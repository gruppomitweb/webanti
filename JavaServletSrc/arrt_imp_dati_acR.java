// * --- Area Manuale = BO - Header
// * --- arrt_imp_dati_ac
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
// * --- Fine Area Manuale
public class arrt_imp_dati_acR implements CallerWithObjs {
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
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_wucodes;
  public String m_cServer_wucodes;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_docfrabo;
  public String m_cServer_docfrabo;
  public String m_cPhName_xocfrabo;
  public String m_cServer_xocfrabo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_kersonbo;
  public String m_cServer_kersonbo;
  public String m_cPhName_mtimport;
  public String m_cServer_mtimport;
  public String m_cPhName_mtimperr;
  public String m_cServer_mtimperr;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_mtstati;
  public String m_cServer_mtstati;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xocopebo;
  public String m_cServer_xocopebo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_docopebo;
  public String m_cServer_docopebo;
  public String m_cPhName_tmp_impwu;
  public String m_cServer_tmp_impwu;
  public String m_cPhName_wuchkimp;
  public String m_cServer_wuchkimp;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_wurapporti;
  public String m_cServer_wurapporti;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_decodestati;
  public String m_cServer_decodestati;
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
  public String w_opextc;
  public String w_codmage;
  public String w_destfin;
  public String w_xMAFLGRAP;
  public String w_xMAFLGBON;
  public String w_xMAFLGCKR;
  public String w_xMAFLGASR;
  public String w_xMADIPSTD;
  public String w_newrec;
  public String w_flgscad;
  public String w_fileage;
  public String fhand;
  public String _codrap;
  public String riga;
  public double nProg;
  public String nomefileimport;
  public String xConnes;
  public double conta;
  public String _tdest;
  public double _i;
  public double _pos;
  public double _npos;
  public String _tipoop;
  public String _riga1_2;
  public String _riga1_3;
  public String _coddip;
  public String _uniquecode;
  public String _riga1_5;
  public java.sql.Date _datope;
  public String _riga1_6;
  public String _riga1_7;
  public String _riga1_8;
  public String _impstr;
  public double _importo;
  public String _riga2_1;
  public String _riga2_2;
  public String _riga2_3;
  public String _riga2_4;
  public String _riga2_5;
  public String _riga2_6;
  public String _riga2_7;
  public String _riga2_8;
  public String _riga2_9;
  public String _riga2_10;
  public String _riga2_11;
  public String _riga2_12;
  public String _statodest;
  public String _isodest;
  public String _riga3_1;
  public String _cognome;
  public String _nome;
  public String _riga4_1;
  public String _riga4_2;
  public String _riga4_3;
  public String _riga4_4;
  public String _riga4_5;
  public String _riga4_6;
  public String _riga4_7;
  public String _citta;
  public String _cap;
  public String _via;
  public String _prov;
  public String _cab;
  public String _riga5_1;
  public String _cognomecp;
  public String _nomecp;
  public String _riga6_1;
  public String _riga6_2;
  public String _riga6_3;
  public String _riga6_4;
  public String _pep;
  public String _sesso;
  public String _nascitta;
  public String _nasstato;
  public String _resstato;
  public String _nasprov;
  public java.sql.Date _nasdata;
  public String _riga6_5;
  public String _riga6_6;
  public String _riga6_7;
  public String _riga6_8;
  public String _riga6_9;
  public String _riga6_10;
  public String _riga6_11;
  public String _riga7_1;
  public String _riga7_2;
  public String _riga7_3;
  public String _tipodoc;
  public String _numdoc;
  public String _riga7_4;
  public String _riga7_5;
  public java.sql.Date _docril;
  public String _autril;
  public String _riga7_6;
  public String _riga7_7;
  public String _riga7_8;
  public String _riga7_9;
  public String _riga8_1;
  public String _riga8_2;
  public String _riga8_3;
  public String _riga8_4;
  public String _riga8_5;
  public String _riga8_6;
  public String _riga8_7;
  public java.sql.Date _docsca;
  public String _codfis;
  public String _riga8_9;
  public String _riga9_1;
  public String _riga9_2;
  public String _riga9_3;
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
  public String _siglacit;
  public String _siglasta;
  public String _merr;
  public String _oldmac;
  public double _aggcli;
  public String _tiperr;
  public String _intertip;
  public String _listerr;
  public String _tipope;
  public String _rapporto;
  public String _codinter;
  public String _citinter;
  public String _cabinter;
  public String _prvinter;
  public String _citdip;
  public String _cabdip;
  public String _provdip;
  public String _flgcont;
  public String _numtel;
  public MemoryCursor_mcstringa_mcrdef mcListaAge;
  public String _codajw;
  public String _tipriga;
  public String _tplriga;
  public double foglio;
  public double riga_letta;
  public String _terminalid;
  public String _dip;
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
  // * --- Area Manuale = BO - Properties
  // * --- arrt_imp_dati_ac
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  public int _i1;
  public int _y;
  public int _righe;
  public int _conta;
  public int r;
  public int cell_count;
  String sheetName = "Foglio1";
  public String[] campi;
  public int nfogli;
  public int ncampi;
  public SXSSFWorkbook wb;
  public SXSSFSheet sheet;
  public Row row; 
  public Cell cell;
  public CellStyle cs;
  public Font f;
  public String[] colonna;
  // * --- Fine Area Manuale
  public arrt_imp_dati_acR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_imp_dati_ac",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_xraziobo = p_ContextObject.GetPhName("xraziobo");
    if (m_cPhName_xraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xraziobo = m_cPhName_xraziobo+" "+m_Ctx.GetWritePhName("xraziobo");
    }
    m_cServer_xraziobo = p_ContextObject.GetServer("xraziobo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_tbcauana = p_ContextObject.GetPhName("tbcauana");
    if (m_cPhName_tbcauana.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcauana = m_cPhName_tbcauana+" "+m_Ctx.GetWritePhName("tbcauana");
    }
    m_cServer_tbcauana = p_ContextObject.GetServer("tbcauana");
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
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
    m_cPhName_wucodes = p_ContextObject.GetPhName("wucodes");
    if (m_cPhName_wucodes.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wucodes = m_cPhName_wucodes+" "+m_Ctx.GetWritePhName("wucodes");
    }
    m_cServer_wucodes = p_ContextObject.GetServer("wucodes");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_docfrabo = p_ContextObject.GetPhName("docfrabo");
    if (m_cPhName_docfrabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_docfrabo = m_cPhName_docfrabo+" "+m_Ctx.GetWritePhName("docfrabo");
    }
    m_cServer_docfrabo = p_ContextObject.GetServer("docfrabo");
    m_cPhName_xocfrabo = p_ContextObject.GetPhName("xocfrabo");
    if (m_cPhName_xocfrabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xocfrabo = m_cPhName_xocfrabo+" "+m_Ctx.GetWritePhName("xocfrabo");
    }
    m_cServer_xocfrabo = p_ContextObject.GetServer("xocfrabo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_kersonbo = p_ContextObject.GetPhName("kersonbo");
    if (m_cPhName_kersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_kersonbo = m_cPhName_kersonbo+" "+m_Ctx.GetWritePhName("kersonbo");
    }
    m_cServer_kersonbo = p_ContextObject.GetServer("kersonbo");
    m_cPhName_mtimport = p_ContextObject.GetPhName("mtimport");
    if (m_cPhName_mtimport.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mtimport = m_cPhName_mtimport+" "+m_Ctx.GetWritePhName("mtimport");
    }
    m_cServer_mtimport = p_ContextObject.GetServer("mtimport");
    m_cPhName_mtimperr = p_ContextObject.GetPhName("mtimperr");
    if (m_cPhName_mtimperr.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mtimperr = m_cPhName_mtimperr+" "+m_Ctx.GetWritePhName("mtimperr");
    }
    m_cServer_mtimperr = p_ContextObject.GetServer("mtimperr");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_mtstati = p_ContextObject.GetPhName("mtstati");
    if (m_cPhName_mtstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mtstati = m_cPhName_mtstati+" "+m_Ctx.GetWritePhName("mtstati");
    }
    m_cServer_mtstati = p_ContextObject.GetServer("mtstati");
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    if (m_cPhName_xperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo = m_cPhName_xperazbo+" "+m_Ctx.GetWritePhName("xperazbo");
    }
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_xocopebo = p_ContextObject.GetPhName("xocopebo");
    if (m_cPhName_xocopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xocopebo = m_cPhName_xocopebo+" "+m_Ctx.GetWritePhName("xocopebo");
    }
    m_cServer_xocopebo = p_ContextObject.GetServer("xocopebo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_docopebo = p_ContextObject.GetPhName("docopebo");
    if (m_cPhName_docopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_docopebo = m_cPhName_docopebo+" "+m_Ctx.GetWritePhName("docopebo");
    }
    m_cServer_docopebo = p_ContextObject.GetServer("docopebo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_impwu")) {
      m_cPhName_tmp_impwu = p_ContextObject.GetPhName("tmp_impwu");
      if (m_cPhName_tmp_impwu.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_impwu = m_cPhName_tmp_impwu+" "+m_Ctx.GetWritePhName("tmp_impwu");
      }
      m_cServer_tmp_impwu = p_ContextObject.GetServer("tmp_impwu");
    }
    m_cPhName_wuchkimp = p_ContextObject.GetPhName("wuchkimp");
    if (m_cPhName_wuchkimp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wuchkimp = m_cPhName_wuchkimp+" "+m_Ctx.GetWritePhName("wuchkimp");
    }
    m_cServer_wuchkimp = p_ContextObject.GetServer("wuchkimp");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_wurapporti = p_ContextObject.GetPhName("wurapporti");
    if (m_cPhName_wurapporti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wurapporti = m_cPhName_wurapporti+" "+m_Ctx.GetWritePhName("wurapporti");
    }
    m_cServer_wurapporti = p_ContextObject.GetServer("wurapporti");
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    if (m_cPhName_knarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_knarapbo = m_cPhName_knarapbo+" "+m_Ctx.GetWritePhName("knarapbo");
    }
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
    m_cPhName_decodestati = p_ContextObject.GetPhName("decodestati");
    if (m_cPhName_decodestati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_decodestati = m_cPhName_decodestati+" "+m_Ctx.GetWritePhName("decodestati");
    }
    m_cServer_decodestati = p_ContextObject.GetServer("decodestati");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("impzip",p_cVarName)) {
      return w_impzip;
    }
    if (CPLib.eqr("nProg",p_cVarName)) {
      return nProg;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      return _i;
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
    if (CPLib.eqr("foglio",p_cVarName)) {
      return foglio;
    }
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      return riga_letta;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_imp_dati_ac";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("tipodest",p_cVarName)) {
      return w_tipodest;
    }
    if (CPLib.eqr("opextc",p_cVarName)) {
      return w_opextc;
    }
    if (CPLib.eqr("codmage",p_cVarName)) {
      return w_codmage;
    }
    if (CPLib.eqr("destfin",p_cVarName)) {
      return w_destfin;
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
    if (CPLib.eqr("newrec",p_cVarName)) {
      return w_newrec;
    }
    if (CPLib.eqr("flgscad",p_cVarName)) {
      return w_flgscad;
    }
    if (CPLib.eqr("fileage",p_cVarName)) {
      return w_fileage;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_codrap",p_cVarName)) {
      return _codrap;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
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
    if (CPLib.eqr("_riga1_2",p_cVarName)) {
      return _riga1_2;
    }
    if (CPLib.eqr("_riga1_3",p_cVarName)) {
      return _riga1_3;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      return _coddip;
    }
    if (CPLib.eqr("_uniquecode",p_cVarName)) {
      return _uniquecode;
    }
    if (CPLib.eqr("_riga1_5",p_cVarName)) {
      return _riga1_5;
    }
    if (CPLib.eqr("_riga1_6",p_cVarName)) {
      return _riga1_6;
    }
    if (CPLib.eqr("_riga1_7",p_cVarName)) {
      return _riga1_7;
    }
    if (CPLib.eqr("_riga1_8",p_cVarName)) {
      return _riga1_8;
    }
    if (CPLib.eqr("_impstr",p_cVarName)) {
      return _impstr;
    }
    if (CPLib.eqr("_riga2_1",p_cVarName)) {
      return _riga2_1;
    }
    if (CPLib.eqr("_riga2_2",p_cVarName)) {
      return _riga2_2;
    }
    if (CPLib.eqr("_riga2_3",p_cVarName)) {
      return _riga2_3;
    }
    if (CPLib.eqr("_riga2_4",p_cVarName)) {
      return _riga2_4;
    }
    if (CPLib.eqr("_riga2_5",p_cVarName)) {
      return _riga2_5;
    }
    if (CPLib.eqr("_riga2_6",p_cVarName)) {
      return _riga2_6;
    }
    if (CPLib.eqr("_riga2_7",p_cVarName)) {
      return _riga2_7;
    }
    if (CPLib.eqr("_riga2_8",p_cVarName)) {
      return _riga2_8;
    }
    if (CPLib.eqr("_riga2_9",p_cVarName)) {
      return _riga2_9;
    }
    if (CPLib.eqr("_riga2_10",p_cVarName)) {
      return _riga2_10;
    }
    if (CPLib.eqr("_riga2_11",p_cVarName)) {
      return _riga2_11;
    }
    if (CPLib.eqr("_riga2_12",p_cVarName)) {
      return _riga2_12;
    }
    if (CPLib.eqr("_statodest",p_cVarName)) {
      return _statodest;
    }
    if (CPLib.eqr("_isodest",p_cVarName)) {
      return _isodest;
    }
    if (CPLib.eqr("_riga3_1",p_cVarName)) {
      return _riga3_1;
    }
    if (CPLib.eqr("_cognome",p_cVarName)) {
      return _cognome;
    }
    if (CPLib.eqr("_nome",p_cVarName)) {
      return _nome;
    }
    if (CPLib.eqr("_riga4_1",p_cVarName)) {
      return _riga4_1;
    }
    if (CPLib.eqr("_riga4_2",p_cVarName)) {
      return _riga4_2;
    }
    if (CPLib.eqr("_riga4_3",p_cVarName)) {
      return _riga4_3;
    }
    if (CPLib.eqr("_riga4_4",p_cVarName)) {
      return _riga4_4;
    }
    if (CPLib.eqr("_riga4_5",p_cVarName)) {
      return _riga4_5;
    }
    if (CPLib.eqr("_riga4_6",p_cVarName)) {
      return _riga4_6;
    }
    if (CPLib.eqr("_riga4_7",p_cVarName)) {
      return _riga4_7;
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
    if (CPLib.eqr("_prov",p_cVarName)) {
      return _prov;
    }
    if (CPLib.eqr("_cab",p_cVarName)) {
      return _cab;
    }
    if (CPLib.eqr("_riga5_1",p_cVarName)) {
      return _riga5_1;
    }
    if (CPLib.eqr("_cognomecp",p_cVarName)) {
      return _cognomecp;
    }
    if (CPLib.eqr("_nomecp",p_cVarName)) {
      return _nomecp;
    }
    if (CPLib.eqr("_riga6_1",p_cVarName)) {
      return _riga6_1;
    }
    if (CPLib.eqr("_riga6_2",p_cVarName)) {
      return _riga6_2;
    }
    if (CPLib.eqr("_riga6_3",p_cVarName)) {
      return _riga6_3;
    }
    if (CPLib.eqr("_riga6_4",p_cVarName)) {
      return _riga6_4;
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
    if (CPLib.eqr("_riga6_5",p_cVarName)) {
      return _riga6_5;
    }
    if (CPLib.eqr("_riga6_6",p_cVarName)) {
      return _riga6_6;
    }
    if (CPLib.eqr("_riga6_7",p_cVarName)) {
      return _riga6_7;
    }
    if (CPLib.eqr("_riga6_8",p_cVarName)) {
      return _riga6_8;
    }
    if (CPLib.eqr("_riga6_9",p_cVarName)) {
      return _riga6_9;
    }
    if (CPLib.eqr("_riga6_10",p_cVarName)) {
      return _riga6_10;
    }
    if (CPLib.eqr("_riga6_11",p_cVarName)) {
      return _riga6_11;
    }
    if (CPLib.eqr("_riga7_1",p_cVarName)) {
      return _riga7_1;
    }
    if (CPLib.eqr("_riga7_2",p_cVarName)) {
      return _riga7_2;
    }
    if (CPLib.eqr("_riga7_3",p_cVarName)) {
      return _riga7_3;
    }
    if (CPLib.eqr("_tipodoc",p_cVarName)) {
      return _tipodoc;
    }
    if (CPLib.eqr("_numdoc",p_cVarName)) {
      return _numdoc;
    }
    if (CPLib.eqr("_riga7_4",p_cVarName)) {
      return _riga7_4;
    }
    if (CPLib.eqr("_riga7_5",p_cVarName)) {
      return _riga7_5;
    }
    if (CPLib.eqr("_autril",p_cVarName)) {
      return _autril;
    }
    if (CPLib.eqr("_riga7_6",p_cVarName)) {
      return _riga7_6;
    }
    if (CPLib.eqr("_riga7_7",p_cVarName)) {
      return _riga7_7;
    }
    if (CPLib.eqr("_riga7_8",p_cVarName)) {
      return _riga7_8;
    }
    if (CPLib.eqr("_riga7_9",p_cVarName)) {
      return _riga7_9;
    }
    if (CPLib.eqr("_riga8_1",p_cVarName)) {
      return _riga8_1;
    }
    if (CPLib.eqr("_riga8_2",p_cVarName)) {
      return _riga8_2;
    }
    if (CPLib.eqr("_riga8_3",p_cVarName)) {
      return _riga8_3;
    }
    if (CPLib.eqr("_riga8_4",p_cVarName)) {
      return _riga8_4;
    }
    if (CPLib.eqr("_riga8_5",p_cVarName)) {
      return _riga8_5;
    }
    if (CPLib.eqr("_riga8_6",p_cVarName)) {
      return _riga8_6;
    }
    if (CPLib.eqr("_riga8_7",p_cVarName)) {
      return _riga8_7;
    }
    if (CPLib.eqr("_codfis",p_cVarName)) {
      return _codfis;
    }
    if (CPLib.eqr("_riga8_9",p_cVarName)) {
      return _riga8_9;
    }
    if (CPLib.eqr("_riga9_1",p_cVarName)) {
      return _riga9_1;
    }
    if (CPLib.eqr("_riga9_2",p_cVarName)) {
      return _riga9_2;
    }
    if (CPLib.eqr("_riga9_3",p_cVarName)) {
      return _riga9_3;
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
    if (CPLib.eqr("_siglacit",p_cVarName)) {
      return _siglacit;
    }
    if (CPLib.eqr("_siglasta",p_cVarName)) {
      return _siglasta;
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
    if (CPLib.eqr("_codinter",p_cVarName)) {
      return _codinter;
    }
    if (CPLib.eqr("_citinter",p_cVarName)) {
      return _citinter;
    }
    if (CPLib.eqr("_cabinter",p_cVarName)) {
      return _cabinter;
    }
    if (CPLib.eqr("_prvinter",p_cVarName)) {
      return _prvinter;
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
    if (CPLib.eqr("_flgcont",p_cVarName)) {
      return _flgcont;
    }
    if (CPLib.eqr("_numtel",p_cVarName)) {
      return _numtel;
    }
    if (CPLib.eqr("_codajw",p_cVarName)) {
      return _codajw;
    }
    if (CPLib.eqr("_tipriga",p_cVarName)) {
      return _tipriga;
    }
    if (CPLib.eqr("_tplriga",p_cVarName)) {
      return _tplriga;
    }
    if (CPLib.eqr("_terminalid",p_cVarName)) {
      return _terminalid;
    }
    if (CPLib.eqr("_dip",p_cVarName)) {
      return _dip;
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
    if (CPLib.eqr("mcListaAge",p_cVarName)) {
      return mcListaAge;
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
    if (CPLib.eqr("impzip",p_cVarName)) {
      w_impzip = value;
      return;
    }
    if (CPLib.eqr("nProg",p_cVarName)) {
      nProg = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      _i = value;
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
    if (CPLib.eqr("foglio",p_cVarName)) {
      foglio = value;
      return;
    }
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      riga_letta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tipodest",p_cVarName)) {
      w_tipodest = value;
      return;
    }
    if (CPLib.eqr("opextc",p_cVarName)) {
      w_opextc = value;
      return;
    }
    if (CPLib.eqr("codmage",p_cVarName)) {
      w_codmage = value;
      return;
    }
    if (CPLib.eqr("destfin",p_cVarName)) {
      w_destfin = value;
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
    if (CPLib.eqr("newrec",p_cVarName)) {
      w_newrec = value;
      return;
    }
    if (CPLib.eqr("flgscad",p_cVarName)) {
      w_flgscad = value;
      return;
    }
    if (CPLib.eqr("fileage",p_cVarName)) {
      w_fileage = value;
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
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
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
    if (CPLib.eqr("_riga1_2",p_cVarName)) {
      _riga1_2 = value;
      return;
    }
    if (CPLib.eqr("_riga1_3",p_cVarName)) {
      _riga1_3 = value;
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
    if (CPLib.eqr("_riga1_5",p_cVarName)) {
      _riga1_5 = value;
      return;
    }
    if (CPLib.eqr("_riga1_6",p_cVarName)) {
      _riga1_6 = value;
      return;
    }
    if (CPLib.eqr("_riga1_7",p_cVarName)) {
      _riga1_7 = value;
      return;
    }
    if (CPLib.eqr("_riga1_8",p_cVarName)) {
      _riga1_8 = value;
      return;
    }
    if (CPLib.eqr("_impstr",p_cVarName)) {
      _impstr = value;
      return;
    }
    if (CPLib.eqr("_riga2_1",p_cVarName)) {
      _riga2_1 = value;
      return;
    }
    if (CPLib.eqr("_riga2_2",p_cVarName)) {
      _riga2_2 = value;
      return;
    }
    if (CPLib.eqr("_riga2_3",p_cVarName)) {
      _riga2_3 = value;
      return;
    }
    if (CPLib.eqr("_riga2_4",p_cVarName)) {
      _riga2_4 = value;
      return;
    }
    if (CPLib.eqr("_riga2_5",p_cVarName)) {
      _riga2_5 = value;
      return;
    }
    if (CPLib.eqr("_riga2_6",p_cVarName)) {
      _riga2_6 = value;
      return;
    }
    if (CPLib.eqr("_riga2_7",p_cVarName)) {
      _riga2_7 = value;
      return;
    }
    if (CPLib.eqr("_riga2_8",p_cVarName)) {
      _riga2_8 = value;
      return;
    }
    if (CPLib.eqr("_riga2_9",p_cVarName)) {
      _riga2_9 = value;
      return;
    }
    if (CPLib.eqr("_riga2_10",p_cVarName)) {
      _riga2_10 = value;
      return;
    }
    if (CPLib.eqr("_riga2_11",p_cVarName)) {
      _riga2_11 = value;
      return;
    }
    if (CPLib.eqr("_riga2_12",p_cVarName)) {
      _riga2_12 = value;
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
    if (CPLib.eqr("_riga3_1",p_cVarName)) {
      _riga3_1 = value;
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
    if (CPLib.eqr("_riga4_1",p_cVarName)) {
      _riga4_1 = value;
      return;
    }
    if (CPLib.eqr("_riga4_2",p_cVarName)) {
      _riga4_2 = value;
      return;
    }
    if (CPLib.eqr("_riga4_3",p_cVarName)) {
      _riga4_3 = value;
      return;
    }
    if (CPLib.eqr("_riga4_4",p_cVarName)) {
      _riga4_4 = value;
      return;
    }
    if (CPLib.eqr("_riga4_5",p_cVarName)) {
      _riga4_5 = value;
      return;
    }
    if (CPLib.eqr("_riga4_6",p_cVarName)) {
      _riga4_6 = value;
      return;
    }
    if (CPLib.eqr("_riga4_7",p_cVarName)) {
      _riga4_7 = value;
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
    if (CPLib.eqr("_prov",p_cVarName)) {
      _prov = value;
      return;
    }
    if (CPLib.eqr("_cab",p_cVarName)) {
      _cab = value;
      return;
    }
    if (CPLib.eqr("_riga5_1",p_cVarName)) {
      _riga5_1 = value;
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
    if (CPLib.eqr("_riga6_1",p_cVarName)) {
      _riga6_1 = value;
      return;
    }
    if (CPLib.eqr("_riga6_2",p_cVarName)) {
      _riga6_2 = value;
      return;
    }
    if (CPLib.eqr("_riga6_3",p_cVarName)) {
      _riga6_3 = value;
      return;
    }
    if (CPLib.eqr("_riga6_4",p_cVarName)) {
      _riga6_4 = value;
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
    if (CPLib.eqr("_riga6_5",p_cVarName)) {
      _riga6_5 = value;
      return;
    }
    if (CPLib.eqr("_riga6_6",p_cVarName)) {
      _riga6_6 = value;
      return;
    }
    if (CPLib.eqr("_riga6_7",p_cVarName)) {
      _riga6_7 = value;
      return;
    }
    if (CPLib.eqr("_riga6_8",p_cVarName)) {
      _riga6_8 = value;
      return;
    }
    if (CPLib.eqr("_riga6_9",p_cVarName)) {
      _riga6_9 = value;
      return;
    }
    if (CPLib.eqr("_riga6_10",p_cVarName)) {
      _riga6_10 = value;
      return;
    }
    if (CPLib.eqr("_riga6_11",p_cVarName)) {
      _riga6_11 = value;
      return;
    }
    if (CPLib.eqr("_riga7_1",p_cVarName)) {
      _riga7_1 = value;
      return;
    }
    if (CPLib.eqr("_riga7_2",p_cVarName)) {
      _riga7_2 = value;
      return;
    }
    if (CPLib.eqr("_riga7_3",p_cVarName)) {
      _riga7_3 = value;
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
    if (CPLib.eqr("_riga7_4",p_cVarName)) {
      _riga7_4 = value;
      return;
    }
    if (CPLib.eqr("_riga7_5",p_cVarName)) {
      _riga7_5 = value;
      return;
    }
    if (CPLib.eqr("_autril",p_cVarName)) {
      _autril = value;
      return;
    }
    if (CPLib.eqr("_riga7_6",p_cVarName)) {
      _riga7_6 = value;
      return;
    }
    if (CPLib.eqr("_riga7_7",p_cVarName)) {
      _riga7_7 = value;
      return;
    }
    if (CPLib.eqr("_riga7_8",p_cVarName)) {
      _riga7_8 = value;
      return;
    }
    if (CPLib.eqr("_riga7_9",p_cVarName)) {
      _riga7_9 = value;
      return;
    }
    if (CPLib.eqr("_riga8_1",p_cVarName)) {
      _riga8_1 = value;
      return;
    }
    if (CPLib.eqr("_riga8_2",p_cVarName)) {
      _riga8_2 = value;
      return;
    }
    if (CPLib.eqr("_riga8_3",p_cVarName)) {
      _riga8_3 = value;
      return;
    }
    if (CPLib.eqr("_riga8_4",p_cVarName)) {
      _riga8_4 = value;
      return;
    }
    if (CPLib.eqr("_riga8_5",p_cVarName)) {
      _riga8_5 = value;
      return;
    }
    if (CPLib.eqr("_riga8_6",p_cVarName)) {
      _riga8_6 = value;
      return;
    }
    if (CPLib.eqr("_riga8_7",p_cVarName)) {
      _riga8_7 = value;
      return;
    }
    if (CPLib.eqr("_codfis",p_cVarName)) {
      _codfis = value;
      return;
    }
    if (CPLib.eqr("_riga8_9",p_cVarName)) {
      _riga8_9 = value;
      return;
    }
    if (CPLib.eqr("_riga9_1",p_cVarName)) {
      _riga9_1 = value;
      return;
    }
    if (CPLib.eqr("_riga9_2",p_cVarName)) {
      _riga9_2 = value;
      return;
    }
    if (CPLib.eqr("_riga9_3",p_cVarName)) {
      _riga9_3 = value;
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
    if (CPLib.eqr("_siglacit",p_cVarName)) {
      _siglacit = value;
      return;
    }
    if (CPLib.eqr("_siglasta",p_cVarName)) {
      _siglasta = value;
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
    if (CPLib.eqr("_codinter",p_cVarName)) {
      _codinter = value;
      return;
    }
    if (CPLib.eqr("_citinter",p_cVarName)) {
      _citinter = value;
      return;
    }
    if (CPLib.eqr("_cabinter",p_cVarName)) {
      _cabinter = value;
      return;
    }
    if (CPLib.eqr("_prvinter",p_cVarName)) {
      _prvinter = value;
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
    if (CPLib.eqr("_flgcont",p_cVarName)) {
      _flgcont = value;
      return;
    }
    if (CPLib.eqr("_numtel",p_cVarName)) {
      _numtel = value;
      return;
    }
    if (CPLib.eqr("_codajw",p_cVarName)) {
      _codajw = value;
      return;
    }
    if (CPLib.eqr("_tipriga",p_cVarName)) {
      _tipriga = value;
      return;
    }
    if (CPLib.eqr("_tplriga",p_cVarName)) {
      _tplriga = value;
      return;
    }
    if (CPLib.eqr("_terminalid",p_cVarName)) {
      _terminalid = value;
      return;
    }
    if (CPLib.eqr("_dip",p_cVarName)) {
      _dip = value;
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
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcListaAge",p_cVarName)) {
      mcListaAge = (MemoryCursor_mcstringa_mcrdef)value;
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
    CPResultSet Read_Cursor=null;
    try {
      /* Dichiarazione variabili del caller */
      /* w_tipodest Char(1) */
      /* w_impzip Numeric(1, 0) */
      /* w_opextc Char(1) */
      /* w_codmage Char(5) // Codice Macroagente */
      /* w_destfin Char(1) // Destinazione finale */
      /* w_xMAFLGRAP Char(1) */
      /* w_xMAFLGBON Char(1) */
      /* w_xMAFLGCKR Char(1) */
      /* w_xMAFLGASR Char(1) */
      /* w_xMADIPSTD Char(6) */
      /* w_newrec Char(1) */
      /* w_flgscad Char(1) */
      /* w_fileage Char(80) // Agenzie da filtrare */
      /* Definizione variabili locali */
      /* fhand Char(1) */
      /* _codrap Char(16) */
      /* riga Memo */
      /* nProg Numeric(10, 0) */
      /* nomefileimport Char(50) */
      /* xConnes Char(16) */
      /* conta Numeric(10, 0) */
      /* _tdest Char(1) */
      /* _i Numeric(1, 0) */
      /* _pos Numeric(3, 0) */
      /* _npos Numeric(1, 0) */
      /* _tipoop Char(1) */
      /* _riga1_2 Char(20) */
      /* _riga1_3 Char(20) */
      /* _coddip Char(6) */
      /* _uniquecode Char(10) */
      /* _riga1_5 Char(20) */
      /* _datope Date */
      /* _riga1_6 Char(20) */
      /* _riga1_7 Char(20) */
      /* _riga1_8 Char(20) */
      /* _impstr Char(20) */
      /* _importo Numeric(10, 2) */
      /* _riga2_1 Char(20) */
      /* _riga2_2 Char(20) */
      /* _riga2_3 Char(20) */
      /* _riga2_4 Char(20) */
      /* _riga2_5 Char(20) */
      /* _riga2_6 Char(20) */
      /* _riga2_7 Char(20) */
      /* _riga2_8 Char(20) */
      /* _riga2_9 Char(20) */
      /* _riga2_10 Char(20) */
      /* _riga2_11 Char(20) */
      /* _riga2_12 Char(20) */
      /* _statodest Char(3) */
      /* _isodest Char(3) */
      /* _riga3_1 Char(20) */
      /* _cognome Char(26) */
      /* _nome Char(25) */
      /* _riga4_1 Char(20) */
      /* _riga4_2 Char(20) */
      /* _riga4_3 Char(20) */
      /* _riga4_4 Char(20) */
      /* _riga4_5 Char(20) */
      /* _riga4_6 Char(20) */
      /* _riga4_7 Char(20) */
      /* _citta Char(40) */
      /* _cap Char(5) */
      /* _via Char(35) */
      /* _prov Char(2) */
      /* _cab Char(6) */
      /* _riga5_1 Char(20) */
      /* _cognomecp Char(26) */
      /* _nomecp Char(25) */
      /* _riga6_1 Char(20) */
      /* _riga6_2 Char(20) */
      /* _riga6_3 Char(20) */
      /* _riga6_4 Char(20) */
      /* _pep Char(1) */
      /* _sesso Char(1) */
      /* _nascitta Char(30) */
      /* _nasstato Char(30) */
      /* _resstato Char(3) */
      /* _nasprov Char(2) */
      /* _nasdata Date */
      /* _riga6_5 Char(20) */
      /* _riga6_6 Char(20) */
      /* _riga6_7 Char(20) */
      /* _riga6_8 Char(20) */
      /* _riga6_9 Char(20) */
      /* _riga6_10 Char(20) */
      /* _riga6_11 Char(20) */
      /* _riga7_1 Char(20) */
      /* _riga7_2 Char(20) */
      /* _riga7_3 Char(20) */
      /* _tipodoc Char(20) */
      /* _numdoc Char(20) */
      /* _riga7_4 Char(20) */
      /* _riga7_5 Char(20) */
      /* _docril Date */
      /* _autril Char(30) */
      /* _riga7_6 Char(20) */
      /* _riga7_7 Char(20) */
      /* _riga7_8 Char(20) */
      /* _riga7_9 Char(20) */
      /* _riga8_1 Char(20) */
      /* _riga8_2 Char(20) */
      /* _riga8_3 Char(20) */
      /* _riga8_4 Char(20) */
      /* _riga8_5 Char(20) */
      /* _riga8_6 Char(20) */
      /* _riga8_7 Char(20) */
      /* _docsca Date */
      /* _codfis Char(16) */
      /* _riga8_9 Char(20) */
      /* _riga9_1 Char(20) */
      /* _riga9_2 Char(20) */
      /* _riga9_3 Char(20) */
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
      /* _siglacit Char(4) */
      /* _siglasta Char(4) */
      /* _merr Char(100) */
      /* _oldmac Char(5) */
      /* _aggcli Numeric(1, 0) */
      /* _tiperr Char(2) */
      /* _intertip Char(2) */
      /* _listerr Memo */
      /* _tipope Char(2) */
      /* _rapporto Char(25) */
      /* _codinter Char(11) */
      /* _citinter Char(30) */
      /* _cabinter Char(6) */
      /* _prvinter Char(2) */
      /* _citdip Char(30) */
      /* _cabdip Char(6) */
      /* _provdip Char(2) */
      /* _flgcont Char(1) */
      /* _numtel Char(20) */
      /* mcListaAge MemoryCursor(mcStringa.MCRDef) */
      /* _codajw Char(10) */
      /* _tipriga Char(1) */
      /* _tplriga Char(8) */
      /* foglio Numeric(2, 0) // foglio letto */
      /* riga_letta Numeric(9, 0) // riga letta del file Excel */
      /* _terminalid Char(4) */
      /* _dip Char(6) */
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
      /* If not(Empty(LRTrim(w_fileage))) */
      if ( ! (CPLib.Empty(CPLib.LRTrim(w_fileage)))) {
        /* Exec "Legge file Excel Agenzie" Page 12:Page_12 */
        Page_12();
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
        // * --- Read from mtimport
        m_cServer = m_Ctx.GetServer("mtimport");
        m_cPhName = m_Ctx.GetPhName("mtimport");
        m_cSql = "";
        m_cSql = m_cSql+"MTCODMAGE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codmage,"C",5,0,m_cServer),m_cServer,w_codmage);
        m_cSql = m_cSql+" and MTNOMFIL="+CPSql.SQLValueAdapter(CPLib.ToSQL(nomefileimport,"C",60,0,m_cServer),m_cServer,nomefileimport);
        if (m_Ctx.IsSharedTemp("mtimport")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("MTDATIMP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _dtimport = Read_Cursor.GetDateTime("MTDATIMP");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on mtimport into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _dtimport = CPLib.NullDateTime();
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(_dtimport) */
        if (CPLib.Empty(_dtimport)) {
          /* Case At('.AC',Upper(nomefileimport)) <> 0 */
          if (CPLib.ne(CPLib.At(".AC",CPLib.Upper(nomefileimport)),0)) {
            /* Exec "Legge le transazioni" Page 2:Page_2 */
            Page_2();
            /* Case At('.MD',Upper(nomefileimport)) <> 0 */
          } else if (CPLib.ne(CPLib.At(".MD",CPLib.Upper(nomefileimport)),0)) {
            /* Exec "Elabora il file MD" Page 3:Page_3 */
            Page_3();
          } // End Case
        } else { // Else
          /* gMsgProc := gMsgProc +"Il file "+LRTrim(nomefileimport)+" è già stato importato per il MacroAgente selezionato"+NL+"Ricreare il file e rieseguire l'import dei dati."+ NL */
          gMsgProc = gMsgProc+"Il file "+CPLib.LRTrim(nomefileimport)+" è già stato importato per il MacroAgente selezionato"+"\n"+"Ricreare il file e rieseguire l'import dei dati."+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        // * --- Delete from tmp_list_imprich
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000000E1")+"delete from "+m_oWrInfo.GetTableWriteName();
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
      /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Importazione dati terminata. Verificare esito' // Messaggio Import */
      gMsgImp = "Importazione dati terminata. Verificare esito";
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
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_opextrbo=null;
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
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibMit.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibMit.OpenRead("./appo/"+nomefileimport);
      /* Salta la prima riga in quanti dice solo cose di trasmissione */
      /* _idfile := LRTrim(w_codmage)+"-"+LRTrim(nomefileimport) */
      _idfile = CPLib.LRTrim(w_codmage)+"-"+CPLib.LRTrim(nomefileimport);
      /* riga := FileLibMit.ReadLine(fhand) */
      riga = FileLibMit.ReadLine(fhand);
      /* Legge il file */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry000000F1status;
      nTry000000F1status = m_Sql.GetTransactionStatus();
      String cTry000000F1msg;
      cTry000000F1msg = m_Sql.TransactionErrorMessage();
      try {
        /* While not(FileLibMit.Eof(fhand)) */
        while ( ! (FileLibMit.Eof(fhand))) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* _i := 1 */
          _i = CPLib.Round(1,0);
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
          /* _riga1_2 := '' */
          _riga1_2 = "";
          /* _riga1_3 := '' */
          _riga1_3 = "";
          /* _coddip := '' */
          _coddip = "";
          /* _uniquecode := '' */
          _uniquecode = "";
          /* _riga1_5 := '' */
          _riga1_5 = "";
          /* _datope := NullDate() */
          _datope = CPLib.NullDate();
          /* _riga1_6 := '' */
          _riga1_6 = "";
          /* _riga1_7 := '' */
          _riga1_7 = "";
          /* _riga1_8 := '' */
          _riga1_8 = "";
          /* _impstr := '' */
          _impstr = "";
          /* _importo := 0 */
          _importo = CPLib.Round(0,2);
          /* _riga2_1 := '' */
          _riga2_1 = "";
          /* _riga2_2 := '' */
          _riga2_2 = "";
          /* _riga2_3 := '' */
          _riga2_3 = "";
          /* _riga2_4 := '' */
          _riga2_4 = "";
          /* _riga2_5 := '' */
          _riga2_5 = "";
          /* _riga2_6 := '' */
          _riga2_6 = "";
          /* _riga2_7 := '' */
          _riga2_7 = "";
          /* _riga2_8 := '' */
          _riga2_8 = "";
          /* _riga2_9 := '' */
          _riga2_9 = "";
          /* _riga2_10 := '' */
          _riga2_10 = "";
          /* _riga2_11 := '' */
          _riga2_11 = "";
          /* _riga2_12 := '' */
          _riga2_12 = "";
          /* _statodest := '' */
          _statodest = "";
          /* _isodest := '' */
          _isodest = "";
          /* _riga3_1 := '' */
          _riga3_1 = "";
          /* _cognome := '' */
          _cognome = "";
          /* _nome := '' */
          _nome = "";
          /* _resstato := '' */
          _resstato = "";
          /* _riga4_1 := '' */
          _riga4_1 = "";
          /* _riga4_2 := '' */
          _riga4_2 = "";
          /* _riga4_3 := '' */
          _riga4_3 = "";
          /* _riga4_4 := '' */
          _riga4_4 = "";
          /* _riga4_5 := '' */
          _riga4_5 = "";
          /* _riga4_6 := '' */
          _riga4_6 = "";
          /* _riga4_7 := '' */
          _riga4_7 = "";
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
          /* _riga5_1 := '' */
          _riga5_1 = "";
          /* _cognomecp := '' */
          _cognomecp = "";
          /* _nomecp := '' */
          _nomecp = "";
          /* _riga6_1 := '' */
          _riga6_1 = "";
          /* _riga6_2 := '' */
          _riga6_2 = "";
          /* _riga6_3 := '' */
          _riga6_3 = "";
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
          /* _riga6_6 := '' */
          _riga6_6 = "";
          /* _riga6_7 := '' */
          _riga6_7 = "";
          /* _riga6_8 := '' */
          _riga6_8 = "";
          /* _riga7_1 := '' */
          _riga7_1 = "";
          /* _tipodoc := '' */
          _tipodoc = "";
          /* _numdoc := '' */
          _numdoc = "";
          /* _riga7_4 := '' */
          _riga7_4 = "";
          /* _docril := NullDate() */
          _docril = CPLib.NullDate();
          /* _autril := '' */
          _autril = "";
          /* _riga7_6 := '' */
          _riga7_6 = "";
          /* _riga7_7 := '' */
          _riga7_7 = "";
          /* _riga7_8 := '' */
          _riga7_8 = "";
          /* _riga8_1 := '' */
          _riga8_1 = "";
          /* _riga8_2 := '' */
          _riga8_2 = "";
          /* _riga8_3 := '' */
          _riga8_3 = "";
          /* _riga8_4 := '' */
          _riga8_4 = "";
          /* _riga8_5 := '' */
          _riga8_5 = "";
          /* _riga8_6 := '' */
          _riga8_6 = "";
          /* _riga8_7 := '' */
          _riga8_7 = "";
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
          /* _dip := '' */
          _dip = "";
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
          /* If Left(riga,1) = 'S' or Left(riga,1)='P' */
          if (CPLib.eqr(CPLib.Left(riga,1),"S") || CPLib.eqr(CPLib.Left(riga,1),"P")) {
            /* _tipriga := Left(riga,1) */
            _tipriga = CPLib.Left(riga,1);
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            /* If Left(riga,1)='S' */
            if (CPLib.eqr(CPLib.Left(riga,1),"S")) {
              /* _txtope := _txtope + riga */
              _txtope = _txtope+riga;
              /* _i := _i + 1 */
              _i = CPLib.Round(_i+1,0);
              /* _npos := 1 */
              _npos = CPLib.Round(1,0);
              /* _tipoop := 'S' */
              _tipoop = "S";
              /* While Len(LRTrim(riga)) > 0 */
              while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
                /* _pos := At(';',riga) */
                _pos = CPLib.Round(CPLib.At(";",riga),0);
                /* Case _npos = 1 */
                if (CPLib.eqr(_npos,1)) {
                  /* Case _npos = 2 */
                } else if (CPLib.eqr(_npos,2)) {
                  /* _riga1_2 := Left(riga,_pos - 1) */
                  _riga1_2 = CPLib.Left(riga,_pos-1);
                  /* _codajw := LRTrim(_riga1_2) */
                  _codajw = CPLib.LRTrim(_riga1_2);
                  /* _coddip := iif(Empty(LRTrim(Substr(LRTrim(_riga1_2),4,6))),w_xMADIPSTD,Substr(LRTrim(_riga1_2),4,6)) */
                  _coddip = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(CPLib.LRTrim(_riga1_2),4,6)))?w_xMADIPSTD:CPLib.Substr(CPLib.LRTrim(_riga1_2),4,6));
                  /* Case _npos = 3 */
                } else if (CPLib.eqr(_npos,3)) {
                  /* _riga1_3 := Left(riga,_pos - 1) */
                  _riga1_3 = CPLib.Left(riga,_pos-1);
                  /* _terminalid := LRTrim(Left(riga,_pos - 1)) */
                  _terminalid = CPLib.LRTrim(CPLib.Left(riga,_pos-1));
                  /* Case _npos = 4 */
                } else if (CPLib.eqr(_npos,4)) {
                  /* _uniquecode := LRTrim(Left(riga,_pos - 1)) */
                  _uniquecode = CPLib.LRTrim(CPLib.Left(riga,_pos-1));
                  /* Case _npos = 5 */
                } else if (CPLib.eqr(_npos,5)) {
                  /* _riga1_5 := Left(riga,_pos - 1) */
                  _riga1_5 = CPLib.Left(riga,_pos-1);
                  /* _datope := CharToDate(Substr(_riga1_5,5,4)+Left(_riga1_5,2)+Substr(_riga1_5,3,2)) */
                  _datope = CPLib.CharToDate(CPLib.Substr(_riga1_5,5,4)+CPLib.Left(_riga1_5,2)+CPLib.Substr(_riga1_5,3,2));
                  /* Case _npos = 6 */
                } else if (CPLib.eqr(_npos,6)) {
                  /* _riga1_6 := Left(riga,_pos - 1) */
                  _riga1_6 = CPLib.Left(riga,_pos-1);
                  /* Case _npos = 7 */
                } else if (CPLib.eqr(_npos,7)) {
                  /* _riga1_7 := LRTrim(riga) */
                  _riga1_7 = CPLib.LRTrim(riga);
                } // End Case
                /* If _npos <= 6 */
                if (CPLib.le(_npos,6)) {
                  /* riga := Substr(riga,_pos + 1) */
                  riga = CPLib.Substr(riga,_pos+1);
                } else { // Else
                  /* riga := '' */
                  riga = "";
                } // End If
                /* _npos := _npos + 1 */
                _npos = CPLib.Round(_npos+1,0);
              } // End While
              /* riga := FileLibMit.ReadLine(fhand) */
              riga = FileLibMit.ReadLine(fhand);
              /* _txtope := _txtope + riga */
              _txtope = _txtope+riga;
              /* If Empty(w_fileage) */
              if (CPLib.Empty(w_fileage)) {
                /* If Right(LRTrim(riga),6)='ITE_04' */
                if (CPLib.eqr(CPLib.Right(CPLib.LRTrim(riga),6),"ITE_04")) {
                  /* Exec "ITE_4 - TIPO S" Page 6:Page_6 */
                  Page_6();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* ElseIf Right(LRTrim(riga),6)='ITE_05' */
                } else if (CPLib.eqr(CPLib.Right(CPLib.LRTrim(riga),6),"ITE_05")) {
                  /* Exec "ITE_5 - TIPO S" Page 7:Page_7 */
                  Page_7();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* ElseIf Right(LRTrim(riga),8)='UNI_0106' */
                } else if (CPLib.eqr(CPLib.Right(CPLib.LRTrim(riga),8),"UNI_0106")) {
                  /* _tplriga := 'UNI_0106' */
                  _tplriga = "UNI_0106";
                  /* Exec "Salta le righe" Page 13:Page_13 */
                  Page_13();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* _esito := -1 */
                  _esito = CPLib.Round(-1,0);
                } // End If
                /* ElseIf mcListaAge.GoToKey(_codajw) */
              } else if (mcListaAge.GoToKey(_codajw)) {
                /* If Right(LRTrim(riga),6)='ITE_04' */
                if (CPLib.eqr(CPLib.Right(CPLib.LRTrim(riga),6),"ITE_04")) {
                  /* _tplriga := 'ITE_04' */
                  _tplriga = "ITE_04";
                  /* Exec "Salta le righe" Page 13:Page_13 */
                  Page_13();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* _esito := -1 */
                  _esito = CPLib.Round(-1,0);
                  /* ElseIf Right(LRTrim(riga),6)='ITE_05' */
                } else if (CPLib.eqr(CPLib.Right(CPLib.LRTrim(riga),6),"ITE_05")) {
                  /* _tplriga := 'ITE_05' */
                  _tplriga = "ITE_05";
                  /* Exec "Salta le righe" Page 13:Page_13 */
                  Page_13();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* _esito := -1 */
                  _esito = CPLib.Round(-1,0);
                  /* ElseIf Right(LRTrim(riga),8)='UNI_0106' */
                } else if (CPLib.eqr(CPLib.Right(CPLib.LRTrim(riga),8),"UNI_0106")) {
                  /* Exec "UNI - TIPO S" Page 10:Page_10 */
                  Page_10();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
              } else { // Else
                /* If Right(LRTrim(riga),6)='ITE_04' */
                if (CPLib.eqr(CPLib.Right(CPLib.LRTrim(riga),6),"ITE_04")) {
                  /* _tplriga := 'ITE_04' */
                  _tplriga = "ITE_04";
                  /* ElseIf Right(LRTrim(riga),6)='ITE_05' */
                } else if (CPLib.eqr(CPLib.Right(CPLib.LRTrim(riga),6),"ITE_05")) {
                  /* _tplriga := 'ITE_05' */
                  _tplriga = "ITE_05";
                  /* ElseIf Right(LRTrim(riga),8)='UNI_0106' */
                } else if (CPLib.eqr(CPLib.Right(CPLib.LRTrim(riga),8),"UNI_0106")) {
                  /* _tplriga := 'UNI_0106' */
                  _tplriga = "UNI_0106";
                } // End If
                /* Exec "Salta le righe" Page 13:Page_13 */
                Page_13();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* _esito := -1 */
                _esito = CPLib.Round(-1,0);
              } // End If
              /* ElseIf Left(riga,1)='P' */
            } else if (CPLib.eqr(CPLib.Left(riga,1),"P")) {
              /* _txtope := _txtope + riga */
              _txtope = _txtope+riga;
              /* _i := _i + 1 */
              _i = CPLib.Round(_i+1,0);
              /* _npos := 1 */
              _npos = CPLib.Round(1,0);
              /* _tipoop := 'P' */
              _tipoop = "P";
              /* While Len(LRTrim(riga)) > 0 */
              while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
                /* _pos := At(';',riga) */
                _pos = CPLib.Round(CPLib.At(";",riga),0);
                /* Case _npos = 1 */
                if (CPLib.eqr(_npos,1)) {
                  /* Case _npos = 2 */
                } else if (CPLib.eqr(_npos,2)) {
                  /* _riga1_2 := Left(riga,_pos - 1) */
                  _riga1_2 = CPLib.Left(riga,_pos-1);
                  /* _codajw := LRTrim(_riga1_2) */
                  _codajw = CPLib.LRTrim(_riga1_2);
                  /* _coddip := iif(Empty(LRTrim(Substr(LRTrim(_riga1_2),4,6))),w_xMADIPSTD,Substr(LRTrim(_riga1_2),4,6)) */
                  _coddip = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(CPLib.LRTrim(_riga1_2),4,6)))?w_xMADIPSTD:CPLib.Substr(CPLib.LRTrim(_riga1_2),4,6));
                  /* Case _npos = 3 */
                } else if (CPLib.eqr(_npos,3)) {
                  /* _riga1_3 := Left(riga,_pos - 1) */
                  _riga1_3 = CPLib.Left(riga,_pos-1);
                  /* _terminalid := LRTrim(Left(riga,_pos - 1)) */
                  _terminalid = CPLib.LRTrim(CPLib.Left(riga,_pos-1));
                  /* Case _npos = 4 */
                } else if (CPLib.eqr(_npos,4)) {
                  /* _uniquecode := LRTrim(Left(riga,_pos - 1)) */
                  _uniquecode = CPLib.LRTrim(CPLib.Left(riga,_pos-1));
                  /* Case _npos = 5 */
                } else if (CPLib.eqr(_npos,5)) {
                  /* _riga1_5 := Left(riga,_pos - 1) */
                  _riga1_5 = CPLib.Left(riga,_pos-1);
                  /* _datope := CharToDate(Substr(_riga1_5,5,4)+Left(_riga1_5,2)+Substr(_riga1_5,3,2)) */
                  _datope = CPLib.CharToDate(CPLib.Substr(_riga1_5,5,4)+CPLib.Left(_riga1_5,2)+CPLib.Substr(_riga1_5,3,2));
                  /* Case _npos = 6 */
                } else if (CPLib.eqr(_npos,6)) {
                  /* _riga1_6 := Left(riga,_pos - 1) */
                  _riga1_6 = CPLib.Left(riga,_pos-1);
                  /* Case _npos = 7 */
                } else if (CPLib.eqr(_npos,7)) {
                  /* _riga1_7 := Left(riga,_pos - 1) */
                  _riga1_7 = CPLib.Left(riga,_pos-1);
                  /* Case _npos = 8 */
                } else if (CPLib.eqr(_npos,8)) {
                  /* _riga1_8 := LRTrim(riga) */
                  _riga1_8 = CPLib.LRTrim(riga);
                } // End Case
                /* If _npos <= 7 */
                if (CPLib.le(_npos,7)) {
                  /* riga := Substr(riga,_pos + 1) */
                  riga = CPLib.Substr(riga,_pos+1);
                } else { // Else
                  /* riga := '' */
                  riga = "";
                } // End If
                /* _npos := _npos + 1 */
                _npos = CPLib.Round(_npos+1,0);
              } // End While
              /* riga := FileLibMit.ReadLine(fhand) */
              riga = FileLibMit.ReadLine(fhand);
              /* _txtope := _txtope + riga */
              _txtope = _txtope+riga;
              /* If Empty(w_fileage) */
              if (CPLib.Empty(w_fileage)) {
                /* If Right(LRTrim(riga),6)='ITE_04' */
                if (CPLib.eqr(CPLib.Right(CPLib.LRTrim(riga),6),"ITE_04")) {
                  /* Exec "ITE_4 - TIPO P" Page 8:Page_8 */
                  Page_8();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* ElseIf Right(LRTrim(riga),6)='ITE_05' */
                } else if (CPLib.eqr(CPLib.Right(CPLib.LRTrim(riga),6),"ITE_05")) {
                  /* Exec "ITE_5 - TIPO P" Page 9:Page_9 */
                  Page_9();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* ElseIf Right(LRTrim(riga),8)='UNI_0106' */
                } else if (CPLib.eqr(CPLib.Right(CPLib.LRTrim(riga),8),"UNI_0106")) {
                  /* _tplriga := 'UNI_0106' */
                  _tplriga = "UNI_0106";
                  /* Exec "Salta le righe" Page 13:Page_13 */
                  Page_13();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* _esito := -1 */
                  _esito = CPLib.Round(-1,0);
                } // End If
                /* ElseIf mcListaAge.GoToKey(_codajw) */
              } else if (mcListaAge.GoToKey(_codajw)) {
                /* If Right(LRTrim(riga),6)='ITE_04' */
                if (CPLib.eqr(CPLib.Right(CPLib.LRTrim(riga),6),"ITE_04")) {
                  /* _tplriga := 'ITE_04' */
                  _tplriga = "ITE_04";
                  /* Exec "Salta le righe" Page 13:Page_13 */
                  Page_13();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* _esito := -1 */
                  _esito = CPLib.Round(-1,0);
                  /* ElseIf Right(LRTrim(riga),6)='ITE_05' */
                } else if (CPLib.eqr(CPLib.Right(CPLib.LRTrim(riga),6),"ITE_05")) {
                  /* _tplriga := 'ITE_05' */
                  _tplriga = "ITE_05";
                  /* Exec "Salta le righe" Page 13:Page_13 */
                  Page_13();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* _esito := -1 */
                  _esito = CPLib.Round(-1,0);
                  /* ElseIf Right(LRTrim(riga),8)='UNI_0106' */
                } else if (CPLib.eqr(CPLib.Right(CPLib.LRTrim(riga),8),"UNI_0106")) {
                  /* Exec "UNI - TIPO P" Page 11:Page_11 */
                  Page_11();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
              } else { // Else
                /* If Right(LRTrim(riga),6)='ITE_04' */
                if (CPLib.eqr(CPLib.Right(CPLib.LRTrim(riga),6),"ITE_04")) {
                  /* _tplriga := 'ITE_04' */
                  _tplriga = "ITE_04";
                  /* ElseIf Right(LRTrim(riga),6)='ITE_05' */
                } else if (CPLib.eqr(CPLib.Right(CPLib.LRTrim(riga),6),"ITE_05")) {
                  /* _tplriga := 'ITE_05' */
                  _tplriga = "ITE_05";
                  /* ElseIf Right(LRTrim(riga),8)='UNI_0106' */
                } else if (CPLib.eqr(CPLib.Right(CPLib.LRTrim(riga),8),"UNI_0106")) {
                  /* _tplriga := 'UNI_0106' */
                  _tplriga = "UNI_0106";
                } // End If
                /* Exec "Salta le righe" Page 13:Page_13 */
                Page_13();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* _esito := -1 */
                _esito = CPLib.Round(-1,0);
              } // End If
            } // End If
            /* If _esito <> - 1 */
            if (CPLib.ne(_esito,-1)) {
              /* Exec "Controllo dati" Page 5:Page_5 */
              Page_5();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
            } // End If
            /* If _esito = 0 */
            if (CPLib.eqr(_esito,0)) {
              /* _connes := '' */
              _connes = "";
              /* If Substr(_codfis,12,1)='Z' */
              if (CPLib.eqr(CPLib.Substr(_codfis,12,1),"Z")) {
                /* _nasprov := 'EE' */
                _nasprov = "EE";
              } else { // Else
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
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _nasprov = Read_Cursor.GetString("PROV");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
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
              /* _prov := '' */
              _prov = "";
              /* _cab := '' */
              _cab = "";
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
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROV",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _prov = Read_Cursor.GetString("PROV");
                _cab = Read_Cursor.GetString("CAB");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _prov = "";
                _cab = "";
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
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000001C9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000001C9(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_codfis,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),70),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_via,35),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_codfis,"?",0,0,m_cServer)+", ";
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
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_sesso,"M")?"1":"2"),"?",0,0,m_cServer)+", ";
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
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_xMAFLGRAP,"S")?"086":_resstato),"?",0,0,m_cServer)+", ";
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
                    Error l_oErrorFault = new Error("Read on kersonbo into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000001D2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000001D2(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),70),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_via,35),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codfis,"?",0,0,m_cServer)+", ";
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
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_sesso,"M")?"1":"2"),"?",0,0,m_cServer)+", ";
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
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_xMAFLGRAP,"S")?"086":_resstato),"?",0,0,m_cServer)+", ";
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000001D8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL((CPLib.eqr(_sesso,"M")?"1":"2"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(_docsca,"D",8,0)+", ";
                  m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Left(_cognome,26),"C",26,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Left(_nome,25),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Left(_nasprov,2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.Left(_nasstato,30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ALLINEATONOMECNOME = "+CPLib.ToSQL(0,"N",1,0)+", ";
                  m_cSql = m_cSql+"PEP = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"IDFILE = "+CPLib.ToSQL(_idfile,"C",60,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL((CPLib.eqr(w_xMAFLGRAP,"S")?"086":_resstato),"C",3,0,m_cServer)+", ";
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
                /* If w_opextc='S' */
                if (CPLib.eqr(w_opextc,"S")) {
                  /* _prog := Utilities.GetAutonumber("PRGAEOPEXTR\'"+LRTrim(gAzienda)+"'",'',10) */
                  _prog = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAEOPEXTR\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                  // * --- Insert into aeoprig from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aeoprig");
                  m_cPhName = m_Ctx.GetPhName("aeoprig");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000001E0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000001E0(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("98","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeoprig",true);
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
                  // * --- Insert into opextrbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("opextrbo");
                  m_cPhName = m_Ctx.GetPhName("opextrbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000001E1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000001E1(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Str(CPLib.Year(_datope),4,0),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
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
                    throw new RoutineException();
                  }
                } // End If
              } else { // Else
                /* _aggcli := 0 */
                _aggcli = CPLib.Round(0,0);
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
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000001F4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000001F4(m_Ctx,m_oWrInfo);
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
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000001FA")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL((CPLib.eqr(w_xMAFLGRAP,"S")?"086":_resstato),"C",3,0,m_cServer)+", ";
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
                    Error l_oErrorFault = new Error("Read on kersonbo into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"00000203")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000203(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),70),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_via,35),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codfis,"?",0,0,m_cServer)+", ";
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
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_sesso,"M")?"1":"2"),"?",0,0,m_cServer)+", ";
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
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_xMAFLGRAP,"S")?"086":_resstato),"?",0,0,m_cServer)+", ";
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
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"0000020A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL((CPLib.eqr(_sesso,"M")?"1":"2"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(_docsca,"D",8,0)+", ";
                    m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Left(_cognome,26),"C",26,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Left(_nome,25),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Left(_nasprov,2),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.Left(_nasstato,30),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"ALLINEATONOMECNOME = "+CPLib.ToSQL(0,"N",1,0)+", ";
                    m_cSql = m_cSql+"PEP = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"IDFILE = "+CPLib.ToSQL(_idfile,"C",60,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL((CPLib.eqr(w_xMAFLGRAP,"S")?"086":_resstato),"C",3,0,m_cServer)+", ";
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
                /* If w_opextc='S' */
                if (CPLib.eqr(w_opextc,"S")) {
                  /* _prog := '' */
                  _prog = "";
                  // * --- Select from opextrbo
                  m_cServer = m_Ctx.GetServer("opextrbo");
                  m_cPhName = m_Ctx.GetPhName("opextrbo");
                  if (Cursor_opextrbo!=null)
                    Cursor_opextrbo.Close();
                  Cursor_opextrbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select ANNO,IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("opextrbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_opextrbo.Eof())) {
                    /* If opextrbo->ANNO=Str(Year(_datope),4,0) */
                    if (CPLib.eqr(Cursor_opextrbo.GetString("ANNO"),CPLib.Str(CPLib.Year(_datope),4,0))) {
                      /* _prog := opextrbo->IDBASE */
                      _prog = Cursor_opextrbo.GetString("IDBASE");
                    } // End If
                    Cursor_opextrbo.Next();
                  }
                  m_cConnectivityError = Cursor_opextrbo.ErrorMessage();
                  Cursor_opextrbo.Close();
                  // * --- End Select
                  /* If Empty(LRTrim(_prog)) */
                  if (CPLib.Empty(CPLib.LRTrim(_prog))) {
                    /* _prog := Utilities.GetAutonumber("PRGAEOPEXTR\'"+LRTrim(gAzienda)+"'",'',10) */
                    _prog = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAEOPEXTR\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                    /* nProgImp := Utilities.GetAutonumber("PROGOPEX\'"+LRTrim(gAzienda)+"'",0,10) */
                    nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGOPEX\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
                    // * --- Insert into opextrbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("opextrbo");
                    m_cPhName = m_Ctx.GetPhName("opextrbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"00000218")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000218(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Str(CPLib.Year(_datope),4,0),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
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
                      throw new RoutineException();
                    }
                  } // End If
                } // End If
              } // End If
              /* _tipope := '10' */
              _tipope = "10";
              /* _flgcont := iif(w_xMAFLGBON='S','0','1') */
              _flgcont = (CPLib.eqr(w_xMAFLGBON,"S")?"0":"1");
              /* If _tipoop='P' */
              if (CPLib.eqr(_tipoop,"P")) {
                /* _codana := 'I8' */
                _codana = "I8";
                /* _codsin := '2M' */
                _codsin = "2M";
                /* _segno := 'A' */
                _segno = "A";
                /* ElseIf _tipoop='S' */
              } else if (CPLib.eqr(_tipoop,"S")) {
                /* _codana := 'I9' */
                _codana = "I9";
                /* _codsin := '1M' */
                _codsin = "1M";
                /* _segno := 'D' */
                _segno = "D";
              } // End If
              /* _citinter := '' */
              _citinter = "";
              /* _cabinter := '' */
              _cabinter = "";
              /* _prvinter := '' */
              _prvinter = "";
              /* _dip := '' */
              _dip = "";
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
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _citinter = Read_Cursor.GetString("DESCCIT");
                _prvinter = Read_Cursor.GetString("PROVINCIA");
                _cabinter = Read_Cursor.GetString("CAB");
                _dip = Read_Cursor.GetString("CODDIP");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _citinter = "";
                _prvinter = "";
                _cabinter = "";
                _dip = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_dip)) */
              if (CPLib.Empty(CPLib.LRTrim(_dip))) {
                // * --- Read from anadip
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_cSql = "";
                m_cSql = m_cSql+"TERMINALID="+CPSql.SQLValueAdapter(CPLib.ToSQL(_terminalid,"C",15,0,m_cServer),m_cServer,_terminalid);
                if (m_Ctx.IsSharedTemp("anadip")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _citinter = Read_Cursor.GetString("DESCCIT");
                  _prvinter = Read_Cursor.GetString("PROVINCIA");
                  _cabinter = Read_Cursor.GetString("CAB");
                  _dip = Read_Cursor.GetString("CODDIP");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _citinter = "";
                  _prvinter = "";
                  _cabinter = "";
                  _dip = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If Empty(LRTrim(_dip)) */
                if (CPLib.Empty(CPLib.LRTrim(_dip))) {
                  // * --- Read from anadip
                  m_cServer = m_Ctx.GetServer("anadip");
                  m_cPhName = m_Ctx.GetPhName("anadip");
                  m_cSql = "";
                  m_cSql = m_cSql+"AGACCODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codajw,"C",10,0,m_cServer),m_cServer,_codajw);
                  if (m_Ctx.IsSharedTemp("anadip")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _citinter = Read_Cursor.GetString("DESCCIT");
                    _prvinter = Read_Cursor.GetString("PROVINCIA");
                    _cabinter = Read_Cursor.GetString("CAB");
                    _dip = Read_Cursor.GetString("CODDIP");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _citinter = "";
                    _prvinter = "";
                    _cabinter = "";
                    _dip = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                } // End If
              } // End If
              /* _codrap := '' */
              _codrap = "";
              /* If w_xMAFLGRAP='S' */
              if (CPLib.eqr(w_xMAFLGRAP,"S")) {
                /* Exec "Crea Rapporti" Page 4:Page_4 */
                Page_4();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"00000238")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000238(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(_datope),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognomecp)+" "+CPLib.LRTrim(_nomecp),70),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_uifdest,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_cabinter))?_intercab:_cabinter),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_dip,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codfis,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_citinter))?CPLib.Left(_intercit,30):CPLib.Left(_citinter,30)),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_flgcont,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(_codrap)?"":"0"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cOpeProg2+"X","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_prvinter))?_interprv:_prvinter),"?",0,0,m_cServer)+", ";
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
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                  // * --- Insert into xocopebo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xocopebo");
                  m_cPhName = m_Ctx.GetPhName("xocopebo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xocopebo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"0000023E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000023E(m_Ctx,m_oWrInfo);
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
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"00000248")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000248(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(_datope),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognomecp)+" "+CPLib.LRTrim(_nomecp),70),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_uifdest,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_cabinter))?_intercab:_cabinter),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_dip,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codfis,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_citinter))?CPLib.Left(_intercit,30):CPLib.Left(_citinter,30)),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(_codrap)?"":"0"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_flgcont,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cOpeProg2+"X","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_prvinter))?_interprv:_prvinter),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_xMAFLGBON,"S")?0:_importo),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
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
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                  // * --- Insert into docopebo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("docopebo");
                  m_cPhName = m_Ctx.GetPhName("docopebo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"docopebo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"0000024E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000024E(m_Ctx,m_oWrInfo);
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
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"0000025A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000025A(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognomecp)+" "+CPLib.LRTrim(_nomecp),70),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_uifdest,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_dip,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codfis,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(_codrap)?"":"0"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_flgcont,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cOpeProg2+"X","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_xMAFLGBON,"S")?0:_importo),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_cabinter))?_intercab:_cabinter),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_citinter))?CPLib.Left(_intercit,30):CPLib.Left(_citinter,30)),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_prvinter))?_interprv:_prvinter),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(_datope),"?",0,0)+", ";
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
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                  // * --- Insert into xocfrabo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("xocfrabo");
                  m_cPhName = m_Ctx.GetPhName("xocfrabo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xocfrabo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"00000260")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000260(m_Ctx,m_oWrInfo);
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
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"0000026A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000026A(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognomecp)+" "+CPLib.LRTrim(_nomecp),70),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_uifdest,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(CPLib.Date()),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_dip,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codfis,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(w_codmage)+"_"+_codfis+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(_numdoc,15),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
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
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_xMAFLGBON,"S")?0:_importo),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_cabinter))?_intercab:_cabinter),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_citinter))?CPLib.Left(_intercit,30):CPLib.Left(_citinter,30)),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_prvinter))?_interprv:_prvinter),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(_datope),"?",0,0)+", ";
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
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                  // * --- Insert into docfrabo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("docfrabo");
                  m_cPhName = m_Ctx.GetPhName("docfrabo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"docfrabo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"00000270")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000270(m_Ctx,m_oWrInfo);
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
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } else if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                  /* If Empty(LRTrim(_tiperr)) */
                  if (CPLib.Empty(CPLib.LRTrim(_tiperr))) {
                    /* _tiperr := '+0' */
                    _tiperr = "+0";
                  } // End If
                } // End If
              } // End If
            } // End If
            /* If _esito=1 */
            if (CPLib.eqr(_esito,1)) {
              /* Scrive l'errore */
              /* nProg := Utilities.GetAutonumber("PRGWUCHKIMP\'"+LRTrim(gAzienda)+"'",0,10) */
              nProg = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGWUCHKIMP\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
              // * --- Insert into wuchkimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("wuchkimp");
              m_cPhName = m_Ctx.GetPhName("wuchkimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wuchkimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"0000027B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000027B(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProg,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nomefileimport),20),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_uniquecode),10),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_tipoop),1),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_coddip),6),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(arfn_fdateR.Make(m_Ctx,this).Run(_datope),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((_importo/100),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_statodest),3),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_nome),40),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognome),40),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_citta),40),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cap),5),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_via),60),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_nomecp),40),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognomecp),40),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_nascitta),40),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_nasstato),40),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(arfn_fdateR.Make(m_Ctx,this).Run(_nasdata),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_sesso),1),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_codfis),16),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_tipodoc),1),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_numdoc),25),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_autril),30),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(arfn_fdateR.Make(m_Ctx,this).Run(_docril),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(arfn_fdateR.Make(m_Ctx,this).Run(_docsca),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_tiperr),2),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_codmage,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_listerr,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_nocf,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_ocodfis,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wuchkimp",true);
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
              /* _nerrori := _nerrori + 1 */
              _nerrori = CPLib.Round(_nerrori+1,0);
              /* eProg := Utilities.GetAutonumber("PRGIMPERR\'"+LRTrim(gAzienda)+"'",0,10) */
              eProg = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPERR\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
              // * --- Insert into mtimperr from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("mtimperr");
              m_cPhName = m_Ctx.GetPhName("mtimperr");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mtimperr",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"0000027E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000027E(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(eProg,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_codmage,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_txtope,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_merr,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mtimperr",true);
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
            } // End If
            /* If _esito <> - 1 */
            if (CPLib.ne(_esito,-1)) {
              // * --- Insert into tmp_impwu from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_impwu");
              m_cPhName = m_Ctx.GetPhName("tmp_impwu");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_impwu",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"00000280")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000280(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),70),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tiperr,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_impwu",true);
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
            } // End If
            /* gMsgImp := 'Sono state elaborate '+LRTrim(Str(conta,10,0))+' informazioni del file '+nomefileimport // Messaggio Import */
            gMsgImp = "Sono state elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" informazioni del file "+nomefileimport;
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } // End If
        } // End While
        // * --- Insert into mtimport from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("mtimport");
        m_cPhName = m_Ctx.GetPhName("mtimport");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mtimport",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"00000282")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000282(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_codmage,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nomefileimport),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mtimport",true);
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000F1status,0)) {
          m_Sql.SetTransactionStatus(nTry000000F1status,cTry000000F1msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Informazioni Elaborate: '+LRTrim(Str(conta,10,0)) + ' dal file '+nomefileimport+NL */
      gMsgProc = gMsgProc+"Informazioni Elaborate: "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" dal file "+nomefileimport+"\n";
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
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_opextrbo!=null)
          Cursor_opextrbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    /* Elabora il file MD */
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"0000029E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000029E(m_Ctx,m_oWrInfo);
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000002A0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000002A0(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("99","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_codmage,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000002A1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000002A1(m_Ctx,m_oWrInfo);
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000002A5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000002A5(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(_dip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,169,50),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+"I"+LibreriaMit.UniqueId()+"X","?",0,0,m_cServer)+", ";
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000002A7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000002A7(m_Ctx,m_oWrInfo);
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000002AB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000002AB(m_Ctx,m_oWrInfo);
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000002AD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000002AD(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("99","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_codmage,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000002AE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000002AE(m_Ctx,m_oWrInfo);
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000002B2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000002B2(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(_dip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,169,50),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+"I"+LibreriaMit.UniqueId()+"X","?",0,0,m_cServer)+", ";
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000002B4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000002B4(m_Ctx,m_oWrInfo);
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000002B7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000002B8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000002BB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ac",768,"000002BC")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
    try {
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
          Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
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
        // * --- Read from anadip
        m_cServer = m_Ctx.GetServer("anadip");
        m_cPhName = m_Ctx.GetPhName("anadip");
        m_cSql = "";
        m_cSql = m_cSql+"TERMINALID="+CPSql.SQLValueAdapter(CPLib.ToSQL(_terminalid,"C",15,0,m_cServer),m_cServer,_terminalid);
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
            Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
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
        /* If Empty(_prog) */
        if (CPLib.Empty(_prog)) {
          // * --- Read from anadip
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          m_cSql = "";
          m_cSql = m_cSql+"AGACCODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codajw,"C",10,0,m_cServer),m_cServer,_codajw);
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
              Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
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
        } // End If
      } // End If
      // Cerca la dipendenza
      System.out.println("Codice: "+_coddip);
      System.out.println("Terminal: "+_terminalid);
      System.out.println("Trovato: "+_prog);
      /* If Empty(LRTrim(_prog)) */
      if (CPLib.Empty(CPLib.LRTrim(_prog))) {
        /* _tiperr := '*1' */
        _tiperr = "*1";
        /* _listerr := _listerr + "* Agenzia non ancora censita" + NL */
        _listerr = _listerr+"* Agenzia non ancora censita"+"\n";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
        /* ElseIf LRTrim(_mage) <> LRTrim(w_codmage) */
      } else if (CPLib.ne(CPLib.LRTrim(_mage),CPLib.LRTrim(w_codmage))) {
        /* _tiperr := '*2' */
        _tiperr = "*2";
        /* _listerr := _listerr + "* Agenzia collegata ad un altro MacroAgente" + NL */
        _listerr = _listerr+"* Agenzia collegata ad un altro MacroAgente"+"\n";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
      /* If Empty(_cabdip) */
      if (CPLib.Empty(_cabdip)) {
        /* _tiperr := '*1' */
        _tiperr = "*1";
        /* _listerr := _listerr + "* Agenzia priva di codice CAB" + NL */
        _listerr = _listerr+"* Agenzia priva di codice CAB"+"\n";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
      /* If Empty(_provdip) */
      if (CPLib.Empty(_provdip)) {
        /* _tiperr := '*1' */
        _tiperr = "*1";
        /* _listerr := _listerr + "* Agenzia priva di provincia" + NL */
        _listerr = _listerr+"* Agenzia priva di provincia"+"\n";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
      /* If Empty(_citdip) */
      if (CPLib.Empty(_citdip)) {
        /* _tiperr := '*1' */
        _tiperr = "*1";
        /* _listerr := _listerr + "* Agenzia priva di città" + NL */
        _listerr = _listerr+"* Agenzia priva di città"+"\n";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
      /* If Year(_datope) < 1900 */
      if (CPLib.lt(CPLib.Year(_datope),1900)) {
        /* _tiperr := '*3' */
        _tiperr = "*3";
        /* _listerr := _listerr + "* Data operazione non valida" + NL */
        _listerr = _listerr+"* Data operazione non valida"+"\n";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
      /* If Empty(_nasdata) */
      if (CPLib.Empty(_nasdata)) {
        /* _tiperr := '*A' */
        _tiperr = "*A";
        /* _listerr := _listerr + "* Data di nascita non presente" + NL */
        _listerr = _listerr+"* Data di nascita non presente"+"\n";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } else { // Else
        /* If Year(_nasdata) < 1900 */
        if (CPLib.lt(CPLib.Year(_nasdata),1900)) {
          /* _tiperr := '*4' */
          _tiperr = "*4";
          /* _listerr := _listerr + "* Data di nascita errata" + NL */
          _listerr = _listerr+"* Data di nascita errata"+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
      } // End If
      /* If Empty(_docril) */
      if (CPLib.Empty(_docril)) {
        /* _tiperr := '*B' */
        _tiperr = "*B";
        /* _listerr := _listerr + "* Data di rilascio del documento assente" + NL */
        _listerr = _listerr+"* Data di rilascio del documento assente"+"\n";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } else { // Else
        /* If Year(_docril) < 1900 */
        if (CPLib.lt(CPLib.Year(_docril),1900)) {
          /* _tiperr := '*5' */
          _tiperr = "*5";
          /* _listerr := _listerr + "* Data di rilascio del documento errata" + NL */
          _listerr = _listerr+"* Data di rilascio del documento errata"+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If _docril > _datope */
        if (CPLib.gt(_docril,_datope)) {
          /* _tiperr := '*5' */
          _tiperr = "*5";
          /* _listerr := _listerr + "* Data di rilascio del documento superiore alla data operazione" + NL */
          _listerr = _listerr+"* Data di rilascio del documento superiore alla data operazione"+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
      } // End If
      /* If w_flgscad = 'N' */
      if (CPLib.eqr(w_flgscad,"N")) {
        /* If Empty(_docsca) */
        if (CPLib.Empty(_docsca)) {
          /* _tiperr := '*C' */
          _tiperr = "*C";
          /* _listerr := _listerr + "* Data di scadenza del documento assente" + NL */
          _listerr = _listerr+"* Data di scadenza del documento assente"+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } else { // Else
          /* If Year(_docsca) < 1900 */
          if (CPLib.lt(CPLib.Year(_docsca),1900)) {
            /* _tiperr := '*6' */
            _tiperr = "*6";
            /* _listerr := _listerr + "* Data di scadenza del documento errata" + NL */
            _listerr = _listerr+"* Data di scadenza del documento errata"+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
          /* If _datope > _docsca */
          if (CPLib.gt(_datope,_docsca)) {
            /* _tiperr := '*7' */
            _tiperr = "*7";
            /* _listerr := _listerr + "* Data di scadenza del documento inferiore alla data dell'operazione" + NL */
            _listerr = _listerr+"* Data di scadenza del documento inferiore alla data dell'operazione"+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
          /* If _docril > _docsca */
          if (CPLib.gt(_docril,_docsca)) {
            /* _tiperr := '*7' */
            _tiperr = "*7";
            /* _listerr := _listerr + "* Data di scadenza del documento inferiore alla data di rilascio" + NL */
            _listerr = _listerr+"* Data di scadenza del documento inferiore alla data di rilascio"+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
        } // End If
      } // End If
      /* If Empty(_sesso) */
      if (CPLib.Empty(_sesso)) {
        /* _tiperr := '*7' */
        _tiperr = "*7";
        /* _listerr := _listerr + "* Manca il genere della persona" + NL */
        _listerr = _listerr+"* Manca il genere della persona"+"\n";
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
      } // End If
      /* If w_xMAFLGCKR='S' */
      if (CPLib.eqr(w_xMAFLGCKR,"S")) {
        /* If Len(LRTrim(_codfis))=16 */
        if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_codfis)),16)) {
          /* _rapporto := '' */
          _rapporto = "";
          // * --- Read from knarapbo
          m_cServer = m_Ctx.GetServer("knarapbo");
          m_cPhName = m_Ctx.GetPhName("knarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_codfis),"C",25,0,m_cServer),m_cServer,CPLib.LRTrim(_codfis));
          if (m_Ctx.IsSharedTemp("knarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _rapporto = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on knarapbo into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
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
            /* _listerr := _listerr + "* Rapporto non esistente" + NL */
            _listerr = _listerr+"* Rapporto non esistente"+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
        } else { // Else
          /* _tiperr := '*1' */
          _tiperr = "*1";
          /* _listerr := _listerr + "* Codice Fiscale non valido" + NL */
          _listerr = _listerr+"* Codice Fiscale non valido"+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
      } // End If
      /* _nocf := 0 */
      _nocf = CPLib.Round(0,0);
      /* _errore := 0 */
      _errore = CPLib.Round(0,0);
      /* _merr := '' */
      _merr = "";
      /* If Empty(LRTrim(_codfis)) or Len(LRTrim(_codfis)) <> 16 */
      if (CPLib.Empty(CPLib.LRTrim(_codfis)) || CPLib.ne(CPLib.Len(CPLib.LRTrim(_codfis)),16)) {
        /* _oldcodfis := _codfis */
        _oldcodfis = _codfis;
        /* _nocf := 1 */
        _nocf = CPLib.Round(1,0);
        /* w_CODFISC := '' // Codice Fiscale */
        w_CODFISC = "";
        /* w_DATANASC := _nasdata // Data Nascita */
        w_DATANASC = _nasdata;
        /* w_NASCOMUN := _nascitta // Luogo di Nascita */
        w_NASCOMUN = _nascitta;
        /* w_NASSTATO := _nasstato // Stato di nascita */
        w_NASSTATO = _nasstato;
        /* _codstanas := '' */
        _codstanas = "";
        /* _siglacit := '' */
        _siglacit = "";
        /* _siglasta := '' */
        _siglasta = "";
        // * --- Read from mtstati
        m_cServer = m_Ctx.GetServer("mtstati");
        m_cPhName = m_Ctx.GetPhName("mtstati");
        m_cSql = "";
        m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(_nasstato),"C",40,0,m_cServer),m_cServer,CPLib.Upper(_nasstato));
        if (m_Ctx.IsSharedTemp("mtstati")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _codstanas = Read_Cursor.GetString("SIGLA");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on mtstati into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _codstanas = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(_codstanas)) */
        if (CPLib.Empty(CPLib.LRTrim(_codstanas))) {
          /* If Substr(_codfis,12,1)='Z' */
          if (CPLib.eqr(CPLib.Substr(_codfis,12,1),"Z")) {
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
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _nasstato = Read_Cursor.GetString("DESCRI");
              _siglasta = Read_Cursor.GetString("SIGLA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _nasstato = "";
              _siglasta = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* ElseIf not(Empty(Substr(_codfis,12,1))) and Substr(_codfis,12,1) <> 'Z' */
          } else if ( ! (CPLib.Empty(CPLib.Substr(_codfis,12,1))) && CPLib.ne(CPLib.Substr(_codfis,12,1),"Z")) {
            /* _nasstato := 'ITALIA' */
            _nasstato = "ITALIA";
          } // End If
          /* w_NASSTATO := _nasstato // Stato di nascita */
          w_NASSTATO = _nasstato;
        } // End If
        /* If not(Empty(w_NASSTATO)) and (Upper(LRTrim(w_NASSTATO)) = 'ITALIA' or Upper(LRTrim(w_NASSTATO))='ITALY') */
        if ( ! (CPLib.Empty(w_NASSTATO)) && (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(w_NASSTATO)),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(w_NASSTATO)),"ITALY"))) {
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
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _siglacit = Read_Cursor.GetString("SIGLA");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _siglacit = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
        } // End If
        /* If not(Empty(w_NASSTATO)) and Upper(LRTrim(w_NASSTATO)) <> 'ITALIA' and Upper(LRTrim(w_NASSTATO)) <> 'ITALY' */
        if ( ! (CPLib.Empty(w_NASSTATO)) && CPLib.ne(CPLib.Upper(CPLib.LRTrim(w_NASSTATO)),"ITALIA") && CPLib.ne(CPLib.Upper(CPLib.LRTrim(w_NASSTATO)),"ITALY")) {
          // * --- Read from tbstati
          m_cServer = m_Ctx.GetServer("tbstati");
          m_cPhName = m_Ctx.GetPhName("tbstati");
          m_cSql = "";
          m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nasstato,"C",40,0,m_cServer),m_cServer,_nasstato);
          if (m_Ctx.IsSharedTemp("tbstati")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _siglasta = Read_Cursor.GetString("SIGLA");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbstati into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _siglasta = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
        } // End If
        /* w_COGNOME := _cognome // Ragione Sociale */
        w_COGNOME = _cognome;
        /* w_RAGSOC := LRTrim(_cognome)+" "+LRTrim(_nome) // Ragione Sociale */
        w_RAGSOC = CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome);
        /* w_NOME := _nome // Ragione Sociale */
        w_NOME = _nome;
        /* w_SESSO := iif(_sesso='M','1',iif(_sesso='F','2',_sesso)) // Sesso */
        w_SESSO = (CPLib.eqr(_sesso,"M")?"1":(CPLib.eqr(_sesso,"F")?"2":_sesso));
        /* Exec Routine arrt_calccodfis_mt */
        arrt_calccodfis_mtR.Make(m_Ctx,this).Run();
        /* _codfis := w_CODFISC */
        _codfis = w_CODFISC;
        /* If Len(LRTrim(_codfis)) < 16 or not(arfn_poscodfis(_codfis)) */
        if (CPLib.lt(CPLib.Len(CPLib.LRTrim(_codfis)),16) ||  ! (arfn_poscodfisR.Make(m_Ctx,this).Run(_codfis))) {
          /* If Empty(_nascitta) */
          if (CPLib.Empty(_nascitta)) {
            /* _listerr := _listerr + "* Città di nascita mancante" + NL */
            _listerr = _listerr+"* Città di nascita mancante"+"\n";
          } // End If
          /* If (Upper(LRTrim(w_NASSTATO)) = 'ITALIA' or Upper(LRTrim(w_NASSTATO))='ITALY' or Empty(LRTrim(w_NASSTATO))) and Empty(_siglacit) */
          if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(w_NASSTATO)),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(w_NASSTATO)),"ITALY") || CPLib.Empty(CPLib.LRTrim(w_NASSTATO))) && CPLib.Empty(_siglacit)) {
            /* _listerr := _listerr + "* Città di nascita errata" + NL */
            _listerr = _listerr+"* Città di nascita errata"+"\n";
          } // End If
          /* If Empty(_nasstato) */
          if (CPLib.Empty(_nasstato)) {
            /* _listerr := _listerr + "* Stato di nascita mancante" + NL */
            _listerr = _listerr+"* Stato di nascita mancante"+"\n";
          } // End If
          /* If (Upper(LRTrim(w_NASSTATO)) <>  'ITALIA' and Upper(LRTrim(w_NASSTATO)) <> 'ITALY' and not(Empty(w_NASSTATO))) and Empty(_siglasta) */
          if ((CPLib.ne(CPLib.Upper(CPLib.LRTrim(w_NASSTATO)),"ITALIA") && CPLib.ne(CPLib.Upper(CPLib.LRTrim(w_NASSTATO)),"ITALY") &&  ! (CPLib.Empty(w_NASSTATO))) && CPLib.Empty(_siglasta)) {
            /* _listerr := _listerr + "* Stato di nascita errato" + NL */
            _listerr = _listerr+"* Stato di nascita errato"+"\n";
          } // End If
          /* _merr := 'Codice Fiscale Ricalcolato Errato - Probabili dati mancanti' */
          _merr = "Codice Fiscale Ricalcolato Errato - Probabili dati mancanti";
          /* _listerr := _listerr + "* Codice Fiscale Ricalcolato Errato - Probabili dati mancanti" + NL */
          _listerr = _listerr+"* Codice Fiscale Ricalcolato Errato - Probabili dati mancanti"+"\n";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          /* _tiperr := '*8' */
          _tiperr = "*8";
        } else { // Else
          /* _tiperr := '+1' */
          _tiperr = "+1";
        } // End If
        /* ElseIf Len(LRTrim(_codfis)) = 16 */
      } else if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_codfis)),16)) {
        /* If not(arfn_poscodfis(_codfis)) */
        if ( ! (arfn_poscodfisR.Make(m_Ctx,this).Run(_codfis))) {
          /* _oldcodfis := _codfis */
          _oldcodfis = _codfis;
          /* _nocf := 1 */
          _nocf = CPLib.Round(1,0);
          /* w_CODFISC := '' // Codice Fiscale */
          w_CODFISC = "";
          /* w_DATANASC := _nasdata // Data Nascita */
          w_DATANASC = _nasdata;
          /* w_NASCOMUN := _nascitta // Luogo di Nascita */
          w_NASCOMUN = _nascitta;
          /* w_NASSTATO := _nasstato // Stato di nascita */
          w_NASSTATO = _nasstato;
          /* _codstanas := '' */
          _codstanas = "";
          /* _siglacit := '' */
          _siglacit = "";
          /* _siglasta := '' */
          _siglasta = "";
          // * --- Read from mtstati
          m_cServer = m_Ctx.GetServer("mtstati");
          m_cPhName = m_Ctx.GetPhName("mtstati");
          m_cSql = "";
          m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(_nasstato),"C",40,0,m_cServer),m_cServer,CPLib.Upper(_nasstato));
          if (m_Ctx.IsSharedTemp("mtstati")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _codstanas = Read_Cursor.GetString("SIGLA");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on mtstati into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _codstanas = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_codstanas)) */
          if (CPLib.Empty(CPLib.LRTrim(_codstanas))) {
            /* If Substr(_codfis,12,1)='Z' */
            if (CPLib.eqr(CPLib.Substr(_codfis,12,1),"Z")) {
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
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _nasstato = Read_Cursor.GetString("DESCRI");
                _siglasta = Read_Cursor.GetString("SIGLA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstati into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _nasstato = "";
                _siglasta = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* ElseIf not(Empty(Substr(_codfis,12,1))) and Substr(_codfis,12,1) <> 'Z' */
            } else if ( ! (CPLib.Empty(CPLib.Substr(_codfis,12,1))) && CPLib.ne(CPLib.Substr(_codfis,12,1),"Z")) {
              /* _nasstato := 'ITALIA' */
              _nasstato = "ITALIA";
            } // End If
            /* w_NASSTATO := _nasstato // Stato di nascita */
            w_NASSTATO = _nasstato;
          } // End If
          /* If not(Empty(w_NASSTATO)) and (Upper(LRTrim(w_NASSTATO)) = 'ITALIA' or Upper(LRTrim(w_NASSTATO))='ITALY') */
          if ( ! (CPLib.Empty(w_NASSTATO)) && (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(w_NASSTATO)),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(w_NASSTATO)),"ITALY"))) {
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
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _siglacit = Read_Cursor.GetString("SIGLA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _siglacit = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* If not(Empty(w_NASSTATO)) and Upper(LRTrim(w_NASSTATO)) <> 'ITALIA' and Upper(LRTrim(w_NASSTATO)) <> 'ITALY' */
          if ( ! (CPLib.Empty(w_NASSTATO)) && CPLib.ne(CPLib.Upper(CPLib.LRTrim(w_NASSTATO)),"ITALIA") && CPLib.ne(CPLib.Upper(CPLib.LRTrim(w_NASSTATO)),"ITALY")) {
            // * --- Read from tbstati
            m_cServer = m_Ctx.GetServer("tbstati");
            m_cPhName = m_Ctx.GetPhName("tbstati");
            m_cSql = "";
            m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nasstato,"C",40,0,m_cServer),m_cServer,_nasstato);
            if (m_Ctx.IsSharedTemp("tbstati")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _siglasta = Read_Cursor.GetString("SIGLA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _siglasta = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* w_COGNOME := _cognome // Ragione Sociale */
          w_COGNOME = _cognome;
          /* w_RAGSOC := LRTrim(_cognome)+" "+LRTrim(_nome) // Ragione Sociale */
          w_RAGSOC = CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome);
          /* w_NOME := _nome // Ragione Sociale */
          w_NOME = _nome;
          /* w_SESSO := iif(_sesso='M','1',iif(_sesso='F','2',_sesso)) // Sesso */
          w_SESSO = (CPLib.eqr(_sesso,"M")?"1":(CPLib.eqr(_sesso,"F")?"2":_sesso));
          /* Exec Routine arrt_calccodfis_mt */
          arrt_calccodfis_mtR.Make(m_Ctx,this).Run();
          /* If Len(LRTrim(w_CODFISC)) < 16 or not(arfn_poscodfis(w_CODFISC)) */
          if (CPLib.lt(CPLib.Len(CPLib.LRTrim(w_CODFISC)),16) ||  ! (arfn_poscodfisR.Make(m_Ctx,this).Run(w_CODFISC))) {
            /* If Empty(_nascitta) */
            if (CPLib.Empty(_nascitta)) {
              /* _listerr := _listerr + "* Città di nascita mancante" + NL */
              _listerr = _listerr+"* Città di nascita mancante"+"\n";
            } // End If
            /* If (Upper(LRTrim(w_NASSTATO)) = 'ITALIA' or Upper(LRTrim(w_NASSTATO))='ITALY' or Empty(LRTrim(w_NASSTATO))) and Empty(_siglacit) */
            if ((CPLib.eqr(CPLib.Upper(CPLib.LRTrim(w_NASSTATO)),"ITALIA") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(w_NASSTATO)),"ITALY") || CPLib.Empty(CPLib.LRTrim(w_NASSTATO))) && CPLib.Empty(_siglacit)) {
              /* _listerr := _listerr + "* Città di nascita errata" + NL */
              _listerr = _listerr+"* Città di nascita errata"+"\n";
            } // End If
            /* If Empty(_nasstato) */
            if (CPLib.Empty(_nasstato)) {
              /* _listerr := _listerr + "* Stato di nascita mancante" + NL */
              _listerr = _listerr+"* Stato di nascita mancante"+"\n";
            } // End If
            /* If (Upper(LRTrim(w_NASSTATO)) <>  'ITALIA' and Upper(LRTrim(w_NASSTATO)) <> 'ITALY' and not(Empty(w_NASSTATO))) and Empty(_siglasta) */
            if ((CPLib.ne(CPLib.Upper(CPLib.LRTrim(w_NASSTATO)),"ITALIA") && CPLib.ne(CPLib.Upper(CPLib.LRTrim(w_NASSTATO)),"ITALY") &&  ! (CPLib.Empty(w_NASSTATO))) && CPLib.Empty(_siglasta)) {
              /* _listerr := _listerr + "* Stato di nascita errato" + NL */
              _listerr = _listerr+"* Stato di nascita errato"+"\n";
            } // End If
            /* _merr := 'Codice Fiscale Ricalcolato - Probabili dati anagrafici errati o mancanti' */
            _merr = "Codice Fiscale Ricalcolato - Probabili dati anagrafici errati o mancanti";
            /* _listerr := _listerr + "* Codice Fiscale Ricalcolato - Probabili dati anagrafici errati o mancanti" + NL */
            _listerr = _listerr+"* Codice Fiscale Ricalcolato - Probabili dati anagrafici errati o mancanti"+"\n";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            /* _tiperr := '*9' */
            _tiperr = "*9";
          } else { // Else
            /* _tiperr := '+1' */
            _tiperr = "+1";
          } // End If
        } else { // Else
          /* If Substr(_codfis,12,1)='Z' */
          if (CPLib.eqr(CPLib.Substr(_codfis,12,1),"Z")) {
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
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _nasstato = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } else { // Else
            /* _nasstato := 'ITALIA' */
            _nasstato = "ITALIA";
          } // End If
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
  void Page_6() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Template ITE_04 - Tipo S */
      /* While _i <= 7 */
      while (CPLib.le(_i,7)) {
        /* If _i > 2 */
        if (CPLib.gt(_i,2)) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* _txtope := _txtope + riga */
          _txtope = _txtope+riga;
        } // End If
        /* Case _i = 1 */
        if (CPLib.eqr(_i,1)) {
          /* Case _i = 2 */
        } else if (CPLib.eqr(_i,2)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga2_1 := Left(riga,_pos - 1) */
              _riga2_1 = CPLib.Left(riga,_pos-1);
              /* _impstr := LRTrim(Strtran(_riga2_1,'.','')) */
              _impstr = CPLib.LRTrim(CPLib.Strtran(_riga2_1,".",""));
              /* _importo := Val(_impstr) */
              _importo = CPLib.Round(CPLib.Val(_impstr),2);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _riga2_2 := Left(riga,_pos - 1) */
              _riga2_2 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _riga2_3 := Left(riga,_pos - 1) */
              _riga2_3 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _riga2_4 := Left(riga,_pos - 1) */
              _riga2_4 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _riga2_5 := Left(riga,_pos - 1) */
              _riga2_5 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _riga2_6 := Left(riga,_pos - 1) */
              _riga2_6 = CPLib.Left(riga,_pos-1);
              /* _statodest := LRTrim(_riga2_6) */
              _statodest = CPLib.LRTrim(_riga2_6);
              /* _uifdest := '' */
              _uifdest = "";
              // * --- Read from wucodes
              m_cServer = m_Ctx.GetServer("wucodes");
              m_cPhName = m_Ctx.GetPhName("wucodes");
              m_cSql = "";
              m_cSql = m_cSql+"WUCODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_statodest,"C",3,0,m_cServer),m_cServer,_statodest);
              if (m_Ctx.IsSharedTemp("wucodes")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("WUCODISO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("WUCODUIF",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _isodest = Read_Cursor.GetString("WUCODISO");
                _uifdest = Read_Cursor.GetString("WUCODUIF");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on wucodes into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _isodest = "";
                _uifdest = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _riga2_7 := LRTrim(riga) */
              _riga2_7 = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 6 */
            if (CPLib.le(_npos,6)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 3 */
        } else if (CPLib.eqr(_i,3)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga3_1 := Left(riga,_pos - 1) */
              _riga3_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _nome := Left(riga,_pos - 1) */
              _nome = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _cognome := LRTrim(riga) */
              _cognome = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 2 */
            if (CPLib.le(_npos,2)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 4 */
        } else if (CPLib.eqr(_i,4)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga4_1 := Left(riga,_pos - 1) */
              _riga4_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _citta := Left(riga,_pos - 1) */
              _citta = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _cap := Left(riga,_pos - 1) */
              _cap = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _via := LRTrim(riga) */
              _via = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 3 */
            if (CPLib.le(_npos,3)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 5 */
        } else if (CPLib.eqr(_i,5)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga5_1 := Left(riga,_pos - 1) */
              _riga5_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _nomecp := Left(riga,_pos - 1) */
              _nomecp = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _cognomecp := LRTrim(riga) */
              _cognomecp = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 2 */
            if (CPLib.le(_npos,2)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 6 */
        } else if (CPLib.eqr(_i,6)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga6_1 := Left(riga,_pos - 1) */
              _riga6_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _riga6_2 := Left(riga,_pos - 1) */
              _riga6_2 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _sesso := Left(riga,_pos - 1) */
              _sesso = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _nasstato := Left(riga,_pos - 1) */
              _nasstato = CPLib.Left(riga,_pos-1);
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _nascitta := Left(riga,_pos - 1) */
              _nascitta = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _riga6_6 := Left(riga,_pos - 1) */
              _riga6_6 = CPLib.Left(riga,_pos-1);
              /* If At('/',LRTrim(_riga6_6)) <> 0 or At('-',LRTrim(_riga6_6)) <> 0 */
              if (CPLib.ne(CPLib.At("/",CPLib.LRTrim(_riga6_6)),0) || CPLib.ne(CPLib.At("-",CPLib.LRTrim(_riga6_6)),0)) {
                /* _nasdata := CharToDate(Substr(_riga6_6,7,4)+Substr(_riga6_6,4,2)+Left(_riga6_6,2)) */
                _nasdata = CPLib.CharToDate(CPLib.Substr(_riga6_6,7,4)+CPLib.Substr(_riga6_6,4,2)+CPLib.Left(_riga6_6,2));
              } else { // Else
                /* _nasdata := CharToDate(Substr(_riga6_6,5,4)+Substr(_riga6_6,3,2)+Left(_riga6_6,2)) */
                _nasdata = CPLib.CharToDate(CPLib.Substr(_riga6_6,5,4)+CPLib.Substr(_riga6_6,3,2)+CPLib.Left(_riga6_6,2));
              } // End If
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _riga6_7 := Left(riga,_pos - 1) */
              _riga6_7 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 8 */
            } else if (CPLib.eqr(_npos,8)) {
              /* _riga6_8 := LRTrim(riga) */
              _riga6_8 = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 7 */
            if (CPLib.le(_npos,7)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 7 */
        } else if (CPLib.eqr(_i,7)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga7_1 := Left(riga,_pos - 1) */
              _riga7_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _tipodoc := Left(riga,_pos - 1) */
              _tipodoc = CPLib.Left(riga,_pos-1);
              /* Case LRTrim(_tipodoc)='A' */
              if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"A")) {
                /* _doctype := '03' */
                _doctype = "03";
                /* Case LRTrim(_tipodoc)='B' or LRTrim(_tipodoc)='F' */
              } else if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"B") || CPLib.eqr(CPLib.LRTrim(_tipodoc),"F")) {
                /* _doctype := '01' */
                _doctype = "01";
                /* Case LRTrim(_tipodoc)='C' */
              } else if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"C")) {
                /* _doctype := '02' */
                _doctype = "02";
                /* Case LRTrim(_tipodoc)='I' */
              } else if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"I")) {
                /* _doctype := '04' */
                _doctype = "04";
              } else { // Otherwise
                /* _doctype := '06' */
                _doctype = "06";
              } // End Case
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _numdoc := Left(riga,_pos - 1) */
              _numdoc = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _riga7_4 := Left(riga,_pos - 1) */
              _riga7_4 = CPLib.Left(riga,_pos-1);
              /* _docril := CharToDate(Substr(_riga7_4,5,4)+Substr(_riga7_4,3,2)+Left(_riga7_4,2)) */
              _docril = CPLib.CharToDate(CPLib.Substr(_riga7_4,5,4)+CPLib.Substr(_riga7_4,3,2)+CPLib.Left(_riga7_4,2));
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _autril := Left(riga,_pos - 1) */
              _autril = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _riga7_6 := Left(riga,_pos - 1) */
              _riga7_6 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _riga7_7 := Left(riga,_pos - 1) */
              _riga7_7 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 8 */
            } else if (CPLib.eqr(_npos,8)) {
              /* _riga7_8 := Left(riga,_pos - 1) */
              _riga7_8 = CPLib.Left(riga,_pos-1);
              /* _docsca := iif((Empty(LRTrim(_riga7_8)) or _riga7_8='01010001'),NullDate(),CharToDate(Substr(_riga7_8,5,4)+Substr(_riga7_8,3,2)+Left(_riga7_8,2))) */
              _docsca = ((CPLib.Empty(CPLib.LRTrim(_riga7_8)) || CPLib.eqr(_riga7_8,"01010001"))?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(_riga7_8,5,4)+CPLib.Substr(_riga7_8,3,2)+CPLib.Left(_riga7_8,2)));
              /* Case _npos = 9 */
            } else if (CPLib.eqr(_npos,9)) {
              /* _codfis := LRTrim(riga) */
              _codfis = CPLib.LRTrim(riga);
              /* _ocodfis := _codfis */
              _ocodfis = _codfis;
            } // End Case
            /* If _npos <= 8 */
            if (CPLib.le(_npos,8)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
        } // End Case
        /* _i := _i + 1 */
        _i = CPLib.Round(_i+1,0);
      } // End While
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
    CPResultSet Read_Cursor=null;
    try {
      /* Template ITE_05 - Tipo S */
      /* While _i <= 9 */
      while (CPLib.le(_i,9)) {
        /* If _i > 2 */
        if (CPLib.gt(_i,2)) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* _txtope := _txtope + riga */
          _txtope = _txtope+riga;
        } // End If
        /* Case _i = 1 */
        if (CPLib.eqr(_i,1)) {
          /* Case _i = 2 */
        } else if (CPLib.eqr(_i,2)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga2_1 := Left(riga,_pos - 1) */
              _riga2_1 = CPLib.Left(riga,_pos-1);
              /* _impstr := LRTrim(Strtran(_riga2_1,'.','')) */
              _impstr = CPLib.LRTrim(CPLib.Strtran(_riga2_1,".",""));
              /* _importo := Val(_impstr) */
              _importo = CPLib.Round(CPLib.Val(_impstr),2);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _riga2_2 := Left(riga,_pos - 1) */
              _riga2_2 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _riga2_3 := Left(riga,_pos - 1) */
              _riga2_3 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _riga2_4 := Left(riga,_pos - 1) */
              _riga2_4 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _riga2_5 := Left(riga,_pos - 1) */
              _riga2_5 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _riga2_6 := Left(riga,_pos - 1) */
              _riga2_6 = CPLib.Left(riga,_pos-1);
              /* _statodest := LRTrim(_riga2_6) */
              _statodest = CPLib.LRTrim(_riga2_6);
              /* _uifdest := '' */
              _uifdest = "";
              // * --- Read from wucodes
              m_cServer = m_Ctx.GetServer("wucodes");
              m_cPhName = m_Ctx.GetPhName("wucodes");
              m_cSql = "";
              m_cSql = m_cSql+"WUCODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_statodest,"C",3,0,m_cServer),m_cServer,_statodest);
              if (m_Ctx.IsSharedTemp("wucodes")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("WUCODISO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("WUCODUIF",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _isodest = Read_Cursor.GetString("WUCODISO");
                _uifdest = Read_Cursor.GetString("WUCODUIF");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on wucodes into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _isodest = "";
                _uifdest = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _riga2_7 := LRTrim(riga) */
              _riga2_7 = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 6 */
            if (CPLib.le(_npos,6)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 3 */
        } else if (CPLib.eqr(_i,3)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga3_1 := Left(riga,_pos - 1) */
              _riga3_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _nome := Left(riga,_pos - 1) */
              _nome = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _cognome := LRTrim(riga) */
              _cognome = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 2 */
            if (CPLib.le(_npos,2)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 4 */
        } else if (CPLib.eqr(_i,4)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga4_1 := Left(riga,_pos - 1) */
              _riga4_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _citta := Left(riga,_pos - 1) */
              _citta = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _cap := Left(riga,_pos - 1) */
              _cap = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _via := LRTrim(riga) */
              _via = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 3 */
            if (CPLib.le(_npos,3)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 5 */
        } else if (CPLib.eqr(_i,5)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga5_1 := Left(riga,_pos - 1) */
              _riga5_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _nomecp := Left(riga,_pos - 1) */
              _nomecp = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _cognomecp := LRTrim(riga) */
              _cognomecp = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 2 */
            if (CPLib.le(_npos,2)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 6 */
        } else if (CPLib.eqr(_i,6)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga6_1 := Left(riga,_pos - 1) */
              _riga6_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _riga6_2 := Left(riga,_pos - 1) */
              _riga6_2 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _riga6_3 := Left(riga,_pos - 1) */
              _riga6_3 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _tipodoc := Left(riga,_pos - 1) */
              _tipodoc = CPLib.Left(riga,_pos-1);
              /* Case LRTrim(_tipodoc)='A' */
              if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"A")) {
                /* _doctype := '03' */
                _doctype = "03";
                /* Case LRTrim(_tipodoc)='B' or LRTrim(_tipodoc)='F' */
              } else if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"B") || CPLib.eqr(CPLib.LRTrim(_tipodoc),"F")) {
                /* _doctype := '01' */
                _doctype = "01";
                /* Case LRTrim(_tipodoc)='C' */
              } else if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"C")) {
                /* _doctype := '02' */
                _doctype = "02";
                /* Case LRTrim(_tipodoc)='I' */
              } else if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"I")) {
                /* _doctype := '04' */
                _doctype = "04";
              } else { // Otherwise
                /* _doctype := '06' */
                _doctype = "06";
              } // End Case
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _numdoc := Left(riga,_pos - 1) */
              _numdoc = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _pep := Left(riga,_pos - 1) */
              _pep = CPLib.Left(riga,_pos-1);
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _riga6_7 := Left(riga,_pos - 1) */
              _riga6_7 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 8 */
            } else if (CPLib.eqr(_npos,8)) {
              /* _riga6_8 := Left(riga,_pos - 1) */
              _riga6_8 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 9 */
            } else if (CPLib.eqr(_npos,9)) {
              /* _autril := Left(Left(riga,_pos - 1),30) */
              _autril = CPLib.Left(CPLib.Left(riga,_pos-1),30);
              /* Case _npos = 10 */
            } else if (CPLib.eqr(_npos,10)) {
              /* _riga6_10 := Left(riga,_pos - 1) */
              _riga6_10 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 11 */
            } else if (CPLib.eqr(_npos,11)) {
              /* _riga6_11 := LRTrim(riga) */
              _riga6_11 = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 10 */
            if (CPLib.le(_npos,10)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 7 */
        } else if (CPLib.eqr(_i,7)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga7_1 := Left(riga,_pos - 1) */
              _riga7_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _riga7_2 := Left(riga,_pos - 1) */
              _riga7_2 = CPLib.Left(riga,_pos-1);
              /* If At('/',LRTrim(_riga7_2)) <> 0 or At('-',LRTrim(_riga7_2)) <> 0 */
              if (CPLib.ne(CPLib.At("/",CPLib.LRTrim(_riga7_2)),0) || CPLib.ne(CPLib.At("-",CPLib.LRTrim(_riga7_2)),0)) {
                /* _nasdata := CharToDate(Substr(_riga7_2,7,4)+Substr(_riga7_2,4,2)+Left(_riga7_2,2)) */
                _nasdata = CPLib.CharToDate(CPLib.Substr(_riga7_2,7,4)+CPLib.Substr(_riga7_2,4,2)+CPLib.Left(_riga7_2,2));
              } else { // Else
                /* _nasdata := CharToDate(Substr(_riga7_2,5,4)+Substr(_riga7_2,3,2)+Left(_riga7_2,2)) */
                _nasdata = CPLib.CharToDate(CPLib.Substr(_riga7_2,5,4)+CPLib.Substr(_riga7_2,3,2)+CPLib.Left(_riga7_2,2));
              } // End If
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _riga7_3 := Left(riga,_pos - 1) */
              _riga7_3 = CPLib.Left(riga,_pos-1);
              /* _docsca := iif((Empty(LRTrim(_riga7_3)) or _riga7_3='01010001'),NullDate(),CharToDate(Substr(_riga7_3,5,4)+Substr(_riga7_3,3,2)+Left(_riga7_3,2))) */
              _docsca = ((CPLib.Empty(CPLib.LRTrim(_riga7_3)) || CPLib.eqr(_riga7_3,"01010001"))?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(_riga7_3,5,4)+CPLib.Substr(_riga7_3,3,2)+CPLib.Left(_riga7_3,2)));
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _riga7_4 := Left(riga,_pos - 1) */
              _riga7_4 = CPLib.Left(riga,_pos-1);
              /* _docril := CharToDate(Substr(_riga7_4,5,4)+Substr(_riga7_4,3,2)+Left(_riga7_4,2)) */
              _docril = CPLib.CharToDate(CPLib.Substr(_riga7_4,5,4)+CPLib.Substr(_riga7_4,3,2)+CPLib.Left(_riga7_4,2));
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _sesso := Left(riga,_pos - 1) */
              _sesso = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _riga7_6 := Left(riga,_pos - 1) */
              _riga7_6 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _riga7_7 := Left(riga,_pos - 1) */
              _riga7_7 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 8 */
            } else if (CPLib.eqr(_npos,8)) {
              /* _riga7_8 := Left(riga,_pos - 1) */
              _riga7_8 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 9 */
            } else if (CPLib.eqr(_npos,9)) {
              /* _riga7_9 := LRTrim(riga) */
              _riga7_9 = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 8 */
            if (CPLib.le(_npos,8)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 8 */
        } else if (CPLib.eqr(_i,8)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga8_1 := Left(riga,_pos - 1) */
              _riga8_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _riga8_2 := Left(riga,_pos - 1) */
              _riga8_2 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _resstato := '' */
              _resstato = "";
              // * --- Read from DecodeStati
              m_cServer = m_Ctx.GetServer("DecodeStati");
              m_cPhName = m_Ctx.GetPhName("DecodeStati");
              m_cSql = "";
              m_cSql = m_cSql+"account="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(CPLib.Left(CPLib.Left(riga,_pos-1),30)),"C",100,0,m_cServer),m_cServer,CPLib.Upper(CPLib.Left(CPLib.Left(riga,_pos-1),30)));
              if (m_Ctx.IsSharedTemp("DecodeStati")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _resstato = Read_Cursor.GetString("CODSTA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on DecodeStati into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _resstato = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _nasstato := Left(riga,_pos - 1) */
              _nasstato = CPLib.Left(riga,_pos-1);
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _nascitta := Left(riga,_pos - 1) */
              _nascitta = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _riga8_6 := LRTrim(riga) */
              _riga8_6 = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 5 */
            if (CPLib.le(_npos,5)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 9 */
        } else if (CPLib.eqr(_i,9)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga9_1 := Left(riga,_pos - 1) */
              _riga9_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _riga9_2 := Left(riga,_pos - 1) */
              _riga9_2 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _riga9_3 := Left(riga,_pos - 1) */
              _riga9_3 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _codfis := LRTrim(riga) */
              _codfis = CPLib.LRTrim(riga);
              /* _ocodfis := _codfis */
              _ocodfis = _codfis;
            } // End Case
            /* If _npos <= 3 */
            if (CPLib.le(_npos,3)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
        } // End Case
        /* _i := _i + 1 */
        _i = CPLib.Round(_i+1,0);
      } // End While
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
  void Page_8() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Template ITE_04 - Tipo P */
      /* While _i <= 8 */
      while (CPLib.le(_i,8)) {
        /* If _i > 2 */
        if (CPLib.gt(_i,2)) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* _txtope := _txtope + riga */
          _txtope = _txtope+riga;
        } // End If
        /* Case _i = 1 */
        if (CPLib.eqr(_i,1)) {
          /* Case _i = 2 */
        } else if (CPLib.eqr(_i,2)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga2_1 := Left(riga,_pos - 1) */
              _riga2_1 = CPLib.Left(riga,_pos-1);
              /* _statodest := LRTrim(_riga2_1) */
              _statodest = CPLib.LRTrim(_riga2_1);
              /* _uifdest := '' */
              _uifdest = "";
              // * --- Read from wucodes
              m_cServer = m_Ctx.GetServer("wucodes");
              m_cPhName = m_Ctx.GetPhName("wucodes");
              m_cSql = "";
              m_cSql = m_cSql+"WUCODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_statodest,"C",3,0,m_cServer),m_cServer,_statodest);
              if (m_Ctx.IsSharedTemp("wucodes")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("WUCODISO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("WUCODUIF",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _isodest = Read_Cursor.GetString("WUCODISO");
                _uifdest = Read_Cursor.GetString("WUCODUIF");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on wucodes into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _isodest = "";
                _uifdest = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _riga2_2 := Left(riga,_pos - 1) */
              _riga2_2 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _riga2_3 := Left(riga,_pos - 1) */
              _riga2_3 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _riga2_4 := Left(riga,_pos - 1) */
              _riga2_4 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _riga2_5 := Left(riga,_pos - 1) */
              _riga2_5 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _riga2_6 := Left(riga,_pos - 1) */
              _riga2_6 = CPLib.Left(riga,_pos-1);
              /* _impstr := LRTrim(Strtran(_riga2_6,'.','')) */
              _impstr = CPLib.LRTrim(CPLib.Strtran(_riga2_6,".",""));
              /* _importo := Val(_impstr) */
              _importo = CPLib.Round(CPLib.Val(_impstr),2);
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _riga2_7 := Left(riga,_pos - 1) */
              _riga2_7 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 8 */
            } else if (CPLib.eqr(_npos,8)) {
              /* _riga2_8 := Left(riga,_pos - 1) */
              _riga2_8 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 9 */
            } else if (CPLib.eqr(_npos,9)) {
              /* _riga2_9 := Left(riga,_pos - 1) */
              _riga2_9 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 10 */
            } else if (CPLib.eqr(_npos,10)) {
              /* _riga2_10 := Left(riga,_pos - 1) */
              _riga2_10 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 11 */
            } else if (CPLib.eqr(_npos,11)) {
              /* _riga2_11 := Left(riga,_pos - 1) */
              _riga2_11 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 12 */
            } else if (CPLib.eqr(_npos,12)) {
              /* _riga2_12 := LRTrim(riga) */
              _riga2_12 = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 11 */
            if (CPLib.le(_npos,11)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 3 */
        } else if (CPLib.eqr(_i,3)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga3_1 := Left(riga,_pos - 1) */
              _riga3_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _nome := Left(riga,_pos - 1) */
              _nome = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _cognome := LRTrim(riga) */
              _cognome = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 2 */
            if (CPLib.le(_npos,2)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 4 */
        } else if (CPLib.eqr(_i,4)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga4_1 := Left(riga,_pos - 1) */
              _riga4_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _sesso := Left(riga,_pos - 1) */
              _sesso = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _via := Left(riga,_pos - 1) */
              _via = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _citta := Left(riga,_pos - 1) */
              _citta = CPLib.Left(riga,_pos-1);
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _prov := Left(riga,_pos - 1) */
              _prov = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _cap := Left(riga,_pos - 1) */
              _cap = CPLib.Left(riga,_pos-1);
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _riga4_7 := LRTrim(riga) */
              _riga4_7 = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 6 */
            if (CPLib.le(_npos,6)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 5 */
        } else if (CPLib.eqr(_i,5)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga5_1 := Left(riga,_pos - 1) */
              _riga5_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _nomecp := Left(riga,_pos - 1) */
              _nomecp = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _cognomecp := LRTrim(riga) */
              _cognomecp = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 2 */
            if (CPLib.le(_npos,2)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 6 */
        } else if (CPLib.eqr(_i,6)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga7_1 := Left(riga,_pos - 1) */
              _riga7_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _tipodoc := Left(riga,_pos - 1) */
              _tipodoc = CPLib.Left(riga,_pos-1);
              /* Case LRTrim(_tipodoc)='A' */
              if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"A")) {
                /* _doctype := '03' */
                _doctype = "03";
                /* Case LRTrim(_tipodoc)='B' or LRTrim(_tipodoc)='F' */
              } else if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"B") || CPLib.eqr(CPLib.LRTrim(_tipodoc),"F")) {
                /* _doctype := '01' */
                _doctype = "01";
                /* Case LRTrim(_tipodoc)='C' */
              } else if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"C")) {
                /* _doctype := '02' */
                _doctype = "02";
                /* Case LRTrim(_tipodoc)='I' */
              } else if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"I")) {
                /* _doctype := '04' */
                _doctype = "04";
              } else { // Otherwise
                /* _doctype := '06' */
                _doctype = "06";
              } // End Case
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _numdoc := Left(riga,_pos - 1) */
              _numdoc = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _riga7_4 := Left(riga,_pos - 1) */
              _riga7_4 = CPLib.Left(riga,_pos-1);
              /* _docril := CharToDate(Substr(_riga7_4,5,4)+Substr(_riga7_4,3,2)+Left(_riga7_4,2)) */
              _docril = CPLib.CharToDate(CPLib.Substr(_riga7_4,5,4)+CPLib.Substr(_riga7_4,3,2)+CPLib.Left(_riga7_4,2));
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _autril := Left(riga,_pos - 1) */
              _autril = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _riga7_6 := Left(riga,_pos - 1) */
              _riga7_6 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _riga7_7 := Left(riga,_pos - 1) */
              _riga7_7 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 8 */
            } else if (CPLib.eqr(_npos,8)) {
              /* _riga7_8 := Left(riga,_pos - 1) */
              _riga7_8 = CPLib.Left(riga,_pos-1);
              /* _docsca := iif((Empty(LRTrim(_riga7_8)) or _riga7_8='01010001'),NullDate(),CharToDate(Substr(_riga7_8,5,4)+Substr(_riga7_8,3,2)+Left(_riga7_8,2))) */
              _docsca = ((CPLib.Empty(CPLib.LRTrim(_riga7_8)) || CPLib.eqr(_riga7_8,"01010001"))?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(_riga7_8,5,4)+CPLib.Substr(_riga7_8,3,2)+CPLib.Left(_riga7_8,2)));
              /* Case _npos = 9 */
            } else if (CPLib.eqr(_npos,9)) {
              /* _codfis := LRTrim(riga) */
              _codfis = CPLib.LRTrim(riga);
              /* _ocodfis := _codfis */
              _ocodfis = _codfis;
            } // End Case
            /* If _npos <= 8 */
            if (CPLib.le(_npos,8)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 7 */
        } else if (CPLib.eqr(_i,7)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga6_1 := Left(riga,_pos - 1) */
              _riga6_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _riga6_2 := Left(riga,_pos - 1) */
              _riga6_2 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _riga6_3 := Left(riga,_pos - 1) */
              _riga6_3 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _nasstato := Left(riga,_pos - 1) */
              _nasstato = CPLib.Left(riga,_pos-1);
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _nascitta := Left(riga,_pos - 1) */
              _nascitta = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _riga6_6 := Left(riga,_pos - 1) */
              _riga6_6 = CPLib.Left(riga,_pos-1);
              /* If At('/',LRTrim(_riga6_6)) <> 0 or At('-',LRTrim(_riga6_6)) <> 0 */
              if (CPLib.ne(CPLib.At("/",CPLib.LRTrim(_riga6_6)),0) || CPLib.ne(CPLib.At("-",CPLib.LRTrim(_riga6_6)),0)) {
                /* _nasdata := CharToDate(Substr(_riga6_6,7,4)+Substr(_riga6_6,4,2)+Left(_riga6_6,2)) */
                _nasdata = CPLib.CharToDate(CPLib.Substr(_riga6_6,7,4)+CPLib.Substr(_riga6_6,4,2)+CPLib.Left(_riga6_6,2));
              } else { // Else
                /* _nasdata := CharToDate(Substr(_riga6_6,5,4)+Substr(_riga6_6,3,2)+Left(_riga6_6,2)) */
                _nasdata = CPLib.CharToDate(CPLib.Substr(_riga6_6,5,4)+CPLib.Substr(_riga6_6,3,2)+CPLib.Left(_riga6_6,2));
              } // End If
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _riga6_7 := Left(riga,_pos - 1) */
              _riga6_7 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 8 */
            } else if (CPLib.eqr(_npos,8)) {
              /* _riga6_8 := LRTrim(riga) */
              _riga6_8 = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 7 */
            if (CPLib.le(_npos,7)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 8 */
        } else if (CPLib.eqr(_i,8)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga8_1 := Left(riga,_pos - 1) */
              _riga8_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _riga8_2 := Left(riga,_pos - 1) */
              _riga8_2 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _riga8_3 := Left(riga,_pos - 1) */
              _riga8_3 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _riga8_4 := LRTrim(Left(riga,_pos - 1)) */
              _riga8_4 = CPLib.LRTrim(CPLib.Left(riga,_pos-1));
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _riga8_5 := Left(riga,_pos - 1) */
              _riga8_5 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _riga8_6 := Left(riga,_pos - 1) */
              _riga8_6 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _riga8_7 := LRTrim(riga) */
              _riga8_7 = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 6 */
            if (CPLib.le(_npos,6)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
        } // End Case
        /* _i := _i + 1 */
        _i = CPLib.Round(_i+1,0);
      } // End While
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
    CPResultSet Read_Cursor=null;
    try {
      /* Template ITE_05 - Tipo P */
      /* While _i <= 10 */
      while (CPLib.le(_i,10)) {
        /* If _i > 2 */
        if (CPLib.gt(_i,2)) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* _txtope := _txtope + riga */
          _txtope = _txtope+riga;
        } // End If
        /* Case _i = 1 */
        if (CPLib.eqr(_i,1)) {
          /* Case _i = 2 */
        } else if (CPLib.eqr(_i,2)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga2_1 := Left(riga,_pos - 1) */
              _riga2_1 = CPLib.Left(riga,_pos-1);
              /* _statodest := LRTrim(_riga2_1) */
              _statodest = CPLib.LRTrim(_riga2_1);
              /* _uifdest := '' */
              _uifdest = "";
              // * --- Read from wucodes
              m_cServer = m_Ctx.GetServer("wucodes");
              m_cPhName = m_Ctx.GetPhName("wucodes");
              m_cSql = "";
              m_cSql = m_cSql+"WUCODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_statodest,"C",3,0,m_cServer),m_cServer,_statodest);
              if (m_Ctx.IsSharedTemp("wucodes")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("WUCODISO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("WUCODUIF",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _isodest = Read_Cursor.GetString("WUCODISO");
                _uifdest = Read_Cursor.GetString("WUCODUIF");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on wucodes into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _isodest = "";
                _uifdest = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _riga2_2 := Left(riga,_pos - 1) */
              _riga2_2 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _riga2_3 := Left(riga,_pos - 1) */
              _riga2_3 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _riga2_4 := Left(riga,_pos - 1) */
              _riga2_4 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _riga2_5 := Left(riga,_pos - 1) */
              _riga2_5 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _riga2_6 := Left(riga,_pos - 1) */
              _riga2_6 = CPLib.Left(riga,_pos-1);
              /* _impstr := LRTrim(Strtran(_riga2_6,'.','')) */
              _impstr = CPLib.LRTrim(CPLib.Strtran(_riga2_6,".",""));
              /* _importo := Val(_impstr) */
              _importo = CPLib.Round(CPLib.Val(_impstr),2);
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _riga2_7 := Left(riga,_pos - 1) */
              _riga2_7 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 8 */
            } else if (CPLib.eqr(_npos,8)) {
              /* _riga2_8 := Left(riga,_pos - 1) */
              _riga2_8 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 9 */
            } else if (CPLib.eqr(_npos,9)) {
              /* _riga2_9 := Left(riga,_pos - 1) */
              _riga2_9 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 10 */
            } else if (CPLib.eqr(_npos,10)) {
              /* _riga2_10 := Left(riga,_pos - 1) */
              _riga2_10 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 11 */
            } else if (CPLib.eqr(_npos,11)) {
              /* _riga2_11 := Left(riga,_pos - 1) */
              _riga2_11 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 12 */
            } else if (CPLib.eqr(_npos,12)) {
              /* _riga2_12 := LRTrim(riga) */
              _riga2_12 = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 11 */
            if (CPLib.le(_npos,11)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 3 */
        } else if (CPLib.eqr(_i,3)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga3_1 := Left(riga,_pos - 1) */
              _riga3_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _nome := Left(riga,_pos - 1) */
              _nome = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _cognome := LRTrim(riga) */
              _cognome = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 2 */
            if (CPLib.le(_npos,2)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 4 */
        } else if (CPLib.eqr(_i,4)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga4_1 := Left(riga,_pos - 1) */
              _riga4_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _via := Left(riga,_pos - 1) */
              _via = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _tipodoc := Left(riga,_pos - 1) */
              _tipodoc = CPLib.Left(riga,_pos-1);
              /* Case LRTrim(_tipodoc)='A' */
              if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"A")) {
                /* _doctype := '03' */
                _doctype = "03";
                /* Case LRTrim(_tipodoc)='B' or LRTrim(_tipodoc)='F' */
              } else if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"B") || CPLib.eqr(CPLib.LRTrim(_tipodoc),"F")) {
                /* _doctype := '01' */
                _doctype = "01";
                /* Case LRTrim(_tipodoc)='C' */
              } else if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"C")) {
                /* _doctype := '02' */
                _doctype = "02";
                /* Case LRTrim(_tipodoc)='I' */
              } else if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"I")) {
                /* _doctype := '04' */
                _doctype = "04";
              } else { // Otherwise
                /* _doctype := '06' */
                _doctype = "06";
              } // End Case
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _numdoc := Left(riga,_pos - 1) */
              _numdoc = CPLib.Left(riga,_pos-1);
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _citta := Left(riga,_pos - 1) */
              _citta = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _prov := Left(riga,_pos - 1) */
              _prov = CPLib.Left(riga,_pos-1);
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _cap := Left(riga,_pos - 1) */
              _cap = CPLib.Left(riga,_pos-1);
              /* Case _npos = 8 */
            } else if (CPLib.eqr(_npos,8)) {
              /* _resstato := '' */
              _resstato = "";
              // * --- Read from DecodeStati
              m_cServer = m_Ctx.GetServer("DecodeStati");
              m_cPhName = m_Ctx.GetPhName("DecodeStati");
              m_cSql = "";
              m_cSql = m_cSql+"account="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(CPLib.Left(CPLib.LRTrim(riga),30)),"C",100,0,m_cServer),m_cServer,CPLib.Upper(CPLib.Left(CPLib.LRTrim(riga),30)));
              if (m_Ctx.IsSharedTemp("DecodeStati")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _resstato = Read_Cursor.GetString("CODSTA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on DecodeStati into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _resstato = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End Case
            /* If _npos <= 8 */
            if (CPLib.le(_npos,8)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 5 */
        } else if (CPLib.eqr(_i,5)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga5_1 := Left(riga,_pos - 1) */
              _riga5_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _nomecp := Left(riga,_pos - 1) */
              _nomecp = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _cognomecp := LRTrim(riga) */
              _cognomecp = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 2 */
            if (CPLib.le(_npos,2)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 6 */
        } else if (CPLib.eqr(_i,6)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga6_1 := Left(riga,_pos - 1) */
              _riga6_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _riga6_2 := Left(riga,_pos - 1) */
              _riga6_2 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _pep := Left(riga,_pos - 1) */
              _pep = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _riga6_4 := Left(riga,_pos - 1) */
              _riga6_4 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _riga6_5 := Left(riga,_pos - 1) */
              _riga6_5 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _autril := Left(riga,_pos - 1) */
              _autril = CPLib.Left(riga,_pos-1);
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _riga6_7 := Left(riga,_pos - 1) */
              _riga6_7 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 8 */
            } else if (CPLib.eqr(_npos,8)) {
              /* _riga6_8 := LRTrim(riga) */
              _riga6_8 = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 7 */
            if (CPLib.le(_npos,7)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 7 */
        } else if (CPLib.eqr(_i,7)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga7_1 := Left(riga,_pos - 1) */
              _riga7_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _riga7_2 := Left(riga,_pos - 1) */
              _riga7_2 = CPLib.Left(riga,_pos-1);
              /* If At('/',LRTrim(_riga7_2)) <> 0 or At('-',LRTrim(_riga7_2)) <> 0 */
              if (CPLib.ne(CPLib.At("/",CPLib.LRTrim(_riga7_2)),0) || CPLib.ne(CPLib.At("-",CPLib.LRTrim(_riga7_2)),0)) {
                /* _nasdata := CharToDate(Substr(_riga7_2,7,4)+Substr(_riga7_2,4,2)+Left(_riga7_2,2)) */
                _nasdata = CPLib.CharToDate(CPLib.Substr(_riga7_2,7,4)+CPLib.Substr(_riga7_2,4,2)+CPLib.Left(_riga7_2,2));
              } else { // Else
                /* _nasdata := CharToDate(Substr(_riga7_2,5,4)+Substr(_riga7_2,3,2)+Left(_riga7_2,2)) */
                _nasdata = CPLib.CharToDate(CPLib.Substr(_riga7_2,5,4)+CPLib.Substr(_riga7_2,3,2)+CPLib.Left(_riga7_2,2));
              } // End If
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _riga7_3 := Left(riga,_pos - 1) */
              _riga7_3 = CPLib.Left(riga,_pos-1);
              /* _docsca := iif((Empty(LRTrim(_riga7_3)) or _riga7_3='01010001'),NullDate(),CharToDate(Substr(_riga7_3,5,4)+Substr(_riga7_3,3,2)+Left(_riga7_3,2))) */
              _docsca = ((CPLib.Empty(CPLib.LRTrim(_riga7_3)) || CPLib.eqr(_riga7_3,"01010001"))?CPLib.NullDate():CPLib.CharToDate(CPLib.Substr(_riga7_3,5,4)+CPLib.Substr(_riga7_3,3,2)+CPLib.Left(_riga7_3,2)));
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _riga7_4 := Left(riga,_pos - 1) */
              _riga7_4 = CPLib.Left(riga,_pos-1);
              /* _docril := CharToDate(Substr(_riga7_4,5,4)+Substr(_riga7_4,3,2)+Left(_riga7_4,2)) */
              _docril = CPLib.CharToDate(CPLib.Substr(_riga7_4,5,4)+CPLib.Substr(_riga7_4,3,2)+CPLib.Left(_riga7_4,2));
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _sesso := Left(riga,_pos - 1) */
              _sesso = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _riga6_6 := Left(riga,_pos - 1) */
              _riga6_6 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _riga7_7 := Left(riga,_pos - 1) */
              _riga7_7 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 8 */
            } else if (CPLib.eqr(_npos,8)) {
              /* _riga7_8 := LRTrim(riga) */
              _riga7_8 = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 7 */
            if (CPLib.le(_npos,7)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 8 */
        } else if (CPLib.eqr(_i,8)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga8_1 := Left(riga,_pos - 1) */
              _riga8_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _riga8_2 := Left(riga,_pos - 1) */
              _riga8_2 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _riga8_3 := Left(riga,_pos - 1) */
              _riga8_3 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _nasstato := Left(riga,_pos - 1) */
              _nasstato = CPLib.Left(riga,_pos-1);
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _riga8_5 := Left(riga,_pos - 1) */
              _riga8_5 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _nascitta := Left(riga,_pos - 1) */
              _nascitta = CPLib.Left(riga,_pos-1);
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _riga8_7 := Left(riga,_pos - 1) */
              _riga8_7 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 8 */
            } else if (CPLib.eqr(_npos,8)) {
              /* _codfis := Left(riga,_pos - 1) */
              _codfis = CPLib.Left(riga,_pos-1);
              /* _ocodfis := _codfis */
              _ocodfis = _codfis;
              /* Case _npos = 9 */
            } else if (CPLib.eqr(_npos,9)) {
              /* _riga8_9 := LRTrim(riga) */
              _riga8_9 = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 8 */
            if (CPLib.le(_npos,8)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 9 */
        } else if (CPLib.eqr(_i,9)) {
          /* Case _i = 10 */
        } else if (CPLib.eqr(_i,10)) {
        } // End Case
        /* _i := _i + 1 */
        _i = CPLib.Round(_i+1,0);
      } // End While
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
    CPResultSet Read_Cursor=null;
    try {
      /* Template UNI_0106 - Tipo S */
      /* While _i <= 27 */
      while (CPLib.le(_i,27)) {
        /* If _i > 2 */
        if (CPLib.gt(_i,2)) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* _txtope := _txtope + riga */
          _txtope = _txtope+riga;
        } // End If
        /* Case _i = 1 */
        if (CPLib.eqr(_i,1)) {
          /* Case _i = 2 */
        } else if (CPLib.eqr(_i,2)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga2_1 := Left(riga,_pos - 1) */
              _riga2_1 = CPLib.Left(riga,_pos-1);
              /* _impstr := LRTrim(Strtran(_riga2_1,'.','')) */
              _impstr = CPLib.LRTrim(CPLib.Strtran(_riga2_1,".",""));
              /* _importo := Val(_impstr) */
              _importo = CPLib.Round(CPLib.Val(_impstr),2);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _riga2_2 := Left(riga,_pos - 1) */
              _riga2_2 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _riga2_3 := Left(riga,_pos - 1) */
              _riga2_3 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _riga2_4 := Left(riga,_pos - 1) */
              _riga2_4 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _riga2_5 := Left(riga,_pos - 1) */
              _riga2_5 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _riga2_6 := Left(riga,_pos - 1) */
              _riga2_6 = CPLib.Left(riga,_pos-1);
              /* _statodest := LRTrim(_riga2_6) */
              _statodest = CPLib.LRTrim(_riga2_6);
              /* _uifdest := '' */
              _uifdest = "";
              // * --- Read from wucodes
              m_cServer = m_Ctx.GetServer("wucodes");
              m_cPhName = m_Ctx.GetPhName("wucodes");
              m_cSql = "";
              m_cSql = m_cSql+"WUCODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_statodest,"C",3,0,m_cServer),m_cServer,_statodest);
              if (m_Ctx.IsSharedTemp("wucodes")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("WUCODISO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("WUCODUIF",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _isodest = Read_Cursor.GetString("WUCODISO");
                _uifdest = Read_Cursor.GetString("WUCODUIF");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on wucodes into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _isodest = "";
                _uifdest = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _riga2_7 := LRTrim(riga) */
              _riga2_7 = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 6 */
            if (CPLib.le(_npos,6)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 3 */
        } else if (CPLib.eqr(_i,3)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga3_1 := Left(riga,_pos - 1) */
              _riga3_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _nome := Left(riga,_pos - 1) */
              _nome = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _cognome := LRTrim(riga) */
              _cognome = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 2 */
            if (CPLib.le(_npos,2)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 4 */
        } else if (CPLib.eqr(_i,4)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga4_1 := Left(riga,_pos - 1) */
              _riga4_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _citta := Left(riga,_pos - 1) */
              _citta = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _cap := Left(riga,_pos - 1) */
              _cap = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _via := LRTrim(riga) */
              _via = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 3 */
            if (CPLib.le(_npos,3)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 5 */
        } else if (CPLib.eqr(_i,5)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga5_1 := Left(riga,_pos - 1) */
              _riga5_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _nomecp := Left(riga,_pos - 1) */
              _nomecp = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _cognomecp := LRTrim(riga) */
              _cognomecp = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 2 */
            if (CPLib.le(_npos,2)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 6 */
        } else if (CPLib.eqr(_i,6)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga6_1 := Left(riga,_pos - 1) */
              _riga6_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _riga6_2 := Left(riga,_pos - 1) */
              _riga6_2 = CPLib.Left(riga,_pos-1);
              /* _numtel := Left(LRTrim(_riga6_2),20) */
              _numtel = CPLib.Left(CPLib.LRTrim(_riga6_2),20);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _tipodoc := Left(riga,_pos - 1) */
              _tipodoc = CPLib.Left(riga,_pos-1);
              /* Case LRTrim(_tipodoc)='A' */
              if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"A")) {
                /* _doctype := '03' */
                _doctype = "03";
                /* Case LRTrim(_tipodoc)='B' or LRTrim(_tipodoc)='F' */
              } else if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"B") || CPLib.eqr(CPLib.LRTrim(_tipodoc),"F")) {
                /* _doctype := '01' */
                _doctype = "01";
                /* Case LRTrim(_tipodoc)='C' */
              } else if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"C")) {
                /* _doctype := '02' */
                _doctype = "02";
                /* Case LRTrim(_tipodoc)='I' */
              } else if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"I")) {
                /* _doctype := '04' */
                _doctype = "04";
              } else { // Otherwise
                /* _doctype := '06' */
                _doctype = "06";
              } // End Case
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _numdoc := Left(riga,_pos - 1) */
              _numdoc = CPLib.Left(riga,_pos-1);
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _autril := Left(Left(riga,_pos - 1),30) */
              _autril = CPLib.Left(CPLib.Left(riga,_pos-1),30);
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _riga6_7 := Left(riga,_pos - 1) */
              _riga6_7 = CPLib.Left(riga,_pos-1);
              /* _docsca := iif((Empty(LRTrim(_riga6_7)) or _riga6_7='01010001'),NullDate(),CharToDate(Right(_riga6_7,4)+Substr(_riga6_7,3,2)+Left(_riga6_7,2))) */
              _docsca = ((CPLib.Empty(CPLib.LRTrim(_riga6_7)) || CPLib.eqr(_riga6_7,"01010001"))?CPLib.NullDate():CPLib.CharToDate(CPLib.Right(_riga6_7,4)+CPLib.Substr(_riga6_7,3,2)+CPLib.Left(_riga6_7,2)));
              /* Case _npos = 8 */
            } else if (CPLib.eqr(_npos,8)) {
              /* _riga6_8 := Left(riga,_pos - 1) */
              _riga6_8 = CPLib.Left(riga,_pos-1);
              /* _docril := iif((Empty(LRTrim(_riga6_8)) or _riga6_8='01010001'),NullDate(),CharToDate(Right(_riga6_8,4)+Substr(_riga6_8,3,2)+Left(_riga6_8,2))) */
              _docril = ((CPLib.Empty(CPLib.LRTrim(_riga6_8)) || CPLib.eqr(_riga6_8,"01010001"))?CPLib.NullDate():CPLib.CharToDate(CPLib.Right(_riga6_8,4)+CPLib.Substr(_riga6_8,3,2)+CPLib.Left(_riga6_8,2)));
              /* Case _npos = 9 */
            } else if (CPLib.eqr(_npos,9)) {
              /* _riga6_9 := Left(riga,_pos - 1) */
              _riga6_9 = CPLib.Left(riga,_pos-1);
              /* _nasdata := CharToDate(Right(_riga6_9,4)+Substr(_riga6_9,3,2)+Left(_riga6_9,2)) */
              _nasdata = CPLib.CharToDate(CPLib.Right(_riga6_9,4)+CPLib.Substr(_riga6_9,3,2)+CPLib.Left(_riga6_9,2));
              /* Case _npos = 10 */
            } else if (CPLib.eqr(_npos,10)) {
              /* _riga6_10 := Left(riga,_pos - 1) */
              _riga6_10 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 11 */
            } else if (CPLib.eqr(_npos,11)) {
              /* _riga6_11 := LRTrim(riga) */
              _riga6_11 = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 10 */
            if (CPLib.le(_npos,10)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 7 */
        } else if (CPLib.eqr(_i,7)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga7_1 := Left(riga,_pos - 1) */
              _riga7_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _riga7_2 := Left(riga,_pos - 1) */
              _riga7_2 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _riga7_3 := Left(riga,_pos - 1) */
              _riga7_3 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _riga7_4 := Left(riga,_pos - 1) */
              _riga7_4 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _nasstato := Left(riga,_pos - 1) */
              _nasstato = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _riga7_6 := Left(riga,_pos - 1) */
              _riga7_6 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _riga7_7 := Left(riga,_pos - 1) */
              _riga7_7 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 8 */
            } else if (CPLib.eqr(_npos,8)) {
              /* _riga7_8 := Left(riga,_pos - 1) */
              _riga7_8 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 9 */
            } else if (CPLib.eqr(_npos,9)) {
              /* _riga7_9 := LRTrim(riga) */
              _riga7_9 = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 8 */
            if (CPLib.le(_npos,8)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 8 */
        } else if (CPLib.eqr(_i,8)) {
          /* Case _i = 9 */
        } else if (CPLib.eqr(_i,9)) {
          /* Case _i=10 */
        } else if (CPLib.eqr(_i,10)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 3 */
            if (CPLib.eqr(_npos,3)) {
              /* _sesso := Left(riga,_pos - 1) */
              _sesso = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _codfis := LRTrim(Left(riga,_pos - 1)) */
              _codfis = CPLib.LRTrim(CPLib.Left(riga,_pos-1));
              /* _ocodfis := _codfis */
              _ocodfis = _codfis;
            } // End Case
            /* If _npos <= 10 */
            if (CPLib.le(_npos,10)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i=11 */
        } else if (CPLib.eqr(_i,11)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 2 */
            if (CPLib.eqr(_npos,2)) {
              /* _nascitta := Left(riga,_pos - 1) */
              _nascitta = CPLib.Left(riga,_pos-1);
            } // End Case
            /* If _npos <= 6 */
            if (CPLib.le(_npos,6)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i=12 */
        } else if (CPLib.eqr(_i,12)) {
          /* Case _i=13 */
        } else if (CPLib.eqr(_i,13)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 3 */
            if (CPLib.eqr(_npos,3)) {
              /* _nasprov := Left(riga,_pos - 1) */
              _nasprov = CPLib.Left(riga,_pos-1);
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
            } // End Case
            /* If _npos <= 6 */
            if (CPLib.le(_npos,6)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i=14 */
        } else if (CPLib.eqr(_i,14)) {
          /* Case _i=15 */
        } else if (CPLib.eqr(_i,15)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 2 */
            if (CPLib.eqr(_npos,2)) {
              /* _autril := Left(LRTrim(Left(riga,_pos - 1))+ " "+LRTrim(_autril),30) */
              _autril = CPLib.Left(CPLib.LRTrim(CPLib.Left(riga,_pos-1))+" "+CPLib.LRTrim(_autril),30);
            } // End Case
            /* If _npos <= 5 */
            if (CPLib.le(_npos,5)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i=19 */
        } else if (CPLib.eqr(_i,19)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 2 */
            if (CPLib.eqr(_npos,2)) {
              /* _resstato := '' */
              _resstato = "";
              // * --- Read from DecodeStati
              m_cServer = m_Ctx.GetServer("DecodeStati");
              m_cPhName = m_Ctx.GetPhName("DecodeStati");
              m_cSql = "";
              m_cSql = m_cSql+"account="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(CPLib.Left(CPLib.Left(riga,_pos-1),30)),"C",100,0,m_cServer),m_cServer,CPLib.Upper(CPLib.Left(CPLib.Left(riga,_pos-1),30)));
              if (m_Ctx.IsSharedTemp("DecodeStati")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _resstato = Read_Cursor.GetString("CODSTA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on DecodeStati into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _resstato = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End Case
            /* If _npos <= 7 */
            if (CPLib.le(_npos,7)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i=28 */
        } else if (CPLib.eqr(_i,28)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 2 */
            if (CPLib.eqr(_npos,2)) {
            } // End Case
            /* If _npos <= 3 */
            if (CPLib.le(_npos,3)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
        } // End Case
        /* _i := _i + 1 */
        _i = CPLib.Round(_i+1,0);
      } // End While
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
  void Page_11() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Template UNI_0106 - Tipo P */
      /* While _i <= 26 */
      while (CPLib.le(_i,26)) {
        /* If _i > 2 */
        if (CPLib.gt(_i,2)) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* _txtope := _txtope + riga */
          _txtope = _txtope+riga;
        } // End If
        /* Case _i = 1 */
        if (CPLib.eqr(_i,1)) {
          /* Case _i = 2 */
        } else if (CPLib.eqr(_i,2)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga2_1 := Left(riga,_pos - 1) */
              _riga2_1 = CPLib.Left(riga,_pos-1);
              /* _statodest := LRTrim(_riga2_1) */
              _statodest = CPLib.LRTrim(_riga2_1);
              /* _uifdest := '' */
              _uifdest = "";
              // * --- Read from wucodes
              m_cServer = m_Ctx.GetServer("wucodes");
              m_cPhName = m_Ctx.GetPhName("wucodes");
              m_cSql = "";
              m_cSql = m_cSql+"WUCODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_statodest,"C",3,0,m_cServer),m_cServer,_statodest);
              if (m_Ctx.IsSharedTemp("wucodes")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("WUCODISO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("WUCODUIF",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _isodest = Read_Cursor.GetString("WUCODISO");
                _uifdest = Read_Cursor.GetString("WUCODUIF");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on wucodes into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _isodest = "";
                _uifdest = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _riga2_2 := Left(riga,_pos - 1) */
              _riga2_2 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _riga2_3 := Left(riga,_pos - 1) */
              _riga2_3 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _riga2_4 := Left(riga,_pos - 1) */
              _riga2_4 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _riga2_5 := Left(riga,_pos - 1) */
              _riga2_5 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 6 */
            } else if (CPLib.eqr(_npos,6)) {
              /* _riga2_6 := Left(riga,_pos - 1) */
              _riga2_6 = CPLib.Left(riga,_pos-1);
              /* _impstr := LRTrim(Strtran(_riga2_6,'.','')) */
              _impstr = CPLib.LRTrim(CPLib.Strtran(_riga2_6,".",""));
              /* _importo := Val(_impstr) */
              _importo = CPLib.Round(CPLib.Val(_impstr),2);
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _riga2_7 := LRTrim(riga) */
              _riga2_7 = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 12 */
            if (CPLib.le(_npos,12)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 3 */
        } else if (CPLib.eqr(_i,3)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga3_1 := Left(riga,_pos - 1) */
              _riga3_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _nome := Left(riga,_pos - 1) */
              _nome = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _cognome := LRTrim(riga) */
              _cognome = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 2 */
            if (CPLib.le(_npos,2)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 4 */
        } else if (CPLib.eqr(_i,4)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga4_1 := Left(riga,_pos - 1) */
              _riga4_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _cap := Left(riga,_pos - 1) */
              _cap = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _prov := LRTrim(Left(riga,_pos-1)) */
              _prov = CPLib.LRTrim(CPLib.Left(riga,_pos-1));
              /* Case _npos = 4 */
            } else if (CPLib.eqr(_npos,4)) {
              /* _citta := Left(riga,_pos - 1) */
              _citta = CPLib.Left(riga,_pos-1);
              /* Case _npos = 5 */
            } else if (CPLib.eqr(_npos,5)) {
              /* _via := Left(riga,_pos - 1) */
              _via = CPLib.Left(riga,_pos-1);
              /* Case _npos = 8 */
            } else if (CPLib.eqr(_npos,8)) {
              /* _numtel := Left(riga,_pos - 1) */
              _numtel = CPLib.Left(riga,_pos-1);
            } // End Case
            /* If _npos <= 10 */
            if (CPLib.le(_npos,10)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 5 */
        } else if (CPLib.eqr(_i,5)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 1 */
            if (CPLib.eqr(_npos,1)) {
              /* _riga5_1 := Left(riga,_pos - 1) */
              _riga5_1 = CPLib.Left(riga,_pos-1);
              /* Case _npos = 2 */
            } else if (CPLib.eqr(_npos,2)) {
              /* _nomecp := Left(riga,_pos - 1) */
              _nomecp = CPLib.Left(riga,_pos-1);
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _cognomecp := LRTrim(riga) */
              _cognomecp = CPLib.LRTrim(riga);
            } // End Case
            /* If _npos <= 2 */
            if (CPLib.le(_npos,2)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 6 */
        } else if (CPLib.eqr(_i,6)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 7 */
            if (CPLib.eqr(_npos,7)) {
              /* _tipodoc := Left(riga,_pos - 1) */
              _tipodoc = CPLib.Left(riga,_pos-1);
              /* Case LRTrim(_tipodoc)='A' */
              if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"A")) {
                /* _doctype := '03' */
                _doctype = "03";
                /* Case LRTrim(_tipodoc)='B' or LRTrim(_tipodoc)='F' */
              } else if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"B") || CPLib.eqr(CPLib.LRTrim(_tipodoc),"F")) {
                /* _doctype := '01' */
                _doctype = "01";
                /* Case LRTrim(_tipodoc)='C' */
              } else if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"C")) {
                /* _doctype := '02' */
                _doctype = "02";
                /* Case LRTrim(_tipodoc)='I' */
              } else if (CPLib.eqr(CPLib.LRTrim(_tipodoc),"I")) {
                /* _doctype := '04' */
                _doctype = "04";
              } else { // Otherwise
                /* _doctype := '06' */
                _doctype = "06";
              } // End Case
              /* Case _npos = 8 */
            } else if (CPLib.eqr(_npos,8)) {
              /* _numdoc := Left(riga,_pos - 1) */
              _numdoc = CPLib.Left(riga,_pos-1);
              /* Case _npos = 9 */
            } else if (CPLib.eqr(_npos,9)) {
              /* _riga6_9 := Left(riga,_pos - 1) */
              _riga6_9 = CPLib.Left(riga,_pos-1);
              /* _nasdata := CharToDate(Right(_riga6_9,4)+Substr(_riga6_9,3,2)+Left(_riga6_9,2)) */
              _nasdata = CPLib.CharToDate(CPLib.Right(_riga6_9,4)+CPLib.Substr(_riga6_9,3,2)+CPLib.Left(_riga6_9,2));
              /* Case _npos = 10 */
            } else if (CPLib.eqr(_npos,10)) {
              /* _riga6_7 := Left(riga,_pos - 1) */
              _riga6_7 = CPLib.Left(riga,_pos-1);
              /* _docsca := iif((Empty(LRTrim(_riga6_7)) or _riga6_7='01010001'),NullDate(),CharToDate(Right(_riga6_7,4)+Substr(_riga6_7,3,2)+Left(_riga6_7,2))) */
              _docsca = ((CPLib.Empty(CPLib.LRTrim(_riga6_7)) || CPLib.eqr(_riga6_7,"01010001"))?CPLib.NullDate():CPLib.CharToDate(CPLib.Right(_riga6_7,4)+CPLib.Substr(_riga6_7,3,2)+CPLib.Left(_riga6_7,2)));
            } // End Case
            /* If _npos <= 10 */
            if (CPLib.le(_npos,10)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 7 */
        } else if (CPLib.eqr(_i,7)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* Case _npos = 2 */
            if (CPLib.eqr(_npos,2)) {
              /* _resstato := '' */
              _resstato = "";
              // * --- Read from DecodeStati
              m_cServer = m_Ctx.GetServer("DecodeStati");
              m_cPhName = m_Ctx.GetPhName("DecodeStati");
              m_cSql = "";
              m_cSql = m_cSql+"account="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(CPLib.Left(CPLib.Left(riga,_pos-1),30)),"C",100,0,m_cServer),m_cServer,CPLib.Upper(CPLib.Left(CPLib.Left(riga,_pos-1),30)));
              if (m_Ctx.IsSharedTemp("DecodeStati")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODSTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _resstato = Read_Cursor.GetString("CODSTA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on DecodeStati into routine arrt_imp_dati_ac returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _resstato = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* Case _npos = 3 */
            } else if (CPLib.eqr(_npos,3)) {
              /* _riga7_3 := Left(riga,_pos - 1) */
              _riga7_3 = CPLib.Left(riga,_pos-1);
              /* _docril := iif((Empty(LRTrim(_riga7_3)) or _riga7_3='01010001'),NullDate(),CharToDate(Right(_riga7_3,4)+Substr(_riga7_3,3,2)+Left(_riga7_3,2))) */
              _docril = ((CPLib.Empty(CPLib.LRTrim(_riga7_3)) || CPLib.eqr(_riga7_3,"01010001"))?CPLib.NullDate():CPLib.CharToDate(CPLib.Right(_riga7_3,4)+CPLib.Substr(_riga7_3,3,2)+CPLib.Left(_riga7_3,2)));
              /* Case _npos = 7 */
            } else if (CPLib.eqr(_npos,7)) {
              /* _nasstato := Left(riga,_pos - 1) */
              _nasstato = CPLib.Left(riga,_pos-1);
            } // End Case
            /* If _npos <= 8 */
            if (CPLib.le(_npos,8)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 8 */
        } else if (CPLib.eqr(_i,8)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* If _npos=2 */
            if (CPLib.eqr(_npos,2)) {
              /* _autril := Left(Left(riga,_pos - 1),30) */
              _autril = CPLib.Left(CPLib.Left(riga,_pos-1),30);
            } // End If
            /* If _npos <= 7 */
            if (CPLib.le(_npos,7)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i = 9 */
        } else if (CPLib.eqr(_i,9)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* If _npos=7 */
            if (CPLib.eqr(_npos,7)) {
              /* _sesso := Left(riga,_pos - 1) */
              _sesso = CPLib.Left(riga,_pos-1);
            } // End If
            /* If _npos <= 7 */
            if (CPLib.le(_npos,7)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i=10 */
        } else if (CPLib.eqr(_i,10)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* If _npos=5 */
            if (CPLib.eqr(_npos,5)) {
              /* _codfis := LRTrim(Left(riga,_pos - 1)) */
              _codfis = CPLib.LRTrim(CPLib.Left(riga,_pos-1));
              /* _ocodfis := _codfis */
              _ocodfis = _codfis;
            } // End If
            /* If _npos=9 */
            if (CPLib.eqr(_npos,9)) {
              /* _nascitta := Left(riga,_pos - 1) */
              _nascitta = CPLib.Left(riga,_pos-1);
            } // End If
            /* If _npos <= 9 */
            if (CPLib.le(_npos,9)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
          /* Case _i=14 */
        } else if (CPLib.eqr(_i,14)) {
          /* _npos := 1 */
          _npos = CPLib.Round(1,0);
          /* While Len(LRTrim(riga)) > 0 */
          while (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _pos := At(';',riga) */
            _pos = CPLib.Round(CPLib.At(";",riga),0);
            /* If _npos=3 */
            if (CPLib.eqr(_npos,3)) {
              /* _nasprov := Left(riga,_pos - 1) */
              _nasprov = CPLib.Left(riga,_pos-1);
            } // End If
            /* If _npos <= 6 */
            if (CPLib.le(_npos,6)) {
              /* riga := Substr(riga,_pos + 1) */
              riga = CPLib.Substr(riga,_pos+1);
            } else { // Else
              /* riga := '' */
              riga = "";
            } // End If
            /* _npos := _npos + 1 */
            _npos = CPLib.Round(_npos+1,0);
          } // End While
        } // End Case
        /* _i := _i + 1 */
        _i = CPLib.Round(_i+1,0);
      } // End While
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
    //base
    InputStream ExcelFileToRead = new FileInputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_fileage));
    XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
    _conta = wb.getNumberOfSheets();
    XSSFRow row; 
    XSSFCell cell;
    colonna=new String[1];
    /* _i1 = 0 */
    CPLib.eqr(_i1,0);
    /* While _i1 < _conta */
    while (CPLib.lt(_i1,_conta)) {
      //Apro uno ad uno i fogli del file Excel
      XSSFSheet sheet = wb.getSheetAt(_i1);
      //Mi definisco un oggetto che contiene tutte le righe
      Iterator rows = sheet.rowIterator();
      //_righe = sheet.getLastRowNum()+1;
      //_y = 1;
      /* foglio := _i1 // foglio letto */
      foglio = CPLib.Round(_i1,0);
      /* While rows.hasNext() */
      while (rows.hasNext()) {
        //scorro le righe
        row=(XSSFRow) rows.next();
        //Mi definisco un oggetto che contiene tutte le celle della riga letta
        Iterator cells = row.cellIterator();
        cell_count=0;
        /* riga_letta := riga_letta+1 // riga letta del file Excel */
        riga_letta = CPLib.Round(riga_letta+1,0);
        /* While cells.hasNext() and riga_letta>1 */
        while (cells.hasNext() && CPLib.gt(riga_letta,1)) {
          //scorro le celle della riga
          cell=(XSSFCell) cells.next();
          colonna[cell_count]=cell.getStringCellValue();
          ++cell_count;
        } // End While
        /* If riga_letta > 1 */
        if (CPLib.gt(riga_letta,1)) {
          /* mcListaAge.AppendWithKey(colonna[0]) */
          mcListaAge.AppendWithKey(colonna[0]);
          /* mcListaAge.CODICE := colonna[0] */
          mcListaAge.row.CODICE = colonna[0];
          /* mcListaAge.SaveRow() */
          mcListaAge.SaveRow();
        } // End If
      } // End While
      _i1++;
    } // End While
  }
  void Page_13() throws Exception {
    /* Passa alla nuova riga */
    /* _i := _i + 1 */
    _i = CPLib.Round(_i+1,0);
    /* If _tipriga='S' */
    if (CPLib.eqr(_tipriga,"S")) {
      /* Case _tplriga='ITE_04' */
      if (CPLib.eqr(_tplriga,"ITE_04")) {
        /* While _i <= 7 */
        while (CPLib.le(_i,7)) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* _i := _i + 1 */
          _i = CPLib.Round(_i+1,0);
        } // End While
        /* Case _tplriga='ITE_05' */
      } else if (CPLib.eqr(_tplriga,"ITE_05")) {
        /* While _i <= 9 */
        while (CPLib.le(_i,9)) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* _i := _i + 1 */
          _i = CPLib.Round(_i+1,0);
        } // End While
        /* Case _tplriga='UNI_0106' */
      } else if (CPLib.eqr(_tplriga,"UNI_0106")) {
        /* While _i <= 27 */
        while (CPLib.le(_i,27)) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* _i := _i + 1 */
          _i = CPLib.Round(_i+1,0);
        } // End While
      } // End Case
    } // End If
    /* If _tipriga='P' */
    if (CPLib.eqr(_tipriga,"P")) {
      /* Case _tplriga='ITE_04' */
      if (CPLib.eqr(_tplriga,"ITE_04")) {
        /* While _i <= 8 */
        while (CPLib.le(_i,8)) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* _i := _i + 1 */
          _i = CPLib.Round(_i+1,0);
        } // End While
        /* Case _tplriga='ITE_05' */
      } else if (CPLib.eqr(_tplriga,"ITE_05")) {
        /* While _i <= 10 */
        while (CPLib.le(_i,10)) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* _i := _i + 1 */
          _i = CPLib.Round(_i+1,0);
        } // End While
        /* Case _tplriga='UNI_0106' */
      } else if (CPLib.eqr(_tplriga,"UNI_0106")) {
        /* While _i <= 26 */
        while (CPLib.le(_i,26)) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* _i := _i + 1 */
          _i = CPLib.Round(_i+1,0);
        } // End While
      } // End Case
    } // End If
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
      m_Caller.SetString("opextc","C",1,0,w_opextc);
      m_Caller.SetString("codmage","C",5,0,w_codmage);
      m_Caller.SetString("destfin","C",1,0,w_destfin);
      m_Caller.SetString("xMAFLGRAP","C",1,0,w_xMAFLGRAP);
      m_Caller.SetString("xMAFLGBON","C",1,0,w_xMAFLGBON);
      m_Caller.SetString("xMAFLGCKR","C",1,0,w_xMAFLGCKR);
      m_Caller.SetString("xMAFLGASR","C",1,0,w_xMAFLGASR);
      m_Caller.SetString("xMADIPSTD","C",6,0,w_xMADIPSTD);
      m_Caller.SetString("newrec","C",1,0,w_newrec);
      m_Caller.SetString("flgscad","C",1,0,w_flgscad);
      m_Caller.SetString("fileage","C",80,0,w_fileage);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_imp_dati_acR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_imp_dati_acR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_tipodest = m_Caller.GetString("tipodest","C",1,0);
    w_impzip = m_Caller.GetNumber("impzip","N",1,0);
    w_opextc = m_Caller.GetString("opextc","C",1,0);
    w_codmage = m_Caller.GetString("codmage","C",5,0);
    w_destfin = m_Caller.GetString("destfin","C",1,0);
    w_xMAFLGRAP = m_Caller.GetString("xMAFLGRAP","C",1,0);
    w_xMAFLGBON = m_Caller.GetString("xMAFLGBON","C",1,0);
    w_xMAFLGCKR = m_Caller.GetString("xMAFLGCKR","C",1,0);
    w_xMAFLGASR = m_Caller.GetString("xMAFLGASR","C",1,0);
    w_xMADIPSTD = m_Caller.GetString("xMADIPSTD","C",6,0);
    w_newrec = m_Caller.GetString("newrec","C",1,0);
    w_flgscad = m_Caller.GetString("flgscad","C",1,0);
    w_fileage = m_Caller.GetString("fileage","C",80,0);
    fhand = CPLib.Space(1);
    _codrap = CPLib.Space(16);
    riga = "";
    nProg = 0;
    nomefileimport = CPLib.Space(50);
    xConnes = CPLib.Space(16);
    conta = 0;
    _tdest = CPLib.Space(1);
    _i = 0;
    _pos = 0;
    _npos = 0;
    _tipoop = CPLib.Space(1);
    _riga1_2 = CPLib.Space(20);
    _riga1_3 = CPLib.Space(20);
    _coddip = CPLib.Space(6);
    _uniquecode = CPLib.Space(10);
    _riga1_5 = CPLib.Space(20);
    _datope = CPLib.NullDate();
    _riga1_6 = CPLib.Space(20);
    _riga1_7 = CPLib.Space(20);
    _riga1_8 = CPLib.Space(20);
    _impstr = CPLib.Space(20);
    _importo = 0;
    _riga2_1 = CPLib.Space(20);
    _riga2_2 = CPLib.Space(20);
    _riga2_3 = CPLib.Space(20);
    _riga2_4 = CPLib.Space(20);
    _riga2_5 = CPLib.Space(20);
    _riga2_6 = CPLib.Space(20);
    _riga2_7 = CPLib.Space(20);
    _riga2_8 = CPLib.Space(20);
    _riga2_9 = CPLib.Space(20);
    _riga2_10 = CPLib.Space(20);
    _riga2_11 = CPLib.Space(20);
    _riga2_12 = CPLib.Space(20);
    _statodest = CPLib.Space(3);
    _isodest = CPLib.Space(3);
    _riga3_1 = CPLib.Space(20);
    _cognome = CPLib.Space(26);
    _nome = CPLib.Space(25);
    _riga4_1 = CPLib.Space(20);
    _riga4_2 = CPLib.Space(20);
    _riga4_3 = CPLib.Space(20);
    _riga4_4 = CPLib.Space(20);
    _riga4_5 = CPLib.Space(20);
    _riga4_6 = CPLib.Space(20);
    _riga4_7 = CPLib.Space(20);
    _citta = CPLib.Space(40);
    _cap = CPLib.Space(5);
    _via = CPLib.Space(35);
    _prov = CPLib.Space(2);
    _cab = CPLib.Space(6);
    _riga5_1 = CPLib.Space(20);
    _cognomecp = CPLib.Space(26);
    _nomecp = CPLib.Space(25);
    _riga6_1 = CPLib.Space(20);
    _riga6_2 = CPLib.Space(20);
    _riga6_3 = CPLib.Space(20);
    _riga6_4 = CPLib.Space(20);
    _pep = CPLib.Space(1);
    _sesso = CPLib.Space(1);
    _nascitta = CPLib.Space(30);
    _nasstato = CPLib.Space(30);
    _resstato = CPLib.Space(3);
    _nasprov = CPLib.Space(2);
    _nasdata = CPLib.NullDate();
    _riga6_5 = CPLib.Space(20);
    _riga6_6 = CPLib.Space(20);
    _riga6_7 = CPLib.Space(20);
    _riga6_8 = CPLib.Space(20);
    _riga6_9 = CPLib.Space(20);
    _riga6_10 = CPLib.Space(20);
    _riga6_11 = CPLib.Space(20);
    _riga7_1 = CPLib.Space(20);
    _riga7_2 = CPLib.Space(20);
    _riga7_3 = CPLib.Space(20);
    _tipodoc = CPLib.Space(20);
    _numdoc = CPLib.Space(20);
    _riga7_4 = CPLib.Space(20);
    _riga7_5 = CPLib.Space(20);
    _docril = CPLib.NullDate();
    _autril = CPLib.Space(30);
    _riga7_6 = CPLib.Space(20);
    _riga7_7 = CPLib.Space(20);
    _riga7_8 = CPLib.Space(20);
    _riga7_9 = CPLib.Space(20);
    _riga8_1 = CPLib.Space(20);
    _riga8_2 = CPLib.Space(20);
    _riga8_3 = CPLib.Space(20);
    _riga8_4 = CPLib.Space(20);
    _riga8_5 = CPLib.Space(20);
    _riga8_6 = CPLib.Space(20);
    _riga8_7 = CPLib.Space(20);
    _docsca = CPLib.NullDate();
    _codfis = CPLib.Space(16);
    _riga8_9 = CPLib.Space(20);
    _riga9_1 = CPLib.Space(20);
    _riga9_2 = CPLib.Space(20);
    _riga9_3 = CPLib.Space(20);
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
    _siglacit = CPLib.Space(4);
    _siglasta = CPLib.Space(4);
    _merr = CPLib.Space(100);
    _oldmac = CPLib.Space(5);
    _aggcli = 0;
    _tiperr = CPLib.Space(2);
    _intertip = CPLib.Space(2);
    _listerr = "";
    _tipope = CPLib.Space(2);
    _rapporto = CPLib.Space(25);
    _codinter = CPLib.Space(11);
    _citinter = CPLib.Space(30);
    _cabinter = CPLib.Space(6);
    _prvinter = CPLib.Space(2);
    _citdip = CPLib.Space(30);
    _cabdip = CPLib.Space(6);
    _provdip = CPLib.Space(2);
    _flgcont = CPLib.Space(1);
    _numtel = CPLib.Space(20);
    mcListaAge = new MemoryCursor_mcstringa_mcrdef();
    _codajw = CPLib.Space(10);
    _tipriga = CPLib.Space(1);
    _tplriga = CPLib.Space(8);
    foglio = 0;
    riga_letta = 0;
    _terminalid = CPLib.Space(4);
    _dip = CPLib.Space(6);
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
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdate,arfn_fdatetime,arfn_poscodfis,arrt_calccodfis_mt,
  public static final String i_InvokedRoutines = ",arfn_fdate,arfn_fdatetime,arfn_poscodfis,arrt_calccodfis_mt,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_000001C9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001D2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"kersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001E0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeoprig",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001E1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"opextrbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001F4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000203(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"kersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000218(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"PROGOPEX,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"opextrbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000238(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
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
  protected static String GetFieldsName_0000023E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000248(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000024E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000025A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
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
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000260(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000026A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
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
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000270(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000027B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"WUCODICE,";
    p_cSql = p_cSql+"WUNOMEFILE,";
    p_cSql = p_cSql+"WURIFMTCN,";
    p_cSql = p_cSql+"WUTIPOPE,";
    p_cSql = p_cSql+"WUCODDIP,";
    p_cSql = p_cSql+"WUDATOPE,";
    p_cSql = p_cSql+"WUIMPORTO,";
    p_cSql = p_cSql+"WUSTADES,";
    p_cSql = p_cSql+"WUNOMCLI,";
    p_cSql = p_cSql+"WUCOGCLI,";
    p_cSql = p_cSql+"WUCITCLI,";
    p_cSql = p_cSql+"WUCAPCLI,";
    p_cSql = p_cSql+"WUINDCLI,";
    p_cSql = p_cSql+"WUNOMCON,";
    p_cSql = p_cSql+"WUCOGCON,";
    p_cSql = p_cSql+"WUBCITCLI,";
    p_cSql = p_cSql+"WUBSTACLI,";
    p_cSql = p_cSql+"WUDATNAS,";
    p_cSql = p_cSql+"WUSEXCLI,";
    p_cSql = p_cSql+"WUCODFIS,";
    p_cSql = p_cSql+"WUTDOCCLI,";
    p_cSql = p_cSql+"WUNDOCCLI,";
    p_cSql = p_cSql+"WUADOCRIL,";
    p_cSql = p_cSql+"WURDOCCLI,";
    p_cSql = p_cSql+"WUSDOCCLI,";
    p_cSql = p_cSql+"WUTIPERR,";
    p_cSql = p_cSql+"WUFLGALL,";
    p_cSql = p_cSql+"WUCODMAGE,";
    p_cSql = p_cSql+"WUNOTE,";
    p_cSql = p_cSql+"WUFLGFRC,";
    p_cSql = p_cSql+"WUCODCLC,";
    p_cSql = p_cSql+"WUORIGCF,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wuchkimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000027E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"EICODICE,";
    p_cSql = p_cSql+"EICODMAG,";
    p_cSql = p_cSql+"EINOMFIL,";
    p_cSql = p_cSql+"EIMTCN,";
    p_cSql = p_cSql+"EIDATIMP,";
    p_cSql = p_cSql+"EITXTFLD,";
    p_cSql = p_cSql+"EIMSGERR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mtimperr",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000280(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"WUNOMEFILE,";
    p_cSql = p_cSql+"WURIFEMTCN,";
    p_cSql = p_cSql+"WUNCLIENTE,";
    p_cSql = p_cSql+"WUCODDIPEN,";
    p_cSql = p_cSql+"WUTIPESITO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_impwu",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000282(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"MTCODMAGE,";
    p_cSql = p_cSql+"MTNOMFIL,";
    p_cSql = p_cSql+"MTDATIMP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mtimport",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000029E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RWMACAGE,";
    p_cSql = p_cSql+"RWCODRAP,";
    p_cSql = p_cSql+"RWCODFIS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wurapporti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002A0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"MACODICE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002A1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"knarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002A5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
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
  protected static String GetFieldsName_000002A7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002AB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RWMACAGE,";
    p_cSql = p_cSql+"RWCODRAP,";
    p_cSql = p_cSql+"RWCODFIS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wurapporti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002AD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"MACODICE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002AE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"knarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002B2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
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
  protected static String GetFieldsName_000002B4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
}
