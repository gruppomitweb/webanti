// * --- Area Manuale = BO - Header
// * --- arrt_stp_stdtec_tit_new
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.io.MemoryUsageSetting;
// * --- Fine Area Manuale
public class arrt_stp_stdtec_tit_newR implements CallerWithObjs {
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
  public String m_cPhName_tmp_stpoperazioni;
  public String m_cServer_tmp_stpoperazioni;
  public String m_cPhName_tmp_soggettioper;
  public String m_cServer_tmp_soggettioper;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_xntestit;
  public String m_cServer_xntestit;
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
  public String pAUI;
  public String pPDF;
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public java.sql.Date w_DaDatReg;
  public java.sql.Date w_ADatReg;
  public String w_daCodCli;
  public String w_aCodCli;
  public String w_daCodDip;
  public String w_aCodDip;
  public String _nomerep;
  public ReportLibrary _report;
  public boolean bReport;
  public String _id;
  public String _idrep;
  public double _conta;
  public String _numsto;
  public String _tipoleg;
  public String w_c_dadata;
  public String w_c_adata;
  public String w_dacdatreg;
  public String w_acdatreg;
  public String xProg;
  public String lReport;
  public double _avanza;
  public String _connescli;
  public String _reportname;
  public String filepdf;
  public java.sql.Date _dataope;
  public String _varrep;
  public double nPag;
  public String _intest;
  public MemoryCursor_mclistafile_mcrdef mcFileList;
  public String gDescAzi;
  public String gAzienda;
  public String gPathApp;
  public String gUrlApp;
  public String gMsgImp;
  public String gMsgProc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_stp_stdtec_tit_newR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stp_stdtec_tit_new",m_Caller);
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stpoperazioni")) {
      m_cPhName_tmp_stpoperazioni = p_ContextObject.GetPhName("tmp_stpoperazioni");
      if (m_cPhName_tmp_stpoperazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stpoperazioni = m_cPhName_tmp_stpoperazioni+" "+m_Ctx.GetWritePhName("tmp_stpoperazioni");
      }
      m_cServer_tmp_stpoperazioni = p_ContextObject.GetServer("tmp_stpoperazioni");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_soggettioper")) {
      m_cPhName_tmp_soggettioper = p_ContextObject.GetPhName("tmp_soggettioper");
      if (m_cPhName_tmp_soggettioper.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_soggettioper = m_cPhName_tmp_soggettioper+" "+m_Ctx.GetWritePhName("tmp_soggettioper");
      }
      m_cServer_tmp_soggettioper = p_ContextObject.GetServer("tmp_soggettioper");
    }
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_xntestit = p_ContextObject.GetPhName("xntestit");
    if (m_cPhName_xntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestit = m_cPhName_xntestit+" "+m_Ctx.GetWritePhName("xntestit");
    }
    m_cServer_xntestit = p_ContextObject.GetServer("xntestit");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_avanza",p_cVarName)) {
      return _avanza;
    }
    if (CPLib.eqr("nPag",p_cVarName)) {
      return nPag;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_stp_stdtec_tit_new";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pAUI",p_cVarName)) {
      return pAUI;
    }
    if (CPLib.eqr("pPDF",p_cVarName)) {
      return pPDF;
    }
    if (CPLib.eqr("daCodCli",p_cVarName)) {
      return w_daCodCli;
    }
    if (CPLib.eqr("aCodCli",p_cVarName)) {
      return w_aCodCli;
    }
    if (CPLib.eqr("daCodDip",p_cVarName)) {
      return w_daCodDip;
    }
    if (CPLib.eqr("aCodDip",p_cVarName)) {
      return w_aCodDip;
    }
    if (CPLib.eqr("_nomerep",p_cVarName)) {
      return _nomerep;
    }
    if (CPLib.eqr("_id",p_cVarName)) {
      return _id;
    }
    if (CPLib.eqr("_idrep",p_cVarName)) {
      return _idrep;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      return _numsto;
    }
    if (CPLib.eqr("_tipoleg",p_cVarName)) {
      return _tipoleg;
    }
    if (CPLib.eqr("c_dadata",p_cVarName)) {
      return w_c_dadata;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return w_c_adata;
    }
    if (CPLib.eqr("dacdatreg",p_cVarName)) {
      return w_dacdatreg;
    }
    if (CPLib.eqr("acdatreg",p_cVarName)) {
      return w_acdatreg;
    }
    if (CPLib.eqr("xProg",p_cVarName)) {
      return xProg;
    }
    if (CPLib.eqr("lReport",p_cVarName)) {
      return lReport;
    }
    if (CPLib.eqr("_connescli",p_cVarName)) {
      return _connescli;
    }
    if (CPLib.eqr("_reportname",p_cVarName)) {
      return _reportname;
    }
    if (CPLib.eqr("filepdf",p_cVarName)) {
      return filepdf;
    }
    if (CPLib.eqr("_varrep",p_cVarName)) {
      return _varrep;
    }
    if (CPLib.eqr("_intest",p_cVarName)) {
      return _intest;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      return w_DaDatOpe;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      return w_ADatOpe;
    }
    if (CPLib.eqr("DaDatReg",p_cVarName)) {
      return w_DaDatReg;
    }
    if (CPLib.eqr("ADatReg",p_cVarName)) {
      return w_ADatReg;
    }
    if (CPLib.eqr("_dataope",p_cVarName)) {
      return _dataope;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("bReport",p_cVarName)) {
      return bReport;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcFileList",p_cVarName)) {
      return mcFileList;
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
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_avanza",p_cVarName)) {
      _avanza = value;
      return;
    }
    if (CPLib.eqr("nPag",p_cVarName)) {
      nPag = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pAUI",p_cVarName)) {
      pAUI = value;
      return;
    }
    if (CPLib.eqr("pPDF",p_cVarName)) {
      pPDF = value;
      return;
    }
    if (CPLib.eqr("daCodCli",p_cVarName)) {
      w_daCodCli = value;
      return;
    }
    if (CPLib.eqr("aCodCli",p_cVarName)) {
      w_aCodCli = value;
      return;
    }
    if (CPLib.eqr("daCodDip",p_cVarName)) {
      w_daCodDip = value;
      return;
    }
    if (CPLib.eqr("aCodDip",p_cVarName)) {
      w_aCodDip = value;
      return;
    }
    if (CPLib.eqr("_nomerep",p_cVarName)) {
      _nomerep = value;
      return;
    }
    if (CPLib.eqr("_id",p_cVarName)) {
      _id = value;
      return;
    }
    if (CPLib.eqr("_idrep",p_cVarName)) {
      _idrep = value;
      return;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      _numsto = value;
      return;
    }
    if (CPLib.eqr("_tipoleg",p_cVarName)) {
      _tipoleg = value;
      return;
    }
    if (CPLib.eqr("c_dadata",p_cVarName)) {
      w_c_dadata = value;
      return;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      w_c_adata = value;
      return;
    }
    if (CPLib.eqr("dacdatreg",p_cVarName)) {
      w_dacdatreg = value;
      return;
    }
    if (CPLib.eqr("acdatreg",p_cVarName)) {
      w_acdatreg = value;
      return;
    }
    if (CPLib.eqr("xProg",p_cVarName)) {
      xProg = value;
      return;
    }
    if (CPLib.eqr("lReport",p_cVarName)) {
      lReport = value;
      return;
    }
    if (CPLib.eqr("_connescli",p_cVarName)) {
      _connescli = value;
      return;
    }
    if (CPLib.eqr("_reportname",p_cVarName)) {
      _reportname = value;
      return;
    }
    if (CPLib.eqr("filepdf",p_cVarName)) {
      filepdf = value;
      return;
    }
    if (CPLib.eqr("_varrep",p_cVarName)) {
      _varrep = value;
      return;
    }
    if (CPLib.eqr("_intest",p_cVarName)) {
      _intest = value;
      return;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
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
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
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
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      w_DaDatOpe = value;
      return;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      w_ADatOpe = value;
      return;
    }
    if (CPLib.eqr("DaDatReg",p_cVarName)) {
      w_DaDatReg = value;
      return;
    }
    if (CPLib.eqr("ADatReg",p_cVarName)) {
      w_ADatReg = value;
      return;
    }
    if (CPLib.eqr("_dataope",p_cVarName)) {
      _dataope = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("bReport",p_cVarName)) {
      bReport = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcFileList",p_cVarName)) {
      mcFileList = (MemoryCursor_mclistafile_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    /* pAUI Char(1) */
    /* pPDF Char(6) */
    /* w_DaDatOpe Date */
    /* w_ADatOpe Date */
    /* w_DaDatReg Date */
    /* w_ADatReg Date */
    /* w_daCodCli Char(16) */
    /* w_aCodCli Char(16) */
    /* w_daCodDip Char(6) */
    /* w_aCodDip Char(6) */
    /* _nomerep Memo // Nome Stampa */
    /* _report Object(ReportLibrary) */
    /* bReport Bool */
    /* _id Char(6) */
    /* _idrep Char(10) */
    /* _conta Numeric(10, 0) */
    /* _numsto Char(15) */
    /* _tipoleg Char(1) */
    /* w_c_dadata Char(8) */
    /* w_c_adata Char(8) */
    /* w_dacdatreg Char(8) */
    /* w_acdatreg Char(8) */
    /* xProg Char(15) */
    /* lReport Memo */
    /* _avanza Numeric(1, 0) */
    /* _connescli Char(16) */
    /* _reportname Char(100) */
    /* filepdf Char(128) */
    /* _dataope Date */
    /* _varrep Char(30) */
    /* nPag Numeric(10, 0) */
    /* _intest Char(1) */
    /* mcFileList MemoryCursor(mcListaFile.MCRDef) */
    /* gDescAzi Char(70) // Descrizione Intermediario */
    /* gAzienda Char(10) // Azienda */
    /* gPathApp Char(80) // Path Applicazione */
    /* gUrlApp Char(80) // URL Applicazione */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gMsgProc Memo // Messaggio */
    // * --- Drop temporary table tmp_stpoperazioni
    if (m_Ctx.IsSharedTemp("tmp_stpoperazioni")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_stpoperazioni")) {
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_stpoperazioni");
    }
    // * --- Drop temporary table tmp_soggettioper
    if (m_Ctx.IsSharedTemp("tmp_soggettioper")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_soggettioper")) {
        m_cServer = m_Ctx.GetServer("tmp_soggettioper");
        m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_soggettioper");
    }
    // * --- Create temporary table tmp_stpoperazioni
    if (m_Ctx.IsSharedTemp("tmp_stpoperazioni")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_stpoperazioni")) {
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_stpoperazioni");
    }
    m_cPhName = m_Ctx.CreateTmpPhName("tmp_stpoperazioni");
    if ( ! (m_Ctx.IsSharedTemp("tmp_stpoperazioni"))) {
      m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
      m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stpoperazioni",m_cServer,"proto")),m_cPhName,"tmp_stpoperazioni",m_Ctx);
    }
    m_cPhName_tmp_stpoperazioni = m_cPhName;
    // * --- Create temporary table tmp_soggettioper
    if (m_Ctx.IsSharedTemp("tmp_soggettioper")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_soggettioper")) {
        m_cServer = m_Ctx.GetServer("tmp_soggettioper");
        m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_soggettioper");
    }
    m_cPhName = m_Ctx.CreateTmpPhName("tmp_soggettioper");
    if ( ! (m_Ctx.IsSharedTemp("tmp_soggettioper"))) {
      m_cServer = m_Ctx.GetServer("tmp_soggettioper");
      m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_soggettioper",m_cServer,"proto")),m_cPhName,"tmp_soggettioper",m_Ctx,new String[]{"IDBASE,TIPOPERS,CONNES"});
    }
    m_cPhName_tmp_soggettioper = m_cPhName;
    /* Lancio la stampa */
    /* w_c_dadata := iif(Empty(w_DaDatOpe),'',DateToChar(w_DaDatOpe)) */
    w_c_dadata = (CPLib.Empty(w_DaDatOpe)?"":CPLib.DateToChar(w_DaDatOpe));
    /* w_c_adata := iif(Empty(w_ADatOpe),'',DateToChar(w_ADatOpe)) */
    w_c_adata = (CPLib.Empty(w_ADatOpe)?"":CPLib.DateToChar(w_ADatOpe));
    /* w_dacdatreg := iif(Empty(w_DaDatReg),'',DateToChar(w_DaDatReg)) */
    w_dacdatreg = (CPLib.Empty(w_DaDatReg)?"":CPLib.DateToChar(w_DaDatReg));
    /* w_acdatreg := iif(Empty(w_ADatReg),'',DateToChar(w_ADatReg)) */
    w_acdatreg = (CPLib.Empty(w_ADatReg)?"":CPLib.DateToChar(w_ADatReg));
    /* _conta := 0 */
    _conta = CPLib.Round(0,0);
    /* nPag := 1 */
    nPag = CPLib.Round(1,0);
    /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* Case pAUI='D' */
    if (CPLib.eqr(pAUI,"D")) {
      /* Exec "Legami tra soggetti AUI" Page 2:Page_2 */
      Page_2();
      /* Case pAUI='P' */
    } else if (CPLib.eqr(pAUI,"P")) {
      /* Exec "Legami tra soggetti Prov." Page 3:Page_3 */
      Page_3();
    } // End Case
    /* If mcFileList.RecCount() > 0 */
    if (CPLib.gt(mcFileList.RecCount(),0)) {
      /* _reportname := 'legami_stdtec_'+DateToChar(Date())+'.pdf' */
      _reportname = "legami_stdtec_"+CPLib.DateToChar(CPLib.Date())+".pdf";
      /* lReport := LRTrim(gPathApp)+'/output/'+LRTrim(gAzienda)+'/'+LRTrim(_reportname) */
      lReport = CPLib.LRTrim(gPathApp)+"/output/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_reportname);
      // Crea le variabili per per il merge
      PDFMergerUtility merger2 = new PDFMergerUtility();
      merger2.setDestinationFileName(lReport);
      for (MemoryCursorRow_mclistafile_mcrdef rowListFile : mcFileList._iterable_()) {
        /* lReport := LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/'+LRTrim(rowListFile.nomefile) */
        lReport = CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(rowListFile.nomefile);
        /* merger2.addSource(lReport) */
        merger2.addSource(lReport);
      }
      // Scrive il pdf mergiato
      merger2.mergeDocuments(MemoryUsageSetting.setupTempFileOnly());
      for (MemoryCursorRow_mclistafile_mcrdef rowListFile : mcFileList._iterable_()) {
        /* FileLibMit.DeleteFile('stampe_off/'+LRTrim(gAzienda)+'/'+LRTrim(rowListFile.nomefile)) */
        FileLibMit.DeleteFile("stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(rowListFile.nomefile));
      }
      /* filepdf := LRTrim(Strtran(gPathApp,'/','//'))+"//output//"+LRTrim(gAzienda)+"//"+LRTrim(_reportname) */
      filepdf = CPLib.LRTrim(CPLib.Strtran(gPathApp,"/","//"))+"//output//"+CPLib.LRTrim(gAzienda)+"//"+CPLib.LRTrim(_reportname);
      /* gMsgImp := 'Elaborazione Terminata!' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Sono state elaborate '+LRTrim(Str(_conta,10,0))+" informazioni" + NL */
      gMsgProc = gMsgProc+"Sono state elaborate "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" informazioni"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + NL + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"\n"+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Stop LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+LRTrim(filepdf) */
      Forward f;
      f=new Forward(CPLib.LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+CPLib.LRTrim(filepdf),false,this,Forward.NoStatus,true);
      f.SetParameter("m_cParameterSequence", "");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } else { // Else
      /* gMsgProc := gMsgProc + 'Non sono stati trovati dati per i parametri inseriti' + NL */
      gMsgProc = gMsgProc+"Non sono stati trovati dati per i parametri inseriti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Elaborazione Terminata!' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + NL + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"\n"+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Stop LRTrim(gUrlApp)+"blank.htm" */
      Forward f;
      f=new Forward(CPLib.LRTrim(gUrlApp)+"blank.htm",false,this,Forward.NoStatus,true);
      f.SetParameter("m_cParameterSequence", "");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } // End If
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_allrapotit_tec=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_intermbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_allrapotit_tec
      if (Cursor_qbe_allrapotit_tec!=null)
        Cursor_qbe_allrapotit_tec.Close();
      Cursor_qbe_allrapotit_tec = new VQRHolder("qbe_allrapotit_tec",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_allrapotit_tec.Eof())) {
        /* gMsgImp := "Elaborazione dell'informazione n. "+LRTrim(qbe_allrapotit_tec->NUMPROG) // Messaggio Import */
        gMsgImp = "Elaborazione dell'informazione n. "+CPLib.LRTrim(Cursor_qbe_allrapotit_tec.GetString("NUMPROG"));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* _intest := 'N' */
        _intest = "N";
        /* _id := Right('000000'+LRTrim(Str(_conta,10,0)),6) */
        _id = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta,10,0)),6);
        /* _tipoleg := iif(qbe_allrapotit_tec->TIPOLEG='5','7','9') */
        _tipoleg = (CPLib.eqr(Cursor_qbe_allrapotit_tec.GetString("TIPOLEG"),"5")?"7":"9");
        /* _dataope := qbe_allrapotit_tec->DATAOPE */
        _dataope = Cursor_qbe_allrapotit_tec.GetDate("DATAOPE");
        // * --- Delete from tmp_stpoperazioni
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"00000054")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
        // * --- Delete from tmp_soggettioper
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_soggettioper");
        m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"00000055")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
        // * --- Insert into tmp_stpoperazioni from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"00000056")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000056(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetDate("DATAOPE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("DIPCIT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("DIPPRV"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("DIPCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetDate("DATAREG"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetDate("DATARETT"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpoperazioni",true);
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
        /* Case qbe_allrapotit_tec->TIPOOPRAP='50' or qbe_allrapotit_tec->TIPOOPRAP='51' or qbe_allrapotit_tec->TIPOOPRAP='52' or qbe_allrapotit_tec->TIPOOPRAP='53' */
        if (CPLib.eqr(Cursor_qbe_allrapotit_tec.GetString("TIPOOPRAP"),"50") || CPLib.eqr(Cursor_qbe_allrapotit_tec.GetString("TIPOOPRAP"),"51") || CPLib.eqr(Cursor_qbe_allrapotit_tec.GetString("TIPOOPRAP"),"52") || CPLib.eqr(Cursor_qbe_allrapotit_tec.GetString("TIPOOPRAP"),"53")) {
          /* If not(Empty(qbe_allrapotit_tec->CONNESCLI)) */
          if ( ! (CPLib.Empty(Cursor_qbe_allrapotit_tec.GetString("CONNESCLI")))) {
            /* xProg := '' */
            xProg = "";
            // * --- Insert into tmp_soggettioper from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"0000005A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000005A(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipoleg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
            /* xProg := arfn_chkspers(qbe_allrapotit_tec->CONNESCLI,qbe_allrapotit_tec->DATAREG) */
            xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allrapotit_tec.GetString("CONNESCLI"),Cursor_qbe_allrapotit_tec.GetDate("DATAREG"));
            /* If Empty(LRTrim(xProg)) */
            if (CPLib.Empty(CPLib.LRTrim(xProg))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"0000005E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapotit_tec.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapotit_tec.GetString("CONNESCLI"))+"";
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
              Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wersonbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"00000060")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapotit_tec.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapotit_tec.GetString("CONNESCLI"))+"";
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
                Cursor_wersonbo.Next();
              }
              m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
              Cursor_wersonbo.Close();
              // * --- End Select
            } // End If
          } // End If
          /* If qbe_allrapotit_tec->TIPOOPRAP='50' or qbe_allrapotit_tec->TIPOOPRAP='52' */
          if (CPLib.eqr(Cursor_qbe_allrapotit_tec.GetString("TIPOOPRAP"),"50") || CPLib.eqr(Cursor_qbe_allrapotit_tec.GetString("TIPOOPRAP"),"52")) {
            // * --- Select from intestit
            m_cServer = m_Ctx.GetServer("intestit");
            m_cPhName = m_Ctx.GetPhName("intestit");
            if (Cursor_intestit!=null)
              Cursor_intestit.Close();
            Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CONNESCLI"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestit.Eof())) {
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"00000064")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000064(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
              /* xProg := arfn_chkspers(intestit->CODINTER,qbe_allrapotit_tec->DATAREG) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_intestit.GetString("CODINTER"),Cursor_qbe_allrapotit_tec.GetDate("DATAREG"));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"00000068")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapotit_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestit.GetString("CODINTER"))+"";
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
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"0000006A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapotit_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestit.GetString("CODINTER"))+"";
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
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
              /* _intest := 'S' */
              _intest = "S";
              Cursor_intestit.Next();
            }
            m_cConnectivityError = Cursor_intestit.ErrorMessage();
            Cursor_intestit.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from intestit
            m_cServer = m_Ctx.GetServer("intestit");
            m_cPhName = m_Ctx.GetPhName("intestit");
            if (Cursor_intestit!=null)
              Cursor_intestit.Close();
            Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CONNESCLI"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestit.Eof())) {
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"0000006E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000006E(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
              /* xProg := arfn_chkspers(intestit->CODINTER,qbe_allrapotit_tec->DATAREG) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_intestit.GetString("CODINTER"),Cursor_qbe_allrapotit_tec.GetDate("DATAREG"));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"00000072")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapotit_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestit.GetString("CODINTER"))+"";
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
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"00000074")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapotit_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestit.GetString("CODINTER"))+"";
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
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
              /* _intest := 'S' */
              _intest = "S";
              Cursor_intestit.Next();
            }
            m_cConnectivityError = Cursor_intestit.ErrorMessage();
            Cursor_intestit.Close();
            // * --- End Select
          } // End If
          /* Case qbe_allrapotit_tec->TIPOOPRAP='54' or qbe_allrapotit_tec->TIPOOPRAP='55' or qbe_allrapotit_tec->TIPOOPRAP='58' */
        } else if (CPLib.eqr(Cursor_qbe_allrapotit_tec.GetString("TIPOOPRAP"),"54") || CPLib.eqr(Cursor_qbe_allrapotit_tec.GetString("TIPOOPRAP"),"55") || CPLib.eqr(Cursor_qbe_allrapotit_tec.GetString("TIPOOPRAP"),"58")) {
          /* If not(Empty(qbe_allrapotit_tec->CONNESCLI)) */
          if ( ! (CPLib.Empty(Cursor_qbe_allrapotit_tec.GetString("CONNESCLI")))) {
            /* xProg := '' */
            xProg = "";
            // * --- Insert into tmp_soggettioper from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"00000078")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000078(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipoleg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
            /* xProg := arfn_chkspers(qbe_allrapotit_tec->CONNESCLI,iif(qbe_allrapotit_tec->TIPOOPRAP='54',arfn_dateminus(qbe_allrapotit_tec->DATAREG,1),qbe_allrapotit_tec->DATAREG)) */
            xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allrapotit_tec.GetString("CONNESCLI"),(CPLib.eqr(Cursor_qbe_allrapotit_tec.GetString("TIPOOPRAP"),"54")?arfn_dateminusR.Make(m_Ctx,this).Run(Cursor_qbe_allrapotit_tec.GetDate("DATAREG"),1):Cursor_qbe_allrapotit_tec.GetDate("DATAREG")));
            /* If Empty(LRTrim(xProg)) */
            if (CPLib.Empty(CPLib.LRTrim(xProg))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"0000007C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapotit_tec.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapotit_tec.GetString("CONNESCLI"))+"";
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
              Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wersonbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"0000007E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapotit_tec.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapotit_tec.GetString("CONNESCLI"))+"";
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
                Cursor_wersonbo.Next();
              }
              m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
              Cursor_wersonbo.Close();
              // * --- End Select
            } // End If
          } // End If
          /* If qbe_allrapotit_tec->TIPOOPRAP='54' */
          if (CPLib.eqr(Cursor_qbe_allrapotit_tec.GetString("TIPOOPRAP"),"54")) {
            // * --- Select from intestit
            m_cServer = m_Ctx.GetServer("intestit");
            m_cPhName = m_Ctx.GetPhName("intestit");
            if (Cursor_intestit!=null)
              Cursor_intestit.Close();
            Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestit.Eof())) {
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"00000082")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000082(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
              /* xProg := arfn_chkspers(intestit->CODINTER,arfn_dateminus(qbe_allrapotit_tec->DATAREG,1)) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_intestit.GetString("CODINTER"),arfn_dateminusR.Make(m_Ctx,this).Run(Cursor_qbe_allrapotit_tec.GetDate("DATAREG"),1));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"00000086")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapotit_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestit.GetString("CODINTER"))+"";
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
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"00000088")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapotit_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestit.GetString("CODINTER"))+"";
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
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
              /* _intest := 'S' */
              _intest = "S";
              Cursor_intestit.Next();
            }
            m_cConnectivityError = Cursor_intestit.ErrorMessage();
            Cursor_intestit.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from intestit
            m_cServer = m_Ctx.GetServer("intestit");
            m_cPhName = m_Ctx.GetPhName("intestit");
            if (Cursor_intestit!=null)
              Cursor_intestit.Close();
            Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestit.Eof())) {
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"0000008C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000008C(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
              /* xProg := arfn_chkspers(intestit->CODINTER,qbe_allrapotit_tec->DATAREG) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_intestit.GetString("CODINTER"),Cursor_qbe_allrapotit_tec.GetDate("DATAREG"));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"00000090")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapotit_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestit.GetString("CODINTER"))+"";
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
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"00000092")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapotit_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestit.GetString("CODINTER"))+"";
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
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
              /* _intest := 'S' */
              _intest = "S";
              Cursor_intestit.Next();
            }
            m_cConnectivityError = Cursor_intestit.ErrorMessage();
            Cursor_intestit.Close();
            // * --- End Select
          } // End If
        } // End Case
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          // * --- Write into tmp_stpoperazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"00000095")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TIPOINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
          // * --- Write into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"00000096")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TIPOINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* Exec "Stampa " Page 4:Stampa */
        Stampa();
        Cursor_qbe_allrapotit_tec.Next();
      }
      m_cConnectivityError = Cursor_qbe_allrapotit_tec.ErrorMessage();
      Cursor_qbe_allrapotit_tec.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_allrapotit_tec!=null)
          Cursor_qbe_allrapotit_tec.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
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
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
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
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_allxapotit_tec=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_xntestit=null;
    CPResultSet Cursor_intermbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_allxapotit_tec
      if (Cursor_qbe_allxapotit_tec!=null)
        Cursor_qbe_allxapotit_tec.Close();
      Cursor_qbe_allxapotit_tec = new VQRHolder("qbe_allxapotit_tec",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_allxapotit_tec.Eof())) {
        /* gMsgImp := "Elaborazione dell'informazione n. "+LRTrim(qbe_allxapotit_tec->NUMPROG) // Messaggio Import */
        gMsgImp = "Elaborazione dell'informazione n. "+CPLib.LRTrim(Cursor_qbe_allxapotit_tec.GetString("NUMPROG"));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* _intest := 'N' */
        _intest = "N";
        /* _id := Right('000000'+LRTrim(Str(_conta,10,0)),6) */
        _id = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta,10,0)),6);
        /* _tipoleg := iif(qbe_allxapotit_tec->TIPOLEG='5','7','9') */
        _tipoleg = (CPLib.eqr(Cursor_qbe_allxapotit_tec.GetString("TIPOLEG"),"5")?"7":"9");
        /* _dataope := qbe_allxapotit_tec->DATAOPE */
        _dataope = Cursor_qbe_allxapotit_tec.GetDate("DATAOPE");
        // * --- Delete from tmp_stpoperazioni
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"0000009F")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
        // * --- Delete from tmp_soggettioper
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_soggettioper");
        m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000A0")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
        // * --- Insert into tmp_stpoperazioni from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000A1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000000A1(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetDate("DATAOPE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("DIPCIT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("DIPPRV"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("DIPCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetDate("DATAREG"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetDate("DATARETT"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpoperazioni",true);
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
        /* Case qbe_allxapotit_tec->TIPOOPRAP='50' or qbe_allxapotit_tec->TIPOOPRAP='51' or qbe_allxapotit_tec->TIPOOPRAP='52' or qbe_allxapotit_tec->TIPOOPRAP='53' */
        if (CPLib.eqr(Cursor_qbe_allxapotit_tec.GetString("TIPOOPRAP"),"50") || CPLib.eqr(Cursor_qbe_allxapotit_tec.GetString("TIPOOPRAP"),"51") || CPLib.eqr(Cursor_qbe_allxapotit_tec.GetString("TIPOOPRAP"),"52") || CPLib.eqr(Cursor_qbe_allxapotit_tec.GetString("TIPOOPRAP"),"53")) {
          /* If not(Empty(qbe_allxapotit_tec->CONNESCLI)) */
          if ( ! (CPLib.Empty(Cursor_qbe_allxapotit_tec.GetString("CONNESCLI")))) {
            /* xProg := '' */
            xProg = "";
            // * --- Insert into tmp_soggettioper from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000A5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000A5(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipoleg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
            /* xProg := arfn_chkspers(qbe_allxapotit_tec->CONNESCLI,qbe_allxapotit_tec->DATAREG) */
            xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allxapotit_tec.GetString("CONNESCLI"),Cursor_qbe_allxapotit_tec.GetDate("DATAREG"));
            /* If Empty(LRTrim(xProg)) */
            if (CPLib.Empty(CPLib.LRTrim(xProg))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000A9")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapotit_tec.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapotit_tec.GetString("CONNESCLI"))+"";
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
              Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wersonbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000AB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapotit_tec.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapotit_tec.GetString("CONNESCLI"))+"";
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
                Cursor_wersonbo.Next();
              }
              m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
              Cursor_wersonbo.Close();
              // * --- End Select
            } // End If
          } // End If
          /* If qbe_allxapotit_tec->TIPOOPRAP='50' or qbe_allxapotit_tec->TIPOOPRAP='52' */
          if (CPLib.eqr(Cursor_qbe_allxapotit_tec.GetString("TIPOOPRAP"),"50") || CPLib.eqr(Cursor_qbe_allxapotit_tec.GetString("TIPOOPRAP"),"52")) {
            // * --- Select from xntestit
            m_cServer = m_Ctx.GetServer("xntestit");
            m_cPhName = m_Ctx.GetPhName("xntestit");
            if (Cursor_xntestit!=null)
              Cursor_xntestit.Close();
            Cursor_xntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CONNESCLI"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestit.Eof())) {
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000AF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000AF(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
              /* xProg := arfn_chkspers(xntestit->CODINTER,qbe_allxapotit_tec->DATAREG) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xntestit.GetString("CODINTER"),Cursor_qbe_allxapotit_tec.GetDate("DATAREG"));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000B3")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapotit_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestit.GetString("CODINTER"))+"";
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
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000B5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapotit_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestit.GetString("CODINTER"))+"";
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
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
              /* _intest := 'S' */
              _intest = "S";
              Cursor_xntestit.Next();
            }
            m_cConnectivityError = Cursor_xntestit.ErrorMessage();
            Cursor_xntestit.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from xntestit
            m_cServer = m_Ctx.GetServer("xntestit");
            m_cPhName = m_Ctx.GetPhName("xntestit");
            if (Cursor_xntestit!=null)
              Cursor_xntestit.Close();
            Cursor_xntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CONNESCLI"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestit.Eof())) {
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000B9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000B9(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
              /* xProg := arfn_chkspers(xntestit->CODINTER,qbe_allxapotit_tec->DATAREG) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xntestit.GetString("CODINTER"),Cursor_qbe_allxapotit_tec.GetDate("DATAREG"));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000BD")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapotit_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestit.GetString("CODINTER"))+"";
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
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000BF")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapotit_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestit.GetString("CODINTER"))+"";
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
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
              /* _intest := 'S' */
              _intest = "S";
              Cursor_xntestit.Next();
            }
            m_cConnectivityError = Cursor_xntestit.ErrorMessage();
            Cursor_xntestit.Close();
            // * --- End Select
          } // End If
          /* Case qbe_allxapotit_tec->TIPOOPRAP='54' or qbe_allxapotit_tec->TIPOOPRAP='55' or qbe_allxapotit_tec->TIPOOPRAP='58' */
        } else if (CPLib.eqr(Cursor_qbe_allxapotit_tec.GetString("TIPOOPRAP"),"54") || CPLib.eqr(Cursor_qbe_allxapotit_tec.GetString("TIPOOPRAP"),"55") || CPLib.eqr(Cursor_qbe_allxapotit_tec.GetString("TIPOOPRAP"),"58")) {
          /* If not(Empty(qbe_allxapotit_tec->CONNESCLI)) */
          if ( ! (CPLib.Empty(Cursor_qbe_allxapotit_tec.GetString("CONNESCLI")))) {
            /* xProg := '' */
            xProg = "";
            // * --- Insert into tmp_soggettioper from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000C3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000C3(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipoleg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
            /* xProg := arfn_chkspers(qbe_allxapotit_tec->CONNESCLI,iif(qbe_allxapotit_tec->TIPOOPRAP='54',arfn_dateminus(qbe_allxapotit_tec->DATAREG,1),qbe_allxapotit_tec->DATAREG)) */
            xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allxapotit_tec.GetString("CONNESCLI"),(CPLib.eqr(Cursor_qbe_allxapotit_tec.GetString("TIPOOPRAP"),"54")?arfn_dateminusR.Make(m_Ctx,this).Run(Cursor_qbe_allxapotit_tec.GetDate("DATAREG"),1):Cursor_qbe_allxapotit_tec.GetDate("DATAREG")));
            /* If Empty(LRTrim(xProg)) */
            if (CPLib.Empty(CPLib.LRTrim(xProg))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000C7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapotit_tec.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapotit_tec.GetString("CONNESCLI"))+"";
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
              Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wersonbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000C9")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapotit_tec.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapotit_tec.GetString("CONNESCLI"))+"";
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
                Cursor_wersonbo.Next();
              }
              m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
              Cursor_wersonbo.Close();
              // * --- End Select
            } // End If
          } // End If
          /* If qbe_allxapotit_tec->TIPOOPRAP='54' */
          if (CPLib.eqr(Cursor_qbe_allxapotit_tec.GetString("TIPOOPRAP"),"54")) {
            // * --- Select from xntestit
            m_cServer = m_Ctx.GetServer("xntestit");
            m_cPhName = m_Ctx.GetPhName("xntestit");
            if (Cursor_xntestit!=null)
              Cursor_xntestit.Close();
            Cursor_xntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestit.Eof())) {
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000CD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000CD(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
              /* xProg := arfn_chkspers(xntestit->CODINTER,arfn_dateminus(qbe_allxapotit_tec->DATAREG,1)) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xntestit.GetString("CODINTER"),arfn_dateminusR.Make(m_Ctx,this).Run(Cursor_qbe_allxapotit_tec.GetDate("DATAREG"),1));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000D1")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapotit_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestit.GetString("CODINTER"))+"";
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
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000D3")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapotit_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestit.GetString("CODINTER"))+"";
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
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
              /* _intest := 'S' */
              _intest = "S";
              Cursor_xntestit.Next();
            }
            m_cConnectivityError = Cursor_xntestit.ErrorMessage();
            Cursor_xntestit.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from xntestit
            m_cServer = m_Ctx.GetServer("xntestit");
            m_cPhName = m_Ctx.GetPhName("xntestit");
            if (Cursor_xntestit!=null)
              Cursor_xntestit.Close();
            Cursor_xntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xntestit.Eof())) {
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000D7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000D7(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_soggettioper",true);
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
              /* xProg := arfn_chkspers(xntestit->CODINTER,qbe_allxapotit_tec->DATAREG) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xntestit.GetString("CODINTER"),Cursor_qbe_allxapotit_tec.GetDate("DATAREG"));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000DB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapotit_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestit.GetString("CODINTER"))+"";
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
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(xProg,"?",0,0,m_cServer, m_oParameters),m_cServer,xProg)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000DD")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapotit_tec.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapotit_tec.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestit.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestit.GetString("CODINTER"))+"";
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
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
              /* _intest := 'S' */
              _intest = "S";
              Cursor_xntestit.Next();
            }
            m_cConnectivityError = Cursor_xntestit.ErrorMessage();
            Cursor_xntestit.Close();
            // * --- End Select
          } // End If
        } // End Case
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          // * --- Write into tmp_stpoperazioni from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000E0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TIPOINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
          // * --- Write into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_tit_new",179,"000000E1")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TIPOINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_intermbo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* Exec "Stampa " Page 4:Stampa */
        Stampa();
        Cursor_qbe_allxapotit_tec.Next();
      }
      m_cConnectivityError = Cursor_qbe_allxapotit_tec.ErrorMessage();
      Cursor_qbe_allxapotit_tec.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_allxapotit_tec!=null)
          Cursor_qbe_allxapotit_tec.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
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
        if (Cursor_xntestit!=null)
          Cursor_xntestit.Close();
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
    }
  }
  void Stampa() throws Exception {
    /* _report := ReportLibrary.GetReportLibrary() */
    _report = ReportLibrary.Make(m_Ctx).GetReportLibrary();
    /* _report.SetParameterChar('outputFormat',pPDF) */
    _report.SetParameterChar("outputFormat",pPDF);
    /* _report.setParameterChar('w_daCodDip',w_daCodDip) */
    _report.setParameterChar("w_daCodDip",w_daCodDip);
    /* _report.setParameterChar('w_aCodDip',w_aCodDip) */
    _report.setParameterChar("w_aCodDip",w_aCodDip);
    /* _report.setParameterChar('w_daCodCli',w_daCodCli) */
    _report.setParameterChar("w_daCodCli",w_daCodCli);
    /* _report.setParameterChar('w_aCodCli',w_aCodCli) */
    _report.setParameterChar("w_aCodCli",w_aCodCli);
    /* _report.setParameterChar('w_c_dadata',w_c_dadata) */
    _report.setParameterChar("w_c_dadata",w_c_dadata);
    /* _report.setParameterChar('w_c_adata',w_c_adata) */
    _report.setParameterChar("w_c_adata",w_c_adata);
    /* _report.setParameterChar('DescAzi',gDescAzi) */
    _report.setParameterChar("DescAzi",gDescAzi);
    /* _report.setParameterChar('pAUI',pAUI) */
    _report.setParameterChar("pAUI",pAUI);
    /* _nomerep := '' */
    _nomerep = "";
    /* If _dataope < CharToDate('20140101') */
    if (CPLib.lt(_dataope,CPLib.CharToDate("20140101"))) {
      /* _varrep := 'arrp_stp_stdtec_tit' */
      _varrep = "arrp_stp_stdtec_tit";
    } else { // Else
      /* _varrep := 'arrp_stp_stdtec_tit_new' */
      _varrep = "arrp_stp_stdtec_tit_new";
    } // End If
    /* Exec "Stampa singola Pagina" Page 5:StampaPag */
    StampaPag();
    /* If _dataope < CharToDate('20140101') */
    if (CPLib.lt(_dataope,CPLib.CharToDate("20140101"))) {
      /* _varrep := 'arrp_stp_stdtec_tit_1' */
      _varrep = "arrp_stp_stdtec_tit_1";
    } else { // Else
      /* If _tipoleg='7' */
      if (CPLib.eqr(_tipoleg,"7")) {
        /* _varrep := 'arrp_stp_stdtec_tit_1_7' */
        _varrep = "arrp_stp_stdtec_tit_1_7";
      } else { // Else
        /* _varrep := 'arrp_stp_stdtec_tit_1_9' */
        _varrep = "arrp_stp_stdtec_tit_1_9";
      } // End If
    } // End If
    /* Exec "Stampa singola Pagina" Page 5:StampaPag */
    StampaPag();
    /* If _intest='S' */
    if (CPLib.eqr(_intest,"S")) {
      /* If _dataope < CharToDate('20140101') */
      if (CPLib.lt(_dataope,CPLib.CharToDate("20140101"))) {
        /* _varrep := 'arrp_stp_stdtec_tit_2' */
        _varrep = "arrp_stp_stdtec_tit_2";
      } else { // Else
        /* _varrep := 'arrp_stp_stdtec_tit_2_new' */
        _varrep = "arrp_stp_stdtec_tit_2_new";
      } // End If
      /* Exec "Stampa singola Pagina" Page 5:StampaPag */
      StampaPag();
    } // End If
    /* _nomerep := Left(_nomerep,Len(LRTrim(_nomerep)) - 1) // Nome Stampa */
    _nomerep = CPLib.Left(_nomerep,CPLib.Len(CPLib.LRTrim(_nomerep))-1);
    /* If pPDF='PDF' */
    if (CPLib.eqr(pPDF,"PDF")) {
      /* bReport := _report.MergingPdf(_nomerep,LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/stampa_stdtec_'+_id+'.pdf',true) */
      bReport = _report.MergingPdf(_nomerep,CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/stampa_stdtec_"+_id+".pdf",true);
    } else { // Else
      /* bReport := _report.MergingPdfA(_nomerep,LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/stampa_stdtec_'+_id+'.pdf',true) */
      bReport = _report.MergingPdfA(_nomerep,CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/stampa_stdtec_"+_id+".pdf",true);
    } // End If
    /* _report.cleanObj() */
    _report.cleanObj();
    /* mcFileList.AppendBlank() */
    mcFileList.AppendBlank();
    /* mcFileList.nomefile := 'stampa_stdtec_'+_id+'.pdf' */
    mcFileList.row.nomefile = "stampa_stdtec_"+_id+".pdf";
    /* mcFileList.priorita := _conta */
    mcFileList.row.priorita = _conta;
    /* mcFileList.SaveRow() */
    mcFileList.SaveRow();
  }
  void StampaPag() throws Exception {
    /* _report.SetParameterNumeric('nNumPage',nPag) */
    _report.SetParameterNumeric("nNumPage",nPag);
    /* bReport := _report.makeReport(_varrep,LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/'+_varrep+'_'+_id+'.pdf','A4','PORTRAIT',pPDF) */
    bReport = _report.makeReport(_varrep,CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+_varrep+"_"+_id+".pdf","A4","PORTRAIT",pPDF);
    /* If bReport */
    if (bReport) {
      /* _nomerep := _nomerep + LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/'+_varrep+'_'+_id+'.pdf;' // Nome Stampa */
      _nomerep = _nomerep+CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+_varrep+"_"+_id+".pdf;";
      /* nPag := _report.GetnNumPage()+1 */
      nPag = CPLib.Round(_report.GetnNumPage()+1,0);
    } // End If
  }
  void _init_() {
  }
  public String RunAsync(String p_pAUI,String p_pPDF,java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,java.sql.Date p_w_DaDatReg,java.sql.Date p_w_ADatReg,String p_w_daCodCli,String p_w_aCodCli,String p_w_daCodDip,String p_w_aCodDip) {
    pAUI = p_pAUI;
    pPDF = p_pPDF;
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_DaDatReg = p_w_DaDatReg;
    w_ADatReg = p_w_ADatReg;
    w_daCodCli = p_w_daCodCli;
    w_aCodCli = p_w_aCodCli;
    w_daCodDip = p_w_daCodDip;
    w_aCodDip = p_w_aCodDip;
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
  public Forward Run(String p_pAUI,String p_pPDF,java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,java.sql.Date p_w_DaDatReg,java.sql.Date p_w_ADatReg,String p_w_daCodCli,String p_w_aCodCli,String p_w_daCodDip,String p_w_aCodDip) {
    pAUI = p_pAUI;
    pPDF = p_pPDF;
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_DaDatReg = p_w_DaDatReg;
    w_ADatReg = p_w_ADatReg;
    w_daCodCli = p_w_daCodCli;
    w_aCodCli = p_w_aCodCli;
    w_daCodDip = p_w_daCodDip;
    w_aCodDip = p_w_aCodDip;
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
  public static arrt_stp_stdtec_tit_newR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stp_stdtec_tit_newR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pAUI = CPLib.Space(1);
    pPDF = CPLib.Space(6);
    w_DaDatOpe = CPLib.NullDate();
    w_ADatOpe = CPLib.NullDate();
    w_DaDatReg = CPLib.NullDate();
    w_ADatReg = CPLib.NullDate();
    w_daCodCli = CPLib.Space(16);
    w_aCodCli = CPLib.Space(16);
    w_daCodDip = CPLib.Space(6);
    w_aCodDip = CPLib.Space(6);
    _nomerep = "";
    _report = null;
    bReport = false;
    _id = CPLib.Space(6);
    _idrep = CPLib.Space(10);
    _conta = 0;
    _numsto = CPLib.Space(15);
    _tipoleg = CPLib.Space(1);
    w_c_dadata = CPLib.Space(8);
    w_c_adata = CPLib.Space(8);
    w_dacdatreg = CPLib.Space(8);
    w_acdatreg = CPLib.Space(8);
    xProg = CPLib.Space(15);
    lReport = "";
    _avanza = 0;
    _connescli = CPLib.Space(16);
    _reportname = CPLib.Space(100);
    filepdf = CPLib.Space(128);
    _dataope = CPLib.NullDate();
    _varrep = CPLib.Space(30);
    nPag = 0;
    _intest = CPLib.Space(1);
    mcFileList = new MemoryCursor_mclistafile_mcrdef();
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_allrapotit_tec,qbe_allxapotit_tec,
  public static final String m_cVQRList = ",qbe_allrapotit_tec,qbe_allxapotit_tec,";
  // ENTITY_BATCHES: ,arfn_chkspers,arfn_dateminus,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_chkspers,arfn_dateminus,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"pAUI","pPDF","w_DaDatOpe","w_ADatOpe","w_DaDatReg","w_ADatReg","w_daCodCli","w_aCodCli","w_daCodDip","w_aCodDip"};
  protected static String GetFieldsName_00000056(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000005A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000064(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000006E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000078(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000082(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000008C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000AF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000CD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_soggettioper",true);
    return p_cSql;
  }
}
