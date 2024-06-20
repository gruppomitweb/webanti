// * --- Area Manuale = BO - Header
// * --- arfn_import_correzioni_sv_wu
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
public class arfn_import_correzioni_sv_wuR implements CallerWithObjs {
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
  public String m_cPhName_analisi_sv;
  public String m_cServer_analisi_sv;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
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
  public String nomefile;
  public double riga_letta;
  public double foglio;
  public double cell_type;
  public String _cRitorno;
  public double _contar;
  public String _sotgru;
  public String _provres;
  public MemoryCursor_tbstati mcStati;
  public String column01;
  public String column02;
  public String column03;
  public String column04;
  public String column05;
  public String column06;
  public String column07;
  public String column08;
  public String column09;
  public String column10;
  public String column11;
  public String column12;
  public String column13;
  public String column14;
  public String column15;
  public String column16;
  public String column17;
  public String column18;
  public String column19;
  public String column20;
  public String column21;
  public String column22;
  public String gAzienda;
  public String gPathApp;
  public java.sql.Date gDataVaria;
  public String gMsgProc;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- arfn_import_correzioni_sv_wu
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
  public arfn_import_correzioni_sv_wuR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_import_correzioni_sv_wu",m_Caller);
    m_cPhName_analisi_sv = p_ContextObject.GetPhName("analisi_sv");
    if (m_cPhName_analisi_sv.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_analisi_sv = m_cPhName_analisi_sv+" "+m_Ctx.GetWritePhName("analisi_sv");
    }
    m_cServer_analisi_sv = p_ContextObject.GetServer("analisi_sv");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      return riga_letta;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      return foglio;
    }
    if (CPLib.eqr("cell_type",p_cVarName)) {
      return cell_type;
    }
    if (CPLib.eqr("_contar",p_cVarName)) {
      return _contar;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_import_correzioni_sv_wu";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return nomefile;
    }
    if (CPLib.eqr("_cRitorno",p_cVarName)) {
      return _cRitorno;
    }
    if (CPLib.eqr("_sotgru",p_cVarName)) {
      return _sotgru;
    }
    if (CPLib.eqr("_provres",p_cVarName)) {
      return _provres;
    }
    if (CPLib.eqr("column01",p_cVarName)) {
      return column01;
    }
    if (CPLib.eqr("column02",p_cVarName)) {
      return column02;
    }
    if (CPLib.eqr("column03",p_cVarName)) {
      return column03;
    }
    if (CPLib.eqr("column04",p_cVarName)) {
      return column04;
    }
    if (CPLib.eqr("column05",p_cVarName)) {
      return column05;
    }
    if (CPLib.eqr("column06",p_cVarName)) {
      return column06;
    }
    if (CPLib.eqr("column07",p_cVarName)) {
      return column07;
    }
    if (CPLib.eqr("column08",p_cVarName)) {
      return column08;
    }
    if (CPLib.eqr("column09",p_cVarName)) {
      return column09;
    }
    if (CPLib.eqr("column10",p_cVarName)) {
      return column10;
    }
    if (CPLib.eqr("column11",p_cVarName)) {
      return column11;
    }
    if (CPLib.eqr("column12",p_cVarName)) {
      return column12;
    }
    if (CPLib.eqr("column13",p_cVarName)) {
      return column13;
    }
    if (CPLib.eqr("column14",p_cVarName)) {
      return column14;
    }
    if (CPLib.eqr("column15",p_cVarName)) {
      return column15;
    }
    if (CPLib.eqr("column16",p_cVarName)) {
      return column16;
    }
    if (CPLib.eqr("column17",p_cVarName)) {
      return column17;
    }
    if (CPLib.eqr("column18",p_cVarName)) {
      return column18;
    }
    if (CPLib.eqr("column19",p_cVarName)) {
      return column19;
    }
    if (CPLib.eqr("column20",p_cVarName)) {
      return column20;
    }
    if (CPLib.eqr("column21",p_cVarName)) {
      return column21;
    }
    if (CPLib.eqr("column22",p_cVarName)) {
      return column22;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("gDataVaria",p_cVarName)) {
      return gDataVaria;
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
    if (CPLib.eqr("mcStati",p_cVarName)) {
      return mcStati;
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
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      riga_letta = value;
      return;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      foglio = value;
      return;
    }
    if (CPLib.eqr("cell_type",p_cVarName)) {
      cell_type = value;
      return;
    }
    if (CPLib.eqr("_contar",p_cVarName)) {
      _contar = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("nomefile",p_cVarName)) {
      nomefile = value;
      return;
    }
    if (CPLib.eqr("_cRitorno",p_cVarName)) {
      _cRitorno = value;
      return;
    }
    if (CPLib.eqr("_sotgru",p_cVarName)) {
      _sotgru = value;
      return;
    }
    if (CPLib.eqr("_provres",p_cVarName)) {
      _provres = value;
      return;
    }
    if (CPLib.eqr("column01",p_cVarName)) {
      column01 = value;
      return;
    }
    if (CPLib.eqr("column02",p_cVarName)) {
      column02 = value;
      return;
    }
    if (CPLib.eqr("column03",p_cVarName)) {
      column03 = value;
      return;
    }
    if (CPLib.eqr("column04",p_cVarName)) {
      column04 = value;
      return;
    }
    if (CPLib.eqr("column05",p_cVarName)) {
      column05 = value;
      return;
    }
    if (CPLib.eqr("column06",p_cVarName)) {
      column06 = value;
      return;
    }
    if (CPLib.eqr("column07",p_cVarName)) {
      column07 = value;
      return;
    }
    if (CPLib.eqr("column08",p_cVarName)) {
      column08 = value;
      return;
    }
    if (CPLib.eqr("column09",p_cVarName)) {
      column09 = value;
      return;
    }
    if (CPLib.eqr("column10",p_cVarName)) {
      column10 = value;
      return;
    }
    if (CPLib.eqr("column11",p_cVarName)) {
      column11 = value;
      return;
    }
    if (CPLib.eqr("column12",p_cVarName)) {
      column12 = value;
      return;
    }
    if (CPLib.eqr("column13",p_cVarName)) {
      column13 = value;
      return;
    }
    if (CPLib.eqr("column14",p_cVarName)) {
      column14 = value;
      return;
    }
    if (CPLib.eqr("column15",p_cVarName)) {
      column15 = value;
      return;
    }
    if (CPLib.eqr("column16",p_cVarName)) {
      column16 = value;
      return;
    }
    if (CPLib.eqr("column17",p_cVarName)) {
      column17 = value;
      return;
    }
    if (CPLib.eqr("column18",p_cVarName)) {
      column18 = value;
      return;
    }
    if (CPLib.eqr("column19",p_cVarName)) {
      column19 = value;
      return;
    }
    if (CPLib.eqr("column20",p_cVarName)) {
      column20 = value;
      return;
    }
    if (CPLib.eqr("column21",p_cVarName)) {
      column21 = value;
      return;
    }
    if (CPLib.eqr("column22",p_cVarName)) {
      column22 = value;
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
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("gDataVaria",p_cVarName)) {
      gDataVaria = value;
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
    if (CPLib.eqr("mcStati",p_cVarName)) {
      mcStati = (MemoryCursor_tbstati)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_tbstati=null;
    try {
      /* nomefile Char(30) // nome file da importare */
      /* riga_letta Numeric(10, 0) */
      /* foglio Numeric(2, 0) // foglio letto */
      double foglio;
      foglio = 0;
      /* cCanc Char(10) */
      String cCanc;
      cCanc = CPLib.Space(10);
      /* cProg Char(10) */
      String cProg;
      cProg = CPLib.Space(10);
      /* _progrig Char(10) */
      String _progrig;
      _progrig = CPLib.Space(10);
      /* foglio Numeric(2, 0) // foglio letto */
      /* cell_type Numeric(1, 0) // tipologia di cella letta */
      /* _cRitorno Char(2) */
      /* _contar Numeric(10, 0) */
      /* _sotgru Char(3) */
      /* _provres Char(2) */
      /* mcStati MemoryCursor(tbstati) */
      /* column01 Char(100) */
      /* column02 Char(100) */
      /* column03 Char(100) */
      /* column04 Char(100) */
      /* column05 Char(100) */
      /* column06 Char(100) */
      /* column07 Char(100) */
      /* column08 Char(100) */
      /* column09 Char(100) */
      /* column10 Char(100) */
      /* column11 Char(100) */
      /* column12 Char(100) */
      /* column13 Char(100) */
      /* column14 Char(100) */
      /* column15 Char(100) */
      /* column16 Char(100) */
      /* column17 Char(100) */
      /* column18 Char(100) */
      /* column19 Char(100) */
      /* column20 Char(100) */
      /* column21 Char(100) */
      /* column22 Char(100) */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gDataVaria Date // Data Variazione */
      /* gMsgProc Char(120) // Messaggio */
      /* gMsgImp Char(120) */
      /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefile + NL */
      gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefile+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000002Fstatus;
      nTry0000002Fstatus = m_Sql.GetTransactionStatus();
      String cTry0000002Fmsg;
      cTry0000002Fmsg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Fill memory cursor mcStati on tbstati
        mcStati.Zap();
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
                  info.log("Routine arfn_import_correzioni_sv_wu: query on tbstati returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_tbstati.Eof())) {
          mcStati.AppendWithTrimmedKey(Cursor_tbstati.GetString("CODSTA"));
          mcStati.row.CODSTA = Cursor_tbstati.GetString("CODSTA");
          mcStati.row.DESCRI = Cursor_tbstati.GetString("DESCRI");
          mcStati.row.SIGLA = Cursor_tbstati.GetString("SIGLA");
          mcStati.row.ISO = Cursor_tbstati.GetString("ISO");
          mcStati.row.ISO2 = Cursor_tbstati.GetString("ISO2");
          mcStati.row.IDTBLS = Cursor_tbstati.GetString("IDTBLS");
          mcStati.row.IDBASE = Cursor_tbstati.GetString("IDBASE");
          mcStati.row.FLGSAE = Cursor_tbstati.GetString("FLGSAE");
          mcStati.row.ISON = Cursor_tbstati.GetString("ISON");
          Cursor_tbstati.Next();
        }
        m_cConnectivityError = Cursor_tbstati.ErrorMessage();
        Cursor_tbstati.Close();
        mcStati.GoTop();
        // Prova
        InputStream ExcelFileToRead = new FileInputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+'/'+CPLib.LRTrim(nomefile));
        XSSFWorkbook  workbook = new XSSFWorkbook(ExcelFileToRead);
        // Workbook workbook = StreamingReader.builder()
        //        .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
        //        .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
        //        .open(is);            // InputStream or File for XLSX file (required)
        Cell cell;
        int cellType;
        String[] colonna = new String[22];
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
        /* If riga_letta > 1 */
        if (CPLib.gt(riga_letta,1)) {
          //scorro le colonne
          cell_count=0;
          /* While cell_count < 22 */
          while (CPLib.lt(cell_count,22)) {
            //scorro le celle della riga
            cell = row.getCell(cell_count);
            if (cell != null) {
                  DataFormatter formatter = new DataFormatter();
                  String strValue = formatter.formatCellValue(cell);
                  colonna[cell_count]=strValue;       
            } else {
              colonna[cell_count]="";
            }
            ++cell_count;
          } // End While
          /* _provres := iif(not(Empty(colonna[20])) and colonna[20] <> '086','EE',colonna[10]) */
          _provres = ( ! (CPLib.Empty(colonna[20])) && CPLib.ne(colonna[20],"086")?"EE":colonna[10]);
          /* If not(Empty(colonna[20])) and mcStati.GoToKey(colonna[20]) */
          if ( ! (CPLib.Empty(colonna[20])) && mcStati.GoToKey(colonna[20])) {
            /* _sotgru := mcStati.FLGSAE */
            _sotgru = mcStati.row.FLGSAE;
          } else { // Else
            /* _sotgru := colonna[9] */
            _sotgru = colonna[9];
          } // End If
          /* _contar := _contar + 1 */
          _contar = CPLib.Round(_contar+1,0);
          /* gMsgImp := 'Aggiorno operazione con progressivo='+ LRTrim(colonna[0]) + " - Riga "+LRTrim(Str(riga_letta,10,0)) // Messaggio Import */
          gMsgImp = "Aggiorno operazione con progressivo="+CPLib.LRTrim(colonna[0])+" - Riga "+CPLib.LRTrim(CPLib.Str(riga_letta,10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Write into analisi_sv from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("analisi_sv");
          m_cPhName = m_Ctx.GetPhName("analisi_sv");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"analisi_sv",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_import_correzioni_sv_wu",72,"00000040")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"SEGNO = "+CPLib.ToSQL(CPLib.LRTrim(colonna[2]),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODDIPE = "+CPLib.ToSQL(CPLib.LRTrim(colonna[3]),"C",6,0,m_cServer)+", ";
          m_cSql = m_cSql+"DESCRIZ = "+CPLib.ToSQL(CPLib.LRTrim(colonna[4]),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROVINCIA1 = "+CPLib.ToSQL(CPLib.LRTrim(colonna[5]),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPOSV = "+CPLib.ToSQL(CPLib.LRTrim(colonna[6]),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(CPLib.LRTrim(colonna[7]),"C",16,0,m_cServer)+", ";
          m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.LRTrim(colonna[8]),"C",70,0,m_cServer)+", ";
          m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.LRTrim(colonna[9]),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.LRTrim(colonna[10]),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(CPLib.LRTrim(colonna[12]),"C",3,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"analisi_sv",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"TIPO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(colonna[13]),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(colonna[13]))+"";
          m_cSql = m_cSql+" and NUMPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(colonna[0]),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(colonna[0]))+"";
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
          /* conta := conta + 1 */
          conta = conta+1;
        } // End If
        // Chiude i cicli
          }
        }
        workbook.close();
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* _cRitorno := 'OK' */
        _cRitorno = "OK";
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* _cRitorno := 'KO' */
        _cRitorno = "KO";
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000002Fstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000002Fstatus,cTry0000002Fmsg);
        }
      }
      /* FileLibMit.DeleteFile('appo/'+LRTrim(gAzienda)+"/"+nomefile) */
      FileLibMit.DeleteFile("appo/"+CPLib.LRTrim(gAzienda)+"/"+nomefile);
      /* gMsgImp := 'Elaborazione terminata!' // Messaggio Import */
      gMsgImp = "Elaborazione terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefile + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefile+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Return _cRitorno */
      throw new Stop(_cRitorno);
    } finally {
      try {
        if (Cursor_tbstati!=null)
          Cursor_tbstati.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_nomefile) {
    nomefile = p_nomefile;
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
  public String Run(String p_nomefile) {
    nomefile = p_nomefile;
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
  public static arfn_import_correzioni_sv_wuR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_import_correzioni_sv_wuR(p_Ctx, p_Caller);
  }
  public static arfn_import_correzioni_sv_wuR Make(CPContext p_Ctx) {
    return new arfn_import_correzioni_sv_wuR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    nomefile = CPLib.Space(30);
    riga_letta = 0;
    foglio = 0;
    cell_type = 0;
    _cRitorno = CPLib.Space(2);
    _contar = 0;
    _sotgru = CPLib.Space(3);
    _provres = CPLib.Space(2);
    mcStati = new MemoryCursor_tbstati();
    column01 = CPLib.Space(100);
    column02 = CPLib.Space(100);
    column03 = CPLib.Space(100);
    column04 = CPLib.Space(100);
    column05 = CPLib.Space(100);
    column06 = CPLib.Space(100);
    column07 = CPLib.Space(100);
    column08 = CPLib.Space(100);
    column09 = CPLib.Space(100);
    column10 = CPLib.Space(100);
    column11 = CPLib.Space(100);
    column12 = CPLib.Space(100);
    column13 = CPLib.Space(100);
    column14 = CPLib.Space(100);
    column15 = CPLib.Space(100);
    column16 = CPLib.Space(100);
    column17 = CPLib.Space(100);
    column18 = CPLib.Space(100);
    column19 = CPLib.Space(100);
    column20 = CPLib.Space(100);
    column21 = CPLib.Space(100);
    column22 = CPLib.Space(100);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gDataVaria=m_Ctx.GetGlobalDate("gDataVaria");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,arfn_import_correzioni_sv_wu,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arfn_import_correzioni_sv_wu,";
  public static String[] m_cRunParameterNames={"nomefile"};
}
