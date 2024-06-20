// * --- Area Manuale = BO - Header
// * --- arrt_wu_stampa_trx
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
public class arrt_wu_stampa_trxR implements CallerWithObjs {
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
  public String m_cPhName_wutrxchk;
  public String m_cServer_wutrxchk;
  public String m_cPhName_cpusers;
  public String m_cServer_cpusers;
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
  public java.sql.Date pDatIni;
  public java.sql.Date pDatFin;
  public String gPathApp;
  public String gAzienda;
  public String gMsgImp;
  public String gUrlApp;
  public String _filexls;
  public String _filexlspath;
  public String _trxcodprg;
  public String _mtcn;
  public String _nominativo;
  public String _codute;
  public String _desute;
  public String _inilav;
  public String _finlav;
  public String _esito;
  public String _caso1;
  public String _caso2;
  public String _caso3;
  public String _caso4;
  public String _caso5;
  public String _caso6;
  public double _ccasi;
  public String _datope;
  public String _agenzia;
  public double _durata;
  public java.sql.Timestamp _tinilav;
  public java.sql.Timestamp _tfinlav;
  public String cRitorno;
  public String _datini;
  public String _cdatini;
  public String _datfin;
  public String _cdatfin;
  public String _numril;
  public String _flgderiv;
  public String _luonas;
  public String _datnas;
  public String _sesso;
  public String _codfisc;
  public String _tipodoc;
  public String _dataril;
  public String _datasca;
  public String _numdoc;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_wu_stampa_trx
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
  public SXSSFWorkbook wb;
  public SXSSFSheet sheet;
  public Row row; 
  public Cell cell;
  public CellStyle cs;
  public Font f;
  // * --- Fine Area Manuale
  public arrt_wu_stampa_trxR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_wu_stampa_trx",m_Caller);
    m_cPhName_wutrxchk = p_ContextObject.GetPhName("wutrxchk");
    if (m_cPhName_wutrxchk.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wutrxchk = m_cPhName_wutrxchk+" "+m_Ctx.GetWritePhName("wutrxchk");
    }
    m_cServer_wutrxchk = p_ContextObject.GetServer("wutrxchk");
    m_cPhName_cpusers = p_ContextObject.GetPhName("cpusers");
    if (m_cPhName_cpusers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers = m_cPhName_cpusers+" "+m_Ctx.GetWritePhName("cpusers");
    }
    m_cServer_cpusers = p_ContextObject.GetServer("cpusers");
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
    if (CPLib.eqr("_ccasi",p_cVarName)) {
      return _ccasi;
    }
    if (CPLib.eqr("_durata",p_cVarName)) {
      return _durata;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_wu_stampa_trx";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
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
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("_filexls",p_cVarName)) {
      return _filexls;
    }
    if (CPLib.eqr("_filexlspath",p_cVarName)) {
      return _filexlspath;
    }
    if (CPLib.eqr("_trxcodprg",p_cVarName)) {
      return _trxcodprg;
    }
    if (CPLib.eqr("_mtcn",p_cVarName)) {
      return _mtcn;
    }
    if (CPLib.eqr("_nominativo",p_cVarName)) {
      return _nominativo;
    }
    if (CPLib.eqr("_codute",p_cVarName)) {
      return _codute;
    }
    if (CPLib.eqr("_desute",p_cVarName)) {
      return _desute;
    }
    if (CPLib.eqr("_inilav",p_cVarName)) {
      return _inilav;
    }
    if (CPLib.eqr("_finlav",p_cVarName)) {
      return _finlav;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    if (CPLib.eqr("_caso1",p_cVarName)) {
      return _caso1;
    }
    if (CPLib.eqr("_caso2",p_cVarName)) {
      return _caso2;
    }
    if (CPLib.eqr("_caso3",p_cVarName)) {
      return _caso3;
    }
    if (CPLib.eqr("_caso4",p_cVarName)) {
      return _caso4;
    }
    if (CPLib.eqr("_caso5",p_cVarName)) {
      return _caso5;
    }
    if (CPLib.eqr("_caso6",p_cVarName)) {
      return _caso6;
    }
    if (CPLib.eqr("_datope",p_cVarName)) {
      return _datope;
    }
    if (CPLib.eqr("_agenzia",p_cVarName)) {
      return _agenzia;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      return _datini;
    }
    if (CPLib.eqr("_cdatini",p_cVarName)) {
      return _cdatini;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      return _datfin;
    }
    if (CPLib.eqr("_cdatfin",p_cVarName)) {
      return _cdatfin;
    }
    if (CPLib.eqr("_numril",p_cVarName)) {
      return _numril;
    }
    if (CPLib.eqr("_flgderiv",p_cVarName)) {
      return _flgderiv;
    }
    if (CPLib.eqr("_luonas",p_cVarName)) {
      return _luonas;
    }
    if (CPLib.eqr("_datnas",p_cVarName)) {
      return _datnas;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      return _sesso;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      return _codfisc;
    }
    if (CPLib.eqr("_tipodoc",p_cVarName)) {
      return _tipodoc;
    }
    if (CPLib.eqr("_dataril",p_cVarName)) {
      return _dataril;
    }
    if (CPLib.eqr("_datasca",p_cVarName)) {
      return _datasca;
    }
    if (CPLib.eqr("_numdoc",p_cVarName)) {
      return _numdoc;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDatIni",p_cVarName)) {
      return pDatIni;
    }
    if (CPLib.eqr("pDatFin",p_cVarName)) {
      return pDatFin;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_tinilav",p_cVarName)) {
      return _tinilav;
    }
    if (CPLib.eqr("_tfinlav",p_cVarName)) {
      return _tfinlav;
    }
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
    if (CPLib.eqr("_ccasi",p_cVarName)) {
      _ccasi = value;
      return;
    }
    if (CPLib.eqr("_durata",p_cVarName)) {
      _durata = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
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
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("_filexls",p_cVarName)) {
      _filexls = value;
      return;
    }
    if (CPLib.eqr("_filexlspath",p_cVarName)) {
      _filexlspath = value;
      return;
    }
    if (CPLib.eqr("_trxcodprg",p_cVarName)) {
      _trxcodprg = value;
      return;
    }
    if (CPLib.eqr("_mtcn",p_cVarName)) {
      _mtcn = value;
      return;
    }
    if (CPLib.eqr("_nominativo",p_cVarName)) {
      _nominativo = value;
      return;
    }
    if (CPLib.eqr("_codute",p_cVarName)) {
      _codute = value;
      return;
    }
    if (CPLib.eqr("_desute",p_cVarName)) {
      _desute = value;
      return;
    }
    if (CPLib.eqr("_inilav",p_cVarName)) {
      _inilav = value;
      return;
    }
    if (CPLib.eqr("_finlav",p_cVarName)) {
      _finlav = value;
      return;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
    if (CPLib.eqr("_caso1",p_cVarName)) {
      _caso1 = value;
      return;
    }
    if (CPLib.eqr("_caso2",p_cVarName)) {
      _caso2 = value;
      return;
    }
    if (CPLib.eqr("_caso3",p_cVarName)) {
      _caso3 = value;
      return;
    }
    if (CPLib.eqr("_caso4",p_cVarName)) {
      _caso4 = value;
      return;
    }
    if (CPLib.eqr("_caso5",p_cVarName)) {
      _caso5 = value;
      return;
    }
    if (CPLib.eqr("_caso6",p_cVarName)) {
      _caso6 = value;
      return;
    }
    if (CPLib.eqr("_datope",p_cVarName)) {
      _datope = value;
      return;
    }
    if (CPLib.eqr("_agenzia",p_cVarName)) {
      _agenzia = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      _datini = value;
      return;
    }
    if (CPLib.eqr("_cdatini",p_cVarName)) {
      _cdatini = value;
      return;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      _datfin = value;
      return;
    }
    if (CPLib.eqr("_cdatfin",p_cVarName)) {
      _cdatfin = value;
      return;
    }
    if (CPLib.eqr("_numril",p_cVarName)) {
      _numril = value;
      return;
    }
    if (CPLib.eqr("_flgderiv",p_cVarName)) {
      _flgderiv = value;
      return;
    }
    if (CPLib.eqr("_luonas",p_cVarName)) {
      _luonas = value;
      return;
    }
    if (CPLib.eqr("_datnas",p_cVarName)) {
      _datnas = value;
      return;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      _sesso = value;
      return;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      _codfisc = value;
      return;
    }
    if (CPLib.eqr("_tipodoc",p_cVarName)) {
      _tipodoc = value;
      return;
    }
    if (CPLib.eqr("_dataril",p_cVarName)) {
      _dataril = value;
      return;
    }
    if (CPLib.eqr("_datasca",p_cVarName)) {
      _datasca = value;
      return;
    }
    if (CPLib.eqr("_numdoc",p_cVarName)) {
      _numdoc = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pDatIni",p_cVarName)) {
      pDatIni = value;
      return;
    }
    if (CPLib.eqr("pDatFin",p_cVarName)) {
      pDatFin = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
    if (CPLib.eqr("_tinilav",p_cVarName)) {
      _tinilav = value;
      return;
    }
    if (CPLib.eqr("_tfinlav",p_cVarName)) {
      _tfinlav = value;
      return;
    }
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
    CPResultSet Cursor_qbe_wu_stampa_trx=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_wu_stampa_trx_cases=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pDatIni Date // Data Inizio Periodo */
      /* pDatFin Date // Data Fine Periodo */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) */
      /* gUrlApp Char(80) // URL Applicazione */
      /* _filexls Char(80) */
      /* _filexlspath Char(80) */
      /* _trxcodprg Char(15) */
      /* _mtcn Char(10) */
      /* _nominativo Char(100) */
      /* _codute Char(10) */
      /* _desute Char(10) */
      /* _inilav Char(30) */
      /* _finlav Char(30) */
      /* _esito Char(50) */
      /* _caso1 Char(80) */
      /* _caso2 Char(80) */
      /* _caso3 Char(80) */
      /* _caso4 Char(80) */
      /* _caso5 Char(80) */
      /* _caso6 Char(80) */
      /* _ccasi Numeric(1, 0) */
      /* _datope Char(10) */
      /* _agenzia Char(10) */
      /* _durata Numeric(10, 0) */
      /* _tinilav DateTime */
      /* _tfinlav DateTime */
      /* cRitorno Char(50) */
      /* _datini Char(10) */
      /* _cdatini Char(8) */
      /* _datfin Char(10) */
      /* _cdatfin Char(8) */
      /* _numril Char(2) */
      /* _flgderiv Char(1) */
      /* _luonas Char(60) */
      /* _datnas Char(10) */
      /* _sesso Char(10) */
      /* _codfisc Char(16) */
      /* _tipodoc Char(50) */
      /* _dataril Char(10) */
      /* _datasca Char(10) */
      /* _numdoc Char(20) */
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
      double nTry00000032status;
      nTry00000032status = m_Sql.GetTransactionStatus();
      String cTry00000032msg;
      cTry00000032msg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgImp := 'Attendere. Creazione del file excel ...' // Messaggio Import */
        gMsgImp = "Attendere. Creazione del file excel ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Formato Excel */
        /* _filexls := 'TRX_AUA_'+DateToChar(Date())+".xlsx" */
        _filexls = "TRX_AUA_"+CPLib.DateToChar(CPLib.Date())+".xlsx";
        /* _filexlspath := LRTrim(gPathApp)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(_filexls) */
        _filexlspath = CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_filexls);
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
        cell.setCellValue("NUMERO CASO");
        cell.setCellStyle(cs);
        cell = row.createCell(1);
        cell.setCellValue("MTCN");
        cell.setCellStyle(cs);
        cell = row.createCell(2);
        cell.setCellValue("DATA OPERAZIONE");
        cell.setCellStyle(cs);
        cell = row.createCell(3);
        cell.setCellValue("NOMINATIVO");
        cell.setCellStyle(cs);
        cell =  row.createCell(4);
        cell.setCellValue("AGENZIA");
        cell.setCellStyle(cs);
        cell =  row.createCell(5);
        cell.setCellValue("NOME UTENTE");
        cell.setCellStyle(cs);
        cell =  row.createCell(6);
        cell.setCellValue("CASO 1");
        cell.setCellStyle(cs);
        cell =  row.createCell(7);
        cell.setCellValue("CASO 2");
        cell.setCellStyle(cs);
        cell =  row.createCell(8);
        cell.setCellValue("CASO 3");
        cell.setCellStyle(cs);
        cell = row.createCell(9);
        cell.setCellValue("CASO 4");
        cell.setCellStyle(cs);
        cell = row.createCell(10);
        cell.setCellValue("CASO 5");
        cell.setCellStyle(cs);
        cell = row.createCell(11);
        cell.setCellValue("DATA E ORA INIZIO LAVORAZIONE");
        cell.setCellStyle(cs);
        cell = row.createCell(12);
        cell.setCellValue("DATA INIZIO LAVORAZIONE");
        cell.setCellStyle(cs);
        cell = row.createCell(13);
        cell.setCellValue("DATA E ORA FINE LAVORAZIONE");
        cell.setCellStyle(cs);
        cell = row.createCell(14);
        cell.setCellValue("DATA FINE LAVORAZIONE");
        cell.setCellStyle(cs);
        cell = row.createCell(15);
        cell.setCellValue("DURATA");
        cell.setCellStyle(cs);
        cell = row.createCell(16);
        cell.setCellValue("N. RILIEVI");
        cell.setCellStyle(cs);
        cell = row.createCell(17);
        cell.setCellValue("ESITO");
        cell.setCellStyle(cs);
        cell = row.createCell(18);
        cell.setCellValue("CORREZIONE DERIVATA");
        cell.setCellStyle(cs);
        cell = row.createCell(19);
        cell.setCellValue("Luogo di Nascita");
        cell.setCellStyle(cs);
        cell = row.createCell(20);
        cell.setCellValue("Data di Nascita");
        cell.setCellStyle(cs);
        cell = row.createCell(21);
        cell.setCellValue("Sesso");
        cell.setCellStyle(cs);
        cell = row.createCell(22);
        cell.setCellValue("Tipo Documento");
        cell.setCellStyle(cs);
        cell = row.createCell(23);
        cell.setCellValue("N. Documento");
        cell.setCellStyle(cs);
        cell = row.createCell(24);
        cell.setCellValue("Rilascio Documento");
        cell.setCellStyle(cs);
        cell = row.createCell(25);
        cell.setCellValue("Scadenza Documento");
        cell.setCellStyle(cs);
        cell = row.createCell(26);
        cell.setCellValue("Codice Fiscale");
        cell.setCellStyle(cs);
        r++;
        // * --- Select from qbe_wu_stampa_trx
        SPBridge.HMCaller _h0000003E;
        _h0000003E = new SPBridge.HMCaller();
        _h0000003E.Set("m_cVQRList",m_cVQRList);
        _h0000003E.Set("pDaData",pDatIni);
        _h0000003E.Set("pAData",pDatFin);
        if (Cursor_qbe_wu_stampa_trx!=null)
          Cursor_qbe_wu_stampa_trx.Close();
        Cursor_qbe_wu_stampa_trx = new VQRHolder("qbe_wu_stampa_trx",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000003E,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_wu_stampa_trx.Eof())) {
          /* gMsgImp := 'Elaborazione della caso n. '+LRTrim(Str(qbe_wu_stampa_trx->TRXCODPRG,15,0)) */
          gMsgImp = "Elaborazione della caso n. "+CPLib.LRTrim(CPLib.Str(Cursor_qbe_wu_stampa_trx.GetDouble("TRXCODPRG"),15,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _trxcodprg := LRTrim(Str(qbe_wu_stampa_trx->TRXCODPRG,15,0)) */
          _trxcodprg = CPLib.LRTrim(CPLib.Str(Cursor_qbe_wu_stampa_trx.GetDouble("TRXCODPRG"),15,0));
          /* _mtcn := qbe_wu_stampa_trx->TRXMTCN */
          _mtcn = Cursor_qbe_wu_stampa_trx.GetString("TRXMTCN");
          /* _nominativo := LRTrim(qbe_wu_stampa_trx->TRXCOGNOM)+" "+LRTrim(qbe_wu_stampa_trx->TRXNOME) */
          _nominativo = CPLib.LRTrim(Cursor_qbe_wu_stampa_trx.GetString("TRXCOGNOM"))+" "+CPLib.LRTrim(Cursor_qbe_wu_stampa_trx.GetString("TRXNOME"));
          /* _codute := LRTrim(Str(qbe_wu_stampa_trx->TRXUTENTE,10,0)) */
          _codute = CPLib.LRTrim(CPLib.Str(Cursor_qbe_wu_stampa_trx.GetDouble("TRXUTENTE"),10,0));
          /* _datope := arfn_fdate(qbe_wu_stampa_trx->TRXDATOPE) */
          _datope = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_wu_stampa_trx.GetDate("TRXDATOPE"));
          /* _agenzia := qbe_wu_stampa_trx->TRXCODDIP */
          _agenzia = Cursor_qbe_wu_stampa_trx.GetString("TRXCODDIP");
          /* _flgderiv := qbe_wu_stampa_trx->TRXDERIVATA */
          _flgderiv = Cursor_qbe_wu_stampa_trx.GetString("TRXDERIVATA");
          /* _tinilav := qbe_wu_stampa_trx->TRXTINILAV */
          _tinilav = Cursor_qbe_wu_stampa_trx.GetDateTime("TRXTINILAV");
          /* _tfinlav := qbe_wu_stampa_trx->TRXTFINLAV */
          _tfinlav = Cursor_qbe_wu_stampa_trx.GetDateTime("TRXTFINLAV");
          /* _durata := (_tfinlav.getTime() - _tinilav.getTime()) / 1000 */
          _durata = CPLib.Round((_tfinlav.getTime()-_tinilav.getTime())/1000,0);
          /* _desute := '' */
          _desute = "";
          // * --- Read from cpusers
          m_cServer = m_Ctx.GetServer("cpusers");
          m_cPhName = m_Ctx.GetPhName("cpusers");
          m_cSql = "";
          m_cSql = m_cSql+"code="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_wu_stampa_trx.GetDouble("TRXUTENTE"),"N",10,0,m_cServer),m_cServer,Cursor_qbe_wu_stampa_trx.GetDouble("TRXUTENTE"));
          if (m_Ctx.IsSharedTemp("cpusers")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("fullname",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _desute = Read_Cursor.GetString("fullname");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on cpusers into routine arrt_wu_stampa_trx returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _desute = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* _inilav := arfn_fdatetime(qbe_wu_stampa_trx->TRXTINILAV) */
          _inilav = arfn_fdatetimeR.Make(m_Ctx,this).Run(Cursor_qbe_wu_stampa_trx.GetDateTime("TRXTINILAV"));
          /* _finlav := arfn_fdatetime(qbe_wu_stampa_trx->TRXTFINLAV) */
          _finlav = arfn_fdatetimeR.Make(m_Ctx,this).Run(Cursor_qbe_wu_stampa_trx.GetDateTime("TRXTFINLAV"));
          /* _datini := Left(_inilav,10) */
          _datini = CPLib.Left(_inilav,10);
          /* _datfin := Left(_finlav,10) */
          _datfin = CPLib.Left(_finlav,10);
          /* _numril := LRTrim(Str(qbe_wu_stampa_trx->TRXNUMRIL,2,0)) */
          _numril = CPLib.LRTrim(CPLib.Str(Cursor_qbe_wu_stampa_trx.GetDouble("TRXNUMRIL"),2,0));
          /* _esito := iif(qbe_wu_stampa_trx->TRXESITO='O','DATI ORIGINALI',iif(qbe_wu_stampa_trx->TRXESITO='V','DATI AUI','FORZATURA DATI')) */
          _esito = (CPLib.eqr(Cursor_qbe_wu_stampa_trx.GetString("TRXESITO"),"O")?"DATI ORIGINALI":(CPLib.eqr(Cursor_qbe_wu_stampa_trx.GetString("TRXESITO"),"V")?"DATI AUI":"FORZATURA DATI"));
          /* _luonas := LRTrim(qbe_wu_stampa_trx->TRXLUONAS) */
          _luonas = CPLib.LRTrim(Cursor_qbe_wu_stampa_trx.GetString("TRXLUONAS"));
          /* _datnas := arfn_fdate(qbe_wu_stampa_trx->TRXDATNAS) */
          _datnas = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_wu_stampa_trx.GetDate("TRXDATNAS"));
          /* _sesso := iif(qbe_wu_stampa_trx->TRXSESSO='M','Maschio','Femmina') */
          _sesso = (CPLib.eqr(Cursor_qbe_wu_stampa_trx.GetString("TRXSESSO"),"M")?"Maschio":"Femmina");
          /* _codfisc := LRTrim(qbe_wu_stampa_trx->TRXCODFIS) */
          _codfisc = CPLib.LRTrim(Cursor_qbe_wu_stampa_trx.GetString("TRXCODFIS"));
          /* _tipodoc := qbe_wu_stampa_trx->TRXTIPDOC */
          _tipodoc = Cursor_qbe_wu_stampa_trx.GetString("TRXTIPDOC");
          /* _dataril := arfn_fdate(qbe_wu_stampa_trx->TRXDATRIL) */
          _dataril = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_wu_stampa_trx.GetDate("TRXDATRIL"));
          /* _datasca := arfn_fdate(qbe_wu_stampa_trx->TRXDATSCA) */
          _datasca = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_wu_stampa_trx.GetDate("TRXDATSCA"));
          /* _numdoc := qbe_wu_stampa_trx->TRXNUMDOC */
          _numdoc = Cursor_qbe_wu_stampa_trx.GetString("TRXNUMDOC");
          /* _caso1 := '' */
          _caso1 = "";
          /* _caso2 := '' */
          _caso2 = "";
          /* _caso3 := '' */
          _caso3 = "";
          /* _caso4 := '' */
          _caso4 = "";
          /* _caso5 := '' */
          _caso5 = "";
          /* _caso6 := '' */
          _caso6 = "";
          // * --- Select from qbe_wu_stampa_trx_cases
          SPBridge.HMCaller _h00000062;
          _h00000062 = new SPBridge.HMCaller();
          _h00000062.Set("m_cVQRList",m_cVQRList);
          _h00000062.Set("pTRXCODPRG",Cursor_qbe_wu_stampa_trx.GetDouble("TRXCODPRG"));
          if (Cursor_qbe_wu_stampa_trx_cases!=null)
            Cursor_qbe_wu_stampa_trx_cases.Close();
          Cursor_qbe_wu_stampa_trx_cases = new VQRHolder("qbe_wu_stampa_trx_cases",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000062,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_wu_stampa_trx_cases.Eof())) {
            /* Case qbe_wu_stampa_trx_cases->TRXCODCASE=1 */
            if (CPLib.eqr(Cursor_qbe_wu_stampa_trx_cases.GetDouble("TRXCODCASE"),1)) {
              /* _caso1 := qbe_wu_stampa_trx_cases->WCNOMCAS */
              _caso1 = Cursor_qbe_wu_stampa_trx_cases.GetString("WCNOMCAS");
              /* Case qbe_wu_stampa_trx_cases->TRXCODCASE=2 */
            } else if (CPLib.eqr(Cursor_qbe_wu_stampa_trx_cases.GetDouble("TRXCODCASE"),2)) {
              /* _caso2 := qbe_wu_stampa_trx_cases->WCNOMCAS */
              _caso2 = Cursor_qbe_wu_stampa_trx_cases.GetString("WCNOMCAS");
              /* Case qbe_wu_stampa_trx_cases->TRXCODCASE=3 */
            } else if (CPLib.eqr(Cursor_qbe_wu_stampa_trx_cases.GetDouble("TRXCODCASE"),3)) {
              /* _caso3 := qbe_wu_stampa_trx_cases->WCNOMCAS */
              _caso3 = Cursor_qbe_wu_stampa_trx_cases.GetString("WCNOMCAS");
              /* Case qbe_wu_stampa_trx_cases->TRXCODCASE=4 */
            } else if (CPLib.eqr(Cursor_qbe_wu_stampa_trx_cases.GetDouble("TRXCODCASE"),4)) {
              /* _caso4 := qbe_wu_stampa_trx_cases->WCNOMCAS */
              _caso4 = Cursor_qbe_wu_stampa_trx_cases.GetString("WCNOMCAS");
              /* Case qbe_wu_stampa_trx_cases->TRXCODCASE=5 */
            } else if (CPLib.eqr(Cursor_qbe_wu_stampa_trx_cases.GetDouble("TRXCODCASE"),5)) {
              /* _caso5 := qbe_wu_stampa_trx_cases->WCNOMCAS */
              _caso5 = Cursor_qbe_wu_stampa_trx_cases.GetString("WCNOMCAS");
              /* Case qbe_wu_stampa_trx_cases->TRXCODCASE=6 */
            } else if (CPLib.eqr(Cursor_qbe_wu_stampa_trx_cases.GetDouble("TRXCODCASE"),6)) {
              /* _caso6 := qbe_wu_stampa_trx_cases->WCNOMCAS */
              _caso6 = Cursor_qbe_wu_stampa_trx_cases.GetString("WCNOMCAS");
            } // End Case
            Cursor_qbe_wu_stampa_trx_cases.Next();
          }
          m_cConnectivityError = Cursor_qbe_wu_stampa_trx_cases.ErrorMessage();
          Cursor_qbe_wu_stampa_trx_cases.Close();
          // * --- End Select
          // Scrive la riga
          row = sheet.createRow(r);
          cell = row.createCell(0);
          cell.setCellValue(_trxcodprg);
          cell = row.createCell(1);
          cell.setCellValue(_mtcn);
          cell = row.createCell(2);
          cell.setCellValue(_datope);
          cell = row.createCell(3);
          cell.setCellValue(_nominativo);
          cell = row.createCell(4);
          cell.setCellValue(_agenzia);
          cell = row.createCell(5);
          cell.setCellValue(_desute);
          cell = row.createCell(6);
          cell.setCellValue(_caso1);
          cell = row.createCell(7);
          cell.setCellValue(_caso2);
          cell = row.createCell(8);
          cell.setCellValue(_caso3);
          cell = row.createCell(9);
          cell.setCellValue(_caso4);
          cell = row.createCell(10);
          cell.setCellValue(_caso5);
          cell = row.createCell(11);
          cell.setCellValue(_inilav);
          cell = row.createCell(12);
          cell.setCellValue(_datini);
          cell = row.createCell(13);
          cell.setCellValue(_finlav);
          cell = row.createCell(14);
          cell.setCellValue(_datfin);
          cell = row.createCell(15);
          cell.setCellValue(CPLib.LRTrim(CPLib.Str(_durata,10,0)));
          cell = row.createCell(16);
          cell.setCellValue(_numril);
          cell = row.createCell(17);
          cell.setCellValue(_esito);
          cell = row.createCell(18);
          cell.setCellValue(_flgderiv);
          cell = row.createCell(19);
          cell.setCellValue(_luonas);
          cell = row.createCell(20);
          cell.setCellValue(_datnas);
          cell = row.createCell(21);
          cell.setCellValue(_sesso);
          cell = row.createCell(22);
          cell.setCellValue(_tipodoc);
          cell = row.createCell(23);
          cell.setCellValue(_numdoc);
          cell = row.createCell(24);
          cell.setCellValue(_dataril);
          cell = row.createCell(25);
          cell.setCellValue(_datasca);
          cell = row.createCell(26);
          cell.setCellValue(_codfisc);
          r++;
          Cursor_qbe_wu_stampa_trx.Next();
        }
        m_cConnectivityError = Cursor_qbe_wu_stampa_trx.ErrorMessage();
        Cursor_qbe_wu_stampa_trx.Close();
        // * --- End Select
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
        
        // scrivo il file di esito
        FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(_filexlspath));
        //write this workbook to an Outputstream.
        wb.write(fileOut);
        fileOut.flush();
        fileOut.close();
        /* cRitorno := _filexls */
        cRitorno = _filexls;
        // * --- Insert into tmp_listafile from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_listafile");
        m_cPhName = m_Ctx.GetPhName("tmp_listafile");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_listafile",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_stampa_trx",41,"0000006F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000006F(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_filexls),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gUrlApp)+"export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_filexls),"?",0,0,m_cServer)+", ";
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
          throw new RoutineException();
        }
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* cRitorno := '' */
        cRitorno = "";
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000032status,0)) {
          m_Sql.SetTransactionStatus(nTry00000032status,cTry00000032msg);
        }
      }
      /* gMsgImp := 'Elaborazione terminata!' // Messaggio Import */
      gMsgImp = "Elaborazione terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
      try {
        if (Cursor_qbe_wu_stampa_trx!=null)
          Cursor_qbe_wu_stampa_trx.Close();
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
        if (Cursor_qbe_wu_stampa_trx_cases!=null)
          Cursor_qbe_wu_stampa_trx_cases.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_pDatIni,java.sql.Date p_pDatFin) {
    pDatIni = p_pDatIni;
    pDatFin = p_pDatFin;
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
  public String Run(java.sql.Date p_pDatIni,java.sql.Date p_pDatFin) {
    pDatIni = p_pDatIni;
    pDatFin = p_pDatFin;
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
  public static arrt_wu_stampa_trxR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_wu_stampa_trxR(p_Ctx, p_Caller);
  }
  public static arrt_wu_stampa_trxR Make(CPContext p_Ctx) {
    return new arrt_wu_stampa_trxR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pDatIni = CPLib.NullDate();
    pDatFin = CPLib.NullDate();
    _filexls = CPLib.Space(80);
    _filexlspath = CPLib.Space(80);
    _trxcodprg = CPLib.Space(15);
    _mtcn = CPLib.Space(10);
    _nominativo = CPLib.Space(100);
    _codute = CPLib.Space(10);
    _desute = CPLib.Space(10);
    _inilav = CPLib.Space(30);
    _finlav = CPLib.Space(30);
    _esito = CPLib.Space(50);
    _caso1 = CPLib.Space(80);
    _caso2 = CPLib.Space(80);
    _caso3 = CPLib.Space(80);
    _caso4 = CPLib.Space(80);
    _caso5 = CPLib.Space(80);
    _caso6 = CPLib.Space(80);
    _ccasi = 0;
    _datope = CPLib.Space(10);
    _agenzia = CPLib.Space(10);
    _durata = 0;
    _tinilav = CPLib.NullDateTime();
    _tfinlav = CPLib.NullDateTime();
    cRitorno = CPLib.Space(50);
    _datini = CPLib.Space(10);
    _cdatini = CPLib.Space(8);
    _datfin = CPLib.Space(10);
    _cdatfin = CPLib.Space(8);
    _numril = CPLib.Space(2);
    _flgderiv = CPLib.Space(1);
    _luonas = CPLib.Space(60);
    _datnas = CPLib.Space(10);
    _sesso = CPLib.Space(10);
    _codfisc = CPLib.Space(16);
    _tipodoc = CPLib.Space(50);
    _dataril = CPLib.Space(10);
    _datasca = CPLib.Space(10);
    _numdoc = CPLib.Space(20);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_wu_stampa_trx,qbe_wu_stampa_trx_cases,
  public static final String m_cVQRList = ",qbe_wu_stampa_trx,qbe_wu_stampa_trx_cases,";
  // ENTITY_BATCHES: ,arfn_fdate,arfn_fdatetime,arrt_wu_stampa_trx,
  public static final String i_InvokedRoutines = ",arfn_fdate,arfn_fdatetime,arrt_wu_stampa_trx,";
  public static String[] m_cRunParameterNames={"pDatIni","pDatFin"};
  protected static String GetFieldsName_0000006F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"priorita,";
    p_cSql = p_cSql+"hyperlynk,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_listafile",true);
    return p_cSql;
  }
}
