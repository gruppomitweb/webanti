// * --- Area Manuale = BO - Header
// * --- opert_check_estr_trim
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
public class opert_check_estr_trimR implements CallerWithObjs {
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
  public String m_cPhName_tmp_impesiti;
  public String m_cServer_tmp_impesiti;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbtipatt_p;
  public String m_cServer_tbtipatt_p;
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
  public String gMsgImp;
  public String gMsgProc;
  public String gIntemediario;
  public String gAzienda;
  public String gPathApp;
  public String gPathDoc;
  public String GLNSegnalante;
  public java.sql.Date c_DataBegin;
  public java.sql.Date c_DataEnd;
  public MemoryCursor_qbe_estr_trim_check_vqr mc_Ritiri;
  public MemoryCursor_mcerrorigenerici_mcrdef mc_errori;
  public MemoryCursorRow_mcerrorigenerici_mcrdef rwErrore;
  public double cnt;
  public double tot;
  public MemoryCursor_mcerrorigenerici_mcrdef mc_ABI;
  public MemoryCursor_mcerrorigenerici_mcrdef mc_ATECO;
  public MemoryCursor_mcerrorigenerici_mcrdef mc_ISTAT;
  public MemoryCursorRow_mcerrorigenerici_mcrdef rw_MC;
  public String _str;
  public String fhand;
  public String memo_riga;
  public String field1;
  public String field2;
  public String field3;
  public String field4;
  public String field5;
  public String file;
  public String foglio;
  public String nomeesito;
  public String nomefilexls;
  public String nomefoglio;
  public String stringa;
  public String _nfile;
  public String _cfile;
  // * --- Area Manuale = BO - Properties
  // * --- opert_check_estr_trim
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
  public opert_check_estr_trimR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("opert_check_estr_trim",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_tmp_impesiti = p_ContextObject.GetPhName("tmp_impesiti");
    if (m_cPhName_tmp_impesiti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_impesiti = m_cPhName_tmp_impesiti+" "+m_Ctx.GetWritePhName("tmp_impesiti");
    }
    m_cServer_tmp_impesiti = p_ContextObject.GetServer("tmp_impesiti");
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tbtipatt_p = p_ContextObject.GetPhName("tbtipatt_p");
    if (m_cPhName_tbtipatt_p.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipatt_p = m_cPhName_tbtipatt_p+" "+m_Ctx.GetWritePhName("tbtipatt_p");
    }
    m_cServer_tbtipatt_p = p_ContextObject.GetServer("tbtipatt_p");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("cnt",p_cVarName)) {
      return cnt;
    }
    if (CPLib.eqr("tot",p_cVarName)) {
      return tot;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "opert_check_estr_trim";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("trimestre",p_cVarName)) {
      return w_trimestre;
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
    if (CPLib.eqr("_str",p_cVarName)) {
      return _str;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("memo_riga",p_cVarName)) {
      return memo_riga;
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
    if (CPLib.eqr("file",p_cVarName)) {
      return file;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      return foglio;
    }
    if (CPLib.eqr("nomeesito",p_cVarName)) {
      return nomeesito;
    }
    if (CPLib.eqr("nomefilexls",p_cVarName)) {
      return nomefilexls;
    }
    if (CPLib.eqr("nomefoglio",p_cVarName)) {
      return nomefoglio;
    }
    if (CPLib.eqr("stringa",p_cVarName)) {
      return stringa;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      return _nfile;
    }
    if (CPLib.eqr("_cfile",p_cVarName)) {
      return _cfile;
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
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mc_Ritiri",p_cVarName)) {
      return mc_Ritiri;
    }
    if (CPLib.eqr("mc_errori",p_cVarName)) {
      return mc_errori;
    }
    if (CPLib.eqr("mc_ABI",p_cVarName)) {
      return mc_ABI;
    }
    if (CPLib.eqr("mc_ATECO",p_cVarName)) {
      return mc_ATECO;
    }
    if (CPLib.eqr("mc_ISTAT",p_cVarName)) {
      return mc_ISTAT;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rwErrore",p_cVarName)) {
      return rwErrore;
    }
    if (CPLib.eqr("rw_MC",p_cVarName)) {
      return rw_MC;
    }
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
    if (CPLib.eqr("_str",p_cVarName)) {
      _str = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("memo_riga",p_cVarName)) {
      memo_riga = value;
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
    if (CPLib.eqr("file",p_cVarName)) {
      file = value;
      return;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      foglio = value;
      return;
    }
    if (CPLib.eqr("nomeesito",p_cVarName)) {
      nomeesito = value;
      return;
    }
    if (CPLib.eqr("nomefilexls",p_cVarName)) {
      nomefilexls = value;
      return;
    }
    if (CPLib.eqr("nomefoglio",p_cVarName)) {
      nomefoglio = value;
      return;
    }
    if (CPLib.eqr("stringa",p_cVarName)) {
      stringa = value;
      return;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      _nfile = value;
      return;
    }
    if (CPLib.eqr("_cfile",p_cVarName)) {
      _cfile = value;
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
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rwErrore",p_cVarName)) {
      rwErrore = (MemoryCursorRow_mcerrorigenerici_mcrdef)value;
      return;
    }
    if (CPLib.eqr("rw_MC",p_cVarName)) {
      rw_MC = (MemoryCursorRow_mcerrorigenerici_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mc_Ritiri",p_cVarName)) {
      mc_Ritiri = (MemoryCursor_qbe_estr_trim_check_vqr)value;
      return;
    }
    if (CPLib.eqr("mc_errori",p_cVarName)) {
      mc_errori = (MemoryCursor_mcerrorigenerici_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mc_ABI",p_cVarName)) {
      mc_ABI = (MemoryCursor_mcerrorigenerici_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mc_ATECO",p_cVarName)) {
      mc_ATECO = (MemoryCursor_mcerrorigenerici_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mc_ISTAT",p_cVarName)) {
      mc_ISTAT = (MemoryCursor_mcerrorigenerici_mcrdef)value;
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
      /* gMsgImp Char(120) // Messaggio Trasferimento */
      /* gMsgProc Memo // Log */
      /* gIntemediario Char(11) // Intermediario */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
      /* GLNSegnalante Char(13) */
      /* c_DataBegin Date // Data inizio periodo */
      /* c_DataEnd Date // Data fine periodo */
      /* mc_Ritiri MemoryCursor(qbe_estr_trim_check.vqr) */
      /* mc_errori MemoryCursor(mcErroriGenerici.MCRDef) // errori */
      /* rwErrore Row(mcErroriGenerici.MCRDef) */
      /* cnt Numeric(0, 0) // contatore di appoggio */
      /* tot Numeric(0, 0) //  altro contatore di appoggio */
      /* mc_ABI MemoryCursor(mcErroriGenerici.MCRDef) // Prima colonna è chiave e contiene gli ABI */
      /* mc_ATECO MemoryCursor(mcErroriGenerici.MCRDef) // Prima colonna è chiave e contiene gli ATECO */
      /* mc_ISTAT MemoryCursor(mcErroriGenerici.MCRDef) // Prima colonna è chiave e contiene gli ISTAT */
      /* rw_MC Row(mcErroriGenerici.MCRDef) */
      /* _str Char(0) // Stringa di appogio */
      /* fhand Char(1) */
      /* memo_riga Memo */
      /* field1 Char(15) */
      /* field2 Char(10) */
      /* field3 Char(30) */
      /* field4 Char(30) */
      /* field5 Char(30) */
      /* file Char(1) */
      /* foglio Char(1) */
      /* nomeesito Char(50) */
      /* nomefilexls Char(50) */
      /* nomefoglio Char(50) */
      /* stringa Char(1) */
      /* _nfile Char(120) */
      /* _cfile Char(120) */
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
      /* Exec "Init Data" Page 4:init_data */
      init_data();
      /* Exec "Controlli" Page 2:check */
      check();
      /* Exec "Creazione File Excel" Page 3:create_xls */
      create_xls();
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
  void check() throws Exception {
    CPResultSet Cursor_qbe_estr_trim_check=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* gMsgProc := gMsgProc + arfn_fdatetime(DateTime())+' Inizio estrazione dati del periodo:  da '+c_DataBegin+' a '+c_DataEnd + NL */
      gMsgProc = gMsgProc+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Inizio estrazione dati del periodo:  da "+c_DataBegin+" a "+c_DataEnd+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Fill memory cursor mc_Ritiri on qbe_estr_trim_check
      mc_Ritiri.Zap();
      SPBridge.HMCaller _h00000041;
      _h00000041 = new SPBridge.HMCaller();
      _h00000041.Set("m_cVQRList",m_cVQRList);
      _h00000041.Set("daData",c_DataBegin);
      _h00000041.Set("aData",c_DataEnd);
      if (Cursor_qbe_estr_trim_check!=null)
        Cursor_qbe_estr_trim_check.Close();
      Cursor_qbe_estr_trim_check = new VQRHolder("qbe_estr_trim_check",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000041,true).GetResultSet(m_Ctx);
      {
        final CPResultSet m_TheCursor = Cursor_qbe_estr_trim_check;
        Cursor_qbe_estr_trim_check.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,10000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine opert_check_estr_trim: query on qbe_estr_trim_check returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 10000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_qbe_estr_trim_check.Eof())) {
        mc_Ritiri.AppendBlank();
        mc_Ritiri.row.IDBASE = Cursor_qbe_estr_trim_check.GetString("IDBASE");
        mc_Ritiri.row.TIPOSOGGETTO = Cursor_qbe_estr_trim_check.GetString("TIPOSOGGETTO");
        mc_Ritiri.row.RAPSEGNA = Cursor_qbe_estr_trim_check.GetString("RAPSEGNA");
        mc_Ritiri.row.CODICEGLN = Cursor_qbe_estr_trim_check.GetString("CODICEGLN");
        mc_Ritiri.row.ABIINTER = Cursor_qbe_estr_trim_check.GetString("ABIINTER");
        mc_Ritiri.row.ABIPROPR = Cursor_qbe_estr_trim_check.GetString("ABIPROPR");
        mc_Ritiri.row.TIPOATTIV = Cursor_qbe_estr_trim_check.GetString("TIPOATTIV");
        mc_Ritiri.row.GLNALTRASC = Cursor_qbe_estr_trim_check.GetString("GLNALTRASC");
        mc_Ritiri.row.GLNALTROSOG = Cursor_qbe_estr_trim_check.GetString("GLNALTROSOG");
        mc_Ritiri.row.CODCLICON = Cursor_qbe_estr_trim_check.GetString("CODCLICON");
        mc_Ritiri.row.CODCOMCON = Cursor_qbe_estr_trim_check.GetString("CODCOMCON");
        mc_Ritiri.row.ATECO_CON = Cursor_qbe_estr_trim_check.GetString("ATECO_CON");
        mc_Ritiri.row.CONNES = Cursor_qbe_estr_trim_check.GetString("CONNES");
        mc_Ritiri.row.ATTIV = Cursor_qbe_estr_trim_check.GetString("ATTIV");
        mc_Ritiri.row.NUMPROG = Cursor_qbe_estr_trim_check.GetString("NUMPROG");
        mc_Ritiri.row.NATURA = Cursor_qbe_estr_trim_check.GetString("NATURA");
        Cursor_qbe_estr_trim_check.Next();
      }
      m_cConnectivityError = Cursor_qbe_estr_trim_check.ErrorMessage();
      Cursor_qbe_estr_trim_check.Close();
      mc_Ritiri.GoTop();
      /* gMsgProc := gMsgProc + arfn_fdatetime(DateTime())+' Fine estrazione dati'+ NL */
      gMsgProc = gMsgProc+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Fine estrazione dati"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + arfn_fdatetime(DateTime())+' Inizio controllo dati, elementi da processare: '+mc_Ritiri.RecCount() + NL */
      gMsgProc = gMsgProc+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Inizio controllo dati, elementi da processare: "+mc_Ritiri.RecCount()+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* tot := mc_Ritiri.RecCount() */
      tot = CPLib.Round(mc_Ritiri.RecCount(),0);
      /* cnt := 1 */
      cnt = CPLib.Round(1,0);
      for (MemoryCursorRow_qbe_estr_trim_check_vqr rwOpe : mc_Ritiri._iterable_()) {
        /* gMsgImp := Str(((cnt/tot)*100), 6,3)+'% Elaborazione in corso' */
        gMsgImp = CPLib.Str(((cnt/tot)*100),6,3)+"% Elaborazione in corso";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* cnt := cnt+1 */
        cnt = CPLib.Round(cnt+1,0);
        /* If Empty(rwOpe.TIPOSOGGETTO) or At(rwOpe.TIPOSOGGETTO,'|a|b|c|d')=0 */
        if (CPLib.Empty(rwOpe.TIPOSOGGETTO) || CPLib.eqr(CPLib.At(rwOpe.TIPOSOGGETTO,"|a|b|c|d"),0)) {
          /* If not(mc_errori.GoToKey("CLIENTE_TIPOSOGGETTO"+rwOpe.CONNES)) */
          if ( ! (mc_errori.GoToKey("CLIENTE_TIPOSOGGETTO"+rwOpe.CONNES))) {
            /* rwErrore := new Row(mcErroriGenerici.MCRDef) */
            rwErrore = new MemoryCursorRow_mcerrorigenerici_mcrdef();
            /* rwErrore.field1 := "CLIENTE" // errori */
            rwErrore.field1 = "CLIENTE";
            /* rwErrore.field2 := rwOpe.IDBASE // errori */
            rwErrore.field2 = rwOpe.IDBASE;
            /* If Empty(rwOpe.TIPOSOGGETTO) */
            if (CPLib.Empty(rwOpe.TIPOSOGGETTO)) {
              /* rwErrore.field3 := "Tipo Soggetto non settato" // errori */
              rwErrore.field3 = "Tipo Soggetto non settato";
            } else { // Else
              /* rwErrore.field3 := "Tipo Soggetto valore non ammesso" // errori */
              rwErrore.field3 = "Tipo Soggetto valore non ammesso";
            } // End If
            /* rwErrore.field4 := rwOpe.CONNES // errori */
            rwErrore.field4 = rwOpe.CONNES;
            /* rwErrore.field5 := rwOpe.NUMPROG // errori */
            rwErrore.field5 = rwOpe.NUMPROG;
            /* rwErrore.field6 := rwOpe.CODICEGLN // errori */
            rwErrore.field6 = rwOpe.CODICEGLN;
            /* rwErrore.field7 := rwOpe.CODCLICON // errori */
            rwErrore.field7 = rwOpe.CODCLICON;
            /* rwErrore.field8 := rwOpe.NATURA // errori */
            rwErrore.field8 = rwOpe.NATURA;
            /* rwErrore.field9 := rwOpe.CODCOMCON // errori */
            rwErrore.field9 = rwOpe.CODCOMCON;
            /* rwErrore.field10 := rwOpe.ABIINTER // errori */
            rwErrore.field10 = rwOpe.ABIINTER;
            /* rwErrore.field11 := rwOpe.ABIPROPR // errori */
            rwErrore.field11 = rwOpe.ABIPROPR;
            /* mc_errori.AppendRowWithKey("CLIENTE_TIPOSOGGETTO"+rwOpe.CONNES, rwErrore) // errori */
            mc_errori.AppendRowWithKey("CLIENTE_TIPOSOGGETTO"+rwOpe.CONNES,rwErrore);
          } // End If
        } // End If
        /* If rwOpe.TIPOSOGGETTO='a' */
        if (CPLib.eqr(rwOpe.TIPOSOGGETTO,"a")) {
          /* If Empty(rwOpe.RAPSEGNA) */
          if (CPLib.Empty(rwOpe.RAPSEGNA)) {
            /* If not(mc_errori.GoToKey("CLIENTE_RAPSEGNA"+rwOpe.CONNES)) */
            if ( ! (mc_errori.GoToKey("CLIENTE_RAPSEGNA"+rwOpe.CONNES))) {
              /* rwErrore := new Row(mcErroriGenerici.MCRDef) */
              rwErrore = new MemoryCursorRow_mcerrorigenerici_mcrdef();
              /* rwErrore.field1 := "CLIENTE" // errori */
              rwErrore.field1 = "CLIENTE";
              /* rwErrore.field2 := rwOpe.IDBASE // errori */
              rwErrore.field2 = rwOpe.IDBASE;
              /* rwErrore.field3 := "Tipo di Rapporto non settato" // errori */
              rwErrore.field3 = "Tipo di Rapporto non settato";
              /* rwErrore.field4 := rwOpe.CONNES // errori */
              rwErrore.field4 = rwOpe.CONNES;
              /* rwErrore.field5 := rwOpe.NUMPROG // errori */
              rwErrore.field5 = rwOpe.NUMPROG;
              /* rwErrore.field6 := rwOpe.CODICEGLN // errori */
              rwErrore.field6 = rwOpe.CODICEGLN;
              /* rwErrore.field7 := rwOpe.CODCLICON // errori */
              rwErrore.field7 = rwOpe.CODCLICON;
              /* rwErrore.field8 := rwOpe.NATURA // errori */
              rwErrore.field8 = rwOpe.NATURA;
              /* rwErrore.field9 := rwOpe.CODCOMCON // errori */
              rwErrore.field9 = rwOpe.CODCOMCON;
              /* rwErrore.field10 := rwOpe.ABIINTER // errori */
              rwErrore.field10 = rwOpe.ABIINTER;
              /* rwErrore.field11 := rwOpe.ABIPROPR // errori */
              rwErrore.field11 = rwOpe.ABIPROPR;
              /* mc_errori.AppendRowWithKey("CLIENTE_RAPSEGNA"+rwOpe.CONNES, rwErrore) // errori */
              mc_errori.AppendRowWithKey("CLIENTE_RAPSEGNA"+rwOpe.CONNES,rwErrore);
            } // End If
          } // End If
        } // End If
        /* If Empty(rwOpe.CODCOMCON)  */
        if (CPLib.Empty(rwOpe.CODCOMCON)) {
          /* rwErrore := new Row(mcErroriGenerici.MCRDef) */
          rwErrore = new MemoryCursorRow_mcerrorigenerici_mcrdef();
          /* rwErrore.field1 := "OPERAZIONE" // errori */
          rwErrore.field1 = "OPERAZIONE";
          /* rwErrore.field2 := rwOpe.IDBASE // errori */
          rwErrore.field2 = rwOpe.IDBASE;
          /* rwErrore.field3 := "CODICE ISTAT non settato" // errori */
          rwErrore.field3 = "CODICE ISTAT non settato";
          /* rwErrore.field4 := rwOpe.CONNES // errori */
          rwErrore.field4 = rwOpe.CONNES;
          /* rwErrore.field5 := rwOpe.NUMPROG // errori */
          rwErrore.field5 = rwOpe.NUMPROG;
          /* rwErrore.field6 := rwOpe.CODICEGLN // errori */
          rwErrore.field6 = rwOpe.CODICEGLN;
          /* rwErrore.field7 := rwOpe.CODCLICON // errori */
          rwErrore.field7 = rwOpe.CODCLICON;
          /* rwErrore.field8 := rwOpe.NATURA // errori */
          rwErrore.field8 = rwOpe.NATURA;
          /* rwErrore.field9 := rwOpe.CODCOMCON // errori */
          rwErrore.field9 = rwOpe.CODCOMCON;
          /* rwErrore.field10 := rwOpe.ABIINTER // errori */
          rwErrore.field10 = rwOpe.ABIINTER;
          /* rwErrore.field11 := rwOpe.ABIPROPR // errori */
          rwErrore.field11 = rwOpe.ABIPROPR;
          /* mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES, rwErrore) // errori */
          mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES,rwErrore);
        } else { // Else
          /* If not(mc_ISTAT.HasKey(rwOpe.CODCOMCON)) */
          if ( ! (mc_ISTAT.HasKey(rwOpe.CODCOMCON))) {
            /* rwErrore := new Row(mcErroriGenerici.MCRDef) */
            rwErrore = new MemoryCursorRow_mcerrorigenerici_mcrdef();
            /* rwErrore.field1 := "OPERAZIONE" // errori */
            rwErrore.field1 = "OPERAZIONE";
            /* rwErrore.field2 := rwOpe.IDBASE // errori */
            rwErrore.field2 = rwOpe.IDBASE;
            /* rwErrore.field3 := "CODICE ISTAT errato" // errori */
            rwErrore.field3 = "CODICE ISTAT errato";
            /* rwErrore.field4 := rwOpe.CONNES // errori */
            rwErrore.field4 = rwOpe.CONNES;
            /* rwErrore.field5 := rwOpe.NUMPROG // errori */
            rwErrore.field5 = rwOpe.NUMPROG;
            /* rwErrore.field6 := rwOpe.CODICEGLN // errori */
            rwErrore.field6 = rwOpe.CODICEGLN;
            /* rwErrore.field7 := rwOpe.CODCLICON // errori */
            rwErrore.field7 = rwOpe.CODCLICON;
            /* rwErrore.field8 := rwOpe.NATURA // errori */
            rwErrore.field8 = rwOpe.NATURA;
            /* rwErrore.field9 := rwOpe.CODCOMCON // errori */
            rwErrore.field9 = rwOpe.CODCOMCON;
            /* rwErrore.field10 := rwOpe.ABIINTER // errori */
            rwErrore.field10 = rwOpe.ABIINTER;
            /* rwErrore.field11 := rwOpe.ABIPROPR // errori */
            rwErrore.field11 = rwOpe.ABIPROPR;
            /* mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES, rwErrore) // errori */
            mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES,rwErrore);
          } // End If
        } // End If
        /* If rwOpe.TIPOSOGGETTO='c' */
        if (CPLib.eqr(rwOpe.TIPOSOGGETTO,"c")) {
          /* If Empty(rwOpe.ATECO_CON) and Empty(rwOpe.ATTIV) */
          if (CPLib.Empty(rwOpe.ATECO_CON) && CPLib.Empty(rwOpe.ATTIV)) {
            /* rwErrore := new Row(mcErroriGenerici.MCRDef) */
            rwErrore = new MemoryCursorRow_mcerrorigenerici_mcrdef();
            /* rwErrore.field1 := "OPERAZIONE" // errori */
            rwErrore.field1 = "OPERAZIONE";
            /* rwErrore.field2 := rwOpe.IDBASE // errori */
            rwErrore.field2 = rwOpe.IDBASE;
            /* rwErrore.field3 := "CODICE ATECO non settato" // errori */
            rwErrore.field3 = "CODICE ATECO non settato";
            /* rwErrore.field4 := rwOpe.CONNES // errori */
            rwErrore.field4 = rwOpe.CONNES;
            /* rwErrore.field5 := rwOpe.NUMPROG // errori */
            rwErrore.field5 = rwOpe.NUMPROG;
            /* rwErrore.field6 := rwOpe.CODICEGLN // errori */
            rwErrore.field6 = rwOpe.CODICEGLN;
            /* rwErrore.field7 := rwOpe.CODCLICON // errori */
            rwErrore.field7 = rwOpe.CODCLICON;
            /* rwErrore.field8 := rwOpe.NATURA // errori */
            rwErrore.field8 = rwOpe.NATURA;
            /* rwErrore.field9 := rwOpe.CODCOMCON // errori */
            rwErrore.field9 = rwOpe.CODCOMCON;
            /* rwErrore.field10 := rwOpe.ABIINTER // errori */
            rwErrore.field10 = rwOpe.ABIINTER;
            /* rwErrore.field11 := rwOpe.ABIPROPR // errori */
            rwErrore.field11 = rwOpe.ABIPROPR;
            /* mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES, rwErrore) // errori */
            mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES,rwErrore);
          } else { // Else
            /* If not(Empty(rwOpe.ATTIV)) */
            if ( ! (CPLib.Empty(rwOpe.ATTIV))) {
              /* If not(mc_ATECO.HasKey(rwOpe.ATTIV)) */
              if ( ! (mc_ATECO.HasKey(rwOpe.ATTIV))) {
                /* rwErrore := new Row(mcErroriGenerici.MCRDef) */
                rwErrore = new MemoryCursorRow_mcerrorigenerici_mcrdef();
                /* rwErrore.field1 := "OPERAZIONE" // errori */
                rwErrore.field1 = "OPERAZIONE";
                /* rwErrore.field2 := rwOpe.IDBASE // errori */
                rwErrore.field2 = rwOpe.IDBASE;
                /* rwErrore.field3 := "CODICE ATECO errato: "+rwOpe.ATTIV // errori */
                rwErrore.field3 = "CODICE ATECO errato: "+rwOpe.ATTIV;
                /* rwErrore.field4 := rwOpe.CONNES // errori */
                rwErrore.field4 = rwOpe.CONNES;
                /* rwErrore.field5 := rwOpe.NUMPROG // errori */
                rwErrore.field5 = rwOpe.NUMPROG;
                /* rwErrore.field6 := rwOpe.CODICEGLN // errori */
                rwErrore.field6 = rwOpe.CODICEGLN;
                /* rwErrore.field7 := rwOpe.CODCLICON // errori */
                rwErrore.field7 = rwOpe.CODCLICON;
                /* rwErrore.field8 := rwOpe.NATURA // errori */
                rwErrore.field8 = rwOpe.NATURA;
                /* rwErrore.field9 := rwOpe.CODCOMCON // errori */
                rwErrore.field9 = rwOpe.CODCOMCON;
                /* rwErrore.field10 := rwOpe.ABIINTER // errori */
                rwErrore.field10 = rwOpe.ABIINTER;
                /* rwErrore.field11 := rwOpe.ABIPROPR // errori */
                rwErrore.field11 = rwOpe.ABIPROPR;
                /* mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES, rwErrore) // errori */
                mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES,rwErrore);
              } // End If
            } else { // Else
              /* If not(mc_ATECO.HasKey(rwOpe.ATECO_CON)) */
              if ( ! (mc_ATECO.HasKey(rwOpe.ATECO_CON))) {
                /* rwErrore := new Row(mcErroriGenerici.MCRDef) */
                rwErrore = new MemoryCursorRow_mcerrorigenerici_mcrdef();
                /* rwErrore.field1 := "OPERAZIONE" // errori */
                rwErrore.field1 = "OPERAZIONE";
                /* rwErrore.field2 := rwOpe.IDBASE // errori */
                rwErrore.field2 = rwOpe.IDBASE;
                /* rwErrore.field3 := "CODICE ATECO errato: "+rwOpe.ATECO_CON // errori */
                rwErrore.field3 = "CODICE ATECO errato: "+rwOpe.ATECO_CON;
                /* rwErrore.field4 := rwOpe.CONNES // errori */
                rwErrore.field4 = rwOpe.CONNES;
                /* rwErrore.field5 := rwOpe.NUMPROG // errori */
                rwErrore.field5 = rwOpe.NUMPROG;
                /* rwErrore.field6 := rwOpe.CODICEGLN // errori */
                rwErrore.field6 = rwOpe.CODICEGLN;
                /* rwErrore.field7 := rwOpe.CODCLICON // errori */
                rwErrore.field7 = rwOpe.CODCLICON;
                /* rwErrore.field8 := rwOpe.NATURA // errori */
                rwErrore.field8 = rwOpe.NATURA;
                /* rwErrore.field9 := rwOpe.CODCOMCON // errori */
                rwErrore.field9 = rwOpe.CODCOMCON;
                /* rwErrore.field10 := rwOpe.ABIINTER // errori */
                rwErrore.field10 = rwOpe.ABIINTER;
                /* rwErrore.field11 := rwOpe.ABIPROPR // errori */
                rwErrore.field11 = rwOpe.ABIPROPR;
                /* mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES, rwErrore) // errori */
                mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES,rwErrore);
              } // End If
            } // End If
          } // End If
        } // End If
        /* If rwOpe.TIPOSOGGETTO='a' */
        if (CPLib.eqr(rwOpe.TIPOSOGGETTO,"a")) {
          /* If Empty(rwOpe.ABIINTER) */
          if (CPLib.Empty(rwOpe.ABIINTER)) {
            /* rwErrore := new Row(mcErroriGenerici.MCRDef) */
            rwErrore = new MemoryCursorRow_mcerrorigenerici_mcrdef();
            /* rwErrore.field1 := "OPERAZIONE" // errori */
            rwErrore.field1 = "OPERAZIONE";
            /* rwErrore.field2 := rwOpe.IDBASE // errori */
            rwErrore.field2 = rwOpe.IDBASE;
            /* rwErrore.field3 := "CODICE ABI Intermediario non settato" // errori */
            rwErrore.field3 = "CODICE ABI Intermediario non settato";
            /* rwErrore.field4 := rwOpe.CONNES // errori */
            rwErrore.field4 = rwOpe.CONNES;
            /* rwErrore.field5 := rwOpe.NUMPROG // errori */
            rwErrore.field5 = rwOpe.NUMPROG;
            /* rwErrore.field6 := rwOpe.CODICEGLN // errori */
            rwErrore.field6 = rwOpe.CODICEGLN;
            /* rwErrore.field7 := rwOpe.CODCLICON // errori */
            rwErrore.field7 = rwOpe.CODCLICON;
            /* rwErrore.field8 := rwOpe.NATURA // errori */
            rwErrore.field8 = rwOpe.NATURA;
            /* rwErrore.field9 := rwOpe.CODCOMCON // errori */
            rwErrore.field9 = rwOpe.CODCOMCON;
            /* rwErrore.field10 := rwOpe.ABIINTER // errori */
            rwErrore.field10 = rwOpe.ABIINTER;
            /* rwErrore.field11 := rwOpe.ABIPROPR // errori */
            rwErrore.field11 = rwOpe.ABIPROPR;
            /* mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES, rwErrore) // errori */
            mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES,rwErrore);
          } else { // Else
            /* If not(mc_ABI.HasKey(rwOpe.ABIINTER)) */
            if ( ! (mc_ABI.HasKey(rwOpe.ABIINTER))) {
              /* rwErrore := new Row(mcErroriGenerici.MCRDef) */
              rwErrore = new MemoryCursorRow_mcerrorigenerici_mcrdef();
              /* rwErrore.field1 := "OPERAZIONE" // errori */
              rwErrore.field1 = "OPERAZIONE";
              /* rwErrore.field2 := rwOpe.IDBASE // errori */
              rwErrore.field2 = rwOpe.IDBASE;
              /* rwErrore.field3 := "CODICE ABI Intermediario errato" // errori */
              rwErrore.field3 = "CODICE ABI Intermediario errato";
              /* rwErrore.field4 := rwOpe.CONNES // errori */
              rwErrore.field4 = rwOpe.CONNES;
              /* rwErrore.field5 := rwOpe.NUMPROG // errori */
              rwErrore.field5 = rwOpe.NUMPROG;
              /* rwErrore.field6 := rwOpe.CODICEGLN // errori */
              rwErrore.field6 = rwOpe.CODICEGLN;
              /* rwErrore.field7 := rwOpe.CODCLICON // errori */
              rwErrore.field7 = rwOpe.CODCLICON;
              /* rwErrore.field8 := rwOpe.NATURA // errori */
              rwErrore.field8 = rwOpe.NATURA;
              /* rwErrore.field9 := rwOpe.CODCOMCON // errori */
              rwErrore.field9 = rwOpe.CODCOMCON;
              /* rwErrore.field10 := rwOpe.ABIINTER // errori */
              rwErrore.field10 = rwOpe.ABIINTER;
              /* rwErrore.field11 := rwOpe.ABIPROPR // errori */
              rwErrore.field11 = rwOpe.ABIPROPR;
              /* mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES, rwErrore) // errori */
              mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES,rwErrore);
            } // End If
            /* If At(rwOpe.ABIINTER,'|08000|03134|03599|01000') <> 0 */
            if (CPLib.ne(CPLib.At(rwOpe.ABIINTER,"|08000|03134|03599|01000"),0)) {
              /* rwErrore := new Row(mcErroriGenerici.MCRDef) */
              rwErrore = new MemoryCursorRow_mcerrorigenerici_mcrdef();
              /* rwErrore.field1 := "OPERAZIONE" // errori */
              rwErrore.field1 = "OPERAZIONE";
              /* rwErrore.field2 := rwOpe.IDBASE // errori */
              rwErrore.field2 = rwOpe.IDBASE;
              /* rwErrore.field3 := "CODICE ABI Intermediario non valido (08000 - 03134 - 03599 - 01000)" // errori */
              rwErrore.field3 = "CODICE ABI Intermediario non valido (08000 - 03134 - 03599 - 01000)";
              /* rwErrore.field4 := rwOpe.CONNES // errori */
              rwErrore.field4 = rwOpe.CONNES;
              /* rwErrore.field5 := rwOpe.NUMPROG // errori */
              rwErrore.field5 = rwOpe.NUMPROG;
              /* rwErrore.field6 := rwOpe.CODICEGLN // errori */
              rwErrore.field6 = rwOpe.CODICEGLN;
              /* rwErrore.field7 := rwOpe.CODCLICON // errori */
              rwErrore.field7 = rwOpe.CODCLICON;
              /* rwErrore.field8 := rwOpe.NATURA // errori */
              rwErrore.field8 = rwOpe.NATURA;
              /* rwErrore.field9 := rwOpe.CODCOMCON // errori */
              rwErrore.field9 = rwOpe.CODCOMCON;
              /* rwErrore.field10 := rwOpe.ABIINTER // errori */
              rwErrore.field10 = rwOpe.ABIINTER;
              /* rwErrore.field11 := rwOpe.ABIPROPR // errori */
              rwErrore.field11 = rwOpe.ABIPROPR;
              /* mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES, rwErrore) // errori */
              mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES,rwErrore);
            } // End If
          } // End If
        } // End If
        /* If At(rwOpe.TIPOSOGGETTO,'|a|b|c') > 0 */
        if (CPLib.gt(CPLib.At(rwOpe.TIPOSOGGETTO,"|a|b|c"),0)) {
          /* If Empty(rwOpe.ABIPROPR) */
          if (CPLib.Empty(rwOpe.ABIPROPR)) {
            /* rwErrore := new Row(mcErroriGenerici.MCRDef) */
            rwErrore = new MemoryCursorRow_mcerrorigenerici_mcrdef();
            /* rwErrore.field1 := "OPERAZIONE" // errori */
            rwErrore.field1 = "OPERAZIONE";
            /* rwErrore.field2 := rwOpe.IDBASE // errori */
            rwErrore.field2 = rwOpe.IDBASE;
            /* rwErrore.field3 := "CODICE ABI Proprietario non settato" // errori */
            rwErrore.field3 = "CODICE ABI Proprietario non settato";
            /* rwErrore.field4 := rwOpe.CONNES // errori */
            rwErrore.field4 = rwOpe.CONNES;
            /* rwErrore.field5 := rwOpe.NUMPROG // errori */
            rwErrore.field5 = rwOpe.NUMPROG;
            /* rwErrore.field6 := rwOpe.CODICEGLN // errori */
            rwErrore.field6 = rwOpe.CODICEGLN;
            /* rwErrore.field7 := rwOpe.CODCLICON // errori */
            rwErrore.field7 = rwOpe.CODCLICON;
            /* rwErrore.field8 := rwOpe.NATURA // errori */
            rwErrore.field8 = rwOpe.NATURA;
            /* rwErrore.field9 := rwOpe.CODCOMCON // errori */
            rwErrore.field9 = rwOpe.CODCOMCON;
            /* rwErrore.field10 := rwOpe.ABIINTER // errori */
            rwErrore.field10 = rwOpe.ABIINTER;
            /* rwErrore.field11 := rwOpe.ABIPROPR // errori */
            rwErrore.field11 = rwOpe.ABIPROPR;
            /* mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES, rwErrore) // errori */
            mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES,rwErrore);
          } else { // Else
            /* If not(mc_ABI.HasKey(rwOpe.ABIPROPR)) */
            if ( ! (mc_ABI.HasKey(rwOpe.ABIPROPR))) {
              /* rwErrore := new Row(mcErroriGenerici.MCRDef) */
              rwErrore = new MemoryCursorRow_mcerrorigenerici_mcrdef();
              /* rwErrore.field1 := "OPERAZIONE" // errori */
              rwErrore.field1 = "OPERAZIONE";
              /* rwErrore.field2 := rwOpe.IDBASE // errori */
              rwErrore.field2 = rwOpe.IDBASE;
              /* rwErrore.field3 := "CODICE ABI Proprietario errato" // errori */
              rwErrore.field3 = "CODICE ABI Proprietario errato";
              /* rwErrore.field4 := rwOpe.CONNES // errori */
              rwErrore.field4 = rwOpe.CONNES;
              /* rwErrore.field5 := rwOpe.NUMPROG // errori */
              rwErrore.field5 = rwOpe.NUMPROG;
              /* rwErrore.field6 := rwOpe.CODICEGLN // errori */
              rwErrore.field6 = rwOpe.CODICEGLN;
              /* rwErrore.field7 := rwOpe.CODCLICON // errori */
              rwErrore.field7 = rwOpe.CODCLICON;
              /* rwErrore.field8 := rwOpe.NATURA // errori */
              rwErrore.field8 = rwOpe.NATURA;
              /* rwErrore.field9 := rwOpe.CODCOMCON // errori */
              rwErrore.field9 = rwOpe.CODCOMCON;
              /* rwErrore.field10 := rwOpe.ABIINTER // errori */
              rwErrore.field10 = rwOpe.ABIINTER;
              /* rwErrore.field11 := rwOpe.ABIPROPR // errori */
              rwErrore.field11 = rwOpe.ABIPROPR;
              /* mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES, rwErrore) // errori */
              mc_errori.AppendRowWithKey("OPE"+rwOpe.CONNES,rwErrore);
            } // End If
          } // End If
        } // End If
      }
      /* gMsgProc := gMsgProc + arfn_fdatetime(DateTime())+' Fine controllo dati. Errori riscontrati: '+mc_errori.RecCount()  + NL */
      gMsgProc = gMsgProc+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Fine controllo dati. Errori riscontrati: "+mc_errori.RecCount()+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_estr_trim_check!=null)
          Cursor_qbe_estr_trim_check.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void create_xls() throws Exception {
    /* nomeesito := 'ERRORI_'+w_anno+"Q"+w_trimestre+".xlsx" */
    nomeesito = "ERRORI_"+w_anno+"Q"+w_trimestre+".xlsx";
    /* _nfile := LRTrim(gPathApp)+'/appo/'+LRTrim(gAzienda)+"/"+nomeesito */
    _nfile = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+nomeesito;
    /* _cfile := LRTrim(gPathDoc)+'/export/'+LRTrim(gAzienda)+"/"+nomeesito */
    _cfile = CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+nomeesito;
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
    cell.setCellValue("Tipo Informazione");
    cell.setCellStyle(cs);
    cell =  row.createCell(1);
    cell.setCellValue("Identificativo");
    cell.setCellStyle(cs);
    cell = row.createCell(2);
    cell.setCellValue("Tipo di errore");
    cell.setCellStyle(cs);
    cell = row.createCell(3);
    cell.setCellValue("Codice Cliente");
    cell.setCellStyle(cs);
    cell = row.createCell(4);
    cell.setCellValue("N. Operazione");
    cell.setCellStyle(cs);
    cell = row.createCell(5);
    cell.setCellValue("GLN Sala Conta");
    cell.setCellStyle(cs);
    cell = row.createCell(6);
    cell.setCellValue("Cliente Contante");
    cell.setCellStyle(cs);
    cell = row.createCell(7);
    cell.setCellValue("Luogo");
    cell.setCellStyle(cs);
    cell = row.createCell(8);
    cell.setCellValue("ISTAT");
    cell.setCellStyle(cs);
    cell = row.createCell(9);
    cell.setCellValue("ABI Banca");
    cell.setCellStyle(cs);
    cell = row.createCell(10);
    cell.setCellValue("ABI Proprietario");
    cell.setCellStyle(cs);
    r=r+1;
    /* imposto campi */
    MemoryCursor_mcerrorigenerici_mcrdef cpmc_0000010A;
    cpmc_0000010A = new MemoryCursor_mcerrorigenerici_mcrdef();
    for (MemoryCursorRow_mcerrorigenerici_mcrdef rwPrint : mc_errori._iterable_()) {
      cpmc_0000010A.Append(rwPrint);
    }
    for (MemoryCursorRow_mcerrorigenerici_mcrdef rwPrint : cpmc_0000010A._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_mcerrorigenerici_mcrdef>(){  public int compare(MemoryCursorRow_mcerrorigenerici_mcrdef r1,MemoryCursorRow_mcerrorigenerici_mcrdef r2){    if (CPLib.gt(r1.field1,r2.field1)) return 1;    if (CPLib.lt(r1.field1,r2.field1)) return -1;    return 0;  }})) {
      //Creo il record da scrivere
      row = sheet.createRow(r);
      cell = row.createCell(0);
      cell.setCellValue(rwPrint.field1);
      cell = row.createCell(1);
      cell.setCellValue(rwPrint.field2);
      cell = row.createCell(2);
      cell.setCellValue(rwPrint.field3);
      cell = row.createCell(3);
      cell.setCellValue(rwPrint.field4);
      cell = row.createCell(4);
      cell.setCellValue(rwPrint.field5);
      cell = row.createCell(5);
      cell.setCellValue(rwPrint.field6);
      cell = row.createCell(6);
      cell.setCellValue(rwPrint.field7);
      cell = row.createCell(7);
      cell.setCellValue(rwPrint.field8);
      cell = row.createCell(8);
      cell.setCellValue(rwPrint.field9);
      cell = row.createCell(9);
      cell.setCellValue(rwPrint.field10);
      cell = row.createCell(10);
      cell.setCellValue(rwPrint.field11);
      r=r+1;
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
    // scrivo il file di esito
    FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(_nfile));
    
    //write this workbook to an Outputstream.
    wb.write(fileOut);
    fileOut.flush();
    fileOut.close();
    
    FileLibMit.FileCopy(_nfile,_cfile);
  }
  void init_data() throws Exception {
    CPResultSet Cursor_tbtipatt_p=null;
    CPResultSet Cursor_tbcitta=null;
    try {
      /* fhand := FileLibrary.OpenRead('tabelle/abicab.txt') */
      fhand = FileLibrary.OpenRead("tabelle/abicab.txt");
      /* While not(FileLibrary.Eof(fhand)) */
      while ( ! (FileLibrary.Eof(fhand))) {
        /* memo_riga := FileLibrary.ReadLine(fhand) */
        memo_riga = FileLibrary.ReadLine(fhand);
        /* If Substr(memo_riga,1,1)='1' */
        if (CPLib.eqr(CPLib.Substr(memo_riga,1,1),"1")) {
          /* _str := Substr(memo_riga,3,5) // Prelevo il codice ABI */
          _str = CPLib.Substr(memo_riga,3,5);
          /* rw_MC := new Row(mcErroriGenerici.MCRDef) */
          rw_MC = new MemoryCursorRow_mcerrorigenerici_mcrdef();
          /* rw_MC.field1 := _str */
          rw_MC.field1 = _str;
          /* mc_ABI.AppendRowWithKey(_str,rw_MC) */
          mc_ABI.AppendRowWithKey(_str,rw_MC);
        } // End If
      } // End While
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* gMsgProc := gMsgProc + arfn_fdatetime(DateTime())+' Caricato dati preliminari (ABI) - '+mc_ABI.RecCount() +NL */
      gMsgProc = gMsgProc+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Caricato dati preliminari (ABI) - "+mc_ABI.RecCount()+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Select from tbtipatt_p
      m_cServer = m_Ctx.GetServer("tbtipatt_p");
      m_cPhName = m_Ctx.GetPhName("tbtipatt_p");
      if (Cursor_tbtipatt_p!=null)
        Cursor_tbtipatt_p.Close();
      Cursor_tbtipatt_p = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODICE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbtipatt_p")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" group by "+"CODICE ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_tbtipatt_p.Eof())) {
        /* _str := LRTrim(tbtipatt_p->CODICE)  */
        _str = CPLib.LRTrim(Cursor_tbtipatt_p.GetString("CODICE"));
        /* rw_MC := new Row(mcErroriGenerici.MCRDef) */
        rw_MC = new MemoryCursorRow_mcerrorigenerici_mcrdef();
        /* rw_MC.field1 := _str */
        rw_MC.field1 = _str;
        /* mc_ATECO.AppendRowWithKey(_str,rw_MC) // Prima colonna è chiave e contiene gli ATECO */
        mc_ATECO.AppendRowWithKey(_str,rw_MC);
        Cursor_tbtipatt_p.Next();
      }
      m_cConnectivityError = Cursor_tbtipatt_p.ErrorMessage();
      Cursor_tbtipatt_p.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + arfn_fdatetime(DateTime())+' Caricato dati preliminari (ATECO) - '+mc_ATECO.RecCount() +NL */
      gMsgProc = gMsgProc+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Caricato dati preliminari (ATECO) - "+mc_ATECO.RecCount()+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Select from tbcitta
      m_cServer = m_Ctx.GetServer("tbcitta");
      m_cPhName = m_Ctx.GetPhName("tbcitta");
      if (Cursor_tbcitta!=null)
        Cursor_tbcitta.Close();
      Cursor_tbcitta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDISTAT  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbcitta")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" group by "+"IDISTAT ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_tbcitta.Eof())) {
        /* _str := LRTrim(tbcitta->IDISTAT) */
        _str = CPLib.LRTrim(Cursor_tbcitta.GetString("IDISTAT"));
        /* rw_MC := new Row(mcErroriGenerici.MCRDef) */
        rw_MC = new MemoryCursorRow_mcerrorigenerici_mcrdef();
        /* rw_MC.field1 := _str */
        rw_MC.field1 = _str;
        /* mc_ISTAT.AppendRowWithKey(_str,rw_MC) // Prima colonna è chiave e contiene gli ISTAT */
        mc_ISTAT.AppendRowWithKey(_str,rw_MC);
        Cursor_tbcitta.Next();
      }
      m_cConnectivityError = Cursor_tbcitta.ErrorMessage();
      Cursor_tbcitta.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + arfn_fdatetime(DateTime())+' Caricato dati preliminari (ISTAT) - '+mc_ISTAT.RecCount() +NL */
      gMsgProc = gMsgProc+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Caricato dati preliminari (ISTAT) - "+mc_ISTAT.RecCount()+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_tbtipatt_p!=null)
          Cursor_tbtipatt_p.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbcitta!=null)
          Cursor_tbcitta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_anno,String p_w_trimestre) {
    w_anno = p_w_anno;
    w_trimestre = p_w_trimestre;
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
  public double Run(String p_w_anno,String p_w_trimestre) {
    w_anno = p_w_anno;
    w_trimestre = p_w_trimestre;
    return Run();
  }
  public double Run() {
    double l_result;
    l_result = 0;
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
        l_result = stop_value.GetNumber();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = 0;
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
  public static opert_check_estr_trimR Make(CPContext p_Ctx, Caller p_Caller) {
    return new opert_check_estr_trimR(p_Ctx, p_Caller);
  }
  public static opert_check_estr_trimR Make(CPContext p_Ctx) {
    return new opert_check_estr_trimR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_anno = CPLib.Space(0);
    w_trimestre = CPLib.Space(0);
    GLNSegnalante = CPLib.Space(13);
    c_DataBegin = CPLib.NullDate();
    c_DataEnd = CPLib.NullDate();
    mc_Ritiri = new MemoryCursor_qbe_estr_trim_check_vqr();
    mc_errori = new MemoryCursor_mcerrorigenerici_mcrdef();
    rwErrore = new MemoryCursorRow_mcerrorigenerici_mcrdef();
    cnt = 0;
    tot = 0;
    mc_ABI = new MemoryCursor_mcerrorigenerici_mcrdef();
    mc_ATECO = new MemoryCursor_mcerrorigenerici_mcrdef();
    mc_ISTAT = new MemoryCursor_mcerrorigenerici_mcrdef();
    rw_MC = new MemoryCursorRow_mcerrorigenerici_mcrdef();
    _str = CPLib.Space(0);
    fhand = CPLib.Space(1);
    memo_riga = "";
    field1 = CPLib.Space(15);
    field2 = CPLib.Space(10);
    field3 = CPLib.Space(30);
    field4 = CPLib.Space(30);
    field5 = CPLib.Space(30);
    file = CPLib.Space(1);
    foglio = CPLib.Space(1);
    nomeesito = CPLib.Space(50);
    nomefilexls = CPLib.Space(50);
    nomefoglio = CPLib.Space(50);
    stringa = CPLib.Space(1);
    _nfile = CPLib.Space(120);
    _cfile = CPLib.Space(120);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_estr_trim_check,
  public static final String m_cVQRList = ",qbe_estr_trim_check,";
  // ENTITY_BATCHES: ,arfn_fdatetime,opert_check_estr_trim,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,opert_check_estr_trim,";
  public static String[] m_cRunParameterNames={"w_anno","w_trimestre"};
}
