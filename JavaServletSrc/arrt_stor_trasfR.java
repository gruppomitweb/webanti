// * --- Area Manuale = BO - Header
// * --- arrt_stor_trasf
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
// import com.opencsv.CSVWriter;
import com.opencsv.CSVWriter;
import java.util.ArrayList;
// * --- Fine Area Manuale
public class arrt_stor_trasfR implements CallerWithObjs {
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
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_beneficfrz;
  public String m_cServer_beneficfrz;
  public String m_cPhName_beneficope;
  public String m_cServer_beneficope;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_dersonbo;
  public String m_cServer_dersonbo;
  public String m_cPhName_fiduciabo;
  public String m_cServer_fiduciabo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_garantbo;
  public String m_cServer_garantbo;
  public String m_cPhName_hapopebo;
  public String m_cServer_hapopebo;
  public String m_cPhName_hapotit;
  public String m_cServer_hapotit;
  public String m_cPhName_harantbo;
  public String m_cServer_harantbo;
  public String m_cPhName_helegabo;
  public String m_cServer_helegabo;
  public String m_cPhName_hnarapbo;
  public String m_cServer_hnarapbo;
  public String m_cPhName_hntestbo;
  public String m_cServer_hntestbo;
  public String m_cPhName_hntestit;
  public String m_cServer_hntestit;
  public String m_cPhName_hoginfo;
  public String m_cServer_hoginfo;
  public String m_cPhName_hogopebo;
  public String m_cServer_hogopebo;
  public String m_cPhName_hperazbo;
  public String m_cServer_hperazbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public String m_cPhName_japotit;
  public String m_cServer_japotit;
  public String m_cPhName_jarantbo;
  public String m_cServer_jarantbo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_jntestit;
  public String m_cServer_jntestit;
  public String m_cPhName_joginfo;
  public String m_cServer_joginfo;
  public String m_cPhName_jogopebo;
  public String m_cServer_jogopebo;
  public String m_cPhName_jperazbo;
  public String m_cServer_jperazbo;
  public String m_cPhName_kersonbo;
  public String m_cServer_kersonbo;
  public String m_cPhName_kperazbo;
  public String m_cServer_kperazbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_personbo_dip;
  public String m_cServer_personbo_dip;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
  public String m_cPhName_saldi_idp;
  public String m_cServer_saldi_idp;
  public String m_cPhName_soginfo;
  public String m_cServer_soginfo;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_statorap;
  public String m_cServer_statorap;
  public String m_cPhName_storicoxbrl;
  public String m_cServer_storicoxbrl;
  public String m_cPhName_storicoxbrl_dett;
  public String m_cServer_storicoxbrl_dett;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_waldi_idp;
  public String m_cServer_waldi_idp;
  public String m_cPhName_wapopebo;
  public String m_cServer_wapopebo;
  public String m_cPhName_wapotit;
  public String m_cServer_wapotit;
  public String m_cPhName_warantbo;
  public String m_cServer_warantbo;
  public String m_cPhName_welegabo;
  public String m_cServer_welegabo;
  public String m_cPhName_weneficfrz;
  public String m_cServer_weneficfrz;
  public String m_cPhName_weneficope;
  public String m_cServer_weneficope;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_wersonbo_agg;
  public String m_cServer_wersonbo_agg;
  public String m_cPhName_werzistifrz;
  public String m_cServer_werzistifrz;
  public String m_cPhName_werzistiope;
  public String m_cServer_werzistiope;
  public String m_cPhName_widuciabo;
  public String m_cServer_widuciabo;
  public String m_cPhName_wlientifrz;
  public String m_cServer_wlientifrz;
  public String m_cPhName_wlientiope;
  public String m_cServer_wlientiope;
  public String m_cPhName_wnarapbo;
  public String m_cServer_wnarapbo;
  public String m_cPhName_wntestbo;
  public String m_cServer_wntestbo;
  public String m_cPhName_wntestit;
  public String m_cServer_wntestit;
  public String m_cPhName_woginfo;
  public String m_cServer_woginfo;
  public String m_cPhName_wogopebo;
  public String m_cServer_wogopebo;
  public String m_cPhName_wogopefbo;
  public String m_cServer_wogopefbo;
  public String m_cPhName_wperazbo;
  public String m_cServer_wperazbo;
  public String m_cPhName_wraziobo;
  public String m_cServer_wraziobo;
  public String m_cPhName_wtatorap;
  public String m_cServer_wtatorap;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_xapotit;
  public String m_cServer_xapotit;
  public String m_cPhName_xarantbo;
  public String m_cServer_xarantbo;
  public String m_cPhName_xelegabo;
  public String m_cServer_xelegabo;
  public String m_cPhName_xeneficfrz;
  public String m_cServer_xeneficfrz;
  public String m_cPhName_xeneficope;
  public String m_cServer_xeneficope;
  public String m_cPhName_xerzistifrz;
  public String m_cServer_xerzistifrz;
  public String m_cPhName_xerzistiope;
  public String m_cServer_xerzistiope;
  public String m_cPhName_xiduciabo;
  public String m_cServer_xiduciabo;
  public String m_cPhName_xlientifrz;
  public String m_cServer_xlientifrz;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xntestit;
  public String m_cServer_xntestit;
  public String m_cPhName_xoginfo;
  public String m_cServer_xoginfo;
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_xogopefbo;
  public String m_cServer_xogopefbo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
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
  public String w_chi_chiama_la_routine;
  public String w_tipoope;
  public boolean w_anag_colleg;
  public String w_stampa;
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public java.sql.Date w_today_caller;
  public String w_chkAUI;
  public String w_chkAGE;
  public String gMsgProc;
  public String gMsgImp;
  public java.sql.Date gDatDel;
  public java.sql.Date gDatTra;
  public String gAzienda;
  public String gPathApp;
  public String gPathDoc;
  public java.sql.Date w_dadata;
  public java.sql.Date w_adata;
  public String _cdatini;
  public String _cdatfin;
  public String _cdataoggi;
  public String _cdatafine;
  public java.sql.Date _ddatini;
  public java.sql.Date _ddatfin;
  public java.sql.Date _dataoggi;
  public String _errore;
  public double _contaop;
  public double _contarow;
  public String _oldmsg;
  public String _stringa_appoggio;
  public String operfraz;
  public String w_codrap;
  public double w_numrec;
  public java.sql.Date _today;
  public boolean _isThereSomething;
  public boolean _isThereInfo;
  public MemoryCursor_mcopefrazstorico_mcrdef _mc_operazioni;
  public MemoryCursor_mcopefrazstorico_mcrdef _mc_frazionate;
  public MemoryCursor_qbe_storrap_vqr _mc_rapporti;
  public MemoryCursor_mcpersonstorico_mcrdef _mc_soggetti_pf;
  public MemoryCursor_mcpersonstorico_mcrdef _mc_soggetti_pnf;
  public MemoryCursor_intestit _mc_intestit;
  public MemoryCursor_rapotit _mc_rapotit;
  public String fhand;
  public String riga;
  public String nFile;
  public String outFileName;
  public String _paese;
  public String _prov;
  public String _segno;
  public String _nfile;
  public String _impope;
  public String _numope;
  public double _tot;
  public String _nomeFile;
  public String _str_init;
  public String _str_init_1;
  public MemoryCursorRow_mctabelle_mcrdef rowTabelle;
  public double _pers_count_pf;
  public double _pers_count_pnf;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_stor_trasf
  public int _x;
  public int _y;
  public int _righe;
  public int _cnt;
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
  public arrt_stor_trasfR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stor_trasf",m_Caller);
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
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
    m_cPhName_beneficfrz = p_ContextObject.GetPhName("beneficfrz");
    if (m_cPhName_beneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficfrz = m_cPhName_beneficfrz+" "+m_Ctx.GetWritePhName("beneficfrz");
    }
    m_cServer_beneficfrz = p_ContextObject.GetServer("beneficfrz");
    m_cPhName_beneficope = p_ContextObject.GetPhName("beneficope");
    if (m_cPhName_beneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficope = m_cPhName_beneficope+" "+m_Ctx.GetWritePhName("beneficope");
    }
    m_cServer_beneficope = p_ContextObject.GetServer("beneficope");
    m_cPhName_clientifrz = p_ContextObject.GetPhName("clientifrz");
    if (m_cPhName_clientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientifrz = m_cPhName_clientifrz+" "+m_Ctx.GetWritePhName("clientifrz");
    }
    m_cServer_clientifrz = p_ContextObject.GetServer("clientifrz");
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    if (m_cPhName_clientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientiope = m_cPhName_clientiope+" "+m_Ctx.GetWritePhName("clientiope");
    }
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_dersonbo = p_ContextObject.GetPhName("dersonbo");
    if (m_cPhName_dersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_dersonbo = m_cPhName_dersonbo+" "+m_Ctx.GetWritePhName("dersonbo");
    }
    m_cServer_dersonbo = p_ContextObject.GetServer("dersonbo");
    m_cPhName_fiduciabo = p_ContextObject.GetPhName("fiduciabo");
    if (m_cPhName_fiduciabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fiduciabo = m_cPhName_fiduciabo+" "+m_Ctx.GetWritePhName("fiduciabo");
    }
    m_cServer_fiduciabo = p_ContextObject.GetServer("fiduciabo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_garantbo = p_ContextObject.GetPhName("garantbo");
    if (m_cPhName_garantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_garantbo = m_cPhName_garantbo+" "+m_Ctx.GetWritePhName("garantbo");
    }
    m_cServer_garantbo = p_ContextObject.GetServer("garantbo");
    m_cPhName_hapopebo = p_ContextObject.GetPhName("hapopebo");
    if (m_cPhName_hapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_hapopebo = m_cPhName_hapopebo+" "+m_Ctx.GetWritePhName("hapopebo");
    }
    m_cServer_hapopebo = p_ContextObject.GetServer("hapopebo");
    m_cPhName_hapotit = p_ContextObject.GetPhName("hapotit");
    if (m_cPhName_hapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_hapotit = m_cPhName_hapotit+" "+m_Ctx.GetWritePhName("hapotit");
    }
    m_cServer_hapotit = p_ContextObject.GetServer("hapotit");
    m_cPhName_harantbo = p_ContextObject.GetPhName("harantbo");
    if (m_cPhName_harantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_harantbo = m_cPhName_harantbo+" "+m_Ctx.GetWritePhName("harantbo");
    }
    m_cServer_harantbo = p_ContextObject.GetServer("harantbo");
    m_cPhName_helegabo = p_ContextObject.GetPhName("helegabo");
    if (m_cPhName_helegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_helegabo = m_cPhName_helegabo+" "+m_Ctx.GetWritePhName("helegabo");
    }
    m_cServer_helegabo = p_ContextObject.GetServer("helegabo");
    m_cPhName_hnarapbo = p_ContextObject.GetPhName("hnarapbo");
    if (m_cPhName_hnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_hnarapbo = m_cPhName_hnarapbo+" "+m_Ctx.GetWritePhName("hnarapbo");
    }
    m_cServer_hnarapbo = p_ContextObject.GetServer("hnarapbo");
    m_cPhName_hntestbo = p_ContextObject.GetPhName("hntestbo");
    if (m_cPhName_hntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_hntestbo = m_cPhName_hntestbo+" "+m_Ctx.GetWritePhName("hntestbo");
    }
    m_cServer_hntestbo = p_ContextObject.GetServer("hntestbo");
    m_cPhName_hntestit = p_ContextObject.GetPhName("hntestit");
    if (m_cPhName_hntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_hntestit = m_cPhName_hntestit+" "+m_Ctx.GetWritePhName("hntestit");
    }
    m_cServer_hntestit = p_ContextObject.GetServer("hntestit");
    m_cPhName_hoginfo = p_ContextObject.GetPhName("hoginfo");
    if (m_cPhName_hoginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_hoginfo = m_cPhName_hoginfo+" "+m_Ctx.GetWritePhName("hoginfo");
    }
    m_cServer_hoginfo = p_ContextObject.GetServer("hoginfo");
    m_cPhName_hogopebo = p_ContextObject.GetPhName("hogopebo");
    if (m_cPhName_hogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_hogopebo = m_cPhName_hogopebo+" "+m_Ctx.GetWritePhName("hogopebo");
    }
    m_cServer_hogopebo = p_ContextObject.GetServer("hogopebo");
    m_cPhName_hperazbo = p_ContextObject.GetPhName("hperazbo");
    if (m_cPhName_hperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_hperazbo = m_cPhName_hperazbo+" "+m_Ctx.GetWritePhName("hperazbo");
    }
    m_cServer_hperazbo = p_ContextObject.GetServer("hperazbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_japopebo = p_ContextObject.GetPhName("japopebo");
    if (m_cPhName_japopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_japopebo = m_cPhName_japopebo+" "+m_Ctx.GetWritePhName("japopebo");
    }
    m_cServer_japopebo = p_ContextObject.GetServer("japopebo");
    m_cPhName_japotit = p_ContextObject.GetPhName("japotit");
    if (m_cPhName_japotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_japotit = m_cPhName_japotit+" "+m_Ctx.GetWritePhName("japotit");
    }
    m_cServer_japotit = p_ContextObject.GetServer("japotit");
    m_cPhName_jarantbo = p_ContextObject.GetPhName("jarantbo");
    if (m_cPhName_jarantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jarantbo = m_cPhName_jarantbo+" "+m_Ctx.GetWritePhName("jarantbo");
    }
    m_cServer_jarantbo = p_ContextObject.GetServer("jarantbo");
    m_cPhName_jelegabo = p_ContextObject.GetPhName("jelegabo");
    if (m_cPhName_jelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jelegabo = m_cPhName_jelegabo+" "+m_Ctx.GetWritePhName("jelegabo");
    }
    m_cServer_jelegabo = p_ContextObject.GetServer("jelegabo");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_jntestit = p_ContextObject.GetPhName("jntestit");
    if (m_cPhName_jntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestit = m_cPhName_jntestit+" "+m_Ctx.GetWritePhName("jntestit");
    }
    m_cServer_jntestit = p_ContextObject.GetServer("jntestit");
    m_cPhName_joginfo = p_ContextObject.GetPhName("joginfo");
    if (m_cPhName_joginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_joginfo = m_cPhName_joginfo+" "+m_Ctx.GetWritePhName("joginfo");
    }
    m_cServer_joginfo = p_ContextObject.GetServer("joginfo");
    m_cPhName_jogopebo = p_ContextObject.GetPhName("jogopebo");
    if (m_cPhName_jogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jogopebo = m_cPhName_jogopebo+" "+m_Ctx.GetWritePhName("jogopebo");
    }
    m_cServer_jogopebo = p_ContextObject.GetServer("jogopebo");
    m_cPhName_jperazbo = p_ContextObject.GetPhName("jperazbo");
    if (m_cPhName_jperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jperazbo = m_cPhName_jperazbo+" "+m_Ctx.GetWritePhName("jperazbo");
    }
    m_cServer_jperazbo = p_ContextObject.GetServer("jperazbo");
    m_cPhName_kersonbo = p_ContextObject.GetPhName("kersonbo");
    if (m_cPhName_kersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_kersonbo = m_cPhName_kersonbo+" "+m_Ctx.GetWritePhName("kersonbo");
    }
    m_cServer_kersonbo = p_ContextObject.GetServer("kersonbo");
    m_cPhName_kperazbo = p_ContextObject.GetPhName("kperazbo");
    if (m_cPhName_kperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_kperazbo = m_cPhName_kperazbo+" "+m_Ctx.GetWritePhName("kperazbo");
    }
    m_cServer_kperazbo = p_ContextObject.GetServer("kperazbo");
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
    m_cPhName_personbo_dip = p_ContextObject.GetPhName("personbo_dip");
    if (m_cPhName_personbo_dip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_dip = m_cPhName_personbo_dip+" "+m_Ctx.GetWritePhName("personbo_dip");
    }
    m_cServer_personbo_dip = p_ContextObject.GetServer("personbo_dip");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
    m_cPhName_saldi_idp = p_ContextObject.GetPhName("saldi_idp");
    if (m_cPhName_saldi_idp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_saldi_idp = m_cPhName_saldi_idp+" "+m_Ctx.GetWritePhName("saldi_idp");
    }
    m_cServer_saldi_idp = p_ContextObject.GetServer("saldi_idp");
    m_cPhName_soginfo = p_ContextObject.GetPhName("soginfo");
    if (m_cPhName_soginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_soginfo = m_cPhName_soginfo+" "+m_Ctx.GetWritePhName("soginfo");
    }
    m_cServer_soginfo = p_ContextObject.GetServer("soginfo");
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    if (m_cPhName_sogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopebo = m_cPhName_sogopebo+" "+m_Ctx.GetWritePhName("sogopebo");
    }
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_sogopefbo = p_ContextObject.GetPhName("sogopefbo");
    if (m_cPhName_sogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopefbo = m_cPhName_sogopefbo+" "+m_Ctx.GetWritePhName("sogopefbo");
    }
    m_cServer_sogopefbo = p_ContextObject.GetServer("sogopefbo");
    m_cPhName_statorap = p_ContextObject.GetPhName("statorap");
    if (m_cPhName_statorap.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_statorap = m_cPhName_statorap+" "+m_Ctx.GetWritePhName("statorap");
    }
    m_cServer_statorap = p_ContextObject.GetServer("statorap");
    m_cPhName_storicoxbrl = p_ContextObject.GetPhName("storicoxbrl");
    if (m_cPhName_storicoxbrl.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_storicoxbrl = m_cPhName_storicoxbrl+" "+m_Ctx.GetWritePhName("storicoxbrl");
    }
    m_cServer_storicoxbrl = p_ContextObject.GetServer("storicoxbrl");
    m_cPhName_storicoxbrl_dett = p_ContextObject.GetPhName("storicoxbrl_dett");
    if (m_cPhName_storicoxbrl_dett.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_storicoxbrl_dett = m_cPhName_storicoxbrl_dett+" "+m_Ctx.GetWritePhName("storicoxbrl_dett");
    }
    m_cServer_storicoxbrl_dett = p_ContextObject.GetServer("storicoxbrl_dett");
    m_cPhName_terzistifrz = p_ContextObject.GetPhName("terzistifrz");
    if (m_cPhName_terzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistifrz = m_cPhName_terzistifrz+" "+m_Ctx.GetWritePhName("terzistifrz");
    }
    m_cServer_terzistifrz = p_ContextObject.GetServer("terzistifrz");
    m_cPhName_terzistiope = p_ContextObject.GetPhName("terzistiope");
    if (m_cPhName_terzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistiope = m_cPhName_terzistiope+" "+m_Ctx.GetWritePhName("terzistiope");
    }
    m_cServer_terzistiope = p_ContextObject.GetServer("terzistiope");
    m_cPhName_waldi_idp = p_ContextObject.GetPhName("waldi_idp");
    if (m_cPhName_waldi_idp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_waldi_idp = m_cPhName_waldi_idp+" "+m_Ctx.GetWritePhName("waldi_idp");
    }
    m_cServer_waldi_idp = p_ContextObject.GetServer("waldi_idp");
    m_cPhName_wapopebo = p_ContextObject.GetPhName("wapopebo");
    if (m_cPhName_wapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wapopebo = m_cPhName_wapopebo+" "+m_Ctx.GetWritePhName("wapopebo");
    }
    m_cServer_wapopebo = p_ContextObject.GetServer("wapopebo");
    m_cPhName_wapotit = p_ContextObject.GetPhName("wapotit");
    if (m_cPhName_wapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wapotit = m_cPhName_wapotit+" "+m_Ctx.GetWritePhName("wapotit");
    }
    m_cServer_wapotit = p_ContextObject.GetServer("wapotit");
    m_cPhName_warantbo = p_ContextObject.GetPhName("warantbo");
    if (m_cPhName_warantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_warantbo = m_cPhName_warantbo+" "+m_Ctx.GetWritePhName("warantbo");
    }
    m_cServer_warantbo = p_ContextObject.GetServer("warantbo");
    m_cPhName_welegabo = p_ContextObject.GetPhName("welegabo");
    if (m_cPhName_welegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_welegabo = m_cPhName_welegabo+" "+m_Ctx.GetWritePhName("welegabo");
    }
    m_cServer_welegabo = p_ContextObject.GetServer("welegabo");
    m_cPhName_weneficfrz = p_ContextObject.GetPhName("weneficfrz");
    if (m_cPhName_weneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_weneficfrz = m_cPhName_weneficfrz+" "+m_Ctx.GetWritePhName("weneficfrz");
    }
    m_cServer_weneficfrz = p_ContextObject.GetServer("weneficfrz");
    m_cPhName_weneficope = p_ContextObject.GetPhName("weneficope");
    if (m_cPhName_weneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_weneficope = m_cPhName_weneficope+" "+m_Ctx.GetWritePhName("weneficope");
    }
    m_cServer_weneficope = p_ContextObject.GetServer("weneficope");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_wersonbo_agg = p_ContextObject.GetPhName("wersonbo_agg");
    if (m_cPhName_wersonbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo_agg = m_cPhName_wersonbo_agg+" "+m_Ctx.GetWritePhName("wersonbo_agg");
    }
    m_cServer_wersonbo_agg = p_ContextObject.GetServer("wersonbo_agg");
    m_cPhName_werzistifrz = p_ContextObject.GetPhName("werzistifrz");
    if (m_cPhName_werzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_werzistifrz = m_cPhName_werzistifrz+" "+m_Ctx.GetWritePhName("werzistifrz");
    }
    m_cServer_werzistifrz = p_ContextObject.GetServer("werzistifrz");
    m_cPhName_werzistiope = p_ContextObject.GetPhName("werzistiope");
    if (m_cPhName_werzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_werzistiope = m_cPhName_werzistiope+" "+m_Ctx.GetWritePhName("werzistiope");
    }
    m_cServer_werzistiope = p_ContextObject.GetServer("werzistiope");
    m_cPhName_widuciabo = p_ContextObject.GetPhName("widuciabo");
    if (m_cPhName_widuciabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_widuciabo = m_cPhName_widuciabo+" "+m_Ctx.GetWritePhName("widuciabo");
    }
    m_cServer_widuciabo = p_ContextObject.GetServer("widuciabo");
    m_cPhName_wlientifrz = p_ContextObject.GetPhName("wlientifrz");
    if (m_cPhName_wlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wlientifrz = m_cPhName_wlientifrz+" "+m_Ctx.GetWritePhName("wlientifrz");
    }
    m_cServer_wlientifrz = p_ContextObject.GetServer("wlientifrz");
    m_cPhName_wlientiope = p_ContextObject.GetPhName("wlientiope");
    if (m_cPhName_wlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wlientiope = m_cPhName_wlientiope+" "+m_Ctx.GetWritePhName("wlientiope");
    }
    m_cServer_wlientiope = p_ContextObject.GetServer("wlientiope");
    m_cPhName_wnarapbo = p_ContextObject.GetPhName("wnarapbo");
    if (m_cPhName_wnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wnarapbo = m_cPhName_wnarapbo+" "+m_Ctx.GetWritePhName("wnarapbo");
    }
    m_cServer_wnarapbo = p_ContextObject.GetServer("wnarapbo");
    m_cPhName_wntestbo = p_ContextObject.GetPhName("wntestbo");
    if (m_cPhName_wntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wntestbo = m_cPhName_wntestbo+" "+m_Ctx.GetWritePhName("wntestbo");
    }
    m_cServer_wntestbo = p_ContextObject.GetServer("wntestbo");
    m_cPhName_wntestit = p_ContextObject.GetPhName("wntestit");
    if (m_cPhName_wntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wntestit = m_cPhName_wntestit+" "+m_Ctx.GetWritePhName("wntestit");
    }
    m_cServer_wntestit = p_ContextObject.GetServer("wntestit");
    m_cPhName_woginfo = p_ContextObject.GetPhName("woginfo");
    if (m_cPhName_woginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_woginfo = m_cPhName_woginfo+" "+m_Ctx.GetWritePhName("woginfo");
    }
    m_cServer_woginfo = p_ContextObject.GetServer("woginfo");
    m_cPhName_wogopebo = p_ContextObject.GetPhName("wogopebo");
    if (m_cPhName_wogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wogopebo = m_cPhName_wogopebo+" "+m_Ctx.GetWritePhName("wogopebo");
    }
    m_cServer_wogopebo = p_ContextObject.GetServer("wogopebo");
    m_cPhName_wogopefbo = p_ContextObject.GetPhName("wogopefbo");
    if (m_cPhName_wogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wogopefbo = m_cPhName_wogopefbo+" "+m_Ctx.GetWritePhName("wogopefbo");
    }
    m_cServer_wogopefbo = p_ContextObject.GetServer("wogopefbo");
    m_cPhName_wperazbo = p_ContextObject.GetPhName("wperazbo");
    if (m_cPhName_wperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wperazbo = m_cPhName_wperazbo+" "+m_Ctx.GetWritePhName("wperazbo");
    }
    m_cServer_wperazbo = p_ContextObject.GetServer("wperazbo");
    m_cPhName_wraziobo = p_ContextObject.GetPhName("wraziobo");
    if (m_cPhName_wraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wraziobo = m_cPhName_wraziobo+" "+m_Ctx.GetWritePhName("wraziobo");
    }
    m_cServer_wraziobo = p_ContextObject.GetServer("wraziobo");
    m_cPhName_wtatorap = p_ContextObject.GetPhName("wtatorap");
    if (m_cPhName_wtatorap.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wtatorap = m_cPhName_wtatorap+" "+m_Ctx.GetWritePhName("wtatorap");
    }
    m_cServer_wtatorap = p_ContextObject.GetServer("wtatorap");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_xapotit = p_ContextObject.GetPhName("xapotit");
    if (m_cPhName_xapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapotit = m_cPhName_xapotit+" "+m_Ctx.GetWritePhName("xapotit");
    }
    m_cServer_xapotit = p_ContextObject.GetServer("xapotit");
    m_cPhName_xarantbo = p_ContextObject.GetPhName("xarantbo");
    if (m_cPhName_xarantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xarantbo = m_cPhName_xarantbo+" "+m_Ctx.GetWritePhName("xarantbo");
    }
    m_cServer_xarantbo = p_ContextObject.GetServer("xarantbo");
    m_cPhName_xelegabo = p_ContextObject.GetPhName("xelegabo");
    if (m_cPhName_xelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xelegabo = m_cPhName_xelegabo+" "+m_Ctx.GetWritePhName("xelegabo");
    }
    m_cServer_xelegabo = p_ContextObject.GetServer("xelegabo");
    m_cPhName_xeneficfrz = p_ContextObject.GetPhName("xeneficfrz");
    if (m_cPhName_xeneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficfrz = m_cPhName_xeneficfrz+" "+m_Ctx.GetWritePhName("xeneficfrz");
    }
    m_cServer_xeneficfrz = p_ContextObject.GetServer("xeneficfrz");
    m_cPhName_xeneficope = p_ContextObject.GetPhName("xeneficope");
    if (m_cPhName_xeneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficope = m_cPhName_xeneficope+" "+m_Ctx.GetWritePhName("xeneficope");
    }
    m_cServer_xeneficope = p_ContextObject.GetServer("xeneficope");
    m_cPhName_xerzistifrz = p_ContextObject.GetPhName("xerzistifrz");
    if (m_cPhName_xerzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistifrz = m_cPhName_xerzistifrz+" "+m_Ctx.GetWritePhName("xerzistifrz");
    }
    m_cServer_xerzistifrz = p_ContextObject.GetServer("xerzistifrz");
    m_cPhName_xerzistiope = p_ContextObject.GetPhName("xerzistiope");
    if (m_cPhName_xerzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistiope = m_cPhName_xerzistiope+" "+m_Ctx.GetWritePhName("xerzistiope");
    }
    m_cServer_xerzistiope = p_ContextObject.GetServer("xerzistiope");
    m_cPhName_xiduciabo = p_ContextObject.GetPhName("xiduciabo");
    if (m_cPhName_xiduciabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xiduciabo = m_cPhName_xiduciabo+" "+m_Ctx.GetWritePhName("xiduciabo");
    }
    m_cServer_xiduciabo = p_ContextObject.GetServer("xiduciabo");
    m_cPhName_xlientifrz = p_ContextObject.GetPhName("xlientifrz");
    if (m_cPhName_xlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientifrz = m_cPhName_xlientifrz+" "+m_Ctx.GetWritePhName("xlientifrz");
    }
    m_cServer_xlientifrz = p_ContextObject.GetServer("xlientifrz");
    m_cPhName_xlientiope = p_ContextObject.GetPhName("xlientiope");
    if (m_cPhName_xlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientiope = m_cPhName_xlientiope+" "+m_Ctx.GetWritePhName("xlientiope");
    }
    m_cServer_xlientiope = p_ContextObject.GetServer("xlientiope");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_xntestit = p_ContextObject.GetPhName("xntestit");
    if (m_cPhName_xntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestit = m_cPhName_xntestit+" "+m_Ctx.GetWritePhName("xntestit");
    }
    m_cServer_xntestit = p_ContextObject.GetServer("xntestit");
    m_cPhName_xoginfo = p_ContextObject.GetPhName("xoginfo");
    if (m_cPhName_xoginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xoginfo = m_cPhName_xoginfo+" "+m_Ctx.GetWritePhName("xoginfo");
    }
    m_cServer_xoginfo = p_ContextObject.GetServer("xoginfo");
    m_cPhName_xogopebo = p_ContextObject.GetPhName("xogopebo");
    if (m_cPhName_xogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xogopebo = m_cPhName_xogopebo+" "+m_Ctx.GetWritePhName("xogopebo");
    }
    m_cServer_xogopebo = p_ContextObject.GetServer("xogopebo");
    m_cPhName_xogopefbo = p_ContextObject.GetPhName("xogopefbo");
    if (m_cPhName_xogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xogopefbo = m_cPhName_xogopefbo+" "+m_Ctx.GetWritePhName("xogopefbo");
    }
    m_cServer_xogopefbo = p_ContextObject.GetServer("xogopefbo");
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
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_contaop",p_cVarName)) {
      return _contaop;
    }
    if (CPLib.eqr("_contarow",p_cVarName)) {
      return _contarow;
    }
    if (CPLib.eqr("numrec",p_cVarName)) {
      return w_numrec;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_pers_count_pf",p_cVarName)) {
      return _pers_count_pf;
    }
    if (CPLib.eqr("_pers_count_pnf",p_cVarName)) {
      return _pers_count_pnf;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_stor_trasf";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("chi_chiama_la_routine",p_cVarName)) {
      return w_chi_chiama_la_routine;
    }
    if (CPLib.eqr("tipoope",p_cVarName)) {
      return w_tipoope;
    }
    if (CPLib.eqr("stampa",p_cVarName)) {
      return w_stampa;
    }
    if (CPLib.eqr("chkAUI",p_cVarName)) {
      return w_chkAUI;
    }
    if (CPLib.eqr("chkAGE",p_cVarName)) {
      return w_chkAGE;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
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
    if (CPLib.eqr("_cdatini",p_cVarName)) {
      return _cdatini;
    }
    if (CPLib.eqr("_cdatfin",p_cVarName)) {
      return _cdatfin;
    }
    if (CPLib.eqr("_cdataoggi",p_cVarName)) {
      return _cdataoggi;
    }
    if (CPLib.eqr("_cdatafine",p_cVarName)) {
      return _cdatafine;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    if (CPLib.eqr("_stringa_appoggio",p_cVarName)) {
      return _stringa_appoggio;
    }
    if (CPLib.eqr("operfraz",p_cVarName)) {
      return operfraz;
    }
    if (CPLib.eqr("codrap",p_cVarName)) {
      return w_codrap;
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
    if (CPLib.eqr("_paese",p_cVarName)) {
      return _paese;
    }
    if (CPLib.eqr("_prov",p_cVarName)) {
      return _prov;
    }
    if (CPLib.eqr("_segno",p_cVarName)) {
      return _segno;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      return _nfile;
    }
    if (CPLib.eqr("_impope",p_cVarName)) {
      return _impope;
    }
    if (CPLib.eqr("_numope",p_cVarName)) {
      return _numope;
    }
    if (CPLib.eqr("_nomeFile",p_cVarName)) {
      return _nomeFile;
    }
    if (CPLib.eqr("_str_init",p_cVarName)) {
      return _str_init;
    }
    if (CPLib.eqr("_str_init_1",p_cVarName)) {
      return _str_init_1;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      return w_DaDatOpe;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      return w_ADatOpe;
    }
    if (CPLib.eqr("today_caller",p_cVarName)) {
      return w_today_caller;
    }
    if (CPLib.eqr("gDatDel",p_cVarName)) {
      return gDatDel;
    }
    if (CPLib.eqr("gDatTra",p_cVarName)) {
      return gDatTra;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      return w_dadata;
    }
    if (CPLib.eqr("adata",p_cVarName)) {
      return w_adata;
    }
    if (CPLib.eqr("_ddatini",p_cVarName)) {
      return _ddatini;
    }
    if (CPLib.eqr("_ddatfin",p_cVarName)) {
      return _ddatfin;
    }
    if (CPLib.eqr("_dataoggi",p_cVarName)) {
      return _dataoggi;
    }
    if (CPLib.eqr("_today",p_cVarName)) {
      return _today;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("anag_colleg",p_cVarName)) {
      return w_anag_colleg;
    }
    if (CPLib.eqr("_isThereSomething",p_cVarName)) {
      return _isThereSomething;
    }
    if (CPLib.eqr("_isThereInfo",p_cVarName)) {
      return _isThereInfo;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_mc_operazioni",p_cVarName)) {
      return _mc_operazioni;
    }
    if (CPLib.eqr("_mc_frazionate",p_cVarName)) {
      return _mc_frazionate;
    }
    if (CPLib.eqr("_mc_rapporti",p_cVarName)) {
      return _mc_rapporti;
    }
    if (CPLib.eqr("_mc_soggetti_pf",p_cVarName)) {
      return _mc_soggetti_pf;
    }
    if (CPLib.eqr("_mc_soggetti_pnf",p_cVarName)) {
      return _mc_soggetti_pnf;
    }
    if (CPLib.eqr("_mc_intestit",p_cVarName)) {
      return _mc_intestit;
    }
    if (CPLib.eqr("_mc_rapotit",p_cVarName)) {
      return _mc_rapotit;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowTabelle",p_cVarName)) {
      return rowTabelle;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_contaop",p_cVarName)) {
      _contaop = value;
      return;
    }
    if (CPLib.eqr("_contarow",p_cVarName)) {
      _contarow = value;
      return;
    }
    if (CPLib.eqr("numrec",p_cVarName)) {
      w_numrec = value;
      return;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
    if (CPLib.eqr("_pers_count_pf",p_cVarName)) {
      _pers_count_pf = value;
      return;
    }
    if (CPLib.eqr("_pers_count_pnf",p_cVarName)) {
      _pers_count_pnf = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("chi_chiama_la_routine",p_cVarName)) {
      w_chi_chiama_la_routine = value;
      return;
    }
    if (CPLib.eqr("tipoope",p_cVarName)) {
      w_tipoope = value;
      return;
    }
    if (CPLib.eqr("stampa",p_cVarName)) {
      w_stampa = value;
      return;
    }
    if (CPLib.eqr("chkAUI",p_cVarName)) {
      w_chkAUI = value;
      return;
    }
    if (CPLib.eqr("chkAGE",p_cVarName)) {
      w_chkAGE = value;
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
    if (CPLib.eqr("_cdatini",p_cVarName)) {
      _cdatini = value;
      return;
    }
    if (CPLib.eqr("_cdatfin",p_cVarName)) {
      _cdatfin = value;
      return;
    }
    if (CPLib.eqr("_cdataoggi",p_cVarName)) {
      _cdataoggi = value;
      return;
    }
    if (CPLib.eqr("_cdatafine",p_cVarName)) {
      _cdatafine = value;
      return;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      _errore = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
      return;
    }
    if (CPLib.eqr("_stringa_appoggio",p_cVarName)) {
      _stringa_appoggio = value;
      return;
    }
    if (CPLib.eqr("operfraz",p_cVarName)) {
      operfraz = value;
      return;
    }
    if (CPLib.eqr("codrap",p_cVarName)) {
      w_codrap = value;
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
    if (CPLib.eqr("_paese",p_cVarName)) {
      _paese = value;
      return;
    }
    if (CPLib.eqr("_prov",p_cVarName)) {
      _prov = value;
      return;
    }
    if (CPLib.eqr("_segno",p_cVarName)) {
      _segno = value;
      return;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      _nfile = value;
      return;
    }
    if (CPLib.eqr("_impope",p_cVarName)) {
      _impope = value;
      return;
    }
    if (CPLib.eqr("_numope",p_cVarName)) {
      _numope = value;
      return;
    }
    if (CPLib.eqr("_nomeFile",p_cVarName)) {
      _nomeFile = value;
      return;
    }
    if (CPLib.eqr("_str_init",p_cVarName)) {
      _str_init = value;
      return;
    }
    if (CPLib.eqr("_str_init_1",p_cVarName)) {
      _str_init_1 = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      w_DaDatOpe = value;
      return;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      w_ADatOpe = value;
      return;
    }
    if (CPLib.eqr("today_caller",p_cVarName)) {
      w_today_caller = value;
      return;
    }
    if (CPLib.eqr("gDatDel",p_cVarName)) {
      gDatDel = value;
      return;
    }
    if (CPLib.eqr("gDatTra",p_cVarName)) {
      gDatTra = value;
      return;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      w_dadata = value;
      return;
    }
    if (CPLib.eqr("adata",p_cVarName)) {
      w_adata = value;
      return;
    }
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
    if (CPLib.eqr("_today",p_cVarName)) {
      _today = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("anag_colleg",p_cVarName)) {
      w_anag_colleg = value;
      return;
    }
    if (CPLib.eqr("_isThereSomething",p_cVarName)) {
      _isThereSomething = value;
      return;
    }
    if (CPLib.eqr("_isThereInfo",p_cVarName)) {
      _isThereInfo = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowTabelle",p_cVarName)) {
      rowTabelle = (MemoryCursorRow_mctabelle_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("_mc_operazioni",p_cVarName)) {
      _mc_operazioni = (MemoryCursor_mcopefrazstorico_mcrdef)value;
      return;
    }
    if (CPLib.eqr("_mc_frazionate",p_cVarName)) {
      _mc_frazionate = (MemoryCursor_mcopefrazstorico_mcrdef)value;
      return;
    }
    if (CPLib.eqr("_mc_rapporti",p_cVarName)) {
      _mc_rapporti = (MemoryCursor_qbe_storrap_vqr)value;
      return;
    }
    if (CPLib.eqr("_mc_soggetti_pf",p_cVarName)) {
      _mc_soggetti_pf = (MemoryCursor_mcpersonstorico_mcrdef)value;
      return;
    }
    if (CPLib.eqr("_mc_soggetti_pnf",p_cVarName)) {
      _mc_soggetti_pnf = (MemoryCursor_mcpersonstorico_mcrdef)value;
      return;
    }
    if (CPLib.eqr("_mc_intestit",p_cVarName)) {
      _mc_intestit = (MemoryCursor_intestit)value;
      return;
    }
    if (CPLib.eqr("_mc_rapotit",p_cVarName)) {
      _mc_rapotit = (MemoryCursor_rapotit)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void page1() throws Exception {
    CPResultSet Cursor_operazbo=null;
    CPResultSet Cursor_wperazbo=null;
    CPResultSet Cursor_jperazbo=null;
    CPResultSet Cursor_hperazbo=null;
    CPResultSet Cursor_fraziobo=null;
    CPResultSet Cursor_wraziobo=null;
    try {
      /* w_chi_chiama_la_routine Char(0) // "AUI" o "STO" */
      /* w_tipoope Char(1) // T = Trasferimento  e C = Cancellazione */
      /* w_anag_colleg Bool // eliminazione anagrafiche collegate */
      /* w_stampa Char(1) // stampa elemco */
      /* w_DaDatOpe Date // parametro in ingresso */
      /* w_ADatOpe Date // parametro in ingresso */
      /* w_today_caller Date // data del chiamante */
      /* w_chkAUI Char(8) // Elabora AUI */
      /* w_chkAGE Char(8) // Elabora AUI */
      /* gMsgProc Memo // Messaggio */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gDatDel Date // Data Massima Cancellazione Operazioni */
      /* gDatTra Date // Data Massima Trasf a Storico */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
      /* w_dadata Date */
      /* w_adata Date */
      /* _cdatini Char(8) */
      /* _cdatfin Char(8) */
      /* _cdataoggi Char(8) */
      /* _cdatafine Char(10) */
      /* _ddatini Date */
      /* _ddatfin Date */
      /* _dataoggi Date */
      /* _errore Char(1) */
      /* _contaop Numeric(10, 0) */
      /* _contarow Numeric(15, 0) */
      /* _oldmsg Memo */
      /* _stringa_appoggio Memo */
      /* operfraz Char(0) */
      /* w_codrap Char(25) */
      /* w_numrec Numeric(3, 0) */
      /* _today Date */
      /* _isThereSomething Bool := False // Flag Generale */
      _isThereSomething = false;
      /* _isThereInfo Bool := False // Flag Secondario  */
      _isThereInfo = false;
      /* _mc_operazioni MemoryCursor(mcOpeFrazStorico.MCRDef) // Stampa operazioni */
      /* _mc_frazionate MemoryCursor(mcOpeFrazStorico.MCRDef) // Stampa frazionate */
      /* _mc_rapporti MemoryCursor(qbe_storrap.vqr) // Stampa rapporti */
      /* _mc_soggetti_pf MemoryCursor(mcPersonStorico.MCRDef) // Soggetti potenzialmente dangling */
      /* _mc_soggetti_pnf MemoryCursor(mcPersonStorico.MCRDef) // Soggetti potenzialmente dangling */
      /* _mc_intestit MemoryCursor(intestit) // Titolari Efettivi */
      /* _mc_rapotit MemoryCursor(rapotit) // Informazioni titolari effettivi */
      /* fhand Char(1) // Per gestione file */
      /* riga Memo */
      /* nFile Char(20) */
      /* outFileName Char(30) */
      /* _paese Char(2) */
      /* _prov Char(3) */
      /* _segno Char(3) */
      /* _nfile Char(120) */
      /* _impope Char(15) */
      /* _numope Char(10) */
      /* _tot Numeric(10, 0) */
      /* _nomeFile Char(0) */
      /* _str_init Char(0) */
      /* _str_init_1 Char(0) */
      /* rowTabelle Row(mcTabelle.MCRDef) */
      /* _errore := 'N' */
      _errore = "N";
      /* _today := Date() */
      _today = CPLib.Date();
      /* _ddatini := w_DaDatOpe // può essere vuota */
      _ddatini = w_DaDatOpe;
      /* _ddatfin := w_ADatOpe */
      _ddatfin = w_ADatOpe;
      /* _cdatini := DateToChar(_ddatini) */
      _cdatini = CPLib.DateToChar(_ddatini);
      /* _cdatfin := DateToChar(_ddatfin) */
      _cdatfin = CPLib.DateToChar(_ddatfin);
      /* _cdatafine := Left(_cdatfin,4)+"-"+Substr(_cdatfin,5,2)+"-"+Substr(_cdatfin,7,2) */
      _cdatafine = CPLib.Left(_cdatfin,4)+"-"+CPLib.Substr(_cdatfin,5,2)+"-"+CPLib.Substr(_cdatfin,7,2);
      /* gMsgProc := 'Ora Inizio Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _str_init := iif((w_chi_chiama_la_routine="AUI" and w_tipoope="T" ),"Trasferimento da AUI a Storico",iif((w_chi_chiama_la_routine="AUI" and w_tipoope="C"),"Cancellazione da AUI",iif((w_chi_chiama_la_routine="STO" and w_tipoope="C"),"Cancellazione da Storico","Parametri di chiamata non validi!"+NL+"Contattare l'assistenza" ))) */
      _str_init = ((CPLib.eqr(w_chi_chiama_la_routine,"AUI") && CPLib.eqr(w_tipoope,"T"))?"Trasferimento da AUI a Storico":((CPLib.eqr(w_chi_chiama_la_routine,"AUI") && CPLib.eqr(w_tipoope,"C"))?"Cancellazione da AUI":((CPLib.eqr(w_chi_chiama_la_routine,"STO") && CPLib.eqr(w_tipoope,"C"))?"Cancellazione da Storico":"Parametri di chiamata non validi!"+"\n"+"Contattare l'assistenza")));
      /* gMsgProc := gMsgProc+_str_init */
      gMsgProc = gMsgProc+_str_init;
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _str_init_1 := " da Data: "+iif(Empty(w_DaDatOpe),"-non settata-",w_DaDatOpe)+" a Data: "+w_ADatOpe+iif(w_anag_colleg," con cancellazione anagrafiche collegate","") */
      _str_init_1 = " da Data: "+(CPLib.Empty(w_DaDatOpe)?"-non settata-":w_DaDatOpe)+" a Data: "+w_ADatOpe+(w_anag_colleg?" con cancellazione anagrafiche collegate":"");
      /* gMsgProc := gMsgProc+_str_init_1+", stampa elenco: "+iif(At(w_stampa,"|R|S") > 0,"SI","NO")+NL */
      gMsgProc = gMsgProc+_str_init_1+", stampa elenco: "+(CPLib.gt(CPLib.At(w_stampa,"|R|S"),0)?"SI":"NO")+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If False */
      if (false) {
        /* If DateDiff(_today, w_today_caller)<>0 */
        if (CPLib.ne(CPLib.DateDiff(_today,w_today_caller),0)) {
          /* _errore := 'S' */
          _errore = "S";
          /* gMsgProc := "La data del server differisce dalla data del client. Contattare l'assistenza" */
          gMsgProc = "La data del server differisce dalla data del client. Contattare l'assistenza";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* ElseIf Empty(w_ADatOpe) */
        } else if (CPLib.Empty(w_ADatOpe)) {
          /* _errore := 'S' */
          _errore = "S";
          /* gMsgProc := 'La data di fine periodo non può essere vuota' */
          gMsgProc = "La data di fine periodo non può essere vuota";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* ElseIf w_tipoope='T' and w_ADatOpe > gDatTra */
        } else if (CPLib.eqr(w_tipoope,"T") && CPLib.gt(w_ADatOpe,gDatTra)) {
          /* _errore := 'S' */
          _errore = "S";
          /* gMsgProc := 'La data di fine periodo non può essere superiore alla data massima di trasferimento ('+arfn_fdate(gDatTra)+')' */
          gMsgProc = "La data di fine periodo non può essere superiore alla data massima di trasferimento ("+arfn_fdateR.Make(m_Ctx,this).Run(gDatTra)+")";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* ElseIf w_tipoope='C' and w_ADatOpe > gDatDel */
        } else if (CPLib.eqr(w_tipoope,"C") && CPLib.gt(w_ADatOpe,gDatDel)) {
          /* _errore := 'S' */
          _errore = "S";
          /* gMsgProc := 'La data di fine periodo non può essere superiore alla data massima di cancellazione ('+arfn_fdate(gDatDel)+')' */
          gMsgProc = "La data di fine periodo non può essere superiore alla data massima di cancellazione ("+arfn_fdateR.Make(m_Ctx,this).Run(gDatDel)+")";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
      } // End If
      /* If _errore="N" */
      if (CPLib.eqr(_errore,"N")) {
        /* Exec "Controllo presenza dati nelle tabelle accessorie" Page 9:chktab */
        chktab();
        /* _isThereSomething := False */
        _isThereSomething = false;
        /* If w_chkAUI='S' */
        if (CPLib.eqr(w_chkAUI,"S")) {
          /* If w_chi_chiama_la_routine="AUI" */
          if (CPLib.eqr(w_chi_chiama_la_routine,"AUI")) {
            /* If Empty(_ddatini) */
            if (CPLib.Empty(_ddatini)) {
              // * --- Select from operazbo
              m_cServer = m_Ctx.GetServer("operazbo");
              m_cPhName = m_Ctx.GetPhName("operazbo");
              if (Cursor_operazbo!=null)
                Cursor_operazbo.Close();
              Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CDATREG<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatfin)+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAREG ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_operazbo.Eof())) {
                /* _ddatini := operazbo->DATAREG */
                _ddatini = Cursor_operazbo.GetDate("DATAREG");
                /* _isThereSomething := True */
                _isThereSomething = true;
                // Exit Loop
                if (true) {
                  break;
                }
                Cursor_operazbo.Next();
              }
              m_cConnectivityError = Cursor_operazbo.ErrorMessage();
              Cursor_operazbo.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from operazbo
              m_cServer = m_Ctx.GetServer("operazbo");
              m_cPhName = m_Ctx.GetPhName("operazbo");
              if (Cursor_operazbo!=null)
                Cursor_operazbo.Close();
              Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CDATREG>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatini)+"  and  CDATREG<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatfin)+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAREG ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_operazbo.Eof())) {
                /* _ddatini := operazbo->DATAREG */
                _ddatini = Cursor_operazbo.GetDate("DATAREG");
                /* _isThereSomething := True */
                _isThereSomething = true;
                // Exit Loop
                if (true) {
                  break;
                }
                Cursor_operazbo.Next();
              }
              m_cConnectivityError = Cursor_operazbo.ErrorMessage();
              Cursor_operazbo.Close();
              // * --- End Select
            } // End If
            /* ElseIf w_chi_chiama_la_routine="STO" */
          } else if (CPLib.eqr(w_chi_chiama_la_routine,"STO")) {
            /* If Empty(_ddatini) */
            if (CPLib.Empty(_ddatini)) {
              // * --- Select from wperazbo
              m_cServer = m_Ctx.GetServer("wperazbo");
              m_cPhName = m_Ctx.GetPhName("wperazbo");
              if (Cursor_wperazbo!=null)
                Cursor_wperazbo.Close();
              Cursor_wperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CDATREG<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatfin)+" "+")"+(m_Ctx.IsSharedTemp("wperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAREG ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_wperazbo.Eof())) {
                /* _ddatini := wperazbo->DATAREG */
                _ddatini = Cursor_wperazbo.GetDate("DATAREG");
                /* _isThereSomething := True */
                _isThereSomething = true;
                // Exit Loop
                if (true) {
                  break;
                }
                Cursor_wperazbo.Next();
              }
              m_cConnectivityError = Cursor_wperazbo.ErrorMessage();
              Cursor_wperazbo.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from wperazbo
              m_cServer = m_Ctx.GetServer("wperazbo");
              m_cPhName = m_Ctx.GetPhName("wperazbo");
              if (Cursor_wperazbo!=null)
                Cursor_wperazbo.Close();
              Cursor_wperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CDATREG>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatini)+"  and  CDATREG<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatfin)+" "+")"+(m_Ctx.IsSharedTemp("wperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAREG ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_wperazbo.Eof())) {
                /* _ddatini := wperazbo->DATAREG */
                _ddatini = Cursor_wperazbo.GetDate("DATAREG");
                /* _isThereSomething := True */
                _isThereSomething = true;
                // Exit Loop
                if (true) {
                  break;
                }
                Cursor_wperazbo.Next();
              }
              m_cConnectivityError = Cursor_wperazbo.ErrorMessage();
              Cursor_wperazbo.Close();
              // * --- End Select
            } // End If
          } // End If
        } // End If
        /* If w_chkAGE='S' */
        if (CPLib.eqr(w_chkAGE,"S")) {
          /* If w_chi_chiama_la_routine="AUI" */
          if (CPLib.eqr(w_chi_chiama_la_routine,"AUI")) {
            /* If Empty(_ddatini) */
            if (CPLib.Empty(_ddatini)) {
              // * --- Select from jperazbo
              m_cServer = m_Ctx.GetServer("jperazbo");
              m_cPhName = m_Ctx.GetPhName("jperazbo");
              if (Cursor_jperazbo!=null)
                Cursor_jperazbo.Close();
              Cursor_jperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CDATREG<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatfin)+" "+")"+(m_Ctx.IsSharedTemp("jperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAREG ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_jperazbo.Eof())) {
                /* _ddatini := jperazbo->DATAREG */
                _ddatini = Cursor_jperazbo.GetDate("DATAREG");
                /* _isThereSomething := True */
                _isThereSomething = true;
                // Exit Loop
                if (true) {
                  break;
                }
                Cursor_jperazbo.Next();
              }
              m_cConnectivityError = Cursor_jperazbo.ErrorMessage();
              Cursor_jperazbo.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from jperazbo
              m_cServer = m_Ctx.GetServer("jperazbo");
              m_cPhName = m_Ctx.GetPhName("jperazbo");
              if (Cursor_jperazbo!=null)
                Cursor_jperazbo.Close();
              Cursor_jperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CDATREG>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatini)+"  and  CDATREG<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatfin)+" "+")"+(m_Ctx.IsSharedTemp("jperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAREG ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_jperazbo.Eof())) {
                /* _ddatini := jperazbo->DATAREG */
                _ddatini = Cursor_jperazbo.GetDate("DATAREG");
                /* _isThereSomething := True */
                _isThereSomething = true;
                // Exit Loop
                if (true) {
                  break;
                }
                Cursor_jperazbo.Next();
              }
              m_cConnectivityError = Cursor_jperazbo.ErrorMessage();
              Cursor_jperazbo.Close();
              // * --- End Select
            } // End If
            /* ElseIf w_chi_chiama_la_routine="STO" */
          } else if (CPLib.eqr(w_chi_chiama_la_routine,"STO")) {
            /* If Empty(_ddatini) */
            if (CPLib.Empty(_ddatini)) {
              // * --- Select from hperazbo
              m_cServer = m_Ctx.GetServer("hperazbo");
              m_cPhName = m_Ctx.GetPhName("hperazbo");
              if (Cursor_hperazbo!=null)
                Cursor_hperazbo.Close();
              Cursor_hperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CDATREG<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatfin)+" "+")"+(m_Ctx.IsSharedTemp("hperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAREG ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_hperazbo.Eof())) {
                /* _ddatini := hperazbo->DATAREG */
                _ddatini = Cursor_hperazbo.GetDate("DATAREG");
                /* _isThereSomething := True */
                _isThereSomething = true;
                // Exit Loop
                if (true) {
                  break;
                }
                Cursor_hperazbo.Next();
              }
              m_cConnectivityError = Cursor_hperazbo.ErrorMessage();
              Cursor_hperazbo.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from hperazbo
              m_cServer = m_Ctx.GetServer("hperazbo");
              m_cPhName = m_Ctx.GetPhName("hperazbo");
              if (Cursor_hperazbo!=null)
                Cursor_hperazbo.Close();
              Cursor_hperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CDATREG>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatini)+"  and  CDATREG<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatfin)+" "+")"+(m_Ctx.IsSharedTemp("hperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAREG ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_hperazbo.Eof())) {
                /* _ddatini := hperazbo->DATAREG */
                _ddatini = Cursor_hperazbo.GetDate("DATAREG");
                /* _isThereSomething := True */
                _isThereSomething = true;
                // Exit Loop
                if (true) {
                  break;
                }
                Cursor_hperazbo.Next();
              }
              m_cConnectivityError = Cursor_hperazbo.ErrorMessage();
              Cursor_hperazbo.Close();
              // * --- End Select
            } // End If
          } // End If
        } // End If
        /* If not(_isThereSomething) */
        if ( ! (_isThereSomething)) {
          /* gMsgProc := gMsgProc + 'Non ci sono Operazioni da trasferire/cancellare nel periodo selezionato'+NL */
          gMsgProc = gMsgProc+"Non ci sono Operazioni da trasferire/cancellare nel periodo selezionato"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* gMsgProc := gMsgProc + 'Data inizio Operazioni calcolata: '+_ddatini+NL */
          gMsgProc = gMsgProc+"Data inizio Operazioni calcolata: "+_ddatini+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* _cdatini := DateToChar(_ddatini) */
          _cdatini = CPLib.DateToChar(_ddatini);
          /* operfraz := 'O' */
          operfraz = "O";
          /* If w_chkAUI='S' */
          if (CPLib.eqr(w_chkAUI,"S")) {
            /* Exec "Operazioni/Frazionate" Page 2:ope_fraz */
            ope_fraz();
          } // End If
          /* If w_chkAGE='S' */
          if (CPLib.eqr(w_chkAGE,"S")) {
            /* Exec "Operazioni/Frazionate" Page 2:ope_fraz */
            ope_fraz();
          } // End If
        } // End If
        /* _isThereSomething := False */
        _isThereSomething = false;
        /* _ddatini := w_DaDatOpe // potrebbe contenere la data inizio delle Operazioni (va ripulita) */
        _ddatini = w_DaDatOpe;
        /* _isThereSomething := False */
        _isThereSomething = false;
        /* If w_chkAUI='S' */
        if (CPLib.eqr(w_chkAUI,"S")) {
          /* If w_chi_chiama_la_routine="AUI" */
          if (CPLib.eqr(w_chi_chiama_la_routine,"AUI")) {
            /* If Empty(_ddatini) */
            if (CPLib.Empty(_ddatini)) {
              // * --- Select from fraziobo
              m_cServer = m_Ctx.GetServer("fraziobo");
              m_cPhName = m_Ctx.GetPhName("fraziobo");
              if (Cursor_fraziobo!=null)
                Cursor_fraziobo.Close();
              Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAREG<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatfin)+" "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAREG ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_fraziobo.Eof())) {
                /* _ddatini := fraziobo->DATAREG */
                _ddatini = Cursor_fraziobo.GetDate("DATAREG");
                /* _isThereSomething := True */
                _isThereSomething = true;
                // Exit Loop
                if (true) {
                  break;
                }
                Cursor_fraziobo.Next();
              }
              m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
              Cursor_fraziobo.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from fraziobo
              m_cServer = m_Ctx.GetServer("fraziobo");
              m_cPhName = m_Ctx.GetPhName("fraziobo");
              if (Cursor_fraziobo!=null)
                Cursor_fraziobo.Close();
              Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAREG>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatini)+"  and  DATAREG<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatfin)+" "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAREG ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_fraziobo.Eof())) {
                /* _ddatini := fraziobo->DATAREG */
                _ddatini = Cursor_fraziobo.GetDate("DATAREG");
                /* _isThereSomething := True */
                _isThereSomething = true;
                // Exit Loop
                if (true) {
                  break;
                }
                Cursor_fraziobo.Next();
              }
              m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
              Cursor_fraziobo.Close();
              // * --- End Select
            } // End If
            /* ElseIf w_chi_chiama_la_routine="STO" */
          } else if (CPLib.eqr(w_chi_chiama_la_routine,"STO")) {
            /* If Empty(_ddatini) */
            if (CPLib.Empty(_ddatini)) {
              // * --- Select from wraziobo
              m_cServer = m_Ctx.GetServer("wraziobo");
              m_cPhName = m_Ctx.GetPhName("wraziobo");
              if (Cursor_wraziobo!=null)
                Cursor_wraziobo.Close();
              Cursor_wraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAREG<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatfin)+" "+")"+(m_Ctx.IsSharedTemp("wraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAREG ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_wraziobo.Eof())) {
                /* _ddatini := wraziobo->DATAREG */
                _ddatini = Cursor_wraziobo.GetDate("DATAREG");
                /* _isThereSomething := True */
                _isThereSomething = true;
                // Exit Loop
                if (true) {
                  break;
                }
                Cursor_wraziobo.Next();
              }
              m_cConnectivityError = Cursor_wraziobo.ErrorMessage();
              Cursor_wraziobo.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from wraziobo
              m_cServer = m_Ctx.GetServer("wraziobo");
              m_cPhName = m_Ctx.GetPhName("wraziobo");
              if (Cursor_wraziobo!=null)
                Cursor_wraziobo.Close();
              Cursor_wraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAREG>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatini)+"  and  DATAREG<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatfin)+" "+")"+(m_Ctx.IsSharedTemp("wraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAREG ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_wraziobo.Eof())) {
                /* _ddatini := wraziobo->DATAREG */
                _ddatini = Cursor_wraziobo.GetDate("DATAREG");
                /* _isThereSomething := True */
                _isThereSomething = true;
                // Exit Loop
                if (true) {
                  break;
                }
                Cursor_wraziobo.Next();
              }
              m_cConnectivityError = Cursor_wraziobo.ErrorMessage();
              Cursor_wraziobo.Close();
              // * --- End Select
            } // End If
          } // End If
        } // End If
        /* If not(_isThereSomething) */
        if ( ! (_isThereSomething)) {
          /* gMsgProc := gMsgProc + 'Non ci sono Frazionate da trasferire/cancellare nel periodo selezionato'+NL */
          gMsgProc = gMsgProc+"Non ci sono Frazionate da trasferire/cancellare nel periodo selezionato"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* operfraz := 'F' */
          operfraz = "F";
          /* gMsgProc := gMsgProc + 'Data inizio Frazionate calcolata: '+_ddatini+NL */
          gMsgProc = gMsgProc+"Data inizio Frazionate calcolata: "+_ddatini+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* _cdatini := DateToChar(_ddatini) */
          _cdatini = CPLib.DateToChar(_ddatini);
          /* If w_chkAUI='S' */
          if (CPLib.eqr(w_chkAUI,"S")) {
            /* Exec "Operazioni/Frazionate" Page 2:ope_fraz */
            ope_fraz();
          } // End If
        } // End If
        /* _isThereSomething := False */
        _isThereSomething = false;
        /* _ddatini := w_DaDatOpe // potrebbe contenere la data inizio delle Frazionate(va ripulita) */
        _ddatini = w_DaDatOpe;
        /* If w_chkAUI='S' */
        if (CPLib.eqr(w_chkAUI,"S")) {
          /* Exec "Rapporti" Page 3:rap */
          rap();
        } // End If
        /* If w_chkAGE='S' */
        if (CPLib.eqr(w_chkAGE,"S")) {
          /* Exec "Rapporti" Page 3:rap */
          rap();
        } // End If
        /* If w_chkAUI='S' */
        if (CPLib.eqr(w_chkAUI,"S")) {
          /* Exec "Titolari Effettivi" Page 8:titolari */
          titolari();
        } // End If
        /* If w_chkAGE='S' */
        if (CPLib.eqr(w_chkAGE,"S")) {
          /* Exec "Titolari Agenzia Entrate" Page 12:tit_age */
          tit_age();
        } // End If
        /* If w_anag_colleg and w_tipoope='C' */
        if (w_anag_colleg && CPLib.eqr(w_tipoope,"C")) {
          /* Exec "Anagrafiche" Page 4:anag */
          anag();
        } // End If
        /* If At(w_stampa,'|R|S') > 0 */
        if (CPLib.gt(CPLib.At(w_stampa,"|R|S"),0)) {
          /* Exec "Stampa" Page 7:print_xlsx */
          print_xlsx();
          /* gMsgProc := gMsgProc + 'Fine Elaborazione'+NL */
          gMsgProc = gMsgProc+"Fine Elaborazione"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgImp := "Fine Elaborazione - Prelevare il file da bottone nuvolina" */
          gMsgImp = "Fine Elaborazione - Prelevare il file da bottone nuvolina";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* Return _nomeFile */
          throw new Stop(_nomeFile);
        } else { // Else
          /* gMsgProc := gMsgProc + 'Fine Elaborazione'+NL */
          gMsgProc = gMsgProc+"Fine Elaborazione"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgImp := "Fine Elaborazione" */
          gMsgImp = "Fine Elaborazione";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* Return "OK" */
          throw new Stop("OK");
        } // End If
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione:'+ arfn_fdatetime(DateTime()) */
      gMsgProc = gMsgProc+"Ora Fine Elaborazione:"+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := "Fine Elaborazione" */
      gMsgImp = "Fine Elaborazione";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Return "KO" */
      throw new Stop("KO");
    } finally {
      try {
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wperazbo!=null)
          Cursor_wperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jperazbo!=null)
          Cursor_jperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_hperazbo!=null)
          Cursor_hperazbo.Close();
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
        if (Cursor_wraziobo!=null)
          Cursor_wraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void ope_fraz() throws Exception {
    CPResultSet Cursor_operazbo=null;
    CPResultSet Cursor_fraziobo=null;
    CPResultSet Cursor_wperazbo=null;
    CPResultSet Cursor_wraziobo=null;
    CPResultSet Cursor_qbe_storope=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_beneficope=null;
    CPResultSet Cursor_terzistiope=null;
    CPResultSet Cursor_qbe_storwpe=null;
    CPResultSet Cursor_wogopebo=null;
    CPResultSet Cursor_wlientiope=null;
    CPResultSet Cursor_weneficope=null;
    CPResultSet Cursor_werzistiope=null;
    CPResultSet Cursor_qbe_storfraz=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_terzistifrz=null;
    CPResultSet Cursor_qbe_storwraz=null;
    CPResultSet Cursor_wogopefbo=null;
    CPResultSet Cursor_wlientifrz=null;
    CPResultSet Cursor_weneficfrz=null;
    CPResultSet Cursor_werzistifrz=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _stringa_appoggio := iif(operfraz='O'," operazioni", " frazionate") */
      _stringa_appoggio = (CPLib.eqr(operfraz,"O")?" operazioni":" frazionate");
      /* _dataoggi := _ddatini */
      _dataoggi = _ddatini;
      /* _cdataoggi := _cdatini */
      _cdataoggi = _cdatini;
      /* _oldmsg := '' */
      _oldmsg = "";
      /* _contarow := 0 */
      _contarow = CPLib.Round(0,0);
      /* _contaop := 0 */
      _contaop = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry000000CEstatus;
      nTry000000CEstatus = m_Sql.GetTransactionStatus();
      String cTry000000CEmsg;
      cTry000000CEmsg = m_Sql.TransactionErrorMessage();
      try {
        /* If At(w_stampa,"|R|S") > 0 */
        if (CPLib.gt(CPLib.At(w_stampa,"|R|S"),0)) {
          /* gMsgProc := gMsgProc + 'Precaricamento delle'+_stringa_appoggio+' per la stampa'+NL // Messaggio */
          gMsgProc = gMsgProc+"Precaricamento delle"+_stringa_appoggio+" per la stampa"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* Case w_chi_chiama_la_routine="AUI" */
          if (CPLib.eqr(w_chi_chiama_la_routine,"AUI")) {
            /* If operfraz='O' */
            if (CPLib.eqr(operfraz,"O")) {
              // * --- Select from operazbo
              m_cServer = m_Ctx.GetServer("operazbo");
              m_cPhName = m_Ctx.GetPhName("operazbo");
              if (Cursor_operazbo!=null)
                Cursor_operazbo.Close();
              Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CDATREG>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatini)+"  and  CDATREG<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatfin)+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_operazbo.Eof())) {
                /* _mc_operazioni.AppendBlank() // Stampa operazioni */
                _mc_operazioni.AppendBlank();
                /* _mc_operazioni.DATAOPE := operazbo->DATAOPE // Stampa operazioni */
                _mc_operazioni.row.DATAOPE = Cursor_operazbo.GetDate("DATAOPE");
                /* _mc_operazioni.NUMPROG := operazbo->NUMPROG // Stampa operazioni */
                _mc_operazioni.row.NUMPROG = Cursor_operazbo.GetString("NUMPROG");
                /* _mc_operazioni.DATAREG := operazbo->DATAREG // Stampa operazioni */
                _mc_operazioni.row.DATAREG = Cursor_operazbo.GetDate("DATAREG");
                /* _mc_operazioni.CAUSALE := operazbo->CODANA // Stampa operazioni */
                _mc_operazioni.row.CAUSALE = Cursor_operazbo.GetString("CODANA");
                /* _mc_operazioni.IMPORTO := operazbo->TOTLIRE // Stampa operazioni */
                _mc_operazioni.row.IMPORTO = Cursor_operazbo.GetDouble("TOTLIRE");
                /* _mc_operazioni.VALUTA := operazbo->VALUTA // Stampa operazioni */
                _mc_operazioni.row.VALUTA = Cursor_operazbo.GetString("VALUTA");
                /* _mc_operazioni.CONNESCLI := operazbo->CONNESCLI // Stampa operazioni */
                _mc_operazioni.row.CONNESCLI = Cursor_operazbo.GetString("CONNESCLI");
                /* _mc_operazioni.DESCRI := operazbo->RAPPORTO // Stampa operazioni */
                _mc_operazioni.row.DESCRI = Cursor_operazbo.GetString("RAPPORTO");
                /* _mc_operazioni.STATOREG := operazbo->STATOREG // Stampa operazioni */
                _mc_operazioni.row.STATOREG = Cursor_operazbo.GetString("STATOREG");
                /* _mc_operazioni.TIPOARCH := 'A' // Stampa operazioni */
                _mc_operazioni.row.TIPOARCH = "A";
                /* _mc_operazioni.SaveRow() // Stampa operazioni */
                _mc_operazioni.SaveRow();
                Cursor_operazbo.Next();
              }
              m_cConnectivityError = Cursor_operazbo.ErrorMessage();
              Cursor_operazbo.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from fraziobo
              m_cServer = m_Ctx.GetServer("fraziobo");
              m_cPhName = m_Ctx.GetPhName("fraziobo");
              if (Cursor_fraziobo!=null)
                Cursor_fraziobo.Close();
              Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CDATREG>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatini)+"  and  CDATREG<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatfin)+" "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_fraziobo.Eof())) {
                /* _mc_frazionate.AppendBlank() // Stampa frazionate */
                _mc_frazionate.AppendBlank();
                /* _mc_frazionate.DATAOPE := fraziobo->DATAOPE // Stampa operazioni */
                _mc_frazionate.row.DATAOPE = Cursor_fraziobo.GetDate("DATAOPE");
                /* _mc_frazionate.NUMPROG := fraziobo->NUMPROG // Stampa operazioni */
                _mc_frazionate.row.NUMPROG = Cursor_fraziobo.GetString("NUMPROG");
                /* _mc_frazionate.DATAREG := fraziobo->DATAREG // Stampa operazioni */
                _mc_frazionate.row.DATAREG = Cursor_fraziobo.GetDate("DATAREG");
                /* _mc_frazionate.CAUSALE := fraziobo->CODANA // Stampa operazioni */
                _mc_frazionate.row.CAUSALE = Cursor_fraziobo.GetString("CODANA");
                /* _mc_frazionate.IMPORTO := fraziobo->TOTLIRE // Stampa operazioni */
                _mc_frazionate.row.IMPORTO = Cursor_fraziobo.GetDouble("TOTLIRE");
                /* _mc_frazionate.VALUTA := fraziobo->VALUTA // Stampa operazioni */
                _mc_frazionate.row.VALUTA = Cursor_fraziobo.GetString("VALUTA");
                /* _mc_frazionate.CONNESCLI := fraziobo->CONNESCLI // Stampa operazioni */
                _mc_frazionate.row.CONNESCLI = Cursor_fraziobo.GetString("CONNESCLI");
                /* _mc_frazionate.DESCRI := fraziobo->RAPPORTO // Stampa operazioni */
                _mc_frazionate.row.DESCRI = Cursor_fraziobo.GetString("RAPPORTO");
                /* _mc_frazionate.STATOREG := fraziobo->STATOREG // Stampa operazioni */
                _mc_frazionate.row.STATOREG = Cursor_fraziobo.GetString("STATOREG");
                /* _mc_frazionate.TIPOARCH := 'A' // Stampa operazioni */
                _mc_frazionate.row.TIPOARCH = "A";
                /* _mc_frazionate.SaveRow() // Stampa frazionate */
                _mc_frazionate.SaveRow();
                Cursor_fraziobo.Next();
              }
              m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
              Cursor_fraziobo.Close();
              // * --- End Select
            } // End If
            /* Case w_chi_chiama_la_routine="STO" */
          } else if (CPLib.eqr(w_chi_chiama_la_routine,"STO")) {
            /* If operfraz='O' */
            if (CPLib.eqr(operfraz,"O")) {
              // * --- Select from wperazbo
              m_cServer = m_Ctx.GetServer("wperazbo");
              m_cPhName = m_Ctx.GetPhName("wperazbo");
              if (Cursor_wperazbo!=null)
                Cursor_wperazbo.Close();
              Cursor_wperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CDATREG>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatini)+"  and  CDATREG<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatfin)+" "+")"+(m_Ctx.IsSharedTemp("wperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wperazbo.Eof())) {
                /* _mc_operazioni.AppendBlank() // Stampa operazioni */
                _mc_operazioni.AppendBlank();
                /* _mc_operazioni.DATAOPE := wperazbo->DATAOPE // Stampa operazioni */
                _mc_operazioni.row.DATAOPE = Cursor_wperazbo.GetDate("DATAOPE");
                /* _mc_operazioni.NUMPROG := wperazbo->NUMPROG // Stampa operazioni */
                _mc_operazioni.row.NUMPROG = Cursor_wperazbo.GetString("NUMPROG");
                /* _mc_operazioni.DATAREG := wperazbo->DATAREG // Stampa operazioni */
                _mc_operazioni.row.DATAREG = Cursor_wperazbo.GetDate("DATAREG");
                /* _mc_operazioni.CAUSALE := wperazbo->CODANA // Stampa operazioni */
                _mc_operazioni.row.CAUSALE = Cursor_wperazbo.GetString("CODANA");
                /* _mc_operazioni.IMPORTO := wperazbo->TOTLIRE // Stampa operazioni */
                _mc_operazioni.row.IMPORTO = Cursor_wperazbo.GetDouble("TOTLIRE");
                /* _mc_operazioni.VALUTA := wperazbo->VALUTA // Stampa operazioni */
                _mc_operazioni.row.VALUTA = Cursor_wperazbo.GetString("VALUTA");
                /* _mc_operazioni.CONNESCLI := wperazbo->CONNESCLI // Stampa operazioni */
                _mc_operazioni.row.CONNESCLI = Cursor_wperazbo.GetString("CONNESCLI");
                /* _mc_operazioni.DESCRI := wperazbo->RAPPORTO // Stampa operazioni */
                _mc_operazioni.row.DESCRI = Cursor_wperazbo.GetString("RAPPORTO");
                /* _mc_operazioni.STATOREG := wperazbo->STATOREG // Stampa operazioni */
                _mc_operazioni.row.STATOREG = Cursor_wperazbo.GetString("STATOREG");
                /* _mc_operazioni.TIPOARCH := 'A' // Stampa operazioni */
                _mc_operazioni.row.TIPOARCH = "A";
                /* _mc_operazioni.SaveRow() // Stampa operazioni */
                _mc_operazioni.SaveRow();
                Cursor_wperazbo.Next();
              }
              m_cConnectivityError = Cursor_wperazbo.ErrorMessage();
              Cursor_wperazbo.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from wraziobo
              m_cServer = m_Ctx.GetServer("wraziobo");
              m_cPhName = m_Ctx.GetPhName("wraziobo");
              if (Cursor_wraziobo!=null)
                Cursor_wraziobo.Close();
              Cursor_wraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CDATREG>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatini)+"  and  CDATREG<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatfin)+" "+")"+(m_Ctx.IsSharedTemp("wraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wraziobo.Eof())) {
                /* _mc_frazionate.AppendBlank() // Stampa frazionate */
                _mc_frazionate.AppendBlank();
                /* _mc_frazionate.DATAOPE := wraziobo->DATAOPE // Stampa operazioni */
                _mc_frazionate.row.DATAOPE = Cursor_wraziobo.GetDate("DATAOPE");
                /* _mc_frazionate.NUMPROG := wraziobo->NUMPROG // Stampa operazioni */
                _mc_frazionate.row.NUMPROG = Cursor_wraziobo.GetString("NUMPROG");
                /* _mc_frazionate.DATAREG := wraziobo->DATAREG // Stampa operazioni */
                _mc_frazionate.row.DATAREG = Cursor_wraziobo.GetDate("DATAREG");
                /* _mc_frazionate.CAUSALE := wraziobo->CODANA // Stampa operazioni */
                _mc_frazionate.row.CAUSALE = Cursor_wraziobo.GetString("CODANA");
                /* _mc_frazionate.IMPORTO := wraziobo->TOTLIRE // Stampa operazioni */
                _mc_frazionate.row.IMPORTO = Cursor_wraziobo.GetDouble("TOTLIRE");
                /* _mc_frazionate.VALUTA := wraziobo->VALUTA // Stampa operazioni */
                _mc_frazionate.row.VALUTA = Cursor_wraziobo.GetString("VALUTA");
                /* _mc_frazionate.CONNESCLI := wraziobo->CONNESCLI // Stampa operazioni */
                _mc_frazionate.row.CONNESCLI = Cursor_wraziobo.GetString("CONNESCLI");
                /* _mc_frazionate.DESCRI := wraziobo->RAPPORTO // Stampa operazioni */
                _mc_frazionate.row.DESCRI = Cursor_wraziobo.GetString("RAPPORTO");
                /* _mc_frazionate.STATOREG := wraziobo->STATOREG // Stampa operazioni */
                _mc_frazionate.row.STATOREG = Cursor_wraziobo.GetString("STATOREG");
                /* _mc_frazionate.TIPOARCH := 'A' // Stampa operazioni */
                _mc_frazionate.row.TIPOARCH = "A";
                /* _mc_frazionate.SaveRow() // Stampa frazionate */
                _mc_frazionate.SaveRow();
                Cursor_wraziobo.Next();
              }
              m_cConnectivityError = Cursor_wraziobo.ErrorMessage();
              Cursor_wraziobo.Close();
              // * --- End Select
            } // End If
          } // End Case
          /* gMsgProc := gMsgProc + 'Fine precaricamento per la stampa'+NL // Messaggio */
          gMsgProc = gMsgProc+"Fine precaricamento per la stampa"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* If False */
          if (false) {
            /* gMsgProc := gMsgProc + 'mcOPE:'+_mc_operazioni.RecCount()+NL +'mcFRZ:'+_mc_frazionate.RecCount()+NL // Messaggio */
            gMsgProc = gMsgProc+"mcOPE:"+_mc_operazioni.RecCount()+"\n"+"mcFRZ:"+_mc_frazionate.RecCount()+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
        } // End If
        /* While _dataoggi <= _ddatfin */
        while (CPLib.le(_dataoggi,_ddatfin)) {
          /* If Empty(_oldmsg) */
          if (CPLib.Empty(_oldmsg)) {
            /* gMsgProc := gMsgProc + 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) +_stringa_appoggio // Messaggio */
            gMsgProc = gMsgProc+"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+_stringa_appoggio;
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) +_stringa_appoggio) // Messaggio */
            gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+_stringa_appoggio);
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* _oldmsg := 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) +_stringa_appoggio */
          _oldmsg = "Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+_stringa_appoggio;
          /* If operfraz='O' */
          if (CPLib.eqr(operfraz,"O")) {
            /* If w_chi_chiama_la_routine='AUI' */
            if (CPLib.eqr(w_chi_chiama_la_routine,"AUI")) {
              // * --- Select from qbe_storope
              SPBridge.HMCaller _h00000113;
              _h00000113 = new SPBridge.HMCaller();
              _h00000113.Set("m_cVQRList",m_cVQRList);
              _h00000113.Set("data_oggi",_cdataoggi);
              if (Cursor_qbe_storope!=null)
                Cursor_qbe_storope.Close();
              Cursor_qbe_storope = new VQRHolder("qbe_storope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000113,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_storope.Eof())) {
                /* _contaop := _contaop + 1 */
                _contaop = CPLib.Round(_contaop+1,0);
                /* gMsgImp :=  iif(At(w_stampa,'|E|R') <> 0,"Elaborazione ",iif(w_tipoope='T','Storicizzazione ','Cancellazione '))+"dati dell'operazione con ID: "+qbe_storope->IDBASE */
                gMsgImp = (CPLib.ne(CPLib.At(w_stampa,"|E|R"),0)?"Elaborazione ":(CPLib.eqr(w_tipoope,"T")?"Storicizzazione ":"Cancellazione "))+"dati dell'operazione con ID: "+Cursor_qbe_storope.GetString("IDBASE");
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* If w_anag_colleg */
                if (w_anag_colleg) {
                  /* Prendo i CONNES collegati all'operazione (CONNESCLI, CONNESOPER,CONNESBEN,CONNALTRO) */
                  /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storope->CONNESCLI) */
                  add_sogg_mc(Cursor_qbe_storope.GetString("CONNESCLI"));
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storope->CONNESOPER) */
                  add_sogg_mc(Cursor_qbe_storope.GetString("CONNESOPER"));
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storope->CONNESBEN) */
                  add_sogg_mc(Cursor_qbe_storope.GetString("CONNESBEN"));
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storope->CONNALTRO) */
                  add_sogg_mc(Cursor_qbe_storope.GetString("CONNALTRO"));
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
                /* If w_tipoope = 'T' and (Empty(w_stampa) or w_stampa='S') */
                if (CPLib.eqr(w_tipoope,"T") && (CPLib.Empty(w_stampa) || CPLib.eqr(w_stampa,"S"))) {
                  // * --- Select from operazbo
                  m_cServer = m_Ctx.GetServer("operazbo");
                  m_cPhName = m_Ctx.GetPhName("operazbo");
                  if (Cursor_operazbo!=null)
                    Cursor_operazbo.Close();
                  Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE = "+CPLib.ToSQL(Cursor_qbe_storope.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_operazbo.Eof())) {
                    // * --- Insert into wperazbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("wperazbo");
                    m_cPhName = m_Ctx.GetPhName("wperazbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wperazbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000120")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000120(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("ANNOOPE"),"?",0,0)+", ";
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
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DAC6"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDate("DATAIMP"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDate("DATAOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDate("DATAREG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDate("DATARETT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("FLAGDAC6"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("IDBASE2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("IMPIN"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("IMPOUT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("IMPSARA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("MITIGDOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("MITIG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("MTCN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("NOPROT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("NOSARA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("PROQUOTA"),"?",0,0)+", ";
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
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RTIPO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("SV58550"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("SV58550MA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOORO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wperazbo",true);
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
                    Cursor_operazbo.Next();
                  }
                  m_cConnectivityError = Cursor_operazbo.ErrorMessage();
                  Cursor_operazbo.Close();
                  // * --- End Select
                  /* If rowTabelle._sogopebo */
                  if (rowTabelle._sogopebo) {
                    // * --- Select from sogopebo
                    m_cServer = m_Ctx.GetServer("sogopebo");
                    m_cPhName = m_Ctx.GetPhName("sogopebo");
                    if (Cursor_sogopebo!=null)
                      Cursor_sogopebo.Close();
                    Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_storope.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_sogopebo.Eof())) {
                      // * --- Insert into wogopebo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("wogopebo");
                      m_cPhName = m_Ctx.GetPhName("wogopebo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wogopebo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000123")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000123(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wogopebo",true);
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
                      Cursor_sogopebo.Next();
                    }
                    m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
                    Cursor_sogopebo.Close();
                    // * --- End Select
                  } // End If
                  /* If rowTabelle._clientiope */
                  if (rowTabelle._clientiope) {
                    // * --- Select from clientiope
                    m_cServer = m_Ctx.GetServer("clientiope");
                    m_cPhName = m_Ctx.GetPhName("clientiope");
                    if (Cursor_clientiope!=null)
                      Cursor_clientiope.Close();
                    Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_storope.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_clientiope.Eof())) {
                      // * --- Insert into wlientiope from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("wlientiope");
                      m_cPhName = m_Ctx.GetPhName("wlientiope");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wlientiope",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000126")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000126(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wlientiope",true);
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
                      Cursor_clientiope.Next();
                    }
                    m_cConnectivityError = Cursor_clientiope.ErrorMessage();
                    Cursor_clientiope.Close();
                    // * --- End Select
                  } // End If
                  /* If rowTabelle._beneficope */
                  if (rowTabelle._beneficope) {
                    // * --- Select from beneficope
                    m_cServer = m_Ctx.GetServer("beneficope");
                    m_cPhName = m_Ctx.GetPhName("beneficope");
                    if (Cursor_beneficope!=null)
                      Cursor_beneficope.Close();
                    Cursor_beneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_storope.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_beneficope.Eof())) {
                      // * --- Insert into weneficope from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("weneficope");
                      m_cPhName = m_Ctx.GetPhName("weneficope");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"weneficope",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000129")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000129(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetDouble("CPROWNUM"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"weneficope",true);
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
                      Cursor_beneficope.Next();
                    }
                    m_cConnectivityError = Cursor_beneficope.ErrorMessage();
                    Cursor_beneficope.Close();
                    // * --- End Select
                  } // End If
                  /* If rowTabelle._terzistiope */
                  if (rowTabelle._terzistiope) {
                    // * --- Select from terzistiope
                    m_cServer = m_Ctx.GetServer("terzistiope");
                    m_cPhName = m_Ctx.GetPhName("terzistiope");
                    if (Cursor_terzistiope!=null)
                      Cursor_terzistiope.Close();
                    Cursor_terzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_storope.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_terzistiope.Eof())) {
                      // * --- Insert into werzistiope from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("werzistiope");
                      m_cPhName = m_Ctx.GetPhName("werzistiope");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"werzistiope",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000012C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000012C(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"werzistiope",true);
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
                      Cursor_terzistiope.Next();
                    }
                    m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
                    Cursor_terzistiope.Close();
                    // * --- End Select
                  } // End If
                } // End If
                /* If rowTabelle._sogopebo */
                if (rowTabelle._sogopebo) {
                  /* If w_anag_colleg */
                  if (w_anag_colleg) {
                    // * --- Select from sogopebo
                    m_cServer = m_Ctx.GetServer("sogopebo");
                    m_cPhName = m_Ctx.GetPhName("sogopebo");
                    if (Cursor_sogopebo!=null)
                      Cursor_sogopebo.Close();
                    Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_qbe_storope.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_sogopebo.Eof())) {
                      /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(sogopebo->CODSOG) */
                      add_sogg_mc(Cursor_sogopebo.GetString("CODSOG"));
                      if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                        throw new RoutineException();
                      }
                      Cursor_sogopebo.Next();
                    }
                    m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
                    Cursor_sogopebo.Close();
                    // * --- End Select
                  } // End If
                  /* If At(w_stampa,'|E|S') <> 0 */
                  if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                    // * --- Delete from sogopebo
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("sogopebo");
                    m_cPhName = m_Ctx.GetPhName("sogopebo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopebo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000132")+"delete from "+m_oWrInfo.GetTableWriteName();
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storope.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storope.GetString("IDBASE"))+"";
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
                /* If rowTabelle._clientiope */
                if (rowTabelle._clientiope) {
                  /* If w_anag_colleg */
                  if (w_anag_colleg) {
                    // * --- Select from clientiope
                    m_cServer = m_Ctx.GetServer("clientiope");
                    m_cPhName = m_Ctx.GetPhName("clientiope");
                    if (Cursor_clientiope!=null)
                      Cursor_clientiope.Close();
                    Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_qbe_storope.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_clientiope.Eof())) {
                      /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(clientiope->CODSOG) */
                      add_sogg_mc(Cursor_clientiope.GetString("CODSOG"));
                      if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                        throw new RoutineException();
                      }
                      Cursor_clientiope.Next();
                    }
                    m_cConnectivityError = Cursor_clientiope.ErrorMessage();
                    Cursor_clientiope.Close();
                    // * --- End Select
                  } // End If
                  /* If At(w_stampa,'|E|S') <> 0 */
                  if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                    // * --- Delete from clientiope
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("clientiope");
                    m_cPhName = m_Ctx.GetPhName("clientiope");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000138")+"delete from "+m_oWrInfo.GetTableWriteName();
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storope.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storope.GetString("IDBASE"))+"";
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
                /* If rowTabelle._beneficope */
                if (rowTabelle._beneficope) {
                  /* If w_anag_colleg */
                  if (w_anag_colleg) {
                    // * --- Select from beneficope
                    m_cServer = m_Ctx.GetServer("beneficope");
                    m_cPhName = m_Ctx.GetPhName("beneficope");
                    if (Cursor_beneficope!=null)
                      Cursor_beneficope.Close();
                    Cursor_beneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_qbe_storope.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("beneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_beneficope.Eof())) {
                      /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(beneficope->CODSOG) */
                      add_sogg_mc(Cursor_beneficope.GetString("CODSOG"));
                      if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                        throw new RoutineException();
                      }
                      Cursor_beneficope.Next();
                    }
                    m_cConnectivityError = Cursor_beneficope.ErrorMessage();
                    Cursor_beneficope.Close();
                    // * --- End Select
                  } // End If
                  /* If At(w_stampa,'|E|S') <> 0 */
                  if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                    // * --- Delete from beneficope
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("beneficope");
                    m_cPhName = m_Ctx.GetPhName("beneficope");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficope",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000013E")+"delete from "+m_oWrInfo.GetTableWriteName();
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storope.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storope.GetString("IDBASE"))+"";
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
                /* If rowTabelle._terzistiope */
                if (rowTabelle._terzistiope) {
                  /* If w_anag_colleg */
                  if (w_anag_colleg) {
                    // * --- Select from terzistiope
                    m_cServer = m_Ctx.GetServer("terzistiope");
                    m_cPhName = m_Ctx.GetPhName("terzistiope");
                    if (Cursor_terzistiope!=null)
                      Cursor_terzistiope.Close();
                    Cursor_terzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_qbe_storope.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("terzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_terzistiope.Eof())) {
                      /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(terzistiope->CODSOG) */
                      add_sogg_mc(Cursor_terzistiope.GetString("CODSOG"));
                      if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                        throw new RoutineException();
                      }
                      Cursor_terzistiope.Next();
                    }
                    m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
                    Cursor_terzistiope.Close();
                    // * --- End Select
                  } // End If
                  /* If At(w_stampa,'|E|S') <> 0 */
                  if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                    // * --- Delete from terzistiope
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("terzistiope");
                    m_cPhName = m_Ctx.GetPhName("terzistiope");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistiope",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000144")+"delete from "+m_oWrInfo.GetTableWriteName();
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storope.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storope.GetString("IDBASE"))+"";
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
                /* If At(w_stampa,'|E|S') <> 0 */
                if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                  // * --- Delete from operazbo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("operazbo");
                  m_cPhName = m_Ctx.GetPhName("operazbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000146")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storope.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storope.GetString("IDBASE"))+"";
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
                Cursor_qbe_storope.Next();
              }
              m_cConnectivityError = Cursor_qbe_storope.ErrorMessage();
              Cursor_qbe_storope.Close();
              // * --- End Select
              /* ElseIf w_chi_chiama_la_routine='STO' */
            } else if (CPLib.eqr(w_chi_chiama_la_routine,"STO")) {
              // * --- Select from qbe_storwpe
              SPBridge.HMCaller _h00000147;
              _h00000147 = new SPBridge.HMCaller();
              _h00000147.Set("m_cVQRList",m_cVQRList);
              _h00000147.Set("data_oggi",_cdataoggi);
              if (Cursor_qbe_storwpe!=null)
                Cursor_qbe_storwpe.Close();
              Cursor_qbe_storwpe = new VQRHolder("qbe_storwpe",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000147,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_storwpe.Eof())) {
                /* _contaop := _contaop + 1 */
                _contaop = CPLib.Round(_contaop+1,0);
                /* gMsgImp :=  iif(At(w_stampa,'|E|R') <> 0,"Elaborazione ","Cancellazione ")+"dati storici dell'operazione con ID: "+qbe_storwpe->IDBASE */
                gMsgImp = (CPLib.ne(CPLib.At(w_stampa,"|E|R"),0)?"Elaborazione ":"Cancellazione ")+"dati storici dell'operazione con ID: "+Cursor_qbe_storwpe.GetString("IDBASE");
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* If w_anag_colleg */
                if (w_anag_colleg) {
                  /* Prendo i CONNES collegati all'operazione (CONNESCLI, CONNESOPER,CONNESBEN,CONNALTRO) */
                  /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storwpe->CONNESCLI) */
                  add_sogg_mc(Cursor_qbe_storwpe.GetString("CONNESCLI"));
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storwpe->CONNESOPER) */
                  add_sogg_mc(Cursor_qbe_storwpe.GetString("CONNESOPER"));
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storwpe->CONNESBEN) */
                  add_sogg_mc(Cursor_qbe_storwpe.GetString("CONNESBEN"));
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storwpe->CONNALTRO) */
                  add_sogg_mc(Cursor_qbe_storwpe.GetString("CONNALTRO"));
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  // * --- Select from wogopebo
                  m_cServer = m_Ctx.GetServer("wogopebo");
                  m_cPhName = m_Ctx.GetPhName("wogopebo");
                  if (Cursor_wogopebo!=null)
                    Cursor_wogopebo.Close();
                  Cursor_wogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_qbe_storwpe.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("wogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wogopebo.Eof())) {
                    /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(wogopebo->CODSOG) */
                    add_sogg_mc(Cursor_wogopebo.GetString("CODSOG"));
                    if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                      throw new RoutineException();
                    }
                    Cursor_wogopebo.Next();
                  }
                  m_cConnectivityError = Cursor_wogopebo.ErrorMessage();
                  Cursor_wogopebo.Close();
                  // * --- End Select
                  // * --- Select from wlientiope
                  m_cServer = m_Ctx.GetServer("wlientiope");
                  m_cPhName = m_Ctx.GetPhName("wlientiope");
                  if (Cursor_wlientiope!=null)
                    Cursor_wlientiope.Close();
                  Cursor_wlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_qbe_storwpe.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("wlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wlientiope.Eof())) {
                    /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(wlientiope->CODSOG) */
                    add_sogg_mc(Cursor_wlientiope.GetString("CODSOG"));
                    if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                      throw new RoutineException();
                    }
                    Cursor_wlientiope.Next();
                  }
                  m_cConnectivityError = Cursor_wlientiope.ErrorMessage();
                  Cursor_wlientiope.Close();
                  // * --- End Select
                  // * --- Select from weneficope
                  m_cServer = m_Ctx.GetServer("weneficope");
                  m_cPhName = m_Ctx.GetPhName("weneficope");
                  if (Cursor_weneficope!=null)
                    Cursor_weneficope.Close();
                  Cursor_weneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_qbe_storwpe.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("weneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_weneficope.Eof())) {
                    /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(weneficope->CODSOG) */
                    add_sogg_mc(Cursor_weneficope.GetString("CODSOG"));
                    if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                      throw new RoutineException();
                    }
                    Cursor_weneficope.Next();
                  }
                  m_cConnectivityError = Cursor_weneficope.ErrorMessage();
                  Cursor_weneficope.Close();
                  // * --- End Select
                  // * --- Select from werzistiope
                  m_cServer = m_Ctx.GetServer("werzistiope");
                  m_cPhName = m_Ctx.GetPhName("werzistiope");
                  if (Cursor_werzistiope!=null)
                    Cursor_werzistiope.Close();
                  Cursor_werzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_qbe_storwpe.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("werzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_werzistiope.Eof())) {
                    /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(werzistiope->CODSOG) */
                    add_sogg_mc(Cursor_werzistiope.GetString("CODSOG"));
                    if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                      throw new RoutineException();
                    }
                    Cursor_werzistiope.Next();
                  }
                  m_cConnectivityError = Cursor_werzistiope.ErrorMessage();
                  Cursor_werzistiope.Close();
                  // * --- End Select
                } // End If
                /* If At(w_stampa,'|E|S') <> 0 */
                if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                  // * --- Delete from wogopebo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("wogopebo");
                  m_cPhName = m_Ctx.GetPhName("wogopebo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wogopebo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000015A")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwpe.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwpe.GetString("IDBASE"))+"";
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
                  // * --- Delete from weneficope
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("weneficope");
                  m_cPhName = m_Ctx.GetPhName("weneficope");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"weneficope",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000015B")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwpe.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwpe.GetString("IDBASE"))+"";
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
                  // * --- Delete from wlientiope
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("wlientiope");
                  m_cPhName = m_Ctx.GetPhName("wlientiope");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wlientiope",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000015C")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwpe.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwpe.GetString("IDBASE"))+"";
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
                  // * --- Delete from werzistiope
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("werzistiope");
                  m_cPhName = m_Ctx.GetPhName("werzistiope");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"werzistiope",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000015D")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwpe.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwpe.GetString("IDBASE"))+"";
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
                  // * --- Delete from wperazbo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("wperazbo");
                  m_cPhName = m_Ctx.GetPhName("wperazbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wperazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000015E")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwpe.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwpe.GetString("IDBASE"))+"";
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
                Cursor_qbe_storwpe.Next();
              }
              m_cConnectivityError = Cursor_qbe_storwpe.ErrorMessage();
              Cursor_qbe_storwpe.Close();
              // * --- End Select
            } // End If
            /* ElseIf operfraz='F' */
          } else if (CPLib.eqr(operfraz,"F")) {
            /* If w_chi_chiama_la_routine='AUI' */
            if (CPLib.eqr(w_chi_chiama_la_routine,"AUI")) {
              // * --- Select from qbe_storfraz
              SPBridge.HMCaller _h00000160;
              _h00000160 = new SPBridge.HMCaller();
              _h00000160.Set("m_cVQRList",m_cVQRList);
              _h00000160.Set("dadata",_cdataoggi);
              if (Cursor_qbe_storfraz!=null)
                Cursor_qbe_storfraz.Close();
              Cursor_qbe_storfraz = new VQRHolder("qbe_storfraz",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000160,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_storfraz.Eof())) {
                /* _contaop := _contaop + 1 */
                _contaop = CPLib.Round(_contaop+1,0);
                /* gMsgImp :=  iif(At(w_stampa,'|E|R') <> 0,"Elaborazione ",iif(w_tipoope='T','Storicizzazione ','Cancellazione '))+"dati dell'operazione frazionata con ID: "+qbe_storfraz->IDBASE */
                gMsgImp = (CPLib.ne(CPLib.At(w_stampa,"|E|R"),0)?"Elaborazione ":(CPLib.eqr(w_tipoope,"T")?"Storicizzazione ":"Cancellazione "))+"dati dell'operazione frazionata con ID: "+Cursor_qbe_storfraz.GetString("IDBASE");
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* If w_anag_colleg */
                if (w_anag_colleg) {
                  /* Prendo i CONNES collegati all'operazione (CONNESCLI, CONNESOPER,CONNESBEN,CONNALTRO) */
                  /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storfraz->CONNESCLI) */
                  add_sogg_mc(Cursor_qbe_storfraz.GetString("CONNESCLI"));
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storfraz->CONNESOPER) */
                  add_sogg_mc(Cursor_qbe_storfraz.GetString("CONNESOPER"));
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storfraz->CONNESBEN) */
                  add_sogg_mc(Cursor_qbe_storfraz.GetString("CONNESBEN"));
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storfraz->CONNALTRO) */
                  add_sogg_mc(Cursor_qbe_storfraz.GetString("CONNALTRO"));
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
                /* If w_tipoope = 'T' and At(w_stampa,'|E|S') <> 0 */
                if (CPLib.eqr(w_tipoope,"T") && CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                  // * --- Insert into wraziobo from query
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("wraziobo");
                  m_cPhName = m_Ctx.GetPhName("wraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wraziobo",m_Ctx.GetCompany());
                  SPBridge.HMCaller _h0000016B;
                  _h0000016B = new SPBridge.HMCaller();
                  _h0000016B.Set("m_cVQRList",m_cVQRList);
                  _h0000016B.Set("_idb",Cursor_qbe_storfraz.GetString("IDBASE"));
                  m_nUpdatedRows=m_Sql.InsertIntoVQR(CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000016B"),m_oWrInfo,"qbe_storfraz1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000016B,m_Ctx);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                  /* If rowTabelle._sogopefbo */
                  if (rowTabelle._sogopefbo) {
                    // * --- Select from sogopefbo
                    m_cServer = m_Ctx.GetServer("sogopefbo");
                    m_cPhName = m_Ctx.GetPhName("sogopefbo");
                    if (Cursor_sogopefbo!=null)
                      Cursor_sogopefbo.Close();
                    Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_storfraz.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_sogopefbo.Eof())) {
                      // * --- Insert into wogopefbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("wogopefbo");
                      m_cPhName = m_Ctx.GetPhName("wogopefbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wogopefbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000016E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000016E(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wogopefbo",true);
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
                      Cursor_sogopefbo.Next();
                    }
                    m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
                    Cursor_sogopefbo.Close();
                    // * --- End Select
                  } // End If
                  /* If rowTabelle._clientifrz */
                  if (rowTabelle._clientifrz) {
                    // * --- Select from clientifrz
                    m_cServer = m_Ctx.GetServer("clientifrz");
                    m_cPhName = m_Ctx.GetPhName("clientifrz");
                    if (Cursor_clientifrz!=null)
                      Cursor_clientifrz.Close();
                    Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_storfraz.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_clientifrz.Eof())) {
                      // * --- Insert into wlientifrz from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("wlientifrz");
                      m_cPhName = m_Ctx.GetPhName("wlientifrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wlientifrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000171")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000171(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wlientifrz",true);
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
                      Cursor_clientifrz.Next();
                    }
                    m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
                    Cursor_clientifrz.Close();
                    // * --- End Select
                  } // End If
                  /* If rowTabelle._beneficfrz */
                  if (rowTabelle._beneficfrz) {
                    // * --- Select from beneficfrz
                    m_cServer = m_Ctx.GetServer("beneficfrz");
                    m_cPhName = m_Ctx.GetPhName("beneficfrz");
                    if (Cursor_beneficfrz!=null)
                      Cursor_beneficfrz.Close();
                    Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_storfraz.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_beneficfrz.Eof())) {
                      // * --- Insert into weneficfrz from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("weneficfrz");
                      m_cPhName = m_Ctx.GetPhName("weneficfrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"weneficfrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000174")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000174(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
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
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"weneficfrz",true);
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
                      Cursor_beneficfrz.Next();
                    }
                    m_cConnectivityError = Cursor_beneficfrz.ErrorMessage();
                    Cursor_beneficfrz.Close();
                    // * --- End Select
                  } // End If
                  /* If rowTabelle._terzistifrz */
                  if (rowTabelle._terzistifrz) {
                    // * --- Select from terzistifrz
                    m_cServer = m_Ctx.GetServer("terzistifrz");
                    m_cPhName = m_Ctx.GetPhName("terzistifrz");
                    if (Cursor_terzistifrz!=null)
                      Cursor_terzistifrz.Close();
                    Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_storfraz.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_terzistifrz.Eof())) {
                      // * --- Insert into werzistifrz from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("werzistifrz");
                      m_cPhName = m_Ctx.GetPhName("werzistifrz");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"werzistifrz",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000177")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000177(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"werzistifrz",true);
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
                      Cursor_terzistifrz.Next();
                    }
                    m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
                    Cursor_terzistifrz.Close();
                    // * --- End Select
                  } // End If
                } // End If
                /* If rowTabelle._sogopefbo */
                if (rowTabelle._sogopefbo) {
                  /* If w_anag_colleg */
                  if (w_anag_colleg) {
                    // * --- Select from sogopefbo
                    m_cServer = m_Ctx.GetServer("sogopefbo");
                    m_cPhName = m_Ctx.GetPhName("sogopefbo");
                    if (Cursor_sogopefbo!=null)
                      Cursor_sogopefbo.Close();
                    Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_qbe_storfraz.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_sogopefbo.Eof())) {
                      /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(sogopefbo->CODSOG) */
                      add_sogg_mc(Cursor_sogopefbo.GetString("CODSOG"));
                      if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                        throw new RoutineException();
                      }
                      Cursor_sogopefbo.Next();
                    }
                    m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
                    Cursor_sogopefbo.Close();
                    // * --- End Select
                  } // End If
                  /* If At(w_stampa,'|E|S') <> 0 */
                  if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                    // * --- Delete from sogopefbo
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("sogopefbo");
                    m_cPhName = m_Ctx.GetPhName("sogopefbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000017D")+"delete from "+m_oWrInfo.GetTableWriteName();
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storfraz.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storfraz.GetString("IDBASE"))+"";
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
                /* If rowTabelle._clientifrz */
                if (rowTabelle._clientifrz) {
                  /* If w_anag_colleg */
                  if (w_anag_colleg) {
                    // * --- Select from clientifrz
                    m_cServer = m_Ctx.GetServer("clientifrz");
                    m_cPhName = m_Ctx.GetPhName("clientifrz");
                    if (Cursor_clientifrz!=null)
                      Cursor_clientifrz.Close();
                    Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_qbe_storfraz.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_clientifrz.Eof())) {
                      /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(clientifrz->CODSOG) */
                      add_sogg_mc(Cursor_clientifrz.GetString("CODSOG"));
                      if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                        throw new RoutineException();
                      }
                      Cursor_clientifrz.Next();
                    }
                    m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
                    Cursor_clientifrz.Close();
                    // * --- End Select
                  } // End If
                  /* If At(w_stampa,'|E|S') <> 0 */
                  if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                    // * --- Delete from clientifrz
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("clientifrz");
                    m_cPhName = m_Ctx.GetPhName("clientifrz");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000183")+"delete from "+m_oWrInfo.GetTableWriteName();
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storfraz.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storfraz.GetString("IDBASE"))+"";
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
                /* If rowTabelle._beneficfrz */
                if (rowTabelle._beneficfrz) {
                  /* If w_anag_colleg */
                  if (w_anag_colleg) {
                    // * --- Select from beneficfrz
                    m_cServer = m_Ctx.GetServer("beneficfrz");
                    m_cPhName = m_Ctx.GetPhName("beneficfrz");
                    if (Cursor_beneficfrz!=null)
                      Cursor_beneficfrz.Close();
                    Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_qbe_storfraz.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_beneficfrz.Eof())) {
                      /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(beneficfrz->CODSOG) */
                      add_sogg_mc(Cursor_beneficfrz.GetString("CODSOG"));
                      if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                        throw new RoutineException();
                      }
                      Cursor_beneficfrz.Next();
                    }
                    m_cConnectivityError = Cursor_beneficfrz.ErrorMessage();
                    Cursor_beneficfrz.Close();
                    // * --- End Select
                  } // End If
                  /* If At(w_stampa,'|E|S') <> 0 */
                  if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                    // * --- Delete from beneficfrz
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("beneficfrz");
                    m_cPhName = m_Ctx.GetPhName("beneficfrz");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000189")+"delete from "+m_oWrInfo.GetTableWriteName();
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storfraz.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storfraz.GetString("IDBASE"))+"";
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
                /* If rowTabelle._terzistifrz */
                if (rowTabelle._terzistifrz) {
                  /* If w_anag_colleg */
                  if (w_anag_colleg) {
                    // * --- Select from terzistifrz
                    m_cServer = m_Ctx.GetServer("terzistifrz");
                    m_cPhName = m_Ctx.GetPhName("terzistifrz");
                    if (Cursor_terzistifrz!=null)
                      Cursor_terzistifrz.Close();
                    Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_qbe_storfraz.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_terzistifrz.Eof())) {
                      /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(terzistifrz->CODSOG) */
                      add_sogg_mc(Cursor_terzistifrz.GetString("CODSOG"));
                      if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                        throw new RoutineException();
                      }
                      Cursor_terzistifrz.Next();
                    }
                    m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
                    Cursor_terzistifrz.Close();
                    // * --- End Select
                  } // End If
                  /* If At(w_stampa,'|E|S') <> 0 */
                  if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                    // * --- Delete from terzistifrz
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("terzistifrz");
                    m_cPhName = m_Ctx.GetPhName("terzistifrz");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000018F")+"delete from "+m_oWrInfo.GetTableWriteName();
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storfraz.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storfraz.GetString("IDBASE"))+"";
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
                /* If At(w_stampa,'|E|S') <> 0 */
                if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                  // * --- Delete from fraziobo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("fraziobo");
                  m_cPhName = m_Ctx.GetPhName("fraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000191")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storfraz.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storfraz.GetString("IDBASE"))+"";
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
                Cursor_qbe_storfraz.Next();
              }
              m_cConnectivityError = Cursor_qbe_storfraz.ErrorMessage();
              Cursor_qbe_storfraz.Close();
              // * --- End Select
              /* ElseIf w_chi_chiama_la_routine='STO' */
            } else if (CPLib.eqr(w_chi_chiama_la_routine,"STO")) {
              // * --- Select from qbe_storwraz
              SPBridge.HMCaller _h00000192;
              _h00000192 = new SPBridge.HMCaller();
              _h00000192.Set("m_cVQRList",m_cVQRList);
              _h00000192.Set("dadata",_cdataoggi);
              if (Cursor_qbe_storwraz!=null)
                Cursor_qbe_storwraz.Close();
              Cursor_qbe_storwraz = new VQRHolder("qbe_storwraz",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000192,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_storwraz.Eof())) {
                /* _contaop := _contaop + 1 */
                _contaop = CPLib.Round(_contaop+1,0);
                /* gMsgImp :=  iif(At(w_stampa,'|E|R') <> 0,"Elaborazione ","Cancellazione ")+"dati dell'operazione frazionata con ID: "+qbe_storwraz->IDBASE */
                gMsgImp = (CPLib.ne(CPLib.At(w_stampa,"|E|R"),0)?"Elaborazione ":"Cancellazione ")+"dati dell'operazione frazionata con ID: "+Cursor_qbe_storwraz.GetString("IDBASE");
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* If w_anag_colleg */
                if (w_anag_colleg) {
                  /* Prendo i CONNES collegati all'operazione (CONNESCLI, CONNESOPER,CONNESBEN,CONNALTRO) */
                  /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storwraz->CONNESCLI) */
                  add_sogg_mc(Cursor_qbe_storwraz.GetString("CONNESCLI"));
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storwraz->CONNESOPER) */
                  add_sogg_mc(Cursor_qbe_storwraz.GetString("CONNESOPER"));
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storwraz->CONNESBEN) */
                  add_sogg_mc(Cursor_qbe_storwraz.GetString("CONNESBEN"));
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storwraz->CONNALTRO) */
                  add_sogg_mc(Cursor_qbe_storwraz.GetString("CONNALTRO"));
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  // * --- Select from wogopefbo
                  m_cServer = m_Ctx.GetServer("wogopefbo");
                  m_cPhName = m_Ctx.GetPhName("wogopefbo");
                  if (Cursor_wogopefbo!=null)
                    Cursor_wogopefbo.Close();
                  Cursor_wogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_qbe_storwraz.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("wogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wogopefbo.Eof())) {
                    /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(wogopefbo->CODSOG) */
                    add_sogg_mc(Cursor_wogopefbo.GetString("CODSOG"));
                    if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                      throw new RoutineException();
                    }
                    Cursor_wogopefbo.Next();
                  }
                  m_cConnectivityError = Cursor_wogopefbo.ErrorMessage();
                  Cursor_wogopefbo.Close();
                  // * --- End Select
                  // * --- Select from wlientifrz
                  m_cServer = m_Ctx.GetServer("wlientifrz");
                  m_cPhName = m_Ctx.GetPhName("wlientifrz");
                  if (Cursor_wlientifrz!=null)
                    Cursor_wlientifrz.Close();
                  Cursor_wlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_qbe_storwraz.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("wlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wlientifrz.Eof())) {
                    /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(wlientifrz->CODSOG) */
                    add_sogg_mc(Cursor_wlientifrz.GetString("CODSOG"));
                    if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                      throw new RoutineException();
                    }
                    Cursor_wlientifrz.Next();
                  }
                  m_cConnectivityError = Cursor_wlientifrz.ErrorMessage();
                  Cursor_wlientifrz.Close();
                  // * --- End Select
                  // * --- Select from weneficfrz
                  m_cServer = m_Ctx.GetServer("weneficfrz");
                  m_cPhName = m_Ctx.GetPhName("weneficfrz");
                  if (Cursor_weneficfrz!=null)
                    Cursor_weneficfrz.Close();
                  Cursor_weneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_qbe_storwraz.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("weneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_weneficfrz.Eof())) {
                    /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(weneficfrz->CODSOG) */
                    add_sogg_mc(Cursor_weneficfrz.GetString("CODSOG"));
                    if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                      throw new RoutineException();
                    }
                    Cursor_weneficfrz.Next();
                  }
                  m_cConnectivityError = Cursor_weneficfrz.ErrorMessage();
                  Cursor_weneficfrz.Close();
                  // * --- End Select
                  // * --- Select from werzistifrz
                  m_cServer = m_Ctx.GetServer("werzistifrz");
                  m_cPhName = m_Ctx.GetPhName("werzistifrz");
                  if (Cursor_werzistifrz!=null)
                    Cursor_werzistifrz.Close();
                  Cursor_werzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_qbe_storwraz.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("werzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_werzistifrz.Eof())) {
                    /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(werzistifrz->CODSOG) */
                    add_sogg_mc(Cursor_werzistifrz.GetString("CODSOG"));
                    if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                      throw new RoutineException();
                    }
                    Cursor_werzistifrz.Next();
                  }
                  m_cConnectivityError = Cursor_werzistifrz.ErrorMessage();
                  Cursor_werzistifrz.Close();
                  // * --- End Select
                } // End If
                /* If At(w_stampa,'|E|S') <> 0 */
                if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                  // * --- Delete from wogopefbo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("wogopefbo");
                  m_cPhName = m_Ctx.GetPhName("wogopefbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wogopefbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001A5")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwraz.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwraz.GetString("IDBASE"))+"";
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
                  // * --- Delete from weneficfrz
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("weneficfrz");
                  m_cPhName = m_Ctx.GetPhName("weneficfrz");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"weneficfrz",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001A6")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwraz.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwraz.GetString("IDBASE"))+"";
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
                  // * --- Delete from wlientifrz
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("wlientifrz");
                  m_cPhName = m_Ctx.GetPhName("wlientifrz");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wlientifrz",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001A7")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwraz.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwraz.GetString("IDBASE"))+"";
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
                  // * --- Delete from werzistifrz
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("werzistifrz");
                  m_cPhName = m_Ctx.GetPhName("werzistifrz");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"werzistifrz",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001A8")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwraz.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwraz.GetString("IDBASE"))+"";
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
                  // * --- Delete from wraziobo
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("wraziobo");
                  m_cPhName = m_Ctx.GetPhName("wraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001A9")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwraz.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwraz.GetString("IDBASE"))+"";
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
                Cursor_qbe_storwraz.Next();
              }
              m_cConnectivityError = Cursor_qbe_storwraz.ErrorMessage();
              Cursor_qbe_storwraz.Close();
              // * --- End Select
            } // End If
          } // End If
          /* _dataoggi := arfn_datesum(_dataoggi,1) */
          _dataoggi = arfn_datesumR.Make(m_Ctx,this).Run(_dataoggi,1);
          /* _cdataoggi := DateToChar(_dataoggi) */
          _cdataoggi = CPLib.DateToChar(_dataoggi);
        } // End While
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgProc := gMsgProc +NL+'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file'+_stringa_appoggio+NL */
        gMsgProc = gMsgProc+"\n"+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file"+_stringa_appoggio+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc +'Sono state '+ iif(w_tipoope='T','Trasferite ','Cancellate ')+LRTrim(Str(_contaop,10,0))+_stringa_appoggio+ NL */
        gMsgProc = gMsgProc+"Sono state "+(CPLib.eqr(w_tipoope,"T")?"Trasferite ":"Cancellate ")+CPLib.LRTrim(CPLib.Str(_contaop,10,0))+_stringa_appoggio+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgImp := "Errore di transazione, contattare l'assistenza" */
        gMsgImp = "Errore di transazione, contattare l'assistenza";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Return "KO" */
        throw new Stop("KO");
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000CEstatus,0)) {
          m_Sql.SetTransactionStatus(nTry000000CEstatus,cTry000000CEmsg);
        }
      }
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
        if (Cursor_wperazbo!=null)
          Cursor_wperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wraziobo!=null)
          Cursor_wraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_storope!=null)
          Cursor_qbe_storope.Close();
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
        if (Cursor_qbe_storwpe!=null)
          Cursor_qbe_storwpe.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wogopebo!=null)
          Cursor_wogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wlientiope!=null)
          Cursor_wlientiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_weneficope!=null)
          Cursor_weneficope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_werzistiope!=null)
          Cursor_werzistiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_storfraz!=null)
          Cursor_qbe_storfraz.Close();
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
      try {
        if (Cursor_qbe_storwraz!=null)
          Cursor_qbe_storwraz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wogopefbo!=null)
          Cursor_wogopefbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wlientifrz!=null)
          Cursor_wlientifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_weneficfrz!=null)
          Cursor_weneficfrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_werzistifrz!=null)
          Cursor_werzistifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void rap() throws Exception {
    CPResultSet Cursor_qbe_storrap=null;
    CPResultSet Cursor_qbe_storwap=null;
    CPResultSet Cursor_qbe_storrap2=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_garantbo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_soginfo=null;
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Cursor_fiduciabo=null;
    CPResultSet Cursor_qbe_storrap1=null;
    CPResultSet Cursor_saldi_idp=null;
    CPResultSet Cursor_qbe_storwap2=null;
    CPResultSet Cursor_welegabo=null;
    CPResultSet Cursor_warantbo=null;
    CPResultSet Cursor_wntestbo=null;
    CPResultSet Cursor_woginfo=null;
    CPResultSet Cursor_wapopebo=null;
    CPResultSet Cursor_widuciabo=null;
    CPResultSet Cursor_qbe_storwap1=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _oldmsg := '' */
      _oldmsg = "";
      /* _contaop := 0 */
      _contaop = CPLib.Round(0,0);
      /* -- prendo solo i rapporti chiusi nel periodo (tipooprap = 6) */
      /* If At(w_stampa,"|R|S") > 0 */
      if (CPLib.gt(CPLib.At(w_stampa,"|R|S"),0)) {
        /* gMsgProc := gMsgProc + 'Precaricamento dei Rapporti per la stampa'+NL // Messaggio */
        gMsgProc = gMsgProc+"Precaricamento dei Rapporti per la stampa"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* Case w_chi_chiama_la_routine="AUI" */
        if (CPLib.eqr(w_chi_chiama_la_routine,"AUI")) {
          // * --- Fill memory cursor _mc_rapporti on qbe_storrap
          _mc_rapporti.Zap();
          SPBridge.HMCaller _h000001B8;
          _h000001B8 = new SPBridge.HMCaller();
          _h000001B8.Set("m_cVQRList",m_cVQRList);
          _h000001B8.Set("dadata",_ddatini);
          _h000001B8.Set("adata",_ddatfin);
          if (Cursor_qbe_storrap!=null)
            Cursor_qbe_storrap.Close();
          Cursor_qbe_storrap = new VQRHolder("qbe_storrap",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001B8,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_storrap;
            Cursor_qbe_storrap.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_stor_trasf: query on qbe_storrap returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_storrap.Eof())) {
            _mc_rapporti.AppendBlank();
            _mc_rapporti.row.RAPPORTO = Cursor_qbe_storrap.GetString("RAPPORTO");
            _mc_rapporti.row.DESCRAP = Cursor_qbe_storrap.GetString("DESCRAP");
            _mc_rapporti.row.TIPORAP = Cursor_qbe_storrap.GetString("TIPORAP");
            _mc_rapporti.row.FLAGLIRE = Cursor_qbe_storrap.GetString("FLAGLIRE");
            _mc_rapporti.row.VALUTA = Cursor_qbe_storrap.GetString("VALUTA");
            _mc_rapporti.row.CONTINUA = Cursor_qbe_storrap.GetString("CONTINUA");
            _mc_rapporti.row.TIPOAG = Cursor_qbe_storrap.GetString("TIPOAG");
            _mc_rapporti.row.DOCFILE = Cursor_qbe_storrap.GetString("DOCFILE");
            _mc_rapporti.row.NOPROT = Cursor_qbe_storrap.GetDouble("NOPROT");
            _mc_rapporti.row.TIPMOD = Cursor_qbe_storrap.GetString("TIPMOD");
            _mc_rapporti.row.DATAMOD = Cursor_qbe_storrap.GetDate("DATAMOD");
            _mc_rapporti.row.IDRAPPORTO = Cursor_qbe_storrap.GetString("IDRAPPORTO");
            _mc_rapporti.row.IDBASE = Cursor_qbe_storrap.GetString("IDBASE");
            _mc_rapporti.row.RAGIO = Cursor_qbe_storrap.GetString("RAGIO");
            _mc_rapporti.row.MODSVOL = Cursor_qbe_storrap.GetString("MODSVOL");
            _mc_rapporti.row.AREAGEO = Cursor_qbe_storrap.GetString("AREAGEO");
            _mc_rapporti.row.SCOPO = Cursor_qbe_storrap.GetString("SCOPO");
            _mc_rapporti.row.NATURA = Cursor_qbe_storrap.GetString("NATURA");
            _mc_rapporti.row.RTIPO = Cursor_qbe_storrap.GetDouble("RTIPO");
            _mc_rapporti.row.RCOMP = Cursor_qbe_storrap.GetDouble("RCOMP");
            _mc_rapporti.row.RIMP = Cursor_qbe_storrap.GetDouble("RIMP");
            _mc_rapporti.row.RFREQ = Cursor_qbe_storrap.GetDouble("RFREQ");
            _mc_rapporti.row.RRAGIO = Cursor_qbe_storrap.GetDouble("RRAGIO");
            _mc_rapporti.row.RAREA = Cursor_qbe_storrap.GetDouble("RAREA");
            _mc_rapporti.row.TIPO = Cursor_qbe_storrap.GetString("TIPO");
            _mc_rapporti.row.PRGIMPRAP = Cursor_qbe_storrap.GetDouble("PRGIMPRAP");
            _mc_rapporti.row.AMMONT = Cursor_qbe_storrap.GetString("AMMONT");
            _mc_rapporti.row.DURAT = Cursor_qbe_storrap.GetString("DURAT");
            _mc_rapporti.row.IMPAPE = Cursor_qbe_storrap.GetDouble("IMPAPE");
            _mc_rapporti.row.IMPCHIU = Cursor_qbe_storrap.GetDouble("IMPCHIU");
            _mc_rapporti.row.SPLITCODE = Cursor_qbe_storrap.GetString("SPLITCODE");
            _mc_rapporti.row.MACODICE = Cursor_qbe_storrap.GetString("MACODICE");
            _mc_rapporti.row.CODDIP = Cursor_qbe_storrap.GetString("CODDIP");
            _mc_rapporti.row.STATORAP = Cursor_qbe_storrap.GetString("STATORAP");
            _mc_rapporti.row.CASTATOC = Cursor_qbe_storrap.GetDouble("CASTATOC");
            _mc_rapporti.row.CASTATOM = Cursor_qbe_storrap.GetDouble("CASTATOM");
            _mc_rapporti.row.CODICELR = Cursor_qbe_storrap.GetString("CODICELR");
            _mc_rapporti.row.CADSTATO = Cursor_qbe_storrap.GetDate("CADSTATO");
            _mc_rapporti.row.MITIG = Cursor_qbe_storrap.GetDouble("MITIG");
            _mc_rapporti.row.MITGDOC = Cursor_qbe_storrap.GetString("MITGDOC");
            _mc_rapporti.row.DAC6 = Cursor_qbe_storrap.GetString("DAC6");
            _mc_rapporti.row.FLAGDAC6 = Cursor_qbe_storrap.GetDouble("FLAGDAC6");
            _mc_rapporti.row.IBAN = Cursor_qbe_storrap.GetString("IBAN");
            _mc_rapporti.row.CODOGG = Cursor_qbe_storrap.GetString("CODOGG");
            Cursor_qbe_storrap.Next();
          }
          m_cConnectivityError = Cursor_qbe_storrap.ErrorMessage();
          Cursor_qbe_storrap.Close();
          _mc_rapporti.GoTop();
          /* Case w_chi_chiama_la_routine="STO" */
        } else if (CPLib.eqr(w_chi_chiama_la_routine,"STO")) {
          // * --- Fill memory cursor _mc_rapporti on qbe_storwap
          _mc_rapporti.Zap();
          SPBridge.HMCaller _h000001B9;
          _h000001B9 = new SPBridge.HMCaller();
          _h000001B9.Set("m_cVQRList",m_cVQRList);
          _h000001B9.Set("dadata",_ddatini);
          _h000001B9.Set("adata",_ddatfin);
          if (Cursor_qbe_storwap!=null)
            Cursor_qbe_storwap.Close();
          Cursor_qbe_storwap = new VQRHolder("qbe_storwap",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001B9,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_storwap;
            Cursor_qbe_storwap.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_stor_trasf: query on qbe_storwap returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_storwap.Eof())) {
            _mc_rapporti.AppendBlank();
            _mc_rapporti.row.RAPPORTO = Cursor_qbe_storwap.GetString("RAPPORTO");
            _mc_rapporti.row.DESCRAP = Cursor_qbe_storwap.GetString("DESCRAP");
            _mc_rapporti.row.TIPORAP = Cursor_qbe_storwap.GetString("TIPORAP");
            _mc_rapporti.row.FLAGLIRE = Cursor_qbe_storwap.GetString("FLAGLIRE");
            _mc_rapporti.row.VALUTA = Cursor_qbe_storwap.GetString("VALUTA");
            _mc_rapporti.row.CONTINUA = Cursor_qbe_storwap.GetString("CONTINUA");
            _mc_rapporti.row.TIPOAG = Cursor_qbe_storwap.GetString("TIPOAG");
            _mc_rapporti.row.DOCFILE = Cursor_qbe_storwap.GetString("DOCFILE");
            _mc_rapporti.row.NOPROT = Cursor_qbe_storwap.GetDouble("NOPROT");
            _mc_rapporti.row.TIPMOD = Cursor_qbe_storwap.GetString("TIPMOD");
            _mc_rapporti.row.DATAMOD = Cursor_qbe_storwap.GetDate("DATAMOD");
            _mc_rapporti.row.IDRAPPORTO = Cursor_qbe_storwap.GetString("IDRAPPORTO");
            _mc_rapporti.row.IDBASE = Cursor_qbe_storwap.GetString("IDBASE");
            _mc_rapporti.row.RAGIO = Cursor_qbe_storwap.GetString("RAGIO");
            _mc_rapporti.row.MODSVOL = Cursor_qbe_storwap.GetString("MODSVOL");
            _mc_rapporti.row.AREAGEO = Cursor_qbe_storwap.GetString("AREAGEO");
            _mc_rapporti.row.SCOPO = Cursor_qbe_storwap.GetString("SCOPO");
            _mc_rapporti.row.NATURA = Cursor_qbe_storwap.GetString("NATURA");
            _mc_rapporti.row.RTIPO = Cursor_qbe_storwap.GetDouble("RTIPO");
            _mc_rapporti.row.RCOMP = Cursor_qbe_storwap.GetDouble("RCOMP");
            _mc_rapporti.row.RIMP = Cursor_qbe_storwap.GetDouble("RIMP");
            _mc_rapporti.row.RFREQ = Cursor_qbe_storwap.GetDouble("RFREQ");
            _mc_rapporti.row.RRAGIO = Cursor_qbe_storwap.GetDouble("RRAGIO");
            _mc_rapporti.row.RAREA = Cursor_qbe_storwap.GetDouble("RAREA");
            _mc_rapporti.row.TIPO = Cursor_qbe_storwap.GetString("TIPO");
            _mc_rapporti.row.PRGIMPRAP = Cursor_qbe_storwap.GetDouble("PRGIMPRAP");
            _mc_rapporti.row.AMMONT = Cursor_qbe_storwap.GetString("AMMONT");
            _mc_rapporti.row.DURAT = Cursor_qbe_storwap.GetString("DURAT");
            _mc_rapporti.row.IMPAPE = Cursor_qbe_storwap.GetDouble("IMPAPE");
            _mc_rapporti.row.IMPCHIU = Cursor_qbe_storwap.GetDouble("IMPCHIU");
            _mc_rapporti.row.SPLITCODE = Cursor_qbe_storwap.GetString("SPLITCODE");
            _mc_rapporti.row.MACODICE = Cursor_qbe_storwap.GetString("MACODICE");
            _mc_rapporti.row.CODDIP = Cursor_qbe_storwap.GetString("CODDIP");
            _mc_rapporti.row.STATORAP = Cursor_qbe_storwap.GetString("STATORAP");
            _mc_rapporti.row.CASTATOC = Cursor_qbe_storwap.GetDouble("CASTATOC");
            _mc_rapporti.row.CASTATOM = Cursor_qbe_storwap.GetDouble("CASTATOM");
            _mc_rapporti.row.CODICELR = Cursor_qbe_storwap.GetString("CODICELR");
            _mc_rapporti.row.CADSTATO = Cursor_qbe_storwap.GetDate("CADSTATO");
            _mc_rapporti.row.MITIG = Cursor_qbe_storwap.GetDouble("MITIG");
            _mc_rapporti.row.MITGDOC = Cursor_qbe_storwap.GetString("MITGDOC");
            _mc_rapporti.row.DAC6 = Cursor_qbe_storwap.GetString("DAC6");
            _mc_rapporti.row.FLAGDAC6 = Cursor_qbe_storwap.GetDouble("FLAGDAC6");
            _mc_rapporti.row.IBAN = Cursor_qbe_storwap.GetString("IBAN");
            _mc_rapporti.row.CODOGG = Cursor_qbe_storwap.GetString("CODOGG");
            Cursor_qbe_storwap.Next();
          }
          m_cConnectivityError = Cursor_qbe_storwap.ErrorMessage();
          Cursor_qbe_storwap.Close();
          _mc_rapporti.GoTop();
        } // End Case
        /* gMsgProc := gMsgProc + 'Fine precaricamento dei Rapporti per la stampa'+NL // Messaggio */
        gMsgProc = gMsgProc+"Fine precaricamento dei Rapporti per la stampa"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Rapporti da elaborare: '+_mc_rapporti.RecCount()+NL // Messaggio */
        gMsgProc = gMsgProc+"Rapporti da elaborare: "+_mc_rapporti.RecCount()+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* If w_chi_chiama_la_routine='AUI' */
      if (CPLib.eqr(w_chi_chiama_la_routine,"AUI")) {
        // * --- Select from qbe_storrap
        SPBridge.HMCaller _h000001BD;
        _h000001BD = new SPBridge.HMCaller();
        _h000001BD.Set("m_cVQRList",m_cVQRList);
        _h000001BD.Set("dadata",_ddatini);
        _h000001BD.Set("adata",_ddatfin);
        if (Cursor_qbe_storrap!=null)
          Cursor_qbe_storrap.Close();
        Cursor_qbe_storrap = new VQRHolder("qbe_storrap",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001BD,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_storrap.Eof())) {
          /* w_codrap := qbe_storrap->RAPPORTO */
          w_codrap = Cursor_qbe_storrap.GetString("RAPPORTO");
          /* w_numrec := 0 */
          w_numrec = CPLib.Round(0,0);
          // * --- Select from qbe_storrap2
          SPBridge.HMCaller _h000001C0;
          _h000001C0 = new SPBridge.HMCaller();
          _h000001C0.Set("m_cVQRList",m_cVQRList);
          _h000001C0.Set("codrap",w_codrap);
          _h000001C0.Set("adata",_ddatfin);
          if (Cursor_qbe_storrap2!=null)
            Cursor_qbe_storrap2.Close();
          Cursor_qbe_storrap2 = new VQRHolder("qbe_storrap2",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001C0,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_storrap2.Eof())) {
            /* -- check sulle porcate fatte dopo le chiusure */
            /* w_numrec := qbe_storrap2->totrec */
            w_numrec = CPLib.Round(Cursor_qbe_storrap2.GetDouble("totrec"),0);
            Cursor_qbe_storrap2.Next();
          }
          m_cConnectivityError = Cursor_qbe_storrap2.ErrorMessage();
          Cursor_qbe_storrap2.Close();
          // * --- End Select
          /* If w_numrec = 0 */
          if (CPLib.eqr(w_numrec,0)) {
            /* If Empty(_oldmsg) */
            if (CPLib.Empty(_oldmsg)) {
              /* gMsgProc := gMsgProc + 'Sto elaborando il rapporto: '+w_codrap // Messaggio */
              gMsgProc = gMsgProc+"Sto elaborando il rapporto: "+w_codrap;
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sto elaborando il rapporto: '+w_codrap) // Messaggio */
              gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sto elaborando il rapporto: "+w_codrap);
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } // End If
            /* _oldmsg := 'Sto elaborando il rapporto: '+w_codrap */
            _oldmsg = "Sto elaborando il rapporto: "+w_codrap;
            // * --- Select from delegabo
            m_cServer = m_Ctx.GetServer("delegabo");
            m_cPhName = m_Ctx.GetPhName("delegabo");
            if (Cursor_delegabo!=null)
              Cursor_delegabo.Close();
            Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,w_codrap)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_delegabo.Eof())) {
              /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(delegabo->COLLEGAMEN) */
              add_sogg_mc(Cursor_delegabo.GetString("COLLEGAMEN"));
              Cursor_delegabo.Next();
            }
            m_cConnectivityError = Cursor_delegabo.ErrorMessage();
            Cursor_delegabo.Close();
            // * --- End Select
            // * --- Select from garantbo
            m_cServer = m_Ctx.GetServer("garantbo");
            m_cPhName = m_Ctx.GetPhName("garantbo");
            if (Cursor_garantbo!=null)
              Cursor_garantbo.Close();
            Cursor_garantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO "+")"+(m_Ctx.IsSharedTemp("garantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_garantbo.Eof())) {
              /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(garantbo->CODINTER) */
              add_sogg_mc(Cursor_garantbo.GetString("CODINTER"));
              Cursor_garantbo.Next();
            }
            m_cConnectivityError = Cursor_garantbo.ErrorMessage();
            Cursor_garantbo.Close();
            // * --- End Select
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,w_codrap)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(intestbo->CODINTER) */
              add_sogg_mc(Cursor_intestbo.GetString("CODINTER"));
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
            // * --- Select from soginfo
            m_cServer = m_Ctx.GetServer("soginfo");
            m_cPhName = m_Ctx.GetPhName("soginfo");
            if (Cursor_soginfo!=null)
              Cursor_soginfo.Close();
            Cursor_soginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,w_codrap)+" "+")"+(m_Ctx.IsSharedTemp("soginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_soginfo.Eof())) {
              /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(soginfo->CODSOG) */
              add_sogg_mc(Cursor_soginfo.GetString("CODSOG"));
              Cursor_soginfo.Next();
            }
            m_cConnectivityError = Cursor_soginfo.ErrorMessage();
            Cursor_soginfo.Close();
            // * --- End Select
            // * --- Select from rapopebo
            m_cServer = m_Ctx.GetServer("rapopebo");
            m_cPhName = m_Ctx.GetPhName("rapopebo");
            if (Cursor_rapopebo!=null)
              Cursor_rapopebo.Close();
            Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,w_codrap)+" "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_rapopebo.Eof())) {
              // * --- Select from fiduciabo
              m_cServer = m_Ctx.GetServer("fiduciabo");
              m_cPhName = m_Ctx.GetPhName("fiduciabo");
              if (Cursor_fiduciabo!=null)
                Cursor_fiduciabo.Close();
              Cursor_fiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_rapopebo.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("fiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_fiduciabo.Eof())) {
                /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(fiduciabo->CODSOG) */
                add_sogg_mc(Cursor_fiduciabo.GetString("CODSOG"));
                Cursor_fiduciabo.Next();
              }
              m_cConnectivityError = Cursor_fiduciabo.ErrorMessage();
              Cursor_fiduciabo.Close();
              // * --- End Select
              Cursor_rapopebo.Next();
            }
            m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
            Cursor_rapopebo.Close();
            // * --- End Select
            /* If w_tipoope = 'T' and At(w_stampa,'|E|S') <> 0 */
            if (CPLib.eqr(w_tipoope,"T") && CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
              // * --- Insert into wnarapbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("wnarapbo");
              m_cPhName = m_Ctx.GetPhName("wnarapbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wnarapbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001D6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001D6(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("CONTINUA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("NOPROT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("TIPMOD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDate("DATAMOD"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("IDRAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("NATURA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("RTIPO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("RIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("RFREQ"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("RRAGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("PRGIMPRAP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("DURAT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("IMPAPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("IMPCHIU"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("SPLITCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("MACODICE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("STATORAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("CASTATOC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("CASTATOM"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("CODICELR"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetDouble("MITIG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap.GetString("MITGDOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wnarapbo",true);
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
            // * --- Select from qbe_storrap1
            SPBridge.HMCaller _h000001D7;
            _h000001D7 = new SPBridge.HMCaller();
            _h000001D7.Set("m_cVQRList",m_cVQRList);
            _h000001D7.Set("codrap",w_codrap);
            if (Cursor_qbe_storrap1!=null)
              Cursor_qbe_storrap1.Close();
            Cursor_qbe_storrap1 = new VQRHolder("qbe_storrap1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001D7,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_storrap1.Eof())) {
              /* If w_tipoope = 'T' and At(w_stampa,'|E|S') <> 0 */
              if (CPLib.eqr(w_tipoope,"T") && CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                // * --- Insert into wapopebo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("wapopebo");
                m_cPhName = m_Ctx.GetPhName("wapopebo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wapopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001D9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000001D9(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetDate("DATAREG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetDouble("TOTLIRE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetDouble("TOTCONT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetDouble("CAMBIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetDate("DATAAGE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetDouble("PRGIMPINF"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("IDBASE2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wapopebo",true);
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
                // * --- Select from intestbo
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                if (Cursor_intestbo!=null)
                  Cursor_intestbo.Close();
                Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_intestbo.Eof())) {
                  // * --- Insert into wntestbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("wntestbo");
                  m_cPhName = m_Ctx.GetPhName("wntestbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wntestbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001DB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000001DB(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAINI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetDate("DATAFINE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wntestbo",true);
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
                  Cursor_intestbo.Next();
                }
                m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                Cursor_intestbo.Close();
                // * --- End Select
                // * --- Select from soginfo
                m_cServer = m_Ctx.GetServer("soginfo");
                m_cPhName = m_Ctx.GetPhName("soginfo");
                if (Cursor_soginfo!=null)
                  Cursor_soginfo.Close();
                Cursor_soginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("soginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_soginfo.Eof())) {
                  // * --- Insert into woginfo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("woginfo");
                  m_cPhName = m_Ctx.GetPhName("woginfo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"woginfo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001DD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000001DD(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_soginfo.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_soginfo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_soginfo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_soginfo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"woginfo",true);
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
                  Cursor_soginfo.Next();
                }
                m_cConnectivityError = Cursor_soginfo.ErrorMessage();
                Cursor_soginfo.Close();
                // * --- End Select
                // * --- Select from delegabo
                m_cServer = m_Ctx.GetServer("delegabo");
                m_cPhName = m_Ctx.GetPhName("delegabo");
                if (Cursor_delegabo!=null)
                  Cursor_delegabo.Close();
                Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_delegabo.Eof())) {
                  // * --- Insert into welegabo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("welegabo");
                  m_cPhName = m_Ctx.GetPhName("welegabo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"welegabo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001DF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000001DF(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDate("DATAINI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDate("DATARETT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDate("DATAFINE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetDouble("ABBINATO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("NOAGE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"welegabo",true);
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
                  Cursor_delegabo.Next();
                }
                m_cConnectivityError = Cursor_delegabo.ErrorMessage();
                Cursor_delegabo.Close();
                // * --- End Select
                // * --- Select from fiduciabo
                m_cServer = m_Ctx.GetServer("fiduciabo");
                m_cPhName = m_Ctx.GetPhName("fiduciabo");
                if (Cursor_fiduciabo!=null)
                  Cursor_fiduciabo.Close();
                Cursor_fiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("fiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_fiduciabo.Eof())) {
                  // * --- Insert into fiduciabo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("fiduciabo");
                  m_cPhName = m_Ctx.GetPhName("fiduciabo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fiduciabo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001E1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000001E1(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fiduciabo.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fiduciabo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fiduciabo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fiduciabo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fiduciabo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fiduciabo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fiduciabo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"fiduciabo",true);
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
                  Cursor_fiduciabo.Next();
                }
                m_cConnectivityError = Cursor_fiduciabo.ErrorMessage();
                Cursor_fiduciabo.Close();
                // * --- End Select
                // * --- Select from garantbo
                m_cServer = m_Ctx.GetServer("garantbo");
                m_cPhName = m_Ctx.GetPhName("garantbo");
                if (Cursor_garantbo!=null)
                  Cursor_garantbo.Close();
                Cursor_garantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("garantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_garantbo.Eof())) {
                  // * --- Insert into warantbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("warantbo");
                  m_cPhName = m_Ctx.GetPhName("warantbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"warantbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001E3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000001E3(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetDate("DATAINI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetDate("DATAFINE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_garantbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"warantbo",true);
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
                  Cursor_garantbo.Next();
                }
                m_cConnectivityError = Cursor_garantbo.ErrorMessage();
                Cursor_garantbo.Close();
                // * --- End Select
                // * --- Select from saldi_idp
                m_cServer = m_Ctx.GetServer("saldi_idp");
                m_cPhName = m_Ctx.GetPhName("saldi_idp");
                if (Cursor_saldi_idp!=null)
                  Cursor_saldi_idp.Close();
                Cursor_saldi_idp = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_storrap1.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("saldi_idp")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_saldi_idp.Eof())) {
                  // * --- Insert into waldi_idp from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("waldi_idp");
                  m_cPhName = m_Ctx.GetPhName("waldi_idp");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"waldi_idp",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001E5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000001E5(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_saldi_idp.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_saldi_idp.GetString("ANNO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_saldi_idp.GetString("TRIMESTRE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_saldi_idp.GetDouble("IMPORTO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_saldi_idp.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"waldi_idp",true);
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
                  Cursor_saldi_idp.Next();
                }
                m_cConnectivityError = Cursor_saldi_idp.ErrorMessage();
                Cursor_saldi_idp.Close();
                // * --- End Select
              } // End If
              /* If At(w_stampa,'|E|S') <> 0 */
              if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                // * --- Delete from saldi_idp
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("saldi_idp");
                m_cPhName = m_Ctx.GetPhName("saldi_idp");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"saldi_idp",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001E7")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storrap1.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storrap1.GetString("RAPPORTO"))+"";
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
                // * --- Delete from garantbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("garantbo");
                m_cPhName = m_Ctx.GetPhName("garantbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"garantbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001E8")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storrap1.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storrap1.GetString("RAPPORTO"))+"";
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
                // * --- Delete from fiduciabo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("fiduciabo");
                m_cPhName = m_Ctx.GetPhName("fiduciabo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fiduciabo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001E9")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storrap1.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storrap1.GetString("IDBASE"))+"";
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
                // * --- Delete from delegabo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("delegabo");
                m_cPhName = m_Ctx.GetPhName("delegabo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"delegabo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001EA")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storrap1.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storrap1.GetString("RAPPORTO"))+"";
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
                // * --- Delete from soginfo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("soginfo");
                m_cPhName = m_Ctx.GetPhName("soginfo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"soginfo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001EB")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storrap1.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storrap1.GetString("IDBASE"))+"";
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
                // * --- Delete from intestbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001EC")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storrap1.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storrap1.GetString("RAPPORTO"))+"";
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
                // * --- Delete from rapopebo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("rapopebo");
                m_cPhName = m_Ctx.GetPhName("rapopebo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001ED")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storrap1.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storrap1.GetString("IDBASE"))+"";
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
              Cursor_qbe_storrap1.Next();
            }
            m_cConnectivityError = Cursor_qbe_storrap1.ErrorMessage();
            Cursor_qbe_storrap1.Close();
            // * --- End Select
            /* If At(w_stampa,'|E|S') <> 0 */
            if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
              // * --- Delete from anarapbo
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("anarapbo");
              m_cPhName = m_Ctx.GetPhName("anarapbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000001EF")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer),m_cServer,w_codrap)+"";
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
          /* _contaop := _contaop+1 */
          _contaop = CPLib.Round(_contaop+1,0);
          Cursor_qbe_storrap.Next();
        }
        m_cConnectivityError = Cursor_qbe_storrap.ErrorMessage();
        Cursor_qbe_storrap.Close();
        // * --- End Select
        /* ElseIf w_chi_chiama_la_routine='STO' */
      } else if (CPLib.eqr(w_chi_chiama_la_routine,"STO")) {
        // * --- Select from qbe_storwap
        SPBridge.HMCaller _h000001F1;
        _h000001F1 = new SPBridge.HMCaller();
        _h000001F1.Set("m_cVQRList",m_cVQRList);
        _h000001F1.Set("dadata",_ddatini);
        _h000001F1.Set("adata",_ddatfin);
        if (Cursor_qbe_storwap!=null)
          Cursor_qbe_storwap.Close();
        Cursor_qbe_storwap = new VQRHolder("qbe_storwap",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001F1,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_storwap.Eof())) {
          /* w_codrap := qbe_storwap->RAPPORTO */
          w_codrap = Cursor_qbe_storwap.GetString("RAPPORTO");
          /* w_numrec := 0 */
          w_numrec = CPLib.Round(0,0);
          // * --- Select from qbe_storwap2
          SPBridge.HMCaller _h000001F4;
          _h000001F4 = new SPBridge.HMCaller();
          _h000001F4.Set("m_cVQRList",m_cVQRList);
          _h000001F4.Set("codrap",w_codrap);
          _h000001F4.Set("adata",_ddatfin);
          if (Cursor_qbe_storwap2!=null)
            Cursor_qbe_storwap2.Close();
          Cursor_qbe_storwap2 = new VQRHolder("qbe_storwap2",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001F4,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_storwap2.Eof())) {
            /* -- check sulle porcate fatte dopo le chiusure */
            /* w_numrec := qbe_storwap2->totrec */
            w_numrec = CPLib.Round(Cursor_qbe_storwap2.GetDouble("totrec"),0);
            Cursor_qbe_storwap2.Next();
          }
          m_cConnectivityError = Cursor_qbe_storwap2.ErrorMessage();
          Cursor_qbe_storwap2.Close();
          // * --- End Select
          /* If w_numrec = 0 */
          if (CPLib.eqr(w_numrec,0)) {
            /* If Empty(_oldmsg) */
            if (CPLib.Empty(_oldmsg)) {
              /* gMsgProc := gMsgProc + 'Sto elaborando il rapporto: '+w_codrap // Messaggio */
              gMsgProc = gMsgProc+"Sto elaborando il rapporto: "+w_codrap;
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sto elaborando il rapporto: '+w_codrap) // Messaggio */
              gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sto elaborando il rapporto: "+w_codrap);
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } // End If
            /* _oldmsg := 'Sto elaborando il rapporto: '+w_codrap */
            _oldmsg = "Sto elaborando il rapporto: "+w_codrap;
            // * --- Select from welegabo
            m_cServer = m_Ctx.GetServer("welegabo");
            m_cPhName = m_Ctx.GetPhName("welegabo");
            if (Cursor_welegabo!=null)
              Cursor_welegabo.Close();
            Cursor_welegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,w_codrap)+" "+")"+(m_Ctx.IsSharedTemp("welegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_welegabo.Eof())) {
              /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(welegabo->COLLEGAMEN) */
              add_sogg_mc(Cursor_welegabo.GetString("COLLEGAMEN"));
              Cursor_welegabo.Next();
            }
            m_cConnectivityError = Cursor_welegabo.ErrorMessage();
            Cursor_welegabo.Close();
            // * --- End Select
            // * --- Select from warantbo
            m_cServer = m_Ctx.GetServer("warantbo");
            m_cPhName = m_Ctx.GetPhName("warantbo");
            if (Cursor_warantbo!=null)
              Cursor_warantbo.Close();
            Cursor_warantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO "+")"+(m_Ctx.IsSharedTemp("warantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_warantbo.Eof())) {
              /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(warantbo->CODINTER) */
              add_sogg_mc(Cursor_warantbo.GetString("CODINTER"));
              Cursor_warantbo.Next();
            }
            m_cConnectivityError = Cursor_warantbo.ErrorMessage();
            Cursor_warantbo.Close();
            // * --- End Select
            // * --- Select from wntestbo
            m_cServer = m_Ctx.GetServer("wntestbo");
            m_cPhName = m_Ctx.GetPhName("wntestbo");
            if (Cursor_wntestbo!=null)
              Cursor_wntestbo.Close();
            Cursor_wntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,w_codrap)+" "+")"+(m_Ctx.IsSharedTemp("wntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wntestbo.Eof())) {
              /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(wntestbo->CODINTER) */
              add_sogg_mc(Cursor_wntestbo.GetString("CODINTER"));
              Cursor_wntestbo.Next();
            }
            m_cConnectivityError = Cursor_wntestbo.ErrorMessage();
            Cursor_wntestbo.Close();
            // * --- End Select
            // * --- Select from woginfo
            m_cServer = m_Ctx.GetServer("woginfo");
            m_cPhName = m_Ctx.GetPhName("woginfo");
            if (Cursor_woginfo!=null)
              Cursor_woginfo.Close();
            Cursor_woginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,w_codrap)+" "+")"+(m_Ctx.IsSharedTemp("woginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_woginfo.Eof())) {
              /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(woginfo->CODSOG) */
              add_sogg_mc(Cursor_woginfo.GetString("CODSOG"));
              Cursor_woginfo.Next();
            }
            m_cConnectivityError = Cursor_woginfo.ErrorMessage();
            Cursor_woginfo.Close();
            // * --- End Select
            // * --- Select from wapopebo
            m_cServer = m_Ctx.GetServer("wapopebo");
            m_cPhName = m_Ctx.GetPhName("wapopebo");
            if (Cursor_wapopebo!=null)
              Cursor_wapopebo.Close();
            Cursor_wapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,w_codrap)+" "+")"+(m_Ctx.IsSharedTemp("wapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wapopebo.Eof())) {
              // * --- Select from widuciabo
              m_cServer = m_Ctx.GetServer("widuciabo");
              m_cPhName = m_Ctx.GetPhName("widuciabo");
              if (Cursor_widuciabo!=null)
                Cursor_widuciabo.Close();
              Cursor_widuciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_wapopebo.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("widuciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_widuciabo.Eof())) {
                /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(widuciabo->CODSOG) */
                add_sogg_mc(Cursor_widuciabo.GetString("CODSOG"));
                Cursor_widuciabo.Next();
              }
              m_cConnectivityError = Cursor_widuciabo.ErrorMessage();
              Cursor_widuciabo.Close();
              // * --- End Select
              Cursor_wapopebo.Next();
            }
            m_cConnectivityError = Cursor_wapopebo.ErrorMessage();
            Cursor_wapopebo.Close();
            // * --- End Select
            /* If At(w_stampa,'|E|S') <> 0 */
            if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
              // * --- Select from qbe_storwap1
              SPBridge.HMCaller _h0000020A;
              _h0000020A = new SPBridge.HMCaller();
              _h0000020A.Set("m_cVQRList",m_cVQRList);
              _h0000020A.Set("codrap",w_codrap);
              if (Cursor_qbe_storwap1!=null)
                Cursor_qbe_storwap1.Close();
              Cursor_qbe_storwap1 = new VQRHolder("qbe_storwap1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000020A,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_storwap1.Eof())) {
                // * --- Delete from waldi_idp
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("waldi_idp");
                m_cPhName = m_Ctx.GetPhName("waldi_idp");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"waldi_idp",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000020B")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwap1.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwap1.GetString("RAPPORTO"))+"";
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
                // * --- Delete from warantbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("warantbo");
                m_cPhName = m_Ctx.GetPhName("warantbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"warantbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000020C")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwap1.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwap1.GetString("RAPPORTO"))+"";
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
                // * --- Delete from widuciabo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("widuciabo");
                m_cPhName = m_Ctx.GetPhName("widuciabo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"widuciabo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000020D")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwap1.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwap1.GetString("IDBASE"))+"";
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
                // * --- Delete from welegabo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("welegabo");
                m_cPhName = m_Ctx.GetPhName("welegabo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"welegabo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000020E")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwap1.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwap1.GetString("RAPPORTO"))+"";
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
                // * --- Delete from woginfo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("woginfo");
                m_cPhName = m_Ctx.GetPhName("woginfo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"woginfo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000020F")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwap1.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwap1.GetString("IDBASE"))+"";
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
                // * --- Delete from wntestbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("wntestbo");
                m_cPhName = m_Ctx.GetPhName("wntestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wntestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000210")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwap1.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwap1.GetString("RAPPORTO"))+"";
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
                // * --- Delete from wapopebo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("wapopebo");
                m_cPhName = m_Ctx.GetPhName("wapopebo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wapopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000211")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwap1.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwap1.GetString("IDBASE"))+"";
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
                Cursor_qbe_storwap1.Next();
              }
              m_cConnectivityError = Cursor_qbe_storwap1.ErrorMessage();
              Cursor_qbe_storwap1.Close();
              // * --- End Select
              // * --- Delete from wnarapbo
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("wnarapbo");
              m_cPhName = m_Ctx.GetPhName("wnarapbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wnarapbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000212")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer),m_cServer,w_codrap)+"";
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
          /* _contaop := _contaop+1 */
          _contaop = CPLib.Round(_contaop+1,0);
          Cursor_qbe_storwap.Next();
        }
        m_cConnectivityError = Cursor_qbe_storwap.ErrorMessage();
        Cursor_qbe_storwap.Close();
        // * --- End Select
      } // End If
      /* gMsgProc := gMsgProc +'Sono stati '+ iif(w_tipoope='T','Trasferiti ','Cancellati ')+LRTrim(Str(_contaop,10,0))+" rapporti"+ NL */
      gMsgProc = gMsgProc+"Sono stati "+(CPLib.eqr(w_tipoope,"T")?"Trasferiti ":"Cancellati ")+CPLib.LRTrim(CPLib.Str(_contaop,10,0))+" rapporti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_storrap!=null)
          Cursor_qbe_storrap.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_storwap!=null)
          Cursor_qbe_storwap.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_storrap2!=null)
          Cursor_qbe_storrap2.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_garantbo!=null)
          Cursor_garantbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_soginfo!=null)
          Cursor_soginfo.Close();
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
      try {
        if (Cursor_fiduciabo!=null)
          Cursor_fiduciabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_storrap1!=null)
          Cursor_qbe_storrap1.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_saldi_idp!=null)
          Cursor_saldi_idp.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_storwap2!=null)
          Cursor_qbe_storwap2.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_welegabo!=null)
          Cursor_welegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_warantbo!=null)
          Cursor_warantbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wntestbo!=null)
          Cursor_wntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_woginfo!=null)
          Cursor_woginfo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wapopebo!=null)
          Cursor_wapopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_widuciabo!=null)
          Cursor_widuciabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_storwap1!=null)
          Cursor_qbe_storwap1.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void anag() throws Exception {
    CPResultSet Cursor_intestit=null;
    try {
      /* arrivato_in_fondo_al_memory_cursor Bool := False */
      boolean arrivato_in_fondo_al_memory_cursor;
      arrivato_in_fondo_al_memory_cursor = false;
      /* _delete_count Numeric(0, 0) := 0 */
      double _delete_count;
      _delete_count = CPLib.Round(0,0);
      /* _esitoCancellazione Char(0) */
      String _esitoCancellazione;
      _esitoCancellazione = CPLib.Space(0);
      for (MemoryCursorRow_mcpersonstorico_mcrdef rw_pnf : _mc_soggetti_pnf._iterable_()) {
        // * --- Select from intestit
        m_cServer = m_Ctx.GetServer("intestit");
        m_cPhName = m_Ctx.GetPhName("intestit");
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
        Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_pnf.CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_pnf.CONNES)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestit.Eof())) {
          /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(intestit->CODINTER) */
          add_sogg_mc(Cursor_intestit.GetString("CODINTER"));
          Cursor_intestit.Next();
        }
        m_cConnectivityError = Cursor_intestit.ErrorMessage();
        Cursor_intestit.Close();
        // * --- End Select
      }
      /* gMsgProc := gMsgProc + 'Inizio analisi anagrafiche collegate, entità da elaborare PF: '+_mc_soggetti_pf.RecCount()+' NPF: '+_mc_soggetti_pnf.RecCount()+NL // Messaggio */
      gMsgProc = gMsgProc+"Inizio analisi anagrafiche collegate, entità da elaborare PF: "+_mc_soggetti_pf.RecCount()+" NPF: "+_mc_soggetti_pnf.RecCount()+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _mc_soggetti_pnf.GoTop() // Soggetti PNF potenzialmente dangling */
      _mc_soggetti_pnf.GoTop();
      /* While not(_mc_soggetti_pnf.Eof()) */
      while ( ! (_mc_soggetti_pnf.Eof())) {
        /* If not(Empty(_mc_soggetti_pnf.CONNES)) */
        if ( ! (CPLib.Empty(_mc_soggetti_pnf.row.CONNES))) {
          /* gMsgImp := "Analisi soggetto: "+_mc_soggetti_pnf.CONNES+" ("+_mc_soggetti_pnf.RAGSOC+")" */
          gMsgImp = "Analisi soggetto: "+_mc_soggetti_pnf.row.CONNES+" ("+_mc_soggetti_pnf.row.RAGSOC+")";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _esitoCancellazione := delete_chk(_mc_soggetti_pnf.CONNES,rowTabelle) */
          _esitoCancellazione = delete_chk(_mc_soggetti_pnf.row.CONNES,rowTabelle);
          /* If _esitoCancellazione="" */
          if (CPLib.eqr(_esitoCancellazione,"")) {
            /* _mc_soggetti_pnf.NOSARA := 'E' // E = Eliminato */
            _mc_soggetti_pnf.row.NOSARA = "E";
            /* _delete_count := _delete_count+1 */
            _delete_count = CPLib.Round(_delete_count+1,0);
          } else { // Else
            /* _mc_soggetti_pnf.NOSARA := _esitoCancellazione // E = Eliminato */
            _mc_soggetti_pnf.row.NOSARA = _esitoCancellazione;
          } // End If
          /* _mc_soggetti_pnf.SaveRow() */
          _mc_soggetti_pnf.SaveRow();
          /* _mc_soggetti_pnf.Next() // Soggetti potenzialmente dangling */
          _mc_soggetti_pnf.Next();
        } // End If
      } // End While
      /* gMsgProc := gMsgProc + 'Fine analisi anagrafiche collegate, entità eliminate PNF: '+Str(_delete_count,10,0)+NL // Messaggio */
      gMsgProc = gMsgProc+"Fine analisi anagrafiche collegate, entità eliminate PNF: "+CPLib.Str(_delete_count,10,0)+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _delete_count := 0 */
      _delete_count = CPLib.Round(0,0);
      /* arrivato_in_fondo_al_memory_cursor := False */
      arrivato_in_fondo_al_memory_cursor = false;
      /* _mc_soggetti_pf.GoTop() // Soggetti PF potenzialmente dangling */
      _mc_soggetti_pf.GoTop();
      /* While not(_mc_soggetti_pf.Eof()) */
      while ( ! (_mc_soggetti_pf.Eof())) {
        /* gMsgImp := "Analisi soggetto: "+_mc_soggetti_pf.CONNES+" ("+_mc_soggetti_pf.RAGSOC+")" */
        gMsgImp = "Analisi soggetto: "+_mc_soggetti_pf.row.CONNES+" ("+_mc_soggetti_pf.row.RAGSOC+")";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _esitoCancellazione := delete_chk(_mc_soggetti_pf.CONNES,rowTabelle) */
        _esitoCancellazione = delete_chk(_mc_soggetti_pf.row.CONNES,rowTabelle);
        /* If _esitoCancellazione="" */
        if (CPLib.eqr(_esitoCancellazione,"")) {
          /* _mc_soggetti_pf.NOSARA := 'E' // E = Eliminato */
          _mc_soggetti_pf.row.NOSARA = "E";
          /* _delete_count := _delete_count+1 */
          _delete_count = CPLib.Round(_delete_count+1,0);
        } else { // Else
          /* _mc_soggetti_pf.NOSARA := _esitoCancellazione // E = Eliminato */
          _mc_soggetti_pf.row.NOSARA = _esitoCancellazione;
        } // End If
        /* _mc_soggetti_pf.SaveRow() */
        _mc_soggetti_pf.SaveRow();
        /* _mc_soggetti_pf.Next() // Soggetti potenzialmente dangling */
        _mc_soggetti_pf.Next();
      } // End While
      /* If At(w_stampa,'|E|S') <> 0 */
      if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
        /* gMsgProc := gMsgProc + 'Fine analisi anagrafiche collegate, entità eliminate PF: '+Str(_delete_count,10,0)+NL // Messaggio */
        gMsgProc = gMsgProc+"Fine analisi anagrafiche collegate, entità eliminate PF: "+CPLib.Str(_delete_count,10,0)+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
    } finally {
      try {
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  String delete_chk(String w_CONNES,MemoryCursorRow_mctabelle_mcrdef rTabelle) throws Exception {
    CPResultSet Cursor_operazbo=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_beneficope=null;
    CPResultSet Cursor_terzistiope=null;
    CPResultSet Cursor_fraziobo=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_terzistifrz=null;
    CPResultSet Cursor_xperazbo=null;
    CPResultSet Cursor_xlientiope=null;
    CPResultSet Cursor_xeneficope=null;
    CPResultSet Cursor_xogopebo=null;
    CPResultSet Cursor_xerzistiope=null;
    CPResultSet Cursor_xraziobo=null;
    CPResultSet Cursor_xlientifrz=null;
    CPResultSet Cursor_xeneficfrz=null;
    CPResultSet Cursor_xogopefbo=null;
    CPResultSet Cursor_xerzistifrz=null;
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Cursor_soginfo=null;
    CPResultSet Cursor_fiduciabo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_garantbo=null;
    CPResultSet Cursor_xapopebo=null;
    CPResultSet Cursor_xoginfo=null;
    CPResultSet Cursor_xiduciabo=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_xelegabo=null;
    CPResultSet Cursor_xarantbo=null;
    CPResultSet Cursor_rapotit=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_xapotit=null;
    CPResultSet Cursor_xntestit=null;
    CPResultSet Cursor_japopebo=null;
    CPResultSet Cursor_jntestbo=null;
    CPResultSet Cursor_jelegabo=null;
    CPResultSet Cursor_jarantbo=null;
    CPResultSet Cursor_japotit=null;
    CPResultSet Cursor_jntestit=null;
    CPResultSet Cursor_jperazbo=null;
    CPResultSet Cursor_kperazbo=null;
    CPResultSet Cursor_opextrbo=null;
    CPResultSet Cursor_wperazbo=null;
    CPResultSet Cursor_wlientiope=null;
    CPResultSet Cursor_weneficope=null;
    CPResultSet Cursor_wogopebo=null;
    CPResultSet Cursor_werzistiope=null;
    CPResultSet Cursor_wraziobo=null;
    CPResultSet Cursor_wlientifrz=null;
    CPResultSet Cursor_weneficfrz=null;
    CPResultSet Cursor_wogopefbo=null;
    CPResultSet Cursor_werzistifrz=null;
    CPResultSet Cursor_wapopebo=null;
    CPResultSet Cursor_woginfo=null;
    CPResultSet Cursor_widuciabo=null;
    CPResultSet Cursor_wntestbo=null;
    CPResultSet Cursor_welegabo=null;
    CPResultSet Cursor_warantbo=null;
    try {
      /* w_CONNES Char(16) */
      /* rTabelle Row(mcTabelle.MCRDef) */
      /* conta Numeric(10, 0) */
      double conta;
      conta = 0;
      /* found Bool */
      boolean found;
      found = false;
      /* _whereFound Char(0) := "" // Indica dove il soggetto è stato riscontrato */
      String _whereFound;
      _whereFound = "";
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* found := False */
      found = false;
      /* Dichiarazione variabili globali */
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // * --- Select from operazbo
      m_cServer = m_Ctx.GetServer("operazbo");
      m_cPhName = m_Ctx.GetPhName("operazbo");
      if (Cursor_operazbo!=null)
        Cursor_operazbo.Close();
      Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNALTRO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_operazbo.Eof())) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        Cursor_operazbo.Next();
      }
      m_cConnectivityError = Cursor_operazbo.ErrorMessage();
      Cursor_operazbo.Close();
      // * --- End Select
      /* If conta > 0 */
      if (CPLib.gt(conta,0)) {
        /* If rTabelle._sogopebo */
        if (rTabelle._sogopebo) {
          // * --- Select from sogopebo
          m_cServer = m_Ctx.GetServer("sogopebo");
          m_cPhName = m_Ctx.GetPhName("sogopebo");
          if (Cursor_sogopebo!=null)
            Cursor_sogopebo.Close();
          Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_sogopebo.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            Cursor_sogopebo.Next();
          }
          m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
          Cursor_sogopebo.Close();
          // * --- End Select
        } // End If
        /* If rTabelle._clientiope */
        if (rTabelle._clientiope) {
          // * --- Select from clientiope
          m_cServer = m_Ctx.GetServer("clientiope");
          m_cPhName = m_Ctx.GetPhName("clientiope");
          if (Cursor_clientiope!=null)
            Cursor_clientiope.Close();
          Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_clientiope.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            Cursor_clientiope.Next();
          }
          m_cConnectivityError = Cursor_clientiope.ErrorMessage();
          Cursor_clientiope.Close();
          // * --- End Select
        } // End If
        /* If rTabelle._beneficope */
        if (rTabelle._beneficope) {
          // * --- Select from beneficope
          m_cServer = m_Ctx.GetServer("beneficope");
          m_cPhName = m_Ctx.GetPhName("beneficope");
          if (Cursor_beneficope!=null)
            Cursor_beneficope.Close();
          Cursor_beneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("beneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_beneficope.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            Cursor_beneficope.Next();
          }
          m_cConnectivityError = Cursor_beneficope.ErrorMessage();
          Cursor_beneficope.Close();
          // * --- End Select
        } // End If
        /* If rTabelle._terzistiope */
        if (rTabelle._terzistiope) {
          // * --- Select from terzistiope
          m_cServer = m_Ctx.GetServer("terzistiope");
          m_cPhName = m_Ctx.GetPhName("terzistiope");
          if (Cursor_terzistiope!=null)
            Cursor_terzistiope.Close();
          Cursor_terzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("terzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_terzistiope.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            Cursor_terzistiope.Next();
          }
          m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
          Cursor_terzistiope.Close();
          // * --- End Select
        } // End If
        /* found := True */
        found = true;
        /* _whereFound := "Operazioni AUI" */
        _whereFound = "Operazioni AUI";
      } // End If
      /* If not(found) */
      if ( ! (found)) {
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        // * --- Select from fraziobo
        m_cServer = m_Ctx.GetServer("fraziobo");
        m_cPhName = m_Ctx.GetPhName("fraziobo");
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
        Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNALTRO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_fraziobo.Eof())) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          Cursor_fraziobo.Next();
        }
        m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
        Cursor_fraziobo.Close();
        // * --- End Select
        /* If conta > 0 */
        if (CPLib.gt(conta,0)) {
          /* If rTabelle._sogopefbo */
          if (rTabelle._sogopefbo) {
            // * --- Select from sogopefbo
            m_cServer = m_Ctx.GetServer("sogopefbo");
            m_cPhName = m_Ctx.GetPhName("sogopefbo");
            if (Cursor_sogopefbo!=null)
              Cursor_sogopefbo.Close();
            Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_sogopefbo.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_sogopefbo.Next();
            }
            m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
            Cursor_sogopefbo.Close();
            // * --- End Select
          } // End If
          /* If rTabelle._clientifrz */
          if (rTabelle._clientifrz) {
            // * --- Select from clientifrz
            m_cServer = m_Ctx.GetServer("clientifrz");
            m_cPhName = m_Ctx.GetPhName("clientifrz");
            if (Cursor_clientifrz!=null)
              Cursor_clientifrz.Close();
            Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_clientifrz.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_clientifrz.Next();
            }
            m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
            Cursor_clientifrz.Close();
            // * --- End Select
          } // End If
          /* If rTabelle._beneficfrz */
          if (rTabelle._beneficfrz) {
            // * --- Select from beneficfrz
            m_cServer = m_Ctx.GetServer("beneficfrz");
            m_cPhName = m_Ctx.GetPhName("beneficfrz");
            if (Cursor_beneficfrz!=null)
              Cursor_beneficfrz.Close();
            Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_beneficfrz.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_beneficfrz.Next();
            }
            m_cConnectivityError = Cursor_beneficfrz.ErrorMessage();
            Cursor_beneficfrz.Close();
            // * --- End Select
          } // End If
          /* If rTabelle._terzistifrz */
          if (rTabelle._terzistifrz) {
            // * --- Select from terzistifrz
            m_cServer = m_Ctx.GetServer("terzistifrz");
            m_cPhName = m_Ctx.GetPhName("terzistifrz");
            if (Cursor_terzistifrz!=null)
              Cursor_terzistifrz.Close();
            Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_terzistifrz.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_terzistifrz.Next();
            }
            m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
            Cursor_terzistifrz.Close();
            // * --- End Select
          } // End If
          /* found := True */
          found = true;
          /* _whereFound := "Frazionate AUI" */
          _whereFound = "Frazionate AUI";
        } // End If
      } // End If
      /* If not(found) */
      if ( ! (found)) {
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* If rTabelle._xperazbo */
        if (rTabelle._xperazbo) {
          // * --- Select from xperazbo
          m_cServer = m_Ctx.GetServer("xperazbo");
          m_cPhName = m_Ctx.GetPhName("xperazbo");
          if (Cursor_xperazbo!=null)
            Cursor_xperazbo.Close();
          Cursor_xperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNALTRO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xperazbo.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            Cursor_xperazbo.Next();
          }
          m_cConnectivityError = Cursor_xperazbo.ErrorMessage();
          Cursor_xperazbo.Close();
          // * --- End Select
          /* If conta > 0 */
          if (CPLib.gt(conta,0)) {
            /* If rTabelle._xlientiope */
            if (rTabelle._xlientiope) {
              // * --- Select from xlientiope
              m_cServer = m_Ctx.GetServer("xlientiope");
              m_cPhName = m_Ctx.GetPhName("xlientiope");
              if (Cursor_xlientiope!=null)
                Cursor_xlientiope.Close();
              Cursor_xlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xlientiope.Eof())) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                Cursor_xlientiope.Next();
              }
              m_cConnectivityError = Cursor_xlientiope.ErrorMessage();
              Cursor_xlientiope.Close();
              // * --- End Select
            } // End If
            /* If rTabelle._xeneficope */
            if (rTabelle._xeneficope) {
              // * --- Select from xeneficope
              m_cServer = m_Ctx.GetServer("xeneficope");
              m_cPhName = m_Ctx.GetPhName("xeneficope");
              if (Cursor_xeneficope!=null)
                Cursor_xeneficope.Close();
              Cursor_xeneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xeneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xeneficope.Eof())) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                Cursor_xeneficope.Next();
              }
              m_cConnectivityError = Cursor_xeneficope.ErrorMessage();
              Cursor_xeneficope.Close();
              // * --- End Select
            } // End If
            /* If rTabelle._xogopebo */
            if (rTabelle._xogopebo) {
              // * --- Select from xogopebo
              m_cServer = m_Ctx.GetServer("xogopebo");
              m_cPhName = m_Ctx.GetPhName("xogopebo");
              if (Cursor_xogopebo!=null)
                Cursor_xogopebo.Close();
              Cursor_xogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xogopebo.Eof())) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                Cursor_xogopebo.Next();
              }
              m_cConnectivityError = Cursor_xogopebo.ErrorMessage();
              Cursor_xogopebo.Close();
              // * --- End Select
            } // End If
            /* If rTabelle._xerzistiope */
            if (rTabelle._xerzistiope) {
              // * --- Select from xerzistiope
              m_cServer = m_Ctx.GetServer("xerzistiope");
              m_cPhName = m_Ctx.GetPhName("xerzistiope");
              if (Cursor_xerzistiope!=null)
                Cursor_xerzistiope.Close();
              Cursor_xerzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xerzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xerzistiope.Eof())) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                Cursor_xerzistiope.Next();
              }
              m_cConnectivityError = Cursor_xerzistiope.ErrorMessage();
              Cursor_xerzistiope.Close();
              // * --- End Select
            } // End If
            /* found := True */
            found = true;
            /* _whereFound := "Operazioni Provvisorie" */
            _whereFound = "Operazioni Provvisorie";
          } // End If
        } // End If
      } // End If
      /* If not(found) */
      if ( ! (found)) {
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* If rTabelle._xraziobo */
        if (rTabelle._xraziobo) {
          // * --- Select from xraziobo
          m_cServer = m_Ctx.GetServer("xraziobo");
          m_cPhName = m_Ctx.GetPhName("xraziobo");
          if (Cursor_xraziobo!=null)
            Cursor_xraziobo.Close();
          Cursor_xraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNALTRO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xraziobo.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            Cursor_xraziobo.Next();
          }
          m_cConnectivityError = Cursor_xraziobo.ErrorMessage();
          Cursor_xraziobo.Close();
          // * --- End Select
          /* If conta > 0 */
          if (CPLib.gt(conta,0)) {
            /* If rTabelle._xlientifrz */
            if (rTabelle._xlientifrz) {
              // * --- Select from xlientifrz
              m_cServer = m_Ctx.GetServer("xlientifrz");
              m_cPhName = m_Ctx.GetPhName("xlientifrz");
              if (Cursor_xlientifrz!=null)
                Cursor_xlientifrz.Close();
              Cursor_xlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xlientifrz.Eof())) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                Cursor_xlientifrz.Next();
              }
              m_cConnectivityError = Cursor_xlientifrz.ErrorMessage();
              Cursor_xlientifrz.Close();
              // * --- End Select
            } // End If
            /* If rTabelle._xeneficfrz */
            if (rTabelle._xeneficfrz) {
              // * --- Select from xeneficfrz
              m_cServer = m_Ctx.GetServer("xeneficfrz");
              m_cPhName = m_Ctx.GetPhName("xeneficfrz");
              if (Cursor_xeneficfrz!=null)
                Cursor_xeneficfrz.Close();
              Cursor_xeneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xeneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xeneficfrz.Eof())) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                Cursor_xeneficfrz.Next();
              }
              m_cConnectivityError = Cursor_xeneficfrz.ErrorMessage();
              Cursor_xeneficfrz.Close();
              // * --- End Select
            } // End If
            /* If rTabelle._xogopefbo */
            if (rTabelle._xogopefbo) {
              // * --- Select from xogopefbo
              m_cServer = m_Ctx.GetServer("xogopefbo");
              m_cPhName = m_Ctx.GetPhName("xogopefbo");
              if (Cursor_xogopefbo!=null)
                Cursor_xogopefbo.Close();
              Cursor_xogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xogopefbo.Eof())) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                Cursor_xogopefbo.Next();
              }
              m_cConnectivityError = Cursor_xogopefbo.ErrorMessage();
              Cursor_xogopefbo.Close();
              // * --- End Select
            } // End If
            /* If rTabelle._xerzistifrz */
            if (rTabelle._xerzistifrz) {
              // * --- Select from xerzistifrz
              m_cServer = m_Ctx.GetServer("xerzistifrz");
              m_cPhName = m_Ctx.GetPhName("xerzistifrz");
              if (Cursor_xerzistifrz!=null)
                Cursor_xerzistifrz.Close();
              Cursor_xerzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xerzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_xerzistifrz.Eof())) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                Cursor_xerzistifrz.Next();
              }
              m_cConnectivityError = Cursor_xerzistifrz.ErrorMessage();
              Cursor_xerzistifrz.Close();
              // * --- End Select
            } // End If
            /* found := True */
            found = true;
            /* _whereFound := "Frazionate Provvisorie" */
            _whereFound = "Frazionate Provvisorie";
          } // End If
        } // End If
      } // End If
      /* If not(found) */
      if ( ! (found)) {
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* If rTabelle._rapopebo */
        if (rTabelle._rapopebo) {
          // * --- Select from rapopebo
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          if (Cursor_rapopebo!=null)
            Cursor_rapopebo.Close();
          Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_rapopebo.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            Cursor_rapopebo.Next();
          }
          m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
          Cursor_rapopebo.Close();
          // * --- End Select
          /* If rTabelle._soginfo */
          if (rTabelle._soginfo) {
            // * --- Select from soginfo
            m_cServer = m_Ctx.GetServer("soginfo");
            m_cPhName = m_Ctx.GetPhName("soginfo");
            if (Cursor_soginfo!=null)
              Cursor_soginfo.Close();
            Cursor_soginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("soginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_soginfo.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_soginfo.Next();
            }
            m_cConnectivityError = Cursor_soginfo.ErrorMessage();
            Cursor_soginfo.Close();
            // * --- End Select
          } // End If
          /* If rTabelle._fiduciabo */
          if (rTabelle._fiduciabo) {
            // * --- Select from fiduciabo
            m_cServer = m_Ctx.GetServer("fiduciabo");
            m_cPhName = m_Ctx.GetPhName("fiduciabo");
            if (Cursor_fiduciabo!=null)
              Cursor_fiduciabo.Close();
            Cursor_fiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("fiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_fiduciabo.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_fiduciabo.Next();
            }
            m_cConnectivityError = Cursor_fiduciabo.ErrorMessage();
            Cursor_fiduciabo.Close();
            // * --- End Select
          } // End If
          /* If rTabelle._intestbo */
          if (rTabelle._intestbo) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
          } // End If
          /* If rTabelle._delegabo */
          if (rTabelle._delegabo) {
            // * --- Select from delegabo
            m_cServer = m_Ctx.GetServer("delegabo");
            m_cPhName = m_Ctx.GetPhName("delegabo");
            if (Cursor_delegabo!=null)
              Cursor_delegabo.Close();
            Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_delegabo.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_delegabo.Next();
            }
            m_cConnectivityError = Cursor_delegabo.ErrorMessage();
            Cursor_delegabo.Close();
            // * --- End Select
          } // End If
          /* If rTabelle._garantbo */
          if (rTabelle._garantbo) {
            // * --- Select from garantbo
            m_cServer = m_Ctx.GetServer("garantbo");
            m_cPhName = m_Ctx.GetPhName("garantbo");
            if (Cursor_garantbo!=null)
              Cursor_garantbo.Close();
            Cursor_garantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER "+")"+(m_Ctx.IsSharedTemp("garantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_garantbo.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_garantbo.Next();
            }
            m_cConnectivityError = Cursor_garantbo.ErrorMessage();
            Cursor_garantbo.Close();
            // * --- End Select
          } // End If
          /* If conta > 0 */
          if (CPLib.gt(conta,0)) {
            /* found := True */
            found = true;
            /* _whereFound := "Rapporti Continuativi AUI" */
            _whereFound = "Rapporti Continuativi AUI";
          } // End If
        } // End If
      } // End If
      /* If not(found) */
      if ( ! (found)) {
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* If rTabelle._xapopebo */
        if (rTabelle._xapopebo) {
          // * --- Select from xapopebo
          m_cServer = m_Ctx.GetServer("xapopebo");
          m_cPhName = m_Ctx.GetPhName("xapopebo");
          if (Cursor_xapopebo!=null)
            Cursor_xapopebo.Close();
          Cursor_xapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xapopebo.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            Cursor_xapopebo.Next();
          }
          m_cConnectivityError = Cursor_xapopebo.ErrorMessage();
          Cursor_xapopebo.Close();
          // * --- End Select
          /* If rTabelle._xoginfo */
          if (rTabelle._xoginfo) {
            // * --- Select from xoginfo
            m_cServer = m_Ctx.GetServer("xoginfo");
            m_cPhName = m_Ctx.GetPhName("xoginfo");
            if (Cursor_xoginfo!=null)
              Cursor_xoginfo.Close();
            Cursor_xoginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xoginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xoginfo.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_xoginfo.Next();
            }
            m_cConnectivityError = Cursor_xoginfo.ErrorMessage();
            Cursor_xoginfo.Close();
            // * --- End Select
          } // End If
          /* If rTabelle._xiduciabo */
          if (rTabelle._xiduciabo) {
            // * --- Select from xiduciabo
            m_cServer = m_Ctx.GetServer("xiduciabo");
            m_cPhName = m_Ctx.GetPhName("xiduciabo");
            if (Cursor_xiduciabo!=null)
              Cursor_xiduciabo.Close();
            Cursor_xiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xiduciabo.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_xiduciabo.Next();
            }
            m_cConnectivityError = Cursor_xiduciabo.ErrorMessage();
            Cursor_xiduciabo.Close();
            // * --- End Select
          } // End If
          /* If rTabelle._xntestbo */
          if (rTabelle._xntestbo) {
            // * --- Select from xntestbo
            m_cServer = m_Ctx.GetServer("xntestbo");
            m_cPhName = m_Ctx.GetPhName("xntestbo");
            if (Cursor_xntestbo!=null)
              Cursor_xntestbo.Close();
            Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestbo.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_xntestbo.Next();
            }
            m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
            Cursor_xntestbo.Close();
            // * --- End Select
          } // End If
          /* If rTabelle._xelegabo */
          if (rTabelle._xelegabo) {
            // * --- Select from xelegabo
            m_cServer = m_Ctx.GetServer("xelegabo");
            m_cPhName = m_Ctx.GetPhName("xelegabo");
            if (Cursor_xelegabo!=null)
              Cursor_xelegabo.Close();
            Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xelegabo.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_xelegabo.Next();
            }
            m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
            Cursor_xelegabo.Close();
            // * --- End Select
          } // End If
          /* If rTabelle._xarantbo */
          if (rTabelle._xarantbo) {
            // * --- Select from xarantbo
            m_cServer = m_Ctx.GetServer("xarantbo");
            m_cPhName = m_Ctx.GetPhName("xarantbo");
            if (Cursor_xarantbo!=null)
              Cursor_xarantbo.Close();
            Cursor_xarantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER "+")"+(m_Ctx.IsSharedTemp("xarantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xarantbo.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_xarantbo.Next();
            }
            m_cConnectivityError = Cursor_xarantbo.ErrorMessage();
            Cursor_xarantbo.Close();
            // * --- End Select
          } // End If
          /* If conta > 0 */
          if (CPLib.gt(conta,0)) {
            /* found := True */
            found = true;
            /* _whereFound := "Rapporti Continuativi Provvisori" */
            _whereFound = "Rapporti Continuativi Provvisori";
          } // End If
        } // End If
      } // End If
      /* If not(found) */
      if ( ! (found)) {
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* If rTabelle._rapotit */
        if (rTabelle._rapotit) {
          // * --- Select from rapotit
          m_cServer = m_Ctx.GetServer("rapotit");
          m_cPhName = m_Ctx.GetPhName("rapotit");
          if (Cursor_rapotit!=null)
            Cursor_rapotit.Close();
          Cursor_rapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("rapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_rapotit.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            Cursor_rapotit.Next();
          }
          m_cConnectivityError = Cursor_rapotit.ErrorMessage();
          Cursor_rapotit.Close();
          // * --- End Select
          /* If rTabelle._intestit */
          if (rTabelle._intestit) {
            // * --- Select from intestit
            m_cServer = m_Ctx.GetServer("intestit");
            m_cPhName = m_Ctx.GetPhName("intestit");
            if (Cursor_intestit!=null)
              Cursor_intestit.Close();
            Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODCLI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestit.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_intestit.Next();
            }
            m_cConnectivityError = Cursor_intestit.ErrorMessage();
            Cursor_intestit.Close();
            // * --- End Select
          } // End If
          /* If conta > 0 */
          if (CPLib.gt(conta,0)) {
            /* found := True */
            found = true;
            /* _whereFound := "Titolari effetti AUI" */
            _whereFound = "Titolari effetti AUI";
          } // End If
        } // End If
      } // End If
      /* If not(found) */
      if ( ! (found)) {
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* If rTabelle._xapotit */
        if (rTabelle._xapotit) {
          // * --- Select from xapotit
          m_cServer = m_Ctx.GetServer("xapotit");
          m_cPhName = m_Ctx.GetPhName("xapotit");
          if (Cursor_xapotit!=null)
            Cursor_xapotit.Close();
          Cursor_xapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xapotit.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            Cursor_xapotit.Next();
          }
          m_cConnectivityError = Cursor_xapotit.ErrorMessage();
          Cursor_xapotit.Close();
          // * --- End Select
          /* If rTabelle._xntestit */
          if (rTabelle._xntestit) {
            // * --- Select from xntestit
            m_cServer = m_Ctx.GetServer("xntestit");
            m_cPhName = m_Ctx.GetPhName("xntestit");
            if (Cursor_xntestit!=null)
              Cursor_xntestit.Close();
            Cursor_xntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODCLI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("xntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestit.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_xntestit.Next();
            }
            m_cConnectivityError = Cursor_xntestit.ErrorMessage();
            Cursor_xntestit.Close();
            // * --- End Select
          } // End If
          /* If conta > 0 */
          if (CPLib.gt(conta,0)) {
            /* found := True */
            found = true;
            /* _whereFound := "Titolari effetti Provvisori" */
            _whereFound = "Titolari effetti Provvisori";
          } // End If
        } // End If
      } // End If
      /* If not(found) */
      if ( ! (found)) {
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* If rTabelle._japopebo */
        if (rTabelle._japopebo) {
          // * --- Select from japopebo
          m_cServer = m_Ctx.GetServer("japopebo");
          m_cPhName = m_Ctx.GetPhName("japopebo");
          if (Cursor_japopebo!=null)
            Cursor_japopebo.Close();
          Cursor_japopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("japopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_japopebo.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            Cursor_japopebo.Next();
          }
          m_cConnectivityError = Cursor_japopebo.ErrorMessage();
          Cursor_japopebo.Close();
          // * --- End Select
          /* If rTabelle._jntestbo */
          if (rTabelle._jntestbo) {
            // * --- Select from jntestbo
            m_cServer = m_Ctx.GetServer("jntestbo");
            m_cPhName = m_Ctx.GetPhName("jntestbo");
            if (Cursor_jntestbo!=null)
              Cursor_jntestbo.Close();
            Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_jntestbo.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_jntestbo.Next();
            }
            m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
            Cursor_jntestbo.Close();
            // * --- End Select
          } // End If
          /* If rTabelle._jelegabo */
          if (rTabelle._jelegabo) {
            // * --- Select from jelegabo
            m_cServer = m_Ctx.GetServer("jelegabo");
            m_cPhName = m_Ctx.GetPhName("jelegabo");
            if (Cursor_jelegabo!=null)
              Cursor_jelegabo.Close();
            Cursor_jelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("jelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_jelegabo.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_jelegabo.Next();
            }
            m_cConnectivityError = Cursor_jelegabo.ErrorMessage();
            Cursor_jelegabo.Close();
            // * --- End Select
          } // End If
          /* If rTabelle._jarantbo */
          if (rTabelle._jarantbo) {
            // * --- Select from jarantbo
            m_cServer = m_Ctx.GetServer("jarantbo");
            m_cPhName = m_Ctx.GetPhName("jarantbo");
            if (Cursor_jarantbo!=null)
              Cursor_jarantbo.Close();
            Cursor_jarantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("jarantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_jarantbo.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_jarantbo.Next();
            }
            m_cConnectivityError = Cursor_jarantbo.ErrorMessage();
            Cursor_jarantbo.Close();
            // * --- End Select
          } // End If
          /* If conta > 0 */
          if (CPLib.gt(conta,0)) {
            /* found := True */
            found = true;
            /* _whereFound := "Rapporti Continuativi AGE" */
            _whereFound = "Rapporti Continuativi AGE";
          } // End If
        } // End If
      } // End If
      /* If not(found) */
      if ( ! (found)) {
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* If rTabelle._japotit */
        if (rTabelle._japotit) {
          // * --- Select from japotit
          m_cServer = m_Ctx.GetServer("japotit");
          m_cPhName = m_Ctx.GetPhName("japotit");
          if (Cursor_japotit!=null)
            Cursor_japotit.Close();
          Cursor_japotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("japotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_japotit.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            Cursor_japotit.Next();
          }
          m_cConnectivityError = Cursor_japotit.ErrorMessage();
          Cursor_japotit.Close();
          // * --- End Select
          /* If rTabelle._jntestit */
          if (rTabelle._jntestit) {
            // * --- Select from jntestit
            m_cServer = m_Ctx.GetServer("jntestit");
            m_cPhName = m_Ctx.GetPhName("jntestit");
            if (Cursor_jntestit!=null)
              Cursor_jntestit.Close();
            Cursor_jntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODCLI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("jntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_jntestit.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_jntestit.Next();
            }
            m_cConnectivityError = Cursor_jntestit.ErrorMessage();
            Cursor_jntestit.Close();
            // * --- End Select
          } // End If
          /* If conta > 0 */
          if (CPLib.gt(conta,0)) {
            /* found := True */
            found = true;
            /* _whereFound := "Titolari effetti AGE" */
            _whereFound = "Titolari effetti AGE";
          } // End If
        } // End If
      } // End If
      /* If not(found) */
      if ( ! (found)) {
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* If rTabelle._jperazbo */
        if (rTabelle._jperazbo) {
          // * --- Select from jperazbo
          m_cServer = m_Ctx.GetServer("jperazbo");
          m_cPhName = m_Ctx.GetPhName("jperazbo");
          if (Cursor_jperazbo!=null)
            Cursor_jperazbo.Close();
          Cursor_jperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("jperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_jperazbo.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            Cursor_jperazbo.Next();
          }
          m_cConnectivityError = Cursor_jperazbo.ErrorMessage();
          Cursor_jperazbo.Close();
          // * --- End Select
          /* If conta > 0 */
          if (CPLib.gt(conta,0)) {
            /* found := True */
            found = true;
            /* _whereFound := "Operazioni AGE" */
            _whereFound = "Operazioni AGE";
          } // End If
        } // End If
      } // End If
      /* If not(found) */
      if ( ! (found)) {
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* If rTabelle._kperazbo */
        if (rTabelle._kperazbo) {
          // * --- Select from kperazbo
          m_cServer = m_Ctx.GetServer("kperazbo");
          m_cPhName = m_Ctx.GetPhName("kperazbo");
          if (Cursor_kperazbo!=null)
            Cursor_kperazbo.Close();
          Cursor_kperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("kperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_kperazbo.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            Cursor_kperazbo.Next();
          }
          m_cConnectivityError = Cursor_kperazbo.ErrorMessage();
          Cursor_kperazbo.Close();
          // * --- End Select
          /* If conta > 0 */
          if (CPLib.gt(conta,0)) {
            /* found := True */
            found = true;
            /* _whereFound := "Operazioni Società Quotate" */
            _whereFound = "Operazioni Società Quotate";
          } // End If
        } // End If
      } // End If
      /* If not(found) */
      if ( ! (found)) {
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* If rTabelle._opextrbo */
        if (rTabelle._opextrbo) {
          // * --- Select from opextrbo
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          if (Cursor_opextrbo!=null)
            Cursor_opextrbo.Close();
          Cursor_opextrbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select ANNO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("opextrbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_opextrbo.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            Cursor_opextrbo.Next();
          }
          m_cConnectivityError = Cursor_opextrbo.ErrorMessage();
          Cursor_opextrbo.Close();
          // * --- End Select
          /* If conta > 0 */
          if (CPLib.gt(conta,0)) {
            /* found := True */
            found = true;
            /* _whereFound := "Operazioni Extraconto" */
            _whereFound = "Operazioni Extraconto";
          } // End If
        } // End If
      } // End If
      /* If not(found) */
      if ( ! (found)) {
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* If rTabelle._wperazbo */
        if (rTabelle._wperazbo) {
          // * --- Select from wperazbo
          m_cServer = m_Ctx.GetServer("wperazbo");
          m_cPhName = m_Ctx.GetPhName("wperazbo");
          if (Cursor_wperazbo!=null)
            Cursor_wperazbo.Close();
          Cursor_wperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNALTRO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("wperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_wperazbo.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            Cursor_wperazbo.Next();
          }
          m_cConnectivityError = Cursor_wperazbo.ErrorMessage();
          Cursor_wperazbo.Close();
          // * --- End Select
          /* If conta > 0 */
          if (CPLib.gt(conta,0)) {
            /* If rTabelle._wlientiope */
            if (rTabelle._wlientiope) {
              // * --- Select from wlientiope
              m_cServer = m_Ctx.GetServer("wlientiope");
              m_cPhName = m_Ctx.GetPhName("wlientiope");
              if (Cursor_wlientiope!=null)
                Cursor_wlientiope.Close();
              Cursor_wlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("wlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wlientiope.Eof())) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                Cursor_wlientiope.Next();
              }
              m_cConnectivityError = Cursor_wlientiope.ErrorMessage();
              Cursor_wlientiope.Close();
              // * --- End Select
            } // End If
            /* If rTabelle._weneficope */
            if (rTabelle._weneficope) {
              // * --- Select from weneficope
              m_cServer = m_Ctx.GetServer("weneficope");
              m_cPhName = m_Ctx.GetPhName("weneficope");
              if (Cursor_weneficope!=null)
                Cursor_weneficope.Close();
              Cursor_weneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("weneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_weneficope.Eof())) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                Cursor_weneficope.Next();
              }
              m_cConnectivityError = Cursor_weneficope.ErrorMessage();
              Cursor_weneficope.Close();
              // * --- End Select
            } // End If
            /* If rTabelle._wogopebo */
            if (rTabelle._wogopebo) {
              // * --- Select from wogopebo
              m_cServer = m_Ctx.GetServer("wogopebo");
              m_cPhName = m_Ctx.GetPhName("wogopebo");
              if (Cursor_wogopebo!=null)
                Cursor_wogopebo.Close();
              Cursor_wogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("wogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wogopebo.Eof())) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                Cursor_wogopebo.Next();
              }
              m_cConnectivityError = Cursor_wogopebo.ErrorMessage();
              Cursor_wogopebo.Close();
              // * --- End Select
            } // End If
            /* If rTabelle._werzistiope */
            if (rTabelle._werzistiope) {
              // * --- Select from werzistiope
              m_cServer = m_Ctx.GetServer("werzistiope");
              m_cPhName = m_Ctx.GetPhName("werzistiope");
              if (Cursor_werzistiope!=null)
                Cursor_werzistiope.Close();
              Cursor_werzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("werzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_werzistiope.Eof())) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                Cursor_werzistiope.Next();
              }
              m_cConnectivityError = Cursor_werzistiope.ErrorMessage();
              Cursor_werzistiope.Close();
              // * --- End Select
            } // End If
            /* found := True */
            found = true;
            /* _whereFound := "Storico Operazioni" */
            _whereFound = "Storico Operazioni";
          } // End If
        } // End If
      } // End If
      /* If not(found) */
      if ( ! (found)) {
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* If rTabelle._wraziobo */
        if (rTabelle._wraziobo) {
          // * --- Select from wraziobo
          m_cServer = m_Ctx.GetServer("wraziobo");
          m_cPhName = m_Ctx.GetPhName("wraziobo");
          if (Cursor_wraziobo!=null)
            Cursor_wraziobo.Close();
          Cursor_wraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNALTRO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESBEN="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+"  or  CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("wraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_wraziobo.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            Cursor_wraziobo.Next();
          }
          m_cConnectivityError = Cursor_wraziobo.ErrorMessage();
          Cursor_wraziobo.Close();
          // * --- End Select
          /* If conta > 0 */
          if (CPLib.gt(conta,0)) {
            /* If rTabelle._wlientifrz */
            if (rTabelle._wlientifrz) {
              // * --- Select from wlientifrz
              m_cServer = m_Ctx.GetServer("wlientifrz");
              m_cPhName = m_Ctx.GetPhName("wlientifrz");
              if (Cursor_wlientifrz!=null)
                Cursor_wlientifrz.Close();
              Cursor_wlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("wlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wlientifrz.Eof())) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                Cursor_wlientifrz.Next();
              }
              m_cConnectivityError = Cursor_wlientifrz.ErrorMessage();
              Cursor_wlientifrz.Close();
              // * --- End Select
            } // End If
            /* If rTabelle._weneficfrz */
            if (rTabelle._weneficfrz) {
              // * --- Select from weneficfrz
              m_cServer = m_Ctx.GetServer("weneficfrz");
              m_cPhName = m_Ctx.GetPhName("weneficfrz");
              if (Cursor_weneficfrz!=null)
                Cursor_weneficfrz.Close();
              Cursor_weneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("weneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_weneficfrz.Eof())) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                Cursor_weneficfrz.Next();
              }
              m_cConnectivityError = Cursor_weneficfrz.ErrorMessage();
              Cursor_weneficfrz.Close();
              // * --- End Select
            } // End If
            /* If rTabelle._wogopefbo */
            if (rTabelle._wogopefbo) {
              // * --- Select from wogopefbo
              m_cServer = m_Ctx.GetServer("wogopefbo");
              m_cPhName = m_Ctx.GetPhName("wogopefbo");
              if (Cursor_wogopefbo!=null)
                Cursor_wogopefbo.Close();
              Cursor_wogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("wogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wogopefbo.Eof())) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                Cursor_wogopefbo.Next();
              }
              m_cConnectivityError = Cursor_wogopefbo.ErrorMessage();
              Cursor_wogopefbo.Close();
              // * --- End Select
            } // End If
            /* If rTabelle._werzistifrz */
            if (rTabelle._werzistifrz) {
              // * --- Select from werzistifrz
              m_cServer = m_Ctx.GetServer("werzistifrz");
              m_cPhName = m_Ctx.GetPhName("werzistifrz");
              if (Cursor_werzistifrz!=null)
                Cursor_werzistifrz.Close();
              Cursor_werzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDFILEBO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("werzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_werzistifrz.Eof())) {
                /* conta := conta + 1 */
                conta = CPLib.Round(conta+1,0);
                Cursor_werzistifrz.Next();
              }
              m_cConnectivityError = Cursor_werzistifrz.ErrorMessage();
              Cursor_werzistifrz.Close();
              // * --- End Select
            } // End If
            /* found := True */
            found = true;
            /* _whereFound := "Storico Frazionate" */
            _whereFound = "Storico Frazionate";
          } // End If
        } // End If
      } // End If
      /* If not(found) */
      if ( ! (found)) {
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        /* If rTabelle._wapopebo */
        if (rTabelle._wapopebo) {
          // * --- Select from wapopebo
          m_cServer = m_Ctx.GetServer("wapopebo");
          m_cPhName = m_Ctx.GetPhName("wapopebo");
          if (Cursor_wapopebo!=null)
            Cursor_wapopebo.Close();
          Cursor_wapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESOPER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("wapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_wapopebo.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            Cursor_wapopebo.Next();
          }
          m_cConnectivityError = Cursor_wapopebo.ErrorMessage();
          Cursor_wapopebo.Close();
          // * --- End Select
          /* If rTabelle._woginfo */
          if (rTabelle._woginfo) {
            // * --- Select from woginfo
            m_cServer = m_Ctx.GetServer("woginfo");
            m_cPhName = m_Ctx.GetPhName("woginfo");
            if (Cursor_woginfo!=null)
              Cursor_woginfo.Close();
            Cursor_woginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("woginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_woginfo.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_woginfo.Next();
            }
            m_cConnectivityError = Cursor_woginfo.ErrorMessage();
            Cursor_woginfo.Close();
            // * --- End Select
          } // End If
          /* If rTabelle._widuciabo */
          if (rTabelle._widuciabo) {
            // * --- Select from widuciabo
            m_cServer = m_Ctx.GetServer("widuciabo");
            m_cPhName = m_Ctx.GetPhName("widuciabo");
            if (Cursor_widuciabo!=null)
              Cursor_widuciabo.Close();
            Cursor_widuciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("widuciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_widuciabo.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_widuciabo.Next();
            }
            m_cConnectivityError = Cursor_widuciabo.ErrorMessage();
            Cursor_widuciabo.Close();
            // * --- End Select
          } // End If
          /* If rTabelle._wntestbo */
          if (rTabelle._wntestbo) {
            // * --- Select from wntestbo
            m_cServer = m_Ctx.GetServer("wntestbo");
            m_cPhName = m_Ctx.GetPhName("wntestbo");
            if (Cursor_wntestbo!=null)
              Cursor_wntestbo.Close();
            Cursor_wntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("wntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wntestbo.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_wntestbo.Next();
            }
            m_cConnectivityError = Cursor_wntestbo.ErrorMessage();
            Cursor_wntestbo.Close();
            // * --- End Select
          } // End If
          /* If rTabelle._welegabo */
          if (rTabelle._welegabo) {
            // * --- Select from welegabo
            m_cServer = m_Ctx.GetServer("welegabo");
            m_cPhName = m_Ctx.GetPhName("welegabo");
            if (Cursor_welegabo!=null)
              Cursor_welegabo.Close();
            Cursor_welegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("welegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_welegabo.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_welegabo.Next();
            }
            m_cConnectivityError = Cursor_welegabo.ErrorMessage();
            Cursor_welegabo.Close();
            // * --- End Select
          } // End If
          /* If rTabelle._warantbo */
          if (rTabelle._warantbo) {
            // * --- Select from warantbo
            m_cServer = m_Ctx.GetServer("warantbo");
            m_cPhName = m_Ctx.GetPhName("warantbo");
            if (Cursor_warantbo!=null)
              Cursor_warantbo.Close();
            Cursor_warantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER "+")"+(m_Ctx.IsSharedTemp("warantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_warantbo.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              Cursor_warantbo.Next();
            }
            m_cConnectivityError = Cursor_warantbo.ErrorMessage();
            Cursor_warantbo.Close();
            // * --- End Select
          } // End If
          /* If conta > 0 */
          if (CPLib.gt(conta,0)) {
            /* found := True */
            found = true;
            /* _whereFound := "Rapporti Continuativi Storico" */
            _whereFound = "Rapporti Continuativi Storico";
          } // End If
        } // End If
      } // End If
      /* If not(found) and At(w_stampa,'|E|S') <> 0 */
      if ( ! (found) && CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
        // * --- Delete from aerighe
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aerighe");
        m_cPhName = m_Ctx.GetPhName("aerighe");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000035C")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNESINT = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(w_CONNES,"?",0,0,m_cServer),m_cServer,w_CONNES)+"";
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
        // * --- Delete from personbo_agg
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("personbo_agg");
        m_cPhName = m_Ctx.GetPhName("personbo_agg");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000035D")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer),m_cServer,w_CONNES)+"";
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
        // * --- Delete from personbo_dip
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("personbo_dip");
        m_cPhName = m_Ctx.GetPhName("personbo_dip");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_dip",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000035E")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer),m_cServer,w_CONNES)+"";
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
        // * --- Delete from personbo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000035F")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer),m_cServer,w_CONNES)+"";
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
        // * --- Delete from wersonbo_agg
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("wersonbo_agg");
        m_cPhName = m_Ctx.GetPhName("wersonbo_agg");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo_agg",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000360")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer),m_cServer,w_CONNES)+"";
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
        // * --- Delete from wersonbo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000361")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer),m_cServer,w_CONNES)+"";
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
        // * --- Delete from dersonbo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("dersonbo");
        m_cPhName = m_Ctx.GetPhName("dersonbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dersonbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000362")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer),m_cServer,w_CONNES)+"";
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
      /* Page Return _whereFound */
      return _whereFound;
    } finally {
      try {
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
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
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
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
      try {
        if (Cursor_xperazbo!=null)
          Cursor_xperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xlientiope!=null)
          Cursor_xlientiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xeneficope!=null)
          Cursor_xeneficope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xogopebo!=null)
          Cursor_xogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xerzistiope!=null)
          Cursor_xerzistiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xraziobo!=null)
          Cursor_xraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xlientifrz!=null)
          Cursor_xlientifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xeneficfrz!=null)
          Cursor_xeneficfrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xogopefbo!=null)
          Cursor_xogopefbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xerzistifrz!=null)
          Cursor_xerzistifrz.Close();
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
      try {
        if (Cursor_soginfo!=null)
          Cursor_soginfo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_fiduciabo!=null)
          Cursor_fiduciabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_garantbo!=null)
          Cursor_garantbo.Close();
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
        if (Cursor_xoginfo!=null)
          Cursor_xoginfo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xiduciabo!=null)
          Cursor_xiduciabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xelegabo!=null)
          Cursor_xelegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xarantbo!=null)
          Cursor_xarantbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_rapotit!=null)
          Cursor_rapotit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xapotit!=null)
          Cursor_xapotit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xntestit!=null)
          Cursor_xntestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_japopebo!=null)
          Cursor_japopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jelegabo!=null)
          Cursor_jelegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jarantbo!=null)
          Cursor_jarantbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_japotit!=null)
          Cursor_japotit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jntestit!=null)
          Cursor_jntestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jperazbo!=null)
          Cursor_jperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_kperazbo!=null)
          Cursor_kperazbo.Close();
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
      try {
        if (Cursor_wperazbo!=null)
          Cursor_wperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wlientiope!=null)
          Cursor_wlientiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_weneficope!=null)
          Cursor_weneficope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wogopebo!=null)
          Cursor_wogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_werzistiope!=null)
          Cursor_werzistiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wraziobo!=null)
          Cursor_wraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wlientifrz!=null)
          Cursor_wlientifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_weneficfrz!=null)
          Cursor_weneficfrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wogopefbo!=null)
          Cursor_wogopefbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_werzistifrz!=null)
          Cursor_werzistifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wapopebo!=null)
          Cursor_wapopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_woginfo!=null)
          Cursor_woginfo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_widuciabo!=null)
          Cursor_widuciabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wntestbo!=null)
          Cursor_wntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_welegabo!=null)
          Cursor_welegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_warantbo!=null)
          Cursor_warantbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void add_sogg_mc(String w_CONNES) throws Exception {
    CPResultSet Cursor_personbo=null;
    try {
      /* w_CONNES Char(16) */
      /* rw_personbo Row(mcPersonStorico.MCRDef) */
      MemoryCursorRow_mcpersonstorico_mcrdef rw_personbo;
      rw_personbo = new MemoryCursorRow_mcpersonstorico_mcrdef();
      /* If not(Empty(w_CONNES)) and not( _mc_soggetti_pf.GoToKey(w_CONNES) or _mc_soggetti_pnf.GoToKey(w_CONNES))  */
      if ( ! (CPLib.Empty(w_CONNES)) &&  ! (_mc_soggetti_pf.GoToKey(w_CONNES) || _mc_soggetti_pnf.GoToKey(w_CONNES))) {
        /* rw_personbo := new Row(mcPersonStorico.MCRDef) */
        rw_personbo = new MemoryCursorRow_mcpersonstorico_mcrdef();
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,w_CONNES)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* rw_personbo.CONNES := personbo->CONNES */
          rw_personbo.CONNES = Cursor_personbo.GetString("CONNES");
          /* rw_personbo.CODFISC := personbo->CODFISC */
          rw_personbo.CODFISC = Cursor_personbo.GetString("CODFISC");
          /* rw_personbo.RAGSOC := personbo->RAGSOC */
          rw_personbo.RAGSOC = Cursor_personbo.GetString("RAGSOC");
          /* rw_personbo.CAP := personbo->CAP */
          rw_personbo.CAP = Cursor_personbo.GetString("CAP");
          /* rw_personbo.CAB := personbo->CODCAB */
          rw_personbo.CAB = Cursor_personbo.GetString("CODCAB");
          /* rw_personbo.PAESE := personbo->PAESE */
          rw_personbo.PAESE = Cursor_personbo.GetString("PAESE");
          /* rw_personbo.DESCCIT := personbo->DESCCIT */
          rw_personbo.DESCCIT = Cursor_personbo.GetString("DESCCIT");
          /* rw_personbo.PROVINCIA := personbo->PROVINCIA */
          rw_personbo.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
          /* rw_personbo.DATANASC := personbo->DATANASC */
          rw_personbo.DATANASC = Cursor_personbo.GetDate("DATANASC");
          /* rw_personbo.IDNASSTATO := personbo->IDNASSTATO */
          rw_personbo.IDNASSTATO = Cursor_personbo.GetString("IDNASSTATO");
          /* rw_personbo.PIVA := personbo->PARTIVA */
          rw_personbo.PIVA = Cursor_personbo.GetString("PARTIVA");
          /* rw_personbo.NOSARA := '' // lo uso come FLAG per testare successivamente se è stato cancellato dal'AUI */
          rw_personbo.NOSARA = "";
          /* rw_personbo.TIPOPERS := personbo->TIPOPERS */
          rw_personbo.TIPOPERS = Cursor_personbo.GetString("TIPOPERS");
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
        /* If rw_personbo.TIPOPERS='G' */
        if (CPLib.eqr(rw_personbo.TIPOPERS,"G")) {
          /* _mc_soggetti_pnf.AppendRowWithKey(w_CONNES,rw_personbo) // Soggetti potenzialmente dangling */
          _mc_soggetti_pnf.AppendRowWithKey(w_CONNES,rw_personbo);
        } else { // Else
          /* _mc_soggetti_pf.AppendRowWithKey(w_CONNES,rw_personbo) // Soggetti potenzialmente dangling */
          _mc_soggetti_pf.AppendRowWithKey(w_CONNES,rw_personbo);
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
    }
  }
  void print_xlsx() throws Exception {
    /* ope Numeric(0, 0) := _mc_operazioni.RecCount() */
    double ope;
    ope = CPLib.Round(_mc_operazioni.RecCount(),0);
    /* fraz Numeric(0, 0) := _mc_frazionate.RecCount() */
    double fraz;
    fraz = CPLib.Round(_mc_frazionate.RecCount(),0);
    /* rap Numeric(0, 0) := _mc_rapporti.RecCount() */
    double rap;
    rap = CPLib.Round(_mc_rapporti.RecCount(),0);
    /* pf Numeric(0, 0) := _mc_soggetti_pf.RecCount() */
    double pf;
    pf = CPLib.Round(_mc_soggetti_pf.RecCount(),0);
    /* pnf Numeric(0, 0) := _mc_soggetti_pnf.RecCount() */
    double pnf;
    pnf = CPLib.Round(_mc_soggetti_pnf.RecCount(),0);
    /* _dataOpe Char(8) */
    String _dataOpe;
    _dataOpe = CPLib.Space(8);
    /* _dataReg Char(8) */
    String _dataReg;
    _dataReg = CPLib.Space(8);
    /* _dataRett Char(8) */
    String _dataRett;
    _dataRett = CPLib.Space(8);
    /* _pers_count_pf Numeric(0, 0) := 0 */
    _pers_count_pf = CPLib.Round(0,0);
    /* _pers_count_pnf Numeric(0, 0) := 0 */
    _pers_count_pnf = CPLib.Round(0,0);
    for (MemoryCursorRow_mcpersonstorico_mcrdef rw_o : _mc_soggetti_pf._iterable_()) {
      if (CPLib.eqr(rw_o.NOSARA,"E")) {
        /* _pers_count_pf := _pers_count_pf+1 */
        _pers_count_pf = CPLib.Round(_pers_count_pf+1,0);
      }
    }
    for (MemoryCursorRow_mcpersonstorico_mcrdef rw_o : _mc_soggetti_pnf._iterable_()) {
      if (CPLib.eqr(rw_o.NOSARA,"E")) {
        /* _pers_count_pnf := _pers_count_pnf+1 */
        _pers_count_pnf = CPLib.Round(_pers_count_pnf+1,0);
      }
    }
    /* gMsgProc := gMsgProc +'Ora Inizio Creazione file di Stampa: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Ora Inizio Creazione file di Stampa: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* _nomeFile := iif((w_chi_chiama_la_routine="AUI" and w_tipoope="T" ),"TRASF_AUI_STO",iif((w_chi_chiama_la_routine="AUI" and w_tipoope="C"),"DEL_AUI","DEL_STO"))+"_"+DateTimeToChar(DateTime())+".xlsx" */
    _nomeFile = ((CPLib.eqr(w_chi_chiama_la_routine,"AUI") && CPLib.eqr(w_tipoope,"T"))?"TRASF_AUI_STO":((CPLib.eqr(w_chi_chiama_la_routine,"AUI") && CPLib.eqr(w_tipoope,"C"))?"DEL_AUI":"DEL_STO"))+"_"+CPLib.DateTimeToChar(CPLib.DateTime())+".xlsx";
    /* _nfile := LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+"/"+_nomeFile */
    _nfile = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+_nomeFile;
    /* gMsgProc := 'file:'+_nfile+NL+gMsgProc // Messaggio */
    gMsgProc = "file:"+_nfile+"\n"+gMsgProc;
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgImp := "Creazione WorkBook XLSX" */
    gMsgImp = "Creazione WorkBook XLSX";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    // creo il contenitore dei fogli
    wb = new SXSSFWorkbook();
    // creo lo stile (testo Bold)
    CellStyle style = wb.createCellStyle();
    Font font = wb.createFont();
    font.setBold(true);;
    style.setFont(font);
    /* gMsgImp := "Creazione Stili e Corpo del documento" */
    gMsgImp = "Creazione Stili e Corpo del documento";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    /* gMsgImp := "Elaborazione del Foglio di lavoro: Riassunto" */
    gMsgImp = "Elaborazione del Foglio di lavoro: Riassunto";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    
    sheet = (SXSSFSheet) wb.createSheet("Elaborazione") ;
    sheet.trackColumnForAutoSizing(0);
    sheet.trackColumnForAutoSizing(1);
    sheet.trackColumnForAutoSizing(2);
    sheet.trackColumnForAutoSizing(3);
    sheet.trackColumnForAutoSizing(4);
    // Mi posiziono e scrivo
    _x = 0; // mi sposto sulle colonne
    _y = 2; // mi sposto sulle righe
    //Creo il record da scrivere
    row = sheet.createRow(_y);
    //scrivo la riga di intestazione
    cell = row.createCell(0); cell.setCellStyle(style); cell.setCellValue("Operazioni");
    cell = row.createCell(1); cell.setCellStyle(style); cell.setCellValue("Frazionate");
    cell = row.createCell(2); cell.setCellStyle(style); cell.setCellValue("Rapporti");
    cell = row.createCell(3); cell.setCellStyle(style); cell.setCellValue("Persone Fisiche");
    cell = row.createCell(4); cell.setCellStyle(style); cell.setCellValue("Persone Non Fisiche");
    _y=_y+1;
    //faccio l'autosize sulla prima riga
    sheet.autoSizeColumn(0);
    sheet.autoSizeColumn(1);
    sheet.autoSizeColumn(2);
    sheet.autoSizeColumn(3);
    sheet.autoSizeColumn(4);
    //Creo il record da scrivere
    row = sheet.createRow(_y);
    cell = row.createCell(0);
    cell.setCellValue((ope));
    cell = row.createCell(1);
    cell.setCellValue((fraz));
    cell = row.createCell(2);
    cell.setCellValue((rap));
    cell = row.createCell(3);
    cell.setCellValue((_pers_count_pf));
    cell = row.createCell(4);
    cell.setCellValue((_pers_count_pnf));
    _y=_y+1;
    
    //Riga 1
    row = sheet.createRow(0);
    cell = row.createCell(0);
    cell.setCellValue(_str_init+' '+_str_init_1);
    /* gMsgImp := "Elaborazione del Foglio di lavoro: Operazioni" */
    gMsgImp = "Elaborazione del Foglio di lavoro: Operazioni";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    
    sheet = (SXSSFSheet) wb.createSheet("Operazioni") ;
    
    sheet.setColumnWidth(0, (17+3)*256 );
    sheet.setColumnWidth(1, (17+3)*256 );
    sheet.setColumnWidth(2, (17+3)*256 );
    sheet.setColumnWidth(3, (17+3)*256 );
    sheet.setColumnWidth(4, (15+3)*256 );
    sheet.setColumnWidth(5, (10+3)*256 );
    sheet.setColumnWidth(6, (19+3)*256 );
    sheet.setColumnWidth(7, (18+3)*256 );
    sheet.setColumnWidth(8, (16+3)*256 );
    sheet.setColumnWidth(9, (17+3)*256 );
    
    //Creo il record da scrivere
    row = sheet.createRow(0);
    
    cell = row.createCell(0); cell.setCellStyle(style); cell.setCellValue("DATA_OPERAZIONE");
    cell = row.createCell(1); cell.setCellStyle(style); cell.setCellValue("NUM_PROGRESSIVO");
    cell = row.createCell(2); cell.setCellStyle(style); cell.setCellValue("DATA_REGISTRAZONE");
    cell = row.createCell(3); cell.setCellStyle(style); cell.setCellValue("CAUSALE_ANALITICA");
    cell = row.createCell(4); cell.setCellStyle(style); cell.setCellValue("IMPORTO");
    cell = row.createCell(5); cell.setCellStyle(style); cell.setCellValue("VALUTA");
    cell = row.createCell(6); cell.setCellStyle(style); cell.setCellValue("CLIENTE");
    cell = row.createCell(7); cell.setCellStyle(style); cell.setCellValue("RAPPORTO");
    cell = row.createCell(8); cell.setCellStyle(style); cell.setCellValue("STATO_REGISTRAZIONE");
    _cnt = 1;
    for (MemoryCursorRow_mcopefrazstorico_mcrdef rw_riga_ope : _mc_operazioni._iterable_()) {
      /* gMsgImp := "Elaborazione del Foglio di lavoro: Operazioni "+_cnt+" su "+_mc_operazioni.RecCount() */
      gMsgImp = "Elaborazione del Foglio di lavoro: Operazioni "+_cnt+" su "+_mc_operazioni.RecCount();
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _dataOpe := iif(Empty(rw_riga_ope.DATAOPE) or DateToChar(rw_riga_ope.DATAOPE)='01000101',Space(8),DateToChar(rw_riga_ope.DATAOPE)) */
      _dataOpe = (CPLib.Empty(rw_riga_ope.DATAOPE) || CPLib.eqr(CPLib.DateToChar(rw_riga_ope.DATAOPE),"01000101")?CPLib.Space(8):CPLib.DateToChar(rw_riga_ope.DATAOPE));
      /* _dataReg := iif(Empty(rw_riga_ope.DATAREG) or DateToChar(rw_riga_ope.DATAREG) ='01000101',Space(8),DateToChar(rw_riga_ope.DATAREG) ) */
      _dataReg = (CPLib.Empty(rw_riga_ope.DATAREG) || CPLib.eqr(CPLib.DateToChar(rw_riga_ope.DATAREG),"01000101")?CPLib.Space(8):CPLib.DateToChar(rw_riga_ope.DATAREG));
      row = sheet.createRow(_cnt);
      
      cell = row.createCell(0); cell.setCellValue(_dataOpe);
      cell = row.createCell(1); cell.setCellValue(rw_riga_ope.NUMPROG);
      cell = row.createCell(2); cell.setCellValue(_dataReg);
      cell = row.createCell(3); cell.setCellValue(rw_riga_ope.CAUSALE);
      cell = row.createCell(4); cell.setCellValue(CPLib.Right(CPLib.LRTrim(CPLib.Str((rw_riga_ope.IMPORTO/100),15,2)),17));
      cell = row.createCell(5); cell.setCellValue(rw_riga_ope.VALUTA);
      cell = row.createCell(6); cell.setCellValue(rw_riga_ope.CONNESCLI);
      cell = row.createCell(7); cell.setCellValue(rw_riga_ope.DESCRI);
      cell = row.createCell(8); cell.setCellValue(rw_riga_ope.STATOREG);
      /* _cnt := _cnt+1 */
      _cnt = _cnt+1;
    }
    /* gMsgImp := "Elaborazione del Foglio di lavoro: Frazionate" */
    gMsgImp = "Elaborazione del Foglio di lavoro: Frazionate";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    
    sheet = (SXSSFSheet) wb.createSheet("Frazionate") ;
    
    sheet.setColumnWidth(0, (17+3)*256 );
    sheet.setColumnWidth(1, (17+3)*256 );
    sheet.setColumnWidth(2, (17+3)*256 );
    sheet.setColumnWidth(3, (17+3)*256 );
    sheet.setColumnWidth(4, (15+3)*256 );
    sheet.setColumnWidth(5, (10+3)*256 );
    sheet.setColumnWidth(6, (19+3)*256 );
    sheet.setColumnWidth(7, (18+3)*256 );
    sheet.setColumnWidth(8, (16+3)*256 );
    sheet.setColumnWidth(9, (17+3)*256 );
    //Creo il record da scrivere
    row = sheet.createRow(0);
    
    cell = row.createCell(0); cell.setCellStyle(style); cell.setCellValue("DATA_OPERAZIONE");
    cell = row.createCell(1); cell.setCellStyle(style); cell.setCellValue("NUM_PROGRESSIVO");
    cell = row.createCell(2); cell.setCellStyle(style); cell.setCellValue("DATA_REGISTRAZONE");
    cell = row.createCell(3); cell.setCellStyle(style); cell.setCellValue("CAUSALE_ANALITICA");
    cell = row.createCell(4); cell.setCellStyle(style); cell.setCellValue("IMPORTO");
    cell = row.createCell(5); cell.setCellStyle(style); cell.setCellValue("VALUTA");
    cell = row.createCell(6); cell.setCellStyle(style); cell.setCellValue("CLIENTE");
    cell = row.createCell(7); cell.setCellStyle(style); cell.setCellValue("RAPPORTO");
    cell = row.createCell(8); cell.setCellStyle(style); cell.setCellValue("STATO_REGISTRAZIONE");
    _cnt = 1;
    for (MemoryCursorRow_mcopefrazstorico_mcrdef rw_riga_ope : _mc_frazionate._iterable_()) {
      /* gMsgImp := "Elaborazione del Foglio di lavoro: Frazionate "+_cnt+" su "+_mc_frazionate.RecCount() */
      gMsgImp = "Elaborazione del Foglio di lavoro: Frazionate "+_cnt+" su "+_mc_frazionate.RecCount();
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _dataOpe := iif(Empty(rw_riga_ope.DATAOPE) or DateToChar(rw_riga_ope.DATAOPE)='01000101',Space(8),DateToChar(rw_riga_ope.DATAOPE)) */
      _dataOpe = (CPLib.Empty(rw_riga_ope.DATAOPE) || CPLib.eqr(CPLib.DateToChar(rw_riga_ope.DATAOPE),"01000101")?CPLib.Space(8):CPLib.DateToChar(rw_riga_ope.DATAOPE));
      /* _dataReg := iif(Empty(rw_riga_ope.DATAREG) or DateToChar(rw_riga_ope.DATAREG) ='01000101',Space(8),DateToChar(rw_riga_ope.DATAREG) ) */
      _dataReg = (CPLib.Empty(rw_riga_ope.DATAREG) || CPLib.eqr(CPLib.DateToChar(rw_riga_ope.DATAREG),"01000101")?CPLib.Space(8):CPLib.DateToChar(rw_riga_ope.DATAREG));
      row = sheet.createRow(_cnt);
      
      cell = row.createCell(0); cell.setCellValue(_dataOpe);
      cell = row.createCell(1); cell.setCellValue(rw_riga_ope.NUMPROG);
      cell = row.createCell(2); cell.setCellValue(_dataReg);
      cell = row.createCell(3); cell.setCellValue(rw_riga_ope.CAUSALE);
      cell = row.createCell(4); cell.setCellValue(CPLib.Right(CPLib.LRTrim(CPLib.Str((rw_riga_ope.IMPORTO/100),15,2)),17));
      cell = row.createCell(5); cell.setCellValue(rw_riga_ope.VALUTA);
      cell = row.createCell(6); cell.setCellValue(rw_riga_ope.CONNESCLI);
      cell = row.createCell(7); cell.setCellValue(rw_riga_ope.DESCRI);
      cell = row.createCell(8); cell.setCellValue(rw_riga_ope.STATOREG);
      /* _cnt := _cnt+1 */
      _cnt = _cnt+1;
    }
    /* gMsgImp := "Elaborazione del Foglio di lavoro: Rapporti" */
    gMsgImp = "Elaborazione del Foglio di lavoro: Rapporti";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    
    sheet = (SXSSFSheet) wb.createSheet("Rapporti") ;
    sheet.trackColumnForAutoSizing(0);
    sheet.trackColumnForAutoSizing(1);
    sheet.trackColumnForAutoSizing(2);
    sheet.trackColumnForAutoSizing(3);
    sheet.trackColumnForAutoSizing(4);
    sheet.trackColumnForAutoSizing(5);
    sheet.trackColumnForAutoSizing(6);
    sheet.trackColumnForAutoSizing(7);
    sheet.trackColumnForAutoSizing(8);
    sheet.trackColumnForAutoSizing(9);
    //Creo il record da scrivere
    row = sheet.createRow(0);
    
    //DATI RAPPORTO
    cell = row.createCell(0); cell.setCellStyle(style); cell.setCellValue("COD_RAPPORTO");
    cell = row.createCell(1); cell.setCellStyle(style); cell.setCellValue("DESCRI_RAPPORTO");
    cell = row.createCell(2); cell.setCellStyle(style); cell.setCellValue("TIPO_RAPPORTO");
    cell = row.createCell(3); cell.setCellStyle(style); cell.setCellValue("TIPO_AGE");
    cell = row.createCell(4); cell.setCellStyle(style); cell.setCellValue("DIVISA");
    cell = row.createCell(5); cell.setCellStyle(style); cell.setCellValue("VALUTA");
    cell = row.createCell(6); cell.setCellStyle(style); cell.setCellValue("IBAN");
    cell = row.createCell(7); cell.setCellStyle(style); cell.setCellValue("CODICE_OGG");
    cell = row.createCell(8); cell.setCellStyle(style); cell.setCellValue("NATURA");
    cell = row.createCell(9); cell.setCellStyle(style); cell.setCellValue("SCOPO");
    
    //faccio l'autosize sulla prima riga
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
    _cnt = 1;
    for (MemoryCursorRow_qbe_storrap_vqr rw_riga_rapp : _mc_rapporti._iterable_()) {
      row = sheet.createRow(_cnt);
      
      //DATI RAPPORTO
      cell = row.createCell(0); cell.setCellValue(rw_riga_rapp.RAPPORTO);
      cell = row.createCell(1); cell.setCellValue(rw_riga_rapp.DESCRAP);
      cell = row.createCell(2); cell.setCellValue(rw_riga_rapp.TIPORAP);
      cell = row.createCell(3); cell.setCellValue(rw_riga_rapp.TIPOAG);
      cell = row.createCell(4); cell.setCellValue(rw_riga_rapp.FLAGLIRE);
      cell = row.createCell(5); cell.setCellValue(rw_riga_rapp.VALUTA);
      cell = row.createCell(6); cell.setCellValue(rw_riga_rapp.IBAN);
      cell = row.createCell(7); cell.setCellValue(rw_riga_rapp.CODOGG);
      cell = row.createCell(8); cell.setCellValue(rw_riga_rapp.NATURA);
      cell = row.createCell(9); cell.setCellValue(rw_riga_rapp.SCOPO);
      /* _cnt := _cnt+1 */
      _cnt = _cnt+1;
    }
    /* gMsgImp := "Elaborazione del Foglio di lavoro: PF" */
    gMsgImp = "Elaborazione del Foglio di lavoro: PF";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    
    sheet = (SXSSFSheet) wb.createSheet("Persone Fisiche") ;
    
    
    sheet.setColumnWidth(0, (17+3)*256 );
    sheet.setColumnWidth(1, (17+3)*256 );
    sheet.setColumnWidth(2, (14+3)*256 );
    sheet.setColumnWidth(3, (19+3)*256 );
    sheet.setColumnWidth(4, (15+3)*256 );
    sheet.setColumnWidth(5, (12+3)*256 );
    sheet.setColumnWidth(6, (12+3)*256 );
    sheet.setColumnWidth(7, (22+3)*256 );
    sheet.setColumnWidth(8, (13+3)*256 );
    sheet.setColumnWidth(9, (13+3)*256 );
    sheet.setColumnWidth(10, (10+3)*256 );
    sheet.setColumnWidth(11, (19+3)*256 );
    //Creo il record da scrivere
    row = sheet.createRow(0);
    
    //DATI SOGGETTO PF
    cell = row.createCell(0); cell.setCellStyle(style); cell.setCellValue("CODICE_NDG");
    cell = row.createCell(1); cell.setCellStyle(style); cell.setCellValue("CODICE_FISCALE");
    cell = row.createCell(2); cell.setCellStyle(style); cell.setCellValue("RAGIONE_SOCIALE");
    cell = row.createCell(3); cell.setCellStyle(style); cell.setCellValue("CODICE_CAP");
    cell = row.createCell(4); cell.setCellStyle(style); cell.setCellValue("CODICE_CAB");
    cell = row.createCell(5); cell.setCellStyle(style); cell.setCellValue("PAESE");
    cell = row.createCell(6); cell.setCellStyle(style); cell.setCellValue("CITTA");
    cell = row.createCell(7); cell.setCellStyle(style); cell.setCellValue("PROVINCIA");
    cell = row.createCell(8); cell.setCellStyle(style); cell.setCellValue("DATANASC");
    cell = row.createCell(9); cell.setCellStyle(style); cell.setCellValue("STATONASC");
    cell = row.createCell(10); cell.setCellStyle(style); cell.setCellValue("PIVA");
    
    _cnt = 1;
    for (MemoryCursorRow_mcpersonstorico_mcrdef rw_riga_pers : _mc_soggetti_pf._iterable_()) {
      /* If rw_riga_pers.NOSARA='E' */
      if (CPLib.eqr(rw_riga_pers.NOSARA,"E")) {
        /* _dataOpe := iif(Empty(rw_riga_pers.DATANASC) or DateToChar(rw_riga_pers.DATANASC)='01000101',Space(8),DateToChar(rw_riga_pers.DATANASC)) */
        _dataOpe = (CPLib.Empty(rw_riga_pers.DATANASC) || CPLib.eqr(CPLib.DateToChar(rw_riga_pers.DATANASC),"01000101")?CPLib.Space(8):CPLib.DateToChar(rw_riga_pers.DATANASC));
        row = sheet.createRow(_cnt);
        
        //DATI SOGETTO PF
        cell = row.createCell(0); cell.setCellValue(rw_riga_pers.CONNES);
        cell = row.createCell(1); cell.setCellValue(rw_riga_pers.CODFISC);
        cell = row.createCell(2); cell.setCellValue(rw_riga_pers.RAGSOC);
        cell = row.createCell(3); cell.setCellValue(rw_riga_pers.CAP);
        cell = row.createCell(4); cell.setCellValue(rw_riga_pers.CAB);
        cell = row.createCell(5); cell.setCellValue(rw_riga_pers.PAESE);
        cell = row.createCell(6); cell.setCellValue(rw_riga_pers.DESCCIT);
        cell = row.createCell(7); cell.setCellValue(rw_riga_pers.PROVINCIA);
        cell = row.createCell(8); cell.setCellValue(_dataOpe);
        cell = row.createCell(9); cell.setCellValue(rw_riga_pers.IDNASSTATO);
        cell = row.createCell(10); cell.setCellValue(rw_riga_pers.PIVA);
        /* _cnt := _cnt+1 */
        _cnt = _cnt+1;
      } // End If
    }
    /* gMsgImp := "Elaborazione del Foglio di lavoro: PNF" */
    gMsgImp = "Elaborazione del Foglio di lavoro: PNF";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    
    sheet = (SXSSFSheet) wb.createSheet("Persone Non Fisiche") ;
    
    sheet.setColumnWidth(0, (17+3)*256 );
    sheet.setColumnWidth(1, (17+3)*256 );
    sheet.setColumnWidth(2, (14+3)*256 );
    sheet.setColumnWidth(3, (19+3)*256 );
    sheet.setColumnWidth(4, (15+3)*256 );
    sheet.setColumnWidth(5, (12+3)*256 );
    sheet.setColumnWidth(6, (12+3)*256 );
    sheet.setColumnWidth(7, (22+3)*256 );
    sheet.setColumnWidth(8, (13+3)*256 );
    sheet.setColumnWidth(9, (13+3)*256 );
    sheet.setColumnWidth(10, (10+3)*256 );
    sheet.setColumnWidth(11, (19+3)*256 );
    //Creo il record da scrivere
    row = sheet.createRow(0);
    
    //DATI SOGGETTO PF
    cell = row.createCell(0); cell.setCellStyle(style); cell.setCellValue("CODICE_NDG");
    cell = row.createCell(1); cell.setCellStyle(style); cell.setCellValue("CODICE_FISCALE");
    cell = row.createCell(2); cell.setCellStyle(style); cell.setCellValue("RAGIONE_SOCIALE");
    cell = row.createCell(3); cell.setCellStyle(style); cell.setCellValue("CODICE_CAP");
    cell = row.createCell(4); cell.setCellStyle(style); cell.setCellValue("CODICE_CAB");
    cell = row.createCell(5); cell.setCellStyle(style); cell.setCellValue("PAESE");
    cell = row.createCell(6); cell.setCellStyle(style); cell.setCellValue("CITTA");
    cell = row.createCell(7); cell.setCellStyle(style); cell.setCellValue("PROVINCIA");
    cell = row.createCell(8); cell.setCellStyle(style); cell.setCellValue("DATANASC");
    cell = row.createCell(9); cell.setCellStyle(style); cell.setCellValue("STATONASC");
    cell = row.createCell(10); cell.setCellStyle(style); cell.setCellValue("PIVA");
    
    _cnt = 1;
    for (MemoryCursorRow_mcpersonstorico_mcrdef rw_riga_pers : _mc_soggetti_pnf._iterable_()) {
      /* If rw_riga_pers.NOSARA='E' */
      if (CPLib.eqr(rw_riga_pers.NOSARA,"E")) {
        /* _dataOpe := iif(Empty(rw_riga_pers.DATANASC) or DateToChar(rw_riga_pers.DATANASC)='01000101',Space(8),DateToChar(rw_riga_pers.DATANASC)) */
        _dataOpe = (CPLib.Empty(rw_riga_pers.DATANASC) || CPLib.eqr(CPLib.DateToChar(rw_riga_pers.DATANASC),"01000101")?CPLib.Space(8):CPLib.DateToChar(rw_riga_pers.DATANASC));
        row = sheet.createRow(_cnt);
        
        //DATI SOGETTO PF
        cell = row.createCell(0); cell.setCellValue(rw_riga_pers.CONNES);
        cell = row.createCell(1); cell.setCellValue(rw_riga_pers.CODFISC);
        cell = row.createCell(2); cell.setCellValue(rw_riga_pers.RAGSOC);
        cell = row.createCell(3); cell.setCellValue(rw_riga_pers.CAP);
        cell = row.createCell(4); cell.setCellValue(rw_riga_pers.CAB);
        cell = row.createCell(5); cell.setCellValue(rw_riga_pers.PAESE);
        cell = row.createCell(6); cell.setCellValue(rw_riga_pers.DESCCIT);
        cell = row.createCell(7); cell.setCellValue(rw_riga_pers.PROVINCIA);
        cell = row.createCell(8); cell.setCellValue(_dataOpe);
        cell = row.createCell(9); cell.setCellValue(rw_riga_pers.IDNASSTATO);
        cell = row.createCell(10); cell.setCellValue(rw_riga_pers.PIVA);
        /* _cnt := _cnt+1 */
        _cnt = _cnt+1;
      } // End If
    }
    // scrivo il file di esito
    FileOutputStream fileOut = new FileOutputStream(_nfile);
    //write this workbook to an Outputstream.
    wb.write(fileOut);
    //fileOut.flush();
    fileOut.close();
    wb.dispose();
    /* gMsgProc := gMsgProc +'Ora Fine Creazione file di Stampa: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Ora Fine Creazione file di Stampa: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
  }
  void titolari() throws Exception {
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_wntestit=null;
    CPResultSet Cursor_rapotit=null;
    CPResultSet Cursor_wapotit=null;
    CPResultSet Cursor_japotit=null;
    try {
      /* _isThereInfo := False */
      _isThereInfo = false;
      /* _isThereSomething := False */
      _isThereSomething = false;
      /* _contarow := 0 */
      _contarow = CPLib.Round(0,0);
      /* _contaop := 0 */
      _contaop = CPLib.Round(0,0);
      /* If Empty(_ddatini) */
      if (CPLib.Empty(_ddatini)) {
        /* If w_chi_chiama_la_routine="AUI" */
        if (CPLib.eqr(w_chi_chiama_la_routine,"AUI")) {
          // * --- Select from intestit
          m_cServer = m_Ctx.GetServer("intestit");
          m_cPhName = m_Ctx.GetPhName("intestit");
          if (Cursor_intestit!=null)
            Cursor_intestit.Close();
          Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAFINE<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatfin)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAFINE ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestit.Eof())) {
            /* _ddatini := intestit->DATAFINE */
            _ddatini = Cursor_intestit.GetDate("DATAFINE");
            /* _isThereSomething := True */
            _isThereSomething = true;
            // Exit Loop
            if (true) {
              break;
            }
            Cursor_intestit.Next();
          }
          m_cConnectivityError = Cursor_intestit.ErrorMessage();
          Cursor_intestit.Close();
          // * --- End Select
          /* ElseIf w_chi_chiama_la_routine="STO" */
        } else if (CPLib.eqr(w_chi_chiama_la_routine,"STO")) {
          // * --- Select from wntestit
          m_cServer = m_Ctx.GetServer("wntestit");
          m_cPhName = m_Ctx.GetPhName("wntestit");
          if (Cursor_wntestit!=null)
            Cursor_wntestit.Close();
          Cursor_wntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAFINE<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatfin)+" "+")"+(m_Ctx.IsSharedTemp("wntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAFINE ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_wntestit.Eof())) {
            /* _ddatini := wntestit->DATAFINE */
            _ddatini = Cursor_wntestit.GetDate("DATAFINE");
            /* _isThereSomething := True */
            _isThereSomething = true;
            // Exit Loop
            if (true) {
              break;
            }
            Cursor_wntestit.Next();
          }
          m_cConnectivityError = Cursor_wntestit.ErrorMessage();
          Cursor_wntestit.Close();
          // * --- End Select
        } // End If
      } else { // Else
        /* If w_chi_chiama_la_routine="AUI" */
        if (CPLib.eqr(w_chi_chiama_la_routine,"AUI")) {
          // * --- Select from intestit
          m_cServer = m_Ctx.GetServer("intestit");
          m_cPhName = m_Ctx.GetPhName("intestit");
          if (Cursor_intestit!=null)
            Cursor_intestit.Close();
          Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAFINE>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatini)+"  and  DATAFINE<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatfin)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAFINE ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestit.Eof())) {
            /* _ddatini := intestit->DATAFINE */
            _ddatini = Cursor_intestit.GetDate("DATAFINE");
            /* _isThereSomething := True */
            _isThereSomething = true;
            // Exit Loop
            if (true) {
              break;
            }
            Cursor_intestit.Next();
          }
          m_cConnectivityError = Cursor_intestit.ErrorMessage();
          Cursor_intestit.Close();
          // * --- End Select
          /* ElseIf w_chi_chiama_la_routine="STO" */
        } else if (CPLib.eqr(w_chi_chiama_la_routine,"STO")) {
          // * --- Select from wntestit
          m_cServer = m_Ctx.GetServer("wntestit");
          m_cPhName = m_Ctx.GetPhName("wntestit");
          if (Cursor_wntestit!=null)
            Cursor_wntestit.Close();
          Cursor_wntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAFINE  and  DATAFINE<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatfin)+" "+")"+(m_Ctx.IsSharedTemp("wntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAFINE ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_wntestit.Eof())) {
            /* _ddatini := wntestit->DATAFINE */
            _ddatini = Cursor_wntestit.GetDate("DATAFINE");
            /* _isThereSomething := True */
            _isThereSomething = true;
            // Exit Loop
            if (true) {
              break;
            }
            Cursor_wntestit.Next();
          }
          m_cConnectivityError = Cursor_wntestit.ErrorMessage();
          Cursor_wntestit.Close();
          // * --- End Select
        } // End If
      } // End If
      /* gMsgProc := gMsgProc+"Analisi dei legami di titolarità tra i soggetti"+NL // Messaggio */
      gMsgProc = gMsgProc+"Analisi dei legami di titolarità tra i soggetti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If _isThereSomething */
      if (_isThereSomething) {
        /* Se effettivamente ci sono chiusure nel periodo */
        /* If w_chi_chiama_la_routine="AUI" */
        if (CPLib.eqr(w_chi_chiama_la_routine,"AUI")) {
          // * --- Fill memory cursor _mc_intestit on intestit
          _mc_intestit.Zap();
          m_cServer = m_Ctx.GetServer("intestit");
          m_cPhName = m_Ctx.GetPhName("intestit");
          if (Cursor_intestit!=null)
            Cursor_intestit.Close();
          Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAFINE>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatini)+"  and  DATAFINE<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatfin)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_intestit;
            Cursor_intestit.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_stor_trasf: query on intestit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_intestit.Eof())) {
            _mc_intestit.AppendBlank();
            _mc_intestit.row.CODCLI = Cursor_intestit.GetString("CODCLI");
            _mc_intestit.row.RAPPORTO = Cursor_intestit.GetString("RAPPORTO");
            _mc_intestit.row.CODINTER = Cursor_intestit.GetString("CODINTER");
            _mc_intestit.row.DESCINTER = Cursor_intestit.GetString("DESCINTER");
            _mc_intestit.row.DATAINI = Cursor_intestit.GetDate("DATAINI");
            _mc_intestit.row.TIPORAP = Cursor_intestit.GetString("TIPORAP");
            _mc_intestit.row.TIPOPERS = Cursor_intestit.GetString("TIPOPERS");
            _mc_intestit.row.STATOREG = Cursor_intestit.GetString("STATOREG");
            _mc_intestit.row.OPERAZMOD = Cursor_intestit.GetString("OPERAZMOD");
            _mc_intestit.row.DATARETT = Cursor_intestit.GetDate("DATARETT");
            _mc_intestit.row.IDEREG = Cursor_intestit.GetString("IDEREG");
            _mc_intestit.row.COLLEGAMEN = Cursor_intestit.GetString("COLLEGAMEN");
            _mc_intestit.row.DATAFINE = Cursor_intestit.GetDate("DATAFINE");
            _mc_intestit.row.NUMPROG1 = Cursor_intestit.GetString("NUMPROG1");
            _mc_intestit.row.NUMPROG2 = Cursor_intestit.GetString("NUMPROG2");
            _mc_intestit.row.IDBASE = Cursor_intestit.GetString("IDBASE");
            _mc_intestit.row.UCODE = Cursor_intestit.GetString("UCODE");
            _mc_intestit.row.ABBINATO = Cursor_intestit.GetDouble("ABBINATO");
            _mc_intestit.row.PRGIMPTITE = Cursor_intestit.GetDouble("PRGIMPTITE");
            _mc_intestit.row.NUMIMP = Cursor_intestit.GetDateTime("NUMIMP");
            _mc_intestit.row.NOAGE = Cursor_intestit.GetString("NOAGE");
            Cursor_intestit.Next();
          }
          m_cConnectivityError = Cursor_intestit.ErrorMessage();
          Cursor_intestit.Close();
          _mc_intestit.GoTop();
          for (MemoryCursorRow_intestit rw_intestino : _mc_intestit._iterable_()) {
            /* gMsgImp := "Analisi del legame del soggetto: "+rw_intestino.CODINTER */
            gMsgImp = "Analisi del legame del soggetto: "+rw_intestino.CODINTER;
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* Aggiungo i Soggetti a quelli da controllare (eventuale penzoloni) */
            /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(rw_intestino.CODINTER) */
            add_sogg_mc(rw_intestino.CODINTER);
            /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(rw_intestino.CODCLI) */
            add_sogg_mc(rw_intestino.CODCLI);
            /* If w_tipoope = 'T' and At(w_stampa,'|E|S') <> 0 */
            if (CPLib.eqr(w_tipoope,"T") && CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
              /* Trasferisco il titolare a storico */
              // * --- Insert into intestit from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("intestit");
              m_cPhName = m_Ctx.GetPhName("intestit");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestit",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000406")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000406(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.UCODE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.TIPORAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.TIPOPERS,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.STATOREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.RAPPORTO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.PRGIMPTITE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.OPERAZMOD,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.NUMPROG2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.NUMPROG1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.IDEREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.IDBASE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.DESCINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.DATARETT,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.DATAINI,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.DATAFINE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.COLLEGAMEN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.CODINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.CODCLI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.ABBINATO,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"intestit",true);
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
              /* Trasferisco le informazioni a strorico (50 e 51) */
              // * --- Select from rapotit
              m_cServer = m_Ctx.GetServer("rapotit");
              m_cPhName = m_Ctx.GetPhName("rapotit");
              if (Cursor_rapotit!=null)
                Cursor_rapotit.Close();
              Cursor_rapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_intestino.NUMPROG1,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_intestino.NUMPROG1)+" "+")"+(m_Ctx.IsSharedTemp("rapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_rapotit.Eof())) {
                /* _isThereInfo := False */
                _isThereInfo = false;
                /* Controllo che l'informazione non ci sia già */
                // * --- Select from wapotit
                m_cServer = m_Ctx.GetServer("wapotit");
                m_cPhName = m_Ctx.GetPhName("wapotit");
                if (Cursor_wapotit!=null)
                  Cursor_wapotit.Close();
                Cursor_wapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG = "+CPLib.ToSQL(Cursor_rapotit.GetString("NUMPROG"),"?",0,0)+"  and  TIPOOPRAP= "+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOOPRAP"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("wapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wapotit.Eof())) {
                  /* _isThereInfo := True */
                  _isThereInfo = true;
                  Cursor_wapotit.Next();
                }
                m_cConnectivityError = Cursor_wapotit.ErrorMessage();
                Cursor_wapotit.Close();
                // * --- End Select
                /* If not(_isThereInfo) */
                if ( ! (_isThereInfo)) {
                  /* Se l'informazione non cè la inserisco */
                  // * --- Insert into wapotit from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("wapotit");
                  m_cPhName = m_Ctx.GetPhName("wapotit");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wapotit",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000040F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000040F(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDouble("CAMBIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDate("DATAAGE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDate("DATAOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDate("DATAREG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDate("DATARETT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("IDBASE2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDouble("PRGIMPTIT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDouble("TOTCONT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetDouble("TOTLIRE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rapotit.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wapotit",true);
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
                Cursor_rapotit.Next();
              }
              m_cConnectivityError = Cursor_rapotit.ErrorMessage();
              Cursor_rapotit.Close();
              // * --- End Select
            } // End If
            /* If At(w_stampa,'|E|S') <> 0 */
            if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
              // * --- Delete from intestit
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("intestit");
              m_cPhName = m_Ctx.GetPhName("intestit");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestit",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000411")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_intestino.IDBASE,"?",0,0,m_cServer),m_cServer,rw_intestino.IDBASE)+"";
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
            /* _contarow := _contarow+1 */
            _contarow = CPLib.Round(_contarow+1,0);
            /* Tento di eliminare l'informazione (se non ha più voci in intestit) */
            // * --- Fill memory cursor _mc_rapotit on japotit
            _mc_rapotit.Zap();
            m_cServer = m_Ctx.GetServer("japotit");
            m_cPhName = m_Ctx.GetPhName("japotit");
            if (Cursor_japotit!=null)
              Cursor_japotit.Close();
            Cursor_japotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESCLI"),"?",0,0)+" = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_intestino.CODCLI,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_intestino.CODCLI)+" "+")"+(m_Ctx.IsSharedTemp("japotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_japotit;
              Cursor_japotit.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stor_trasf: query on japotit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_japotit.Eof())) {
              _mc_rapotit.AppendBlank();
              _mc_rapotit.row.IDBASE = Cursor_japotit.GetString("IDBASE");
              _mc_rapotit.row.DATAOPE = Cursor_japotit.GetDate("DATAOPE");
              _mc_rapotit.row.NUMPROG = Cursor_japotit.GetString("NUMPROG");
              _mc_rapotit.row.TIPOINTER = Cursor_japotit.GetString("TIPOINTER");
              _mc_rapotit.row.CODINTER = Cursor_japotit.GetString("CODINTER");
              _mc_rapotit.row.TIPOINF = Cursor_japotit.GetString("TIPOINF");
              _mc_rapotit.row.IDEREG = Cursor_japotit.GetString("IDEREG");
              _mc_rapotit.row.CODDIPE = Cursor_japotit.GetString("CODDIPE");
              _mc_rapotit.row.DESCCIT = Cursor_japotit.GetString("DESCCIT");
              _mc_rapotit.row.PROVINCIA = Cursor_japotit.GetString("PROVINCIA");
              _mc_rapotit.row.CODCAB = Cursor_japotit.GetString("CODCAB");
              _mc_rapotit.row.FLAGFRAZ = Cursor_japotit.GetString("FLAGFRAZ");
              _mc_rapotit.row.FLAGCONT = Cursor_japotit.GetString("FLAGCONT");
              _mc_rapotit.row.CODANA = Cursor_japotit.GetString("CODANA");
              _mc_rapotit.row.CODVOC = Cursor_japotit.GetString("CODVOC");
              _mc_rapotit.row.TIPOINT2 = Cursor_japotit.GetString("TIPOINT2");
              _mc_rapotit.row.CODINT2 = Cursor_japotit.GetString("CODINT2");
              _mc_rapotit.row.PAESE = Cursor_japotit.GetString("PAESE");
              _mc_rapotit.row.DESC2 = Cursor_japotit.GetString("DESC2");
              _mc_rapotit.row.PROV2 = Cursor_japotit.GetString("PROV2");
              _mc_rapotit.row.CODCAB2 = Cursor_japotit.GetString("CODCAB2");
              _mc_rapotit.row.DESCINTER = Cursor_japotit.GetString("DESCINTER");
              _mc_rapotit.row.RAPPORTO = Cursor_japotit.GetString("RAPPORTO");
              _mc_rapotit.row.FLAGRAP = Cursor_japotit.GetString("FLAGRAP");
              _mc_rapotit.row.TIPOLEG = Cursor_japotit.GetString("TIPOLEG");
              _mc_rapotit.row.DATAREG = Cursor_japotit.GetDate("DATAREG");
              _mc_rapotit.row.OPRAP = Cursor_japotit.GetString("OPRAP");
              _mc_rapotit.row.TIPOOPRAP = Cursor_japotit.GetString("TIPOOPRAP");
              _mc_rapotit.row.FLAGLIRE = Cursor_japotit.GetString("FLAGLIRE");
              _mc_rapotit.row.VALUTA = Cursor_japotit.GetString("VALUTA");
              _mc_rapotit.row.SEGNO = Cursor_japotit.GetString("SEGNO");
              _mc_rapotit.row.TOTLIRE = Cursor_japotit.GetDouble("TOTLIRE");
              _mc_rapotit.row.TOTCONT = Cursor_japotit.GetDouble("TOTCONT");
              _mc_rapotit.row.STATOREG = Cursor_japotit.GetString("STATOREG");
              _mc_rapotit.row.OPERAZMOD = Cursor_japotit.GetString("OPERAZMOD");
              _mc_rapotit.row.DATARETT = Cursor_japotit.GetDate("DATARETT");
              _mc_rapotit.row.CONNESCLI = Cursor_japotit.GetString("CONNESCLI");
              _mc_rapotit.row.CONNESOPER = Cursor_japotit.GetString("CONNESOPER");
              _mc_rapotit.row.CONNESBEN = Cursor_japotit.GetString("CONNESBEN");
              _mc_rapotit.row.COLLEG = Cursor_japotit.GetString("COLLEG");
              _mc_rapotit.row.CAMBIO = Cursor_japotit.GetDouble("CAMBIO");
              _mc_rapotit.row.RAPPORTBEN = Cursor_japotit.GetString("RAPPORTBEN");
              _mc_rapotit.row.FLAGRAP2 = Cursor_japotit.GetString("FLAGRAP2");
              _mc_rapotit.row.OPERATORE = Cursor_japotit.GetString("OPERATORE");
              _mc_rapotit.row.AUTOM = Cursor_japotit.GetString("AUTOM");
              _mc_rapotit.row.RESPINS = Cursor_japotit.GetString("RESPINS");
              _mc_rapotit.row.INFORM = Cursor_japotit.GetString("INFORM");
              _mc_rapotit.row.DATAAGE = Cursor_japotit.GetDate("DATAAGE");
              _mc_rapotit.row.UCODE = Cursor_japotit.GetString("UCODE");
              _mc_rapotit.row.PRGIMPTIT = Cursor_japotit.GetDouble("PRGIMPTIT");
              _mc_rapotit.row.CDATOPE = Cursor_japotit.GetString("CDATOPE");
              _mc_rapotit.row.UNIQUECODE = Cursor_japotit.GetString("UNIQUECODE");
              _mc_rapotit.row.CDATREG = Cursor_japotit.GetString("CDATREG");
              _mc_rapotit.row.IDBASE2 = Cursor_japotit.GetString("IDBASE2");
              _mc_rapotit.row.NUMIMP = Cursor_japotit.GetDateTime("NUMIMP");
              Cursor_japotit.Next();
            }
            m_cConnectivityError = Cursor_japotit.ErrorMessage();
            Cursor_japotit.Close();
            _mc_rapotit.GoTop();
            for (MemoryCursorRow_rapotit rw_rapotitte : _mc_rapotit._iterable_()) {
              /* Cerco dei titolari in base al NUMPROG */
              /* _isThereInfo := False */
              _isThereInfo = false;
              // * --- Select from intestit
              m_cServer = m_Ctx.GetServer("intestit");
              m_cPhName = m_Ctx.GetPhName("intestit");
              if (Cursor_intestit!=null)
                Cursor_intestit.Close();
              Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_rapotitte.NUMPROG,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_rapotitte.NUMPROG)+"=NUMPROG1  or  "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_rapotitte.NUMPROG,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_rapotitte.NUMPROG)+"=NUMPROG2 "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestit.Eof())) {
                /* Ci sono ancora titolari */
                /* _isThereInfo := True */
                _isThereInfo = true;
                Cursor_intestit.Next();
              }
              m_cConnectivityError = Cursor_intestit.ErrorMessage();
              Cursor_intestit.Close();
              // * --- End Select
              /* If not(_isThereInfo) */
              if ( ! (_isThereInfo)) {
                /* Se l'informazione NON ha più titolari associati la cancello */
                /* If At(w_stampa,'|E|S') <> 0 */
                if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                  // * --- Delete from rapotit
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("rapotit");
                  m_cPhName = m_Ctx.GetPhName("rapotit");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000041E")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_rapotitte.IDBASE,"?",0,0,m_cServer),m_cServer,rw_rapotitte.IDBASE)+"";
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
                /* _contaop := _contaop+1 */
                _contaop = CPLib.Round(_contaop+1,0);
              } // End If
            }
          }
          /* ElseIf w_chi_chiama_la_routine="STO" */
        } else if (CPLib.eqr(w_chi_chiama_la_routine,"STO")) {
          // * --- Fill memory cursor _mc_intestit on wntestit
          _mc_intestit.Zap();
          m_cServer = m_Ctx.GetServer("wntestit");
          m_cPhName = m_Ctx.GetPhName("wntestit");
          if (Cursor_wntestit!=null)
            Cursor_wntestit.Close();
          Cursor_wntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAFINE>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatini)+"  and  DATAFINE<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatfin)+" "+")"+(m_Ctx.IsSharedTemp("wntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_wntestit;
            Cursor_wntestit.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_stor_trasf: query on wntestit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_wntestit.Eof())) {
            _mc_intestit.AppendBlank();
            _mc_intestit.row.CODCLI = Cursor_wntestit.GetString("CODCLI");
            _mc_intestit.row.RAPPORTO = Cursor_wntestit.GetString("RAPPORTO");
            _mc_intestit.row.CODINTER = Cursor_wntestit.GetString("CODINTER");
            _mc_intestit.row.DESCINTER = Cursor_wntestit.GetString("DESCINTER");
            _mc_intestit.row.DATAINI = Cursor_wntestit.GetDate("DATAINI");
            _mc_intestit.row.TIPORAP = Cursor_wntestit.GetString("TIPORAP");
            _mc_intestit.row.TIPOPERS = Cursor_wntestit.GetString("TIPOPERS");
            _mc_intestit.row.STATOREG = Cursor_wntestit.GetString("STATOREG");
            _mc_intestit.row.OPERAZMOD = Cursor_wntestit.GetString("OPERAZMOD");
            _mc_intestit.row.DATARETT = Cursor_wntestit.GetDate("DATARETT");
            _mc_intestit.row.IDEREG = Cursor_wntestit.GetString("IDEREG");
            _mc_intestit.row.COLLEGAMEN = Cursor_wntestit.GetString("COLLEGAMEN");
            _mc_intestit.row.DATAFINE = Cursor_wntestit.GetDate("DATAFINE");
            _mc_intestit.row.NUMPROG1 = Cursor_wntestit.GetString("NUMPROG1");
            _mc_intestit.row.NUMPROG2 = Cursor_wntestit.GetString("NUMPROG2");
            _mc_intestit.row.IDBASE = Cursor_wntestit.GetString("IDBASE");
            _mc_intestit.row.UCODE = Cursor_wntestit.GetString("UCODE");
            _mc_intestit.row.ABBINATO = Cursor_wntestit.GetDouble("ABBINATO");
            _mc_intestit.row.PRGIMPTITE = Cursor_wntestit.GetDouble("PRGIMPTITE");
            _mc_intestit.row.NUMIMP = Cursor_wntestit.GetDateTime("NUMIMP");
            _mc_intestit.row.NOAGE = Cursor_wntestit.GetString("NOAGE");
            Cursor_wntestit.Next();
          }
          m_cConnectivityError = Cursor_wntestit.ErrorMessage();
          Cursor_wntestit.Close();
          _mc_intestit.GoTop();
          for (MemoryCursorRow_intestit rw_wntestino : _mc_intestit._iterable_()) {
            /* gMsgImp := "Analisi del legame del soggetto: "+rw_wntestino.CODINTER */
            gMsgImp = "Analisi del legame del soggetto: "+rw_wntestino.CODINTER;
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* Aggiungo i Soggetti a quelli da controllare (eventuale penzoloni) */
            /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(rw_wntestino.CODINTER) */
            add_sogg_mc(rw_wntestino.CODINTER);
            /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(rw_wntestino.CODCLI) */
            add_sogg_mc(rw_wntestino.CODCLI);
            /* If At(w_stampa,'|E|S') <> 0 */
            if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
              // * --- Delete from wntestit
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("wntestit");
              m_cPhName = m_Ctx.GetPhName("wntestit");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wntestit",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000427")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_wntestino.IDBASE,"?",0,0,m_cServer),m_cServer,rw_wntestino.IDBASE)+"";
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
            /* _contarow := _contarow+1 */
            _contarow = CPLib.Round(_contarow+1,0);
            // * --- Fill memory cursor _mc_rapotit on wapotit
            _mc_rapotit.Zap();
            m_cServer = m_Ctx.GetServer("wapotit");
            m_cPhName = m_Ctx.GetPhName("wapotit");
            if (Cursor_wapotit!=null)
              Cursor_wapotit.Close();
            Cursor_wapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_wntestino.CODCLI,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_wntestino.CODCLI)+" "+")"+(m_Ctx.IsSharedTemp("wapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_wapotit;
              Cursor_wapotit.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stor_trasf: query on wapotit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_wapotit.Eof())) {
              _mc_rapotit.AppendBlank();
              _mc_rapotit.row.IDBASE = Cursor_wapotit.GetString("IDBASE");
              _mc_rapotit.row.DATAOPE = Cursor_wapotit.GetDate("DATAOPE");
              _mc_rapotit.row.NUMPROG = Cursor_wapotit.GetString("NUMPROG");
              _mc_rapotit.row.TIPOINTER = Cursor_wapotit.GetString("TIPOINTER");
              _mc_rapotit.row.CODINTER = Cursor_wapotit.GetString("CODINTER");
              _mc_rapotit.row.TIPOINF = Cursor_wapotit.GetString("TIPOINF");
              _mc_rapotit.row.IDEREG = Cursor_wapotit.GetString("IDEREG");
              _mc_rapotit.row.CODDIPE = Cursor_wapotit.GetString("CODDIPE");
              _mc_rapotit.row.DESCCIT = Cursor_wapotit.GetString("DESCCIT");
              _mc_rapotit.row.PROVINCIA = Cursor_wapotit.GetString("PROVINCIA");
              _mc_rapotit.row.CODCAB = Cursor_wapotit.GetString("CODCAB");
              _mc_rapotit.row.FLAGFRAZ = Cursor_wapotit.GetString("FLAGFRAZ");
              _mc_rapotit.row.FLAGCONT = Cursor_wapotit.GetString("FLAGCONT");
              _mc_rapotit.row.CODANA = Cursor_wapotit.GetString("CODANA");
              _mc_rapotit.row.CODVOC = Cursor_wapotit.GetString("CODVOC");
              _mc_rapotit.row.TIPOINT2 = Cursor_wapotit.GetString("TIPOINT2");
              _mc_rapotit.row.CODINT2 = Cursor_wapotit.GetString("CODINT2");
              _mc_rapotit.row.PAESE = Cursor_wapotit.GetString("PAESE");
              _mc_rapotit.row.DESC2 = Cursor_wapotit.GetString("DESC2");
              _mc_rapotit.row.PROV2 = Cursor_wapotit.GetString("PROV2");
              _mc_rapotit.row.CODCAB2 = Cursor_wapotit.GetString("CODCAB2");
              _mc_rapotit.row.DESCINTER = Cursor_wapotit.GetString("DESCINTER");
              _mc_rapotit.row.RAPPORTO = Cursor_wapotit.GetString("RAPPORTO");
              _mc_rapotit.row.FLAGRAP = Cursor_wapotit.GetString("FLAGRAP");
              _mc_rapotit.row.TIPOLEG = Cursor_wapotit.GetString("TIPOLEG");
              _mc_rapotit.row.DATAREG = Cursor_wapotit.GetDate("DATAREG");
              _mc_rapotit.row.OPRAP = Cursor_wapotit.GetString("OPRAP");
              _mc_rapotit.row.TIPOOPRAP = Cursor_wapotit.GetString("TIPOOPRAP");
              _mc_rapotit.row.FLAGLIRE = Cursor_wapotit.GetString("FLAGLIRE");
              _mc_rapotit.row.VALUTA = Cursor_wapotit.GetString("VALUTA");
              _mc_rapotit.row.SEGNO = Cursor_wapotit.GetString("SEGNO");
              _mc_rapotit.row.TOTLIRE = Cursor_wapotit.GetDouble("TOTLIRE");
              _mc_rapotit.row.TOTCONT = Cursor_wapotit.GetDouble("TOTCONT");
              _mc_rapotit.row.STATOREG = Cursor_wapotit.GetString("STATOREG");
              _mc_rapotit.row.OPERAZMOD = Cursor_wapotit.GetString("OPERAZMOD");
              _mc_rapotit.row.DATARETT = Cursor_wapotit.GetDate("DATARETT");
              _mc_rapotit.row.CONNESCLI = Cursor_wapotit.GetString("CONNESCLI");
              _mc_rapotit.row.CONNESOPER = Cursor_wapotit.GetString("CONNESOPER");
              _mc_rapotit.row.CONNESBEN = Cursor_wapotit.GetString("CONNESBEN");
              _mc_rapotit.row.COLLEG = Cursor_wapotit.GetString("COLLEG");
              _mc_rapotit.row.CAMBIO = Cursor_wapotit.GetDouble("CAMBIO");
              _mc_rapotit.row.RAPPORTBEN = Cursor_wapotit.GetString("RAPPORTBEN");
              _mc_rapotit.row.FLAGRAP2 = Cursor_wapotit.GetString("FLAGRAP2");
              _mc_rapotit.row.OPERATORE = Cursor_wapotit.GetString("OPERATORE");
              _mc_rapotit.row.AUTOM = Cursor_wapotit.GetString("AUTOM");
              _mc_rapotit.row.RESPINS = Cursor_wapotit.GetString("RESPINS");
              _mc_rapotit.row.INFORM = Cursor_wapotit.GetString("INFORM");
              _mc_rapotit.row.DATAAGE = Cursor_wapotit.GetDate("DATAAGE");
              _mc_rapotit.row.UCODE = Cursor_wapotit.GetString("UCODE");
              _mc_rapotit.row.PRGIMPTIT = Cursor_wapotit.GetDouble("PRGIMPTIT");
              _mc_rapotit.row.CDATOPE = Cursor_wapotit.GetString("CDATOPE");
              _mc_rapotit.row.UNIQUECODE = Cursor_wapotit.GetString("UNIQUECODE");
              _mc_rapotit.row.CDATREG = Cursor_wapotit.GetString("CDATREG");
              _mc_rapotit.row.IDBASE2 = Cursor_wapotit.GetString("IDBASE2");
              _mc_rapotit.row.NUMIMP = Cursor_wapotit.GetDateTime("NUMIMP");
              Cursor_wapotit.Next();
            }
            m_cConnectivityError = Cursor_wapotit.ErrorMessage();
            Cursor_wapotit.Close();
            _mc_rapotit.GoTop();
            for (MemoryCursorRow_rapotit rw_wapotitte : _mc_rapotit._iterable_()) {
              /* Cerco dei titolari in base al NUMPROG */
              /* _isThereInfo := False */
              _isThereInfo = false;
              // * --- Select from wntestit
              m_cServer = m_Ctx.GetServer("wntestit");
              m_cPhName = m_Ctx.GetPhName("wntestit");
              if (Cursor_wntestit!=null)
                Cursor_wntestit.Close();
              Cursor_wntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_wapotitte.NUMPROG,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_wapotitte.NUMPROG)+"=NUMPROG1  or  "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_wapotitte.NUMPROG,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_wapotitte.NUMPROG)+"=NUMPROG2 "+")"+(m_Ctx.IsSharedTemp("wntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wntestit.Eof())) {
                /* Ci sono ancora titolari */
                /* _isThereInfo := True */
                _isThereInfo = true;
                Cursor_wntestit.Next();
              }
              m_cConnectivityError = Cursor_wntestit.ErrorMessage();
              Cursor_wntestit.Close();
              // * --- End Select
              /* If not(_isThereInfo) */
              if ( ! (_isThereInfo)) {
                /* Se l'informazione NON ha più titolari associati la cancello */
                /* If At(w_stampa,'|E|S') <> 0 */
                if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                  // * --- Delete from wapotit
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("wapotit");
                  m_cPhName = m_Ctx.GetPhName("wapotit");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wapotit",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000433")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_wapotitte.IDBASE,"?",0,0,m_cServer),m_cServer,rw_wapotitte.IDBASE)+"";
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
                /* _contaop := _contaop+1 */
                _contaop = CPLib.Round(_contaop+1,0);
              } // End If
            }
          }
        } // End If
        /* gMsgProc := gMsgProc+"Numero di legami di titolari cancellati/trasferiti: "+Str(_contarow,10,0)+NL // Messaggio */
        gMsgProc = gMsgProc+"Numero di legami di titolari cancellati/trasferiti: "+CPLib.Str(_contarow,10,0)+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc+"Numero di informazioni di titolari cancellati/trasferiti: "+Str(_contaop,10,0)+NL // Messaggio */
        gMsgProc = gMsgProc+"Numero di informazioni di titolari cancellati/trasferiti: "+CPLib.Str(_contaop,10,0)+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc+"Non sono presenti informazioni nel periodo selezionato"+NL // Messaggio */
        gMsgProc = gMsgProc+"Non sono presenti informazioni nel periodo selezionato"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc+"Fine analisi dei legami di titolarità tra i soggetti"+NL // Messaggio */
      gMsgProc = gMsgProc+"Fine analisi dei legami di titolarità tra i soggetti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wntestit!=null)
          Cursor_wntestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_rapotit!=null)
          Cursor_rapotit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wapotit!=null)
          Cursor_wapotit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_japotit!=null)
          Cursor_japotit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void chktab() throws Exception {
    CPResultSet Cursor_qbe_tab_mmc=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* rowTabelle._clientiope := False */
      rowTabelle._clientiope = false;
      /* rowTabelle._sogopebo := False */
      rowTabelle._sogopebo = false;
      /* rowTabelle._beneficope := False */
      rowTabelle._beneficope = false;
      /* rowTabelle._terzistiope := False */
      rowTabelle._terzistiope = false;
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000043E;
      _h0000043E = new SPBridge.HMCaller();
      _h0000043E.Set("m_cVQRList",m_cVQRList);
      _h0000043E.Set("tbname","clientiope");
      _h0000043E.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000043E,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._clientiope := qbe_tab_mmc->tot > 0 */
        rowTabelle._clientiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000440;
      _h00000440 = new SPBridge.HMCaller();
      _h00000440.Set("m_cVQRList",m_cVQRList);
      _h00000440.Set("tbname","sogopebo");
      _h00000440.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000440,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._sogopebo := qbe_tab_mmc->tot > 0 */
        rowTabelle._sogopebo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000442;
      _h00000442 = new SPBridge.HMCaller();
      _h00000442.Set("m_cVQRList",m_cVQRList);
      _h00000442.Set("tbname","beneficope");
      _h00000442.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000442,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._beneficope := qbe_tab_mmc->tot > 0 */
        rowTabelle._beneficope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000444;
      _h00000444 = new SPBridge.HMCaller();
      _h00000444.Set("m_cVQRList",m_cVQRList);
      _h00000444.Set("tbname","terzistiope");
      _h00000444.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000444,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._terzistiope := qbe_tab_mmc->tot > 0 */
        rowTabelle._terzistiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* rowTabelle._clientifrz := False */
      rowTabelle._clientifrz = false;
      /* rowTabelle._sogopefbo := False */
      rowTabelle._sogopefbo = false;
      /* rowTabelle._beneficfrz := False */
      rowTabelle._beneficfrz = false;
      /* rowTabelle._terzistifrz := False */
      rowTabelle._terzistifrz = false;
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000044A;
      _h0000044A = new SPBridge.HMCaller();
      _h0000044A.Set("m_cVQRList",m_cVQRList);
      _h0000044A.Set("tbname","clientifrz");
      _h0000044A.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000044A,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._clientifrz := qbe_tab_mmc->tot > 0 */
        rowTabelle._clientifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000044C;
      _h0000044C = new SPBridge.HMCaller();
      _h0000044C.Set("m_cVQRList",m_cVQRList);
      _h0000044C.Set("tbname","sogopefbo");
      _h0000044C.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000044C,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._sogopefbo := qbe_tab_mmc->tot > 0 */
        rowTabelle._sogopefbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000044E;
      _h0000044E = new SPBridge.HMCaller();
      _h0000044E.Set("m_cVQRList",m_cVQRList);
      _h0000044E.Set("tbname","beneficfrz");
      _h0000044E.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000044E,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._beneficfrz := qbe_tab_mmc->tot > 0 */
        rowTabelle._beneficfrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000450;
      _h00000450 = new SPBridge.HMCaller();
      _h00000450.Set("m_cVQRList",m_cVQRList);
      _h00000450.Set("tbname","terzistifrz");
      _h00000450.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000450,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._terzistifrz := qbe_tab_mmc->tot > 0 */
        rowTabelle._terzistifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* rowTabelle._xlientiope := False */
      rowTabelle._xlientiope = false;
      /* rowTabelle._xogopebo := False */
      rowTabelle._xogopebo = false;
      /* rowTabelle._xeneficope := False */
      rowTabelle._xeneficope = false;
      /* rowTabelle._xerzistiope := False */
      rowTabelle._xerzistiope = false;
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000457;
      _h00000457 = new SPBridge.HMCaller();
      _h00000457.Set("m_cVQRList",m_cVQRList);
      _h00000457.Set("tbname","xperazbo");
      _h00000457.Set("fldname","IDBASE");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000457,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._xperazbo := qbe_tab_mmc->tot > 0 */
        rowTabelle._xperazbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* If rowTabelle._xperazbo */
      if (rowTabelle._xperazbo) {
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h0000045A;
        _h0000045A = new SPBridge.HMCaller();
        _h0000045A.Set("m_cVQRList",m_cVQRList);
        _h0000045A.Set("tbname","xlientiope");
        _h0000045A.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000045A,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._xlientiope := qbe_tab_mmc->tot > 0 */
          rowTabelle._xlientiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h0000045C;
        _h0000045C = new SPBridge.HMCaller();
        _h0000045C.Set("m_cVQRList",m_cVQRList);
        _h0000045C.Set("tbname","xogopebo");
        _h0000045C.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000045C,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._xogopebo := qbe_tab_mmc->tot > 0 */
          rowTabelle._xogopebo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h0000045E;
        _h0000045E = new SPBridge.HMCaller();
        _h0000045E.Set("m_cVQRList",m_cVQRList);
        _h0000045E.Set("tbname","xeneficope");
        _h0000045E.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000045E,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._xeneficope := qbe_tab_mmc->tot > 0 */
          rowTabelle._xeneficope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h00000460;
        _h00000460 = new SPBridge.HMCaller();
        _h00000460.Set("m_cVQRList",m_cVQRList);
        _h00000460.Set("tbname","xerzistiope");
        _h00000460.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000460,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._xerzistiope := qbe_tab_mmc->tot > 0 */
          rowTabelle._xerzistiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
      } // End If
      /* rowTabelle._xlientifrz := False */
      rowTabelle._xlientifrz = false;
      /* rowTabelle._xogopefbo := False */
      rowTabelle._xogopefbo = false;
      /* rowTabelle._xeneficfrz := False */
      rowTabelle._xeneficfrz = false;
      /* rowTabelle._xerzistifrz := False */
      rowTabelle._xerzistifrz = false;
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000466;
      _h00000466 = new SPBridge.HMCaller();
      _h00000466.Set("m_cVQRList",m_cVQRList);
      _h00000466.Set("tbname","xraziobo");
      _h00000466.Set("fldname","IDBASE");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000466,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._xraziobo := qbe_tab_mmc->tot > 0 */
        rowTabelle._xraziobo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* If rowTabelle._xraziobo */
      if (rowTabelle._xraziobo) {
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h00000469;
        _h00000469 = new SPBridge.HMCaller();
        _h00000469.Set("m_cVQRList",m_cVQRList);
        _h00000469.Set("tbname","xlientifrz");
        _h00000469.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000469,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._xlientifrz := qbe_tab_mmc->tot > 0 */
          rowTabelle._xlientifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h0000046B;
        _h0000046B = new SPBridge.HMCaller();
        _h0000046B.Set("m_cVQRList",m_cVQRList);
        _h0000046B.Set("tbname","xogopefbo");
        _h0000046B.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000046B,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._xogopefbo := qbe_tab_mmc->tot > 0 */
          rowTabelle._xogopefbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h0000046D;
        _h0000046D = new SPBridge.HMCaller();
        _h0000046D.Set("m_cVQRList",m_cVQRList);
        _h0000046D.Set("tbname","xeneficfrz");
        _h0000046D.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000046D,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._xeneficfrz := qbe_tab_mmc->tot > 0 */
          rowTabelle._xeneficfrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h0000046F;
        _h0000046F = new SPBridge.HMCaller();
        _h0000046F.Set("m_cVQRList",m_cVQRList);
        _h0000046F.Set("tbname","xerzistifrz");
        _h0000046F.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000046F,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._xerzistifrz := qbe_tab_mmc->tot > 0 */
          rowTabelle._xerzistifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
      } // End If
      /* rowTabelle._soginfo := False */
      rowTabelle._soginfo = false;
      /* rowTabelle._intestbo := False */
      rowTabelle._intestbo = false;
      /* rowTabelle._delegabo := False */
      rowTabelle._delegabo = false;
      /* rowTabelle._fiduciabo := False */
      rowTabelle._fiduciabo = false;
      /* rowTabelle._garantbo := False */
      rowTabelle._garantbo = false;
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000477;
      _h00000477 = new SPBridge.HMCaller();
      _h00000477.Set("m_cVQRList",m_cVQRList);
      _h00000477.Set("tbname","rapopebo");
      _h00000477.Set("fldname","IDBASE");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000477,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._rapopebo := qbe_tab_mmc->tot > 0 */
        rowTabelle._rapopebo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* If rowTabelle._rapopebo */
      if (rowTabelle._rapopebo) {
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h0000047A;
        _h0000047A = new SPBridge.HMCaller();
        _h0000047A.Set("m_cVQRList",m_cVQRList);
        _h0000047A.Set("tbname","soginfo");
        _h0000047A.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000047A,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._soginfo := qbe_tab_mmc->tot > 0 */
          rowTabelle._soginfo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h0000047C;
        _h0000047C = new SPBridge.HMCaller();
        _h0000047C.Set("m_cVQRList",m_cVQRList);
        _h0000047C.Set("tbname","intestbo");
        _h0000047C.Set("fldname","RAPPORTO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000047C,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._intestbo := qbe_tab_mmc->tot > 0 */
          rowTabelle._intestbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h0000047E;
        _h0000047E = new SPBridge.HMCaller();
        _h0000047E.Set("m_cVQRList",m_cVQRList);
        _h0000047E.Set("tbname","delegabo");
        _h0000047E.Set("fldname","RAPPORTO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000047E,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._delegabo := qbe_tab_mmc->tot > 0 */
          rowTabelle._delegabo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h00000480;
        _h00000480 = new SPBridge.HMCaller();
        _h00000480.Set("m_cVQRList",m_cVQRList);
        _h00000480.Set("tbname","fiduciabo");
        _h00000480.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000480,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._fiduciabo := qbe_tab_mmc->tot > 0 */
          rowTabelle._fiduciabo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h00000482;
        _h00000482 = new SPBridge.HMCaller();
        _h00000482.Set("m_cVQRList",m_cVQRList);
        _h00000482.Set("tbname","garantbo");
        _h00000482.Set("fldname","RAPPORTO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000482,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._garantbo := qbe_tab_mmc->tot > 0 */
          rowTabelle._garantbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
      } // End If
      /* rowTabelle._xoginfo := False */
      rowTabelle._xoginfo = false;
      /* rowTabelle._xntestbo := False */
      rowTabelle._xntestbo = false;
      /* rowTabelle._xelegabo := False */
      rowTabelle._xelegabo = false;
      /* rowTabelle._xiduciabo := False */
      rowTabelle._xiduciabo = false;
      /* rowTabelle._xarantbo := False */
      rowTabelle._xarantbo = false;
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000048A;
      _h0000048A = new SPBridge.HMCaller();
      _h0000048A.Set("m_cVQRList",m_cVQRList);
      _h0000048A.Set("tbname","xapopebo");
      _h0000048A.Set("fldname","IDBASE");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000048A,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._xapopebo := qbe_tab_mmc->tot > 0 */
        rowTabelle._xapopebo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* If rowTabelle._xapopebo */
      if (rowTabelle._xapopebo) {
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h0000048D;
        _h0000048D = new SPBridge.HMCaller();
        _h0000048D.Set("m_cVQRList",m_cVQRList);
        _h0000048D.Set("tbname","xoginfo");
        _h0000048D.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000048D,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._xoginfo := qbe_tab_mmc->tot > 0 */
          rowTabelle._xoginfo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h0000048F;
        _h0000048F = new SPBridge.HMCaller();
        _h0000048F.Set("m_cVQRList",m_cVQRList);
        _h0000048F.Set("tbname","xntestbo");
        _h0000048F.Set("fldname","RAPPORTO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000048F,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._xntestbo := qbe_tab_mmc->tot > 0 */
          rowTabelle._xntestbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h00000491;
        _h00000491 = new SPBridge.HMCaller();
        _h00000491.Set("m_cVQRList",m_cVQRList);
        _h00000491.Set("tbname","xelegabo");
        _h00000491.Set("fldname","RAPPORTO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000491,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._xelegabo := qbe_tab_mmc->tot > 0 */
          rowTabelle._xelegabo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h00000493;
        _h00000493 = new SPBridge.HMCaller();
        _h00000493.Set("m_cVQRList",m_cVQRList);
        _h00000493.Set("tbname","xiduciabo");
        _h00000493.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000493,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._xiduciabo := qbe_tab_mmc->tot > 0 */
          rowTabelle._xiduciabo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h00000495;
        _h00000495 = new SPBridge.HMCaller();
        _h00000495.Set("m_cVQRList",m_cVQRList);
        _h00000495.Set("tbname","xarantbo");
        _h00000495.Set("fldname","RAPPORTO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000495,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._xarantbo := qbe_tab_mmc->tot > 0 */
          rowTabelle._xarantbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
      } // End If
      /* rowTabelle._intestit := False */
      rowTabelle._intestit = false;
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000499;
      _h00000499 = new SPBridge.HMCaller();
      _h00000499.Set("m_cVQRList",m_cVQRList);
      _h00000499.Set("tbname","rapotit");
      _h00000499.Set("fldname","IDBASE");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000499,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._rapotit := qbe_tab_mmc->tot > 0 */
        rowTabelle._rapotit = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* If rowTabelle._rapotit */
      if (rowTabelle._rapotit) {
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h0000049C;
        _h0000049C = new SPBridge.HMCaller();
        _h0000049C.Set("m_cVQRList",m_cVQRList);
        _h0000049C.Set("tbname","intestit");
        _h0000049C.Set("fldname","CODCLI");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000049C,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._intestit := qbe_tab_mmc->tot > 0 */
          rowTabelle._intestit = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
      } // End If
      /* rowTabelle._xntestit := False */
      rowTabelle._xntestit = false;
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h000004A0;
      _h000004A0 = new SPBridge.HMCaller();
      _h000004A0.Set("m_cVQRList",m_cVQRList);
      _h000004A0.Set("tbname","xapotit");
      _h000004A0.Set("fldname","IDBASE");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004A0,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._xapotit := qbe_tab_mmc->tot > 0 */
        rowTabelle._xapotit = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* If rowTabelle._xapotit */
      if (rowTabelle._xapotit) {
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000004A3;
        _h000004A3 = new SPBridge.HMCaller();
        _h000004A3.Set("m_cVQRList",m_cVQRList);
        _h000004A3.Set("tbname","xntestit");
        _h000004A3.Set("fldname","CODCLI");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004A3,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._xntestit := qbe_tab_mmc->tot > 0 */
          rowTabelle._xntestit = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
      } // End If
      /* rowTabelle._jntestbo := False */
      rowTabelle._jntestbo = false;
      /* rowTabelle._jelegabo := False */
      rowTabelle._jelegabo = false;
      /* rowTabelle._jarantbo := False */
      rowTabelle._jarantbo = false;
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h000004A9;
      _h000004A9 = new SPBridge.HMCaller();
      _h000004A9.Set("m_cVQRList",m_cVQRList);
      _h000004A9.Set("tbname","japopebo");
      _h000004A9.Set("fldname","IDBASE");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004A9,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._japopebo := qbe_tab_mmc->tot > 0 */
        rowTabelle._japopebo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* If rowTabelle._japopebo */
      if (rowTabelle._japopebo) {
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000004AC;
        _h000004AC = new SPBridge.HMCaller();
        _h000004AC.Set("m_cVQRList",m_cVQRList);
        _h000004AC.Set("tbname","jntestbo");
        _h000004AC.Set("fldname","RAPPORTO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004AC,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._jntestbo := qbe_tab_mmc->tot > 0 */
          rowTabelle._jntestbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000004AE;
        _h000004AE = new SPBridge.HMCaller();
        _h000004AE.Set("m_cVQRList",m_cVQRList);
        _h000004AE.Set("tbname","jelegabo");
        _h000004AE.Set("fldname","RAPPORTO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004AE,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._jelegabo := qbe_tab_mmc->tot > 0 */
          rowTabelle._jelegabo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000004B0;
        _h000004B0 = new SPBridge.HMCaller();
        _h000004B0.Set("m_cVQRList",m_cVQRList);
        _h000004B0.Set("tbname","jarantbo");
        _h000004B0.Set("fldname","RAPPORTO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004B0,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._jarantbo := qbe_tab_mmc->tot > 0 */
          rowTabelle._jarantbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
      } // End If
      /* rowTabelle._jntestit := False */
      rowTabelle._jntestit = false;
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h000004B4;
      _h000004B4 = new SPBridge.HMCaller();
      _h000004B4.Set("m_cVQRList",m_cVQRList);
      _h000004B4.Set("tbname","japotit");
      _h000004B4.Set("fldname","IDBASE");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004B4,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._japotit := qbe_tab_mmc->tot > 0 */
        rowTabelle._japotit = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* If rowTabelle._japotit */
      if (rowTabelle._japotit) {
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000004B7;
        _h000004B7 = new SPBridge.HMCaller();
        _h000004B7.Set("m_cVQRList",m_cVQRList);
        _h000004B7.Set("tbname","jntestit");
        _h000004B7.Set("fldname","CODCLI");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004B7,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._jntestit := qbe_tab_mmc->tot > 0 */
          rowTabelle._jntestit = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
      } // End If
      /* rowTabelle._kperazbo := False */
      rowTabelle._kperazbo = false;
      /* rowTabelle._jperazbo := False */
      rowTabelle._jperazbo = false;
      /* rowTabelle._opextrbo := False */
      rowTabelle._opextrbo = false;
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h000004BD;
      _h000004BD = new SPBridge.HMCaller();
      _h000004BD.Set("m_cVQRList",m_cVQRList);
      _h000004BD.Set("tbname","kperazbo");
      _h000004BD.Set("fldname","IDBASE");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004BD,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._kperazbo := qbe_tab_mmc->tot > 0 */
        rowTabelle._kperazbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h000004BF;
      _h000004BF = new SPBridge.HMCaller();
      _h000004BF.Set("m_cVQRList",m_cVQRList);
      _h000004BF.Set("tbname","jperazbo");
      _h000004BF.Set("fldname","IDBASE");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004BF,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._jperazbo := qbe_tab_mmc->tot > 0 */
        rowTabelle._jperazbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h000004C1;
      _h000004C1 = new SPBridge.HMCaller();
      _h000004C1.Set("m_cVQRList",m_cVQRList);
      _h000004C1.Set("tbname","opextrbo");
      _h000004C1.Set("fldname","COLLEG");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004C1,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._opextrbo := qbe_tab_mmc->tot > 0 */
        rowTabelle._opextrbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* rowTabelle._wlientiope := False */
      rowTabelle._wlientiope = false;
      /* rowTabelle._wogopebo := False */
      rowTabelle._wogopebo = false;
      /* rowTabelle._weneficope := False */
      rowTabelle._weneficope = false;
      /* rowTabelle._werzistiope := False */
      rowTabelle._werzistiope = false;
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h000004C9;
      _h000004C9 = new SPBridge.HMCaller();
      _h000004C9.Set("m_cVQRList",m_cVQRList);
      _h000004C9.Set("tbname","wperazbo");
      _h000004C9.Set("fldname","IDBASE");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004C9,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._wperazbo := qbe_tab_mmc->tot > 0 */
        rowTabelle._wperazbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* If rowTabelle._wperazbo */
      if (rowTabelle._wperazbo) {
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000004CC;
        _h000004CC = new SPBridge.HMCaller();
        _h000004CC.Set("m_cVQRList",m_cVQRList);
        _h000004CC.Set("tbname","wlientiope");
        _h000004CC.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004CC,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._wlientiope := qbe_tab_mmc->tot > 0 */
          rowTabelle._wlientiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000004CE;
        _h000004CE = new SPBridge.HMCaller();
        _h000004CE.Set("m_cVQRList",m_cVQRList);
        _h000004CE.Set("tbname","wogopebo");
        _h000004CE.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004CE,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._wogopebo := qbe_tab_mmc->tot > 0 */
          rowTabelle._wogopebo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000004D0;
        _h000004D0 = new SPBridge.HMCaller();
        _h000004D0.Set("m_cVQRList",m_cVQRList);
        _h000004D0.Set("tbname","weneficope");
        _h000004D0.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004D0,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._weneficope := qbe_tab_mmc->tot > 0 */
          rowTabelle._weneficope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000004D2;
        _h000004D2 = new SPBridge.HMCaller();
        _h000004D2.Set("m_cVQRList",m_cVQRList);
        _h000004D2.Set("tbname","werzistiope");
        _h000004D2.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004D2,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._werzistiope := qbe_tab_mmc->tot > 0 */
          rowTabelle._werzistiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
      } // End If
      /* rowTabelle._wlientifrz := False */
      rowTabelle._wlientifrz = false;
      /* rowTabelle._wogopefbo := False */
      rowTabelle._wogopefbo = false;
      /* rowTabelle._weneficfrz := False */
      rowTabelle._weneficfrz = false;
      /* rowTabelle._werzistifrz := False */
      rowTabelle._werzistifrz = false;
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h000004D9;
      _h000004D9 = new SPBridge.HMCaller();
      _h000004D9.Set("m_cVQRList",m_cVQRList);
      _h000004D9.Set("tbname","wraziobo");
      _h000004D9.Set("fldname","IDBASE");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004D9,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._wraziobo := qbe_tab_mmc->tot > 0 */
        rowTabelle._wraziobo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* If rowTabelle._wraziobo */
      if (rowTabelle._wraziobo) {
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000004DC;
        _h000004DC = new SPBridge.HMCaller();
        _h000004DC.Set("m_cVQRList",m_cVQRList);
        _h000004DC.Set("tbname","wlientifrz");
        _h000004DC.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004DC,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._wlientifrz := qbe_tab_mmc->tot > 0 */
          rowTabelle._wlientifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000004DE;
        _h000004DE = new SPBridge.HMCaller();
        _h000004DE.Set("m_cVQRList",m_cVQRList);
        _h000004DE.Set("tbname","wogopefbo");
        _h000004DE.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004DE,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._xogopefbo := qbe_tab_mmc->tot > 0 */
          rowTabelle._xogopefbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000004E0;
        _h000004E0 = new SPBridge.HMCaller();
        _h000004E0.Set("m_cVQRList",m_cVQRList);
        _h000004E0.Set("tbname","weneficfrz");
        _h000004E0.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004E0,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._weneficfrz := qbe_tab_mmc->tot > 0 */
          rowTabelle._weneficfrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000004E2;
        _h000004E2 = new SPBridge.HMCaller();
        _h000004E2.Set("m_cVQRList",m_cVQRList);
        _h000004E2.Set("tbname","werzistifrz");
        _h000004E2.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004E2,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._werzistifrz := qbe_tab_mmc->tot > 0 */
          rowTabelle._werzistifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
      } // End If
      /* rowTabelle._woginfo := False */
      rowTabelle._woginfo = false;
      /* rowTabelle._wntestbo := False */
      rowTabelle._wntestbo = false;
      /* rowTabelle._welegabo := False */
      rowTabelle._welegabo = false;
      /* rowTabelle._widuciabo := False */
      rowTabelle._widuciabo = false;
      /* rowTabelle._warantbo := False */
      rowTabelle._warantbo = false;
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h000004EA;
      _h000004EA = new SPBridge.HMCaller();
      _h000004EA.Set("m_cVQRList",m_cVQRList);
      _h000004EA.Set("tbname","wapopebo");
      _h000004EA.Set("fldname","IDBASE");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004EA,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* rowTabelle._wapopebo := qbe_tab_mmc->tot > 0 */
        rowTabelle._wapopebo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* If rowTabelle._wapopebo */
      if (rowTabelle._wapopebo) {
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000004ED;
        _h000004ED = new SPBridge.HMCaller();
        _h000004ED.Set("m_cVQRList",m_cVQRList);
        _h000004ED.Set("tbname","woginfo");
        _h000004ED.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004ED,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._woginfo := qbe_tab_mmc->tot > 0 */
          rowTabelle._woginfo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000004EF;
        _h000004EF = new SPBridge.HMCaller();
        _h000004EF.Set("m_cVQRList",m_cVQRList);
        _h000004EF.Set("tbname","wntestbo");
        _h000004EF.Set("fldname","RAPPORTO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004EF,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._wntestbo := qbe_tab_mmc->tot > 0 */
          rowTabelle._wntestbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000004F1;
        _h000004F1 = new SPBridge.HMCaller();
        _h000004F1.Set("m_cVQRList",m_cVQRList);
        _h000004F1.Set("tbname","welegabo");
        _h000004F1.Set("fldname","RAPPORTO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004F1,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._welegabo := qbe_tab_mmc->tot > 0 */
          rowTabelle._welegabo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000004F3;
        _h000004F3 = new SPBridge.HMCaller();
        _h000004F3.Set("m_cVQRList",m_cVQRList);
        _h000004F3.Set("tbname","widuciabo");
        _h000004F3.Set("fldname","IDFILEBO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004F3,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._widuciabo := qbe_tab_mmc->tot > 0 */
          rowTabelle._widuciabo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h000004F5;
        _h000004F5 = new SPBridge.HMCaller();
        _h000004F5.Set("m_cVQRList",m_cVQRList);
        _h000004F5.Set("tbname","warantbo");
        _h000004F5.Set("fldname","RAPPORTO");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000004F5,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* rowTabelle._warantbo := qbe_tab_mmc->tot > 0 */
          rowTabelle._warantbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
      } // End If
    } finally {
      try {
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void ope_age() throws Exception {
    CPResultSet Cursor_jperazbo=null;
    CPResultSet Cursor_hperazbo=null;
    CPResultSet Cursor_qbe_storope_age=null;
    CPResultSet Cursor_jogopebo=null;
    CPResultSet Cursor_qbe_storhpe=null;
    CPResultSet Cursor_hogopebo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _stringa_appoggio := " operazioni age" */
      _stringa_appoggio = " operazioni age";
      /* _dataoggi := _ddatini */
      _dataoggi = _ddatini;
      /* _cdataoggi := _cdatini */
      _cdataoggi = _cdatini;
      /* _oldmsg := '' */
      _oldmsg = "";
      /* _contarow := 0 */
      _contarow = CPLib.Round(0,0);
      /* _contaop := 0 */
      _contaop = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry000004FEstatus;
      nTry000004FEstatus = m_Sql.GetTransactionStatus();
      String cTry000004FEmsg;
      cTry000004FEmsg = m_Sql.TransactionErrorMessage();
      try {
        /* If At(w_stampa,"|R|S") > 0 */
        if (CPLib.gt(CPLib.At(w_stampa,"|R|S"),0)) {
          /* gMsgProc := gMsgProc + 'Precaricamento delle'+_stringa_appoggio+' per la stampa'+NL // Messaggio */
          gMsgProc = gMsgProc+"Precaricamento delle"+_stringa_appoggio+" per la stampa"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* Case w_chi_chiama_la_routine="AUI" */
          if (CPLib.eqr(w_chi_chiama_la_routine,"AUI")) {
            // * --- Select from jperazbo
            m_cServer = m_Ctx.GetServer("jperazbo");
            m_cPhName = m_Ctx.GetPhName("jperazbo");
            if (Cursor_jperazbo!=null)
              Cursor_jperazbo.Close();
            Cursor_jperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CDATREG>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatini)+"  and  CDATREG<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatfin)+" "+")"+(m_Ctx.IsSharedTemp("jperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_jperazbo.Eof())) {
              /* _mc_operazioni.AppendBlank() // Stampa operazioni */
              _mc_operazioni.AppendBlank();
              /* _mc_operazioni.DATAOPE := jperazbo->DATAOPE // Stampa operazioni */
              _mc_operazioni.row.DATAOPE = Cursor_jperazbo.GetDate("DATAOPE");
              /* _mc_operazioni.NUMPROG := jperazbo->NUMPROG // Stampa operazioni */
              _mc_operazioni.row.NUMPROG = Cursor_jperazbo.GetString("NUMPROG");
              /* _mc_operazioni.DATAREG := jperazbo->DATAREG // Stampa operazioni */
              _mc_operazioni.row.DATAREG = Cursor_jperazbo.GetDate("DATAREG");
              /* _mc_operazioni.CAUSALE := jperazbo->CODANA // Stampa operazioni */
              _mc_operazioni.row.CAUSALE = Cursor_jperazbo.GetString("CODANA");
              /* _mc_operazioni.IMPORTO := jperazbo->TOTLIRE // Stampa operazioni */
              _mc_operazioni.row.IMPORTO = Cursor_jperazbo.GetDouble("TOTLIRE");
              /* _mc_operazioni.VALUTA := jperazbo->VALUTA // Stampa operazioni */
              _mc_operazioni.row.VALUTA = Cursor_jperazbo.GetString("VALUTA");
              /* _mc_operazioni.CONNESCLI := jperazbo->CONNESCLI // Stampa operazioni */
              _mc_operazioni.row.CONNESCLI = Cursor_jperazbo.GetString("CONNESCLI");
              /* _mc_operazioni.DESCRI := jperazbo->RAPPORTO // Stampa operazioni */
              _mc_operazioni.row.DESCRI = Cursor_jperazbo.GetString("RAPPORTO");
              /* _mc_operazioni.STATOREG := jperazbo->STATOREG // Stampa operazioni */
              _mc_operazioni.row.STATOREG = Cursor_jperazbo.GetString("STATOREG");
              /* _mc_operazioni.TIPOARCH := 'E' // Stampa operazioni */
              _mc_operazioni.row.TIPOARCH = "E";
              /* _mc_operazioni.SaveRow() // Stampa operazioni */
              _mc_operazioni.SaveRow();
              Cursor_jperazbo.Next();
            }
            m_cConnectivityError = Cursor_jperazbo.ErrorMessage();
            Cursor_jperazbo.Close();
            // * --- End Select
            /* Case w_chi_chiama_la_routine="STO" */
          } else if (CPLib.eqr(w_chi_chiama_la_routine,"STO")) {
            // * --- Select from hperazbo
            m_cServer = m_Ctx.GetServer("hperazbo");
            m_cPhName = m_Ctx.GetPhName("hperazbo");
            if (Cursor_hperazbo!=null)
              Cursor_hperazbo.Close();
            Cursor_hperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CDATREG>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatini)+"  and  CDATREG<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_cdatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_cdatfin)+" "+")"+(m_Ctx.IsSharedTemp("hperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_hperazbo.Eof())) {
              /* _mc_operazioni.AppendBlank() // Stampa operazioni */
              _mc_operazioni.AppendBlank();
              /* _mc_operazioni.DATAOPE := hperazbo->DATAOPE // Stampa operazioni */
              _mc_operazioni.row.DATAOPE = Cursor_hperazbo.GetDate("DATAOPE");
              /* _mc_operazioni.NUMPROG := hperazbo->NUMPROG // Stampa operazioni */
              _mc_operazioni.row.NUMPROG = Cursor_hperazbo.GetString("NUMPROG");
              /* _mc_operazioni.DATAREG := hperazbo->DATAREG // Stampa operazioni */
              _mc_operazioni.row.DATAREG = Cursor_hperazbo.GetDate("DATAREG");
              /* _mc_operazioni.CAUSALE := hperazbo->CODANA // Stampa operazioni */
              _mc_operazioni.row.CAUSALE = Cursor_hperazbo.GetString("CODANA");
              /* _mc_operazioni.IMPORTO := hperazbo->TOTLIRE // Stampa operazioni */
              _mc_operazioni.row.IMPORTO = Cursor_hperazbo.GetDouble("TOTLIRE");
              /* _mc_operazioni.VALUTA := hperazbo->VALUTA // Stampa operazioni */
              _mc_operazioni.row.VALUTA = Cursor_hperazbo.GetString("VALUTA");
              /* _mc_operazioni.CONNESCLI := hperazbo->CONNESCLI // Stampa operazioni */
              _mc_operazioni.row.CONNESCLI = Cursor_hperazbo.GetString("CONNESCLI");
              /* _mc_operazioni.DESCRI := hperazbo->RAPPORTO // Stampa operazioni */
              _mc_operazioni.row.DESCRI = Cursor_hperazbo.GetString("RAPPORTO");
              /* _mc_operazioni.STATOREG := hperazbo->STATOREG // Stampa operazioni */
              _mc_operazioni.row.STATOREG = Cursor_hperazbo.GetString("STATOREG");
              /* _mc_operazioni.TIPOARCH := 'E' // Stampa operazioni */
              _mc_operazioni.row.TIPOARCH = "E";
              /* _mc_operazioni.SaveRow() // Stampa operazioni */
              _mc_operazioni.SaveRow();
              Cursor_hperazbo.Next();
            }
            m_cConnectivityError = Cursor_hperazbo.ErrorMessage();
            Cursor_hperazbo.Close();
            // * --- End Select
          } // End Case
          /* gMsgProc := gMsgProc + 'Fine precaricamento per la stampa'+NL // Messaggio */
          gMsgProc = gMsgProc+"Fine precaricamento per la stampa"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* If False */
          if (false) {
            /* gMsgProc := gMsgProc + 'mcOPE:'+_mc_operazioni.RecCount()+NL +'mcFRZ:'+_mc_frazionate.RecCount()+NL // Messaggio */
            gMsgProc = gMsgProc+"mcOPE:"+_mc_operazioni.RecCount()+"\n"+"mcFRZ:"+_mc_frazionate.RecCount()+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
        } // End If
        /* While _dataoggi <= _ddatfin */
        while (CPLib.le(_dataoggi,_ddatfin)) {
          /* If Empty(_oldmsg) */
          if (CPLib.Empty(_oldmsg)) {
            /* gMsgProc := gMsgProc + 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) +_stringa_appoggio // Messaggio */
            gMsgProc = gMsgProc+"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+_stringa_appoggio;
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) +_stringa_appoggio) // Messaggio */
            gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+_stringa_appoggio);
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* _oldmsg := 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) +_stringa_appoggio */
          _oldmsg = "Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+_stringa_appoggio;
          /* If w_chi_chiama_la_routine='AUI' */
          if (CPLib.eqr(w_chi_chiama_la_routine,"AUI")) {
            // * --- Select from qbe_storope_age
            SPBridge.HMCaller _h00000526;
            _h00000526 = new SPBridge.HMCaller();
            _h00000526.Set("m_cVQRList",m_cVQRList);
            _h00000526.Set("data_oggi",_cdataoggi);
            if (Cursor_qbe_storope_age!=null)
              Cursor_qbe_storope_age.Close();
            Cursor_qbe_storope_age = new VQRHolder("qbe_storope_age",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000526,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_storope_age.Eof())) {
              /* _contaop := _contaop + 1 */
              _contaop = CPLib.Round(_contaop+1,0);
              /* gMsgImp :=  iif(At(w_stampa,'|E|R') <> 0,"Elaborazione ",iif(w_tipoope='T','Storicizzazione ','Cancellazione '))+"dati dell'operazione con ID: "+qbe_storope_age->IDBASE */
              gMsgImp = (CPLib.ne(CPLib.At(w_stampa,"|E|R"),0)?"Elaborazione ":(CPLib.eqr(w_tipoope,"T")?"Storicizzazione ":"Cancellazione "))+"dati dell'operazione con ID: "+Cursor_qbe_storope_age.GetString("IDBASE");
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* If w_anag_colleg */
              if (w_anag_colleg) {
                /* Prendo i CONNES collegati all'operazione (CONNESCLI, CONNESOPER,CONNESBEN,CONNALTRO) */
                /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storope_age->CONNESCLI) */
                add_sogg_mc(Cursor_qbe_storope_age.GetString("CONNESCLI"));
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storope_age->CONNESOPER) */
                add_sogg_mc(Cursor_qbe_storope_age.GetString("CONNESOPER"));
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storope_age->CONNESBEN) */
                add_sogg_mc(Cursor_qbe_storope_age.GetString("CONNESBEN"));
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storope_age->CONNALTRO) */
                add_sogg_mc(Cursor_qbe_storope_age.GetString("CONNALTRO"));
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
              } // End If
              /* If w_tipoope = 'T' and (Empty(w_stampa) or w_stampa='S') */
              if (CPLib.eqr(w_tipoope,"T") && (CPLib.Empty(w_stampa) || CPLib.eqr(w_stampa,"S"))) {
                // * --- Select from jperazbo
                m_cServer = m_Ctx.GetServer("jperazbo");
                m_cPhName = m_Ctx.GetPhName("jperazbo");
                if (Cursor_jperazbo!=null)
                  Cursor_jperazbo.Close();
                Cursor_jperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE = "+CPLib.ToSQL(Cursor_qbe_storope_age.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_jperazbo.Eof())) {
                  // * --- Insert into hperazbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("hperazbo");
                  m_cPhName = m_Ctx.GetPhName("hperazbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"hperazbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000533")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000533(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDouble("ANNOOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDouble("CAMBIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDate("DATAIMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDate("DATAOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDate("DATAREG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDate("DATARETT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("IDBASE2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDouble("IMPIN"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDouble("IMPOUT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("MTCN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDouble("NOPROT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDouble("RAREA"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDouble("RCOMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDouble("RFREQ"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDouble("RIMP"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDouble("RTIPO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jperazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"hperazbo",true);
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
                  Cursor_jperazbo.Next();
                }
                m_cConnectivityError = Cursor_jperazbo.ErrorMessage();
                Cursor_jperazbo.Close();
                // * --- End Select
                // * --- Select from jogopebo
                m_cServer = m_Ctx.GetServer("jogopebo");
                m_cPhName = m_Ctx.GetPhName("jogopebo");
                if (Cursor_jogopebo!=null)
                  Cursor_jogopebo.Close();
                Cursor_jogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_storope_age.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_jogopebo.Eof())) {
                  // * --- Insert into hogopebo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("hogopebo");
                  m_cPhName = m_Ctx.GetPhName("hogopebo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"hogopebo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000535")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000535(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jogopebo.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jogopebo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jogopebo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jogopebo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jogopebo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jogopebo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jogopebo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jogopebo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"hogopebo",true);
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
                  /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(jogopebo->CODSOG) */
                  add_sogg_mc(Cursor_jogopebo.GetString("CODSOG"));
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  /* If At(w_stampa,'|E|S') <> 0 */
                  if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                    // * --- Delete from jogopebo
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("jogopebo");
                    m_cPhName = m_Ctx.GetPhName("jogopebo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jogopebo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000538")+"delete from "+m_oWrInfo.GetTableWriteName();
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storope_age.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storope_age.GetString("IDBASE"))+"";
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
                  Cursor_jogopebo.Next();
                }
                m_cConnectivityError = Cursor_jogopebo.ErrorMessage();
                Cursor_jogopebo.Close();
                // * --- End Select
              } // End If
              /* If At(w_stampa,'|E|S') <> 0 */
              if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                // * --- Delete from jperazbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("jperazbo");
                m_cPhName = m_Ctx.GetPhName("jperazbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jperazbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000053A")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storope_age.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storope_age.GetString("IDBASE"))+"";
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
              Cursor_qbe_storope_age.Next();
            }
            m_cConnectivityError = Cursor_qbe_storope_age.ErrorMessage();
            Cursor_qbe_storope_age.Close();
            // * --- End Select
            /* ElseIf w_chi_chiama_la_routine='STO' */
          } else if (CPLib.eqr(w_chi_chiama_la_routine,"STO")) {
            // * --- Select from qbe_storhpe
            SPBridge.HMCaller _h0000053B;
            _h0000053B = new SPBridge.HMCaller();
            _h0000053B.Set("m_cVQRList",m_cVQRList);
            _h0000053B.Set("data_oggi",_cdataoggi);
            if (Cursor_qbe_storhpe!=null)
              Cursor_qbe_storhpe.Close();
            Cursor_qbe_storhpe = new VQRHolder("qbe_storhpe",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000053B,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_storhpe.Eof())) {
              /* _contaop := _contaop + 1 */
              _contaop = CPLib.Round(_contaop+1,0);
              /* gMsgImp :=  iif(At(w_stampa,'|E|R') <> 0,"Elaborazione ","Cancellazione ")+"dati storici dell'operazione con ID: "+qbe_storhpe->IDBASE */
              gMsgImp = (CPLib.ne(CPLib.At(w_stampa,"|E|R"),0)?"Elaborazione ":"Cancellazione ")+"dati storici dell'operazione con ID: "+Cursor_qbe_storhpe.GetString("IDBASE");
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* If w_anag_colleg */
              if (w_anag_colleg) {
                /* Prendo i CONNES collegati all'operazione (CONNESCLI, CONNESOPER,CONNESBEN,CONNALTRO) */
                /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storhpe->CONNESCLI) */
                add_sogg_mc(Cursor_qbe_storhpe.GetString("CONNESCLI"));
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storhpe->CONNESOPER) */
                add_sogg_mc(Cursor_qbe_storhpe.GetString("CONNESOPER"));
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storhpe->CONNESBEN) */
                add_sogg_mc(Cursor_qbe_storhpe.GetString("CONNESBEN"));
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(qbe_storhpe->CONNALTRO) */
                add_sogg_mc(Cursor_qbe_storhpe.GetString("CONNALTRO"));
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
                // * --- Select from hogopebo
                m_cServer = m_Ctx.GetServer("hogopebo");
                m_cPhName = m_Ctx.GetPhName("hogopebo");
                if (Cursor_hogopebo!=null)
                  Cursor_hogopebo.Close();
                Cursor_hogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_qbe_storhpe.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("hogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_hogopebo.Eof())) {
                  /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(hogopebo->CODSOG) */
                  add_sogg_mc(Cursor_hogopebo.GetString("CODSOG"));
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                  Cursor_hogopebo.Next();
                }
                m_cConnectivityError = Cursor_hogopebo.ErrorMessage();
                Cursor_hogopebo.Close();
                // * --- End Select
              } // End If
              /* If At(w_stampa,'|E|S') <> 0 */
              if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                // * --- Delete from hogopebo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("hogopebo");
                m_cPhName = m_Ctx.GetPhName("hogopebo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"hogopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000548")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storhpe.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storhpe.GetString("IDBASE"))+"";
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
                // * --- Delete from hperazbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("hperazbo");
                m_cPhName = m_Ctx.GetPhName("hperazbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"hperazbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000549")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storhpe.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storhpe.GetString("IDBASE"))+"";
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
              Cursor_qbe_storhpe.Next();
            }
            m_cConnectivityError = Cursor_qbe_storhpe.ErrorMessage();
            Cursor_qbe_storhpe.Close();
            // * --- End Select
          } // End If
          /* _dataoggi := arfn_datesum(_dataoggi,1) */
          _dataoggi = arfn_datesumR.Make(m_Ctx,this).Run(_dataoggi,1);
          /* _cdataoggi := DateToChar(_dataoggi) */
          _cdataoggi = CPLib.DateToChar(_dataoggi);
        } // End While
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgProc := gMsgProc +NL+'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file'+_stringa_appoggio+NL */
        gMsgProc = gMsgProc+"\n"+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file"+_stringa_appoggio+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc +'Sono state '+ iif(w_tipoope='T','Trasferite ','Cancellate ')+LRTrim(Str(_contaop,10,0))+_stringa_appoggio+ NL */
        gMsgProc = gMsgProc+"Sono state "+(CPLib.eqr(w_tipoope,"T")?"Trasferite ":"Cancellate ")+CPLib.LRTrim(CPLib.Str(_contaop,10,0))+_stringa_appoggio+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgImp := "Errore di transazione, contattare l'assistenza" */
        gMsgImp = "Errore di transazione, contattare l'assistenza";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Return "KO" */
        throw new Stop("KO");
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000004FEstatus,0)) {
          m_Sql.SetTransactionStatus(nTry000004FEstatus,cTry000004FEmsg);
        }
      }
    } finally {
      try {
        if (Cursor_jperazbo!=null)
          Cursor_jperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_hperazbo!=null)
          Cursor_hperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_storope_age!=null)
          Cursor_qbe_storope_age.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jogopebo!=null)
          Cursor_jogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_storhpe!=null)
          Cursor_qbe_storhpe.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_hogopebo!=null)
          Cursor_hogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void rap_age() throws Exception {
    CPResultSet Cursor_qbe_storjap=null;
    CPResultSet Cursor_qbe_storwap=null;
    CPResultSet Cursor_qbe_storjap2=null;
    CPResultSet Cursor_jelegabo=null;
    CPResultSet Cursor_jarantbo=null;
    CPResultSet Cursor_jntestbo=null;
    CPResultSet Cursor_joginfo=null;
    CPResultSet Cursor_qbe_storjap1=null;
    CPResultSet Cursor_qbe_storwap2=null;
    CPResultSet Cursor_welegabo=null;
    CPResultSet Cursor_warantbo=null;
    CPResultSet Cursor_wntestbo=null;
    CPResultSet Cursor_woginfo=null;
    CPResultSet Cursor_wapopebo=null;
    CPResultSet Cursor_widuciabo=null;
    CPResultSet Cursor_qbe_storwap1=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _oldmsg := '' */
      _oldmsg = "";
      /* _contaop := 0 */
      _contaop = CPLib.Round(0,0);
      /* -- prendo solo i rapporti chiusi nel periodo (tipooprap = 6) */
      /* If At(w_stampa,"|R|S") > 0 */
      if (CPLib.gt(CPLib.At(w_stampa,"|R|S"),0)) {
        /* gMsgProc := gMsgProc + 'Precaricamento dei Rapporti per la stampa'+NL // Messaggio */
        gMsgProc = gMsgProc+"Precaricamento dei Rapporti per la stampa"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* Case w_chi_chiama_la_routine="AUI" */
        if (CPLib.eqr(w_chi_chiama_la_routine,"AUI")) {
          // * --- Fill memory cursor _mc_rapporti on qbe_storjap
          _mc_rapporti.Zap();
          SPBridge.HMCaller _h00000558;
          _h00000558 = new SPBridge.HMCaller();
          _h00000558.Set("m_cVQRList",m_cVQRList);
          _h00000558.Set("dadata",_ddatini);
          _h00000558.Set("adata",_ddatfin);
          if (Cursor_qbe_storjap!=null)
            Cursor_qbe_storjap.Close();
          Cursor_qbe_storjap = new VQRHolder("qbe_storjap",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000558,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_storjap;
            Cursor_qbe_storjap.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_stor_trasf: query on qbe_storjap returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_storjap.Eof())) {
            _mc_rapporti.AppendBlank();
            _mc_rapporti.row.RAPPORTO = Cursor_qbe_storjap.GetString("RAPPORTO");
            _mc_rapporti.row.DESCRAP = Cursor_qbe_storjap.GetString("DESCRAP");
            _mc_rapporti.row.TIPORAP = Cursor_qbe_storjap.GetString("TIPORAP");
            _mc_rapporti.row.FLAGLIRE = Cursor_qbe_storjap.GetString("FLAGLIRE");
            _mc_rapporti.row.VALUTA = Cursor_qbe_storjap.GetString("VALUTA");
            _mc_rapporti.row.CONTINUA = Cursor_qbe_storjap.GetString("CONTINUA");
            _mc_rapporti.row.TIPOAG = Cursor_qbe_storjap.GetString("TIPOAG");
            _mc_rapporti.row.DOCFILE = Cursor_qbe_storjap.GetString("DOCFILE");
            _mc_rapporti.row.NOPROT = Cursor_qbe_storjap.GetDouble("NOPROT");
            _mc_rapporti.row.TIPMOD = Cursor_qbe_storjap.GetString("TIPMOD");
            _mc_rapporti.row.DATAMOD = Cursor_qbe_storjap.GetDate("DATAMOD");
            _mc_rapporti.row.IDRAPPORTO = Cursor_qbe_storjap.GetString("IDRAPPORTO");
            _mc_rapporti.row.IDBASE = Cursor_qbe_storjap.GetString("IDBASE");
            _mc_rapporti.row.RAGIO = Cursor_qbe_storjap.GetString("RAGIO");
            _mc_rapporti.row.MODSVOL = Cursor_qbe_storjap.GetString("MODSVOL");
            _mc_rapporti.row.AREAGEO = Cursor_qbe_storjap.GetString("AREAGEO");
            _mc_rapporti.row.SCOPO = Cursor_qbe_storjap.GetString("SCOPO");
            _mc_rapporti.row.NATURA = Cursor_qbe_storjap.GetString("NATURA");
            _mc_rapporti.row.RTIPO = Cursor_qbe_storjap.GetDouble("RTIPO");
            _mc_rapporti.row.RCOMP = Cursor_qbe_storjap.GetDouble("RCOMP");
            _mc_rapporti.row.RIMP = Cursor_qbe_storjap.GetDouble("RIMP");
            _mc_rapporti.row.RFREQ = Cursor_qbe_storjap.GetDouble("RFREQ");
            _mc_rapporti.row.RRAGIO = Cursor_qbe_storjap.GetDouble("RRAGIO");
            _mc_rapporti.row.RAREA = Cursor_qbe_storjap.GetDouble("RAREA");
            _mc_rapporti.row.TIPO = Cursor_qbe_storjap.GetString("TIPO");
            _mc_rapporti.row.PRGIMPRAP = Cursor_qbe_storjap.GetDouble("PRGIMPRAP");
            _mc_rapporti.row.AMMONT = Cursor_qbe_storjap.GetString("AMMONT");
            _mc_rapporti.row.DURAT = Cursor_qbe_storjap.GetString("DURAT");
            _mc_rapporti.row.IMPAPE = Cursor_qbe_storjap.GetDouble("IMPAPE");
            _mc_rapporti.row.IMPCHIU = Cursor_qbe_storjap.GetDouble("IMPCHIU");
            _mc_rapporti.row.SPLITCODE = Cursor_qbe_storjap.GetString("SPLITCODE");
            _mc_rapporti.row.MACODICE = Cursor_qbe_storjap.GetString("MACODICE");
            _mc_rapporti.row.CODDIP = Cursor_qbe_storjap.GetString("CODDIP");
            _mc_rapporti.row.STATORAP = Cursor_qbe_storjap.GetString("STATORAP");
            _mc_rapporti.row.CASTATOC = Cursor_qbe_storjap.GetDouble("CASTATOC");
            _mc_rapporti.row.CASTATOM = Cursor_qbe_storjap.GetDouble("CASTATOM");
            _mc_rapporti.row.CODICELR = Cursor_qbe_storjap.GetString("CODICELR");
            _mc_rapporti.row.CADSTATO = Cursor_qbe_storjap.GetDate("CADSTATO");
            _mc_rapporti.row.MITIG = Cursor_qbe_storjap.GetDouble("MITIG");
            _mc_rapporti.row.MITGDOC = Cursor_qbe_storjap.GetString("MITGDOC");
            _mc_rapporti.row.DAC6 = Cursor_qbe_storjap.GetString("DAC6");
            _mc_rapporti.row.FLAGDAC6 = Cursor_qbe_storjap.GetDouble("FLAGDAC6");
            _mc_rapporti.row.IBAN = Cursor_qbe_storjap.GetString("IBAN");
            _mc_rapporti.row.CODOGG = Cursor_qbe_storjap.GetString("CODOGG");
            Cursor_qbe_storjap.Next();
          }
          m_cConnectivityError = Cursor_qbe_storjap.ErrorMessage();
          Cursor_qbe_storjap.Close();
          _mc_rapporti.GoTop();
          /* Case w_chi_chiama_la_routine="STO" */
        } else if (CPLib.eqr(w_chi_chiama_la_routine,"STO")) {
          // * --- Fill memory cursor _mc_rapporti on qbe_storwap
          _mc_rapporti.Zap();
          SPBridge.HMCaller _h00000559;
          _h00000559 = new SPBridge.HMCaller();
          _h00000559.Set("m_cVQRList",m_cVQRList);
          _h00000559.Set("dadata",_ddatini);
          _h00000559.Set("adata",_ddatfin);
          if (Cursor_qbe_storwap!=null)
            Cursor_qbe_storwap.Close();
          Cursor_qbe_storwap = new VQRHolder("qbe_storwap",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000559,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_storwap;
            Cursor_qbe_storwap.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_stor_trasf: query on qbe_storwap returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_storwap.Eof())) {
            _mc_rapporti.AppendBlank();
            _mc_rapporti.row.RAPPORTO = Cursor_qbe_storwap.GetString("RAPPORTO");
            _mc_rapporti.row.DESCRAP = Cursor_qbe_storwap.GetString("DESCRAP");
            _mc_rapporti.row.TIPORAP = Cursor_qbe_storwap.GetString("TIPORAP");
            _mc_rapporti.row.FLAGLIRE = Cursor_qbe_storwap.GetString("FLAGLIRE");
            _mc_rapporti.row.VALUTA = Cursor_qbe_storwap.GetString("VALUTA");
            _mc_rapporti.row.CONTINUA = Cursor_qbe_storwap.GetString("CONTINUA");
            _mc_rapporti.row.TIPOAG = Cursor_qbe_storwap.GetString("TIPOAG");
            _mc_rapporti.row.DOCFILE = Cursor_qbe_storwap.GetString("DOCFILE");
            _mc_rapporti.row.NOPROT = Cursor_qbe_storwap.GetDouble("NOPROT");
            _mc_rapporti.row.TIPMOD = Cursor_qbe_storwap.GetString("TIPMOD");
            _mc_rapporti.row.DATAMOD = Cursor_qbe_storwap.GetDate("DATAMOD");
            _mc_rapporti.row.IDRAPPORTO = Cursor_qbe_storwap.GetString("IDRAPPORTO");
            _mc_rapporti.row.IDBASE = Cursor_qbe_storwap.GetString("IDBASE");
            _mc_rapporti.row.RAGIO = Cursor_qbe_storwap.GetString("RAGIO");
            _mc_rapporti.row.MODSVOL = Cursor_qbe_storwap.GetString("MODSVOL");
            _mc_rapporti.row.AREAGEO = Cursor_qbe_storwap.GetString("AREAGEO");
            _mc_rapporti.row.SCOPO = Cursor_qbe_storwap.GetString("SCOPO");
            _mc_rapporti.row.NATURA = Cursor_qbe_storwap.GetString("NATURA");
            _mc_rapporti.row.RTIPO = Cursor_qbe_storwap.GetDouble("RTIPO");
            _mc_rapporti.row.RCOMP = Cursor_qbe_storwap.GetDouble("RCOMP");
            _mc_rapporti.row.RIMP = Cursor_qbe_storwap.GetDouble("RIMP");
            _mc_rapporti.row.RFREQ = Cursor_qbe_storwap.GetDouble("RFREQ");
            _mc_rapporti.row.RRAGIO = Cursor_qbe_storwap.GetDouble("RRAGIO");
            _mc_rapporti.row.RAREA = Cursor_qbe_storwap.GetDouble("RAREA");
            _mc_rapporti.row.TIPO = Cursor_qbe_storwap.GetString("TIPO");
            _mc_rapporti.row.PRGIMPRAP = Cursor_qbe_storwap.GetDouble("PRGIMPRAP");
            _mc_rapporti.row.AMMONT = Cursor_qbe_storwap.GetString("AMMONT");
            _mc_rapporti.row.DURAT = Cursor_qbe_storwap.GetString("DURAT");
            _mc_rapporti.row.IMPAPE = Cursor_qbe_storwap.GetDouble("IMPAPE");
            _mc_rapporti.row.IMPCHIU = Cursor_qbe_storwap.GetDouble("IMPCHIU");
            _mc_rapporti.row.SPLITCODE = Cursor_qbe_storwap.GetString("SPLITCODE");
            _mc_rapporti.row.MACODICE = Cursor_qbe_storwap.GetString("MACODICE");
            _mc_rapporti.row.CODDIP = Cursor_qbe_storwap.GetString("CODDIP");
            _mc_rapporti.row.STATORAP = Cursor_qbe_storwap.GetString("STATORAP");
            _mc_rapporti.row.CASTATOC = Cursor_qbe_storwap.GetDouble("CASTATOC");
            _mc_rapporti.row.CASTATOM = Cursor_qbe_storwap.GetDouble("CASTATOM");
            _mc_rapporti.row.CODICELR = Cursor_qbe_storwap.GetString("CODICELR");
            _mc_rapporti.row.CADSTATO = Cursor_qbe_storwap.GetDate("CADSTATO");
            _mc_rapporti.row.MITIG = Cursor_qbe_storwap.GetDouble("MITIG");
            _mc_rapporti.row.MITGDOC = Cursor_qbe_storwap.GetString("MITGDOC");
            _mc_rapporti.row.DAC6 = Cursor_qbe_storwap.GetString("DAC6");
            _mc_rapporti.row.FLAGDAC6 = Cursor_qbe_storwap.GetDouble("FLAGDAC6");
            _mc_rapporti.row.IBAN = Cursor_qbe_storwap.GetString("IBAN");
            _mc_rapporti.row.CODOGG = Cursor_qbe_storwap.GetString("CODOGG");
            Cursor_qbe_storwap.Next();
          }
          m_cConnectivityError = Cursor_qbe_storwap.ErrorMessage();
          Cursor_qbe_storwap.Close();
          _mc_rapporti.GoTop();
        } // End Case
        /* gMsgProc := gMsgProc + 'Fine precaricamento dei Rapporti per la stampa'+NL // Messaggio */
        gMsgProc = gMsgProc+"Fine precaricamento dei Rapporti per la stampa"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Rapporti da elaborare: '+_mc_rapporti.RecCount()+NL // Messaggio */
        gMsgProc = gMsgProc+"Rapporti da elaborare: "+_mc_rapporti.RecCount()+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* If w_chi_chiama_la_routine='AUI' */
      if (CPLib.eqr(w_chi_chiama_la_routine,"AUI")) {
        // * --- Select from qbe_storjap
        SPBridge.HMCaller _h0000055D;
        _h0000055D = new SPBridge.HMCaller();
        _h0000055D.Set("m_cVQRList",m_cVQRList);
        _h0000055D.Set("dadata",_ddatini);
        _h0000055D.Set("adata",_ddatfin);
        if (Cursor_qbe_storjap!=null)
          Cursor_qbe_storjap.Close();
        Cursor_qbe_storjap = new VQRHolder("qbe_storjap",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000055D,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_storjap.Eof())) {
          /* w_codrap := qbe_storjap->RAPPORTO */
          w_codrap = Cursor_qbe_storjap.GetString("RAPPORTO");
          /* w_numrec := 0 */
          w_numrec = CPLib.Round(0,0);
          // * --- Select from qbe_storjap2
          SPBridge.HMCaller _h00000560;
          _h00000560 = new SPBridge.HMCaller();
          _h00000560.Set("m_cVQRList",m_cVQRList);
          _h00000560.Set("codrap",w_codrap);
          _h00000560.Set("adata",_ddatfin);
          if (Cursor_qbe_storjap2!=null)
            Cursor_qbe_storjap2.Close();
          Cursor_qbe_storjap2 = new VQRHolder("qbe_storjap2",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000560,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_storjap2.Eof())) {
            /* -- check sulle porcate fatte dopo le chiusure */
            /* w_numrec := qbe_storjap2->totrec */
            w_numrec = CPLib.Round(Cursor_qbe_storjap2.GetDouble("totrec"),0);
            Cursor_qbe_storjap2.Next();
          }
          m_cConnectivityError = Cursor_qbe_storjap2.ErrorMessage();
          Cursor_qbe_storjap2.Close();
          // * --- End Select
          /* If w_numrec = 0 */
          if (CPLib.eqr(w_numrec,0)) {
            /* If Empty(_oldmsg) */
            if (CPLib.Empty(_oldmsg)) {
              /* gMsgProc := gMsgProc + 'Sto elaborando il rapporto: '+w_codrap // Messaggio */
              gMsgProc = gMsgProc+"Sto elaborando il rapporto: "+w_codrap;
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sto elaborando il rapporto: '+w_codrap) // Messaggio */
              gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sto elaborando il rapporto: "+w_codrap);
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } // End If
            /* _oldmsg := 'Sto elaborando il rapporto: '+w_codrap */
            _oldmsg = "Sto elaborando il rapporto: "+w_codrap;
            // * --- Select from jelegabo
            m_cServer = m_Ctx.GetServer("jelegabo");
            m_cPhName = m_Ctx.GetPhName("jelegabo");
            if (Cursor_jelegabo!=null)
              Cursor_jelegabo.Close();
            Cursor_jelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,w_codrap)+" "+")"+(m_Ctx.IsSharedTemp("jelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_jelegabo.Eof())) {
              /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(jelegabo->COLLEGAMEN) */
              add_sogg_mc(Cursor_jelegabo.GetString("COLLEGAMEN"));
              Cursor_jelegabo.Next();
            }
            m_cConnectivityError = Cursor_jelegabo.ErrorMessage();
            Cursor_jelegabo.Close();
            // * --- End Select
            // * --- Select from jarantbo
            m_cServer = m_Ctx.GetServer("jarantbo");
            m_cPhName = m_Ctx.GetPhName("jarantbo");
            if (Cursor_jarantbo!=null)
              Cursor_jarantbo.Close();
            Cursor_jarantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO "+")"+(m_Ctx.IsSharedTemp("jarantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_jarantbo.Eof())) {
              /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(jarantbo->CODINTER) */
              add_sogg_mc(Cursor_jarantbo.GetString("CODINTER"));
              Cursor_jarantbo.Next();
            }
            m_cConnectivityError = Cursor_jarantbo.ErrorMessage();
            Cursor_jarantbo.Close();
            // * --- End Select
            // * --- Select from jntestbo
            m_cServer = m_Ctx.GetServer("jntestbo");
            m_cPhName = m_Ctx.GetPhName("jntestbo");
            if (Cursor_jntestbo!=null)
              Cursor_jntestbo.Close();
            Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,w_codrap)+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_jntestbo.Eof())) {
              /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(jntestbo->CODINTER) */
              add_sogg_mc(Cursor_jntestbo.GetString("CODINTER"));
              Cursor_jntestbo.Next();
            }
            m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
            Cursor_jntestbo.Close();
            // * --- End Select
            // * --- Select from joginfo
            m_cServer = m_Ctx.GetServer("joginfo");
            m_cPhName = m_Ctx.GetPhName("joginfo");
            if (Cursor_joginfo!=null)
              Cursor_joginfo.Close();
            Cursor_joginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,w_codrap)+" "+")"+(m_Ctx.IsSharedTemp("joginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_joginfo.Eof())) {
              /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(joginfo->CODSOG) */
              add_sogg_mc(Cursor_joginfo.GetString("CODSOG"));
              Cursor_joginfo.Next();
            }
            m_cConnectivityError = Cursor_joginfo.ErrorMessage();
            Cursor_joginfo.Close();
            // * --- End Select
            /* If w_tipoope = 'T' and At(w_stampa,'|E|S') <> 0 */
            if (CPLib.eqr(w_tipoope,"T") && CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
              // * --- Insert into hnarapbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("hnarapbo");
              m_cPhName = m_Ctx.GetPhName("hnarapbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"hnarapbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000573")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000573(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("CONTINUA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetDouble("NOPROT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("TIPMOD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetDate("DATAMOD"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("IDRAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("NATURA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetDouble("RTIPO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetDouble("RIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetDouble("RFREQ"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetDouble("RRAGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetDouble("PRGIMPRAP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("DURAT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetDouble("IMPAPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetDouble("IMPCHIU"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("SPLITCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("MACODICE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("STATORAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetDouble("CASTATOC"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetDouble("CASTATOM"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("CODICELR"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetDouble("MITIG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap.GetString("MITGDOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"hnarapbo",true);
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
            // * --- Select from qbe_storjap1
            SPBridge.HMCaller _h00000574;
            _h00000574 = new SPBridge.HMCaller();
            _h00000574.Set("m_cVQRList",m_cVQRList);
            _h00000574.Set("codrap",w_codrap);
            if (Cursor_qbe_storjap1!=null)
              Cursor_qbe_storjap1.Close();
            Cursor_qbe_storjap1 = new VQRHolder("qbe_storjap1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000574,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_storjap1.Eof())) {
              /* If w_tipoope = 'T' and At(w_stampa,'|E|S') <> 0 */
              if (CPLib.eqr(w_tipoope,"T") && CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                // * --- Insert into hapopebo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("hapopebo");
                m_cPhName = m_Ctx.GetPhName("hapopebo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"hapopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000576")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000576(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetDate("DATAREG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetDouble("TOTLIRE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetDouble("TOTCONT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetDouble("CAMBIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetDate("DATAAGE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetDouble("PRGIMPINF"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("IDBASE2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"hapopebo",true);
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
                // * --- Select from jntestbo
                m_cServer = m_Ctx.GetServer("jntestbo");
                m_cPhName = m_Ctx.GetPhName("jntestbo");
                if (Cursor_jntestbo!=null)
                  Cursor_jntestbo.Close();
                Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_jntestbo.Eof())) {
                  // * --- Insert into hntestbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("hntestbo");
                  m_cPhName = m_Ctx.GetPhName("hntestbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"hntestbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000578")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000578(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jntestbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jntestbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jntestbo.GetDate("DATAINI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jntestbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jntestbo.GetDate("DATAFINE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jntestbo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jntestbo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jntestbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jntestbo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jntestbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"hntestbo",true);
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
                  Cursor_jntestbo.Next();
                }
                m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
                Cursor_jntestbo.Close();
                // * --- End Select
                // * --- Select from joginfo
                m_cServer = m_Ctx.GetServer("joginfo");
                m_cPhName = m_Ctx.GetPhName("joginfo");
                if (Cursor_joginfo!=null)
                  Cursor_joginfo.Close();
                Cursor_joginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("joginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_joginfo.Eof())) {
                  // * --- Insert into hoginfo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("hoginfo");
                  m_cPhName = m_Ctx.GetPhName("hoginfo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"hoginfo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000057A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000057A(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_joginfo.GetString("IDFILEBO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_joginfo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_joginfo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_joginfo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"hoginfo",true);
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
                  Cursor_joginfo.Next();
                }
                m_cConnectivityError = Cursor_joginfo.ErrorMessage();
                Cursor_joginfo.Close();
                // * --- End Select
                // * --- Select from jelegabo
                m_cServer = m_Ctx.GetServer("jelegabo");
                m_cPhName = m_Ctx.GetPhName("jelegabo");
                if (Cursor_jelegabo!=null)
                  Cursor_jelegabo.Close();
                Cursor_jelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_jelegabo.Eof())) {
                  // * --- Insert into helegabo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("helegabo");
                  m_cPhName = m_Ctx.GetPhName("helegabo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"helegabo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000057C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000057C(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetDate("DATAINI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetDate("DATARETT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetString("COLLEGAMEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetDate("DATAFINE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetString("NUMPROG2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetDouble("ABBINATO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jelegabo.GetString("NOAGE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"helegabo",true);
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
                  Cursor_jelegabo.Next();
                }
                m_cConnectivityError = Cursor_jelegabo.ErrorMessage();
                Cursor_jelegabo.Close();
                // * --- End Select
                // * --- Select from jarantbo
                m_cServer = m_Ctx.GetServer("jarantbo");
                m_cPhName = m_Ctx.GetPhName("jarantbo");
                if (Cursor_jarantbo!=null)
                  Cursor_jarantbo.Close();
                Cursor_jarantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_storjap1.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jarantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_jarantbo.Eof())) {
                  // * --- Insert into harantbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("harantbo");
                  m_cPhName = m_Ctx.GetPhName("harantbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"harantbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"0000057E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000057E(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jarantbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jarantbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jarantbo.GetDate("DATAINI"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jarantbo.GetDate("DATAFINE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_jarantbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"harantbo",true);
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
                  Cursor_jarantbo.Next();
                }
                m_cConnectivityError = Cursor_jarantbo.ErrorMessage();
                Cursor_jarantbo.Close();
                // * --- End Select
              } // End If
              /* If At(w_stampa,'|E|S') <> 0 */
              if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                // * --- Delete from jarantbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("jarantbo");
                m_cPhName = m_Ctx.GetPhName("jarantbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jarantbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000580")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storjap1.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storjap1.GetString("RAPPORTO"))+"";
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
                // * --- Delete from jelegabo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("jelegabo");
                m_cPhName = m_Ctx.GetPhName("jelegabo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jelegabo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000581")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storjap1.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storjap1.GetString("RAPPORTO"))+"";
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
                // * --- Delete from joginfo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("joginfo");
                m_cPhName = m_Ctx.GetPhName("joginfo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"joginfo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000582")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storjap1.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storjap1.GetString("IDBASE"))+"";
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
                // * --- Delete from jntestbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("jntestbo");
                m_cPhName = m_Ctx.GetPhName("jntestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000583")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storjap1.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storjap1.GetString("RAPPORTO"))+"";
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
                // * --- Delete from japopebo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("japopebo");
                m_cPhName = m_Ctx.GetPhName("japopebo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"japopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000584")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storjap1.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storjap1.GetString("IDBASE"))+"";
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
              Cursor_qbe_storjap1.Next();
            }
            m_cConnectivityError = Cursor_qbe_storjap1.ErrorMessage();
            Cursor_qbe_storjap1.Close();
            // * --- End Select
            /* If At(w_stampa,'|E|S') <> 0 */
            if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
              // * --- Delete from jnarapbo
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("jnarapbo");
              m_cPhName = m_Ctx.GetPhName("jnarapbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jnarapbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000586")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer),m_cServer,w_codrap)+"";
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
          /* _contaop := _contaop+1 */
          _contaop = CPLib.Round(_contaop+1,0);
          Cursor_qbe_storjap.Next();
        }
        m_cConnectivityError = Cursor_qbe_storjap.ErrorMessage();
        Cursor_qbe_storjap.Close();
        // * --- End Select
        /* ElseIf w_chi_chiama_la_routine='STO' */
      } else if (CPLib.eqr(w_chi_chiama_la_routine,"STO")) {
        // * --- Select from qbe_storwap
        SPBridge.HMCaller _h00000588;
        _h00000588 = new SPBridge.HMCaller();
        _h00000588.Set("m_cVQRList",m_cVQRList);
        _h00000588.Set("dadata",_ddatini);
        _h00000588.Set("adata",_ddatfin);
        if (Cursor_qbe_storwap!=null)
          Cursor_qbe_storwap.Close();
        Cursor_qbe_storwap = new VQRHolder("qbe_storwap",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000588,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_storwap.Eof())) {
          /* w_codrap := qbe_storwap->RAPPORTO */
          w_codrap = Cursor_qbe_storwap.GetString("RAPPORTO");
          /* w_numrec := 0 */
          w_numrec = CPLib.Round(0,0);
          // * --- Select from qbe_storwap2
          SPBridge.HMCaller _h0000058B;
          _h0000058B = new SPBridge.HMCaller();
          _h0000058B.Set("m_cVQRList",m_cVQRList);
          _h0000058B.Set("codrap",w_codrap);
          _h0000058B.Set("adata",_ddatfin);
          if (Cursor_qbe_storwap2!=null)
            Cursor_qbe_storwap2.Close();
          Cursor_qbe_storwap2 = new VQRHolder("qbe_storwap2",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000058B,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_storwap2.Eof())) {
            /* -- check sulle porcate fatte dopo le chiusure */
            /* w_numrec := qbe_storwap2->totrec */
            w_numrec = CPLib.Round(Cursor_qbe_storwap2.GetDouble("totrec"),0);
            Cursor_qbe_storwap2.Next();
          }
          m_cConnectivityError = Cursor_qbe_storwap2.ErrorMessage();
          Cursor_qbe_storwap2.Close();
          // * --- End Select
          /* If w_numrec = 0 */
          if (CPLib.eqr(w_numrec,0)) {
            /* If Empty(_oldmsg) */
            if (CPLib.Empty(_oldmsg)) {
              /* gMsgProc := gMsgProc + 'Sto elaborando il rapporto: '+w_codrap // Messaggio */
              gMsgProc = gMsgProc+"Sto elaborando il rapporto: "+w_codrap;
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sto elaborando il rapporto: '+w_codrap) // Messaggio */
              gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sto elaborando il rapporto: "+w_codrap);
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } // End If
            /* _oldmsg := 'Sto elaborando il rapporto: '+w_codrap */
            _oldmsg = "Sto elaborando il rapporto: "+w_codrap;
            // * --- Select from welegabo
            m_cServer = m_Ctx.GetServer("welegabo");
            m_cPhName = m_Ctx.GetPhName("welegabo");
            if (Cursor_welegabo!=null)
              Cursor_welegabo.Close();
            Cursor_welegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,w_codrap)+" "+")"+(m_Ctx.IsSharedTemp("welegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_welegabo.Eof())) {
              /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(welegabo->COLLEGAMEN) */
              add_sogg_mc(Cursor_welegabo.GetString("COLLEGAMEN"));
              Cursor_welegabo.Next();
            }
            m_cConnectivityError = Cursor_welegabo.ErrorMessage();
            Cursor_welegabo.Close();
            // * --- End Select
            // * --- Select from warantbo
            m_cServer = m_Ctx.GetServer("warantbo");
            m_cPhName = m_Ctx.GetPhName("warantbo");
            if (Cursor_warantbo!=null)
              Cursor_warantbo.Close();
            Cursor_warantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO "+")"+(m_Ctx.IsSharedTemp("warantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_warantbo.Eof())) {
              /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(warantbo->CODINTER) */
              add_sogg_mc(Cursor_warantbo.GetString("CODINTER"));
              Cursor_warantbo.Next();
            }
            m_cConnectivityError = Cursor_warantbo.ErrorMessage();
            Cursor_warantbo.Close();
            // * --- End Select
            // * --- Select from wntestbo
            m_cServer = m_Ctx.GetServer("wntestbo");
            m_cPhName = m_Ctx.GetPhName("wntestbo");
            if (Cursor_wntestbo!=null)
              Cursor_wntestbo.Close();
            Cursor_wntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,w_codrap)+" "+")"+(m_Ctx.IsSharedTemp("wntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wntestbo.Eof())) {
              /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(wntestbo->CODINTER) */
              add_sogg_mc(Cursor_wntestbo.GetString("CODINTER"));
              Cursor_wntestbo.Next();
            }
            m_cConnectivityError = Cursor_wntestbo.ErrorMessage();
            Cursor_wntestbo.Close();
            // * --- End Select
            // * --- Select from woginfo
            m_cServer = m_Ctx.GetServer("woginfo");
            m_cPhName = m_Ctx.GetPhName("woginfo");
            if (Cursor_woginfo!=null)
              Cursor_woginfo.Close();
            Cursor_woginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,w_codrap)+" "+")"+(m_Ctx.IsSharedTemp("woginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_woginfo.Eof())) {
              /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(woginfo->CODSOG) */
              add_sogg_mc(Cursor_woginfo.GetString("CODSOG"));
              Cursor_woginfo.Next();
            }
            m_cConnectivityError = Cursor_woginfo.ErrorMessage();
            Cursor_woginfo.Close();
            // * --- End Select
            // * --- Select from wapopebo
            m_cServer = m_Ctx.GetServer("wapopebo");
            m_cPhName = m_Ctx.GetPhName("wapopebo");
            if (Cursor_wapopebo!=null)
              Cursor_wapopebo.Close();
            Cursor_wapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,w_codrap)+" "+")"+(m_Ctx.IsSharedTemp("wapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wapopebo.Eof())) {
              // * --- Select from widuciabo
              m_cServer = m_Ctx.GetServer("widuciabo");
              m_cPhName = m_Ctx.GetPhName("widuciabo");
              if (Cursor_widuciabo!=null)
                Cursor_widuciabo.Close();
              Cursor_widuciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_wapopebo.GetString("IDBASE"),"?",0,0)+"=IDFILEBO "+")"+(m_Ctx.IsSharedTemp("widuciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_widuciabo.Eof())) {
                /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(widuciabo->CODSOG) */
                add_sogg_mc(Cursor_widuciabo.GetString("CODSOG"));
                Cursor_widuciabo.Next();
              }
              m_cConnectivityError = Cursor_widuciabo.ErrorMessage();
              Cursor_widuciabo.Close();
              // * --- End Select
              Cursor_wapopebo.Next();
            }
            m_cConnectivityError = Cursor_wapopebo.ErrorMessage();
            Cursor_wapopebo.Close();
            // * --- End Select
            /* If At(w_stampa,'|E|S') <> 0 */
            if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
              // * --- Select from qbe_storwap1
              SPBridge.HMCaller _h000005A1;
              _h000005A1 = new SPBridge.HMCaller();
              _h000005A1.Set("m_cVQRList",m_cVQRList);
              _h000005A1.Set("codrap",w_codrap);
              if (Cursor_qbe_storwap1!=null)
                Cursor_qbe_storwap1.Close();
              Cursor_qbe_storwap1 = new VQRHolder("qbe_storwap1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000005A1,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_storwap1.Eof())) {
                // * --- Delete from waldi_idp
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("waldi_idp");
                m_cPhName = m_Ctx.GetPhName("waldi_idp");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"waldi_idp",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000005A2")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwap1.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwap1.GetString("RAPPORTO"))+"";
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
                // * --- Delete from warantbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("warantbo");
                m_cPhName = m_Ctx.GetPhName("warantbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"warantbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000005A3")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwap1.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwap1.GetString("RAPPORTO"))+"";
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
                // * --- Delete from widuciabo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("widuciabo");
                m_cPhName = m_Ctx.GetPhName("widuciabo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"widuciabo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000005A4")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwap1.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwap1.GetString("IDBASE"))+"";
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
                // * --- Delete from welegabo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("welegabo");
                m_cPhName = m_Ctx.GetPhName("welegabo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"welegabo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000005A5")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwap1.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwap1.GetString("RAPPORTO"))+"";
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
                // * --- Delete from woginfo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("woginfo");
                m_cPhName = m_Ctx.GetPhName("woginfo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"woginfo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000005A6")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDFILEBO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwap1.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwap1.GetString("IDBASE"))+"";
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
                // * --- Delete from wntestbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("wntestbo");
                m_cPhName = m_Ctx.GetPhName("wntestbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wntestbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000005A7")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwap1.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwap1.GetString("RAPPORTO"))+"";
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
                // * --- Delete from wapopebo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("wapopebo");
                m_cPhName = m_Ctx.GetPhName("wapopebo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wapopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000005A8")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_storwap1.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_storwap1.GetString("IDBASE"))+"";
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
                Cursor_qbe_storwap1.Next();
              }
              m_cConnectivityError = Cursor_qbe_storwap1.ErrorMessage();
              Cursor_qbe_storwap1.Close();
              // * --- End Select
              // * --- Delete from wnarapbo
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("wnarapbo");
              m_cPhName = m_Ctx.GetPhName("wnarapbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wnarapbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000005A9")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codrap,"?",0,0,m_cServer),m_cServer,w_codrap)+"";
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
          /* _contaop := _contaop+1 */
          _contaop = CPLib.Round(_contaop+1,0);
          Cursor_qbe_storwap.Next();
        }
        m_cConnectivityError = Cursor_qbe_storwap.ErrorMessage();
        Cursor_qbe_storwap.Close();
        // * --- End Select
      } // End If
      /* gMsgProc := gMsgProc +'Sono stati '+ iif(w_tipoope='T','Trasferiti ','Cancellati ')+LRTrim(Str(_contaop,10,0))+" rapporti"+ NL */
      gMsgProc = gMsgProc+"Sono stati "+(CPLib.eqr(w_tipoope,"T")?"Trasferiti ":"Cancellati ")+CPLib.LRTrim(CPLib.Str(_contaop,10,0))+" rapporti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_storjap!=null)
          Cursor_qbe_storjap.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_storwap!=null)
          Cursor_qbe_storwap.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_storjap2!=null)
          Cursor_qbe_storjap2.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jelegabo!=null)
          Cursor_jelegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jarantbo!=null)
          Cursor_jarantbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_joginfo!=null)
          Cursor_joginfo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_storjap1!=null)
          Cursor_qbe_storjap1.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_storwap2!=null)
          Cursor_qbe_storwap2.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_welegabo!=null)
          Cursor_welegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_warantbo!=null)
          Cursor_warantbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wntestbo!=null)
          Cursor_wntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_woginfo!=null)
          Cursor_woginfo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wapopebo!=null)
          Cursor_wapopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_widuciabo!=null)
          Cursor_widuciabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_storwap1!=null)
          Cursor_qbe_storwap1.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void tit_age() throws Exception {
    CPResultSet Cursor_jntestit=null;
    CPResultSet Cursor_hntestit=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_japotit=null;
    CPResultSet Cursor_hapotit=null;
    CPResultSet Cursor_wntestit=null;
    try {
      /* _isThereInfo := False */
      _isThereInfo = false;
      /* _isThereSomething := False */
      _isThereSomething = false;
      /* _contarow := 0 */
      _contarow = CPLib.Round(0,0);
      /* _contaop := 0 */
      _contaop = CPLib.Round(0,0);
      /* If Empty(_ddatini) */
      if (CPLib.Empty(_ddatini)) {
        /* If w_chi_chiama_la_routine="AUI" */
        if (CPLib.eqr(w_chi_chiama_la_routine,"AUI")) {
          // * --- Select from jntestit
          m_cServer = m_Ctx.GetServer("jntestit");
          m_cPhName = m_Ctx.GetPhName("jntestit");
          if (Cursor_jntestit!=null)
            Cursor_jntestit.Close();
          Cursor_jntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAFINE<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatfin)+" "+")"+(m_Ctx.IsSharedTemp("jntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAFINE ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_jntestit.Eof())) {
            /* _ddatini := jntestit->DATAFINE */
            _ddatini = Cursor_jntestit.GetDate("DATAFINE");
            /* _isThereSomething := True */
            _isThereSomething = true;
            // Exit Loop
            if (true) {
              break;
            }
            Cursor_jntestit.Next();
          }
          m_cConnectivityError = Cursor_jntestit.ErrorMessage();
          Cursor_jntestit.Close();
          // * --- End Select
          /* ElseIf w_chi_chiama_la_routine="STO" */
        } else if (CPLib.eqr(w_chi_chiama_la_routine,"STO")) {
          // * --- Select from hntestit
          m_cServer = m_Ctx.GetServer("hntestit");
          m_cPhName = m_Ctx.GetPhName("hntestit");
          if (Cursor_hntestit!=null)
            Cursor_hntestit.Close();
          Cursor_hntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAFINE<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatfin)+" "+")"+(m_Ctx.IsSharedTemp("hntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAFINE ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_hntestit.Eof())) {
            /* _ddatini := hntestit->DATAFINE */
            _ddatini = Cursor_hntestit.GetDate("DATAFINE");
            /* _isThereSomething := True */
            _isThereSomething = true;
            // Exit Loop
            if (true) {
              break;
            }
            Cursor_hntestit.Next();
          }
          m_cConnectivityError = Cursor_hntestit.ErrorMessage();
          Cursor_hntestit.Close();
          // * --- End Select
        } // End If
      } else { // Else
        /* If w_chi_chiama_la_routine="AUI" */
        if (CPLib.eqr(w_chi_chiama_la_routine,"AUI")) {
          // * --- Select from jntestit
          m_cServer = m_Ctx.GetServer("jntestit");
          m_cPhName = m_Ctx.GetPhName("jntestit");
          if (Cursor_jntestit!=null)
            Cursor_jntestit.Close();
          Cursor_jntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAFINE>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatini)+"  and  DATAFINE<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatfin)+" "+")"+(m_Ctx.IsSharedTemp("jntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAFINE ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_jntestit.Eof())) {
            /* _ddatini := jntestit->DATAFINE */
            _ddatini = Cursor_jntestit.GetDate("DATAFINE");
            /* _isThereSomething := True */
            _isThereSomething = true;
            // Exit Loop
            if (true) {
              break;
            }
            Cursor_jntestit.Next();
          }
          m_cConnectivityError = Cursor_jntestit.ErrorMessage();
          Cursor_jntestit.Close();
          // * --- End Select
          /* ElseIf w_chi_chiama_la_routine="STO" */
        } else if (CPLib.eqr(w_chi_chiama_la_routine,"STO")) {
          // * --- Select from hntestit
          m_cServer = m_Ctx.GetServer("hntestit");
          m_cPhName = m_Ctx.GetPhName("hntestit");
          if (Cursor_hntestit!=null)
            Cursor_hntestit.Close();
          Cursor_hntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DATAFINE  and  DATAFINE<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatfin)+" "+")"+(m_Ctx.IsSharedTemp("hntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAFINE ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_hntestit.Eof())) {
            /* _ddatini := hntestit->DATAFINE */
            _ddatini = Cursor_hntestit.GetDate("DATAFINE");
            /* _isThereSomething := True */
            _isThereSomething = true;
            // Exit Loop
            if (true) {
              break;
            }
            Cursor_hntestit.Next();
          }
          m_cConnectivityError = Cursor_hntestit.ErrorMessage();
          Cursor_hntestit.Close();
          // * --- End Select
        } // End If
      } // End If
      /* gMsgProc := gMsgProc+"Analisi dei legami di titolarità tra i soggetti"+NL // Messaggio */
      gMsgProc = gMsgProc+"Analisi dei legami di titolarità tra i soggetti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If _isThereSomething */
      if (_isThereSomething) {
        /* Se effettivamente ci sono chiusure nel periodo */
        /* If w_chi_chiama_la_routine="AUI" */
        if (CPLib.eqr(w_chi_chiama_la_routine,"AUI")) {
          // * --- Fill memory cursor _mc_intestit on intestit
          _mc_intestit.GoBottom();
          m_cServer = m_Ctx.GetServer("intestit");
          m_cPhName = m_Ctx.GetPhName("intestit");
          if (Cursor_intestit!=null)
            Cursor_intestit.Close();
          Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_jntestit.GetDate("DATAFINE"),"?",0,0)+">="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatini)+"  and  "+CPLib.ToSQL(Cursor_jntestit.GetDate("DATAFINE"),"?",0,0)+"<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatfin)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_intestit;
            Cursor_intestit.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_stor_trasf: query on intestit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_intestit.Eof())) {
            _mc_intestit.AppendBlank();
            _mc_intestit.row.CODCLI = Cursor_intestit.GetString("CODCLI");
            _mc_intestit.row.RAPPORTO = Cursor_intestit.GetString("RAPPORTO");
            _mc_intestit.row.CODINTER = Cursor_intestit.GetString("CODINTER");
            _mc_intestit.row.DESCINTER = Cursor_intestit.GetString("DESCINTER");
            _mc_intestit.row.DATAINI = Cursor_intestit.GetDate("DATAINI");
            _mc_intestit.row.TIPORAP = Cursor_intestit.GetString("TIPORAP");
            _mc_intestit.row.TIPOPERS = Cursor_intestit.GetString("TIPOPERS");
            _mc_intestit.row.STATOREG = Cursor_intestit.GetString("STATOREG");
            _mc_intestit.row.OPERAZMOD = Cursor_intestit.GetString("OPERAZMOD");
            _mc_intestit.row.DATARETT = Cursor_intestit.GetDate("DATARETT");
            _mc_intestit.row.IDEREG = Cursor_intestit.GetString("IDEREG");
            _mc_intestit.row.COLLEGAMEN = Cursor_intestit.GetString("COLLEGAMEN");
            _mc_intestit.row.DATAFINE = Cursor_intestit.GetDate("DATAFINE");
            _mc_intestit.row.NUMPROG1 = Cursor_intestit.GetString("NUMPROG1");
            _mc_intestit.row.NUMPROG2 = Cursor_intestit.GetString("NUMPROG2");
            _mc_intestit.row.IDBASE = Cursor_intestit.GetString("IDBASE");
            _mc_intestit.row.UCODE = Cursor_intestit.GetString("UCODE");
            _mc_intestit.row.ABBINATO = Cursor_intestit.GetDouble("ABBINATO");
            _mc_intestit.row.PRGIMPTITE = Cursor_intestit.GetDouble("PRGIMPTITE");
            _mc_intestit.row.NUMIMP = Cursor_intestit.GetDateTime("NUMIMP");
            _mc_intestit.row.NOAGE = Cursor_intestit.GetString("NOAGE");
            Cursor_intestit.Next();
          }
          m_cConnectivityError = Cursor_intestit.ErrorMessage();
          Cursor_intestit.Close();
          _mc_intestit.GoTop();
          for (MemoryCursorRow_intestit rw_intestino : _mc_intestit._iterable_()) {
            /* gMsgImp := "Analisi del legame del soggetto: "+rw_intestino.CODINTER */
            gMsgImp = "Analisi del legame del soggetto: "+rw_intestino.CODINTER;
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* Aggiungo i Soggetti a quelli da controllare (eventuale penzoloni) */
            /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(rw_intestino.CODINTER) */
            add_sogg_mc(rw_intestino.CODINTER);
            /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(rw_intestino.CODCLI) */
            add_sogg_mc(rw_intestino.CODCLI);
            /* If w_tipoope = 'T' and At(w_stampa,'|E|S') <> 0 */
            if (CPLib.eqr(w_tipoope,"T") && CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
              /* Trasferisco il titolare a storico */
              // * --- Insert into hntestit from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("hntestit");
              m_cPhName = m_Ctx.GetPhName("hntestit");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"hntestit",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000005D4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000005D4(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.UCODE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.TIPORAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.TIPOPERS,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.STATOREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.RAPPORTO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.PRGIMPTITE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.OPERAZMOD,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.NUMPROG2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.NUMPROG1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.IDEREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.IDBASE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.DESCINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.DATARETT,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.DATAINI,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.DATAFINE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.COLLEGAMEN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.CODINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.CODCLI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rw_intestino.ABBINATO,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"hntestit",true);
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
              /* Trasferisco le informazioni a strorico (50 e 51) */
              // * --- Select from japotit
              m_cServer = m_Ctx.GetServer("japotit");
              m_cPhName = m_Ctx.GetPhName("japotit");
              if (Cursor_japotit!=null)
                Cursor_japotit.Close();
              Cursor_japotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_intestino.NUMPROG1,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_intestino.NUMPROG1)+" "+")"+(m_Ctx.IsSharedTemp("japotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_japotit.Eof())) {
                /* _isThereInfo := False */
                _isThereInfo = false;
                /* Controllo che l'informazione non ci sia già */
                // * --- Select from hapotit
                m_cServer = m_Ctx.GetServer("hapotit");
                m_cPhName = m_Ctx.GetPhName("hapotit");
                if (Cursor_hapotit!=null)
                  Cursor_hapotit.Close();
                Cursor_hapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG = "+CPLib.ToSQL(Cursor_japotit.GetString("NUMPROG"),"?",0,0)+"  and  TIPOOPRAP= "+CPLib.ToSQL(Cursor_japotit.GetString("TIPOOPRAP"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("hapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_hapotit.Eof())) {
                  /* _isThereInfo := True */
                  _isThereInfo = true;
                  Cursor_hapotit.Next();
                }
                m_cConnectivityError = Cursor_hapotit.ErrorMessage();
                Cursor_hapotit.Close();
                // * --- End Select
                /* If not(_isThereInfo) */
                if ( ! (_isThereInfo)) {
                  /* Se l'informazione non cè la inserisco */
                  // * --- Insert into hapotit from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("hapotit");
                  m_cPhName = m_Ctx.GetPhName("hapotit");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"hapotit",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000005DD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000005DD(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetDouble("CAMBIO"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetDate("DATAAGE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetDate("DATAOPE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetDate("DATAREG"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetDate("DATARETT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("IDBASE2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("INFORM"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetDouble("PRGIMPTIT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetDouble("TOTCONT"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetDouble("TOTLIRE"),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_japotit.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"hapotit",true);
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
                Cursor_japotit.Next();
              }
              m_cConnectivityError = Cursor_japotit.ErrorMessage();
              Cursor_japotit.Close();
              // * --- End Select
            } // End If
            /* If At(w_stampa,'|E|S') <> 0 */
            if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
              // * --- Delete from jntestit
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("jntestit");
              m_cPhName = m_Ctx.GetPhName("jntestit");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestit",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000005DF")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_intestino.IDBASE,"?",0,0,m_cServer),m_cServer,rw_intestino.IDBASE)+"";
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
            /* _contarow := _contarow+1 */
            _contarow = CPLib.Round(_contarow+1,0);
            /* Tento di eliminare l'informazione (se non ha più voci in intestit) */
            // * --- Fill memory cursor _mc_rapotit on japotit
            _mc_rapotit.GoBottom();
            m_cServer = m_Ctx.GetServer("japotit");
            m_cPhName = m_Ctx.GetPhName("japotit");
            if (Cursor_japotit!=null)
              Cursor_japotit.Close();
            Cursor_japotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_intestino.CODCLI,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_intestino.CODCLI)+" "+")"+(m_Ctx.IsSharedTemp("japotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_japotit;
              Cursor_japotit.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stor_trasf: query on japotit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_japotit.Eof())) {
              _mc_rapotit.AppendBlank();
              _mc_rapotit.row.IDBASE = Cursor_japotit.GetString("IDBASE");
              _mc_rapotit.row.DATAOPE = Cursor_japotit.GetDate("DATAOPE");
              _mc_rapotit.row.NUMPROG = Cursor_japotit.GetString("NUMPROG");
              _mc_rapotit.row.TIPOINTER = Cursor_japotit.GetString("TIPOINTER");
              _mc_rapotit.row.CODINTER = Cursor_japotit.GetString("CODINTER");
              _mc_rapotit.row.TIPOINF = Cursor_japotit.GetString("TIPOINF");
              _mc_rapotit.row.IDEREG = Cursor_japotit.GetString("IDEREG");
              _mc_rapotit.row.CODDIPE = Cursor_japotit.GetString("CODDIPE");
              _mc_rapotit.row.DESCCIT = Cursor_japotit.GetString("DESCCIT");
              _mc_rapotit.row.PROVINCIA = Cursor_japotit.GetString("PROVINCIA");
              _mc_rapotit.row.CODCAB = Cursor_japotit.GetString("CODCAB");
              _mc_rapotit.row.FLAGFRAZ = Cursor_japotit.GetString("FLAGFRAZ");
              _mc_rapotit.row.FLAGCONT = Cursor_japotit.GetString("FLAGCONT");
              _mc_rapotit.row.CODANA = Cursor_japotit.GetString("CODANA");
              _mc_rapotit.row.CODVOC = Cursor_japotit.GetString("CODVOC");
              _mc_rapotit.row.TIPOINT2 = Cursor_japotit.GetString("TIPOINT2");
              _mc_rapotit.row.CODINT2 = Cursor_japotit.GetString("CODINT2");
              _mc_rapotit.row.PAESE = Cursor_japotit.GetString("PAESE");
              _mc_rapotit.row.DESC2 = Cursor_japotit.GetString("DESC2");
              _mc_rapotit.row.PROV2 = Cursor_japotit.GetString("PROV2");
              _mc_rapotit.row.CODCAB2 = Cursor_japotit.GetString("CODCAB2");
              _mc_rapotit.row.DESCINTER = Cursor_japotit.GetString("DESCINTER");
              _mc_rapotit.row.RAPPORTO = Cursor_japotit.GetString("RAPPORTO");
              _mc_rapotit.row.FLAGRAP = Cursor_japotit.GetString("FLAGRAP");
              _mc_rapotit.row.TIPOLEG = Cursor_japotit.GetString("TIPOLEG");
              _mc_rapotit.row.DATAREG = Cursor_japotit.GetDate("DATAREG");
              _mc_rapotit.row.OPRAP = Cursor_japotit.GetString("OPRAP");
              _mc_rapotit.row.TIPOOPRAP = Cursor_japotit.GetString("TIPOOPRAP");
              _mc_rapotit.row.FLAGLIRE = Cursor_japotit.GetString("FLAGLIRE");
              _mc_rapotit.row.VALUTA = Cursor_japotit.GetString("VALUTA");
              _mc_rapotit.row.SEGNO = Cursor_japotit.GetString("SEGNO");
              _mc_rapotit.row.TOTLIRE = Cursor_japotit.GetDouble("TOTLIRE");
              _mc_rapotit.row.TOTCONT = Cursor_japotit.GetDouble("TOTCONT");
              _mc_rapotit.row.STATOREG = Cursor_japotit.GetString("STATOREG");
              _mc_rapotit.row.OPERAZMOD = Cursor_japotit.GetString("OPERAZMOD");
              _mc_rapotit.row.DATARETT = Cursor_japotit.GetDate("DATARETT");
              _mc_rapotit.row.CONNESCLI = Cursor_japotit.GetString("CONNESCLI");
              _mc_rapotit.row.CONNESOPER = Cursor_japotit.GetString("CONNESOPER");
              _mc_rapotit.row.CONNESBEN = Cursor_japotit.GetString("CONNESBEN");
              _mc_rapotit.row.COLLEG = Cursor_japotit.GetString("COLLEG");
              _mc_rapotit.row.CAMBIO = Cursor_japotit.GetDouble("CAMBIO");
              _mc_rapotit.row.RAPPORTBEN = Cursor_japotit.GetString("RAPPORTBEN");
              _mc_rapotit.row.FLAGRAP2 = Cursor_japotit.GetString("FLAGRAP2");
              _mc_rapotit.row.OPERATORE = Cursor_japotit.GetString("OPERATORE");
              _mc_rapotit.row.AUTOM = Cursor_japotit.GetString("AUTOM");
              _mc_rapotit.row.RESPINS = Cursor_japotit.GetString("RESPINS");
              _mc_rapotit.row.INFORM = Cursor_japotit.GetString("INFORM");
              _mc_rapotit.row.DATAAGE = Cursor_japotit.GetDate("DATAAGE");
              _mc_rapotit.row.UCODE = Cursor_japotit.GetString("UCODE");
              _mc_rapotit.row.PRGIMPTIT = Cursor_japotit.GetDouble("PRGIMPTIT");
              _mc_rapotit.row.CDATOPE = Cursor_japotit.GetString("CDATOPE");
              _mc_rapotit.row.UNIQUECODE = Cursor_japotit.GetString("UNIQUECODE");
              _mc_rapotit.row.CDATREG = Cursor_japotit.GetString("CDATREG");
              _mc_rapotit.row.IDBASE2 = Cursor_japotit.GetString("IDBASE2");
              _mc_rapotit.row.NUMIMP = Cursor_japotit.GetDateTime("NUMIMP");
              Cursor_japotit.Next();
            }
            m_cConnectivityError = Cursor_japotit.ErrorMessage();
            Cursor_japotit.Close();
            _mc_rapotit.GoTop();
            for (MemoryCursorRow_rapotit rw_rapotitte : _mc_rapotit._iterable_()) {
              /* Cerco dei titolari in base al NUMPROG */
              /* _isThereInfo := False */
              _isThereInfo = false;
              // * --- Select from intestit
              m_cServer = m_Ctx.GetServer("intestit");
              m_cPhName = m_Ctx.GetPhName("intestit");
              if (Cursor_intestit!=null)
                Cursor_intestit.Close();
              Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_rapotitte.NUMPROG,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_rapotitte.NUMPROG)+"=NUMPROG1  or  "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_rapotitte.NUMPROG,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_rapotitte.NUMPROG)+"=NUMPROG2 "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestit.Eof())) {
                /* Ci sono ancora titolari */
                /* _isThereInfo := True */
                _isThereInfo = true;
                Cursor_intestit.Next();
              }
              m_cConnectivityError = Cursor_intestit.ErrorMessage();
              Cursor_intestit.Close();
              // * --- End Select
              /* If not(_isThereInfo) */
              if ( ! (_isThereInfo)) {
                /* Se l'informazione NON ha più titolari associati la cancello */
                /* If At(w_stampa,'|E|S') <> 0 */
                if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                  // * --- Delete from japotit
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("japotit");
                  m_cPhName = m_Ctx.GetPhName("japotit");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"japotit",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000005EC")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_rapotitte.IDBASE,"?",0,0,m_cServer),m_cServer,rw_rapotitte.IDBASE)+"";
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
                /* _contaop := _contaop+1 */
                _contaop = CPLib.Round(_contaop+1,0);
              } // End If
            }
          }
          /* ElseIf w_chi_chiama_la_routine="STO" */
        } else if (CPLib.eqr(w_chi_chiama_la_routine,"STO")) {
          // * --- Fill memory cursor _mc_intestit on wntestit
          _mc_intestit.Zap();
          m_cServer = m_Ctx.GetServer("wntestit");
          m_cPhName = m_Ctx.GetPhName("wntestit");
          if (Cursor_wntestit!=null)
            Cursor_wntestit.Close();
          Cursor_wntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_hntestit.GetDate("DATAFINE"),"?",0,0)+">="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatini)+"  and  "+CPLib.ToSQL(Cursor_hntestit.GetDate("DATAFINE"),"?",0,0)+"<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatfin,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatfin)+" "+")"+(m_Ctx.IsSharedTemp("wntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_wntestit;
            Cursor_wntestit.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_stor_trasf: query on wntestit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_wntestit.Eof())) {
            _mc_intestit.AppendBlank();
            _mc_intestit.row.CODCLI = Cursor_wntestit.GetString("CODCLI");
            _mc_intestit.row.RAPPORTO = Cursor_wntestit.GetString("RAPPORTO");
            _mc_intestit.row.CODINTER = Cursor_wntestit.GetString("CODINTER");
            _mc_intestit.row.DESCINTER = Cursor_wntestit.GetString("DESCINTER");
            _mc_intestit.row.DATAINI = Cursor_wntestit.GetDate("DATAINI");
            _mc_intestit.row.TIPORAP = Cursor_wntestit.GetString("TIPORAP");
            _mc_intestit.row.TIPOPERS = Cursor_wntestit.GetString("TIPOPERS");
            _mc_intestit.row.STATOREG = Cursor_wntestit.GetString("STATOREG");
            _mc_intestit.row.OPERAZMOD = Cursor_wntestit.GetString("OPERAZMOD");
            _mc_intestit.row.DATARETT = Cursor_wntestit.GetDate("DATARETT");
            _mc_intestit.row.IDEREG = Cursor_wntestit.GetString("IDEREG");
            _mc_intestit.row.COLLEGAMEN = Cursor_wntestit.GetString("COLLEGAMEN");
            _mc_intestit.row.DATAFINE = Cursor_wntestit.GetDate("DATAFINE");
            _mc_intestit.row.NUMPROG1 = Cursor_wntestit.GetString("NUMPROG1");
            _mc_intestit.row.NUMPROG2 = Cursor_wntestit.GetString("NUMPROG2");
            _mc_intestit.row.IDBASE = Cursor_wntestit.GetString("IDBASE");
            _mc_intestit.row.UCODE = Cursor_wntestit.GetString("UCODE");
            _mc_intestit.row.ABBINATO = Cursor_wntestit.GetDouble("ABBINATO");
            _mc_intestit.row.PRGIMPTITE = Cursor_wntestit.GetDouble("PRGIMPTITE");
            _mc_intestit.row.NUMIMP = Cursor_wntestit.GetDateTime("NUMIMP");
            _mc_intestit.row.NOAGE = Cursor_wntestit.GetString("NOAGE");
            Cursor_wntestit.Next();
          }
          m_cConnectivityError = Cursor_wntestit.ErrorMessage();
          Cursor_wntestit.Close();
          _mc_intestit.GoTop();
          for (MemoryCursorRow_intestit rw_wntestino : _mc_intestit._iterable_()) {
            /* gMsgImp := "Analisi del legame del soggetto: "+rw_wntestino.CODINTER */
            gMsgImp = "Analisi del legame del soggetto: "+rw_wntestino.CODINTER;
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* Aggiungo i Soggetti a quelli da controllare (eventuale penzoloni) */
            /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(rw_wntestino.CODINTER) */
            add_sogg_mc(rw_wntestino.CODINTER);
            /* Exec "Aggiungi sogg all'MC" Page 6:add_sogg_mc(rw_wntestino.CODCLI) */
            add_sogg_mc(rw_wntestino.CODCLI);
            /* If At(w_stampa,'|E|S') <> 0 */
            if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
              // * --- Delete from hntestit
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("hntestit");
              m_cPhName = m_Ctx.GetPhName("hntestit");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"hntestit",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"000005F5")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_wntestino.IDBASE,"?",0,0,m_cServer),m_cServer,rw_wntestino.IDBASE)+"";
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
            /* _contarow := _contarow+1 */
            _contarow = CPLib.Round(_contarow+1,0);
            // * --- Fill memory cursor _mc_rapotit on hapotit
            _mc_rapotit.Zap();
            m_cServer = m_Ctx.GetServer("hapotit");
            m_cPhName = m_Ctx.GetPhName("hapotit");
            if (Cursor_hapotit!=null)
              Cursor_hapotit.Close();
            Cursor_hapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_wntestino.CODCLI,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_wntestino.CODCLI)+" "+")"+(m_Ctx.IsSharedTemp("hapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_hapotit;
              Cursor_hapotit.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_stor_trasf: query on hapotit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_hapotit.Eof())) {
              _mc_rapotit.AppendBlank();
              _mc_rapotit.row.IDBASE = Cursor_hapotit.GetString("IDBASE");
              _mc_rapotit.row.DATAOPE = Cursor_hapotit.GetDate("DATAOPE");
              _mc_rapotit.row.NUMPROG = Cursor_hapotit.GetString("NUMPROG");
              _mc_rapotit.row.TIPOINTER = Cursor_hapotit.GetString("TIPOINTER");
              _mc_rapotit.row.CODINTER = Cursor_hapotit.GetString("CODINTER");
              _mc_rapotit.row.TIPOINF = Cursor_hapotit.GetString("TIPOINF");
              _mc_rapotit.row.IDEREG = Cursor_hapotit.GetString("IDEREG");
              _mc_rapotit.row.CODDIPE = Cursor_hapotit.GetString("CODDIPE");
              _mc_rapotit.row.DESCCIT = Cursor_hapotit.GetString("DESCCIT");
              _mc_rapotit.row.PROVINCIA = Cursor_hapotit.GetString("PROVINCIA");
              _mc_rapotit.row.CODCAB = Cursor_hapotit.GetString("CODCAB");
              _mc_rapotit.row.FLAGFRAZ = Cursor_hapotit.GetString("FLAGFRAZ");
              _mc_rapotit.row.FLAGCONT = Cursor_hapotit.GetString("FLAGCONT");
              _mc_rapotit.row.CODANA = Cursor_hapotit.GetString("CODANA");
              _mc_rapotit.row.CODVOC = Cursor_hapotit.GetString("CODVOC");
              _mc_rapotit.row.TIPOINT2 = Cursor_hapotit.GetString("TIPOINT2");
              _mc_rapotit.row.CODINT2 = Cursor_hapotit.GetString("CODINT2");
              _mc_rapotit.row.PAESE = Cursor_hapotit.GetString("PAESE");
              _mc_rapotit.row.DESC2 = Cursor_hapotit.GetString("DESC2");
              _mc_rapotit.row.PROV2 = Cursor_hapotit.GetString("PROV2");
              _mc_rapotit.row.CODCAB2 = Cursor_hapotit.GetString("CODCAB2");
              _mc_rapotit.row.DESCINTER = Cursor_hapotit.GetString("DESCINTER");
              _mc_rapotit.row.RAPPORTO = Cursor_hapotit.GetString("RAPPORTO");
              _mc_rapotit.row.FLAGRAP = Cursor_hapotit.GetString("FLAGRAP");
              _mc_rapotit.row.TIPOLEG = Cursor_hapotit.GetString("TIPOLEG");
              _mc_rapotit.row.DATAREG = Cursor_hapotit.GetDate("DATAREG");
              _mc_rapotit.row.OPRAP = Cursor_hapotit.GetString("OPRAP");
              _mc_rapotit.row.TIPOOPRAP = Cursor_hapotit.GetString("TIPOOPRAP");
              _mc_rapotit.row.FLAGLIRE = Cursor_hapotit.GetString("FLAGLIRE");
              _mc_rapotit.row.VALUTA = Cursor_hapotit.GetString("VALUTA");
              _mc_rapotit.row.SEGNO = Cursor_hapotit.GetString("SEGNO");
              _mc_rapotit.row.TOTLIRE = Cursor_hapotit.GetDouble("TOTLIRE");
              _mc_rapotit.row.TOTCONT = Cursor_hapotit.GetDouble("TOTCONT");
              _mc_rapotit.row.STATOREG = Cursor_hapotit.GetString("STATOREG");
              _mc_rapotit.row.OPERAZMOD = Cursor_hapotit.GetString("OPERAZMOD");
              _mc_rapotit.row.DATARETT = Cursor_hapotit.GetDate("DATARETT");
              _mc_rapotit.row.CONNESCLI = Cursor_hapotit.GetString("CONNESCLI");
              _mc_rapotit.row.CONNESOPER = Cursor_hapotit.GetString("CONNESOPER");
              _mc_rapotit.row.CONNESBEN = Cursor_hapotit.GetString("CONNESBEN");
              _mc_rapotit.row.COLLEG = Cursor_hapotit.GetString("COLLEG");
              _mc_rapotit.row.CAMBIO = Cursor_hapotit.GetDouble("CAMBIO");
              _mc_rapotit.row.RAPPORTBEN = Cursor_hapotit.GetString("RAPPORTBEN");
              _mc_rapotit.row.FLAGRAP2 = Cursor_hapotit.GetString("FLAGRAP2");
              _mc_rapotit.row.OPERATORE = Cursor_hapotit.GetString("OPERATORE");
              _mc_rapotit.row.AUTOM = Cursor_hapotit.GetString("AUTOM");
              _mc_rapotit.row.RESPINS = Cursor_hapotit.GetString("RESPINS");
              _mc_rapotit.row.INFORM = Cursor_hapotit.GetString("INFORM");
              _mc_rapotit.row.DATAAGE = Cursor_hapotit.GetDate("DATAAGE");
              _mc_rapotit.row.UCODE = Cursor_hapotit.GetString("UCODE");
              _mc_rapotit.row.PRGIMPTIT = Cursor_hapotit.GetDouble("PRGIMPTIT");
              _mc_rapotit.row.CDATOPE = Cursor_hapotit.GetString("CDATOPE");
              _mc_rapotit.row.UNIQUECODE = Cursor_hapotit.GetString("UNIQUECODE");
              _mc_rapotit.row.CDATREG = Cursor_hapotit.GetString("CDATREG");
              _mc_rapotit.row.IDBASE2 = Cursor_hapotit.GetString("IDBASE2");
              _mc_rapotit.row.NUMIMP = Cursor_hapotit.GetDateTime("NUMIMP");
              Cursor_hapotit.Next();
            }
            m_cConnectivityError = Cursor_hapotit.ErrorMessage();
            Cursor_hapotit.Close();
            _mc_rapotit.GoTop();
            for (MemoryCursorRow_rapotit rw_wapotitte : _mc_rapotit._iterable_()) {
              /* Cerco dei titolari in base al NUMPROG */
              /* _isThereInfo := False */
              _isThereInfo = false;
              // * --- Select from hntestit
              m_cServer = m_Ctx.GetServer("hntestit");
              m_cPhName = m_Ctx.GetPhName("hntestit");
              if (Cursor_hntestit!=null)
                Cursor_hntestit.Close();
              Cursor_hntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_wapotitte.NUMPROG,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_wapotitte.NUMPROG)+"=NUMPROG1  or  "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_wapotitte.NUMPROG,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_wapotitte.NUMPROG)+"=NUMPROG2 "+")"+(m_Ctx.IsSharedTemp("hntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_hntestit.Eof())) {
                /* Ci sono ancora titolari */
                /* _isThereInfo := True */
                _isThereInfo = true;
                Cursor_hntestit.Next();
              }
              m_cConnectivityError = Cursor_hntestit.ErrorMessage();
              Cursor_hntestit.Close();
              // * --- End Select
              /* If not(_isThereInfo) */
              if ( ! (_isThereInfo)) {
                /* Se l'informazione NON ha più titolari associati la cancello */
                /* If At(w_stampa,'|E|S') <> 0 */
                if (CPLib.ne(CPLib.At(w_stampa,"|E|S"),0)) {
                  // * --- Delete from hapotit
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("hapotit");
                  m_cPhName = m_Ctx.GetPhName("hapotit");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"hapotit",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stor_trasf",363,"00000601")+"delete from "+m_oWrInfo.GetTableWriteName();
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_wapotitte.IDBASE,"?",0,0,m_cServer),m_cServer,rw_wapotitte.IDBASE)+"";
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
                /* _contaop := _contaop+1 */
                _contaop = CPLib.Round(_contaop+1,0);
              } // End If
            }
          }
        } // End If
        /* gMsgProc := gMsgProc+"Numero di legami di titolari cancellati/trasferiti: "+Str(_contarow,10,0)+NL // Messaggio */
        gMsgProc = gMsgProc+"Numero di legami di titolari cancellati/trasferiti: "+CPLib.Str(_contarow,10,0)+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc+"Numero di informazioni di titolari cancellati/trasferiti: "+Str(_contaop,10,0)+NL // Messaggio */
        gMsgProc = gMsgProc+"Numero di informazioni di titolari cancellati/trasferiti: "+CPLib.Str(_contaop,10,0)+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc+"Non sono presenti informazioni nel periodo selezionato"+NL // Messaggio */
        gMsgProc = gMsgProc+"Non sono presenti informazioni nel periodo selezionato"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc+"Fine analisi dei legami di titolarità tra i soggetti"+NL // Messaggio */
      gMsgProc = gMsgProc+"Fine analisi dei legami di titolarità tra i soggetti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_jntestit!=null)
          Cursor_jntestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_hntestit!=null)
          Cursor_hntestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_japotit!=null)
          Cursor_japotit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_hapotit!=null)
          Cursor_hapotit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wntestit!=null)
          Cursor_wntestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_chi_chiama_la_routine,String p_w_tipoope,boolean p_w_anag_colleg,String p_w_stampa,java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,java.sql.Date p_w_today_caller,String p_w_chkAUI,String p_w_chkAGE) {
    w_chi_chiama_la_routine = p_w_chi_chiama_la_routine;
    w_tipoope = p_w_tipoope;
    w_anag_colleg = p_w_anag_colleg;
    w_stampa = p_w_stampa;
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_today_caller = p_w_today_caller;
    w_chkAUI = p_w_chkAUI;
    w_chkAGE = p_w_chkAGE;
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
  public String Run(String p_w_chi_chiama_la_routine,String p_w_tipoope,boolean p_w_anag_colleg,String p_w_stampa,java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,java.sql.Date p_w_today_caller,String p_w_chkAUI,String p_w_chkAGE) {
    w_chi_chiama_la_routine = p_w_chi_chiama_la_routine;
    w_tipoope = p_w_tipoope;
    w_anag_colleg = p_w_anag_colleg;
    w_stampa = p_w_stampa;
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_today_caller = p_w_today_caller;
    w_chkAUI = p_w_chkAUI;
    w_chkAGE = p_w_chkAGE;
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
          page1();
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
  public static arrt_stor_trasfR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stor_trasfR(p_Ctx, p_Caller);
  }
  public static arrt_stor_trasfR Make(CPContext p_Ctx) {
    return new arrt_stor_trasfR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_chi_chiama_la_routine = CPLib.Space(0);
    w_tipoope = CPLib.Space(1);
    w_anag_colleg = false;
    w_stampa = CPLib.Space(1);
    w_DaDatOpe = CPLib.NullDate();
    w_ADatOpe = CPLib.NullDate();
    w_today_caller = CPLib.NullDate();
    w_chkAUI = CPLib.Space(8);
    w_chkAGE = CPLib.Space(8);
    w_dadata = CPLib.NullDate();
    w_adata = CPLib.NullDate();
    _cdatini = CPLib.Space(8);
    _cdatfin = CPLib.Space(8);
    _cdataoggi = CPLib.Space(8);
    _cdatafine = CPLib.Space(10);
    _ddatini = CPLib.NullDate();
    _ddatfin = CPLib.NullDate();
    _dataoggi = CPLib.NullDate();
    _errore = CPLib.Space(1);
    _contaop = 0;
    _contarow = 0;
    _oldmsg = "";
    _stringa_appoggio = "";
    operfraz = CPLib.Space(0);
    w_codrap = CPLib.Space(25);
    w_numrec = 0;
    _today = CPLib.NullDate();
    _isThereSomething = false;
    _isThereInfo = false;
    _mc_operazioni = new MemoryCursor_mcopefrazstorico_mcrdef();
    _mc_frazionate = new MemoryCursor_mcopefrazstorico_mcrdef();
    _mc_rapporti = new MemoryCursor_qbe_storrap_vqr();
    _mc_soggetti_pf = new MemoryCursor_mcpersonstorico_mcrdef();
    _mc_soggetti_pnf = new MemoryCursor_mcpersonstorico_mcrdef();
    _mc_intestit = new MemoryCursor_intestit();
    _mc_rapotit = new MemoryCursor_rapotit();
    fhand = CPLib.Space(1);
    riga = "";
    nFile = CPLib.Space(20);
    outFileName = CPLib.Space(30);
    _paese = CPLib.Space(2);
    _prov = CPLib.Space(3);
    _segno = CPLib.Space(3);
    _nfile = CPLib.Space(120);
    _impope = CPLib.Space(15);
    _numope = CPLib.Space(10);
    _tot = 0;
    _nomeFile = CPLib.Space(0);
    _str_init = CPLib.Space(0);
    _str_init_1 = CPLib.Space(0);
    rowTabelle = new MemoryCursorRow_mctabelle_mcrdef();
    _pers_count_pf = CPLib.Round(0,0);
    _pers_count_pnf = CPLib.Round(0,0);
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gDatDel=m_Ctx.GetGlobalDate("gDatDel");
    gDatTra=m_Ctx.GetGlobalDate("gDatTra");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_storope,qbe_storwpe,qbe_storfraz,qbe_storfraz1,qbe_storwraz,qbe_storrap,qbe_storwap,qbe_storrap,qbe_storrap2,qbe_storrap1,qbe_storwap,qbe_storwap2,qbe_storwap1,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_storope_age,qbe_storhpe,qbe_storjap,qbe_storwap,qbe_storjap,qbe_storjap2,qbe_storjap1,qbe_storwap,qbe_storwap2,qbe_storwap1,
  public static final String m_cVQRList = ",qbe_storope,qbe_storwpe,qbe_storfraz,qbe_storfraz1,qbe_storwraz,qbe_storrap,qbe_storwap,qbe_storrap,qbe_storrap2,qbe_storrap1,qbe_storwap,qbe_storwap2,qbe_storwap1,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_storope_age,qbe_storhpe,qbe_storjap,qbe_storwap,qbe_storjap,qbe_storjap2,qbe_storjap1,qbe_storwap,qbe_storwap2,qbe_storwap1,";
  // ENTITY_BATCHES: ,arfn_datesum,arfn_fdate,arfn_fdatetime,arrt_stor_trasf,
  public static final String i_InvokedRoutines = ",arfn_datesum,arfn_fdate,arfn_fdatetime,arrt_stor_trasf,";
  public static String[] m_cRunParameterNames={"w_chi_chiama_la_routine","w_tipoope","w_anag_colleg","w_stampa","w_DaDatOpe","w_ADatOpe","w_today_caller","w_chkAUI","w_chkAGE"};
  protected static String GetFieldsName_00000120(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"ANNOOPE,";
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
    p_cSql = p_cSql+"DAC6,";
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
    p_cSql = p_cSql+"FLAGDAC6,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"IMPSARA,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MITGDOC,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NOSARA,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROQUOTA,";
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
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"SV58550,";
    p_cSql = p_cSql+"SV58550MA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TIPOORO,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000123(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000126(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wlientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000129(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"weneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000012C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"werzistiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000016E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wogopefbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000171(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wlientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000174(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"weneficfrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000177(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"werzistifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001D6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CONTINUA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"TIPMOD,";
    p_cSql = p_cSql+"DATAMOD,";
    p_cSql = p_cSql+"IDRAPPORTO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPRAP,";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"IMPAPE,";
    p_cSql = p_cSql+"IMPCHIU,";
    p_cSql = p_cSql+"SPLITCODE,";
    p_cSql = p_cSql+"MACODICE,";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"STATORAP,";
    p_cSql = p_cSql+"CASTATOC,";
    p_cSql = p_cSql+"CASTATOM,";
    p_cSql = p_cSql+"CODICELR,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITGDOC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001D9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001DB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001DD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"woginfo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001DF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"NOAGE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"welegabo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001E1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fiduciabo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001E3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"warantbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001E5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"TRIMESTRE,";
    p_cSql = p_cSql+"IMPORTO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"waldi_idp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000406(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"PRGIMPTITE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODCLI,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestit",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000040F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
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
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPTIT,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wapotit",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000533(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"ANNOOPE,";
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
    p_cSql = p_cSql+"IMPIN,";
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"hperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000535(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"hogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000573(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CONTINUA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"TIPMOD,";
    p_cSql = p_cSql+"DATAMOD,";
    p_cSql = p_cSql+"IDRAPPORTO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPRAP,";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"IMPAPE,";
    p_cSql = p_cSql+"IMPCHIU,";
    p_cSql = p_cSql+"SPLITCODE,";
    p_cSql = p_cSql+"MACODICE,";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"STATORAP,";
    p_cSql = p_cSql+"CASTATOC,";
    p_cSql = p_cSql+"CASTATOM,";
    p_cSql = p_cSql+"CODICELR,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITGDOC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"hnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000576(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"hapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000578(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"hntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000057A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"hoginfo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000057C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+"NOAGE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"helegabo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000057E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"harantbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000005D4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"PRGIMPTITE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"NUMPROG2,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODCLI,";
    p_cSql = p_cSql+"ABBINATO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"hntestit",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000005DD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
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
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAAGE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPTIT,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"hapotit",true);
    return p_cSql;
  }
}
