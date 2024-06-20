// * --- Area Manuale = BO - Header
// * --- arrt_fam_xls_esiti_sid
import java.io.File; 
import java.lang.Double;

import jxl.CellReferenceHelper;
import jxl.CellView;
import jxl.HeaderFooter;
import jxl.Range;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.Orientation;
import jxl.format.PageOrder;
import jxl.format.PageOrientation;
import jxl.format.PaperSize;
import jxl.format.ScriptStyle;
import jxl.format.UnderlineStyle;
import jxl.write.Blank;
import jxl.write.Boolean;
import jxl.write.DateFormat;
import jxl.write.DateFormats;
import jxl.write.DateTime;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableHyperlink;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
// * --- Fine Area Manuale
public class arrt_fam_xls_esiti_sidR implements CallerWithObjs {
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
  public String m_cPhName_tmp_esitosid;
  public String m_cServer_tmp_esitosid;
  public String m_cPhName_tmp_chkperiodo;
  public String m_cServer_tmp_chkperiodo;
  public String m_cPhName_tmp_impesiti;
  public String m_cServer_tmp_impesiti;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_cgo_stampeav;
  public String m_cServer_cgo_stampeav;
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
  public String FileName;
  public String file;
  public String foglio;
  public String nomeesito;
  public String nomefilexls;
  public String nomefoglio;
  public String stringa;
  public String cProg;
  public String gMsgImp;
  public String gMsgProc;
  public String gDescAzi;
  public String gPathApp;
  public String gUrlApp;
  public String gAzienda;
  public String gCodDip;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_fam_xls_esiti_sid
  public int riga;
  public int conta;
  // * --- Fine Area Manuale
  public arrt_fam_xls_esiti_sidR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_fam_xls_esiti_sid",m_Caller);
    m_cPhName_tmp_esitosid = p_ContextObject.GetPhName("tmp_esitosid");
    if (m_cPhName_tmp_esitosid.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_esitosid = m_cPhName_tmp_esitosid+" "+m_Ctx.GetWritePhName("tmp_esitosid");
    }
    m_cServer_tmp_esitosid = p_ContextObject.GetServer("tmp_esitosid");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_chkperiodo")) {
      m_cPhName_tmp_chkperiodo = p_ContextObject.GetPhName("tmp_chkperiodo");
      if (m_cPhName_tmp_chkperiodo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_chkperiodo = m_cPhName_tmp_chkperiodo+" "+m_Ctx.GetWritePhName("tmp_chkperiodo");
      }
      m_cServer_tmp_chkperiodo = p_ContextObject.GetServer("tmp_chkperiodo");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_impesiti")) {
      m_cPhName_tmp_impesiti = p_ContextObject.GetPhName("tmp_impesiti");
      if (m_cPhName_tmp_impesiti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_impesiti = m_cPhName_tmp_impesiti+" "+m_Ctx.GetWritePhName("tmp_impesiti");
      }
      m_cServer_tmp_impesiti = p_ContextObject.GetServer("tmp_impesiti");
    }
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
    m_cPhName_cgo_stampeav = p_ContextObject.GetPhName("cgo_stampeav");
    if (m_cPhName_cgo_stampeav.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_stampeav = m_cPhName_cgo_stampeav+" "+m_Ctx.GetWritePhName("cgo_stampeav");
    }
    m_cServer_cgo_stampeav = p_ContextObject.GetServer("cgo_stampeav");
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
      return "arrt_fam_xls_esiti_sid";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("FileName",p_cVarName)) {
      return FileName;
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
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      return gCodDip;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("FileName",p_cVarName)) {
      FileName = value;
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
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
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
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      gCodDip = value;
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
  void Page_1() throws Exception {
    CPResultSet Cursor_tmp_esitosid=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_fam_chkerrori_01=null;
    CPResultSet Cursor_tmp_chkperiodo=null;
    CPResultSet Cursor_qbe_tmp_impesiti_max_min=null;
    CPResultSet Cursor_tmp_impesiti=null;
    CPResultSet Cursor_personbo_agg=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* FileName Char(50) // nome del file del report */
      /* _errori Numeric(10, 0) */
      double _errori;
      _errori = 0;
      /* _rapporto Char(25) */
      String _rapporto;
      _rapporto = CPLib.Space(25);
      /* _tipo Char(1) */
      String _tipo;
      _tipo = CPLib.Space(1);
      /* _ndg Char(16) */
      String _ndg;
      _ndg = CPLib.Space(16);
      /* _errore Memo */
      String _errore;
      _errore = "";
      /* _reccount Numeric(10, 0) */
      double _reccount;
      _reccount = 0;
      /* _max Numeric(15, 0) */
      double _max;
      _max = 0;
      /* _min Numeric(15, 0) */
      double _min;
      _min = 0;
      /* _tot Numeric(15, 0) */
      double _tot;
      _tot = 0;
      /* _mono Numeric(1, 0) */
      double _mono;
      _mono = 0;
      /* _contacicli Numeric(15, 0) */
      double _contacicli;
      _contacicli = 0;
      /* _bottom Numeric(15, 0) */
      double _bottom;
      _bottom = 0;
      /* _top Numeric(15, 0) */
      double _top;
      _top = 0;
      /* _cicli Numeric(15, 0) */
      double _cicli;
      _cicli = 0;
      /* _totrecord Numeric(10, 0) */
      double _totrecord;
      _totrecord = 0;
      /* _go Numeric(1, 0) */
      double _go;
      _go = 0;
      /* _tipdoc Char(2) */
      String _tipdoc;
      _tipdoc = CPLib.Space(2);
      /* _numdoc Char(15) */
      String _numdoc;
      _numdoc = CPLib.Space(15);
      /* _datril Date */
      java.sql.Date _datril;
      _datril = CPLib.NullDate();
      /* _dataope Date */
      java.sql.Date _dataope;
      _dataope = CPLib.NullDate();
      /* _cdatril Char(10) */
      String _cdatril;
      _cdatril = CPLib.Space(10);
      /* _autril Char(30) */
      String _autril;
      _autril = CPLib.Space(30);
      /* _datope Char(10) */
      String _datope;
      _datope = CPLib.Space(10);
      /* _blccf Char(1) */
      String _blccf;
      _blccf = CPLib.Space(1);
      /* _blcan Char(1) */
      String _blcan;
      _blcan = CPLib.Space(1);
      /* file Char(1) */
      /* foglio Char(1) */
      /* nomeesito Char(150) */
      /* nomefilexls Char(300) */
      /* nomefoglio Char(50) */
      /* stringa Char(1) */
      /* cProg Char(20) */
      /* rapporto Char(25) */
      String rapporto;
      rapporto = CPLib.Space(25);
      /* tipoac Char(50) */
      String tipoac;
      tipoac = CPLib.Space(50);
      /* connes Char(16) */
      String connes;
      connes = CPLib.Space(16);
      /* ident Char(15) */
      String ident;
      ident = CPLib.Space(15);
      /* ragsoc Char(30) */
      String ragsoc;
      ragsoc = CPLib.Space(30);
      /* persona Char(10) */
      String persona;
      persona = CPLib.Space(10);
      /* cognome Char(26) */
      String cognome;
      cognome = CPLib.Space(26);
      /* nome Char(25) */
      String nome;
      nome = CPLib.Space(25);
      /* sesso Char(1) */
      String sesso;
      sesso = CPLib.Space(1);
      /* datanasc Char(10) */
      String datanasc;
      datanasc = CPLib.Space(10);
      /* nascomun Char(30) */
      String nascomun;
      nascomun = CPLib.Space(30);
      /* nasstato Char(30) */
      String nasstato;
      nasstato = CPLib.Space(30);
      /* tipinter Char(2) */
      String tipinter;
      tipinter = CPLib.Space(2);
      /* desccit Char(30) */
      String desccit;
      desccit = CPLib.Space(30);
      /* provincia Char(2) */
      String provincia;
      provincia = CPLib.Space(2);
      /* codfisc Char(16) */
      String codfisc;
      codfisc = CPLib.Space(16);
      /* codcab Char(6) */
      String codcab;
      codcab = CPLib.Space(6);
      /* cfestero Char(1) */
      String cfestero;
      cfestero = CPLib.Space(1);
      /* esito Memo */
      String esito;
      esito = "";
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* gPathApp Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gCodDip Char(6) // Dipendenza */
      // * --- Drop temporary table tmp_chkperiodo
      if (m_Ctx.IsSharedTemp("tmp_chkperiodo")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_chkperiodo")) {
          m_cServer = m_Ctx.GetServer("tmp_chkperiodo");
          m_cPhName = m_Ctx.GetPhName("tmp_chkperiodo");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_chkperiodo");
      }
      // * --- Create temporary table tmp_chkperiodo
      if (m_Ctx.IsSharedTemp("tmp_chkperiodo")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_chkperiodo")) {
          m_cServer = m_Ctx.GetServer("tmp_chkperiodo");
          m_cPhName = m_Ctx.GetPhName("tmp_chkperiodo");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_chkperiodo");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_chkperiodo");
      if ( ! (m_Ctx.IsSharedTemp("tmp_chkperiodo"))) {
        m_cServer = m_Ctx.GetServer("tmp_chkperiodo");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_chkperiodo",m_cServer,"proto")),m_cPhName,"tmp_chkperiodo",m_Ctx,new String[]{"RAPPORTO","NDG"});
      }
      m_cPhName_tmp_chkperiodo = m_cPhName;
      // * --- Drop temporary table tmp_impesiti
      if (m_Ctx.IsSharedTemp("tmp_impesiti")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_impesiti")) {
          m_cServer = m_Ctx.GetServer("tmp_impesiti");
          m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_impesiti");
      }
      // * --- Create temporary table tmp_impesiti
      if (m_Ctx.IsSharedTemp("tmp_impesiti")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_impesiti")) {
          m_cServer = m_Ctx.GetServer("tmp_impesiti");
          m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_impesiti");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_impesiti");
      if ( ! (m_Ctx.IsSharedTemp("tmp_impesiti"))) {
        m_cServer = m_Ctx.GetServer("tmp_impesiti");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_impesiti",m_cServer,"proto")),m_cPhName,"tmp_impesiti",m_Ctx);
      }
      m_cPhName_tmp_impesiti = m_cPhName;
      /* _go := 0 */
      _go = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000048status;
      nTry00000048status = m_Sql.GetTransactionStatus();
      String cTry00000048msg;
      cTry00000048msg = m_Sql.TransactionErrorMessage();
      try {
        /* _errori := 0 */
        _errori = CPLib.Round(0,0);
        // * --- Select from tmp_esitosid
        m_cServer = m_Ctx.GetServer("tmp_esitosid");
        m_cPhName = m_Ctx.GetPhName("tmp_esitosid");
        if (Cursor_tmp_esitosid!=null)
          Cursor_tmp_esitosid.Close();
        Cursor_tmp_esitosid = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"TIPORIGA='C' "+")"+(m_Ctx.IsSharedTemp("tmp_esitosid")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_tmp_esitosid.Eof())) {
          /* _rapporto := '' */
          _rapporto = "";
          /* _tipo := 'O' */
          _tipo = "O";
          /* _ndg := '' */
          _ndg = "";
          /* _dataope := NullDate() */
          _dataope = CPLib.NullDate();
          // * --- Read from opextrbo
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          m_cSql = "";
          m_cSql = m_cSql+"UNIQUER="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(Cursor_tmp_esitosid.GetString("RAPPORTO")),"C",50,0,m_cServer),m_cServer,CPLib.LRTrim(Cursor_tmp_esitosid.GetString("RAPPORTO")));
          if (m_Ctx.IsSharedTemp("opextrbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("COLLEG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DATAOPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _rapporto = Read_Cursor.GetString("RAPPORTO");
            _ndg = Read_Cursor.GetString("COLLEG");
            _dataope = Read_Cursor.GetDate("DATAOPE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_fam_xls_esiti_sid returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _rapporto = "";
            _ndg = "";
            _dataope = CPLib.NullDate();
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // * --- Insert into tmp_chkperiodo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_chkperiodo");
          m_cPhName = m_Ctx.GetPhName("tmp_chkperiodo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_chkperiodo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_xls_esiti_sid",31,"00000051")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000051(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rapporto,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_tmp_esitosid.GetString("TXTMSG"),"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_ndg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_dataope,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_chkperiodo",true);
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
          Cursor_tmp_esitosid.Next();
        }
        m_cConnectivityError = Cursor_tmp_esitosid.ErrorMessage();
        Cursor_tmp_esitosid.Close();
        // * --- End Select
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* _go := 1 */
        _go = CPLib.Round(1,0);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000048status,0)) {
          m_Sql.SetTransactionStatus(nTry00000048status,cTry00000048msg);
        }
      }
      /* If _go=1 */
      if (CPLib.eqr(_go,1)) {
        /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione file excel: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Inizio Elaborazione file excel: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* _reccount := 0 */
        _reccount = CPLib.Round(0,0);
        // * --- Select from qbe_fam_chkerrori_01
        if (Cursor_qbe_fam_chkerrori_01!=null)
          Cursor_qbe_fam_chkerrori_01.Close();
        Cursor_qbe_fam_chkerrori_01 = new VQRHolder("qbe_fam_chkerrori_01",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_fam_chkerrori_01.Eof())) {
          /* _errore := '' */
          _errore = "";
          // * --- Select from tmp_chkperiodo
          m_cServer = m_Ctx.GetServer("tmp_chkperiodo");
          m_cPhName = m_Ctx.GetPhName("tmp_chkperiodo");
          if (Cursor_tmp_chkperiodo!=null)
            Cursor_tmp_chkperiodo.Close();
          Cursor_tmp_chkperiodo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NDG="+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("NDG"),"?",0,0)+"  and  RAPPORTO="+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("tmp_chkperiodo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tmp_chkperiodo.Eof())) {
            /* _errore := _errore +" - " + LRTrim(tmp_chkperiodo->MSGTXT) */
            _errore = _errore+" - "+CPLib.LRTrim(Cursor_tmp_chkperiodo.GetString("MSGTXT"));
            Cursor_tmp_chkperiodo.Next();
          }
          m_cConnectivityError = Cursor_tmp_chkperiodo.ErrorMessage();
          Cursor_tmp_chkperiodo.Close();
          // * --- End Select
          /* _reccount := _reccount + 1 */
          _reccount = CPLib.Round(_reccount+1,0);
          /* gMsgImp := 'Lettura esito n. '+LRTrim(Str(_reccount,10,0)) // Messaggio allineamento 1 */
          gMsgImp = "Lettura esito n. "+CPLib.LRTrim(CPLib.Str(_reccount,10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _tipdoc := '' */
          _tipdoc = "";
          /* _numdoc := '' */
          _numdoc = "";
          /* _datril := NullDate() */
          _datril = CPLib.NullDate();
          /* _autril := '' */
          _autril = "";
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("NDG"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_fam_chkerrori_01.GetString("NDG"));
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPODOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NUMDOCUM",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DATARILASC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("AUTRILASC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _tipdoc = Read_Cursor.GetString("TIPODOC");
            _numdoc = Read_Cursor.GetString("NUMDOCUM");
            _datril = Read_Cursor.GetDate("DATARILASC");
            _autril = Read_Cursor.GetString("AUTRILASC");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_fam_xls_esiti_sid returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _tipdoc = "";
            _numdoc = "";
            _datril = CPLib.NullDate();
            _autril = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // * --- Insert into tmp_impesiti from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_impesiti");
          m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_impesiti",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_xls_esiti_sid",31,"00000064")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000064(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_fam_chkerrori_01.GetDouble("CFESTERO"),1)?"S":"N"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipdoc,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("NDG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datril),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetDate("DATANASC"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_autril,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("NOME"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_reccount,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("SESSO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("TIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_numdoc,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_fam_chkerrori_01.GetDate("DATAINI")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_impesiti",true);
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
          Cursor_qbe_fam_chkerrori_01.Next();
        }
        m_cConnectivityError = Cursor_qbe_fam_chkerrori_01.ErrorMessage();
        Cursor_qbe_fam_chkerrori_01.Close();
        // * --- End Select
        /* gMsgProc := gMsgProc + 'Ora Inizio Scrittura file excel: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Inizio Scrittura file excel: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* nomeesito := FileName+'_Esiti_SID_'+DateTimeToChar(DateTime())+".xls" */
        nomeesito = FileName+"_Esiti_SID_"+CPLib.DateTimeToChar(CPLib.DateTime())+".xls";
        /* nomefilexls := LRTrim(gPathApp)+"/output/"+LRTrim(gAzienda)+"/"+nomeesito */
        nomefilexls = CPLib.LRTrim(gPathApp)+"/output/"+CPLib.LRTrim(gAzienda)+"/"+nomeesito;
        //base
        riga = 1;
        conta = 0;
        nomefoglio="Foglio"+conta;
        WorkbookSettings ws = new WorkbookSettings();
        WritableWorkbook file = Workbook.createWorkbook(new File(nomefilexls), ws);
        WritableSheet foglio = file.createSheet(nomefoglio, conta);
        WritableFont arial11font = new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD, true);
        WritableCellFormat arial11format = new WritableCellFormat (arial11font);
        WritableCellFormat unlock = new WritableCellFormat();
        unlock.setBackground(jxl.format.Colour.LIGHT_TURQUOISE);
        unlock.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN,jxl.format.Colour.BLACK);
        
        Label stringa = new Label(0,0,"Codice rapporto",arial11format);
        foglio.addCell(stringa); 
        stringa = new Label(1,0,"Tipo informazione",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(2,0,"Data Prima Oper.",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(3,0,"Connes intestatario",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(4,0,"Intestatario",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(5,0,"CF intestatario",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(6,0,"Persona",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(7,0,"Cognome",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(8,0,"Nome",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(9,0,"Sesso",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(10,0,"Data di nascita",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(11,0,"Comune di nascita",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(12,0,"Stato di nascita",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(13,0,"Provincia di nascita",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(14,0,"Comune di residenza",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(15,0,"Provincia di residenza",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(16,0,"CAB di residenza",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(17,0,"CF non assegnato da AGE",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(18,0,"Tipo Documento",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(19,0,"N. Documento",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(20,0,"Data Rilascio Doc.",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(21,0,"Autorità Rilascio",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(22,0,"Soggetto da Aggiornare",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(23,0,"Modifica Operazione Corrente",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(24,0,"Modifica Tutte le Operazioni del Soggetto",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(25,0,"Blocco Codice Fiscale",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(26,0,"Blocco Dati Anagrafici",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(27,0,"Errori Rilevati",arial11format);
        foglio.addCell(stringa);
        /* leggo la tabella ordinata x esito */
        // * --- Select from qbe_tmp_impesiti_max_min
        if (Cursor_qbe_tmp_impesiti_max_min!=null)
          Cursor_qbe_tmp_impesiti_max_min.Close();
        Cursor_qbe_tmp_impesiti_max_min = new VQRHolder("qbe_tmp_impesiti_max_min",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tmp_impesiti_max_min.Eof())) {
          /* _max := qbe_tmp_impesiti_max_min->MAXPROGIMPESITI */
          _max = CPLib.Round(Cursor_qbe_tmp_impesiti_max_min.GetDouble("MAXPROGIMPESITI"),0);
          /* _min := qbe_tmp_impesiti_max_min->MINPROGIMPESITI */
          _min = CPLib.Round(Cursor_qbe_tmp_impesiti_max_min.GetDouble("MINPROGIMPESITI"),0);
          Cursor_qbe_tmp_impesiti_max_min.Next();
        }
        m_cConnectivityError = Cursor_qbe_tmp_impesiti_max_min.ErrorMessage();
        Cursor_qbe_tmp_impesiti_max_min.Close();
        // * --- End Select
        /* _cicli := iif(Mod(_max,10000) <> 0,Int(_max/10000) + 1,Int(_max/10000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,10000),0)?CPLib.Int(_max/10000)+1:CPLib.Int(_max/10000)),0);
        /* _contacicli := 1 */
        _contacicli = CPLib.Round(1,0);
        /* While _contacicli<= _cicli */
        while (CPLib.le(_contacicli,_cicli)) {
          /* _bottom := ((_contacicli -1 ) * 10000) + 1 */
          _bottom = CPLib.Round(((_contacicli-1)*10000)+1,0);
          /* _top := _contacicli * 10000 */
          _top = CPLib.Round(_contacicli*10000,0);
          /* If _top>=_min */
          if (CPLib.ge(_top,_min)) {
            // * --- Select from tmp_impesiti
            m_cServer = m_Ctx.GetServer("tmp_impesiti");
            m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
            if (Cursor_tmp_impesiti!=null)
              Cursor_tmp_impesiti.Close();
            Cursor_tmp_impesiti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PROGIMPESITI>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_bottom,"?",0,0,m_cServer, m_oParameters),m_cServer,_bottom)+"  and  PROGIMPESITI<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+" "+")"+(m_Ctx.IsSharedTemp("tmp_impesiti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_tmp_impesiti.Eof())) {
              /* gMsgImp := 'Elaborazione esiti al ' + LRTrim(Str(((tmp_impesiti->PROGIMPESITI-(_min-1))/(_max-(_min-1)))*100,5,2)) + '%.' // Messaggio allineamento 1 */
              gMsgImp = "Elaborazione esiti al "+CPLib.LRTrim(CPLib.Str(((Cursor_tmp_impesiti.GetDouble("PROGIMPESITI")-(_min-1))/(_max-(_min-1)))*100,5,2))+"%.";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _blccf := 'N' */
              _blccf = "N";
              /* _blcan := 'N' */
              _blcan = "N";
              // * --- Select from personbo_agg
              m_cServer = m_Ctx.GetServer("personbo_agg");
              m_cPhName = m_Ctx.GetPhName("personbo_agg");
              if (Cursor_personbo_agg!=null)
                Cursor_personbo_agg.Close();
              Cursor_personbo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select FLGVALIDO,FLGANAVAL  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_tmp_impesiti.GetString("connes"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo_agg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo_agg.Eof())) {
                /* _blccf := iif(Empty(personbo_agg->FLGVALIDO),'N',personbo_agg->FLGVALIDO) */
                _blccf = (CPLib.Empty(Cursor_personbo_agg.GetString("FLGVALIDO"))?"N":Cursor_personbo_agg.GetString("FLGVALIDO"));
                /* _blcan := iif(Empty(personbo_agg->FLGANAVAL),'N',personbo_agg->FLGANAVAL) */
                _blcan = (CPLib.Empty(Cursor_personbo_agg.GetString("FLGANAVAL"))?"N":Cursor_personbo_agg.GetString("FLGANAVAL"));
                Cursor_personbo_agg.Next();
              }
              m_cConnectivityError = Cursor_personbo_agg.ErrorMessage();
              Cursor_personbo_agg.Close();
              // * --- End Select
              /* prima imposto le variabili */
              /* esito := tmp_impesiti->errore */
              esito = Cursor_tmp_impesiti.GetString("errore");
              /* rapporto := tmp_impesiti->rapporto */
              rapporto = Cursor_tmp_impesiti.GetString("rapporto");
              /* If not(Empty(tmp_impesiti->tipoac)) */
              if ( ! (CPLib.Empty(Cursor_tmp_impesiti.GetString("tipoac")))) {
                /* tipoac := iif(tmp_impesiti->tipoac='O','Operazione extraconto','Rapporto Continuativo') */
                tipoac = (CPLib.eqr(Cursor_tmp_impesiti.GetString("tipoac"),"O")?"Operazione extraconto":"Rapporto Continuativo");
              } else { // Else
                /* tipoac := '' */
                tipoac = "";
              } // End If
              /* connes := tmp_impesiti->connes */
              connes = Cursor_tmp_impesiti.GetString("connes");
              /* ragsoc := tmp_impesiti->ragsoc */
              ragsoc = Cursor_tmp_impesiti.GetString("ragsoc");
              /* codfisc := tmp_impesiti->codfisc */
              codfisc = Cursor_tmp_impesiti.GetString("codfisc");
              /* cognome := tmp_impesiti->cognome */
              cognome = Cursor_tmp_impesiti.GetString("cognome");
              /* nome := tmp_impesiti->nome */
              nome = Cursor_tmp_impesiti.GetString("nome");
              /* If not(Empty(tmp_impesiti->sesso)) */
              if ( ! (CPLib.Empty(Cursor_tmp_impesiti.GetString("sesso")))) {
                /* sesso := iif(tmp_impesiti->sesso='1' or tmp_impesiti->sesso='M','M','F') */
                sesso = (CPLib.eqr(Cursor_tmp_impesiti.GetString("sesso"),"1") || CPLib.eqr(Cursor_tmp_impesiti.GetString("sesso"),"M")?"M":"F");
                /* persona := 'F' */
                persona = "F";
              } else { // Else
                /* sesso := '' */
                sesso = "";
                /* persona := 'G' */
                persona = "G";
              } // End If
              /* datanasc := iif(Empty(tmp_impesiti->datanasc),'',DateToChar(tmp_impesiti->datanasc)) */
              datanasc = (CPLib.Empty(Cursor_tmp_impesiti.GetDate("datanasc"))?"":CPLib.DateToChar(Cursor_tmp_impesiti.GetDate("datanasc")));
              /* nascomun := tmp_impesiti->nascomun */
              nascomun = Cursor_tmp_impesiti.GetString("nascomun");
              /* nasstato := LRTrim(tmp_impesiti->nomefile) */
              nasstato = CPLib.LRTrim(Cursor_tmp_impesiti.GetString("nomefile"));
              /* tipinter := tmp_impesiti->tipinter */
              tipinter = Cursor_tmp_impesiti.GetString("tipinter");
              /* desccit := tmp_impesiti->desccit */
              desccit = Cursor_tmp_impesiti.GetString("desccit");
              /* provincia := tmp_impesiti->provincia */
              provincia = Cursor_tmp_impesiti.GetString("provincia");
              /* codcab := tmp_impesiti->codcab */
              codcab = Cursor_tmp_impesiti.GetString("codcab");
              /* cfestero := Left(LRTrim(tmp_impesiti->aprog),1) */
              cfestero = CPLib.Left(CPLib.LRTrim(Cursor_tmp_impesiti.GetString("aprog")),1);
              /* _tipdoc := Left(LRTrim(tmp_impesiti->cfile),2) */
              _tipdoc = CPLib.Left(CPLib.LRTrim(Cursor_tmp_impesiti.GetString("cfile")),2);
              /* _numdoc := Left(LRTrim(tmp_impesiti->trueident),15) */
              _numdoc = CPLib.Left(CPLib.LRTrim(Cursor_tmp_impesiti.GetString("trueident")),15);
              /* _cdatril := LRTrim(tmp_impesiti->cprog) */
              _cdatril = CPLib.LRTrim(Cursor_tmp_impesiti.GetString("cprog"));
              /* _autril := Left(LRTrim(tmp_impesiti->esito),30) */
              _autril = CPLib.Left(CPLib.LRTrim(Cursor_tmp_impesiti.GetString("esito")),30);
              /* _datope := LRTrim(tmp_impesiti->afile) */
              _datope = CPLib.LRTrim(Cursor_tmp_impesiti.GetString("afile"));
              /* If riga=32000 */
              if (CPLib.eqr(riga,32000)) {
                //Aggiusta le colonne
                CellView cf = new CellView();
                cf.setAutosize(true);
                foglio.setColumnView(0, cf);
                foglio.setColumnView(1, cf);
                foglio.setColumnView(2, cf);
                foglio.setColumnView(3, cf);
                foglio.setColumnView(4, cf);
                foglio.setColumnView(5, cf);
                foglio.setColumnView(6, cf);
                foglio.setColumnView(7, cf);
                foglio.setColumnView(8, cf);
                foglio.setColumnView(9, cf);
                foglio.setColumnView(10, cf);
                foglio.setColumnView(11, cf);
                foglio.setColumnView(12, cf);
                foglio.setColumnView(13, cf);
                foglio.setColumnView(14, cf);
                foglio.setColumnView(15, cf);
                foglio.setColumnView(16, cf);
                foglio.setColumnView(17, cf);
                foglio.setColumnView(18, cf);
                foglio.setColumnView(19, cf);
                foglio.setColumnView(20, cf);
                foglio.setColumnView(21, cf);
                foglio.setColumnView(22, cf);
                foglio.setColumnView(23, cf);
                foglio.setColumnView(24, cf);
                foglio.setColumnView(25, cf);
                foglio.setColumnView(26, cf);
                foglio.setColumnView(27, cf);
                //aggiungo foglio
                riga =1;
                conta = conta+1;
                nomefoglio="Foglio"+conta;
                foglio = file.createSheet(nomefoglio, conta);
                foglio.getSettings().setPassword("123");
                foglio.setProtected(true);
                stringa = new Label(0,0,"Codice rapporto",arial11format);
                foglio.addCell(stringa); 
                stringa = new Label(1,0,"Tipo informazione",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(2,0,"Data Prima Oper.",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(3,0,"Connes intestatario",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(4,0,"Intestatario",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(5,0,"CF intestatario",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(6,0,"Persona",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(7,0,"Cognome",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(8,0,"Nome",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(9,0,"Sesso",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(10,0,"Data di nascita",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(11,0,"Comune di nascita",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(12,0,"Stato di nascita",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(13,0,"Provincia di nascita",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(14,0,"Comune di residenza",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(15,0,"Provincia di residenza",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(16,0,"CAB di residenza",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(17,0,"CF non assegnato da AGE",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(18,0,"Tipo Documento",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(19,0,"N. Documento",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(20,0,"Data Rilascio Doc.",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(21,0,"Autorità Rilascio",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(22,0,"Soggetto da Aggiornare",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(23,0,"Modifica Operazioni Extraconto",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(24,0,"Modifica Rapporti Continuativi",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(25,0,"Blocco Codice Fiscale",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(26,0,"Blocco Dati Anagrafici",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(27,0,"Errori Rilevati",arial11format);
                foglio.addCell(stringa);
              } // End If
              /* imposto campi */
              stringa = new Label(0,riga,rapporto);
              foglio.addCell(stringa); 
              stringa = new Label(1,riga,tipoac);
              foglio.addCell(stringa); 
              stringa = new Label(2,riga,_datope);
              foglio.addCell(stringa);
              stringa = new Label(3,riga,connes);
              foglio.addCell(stringa); 
              stringa = new Label(4,riga,ragsoc);
              foglio.addCell(stringa); 
              stringa = new Label(5,riga,codfisc);
              foglio.addCell(stringa);
              stringa = new Label(6,riga,persona);
              foglio.addCell(stringa);  
              stringa = new Label(7,riga,cognome);
              foglio.addCell(stringa); 
              stringa = new Label(8,riga,nome);
              foglio.addCell(stringa); 
              stringa = new Label(9,riga,sesso);
              foglio.addCell(stringa); 
              stringa = new Label(10,riga,datanasc);
              foglio.addCell(stringa); 
              stringa = new Label(11,riga,nascomun);
              foglio.addCell(stringa); 
              stringa = new Label(12,riga,nasstato);
              foglio.addCell(stringa); 
              stringa = new Label(13,riga,tipinter);
              foglio.addCell(stringa); 
              stringa = new Label(14,riga,desccit);
              foglio.addCell(stringa); 
              stringa = new Label(15,riga,provincia);
              foglio.addCell(stringa); 
              stringa = new Label(16,riga,codcab);
              foglio.addCell(stringa); 
              stringa = new Label(17,riga,cfestero);
              foglio.addCell(stringa); 
              stringa = new Label(18,riga,_tipdoc);
              foglio.addCell(stringa); 
              stringa = new Label(19,riga,_numdoc);
              foglio.addCell(stringa); 
              stringa = new Label(20,riga,_cdatril);
              foglio.addCell(stringa); 
              stringa = new Label(21,riga,_autril);
              foglio.addCell(stringa); 
              stringa = new Label(22,riga,"N");
              foglio.addCell(stringa); 
              stringa = new Label(23,riga,"N");
              foglio.addCell(stringa); 
              stringa = new Label(24,riga,"N");
              foglio.addCell(stringa); 
              stringa = new Label(25,riga,_blccf);
              foglio.addCell(stringa); 
              stringa = new Label(26,riga,_blcan);
              foglio.addCell(stringa); 
              stringa = new Label(27,riga,esito);
              foglio.addCell(stringa); 
              riga = riga +1;
              Cursor_tmp_impesiti.Next();
            }
            m_cConnectivityError = Cursor_tmp_impesiti.ErrorMessage();
            Cursor_tmp_impesiti.Close();
            // * --- End Select
          } // End If
          /* Se ho già raggiunto il numero di presenze per l'esito controllato passo al successivo */
          /* _contacicli := _contacicli+1 */
          _contacicli = CPLib.Round(_contacicli+1,0);
        } // End While
        //Aggiusta le colonne
        CellView cf = new CellView();
        cf.setAutosize(true);
        foglio.setColumnView(0, cf);
        foglio.setColumnView(1, cf);
        foglio.setColumnView(2, cf);
        foglio.setColumnView(3, cf);
        foglio.setColumnView(4, cf);
        foglio.setColumnView(5, cf);
        foglio.setColumnView(6, cf);
        foglio.setColumnView(7, cf);
        foglio.setColumnView(8, cf);
        foglio.setColumnView(9, cf);
        foglio.setColumnView(10, cf);
        foglio.setColumnView(11, cf);
        foglio.setColumnView(12, cf);
        foglio.setColumnView(13, cf);
        foglio.setColumnView(14, cf);
        foglio.setColumnView(15, cf);
        foglio.setColumnView(16, cf);
        foglio.setColumnView(17, cf);
        foglio.setColumnView(18, cf);
        foglio.setColumnView(19, cf);
        foglio.setColumnView(20, cf);
        foglio.setColumnView(21, cf);
        foglio.setColumnView(22, cf);
        foglio.setColumnView(23, cf);
        foglio.setColumnView(24, cf);
        foglio.setColumnView(25, cf);
        foglio.setColumnView(26, cf);
        foglio.setColumnView(27, cf);
        file.write();
        file.close();
        
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Scrittura file excel: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine Scrittura file excel: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione file excel: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine Elaborazione file excel: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Crea il primo report */
      /* cProg := Utilities.GetAutonumber("PSTPMAV\'"+LRTrim(gAzienda)+"'","",10) */
      cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTPMAV\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
      // * --- Insert into cgo_stampeav from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("cgo_stampeav");
      m_cPhName = m_Ctx.GetPhName("cgo_stampeav");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_stampeav",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_xls_esiti_sid",31,"000000A6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_000000A6(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(gCodDip,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nomefilexls),"?",0,0,m_cServer, m_oParameters)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_stampeav",true);
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
      /* Return cProg */
      throw new Stop(cProg);
    } finally {
      try {
        if (Cursor_tmp_esitosid!=null)
          Cursor_tmp_esitosid.Close();
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
        if (Cursor_qbe_fam_chkerrori_01!=null)
          Cursor_qbe_fam_chkerrori_01.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_chkperiodo!=null)
          Cursor_tmp_chkperiodo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_tmp_impesiti_max_min!=null)
          Cursor_qbe_tmp_impesiti_max_min.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_impesiti!=null)
          Cursor_tmp_impesiti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo_agg!=null)
          Cursor_personbo_agg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_FileName) {
    FileName = p_FileName;
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
  public String Run(String p_FileName) {
    FileName = p_FileName;
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
  public static arrt_fam_xls_esiti_sidR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_fam_xls_esiti_sidR(p_Ctx, p_Caller);
  }
  public static arrt_fam_xls_esiti_sidR Make(CPContext p_Ctx) {
    return new arrt_fam_xls_esiti_sidR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    FileName = CPLib.Space(50);
    file = CPLib.Space(1);
    foglio = CPLib.Space(1);
    nomeesito = CPLib.Space(150);
    nomefilexls = CPLib.Space(300);
    nomefoglio = CPLib.Space(50);
    stringa = CPLib.Space(1);
    cProg = CPLib.Space(20);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gCodDip=m_Ctx.GetGlobalString("gCodDip");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_fam_chkerrori_01,qbe_tmp_impesiti_max_min,
  public static final String m_cVQRList = ",qbe_fam_chkerrori_01,qbe_tmp_impesiti_max_min,";
  // ENTITY_BATCHES: ,arfn_fdate,arfn_fdatetime,arrt_fam_xls_esiti_sid,
  public static final String i_InvokedRoutines = ",arfn_fdate,arfn_fdatetime,arrt_fam_xls_esiti_sid,";
  public static String[] m_cRunParameterNames={"FileName"};
  protected static String GetFieldsName_00000051(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"MSGTXT,";
    p_cSql = p_cSql+"NDG,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chkperiodo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000064(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"aprog,";
    p_cSql = p_cSql+"cfile,";
    p_cSql = p_cSql+"codcab,";
    p_cSql = p_cSql+"codfisc,";
    p_cSql = p_cSql+"cognome,";
    p_cSql = p_cSql+"connes,";
    p_cSql = p_cSql+"cprog,";
    p_cSql = p_cSql+"datanasc,";
    p_cSql = p_cSql+"desccit,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+"esito,";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"nascomun,";
    p_cSql = p_cSql+"nome,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"PROGIMPESITI,";
    p_cSql = p_cSql+"provincia,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"rapporto,";
    p_cSql = p_cSql+"sesso,";
    p_cSql = p_cSql+"tipinter,";
    p_cSql = p_cSql+"tipoac,";
    p_cSql = p_cSql+"trueident,";
    p_cSql = p_cSql+"afile,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_impesiti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ESCODICE,";
    p_cSql = p_cSql+"ESCODDIP,";
    p_cSql = p_cSql+"ESDATREP,";
    p_cSql = p_cSql+"ESNUMREP,";
    p_cSql = p_cSql+"ESNOMREP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_stampeav",true);
    return p_cSql;
  }
}
