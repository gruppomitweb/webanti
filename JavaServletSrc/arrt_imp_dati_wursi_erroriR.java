// * --- Area Manuale = BO - Header
// * --- arrt_imp_dati_wursi_errori
import java.util.*;
import java.util.Iterator;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import com.opencsv.*;
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
public class arrt_imp_dati_wursi_erroriR implements CallerWithObjs {
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
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_beneficope;
  public String m_cServer_beneficope;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_docfrabo;
  public String m_cServer_docfrabo;
  public String m_cPhName_docopebo;
  public String m_cServer_docopebo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_kersonbo;
  public String m_cServer_kersonbo;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_meneficope;
  public String m_cServer_meneficope;
  public String m_cPhName_merzistiope;
  public String m_cServer_merzistiope;
  public String m_cPhName_mlientiope;
  public String m_cServer_mlientiope;
  public String m_cPhName_mogopebo;
  public String m_cServer_mogopebo;
  public String m_cPhName_mtimperr;
  public String m_cServer_mtimperr;
  public String m_cPhName_mtimport;
  public String m_cServer_mtimport;
  public String m_cPhName_mtstati;
  public String m_cServer_mtstati;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbmacage;
  public String m_cServer_tbmacage;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_tmp_impwu;
  public String m_cServer_tmp_impwu;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_wuchkimp;
  public String m_cServer_wuchkimp;
  public String m_cPhName_wuchkimp_sf;
  public String m_cServer_wuchkimp_sf;
  public String m_cPhName_wucodes;
  public String m_cServer_wucodes;
  public String m_cPhName_wurapporti;
  public String m_cServer_wurapporti;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xocfrabo;
  public String m_cServer_xocfrabo;
  public String m_cPhName_xocopebo;
  public String m_cServer_xocopebo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_beneficfrz;
  public String m_cServer_beneficfrz;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_meneficfrz;
  public String m_cServer_meneficfrz;
  public String m_cPhName_merzistifrz;
  public String m_cServer_merzistifrz;
  public String m_cPhName_mlientifrz;
  public String m_cServer_mlientifrz;
  public String m_cPhName_mogopefbo;
  public String m_cServer_mogopefbo;
  public String m_cPhName_decodestati;
  public String m_cServer_decodestati;
  public String m_cPhName_decodecitta;
  public String m_cServer_decodecitta;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_tbcittna;
  public String m_cServer_tbcittna;
  public String m_cPhName_tbstatna;
  public String m_cServer_tbstatna;
  public String m_cPhName_tmp_listafile;
  public String m_cServer_tmp_listafile;
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
  public double w_impzip;
  public String w_destfin;
  public String fhand;
  public String _codrap;
  public String _luonas;
  public double nProg;
  public String nomefileimport;
  public String xConnes;
  public String _tdest;
  public double _pos;
  public double _npos;
  public String _tipoop;
  public String _coddip;
  public String _uniquecode;
  public java.sql.Date _datope;
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
  public String w_xMAFLGRAP;
  public String w_xMAFLGBON;
  public String w_xMAFLGCKR;
  public String w_xMAFLGASR;
  public String w_xMADIPSTD;
  public String w_xMAFLGCHKDAT;
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
  public MemoryCursor_mcerratedef_mcrdef mcErrate;
  public MemoryCursorRow_mcerratedef_mcrdef rowErrate;
  public MemoryCursor_mcerratedef_mcrdef mcErrAge;
  public MemoryCursor_mcerratedef_mcrdef mcAgeDuo;
  public double _contage;
  public double cell_count;
  public double riga_letta;
  public double foglio;
  public double _conta;
  public String _idb;
  public String _flgvalage;
  public String _anno;
  public String czipfile;
  public String cpercorsozip;
  public String cdirectoryfile;
  public String buffernomefile;
  public double _priorita;
  public String w_CODFISC;
  public java.sql.Date w_DATANASC;
  public String w_NASCOMUN;
  public String w_NASSTATO;
  public String w_COGNOME;
  public String w_RAGSOC;
  public String w_NOME;
  public String w_SESSO;
  public String gPathApp;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String gUrlApp;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_imp_dati_wursi_errori
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
  public String[] nextLine;
  public int _celle;
  // * --- Fine Area Manuale
  public arrt_imp_dati_wursi_erroriR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_imp_dati_wursi_errori",m_Caller);
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_beneficope = p_ContextObject.GetPhName("beneficope");
    if (m_cPhName_beneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficope = m_cPhName_beneficope+" "+m_Ctx.GetWritePhName("beneficope");
    }
    m_cServer_beneficope = p_ContextObject.GetServer("beneficope");
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    if (m_cPhName_clientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientiope = m_cPhName_clientiope+" "+m_Ctx.GetWritePhName("clientiope");
    }
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    m_cPhName_docfrabo = p_ContextObject.GetPhName("docfrabo");
    if (m_cPhName_docfrabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_docfrabo = m_cPhName_docfrabo+" "+m_Ctx.GetWritePhName("docfrabo");
    }
    m_cServer_docfrabo = p_ContextObject.GetServer("docfrabo");
    m_cPhName_docopebo = p_ContextObject.GetPhName("docopebo");
    if (m_cPhName_docopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_docopebo = m_cPhName_docopebo+" "+m_Ctx.GetWritePhName("docopebo");
    }
    m_cServer_docopebo = p_ContextObject.GetServer("docopebo");
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
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_kersonbo = p_ContextObject.GetPhName("kersonbo");
    if (m_cPhName_kersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_kersonbo = m_cPhName_kersonbo+" "+m_Ctx.GetWritePhName("kersonbo");
    }
    m_cServer_kersonbo = p_ContextObject.GetServer("kersonbo");
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    if (m_cPhName_knarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_knarapbo = m_cPhName_knarapbo+" "+m_Ctx.GetWritePhName("knarapbo");
    }
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
    m_cPhName_meneficope = p_ContextObject.GetPhName("meneficope");
    if (m_cPhName_meneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_meneficope = m_cPhName_meneficope+" "+m_Ctx.GetWritePhName("meneficope");
    }
    m_cServer_meneficope = p_ContextObject.GetServer("meneficope");
    m_cPhName_merzistiope = p_ContextObject.GetPhName("merzistiope");
    if (m_cPhName_merzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_merzistiope = m_cPhName_merzistiope+" "+m_Ctx.GetWritePhName("merzistiope");
    }
    m_cServer_merzistiope = p_ContextObject.GetServer("merzistiope");
    m_cPhName_mlientiope = p_ContextObject.GetPhName("mlientiope");
    if (m_cPhName_mlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mlientiope = m_cPhName_mlientiope+" "+m_Ctx.GetWritePhName("mlientiope");
    }
    m_cServer_mlientiope = p_ContextObject.GetServer("mlientiope");
    m_cPhName_mogopebo = p_ContextObject.GetPhName("mogopebo");
    if (m_cPhName_mogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mogopebo = m_cPhName_mogopebo+" "+m_Ctx.GetWritePhName("mogopebo");
    }
    m_cServer_mogopebo = p_ContextObject.GetServer("mogopebo");
    m_cPhName_mtimperr = p_ContextObject.GetPhName("mtimperr");
    if (m_cPhName_mtimperr.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mtimperr = m_cPhName_mtimperr+" "+m_Ctx.GetWritePhName("mtimperr");
    }
    m_cServer_mtimperr = p_ContextObject.GetServer("mtimperr");
    m_cPhName_mtimport = p_ContextObject.GetPhName("mtimport");
    if (m_cPhName_mtimport.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mtimport = m_cPhName_mtimport+" "+m_Ctx.GetWritePhName("mtimport");
    }
    m_cServer_mtimport = p_ContextObject.GetServer("mtimport");
    m_cPhName_mtstati = p_ContextObject.GetPhName("mtstati");
    if (m_cPhName_mtstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mtstati = m_cPhName_mtstati+" "+m_Ctx.GetWritePhName("mtstati");
    }
    m_cServer_mtstati = p_ContextObject.GetServer("mtstati");
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
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    if (m_cPhName_sogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopebo = m_cPhName_sogopebo+" "+m_Ctx.GetWritePhName("sogopebo");
    }
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
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
    m_cPhName_tbmacage = p_ContextObject.GetPhName("tbmacage");
    if (m_cPhName_tbmacage.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbmacage = m_cPhName_tbmacage+" "+m_Ctx.GetWritePhName("tbmacage");
    }
    m_cServer_tbmacage = p_ContextObject.GetServer("tbmacage");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_terzistiope = p_ContextObject.GetPhName("terzistiope");
    if (m_cPhName_terzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistiope = m_cPhName_terzistiope+" "+m_Ctx.GetWritePhName("terzistiope");
    }
    m_cServer_terzistiope = p_ContextObject.GetServer("terzistiope");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_impwu")) {
      m_cPhName_tmp_impwu = p_ContextObject.GetPhName("tmp_impwu");
      if (m_cPhName_tmp_impwu.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_impwu = m_cPhName_tmp_impwu+" "+m_Ctx.GetWritePhName("tmp_impwu");
      }
      m_cServer_tmp_impwu = p_ContextObject.GetServer("tmp_impwu");
    }
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
    m_cPhName_wuchkimp = p_ContextObject.GetPhName("wuchkimp");
    if (m_cPhName_wuchkimp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wuchkimp = m_cPhName_wuchkimp+" "+m_Ctx.GetWritePhName("wuchkimp");
    }
    m_cServer_wuchkimp = p_ContextObject.GetServer("wuchkimp");
    m_cPhName_wuchkimp_sf = p_ContextObject.GetPhName("wuchkimp_sf");
    if (m_cPhName_wuchkimp_sf.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wuchkimp_sf = m_cPhName_wuchkimp_sf+" "+m_Ctx.GetWritePhName("wuchkimp_sf");
    }
    m_cServer_wuchkimp_sf = p_ContextObject.GetServer("wuchkimp_sf");
    m_cPhName_wucodes = p_ContextObject.GetPhName("wucodes");
    if (m_cPhName_wucodes.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wucodes = m_cPhName_wucodes+" "+m_Ctx.GetWritePhName("wucodes");
    }
    m_cServer_wucodes = p_ContextObject.GetServer("wucodes");
    m_cPhName_wurapporti = p_ContextObject.GetPhName("wurapporti");
    if (m_cPhName_wurapporti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wurapporti = m_cPhName_wurapporti+" "+m_Ctx.GetWritePhName("wurapporti");
    }
    m_cServer_wurapporti = p_ContextObject.GetServer("wurapporti");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_xocfrabo = p_ContextObject.GetPhName("xocfrabo");
    if (m_cPhName_xocfrabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xocfrabo = m_cPhName_xocfrabo+" "+m_Ctx.GetWritePhName("xocfrabo");
    }
    m_cServer_xocfrabo = p_ContextObject.GetServer("xocfrabo");
    m_cPhName_xocopebo = p_ContextObject.GetPhName("xocopebo");
    if (m_cPhName_xocopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xocopebo = m_cPhName_xocopebo+" "+m_Ctx.GetWritePhName("xocopebo");
    }
    m_cServer_xocopebo = p_ContextObject.GetServer("xocopebo");
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    if (m_cPhName_xperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo = m_cPhName_xperazbo+" "+m_Ctx.GetWritePhName("xperazbo");
    }
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_xraziobo = p_ContextObject.GetPhName("xraziobo");
    if (m_cPhName_xraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xraziobo = m_cPhName_xraziobo+" "+m_Ctx.GetWritePhName("xraziobo");
    }
    m_cServer_xraziobo = p_ContextObject.GetServer("xraziobo");
    m_cPhName_sogopefbo = p_ContextObject.GetPhName("sogopefbo");
    if (m_cPhName_sogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopefbo = m_cPhName_sogopefbo+" "+m_Ctx.GetWritePhName("sogopefbo");
    }
    m_cServer_sogopefbo = p_ContextObject.GetServer("sogopefbo");
    m_cPhName_clientifrz = p_ContextObject.GetPhName("clientifrz");
    if (m_cPhName_clientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientifrz = m_cPhName_clientifrz+" "+m_Ctx.GetWritePhName("clientifrz");
    }
    m_cServer_clientifrz = p_ContextObject.GetServer("clientifrz");
    m_cPhName_beneficfrz = p_ContextObject.GetPhName("beneficfrz");
    if (m_cPhName_beneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficfrz = m_cPhName_beneficfrz+" "+m_Ctx.GetWritePhName("beneficfrz");
    }
    m_cServer_beneficfrz = p_ContextObject.GetServer("beneficfrz");
    m_cPhName_terzistifrz = p_ContextObject.GetPhName("terzistifrz");
    if (m_cPhName_terzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistifrz = m_cPhName_terzistifrz+" "+m_Ctx.GetWritePhName("terzistifrz");
    }
    m_cServer_terzistifrz = p_ContextObject.GetServer("terzistifrz");
    m_cPhName_meneficfrz = p_ContextObject.GetPhName("meneficfrz");
    if (m_cPhName_meneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_meneficfrz = m_cPhName_meneficfrz+" "+m_Ctx.GetWritePhName("meneficfrz");
    }
    m_cServer_meneficfrz = p_ContextObject.GetServer("meneficfrz");
    m_cPhName_merzistifrz = p_ContextObject.GetPhName("merzistifrz");
    if (m_cPhName_merzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_merzistifrz = m_cPhName_merzistifrz+" "+m_Ctx.GetWritePhName("merzistifrz");
    }
    m_cServer_merzistifrz = p_ContextObject.GetServer("merzistifrz");
    m_cPhName_mlientifrz = p_ContextObject.GetPhName("mlientifrz");
    if (m_cPhName_mlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mlientifrz = m_cPhName_mlientifrz+" "+m_Ctx.GetWritePhName("mlientifrz");
    }
    m_cServer_mlientifrz = p_ContextObject.GetServer("mlientifrz");
    m_cPhName_mogopefbo = p_ContextObject.GetPhName("mogopefbo");
    if (m_cPhName_mogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mogopefbo = m_cPhName_mogopefbo+" "+m_Ctx.GetWritePhName("mogopefbo");
    }
    m_cServer_mogopefbo = p_ContextObject.GetServer("mogopefbo");
    m_cPhName_decodestati = p_ContextObject.GetPhName("decodestati");
    if (m_cPhName_decodestati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_decodestati = m_cPhName_decodestati+" "+m_Ctx.GetWritePhName("decodestati");
    }
    m_cServer_decodestati = p_ContextObject.GetServer("decodestati");
    m_cPhName_decodecitta = p_ContextObject.GetPhName("decodecitta");
    if (m_cPhName_decodecitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_decodecitta = m_cPhName_decodecitta+" "+m_Ctx.GetWritePhName("decodecitta");
    }
    m_cServer_decodecitta = p_ContextObject.GetServer("decodecitta");
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    m_cPhName_tbcittna = p_ContextObject.GetPhName("tbcittna");
    if (m_cPhName_tbcittna.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcittna = m_cPhName_tbcittna+" "+m_Ctx.GetWritePhName("tbcittna");
    }
    m_cServer_tbcittna = p_ContextObject.GetServer("tbcittna");
    m_cPhName_tbstatna = p_ContextObject.GetPhName("tbstatna");
    if (m_cPhName_tbstatna.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstatna = m_cPhName_tbstatna+" "+m_Ctx.GetWritePhName("tbstatna");
    }
    m_cServer_tbstatna = p_ContextObject.GetServer("tbstatna");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
      m_cPhName_tmp_listafile = p_ContextObject.GetPhName("tmp_listafile");
      if (m_cPhName_tmp_listafile.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_listafile = m_cPhName_tmp_listafile+" "+m_Ctx.GetWritePhName("tmp_listafile");
      }
      m_cServer_tmp_listafile = p_ContextObject.GetServer("tmp_listafile");
    }
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("impzip",p_cVarName)) {
      return w_impzip;
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
    if (CPLib.eqr("_contage",p_cVarName)) {
      return _contage;
    }
    if (CPLib.eqr("cell_count",p_cVarName)) {
      return cell_count;
    }
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      return riga_letta;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      return foglio;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_priorita",p_cVarName)) {
      return _priorita;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_imp_dati_wursi_errori";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("tipodest",p_cVarName)) {
      return w_tipodest;
    }
    if (CPLib.eqr("destfin",p_cVarName)) {
      return w_destfin;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_codrap",p_cVarName)) {
      return _codrap;
    }
    if (CPLib.eqr("_luonas",p_cVarName)) {
      return _luonas;
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
    if (CPLib.eqr("xMAFLGRAP",p_cVarName)) {
      return w_xMAFLGRAP;
    }
    if (CPLib.eqr("xMAFLGBON",p_cVarName)) {
      return w_xMAFLGBON;
    }
    if (CPLib.eqr("xMAFLGCKR",p_cVarName)) {
      return w_xMAFLGCKR;
    }
    if (CPLib.eqr("xMAFLGASR",p_cVarName)) {
      return w_xMAFLGASR;
    }
    if (CPLib.eqr("xMADIPSTD",p_cVarName)) {
      return w_xMADIPSTD;
    }
    if (CPLib.eqr("xMAFLGCHKDAT",p_cVarName)) {
      return w_xMAFLGCHKDAT;
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
    if (CPLib.eqr("_idb",p_cVarName)) {
      return _idb;
    }
    if (CPLib.eqr("_flgvalage",p_cVarName)) {
      return _flgvalage;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      return _anno;
    }
    if (CPLib.eqr("czipfile",p_cVarName)) {
      return czipfile;
    }
    if (CPLib.eqr("cpercorsozip",p_cVarName)) {
      return cpercorsozip;
    }
    if (CPLib.eqr("cdirectoryfile",p_cVarName)) {
      return cdirectoryfile;
    }
    if (CPLib.eqr("buffernomefile",p_cVarName)) {
      return buffernomefile;
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
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
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
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_datope",p_cVarName)) {
      return _datope;
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
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowErrate",p_cVarName)) {
      return rowErrate;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("impzip",p_cVarName)) {
      w_impzip = value;
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
    if (CPLib.eqr("_contage",p_cVarName)) {
      _contage = value;
      return;
    }
    if (CPLib.eqr("cell_count",p_cVarName)) {
      cell_count = value;
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
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_priorita",p_cVarName)) {
      _priorita = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tipodest",p_cVarName)) {
      w_tipodest = value;
      return;
    }
    if (CPLib.eqr("destfin",p_cVarName)) {
      w_destfin = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
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
    if (CPLib.eqr("xMAFLGRAP",p_cVarName)) {
      w_xMAFLGRAP = value;
      return;
    }
    if (CPLib.eqr("xMAFLGBON",p_cVarName)) {
      w_xMAFLGBON = value;
      return;
    }
    if (CPLib.eqr("xMAFLGCKR",p_cVarName)) {
      w_xMAFLGCKR = value;
      return;
    }
    if (CPLib.eqr("xMAFLGASR",p_cVarName)) {
      w_xMAFLGASR = value;
      return;
    }
    if (CPLib.eqr("xMADIPSTD",p_cVarName)) {
      w_xMADIPSTD = value;
      return;
    }
    if (CPLib.eqr("xMAFLGCHKDAT",p_cVarName)) {
      w_xMAFLGCHKDAT = value;
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
    if (CPLib.eqr("_idb",p_cVarName)) {
      _idb = value;
      return;
    }
    if (CPLib.eqr("_flgvalage",p_cVarName)) {
      _flgvalage = value;
      return;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      _anno = value;
      return;
    }
    if (CPLib.eqr("czipfile",p_cVarName)) {
      czipfile = value;
      return;
    }
    if (CPLib.eqr("cpercorsozip",p_cVarName)) {
      cpercorsozip = value;
      return;
    }
    if (CPLib.eqr("cdirectoryfile",p_cVarName)) {
      cdirectoryfile = value;
      return;
    }
    if (CPLib.eqr("buffernomefile",p_cVarName)) {
      buffernomefile = value;
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
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
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
      /* w_impzip Numeric(1, 0) */
      /* w_destfin Char(1) // Destinazione finale */
      /* fhand Char(1) */
      /* _codrap Char(16) */
      /* _luonas Char(50) */
      /* nProg Numeric(10, 0) */
      /* nomefileimport Char(50) */
      /* xConnes Char(16) */
      /* _tdest Char(1) */
      /* _pos Numeric(3, 0) */
      /* _npos Numeric(1, 0) */
      /* _tipoop Char(1) */
      /* _coddip Char(6) */
      /* _uniquecode Char(10) */
      /* _datope Date */
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
      /* _tipodoc Char(20) */
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
      /* w_xMAFLGRAP Char(1) */
      /* w_xMAFLGBON Char(1) */
      /* w_xMAFLGCKR Char(1) */
      /* w_xMAFLGASR Char(1) */
      /* w_xMADIPSTD Char(6) */
      /* w_xMAFLGCHKDAT Char(1) */
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
      /* mcErrate MemoryCursor(mcErrateDef.MCRDef) */
      /* rowErrate Row(mcErrateDef.MCRDef) */
      /* mcErrAge MemoryCursor(mcErrateDef.MCRDef) */
      /* mcAgeDuo MemoryCursor(mcErrateDef.MCRDef) */
      /* _contage Numeric(10, 0) */
      /* cell_count Numeric(9, 0) // Contatore per le celle */
      /* riga_letta Numeric(9, 0) // riga letta del file Excel */
      /* foglio Numeric(2, 0) // foglio letto */
      /* _conta Numeric(10, 0) */
      /* _idb Char(10) */
      /* _flgvalage Char(1) */
      /* _anno Char(4) */
      /* czipfile Char(100) */
      /* cpercorsozip Char(200) */
      /* cdirectoryfile Char(200) */
      /* buffernomefile Char(100) */
      /* nomefileimport Char(50) */
      /* _priorita Numeric(3, 0) */
      /* _nocf Numeric(1, 0) */
      /* w_CODFISC Char(16) // Codice Fiscale */
      /* w_DATANASC Date // Data Nascita */
      /* w_NASCOMUN Char(30) // Luogo di Nascita */
      /* w_NASSTATO Char(30) // Stato di nascita */
      /* w_COGNOME Char(26) // Ragione Sociale */
      /* w_RAGSOC Char(70) // Ragione Sociale */
      /* w_NOME Char(25) // Ragione Sociale */
      /* w_SESSO Char(1) // Sesso */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo */
      /* gUrlApp Char(80) // URL Applicazione */
      /* Legge dati intermediario per metteri su operazbo,fraziobo,rapopebo se mancanti */
      // * --- Drop temporary table tmp_impwu
      if (m_Ctx.IsSharedTemp("tmp_impwu")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_impwu")) {
          m_cServer = m_Ctx.GetServer("tmp_impwu");
          m_cPhName = m_Ctx.GetPhName("tmp_impwu");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_impwu");
      }
      // * --- Create temporary table tmp_impwu
      if (m_Ctx.IsSharedTemp("tmp_impwu")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_impwu")) {
          m_cServer = m_Ctx.GetServer("tmp_impwu");
          m_cPhName = m_Ctx.GetPhName("tmp_impwu");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_impwu");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_impwu");
      if ( ! (m_Ctx.IsSharedTemp("tmp_impwu"))) {
        m_cServer = m_Ctx.GetServer("tmp_impwu");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_impwu",m_cServer,"proto")),m_cPhName,"tmp_impwu",m_Ctx,new String[]{"WUNOMEFILE,WURIFEMTCN"});
      }
      m_cPhName_tmp_impwu = m_cPhName;
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
      /* Import Soggetti */
      /* gMsgProc := '' */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Cicla sul file della lista e lancia la pagina appropriata */
      /* _esito := 0 */
      _esito = CPLib.Round(0,0);
      /* gMsgProc := 'Ora Inizio Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _nerrori := 0 */
      _nerrori = CPLib.Round(0,0);
      /* _nerrage := 0 */
      _nerrage = CPLib.Round(0,0);
      /* If w_impzip=1 */
      if (CPLib.eqr(w_impzip,1)) {
        /* Exec "Estrazione ZIP" Page 3:Page_3 */
        Page_3();
      } // End If
      // * --- Select from tmp_list_imprich
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      if (Cursor_tmp_list_imprich!=null)
        Cursor_tmp_list_imprich.Close();
      Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"priorita,nomefile ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_tmp_list_imprich.Eof())) {
        /* nomefileimport := LRTrim(tmp_list_imprich->nomefile) */
        nomefileimport = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile"));
        /* _dtimport := NullDateTime() */
        _dtimport = CPLib.NullDateTime();
        /* _filename := gPathApp+"/appo/"+LRTrim(nomefileimport) // Nome file con path */
        _filename = gPathApp+"/appo/"+CPLib.LRTrim(nomefileimport);
        /* If At('LOCATION',Upper(nomefileimport)) <> 0 */
        if (CPLib.ne(CPLib.At("LOCATION",CPLib.Upper(nomefileimport)),0)) {
          /* Exec "Agenzie" Page 6:Page_6 */
          Page_6();
        } else { // Else
          /* Exec "Elabora il file" Page 2:Page_2 */
          Page_2();
        } // End If
        // * --- Delete from tmp_list_imprich
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000000BA")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* If _nerrage > 0 */
      if (CPLib.gt(_nerrage,0)) {
        /* Exec "File Excel Errori Agenzie" Page 10:Page_10 */
        Page_10();
      } // End If
      /* If _nerrori > 0 */
      if (CPLib.gt(_nerrori,0)) {
        /* Exec "File Excel Errori Transazioni" Page 9:Page_9 */
        Page_9();
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If (_nerrori + _nerrage) > 0 */
      if (CPLib.gt((_nerrori+_nerrage),0)) {
        /* gMsgImp := 'Importazione dati terminata. Premere il bottone con la lente per prelevare i file degli scarti' // Messaggio Import */
        gMsgImp = "Importazione dati terminata. Premere il bottone con la lente per prelevare i file degli scarti";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } else { // Else
        /* gMsgImp := 'Importazione dati terminata. Non sono stati rilevati errori' // Messaggio Import */
        gMsgImp = "Importazione dati terminata. Non sono stati rilevati errori";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } // End If
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
    CPResultSet Cursor_personbo=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* cNumInv := 0 */
      cNumInv = CPLib.Round(0,0);
      /* conta := 0 */
      conta = 0;
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Salta la prima riga in quanti dice solo cose di trasmissione */
      /* Legge il file */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry000000CDstatus;
      nTry000000CDstatus = m_Sql.GetTransactionStatus();
      String cTry000000CDmsg;
      cTry000000CDmsg = m_Sql.TransactionErrorMessage();
      try {
        //Legge il file excel
        InputStream ExcelFileToRead = new FileInputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(nomefileimport));
        XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
        conta = wb.getNumberOfSheets();
        XSSFRow row; 
        XSSFCell cell;
        XSSFRow row2; 
        XSSFCell cell2;
        /* While _i < conta */
        while (CPLib.lt(_i,conta)) {
          //Apro uno ad uno i fogli del file Excel
          XSSFSheet sheet = wb.getSheetAt(_i);
          //Mi definisco un oggetto che contiene tutte le righe
          Iterator rows = sheet.rowIterator();
          //_righe = sheet.getLastRowNum()+1;
          //_y = 1;
          /* foglio := _i // foglio letto */
          foglio = CPLib.Round(_i,0);
          /* While rows.hasNext() */
          while (rows.hasNext()) {
            //scorro le righe
            row=(XSSFRow) rows.next();
            //Mi definisco un oggetto che contiene tutte le celle della riga letta
            Iterator cells = row.cellIterator();
            /* riga_letta := riga_letta+1 // riga letta del file Excel */
            riga_letta = CPLib.Round(riga_letta+1,0);
            /* gMsgImp := 'Sto elaborando la riga n. '+LRTrim(Str(riga_letta,10,0)) // Messaggio Import */
            gMsgImp = "Sto elaborando la riga n. "+CPLib.LRTrim(CPLib.Str(riga_letta,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If riga_letta > 1 */
            if (CPLib.gt(riga_letta,1)) {
              // Preparo variabili per lettura righe
              _celle=0;
              nextLine=new String[37];
              for (int _celle = 0; CPLib.ne(_celle,37); _celle = _celle + (1)) {
                // Mette i valori nell'array
                cell=(XSSFCell) row.getCell(_celle);
                if (cell != null) {
                  nextLine[_celle]=cell.getStringCellValue();
                } else {
                  nextLine[_celle]="";
                }
              }
              /* If nextLine[36]='S' */
              if (CPLib.eqr(nextLine[36],"S")) {
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
                /* w_xMAFLGRAP := '' */
                w_xMAFLGRAP = "";
                /* w_xMAFLGBON := '' */
                w_xMAFLGBON = "";
                /* w_xMAFLGCKR := '' */
                w_xMAFLGCKR = "";
                /* w_xMAFLGASR := '' */
                w_xMAFLGASR = "";
                /* w_xMADIPSTD := '' */
                w_xMADIPSTD = "";
                /* w_xMAFLGCHKDAT := '' */
                w_xMAFLGCHKDAT = "";
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
                /* _cognome := nextLine[1] */
                _cognome = nextLine[1];
                /* _nome := nextLine[2] */
                _nome = nextLine[2];
                /* _via := nextLine[3] */
                _via = nextLine[3];
                /* _nocf := iif(LRTrim(nextLine[4])='S',0,1) */
                _nocf = CPLib.Round((CPLib.eqr(CPLib.LRTrim(nextLine[4]),"S")?0:1),0);
                /* _codfis := nextLine[5] */
                _codfis = nextLine[5];
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
                        Error l_oErrorFault = new Error("Read on tbstati into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
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
                          Error l_oErrorFault = new Error("Read on tbstatna into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
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
                        /* _nasstato := LRTrim(nextLine[6]) */
                        _nasstato = CPLib.LRTrim(nextLine[6]);
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
                        Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
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
                          Error l_oErrorFault = new Error("Read on tbcittna into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
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
                        m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(nextLine[6]),"C",60,0,m_cServer),m_cServer,CPLib.LRTrim(nextLine[6]));
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
                            Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
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
                  /* If not(Empty(LRTrim(nextLine[6]))) */
                  if ( ! (CPLib.Empty(CPLib.LRTrim(nextLine[6])))) {
                    /* _codstanas := '' */
                    _codstanas = "";
                    /* _luonas := LRTrim(nextLine[6]) */
                    _luonas = CPLib.LRTrim(nextLine[6]);
                    // * --- Read from DecodeStati
                    m_cServer = m_Ctx.GetServer("DecodeStati");
                    m_cPhName = m_Ctx.GetPhName("DecodeStati");
                    m_cSql = "";
                    m_cSql = m_cSql+"account="+CPSql.SQLValueAdapter(CPLib.ToSQL(_luonas,"C",100,0,m_cServer),m_cServer,_luonas);
                    if (m_Ctx.IsSharedTemp("DecodeStati")) {
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
                        Error l_oErrorFault = new Error("Read on DecodeStati into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
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
                      // * --- Read from tbstati
                      m_cServer = m_Ctx.GetServer("tbstati");
                      m_cPhName = m_Ctx.GetPhName("tbstati");
                      m_cSql = "";
                      m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codstanas,"C",3,0,m_cServer),m_cServer,_codstanas);
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
                          Error l_oErrorFault = new Error("Read on tbstati into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
                          CPStdCounter.Error(l_oErrorFault);
                        }
                        Read_Cursor.Close();
                      } else {
                        // Error: no record found!
                        _nasstato = "";
                        Read_Cursor.Close();
                        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                      }
                      /* _nasprov := 'EE' */
                      _nasprov = "EE";
                    } else { // Else
                      // * --- Read from DecodeCitta
                      m_cServer = m_Ctx.GetServer("DecodeCitta");
                      m_cPhName = m_Ctx.GetPhName("DecodeCitta");
                      m_cSql = "";
                      m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_luonas,"C",80,0,m_cServer),m_cServer,_luonas);
                      if (m_Ctx.IsSharedTemp("DecodeCitta")) {
                        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                      }
                      if (Read_Cursor!=null)
                        Read_Cursor.Close();
                      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTAMIT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                      if ( ! (Read_Cursor.Eof())) {
                        _nascitta = Read_Cursor.GetString("CITTAMIT");
                        Read_Cursor.Next();
                        if ( ! (Read_Cursor.Eof())) {
                          Error l_oErrorFault = new Error("Read on DecodeCitta into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
                          CPStdCounter.Error(l_oErrorFault);
                        }
                        Read_Cursor.Close();
                      } else {
                        // Error: no record found!
                        _nascitta = "";
                        Read_Cursor.Close();
                        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                      }
                      // * --- Read from tbcitta
                      m_cServer = m_Ctx.GetServer("tbcitta");
                      m_cPhName = m_Ctx.GetPhName("tbcitta");
                      m_cSql = "";
                      m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nascitta,"C",60,0,m_cServer),m_cServer,_nascitta);
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
                          Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
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
                    /* If Empty(_nasstato) and Empty(_nascitta) */
                    if (CPLib.Empty(_nasstato) && CPLib.Empty(_nascitta)) {
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
                          Error l_oErrorFault = new Error("Read on tbstati into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
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
                            Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
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
                } // End If
                /* _numdoc := nextLine[7] */
                _numdoc = nextLine[7];
                /* _docril := CharToDate(nextLine[9]) */
                _docril = CPLib.CharToDate(nextLine[9]);
                /* _docsca := CharToDate(nextLine[8]) */
                _docsca = CPLib.CharToDate(nextLine[8]);
                /* _autril := nextLine[10] */
                _autril = nextLine[10];
                /* Case LRTrim(nextLine[12])='PP' */
                if (CPLib.eqr(CPLib.LRTrim(nextLine[12]),"PP")) {
                  /* _doctype := '03' */
                  _doctype = "03";
                  /* Case LRTrim(nextLine[12])='CI' */
                } else if (CPLib.eqr(CPLib.LRTrim(nextLine[12]),"CI")) {
                  /* _doctype := '01' */
                  _doctype = "01";
                  /* Case LRTrim(nextLine[12])='PA' */
                } else if (CPLib.eqr(CPLib.LRTrim(nextLine[12]),"PA")) {
                  /* _doctype := '02' */
                  _doctype = "02";
                  /* Case LRTrim(nextLine[12])='FC' */
                } else if (CPLib.eqr(CPLib.LRTrim(nextLine[12]),"FC")) {
                  /* _doctype := '04' */
                  _doctype = "04";
                } else { // Otherwise
                  /* _doctype := '06' */
                  _doctype = "06";
                } // End Case
                /* _nasdata := CharToDate(nextLine[31]) */
                _nasdata = CPLib.CharToDate(nextLine[31]);
                /* _sesso := nextLine[32] */
                _sesso = nextLine[32];
                /* _citta := LRTrim(nextLine[11]) */
                _citta = CPLib.LRTrim(nextLine[11]);
                /* _codcit := '' */
                _codcit = "";
                // * --- Read from DecodeCitta
                m_cServer = m_Ctx.GetServer("DecodeCitta");
                m_cPhName = m_Ctx.GetPhName("DecodeCitta");
                m_cSql = "";
                m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_citta,"C",80,0,m_cServer),m_cServer,_citta);
                if (m_Ctx.IsSharedTemp("DecodeCitta")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _codcit = Read_Cursor.GetString("IDBASE");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on DecodeCitta into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _codcit = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _paese := Upper(LRTrim(nextLine[30]]) */
                _paese = CPLib.Upper(CPLib.LRTrim(nextLine[30]));
                /* _codstares := '' */
                _codstares = "";
                // * --- Read from DecodeStati
                m_cServer = m_Ctx.GetServer("DecodeStati");
                m_cPhName = m_Ctx.GetPhName("DecodeStati");
                m_cSql = "";
                m_cSql = m_cSql+"account="+CPSql.SQLValueAdapter(CPLib.ToSQL(_paese,"C",100,0,m_cServer),m_cServer,_paese);
                if (m_Ctx.IsSharedTemp("DecodeStati")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _codstares = Read_Cursor.GetString("CODSTA");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on DecodeStati into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _codstares = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _nomecp := LRTrim(nextLine[26]) */
                _nomecp = CPLib.LRTrim(nextLine[26]);
                /* _cognomecp := LRTrim(nextLine[25]) */
                _cognomecp = CPLib.LRTrim(nextLine[25]);
                /* _statodest := Upper(LRTrim(nextLine[27])) */
                _statodest = CPLib.Upper(CPLib.LRTrim(nextLine[27]));
                /* _uifdest := '' */
                _uifdest = "";
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(_statodest,"C",40,0,m_cServer),m_cServer,_statodest);
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
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _uifdest = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Empty(_uifdest) */
                if (CPLib.Empty(_uifdest)) {
                  // * --- Read from DecodeStati
                  m_cServer = m_Ctx.GetServer("DecodeStati");
                  m_cPhName = m_Ctx.GetPhName("DecodeStati");
                  m_cSql = "";
                  m_cSql = m_cSql+"account="+CPSql.SQLValueAdapter(CPLib.ToSQL(_statodest,"C",100,0,m_cServer),m_cServer,_statodest);
                  if (m_Ctx.IsSharedTemp("DecodeStati")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _codstares = Read_Cursor.GetString("CODSTA");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on DecodeStati into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
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
                /* _datope := CharToDate(Substr(nextLine[13),7,4)+Substr(nextLine[13),4,2)+Left(nextLine[13),2)) */
                _datope = CPLib.CharToDate(CPLib.Substr(nextLine[13],7,4)+CPLib.Substr(nextLine[13],4,2)+CPLib.Left(nextLine[13],2));
                /* _importo := Val(nextLine[17]) */
                _importo = CPLib.Round(CPLib.Val(nextLine[17]),2);
                /* _contanti := Val(nextLine[18]) */
                _contanti = CPLib.Round(CPLib.Val(nextLine[18]),2);
                /* _flgcash := iif(w_xMAFLGBON='S','S','N') */
                _flgcash = (CPLib.eqr(w_xMAFLGBON,"S")?"S":"N");
                /* _tipope := '10' */
                _tipope = "10";
                /* If nextLine[16]='D' or nextLine[16]='S' */
                if (CPLib.eqr(nextLine[16],"D") || CPLib.eqr(nextLine[16],"S")) {
                  /* _codana := 'I9' */
                  _codana = "I9";
                  /* _codsin := '1M' */
                  _codsin = "1M";
                  /* _segno := 'D' */
                  _segno = "D";
                  /* ElseIf nextLine[16]='R' or nextLine[16]='A'  or nextLine[16]='Q' */
                } else if (CPLib.eqr(nextLine[16],"R") || CPLib.eqr(nextLine[16],"A") || CPLib.eqr(nextLine[16],"Q")) {
                  /* _codana := 'I8' */
                  _codana = "I8";
                  /* _codsin := '2M' */
                  _codsin = "2M";
                  /* _segno := 'A' */
                  _segno = "A";
                } // End If
                /* _uniquecode := nextLine[29] */
                _uniquecode = nextLine[29];
                // * --- Read from tbmacage
                m_cServer = m_Ctx.GetServer("tbmacage");
                m_cPhName = m_Ctx.GetPhName("tbmacage");
                m_cSql = "";
                m_cSql = m_cSql+"MANAIDWU="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(nextLine[34],5),"C",5,0,m_cServer),m_cServer,CPLib.Left(nextLine[34],5));
                if (m_Ctx.IsSharedTemp("tbmacage")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("MADIPSTD",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MAFLGASR",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MAFLGBON",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MAFLGCKR",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MAFLGRAP",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MACODICE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MAFLGCHKDAT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  w_xMADIPSTD = Read_Cursor.GetString("MADIPSTD");
                  w_xMAFLGASR = Read_Cursor.GetString("MAFLGASR");
                  w_xMAFLGBON = Read_Cursor.GetString("MAFLGBON");
                  w_xMAFLGCKR = Read_Cursor.GetString("MAFLGCKR");
                  w_xMAFLGRAP = Read_Cursor.GetString("MAFLGRAP");
                  w_codmage = Read_Cursor.GetString("MACODICE");
                  w_xMAFLGCHKDAT = Read_Cursor.GetString("MAFLGCHKDAT");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbmacage into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  w_xMADIPSTD = "";
                  w_xMAFLGASR = "";
                  w_xMAFLGBON = "";
                  w_xMAFLGCKR = "";
                  w_xMAFLGRAP = "";
                  w_codmage = "";
                  w_xMAFLGCHKDAT = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _idfile := LRTrim(w_codmage)+"-"+LRTrim(nomefileimport) */
                _idfile = CPLib.LRTrim(w_codmage)+"-"+CPLib.LRTrim(nomefileimport);
                /* _dipid := iif(nextLine[34]='IT112',LRTrim(nextLine[20]),'FN'+LRTrim(nextLine[20])) */
                _dipid = (CPLib.eqr(nextLine[34],"IT112")?CPLib.LRTrim(nextLine[20]):"FN"+CPLib.LRTrim(nextLine[20]));
                // * --- Read from anadip
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_cSql = "";
                m_cSql = m_cSql+"TERMINALID="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(nextLine[20]),"C",15,0,m_cServer),m_cServer,CPLib.LRTrim(nextLine[20]));
                m_cSql = m_cSql+" and MACROAGENTE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codmage,"C",5,0,m_cServer),m_cServer,w_codmage);
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
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _coddip = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* Exec "Controllo dati" Page 5:Page_5 */
                Page_5();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* If _esito = 0 */
                if (CPLib.eqr(_esito,0)) {
                  /* _connes := '' */
                  _connes = "";
                  /* _prov := '' */
                  _prov = "";
                  /* _cab := '' */
                  _cab = "";
                  /* _idb2 := '' */
                  _idb2 = "";
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
                      Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
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
                  m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codfis,"C",16,0,m_cServer),m_cServer,_codfis);
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
                      Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
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
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"0000017C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_0000017C(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codfis,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),70),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_via,35),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_nocf,0)?_codfis:""),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_nasdata,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nascitta,30),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("600","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("600","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_doctype,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_docril,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_autril,30),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_citta,30),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_cap,5),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_sesso,"M")?"1":(CPLib.eqr(_sesso,"F")?"2":"")),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_docsca,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_cognome,26),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nome,25),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nasprov,2),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_nocf,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nasstato,30),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_prov,2),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_cab,6),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_oldcodfis,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(w_codmage,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
                    m_cSql = m_cSql+")";
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_nUpdatedRows = 0;
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.lt(m_nUpdatedRows,1)) {
                      // No rows inserted
                      /* gMsgProc := gMsgProc +"PERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
                      gMsgProc = gMsgProc+"PERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
                      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                      /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                      gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                      /* _esito := 1 */
                      _esito = CPLib.Round(1,0);
                      m_cLastMsgError = "";
                      // Exit Loop
                      if (true) {
                        break;
                      }
                    } else if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                      throw new RoutineException();
                    }
                    /* _condoc := '' */
                    _condoc = "";
                    // * --- Read from kersonbo
                    m_cServer = m_Ctx.GetServer("kersonbo");
                    m_cPhName = m_Ctx.GetPhName("kersonbo");
                    m_cSql = "";
                    m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codmage+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15),"C",50,0,m_cServer),m_cServer,w_codmage+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15));
                    if (m_Ctx.IsSharedTemp("kersonbo")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _condoc = Read_Cursor.GetString("CONNES");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on kersonbo into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _condoc = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* If Empty(LRTrim(_condoc)) */
                    if (CPLib.Empty(CPLib.LRTrim(_condoc))) {
                      // * --- Insert into kersonbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("kersonbo");
                      m_cPhName = m_Ctx.GetPhName("kersonbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"kersonbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"00000185")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000185(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),70),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_via,35),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_nocf,0)?_codfis:""),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_nasdata,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nascitta,30),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("600","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("600","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_doctype,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_docril,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_autril,30),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_citta,30),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_cap,5),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_sesso,"M")?"1":(CPLib.eqr(_sesso,"F")?"2":"")),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_docsca,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_cognome,26),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nome,25),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nasprov,2),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_nocf,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nasstato,30),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_prov,2),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_cab,6),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"kersonbo",true);
                      m_cSql = m_cSql+")";
                      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                      if (CPLib.lt(m_nUpdatedRows,0)) {
                        m_nUpdatedRows = 0;
                      }
                      m_Sql.CompleteTransaction();
                      m_cLastMsgError = m_Sql.TransactionErrorMessage();
                      if (CPLib.lt(m_nUpdatedRows,1)) {
                        // No rows inserted
                        /* gMsgProc := gMsgProc +"KERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
                        gMsgProc = gMsgProc+"KERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
                        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                        /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                        gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                        /* _esito := 1 */
                        _esito = CPLib.Round(1,0);
                        m_cLastMsgError = "";
                        // Exit Loop
                        if (true) {
                          break;
                        }
                      } else if (CPLib.ne(m_cLastMsgError,"")) {
                        m_bError = true;
                        throw new RoutineException();
                      }
                    } else { // Else
                      // * --- Write into kersonbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("kersonbo");
                      m_cPhName = m_Ctx.GetPhName("kersonbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"kersonbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"0000018B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(CPLib.Left(_cab,6),"C",6,0,m_cServer)+", ";
                      m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),70),"C",70,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Left(_via,35),"C",35,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(_codfis,"C",16,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(_nasdata,"D",8,0)+", ";
                      m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.Left(_nascitta,30),"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
                      m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL("","C",3,0,m_cServer)+", ";
                      m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
                      m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(_doctype,"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Left(_numdoc,15),"C",15,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(_docril,"D",8,0)+", ";
                      m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Left(_autril,30),"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Left(_citta,30),"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Left(_prov,2),"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Left(_cap,5),"C",9,0,m_cServer)+", ";
                      m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL((CPLib.eqr(_sesso,"M")?"1":(CPLib.eqr(_sesso,"F")?"2":"")),"C",1,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(_docsca,"D",8,0)+", ";
                      m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Left(_cognome,26),"C",26,0,m_cServer)+", ";
                      m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Left(_nome,25),"C",25,0,m_cServer)+", ";
                      m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Left(_nasprov,2),"C",2,0,m_cServer)+", ";
                      m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.Left(_nasstato,30),"C",30,0,m_cServer)+", ";
                      m_cSql = m_cSql+"ALLINEATONOMECNOME = "+CPLib.ToSQL(0,"N",1,0)+", ";
                      m_cSql = m_cSql+"PEP = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
                      m_cSql = m_cSql+"IDFILE = "+CPLib.ToSQL(_idfile,"C",60,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"kersonbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15))+"";
                      m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                      if (CPLib.lt(m_nUpdatedRows,0)) {
                        m_nUpdatedRows = 0;
                      }
                      m_Sql.CompleteTransaction();
                      m_cLastMsgError = m_Sql.TransactionErrorMessage();
                      if (CPLib.lt(m_nUpdatedRows,1)) {
                        // No rows updated
                        /* gMsgProc := gMsgProc +"KERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
                        gMsgProc = gMsgProc+"KERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
                        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                        /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                        gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                        /* _esito := 1 */
                        _esito = CPLib.Round(1,0);
                        m_cLastMsgError = "";
                        // Exit Loop
                        if (true) {
                          break;
                        }
                      } else if (CPLib.ne(m_cLastMsgError,"")) {
                        m_bError = true;
                        m_cLastMsgError = "Errore in aggiornamento ARCHPERS";
                        throw new RoutineException();
                      }
                    } // End If
                    // * --- Insert into personbo_agg from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("personbo_agg");
                    m_cPhName = m_Ctx.GetPhName("personbo_agg");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"00000191")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000191(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codfis,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(w_xMAFLGCHKDAT,"?",0,0,m_cServer)+", ";
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
                      throw new RoutineException();
                    }
                  } else { // Else
                    /* _flgbanca := 'X' */
                    _flgbanca = "X";
                    /* _flgvalage := 'X' */
                    _flgvalage = "X";
                    // * --- Read from personbo_agg
                    m_cServer = m_Ctx.GetServer("personbo_agg");
                    m_cPhName = m_Ctx.GetPhName("personbo_agg");
                    m_cSql = "";
                    m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codfis,"C",16,0,m_cServer),m_cServer,_codfis);
                    if (m_Ctx.IsSharedTemp("personbo_agg")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("FLGBANCA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("FLGVALIDO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _flgbanca = Read_Cursor.GetString("FLGBANCA");
                      _flgvalage = Read_Cursor.GetString("FLGVALIDO");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on personbo_agg into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _flgbanca = "";
                      _flgvalage = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* _aggcli := 0 */
                    _aggcli = CPLib.Round(0,0);
                    /* If w_xMAFLGCHKDAT='S' */
                    if (CPLib.eqr(w_xMAFLGCHKDAT,"S")) {
                      /* _aggcli := 1 */
                      _aggcli = CPLib.Round(1,0);
                    } else { // Else
                      /* Case LRTrim(w_codmage)='COSTA' */
                      if (CPLib.eqr(CPLib.LRTrim(w_codmage),"COSTA")) {
                        /* _aggcli := 1 */
                        _aggcli = CPLib.Round(1,0);
                        /* Case w_codmage='FININ' */
                      } else if (CPLib.eqr(w_codmage,"FININ")) {
                        /* If _oldmac <> 'COSTA' */
                        if (CPLib.ne(_oldmac,"COSTA")) {
                          /* _aggcli := 1 */
                          _aggcli = CPLib.Round(1,0);
                        } // End If
                        /* Case w_codmage='BCAUC' */
                      } else if (CPLib.eqr(w_codmage,"BCAUC")) {
                        /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' */
                        if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ")) {
                          /* _aggcli := 1 */
                          _aggcli = CPLib.Round(1,0);
                        } // End If
                        /* Case w_codmage='BCISP' */
                      } else if (CPLib.eqr(w_codmage,"BCISP")) {
                        /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' and _oldmac <> 'BCAUC' */
                        if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ") && CPLib.ne(_oldmac,"BCAUC")) {
                          /* _aggcli := 1 */
                          _aggcli = CPLib.Round(1,0);
                        } // End If
                        /* Case w_codmage='BCASS' or LRTrim(w_codmage)='E998' or LRTrim(w_codmage)='EBDSS' or LRTrim(w_codmage)='I999' */
                      } else if (CPLib.eqr(w_codmage,"BCASS") || CPLib.eqr(CPLib.LRTrim(w_codmage),"E998") || CPLib.eqr(CPLib.LRTrim(w_codmage),"EBDSS") || CPLib.eqr(CPLib.LRTrim(w_codmage),"I999")) {
                        /* If _oldmac <> 'COSTA' and _oldmac <> 'FININ' and _oldmac <> 'BCAUC' and _oldmac <> 'BCISP' */
                        if (CPLib.ne(_oldmac,"COSTA") && CPLib.ne(_oldmac,"FININ") && CPLib.ne(_oldmac,"BCAUC") && CPLib.ne(_oldmac,"BCISP")) {
                          /* _aggcli := 1 */
                          _aggcli = CPLib.Round(1,0);
                        } // End If
                        /* Case w_codmage='DHLSP' */
                      } else if (CPLib.eqr(w_codmage,"DHLSP")) {
                        /* If _oldmac = 'TRAVX' or _oldmac='DHLSP' */
                        if (CPLib.eqr(_oldmac,"TRAVX") || CPLib.eqr(_oldmac,"DHLSP")) {
                          /* _aggcli := 1 */
                          _aggcli = CPLib.Round(1,0);
                        } // End If
                        /* Case w_codmage='TRAVX' */
                      } else if (CPLib.eqr(w_codmage,"TRAVX")) {
                        /* If _oldmac='TRAVX' */
                        if (CPLib.eqr(_oldmac,"TRAVX")) {
                          /* _aggcli := 1 */
                          _aggcli = CPLib.Round(1,0);
                        } // End If
                      } // End Case
                    } // End If
                    /* If _aggcli = 1 */
                    if (CPLib.eqr(_aggcli,1)) {
                      /* cProgSto := Utilities.GetAutonumber("PSTOPERS\'"+LRTrim(gAzienda)+"'","",15) */
                      cProgSto = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","",15);
                      // * --- Select from personbo
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      if (Cursor_personbo!=null)
                        Cursor_personbo.Close();
                      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_personbo.Eof())) {
                        // * --- Insert into wersonbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("wersonbo");
                        m_cPhName = m_Ctx.GetPhName("wersonbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000001A9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_000001A9(m_Ctx,m_oWrInfo);
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
                          m_nUpdatedRows = 0;
                        }
                        m_Sql.CompleteTransaction();
                        m_cLastMsgError = m_Sql.TransactionErrorMessage();
                        if (CPLib.lt(m_nUpdatedRows,1)) {
                          // No rows inserted
                          /* gMsgProc := gMsgProc +"WERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
                          gMsgProc = gMsgProc+"WERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
                          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                          /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                          gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                          /* _esito := 1 */
                          _esito = CPLib.Round(1,0);
                          m_cLastMsgError = "";
                          // Exit Loop
                          if (true) {
                            break;
                          }
                        } else if (CPLib.ne(m_cLastMsgError,"")) {
                          m_bError = true;
                          throw new RoutineException();
                        }
                        Cursor_personbo.Next();
                      }
                      m_cConnectivityError = Cursor_personbo.ErrorMessage();
                      Cursor_personbo.Close();
                      // * --- End Select
                      /* If w_xMAFLGCHKDAT='S' or _flgbanca='N' or _flgbanca='X' or _flgvalage='X' or _flgvalage='N' */
                      if (CPLib.eqr(w_xMAFLGCHKDAT,"S") || CPLib.eqr(_flgbanca,"N") || CPLib.eqr(_flgbanca,"X") || CPLib.eqr(_flgvalage,"X") || CPLib.eqr(_flgvalage,"N")) {
                        // * --- Write into personbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("personbo");
                        m_cPhName = m_Ctx.GetPhName("personbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000001B0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(CPLib.Left(_cab,6),"C",6,0,m_cServer)+", ";
                        m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),70),"C",70,0,m_cServer)+", ";
                        m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Left(_via,35),"C",35,0,m_cServer)+", ";
                        m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL((CPLib.eqr(_nocf,0)?_codfis:""),"C",16,0,m_cServer)+", ";
                        m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(_nasdata,"D",8,0)+", ";
                        m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.Left(_nascitta,30),"C",30,0,m_cServer)+", ";
                        m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
                        m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL("","C",3,0,m_cServer)+", ";
                        m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
                        m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(_doctype,"C",2,0,m_cServer)+", ";
                        m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Left(_numdoc,15),"C",15,0,m_cServer)+", ";
                        m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(_docril,"D",8,0)+", ";
                        m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Left(_autril,30),"C",30,0,m_cServer)+", ";
                        m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Left(_citta,30),"C",30,0,m_cServer)+", ";
                        m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Left(_prov,2),"C",2,0,m_cServer)+", ";
                        m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Left(_cap,5),"C",9,0,m_cServer)+", ";
                        m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL((CPLib.eqr(_sesso,"M")?"1":"2"),"C",1,0,m_cServer)+", ";
                        m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(_docsca,"D",8,0)+", ";
                        m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Left(_cognome,26),"C",26,0,m_cServer)+", ";
                        m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Left(_nome,25),"C",25,0,m_cServer)+", ";
                        m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Left(_nasprov,2),"C",2,0,m_cServer)+", ";
                        m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.Left(_nasstato,30),"C",30,0,m_cServer)+", ";
                        m_cSql = m_cSql+"ALLINEATONOMECNOME = "+CPLib.ToSQL(0,"N",1,0)+", ";
                        m_cSql = m_cSql+"PEP = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
                        m_cSql = m_cSql+"IDFILE = "+CPLib.ToSQL(_idfile,"C",60,0,m_cServer)+", ";
                        m_cSql = m_cSql+"OLDCODFISC = "+CPLib.ToSQL(_oldcodfis,"C",20,0,m_cServer)+", ";
                        m_cSql = m_cSql+"MACROAGENTE = "+CPLib.ToSQL(w_codmage,"C",5,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                        m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                        if (CPLib.lt(m_nUpdatedRows,0)) {
                          m_nUpdatedRows = 0;
                        }
                        m_Sql.CompleteTransaction();
                        m_cLastMsgError = m_Sql.TransactionErrorMessage();
                        if (CPLib.lt(m_nUpdatedRows,1)) {
                          // No rows updated
                          /* gMsgProc := gMsgProc +"PERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
                          gMsgProc = gMsgProc+"PERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
                          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                          /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                          gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                          /* _esito := 1 */
                          _esito = CPLib.Round(1,0);
                          m_cLastMsgError = "";
                          // Exit Loop
                          if (true) {
                            break;
                          }
                        } else if (CPLib.ne(m_cLastMsgError,"")) {
                          m_bError = true;
                          m_cLastMsgError = "Errore in aggiornamento ARCHPERS";
                          throw new RoutineException();
                        }
                        /* If w_xMAFLGCHKDAT='S' */
                        if (CPLib.eqr(w_xMAFLGCHKDAT,"S")) {
                          /* If _flgbanca='X' */
                          if (CPLib.eqr(_flgbanca,"X")) {
                            // * --- Insert into personbo_agg from values
                            m_Sql.RequireTransaction();
                            m_cServer = m_Ctx.GetServer("personbo_agg");
                            m_cPhName = m_Ctx.GetPhName("personbo_agg");
                            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000001B8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                            m_cSql = m_cSql+GetFieldsName_000001B8(m_Ctx,m_oWrInfo);
                            m_cSql = m_cSql+") values (";
                            m_cSql = m_cSql+""+CPLib.ToSQL(_codfis,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
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
                              throw new RoutineException();
                            }
                          } else { // Else
                            // * --- Write into personbo_agg from values
                            m_Sql.RequireTransaction();
                            m_cServer = m_Ctx.GetServer("personbo_agg");
                            m_cPhName = m_Ctx.GetPhName("personbo_agg");
                            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000001B9")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                            m_cSql = m_cSql+"FLGBANCA = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
                            m_cSql = m_cSql+" where ";
                            m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codfis,"?",0,0,m_cServer),m_cServer,_codfis)+"";
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
                        /* ElseIf (_flgbanca='S' or _flgbanca='S') and w_xMAFLGCHKDAT='N' */
                      } else if ((CPLib.eqr(_flgbanca,"S") || CPLib.eqr(_flgbanca,"S")) && CPLib.eqr(w_xMAFLGCHKDAT,"N")) {
                        // * --- Write into personbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("personbo");
                        m_cPhName = m_Ctx.GetPhName("personbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000001BA")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(CPLib.Left(_cab,6),"C",6,0,m_cServer)+", ";
                        m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),70),"C",70,0,m_cServer)+", ";
                        m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Left(_via,35),"C",35,0,m_cServer)+", ";
                        m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
                        m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL("","C",3,0,m_cServer)+", ";
                        m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
                        m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(_doctype,"C",2,0,m_cServer)+", ";
                        m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Left(_numdoc,15),"C",15,0,m_cServer)+", ";
                        m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(_docril,"D",8,0)+", ";
                        m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Left(_autril,30),"C",30,0,m_cServer)+", ";
                        m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Left(_citta,30),"C",30,0,m_cServer)+", ";
                        m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Left(_prov,2),"C",2,0,m_cServer)+", ";
                        m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Left(_cap,5),"C",9,0,m_cServer)+", ";
                        m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(_docsca,"D",8,0)+", ";
                        m_cSql = m_cSql+"ALLINEATONOMECNOME = "+CPLib.ToSQL(0,"N",1,0)+", ";
                        m_cSql = m_cSql+"PEP = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
                        m_cSql = m_cSql+"IDFILE = "+CPLib.ToSQL(_idfile,"C",60,0,m_cServer)+", ";
                        m_cSql = m_cSql+"OLDCODFISC = "+CPLib.ToSQL(_oldcodfis,"C",20,0,m_cServer)+", ";
                        m_cSql = m_cSql+"MACROAGENTE = "+CPLib.ToSQL(w_codmage,"C",5,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                        m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                        if (CPLib.lt(m_nUpdatedRows,0)) {
                          m_nUpdatedRows = 0;
                        }
                        m_Sql.CompleteTransaction();
                        m_cLastMsgError = m_Sql.TransactionErrorMessage();
                        if (CPLib.lt(m_nUpdatedRows,1)) {
                          // No rows updated
                          /* gMsgProc := gMsgProc +"PERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
                          gMsgProc = gMsgProc+"PERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
                          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                          /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                          gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                          /* _esito := 1 */
                          _esito = CPLib.Round(1,0);
                          m_cLastMsgError = "";
                          // Exit Loop
                          if (true) {
                            break;
                          }
                        } else if (CPLib.ne(m_cLastMsgError,"")) {
                          m_bError = true;
                          m_cLastMsgError = "Errore in aggiornamento ARCHPERS";
                          throw new RoutineException();
                        }
                      } // End If
                    } // End If
                    /* _condoc := '' */
                    _condoc = "";
                    // * --- Read from kersonbo
                    m_cServer = m_Ctx.GetServer("kersonbo");
                    m_cPhName = m_Ctx.GetPhName("kersonbo");
                    m_cSql = "";
                    m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15),"C",50,0,m_cServer),m_cServer,CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15));
                    if (m_Ctx.IsSharedTemp("kersonbo")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _condoc = Read_Cursor.GetString("CONNES");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on kersonbo into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _condoc = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* If Empty(LRTrim(_condoc)) */
                    if (CPLib.Empty(CPLib.LRTrim(_condoc))) {
                      // * --- Insert into kersonbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("kersonbo");
                      m_cPhName = m_Ctx.GetPhName("kersonbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"kersonbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000001C3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000001C3(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),70),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_via,35),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_nocf,0)?_codfis:""),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_nasdata,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nascitta,30),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("600","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("600","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_doctype,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_docril,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_autril,30),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_citta,30),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_cap,5),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_sesso,"M")?"1":(CPLib.eqr(_sesso,"F")?"2":"")),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_docsca,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_cognome,26),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nome,25),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nasprov,2),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_nocf,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nasstato,30),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_prov,2),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_cab,6),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"kersonbo",true);
                      m_cSql = m_cSql+")";
                      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                      if (CPLib.lt(m_nUpdatedRows,0)) {
                        m_nUpdatedRows = 0;
                      }
                      m_Sql.CompleteTransaction();
                      m_cLastMsgError = m_Sql.TransactionErrorMessage();
                      if (CPLib.lt(m_nUpdatedRows,1)) {
                        // No rows inserted
                        /* gMsgProc := gMsgProc +"KERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
                        gMsgProc = gMsgProc+"KERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
                        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                        /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                        gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                        /* _esito := 1 */
                        _esito = CPLib.Round(1,0);
                        m_cLastMsgError = "";
                        // Exit Loop
                        if (true) {
                          break;
                        }
                      } else if (CPLib.ne(m_cLastMsgError,"")) {
                        m_bError = true;
                        throw new RoutineException();
                      }
                    } else { // Else
                      /* If _aggcli=1 */
                      if (CPLib.eqr(_aggcli,1)) {
                        // * --- Write into kersonbo from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("kersonbo");
                        m_cPhName = m_Ctx.GetPhName("kersonbo");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"kersonbo",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000001CA")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(CPLib.Left(_cab,6),"C",6,0,m_cServer)+", ";
                        m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),70),"C",70,0,m_cServer)+", ";
                        m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Left(_via,35),"C",35,0,m_cServer)+", ";
                        m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL((CPLib.eqr(_nocf,0)?_codfis:""),"C",16,0,m_cServer)+", ";
                        m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(_nasdata,"D",8,0)+", ";
                        m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.Left(_nascitta,30),"C",30,0,m_cServer)+", ";
                        m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
                        m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL("","C",3,0,m_cServer)+", ";
                        m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL("600","C",3,0,m_cServer)+", ";
                        m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(_doctype,"C",2,0,m_cServer)+", ";
                        m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Left(_numdoc,15),"C",15,0,m_cServer)+", ";
                        m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(_docril,"D",8,0)+", ";
                        m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Left(_autril,30),"C",30,0,m_cServer)+", ";
                        m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Left(_citta,30),"C",30,0,m_cServer)+", ";
                        m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Left(_prov,2),"C",2,0,m_cServer)+", ";
                        m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Left(_cap,5),"C",9,0,m_cServer)+", ";
                        m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL((CPLib.eqr(_sesso,"M")?"1":(CPLib.eqr(_sesso,"F")?"2":"")),"C",1,0,m_cServer)+", ";
                        m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(_docsca,"D",8,0)+", ";
                        m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Left(_cognome,26),"C",26,0,m_cServer)+", ";
                        m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Left(_nome,25),"C",25,0,m_cServer)+", ";
                        m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Left(_nasprov,2),"C",2,0,m_cServer)+", ";
                        m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.Left(_nasstato,30),"C",30,0,m_cServer)+", ";
                        m_cSql = m_cSql+"ALLINEATONOMECNOME = "+CPLib.ToSQL(0,"N",1,0)+", ";
                        m_cSql = m_cSql+"PEP = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
                        m_cSql = m_cSql+"IDFILE = "+CPLib.ToSQL(_idfile,"C",60,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"kersonbo",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15))+"";
                        m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                        if (CPLib.lt(m_nUpdatedRows,0)) {
                          m_nUpdatedRows = 0;
                        }
                        m_Sql.CompleteTransaction();
                        m_cLastMsgError = m_Sql.TransactionErrorMessage();
                        if (CPLib.lt(m_nUpdatedRows,1)) {
                          // No rows updated
                          /* gMsgProc := gMsgProc +"KERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
                          gMsgProc = gMsgProc+"KERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
                          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                          /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                          gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                          /* _esito := 1 */
                          _esito = CPLib.Round(1,0);
                          m_cLastMsgError = "";
                          // Exit Loop
                          if (true) {
                            break;
                          }
                        } else if (CPLib.ne(m_cLastMsgError,"")) {
                          m_bError = true;
                          m_cLastMsgError = "Errore in aggiornamento ARCHPERS";
                          throw new RoutineException();
                        }
                      } // End If
                    } // End If
                  } // End If
                  /* _idb2 := LibreriaMit.UniqueId() */
                  _idb2 = LibreriaMit.UniqueId();
                  /* Exec "Inserimento Transazione" Page 8:Page_8 */
                  Page_8();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* If _esito=-1 */
                  if (CPLib.eqr(_esito,-1)) {
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } // End If
                } // End If
                /* If _esito=1 */
                if (CPLib.eqr(_esito,1)) {
                  /* _nerrori := _nerrori + 1 */
                  _nerrori = CPLib.Round(_nerrori+1,0);
                  /* mcErrate.AppendBlank() */
                  mcErrate.AppendBlank();
                  /* mcErrate.colonna01 := nextLine[0] */
                  mcErrate.row.colonna01 = nextLine[0];
                  /* mcErrate.colonna02 := nextLine[1] */
                  mcErrate.row.colonna02 = nextLine[1];
                  /* mcErrate.colonna03 := nextLine[2] */
                  mcErrate.row.colonna03 = nextLine[2];
                  /* mcErrate.colonna04 := nextLine[3] */
                  mcErrate.row.colonna04 = nextLine[3];
                  /* mcErrate.colonna05 := nextLine[4] */
                  mcErrate.row.colonna05 = nextLine[4];
                  /* mcErrate.colonna06 := nextLine[5] */
                  mcErrate.row.colonna06 = nextLine[5];
                  /* mcErrate.colonna07 := nextLine[6] */
                  mcErrate.row.colonna07 = nextLine[6];
                  /* mcErrate.colonna08 := nextLine[7] */
                  mcErrate.row.colonna08 = nextLine[7];
                  /* mcErrate.colonna09 := nextLine[8] */
                  mcErrate.row.colonna09 = nextLine[8];
                  /* mcErrate.colonna10 := nextLine[9] */
                  mcErrate.row.colonna10 = nextLine[9];
                  /* mcErrate.colonna11 := nextLine[10] */
                  mcErrate.row.colonna11 = nextLine[10];
                  /* mcErrate.colonna12 := nextLine[11] */
                  mcErrate.row.colonna12 = nextLine[11];
                  /* mcErrate.colonna13 := nextLine[12] */
                  mcErrate.row.colonna13 = nextLine[12];
                  /* mcErrate.colonna14 := nextLine[13] */
                  mcErrate.row.colonna14 = nextLine[13];
                  /* mcErrate.colonna15 := nextLine[14] */
                  mcErrate.row.colonna15 = nextLine[14];
                  /* mcErrate.colonna16 := nextLine[15] */
                  mcErrate.row.colonna16 = nextLine[15];
                  /* mcErrate.colonna17 := nextLine[16] */
                  mcErrate.row.colonna17 = nextLine[16];
                  /* mcErrate.colonna18 := nextLine[17] */
                  mcErrate.row.colonna18 = nextLine[17];
                  /* mcErrate.colonna19 := nextLine[18] */
                  mcErrate.row.colonna19 = nextLine[18];
                  /* mcErrate.colonna20 := nextLine[19] */
                  mcErrate.row.colonna20 = nextLine[19];
                  /* mcErrate.colonna21 := nextLine[20] */
                  mcErrate.row.colonna21 = nextLine[20];
                  /* mcErrate.colonna22 := nextLine[21] */
                  mcErrate.row.colonna22 = nextLine[21];
                  /* mcErrate.colonna23 := nextLine[22] */
                  mcErrate.row.colonna23 = nextLine[22];
                  /* mcErrate.colonna24 := nextLine[23] */
                  mcErrate.row.colonna24 = nextLine[23];
                  /* mcErrate.colonna25 := nextLine[24] */
                  mcErrate.row.colonna25 = nextLine[24];
                  /* mcErrate.colonna26 := nextLine[25] */
                  mcErrate.row.colonna26 = nextLine[25];
                  /* mcErrate.colonna27 := nextLine[26] */
                  mcErrate.row.colonna27 = nextLine[26];
                  /* mcErrate.colonna28 := nextLine[27] */
                  mcErrate.row.colonna28 = nextLine[27];
                  /* mcErrate.colonna29 := nextLine[28] */
                  mcErrate.row.colonna29 = nextLine[28];
                  /* mcErrate.colonna30 := nextLine[29] */
                  mcErrate.row.colonna30 = nextLine[29];
                  /* mcErrate.colonna31 := nextLine[30] */
                  mcErrate.row.colonna31 = nextLine[30];
                  /* mcErrate.colonna32 := nextLine[31] */
                  mcErrate.row.colonna32 = nextLine[31];
                  /* mcErrate.colonna33 := nextLine[32] */
                  mcErrate.row.colonna33 = nextLine[32];
                  /* mcErrate.colonna34 := nextLine[33] */
                  mcErrate.row.colonna34 = nextLine[33];
                  /* mcErrate.colonna35 := nextLine[34] */
                  mcErrate.row.colonna35 = nextLine[34];
                  /* mcErrate.colonna36 := _listerr */
                  mcErrate.row.colonna36 = _listerr;
                  /* mcErrate.SaveRow() */
                  mcErrate.SaveRow();
                } // End If
                /* _conta := _conta + 1 */
                _conta = CPLib.Round(_conta+1,0);
                /* gMsgImp := 'Sono state elaborate '+LRTrim(Str(_conta,10,0))+' informazioni del file '+nomefileimport // Messaggio Import */
                gMsgImp = "Sono state elaborate "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" informazioni del file "+nomefileimport;
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              } else { // Else
                /* _nerrori := _nerrori + 1 */
                _nerrori = CPLib.Round(_nerrori+1,0);
                /* mcErrate.AppendBlank() */
                mcErrate.AppendBlank();
                /* mcErrate.colonna01 := nextLine[0] */
                mcErrate.row.colonna01 = nextLine[0];
                /* mcErrate.colonna02 := nextLine[1] */
                mcErrate.row.colonna02 = nextLine[1];
                /* mcErrate.colonna03 := nextLine[2] */
                mcErrate.row.colonna03 = nextLine[2];
                /* mcErrate.colonna04 := nextLine[3] */
                mcErrate.row.colonna04 = nextLine[3];
                /* mcErrate.colonna05 := nextLine[4] */
                mcErrate.row.colonna05 = nextLine[4];
                /* mcErrate.colonna06 := nextLine[5] */
                mcErrate.row.colonna06 = nextLine[5];
                /* mcErrate.colonna07 := nextLine[6] */
                mcErrate.row.colonna07 = nextLine[6];
                /* mcErrate.colonna08 := nextLine[7] */
                mcErrate.row.colonna08 = nextLine[7];
                /* mcErrate.colonna09 := nextLine[8] */
                mcErrate.row.colonna09 = nextLine[8];
                /* mcErrate.colonna10 := nextLine[9] */
                mcErrate.row.colonna10 = nextLine[9];
                /* mcErrate.colonna11 := nextLine[10] */
                mcErrate.row.colonna11 = nextLine[10];
                /* mcErrate.colonna12 := nextLine[11] */
                mcErrate.row.colonna12 = nextLine[11];
                /* mcErrate.colonna13 := nextLine[12] */
                mcErrate.row.colonna13 = nextLine[12];
                /* mcErrate.colonna14 := nextLine[13] */
                mcErrate.row.colonna14 = nextLine[13];
                /* mcErrate.colonna15 := nextLine[14] */
                mcErrate.row.colonna15 = nextLine[14];
                /* mcErrate.colonna16 := nextLine[15] */
                mcErrate.row.colonna16 = nextLine[15];
                /* mcErrate.colonna17 := nextLine[16] */
                mcErrate.row.colonna17 = nextLine[16];
                /* mcErrate.colonna18 := nextLine[17] */
                mcErrate.row.colonna18 = nextLine[17];
                /* mcErrate.colonna19 := nextLine[18] */
                mcErrate.row.colonna19 = nextLine[18];
                /* mcErrate.colonna20 := nextLine[19] */
                mcErrate.row.colonna20 = nextLine[19];
                /* mcErrate.colonna21 := nextLine[20] */
                mcErrate.row.colonna21 = nextLine[20];
                /* mcErrate.colonna22 := nextLine[21] */
                mcErrate.row.colonna22 = nextLine[21];
                /* mcErrate.colonna23 := nextLine[22] */
                mcErrate.row.colonna23 = nextLine[22];
                /* mcErrate.colonna24 := nextLine[23] */
                mcErrate.row.colonna24 = nextLine[23];
                /* mcErrate.colonna25 := nextLine[24] */
                mcErrate.row.colonna25 = nextLine[24];
                /* mcErrate.colonna26 := nextLine[25] */
                mcErrate.row.colonna26 = nextLine[25];
                /* mcErrate.colonna27 := nextLine[26] */
                mcErrate.row.colonna27 = nextLine[26];
                /* mcErrate.colonna28 := nextLine[27] */
                mcErrate.row.colonna28 = nextLine[27];
                /* mcErrate.colonna29 := nextLine[28] */
                mcErrate.row.colonna29 = nextLine[28];
                /* mcErrate.colonna30 := nextLine[29] */
                mcErrate.row.colonna30 = nextLine[29];
                /* mcErrate.colonna31 := nextLine[30] */
                mcErrate.row.colonna31 = nextLine[30];
                /* mcErrate.colonna32 := nextLine[31] */
                mcErrate.row.colonna32 = nextLine[31];
                /* mcErrate.colonna33 := nextLine[32] */
                mcErrate.row.colonna33 = nextLine[32];
                /* mcErrate.colonna34 := nextLine[33] */
                mcErrate.row.colonna34 = nextLine[33];
                /* mcErrate.colonna35 := nextLine[34] */
                mcErrate.row.colonna35 = nextLine[34];
                /* mcErrate.colonna36 := nextLine[35] */
                mcErrate.row.colonna36 = nextLine[35];
                /* mcErrate.SaveRow() */
                mcErrate.SaveRow();
              } // End If
            } // End If
          } // End While
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000CDstatus,0)) {
          m_Sql.SetTransactionStatus(nTry000000CDstatus,cTry000000CDmsg);
        }
      }
      /* gMsgProc := gMsgProc + 'Informazioni Elaborate: '+LRTrim(Str(_conta,10,0)) + ' dal file '+nomefileimport+NL */
      gMsgProc = gMsgProc+"Informazioni Elaborate: "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" dal file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If _nerrori > 0 */
      if (CPLib.gt(_nerrori,0)) {
        /* gMsgProc := gMsgProc + 'Sono stati rilevati '+LRTrim(Str(_nerrori,10,0)) + ' errori dal file '+nomefileimport+NL */
        gMsgProc = gMsgProc+"Sono stati rilevati "+CPLib.LRTrim(CPLib.Str(_nerrori,10,0))+" errori dal file "+nomefileimport+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file '+nomefileimport // Messaggio Import */
      gMsgImp = "Fine importazione del file "+nomefileimport;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_tmp_list_imprich=null;
    try {
      // * --- Select from tmp_list_imprich
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      if (Cursor_tmp_list_imprich!=null)
        Cursor_tmp_list_imprich.Close();
      Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tmp_list_imprich.Eof())) {
        /* czipfile := LRTrim(tmp_list_imprich->nomefile) */
        czipfile = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile"));
        Cursor_tmp_list_imprich.Next();
      }
      m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
      Cursor_tmp_list_imprich.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + czipfile + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+czipfile+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Inizio estrazione del file '+ czipfile // Messaggio Import */
      gMsgImp = "Inizio estrazione del file "+czipfile;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* cpercorsozip := LRTrim(gPathApp)+"\appo\"+czipfile */
      cpercorsozip = CPLib.LRTrim(gPathApp)+"\\appo\\"+czipfile;
      /* cdirectoryfile := LRTrim(gPathApp)+"\appo\" */
      cdirectoryfile = CPLib.LRTrim(gPathApp)+"\\appo\\";
      try {
            // Apro il file zip
            java.util.zip.ZipFile zf = new java.util.zip.ZipFile(cpercorsozip);
      
            //Conto il numero di file all interno del file zip e creo un array di stringhe per memorizzare i nomi file
            conteggio=zf.size();
            lista=new String[conteggio];
            
            // Enumerate each entry
            i=0;
            for (java.util.Enumeration entries = zf.entries(); entries.hasMoreElements();) {
                // Get the entry name
                lista[i] = ((java.util.zip.ZipEntry)entries.nextElement()).getName();
                i++;
            }
           zf.close();
           } catch (java.io.IOException e) {
           }
      try {
            // Apro il file zip
            java.util.zip.ZipFile zf = new java.util.zip.ZipFile(cpercorsozip);
      
            byte[] buffer = new byte[1024]; 
            java.util.Enumeration entries = zf.entries();
            while(entries.hasMoreElements() ) {
              java.util.zip.ZipEntry entry = (java.util.zip.ZipEntry)entries.nextElement();
      
              System.err.println("Extracting file: " + entry.getName());
              java.io.InputStream in =zf.getInputStream(entry);
              java.io.OutputStream out = new java.io.BufferedOutputStream(new java.io.FileOutputStream(cdirectoryfile+entry.getName()));
      
              int len;
      
              while((len = in.read(buffer)) >= 0){
                out.write(buffer, 0, len);
              }
      
                in.close();
                out.close();
            }
      
            zf.close();
      } catch (java.io.IOException ioe) {
            System.err.println("Unhandled exception:");
            ioe.printStackTrace();
            return;
      }
      // * --- Delete from tmp_list_imprich
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"00000234")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"nomefile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(czipfile,"?",0,0,m_cServer),m_cServer,czipfile)+"";
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
      /* contanome := 0 */
      contanome = 0;
      /* _priorita := 0 */
      _priorita = CPLib.Round(0,0);
      /* While contanome<conteggio */
      while (CPLib.lt(contanome,conteggio)) {
        buffernomefile=lista[contanome];
        /* _priorita := iif(At('LOCATION',Upper(buffernomefile)) >0,1,2) */
        _priorita = CPLib.Round((CPLib.gt(CPLib.At("LOCATION",CPLib.Upper(buffernomefile)),0)?1:2),0);
        // * --- Insert into tmp_list_imprich from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"0000023A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000023A(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(buffernomefile,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_priorita,"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_list_imprich",true);
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
        /* contanome := contanome+1 */
        contanome = contanome+1;
      } // End While
      /* FileLibMit.DeleteFile('./appo/'+czipfile) */
      FileLibMit.DeleteFile("./appo/"+czipfile);
      /* gMsgImp := 'Fine estrazione del file '+ czipfile // Messaggio Import */
      gMsgImp = "Fine estrazione del file "+czipfile;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +czipfile + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+czipfile+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_wurapporti=null;
    CPResultSet Cursor_xapopebo=null;
    CPResultSet Cursor_rapopebo=null;
    try {
      /* Variabili loclai */
      /* _rap Numeric(1, 0) */
      double _rap;
      _rap = 0;
      /* nProgImp Numeric(15, 0) */
      double nProgImp;
      nProgImp = 0;
      /* nProgImp2 Numeric(15, 0) */
      double nProgImp2;
      nProgImp2 = 0;
      /* cInfProg1 Char(10) */
      String cInfProg1;
      cInfProg1 = CPLib.Space(10);
      /* cInfProg2 Char(11) */
      String cInfProg2;
      cInfProg2 = CPLib.Space(11);
      /* cProgRap Char(10) */
      String cProgRap;
      cProgRap = CPLib.Space(10);
      /* Verifica se il rapporto continuativo esiste già */
      /* _codrap := '' */
      _codrap = "";
      /* _rap := 0 */
      _rap = CPLib.Round(0,0);
      // * --- Select from wurapporti
      m_cServer = m_Ctx.GetServer("wurapporti");
      m_cPhName = m_Ctx.GetPhName("wurapporti");
      if (Cursor_wurapporti!=null)
        Cursor_wurapporti.Close();
      Cursor_wurapporti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RWCODFIS="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("wurapporti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_wurapporti.Eof())) {
        /* _rap := 1 */
        _rap = CPLib.Round(1,0);
        /* _codrap := LRTrim(wurapporti->RWMACAGE)+wurapporti->RWCODRAP */
        _codrap = CPLib.LRTrim(Cursor_wurapporti.GetString("RWMACAGE"))+Cursor_wurapporti.GetString("RWCODRAP");
        Cursor_wurapporti.Next();
      }
      m_cConnectivityError = Cursor_wurapporti.ErrorMessage();
      Cursor_wurapporti.Close();
      // * --- End Select
      /* If w_tipodest='P' */
      if (CPLib.eqr(w_tipodest,"P")) {
        /* If _rap = 0 */
        if (CPLib.eqr(_rap,0)) {
          /* cProgRap := Utilities.GetAutonumber("PRG"+LRTrim(w_codmage)+"\'"+LRTrim(gAzienda)+"'",'',10) */
          cProgRap = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRG"+CPLib.LRTrim(w_codmage)+"\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          /* _codrap := LRTrim(w_codmage)+cProgRap */
          _codrap = CPLib.LRTrim(w_codmage)+cProgRap;
          // * --- Insert into wurapporti from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("wurapporti");
          m_cPhName = m_Ctx.GetPhName("wurapporti");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wurapporti",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"00000250")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000250(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_codmage,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProgRap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wurapporti",true);
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
          /* nProgImp := Utilities.GetAutonumber("PRGIMPRAP\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAP\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into xnarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xnarapbo");
          m_cPhName = m_Ctx.GetPhName("xnarapbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xnarapbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"00000252")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000252(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("99","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_codmage,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xnarapbo",true);
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
          // * --- Insert into knarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("knarapbo");
          m_cPhName = m_Ctx.GetPhName("knarapbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"knarapbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"00000253")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000253(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"knarapbo",true);
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
          /* cInfProg1 := Utilities.GetAutonumber("PRGPINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
          cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          /* cInfProg2 := Utilities.GetAutonumber("PRGPINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
          cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
          /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into xapopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xapopebo");
          m_cPhName = m_Ctx.GetPhName("xapopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"00000257")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000257(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cInfProg1+"0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("23","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xapopebo",true);
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
          /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into xntestbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xntestbo");
          m_cPhName = m_Ctx.GetPhName("xntestbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"00000259")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000259(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(_connes,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cInfProg2+"0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xntestbo",true);
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
      } else { // Else
        /* If _rap = 0 */
        if (CPLib.eqr(_rap,0)) {
          /* cProgRap := Utilities.GetAutonumber("PRG"+LRTrim(w_codmage)+"\'"+LRTrim(gAzienda)+"'",'',10) */
          cProgRap = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRG"+CPLib.LRTrim(w_codmage)+"\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          /* _codrap := LRTrim(w_codmage)+cProgRap */
          _codrap = CPLib.LRTrim(w_codmage)+cProgRap;
          // * --- Insert into wurapporti from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("wurapporti");
          m_cPhName = m_Ctx.GetPhName("wurapporti");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wurapporti",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"0000025D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000025D(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_codmage,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProgRap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wurapporti",true);
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
          /* nProgImp := Utilities.GetAutonumber("PRGIMPRAP\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAP\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into anarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"0000025F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000025F(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("99","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_codmage,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"anarapbo",true);
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
          // * --- Insert into knarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("knarapbo");
          m_cPhName = m_Ctx.GetPhName("knarapbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"knarapbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"00000260")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000260(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"knarapbo",true);
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
          /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(gAzienda)+"'",'',10) */
          cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(gAzienda)+"'",'',11) */
          cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(gAzienda)+"'","",11);
          /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into rapopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"00000264")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000264(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cInfProg1+"0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("23","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"rapopebo",true);
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
          /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into intestbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"00000266")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000266(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(_connes,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cInfProg2+"0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"intestbo",true);
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
      // * --- Select from xapopebo
      m_cServer = m_Ctx.GetServer("xapopebo");
      m_cPhName = m_Ctx.GetPhName("xapopebo");
      if (Cursor_xapopebo!=null)
        Cursor_xapopebo.Close();
      Cursor_xapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,_codrap)+" "+")"+(m_Ctx.IsSharedTemp("xapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xapopebo.Eof())) {
        /* If xapopebo->DATAOPE > _datope */
        if (CPLib.gt(Cursor_xapopebo.GetDate("DATAOPE"),_datope)) {
          // * --- Write into xapopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xapopebo");
          m_cPhName = m_Ctx.GetPhName("xapopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"00000269")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(_datope,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xapopebo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codrap,"?",0,0,m_cServer),m_cServer,_codrap)+"";
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
          // * --- Write into xntestbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xntestbo");
          m_cPhName = m_Ctx.GetPhName("xntestbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"0000026A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(_datope,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xntestbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codrap,"?",0,0,m_cServer),m_cServer,_codrap)+"";
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
        Cursor_xapopebo.Next();
      }
      m_cConnectivityError = Cursor_xapopebo.ErrorMessage();
      Cursor_xapopebo.Close();
      // * --- End Select
      // * --- Select from rapopebo
      m_cServer = m_Ctx.GetServer("rapopebo");
      m_cPhName = m_Ctx.GetPhName("rapopebo");
      if (Cursor_rapopebo!=null)
        Cursor_rapopebo.Close();
      Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,_codrap)+" "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_rapopebo.Eof())) {
        /* If rapopebo->DATAOPE > _datope */
        if (CPLib.gt(Cursor_rapopebo.GetDate("DATAOPE"),_datope)) {
          // * --- Write into rapopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"0000026D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(_datope,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapopebo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(_codrap,"?",0,0,m_cServer),m_cServer,_codrap)+"";
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
          // * --- Write into intestbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"0000026E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(_datope,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codrap,"?",0,0,m_cServer),m_cServer,_codrap)+"";
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
        Cursor_rapopebo.Next();
      }
      m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
      Cursor_rapopebo.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_wurapporti!=null)
          Cursor_wurapporti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xapopebo!=null)
          Cursor_xapopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_rapopebo!=null)
          Cursor_rapopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_5() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_maxstati=null;
    CPResultSet Cursor_qbe_maxcitta=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _idb := '' */
      _idb = "";
      // * --- Read from operazbo
      m_cServer = m_Ctx.GetServer("operazbo");
      m_cPhName = m_Ctx.GetPhName("operazbo");
      m_cSql = "";
      m_cSql = m_cSql+"MTCN="+CPSql.SQLValueAdapter(CPLib.ToSQL(_uniquecode,"C",10,0,m_cServer),m_cServer,_uniquecode);
      m_cSql = m_cSql+" and DATAOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"D",8,0,m_cServer),m_cServer,_datope);
      m_cSql = m_cSql+" and SEGNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"C",1,0,m_cServer),m_cServer,_segno);
      if (m_Ctx.IsSharedTemp("operazbo")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _idb = Read_Cursor.GetString("IDBASE");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on operazbo into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _idb = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If Empty(_idb) */
      if (CPLib.Empty(_idb)) {
        // * --- Read from xperazbo
        m_cServer = m_Ctx.GetServer("xperazbo");
        m_cPhName = m_Ctx.GetPhName("xperazbo");
        m_cSql = "";
        m_cSql = m_cSql+"MTCN="+CPSql.SQLValueAdapter(CPLib.ToSQL(_uniquecode,"C",10,0,m_cServer),m_cServer,_uniquecode);
        m_cSql = m_cSql+" and DATAOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_datope,"D",8,0,m_cServer),m_cServer,_datope);
        m_cSql = m_cSql+" and SEGNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"C",1,0,m_cServer),m_cServer,_segno);
        if (m_Ctx.IsSharedTemp("xperazbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _idb = Read_Cursor.GetString("IDBASE");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on xperazbo into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _idb = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
      } // End If
      /* If Empty(_idb) */
      if (CPLib.Empty(_idb)) {
        /* _mage := '' */
        _mage = "";
        /* _prog := '' */
        _prog = "";
        /* _citdip := '' */
        _citdip = "";
        /* _cabdip := '' */
        _cabdip = "";
        /* _provdip := '' */
        _provdip = "";
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
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODDIP",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("MACROAGENTE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _prog = Read_Cursor.GetString("CODDIP");
          _mage = Read_Cursor.GetString("MACROAGENTE");
          _citdip = Read_Cursor.GetString("DESCCIT");
          _cabdip = Read_Cursor.GetString("CAB");
          _provdip = Read_Cursor.GetString("PROVINCIA");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _prog = "";
          _mage = "";
          _citdip = "";
          _cabdip = "";
          _provdip = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(_prog)) */
        if (CPLib.Empty(CPLib.LRTrim(_prog))) {
          /* _tiperr := '*1' */
          _tiperr = "*1";
          /* _listerr := _listerr + "* Agenzia non ancora censita |"  */
          _listerr = _listerr+"* Agenzia non ancora censita |";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          /* ElseIf LRTrim(_mage) <> LRTrim(w_codmage) */
        } else if (CPLib.ne(CPLib.LRTrim(_mage),CPLib.LRTrim(w_codmage))) {
          /* _tiperr := '*2' */
          _tiperr = "*2";
          /* _listerr := _listerr + "* Agenzia collegata ad un altro MacroAgente |" */
          _listerr = _listerr+"* Agenzia collegata ad un altro MacroAgente |";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          /* ElseIf Empty(w_codmage) */
        } else if (CPLib.Empty(w_codmage)) {
          /* _tiperr := '*D' */
          _tiperr = "*D";
          /* _listerr := _listerr + "* Agenzia non collegata a nessun MacroAgente |"  */
          _listerr = _listerr+"* Agenzia non collegata a nessun MacroAgente |";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(_cabdip) */
        if (CPLib.Empty(_cabdip)) {
          /* _tiperr := '*1' */
          _tiperr = "*1";
          /* _listerr := _listerr + "* Agenzia priva di codice CAB |" */
          _listerr = _listerr+"* Agenzia priva di codice CAB |";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(_provdip) */
        if (CPLib.Empty(_provdip)) {
          /* _tiperr := '*1' */
          _tiperr = "*1";
          /* _listerr := _listerr + "* Agenzia priva di provincia |" */
          _listerr = _listerr+"* Agenzia priva di provincia |";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(_citdip) */
        if (CPLib.Empty(_citdip)) {
          /* _tiperr := '*1' */
          _tiperr = "*1";
          /* _listerr := _listerr + "* Agenzia priva di città |" */
          _listerr = _listerr+"* Agenzia priva di città |";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Year(_datope) < 1900 */
        if (CPLib.lt(CPLib.Year(_datope),1900)) {
          /* _tiperr := '*3' */
          _tiperr = "*3";
          /* _listerr := _listerr + "* Data operazione non valida |" */
          _listerr = _listerr+"* Data operazione non valida |";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(_nasdata) */
        if (CPLib.Empty(_nasdata)) {
          /* _tiperr := '*A' */
          _tiperr = "*A";
          /* _listerr := _listerr + "* Data di nascita non presente |" */
          _listerr = _listerr+"* Data di nascita non presente |";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } else { // Else
          /* If Year(_nasdata) < 1900 */
          if (CPLib.lt(CPLib.Year(_nasdata),1900)) {
            /* _tiperr := '*4' */
            _tiperr = "*4";
            /* _listerr := _listerr + "* Data di nascita errata |" */
            _listerr = _listerr+"* Data di nascita errata |";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If Empty(_doctype) */
        if (CPLib.Empty(_doctype)) {
          /* _tiperr := '*E' */
          _tiperr = "*E";
          /* _listerr := _listerr + "*Tipo del documento assente |" */
          _listerr = _listerr+"*Tipo del documento assente |";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(_docril) */
        if (CPLib.Empty(_docril)) {
          /* _tiperr := '*B' */
          _tiperr = "*B";
          /* _listerr := _listerr + "* Data di rilascio del documento assente |" */
          _listerr = _listerr+"* Data di rilascio del documento assente |";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } else { // Else
          /* If Year(_docril) < 1900 */
          if (CPLib.lt(CPLib.Year(_docril),1900)) {
            /* _tiperr := '*5' */
            _tiperr = "*5";
            /* _listerr := _listerr + "* Data di rilascio del documento errata |" */
            _listerr = _listerr+"* Data di rilascio del documento errata |";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
          /* If _docril > _datope */
          if (CPLib.gt(_docril,_datope)) {
            /* _tiperr := '*5' */
            _tiperr = "*5";
            /* _listerr := _listerr + "* Data di rilascio del documento superiore alla data operazione |" */
            _listerr = _listerr+"* Data di rilascio del documento superiore alla data operazione |";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
          /* If _docril = _nasdata */
          if (CPLib.eqr(_docril,_nasdata)) {
            /* _tiperr := '*5' */
            _tiperr = "*5";
            /* _listerr := _listerr + "* Data di rilascio del documento coincide con la data di nascita |" */
            _listerr = _listerr+"* Data di rilascio del documento coincide con la data di nascita |";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If Empty(_docsca) */
        if (CPLib.Empty(_docsca)) {
          /* _tiperr := '*C' */
          _tiperr = "*C";
          /* _listerr := _listerr + "* Data di scadenza del documento assente |" */
          _listerr = _listerr+"* Data di scadenza del documento assente |";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } else { // Else
          /* If Year(_docsca) < 1900 */
          if (CPLib.lt(CPLib.Year(_docsca),1900)) {
            /* _tiperr := '*6' */
            _tiperr = "*6";
            /* _listerr := _listerr + "* Data di scadenza del documento errata |" */
            _listerr = _listerr+"* Data di scadenza del documento errata |";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
          /* If _datope > _docsca */
          if (CPLib.gt(_datope,_docsca)) {
            /* _tiperr := '*7' */
            _tiperr = "*7";
            /* _listerr := _listerr + "* Data di scadenza del documento inferiore alla data dell'operazione |" */
            _listerr = _listerr+"* Data di scadenza del documento inferiore alla data dell'operazione |";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
          /* If _docril > _docsca */
          if (CPLib.gt(_docril,_docsca)) {
            /* _tiperr := '*7' */
            _tiperr = "*7";
            /* _listerr := _listerr + "* Data di scadenza del documento inferiore alla data di rilascio |" */
            _listerr = _listerr+"* Data di scadenza del documento inferiore alla data di rilascio |";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If Empty(_numdoc) */
        if (CPLib.Empty(_numdoc)) {
          /* _tiperr := '*7' */
          _tiperr = "*7";
          /* _listerr := _listerr + "* ID (Numero) del documento assente |" */
          _listerr = _listerr+"* ID (Numero) del documento assente |";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(_autril) */
        if (CPLib.Empty(_autril)) {
          /* _tiperr := '*7' */
          _tiperr = "*7";
          /* _listerr := _listerr + "* Autorità di rilascio del documento assente |" */
          _listerr = _listerr+"* Autorità di rilascio del documento assente |";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(_sesso) */
        if (CPLib.Empty(_sesso)) {
          /* _tiperr := '*7' */
          _tiperr = "*7";
          /* _listerr := _listerr + "* Manca il genere della persona |" */
          _listerr = _listerr+"* Manca il genere della persona |";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(_nasstato) and Empty(_nascitta) */
        if (CPLib.Empty(_nasstato) && CPLib.Empty(_nascitta)) {
          /* _tiperr := '*7' */
          _tiperr = "*7";
          /* _listerr := _listerr + "* Manca il luogo di nascita |" */
          _listerr = _listerr+"* Manca il luogo di nascita |";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          /* _listerr := _listerr + "* Manca lo stato di residenza |" */
          _listerr = _listerr+"* Manca lo stato di residenza |";
          /* _id := 0 */
          _id = CPLib.Round(0,0);
          // * --- Select from qbe_maxstati
          if (Cursor_qbe_maxstati!=null)
            Cursor_qbe_maxstati.Close();
          Cursor_qbe_maxstati = new VQRHolder("qbe_maxstati",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_maxstati.Eof())) {
            /* _id := qbe_maxstati->MAXID */
            _id = CPLib.Round(Cursor_qbe_maxstati.GetDouble("MAXID"),0);
            Cursor_qbe_maxstati.Next();
          }
          m_cConnectivityError = Cursor_qbe_maxstati.ErrorMessage();
          Cursor_qbe_maxstati.Close();
          // * --- End Select
          /* _id := _id + 1 */
          _id = CPLib.Round(_id+1,0);
          // * --- Insert into DecodeStati from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("DecodeStati");
          m_cPhName = m_Ctx.GetPhName("DecodeStati");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"DecodeStati",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000002D8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000002D8(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_id,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_luonas,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"DecodeStati",true);
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
          /* _id := 0 */
          _id = CPLib.Round(0,0);
          // * --- Select from qbe_maxcitta
          if (Cursor_qbe_maxcitta!=null)
            Cursor_qbe_maxcitta.Close();
          Cursor_qbe_maxcitta = new VQRHolder("qbe_maxcitta",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_maxcitta.Eof())) {
            /* _id := qbe_maxcitta->MAXID */
            _id = CPLib.Round(Cursor_qbe_maxcitta.GetDouble("MAXID"),0);
            Cursor_qbe_maxcitta.Next();
          }
          m_cConnectivityError = Cursor_qbe_maxcitta.ErrorMessage();
          Cursor_qbe_maxcitta.Close();
          // * --- End Select
          /* _id := _id + 1 */
          _id = CPLib.Round(_id+1,0);
          // * --- Insert into DecodeCitta from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("DecodeCitta");
          m_cPhName = m_Ctx.GetPhName("DecodeCitta");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"DecodeCitta",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000002DD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000002DD(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_id,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_luonas,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"DecodeCitta",true);
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
        /* If Empty(_codstares) */
        if (CPLib.Empty(_codstares)) {
          /* _listerr := _listerr + "* Manca lo stato di residenza |" */
          _listerr = _listerr+"* Manca lo stato di residenza |";
          /* _id := 0 */
          _id = CPLib.Round(0,0);
          // * --- Select from qbe_maxstati
          if (Cursor_qbe_maxstati!=null)
            Cursor_qbe_maxstati.Close();
          Cursor_qbe_maxstati = new VQRHolder("qbe_maxstati",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_maxstati.Eof())) {
            /* _id := qbe_maxstati->MAXID */
            _id = CPLib.Round(Cursor_qbe_maxstati.GetDouble("MAXID"),0);
            Cursor_qbe_maxstati.Next();
          }
          m_cConnectivityError = Cursor_qbe_maxstati.ErrorMessage();
          Cursor_qbe_maxstati.Close();
          // * --- End Select
          /* _id := _id + 1 */
          _id = CPLib.Round(_id+1,0);
          // * --- Insert into DecodeStati from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("DecodeStati");
          m_cPhName = m_Ctx.GetPhName("DecodeStati");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"DecodeStati",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000002E4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000002E4(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_id,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_paese,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"DecodeStati",true);
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
        /* If Empty(_codcit) and _codstares='086' */
        if (CPLib.Empty(_codcit) && CPLib.eqr(_codstares,"086")) {
          /* _listerr := _listerr + "* Manca la città di residenza |" */
          _listerr = _listerr+"* Manca la città di residenza |";
        } // End If
        /* If w_xMAFLGCKR='S' */
        if (CPLib.eqr(w_xMAFLGCKR,"S")) {
          /* If Len(LRTrim(_codfis))=16 */
          if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_codfis)),16)) {
            /* _rapporto := '' */
            _rapporto = "";
            // * --- Read from anarapbo
            m_cServer = m_Ctx.GetServer("anarapbo");
            m_cPhName = m_Ctx.GetPhName("anarapbo");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_codfis),"C",25,0,m_cServer),m_cServer,CPLib.LRTrim(_codfis));
            if (m_Ctx.IsSharedTemp("anarapbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _rapporto = Read_Cursor.GetString("RAPPORTO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _rapporto = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(LRTrim(_rapporto)) */
            if (CPLib.Empty(CPLib.LRTrim(_rapporto))) {
              /* _tiperr := '*1' */
              _tiperr = "*1";
              /* _listerr := _listerr + "* Rapporto non esistente |" */
              _listerr = _listerr+"* Rapporto non esistente |";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
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
            /* _listerr := _listerr + "* Mancanza dati per calcolo codice fiscale fittizio |" */
            _listerr = _listerr+"* Mancanza dati per calcolo codice fiscale fittizio |";
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
          /* If not(arfn_chkcodfis(_codfis,'000',_nocf)) */
          if ( ! (arfn_chkcodfisR.Make(m_Ctx,this).Run(_codfis,"000",_nocf))) {
            /* _listerr := _listerr + "* Codice Fiscale Originale - Codice Fiscale non valido |" */
            _listerr = _listerr+"* Codice Fiscale Originale - Codice Fiscale non valido |";
          } // End If
        } // End If
        /* If Empty(_cognomecp) */
        if (CPLib.Empty(_cognomecp)) {
          /* _tiperr := '*P' */
          _tiperr = "*P";
          /* _listerr := _listerr + "* Manca cognome conroparte |" */
          _listerr = _listerr+"* Manca cognome conroparte |";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(_nomecp) */
        if (CPLib.Empty(_nomecp)) {
          /* _tiperr := '*P' */
          _tiperr = "*P";
          /* _listerr := _listerr + "* Manca nome conroparte |" */
          _listerr = _listerr+"* Manca nome conroparte |";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(_uifdest) */
        if (CPLib.Empty(_uifdest)) {
          /* _tiperr := '*P' */
          _tiperr = "*P";
          /* _listerr := _listerr + "* Manca stato destinazione |" */
          _listerr = _listerr+"* Manca stato destinazione |";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
      } else { // Else
        /* _listerr := _listerr + "* Operazione già caricata sul sistema" */
        _listerr = _listerr+"* Operazione già caricata sul sistema";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
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
        if (Cursor_qbe_maxstati!=null)
          Cursor_qbe_maxstati.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_maxcitta!=null)
          Cursor_qbe_maxcitta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_6() throws Exception {
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
      conta = 0;
      /* _nerrori := 0 */
      _nerrori = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Salta la prima riga in quanti dice solo cose di trasmissione */
      /* _idfile := LRTrim(nomefileimport) */
      _idfile = CPLib.LRTrim(nomefileimport);
      /* Legge il file */
      // Legge il file
      CSVReader reader = new CSVReaderBuilder(new FileReader(_filename)).withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build();
      String [] nextLine;
      while ((nextLine = reader.readNext()) != null) {
        if (nextLine.length==9) {
      /* mcAgeDuo.AppendWithKey(nextLine[0]) */
      mcAgeDuo.AppendWithKey(nextLine[0]);
      /* mcAgeDuo.colonna01 := nextLine[0] */
      mcAgeDuo.row.colonna01 = nextLine[0];
      /* mcAgeDuo.colonna02 := nextLine[1] */
      mcAgeDuo.row.colonna02 = nextLine[1];
      /* mcAgeDuo.colonna03 := nextLine[2] */
      mcAgeDuo.row.colonna03 = nextLine[2];
      /* mcAgeDuo.colonna04 := nextLine[3] */
      mcAgeDuo.row.colonna04 = nextLine[3];
      /* mcAgeDuo.colonna05 := nextLine[4] */
      mcAgeDuo.row.colonna05 = nextLine[4];
      /* mcAgeDuo.colonna06 := nextLine[5] */
      mcAgeDuo.row.colonna06 = nextLine[5];
      /* mcAgeDuo.colonna07 := nextLine[6] */
      mcAgeDuo.row.colonna07 = nextLine[6];
      /* mcAgeDuo.colonna08 := nextLine[7] */
      mcAgeDuo.row.colonna08 = nextLine[7];
      /* mcAgeDuo.colonna09 := nextLine[8] */
      mcAgeDuo.row.colonna09 = nextLine[8];
      /* mcAgeDuo.SaveRow() */
      mcAgeDuo.SaveRow();
      // Chiude ciclo e if
        }
      }
      // Commit
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      m_Sql.CompleteTransaction();
      // Chiude il file e lo cancella
      reader.close();
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000032Fstatus;
      nTry0000032Fstatus = m_Sql.GetTransactionStatus();
      String cTry0000032Fmsg;
      cTry0000032Fmsg = m_Sql.TransactionErrorMessage();
      try {
        // Legge il file
        reader = new CSVReaderBuilder(new FileReader(_filename)).withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build();
        while ((nextLine = reader.readNext()) != null) {
          if (nextLine.length==9) {
        /* If not(Empty(LRTrim(nextLine[0]))) and Len(LRTrim(nextLine[0])) > 3 */
        if ( ! (CPLib.Empty(CPLib.LRTrim(nextLine[0]))) && CPLib.gt(CPLib.Len(CPLib.LRTrim(nextLine[0])),3)) {
          /* _contage := 0 */
          _contage = CPLib.Round(0,0);
          for (MemoryCursorRow_mcerratedef_mcrdef rowErrate : mcAgeDuo._iterable_()) {
            /* If LRTrim(rowErrate.colonna01)=LRTrim(nextLine[0]) or LRTrim(rowErrate.colonna08)=LRTrim(nextLine[7]) */
            if (CPLib.eqr(CPLib.LRTrim(rowErrate.colonna01),CPLib.LRTrim(nextLine[0])) || CPLib.eqr(CPLib.LRTrim(rowErrate.colonna08),CPLib.LRTrim(nextLine[7]))) {
              /* _contage := _contage + 1 */
              _contage = CPLib.Round(_contage+1,0);
            } // End If
          }
          /* _coddip := '' */
          _coddip = "";
          /* _prov := '' */
          _prov = "";
          /* _cap := '' */
          _cap = "";
          /* _cab := '' */
          _cab = "";
          /* _idbase := '' */
          _idbase = "";
          /* w_codmage := '' */
          w_codmage = "";
          // * --- Read from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          m_cSql = "";
          m_cSql = m_cSql+"AGACCODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(nextLine[0]),"C",10,0,m_cServer),m_cServer,CPLib.LRTrim(nextLine[0]));
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
              Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
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
            m_cSql = m_cSql+"TERMINALID="+CPSql.SQLValueAdapter(CPLib.ToSQL(nextLine[7],"C",15,0,m_cServer),m_cServer,nextLine[7]);
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
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
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
              m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(nextLine[0],4,6)),"C",6,0,m_cServer),m_cServer,CPLib.LRTrim(CPLib.Substr(nextLine[0],4,6)));
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
                  Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
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
          } // End If
          // * --- Read from DecodeCitta
          m_cServer = m_Ctx.GetServer("DecodeCitta");
          m_cPhName = m_Ctx.GetPhName("DecodeCitta");
          m_cSql = "";
          m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(nextLine[3]),"C",80,0,m_cServer),m_cServer,CPLib.LRTrim(nextLine[3]));
          if (m_Ctx.IsSharedTemp("DecodeCitta")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CITTAMIT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _citta = Read_Cursor.GetString("CITTAMIT");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on DecodeCitta into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _citta = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* _citta := iif(Empty(_citta),LRTrim(nextLine[3]),_citta) */
          _citta = (CPLib.Empty(_citta)?CPLib.LRTrim(nextLine[3]):_citta);
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
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAP",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _cab = Read_Cursor.GetString("CAB");
            _prov = Read_Cursor.GetString("PROV");
            _cap = Read_Cursor.GetString("CAP");
            _idbase = Read_Cursor.GetString("IDBASE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _cab = "";
            _prov = "";
            _cap = "";
            _idbase = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(_idbase) or _contage > 1 */
          if (CPLib.Empty(_idbase) || CPLib.gt(_contage,1)) {
            /* _nerrage := _nerrage + 1 */
            _nerrage = CPLib.Round(_nerrage+1,0);
            /* mcErrAge.AppendWithKey(nextLine[0]) */
            mcErrAge.AppendWithKey(nextLine[0]);
            /* mcErrAge.colonna01 := nextLine[0] */
            mcErrAge.row.colonna01 = nextLine[0];
            /* mcErrAge.colonna02 := nextLine[1] */
            mcErrAge.row.colonna02 = nextLine[1];
            /* mcErrAge.colonna03 := nextLine[2] */
            mcErrAge.row.colonna03 = nextLine[2];
            /* mcErrAge.colonna04 := nextLine[3] */
            mcErrAge.row.colonna04 = nextLine[3];
            /* mcErrAge.colonna05 := nextLine[4] */
            mcErrAge.row.colonna05 = nextLine[4];
            /* mcErrAge.colonna06 := nextLine[5] */
            mcErrAge.row.colonna06 = nextLine[5];
            /* mcErrAge.colonna07 := nextLine[6] */
            mcErrAge.row.colonna07 = nextLine[6];
            /* mcErrAge.colonna08 := nextLine[7] */
            mcErrAge.row.colonna08 = nextLine[7];
            /* mcErrAge.colonna09 := nextLine[8] */
            mcErrAge.row.colonna09 = nextLine[8];
            /* mcErrAge.colonna10 := iif(_contage>1,'Duplicazione Agenzia','Mancano i dati completi della località') */
            mcErrAge.row.colonna10 = (CPLib.gt(_contage,1)?"Duplicazione Agenzia":"Mancano i dati completi della località");
            /* mcErrAge.SaveRow() */
            mcErrAge.SaveRow();
          } else { // Else
            // * --- Read from tbmacage
            m_cServer = m_Ctx.GetServer("tbmacage");
            m_cPhName = m_Ctx.GetPhName("tbmacage");
            m_cSql = "";
            m_cSql = m_cSql+"MANAIDWU="+CPSql.SQLValueAdapter(CPLib.ToSQL(nextLine[6],"C",5,0,m_cServer),m_cServer,nextLine[6]);
            if (m_Ctx.IsSharedTemp("tbmacage")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("MACODICE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              w_codmage = Read_Cursor.GetString("MACODICE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbmacage into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              w_codmage = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
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
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"00000357")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000357(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(nextLine[0],4,6)),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[1]),30),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_citta,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[4]),2),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull(w_codmage,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[0]),10),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cab,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cap,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idbase,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[2]),40),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nextLine[7],"?",0,0,m_cServer)+", ";
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
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"00000359")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DESCRIZ = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[1]),30),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"IDCITTA = "+CPLib.ToSQL(_idbase,"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(_citta,"C",60,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(_prov,"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAB = "+CPLib.ToSQL(_cab,"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"AGENTE = "+CPLib.ToSQL(1,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"MACROAGENTE = "+CPLib.ToSQLNull(w_codmage,"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[2]),40),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(_cap,"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"AGACCODE = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[0]),10),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"TERMINALID = "+CPLib.ToSQL(nextLine[7],"C",15,0,m_cServer)+", ";
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
          /* mcErrAge.AppendWithKey(nextLine[0]) */
          mcErrAge.AppendWithKey(nextLine[0]);
          /* mcErrAge.colonna01 := nextLine[0] */
          mcErrAge.row.colonna01 = nextLine[0];
          /* mcErrAge.colonna02 := nextLine[1] */
          mcErrAge.row.colonna02 = nextLine[1];
          /* mcErrAge.colonna03 := nextLine[2] */
          mcErrAge.row.colonna03 = nextLine[2];
          /* mcErrAge.colonna04 := nextLine[3] */
          mcErrAge.row.colonna04 = nextLine[3];
          /* mcErrAge.colonna05 := nextLine[4] */
          mcErrAge.row.colonna05 = nextLine[4];
          /* mcErrAge.colonna06 := nextLine[5] */
          mcErrAge.row.colonna06 = nextLine[5];
          /* mcErrAge.colonna07 := nextLine[6] */
          mcErrAge.row.colonna07 = nextLine[6];
          /* mcErrAge.colonna08 := nextLine[7] */
          mcErrAge.row.colonna08 = nextLine[7];
          /* mcErrAge.colonna09 := nextLine[8] */
          mcErrAge.row.colonna09 = nextLine[8];
          /* mcErrAge.colonna10 := 'Dati non completi' */
          mcErrAge.row.colonna10 = "Dati non completi";
          /* mcErrAge.SaveRow() */
          mcErrAge.SaveRow();
        } // End If
        /* conta := conta + 1 */
        conta = conta+1;
        /* gMsgImp := 'Sono state elaborate '+LRTrim(Str(conta,10,0))+' informazioni del file '+nomefileimport // Messaggio Import */
        gMsgImp = "Sono state elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" informazioni del file "+nomefileimport;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // Chiude ciclo e if
          }
        }
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        // Chiude il file e lo cancella
        reader.close();
        FileLibMit.DeleteFile("appo/"+nomefileimport);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000032Fstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000032Fstatus,cTry0000032Fmsg);
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
      /* gMsgProc := gMsgProc + 'Agenzie Scartate '+LRTrim(Str(_nerrage,10,0)) + ' dal file '+nomefileimport+NL */
      gMsgProc = gMsgProc+"Agenzie Scartate "+CPLib.LRTrim(CPLib.Str(_nerrage,10,0))+" dal file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* FileLibMit.DeleteFile('./appo/'+nomefileimport) */
      FileLibMit.DeleteFile("./appo/"+nomefileimport);
      /* gMsgImp := 'Fine importazione del file '+nomefileimport // Messaggio Import */
      gMsgImp = "Fine importazione del file "+nomefileimport;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
  void Page_7() throws Exception {
    CPResultSet Cursor_operazbo=null;
    CPResultSet Cursor_fraziobo=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_beneficope=null;
    CPResultSet Cursor_terzistiope=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_terzistifrz=null;
    try {
      /* _idbase := '' */
      _idbase = "";
      // * --- Select from operazbo
      m_cServer = m_Ctx.GetServer("operazbo");
      m_cPhName = m_Ctx.GetPhName("operazbo");
      if (Cursor_operazbo!=null)
        Cursor_operazbo.Close();
      Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"MTCN="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_uniquecode),10),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(CPLib.LRTrim(_uniquecode),10))+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_operazbo.Eof())) {
        /* _idbase := operazbo->IDBASE */
        _idbase = Cursor_operazbo.GetString("IDBASE");
        /* _tdest := 'O' */
        _tdest = "O";
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
        Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"MTCN="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_uniquecode),10),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(CPLib.LRTrim(_uniquecode),10))+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_fraziobo.Eof())) {
          /* _idbase := fraziobo->IDBASE */
          _idbase = Cursor_fraziobo.GetString("IDBASE");
          /* _tdest := 'F' */
          _tdest = "F";
          Cursor_fraziobo.Next();
        }
        m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
        Cursor_fraziobo.Close();
        // * --- End Select
      } // End If
      /* If not(Empty(_idbase)) */
      if ( ! (CPLib.Empty(_idbase))) {
        /* stringaflagrap2 := 'ABCDEFGHI' // stringa di valori di flagrap2 */
        stringaflagrap2 = "ABCDEFGHI";
        /* If _tdest='O' */
        if (CPLib.eqr(_tdest,"O")) {
          // * --- Select from operazbo
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          if (Cursor_operazbo!=null)
            Cursor_operazbo.Close();
          Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,NUMPROG,DATAOPE,FLAGRAP2  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,_idbase)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_operazbo.Eof())) {
            /* _oldidb := operazbo->IDBASE */
            _oldidb = Cursor_operazbo.GetString("IDBASE");
            /* _flagrap2 := iif(Empty(operazbo->FLAGRAP2) or operazbo->FLAGRAP2='S',Left(stringaflagrap2,1),Substr(stringaflagrap2,(At(operazbo->FLAGRAP2,stringaflagrap2)+1),1)) */
            _flagrap2 = (CPLib.Empty(Cursor_operazbo.GetString("FLAGRAP2")) || CPLib.eqr(Cursor_operazbo.GetString("FLAGRAP2"),"S")?CPLib.Left(stringaflagrap2,1):CPLib.Substr(stringaflagrap2,(CPLib.At(Cursor_operazbo.GetString("FLAGRAP2"),stringaflagrap2)+1),1));
            /* _idreg := operazbo->IDEREG */
            _idreg = Cursor_operazbo.GetString("IDEREG");
            /* cOpeProg2 := operazbo->NUMPROG */
            cOpeProg2 = Cursor_operazbo.GetString("NUMPROG");
            // * --- Write into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"00000386")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("3","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
            m_cSql = m_cSql+"FLAGRAP2 = "+CPLib.ToSQL(_flagrap2,"C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_operazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_operazbo.GetString("IDBASE"))+"";
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
            // * --- Select from sogopebo
            m_cServer = m_Ctx.GetServer("sogopebo");
            m_cPhName = m_Ctx.GetPhName("sogopebo");
            if (Cursor_sogopebo!=null)
              Cursor_sogopebo.Close();
            Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_sogopebo.Eof())) {
              // * --- Insert into mogopebo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("mogopebo");
              m_cPhName = m_Ctx.GetPhName("mogopebo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mogopebo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"00000388")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000388(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetDouble("CPROWNUM"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mogopebo",true);
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
              Cursor_sogopebo.Next();
            }
            m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
            Cursor_sogopebo.Close();
            // * --- End Select
            // * --- Select from clientiope
            m_cServer = m_Ctx.GetServer("clientiope");
            m_cPhName = m_Ctx.GetPhName("clientiope");
            if (Cursor_clientiope!=null)
              Cursor_clientiope.Close();
            Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_clientiope.Eof())) {
              // * --- Insert into mlientiope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("mlientiope");
              m_cPhName = m_Ctx.GetPhName("mlientiope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mlientiope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"0000038A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000038A(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mlientiope",true);
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
              Cursor_clientiope.Next();
            }
            m_cConnectivityError = Cursor_clientiope.ErrorMessage();
            Cursor_clientiope.Close();
            // * --- End Select
            // * --- Select from beneficope
            m_cServer = m_Ctx.GetServer("beneficope");
            m_cPhName = m_Ctx.GetPhName("beneficope");
            if (Cursor_beneficope!=null)
              Cursor_beneficope.Close();
            Cursor_beneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("beneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_beneficope.Eof())) {
              // * --- Insert into meneficope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("meneficope");
              m_cPhName = m_Ctx.GetPhName("meneficope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"meneficope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"0000038C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000038C(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_IND"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_STA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetDouble("CPROWNUM"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"meneficope",true);
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
              Cursor_beneficope.Next();
            }
            m_cConnectivityError = Cursor_beneficope.ErrorMessage();
            Cursor_beneficope.Close();
            // * --- End Select
            // * --- Select from terzistiope
            m_cServer = m_Ctx.GetServer("terzistiope");
            m_cPhName = m_Ctx.GetPhName("terzistiope");
            if (Cursor_terzistiope!=null)
              Cursor_terzistiope.Close();
            Cursor_terzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("terzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_terzistiope.Eof())) {
              // * --- Insert into merzistiope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("merzistiope");
              m_cPhName = m_Ctx.GetPhName("merzistiope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"merzistiope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"0000038E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000038E(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"merzistiope",true);
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
              Cursor_terzistiope.Next();
            }
            m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
            Cursor_terzistiope.Close();
            // * --- End Select
            Cursor_operazbo.Next();
          }
          m_cConnectivityError = Cursor_operazbo.ErrorMessage();
          Cursor_operazbo.Close();
          // * --- End Select
          /* cOpeProg1 := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(gAzienda)+"'",'',10) */
          cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          // * --- Insert into operazbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"00000390")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000390(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognomecp)+" "+CPLib.LRTrim(_nomecp),70),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uifdest,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codfis,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_intercit,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_xMAFLGBON,"S")?"0":"1"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O"+CPLib.Right(cOpeProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_tipope,"10")?_importo*100:0),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_importo*100,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(_datope),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* gMsgProc := gMsgProc +"OPERAZBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
            gMsgProc = gMsgProc+"OPERAZBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            m_cLastMsgError = "";
            /* _esito := -1 */
            _esito = CPLib.Round(-1,0);
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          // * --- Write into docopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("docopebo");
          m_cPhName = m_Ctx.GetPhName("docopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"docopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"00000395")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(CPLib.Left(_connes,16),"C",16,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(CPLib.Left(_doctype,2),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Left(_numdoc,15),"C",15,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(_docril,"D",8,0)+", ";
          m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Left(_autril,30),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(_docsca,"D",8,0)+", ";
          m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Left(_via,35),"C",35,0,m_cServer)+", ";
          m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Left(_citta,30),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Left(_prov,2),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Left(_cap,5),"C",9,0,m_cServer)+", ";
          m_cSql = m_cSql+"IDFILE = "+CPLib.ToSQL(_idfile,"C",60,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"docopebo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"NUMPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer),m_cServer,cOpeProg2)+"";
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
          /* If Empty(LRTrim(_tiperr)) */
          if (CPLib.Empty(CPLib.LRTrim(_tiperr))) {
            /* _tiperr := '+0' */
            _tiperr = "+0";
          } // End If
        } else { // Else
          /* stringaflagrap2 := 'JLMNOTUV?' // stringa di valori di flagrap2 */
          stringaflagrap2 = "JLMNOTUV?";
          // * --- Select from fraziobo
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          if (Cursor_fraziobo!=null)
            Cursor_fraziobo.Close();
          Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,NUMPROG,DATAOPE,FLAGRAP2  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,_idbase)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_fraziobo.Eof())) {
            /* _oldidb := fraziobo->IDBASE */
            _oldidb = Cursor_fraziobo.GetString("IDBASE");
            /* _flagrap2 := iif(Empty(fraziobo->FLAGRAP2) or fraziobo->FLAGRAP2='Z',Left(stringaflagrap2,1),Substr(stringaflagrap2,(At(fraziobo->FLAGRAP2,stringaflagrap2)+1),1)) */
            _flagrap2 = (CPLib.Empty(Cursor_fraziobo.GetString("FLAGRAP2")) || CPLib.eqr(Cursor_fraziobo.GetString("FLAGRAP2"),"Z")?CPLib.Left(stringaflagrap2,1):CPLib.Substr(stringaflagrap2,(CPLib.At(Cursor_fraziobo.GetString("FLAGRAP2"),stringaflagrap2)+1),1));
            /* _idreg := fraziobo->IDEREG */
            _idreg = Cursor_fraziobo.GetString("IDEREG");
            /* cOpeProg2 := operazbo->NUMPROG */
            cOpeProg2 = Cursor_operazbo.GetString("NUMPROG");
            // * --- Write into fraziobo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"0000039E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("3","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
            m_cSql = m_cSql+"FLAGRAP2 = "+CPLib.ToSQL(_flagrap2,"C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_fraziobo.GetString("IDBASE"))+"";
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
            // * --- Select from sogopefbo
            m_cServer = m_Ctx.GetServer("sogopefbo");
            m_cPhName = m_Ctx.GetPhName("sogopefbo");
            if (Cursor_sogopefbo!=null)
              Cursor_sogopefbo.Close();
            Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_sogopefbo.Eof())) {
              // * --- Insert into mogopefbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("mogopefbo");
              m_cPhName = m_Ctx.GetPhName("mogopefbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mogopefbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000003A0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000003A0(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mogopefbo",true);
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
              Cursor_sogopefbo.Next();
            }
            m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
            Cursor_sogopefbo.Close();
            // * --- End Select
            // * --- Select from clientifrz
            m_cServer = m_Ctx.GetServer("clientifrz");
            m_cPhName = m_Ctx.GetPhName("clientifrz");
            if (Cursor_clientifrz!=null)
              Cursor_clientifrz.Close();
            Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_clientifrz.Eof())) {
              // * --- Insert into mlientifrz from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("mlientifrz");
              m_cPhName = m_Ctx.GetPhName("mlientifrz");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mlientifrz",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000003A2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000003A2(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mlientifrz",true);
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
              Cursor_clientifrz.Next();
            }
            m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
            Cursor_clientifrz.Close();
            // * --- End Select
            // * --- Select from beneficfrz
            m_cServer = m_Ctx.GetServer("beneficfrz");
            m_cPhName = m_Ctx.GetPhName("beneficfrz");
            if (Cursor_beneficfrz!=null)
              Cursor_beneficfrz.Close();
            Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_beneficfrz.Eof())) {
              // * --- Insert into meneficfrz from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("meneficfrz");
              m_cPhName = m_Ctx.GetPhName("meneficfrz");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"meneficfrz",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000003A4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000003A4(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetDouble("CPROWNUM"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_STA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_IND"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"meneficfrz",true);
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
              Cursor_beneficfrz.Next();
            }
            m_cConnectivityError = Cursor_beneficfrz.ErrorMessage();
            Cursor_beneficfrz.Close();
            // * --- End Select
            // * --- Select from terzistifrz
            m_cServer = m_Ctx.GetServer("terzistifrz");
            m_cPhName = m_Ctx.GetPhName("terzistifrz");
            if (Cursor_terzistifrz!=null)
              Cursor_terzistifrz.Close();
            Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_terzistifrz.Eof())) {
              // * --- Insert into merzistifrz from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("merzistifrz");
              m_cPhName = m_Ctx.GetPhName("merzistifrz");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"merzistifrz",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000003A6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000003A6(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"merzistifrz",true);
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
              Cursor_terzistifrz.Next();
            }
            m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
            Cursor_terzistifrz.Close();
            // * --- End Select
            Cursor_fraziobo.Next();
          }
          m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
          Cursor_fraziobo.Close();
          // * --- End Select
          /* cOpeProg1 := Utilities.GetAutonumber("PFRAZIO1\'"+LRTrim(gAzienda)+"'",'',10) */
          cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          // * --- Insert into fraziobo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000003A8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000003A8(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognomecp)+" "+CPLib.LRTrim(_nomecp),70),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uifdest,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codfis,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_intercit,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_xMAFLGBON,"S")?"0":"1"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("F"+CPLib.Right(cOpeProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_tipope,"10")?_importo*100:0),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_importo*100,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(_datope),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"fraziobo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* gMsgProc := gMsgProc +"FRAZIOBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
            gMsgProc = gMsgProc+"FRAZIOBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            m_cLastMsgError = "";
            /* _esito := -1 */
            _esito = CPLib.Round(-1,0);
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          // * --- Write into docfrabo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("docfrabo");
          m_cPhName = m_Ctx.GetPhName("docfrabo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"docfrabo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000003AD")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(CPLib.Left(_connes,16),"C",16,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(CPLib.Left(_doctype,2),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Left(_numdoc,15),"C",15,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(_docril,"D",8,0)+", ";
          m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Left(_autril,30),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(_docsca,"D",8,0)+", ";
          m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Left(_via,35),"C",35,0,m_cServer)+", ";
          m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Left(_citta,30),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Left(_prov,2),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.Left(_cap,5),"C",9,0,m_cServer)+", ";
          m_cSql = m_cSql+"IDFILE = "+CPLib.ToSQL(_idfile,"C",60,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"docfrabo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"NUMPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer),m_cServer,cOpeProg2)+"";
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
          /* If Empty(LRTrim(_tiperr)) */
          if (CPLib.Empty(CPLib.LRTrim(_tiperr))) {
            /* _tiperr := '+0' */
            _tiperr = "+0";
          } // End If
        } // End If
      } else { // Else
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
        /* _tiperr := '*Y' */
        _tiperr = "*Y";
        /* _listerr := _listerr + "* Operazione da modificare non presente in AUI |" */
        _listerr = _listerr+"* Operazione da modificare non presente in AUI |";
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
      try {
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_clientiope!=null)
          Cursor_clientiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_beneficope!=null)
          Cursor_beneficope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_terzistiope!=null)
          Cursor_terzistiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_sogopefbo!=null)
          Cursor_sogopefbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_clientifrz!=null)
          Cursor_clientifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_beneficfrz!=null)
          Cursor_beneficfrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_terzistifrz!=null)
          Cursor_terzistifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_8() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* _codrap := '' */
      _codrap = "";
      /* If w_xMAFLGRAP='S' */
      if (CPLib.eqr(w_xMAFLGRAP,"S")) {
        /* Exec "Crea Rapporti" Page 4:Page_4 */
        Page_4();
      } // End If
      /* If w_xMAFLGASR='S' */
      if (CPLib.eqr(w_xMAFLGASR,"S")) {
        /* _codrap := _codfis */
        _codrap = _codfis;
      } // End If
      /* If w_destfin='O' */
      if (CPLib.eqr(w_destfin,"O")) {
        /* nProgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(gAzienda)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000003BE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000003BE(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(_datope),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognomecp)+" "+CPLib.LRTrim(_nomecp),70),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uifdest,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codfis,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_intercit,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(_codrap)?"":"0"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_xMAFLGBON,"S")?"0":"1"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cOpeProg2+"X","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_xMAFLGBON,"S")?0:_importo),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xperazbo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* gMsgProc := gMsgProc +"XPERAZBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
            gMsgProc = gMsgProc+"XPERAZBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            m_cLastMsgError = "";
            /* _esito := -1 */
            _esito = CPLib.Round(-1,0);
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          // * --- Insert into xocopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xocopebo");
          m_cPhName = m_Ctx.GetPhName("xocopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xocopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000003C3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000003C3(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_connes,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_doctype,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_docril,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_autril,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_docsca,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_via,35),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_citta,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_prov,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_cap,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xocopebo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* gMsgProc := gMsgProc +"XOCOPEBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN " + _uniquecode + NL */
            gMsgProc = gMsgProc+"XOCOPEBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            m_cLastMsgError = "";
            /* _esito := -1 */
            _esito = CPLib.Round(-1,0);
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* If Empty(LRTrim(_tiperr)) */
          if (CPLib.Empty(CPLib.LRTrim(_tiperr))) {
            /* _tiperr := '+0' */
            _tiperr = "+0";
          } // End If
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000003CC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000003CC(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(_datope),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognomecp)+" "+CPLib.LRTrim(_nomecp),70),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uifdest,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codfis,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_intercit,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(_codrap)?"":"0"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_xMAFLGBON,"S")?"0":"1"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cOpeProg2+"X","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_xMAFLGBON,"S")?0:_importo*100),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_importo*100,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* gMsgProc := gMsgProc +"OPERAZBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
            gMsgProc = gMsgProc+"OPERAZBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            m_cLastMsgError = "";
            /* _esito := -1 */
            _esito = CPLib.Round(-1,0);
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          // * --- Insert into docopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("docopebo");
          m_cPhName = m_Ctx.GetPhName("docopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"docopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000003D1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000003D1(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_connes,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_doctype,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_docril,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_autril,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_docsca,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_via,35),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_citta,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_prov,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_cap,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"docopebo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* gMsgProc := gMsgProc +"DOCOPEBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
            gMsgProc = gMsgProc+"DOCOPEBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            m_cLastMsgError = "";
            /* _esito := -1 */
            _esito = CPLib.Round(-1,0);
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* If Empty(LRTrim(_tiperr)) */
          if (CPLib.Empty(CPLib.LRTrim(_tiperr))) {
            /* _tiperr := '+0' */
            _tiperr = "+0";
          } // End If
        } // End If
        /* ElseIf w_destfin='F' */
      } else if (CPLib.eqr(w_destfin,"F")) {
        /* nProgImp := Utilities.GetAutonumber("PRGIMPFRZ\'"+LRTrim(gAzienda)+"'",0,15) */
        nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPFRZ\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000003DC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000003DC(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(_datope),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognomecp)+" "+CPLib.LRTrim(_nomecp),70),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uifdest,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codfis,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_intercit,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(_codrap)?"":"0"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_xMAFLGBON,"S")?"0":"1"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cOpeProg2+"X","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_xMAFLGBON,"S")?0:_importo*100),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_importo*100,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xraziobo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* gMsgProc := gMsgProc +"XRAZIOBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
            gMsgProc = gMsgProc+"XRAZIOBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            m_cLastMsgError = "";
            /* _esito := -1 */
            _esito = CPLib.Round(-1,0);
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          // * --- Insert into xocfrabo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xocfrabo");
          m_cPhName = m_Ctx.GetPhName("xocfrabo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xocfrabo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000003E1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000003E1(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_connes,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_doctype,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_docril,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_autril,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_docsca,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_via,35),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_citta,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_prov,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_cap,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xocfrabo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* gMsgProc := gMsgProc +"XOCFRABO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN " + _uniquecode + NL */
            gMsgProc = gMsgProc+"XOCFRABO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            m_cLastMsgError = "";
            /* _esito := -1 */
            _esito = CPLib.Round(-1,0);
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* If Empty(LRTrim(_tiperr)) */
          if (CPLib.Empty(CPLib.LRTrim(_tiperr))) {
            /* _tiperr := '+0' */
            _tiperr = "+0";
          } // End If
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000003EA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000003EA(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(_datope),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognomecp)+" "+CPLib.LRTrim(_nomecp),70),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uifdest,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codfis,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_intercit,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(_codrap)?"":"0"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_xMAFLGBON,"S")?"0":"1"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cOpeProg2+"X","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_xMAFLGBON,"S")?0:_importo*100),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_importo*100,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"fraziobo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* gMsgProc := gMsgProc +"FRAZIOBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
            gMsgProc = gMsgProc+"FRAZIOBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* _esito := -1 */
            _esito = CPLib.Round(-1,0);
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          // * --- Insert into docfrabo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("docfrabo");
          m_cPhName = m_Ctx.GetPhName("docfrabo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"docfrabo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000003EE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000003EE(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_connes,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_doctype,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_docril,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_autril,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_docsca,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_via,35),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_citta,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_prov,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_cap,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"docfrabo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* gMsgProc := gMsgProc +"DOCFRABO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
            gMsgProc = gMsgProc+"DOCFRABO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            m_cLastMsgError = "";
            /* _esito := -1 */
            _esito = CPLib.Round(-1,0);
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          /* If Empty(LRTrim(_tiperr)) */
          if (CPLib.Empty(CPLib.LRTrim(_tiperr))) {
            /* _tiperr := '+0' */
            _tiperr = "+0";
          } // End If
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
        m_cSql = m_cSql+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codfis,"C",16,0,m_cServer),m_cServer,_codfis);
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
            Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_imp_dati_wursi_errori returns two or more records. This item should return only a record.");
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"000003FC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000003FC(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codfis,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_anno,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Generato da  MTCN: "+_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_id,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_anno+"_"+CPLib.LRTrim(_codfis),"?",0,0,m_cServer)+", ";
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
  void Page_9() throws Exception {
    /* Formato Excel */
    /* _filen := "Errori_TRX_"+DateToChar(Date())+".xlsx" */
    _filen = "Errori_TRX_"+CPLib.DateToChar(CPLib.Date())+".xlsx";
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
    cell.setCellValue("CITTA' DI RESIDENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(12);
    cell.setCellValue("TIPO DOCUMENTO");
    cell.setCellStyle(cs);
    cell = row.createCell(13);
    cell.setCellValue("DATA OPERAZIONE");
    cell.setCellStyle(cs);
    cell = row.createCell(14);
    cell.setCellValue("VALUTA");
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
    cell.setCellValue("PCID");
    cell.setCellStyle(cs);
    cell = row.createCell(22);
    cell.setCellValue("CODICE OPERATORE");
    cell.setCellStyle(cs);
    cell = row.createCell(23);
    cell.setCellValue("CITTA' AGENZIA");
    cell.setCellStyle(cs);
    cell = row.createCell(24);
    cell.setCellValue("NOME AGENZIA");
    cell.setCellStyle(cs);
    cell = row.createCell(25);
    cell.setCellValue("COGNOME CONTROPARTE");
    cell.setCellStyle(cs);
    cell = row.createCell(26);
    cell.setCellValue("NOME CONTROPARTE");
    cell.setCellStyle(cs);
    cell = row.createCell(27);
    cell.setCellValue("STATO CONTROPARTE");
    cell.setCellStyle(cs);
    cell = row.createCell(28);
    cell.setCellValue("CITTA' DEST. CONTROPARTE");
    cell.setCellStyle(cs);
    cell = row.createCell(29);
    cell.setCellValue("MTCN");
    cell.setCellStyle(cs);
    cell = row.createCell(30);
    cell.setCellValue("PAESE RESIDENZA CLIENTE");
    cell.setCellStyle(cs);
    cell = row.createCell(31);
    cell.setCellValue("DATA DI NASCITA");
    cell.setCellStyle(cs);
    cell = row.createCell(32);
    cell.setCellValue("SESSO");
    cell.setCellStyle(cs);
    cell = row.createCell(33);
    cell.setCellValue("CODICE CATASTALE");
    cell.setCellStyle(cs);
    cell = row.createCell(34);
    cell.setCellValue("MACROAGENTE");
    cell.setCellStyle(cs);
    cell = row.createCell(35);
    cell.setCellValue("ERRORI RILEVATI");
    cell.setCellStyle(cs);
    cell = row.createCell(36);
    cell.setCellValue("OPERAZIONE CORRETTA");
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
      cell.setCellValue(CPLib.LRTrim("N"));
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
    // scrivo il file di esito
    FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(_nfile));
    //write this workbook to an Outputstream.
    wb.write(fileOut);
    fileOut.flush();
    fileOut.close();
    // * --- Insert into tmp_listafile from values
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("tmp_listafile");
    m_cPhName = m_Ctx.GetPhName("tmp_listafile");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_listafile",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"0000040C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
    m_cSql = m_cSql+GetFieldsName_0000040C(m_Ctx,m_oWrInfo);
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
  }
  void Page_10() throws Exception {
    /* Formato Excel */
    /* _filen := "Errori_Location_"+DateToChar(Date())+".xlsx" */
    _filen = "Errori_Location_"+CPLib.DateToChar(CPLib.Date())+".xlsx";
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
    cell.setCellValue("Agency Account code");
    cell.setCellStyle(cs);
    cell =  row.createCell(1);
    cell.setCellValue("Agency Name");
    cell.setCellStyle(cs);
    cell = row.createCell(2);
    cell.setCellValue("Agency Address");
    cell.setCellStyle(cs);
    cell = row.createCell(3);
    cell.setCellValue("Agency City");
    cell.setCellStyle(cs);
    cell =  row.createCell(4);
    cell.setCellValue("Agency Province");
    cell.setCellStyle(cs);
    cell =  row.createCell(5);
    cell.setCellValue("IsSubagent");
    cell.setCellStyle(cs);
    cell =  row.createCell(6);
    cell.setCellValue("Network");
    cell.setCellStyle(cs);
    cell =  row.createCell(7);
    cell.setCellValue("TerminalID");
    cell.setCellStyle(cs);
    cell =  row.createCell(8);
    cell.setCellValue("Telephon number");
    cell.setCellStyle(cs);
    cell =  row.createCell(9);
    cell.setCellValue("Motivo Scarto");
    cell.setCellStyle(cs);
    r++;
    MemoryCursor_mcerratedef_mcrdef cpmc_00000416;
    cpmc_00000416 = new MemoryCursor_mcerratedef_mcrdef();
    for (MemoryCursorRow_mcerratedef_mcrdef rowErrate : mcErrAge._iterable_()) {
      cpmc_00000416.Append(rowErrate);
    }
    for (MemoryCursorRow_mcerratedef_mcrdef rowErrate : cpmc_00000416._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_mcerratedef_mcrdef>(){  public int compare(MemoryCursorRow_mcerratedef_mcrdef r1,MemoryCursorRow_mcerratedef_mcrdef r2){    if (CPLib.gt(r1.colonna01,r2.colonna01)) return 1;    if (CPLib.lt(r1.colonna01,r2.colonna01)) return -1;    return 0;  }})) {
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
    // scrivo il file di esito
    FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(_nfile));
    //write this workbook to an Outputstream.
    wb.write(fileOut);
    fileOut.flush();
    fileOut.close();
    // * --- Insert into tmp_listafile from values
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("tmp_listafile");
    m_cPhName = m_Ctx.GetPhName("tmp_listafile");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_listafile",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_wursi_errori",937,"0000041C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
    m_cSql = m_cSql+GetFieldsName_0000041C(m_Ctx,m_oWrInfo);
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
      m_Caller.SetString("tipodest","C",1,0,w_tipodest);
      m_Caller.SetNumber("impzip","N",1,0,w_impzip);
      m_Caller.SetString("destfin","C",1,0,w_destfin);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_imp_dati_wursi_erroriR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_imp_dati_wursi_erroriR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_tipodest = m_Caller.GetString("tipodest","C",1,0);
    w_impzip = m_Caller.GetNumber("impzip","N",1,0);
    w_destfin = m_Caller.GetString("destfin","C",1,0);
    fhand = CPLib.Space(1);
    _codrap = CPLib.Space(16);
    _luonas = CPLib.Space(50);
    nProg = 0;
    nomefileimport = CPLib.Space(50);
    xConnes = CPLib.Space(16);
    _tdest = CPLib.Space(1);
    _pos = 0;
    _npos = 0;
    _tipoop = CPLib.Space(1);
    _coddip = CPLib.Space(6);
    _uniquecode = CPLib.Space(10);
    _datope = CPLib.NullDate();
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
    _tipodoc = CPLib.Space(20);
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
    w_xMAFLGRAP = CPLib.Space(1);
    w_xMAFLGBON = CPLib.Space(1);
    w_xMAFLGCKR = CPLib.Space(1);
    w_xMAFLGASR = CPLib.Space(1);
    w_xMADIPSTD = CPLib.Space(6);
    w_xMAFLGCHKDAT = CPLib.Space(1);
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
    mcErrate = new MemoryCursor_mcerratedef_mcrdef();
    rowErrate = new MemoryCursorRow_mcerratedef_mcrdef();
    mcErrAge = new MemoryCursor_mcerratedef_mcrdef();
    mcAgeDuo = new MemoryCursor_mcerratedef_mcrdef();
    _contage = 0;
    cell_count = 0;
    riga_letta = 0;
    foglio = 0;
    _conta = 0;
    _idb = CPLib.Space(10);
    _flgvalage = CPLib.Space(1);
    _anno = CPLib.Space(4);
    czipfile = CPLib.Space(100);
    cpercorsozip = CPLib.Space(200);
    cdirectoryfile = CPLib.Space(200);
    buffernomefile = CPLib.Space(100);
    _priorita = 0;
    w_CODFISC = CPLib.Space(16);
    w_DATANASC = CPLib.NullDate();
    w_NASCOMUN = CPLib.Space(30);
    w_NASSTATO = CPLib.Space(30);
    w_COGNOME = CPLib.Space(26);
    w_RAGSOC = CPLib.Space(70);
    w_NOME = CPLib.Space(25);
    w_SESSO = CPLib.Space(1);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_maxstati,qbe_maxcitta,qbe_maxstati,
  public static final String m_cVQRList = ",qbe_maxstati,qbe_maxcitta,qbe_maxstati,";
  // ENTITY_BATCHES: ,arfn_chkcodfis,arfn_fdatetime,arrt_calccodfis_wu,
  public static final String i_InvokedRoutines = ",arfn_chkcodfis,arfn_fdatetime,arrt_calccodfis_wu,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000017C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
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
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"OLDCODFISC,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000185(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
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
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"kersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000191(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"FLGBANCA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001A9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000001B8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"FLGBANCA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001C3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
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
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"kersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000023A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"priorita,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000250(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RWMACAGE,";
    p_cSql = p_cSql+"RWCODRAP,";
    p_cSql = p_cSql+"RWCODFIS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wurapporti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000252(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"MACODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000253(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"knarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000257(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000259(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000025D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RWMACAGE,";
    p_cSql = p_cSql+"RWCODRAP,";
    p_cSql = p_cSql+"RWCODFIS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wurapporti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000025F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"MACODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000260(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"knarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000264(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000266(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002D8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"id,";
    p_cSql = p_cSql+"account,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"DecodeStati",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002DD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ID,";
    p_cSql = p_cSql+"CITTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"DecodeCitta",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002E4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"id,";
    p_cSql = p_cSql+"account,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"DecodeStati",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000357(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"AGENTE,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"AGACCODE,";
    p_cSql = p_cSql+"CAB,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"IDCITTA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"TERMINALID,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anadip",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000388(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000038A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mlientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000038C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"meneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000038E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"merzistiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000390(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003A0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mogopefbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003A2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mlientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003A4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"meneficfrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003A6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"merzistifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003A8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003BE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003C3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xocopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003CC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003D1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"docopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003DC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003E1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xocfrabo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003EA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003EE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"docfrabo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003FC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000040C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"priorita,";
    p_cSql = p_cSql+"hyperlynk,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_listafile",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000041C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"priorita,";
    p_cSql = p_cSql+"hyperlynk,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_listafile",true);
    return p_cSql;
  }
}
