// * --- Area Manuale = BO - Header
// * --- wubp_to_xlsx
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
public class wubp_to_xlsxR implements CallerWithObjs {
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
  public String gAzienda;
  public String gPathApp;
  // * --- Area Manuale = BO - Properties
  // * --- wubp_to_xlsx
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
  public wubp_to_xlsxR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("wubp_to_xlsx",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "wubp_to_xlsx";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
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
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
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
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
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
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
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
  void Page_Main() throws Exception {
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
    /* gAzienda Char(10) // Azienda */
    /* gPathApp Char(80) // Path Applicazione */
    /* _nfile := LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+"/10671321007_2018_01.xlsx" */
    _nfile = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/10671321007_2018_01.xlsx";
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
    cell.setCellValue("Segno");
    cell.setCellStyle(cs);
    cell =  row.createCell(1);
    cell.setCellValue("Provincia");
    cell.setCellStyle(cs);
    cell = row.createCell(2);
    cell.setCellValue("Stato Controparte");
    cell.setCellStyle(cs);
    cell = row.createCell(3);
    cell.setCellValue("Importo Operazioni");
    cell.setCellStyle(cs);
    cell =  row.createCell(4);
    cell.setCellValue("N. Operazioni");
    cell.setCellStyle(cs);
    r=r+2;
    /* fhand := FileLibMit.OpenRead('appo/10671321007_2018_01.xml') // Per gestione file */
    fhand = FileLibMit.OpenRead("appo/10671321007_2018_01.xml");
    /* _tot := 0 */
    _tot = CPLib.Round(0,0);
    /* While not(FileLibMit.Eof(fhand)) */
    while ( ! (FileLibMit.Eof(fhand))) {
      /* _tot := _tot + 1 */
      _tot = CPLib.Round(_tot+1,0);
      /* riga := FileLibMit.ReadLine(fhand) */
      riga = FileLibMit.ReadLine(fhand);
      /* Case _tot = 4 */
      if (CPLib.eqr(_tot,4)) {
        /* _segno := Substr(riga,36,3) */
        _segno = CPLib.Substr(riga,36,3);
        /* Case _tot = 5 */
      } else if (CPLib.eqr(_tot,5)) {
        /* riga := Substr(riga,30) */
        riga = CPLib.Substr(riga,30);
        /* _prov := Left(riga,At('"/>',riga)-1) */
        _prov = CPLib.Left(riga,CPLib.At("\"/>",riga)-1);
        /* Case _tot = 6 */
      } else if (CPLib.eqr(_tot,6)) {
        /* riga := Substr(riga,30) */
        riga = CPLib.Substr(riga,30);
        /* _paese := Left(riga,At('"/>',riga)-1) */
        _paese = CPLib.Left(riga,CPLib.At("\"/>",riga)-1);
        /* Case _tot = 7 */
      } else if (CPLib.eqr(_tot,7)) {
        /* riga := Substr(riga,39) */
        riga = CPLib.Substr(riga,39);
        /* _impope := Left(riga,At('"/>',riga)-1) */
        _impope = CPLib.Left(riga,CPLib.At("\"/>",riga)-1);
        /* Case _tot = 8 */
      } else if (CPLib.eqr(_tot,8)) {
        /* riga := Substr(riga,29) */
        riga = CPLib.Substr(riga,29);
        /* _numope := Left(riga,At('"/>',riga)-1) */
        _numope = CPLib.Left(riga,CPLib.At("\"/>",riga)-1);
      } // End Case
      /* If _tot = 9 */
      if (CPLib.eqr(_tot,9)) {
        //Creo il record da scrivere
        row = sheet.createRow(r);
        cell = row.createCell(0);
        cell.setCellValue(CPLib.LRTrim(_segno));
        cell = row.createCell(1);
        cell.setCellValue(CPLib.LRTrim(_prov));
        cell = row.createCell(2);
        cell.setCellValue(CPLib.LRTrim(_paese));
        cell = row.createCell(3);
        cell.setCellValue(CPLib.LRTrim(_impope));
        cell = row.createCell(4);
        cell.setCellValue(CPLib.LRTrim(_numope));
        r=r+1;
        /* _tot := 0 */
        _tot = CPLib.Round(0,0);
      } // End If
    } // End While
    //Ridimensiono le colonne in base al contenuto
    sheet.autoSizeColumn(0);
    sheet.autoSizeColumn(1);
    sheet.autoSizeColumn(2);
    sheet.autoSizeColumn(3);
    sheet.autoSizeColumn(4);
    // scrivo il file di esito
    FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(_nfile));
    //write this workbook to an Outputstream.
    wb.write(fileOut);
    fileOut.flush();
    fileOut.close();
    FileLibMit.Close(fhand);
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
          Page_Main();
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static wubp_to_xlsxR Make(CPContext p_Ctx, Caller p_Caller) {
    return new wubp_to_xlsxR(p_Ctx, p_Caller);
  }
  public void Blank() {
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
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
