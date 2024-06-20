// * --- Area Manuale = BO - Header
// * --- arrt_wu_stampa_autocorrect
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
public class arrt_wu_stampa_autocorrectR implements CallerWithObjs {
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
  public String cRitorno;
  public String _mtcn;
  public String _datope;
  public String _datac;
  public String _incognome;
  public String _innome;
  public String _inluonas;
  public String _indatnas;
  public String _insesso;
  public String _intipdoc;
  public String _innumdoc;
  public String _incodfis;
  public String _outcognome;
  public String _outnome;
  public String _outluonas;
  public String _outdatnas;
  public String _outsesso;
  public String _outtipdoc;
  public String _outnumdoc;
  public String _outcodfis;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_wu_stampa_autocorrect
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
  public arrt_wu_stampa_autocorrectR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_wu_stampa_autocorrect",m_Caller);
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
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_wu_stampa_autocorrect";
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
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("_mtcn",p_cVarName)) {
      return _mtcn;
    }
    if (CPLib.eqr("_datope",p_cVarName)) {
      return _datope;
    }
    if (CPLib.eqr("_datac",p_cVarName)) {
      return _datac;
    }
    if (CPLib.eqr("_incognome",p_cVarName)) {
      return _incognome;
    }
    if (CPLib.eqr("_innome",p_cVarName)) {
      return _innome;
    }
    if (CPLib.eqr("_inluonas",p_cVarName)) {
      return _inluonas;
    }
    if (CPLib.eqr("_indatnas",p_cVarName)) {
      return _indatnas;
    }
    if (CPLib.eqr("_insesso",p_cVarName)) {
      return _insesso;
    }
    if (CPLib.eqr("_intipdoc",p_cVarName)) {
      return _intipdoc;
    }
    if (CPLib.eqr("_innumdoc",p_cVarName)) {
      return _innumdoc;
    }
    if (CPLib.eqr("_incodfis",p_cVarName)) {
      return _incodfis;
    }
    if (CPLib.eqr("_outcognome",p_cVarName)) {
      return _outcognome;
    }
    if (CPLib.eqr("_outnome",p_cVarName)) {
      return _outnome;
    }
    if (CPLib.eqr("_outluonas",p_cVarName)) {
      return _outluonas;
    }
    if (CPLib.eqr("_outdatnas",p_cVarName)) {
      return _outdatnas;
    }
    if (CPLib.eqr("_outsesso",p_cVarName)) {
      return _outsesso;
    }
    if (CPLib.eqr("_outtipdoc",p_cVarName)) {
      return _outtipdoc;
    }
    if (CPLib.eqr("_outnumdoc",p_cVarName)) {
      return _outnumdoc;
    }
    if (CPLib.eqr("_outcodfis",p_cVarName)) {
      return _outcodfis;
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
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("_mtcn",p_cVarName)) {
      _mtcn = value;
      return;
    }
    if (CPLib.eqr("_datope",p_cVarName)) {
      _datope = value;
      return;
    }
    if (CPLib.eqr("_datac",p_cVarName)) {
      _datac = value;
      return;
    }
    if (CPLib.eqr("_incognome",p_cVarName)) {
      _incognome = value;
      return;
    }
    if (CPLib.eqr("_innome",p_cVarName)) {
      _innome = value;
      return;
    }
    if (CPLib.eqr("_inluonas",p_cVarName)) {
      _inluonas = value;
      return;
    }
    if (CPLib.eqr("_indatnas",p_cVarName)) {
      _indatnas = value;
      return;
    }
    if (CPLib.eqr("_insesso",p_cVarName)) {
      _insesso = value;
      return;
    }
    if (CPLib.eqr("_intipdoc",p_cVarName)) {
      _intipdoc = value;
      return;
    }
    if (CPLib.eqr("_innumdoc",p_cVarName)) {
      _innumdoc = value;
      return;
    }
    if (CPLib.eqr("_incodfis",p_cVarName)) {
      _incodfis = value;
      return;
    }
    if (CPLib.eqr("_outcognome",p_cVarName)) {
      _outcognome = value;
      return;
    }
    if (CPLib.eqr("_outnome",p_cVarName)) {
      _outnome = value;
      return;
    }
    if (CPLib.eqr("_outluonas",p_cVarName)) {
      _outluonas = value;
      return;
    }
    if (CPLib.eqr("_outdatnas",p_cVarName)) {
      _outdatnas = value;
      return;
    }
    if (CPLib.eqr("_outsesso",p_cVarName)) {
      _outsesso = value;
      return;
    }
    if (CPLib.eqr("_outtipdoc",p_cVarName)) {
      _outtipdoc = value;
      return;
    }
    if (CPLib.eqr("_outnumdoc",p_cVarName)) {
      _outnumdoc = value;
      return;
    }
    if (CPLib.eqr("_outcodfis",p_cVarName)) {
      _outcodfis = value;
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
    CPResultSet Cursor_qbe_wu_stampa_autocorrect=null;
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
      /* cRitorno Char(80) */
      /* _mtcn Char(10) */
      /* _datope Char(10) */
      /* _datac Char(10) */
      /* _incognome Char(50) */
      /* _innome Char(50) */
      /* _inluonas Char(50) */
      /* _indatnas Char(10) */
      /* _insesso Char(1) */
      /* _intipdoc Char(2) */
      /* _innumdoc Char(2) */
      /* _incodfis Char(2) */
      /* _outcognome Char(50) */
      /* _outnome Char(50) */
      /* _outluonas Char(50) */
      /* _outdatnas Char(10) */
      /* _outsesso Char(1) */
      /* _outtipdoc Char(2) */
      /* _outnumdoc Char(2) */
      /* _outcodfis Char(2) */
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
      double nTry00000023status;
      nTry00000023status = m_Sql.GetTransactionStatus();
      String cTry00000023msg;
      cTry00000023msg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgImp := 'Attendere. Creazione del file excel ...' // Messaggio Import */
        gMsgImp = "Attendere. Creazione del file excel ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Formato Excel */
        /* _filexls := 'AUTOCORRECT_AUA_'+DateToChar(Date())+".xlsx" */
        _filexls = "AUTOCORRECT_AUA_"+CPLib.DateToChar(CPLib.Date())+".xlsx";
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
        cell.setCellValue("MTCN");
        cell.setCellStyle(cs);
        cell = row.createCell(1);
        cell.setCellValue("DATA OPERAZIONE");
        cell.setCellStyle(cs);
        cell = row.createCell(2);
        cell.setCellValue("DATA AUTOCORREZIONE");
        cell.setCellStyle(cs);
        cell = row.createCell(3);
        cell.setCellValue("COGNOME IN ARRIVO");
        cell.setCellStyle(cs);
        cell =  row.createCell(4);
        cell.setCellValue("NOME IN ARRIVO");
        cell.setCellStyle(cs);
        cell =  row.createCell(5);
        cell.setCellValue("LUOGO DI NASCITA IN ARRIVO");
        cell.setCellStyle(cs);
        cell =  row.createCell(6);
        cell.setCellValue("DATA DI NASCITA IN ARRIVO");
        cell.setCellStyle(cs);
        cell =  row.createCell(7);
        cell.setCellValue("SESSO IN ARRIVO");
        cell.setCellStyle(cs);
        cell =  row.createCell(8);
        cell.setCellValue("CODICE FISCALE IN ARRIVO");
        cell.setCellStyle(cs);
        cell = row.createCell(9);
        cell.setCellValue("TIPO DOCUMENTO IN ARRIVO");
        cell.setCellStyle(cs);
        cell = row.createCell(10);
        cell.setCellValue("NUMERO DOCUMENTO IN ARRIVO");
        cell.setCellStyle(cs);
        cell = row.createCell(11);
        cell.setCellValue("COGNOME IN USCITA");
        cell.setCellStyle(cs);
        cell =  row.createCell(12);
        cell.setCellValue("NOME IN USCITA");
        cell.setCellStyle(cs);
        cell =  row.createCell(13);
        cell.setCellValue("LUOGO DI NASCITA IN USCITA");
        cell.setCellStyle(cs);
        cell =  row.createCell(14);
        cell.setCellValue("DATA DI NASCITA IN USCITA");
        cell.setCellStyle(cs);
        cell =  row.createCell(15);
        cell.setCellValue("SESSO IN USCITA");
        cell.setCellStyle(cs);
        cell =  row.createCell(16);
        cell.setCellValue("CODICE FISCALE IN USCITA");
        cell.setCellStyle(cs);
        cell = row.createCell(17);
        cell.setCellValue("TIPO DOCUMENTO IN USCITA");
        cell.setCellStyle(cs);
        cell = row.createCell(18);
        cell.setCellValue("NUMERO DOCUMENTO IN USCITA");
        cell.setCellStyle(cs);
        r++;
        // * --- Select from qbe_wu_stampa_autocorrect
        SPBridge.HMCaller _h0000002F;
        _h0000002F = new SPBridge.HMCaller();
        _h0000002F.Set("m_cVQRList",m_cVQRList);
        _h0000002F.Set("pDaData",pDatIni);
        _h0000002F.Set("pAData",pDatFin);
        if (Cursor_qbe_wu_stampa_autocorrect!=null)
          Cursor_qbe_wu_stampa_autocorrect.Close();
        Cursor_qbe_wu_stampa_autocorrect = new VQRHolder("qbe_wu_stampa_autocorrect",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000002F,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_wu_stampa_autocorrect.Eof())) {
          /* gMsgImp := 'Elaborazione della transazione n. '+LRTrim(qbe_wu_stampa_autocorrect->MTCN) */
          gMsgImp = "Elaborazione della transazione n. "+CPLib.LRTrim(Cursor_qbe_wu_stampa_autocorrect.GetString("MTCN"));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _mtcn := qbe_wu_stampa_autocorrect->MTCN */
          _mtcn = Cursor_qbe_wu_stampa_autocorrect.GetString("MTCN");
          /* _datope := arfn_fdate(qbe_wu_stampa_autocorrect->DATAOPE) */
          _datope = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_wu_stampa_autocorrect.GetDate("DATAOPE"));
          /* _datac := arfn_fdate(qbe_wu_stampa_autocorrect->DCORRECTION) */
          _datac = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_wu_stampa_autocorrect.GetDate("DCORRECTION"));
          /* _incognome := qbe_wu_stampa_autocorrect->AUOCOGNOM */
          _incognome = Cursor_qbe_wu_stampa_autocorrect.GetString("AUOCOGNOM");
          /* _innome := qbe_wu_stampa_autocorrect->AUONOME */
          _innome = Cursor_qbe_wu_stampa_autocorrect.GetString("AUONOME");
          /* _inluonas := qbe_wu_stampa_autocorrect->AUOLUONAS */
          _inluonas = Cursor_qbe_wu_stampa_autocorrect.GetString("AUOLUONAS");
          /* _indatnas := arfn_fdate(qbe_wu_stampa_autocorrect->AUODATNAS) */
          _indatnas = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_wu_stampa_autocorrect.GetDate("AUODATNAS"));
          /* _insesso := qbe_wu_stampa_autocorrect->AUOSESSO */
          _insesso = Cursor_qbe_wu_stampa_autocorrect.GetString("AUOSESSO");
          /* _intipdoc := qbe_wu_stampa_autocorrect->AUOTIPDOC */
          _intipdoc = Cursor_qbe_wu_stampa_autocorrect.GetString("AUOTIPDOC");
          /* _innumdoc := qbe_wu_stampa_autocorrect->AUONUMDOC */
          _innumdoc = Cursor_qbe_wu_stampa_autocorrect.GetString("AUONUMDOC");
          /* _incodfis := qbe_wu_stampa_autocorrect->AUOCODFISC */
          _incodfis = Cursor_qbe_wu_stampa_autocorrect.GetString("AUOCODFISC");
          /* _outcognome := qbe_wu_stampa_autocorrect->AUCOGNOM */
          _outcognome = Cursor_qbe_wu_stampa_autocorrect.GetString("AUCOGNOM");
          /* _outnome := qbe_wu_stampa_autocorrect->AUNOME */
          _outnome = Cursor_qbe_wu_stampa_autocorrect.GetString("AUNOME");
          /* _outluonas := qbe_wu_stampa_autocorrect->AULUONAS */
          _outluonas = Cursor_qbe_wu_stampa_autocorrect.GetString("AULUONAS");
          /* _outdatnas := arfn_fdate(qbe_wu_stampa_autocorrect->AUDATNAS) */
          _outdatnas = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_wu_stampa_autocorrect.GetDate("AUDATNAS"));
          /* _outsesso := qbe_wu_stampa_autocorrect->AUSESSO */
          _outsesso = Cursor_qbe_wu_stampa_autocorrect.GetString("AUSESSO");
          /* _outtipdoc := qbe_wu_stampa_autocorrect->AUTIPDOC */
          _outtipdoc = Cursor_qbe_wu_stampa_autocorrect.GetString("AUTIPDOC");
          /* _outnumdoc := qbe_wu_stampa_autocorrect->AUNUMDOC */
          _outnumdoc = Cursor_qbe_wu_stampa_autocorrect.GetString("AUNUMDOC");
          /* _outcodfis := qbe_wu_stampa_autocorrect->AUCODFISC */
          _outcodfis = Cursor_qbe_wu_stampa_autocorrect.GetString("AUCODFISC");
          // Scrive la riga
          row = sheet.createRow(r);
          cell = row.createCell(0);
          cell.setCellValue(_mtcn);
          cell = row.createCell(1);
          cell.setCellValue(_datope);
          cell = row.createCell(2);
          cell.setCellValue(_datac);
          cell = row.createCell(3);
          cell.setCellValue(_incognome);
          cell = row.createCell(4);
          cell.setCellValue(_innome);
          cell = row.createCell(5);
          cell.setCellValue(_inluonas);
          cell = row.createCell(6);
          cell.setCellValue(_indatnas);
          cell = row.createCell(7);
          cell.setCellValue(_insesso);
          cell = row.createCell(8);
          cell.setCellValue(_incodfis);
          cell = row.createCell(9);
          cell.setCellValue(_intipdoc);
          cell = row.createCell(10);
          cell.setCellValue(_innumdoc);
          cell = row.createCell(11);
          cell.setCellValue(_outcognome);
          cell = row.createCell(12);
          cell.setCellValue(_outnome);
          cell = row.createCell(13);
          cell.setCellValue(_outluonas);
          cell = row.createCell(14);
          cell.setCellValue(_outdatnas);
          cell = row.createCell(15);
          cell.setCellValue(_outsesso);
          cell = row.createCell(16);
          cell.setCellValue(_outcodfis);
          cell = row.createCell(17);
          cell.setCellValue(_outtipdoc);
          cell = row.createCell(18);
          cell.setCellValue(_outnumdoc);
          r++;
          Cursor_qbe_wu_stampa_autocorrect.Next();
        }
        m_cConnectivityError = Cursor_qbe_wu_stampa_autocorrect.ErrorMessage();
        Cursor_qbe_wu_stampa_autocorrect.Close();
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
        m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_stampa_autocorrect",44,"0000004A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000004A(m_Ctx,m_oWrInfo);
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000023status,0)) {
          m_Sql.SetTransactionStatus(nTry00000023status,cTry00000023msg);
        }
      }
      /* gMsgImp := 'Elaborazione terminata!' // Messaggio Import */
      gMsgImp = "Elaborazione terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
      try {
        if (Cursor_qbe_wu_stampa_autocorrect!=null)
          Cursor_qbe_wu_stampa_autocorrect.Close();
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
  public static arrt_wu_stampa_autocorrectR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_wu_stampa_autocorrectR(p_Ctx, p_Caller);
  }
  public static arrt_wu_stampa_autocorrectR Make(CPContext p_Ctx) {
    return new arrt_wu_stampa_autocorrectR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pDatIni = CPLib.NullDate();
    pDatFin = CPLib.NullDate();
    _filexls = CPLib.Space(80);
    _filexlspath = CPLib.Space(80);
    cRitorno = CPLib.Space(80);
    _mtcn = CPLib.Space(10);
    _datope = CPLib.Space(10);
    _datac = CPLib.Space(10);
    _incognome = CPLib.Space(50);
    _innome = CPLib.Space(50);
    _inluonas = CPLib.Space(50);
    _indatnas = CPLib.Space(10);
    _insesso = CPLib.Space(1);
    _intipdoc = CPLib.Space(2);
    _innumdoc = CPLib.Space(2);
    _incodfis = CPLib.Space(2);
    _outcognome = CPLib.Space(50);
    _outnome = CPLib.Space(50);
    _outluonas = CPLib.Space(50);
    _outdatnas = CPLib.Space(10);
    _outsesso = CPLib.Space(1);
    _outtipdoc = CPLib.Space(2);
    _outnumdoc = CPLib.Space(2);
    _outcodfis = CPLib.Space(2);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_wu_stampa_autocorrect,
  public static final String m_cVQRList = ",qbe_wu_stampa_autocorrect,";
  // ENTITY_BATCHES: ,arfn_fdate,arrt_wu_stampa_autocorrect,
  public static final String i_InvokedRoutines = ",arfn_fdate,arrt_wu_stampa_autocorrect,";
  public static String[] m_cRunParameterNames={"pDatIni","pDatFin"};
  protected static String GetFieldsName_0000004A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"priorita,";
    p_cSql = p_cSql+"hyperlynk,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_listafile",true);
    return p_cSql;
  }
}
