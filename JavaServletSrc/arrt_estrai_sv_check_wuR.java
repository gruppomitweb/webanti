// * --- Area Manuale = BO - Header
// * --- arrt_estrai_sv_check_wu
import java.util.*;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
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
import com.opencsv.*;
import java.util.ArrayList;
// * --- Fine Area Manuale
public class arrt_estrai_sv_check_wuR implements CallerWithObjs {
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
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
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
  public double pAnno;
  public double pTri;
  public String pTipo;
  public String pFile;
  public String _datini;
  public String _datfin;
  public String cRitorno;
  public String fhand;
  public String riga;
  public String nFile;
  public String outFileName;
  public String inFileName;
  public double _conta;
  public double _bottom;
  public double _top;
  public double _max;
  public double _cicli;
  public double _min;
  public double _mono;
  public double _tot;
  public double _reccount;
  public double _contarow;
  public String _tcont;
  public double _importo;
  public String _sotgru;
  public String _paeseres;
  public String _provres;
  public String _provage;
  public MemoryCursor_tbstati mcStati;
  public MemoryCursor_qbe_estrai_sv_ope_chk_wu_vqr mcErrori;
  public MemoryCursor_qbe_estrai_sv_ope_tab_wu_vqr mcDati;
  public String _nfile;
  public String _datope;
  public java.sql.Date _ddatini;
  public java.sql.Date _ddatfin;
  public java.sql.Date _dataoggi;
  public String _cdataoggi;
  public String _oldmsg;
  public String _valuta;
  public String _flgfraud;
  public String gAzienda;
  public String gIntemediario;
  public String gMsgImp;
  public String gMsgProc;
  public String gPathApp;
  public String gPathDoc;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_estrai_sv_check_wu
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
  public arrt_estrai_sv_check_wuR (CPContext p_ContextObject, Caller caller) {
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
                                all'oggetto globale (unico per pi� istanze di una stessa applicazione)
                                per recuperare informazioni sul:
                                1) nome fisico della tabella di gestione;
                                2) nome fisico delle tabelle collegate nei link;
                                3) stringa di connessione.
                                L'azienda � contenuta nel global object.
                             */
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_estrai_sv_check_wu",m_Caller);
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
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pAnno",p_cVarName)) {
      return pAnno;
    }
    if (CPLib.eqr("pTri",p_cVarName)) {
      return pTri;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      return _reccount;
    }
    if (CPLib.eqr("_contarow",p_cVarName)) {
      return _contarow;
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
      return "arrt_estrai_sv_check_wu";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pFile",p_cVarName)) {
      return pFile;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      return _datini;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      return _datfin;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
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
    if (CPLib.eqr("inFileName",p_cVarName)) {
      return inFileName;
    }
    if (CPLib.eqr("_tcont",p_cVarName)) {
      return _tcont;
    }
    if (CPLib.eqr("_sotgru",p_cVarName)) {
      return _sotgru;
    }
    if (CPLib.eqr("_paeseres",p_cVarName)) {
      return _paeseres;
    }
    if (CPLib.eqr("_provres",p_cVarName)) {
      return _provres;
    }
    if (CPLib.eqr("_provage",p_cVarName)) {
      return _provage;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      return _nfile;
    }
    if (CPLib.eqr("_datope",p_cVarName)) {
      return _datope;
    }
    if (CPLib.eqr("_cdataoggi",p_cVarName)) {
      return _cdataoggi;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    if (CPLib.eqr("_valuta",p_cVarName)) {
      return _valuta;
    }
    if (CPLib.eqr("_flgfraud",p_cVarName)) {
      return _flgfraud;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_ddatini",p_cVarName)) {
      return _ddatini;
    }
    if (CPLib.eqr("_ddatfin",p_cVarName)) {
      return _ddatfin;
    }
    if (CPLib.eqr("_dataoggi",p_cVarName)) {
      return _dataoggi;
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
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      return mcErrori;
    }
    if (CPLib.eqr("mcDati",p_cVarName)) {
      return mcDati;
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
    if (CPLib.eqr("pAnno",p_cVarName)) {
      pAnno = value;
      return;
    }
    if (CPLib.eqr("pTri",p_cVarName)) {
      pTri = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
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
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      _mono = value;
      return;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      _reccount = value;
      return;
    }
    if (CPLib.eqr("_contarow",p_cVarName)) {
      _contarow = value;
      return;
    }
    if (CPLib.eqr("_importo",p_cVarName)) {
      _importo = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("pFile",p_cVarName)) {
      pFile = value;
      return;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      _datini = value;
      return;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      _datfin = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
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
    if (CPLib.eqr("inFileName",p_cVarName)) {
      inFileName = value;
      return;
    }
    if (CPLib.eqr("_tcont",p_cVarName)) {
      _tcont = value;
      return;
    }
    if (CPLib.eqr("_sotgru",p_cVarName)) {
      _sotgru = value;
      return;
    }
    if (CPLib.eqr("_paeseres",p_cVarName)) {
      _paeseres = value;
      return;
    }
    if (CPLib.eqr("_provres",p_cVarName)) {
      _provres = value;
      return;
    }
    if (CPLib.eqr("_provage",p_cVarName)) {
      _provage = value;
      return;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      _nfile = value;
      return;
    }
    if (CPLib.eqr("_datope",p_cVarName)) {
      _datope = value;
      return;
    }
    if (CPLib.eqr("_cdataoggi",p_cVarName)) {
      _cdataoggi = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
      return;
    }
    if (CPLib.eqr("_valuta",p_cVarName)) {
      _valuta = value;
      return;
    }
    if (CPLib.eqr("_flgfraud",p_cVarName)) {
      _flgfraud = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
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
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
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
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      mcErrori = (MemoryCursor_qbe_estrai_sv_ope_chk_wu_vqr)value;
      return;
    }
    if (CPLib.eqr("mcDati",p_cVarName)) {
      mcDati = (MemoryCursor_qbe_estrai_sv_ope_tab_wu_vqr)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_Main() throws Exception {
    CPResultSet Cursor_tbstati=null;
    try {
      /* pAnno Numeric(4, 0) // Anno di riferimento */
      /* pTri Numeric(1, 0) // Trimestre */
      /* pTipo Char(1) // Tipo elaborazione */
      /* pFile Char(80) // Nome File Import */
      /* _datini Char(8) // Data Inizio Trimestre */
      /* _datfin Char(8) // Data Fine Trimestre */
      /* cRitorno Char(30) */
      /* fhand Char(1) // Per gestione file */
      /* riga Memo */
      /* nFile Char(20) */
      /* outFileName Char(30) */
      /* inFileName Char(80) */
      /* _conta Numeric(10, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _max Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _tot Numeric(15, 0) */
      /* _reccount Numeric(10, 0) */
      /* _contarow Numeric(15, 0) */
      /* _tcont Char(3) */
      /* _importo Numeric(15, 0) */
      /* _sotgru Char(3) */
      /* _paeseres Char(3) */
      /* _provres Char(2) */
      /* _provage Char(2) */
      /* mcStati MemoryCursor(tbstati) */
      /* mcErrori MemoryCursor(qbe_estrai_sv_ope_chk_wu.vqr) */
      /* mcDati MemoryCursor(qbe_estrai_sv_ope_tab_wu.vqr) */
      /* _nfile Char(120) */
      /* _datope Char(10) */
      /* _ddatini Date */
      /* _ddatfin Date */
      /* _dataoggi Date */
      /* _cdataoggi Char(8) */
      /* _oldmsg Memo */
      /* _valuta Char(1) */
      /* _flgfraud Char(1) */
      /* gAzienda Char(10) // Azienda */
      /* gIntemediario Char(11) // Intermediario */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
      /* Case pTri=1 */
      if (CPLib.eqr(pTri,1)) {
        /* _datini := Str(pAnno,4,0)+'0101' // Data Inizio Trimestre */
        _datini = CPLib.Str(pAnno,4,0)+"0101";
        /* _datfin := Str(pAnno,4,0)+'0331' // Data Fine Trimestre */
        _datfin = CPLib.Str(pAnno,4,0)+"0331";
        /* Case pTri=2 */
      } else if (CPLib.eqr(pTri,2)) {
        /* _datini := Str(pAnno,4,0)+'0401' // Data Inizio Trimestre */
        _datini = CPLib.Str(pAnno,4,0)+"0401";
        /* _datfin := Str(pAnno,4,0)+'0630' // Data Fine Trimestre */
        _datfin = CPLib.Str(pAnno,4,0)+"0630";
        /* Case pTri=3 */
      } else if (CPLib.eqr(pTri,3)) {
        /* _datini := Str(pAnno,4,0)+'0701' // Data Inizio Trimestre */
        _datini = CPLib.Str(pAnno,4,0)+"0701";
        /* _datfin := Str(pAnno,4,0)+'0930' // Data Fine Trimestre */
        _datfin = CPLib.Str(pAnno,4,0)+"0930";
        /* Case pTri=4 */
      } else if (CPLib.eqr(pTri,4)) {
        /* _datini := Str(pAnno,4,0)+'1001' // Data Inizio Trimestre */
        _datini = CPLib.Str(pAnno,4,0)+"1001";
        /* _datfin := Str(pAnno,4,0)+'1231' // Data Fine Trimestre */
        _datfin = CPLib.Str(pAnno,4,0)+"1231";
      } // End Case
      /* _ddatini := CharToDate(_datini) */
      _ddatini = CPLib.CharToDate(_datini);
      /* _ddatfin := CharToDate(_datfin) */
      _ddatfin = CPLib.CharToDate(_datfin);
      /* If pTipo='C' */
      if (CPLib.eqr(pTipo,"C")) {
        /* gMsgProc := 'Ora Inizio Verifica Operazioni per SV: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = "Ora Inizio Verifica Operazioni per SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* outFileName := "CheckSV_"+LRTrim(gIntemediario)+"_"+Str(pAnno,4,0)+"_"+Str(pTri,1,0) */
        outFileName = "CheckSV_"+CPLib.LRTrim(gIntemediario)+"_"+CPLib.Str(pAnno,4,0)+"_"+CPLib.Str(pTri,1,0);
        /* _contarow := 0 */
        _contarow = CPLib.Round(0,0);
        /* Exec "Crea File Excel" Page 4:Excel */
        Excel();
        /* If _contarow = 0 */
        if (CPLib.eqr(_contarow,0)) {
          /* outFileName := '' */
          outFileName = "";
        } // End If
        /* gMsgProc := gMsgProc + 'Ora Fine Verifica Operazioni per SV: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Verifica Operazioni per SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Elaborazione terminata con successo!' // Messaggio Import */
        gMsgImp = "Elaborazione terminata con successo!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* ElseIf pTipo='T' */
      } else if (CPLib.eqr(pTipo,"T")) {
        /* gMsgProc :=  'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
                  info.log("Routine arrt_estrai_sv_check_wu: query on tbstati returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
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
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry0000004Astatus;
        nTry0000004Astatus = m_Sql.GetTransactionStatus();
        String cTry0000004Amsg;
        cTry0000004Amsg = m_Sql.TransactionErrorMessage();
        try {
          /* If pTri=1 or pTri=3 */
          if (CPLib.eqr(pTri,1) || CPLib.eqr(pTri,3)) {
            /* gMsgProc := gMsgProc + 'Ora Inizio Azzeramento Archivio SV: '+ arfn_fdatetime(DateTime()) + NL */
            gMsgProc = gMsgProc+"Ora Inizio Azzeramento Archivio SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            // * --- Delete from analisi_sv
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("analisi_sv");
            m_cPhName = m_Ctx.GetPhName("analisi_sv");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"analisi_sv",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_sv_check_wu",107,"0000004D")+"delete from "+m_oWrInfo.GetTableWriteName();
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
              throw new RoutineException();
            }
            /* gMsgProc := gMsgProc + 'Ora Fine Azzeramento Archivio SV: '+ arfn_fdatetime(DateTime()) + NL */
            gMsgProc = gMsgProc+"Ora Fine Azzeramento Archivio SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* gMsgProc := gMsgProc + 'Ora Inizio Azzeramento Archivio SV: '+ arfn_fdatetime(DateTime()) + NL */
            gMsgProc = gMsgProc+"Ora Inizio Azzeramento Archivio SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            // * --- Delete from analisi_sv
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("analisi_sv");
            m_cPhName = m_Ctx.GetPhName("analisi_sv");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"analisi_sv",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_sv_check_wu",107,"00000050")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"DATAOPE >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatini,"?",0,0,m_cServer),m_cServer,_ddatini)+"";
            m_cSql = m_cSql+" and DATAOPE <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatfin,"?",0,0,m_cServer),m_cServer,_ddatfin)+"";
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
            /* gMsgProc := gMsgProc + 'Ora Fine Azzeramento Archivio SV: '+ arfn_fdatetime(DateTime()) + NL */
            gMsgProc = gMsgProc+"Ora Fine Azzeramento Archivio SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* _contarow := 0 */
          _contarow = CPLib.Round(0,0);
          /* Exec "Operazioni" Page 2:Operazioni */
          Operazioni();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* Exec "Frazionate" Page 3:Frazionate */
          Frazionate();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
          /* gMsgProc := gMsgProc + 'Sono state estratte '+ LRTrim(Str(_contarow,10,0)) + " operazioni/frazionate" + NL */
          gMsgProc = gMsgProc+"Sono state estratte "+CPLib.LRTrim(CPLib.Str(_contarow,10,0))+" operazioni/frazionate"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* outFileName := "OK" */
          outFileName = "OK";
          /* gMsgImp := 'Elaborazione terminata con successo!' // Messaggio Import */
          gMsgImp = "Elaborazione terminata con successo!";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
          /* outFileName := "KO" */
          outFileName = "KO";
          /* gMsgImp := 'Elaborazione terminata con errori!' // Messaggio Import */
          gMsgImp = "Elaborazione terminata con errori!";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000004Astatus,0)) {
            m_Sql.SetTransactionStatus(nTry0000004Astatus,cTry0000004Amsg);
          }
        }
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* ElseIf pTipo='X' */
      } else if (CPLib.eqr(pTipo,"X")) {
        /* gMsgProc := 'Ora Inizio Creazione file copia: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = "Ora Inizio Creazione file copia: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* outFileName := "COPIA_"+LRTrim(gIntemediario)+"_"+Str(pAnno,4,0)+"_"+Str(pTri,1,0)+".txt" */
        outFileName = "COPIA_"+CPLib.LRTrim(gIntemediario)+"_"+CPLib.Str(pAnno,4,0)+"_"+CPLib.Str(pTri,1,0)+".txt";
        /* Exec "Crea File copia TXT" Page 5:CopiaTXT */
        CopiaTXT();
        /* gMsgProc := gMsgProc + 'Sono stati estratti ' +LRTrim(Str(_contarow,10,0))+" record." +NL */
        gMsgProc = gMsgProc+"Sono stati estratti "+CPLib.LRTrim(CPLib.Str(_contarow,10,0))+" record."+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Fine Creazione file copia: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Creazione file copia: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Elaborazione terminata con successo!' // Messaggio Import */
        gMsgImp = "Elaborazione terminata con successo!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* ElseIf pTipo='R' */
      } else if (CPLib.eqr(pTipo,"R")) {
        /* gMsgProc := 'Ora Inizio Restore Tabelle Trimestrale: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = "Ora Inizio Restore Tabelle Trimestrale: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000065status;
        nTry00000065status = m_Sql.GetTransactionStatus();
        String cTry00000065msg;
        cTry00000065msg = m_Sql.TransactionErrorMessage();
        try {
          /* gMsgProc := gMsgProc + 'Ora Inizio Azzeramento Archivio SV: '+ arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Ora Inizio Azzeramento Archivio SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // * --- Delete from analisi_sv
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("analisi_sv");
          m_cPhName = m_Ctx.GetPhName("analisi_sv");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"analisi_sv",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_sv_check_wu",107,"00000067")+"delete from "+m_oWrInfo.GetTableWriteName();
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
            throw new RoutineException();
          }
          /* gMsgProc := gMsgProc + 'Ora Fine Azzeramento Archivio SV: '+ arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Ora Fine Azzeramento Archivio SV: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* _contarow := 0 */
          _contarow = CPLib.Round(0,0);
          /* Exec "Restore copia TXT" Page 6:RestoreTXT */
          RestoreTXT();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
          /* gMsgProc := gMsgProc + 'Sono stati importati ' +LRTrim(Str(_contarow,10,0))+" record." +NL */
          gMsgProc = gMsgProc+"Sono stati importati "+CPLib.LRTrim(CPLib.Str(_contarow,10,0))+" record."+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* outFileName := "OK" */
          outFileName = "OK";
          /* gMsgImp := 'Elaborazione terminata con successo!' // Messaggio Import */
          gMsgImp = "Elaborazione terminata con successo!";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
          /* outFileName := "KO" */
          outFileName = "KO";
          /* gMsgImp := 'Elaborazione terminata con errori!' // Messaggio Import */
          gMsgImp = "Elaborazione terminata con errori!";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000065status,0)) {
            m_Sql.SetTransactionStatus(nTry00000065status,cTry00000065msg);
          }
        }
        /* gMsgProc := gMsgProc + 'Ora Fine Restore Tabella Trimestrale: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Restore Tabella Trimestrale: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* Return outFileName */
      throw new Stop(outFileName);
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
  void Operazioni() throws Exception {
    CPResultSet Cursor_qbe_estrai_sv_ope_tab_wu_minmax=null;
    CPResultSet Cursor_qbe_estrai_sv_ope_tab_wu=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _reccount := 0 */
      _reccount = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file delle operazioni' + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file delle operazioni"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Select from qbe_estrai_sv_ope_tab_wu_minmax
      SPBridge.HMCaller _h00000077;
      _h00000077 = new SPBridge.HMCaller();
      _h00000077.Set("m_cVQRList",m_cVQRList);
      _h00000077.Set("pDADATA",_datini);
      _h00000077.Set("pA_DATA",_datfin);
      if (Cursor_qbe_estrai_sv_ope_tab_wu_minmax!=null)
        Cursor_qbe_estrai_sv_ope_tab_wu_minmax.Close();
      Cursor_qbe_estrai_sv_ope_tab_wu_minmax = new VQRHolder("qbe_estrai_sv_ope_tab_wu_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000077,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_estrai_sv_ope_tab_wu_minmax.Eof())) {
        /* _reccount := qbe_estrai_sv_ope_tab_wu_minmax->TOTOPE */
        _reccount = CPLib.Round(Cursor_qbe_estrai_sv_ope_tab_wu_minmax.GetDouble("TOTOPE"),0);
        Cursor_qbe_estrai_sv_ope_tab_wu_minmax.Next();
      }
      m_cConnectivityError = Cursor_qbe_estrai_sv_ope_tab_wu_minmax.ErrorMessage();
      Cursor_qbe_estrai_sv_ope_tab_wu_minmax.Close();
      // * --- End Select
      /* If _reccount > 0 */
      if (CPLib.gt(_reccount,0)) {
        /* _contarow := 0 */
        _contarow = CPLib.Round(0,0);
        /* _dataoggi := _ddatini */
        _dataoggi = _ddatini;
        /* _cdataoggi := _datini */
        _cdataoggi = _datini;
        /* While _dataoggi <= _ddatfin */
        while (CPLib.le(_dataoggi,_ddatfin)) {
          /* If Empty(_oldmsg) */
          if (CPLib.Empty(_oldmsg)) {
            /* gMsgProc := gMsgProc + 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file operazioni" // Messaggio */
            gMsgProc = gMsgProc+"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file operazioni";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file operazioni") // Messaggio */
            gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file operazioni");
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* _oldmsg := 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file operazioni" */
          _oldmsg = "Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file operazioni";
          // * --- Fill memory cursor mcDati on qbe_estrai_sv_ope_tab_wu
          mcDati.Zap();
          SPBridge.HMCaller _h00000083;
          _h00000083 = new SPBridge.HMCaller();
          _h00000083.Set("m_cVQRList",m_cVQRList);
          _h00000083.Set("pDADATA",_cdataoggi);
          if (Cursor_qbe_estrai_sv_ope_tab_wu!=null)
            Cursor_qbe_estrai_sv_ope_tab_wu.Close();
          Cursor_qbe_estrai_sv_ope_tab_wu = new VQRHolder("qbe_estrai_sv_ope_tab_wu",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000083,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_estrai_sv_ope_tab_wu;
            Cursor_qbe_estrai_sv_ope_tab_wu.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,60000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_estrai_sv_check_wu: query on qbe_estrai_sv_ope_tab_wu returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 60000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_estrai_sv_ope_tab_wu.Eof())) {
            mcDati.AppendBlank();
            mcDati.row.NUMPROG = Cursor_qbe_estrai_sv_ope_tab_wu.GetString("NUMPROG");
            mcDati.row.DATAOPE = Cursor_qbe_estrai_sv_ope_tab_wu.GetDate("DATAOPE");
            mcDati.row.SEGNO = Cursor_qbe_estrai_sv_ope_tab_wu.GetString("SEGNO");
            mcDati.row.CODDIPE = Cursor_qbe_estrai_sv_ope_tab_wu.GetString("CODDIPE");
            mcDati.row.DESCRIZ = Cursor_qbe_estrai_sv_ope_tab_wu.GetString("DESCRIZ");
            mcDati.row.PROVINCIA1 = Cursor_qbe_estrai_sv_ope_tab_wu.GetString("PROVINCIA1");
            mcDati.row.TIPOSV = Cursor_qbe_estrai_sv_ope_tab_wu.GetString("TIPOSV");
            mcDati.row.CONNESCLI = Cursor_qbe_estrai_sv_ope_tab_wu.GetString("CONNESCLI");
            mcDati.row.RAGSOC = Cursor_qbe_estrai_sv_ope_tab_wu.GetString("RAGSOC");
            mcDati.row.SOTGRUP = Cursor_qbe_estrai_sv_ope_tab_wu.GetString("SOTGRUP");
            mcDati.row.PROVINCIA = Cursor_qbe_estrai_sv_ope_tab_wu.GetString("PROVINCIA");
            mcDati.row.PAESE = Cursor_qbe_estrai_sv_ope_tab_wu.GetString("PAESE");
            mcDati.row.IMPOUT = Cursor_qbe_estrai_sv_ope_tab_wu.GetDouble("IMPOUT");
            mcDati.row.TOTLIRE = Cursor_qbe_estrai_sv_ope_tab_wu.GetDouble("TOTLIRE");
            mcDati.row.TOTCONT = Cursor_qbe_estrai_sv_ope_tab_wu.GetDouble("TOTCONT");
            mcDati.row.PAESERES = Cursor_qbe_estrai_sv_ope_tab_wu.GetString("PAESERES");
            mcDati.row.FLAGLIRE = Cursor_qbe_estrai_sv_ope_tab_wu.GetString("FLAGLIRE");
            mcDati.row.TIPO = Cursor_qbe_estrai_sv_ope_tab_wu.GetString("TIPO");
            mcDati.row.FLAGFRAUD = Cursor_qbe_estrai_sv_ope_tab_wu.GetDouble("FLAGFRAUD");
            Cursor_qbe_estrai_sv_ope_tab_wu.Next();
          }
          m_cConnectivityError = Cursor_qbe_estrai_sv_ope_tab_wu.ErrorMessage();
          Cursor_qbe_estrai_sv_ope_tab_wu.Close();
          mcDati.GoTop();
          for (MemoryCursorRow_qbe_estrai_sv_ope_tab_wu_vqr rowDati : mcDati._iterable_()) {
            /* gMsgImp := "Sto elaborando l'operazione con progressivo: " + rowDati.NUMPROG // Messaggio Import */
            gMsgImp = "Sto elaborando l'operazione con progressivo: "+rowDati.NUMPROG;
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* Case rowDati.PAESE='030' */
            if (CPLib.eqr(rowDati.PAESE,"030")) {
              /* _paeseres := '240' */
              _paeseres = "240";
              /* Case rowDati.PAESE='043' or rowDati.PAESE='291' */
            } else if (CPLib.eqr(rowDati.PAESE,"043") || CPLib.eqr(rowDati.PAESE,"291")) {
              /* _paeseres := '289' */
              _paeseres = "289";
              /* Case rowDati.PAESE='251' */
            } else if (CPLib.eqr(rowDati.PAESE,"251")) {
              /* _paeseres := '050' */
              _paeseres = "050";
            } else { // Otherwise
              /* _paeseres := rowDati.PAESE */
              _paeseres = rowDati.PAESE;
            } // End Case
            /* Case rowDati.PROVINCIA='FO' */
            if (CPLib.eqr(rowDati.PROVINCIA,"FO")) {
              /* _provres := 'FC' */
              _provres = "FC";
              /* Case rowDati.PROVINCIA='PS' */
            } else if (CPLib.eqr(rowDati.PROVINCIA,"PS")) {
              /* _provres := 'PU' */
              _provres = "PU";
              /* Case not(Empty(rowDati.PAESERES)) and rowDati.PAESERES <> '086' */
            } else if ( ! (CPLib.Empty(rowDati.PAESERES)) && CPLib.ne(rowDati.PAESERES,"086")) {
              /* _provres := 'EE' */
              _provres = "EE";
            } else { // Otherwise
              /* _provres := rowDati.PROVINCIA */
              _provres = rowDati.PROVINCIA;
            } // End Case
            /* Case rowDati.PROVINCIA1='FO' */
            if (CPLib.eqr(rowDati.PROVINCIA1,"FO")) {
              /* _provage := 'FC' */
              _provage = "FC";
              /* Case rowDati.PROVINCIA1='PS' */
            } else if (CPLib.eqr(rowDati.PROVINCIA1,"PS")) {
              /* _provage := 'PU' */
              _provage = "PU";
            } else { // Otherwise
              /* _provage := rowDati.PROVINCIA1 */
              _provage = rowDati.PROVINCIA1;
            } // End Case
            /* If not(Empty(rowDati.PAESERES)) and mcStati.GoToKey(rowDati.PAESERES) */
            if ( ! (CPLib.Empty(rowDati.PAESERES)) && mcStati.GoToKey(rowDati.PAESERES)) {
              /* _sotgru := mcStati.FLGSAE */
              _sotgru = mcStati.row.FLGSAE;
            } else { // Else
              /* _sotgru := rowDati.SOTGRUP */
              _sotgru = rowDati.SOTGRUP;
            } // End If
            /* If not(Empty(rowDati.PAESERES)) and mcStati.GoToKey(rowDati.PAESERES) */
            if ( ! (CPLib.Empty(rowDati.PAESERES)) && mcStati.GoToKey(rowDati.PAESERES)) {
              /* _sotgru := mcStati.FLGSAE */
              _sotgru = mcStati.row.FLGSAE;
            } else { // Else
              /* _sotgru := rowDati.SOTGRUP */
              _sotgru = rowDati.SOTGRUP;
            } // End If
            /* _contarow := _contarow + 1 */
            _contarow = CPLib.Round(_contarow+1,0);
            /* _tcont := iif(rowDati.TOTLIRE=rowDati.TOTCONT,'351','352') */
            _tcont = (CPLib.eqr(rowDati.TOTLIRE,rowDati.TOTCONT)?"351":"352");
            /* If _tcont='352' */
            if (CPLib.eqr(_tcont,"352")) {
              /* _importo := iif(rowDati.TOTCONT=0,rowDati.TOTLIRE,rowDati.TOTLIRE - rowDati.TOTCONT) */
              _importo = CPLib.Round((CPLib.eqr(rowDati.TOTCONT,0)?rowDati.TOTLIRE:rowDati.TOTLIRE-rowDati.TOTCONT),0);
            } else { // Else
              /* _importo := rowDati.TOTCONT */
              _importo = CPLib.Round(rowDati.TOTCONT,0);
            } // End If
            /* _valuta := iif(At(rowDati.FLAGLIRE,'|E|3|5') > 0 or Empty(rowDati.FLAGLIRE), '1','2') */
            _valuta = (CPLib.gt(CPLib.At(rowDati.FLAGLIRE,"|E|3|5"),0) || CPLib.Empty(rowDati.FLAGLIRE)?"1":"2");
            /* _flgfraud := iif ((Empty(rowDati.FLAGFRAUD) or rowDati.FLAGFRAUD=0),'N','S') */
            _flgfraud = ((CPLib.Empty(rowDati.FLAGFRAUD) || CPLib.eqr(rowDati.FLAGFRAUD,0))?"N":"S");
            // * --- Insert into analisi_sv from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("analisi_sv");
            m_cPhName = m_Ctx.GetPhName("analisi_sv");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"analisi_sv",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_sv_check_wu",107,"000000A1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000A1(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.DESCRIZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_provage,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.TIPOSV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_sotgru,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_provres,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_paeseres,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tcont,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_contarow,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_valuta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_flgfraud,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"analisi_sv",true);
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
          /* _dataoggi := arfn_datesum(_dataoggi,1) */
          _dataoggi = arfn_datesumR.Make(m_Ctx,this).Run(_dataoggi,1);
          /* _cdataoggi := DateToChar(_dataoggi) */
          _cdataoggi = CPLib.DateToChar(_dataoggi);
        } // End While
        /* gMsgProc := NL + gMsgProc + 'Sono state estratte '+ LRTrim(Str(_contarow,10,0)) + " operazioni" + NL */
        gMsgProc = "\n"+gMsgProc+"Sono state estratte "+CPLib.LRTrim(CPLib.Str(_contarow,10,0))+" operazioni"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc + 'Non ci sono operazioni da elaborare per il periodo.' + NL */
        gMsgProc = gMsgProc+"Non ci sono operazioni da elaborare per il periodo."+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file delle operazioni' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file delle operazioni"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_estrai_sv_ope_tab_wu_minmax!=null)
          Cursor_qbe_estrai_sv_ope_tab_wu_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_sv_ope_tab_wu!=null)
          Cursor_qbe_estrai_sv_ope_tab_wu.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Frazionate() throws Exception {
    CPResultSet Cursor_qbe_estrai_sv_frz_tab_wu_minmax=null;
    CPResultSet Cursor_qbe_estrai_sv_frz_tab_wu=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _reccount := 0 */
      _reccount = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file delle frazionate' + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file delle frazionate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Select from qbe_estrai_sv_frz_tab_wu_minmax
      SPBridge.HMCaller _h000000AA;
      _h000000AA = new SPBridge.HMCaller();
      _h000000AA.Set("m_cVQRList",m_cVQRList);
      _h000000AA.Set("pDADATA",_datini);
      _h000000AA.Set("pA_DATA",_datfin);
      if (Cursor_qbe_estrai_sv_frz_tab_wu_minmax!=null)
        Cursor_qbe_estrai_sv_frz_tab_wu_minmax.Close();
      Cursor_qbe_estrai_sv_frz_tab_wu_minmax = new VQRHolder("qbe_estrai_sv_frz_tab_wu_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000AA,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_estrai_sv_frz_tab_wu_minmax.Eof())) {
        /* _reccount := qbe_estrai_sv_frz_tab_wu_minmax->TOTOPE */
        _reccount = CPLib.Round(Cursor_qbe_estrai_sv_frz_tab_wu_minmax.GetDouble("TOTOPE"),0);
        Cursor_qbe_estrai_sv_frz_tab_wu_minmax.Next();
      }
      m_cConnectivityError = Cursor_qbe_estrai_sv_frz_tab_wu_minmax.ErrorMessage();
      Cursor_qbe_estrai_sv_frz_tab_wu_minmax.Close();
      // * --- End Select
      /* If _reccount > 0 */
      if (CPLib.gt(_reccount,0)) {
        /* _contarow := 0 */
        _contarow = CPLib.Round(0,0);
        /* _dataoggi := _ddatini */
        _dataoggi = _ddatini;
        /* _cdataoggi := _datini */
        _cdataoggi = _datini;
        /* While _dataoggi <= _ddatfin */
        while (CPLib.le(_dataoggi,_ddatfin)) {
          /* If Empty(_oldmsg) */
          if (CPLib.Empty(_oldmsg)) {
            /* gMsgProc := gMsgProc + 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file frazionate" // Messaggio */
            gMsgProc = gMsgProc+"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file frazionate";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file frazionate") // Messaggio */
            gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file frazionate");
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* _oldmsg := 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file frazionate" */
          _oldmsg = "Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file frazionate";
          // * --- Fill memory cursor mcDati on qbe_estrai_sv_frz_tab_wu
          mcDati.Zap();
          SPBridge.HMCaller _h000000B6;
          _h000000B6 = new SPBridge.HMCaller();
          _h000000B6.Set("m_cVQRList",m_cVQRList);
          _h000000B6.Set("pDADATA",_cdataoggi);
          if (Cursor_qbe_estrai_sv_frz_tab_wu!=null)
            Cursor_qbe_estrai_sv_frz_tab_wu.Close();
          Cursor_qbe_estrai_sv_frz_tab_wu = new VQRHolder("qbe_estrai_sv_frz_tab_wu",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000B6,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_estrai_sv_frz_tab_wu;
            Cursor_qbe_estrai_sv_frz_tab_wu.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,60000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_estrai_sv_check_wu: query on qbe_estrai_sv_frz_tab_wu returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 60000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_estrai_sv_frz_tab_wu.Eof())) {
            mcDati.AppendBlank();
            mcDati.row.NUMPROG = Cursor_qbe_estrai_sv_frz_tab_wu.GetString("NUMPROG");
            mcDati.row.DATAOPE = Cursor_qbe_estrai_sv_frz_tab_wu.GetDate("DATAOPE");
            mcDati.row.SEGNO = Cursor_qbe_estrai_sv_frz_tab_wu.GetString("SEGNO");
            mcDati.row.CODDIPE = Cursor_qbe_estrai_sv_frz_tab_wu.GetString("CODDIPE");
            mcDati.row.DESCRIZ = Cursor_qbe_estrai_sv_frz_tab_wu.GetString("DESCRIZ");
            mcDati.row.PROVINCIA1 = Cursor_qbe_estrai_sv_frz_tab_wu.GetString("PROVINCIA1");
            mcDati.row.TIPOSV = Cursor_qbe_estrai_sv_frz_tab_wu.GetString("TIPOSV");
            mcDati.row.CONNESCLI = Cursor_qbe_estrai_sv_frz_tab_wu.GetString("CONNESCLI");
            mcDati.row.RAGSOC = Cursor_qbe_estrai_sv_frz_tab_wu.GetString("RAGSOC");
            mcDati.row.SOTGRUP = Cursor_qbe_estrai_sv_frz_tab_wu.GetString("SOTGRUP");
            mcDati.row.PROVINCIA = Cursor_qbe_estrai_sv_frz_tab_wu.GetString("PROVINCIA");
            mcDati.row.PAESE = Cursor_qbe_estrai_sv_frz_tab_wu.GetString("PAESE");
            mcDati.row.IMPOUT = Cursor_qbe_estrai_sv_frz_tab_wu.GetDouble("IMPOUT");
            mcDati.row.TOTLIRE = Cursor_qbe_estrai_sv_frz_tab_wu.GetDouble("TOTLIRE");
            mcDati.row.TOTCONT = Cursor_qbe_estrai_sv_frz_tab_wu.GetDouble("TOTCONT");
            mcDati.row.PAESERES = Cursor_qbe_estrai_sv_frz_tab_wu.GetString("PAESERES");
            mcDati.row.FLAGLIRE = Cursor_qbe_estrai_sv_frz_tab_wu.GetString("FLAGLIRE");
            mcDati.row.TIPO = Cursor_qbe_estrai_sv_frz_tab_wu.GetString("TIPO");
            mcDati.row.FLAGFRAUD = Cursor_qbe_estrai_sv_frz_tab_wu.GetDouble("FLAGFRAUD");
            Cursor_qbe_estrai_sv_frz_tab_wu.Next();
          }
          m_cConnectivityError = Cursor_qbe_estrai_sv_frz_tab_wu.ErrorMessage();
          Cursor_qbe_estrai_sv_frz_tab_wu.Close();
          mcDati.GoTop();
          for (MemoryCursorRow_qbe_estrai_sv_ope_tab_wu_vqr rowDati : mcDati._iterable_()) {
            /* gMsgImp := "Sto elaborando l'operazione con progressivo: " + rowDati.NUMPROG // Messaggio Import */
            gMsgImp = "Sto elaborando l'operazione con progressivo: "+rowDati.NUMPROG;
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* Case rowDati.PAESE='030' */
            if (CPLib.eqr(rowDati.PAESE,"030")) {
              /* _paeseres := '240' */
              _paeseres = "240";
              /* Case rowDati.PAESE='043' or rowDati.PAESE='291' */
            } else if (CPLib.eqr(rowDati.PAESE,"043") || CPLib.eqr(rowDati.PAESE,"291")) {
              /* _paeseres := '289' */
              _paeseres = "289";
              /* Case rowDati.PAESE='251' */
            } else if (CPLib.eqr(rowDati.PAESE,"251")) {
              /* _paeseres := '050' */
              _paeseres = "050";
            } else { // Otherwise
              /* _paeseres := rowDati.PAESE */
              _paeseres = rowDati.PAESE;
            } // End Case
            /* Case rowDati.PROVINCIA='FO' */
            if (CPLib.eqr(rowDati.PROVINCIA,"FO")) {
              /* _provres := 'FC' */
              _provres = "FC";
              /* Case rowDati.PROVINCIA='PS' */
            } else if (CPLib.eqr(rowDati.PROVINCIA,"PS")) {
              /* _provres := 'PU' */
              _provres = "PU";
              /* Case not(Empty(rowDati.PAESERES)) and rowDati.PAESERES <> '086' */
            } else if ( ! (CPLib.Empty(rowDati.PAESERES)) && CPLib.ne(rowDati.PAESERES,"086")) {
              /* _provres := 'EE' */
              _provres = "EE";
            } else { // Otherwise
              /* _provres := rowDati.PROVINCIA */
              _provres = rowDati.PROVINCIA;
            } // End Case
            /* Case rowDati.PROVINCIA1='FO' */
            if (CPLib.eqr(rowDati.PROVINCIA1,"FO")) {
              /* _provage := 'FC' */
              _provage = "FC";
              /* Case rowDati.PROVINCIA1='PS' */
            } else if (CPLib.eqr(rowDati.PROVINCIA1,"PS")) {
              /* _provage := 'PU' */
              _provage = "PU";
            } else { // Otherwise
              /* _provage := rowDati.PROVINCIA1 */
              _provage = rowDati.PROVINCIA1;
            } // End Case
            /* If not(Empty(rowDati.PAESERES)) and mcStati.GoToKey(rowDati.PAESERES) */
            if ( ! (CPLib.Empty(rowDati.PAESERES)) && mcStati.GoToKey(rowDati.PAESERES)) {
              /* _sotgru := mcStati.FLGSAE */
              _sotgru = mcStati.row.FLGSAE;
            } else { // Else
              /* _sotgru := rowDati.SOTGRUP */
              _sotgru = rowDati.SOTGRUP;
            } // End If
            /* _contarow := _contarow + 1 */
            _contarow = CPLib.Round(_contarow+1,0);
            /* _tcont := iif(rowDati.TOTLIRE=rowDati.TOTCONT,'351','352') */
            _tcont = (CPLib.eqr(rowDati.TOTLIRE,rowDati.TOTCONT)?"351":"352");
            /* If _tcont='352' */
            if (CPLib.eqr(_tcont,"352")) {
              /* _importo := iif(rowDati.TOTCONT=0,rowDati.TOTLIRE,rowDati.TOTLIRE - rowDati.TOTCONT) */
              _importo = CPLib.Round((CPLib.eqr(rowDati.TOTCONT,0)?rowDati.TOTLIRE:rowDati.TOTLIRE-rowDati.TOTCONT),0);
            } else { // Else
              /* _importo := rowDati.TOTCONT */
              _importo = CPLib.Round(rowDati.TOTCONT,0);
            } // End If
            /* _valuta := iif(At(rowDati.FLAGLIRE,'|E|3|5') > 0 or Empty(rowDati.FLAGLIRE), '1','2') */
            _valuta = (CPLib.gt(CPLib.At(rowDati.FLAGLIRE,"|E|3|5"),0) || CPLib.Empty(rowDati.FLAGLIRE)?"1":"2");
            /* _flgfraud := iif ((Empty(rowDati.FLAGFRAUD) or rowDati.FLAGFRAUD=0),'N','S') */
            _flgfraud = ((CPLib.Empty(rowDati.FLAGFRAUD) || CPLib.eqr(rowDati.FLAGFRAUD,0))?"N":"S");
            // * --- Insert into analisi_sv from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("analisi_sv");
            m_cPhName = m_Ctx.GetPhName("analisi_sv");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"analisi_sv",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_sv_check_wu",107,"000000D1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000D1(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.DESCRIZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_provage,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.TIPOSV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDati.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_sotgru,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_provres,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_paeseres,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tcont,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_contarow,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_valuta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_flgfraud,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"analisi_sv",true);
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
          /* _dataoggi := arfn_datesum(_dataoggi,1) */
          _dataoggi = arfn_datesumR.Make(m_Ctx,this).Run(_dataoggi,1);
          /* _cdataoggi := DateToChar(_dataoggi) */
          _cdataoggi = CPLib.DateToChar(_dataoggi);
        } // End While
        /* gMsgProc := NL + gMsgProc + 'Sono state estratte '+ LRTrim(Str(_contarow,10,0)) + " frazionate" + NL */
        gMsgProc = "\n"+gMsgProc+"Sono state estratte "+CPLib.LRTrim(CPLib.Str(_contarow,10,0))+" frazionate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc + 'Non ci sono frazionate da elaborare per il periodo.' + NL */
        gMsgProc = gMsgProc+"Non ci sono frazionate da elaborare per il periodo."+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file delle frazionate' + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file delle frazionate"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_estrai_sv_frz_tab_wu_minmax!=null)
          Cursor_qbe_estrai_sv_frz_tab_wu_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_sv_frz_tab_wu!=null)
          Cursor_qbe_estrai_sv_frz_tab_wu.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Excel() throws Exception {
    CPResultSet Cursor_qbe_estrai_sv_ope_chk_wu=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* gMsgProc := gMsgProc + 'Esame operazioni...' + NL */
      gMsgProc = gMsgProc+"Esame operazioni..."+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Fill memory cursor mcErrori on qbe_estrai_sv_ope_chk_wu
      mcErrori.Zap();
      if (Cursor_qbe_estrai_sv_ope_chk_wu!=null)
        Cursor_qbe_estrai_sv_ope_chk_wu.Close();
      Cursor_qbe_estrai_sv_ope_chk_wu = new VQRHolder("qbe_estrai_sv_ope_chk_wu",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      {
        final CPResultSet m_TheCursor = Cursor_qbe_estrai_sv_ope_chk_wu;
        Cursor_qbe_estrai_sv_ope_chk_wu.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_estrai_sv_check_wu: query on qbe_estrai_sv_ope_chk_wu returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_qbe_estrai_sv_ope_chk_wu.Eof())) {
        mcErrori.AppendBlank();
        mcErrori.row.TIPO = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("TIPO");
        mcErrori.row.NUMPROG = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("NUMPROG");
        mcErrori.row.DATAOPE = Cursor_qbe_estrai_sv_ope_chk_wu.GetDate("DATAOPE");
        mcErrori.row.SEGNO = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("SEGNO");
        mcErrori.row.CODDIPE = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("CODDIPE");
        mcErrori.row.DESCRIZ = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("DESCRIZ");
        mcErrori.row.PROVINCIA1 = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("PROVINCIA1");
        mcErrori.row.TIPOSV = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("TIPOSV");
        mcErrori.row.CONNESCLI = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("CONNESCLI");
        mcErrori.row.RAGSOC = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("RAGSOC");
        mcErrori.row.SOTGRUP = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("SOTGRUP");
        mcErrori.row.PROVINCIA = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("PROVINCIA");
        mcErrori.row.PAESE = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("PAESE");
        mcErrori.row.IMPOUT = Cursor_qbe_estrai_sv_ope_chk_wu.GetDouble("IMPOUT");
        mcErrori.row.CODFISC = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("CODFISC");
        mcErrori.row.DESCCIT = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("DESCCIT");
        mcErrori.row.NASCOMUN = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("NASCOMUN");
        mcErrori.row.NASSTATO = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("NASSTATO");
        mcErrori.row.TIPINTER = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("TIPINTER");
        mcErrori.row.CITAGE = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("CITAGE");
        mcErrori.row.PAESERES = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("PAESERES");
        mcErrori.row.MTCN = Cursor_qbe_estrai_sv_ope_chk_wu.GetString("MTCN");
        Cursor_qbe_estrai_sv_ope_chk_wu.Next();
      }
      m_cConnectivityError = Cursor_qbe_estrai_sv_ope_chk_wu.ErrorMessage();
      Cursor_qbe_estrai_sv_ope_chk_wu.Close();
      mcErrori.GoTop();
      /* If mcErrori.RecCount() > 0 */
      if (CPLib.gt(mcErrori.RecCount(),0)) {
        /* gMsgProc := gMsgProc + 'Ora Inizio Creazione File Excel: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Inizio Creazione File Excel: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* _nfile := LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+"/"+LRTrim(outFileName)+".xlsx" */
        _nfile = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(outFileName)+".xlsx";
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
        cell.setCellValue("N. Operazione");
        cell.setCellStyle(cs);
        cell =  row.createCell(1);
        cell.setCellValue("Data Operazione");
        cell.setCellStyle(cs);
        cell = row.createCell(2);
        cell.setCellValue("Segno");
        cell.setCellStyle(cs);
        cell = row.createCell(3);
        cell.setCellValue("Codice AGENZIA");
        cell.setCellStyle(cs);
        cell =  row.createCell(4);
        cell.setCellValue("Nome AGENZIA");
        cell.setCellStyle(cs);
        cell =  row.createCell(5);
        cell.setCellValue("Prov. Agenzia'");
        cell.setCellStyle(cs);
        cell =  row.createCell(6);
        cell.setCellValue("Canale Distributivo AGENZIA");
        cell.setCellStyle(cs);
        cell =  row.createCell(7);
        cell.setCellValue("NDG CLIENTE");
        cell.setCellStyle(cs);
        cell =  row.createCell(8);
        cell.setCellValue("Nominativo CLIENTE");
        cell.setCellStyle(cs);
        cell = row.createCell(9);
        cell.setCellValue("Settore CLIENTE");
        cell.setCellStyle(cs);
        cell = row.createCell(10);
        cell.setCellValue("Provincia CLIENTE");
        cell.setCellStyle(cs);
        cell = row.createCell(11);
        cell.setCellValue("Importo Netto");
        cell.setCellStyle(cs);
        cell = row.createCell(12);
        cell.setCellValue("Stato Destinazione");
        cell.setCellStyle(cs);
        cell = row.createCell(13);
        cell.setCellValue("Tipo Operazione");
        cell.setCellStyle(cs);
        cell = row.createCell(14);
        cell.setCellValue("Codice Fiscale");
        cell.setCellStyle(cs);
        cell = row.createCell(15);
        cell.setCellValue("Comune di nascita");
        cell.setCellStyle(cs);
        cell = row.createCell(16);
        cell.setCellValue("Stato di Nascita");
        cell.setCellStyle(cs);
        cell = row.createCell(17);
        cell.setCellValue("Provincia di Nascita");
        cell.setCellStyle(cs);
        cell = row.createCell(18);
        cell.setCellValue("Citt� di Residenza");
        cell.setCellStyle(cs);
        cell = row.createCell(19);
        cell.setCellValue("Citt� Agenzia");
        cell.setCellStyle(cs);
        cell = row.createCell(20);
        cell.setCellValue("Paese Residenza Cliente");
        cell.setCellStyle(cs);
        cell = row.createCell(21);
        cell.setCellValue("MTCN");
        cell.setCellStyle(cs);
        r=r+1;
        for (MemoryCursorRow_qbe_estrai_sv_ope_chk_wu_vqr rowErrori : mcErrori._iterable_()) {
          /* _contarow := _contarow + 1 */
          _contarow = CPLib.Round(_contarow+1,0);
          /* _datope := arfn_fdate(rowErrori.DATAOPE) */
          _datope = arfn_fdateR.Make(m_Ctx,this).Run(rowErrori.DATAOPE);
          //Creo il record da scrivere
          row = sheet.createRow(r);
          cell = row.createCell(0);
          cell.setCellValue(CPLib.LRTrim(rowErrori.NUMPROG));
          cell = row.createCell(1);
          cell.setCellValue(_datope);
          cell = row.createCell(2);
          cell.setCellValue(CPLib.LRTrim(rowErrori.SEGNO));
          cell = row.createCell(3);
          cell.setCellValue(CPLib.LRTrim(rowErrori.CODDIPE));
          cell = row.createCell(4);
          cell.setCellValue(CPLib.LRTrim(rowErrori.DESCRIZ));
          cell = row.createCell(5);
          cell.setCellValue(CPLib.LRTrim(rowErrori.PROVINCIA1));
          cell = row.createCell(6);
          cell.setCellValue(CPLib.LRTrim(rowErrori.TIPOSV));
          cell = row.createCell(7);
          cell.setCellValue(CPLib.LRTrim(rowErrori.CONNESCLI));
          cell = row.createCell(8);
          cell.setCellValue(CPLib.LRTrim(rowErrori.RAGSOC));
          cell = row.createCell(9);
          cell.setCellValue(CPLib.LRTrim(rowErrori.SOTGRUP));
          cell = row.createCell(10);
          cell.setCellValue(CPLib.LRTrim(rowErrori.PROVINCIA));
          cell = row.createCell(11);
          cell.setCellValue(rowErrori.IMPOUT);
          cell = row.createCell(12);
          cell.setCellValue(CPLib.LRTrim(rowErrori.PAESE));
          cell = row.createCell(13);
          cell.setCellValue(CPLib.LRTrim(rowErrori.TIPO));
          cell = row.createCell(14);
          cell.setCellValue(CPLib.LRTrim(rowErrori.CODFISC));
          cell = row.createCell(15);
          cell.setCellValue(CPLib.LRTrim(rowErrori.NASCOMUN));
          cell = row.createCell(16);
          cell.setCellValue(CPLib.LRTrim(rowErrori.NASSTATO));
          cell = row.createCell(17);
          cell.setCellValue(CPLib.LRTrim(rowErrori.TIPINTER));
          cell = row.createCell(18);
          cell.setCellValue(CPLib.LRTrim(rowErrori.DESCCIT));
          cell = row.createCell(19);
          cell.setCellValue(CPLib.LRTrim(rowErrori.CITAGE));
          cell = row.createCell(20);
          cell.setCellValue(CPLib.LRTrim(rowErrori.PAESERES));
          cell = row.createCell(21);
          cell.setCellValue(CPLib.LRTrim(rowErrori.MTCN));
          r=r+1;
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
        // scrivo il file di esito
        FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(_nfile));
        
        //write this workbook to an Outputstream.
        wb.write(fileOut);
        fileOut.flush();
        fileOut.close();
        /* gMsgProc := gMsgProc + 'Ora Fine Creazione File Excel: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Creazione File Excel: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Sono stati rilevati ' +LRTrim(Str(_contarow,10,0))+" errori." +NL */
        gMsgProc = gMsgProc+"Sono stati rilevati "+CPLib.LRTrim(CPLib.Str(_contarow,10,0))+" errori."+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
    } finally {
      try {
        if (Cursor_qbe_estrai_sv_ope_chk_wu!=null)
          Cursor_qbe_estrai_sv_ope_chk_wu.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void CopiaTXT() throws Exception {
    CPResultSet Cursor_qbe_estrai_copia_sv_wu_minmax=null;
    CPResultSet Cursor_qbe_estrai_copia_sv_wu=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_estrai_copia_sv_wu_minmax
      if (Cursor_qbe_estrai_copia_sv_wu_minmax!=null)
        Cursor_qbe_estrai_copia_sv_wu_minmax.Close();
      Cursor_qbe_estrai_copia_sv_wu_minmax = new VQRHolder("qbe_estrai_copia_sv_wu_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_estrai_copia_sv_wu_minmax.Eof())) {
        /* _min := qbe_estrai_copia_sv_wu_minmax->MINSV */
        _min = CPLib.Round(Cursor_qbe_estrai_copia_sv_wu_minmax.GetDouble("MINSV"),0);
        /* _max := qbe_estrai_copia_sv_wu_minmax->MAXSV */
        _max = CPLib.Round(Cursor_qbe_estrai_copia_sv_wu_minmax.GetDouble("MAXSV"),0);
        /* _tot := qbe_estrai_copia_sv_wu_minmax->TOTSV */
        _tot = CPLib.Round(Cursor_qbe_estrai_copia_sv_wu_minmax.GetDouble("TOTSV"),0);
        Cursor_qbe_estrai_copia_sv_wu_minmax.Next();
      }
      m_cConnectivityError = Cursor_qbe_estrai_copia_sv_wu_minmax.ErrorMessage();
      Cursor_qbe_estrai_copia_sv_wu_minmax.Close();
      // * --- End Select
      /* _mono := iif(_tot > 5000,0,1) */
      _mono = CPLib.Round((CPLib.gt(_tot,5000)?0:1),0);
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
        /* _reccount := _max - _min */
        _reccount = CPLib.Round(_max-_min,0);
        /* _cicli := iif(Mod(_reccount,5000) <> 0,Int(_reccount/5000) + 1,Int(_reccount/5000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,5000),0)?CPLib.Int(_reccount/5000)+1:CPLib.Int(_reccount/5000)),0);
      } // End If
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+"/flussi/"+LRTrim(gAzienda)+"/"+outFileName) // Per gestione file */
      fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+outFileName);
      /* _contarow := 0 */
      _contarow = CPLib.Round(0,0);
      /* While _conta <= _cicli */
      while (CPLib.le(_conta,_cicli)) {
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
          /* _bottom := _min */
          _bottom = CPLib.Round(_min,0);
          /* _top := _max */
          _top = CPLib.Round(_max,0);
        } else { // Else
          /* If _conta=1 */
          if (CPLib.eqr(_conta,1)) {
            /* _bottom := _min */
            _bottom = CPLib.Round(_min,0);
            /* _top := _min + 4999 */
            _top = CPLib.Round(_min+4999,0);
            /* ElseIf _conta = _cicli */
          } else if (CPLib.eqr(_conta,_cicli)) {
            /* _bottom := _top + 1 */
            _bottom = CPLib.Round(_top+1,0);
            /* _top := _max */
            _top = CPLib.Round(_max,0);
          } else { // Else
            /* _bottom := _top + 1 */
            _bottom = CPLib.Round(_top+1,0);
            /* _top := _bottom + 4999 */
            _top = CPLib.Round(_bottom+4999,0);
          } // End If
        } // End If
        /* gMsgImp := 'Sto eseguendo il ciclo n. '+LRTrim(Str(_conta,10,0))+" su "+LRTrim(Str(_cicli,10,0)) // Messaggio Import */
        gMsgImp = "Sto eseguendo il ciclo n. "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_estrai_copia_sv_wu
          SPBridge.HMCaller _h0000010A;
          _h0000010A = new SPBridge.HMCaller();
          _h0000010A.Set("m_cVQRList",m_cVQRList);
          _h0000010A.Set("_bottom",_bottom);
          _h0000010A.Set("_top",_top);
          if (Cursor_qbe_estrai_copia_sv_wu!=null)
            Cursor_qbe_estrai_copia_sv_wu.Close();
          Cursor_qbe_estrai_copia_sv_wu = new VQRHolder("qbe_estrai_copia_sv_wu",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000010A,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_estrai_copia_sv_wu.Eof())) {
            /* _contarow := _contarow + 1 */
            _contarow = CPLib.Round(_contarow+1,0);
            /* gMsgImp := "Sto elaborando l'operazione con progressivo: " + qbe_estrai_copia_sv_wu->NUMPROG // Messaggio Import */
            gMsgImp = "Sto elaborando l'operazione con progressivo: "+Cursor_qbe_estrai_copia_sv_wu.GetString("NUMPROG");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* riga := qbe_estrai_copia_sv_wu->TIPO */
            riga = Cursor_qbe_estrai_copia_sv_wu.GetString("TIPO");
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_copia_sv_wu->NUMPROG,11) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_copia_sv_wu.GetString("NUMPROG"),11);
            /* riga := riga +arfn_fdate(qbe_estrai_copia_sv_wu->DATAOPE) */
            riga = riga+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_estrai_copia_sv_wu.GetDate("DATAOPE"));
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_copia_sv_wu->SEGNO,1) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_copia_sv_wu.GetString("SEGNO"),1);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_copia_sv_wu->CODDIPE,6) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_copia_sv_wu.GetString("CODDIPE"),6);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_copia_sv_wu->DESCRIZ,30) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_copia_sv_wu.GetString("DESCRIZ"),30);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_copia_sv_wu->PROVINCIA1,2) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_copia_sv_wu.GetString("PROVINCIA1"),2);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_copia_sv_wu->TIPOSV,3) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_copia_sv_wu.GetString("TIPOSV"),3);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_copia_sv_wu->CONNESCLI,16) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_copia_sv_wu.GetString("CONNESCLI"),16);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_copia_sv_wu->RAGSOC,70) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_copia_sv_wu.GetString("RAGSOC"),70);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_copia_sv_wu->SOTGRUP,3) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_copia_sv_wu.GetString("SOTGRUP"),3);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_copia_sv_wu->PROVINCIA,2) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_copia_sv_wu.GetString("PROVINCIA"),2);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_copia_sv_wu->PAESE,3) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_copia_sv_wu.GetString("PAESE"),3);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_copia_sv_wu->TIPOCONT,3) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_copia_sv_wu.GetString("TIPOCONT"),3);
            /* riga := riga + Right('000000000000000000'+LRTrim(Str(qbe_estrai_copia_sv_wu->IMPOUT,18,0)),18) */
            riga = riga+CPLib.Right("000000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_estrai_copia_sv_wu.GetDouble("IMPOUT"),18,0)),18);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_copia_sv_wu->VALUTA,1) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_copia_sv_wu.GetString("VALUTA"),1);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_copia_sv_wu->FLAGFRAUD,1) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_copia_sv_wu.GetString("FLAGFRAUD"),1);
            /* FileLibMit.WriteLine(fhand,riga) */
            FileLibMit.WriteLine(fhand,riga);
            Cursor_qbe_estrai_copia_sv_wu.Next();
          }
          m_cConnectivityError = Cursor_qbe_estrai_copia_sv_wu.ErrorMessage();
          Cursor_qbe_estrai_copia_sv_wu.Close();
          // * --- End Select
        } // End If
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
      } // End While
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
    } finally {
      try {
        if (Cursor_qbe_estrai_copia_sv_wu_minmax!=null)
          Cursor_qbe_estrai_copia_sv_wu_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_copia_sv_wu!=null)
          Cursor_qbe_estrai_copia_sv_wu.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void RestoreTXT() throws Exception {
    /* inFileName := LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+"/"+LRTrim(pFile) */
    inFileName = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pFile);
    /* System.out.println(inFileName) */
    System.out.println(inFileName);
    // Legge le righe
    BufferedReader reader = new BufferedReader(new FileReader(inFileName));
    int lines = 0;
    while (reader.readLine() != null) lines++;
    reader.close();
    System.out.println(lines);
    /* fhand := FileLibMit.OpenRead("appo/"+LRTrim(gAzienda)+"/"+LRTrim(pFile)) // Per gestione file */
    fhand = FileLibMit.OpenRead("appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pFile));
    /* While not(FileLibMit.Eof(fhand)) */
    while ( ! (FileLibMit.Eof(fhand))) {
      /* riga := FileLibMit.ReadLine(fhand) */
      riga = FileLibMit.ReadLine(fhand);
      /* If not(Empty(LRTrim(riga))) */
      if ( ! (CPLib.Empty(CPLib.LRTrim(riga)))) {
        /* _contarow := _contarow + 1 */
        _contarow = CPLib.Round(_contarow+1,0);
        /* gMsgImp := "Sto elaborando la riga n. "+LRTrim(Str(_contarow,10,0)) + " su " + LRTrim(Str(lines,10,0)) // Messaggio Import */
        gMsgImp = "Sto elaborando la riga n. "+CPLib.LRTrim(CPLib.Str(_contarow,10,0))+" su "+CPLib.LRTrim(CPLib.Str(lines,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Insert into analisi_sv from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("analisi_sv");
        m_cPhName = m_Ctx.GetPhName("analisi_sv");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"analisi_sv",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_sv_check_wu",107,"0000012C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000012C(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(riga,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,2,11),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(riga,19,4)+CPLib.Substr(riga,16,2)+CPLib.Substr(riga,13,2)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,23,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,24,6),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,30,30),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,60,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,62,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,65,16),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,81,70),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,151,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,154,2),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,156,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,159,3),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,162,18)),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,180,1)))?"1":CPLib.Substr(riga,180,1)),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,181,1),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_contarow,"?",0,0)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"analisi_sv",true);
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
    // Chiusura del file di testo e cancellazione
    FileLibMit.Close(fhand);
    FileLibMit.DeleteFile("appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pFile));
  }
  void _init_() {
  }
  public String RunAsync(double p_pAnno,double p_pTri,String p_pTipo,String p_pFile) {
    pAnno = p_pAnno;
    pTri = p_pTri;
    pTipo = p_pTipo;
    pFile = p_pFile;
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
  public String Run(double p_pAnno,double p_pTri,String p_pTipo,String p_pFile) {
    pAnno = p_pAnno;
    pTri = p_pTri;
    pTipo = p_pTipo;
    pFile = p_pFile;
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
          Page_Main();
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
  public static arrt_estrai_sv_check_wuR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_estrai_sv_check_wuR(p_Ctx, p_Caller);
  }
  public static arrt_estrai_sv_check_wuR Make(CPContext p_Ctx) {
    return new arrt_estrai_sv_check_wuR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pAnno = 0;
    pTri = 0;
    pTipo = CPLib.Space(1);
    pFile = CPLib.Space(80);
    _datini = CPLib.Space(8);
    _datfin = CPLib.Space(8);
    cRitorno = CPLib.Space(30);
    fhand = CPLib.Space(1);
    riga = "";
    nFile = CPLib.Space(20);
    outFileName = CPLib.Space(30);
    inFileName = CPLib.Space(80);
    _conta = 0;
    _bottom = 0;
    _top = 0;
    _max = 0;
    _cicli = 0;
    _min = 0;
    _mono = 0;
    _tot = 0;
    _reccount = 0;
    _contarow = 0;
    _tcont = CPLib.Space(3);
    _importo = 0;
    _sotgru = CPLib.Space(3);
    _paeseres = CPLib.Space(3);
    _provres = CPLib.Space(2);
    _provage = CPLib.Space(2);
    mcStati = new MemoryCursor_tbstati();
    mcErrori = new MemoryCursor_qbe_estrai_sv_ope_chk_wu_vqr();
    mcDati = new MemoryCursor_qbe_estrai_sv_ope_tab_wu_vqr();
    _nfile = CPLib.Space(120);
    _datope = CPLib.Space(10);
    _ddatini = CPLib.NullDate();
    _ddatfin = CPLib.NullDate();
    _dataoggi = CPLib.NullDate();
    _cdataoggi = CPLib.Space(8);
    _oldmsg = "";
    _valuta = CPLib.Space(1);
    _flgfraud = CPLib.Space(1);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_estrai_sv_ope_tab_wu_minmax,qbe_estrai_sv_ope_tab_wu,qbe_estrai_sv_frz_tab_wu_minmax,qbe_estrai_sv_frz_tab_wu,qbe_estrai_sv_ope_chk_wu,qbe_estrai_copia_sv_wu_minmax,qbe_estrai_copia_sv_wu,
  public static final String m_cVQRList = ",qbe_estrai_sv_ope_tab_wu_minmax,qbe_estrai_sv_ope_tab_wu,qbe_estrai_sv_frz_tab_wu_minmax,qbe_estrai_sv_frz_tab_wu,qbe_estrai_sv_ope_chk_wu,qbe_estrai_copia_sv_wu_minmax,qbe_estrai_copia_sv_wu,";
  // ENTITY_BATCHES: ,arfn_datesum,arfn_fdate,arfn_fdatetime,arrt_estrai_sv_check_wu,
  public static final String i_InvokedRoutines = ",arfn_datesum,arfn_fdate,arfn_fdatetime,arrt_estrai_sv_check_wu,";
  public static String[] m_cRunParameterNames={"pAnno","pTri","pTipo","pFile"};
  protected static String GetFieldsName_000000A1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"PROVINCIA1,";
    p_cSql = p_cSql+"TIPOSV,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"TIPOCONT,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"ROWNUMBER,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"FLAGFRAUD,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"analisi_sv",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"PROVINCIA1,";
    p_cSql = p_cSql+"TIPOSV,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"TIPOCONT,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"ROWNUMBER,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"FLAGFRAUD,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"analisi_sv",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000012C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"PROVINCIA1,";
    p_cSql = p_cSql+"TIPOSV,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"TIPOCONT,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"FLAGFRAUD,";
    p_cSql = p_cSql+"ROWNUMBER,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"analisi_sv",true);
    return p_cSql;
  }
}
