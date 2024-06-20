// * --- Area Manuale = BO - Header
// * --- opert_estr_trim
import java.io.*;
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
public class opert_estr_trimR implements CallerWithObjs {
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
  public String w_anno;
  public String w_trimestre;
  public String w_tipo;
  public String gMsgImp;
  public String gMsgProc;
  public String gIntemediario;
  public String gAzienda;
  public String gPathApp;
  public String gPathDoc;
  public String GLNSegnalante;
  public java.sql.Date c_DataBegin;
  public java.sql.Date c_DataEnd;
  public MemoryCursor_qbe_estr_trim_vqr mc_Ritiri;
  public MemoryCursor_qbe_estr_trim_vqr mc_Sovvenzioni;
  public MemoryCursor_mc_tipoa_dipe_banca_mcrdef mc_tipo_a;
  public MemoryCursor_mc_tipob_altra_cit_mcrdef mc_tipo_b;
  public MemoryCursor_mc_tipoc_gdo_mcrdef mc_tipo_c;
  public MemoryCursor_mc_tipod_altri_sogg_mcrdef mc_tipo_d;
  public String tmp_key;
  public String _tipoatt;
  public MemoryCursor_mc_app_stp_estr_trim_mcrdef _GLN_stampa;
  public MemoryCursor_mc_app_stp_estr_trim2_mcrdef _ISTAT_stampa;
  public String fhand;
  public String _testo;
  public String fileName;
  public String cNomeFileZip;
  public String _file1;
  public String _file2;
  public double cnt;
  public double tot;
  public String _idbase;
  public String field1;
  public String field2;
  public String field3;
  public String field4;
  public String field5;
  public String field6;
  public String field7;
  public String field8;
  public String field9;
  public String field10;
  public String field11;
  public String field12;
  public String field13;
  public double count;
  public boolean first_print;
  // * --- Area Manuale = BO - Properties
  // * --- opert_estr_trim
  // These are the files to include in the ZIP file
  Vector filenames = new Vector();
  Vector fileonames = new Vector();
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
  
