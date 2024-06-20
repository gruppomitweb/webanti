// * --- Area Manuale = BO - Header
// * --- arrt_import_dipe_xls
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

import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.*;
import com.monitorjbl.xlsx.StreamingReader;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
//import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
// * --- Fine Area Manuale
public class arrt_import_dipe_xlsR implements CallerWithObjs {
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
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
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
  public String gAzienda;
  public String gPathApp;
  public String gMsgProc;
  public String gMsgImp;
  public String column01;
  public String column02;
  public String column03;
  public String column04;
  public String column05;
  public boolean _commit;
  public boolean _falied;
  public double riga_letta;
  public String riga_letta_c;
  public java.sql.Date date_base_excel;
  public double ncol;
  public double foglio;
  public String foglio_c;
  public String cProgSto;
  public java.sql.Date w_DATARETT;
  public String cCanc;
  public String cProg;
  public String _progrig;
  public MemoryCursor_mcdatistru_mcrdef mcDati;
  public MemoryCursor_mcconnes_mcrdef mcWersonbo;
  public MemoryCursor_qbe_setsin_vqr mcSettori;
  public MemoryCursor_tbsetsina mcSetSina;
  public MemoryCursor_personbo mcpersonbo;
  public MemoryCursor_intestbo mcintestbo;
  public String nota;
  public boolean modifica;
  public double cell_type;
  public String _codinter;
  public String _rapporto;
  public String nomefile;
  public String nomefileoutput;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_import_dipe_xls
  public int _i;
  public int _y;
  public int _righe;
  public int conta;
  public int r;
  String sheetName = "Sheet1";
  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
  public int _conta;
  public String[] lista;
  public String[] campi;
  public String[] colonna;
  public int conteggio;
  public int i;
  public int contanome;
  public int nfogli;
  public int ncampi;
  public int cell_count;
  // * --- Fine Area Manuale
  public arrt_import_dipe_xlsR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_import_dipe_xls",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
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
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      return riga_letta;
    }
    if (CPLib.eqr("ncol",p_cVarName)) {
      return ncol;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      return foglio;
    }
    if (CPLib.eqr("cell_type",p_cVarName)) {
      return cell_type;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_import_dipe_xls";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
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
    if (CPLib.eqr("riga_letta_c",p_cVarName)) {
      return riga_letta_c;
    }
    if (CPLib.eqr("foglio_c",p_cVarName)) {
      return foglio_c;
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      return cProgSto;
    }
    if (CPLib.eqr("cCanc",p_cVarName)) {
      return cCanc;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("_progrig",p_cVarName)) {
      return _progrig;
    }
    if (CPLib.eqr("nota",p_cVarName)) {
      return nota;
    }
    if (CPLib.eqr("_codinter",p_cVarName)) {
      return _codinter;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return nomefile;
    }
    if (CPLib.eqr("nomefileoutput",p_cVarName)) {
      return nomefileoutput;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("date_base_excel",p_cVarName)) {
      return date_base_excel;
    }
    if (CPLib.eqr("DATARETT",p_cVarName)) {
      return w_DATARETT;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_commit",p_cVarName)) {
      return _commit;
    }
    if (CPLib.eqr("_falied",p_cVarName)) {
      return _falied;
    }
    if (CPLib.eqr("modifica",p_cVarName)) {
      return modifica;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcDati",p_cVarName)) {
      return mcDati;
    }
    if (CPLib.eqr("mcWersonbo",p_cVarName)) {
      return mcWersonbo;
    }
    if (CPLib.eqr("mcSettori",p_cVarName)) {
      return mcSettori;
    }
    if (CPLib.eqr("mcSetSina",p_cVarName)) {
      return mcSetSina;
    }
    if (CPLib.eqr("mcpersonbo",p_cVarName)) {
      return mcpersonbo;
    }
    if (CPLib.eqr("mcintestbo",p_cVarName)) {
      return mcintestbo;
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
    if (CPLib.eqr("ncol",p_cVarName)) {
      ncol = value;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
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
    if (CPLib.eqr("riga_letta_c",p_cVarName)) {
      riga_letta_c = value;
      return;
    }
    if (CPLib.eqr("foglio_c",p_cVarName)) {
      foglio_c = value;
      return;
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      cProgSto = value;
      return;
    }
    if (CPLib.eqr("cCanc",p_cVarName)) {
      cCanc = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("_progrig",p_cVarName)) {
      _progrig = value;
      return;
    }
    if (CPLib.eqr("nota",p_cVarName)) {
      nota = value;
      return;
    }
    if (CPLib.eqr("_codinter",p_cVarName)) {
      _codinter = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      nomefile = value;
      return;
    }
    if (CPLib.eqr("nomefileoutput",p_cVarName)) {
      nomefileoutput = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("date_base_excel",p_cVarName)) {
      date_base_excel = value;
      return;
    }
    if (CPLib.eqr("DATARETT",p_cVarName)) {
      w_DATARETT = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("_commit",p_cVarName)) {
      _commit = value;
      return;
    }
    if (CPLib.eqr("_falied",p_cVarName)) {
      _falied = value;
      return;
    }
    if (CPLib.eqr("modifica",p_cVarName)) {
      modifica = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcDati",p_cVarName)) {
      mcDati = (MemoryCursor_mcdatistru_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcWersonbo",p_cVarName)) {
      mcWersonbo = (MemoryCursor_mcconnes_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcSettori",p_cVarName)) {
      mcSettori = (MemoryCursor_qbe_setsin_vqr)value;
      return;
    }
    if (CPLib.eqr("mcSetSina",p_cVarName)) {
      mcSetSina = (MemoryCursor_tbsetsina)value;
      return;
    }
    if (CPLib.eqr("mcpersonbo",p_cVarName)) {
      mcpersonbo = (MemoryCursor_personbo)value;
      return;
    }
    if (CPLib.eqr("mcintestbo",p_cVarName)) {
      mcintestbo = (MemoryCursor_intestbo)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_delegabo=null;
    try {
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gMsgProc Memo // Messaggio */
      /* gMsgImp Char(120) // Messaggio */
      /* column01 Char(11) // codice */
      /* column02 Char(200) // Ragione sociale */
      /* column03 Char(16) // CF */
      /* column04 Char(25) // descrizione agenzia */
      /* column05 Char(2) // codice agenzia */
      /* _commit Bool // ok alla commit */
      /* _falied Bool // fallimento scrittura dati */
      /* riga_letta Numeric(9, 0) // riga letta del file Excel */
      /* riga_letta_c Char(9) // riga letta del file Excel Character */
      /* date_base_excel Date // data di base Excel */
      /* ncol Numeric(2, 0) // numero della colonna letta */
      /* foglio Numeric(2, 0) // foglio letto */
      /* foglio_c Char(9) // foglio letto Character */
      /* cProgSto Char(15) // progressivo wersonbo del giorno */
      /* w_DATARETT Date // data rettifica */
      /* cCanc Char(10) */
      /* cProg Char(10) */
      /* _progrig Char(10) */
      /* mcDati MemoryCursor(mcDatiStru.MCRDef) */
      /* mcWersonbo MemoryCursor(mcConnes.MCRDef) */
      /* mcSettori MemoryCursor(qbe_setsin.vqr) */
      /* mcSetSina MemoryCursor(tbsetsina) */
      /* mcpersonbo MemoryCursor(personbo) // MC delle anagrafiche */
      /* mcintestbo MemoryCursor(intestbo) // MC delle intestazioni di rapporto */
      /* nota Char(100) // nota del eventuale problema */
      /* modifica Bool // ok alla modifica dei dati */
      /* cell_type Numeric(1, 0) // tipologia di cella letta */
      /* _codinter Char(16) // codinter letto dal mc */
      /* _rapporto Char(16) // rapporto letto dal mc */
      /* nomefile Char(30) // nome file da importare */
      /* nomefileoutput Char(30) // nome file risultati */
      /* nomefile := 'file.xlsx' // nome file da importare */
      nomefile = "file.xlsx";
      /* nomefileoutput := 'file_out.xlsx' // nome file risultati */
      nomefileoutput = "file_out.xlsx";
      // * --- Fill memory cursor mcpersonbo on personbo
      mcpersonbo.Zap();
      m_cServer = m_Ctx.GetServer("personbo");
      m_cPhName = m_Ctx.GetPhName("personbo");
      if (Cursor_personbo!=null)
        Cursor_personbo.Close();
      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("personbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_personbo;
        Cursor_personbo.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_dipe_xls: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_personbo.Eof())) {
        mcpersonbo.AppendWithTrimmedKey(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC")));
        mcpersonbo.row.CONNES = Cursor_personbo.GetString("CONNES");
        mcpersonbo.row.CODCAB = Cursor_personbo.GetString("CODCAB");
        mcpersonbo.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
        mcpersonbo.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
        mcpersonbo.row.CODFISC = Cursor_personbo.GetString("CODFISC");
        mcpersonbo.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
        mcpersonbo.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
        mcpersonbo.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
        mcpersonbo.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
        mcpersonbo.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
        mcpersonbo.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
        mcpersonbo.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
        mcpersonbo.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
        mcpersonbo.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
        mcpersonbo.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
        mcpersonbo.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
        mcpersonbo.row.PAESE = Cursor_personbo.GetString("PAESE");
        mcpersonbo.row.CAP = Cursor_personbo.GetString("CAP");
        mcpersonbo.row.CODINTER = Cursor_personbo.GetString("CODINTER");
        mcpersonbo.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
        mcpersonbo.row.TIPOPERS = Cursor_personbo.GetString("TIPOPERS");
        mcpersonbo.row.CODDIPE = Cursor_personbo.GetString("CODDIPE");
        mcpersonbo.row.PARTIVA = Cursor_personbo.GetString("PARTIVA");
        mcpersonbo.row.NOTE = Cursor_personbo.GetString("NOTE");
        mcpersonbo.row.SESSO = Cursor_personbo.GetString("SESSO");
        mcpersonbo.row.SOSPMAF = Cursor_personbo.GetString("SOSPMAF");
        mcpersonbo.row.idcitta = Cursor_personbo.GetString("idcitta");
        mcpersonbo.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
        mcpersonbo.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
        mcpersonbo.row.DOCFILE = Cursor_personbo.GetString("DOCFILE");
        mcpersonbo.row.NOME = Cursor_personbo.GetString("NOME");
        mcpersonbo.row.COGNOME = Cursor_personbo.GetString("COGNOME");
        mcpersonbo.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
        mcpersonbo.row.OLDCONNES = Cursor_personbo.GetString("OLDCONNES");
        mcpersonbo.row.DATEXTRA = Cursor_personbo.GetDate("DATEXTRA");
        mcpersonbo.row.PKTBSPECIE = Cursor_personbo.GetString("PKTBSPECIE");
        mcpersonbo.row.COMPORT = Cursor_personbo.GetString("COMPORT");
        mcpersonbo.row.ATTIV = Cursor_personbo.GetString("ATTIV");
        mcpersonbo.row.RNATGIU = Cursor_personbo.GetDouble("RNATGIU");
        mcpersonbo.row.RATTIV = Cursor_personbo.GetDouble("RATTIV");
        mcpersonbo.row.RCOMP = Cursor_personbo.GetDouble("RCOMP");
        mcpersonbo.row.RAREA = Cursor_personbo.GetDouble("RAREA");
        mcpersonbo.row.ALLINEATO = Cursor_personbo.GetDouble("ALLINEATO");
        mcpersonbo.row.ALLINEATONOMECNOME = Cursor_personbo.GetDouble("ALLINEATONOMECNOME");
        mcpersonbo.row.RAGSOCOLD = Cursor_personbo.GetString("RAGSOCOLD");
        mcpersonbo.row.PROGIMPORT = Cursor_personbo.GetDouble("PROGIMPORT");
        mcpersonbo.row.PROGIMP_C = Cursor_personbo.GetString("PROGIMP_C");
        mcpersonbo.row.AREAGEO = Cursor_personbo.GetString("AREAGEO");
        mcpersonbo.row.PEP = Cursor_personbo.GetString("PEP");
        mcpersonbo.row.IDFILE = Cursor_personbo.GetString("IDFILE");
        mcpersonbo.row.OLDCODFISC = Cursor_personbo.GetString("OLDCODFISC");
        mcpersonbo.row.MACROAGENTE = Cursor_personbo.GetString("MACROAGENTE");
        mcpersonbo.row.SPOTID = Cursor_personbo.GetString("SPOTID");
        mcpersonbo.row.DATASEGN = Cursor_personbo.GetDate("DATASEGN");
        mcpersonbo.row.OLDSETSIN = Cursor_personbo.GetString("OLDSETSIN");
        mcpersonbo.row.DATAVARAGE = Cursor_personbo.GetDate("DATAVARAGE");
        mcpersonbo.row.SETTSINT2 = Cursor_personbo.GetString("SETTSINT2");
        mcpersonbo.row.FATCA = Cursor_personbo.GetString("FATCA");
        mcpersonbo.row.BANCABEN = Cursor_personbo.GetString("BANCABEN");
        mcpersonbo.row.TIN = Cursor_personbo.GetString("TIN");
        mcpersonbo.row.ODB = Cursor_personbo.GetDouble("ODB");
        mcpersonbo.row.TELEF = Cursor_personbo.GetString("TELEF");
        mcpersonbo.row.TIPOORO = Cursor_personbo.GetString("TIPOORO");
        mcpersonbo.row.CODORO = Cursor_personbo.GetString("CODORO");
        mcpersonbo.row.IDNASCOMUN = Cursor_personbo.GetString("IDNASCOMUN");
        mcpersonbo.row.IDNASSTATO = Cursor_personbo.GetString("IDNASSTATO");
        mcpersonbo.row.NOTIT = Cursor_personbo.GetDouble("NOTIT");
        mcpersonbo.row.IDBASE = Cursor_personbo.GetString("IDBASE");
        mcpersonbo.row.FLGVALIDO = Cursor_personbo.GetString("FLGVALIDO");
        mcpersonbo.row.CITTADIN1 = Cursor_personbo.GetString("CITTADIN1");
        mcpersonbo.row.CITTADIN2 = Cursor_personbo.GetString("CITTADIN2");
        mcpersonbo.row.RESFISC = Cursor_personbo.GetString("RESFISC");
        mcpersonbo.row.MITIG = Cursor_personbo.GetDouble("MITIG");
        mcpersonbo.row.MITIGDOC = Cursor_personbo.GetString("MITIGDOC");
        mcpersonbo.row.NOSARA = Cursor_personbo.GetString("NOSARA");
        mcpersonbo.row.RISGLOB = Cursor_personbo.GetString("RISGLOB");
        mcpersonbo.row.DATAPROF = Cursor_personbo.GetDate("DATAPROF");
        mcpersonbo.row.DATAREVPROF = Cursor_personbo.GetDate("DATAREVPROF");
        mcpersonbo.row.IDENT = Cursor_personbo.GetString("IDENT");
        mcpersonbo.row.PEPDATE = Cursor_personbo.GetDate("PEPDATE");
        mcpersonbo.row.DAC6 = Cursor_personbo.GetString("DAC6");
        mcpersonbo.row.FLAGDAC6 = Cursor_personbo.GetDouble("FLAGDAC6");
        mcpersonbo.row.CRIME = Cursor_personbo.GetString("CRIME");
        mcpersonbo.row.CRIMEDATE = Cursor_personbo.GetDate("CRIMEDATE");
        mcpersonbo.row.ALTRODOM = Cursor_personbo.GetString("ALTRODOM");
        mcpersonbo.row.ALTROCAP = Cursor_personbo.GetString("ALTROCAP");
        mcpersonbo.row.CONTO = Cursor_personbo.GetString("CONTO");
        mcpersonbo.row.NUMIMP = Cursor_personbo.GetDateTime("NUMIMP");
        mcpersonbo.row.RAPSEGNA = Cursor_personbo.GetString("RAPSEGNA");
        mcpersonbo.row.CODLEGRAP = Cursor_personbo.GetString("CODLEGRAP");
        mcpersonbo.row.TIPOSOGGETTO = Cursor_personbo.GetString("TIPOSOGGETTO");
        mcpersonbo.row.CAUSALE = Cursor_personbo.GetDouble("CAUSALE");
        mcpersonbo.row.IMPORTOMAX = Cursor_personbo.GetDouble("IMPORTOMAX");
        mcpersonbo.row.FATTURATO = Cursor_personbo.GetDouble("FATTURATO");
        mcpersonbo.row.FREQUENZA = Cursor_personbo.GetString("FREQUENZA");
        mcpersonbo.row.NUMOPERAZ = Cursor_personbo.GetDouble("NUMOPERAZ");
        mcpersonbo.row.SOGAFFIDATARIO = Cursor_personbo.GetString("SOGAFFIDATARIO");
        mcpersonbo.row.FLGNOTRIM = Cursor_personbo.GetString("FLGNOTRIM");
        mcpersonbo.row.DISATTIVO = Cursor_personbo.GetDate("DISATTIVO");
        mcpersonbo.row.DATAFINE = Cursor_personbo.GetDate("DATAFINE");
        mcpersonbo.row.DATAINI = Cursor_personbo.GetDate("DATAINI");
        mcpersonbo.row.DATAIDENT = Cursor_personbo.GetDate("DATAIDENT");
        mcpersonbo.row.DATASIGN = Cursor_personbo.GetDate("DATASIGN");
        mcpersonbo.row.DATARAUT = Cursor_personbo.GetDate("DATARAUT");
        mcpersonbo.row.VERIFICA = Cursor_personbo.GetString("VERIFICA");
        mcpersonbo.row.NOTERIS = Cursor_personbo.GetString("NOTERIS");
        Cursor_personbo.Next();
      }
      m_cConnectivityError = Cursor_personbo.ErrorMessage();
      Cursor_personbo.Close();
      mcpersonbo.GoTop();
      //base
      InputStream ExcelFileToRead = new FileInputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomefile));
      XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
      //Workbook wb = WorkbookFactory.create(ExcelFileToRead);
      //HSSFWorkbook  wb = new HSSFWorkbook(ExcelFileToRead);
      //Modifica per evitare che carichi tutto il file in memoria
      
      conta = wb.getNumberOfSheets();
      
      System.out.println("Sono presenti "+conta);
      
      //Modifica per evitare che carichi tutto il file in memoria
      Row row; 
      Cell cell;
      
      Row row2; 
      Cell cell2;
      // creo il contenitore dei fogli
      XSSFWorkbook wb2 = new XSSFWorkbook();
      XSSFSheet sheet2 = wb2.createSheet(sheetName) ;
      //Azzero i contatori di fogli letti e righe scritte
      _i = 0;
      r=0;
      //Creo il record da scrivere
      row2 = (XSSFRow) sheet2.createRow(r);
      //scrivo la riga di intestazione
      cell2 = (XSSFCell) row2.createCell(0);
      cell2.setCellValue("Codice");
      cell2 = (XSSFCell) row2.createCell(1);
      cell2.setCellValue("Ragione Sociale");
      cell2 = (XSSFCell) row2.createCell(2);
      cell2.setCellValue("codice fiscale");
      cell2 = (XSSFCell) row2.createCell(3);
      cell2.setCellValue("Responsabile");
      cell2 = (XSSFCell) row2.createCell(4);
      cell2.setCellValue("Codice");
      cell2 = (XSSFCell) row2.createCell(5);
      cell2.setCellValue("Note");
      cell2 = (XSSFCell) row2.createCell(6);
      cell2.setCellValue("Riga");
      r++;
      /* riga_letta := 0 // riga letta del file Excel */
      riga_letta = CPLib.Round(0,0);
      /* w_DATARETT := Date() // data rettifica */
      w_DATARETT = CPLib.Date();
      /* _commit := True // ok alla commit */
      _commit = true;
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000034status;
      nTry00000034status = m_Sql.GetTransactionStatus();
      String cTry00000034msg;
      cTry00000034msg = m_Sql.TransactionErrorMessage();
      try {
        /* While _i < conta */
        while (CPLib.lt(_i,conta)) {
          //Apro uno ad uno i fogli del file Excel
          Sheet sheet = wb.getSheetAt(_i);
          //Mi definisco un oggetto che contiene tutte le righe
          Iterator rows = sheet.rowIterator();
          // System.out.println("Lettura foglio "+_i+" di "+conta);
          // System.out.println("Ci sono record "+rows.hasNext());
          /* gMsgProc := gMsgProc +"Lettura foglio "+_i+" di "+conta+' '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefile + NL */
          gMsgProc = gMsgProc+"Lettura foglio "+_i+" di "+conta+" "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefile+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* riga_letta := 0 // riga letta del file Excel */
          riga_letta = CPLib.Round(0,0);
          /* foglio := _i // foglio letto */
          foglio = CPLib.Round(_i,0);
          /* While rows.hasNext() and _commit */
          while (rows.hasNext() && _commit) {
            //scorro le righe
            row=(Row) rows.next();
            //Mi definisco un oggetto che contiene tutte le celle della riga letta
            Iterator cells = row.cellIterator();
            /* cell_count := 0 */
            cell_count = 0;
            /* riga_letta := riga_letta+1 // riga letta del file Excel */
            riga_letta = CPLib.Round(riga_letta+1,0);
            /* nota := '' // nota del eventuale problema */
            nota = "";
            /* modifica := True // ok alla modifica dei dati */
            modifica = true;
            /* gMsgProc := gMsgProc +"Lettura foglio "+_i+" di "+conta+" riga letta "+riga_letta+' '+arfn_fdatetime(DateTime()) + ' del file ' + nomefile + NL */
            gMsgProc = gMsgProc+"Lettura foglio "+_i+" di "+conta+" riga letta "+riga_letta+" "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefile+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* column01 := '' // codice */
            column01 = "";
            /* column02 := '' // Ragione sociale */
            column02 = "";
            /* column03 := '' // CF */
            column03 = "";
            /* column04 := '' // descrizione agenzia */
            column04 = "";
            /* column05 := '' // codice agenzia */
            column05 = "";
            /* While cells.hasNext() and riga_letta>1 */
            while (cells.hasNext() && CPLib.gt(riga_letta,1)) {
              //scorro le celle della riga
              cell=(Cell) cells.next();
              /* cell_count := cell_count+1 */
              cell_count = cell_count+1;
              /* cell_type := cell.getCellType().ordinal() */
              cell_type = CPLib.Round(cell.getCellType().ordinal(),0);
              /* ncol := cell.getColumnIndex() // numero della colonna letta */
              ncol = CPLib.Round(cell.getColumnIndex(),0);
              /* ncol := ncol+1 // numero della colonna letta */
              ncol = CPLib.Round(ncol+1,0);
              /* While cell_count<ncol */
              while (CPLib.lt(cell_count,ncol)) {
                /* cell_count := cell_count+1 */
                cell_count = cell_count+1;
              } // End While
              /* Case cell_type=0 */
              if (CPLib.eqr(cell_type,0)) {
                /* Case cell_count=1 */
                if (CPLib.eqr(cell_count,1)) {
                  /* column01 := LRTrim(Str(cell.getNumericCellValue(),4,0)) // codice */
                  column01 = CPLib.LRTrim(CPLib.Str(cell.getNumericCellValue(),4,0));
                  /* Case cell_count=3 */
                } else if (CPLib.eqr(cell_count,3)) {
                  /* column03 := LRTrim(Str(cell.getNumericCellValue(),16,0)) // codice agenzia */
                  column03 = CPLib.LRTrim(CPLib.Str(cell.getNumericCellValue(),16,0));
                  /* Case cell_count=5 */
                } else if (CPLib.eqr(cell_count,5)) {
                  /* column05 := LRTrim(Str(cell.getNumericCellValue(),2,0)) // codice agenzia */
                  column05 = CPLib.LRTrim(CPLib.Str(cell.getNumericCellValue(),2,0));
                } else { // Otherwise
                  // Transaction Error
                  cTry00000034msg = CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (0) %1",cell_count);
                  m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (0) %1",cell_count));
                } // End Case
                /* Case cell_type=1 */
              } else if (CPLib.eqr(cell_type,1)) {
                /* Case cell_count=1 */
                if (CPLib.eqr(cell_count,1)) {
                  /* column01 := LRTrim(cell.getStringCellValue()) // codice */
                  column01 = CPLib.LRTrim(cell.getStringCellValue());
                  /* Case cell_count=2 */
                } else if (CPLib.eqr(cell_count,2)) {
                  /* column02 := LRTrim(cell.getStringCellValue()) // Ragione sociale */
                  column02 = CPLib.LRTrim(cell.getStringCellValue());
                  /* Case cell_count=3 */
                } else if (CPLib.eqr(cell_count,3)) {
                  /* column03 := LRTrim(cell.getStringCellValue()) // CF */
                  column03 = CPLib.LRTrim(cell.getStringCellValue());
                  /* Case cell_count=4 */
                } else if (CPLib.eqr(cell_count,4)) {
                  /* column04 := LRTrim(cell.getStringCellValue()) // descrizione agenzia */
                  column04 = CPLib.LRTrim(cell.getStringCellValue());
                  /* Case cell_count=5 */
                } else if (CPLib.eqr(cell_count,5)) {
                  /* column05 := LRTrim(cell.getStringCellValue()) // codice agenzia */
                  column05 = CPLib.LRTrim(cell.getStringCellValue());
                  /* Case cell_count >=6 and cell_count <=7 */
                } else if (CPLib.ge(cell_count,6) && CPLib.le(cell_count,7)) {
                } else { // Otherwise
                  // Transaction Error
                  cTry00000034msg = CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (stringa)");
                  m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (stringa)"));
                } // End Case
                /* Case cell_type=2 */
              } else if (CPLib.eqr(cell_type,2)) {
                // Transaction Error
                cTry00000034msg = CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (2)");
                m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (2)"));
                /* Case cell_type=3 */
              } else if (CPLib.eqr(cell_type,3)) {
                // Transaction Error
                cTry00000034msg = CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (3)");
                m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (3)"));
              } else { // Otherwise
                // Transaction Error
                cTry00000034msg = CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (altro)");
                m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"errore tipo colonna non prevista (altro)"));
              } // End Case
            } // End While
            /* If not(Empty(column03) or Empty(column05)) */
            if ( ! (CPLib.Empty(column03) || CPLib.Empty(column05))) {
              /* column05 := Right('00'+LRTrim(column05),2) // codice agenzia */
              column05 = CPLib.Right("00"+CPLib.LRTrim(column05),2);
              /* If mcpersonbo.HasKey(LRTrim(column03)) */
              if (mcpersonbo.HasKey(CPLib.LRTrim(column03))) {
                /* mcpersonbo.GoToKey(LRTrim(column03)) // MC delle anagrafiche */
                mcpersonbo.GoToKey(CPLib.LRTrim(column03));
                /* intestbo->CODINTER=LRTrim(mcpersonbo.column03) */
                // * --- Fill memory cursor mcintestbo on intestbo
                mcintestbo.Zap();
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                if (Cursor_intestbo!=null)
                  Cursor_intestbo.Close();
                Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(mcpersonbo.row.CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,mcpersonbo.row.CONNES)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                {
                  final CPResultSet m_TheCursor = Cursor_intestbo;
                  Cursor_intestbo.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_import_dipe_xls: query on intestbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_intestbo.Eof())) {
                  mcintestbo.AppendBlank();
                  mcintestbo.row.IDBASE = Cursor_intestbo.GetString("IDBASE");
                  mcintestbo.row.CPROWNUM = Cursor_intestbo.GetDouble("CPROWNUM");
                  mcintestbo.row.DATAINI = Cursor_intestbo.GetDate("DATAINI");
                  mcintestbo.row.TIPOPERS = Cursor_intestbo.GetString("TIPOPERS");
                  mcintestbo.row.CODINTER = Cursor_intestbo.GetString("CODINTER");
                  mcintestbo.row.DATAFINE = Cursor_intestbo.GetDate("DATAFINE");
                  mcintestbo.row.NUMPROG1 = Cursor_intestbo.GetString("NUMPROG1");
                  mcintestbo.row.NUMPROG2 = Cursor_intestbo.GetString("NUMPROG2");
                  mcintestbo.row.RAPPORTO = Cursor_intestbo.GetString("RAPPORTO");
                  mcintestbo.row.TIPORAP = Cursor_intestbo.GetString("TIPORAP");
                  mcintestbo.row.STATOREG = Cursor_intestbo.GetString("STATOREG");
                  mcintestbo.row.DESCINTER = Cursor_intestbo.GetString("DESCINTER");
                  mcintestbo.row.OPERAZMOD = Cursor_intestbo.GetString("OPERAZMOD");
                  mcintestbo.row.DATARETT = Cursor_intestbo.GetDate("DATARETT");
                  mcintestbo.row.IDEREG = Cursor_intestbo.GetString("IDEREG");
                  mcintestbo.row.COLLEGAMEN = Cursor_intestbo.GetString("COLLEGAMEN");
                  mcintestbo.row.UCODE = Cursor_intestbo.GetString("UCODE");
                  mcintestbo.row.ABBINATO = Cursor_intestbo.GetDouble("ABBINATO");
                  mcintestbo.row.PRGIMPSOG = Cursor_intestbo.GetDouble("PRGIMPSOG");
                  mcintestbo.row.PROQUOTA = Cursor_intestbo.GetDouble("PROQUOTA");
                  mcintestbo.row.NUMIMP = Cursor_intestbo.GetDateTime("NUMIMP");
                  Cursor_intestbo.Next();
                }
                m_cConnectivityError = Cursor_intestbo.ErrorMessage();
                Cursor_intestbo.Close();
                mcintestbo.GoTop();
                /* If mcintestbo.RecCount()>0 */
                if (CPLib.gt(mcintestbo.RecCount(),0)) {
                  /* mcintestbo.GoTop() // MC delle intestazioni di rapporto */
                  mcintestbo.GoTop();
                  /* _codinter := mcpersonbo.CONNES // codinter letto dal mc */
                  _codinter = mcpersonbo.row.CONNES;
                  // * --- Select from intestit
                  m_cServer = m_Ctx.GetServer("intestit");
                  m_cPhName = m_Ctx.GetPhName("intestit");
                  if (Cursor_intestit!=null)
                    Cursor_intestit.Close();
                  Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codinter,"?",0,0,m_cServer, m_oParameters),m_cServer,_codinter)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_intestit.Eof())) {
                    // * --- Write into personbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dipe_xls",42,"00000069")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"CODDIPE = "+CPLib.ToSQL(CPLib.LRTrim(column05),"C",6,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestit.GetString("CODINTER"))+"";
                    m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_nUpdatedRows = 0;
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.lt(m_nUpdatedRows,1)) {
                      // No rows updated
                      /* nota := iif(Empty(nota),'',nota)+'errore nella scrittura della dipendenza sulle intestazioni della titolarita ' // nota del eventuale problema */
                      nota = (CPLib.Empty(nota)?"":nota)+"errore nella scrittura della dipendenza sulle intestazioni della titolarita ";
                    } else if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                      throw new RoutineException();
                    }
                    // * --- Write into rapotit from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("rapotit");
                    m_cPhName = m_Ctx.GetPhName("rapotit");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dipe_xls",42,"0000006B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"CODDIPE = "+CPLib.ToSQL(CPLib.LRTrim(column05),"C",6,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapotit",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codinter,"?",0,0,m_cServer),m_cServer,_codinter)+"";
                    m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_nUpdatedRows = 0;
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.lt(m_nUpdatedRows,1)) {
                      // No rows updated
                      /* nota := iif(Empty(nota),'',nota)+'errore nella scrittura della dipendenza sulle informazioni di titolarita ' // nota del eventuale problema */
                      nota = (CPLib.Empty(nota)?"":nota)+"errore nella scrittura della dipendenza sulle informazioni di titolarita ";
                    } else if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                      throw new RoutineException();
                    }
                    Cursor_intestit.Next();
                  }
                  m_cConnectivityError = Cursor_intestit.ErrorMessage();
                  Cursor_intestit.Close();
                  // * --- End Select
                  /* While not(mcintestbo.Eof()) */
                  while ( ! (mcintestbo.Eof())) {
                    /* _rapporto := mcintestbo.RAPPORTO // rapporto letto dal mc */
                    _rapporto = mcintestbo.row.RAPPORTO;
                    // * --- Write into personbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dipe_xls",42,"0000006F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"CODDIPE = "+CPLib.ToSQL(CPLib.LRTrim(column05),"C",6,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codinter,"?",0,0,m_cServer),m_cServer,_codinter)+"";
                    m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_nUpdatedRows = 0;
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.lt(m_nUpdatedRows,1)) {
                      // No rows updated
                      /* nota := iif(Empty(nota),'',nota)+'errore nella scrittura della dipendenza sul soggetto ' // nota del eventuale problema */
                      nota = (CPLib.Empty(nota)?"":nota)+"errore nella scrittura della dipendenza sul soggetto ";
                    } else if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                      throw new RoutineException();
                    }
                    // * --- Write into rapopebo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("rapopebo");
                    m_cPhName = m_Ctx.GetPhName("rapopebo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dipe_xls",42,"00000071")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"CODDIPE = "+CPLib.ToSQLNull(CPLib.LRTrim(column05),"C",6,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapopebo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(_rapporto,"?",0,0,m_cServer),m_cServer,_rapporto)+"";
                    m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_nUpdatedRows = 0;
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.lt(m_nUpdatedRows,1)) {
                      // No rows updated
                      /* nota := iif(Empty(nota),'',nota)+'errore nella scrittura della dipendenza sulle informazioni del rapporto ' // nota del eventuale problema */
                      nota = (CPLib.Empty(nota)?"":nota)+"errore nella scrittura della dipendenza sulle informazioni del rapporto ";
                    } else if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                      throw new RoutineException();
                    }
                    // * --- Select from delegabo
                    m_cServer = m_Ctx.GetServer("delegabo");
                    m_cPhName = m_Ctx.GetPhName("delegabo");
                    if (Cursor_delegabo!=null)
                      Cursor_delegabo.Close();
                    Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_delegabo.Eof())) {
                      // * --- Write into personbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("personbo");
                      m_cPhName = m_Ctx.GetPhName("personbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dipe_xls",42,"00000074")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"CODDIPE = "+CPLib.ToSQL(CPLib.LRTrim(column05),"C",6,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetString("CODINTER"))+"";
                      m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                      if (CPLib.lt(m_nUpdatedRows,0)) {
                        m_nUpdatedRows = 0;
                      }
                      m_Sql.CompleteTransaction();
                      m_cLastMsgError = m_Sql.TransactionErrorMessage();
                      if (CPLib.lt(m_nUpdatedRows,1)) {
                        // No rows updated
                        /* nota := iif(Empty(nota),'',nota)+'errore nella scrittura della dipendenza sulle deleghe ' // nota del eventuale problema */
                        nota = (CPLib.Empty(nota)?"":nota)+"errore nella scrittura della dipendenza sulle deleghe ";
                      } else if (CPLib.ne(m_cLastMsgError,"")) {
                        m_bError = true;
                        throw new RoutineException();
                      }
                      Cursor_delegabo.Next();
                    }
                    m_cConnectivityError = Cursor_delegabo.ErrorMessage();
                    Cursor_delegabo.Close();
                    // * --- End Select
                    // * --- Write into anarapbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("anarapbo");
                    m_cPhName = m_Ctx.GetPhName("anarapbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_import_dipe_xls",42,"00000076")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"CODDIP = "+CPLib.ToSQL(column05,"C",6,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto,"?",0,0,m_cServer),m_cServer,_rapporto)+"";
                    m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.lt(m_nUpdatedRows,0)) {
                      m_nUpdatedRows = 0;
                    }
                    m_Sql.CompleteTransaction();
                    m_cLastMsgError = m_Sql.TransactionErrorMessage();
                    if (CPLib.lt(m_nUpdatedRows,1)) {
                      // No rows updated
                      /* nota := iif(Empty(nota),'',nota)+"errore nella scrittura della dipendenza sull'anarapbo" // nota del eventuale problema */
                      nota = (CPLib.Empty(nota)?"":nota)+"errore nella scrittura della dipendenza sull'anarapbo";
                    } else if (CPLib.ne(m_cLastMsgError,"")) {
                      m_bError = true;
                      throw new RoutineException();
                    }
                    /* mcintestbo.Next() // MC delle intestazioni di rapporto */
                    mcintestbo.Next();
                  } // End While
                  /* mcintestbo.Zap() // MC delle intestazioni di rapporto */
                  mcintestbo.Zap();
                } else { // Else
                  /* nota := iif(Empty(nota),'',nota)+'Nessun rapporto individuato per il soggetto ' // nota del eventuale problema */
                  nota = (CPLib.Empty(nota)?"":nota)+"Nessun rapporto individuato per il soggetto ";
                } // End If
              } else { // Else
                /* nota := iif(Empty(nota),'',nota)+'Soggetto non individuato con CF *'+column03+'* dipendenza *'+column05+'*' // nota del eventuale problema */
                nota = (CPLib.Empty(nota)?"":nota)+"Soggetto non individuato con CF *"+column03+"* dipendenza *"+column05+"*";
              } // End If
              /* If not(Empty(nota)) */
              if ( ! (CPLib.Empty(nota))) {
                /* gMsgProc := gMsgProc+nota+' '+arfn_fdatetime(DateTime()) + ' del file ' + nomefile + NL */
                gMsgProc = gMsgProc+nota+" "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefile+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              } // End If
            } else { // Else
              /* gMsgProc := gMsgProc +'Nessuna azione intrapesa per la riga corrente '+arfn_fdatetime(DateTime()) + ' del file ' + nomefile + NL */
              gMsgProc = gMsgProc+"Nessuna azione intrapesa per la riga corrente "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefile+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* nota := iif(Empty(nota),'',nota)+'Valore del CF o del codice dipendenza vuoto ' // nota del eventuale problema */
              nota = (CPLib.Empty(nota)?"":nota)+"Valore del CF o del codice dipendenza vuoto ";
            } // End If
            /* If riga_letta>1 */
            if (CPLib.gt(riga_letta,1)) {
              /* riga_letta_c := Str(riga_letta,9,0) */
              riga_letta_c = CPLib.Str(riga_letta,9,0);
              //Creo il record da scrivere
              row2 = (XSSFRow) sheet2.createRow(r);
              cell2 = (XSSFCell) row2.createCell(0);
              cell2.setCellValue(CPLib.LRTrim(column01));
              cell2 = (XSSFCell) row2.createCell(1);
              cell2.setCellValue(CPLib.LRTrim(column02));
              cell2 = (XSSFCell) row2.createCell(2);
              cell2.setCellValue(CPLib.LRTrim(column03));
              cell2 = (XSSFCell) row2.createCell(3);
              cell2.setCellValue(CPLib.LRTrim(column04));
              cell2 = (XSSFCell) row2.createCell(4);
              cell2.setCellValue(CPLib.LRTrim(column05));
              cell2 = (XSSFCell) row2.createCell(5);
              cell2.setCellValue(CPLib.LRTrim(nota));
              cell2 = (XSSFCell) row2.createCell(6);
              cell2.setCellValue(CPLib.LRTrim(riga_letta_c));
              r++;
            } // End If
          } // End While
          _i++;
        } // End While
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000034status,0)) {
          m_Sql.SetTransactionStatus(nTry00000034status,cTry00000034msg);
        }
      }
      //Ridimenziono le colonne in base al contenuto
      sheet2.autoSizeColumn(0);
      sheet2.autoSizeColumn(1);
      sheet2.autoSizeColumn(2);
      sheet2.autoSizeColumn(3);
      sheet2.autoSizeColumn(4);
      sheet2.autoSizeColumn(5);
      sheet2.autoSizeColumn(6);
      // scrivo il file di esito
      FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+'/'+CPLib.LRTrim(nomefileoutput));
      
      //write this workbook to an Outputstream.
      wb2.write(fileOut);
      fileOut.flush();
      fileOut.close();
    } finally {
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
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
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
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
    }
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_import_dipe_xlsR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_import_dipe_xlsR(p_Ctx, p_Caller);
  }
  public void Blank() {
    column01 = CPLib.Space(11);
    column02 = CPLib.Space(200);
    column03 = CPLib.Space(16);
    column04 = CPLib.Space(25);
    column05 = CPLib.Space(2);
    _commit = false;
    _falied = false;
    riga_letta = 0;
    riga_letta_c = CPLib.Space(9);
    date_base_excel = CPLib.NullDate();
    ncol = 0;
    foglio = 0;
    foglio_c = CPLib.Space(9);
    cProgSto = CPLib.Space(15);
    w_DATARETT = CPLib.NullDate();
    cCanc = CPLib.Space(10);
    cProg = CPLib.Space(10);
    _progrig = CPLib.Space(10);
    mcDati = new MemoryCursor_mcdatistru_mcrdef();
    mcWersonbo = new MemoryCursor_mcconnes_mcrdef();
    mcSettori = new MemoryCursor_qbe_setsin_vqr();
    mcSetSina = new MemoryCursor_tbsetsina();
    mcpersonbo = new MemoryCursor_personbo();
    mcintestbo = new MemoryCursor_intestbo();
    nota = CPLib.Space(100);
    modifica = false;
    cell_type = 0;
    _codinter = CPLib.Space(16);
    _rapporto = CPLib.Space(16);
    nomefile = CPLib.Space(30);
    nomefileoutput = CPLib.Space(30);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
}
