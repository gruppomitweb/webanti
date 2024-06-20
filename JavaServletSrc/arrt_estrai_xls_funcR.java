// * --- Area Manuale = BO - Header
// * --- arrt_estrai_xls_func
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
public class arrt_estrai_xls_funcR implements CallerWithObjs {
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
  public String m_cPhName_docfrabo;
  public String m_cServer_docfrabo;
  public String m_cPhName_dw_operazioni;
  public String m_cServer_dw_operazioni;
  public String m_cPhName_kersonbo;
  public String m_cServer_kersonbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tbtipdoc;
  public String m_cServer_tbtipdoc;
  public String m_cPhName_tmp_mtcn_cf;
  public String m_cServer_tmp_mtcn_cf;
  public String m_cPhName_tmp_newpers;
  public String m_cServer_tmp_newpers;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public String m_cPhName_tbcausin;
  public String m_cServer_tbcausin;
  public String m_cPhName_tbtipreg;
  public String m_cServer_tbtipreg;
  public String m_cPhName_processi;
  public String m_cServer_processi;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
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
  public MemoryCursor_mcparametri_mcrdef pmcParametri;
  public String pAzienda;
  public String pPath;
  public String gMsgImp;
  public String gFileName;
  public String gFlgWU;
  public String gUrlApp;
  public String _gPathApp;
  public String _gAzienda;
  public String fhand;
  public String filenome;
  public double righe;
  public String cell01;
  public String column01;
  public double cell_count;
  public double riga_letta;
  public String _file;
  public java.sql.Date _dadata;
  public java.sql.Date _a_data;
  public String prova;
  public String foglio;
  public String _nfile;
  public String stringa;
  public String numero;
  public String dData;
  public String dataoggi;
  public String numprog;
  public String datareg;
  public java.sql.Date _datareg;
  public String dataope;
  public java.sql.Date _dataope;
  public String f_datope;
  public String f_datnas;
  public String f_datreg;
  public String tipope;
  public String cauana;
  public String causin;
  public String segno;
  public String valuta;
  public String divisa;
  public double cambio;
  public double totimp;
  public double totcon;
  public String codfisc;
  public String nominativo;
  public String indirizzo;
  public String citres;
  public String capres;
  public String prvres;
  public String stares;
  public String citnas;
  public String prvnas;
  public String stanas;
  public String sesso;
  public String datnas;
  public java.sql.Date _datnas;
  public String tipdoc;
  public String autril;
  public String numdoc;
  public String datril;
  public java.sql.Date _datril;
  public String _testa;
  public String _agetesta;
  public String _sqr;
  public String _coddip;
  public String _namdip;
  public String _citdip;
  public String _nomman;
  public String _cogman;
  public String _nazben;
  public String _luonas;
  public String _tipdoc;
  public String _numdoc;
  public String f_datdoc;
  public String _autril;
  public String _numprog;
  public String _mtcn;
  public String _macage;
  public String _stator;
  public String _rapporto;
  public double riga;
  public String _ndg;
  public String _cfestero;
  public String _numsto;
  public double _ctot;
  public String cNomeFile;
  public String cNomeFileZip;
  public java.sql.Date _datadoc;
  public double _max;
  public double _min;
  public double _tot;
  public double _mono;
  public double _cicli;
  public double _contacicli;
  public double _bottom;
  public double _top;
  public String _mstato;
  public String _rifimp;
  public String _rifimp2;
  public String _connesdoc;
  public java.sql.Date _datarett;
  public String _dcauana;
  public String _dcausin;
  public String _dpaeseres;
  public String _dpaesedes;
  public String _dtipoope;
  public String _dstator;
  public String prcProg;
  public String cOutput;
  public String _codstar;
  public double _totgen;
  public String fmhand;
  public String _file1;
  public String _file2;
  public double _totalone;
  public String _orgdati;
  public String _codinter;
  public MemoryCursor_anadip mcANADIP;
  public MemoryCursorRow_anadip rowANADIP;
  public String _prvdip;
  public String _cabdip;
  public String _inddip;
  public String _cfromdate;
  public String _c_todate;
  public String _nomefile;
  public String _ragsoc;
  public double _importo;
  public String _ajwcode;
  public java.sql.Date _datasto;
  public java.sql.Date _datascad;
  public String _fdtscad;
  public String _iban;
  public MemoryCursor_tbstati mcTBSTATI;
  public MemoryCursor_tbcauana mcTBCAUANA;
  public MemoryCursor_tbcausin mcTBCAUSIN;
  public MemoryCursor_tbtipdoc mcTBTIPDOC;
  public MemoryCursor_tbtipreg mcTBTIPREG;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_estrai_xls_func
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
  public CSVWriter cwriter;
  Vector filenames = new Vector();
  Vector fileonames = new Vector();
  // * --- Fine Area Manuale
  public arrt_estrai_xls_funcR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_estrai_xls_func",m_Caller);
    m_cPhName_docfrabo = p_ContextObject.GetPhName("docfrabo");
    if (m_cPhName_docfrabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_docfrabo = m_cPhName_docfrabo+" "+m_Ctx.GetWritePhName("docfrabo");
    }
    m_cServer_docfrabo = p_ContextObject.GetServer("docfrabo");
    m_cPhName_dw_operazioni = p_ContextObject.GetPhName("dw_operazioni");
    if (m_cPhName_dw_operazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_dw_operazioni = m_cPhName_dw_operazioni+" "+m_Ctx.GetWritePhName("dw_operazioni");
    }
    m_cServer_dw_operazioni = p_ContextObject.GetServer("dw_operazioni");
    m_cPhName_kersonbo = p_ContextObject.GetPhName("kersonbo");
    if (m_cPhName_kersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_kersonbo = m_cPhName_kersonbo+" "+m_Ctx.GetWritePhName("kersonbo");
    }
    m_cServer_kersonbo = p_ContextObject.GetServer("kersonbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_tbtipdoc = p_ContextObject.GetPhName("tbtipdoc");
    if (m_cPhName_tbtipdoc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipdoc = m_cPhName_tbtipdoc+" "+m_Ctx.GetWritePhName("tbtipdoc");
    }
    m_cServer_tbtipdoc = p_ContextObject.GetServer("tbtipdoc");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_mtcn_cf")) {
      m_cPhName_tmp_mtcn_cf = p_ContextObject.GetPhName("tmp_mtcn_cf");
      if (m_cPhName_tmp_mtcn_cf.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_mtcn_cf = m_cPhName_tmp_mtcn_cf+" "+m_Ctx.GetWritePhName("tmp_mtcn_cf");
      }
      m_cServer_tmp_mtcn_cf = p_ContextObject.GetServer("tmp_mtcn_cf");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_newpers")) {
      m_cPhName_tmp_newpers = p_ContextObject.GetPhName("tmp_newpers");
      if (m_cPhName_tmp_newpers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_newpers = m_cPhName_tmp_newpers+" "+m_Ctx.GetWritePhName("tmp_newpers");
      }
      m_cServer_tmp_newpers = p_ContextObject.GetServer("tmp_newpers");
    }
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_tbcauana = p_ContextObject.GetPhName("tbcauana");
    if (m_cPhName_tbcauana.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcauana = m_cPhName_tbcauana+" "+m_Ctx.GetWritePhName("tbcauana");
    }
    m_cServer_tbcauana = p_ContextObject.GetServer("tbcauana");
    m_cPhName_tbcausin = p_ContextObject.GetPhName("tbcausin");
    if (m_cPhName_tbcausin.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcausin = m_cPhName_tbcausin+" "+m_Ctx.GetWritePhName("tbcausin");
    }
    m_cServer_tbcausin = p_ContextObject.GetServer("tbcausin");
    m_cPhName_tbtipreg = p_ContextObject.GetPhName("tbtipreg");
    if (m_cPhName_tbtipreg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipreg = m_cPhName_tbtipreg+" "+m_Ctx.GetWritePhName("tbtipreg");
    }
    m_cServer_tbtipreg = p_ContextObject.GetServer("tbtipreg");
    m_cPhName_processi = p_ContextObject.GetPhName("processi");
    if (m_cPhName_processi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_processi = m_cPhName_processi+" "+m_Ctx.GetWritePhName("processi");
    }
    m_cServer_processi = p_ContextObject.GetServer("processi");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("righe",p_cVarName)) {
      return righe;
    }
    if (CPLib.eqr("cell_count",p_cVarName)) {
      return cell_count;
    }
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      return riga_letta;
    }
    if (CPLib.eqr("cambio",p_cVarName)) {
      return cambio;
    }
    if (CPLib.eqr("totimp",p_cVarName)) {
      return totimp;
    }
    if (CPLib.eqr("totcon",p_cVarName)) {
      return totcon;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("_ctot",p_cVarName)) {
      return _ctot;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      return _contacicli;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_totgen",p_cVarName)) {
      return _totgen;
    }
    if (CPLib.eqr("_totalone",p_cVarName)) {
      return _totalone;
    }
    if (CPLib.eqr("_importo",p_cVarName)) {
      return _importo;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_estrai_xls_func";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pAzienda",p_cVarName)) {
      return pAzienda;
    }
    if (CPLib.eqr("pPath",p_cVarName)) {
      return pPath;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gFileName",p_cVarName)) {
      return gFileName;
    }
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      return gFlgWU;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("_gPathApp",p_cVarName)) {
      return _gPathApp;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      return _gAzienda;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("filenome",p_cVarName)) {
      return filenome;
    }
    if (CPLib.eqr("cell01",p_cVarName)) {
      return cell01;
    }
    if (CPLib.eqr("column01",p_cVarName)) {
      return column01;
    }
    if (CPLib.eqr("_file",p_cVarName)) {
      return _file;
    }
    if (CPLib.eqr("prova",p_cVarName)) {
      return prova;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      return foglio;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      return _nfile;
    }
    if (CPLib.eqr("stringa",p_cVarName)) {
      return stringa;
    }
    if (CPLib.eqr("numero",p_cVarName)) {
      return numero;
    }
    if (CPLib.eqr("dData",p_cVarName)) {
      return dData;
    }
    if (CPLib.eqr("dataoggi",p_cVarName)) {
      return dataoggi;
    }
    if (CPLib.eqr("numprog",p_cVarName)) {
      return numprog;
    }
    if (CPLib.eqr("datareg",p_cVarName)) {
      return datareg;
    }
    if (CPLib.eqr("dataope",p_cVarName)) {
      return dataope;
    }
    if (CPLib.eqr("f_datope",p_cVarName)) {
      return f_datope;
    }
    if (CPLib.eqr("f_datnas",p_cVarName)) {
      return f_datnas;
    }
    if (CPLib.eqr("f_datreg",p_cVarName)) {
      return f_datreg;
    }
    if (CPLib.eqr("tipope",p_cVarName)) {
      return tipope;
    }
    if (CPLib.eqr("cauana",p_cVarName)) {
      return cauana;
    }
    if (CPLib.eqr("causin",p_cVarName)) {
      return causin;
    }
    if (CPLib.eqr("segno",p_cVarName)) {
      return segno;
    }
    if (CPLib.eqr("valuta",p_cVarName)) {
      return valuta;
    }
    if (CPLib.eqr("divisa",p_cVarName)) {
      return divisa;
    }
    if (CPLib.eqr("codfisc",p_cVarName)) {
      return codfisc;
    }
    if (CPLib.eqr("nominativo",p_cVarName)) {
      return nominativo;
    }
    if (CPLib.eqr("indirizzo",p_cVarName)) {
      return indirizzo;
    }
    if (CPLib.eqr("citres",p_cVarName)) {
      return citres;
    }
    if (CPLib.eqr("capres",p_cVarName)) {
      return capres;
    }
    if (CPLib.eqr("prvres",p_cVarName)) {
      return prvres;
    }
    if (CPLib.eqr("stares",p_cVarName)) {
      return stares;
    }
    if (CPLib.eqr("citnas",p_cVarName)) {
      return citnas;
    }
    if (CPLib.eqr("prvnas",p_cVarName)) {
      return prvnas;
    }
    if (CPLib.eqr("stanas",p_cVarName)) {
      return stanas;
    }
    if (CPLib.eqr("sesso",p_cVarName)) {
      return sesso;
    }
    if (CPLib.eqr("datnas",p_cVarName)) {
      return datnas;
    }
    if (CPLib.eqr("tipdoc",p_cVarName)) {
      return tipdoc;
    }
    if (CPLib.eqr("autril",p_cVarName)) {
      return autril;
    }
    if (CPLib.eqr("numdoc",p_cVarName)) {
      return numdoc;
    }
    if (CPLib.eqr("datril",p_cVarName)) {
      return datril;
    }
    if (CPLib.eqr("_testa",p_cVarName)) {
      return _testa;
    }
    if (CPLib.eqr("_agetesta",p_cVarName)) {
      return _agetesta;
    }
    if (CPLib.eqr("_sqr",p_cVarName)) {
      return _sqr;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      return _coddip;
    }
    if (CPLib.eqr("_namdip",p_cVarName)) {
      return _namdip;
    }
    if (CPLib.eqr("_citdip",p_cVarName)) {
      return _citdip;
    }
    if (CPLib.eqr("_nomman",p_cVarName)) {
      return _nomman;
    }
    if (CPLib.eqr("_cogman",p_cVarName)) {
      return _cogman;
    }
    if (CPLib.eqr("_nazben",p_cVarName)) {
      return _nazben;
    }
    if (CPLib.eqr("_luonas",p_cVarName)) {
      return _luonas;
    }
    if (CPLib.eqr("_tipdoc",p_cVarName)) {
      return _tipdoc;
    }
    if (CPLib.eqr("_numdoc",p_cVarName)) {
      return _numdoc;
    }
    if (CPLib.eqr("f_datdoc",p_cVarName)) {
      return f_datdoc;
    }
    if (CPLib.eqr("_autril",p_cVarName)) {
      return _autril;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      return _numprog;
    }
    if (CPLib.eqr("_mtcn",p_cVarName)) {
      return _mtcn;
    }
    if (CPLib.eqr("_macage",p_cVarName)) {
      return _macage;
    }
    if (CPLib.eqr("_stator",p_cVarName)) {
      return _stator;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_ndg",p_cVarName)) {
      return _ndg;
    }
    if (CPLib.eqr("_cfestero",p_cVarName)) {
      return _cfestero;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      return _numsto;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      return cNomeFile;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      return cNomeFileZip;
    }
    if (CPLib.eqr("_mstato",p_cVarName)) {
      return _mstato;
    }
    if (CPLib.eqr("_rifimp",p_cVarName)) {
      return _rifimp;
    }
    if (CPLib.eqr("_rifimp2",p_cVarName)) {
      return _rifimp2;
    }
    if (CPLib.eqr("_connesdoc",p_cVarName)) {
      return _connesdoc;
    }
    if (CPLib.eqr("_dcauana",p_cVarName)) {
      return _dcauana;
    }
    if (CPLib.eqr("_dcausin",p_cVarName)) {
      return _dcausin;
    }
    if (CPLib.eqr("_dpaeseres",p_cVarName)) {
      return _dpaeseres;
    }
    if (CPLib.eqr("_dpaesedes",p_cVarName)) {
      return _dpaesedes;
    }
    if (CPLib.eqr("_dtipoope",p_cVarName)) {
      return _dtipoope;
    }
    if (CPLib.eqr("_dstator",p_cVarName)) {
      return _dstator;
    }
    if (CPLib.eqr("prcProg",p_cVarName)) {
      return prcProg;
    }
    if (CPLib.eqr("cOutput",p_cVarName)) {
      return cOutput;
    }
    if (CPLib.eqr("_codstar",p_cVarName)) {
      return _codstar;
    }
    if (CPLib.eqr("fmhand",p_cVarName)) {
      return fmhand;
    }
    if (CPLib.eqr("_file1",p_cVarName)) {
      return _file1;
    }
    if (CPLib.eqr("_file2",p_cVarName)) {
      return _file2;
    }
    if (CPLib.eqr("_orgdati",p_cVarName)) {
      return _orgdati;
    }
    if (CPLib.eqr("_codinter",p_cVarName)) {
      return _codinter;
    }
    if (CPLib.eqr("_prvdip",p_cVarName)) {
      return _prvdip;
    }
    if (CPLib.eqr("_cabdip",p_cVarName)) {
      return _cabdip;
    }
    if (CPLib.eqr("_inddip",p_cVarName)) {
      return _inddip;
    }
    if (CPLib.eqr("_cfromdate",p_cVarName)) {
      return _cfromdate;
    }
    if (CPLib.eqr("_c_todate",p_cVarName)) {
      return _c_todate;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      return _ragsoc;
    }
    if (CPLib.eqr("_ajwcode",p_cVarName)) {
      return _ajwcode;
    }
    if (CPLib.eqr("_fdtscad",p_cVarName)) {
      return _fdtscad;
    }
    if (CPLib.eqr("_iban",p_cVarName)) {
      return _iban;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_dadata",p_cVarName)) {
      return _dadata;
    }
    if (CPLib.eqr("_a_data",p_cVarName)) {
      return _a_data;
    }
    if (CPLib.eqr("_datareg",p_cVarName)) {
      return _datareg;
    }
    if (CPLib.eqr("_dataope",p_cVarName)) {
      return _dataope;
    }
    if (CPLib.eqr("_datnas",p_cVarName)) {
      return _datnas;
    }
    if (CPLib.eqr("_datril",p_cVarName)) {
      return _datril;
    }
    if (CPLib.eqr("_datadoc",p_cVarName)) {
      return _datadoc;
    }
    if (CPLib.eqr("_datarett",p_cVarName)) {
      return _datarett;
    }
    if (CPLib.eqr("_datasto",p_cVarName)) {
      return _datasto;
    }
    if (CPLib.eqr("_datascad",p_cVarName)) {
      return _datascad;
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
    if (CPLib.eqr("pmcParametri",p_cVarName)) {
      return pmcParametri;
    }
    if (CPLib.eqr("mcANADIP",p_cVarName)) {
      return mcANADIP;
    }
    if (CPLib.eqr("mcTBSTATI",p_cVarName)) {
      return mcTBSTATI;
    }
    if (CPLib.eqr("mcTBCAUANA",p_cVarName)) {
      return mcTBCAUANA;
    }
    if (CPLib.eqr("mcTBCAUSIN",p_cVarName)) {
      return mcTBCAUSIN;
    }
    if (CPLib.eqr("mcTBTIPDOC",p_cVarName)) {
      return mcTBTIPDOC;
    }
    if (CPLib.eqr("mcTBTIPREG",p_cVarName)) {
      return mcTBTIPREG;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowANADIP",p_cVarName)) {
      return rowANADIP;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("righe",p_cVarName)) {
      righe = value;
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
    if (CPLib.eqr("cambio",p_cVarName)) {
      cambio = value;
      return;
    }
    if (CPLib.eqr("totimp",p_cVarName)) {
      totimp = value;
      return;
    }
    if (CPLib.eqr("totcon",p_cVarName)) {
      totcon = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("_ctot",p_cVarName)) {
      _ctot = value;
      return;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      _mono = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      _contacicli = value;
      return;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
      return;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
      return;
    }
    if (CPLib.eqr("_totgen",p_cVarName)) {
      _totgen = value;
      return;
    }
    if (CPLib.eqr("_totalone",p_cVarName)) {
      _totalone = value;
      return;
    }
    if (CPLib.eqr("_importo",p_cVarName)) {
      _importo = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pAzienda",p_cVarName)) {
      pAzienda = value;
      return;
    }
    if (CPLib.eqr("pPath",p_cVarName)) {
      pPath = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gFileName",p_cVarName)) {
      gFileName = value;
      return;
    }
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      gFlgWU = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("_gPathApp",p_cVarName)) {
      _gPathApp = value;
      return;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      _gAzienda = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("filenome",p_cVarName)) {
      filenome = value;
      return;
    }
    if (CPLib.eqr("cell01",p_cVarName)) {
      cell01 = value;
      return;
    }
    if (CPLib.eqr("column01",p_cVarName)) {
      column01 = value;
      return;
    }
    if (CPLib.eqr("_file",p_cVarName)) {
      _file = value;
      return;
    }
    if (CPLib.eqr("prova",p_cVarName)) {
      prova = value;
      return;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      foglio = value;
      return;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      _nfile = value;
      return;
    }
    if (CPLib.eqr("stringa",p_cVarName)) {
      stringa = value;
      return;
    }
    if (CPLib.eqr("numero",p_cVarName)) {
      numero = value;
      return;
    }
    if (CPLib.eqr("dData",p_cVarName)) {
      dData = value;
      return;
    }
    if (CPLib.eqr("dataoggi",p_cVarName)) {
      dataoggi = value;
      return;
    }
    if (CPLib.eqr("numprog",p_cVarName)) {
      numprog = value;
      return;
    }
    if (CPLib.eqr("datareg",p_cVarName)) {
      datareg = value;
      return;
    }
    if (CPLib.eqr("dataope",p_cVarName)) {
      dataope = value;
      return;
    }
    if (CPLib.eqr("f_datope",p_cVarName)) {
      f_datope = value;
      return;
    }
    if (CPLib.eqr("f_datnas",p_cVarName)) {
      f_datnas = value;
      return;
    }
    if (CPLib.eqr("f_datreg",p_cVarName)) {
      f_datreg = value;
      return;
    }
    if (CPLib.eqr("tipope",p_cVarName)) {
      tipope = value;
      return;
    }
    if (CPLib.eqr("cauana",p_cVarName)) {
      cauana = value;
      return;
    }
    if (CPLib.eqr("causin",p_cVarName)) {
      causin = value;
      return;
    }
    if (CPLib.eqr("segno",p_cVarName)) {
      segno = value;
      return;
    }
    if (CPLib.eqr("valuta",p_cVarName)) {
      valuta = value;
      return;
    }
    if (CPLib.eqr("divisa",p_cVarName)) {
      divisa = value;
      return;
    }
    if (CPLib.eqr("codfisc",p_cVarName)) {
      codfisc = value;
      return;
    }
    if (CPLib.eqr("nominativo",p_cVarName)) {
      nominativo = value;
      return;
    }
    if (CPLib.eqr("indirizzo",p_cVarName)) {
      indirizzo = value;
      return;
    }
    if (CPLib.eqr("citres",p_cVarName)) {
      citres = value;
      return;
    }
    if (CPLib.eqr("capres",p_cVarName)) {
      capres = value;
      return;
    }
    if (CPLib.eqr("prvres",p_cVarName)) {
      prvres = value;
      return;
    }
    if (CPLib.eqr("stares",p_cVarName)) {
      stares = value;
      return;
    }
    if (CPLib.eqr("citnas",p_cVarName)) {
      citnas = value;
      return;
    }
    if (CPLib.eqr("prvnas",p_cVarName)) {
      prvnas = value;
      return;
    }
    if (CPLib.eqr("stanas",p_cVarName)) {
      stanas = value;
      return;
    }
    if (CPLib.eqr("sesso",p_cVarName)) {
      sesso = value;
      return;
    }
    if (CPLib.eqr("datnas",p_cVarName)) {
      datnas = value;
      return;
    }
    if (CPLib.eqr("tipdoc",p_cVarName)) {
      tipdoc = value;
      return;
    }
    if (CPLib.eqr("autril",p_cVarName)) {
      autril = value;
      return;
    }
    if (CPLib.eqr("numdoc",p_cVarName)) {
      numdoc = value;
      return;
    }
    if (CPLib.eqr("datril",p_cVarName)) {
      datril = value;
      return;
    }
    if (CPLib.eqr("_testa",p_cVarName)) {
      _testa = value;
      return;
    }
    if (CPLib.eqr("_agetesta",p_cVarName)) {
      _agetesta = value;
      return;
    }
    if (CPLib.eqr("_sqr",p_cVarName)) {
      _sqr = value;
      return;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      _coddip = value;
      return;
    }
    if (CPLib.eqr("_namdip",p_cVarName)) {
      _namdip = value;
      return;
    }
    if (CPLib.eqr("_citdip",p_cVarName)) {
      _citdip = value;
      return;
    }
    if (CPLib.eqr("_nomman",p_cVarName)) {
      _nomman = value;
      return;
    }
    if (CPLib.eqr("_cogman",p_cVarName)) {
      _cogman = value;
      return;
    }
    if (CPLib.eqr("_nazben",p_cVarName)) {
      _nazben = value;
      return;
    }
    if (CPLib.eqr("_luonas",p_cVarName)) {
      _luonas = value;
      return;
    }
    if (CPLib.eqr("_tipdoc",p_cVarName)) {
      _tipdoc = value;
      return;
    }
    if (CPLib.eqr("_numdoc",p_cVarName)) {
      _numdoc = value;
      return;
    }
    if (CPLib.eqr("f_datdoc",p_cVarName)) {
      f_datdoc = value;
      return;
    }
    if (CPLib.eqr("_autril",p_cVarName)) {
      _autril = value;
      return;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      _numprog = value;
      return;
    }
    if (CPLib.eqr("_mtcn",p_cVarName)) {
      _mtcn = value;
      return;
    }
    if (CPLib.eqr("_macage",p_cVarName)) {
      _macage = value;
      return;
    }
    if (CPLib.eqr("_stator",p_cVarName)) {
      _stator = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("_ndg",p_cVarName)) {
      _ndg = value;
      return;
    }
    if (CPLib.eqr("_cfestero",p_cVarName)) {
      _cfestero = value;
      return;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      _numsto = value;
      return;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      cNomeFile = value;
      return;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      cNomeFileZip = value;
      return;
    }
    if (CPLib.eqr("_mstato",p_cVarName)) {
      _mstato = value;
      return;
    }
    if (CPLib.eqr("_rifimp",p_cVarName)) {
      _rifimp = value;
      return;
    }
    if (CPLib.eqr("_rifimp2",p_cVarName)) {
      _rifimp2 = value;
      return;
    }
    if (CPLib.eqr("_connesdoc",p_cVarName)) {
      _connesdoc = value;
      return;
    }
    if (CPLib.eqr("_dcauana",p_cVarName)) {
      _dcauana = value;
      return;
    }
    if (CPLib.eqr("_dcausin",p_cVarName)) {
      _dcausin = value;
      return;
    }
    if (CPLib.eqr("_dpaeseres",p_cVarName)) {
      _dpaeseres = value;
      return;
    }
    if (CPLib.eqr("_dpaesedes",p_cVarName)) {
      _dpaesedes = value;
      return;
    }
    if (CPLib.eqr("_dtipoope",p_cVarName)) {
      _dtipoope = value;
      return;
    }
    if (CPLib.eqr("_dstator",p_cVarName)) {
      _dstator = value;
      return;
    }
    if (CPLib.eqr("prcProg",p_cVarName)) {
      prcProg = value;
      return;
    }
    if (CPLib.eqr("cOutput",p_cVarName)) {
      cOutput = value;
      return;
    }
    if (CPLib.eqr("_codstar",p_cVarName)) {
      _codstar = value;
      return;
    }
    if (CPLib.eqr("fmhand",p_cVarName)) {
      fmhand = value;
      return;
    }
    if (CPLib.eqr("_file1",p_cVarName)) {
      _file1 = value;
      return;
    }
    if (CPLib.eqr("_file2",p_cVarName)) {
      _file2 = value;
      return;
    }
    if (CPLib.eqr("_orgdati",p_cVarName)) {
      _orgdati = value;
      return;
    }
    if (CPLib.eqr("_codinter",p_cVarName)) {
      _codinter = value;
      return;
    }
    if (CPLib.eqr("_prvdip",p_cVarName)) {
      _prvdip = value;
      return;
    }
    if (CPLib.eqr("_cabdip",p_cVarName)) {
      _cabdip = value;
      return;
    }
    if (CPLib.eqr("_inddip",p_cVarName)) {
      _inddip = value;
      return;
    }
    if (CPLib.eqr("_cfromdate",p_cVarName)) {
      _cfromdate = value;
      return;
    }
    if (CPLib.eqr("_c_todate",p_cVarName)) {
      _c_todate = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
      return;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      _ragsoc = value;
      return;
    }
    if (CPLib.eqr("_ajwcode",p_cVarName)) {
      _ajwcode = value;
      return;
    }
    if (CPLib.eqr("_fdtscad",p_cVarName)) {
      _fdtscad = value;
      return;
    }
    if (CPLib.eqr("_iban",p_cVarName)) {
      _iban = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_dadata",p_cVarName)) {
      _dadata = value;
      return;
    }
    if (CPLib.eqr("_a_data",p_cVarName)) {
      _a_data = value;
      return;
    }
    if (CPLib.eqr("_datareg",p_cVarName)) {
      _datareg = value;
      return;
    }
    if (CPLib.eqr("_dataope",p_cVarName)) {
      _dataope = value;
      return;
    }
    if (CPLib.eqr("_datnas",p_cVarName)) {
      _datnas = value;
      return;
    }
    if (CPLib.eqr("_datril",p_cVarName)) {
      _datril = value;
      return;
    }
    if (CPLib.eqr("_datadoc",p_cVarName)) {
      _datadoc = value;
      return;
    }
    if (CPLib.eqr("_datarett",p_cVarName)) {
      _datarett = value;
      return;
    }
    if (CPLib.eqr("_datasto",p_cVarName)) {
      _datasto = value;
      return;
    }
    if (CPLib.eqr("_datascad",p_cVarName)) {
      _datascad = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowANADIP",p_cVarName)) {
      rowANADIP = (MemoryCursorRow_anadip)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("pmcParametri",p_cVarName)) {
      pmcParametri = (MemoryCursor_mcparametri_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcANADIP",p_cVarName)) {
      mcANADIP = (MemoryCursor_anadip)value;
      return;
    }
    if (CPLib.eqr("mcTBSTATI",p_cVarName)) {
      mcTBSTATI = (MemoryCursor_tbstati)value;
      return;
    }
    if (CPLib.eqr("mcTBCAUANA",p_cVarName)) {
      mcTBCAUANA = (MemoryCursor_tbcauana)value;
      return;
    }
    if (CPLib.eqr("mcTBCAUSIN",p_cVarName)) {
      mcTBCAUSIN = (MemoryCursor_tbcausin)value;
      return;
    }
    if (CPLib.eqr("mcTBTIPDOC",p_cVarName)) {
      mcTBTIPDOC = (MemoryCursor_tbtipdoc)value;
      return;
    }
    if (CPLib.eqr("mcTBTIPREG",p_cVarName)) {
      mcTBTIPREG = (MemoryCursor_tbtipreg)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_tbcauana=null;
    CPResultSet Cursor_tbcausin=null;
    CPResultSet Cursor_tbstati=null;
    CPResultSet Cursor_tbtipdoc=null;
    CPResultSet Cursor_tbtipreg=null;
    CPResultSet Cursor_qbe_estrai_frz_lim=null;
    CPResultSet Cursor_qbe_estrai_ope_lim=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pmcParametri MemoryCursor(mcParametri.MCRDef) // mc Parametri */
      /* pAzienda Char(10) // Azienda Riferimento */
      /* pPath Char(80) // Path Applicazione */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gFileName Char(80) // NomeFile */
      /* gFlgWU Char(1) // Gestione WU */
      /* gUrlApp Char(80) // URL Applicazione */
      /* _gPathApp Char(80) // Path Applicazione */
      /* _gAzienda Char(10) // Azienda */
      /* fhand Char(10) */
      /* filenome Char(100) */
      /* righe Numeric(10, 0) */
      /* cell01 Char(100) */
      /* column01 Char(25) */
      /* cell_count Numeric(9, 0) */
      /* riga_letta Numeric(9, 0) // riga letta del file Excel */
      /* _file Memo */
      /* _dadata Date */
      /* _a_data Date */
      /* prova Char(1) */
      /* foglio Char(1) */
      /* _nfile Char(50) */
      /* stringa Char(1) */
      /* numero Char(1) */
      /* dData Char(1) */
      /* dataoggi Char(14) */
      /* numprog Char(11) */
      /* datareg Char(8) */
      /* _datareg Date */
      /* dataope Char(8) */
      /* _dataope Date */
      /* f_datope Char(10) */
      /* f_datnas Char(10) */
      /* f_datreg Char(10) */
      /* tipope Char(2) */
      /* cauana Char(4) */
      /* causin Char(4) */
      /* segno Char(1) */
      /* valuta Char(6) */
      /* divisa Char(30) */
      /* cambio Numeric(15, 10) */
      /* totimp Numeric(15, 2) */
      /* totcon Numeric(15, 2) */
      /* codfisc Char(16) */
      /* nominativo Char(70) */
      /* indirizzo Char(35) */
      /* citres Char(40) */
      /* capres Char(5) */
      /* prvres Char(2) */
      /* stares Char(40) */
      /* citnas Char(40) */
      /* prvnas Char(2) */
      /* stanas Char(40) */
      /* sesso Char(40) */
      /* datnas Char(8) */
      /* _datnas Date */
      /* tipdoc Char(2) */
      /* autril Char(30) */
      /* numdoc Char(15) */
      /* datril Char(8) */
      /* _datril Date */
      /* _testa Char(50) */
      /* _agetesta Char(50) */
      /* _sqr Char(10) */
      /* _coddip Char(6) */
      /* _namdip Char(40) */
      /* _citdip Char(40) */
      /* _nomman Char(30) */
      /* _cogman Char(30) */
      /* _nazben Char(30) */
      /* _luonas Char(40) */
      /* _tipdoc Char(20) */
      /* _numdoc Char(20) */
      /* f_datdoc Char(10) */
      /* _autril Char(30) */
      /* _numprog Char(11) */
      /* _mtcn Char(10) */
      /* _macage Char(5) */
      /* _stator Char(1) */
      /* _rapporto Char(25) */
      /* riga Numeric(10, 0) */
      /* _ndg Char(16) */
      /* _cfestero Char(2) */
      /* _numsto Char(15) */
      /* _ctot Numeric(10, 0) */
      /* cNomeFile Char(30) */
      /* cNomeFileZip Char(30) */
      /* _datadoc Date */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _cicli Numeric(15, 0) */
      /* _contacicli Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _mstato Char(15) */
      /* _rifimp Char(28) */
      /* _rifimp2 Char(30) */
      /* _connesdoc Char(50) */
      /* _datarett Date */
      /* _datareg Date */
      /* _dcauana Char(165) */
      /* _dcausin Char(165) */
      /* _dpaeseres Char(30) */
      /* _dpaesedes Char(30) */
      /* _dtipoope Char(90) */
      /* _dstator Char(30) */
      /* prcProg Char(10) */
      /* cOutput Char(30) */
      /* _codstar Char(3) */
      /* _totgen Numeric(10, 0) */
      /* fmhand Char(10) */
      /* _file1 Char(128) */
      /* _file2 Char(80) */
      /* _totalone Numeric(10, 0) */
      /* _orgdati Char(1) */
      /* _codinter Char(11) */
      /* mcANADIP MemoryCursor(anadip) */
      /* rowANADIP Row(anadip) */
      /* _prvdip Char(2) */
      /* _cabdip Char(6) */
      /* _inddip Char(40) */
      /* _cfromdate Char(8) */
      /* _c_todate Char(8) */
      /* _nomefile Char(60) // Nome file */
      /* _ragsoc Char(70) */
      /* _importo Numeric(15, 0) */
      /* _ajwcode Char(10) */
      /* _datasto Date */
      /* _datascad Date */
      /* _fdtscad Char(10) */
      /* _iban Char(25) */
      /* mcTBSTATI MemoryCursor(tbstati) */
      /* mcTBCAUANA MemoryCursor(tbcauana) */
      /* mcTBCAUSIN MemoryCursor(tbcausin) */
      /* mcTBTIPDOC MemoryCursor(tbtipdoc) */
      /* mcTBTIPREG MemoryCursor(tbtipreg) */
      /* pmcParametri.GoTop() // mc Parametri */
      pmcParametri.GoTop();
      /* dataoggi := DateTimeToChar(DateTime()) */
      dataoggi = CPLib.DateTimeToChar(CPLib.DateTime());
      /* _gPathApp := pPath // Path Applicazione */
      _gPathApp = pPath;
      /* _gAzienda := pAzienda // Azienda */
      _gAzienda = pAzienda;
      /* _mstato := '' */
      _mstato = "";
      /* _nomefile := pmcParametri.w_nomefile // Nome file */
      _nomefile = pmcParametri.row.w_nomefile;
      /* _importo := pmcParametri.w_importo * 100 */
      _importo = CPLib.Round(pmcParametri.row.w_importo*100,0);
      // * --- Fill memory cursor mcTBCAUANA on tbcauana
      mcTBCAUANA.Zap();
      m_cServer = m_Ctx.GetServer("tbcauana");
      m_cPhName = m_Ctx.GetPhName("tbcauana");
      if (Cursor_tbcauana!=null)
        Cursor_tbcauana.Close();
      Cursor_tbcauana = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbcauana")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbcauana;
        Cursor_tbcauana.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_estrai_xls_func: query on tbcauana returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbcauana.Eof())) {
        mcTBCAUANA.AppendWithTrimmedKey(Cursor_tbcauana.GetString("CODCAU")+Cursor_tbcauana.GetString("CAUSINT"));
        mcTBCAUANA.row.idbase = Cursor_tbcauana.GetString("idbase");
        mcTBCAUANA.row.DESCRI = Cursor_tbcauana.GetString("DESCRI");
        mcTBCAUANA.row.CODCAU = Cursor_tbcauana.GetString("CODCAU");
        mcTBCAUANA.row.SEGNO = Cursor_tbcauana.GetString("SEGNO");
        mcTBCAUANA.row.CAUSINT = Cursor_tbcauana.GetString("CAUSINT");
        mcTBCAUANA.row.DATAVALI = Cursor_tbcauana.GetDate("DATAVALI");
        mcTBCAUANA.row.VALPERINT = Cursor_tbcauana.GetString("VALPERINT");
        mcTBCAUANA.row.DATINI = Cursor_tbcauana.GetDate("DATINI");
        mcTBCAUANA.row.FLGINTER = Cursor_tbcauana.GetString("FLGINTER");
        mcTBCAUANA.row.MITBASE = Cursor_tbcauana.GetString("MITBASE");
        mcTBCAUANA.row.USEBASE = Cursor_tbcauana.GetString("USEBASE");
        mcTBCAUANA.row.NOSARA = Cursor_tbcauana.GetString("NOSARA");
        Cursor_tbcauana.Next();
      }
      m_cConnectivityError = Cursor_tbcauana.ErrorMessage();
      Cursor_tbcauana.Close();
      mcTBCAUANA.GoTop();
      // * --- Fill memory cursor mcTBCAUSIN on tbcausin
      mcTBCAUSIN.Zap();
      m_cServer = m_Ctx.GetServer("tbcausin");
      m_cPhName = m_Ctx.GetPhName("tbcausin");
      if (Cursor_tbcausin!=null)
        Cursor_tbcausin.Close();
      Cursor_tbcausin = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbcausin")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbcausin;
        Cursor_tbcausin.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_estrai_xls_func: query on tbcausin returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbcausin.Eof())) {
        mcTBCAUSIN.AppendWithTrimmedKey(Cursor_tbcausin.GetString("CODVOC"));
        mcTBCAUSIN.row.CODVOC = Cursor_tbcausin.GetString("CODVOC");
        mcTBCAUSIN.row.DESCRIZ = Cursor_tbcausin.GetString("DESCRIZ");
        mcTBCAUSIN.row.DATAVALI = Cursor_tbcausin.GetDate("DATAVALI");
        Cursor_tbcausin.Next();
      }
      m_cConnectivityError = Cursor_tbcausin.ErrorMessage();
      Cursor_tbcausin.Close();
      mcTBCAUSIN.GoTop();
      // * --- Fill memory cursor mcTBSTATI on tbstati
      mcTBSTATI.Zap();
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
                info.log("Routine arrt_estrai_xls_func: query on tbstati returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbstati.Eof())) {
        mcTBSTATI.AppendWithTrimmedKey(Cursor_tbstati.GetString("CODSTA"));
        mcTBSTATI.row.CODSTA = Cursor_tbstati.GetString("CODSTA");
        mcTBSTATI.row.DESCRI = Cursor_tbstati.GetString("DESCRI");
        mcTBSTATI.row.SIGLA = Cursor_tbstati.GetString("SIGLA");
        mcTBSTATI.row.ISO = Cursor_tbstati.GetString("ISO");
        mcTBSTATI.row.ISO2 = Cursor_tbstati.GetString("ISO2");
        mcTBSTATI.row.IDTBLS = Cursor_tbstati.GetString("IDTBLS");
        mcTBSTATI.row.IDBASE = Cursor_tbstati.GetString("IDBASE");
        mcTBSTATI.row.FLGSAE = Cursor_tbstati.GetString("FLGSAE");
        mcTBSTATI.row.ISON = Cursor_tbstati.GetString("ISON");
        Cursor_tbstati.Next();
      }
      m_cConnectivityError = Cursor_tbstati.ErrorMessage();
      Cursor_tbstati.Close();
      mcTBSTATI.GoTop();
      // * --- Fill memory cursor mcTBTIPDOC on tbtipdoc
      mcTBTIPDOC.Zap();
      m_cServer = m_Ctx.GetServer("tbtipdoc");
      m_cPhName = m_Ctx.GetPhName("tbtipdoc");
      if (Cursor_tbtipdoc!=null)
        Cursor_tbtipdoc.Close();
      Cursor_tbtipdoc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbtipdoc")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbtipdoc;
        Cursor_tbtipdoc.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_estrai_xls_func: query on tbtipdoc returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbtipdoc.Eof())) {
        mcTBTIPDOC.AppendWithTrimmedKey(Cursor_tbtipdoc.GetString("TIPDOC"));
        mcTBTIPDOC.row.TIPDOC = Cursor_tbtipdoc.GetString("TIPDOC");
        mcTBTIPDOC.row.DESCRI = Cursor_tbtipdoc.GetString("DESCRI");
        Cursor_tbtipdoc.Next();
      }
      m_cConnectivityError = Cursor_tbtipdoc.ErrorMessage();
      Cursor_tbtipdoc.Close();
      mcTBTIPDOC.GoTop();
      // * --- Fill memory cursor mcTBTIPREG on tbtipreg
      mcTBTIPREG.Zap();
      m_cServer = m_Ctx.GetServer("tbtipreg");
      m_cPhName = m_Ctx.GetPhName("tbtipreg");
      if (Cursor_tbtipreg!=null)
        Cursor_tbtipreg.Close();
      Cursor_tbtipreg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbtipreg")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbtipreg;
        Cursor_tbtipreg.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_estrai_xls_func: query on tbtipreg returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbtipreg.Eof())) {
        mcTBTIPREG.AppendWithTrimmedKey(Cursor_tbtipreg.GetString("CODICE"));
        mcTBTIPREG.row.CODICE = Cursor_tbtipreg.GetString("CODICE");
        mcTBTIPREG.row.DES1 = Cursor_tbtipreg.GetString("DES1");
        mcTBTIPREG.row.DES2 = Cursor_tbtipreg.GetString("DES2");
        mcTBTIPREG.row.TIPREG = Cursor_tbtipreg.GetString("TIPREG");
        mcTBTIPREG.row.OPERAZIO = Cursor_tbtipreg.GetString("OPERAZIO");
        mcTBTIPREG.row.DATAINI = Cursor_tbtipreg.GetDate("DATAINI");
        mcTBTIPREG.row.DATAFINE = Cursor_tbtipreg.GetDate("DATAFINE");
        Cursor_tbtipreg.Next();
      }
      m_cConnectivityError = Cursor_tbtipreg.ErrorMessage();
      Cursor_tbtipreg.Close();
      mcTBTIPREG.GoTop();
      /* If pmcParametri.pTipo='B' */
      if (CPLib.eqr(pmcParametri.row.pTipo,"B")) {
        /* Utilities.SetCompany(_gAzienda) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(_gAzienda);
        /* prcProg := Utilities.GetAutonumber("PRGPROC\'"+LRTrim(_gAzienda)+"'",'',10) */
        prcProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPROC\\'"+CPLib.LRTrim(_gAzienda)+"'","",10);
        /* Case pmcParametri.w_tipoout='E' */
        if (CPLib.eqr(pmcParametri.row.w_tipoout,"E")) {
          /* cOutput := 'su file Excel' */
          cOutput = "su file Excel";
          /* Case pmcParametri.w_tipoout='T' */
        } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"T")) {
          /* cOutput := 'su file Testo' */
          cOutput = "su file Testo";
          /* Case pmcParametri.w_tipoout='D' */
        } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"D")) {
          /* cOutput := 'su tabella in accodamento' */
          cOutput = "su tabella in accodamento";
          /* Case pmcParametri.w_tipoout='Z' */
        } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"Z")) {
          /* cOutput := 'su tabella con azzeramento' */
          cOutput = "su tabella con azzeramento";
          /* Case pmcParametri.w_tipoout='C' */
        } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"C")) {
          /* cOutput := 'su file CSV' */
          cOutput = "su file CSV";
        } // End Case
        // * --- Insert into processi from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("processi");
        m_cPhName = m_Ctx.GetPhName("processi");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"processi",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_xls_func",395,"000000A5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000000A5(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("EXT","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(prcProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Estrazione Movimenti "+CPLib.LRTrim(cOutput),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("L","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(pmcParametri.row.w_tipoout,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"processi",true);
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
        /* gMsgImp := 'Elaborazione lanciata. Consultare la schermata dei processi per verificare lo stato di avanzamento' // Messaggio Import */
        gMsgImp = "Elaborazione lanciata. Consultare la schermata dei processi per verificare lo stato di avanzamento";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } // End If
      /* If pmcParametri.w_attive='S' */
      if (CPLib.eqr(pmcParametri.row.w_attive,"S")) {
        /* _mstato := "'0','1'" */
        _mstato = "'0','1'";
      } // End If
      /* _totalone := 0 */
      _totalone = CPLib.Round(0,0);
      /* riga := 0 */
      riga = CPLib.Round(0,0);
      /* gMsgImp := 'Calcolo Operazioni/Frazionate da Elaborare' // Messaggio Import */
      gMsgImp = "Calcolo Operazioni/Frazionate da Elaborare";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If pmcParametri.w_frzsel='S' */
      if (CPLib.eqr(pmcParametri.row.w_frzsel,"S")) {
        // * --- Select from qbe_estrai_frz_lim
        SPBridge.HMCaller _h000000AD;
        _h000000AD = new SPBridge.HMCaller();
        _h000000AD.Set("m_cVQRList",m_cVQRList);
        _h000000AD.Set("cdadata",pmcParametri.row.w_cdadata);
        _h000000AD.Set("c_adata",pmcParametri.row.w_c_adata);
        _h000000AD.Set("cDIP",pmcParametri.row.w_cDIP);
        _h000000AD.Set("cCODFISC",pmcParametri.row.w_cCODFISC);
        _h000000AD.Set("cMTCN",pmcParametri.row.w_cMTCN);
        _h000000AD.Set("codmag",pmcParametri.row.w_codmag);
        _h000000AD.Set("_mstato",_mstato);
        _h000000AD.Set("_lststati",pmcParametri.row.w_lststa);
        _h000000AD.Set("_lstprov",pmcParametri.row.w_lstprv);
        _h000000AD.Set("connes",pmcParametri.row.w_connes);
        _h000000AD.Set("_importo",_importo);
        if (Cursor_qbe_estrai_frz_lim!=null)
          Cursor_qbe_estrai_frz_lim.Close();
        Cursor_qbe_estrai_frz_lim = new VQRHolder("qbe_estrai_frz_lim",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000AD,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_estrai_frz_lim.Eof())) {
          /* _totalone := _totalone + qbe_estrai_frz_lim->totfrz */
          _totalone = CPLib.Round(_totalone+Cursor_qbe_estrai_frz_lim.GetDouble("totfrz"),0);
          Cursor_qbe_estrai_frz_lim.Next();
        }
        m_cConnectivityError = Cursor_qbe_estrai_frz_lim.ErrorMessage();
        Cursor_qbe_estrai_frz_lim.Close();
        // * --- End Select
      } // End If
      /* If pmcParametri.w_opesel='S' */
      if (CPLib.eqr(pmcParametri.row.w_opesel,"S")) {
        // * --- Select from qbe_estrai_ope_lim
        SPBridge.HMCaller _h000000B0;
        _h000000B0 = new SPBridge.HMCaller();
        _h000000B0.Set("m_cVQRList",m_cVQRList);
        _h000000B0.Set("cdadata",pmcParametri.row.w_cdadata);
        _h000000B0.Set("c_adata",pmcParametri.row.w_c_adata);
        _h000000B0.Set("cDIP",pmcParametri.row.w_cDIP);
        _h000000B0.Set("cCODFISC",pmcParametri.row.w_cCODFISC);
        _h000000B0.Set("cMTCN",pmcParametri.row.w_cMTCN);
        _h000000B0.Set("codmag",pmcParametri.row.w_codmag);
        _h000000B0.Set("_mstato",_mstato);
        _h000000B0.Set("_lststati",pmcParametri.row.w_lststa);
        _h000000B0.Set("_lstprov",pmcParametri.row.w_lstprv);
        _h000000B0.Set("connes",pmcParametri.row.w_connes);
        _h000000B0.Set("_importo",_importo);
        if (Cursor_qbe_estrai_ope_lim!=null)
          Cursor_qbe_estrai_ope_lim.Close();
        Cursor_qbe_estrai_ope_lim = new VQRHolder("qbe_estrai_ope_lim",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000B0,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_estrai_ope_lim.Eof())) {
          /* _totalone := _totalone + qbe_estrai_ope_lim->totope */
          _totalone = CPLib.Round(_totalone+Cursor_qbe_estrai_ope_lim.GetDouble("totope"),0);
          Cursor_qbe_estrai_ope_lim.Next();
        }
        m_cConnectivityError = Cursor_qbe_estrai_ope_lim.ErrorMessage();
        Cursor_qbe_estrai_ope_lim.Close();
        // * --- End Select
      } // End If
      /* _testa := LRTrim(_gAzienda)+"_movimenti_"+dataoggi */
      _testa = CPLib.LRTrim(_gAzienda)+"_movimenti_"+dataoggi;
      /* cNomeFileZip := iif(Empty(LRTrim(pmcParametri.w_destfold)),LRTrim(_gPathApp)+'/export/'+LRTrim(_gAzienda)+"/"+LRTrim(_testa)+".zip",LRTrim(pmcParametri.w_destfold)+"/"+LRTrim(_testa)+".zip") */
      cNomeFileZip = (CPLib.Empty(CPLib.LRTrim(pmcParametri.row.w_destfold))?CPLib.LRTrim(_gPathApp)+"/export/"+CPLib.LRTrim(_gAzienda)+"/"+CPLib.LRTrim(_testa)+".zip":CPLib.LRTrim(pmcParametri.row.w_destfold)+"/"+CPLib.LRTrim(_testa)+".zip");
      // * --- Drop temporary table tmp_mtcn_cf
      if (m_Ctx.IsSharedTemp("tmp_mtcn_cf")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_mtcn_cf")) {
          m_cServer = m_Ctx.GetServer("tmp_mtcn_cf");
          m_cPhName = m_Ctx.GetPhName("tmp_mtcn_cf");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_mtcn_cf");
      }
      // * --- Create temporary table tmp_mtcn_cf
      if (m_Ctx.IsSharedTemp("tmp_mtcn_cf")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_mtcn_cf")) {
          m_cServer = m_Ctx.GetServer("tmp_mtcn_cf");
          m_cPhName = m_Ctx.GetPhName("tmp_mtcn_cf");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_mtcn_cf");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_mtcn_cf");
      if ( ! (m_Ctx.IsSharedTemp("tmp_mtcn_cf"))) {
        m_cServer = m_Ctx.GetServer("tmp_mtcn_cf");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_mtcn_cf",m_cServer,"proto")),m_cPhName,"tmp_mtcn_cf",m_Ctx);
      }
      m_cPhName_tmp_mtcn_cf = m_cPhName;
      // * --- Drop temporary table tmp_newpers
      if (m_Ctx.IsSharedTemp("tmp_newpers")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_newpers")) {
          m_cServer = m_Ctx.GetServer("tmp_newpers");
          m_cPhName = m_Ctx.GetPhName("tmp_newpers");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_newpers");
      }
      // * --- Create temporary table tmp_newpers
      if (m_Ctx.IsSharedTemp("tmp_newpers")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_newpers")) {
          m_cServer = m_Ctx.GetServer("tmp_newpers");
          m_cPhName = m_Ctx.GetPhName("tmp_newpers");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_newpers");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_newpers");
      if ( ! (m_Ctx.IsSharedTemp("tmp_newpers"))) {
        m_cServer = m_Ctx.GetServer("tmp_newpers");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_newpers",m_cServer,"proto")),m_cPhName,"tmp_newpers",m_Ctx);
      }
      m_cPhName_tmp_newpers = m_cPhName;
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry000000B9status;
      nTry000000B9status = m_Sql.GetTransactionStatus();
      String cTry000000B9msg;
      cTry000000B9msg = m_Sql.TransactionErrorMessage();
      try {
        /* If pmcParametri.w_flgmese='N' */
        if (CPLib.eqr(pmcParametri.row.w_flgmese,"N")) {
          /* _dadata := iif(DateToChar(pmcParametri.w_dadata)='01000101',NullDate(),pmcParametri.w_dadata) */
          _dadata = (CPLib.eqr(CPLib.DateToChar(pmcParametri.row.w_dadata),"01000101")?CPLib.NullDate():pmcParametri.row.w_dadata);
          /* _a_data := iif(DateToChar(pmcParametri.w_adata)='01000101',NullDate(),pmcParametri.w_adata) */
          _a_data = (CPLib.eqr(CPLib.DateToChar(pmcParametri.row.w_adata),"01000101")?CPLib.NullDate():pmcParametri.row.w_adata);
          /* _cfromdate := iif(DateToChar(pmcParametri.w_dadata)='01000101','',DateToChar(_dadata)) */
          _cfromdate = (CPLib.eqr(CPLib.DateToChar(pmcParametri.row.w_dadata),"01000101")?"":CPLib.DateToChar(_dadata));
          /* _c_todate := iif(DateToChar(pmcParametri.w_adata)='01000101','',DateToChar(_a_data)) */
          _c_todate = (CPLib.eqr(CPLib.DateToChar(pmcParametri.row.w_adata),"01000101")?"":CPLib.DateToChar(_a_data));
          /* If pmcParametri.w_tipoout='E' */
          if (CPLib.eqr(pmcParametri.row.w_tipoout,"E")) {
            /* Exec "Excel" Page 2:Page_2 */
            Page_2();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* ElseIf pmcParametri.w_tipoout='D' or pmcParametri.w_tipoout='Z' */
          } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"D") || CPLib.eqr(pmcParametri.row.w_tipoout,"Z")) {
            /* Exec "DB" Page 4:Page_4 */
            Page_4();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* ElseIf pmcParametri.w_tipoout='T' */
          } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"T")) {
            /* Exec "Txt" Page 3:Page_3 */
            Page_3();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* ElseIf pmcParametri.w_tipoout='C' */
          } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"C")) {
            /* Exec "CSV" Page 5:Page_5 */
            Page_5();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
          } // End If
        } else { // Else
          /* _dadata := pmcParametri.w_dadata */
          _dadata = pmcParametri.row.w_dadata;
          /* _a_data := arfn_finemese(_dadata) */
          _a_data = arfn_finemeseR.Make(m_Ctx,this).Run(_dadata);
          /* If _dadata < pmcParametri.w_adata and _a_data > pmcParametri.w_adata */
          if (CPLib.lt(_dadata,pmcParametri.row.w_adata) && CPLib.gt(_a_data,pmcParametri.row.w_adata)) {
            /* _a_data := pmcParametri.w_adata */
            _a_data = pmcParametri.row.w_adata;
          } // End If
          /* _cfromdate := DateToChar(_dadata) */
          _cfromdate = CPLib.DateToChar(_dadata);
          /* _c_todate := DateToChar(_a_data) */
          _c_todate = CPLib.DateToChar(_a_data);
          /* While _a_data <= pmcParametri.w_adata */
          while (CPLib.le(_a_data,pmcParametri.row.w_adata)) {
            /* If pmcParametri.w_tipoout='E' */
            if (CPLib.eqr(pmcParametri.row.w_tipoout,"E")) {
              /* Exec "Excel" Page 2:Page_2 */
              Page_2();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
              /* ElseIf pmcParametri.w_tipoout='D' or pmcParametri.w_tipoout='Z' */
            } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"D") || CPLib.eqr(pmcParametri.row.w_tipoout,"Z")) {
              /* Exec "DB" Page 4:Page_4 */
              Page_4();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
              /* ElseIf pmcParametri.w_tipoout='T' */
            } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"T")) {
              /* Exec "Txt" Page 3:Page_3 */
              Page_3();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
              /* ElseIf pmcParametri.w_tipoout='C' */
            } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"C")) {
              /* Exec "CSV" Page 5:Page_5 */
              Page_5();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
            } // End If
            /* _dadata := arfn_datesum(_a_data,1) */
            _dadata = arfn_datesumR.Make(m_Ctx,this).Run(_a_data,1);
            /* _a_data := arfn_finemese(_dadata) */
            _a_data = arfn_finemeseR.Make(m_Ctx,this).Run(_dadata);
            /* If _dadata < pmcParametri.w_adata and _a_data > pmcParametri.w_adata */
            if (CPLib.lt(_dadata,pmcParametri.row.w_adata) && CPLib.gt(_a_data,pmcParametri.row.w_adata)) {
              /* _a_data := pmcParametri.w_adata */
              _a_data = pmcParametri.row.w_adata;
            } // End If
            /* _cfromdate := DateToChar(_dadata) */
            _cfromdate = CPLib.DateToChar(_dadata);
            /* _c_todate := DateToChar(_a_data) */
            _c_todate = CPLib.DateToChar(_a_data);
          } // End While
        } // End If
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* If pmcParametri.pTipo='B' */
        if (CPLib.eqr(pmcParametri.row.pTipo,"B")) {
          // * --- Write into processi from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("processi");
          m_cPhName = m_Ctx.GetPhName("processi");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"processi",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_xls_func",395,"000000D8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"PRFILEOUT = "+CPLib.ToSQL(CPLib.LRTrim(cNomeFileZip),"C",128,0,m_cServer)+", ";
          m_cSql = m_cSql+"PRDOSTOP = "+CPLib.ToSQL(CPLib.DateTime(),"T",14,0)+", ";
          m_cSql = m_cSql+"PRESITO = "+CPLib.ToSQL("P","C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"PRNOMEFILE = "+CPLib.ToSQL(CPLib.LRTrim(_testa)+".zip","C",80,0,m_cServer)+", ";
          m_cSql = m_cSql+"PRGMSGSTA = "+CPLib.ToSQL("Estrazione Terminata ("+CPLib.LRTrim(CPLib.Str(_totalone,10,0))+" movimenti)","C",128,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"processi",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"PR_TIPO = "+CPSql.SQLValueAdapter(CPLib.ToSQL("EXT","?",0,0,m_cServer),m_cServer,"EXT")+"";
          m_cSql = m_cSql+" and PRCODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(prcProg,"?",0,0,m_cServer),m_cServer,prcProg)+"";
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
        /* Exec "Crea il file delle dipendenze" Page 15:Page_15 */
        Page_15();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Exec "Crea il file zip" Page 14:Page_14 */
        Page_14();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* If pmcParametri.pTipo='B' */
        if (CPLib.eqr(pmcParametri.row.pTipo,"B")) {
          /* FileLibMit.DeleteFile('./processi/EXT'+prcProg) */
          FileLibMit.DeleteFile("./processi/EXT"+prcProg);
          // * --- Write into processi from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("processi");
          m_cPhName = m_Ctx.GetPhName("processi");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"processi",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_xls_func",395,"000000DE")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"PRDOSTOP = "+CPLib.ToSQL(CPLib.DateTime(),"T",14,0)+", ";
          m_cSql = m_cSql+"PRESITO = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"PRGMSGSTA = "+CPLib.ToSQL("Estrazione Abortita","C",128,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"processi",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"PR_TIPO = "+CPSql.SQLValueAdapter(CPLib.ToSQL("EXT","?",0,0,m_cServer),m_cServer,"EXT")+"";
          m_cSql = m_cSql+" and PRCODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(prcProg,"?",0,0,m_cServer),m_cServer,prcProg)+"";
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000B9status,0)) {
          m_Sql.SetTransactionStatus(nTry000000B9status,cTry000000B9msg);
        }
      }
      /* gFileName := LRTrim(_testa)+".zip" // NomeFile */
      gFileName = CPLib.LRTrim(_testa)+".zip";
      m_Ctx.SetGlobalString("gFileName",gFileName);
    } finally {
      try {
        if (Cursor_tbcauana!=null)
          Cursor_tbcauana.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbcausin!=null)
          Cursor_tbcausin.Close();
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
        if (Cursor_tbtipdoc!=null)
          Cursor_tbtipdoc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbtipreg!=null)
          Cursor_tbtipreg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_frz_lim!=null)
          Cursor_qbe_estrai_frz_lim.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_ope_lim!=null)
          Cursor_qbe_estrai_ope_lim.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    /* Formato Excel */
    /* _nfile := iif(Empty(LRTrim(pmcParametri.w_destfold)),LRTrim(_gPathApp)+"/export/"+LRTrim(_gAzienda)+"/"+LRTrim(_testa)+"_"+Left(_cfromdate,6)+".xlsx",LRTrim(pmcParametri.w_destfold)+"/"+LRTrim(_testa)+"_"+Left(_cfromdate,6)+".xlsx") */
    _nfile = (CPLib.Empty(CPLib.LRTrim(pmcParametri.row.w_destfold))?CPLib.LRTrim(_gPathApp)+"/export/"+CPLib.LRTrim(_gAzienda)+"/"+CPLib.LRTrim(_testa)+"_"+CPLib.Left(_cfromdate,6)+".xlsx":CPLib.LRTrim(pmcParametri.row.w_destfold)+"/"+CPLib.LRTrim(_testa)+"_"+CPLib.Left(_cfromdate,6)+".xlsx");
    // These are the files to include in the ZIP file
    filenames.add(CPLib.LRTrim(_nfile));
    fileonames.add(CPLib.LRTrim(_testa)+"_"+CPLib.Left(_cfromdate,6)+".xlsx");
    /* Seleziona i record */
    /* riga := 0 */
    riga = CPLib.Round(0,0);
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
    cell.setCellValue("INTERMEDIARIO");
    cell.setCellStyle(cs);
    cell =  row.createCell(1);
    cell.setCellValue("TIPO");
    cell.setCellStyle(cs);
    cell = row.createCell(2);
    cell.setCellValue("Codice AGENZIA");
    cell.setCellStyle(cs);
    cell = row.createCell(3);
    cell.setCellValue("AGENZIA");
    cell.setCellStyle(cs);
    cell =  row.createCell(4);
    cell.setCellValue("INDIRIZZO");
    cell.setCellStyle(cs);
    cell =  row.createCell(5);
    cell.setCellValue("CITTA'");
    cell.setCellStyle(cs);
    cell =  row.createCell(6);
    cell.setCellValue("PROVINCIA'");
    cell.setCellStyle(cs);
    cell =  row.createCell(7);
    cell.setCellValue("IMPORTO TRASFERITO");
    cell.setCellStyle(cs);
    cell =  row.createCell(8);
    cell.setCellValue("NDG CLIENTE");
    cell.setCellStyle(cs);
    cell =  row.createCell(9);
    cell.setCellValue("COGNOME/RAGIONE SOCIALE CLIENTE");
    cell.setCellStyle(cs);
    cell = row.createCell(10);
    cell.setCellValue("NOME CLIENTE");
    cell.setCellStyle(cs);
    cell = row.createCell(11);
    cell.setCellValue("SESSO");
    cell.setCellStyle(cs);
    cell = row.createCell(12);
    cell.setCellValue("STATO DI NASCITA");
    cell.setCellStyle(cs);
    cell = row.createCell(13);
    cell.setCellValue("COMUNE DI NASCITA");
    cell.setCellStyle(cs);
    cell = row.createCell(14);
    cell.setCellValue("PROVINCIA DI NASCITA");
    cell.setCellStyle(cs);
    cell = row.createCell(15);
    cell.setCellValue("DATA DI NASCITA");
    cell.setCellStyle(cs);
    cell = row.createCell(16);
    cell.setCellValue("CODICE FISCALE");
    cell.setCellStyle(cs);
    cell = row.createCell(17);
    cell.setCellValue("DOCUMENTO");
    cell.setCellStyle(cs);
    cell = row.createCell(18);
    cell.setCellValue("N° DOCUMENTO");
    cell.setCellStyle(cs);
    cell = row.createCell(19);
    cell.setCellValue("DATA DI RILASCIO");
    cell.setCellStyle(cs);
    cell = row.createCell(20);
    cell.setCellValue("DATA DI SCADENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(21);
    cell.setCellValue("AUTORITA' DI RILASCIO");
    cell.setCellStyle(cs);
    cell = row.createCell(22);
    cell.setCellValue("STATO RESIDENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(23);
    cell.setCellValue("CITTA' RESIDENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(24);
    cell.setCellValue("PROVINCIA DI RESIDENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(25);
    cell.setCellValue("INDIRIZZO");
    cell.setCellStyle(cs);
    cell = row.createCell(26);
    cell.setCellValue("TIPO OPERAZIONE");
    cell.setCellStyle(cs);
    cell = row.createCell(27);
    cell.setCellValue("CAUSALE ANALITICA");
    cell.setCellStyle(cs);
    cell = row.createCell(28);
    cell.setCellValue("CAUSALE SINTETICA");
    cell.setCellStyle(cs);
    cell = row.createCell(29);
    cell.setCellValue("SEGNO OPERAZIONE");
    cell.setCellStyle(cs);
    cell = row.createCell(30);
    cell.setCellValue("DATA OPERAZIONE");
    cell.setCellStyle(cs);
    cell = row.createCell(31);
    cell.setCellValue("NOMINATIVO CONTROPARTE");
    cell.setCellStyle(cs);
    cell = row.createCell(32);
    cell.setCellValue("STATO CONTROPARTE");
    cell.setCellStyle(cs);
    cell = row.createCell(33);
    cell.setCellValue("N° OPERAZIONE");
    cell.setCellStyle(cs);
    cell = row.createCell(34);
    cell.setCellValue("STATO REGISTRAZIONE");
    cell.setCellStyle(cs);
    cell = row.createCell(35);
    cell.setCellValue("CODICE RAPPORTO");
    cell.setCellStyle(cs);
    cell = row.createCell(36);
    cell.setCellValue("DATA REGISTRAZIONE");
    cell.setCellStyle(cs);
    cell = row.createCell(37);
    cell.setCellValue("FRAZIONATA/OPERAZIONE");
    cell.setCellStyle(cs);
    /* If gFlgWU='S' */
    if (CPLib.eqr(gFlgWU,"S")) {
      /* If pmcParametri.w_flgncf='N' */
      if (CPLib.eqr(pmcParametri.row.w_flgncf,"N")) {
        // Scrive MTCN e MacroAgente per WU
        cell = row.createCell(38);
        cell.setCellValue("COD. FISCALE FITTIZZIO");
        cell.setCellStyle(cs);
        cell = row.createCell(39);
        cell.setCellValue("MTCN");
        cell.setCellStyle(cs);
        cell = row.createCell(40);
        cell.setCellValue("MACROAGENTE");
        cell.setCellStyle(cs);
        cell = row.createCell(41);
        cell.setCellValue("AJW CODE");
        cell.setCellStyle(cs);
      } else { // Else
        // Scrive MTCN e MacroAgente per WU
        cell = row.createCell(38);
        cell.setCellValue("MTCN");
        cell.setCellStyle(cs);
        cell = row.createCell(39);
        cell.setCellValue("MACROAGENTE");
        cell.setCellStyle(cs);
        cell = row.createCell(40);
        cell.setCellValue("AJW CODE");
        cell.setCellStyle(cs);
      } // End If
    } else { // Else
      /* If pmcParametri.w_flgncf='N' */
      if (CPLib.eqr(pmcParametri.row.w_flgncf,"N")) {
        // Scrive riferimento per Altri
        cell = row.createCell(38);
        cell.setCellValue("COD. FISCALE FITTIZZIO");
        cell.setCellStyle(cs);
        cell = row.createCell(39);
        cell.setCellValue("RIFERIMENTO 1");
        cell.setCellStyle(cs);
        cell = row.createCell(40);
        cell.setCellValue("RIFERIMENTO 2");
        cell.setCellStyle(cs);
        cell = row.createCell(41);
        cell.setCellValue("CODICE CONTO");
        cell.setCellStyle(cs);
      } else { // Else
        // Scrive riferimento per Altri
        cell = row.createCell(38);
        cell.setCellValue("RIFERIMENTO 1");
        cell.setCellStyle(cs);
        cell = row.createCell(39);
        cell.setCellValue("RIFERIMENTO 2");
        cell.setCellStyle(cs);
        cell = row.createCell(40);
        cell.setCellValue("CODICE CONTO");
        cell.setCellStyle(cs);
      } // End If
    } // End If
    // Aggiorna il contatore delle righe
    r++;
    /* Exec "Lettura Dati" Page 6:Page_6 */
    Page_6();
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
    sheet.autoSizeColumn(37);
    /* If gFlgWU='S' */
    if (CPLib.eqr(gFlgWU,"S")) {
      // Scrive MTCN e MacroAgente per WU
      sheet.autoSizeColumn(38);
      sheet.autoSizeColumn(39);
      sheet.autoSizeColumn(40);
      /* If pmcParametri.w_flgncf='N' */
      if (CPLib.eqr(pmcParametri.row.w_flgncf,"N")) {
        // Scrive MTCN e MacroAgente per WU
        sheet.autoSizeColumn(41);
      } // End If
    } else { // Else
      /* If pmcParametri.w_flgncf='N' */
      if (CPLib.eqr(pmcParametri.row.w_flgncf,"N")) {
        // Scrive MTCN e MacroAgente per WU
        sheet.autoSizeColumn(38);
        sheet.autoSizeColumn(39);
        sheet.autoSizeColumn(40);
      } else { // Else
        // Scrive MTCN e MacroAgente per WU
        sheet.autoSizeColumn(38);
        sheet.autoSizeColumn(39);
      } // End If
    } // End If
    // scrivo il file di esito
    FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(_nfile));
    
    //write this workbook to an Outputstream.
    wb.write(fileOut);
    fileOut.flush();
    fileOut.close();
    /* If pmcParametri.pTipo = 'B' */
    if (CPLib.eqr(pmcParametri.row.pTipo,"B")) {
      /* FileLibMit.DeleteFile('./processi/EXT'+prcProg) */
      FileLibMit.DeleteFile("./processi/EXT"+prcProg);
    } else { // Else
      /* gMsgImp := 'Elaborazione Terminata (' + LRTrim(Str(riga,10,0)) + ' movimenti).' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata ("+CPLib.LRTrim(CPLib.Str(riga,10,0))+" movimenti).";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } // End If
  }
  void Page_3() throws Exception {
    /* Formato Testo */
    /* _nfile := iif(Empty(LRTrim(pmcParametri.w_destfold)),LRTrim(_gPathApp)+"/export/"+LRTrim(_gAzienda)+"/"+LRTrim(_testa)+"_"+Left(_cfromdate,6)+".txt",LRTrim(pmcParametri.w_destfold)+"/"+LRTrim(_testa)+"_"+Left(_cfromdate,6)+".txt") */
    _nfile = (CPLib.Empty(CPLib.LRTrim(pmcParametri.row.w_destfold))?CPLib.LRTrim(_gPathApp)+"/export/"+CPLib.LRTrim(_gAzienda)+"/"+CPLib.LRTrim(_testa)+"_"+CPLib.Left(_cfromdate,6)+".txt":CPLib.LRTrim(pmcParametri.row.w_destfold)+"/"+CPLib.LRTrim(_testa)+"_"+CPLib.Left(_cfromdate,6)+".txt");
    // These are the files to include in the ZIP file
    filenames.add(CPLib.LRTrim(_nfile));
    fileonames.add(CPLib.LRTrim(_testa)+"_"+CPLib.Left(_cfromdate,6)+".txt");
    /* fhand := FileLibMit.OpenWritePath(_nfile) */
    fhand = FileLibMit.OpenWritePath(_nfile);
    /* _file := LibreriaMit.SpacePad("TIPO",8) */
    _file = LibreriaMit.SpacePad("TIPO",8);
    /* _file := _file + LibreriaMit.SpacePad("AGENZIA",41) */
    _file = _file+LibreriaMit.SpacePad("AGENZIA",41);
    /* _file := _file + LibreriaMit.SpacePad("INDIRIZZO",36) */
    _file = _file+LibreriaMit.SpacePad("INDIRIZZO",36);
    /* _file := _file + LibreriaMit.SpacePad("CITTA'",31) */
    _file = _file+LibreriaMit.SpacePad("CITTA'",31);
    /* _file := _file + LibreriaMit.SpacePad("IMPORTO",13) */
    _file = _file+LibreriaMit.SpacePad("IMPORTO",13);
    /* _file := _file + LibreriaMit.SpacePad("NDG CLIENTE",17) */
    _file = _file+LibreriaMit.SpacePad("NDG CLIENTE",17);
    /* _file := _file + LibreriaMit.SpacePad("COGNOME CLIENTE",27) */
    _file = _file+LibreriaMit.SpacePad("COGNOME CLIENTE",27);
    /* _file := _file + LibreriaMit.SpacePad("NOME CLIENTE",26) */
    _file = _file+LibreriaMit.SpacePad("NOME CLIENTE",26);
    /* _file := _file + "SESSO " */
    _file = _file+"SESSO ";
    /* _file := _file + LibreriaMit.SpacePad("STATO DI NASCITA",31) */
    _file = _file+LibreriaMit.SpacePad("STATO DI NASCITA",31);
    /* _file := _file + LibreriaMit.SpacePad("COMUNE DI NASCITA",31) */
    _file = _file+LibreriaMit.SpacePad("COMUNE DI NASCITA",31);
    /* _file := _file + "PROVINCIA DI NASCITA " */
    _file = _file+"PROVINCIA DI NASCITA ";
    /* _file := _file + "DATA DI NASCITA " */
    _file = _file+"DATA DI NASCITA ";
    /* _file := _file + LibreriaMit.SpacePad("CODICE FISCALE",17) */
    _file = _file+LibreriaMit.SpacePad("CODICE FISCALE",17);
    /* _file := _file + LibreriaMit.SpacePad("DOCUMENTO",31) */
    _file = _file+LibreriaMit.SpacePad("DOCUMENTO",31);
    /* _file := _file + LibreriaMit.SpacePad("N° DOCUMENTO",16) */
    _file = _file+LibreriaMit.SpacePad("N° DOCUMENTO",16);
    /* _file := _file + "DATA RILASCIO " */
    _file = _file+"DATA RILASCIO ";
    /* _file := _file + LibreriaMit.SpacePad("AUTORITA' DI RILASCIO",31) */
    _file = _file+LibreriaMit.SpacePad("AUTORITA' DI RILASCIO",31);
    /* _file := _file + "STATO DI RESIDENZA " */
    _file = _file+"STATO DI RESIDENZA ";
    /* _file := _file + LibreriaMit.SpacePad("CITTA' DI RESIDENZA",31) */
    _file = _file+LibreriaMit.SpacePad("CITTA' DI RESIDENZA",31);
    /* _file := _file + "PROVINCIA DI RESIDENZA " */
    _file = _file+"PROVINCIA DI RESIDENZA ";
    /* _file := _file + LibreriaMit.SpacePad("INDIRIZZO",36) */
    _file = _file+LibreriaMit.SpacePad("INDIRIZZO",36);
    /* _file := _file + "TIPO OPERAZIONE " */
    _file = _file+"TIPO OPERAZIONE ";
    /* _file := _file + "CAUSALE ANALITICA " */
    _file = _file+"CAUSALE ANALITICA ";
    /* _file := _file + "CAUSALE SINTETICA " */
    _file = _file+"CAUSALE SINTETICA ";
    /* _file := _file + "SEGNO OPERAZIONE " */
    _file = _file+"SEGNO OPERAZIONE ";
    /* _file := _file + "DATA OPERAZIONE " */
    _file = _file+"DATA OPERAZIONE ";
    /* _file := _file + LibreriaMit.SpacePad("NOMINATIVO CONTROPARTE",71) */
    _file = _file+LibreriaMit.SpacePad("NOMINATIVO CONTROPARTE",71);
    /* _file := _file + "STATO CONTROPARTE " */
    _file = _file+"STATO CONTROPARTE ";
    /* _file := _file + "N° OPERAZIONE " */
    _file = _file+"N° OPERAZIONE ";
    /* _file := _file + "STATO REGISTRAZIONE " */
    _file = _file+"STATO REGISTRAZIONE ";
    /* _file := _file + LibreriaMit.SpacePad("CODICE RAPPORTO",26) */
    _file = _file+LibreriaMit.SpacePad("CODICE RAPPORTO",26);
    /* _file := _file + "DATA REGISTRAZIONE " */
    _file = _file+"DATA REGISTRAZIONE ";
    /* _file := _file + "FRAZIONATA/OPERAZIONE " */
    _file = _file+"FRAZIONATA/OPERAZIONE ";
    /* If gFlgWU='S' */
    if (CPLib.eqr(gFlgWU,"S")) {
      /* If pmcParametri.w_flgncf='N' */
      if (CPLib.eqr(pmcParametri.row.w_flgncf,"N")) {
        /* _file := _file + "CODICE FISCALE FITTIZIO " */
        _file = _file+"CODICE FISCALE FITTIZIO ";
        /* _file := _file + LibreriaMit.SpacePad("MTCN",11) */
        _file = _file+LibreriaMit.SpacePad("MTCN",11);
        /* _file := _file + "MACROAGENTE " */
        _file = _file+"MACROAGENTE ";
        /* _file := _file + "AJW CODE " */
        _file = _file+"AJW CODE ";
      } else { // Else
        /* _file := _file + LibreriaMit.SpacePad("MTCN",11) */
        _file = _file+LibreriaMit.SpacePad("MTCN",11);
        /* _file := _file + "MACROAGENTE " */
        _file = _file+"MACROAGENTE ";
        /* _file := _file + "AJW CODE " */
        _file = _file+"AJW CODE ";
      } // End If
    } else { // Else
      /* If pmcParametri.w_flgncf='N' */
      if (CPLib.eqr(pmcParametri.row.w_flgncf,"N")) {
        /* _file := _file + "CODICE FISCALE FITTIZIO " */
        _file = _file+"CODICE FISCALE FITTIZIO ";
        /* _file := _file + "RIFERIMENTO" */
        _file = _file+"RIFERIMENTO";
      } else { // Else
        /* _file := _file + "RIFERIMENTO" */
        _file = _file+"RIFERIMENTO";
      } // End If
    } // End If
    /* FileLibMit.WriteLine(fhand,_file) */
    FileLibMit.WriteLine(fhand,_file);
    /* Seleziona i record */
    /* Exec "Lettura Dati" Page 6:Page_6 */
    Page_6();
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* If pmcParametri.pTipo = 'B' */
    if (CPLib.eqr(pmcParametri.row.pTipo,"B")) {
      /* FileLibMit.DeleteFile('./processi/EXT'+prcProg) */
      FileLibMit.DeleteFile("./processi/EXT"+prcProg);
    } else { // Else
      /* gMsgImp := 'Elaborazione Terminata (' + LRTrim(Str(riga,10,0)) + ' movimenti).' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata ("+CPLib.LRTrim(CPLib.Str(riga,10,0))+" movimenti).";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } // End If
  }
  void Page_4() throws Exception {
    /* Database */
    /* Exec "Lettura Dati" Page 6:Page_6 */
    Page_6();
    /* gMsgImp := 'Elaborazione Terminata (' + LRTrim(Str(riga,10,0)) + ' movimenti).' // Messaggio Import */
    gMsgImp = "Elaborazione Terminata ("+CPLib.LRTrim(CPLib.Str(riga,10,0))+" movimenti).";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
  }
  void Page_5() throws Exception {
    /* Formato CSV */
    /* _nfile := iif(Empty(LRTrim(pmcParametri.w_destfold)),LRTrim(_gPathApp)+"/export/"+LRTrim(_gAzienda)+"/"+LRTrim(_testa)+"_"+Left(_cfromdate,6)+".csv",LRTrim(pmcParametri.w_destfold)+"/"+LRTrim(_testa)+"_"+Left(_cfromdate,6)+".csv") */
    _nfile = (CPLib.Empty(CPLib.LRTrim(pmcParametri.row.w_destfold))?CPLib.LRTrim(_gPathApp)+"/export/"+CPLib.LRTrim(_gAzienda)+"/"+CPLib.LRTrim(_testa)+"_"+CPLib.Left(_cfromdate,6)+".csv":CPLib.LRTrim(pmcParametri.row.w_destfold)+"/"+CPLib.LRTrim(_testa)+"_"+CPLib.Left(_cfromdate,6)+".csv");
    // These are the files to include in the ZIP file
    filenames.add(CPLib.LRTrim(_nfile));
    fileonames.add(CPLib.LRTrim(_testa)+"_"+CPLib.Left(_cfromdate,6)+".csv");
    // Creazione del writer
    cwriter=new CSVWriter(new FileWriter(_nfile));
    // Creazione della prima riga
    ncampi=(CPLib.eqr(gFlgWU,"S")?40:38);
    campi = new String[ncampi];
    campi[0]="INTERMEDIARIO";
    campi[1]="TIPO";
    campi[2]="CODICE AGENZIA";
    campi[3]="AGENZIA";
    campi[4]="INDIRIZZO";
    campi[5]="CITTA";
    campi[6]="PROVINCIA";
    campi[7]="IMPORTO";
    campi[8]="NDG CLIENTE";
    campi[9]="COGNOME CLIENTE/RAGIONE SOCIALE";
    campi[10]="NOME CLIENTE";
    campi[11]="SESSO";
    campi[12]="STATO DI NASCITA";
    campi[13]="COMUNE DI NASCITA";
    campi[14]="PROVINCIA DI NASCITA";
    campi[15]="DATA DI NASCITA";
    campi[16]="CODICE FISCALE";
    campi[17]="DOCUMENTO";
    campi[18]="N. DOCUMENTO";
    campi[19]="DATA DI RILASCIO";
    campi[20]="DATA DI SCADENZA";
    campi[21]="AUTORITA DI RILASCIO";
    campi[22]="STATO DI RESIDENZA";
    campi[23]="CITTA DI RESIDENZA";
    campi[24]="PROVINCIA DI RESIDENZA";
    campi[25]="INDIRIZZO RESIDENZA";
    campi[26]="TIPO OPERAZIONE";
    campi[27]="CAUSALE ANALITICA";
    campi[28]="CAUSALE SINTETICA";
    campi[29]="SEGNO OPERAZIONE";
    campi[30]="DATA OPERAZIONE";
    campi[31]="NOMINATIVO CONTROPARTE";
    campi[32]="STATO CONTROPARTE";
    campi[33]="N. OPERAZIONE";
    campi[34]="STATO REGISTRAZIONE";
    campi[35]="CODICE RAPPORTO";
    campi[36]="DATA REGISTRAZIONE";
    campi[37]="FRAZIONATA/OPERAZIONE";
    /* If gFlgWU='S' */
    if (CPLib.eqr(gFlgWU,"S")) {
      /* If pmcParametri.w_flgncf='N' */
      if (CPLib.eqr(pmcParametri.row.w_flgncf,"N")) {
        // CAmpi WU
        campi[38]="CODICE FISCALE FITTIZIO";
        campi[39]="MTCN";
        campi[40]="MACROAGENTE";
        campi[41]="AJW CODE";
      } else { // Else
        // CAmpi WU
        campi[38]="MTCN";
        campi[39]="MACROAGENTE";
        campi[40]="AJW CODE";
      } // End If
    } else { // Else
      /* If pmcParametri.w_flgncf='N' */
      if (CPLib.eqr(pmcParametri.row.w_flgncf,"N")) {
        // CAmpi No WU
        campi[38]="CODICE FISCALE FITTIZIO";
        campi[39]="RIFERIMENTO 1";
        campi[40]="RIFERIMENTO 2";
      } else { // Else
        // CAmpi No WU
        campi[38]="RIFERIMENTO 1";
        campi[39]="RIFERIMENTO 2";
      } // End If
    } // End If
    /* cwriter.writeNext(campi) */
    cwriter.writeNext(campi);
    /* Seleziona i record */
    /* Exec "Lettura Dati" Page 6:Page_6 */
    Page_6();
    /* cwriter.close() */
    cwriter.close();
    /* If pmcParametri.pTipo = 'B' */
    if (CPLib.eqr(pmcParametri.row.pTipo,"B")) {
      /* FileLibMit.DeleteFile('./processi/EXT'+prcProg) */
      FileLibMit.DeleteFile("./processi/EXT"+prcProg);
    } else { // Else
      /* gMsgImp := 'Elaborazione Terminata (' + LRTrim(Str(riga,10,0)) + ' movimenti).' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata ("+CPLib.LRTrim(CPLib.Str(riga,10,0))+" movimenti).";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } // End If
  }
  void Page_6() throws Exception {
    CPResultSet Cursor_qbe_tab_mmc=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_qbe_estrai_frz_lim=null;
    CPResultSet Cursor_qbe_estrai_frz=null;
    CPResultSet Cursor_qbe_estrai_ope_lim=null;
    CPResultSet Cursor_qbe_estrai_ope=null;
    CPResultSet Cursor_qbe_sele_sogg=null;
    CPResultSet Cursor_qbe_sele_sogg2=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* If pmcParametri.w_tipoout='Z' */
      if (CPLib.eqr(pmcParametri.row.w_tipoout,"Z")) {
        // * --- Delete from dw_operazioni
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("dw_operazioni");
        m_cPhName = m_Ctx.GetPhName("dw_operazioni");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dw_operazioni",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_xls_func",395,"00000153")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        /* _ctot := 0 */
        _ctot = CPLib.Round(0,0);
        /* ElseIf pmcParametri.w_tipoout='D' */
      } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"D")) {
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h00000155;
        _h00000155 = new SPBridge.HMCaller();
        _h00000155.Set("m_cVQRList",m_cVQRList);
        _h00000155.Set("tbname","dw_operazioni");
        _h00000155.Set("fldname","PROGOPE");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000155,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* _ctot := qbe_tab_mmc->max */
          _ctot = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("max"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
        // * --- End Select
      } // End If
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _codinter := intermbo->CODINTER */
        _codinter = Cursor_intermbo.GetString("CODINTER");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* If Empty(LRTrim(pmcParametri.w_nomefile)) and Empty(pmcParametri.w_cCODFISC) */
      if (CPLib.Empty(CPLib.LRTrim(pmcParametri.row.w_nomefile)) && CPLib.Empty(pmcParametri.row.w_cCODFISC)) {
        /* If Empty(pmcParametri.w_ragosc) and Empty(pmcParametri.w_citnas) and Empty(pmcParametri.w_stanas) and Empty(pmcParametri.w_datnas) and Empty(pmcParametri.w_connes) */
        if (CPLib.Empty(pmcParametri.row.w_ragosc) && CPLib.Empty(pmcParametri.row.w_citnas) && CPLib.Empty(pmcParametri.row.w_stanas) && CPLib.Empty(pmcParametri.row.w_datnas) && CPLib.Empty(pmcParametri.row.w_connes)) {
          /* If pmcParametri.w_frzsel='S' */
          if (CPLib.eqr(pmcParametri.row.w_frzsel,"S")) {
            /* _max := 0 */
            _max = CPLib.Round(0,0);
            /* _min := 0 */
            _min = CPLib.Round(0,0);
            /* _tot := 0 */
            _tot = CPLib.Round(0,0);
            // * --- Select from qbe_estrai_frz_lim
            SPBridge.HMCaller _h0000015F;
            _h0000015F = new SPBridge.HMCaller();
            _h0000015F.Set("m_cVQRList",m_cVQRList);
            _h0000015F.Set("cdadata",_cfromdate);
            _h0000015F.Set("c_adata",_c_todate);
            _h0000015F.Set("cDIP",pmcParametri.row.w_cDIP);
            _h0000015F.Set("cCODFISC",pmcParametri.row.w_cCODFISC);
            _h0000015F.Set("cMTCN",pmcParametri.row.w_cMTCN);
            _h0000015F.Set("codmag",pmcParametri.row.w_codmag);
            _h0000015F.Set("_mstato",_mstato);
            _h0000015F.Set("_lststati",pmcParametri.row.w_lststa);
            _h0000015F.Set("_lstprov",pmcParametri.row.w_lstprv);
            _h0000015F.Set("_importo",_importo);
            if (Cursor_qbe_estrai_frz_lim!=null)
              Cursor_qbe_estrai_frz_lim.Close();
            Cursor_qbe_estrai_frz_lim = new VQRHolder("qbe_estrai_frz_lim",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000015F,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_estrai_frz_lim.Eof())) {
              /* _max := qbe_estrai_frz_lim->maxfrz */
              _max = CPLib.Round(Cursor_qbe_estrai_frz_lim.GetDouble("maxfrz"),0);
              /* _min := qbe_estrai_frz_lim->minfrz */
              _min = CPLib.Round(Cursor_qbe_estrai_frz_lim.GetDouble("minfrz"),0);
              /* _tot := qbe_estrai_frz_lim->totfrz */
              _tot = CPLib.Round(Cursor_qbe_estrai_frz_lim.GetDouble("totfrz"),0);
              Cursor_qbe_estrai_frz_lim.Next();
            }
            m_cConnectivityError = Cursor_qbe_estrai_frz_lim.ErrorMessage();
            Cursor_qbe_estrai_frz_lim.Close();
            // * --- End Select
            /* _mono := iif(_tot > 75000,0,1) */
            _mono = CPLib.Round((CPLib.gt(_tot,75000)?0:1),0);
            /* If _mono = 1 */
            if (CPLib.eqr(_mono,1)) {
              /* If _tot = 0 */
              if (CPLib.eqr(_tot,0)) {
                /* _cicli := 0 */
                _cicli = CPLib.Round(0,0);
              } else { // Else
                /* _cicli := 1 */
                _cicli = CPLib.Round(1,0);
              } // End If
            } else { // Else
              /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
              _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
            } // End If
            /* _contacicli := 1 */
            _contacicli = CPLib.Round(1,0);
            /* While _contacicli<=_cicli */
            while (CPLib.le(_contacicli,_cicli)) {
              /* If _mono = 1 */
              if (CPLib.eqr(_mono,1)) {
                /* _bottom := _min */
                _bottom = CPLib.Round(_min,0);
                /* _top := _max */
                _top = CPLib.Round(_max,0);
              } else { // Else
                /* _bottom := ((_contacicli -1 ) * 5000) + 1 */
                _bottom = CPLib.Round(((_contacicli-1)*5000)+1,0);
                /* _top := _contacicli * 5000 */
                _top = CPLib.Round(_contacicli*5000,0);
              } // End If
              /* If pmcParametri.pTipo <> 'B' */
              if (CPLib.ne(pmcParametri.row.pTipo,"B")) {
                /* gMsgImp := 'Lettura informazioni in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) // Messaggio Import */
                gMsgImp = "Lettura informazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0));
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              } // End If
              /* If _top>=_min */
              if (CPLib.ge(_top,_min)) {
                // * --- Select from qbe_estrai_frz
                SPBridge.HMCaller _h00000173;
                _h00000173 = new SPBridge.HMCaller();
                _h00000173.Set("m_cVQRList",m_cVQRList);
                _h00000173.Set("cdadata",_cfromdate);
                _h00000173.Set("c_adata",_c_todate);
                _h00000173.Set("cDIP",pmcParametri.row.w_cDIP);
                _h00000173.Set("cCODFISC",pmcParametri.row.w_cCODFISC);
                _h00000173.Set("cMTCN",pmcParametri.row.w_cMTCN);
                _h00000173.Set("codmag",pmcParametri.row.w_codmag);
                _h00000173.Set("_bottom",_bottom);
                _h00000173.Set("_top",_top);
                _h00000173.Set("_mstato",_mstato);
                _h00000173.Set("_lststati",pmcParametri.row.w_lststa);
                _h00000173.Set("_lstprov",pmcParametri.row.w_lstprv);
                _h00000173.Set("_importo",_importo);
                _h00000173.Set("_stadest",pmcParametri.row.w_staben);
                if (Cursor_qbe_estrai_frz!=null)
                  Cursor_qbe_estrai_frz.Close();
                Cursor_qbe_estrai_frz = new VQRHolder("qbe_estrai_frz",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000173,true).GetResultSet(m_Ctx);
                while ( ! (Cursor_qbe_estrai_frz.Eof())) {
                  /* riga := riga + 1 */
                  riga = CPLib.Round(riga+1,0);
                  /* If pmcParametri.pTipo='B' */
                  if (CPLib.eqr(pmcParametri.row.pTipo,"B")) {
                    /* fmhand := FileLibMit.OpenWrite('./processi/EXT'+prcProg) */
                    fmhand = FileLibMit.OpenWrite("./processi/EXT"+prcProg);
                    /* FileLibMit.Write(fmhand,'Elaborazione del record '+LRTrim(Str(riga,10,0))+"/"+LRTrim(Str(_totalone,10,0))) */
                    FileLibMit.Write(fmhand,"Elaborazione del record "+CPLib.LRTrim(CPLib.Str(riga,10,0))+"/"+CPLib.LRTrim(CPLib.Str(_totalone,10,0)));
                    /* FileLibMit.Close(fmhand) */
                    FileLibMit.Close(fmhand);
                  } else { // Else
                    /* gMsgImp := 'Elaboro frazionata con progressivo n°: '+qbe_estrai_frz->NUMPROG // Messaggio Import */
                    gMsgImp = "Elaboro frazionata con progressivo n°: "+Cursor_qbe_estrai_frz.GetString("NUMPROG");
                    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                  } // End If
                  /* If qbe_estrai_frz->DATAOPE < CharToDate('20210101') */
                  if (CPLib.lt(Cursor_qbe_estrai_frz.GetDate("DATAOPE"),CPLib.CharToDate("20210101"))) {
                    /* If pmcParametri.w_flgsegno='1' */
                    if (CPLib.eqr(pmcParametri.row.w_flgsegno,"1")) {
                      /* _sqr := iif(qbe_estrai_frz->SEGNO='D','RECEIVE','SEND') */
                      _sqr = (CPLib.eqr(Cursor_qbe_estrai_frz.GetString("SEGNO"),"D")?"RECEIVE":"SEND");
                      /* ElseIf pmcParametri.w_flgsegno='2' */
                    } else if (CPLib.eqr(pmcParametri.row.w_flgsegno,"2")) {
                      /* _sqr := iif(qbe_estrai_frz->SEGNO='A','RECEIVE','SEND') */
                      _sqr = (CPLib.eqr(Cursor_qbe_estrai_frz.GetString("SEGNO"),"A")?"RECEIVE":"SEND");
                    } // End If
                  } else { // Else
                    /* _sqr := iif(qbe_estrai_frz->SEGNO='A','RECEIVE','SEND') */
                    _sqr = (CPLib.eqr(Cursor_qbe_estrai_frz.GetString("SEGNO"),"A")?"RECEIVE":"SEND");
                  } // End If
                  /* _numprog := qbe_estrai_frz->NUMPROG */
                  _numprog = Cursor_qbe_estrai_frz.GetString("NUMPROG");
                  /* _coddip := qbe_estrai_frz->CODDIPE */
                  _coddip = Cursor_qbe_estrai_frz.GetString("CODDIPE");
                  /* _ajwcode := qbe_estrai_frz->AGACCODE */
                  _ajwcode = Cursor_qbe_estrai_frz.GetString("AGACCODE");
                  /* _namdip := qbe_estrai_frz->DESCRIZ */
                  _namdip = Cursor_qbe_estrai_frz.GetString("DESCRIZ");
                  /* _citdip := qbe_estrai_frz->DESCCIT */
                  _citdip = Cursor_qbe_estrai_frz.GetString("DESCCIT");
                  /* _prvdip := qbe_estrai_frz->PROVINCIA */
                  _prvdip = Cursor_qbe_estrai_frz.GetString("PROVINCIA");
                  /* _cabdip := qbe_estrai_frz->CAB */
                  _cabdip = Cursor_qbe_estrai_frz.GetString("CAB");
                  /* _inddip := qbe_estrai_frz->DOMICILIO */
                  _inddip = Cursor_qbe_estrai_frz.GetString("DOMICILIO");
                  /* numprog := qbe_estrai_frz->MTCN */
                  numprog = Cursor_qbe_estrai_frz.GetString("MTCN");
                  /* dataope := DateToChar(qbe_estrai_frz->DATAOPE) */
                  dataope = CPLib.DateToChar(Cursor_qbe_estrai_frz.GetDate("DATAOPE"));
                  /* _dataope := qbe_estrai_frz->DATAOPE */
                  _dataope = Cursor_qbe_estrai_frz.GetDate("DATAOPE");
                  /* f_datope := arfn_fdate(qbe_estrai_frz->DATAOPE) */
                  f_datope = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_estrai_frz.GetDate("DATAOPE"));
                  /* totimp := qbe_estrai_frz->TOTLIRE / 100 */
                  totimp = CPLib.Round(Cursor_qbe_estrai_frz.GetDouble("TOTLIRE")/100,2);
                  /* _ndg := LRTrim(qbe_estrai_frz->CONNESCLI) */
                  _ndg = CPLib.LRTrim(Cursor_qbe_estrai_frz.GetString("CONNESCLI"));
                  /* _connesdoc := LRTrim(qbe_estrai_frz->CONNESDOC) */
                  _connesdoc = CPLib.LRTrim(Cursor_qbe_estrai_frz.GetString("CONNESDOC"));
                  /* _datareg := qbe_estrai_frz->DATAREG */
                  _datareg = Cursor_qbe_estrai_frz.GetDate("DATAREG");
                  /* _stator := qbe_estrai_frz->STATOREG */
                  _stator = Cursor_qbe_estrai_frz.GetString("STATOREG");
                  /* _datarett := qbe_estrai_frz->DATARETT */
                  _datarett = Cursor_qbe_estrai_frz.GetDate("DATARETT");
                  /* _numsto := '' */
                  _numsto = "";
                  /* _datasto := iif(pmcParametri.w_storico='O',qbe_estrai_frz->DATAOPE,qbe_estrai_frz->DATAREG) */
                  _datasto = (CPLib.eqr(pmcParametri.row.w_storico,"O")?Cursor_qbe_estrai_frz.GetDate("DATAOPE"):Cursor_qbe_estrai_frz.GetDate("DATAREG"));
                  /* Exec "Estrazione Dati Anagrafici" Page 13:Page_13 */
                  Page_13();
                  /* nominativo := qbe_estrai_frz->C_RAG */
                  nominativo = Cursor_qbe_estrai_frz.GetString("C_RAG");
                  /* _nazben := qbe_estrai_frz->C_STA */
                  _nazben = Cursor_qbe_estrai_frz.GetString("C_STA");
                  /* _iban := LRTrim(qbe_estrai_frz->C_RAPPORTO) */
                  _iban = CPLib.LRTrim(Cursor_qbe_estrai_frz.GetString("C_RAPPORTO"));
                  /* tipope := qbe_estrai_frz->TIPOOPRAP */
                  tipope = Cursor_qbe_estrai_frz.GetString("TIPOOPRAP");
                  /* cauana := qbe_estrai_frz->CODANA */
                  cauana = Cursor_qbe_estrai_frz.GetString("CODANA");
                  /* causin := qbe_estrai_frz->CODVOC */
                  causin = Cursor_qbe_estrai_frz.GetString("CODVOC");
                  /* segno := qbe_estrai_frz->SEGNO */
                  segno = Cursor_qbe_estrai_frz.GetString("SEGNO");
                  /* _rifimp := qbe_estrai_frz->RIFIMP */
                  _rifimp = Cursor_qbe_estrai_frz.GetString("RIFIMP");
                  /* _rifimp2 := qbe_estrai_frz->INFORM */
                  _rifimp2 = Cursor_qbe_estrai_frz.GetString("INFORM");
                  /* _mtcn := qbe_estrai_frz->MTCN */
                  _mtcn = Cursor_qbe_estrai_frz.GetString("MTCN");
                  /* _macage := qbe_estrai_frz->MACROAGENTE */
                  _macage = Cursor_qbe_estrai_frz.GetString("MACROAGENTE");
                  /* f_datreg := arfn_fdate(qbe_estrai_frz->DATAREG) */
                  f_datreg = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_estrai_frz.GetDate("DATAREG"));
                  /* _rapporto := qbe_estrai_frz->RAPPORTO */
                  _rapporto = Cursor_qbe_estrai_frz.GetString("RAPPORTO");
                  /* _dcauana := '' */
                  _dcauana = "";
                  /* _dcausin := '' */
                  _dcausin = "";
                  /* _dpaesedes := '' */
                  _dpaesedes = "";
                  /* _dtipoope := '' */
                  _dtipoope = "";
                  /* If mcTBCAUANA.GoToKey(cauana+Left(causin,2)) */
                  if (mcTBCAUANA.GoToKey(cauana+CPLib.Left(causin,2))) {
                    /* _dcauana := mcTBCAUANA.DESCRI */
                    _dcauana = mcTBCAUANA.row.DESCRI;
                  } // End If
                  /* If Upper(LRTrim(cauana))='U2' */
                  if (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(cauana)),"U2")) {
                    /* If Left(causin,2)='80' */
                    if (CPLib.eqr(CPLib.Left(causin,2),"80")) {
                      /* _dcauana := 'Consegna di mezzi di pagamento da parte di clientela' */
                      _dcauana = "Consegna di mezzi di pagamento da parte di clientela";
                      /* _dcausin := 'Consegna mezzi di pagamento' */
                      _dcausin = "Consegna mezzi di pagamento";
                    } else { // Else
                      /* _dcauana := 'Ritiro di mezzi di pagamento da parte di clientela' */
                      _dcauana = "Ritiro di mezzi di pagamento da parte di clientela";
                      /* _dcausin := 'Ritiro mezzi di pagamento' */
                      _dcausin = "Ritiro mezzi di pagamento";
                    } // End If
                  } else { // Else
                    /* If mcTBCAUSIN.GoToKey(Left(causin,2)) */
                    if (mcTBCAUSIN.GoToKey(CPLib.Left(causin,2))) {
                      /* _dcausin := mcTBCAUSIN.DESCRIZ */
                      _dcausin = mcTBCAUSIN.row.DESCRIZ;
                    } // End If
                  } // End If
                  /* If mcTBTIPREG.GoToKey(tipope) */
                  if (mcTBTIPREG.GoToKey(tipope)) {
                    /* _dtipoope := mcTBTIPREG.DES1 */
                    _dtipoope = mcTBTIPREG.row.DES1;
                  } // End If
                  /* If mcTBSTATI.GoToKey(_nazben) */
                  if (mcTBSTATI.GoToKey(_nazben)) {
                    /* _dpaesedes := mcTBSTATI.DESCRI */
                    _dpaesedes = mcTBSTATI.row.DESCRI;
                  } // End If
                  /* _dstator := iif(_stator='0','Attiva',iif(_stator='1','Attiva dopo modifica',iif(_stator='2','Cancellata','Copia di modificata'))) */
                  _dstator = (CPLib.eqr(_stator,"0")?"Attiva":(CPLib.eqr(_stator,"1")?"Attiva dopo modifica":(CPLib.eqr(_stator,"2")?"Cancellata":"Copia di modificata")));
                  /* _orgdati := 'F' */
                  _orgdati = "F";
                  /* If not(mcANADIP.GoToKey(_coddip)) */
                  if ( ! (mcANADIP.GoToKey(_coddip))) {
                    /* mcANADIP.AppendWithKey(_coddip) */
                    mcANADIP.AppendWithKey(_coddip);
                    /* mcANADIP.CODDIP := _coddip */
                    mcANADIP.row.CODDIP = _coddip;
                    /* mcANADIP.DESCRIZ := _namdip */
                    mcANADIP.row.DESCRIZ = _namdip;
                    /* mcANADIP.DESCCIT := _citdip */
                    mcANADIP.row.DESCCIT = _citdip;
                    /* mcANADIP.DOMICILIO := _inddip */
                    mcANADIP.row.DOMICILIO = _inddip;
                    /* mcANADIP.PROVINCIA := _prvdip */
                    mcANADIP.row.PROVINCIA = _prvdip;
                    /* mcANADIP.CAB := _cabdip */
                    mcANADIP.row.CAB = _cabdip;
                    /* mcANADIP.MACROAGENTE := _macage */
                    mcANADIP.row.MACROAGENTE = _macage;
                    /* mcANADIP.SaveRow() */
                    mcANADIP.SaveRow();
                  } // End If
                  /* If pmcParametri.w_tipoout='E' */
                  if (CPLib.eqr(pmcParametri.row.w_tipoout,"E")) {
                    /* Exec "Riga Excel" Page 10:Page_10 */
                    Page_10();
                    /* ElseIf pmcParametri.w_tipoout='T' */
                  } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"T")) {
                    /* Exec "Riga TXT" Page 11:Page_11 */
                    Page_11();
                    /* ElseIf pmcParametri.w_tipoout='C' */
                  } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"C")) {
                    /* Exec "Riga CSV" Page 12:Page_12 */
                    Page_12();
                  } else { // Else
                    /* _ctot := _ctot + 1 */
                    _ctot = CPLib.Round(_ctot+1,0);
                    // * --- Insert into dw_operazioni from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("dw_operazioni");
                    m_cPhName = m_Ctx.GetPhName("dw_operazioni");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dw_operazioni",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_xls_func",395,"000001C7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000001C7(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_ctot,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_sqr,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_namdip,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_citdip,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_numprog,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(totimp,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_ndg,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_cogman,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_nomman,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(sesso,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_luonas,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datnas,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(codfisc,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipdoc,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_numdoc,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datadoc,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_autril,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(citres,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(capres,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(prvres,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(indirizzo,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(stares,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_dtipoope,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_dcauana,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_dcausin,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(segno,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_dataope,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(nominativo,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_dpaesedes,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_dstator,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datareg,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_orgdati,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(numprog,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_macage,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_cfestero,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"dw_operazioni",true);
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
                  Cursor_qbe_estrai_frz.Next();
                }
                m_cConnectivityError = Cursor_qbe_estrai_frz.ErrorMessage();
                Cursor_qbe_estrai_frz.Close();
                // * --- End Select
              } else { // Else
                /* If pmcParametri.pTipo <> 'B' */
                if (CPLib.ne(pmcParametri.row.pTipo,"B")) {
                  /* gMsgImp := 'Lettura informazioni in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) // Messaggio Import */
                  gMsgImp = "Lettura informazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0));
                  m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                } // End If
              } // End If
              /* _contacicli := _contacicli+1 */
              _contacicli = CPLib.Round(_contacicli+1,0);
            } // End While
          } // End If
          /* If pmcParametri.w_opesel='S' */
          if (CPLib.eqr(pmcParametri.row.w_opesel,"S")) {
            /* _max := 0 */
            _max = CPLib.Round(0,0);
            /* _min := 0 */
            _min = CPLib.Round(0,0);
            /* _tot := 0 */
            _tot = CPLib.Round(0,0);
            // * --- Select from qbe_estrai_ope_lim
            SPBridge.HMCaller _h000001CF;
            _h000001CF = new SPBridge.HMCaller();
            _h000001CF.Set("m_cVQRList",m_cVQRList);
            _h000001CF.Set("cdadata",_cfromdate);
            _h000001CF.Set("c_adata",_c_todate);
            _h000001CF.Set("cDIP",pmcParametri.row.w_cDIP);
            _h000001CF.Set("cCODFISC",pmcParametri.row.w_cCODFISC);
            _h000001CF.Set("cMTCN",pmcParametri.row.w_cMTCN);
            _h000001CF.Set("codmag",pmcParametri.row.w_codmag);
            _h000001CF.Set("_mstato",_mstato);
            _h000001CF.Set("_lststati",pmcParametri.row.w_lststa);
            _h000001CF.Set("_lstprov",pmcParametri.row.w_lstprv);
            _h000001CF.Set("_importo",_importo);
            if (Cursor_qbe_estrai_ope_lim!=null)
              Cursor_qbe_estrai_ope_lim.Close();
            Cursor_qbe_estrai_ope_lim = new VQRHolder("qbe_estrai_ope_lim",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001CF,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_estrai_ope_lim.Eof())) {
              /* _max := qbe_estrai_ope_lim->maxope */
              _max = CPLib.Round(Cursor_qbe_estrai_ope_lim.GetDouble("maxope"),0);
              /* _min := qbe_estrai_ope_lim->minope */
              _min = CPLib.Round(Cursor_qbe_estrai_ope_lim.GetDouble("minope"),0);
              /* _tot := qbe_estrai_ope_lim->totope */
              _tot = CPLib.Round(Cursor_qbe_estrai_ope_lim.GetDouble("totope"),0);
              Cursor_qbe_estrai_ope_lim.Next();
            }
            m_cConnectivityError = Cursor_qbe_estrai_ope_lim.ErrorMessage();
            Cursor_qbe_estrai_ope_lim.Close();
            // * --- End Select
            /* _mono := iif(_tot > 75000,0,1) */
            _mono = CPLib.Round((CPLib.gt(_tot,75000)?0:1),0);
            /* If _mono = 1 */
            if (CPLib.eqr(_mono,1)) {
              /* If _tot = 0 */
              if (CPLib.eqr(_tot,0)) {
                /* _cicli := 0 */
                _cicli = CPLib.Round(0,0);
              } else { // Else
                /* _cicli := 1 */
                _cicli = CPLib.Round(1,0);
              } // End If
            } else { // Else
              /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
              _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
            } // End If
            /* _contacicli := 1 */
            _contacicli = CPLib.Round(1,0);
            /* While _contacicli<=_cicli */
            while (CPLib.le(_contacicli,_cicli)) {
              /* If _mono = 1 */
              if (CPLib.eqr(_mono,1)) {
                /* _bottom := _min */
                _bottom = CPLib.Round(_min,0);
                /* _top := _max */
                _top = CPLib.Round(_max,0);
              } else { // Else
                /* _bottom := ((_contacicli -1 ) * 5000) + 1 */
                _bottom = CPLib.Round(((_contacicli-1)*5000)+1,0);
                /* _top := _contacicli * 5000 */
                _top = CPLib.Round(_contacicli*5000,0);
              } // End If
              /* If pmcParametri.pTipo <> 'B' */
              if (CPLib.ne(pmcParametri.row.pTipo,"B")) {
                /* gMsgImp := 'Lettura informazioni in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) // Messaggio Import */
                gMsgImp = "Lettura informazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0));
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              } // End If
              /* If _top>=_min */
              if (CPLib.ge(_top,_min)) {
                // * --- Select from qbe_estrai_ope
                SPBridge.HMCaller _h000001E3;
                _h000001E3 = new SPBridge.HMCaller();
                _h000001E3.Set("m_cVQRList",m_cVQRList);
                _h000001E3.Set("cdadata",_cfromdate);
                _h000001E3.Set("c_adata",_c_todate);
                _h000001E3.Set("cDIP",pmcParametri.row.w_cDIP);
                _h000001E3.Set("cCODFISC",pmcParametri.row.w_cCODFISC);
                _h000001E3.Set("cMTCN",pmcParametri.row.w_cMTCN);
                _h000001E3.Set("codmag",pmcParametri.row.w_codmag);
                _h000001E3.Set("_bottom",_bottom);
                _h000001E3.Set("_top",_top);
                _h000001E3.Set("_mstato",_mstato);
                _h000001E3.Set("_lststati",pmcParametri.row.w_lststa);
                _h000001E3.Set("_lstprov",pmcParametri.row.w_lstprv);
                _h000001E3.Set("_importo",_importo);
                _h000001E3.Set("_stadest",pmcParametri.row.w_staben);
                if (Cursor_qbe_estrai_ope!=null)
                  Cursor_qbe_estrai_ope.Close();
                Cursor_qbe_estrai_ope = new VQRHolder("qbe_estrai_ope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001E3,true).GetResultSet(m_Ctx);
                while ( ! (Cursor_qbe_estrai_ope.Eof())) {
                  /* riga := riga + 1 */
                  riga = CPLib.Round(riga+1,0);
                  /* If pmcParametri.pTipo='B' */
                  if (CPLib.eqr(pmcParametri.row.pTipo,"B")) {
                    /* fmhand := FileLibMit.OpenWrite('./processi/EXT'+prcProg) */
                    fmhand = FileLibMit.OpenWrite("./processi/EXT"+prcProg);
                    /* FileLibMit.Write(fmhand,'Elaborazione del record '+LRTrim(Str(riga,10,0))+"/"+LRTrim(Str(_totalone,10,0))) */
                    FileLibMit.Write(fmhand,"Elaborazione del record "+CPLib.LRTrim(CPLib.Str(riga,10,0))+"/"+CPLib.LRTrim(CPLib.Str(_totalone,10,0)));
                    /* FileLibMit.Close(fmhand) */
                    FileLibMit.Close(fmhand);
                  } else { // Else
                    /* gMsgImp := 'Elaboro operazione con progressivo n°: '+qbe_estrai_ope->NUMPROG // Messaggio Import */
                    gMsgImp = "Elaboro operazione con progressivo n°: "+Cursor_qbe_estrai_ope.GetString("NUMPROG");
                    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                  } // End If
                  /* If qbe_estrai_ope->DATAOPE < CharToDate('20210101') */
                  if (CPLib.lt(Cursor_qbe_estrai_ope.GetDate("DATAOPE"),CPLib.CharToDate("20210101"))) {
                    /* If pmcParametri.w_flgsegno='1' */
                    if (CPLib.eqr(pmcParametri.row.w_flgsegno,"1")) {
                      /* _sqr := iif(qbe_estrai_ope->SEGNO='D','RECEIVE','SEND') */
                      _sqr = (CPLib.eqr(Cursor_qbe_estrai_ope.GetString("SEGNO"),"D")?"RECEIVE":"SEND");
                      /* ElseIf pmcParametri.w_flgsegno='2' */
                    } else if (CPLib.eqr(pmcParametri.row.w_flgsegno,"2")) {
                      /* _sqr := iif(qbe_estrai_ope->SEGNO='A','RECEIVE','SEND') */
                      _sqr = (CPLib.eqr(Cursor_qbe_estrai_ope.GetString("SEGNO"),"A")?"RECEIVE":"SEND");
                    } // End If
                  } else { // Else
                    /* _sqr := iif(qbe_estrai_ope->SEGNO='A','RECEIVE','SEND') */
                    _sqr = (CPLib.eqr(Cursor_qbe_estrai_ope.GetString("SEGNO"),"A")?"RECEIVE":"SEND");
                  } // End If
                  /* _numprog := qbe_estrai_ope->NUMPROG */
                  _numprog = Cursor_qbe_estrai_ope.GetString("NUMPROG");
                  /* _coddip := qbe_estrai_ope->CODDIPE */
                  _coddip = Cursor_qbe_estrai_ope.GetString("CODDIPE");
                  /* _ajwcode := qbe_estrai_ope->AGACCODE */
                  _ajwcode = Cursor_qbe_estrai_ope.GetString("AGACCODE");
                  /* _namdip := qbe_estrai_ope->DESCRIZ */
                  _namdip = Cursor_qbe_estrai_ope.GetString("DESCRIZ");
                  /* _citdip := qbe_estrai_ope->DESCCIT */
                  _citdip = Cursor_qbe_estrai_ope.GetString("DESCCIT");
                  /* _prvdip := qbe_estrai_ope->PROVINCIA */
                  _prvdip = Cursor_qbe_estrai_ope.GetString("PROVINCIA");
                  /* _cabdip := qbe_estrai_ope->CAB */
                  _cabdip = Cursor_qbe_estrai_ope.GetString("CAB");
                  /* _inddip := qbe_estrai_ope->DOMICILIO */
                  _inddip = Cursor_qbe_estrai_ope.GetString("DOMICILIO");
                  /* numprog := qbe_estrai_ope->MTCN */
                  numprog = Cursor_qbe_estrai_ope.GetString("MTCN");
                  /* dataope := DateToChar(qbe_estrai_ope->DATAOPE) */
                  dataope = CPLib.DateToChar(Cursor_qbe_estrai_ope.GetDate("DATAOPE"));
                  /* _dataope := qbe_estrai_ope->DATAOPE */
                  _dataope = Cursor_qbe_estrai_ope.GetDate("DATAOPE");
                  /* f_datope := arfn_fdate(qbe_estrai_ope->DATAOPE) */
                  f_datope = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_estrai_ope.GetDate("DATAOPE"));
                  /* totimp := qbe_estrai_ope->TOTLIRE / 100 */
                  totimp = CPLib.Round(Cursor_qbe_estrai_ope.GetDouble("TOTLIRE")/100,2);
                  /* _ndg := LRTrim(qbe_estrai_ope->CONNESCLI) */
                  _ndg = CPLib.LRTrim(Cursor_qbe_estrai_ope.GetString("CONNESCLI"));
                  /* _connesdoc := LRTrim(qbe_estrai_ope->CONNESDOC) */
                  _connesdoc = CPLib.LRTrim(Cursor_qbe_estrai_ope.GetString("CONNESDOC"));
                  /* _datareg := qbe_estrai_ope->DATAREG */
                  _datareg = Cursor_qbe_estrai_ope.GetDate("DATAREG");
                  /* _stator := qbe_estrai_ope->STATOREG */
                  _stator = Cursor_qbe_estrai_ope.GetString("STATOREG");
                  /* _datarett := qbe_estrai_ope->DATARETT */
                  _datarett = Cursor_qbe_estrai_ope.GetDate("DATARETT");
                  /* _numsto := '' */
                  _numsto = "";
                  /* _datasto := iif(pmcParametri.w_storico='O',qbe_estrai_ope->DATAOPE,qbe_estrai_ope->DATAREG) */
                  _datasto = (CPLib.eqr(pmcParametri.row.w_storico,"O")?Cursor_qbe_estrai_ope.GetDate("DATAOPE"):Cursor_qbe_estrai_ope.GetDate("DATAREG"));
                  /* Exec "Estrazione Dati Anagrafici" Page 13:Page_13 */
                  Page_13();
                  /* nominativo := qbe_estrai_ope->C_RAG */
                  nominativo = Cursor_qbe_estrai_ope.GetString("C_RAG");
                  /* _nazben := qbe_estrai_ope->C_STA */
                  _nazben = Cursor_qbe_estrai_ope.GetString("C_STA");
                  /* _iban := LRTrim(qbe_estrai_ope->C_RAPPORTO) */
                  _iban = CPLib.LRTrim(Cursor_qbe_estrai_ope.GetString("C_RAPPORTO"));
                  /* tipope := qbe_estrai_ope->TIPOOPRAP */
                  tipope = Cursor_qbe_estrai_ope.GetString("TIPOOPRAP");
                  /* cauana := qbe_estrai_ope->CODANA */
                  cauana = Cursor_qbe_estrai_ope.GetString("CODANA");
                  /* causin := qbe_estrai_ope->CODVOC */
                  causin = Cursor_qbe_estrai_ope.GetString("CODVOC");
                  /* segno := qbe_estrai_ope->SEGNO */
                  segno = Cursor_qbe_estrai_ope.GetString("SEGNO");
                  /* _rifimp := qbe_estrai_ope->RIFIMP */
                  _rifimp = Cursor_qbe_estrai_ope.GetString("RIFIMP");
                  /* _rifimp2 := qbe_estrai_ope->INFORM */
                  _rifimp2 = Cursor_qbe_estrai_ope.GetString("INFORM");
                  /* _mtcn := qbe_estrai_ope->MTCN */
                  _mtcn = Cursor_qbe_estrai_ope.GetString("MTCN");
                  /* _macage := qbe_estrai_ope->MACROAGENTE */
                  _macage = Cursor_qbe_estrai_ope.GetString("MACROAGENTE");
                  /* f_datreg := arfn_fdate(qbe_estrai_ope->DATAREG) */
                  f_datreg = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_estrai_ope.GetDate("DATAREG"));
                  /* _rapporto := qbe_estrai_ope->RAPPORTO */
                  _rapporto = Cursor_qbe_estrai_ope.GetString("RAPPORTO");
                  /* _dcauana := '' */
                  _dcauana = "";
                  /* _dcausin := '' */
                  _dcausin = "";
                  /* _dpaesedes := '' */
                  _dpaesedes = "";
                  /* _dtipoope := '' */
                  _dtipoope = "";
                  /* If mcTBCAUANA.GoToKey(cauana+Left(causin,2)) */
                  if (mcTBCAUANA.GoToKey(cauana+CPLib.Left(causin,2))) {
                    /* _dcauana := mcTBCAUANA.DESCRI */
                    _dcauana = mcTBCAUANA.row.DESCRI;
                  } // End If
                  /* If Upper(LRTrim(cauana))='U2' */
                  if (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(cauana)),"U2")) {
                    /* If Left(causin,2)='80' */
                    if (CPLib.eqr(CPLib.Left(causin,2),"80")) {
                      /* _dcauana := 'Consegna di mezzi di pagamento da parte di clientela' */
                      _dcauana = "Consegna di mezzi di pagamento da parte di clientela";
                      /* _dcausin := 'Consegna mezzi di pagamento' */
                      _dcausin = "Consegna mezzi di pagamento";
                    } else { // Else
                      /* _dcauana := 'Ritiro di mezzi di pagamento da parte di clientela' */
                      _dcauana = "Ritiro di mezzi di pagamento da parte di clientela";
                      /* _dcausin := 'Ritiro mezzi di pagamento' */
                      _dcausin = "Ritiro mezzi di pagamento";
                    } // End If
                  } else { // Else
                    /* If mcTBCAUSIN.GoToKey(Left(causin,2)) */
                    if (mcTBCAUSIN.GoToKey(CPLib.Left(causin,2))) {
                      /* _dcausin := mcTBCAUSIN.DESCRIZ */
                      _dcausin = mcTBCAUSIN.row.DESCRIZ;
                    } // End If
                  } // End If
                  /* If mcTBTIPREG.GoToKey(tipope) */
                  if (mcTBTIPREG.GoToKey(tipope)) {
                    /* _dtipoope := mcTBTIPREG.DES1 */
                    _dtipoope = mcTBTIPREG.row.DES1;
                  } // End If
                  /* If mcTBSTATI.GoToKey(_nazben) */
                  if (mcTBSTATI.GoToKey(_nazben)) {
                    /* _dpaesedes := mcTBSTATI.DESCRI */
                    _dpaesedes = mcTBSTATI.row.DESCRI;
                  } // End If
                  /* _dstator := iif(_stator='0','Attiva',iif(_stator='1','Attiva dopo modifica',iif(_stator='2','Cancellata','Copia di modificata'))) */
                  _dstator = (CPLib.eqr(_stator,"0")?"Attiva":(CPLib.eqr(_stator,"1")?"Attiva dopo modifica":(CPLib.eqr(_stator,"2")?"Cancellata":"Copia di modificata")));
                  /* _orgdati := 'O' */
                  _orgdati = "O";
                  /* If not(mcANADIP.GoToKey(_coddip)) */
                  if ( ! (mcANADIP.GoToKey(_coddip))) {
                    /* mcANADIP.AppendWithKey(_coddip) */
                    mcANADIP.AppendWithKey(_coddip);
                    /* mcANADIP.CODDIP := _coddip */
                    mcANADIP.row.CODDIP = _coddip;
                    /* mcANADIP.DESCRIZ := _namdip */
                    mcANADIP.row.DESCRIZ = _namdip;
                    /* mcANADIP.DESCCIT := _citdip */
                    mcANADIP.row.DESCCIT = _citdip;
                    /* mcANADIP.DOMICILIO := _inddip */
                    mcANADIP.row.DOMICILIO = _inddip;
                    /* mcANADIP.PROVINCIA := _prvdip */
                    mcANADIP.row.PROVINCIA = _prvdip;
                    /* mcANADIP.CAB := _cabdip */
                    mcANADIP.row.CAB = _cabdip;
                    /* mcANADIP.MACROAGENTE := _macage */
                    mcANADIP.row.MACROAGENTE = _macage;
                    /* mcANADIP.SaveRow() */
                    mcANADIP.SaveRow();
                  } // End If
                  /* If pmcParametri.w_tipoout='E' */
                  if (CPLib.eqr(pmcParametri.row.w_tipoout,"E")) {
                    /* Exec "Riga Excel" Page 10:Page_10 */
                    Page_10();
                    /* ElseIf pmcParametri.w_tipoout='T' */
                  } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"T")) {
                    /* Exec "Riga TXT" Page 11:Page_11 */
                    Page_11();
                    /* ElseIf pmcParametri.w_tipoout='C' */
                  } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"C")) {
                    /* Exec "Riga CSV" Page 12:Page_12 */
                    Page_12();
                  } else { // Else
                    /* _ctot := _ctot + 1 */
                    _ctot = CPLib.Round(_ctot+1,0);
                    // * --- Insert into dw_operazioni from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("dw_operazioni");
                    m_cPhName = m_Ctx.GetPhName("dw_operazioni");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dw_operazioni",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_xls_func",395,"00000237")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000237(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_ctot,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_sqr,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_namdip,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_citdip,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_numprog,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(totimp,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_ndg,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_cogman,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_nomman,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(sesso,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_luonas,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datnas,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(codfisc,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_tipdoc,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_numdoc,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datadoc,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_autril,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(citres,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(capres,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(prvres,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(indirizzo,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(stares,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_dtipoope,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_dcauana,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_dcausin,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(segno,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_dataope,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(nominativo,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_dpaesedes,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_dstator,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datareg,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_orgdati,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(numprog,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_macage,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_cfestero,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"dw_operazioni",true);
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
                  Cursor_qbe_estrai_ope.Next();
                }
                m_cConnectivityError = Cursor_qbe_estrai_ope.ErrorMessage();
                Cursor_qbe_estrai_ope.Close();
                // * --- End Select
              } else { // Else
                /* If pmcParametri.pTipo <> 'B' */
                if (CPLib.ne(pmcParametri.row.pTipo,"B")) {
                  /* gMsgImp := 'Lettura informazioni in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) // Messaggio Import */
                  gMsgImp = "Lettura informazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0));
                  m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                } // End If
              } // End If
              /* _contacicli := _contacicli+1 */
              _contacicli = CPLib.Round(_contacicli+1,0);
            } // End While
          } // End If
        } else { // Else
          /* If Empty(LRTrim(pmcParametri.w_connes)) */
          if (CPLib.Empty(CPLib.LRTrim(pmcParametri.row.w_connes))) {
            /* _ragsoc := iif(Empty(LRTrim(pmcParametri.w_ragosc)),'','%'+LRTrim(pmcParametri.w_ragosc)+"%") */
            _ragsoc = (CPLib.Empty(CPLib.LRTrim(pmcParametri.row.w_ragosc))?"":"%"+CPLib.LRTrim(pmcParametri.row.w_ragosc)+"%");
            // * --- Select from qbe_sele_sogg
            SPBridge.HMCaller _h0000023D;
            _h0000023D = new SPBridge.HMCaller();
            _h0000023D.Set("m_cVQRList",m_cVQRList);
            _h0000023D.Set("ragosc",_ragsoc);
            _h0000023D.Set("citnas",pmcParametri.row.w_citnas);
            _h0000023D.Set("datnas",pmcParametri.row.w_datnas);
            _h0000023D.Set("stanas",pmcParametri.row.w_stanas);
            if (Cursor_qbe_sele_sogg!=null)
              Cursor_qbe_sele_sogg.Close();
            Cursor_qbe_sele_sogg = new VQRHolder("qbe_sele_sogg",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000023D,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_sele_sogg.Eof())) {
              // * --- Insert into tmp_newpers from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_newpers");
              m_cPhName = m_Ctx.GetPhName("tmp_newpers");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_newpers",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_xls_func",395,"0000023E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000023E(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_sele_sogg.GetString("CONNES"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_newpers",true);
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
              Cursor_qbe_sele_sogg.Next();
            }
            m_cConnectivityError = Cursor_qbe_sele_sogg.ErrorMessage();
            Cursor_qbe_sele_sogg.Close();
            // * --- End Select
          } else { // Else
            // * --- Insert into tmp_newpers from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_newpers");
            m_cPhName = m_Ctx.GetPhName("tmp_newpers");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_newpers",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_xls_func",395,"0000023F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000023F(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(pmcParametri.row.w_connes,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_newpers",true);
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
          /* Exec "Lettura per SOG" Page 8:Page_8 */
          Page_8();
        } // End If
      } else { // Else
        /* If not(Empty(pmcParametri.w_nomefile)) */
        if ( ! (CPLib.Empty(pmcParametri.row.w_nomefile))) {
          /* Exec "Legge il file XLSX" Page 7:Page_7 */
          Page_7();
          /* ElseIf not(Empty(pmcParametri.w_cCODFISC)) */
        } else if ( ! (CPLib.Empty(pmcParametri.row.w_cCODFISC))) {
          // * --- Insert into tmp_mtcn_cf from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_mtcn_cf");
          m_cPhName = m_Ctx.GetPhName("tmp_mtcn_cf");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_mtcn_cf",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_xls_func",395,"00000243")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000243(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(pmcParametri.row.w_cCODFISC,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_mtcn_cf",true);
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
          /* pmcParametri.w_tipofile := '2' */
          pmcParametri.row.w_tipofile = "2";
        } // End If
        /* If pmcParametri.w_tipofile='1' */
        if (CPLib.eqr(pmcParametri.row.w_tipofile,"1")) {
          /* Exec "Lettura per MTCN" Page 9:Page_9 */
          Page_9();
          /* ElseIf pmcParametri.w_tipofile='2' */
        } else if (CPLib.eqr(pmcParametri.row.w_tipofile,"2")) {
          // * --- Select from qbe_sele_sogg2
          if (Cursor_qbe_sele_sogg2!=null)
            Cursor_qbe_sele_sogg2.Close();
          Cursor_qbe_sele_sogg2 = new VQRHolder("qbe_sele_sogg2",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_sele_sogg2.Eof())) {
            // * --- Insert into tmp_newpers from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_newpers");
            m_cPhName = m_Ctx.GetPhName("tmp_newpers");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_newpers",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_xls_func",395,"00000248")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000248(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_sele_sogg2.GetString("CONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_newpers",true);
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
            Cursor_qbe_sele_sogg2.Next();
          }
          m_cConnectivityError = Cursor_qbe_sele_sogg2.ErrorMessage();
          Cursor_qbe_sele_sogg2.Close();
          // * --- End Select
          /* Exec "Lettura per SOG" Page 8:Page_8 */
          Page_8();
        } // End If
      } // End If
    } finally {
      try {
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_frz_lim!=null)
          Cursor_qbe_estrai_frz_lim.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_frz!=null)
          Cursor_qbe_estrai_frz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_ope_lim!=null)
          Cursor_qbe_estrai_ope_lim.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_ope!=null)
          Cursor_qbe_estrai_ope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_sele_sogg!=null)
          Cursor_qbe_sele_sogg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_sele_sogg2!=null)
          Cursor_qbe_sele_sogg2.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_7() throws Exception {
    //base
    InputStream ExcelFileToRead = new FileInputStream(CPLib.LRTrim(_gPathApp)+"/appo/"+CPLib.LRTrim(_gAzienda)+"/"+CPLib.LRTrim(_nomefile));
    XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
    
    conta = wb.getNumberOfSheets();
    
    //XSSFWorkbook test = new XSSFWorkbook(); 
    
    //XSSFSheet sheet = wb.getSheetAt(0);
    XSSFRow row; 
    XSSFCell cell;
    
    XSSFRow row2; 
    XSSFCell cell2;
    
    //Iterator rows = sheet.rowIterator();
    
    _i =0;
    /* While _i < conta */
    while (CPLib.lt(_i,conta)) {
      //Apro uno ad uno i fogli del file Excel
      XSSFSheet sheet = wb.getSheetAt(_i);
      //Mi definisco un oggetto che contiene tutte le righe
      Iterator rows = sheet.rowIterator();
      //_righe = sheet.getLastRowNum()+1;
      //_y = 1;
      /* While rows.hasNext() */
      while (rows.hasNext()) {
        //scorro le righe
        row=(XSSFRow) rows.next();
        //Mi definisco un oggetto che contiene tutte le celle della riga letta
        Iterator cells = row.cellIterator();
        /* cell_count := 0 */
        cell_count = CPLib.Round(0,0);
        /* riga_letta := riga_letta+1 // riga letta del file Excel */
        riga_letta = CPLib.Round(riga_letta+1,0);
        /* While cells.hasNext() and riga_letta>1 */
        while (cells.hasNext() && CPLib.gt(riga_letta,1)) {
          //scorro le celle della riga
          cell=(XSSFCell) cells.next();
          /* cell_count := cell_count+1 */
          cell_count = CPLib.Round(cell_count+1,0);
          /* column01 := cell.getStringCellValue() */
          column01 = cell.getStringCellValue();
        } // End While
        /* If pmcParametri.w_tipofile='1' */
        if (CPLib.eqr(pmcParametri.row.w_tipofile,"1")) {
          /* _mtcn := Left(LRTrim(column01),10) */
          _mtcn = CPLib.Left(CPLib.LRTrim(column01),10);
          /* codfisc := '' */
          codfisc = "";
          /* ElseIf pmcParametri.w_tipofile='2' */
        } else if (CPLib.eqr(pmcParametri.row.w_tipofile,"2")) {
          /* codfisc := Left(LRTrim(column01),16) */
          codfisc = CPLib.Left(CPLib.LRTrim(column01),16);
          /* _mtcn := '' */
          _mtcn = "";
        } // End If
        /* If (not(Empty(LRTrim(_mtcn))) and pmcParametri.w_tipofile='1') or (not(Empty(LRTrim(codfisc))) and pmcParametri.w_tipofile='2') */
        if (( ! (CPLib.Empty(CPLib.LRTrim(_mtcn))) && CPLib.eqr(pmcParametri.row.w_tipofile,"1")) || ( ! (CPLib.Empty(CPLib.LRTrim(codfisc))) && CPLib.eqr(pmcParametri.row.w_tipofile,"2"))) {
          // * --- Insert into tmp_mtcn_cf from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_mtcn_cf");
          m_cPhName = m_Ctx.GetPhName("tmp_mtcn_cf");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_mtcn_cf",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_xls_func",395,"0000025C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000025C(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_mtcn,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(codfisc,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_mtcn_cf",true);
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
      } // End While
      _i++;
    } // End While
    // Cancella il file excel di input
    ExcelFileToRead.close();
    FileLibMit.DeleteFilePath(CPLib.LRTrim(_gPathApp)+"/appo/"+CPLib.LRTrim(_gAzienda)+"/"+CPLib.LRTrim(_nomefile));
  }
  void Page_8() throws Exception {
    CPResultSet Cursor_qbe_estrai_frz_sog=null;
    CPResultSet Cursor_qbe_estrai_ope_sog=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* If pmcParametri.w_frzsel='S' */
      if (CPLib.eqr(pmcParametri.row.w_frzsel,"S")) {
        // * --- Select from qbe_estrai_frz_sog
        SPBridge.HMCaller _h00000260;
        _h00000260 = new SPBridge.HMCaller();
        _h00000260.Set("m_cVQRList",m_cVQRList);
        _h00000260.Set("cdadata",_cfromdate);
        _h00000260.Set("c_adata",_c_todate);
        _h00000260.Set("cDIP",pmcParametri.row.w_cDIP);
        _h00000260.Set("cCODFISC",pmcParametri.row.w_cCODFISC);
        _h00000260.Set("cMTCN",pmcParametri.row.w_cMTCN);
        _h00000260.Set("codmag",pmcParametri.row.w_codmag);
        _h00000260.Set("_mstato",_mstato);
        _h00000260.Set("_lststati",pmcParametri.row.w_lststa);
        _h00000260.Set("_lstprov",pmcParametri.row.w_lstprv);
        _h00000260.Set("_importo",_importo);
        _h00000260.Set("_stadest",pmcParametri.row.w_staben);
        if (Cursor_qbe_estrai_frz_sog!=null)
          Cursor_qbe_estrai_frz_sog.Close();
        Cursor_qbe_estrai_frz_sog = new VQRHolder("qbe_estrai_frz_sog",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000260,true).GetResultSet(m_Ctx);
        if ( ! (Cursor_qbe_estrai_frz_sog.Eof())) {
          while ( ! (Cursor_qbe_estrai_frz_sog.Eof())) {
            /* gMsgImp := 'Elaboro frazionata con progressivo n°: '+qbe_estrai_frz_sog->NUMPROG // Messaggio Import */
            gMsgImp = "Elaboro frazionata con progressivo n°: "+Cursor_qbe_estrai_frz_sog.GetString("NUMPROG");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* riga := riga + 1 */
            riga = CPLib.Round(riga+1,0);
            /* If qbe_estrai_frz_sog->DATAOPE < CharToDate('20210101') */
            if (CPLib.lt(Cursor_qbe_estrai_frz_sog.GetDate("DATAOPE"),CPLib.CharToDate("20210101"))) {
              /* If pmcParametri.w_flgsegno='1' */
              if (CPLib.eqr(pmcParametri.row.w_flgsegno,"1")) {
                /* _sqr := iif(qbe_estrai_frz_sog->SEGNO='D','RECEIVE','SEND') */
                _sqr = (CPLib.eqr(Cursor_qbe_estrai_frz_sog.GetString("SEGNO"),"D")?"RECEIVE":"SEND");
                /* ElseIf pmcParametri.w_flgsegno='2' */
              } else if (CPLib.eqr(pmcParametri.row.w_flgsegno,"2")) {
                /* _sqr := iif(qbe_estrai_frz_sog->SEGNO='A','RECEIVE','SEND') */
                _sqr = (CPLib.eqr(Cursor_qbe_estrai_frz_sog.GetString("SEGNO"),"A")?"RECEIVE":"SEND");
              } // End If
            } else { // Else
              /* _sqr := iif(qbe_estrai_frz_sog->SEGNO='A','RECEIVE','SEND') */
              _sqr = (CPLib.eqr(Cursor_qbe_estrai_frz_sog.GetString("SEGNO"),"A")?"RECEIVE":"SEND");
            } // End If
            /* _coddip := qbe_estrai_frz_sog->CODDIPE */
            _coddip = Cursor_qbe_estrai_frz_sog.GetString("CODDIPE");
            /* _ajwcode := qbe_estrai_frz_sog->AGACCODE */
            _ajwcode = Cursor_qbe_estrai_frz_sog.GetString("AGACCODE");
            /* _numprog := qbe_estrai_frz_sog->NUMPROG */
            _numprog = Cursor_qbe_estrai_frz_sog.GetString("NUMPROG");
            /* _namdip := qbe_estrai_frz_sog->DESCRIZ */
            _namdip = Cursor_qbe_estrai_frz_sog.GetString("DESCRIZ");
            /* _citdip := qbe_estrai_frz_sog->DESCCIT */
            _citdip = Cursor_qbe_estrai_frz_sog.GetString("DESCCIT");
            /* _prvdip := qbe_estrai_frz_sog->PROVINCIA */
            _prvdip = Cursor_qbe_estrai_frz_sog.GetString("PROVINCIA");
            /* _cabdip := qbe_estrai_frz_sog->CAB */
            _cabdip = Cursor_qbe_estrai_frz_sog.GetString("CAB");
            /* _inddip := qbe_estrai_frz_sog->DOMICILIO */
            _inddip = Cursor_qbe_estrai_frz_sog.GetString("DOMICILIO");
            /* numprog := qbe_estrai_frz_sog->MTCN */
            numprog = Cursor_qbe_estrai_frz_sog.GetString("MTCN");
            /* dataope := DateToChar(qbe_estrai_frz_sog->DATAOPE) */
            dataope = CPLib.DateToChar(Cursor_qbe_estrai_frz_sog.GetDate("DATAOPE"));
            /* _dataope := qbe_estrai_frz_sog->DATAOPE */
            _dataope = Cursor_qbe_estrai_frz_sog.GetDate("DATAOPE");
            /* f_datope := arfn_fdate(qbe_estrai_frz_sog->DATAOPE) */
            f_datope = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_estrai_frz_sog.GetDate("DATAOPE"));
            /* f_datreg := arfn_fdate(qbe_estrai_frz_sog->DATAREG) */
            f_datreg = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_estrai_frz_sog.GetDate("DATAREG"));
            /* _rapporto := qbe_estrai_frz_sog->RAPPORTO */
            _rapporto = Cursor_qbe_estrai_frz_sog.GetString("RAPPORTO");
            /* totimp := qbe_estrai_frz_sog->TOTLIRE / 100 */
            totimp = CPLib.Round(Cursor_qbe_estrai_frz_sog.GetDouble("TOTLIRE")/100,2);
            /* _ndg := LRTrim(qbe_estrai_frz_sog->CONNESCLI) */
            _ndg = CPLib.LRTrim(Cursor_qbe_estrai_frz_sog.GetString("CONNESCLI"));
            /* _connesdoc := LRTrim(qbe_estrai_frz_sog->CONNESDOC) */
            _connesdoc = CPLib.LRTrim(Cursor_qbe_estrai_frz_sog.GetString("CONNESDOC"));
            /* _datareg := qbe_estrai_frz_sog->DATAREG */
            _datareg = Cursor_qbe_estrai_frz_sog.GetDate("DATAREG");
            /* _stator := qbe_estrai_frz_sog->STATOREG */
            _stator = Cursor_qbe_estrai_frz_sog.GetString("STATOREG");
            /* _datarett := qbe_estrai_frz_sog->DATARETT */
            _datarett = Cursor_qbe_estrai_frz_sog.GetDate("DATARETT");
            /* _numsto := '' */
            _numsto = "";
            /* _datasto := iif(pmcParametri.w_storico='O',qbe_estrai_frz_sog->DATAOPE,qbe_estrai_frz_sog->DATAREG) */
            _datasto = (CPLib.eqr(pmcParametri.row.w_storico,"O")?Cursor_qbe_estrai_frz_sog.GetDate("DATAOPE"):Cursor_qbe_estrai_frz_sog.GetDate("DATAREG"));
            /* Exec "Estrazione Dati Anagrafici" Page 13:Page_13 */
            Page_13();
            /* nominativo := qbe_estrai_frz_sog->C_RAG */
            nominativo = Cursor_qbe_estrai_frz_sog.GetString("C_RAG");
            /* _nazben := qbe_estrai_frz_sog->C_STA */
            _nazben = Cursor_qbe_estrai_frz_sog.GetString("C_STA");
            /* tipope := qbe_estrai_frz_sog->TIPOOPRAP */
            tipope = Cursor_qbe_estrai_frz_sog.GetString("TIPOOPRAP");
            /* cauana := qbe_estrai_frz_sog->CODANA */
            cauana = Cursor_qbe_estrai_frz_sog.GetString("CODANA");
            /* causin := qbe_estrai_frz_sog->CODVOC */
            causin = Cursor_qbe_estrai_frz_sog.GetString("CODVOC");
            /* segno := qbe_estrai_frz_sog->SEGNO */
            segno = Cursor_qbe_estrai_frz_sog.GetString("SEGNO");
            /* _rifimp := qbe_estrai_frz_sog->RIFIMP */
            _rifimp = Cursor_qbe_estrai_frz_sog.GetString("RIFIMP");
            /* _rifimp2 := qbe_estrai_frz_sog->INFORM */
            _rifimp2 = Cursor_qbe_estrai_frz_sog.GetString("INFORM");
            /* _mtcn := qbe_estrai_frz_sog->MTCN */
            _mtcn = Cursor_qbe_estrai_frz_sog.GetString("MTCN");
            /* _macage := qbe_estrai_frz_sog->MACROAGENTE */
            _macage = Cursor_qbe_estrai_frz_sog.GetString("MACROAGENTE");
            /* f_datreg := arfn_fdate(qbe_estrai_frz_sog->DATAREG) */
            f_datreg = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_estrai_frz_sog.GetDate("DATAREG"));
            /* _rapporto := qbe_estrai_frz_sog->RAPPORTO */
            _rapporto = Cursor_qbe_estrai_frz_sog.GetString("RAPPORTO");
            /* _dcauana := '' */
            _dcauana = "";
            /* _dcausin := '' */
            _dcausin = "";
            /* _dpaesedes := '' */
            _dpaesedes = "";
            /* _dtipoope := '' */
            _dtipoope = "";
            /* If mcTBCAUANA.GoToKey(cauana+Left(causin,2)) */
            if (mcTBCAUANA.GoToKey(cauana+CPLib.Left(causin,2))) {
              /* _dcauana := mcTBCAUANA.DESCRI */
              _dcauana = mcTBCAUANA.row.DESCRI;
            } // End If
            /* If Upper(LRTrim(cauana))='U2' */
            if (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(cauana)),"U2")) {
              /* If Left(causin,2)='80' */
              if (CPLib.eqr(CPLib.Left(causin,2),"80")) {
                /* _dcauana := 'Consegna di mezzi di pagamento da parte di clientela' */
                _dcauana = "Consegna di mezzi di pagamento da parte di clientela";
                /* _dcausin := 'Consegna mezzi di pagamento' */
                _dcausin = "Consegna mezzi di pagamento";
              } else { // Else
                /* _dcauana := 'Ritiro di mezzi di pagamento da parte di clientela' */
                _dcauana = "Ritiro di mezzi di pagamento da parte di clientela";
                /* _dcausin := 'Ritiro mezzi di pagamento' */
                _dcausin = "Ritiro mezzi di pagamento";
              } // End If
            } else { // Else
              /* If mcTBCAUSIN.GoToKey(Left(causin,2)) */
              if (mcTBCAUSIN.GoToKey(CPLib.Left(causin,2))) {
                /* _dcausin := mcTBCAUSIN.DESCRIZ */
                _dcausin = mcTBCAUSIN.row.DESCRIZ;
              } // End If
            } // End If
            /* If mcTBTIPREG.GoToKey(tipope) */
            if (mcTBTIPREG.GoToKey(tipope)) {
              /* _dtipoope := mcTBTIPREG.DES1 */
              _dtipoope = mcTBTIPREG.row.DES1;
            } // End If
            /* If mcTBSTATI.GoToKey(_nazben) */
            if (mcTBSTATI.GoToKey(_nazben)) {
              /* _dpaesedes := mcTBSTATI.DESCRI */
              _dpaesedes = mcTBSTATI.row.DESCRI;
            } // End If
            /* _dstator := iif(_stator='0','Attiva',iif(_stator='1','Attiva dopo modifica',iif(_stator='2','Cancellata','Copia di modificata'))) */
            _dstator = (CPLib.eqr(_stator,"0")?"Attiva":(CPLib.eqr(_stator,"1")?"Attiva dopo modifica":(CPLib.eqr(_stator,"2")?"Cancellata":"Copia di modificata")));
            /* _orgdati := 'F' */
            _orgdati = "F";
            /* If not(mcANADIP.GoToKey(_coddip)) */
            if ( ! (mcANADIP.GoToKey(_coddip))) {
              /* mcANADIP.AppendWithKey(_coddip) */
              mcANADIP.AppendWithKey(_coddip);
              /* mcANADIP.CODDIP := _coddip */
              mcANADIP.row.CODDIP = _coddip;
              /* mcANADIP.DESCRIZ := _namdip */
              mcANADIP.row.DESCRIZ = _namdip;
              /* mcANADIP.DESCCIT := _citdip */
              mcANADIP.row.DESCCIT = _citdip;
              /* mcANADIP.DOMICILIO := _inddip */
              mcANADIP.row.DOMICILIO = _inddip;
              /* mcANADIP.PROVINCIA := _prvdip */
              mcANADIP.row.PROVINCIA = _prvdip;
              /* mcANADIP.CAB := _cabdip */
              mcANADIP.row.CAB = _cabdip;
              /* mcANADIP.MACROAGENTE := _macage */
              mcANADIP.row.MACROAGENTE = _macage;
              /* mcANADIP.SaveRow() */
              mcANADIP.SaveRow();
            } // End If
            /* If pmcParametri.w_tipoout='E' */
            if (CPLib.eqr(pmcParametri.row.w_tipoout,"E")) {
              /* Exec "Riga Excel" Page 10:Page_10 */
              Page_10();
              /* ElseIf pmcParametri.w_tipoout='T' */
            } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"T")) {
              /* Exec "Riga TXT" Page 11:Page_11 */
              Page_11();
              /* ElseIf pmcParametri.w_tipoout='C' */
            } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"C")) {
              /* Exec "Riga CSV" Page 12:Page_12 */
              Page_12();
            } else { // Else
              /* _ctot := _ctot + 1 */
              _ctot = CPLib.Round(_ctot+1,0);
              // * --- Insert into dw_operazioni from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("dw_operazioni");
              m_cPhName = m_Ctx.GetPhName("dw_operazioni");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dw_operazioni",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_xls_func",395,"000002B1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000002B1(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_ctot,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_sqr,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_namdip,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_citdip,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_numprog,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(totimp,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_ndg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cogman,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_nomman,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(sesso,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_luonas,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datnas,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(codfisc,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_tipdoc,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_numdoc,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datadoc,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_autril,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(citres,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(capres,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(prvres,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(indirizzo,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(stares,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_dtipoope,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_dcauana,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_dcausin,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(segno,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_dataope,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nominativo,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_dpaesedes,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_dstator,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datareg,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_orgdati,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(numprog,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_macage,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cfestero,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"dw_operazioni",true);
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
            Cursor_qbe_estrai_frz_sog.Next();
          }
          m_cConnectivityError = Cursor_qbe_estrai_frz_sog.ErrorMessage();
        } else {
          // No rows selected
        }
        Cursor_qbe_estrai_frz_sog.Close();
        // * --- End Select
      } // End If
      /* If pmcParametri.w_opesel='S' */
      if (CPLib.eqr(pmcParametri.row.w_opesel,"S")) {
        // * --- Select from qbe_estrai_ope_sog
        SPBridge.HMCaller _h000002B3;
        _h000002B3 = new SPBridge.HMCaller();
        _h000002B3.Set("m_cVQRList",m_cVQRList);
        _h000002B3.Set("cdadata",_cfromdate);
        _h000002B3.Set("c_adata",_c_todate);
        _h000002B3.Set("cDIP",pmcParametri.row.w_cDIP);
        _h000002B3.Set("cCODFISC",pmcParametri.row.w_cCODFISC);
        _h000002B3.Set("cMTCN",pmcParametri.row.w_cMTCN);
        _h000002B3.Set("codmag",pmcParametri.row.w_codmag);
        _h000002B3.Set("_mstato",_mstato);
        _h000002B3.Set("_lststati",pmcParametri.row.w_lststa);
        _h000002B3.Set("_lstprov",pmcParametri.row.w_lstprv);
        _h000002B3.Set("_importo",_importo);
        _h000002B3.Set("_stadest",pmcParametri.row.w_staben);
        if (Cursor_qbe_estrai_ope_sog!=null)
          Cursor_qbe_estrai_ope_sog.Close();
        Cursor_qbe_estrai_ope_sog = new VQRHolder("qbe_estrai_ope_sog",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000002B3,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_estrai_ope_sog.Eof())) {
          /* gMsgImp := 'Elaboro operazione con progressivo n°: '+qbe_estrai_ope_sog->NUMPROG // Messaggio Import */
          gMsgImp = "Elaboro operazione con progressivo n°: "+Cursor_qbe_estrai_ope_sog.GetString("NUMPROG");
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* riga := riga + 1 */
          riga = CPLib.Round(riga+1,0);
          /* If qbe_estrai_ope_sog->DATAOPE < CharToDate('20210101') */
          if (CPLib.lt(Cursor_qbe_estrai_ope_sog.GetDate("DATAOPE"),CPLib.CharToDate("20210101"))) {
            /* If pmcParametri.w_flgsegno='1' */
            if (CPLib.eqr(pmcParametri.row.w_flgsegno,"1")) {
              /* _sqr := iif(qbe_estrai_ope_sog->SEGNO='D','RECEIVE','SEND') */
              _sqr = (CPLib.eqr(Cursor_qbe_estrai_ope_sog.GetString("SEGNO"),"D")?"RECEIVE":"SEND");
              /* ElseIf pmcParametri.w_flgsegno='2' */
            } else if (CPLib.eqr(pmcParametri.row.w_flgsegno,"2")) {
              /* _sqr := iif(qbe_estrai_ope_sog->SEGNO='A','RECEIVE','SEND') */
              _sqr = (CPLib.eqr(Cursor_qbe_estrai_ope_sog.GetString("SEGNO"),"A")?"RECEIVE":"SEND");
            } // End If
          } else { // Else
            /* _sqr := iif(qbe_estrai_ope_sog->SEGNO='A','RECEIVE','SEND') */
            _sqr = (CPLib.eqr(Cursor_qbe_estrai_ope_sog.GetString("SEGNO"),"A")?"RECEIVE":"SEND");
          } // End If
          /* _numprog := qbe_estrai_ope_sog->NUMPROG */
          _numprog = Cursor_qbe_estrai_ope_sog.GetString("NUMPROG");
          /* _coddip := qbe_estrai_ope_sog->CODDIPE */
          _coddip = Cursor_qbe_estrai_ope_sog.GetString("CODDIPE");
          /* _ajwcode := qbe_estrai_ope_sog->AGACCODE */
          _ajwcode = Cursor_qbe_estrai_ope_sog.GetString("AGACCODE");
          /* _namdip := qbe_estrai_ope_sog->DESCRIZ */
          _namdip = Cursor_qbe_estrai_ope_sog.GetString("DESCRIZ");
          /* _citdip := qbe_estrai_ope_sog->DESCCIT */
          _citdip = Cursor_qbe_estrai_ope_sog.GetString("DESCCIT");
          /* _prvdip := qbe_estrai_ope_sog->PROVINCIA */
          _prvdip = Cursor_qbe_estrai_ope_sog.GetString("PROVINCIA");
          /* _cabdip := qbe_estrai_ope_sog->CAB */
          _cabdip = Cursor_qbe_estrai_ope_sog.GetString("CAB");
          /* _inddip := qbe_estrai_ope_sog->DOMICILIO */
          _inddip = Cursor_qbe_estrai_ope_sog.GetString("DOMICILIO");
          /* numprog := qbe_estrai_ope_sog->MTCN */
          numprog = Cursor_qbe_estrai_ope_sog.GetString("MTCN");
          /* dataope := DateToChar(qbe_estrai_ope_sog->DATAOPE) */
          dataope = CPLib.DateToChar(Cursor_qbe_estrai_ope_sog.GetDate("DATAOPE"));
          /* _dataope := qbe_estrai_ope_sog->DATAOPE */
          _dataope = Cursor_qbe_estrai_ope_sog.GetDate("DATAOPE");
          /* f_datope := arfn_fdate(qbe_estrai_ope_sog->DATAOPE) */
          f_datope = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_estrai_ope_sog.GetDate("DATAOPE"));
          /* f_datreg := arfn_fdate(qbe_estrai_ope_sog->DATAREG) */
          f_datreg = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_estrai_ope_sog.GetDate("DATAREG"));
          /* _rapporto := qbe_estrai_ope_sog->RAPPORTO */
          _rapporto = Cursor_qbe_estrai_ope_sog.GetString("RAPPORTO");
          /* totimp := qbe_estrai_ope_sog->TOTLIRE / 100 */
          totimp = CPLib.Round(Cursor_qbe_estrai_ope_sog.GetDouble("TOTLIRE")/100,2);
          /* _ndg := LRTrim(qbe_estrai_ope_sog->CONNESCLI) */
          _ndg = CPLib.LRTrim(Cursor_qbe_estrai_ope_sog.GetString("CONNESCLI"));
          /* _connesdoc := LRTrim(qbe_estrai_ope_sog->CONNESDOC) */
          _connesdoc = CPLib.LRTrim(Cursor_qbe_estrai_ope_sog.GetString("CONNESDOC"));
          /* _datareg := qbe_estrai_ope_sog->DATAREG */
          _datareg = Cursor_qbe_estrai_ope_sog.GetDate("DATAREG");
          /* _stator := qbe_estrai_ope_sog->STATOREG */
          _stator = Cursor_qbe_estrai_ope_sog.GetString("STATOREG");
          /* _datarett := qbe_estrai_ope_sog->DATARETT */
          _datarett = Cursor_qbe_estrai_ope_sog.GetDate("DATARETT");
          /* _numsto := '' */
          _numsto = "";
          /* _datasto := iif(pmcParametri.w_storico='O',qbe_estrai_ope_sog->DATAOPE,qbe_estrai_ope_sog->DATAREG) */
          _datasto = (CPLib.eqr(pmcParametri.row.w_storico,"O")?Cursor_qbe_estrai_ope_sog.GetDate("DATAOPE"):Cursor_qbe_estrai_ope_sog.GetDate("DATAREG"));
          /* Exec "Estrazione Dati Anagrafici" Page 13:Page_13 */
          Page_13();
          /* nominativo := qbe_estrai_ope_sog->C_RAG */
          nominativo = Cursor_qbe_estrai_ope_sog.GetString("C_RAG");
          /* _nazben := qbe_estrai_ope_sog->C_STA */
          _nazben = Cursor_qbe_estrai_ope_sog.GetString("C_STA");
          /* tipope := qbe_estrai_ope_sog->TIPOOPRAP */
          tipope = Cursor_qbe_estrai_ope_sog.GetString("TIPOOPRAP");
          /* cauana := qbe_estrai_ope_sog->CODANA */
          cauana = Cursor_qbe_estrai_ope_sog.GetString("CODANA");
          /* causin := qbe_estrai_ope_sog->CODVOC */
          causin = Cursor_qbe_estrai_ope_sog.GetString("CODVOC");
          /* segno := qbe_estrai_ope_sog->SEGNO */
          segno = Cursor_qbe_estrai_ope_sog.GetString("SEGNO");
          /* _rifimp := qbe_estrai_ope_sog->RIFIMP */
          _rifimp = Cursor_qbe_estrai_ope_sog.GetString("RIFIMP");
          /* _rifimp2 := qbe_estrai_ope_sog->INFORM */
          _rifimp2 = Cursor_qbe_estrai_ope_sog.GetString("INFORM");
          /* _mtcn := qbe_estrai_ope_sog->MTCN */
          _mtcn = Cursor_qbe_estrai_ope_sog.GetString("MTCN");
          /* _macage := qbe_estrai_ope_sog->MACROAGENTE */
          _macage = Cursor_qbe_estrai_ope_sog.GetString("MACROAGENTE");
          /* f_datreg := arfn_fdate(qbe_estrai_ope_sog->DATAREG) */
          f_datreg = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_estrai_ope_sog.GetDate("DATAREG"));
          /* _rapporto := qbe_estrai_ope_sog->RAPPORTO */
          _rapporto = Cursor_qbe_estrai_ope_sog.GetString("RAPPORTO");
          /* _dcauana := '' */
          _dcauana = "";
          /* _dcausin := '' */
          _dcausin = "";
          /* _dpaesedes := '' */
          _dpaesedes = "";
          /* _dtipoope := '' */
          _dtipoope = "";
          /* If mcTBCAUANA.GoToKey(cauana+Left(causin,2)) */
          if (mcTBCAUANA.GoToKey(cauana+CPLib.Left(causin,2))) {
            /* _dcauana := mcTBCAUANA.DESCRI */
            _dcauana = mcTBCAUANA.row.DESCRI;
          } // End If
          /* If Upper(LRTrim(cauana))='U2' */
          if (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(cauana)),"U2")) {
            /* If Left(causin,2)='80' */
            if (CPLib.eqr(CPLib.Left(causin,2),"80")) {
              /* _dcauana := 'Consegna di mezzi di pagamento da parte di clientela' */
              _dcauana = "Consegna di mezzi di pagamento da parte di clientela";
              /* _dcausin := 'Consegna mezzi di pagamento' */
              _dcausin = "Consegna mezzi di pagamento";
            } else { // Else
              /* _dcauana := 'Ritiro di mezzi di pagamento da parte di clientela' */
              _dcauana = "Ritiro di mezzi di pagamento da parte di clientela";
              /* _dcausin := 'Ritiro mezzi di pagamento' */
              _dcausin = "Ritiro mezzi di pagamento";
            } // End If
          } else { // Else
            /* If mcTBCAUSIN.GoToKey(Left(causin,2)) */
            if (mcTBCAUSIN.GoToKey(CPLib.Left(causin,2))) {
              /* _dcausin := mcTBCAUSIN.DESCRIZ */
              _dcausin = mcTBCAUSIN.row.DESCRIZ;
            } // End If
          } // End If
          /* If mcTBTIPREG.GoToKey(tipope) */
          if (mcTBTIPREG.GoToKey(tipope)) {
            /* _dtipoope := mcTBTIPREG.DES1 */
            _dtipoope = mcTBTIPREG.row.DES1;
          } // End If
          /* If mcTBSTATI.GoToKey(_nazben) */
          if (mcTBSTATI.GoToKey(_nazben)) {
            /* _dpaesedes := mcTBSTATI.DESCRI */
            _dpaesedes = mcTBSTATI.row.DESCRI;
          } // End If
          /* _dstator := iif(_stator='0','Attiva',iif(_stator='1','Attiva dopo modifica',iif(_stator='2','Cancellata','Copia di modificata'))) */
          _dstator = (CPLib.eqr(_stator,"0")?"Attiva":(CPLib.eqr(_stator,"1")?"Attiva dopo modifica":(CPLib.eqr(_stator,"2")?"Cancellata":"Copia di modificata")));
          /* _orgdati := 'O' */
          _orgdati = "O";
          /* If not(mcANADIP.GoToKey(_coddip)) */
          if ( ! (mcANADIP.GoToKey(_coddip))) {
            /* mcANADIP.AppendWithKey(_coddip) */
            mcANADIP.AppendWithKey(_coddip);
            /* mcANADIP.CODDIP := _coddip */
            mcANADIP.row.CODDIP = _coddip;
            /* mcANADIP.DESCRIZ := _namdip */
            mcANADIP.row.DESCRIZ = _namdip;
            /* mcANADIP.DESCCIT := _citdip */
            mcANADIP.row.DESCCIT = _citdip;
            /* mcANADIP.DOMICILIO := _inddip */
            mcANADIP.row.DOMICILIO = _inddip;
            /* mcANADIP.PROVINCIA := _prvdip */
            mcANADIP.row.PROVINCIA = _prvdip;
            /* mcANADIP.CAB := _cabdip */
            mcANADIP.row.CAB = _cabdip;
            /* mcANADIP.MACROAGENTE := _macage */
            mcANADIP.row.MACROAGENTE = _macage;
            /* mcANADIP.SaveRow() */
            mcANADIP.SaveRow();
          } // End If
          /* If pmcParametri.w_tipoout='E' */
          if (CPLib.eqr(pmcParametri.row.w_tipoout,"E")) {
            /* Exec "Riga Excel" Page 10:Page_10 */
            Page_10();
            /* ElseIf pmcParametri.w_tipoout='T' */
          } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"T")) {
            /* Exec "Riga TXT" Page 11:Page_11 */
            Page_11();
            /* ElseIf pmcParametri.w_tipoout='C' */
          } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"C")) {
            /* Exec "Riga CSV" Page 12:Page_12 */
            Page_12();
          } else { // Else
            /* _ctot := _ctot + 1 */
            _ctot = CPLib.Round(_ctot+1,0);
            // * --- Insert into dw_operazioni from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("dw_operazioni");
            m_cPhName = m_Ctx.GetPhName("dw_operazioni");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dw_operazioni",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_xls_func",395,"00000304")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000304(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_ctot,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_sqr,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_namdip,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_citdip,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_numprog,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(totimp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_ndg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_cogman,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_nomman,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(sesso,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_luonas,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datnas,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(codfisc,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipdoc,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_numdoc,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datadoc,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_autril,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(citres,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(capres,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(prvres,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(indirizzo,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(stares,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dtipoope,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dcausin,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(segno,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dataope,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nominativo,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dpaesedes,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dstator,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datareg,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_orgdati,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(numprog,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_macage,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_cfestero,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"dw_operazioni",true);
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
          Cursor_qbe_estrai_ope_sog.Next();
        }
        m_cConnectivityError = Cursor_qbe_estrai_ope_sog.ErrorMessage();
        Cursor_qbe_estrai_ope_sog.Close();
        // * --- End Select
      } // End If
    } finally {
      try {
        if (Cursor_qbe_estrai_frz_sog!=null)
          Cursor_qbe_estrai_frz_sog.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_ope_sog!=null)
          Cursor_qbe_estrai_ope_sog.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_9() throws Exception {
    CPResultSet Cursor_qbe_estrai_frz_mtcn=null;
    CPResultSet Cursor_qbe_estrai_ope_mtcn=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* If pmcParametri.w_frzsel='S' */
      if (CPLib.eqr(pmcParametri.row.w_frzsel,"S")) {
        // * --- Select from qbe_estrai_frz_mtcn
        SPBridge.HMCaller _h00000306;
        _h00000306 = new SPBridge.HMCaller();
        _h00000306.Set("m_cVQRList",m_cVQRList);
        _h00000306.Set("cdadata",_cfromdate);
        _h00000306.Set("c_adata",_c_todate);
        _h00000306.Set("cDIP",pmcParametri.row.w_cDIP);
        _h00000306.Set("cCODFISC",pmcParametri.row.w_cCODFISC);
        _h00000306.Set("cMTCN",pmcParametri.row.w_cMTCN);
        _h00000306.Set("codmag",pmcParametri.row.w_codmag);
        _h00000306.Set("_mstato",_mstato);
        _h00000306.Set("_lststati",pmcParametri.row.w_lststa);
        _h00000306.Set("_lstprov",pmcParametri.row.w_lstprv);
        _h00000306.Set("_importo",_importo);
        _h00000306.Set("_stadest",pmcParametri.row.w_staben);
        if (Cursor_qbe_estrai_frz_mtcn!=null)
          Cursor_qbe_estrai_frz_mtcn.Close();
        Cursor_qbe_estrai_frz_mtcn = new VQRHolder("qbe_estrai_frz_mtcn",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000306,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_estrai_frz_mtcn.Eof())) {
          /* gMsgImp := 'Elaboro frazionata con progressivo n°: '+qbe_estrai_frz_mtcn->NUMPROG // Messaggio Import */
          gMsgImp = "Elaboro frazionata con progressivo n°: "+Cursor_qbe_estrai_frz_mtcn.GetString("NUMPROG");
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* riga := riga + 1 */
          riga = CPLib.Round(riga+1,0);
          /* If qbe_estrai_frz_mtcn->DATAOPE < CharToDate('20210101') */
          if (CPLib.lt(Cursor_qbe_estrai_frz_mtcn.GetDate("DATAOPE"),CPLib.CharToDate("20210101"))) {
            /* If pmcParametri.w_flgsegno='1' */
            if (CPLib.eqr(pmcParametri.row.w_flgsegno,"1")) {
              /* _sqr := iif(qbe_estrai_frz_mtcn->SEGNO='D','RECEIVE','SEND') */
              _sqr = (CPLib.eqr(Cursor_qbe_estrai_frz_mtcn.GetString("SEGNO"),"D")?"RECEIVE":"SEND");
              /* ElseIf pmcParametri.w_flgsegno='2' */
            } else if (CPLib.eqr(pmcParametri.row.w_flgsegno,"2")) {
              /* _sqr := iif(qbe_estrai_frz_mtcn->SEGNO='A','RECEIVE','SEND') */
              _sqr = (CPLib.eqr(Cursor_qbe_estrai_frz_mtcn.GetString("SEGNO"),"A")?"RECEIVE":"SEND");
            } // End If
          } else { // Else
            /* _sqr := iif(qbe_estrai_frz_mtcn->SEGNO='A','RECEIVE','SEND') */
            _sqr = (CPLib.eqr(Cursor_qbe_estrai_frz_mtcn.GetString("SEGNO"),"A")?"RECEIVE":"SEND");
          } // End If
          /* _coddip := qbe_estrai_frz_mtcn->CODDIPE */
          _coddip = Cursor_qbe_estrai_frz_mtcn.GetString("CODDIPE");
          /* _ajwcode := qbe_estrai_frz_mtcn->AGACCODE */
          _ajwcode = Cursor_qbe_estrai_frz_mtcn.GetString("AGACCODE");
          /* _numprog := qbe_estrai_frz_mtcn->NUMPROG */
          _numprog = Cursor_qbe_estrai_frz_mtcn.GetString("NUMPROG");
          /* _namdip := qbe_estrai_frz_mtcn->DESCRIZ */
          _namdip = Cursor_qbe_estrai_frz_mtcn.GetString("DESCRIZ");
          /* _citdip := qbe_estrai_frz_mtcn->DESCCIT */
          _citdip = Cursor_qbe_estrai_frz_mtcn.GetString("DESCCIT");
          /* _prvdip := qbe_estrai_frz_mtcn->PROVINCIA */
          _prvdip = Cursor_qbe_estrai_frz_mtcn.GetString("PROVINCIA");
          /* _cabdip := qbe_estrai_frz_mtcn->CAB */
          _cabdip = Cursor_qbe_estrai_frz_mtcn.GetString("CAB");
          /* _inddip := qbe_estrai_frz_mtcn->DOMICILIO */
          _inddip = Cursor_qbe_estrai_frz_mtcn.GetString("DOMICILIO");
          /* numprog := qbe_estrai_frz_mtcn->MTCN */
          numprog = Cursor_qbe_estrai_frz_mtcn.GetString("MTCN");
          /* dataope := DateToChar(qbe_estrai_frz_mtcn->DATAOPE) */
          dataope = CPLib.DateToChar(Cursor_qbe_estrai_frz_mtcn.GetDate("DATAOPE"));
          /* _dataope := qbe_estrai_frz_mtcn->DATAOPE */
          _dataope = Cursor_qbe_estrai_frz_mtcn.GetDate("DATAOPE");
          /* f_datope := arfn_fdate(qbe_estrai_frz_mtcn->DATAOPE) */
          f_datope = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_estrai_frz_mtcn.GetDate("DATAOPE"));
          /* f_datreg := arfn_fdate(qbe_estrai_frz_mtcn->DATAREG) */
          f_datreg = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_estrai_frz_mtcn.GetDate("DATAREG"));
          /* _rapporto := qbe_estrai_frz_mtcn->RAPPORTO */
          _rapporto = Cursor_qbe_estrai_frz_mtcn.GetString("RAPPORTO");
          /* totimp := qbe_estrai_frz_mtcn->TOTLIRE / 100 */
          totimp = CPLib.Round(Cursor_qbe_estrai_frz_mtcn.GetDouble("TOTLIRE")/100,2);
          /* _ndg := LRTrim(qbe_estrai_frz_mtcn->CONNESCLI) */
          _ndg = CPLib.LRTrim(Cursor_qbe_estrai_frz_mtcn.GetString("CONNESCLI"));
          /* _connesdoc := LRTrim(qbe_estrai_frz_mtcn->CONNESDOC) */
          _connesdoc = CPLib.LRTrim(Cursor_qbe_estrai_frz_mtcn.GetString("CONNESDOC"));
          /* _datareg := qbe_estrai_frz_mtcn->DATAREG */
          _datareg = Cursor_qbe_estrai_frz_mtcn.GetDate("DATAREG");
          /* _stator := qbe_estrai_frz_mtcn->STATOREG */
          _stator = Cursor_qbe_estrai_frz_mtcn.GetString("STATOREG");
          /* _datarett := qbe_estrai_frz_mtcn->DATARETT */
          _datarett = Cursor_qbe_estrai_frz_mtcn.GetDate("DATARETT");
          /* _numsto := '' */
          _numsto = "";
          /* _datasto := iif(pmcParametri.w_storico='O',qbe_estrai_frz_mtcn->DATAOPE,qbe_estrai_frz_mtcn->DATAREG) */
          _datasto = (CPLib.eqr(pmcParametri.row.w_storico,"O")?Cursor_qbe_estrai_frz_mtcn.GetDate("DATAOPE"):Cursor_qbe_estrai_frz_mtcn.GetDate("DATAREG"));
          /* Exec "Estrazione Dati Anagrafici" Page 13:Page_13 */
          Page_13();
          /* nominativo := qbe_estrai_frz_mtcn->C_RAG */
          nominativo = Cursor_qbe_estrai_frz_mtcn.GetString("C_RAG");
          /* _nazben := qbe_estrai_frz_mtcn->C_STA */
          _nazben = Cursor_qbe_estrai_frz_mtcn.GetString("C_STA");
          /* tipope := qbe_estrai_frz_mtcn->TIPOOPRAP */
          tipope = Cursor_qbe_estrai_frz_mtcn.GetString("TIPOOPRAP");
          /* cauana := qbe_estrai_frz_mtcn->CODANA */
          cauana = Cursor_qbe_estrai_frz_mtcn.GetString("CODANA");
          /* causin := qbe_estrai_frz_mtcn->CODVOC */
          causin = Cursor_qbe_estrai_frz_mtcn.GetString("CODVOC");
          /* segno := qbe_estrai_frz_mtcn->SEGNO */
          segno = Cursor_qbe_estrai_frz_mtcn.GetString("SEGNO");
          /* _rifimp := qbe_estrai_frz_mtcn->RIFIMP */
          _rifimp = Cursor_qbe_estrai_frz_mtcn.GetString("RIFIMP");
          /* _rifimp2 := qbe_estrai_frz_mtcn->INFORM */
          _rifimp2 = Cursor_qbe_estrai_frz_mtcn.GetString("INFORM");
          /* _mtcn := qbe_estrai_frz_mtcn->MTCN */
          _mtcn = Cursor_qbe_estrai_frz_mtcn.GetString("MTCN");
          /* _macage := qbe_estrai_frz_mtcn->MACROAGENTE */
          _macage = Cursor_qbe_estrai_frz_mtcn.GetString("MACROAGENTE");
          /* f_datreg := arfn_fdate(qbe_estrai_frz_mtcn->DATAREG) */
          f_datreg = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_estrai_frz_mtcn.GetDate("DATAREG"));
          /* _rapporto := qbe_estrai_frz_mtcn->RAPPORTO */
          _rapporto = Cursor_qbe_estrai_frz_mtcn.GetString("RAPPORTO");
          /* _dcauana := '' */
          _dcauana = "";
          /* _dcausin := '' */
          _dcausin = "";
          /* _dpaesedes := '' */
          _dpaesedes = "";
          /* _dtipoope := '' */
          _dtipoope = "";
          /* If mcTBCAUANA.GoToKey(cauana+Left(causin,2)) */
          if (mcTBCAUANA.GoToKey(cauana+CPLib.Left(causin,2))) {
            /* _dcauana := mcTBCAUANA.DESCRI */
            _dcauana = mcTBCAUANA.row.DESCRI;
          } // End If
          /* If Upper(LRTrim(cauana))='U2' */
          if (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(cauana)),"U2")) {
            /* If Left(causin,2)='80' */
            if (CPLib.eqr(CPLib.Left(causin,2),"80")) {
              /* _dcauana := 'Consegna di mezzi di pagamento da parte di clientela' */
              _dcauana = "Consegna di mezzi di pagamento da parte di clientela";
              /* _dcausin := 'Consegna mezzi di pagamento' */
              _dcausin = "Consegna mezzi di pagamento";
            } else { // Else
              /* _dcauana := 'Ritiro di mezzi di pagamento da parte di clientela' */
              _dcauana = "Ritiro di mezzi di pagamento da parte di clientela";
              /* _dcausin := 'Ritiro mezzi di pagamento' */
              _dcausin = "Ritiro mezzi di pagamento";
            } // End If
          } else { // Else
            /* If mcTBCAUSIN.GoToKey(Left(causin,2)) */
            if (mcTBCAUSIN.GoToKey(CPLib.Left(causin,2))) {
              /* _dcausin := mcTBCAUSIN.DESCRIZ */
              _dcausin = mcTBCAUSIN.row.DESCRIZ;
            } // End If
          } // End If
          /* If mcTBTIPREG.GoToKey(tipope) */
          if (mcTBTIPREG.GoToKey(tipope)) {
            /* _dtipoope := mcTBTIPREG.DES1 */
            _dtipoope = mcTBTIPREG.row.DES1;
          } // End If
          /* If mcTBSTATI.GoToKey(_nazben) */
          if (mcTBSTATI.GoToKey(_nazben)) {
            /* _dpaesedes := mcTBSTATI.DESCRI */
            _dpaesedes = mcTBSTATI.row.DESCRI;
          } // End If
          /* _dstator := iif(_stator='0','Attiva',iif(_stator='1','Attiva dopo modifica',iif(_stator='2','Cancellata','Copia di modificata'))) */
          _dstator = (CPLib.eqr(_stator,"0")?"Attiva":(CPLib.eqr(_stator,"1")?"Attiva dopo modifica":(CPLib.eqr(_stator,"2")?"Cancellata":"Copia di modificata")));
          /* _orgdati := 'F' */
          _orgdati = "F";
          /* If not(mcANADIP.GoToKey(_coddip)) */
          if ( ! (mcANADIP.GoToKey(_coddip))) {
            /* mcANADIP.AppendWithKey(_coddip) */
            mcANADIP.AppendWithKey(_coddip);
            /* mcANADIP.CODDIP := _coddip */
            mcANADIP.row.CODDIP = _coddip;
            /* mcANADIP.DESCRIZ := _namdip */
            mcANADIP.row.DESCRIZ = _namdip;
            /* mcANADIP.DESCCIT := _citdip */
            mcANADIP.row.DESCCIT = _citdip;
            /* mcANADIP.DOMICILIO := _inddip */
            mcANADIP.row.DOMICILIO = _inddip;
            /* mcANADIP.PROVINCIA := _prvdip */
            mcANADIP.row.PROVINCIA = _prvdip;
            /* mcANADIP.CAB := _cabdip */
            mcANADIP.row.CAB = _cabdip;
            /* mcANADIP.MACROAGENTE := _macage */
            mcANADIP.row.MACROAGENTE = _macage;
            /* mcANADIP.SaveRow() */
            mcANADIP.SaveRow();
          } // End If
          /* If pmcParametri.w_tipoout='E' */
          if (CPLib.eqr(pmcParametri.row.w_tipoout,"E")) {
            /* Exec "Riga Excel" Page 10:Page_10 */
            Page_10();
            /* ElseIf pmcParametri.w_tipoout='T' */
          } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"T")) {
            /* Exec "Riga TXT" Page 11:Page_11 */
            Page_11();
            /* ElseIf pmcParametri.w_tipoout='C' */
          } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"C")) {
            /* Exec "Riga CSV" Page 12:Page_12 */
            Page_12();
          } else { // Else
            /* _ctot := _ctot + 1 */
            _ctot = CPLib.Round(_ctot+1,0);
            // * --- Insert into dw_operazioni from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("dw_operazioni");
            m_cPhName = m_Ctx.GetPhName("dw_operazioni");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dw_operazioni",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_xls_func",395,"00000357")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000357(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_ctot,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_sqr,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_namdip,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_citdip,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_numprog,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(totimp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_ndg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_cogman,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_nomman,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(sesso,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_luonas,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datnas,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(codfisc,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipdoc,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_numdoc,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datadoc,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_autril,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(citres,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(capres,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(prvres,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(indirizzo,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(stares,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dtipoope,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dcausin,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(segno,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dataope,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nominativo,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dpaesedes,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dstator,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datareg,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_orgdati,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(numprog,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_macage,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_cfestero,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"dw_operazioni",true);
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
          Cursor_qbe_estrai_frz_mtcn.Next();
        }
        m_cConnectivityError = Cursor_qbe_estrai_frz_mtcn.ErrorMessage();
        Cursor_qbe_estrai_frz_mtcn.Close();
        // * --- End Select
      } // End If
      /* If pmcParametri.w_opesel='S' */
      if (CPLib.eqr(pmcParametri.row.w_opesel,"S")) {
        // * --- Select from qbe_estrai_ope_mtcn
        SPBridge.HMCaller _h00000359;
        _h00000359 = new SPBridge.HMCaller();
        _h00000359.Set("m_cVQRList",m_cVQRList);
        _h00000359.Set("cdadata",_cfromdate);
        _h00000359.Set("c_adata",_c_todate);
        _h00000359.Set("cDIP",pmcParametri.row.w_cDIP);
        _h00000359.Set("cCODFISC",pmcParametri.row.w_cCODFISC);
        _h00000359.Set("cMTCN",pmcParametri.row.w_cMTCN);
        _h00000359.Set("codmag",pmcParametri.row.w_codmag);
        _h00000359.Set("_mstato",_mstato);
        _h00000359.Set("_lststati",pmcParametri.row.w_lststa);
        _h00000359.Set("_lstprov",pmcParametri.row.w_lstprv);
        _h00000359.Set("_importo",_importo);
        _h00000359.Set("_stadest",pmcParametri.row.w_staben);
        if (Cursor_qbe_estrai_ope_mtcn!=null)
          Cursor_qbe_estrai_ope_mtcn.Close();
        Cursor_qbe_estrai_ope_mtcn = new VQRHolder("qbe_estrai_ope_mtcn",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000359,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_estrai_ope_mtcn.Eof())) {
          /* gMsgImp := 'Elaboro operazione con progressivo n°: '+qbe_estrai_ope_mtcn->NUMPROG // Messaggio Import */
          gMsgImp = "Elaboro operazione con progressivo n°: "+Cursor_qbe_estrai_ope_mtcn.GetString("NUMPROG");
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* riga := riga + 1 */
          riga = CPLib.Round(riga+1,0);
          /* If qbe_estrai_ope_mtcn->DATAOPE < CharToDate('20210101') */
          if (CPLib.lt(Cursor_qbe_estrai_ope_mtcn.GetDate("DATAOPE"),CPLib.CharToDate("20210101"))) {
            /* If pmcParametri.w_flgsegno='1' */
            if (CPLib.eqr(pmcParametri.row.w_flgsegno,"1")) {
              /* _sqr := iif(qbe_estrai_ope_mtcn->SEGNO='D','RECEIVE','SEND') */
              _sqr = (CPLib.eqr(Cursor_qbe_estrai_ope_mtcn.GetString("SEGNO"),"D")?"RECEIVE":"SEND");
              /* ElseIf pmcParametri.w_flgsegno='2' */
            } else if (CPLib.eqr(pmcParametri.row.w_flgsegno,"2")) {
              /* _sqr := iif(qbe_estrai_ope_mtcn->SEGNO='A','RECEIVE','SEND') */
              _sqr = (CPLib.eqr(Cursor_qbe_estrai_ope_mtcn.GetString("SEGNO"),"A")?"RECEIVE":"SEND");
            } // End If
          } else { // Else
            /* _sqr := iif(qbe_estrai_ope_mtcn->SEGNO='A','RECEIVE','SEND') */
            _sqr = (CPLib.eqr(Cursor_qbe_estrai_ope_mtcn.GetString("SEGNO"),"A")?"RECEIVE":"SEND");
          } // End If
          /* _numprog := qbe_estrai_ope_mtcn->NUMPROG */
          _numprog = Cursor_qbe_estrai_ope_mtcn.GetString("NUMPROG");
          /* _coddip := qbe_estrai_ope_mtcn->CODDIPE */
          _coddip = Cursor_qbe_estrai_ope_mtcn.GetString("CODDIPE");
          /* _ajwcode := qbe_estrai_ope_mtcn->AGACCODE */
          _ajwcode = Cursor_qbe_estrai_ope_mtcn.GetString("AGACCODE");
          /* _namdip := qbe_estrai_ope_mtcn->DESCRIZ */
          _namdip = Cursor_qbe_estrai_ope_mtcn.GetString("DESCRIZ");
          /* _citdip := qbe_estrai_ope_mtcn->DESCCIT */
          _citdip = Cursor_qbe_estrai_ope_mtcn.GetString("DESCCIT");
          /* _prvdip := qbe_estrai_ope_mtcn->PROVINCIA */
          _prvdip = Cursor_qbe_estrai_ope_mtcn.GetString("PROVINCIA");
          /* _cabdip := qbe_estrai_ope_mtcn->CAB */
          _cabdip = Cursor_qbe_estrai_ope_mtcn.GetString("CAB");
          /* _inddip := qbe_estrai_ope_mtcn->DOMICILIO */
          _inddip = Cursor_qbe_estrai_ope_mtcn.GetString("DOMICILIO");
          /* numprog := qbe_estrai_ope_mtcn->MTCN */
          numprog = Cursor_qbe_estrai_ope_mtcn.GetString("MTCN");
          /* dataope := DateToChar(qbe_estrai_ope_mtcn->DATAOPE) */
          dataope = CPLib.DateToChar(Cursor_qbe_estrai_ope_mtcn.GetDate("DATAOPE"));
          /* _dataope := qbe_estrai_ope_mtcn->DATAOPE */
          _dataope = Cursor_qbe_estrai_ope_mtcn.GetDate("DATAOPE");
          /* f_datope := arfn_fdate(qbe_estrai_ope_mtcn->DATAOPE) */
          f_datope = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_estrai_ope_mtcn.GetDate("DATAOPE"));
          /* f_datreg := arfn_fdate(qbe_estrai_ope_mtcn->DATAREG) */
          f_datreg = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_estrai_ope_mtcn.GetDate("DATAREG"));
          /* _rapporto := qbe_estrai_ope_mtcn->RAPPORTO */
          _rapporto = Cursor_qbe_estrai_ope_mtcn.GetString("RAPPORTO");
          /* totimp := qbe_estrai_ope_mtcn->TOTLIRE / 100 */
          totimp = CPLib.Round(Cursor_qbe_estrai_ope_mtcn.GetDouble("TOTLIRE")/100,2);
          /* _ndg := LRTrim(qbe_estrai_ope_mtcn->CONNESCLI) */
          _ndg = CPLib.LRTrim(Cursor_qbe_estrai_ope_mtcn.GetString("CONNESCLI"));
          /* _connesdoc := LRTrim(qbe_estrai_ope_mtcn->CONNESDOC) */
          _connesdoc = CPLib.LRTrim(Cursor_qbe_estrai_ope_mtcn.GetString("CONNESDOC"));
          /* _datareg := qbe_estrai_ope_mtcn->DATAREG */
          _datareg = Cursor_qbe_estrai_ope_mtcn.GetDate("DATAREG");
          /* _stator := qbe_estrai_ope_mtcn->STATOREG */
          _stator = Cursor_qbe_estrai_ope_mtcn.GetString("STATOREG");
          /* _datarett := qbe_estrai_ope_mtcn->DATARETT */
          _datarett = Cursor_qbe_estrai_ope_mtcn.GetDate("DATARETT");
          /* _numsto := '' */
          _numsto = "";
          /* _datasto := iif(pmcParametri.w_storico='O',qbe_estrai_ope_mtcn->DATAOPE,qbe_estrai_ope_mtcn->DATAREG) */
          _datasto = (CPLib.eqr(pmcParametri.row.w_storico,"O")?Cursor_qbe_estrai_ope_mtcn.GetDate("DATAOPE"):Cursor_qbe_estrai_ope_mtcn.GetDate("DATAREG"));
          /* Exec "Estrazione Dati Anagrafici" Page 13:Page_13 */
          Page_13();
          /* nominativo := qbe_estrai_ope_mtcn->C_RAG */
          nominativo = Cursor_qbe_estrai_ope_mtcn.GetString("C_RAG");
          /* _nazben := qbe_estrai_ope_mtcn->C_STA */
          _nazben = Cursor_qbe_estrai_ope_mtcn.GetString("C_STA");
          /* tipope := qbe_estrai_ope_mtcn->TIPOOPRAP */
          tipope = Cursor_qbe_estrai_ope_mtcn.GetString("TIPOOPRAP");
          /* cauana := qbe_estrai_ope_mtcn->CODANA */
          cauana = Cursor_qbe_estrai_ope_mtcn.GetString("CODANA");
          /* causin := qbe_estrai_ope_mtcn->CODVOC */
          causin = Cursor_qbe_estrai_ope_mtcn.GetString("CODVOC");
          /* segno := qbe_estrai_ope_mtcn->SEGNO */
          segno = Cursor_qbe_estrai_ope_mtcn.GetString("SEGNO");
          /* _rifimp := qbe_estrai_ope_mtcn->RIFIMP */
          _rifimp = Cursor_qbe_estrai_ope_mtcn.GetString("RIFIMP");
          /* _rifimp2 := qbe_estrai_ope_mtcn->INFORM */
          _rifimp2 = Cursor_qbe_estrai_ope_mtcn.GetString("INFORM");
          /* _mtcn := qbe_estrai_ope_mtcn->MTCN */
          _mtcn = Cursor_qbe_estrai_ope_mtcn.GetString("MTCN");
          /* _macage := qbe_estrai_ope_mtcn->MACROAGENTE */
          _macage = Cursor_qbe_estrai_ope_mtcn.GetString("MACROAGENTE");
          /* f_datreg := arfn_fdate(qbe_estrai_ope_mtcn->DATAREG) */
          f_datreg = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_estrai_ope_mtcn.GetDate("DATAREG"));
          /* _rapporto := qbe_estrai_ope_mtcn->RAPPORTO */
          _rapporto = Cursor_qbe_estrai_ope_mtcn.GetString("RAPPORTO");
          /* _dcauana := '' */
          _dcauana = "";
          /* _dcausin := '' */
          _dcausin = "";
          /* _dpaesedes := '' */
          _dpaesedes = "";
          /* _dtipoope := '' */
          _dtipoope = "";
          /* If mcTBCAUANA.GoToKey(cauana+Left(causin,2)) */
          if (mcTBCAUANA.GoToKey(cauana+CPLib.Left(causin,2))) {
            /* _dcauana := mcTBCAUANA.DESCRI */
            _dcauana = mcTBCAUANA.row.DESCRI;
          } // End If
          /* If Upper(LRTrim(cauana))='U2' */
          if (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(cauana)),"U2")) {
            /* If Left(causin,2)='80' */
            if (CPLib.eqr(CPLib.Left(causin,2),"80")) {
              /* _dcauana := 'Consegna di mezzi di pagamento da parte di clientela' */
              _dcauana = "Consegna di mezzi di pagamento da parte di clientela";
              /* _dcausin := 'Consegna mezzi di pagamento' */
              _dcausin = "Consegna mezzi di pagamento";
            } else { // Else
              /* _dcauana := 'Ritiro di mezzi di pagamento da parte di clientela' */
              _dcauana = "Ritiro di mezzi di pagamento da parte di clientela";
              /* _dcausin := 'Ritiro mezzi di pagamento' */
              _dcausin = "Ritiro mezzi di pagamento";
            } // End If
          } else { // Else
            /* If mcTBCAUSIN.GoToKey(Left(causin,2)) */
            if (mcTBCAUSIN.GoToKey(CPLib.Left(causin,2))) {
              /* _dcausin := mcTBCAUSIN.DESCRIZ */
              _dcausin = mcTBCAUSIN.row.DESCRIZ;
            } // End If
          } // End If
          /* If mcTBTIPREG.GoToKey(tipope) */
          if (mcTBTIPREG.GoToKey(tipope)) {
            /* _dtipoope := mcTBTIPREG.DES1 */
            _dtipoope = mcTBTIPREG.row.DES1;
          } // End If
          /* If mcTBSTATI.GoToKey(_nazben) */
          if (mcTBSTATI.GoToKey(_nazben)) {
            /* _dpaesedes := mcTBSTATI.DESCRI */
            _dpaesedes = mcTBSTATI.row.DESCRI;
          } // End If
          /* _dstator := iif(_stator='0','Attiva',iif(_stator='1','Attiva dopo modifica',iif(_stator='2','Cancellata','Copia di modificata'))) */
          _dstator = (CPLib.eqr(_stator,"0")?"Attiva":(CPLib.eqr(_stator,"1")?"Attiva dopo modifica":(CPLib.eqr(_stator,"2")?"Cancellata":"Copia di modificata")));
          /* _orgdati := 'O' */
          _orgdati = "O";
          /* If not(mcANADIP.GoToKey(_coddip)) */
          if ( ! (mcANADIP.GoToKey(_coddip))) {
            /* mcANADIP.AppendWithKey(_coddip) */
            mcANADIP.AppendWithKey(_coddip);
            /* mcANADIP.CODDIP := _coddip */
            mcANADIP.row.CODDIP = _coddip;
            /* mcANADIP.DESCRIZ := _namdip */
            mcANADIP.row.DESCRIZ = _namdip;
            /* mcANADIP.DESCCIT := _citdip */
            mcANADIP.row.DESCCIT = _citdip;
            /* mcANADIP.DOMICILIO := _inddip */
            mcANADIP.row.DOMICILIO = _inddip;
            /* mcANADIP.PROVINCIA := _prvdip */
            mcANADIP.row.PROVINCIA = _prvdip;
            /* mcANADIP.CAB := _cabdip */
            mcANADIP.row.CAB = _cabdip;
            /* mcANADIP.MACROAGENTE := _macage */
            mcANADIP.row.MACROAGENTE = _macage;
            /* mcANADIP.SaveRow() */
            mcANADIP.SaveRow();
          } // End If
          /* If pmcParametri.w_tipoout='E' */
          if (CPLib.eqr(pmcParametri.row.w_tipoout,"E")) {
            /* Exec "Riga Excel" Page 10:Page_10 */
            Page_10();
            /* ElseIf pmcParametri.w_tipoout='T' */
          } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"T")) {
            /* Exec "Riga TXT" Page 11:Page_11 */
            Page_11();
            /* ElseIf pmcParametri.w_tipoout='C' */
          } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"C")) {
            /* Exec "Riga CSV" Page 12:Page_12 */
            Page_12();
          } else { // Else
            /* _ctot := _ctot + 1 */
            _ctot = CPLib.Round(_ctot+1,0);
            // * --- Insert into dw_operazioni from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("dw_operazioni");
            m_cPhName = m_Ctx.GetPhName("dw_operazioni");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dw_operazioni",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_xls_func",395,"000003AA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000003AA(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_ctot,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_sqr,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_namdip,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_citdip,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_numprog,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(totimp,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_ndg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_cogman,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_nomman,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(sesso,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_luonas,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datnas,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(codfisc,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipdoc,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_numdoc,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datadoc,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_autril,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(citres,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(capres,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(prvres,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(indirizzo,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(stares,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dtipoope,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dcausin,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(segno,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dataope,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nominativo,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dpaesedes,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_dstator,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datareg,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_orgdati,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(numprog,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_macage,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_cfestero,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"dw_operazioni",true);
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
          Cursor_qbe_estrai_ope_mtcn.Next();
        }
        m_cConnectivityError = Cursor_qbe_estrai_ope_mtcn.ErrorMessage();
        Cursor_qbe_estrai_ope_mtcn.Close();
        // * --- End Select
      } // End If
    } finally {
      try {
        if (Cursor_qbe_estrai_frz_mtcn!=null)
          Cursor_qbe_estrai_frz_mtcn.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_ope_mtcn!=null)
          Cursor_qbe_estrai_ope_mtcn.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_10() throws Exception {
    //Creo il record da scrivere
    row = sheet.createRow(r);
    cell = row.createCell(0);
    cell.setCellValue(CPLib.LRTrim(_codinter));
    cell = row.createCell(1);
    cell.setCellValue(CPLib.LRTrim(_sqr));
    cell = row.createCell(2);
    cell.setCellValue(CPLib.LRTrim(_coddip));
    cell = row.createCell(3);
    cell.setCellValue(CPLib.LRTrim(_namdip));
    cell = row.createCell(4);
    cell.setCellValue(CPLib.LRTrim(_inddip));
    cell = row.createCell(5);
    cell.setCellValue(CPLib.LRTrim(_citdip));
    cell = row.createCell(6);
    cell.setCellValue(CPLib.LRTrim(_prvdip));
    cell = row.createCell(7);
    cell.setCellValue(totimp);
    cell = row.createCell(8);
    cell.setCellValue(CPLib.LRTrim(_ndg));
    cell = row.createCell(9);
    cell.setCellValue(CPLib.LRTrim(_cogman));
    cell = row.createCell(10);
    cell.setCellValue(CPLib.LRTrim(_nomman));
    cell = row.createCell(11);
    cell.setCellValue(CPLib.LRTrim(sesso));
    cell = row.createCell(12);
    cell.setCellValue(CPLib.LRTrim(stanas));
    cell = row.createCell(13);
    cell.setCellValue(CPLib.LRTrim(citnas));
    cell = row.createCell(14);
    cell.setCellValue(CPLib.LRTrim(prvnas));
    cell = row.createCell(15);
    cell.setCellValue(CPLib.LRTrim(f_datnas));
    cell = row.createCell(16);
    cell.setCellValue(CPLib.LRTrim(codfisc));
    cell = row.createCell(17);
    cell.setCellValue(CPLib.LRTrim(tipdoc)+"-"+CPLib.LRTrim(_tipdoc));
    cell = row.createCell(18);
    cell.setCellValue(CPLib.LRTrim(_numdoc));
    cell = row.createCell(19);
    cell.setCellValue(CPLib.LRTrim(f_datdoc));
    cell = row.createCell(20);
    cell.setCellValue(CPLib.LRTrim(_fdtscad));
    cell = row.createCell(21);
    cell.setCellValue(CPLib.LRTrim(_autril));
    cell = row.createCell(22);
    cell.setCellValue(CPLib.LRTrim(_codstar)+"-"+CPLib.LRTrim(stares));
    cell = row.createCell(23);
    cell.setCellValue(CPLib.LRTrim(citres));
    cell = row.createCell(24);
    cell.setCellValue(CPLib.LRTrim(prvres));
    cell = row.createCell(25);
    cell.setCellValue(CPLib.LRTrim(indirizzo));
    cell = row.createCell(26);
    cell.setCellValue(CPLib.LRTrim(tipope)+"-"+CPLib.LRTrim(_dtipoope));
    cell = row.createCell(27);
    cell.setCellValue(CPLib.LRTrim(cauana)+"-"+CPLib.LRTrim(_dcauana));
    cell = row.createCell(28);
    cell.setCellValue(CPLib.LRTrim(causin)+"-"+CPLib.LRTrim(_dcausin));
    cell = row.createCell(29);
    cell.setCellValue(CPLib.LRTrim(segno));
    cell = row.createCell(30);
    cell.setCellValue(CPLib.LRTrim(f_datope));
    cell = row.createCell(31);
    cell.setCellValue(CPLib.LRTrim(nominativo));
    cell = row.createCell(32);
    cell.setCellValue(CPLib.LRTrim(_nazben)+"-"+CPLib.LRTrim(_dpaesedes));
    cell = row.createCell(33);
    cell.setCellValue(CPLib.LRTrim(_numprog));
    cell = row.createCell(34);
    cell.setCellValue(CPLib.LRTrim(_stator)+"-"+CPLib.LRTrim(_dstator));
    cell = row.createCell(35);
    cell.setCellValue(CPLib.LRTrim(_rapporto));
    cell = row.createCell(36);
    cell.setCellValue(CPLib.LRTrim(f_datreg));
    cell = row.createCell(37);
    cell.setCellValue(_orgdati);
    /* If gFlgWU='S' */
    if (CPLib.eqr(gFlgWU,"S")) {
      /* If pmcParametri.w_flgncf='N' */
      if (CPLib.eqr(pmcParametri.row.w_flgncf,"N")) {
        // Scrive MTCN e MacroAgente per WU
        cell = row.createCell(38);
        cell.setCellValue(CPLib.LRTrim(_cfestero));
        cell = row.createCell(39);
        cell.setCellValue(CPLib.LRTrim(_mtcn));
        cell = row.createCell(40);
        cell.setCellValue(CPLib.LRTrim(_macage));
        cell = row.createCell(41);
        cell.setCellValue(CPLib.LRTrim(_ajwcode));
      } else { // Else
        // Scrive MTCN e MacroAgente per WU
        cell = row.createCell(38);
        cell.setCellValue(CPLib.LRTrim(_mtcn));
        cell = row.createCell(39);
        cell.setCellValue(CPLib.LRTrim(_macage));
        cell = row.createCell(40);
        cell.setCellValue(CPLib.LRTrim(_ajwcode));
      } // End If
    } else { // Else
      /* If pmcParametri.w_flgncf='N' */
      if (CPLib.eqr(pmcParametri.row.w_flgncf,"N")) {
        // Scrive riferimento per altri
        cell = row.createCell(38);
        cell.setCellValue(CPLib.LRTrim(_cfestero));
        cell = row.createCell(39);
        cell.setCellValue(_rifimp);
        cell = row.createCell(40);
        cell.setCellValue(_rifimp2);
        cell = row.createCell(41);
        cell.setCellValue(CPLib.LRTrim(_iban));
      } else { // Else
        // Scrive riferimento per altri
        cell = row.createCell(38);
        cell.setCellValue(_rifimp);
        cell = row.createCell(39);
        cell.setCellValue(_rifimp2);
        cell = row.createCell(40);
        cell.setCellValue(CPLib.LRTrim(_iban));
      } // End If
    } // End If
    // Contatore Righe
    r++;
  }
  void Page_11() throws Exception {
    /* _file := LibreriaMit.SpacePad(_sqr,8) */
    _file = LibreriaMit.SpacePad(_sqr,8);
    /* _file := _file + LibreriaMit.SpacePad(_namdip,41) */
    _file = _file+LibreriaMit.SpacePad(_namdip,41);
    /* _file := _file + Space(36) */
    _file = _file+CPLib.Space(36);
    /* _file := _file + LibreriaMit.SpacePad(_citdip,31) */
    _file = _file+LibreriaMit.SpacePad(_citdip,31);
    /* _file := _file + LibreriaMit.SpacePad(Str(totimp,12,2),13) */
    _file = _file+LibreriaMit.SpacePad(CPLib.Str(totimp,12,2),13);
    /* _file := _file + LibreriaMit.SpacePad(_ndg,17) */
    _file = _file+LibreriaMit.SpacePad(_ndg,17);
    /* _file := _file + LibreriaMit.SpacePad(_cogman,27) */
    _file = _file+LibreriaMit.SpacePad(_cogman,27);
    /* _file := _file + LibreriaMit.SpacePad(_nomman,26) */
    _file = _file+LibreriaMit.SpacePad(_nomman,26);
    /* _file := _file + LibreriaMit.SpacePad(sesso,6) */
    _file = _file+LibreriaMit.SpacePad(sesso,6);
    /* _file := _file + LibreriaMit.SpacePad(stanas,31) */
    _file = _file+LibreriaMit.SpacePad(stanas,31);
    /* _file := _file + LibreriaMit.SpacePad(citnas,31) */
    _file = _file+LibreriaMit.SpacePad(citnas,31);
    /* _file := _file + LibreriaMit.SpacePad(prvnas,21) */
    _file = _file+LibreriaMit.SpacePad(prvnas,21);
    /* _file := _file + LibreriaMit.SpacePad(f_datnas,16) */
    _file = _file+LibreriaMit.SpacePad(f_datnas,16);
    /* _file := _file + LibreriaMit.SpacePad(codfisc,17) */
    _file = _file+LibreriaMit.SpacePad(codfisc,17);
    /* _file := _file + LibreriaMit.SpacePad(_tipdoc,31) */
    _file = _file+LibreriaMit.SpacePad(_tipdoc,31);
    /* _file := _file + LibreriaMit.SpacePad(_numdoc,16) */
    _file = _file+LibreriaMit.SpacePad(_numdoc,16);
    /* _file := _file + LibreriaMit.SpacePad(f_datdoc,14) */
    _file = _file+LibreriaMit.SpacePad(f_datdoc,14);
    /* _file := _file + LibreriaMit.SpacePad(_autril,31) */
    _file = _file+LibreriaMit.SpacePad(_autril,31);
    /* _file := _file + LibreriaMit.SpacePad(_codstar,19) */
    _file = _file+LibreriaMit.SpacePad(_codstar,19);
    /* _file := _file + LibreriaMit.SpacePad(citres,31) */
    _file = _file+LibreriaMit.SpacePad(citres,31);
    /* _file := _file + LibreriaMit.SpacePad(prvres,23) */
    _file = _file+LibreriaMit.SpacePad(prvres,23);
    /* _file := _file + LibreriaMit.SpacePad(indirizzo,36) */
    _file = _file+LibreriaMit.SpacePad(indirizzo,36);
    /* _file := _file + LibreriaMit.SpacePad(tipope,16) */
    _file = _file+LibreriaMit.SpacePad(tipope,16);
    /* _file := _file + LibreriaMit.SpacePad(cauana,18) */
    _file = _file+LibreriaMit.SpacePad(cauana,18);
    /* _file := _file + LibreriaMit.SpacePad(causin,18) */
    _file = _file+LibreriaMit.SpacePad(causin,18);
    /* _file := _file + LibreriaMit.SpacePad(segno,17) */
    _file = _file+LibreriaMit.SpacePad(segno,17);
    /* _file := _file + LibreriaMit.SpacePad(f_datope,16) */
    _file = _file+LibreriaMit.SpacePad(f_datope,16);
    /* _file := _file + LibreriaMit.SpacePad(nominativo,71) */
    _file = _file+LibreriaMit.SpacePad(nominativo,71);
    /* _file := _file + LibreriaMit.SpacePad(_nazben,18) */
    _file = _file+LibreriaMit.SpacePad(_nazben,18);
    /* _file := _file + LibreriaMit.SpacePad(_numprog,14) */
    _file = _file+LibreriaMit.SpacePad(_numprog,14);
    /* _file := _file + LibreriaMit.SpacePad(_stator,20) */
    _file = _file+LibreriaMit.SpacePad(_stator,20);
    /* _file := _file + LibreriaMit.SpacePad(_rapporto,26) */
    _file = _file+LibreriaMit.SpacePad(_rapporto,26);
    /* _file := _file + LibreriaMit.SpacePad(f_datreg,19) */
    _file = _file+LibreriaMit.SpacePad(f_datreg,19);
    /* _file := _file + _orgdati +Space(21) */
    _file = _file+_orgdati+CPLib.Space(21);
    /* If gFlgWU='S' */
    if (CPLib.eqr(gFlgWU,"S")) {
      /* If pmcParametri.w_flgncf='N' */
      if (CPLib.eqr(pmcParametri.row.w_flgncf,"N")) {
        /* _file := _file + LibreriaMit.SpacePad(_cfestero,24) */
        _file = _file+LibreriaMit.SpacePad(_cfestero,24);
        /* _file := _file + LibreriaMit.SpacePad(_mtcn,11) */
        _file = _file+LibreriaMit.SpacePad(_mtcn,11);
        /* _file := _file + _macage */
        _file = _file+_macage;
        /* _file := _file + _ajwcode */
        _file = _file+_ajwcode;
      } else { // Else
        /* _file := _file + LibreriaMit.SpacePad(_mtcn,11) */
        _file = _file+LibreriaMit.SpacePad(_mtcn,11);
        /* _file := _file + _macage */
        _file = _file+_macage;
        /* _file := _file + _ajwcode */
        _file = _file+_ajwcode;
      } // End If
    } else { // Else
      /* If pmcParametri.w_flgncf='N' */
      if (CPLib.eqr(pmcParametri.row.w_flgncf,"N")) {
        /* _file := _file + LibreriaMit.SpacePad(_cfestero,24) */
        _file = _file+LibreriaMit.SpacePad(_cfestero,24);
        /* _file := _file + _rifimp */
        _file = _file+_rifimp;
        /* _file := _file + _rifimp2 */
        _file = _file+_rifimp2;
        /* _file := _file + LibreriaMit.SpacePad(_iban,25) */
        _file = _file+LibreriaMit.SpacePad(_iban,25);
      } else { // Else
        /* _file := _file + _rifimp */
        _file = _file+_rifimp;
        /* _file := _file + _rifimp2 */
        _file = _file+_rifimp2;
        /* _file := _file + LibreriaMit.SpacePad(_iban,25) */
        _file = _file+LibreriaMit.SpacePad(_iban,25);
      } // End If
    } // End If
    /* FileLibMit.WriteLine(fhand,_file) */
    FileLibMit.WriteLine(fhand,_file);
  }
  void Page_12() throws Exception {
    // Creazione della prima riga
    campi[0]=_codinter;
    campi[1]=_sqr;
    campi[2]=_coddip;
    campi[3]=_namdip;
    campi[4]=_inddip;
    campi[5]=_citdip;
    campi[6]=_prvdip;
    campi[7]=CPLib.LRTrim(CPLib.Str(totimp,12,2));
    campi[8]=_ndg;
    campi[9]=_cogman;
    campi[10]=_nomman;
    campi[11]=sesso;
    campi[12]=stanas;
    campi[13]=citnas;
    campi[14]=prvnas;
    campi[15]=f_datnas;
    campi[16]=codfisc;
    campi[17]=tipdoc+"-"+_tipdoc;
    campi[18]=_numdoc;
    campi[19]=f_datdoc;
    campi[20]=_fdtscad;
    campi[21]=_autril;
    campi[22]=_codstar+"-"+stares;
    campi[23]=citres;
    campi[24]=prvres;
    campi[25]=indirizzo;
    campi[26]=tipope+"-"+_dtipoope;
    campi[27]=cauana+"-"+_dcauana;
    campi[28]=causin+"-"+_dcausin;
    campi[29]=segno;
    campi[30]=f_datope;
    campi[31]=nominativo;
    campi[32]=_nazben+"-"+CPLib.LRTrim(_dpaesedes);
    campi[33]=_numprog;
    campi[34]=_dstator;
    campi[35]=_rapporto;
    campi[36]=f_datreg;
    campi[37]=_orgdati;
    /* If gFlgWU='S' */
    if (CPLib.eqr(gFlgWU,"S")) {
      /* If pmcParametri.w_flgncf='N' */
      if (CPLib.eqr(pmcParametri.row.w_flgncf,"N")) {
        // CAmpi WU
        campi[38]=_cfestero;
        campi[39]=_mtcn;
        campi[40]=_macage;
        campi[41]=_ajwcode;
      } else { // Else
        // CAmpi WU
        campi[38]=_mtcn;
        campi[39]=_macage;
        campi[40]=_ajwcode;
      } // End If
    } else { // Else
      /* If pmcParametri.w_flgncf='N' */
      if (CPLib.eqr(pmcParametri.row.w_flgncf,"N")) {
        // Campi No WU
        campi[38]=_cfestero;
        campi[39]=_rifimp;
        campi[40]=_rifimp2;
        campi[41]=_iban;
      } else { // Else
        // Campi No WU
        campi[38]=_rifimp;
        campi[39]=_rifimp2;
        campi[40]=_iban;
      } // End If
    } // End If
    /* cwriter.writeNext(campi) */
    cwriter.writeNext(campi);
  }
  void Page_13() throws Exception {
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_kersonbo=null;
    try {
      /* If pmcParametri.w_flgsto='N' */
      if (CPLib.eqr(pmcParametri.row.w_flgsto,"N")) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ndg,"?",0,0,m_cServer, m_oParameters),m_cServer,_ndg)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* codfisc := iif(personbo->CFESTERO=1 and pmcParametri.w_flgncf='S','',personbo->CODFISC) */
          codfisc = (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1) && CPLib.eqr(pmcParametri.row.w_flgncf,"S")?"":Cursor_personbo.GetString("CODFISC"));
          /* If Empty(personbo->SESSO) */
          if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
            /* _cogman := LRTrim(personbo->RAGSOC) */
            _cogman = CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"));
          } else { // Else
            /* _cogman := personbo->COGNOME */
            _cogman = Cursor_personbo.GetString("COGNOME");
          } // End If
          /* _nomman := personbo->NOME */
          _nomman = Cursor_personbo.GetString("NOME");
          /* citnas := personbo->NASCOMUN */
          citnas = Cursor_personbo.GetString("NASCOMUN");
          /* prvnas := personbo->TIPINTER */
          prvnas = Cursor_personbo.GetString("TIPINTER");
          /* stanas := personbo->NASSTATO */
          stanas = Cursor_personbo.GetString("NASSTATO");
          /* sesso := iif(personbo->SESSO='1','Uomo',iif(personbo->SESSO='2','Donna','')) */
          sesso = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"1")?"Uomo":(CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"Donna":""));
          /* datnas := DateToChar(personbo->DATANASC) */
          datnas = CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC"));
          /* _datnas := personbo->DATANASC */
          _datnas = Cursor_personbo.GetDate("DATANASC");
          /* f_datnas := arfn_fdate(personbo->DATANASC) */
          f_datnas = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATANASC"));
          /* _luonas := iif(prvnas='EE' or prvnas='',stanas,citnas) */
          _luonas = (CPLib.eqr(prvnas,"EE") || CPLib.eqr(prvnas,"")?stanas:citnas);
          /* indirizzo := personbo->DOMICILIO */
          indirizzo = Cursor_personbo.GetString("DOMICILIO");
          /* citres := personbo->DESCCIT */
          citres = Cursor_personbo.GetString("DESCCIT");
          /* capres := Left(LRTrim(personbo->CAP),5) */
          capres = CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP")),5);
          /* prvres := personbo->PROVINCIA */
          prvres = Cursor_personbo.GetString("PROVINCIA");
          /* stares := '' */
          stares = "";
          /* _codstar := personbo->PAESE */
          _codstar = Cursor_personbo.GetString("PAESE");
          /* If mcTBSTATI.GoToKey(_codstar) */
          if (mcTBSTATI.GoToKey(_codstar)) {
            /* stares := mcTBSTATI.DESCRI */
            stares = mcTBSTATI.row.DESCRI;
          } // End If
          /* _tipdoc := '' */
          _tipdoc = "";
          /* tipdoc := personbo->TIPODOC */
          tipdoc = Cursor_personbo.GetString("TIPODOC");
          /* If mcTBTIPDOC.GoToKey(tipdoc) */
          if (mcTBTIPDOC.GoToKey(tipdoc)) {
            /* _tipdoc := mcTBTIPDOC.DESCRI */
            _tipdoc = mcTBTIPDOC.row.DESCRI;
          } // End If
          /* f_datdoc := arfn_fdate(personbo->DATARILASC) */
          f_datdoc = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATARILASC"));
          /* _datadoc := personbo->DATARILASC */
          _datadoc = Cursor_personbo.GetDate("DATARILASC");
          /* _autril := personbo->AUTRILASC */
          _autril = Cursor_personbo.GetString("AUTRILASC");
          /* _numdoc := personbo->NUMDOCUM */
          _numdoc = Cursor_personbo.GetString("NUMDOCUM");
          /* _cfestero := iif(personbo->CFESTERO=1,'SI','NO') */
          _cfestero = (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?"SI":"NO");
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
      } else { // Else
        /* If Empty(_connesdoc) */
        if (CPLib.Empty(_connesdoc)) {
          /* _numsto := arfn_chkspers(_ndg,iif(_stator='1',_datarett,_datasto)) */
          _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(_ndg,(CPLib.eqr(_stator,"1")?_datarett:_datasto));
          /* If Empty(LRTrim(_numsto)) */
          if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_ndg,"?",0,0,m_cServer, m_oParameters),m_cServer,_ndg)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* codfisc := iif(personbo->CFESTERO=1 and pmcParametri.w_flgncf='S','',personbo->CODFISC) */
              codfisc = (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1) && CPLib.eqr(pmcParametri.row.w_flgncf,"S")?"":Cursor_personbo.GetString("CODFISC"));
              /* If Empty(personbo->SESSO) */
              if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                /* _cogman := LRTrim(personbo->RAGSOC) */
                _cogman = CPLib.LRTrim(Cursor_personbo.GetString("RAGSOC"));
              } else { // Else
                /* _cogman := personbo->COGNOME */
                _cogman = Cursor_personbo.GetString("COGNOME");
              } // End If
              /* _nomman := personbo->NOME */
              _nomman = Cursor_personbo.GetString("NOME");
              /* citnas := personbo->NASCOMUN */
              citnas = Cursor_personbo.GetString("NASCOMUN");
              /* prvnas := personbo->TIPINTER */
              prvnas = Cursor_personbo.GetString("TIPINTER");
              /* stanas := personbo->NASSTATO */
              stanas = Cursor_personbo.GetString("NASSTATO");
              /* sesso := iif(personbo->SESSO='1','Uomo',iif(personbo->SESSO='2','Donna','')) */
              sesso = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"1")?"Uomo":(CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"Donna":""));
              /* datnas := DateToChar(personbo->DATANASC) */
              datnas = CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC"));
              /* _datnas := personbo->DATANASC */
              _datnas = Cursor_personbo.GetDate("DATANASC");
              /* f_datnas := arfn_fdate(personbo->DATANASC) */
              f_datnas = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATANASC"));
              /* _luonas := iif(prvnas='EE' or prvnas='',stanas,citnas) */
              _luonas = (CPLib.eqr(prvnas,"EE") || CPLib.eqr(prvnas,"")?stanas:citnas);
              /* indirizzo := personbo->DOMICILIO */
              indirizzo = Cursor_personbo.GetString("DOMICILIO");
              /* citres := personbo->DESCCIT */
              citres = Cursor_personbo.GetString("DESCCIT");
              /* capres := Left(LRTrim(personbo->CAP),5) */
              capres = CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP")),5);
              /* prvres := personbo->PROVINCIA */
              prvres = Cursor_personbo.GetString("PROVINCIA");
              /* stares := '' */
              stares = "";
              /* _codstar := personbo->PAESE */
              _codstar = Cursor_personbo.GetString("PAESE");
              /* If mcTBSTATI.GoToKey(_codstar) */
              if (mcTBSTATI.GoToKey(_codstar)) {
                /* stares := mcTBSTATI.DESCRI */
                stares = mcTBSTATI.row.DESCRI;
              } // End If
              /* _tipdoc := '' */
              _tipdoc = "";
              /* tipdoc := personbo->TIPODOC */
              tipdoc = Cursor_personbo.GetString("TIPODOC");
              /* If mcTBTIPDOC.GoToKey(tipdoc) */
              if (mcTBTIPDOC.GoToKey(tipdoc)) {
                /* _tipdoc := mcTBTIPDOC.DESCRI */
                _tipdoc = mcTBTIPDOC.row.DESCRI;
              } // End If
              /* f_datdoc := arfn_fdate(personbo->DATARILASC) */
              f_datdoc = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATARILASC"));
              /* _datadoc := personbo->DATARILASC */
              _datadoc = Cursor_personbo.GetDate("DATARILASC");
              /* _datascad := personbo->DATAVALI */
              _datascad = Cursor_personbo.GetDate("DATAVALI");
              /* _fdtscad := arfn_fdate(personbo->DATAVALI) */
              _fdtscad = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_personbo.GetDate("DATAVALI"));
              /* _autril := personbo->AUTRILASC */
              _autril = Cursor_personbo.GetString("AUTRILASC");
              /* _numdoc := personbo->NUMDOCUM */
              _numdoc = Cursor_personbo.GetString("NUMDOCUM");
              /* _cfestero := iif(personbo->CFESTERO=1,'SI','NO') */
              _cfestero = (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?"SI":"NO");
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from wersonbo
            m_cServer = m_Ctx.GetServer("wersonbo");
            m_cPhName = m_Ctx.GetPhName("wersonbo");
            if (Cursor_wersonbo!=null)
              Cursor_wersonbo.Close();
            Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_wersonbo.Eof())) {
              /* codfisc := iif(wersonbo->CFESTERO=1 and pmcParametri.w_flgncf='S','',wersonbo->CODFISC) */
              codfisc = (CPLib.eqr(Cursor_wersonbo.GetDouble("CFESTERO"),1) && CPLib.eqr(pmcParametri.row.w_flgncf,"S")?"":Cursor_wersonbo.GetString("CODFISC"));
              /* If Empty(wersonbo->SESSO) */
              if (CPLib.Empty(Cursor_wersonbo.GetString("SESSO"))) {
                /* _cogman := LRTrim(wersonbo->RAGSOC) */
                _cogman = CPLib.LRTrim(Cursor_wersonbo.GetString("RAGSOC"));
              } else { // Else
                /* _cogman := wersonbo->COGNOME */
                _cogman = Cursor_wersonbo.GetString("COGNOME");
              } // End If
              /* _nomman := wersonbo->NOME */
              _nomman = Cursor_wersonbo.GetString("NOME");
              /* citnas := wersonbo->NASCOMUN */
              citnas = Cursor_wersonbo.GetString("NASCOMUN");
              /* prvnas := wersonbo->TIPINTER */
              prvnas = Cursor_wersonbo.GetString("TIPINTER");
              /* stanas := wersonbo->NASSTATO */
              stanas = Cursor_wersonbo.GetString("NASSTATO");
              /* sesso := iif(wersonbo->SESSO='1','Uomo',iif(wersonbo->SESSO='2','Donna','')) */
              sesso = (CPLib.eqr(Cursor_wersonbo.GetString("SESSO"),"1")?"Uomo":(CPLib.eqr(Cursor_wersonbo.GetString("SESSO"),"2")?"Donna":""));
              /* datnas := DateToChar(wersonbo->DATANASC) */
              datnas = CPLib.DateToChar(Cursor_wersonbo.GetDate("DATANASC"));
              /* _datnas := wersonbo->DATANASC */
              _datnas = Cursor_wersonbo.GetDate("DATANASC");
              /* f_datnas := arfn_fdate(wersonbo->DATANASC) */
              f_datnas = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetDate("DATANASC"));
              /* _luonas := iif(prvnas='EE' or prvnas='',stanas,citnas) */
              _luonas = (CPLib.eqr(prvnas,"EE") || CPLib.eqr(prvnas,"")?stanas:citnas);
              /* indirizzo := wersonbo->DOMICILIO */
              indirizzo = Cursor_wersonbo.GetString("DOMICILIO");
              /* citres := wersonbo->DESCCIT */
              citres = Cursor_wersonbo.GetString("DESCCIT");
              /* capres := Left(LRTrim(wersonbo->CAP),5) */
              capres = CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP")),5);
              /* prvres := wersonbo->PROVINCIA */
              prvres = Cursor_wersonbo.GetString("PROVINCIA");
              /* stares := '' */
              stares = "";
              /* _codstar := wersonbo->PAESE */
              _codstar = Cursor_wersonbo.GetString("PAESE");
              /* If mcTBSTATI.GoToKey(_codstar) */
              if (mcTBSTATI.GoToKey(_codstar)) {
                /* stares := mcTBSTATI.DESCRI */
                stares = mcTBSTATI.row.DESCRI;
              } // End If
              /* _tipdoc := '' */
              _tipdoc = "";
              /* tipdoc := wersonbo->TIPODOC */
              tipdoc = Cursor_wersonbo.GetString("TIPODOC");
              /* If mcTBTIPDOC.GoToKey(tipdoc) */
              if (mcTBTIPDOC.GoToKey(tipdoc)) {
                /* _tipdoc := mcTBTIPDOC.DESCRI */
                _tipdoc = mcTBTIPDOC.row.DESCRI;
              } // End If
              /* f_datdoc := arfn_fdate(wersonbo->DATARILASC) */
              f_datdoc = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetDate("DATARILASC"));
              /* _datadoc := wersonbo->DATARILASC */
              _datadoc = Cursor_wersonbo.GetDate("DATARILASC");
              /* _datascad := wersonbo->DATAVALI */
              _datascad = Cursor_wersonbo.GetDate("DATAVALI");
              /* _fdtscad := arfn_fdate(wersonbo->DATAVALI) */
              _fdtscad = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetDate("DATAVALI"));
              /* _autril := wersonbo->AUTRILASC */
              _autril = Cursor_wersonbo.GetString("AUTRILASC");
              /* _numdoc := wersonbo->NUMDOCUM */
              _numdoc = Cursor_wersonbo.GetString("NUMDOCUM");
              /* _cfestero := iif(wersonbo->CFESTERO=1,'SI','NO') */
              _cfestero = (CPLib.eqr(Cursor_wersonbo.GetDouble("CFESTERO"),1)?"SI":"NO");
              Cursor_wersonbo.Next();
            }
            m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
            Cursor_wersonbo.Close();
            // * --- End Select
          } // End If
        } else { // Else
          // * --- Select from kersonbo
          m_cServer = m_Ctx.GetServer("kersonbo");
          m_cPhName = m_Ctx.GetPhName("kersonbo");
          if (Cursor_kersonbo!=null)
            Cursor_kersonbo.Close();
          Cursor_kersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connesdoc,"?",0,0,m_cServer, m_oParameters),m_cServer,_connesdoc)+" "+")"+(m_Ctx.IsSharedTemp("kersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_kersonbo.Eof())) {
            /* codfisc := iif(kersonbo->CFESTERO=1 and pmcParametri.w_flgncf='S','',kersonbo->CODFISC) */
            codfisc = (CPLib.eqr(Cursor_kersonbo.GetDouble("CFESTERO"),1) && CPLib.eqr(pmcParametri.row.w_flgncf,"S")?"":Cursor_kersonbo.GetString("CODFISC"));
            /* If Empty(kersonbo->SESSO) */
            if (CPLib.Empty(Cursor_kersonbo.GetString("SESSO"))) {
              /* _cogman := LRTrim(kersonbo->RAGSOC) */
              _cogman = CPLib.LRTrim(Cursor_kersonbo.GetString("RAGSOC"));
            } else { // Else
              /* _cogman := kersonbo->COGNOME */
              _cogman = Cursor_kersonbo.GetString("COGNOME");
            } // End If
            /* _nomman := kersonbo->NOME */
            _nomman = Cursor_kersonbo.GetString("NOME");
            /* citnas := kersonbo->NASCOMUN */
            citnas = Cursor_kersonbo.GetString("NASCOMUN");
            /* prvnas := kersonbo->TIPINTER */
            prvnas = Cursor_kersonbo.GetString("TIPINTER");
            /* stanas := kersonbo->NASSTATO */
            stanas = Cursor_kersonbo.GetString("NASSTATO");
            /* sesso := iif(kersonbo->SESSO='1','Uomo',iif(kersonbo->SESSO='2','Donna','')) */
            sesso = (CPLib.eqr(Cursor_kersonbo.GetString("SESSO"),"1")?"Uomo":(CPLib.eqr(Cursor_kersonbo.GetString("SESSO"),"2")?"Donna":""));
            /* datnas := DateToChar(kersonbo->DATANASC) */
            datnas = CPLib.DateToChar(Cursor_kersonbo.GetDate("DATANASC"));
            /* _datnas := kersonbo->DATANASC */
            _datnas = Cursor_kersonbo.GetDate("DATANASC");
            /* f_datnas := arfn_fdate(kersonbo->DATANASC) */
            f_datnas = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_kersonbo.GetDate("DATANASC"));
            /* _luonas := iif(prvnas='EE' or prvnas='',stanas,citnas) */
            _luonas = (CPLib.eqr(prvnas,"EE") || CPLib.eqr(prvnas,"")?stanas:citnas);
            /* indirizzo := kersonbo->DOMICILIO */
            indirizzo = Cursor_kersonbo.GetString("DOMICILIO");
            /* citres := kersonbo->DESCCIT */
            citres = Cursor_kersonbo.GetString("DESCCIT");
            /* capres := Left(LRTrim(kersonbo->CAP),5) */
            capres = CPLib.Left(CPLib.LRTrim(Cursor_kersonbo.GetString("CAP")),5);
            /* prvres := kersonbo->PROVINCIA */
            prvres = Cursor_kersonbo.GetString("PROVINCIA");
            /* stares := '' */
            stares = "";
            /* _codstar := kersonbo->PAESE */
            _codstar = Cursor_kersonbo.GetString("PAESE");
            /* If mcTBSTATI.GoToKey(_codstar) */
            if (mcTBSTATI.GoToKey(_codstar)) {
              /* stares := mcTBSTATI.DESCRI */
              stares = mcTBSTATI.row.DESCRI;
            } // End If
            /* _tipdoc := '' */
            _tipdoc = "";
            /* tipdoc := kersonbo->TIPODOC */
            tipdoc = Cursor_kersonbo.GetString("TIPODOC");
            /* If mcTBTIPDOC.GoToKey(tipdoc) */
            if (mcTBTIPDOC.GoToKey(tipdoc)) {
              /* _tipdoc := mcTBTIPDOC.DESCRI */
              _tipdoc = mcTBTIPDOC.row.DESCRI;
            } // End If
            /* f_datdoc := arfn_fdate(kersonbo->DATARILASC) */
            f_datdoc = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_kersonbo.GetDate("DATARILASC"));
            /* _datadoc := kersonbo->DATARILASC */
            _datadoc = Cursor_kersonbo.GetDate("DATARILASC");
            /* _autril := kersonbo->AUTRILASC */
            _autril = Cursor_kersonbo.GetString("AUTRILASC");
            /* _numdoc := kersonbo->NUMDOCUM */
            _numdoc = Cursor_kersonbo.GetString("NUMDOCUM");
            /* _cfestero := iif(kersonbo->CFESTERO=1,'SI','NO') */
            _cfestero = (CPLib.eqr(Cursor_kersonbo.GetDouble("CFESTERO"),1)?"SI":"NO");
            Cursor_kersonbo.Next();
          }
          m_cConnectivityError = Cursor_kersonbo.ErrorMessage();
          Cursor_kersonbo.Close();
          // * --- End Select
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
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_kersonbo!=null)
          Cursor_kersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_14() throws Exception {
    // Create a buffer for reading the files
        byte[] buf = new byte[1024];
        
        try {
            // Create the ZIP file
            String outFilename = cNomeFileZip;
            java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(outFilename));
        
            // Compress the files
            for (int i=0; i<filenames.size(); i++) {
                _file1=(String)filenames.elementAt(i);
                _file2=(String)fileonames.elementAt(i);
                java.io.FileInputStream in = new java.io.FileInputStream(_file1);
        
                // Add ZIP entry to output stream.
                out.putNextEntry(new java.util.zip.ZipEntry(_file2));
        
                // Transfer bytes from the file to the ZIP file
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
        
                // Complete the entry
                out.closeEntry();
                in.close();
                FileLibMit.DeleteFilePath(CPLib.LRTrim(_file1));
            }
        
            // Complete the ZIP file
            out.close();
            filenames.removeAllElements();
            fileonames.removeAllElements();
        } catch (java.io.IOException e) {
        }
    
  }
  void Page_15() throws Exception {
    /* Crea il file delle dipendenze */
    /* _agetesta := Strtran(LRTrim(_testa),'movimenti','agenzie') */
    _agetesta = CPLib.Strtran(CPLib.LRTrim(_testa),"movimenti","agenzie");
    /* If pmcParametri.w_tipoout='E' */
    if (CPLib.eqr(pmcParametri.row.w_tipoout,"E")) {
      /* Formato Excel */
      /* _nfile := iif(Empty(LRTrim(pmcParametri.w_destfold)),LRTrim(_gPathApp)+"/export/"+LRTrim(_gAzienda)+"/"+LRTrim(_agetesta)+".xlsx",LRTrim(pmcParametri.w_destfold)+"/"+LRTrim(_agetesta)+".xlsx") */
      _nfile = (CPLib.Empty(CPLib.LRTrim(pmcParametri.row.w_destfold))?CPLib.LRTrim(_gPathApp)+"/export/"+CPLib.LRTrim(_gAzienda)+"/"+CPLib.LRTrim(_agetesta)+".xlsx":CPLib.LRTrim(pmcParametri.row.w_destfold)+"/"+CPLib.LRTrim(_agetesta)+".xlsx");
      // These are the files to include in the ZIP file
      filenames.add(CPLib.LRTrim(_nfile));
      fileonames.add(CPLib.LRTrim(_agetesta)+".xlsx");
      /* Seleziona i record */
      /* riga := 0 */
      riga = CPLib.Round(0,0);
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
      cell = row.createCell(0);
      cell.setCellValue("Codice AGENZIA");
      cell.setCellStyle(cs);
      cell = row.createCell(1);
      cell.setCellValue("AGENZIA");
      cell.setCellStyle(cs);
      cell =  row.createCell(2);
      cell.setCellValue("INDIRIZZO");
      cell.setCellStyle(cs);
      cell =  row.createCell(3);
      cell.setCellValue("CITTA'");
      cell.setCellStyle(cs);
      cell =  row.createCell(4);
      cell.setCellValue("PROVINCIA");
      cell.setCellStyle(cs);
      cell =  row.createCell(5);
      cell.setCellValue("CAB");
      cell.setCellStyle(cs);
      /* If gFlgWU='S' */
      if (CPLib.eqr(gFlgWU,"S")) {
        // Scrive MTCN e MacroAgente per WU
        cell = row.createCell(6);
        cell.setCellValue("MACROAGENTE");
        cell.setCellStyle(cs);
      } // End If
      // Aggiorna il contatore delle righe
      r++;
      /* ElseIf pmcParametri.w_tipoout='C' */
    } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"C")) {
      /* _nfile := iif(Empty(LRTrim(pmcParametri.w_destfold)),LRTrim(_gPathApp)+"/export/"+LRTrim(_gAzienda)+"/"+LRTrim(_agetesta)+".csv",LRTrim(pmcParametri.w_destfold)+"/"+LRTrim(_agetesta)+".csv") */
      _nfile = (CPLib.Empty(CPLib.LRTrim(pmcParametri.row.w_destfold))?CPLib.LRTrim(_gPathApp)+"/export/"+CPLib.LRTrim(_gAzienda)+"/"+CPLib.LRTrim(_agetesta)+".csv":CPLib.LRTrim(pmcParametri.row.w_destfold)+"/"+CPLib.LRTrim(_agetesta)+".csv");
      // These are the files to include in the ZIP file
      filenames.add(CPLib.LRTrim(_nfile));
      fileonames.add(CPLib.LRTrim(_agetesta)+".csv");
      // Creazione del writer
      cwriter=new CSVWriter(new FileWriter(_nfile));
      // Creazione della prima riga
      ncampi=(CPLib.eqr(gFlgWU,"S")?9:8);
      campi = new String[ncampi];
      campi[0]="CODICE AGENZIA";
      campi[1]="AGENZIA";
      campi[2]="INDIRIZZO";
      campi[3]="CITTA";
      campi[4]="PROVINCIA";
      campi[5]="CAB";
      /* If gFlgWU='S' */
      if (CPLib.eqr(gFlgWU,"S")) {
        // CAmpi WU
        campi[6]="MACROAGENTE";
      } // End If
      /* cwriter.writeNext(campi) */
      cwriter.writeNext(campi);
      /* ElseIf pmcParametri.w_tipoout='T' */
    } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"T")) {
      /* _nfile := iif(Empty(LRTrim(pmcParametri.w_destfold)),LRTrim(_gPathApp)+"/export/"+LRTrim(_gAzienda)+"/"+LRTrim(_agetesta)+".txt",LRTrim(pmcParametri.w_destfold)+"/"+LRTrim(_agetesta)+".txt") */
      _nfile = (CPLib.Empty(CPLib.LRTrim(pmcParametri.row.w_destfold))?CPLib.LRTrim(_gPathApp)+"/export/"+CPLib.LRTrim(_gAzienda)+"/"+CPLib.LRTrim(_agetesta)+".txt":CPLib.LRTrim(pmcParametri.row.w_destfold)+"/"+CPLib.LRTrim(_agetesta)+".txt");
      // These are the files to include in the ZIP file
      filenames.add(CPLib.LRTrim(_nfile));
      fileonames.add(CPLib.LRTrim(_agetesta)+".txt");
      /* fhand := FileLibMit.OpenWritePath(_nfile) */
      fhand = FileLibMit.OpenWritePath(_nfile);
      /* _file := "CODICE AGENZIA " */
      _file = "CODICE AGENZIA ";
      /* _file := _file + LibreriaMit.SpacePad("AGENZIA",41) */
      _file = _file+LibreriaMit.SpacePad("AGENZIA",41);
      /* _file := _file + LibreriaMit.SpacePad("INDIRIZZO",36) */
      _file = _file+LibreriaMit.SpacePad("INDIRIZZO",36);
      /* _file := _file + LibreriaMit.SpacePad("CITTA'",31) */
      _file = _file+LibreriaMit.SpacePad("CITTA'",31);
      /* _file := _file + "PROVINCIA " */
      _file = _file+"PROVINCIA ";
      /* _file := _file + LibreriaMit.SpacePad("CAB",7) */
      _file = _file+LibreriaMit.SpacePad("CAB",7);
      /* If gFlgWU='S' */
      if (CPLib.eqr(gFlgWU,"S")) {
        /* _file := _file + "MACROAGENTE" */
        _file = _file+"MACROAGENTE";
      } // End If
      /* FileLibMit.WriteLine(fhand,_file) */
      FileLibMit.WriteLine(fhand,_file);
    } // End If
    for (MemoryCursorRow_anadip rowANADIP : mcANADIP._iterable_()) {
      /* _coddip := rowANADIP.CODDIP */
      _coddip = rowANADIP.CODDIP;
      /* _namdip := rowANADIP.DESCRIZ */
      _namdip = rowANADIP.DESCRIZ;
      /* _inddip := rowANADIP.DOMICILIO */
      _inddip = rowANADIP.DOMICILIO;
      /* _citdip := rowANADIP.DESCCIT */
      _citdip = rowANADIP.DESCCIT;
      /* _prvdip := rowANADIP.PROVINCIA */
      _prvdip = rowANADIP.PROVINCIA;
      /* _cabdip := rowANADIP.CAB */
      _cabdip = rowANADIP.CAB;
      /* _macage := rowANADIP.MACROAGENTE */
      _macage = rowANADIP.MACROAGENTE;
      /* If pmcParametri.w_tipoout='E' */
      if (CPLib.eqr(pmcParametri.row.w_tipoout,"E")) {
        //Creo il record da scrivere
        row = sheet.createRow(r);
        cell = row.createCell(0);
        cell.setCellValue(CPLib.LRTrim(_coddip));
        cell = row.createCell(1);
        cell.setCellValue(CPLib.LRTrim(_namdip));
        cell = row.createCell(2);
        cell.setCellValue(CPLib.LRTrim(_inddip));
        cell = row.createCell(3);
        cell.setCellValue(CPLib.LRTrim(_citdip));
        cell = row.createCell(4);
        cell.setCellValue(CPLib.LRTrim(_prvdip));
        cell = row.createCell(5);
        cell.setCellValue(CPLib.LRTrim(_cabdip));
        /* If gFlgWU='S' */
        if (CPLib.eqr(gFlgWU,"S")) {
          // Scrive MTCN e MacroAgente per WU
          cell = row.createCell(6);
          cell.setCellValue(CPLib.LRTrim(_macage));
        } // End If
        // Contatore Righe
        r++;
        /* ElseIf pmcParametri.w_tipoout='C' */
      } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"C")) {
        // Creazione della prima riga
        campi[0]=_coddip;
        campi[1]=_namdip;
        campi[2]=_inddip;
        campi[3]=_citdip;
        campi[4]=_prvdip;
        campi[5]=_cabdip;
        /* If gFlgWU='S' */
        if (CPLib.eqr(gFlgWU,"S")) {
          // CAmpi WU
          campi[6]=_macage;
        } // End If
        /* cwriter.writeNext(campi) */
        cwriter.writeNext(campi);
        /* ElseIf pmcParametri.w_tipoout='T' */
      } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"T")) {
        /* _file := LibreriaMit.SpacePad(_coddip,15) */
        _file = LibreriaMit.SpacePad(_coddip,15);
        /* _file := _file + LibreriaMit.SpacePad(_namdip,41) */
        _file = _file+LibreriaMit.SpacePad(_namdip,41);
        /* _file := _file + LibreriaMit.SpacePad(_inddip,36) */
        _file = _file+LibreriaMit.SpacePad(_inddip,36);
        /* _file := _file + LibreriaMit.SpacePad(_citdip,31) */
        _file = _file+LibreriaMit.SpacePad(_citdip,31);
        /* _file := _file + LibreriaMit.SpacePad(_prvdip,10) */
        _file = _file+LibreriaMit.SpacePad(_prvdip,10);
        /* _file := _file + LibreriaMit.SpacePad(_cabdip,7) */
        _file = _file+LibreriaMit.SpacePad(_cabdip,7);
        /* If gFlgWU='S' */
        if (CPLib.eqr(gFlgWU,"S")) {
          /* _file := _file + _macage */
          _file = _file+_macage;
        } // End If
        /* FileLibMit.WriteLine(fhand,_file) */
        FileLibMit.WriteLine(fhand,_file);
      } // End If
    }
    /* If pmcParametri.w_tipoout='E' */
    if (CPLib.eqr(pmcParametri.row.w_tipoout,"E")) {
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
      /* If gFlgWU='S' */
      if (CPLib.eqr(gFlgWU,"S")) {
        // Formatta colonne aggiuntive WU
        sheet.autoSizeColumn(6);
      } // End If
      // scrivo il file di esito
      FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(_nfile));
      
      //write this workbook to an Outputstream.
      wb.write(fileOut);
      fileOut.flush();
      fileOut.close();
      /* ElseIf pmcParametri.w_tipoout='C' */
    } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"C")) {
      /* cwriter.close() */
      cwriter.close();
      /* ElseIf pmcParametri.w_tipoout='T' */
    } else if (CPLib.eqr(pmcParametri.row.w_tipoout,"T")) {
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
    } // End If
  }
  void _init_() {
  }
  public String RunAsync(MemoryCursor_mcparametri_mcrdef p_pmcParametri,String p_pAzienda,String p_pPath) {
    pmcParametri = p_pmcParametri;
    pAzienda = p_pAzienda;
    pPath = p_pPath;
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
  public Forward Run(MemoryCursor_mcparametri_mcrdef p_pmcParametri,String p_pAzienda,String p_pPath) {
    pmcParametri = p_pmcParametri;
    pAzienda = p_pAzienda;
    pPath = p_pPath;
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_estrai_xls_funcR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_estrai_xls_funcR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pmcParametri = new MemoryCursor_mcparametri_mcrdef();
    pAzienda = CPLib.Space(10);
    pPath = CPLib.Space(80);
    _gPathApp = CPLib.Space(80);
    _gAzienda = CPLib.Space(10);
    fhand = CPLib.Space(10);
    filenome = CPLib.Space(100);
    righe = 0;
    cell01 = CPLib.Space(100);
    column01 = CPLib.Space(25);
    cell_count = 0;
    riga_letta = 0;
    _file = "";
    _dadata = CPLib.NullDate();
    _a_data = CPLib.NullDate();
    prova = CPLib.Space(1);
    foglio = CPLib.Space(1);
    _nfile = CPLib.Space(50);
    stringa = CPLib.Space(1);
    numero = CPLib.Space(1);
    dData = CPLib.Space(1);
    dataoggi = CPLib.Space(14);
    numprog = CPLib.Space(11);
    datareg = CPLib.Space(8);
    _datareg = CPLib.NullDate();
    dataope = CPLib.Space(8);
    _dataope = CPLib.NullDate();
    f_datope = CPLib.Space(10);
    f_datnas = CPLib.Space(10);
    f_datreg = CPLib.Space(10);
    tipope = CPLib.Space(2);
    cauana = CPLib.Space(4);
    causin = CPLib.Space(4);
    segno = CPLib.Space(1);
    valuta = CPLib.Space(6);
    divisa = CPLib.Space(30);
    cambio = 0;
    totimp = 0;
    totcon = 0;
    codfisc = CPLib.Space(16);
    nominativo = CPLib.Space(70);
    indirizzo = CPLib.Space(35);
    citres = CPLib.Space(40);
    capres = CPLib.Space(5);
    prvres = CPLib.Space(2);
    stares = CPLib.Space(40);
    citnas = CPLib.Space(40);
    prvnas = CPLib.Space(2);
    stanas = CPLib.Space(40);
    sesso = CPLib.Space(40);
    datnas = CPLib.Space(8);
    _datnas = CPLib.NullDate();
    tipdoc = CPLib.Space(2);
    autril = CPLib.Space(30);
    numdoc = CPLib.Space(15);
    datril = CPLib.Space(8);
    _datril = CPLib.NullDate();
    _testa = CPLib.Space(50);
    _agetesta = CPLib.Space(50);
    _sqr = CPLib.Space(10);
    _coddip = CPLib.Space(6);
    _namdip = CPLib.Space(40);
    _citdip = CPLib.Space(40);
    _nomman = CPLib.Space(30);
    _cogman = CPLib.Space(30);
    _nazben = CPLib.Space(30);
    _luonas = CPLib.Space(40);
    _tipdoc = CPLib.Space(20);
    _numdoc = CPLib.Space(20);
    f_datdoc = CPLib.Space(10);
    _autril = CPLib.Space(30);
    _numprog = CPLib.Space(11);
    _mtcn = CPLib.Space(10);
    _macage = CPLib.Space(5);
    _stator = CPLib.Space(1);
    _rapporto = CPLib.Space(25);
    riga = 0;
    _ndg = CPLib.Space(16);
    _cfestero = CPLib.Space(2);
    _numsto = CPLib.Space(15);
    _ctot = 0;
    cNomeFile = CPLib.Space(30);
    cNomeFileZip = CPLib.Space(30);
    _datadoc = CPLib.NullDate();
    _max = 0;
    _min = 0;
    _tot = 0;
    _mono = 0;
    _cicli = 0;
    _contacicli = 0;
    _bottom = 0;
    _top = 0;
    _mstato = CPLib.Space(15);
    _rifimp = CPLib.Space(28);
    _rifimp2 = CPLib.Space(30);
    _connesdoc = CPLib.Space(50);
    _datarett = CPLib.NullDate();
    _dcauana = CPLib.Space(165);
    _dcausin = CPLib.Space(165);
    _dpaeseres = CPLib.Space(30);
    _dpaesedes = CPLib.Space(30);
    _dtipoope = CPLib.Space(90);
    _dstator = CPLib.Space(30);
    prcProg = CPLib.Space(10);
    cOutput = CPLib.Space(30);
    _codstar = CPLib.Space(3);
    _totgen = 0;
    fmhand = CPLib.Space(10);
    _file1 = CPLib.Space(128);
    _file2 = CPLib.Space(80);
    _totalone = 0;
    _orgdati = CPLib.Space(1);
    _codinter = CPLib.Space(11);
    mcANADIP = new MemoryCursor_anadip();
    rowANADIP = new MemoryCursorRow_anadip();
    _prvdip = CPLib.Space(2);
    _cabdip = CPLib.Space(6);
    _inddip = CPLib.Space(40);
    _cfromdate = CPLib.Space(8);
    _c_todate = CPLib.Space(8);
    _nomefile = CPLib.Space(60);
    _ragsoc = CPLib.Space(70);
    _importo = 0;
    _ajwcode = CPLib.Space(10);
    _datasto = CPLib.NullDate();
    _datascad = CPLib.NullDate();
    _fdtscad = CPLib.Space(10);
    _iban = CPLib.Space(25);
    mcTBSTATI = new MemoryCursor_tbstati();
    mcTBCAUANA = new MemoryCursor_tbcauana();
    mcTBCAUSIN = new MemoryCursor_tbcausin();
    mcTBTIPDOC = new MemoryCursor_tbtipdoc();
    mcTBTIPREG = new MemoryCursor_tbtipreg();
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gFileName=m_Ctx.GetGlobalString("gFileName");
    gFlgWU=m_Ctx.GetGlobalString("gFlgWU");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_estrai_frz_lim,qbe_estrai_ope_lim,qbe_tab_mmc,qbe_estrai_frz_lim,qbe_estrai_frz,qbe_estrai_ope_lim,qbe_estrai_ope,qbe_sele_sogg,qbe_sele_sogg2,qbe_estrai_frz_sog,qbe_estrai_ope_sog,qbe_estrai_frz_mtcn,qbe_estrai_ope_mtcn,
  public static final String m_cVQRList = ",qbe_estrai_frz_lim,qbe_estrai_ope_lim,qbe_tab_mmc,qbe_estrai_frz_lim,qbe_estrai_frz,qbe_estrai_ope_lim,qbe_estrai_ope,qbe_sele_sogg,qbe_sele_sogg2,qbe_estrai_frz_sog,qbe_estrai_ope_sog,qbe_estrai_frz_mtcn,qbe_estrai_ope_mtcn,";
  // ENTITY_BATCHES: ,arfn_chkspers,arfn_datesum,arfn_fdate,arfn_finemese,
  public static final String i_InvokedRoutines = ",arfn_chkspers,arfn_datesum,arfn_fdate,arfn_finemese,";
  public static String[] m_cRunParameterNames={"pmcParametri","pAzienda","pPath"};
  protected static String GetFieldsName_000000A5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PR_TIPO,";
    p_cSql = p_cSql+"PRCODICE,";
    p_cSql = p_cSql+"PRDESCRI,";
    p_cSql = p_cSql+"PRDOSTART,";
    p_cSql = p_cSql+"PRESITO,";
    p_cSql = p_cSql+"PTRIPOOUT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"processi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001C7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PROGOPE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"AGENZIA,";
    p_cSql = p_cSql+"SEDE_AGENZIA,";
    p_cSql = p_cSql+"NUMOPE,";
    p_cSql = p_cSql+"IMPORTO,";
    p_cSql = p_cSql+"NDG,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"LUOGONAS,";
    p_cSql = p_cSql+"DATANAS,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOC,";
    p_cSql = p_cSql+"DATARIL,";
    p_cSql = p_cSql+"AUTRIL,";
    p_cSql = p_cSql+"CITTARES,";
    p_cSql = p_cSql+"CAPRES,";
    p_cSql = p_cSql+"PRVRES,";
    p_cSql = p_cSql+"INDIRIZZO,";
    p_cSql = p_cSql+"STATORES,";
    p_cSql = p_cSql+"TIPOOPEUIC,";
    p_cSql = p_cSql+"CAUANA,";
    p_cSql = p_cSql+"CAUSIN,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"RAGSOCCONT,";
    p_cSql = p_cSql+"PAESECONT,";
    p_cSql = p_cSql+"STATOOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPEFRZ,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"dw_operazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000237(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PROGOPE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"AGENZIA,";
    p_cSql = p_cSql+"SEDE_AGENZIA,";
    p_cSql = p_cSql+"NUMOPE,";
    p_cSql = p_cSql+"IMPORTO,";
    p_cSql = p_cSql+"NDG,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"LUOGONAS,";
    p_cSql = p_cSql+"DATANAS,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOC,";
    p_cSql = p_cSql+"DATARIL,";
    p_cSql = p_cSql+"AUTRIL,";
    p_cSql = p_cSql+"CITTARES,";
    p_cSql = p_cSql+"CAPRES,";
    p_cSql = p_cSql+"PRVRES,";
    p_cSql = p_cSql+"INDIRIZZO,";
    p_cSql = p_cSql+"STATORES,";
    p_cSql = p_cSql+"TIPOOPEUIC,";
    p_cSql = p_cSql+"CAUANA,";
    p_cSql = p_cSql+"CAUSIN,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"RAGSOCCONT,";
    p_cSql = p_cSql+"PAESECONT,";
    p_cSql = p_cSql+"STATOOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPEFRZ,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"dw_operazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000023E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_newpers",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000023F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_newpers",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000243(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_mtcn_cf",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000248(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_newpers",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000025C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_mtcn_cf",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002B1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PROGOPE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"AGENZIA,";
    p_cSql = p_cSql+"SEDE_AGENZIA,";
    p_cSql = p_cSql+"NUMOPE,";
    p_cSql = p_cSql+"IMPORTO,";
    p_cSql = p_cSql+"NDG,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"LUOGONAS,";
    p_cSql = p_cSql+"DATANAS,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOC,";
    p_cSql = p_cSql+"DATARIL,";
    p_cSql = p_cSql+"AUTRIL,";
    p_cSql = p_cSql+"CITTARES,";
    p_cSql = p_cSql+"CAPRES,";
    p_cSql = p_cSql+"PRVRES,";
    p_cSql = p_cSql+"INDIRIZZO,";
    p_cSql = p_cSql+"STATORES,";
    p_cSql = p_cSql+"TIPOOPEUIC,";
    p_cSql = p_cSql+"CAUANA,";
    p_cSql = p_cSql+"CAUSIN,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"RAGSOCCONT,";
    p_cSql = p_cSql+"PAESECONT,";
    p_cSql = p_cSql+"STATOOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPEFRZ,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"dw_operazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000304(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PROGOPE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"AGENZIA,";
    p_cSql = p_cSql+"SEDE_AGENZIA,";
    p_cSql = p_cSql+"NUMOPE,";
    p_cSql = p_cSql+"IMPORTO,";
    p_cSql = p_cSql+"NDG,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"LUOGONAS,";
    p_cSql = p_cSql+"DATANAS,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOC,";
    p_cSql = p_cSql+"DATARIL,";
    p_cSql = p_cSql+"AUTRIL,";
    p_cSql = p_cSql+"CITTARES,";
    p_cSql = p_cSql+"CAPRES,";
    p_cSql = p_cSql+"PRVRES,";
    p_cSql = p_cSql+"INDIRIZZO,";
    p_cSql = p_cSql+"STATORES,";
    p_cSql = p_cSql+"TIPOOPEUIC,";
    p_cSql = p_cSql+"CAUANA,";
    p_cSql = p_cSql+"CAUSIN,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"RAGSOCCONT,";
    p_cSql = p_cSql+"PAESECONT,";
    p_cSql = p_cSql+"STATOOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPEFRZ,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"dw_operazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000357(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PROGOPE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"AGENZIA,";
    p_cSql = p_cSql+"SEDE_AGENZIA,";
    p_cSql = p_cSql+"NUMOPE,";
    p_cSql = p_cSql+"IMPORTO,";
    p_cSql = p_cSql+"NDG,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"LUOGONAS,";
    p_cSql = p_cSql+"DATANAS,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOC,";
    p_cSql = p_cSql+"DATARIL,";
    p_cSql = p_cSql+"AUTRIL,";
    p_cSql = p_cSql+"CITTARES,";
    p_cSql = p_cSql+"CAPRES,";
    p_cSql = p_cSql+"PRVRES,";
    p_cSql = p_cSql+"INDIRIZZO,";
    p_cSql = p_cSql+"STATORES,";
    p_cSql = p_cSql+"TIPOOPEUIC,";
    p_cSql = p_cSql+"CAUANA,";
    p_cSql = p_cSql+"CAUSIN,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"RAGSOCCONT,";
    p_cSql = p_cSql+"PAESECONT,";
    p_cSql = p_cSql+"STATOOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPEFRZ,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"dw_operazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000003AA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PROGOPE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"AGENZIA,";
    p_cSql = p_cSql+"SEDE_AGENZIA,";
    p_cSql = p_cSql+"NUMOPE,";
    p_cSql = p_cSql+"IMPORTO,";
    p_cSql = p_cSql+"NDG,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"LUOGONAS,";
    p_cSql = p_cSql+"DATANAS,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOC,";
    p_cSql = p_cSql+"DATARIL,";
    p_cSql = p_cSql+"AUTRIL,";
    p_cSql = p_cSql+"CITTARES,";
    p_cSql = p_cSql+"CAPRES,";
    p_cSql = p_cSql+"PRVRES,";
    p_cSql = p_cSql+"INDIRIZZO,";
    p_cSql = p_cSql+"STATORES,";
    p_cSql = p_cSql+"TIPOOPEUIC,";
    p_cSql = p_cSql+"CAUANA,";
    p_cSql = p_cSql+"CAUSIN,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"RAGSOCCONT,";
    p_cSql = p_cSql+"PAESECONT,";
    p_cSql = p_cSql+"STATOOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPEFRZ,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"dw_operazioni",true);
    return p_cSql;
  }
}