  // * --- Fine Area Manuale
  public opert_estr_trimR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("opert_estr_trim",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("cnt",p_cVarName)) {
      return cnt;
    }
    if (CPLib.eqr("tot",p_cVarName)) {
      return tot;
    }
    if (CPLib.eqr("count",p_cVarName)) {
      return count;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "opert_estr_trim";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("trimestre",p_cVarName)) {
      return w_trimestre;
    }
    if (CPLib.eqr("tipo",p_cVarName)) {
      return w_tipo;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
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
    if (CPLib.eqr("GLNSegnalante",p_cVarName)) {
      return GLNSegnalante;
    }
    if (CPLib.eqr("tmp_key",p_cVarName)) {
      return tmp_key;
    }
    if (CPLib.eqr("_tipoatt",p_cVarName)) {
      return _tipoatt;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_testo",p_cVarName)) {
      return _testo;
    }
    if (CPLib.eqr("fileName",p_cVarName)) {
      return fileName;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      return cNomeFileZip;
    }
    if (CPLib.eqr("_file1",p_cVarName)) {
      return _file1;
    }
    if (CPLib.eqr("_file2",p_cVarName)) {
      return _file2;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      return _idbase;
    }
    if (CPLib.eqr("field1",p_cVarName)) {
      return field1;
    }
    if (CPLib.eqr("field2",p_cVarName)) {
      return field2;
    }
    if (CPLib.eqr("field3",p_cVarName)) {
      return field3;
    }
    if (CPLib.eqr("field4",p_cVarName)) {
      return field4;
    }
    if (CPLib.eqr("field5",p_cVarName)) {
      return field5;
    }
    if (CPLib.eqr("field6",p_cVarName)) {
      return field6;
    }
    if (CPLib.eqr("field7",p_cVarName)) {
      return field7;
    }
    if (CPLib.eqr("field8",p_cVarName)) {
      return field8;
    }
    if (CPLib.eqr("field9",p_cVarName)) {
      return field9;
    }
    if (CPLib.eqr("field10",p_cVarName)) {
      return field10;
    }
    if (CPLib.eqr("field11",p_cVarName)) {
      return field11;
    }
    if (CPLib.eqr("field12",p_cVarName)) {
      return field12;
    }
    if (CPLib.eqr("field13",p_cVarName)) {
      return field13;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("c_DataBegin",p_cVarName)) {
      return c_DataBegin;
    }
    if (CPLib.eqr("c_DataEnd",p_cVarName)) {
      return c_DataEnd;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("first_print",p_cVarName)) {
      return first_print;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mc_Ritiri",p_cVarName)) {
      return mc_Ritiri;
    }
    if (CPLib.eqr("mc_Sovvenzioni",p_cVarName)) {
      return mc_Sovvenzioni;
    }
    if (CPLib.eqr("mc_tipo_a",p_cVarName)) {
      return mc_tipo_a;
    }
    if (CPLib.eqr("mc_tipo_b",p_cVarName)) {
      return mc_tipo_b;
    }
    if (CPLib.eqr("mc_tipo_c",p_cVarName)) {
      return mc_tipo_c;
    }
    if (CPLib.eqr("mc_tipo_d",p_cVarName)) {
      return mc_tipo_d;
    }
    if (CPLib.eqr("_GLN_stampa",p_cVarName)) {
      return _GLN_stampa;
    }
    if (CPLib.eqr("_ISTAT_stampa",p_cVarName)) {
      return _ISTAT_stampa;
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
    if (CPLib.eqr("cnt",p_cVarName)) {
      cnt = value;
      return;
    }
    if (CPLib.eqr("tot",p_cVarName)) {
      tot = value;
      return;
    }
    if (CPLib.eqr("count",p_cVarName)) {
      count = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
    if (CPLib.eqr("trimestre",p_cVarName)) {
      w_trimestre = value;
      return;
    }
    if (CPLib.eqr("tipo",p_cVarName)) {
      w_tipo = value;
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
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
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
    if (CPLib.eqr("GLNSegnalante",p_cVarName)) {
      GLNSegnalante = value;
      return;
    }
    if (CPLib.eqr("tmp_key",p_cVarName)) {
      tmp_key = value;
      return;
    }
    if (CPLib.eqr("_tipoatt",p_cVarName)) {
      _tipoatt = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_testo",p_cVarName)) {
      _testo = value;
      return;
    }
    if (CPLib.eqr("fileName",p_cVarName)) {
      fileName = value;
      return;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      cNomeFileZip = value;
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
    if (CPLib.eqr("_idbase",p_cVarName)) {
      _idbase = value;
      return;
    }
    if (CPLib.eqr("field1",p_cVarName)) {
      field1 = value;
      return;
    }
    if (CPLib.eqr("field2",p_cVarName)) {
      field2 = value;
      return;
    }
    if (CPLib.eqr("field3",p_cVarName)) {
      field3 = value;
      return;
    }
    if (CPLib.eqr("field4",p_cVarName)) {
      field4 = value;
      return;
    }
    if (CPLib.eqr("field5",p_cVarName)) {
      field5 = value;
      return;
    }
    if (CPLib.eqr("field6",p_cVarName)) {
      field6 = value;
      return;
    }
    if (CPLib.eqr("field7",p_cVarName)) {
      field7 = value;
      return;
    }
    if (CPLib.eqr("field8",p_cVarName)) {
      field8 = value;
      return;
    }
    if (CPLib.eqr("field9",p_cVarName)) {
      field9 = value;
      return;
    }
    if (CPLib.eqr("field10",p_cVarName)) {
      field10 = value;
      return;
    }
    if (CPLib.eqr("field11",p_cVarName)) {
      field11 = value;
      return;
    }
    if (CPLib.eqr("field12",p_cVarName)) {
      field12 = value;
      return;
    }
    if (CPLib.eqr("field13",p_cVarName)) {
      field13 = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("c_DataBegin",p_cVarName)) {
      c_DataBegin = value;
      return;
    }
    if (CPLib.eqr("c_DataEnd",p_cVarName)) {
      c_DataEnd = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("first_print",p_cVarName)) {
      first_print = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mc_Ritiri",p_cVarName)) {
      mc_Ritiri = (MemoryCursor_qbe_estr_trim_vqr)value;
      return;
    }
    if (CPLib.eqr("mc_Sovvenzioni",p_cVarName)) {
      mc_Sovvenzioni = (MemoryCursor_qbe_estr_trim_vqr)value;
      return;
    }
    if (CPLib.eqr("mc_tipo_a",p_cVarName)) {
      mc_tipo_a = (MemoryCursor_mc_tipoa_dipe_banca_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mc_tipo_b",p_cVarName)) {
      mc_tipo_b = (MemoryCursor_mc_tipob_altra_cit_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mc_tipo_c",p_cVarName)) {
      mc_tipo_c = (MemoryCursor_mc_tipoc_gdo_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mc_tipo_d",p_cVarName)) {
      mc_tipo_d = (MemoryCursor_mc_tipod_altri_sogg_mcrdef)value;
      return;
    }
    if (CPLib.eqr("_GLN_stampa",p_cVarName)) {
      _GLN_stampa = (MemoryCursor_mc_app_stp_estr_trim_mcrdef)value;
      return;
    }
    if (CPLib.eqr("_ISTAT_stampa",p_cVarName)) {
      _ISTAT_stampa = (MemoryCursor_mc_app_stp_estr_trim2_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    try {
      /* w_anno Char(0) */
      /* w_trimestre Char(0) */
      /* w_tipo Char(1) */
      /* gMsgImp Char(120) // Messaggio Trasferimento */
      /* gMsgProc Memo // Log */
      /* gIntemediario Char(11) // Intermediario */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
      /* GLNSegnalante Char(13) */
      /* c_DataBegin Date // Data inizio periodo */
      /* c_DataEnd Date // Data fine periodo */
      /* mc_Ritiri MemoryCursor(qbe_estr_trim.vqr) */
      /* mc_Sovvenzioni MemoryCursor(qbe_estr_trim.vqr) */
      /* mc_tipo_a MemoryCursor(mc_tipoA_dipe_banca.MCRDef) // Dipendenza Bancarie e Postali */
      /* mc_tipo_b MemoryCursor(mc_tipoB_altra_CIT.MCRDef) // Sale Conta altri operatori o Sale Conta stesso operatore */
      /* mc_tipo_c MemoryCursor(mc_tipoC_GDO.MCRDef) // GDO */
      /* mc_tipo_d MemoryCursor(mc_tipoD_altri_sogg.MCRDef) // Altri Soggetti */
      /* tmp_key Char(0) */
      /* _tipoatt Char(3) */
      /* _GLN_stampa MemoryCursor(mc_app_stp_estr_trim.MCRDef) */
      /* _ISTAT_stampa MemoryCursor(mc_app_stp_estr_trim2.MCRDef) */
      /* fhand Char(10) */
      /* _testo Memo */
      /* fileName Char(12) // nome del file xml */
      /* cNomeFileZip Char(30) // Nome file zip da creare */
      /* _file1 Char(30) */
      /* _file2 Char(80) */
      /* cnt Numeric(0, 0) // contatore di appoggio */
      /* tot Numeric(0, 0) // altro contatore di appoggio */
      /* _idbase Char(10) */
      /* field1 Char(0) */
      /* field2 Char(0) */
      /* field3 Char(0) */
      /* field4 Char(0) */
      /* field5 Char(0) */
      /* field6 Char(0) */
      /* field7 Char(0) */
      /* field8 Char(0) */
      /* field9 Char(0) */
      /* field10 Char(0) */
      /* field11 Char(0) */
      /* field12 Char(0) */
      /* field13 Char(0) */
      /* gMsgProc := '' */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := '' */
      gMsgImp = "";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + arfn_fdatetime(DateTime())+' Avvio procedura di elaborazione' +NL */
      gMsgProc = gMsgProc+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Avvio procedura di elaborazione"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Elaborazione in corso' */
      gMsgImp = "Elaborazione in corso";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODICEGLN  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* GLNSegnalante := intermbo->CODICEGLN */
        GLNSegnalante = Cursor_intermbo.GetString("CODICEGLN");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* Case w_trimestre="1" */
      if (CPLib.eqr(w_trimestre,"1")) {
        /* c_DataBegin := CharToDate(w_anno+'0101') // Data inizio periodo */
        c_DataBegin = CPLib.CharToDate(w_anno+"0101");
        /* c_DataEnd := CharToDate(w_anno+"0331") // Data fine periodo */
        c_DataEnd = CPLib.CharToDate(w_anno+"0331");
        /* Case w_trimestre="2" */
      } else if (CPLib.eqr(w_trimestre,"2")) {
        /* c_DataBegin := CharToDate(w_anno+'0401') // Data inizio periodo */
        c_DataBegin = CPLib.CharToDate(w_anno+"0401");
        /* c_DataEnd := CharToDate(w_anno+'0630') // Data fine periodo */
        c_DataEnd = CPLib.CharToDate(w_anno+"0630");
        /* Case w_trimestre="3" */
      } else if (CPLib.eqr(w_trimestre,"3")) {
        /* c_DataBegin := CharToDate(w_anno+'0701') // Data inizio periodo */
        c_DataBegin = CPLib.CharToDate(w_anno+"0701");
        /* c_DataEnd := CharToDate(w_anno+'0930') // Data fine periodo */
        c_DataEnd = CPLib.CharToDate(w_anno+"0930");
        /* Case w_trimestre="4" */
      } else if (CPLib.eqr(w_trimestre,"4")) {
        /* c_DataBegin := CharToDate(w_anno+'1001') // Data inizio periodo */
        c_DataBegin = CPLib.CharToDate(w_anno+"1001");
        /* c_DataEnd := CharToDate(w_anno+'1231') // Data fine periodo */
        c_DataEnd = CPLib.CharToDate(w_anno+"1231");
      } // End Case
      /* gMsgProc := gMsgProc + arfn_fdatetime(DateTime())+' Estrazione periodo:  da '+c_DataBegin+' a '+c_DataEnd + NL */
      gMsgProc = gMsgProc+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Estrazione periodo:  da "+c_DataBegin+" a "+c_DataEnd+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _tipoatt := 'RIT' */
      _tipoatt = "RIT";
      /* Exec "Creare Memory Cursor" Page 2:CreateMC */
      CreateMC();
      /* If mc_Ritiri.RecCount()>0 */
      if (CPLib.gt(mc_Ritiri.RecCount(),0)) {
        /* If w_tipo='E' */
        if (CPLib.eqr(w_tipo,"E")) {
          /* Exec "Crea File XML" Page 3:CreateXML */
          CreateXML();
        } else { // Else
          /* Exec "Estrazione XLS" Page 5:EstraiXLS */
          EstraiXLS();
        } // End If
      } // End If
      /* mc_Ritiri.Zap() */
      mc_Ritiri.Zap();
      /* mc_Sovvenzioni.Zap() */
      mc_Sovvenzioni.Zap();
      /* mc_tipo_a.Zap() // Dipendenza Bancarie e Postali */
      mc_tipo_a.Zap();
      /* mc_tipo_b.Zap() // Sale Conta altri operatori o Sale Conta stesso operatore */
      mc_tipo_b.Zap();
      /* mc_tipo_c.Zap() // GDO */
      mc_tipo_c.Zap();
      /* mc_tipo_d.Zap() // Altri Soggetti */
      mc_tipo_d.Zap();
      /* _GLN_stampa.Zap() */
      _GLN_stampa.Zap();
      /* _ISTAT_stampa.Zap() */
      _ISTAT_stampa.Zap();
      /* _tipoatt := 'SOV' */
      _tipoatt = "SOV";
      /* Exec "Creare Memory Cursor" Page 2:CreateMC */
      CreateMC();
      /* If mc_Ritiri.RecCount()>0 */
      if (CPLib.gt(mc_Ritiri.RecCount(),0)) {
        /* If w_tipo='E' */
        if (CPLib.eqr(w_tipo,"E")) {
          /* Exec "Crea File XML" Page 3:CreateXML */
          CreateXML();
        } else { // Else
          /* Exec "Estrazione XLS" Page 5:EstraiXLS */
          EstraiXLS();
        } // End If
      } // End If
      /* cNomeFileZip := LRTrim(gPathDoc)+"/export/"+LRTrim(gAzienda)+"/"+w_anno+"Q"+w_trimestre+".zip" */
      cNomeFileZip = CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+w_anno+"Q"+w_trimestre+".zip";
      /* Exec "Creazione File Zip" Page 4:CreateZIP */
      CreateZIP();
      /* gMsgProc := gMsgProc + arfn_fdatetime(DateTime())+' Fine procedura di elaborazione' +NL */
      gMsgProc = gMsgProc+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Fine procedura di elaborazione"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Elaborazione terminata - Prelevare il FILE' */
      gMsgImp = "Elaborazione terminata - Prelevare il FILE";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void CreateMC() throws Exception {
    CPResultSet Cursor_qbe_estr_trim=null;
    CPResultSet Cursor_qbe_estr_trim_agg_a_numdipe=null;
    CPResultSet Cursor_qbe_estr_trim_agg_c_numdipe=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* If _tipoatt='RIT' */
      if (CPLib.eqr(_tipoatt,"RIT")) {
        /* gMsgProc := gMsgProc + arfn_fdatetime(DateTime())+' Elaborazione dei ritiri' +NL */
        gMsgProc = gMsgProc+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Elaborazione dei ritiri"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc + arfn_fdatetime(DateTime())+' Elaborazione dei sovvenzioni' +NL */
        gMsgProc = gMsgProc+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Elaborazione dei sovvenzioni"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      // * --- Fill memory cursor mc_Ritiri on qbe_estr_trim
      mc_Ritiri.Zap();
      SPBridge.HMCaller _h0000005E;
      _h0000005E = new SPBridge.HMCaller();
      _h0000005E.Set("m_cVQRList",m_cVQRList);
      _h0000005E.Set("daData",c_DataBegin);
      _h0000005E.Set("aData",c_DataEnd);
      _h0000005E.Set("tipoAttivita",_tipoatt);
      if (Cursor_qbe_estr_trim!=null)
        Cursor_qbe_estr_trim.Close();
      Cursor_qbe_estr_trim = new VQRHolder("qbe_estr_trim",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000005E,true).GetResultSet(m_Ctx);
      {
        final CPResultSet m_TheCursor = Cursor_qbe_estr_trim;
        Cursor_qbe_estr_trim.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,10000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine opert_estr_trim: query on qbe_estr_trim returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 10000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_qbe_estr_trim.Eof())) {
        mc_Ritiri.AppendBlank();
        mc_Ritiri.row.IDBASE = Cursor_qbe_estr_trim.GetString("IDBASE");
        mc_Ritiri.row.TIPOSOGGETTO = Cursor_qbe_estr_trim.GetString("TIPOSOGGETTO");
        mc_Ritiri.row.RAPSEGNA = Cursor_qbe_estr_trim.GetString("RAPSEGNA");
        mc_Ritiri.row.CODICEGLN = Cursor_qbe_estr_trim.GetString("CODICEGLN");
        mc_Ritiri.row.ABIINTER = Cursor_qbe_estr_trim.GetString("ABIINTER");
        mc_Ritiri.row.ABIPROPR = Cursor_qbe_estr_trim.GetString("ABIPROPR");
        mc_Ritiri.row.TIPOATTIV = Cursor_qbe_estr_trim.GetString("TIPOATTIV");
        mc_Ritiri.row.NBANCONOTE = Cursor_qbe_estr_trim.GetDouble("NBANCONOTE");
        mc_Ritiri.row.TAGLIO = Cursor_qbe_estr_trim.GetDouble("TAGLIO");
        mc_Ritiri.row.GLNALTRASC = Cursor_qbe_estr_trim.GetString("GLNALTRASC");
        mc_Ritiri.row.GLNALTROSOG = Cursor_qbe_estr_trim.GetString("GLNALTROSOG");
        mc_Ritiri.row.CODCLICON = Cursor_qbe_estr_trim.GetString("CODCLICON");
        mc_Ritiri.row.CODCOMCON = Cursor_qbe_estr_trim.GetString("CODCOMCON");
        mc_Ritiri.row.ATECO_CON = Cursor_qbe_estr_trim.GetString("ATECO_CON");
        mc_Ritiri.row.CONNES = Cursor_qbe_estr_trim.GetString("CONNES");
        mc_Ritiri.row.ATTIV = Cursor_qbe_estr_trim.GetString("ATTIV");
        Cursor_qbe_estr_trim.Next();
      }
      m_cConnectivityError = Cursor_qbe_estr_trim.ErrorMessage();
      Cursor_qbe_estr_trim.Close();
      mc_Ritiri.GoTop();
      /* gMsgProc := gMsgProc + arfn_fdatetime(DateTime())+ ' Elementi da processare: '+mc_Ritiri.RecCount()+ NL */
      gMsgProc = gMsgProc+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Elementi da processare: "+mc_Ritiri.RecCount()+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      for (MemoryCursorRow_qbe_estr_trim_vqr rw_Ritiri : mc_Ritiri._iterable_()) {
        /* tmp_key := ''+rw_Ritiri.CODICEGLN */
        tmp_key = ""+rw_Ritiri.CODICEGLN;
        /* If not(_GLN_stampa.GoToKey(tmp_key)) */
        if ( ! (_GLN_stampa.GoToKey(tmp_key))) {
          /* _GLN_stampa.AppendWithKey(tmp_key) */
          _GLN_stampa.AppendWithKey(tmp_key);
          /* _GLN_stampa.GLN := rw_Ritiri.CODICEGLN */
          _GLN_stampa.row.GLN = rw_Ritiri.CODICEGLN;
          /* _GLN_stampa.SaveRow() */
          _GLN_stampa.SaveRow();
        } // End If
        /* tmp_key := ''+rw_Ritiri.CODCOMCON */
        tmp_key = ""+rw_Ritiri.CODCOMCON;
        /* If not(_ISTAT_stampa.GoToKey(tmp_key)) and tmp_key<>"" */
        if ( ! (_ISTAT_stampa.GoToKey(tmp_key)) && CPLib.ne(tmp_key,"")) {
          /* _ISTAT_stampa.AppendWithKey(tmp_key) */
          _ISTAT_stampa.AppendWithKey(tmp_key);
          /* _ISTAT_stampa.ISTAT := rw_Ritiri.CODCOMCON */
          _ISTAT_stampa.row.ISTAT = rw_Ritiri.CODCOMCON;
          /* _ISTAT_stampa.SaveRow() */
          _ISTAT_stampa.SaveRow();
        } // End If
        /* Case rw_Ritiri.TIPOSOGGETTO='a' */
        if (CPLib.eqr(rw_Ritiri.TIPOSOGGETTO,"a")) {
          /* tmp_key := ''+rw_Ritiri.CODICEGLN+rw_Ritiri.CODCOMCON+rw_Ritiri.ABIINTER+rw_Ritiri.ABIPROPR+rw_Ritiri.RAPSEGNA+_tipoatt */
          tmp_key = ""+rw_Ritiri.CODICEGLN+rw_Ritiri.CODCOMCON+rw_Ritiri.ABIINTER+rw_Ritiri.ABIPROPR+rw_Ritiri.RAPSEGNA+_tipoatt;
          /* If mc_tipo_a.HasKey(tmp_key) */
          if (mc_tipo_a.HasKey(tmp_key)) {
            /* mc_tipo_a.GoToKey(tmp_key) */
            mc_tipo_a.GoToKey(tmp_key);
            /* If rw_Ritiri.IDBASE <> _idbase */
            if (CPLib.ne(rw_Ritiri.IDBASE,_idbase)) {
              /* mc_tipo_a.NUM_OPE := mc_tipo_a.NUM_OPE+1 */
              mc_tipo_a.row.NUM_OPE = mc_tipo_a.row.NUM_OPE+1;
              /* _idbase := rw_Ritiri.IDBASE */
              _idbase = rw_Ritiri.IDBASE;
            } // End If
            /* If rw_Ritiri.TAGLIO=5 */
            if (CPLib.eqr(rw_Ritiri.TAGLIO,5)) {
              /* mc_tipo_a.BM5 := mc_tipo_a.BM5+rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.BM5 = mc_tipo_a.row.BM5+rw_Ritiri.NBANCONOTE;
              /* If mc_tipo_a.MFB5<rw_Ritiri.NBANCONOTE */
              if (CPLib.lt(mc_tipo_a.row.MFB5,rw_Ritiri.NBANCONOTE)) {
                /* mc_tipo_a.MFB5 := rw_Ritiri.NBANCONOTE */
                mc_tipo_a.row.MFB5 = rw_Ritiri.NBANCONOTE;
              } // End If
              /* ElseIf rw_Ritiri.TAGLIO=10 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,10)) {
              /* mc_tipo_a.BM10 := mc_tipo_a.BM10+rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.BM10 = mc_tipo_a.row.BM10+rw_Ritiri.NBANCONOTE;
              /* If mc_tipo_a.MFB10<rw_Ritiri.NBANCONOTE */
              if (CPLib.lt(mc_tipo_a.row.MFB10,rw_Ritiri.NBANCONOTE)) {
                /* mc_tipo_a.MFB10 := rw_Ritiri.NBANCONOTE */
                mc_tipo_a.row.MFB10 = rw_Ritiri.NBANCONOTE;
              } // End If
              /* ElseIf rw_Ritiri.TAGLIO=20 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,20)) {
              /* mc_tipo_a.BM20 := mc_tipo_a.BM20+rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.BM20 = mc_tipo_a.row.BM20+rw_Ritiri.NBANCONOTE;
              /* If mc_tipo_a.MFB20<rw_Ritiri.NBANCONOTE */
              if (CPLib.lt(mc_tipo_a.row.MFB20,rw_Ritiri.NBANCONOTE)) {
                /* mc_tipo_a.MFB20 := rw_Ritiri.NBANCONOTE */
                mc_tipo_a.row.MFB20 = rw_Ritiri.NBANCONOTE;
              } // End If
              /* ElseIf rw_Ritiri.TAGLIO=50 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,50)) {
              /* mc_tipo_a.BM50 := mc_tipo_a.BM50+rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.BM50 = mc_tipo_a.row.BM50+rw_Ritiri.NBANCONOTE;
              /* If mc_tipo_a.MFB50<rw_Ritiri.NBANCONOTE */
              if (CPLib.lt(mc_tipo_a.row.MFB50,rw_Ritiri.NBANCONOTE)) {
                /* mc_tipo_a.MFB50 := rw_Ritiri.NBANCONOTE */
                mc_tipo_a.row.MFB50 = rw_Ritiri.NBANCONOTE;
              } // End If
              /* ElseIf rw_Ritiri.TAGLIO=100 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,100)) {
              /* mc_tipo_a.BM100 := mc_tipo_a.BM100+rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.BM100 = mc_tipo_a.row.BM100+rw_Ritiri.NBANCONOTE;
              /* If mc_tipo_a.MFB100<rw_Ritiri.NBANCONOTE */
              if (CPLib.lt(mc_tipo_a.row.MFB100,rw_Ritiri.NBANCONOTE)) {
                /* mc_tipo_a.MFB100 := rw_Ritiri.NBANCONOTE */
                mc_tipo_a.row.MFB100 = rw_Ritiri.NBANCONOTE;
              } // End If
              /* ElseIf rw_Ritiri.TAGLIO=200 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,200)) {
              /* mc_tipo_a.BM200 := mc_tipo_a.BM200+rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.BM200 = mc_tipo_a.row.BM200+rw_Ritiri.NBANCONOTE;
              /* If mc_tipo_a.MFB200<rw_Ritiri.NBANCONOTE */
              if (CPLib.lt(mc_tipo_a.row.MFB200,rw_Ritiri.NBANCONOTE)) {
                /* mc_tipo_a.MFB200 := rw_Ritiri.NBANCONOTE */
                mc_tipo_a.row.MFB200 = rw_Ritiri.NBANCONOTE;
              } // End If
              /* ElseIf rw_Ritiri.TAGLIO=500 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,500)) {
              /* mc_tipo_a.BM500 := mc_tipo_a.BM500+rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.BM500 = mc_tipo_a.row.BM500+rw_Ritiri.NBANCONOTE;
              /* If mc_tipo_a.MFB500<rw_Ritiri.NBANCONOTE */
              if (CPLib.lt(mc_tipo_a.row.MFB500,rw_Ritiri.NBANCONOTE)) {
                /* mc_tipo_a.MFB500 := rw_Ritiri.NBANCONOTE */
                mc_tipo_a.row.MFB500 = rw_Ritiri.NBANCONOTE;
              } // End If
            } // End If
          } else { // Else
            /* _idbase := rw_Ritiri.IDBASE */
            _idbase = rw_Ritiri.IDBASE;
            /* mc_tipo_a.AppendWithKey(tmp_key) */
            mc_tipo_a.AppendWithKey(tmp_key);
            /* mc_tipo_a.KEY := tmp_key */
            mc_tipo_a.row.KEY = tmp_key;
            /* mc_tipo_a.GNL := rw_Ritiri.CODICEGLN // GNL Luogo Contazione */
            mc_tipo_a.row.GNL = rw_Ritiri.CODICEGLN;
            /* mc_tipo_a.ISTAT := rw_Ritiri.CODCOMCON // Codice Comune (ISTAT) */
            mc_tipo_a.row.ISTAT = rw_Ritiri.CODCOMCON;
            /* mc_tipo_a.CAB := rw_Ritiri.ABIINTER // ABIBanca (che poi è un CAB) */
            mc_tipo_a.row.CAB = rw_Ritiri.ABIINTER;
            /* mc_tipo_a.ABI_P := rw_Ritiri.ABIPROPR // ABI Proprietario */
            mc_tipo_a.row.ABI_P = rw_Ritiri.ABIPROPR;
            /* mc_tipo_a.TIPO_RAPP := rw_Ritiri.RAPSEGNA // Rapporto con il Segnalante */
            mc_tipo_a.row.TIPO_RAPP = rw_Ritiri.RAPSEGNA;
            /* mc_tipo_a.TIPO_ATT := rw_Ritiri.TIPOATTIV // Tipo di Attività (SP o CD) */
            mc_tipo_a.row.TIPO_ATT = rw_Ritiri.TIPOATTIV;
            /* mc_tipo_a.BM5 := 0 */
            mc_tipo_a.row.BM5 = 0;
            /* mc_tipo_a.BM10 := 0 */
            mc_tipo_a.row.BM10 = 0;
            /* mc_tipo_a.BM20 := 0 */
            mc_tipo_a.row.BM20 = 0;
            /* mc_tipo_a.BM50 := 0 */
            mc_tipo_a.row.BM50 = 0;
            /* mc_tipo_a.BM100 := 0 */
            mc_tipo_a.row.BM100 = 0;
            /* mc_tipo_a.BM200 := 0 */
            mc_tipo_a.row.BM200 = 0;
            /* mc_tipo_a.BM500 := 0 */
            mc_tipo_a.row.BM500 = 0;
            /* mc_tipo_a.MFB5 := 0 */
            mc_tipo_a.row.MFB5 = 0;
            /* mc_tipo_a.MFB10 := 0 */
            mc_tipo_a.row.MFB10 = 0;
            /* mc_tipo_a.MFB20 := 0 */
            mc_tipo_a.row.MFB20 = 0;
            /* mc_tipo_a.MFB50 := 0 */
            mc_tipo_a.row.MFB50 = 0;
            /* mc_tipo_a.MFB100 := 0 */
            mc_tipo_a.row.MFB100 = 0;
            /* mc_tipo_a.MFB200 := 0 */
            mc_tipo_a.row.MFB200 = 0;
            /* mc_tipo_a.MFB500 := 0 */
            mc_tipo_a.row.MFB500 = 0;
            /* mc_tipo_a.DIP_SERV := 1 // Numero di dipendenze Servite */
            mc_tipo_a.row.DIP_SERV = 1;
            /* mc_tipo_a.NUM_OPE := 1 // Numero di operazioni effettuate */
            mc_tipo_a.row.NUM_OPE = 1;
            /* If rw_Ritiri.TAGLIO=5 */
            if (CPLib.eqr(rw_Ritiri.TAGLIO,5)) {
              /* mc_tipo_a.BM5 := rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.BM5 = rw_Ritiri.NBANCONOTE;
              /* mc_tipo_a.MFB5 := rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.MFB5 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=10 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,10)) {
              /* mc_tipo_a.BM10 := rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.BM10 = rw_Ritiri.NBANCONOTE;
              /* mc_tipo_a.MFB10 := rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.MFB10 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=20 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,20)) {
              /* mc_tipo_a.BM20 := rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.BM20 = rw_Ritiri.NBANCONOTE;
              /* mc_tipo_a.MFB20 := rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.MFB20 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=50 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,50)) {
              /* mc_tipo_a.BM50 := rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.BM50 = rw_Ritiri.NBANCONOTE;
              /* mc_tipo_a.MFB50 := rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.MFB50 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=100 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,100)) {
              /* mc_tipo_a.BM100 := rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.BM100 = rw_Ritiri.NBANCONOTE;
              /* mc_tipo_a.MFB100 := rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.MFB100 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=200 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,200)) {
              /* mc_tipo_a.BM200 := rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.BM200 = rw_Ritiri.NBANCONOTE;
              /* mc_tipo_a.MFB200 := rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.MFB200 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=500 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,500)) {
              /* mc_tipo_a.BM500 := rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.BM500 = rw_Ritiri.NBANCONOTE;
              /* mc_tipo_a.MFB500 := rw_Ritiri.NBANCONOTE */
              mc_tipo_a.row.MFB500 = rw_Ritiri.NBANCONOTE;
            } // End If
          } // End If
          /* mc_tipo_a.SaveRow() */
          mc_tipo_a.SaveRow();
          /* Case rw_Ritiri.TIPOSOGGETTO='b' */
        } else if (CPLib.eqr(rw_Ritiri.TIPOSOGGETTO,"b")) {
          /* tmp_key := ''+rw_Ritiri.CODICEGLN+rw_Ritiri.GLNALTROSOG+rw_Ritiri.GLNALTRASC+rw_Ritiri.ABIPROPR+_tipoatt */
          tmp_key = ""+rw_Ritiri.CODICEGLN+rw_Ritiri.GLNALTROSOG+rw_Ritiri.GLNALTRASC+rw_Ritiri.ABIPROPR+_tipoatt;
          /* If mc_tipo_b.HasKey(tmp_key) */
          if (mc_tipo_b.HasKey(tmp_key)) {
            /* mc_tipo_b.GoToKey(tmp_key) */
            mc_tipo_b.GoToKey(tmp_key);
            /* If rw_Ritiri.IDBASE <> _idbase */
            if (CPLib.ne(rw_Ritiri.IDBASE,_idbase)) {
              /* mc_tipo_b.NUM_OPE := mc_tipo_b.NUM_OPE+1 */
              mc_tipo_b.row.NUM_OPE = mc_tipo_b.row.NUM_OPE+1;
              /* _idbase := rw_Ritiri.IDBASE */
              _idbase = rw_Ritiri.IDBASE;
            } // End If
            /* If rw_Ritiri.TAGLIO=5 */
            if (CPLib.eqr(rw_Ritiri.TAGLIO,5)) {
              /* mc_tipo_b.BM5 := mc_tipo_b.BM5+rw_Ritiri.NBANCONOTE */
              mc_tipo_b.row.BM5 = mc_tipo_b.row.BM5+rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=10 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,10)) {
              /* mc_tipo_b.BM10 := mc_tipo_b.BM10+rw_Ritiri.NBANCONOTE */
              mc_tipo_b.row.BM10 = mc_tipo_b.row.BM10+rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=20 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,20)) {
              /* mc_tipo_b.BM20 := mc_tipo_b.BM20+rw_Ritiri.NBANCONOTE */
              mc_tipo_b.row.BM20 = mc_tipo_b.row.BM20+rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=50 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,50)) {
              /* mc_tipo_b.BM50 := mc_tipo_b.BM50+rw_Ritiri.NBANCONOTE */
              mc_tipo_b.row.BM50 = mc_tipo_b.row.BM50+rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=100 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,100)) {
              /* mc_tipo_b.BM100 := mc_tipo_b.BM100+rw_Ritiri.NBANCONOTE */
              mc_tipo_b.row.BM100 = mc_tipo_b.row.BM100+rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=200 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,200)) {
              /* mc_tipo_b.BM200 := mc_tipo_b.BM200+rw_Ritiri.NBANCONOTE */
              mc_tipo_b.row.BM200 = mc_tipo_b.row.BM200+rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=500 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,500)) {
              /* mc_tipo_b.BM500 := mc_tipo_b.BM500+rw_Ritiri.NBANCONOTE */
              mc_tipo_b.row.BM500 = mc_tipo_b.row.BM500+rw_Ritiri.NBANCONOTE;
            } // End If
          } else { // Else
            /* _idbase := rw_Ritiri.IDBASE */
            _idbase = rw_Ritiri.IDBASE;
            /* mc_tipo_b.AppendWithKey(tmp_key) */
            mc_tipo_b.AppendWithKey(tmp_key);
            /* mc_tipo_b.KEY := tmp_key */
            mc_tipo_b.row.KEY = tmp_key;
            /* mc_tipo_b.GNL := rw_Ritiri.CODICEGLN // GNL Luogo di contazione */
            mc_tipo_b.row.GNL = rw_Ritiri.CODICEGLN;
            /* mc_tipo_b.ISTAT := rw_Ritiri.CODCOMCON // Codice Comune (ISTAT) */
            mc_tipo_b.row.ISTAT = rw_Ritiri.CODCOMCON;
            /* mc_tipo_b.GNLCIT := rw_Ritiri.GLNALTROSOG // GNL altra CIT */
            mc_tipo_b.row.GNLCIT = rw_Ritiri.GLNALTROSOG;
            /* mc_tipo_b.GNLCITSALA := rw_Ritiri.GLNALTRASC // GNL Sala Conta dell'altra CIT */
            mc_tipo_b.row.GNLCITSALA = rw_Ritiri.GLNALTRASC;
            /* mc_tipo_b.ABI_P := rw_Ritiri.ABIPROPR // ABI Proprietario */
            mc_tipo_b.row.ABI_P = rw_Ritiri.ABIPROPR;
            /* mc_tipo_b.BM5 := 0 */
            mc_tipo_b.row.BM5 = 0;
            /* mc_tipo_b.BM10 := 0 */
            mc_tipo_b.row.BM10 = 0;
            /* mc_tipo_b.BM20 := 0 */
            mc_tipo_b.row.BM20 = 0;
            /* mc_tipo_b.BM50 := 0 */
            mc_tipo_b.row.BM50 = 0;
            /* mc_tipo_b.BM100 := 0 */
            mc_tipo_b.row.BM100 = 0;
            /* mc_tipo_b.BM200 := 0 */
            mc_tipo_b.row.BM200 = 0;
            /* mc_tipo_b.BM500 := 0 */
            mc_tipo_b.row.BM500 = 0;
            /* mc_tipo_b.NUM_OPE := 1 // Numero delle operazioni effettuate */
            mc_tipo_b.row.NUM_OPE = 1;
            /* If rw_Ritiri.TAGLIO=5 */
            if (CPLib.eqr(rw_Ritiri.TAGLIO,5)) {
              /* mc_tipo_b.BM5 := rw_Ritiri.NBANCONOTE */
              mc_tipo_b.row.BM5 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=10 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,10)) {
              /* mc_tipo_b.BM10 := rw_Ritiri.NBANCONOTE */
              mc_tipo_b.row.BM10 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=20 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,20)) {
              /* mc_tipo_b.BM20 := rw_Ritiri.NBANCONOTE */
              mc_tipo_b.row.BM20 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=50 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,50)) {
              /* mc_tipo_b.BM50 := rw_Ritiri.NBANCONOTE */
              mc_tipo_b.row.BM50 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=100 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,100)) {
              /* mc_tipo_b.BM100 := rw_Ritiri.NBANCONOTE */
              mc_tipo_b.row.BM100 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=200 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,200)) {
              /* mc_tipo_b.BM200 := rw_Ritiri.NBANCONOTE */
              mc_tipo_b.row.BM200 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=500 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,500)) {
              /* mc_tipo_b.BM500 := rw_Ritiri.NBANCONOTE */
              mc_tipo_b.row.BM500 = rw_Ritiri.NBANCONOTE;
            } // End If
          } // End If
          /* mc_tipo_b.SaveRow() */
          mc_tipo_b.SaveRow();
          /* Case rw_Ritiri.TIPOSOGGETTO='c' */
        } else if (CPLib.eqr(rw_Ritiri.TIPOSOGGETTO,"c")) {
          /* tmp_key := ''+rw_Ritiri.CODICEGLN+rw_Ritiri.CODCOMCON+iif(Empty(rw_Ritiri.ATTIV),rw_Ritiri.ATECO_CON,rw_Ritiri.ATTIV)+rw_Ritiri.ABIPROPR+_tipoatt */
          tmp_key = ""+rw_Ritiri.CODICEGLN+rw_Ritiri.CODCOMCON+(CPLib.Empty(rw_Ritiri.ATTIV)?rw_Ritiri.ATECO_CON:rw_Ritiri.ATTIV)+rw_Ritiri.ABIPROPR+_tipoatt;
          /* If mc_tipo_c.HasKey(tmp_key) */
          if (mc_tipo_c.HasKey(tmp_key)) {
            /* mc_tipo_c.GoToKey(tmp_key) // GDO */
            mc_tipo_c.GoToKey(tmp_key);
            /* If rw_Ritiri.IDBASE <> _idbase */
            if (CPLib.ne(rw_Ritiri.IDBASE,_idbase)) {
              /* mc_tipo_c.NUM_OPE := mc_tipo_c.NUM_OPE+1 */
              mc_tipo_c.row.NUM_OPE = mc_tipo_c.row.NUM_OPE+1;
              /* _idbase := rw_Ritiri.IDBASE */
              _idbase = rw_Ritiri.IDBASE;
            } // End If
            /* If rw_Ritiri.TAGLIO=5 */
            if (CPLib.eqr(rw_Ritiri.TAGLIO,5)) {
              /* mc_tipo_c.BM5 := mc_tipo_c.BM5+rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.BM5 = mc_tipo_c.row.BM5+rw_Ritiri.NBANCONOTE;
              /* If mc_tipo_c.MFB5<rw_Ritiri.NBANCONOTE */
              if (CPLib.lt(mc_tipo_c.row.MFB5,rw_Ritiri.NBANCONOTE)) {
                /* mc_tipo_c.MFB5 := rw_Ritiri.NBANCONOTE */
                mc_tipo_c.row.MFB5 = rw_Ritiri.NBANCONOTE;
              } // End If
              /* ElseIf rw_Ritiri.TAGLIO=10 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,10)) {
              /* mc_tipo_c.BM10 := mc_tipo_c.BM10+rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.BM10 = mc_tipo_c.row.BM10+rw_Ritiri.NBANCONOTE;
              /* If mc_tipo_c.MFB10<rw_Ritiri.NBANCONOTE */
              if (CPLib.lt(mc_tipo_c.row.MFB10,rw_Ritiri.NBANCONOTE)) {
                /* mc_tipo_c.MFB10 := rw_Ritiri.NBANCONOTE */
                mc_tipo_c.row.MFB10 = rw_Ritiri.NBANCONOTE;
              } // End If
              /* ElseIf rw_Ritiri.TAGLIO=20 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,20)) {
              /* mc_tipo_c.BM20 := mc_tipo_c.BM20+rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.BM20 = mc_tipo_c.row.BM20+rw_Ritiri.NBANCONOTE;
              /* If mc_tipo_c.MFB20<rw_Ritiri.NBANCONOTE */
              if (CPLib.lt(mc_tipo_c.row.MFB20,rw_Ritiri.NBANCONOTE)) {
                /* mc_tipo_c.MFB20 := rw_Ritiri.NBANCONOTE */
                mc_tipo_c.row.MFB20 = rw_Ritiri.NBANCONOTE;
              } // End If
              /* ElseIf rw_Ritiri.TAGLIO=50 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,50)) {
              /* mc_tipo_c.BM50 := mc_tipo_c.BM50+rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.BM50 = mc_tipo_c.row.BM50+rw_Ritiri.NBANCONOTE;
              /* If mc_tipo_c.MFB50<rw_Ritiri.NBANCONOTE */
              if (CPLib.lt(mc_tipo_c.row.MFB50,rw_Ritiri.NBANCONOTE)) {
                /* mc_tipo_c.MFB50 := rw_Ritiri.NBANCONOTE */
                mc_tipo_c.row.MFB50 = rw_Ritiri.NBANCONOTE;
              } // End If
              /* ElseIf rw_Ritiri.TAGLIO=100 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,100)) {
              /* mc_tipo_c.BM100 := mc_tipo_c.BM100+rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.BM100 = mc_tipo_c.row.BM100+rw_Ritiri.NBANCONOTE;
              /* If mc_tipo_c.MFB100<rw_Ritiri.NBANCONOTE */
              if (CPLib.lt(mc_tipo_c.row.MFB100,rw_Ritiri.NBANCONOTE)) {
                /* mc_tipo_c.MFB100 := rw_Ritiri.NBANCONOTE */
                mc_tipo_c.row.MFB100 = rw_Ritiri.NBANCONOTE;
              } // End If
              /* ElseIf rw_Ritiri.TAGLIO=200 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,200)) {
              /* mc_tipo_c.BM200 := mc_tipo_c.BM200+rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.BM200 = mc_tipo_c.row.BM200+rw_Ritiri.NBANCONOTE;
              /* If mc_tipo_c.MFB200<rw_Ritiri.NBANCONOTE */
              if (CPLib.lt(mc_tipo_c.row.MFB200,rw_Ritiri.NBANCONOTE)) {
                /* mc_tipo_c.MFB200 := rw_Ritiri.NBANCONOTE */
                mc_tipo_c.row.MFB200 = rw_Ritiri.NBANCONOTE;
              } // End If
              /* ElseIf rw_Ritiri.TAGLIO=500 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,500)) {
              /* mc_tipo_c.BM500 := mc_tipo_c.BM500+rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.BM500 = mc_tipo_c.row.BM500+rw_Ritiri.NBANCONOTE;
              /* If mc_tipo_c.MFB500<rw_Ritiri.NBANCONOTE */
              if (CPLib.lt(mc_tipo_c.row.MFB500,rw_Ritiri.NBANCONOTE)) {
                /* mc_tipo_c.MFB500 := rw_Ritiri.NBANCONOTE */
                mc_tipo_c.row.MFB500 = rw_Ritiri.NBANCONOTE;
              } // End If
            } // End If
          } else { // Else
            /* _idbase := rw_Ritiri.IDBASE */
            _idbase = rw_Ritiri.IDBASE;
            /* mc_tipo_c.AppendWithKey(tmp_key) */
            mc_tipo_c.AppendWithKey(tmp_key);
            /* mc_tipo_c.KEY := tmp_key */
            mc_tipo_c.row.KEY = tmp_key;
            /* mc_tipo_c.GNL := rw_Ritiri.CODICEGLN // GNL Luogo Contazione */
            mc_tipo_c.row.GNL = rw_Ritiri.CODICEGLN;
            /* mc_tipo_c.ISTAT := rw_Ritiri.CODCOMCON // Codice Comune (ISTAT) */
            mc_tipo_c.row.ISTAT = rw_Ritiri.CODCOMCON;
            /* mc_tipo_c.ATECO := iif(Empty(rw_Ritiri.ATTIV),rw_Ritiri.ATECO_CON,rw_Ritiri.ATTIV) // Codice Ateco */
            mc_tipo_c.row.ATECO = (CPLib.Empty(rw_Ritiri.ATTIV)?rw_Ritiri.ATECO_CON:rw_Ritiri.ATTIV);
            /* mc_tipo_c.ABI_P := rw_Ritiri.ABIPROPR // ABI Proprietario */
            mc_tipo_c.row.ABI_P = rw_Ritiri.ABIPROPR;
            /* mc_tipo_c.BM5 := 0 */
            mc_tipo_c.row.BM5 = 0;
            /* mc_tipo_c.BM10 := 0 */
            mc_tipo_c.row.BM10 = 0;
            /* mc_tipo_c.BM20 := 0 */
            mc_tipo_c.row.BM20 = 0;
            /* mc_tipo_c.BM50 := 0 */
            mc_tipo_c.row.BM50 = 0;
            /* mc_tipo_c.BM100 := 0 */
            mc_tipo_c.row.BM100 = 0;
            /* mc_tipo_c.BM200 := 0 */
            mc_tipo_c.row.BM200 = 0;
            /* mc_tipo_c.BM500 := 0 */
            mc_tipo_c.row.BM500 = 0;
            /* mc_tipo_c.MFB5 := 0 */
            mc_tipo_c.row.MFB5 = 0;
            /* mc_tipo_c.MFB10 := 0 */
            mc_tipo_c.row.MFB10 = 0;
            /* mc_tipo_c.MFB20 := 0 */
            mc_tipo_c.row.MFB20 = 0;
            /* mc_tipo_c.MFB50 := 0 */
            mc_tipo_c.row.MFB50 = 0;
            /* mc_tipo_c.MFB100 := 0 */
            mc_tipo_c.row.MFB100 = 0;
            /* mc_tipo_c.MFB200 := 0 */
            mc_tipo_c.row.MFB200 = 0;
            /* mc_tipo_c.MFB500 := 0 */
            mc_tipo_c.row.MFB500 = 0;
            /* mc_tipo_c.DIP_SERV := 1 // Numero di dipendenze Servite */
            mc_tipo_c.row.DIP_SERV = 1;
            /* mc_tipo_c.NUM_OPE := 1 // Numero di operazioni effettuate */
            mc_tipo_c.row.NUM_OPE = 1;
            /* If rw_Ritiri.TAGLIO=5 */
            if (CPLib.eqr(rw_Ritiri.TAGLIO,5)) {
              /* mc_tipo_c.BM5 := rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.BM5 = rw_Ritiri.NBANCONOTE;
              /* mc_tipo_c.MFB5 := rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.MFB5 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=10 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,10)) {
              /* mc_tipo_c.BM10 := rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.BM10 = rw_Ritiri.NBANCONOTE;
              /* mc_tipo_c.MFB10 := rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.MFB10 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=20 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,20)) {
              /* mc_tipo_c.BM20 := rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.BM20 = rw_Ritiri.NBANCONOTE;
              /* mc_tipo_c.MFB20 := rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.MFB20 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=50 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,50)) {
              /* mc_tipo_c.BM50 := rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.BM50 = rw_Ritiri.NBANCONOTE;
              /* mc_tipo_c.MFB50 := rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.MFB50 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=100 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,100)) {
              /* mc_tipo_c.BM100 := rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.BM100 = rw_Ritiri.NBANCONOTE;
              /* mc_tipo_c.MFB100 := rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.MFB100 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=200 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,200)) {
              /* mc_tipo_c.BM200 := rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.BM200 = rw_Ritiri.NBANCONOTE;
              /* mc_tipo_c.MFB200 := rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.MFB200 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=500 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,500)) {
              /* mc_tipo_c.BM500 := rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.BM500 = rw_Ritiri.NBANCONOTE;
              /* mc_tipo_c.MFB500 := rw_Ritiri.NBANCONOTE */
              mc_tipo_c.row.MFB500 = rw_Ritiri.NBANCONOTE;
            } // End If
          } // End If
          /* mc_tipo_c.SaveRow() */
          mc_tipo_c.SaveRow();
          /* Case rw_Ritiri.TIPOSOGGETTO='d' */
        } else if (CPLib.eqr(rw_Ritiri.TIPOSOGGETTO,"d")) {
          /* tmp_key := ''+rw_Ritiri.CODICEGLN+rw_Ritiri.CODCOMCON+_tipoatt */
          tmp_key = ""+rw_Ritiri.CODICEGLN+rw_Ritiri.CODCOMCON+_tipoatt;
          /* If mc_tipo_d.HasKey(tmp_key) */
          if (mc_tipo_d.HasKey(tmp_key)) {
            /* mc_tipo_d.GoToKey(tmp_key) */
            mc_tipo_d.GoToKey(tmp_key);
            /* If rw_Ritiri.IDBASE <> _idbase */
            if (CPLib.ne(rw_Ritiri.IDBASE,_idbase)) {
              /* mc_tipo_d.NUM_OPE := mc_tipo_d.NUM_OPE+1 */
              mc_tipo_d.row.NUM_OPE = mc_tipo_d.row.NUM_OPE+1;
              /* _idbase := rw_Ritiri.IDBASE */
              _idbase = rw_Ritiri.IDBASE;
            } // End If
            /* If rw_Ritiri.TAGLIO=5 */
            if (CPLib.eqr(rw_Ritiri.TAGLIO,5)) {
              /* mc_tipo_d.BM5 := mc_tipo_d.BM5+rw_Ritiri.NBANCONOTE */
              mc_tipo_d.row.BM5 = mc_tipo_d.row.BM5+rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=10 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,10)) {
              /* mc_tipo_d.BM10 := mc_tipo_d.BM10+rw_Ritiri.NBANCONOTE */
              mc_tipo_d.row.BM10 = mc_tipo_d.row.BM10+rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=20 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,20)) {
              /* mc_tipo_d.BM20 := mc_tipo_d.BM20+rw_Ritiri.NBANCONOTE */
              mc_tipo_d.row.BM20 = mc_tipo_d.row.BM20+rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=50 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,50)) {
              /* mc_tipo_d.BM50 := mc_tipo_d.BM50+rw_Ritiri.NBANCONOTE */
              mc_tipo_d.row.BM50 = mc_tipo_d.row.BM50+rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=100 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,100)) {
              /* mc_tipo_d.BM100 := mc_tipo_d.BM100+rw_Ritiri.NBANCONOTE */
              mc_tipo_d.row.BM100 = mc_tipo_d.row.BM100+rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=200 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,200)) {
              /* mc_tipo_d.BM200 := mc_tipo_d.BM200+rw_Ritiri.NBANCONOTE */
              mc_tipo_d.row.BM200 = mc_tipo_d.row.BM200+rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=500 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,500)) {
              /* mc_tipo_d.BM500 := mc_tipo_d.BM500+rw_Ritiri.NBANCONOTE */
              mc_tipo_d.row.BM500 = mc_tipo_d.row.BM500+rw_Ritiri.NBANCONOTE;
            } // End If
          } else { // Else
            /* _idbase := rw_Ritiri.IDBASE */
            _idbase = rw_Ritiri.IDBASE;
            /* mc_tipo_d.AppendWithKey(tmp_key) */
            mc_tipo_d.AppendWithKey(tmp_key);
            /* mc_tipo_d.KEY := tmp_key */
            mc_tipo_d.row.KEY = tmp_key;
            /* mc_tipo_d.ISTAT := rw_Ritiri.CODCOMCON // Codice Comune (ISTAT) */
            mc_tipo_d.row.ISTAT = rw_Ritiri.CODCOMCON;
            /* mc_tipo_d.GNL := rw_Ritiri.CODICEGLN // GNL Luogo di contazione */
            mc_tipo_d.row.GNL = rw_Ritiri.CODICEGLN;
            /* mc_tipo_d.BM5 := 0 */
            mc_tipo_d.row.BM5 = 0;
            /* mc_tipo_d.BM10 := 0 */
            mc_tipo_d.row.BM10 = 0;
            /* mc_tipo_d.BM20 := 0 */
            mc_tipo_d.row.BM20 = 0;
            /* mc_tipo_d.BM50 := 0 */
            mc_tipo_d.row.BM50 = 0;
            /* mc_tipo_d.BM100 := 0 */
            mc_tipo_d.row.BM100 = 0;
            /* mc_tipo_d.BM200 := 0 */
            mc_tipo_d.row.BM200 = 0;
            /* mc_tipo_d.BM500 := 0 */
            mc_tipo_d.row.BM500 = 0;
            /* mc_tipo_d.NUM_OPE := 0 //  (proprietà non richiesta da Banca d'Italia) */
            mc_tipo_d.row.NUM_OPE = 0;
            /* If rw_Ritiri.TAGLIO=5 */
            if (CPLib.eqr(rw_Ritiri.TAGLIO,5)) {
              /* mc_tipo_d.BM5 := rw_Ritiri.NBANCONOTE */
              mc_tipo_d.row.BM5 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=10 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,10)) {
              /* mc_tipo_d.BM10 := rw_Ritiri.NBANCONOTE */
              mc_tipo_d.row.BM10 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=20 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,20)) {
              /* mc_tipo_d.BM20 := rw_Ritiri.NBANCONOTE */
              mc_tipo_d.row.BM20 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=50 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,50)) {
              /* mc_tipo_d.BM50 := rw_Ritiri.NBANCONOTE */
              mc_tipo_d.row.BM50 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=100 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,100)) {
              /* mc_tipo_d.BM100 := rw_Ritiri.NBANCONOTE */
              mc_tipo_d.row.BM100 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=200 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,200)) {
              /* mc_tipo_d.BM200 := rw_Ritiri.NBANCONOTE */
              mc_tipo_d.row.BM200 = rw_Ritiri.NBANCONOTE;
              /* ElseIf rw_Ritiri.TAGLIO=500 */
            } else if (CPLib.eqr(rw_Ritiri.TAGLIO,500)) {
              /* mc_tipo_d.BM500 := rw_Ritiri.NBANCONOTE */
              mc_tipo_d.row.BM500 = rw_Ritiri.NBANCONOTE;
            } // End If
          } // End If
          /* mc_tipo_d.SaveRow() */
          mc_tipo_d.SaveRow();
        } // End Case
      }
      /* Prelievo il numero di operazioni effettuate e le dipendenze servite per le Dipendenze Bancarie (altrimenti conteggia ogni taglio di ogni operazione come singola operazione) */
      /* gMsgProc := gMsgProc + arfn_fdatetime(DateTime())+' Prelievo dati aggiuntivi Dipendenze Bancarie:  '+mc_tipo_a.RecCount()+ NL */
      gMsgProc = gMsgProc+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Prelievo dati aggiuntivi Dipendenze Bancarie:  "+mc_tipo_a.RecCount()+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* cnt := 1 */
      cnt = CPLib.Round(1,0);
      /* tot := mc_tipo_a.RecCount() */
      tot = CPLib.Round(mc_tipo_a.RecCount(),0);
      /* mc_tipo_a.GoTop() */
      mc_tipo_a.GoTop();
      /* While not(mc_tipo_a.Eof()) */
      while ( ! (mc_tipo_a.Eof())) {
        /* gMsgImp := Str(((cnt/tot)*100), 6,3)+'% Analisi Dipendenze Bancarie' */
        gMsgImp = CPLib.Str(((cnt/tot)*100),6,3)+"% Analisi Dipendenze Bancarie";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from qbe_estr_trim_agg_a_numdipe
        SPBridge.HMCaller _h00000154;
        _h00000154 = new SPBridge.HMCaller();
        _h00000154.Set("m_cVQRList",m_cVQRList);
        _h00000154.Set("tipoAttivita",_tipoatt);
        _h00000154.Set("gln",mc_tipo_a.row.GNL);
        _h00000154.Set("istat",mc_tipo_a.row.ISTAT);
        _h00000154.Set("abi_inter",mc_tipo_a.row.CAB);
        _h00000154.Set("abi_pro",mc_tipo_a.row.ABI_P);
        _h00000154.Set("tipoattiv",mc_tipo_a.row.TIPO_ATT);
        _h00000154.Set("rap_segna",mc_tipo_a.row.TIPO_RAPP);
        _h00000154.Set("daData",c_DataBegin);
        _h00000154.Set("aData",c_DataEnd);
        if (Cursor_qbe_estr_trim_agg_a_numdipe!=null)
          Cursor_qbe_estr_trim_agg_a_numdipe.Close();
        Cursor_qbe_estr_trim_agg_a_numdipe = new VQRHolder("qbe_estr_trim_agg_a_numdipe",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000154,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_estr_trim_agg_a_numdipe.Eof())) {
          /* mc_tipo_a.DIP_SERV := qbe_estr_trim_agg_a_numdipe->TOTALE */
          mc_tipo_a.row.DIP_SERV = Cursor_qbe_estr_trim_agg_a_numdipe.GetDouble("TOTALE");
          Cursor_qbe_estr_trim_agg_a_numdipe.Next();
        }
        m_cConnectivityError = Cursor_qbe_estr_trim_agg_a_numdipe.ErrorMessage();
        Cursor_qbe_estr_trim_agg_a_numdipe.Close();
        // * --- End Select
        /* mc_tipo_a.SaveRow() */
        mc_tipo_a.SaveRow();
        /* mc_tipo_a.Next() */
        mc_tipo_a.Next();
        /* cnt := cnt+1 */
        cnt = CPLib.Round(cnt+1,0);
      } // End While
      /* Prelievo il numero di operazioni per le GDO */
      /* gMsgProc := gMsgProc + arfn_fdatetime(DateTime())+' Prelievo dati aggiuntivi GDO:  '+ mc_tipo_c.RecCount() + NL */
      gMsgProc = gMsgProc+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Prelievo dati aggiuntivi GDO:  "+mc_tipo_c.RecCount()+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* cnt := 1 */
      cnt = CPLib.Round(1,0);
      /* tot := mc_tipo_c.RecCount() */
      tot = CPLib.Round(mc_tipo_c.RecCount(),0);
      /* mc_tipo_c.GoTop() */
      mc_tipo_c.GoTop();
      /* While not(mc_tipo_c.Eof()) */
      while ( ! (mc_tipo_c.Eof())) {
        /* gMsgImp := Str(((cnt/tot)*100), 6,3)+'% Analisi GDO' */
        gMsgImp = CPLib.Str(((cnt/tot)*100),6,3)+"% Analisi GDO";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from qbe_estr_trim_agg_c_numdipe
        SPBridge.HMCaller _h00000160;
        _h00000160 = new SPBridge.HMCaller();
        _h00000160.Set("m_cVQRList",m_cVQRList);
        _h00000160.Set("tipoAttivita",_tipoatt);
        _h00000160.Set("gln",mc_tipo_c.row.GNL);
        _h00000160.Set("istat",mc_tipo_c.row.ISTAT);
        _h00000160.Set("abi_pro",mc_tipo_c.row.ABI_P);
        _h00000160.Set("ateco",mc_tipo_c.row.ATECO);
        _h00000160.Set("daData",c_DataBegin);
        _h00000160.Set("aData",c_DataEnd);
        if (Cursor_qbe_estr_trim_agg_c_numdipe!=null)
          Cursor_qbe_estr_trim_agg_c_numdipe.Close();
        Cursor_qbe_estr_trim_agg_c_numdipe = new VQRHolder("qbe_estr_trim_agg_c_numdipe",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000160,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_estr_trim_agg_c_numdipe.Eof())) {
          /* mc_tipo_c.DIP_SERV := qbe_estr_trim_agg_c_numdipe->TOTALE */
          mc_tipo_c.row.DIP_SERV = Cursor_qbe_estr_trim_agg_c_numdipe.GetDouble("TOTALE");
          Cursor_qbe_estr_trim_agg_c_numdipe.Next();
        }
        m_cConnectivityError = Cursor_qbe_estr_trim_agg_c_numdipe.ErrorMessage();
        Cursor_qbe_estr_trim_agg_c_numdipe.Close();
        // * --- End Select
        /* mc_tipo_c.SaveRow() */
        mc_tipo_c.SaveRow();
        /* mc_tipo_c.Next() */
        mc_tipo_c.Next();
        /* cnt := cnt+1 */
        cnt = CPLib.Round(cnt+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_estr_trim!=null)
          Cursor_qbe_estr_trim.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estr_trim_agg_a_numdipe!=null)
          Cursor_qbe_estr_trim_agg_a_numdipe.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estr_trim_agg_c_numdipe!=null)
          Cursor_qbe_estr_trim_agg_c_numdipe.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void CreateXML() throws Exception {
    /* Stampa dell'XML */
    /* fileName := w_anno+"Q"+w_trimestre+_tipoatt+".xml" // "2020Q1RIT.xml" */
    fileName = w_anno+"Q"+w_trimestre+_tipoatt+".xml";
    /* gMsgProc := gMsgProc + arfn_fdatetime(DateTime())+' Inizio processo creazione file: ' +fileName+ NL */
    gMsgProc = gMsgProc+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Inizio processo creazione file: "+fileName+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+'/export/'+LRTrim(gAzienda)+"/"+LRTrim(fileName)) */
    fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(fileName));
    // Aggiunge elementi vettore per creazione zip
    filenames.add(CPLib.LRTrim(CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(fileName)));
    fileonames.add(CPLib.LRTrim(fileName));
    /* _testo := '<?xml version="1.0" encoding="UTF-8"?>' + NL */
    _testo = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\n";
    /* _testo := _testo + '<BdI:segnalazione xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:BdI="http://CASH.bancaditalia.it/Schema/SovvenzioniRititri" xsi:type="BdI:SegnalazioneRitiriType" PeriodoSegnalazione="'+w_anno+"-Q"+w_trimestre+'" TipoSegnalazione="'+_tipoatt+'" xsi:schemaLocation="http://CASH.bancaditalia.it/Schema/SovvenzioniRititri Schema_AML_%20INDACO_V1.0.xsd">'+NL */
    _testo = _testo+"<BdI:segnalazione xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:BdI=\"http://CASH.bancaditalia.it/Schema/SovvenzioniRititri\" xsi:type=\"BdI:SegnalazioneRitiriType\" PeriodoSegnalazione=\""+w_anno+"-Q"+w_trimestre+"\" TipoSegnalazione=\""+_tipoatt+"\" xsi:schemaLocation=\"http://CASH.bancaditalia.it/Schema/SovvenzioniRititri Schema_AML_%20INDACO_V1.0.xsd\">"+"\n";
    /* _testo := _testo+'<BdI:segnalazioneContent>'+NL */
    _testo = _testo+"<BdI:segnalazioneContent>"+"\n";
    /* _testo := _testo+'<BdI:Ente_Segnalante GLNSegnalante="'+GLNSegnalante+'">'+NL */
    _testo = _testo+"<BdI:Ente_Segnalante GLNSegnalante=\""+GLNSegnalante+"\">"+"\n";
    /* FileLibMit.Write(fhand,_testo) */
    FileLibMit.Write(fhand,_testo);
    /* count Numeric(5, 0) */
    /* first_print Bool */
    /* count := 1 */
    count = CPLib.Round(1,0);
    for (MemoryCursorRow_mc_app_stp_estr_trim_mcrdef rw_gnl : _GLN_stampa._iterable_()) {
      /* _testo := '<BdI:LuogoContazione GLNLuogoContazione="'+rw_gnl.GLN+'">'+NL */
      _testo = "<BdI:LuogoContazione GLNLuogoContazione=\""+rw_gnl.GLN+"\">"+"\n";
      /* FileLibMit.Write(fhand,_testo) */
      FileLibMit.Write(fhand,_testo);
      for (MemoryCursorRow_mc_app_stp_estr_trim2_mcrdef rw_istat : _ISTAT_stampa._iterable_()) {
        /* first_print := True */
        first_print = true;
        for (MemoryCursorRow_mc_tipoa_dipe_banca_mcrdef rw_a : mc_tipo_a._iterable_()) {
          /* If rw_a.GNL=rw_gnl.GLN and rw_a.ISTAT=rw_istat.ISTAT */
          if (CPLib.eqr(rw_a.GNL,rw_gnl.GLN) && CPLib.eqr(rw_a.ISTAT,rw_istat.ISTAT)) {
            /* If first_print */
            if (first_print) {
              /* _testo := '<BdI:Territorio_Nazionale Cod_Comune="'+rw_istat.ISTAT+'">'+NL */
              _testo = "<BdI:Territorio_Nazionale Cod_Comune=\""+rw_istat.ISTAT+"\">"+"\n";
              /* FileLibMit.Write(fhand,_testo) */
              FileLibMit.Write(fhand,_testo);
              /* first_print := False */
              first_print = false;
            } // End If
            /* _testo := '<BdI:dipendenzeBancarie>'+NL */
            _testo = "<BdI:dipendenzeBancarie>"+"\n";
            /* _testo := _testo+'<BdI:ABIBanca>'+rw_a.CAB+'</BdI:ABIBanca>'+NL */
            _testo = _testo+"<BdI:ABIBanca>"+rw_a.CAB+"</BdI:ABIBanca>"+"\n";
            /* _testo := _testo+'<BdI:RapportoConSegnalante>'+rw_a.TIPO_RAPP+'</BdI:RapportoConSegnalante>'+NL */
            _testo = _testo+"<BdI:RapportoConSegnalante>"+rw_a.TIPO_RAPP+"</BdI:RapportoConSegnalante>"+"\n";
            /* _testo := _testo+'<BdI:TipologiAttivita>'+rw_a.TIPO_ATT+'</BdI:TipologiAttivita>'+NL */
            _testo = _testo+"<BdI:TipologiAttivita>"+rw_a.TIPO_ATT+"</BdI:TipologiAttivita>"+"\n";
            /* _testo := _testo+'<BdI:ABIProprietarioBanconote>'+rw_a.ABI_P+'</BdI:ABIProprietarioBanconote>'+NL */
            _testo = _testo+"<BdI:ABIProprietarioBanconote>"+rw_a.ABI_P+"</BdI:ABIProprietarioBanconote>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="5">'+LTrim(Str(rw_a.BM5,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"5\">"+CPLib.LTrim(CPLib.Str(rw_a.BM5,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="10">'+LTrim(Str(rw_a.BM10,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"10\">"+CPLib.LTrim(CPLib.Str(rw_a.BM10,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="20">'+LTrim(Str(rw_a.BM20,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"20\">"+CPLib.LTrim(CPLib.Str(rw_a.BM20,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="50">'+LTrim(Str(rw_a.BM50,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"50\">"+CPLib.LTrim(CPLib.Str(rw_a.BM50,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="100">'+LTrim(Str(rw_a.BM100,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"100\">"+CPLib.LTrim(CPLib.Str(rw_a.BM100,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="200">'+LTrim(Str(rw_a.BM200,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"200\">"+CPLib.LTrim(CPLib.Str(rw_a.BM200,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="500">'+LTrim(Str(rw_a.BM500,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"500\">"+CPLib.LTrim(CPLib.Str(rw_a.BM500,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_MassimoFlussoBanconote TaglioBanconote="5">'+LTrim(Str(rw_a.MFB5,10,0))+'</BdI:QTA_MassimoFlussoBanconote>'+NL */
            _testo = _testo+"<BdI:QTA_MassimoFlussoBanconote TaglioBanconote=\"5\">"+CPLib.LTrim(CPLib.Str(rw_a.MFB5,10,0))+"</BdI:QTA_MassimoFlussoBanconote>"+"\n";
            /* _testo := _testo+'<BdI:QTA_MassimoFlussoBanconote TaglioBanconote="10">'+LTrim(Str(rw_a.MFB10,10,0))+'</BdI:QTA_MassimoFlussoBanconote>'+NL */
            _testo = _testo+"<BdI:QTA_MassimoFlussoBanconote TaglioBanconote=\"10\">"+CPLib.LTrim(CPLib.Str(rw_a.MFB10,10,0))+"</BdI:QTA_MassimoFlussoBanconote>"+"\n";
            /* _testo := _testo+'<BdI:QTA_MassimoFlussoBanconote TaglioBanconote="20">'+LTrim(Str(rw_a.MFB20,10,0))+'</BdI:QTA_MassimoFlussoBanconote>'+NL */
            _testo = _testo+"<BdI:QTA_MassimoFlussoBanconote TaglioBanconote=\"20\">"+CPLib.LTrim(CPLib.Str(rw_a.MFB20,10,0))+"</BdI:QTA_MassimoFlussoBanconote>"+"\n";
            /* _testo := _testo+'<BdI:QTA_MassimoFlussoBanconote TaglioBanconote="50">'+LTrim(Str(rw_a.MFB50,10,0))+'</BdI:QTA_MassimoFlussoBanconote>'+NL */
            _testo = _testo+"<BdI:QTA_MassimoFlussoBanconote TaglioBanconote=\"50\">"+CPLib.LTrim(CPLib.Str(rw_a.MFB50,10,0))+"</BdI:QTA_MassimoFlussoBanconote>"+"\n";
            /* _testo := _testo+'<BdI:QTA_MassimoFlussoBanconote TaglioBanconote="100">'+LTrim(Str(rw_a.MFB100,10,0))+'</BdI:QTA_MassimoFlussoBanconote>'+NL */
            _testo = _testo+"<BdI:QTA_MassimoFlussoBanconote TaglioBanconote=\"100\">"+CPLib.LTrim(CPLib.Str(rw_a.MFB100,10,0))+"</BdI:QTA_MassimoFlussoBanconote>"+"\n";
            /* _testo := _testo+'<BdI:QTA_MassimoFlussoBanconote TaglioBanconote="200">'+LTrim(Str(rw_a.MFB200,10,0))+'</BdI:QTA_MassimoFlussoBanconote>'+NL */
            _testo = _testo+"<BdI:QTA_MassimoFlussoBanconote TaglioBanconote=\"200\">"+CPLib.LTrim(CPLib.Str(rw_a.MFB200,10,0))+"</BdI:QTA_MassimoFlussoBanconote>"+"\n";
            /* _testo := _testo+'<BdI:QTA_MassimoFlussoBanconote TaglioBanconote="500">'+LTrim(Str(rw_a.MFB500,10,0))+'</BdI:QTA_MassimoFlussoBanconote>'+NL */
            _testo = _testo+"<BdI:QTA_MassimoFlussoBanconote TaglioBanconote=\"500\">"+CPLib.LTrim(CPLib.Str(rw_a.MFB500,10,0))+"</BdI:QTA_MassimoFlussoBanconote>"+"\n";
            /* _testo := _testo+'<BdI:DipendenzeServite>'+LTrim(Str(rw_a.DIP_SERV,10,0))+'</BdI:DipendenzeServite>'+NL */
            _testo = _testo+"<BdI:DipendenzeServite>"+CPLib.LTrim(CPLib.Str(rw_a.DIP_SERV,10,0))+"</BdI:DipendenzeServite>"+"\n";
            /* _testo := _testo+'<BdI:NumeroOperazioni>'+LTrim(Str(rw_a.NUM_OPE,10,0))+'</BdI:NumeroOperazioni>'+NL */
            _testo = _testo+"<BdI:NumeroOperazioni>"+CPLib.LTrim(CPLib.Str(rw_a.NUM_OPE,10,0))+"</BdI:NumeroOperazioni>"+"\n";
            /* _testo := _testo+'</BdI:dipendenzeBancarie>'+NL */
            _testo = _testo+"</BdI:dipendenzeBancarie>"+"\n";
            /* FileLibMit.Write(fhand,_testo) */
            FileLibMit.Write(fhand,_testo);
          } // End If
        }
        for (MemoryCursorRow_mc_tipoc_gdo_mcrdef rw_c : mc_tipo_c._iterable_()) {
          /* If rw_c.GNL=rw_gnl.GLN and rw_c.ISTAT=rw_istat.ISTAT */
          if (CPLib.eqr(rw_c.GNL,rw_gnl.GLN) && CPLib.eqr(rw_c.ISTAT,rw_istat.ISTAT)) {
            /* If first_print */
            if (first_print) {
              /* _testo := '<BdI:Territorio_Nazionale Cod_Comune="'+rw_istat.ISTAT+'">'+NL */
              _testo = "<BdI:Territorio_Nazionale Cod_Comune=\""+rw_istat.ISTAT+"\">"+"\n";
              /* FileLibMit.Write(fhand,_testo) */
              FileLibMit.Write(fhand,_testo);
              /* first_print := False */
              first_print = false;
            } // End If
            /* _testo := '<BdI:GDO ATECO="'+Left(rw_c.ATECO,2)+'.'+Substr(rw_c.ATECO,3,2)+'.'+Right(LRTrim(rw_c.ATECO),2)+'" NumeroOperazioni="'+LTrim(Str(rw_c.NUM_OPE,10,0))+'" PuntiServiti="'+LTrim(Str(rw_c.DIP_SERV,10,0))+'">'+NL */
            _testo = "<BdI:GDO ATECO=\""+CPLib.Left(rw_c.ATECO,2)+"."+CPLib.Substr(rw_c.ATECO,3,2)+"."+CPLib.Right(CPLib.LRTrim(rw_c.ATECO),2)+"\" NumeroOperazioni=\""+CPLib.LTrim(CPLib.Str(rw_c.NUM_OPE,10,0))+"\" PuntiServiti=\""+CPLib.LTrim(CPLib.Str(rw_c.DIP_SERV,10,0))+"\">"+"\n";
            /* _testo := _testo+'<BdI:ABIProprietarioBanconote>'+rw_c.ABI_P+'</BdI:ABIProprietarioBanconote>'+NL */
            _testo = _testo+"<BdI:ABIProprietarioBanconote>"+rw_c.ABI_P+"</BdI:ABIProprietarioBanconote>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="5">'+LTrim(Str(rw_c.BM5,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"5\">"+CPLib.LTrim(CPLib.Str(rw_c.BM5,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="10">'+LTrim(Str(rw_c.BM10,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"10\">"+CPLib.LTrim(CPLib.Str(rw_c.BM10,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="20">'+LTrim(Str(rw_c.BM20,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"20\">"+CPLib.LTrim(CPLib.Str(rw_c.BM20,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="50">'+LTrim(Str(rw_c.BM50,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"50\">"+CPLib.LTrim(CPLib.Str(rw_c.BM50,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="100">'+LTrim(Str(rw_c.BM100,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"100\">"+CPLib.LTrim(CPLib.Str(rw_c.BM100,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="200">'+LTrim(Str(rw_c.BM200,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"200\">"+CPLib.LTrim(CPLib.Str(rw_c.BM200,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="500">'+LTrim(Str(rw_c.BM500,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"500\">"+CPLib.LTrim(CPLib.Str(rw_c.BM500,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_MassimoFlussoBanconote TaglioBanconote="5">'+LTrim(Str(rw_c.MFB5,10,0))+'</BdI:QTA_MassimoFlussoBanconote>'+NL */
            _testo = _testo+"<BdI:QTA_MassimoFlussoBanconote TaglioBanconote=\"5\">"+CPLib.LTrim(CPLib.Str(rw_c.MFB5,10,0))+"</BdI:QTA_MassimoFlussoBanconote>"+"\n";
            /* _testo := _testo+'<BdI:QTA_MassimoFlussoBanconote TaglioBanconote="10">'+LTrim(Str(rw_c.MFB10,10,0))+'</BdI:QTA_MassimoFlussoBanconote>'+NL */
            _testo = _testo+"<BdI:QTA_MassimoFlussoBanconote TaglioBanconote=\"10\">"+CPLib.LTrim(CPLib.Str(rw_c.MFB10,10,0))+"</BdI:QTA_MassimoFlussoBanconote>"+"\n";
            /* _testo := _testo+'<BdI:QTA_MassimoFlussoBanconote TaglioBanconote="20">'+LTrim(Str(rw_c.MFB20,10,0))+'</BdI:QTA_MassimoFlussoBanconote>'+NL */
            _testo = _testo+"<BdI:QTA_MassimoFlussoBanconote TaglioBanconote=\"20\">"+CPLib.LTrim(CPLib.Str(rw_c.MFB20,10,0))+"</BdI:QTA_MassimoFlussoBanconote>"+"\n";
            /* _testo := _testo+'<BdI:QTA_MassimoFlussoBanconote TaglioBanconote="50">'+LTrim(Str(rw_c.MFB50,10,0))+'</BdI:QTA_MassimoFlussoBanconote>'+NL */
            _testo = _testo+"<BdI:QTA_MassimoFlussoBanconote TaglioBanconote=\"50\">"+CPLib.LTrim(CPLib.Str(rw_c.MFB50,10,0))+"</BdI:QTA_MassimoFlussoBanconote>"+"\n";
            /* _testo := _testo+'<BdI:QTA_MassimoFlussoBanconote TaglioBanconote="100">'+LTrim(Str(rw_c.MFB100,10,0))+'</BdI:QTA_MassimoFlussoBanconote>'+NL */
            _testo = _testo+"<BdI:QTA_MassimoFlussoBanconote TaglioBanconote=\"100\">"+CPLib.LTrim(CPLib.Str(rw_c.MFB100,10,0))+"</BdI:QTA_MassimoFlussoBanconote>"+"\n";
            /* _testo := _testo+'<BdI:QTA_MassimoFlussoBanconote TaglioBanconote="200">'+LTrim(Str(rw_c.MFB200,10,0))+'</BdI:QTA_MassimoFlussoBanconote>'+NL */
            _testo = _testo+"<BdI:QTA_MassimoFlussoBanconote TaglioBanconote=\"200\">"+CPLib.LTrim(CPLib.Str(rw_c.MFB200,10,0))+"</BdI:QTA_MassimoFlussoBanconote>"+"\n";
            /* _testo := _testo+'<BdI:QTA_MassimoFlussoBanconote TaglioBanconote="500">'+LTrim(Str(rw_c.MFB500,10,0))+'</BdI:QTA_MassimoFlussoBanconote>'+NL */
            _testo = _testo+"<BdI:QTA_MassimoFlussoBanconote TaglioBanconote=\"500\">"+CPLib.LTrim(CPLib.Str(rw_c.MFB500,10,0))+"</BdI:QTA_MassimoFlussoBanconote>"+"\n";
            /* _testo := _testo+'</BdI:GDO>'+NL */
            _testo = _testo+"</BdI:GDO>"+"\n";
            /* FileLibMit.Write(fhand,_testo) */
            FileLibMit.Write(fhand,_testo);
          } // End If
        }
        for (MemoryCursorRow_mc_tipob_altra_cit_mcrdef rw_b : mc_tipo_b._iterable_()) {
          /* If rw_b.GNL=rw_gnl.GLN and rw_b.ISTAT=rw_istat.ISTAT */
          if (CPLib.eqr(rw_b.GNL,rw_gnl.GLN) && CPLib.eqr(rw_b.ISTAT,rw_istat.ISTAT)) {
            /* If first_print */
            if (first_print) {
              /* _testo := '<BdI:Territorio_Nazionale Cod_Comune="'+rw_istat.ISTAT+'">'+NL */
              _testo = "<BdI:Territorio_Nazionale Cod_Comune=\""+rw_istat.ISTAT+"\">"+"\n";
              /* FileLibMit.Write(fhand,_testo) */
              FileLibMit.Write(fhand,_testo);
              /* first_print := False */
              first_print = false;
            } // End If
            /* _testo := '<BdI:altraCIT GLNCIT="'+rw_b.GNLCIT+'" GLNSalaConta="'+rw_b.GNLCITSALA+'" NumeroOperazioni="'+LTrim(Str(rw_b.NUM_OPE,10,0))+'">'+NL */
            _testo = "<BdI:altraCIT GLNCIT=\""+rw_b.GNLCIT+"\" GLNSalaConta=\""+rw_b.GNLCITSALA+"\" NumeroOperazioni=\""+CPLib.LTrim(CPLib.Str(rw_b.NUM_OPE,10,0))+"\">"+"\n";
            /* _testo := _testo+'<BdI:ABIProprietarioBanconote>'+rw_b.ABI_P+'</BdI:ABIProprietarioBanconote>'+NL */
            _testo = _testo+"<BdI:ABIProprietarioBanconote>"+rw_b.ABI_P+"</BdI:ABIProprietarioBanconote>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="5">'+LTrim(Str(rw_b.BM5,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"5\">"+CPLib.LTrim(CPLib.Str(rw_b.BM5,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="10">'+LTrim(Str(rw_b.BM10,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"10\">"+CPLib.LTrim(CPLib.Str(rw_b.BM10,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="20">'+LTrim(Str(rw_b.BM20,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"20\">"+CPLib.LTrim(CPLib.Str(rw_b.BM20,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="50">'+LTrim(Str(rw_b.BM50,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"50\">"+CPLib.LTrim(CPLib.Str(rw_b.BM50,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="100">'+LTrim(Str(rw_b.BM100,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"100\">"+CPLib.LTrim(CPLib.Str(rw_b.BM100,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="200">'+LTrim(Str(rw_b.BM200,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"200\">"+CPLib.LTrim(CPLib.Str(rw_b.BM200,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="500">'+LTrim(Str(rw_b.BM500,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"500\">"+CPLib.LTrim(CPLib.Str(rw_b.BM500,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'</BdI:altraCIT>'+NL */
            _testo = _testo+"</BdI:altraCIT>"+"\n";
            /* FileLibMit.Write(fhand,_testo) */
            FileLibMit.Write(fhand,_testo);
          } // End If
        }
        for (MemoryCursorRow_mc_tipod_altri_sogg_mcrdef rw_d : mc_tipo_d._iterable_()) {
          /* If rw_d.GNL=rw_gnl.GLN and rw_d.ISTAT=rw_istat.ISTAT */
          if (CPLib.eqr(rw_d.GNL,rw_gnl.GLN) && CPLib.eqr(rw_d.ISTAT,rw_istat.ISTAT)) {
            /* If first_print */
            if (first_print) {
              /* _testo := '<BdI:Territorio_Nazionale Cod_Comune="'+rw_istat.ISTAT+'">'+NL */
              _testo = "<BdI:Territorio_Nazionale Cod_Comune=\""+rw_istat.ISTAT+"\">"+"\n";
              /* FileLibMit.Write(fhand,_testo) */
              FileLibMit.Write(fhand,_testo);
              /* first_print := False */
              first_print = false;
            } // End If
            /* _testo := '<BdI:altriSoggetti>'+NL */
            _testo = "<BdI:altriSoggetti>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="5">'+LTrim(Str(rw_d.BM5,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"5\">"+CPLib.LTrim(CPLib.Str(rw_d.BM5,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="10">'+LTrim(Str(rw_d.BM10,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"10\">"+CPLib.LTrim(CPLib.Str(rw_d.BM10,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="20">'+LTrim(Str(rw_d.BM20,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"20\">"+CPLib.LTrim(CPLib.Str(rw_d.BM20,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="50">'+LTrim(Str(rw_d.BM50,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"50\">"+CPLib.LTrim(CPLib.Str(rw_d.BM50,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="100">'+LTrim(Str(rw_d.BM100,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"100\">"+CPLib.LTrim(CPLib.Str(rw_d.BM100,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="200">'+LTrim(Str(rw_d.BM200,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"200\">"+CPLib.LTrim(CPLib.Str(rw_d.BM200,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'<BdI:QTA_BanconoteMovimentate TaglioBanconote="500">'+LTrim(Str(rw_d.BM500,10,0))+'</BdI:QTA_BanconoteMovimentate>'+NL */
            _testo = _testo+"<BdI:QTA_BanconoteMovimentate TaglioBanconote=\"500\">"+CPLib.LTrim(CPLib.Str(rw_d.BM500,10,0))+"</BdI:QTA_BanconoteMovimentate>"+"\n";
            /* _testo := _testo+'</BdI:altriSoggetti>'+NL */
            _testo = _testo+"</BdI:altriSoggetti>"+"\n";
            /* FileLibMit.Write(fhand,_testo) */
            FileLibMit.Write(fhand,_testo);
          } // End If
        }
        /* If not(first_print) */
        if ( ! (first_print)) {
          /* _testo := '</BdI:Territorio_Nazionale>'+NL */
          _testo = "</BdI:Territorio_Nazionale>"+"\n";
          /* FileLibMit.Write(fhand,_testo) */
          FileLibMit.Write(fhand,_testo);
        } // End If
      }
      /* _testo := '</BdI:LuogoContazione>'+NL */
      _testo = "</BdI:LuogoContazione>"+"\n";
      /* FileLibMit.Write(fhand,_testo) */
      FileLibMit.Write(fhand,_testo);
    }
    /* _testo := '</BdI:Ente_Segnalante>'+NL */
    _testo = "</BdI:Ente_Segnalante>"+"\n";
    /* _testo := _testo+'</BdI:segnalazioneContent>'+NL */
    _testo = _testo+"</BdI:segnalazioneContent>"+"\n";
    /* _testo := _testo+'</BdI:segnalazione>'+NL */
    _testo = _testo+"</BdI:segnalazione>"+"\n";
    /* FileLibMit.Write(fhand,_testo) */
    FileLibMit.Write(fhand,_testo);
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* gMsgProc := gMsgProc + arfn_fdatetime(DateTime())+' Fine processo creazione file: ' +fileName+ NL */
    gMsgProc = gMsgProc+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Fine processo creazione file: "+fileName+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
  }
  void CreateZIP() throws Exception {
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
            }
        
            // Complete the ZIP file
            out.close();
            filenames.removeAllElements();
            fileonames.removeAllElements();
        } catch (java.io.IOException e) {
        }
    
  }
  void EstraiXLS() throws Exception {
    /* Stampa dell'XLSX */
    /* fileName := w_anno+"Q"+w_trimestre+_tipoatt+".xlsx" // "2020Q1RIT.xml" */
    fileName = w_anno+"Q"+w_trimestre+_tipoatt+".xlsx";
    /* gMsgProc := gMsgProc + arfn_fdatetime(DateTime())+' Inizio processo creazione file: ' +fileName+ NL */
    gMsgProc = gMsgProc+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Inizio processo creazione file: "+fileName+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    // Aggiunge elementi vettore per creazione zip
    filenames.add(CPLib.LRTrim(CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(fileName)));
    fileonames.add(CPLib.LRTrim(fileName));
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
    cell.setCellValue("Tipo Attività");
    cell.setCellStyle(cs);
    cell =  row.createCell(1);
    cell.setCellValue("ATECO");
    cell.setCellStyle(cs);
    cell = row.createCell(2);
    cell.setCellValue("Codice ABI");
    cell.setCellStyle(cs);
    cell = row.createCell(3);
    cell.setCellValue("GLN CIT");
    cell.setCellStyle(cs);
    cell = row.createCell(4);
    cell.setCellValue("GLN Sala Conta");
    cell.setCellStyle(cs);
    cell = row.createCell(5);
    cell.setCellValue("Comune/Stato Estero");
    cell.setCellStyle(cs);
    cell = row.createCell(6);
    cell.setCellValue("Rapporto con il segnalante");
    cell.setCellStyle(cs);
    cell = row.createCell(7);
    cell.setCellValue("ABI Proprietario");
    cell.setCellStyle(cs);
    cell = row.createCell(8);
    cell.setCellValue("Tipologia Attività");
    cell.setCellStyle(cs);
    cell = row.createCell(9);
    cell.setCellValue("Taglio 5");
    cell.setCellStyle(cs);
    cell = row.createCell(10);
    cell.setCellValue("Taglio 10");
    cell.setCellStyle(cs);
    cell = row.createCell(11);
    cell.setCellValue("Taglio 20");
    cell.setCellStyle(cs);
    cell = row.createCell(12);
    cell.setCellValue("Taglio 50");
    cell.setCellStyle(cs);
    cell = row.createCell(13);
    cell.setCellValue("Taglio 100");
    cell.setCellStyle(cs);
    cell = row.createCell(14);
    cell.setCellValue("Taglio 200");
    cell.setCellStyle(cs);
    cell = row.createCell(15);
    cell.setCellValue("Taglio 500");
    cell.setCellStyle(cs);
    cell = row.createCell(16);
    cell.setCellValue("Massimo Flusso Taglio 5");
    cell.setCellStyle(cs);
    cell = row.createCell(17);
    cell.setCellValue("Massimo Flusso Taglio 10");
    cell.setCellStyle(cs);
    cell = row.createCell(18);
    cell.setCellValue("Massimo Flusso Taglio 20");
    cell.setCellStyle(cs);
    cell = row.createCell(19);
    cell.setCellValue("Massimo Flusso Taglio 50");
    cell.setCellStyle(cs);
    cell = row.createCell(20);
    cell.setCellValue("Massimo Flusso Taglio 100");
    cell.setCellStyle(cs);
    cell = row.createCell(21);
    cell.setCellValue("Massimo Flusso Taglio 200");
    cell.setCellStyle(cs);
    cell = row.createCell(22);
    cell.setCellValue("Massimo Flusso Taglio 500");
    cell.setCellStyle(cs);
    cell = row.createCell(23);
    cell.setCellValue("Numero Punti/Dipendenze Servite");
    cell.setCellStyle(cs);
    cell = row.createCell(24);
    cell.setCellValue("Numero Operazioni");
    cell.setCellStyle(cs);
    r=r+1;
    for (MemoryCursorRow_mc_app_stp_estr_trim_mcrdef rw_gnl : _GLN_stampa._iterable_()) {
      for (MemoryCursorRow_mc_app_stp_estr_trim2_mcrdef rw_istat : _ISTAT_stampa._iterable_()) {
        for (MemoryCursorRow_mc_tipoa_dipe_banca_mcrdef rw_a : mc_tipo_a._iterable_()) {
          /* If rw_a.GNL=rw_gnl.GLN and rw_a.ISTAT=rw_istat.ISTAT */
          if (CPLib.eqr(rw_a.GNL,rw_gnl.GLN) && CPLib.eqr(rw_a.ISTAT,rw_istat.ISTAT)) {
            //Creo il record da scrivere
            row = sheet.createRow(r);
            cell = row.createCell(0);
            cell.setCellValue(_tipoatt);
            cell = row.createCell(2);
            cell.setCellValue(rw_a.CAB);
            cell = row.createCell(5);
            cell.setCellValue(rw_a.ISTAT);
            cell = row.createCell(6);
            cell.setCellValue(rw_a.TIPO_RAPP);
            cell = row.createCell(7);
            cell.setCellValue(rw_a.ABI_P);
            cell = row.createCell(8);
            cell.setCellValue(rw_a.TIPO_ATT);
            cell = row.createCell(9);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_a.BM5,10,0)));
            cell = row.createCell(10);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_a.BM10,10,0)));
            cell = row.createCell(11);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_a.BM20,10,0)));
            cell = row.createCell(12);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_a.BM50,10,0)));
            cell = row.createCell(13);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_a.BM100,10,0)));
            cell = row.createCell(14);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_a.BM200,10,0)));
            cell = row.createCell(15);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_a.BM500,10,0)));
            cell = row.createCell(16);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_a.MFB5,10,0)));
            cell = row.createCell(17);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_a.MFB10,10,0)));
            cell = row.createCell(18);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_a.MFB20,10,0)));
            cell = row.createCell(19);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_a.MFB50,10,0)));
            cell = row.createCell(20);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_a.MFB100,10,0)));
            cell = row.createCell(21);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_a.MFB200,10,0)));
            cell = row.createCell(22);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_a.MFB500,10,0)));
            cell = row.createCell(23);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_a.DIP_SERV,10,0)));
            cell = row.createCell(24);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_a.NUM_OPE,10,0)));
            r=r+1;
          } // End If
        }
        for (MemoryCursorRow_mc_tipob_altra_cit_mcrdef rw_b : mc_tipo_b._iterable_()) {
          /* If rw_b.GNL=rw_gnl.GLN and rw_b.ISTAT=rw_istat.ISTAT */
          if (CPLib.eqr(rw_b.GNL,rw_gnl.GLN) && CPLib.eqr(rw_b.ISTAT,rw_istat.ISTAT)) {
            //Creo il record da scrivere
            row = sheet.createRow(r);
            cell = row.createCell(0);
            cell.setCellValue(_tipoatt);
            cell = row.createCell(3);
            cell.setCellValue(rw_b.GNLCIT);
            cell = row.createCell(4);
            cell.setCellValue(rw_b.GNLCITSALA);
            cell = row.createCell(5);
            cell.setCellValue(rw_b.ISTAT);
            cell = row.createCell(7);
            cell.setCellValue(rw_b.ABI_P);
            cell = row.createCell(9);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_b.BM5,10,0)));
            cell = row.createCell(10);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_b.BM10,10,0)));
            cell = row.createCell(11);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_b.BM20,10,0)));
            cell = row.createCell(12);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_b.BM50,10,0)));
            cell = row.createCell(13);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_b.BM100,10,0)));
            cell = row.createCell(14);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_b.BM200,10,0)));
            cell = row.createCell(15);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_b.BM500,10,0)));
            cell = row.createCell(24);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_b.NUM_OPE,10,0)));
            r=r+1;
          } // End If
        }
        for (MemoryCursorRow_mc_tipoc_gdo_mcrdef rw_c : mc_tipo_c._iterable_()) {
          /* If rw_c.GNL=rw_gnl.GLN and rw_c.ISTAT=rw_istat.ISTAT */
          if (CPLib.eqr(rw_c.GNL,rw_gnl.GLN) && CPLib.eqr(rw_c.ISTAT,rw_istat.ISTAT)) {
            //Creo il record da scrivere
            row = sheet.createRow(r);
            cell = row.createCell(0);
            cell.setCellValue(_tipoatt);
            cell = row.createCell(1);
            cell.setCellValue(rw_c.ATECO);
            cell = row.createCell(5);
            cell.setCellValue(rw_c.ISTAT);
            cell = row.createCell(7);
            cell.setCellValue(rw_c.ABI_P);
            cell = row.createCell(9);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_c.BM5,10,0)));
            cell = row.createCell(10);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_c.BM10,10,0)));
            cell = row.createCell(11);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_c.BM20,10,0)));
            cell = row.createCell(12);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_c.BM50,10,0)));
            cell = row.createCell(13);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_c.BM100,10,0)));
            cell = row.createCell(14);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_c.BM200,10,0)));
            cell = row.createCell(15);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_c.BM500,10,0)));
            cell = row.createCell(16);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_c.MFB5,10,0)));
            cell = row.createCell(17);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_c.MFB10,10,0)));
            cell = row.createCell(18);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_c.MFB20,10,0)));
            cell = row.createCell(19);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_c.MFB50,10,0)));
            cell = row.createCell(20);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_c.MFB100,10,0)));
            cell = row.createCell(21);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_c.MFB200,10,0)));
            cell = row.createCell(22);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_c.MFB500,10,0)));
            cell = row.createCell(23);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_c.DIP_SERV,10,0)));
            cell = row.createCell(24);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_c.NUM_OPE,10,0)));
            r=r+1;
          } // End If
        }
        for (MemoryCursorRow_mc_tipod_altri_sogg_mcrdef rw_d : mc_tipo_d._iterable_()) {
          /* If rw_d.GNL=rw_gnl.GLN and rw_d.ISTAT=rw_istat.ISTAT */
          if (CPLib.eqr(rw_d.GNL,rw_gnl.GLN) && CPLib.eqr(rw_d.ISTAT,rw_istat.ISTAT)) {
            //Creo il record da scrivere
            row = sheet.createRow(r);
            cell = row.createCell(0);
            cell.setCellValue(_tipoatt);
            cell = row.createCell(9);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_d.BM5,10,0)));
            cell = row.createCell(10);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_d.BM10,10,0)));
            cell = row.createCell(11);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_d.BM20,10,0)));
            cell = row.createCell(12);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_d.BM50,10,0)));
            cell = row.createCell(13);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_d.BM100,10,0)));
            cell = row.createCell(14);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_d.BM200,10,0)));
            cell = row.createCell(15);
            cell.setCellValue(CPLib.LTrim(CPLib.Str(rw_d.BM500,10,0)));
            r=r+1;
          } // End If
        }
      }
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
    // scrivo il file di esito
    FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(fileName)));
    
    //write this workbook to an Outputstream.
    wb.write(fileOut);
    fileOut.flush();
    fileOut.close();
    
    // FileLibMit.FileCopy(_nfile,_cfile);
  }
  void _init_() {
  }
  public String RunAsync(String p_w_anno,String p_w_trimestre,String p_w_tipo) {
    w_anno = p_w_anno;
    w_trimestre = p_w_trimestre;
    w_tipo = p_w_tipo;
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
  public String Run(String p_w_anno,String p_w_trimestre,String p_w_tipo) {
    w_anno = p_w_anno;
    w_trimestre = p_w_trimestre;
    w_tipo = p_w_tipo;
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
  public static opert_estr_trimR Make(CPContext p_Ctx, Caller p_Caller) {
    return new opert_estr_trimR(p_Ctx, p_Caller);
  }
  public static opert_estr_trimR Make(CPContext p_Ctx) {
    return new opert_estr_trimR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_anno = CPLib.Space(0);
    w_trimestre = CPLib.Space(0);
    w_tipo = CPLib.Space(1);
    GLNSegnalante = CPLib.Space(13);
    c_DataBegin = CPLib.NullDate();
    c_DataEnd = CPLib.NullDate();
    mc_Ritiri = new MemoryCursor_qbe_estr_trim_vqr();
    mc_Sovvenzioni = new MemoryCursor_qbe_estr_trim_vqr();
    mc_tipo_a = new MemoryCursor_mc_tipoa_dipe_banca_mcrdef();
    mc_tipo_b = new MemoryCursor_mc_tipob_altra_cit_mcrdef();
    mc_tipo_c = new MemoryCursor_mc_tipoc_gdo_mcrdef();
    mc_tipo_d = new MemoryCursor_mc_tipod_altri_sogg_mcrdef();
    tmp_key = CPLib.Space(0);
    _tipoatt = CPLib.Space(3);
    _GLN_stampa = new MemoryCursor_mc_app_stp_estr_trim_mcrdef();
    _ISTAT_stampa = new MemoryCursor_mc_app_stp_estr_trim2_mcrdef();
    fhand = CPLib.Space(10);
    _testo = "";
    fileName = CPLib.Space(12);
    cNomeFileZip = CPLib.Space(30);
    _file1 = CPLib.Space(30);
    _file2 = CPLib.Space(80);
    cnt = 0;
    tot = 0;
    _idbase = CPLib.Space(10);
    field1 = CPLib.Space(0);
    field2 = CPLib.Space(0);
    field3 = CPLib.Space(0);
    field4 = CPLib.Space(0);
    field5 = CPLib.Space(0);
    field6 = CPLib.Space(0);
    field7 = CPLib.Space(0);
    field8 = CPLib.Space(0);
    field9 = CPLib.Space(0);
    field10 = CPLib.Space(0);
    field11 = CPLib.Space(0);
    field12 = CPLib.Space(0);
    field13 = CPLib.Space(0);
    count = 0;
    first_print = false;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_estr_trim,qbe_estr_trim_agg_a_numdipe,qbe_estr_trim_agg_c_numdipe,
  public static final String m_cVQRList = ",qbe_estr_trim,qbe_estr_trim_agg_a_numdipe,qbe_estr_trim_agg_c_numdipe,";
  // ENTITY_BATCHES: ,arfn_fdatetime,opert_estr_trim,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,opert_estr_trim,";
  public static String[] m_cRunParameterNames={"w_anno","w_trimestre","w_tipo"};
}
