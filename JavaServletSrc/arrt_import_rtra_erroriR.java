// * --- Area Manuale = BO - Header
// * --- arrt_import_rtra_errori
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
public class arrt_import_rtra_erroriR implements CallerWithObjs {
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
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_log_app;
  public String m_cServer_log_app;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbcittna;
  public String m_cServer_tbcittna;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tbstatna;
  public String m_cServer_tbstatna;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_jperazbo;
  public String m_cServer_jperazbo;
  public String m_cPhName_tmp_listafile;
  public String m_cServer_tmp_listafile;
  public String m_cPhName_inter2bo;
  public String m_cServer_inter2bo;
  public String m_cPhName_cpwarn;
  public String m_cServer_cpwarn;
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
  public String w_tipodest;
  public String _dirfiles;
  public double conta;
  public String _trxdate;
  public String fhand;
  public String ihand;
  public String dhand;
  public double dFile;
  public String dNomeFile;
  public String iNomeFile;
  public String riga;
  public String _codrap;
  public String _luonas;
  public double nProg;
  public String cProg;
  public String nomefileimport;
  public String xConnes;
  public String _tdest;
  public double _pos;
  public double _npos;
  public String _tipoop;
  public String _coddip;
  public String _uniquecode;
  public java.sql.Date _datope;
  public java.sql.Date _datmod;
  public java.sql.Date _datreal;
  public java.sql.Date _datreg;
  public String _impstr;
  public double _importo;
  public double _contanti;
  public String _flgcash;
  public String _statodest;
  public String _isodest;
  public String _cognome;
  public String _nome;
  public String _citta;
  public String _cap;
  public String _via;
  public String _paese;
  public String _prov;
  public String _cab;
  public String _cognomecp;
  public String _nomecp;
  public String _pep;
  public String _sesso;
  public String _nascitta;
  public String _nasstato;
  public String _resstato;
  public String _nasprov;
  public java.sql.Date _nasdata;
  public String _tipodoc;
  public String _numdoc;
  public java.sql.Date _docril;
  public String _autril;
  public java.sql.Date _docsca;
  public String _codfis;
  public String _connes;
  public String cOpeProg1;
  public String cOpeProg2;
  public double nProgImp;
  public String xSesso;
  public String xCAB;
  public String xDIP;
  public String xDIPx;
  public String cCli1;
  public String xIDB;
  public String xData;
  public String xDatF;
  public String _flgbanca;
  public double cNumNew;
  public double cNumMod;
  public double cNumInv;
  public double _esito;
  public String _idbase;
  public String _intercod;
  public String _intercit;
  public String _intercab;
  public String _interprv;
  public String _doctype;
  public String _codana;
  public String _codsin;
  public String _segno;
  public String _uifdest;
  public String cProgSto;
  public String _prog;
  public double _nocf;
  public String _condoc;
  public String _idfile;
  public String _mage;
  public String _oldcodfis;
  public String _ocodfis;
  public java.sql.Timestamp _dtimport;
  public String _txtope;
  public double _errore;
  public double _nerrori;
  public double eProg;
  public String _codstanas;
  public String _codstares;
  public String _siglacit;
  public String _siglasta;
  public String _codcit;
  public String _merr;
  public String _oldmac;
  public double _aggcli;
  public String _tiperr;
  public String _intertip;
  public String _listerr;
  public String _tipope;
  public String _rapporto;
  public String _priga;
  public String w_codmage;
  public String stringaflagrap2;
  public String _oldidb;
  public String _flagrap2;
  public String _idreg;
  public String _idb2;
  public String _citdip;
  public String _cabdip;
  public String _provdip;
  public double _id;
  public String _filename;
  public String _dipid;
  public String _nfile;
  public String _filen;
  public double _nerrage;
  public double _errage;
  public MemoryCursor_mcerratedef_mcrdef mcErrate;
  public MemoryCursorRow_mcerratedef_mcrdef rowErrate;
  public MemoryCursor_mcerratedef_mcrdef mcErrAge;
  public MemoryCursor_mcerratedef_mcrdef mcAgeDuo;
  public MemoryCursor_mcerratedef_mcrdef mcAgenzie;
  public MemoryCursorRow_mcerratedef_mcrdef rowAgenzie;
  public double _contage;
  public String _anno;
  public double _errorig;
  public String _ageerr01;
  public String _ageerr02;
  public String _ageerr03;
  public String _ageerr04;
  public String _ageerr05;
  public String _ageerr06;
  public String _ageerr07;
  public String _ageerr08;
  public String _ageerr09;
  public String _ageerr10;
  public String _ageerr11;
  public String _ageerr12;
  public String _ageerr13;
  public String _colonna01;
  public String _colonna02;
  public String _colonna03;
  public String _colonna04;
  public String _colonna05;
  public String _colonna06;
  public String _colonna07;
  public String _colonna08;
  public String _colonna09;
  public String _colonna10;
  public String _colonna11;
  public String _colonna12;
  public String _colonna13;
  public String _flgact;
  public String _ndg;
  public String _valuta;
  public String _valiso;
  public String _cittaben;
  public String _viaben;
  public String _cabben;
  public String _capben;
  public String _prvben;
  public String _agente;
  public String w_destfin;
  public String _tipintcon;
  public String _desintcon;
  public String _nazintcon;
  public String _cabintcon;
  public String _prvintcon;
  public String _abichk;
  public double _cambio;
  public double riga_letta;
  public double foglio;
  public String _abicab;
  public String _conto;
  public double _impin;
  public double _impout;
  public String _codsae;
  public String _setsint;
  public java.sql.Date _data;
  public String w_CODFISC;
  public java.sql.Date w_DATANASC;
  public String w_NASCOMUN;
  public String w_NASSTATO;
  public String w_COGNOME;
  public String w_RAGSOC;
  public String w_NOME;
  public String w_SESSO;
  public String _err01;
  public String _err02;
  public String _err03;
  public String _err04;
  public String _err05;
  public String _err06;
  public String _err07;
  public String _err08;
  public String _err09;
  public String _err10;
  public String _err11;
  public String _err12;
  public String _err13;
  public String _err14;
  public String _err15;
  public String _err16;
  public String _err17;
  public String _err18;
  public String _err19;
  public String _err20;
  public String _err21;
  public String _err22;
  public String _err23;
  public String _err24;
  public String _err25;
  public String _err26;
  public String _err27;
  public String _err28;
  public String _err29;
  public String _err30;
  public String _err31;
  public String _err32;
  public String _err33;
  public String _err34;
  public String _err35;
  public String _err36;
  public String _err37;
  public String _err38;
  public String _err39;
  public String _err40;
  public String _err41;
  public String _err42;
  public String _err43;
  public String _err44;
  public String _err45;
  public String _err46;
  public String _err47;
  public String _err48;
  public String _err49;
  public String _err50;
  public String gPathApp;
  public String gAzienda;
  public String gMsgProc;
  public String gMsgImp;
  public String gUrlApp;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_import_rtra_errori
  public int _i;
  public int _y;
  public int _righe;
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
  public String[] colonna;
  public InputStream ExcelFileToRead;
  // * --- Fine Area Manuale
  public arrt_import_rtra_erroriR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_import_rtra_errori",m_Caller);
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_log_app = p_ContextObject.GetPhName("log_app");
    if (m_cPhName_log_app.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_log_app = m_cPhName_log_app+" "+m_Ctx.GetWritePhName("log_app");
    }
    m_cServer_log_app = p_ContextObject.GetServer("log_app");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
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
    m_cPhName_tbcauana = p_ContextObject.GetPhName("tbcauana");
    if (m_cPhName_tbcauana.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcauana = m_cPhName_tbcauana+" "+m_Ctx.GetWritePhName("tbcauana");
    }
    m_cServer_tbcauana = p_ContextObject.GetServer("tbcauana");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tbcittna = p_ContextObject.GetPhName("tbcittna");
    if (m_cPhName_tbcittna.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcittna = m_cPhName_tbcittna+" "+m_Ctx.GetWritePhName("tbcittna");
    }
    m_cServer_tbcittna = p_ContextObject.GetServer("tbcittna");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_tbstatna = p_ContextObject.GetPhName("tbstatna");
    if (m_cPhName_tbstatna.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstatna = m_cPhName_tbstatna+" "+m_Ctx.GetWritePhName("tbstatna");
    }
    m_cServer_tbstatna = p_ContextObject.GetServer("tbstatna");
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    if (m_cPhName_tbvalute.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbvalute = m_cPhName_tbvalute+" "+m_Ctx.GetWritePhName("tbvalute");
    }
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_xraziobo = p_ContextObject.GetPhName("xraziobo");
    if (m_cPhName_xraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xraziobo = m_cPhName_xraziobo+" "+m_Ctx.GetWritePhName("xraziobo");
    }
    m_cServer_xraziobo = p_ContextObject.GetServer("xraziobo");
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    if (m_cPhName_xperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo = m_cPhName_xperazbo+" "+m_Ctx.GetWritePhName("xperazbo");
    }
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_jperazbo = p_ContextObject.GetPhName("jperazbo");
    if (m_cPhName_jperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jperazbo = m_cPhName_jperazbo+" "+m_Ctx.GetWritePhName("jperazbo");
    }
    m_cServer_jperazbo = p_ContextObject.GetServer("jperazbo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
      m_cPhName_tmp_listafile = p_ContextObject.GetPhName("tmp_listafile");
      if (m_cPhName_tmp_listafile.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_listafile = m_cPhName_tmp_listafile+" "+m_Ctx.GetWritePhName("tmp_listafile");
      }
      m_cServer_tmp_listafile = p_ContextObject.GetServer("tmp_listafile");
    }
    m_cPhName_inter2bo = p_ContextObject.GetPhName("inter2bo");
    if (m_cPhName_inter2bo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_inter2bo = m_cPhName_inter2bo+" "+m_Ctx.GetWritePhName("inter2bo");
    }
    m_cServer_inter2bo = p_ContextObject.GetServer("inter2bo");
    m_cPhName_cpwarn = p_ContextObject.GetPhName("cpwarn");
    if (m_cPhName_cpwarn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpwarn = m_cPhName_cpwarn+" "+m_Ctx.GetWritePhName("cpwarn");
    }
    m_cServer_cpwarn = p_ContextObject.GetServer("cpwarn");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("dFile",p_cVarName)) {
      return dFile;
    }
    if (CPLib.eqr("nProg",p_cVarName)) {
      return nProg;
    }
    if (CPLib.eqr("_pos",p_cVarName)) {
      return _pos;
    }
    if (CPLib.eqr("_npos",p_cVarName)) {
      return _npos;
    }
    if (CPLib.eqr("_importo",p_cVarName)) {
      return _importo;
    }
    if (CPLib.eqr("_contanti",p_cVarName)) {
      return _contanti;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      return cNumNew;
    }
    if (CPLib.eqr("cNumMod",p_cVarName)) {
      return cNumMod;
    }
    if (CPLib.eqr("cNumInv",p_cVarName)) {
      return cNumInv;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    if (CPLib.eqr("_nocf",p_cVarName)) {
      return _nocf;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
    }
    if (CPLib.eqr("_nerrori",p_cVarName)) {
      return _nerrori;
    }
    if (CPLib.eqr("eProg",p_cVarName)) {
      return eProg;
    }
    if (CPLib.eqr("_aggcli",p_cVarName)) {
      return _aggcli;
    }
    if (CPLib.eqr("_id",p_cVarName)) {
      return _id;
    }
    if (CPLib.eqr("_nerrage",p_cVarName)) {
      return _nerrage;
    }
    if (CPLib.eqr("_errage",p_cVarName)) {
      return _errage;
    }
    if (CPLib.eqr("_contage",p_cVarName)) {
      return _contage;
    }
    if (CPLib.eqr("_errorig",p_cVarName)) {
      return _errorig;
    }
    if (CPLib.eqr("_cambio",p_cVarName)) {
      return _cambio;
    }
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      return riga_letta;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      return foglio;
    }
    if (CPLib.eqr("_impin",p_cVarName)) {
      return _impin;
    }
    if (CPLib.eqr("_impout",p_cVarName)) {
      return _impout;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_import_rtra_errori";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("tipodest",p_cVarName)) {
      return w_tipodest;
    }
    if (CPLib.eqr("_dirfiles",p_cVarName)) {
      return _dirfiles;
    }
    if (CPLib.eqr("_trxdate",p_cVarName)) {
      return _trxdate;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("ihand",p_cVarName)) {
      return ihand;
    }
    if (CPLib.eqr("dhand",p_cVarName)) {
      return dhand;
    }
    if (CPLib.eqr("dNomeFile",p_cVarName)) {
      return dNomeFile;
    }
    if (CPLib.eqr("iNomeFile",p_cVarName)) {
      return iNomeFile;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("_codrap",p_cVarName)) {
      return _codrap;
    }
    if (CPLib.eqr("_luonas",p_cVarName)) {
      return _luonas;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      return nomefileimport;
    }
    if (CPLib.eqr("xConnes",p_cVarName)) {
      return xConnes;
    }
    if (CPLib.eqr("_tdest",p_cVarName)) {
      return _tdest;
    }
    if (CPLib.eqr("_tipoop",p_cVarName)) {
      return _tipoop;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      return _coddip;
    }
    if (CPLib.eqr("_uniquecode",p_cVarName)) {
      return _uniquecode;
    }
    if (CPLib.eqr("_impstr",p_cVarName)) {
      return _impstr;
    }
    if (CPLib.eqr("_flgcash",p_cVarName)) {
      return _flgcash;
    }
    if (CPLib.eqr("_statodest",p_cVarName)) {
      return _statodest;
    }
    if (CPLib.eqr("_isodest",p_cVarName)) {
      return _isodest;
    }
    if (CPLib.eqr("_cognome",p_cVarName)) {
      return _cognome;
    }
    if (CPLib.eqr("_nome",p_cVarName)) {
      return _nome;
    }
    if (CPLib.eqr("_citta",p_cVarName)) {
      return _citta;
    }
    if (CPLib.eqr("_cap",p_cVarName)) {
      return _cap;
    }
    if (CPLib.eqr("_via",p_cVarName)) {
      return _via;
    }
    if (CPLib.eqr("_paese",p_cVarName)) {
      return _paese;
    }
    if (CPLib.eqr("_prov",p_cVarName)) {
      return _prov;
    }
    if (CPLib.eqr("_cab",p_cVarName)) {
      return _cab;
    }
    if (CPLib.eqr("_cognomecp",p_cVarName)) {
      return _cognomecp;
    }
    if (CPLib.eqr("_nomecp",p_cVarName)) {
      return _nomecp;
    }
    if (CPLib.eqr("_pep",p_cVarName)) {
      return _pep;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      return _sesso;
    }
    if (CPLib.eqr("_nascitta",p_cVarName)) {
      return _nascitta;
    }
    if (CPLib.eqr("_nasstato",p_cVarName)) {
      return _nasstato;
    }
    if (CPLib.eqr("_resstato",p_cVarName)) {
      return _resstato;
    }
    if (CPLib.eqr("_nasprov",p_cVarName)) {
      return _nasprov;
    }
    if (CPLib.eqr("_tipodoc",p_cVarName)) {
      return _tipodoc;
    }
    if (CPLib.eqr("_numdoc",p_cVarName)) {
      return _numdoc;
    }
    if (CPLib.eqr("_autril",p_cVarName)) {
      return _autril;
    }
    if (CPLib.eqr("_codfis",p_cVarName)) {
      return _codfis;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
    }
    if (CPLib.eqr("cOpeProg1",p_cVarName)) {
      return cOpeProg1;
    }
    if (CPLib.eqr("cOpeProg2",p_cVarName)) {
      return cOpeProg2;
    }
    if (CPLib.eqr("xSesso",p_cVarName)) {
      return xSesso;
    }
    if (CPLib.eqr("xCAB",p_cVarName)) {
      return xCAB;
    }
    if (CPLib.eqr("xDIP",p_cVarName)) {
      return xDIP;
    }
    if (CPLib.eqr("xDIPx",p_cVarName)) {
      return xDIPx;
    }
    if (CPLib.eqr("cCli1",p_cVarName)) {
      return cCli1;
    }
    if (CPLib.eqr("xIDB",p_cVarName)) {
      return xIDB;
    }
    if (CPLib.eqr("xData",p_cVarName)) {
      return xData;
    }
    if (CPLib.eqr("xDatF",p_cVarName)) {
      return xDatF;
    }
    if (CPLib.eqr("_flgbanca",p_cVarName)) {
      return _flgbanca;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      return _idbase;
    }
    if (CPLib.eqr("_intercod",p_cVarName)) {
      return _intercod;
    }
    if (CPLib.eqr("_intercit",p_cVarName)) {
      return _intercit;
    }
    if (CPLib.eqr("_intercab",p_cVarName)) {
      return _intercab;
    }
    if (CPLib.eqr("_interprv",p_cVarName)) {
      return _interprv;
    }
    if (CPLib.eqr("_doctype",p_cVarName)) {
      return _doctype;
    }
    if (CPLib.eqr("_codana",p_cVarName)) {
      return _codana;
    }
    if (CPLib.eqr("_codsin",p_cVarName)) {
      return _codsin;
    }
    if (CPLib.eqr("_segno",p_cVarName)) {
      return _segno;
    }
    if (CPLib.eqr("_uifdest",p_cVarName)) {
      return _uifdest;
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      return cProgSto;
    }
    if (CPLib.eqr("_prog",p_cVarName)) {
      return _prog;
    }
    if (CPLib.eqr("_condoc",p_cVarName)) {
      return _condoc;
    }
    if (CPLib.eqr("_idfile",p_cVarName)) {
      return _idfile;
    }
    if (CPLib.eqr("_mage",p_cVarName)) {
      return _mage;
    }
    if (CPLib.eqr("_oldcodfis",p_cVarName)) {
      return _oldcodfis;
    }
    if (CPLib.eqr("_ocodfis",p_cVarName)) {
      return _ocodfis;
    }
    if (CPLib.eqr("_txtope",p_cVarName)) {
      return _txtope;
    }
    if (CPLib.eqr("_codstanas",p_cVarName)) {
      return _codstanas;
    }
    if (CPLib.eqr("_codstares",p_cVarName)) {
      return _codstares;
    }
    if (CPLib.eqr("_siglacit",p_cVarName)) {
      return _siglacit;
    }
    if (CPLib.eqr("_siglasta",p_cVarName)) {
      return _siglasta;
    }
    if (CPLib.eqr("_codcit",p_cVarName)) {
      return _codcit;
    }
    if (CPLib.eqr("_merr",p_cVarName)) {
      return _merr;
    }
    if (CPLib.eqr("_oldmac",p_cVarName)) {
      return _oldmac;
    }
    if (CPLib.eqr("_tiperr",p_cVarName)) {
      return _tiperr;
    }
    if (CPLib.eqr("_intertip",p_cVarName)) {
      return _intertip;
    }
    if (CPLib.eqr("_listerr",p_cVarName)) {
      return _listerr;
    }
    if (CPLib.eqr("_tipope",p_cVarName)) {
      return _tipope;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_priga",p_cVarName)) {
      return _priga;
    }
    if (CPLib.eqr("codmage",p_cVarName)) {
      return w_codmage;
    }
    if (CPLib.eqr("stringaflagrap2",p_cVarName)) {
      return stringaflagrap2;
    }
    if (CPLib.eqr("_oldidb",p_cVarName)) {
      return _oldidb;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      return _flagrap2;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      return _idreg;
    }
    if (CPLib.eqr("_idb2",p_cVarName)) {
      return _idb2;
    }
    if (CPLib.eqr("_citdip",p_cVarName)) {
      return _citdip;
    }
    if (CPLib.eqr("_cabdip",p_cVarName)) {
      return _cabdip;
    }
    if (CPLib.eqr("_provdip",p_cVarName)) {
      return _provdip;
    }
    if (CPLib.eqr("_filename",p_cVarName)) {
      return _filename;
    }
    if (CPLib.eqr("_dipid",p_cVarName)) {
      return _dipid;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      return _nfile;
    }
    if (CPLib.eqr("_filen",p_cVarName)) {
      return _filen;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      return _anno;
    }
    if (CPLib.eqr("_ageerr01",p_cVarName)) {
      return _ageerr01;
    }
    if (CPLib.eqr("_ageerr02",p_cVarName)) {
      return _ageerr02;
    }
    if (CPLib.eqr("_ageerr03",p_cVarName)) {
      return _ageerr03;
    }
    if (CPLib.eqr("_ageerr04",p_cVarName)) {
      return _ageerr04;
    }
    if (CPLib.eqr("_ageerr05",p_cVarName)) {
      return _ageerr05;
    }
    if (CPLib.eqr("_ageerr06",p_cVarName)) {
      return _ageerr06;
    }
    if (CPLib.eqr("_ageerr07",p_cVarName)) {
      return _ageerr07;
    }
    if (CPLib.eqr("_ageerr08",p_cVarName)) {
      return _ageerr08;
    }
    if (CPLib.eqr("_ageerr09",p_cVarName)) {
      return _ageerr09;
    }
    if (CPLib.eqr("_ageerr10",p_cVarName)) {
      return _ageerr10;
    }
    if (CPLib.eqr("_ageerr11",p_cVarName)) {
      return _ageerr11;
    }
    if (CPLib.eqr("_ageerr12",p_cVarName)) {
      return _ageerr12;
    }
    if (CPLib.eqr("_ageerr13",p_cVarName)) {
      return _ageerr13;
    }
    if (CPLib.eqr("_colonna01",p_cVarName)) {
      return _colonna01;
    }
    if (CPLib.eqr("_colonna02",p_cVarName)) {
      return _colonna02;
    }
    if (CPLib.eqr("_colonna03",p_cVarName)) {
      return _colonna03;
    }
    if (CPLib.eqr("_colonna04",p_cVarName)) {
      return _colonna04;
    }
    if (CPLib.eqr("_colonna05",p_cVarName)) {
      return _colonna05;
    }
    if (CPLib.eqr("_colonna06",p_cVarName)) {
      return _colonna06;
    }
    if (CPLib.eqr("_colonna07",p_cVarName)) {
      return _colonna07;
    }
    if (CPLib.eqr("_colonna08",p_cVarName)) {
      return _colonna08;
    }
    if (CPLib.eqr("_colonna09",p_cVarName)) {
      return _colonna09;
    }
    if (CPLib.eqr("_colonna10",p_cVarName)) {
      return _colonna10;
    }
    if (CPLib.eqr("_colonna11",p_cVarName)) {
      return _colonna11;
    }
    if (CPLib.eqr("_colonna12",p_cVarName)) {
      return _colonna12;
    }
    if (CPLib.eqr("_colonna13",p_cVarName)) {
      return _colonna13;
    }
    if (CPLib.eqr("_flgact",p_cVarName)) {
      return _flgact;
    }
    if (CPLib.eqr("_ndg",p_cVarName)) {
      return _ndg;
    }
    if (CPLib.eqr("_valuta",p_cVarName)) {
      return _valuta;
    }
    if (CPLib.eqr("_valiso",p_cVarName)) {
      return _valiso;
    }
    if (CPLib.eqr("_cittaben",p_cVarName)) {
      return _cittaben;
    }
    if (CPLib.eqr("_viaben",p_cVarName)) {
      return _viaben;
    }
    if (CPLib.eqr("_cabben",p_cVarName)) {
      return _cabben;
    }
    if (CPLib.eqr("_capben",p_cVarName)) {
      return _capben;
    }
    if (CPLib.eqr("_prvben",p_cVarName)) {
      return _prvben;
    }
    if (CPLib.eqr("_agente",p_cVarName)) {
      return _agente;
    }
    if (CPLib.eqr("destfin",p_cVarName)) {
      return w_destfin;
    }
    if (CPLib.eqr("_tipintcon",p_cVarName)) {
      return _tipintcon;
    }
    if (CPLib.eqr("_desintcon",p_cVarName)) {
      return _desintcon;
    }
    if (CPLib.eqr("_nazintcon",p_cVarName)) {
      return _nazintcon;
    }
    if (CPLib.eqr("_cabintcon",p_cVarName)) {
      return _cabintcon;
    }
    if (CPLib.eqr("_prvintcon",p_cVarName)) {
      return _prvintcon;
    }
    if (CPLib.eqr("_abichk",p_cVarName)) {
      return _abichk;
    }
    if (CPLib.eqr("_abicab",p_cVarName)) {
      return _abicab;
    }
    if (CPLib.eqr("_conto",p_cVarName)) {
      return _conto;
    }
    if (CPLib.eqr("_codsae",p_cVarName)) {
      return _codsae;
    }
    if (CPLib.eqr("_setsint",p_cVarName)) {
      return _setsint;
    }
    if (CPLib.eqr("CODFISC",p_cVarName)) {
      return w_CODFISC;
    }
    if (CPLib.eqr("NASCOMUN",p_cVarName)) {
      return w_NASCOMUN;
    }
    if (CPLib.eqr("NASSTATO",p_cVarName)) {
      return w_NASSTATO;
    }
    if (CPLib.eqr("COGNOME",p_cVarName)) {
      return w_COGNOME;
    }
    if (CPLib.eqr("RAGSOC",p_cVarName)) {
      return w_RAGSOC;
    }
    if (CPLib.eqr("NOME",p_cVarName)) {
      return w_NOME;
    }
    if (CPLib.eqr("SESSO",p_cVarName)) {
      return w_SESSO;
    }
    if (CPLib.eqr("_err01",p_cVarName)) {
      return _err01;
    }
    if (CPLib.eqr("_err02",p_cVarName)) {
      return _err02;
    }
    if (CPLib.eqr("_err03",p_cVarName)) {
      return _err03;
    }
    if (CPLib.eqr("_err04",p_cVarName)) {
      return _err04;
    }
    if (CPLib.eqr("_err05",p_cVarName)) {
      return _err05;
    }
    if (CPLib.eqr("_err06",p_cVarName)) {
      return _err06;
    }
    if (CPLib.eqr("_err07",p_cVarName)) {
      return _err07;
    }
    if (CPLib.eqr("_err08",p_cVarName)) {
      return _err08;
    }
    if (CPLib.eqr("_err09",p_cVarName)) {
      return _err09;
    }
    if (CPLib.eqr("_err10",p_cVarName)) {
      return _err10;
    }
    if (CPLib.eqr("_err11",p_cVarName)) {
      return _err11;
    }
    if (CPLib.eqr("_err12",p_cVarName)) {
      return _err12;
    }
    if (CPLib.eqr("_err13",p_cVarName)) {
      return _err13;
    }
    if (CPLib.eqr("_err14",p_cVarName)) {
      return _err14;
    }
    if (CPLib.eqr("_err15",p_cVarName)) {
      return _err15;
    }
    if (CPLib.eqr("_err16",p_cVarName)) {
      return _err16;
    }
    if (CPLib.eqr("_err17",p_cVarName)) {
      return _err17;
    }
    if (CPLib.eqr("_err18",p_cVarName)) {
      return _err18;
    }
    if (CPLib.eqr("_err19",p_cVarName)) {
      return _err19;
    }
    if (CPLib.eqr("_err20",p_cVarName)) {
      return _err20;
    }
    if (CPLib.eqr("_err21",p_cVarName)) {
      return _err21;
    }
    if (CPLib.eqr("_err22",p_cVarName)) {
      return _err22;
    }
    if (CPLib.eqr("_err23",p_cVarName)) {
      return _err23;
    }
    if (CPLib.eqr("_err24",p_cVarName)) {
      return _err24;
    }
    if (CPLib.eqr("_err25",p_cVarName)) {
      return _err25;
    }
    if (CPLib.eqr("_err26",p_cVarName)) {
      return _err26;
    }
    if (CPLib.eqr("_err27",p_cVarName)) {
      return _err27;
    }
    if (CPLib.eqr("_err28",p_cVarName)) {
      return _err28;
    }
    if (CPLib.eqr("_err29",p_cVarName)) {
      return _err29;
    }
    if (CPLib.eqr("_err30",p_cVarName)) {
      return _err30;
    }
    if (CPLib.eqr("_err31",p_cVarName)) {
      return _err31;
    }
    if (CPLib.eqr("_err32",p_cVarName)) {
      return _err32;
    }
    if (CPLib.eqr("_err33",p_cVarName)) {
      return _err33;
    }
    if (CPLib.eqr("_err34",p_cVarName)) {
      return _err34;
    }
    if (CPLib.eqr("_err35",p_cVarName)) {
      return _err35;
    }
    if (CPLib.eqr("_err36",p_cVarName)) {
      return _err36;
    }
    if (CPLib.eqr("_err37",p_cVarName)) {
      return _err37;
    }
    if (CPLib.eqr("_err38",p_cVarName)) {
      return _err38;
    }
    if (CPLib.eqr("_err39",p_cVarName)) {
      return _err39;
    }
    if (CPLib.eqr("_err40",p_cVarName)) {
      return _err40;
    }
    if (CPLib.eqr("_err41",p_cVarName)) {
      return _err41;
    }
    if (CPLib.eqr("_err42",p_cVarName)) {
      return _err42;
    }
    if (CPLib.eqr("_err43",p_cVarName)) {
      return _err43;
    }
    if (CPLib.eqr("_err44",p_cVarName)) {
      return _err44;
    }
    if (CPLib.eqr("_err45",p_cVarName)) {
      return _err45;
    }
    if (CPLib.eqr("_err46",p_cVarName)) {
      return _err46;
    }
    if (CPLib.eqr("_err47",p_cVarName)) {
      return _err47;
    }
    if (CPLib.eqr("_err48",p_cVarName)) {
      return _err48;
    }
    if (CPLib.eqr("_err49",p_cVarName)) {
      return _err49;
    }
    if (CPLib.eqr("_err50",p_cVarName)) {
      return _err50;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_datope",p_cVarName)) {
      return _datope;
    }
    if (CPLib.eqr("_datmod",p_cVarName)) {
      return _datmod;
    }
    if (CPLib.eqr("_datreal",p_cVarName)) {
      return _datreal;
    }
    if (CPLib.eqr("_datreg",p_cVarName)) {
      return _datreg;
    }
    if (CPLib.eqr("_nasdata",p_cVarName)) {
      return _nasdata;
    }
    if (CPLib.eqr("_docril",p_cVarName)) {
      return _docril;
    }
    if (CPLib.eqr("_docsca",p_cVarName)) {
      return _docsca;
    }
    if (CPLib.eqr("_data",p_cVarName)) {
      return _data;
    }
    if (CPLib.eqr("DATANASC",p_cVarName)) {
      return w_DATANASC;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_dtimport",p_cVarName)) {
      return _dtimport;
    }
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcErrate",p_cVarName)) {
      return mcErrate;
    }
    if (CPLib.eqr("mcErrAge",p_cVarName)) {
      return mcErrAge;
    }
    if (CPLib.eqr("mcAgeDuo",p_cVarName)) {
      return mcAgeDuo;
    }
    if (CPLib.eqr("mcAgenzie",p_cVarName)) {
      return mcAgenzie;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowErrate",p_cVarName)) {
      return rowErrate;
    }
    if (CPLib.eqr("rowAgenzie",p_cVarName)) {
      return rowAgenzie;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("dFile",p_cVarName)) {
      dFile = value;
      return;
    }
    if (CPLib.eqr("nProg",p_cVarName)) {
      nProg = value;
      return;
    }
    if (CPLib.eqr("_pos",p_cVarName)) {
      _pos = value;
      return;
    }
    if (CPLib.eqr("_npos",p_cVarName)) {
      _npos = value;
      return;
    }
    if (CPLib.eqr("_importo",p_cVarName)) {
      _importo = value;
      return;
    }
    if (CPLib.eqr("_contanti",p_cVarName)) {
      _contanti = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      cNumNew = value;
      return;
    }
    if (CPLib.eqr("cNumMod",p_cVarName)) {
      cNumMod = value;
      return;
    }
    if (CPLib.eqr("cNumInv",p_cVarName)) {
      cNumInv = value;
      return;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
    if (CPLib.eqr("_nocf",p_cVarName)) {
      _nocf = value;
      return;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      _errore = value;
      return;
    }
    if (CPLib.eqr("_nerrori",p_cVarName)) {
      _nerrori = value;
      return;
    }
    if (CPLib.eqr("eProg",p_cVarName)) {
      eProg = value;
      return;
    }
    if (CPLib.eqr("_aggcli",p_cVarName)) {
      _aggcli = value;
      return;
    }
    if (CPLib.eqr("_id",p_cVarName)) {
      _id = value;
      return;
    }
    if (CPLib.eqr("_nerrage",p_cVarName)) {
      _nerrage = value;
      return;
    }
    if (CPLib.eqr("_errage",p_cVarName)) {
      _errage = value;
      return;
    }
    if (CPLib.eqr("_contage",p_cVarName)) {
      _contage = value;
      return;
    }
    if (CPLib.eqr("_errorig",p_cVarName)) {
      _errorig = value;
      return;
    }
    if (CPLib.eqr("_cambio",p_cVarName)) {
      _cambio = value;
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
    if (CPLib.eqr("_impin",p_cVarName)) {
      _impin = value;
      return;
    }
    if (CPLib.eqr("_impout",p_cVarName)) {
      _impout = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tipodest",p_cVarName)) {
      w_tipodest = value;
      return;
    }
    if (CPLib.eqr("_dirfiles",p_cVarName)) {
      _dirfiles = value;
      return;
    }
    if (CPLib.eqr("_trxdate",p_cVarName)) {
      _trxdate = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("ihand",p_cVarName)) {
      ihand = value;
      return;
    }
    if (CPLib.eqr("dhand",p_cVarName)) {
      dhand = value;
      return;
    }
    if (CPLib.eqr("dNomeFile",p_cVarName)) {
      dNomeFile = value;
      return;
    }
    if (CPLib.eqr("iNomeFile",p_cVarName)) {
      iNomeFile = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("_codrap",p_cVarName)) {
      _codrap = value;
      return;
    }
    if (CPLib.eqr("_luonas",p_cVarName)) {
      _luonas = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      nomefileimport = value;
      return;
    }
    if (CPLib.eqr("xConnes",p_cVarName)) {
      xConnes = value;
      return;
    }
    if (CPLib.eqr("_tdest",p_cVarName)) {
      _tdest = value;
      return;
    }
    if (CPLib.eqr("_tipoop",p_cVarName)) {
      _tipoop = value;
      return;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      _coddip = value;
      return;
    }
    if (CPLib.eqr("_uniquecode",p_cVarName)) {
      _uniquecode = value;
      return;
    }
    if (CPLib.eqr("_impstr",p_cVarName)) {
      _impstr = value;
      return;
    }
    if (CPLib.eqr("_flgcash",p_cVarName)) {
      _flgcash = value;
      return;
    }
    if (CPLib.eqr("_statodest",p_cVarName)) {
      _statodest = value;
      return;
    }
    if (CPLib.eqr("_isodest",p_cVarName)) {
      _isodest = value;
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
    if (CPLib.eqr("_citta",p_cVarName)) {
      _citta = value;
      return;
    }
    if (CPLib.eqr("_cap",p_cVarName)) {
      _cap = value;
      return;
    }
    if (CPLib.eqr("_via",p_cVarName)) {
      _via = value;
      return;
    }
    if (CPLib.eqr("_paese",p_cVarName)) {
      _paese = value;
      return;
    }
    if (CPLib.eqr("_prov",p_cVarName)) {
      _prov = value;
      return;
    }
    if (CPLib.eqr("_cab",p_cVarName)) {
      _cab = value;
      return;
    }
    if (CPLib.eqr("_cognomecp",p_cVarName)) {
      _cognomecp = value;
      return;
    }
    if (CPLib.eqr("_nomecp",p_cVarName)) {
      _nomecp = value;
      return;
    }
    if (CPLib.eqr("_pep",p_cVarName)) {
      _pep = value;
      return;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      _sesso = value;
      return;
    }
    if (CPLib.eqr("_nascitta",p_cVarName)) {
      _nascitta = value;
      return;
    }
    if (CPLib.eqr("_nasstato",p_cVarName)) {
      _nasstato = value;
      return;
    }
    if (CPLib.eqr("_resstato",p_cVarName)) {
      _resstato = value;
      return;
    }
    if (CPLib.eqr("_nasprov",p_cVarName)) {
      _nasprov = value;
      return;
    }
    if (CPLib.eqr("_tipodoc",p_cVarName)) {
      _tipodoc = value;
      return;
    }
    if (CPLib.eqr("_numdoc",p_cVarName)) {
      _numdoc = value;
      return;
    }
    if (CPLib.eqr("_autril",p_cVarName)) {
      _autril = value;
      return;
    }
    if (CPLib.eqr("_codfis",p_cVarName)) {
      _codfis = value;
      return;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      _connes = value;
      return;
    }
    if (CPLib.eqr("cOpeProg1",p_cVarName)) {
      cOpeProg1 = value;
      return;
    }
    if (CPLib.eqr("cOpeProg2",p_cVarName)) {
      cOpeProg2 = value;
      return;
    }
    if (CPLib.eqr("xSesso",p_cVarName)) {
      xSesso = value;
      return;
    }
    if (CPLib.eqr("xCAB",p_cVarName)) {
      xCAB = value;
      return;
    }
    if (CPLib.eqr("xDIP",p_cVarName)) {
      xDIP = value;
      return;
    }
    if (CPLib.eqr("xDIPx",p_cVarName)) {
      xDIPx = value;
      return;
    }
    if (CPLib.eqr("cCli1",p_cVarName)) {
      cCli1 = value;
      return;
    }
    if (CPLib.eqr("xIDB",p_cVarName)) {
      xIDB = value;
      return;
    }
    if (CPLib.eqr("xData",p_cVarName)) {
      xData = value;
      return;
    }
    if (CPLib.eqr("xDatF",p_cVarName)) {
      xDatF = value;
      return;
    }
    if (CPLib.eqr("_flgbanca",p_cVarName)) {
      _flgbanca = value;
      return;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      _idbase = value;
      return;
    }
    if (CPLib.eqr("_intercod",p_cVarName)) {
      _intercod = value;
      return;
    }
    if (CPLib.eqr("_intercit",p_cVarName)) {
      _intercit = value;
      return;
    }
    if (CPLib.eqr("_intercab",p_cVarName)) {
      _intercab = value;
      return;
    }
    if (CPLib.eqr("_interprv",p_cVarName)) {
      _interprv = value;
      return;
    }
    if (CPLib.eqr("_doctype",p_cVarName)) {
      _doctype = value;
      return;
    }
    if (CPLib.eqr("_codana",p_cVarName)) {
      _codana = value;
      return;
    }
    if (CPLib.eqr("_codsin",p_cVarName)) {
      _codsin = value;
      return;
    }
    if (CPLib.eqr("_segno",p_cVarName)) {
      _segno = value;
      return;
    }
    if (CPLib.eqr("_uifdest",p_cVarName)) {
      _uifdest = value;
      return;
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      cProgSto = value;
      return;
    }
    if (CPLib.eqr("_prog",p_cVarName)) {
      _prog = value;
      return;
    }
    if (CPLib.eqr("_condoc",p_cVarName)) {
      _condoc = value;
      return;
    }
    if (CPLib.eqr("_idfile",p_cVarName)) {
      _idfile = value;
      return;
    }
    if (CPLib.eqr("_mage",p_cVarName)) {
      _mage = value;
      return;
    }
    if (CPLib.eqr("_oldcodfis",p_cVarName)) {
      _oldcodfis = value;
      return;
    }
    if (CPLib.eqr("_ocodfis",p_cVarName)) {
      _ocodfis = value;
      return;
    }
    if (CPLib.eqr("_txtope",p_cVarName)) {
      _txtope = value;
      return;
    }
    if (CPLib.eqr("_codstanas",p_cVarName)) {
      _codstanas = value;
      return;
    }
    if (CPLib.eqr("_codstares",p_cVarName)) {
      _codstares = value;
      return;
    }
    if (CPLib.eqr("_siglacit",p_cVarName)) {
      _siglacit = value;
      return;
    }
    if (CPLib.eqr("_siglasta",p_cVarName)) {
      _siglasta = value;
      return;
    }
    if (CPLib.eqr("_codcit",p_cVarName)) {
      _codcit = value;
      return;
    }
    if (CPLib.eqr("_merr",p_cVarName)) {
      _merr = value;
      return;
    }
    if (CPLib.eqr("_oldmac",p_cVarName)) {
      _oldmac = value;
      return;
    }
    if (CPLib.eqr("_tiperr",p_cVarName)) {
      _tiperr = value;
      return;
    }
    if (CPLib.eqr("_intertip",p_cVarName)) {
      _intertip = value;
      return;
    }
    if (CPLib.eqr("_listerr",p_cVarName)) {
      _listerr = value;
      return;
    }
    if (CPLib.eqr("_tipope",p_cVarName)) {
      _tipope = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("_priga",p_cVarName)) {
      _priga = value;
      return;
    }
    if (CPLib.eqr("codmage",p_cVarName)) {
      w_codmage = value;
      return;
    }
    if (CPLib.eqr("stringaflagrap2",p_cVarName)) {
      stringaflagrap2 = value;
      return;
    }
    if (CPLib.eqr("_oldidb",p_cVarName)) {
      _oldidb = value;
      return;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      _flagrap2 = value;
      return;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      _idreg = value;
      return;
    }
    if (CPLib.eqr("_idb2",p_cVarName)) {
      _idb2 = value;
      return;
    }
    if (CPLib.eqr("_citdip",p_cVarName)) {
      _citdip = value;
      return;
    }
    if (CPLib.eqr("_cabdip",p_cVarName)) {
      _cabdip = value;
      return;
    }
    if (CPLib.eqr("_provdip",p_cVarName)) {
      _provdip = value;
      return;
    }
    if (CPLib.eqr("_filename",p_cVarName)) {
      _filename = value;
      return;
    }
    if (CPLib.eqr("_dipid",p_cVarName)) {
      _dipid = value;
      return;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      _nfile = value;
      return;
    }
    if (CPLib.eqr("_filen",p_cVarName)) {
      _filen = value;
      return;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      _anno = value;
      return;
    }
    if (CPLib.eqr("_ageerr01",p_cVarName)) {
      _ageerr01 = value;
      return;
    }
    if (CPLib.eqr("_ageerr02",p_cVarName)) {
      _ageerr02 = value;
      return;
    }
    if (CPLib.eqr("_ageerr03",p_cVarName)) {
      _ageerr03 = value;
      return;
    }
    if (CPLib.eqr("_ageerr04",p_cVarName)) {
      _ageerr04 = value;
      return;
    }
    if (CPLib.eqr("_ageerr05",p_cVarName)) {
      _ageerr05 = value;
      return;
    }
    if (CPLib.eqr("_ageerr06",p_cVarName)) {
      _ageerr06 = value;
      return;
    }
    if (CPLib.eqr("_ageerr07",p_cVarName)) {
      _ageerr07 = value;
      return;
    }
    if (CPLib.eqr("_ageerr08",p_cVarName)) {
      _ageerr08 = value;
      return;
    }
    if (CPLib.eqr("_ageerr09",p_cVarName)) {
      _ageerr09 = value;
      return;
    }
    if (CPLib.eqr("_ageerr10",p_cVarName)) {
      _ageerr10 = value;
      return;
    }
    if (CPLib.eqr("_ageerr11",p_cVarName)) {
      _ageerr11 = value;
      return;
    }
    if (CPLib.eqr("_ageerr12",p_cVarName)) {
      _ageerr12 = value;
      return;
    }
    if (CPLib.eqr("_ageerr13",p_cVarName)) {
      _ageerr13 = value;
      return;
    }
    if (CPLib.eqr("_colonna01",p_cVarName)) {
      _colonna01 = value;
      return;
    }
    if (CPLib.eqr("_colonna02",p_cVarName)) {
      _colonna02 = value;
      return;
    }
    if (CPLib.eqr("_colonna03",p_cVarName)) {
      _colonna03 = value;
      return;
    }
    if (CPLib.eqr("_colonna04",p_cVarName)) {
      _colonna04 = value;
      return;
    }
    if (CPLib.eqr("_colonna05",p_cVarName)) {
      _colonna05 = value;
      return;
    }
    if (CPLib.eqr("_colonna06",p_cVarName)) {
      _colonna06 = value;
      return;
    }
    if (CPLib.eqr("_colonna07",p_cVarName)) {
      _colonna07 = value;
      return;
    }
    if (CPLib.eqr("_colonna08",p_cVarName)) {
      _colonna08 = value;
      return;
    }
    if (CPLib.eqr("_colonna09",p_cVarName)) {
      _colonna09 = value;
      return;
    }
    if (CPLib.eqr("_colonna10",p_cVarName)) {
      _colonna10 = value;
      return;
    }
    if (CPLib.eqr("_colonna11",p_cVarName)) {
      _colonna11 = value;
      return;
    }
    if (CPLib.eqr("_colonna12",p_cVarName)) {
      _colonna12 = value;
      return;
    }
    if (CPLib.eqr("_colonna13",p_cVarName)) {
      _colonna13 = value;
      return;
    }
    if (CPLib.eqr("_flgact",p_cVarName)) {
      _flgact = value;
      return;
    }
    if (CPLib.eqr("_ndg",p_cVarName)) {
      _ndg = value;
      return;
    }
    if (CPLib.eqr("_valuta",p_cVarName)) {
      _valuta = value;
      return;
    }
    if (CPLib.eqr("_valiso",p_cVarName)) {
      _valiso = value;
      return;
    }
    if (CPLib.eqr("_cittaben",p_cVarName)) {
      _cittaben = value;
      return;
    }
    if (CPLib.eqr("_viaben",p_cVarName)) {
      _viaben = value;
      return;
    }
    if (CPLib.eqr("_cabben",p_cVarName)) {
      _cabben = value;
      return;
    }
    if (CPLib.eqr("_capben",p_cVarName)) {
      _capben = value;
      return;
    }
    if (CPLib.eqr("_prvben",p_cVarName)) {
      _prvben = value;
      return;
    }
    if (CPLib.eqr("_agente",p_cVarName)) {
      _agente = value;
      return;
    }
    if (CPLib.eqr("destfin",p_cVarName)) {
      w_destfin = value;
      return;
    }
    if (CPLib.eqr("_tipintcon",p_cVarName)) {
      _tipintcon = value;
      return;
    }
    if (CPLib.eqr("_desintcon",p_cVarName)) {
      _desintcon = value;
      return;
    }
    if (CPLib.eqr("_nazintcon",p_cVarName)) {
      _nazintcon = value;
      return;
    }
    if (CPLib.eqr("_cabintcon",p_cVarName)) {
      _cabintcon = value;
      return;
    }
    if (CPLib.eqr("_prvintcon",p_cVarName)) {
      _prvintcon = value;
      return;
    }
    if (CPLib.eqr("_abichk",p_cVarName)) {
      _abichk = value;
      return;
    }
    if (CPLib.eqr("_abicab",p_cVarName)) {
      _abicab = value;
      return;
    }
    if (CPLib.eqr("_conto",p_cVarName)) {
      _conto = value;
      return;
    }
    if (CPLib.eqr("_codsae",p_cVarName)) {
      _codsae = value;
      return;
    }
    if (CPLib.eqr("_setsint",p_cVarName)) {
      _setsint = value;
      return;
    }
    if (CPLib.eqr("CODFISC",p_cVarName)) {
      w_CODFISC = value;
      return;
    }
    if (CPLib.eqr("NASCOMUN",p_cVarName)) {
      w_NASCOMUN = value;
      return;
    }
    if (CPLib.eqr("NASSTATO",p_cVarName)) {
      w_NASSTATO = value;
      return;
    }
    if (CPLib.eqr("COGNOME",p_cVarName)) {
      w_COGNOME = value;
      return;
    }
    if (CPLib.eqr("RAGSOC",p_cVarName)) {
      w_RAGSOC = value;
      return;
    }
    if (CPLib.eqr("NOME",p_cVarName)) {
      w_NOME = value;
      return;
    }
    if (CPLib.eqr("SESSO",p_cVarName)) {
      w_SESSO = value;
      return;
    }
    if (CPLib.eqr("_err01",p_cVarName)) {
      _err01 = value;
      return;
    }
    if (CPLib.eqr("_err02",p_cVarName)) {
      _err02 = value;
      return;
    }
    if (CPLib.eqr("_err03",p_cVarName)) {
      _err03 = value;
      return;
    }
    if (CPLib.eqr("_err04",p_cVarName)) {
      _err04 = value;
      return;
    }
    if (CPLib.eqr("_err05",p_cVarName)) {
      _err05 = value;
      return;
    }
    if (CPLib.eqr("_err06",p_cVarName)) {
      _err06 = value;
      return;
    }
    if (CPLib.eqr("_err07",p_cVarName)) {
      _err07 = value;
      return;
    }
    if (CPLib.eqr("_err08",p_cVarName)) {
      _err08 = value;
      return;
    }
    if (CPLib.eqr("_err09",p_cVarName)) {
      _err09 = value;
      return;
    }
    if (CPLib.eqr("_err10",p_cVarName)) {
      _err10 = value;
      return;
    }
    if (CPLib.eqr("_err11",p_cVarName)) {
      _err11 = value;
      return;
    }
    if (CPLib.eqr("_err12",p_cVarName)) {
      _err12 = value;
      return;
    }
    if (CPLib.eqr("_err13",p_cVarName)) {
      _err13 = value;
      return;
    }
    if (CPLib.eqr("_err14",p_cVarName)) {
      _err14 = value;
      return;
    }
    if (CPLib.eqr("_err15",p_cVarName)) {
      _err15 = value;
      return;
    }
    if (CPLib.eqr("_err16",p_cVarName)) {
      _err16 = value;
      return;
    }
    if (CPLib.eqr("_err17",p_cVarName)) {
      _err17 = value;
      return;
    }
    if (CPLib.eqr("_err18",p_cVarName)) {
      _err18 = value;
      return;
    }
    if (CPLib.eqr("_err19",p_cVarName)) {
      _err19 = value;
      return;
    }
    if (CPLib.eqr("_err20",p_cVarName)) {
      _err20 = value;
      return;
    }
    if (CPLib.eqr("_err21",p_cVarName)) {
      _err21 = value;
      return;
    }
    if (CPLib.eqr("_err22",p_cVarName)) {
      _err22 = value;
      return;
    }
    if (CPLib.eqr("_err23",p_cVarName)) {
      _err23 = value;
      return;
    }
    if (CPLib.eqr("_err24",p_cVarName)) {
      _err24 = value;
      return;
    }
    if (CPLib.eqr("_err25",p_cVarName)) {
      _err25 = value;
      return;
    }
    if (CPLib.eqr("_err26",p_cVarName)) {
      _err26 = value;
      return;
    }
    if (CPLib.eqr("_err27",p_cVarName)) {
      _err27 = value;
      return;
    }
    if (CPLib.eqr("_err28",p_cVarName)) {
      _err28 = value;
      return;
    }
    if (CPLib.eqr("_err29",p_cVarName)) {
      _err29 = value;
      return;
    }
    if (CPLib.eqr("_err30",p_cVarName)) {
      _err30 = value;
      return;
    }
    if (CPLib.eqr("_err31",p_cVarName)) {
      _err31 = value;
      return;
    }
    if (CPLib.eqr("_err32",p_cVarName)) {
      _err32 = value;
      return;
    }
    if (CPLib.eqr("_err33",p_cVarName)) {
      _err33 = value;
      return;
    }
    if (CPLib.eqr("_err34",p_cVarName)) {
      _err34 = value;
      return;
    }
    if (CPLib.eqr("_err35",p_cVarName)) {
      _err35 = value;
      return;
    }
    if (CPLib.eqr("_err36",p_cVarName)) {
      _err36 = value;
      return;
    }
    if (CPLib.eqr("_err37",p_cVarName)) {
      _err37 = value;
      return;
    }
    if (CPLib.eqr("_err38",p_cVarName)) {
      _err38 = value;
      return;
    }
    if (CPLib.eqr("_err39",p_cVarName)) {
      _err39 = value;
      return;
    }
    if (CPLib.eqr("_err40",p_cVarName)) {
      _err40 = value;
      return;
    }
    if (CPLib.eqr("_err41",p_cVarName)) {
      _err41 = value;
      return;
    }
    if (CPLib.eqr("_err42",p_cVarName)) {
      _err42 = value;
      return;
    }
    if (CPLib.eqr("_err43",p_cVarName)) {
      _err43 = value;
      return;
    }
    if (CPLib.eqr("_err44",p_cVarName)) {
      _err44 = value;
      return;
    }
    if (CPLib.eqr("_err45",p_cVarName)) {
      _err45 = value;
      return;
    }
    if (CPLib.eqr("_err46",p_cVarName)) {
      _err46 = value;
      return;
    }
    if (CPLib.eqr("_err47",p_cVarName)) {
      _err47 = value;
      return;
    }
    if (CPLib.eqr("_err48",p_cVarName)) {
      _err48 = value;
      return;
    }
    if (CPLib.eqr("_err49",p_cVarName)) {
      _err49 = value;
      return;
    }
    if (CPLib.eqr("_err50",p_cVarName)) {
      _err50 = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_datope",p_cVarName)) {
      _datope = value;
      return;
    }
    if (CPLib.eqr("_datmod",p_cVarName)) {
      _datmod = value;
      return;
    }
    if (CPLib.eqr("_datreal",p_cVarName)) {
      _datreal = value;
      return;
    }
    if (CPLib.eqr("_datreg",p_cVarName)) {
      _datreg = value;
      return;
    }
    if (CPLib.eqr("_nasdata",p_cVarName)) {
      _nasdata = value;
      return;
    }
    if (CPLib.eqr("_docril",p_cVarName)) {
      _docril = value;
      return;
    }
    if (CPLib.eqr("_docsca",p_cVarName)) {
      _docsca = value;
      return;
    }
    if (CPLib.eqr("_data",p_cVarName)) {
      _data = value;
      return;
    }
    if (CPLib.eqr("DATANASC",p_cVarName)) {
      w_DATANASC = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
    if (CPLib.eqr("_dtimport",p_cVarName)) {
      _dtimport = value;
      return;
    }
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowErrate",p_cVarName)) {
      rowErrate = (MemoryCursorRow_mcerratedef_mcrdef)value;
      return;
    }
    if (CPLib.eqr("rowAgenzie",p_cVarName)) {
      rowAgenzie = (MemoryCursorRow_mcerratedef_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcErrate",p_cVarName)) {
      mcErrate = (MemoryCursor_mcerratedef_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcErrAge",p_cVarName)) {
      mcErrAge = (MemoryCursor_mcerratedef_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcAgeDuo",p_cVarName)) {
      mcAgeDuo = (MemoryCursor_mcerratedef_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcAgenzie",p_cVarName)) {
      mcAgenzie = (MemoryCursor_mcerratedef_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_tmp_list_imprich=null;
    try {
      /* w_tipodest Char(1) */
      /* _dirfiles Char(100) */
      /* conta Numeric(10, 0) */
      /* _trxdate Char(8) */
      /* fhand Char(1) */
      /* ihand Char(1) */
      /* dhand Char(1) */
      /* dFile Numeric(1, 0) */
      /* dNomeFile Char(100) */
      /* iNomeFile Char(100) */
      /* riga Memo */
      /* _codrap Char(16) */
      /* _luonas Char(50) */
      /* nProg Numeric(10, 0) */
      /* cProg Char(20) */
      /* nomefileimport Char(50) */
      /* xConnes Char(16) */
      /* _tdest Char(1) */
      /* _pos Numeric(3, 0) */
      /* _npos Numeric(1, 0) */
      /* _tipoop Char(1) */
      /* _coddip Char(6) */
      /* _uniquecode Char(18) */
      /* _datope Date */
      /* _datmod Date */
      /* _datreal Date */
      /* _datreg Date */
      /* _impstr Char(20) */
      /* _importo Numeric(15, 2) */
      /* _contanti Numeric(15, 2) */
      /* _flgcash Char(1) */
      /* _statodest Char(3) */
      /* _isodest Char(3) */
      /* _cognome Char(26) */
      /* _nome Char(25) */
      /* _citta Char(40) */
      /* _cap Char(5) */
      /* _via Char(35) */
      /* _paese Char(50) */
      /* _prov Char(2) */
      /* _cab Char(6) */
      /* _cognomecp Char(26) */
      /* _nomecp Char(25) */
      /* _pep Char(1) */
      /* _sesso Char(1) */
      /* _nascitta Char(30) */
      /* _nasstato Char(30) */
      /* _resstato Char(3) */
      /* _nasprov Char(2) */
      /* _nasdata Date */
      /* _tipodoc Char(2) */
      /* _numdoc Char(20) */
      /* _docril Date */
      /* _autril Char(30) */
      /* _docsca Date */
      /* _codfis Char(16) */
      /* _connes Char(16) */
      /* cOpeProg1 Char(10) */
      /* cOpeProg2 Char(11) */
      /* nProgImp Numeric(15, 0) */
      /* xSesso Char(1) */
      /* xCAB Char(6) */
      /* xDIP Char(6) */
      /* xDIPx Char(6) */
      /* cCli1 Char(16) */
      /* xIDB Char(10) */
      /* xData Char(8) */
      /* xDatF Char(8) */
      /* _flgbanca Char(1) */
      /* cNumNew Numeric(10, 0) // Contatore record nuovi */
      /* cNumMod Numeric(10, 0) // Contatore record aggiornati */
      /* cNumInv Numeric(10, 0) // Contatore record invariati */
      /* _esito Numeric(1, 0) */
      /* _idbase Char(10) */
      /* _intercod Char(11) */
      /* _intercit Char(30) */
      /* _intercab Char(6) */
      /* _interprv Char(2) */
      /* _doctype Char(2) */
      /* _codana Char(4) */
      /* _codsin Char(2) */
      /* _segno Char(1) */
      /* _uifdest Char(3) */
      /* cProgSto Char(15) */
      /* _prog Char(10) */
      /* _nocf Numeric(1, 0) */
      /* _condoc Char(50) */
      /* _idfile Char(60) */
      /* _mage Char(5) */
      /* _oldcodfis Char(20) */
      /* _ocodfis Char(16) */
      /* _dtimport DateTime */
      /* _txtope Memo */
      /* _errore Numeric(1, 0) */
      /* _nerrori Numeric(10, 0) */
      /* eProg Numeric(10, 0) */
      /* _codstanas Char(3) */
      /* _codstares Char(3) */
      /* _siglacit Char(4) */
      /* _siglasta Char(4) */
      /* _codcit Char(10) */
      /* _merr Char(100) */
      /* _oldmac Char(5) */
      /* _aggcli Numeric(1, 0) */
      /* _tiperr Char(2) */
      /* _intertip Char(2) */
      /* _listerr Memo */
      /* _tipope Char(2) */
      /* _rapporto Char(25) */
      /* _priga Char(100) */
      /* w_codmage Char(5) // Codice Macroagente */
      /* stringaflagrap2 Char(9) // stringa di valori di flagrap2 */
      /* _oldidb Char(10) */
      /* _flagrap2 Char(1) */
      /* _idreg Char(20) */
      /* _idb2 Char(10) */
      /* _citdip Char(30) */
      /* _cabdip Char(6) */
      /* _provdip Char(2) */
      /* _id Numeric(10, 0) */
      /* _filename Char(128) // Nome file con path */
      /* _dipid Char(6) */
      /* _nfile Char(50) */
      /* _filen Char(50) */
      /* _nerrage Numeric(10, 0) */
      /* _errage Numeric(1, 0) */
      /* mcErrate MemoryCursor(mcErrateDef.MCRDef) */
      /* rowErrate Row(mcErrateDef.MCRDef) */
      /* mcErrAge MemoryCursor(mcErrateDef.MCRDef) */
      /* mcAgeDuo MemoryCursor(mcErrateDef.MCRDef) */
      /* mcAgenzie MemoryCursor(mcErrateDef.MCRDef) */
      /* rowAgenzie Row(mcErrateDef.MCRDef) */
      /* _contage Numeric(10, 0) */
      /* _anno Char(4) */
      /* _errorig Numeric(10, 0) */
      /* _ageerr01 Char(80) */
      /* _ageerr02 Char(80) */
      /* _ageerr03 Char(80) */
      /* _ageerr04 Char(80) */
      /* _ageerr05 Char(80) */
      /* _ageerr06 Char(80) */
      /* _ageerr07 Char(80) */
      /* _ageerr08 Char(80) */
      /* _ageerr09 Char(80) */
      /* _ageerr10 Char(80) */
      /* _ageerr11 Char(80) */
      /* _ageerr12 Char(80) */
      /* _ageerr13 Char(80) */
      /* _colonna01 Char(10) */
      /* _colonna02 Char(30) */
      /* _colonna03 Char(40) */
      /* _colonna04 Char(30) */
      /* _colonna05 Char(3) */
      /* _colonna06 Char(2) */
      /* _colonna07 Char(2) */
      /* _colonna08 Char(10) */
      /* _colonna09 Char(10) */
      /* _colonna10 Char(10) */
      /* _colonna11 Char(2) */
      /* _colonna12 Char(1) */
      /* _colonna13 Char(5) */
      /* _flgact Char(1) */
      /* _ndg Char(16) */
      /* _valuta Char(3) */
      /* _valiso Char(3) */
      /* _cittaben Char(30) */
      /* _viaben Char(30) */
      /* _cabben Char(6) */
      /* _capben Char(5) */
      /* _prvben Char(5) */
      /* _agente Char(1) */
      /* w_destfin Char(1) */
      /* _tipintcon Char(2) */
      /* _desintcon Char(50) */
      /* _nazintcon Char(3) */
      /* _cabintcon Char(6) */
      /* _prvintcon Char(2) */
      /* _abichk Char(11) */
      /* _cambio Numeric(9, 4) */
      /* riga_letta Numeric(9, 0) // riga letta del file Excel */
      /* foglio Numeric(2, 0) // foglio letto */
      /* _abicab Char(11) // Abi-Cab Bonifico */
      /* _conto Char(25) */
      /* _impin Numeric(12, 2) */
      /* _impout Numeric(12, 2) */
      /* _codsae Char(3) // Codice SAE */
      /* _setsint Char(3) // Codice SAE */
      /* _data Date */
      /* _nocf Numeric(1, 0) */
      /* w_CODFISC Char(16) // Codice Fiscale */
      /* w_DATANASC Date // Data Nascita */
      /* w_NASCOMUN Char(30) // Luogo di Nascita */
      /* w_NASSTATO Char(30) // Stato di nascita */
      /* w_COGNOME Char(26) // Ragione Sociale */
      /* w_RAGSOC Char(70) // Ragione Sociale */
      /* w_NOME Char(25) // Ragione Sociale */
      /* w_SESSO Char(1) // Sesso */
      /* _err01 Char(80) */
      /* _err02 Char(80) */
      /* _err03 Char(80) */
      /* _err04 Char(80) */
      /* _err05 Char(80) */
      /* _err06 Char(80) */
      /* _err07 Char(80) */
      /* _err08 Char(80) */
      /* _err09 Char(80) */
      /* _err10 Char(80) */
      /* _err11 Char(80) */
      /* _err12 Char(80) */
      /* _err13 Char(80) */
      /* _err14 Char(80) */
      /* _err15 Char(80) */
      /* _err16 Char(80) */
      /* _err17 Char(80) */
      /* _err18 Char(80) */
      /* _err19 Char(80) */
      /* _err20 Char(80) */
      /* _err21 Char(80) */
      /* _err22 Char(80) */
      /* _err23 Char(80) */
      /* _err24 Char(80) */
      /* _err25 Char(80) */
      /* _err26 Char(80) */
      /* _err27 Char(80) */
      /* _err28 Char(80) */
      /* _err29 Char(80) */
      /* _err30 Char(80) */
      /* _err31 Char(80) */
      /* _err32 Char(80) */
      /* _err33 Char(80) */
      /* _err34 Char(80) */
      /* _err35 Char(80) */
      /* _err36 Char(80) */
      /* _err37 Char(80) */
      /* _err38 Char(80) */
      /* _err39 Char(80) */
      /* _err40 Char(80) */
      /* _err41 Char(80) */
      /* _err42 Char(80) */
      /* _err43 Char(80) */
      /* _err44 Char(80) */
      /* _err45 Char(80) */
      /* _err46 Char(80) */
      /* _err47 Char(80) */
      /* _err48 Char(80) */
      /* _err49 Char(80) */
      /* _err50 Char(80) */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgProc Memo // Messaggio */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gUrlApp Char(80) // URL Applicazione */
      /* Legge dati intermediario per metteri su operazbo,fraziobo,rapopebo se mancanti */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _intercod := intermbo->CODINTER */
        _intercod = Cursor_intermbo.GetString("CODINTER");
        /* _intercit := intermbo->DESCCIT */
        _intercit = Cursor_intermbo.GetString("DESCCIT");
        /* _intercab := intermbo->CODCAB */
        _intercab = Cursor_intermbo.GetString("CODCAB");
        /* _interprv := intermbo->PROVINCIA */
        _interprv = Cursor_intermbo.GetString("PROVINCIA");
        /* _intertip := intermbo->TIPINTER */
        _intertip = Cursor_intermbo.GetString("TIPINTER");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      // * --- Drop temporary table tmp_listafile
      if (m_Ctx.IsSharedTemp("tmp_listafile")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
          m_cServer = m_Ctx.GetServer("tmp_listafile");
          m_cPhName = m_Ctx.GetPhName("tmp_listafile");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_listafile");
      }
      // * --- Create temporary table tmp_listafile
      if (m_Ctx.IsSharedTemp("tmp_listafile")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
          m_cServer = m_Ctx.GetServer("tmp_listafile");
          m_cPhName = m_Ctx.GetPhName("tmp_listafile");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_listafile");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_listafile");
      if ( ! (m_Ctx.IsSharedTemp("tmp_listafile"))) {
        m_cServer = m_Ctx.GetServer("tmp_listafile");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_listafile",m_cServer,"proto")),m_cPhName,"tmp_listafile",m_Ctx);
      }
      m_cPhName_tmp_listafile = m_cPhName;
      /* Cicla sul file della lista e lancia la pagina appropriata */
      /* _esito := 0 */
      _esito = CPLib.Round(0,0);
      /* _nerrori := 0 */
      _nerrori = CPLib.Round(0,0);
      /* _nerrage := 0 */
      _nerrage = CPLib.Round(0,0);
      /* gMsgImp := 'Inizio Elaborazione' // Messaggio Import */
      gMsgImp = "Inizio Elaborazione";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := '' */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Select from tmp_list_imprich
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      if (Cursor_tmp_list_imprich!=null)
        Cursor_tmp_list_imprich.Close();
      Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"priorita,nomefile ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_tmp_list_imprich.Eof())) {
        /* nomefileimport := LRTrim(tmp_list_imprich->nomefile) */
        nomefileimport = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile"));
        /* _trxdate := Substr(nomefileimport,12,8) */
        _trxdate = CPLib.Substr(nomefileimport,12,8);
        /* If At('POS',Upper(nomefileimport)) <> 0 */
        if (CPLib.ne(CPLib.At("POS",CPLib.Upper(nomefileimport)),0)) {
          /* _nerrage := 0 */
          _nerrage = CPLib.Round(0,0);
          /* mcErrAge.Zap() */
          mcErrAge.Zap();
          /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione File Agenzie: '+arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Ora Inizio Elaborazione File Agenzie: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* Exec "File Agenzie" Page 2:Page_2 */
          Page_2();
          /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione File Agenzie: '+arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Ora Fine Elaborazione File Agenzie: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* If _nerrage > 0 */
          if (CPLib.gt(_nerrage,0)) {
            /* _filen := "Errori_POS_"+_trxdate+".xlsx" */
            _filen = "Errori_POS_"+_trxdate+".xlsx";
            /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione File Scarti Agenzie: '+arfn_fdatetime(DateTime()) + NL */
            gMsgProc = gMsgProc+"Ora Inizio Elaborazione File Scarti Agenzie: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* Exec "Excel Errori Agenzie" Page 4:Page_4 */
            Page_4();
            /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione File Scarti Agenzie: '+arfn_fdatetime(DateTime()) + NL */
            gMsgProc = gMsgProc+"Ora Fine Elaborazione File Scarti Agenzie: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            // * --- Insert into tmp_listafile from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_listafile");
            m_cPhName = m_Ctx.GetPhName("tmp_listafile");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_listafile",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"00000121")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000121(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_filen),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gUrlApp)+"export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_filen),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_listafile",true);
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
          /* ElseIf At('TRX',Upper(nomefileimport)) <> 0 or At('OTR',Upper(nomefileimport)) <> 0 */
        } else if (CPLib.ne(CPLib.At("TRX",CPLib.Upper(nomefileimport)),0) || CPLib.ne(CPLib.At("OTR",CPLib.Upper(nomefileimport)),0)) {
          /* mcErrate.Zap() */
          mcErrate.Zap();
          /* _nerrori := 0 */
          _nerrori = CPLib.Round(0,0);
          /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione File Transazioni: '+arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Ora Inizio Elaborazione File Transazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* Exec "File Transazioni" Page 5:Page_5 */
          Page_5();
          /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione File Transazioni: '+arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Ora Fine Elaborazione File Transazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* If _nerrori > 0 */
          if (CPLib.gt(_nerrori,0)) {
            /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione File Scarti Transazioni: '+arfn_fdatetime(DateTime()) + NL */
            gMsgProc = gMsgProc+"Ora Inizio Elaborazione File Scarti Transazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* If At('TRX',Upper(nomefileimport)) <> 0 */
            if (CPLib.ne(CPLib.At("TRX",CPLib.Upper(nomefileimport)),0)) {
              /* _filen := "Errori_TRX_"+_trxdate+".xlsx" */
              _filen = "Errori_TRX_"+_trxdate+".xlsx";
            } else { // Else
              /* _filen := "Errori_OTR_"+_trxdate+".xlsx" */
              _filen = "Errori_OTR_"+_trxdate+".xlsx";
            } // End If
            /* Exec "Excel Errori Transazioni" Page 7:Page_7 */
            Page_7();
            /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione File Transazioni: '+arfn_fdatetime(DateTime()) + NL */
            gMsgProc = gMsgProc+"Ora Fine Elaborazione File Transazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            // * --- Insert into tmp_listafile from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_listafile");
            m_cPhName = m_Ctx.GetPhName("tmp_listafile");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_listafile",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"0000012E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000012E(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_filen),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gUrlApp)+"export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_filen),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_listafile",true);
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
          /* ElseIf At('NEW',Upper(nomefileimport)) <> 0 */
        } else if (CPLib.ne(CPLib.At("NEW",CPLib.Upper(nomefileimport)),0)) {
          /* mcErrate.Zap() */
          mcErrate.Zap();
          /* _nerrori := 0 */
          _nerrori = CPLib.Round(0,0);
          /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione File Aggiornamento Soggetti: '+arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Ora Inizio Elaborazione File Aggiornamento Soggetti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* Exec "Aggiornamento Soggetti" Page 12:Page_12 */
          Page_12();
          /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione File Aggiornamento Soggetti: '+arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Ora Fine Elaborazione File Aggiornamento Soggetti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* If _nerrori > 0 */
          if (CPLib.gt(_nerrori,0)) {
            /* _filen := "Errori_NEW_"+_trxdate+".xlsx" */
            _filen = "Errori_NEW_"+_trxdate+".xlsx";
            /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione File Scarti Aggiornamento Soggetti: '+arfn_fdatetime(DateTime()) + NL */
            gMsgProc = gMsgProc+"Ora Inizio Elaborazione File Scarti Aggiornamento Soggetti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* Exec "Excel Errori Aggiornamento Soggetti" Page 15:Page_15 */
            Page_15();
            /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione File Scarti Aggiornamento Soggetti: '+arfn_fdatetime(DateTime()) + NL */
            gMsgProc = gMsgProc+"Ora Fine Elaborazione File Scarti Aggiornamento Soggetti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            // * --- Insert into tmp_listafile from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_listafile");
            m_cPhName = m_Ctx.GetPhName("tmp_listafile");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_listafile",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"00000139")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000139(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_filen),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(2,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gUrlApp)+"export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_filen),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_listafile",true);
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
        // * --- Delete from tmp_list_imprich
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"0000013A")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"nomefile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_list_imprich.GetString("nomefile"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_list_imprich.GetString("nomefile"))+"";
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
        Cursor_tmp_list_imprich.Next();
      }
      m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
      Cursor_tmp_list_imprich.Close();
      // * --- End Select
      /* gMsgImp := 'Elaborazione terminata!'+iif((_nerrage+_nerrori)>0,' Prelevare i file con gli errori.','') // Messaggio Import */
      gMsgImp = "Elaborazione terminata!"+(CPLib.gt((_nerrage+_nerrori),0)?" Prelevare i file con gli errori.":"");
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* cNumInv := 0 */
      cNumInv = CPLib.Round(0,0);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* _nerrori := 0 */
      _nerrori = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000143status;
      nTry00000143status = m_Sql.GetTransactionStatus();
      String cTry00000143msg;
      cTry00000143msg = m_Sql.TransactionErrorMessage();
      try {
        /* Salta la prima riga in quanti dice solo cose di trasmissione */
        /* _idfile := LRTrim(nomefileimport) */
        _idfile = CPLib.LRTrim(nomefileimport);
        //base
        InputStream ExcelFileToRead = new FileInputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomefileimport));
        XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
        _conta = wb.getNumberOfSheets();
        Row row; 
        Cell cell;
        int cellType;
        String[] colonna = new String[28];
        /* _i = 0 */
        CPLib.eqr(_i,0);
        /* While _i < _conta */
        while (CPLib.lt(_i,_conta)) {
          /* foglio := _i // foglio letto */
          foglio = CPLib.Round(_i,0);
          //Apro uno ad uno i fogli del file Excel
          XSSFSheet sheet = wb.getSheetAt(_i);
          for (int rowNumber = sheet.getFirstRowNum(); rowNumber <= sheet.getLastRowNum(); rowNumber++) {
            row = sheet.getRow(rowNumber);
            if (row == null) {
              // This row is completely empty
              } else {
              cell_count=0;
          /* riga_letta := riga_letta+1 // riga letta del file Excel */
          riga_letta = CPLib.Round(riga_letta+1,0);
          /* If riga_letta > 1 */
          if (CPLib.gt(riga_letta,1)) {
            /* While cell_count < 28 */
            while (CPLib.lt(cell_count,28)) {
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
            /* mcAgeDuo.AppendWithKey(Left(colonna[0],10)) */
            mcAgeDuo.AppendWithKey(CPLib.Left(colonna[0],10));
            /* mcAgeDuo.colonna01 := Left(colonna[0],10) */
            mcAgeDuo.row.colonna01 = CPLib.Left(colonna[0],10);
            /* mcAgeDuo.colonna02 := Left(colonna[1],30) */
            mcAgeDuo.row.colonna02 = CPLib.Left(colonna[1],30);
            /* mcAgeDuo.colonna03 := Left(colonna[2],40) */
            mcAgeDuo.row.colonna03 = CPLib.Left(colonna[2],40);
            /* mcAgeDuo.colonna04 := Left(colonna[3],30) */
            mcAgeDuo.row.colonna04 = CPLib.Left(colonna[3],30);
            /* mcAgeDuo.colonna05 := Left(colonna[4],3) */
            mcAgeDuo.row.colonna05 = CPLib.Left(colonna[4],3);
            /* mcAgeDuo.colonna06 := Left(colonna[5],2) */
            mcAgeDuo.row.colonna06 = CPLib.Left(colonna[5],2);
            /* mcAgeDuo.colonna07 := Left(colonna[6],2) */
            mcAgeDuo.row.colonna07 = CPLib.Left(colonna[6],2);
            /* mcAgeDuo.colonna08 := Left(colonna[7],10) */
            mcAgeDuo.row.colonna08 = CPLib.Left(colonna[7],10);
            /* mcAgeDuo.colonna09 := Left(colonna[8],10) */
            mcAgeDuo.row.colonna09 = CPLib.Left(colonna[8],10);
            /* mcAgeDuo.colonna10 := Left(colonna[9],10) */
            mcAgeDuo.row.colonna10 = CPLib.Left(colonna[9],10);
            /* mcAgeDuo.colonna11 := Left(colonna[10],2) */
            mcAgeDuo.row.colonna11 = CPLib.Left(colonna[10],2);
            /* mcAgeDuo.colonna12 := Left(colonna[11],1) */
            mcAgeDuo.row.colonna12 = CPLib.Left(colonna[11],1);
            /* mcAgeDuo.colonna13 := Left(colonna[12],5) */
            mcAgeDuo.row.colonna13 = CPLib.Left(colonna[12],5);
            /* mcAgeDuo.colonna14 := colonna[13] */
            mcAgeDuo.row.colonna14 = colonna[13];
            /* mcAgeDuo.colonna15 := colonna[14] */
            mcAgeDuo.row.colonna15 = colonna[14];
            /* mcAgeDuo.colonna16 := colonna[15] */
            mcAgeDuo.row.colonna16 = colonna[15];
            /* mcAgeDuo.colonna17 := colonna[16] */
            mcAgeDuo.row.colonna17 = colonna[16];
            /* mcAgeDuo.colonna18 := colonna[17] */
            mcAgeDuo.row.colonna18 = colonna[17];
            /* mcAgeDuo.colonna19 := colonna[18] */
            mcAgeDuo.row.colonna19 = colonna[18];
            /* mcAgeDuo.colonna20 := colonna[19] */
            mcAgeDuo.row.colonna20 = colonna[19];
            /* mcAgeDuo.colonna21 := colonna[20] */
            mcAgeDuo.row.colonna21 = colonna[20];
            /* mcAgeDuo.colonna22 := colonna[21] */
            mcAgeDuo.row.colonna22 = colonna[21];
            /* mcAgeDuo.colonna23 := colonna[22] */
            mcAgeDuo.row.colonna23 = colonna[22];
            /* mcAgeDuo.colonna24 := colonna[23] */
            mcAgeDuo.row.colonna24 = colonna[23];
            /* mcAgeDuo.colonna25 := colonna[24] */
            mcAgeDuo.row.colonna25 = colonna[24];
            /* mcAgeDuo.colonna26 := colonna[25] */
            mcAgeDuo.row.colonna26 = colonna[25];
            /* mcAgeDuo.colonna27 := Left(colonna[26],1) */
            mcAgeDuo.row.colonna27 = CPLib.Left(colonna[26],1);
            /* mcAgeDuo.colonna28 := Left(colonna[27],1) */
            mcAgeDuo.row.colonna28 = CPLib.Left(colonna[27],1);
            /* mcAgeDuo.SaveRow() */
            mcAgeDuo.SaveRow();
            /* mcAgenzie.AppendWithKey(Left(colonna[0],10)) */
            mcAgenzie.AppendWithKey(CPLib.Left(colonna[0],10));
            /* mcAgenzie.colonna01 := Left(colonna[0],10) */
            mcAgenzie.row.colonna01 = CPLib.Left(colonna[0],10);
            /* mcAgenzie.colonna02 := Left(colonna[1],30) */
            mcAgenzie.row.colonna02 = CPLib.Left(colonna[1],30);
            /* mcAgenzie.colonna03 := Left(colonna[2],40) */
            mcAgenzie.row.colonna03 = CPLib.Left(colonna[2],40);
            /* mcAgenzie.colonna04 := Left(colonna[3],30) */
            mcAgenzie.row.colonna04 = CPLib.Left(colonna[3],30);
            /* mcAgenzie.colonna05 := Left(colonna[4],3) */
            mcAgenzie.row.colonna05 = CPLib.Left(colonna[4],3);
            /* mcAgenzie.colonna06 := Left(colonna[5],2) */
            mcAgenzie.row.colonna06 = CPLib.Left(colonna[5],2);
            /* mcAgenzie.colonna07 := Left(colonna[6],2) */
            mcAgenzie.row.colonna07 = CPLib.Left(colonna[6],2);
            /* mcAgenzie.colonna08 := Left(colonna[7],10) */
            mcAgenzie.row.colonna08 = CPLib.Left(colonna[7],10);
            /* mcAgenzie.colonna09 := Left(colonna[8],10) */
            mcAgenzie.row.colonna09 = CPLib.Left(colonna[8],10);
            /* mcAgenzie.colonna10 := Left(colonna[9],10) */
            mcAgenzie.row.colonna10 = CPLib.Left(colonna[9],10);
            /* mcAgenzie.colonna11 := Left(colonna[10],2) */
            mcAgenzie.row.colonna11 = CPLib.Left(colonna[10],2);
            /* mcAgenzie.colonna12 := Left(colonna[11],1) */
            mcAgenzie.row.colonna12 = CPLib.Left(colonna[11],1);
            /* mcAgenzie.colonna13 := Left(colonna[12],5) */
            mcAgenzie.row.colonna13 = CPLib.Left(colonna[12],5);
            /* mcAgenzie.colonna14 := colonna[13] */
            mcAgenzie.row.colonna14 = colonna[13];
            /* mcAgenzie.colonna15 := colonna[14] */
            mcAgenzie.row.colonna15 = colonna[14];
            /* mcAgenzie.colonna16 := colonna[15] */
            mcAgenzie.row.colonna16 = colonna[15];
            /* mcAgenzie.colonna17 := colonna[16] */
            mcAgenzie.row.colonna17 = colonna[16];
            /* mcAgenzie.colonna18 := colonna[17] */
            mcAgenzie.row.colonna18 = colonna[17];
            /* mcAgenzie.colonna19 := colonna[18] */
            mcAgenzie.row.colonna19 = colonna[18];
            /* mcAgenzie.colonna20 := colonna[19] */
            mcAgenzie.row.colonna20 = colonna[19];
            /* mcAgenzie.colonna21 := colonna[20] */
            mcAgenzie.row.colonna21 = colonna[20];
            /* mcAgenzie.colonna22 := colonna[21] */
            mcAgenzie.row.colonna22 = colonna[21];
            /* mcAgenzie.colonna23 := colonna[22] */
            mcAgenzie.row.colonna23 = colonna[22];
            /* mcAgenzie.colonna24 := colonna[23] */
            mcAgenzie.row.colonna24 = colonna[23];
            /* mcAgenzie.colonna25 := colonna[24] */
            mcAgenzie.row.colonna25 = colonna[24];
            /* mcAgenzie.colonna26 := colonna[25] */
            mcAgenzie.row.colonna26 = colonna[25];
            /* mcAgenzie.colonna27 := Left(colonna[26],1) */
            mcAgenzie.row.colonna27 = CPLib.Left(colonna[26],1);
            /* mcAgenzie.colonna28 := Left(colonna[27],1) */
            mcAgenzie.row.colonna28 = CPLib.Left(colonna[27],1);
            /* mcAgeDuo.SaveRow() */
            mcAgeDuo.SaveRow();
          } // End If
          // Chiude i cicli e gli if
            }
          }
          _i++;
        } // End While
        /* Legge il file */
        for (MemoryCursorRow_mcerratedef_mcrdef rowAgenzie : mcAgenzie._iterable_()) {
          /* If rowAgenzie.colonna27='S' or rowAgenzie.colonna28='S' */
          if (CPLib.eqr(rowAgenzie.colonna27,"S") || CPLib.eqr(rowAgenzie.colonna28,"S")) {
            /* gMsgImp := "Elaborazione dell'agenzia con codice: " + rowAgenzie.colonna01 // Messaggio Import */
            gMsgImp = "Elaborazione dell'agenzia con codice: "+rowAgenzie.colonna01;
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _coddip := '' */
            _coddip = "";
            /* _prov := '' */
            _prov = "";
            /* _cap := rowAgenzie.colonna13 */
            _cap = rowAgenzie.colonna13;
            /* _cab := '' */
            _cab = "";
            /* _idbase := '' */
            _idbase = "";
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"AGACCODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowAgenzie.colonna10),"C",10,0,m_cServer),m_cServer,CPLib.LRTrim(rowAgenzie.colonna10));
            if (m_Ctx.IsSharedTemp("anadip")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODDIP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _coddip = Read_Cursor.GetString("CODDIP");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _coddip = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(_coddip) */
            if (CPLib.Empty(_coddip)) {
              // * --- Read from anadip
              m_cServer = m_Ctx.GetServer("anadip");
              m_cPhName = m_Ctx.GetPhName("anadip");
              m_cSql = "";
              m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(rowAgenzie.colonna01,4,6),"C",6,0,m_cServer),m_cServer,CPLib.Substr(rowAgenzie.colonna01,4,6));
              if (m_Ctx.IsSharedTemp("anadip")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODDIP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _coddip = Read_Cursor.GetString("CODDIP");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on anadip into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _coddip = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
            /* _citta := rowAgenzie.colonna04 */
            _citta = rowAgenzie.colonna04;
            // * --- Read from tbcitta
            m_cServer = m_Ctx.GetServer("tbcitta");
            m_cPhName = m_Ctx.GetPhName("tbcitta");
            m_cSql = "";
            m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_citta,"C",60,0,m_cServer),m_cServer,_citta);
            if (m_Ctx.IsSharedTemp("tbcitta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _cab = Read_Cursor.GetString("CAB");
              _prov = Read_Cursor.GetString("PROV");
              _idbase = Read_Cursor.GetString("IDBASE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _cab = "";
              _prov = "";
              _idbase = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _errage := 0 */
            _errage = CPLib.Round(0,0);
            /* _ageerr01 := '' */
            _ageerr01 = "";
            /* _ageerr02 := '' */
            _ageerr02 = "";
            /* _ageerr03 := '' */
            _ageerr03 = "";
            /* _ageerr04 := '' */
            _ageerr04 = "";
            /* _ageerr05 := '' */
            _ageerr05 = "";
            /* _ageerr06 := '' */
            _ageerr06 = "";
            /* _ageerr07 := '' */
            _ageerr07 = "";
            /* _ageerr08 := '' */
            _ageerr08 = "";
            /* _ageerr09 := '' */
            _ageerr09 = "";
            /* _ageerr10 := '' */
            _ageerr10 = "";
            /* _ageerr11 := '' */
            _ageerr11 = "";
            /* _ageerr12 := '' */
            _ageerr12 = "";
            /* _ageerr13 := '' */
            _ageerr13 = "";
            /* _colonna01 := rowAgenzie.colonna01 */
            _colonna01 = rowAgenzie.colonna01;
            /* _colonna02 := rowAgenzie.colonna02 */
            _colonna02 = rowAgenzie.colonna02;
            /* _colonna03 := rowAgenzie.colonna03 */
            _colonna03 = rowAgenzie.colonna03;
            /* _colonna04 := rowAgenzie.colonna04 */
            _colonna04 = rowAgenzie.colonna04;
            /* _colonna05 := rowAgenzie.colonna05 */
            _colonna05 = rowAgenzie.colonna05;
            /* _colonna06 := rowAgenzie.colonna06 */
            _colonna06 = rowAgenzie.colonna06;
            /* _colonna07 := rowAgenzie.colonna07 */
            _colonna07 = rowAgenzie.colonna07;
            /* _colonna08 := rowAgenzie.colonna08 */
            _colonna08 = rowAgenzie.colonna08;
            /* _colonna09 := rowAgenzie.colonna09 */
            _colonna09 = rowAgenzie.colonna09;
            /* _colonna10 := rowAgenzie.colonna10 */
            _colonna10 = rowAgenzie.colonna10;
            /* _colonna11 := rowAgenzie.colonna11 */
            _colonna11 = rowAgenzie.colonna11;
            /* _colonna12 := rowAgenzie.colonna12 */
            _colonna12 = rowAgenzie.colonna12;
            /* _colonna13 := rowAgenzie.colonna13 */
            _colonna13 = rowAgenzie.colonna13;
            /* If rowAgenzie.colonna28='N' */
            if (CPLib.eqr(rowAgenzie.colonna28,"N")) {
              /* Exec "Controllio Agenzia" Page 3:Page_3 */
              Page_3();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
            } // End If
            /* If _errage > 0 */
            if (CPLib.gt(_errage,0)) {
              /* _nerrage := _nerrage + 1 */
              _nerrage = CPLib.Round(_nerrage+1,0);
              /* mcErrAge.AppendWithKey(rowAgenzie.colonna01) */
              mcErrAge.AppendWithKey(rowAgenzie.colonna01);
              /* mcErrAge.colonna01 := rowAgenzie.colonna01 */
              mcErrAge.row.colonna01 = rowAgenzie.colonna01;
              /* mcErrAge.colonna02 := rowAgenzie.colonna02 */
              mcErrAge.row.colonna02 = rowAgenzie.colonna02;
              /* mcErrAge.colonna03 := rowAgenzie.colonna03 */
              mcErrAge.row.colonna03 = rowAgenzie.colonna03;
              /* mcErrAge.colonna04 := rowAgenzie.colonna04 */
              mcErrAge.row.colonna04 = rowAgenzie.colonna04;
              /* mcErrAge.colonna05 := rowAgenzie.colonna05 */
              mcErrAge.row.colonna05 = rowAgenzie.colonna05;
              /* mcErrAge.colonna06 := rowAgenzie.colonna06 */
              mcErrAge.row.colonna06 = rowAgenzie.colonna06;
              /* mcErrAge.colonna07 := rowAgenzie.colonna07 */
              mcErrAge.row.colonna07 = rowAgenzie.colonna07;
              /* mcErrAge.colonna08 := rowAgenzie.colonna08 */
              mcErrAge.row.colonna08 = rowAgenzie.colonna08;
              /* mcErrAge.colonna09 := rowAgenzie.colonna09 */
              mcErrAge.row.colonna09 = rowAgenzie.colonna09;
              /* mcErrAge.colonna10 := rowAgenzie.colonna10 */
              mcErrAge.row.colonna10 = rowAgenzie.colonna10;
              /* mcErrAge.colonna11 := rowAgenzie.colonna11 */
              mcErrAge.row.colonna11 = rowAgenzie.colonna11;
              /* mcErrAge.colonna12 := rowAgenzie.colonna12 */
              mcErrAge.row.colonna12 = rowAgenzie.colonna12;
              /* mcErrAge.colonna13 := rowAgenzie.colonna13 */
              mcErrAge.row.colonna13 = rowAgenzie.colonna13;
              /* mcErrAge.colonna14 := _ageerr01 */
              mcErrAge.row.colonna14 = _ageerr01;
              /* mcErrAge.colonna15 := _ageerr02 */
              mcErrAge.row.colonna15 = _ageerr02;
              /* mcErrAge.colonna16 := _ageerr03 */
              mcErrAge.row.colonna16 = _ageerr03;
              /* mcErrAge.colonna17 := _ageerr04 */
              mcErrAge.row.colonna17 = _ageerr04;
              /* mcErrAge.colonna18 := _ageerr05 */
              mcErrAge.row.colonna18 = _ageerr05;
              /* mcErrAge.colonna19 := _ageerr06 */
              mcErrAge.row.colonna19 = _ageerr06;
              /* mcErrAge.colonna20 := _ageerr07 */
              mcErrAge.row.colonna20 = _ageerr07;
              /* mcErrAge.colonna21 := _ageerr08 */
              mcErrAge.row.colonna21 = _ageerr08;
              /* mcErrAge.colonna22 := _ageerr09 */
              mcErrAge.row.colonna22 = _ageerr09;
              /* mcErrAge.colonna23 := _ageerr10 */
              mcErrAge.row.colonna23 = _ageerr10;
              /* mcErrAge.colonna24 := _ageerr11 */
              mcErrAge.row.colonna24 = _ageerr11;
              /* mcErrAge.colonna25 := _ageerr12 */
              mcErrAge.row.colonna25 = _ageerr12;
              /* mcErrAge.colonna26 := _ageerr13 */
              mcErrAge.row.colonna26 = _ageerr13;
              /* mcErrAge.SaveRow() */
              mcErrAge.SaveRow();
            } else { // Else
              /* If Empty(_coddip) */
              if (CPLib.Empty(_coddip)) {
                /* cNumNew := cNumNew + 1 */
                cNumNew = CPLib.Round(cNumNew+1,0);
                // * --- Insert into anadip from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anadip",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"000001DA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000001DA(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(rowAgenzie.colonna01,4,6)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowAgenzie.colonna02,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_citta,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_prov,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowAgenzie.colonna10),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_cab,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_cap,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_idbase,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowAgenzie.colonna03,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowAgenzie.colonna05),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.LRTrim(rowAgenzie.colonna09)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.LRTrim(rowAgenzie.colonna08)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowAgenzie.colonna07),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowAgenzie.colonna06),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowAgenzie.colonna11),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowAgenzie.colonna12),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"anadip",true);
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
              } else { // Else
                /* cNumMod := cNumMod + 1 */
                cNumMod = CPLib.Round(cNumMod+1,0);
                // * --- Write into anadip from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anadip",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"000001DC")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"AGENTE = "+CPLib.ToSQL(1,"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAB = "+CPLib.ToSQL(_cab,"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(_cap,"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(_citta,"C",60,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDCITTA = "+CPLib.ToSQL(_idbase,"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(_prov,"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"NAZAGENTE = "+CPLib.ToSQL(CPLib.LRTrim(rowAgenzie.colonna05),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"ANOMOPER = "+CPLib.ToSQL(CPLib.LRTrim(rowAgenzie.colonna06),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"VALCOMPL = "+CPLib.ToSQL(CPLib.LRTrim(rowAgenzie.colonna07),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"AGACCODE = "+CPLib.ToSQL(CPLib.LRTrim(rowAgenzie.colonna10),"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"AGEREGIO = "+CPLib.ToSQL(CPLib.LRTrim(rowAgenzie.colonna11),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLGATT = "+CPLib.ToSQL(CPLib.LRTrim(rowAgenzie.colonna12),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(rowAgenzie.colonna03,"C",50,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCRIZ = "+CPLib.ToSQL(rowAgenzie.colonna02,"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"OPXSOSAGE = "+CPLib.ToSQL(CPLib.Val(CPLib.LRTrim(rowAgenzie.colonna08)),"N",10,0)+", ";
                m_cSql = m_cSql+"OPXSOSCLI = "+CPLib.ToSQL(CPLib.Val(CPLib.LRTrim(rowAgenzie.colonna09)),"N",10,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anadip",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CODDIP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_coddip,"?",0,0,m_cServer),m_cServer,_coddip)+"";
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
              } // End If
            } // End If
          } else { // Else
            /* _nerrage := _nerrage + 1 */
            _nerrage = CPLib.Round(_nerrage+1,0);
            /* mcErrAge.AppendWithKey(rowAgenzie.colonna01) */
            mcErrAge.AppendWithKey(rowAgenzie.colonna01);
            /* mcErrAge.colonna01 := rowAgenzie.colonna01 */
            mcErrAge.row.colonna01 = rowAgenzie.colonna01;
            /* mcErrAge.colonna02 := rowAgenzie.colonna02 */
            mcErrAge.row.colonna02 = rowAgenzie.colonna02;
            /* mcErrAge.colonna03 := rowAgenzie.colonna03 */
            mcErrAge.row.colonna03 = rowAgenzie.colonna03;
            /* mcErrAge.colonna04 := rowAgenzie.colonna04 */
            mcErrAge.row.colonna04 = rowAgenzie.colonna04;
            /* mcErrAge.colonna05 := rowAgenzie.colonna05 */
            mcErrAge.row.colonna05 = rowAgenzie.colonna05;
            /* mcErrAge.colonna06 := rowAgenzie.colonna06 */
            mcErrAge.row.colonna06 = rowAgenzie.colonna06;
            /* mcErrAge.colonna07 := rowAgenzie.colonna07 */
            mcErrAge.row.colonna07 = rowAgenzie.colonna07;
            /* mcErrAge.colonna08 := rowAgenzie.colonna08 */
            mcErrAge.row.colonna08 = rowAgenzie.colonna08;
            /* mcErrAge.colonna09 := rowAgenzie.colonna09 */
            mcErrAge.row.colonna09 = rowAgenzie.colonna09;
            /* mcErrAge.colonna10 := rowAgenzie.colonna10 */
            mcErrAge.row.colonna10 = rowAgenzie.colonna10;
            /* mcErrAge.colonna11 := rowAgenzie.colonna11 */
            mcErrAge.row.colonna11 = rowAgenzie.colonna11;
            /* mcErrAge.colonna12 := rowAgenzie.colonna12 */
            mcErrAge.row.colonna12 = rowAgenzie.colonna12;
            /* mcErrAge.colonna13 := rowAgenzie.colonna13 */
            mcErrAge.row.colonna13 = rowAgenzie.colonna13;
            /* mcErrAge.colonna14 := rowAgenzie.colonna14 */
            mcErrAge.row.colonna14 = rowAgenzie.colonna14;
            /* mcErrAge.colonna15 := rowAgenzie.colonna15 */
            mcErrAge.row.colonna15 = rowAgenzie.colonna15;
            /* mcErrAge.colonna16 := rowAgenzie.colonna16 */
            mcErrAge.row.colonna16 = rowAgenzie.colonna16;
            /* mcErrAge.colonna17 := rowAgenzie.colonna17 */
            mcErrAge.row.colonna17 = rowAgenzie.colonna17;
            /* mcErrAge.colonna18 := rowAgenzie.colonna18 */
            mcErrAge.row.colonna18 = rowAgenzie.colonna18;
            /* mcErrAge.colonna19 := rowAgenzie.colonna19 */
            mcErrAge.row.colonna19 = rowAgenzie.colonna19;
            /* mcErrAge.colonna20 := rowAgenzie.colonna20 */
            mcErrAge.row.colonna20 = rowAgenzie.colonna20;
            /* mcErrAge.colonna21 := rowAgenzie.colonna21 */
            mcErrAge.row.colonna21 = rowAgenzie.colonna21;
            /* mcErrAge.colonna22 := rowAgenzie.colonna22 */
            mcErrAge.row.colonna22 = rowAgenzie.colonna22;
            /* mcErrAge.colonna23 := rowAgenzie.colonna23 */
            mcErrAge.row.colonna23 = rowAgenzie.colonna23;
            /* mcErrAge.colonna24 := rowAgenzie.colonna24 */
            mcErrAge.row.colonna24 = rowAgenzie.colonna24;
            /* mcErrAge.colonna25 := rowAgenzie.colonna25 */
            mcErrAge.row.colonna25 = rowAgenzie.colonna25;
            /* mcErrAge.colonna26 := rowAgenzie.colonna26 */
            mcErrAge.row.colonna26 = rowAgenzie.colonna26;
            /* mcErrAge.SaveRow() */
            mcErrAge.SaveRow();
          } // End If
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
        }
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        // Chiude il file e lo cancella
        FileLibMit.DeleteFile("appo/"+nomefileimport);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000143status,0)) {
          m_Sql.SetTransactionStatus(nTry00000143status,cTry00000143msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Informazioni Elaborate: '+LRTrim(Str(conta,10,0)) + ' dal file '+nomefileimport+NL */
      gMsgProc = gMsgProc+"Informazioni Elaborate: "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" dal file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Nuove Agenzie '+LRTrim(Str(cNumNew,10,0)) + ' dal file '+nomefileimport+NL */
      gMsgProc = gMsgProc+"Nuove Agenzie "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" dal file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Agenzie Aggiornate '+LRTrim(Str(cNumMod,10,0)) + ' dal file '+nomefileimport+NL */
      gMsgProc = gMsgProc+"Agenzie Aggiornate "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+" dal file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If _nerrage > 0 */
      if (CPLib.gt(_nerrage,0)) {
        /* gMsgProc := gMsgProc + 'Agenzie Scartate '+LRTrim(Str(_nerrage,10,0)) + ' dal file '+nomefileimport+NL */
        gMsgProc = gMsgProc+"Agenzie Scartate "+CPLib.LRTrim(CPLib.Str(_nerrage,10,0))+" dal file "+nomefileimport+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
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
  void Page_3() throws Exception {
    /* _contage := 0 */
    _contage = CPLib.Round(0,0);
    for (MemoryCursorRow_mcerratedef_mcrdef rowErrate : mcAgeDuo._iterable_()) {
      /* If LRTrim(rowErrate.colonna01)=LRTrim(_colonna01) */
      if (CPLib.eqr(CPLib.LRTrim(rowErrate.colonna01),CPLib.LRTrim(_colonna01))) {
        /* _contage := _contage + 1 */
        _contage = CPLib.Round(_contage+1,0);
      } // End If
    }
    /* If _contage > 1 */
    if (CPLib.gt(_contage,1)) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr01 := 'Duplicazione Agenzia' */
      _ageerr01 = "Duplicazione Agenzia";
    } // End If
    /* If Empty(LRTrim(_colonna04)) */
    if (CPLib.Empty(CPLib.LRTrim(_colonna04))) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr02 := 'Manca la località' */
      _ageerr02 = "Manca la località";
    } // End If
    /* If Empty(_idbase) and not(Empty(LRTrim(_colonna04))) */
    if (CPLib.Empty(_idbase) &&  ! (CPLib.Empty(CPLib.LRTrim(_colonna04)))) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr03 := 'Località non congruente con tabelle AUI' */
      _ageerr03 = "Località non congruente con tabelle AUI";
    } // End If
    /* If Empty(_colonna02) */
    if (CPLib.Empty(_colonna02)) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr04 := "Manca la ragione sociale dell'agenzia" */
      _ageerr04 = "Manca la ragione sociale dell'agenzia";
    } // End If
    /* If Empty(_colonna03) */
    if (CPLib.Empty(_colonna03)) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr05 := "Manca l'indirizzo dell'agenzia" */
      _ageerr05 = "Manca l'indirizzo dell'agenzia";
    } // End If
    /* If Empty(_colonna01) */
    if (CPLib.Empty(_colonna01)) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr06 := 'Agenzia priva di account' */
      _ageerr06 = "Agenzia priva di account";
    } // End If
    /* If Empty(_colonna05) */
    if (CPLib.Empty(_colonna05)) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr07 := "Manca la Nazionalità dell'agente" */
      _ageerr07 = "Manca la Nazionalità dell'agente";
    } // End If
    /* If Empty(_colonna06) */
    if (CPLib.Empty(_colonna06)) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr08 := 'Manca Il Rischio Anomalie Operative' */
      _ageerr08 = "Manca Il Rischio Anomalie Operative";
    } // End If
    /* If Empty(_colonna07) */
    if (CPLib.Empty(_colonna07)) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr09 := 'Manca Il Rischio Visita Compliance' */
      _ageerr09 = "Manca Il Rischio Visita Compliance";
    } // End If
    /* If Empty(_colonna08) */
    if (CPLib.Empty(_colonna08)) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr10 := 'Manca il Numero Operazioni Sospette Agenzia' */
      _ageerr10 = "Manca il Numero Operazioni Sospette Agenzia";
    } // End If
    /* If Empty(_colonna09) */
    if (CPLib.Empty(_colonna09)) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr11 := 'Manca il Numero Operazioni Sospette Clienti' */
      _ageerr11 = "Manca il Numero Operazioni Sospette Clienti";
    } // End If
    /* If Empty(_colonna10) */
    if (CPLib.Empty(_colonna10)) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr12 := 'Manca il Codice Interno Agenzia' */
      _ageerr12 = "Manca il Codice Interno Agenzia";
    } // End If
    /* If Empty(_colonna11) */
    if (CPLib.Empty(_colonna11)) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr13 := "Manca la Regione dell'Agenzia" */
      _ageerr13 = "Manca la Regione dell'Agenzia";
    } // End If
  }
  void Page_4() throws Exception {
    /* Formato Excel */
    /* gMsgImp := 'Attendere. Creazione del file excel ...' // Messaggio Import */
    gMsgImp = "Attendere. Creazione del file excel ...";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    /* _nfile := LRTrim(gPathApp)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(_filen) */
    _nfile = CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_filen);
    /* Seleziona i record */
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
    cell =  row.createCell(0);
    cell.setCellValue("Codice Agenzia");
    cell.setCellStyle(cs);
    cell =  row.createCell(1);
    cell.setCellValue("Ragione Sociale");
    cell.setCellStyle(cs);
    cell = row.createCell(2);
    cell.setCellValue("Domicilio");
    cell.setCellStyle(cs);
    cell = row.createCell(3);
    cell.setCellValue("Città");
    cell.setCellStyle(cs);
    cell =  row.createCell(4);
    cell.setCellValue("Nazionalità Agente");
    cell.setCellStyle(cs);
    cell =  row.createCell(5);
    cell.setCellValue("Anomalie Operative");
    cell.setCellStyle(cs);
    cell =  row.createCell(6);
    cell.setCellValue("Valutazione Compliance");
    cell.setCellStyle(cs);
    cell =  row.createCell(7);
    cell.setCellValue("Operazioni Sospette Agenzia");
    cell.setCellStyle(cs);
    cell =  row.createCell(8);
    cell.setCellValue("Operazioni Sospette Cliente");
    cell.setCellStyle(cs);
    cell =  row.createCell(9);
    cell.setCellValue("Codice Interno Agenzia");
    cell.setCellStyle(cs);
    cell =  row.createCell(10);
    cell.setCellValue("Regione Agenzia");
    cell.setCellStyle(cs);
    cell =  row.createCell(11);
    cell.setCellValue("Flag Agenzia Attiva");
    cell.setCellStyle(cs);
    cell =  row.createCell(12);
    cell.setCellValue("CAP Agenzia");
    cell.setCellStyle(cs);
    cell =  row.createCell(13);
    cell.setCellValue("Errore 1");
    cell.setCellStyle(cs);
    cell =  row.createCell(14);
    cell.setCellValue("Errore 2");
    cell.setCellStyle(cs);
    cell =  row.createCell(15);
    cell.setCellValue("Errore 3");
    cell.setCellStyle(cs);
    cell =  row.createCell(16);
    cell.setCellValue("Errore 4");
    cell.setCellStyle(cs);
    cell =  row.createCell(17);
    cell.setCellValue("Errore 5");
    cell.setCellStyle(cs);
    cell =  row.createCell(18);
    cell.setCellValue("Errore 6");
    cell.setCellStyle(cs);
    cell =  row.createCell(19);
    cell.setCellValue("Errore 7");
    cell.setCellStyle(cs);
    cell =  row.createCell(20);
    cell.setCellValue("Errore 8");
    cell.setCellStyle(cs);
    cell =  row.createCell(21);
    cell.setCellValue("Errore 9");
    cell.setCellStyle(cs);
    cell =  row.createCell(22);
    cell.setCellValue("Errore 10");
    cell.setCellStyle(cs);
    cell =  row.createCell(23);
    cell.setCellValue("Errore 11");
    cell.setCellStyle(cs);
    cell =  row.createCell(24);
    cell.setCellValue("Errore 12");
    cell.setCellStyle(cs);
    cell =  row.createCell(25);
    cell.setCellValue("Errore 13");
    cell.setCellStyle(cs);
    cell =  row.createCell(26);
    cell.setCellValue("AGENZIA CORRETTA");
    cell.setCellStyle(cs);
    cell =  row.createCell(27);
    cell.setCellValue("FORZA SCRITTURA");
    cell.setCellStyle(cs);
    r++;
    MemoryCursor_mcerratedef_mcrdef cpmc_00000239;
    cpmc_00000239 = new MemoryCursor_mcerratedef_mcrdef();
    for (MemoryCursorRow_mcerratedef_mcrdef rowErrate : mcErrAge._iterable_()) {
      cpmc_00000239.Append(rowErrate);
    }
    for (MemoryCursorRow_mcerratedef_mcrdef rowErrate : cpmc_00000239._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_mcerratedef_mcrdef>(){  public int compare(MemoryCursorRow_mcerratedef_mcrdef r1,MemoryCursorRow_mcerratedef_mcrdef r2){    if (CPLib.gt(r1.colonna01,r2.colonna01)) return 1;    if (CPLib.lt(r1.colonna01,r2.colonna01)) return -1;    return 0;  }})) {
      // Scrive la riga
      row = sheet.createRow(r);
      cell = row.createCell(0);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna01));
      cell = row.createCell(1);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna02));
      cell = row.createCell(2);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna03));
      cell = row.createCell(3);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna04));
      cell = row.createCell(4);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna05));
      cell = row.createCell(5);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna06));
      cell = row.createCell(6);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna07));
      cell = row.createCell(7);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna08));
      cell = row.createCell(8);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna09));
      cell = row.createCell(9);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna10));
      cell = row.createCell(10);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna11));
      cell = row.createCell(11);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna12));
      cell = row.createCell(12);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna13));
      cell = row.createCell(13);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna14));
      cell = row.createCell(14);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna15));
      cell = row.createCell(15);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna16));
      cell = row.createCell(16);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna17));
      cell = row.createCell(17);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna18));
      cell = row.createCell(18);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna19));
      cell = row.createCell(19);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna20));
      cell = row.createCell(20);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna21));
      cell = row.createCell(21);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna22));
      cell = row.createCell(22);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna23));
      cell = row.createCell(23);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna24));
      cell = row.createCell(24);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna25));
      cell = row.createCell(25);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna26));
      cell = row.createCell(26);
      cell.setCellValue("N");
      cell = row.createCell(27);
      cell.setCellValue("N");
      r++;
    }
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
    // scrivo il file di esito
    FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(_nfile));
    //write this workbook to an Outputstream.
    wb.write(fileOut);
    fileOut.flush();
    fileOut.close();
  }
  void Page_5() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* cNumInv := 0 */
      cNumInv = CPLib.Round(0,0);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* _idfile := LRTrim(nomefileimport) */
      _idfile = CPLib.LRTrim(nomefileimport);
      /* riga_letta := 0 // riga letta del file Excel */
      riga_letta = CPLib.Round(0,0);
      /* _i = 0 */
      CPLib.eqr(_i,0);
      /* Salta la prima riga in quanti dice solo cose di trasmissione */
      /* Legge il file */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000248status;
      nTry00000248status = m_Sql.GetTransactionStatus();
      String cTry00000248msg;
      cTry00000248msg = m_Sql.TransactionErrorMessage();
      try {
        //base
        InputStream ExcelFileToRead = new FileInputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomefileimport));
        XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
        _conta = wb.getNumberOfSheets();
        Row row; 
        Cell cell;
        int cellType;
        String[] colonna = new String[101];
        /* While _i < _conta */
        while (CPLib.lt(_i,_conta)) {
          //Apro uno ad uno i fogli del file Excel
          XSSFSheet sheet = wb.getSheetAt(_i);
          for (int rowNumber = sheet.getFirstRowNum(); rowNumber <= sheet.getLastRowNum(); rowNumber++) {
            row = sheet.getRow(rowNumber);
            if (row == null) {
                   // This row is completely empty
              } else {
          /* riga_letta := riga_letta+1 // riga letta del file Excel */
          riga_letta = CPLib.Round(riga_letta+1,0);
          /* If riga_letta > 1 */
          if (CPLib.gt(riga_letta,1)) {
            //scorro le colonne
            cell_count=0;
            /* While cell_count < 101 */
            while (CPLib.lt(cell_count,101)) {
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
            /* riga := LibreriaMit.SpacePad(LRTrim(colonna[0]),16) */
            riga = LibreriaMit.SpacePad(CPLib.LRTrim(colonna[0]),16);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[1]),50) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[1]),50);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[2]),50) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[2]),50);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[3]),100) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[3]),100);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[4]),1) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[4]),1);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[5]),16) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[5]),16);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[6]),50) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[6]),50);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[7]),30) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[7]),30);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[8]),8) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[8]),8);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[9]),8) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[9]),8);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[10]),50) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[10]),50);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[11]),50) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[11]),50);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[12]),50) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[12]),50);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[13]),2) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[13]),2);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[14]),8) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[14]),8);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[15]),1) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[15]),1);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[16]),1) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[16]),1);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[17]),15) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[17]),15);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[18]),15) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[18]),15);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[19]),10) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[19]),10);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[20]),10) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[20]),10);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[21]),100) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[21]),100);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[22]),100) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[22]),100);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[23]),100) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[23]),100);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[24]),30) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[24]),30);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[25]),30) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[25]),30);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[26]),10) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[26]),10);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[27]),8) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[27]),8);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[28]),1) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[28]),1);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[29]),4) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[29]),4);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[30]),1) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[30]),1);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[31]),5) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[31]),5);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[32]),18) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[32]),18);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[33]),2) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[33]),2);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[34]),5) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[34]),5);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[35]),1) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[35]),1);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[36]),2) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[36]),2);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[37]),3) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[37]),3);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[38]),10) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[38]),10);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[39]),2) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[39]),2);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[40]),2) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[40]),2);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[42]),50) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[42]),50);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[43]),3) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[43]),3);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[44]),6) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[44]),6);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[46]),10) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[46]),10);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[47]),10) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[47]),10);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[48]),1) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[48]),1);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[99]),1) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[99]),1);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[100]),1) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[100]),1);
            /* _abicab := LRTrim(colonna[41]) // Abi-Cab Bonifico */
            _abicab = CPLib.LRTrim(colonna[41]);
            /* _conto := LRTrim(colonna[45]) */
            _conto = CPLib.LRTrim(colonna[45]);
            /* If LRTrim(colonna[99])='S' or LRTrim(colonna[100])='S' */
            if (CPLib.eqr(CPLib.LRTrim(colonna[99]),"S") || CPLib.eqr(CPLib.LRTrim(colonna[100]),"S")) {
              /* gMsgImp := 'Elaborazione della transazione con n. folio: ' + colonna[32] // Messaggio Import */
              gMsgImp = "Elaborazione della transazione con n. folio: "+colonna[32];
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _i := 1 */
              _i = 1;
              /* _tiperr := '' */
              _tiperr = "";
              /* _listerr := '' */
              _listerr = "";
              /* _esito := 0 */
              _esito = CPLib.Round(0,0);
              /* xConnes := '' */
              xConnes = "";
              /* _tipoop := '' */
              _tipoop = "";
              /* _coddip := '' */
              _coddip = "";
              /* _uniquecode := '' */
              _uniquecode = "";
              /* _datope := NullDate() */
              _datope = CPLib.NullDate();
              /* _impstr := '' */
              _impstr = "";
              /* _importo := 0 */
              _importo = CPLib.Round(0,2);
              /* _statodest := '' */
              _statodest = "";
              /* _isodest := '' */
              _isodest = "";
              /* _cognome := '' */
              _cognome = "";
              /* _nome := '' */
              _nome = "";
              /* _citta := '' */
              _citta = "";
              /* _cap := '' */
              _cap = "";
              /* _via := '' */
              _via = "";
              /* _prov := '' */
              _prov = "";
              /* _cab := '' */
              _cab = "";
              /* _resstato := '' */
              _resstato = "";
              /* _cognomecp := '' */
              _cognomecp = "";
              /* _nomecp := '' */
              _nomecp = "";
              /* _sesso := '' */
              _sesso = "";
              /* _nascitta := '' */
              _nascitta = "";
              /* _nasstato := '' */
              _nasstato = "";
              /* _nasprov := '' */
              _nasprov = "";
              /* _nasdata := NullDate() */
              _nasdata = CPLib.NullDate();
              /* _tipodoc := '' */
              _tipodoc = "";
              /* _numdoc := '' */
              _numdoc = "";
              /* _docril := NullDate() */
              _docril = CPLib.NullDate();
              /* _autril := '' */
              _autril = "";
              /* _docsca := NullDate() */
              _docsca = CPLib.NullDate();
              /* _codfis := '' */
              _codfis = "";
              /* _ocodfis := '' */
              _ocodfis = "";
              /* _connes := '' */
              _connes = "";
              /* _doctype := '' */
              _doctype = "";
              /* _codana := '' */
              _codana = "";
              /* _codsin := '' */
              _codsin = "";
              /* _segno := '' */
              _segno = "";
              /* _nocf := 0 */
              _nocf = CPLib.Round(0,0);
              /* _txtope := '' */
              _txtope = "";
              /* _oldcodfis := '' */
              _oldcodfis = "";
              /* _oldmac := '' */
              _oldmac = "";
              /* _valuta := '' */
              _valuta = "";
              /* _valiso := '' */
              _valiso = "";
              /* _ndg := '' */
              _ndg = "";
              /* _cittaben := '' */
              _cittaben = "";
              /* _viaben := '' */
              _viaben = "";
              /* _cabben := '' */
              _cabben = "";
              /* _capben := '' */
              _capben = "";
              /* _prvben := '' */
              _prvben = "";
              /* _tipintcon := '' */
              _tipintcon = "";
              /* _desintcon := '' */
              _desintcon = "";
              /* _nazintcon := '' */
              _nazintcon = "";
              /* _cabintcon := '' */
              _cabintcon = "";
              /* _prvintcon := '' */
              _prvintcon = "";
              /* _abichk := '' */
              _abichk = "";
              /* _cambio := 0 */
              _cambio = CPLib.Round(0,4);
              /* _impin := 0 */
              _impin = CPLib.Round(0,2);
              /* _impout := 0 */
              _impout = CPLib.Round(0,2);
              /* _agente := '' */
              _agente = "";
              /* _prog := '' */
              _prog = "";
              /* _citdip := '' */
              _citdip = "";
              /* _cabdip := '' */
              _cabdip = "";
              /* _provdip := '' */
              _provdip = "";
              /* _err01 := '' */
              _err01 = "";
              /* _err02 := '' */
              _err02 = "";
              /* _err03 := '' */
              _err03 = "";
              /* _err04 := '' */
              _err04 = "";
              /* _err05 := '' */
              _err05 = "";
              /* _err06 := '' */
              _err06 = "";
              /* _err07 := '' */
              _err07 = "";
              /* _err08 := '' */
              _err08 = "";
              /* _err09 := '' */
              _err09 = "";
              /* _err10 := '' */
              _err10 = "";
              /* _err11 := '' */
              _err11 = "";
              /* _err12 := '' */
              _err12 = "";
              /* _err13 := '' */
              _err13 = "";
              /* _err14 := '' */
              _err14 = "";
              /* _err15 := '' */
              _err15 = "";
              /* _err16 := '' */
              _err16 = "";
              /* _err17 := '' */
              _err17 = "";
              /* _err18 := '' */
              _err18 = "";
              /* _err19 := '' */
              _err19 = "";
              /* _err20 := '' */
              _err20 = "";
              /* _err21 := '' */
              _err21 = "";
              /* _err22 := '' */
              _err22 = "";
              /* _err23 := '' */
              _err23 = "";
              /* _err24 := '' */
              _err24 = "";
              /* _err25 := '' */
              _err25 = "";
              /* _err26 := '' */
              _err26 = "";
              /* _err27 := '' */
              _err27 = "";
              /* _err28 := '' */
              _err28 = "";
              /* _err29 := '' */
              _err29 = "";
              /* _err30 := '' */
              _err30 = "";
              /* _err31 := '' */
              _err31 = "";
              /* _err32 := '' */
              _err32 = "";
              /* _err33 := '' */
              _err33 = "";
              /* _err34 := '' */
              _err34 = "";
              /* _err35 := '' */
              _err35 = "";
              /* _err36 := '' */
              _err36 = "";
              /* _err37 := '' */
              _err37 = "";
              /* _err38 := '' */
              _err38 = "";
              /* _err39 := '' */
              _err39 = "";
              /* _err40 := '' */
              _err40 = "";
              /* _err41 := '' */
              _err41 = "";
              /* _err42 := '' */
              _err42 = "";
              /* _err43 := '' */
              _err43 = "";
              /* _err44 := '' */
              _err44 = "";
              /* _err45 := '' */
              _err45 = "";
              /* _err46 := '' */
              _err46 = "";
              /* _err47 := '' */
              _err47 = "";
              /* _err48 := '' */
              _err48 = "";
              /* _err49 := '' */
              _err49 = "";
              /* If Substr(riga,925,1)='D' */
              if (CPLib.eqr(CPLib.Substr(riga,925,1),"D")) {
                /* cNumMod := cNumMod  + 1 */
                cNumMod = CPLib.Round(cNumMod+1,0);
                /* _uniquecode := LRTrim(Substr(riga,931,18)) */
                _uniquecode = CPLib.LRTrim(CPLib.Substr(riga,931,18));
                /* Exec "Cancellazione Transazione" Page 10:Page_10 */
                Page_10();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
              } else { // Else
                /* w_CODFISC := '' // Codice Fiscale */
                w_CODFISC = "";
                /* w_DATANASC := NullDate() // Data Nascita */
                w_DATANASC = CPLib.NullDate();
                /* w_NASCOMUN := '' // Luogo di Nascita */
                w_NASCOMUN = "";
                /* w_NASSTATO := '' // Stato di nascita */
                w_NASSTATO = "";
                /* w_COGNOME := '' // Ragione Sociale */
                w_COGNOME = "";
                /* w_RAGSOC := '' // Ragione Sociale */
                w_RAGSOC = "";
                /* w_NOME := '' // Ragione Sociale */
                w_NOME = "";
                /* w_SESSO := '' // Sesso */
                w_SESSO = "";
                /* _ndg := LRTrim(Left(riga,16)) */
                _ndg = CPLib.LRTrim(CPLib.Left(riga,16));
                /* _cognome := LRTrim(Substr(riga,17,50)) */
                _cognome = CPLib.LRTrim(CPLib.Substr(riga,17,50));
                /* _nome := LRTrim(Substr(riga,67,50)) */
                _nome = CPLib.LRTrim(CPLib.Substr(riga,67,50));
                /* _nocf := iif(Substr(riga,217,1)='S',0,iif(Substr(riga,217,1)='N',1,-1)) */
                _nocf = CPLib.Round((CPLib.eqr(CPLib.Substr(riga,217,1),"S")?0:(CPLib.eqr(CPLib.Substr(riga,217,1),"N")?1:-1)),0);
                /* _nasdata := CharToDate(Substr(riga,912,8)) */
                _nasdata = CPLib.CharToDate(CPLib.Substr(riga,912,8));
                /* _sesso := Substr(riga,920,1) */
                _sesso = CPLib.Substr(riga,920,1);
                /* _codfis := Upper(Substr(riga,218,16)) */
                _codfis = CPLib.Upper(CPLib.Substr(riga,218,16));
                /* If _nocf=0 */
                if (CPLib.eqr(_nocf,0)) {
                  /* _ocodfis := _codfis */
                  _ocodfis = _codfis;
                  /* If Substr(_codfis,12,1)='Z' */
                  if (CPLib.eqr(CPLib.Substr(_codfis,12,1),"Z")) {
                    /* _nasprov := 'EE' */
                    _nasprov = "EE";
                    /* _nasstato := '' */
                    _nasstato = "";
                    // * --- Read from tbstati
                    m_cServer = m_Ctx.GetServer("tbstati");
                    m_cPhName = m_Ctx.GetPhName("tbstati");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_codfis,12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(_codfis,12,4));
                    if (m_Ctx.IsSharedTemp("tbstati")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _nasstato = Read_Cursor.GetString("DESCRI");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _nasstato = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* If Empty(_nasstato) */
                    if (CPLib.Empty(_nasstato)) {
                      /* _nasstato := Substr(riga,234,40) */
                      _nasstato = CPLib.Substr(riga,234,40);
                    } // End If
                  } else { // Else
                    /* _nascitta := '' */
                    _nascitta = "";
                    /* _nasprov := '' */
                    _nasprov = "";
                    // * --- Read from tbcitta
                    m_cServer = m_Ctx.GetServer("tbcitta");
                    m_cPhName = m_Ctx.GetPhName("tbcitta");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_codfis,12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(_codfis,12,4));
                    if (m_Ctx.IsSharedTemp("tbcitta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _nasprov = Read_Cursor.GetString("PROV");
                      _nascitta = Read_Cursor.GetString("CITTA");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _nasprov = "";
                      _nascitta = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* If Empty(_nascitta) */
                    if (CPLib.Empty(_nascitta)) {
                      /* _nascitta := Substr(riga,234,40) */
                      _nascitta = CPLib.Substr(riga,234,40);
                    } // End If
                  } // End If
                } else { // Else
                  /* _nasprov := '' */
                  _nasprov = "";
                  /* _nasstato := '' */
                  _nasstato = "";
                  /* _nascitta := '' */
                  _nascitta = "";
                  /* If not(Empty(Substr(riga,234,50))) */
                  if ( ! (CPLib.Empty(CPLib.Substr(riga,234,50)))) {
                    /* _codstanas := '' */
                    _codstanas = "";
                    /* _luonas := LRTrim(Substr(riga,234,50)) */
                    _luonas = CPLib.LRTrim(CPLib.Substr(riga,234,50));
                    // * --- Read from tbstati
                    m_cServer = m_Ctx.GetServer("tbstati");
                    m_cPhName = m_Ctx.GetPhName("tbstati");
                    m_cSql = "";
                    m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_luonas),"C",40,0,m_cServer),m_cServer,CPLib.LRTrim(_luonas));
                    if (m_Ctx.IsSharedTemp("tbstati")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _codstanas = Read_Cursor.GetString("CODSTA");
                      _nasstato = Read_Cursor.GetString("DESCRI");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _codstanas = "";
                      _nasstato = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* If not(Empty(_codstanas)) */
                    if ( ! (CPLib.Empty(_codstanas))) {
                      /* _nasprov := 'EE' */
                      _nasprov = "EE";
                    } else { // Else
                      // * --- Read from tbcitta
                      m_cServer = m_Ctx.GetServer("tbcitta");
                      m_cPhName = m_Ctx.GetPhName("tbcitta");
                      m_cSql = "";
                      m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_luonas,"C",60,0,m_cServer),m_cServer,_luonas);
                      if (m_Ctx.IsSharedTemp("tbcitta")) {
                        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                      }
                      if (Read_Cursor!=null)
                        Read_Cursor.Close();
                      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                      if ( ! (Read_Cursor.Eof())) {
                        _nasprov = Read_Cursor.GetString("PROV");
                        _nascitta = Read_Cursor.GetString("CITTA");
                        Read_Cursor.Next();
                        if ( ! (Read_Cursor.Eof())) {
                          Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                          CPStdCounter.Error(l_oErrorFault);
                        }
                        Read_Cursor.Close();
                      } else {
                        // Error: no record found!
                        _nasprov = "";
                        _nascitta = "";
                        Read_Cursor.Close();
                        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                      }
                    } // End If
                  } // End If
                } // End If
                /* _numdoc := LRTrim(Substr(riga,284,30)) */
                _numdoc = CPLib.LRTrim(CPLib.Substr(riga,284,30));
                /* _docril := CharToDate(Substr(riga,322,8)) */
                _docril = CPLib.CharToDate(CPLib.Substr(riga,322,8));
                /* _docsca := CharToDate(Substr(riga,314,8)) */
                _docsca = CPLib.CharToDate(CPLib.Substr(riga,314,8));
                /* _autril := LRTrim(Substr(riga,330,50)) */
                _autril = CPLib.LRTrim(CPLib.Substr(riga,330,50));
                /* _doctype := LRTrim(Substr(riga,480,2)) */
                _doctype = CPLib.LRTrim(CPLib.Substr(riga,480,2));
                /* _tipodoc := LRTrim(Substr(riga,480,2)) */
                _tipodoc = CPLib.LRTrim(CPLib.Substr(riga,480,2));
                /* _via := LRTrim(Substr(riga,117,35)) */
                _via = CPLib.LRTrim(CPLib.Substr(riga,117,35));
                /* _citta := Upper(Substr(riga,430,40)) */
                _citta = CPLib.Upper(CPLib.Substr(riga,430,40));
                /* _codcit := '' */
                _codcit = "";
                /* If not(Empty(LRTrim(_citta))) */
                if ( ! (CPLib.Empty(CPLib.LRTrim(_citta)))) {
                  // * --- Read from tbcitta
                  m_cServer = m_Ctx.GetServer("tbcitta");
                  m_cPhName = m_Ctx.GetPhName("tbcitta");
                  m_cSql = "";
                  m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_citta,"C",60,0,m_cServer),m_cServer,_citta);
                  if (m_Ctx.IsSharedTemp("tbcitta")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _codcit = Read_Cursor.GetString("IDBASE");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _codcit = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } // End If
                /* _paese := Upper(Substr(riga,380,40)) */
                _paese = CPLib.Upper(CPLib.Substr(riga,380,40));
                /* _codstares := '' */
                _codstares = "";
                /* If not(Empty(LRTrim(_paese))) */
                if ( ! (CPLib.Empty(CPLib.LRTrim(_paese)))) {
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paese,"C",40,0,m_cServer),m_cServer,_paese);
                  if (m_Ctx.IsSharedTemp("tbstati")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _codstares = Read_Cursor.GetString("CODSTA");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _codstares = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } // End If
                /* _cap := LRTrim(Substr(riga,902,5)) */
                _cap = CPLib.LRTrim(CPLib.Substr(riga,902,5));
                /* _cognomecp := LRTrim(Substr(riga,542,100)) */
                _cognomecp = CPLib.LRTrim(CPLib.Substr(riga,542,100));
                /* _nomecp := LRTrim(Substr(riga,642,100)) */
                _nomecp = CPLib.LRTrim(CPLib.Substr(riga,642,100));
                /* _statodest := Substr(riga,742,100) */
                _statodest = CPLib.Substr(riga,742,100);
                /* _uifdest := '' */
                _uifdest = "";
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(_statodest,40)),"C",40,0,m_cServer),m_cServer,CPLib.LRTrim(CPLib.Left(_statodest,40)));
                if (m_Ctx.IsSharedTemp("tbstati")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _uifdest = Read_Cursor.GetString("CODSTA");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _uifdest = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If _statodest='ITALIA' */
                if (CPLib.eqr(_statodest,"ITALIA")) {
                  /* _cittaben := Substr(riga,842,30) */
                  _cittaben = CPLib.Substr(riga,842,30);
                  /* _viaben := Substr(riga,872,30) */
                  _viaben = CPLib.Substr(riga,872,30);
                  // * --- Read from tbcitta
                  m_cServer = m_Ctx.GetServer("tbcitta");
                  m_cPhName = m_Ctx.GetPhName("tbcitta");
                  m_cSql = "";
                  m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cittaben,"C",60,0,m_cServer),m_cServer,_cittaben);
                  if (m_Ctx.IsSharedTemp("tbcitta")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _cabben = Read_Cursor.GetString("CAB");
                    _prvben = Read_Cursor.GetString("PROV");
                    _capben = Read_Cursor.GetString("CAP");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _cabben = "";
                    _prvben = "";
                    _capben = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } // End If
                /* _datope := CharToDate(Substr(riga,482,8)) */
                _datope = CPLib.CharToDate(CPLib.Substr(riga,482,8));
                /* _impstr := LRTrim(Substr(riga,492,15)) */
                _impstr = CPLib.LRTrim(CPLib.Substr(riga,492,15));
                /* _importo := Val(_impstr) */
                _importo = CPLib.Round(CPLib.Val(_impstr),2);
                /* _impstr := LRTrim(Substr(riga,507,15)) */
                _impstr = CPLib.LRTrim(CPLib.Substr(riga,507,15));
                /* _contanti := Val(_impstr) */
                _contanti = CPLib.Round(CPLib.Val(_impstr),2);
                /* _flgcash := LRTrim(Substr(riga,490,1)) */
                _flgcash = CPLib.LRTrim(CPLib.Substr(riga,490,1));
                /* _cambio := Val(LRTrim(Substr(riga,522,10))) / 10000 */
                _cambio = CPLib.Round(CPLib.Val(CPLib.LRTrim(CPLib.Substr(riga,522,10)))/10000,4);
                /* _valiso := LRTrim(Substr(riga,921,3)) */
                _valiso = CPLib.LRTrim(CPLib.Substr(riga,921,3));
                /* If At(Substr(riga,490,1),'|C|V') <> 0 */
                if (CPLib.ne(CPLib.At(CPLib.Substr(riga,490,1),"|C|V"),0)) {
                  /* _impin := Val(Substr(riga,1035,10)) / 100 */
                  _impin = CPLib.Round(CPLib.Val(CPLib.Substr(riga,1035,10))/100,2);
                  /* _impout := Val(Substr(riga,1045,10)) / 100 */
                  _impout = CPLib.Round(CPLib.Val(CPLib.Substr(riga,1045,10))/100,2);
                  /* _tipope := '10' */
                  _tipope = "10";
                  /* If Substr(riga,490,1)='C' */
                  if (CPLib.eqr(CPLib.Substr(riga,490,1),"C")) {
                    /* _codana := 'DB' */
                    _codana = "DB";
                    /* _codsin := '' */
                    _codsin = "";
                    /* _segno := 'A' */
                    _segno = "A";
                  } else { // Else
                    /* _codana := 'DC' */
                    _codana = "DC";
                    /* _codsin := '' */
                    _codsin = "";
                    /* _segno := 'D' */
                    _segno = "D";
                  } // End If
                } else { // Else
                  /* _impin := 0 */
                  _impin = CPLib.Round(0,2);
                  /* _impout := 0 */
                  _impout = CPLib.Round(0,2);
                  /* If _flgcash='S' */
                  if (CPLib.eqr(_flgcash,"S")) {
                    /* _tipope := '10' */
                    _tipope = "10";
                  } else { // Else
                    /* If Substr(riga,491,1)='D' */
                    if (CPLib.eqr(CPLib.Substr(riga,491,1),"D")) {
                      /* _tipope := '11' */
                      _tipope = "11";
                    } else { // Else
                      /* _tipope := '12' */
                      _tipope = "12";
                    } // End If
                  } // End If
                  /* If Substr(riga,491,1)='D' */
                  if (CPLib.eqr(CPLib.Substr(riga,491,1),"D")) {
                    /* If _statodest='ITALIA' */
                    if (CPLib.eqr(_statodest,"ITALIA")) {
                      /* _codana := '26' */
                      _codana = "26";
                    } else { // Else
                      /* _codana := 'AA' */
                      _codana = "AA";
                    } // End If
                    /* _codsin := '3M' */
                    _codsin = "3M";
                    /* _segno := 'D' */
                    _segno = "D";
                    /* ElseIf Substr(riga,491,1)='A' */
                  } else if (CPLib.eqr(CPLib.Substr(riga,491,1),"A")) {
                    /* If _statodest='ITALIA' */
                    if (CPLib.eqr(_statodest,"ITALIA")) {
                      /* _codana := '48' */
                      _codana = "48";
                    } else { // Else
                      /* _codana := 'AA' */
                      _codana = "AA";
                    } // End If
                    /* _codsin := '4M' */
                    _codsin = "4M";
                    /* _segno := 'A' */
                    _segno = "A";
                  } // End If
                } // End If
                /* _uniquecode := Substr(riga,931,18) */
                _uniquecode = CPLib.Substr(riga,931,18);
                /* _coddip := Substr(riga,532,6) */
                _coddip = CPLib.Substr(riga,532,6);
                // * --- Read from tbvalute
                m_cServer = m_Ctx.GetServer("tbvalute");
                m_cPhName = m_Ctx.GetPhName("tbvalute");
                m_cSql = "";
                m_cSql = m_cSql+"ISO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_valiso,"C",3,0,m_cServer),m_cServer,_valiso);
                if (m_Ctx.IsSharedTemp("tbvalute")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODVAL",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _valuta = Read_Cursor.GetString("CODVAL");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbvalute into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _valuta = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Substr(riga,974,2)='02' */
                if (CPLib.eqr(CPLib.Substr(riga,974,2),"02")) {
                  // * --- Read from inter2bo
                  m_cServer = m_Ctx.GetServer("inter2bo");
                  m_cPhName = m_Ctx.GetPhName("inter2bo");
                  m_cSql = "";
                  m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(_abicab,"C",11,0,m_cServer),m_cServer,_abicab);
                  if (m_Ctx.IsSharedTemp("inter2bo")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PAESE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODINTER",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPINTER",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _desintcon = Read_Cursor.GetString("RAGSOC");
                    _cabintcon = Read_Cursor.GetString("CODCAB");
                    _prvintcon = Read_Cursor.GetString("PROVINCIA");
                    _nazintcon = Read_Cursor.GetString("PAESE");
                    _abichk = Read_Cursor.GetString("CODINTER");
                    _tipintcon = Read_Cursor.GetString("TIPINTER");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on inter2bo into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _desintcon = "";
                    _cabintcon = "";
                    _prvintcon = "";
                    _nazintcon = "";
                    _abichk = "";
                    _tipintcon = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } else { // Else
                  /* _tipintcon := Substr(riga,974,2) */
                  _tipintcon = CPLib.Substr(riga,974,2);
                  /* _desintcon := Substr(riga,976,50) */
                  _desintcon = CPLib.Substr(riga,976,50);
                  /* _nazintcon := Substr(riga,1026,3) */
                  _nazintcon = CPLib.Substr(riga,1026,3);
                  /* _cabintcon := Substr(riga,1029,6) */
                  _cabintcon = CPLib.Substr(riga,1029,6);
                } // End If
                /* rowErrate.colonna01 := LRTrim(colonna[0]) */
                rowErrate.colonna01 = CPLib.LRTrim(colonna[0]);
                /* rowErrate.colonna02 := LRTrim(colonna[1]) */
                rowErrate.colonna02 = CPLib.LRTrim(colonna[1]);
                /* rowErrate.colonna03 := LRTrim(colonna[2]) */
                rowErrate.colonna03 = CPLib.LRTrim(colonna[2]);
                /* rowErrate.colonna04 := LRTrim(colonna[3]) */
                rowErrate.colonna04 = CPLib.LRTrim(colonna[3]);
                /* rowErrate.colonna05 := LRTrim(colonna[4]) */
                rowErrate.colonna05 = CPLib.LRTrim(colonna[4]);
                /* rowErrate.colonna06 := LRTrim(colonna[5]) */
                rowErrate.colonna06 = CPLib.LRTrim(colonna[5]);
                /* rowErrate.colonna07 := LRTrim(colonna[6]) */
                rowErrate.colonna07 = CPLib.LRTrim(colonna[6]);
                /* rowErrate.colonna08 := LRTrim(colonna[7]) */
                rowErrate.colonna08 = CPLib.LRTrim(colonna[7]);
                /* rowErrate.colonna09 := LRTrim(colonna[8]) */
                rowErrate.colonna09 = CPLib.LRTrim(colonna[8]);
                /* rowErrate.colonna10 := LRTrim(colonna[9]) */
                rowErrate.colonna10 = CPLib.LRTrim(colonna[9]);
                /* rowErrate.colonna11 := LRTrim(colonna[10]) */
                rowErrate.colonna11 = CPLib.LRTrim(colonna[10]);
                /* rowErrate.colonna12 := LRTrim(colonna[11]) */
                rowErrate.colonna12 = CPLib.LRTrim(colonna[11]);
                /* rowErrate.colonna13 := LRTrim(colonna[12]) */
                rowErrate.colonna13 = CPLib.LRTrim(colonna[12]);
                /* rowErrate.colonna14 := LRTrim(colonna[13]) */
                rowErrate.colonna14 = CPLib.LRTrim(colonna[13]);
                /* rowErrate.colonna15 := LRTrim(colonna[14]) */
                rowErrate.colonna15 = CPLib.LRTrim(colonna[14]);
                /* rowErrate.colonna16 := LRTrim(colonna[15]) */
                rowErrate.colonna16 = CPLib.LRTrim(colonna[15]);
                /* rowErrate.colonna17 := LRTrim(colonna[16]) */
                rowErrate.colonna17 = CPLib.LRTrim(colonna[16]);
                /* rowErrate.colonna18 := LRTrim(colonna[17]) */
                rowErrate.colonna18 = CPLib.LRTrim(colonna[17]);
                /* rowErrate.colonna19 := LRTrim(colonna[18]) */
                rowErrate.colonna19 = CPLib.LRTrim(colonna[18]);
                /* rowErrate.colonna20 := LRTrim(colonna[19]) */
                rowErrate.colonna20 = CPLib.LRTrim(colonna[19]);
                /* rowErrate.colonna21 := LRTrim(colonna[20]) */
                rowErrate.colonna21 = CPLib.LRTrim(colonna[20]);
                /* rowErrate.colonna22 := LRTrim(colonna[21]) */
                rowErrate.colonna22 = CPLib.LRTrim(colonna[21]);
                /* rowErrate.colonna23 := LRTrim(colonna[22]) */
                rowErrate.colonna23 = CPLib.LRTrim(colonna[22]);
                /* rowErrate.colonna24 := LRTrim(colonna[23]) */
                rowErrate.colonna24 = CPLib.LRTrim(colonna[23]);
                /* rowErrate.colonna25 := LRTrim(colonna[24]) */
                rowErrate.colonna25 = CPLib.LRTrim(colonna[24]);
                /* rowErrate.colonna26 := LRTrim(colonna[25]) */
                rowErrate.colonna26 = CPLib.LRTrim(colonna[25]);
                /* rowErrate.colonna27 := LRTrim(colonna[26]) */
                rowErrate.colonna27 = CPLib.LRTrim(colonna[26]);
                /* rowErrate.colonna28 := LRTrim(colonna[27]) */
                rowErrate.colonna28 = CPLib.LRTrim(colonna[27]);
                /* rowErrate.colonna29 := LRTrim(colonna[28]) */
                rowErrate.colonna29 = CPLib.LRTrim(colonna[28]);
                /* rowErrate.colonna30 := LRTrim(colonna[29]) */
                rowErrate.colonna30 = CPLib.LRTrim(colonna[29]);
                /* rowErrate.colonna31 := LRTrim(colonna[30]) */
                rowErrate.colonna31 = CPLib.LRTrim(colonna[30]);
                /* rowErrate.colonna32 := LRTrim(colonna[31]) */
                rowErrate.colonna32 = CPLib.LRTrim(colonna[31]);
                /* rowErrate.colonna33 := LRTrim(colonna[32]) */
                rowErrate.colonna33 = CPLib.LRTrim(colonna[32]);
                /* rowErrate.colonna34 := LRTrim(colonna[33]) */
                rowErrate.colonna34 = CPLib.LRTrim(colonna[33]);
                /* rowErrate.colonna35 := LRTrim(colonna[34]) */
                rowErrate.colonna35 = CPLib.LRTrim(colonna[34]);
                /* rowErrate.colonna36 := LRTrim(colonna[35]) */
                rowErrate.colonna36 = CPLib.LRTrim(colonna[35]);
                /* rowErrate.colonna37 := LRTrim(colonna[36]) */
                rowErrate.colonna37 = CPLib.LRTrim(colonna[36]);
                /* rowErrate.colonna38 := LRTrim(colonna[37]) */
                rowErrate.colonna38 = CPLib.LRTrim(colonna[37]);
                /* rowErrate.colonna39 := LRTrim(colonna[38]) */
                rowErrate.colonna39 = CPLib.LRTrim(colonna[38]);
                /* rowErrate.colonna40 := LRTrim(colonna[39]) */
                rowErrate.colonna40 = CPLib.LRTrim(colonna[39]);
                /* rowErrate.colonna41 := LRTrim(colonna[40]) */
                rowErrate.colonna41 = CPLib.LRTrim(colonna[40]);
                /* rowErrate.colonna42 := LRTrim(colonna[41]) */
                rowErrate.colonna42 = CPLib.LRTrim(colonna[41]);
                /* rowErrate.colonna43 := LRTrim(colonna[42]) */
                rowErrate.colonna43 = CPLib.LRTrim(colonna[42]);
                /* rowErrate.colonna44 := LRTrim(colonna[43]) */
                rowErrate.colonna44 = CPLib.LRTrim(colonna[43]);
                /* rowErrate.colonna45 := LRTrim(colonna[44]) */
                rowErrate.colonna45 = CPLib.LRTrim(colonna[44]);
                /* rowErrate.colonna46 := LRTrim(colonna[45]) */
                rowErrate.colonna46 = CPLib.LRTrim(colonna[45]);
                /* rowErrate.colonna47 := LRTrim(colonna[46]) */
                rowErrate.colonna47 = CPLib.LRTrim(colonna[46]);
                /* rowErrate.colonna48 := LRTrim(colonna[47]) */
                rowErrate.colonna48 = CPLib.LRTrim(colonna[47]);
                /* rowErrate.colonna49 := LRTrim(colonna[48]) */
                rowErrate.colonna49 = CPLib.LRTrim(colonna[48]);
                // * --- Read from anadip
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_cSql = "";
                m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(_coddip,"C",6,0,m_cServer),m_cServer,_coddip);
                if (m_Ctx.IsSharedTemp("anadip")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODDIP",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("AGENTE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _prog = Read_Cursor.GetString("CODDIP");
                  _agente = Read_Cursor.GetString("AGENTE");
                  _citdip = Read_Cursor.GetString("DESCCIT");
                  _cabdip = Read_Cursor.GetString("CAB");
                  _provdip = Read_Cursor.GetString("PROVINCIA");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _prog = "";
                  _agente = "";
                  _citdip = "";
                  _cabdip = "";
                  _provdip = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If LRTrim(colonna[100])='N' */
                if (CPLib.eqr(CPLib.LRTrim(colonna[100]),"N")) {
                  /* Exec "Controllo Transazione" Page 6:Page_6 */
                  Page_6();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
                /* If _esito=1 */
                if (CPLib.eqr(_esito,1)) {
                  /* _nerrori := _nerrori + 1 */
                  _nerrori = CPLib.Round(_nerrori+1,0);
                  /* rowErrate.colonna50 := _err01 */
                  rowErrate.colonna50 = _err01;
                  /* rowErrate.colonna51 := _err02 */
                  rowErrate.colonna51 = _err02;
                  /* rowErrate.colonna52 := _err03 */
                  rowErrate.colonna52 = _err03;
                  /* rowErrate.colonna53 := _err04 */
                  rowErrate.colonna53 = _err04;
                  /* rowErrate.colonna54 := _err05 */
                  rowErrate.colonna54 = _err05;
                  /* rowErrate.colonna55 := _err06 */
                  rowErrate.colonna55 = _err06;
                  /* rowErrate.colonna56 := _err07 */
                  rowErrate.colonna56 = _err07;
                  /* rowErrate.colonna57 := _err08 */
                  rowErrate.colonna57 = _err08;
                  /* rowErrate.colonna58 := _err09 */
                  rowErrate.colonna58 = _err09;
                  /* rowErrate.colonna59 := _err10 */
                  rowErrate.colonna59 = _err10;
                  /* rowErrate.colonna60 := _err11 */
                  rowErrate.colonna60 = _err11;
                  /* rowErrate.colonna61 := _err12 */
                  rowErrate.colonna61 = _err12;
                  /* rowErrate.colonna62 := _err13 */
                  rowErrate.colonna62 = _err13;
                  /* rowErrate.colonna63 := _err14 */
                  rowErrate.colonna63 = _err14;
                  /* rowErrate.colonna64 := _err15 */
                  rowErrate.colonna64 = _err15;
                  /* rowErrate.colonna65 := _err16 */
                  rowErrate.colonna65 = _err16;
                  /* rowErrate.colonna66 := _err17 */
                  rowErrate.colonna66 = _err17;
                  /* rowErrate.colonna67 := _err18 */
                  rowErrate.colonna67 = _err18;
                  /* rowErrate.colonna68 := _err19 */
                  rowErrate.colonna68 = _err19;
                  /* rowErrate.colonna69 := _err20 */
                  rowErrate.colonna69 = _err20;
                  /* rowErrate.colonna70 := _err21 */
                  rowErrate.colonna70 = _err21;
                  /* rowErrate.colonna71 := _err22 */
                  rowErrate.colonna71 = _err22;
                  /* rowErrate.colonna72 := _err23 */
                  rowErrate.colonna72 = _err23;
                  /* rowErrate.colonna73 := _err24 */
                  rowErrate.colonna73 = _err24;
                  /* rowErrate.colonna74 := _err25 */
                  rowErrate.colonna74 = _err25;
                  /* rowErrate.colonna75 := _err26 */
                  rowErrate.colonna75 = _err26;
                  /* rowErrate.colonna76 := _err27 */
                  rowErrate.colonna76 = _err27;
                  /* rowErrate.colonna77 := _err28 */
                  rowErrate.colonna77 = _err28;
                  /* rowErrate.colonna78 := _err29 */
                  rowErrate.colonna78 = _err29;
                  /* rowErrate.colonna79 := _err30 */
                  rowErrate.colonna79 = _err30;
                  /* rowErrate.colonna80 := _err31 */
                  rowErrate.colonna80 = _err31;
                  /* rowErrate.colonna81 := _err32 */
                  rowErrate.colonna81 = _err32;
                  /* rowErrate.colonna82 := _err33 */
                  rowErrate.colonna82 = _err33;
                  /* rowErrate.colonna83 := _err34 */
                  rowErrate.colonna83 = _err34;
                  /* rowErrate.colonna84 := _err35 */
                  rowErrate.colonna84 = _err35;
                  /* rowErrate.colonna85 := _err36 */
                  rowErrate.colonna85 = _err36;
                  /* rowErrate.colonna86 := _err37 */
                  rowErrate.colonna86 = _err37;
                  /* rowErrate.colonna87 := _err38 */
                  rowErrate.colonna87 = _err38;
                  /* rowErrate.colonna88 := _err39 */
                  rowErrate.colonna88 = _err39;
                  /* rowErrate.colonna89 := _err40 */
                  rowErrate.colonna89 = _err40;
                  /* rowErrate.colonna90 := _err41 */
                  rowErrate.colonna90 = _err41;
                  /* rowErrate.colonna91 := _err42 */
                  rowErrate.colonna91 = _err42;
                  /* rowErrate.colonna92 := _err43 */
                  rowErrate.colonna92 = _err43;
                  /* rowErrate.colonna93 := _err44 */
                  rowErrate.colonna93 = _err44;
                  /* rowErrate.colonna94 := _err45 */
                  rowErrate.colonna94 = _err45;
                  /* rowErrate.colonna95 := _err46 */
                  rowErrate.colonna95 = _err46;
                  /* rowErrate.colonna96 := _err47 */
                  rowErrate.colonna96 = _err47;
                  /* rowErrate.colonna97 := _err48 */
                  rowErrate.colonna97 = _err48;
                  /* rowErrate.colonna98 := _err49 */
                  rowErrate.colonna98 = _err49;
                  /* rowErrate.colonna99 := _err50 */
                  rowErrate.colonna99 = _err50;
                  /* mcErrate.AppendRow(rowErrate) */
                  mcErrate.AppendRow(rowErrate);
                } // End If
                /* If _esito = 0 */
                if (CPLib.eqr(_esito,0)) {
                  /* w_destfin := iif(_agente='S','O','F') */
                  w_destfin = (CPLib.eqr(_agente,"S")?"O":"F");
                  /* Exec "Scrittura Dati Soggetto" Page 8:Page_8 */
                  Page_8();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* If At(Substr(riga,490,1),'|C|V') = 0 */
                  if (CPLib.eqr(CPLib.At(CPLib.Substr(riga,490,1),"|C|V"),0)) {
                    /* Exec "Scrittura Dati Transazione" Page 9:Page_9 */
                    Page_9();
                    if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                      throw new RoutineException();
                    }
                  } else { // Else
                    /* Exec "Scrittura Dati Cambiavalute" Page 11:Page_11 */
                    Page_11();
                    if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                      throw new RoutineException();
                    }
                  } // End If
                } // End If
              } // End If
            } else { // Else
              /* _nerrori := _nerrori + 1 */
              _nerrori = CPLib.Round(_nerrori+1,0);
              /* rowErrate.colonna01 := colonna[0] */
              rowErrate.colonna01 = colonna[0];
              /* rowErrate.colonna02 := colonna[1] */
              rowErrate.colonna02 = colonna[1];
              /* rowErrate.colonna03 := colonna[2] */
              rowErrate.colonna03 = colonna[2];
              /* rowErrate.colonna04 := colonna[3] */
              rowErrate.colonna04 = colonna[3];
              /* rowErrate.colonna05 := colonna[4] */
              rowErrate.colonna05 = colonna[4];
              /* rowErrate.colonna06 := colonna[5] */
              rowErrate.colonna06 = colonna[5];
              /* rowErrate.colonna07 := colonna[6] */
              rowErrate.colonna07 = colonna[6];
              /* rowErrate.colonna08 := colonna[7] */
              rowErrate.colonna08 = colonna[7];
              /* rowErrate.colonna09 := colonna[8] */
              rowErrate.colonna09 = colonna[8];
              /* rowErrate.colonna10 := colonna[9] */
              rowErrate.colonna10 = colonna[9];
              /* rowErrate.colonna11 := colonna[10] */
              rowErrate.colonna11 = colonna[10];
              /* rowErrate.colonna12 := colonna[11] */
              rowErrate.colonna12 = colonna[11];
              /* rowErrate.colonna13 := colonna[12] */
              rowErrate.colonna13 = colonna[12];
              /* rowErrate.colonna14 := colonna[13] */
              rowErrate.colonna14 = colonna[13];
              /* rowErrate.colonna15 := colonna[14] */
              rowErrate.colonna15 = colonna[14];
              /* rowErrate.colonna16 := colonna[15] */
              rowErrate.colonna16 = colonna[15];
              /* rowErrate.colonna17 := colonna[16] */
              rowErrate.colonna17 = colonna[16];
              /* rowErrate.colonna18 := colonna[17] */
              rowErrate.colonna18 = colonna[17];
              /* rowErrate.colonna19 := colonna[18] */
              rowErrate.colonna19 = colonna[18];
              /* rowErrate.colonna20 := colonna[19] */
              rowErrate.colonna20 = colonna[19];
              /* rowErrate.colonna21 := colonna[20] */
              rowErrate.colonna21 = colonna[20];
              /* rowErrate.colonna22 := colonna[21] */
              rowErrate.colonna22 = colonna[21];
              /* rowErrate.colonna23 := colonna[22] */
              rowErrate.colonna23 = colonna[22];
              /* rowErrate.colonna24 := colonna[23] */
              rowErrate.colonna24 = colonna[23];
              /* rowErrate.colonna25 := colonna[24] */
              rowErrate.colonna25 = colonna[24];
              /* rowErrate.colonna26 := colonna[25] */
              rowErrate.colonna26 = colonna[25];
              /* rowErrate.colonna27 := colonna[26] */
              rowErrate.colonna27 = colonna[26];
              /* rowErrate.colonna28 := colonna[27] */
              rowErrate.colonna28 = colonna[27];
              /* rowErrate.colonna29 := colonna[28] */
              rowErrate.colonna29 = colonna[28];
              /* rowErrate.colonna30 := colonna[29] */
              rowErrate.colonna30 = colonna[29];
              /* rowErrate.colonna31 := colonna[30] */
              rowErrate.colonna31 = colonna[30];
              /* rowErrate.colonna32 := colonna[31] */
              rowErrate.colonna32 = colonna[31];
              /* rowErrate.colonna33 := colonna[32] */
              rowErrate.colonna33 = colonna[32];
              /* rowErrate.colonna34 := colonna[33] */
              rowErrate.colonna34 = colonna[33];
              /* rowErrate.colonna35 := colonna[34] */
              rowErrate.colonna35 = colonna[34];
              /* rowErrate.colonna36 := colonna[35] */
              rowErrate.colonna36 = colonna[35];
              /* rowErrate.colonna37 := colonna[36] */
              rowErrate.colonna37 = colonna[36];
              /* rowErrate.colonna38 := colonna[37] */
              rowErrate.colonna38 = colonna[37];
              /* rowErrate.colonna39 := colonna[38] */
              rowErrate.colonna39 = colonna[38];
              /* rowErrate.colonna40 := colonna[39] */
              rowErrate.colonna40 = colonna[39];
              /* rowErrate.colonna41 := colonna[40] */
              rowErrate.colonna41 = colonna[40];
              /* rowErrate.colonna42 := colonna[41] */
              rowErrate.colonna42 = colonna[41];
              /* rowErrate.colonna43 := colonna[42] */
              rowErrate.colonna43 = colonna[42];
              /* rowErrate.colonna44 := colonna[43] */
              rowErrate.colonna44 = colonna[43];
              /* rowErrate.colonna45 := colonna[44] */
              rowErrate.colonna45 = colonna[44];
              /* rowErrate.colonna46 := colonna[45] */
              rowErrate.colonna46 = colonna[45];
              /* rowErrate.colonna47 := colonna[46] */
              rowErrate.colonna47 = colonna[46];
              /* rowErrate.colonna48 := colonna[47] */
              rowErrate.colonna48 = colonna[47];
              /* rowErrate.colonna49 := colonna[48] */
              rowErrate.colonna49 = colonna[48];
              /* rowErrate.colonna50 := colonna[49] */
              rowErrate.colonna50 = colonna[49];
              /* rowErrate.colonna51 := colonna[50] */
              rowErrate.colonna51 = colonna[50];
              /* rowErrate.colonna52 := colonna[51] */
              rowErrate.colonna52 = colonna[51];
              /* rowErrate.colonna53 := colonna[52] */
              rowErrate.colonna53 = colonna[52];
              /* rowErrate.colonna54 := colonna[53] */
              rowErrate.colonna54 = colonna[53];
              /* rowErrate.colonna55 := colonna[54] */
              rowErrate.colonna55 = colonna[54];
              /* rowErrate.colonna56 := colonna[55] */
              rowErrate.colonna56 = colonna[55];
              /* rowErrate.colonna57 := colonna[56] */
              rowErrate.colonna57 = colonna[56];
              /* rowErrate.colonna58 := colonna[57] */
              rowErrate.colonna58 = colonna[57];
              /* rowErrate.colonna59 := colonna[58] */
              rowErrate.colonna59 = colonna[58];
              /* rowErrate.colonna60 := colonna[59] */
              rowErrate.colonna60 = colonna[59];
              /* rowErrate.colonna61 := colonna[60] */
              rowErrate.colonna61 = colonna[60];
              /* rowErrate.colonna62 := colonna[61] */
              rowErrate.colonna62 = colonna[61];
              /* rowErrate.colonna63 := colonna[62] */
              rowErrate.colonna63 = colonna[62];
              /* rowErrate.colonna64 := colonna[63] */
              rowErrate.colonna64 = colonna[63];
              /* rowErrate.colonna65 := colonna[64] */
              rowErrate.colonna65 = colonna[64];
              /* rowErrate.colonna66 := colonna[65] */
              rowErrate.colonna66 = colonna[65];
              /* rowErrate.colonna67 := colonna[66] */
              rowErrate.colonna67 = colonna[66];
              /* rowErrate.colonna68 := colonna[67] */
              rowErrate.colonna68 = colonna[67];
              /* rowErrate.colonna69 := colonna[68] */
              rowErrate.colonna69 = colonna[68];
              /* rowErrate.colonna70 := colonna[69] */
              rowErrate.colonna70 = colonna[69];
              /* rowErrate.colonna71 := colonna[70] */
              rowErrate.colonna71 = colonna[70];
              /* rowErrate.colonna72 := colonna[71] */
              rowErrate.colonna72 = colonna[71];
              /* rowErrate.colonna73 := colonna[72] */
              rowErrate.colonna73 = colonna[72];
              /* rowErrate.colonna74 := colonna[73] */
              rowErrate.colonna74 = colonna[73];
              /* rowErrate.colonna75 := colonna[74] */
              rowErrate.colonna75 = colonna[74];
              /* rowErrate.colonna76 := colonna[75] */
              rowErrate.colonna76 = colonna[75];
              /* rowErrate.colonna77 := colonna[76] */
              rowErrate.colonna77 = colonna[76];
              /* rowErrate.colonna78 := colonna[77] */
              rowErrate.colonna78 = colonna[77];
              /* rowErrate.colonna79 := colonna[78] */
              rowErrate.colonna79 = colonna[78];
              /* rowErrate.colonna80 := colonna[79] */
              rowErrate.colonna80 = colonna[79];
              /* rowErrate.colonna81 := colonna[80] */
              rowErrate.colonna81 = colonna[80];
              /* rowErrate.colonna82 := colonna[81] */
              rowErrate.colonna82 = colonna[81];
              /* rowErrate.colonna83 := colonna[82] */
              rowErrate.colonna83 = colonna[82];
              /* rowErrate.colonna84 := colonna[83] */
              rowErrate.colonna84 = colonna[83];
              /* rowErrate.colonna85 := colonna[84] */
              rowErrate.colonna85 = colonna[84];
              /* rowErrate.colonna86 := colonna[85] */
              rowErrate.colonna86 = colonna[85];
              /* rowErrate.colonna87 := colonna[86] */
              rowErrate.colonna87 = colonna[86];
              /* rowErrate.colonna88 := colonna[87] */
              rowErrate.colonna88 = colonna[87];
              /* rowErrate.colonna89 := colonna[88] */
              rowErrate.colonna89 = colonna[88];
              /* rowErrate.colonna90 := colonna[89] */
              rowErrate.colonna90 = colonna[89];
              /* rowErrate.colonna91 := colonna[90] */
              rowErrate.colonna91 = colonna[90];
              /* rowErrate.colonna92 := colonna[91] */
              rowErrate.colonna92 = colonna[91];
              /* rowErrate.colonna93 := colonna[92] */
              rowErrate.colonna93 = colonna[92];
              /* rowErrate.colonna94 := colonna[93] */
              rowErrate.colonna94 = colonna[93];
              /* rowErrate.colonna95 := colonna[94] */
              rowErrate.colonna95 = colonna[94];
              /* rowErrate.colonna96 := colonna[95] */
              rowErrate.colonna96 = colonna[95];
              /* rowErrate.colonna97 := colonna[96] */
              rowErrate.colonna97 = colonna[96];
              /* rowErrate.colonna98 := colonna[97] */
              rowErrate.colonna98 = colonna[97];
              /* rowErrate.colonna99 := colonna[98] */
              rowErrate.colonna99 = colonna[98];
              /* mcErrate.AppendRow(rowErrate) */
              mcErrate.AppendRow(rowErrate);
            } // End If
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
          } // End If
          // Chiude i cicli
            }
          }
          /* foglio := _i // foglio letto */
          foglio = CPLib.Round(_i,0);
          _i++;
        } // End While
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        // Chiude il file e lo cancella
        FileLibMit.DeleteFile("appo/"+nomefileimport);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000248status,0)) {
          m_Sql.SetTransactionStatus(nTry00000248status,cTry00000248msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Transazioni Elaborate: '+LRTrim(Str(conta,10,0)) + ' dal file '+nomefileimport+NL */
      gMsgProc = gMsgProc+"Transazioni Elaborate: "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" dal file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If cNumMod > 0 */
      if (CPLib.gt(cNumMod,0)) {
        /* gMsgProc := gMsgProc + 'Sono stati cancellate '+LRTrim(Str(cNumMod,10,0)) + ' transazioni dal file '+nomefileimport+NL */
        gMsgProc = gMsgProc+"Sono stati cancellate "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+" transazioni dal file "+nomefileimport+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* If _nerrori > 0 */
      if (CPLib.gt(_nerrori,0)) {
        /* gMsgProc := gMsgProc + 'Sono stati rilevati '+LRTrim(Str(_nerrori,10,0)) + ' errori dal file '+nomefileimport+NL */
        gMsgProc = gMsgProc+"Sono stati rilevati "+CPLib.LRTrim(CPLib.Str(_nerrori,10,0))+" errori dal file "+nomefileimport+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
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
  void Page_6() throws Exception {
    /* _esito := 0 */
    _esito = CPLib.Round(0,0);
    /* If Empty(LRTrim(rowErrate.colonna21)) */
    if (CPLib.Empty(CPLib.LRTrim(rowErrate.colonna21))) {
      /* _err01 := "Account Agenzia non compilato" */
      _err01 = "Account Agenzia non compilato";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } else { // Else
      /* If Empty(_cabdip) */
      if (CPLib.Empty(_cabdip)) {
        /* _err02 := "Agenzia priva di codice CAB" */
        _err02 = "Agenzia priva di codice CAB";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
      /* If Empty(_provdip) */
      if (CPLib.Empty(_provdip)) {
        /* _err03 := "Agenzia priva di provincia" */
        _err03 = "Agenzia priva di provincia";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
      /* If Empty(_citdip) */
      if (CPLib.Empty(_citdip)) {
        /* _err04 := "Agenzia priva di città" */
        _err04 = "Agenzia priva di città";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
    } // End If
    /* If Empty(LRTrim(_cognome)) */
    if (CPLib.Empty(CPLib.LRTrim(_cognome))) {
      /* _err05 := "Cognome Cliente assente" */
      _err05 = "Cognome Cliente assente";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(LRTrim(_nome)) */
    if (CPLib.Empty(CPLib.LRTrim(_nome))) {
      /* _err06 := "Nome Cliente assente" */
      _err06 = "Nome Cliente assente";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(LRTrim(_via)) and _codstares='086' */
    if (CPLib.Empty(CPLib.LRTrim(_via)) && CPLib.eqr(_codstares,"086")) {
      /* _err07 := "Dati Residenza non completi" */
      _err07 = "Dati Residenza non completi";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Year(_datope) < 1900 */
    if (CPLib.lt(CPLib.Year(_datope),1900)) {
      /* _err08 := "Data operazione non valida" */
      _err08 = "Data operazione non valida";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(_nasdata) */
    if (CPLib.Empty(_nasdata)) {
      /* _err09 := "Data di nascita non presente" */
      _err09 = "Data di nascita non presente";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } else { // Else
      /* If Year(_nasdata) < 1900 */
      if (CPLib.lt(CPLib.Year(_nasdata),1900)) {
        /* _err10 := "Data di nascita errata" */
        _err10 = "Data di nascita errata";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
    } // End If
    /* If Empty(_doctype) */
    if (CPLib.Empty(_doctype)) {
      /* _err11 := "Tipo del documento non valido" */
      _err11 = "Tipo del documento non valido";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(_docril) */
    if (CPLib.Empty(_docril)) {
      /* _err12 := "Data di rilascio del documento assente" */
      _err12 = "Data di rilascio del documento assente";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } else { // Else
      /* If Year(_docril) < 1900 */
      if (CPLib.lt(CPLib.Year(_docril),1900)) {
        /* _err13 := "Data di rilascio del documento errata" */
        _err13 = "Data di rilascio del documento errata";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
      /* If _docril > _datope */
      if (CPLib.gt(_docril,_datope)) {
        /* _err14 := "Data di rilascio del documento superiore alla data operazione" */
        _err14 = "Data di rilascio del documento superiore alla data operazione";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
      /* If _docril = _nasdata */
      if (CPLib.eqr(_docril,_nasdata)) {
        /* _err15 := "Data di rilascio del documento coincide con la data di nascita" */
        _err15 = "Data di rilascio del documento coincide con la data di nascita";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
    } // End If
    /* If Empty(_docsca) */
    if (CPLib.Empty(_docsca)) {
      /* If _tipodoc <> '06' */
      if (CPLib.ne(_tipodoc,"06")) {
        /* _err16 := "Data di scadenza del documento assente" */
        _err16 = "Data di scadenza del documento assente";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
    } else { // Else
      /* If Year(_docsca) < 1900 */
      if (CPLib.lt(CPLib.Year(_docsca),1900)) {
        /* _err17 := "Data di scadenza del documento errata" */
        _err17 = "Data di scadenza del documento errata";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
      /* If _datope > _docsca */
      if (CPLib.gt(_datope,_docsca)) {
        /* _err18 := "Data di scadenza del documento inferiore alla data dell'operazione" */
        _err18 = "Data di scadenza del documento inferiore alla data dell'operazione";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
      /* If _docril > _docsca */
      if (CPLib.gt(_docril,_docsca)) {
        /* _err19 := "Data di scadenza del documento inferiore alla data di rilascio" */
        _err19 = "Data di scadenza del documento inferiore alla data di rilascio";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
    } // End If
    /* If Empty(LRTrim(rowErrate.colonna14)) */
    if (CPLib.Empty(CPLib.LRTrim(rowErrate.colonna14))) {
      /* _err20 := "Tipo Documento Assente" */
      _err20 = "Tipo Documento Assente";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(_numdoc) and not(Empty(LRTrim(rowErrate.colonna14))) */
    if (CPLib.Empty(_numdoc) &&  ! (CPLib.Empty(CPLib.LRTrim(rowErrate.colonna14)))) {
      /* _err21 := "ID (Numero) del documento assente" */
      _err21 = "ID (Numero) del documento assente";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(_autril) */
    if (CPLib.Empty(_autril)) {
      /* _err22 := "Autorità di rilascio del documento assente" */
      _err22 = "Autorità di rilascio del documento assente";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(_sesso) */
    if (CPLib.Empty(_sesso)) {
      /* _err23 := "Manca il genere della persona" */
      _err23 = "Manca il genere della persona";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(_nasstato) and Empty(_nascitta) */
    if (CPLib.Empty(_nasstato) && CPLib.Empty(_nascitta)) {
      /* _err24 := "Manca il luogo di nascita" */
      _err24 = "Manca il luogo di nascita";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(_codstares) */
    if (CPLib.Empty(_codstares)) {
      /* _err25 := "Manca lo stato di residenza" */
      _err25 = "Manca lo stato di residenza";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(_codcit) and _codstares='086' */
    if (CPLib.Empty(_codcit) && CPLib.eqr(_codstares,"086")) {
      /* _err26 := "Manca la città di residenza" */
      _err26 = "Manca la città di residenza";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(LRTrim(rowErrate.colonna17)) */
    if (CPLib.Empty(CPLib.LRTrim(rowErrate.colonna17))) {
      /* _err27 := "Manca il segno dell'operazione" */
      _err27 = "Manca il segno dell'operazione";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } else { // Else
      /* If rowErrate.colonna17 <> 'D' and rowErrate.colonna17 <> 'A' */
      if (CPLib.ne(rowErrate.colonna17,"D") && CPLib.ne(rowErrate.colonna17,"A")) {
        /* _err28 := "Segno dell'operazione non valido" */
        _err28 = "Segno dell'operazione non valido";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
    } // End If
    /* If At(Substr(riga,490,1),'|C|V') = 0 */
    if (CPLib.eqr(CPLib.At(CPLib.Substr(riga,490,1),"|C|V"),0)) {
      /* If Empty(LRTrim(_cognomecp)) and Empty(LRTrim(_nomecp)) */
      if (CPLib.Empty(CPLib.LRTrim(_cognomecp)) && CPLib.Empty(CPLib.LRTrim(_nomecp))) {
        /* _err29 := "Manca il nominativo della controparte" */
        _err29 = "Manca il nominativo della controparte";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
      /* If Empty(LRTrim(_statodest)) */
      if (CPLib.Empty(CPLib.LRTrim(_statodest))) {
        /* _err30 := "Manca lo stato della controparte" */
        _err30 = "Manca lo stato della controparte";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } else { // Else
        /* If Empty(LRTrim(_uifdest)) */
        if (CPLib.Empty(CPLib.LRTrim(_uifdest))) {
          /* _err31 := "Stato della controparte non presente in tabelle UIF" */
          _err31 = "Stato della controparte non presente in tabelle UIF";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } else { // Else
          /* If _uifdest = '086' */
          if (CPLib.eqr(_uifdest,"086")) {
            /* If Empty(_cittaben) */
            if (CPLib.Empty(_cittaben)) {
              /* _err32 := "Città della controparte non presente" */
              _err32 = "Città della controparte non presente";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
            } // End If
            /* If Empty(_viaben) */
            if (CPLib.Empty(_viaben)) {
              /* _err33 := "Indirizzo della controparte non presente" */
              _err33 = "Indirizzo della controparte non presente";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
            } // End If
          } // End If
        } // End If
      } // End If
    } // End If
    /* _errore := 0 */
    _errore = CPLib.Round(0,0);
    /* _merr := '' */
    _merr = "";
    /* If _nocf=1 */
    if (CPLib.eqr(_nocf,1)) {
      /* _oldcodfis := _codfis */
      _oldcodfis = _codfis;
      /* If (Empty(_nasstato) and Empty(_nascitta)) or Empty(_nasdata) or Empty(_cognome) or Empty(_nome) or Empty(_sesso) */
      if ((CPLib.Empty(_nasstato) && CPLib.Empty(_nascitta)) || CPLib.Empty(_nasdata) || CPLib.Empty(_cognome) || CPLib.Empty(_nome) || CPLib.Empty(_sesso)) {
        /* _err34 := "Mancanza dati per calcolo codice fiscale fittizio" */
        _err34 = "Mancanza dati per calcolo codice fiscale fittizio";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } else { // Else
        /* w_CODFISC := '' // Codice Fiscale */
        w_CODFISC = "";
        /* w_DATANASC := _nasdata // Data Nascita */
        w_DATANASC = _nasdata;
        /* w_NASCOMUN := _nascitta // Luogo di Nascita */
        w_NASCOMUN = _nascitta;
        /* w_NASSTATO := _nasstato // Stato di nascita */
        w_NASSTATO = _nasstato;
        /* w_COGNOME := _cognome // Ragione Sociale */
        w_COGNOME = _cognome;
        /* w_RAGSOC := LRTrim(_cognome)+" "+LRTrim(_nome) // Ragione Sociale */
        w_RAGSOC = CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome);
        /* w_NOME := _nome // Ragione Sociale */
        w_NOME = _nome;
        /* w_SESSO := iif(_sesso='M','1',iif(_sesso='F','2','')) // Sesso */
        w_SESSO = (CPLib.eqr(_sesso,"M")?"1":(CPLib.eqr(_sesso,"F")?"2":""));
        /* Exec Routine arrt_calccodfis_wu */
        arrt_calccodfis_wuR.Make(m_Ctx,this).Run();
        /* _codfis := w_CODFISC */
        _codfis = w_CODFISC;
      } // End If
      /* ElseIf _nocf=0 */
    } else if (CPLib.eqr(_nocf,0)) {
      /* If Empty(LRTrim(_codfis)) */
      if (CPLib.Empty(CPLib.LRTrim(_codfis))) {
        /* _err35 := "Codice Fiscale Originale assente" */
        _err35 = "Codice Fiscale Originale assente";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } else { // Else
        /* If not(arfn_chkcodfis(_codfis,'000',_nocf)) */
        if ( ! (arfn_chkcodfisR.Make(m_Ctx,this).Run(_codfis,"000",_nocf))) {
          /* _err36 := "Codice Fiscale Originale - Codice Fiscale formalmente non valido" */
          _err36 = "Codice Fiscale Originale - Codice Fiscale formalmente non valido";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
      } // End If
    } // End If
    /* If Empty(LRTrim(rowErrate.colonna33)) */
    if (CPLib.Empty(CPLib.LRTrim(rowErrate.colonna33))) {
      /* _err37 := "Codice Interno non compilato" */
      _err37 = "Codice Interno non compilato";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If At(Substr(riga,490,1),'|C|V') = 0 */
    if (CPLib.eqr(CPLib.At(CPLib.Substr(riga,490,1),"|C|V"),0)) {
      /* If Empty(LRTrim(rowErrate.colonna41)) */
      if (CPLib.Empty(CPLib.LRTrim(rowErrate.colonna41))) {
        /* _err38 := "Tipo Intermediario Controparte assente" */
        _err38 = "Tipo Intermediario Controparte assente";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } else { // Else
        /* If At(rowErrate.colonna41,'|12|02|46') = 0 */
        if (CPLib.eqr(CPLib.At(rowErrate.colonna41,"|12|02|46"),0)) {
          /* _err39 := "Tipo Intermediario Controparte errato" */
          _err39 = "Tipo Intermediario Controparte errato";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
      } // End If
      /* If At(rowErrate.colonna41,'|02') <> 0 */
      if (CPLib.ne(CPLib.At(rowErrate.colonna41,"|02"),0)) {
        /* If Empty(LRTrim(_abicab)) */
        if (CPLib.Empty(CPLib.LRTrim(_abicab))) {
          /* _err49 := "ABI-CAB Intermediario Controparte Assente" */
          _err49 = "ABI-CAB Intermediario Controparte Assente";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If not(Empty(LRTrim(_abicab))) and Empty(LRTrim(_abichk)) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(_abicab))) && CPLib.Empty(CPLib.LRTrim(_abichk))) {
          /* _err49 := "ABI-CAB Intermediario Controparte Errato o non presente in tabella" */
          _err49 = "ABI-CAB Intermediario Controparte Errato o non presente in tabella";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
      } else { // Else
        /* If Empty(LRTrim(rowErrate.colonna43)) */
        if (CPLib.Empty(CPLib.LRTrim(rowErrate.colonna43))) {
          /* _err40 := "Descrizione Intermediario Controparte Assente" */
          _err40 = "Descrizione Intermediario Controparte Assente";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(LRTrim(rowErrate.colonna44)) */
        if (CPLib.Empty(CPLib.LRTrim(rowErrate.colonna44))) {
          /* _err41 := "Stato Intermediario Controparte Assente" */
          _err41 = "Stato Intermediario Controparte Assente";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(LRTrim(rowErrate.colonna45)) and At(rowErrate.colonna41,'|02|46') <> 0 */
        if (CPLib.Empty(CPLib.LRTrim(rowErrate.colonna45)) && CPLib.ne(CPLib.At(rowErrate.colonna41,"|02|46"),0)) {
          /* _err42 := "CAB Intermediario Controparte Assente" */
          _err42 = "CAB Intermediario Controparte Assente";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
      } // End If
    } // End If
    /* If Len(LRTrim(_numdoc)) < 6 or Len(LRTrim(_numdoc)) > 10 */
    if (CPLib.lt(CPLib.Len(CPLib.LRTrim(_numdoc)),6) || CPLib.gt(CPLib.Len(CPLib.LRTrim(_numdoc)),10)) {
      /* _err43 := 'Lunghezza del documento non valida' */
      _err43 = "Lunghezza del documento non valida";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Len(LRTrim(_numdoc)) <> 9 and _tipodoc='01' and At('ROMANIA',_autril)=0 */
    if (CPLib.ne(CPLib.Len(CPLib.LRTrim(_numdoc)),9) && CPLib.eqr(_tipodoc,"01") && CPLib.eqr(CPLib.At("ROMANIA",_autril),0)) {
      /* _err44 := "Lunghezza della carta d'identità italiana non valida" */
      _err44 = "Lunghezza della carta d'identità italiana non valida";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If _tipodoc='01' and At('ROMANIA',_autril) <> 0 */
    if (CPLib.eqr(_tipodoc,"01") && CPLib.ne(CPLib.At("ROMANIA",_autril),0)) {
      /* If Len(LRTrim(_numdoc)) <> 8 or (Len(LRTrim(_numdoc)) = 8 and not(LibreriaMit.isAlpha(Left(_numdoc,2)))) */
      if (CPLib.ne(CPLib.Len(CPLib.LRTrim(_numdoc)),8) || (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_numdoc)),8) &&  ! (LibreriaMit.isAlpha(CPLib.Left(_numdoc,2))))) {
        /* _err45 := "Lunghezza della carta d'identità rumena non valida o non composta correttamente" */
        _err45 = "Lunghezza della carta d'identità rumena non valida o non composta correttamente";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
    } // End If
    /* If Len(LRTrim(_numdoc)) <> 10 and _tipodoc='02' */
    if (CPLib.ne(CPLib.Len(CPLib.LRTrim(_numdoc)),10) && CPLib.eqr(_tipodoc,"02")) {
      /* _err46 := "Lunghezza della patente non valida" */
      _err46 = "Lunghezza della patente non valida";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If not(LibreriaMit.isAlphaNum(_numdoc))  or At('*',_numdoc) <> 0 */
    if ( ! (LibreriaMit.isAlphaNum(_numdoc)) || CPLib.ne(CPLib.At("*",_numdoc),0)) {
      /* _err47 := "Presenza di caratteri non validi nel numero documento" */
      _err47 = "Presenza di caratteri non validi nel numero documento";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If At('COMUNE DI ITALIA',Upper(_autril)) <> 0 or At('ABU DHABI',Upper(_autril)) <> 0 or At('REUNION',Upper(_autril)) <> 0 or At('IRLANDA',Upper(_autril)) <> 0  */
    if (CPLib.ne(CPLib.At("COMUNE DI ITALIA",CPLib.Upper(_autril)),0) || CPLib.ne(CPLib.At("ABU DHABI",CPLib.Upper(_autril)),0) || CPLib.ne(CPLib.At("REUNION",CPLib.Upper(_autril)),0) || CPLib.ne(CPLib.At("IRLANDA",CPLib.Upper(_autril)),0)) {
      /* _err48 := "Presenza di valore non valido nell'autorità di rilascio" */
      _err48 = "Presenza di valore non valido nell'autorità di rilascio";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If _codstares = '086' and (Empty(LRTrim(_cap)) or At('x',_cap) <> 0) */
    if (CPLib.eqr(_codstares,"086") && (CPLib.Empty(CPLib.LRTrim(_cap)) || CPLib.ne(CPLib.At("x",_cap),0))) {
      /* _err50 := "CAP non compilato o presenza di caratteri non ammessi" */
      _err50 = "CAP non compilato o presenza di caratteri non ammessi";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
  }
  void Page_7() throws Exception {
    /* Formato Excel */
    /* _nfile := LRTrim(gPathApp)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(_filen) */
    _nfile = CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_filen);
    /* Seleziona i record */
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
    cell =  row.createCell(0);
    cell.setCellValue("NDG");
    cell.setCellStyle(cs);
    cell =  row.createCell(1);
    cell.setCellValue("COGNOME");
    cell.setCellStyle(cs);
    cell = row.createCell(2);
    cell.setCellValue("NOME");
    cell.setCellStyle(cs);
    cell = row.createCell(3);
    cell.setCellValue("INDIRIZZO");
    cell.setCellStyle(cs);
    cell =  row.createCell(4);
    cell.setCellValue("FLAG CODICE FISCALE");
    cell.setCellStyle(cs);
    cell =  row.createCell(5);
    cell.setCellValue("CODICE FISCALE");
    cell.setCellStyle(cs);
    cell =  row.createCell(6);
    cell.setCellValue("LUOGO DI NASCITA");
    cell.setCellStyle(cs);
    cell =  row.createCell(7);
    cell.setCellValue("NUM. DOCUMENTO");
    cell.setCellStyle(cs);
    cell =  row.createCell(8);
    cell.setCellValue("DATA SCADENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(9);
    cell.setCellValue("DATA RILASCIO");
    cell.setCellStyle(cs);
    cell = row.createCell(10);
    cell.setCellValue("AUTORITA' RILASCIO");
    cell.setCellStyle(cs);
    cell = row.createCell(11);
    cell.setCellValue("PAESE RESIDENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(12);
    cell.setCellValue("CITTA' DI RESIDENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(13);
    cell.setCellValue("TIPO DOCUMENTO");
    cell.setCellStyle(cs);
    cell = row.createCell(14);
    cell.setCellValue("DATA OPERAZIONE");
    cell.setCellStyle(cs);
    cell = row.createCell(15);
    cell.setCellValue("FLAG CONTANTI");
    cell.setCellStyle(cs);
    cell = row.createCell(16);
    cell.setCellValue("TIPO TRANSAZIONE");
    cell.setCellStyle(cs);
    cell = row.createCell(17);
    cell.setCellValue("IMPORTO TRX");
    cell.setCellStyle(cs);
    cell = row.createCell(18);
    cell.setCellValue("CONTANTI TRX");
    cell.setCellStyle(cs);
    cell = row.createCell(19);
    cell.setCellValue("UNIQUE ID TRX");
    cell.setCellStyle(cs);
    cell = row.createCell(20);
    cell.setCellValue("CODICE AGENZIA");
    cell.setCellStyle(cs);
    cell = row.createCell(21);
    cell.setCellValue("COGNOME CONTROPARTE");
    cell.setCellStyle(cs);
    cell = row.createCell(22);
    cell.setCellValue("NOME CONTROPARTE");
    cell.setCellStyle(cs);
    cell = row.createCell(23);
    cell.setCellValue("STATO CONTROPARTE");
    cell.setCellStyle(cs);
    cell =  row.createCell(24);
    cell.setCellValue("CITTA RESIDENZA CONTROPARTE");
    cell.setCellStyle(cs);
    cell =  row.createCell(25);
    cell.setCellValue("INDIRIZZO RESIDENZA CONTROPARTE");
    cell.setCellStyle(cs);
    cell = row.createCell(26);
    cell.setCellValue("CAP RESIDENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(27);
    cell.setCellValue("DATA DI NASCITA");
    cell.setCellStyle(cs);
    cell = row.createCell(28);
    cell.setCellValue("SESSO");
    cell.setCellStyle(cs);
    cell = row.createCell(29);
    cell.setCellValue("VALUTA");
    cell.setCellStyle(cs);
    cell = row.createCell(30);
    cell.setCellValue("TIPO OPERAZIONE");
    cell.setCellStyle(cs);
    cell = row.createCell(31);
    cell.setCellValue("FILLER");
    cell.setCellStyle(cs);
    cell = row.createCell(32);
    cell.setCellValue("CODICE UNIVOCO");
    cell.setCellStyle(cs);
    cell =  row.createCell(33);
    cell.setCellValue("REGIONE RESIDENZA CLIENTE");
    cell.setCellStyle(cs);
    cell =  row.createCell(34);
    cell.setCellValue("OCCUPAZIONE");
    cell.setCellStyle(cs);
    cell =  row.createCell(35);
    cell.setCellValue("BLACK LIST INTERNA");
    cell.setCellStyle(cs);
    cell =  row.createCell(36);
    cell.setCellValue("LUOGO RILASCIO DOCUMENTO");
    cell.setCellStyle(cs);
    cell =  row.createCell(37);
    cell.setCellValue("FILLER");
    cell.setCellStyle(cs);
    cell =  row.createCell(38);
    cell.setCellValue("CODICE INTERNO CLIENTE");
    cell.setCellStyle(cs);
    cell =  row.createCell(39);
    cell.setCellValue("PROVINCIA RESIDENZA CLIENTE");
    cell.setCellStyle(cs);
    cell =  row.createCell(40);
    cell.setCellValue("TIPO INTERMEDIARIO CONTROPARTE");
    cell.setCellStyle(cs);
    cell =  row.createCell(41);
    cell.setCellValue("ABI-CAB INTERMEDIARIO CONTROPARTE");
    cell.setCellStyle(cs);
    cell =  row.createCell(42);
    cell.setCellValue("DESCRIZIONE INTERMEDIARIO CONTROPARTE");
    cell.setCellStyle(cs);
    cell =  row.createCell(43);
    cell.setCellValue("STATO INTERMEDIARIO CONTROPARTE");
    cell.setCellStyle(cs);
    cell =  row.createCell(44);
    cell.setCellValue("CAB INTERMEDIARIO CONTROPARTE");
    cell.setCellStyle(cs);
    cell =  row.createCell(45);
    cell.setCellValue("CONTO CLIENTE");
    cell.setCellStyle(cs);
    cell =  row.createCell(46);
    cell.setCellValue("IMPIN OAM");
    cell.setCellStyle(cs);
    cell =  row.createCell(47);
    cell.setCellValue("IMPOUT OAM");
    cell.setCellStyle(cs);
    cell =  row.createCell(48);
    cell.setCellValue("STATUS");
    cell.setCellStyle(cs);
    cell = row.createCell(49);
    cell.setCellValue("ERRORE 1");
    cell.setCellStyle(cs);
    cell = row.createCell(50);
    cell.setCellValue("ERRORE 2");
    cell.setCellStyle(cs);
    cell = row.createCell(51);
    cell.setCellValue("ERRORE 3");
    cell.setCellStyle(cs);
    cell = row.createCell(52);
    cell.setCellValue("ERRORE 4");
    cell.setCellStyle(cs);
    cell = row.createCell(53);
    cell.setCellValue("ERRORE 5");
    cell.setCellStyle(cs);
    cell = row.createCell(54);
    cell.setCellValue("ERRORE 6");
    cell.setCellStyle(cs);
    cell = row.createCell(55);
    cell.setCellValue("ERRORE 7");
    cell.setCellStyle(cs);
    cell = row.createCell(56);
    cell.setCellValue("ERRORE 8");
    cell.setCellStyle(cs);
    cell = row.createCell(57);
    cell.setCellValue("ERRORE 9");
    cell.setCellStyle(cs);
    cell = row.createCell(58);
    cell.setCellValue("ERRORE 10");
    cell.setCellStyle(cs);
    cell = row.createCell(59);
    cell.setCellValue("ERRORE 11");
    cell.setCellStyle(cs);
    cell = row.createCell(60);
    cell.setCellValue("ERRORE 12");
    cell.setCellStyle(cs);
    cell = row.createCell(61);
    cell.setCellValue("ERRORE 13");
    cell.setCellStyle(cs);
    cell = row.createCell(62);
    cell.setCellValue("ERRORE 14");
    cell.setCellStyle(cs);
    cell = row.createCell(63);
    cell.setCellValue("ERRORE 15");
    cell.setCellStyle(cs);
    cell = row.createCell(64);
    cell.setCellValue("ERRORE 16");
    cell.setCellStyle(cs);
    cell = row.createCell(65);
    cell.setCellValue("ERRORE 17");
    cell.setCellStyle(cs);
    cell = row.createCell(66);
    cell.setCellValue("ERRORE 18");
    cell.setCellStyle(cs);
    cell = row.createCell(67);
    cell.setCellValue("ERRORE 19");
    cell.setCellStyle(cs);
    cell = row.createCell(68);
    cell.setCellValue("ERRORE 20");
    cell.setCellStyle(cs);
    cell = row.createCell(69);
    cell.setCellValue("ERRORE 21");
    cell.setCellStyle(cs);
    cell = row.createCell(70);
    cell.setCellValue("ERRORE 22");
    cell.setCellStyle(cs);
    cell = row.createCell(71);
    cell.setCellValue("ERRORE 23");
    cell.setCellStyle(cs);
    cell = row.createCell(72);
    cell.setCellValue("ERRORE 24");
    cell.setCellStyle(cs);
    cell = row.createCell(73);
    cell.setCellValue("ERRORE 25");
    cell.setCellStyle(cs);
    cell = row.createCell(74);
    cell.setCellValue("ERRORE 26");
    cell.setCellStyle(cs);
    cell = row.createCell(75);
    cell.setCellValue("ERRORE 27");
    cell.setCellStyle(cs);
    cell = row.createCell(76);
    cell.setCellValue("ERRORE 28");
    cell.setCellStyle(cs);
    cell = row.createCell(77);
    cell.setCellValue("ERRORE 29");
    cell.setCellStyle(cs);
    cell = row.createCell(78);
    cell.setCellValue("ERRORE 30");
    cell.setCellStyle(cs);
    cell = row.createCell(79);
    cell.setCellValue("ERRORE 31");
    cell.setCellStyle(cs);
    cell = row.createCell(80);
    cell.setCellValue("ERRORE 32");
    cell.setCellStyle(cs);
    cell = row.createCell(81);
    cell.setCellValue("ERRORE 33");
    cell.setCellStyle(cs);
    cell = row.createCell(82);
    cell.setCellValue("ERRORE 34");
    cell.setCellStyle(cs);
    cell = row.createCell(83);
    cell.setCellValue("ERRORE 35");
    cell.setCellStyle(cs);
    cell = row.createCell(84);
    cell.setCellValue("ERRORE 36");
    cell.setCellStyle(cs);
    cell = row.createCell(85);
    cell.setCellValue("ERRORE 37");
    cell.setCellStyle(cs);
    cell = row.createCell(86);
    cell.setCellValue("ERRORE 38");
    cell.setCellStyle(cs);
    cell = row.createCell(87);
    cell.setCellValue("ERRORE 39");
    cell.setCellStyle(cs);
    cell = row.createCell(88);
    cell.setCellValue("ERRORE 40");
    cell.setCellStyle(cs);
    cell = row.createCell(89);
    cell.setCellValue("ERRORE 41");
    cell.setCellStyle(cs);
    cell = row.createCell(90);
    cell.setCellValue("ERRORE 42");
    cell.setCellStyle(cs);
    cell = row.createCell(91);
    cell.setCellValue("ERRORE 43");
    cell.setCellStyle(cs);
    cell = row.createCell(92);
    cell.setCellValue("ERRORE 44");
    cell.setCellStyle(cs);
    cell = row.createCell(93);
    cell.setCellValue("ERRORE 45");
    cell.setCellStyle(cs);
    cell = row.createCell(94);
    cell.setCellValue("ERRORE 46");
    cell.setCellStyle(cs);
    cell = row.createCell(95);
    cell.setCellValue("ERRORE 47");
    cell.setCellStyle(cs);
    cell = row.createCell(96);
    cell.setCellValue("ERRORE 48");
    cell.setCellStyle(cs);
    cell = row.createCell(97);
    cell.setCellValue("ERRORE 49");
    cell.setCellStyle(cs);
    cell = row.createCell(98);
    cell.setCellValue("ERRORE 50'");
    cell.setCellStyle(cs);
    cell = row.createCell(99);
    cell.setCellValue("OPERAZIONE CORRETTA");
    cell.setCellStyle(cs);
    cell = row.createCell(100);
    cell.setCellValue("FORZA SCRITTURA");
    cell.setCellStyle(cs);
    r++;
    for (MemoryCursorRow_mcerratedef_mcrdef rowErrate : mcErrate._iterable_()) {
      // Scrive la riga
      row = sheet.createRow(r);
      cell = row.createCell(0);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna01));
      cell = row.createCell(1);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna02));
      cell = row.createCell(2);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna03));
      cell = row.createCell(3);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna04));
      cell = row.createCell(4);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna05));
      cell = row.createCell(5);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna06));
      cell = row.createCell(6);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna07));
      cell = row.createCell(7);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna08));
      cell = row.createCell(8);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna09));
      cell = row.createCell(9);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna10));
      cell = row.createCell(10);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna11));
      cell = row.createCell(11);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna12));
      cell = row.createCell(12);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna13));
      cell = row.createCell(13);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna14));
      cell = row.createCell(14);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna15));
      cell = row.createCell(15);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna16));
      cell = row.createCell(16);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna17));
      cell = row.createCell(17);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna18));
      cell = row.createCell(18);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna19));
      cell = row.createCell(19);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna20));
      cell = row.createCell(20);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna21));
      cell = row.createCell(21);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna22));
      cell = row.createCell(22);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna23));
      cell = row.createCell(23);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna24));
      cell = row.createCell(24);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna25));
      cell = row.createCell(25);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna26));
      cell = row.createCell(26);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna27));
      cell = row.createCell(27);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna28));
      cell = row.createCell(28);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna29));
      cell = row.createCell(29);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna30));
      cell = row.createCell(30);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna31));
      cell = row.createCell(31);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna32));
      cell = row.createCell(32);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna33));
      cell = row.createCell(33);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna34));
      cell = row.createCell(34);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna35));
      cell = row.createCell(35);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna36));
      cell = row.createCell(36);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna37));
      cell = row.createCell(37);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna38));
      cell = row.createCell(38);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna39));
      cell = row.createCell(39);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna40));
      cell = row.createCell(40);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna41));
      cell = row.createCell(41);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna42));
      cell = row.createCell(42);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna43));
      cell = row.createCell(43);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna44));
      cell = row.createCell(44);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna45));
      cell = row.createCell(45);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna46));
      cell = row.createCell(46);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna47));
      cell = row.createCell(47);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna48));
      cell = row.createCell(48);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna49));
      cell = row.createCell(49);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna50));
      cell = row.createCell(50);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna51));
      cell = row.createCell(51);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna52));
      cell = row.createCell(52);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna53));
      cell = row.createCell(53);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna54));
      cell = row.createCell(54);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna55));
      cell = row.createCell(55);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna56));
      cell = row.createCell(56);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna57));
      cell = row.createCell(57);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna58));
      cell = row.createCell(58);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna59));
      cell = row.createCell(59);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna60));
      cell = row.createCell(60);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna61));
      cell = row.createCell(61);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna62));
      cell = row.createCell(62);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna63));
      cell = row.createCell(63);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna64));
      cell = row.createCell(64);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna65));
      cell = row.createCell(65);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna66));
      cell = row.createCell(66);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna67));
      cell = row.createCell(67);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna68));
      cell = row.createCell(68);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna69));
      cell = row.createCell(69);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna70));
      cell = row.createCell(70);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna71));
      cell = row.createCell(71);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna72));
      cell = row.createCell(72);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna73));
      cell = row.createCell(73);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna74));
      cell = row.createCell(74);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna75));
      cell = row.createCell(75);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna76));
      cell = row.createCell(76);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna77));
      cell = row.createCell(77);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna78));
      cell = row.createCell(78);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna79));
      cell = row.createCell(79);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna80));
      cell = row.createCell(80);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna81));
      cell = row.createCell(81);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna82));
      cell = row.createCell(82);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna83));
      cell = row.createCell(83);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna84));
      cell = row.createCell(84);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna85));
      cell = row.createCell(85);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna86));
      cell = row.createCell(86);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna87));
      cell = row.createCell(87);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna88));
      cell = row.createCell(88);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna89));
      cell = row.createCell(89);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna90));
      cell = row.createCell(90);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna91));
      cell = row.createCell(91);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna92));
      cell = row.createCell(92);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna93));
      cell = row.createCell(93);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna94));
      cell = row.createCell(94);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna95));
      cell = row.createCell(95);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna96));
      cell = row.createCell(96);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna97));
      cell = row.createCell(97);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna98));
      cell = row.createCell(98);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna99));
      cell = row.createCell(99);
      cell.setCellValue(CPLib.LRTrim("N"));
      cell = row.createCell(100);
      cell.setCellValue(CPLib.LRTrim("N"));
      r++;
    }
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
    sheet.autoSizeColumn(30);
    sheet.autoSizeColumn(31);
    sheet.autoSizeColumn(32);
    sheet.autoSizeColumn(33);
    sheet.autoSizeColumn(34);
    sheet.autoSizeColumn(35);
    sheet.autoSizeColumn(36);
    sheet.autoSizeColumn(37);
    sheet.autoSizeColumn(38);
    sheet.autoSizeColumn(39);
    sheet.autoSizeColumn(40);
    sheet.autoSizeColumn(41);
    sheet.autoSizeColumn(42);
    sheet.autoSizeColumn(43);
    sheet.autoSizeColumn(44);
    sheet.autoSizeColumn(45);
    sheet.autoSizeColumn(46);
    sheet.autoSizeColumn(47);
    sheet.autoSizeColumn(48);
    sheet.autoSizeColumn(49);
    sheet.autoSizeColumn(50);
    sheet.autoSizeColumn(51);
    sheet.autoSizeColumn(52);
    sheet.autoSizeColumn(53);
    sheet.autoSizeColumn(54);
    sheet.autoSizeColumn(55);
    sheet.autoSizeColumn(56);
    sheet.autoSizeColumn(57);
    sheet.autoSizeColumn(58);
    sheet.autoSizeColumn(59);
    sheet.autoSizeColumn(60);
    sheet.autoSizeColumn(61);
    sheet.autoSizeColumn(62);
    sheet.autoSizeColumn(63);
    sheet.autoSizeColumn(64);
    sheet.autoSizeColumn(65);
    sheet.autoSizeColumn(66);
    sheet.autoSizeColumn(67);
    sheet.autoSizeColumn(68);
    sheet.autoSizeColumn(69);
    sheet.autoSizeColumn(70);
    sheet.autoSizeColumn(71);
    sheet.autoSizeColumn(72);
    sheet.autoSizeColumn(73);
    sheet.autoSizeColumn(74);
    sheet.autoSizeColumn(75);
    sheet.autoSizeColumn(76);
    sheet.autoSizeColumn(77);
    sheet.autoSizeColumn(78);
    sheet.autoSizeColumn(79);
    sheet.autoSizeColumn(80);
    sheet.autoSizeColumn(81);
    sheet.autoSizeColumn(82);
    sheet.autoSizeColumn(83);
    sheet.autoSizeColumn(84);
    sheet.autoSizeColumn(85);
    sheet.autoSizeColumn(86);
    sheet.autoSizeColumn(87);
    sheet.autoSizeColumn(88);
    sheet.autoSizeColumn(89);
    sheet.autoSizeColumn(90);
    sheet.autoSizeColumn(91);
    sheet.autoSizeColumn(92);
    sheet.autoSizeColumn(93);
    sheet.autoSizeColumn(94);
    sheet.autoSizeColumn(95);
    sheet.autoSizeColumn(96);
    sheet.autoSizeColumn(97);
    sheet.autoSizeColumn(98);
    sheet.autoSizeColumn(99);
    sheet.autoSizeColumn(100);
    // scrivo il file di esito
    FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(_nfile));
    //write this workbook to an Outputstream.
    wb.write(fileOut);
    fileOut.flush();
    fileOut.close();
  }
  void Page_8() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_personbo=null;
    try {
      /* _connes := '' */
      _connes = "";
      /* _prov := '' */
      _prov = "";
      /* _cab := '' */
      _cab = "";
      /* _idb2 := '' */
      _idb2 = "";
      /* _codsae := '' // Codice SAE */
      _codsae = "";
      // * --- Read from tbcitta
      m_cServer = m_Ctx.GetServer("tbcitta");
      m_cPhName = m_Ctx.GetPhName("tbcitta");
      m_cSql = "";
      m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_citta,"C",60,0,m_cServer),m_cServer,_citta);
      if (m_Ctx.IsSharedTemp("tbcitta")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _prov = Read_Cursor.GetString("PROV");
        _cab = Read_Cursor.GetString("CAB");
        _idb2 = Read_Cursor.GetString("IDBASE");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _prov = "";
        _cab = "";
        _idb2 = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      // * --- Read from personbo
      m_cServer = m_Ctx.GetServer("personbo");
      m_cPhName = m_Ctx.GetPhName("personbo");
      m_cSql = "";
      m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ndg,"C",16,0,m_cServer),m_cServer,_ndg);
      if (m_Ctx.IsSharedTemp("personbo")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MACROAGENTE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _connes = Read_Cursor.GetString("CONNES");
        _oldmac = Read_Cursor.GetString("MACROAGENTE");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _connes = "";
        _oldmac = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      // * --- Read from tbstati
      m_cServer = m_Ctx.GetServer("tbstati");
      m_cPhName = m_Ctx.GetPhName("tbstati");
      m_cSql = "";
      m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codstares,"C",3,0,m_cServer),m_cServer,_codstares);
      if (m_Ctx.IsSharedTemp("tbstati")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("FLGSAE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _codsae = Read_Cursor.GetString("FLGSAE");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _codsae = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If _codsae='600' */
      if (CPLib.eqr(_codsae,"600")) {
        /* _setsint := '600' // Codice SAE */
        _setsint = "600";
      } else { // Else
        /* _setsint := '711' // Codice SAE */
        _setsint = "711";
      } // End If
      /* If Empty(LRTrim(_connes)) */
      if (CPLib.Empty(CPLib.LRTrim(_connes))) {
        /* nProgImp := Utilities.GetAutonumber("PRGIMPOCLI\'"+LRTrim(gAzienda)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOCLI\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
        /* _connes := _codfis */
        _connes = _codfis;
        // * --- Insert into personbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"0000052C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000052C(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_autril,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_codstares,"086")?CPLib.Left(_cap,5):CPLib.Space(5)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_nocf,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_cab,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_nocf,0)?_codfis:""),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_cognome,26),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_ndg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_nasdata,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_docril,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_docsca,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_citta,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_via,35),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_codmage,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nascitta,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nasstato,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nome,25),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_oldcodfis,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codstares,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_prov,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),70),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_sesso,"M")?"1":(CPLib.eqr(_sesso,"F")?"2":"")),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_setsint,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codsae,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nasprov,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_doctype,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
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
        // * --- Insert into personbo_agg from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("personbo_agg");
        m_cPhName = m_Ctx.GetPhName("personbo_agg");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"0000052D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000052D(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_ndg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,949,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,956,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.LRTrim(CPLib.Substr(riga,951,5))),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,957,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,959,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,962,10)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,972,2),"?",0,0,m_cServer)+", ";
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
      } else { // Else
        /* _data := Date() */
        _data = CPLib.Date();
        /* cProgSto := '' */
        cProgSto = "";
        // * --- Select from wersonbo
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
        Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select sanumpro  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ndg,"?",0,0,m_cServer, m_oParameters),m_cServer,_ndg)+"  and  datamodi="+CPSql.SQLValueAdapter(CPLib.ToSQL(_data,"?",0,0,m_cServer, m_oParameters),m_cServer,_data)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_wersonbo.Eof())) {
          /* cProgSto := wersonbo->sanumpro */
          cProgSto = Cursor_wersonbo.GetString("sanumpro");
          Cursor_wersonbo.Next();
        }
        m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
        Cursor_wersonbo.Close();
        // * --- End Select
        /* If Empty(cProgSto) */
        if (CPLib.Empty(cProgSto)) {
          /* cProgSto := Utilities.GetAutonumber("PSTOPERS\'"+LRTrim(gAzienda)+"'","",15) */
          cProgSto = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","",15);
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ndg,"?",0,0,m_cServer, m_oParameters),m_cServer,_ndg)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            // * --- Insert into wersonbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"00000535")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000535(m_Ctx,m_oWrInfo);
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
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("MACROAGENTE"),"?",0,0,m_cServer)+", ";
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
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
        } // End If
        // * --- Write into personbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"00000536")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"ALLINEATONOMECNOME = "+CPLib.ToSQL(0,"N",1,0)+", ";
        m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Left(_autril,30),"C",30,0,m_cServer)+", ";
        m_cSql = m_cSql+"CAP = "+CPLib.ToSQL((CPLib.eqr(_codstares,"086")?CPLib.Left(_cap,5):CPLib.Space(5)),"C",9,0,m_cServer)+", ";
        m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(_nocf,"N",1,0)+", ";
        m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(CPLib.Left(_cab,6),"C",6,0,m_cServer)+", ";
        m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL((CPLib.eqr(_nocf,0)?_codfis:""),"C",16,0,m_cServer)+", ";
        m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Left(_cognome,26),"C",26,0,m_cServer)+", ";
        m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(_nasdata,"D",8,0)+", ";
        m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(_docril,"D",8,0)+", ";
        m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(_docsca,"D",8,0)+", ";
        m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Left(_citta,30),"C",30,0,m_cServer)+", ";
        m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Left(_via,35),"C",35,0,m_cServer)+", ";
        m_cSql = m_cSql+"IDFILE = "+CPLib.ToSQL(_idfile,"C",60,0,m_cServer)+", ";
        m_cSql = m_cSql+"MACROAGENTE = "+CPLib.ToSQL(w_codmage,"C",5,0,m_cServer)+", ";
        m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.Left(_nascitta,30),"C",30,0,m_cServer)+", ";
        m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.Left(_nasstato,30),"C",30,0,m_cServer)+", ";
        m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Left(_nome,25),"C",25,0,m_cServer)+", ";
        m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Left(_numdoc,15),"C",15,0,m_cServer)+", ";
        m_cSql = m_cSql+"OLDCODFISC = "+CPLib.ToSQL(_oldcodfis,"C",20,0,m_cServer)+", ";
        m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(_codstares,"C",3,0,m_cServer)+", ";
        m_cSql = m_cSql+"PEP = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Left(_prov,2),"C",2,0,m_cServer)+", ";
        m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),70),"C",70,0,m_cServer)+", ";
        m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL("","C",3,0,m_cServer)+", ";
        m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL((CPLib.eqr(_sesso,"M")?"1":"2"),"C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(_setsint,"C",3,0,m_cServer)+", ";
        m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(_codsae,"C",3,0,m_cServer)+", ";
        m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Left(_nasprov,2),"C",2,0,m_cServer)+", ";
        m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(_doctype,"C",2,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_ndg,"?",0,0,m_cServer),m_cServer,_ndg)+"";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter();
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
          m_cLastMsgError = "Errore in aggiornamento ARCHPERS";
        }
        // * --- Read from personbo_agg
        m_cServer = m_Ctx.GetServer("personbo_agg");
        m_cPhName = m_Ctx.GetPhName("personbo_agg");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ndg,"C",16,0,m_cServer),m_cServer,_ndg);
        if (m_Ctx.IsSharedTemp("personbo_agg")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _connes = Read_Cursor.GetString("CONNES");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo_agg into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _connes = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(_connes) */
        if (CPLib.Empty(_connes)) {
          // * --- Insert into personbo_agg from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("personbo_agg");
          m_cPhName = m_Ctx.GetPhName("personbo_agg");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"00000539")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000539(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_ndg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,949,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,956,1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.LRTrim(CPLib.Substr(riga,951,5))),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,957,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,959,3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,962,10)),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,972,2),"?",0,0,m_cServer)+", ";
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
        } else { // Else
          // * --- Write into personbo_agg from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("personbo_agg");
          m_cPhName = m_Ctx.GetPhName("personbo_agg");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"0000053A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"REGRES = "+CPLib.ToSQL(CPLib.Substr(riga,949,2),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"FLGBL = "+CPLib.ToSQL(CPLib.Substr(riga,956,1),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"CLOCCUPA = "+CPLib.ToSQL(CPLib.Val(CPLib.LRTrim(CPLib.Substr(riga,951,5))),"N",3,0)+", ";
          m_cSql = m_cSql+"RDCODAUT = "+CPLib.ToSQL(CPLib.Substr(riga,957,2),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"NAZIONE = "+CPLib.ToSQL(CPLib.Substr(riga,959,3),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODCLIEST = "+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,962,10)),"C",10,0,m_cServer)+", ";
          m_cSql = m_cSql+"CLPRVDOM = "+CPLib.ToSQL(CPLib.Substr(riga,972,2),"C",2,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_ndg,"?",0,0,m_cServer),m_cServer,_ndg)+"";
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
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_9() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* If w_destfin='O' */
      if (CPLib.eqr(w_destfin,"O")) {
        /* nProgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(gAzienda)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
        /* _idb2 := LibreriaMit.UniqueId() */
        _idb2 = LibreriaMit.UniqueId();
        /* If w_tipodest='P' */
        if (CPLib.eqr(w_tipodest,"P")) {
          /* cOpeProg1 := Utilities.GetAutonumber("PPOPER1\'"+LRTrim(gAzienda)+"'",'',10) */
          cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPOPER1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          /* cOpeProg2 := Utilities.GetAutonumber("PPOPER2\'"+LRTrim(gAzienda)+"'",'',11) */
          cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPOPER2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
          // * --- Insert into xperazbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xperazbo");
          m_cPhName = m_Ctx.GetPhName("xperazbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"00000541")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000541(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(_datope),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cabben,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_capben),5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cittaben,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_viaben,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_prvben,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognomecp)+" "+CPLib.LRTrim(_nomecp),70),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uifdest,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cambio,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cabintcon,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_ndg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_intercit,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_desintcon,50),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_flgcash,"N")?"0":"1"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_valiso,"EUR")?"3":"4"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(_codrap)?"":"0"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O"+CPLib.Right(cOpeProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_nazintcon,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("XXXXXXXXX","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipintcon,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_flgcash,"N")?0:_importo),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_valuta,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_abicab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_conto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_prvintcon,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xperazbo",true);
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
          /* cOpeProg1 := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(gAzienda)+"'",'',10) */
          cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          /* cOpeProg2 := Utilities.GetAutonumber("POPERAZ2\'"+LRTrim(gAzienda)+"'",'',11) */
          cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
          // * --- Insert into operazbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"00000544")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000544(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(_datope),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognomecp)+" "+CPLib.LRTrim(_nomecp),70),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uifdest,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cambio,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cabintcon,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_ndg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_intercit,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_desintcon,50),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_flgcash,"N")?"0":"1"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_valiso,"EUR")?"3":"4"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(_codrap)?"":"0"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O"+CPLib.Right(cOpeProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_nazintcon,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("XXXXXXXXX","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipintcon,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_flgcash,"N")?0:_importo),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_valuta,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cittaben,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_viaben,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cabben,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_capben),5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_prvben,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_abicab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_conto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_prvintcon,"?",0,0,m_cServer)+", ";
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
        } // End If
        /* ElseIf w_destfin='F' */
      } else if (CPLib.eqr(w_destfin,"F")) {
        /* nProgImp := Utilities.GetAutonumber("PRGIMPFRZ\'"+LRTrim(gAzienda)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPFRZ\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
        /* _idb2 := LibreriaMit.UniqueId() */
        _idb2 = LibreriaMit.UniqueId();
        /* If w_tipodest='P' */
        if (CPLib.eqr(w_tipodest,"P")) {
          /* cOpeProg1 := Utilities.GetAutonumber("PPFRAZ1\'"+LRTrim(gAzienda)+"'",'',10) */
          cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPFRAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          /* cOpeProg2 := Utilities.GetAutonumber("PPFRAZ2\'"+LRTrim(gAzienda)+"'",'',11) */
          cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PPFRAZ2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
          // * --- Insert into xraziobo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xraziobo");
          m_cPhName = m_Ctx.GetPhName("xraziobo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"0000054A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000054A(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(_datope),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cabben,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_capben),5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cittaben,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_viaben,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_prvben,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognomecp)+" "+CPLib.LRTrim(_nomecp),70),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_conto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uifdest,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cambio,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cabintcon,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_abicab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_ndg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_intercit,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_desintcon,50),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_flgcash,"N")?"0":"1"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_valiso,"EUR")?"3":"4"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(_codrap)?"":"0"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("F"+CPLib.Right(cOpeProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_nazintcon,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("XXXXXXXXX","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipintcon,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_flgcash,"N")?0:_importo),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_valuta,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_prvintcon,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xraziobo",true);
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
          /* cOpeProg1 := Utilities.GetAutonumber("PFRAZIO1\'"+LRTrim(gAzienda)+"'",'',10) */
          cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          /* cOpeProg2 := Utilities.GetAutonumber("PFRAZIO2\'"+LRTrim(gAzienda)+"'",'',11) */
          cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
          // * --- Insert into fraziobo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"0000054D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000054D(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(_datope),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognomecp)+" "+CPLib.LRTrim(_nomecp),70),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uifdest,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cambio,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cabintcon,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_ndg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_intercit,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_desintcon,50),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_flgcash,"N")?"0":"1"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_valiso,"EUR")?"3":"4"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(_codrap)?"":"0"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("F"+CPLib.Right(cOpeProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_nazintcon,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("XXXXXXXXX","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipintcon,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_flgcash,"N")?0:_importo),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_valuta,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cittaben,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_viaben,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cabben,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_capben),5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_prvben,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_abicab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_conto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_prvintcon,"?",0,0,m_cServer)+", ";
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
        } // End If
      } // End If
      /* If w_tipodest='D' */
      if (CPLib.eqr(w_tipodest,"D")) {
        /* _anno := Str(Year(_datope),4,0) */
        _anno = CPLib.Str(CPLib.Year(_datope),4,0);
        /* _idbase := '' */
        _idbase = "";
        // * --- Read from opextrbo
        m_cServer = m_Ctx.GetServer("opextrbo");
        m_cPhName = m_Ctx.GetPhName("opextrbo");
        m_cSql = "";
        m_cSql = m_cSql+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ndg,"C",16,0,m_cServer),m_cServer,_ndg);
        m_cSql = m_cSql+" and ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"C",4,0,m_cServer),m_cServer,_anno);
        if (m_Ctx.IsSharedTemp("opextrbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _idbase = Read_Cursor.GetString("IDBASE");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _idbase = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(_idbase) */
        if (CPLib.Empty(_idbase)) {
          /* _id := Utilities.GetAutonumber("PROGOPEX\'"+LRTrim(gAzienda)+"'",0,10) */
          _id = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGOPEX\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
          // * --- Insert into opextrbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"00000555")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000555(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_ndg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_anno,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Generato da  TRX: "+_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_id,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_anno+"_"+CPLib.LRTrim(_ndg),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"opextrbo",true);
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
  void Page_10() throws Exception {
    CPResultSet Cursor_operazbo=null;
    CPResultSet Cursor_fraziobo=null;
    try {
      /* _idbase := '' */
      _idbase = "";
      // * --- Select from operazbo
      m_cServer = m_Ctx.GetServer("operazbo");
      m_cPhName = m_Ctx.GetPhName("operazbo");
      if (Cursor_operazbo!=null)
        Cursor_operazbo.Close();
      Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"INFORM="+CPSql.SQLValueAdapter(CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer, m_oParameters),m_cServer,_uniquecode)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_operazbo.Eof())) {
        /* _idbase := operazbo->IDBASE */
        _idbase = Cursor_operazbo.GetString("IDBASE");
        Cursor_operazbo.Next();
      }
      m_cConnectivityError = Cursor_operazbo.ErrorMessage();
      Cursor_operazbo.Close();
      // * --- End Select
      /* If Empty(_idbase) */
      if (CPLib.Empty(_idbase)) {
        // * --- Select from fraziobo
        m_cServer = m_Ctx.GetServer("fraziobo");
        m_cPhName = m_Ctx.GetPhName("fraziobo");
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
        Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"INFORM="+CPSql.SQLValueAdapter(CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer, m_oParameters),m_cServer,_uniquecode)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_fraziobo.Eof())) {
          /* _idbase := operazbo->IDBASE */
          _idbase = Cursor_operazbo.GetString("IDBASE");
          Cursor_fraziobo.Next();
        }
        m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
        Cursor_fraziobo.Close();
        // * --- End Select
        /* If not(Empty(_idbase)) */
        if ( ! (CPLib.Empty(_idbase))) {
          // * --- Write into fraziobo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"0000055E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
          m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("2","C",1,0,m_cServer)+", ";
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
      } else { // Else
        // * --- Write into operazbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("operazbo");
        m_cPhName = m_Ctx.GetPhName("operazbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"0000055F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
        m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("2","C",1,0,m_cServer)+", ";
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
    } finally {
      try {
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
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
    }
  }
  void Page_11() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* nProgImp := Utilities.GetAutonumber("PRGIMPOPEAGE\'"+LRTrim(gAzienda)+"'",0,15) */
      nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPEAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
      /* cOpeProg1 := Utilities.GetAutonumber("POPERAGE1\'"+LRTrim(gAzienda)+"'",'',10) */
      cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAGE1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
      /* cOpeProg2 := Utilities.GetAutonumber("POPERAGE2\'"+LRTrim(gAzienda)+"'",'',11) */
      cOpeProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAGE2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
      // * --- Insert into jperazbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("jperazbo");
      m_cPhName = m_Ctx.GetPhName("jperazbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jperazbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"00000563")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_00000563(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(_datope),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognomecp)+" "+CPLib.LRTrim(_nomecp),70),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_uifdest,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_cambio,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_cabintcon,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_ndg,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_intercit,30),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_desintcon,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_flgcash,"N")?"0":"1"),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_valiso,"EUR")?"3":"4"),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(_codrap)?"":"0"),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cOpeProg2+"X","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_nazintcon,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("XXXXXXXXX","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_tipintcon,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_flgcash,"N")?0:_importo),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_valuta,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_impin,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_impout,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jperazbo",true);
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
      /* _anno := Str(Year(_datope),4,0) */
      _anno = CPLib.Str(CPLib.Year(_datope),4,0);
      /* _idbase := '' */
      _idbase = "";
      // * --- Read from opextrbo
      m_cServer = m_Ctx.GetServer("opextrbo");
      m_cPhName = m_Ctx.GetPhName("opextrbo");
      m_cSql = "";
      m_cSql = m_cSql+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ndg,"C",16,0,m_cServer),m_cServer,_ndg);
      m_cSql = m_cSql+" and ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"C",4,0,m_cServer),m_cServer,_anno);
      if (m_Ctx.IsSharedTemp("opextrbo")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _idbase = Read_Cursor.GetString("IDBASE");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _idbase = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If Empty(_idbase) */
      if (CPLib.Empty(_idbase)) {
        /* _id := Utilities.GetAutonumber("PROGOPEX\'"+LRTrim(gAzienda)+"'",0,10) */
        _id = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGOPEX\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
        // * --- Insert into opextrbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("opextrbo");
        m_cPhName = m_Ctx.GetPhName("opextrbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"0000056A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000056A(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_ndg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_anno,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Generato da  TRX: "+_uniquecode,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_id,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_anno+"_"+CPLib.LRTrim(_ndg),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"opextrbo",true);
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
  void Page_12() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file excel e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* cNumInv := 0 */
      cNumInv = CPLib.Round(0,0);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* Legge il file */
      //base
      InputStream ExcelFileToRead = new FileInputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomefileimport));
      XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
      _conta = wb.getNumberOfSheets();
      Row row; 
      Cell cell;
      int cellType;
      String[] colonna = new String[63];
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000574status;
      nTry00000574status = m_Sql.GetTransactionStatus();
      String cTry00000574msg;
      cTry00000574msg = m_Sql.TransactionErrorMessage();
      try {
        /* While _i < _conta */
        while (CPLib.lt(_i,_conta)) {
          /* foglio := _i // foglio letto */
          foglio = CPLib.Round(_i,0);
          //Apro uno ad uno i fogli del file Excel
          XSSFSheet sheet = wb.getSheetAt(_i);
          for (int rowNumber = sheet.getFirstRowNum(); rowNumber <= sheet.getLastRowNum(); rowNumber++) {
            row = sheet.getRow(rowNumber);
            if (row == null) {
                   // This row is completely empty
              } else {
          /* riga_letta := riga_letta+1 // riga letta del file Excel */
          riga_letta = CPLib.Round(riga_letta+1,0);
          /* If riga_letta > 1 */
          if (CPLib.gt(riga_letta,1)) {
            //scorro le colonne
            cell_count=0;
            /* While cell_count < 63 */
            while (CPLib.lt(cell_count,63)) {
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
            /* riga := LibreriaMit.SpacePad(LRTrim(colonna[0]),6) */
            riga = LibreriaMit.SpacePad(CPLib.LRTrim(colonna[0]),6);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[1]),70) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[1]),70);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[2]),35) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[2]),35);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[3]),16) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[3]),16);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[4]),8) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[4]),8);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[5]),30) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[5]),30);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[6]),3) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[6]),3);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[7]),3) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[7]),3);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[8]),3) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[8]),3);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[9]),2) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[9]),2);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[10]),15) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[10]),15);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[11]),8) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[11]),8);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[12]),30) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[12]),30);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[13]),30) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[13]),30);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[14]),2) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[14]),2);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[15]),3) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[15]),3);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[16]),9) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[16]),9);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[17]),14) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[17]),14);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[18]),1) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[18]),1);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[19]),8) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[19]),8);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[20]),8) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[20]),8);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[21]),26) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[21]),26);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[22]),25) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[22]),25);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[23]),100) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[23]),100);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[24]),2) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[24]),2);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[25]),1) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[25]),1);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[26]),37) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[26]),37);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[27]),16) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[27]),16);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[28]),56) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[28]),56);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[29]),2) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[29]),2);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[30]),5) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[30]),5);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[31]),1) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[31]),1);
            /* riga := riga + LibreriaMit.SpacePad(LRTrim(colonna[32]),2) */
            riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(colonna[32]),2);
            /* If LRTrim(colonna[61])='S' or LRTrim(colonna[62])='S' */
            if (CPLib.eqr(CPLib.LRTrim(colonna[61]),"S") || CPLib.eqr(CPLib.LRTrim(colonna[62]),"S")) {
              /* gMsgImp := 'Elaborazione del soggetto con codice fiscale: ' + colonna[3] // Messaggio Import */
              gMsgImp = "Elaborazione del soggetto con codice fiscale: "+colonna[3];
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _i := 1 */
              _i = 1;
              /* _tiperr := '' */
              _tiperr = "";
              /* _listerr := '' */
              _listerr = "";
              /* _esito := 0 */
              _esito = CPLib.Round(0,0);
              /* xConnes := '' */
              xConnes = "";
              /* _cognome := '' */
              _cognome = "";
              /* _nome := '' */
              _nome = "";
              /* _citta := '' */
              _citta = "";
              /* _cap := '' */
              _cap = "";
              /* _via := '' */
              _via = "";
              /* _prov := '' */
              _prov = "";
              /* _cab := '' */
              _cab = "";
              /* _resstato := '' */
              _resstato = "";
              /* _sesso := '' */
              _sesso = "";
              /* _nascitta := '' */
              _nascitta = "";
              /* _nasstato := '' */
              _nasstato = "";
              /* _nasprov := '' */
              _nasprov = "";
              /* _nasdata := NullDate() */
              _nasdata = CPLib.NullDate();
              /* _tipodoc := '' */
              _tipodoc = "";
              /* _numdoc := '' */
              _numdoc = "";
              /* _docril := NullDate() */
              _docril = CPLib.NullDate();
              /* _autril := '' */
              _autril = "";
              /* _docsca := NullDate() */
              _docsca = CPLib.NullDate();
              /* _codfis := '' */
              _codfis = "";
              /* _ocodfis := '' */
              _ocodfis = "";
              /* _connes := '' */
              _connes = "";
              /* _doctype := '' */
              _doctype = "";
              /* _nocf := 0 */
              _nocf = CPLib.Round(0,0);
              /* _oldcodfis := '' */
              _oldcodfis = "";
              /* _oldmac := '' */
              _oldmac = "";
              /* _ndg := '' */
              _ndg = "";
              /* _err01 := '' */
              _err01 = "";
              /* _err02 := '' */
              _err02 = "";
              /* _err03 := '' */
              _err03 = "";
              /* _err04 := '' */
              _err04 = "";
              /* _err05 := '' */
              _err05 = "";
              /* _err06 := '' */
              _err06 = "";
              /* _err07 := '' */
              _err07 = "";
              /* _err08 := '' */
              _err08 = "";
              /* _err09 := '' */
              _err09 = "";
              /* _err10 := '' */
              _err10 = "";
              /* _err11 := '' */
              _err11 = "";
              /* _err12 := '' */
              _err12 = "";
              /* _err13 := '' */
              _err13 = "";
              /* _err14 := '' */
              _err14 = "";
              /* _err15 := '' */
              _err15 = "";
              /* _err16 := '' */
              _err16 = "";
              /* _err17 := '' */
              _err17 = "";
              /* _err18 := '' */
              _err18 = "";
              /* _err19 := '' */
              _err19 = "";
              /* _err20 := '' */
              _err20 = "";
              /* _err21 := '' */
              _err21 = "";
              /* _err22 := '' */
              _err22 = "";
              /* _err23 := '' */
              _err23 = "";
              /* _err24 := '' */
              _err24 = "";
              /* _err25 := '' */
              _err25 = "";
              /* _err26 := '' */
              _err26 = "";
              /* _err27 := '' */
              _err27 = "";
              /* _err28 := '' */
              _err28 = "";
              /* w_CODFISC := '' // Codice Fiscale */
              w_CODFISC = "";
              /* w_DATANASC := NullDate() // Data Nascita */
              w_DATANASC = CPLib.NullDate();
              /* w_NASCOMUN := '' // Luogo di Nascita */
              w_NASCOMUN = "";
              /* w_NASSTATO := '' // Stato di nascita */
              w_NASSTATO = "";
              /* w_COGNOME := '' // Ragione Sociale */
              w_COGNOME = "";
              /* w_RAGSOC := '' // Ragione Sociale */
              w_RAGSOC = "";
              /* w_NOME := '' // Ragione Sociale */
              w_NOME = "";
              /* w_SESSO := '' // Sesso */
              w_SESSO = "";
              /* _ndg := LRTrim(Substr(riga,496,16)) */
              _ndg = CPLib.LRTrim(CPLib.Substr(riga,496,16));
              /* _cognome := LRTrim(Substr(riga,305,26)) */
              _cognome = CPLib.LRTrim(CPLib.Substr(riga,305,26));
              /* _nome := LRTrim(Substr(riga,331,25)) */
              _nome = CPLib.LRTrim(CPLib.Substr(riga,331,25));
              /* _nocf := iif(Substr(riga,458,1)='S',0,iif(Substr(riga,458,1)='N',1,-1)) */
              _nocf = CPLib.Round((CPLib.eqr(CPLib.Substr(riga,458,1),"S")?0:(CPLib.eqr(CPLib.Substr(riga,458,1),"N")?1:-1)),0);
              /* _nasdata := CharToDate(Substr(riga,132,4)+Substr(riga,130,2)+Substr(riga,128,2)) */
              _nasdata = CPLib.CharToDate(CPLib.Substr(riga,132,4)+CPLib.Substr(riga,130,2)+CPLib.Substr(riga,128,2));
              /* _sesso := Substr(riga,288,1) */
              _sesso = CPLib.Substr(riga,288,1);
              /* _codfis := Upper(Substr(riga,112,16)) */
              _codfis = CPLib.Upper(CPLib.Substr(riga,112,16));
              /* If _nocf=0 */
              if (CPLib.eqr(_nocf,0)) {
                /* _ocodfis := _codfis */
                _ocodfis = _codfis;
                /* If Substr(_codfis,12,1)='Z' */
                if (CPLib.eqr(CPLib.Substr(_codfis,12,1),"Z")) {
                  /* _nasprov := 'EE' */
                  _nasprov = "EE";
                  /* _nasstato := '' */
                  _nasstato = "";
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_codfis,12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(_codfis,12,4));
                  if (m_Ctx.IsSharedTemp("tbstati")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _nasstato = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _nasstato = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If Empty(_nasstato) */
                  if (CPLib.Empty(_nasstato)) {
                    // * --- Read from tbstatna
                    m_cServer = m_Ctx.GetServer("tbstatna");
                    m_cPhName = m_Ctx.GetPhName("tbstatna");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_codfis,12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(_codfis,12,4));
                    if (m_Ctx.IsSharedTemp("tbstatna")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _nasstato = Read_Cursor.GetString("DESCRI");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbstatna into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _nasstato = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* If Empty(_nasstato) */
                    if (CPLib.Empty(_nasstato)) {
                      /* _nasstato := Substr(riga,218,40) */
                      _nasstato = CPLib.Substr(riga,218,40);
                    } // End If
                  } // End If
                } else { // Else
                  /* _nascitta := '' */
                  _nascitta = "";
                  /* _nasprov := '' */
                  _nasprov = "";
                  // * --- Read from tbcitta
                  m_cServer = m_Ctx.GetServer("tbcitta");
                  m_cPhName = m_Ctx.GetPhName("tbcitta");
                  m_cSql = "";
                  m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_codfis,12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(_codfis,12,4));
                  if (m_Ctx.IsSharedTemp("tbcitta")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _nasprov = Read_Cursor.GetString("PROV");
                    _nascitta = Read_Cursor.GetString("CITTA");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _nasprov = "";
                    _nascitta = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If Empty(_nascitta) */
                  if (CPLib.Empty(_nascitta)) {
                    // * --- Read from tbcittna
                    m_cServer = m_Ctx.GetServer("tbcittna");
                    m_cPhName = m_Ctx.GetPhName("tbcittna");
                    m_cSql = "";
                    m_cSql = m_cSql+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_codfis,12,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(_codfis,12,4));
                    if (m_Ctx.IsSharedTemp("tbcittna")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _nasprov = Read_Cursor.GetString("PROV");
                      _nascitta = Read_Cursor.GetString("CITTA");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbcittna into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _nasprov = "";
                      _nascitta = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* If Empty(_nascitta) */
                    if (CPLib.Empty(_nascitta)) {
                      // * --- Read from tbcitta
                      m_cServer = m_Ctx.GetServer("tbcitta");
                      m_cPhName = m_Ctx.GetPhName("tbcitta");
                      m_cSql = "";
                      m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,218,40),"C",60,0,m_cServer),m_cServer,CPLib.Substr(riga,218,40));
                      if (m_Ctx.IsSharedTemp("tbcitta")) {
                        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                      }
                      if (Read_Cursor!=null)
                        Read_Cursor.Close();
                      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                      if ( ! (Read_Cursor.Eof())) {
                        _nasprov = Read_Cursor.GetString("PROV");
                        Read_Cursor.Next();
                        if ( ! (Read_Cursor.Eof())) {
                          Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                          CPStdCounter.Error(l_oErrorFault);
                        }
                        Read_Cursor.Close();
                      } else {
                        // Error: no record found!
                        _nasprov = "";
                        Read_Cursor.Close();
                        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                      }
                    } // End If
                  } // End If
                } // End If
              } else { // Else
                /* _nasprov := '' */
                _nasprov = "";
                /* _nasstato := '' */
                _nasstato = "";
                /* _nascitta := '' */
                _nascitta = "";
                /* If not(Empty(Substr(riga,136,30))) */
                if ( ! (CPLib.Empty(CPLib.Substr(riga,136,30)))) {
                  /* _codstanas := '' */
                  _codstanas = "";
                  /* _luonas := LRTrim(Substr(riga,136,30)) */
                  _luonas = CPLib.LRTrim(CPLib.Substr(riga,136,30));
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_luonas),"C",40,0,m_cServer),m_cServer,CPLib.LRTrim(_luonas));
                  if (m_Ctx.IsSharedTemp("tbstati")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _codstanas = Read_Cursor.GetString("CODSTA");
                    _nasstato = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _codstanas = "";
                    _nasstato = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If not(Empty(_codstanas)) */
                  if ( ! (CPLib.Empty(_codstanas))) {
                    /* _nasprov := 'EE' */
                    _nasprov = "EE";
                  } else { // Else
                    // * --- Read from tbcitta
                    m_cServer = m_Ctx.GetServer("tbcitta");
                    m_cPhName = m_Ctx.GetPhName("tbcitta");
                    m_cSql = "";
                    m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_luonas,"C",60,0,m_cServer),m_cServer,_luonas);
                    if (m_Ctx.IsSharedTemp("tbcitta")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CITTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _nasprov = Read_Cursor.GetString("PROV");
                      _nascitta = Read_Cursor.GetString("CITTA");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _nasprov = "";
                      _nascitta = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                  } // End If
                } // End If
              } // End If
              /* _numdoc := LRTrim(Substr(riga,177,15)) */
              _numdoc = CPLib.LRTrim(CPLib.Substr(riga,177,15));
              /* _docril := CharToDate(Substr(riga,196,4)+Substr(riga,194,2)+Substr(riga,192,2)) */
              _docril = CPLib.CharToDate(CPLib.Substr(riga,196,4)+CPLib.Substr(riga,194,2)+CPLib.Substr(riga,192,2));
              /* _docsca := CharToDate(Substr(riga,293,4)+Substr(riga,291,2)+Substr(riga,289,2)) */
              _docsca = CPLib.CharToDate(CPLib.Substr(riga,293,4)+CPLib.Substr(riga,291,2)+CPLib.Substr(riga,289,2));
              /* _autril := LRTrim(Substr(riga,200,30)) */
              _autril = CPLib.LRTrim(CPLib.Substr(riga,200,30));
              /* _doctype := LRTrim(Substr(riga,175,2)) */
              _doctype = CPLib.LRTrim(CPLib.Substr(riga,175,2));
              /* _tipodoc := LRTrim(Substr(riga,175,2)) */
              _tipodoc = CPLib.LRTrim(CPLib.Substr(riga,175,2));
              /* _via := LRTrim(Substr(riga,77,35)) */
              _via = CPLib.LRTrim(CPLib.Substr(riga,77,35));
              /* _citta := Upper(Substr(riga,230,30)) */
              _citta = CPLib.Upper(CPLib.Substr(riga,230,30));
              /* _codcit := '' */
              _codcit = "";
              /* If not(Empty(LRTrim(_citta))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(_citta)))) {
                // * --- Read from tbcitta
                m_cServer = m_Ctx.GetServer("tbcitta");
                m_cPhName = m_Ctx.GetPhName("tbcitta");
                m_cSql = "";
                m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_citta,"C",60,0,m_cServer),m_cServer,_citta);
                if (m_Ctx.IsSharedTemp("tbcitta")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _codcit = Read_Cursor.GetString("IDBASE");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _codcit = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
              } // End If
              /* _codstares := LRTrim(Substr(riga,262,3)) */
              _codstares = CPLib.LRTrim(CPLib.Substr(riga,262,3));
              /* rowErrate.colonna01 := LRTrim(Left(riga,6)) */
              rowErrate.colonna01 = CPLib.LRTrim(CPLib.Left(riga,6));
              /* rowErrate.colonna02 := LRTrim(Substr(riga,7,70)) */
              rowErrate.colonna02 = CPLib.LRTrim(CPLib.Substr(riga,7,70));
              /* rowErrate.colonna03 := LRTrim(Substr(riga,77,35)) */
              rowErrate.colonna03 = CPLib.LRTrim(CPLib.Substr(riga,77,35));
              /* rowErrate.colonna04 := LRTrim(Substr(riga,112,16)) */
              rowErrate.colonna04 = CPLib.LRTrim(CPLib.Substr(riga,112,16));
              /* rowErrate.colonna05 := LRTrim(Substr(riga,128,8)) */
              rowErrate.colonna05 = CPLib.LRTrim(CPLib.Substr(riga,128,8));
              /* rowErrate.colonna06 := Substr(riga,136,30) */
              rowErrate.colonna06 = CPLib.Substr(riga,136,30);
              /* rowErrate.colonna07 := Substr(riga,166,3) */
              rowErrate.colonna07 = CPLib.Substr(riga,166,3);
              /* rowErrate.colonna08 := Substr(riga,169,3) */
              rowErrate.colonna08 = CPLib.Substr(riga,169,3);
              /* rowErrate.colonna09 := Substr(riga,172,3) */
              rowErrate.colonna09 = CPLib.Substr(riga,172,3);
              /* rowErrate.colonna10 := Substr(riga,175,2) */
              rowErrate.colonna10 = CPLib.Substr(riga,175,2);
              /* rowErrate.colonna11 := Substr(riga,177,15) */
              rowErrate.colonna11 = CPLib.Substr(riga,177,15);
              /* rowErrate.colonna12 := Substr(riga,192,8) */
              rowErrate.colonna12 = CPLib.Substr(riga,192,8);
              /* rowErrate.colonna13 := Substr(riga,200,30) */
              rowErrate.colonna13 = CPLib.Substr(riga,200,30);
              /* rowErrate.colonna14 := Substr(riga,230,30) */
              rowErrate.colonna14 = CPLib.Substr(riga,230,30);
              /* rowErrate.colonna15 := Substr(riga,260,2) */
              rowErrate.colonna15 = CPLib.Substr(riga,260,2);
              /* rowErrate.colonna16 := Substr(riga,262,3) */
              rowErrate.colonna16 = CPLib.Substr(riga,262,3);
              /* rowErrate.colonna17 := Substr(riga,265,9) */
              rowErrate.colonna17 = CPLib.Substr(riga,265,9);
              /* rowErrate.colonna18 := Substr(riga,274,14) */
              rowErrate.colonna18 = CPLib.Substr(riga,274,14);
              /* rowErrate.colonna19 := Substr(riga,288,1) */
              rowErrate.colonna19 = CPLib.Substr(riga,288,1);
              /* rowErrate.colonna20 := Substr(riga,289,8) */
              rowErrate.colonna20 = CPLib.Substr(riga,289,8);
              /* rowErrate.colonna21 := Substr(riga,297,8) */
              rowErrate.colonna21 = CPLib.Substr(riga,297,8);
              /* rowErrate.colonna22 := Substr(riga,305,26) */
              rowErrate.colonna22 = CPLib.Substr(riga,305,26);
              /* rowErrate.colonna23 := Substr(riga,331,25) */
              rowErrate.colonna23 = CPLib.Substr(riga,331,25);
              /* rowErrate.colonna24 := Substr(riga,356,100) */
              rowErrate.colonna24 = CPLib.Substr(riga,356,100);
              /* rowErrate.colonna25 := Substr(riga,456,2) */
              rowErrate.colonna25 = CPLib.Substr(riga,456,2);
              /* rowErrate.colonna26 := Substr(riga,458,1) */
              rowErrate.colonna26 = CPLib.Substr(riga,458,1);
              /* rowErrate.colonna27 := Substr(riga,459,37) */
              rowErrate.colonna27 = CPLib.Substr(riga,459,37);
              /* rowErrate.colonna28 := Substr(riga,496,16) */
              rowErrate.colonna28 = CPLib.Substr(riga,496,16);
              /* rowErrate.colonna29 := Substr(riga,512,56) */
              rowErrate.colonna29 = CPLib.Substr(riga,512,56);
              /* rowErrate.colonna30 := Substr(riga,568,2) */
              rowErrate.colonna30 = CPLib.Substr(riga,568,2);
              /* rowErrate.colonna31 := Substr(riga,570,5) */
              rowErrate.colonna31 = CPLib.Substr(riga,570,5);
              /* rowErrate.colonna32 := Substr(riga,575,1) */
              rowErrate.colonna32 = CPLib.Substr(riga,575,1);
              /* rowErrate.colonna33 := Substr(riga,576,2) */
              rowErrate.colonna33 = CPLib.Substr(riga,576,2);
              /* If LRTrim(colonna[62])='N' */
              if (CPLib.eqr(CPLib.LRTrim(colonna[62]),"N")) {
                /* Exec "Controllo Aggiornamento Soggetti" Page 13:Page_13 */
                Page_13();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
              } // End If
              /* If _esito=1 */
              if (CPLib.eqr(_esito,1)) {
                /* _nerrori := _nerrori + 1 */
                _nerrori = CPLib.Round(_nerrori+1,0);
                /* rowErrate.colonna34 := _err01 */
                rowErrate.colonna34 = _err01;
                /* rowErrate.colonna35 := _err02 */
                rowErrate.colonna35 = _err02;
                /* rowErrate.colonna36 := _err03 */
                rowErrate.colonna36 = _err03;
                /* rowErrate.colonna37 := _err04 */
                rowErrate.colonna37 = _err04;
                /* rowErrate.colonna38 := _err05 */
                rowErrate.colonna38 = _err05;
                /* rowErrate.colonna39 := _err06 */
                rowErrate.colonna39 = _err06;
                /* rowErrate.colonna40 := _err07 */
                rowErrate.colonna40 = _err07;
                /* rowErrate.colonna41 := _err08 */
                rowErrate.colonna41 = _err08;
                /* rowErrate.colonna42 := _err09 */
                rowErrate.colonna42 = _err09;
                /* rowErrate.colonna43 := _err10 */
                rowErrate.colonna43 = _err10;
                /* rowErrate.colonna44 := _err11 */
                rowErrate.colonna44 = _err11;
                /* rowErrate.colonna45 := _err12 */
                rowErrate.colonna45 = _err12;
                /* rowErrate.colonna46 := _err13 */
                rowErrate.colonna46 = _err13;
                /* rowErrate.colonna47 := _err14 */
                rowErrate.colonna47 = _err14;
                /* rowErrate.colonna48 := _err15 */
                rowErrate.colonna48 = _err15;
                /* rowErrate.colonna49 := _err16 */
                rowErrate.colonna49 = _err16;
                /* rowErrate.colonna50 := _err17 */
                rowErrate.colonna50 = _err17;
                /* rowErrate.colonna51 := _err18 */
                rowErrate.colonna51 = _err18;
                /* rowErrate.colonna52 := _err19 */
                rowErrate.colonna52 = _err19;
                /* rowErrate.colonna53 := _err20 */
                rowErrate.colonna53 = _err20;
                /* rowErrate.colonna54 := _err21 */
                rowErrate.colonna54 = _err21;
                /* rowErrate.colonna55 := _err22 */
                rowErrate.colonna55 = _err22;
                /* rowErrate.colonna56 := _err23 */
                rowErrate.colonna56 = _err23;
                /* rowErrate.colonna57 := _err24 */
                rowErrate.colonna57 = _err24;
                /* rowErrate.colonna58 := _err25 */
                rowErrate.colonna58 = _err25;
                /* rowErrate.colonna59 := _err26 */
                rowErrate.colonna59 = _err26;
                /* rowErrate.colonna60 := _err27 */
                rowErrate.colonna60 = _err27;
                /* rowErrate.colonna61 := _err28 */
                rowErrate.colonna61 = _err28;
                /* mcErrate.AppendRow(rowErrate) */
                mcErrate.AppendRow(rowErrate);
              } // End If
              /* If _esito = 0 */
              if (CPLib.eqr(_esito,0)) {
                /* Exec "Scrittura Aggiornamento Soggetto" Page 14:Page_14 */
                Page_14();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
              } // End If
            } else { // Else
              /* _nerrori := _nerrori + 1 */
              _nerrori = CPLib.Round(_nerrori+1,0);
              /* rowErrate.colonna01 := colonna[0] */
              rowErrate.colonna01 = colonna[0];
              /* rowErrate.colonna02 := colonna[1] */
              rowErrate.colonna02 = colonna[1];
              /* rowErrate.colonna03 := colonna[2] */
              rowErrate.colonna03 = colonna[2];
              /* rowErrate.colonna04 := colonna[3] */
              rowErrate.colonna04 = colonna[3];
              /* rowErrate.colonna05 := colonna[4] */
              rowErrate.colonna05 = colonna[4];
              /* rowErrate.colonna06 := colonna[5] */
              rowErrate.colonna06 = colonna[5];
              /* rowErrate.colonna07 := colonna[6] */
              rowErrate.colonna07 = colonna[6];
              /* rowErrate.colonna08 := colonna[7] */
              rowErrate.colonna08 = colonna[7];
              /* rowErrate.colonna09 := colonna[8] */
              rowErrate.colonna09 = colonna[8];
              /* rowErrate.colonna10 := colonna[9] */
              rowErrate.colonna10 = colonna[9];
              /* rowErrate.colonna11 := colonna[10] */
              rowErrate.colonna11 = colonna[10];
              /* rowErrate.colonna12 := colonna[11] */
              rowErrate.colonna12 = colonna[11];
              /* rowErrate.colonna13 := colonna[12] */
              rowErrate.colonna13 = colonna[12];
              /* rowErrate.colonna14 := colonna[13] */
              rowErrate.colonna14 = colonna[13];
              /* rowErrate.colonna15 := colonna[14] */
              rowErrate.colonna15 = colonna[14];
              /* rowErrate.colonna16 := colonna[15] */
              rowErrate.colonna16 = colonna[15];
              /* rowErrate.colonna17 := colonna[16] */
              rowErrate.colonna17 = colonna[16];
              /* rowErrate.colonna18 := colonna[17] */
              rowErrate.colonna18 = colonna[17];
              /* rowErrate.colonna19 := colonna[18] */
              rowErrate.colonna19 = colonna[18];
              /* rowErrate.colonna20 := colonna[19] */
              rowErrate.colonna20 = colonna[19];
              /* rowErrate.colonna21 := colonna[20] */
              rowErrate.colonna21 = colonna[20];
              /* rowErrate.colonna22 := colonna[21] */
              rowErrate.colonna22 = colonna[21];
              /* rowErrate.colonna23 := colonna[22] */
              rowErrate.colonna23 = colonna[22];
              /* rowErrate.colonna24 := colonna[23] */
              rowErrate.colonna24 = colonna[23];
              /* rowErrate.colonna25 := colonna[24] */
              rowErrate.colonna25 = colonna[24];
              /* rowErrate.colonna26 := colonna[25] */
              rowErrate.colonna26 = colonna[25];
              /* rowErrate.colonna27 := colonna[26] */
              rowErrate.colonna27 = colonna[26];
              /* rowErrate.colonna28 := colonna[27] */
              rowErrate.colonna28 = colonna[27];
              /* rowErrate.colonna29 := colonna[28] */
              rowErrate.colonna29 = colonna[28];
              /* rowErrate.colonna30 := colonna[29] */
              rowErrate.colonna30 = colonna[29];
              /* rowErrate.colonna31 := colonna[30] */
              rowErrate.colonna31 = colonna[30];
              /* rowErrate.colonna32 := colonna[31] */
              rowErrate.colonna32 = colonna[31];
              /* rowErrate.colonna33 := colonna[32] */
              rowErrate.colonna33 = colonna[32];
              /* rowErrate.colonna34 := colonna[33] */
              rowErrate.colonna34 = colonna[33];
              /* rowErrate.colonna35 := colonna[34] */
              rowErrate.colonna35 = colonna[34];
              /* rowErrate.colonna36 := colonna[35] */
              rowErrate.colonna36 = colonna[35];
              /* rowErrate.colonna37 := colonna[36] */
              rowErrate.colonna37 = colonna[36];
              /* rowErrate.colonna38 := colonna[37] */
              rowErrate.colonna38 = colonna[37];
              /* rowErrate.colonna39 := colonna[38] */
              rowErrate.colonna39 = colonna[38];
              /* rowErrate.colonna40 := colonna[39] */
              rowErrate.colonna40 = colonna[39];
              /* rowErrate.colonna41 := colonna[40] */
              rowErrate.colonna41 = colonna[40];
              /* rowErrate.colonna42 := colonna[41] */
              rowErrate.colonna42 = colonna[41];
              /* rowErrate.colonna43 := colonna[42] */
              rowErrate.colonna43 = colonna[42];
              /* rowErrate.colonna44 := colonna[43] */
              rowErrate.colonna44 = colonna[43];
              /* rowErrate.colonna45 := colonna[44] */
              rowErrate.colonna45 = colonna[44];
              /* rowErrate.colonna46 := colonna[45] */
              rowErrate.colonna46 = colonna[45];
              /* rowErrate.colonna47 := colonna[46] */
              rowErrate.colonna47 = colonna[46];
              /* rowErrate.colonna48 := colonna[47] */
              rowErrate.colonna48 = colonna[47];
              /* rowErrate.colonna49 := colonna[48] */
              rowErrate.colonna49 = colonna[48];
              /* rowErrate.colonna50 := colonna[49] */
              rowErrate.colonna50 = colonna[49];
              /* rowErrate.colonna51 := colonna[50] */
              rowErrate.colonna51 = colonna[50];
              /* rowErrate.colonna52 := colonna[51] */
              rowErrate.colonna52 = colonna[51];
              /* rowErrate.colonna53 := colonna[52] */
              rowErrate.colonna53 = colonna[52];
              /* rowErrate.colonna54 := colonna[53] */
              rowErrate.colonna54 = colonna[53];
              /* rowErrate.colonna55 := colonna[54] */
              rowErrate.colonna55 = colonna[54];
              /* rowErrate.colonna56 := colonna[55] */
              rowErrate.colonna56 = colonna[55];
              /* rowErrate.colonna57 := colonna[56] */
              rowErrate.colonna57 = colonna[56];
              /* rowErrate.colonna58 := colonna[57] */
              rowErrate.colonna58 = colonna[57];
              /* rowErrate.colonna59 := colonna[58] */
              rowErrate.colonna59 = colonna[58];
              /* rowErrate.colonna60 := colonna[59] */
              rowErrate.colonna60 = colonna[59];
              /* rowErrate.colonna61 := colonna[60] */
              rowErrate.colonna61 = colonna[60];
              /* mcErrate.AppendRow(rowErrate) */
              mcErrate.AppendRow(rowErrate);
            } // End If
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
          } // End If
          // Chiude ciclo e if
            }
          }
          _i++;
        } // End While
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000574status,0)) {
          m_Sql.SetTransactionStatus(nTry00000574status,cTry00000574msg);
        }
      }
      // Chiude il file e lo cancella
      ExcelFileToRead.close();
      FileLibMit.DeleteFile("appo/"+CPLib.LRTrim(nomefileimport));
      /* gMsgProc := gMsgProc + 'Anagrafiche Elaborate: '+LRTrim(Str(conta,10,0)) + ' dal file '+nomefileimport+NL */
      gMsgProc = gMsgProc+"Anagrafiche Elaborate: "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" dal file "+nomefileimport+"\n";
      /* If cNumMod > 0 */
      if (CPLib.gt(cNumMod,0)) {
        /* gMsgProc := gMsgProc + 'Sono stati rettificate '+LRTrim(Str(cNumMod,10,0)) + ' anagrafiche dal file '+nomefileimport+NL */
        gMsgProc = gMsgProc+"Sono stati rettificate "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+" anagrafiche dal file "+nomefileimport+"\n";
      } // End If
      /* If cNumNew > 0 */
      if (CPLib.gt(cNumNew,0)) {
        /* gMsgProc := gMsgProc + 'Sono stati inserite '+LRTrim(Str(cNumNew,10,0)) + ' anagrafiche dal file '+nomefileimport+NL */
        gMsgProc = gMsgProc+"Sono stati inserite "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" anagrafiche dal file "+nomefileimport+"\n";
      } // End If
      /* If _nerrori > 0 */
      if (CPLib.gt(_nerrori,0)) {
        /* gMsgProc := gMsgProc + 'Sono stati rilevati '+LRTrim(Str(_nerrori,10,0)) + ' errori dal file '+nomefileimport+NL */
        gMsgProc = gMsgProc+"Sono stati rilevati "+CPLib.LRTrim(CPLib.Str(_nerrori,10,0))+" errori dal file "+nomefileimport+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
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
  void Page_13() throws Exception {
    /* If Empty(LRTrim(_cognome)) */
    if (CPLib.Empty(CPLib.LRTrim(_cognome))) {
      /* _err01 := "Cognome Cliente assente" */
      _err01 = "Cognome Cliente assente";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(LRTrim(_nome)) */
    if (CPLib.Empty(CPLib.LRTrim(_nome))) {
      /* _err02 := "Nome Cliente assente" */
      _err02 = "Nome Cliente assente";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(LRTrim(_via)) and _codstares='086' */
    if (CPLib.Empty(CPLib.LRTrim(_via)) && CPLib.eqr(_codstares,"086")) {
      /* _err03 := "Dati Residenza non completi" */
      _err03 = "Dati Residenza non completi";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(_nasdata) */
    if (CPLib.Empty(_nasdata)) {
      /* _err04 := "Data di nascita non presente" */
      _err04 = "Data di nascita non presente";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } else { // Else
      /* If Year(_nasdata) < 1900 */
      if (CPLib.lt(CPLib.Year(_nasdata),1900)) {
        /* _err05 := "Data di nascita errata" */
        _err05 = "Data di nascita errata";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
    } // End If
    /* If Empty(_doctype) */
    if (CPLib.Empty(_doctype)) {
      /* _err06 := "Tipo del documento non valido" */
      _err06 = "Tipo del documento non valido";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(_docril) */
    if (CPLib.Empty(_docril)) {
      /* _err07 := "Data di rilascio del documento assente" */
      _err07 = "Data di rilascio del documento assente";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } else { // Else
      /* If Year(_docril) < 1900 */
      if (CPLib.lt(CPLib.Year(_docril),1900)) {
        /* _err08 := "Data di rilascio del documento errata" */
        _err08 = "Data di rilascio del documento errata";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
      /* If _docril = _nasdata */
      if (CPLib.eqr(_docril,_nasdata)) {
        /* _err09 := "Data di rilascio del documento coincide con la data di nascita" */
        _err09 = "Data di rilascio del documento coincide con la data di nascita";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
    } // End If
    /* If Empty(_docsca) */
    if (CPLib.Empty(_docsca)) {
      /* If _tipodoc <> '06' */
      if (CPLib.ne(_tipodoc,"06")) {
        /* _err10 := "Data di scadenza del documento assente" */
        _err10 = "Data di scadenza del documento assente";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
    } else { // Else
      /* If Year(_docsca) < 1900 */
      if (CPLib.lt(CPLib.Year(_docsca),1900)) {
        /* _err11 := "Data di scadenza del documento errata" */
        _err11 = "Data di scadenza del documento errata";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
      /* If _docril > _docsca */
      if (CPLib.gt(_docril,_docsca)) {
        /* _err12 := "Data di scadenza del documento inferiore alla data di rilascio" */
        _err12 = "Data di scadenza del documento inferiore alla data di rilascio";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
    } // End If
    /* If Empty(LRTrim(_tipodoc)) */
    if (CPLib.Empty(CPLib.LRTrim(_tipodoc))) {
      /* _err13 := "Tipo Documento Assente" */
      _err13 = "Tipo Documento Assente";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(_numdoc) and not(Empty(LRTrim(_tipodoc))) */
    if (CPLib.Empty(_numdoc) &&  ! (CPLib.Empty(CPLib.LRTrim(_tipodoc)))) {
      /* _err14 := "ID (Numero) del documento assente" */
      _err14 = "ID (Numero) del documento assente";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(_autril) */
    if (CPLib.Empty(_autril)) {
      /* _err15 := "Autorità di rilascio del documento assente" */
      _err15 = "Autorità di rilascio del documento assente";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(_sesso) */
    if (CPLib.Empty(_sesso)) {
      /* _err16 := "Manca il genere della persona" */
      _err16 = "Manca il genere della persona";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(_nasstato) and Empty(_nascitta) */
    if (CPLib.Empty(_nasstato) && CPLib.Empty(_nascitta)) {
      /* _err17 := "Manca il luogo di nascita" */
      _err17 = "Manca il luogo di nascita";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(_codstares) */
    if (CPLib.Empty(_codstares)) {
      /* _err18 := "Manca lo stato di residenza" */
      _err18 = "Manca lo stato di residenza";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Empty(_codcit) and _codstares='086' */
    if (CPLib.Empty(_codcit) && CPLib.eqr(_codstares,"086")) {
      /* _err19 := "Manca la città di residenza" */
      _err19 = "Manca la città di residenza";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* _errore := 0 */
    _errore = CPLib.Round(0,0);
    /* _merr := '' */
    _merr = "";
    /* If _nocf=1 */
    if (CPLib.eqr(_nocf,1)) {
      /* _oldcodfis := _codfis */
      _oldcodfis = _codfis;
      /* If (Empty(_nasstato) and Empty(_nascitta)) or Empty(_nasdata) or Empty(_cognome) or Empty(_nome) or Empty(_sesso) */
      if ((CPLib.Empty(_nasstato) && CPLib.Empty(_nascitta)) || CPLib.Empty(_nasdata) || CPLib.Empty(_cognome) || CPLib.Empty(_nome) || CPLib.Empty(_sesso)) {
        /* _err20 := "Mancanza dati per calcolo codice fiscale fittizio" */
        _err20 = "Mancanza dati per calcolo codice fiscale fittizio";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } else { // Else
        /* w_CODFISC := '' // Codice Fiscale */
        w_CODFISC = "";
        /* w_DATANASC := _nasdata // Data Nascita */
        w_DATANASC = _nasdata;
        /* w_NASCOMUN := _nascitta // Luogo di Nascita */
        w_NASCOMUN = _nascitta;
        /* w_NASSTATO := _nasstato // Stato di nascita */
        w_NASSTATO = _nasstato;
        /* w_COGNOME := _cognome // Ragione Sociale */
        w_COGNOME = _cognome;
        /* w_RAGSOC := LRTrim(_cognome)+" "+LRTrim(_nome) // Ragione Sociale */
        w_RAGSOC = CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome);
        /* w_NOME := _nome // Ragione Sociale */
        w_NOME = _nome;
        /* w_SESSO := iif(_sesso='M','1',iif(_sesso='F','2','')) // Sesso */
        w_SESSO = (CPLib.eqr(_sesso,"M")?"1":(CPLib.eqr(_sesso,"F")?"2":""));
        /* Exec Routine arrt_calccodfis_wu */
        arrt_calccodfis_wuR.Make(m_Ctx,this).Run();
        /* _codfis := w_CODFISC */
        _codfis = w_CODFISC;
      } // End If
      /* ElseIf _nocf=0 */
    } else if (CPLib.eqr(_nocf,0)) {
      /* If Empty(LRTrim(_codfis)) */
      if (CPLib.Empty(CPLib.LRTrim(_codfis))) {
        /* _err21 := "Codice Fiscale Originale assente" */
        _err21 = "Codice Fiscale Originale assente";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } else { // Else
        /* If not(arfn_chkcodfis(_codfis,'000',_nocf)) */
        if ( ! (arfn_chkcodfisR.Make(m_Ctx,this).Run(_codfis,"000",_nocf))) {
          /* _err22 := "Codice Fiscale Originale - Codice Fiscale formalmente non valido" */
          _err22 = "Codice Fiscale Originale - Codice Fiscale formalmente non valido";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
      } // End If
    } // End If
    /* If Len(LRTrim(_numdoc)) < 6 or Len(LRTrim(_numdoc)) > 10 */
    if (CPLib.lt(CPLib.Len(CPLib.LRTrim(_numdoc)),6) || CPLib.gt(CPLib.Len(CPLib.LRTrim(_numdoc)),10)) {
      /* _err23 := 'Lunghezza del documento non valida' */
      _err23 = "Lunghezza del documento non valida";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If Len(LRTrim(_numdoc)) <> 9 and _tipodoc='01' and At('ROMANIA',_autril)=0 */
    if (CPLib.ne(CPLib.Len(CPLib.LRTrim(_numdoc)),9) && CPLib.eqr(_tipodoc,"01") && CPLib.eqr(CPLib.At("ROMANIA",_autril),0)) {
      /* _err24 := "Lunghezza della carta d'identità italiana non valida" */
      _err24 = "Lunghezza della carta d'identità italiana non valida";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If _tipodoc='01' and At('ROMANIA',_autril) <> 0 */
    if (CPLib.eqr(_tipodoc,"01") && CPLib.ne(CPLib.At("ROMANIA",_autril),0)) {
      /* If Len(LRTrim(_numdoc)) <> 8 or (Len(LRTrim(_numdoc)) = 8 and not(LibreriaMit.isAlpha(Left(_numdoc,2)))) */
      if (CPLib.ne(CPLib.Len(CPLib.LRTrim(_numdoc)),8) || (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_numdoc)),8) &&  ! (LibreriaMit.isAlpha(CPLib.Left(_numdoc,2))))) {
        /* _err25 := "Lunghezza della carta d'identità rumena non valida o non composta correttamente" */
        _err25 = "Lunghezza della carta d'identità rumena non valida o non composta correttamente";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
    } // End If
    /* If Len(LRTrim(_numdoc)) <> 10 and _tipodoc='02' */
    if (CPLib.ne(CPLib.Len(CPLib.LRTrim(_numdoc)),10) && CPLib.eqr(_tipodoc,"02")) {
      /* _err26 := "Lunghezza della patente non valida" */
      _err26 = "Lunghezza della patente non valida";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If not(LibreriaMit.isAlphaNum(_numdoc)) or At('*',_numdoc) <> 0 */
    if ( ! (LibreriaMit.isAlphaNum(_numdoc)) || CPLib.ne(CPLib.At("*",_numdoc),0)) {
      /* _err27 := "Presenza di caratteri non validi nel numero documento" */
      _err27 = "Presenza di caratteri non validi nel numero documento";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
    /* If At('COMUNE DI ITALIA',Upper(_autril)) <> 0 or At('ABU DHABI',Upper(_autril)) <> 0 or At('REUNION',Upper(_autril)) <> 0 or At('IRLANDA',Upper(_autril)) <> 0  */
    if (CPLib.ne(CPLib.At("COMUNE DI ITALIA",CPLib.Upper(_autril)),0) || CPLib.ne(CPLib.At("ABU DHABI",CPLib.Upper(_autril)),0) || CPLib.ne(CPLib.At("REUNION",CPLib.Upper(_autril)),0) || CPLib.ne(CPLib.At("IRLANDA",CPLib.Upper(_autril)),0)) {
      /* _err28 := "Presenza di valore non valido nell'autorità di rilascio" */
      _err28 = "Presenza di valore non valido nell'autorità di rilascio";
      /* _esito := 1 */
      _esito = CPLib.Round(1,0);
    } // End If
  }
  void Page_14() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_operazbo=null;
    CPResultSet Cursor_fraziobo=null;
    CPResultSet Cursor_qbe_aggfam_opextrbo_new=null;
    CPResultSet Cursor_qbe_aggfam_opextrbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _oldest Numeric(1, 0) */
      double _oldest;
      _oldest = 0;
      /* _oldcf Char(16) */
      String _oldcf;
      _oldcf = CPLib.Space(16);
      /* _oldcog Char(26) */
      String _oldcog;
      _oldcog = CPLib.Space(26);
      /* _oldnom Char(26) */
      String _oldnom;
      _oldnom = CPLib.Space(26);
      /* _oldrgs Char(70) */
      String _oldrgs;
      _oldrgs = CPLib.Space(70);
      /* _oldncm Char(30) */
      String _oldncm;
      _oldncm = CPLib.Space(30);
      /* _oldnst Char(30) */
      String _oldnst;
      _oldnst = CPLib.Space(30);
      /* _oldndt Date */
      java.sql.Date _oldndt;
      _oldndt = CPLib.NullDate();
      /* _oldnpv Char(2) */
      String _oldnpv;
      _oldnpv = CPLib.Space(2);
      /* _oldnsx Char(1) */
      String _oldnsx;
      _oldnsx = CPLib.Space(1);
      /* nProgSto Numeric(10, 0) */
      double nProgSto;
      nProgSto = 0;
      /* xRiga1 Memo */
      String xRiga1;
      xRiga1 = "";
      /* xRiga2 Memo */
      String xRiga2;
      xRiga2 = "";
      /* xRiga3 Memo */
      String xRiga3;
      xRiga3 = "";
      /* xRiga4 Memo */
      String xRiga4;
      xRiga4 = "";
      /* xRiga5 Memo */
      String xRiga5;
      xRiga5 = "";
      /* xRiga6 Memo */
      String xRiga6;
      xRiga6 = "";
      /* _tipper Char(1) */
      String _tipper;
      _tipper = CPLib.Space(1);
      /* xCF Char(16) */
      String xCF;
      xCF = CPLib.Space(16);
      /* _conadd Char(16) */
      String _conadd;
      _conadd = CPLib.Space(16);
      /* _flgvali Char(1) */
      String _flgvali;
      _flgvali = CPLib.Space(1);
      /* _flganag Char(1) */
      String _flganag;
      _flganag = CPLib.Space(1);
      /* xCFE Numeric(1, 0) */
      double xCFE;
      xCFE = 0;
      /* _datarett Date */
      java.sql.Date _datarett;
      _datarett = CPLib.NullDate();
      /* cSNAS Char(30) */
      String cSNAS;
      cSNAS = CPLib.Space(30);
      /* cCNAS Char(30) */
      String cCNAS;
      cCNAS = CPLib.Space(30);
      /* _datvarage Date */
      java.sql.Date _datvarage;
      _datvarage = CPLib.NullDate();
      /* xCodCab Char(6) */
      String xCodCab;
      xCodCab = CPLib.Space(6);
      /* xCitta Char(30) */
      String xCitta;
      xCitta = CPLib.Space(30);
      /* cNewProg Char(10) */
      String cNewProg;
      cNewProg = CPLib.Space(10);
      /* nProgSto := 0 */
      nProgSto = CPLib.Round(0,0);
      /* nProgImp := 0 */
      nProgImp = CPLib.Round(0,0);
      // * --- Read from cpwarn
      m_cServer = m_Ctx.GetServer("cpwarn");
      m_cPhName = m_Ctx.GetPhName("cpwarn");
      m_cSql = "";
      m_cSql = m_cSql+"tablecode="+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPOCLI\\'"+CPLib.LRTrim(gAzienda)+"'","C",100,0,m_cServer),m_cServer,"prog\\PRGIMPOCLI\\'"+CPLib.LRTrim(gAzienda)+"'");
      m_cSql = m_cSql+" and warncode="+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"C",10,0,m_cServer),m_cServer,gAzienda);
      if (m_Ctx.IsSharedTemp("cpwarn")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("autonum",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        nProgImp = CPLib.Round(Read_Cursor.GetDouble("autonum"),0);
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on cpwarn into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        nProgImp = 0;
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      // * --- Read from cpwarn
      m_cServer = m_Ctx.GetServer("cpwarn");
      m_cPhName = m_Ctx.GetPhName("cpwarn");
      m_cSql = "";
      m_cSql = m_cSql+"tablecode="+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","C",100,0,m_cServer),m_cServer,"prog\\PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'");
      m_cSql = m_cSql+" and warncode="+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"C",10,0,m_cServer),m_cServer,gAzienda);
      if (m_Ctx.IsSharedTemp("cpwarn")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("autonum",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        nProgSto = Read_Cursor.GetDouble("autonum");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on cpwarn into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        nProgSto = 0;
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If Len(LRTrim(riga)) > 0 */
      if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
        /* xRiga1 := '' */
        xRiga1 = "";
        /* xRiga2 := '' */
        xRiga2 = "";
        /* xRiga3 := '' */
        xRiga3 = "";
        /* xRiga4 := '' */
        xRiga4 = "";
        /* xRiga5 := '' */
        xRiga5 = "";
        /* xRiga6 := '' */
        xRiga6 = "";
        /* _tipper := '' */
        _tipper = "";
        /* cCli1 := Substr(riga,112,16) */
        cCli1 = CPLib.Substr(riga,112,16);
        /* xConnes := '' */
        xConnes = "";
        /* xCF := Substr(riga,112,16) */
        xCF = CPLib.Substr(riga,112,16);
        /* _conadd := Substr(riga,496,16) */
        _conadd = CPLib.Substr(riga,496,16);
        /* cCli1 := iif(Empty(LRTrim(_conadd)),cCli1,_conadd) */
        cCli1 = (CPLib.Empty(CPLib.LRTrim(_conadd))?cCli1:_conadd);
        /* Prima la Read si faceva per CF */
        /* _oldest := 0 */
        _oldest = CPLib.Round(0,0);
        /* _oldcf := '' */
        _oldcf = "";
        /* _oldcog := '' */
        _oldcog = "";
        /* _oldnom := '' */
        _oldnom = "";
        /* _oldrgs := '' */
        _oldrgs = "";
        /* _oldncm := '' */
        _oldncm = "";
        /* _oldnst := '' */
        _oldnst = "";
        /* _oldndt := NullDate() */
        _oldndt = CPLib.NullDate();
        /* _oldnpv := '' */
        _oldnpv = "";
        /* _oldnsx := '' */
        _oldnsx = "";
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(cCli1,"C",16,0,m_cServer),m_cServer,cCli1);
        if (m_Ctx.IsSharedTemp("personbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CFESTERO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("COGNOME",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NOME",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NASCOMUN",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NASSTATO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DATANASC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPINTER",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SESSO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          xConnes = Read_Cursor.GetString("CONNES");
          _oldest = Read_Cursor.GetDouble("CFESTERO");
          _oldcf = Read_Cursor.GetString("CODFISC");
          _oldcog = Read_Cursor.GetString("COGNOME");
          _oldnom = Read_Cursor.GetString("NOME");
          _oldrgs = Read_Cursor.GetString("RAGSOC");
          _oldncm = Read_Cursor.GetString("NASCOMUN");
          _oldnst = Read_Cursor.GetString("NASSTATO");
          _oldndt = Read_Cursor.GetDate("DATANASC");
          _oldnpv = Read_Cursor.GetString("TIPINTER");
          _oldnsx = Read_Cursor.GetString("SESSO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          xConnes = "";
          _oldest = 0;
          _oldcf = "";
          _oldcog = "";
          _oldnom = "";
          _oldrgs = "";
          _oldncm = "";
          _oldnst = "";
          _oldndt = CPLib.NullDate();
          _oldnpv = "";
          _oldnsx = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* _flgvali := '' */
        _flgvali = "";
        /* _flganag := '' */
        _flganag = "";
        // * --- Read from personbo_agg
        m_cServer = m_Ctx.GetServer("personbo_agg");
        m_cPhName = m_Ctx.GetPhName("personbo_agg");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(cCli1,"C",16,0,m_cServer),m_cServer,cCli1);
        if (m_Ctx.IsSharedTemp("personbo_agg")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("FLGVALIDO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("FLGANAVAL",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _flgvali = Read_Cursor.GetString("FLGVALIDO");
          _flganag = Read_Cursor.GetString("FLGANAVAL");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo_agg into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _flgvali = "";
          _flganag = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* _tipper := iif(Empty(LRTrim(Substr(riga,288,1))),'G','P') */
        _tipper = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,288,1)))?"G":"P");
        /* xSesso := iif(Substr(riga,288,1)='M','1',iif(Substr(riga,288,1)='F','2',Substr(riga,288,1))) */
        xSesso = (CPLib.eqr(CPLib.Substr(riga,288,1),"M")?"1":(CPLib.eqr(CPLib.Substr(riga,288,1),"F")?"2":CPLib.Substr(riga,288,1)));
        /* xCFE := iif(_flgvali='S',0,iif(LRTrim(Substr(riga,458,1))='S',0,1)) */
        xCFE = CPLib.Round((CPLib.eqr(_flgvali,"S")?0:(CPLib.eqr(CPLib.LRTrim(CPLib.Substr(riga,458,1)),"S")?0:1)),0);
        /* xCF := iif(_flgvali='S',Upper(_oldcf),Upper(LRTrim(Substr(riga,112,16)))) */
        xCF = (CPLib.eqr(_flgvali,"S")?CPLib.Upper(_oldcf):CPLib.Upper(CPLib.LRTrim(CPLib.Substr(riga,112,16))));
        /* xCodCab := Substr(riga,1,6) */
        xCodCab = CPLib.Substr(riga,1,6);
        /* If Empty(LRTrim(xCodCab)) */
        if (CPLib.Empty(CPLib.LRTrim(xCodCab))) {
          /* xCitta := Substr(riga,230,30) */
          xCitta = CPLib.Substr(riga,230,30);
          // * --- Read from tbcitta
          m_cServer = m_Ctx.GetServer("tbcitta");
          m_cPhName = m_Ctx.GetPhName("tbcitta");
          m_cSql = "";
          m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(xCitta,"C",60,0,m_cServer),m_cServer,xCitta);
          if (m_Ctx.IsSharedTemp("tbcitta")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            xCodCab = Read_Cursor.GetString("CAB");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_import_rtra_errori returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            xCodCab = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
        } // End If
        /* cSNAS := '' */
        cSNAS = "";
        /* cCNAS := Substr(riga,136,30) */
        cCNAS = CPLib.Substr(riga,136,30);
        /* If (Substr(xCF,12,1) = 'Z' or Substr(riga,456,2)='EE') and (Substr(riga,288,1)='M' or Substr(riga,288,1)='F') */
        if ((CPLib.eqr(CPLib.Substr(xCF,12,1),"Z") || CPLib.eqr(CPLib.Substr(riga,456,2),"EE")) && (CPLib.eqr(CPLib.Substr(riga,288,1),"M") || CPLib.eqr(CPLib.Substr(riga,288,1),"F"))) {
          /* cSNAS := Substr(riga,136,30) */
          cSNAS = CPLib.Substr(riga,136,30);
          /* cCNAS := '' */
          cCNAS = "";
        } // End If
        /* _oldcog := iif(_flganag='S',_oldcog,Upper(Substr(riga,305,26))) */
        _oldcog = (CPLib.eqr(_flganag,"S")?_oldcog:CPLib.Upper(CPLib.Substr(riga,305,26)));
        /* _oldnom := iif(_flganag='S',_oldnom,Upper(Substr(riga,331,25))) */
        _oldnom = (CPLib.eqr(_flganag,"S")?_oldnom:CPLib.Upper(CPLib.Substr(riga,331,25)));
        /* _oldrgs := iif(_flganag='S',_oldrgs,Upper(Substr(riga,7,70))) */
        _oldrgs = (CPLib.eqr(_flganag,"S")?_oldrgs:CPLib.Upper(CPLib.Substr(riga,7,70)));
        /* _oldncm := iif(_flganag='S',_oldncm,cCNAS) */
        _oldncm = (CPLib.eqr(_flganag,"S")?_oldncm:cCNAS);
        /* _oldnst := iif(_flganag='S',_oldnst,cSNAS) */
        _oldnst = (CPLib.eqr(_flganag,"S")?_oldnst:cSNAS);
        /* _oldndt := iif(_flganag='S',_oldndt,CharToDate(Substr(riga,132,4)+Substr(riga,130,2)+Substr(riga,128,2))) */
        _oldndt = (CPLib.eqr(_flganag,"S")?_oldndt:CPLib.CharToDate(CPLib.Substr(riga,132,4)+CPLib.Substr(riga,130,2)+CPLib.Substr(riga,128,2)));
        /* _oldnpv := iif(_flganag='S',_oldnpv,Upper(Substr(riga,456,2))) */
        _oldnpv = (CPLib.eqr(_flganag,"S")?_oldnpv:CPLib.Upper(CPLib.Substr(riga,456,2)));
        /* _oldnsx := iif(_flganag='S',_oldnsx,xSesso) */
        _oldnsx = (CPLib.eqr(_flganag,"S")?_oldnsx:xSesso);
        /* _oldest := iif(_flgvali='S',_oldest,xCFE) */
        _oldest = CPLib.Round((CPLib.eqr(_flgvali,"S")?_oldest:xCFE),0);
      } // End If
      /* If Empty(xConnes) */
      if (CPLib.Empty(xConnes)) {
        /* nProgImp := nProgImp + 1 */
        nProgImp = CPLib.Round(nProgImp+1,0);
        // * --- Insert into personbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"0000076E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000076E(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(arfn_conv_stato_uicR.Make(m_Ctx,this).Run(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,478,5)),3)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,468,10),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,200,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,265,9),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xCFE,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xCodCab,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(xCF,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_oldcog,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(CPLib.Substr(riga,463,5)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cCli1,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_oldndt,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,196,4)+CPLib.Substr(riga,194,2)+CPLib.Substr(riga,192,2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,293,4)+CPLib.Substr(riga,291,2)+CPLib.Substr(riga,289,2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(CPLib.Substr(riga,230,30)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,356,100),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,77,35),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_oldncm,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_oldnst,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_oldnom,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,177,15),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(arfn_conv_stato_uicR.Make(m_Ctx,this).Run(CPLib.Substr(riga,262,3)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,274,14),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.Substr(riga,495,1))?"N":CPLib.Substr(riga,495,1)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,459,4),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Upper(CPLib.Substr(riga,260,2)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_oldrgs,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_oldrgs,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,169,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,492,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,489,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,486,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,483,3)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_oldnsx,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,172,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,166,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_oldnpv,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,175,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipper,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_datvarage,"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
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
        /* cNumNew := cNumNew + 1 */
        cNumNew = CPLib.Round(cNumNew+1,0);
      } else { // Else
        /* xRiga1 := Upper(xCF)+Substr(riga,7,70)+Substr(riga,77,35)+Substr(riga,230,30)+Substr(riga,260,2)+LibreriaMit.SpacePad(LRTrim(Substr(riga,265,9)),5)+Substr(riga,262,3)+Substr(riga,166,3)+Substr(riga,169,3)+Substr(riga,172,3) */
        xRiga1 = CPLib.Upper(xCF)+CPLib.Substr(riga,7,70)+CPLib.Substr(riga,77,35)+CPLib.Substr(riga,230,30)+CPLib.Substr(riga,260,2)+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Substr(riga,265,9)),5)+CPLib.Substr(riga,262,3)+CPLib.Substr(riga,166,3)+CPLib.Substr(riga,169,3)+CPLib.Substr(riga,172,3);
        /* xRiga1 := xRiga1+LibreriaMit.SpacePad(Left(cCNAS,30),30)+Substr(riga,456,2)+LibreriaMit.SpacePad(Left(cSNAS,30),30) */
        xRiga1 = xRiga1+LibreriaMit.SpacePad(CPLib.Left(cCNAS,30),30)+CPLib.Substr(riga,456,2)+LibreriaMit.SpacePad(CPLib.Left(cSNAS,30),30);
        /* xRiga1 := xRiga1+CharToDate(Substr(riga,132,4)+Substr(riga,130,2)+Substr(riga,128,2)) */
        xRiga1 = xRiga1+CPLib.CharToDate(CPLib.Substr(riga,132,4)+CPLib.Substr(riga,130,2)+CPLib.Substr(riga,128,2));
        /* xRiga1 := xRiga1+Substr(riga,175,2)+Substr(riga,177,15)+Substr(riga,196,4)+Substr(riga,194,2)+Substr(riga,192,2)+Substr(riga,200,30)+Substr(riga,274,14) */
        xRiga1 = xRiga1+CPLib.Substr(riga,175,2)+CPLib.Substr(riga,177,15)+CPLib.Substr(riga,196,4)+CPLib.Substr(riga,194,2)+CPLib.Substr(riga,192,2)+CPLib.Substr(riga,200,30)+CPLib.Substr(riga,274,14);
        /* xRiga3 := Upper(xCF)+Substr(riga,7,70)+Substr(riga,230,30)+Substr(riga,260,2) */
        xRiga3 = CPLib.Upper(xCF)+CPLib.Substr(riga,7,70)+CPLib.Substr(riga,230,30)+CPLib.Substr(riga,260,2);
        /* xRiga3 := xRiga3+LibreriaMit.SpacePad(Left(cCNAS,30),30)+Substr(riga,456,2)+LibreriaMit.SpacePad(Left(cSNAS,30),30) */
        xRiga3 = xRiga3+LibreriaMit.SpacePad(CPLib.Left(cCNAS,30),30)+CPLib.Substr(riga,456,2)+LibreriaMit.SpacePad(CPLib.Left(cSNAS,30),30);
        /* xRiga3 := xRiga3+CharToDate(Substr(riga,132,4)+Substr(riga,130,2)+Substr(riga,128,2))+xSesso */
        xRiga3 = xRiga3+CPLib.CharToDate(CPLib.Substr(riga,132,4)+CPLib.Substr(riga,130,2)+CPLib.Substr(riga,128,2))+xSesso;
        /* xRiga5 := LibreriaMit.SpacePad(Upper(xCF),16)+Substr(riga,7,70)+Substr(riga,230,30)+Substr(riga,262,3)+Substr(riga,260,2) */
        xRiga5 = LibreriaMit.SpacePad(CPLib.Upper(xCF),16)+CPLib.Substr(riga,7,70)+CPLib.Substr(riga,230,30)+CPLib.Substr(riga,262,3)+CPLib.Substr(riga,260,2);
        /* xRiga5 := xRiga5+Substr(riga,305,26)+Substr(riga,331,25)+xSesso */
        xRiga5 = xRiga5+CPLib.Substr(riga,305,26)+CPLib.Substr(riga,331,25)+xSesso;
        /* xRiga5 := xRiga5+Substr(riga,132,4)+Substr(riga,130,2)+Substr(riga,128,2)+LibreriaMit.SpacePad(Left(cCNAS,30),30)+Substr(riga,456,2) */
        xRiga5 = xRiga5+CPLib.Substr(riga,132,4)+CPLib.Substr(riga,130,2)+CPLib.Substr(riga,128,2)+LibreriaMit.SpacePad(CPLib.Left(cCNAS,30),30)+CPLib.Substr(riga,456,2);
        /* xRiga5 := xRiga5+LibreriaMit.SpacePad(Left(cSNAS,30),30)+xCFE */
        xRiga5 = xRiga5+LibreriaMit.SpacePad(CPLib.Left(cSNAS,30),30)+xCFE;
        /* Crea la riga di confronto */
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer, m_oParameters),m_cServer,xConnes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* xRiga2 := LibreriaMit.SpacePad(personbo->CODFISC,16) */
          xRiga2 = LibreriaMit.SpacePad(Cursor_personbo.GetString("CODFISC"),16);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->RAGSOC,70) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("RAGSOC"),70);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->DOMICILIO,35) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("DOMICILIO"),35);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->DESCCIT,30) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("DESCCIT"),30);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->PROVINCIA,2) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("PROVINCIA"),2);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(LRTrim(personbo->CAP),5) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_personbo.GetString("CAP")),5);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->PAESE,3) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("PAESE"),3);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->SOTGRUP,3) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("SOTGRUP"),3);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->RAMOGRUP,3) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("RAMOGRUP"),3);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->SETTSINT,3) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("SETTSINT"),3);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(Left(personbo->NASCOMUN,30),30) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(CPLib.Left(Cursor_personbo.GetString("NASCOMUN"),30),30);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(personbo->TIPINTER,2) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("TIPINTER"),2);
          /* xRiga2 := xRiga2 + LibreriaMit.SpacePad(Left(personbo->NASSTATO,30),30) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(CPLib.Left(Cursor_personbo.GetString("NASSTATO"),30),30);
          /* xRiga2 := xRiga2 + iif(DateToChar(personbo->DATANASC) <> '01000101',LibreriaMit.SpacePad(DateToChar(personbo->DATANASC),8),Space(8)) */
          xRiga2 = xRiga2+(CPLib.ne(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),8):CPLib.Space(8));
          /* xRiga2 := xRiga2 +LibreriaMit.SpacePad(personbo->TIPODOC,2) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("TIPODOC"),2);
          /* xRiga2 := xRiga2 +LibreriaMit.SpacePad(personbo->NUMDOCUM,15) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("NUMDOCUM"),15);
          /* xRiga2 := xRiga2 + iif(DateToChar(personbo->DATARILASC) <> '01000101',LibreriaMit.SpacePad(DateToChar(personbo->DATARILASC),8),Space(8)) */
          xRiga2 = xRiga2+(CPLib.ne(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_personbo.GetDate("DATARILASC")),8):CPLib.Space(8));
          /* xRiga2 := xRiga2 +LibreriaMit.SpacePad(personbo->AUTRILASC,30) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("AUTRILASC"),30);
          /* xRiga2 := xRiga2 +LibreriaMit.SpacePad(personbo->PARTIVA,14) */
          xRiga2 = xRiga2+LibreriaMit.SpacePad(Cursor_personbo.GetString("PARTIVA"),14);
          /* xRiga4 := LibreriaMit.SpacePad(personbo->CODFISC,16) */
          xRiga4 = LibreriaMit.SpacePad(Cursor_personbo.GetString("CODFISC"),16);
          /* xRiga4 := xRiga4 + LibreriaMit.SpacePad(personbo->RAGSOC,70) */
          xRiga4 = xRiga4+LibreriaMit.SpacePad(Cursor_personbo.GetString("RAGSOC"),70);
          /* xRiga4 := xRiga4 + LibreriaMit.SpacePad(personbo->DESCCIT,30) */
          xRiga4 = xRiga4+LibreriaMit.SpacePad(Cursor_personbo.GetString("DESCCIT"),30);
          /* xRiga4 := xRiga4 + LibreriaMit.SpacePad(personbo->PROVINCIA,2) */
          xRiga4 = xRiga4+LibreriaMit.SpacePad(Cursor_personbo.GetString("PROVINCIA"),2);
          /* xRiga4 := xRiga4 + LibreriaMit.SpacePad(Left(personbo->NASCOMUN,30),30) */
          xRiga4 = xRiga4+LibreriaMit.SpacePad(CPLib.Left(Cursor_personbo.GetString("NASCOMUN"),30),30);
          /* xRiga4 := xRiga4 + LibreriaMit.SpacePad(personbo->TIPINTER,2) */
          xRiga4 = xRiga4+LibreriaMit.SpacePad(Cursor_personbo.GetString("TIPINTER"),2);
          /* xRiga4 := xRiga4 + LibreriaMit.SpacePad(Left(personbo->NASSTATO,30),30) */
          xRiga4 = xRiga4+LibreriaMit.SpacePad(CPLib.Left(Cursor_personbo.GetString("NASSTATO"),30),30);
          /* xRiga4 := xRiga4 + iif(DateToChar(personbo->DATANASC) <> '01000101',LibreriaMit.SpacePad(DateToChar(personbo->DATANASC),8),Space(8)) */
          xRiga4 = xRiga4+(CPLib.ne(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),8):CPLib.Space(8));
          /* xRiga4 := xRiga4 + LibreriaMit.SpacePad(personbo->SESSO,1) */
          xRiga4 = xRiga4+LibreriaMit.SpacePad(Cursor_personbo.GetString("SESSO"),1);
          /* xRiga6 := LibreriaMit.SpacePad(personbo->CODFISC,16) */
          xRiga6 = LibreriaMit.SpacePad(Cursor_personbo.GetString("CODFISC"),16);
          /* xRiga6 := xRiga6 + LibreriaMit.SpacePad(personbo->RAGSOC,70) */
          xRiga6 = xRiga6+LibreriaMit.SpacePad(Cursor_personbo.GetString("RAGSOC"),70);
          /* xRiga6 := xRiga6 + LibreriaMit.SpacePad(personbo->DESCCIT,30) */
          xRiga6 = xRiga6+LibreriaMit.SpacePad(Cursor_personbo.GetString("DESCCIT"),30);
          /* xRiga6 := xRiga6 + LibreriaMit.SpacePad(personbo->PAESE,3) */
          xRiga6 = xRiga6+LibreriaMit.SpacePad(Cursor_personbo.GetString("PAESE"),3);
          /* xRiga6 := xRiga6 + LibreriaMit.SpacePad(personbo->PROVINCIA,2) */
          xRiga6 = xRiga6+LibreriaMit.SpacePad(Cursor_personbo.GetString("PROVINCIA"),2);
          /* xRiga6 := xRiga6 + LibreriaMit.SpacePad(personbo->COGNOME,26) */
          xRiga6 = xRiga6+LibreriaMit.SpacePad(Cursor_personbo.GetString("COGNOME"),26);
          /* xRiga6 := xRiga6 + LibreriaMit.SpacePad(personbo->NOME,25) */
          xRiga6 = xRiga6+LibreriaMit.SpacePad(Cursor_personbo.GetString("NOME"),25);
          /* xRiga6 := xRiga6 + LibreriaMit.SpacePad(personbo->SESSO,1) */
          xRiga6 = xRiga6+LibreriaMit.SpacePad(Cursor_personbo.GetString("SESSO"),1);
          /* xRiga6 := xRiga6 + iif(DateToChar(personbo->DATANASC) <> '01000101',LibreriaMit.SpacePad(DateToChar(personbo->DATANASC),8),Space(8)) */
          xRiga6 = xRiga6+(CPLib.ne(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),"01000101")?LibreriaMit.SpacePad(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),8):CPLib.Space(8));
          /* xRiga6 := xRiga6 + LibreriaMit.SpacePad(Left(personbo->NASCOMUN,30),30) */
          xRiga6 = xRiga6+LibreriaMit.SpacePad(CPLib.Left(Cursor_personbo.GetString("NASCOMUN"),30),30);
          /* xRiga6 := xRiga6 + LibreriaMit.SpacePad(personbo->TIPINTER,2) */
          xRiga6 = xRiga6+LibreriaMit.SpacePad(Cursor_personbo.GetString("TIPINTER"),2);
          /* xRiga6 := xRiga6 + LibreriaMit.SpacePad(Left(personbo->NASSTATO,30),30) */
          xRiga6 = xRiga6+LibreriaMit.SpacePad(CPLib.Left(Cursor_personbo.GetString("NASSTATO"),30),30);
          /* xRiga6 := iif(personbo->CFESTERO=1,'1','0') */
          xRiga6 = (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?"1":"0");
          /* Se le due stringhe sono diverse, ci sono delle modifiche da fare. Quindi storicizzo in wersonbo le modifche. */
          /* If LRTrim(xRiga1) <> LRTrim(xRiga2) */
          if (CPLib.ne(CPLib.LRTrim(xRiga1),CPLib.LRTrim(xRiga2))) {
            /* Verifico se c'è già una variazione */
            /* cProgSto := '' */
            cProgSto = "";
            /* _datarett := CharToDate(Substr(riga,301,4)+Substr(riga,299,2)+Substr(riga,297,2)) */
            _datarett = CPLib.CharToDate(CPLib.Substr(riga,301,4)+CPLib.Substr(riga,299,2)+CPLib.Substr(riga,297,2));
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select sanumpro  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer, m_oParameters),m_cServer,xConnes)+"  and  datamodi="+CPSql.SQLValueAdapter(CPLib.ToSQL(_datarett,"?",0,0,m_cServer, m_oParameters),m_cServer,_datarett)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              /* cProgSto := wersonbo->sanumpro */
              cProgSto = Cursor_wersonbo.GetString("sanumpro");
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
            /* If Empty(LRTrim(cProgSto)) */
            if (CPLib.Empty(CPLib.LRTrim(cProgSto))) {
              /* Calcola il progressivo di registrazione */
              /* nProgSto := nProgSto + 1 */
              nProgSto = CPLib.Round(nProgSto+1,0);
              /* cProgSto := Right('000000000000000'+LRTrim(Str(nProgSto,15,0)),15) */
              cProgSto = CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(nProgSto,15,0)),15);
              // * --- Insert into wersonbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("wersonbo");
              m_cPhName = m_Ctx.GetPhName("wersonbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"000007B1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000007B1(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATONOMECNOME"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COMPORT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xConnes,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datarett,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATASEGN"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATEXTRA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("MACROAGENTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDSETSIN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PKTBSPECIE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROGIMP_C"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("PROGIMPORT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOCOLD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RATTIV"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RNATGIU"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SPOTID"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
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
              /* If LRTrim(xRiga3) <> LRTrim(xRiga4) */
              if (CPLib.ne(CPLib.LRTrim(xRiga3),CPLib.LRTrim(xRiga4))) {
                // * --- Select from operazbo
                m_cServer = m_Ctx.GetServer("operazbo");
                m_cPhName = m_Ctx.GetPhName("operazbo");
                if (Cursor_operazbo!=null)
                  Cursor_operazbo.Close();
                Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer, m_oParameters),m_cServer,xConnes)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer, m_oParameters),m_cServer,xConnes)+"  or  CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer, m_oParameters),m_cServer,xConnes)+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_operazbo.Eof())) {
                  /* cNewProg := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(gAzienda)+"'",Space(10),10) */
                  cNewProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
                  /* stringaflagrap2 := 'ABCDEFGHI' // stringa di valori di flagrap2 */
                  stringaflagrap2 = "ABCDEFGHI";
                  /* _idbase := operazbo->IDBASE */
                  _idbase = Cursor_operazbo.GetString("IDBASE");
                  // * --- Select from operazbo
                  m_cServer = m_Ctx.GetServer("operazbo");
                  m_cPhName = m_Ctx.GetPhName("operazbo");
                  if (Cursor_operazbo!=null)
                    Cursor_operazbo.Close();
                  Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,_idbase)+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_operazbo.Eof())) {
                    /* _flagrap2 := iif(Empty(operazbo->FLAGRAP2),Left(stringaflagrap2,1),Substr(stringaflagrap2,(At(operazbo->FLAGRAP2,stringaflagrap2)+1),1)) */
                    _flagrap2 = (CPLib.Empty(Cursor_operazbo.GetString("FLAGRAP2"))?CPLib.Left(stringaflagrap2,1):CPLib.Substr(stringaflagrap2,(CPLib.At(Cursor_operazbo.GetString("FLAGRAP2"),stringaflagrap2)+1),1));
                    // * --- Insert into operazbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("operazbo");
                    m_cPhName = m_Ctx.GetPhName("operazbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"000007B9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000007B9(m_Ctx,m_oWrInfo);
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
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
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
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
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
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
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
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
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
                    m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
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
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("ANNOOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("IDBASE2"),"?",0,0,m_cServer)+", ";
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
                    /* _idb2 := LibreriaMit.UniqueId() */
                    _idb2 = LibreriaMit.UniqueId();
                    /* _idreg := "O"+Right(operazbo->NUMPROG,9)+_idb2 */
                    _idreg = "O"+CPLib.Right(Cursor_operazbo.GetString("NUMPROG"),9)+_idb2;
                    // * --- Write into operazbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("operazbo");
                    m_cPhName = m_Ctx.GetPhName("operazbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"000007BC")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"OPERAZMOD = "+CPLib.ToSQL(Cursor_operazbo.GetString("IDEREG"),"C",20,0,m_cServer)+", ";
                    m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("1","C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                    m_cSql = m_cSql+"IDBASE2 = "+CPLib.ToSQL(_idb2,"C",10,0,m_cServer)+", ";
                    m_cSql = m_cSql+"IDEREG = "+CPLib.ToSQL(_idreg,"C",20,0,m_cServer)+", ";
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
                    Cursor_operazbo.Next();
                  }
                  m_cConnectivityError = Cursor_operazbo.ErrorMessage();
                  Cursor_operazbo.Close();
                  // * --- End Select
                  Cursor_operazbo.Next();
                }
                m_cConnectivityError = Cursor_operazbo.ErrorMessage();
                Cursor_operazbo.Close();
                // * --- End Select
                // * --- Select from fraziobo
                m_cServer = m_Ctx.GetServer("fraziobo");
                m_cPhName = m_Ctx.GetPhName("fraziobo");
                if (Cursor_fraziobo!=null)
                  Cursor_fraziobo.Close();
                Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer, m_oParameters),m_cServer,xConnes)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer, m_oParameters),m_cServer,xConnes)+"  or  CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer, m_oParameters),m_cServer,xConnes)+" "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_fraziobo.Eof())) {
                  /* cNewProg := Utilities.GetAutonumber("PFRAZIO1\'"+LRTrim(gAzienda)+"'",Space(10),10) */
                  cNewProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
                  /* stringaflagrap2 := 'JLMNOTUV?' // stringa di valori di flagrap2 */
                  stringaflagrap2 = "JLMNOTUV?";
                  /* _idbase := fraziobo->IDBASE */
                  _idbase = Cursor_fraziobo.GetString("IDBASE");
                  // * --- Select from fraziobo
                  m_cServer = m_Ctx.GetServer("fraziobo");
                  m_cPhName = m_Ctx.GetPhName("fraziobo");
                  if (Cursor_fraziobo!=null)
                    Cursor_fraziobo.Close();
                  Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,_idbase)+" "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_fraziobo.Eof())) {
                    /* _flagrap2 := iif(Empty(fraziobo->FLAGRAP2),Left(stringaflagrap2,1),Substr(stringaflagrap2,(At(fraziobo->FLAGRAP2,stringaflagrap2)+1),1)) */
                    _flagrap2 = (CPLib.Empty(Cursor_fraziobo.GetString("FLAGRAP2"))?CPLib.Left(stringaflagrap2,1):CPLib.Substr(stringaflagrap2,(CPLib.At(Cursor_fraziobo.GetString("FLAGRAP2"),stringaflagrap2)+1),1));
                    // * --- Insert into fraziobo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("fraziobo");
                    m_cPhName = m_Ctx.GetPhName("fraziobo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"000007C3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000007C3(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("CAMBIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAREG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_flagrap2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("NOPROT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
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
                    m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
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
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAIMP"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("MTCN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("ANNOOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("IDBASE2"),"?",0,0,m_cServer)+", ";
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
                    /* _idb2 := LibreriaMit.UniqueId() */
                    _idb2 = LibreriaMit.UniqueId();
                    /* _idreg := "F"+Right(fraziobo->NUMPROG,9)+_idb2 */
                    _idreg = "F"+CPLib.Right(Cursor_fraziobo.GetString("NUMPROG"),9)+_idb2;
                    // * --- Write into fraziobo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("fraziobo");
                    m_cPhName = m_Ctx.GetPhName("fraziobo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"000007C6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"OPERAZMOD = "+CPLib.ToSQL(Cursor_fraziobo.GetString("IDEREG"),"C",20,0,m_cServer)+", ";
                    m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("1","C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                    m_cSql = m_cSql+"IDBASE2 = "+CPLib.ToSQL(_idb2,"C",10,0,m_cServer)+", ";
                    m_cSql = m_cSql+"IDEREG = "+CPLib.ToSQL(_idreg,"C",20,0,m_cServer)+", ";
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
                    Cursor_fraziobo.Next();
                  }
                  m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
                  Cursor_fraziobo.Close();
                  // * --- End Select
                  Cursor_fraziobo.Next();
                }
                m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
                Cursor_fraziobo.Close();
                // * --- End Select
              } // End If
            } // End If
          } // End If
          /* If LRTrim(xRiga5) <> LRTrim(xRiga6) */
          if (CPLib.ne(CPLib.LRTrim(xRiga5),CPLib.LRTrim(xRiga6))) {
            /* Exec Routine arrt_ae_agg_aetesta_sog(xConnes,_oldest) */
            arrt_ae_agg_aetesta_sogR.Make(m_Ctx,this).Run(xConnes,_oldest);
          } // End If
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
        /* Verifico se il soggetto è una persona fisica */
        /* _datvarage := CharToDate(Substr(riga,301,4)+Substr(riga,299,2)+Substr(riga,297,2)) */
        _datvarage = CPLib.CharToDate(CPLib.Substr(riga,301,4)+CPLib.Substr(riga,299,2)+CPLib.Substr(riga,297,2));
        /* If Substr(riga,288,1)='M' or Substr(riga,288,1)='F' */
        if (CPLib.eqr(CPLib.Substr(riga,288,1),"M") || CPLib.eqr(CPLib.Substr(riga,288,1),"F")) {
          // * --- Write into personbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"000007CC")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(CPLib.Substr(riga,468,10),"C",10,0,m_cServer)+", ";
          m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Substr(riga,200,30),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Substr(riga,265,9),"C",9,0,m_cServer)+", ";
          m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(_oldest,"N",1,0)+", ";
          m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(xCF,"C",16,0,m_cServer)+", ";
          m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(_oldcog,"C",26,0,m_cServer)+", ";
          m_cSql = m_cSql+"COMPORT = "+CPLib.ToSQL(CPLib.Substr(riga,463,5),"C",5,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(_oldndt,"D",8,0)+", ";
          m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,196,4)+CPLib.Substr(riga,194,2)+CPLib.Substr(riga,192,2)),"D",8,0)+", ";
          m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,293,4)+CPLib.Substr(riga,291,2)+CPLib.Substr(riga,289,2)),"D",8,0)+", ";
          m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Upper(CPLib.Substr(riga,230,30)),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(CPLib.Substr(riga,356,100),"C",100,0,m_cServer)+", ";
          m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Substr(riga,77,35),"C",35,0,m_cServer)+", ";
          m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(_oldncm,"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(_oldnst,"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(_oldnom,"C",25,0,m_cServer)+", ";
          m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Substr(riga,177,15),"C",15,0,m_cServer)+", ";
          m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(arfn_conv_stato_uicR.Make(m_Ctx,this).Run(CPLib.Substr(riga,262,3)),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"PARTIVA = "+CPLib.ToSQL(CPLib.Substr(riga,274,14),"C",14,0,m_cServer)+", ";
          m_cSql = m_cSql+"PKTBSPECIE = "+CPLib.ToSQL(CPLib.Substr(riga,459,4),"C",4,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Upper(CPLib.Substr(riga,260,2)),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(_oldrgs,"C",70,0,m_cServer)+", ";
          m_cSql = m_cSql+"RAGSOCOLD = "+CPLib.ToSQL(_oldrgs,"C",70,0,m_cServer)+", ";
          m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,169,3),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(_oldnsx,"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(CPLib.Substr(riga,172,3),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,166,3),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(_oldnpv,"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(CPLib.Substr(riga,175,2),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATAVARAGE = "+CPLib.ToSQL(_datvarage,"D",8,0)+", ";
          m_cSql = m_cSql+"PEP = "+CPLib.ToSQL((CPLib.Empty(CPLib.Substr(riga,495,1))?"N":CPLib.Substr(riga,495,1)),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"AREAGEO = "+CPLib.ToSQL(arfn_conv_stato_uicR.Make(m_Ctx,this).Run(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,478,5)),3)),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"RAREA = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,492,3)),"N",3,0)+", ";
          m_cSql = m_cSql+"RATTIV = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,489,3)),"N",3,0)+", ";
          m_cSql = m_cSql+"RCOMP = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,486,3)),"N",3,0)+", ";
          m_cSql = m_cSql+"RNATGIU = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,483,3)),"N",3,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer),m_cServer,xConnes)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            m_cLastMsgError = "Errore in aggiornamento PERSNEW";
          }
          /* cNumMod := cNumMod + 1 */
          cNumMod = CPLib.Round(cNumMod+1,0);
        } else { // Else
          /* Se non è persona fisica */
          // * --- Write into personbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"000007CF")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(CPLib.Substr(riga,468,10),"C",10,0,m_cServer)+", ";
          m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Substr(riga,200,30),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Substr(riga,265,9),"C",9,0,m_cServer)+", ";
          m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(_oldest,"N",1,0)+", ";
          m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(xCodCab,"C",6,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(xCF,"C",16,0,m_cServer)+", ";
          m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(_oldcog,"C",26,0,m_cServer)+", ";
          m_cSql = m_cSql+"COMPORT = "+CPLib.ToSQL(CPLib.Substr(riga,463,5),"C",5,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(_oldndt,"D",8,0)+", ";
          m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,196,4)+CPLib.Substr(riga,194,2)+CPLib.Substr(riga,192,2)),"D",8,0)+", ";
          m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,293,4)+CPLib.Substr(riga,291,2)+CPLib.Substr(riga,289,2)),"D",8,0)+", ";
          m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Upper(CPLib.Substr(riga,230,30)),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(CPLib.Substr(riga,356,100),"C",100,0,m_cServer)+", ";
          m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Substr(riga,77,35),"C",35,0,m_cServer)+", ";
          m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(_oldncm,"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(_oldnst,"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(_oldnom,"C",25,0,m_cServer)+", ";
          m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Substr(riga,177,15),"C",15,0,m_cServer)+", ";
          m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(arfn_conv_stato_uicR.Make(m_Ctx,this).Run(CPLib.Substr(riga,262,3)),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"PARTIVA = "+CPLib.ToSQL(CPLib.Substr(riga,274,14),"C",14,0,m_cServer)+", ";
          m_cSql = m_cSql+"PKTBSPECIE = "+CPLib.ToSQL(CPLib.Substr(riga,459,4),"C",4,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Upper(CPLib.Substr(riga,260,2)),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(_oldrgs,"C",70,0,m_cServer)+", ";
          m_cSql = m_cSql+"RAGSOCOLD = "+CPLib.ToSQL(_oldrgs,"C",70,0,m_cServer)+", ";
          m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,169,3),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(_oldnsx,"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(CPLib.Substr(riga,172,3),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.Substr(riga,166,3),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(_oldnpv,"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(CPLib.Substr(riga,175,2),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATAVARAGE = "+CPLib.ToSQL(_datvarage,"D",8,0)+", ";
          m_cSql = m_cSql+"PEP = "+CPLib.ToSQL((CPLib.Empty(CPLib.Substr(riga,495,1))?"N":CPLib.Substr(riga,495,1)),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"AREAGEO = "+CPLib.ToSQL(arfn_conv_stato_uicR.Make(m_Ctx,this).Run(CPLib.Left(CPLib.LRTrim(CPLib.Substr(riga,478,5)),3)),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"RAREA = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,492,3)),"N",3,0)+", ";
          m_cSql = m_cSql+"RATTIV = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,489,3)),"N",3,0)+", ";
          m_cSql = m_cSql+"RCOMP = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,486,3)),"N",3,0)+", ";
          m_cSql = m_cSql+"RNATGIU = "+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,483,3)),"N",3,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(xConnes,"?",0,0,m_cServer),m_cServer,xConnes)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            m_cLastMsgError = "Errore in aggiornamento PERSNEW";
          }
          /* cNumMod := cNumMod + 1 */
          cNumMod = CPLib.Round(cNumMod+1,0);
        } // End If
        // * --- Select from qbe_aggfam_opextrbo_new
        SPBridge.HMCaller _h000007D1;
        _h000007D1 = new SPBridge.HMCaller();
        _h000007D1.Set("m_cVQRList",m_cVQRList);
        _h000007D1.Set("CONNES",xConnes);
        if (Cursor_qbe_aggfam_opextrbo_new!=null)
          Cursor_qbe_aggfam_opextrbo_new.Close();
        Cursor_qbe_aggfam_opextrbo_new = new VQRHolder("qbe_aggfam_opextrbo_new",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000007D1,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_aggfam_opextrbo_new.Eof())) {
          // * --- Write into opextrbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"000007D2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL((CPLib.eqr(_oldest,1)?"S":"N"),"C",1,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aggfam_opextrbo_new.GetString("ANNO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aggfam_opextrbo_new.GetString("ANNO"))+"";
          m_cSql = m_cSql+" and COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aggfam_opextrbo_new.GetString("COLLEG"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aggfam_opextrbo_new.GetString("COLLEG"))+"";
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
          Cursor_qbe_aggfam_opextrbo_new.Next();
        }
        m_cConnectivityError = Cursor_qbe_aggfam_opextrbo_new.ErrorMessage();
        Cursor_qbe_aggfam_opextrbo_new.Close();
        // * --- End Select
        /* _anno := Str((Year(Date()) - 10),4,0) */
        _anno = CPLib.Str((CPLib.Year(CPLib.Date())-10),4,0);
        // * --- Select from qbe_aggfam_opextrbo
        SPBridge.HMCaller _h000007D4;
        _h000007D4 = new SPBridge.HMCaller();
        _h000007D4.Set("m_cVQRList",m_cVQRList);
        _h000007D4.Set("CONNES",xConnes);
        _h000007D4.Set("pAnno",_anno);
        if (Cursor_qbe_aggfam_opextrbo!=null)
          Cursor_qbe_aggfam_opextrbo.Close();
        Cursor_qbe_aggfam_opextrbo = new VQRHolder("qbe_aggfam_opextrbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000007D4,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_aggfam_opextrbo.Eof())) {
          // * --- Write into opextrbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"000007D5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL((CPLib.eqr(_oldest,1)?"S":"N"),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aggfam_opextrbo.GetString("ANNO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aggfam_opextrbo.GetString("ANNO"))+"";
          m_cSql = m_cSql+" and COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_aggfam_opextrbo.GetString("COLLEG"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_aggfam_opextrbo.GetString("COLLEG"))+"";
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
          Cursor_qbe_aggfam_opextrbo.Next();
        }
        m_cConnectivityError = Cursor_qbe_aggfam_opextrbo.ErrorMessage();
        Cursor_qbe_aggfam_opextrbo.Close();
        // * --- End Select
      } // End If
      /* If nProgImp > 0 */
      if (CPLib.gt(nProgImp,0)) {
        // * --- Write into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"000007D7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(nProgImp+1,"N",10,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPOCLI\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGIMPOCLI\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
        m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
          // * --- Insert into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"000007D9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000007D9(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PRGIMPOCLI\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(gAzienda,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp+1,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
      /* If nProgSto > 0 */
      if (CPLib.gt(nProgSto,0)) {
        // * --- Write into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"000007DB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(nProgSto+1,"N",10,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'")+"";
        m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gAzienda,"?",0,0,m_cServer),m_cServer,gAzienda)+"";
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
          // * --- Insert into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_rtra_errori",1254,"000007DD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000007DD(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("prog\\PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(gAzienda,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgSto+1,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
    } finally {
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
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
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
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_aggfam_opextrbo_new!=null)
          Cursor_qbe_aggfam_opextrbo_new.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_aggfam_opextrbo!=null)
          Cursor_qbe_aggfam_opextrbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_15() throws Exception {
    /* Formato Excel */
    /* gMsgImp := 'Attendere. Creazione del file excel ...' // Messaggio Import */
    gMsgImp = "Attendere. Creazione del file excel ...";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    /* _nfile := LRTrim(gPathApp)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(_filen) */
    _nfile = CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_filen);
    /* Seleziona i record */
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
    cell =  row.createCell(0);
    cell.setCellValue("CAB");
    cell.setCellStyle(cs);
    cell =  row.createCell(1);
    cell.setCellValue("NOMINATIVO");
    cell.setCellStyle(cs);
    cell = row.createCell(2);
    cell.setCellValue("INDIRIZZO");
    cell.setCellStyle(cs);
    cell = row.createCell(3);
    cell.setCellValue("CODICE FISCALE");
    cell.setCellStyle(cs);
    cell =  row.createCell(4);
    cell.setCellValue("DATA DI NASCITA");
    cell.setCellStyle(cs);
    cell =  row.createCell(5);
    cell.setCellValue("LUOGO DI NASCITA");
    cell.setCellStyle(cs);
    cell =  row.createCell(6);
    cell.setCellValue("SAE");
    cell.setCellStyle(cs);
    cell =  row.createCell(7);
    cell.setCellValue("ATECO");
    cell.setCellStyle(cs);
    cell =  row.createCell(8);
    cell.setCellValue("SETTORE SINTETICO");
    cell.setCellStyle(cs);
    cell = row.createCell(9);
    cell.setCellValue("TIPO DOCUMENTO");
    cell.setCellStyle(cs);
    cell = row.createCell(10);
    cell.setCellValue("NUMERO DOCUMENTO");
    cell.setCellStyle(cs);
    cell = row.createCell(11);
    cell.setCellValue("DATA DI RILASCIO");
    cell.setCellStyle(cs);
    cell = row.createCell(12);
    cell.setCellValue("AUTORITA' DI RILASCIO");
    cell.setCellStyle(cs);
    cell = row.createCell(13);
    cell.setCellValue("CITTA' DI RESIDENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(14);
    cell.setCellValue("PROVINCIA DI RESIDENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(15);
    cell.setCellValue("PAESE DI RESIDENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(16);
    cell.setCellValue("CAP RESIDENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(17);
    cell.setCellValue("FILLER");
    cell.setCellStyle(cs);
    cell = row.createCell(18);
    cell.setCellValue("SESSO");
    cell.setCellStyle(cs);
    cell = row.createCell(19);
    cell.setCellValue("DATA SCADENZA DOCUMENTO");
    cell.setCellStyle(cs);
    cell = row.createCell(20);
    cell.setCellValue("DATA RETTIFICA SOGGETTO");
    cell.setCellStyle(cs);
    cell = row.createCell(21);
    cell.setCellValue("COGNOME");
    cell.setCellStyle(cs);
    cell = row.createCell(22);
    cell.setCellValue("NOME");
    cell.setCellStyle(cs);
    cell = row.createCell(23);
    cell.setCellValue("FILLER");
    cell.setCellStyle(cs);
    cell =  row.createCell(24);
    cell.setCellValue("PROVINCIA DI NASCITA");
    cell.setCellStyle(cs);
    cell =  row.createCell(25);
    cell.setCellValue("CODICE FISCALE NON AGE");
    cell.setCellStyle(cs);
    cell = row.createCell(26);
    cell.setCellValue("FILLER");
    cell.setCellStyle(cs);
    cell = row.createCell(27);
    cell.setCellValue("NDG");
    cell.setCellStyle(cs);
    cell = row.createCell(28);
    cell.setCellValue("FILLER");
    cell.setCellStyle(cs);
    cell = row.createCell(29);
    cell.setCellValue("REGIONE RESIDENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(30);
    cell.setCellValue("OCCUPAZIONE");
    cell.setCellStyle(cs);
    cell = row.createCell(31);
    cell.setCellValue("BLACK LIST INTERNA");
    cell.setCellStyle(cs);
    cell = row.createCell(32);
    cell.setCellValue("LUOGO RILASCIO DOCUMENTO");
    cell.setCellStyle(cs);
    cell = row.createCell(33);
    cell.setCellValue("ERRORE 1");
    cell.setCellStyle(cs);
    cell = row.createCell(34);
    cell.setCellValue("ERRORE 2");
    cell.setCellStyle(cs);
    cell = row.createCell(35);
    cell.setCellValue("ERRORE 3");
    cell.setCellStyle(cs);
    cell = row.createCell(36);
    cell.setCellValue("ERRORE 4");
    cell.setCellStyle(cs);
    cell = row.createCell(37);
    cell.setCellValue("ERRORE 5");
    cell.setCellStyle(cs);
    cell = row.createCell(38);
    cell.setCellValue("ERRORE 6");
    cell.setCellStyle(cs);
    cell = row.createCell(39);
    cell.setCellValue("ERRORE 7");
    cell.setCellStyle(cs);
    cell = row.createCell(40);
    cell.setCellValue("ERRORE 8");
    cell.setCellStyle(cs);
    cell = row.createCell(41);
    cell.setCellValue("ERRORE 9");
    cell.setCellStyle(cs);
    cell = row.createCell(42);
    cell.setCellValue("ERRORE 10");
    cell.setCellStyle(cs);
    cell = row.createCell(43);
    cell.setCellValue("ERRORE 11");
    cell.setCellStyle(cs);
    cell = row.createCell(44);
    cell.setCellValue("ERRORE 12");
    cell.setCellStyle(cs);
    cell = row.createCell(45);
    cell.setCellValue("ERRORE 13");
    cell.setCellStyle(cs);
    cell = row.createCell(46);
    cell.setCellValue("ERRORE 14");
    cell.setCellStyle(cs);
    cell = row.createCell(47);
    cell.setCellValue("ERRORE 15");
    cell.setCellStyle(cs);
    cell = row.createCell(48);
    cell.setCellValue("ERRORE 16");
    cell.setCellStyle(cs);
    cell = row.createCell(49);
    cell.setCellValue("ERRORE 17");
    cell.setCellStyle(cs);
    cell = row.createCell(50);
    cell.setCellValue("ERRORE 18");
    cell.setCellStyle(cs);
    cell = row.createCell(51);
    cell.setCellValue("ERRORE 19");
    cell.setCellStyle(cs);
    cell = row.createCell(52);
    cell.setCellValue("ERRORE 20");
    cell.setCellStyle(cs);
    cell = row.createCell(53);
    cell.setCellValue("ERRORE 21");
    cell.setCellStyle(cs);
    cell = row.createCell(54);
    cell.setCellValue("ERRORE 22");
    cell.setCellStyle(cs);
    cell = row.createCell(55);
    cell.setCellValue("ERRORE 23");
    cell.setCellStyle(cs);
    cell = row.createCell(56);
    cell.setCellValue("ERRORE 24");
    cell.setCellStyle(cs);
    cell = row.createCell(57);
    cell.setCellValue("ERRORE 25");
    cell.setCellStyle(cs);
    cell = row.createCell(58);
    cell.setCellValue("ERRORE 26");
    cell.setCellStyle(cs);
    cell = row.createCell(59);
    cell.setCellValue("ERRORE 27");
    cell.setCellStyle(cs);
    cell = row.createCell(60);
    cell.setCellValue("ERRORE 28");
    cell.setCellStyle(cs);
    cell = row.createCell(61);
    cell.setCellValue("OPERAZIONE CORRETTA");
    cell.setCellStyle(cs);
    cell = row.createCell(62);
    cell.setCellValue("FORZA SCRITTURA");
    cell.setCellStyle(cs);
    r++;
    for (MemoryCursorRow_mcerratedef_mcrdef rowErrate : mcErrate._iterable_()) {
      // Scrive la riga
      row = sheet.createRow(r);
      cell = row.createCell(0);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna01));
      cell = row.createCell(1);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna02));
      cell = row.createCell(2);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna03));
      cell = row.createCell(3);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna04));
      cell = row.createCell(4);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna05));
      cell = row.createCell(5);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna06));
      cell = row.createCell(6);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna07));
      cell = row.createCell(7);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna08));
      cell = row.createCell(8);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna09));
      cell = row.createCell(9);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna10));
      cell = row.createCell(10);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna11));
      cell = row.createCell(11);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna12));
      cell = row.createCell(12);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna13));
      cell = row.createCell(13);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna14));
      cell = row.createCell(14);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna15));
      cell = row.createCell(15);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna16));
      cell = row.createCell(16);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna17));
      cell = row.createCell(17);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna18));
      cell = row.createCell(18);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna19));
      cell = row.createCell(19);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna20));
      cell = row.createCell(20);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna21));
      cell = row.createCell(21);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna22));
      cell = row.createCell(22);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna23));
      cell = row.createCell(23);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna24));
      cell = row.createCell(24);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna25));
      cell = row.createCell(25);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna26));
      cell = row.createCell(26);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna27));
      cell = row.createCell(27);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna28));
      cell = row.createCell(28);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna29));
      cell = row.createCell(29);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna30));
      cell = row.createCell(30);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna31));
      cell = row.createCell(31);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna32));
      cell = row.createCell(32);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna33));
      cell = row.createCell(33);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna34));
      cell = row.createCell(34);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna35));
      cell = row.createCell(35);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna36));
      cell = row.createCell(36);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna37));
      cell = row.createCell(37);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna38));
      cell = row.createCell(38);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna39));
      cell = row.createCell(39);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna40));
      cell = row.createCell(40);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna41));
      cell = row.createCell(41);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna42));
      cell = row.createCell(42);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna43));
      cell = row.createCell(43);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna44));
      cell = row.createCell(44);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna45));
      cell = row.createCell(45);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna46));
      cell = row.createCell(46);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna47));
      cell = row.createCell(47);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna48));
      cell = row.createCell(48);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna49));
      cell = row.createCell(49);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna50));
      cell = row.createCell(50);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna51));
      cell = row.createCell(51);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna52));
      cell = row.createCell(52);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna53));
      cell = row.createCell(53);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna54));
      cell = row.createCell(54);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna55));
      cell = row.createCell(55);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna56));
      cell = row.createCell(56);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna57));
      cell = row.createCell(57);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna58));
      cell = row.createCell(58);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna59));
      cell = row.createCell(59);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna60));
      cell = row.createCell(60);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna61));
      cell = row.createCell(61);
      cell.setCellValue(CPLib.LRTrim("N"));
      cell = row.createCell(62);
      cell.setCellValue(CPLib.LRTrim("N"));
      r++;
    }
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
    sheet.autoSizeColumn(30);
    sheet.autoSizeColumn(31);
    sheet.autoSizeColumn(32);
    sheet.autoSizeColumn(33);
    sheet.autoSizeColumn(34);
    sheet.autoSizeColumn(35);
    sheet.autoSizeColumn(36);
    sheet.autoSizeColumn(37);
    sheet.autoSizeColumn(38);
    sheet.autoSizeColumn(39);
    sheet.autoSizeColumn(40);
    sheet.autoSizeColumn(41);
    sheet.autoSizeColumn(42);
    sheet.autoSizeColumn(43);
    sheet.autoSizeColumn(44);
    sheet.autoSizeColumn(45);
    sheet.autoSizeColumn(46);
    sheet.autoSizeColumn(47);
    sheet.autoSizeColumn(48);
    sheet.autoSizeColumn(49);
    sheet.autoSizeColumn(50);
    sheet.autoSizeColumn(51);
    sheet.autoSizeColumn(52);
    sheet.autoSizeColumn(53);
    sheet.autoSizeColumn(54);
    sheet.autoSizeColumn(55);
    sheet.autoSizeColumn(56);
    sheet.autoSizeColumn(57);
    sheet.autoSizeColumn(58);
    sheet.autoSizeColumn(59);
    sheet.autoSizeColumn(60);
    sheet.autoSizeColumn(61);
    sheet.autoSizeColumn(62);
    // scrivo il file di esito
    FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(_nfile));
    //write this workbook to an Outputstream.
    wb.write(fileOut);
    fileOut.flush();
    fileOut.close();
  }
  void _init_() {
  }
  public String RunAsync(String p_w_tipodest) {
    w_tipodest = p_w_tipodest;
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
  public String Run(String p_w_tipodest) {
    w_tipodest = p_w_tipodest;
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
  public static arrt_import_rtra_erroriR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_import_rtra_erroriR(p_Ctx, p_Caller);
  }
  public static arrt_import_rtra_erroriR Make(CPContext p_Ctx) {
    return new arrt_import_rtra_erroriR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_tipodest = CPLib.Space(1);
    _dirfiles = CPLib.Space(100);
    conta = 0;
    _trxdate = CPLib.Space(8);
    fhand = CPLib.Space(1);
    ihand = CPLib.Space(1);
    dhand = CPLib.Space(1);
    dFile = 0;
    dNomeFile = CPLib.Space(100);
    iNomeFile = CPLib.Space(100);
    riga = "";
    _codrap = CPLib.Space(16);
    _luonas = CPLib.Space(50);
    nProg = 0;
    cProg = CPLib.Space(20);
    nomefileimport = CPLib.Space(50);
    xConnes = CPLib.Space(16);
    _tdest = CPLib.Space(1);
    _pos = 0;
    _npos = 0;
    _tipoop = CPLib.Space(1);
    _coddip = CPLib.Space(6);
    _uniquecode = CPLib.Space(18);
    _datope = CPLib.NullDate();
    _datmod = CPLib.NullDate();
    _datreal = CPLib.NullDate();
    _datreg = CPLib.NullDate();
    _impstr = CPLib.Space(20);
    _importo = 0;
    _contanti = 0;
    _flgcash = CPLib.Space(1);
    _statodest = CPLib.Space(3);
    _isodest = CPLib.Space(3);
    _cognome = CPLib.Space(26);
    _nome = CPLib.Space(25);
    _citta = CPLib.Space(40);
    _cap = CPLib.Space(5);
    _via = CPLib.Space(35);
    _paese = CPLib.Space(50);
    _prov = CPLib.Space(2);
    _cab = CPLib.Space(6);
    _cognomecp = CPLib.Space(26);
    _nomecp = CPLib.Space(25);
    _pep = CPLib.Space(1);
    _sesso = CPLib.Space(1);
    _nascitta = CPLib.Space(30);
    _nasstato = CPLib.Space(30);
    _resstato = CPLib.Space(3);
    _nasprov = CPLib.Space(2);
    _nasdata = CPLib.NullDate();
    _tipodoc = CPLib.Space(2);
    _numdoc = CPLib.Space(20);
    _docril = CPLib.NullDate();
    _autril = CPLib.Space(30);
    _docsca = CPLib.NullDate();
    _codfis = CPLib.Space(16);
    _connes = CPLib.Space(16);
    cOpeProg1 = CPLib.Space(10);
    cOpeProg2 = CPLib.Space(11);
    nProgImp = 0;
    xSesso = CPLib.Space(1);
    xCAB = CPLib.Space(6);
    xDIP = CPLib.Space(6);
    xDIPx = CPLib.Space(6);
    cCli1 = CPLib.Space(16);
    xIDB = CPLib.Space(10);
    xData = CPLib.Space(8);
    xDatF = CPLib.Space(8);
    _flgbanca = CPLib.Space(1);
    cNumNew = 0;
    cNumMod = 0;
    cNumInv = 0;
    _esito = 0;
    _idbase = CPLib.Space(10);
    _intercod = CPLib.Space(11);
    _intercit = CPLib.Space(30);
    _intercab = CPLib.Space(6);
    _interprv = CPLib.Space(2);
    _doctype = CPLib.Space(2);
    _codana = CPLib.Space(4);
    _codsin = CPLib.Space(2);
    _segno = CPLib.Space(1);
    _uifdest = CPLib.Space(3);
    cProgSto = CPLib.Space(15);
    _prog = CPLib.Space(10);
    _nocf = 0;
    _condoc = CPLib.Space(50);
    _idfile = CPLib.Space(60);
    _mage = CPLib.Space(5);
    _oldcodfis = CPLib.Space(20);
    _ocodfis = CPLib.Space(16);
    _dtimport = CPLib.NullDateTime();
    _txtope = "";
    _errore = 0;
    _nerrori = 0;
    eProg = 0;
    _codstanas = CPLib.Space(3);
    _codstares = CPLib.Space(3);
    _siglacit = CPLib.Space(4);
    _siglasta = CPLib.Space(4);
    _codcit = CPLib.Space(10);
    _merr = CPLib.Space(100);
    _oldmac = CPLib.Space(5);
    _aggcli = 0;
    _tiperr = CPLib.Space(2);
    _intertip = CPLib.Space(2);
    _listerr = "";
    _tipope = CPLib.Space(2);
    _rapporto = CPLib.Space(25);
    _priga = CPLib.Space(100);
    w_codmage = CPLib.Space(5);
    stringaflagrap2 = CPLib.Space(9);
    _oldidb = CPLib.Space(10);
    _flagrap2 = CPLib.Space(1);
    _idreg = CPLib.Space(20);
    _idb2 = CPLib.Space(10);
    _citdip = CPLib.Space(30);
    _cabdip = CPLib.Space(6);
    _provdip = CPLib.Space(2);
    _id = 0;
    _filename = CPLib.Space(128);
    _dipid = CPLib.Space(6);
    _nfile = CPLib.Space(50);
    _filen = CPLib.Space(50);
    _nerrage = 0;
    _errage = 0;
    mcErrate = new MemoryCursor_mcerratedef_mcrdef();
    rowErrate = new MemoryCursorRow_mcerratedef_mcrdef();
    mcErrAge = new MemoryCursor_mcerratedef_mcrdef();
    mcAgeDuo = new MemoryCursor_mcerratedef_mcrdef();
    mcAgenzie = new MemoryCursor_mcerratedef_mcrdef();
    rowAgenzie = new MemoryCursorRow_mcerratedef_mcrdef();
    _contage = 0;
    _anno = CPLib.Space(4);
    _errorig = 0;
    _ageerr01 = CPLib.Space(80);
    _ageerr02 = CPLib.Space(80);
    _ageerr03 = CPLib.Space(80);
    _ageerr04 = CPLib.Space(80);
    _ageerr05 = CPLib.Space(80);
    _ageerr06 = CPLib.Space(80);
    _ageerr07 = CPLib.Space(80);
    _ageerr08 = CPLib.Space(80);
    _ageerr09 = CPLib.Space(80);
    _ageerr10 = CPLib.Space(80);
    _ageerr11 = CPLib.Space(80);
    _ageerr12 = CPLib.Space(80);
    _ageerr13 = CPLib.Space(80);
    _colonna01 = CPLib.Space(10);
    _colonna02 = CPLib.Space(30);
    _colonna03 = CPLib.Space(40);
    _colonna04 = CPLib.Space(30);
    _colonna05 = CPLib.Space(3);
    _colonna06 = CPLib.Space(2);
    _colonna07 = CPLib.Space(2);
    _colonna08 = CPLib.Space(10);
    _colonna09 = CPLib.Space(10);
    _colonna10 = CPLib.Space(10);
    _colonna11 = CPLib.Space(2);
    _colonna12 = CPLib.Space(1);
    _colonna13 = CPLib.Space(5);
    _flgact = CPLib.Space(1);
    _ndg = CPLib.Space(16);
    _valuta = CPLib.Space(3);
    _valiso = CPLib.Space(3);
    _cittaben = CPLib.Space(30);
    _viaben = CPLib.Space(30);
    _cabben = CPLib.Space(6);
    _capben = CPLib.Space(5);
    _prvben = CPLib.Space(5);
    _agente = CPLib.Space(1);
    w_destfin = CPLib.Space(1);
    _tipintcon = CPLib.Space(2);
    _desintcon = CPLib.Space(50);
    _nazintcon = CPLib.Space(3);
    _cabintcon = CPLib.Space(6);
    _prvintcon = CPLib.Space(2);
    _abichk = CPLib.Space(11);
    _cambio = 0;
    riga_letta = 0;
    foglio = 0;
    _abicab = CPLib.Space(11);
    _conto = CPLib.Space(25);
    _impin = 0;
    _impout = 0;
    _codsae = CPLib.Space(3);
    _setsint = CPLib.Space(3);
    _data = CPLib.NullDate();
    w_CODFISC = CPLib.Space(16);
    w_DATANASC = CPLib.NullDate();
    w_NASCOMUN = CPLib.Space(30);
    w_NASSTATO = CPLib.Space(30);
    w_COGNOME = CPLib.Space(26);
    w_RAGSOC = CPLib.Space(70);
    w_NOME = CPLib.Space(25);
    w_SESSO = CPLib.Space(1);
    _err01 = CPLib.Space(80);
    _err02 = CPLib.Space(80);
    _err03 = CPLib.Space(80);
    _err04 = CPLib.Space(80);
    _err05 = CPLib.Space(80);
    _err06 = CPLib.Space(80);
    _err07 = CPLib.Space(80);
    _err08 = CPLib.Space(80);
    _err09 = CPLib.Space(80);
    _err10 = CPLib.Space(80);
    _err11 = CPLib.Space(80);
    _err12 = CPLib.Space(80);
    _err13 = CPLib.Space(80);
    _err14 = CPLib.Space(80);
    _err15 = CPLib.Space(80);
    _err16 = CPLib.Space(80);
    _err17 = CPLib.Space(80);
    _err18 = CPLib.Space(80);
    _err19 = CPLib.Space(80);
    _err20 = CPLib.Space(80);
    _err21 = CPLib.Space(80);
    _err22 = CPLib.Space(80);
    _err23 = CPLib.Space(80);
    _err24 = CPLib.Space(80);
    _err25 = CPLib.Space(80);
    _err26 = CPLib.Space(80);
    _err27 = CPLib.Space(80);
    _err28 = CPLib.Space(80);
    _err29 = CPLib.Space(80);
    _err30 = CPLib.Space(80);
    _err31 = CPLib.Space(80);
    _err32 = CPLib.Space(80);
    _err33 = CPLib.Space(80);
    _err34 = CPLib.Space(80);
    _err35 = CPLib.Space(80);
    _err36 = CPLib.Space(80);
    _err37 = CPLib.Space(80);
    _err38 = CPLib.Space(80);
    _err39 = CPLib.Space(80);
    _err40 = CPLib.Space(80);
    _err41 = CPLib.Space(80);
    _err42 = CPLib.Space(80);
    _err43 = CPLib.Space(80);
    _err44 = CPLib.Space(80);
    _err45 = CPLib.Space(80);
    _err46 = CPLib.Space(80);
    _err47 = CPLib.Space(80);
    _err48 = CPLib.Space(80);
    _err49 = CPLib.Space(80);
    _err50 = CPLib.Space(80);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_aggfam_opextrbo_new,qbe_aggfam_opextrbo,
  public static final String m_cVQRList = ",qbe_aggfam_opextrbo_new,qbe_aggfam_opextrbo,";
  // ENTITY_BATCHES: ,arfn_chkcodfis,arfn_conv_stato_uic,arfn_fdatetime,arrt_ae_agg_aetesta_sog,arrt_calccodfis_wu,arrt_import_rtra_errori,
  public static final String i_InvokedRoutines = ",arfn_chkcodfis,arfn_conv_stato_uic,arfn_fdatetime,arrt_ae_agg_aetesta_sog,arrt_calccodfis_wu,arrt_import_rtra_errori,";
  public static String[] m_cRunParameterNames={"w_tipodest"};
  protected static String GetFieldsName_00000121(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"priorita,";
    p_cSql = p_cSql+"hyperlynk,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_listafile",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000012E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"priorita,";
    p_cSql = p_cSql+"hyperlynk,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_listafile",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000139(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"priorita,";
    p_cSql = p_cSql+"hyperlynk,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_listafile",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001DA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"AGENTE,";
    p_cSql = p_cSql+"AGACCODE,";
    p_cSql = p_cSql+"CAB,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"IDCITTA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"NAZAGENTE,";
    p_cSql = p_cSql+"OPXSOSCLI,";
    p_cSql = p_cSql+"OPXSOSAGE,";
    p_cSql = p_cSql+"VALCOMPL,";
    p_cSql = p_cSql+"ANOMOPER,";
    p_cSql = p_cSql+"AGEREGIO,";
    p_cSql = p_cSql+"FLGATT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anadip",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000052C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"OLDCODFISC,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000052D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"REGRES,";
    p_cSql = p_cSql+"FLGBL,";
    p_cSql = p_cSql+"CLOCCUPA,";
    p_cSql = p_cSql+"RDCODAUT,";
    p_cSql = p_cSql+"NAZIONE,";
    p_cSql = p_cSql+"CODCLIEST,";
    p_cSql = p_cSql+"CLPRVDOM,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000535(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"datamodi,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"OLDCODFISC,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000539(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"REGRES,";
    p_cSql = p_cSql+"FLGBL,";
    p_cSql = p_cSql+"CLOCCUPA,";
    p_cSql = p_cSql+"RDCODAUT,";
    p_cSql = p_cSql+"NAZIONE,";
    p_cSql = p_cSql+"CODCLIEST,";
    p_cSql = p_cSql+"CLPRVDOM,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000541(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000544(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000054A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNOOPE,";
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
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000054D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000555(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"PROGOPEX,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"opextrbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000563(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000056A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"PROGOPEX,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"opextrbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000076E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"RAGSOCOLD,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"DATAVARAGE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000007B1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"datamodi,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"DATASEGN,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DATEXTRA,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"idcitta,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"OLDCODFISC,";
    p_cSql = p_cSql+"OLDCONNES,";
    p_cSql = p_cSql+"OLDSETSIN,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"PROGIMP_C,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"RAGSOCOLD,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"sanumpro,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"SOSPMAF,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"SPOTID,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000007B9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000007C3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
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
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000007D9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000007DD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+"autonum,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
}
