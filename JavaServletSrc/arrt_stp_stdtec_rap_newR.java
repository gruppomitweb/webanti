// * --- Area Manuale = BO - Header
// * --- arrt_stp_stdtec_rap_new
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
public class arrt_stp_stdtec_rap_newR implements CallerWithObjs {
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
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_fiduciabo;
  public String m_cServer_fiduciabo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_soginfo;
  public String m_cServer_soginfo;
  public String m_cPhName_tmp_soggettioper;
  public String m_cServer_tmp_soggettioper;
  public String m_cPhName_tmp_stpoperazioni;
  public String m_cServer_tmp_stpoperazioni;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_xelegabo;
  public String m_cServer_xelegabo;
  public String m_cPhName_xiduciabo;
  public String m_cServer_xiduciabo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xoginfo;
  public String m_cServer_xoginfo;
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
  public String w_daRapporto;
  public String w_aRapporto;
  public String w_daCodDip;
  public String w_aCodDip;
  public String _nomerep;
  public ReportLibrary _report;
  public boolean bReport;
  public String _id;
  public String _idrep;
  public double _conta;
  public String _numsto;
  public String w_c_dadata;
  public String w_c_adata;
  public String w_dacdatreg;
  public String w_acdatreg;
  public String xProg;
  public String lReport;
  public double _avanza;
  public String _intest;
  public String _delega;
  public String _titola;
  public String _esecut;
  public String w_idinfo;
  public double _trovati;
  public java.sql.Date _dataope;
  public String _varrep;
  public String _reportname;
  public String filepdf;
  public double nPag;
  public MemoryCursor_mclistafile_mcrdef mcFileList;
  public String gDescAzi;
  public String gAzienda;
  public String gPathApp;
  public String gUrlApp;
  public String gMsgImp;
  public String gMsgProc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_stp_stdtec_rap_newR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stp_stdtec_rap_new",m_Caller);
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_fiduciabo = p_ContextObject.GetPhName("fiduciabo");
    if (m_cPhName_fiduciabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fiduciabo = m_cPhName_fiduciabo+" "+m_Ctx.GetWritePhName("fiduciabo");
    }
    m_cServer_fiduciabo = p_ContextObject.GetServer("fiduciabo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_soginfo = p_ContextObject.GetPhName("soginfo");
    if (m_cPhName_soginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_soginfo = m_cPhName_soginfo+" "+m_Ctx.GetWritePhName("soginfo");
    }
    m_cServer_soginfo = p_ContextObject.GetServer("soginfo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_soggettioper")) {
      m_cPhName_tmp_soggettioper = p_ContextObject.GetPhName("tmp_soggettioper");
      if (m_cPhName_tmp_soggettioper.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_soggettioper = m_cPhName_tmp_soggettioper+" "+m_Ctx.GetWritePhName("tmp_soggettioper");
      }
      m_cServer_tmp_soggettioper = p_ContextObject.GetServer("tmp_soggettioper");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stpoperazioni")) {
      m_cPhName_tmp_stpoperazioni = p_ContextObject.GetPhName("tmp_stpoperazioni");
      if (m_cPhName_tmp_stpoperazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stpoperazioni = m_cPhName_tmp_stpoperazioni+" "+m_Ctx.GetWritePhName("tmp_stpoperazioni");
      }
      m_cServer_tmp_stpoperazioni = p_ContextObject.GetServer("tmp_stpoperazioni");
    }
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_xelegabo = p_ContextObject.GetPhName("xelegabo");
    if (m_cPhName_xelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xelegabo = m_cPhName_xelegabo+" "+m_Ctx.GetWritePhName("xelegabo");
    }
    m_cServer_xelegabo = p_ContextObject.GetServer("xelegabo");
    m_cPhName_xiduciabo = p_ContextObject.GetPhName("xiduciabo");
    if (m_cPhName_xiduciabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xiduciabo = m_cPhName_xiduciabo+" "+m_Ctx.GetWritePhName("xiduciabo");
    }
    m_cServer_xiduciabo = p_ContextObject.GetServer("xiduciabo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_xoginfo = p_ContextObject.GetPhName("xoginfo");
    if (m_cPhName_xoginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xoginfo = m_cPhName_xoginfo+" "+m_Ctx.GetWritePhName("xoginfo");
    }
    m_cServer_xoginfo = p_ContextObject.GetServer("xoginfo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_avanza",p_cVarName)) {
      return _avanza;
    }
    if (CPLib.eqr("_trovati",p_cVarName)) {
      return _trovati;
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
      return "arrt_stp_stdtec_rap_new";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pAUI",p_cVarName)) {
      return pAUI;
    }
    if (CPLib.eqr("pPDF",p_cVarName)) {
      return pPDF;
    }
    if (CPLib.eqr("daRapporto",p_cVarName)) {
      return w_daRapporto;
    }
    if (CPLib.eqr("aRapporto",p_cVarName)) {
      return w_aRapporto;
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
    if (CPLib.eqr("_intest",p_cVarName)) {
      return _intest;
    }
    if (CPLib.eqr("_delega",p_cVarName)) {
      return _delega;
    }
    if (CPLib.eqr("_titola",p_cVarName)) {
      return _titola;
    }
    if (CPLib.eqr("_esecut",p_cVarName)) {
      return _esecut;
    }
    if (CPLib.eqr("idinfo",p_cVarName)) {
      return w_idinfo;
    }
    if (CPLib.eqr("_varrep",p_cVarName)) {
      return _varrep;
    }
    if (CPLib.eqr("_reportname",p_cVarName)) {
      return _reportname;
    }
    if (CPLib.eqr("filepdf",p_cVarName)) {
      return filepdf;
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
    if (CPLib.eqr("_trovati",p_cVarName)) {
      _trovati = value;
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
    if (CPLib.eqr("daRapporto",p_cVarName)) {
      w_daRapporto = value;
      return;
    }
    if (CPLib.eqr("aRapporto",p_cVarName)) {
      w_aRapporto = value;
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
    if (CPLib.eqr("_intest",p_cVarName)) {
      _intest = value;
      return;
    }
    if (CPLib.eqr("_delega",p_cVarName)) {
      _delega = value;
      return;
    }
    if (CPLib.eqr("_titola",p_cVarName)) {
      _titola = value;
      return;
    }
    if (CPLib.eqr("_esecut",p_cVarName)) {
      _esecut = value;
      return;
    }
    if (CPLib.eqr("idinfo",p_cVarName)) {
      w_idinfo = value;
      return;
    }
    if (CPLib.eqr("_varrep",p_cVarName)) {
      _varrep = value;
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
    /* w_daRapporto Char(25) */
    /* w_aRapporto Char(25) */
    /* w_daCodDip Char(6) */
    /* w_aCodDip Char(6) */
    /* _nomerep Memo // Nome Stampa */
    /* _report Object(ReportLibrary) */
    /* bReport Bool */
    /* _id Char(6) */
    /* _idrep Char(10) */
    /* _conta Numeric(10, 0) */
    /* _numsto Char(15) */
    /* w_c_dadata Char(8) */
    /* w_c_adata Char(8) */
    /* w_dacdatreg Char(8) */
    /* w_acdatreg Char(8) */
    /* xProg Char(15) */
    /* lReport Memo */
    /* _avanza Numeric(1, 0) */
    /* _intest Char(1) */
    /* _delega Char(1) */
    /* _titola Char(1) */
    /* _esecut Char(1) */
    /* w_idinfo Char(10) */
    /* _trovati Numeric(1, 0) // Ha trovasto intestatari o fiducianti */
    /* _dataope Date */
    /* _varrep Char(30) */
    /* _reportname Char(100) */
    /* filepdf Char(128) */
    /* nPag Numeric(10, 0) */
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
    /* _delega := 'N' */
    _delega = "N";
    /* _titola := 'N' */
    _titola = "N";
    /* _esecut := 'N' */
    _esecut = "N";
    /* nPag := 1 */
    nPag = CPLib.Round(1,0);
    /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* Case pAUI='D' */
    if (CPLib.eqr(pAUI,"D")) {
      /* Exec "Rapporti AUI" Page 2:Page_2 */
      Page_2();
      /* Case pAUI='P' */
    } else if (CPLib.eqr(pAUI,"P")) {
      /* Exec "Rapporti Prov." Page 3:Page_3 */
      Page_3();
    } // End Case
    /* If mcFileList.RecCount() > 0 */
    if (CPLib.gt(mcFileList.RecCount(),0)) {
      /* _reportname := 'rapporti_stdtec_'+DateToChar(Date())+'.pdf' */
      _reportname = "rapporti_stdtec_"+CPLib.DateToChar(CPLib.Date())+".pdf";
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
      /* gMsgImp := "Elaborazione terminata!" */
      gMsgImp = "Elaborazione terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Sono state elaborate '+LRTrim(Str(_conta,10,0))+" informazioni" + NL */
      gMsgProc = gMsgProc+"Sono state elaborate "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" informazioni"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
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
      /* gMsgImp := "Elaborazione terminata!" */
      gMsgImp = "Elaborazione terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
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
    CPResultSet Cursor_qbe_allrapopebo_tec=null;
    CPResultSet Cursor_intermbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_allrapopebo_tec
      if (Cursor_qbe_allrapopebo_tec!=null)
        Cursor_qbe_allrapopebo_tec.Close();
      Cursor_qbe_allrapopebo_tec = new VQRHolder("qbe_allrapopebo_tec",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_allrapopebo_tec.Eof())) {
        /* gMsgImp := "Elaborazione dell'informazione n. "+ LRTrim(qbe_allrapopebo_tec->NUMPROG) */
        gMsgImp = "Elaborazione dell'informazione n. "+CPLib.LRTrim(Cursor_qbe_allrapopebo_tec.GetString("NUMPROG"));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _intest := 'N' */
        _intest = "N";
        /* _delega := 'N' */
        _delega = "N";
        /* _titola := 'N' */
        _titola = "N";
        /* _esecut := 'N' */
        _esecut = "N";
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* _id := Right('000000'+LRTrim(Str(_conta,10,0)),6) */
        _id = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta,10,0)),6);
        /* w_idinfo := qbe_allrapopebo_tec->IDBASE */
        w_idinfo = Cursor_qbe_allrapopebo_tec.GetString("IDBASE");
        /* _dataope := qbe_allrapopebo_tec->DATAOPE */
        _dataope = Cursor_qbe_allrapopebo_tec.GetDate("DATAOPE");
        // * --- Delete from tmp_stpoperazioni
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000005D")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000005E")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000005F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000005F(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetDate("DATAOPE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("DIPCIT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("DIPPRV"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("DIPCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetDate("DATAREG"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetDate("DATARETT"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("FLAGLIRE1"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("VALUTA1"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
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
        /* Case qbe_allrapopebo_tec->TIPOOPRAP='25' or qbe_allrapopebo_tec->TIPOOPRAP='28' or qbe_allrapopebo_tec->TIPOOPRAP='39' or qbe_allrapopebo_tec->TIPOOPRAP='40' or qbe_allrapopebo_tec->TIPOOPRAP='41' or qbe_allrapopebo_tec->TIPOOPRAP='47' */
        if (CPLib.eqr(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),"28") || CPLib.eqr(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),"39") || CPLib.eqr(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),"40") || CPLib.eqr(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),"41") || CPLib.eqr(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),"47")) {
          /* Exec "RapAUI Deleghe" Page 4:Page_4 */
          Page_4();
          /* Case Right(qbe_allrapopebo_tec->TIPOOPRAP,1)='6' or qbe_allrapopebo_tec->TIPOOPRAP='38' */
        } else if (CPLib.eqr(CPLib.Right(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),1),"6") || CPLib.eqr(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),"38")) {
          /* Exec "RapAUI Chiusure" Page 6:Page_6 */
          Page_6();
          /* Case qbe_allrapopebo_tec->TIPOOPRAP='31' or qbe_allrapopebo_tec->TIPOOPRAP='32' */
        } else if (CPLib.eqr(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),"31") || CPLib.eqr(Cursor_qbe_allrapopebo_tec.GetString("TIPOOPRAP"),"32")) {
          /* Exec "RapAUI 31-32" Page 5:Page_5 */
          Page_5();
        } else { // Otherwise
          /* Exec "RapAUI Aperture" Page 7:Page_7 */
          Page_7();
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000066")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000067")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
        /* Exec "Stampa" Page 11:Stampa */
        Stampa();
        Cursor_qbe_allrapopebo_tec.Next();
      }
      m_cConnectivityError = Cursor_qbe_allrapopebo_tec.ErrorMessage();
      Cursor_qbe_allrapopebo_tec.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_allrapopebo_tec!=null)
          Cursor_qbe_allrapopebo_tec.Close();
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
    CPResultSet Cursor_qbe_allxapopebo_tec=null;
    CPResultSet Cursor_intermbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_allxapopebo_tec
      if (Cursor_qbe_allxapopebo_tec!=null)
        Cursor_qbe_allxapopebo_tec.Close();
      Cursor_qbe_allxapopebo_tec = new VQRHolder("qbe_allxapopebo_tec",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_allxapopebo_tec.Eof())) {
        /* gMsgImp := "Elaborazione dell'informazione n. "+ LRTrim(qbe_allxapopebo_tec->NUMPROG) */
        gMsgImp = "Elaborazione dell'informazione n. "+CPLib.LRTrim(Cursor_qbe_allxapopebo_tec.GetString("NUMPROG"));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _intest := 'N' */
        _intest = "N";
        /* _delega := 'N' */
        _delega = "N";
        /* _titola := 'N' */
        _titola = "N";
        /* _esecut := 'N' */
        _esecut = "N";
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* _id := Right('000000'+LRTrim(Str(_conta,10,0)),6) */
        _id = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(_conta,10,0)),6);
        /* w_idinfo := qbe_allxapopebo_tec->IDBASE */
        w_idinfo = Cursor_qbe_allxapopebo_tec.GetString("IDBASE");
        /* _dataope := qbe_allxapopebo_tec->DATAOPE */
        _dataope = Cursor_qbe_allxapopebo_tec.GetDate("DATAOPE");
        // * --- Delete from tmp_stpoperazioni
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
        m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000073")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000074")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000075")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000075(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetDate("DATAOPE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("DIPCIT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("DIPPRV"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("DIPCAB"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("TIPORAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetDate("DATAREG"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetDate("DATARETT"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("FLAGLIRE1"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("VALUTA1"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
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
        /* Case qbe_allxapopebo_tec->TIPOOPRAP='25' or qbe_allxapopebo_tec->TIPOOPRAP='28' or qbe_allxapopebo_tec->TIPOOPRAP='39' or qbe_allxapopebo_tec->TIPOOPRAP='40' or qbe_allxapopebo_tec->TIPOOPRAP='41' or qbe_allxapopebo_tec->TIPOOPRAP='47' */
        if (CPLib.eqr(Cursor_qbe_allxapopebo_tec.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_qbe_allxapopebo_tec.GetString("TIPOOPRAP"),"28") || CPLib.eqr(Cursor_qbe_allxapopebo_tec.GetString("TIPOOPRAP"),"39") || CPLib.eqr(Cursor_qbe_allxapopebo_tec.GetString("TIPOOPRAP"),"40") || CPLib.eqr(Cursor_qbe_allxapopebo_tec.GetString("TIPOOPRAP"),"41") || CPLib.eqr(Cursor_qbe_allxapopebo_tec.GetString("TIPOOPRAP"),"47")) {
          /* Exec "RapPRV Deleghe" Page 8:Page_8 */
          Page_8();
          /* Case Right(qbe_allxapopebo_tec->TIPOOPRAP,1)='6' or qbe_allxapopebo_tec->TIPOOPRAP='38' */
        } else if (CPLib.eqr(CPLib.Right(Cursor_qbe_allxapopebo_tec.GetString("TIPOOPRAP"),1),"6") || CPLib.eqr(Cursor_qbe_allxapopebo_tec.GetString("TIPOOPRAP"),"38")) {
          /* Exec "RapPRV Chiusure" Page 9:Page_9 */
          Page_9();
        } else { // Otherwise
          /* Exec "RapPRV Aperture" Page 10:Page_10 */
          Page_10();
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000007B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000007C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
        /* Exec "Stampa" Page 11:Stampa */
        Stampa();
        Cursor_qbe_allxapopebo_tec.Next();
      }
      m_cConnectivityError = Cursor_qbe_allxapopebo_tec.ErrorMessage();
      Cursor_qbe_allxapopebo_tec.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_allxapopebo_tec!=null)
          Cursor_qbe_allxapopebo_tec.Close();
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
  void Page_4() throws Exception {
    CPResultSet Cursor_qbe_allrapopebo_tec_one=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_fiduciabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_allrapopebo_tec_one
      SPBridge.HMCaller _h0000007E;
      _h0000007E = new SPBridge.HMCaller();
      _h0000007E.Set("m_cVQRList",m_cVQRList);
      _h0000007E.Set("idinfo",w_idinfo);
      if (Cursor_qbe_allrapopebo_tec_one!=null)
        Cursor_qbe_allrapopebo_tec_one.Close();
      Cursor_qbe_allrapopebo_tec_one = new VQRHolder("qbe_allrapopebo_tec_one",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000007E,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_allrapopebo_tec_one.Eof())) {
        /* If qbe_allrapopebo_tec_one->TIPOOPRAP='25' or qbe_allrapopebo_tec_one->TIPOOPRAP='39' or qbe_allrapopebo_tec_one->TIPOOPRAP='40' */
        if (CPLib.eqr(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOOPRAP"),"39") || CPLib.eqr(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOOPRAP"),"40")) {
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* If intestbo->DATAINI <= qbe_allrapopebo_tec_one->DATAOPE and (intestbo->DATAFINE >= qbe_allrapopebo_tec_one->DATAOPE or Empty(intestbo->DATAFINE)) */
            if (CPLib.le(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAOPE")) && (CPLib.ge(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAOPE")) || CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")))) {
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000083")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000083(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
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
              /* xProg := arfn_chkspers(intestbo->CODINTER,qbe_allrapopebo_tec_one->DATAREG) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG"));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000087")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000089")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
            } // End If
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          // * --- End Select
          // * --- Select from delegabo
          m_cServer = m_Ctx.GetServer("delegabo");
          m_cPhName = m_Ctx.GetPhName("delegabo");
          if (Cursor_delegabo!=null)
            Cursor_delegabo.Close();
          Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_delegabo.Eof())) {
            /* _avanza := 0 */
            _avanza = CPLib.Round(0,0);
            /* If Empty(delegabo->CODINTER) */
            if (CPLib.Empty(Cursor_delegabo.GetString("CODINTER"))) {
              /* _avanza := 1 */
              _avanza = CPLib.Round(1,0);
            } // End If
            /* If _avanza=0 */
            if (CPLib.eqr(_avanza,0)) {
              /* _delega := 'S' */
              _delega = "S";
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000092")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000092(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
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
              /* xProg := arfn_chkspers(delegabo->CODINTER,qbe_allrapopebo_tec_one->DATAREG) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_delegabo.GetString("CODINTER"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG"));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000096")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("D","?",0,0,m_cServer),m_cServer,"D")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetString("CODINTER"))+"";
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000098")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("D","?",0,0,m_cServer),m_cServer,"D")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetString("CODINTER"))+"";
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
            Cursor_delegabo.Next();
          }
          m_cConnectivityError = Cursor_delegabo.ErrorMessage();
          Cursor_delegabo.Close();
          // * --- End Select
          /* If qbe_allrapopebo_tec_one->DATAOPE >= CharToDate('20140101') */
          if (CPLib.ge(Cursor_qbe_allrapopebo_tec_one.GetDate("DATAOPE"),CPLib.CharToDate("20140101"))) {
            // * --- Select from fiduciabo
            m_cServer = m_Ctx.GetServer("fiduciabo");
            m_cPhName = m_Ctx.GetPhName("fiduciabo");
            if (Cursor_fiduciabo!=null)
              Cursor_fiduciabo.Close();
            Cursor_fiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("fiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_fiduciabo.Eof())) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If Empty(fiduciabo->CODSOG) */
              if (CPLib.Empty(Cursor_fiduciabo.GetString("CODSOG"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                /* _titola := 'S' */
                _titola = "S";
                /* xProg := '' */
                xProg = "";
                // * --- Insert into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000A1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000A1(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
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
                /* xProg := arfn_chkspers(fiduciabo->CODSOG,qbe_allrapopebo_tec_one->DATAREG) */
                xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_fiduciabo.GetString("CODSOG"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG"));
                /* If Empty(LRTrim(xProg)) */
                if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000A5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_fiduciabo.GetString("CODSOG"))+"";
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
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000A7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_fiduciabo.GetString("CODSOG"))+"";
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
              Cursor_fiduciabo.Next();
            }
            m_cConnectivityError = Cursor_fiduciabo.ErrorMessage();
            Cursor_fiduciabo.Close();
            // * --- End Select
          } // End If
        } else { // Else
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* If intestbo->DATAINI <= qbe_allrapopebo_tec_one->DATAOPE and (intestbo->DATAFINE >= qbe_allrapopebo_tec_one->DATAOPE or Empty(intestbo->DATAFINE)) */
            if (CPLib.le(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAOPE")) && (CPLib.ge(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAOPE")) || CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")))) {
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000AB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000AB(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
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
              /* xProg := arfn_chkspers(intestbo->CODINTER,qbe_allrapopebo_tec_one->DATAREG) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG"));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000AF")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000B1")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
            } // End If
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          // * --- End Select
          // * --- Select from delegabo
          m_cServer = m_Ctx.GetServer("delegabo");
          m_cPhName = m_Ctx.GetPhName("delegabo");
          if (Cursor_delegabo!=null)
            Cursor_delegabo.Close();
          Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_delegabo.Eof())) {
            /* _avanza := 0 */
            _avanza = CPLib.Round(0,0);
            /* If Empty(delegabo->CODINTER) */
            if (CPLib.Empty(Cursor_delegabo.GetString("CODINTER"))) {
              /* _avanza := 1 */
              _avanza = CPLib.Round(1,0);
            } // End If
            /* If _avanza=0 */
            if (CPLib.eqr(_avanza,0)) {
              /* _delega := 'S' */
              _delega = "S";
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000BA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000BA(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
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
              /* xProg := arfn_chkspers(delegabo->CODINTER,qbe_allrapopebo_tec_one->DATAREG) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_delegabo.GetString("CODINTER"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG"));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000BE")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("D","?",0,0,m_cServer),m_cServer,"D")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetString("CODINTER"))+"";
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000C0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("D","?",0,0,m_cServer),m_cServer,"D")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetString("CODINTER"))+"";
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
            Cursor_delegabo.Next();
          }
          m_cConnectivityError = Cursor_delegabo.ErrorMessage();
          Cursor_delegabo.Close();
          // * --- End Select
          /* If qbe_allrapopebo_tec_one->DATAOPE >= CharToDate('20140101') */
          if (CPLib.ge(Cursor_qbe_allrapopebo_tec_one.GetDate("DATAOPE"),CPLib.CharToDate("20140101"))) {
            // * --- Select from fiduciabo
            m_cServer = m_Ctx.GetServer("fiduciabo");
            m_cPhName = m_Ctx.GetPhName("fiduciabo");
            if (Cursor_fiduciabo!=null)
              Cursor_fiduciabo.Close();
            Cursor_fiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("fiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_fiduciabo.Eof())) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If Empty(fiduciabo->CODSOG) */
              if (CPLib.Empty(Cursor_fiduciabo.GetString("CODSOG"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                /* _titola := 'S' */
                _titola = "S";
                /* xProg := '' */
                xProg = "";
                // * --- Insert into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000C9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000C9(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
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
                /* xProg := arfn_chkspers(fiduciabo->CODSOG,qbe_allrapopebo_tec_one->DATAREG) */
                xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_fiduciabo.GetString("CODSOG"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG"));
                /* If Empty(LRTrim(xProg)) */
                if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000CD")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_fiduciabo.GetString("CODSOG"))+"";
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
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000CF")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"PROVANAS = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_fiduciabo.GetString("CODSOG"))+"";
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
              Cursor_fiduciabo.Next();
            }
            m_cConnectivityError = Cursor_fiduciabo.ErrorMessage();
            Cursor_fiduciabo.Close();
            // * --- End Select
          } // End If
        } // End If
        Cursor_qbe_allrapopebo_tec_one.Next();
      }
      m_cConnectivityError = Cursor_qbe_allrapopebo_tec_one.ErrorMessage();
      Cursor_qbe_allrapopebo_tec_one.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_allrapopebo_tec_one!=null)
          Cursor_qbe_allrapopebo_tec_one.Close();
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
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_fiduciabo!=null)
          Cursor_fiduciabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_5() throws Exception {
    CPResultSet Cursor_qbe_allrapopebo_tec_one=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_soginfo=null;
    CPResultSet Cursor_fiduciabo=null;
    CPResultSet Cursor_delegabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_allrapopebo_tec_one
      SPBridge.HMCaller _h000000D0;
      _h000000D0 = new SPBridge.HMCaller();
      _h000000D0.Set("m_cVQRList",m_cVQRList);
      _h000000D0.Set("idinfo",w_idinfo);
      if (Cursor_qbe_allrapopebo_tec_one!=null)
        Cursor_qbe_allrapopebo_tec_one.Close();
      Cursor_qbe_allrapopebo_tec_one = new VQRHolder("qbe_allrapopebo_tec_one",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000D0,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_allrapopebo_tec_one.Eof())) {
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* _avanza := 0 */
          _avanza = CPLib.Round(0,0);
          /* If Empty(intestbo->CODINTER) */
          if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
            /* _avanza := 1 */
            _avanza = CPLib.Round(1,0);
          } // End If
          /* If _avanza=0 */
          if (CPLib.eqr(_avanza,0)) {
            /* xProg := '' */
            xProg = "";
            // * --- Insert into tmp_soggettioper from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000D7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000D7(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
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
            /* xProg := arfn_chkspers(intestbo->CODINTER,iif(qbe_allrapopebo_tec_one->TIPOOPRAP='31',arfn_dateminus(qbe_allrapopebo_tec_one->DATAREG,1),qbe_allrapopebo_tec_one->DATAREG)) */
            xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),(CPLib.eqr(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOOPRAP"),"31")?arfn_dateminusR.Make(m_Ctx,this).Run(Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG"),1):Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG")));
            /* If Empty(LRTrim(xProg)) */
            if (CPLib.Empty(CPLib.LRTrim(xProg))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000DB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000DD")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
          } // End If
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        /* If not(Empty(qbe_allrapopebo_tec_one->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER")))) {
          /* _esecut := 'S' */
          _esecut = "S";
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000E2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000E2(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
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
          /* xProg := arfn_chkspers(qbe_allrapopebo_tec_one->CONNESOPER,iif(qbe_allrapopebo_tec_one->TIPOOPRAP='31',arfn_dateminus(qbe_allrapopebo_tec_one->DATAREG,1),qbe_allrapopebo_tec_one->DATAREG)) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"),(CPLib.eqr(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOOPRAP"),"31")?arfn_dateminusR.Make(m_Ctx,this).Run(Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG"),1):Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG")));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000E6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"))+"";
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
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000E8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"))+"";
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
        // * --- Select from soginfo
        m_cServer = m_Ctx.GetServer("soginfo");
        m_cPhName = m_Ctx.GetPhName("soginfo");
        if (Cursor_soginfo!=null)
          Cursor_soginfo.Close();
        Cursor_soginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("soginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_soginfo.Eof())) {
          /* _avanza := 0 */
          _avanza = CPLib.Round(0,0);
          /* If Empty(soginfo->CODSOG) */
          if (CPLib.Empty(Cursor_soginfo.GetString("CODSOG"))) {
            /* _avanza := 1 */
            _avanza = CPLib.Round(1,0);
          } // End If
          /* If _avanza=0 */
          if (CPLib.eqr(_avanza,0)) {
            /* _esecut := 'S' */
            _esecut = "S";
            /* xProg := '' */
            xProg = "";
            // * --- Insert into tmp_soggettioper from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000F0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000F0(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_soginfo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
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
            /* xProg := arfn_chkspers(soginfo->CODSOG,iif(qbe_allrapopebo_tec_one->TIPOOPRAP='31',arfn_dateminus(qbe_allrapopebo_tec_one->DATAREG,1),qbe_allrapopebo_tec_one->DATAREG)) */
            xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_soginfo.GetString("CODSOG"),(CPLib.eqr(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOOPRAP"),"31")?arfn_dateminusR.Make(m_Ctx,this).Run(Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG"),1):Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG")));
            /* If Empty(LRTrim(xProg)) */
            if (CPLib.Empty(CPLib.LRTrim(xProg))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_soginfo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000F4")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_soginfo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_soginfo.GetString("CODSOG"))+"";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000F6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_soginfo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_soginfo.GetString("CODSOG"))+"";
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
          Cursor_soginfo.Next();
        }
        m_cConnectivityError = Cursor_soginfo.ErrorMessage();
        Cursor_soginfo.Close();
        // * --- End Select
        /* If qbe_allrapopebo_tec_one->DATAOPE >= CharToDate('20140101') */
        if (CPLib.ge(Cursor_qbe_allrapopebo_tec_one.GetDate("DATAOPE"),CPLib.CharToDate("20140101"))) {
          // * --- Select from fiduciabo
          m_cServer = m_Ctx.GetServer("fiduciabo");
          m_cPhName = m_Ctx.GetPhName("fiduciabo");
          if (Cursor_fiduciabo!=null)
            Cursor_fiduciabo.Close();
          Cursor_fiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("fiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_fiduciabo.Eof())) {
            /* _avanza := 0 */
            _avanza = CPLib.Round(0,0);
            /* If Empty(fiduciabo->CODSOG) */
            if (CPLib.Empty(Cursor_fiduciabo.GetString("CODSOG"))) {
              /* _avanza := 1 */
              _avanza = CPLib.Round(1,0);
            } // End If
            /* If _avanza=0 */
            if (CPLib.eqr(_avanza,0)) {
              /* _titola := 'S' */
              _titola = "S";
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000000FF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000FF(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
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
              /* xProg := arfn_chkspers(fiduciabo->CODSOG,iif(qbe_allrapopebo_tec_one->TIPOOPRAP='31',arfn_dateminus(qbe_allrapopebo_tec_one->DATAREG,1),qbe_allrapopebo_tec_one->DATAREG)) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_fiduciabo.GetString("CODSOG"),(CPLib.eqr(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOOPRAP"),"31")?arfn_dateminusR.Make(m_Ctx,this).Run(Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG"),1):Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG")));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000103")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_fiduciabo.GetString("CODSOG"))+"";
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000105")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_fiduciabo.GetString("CODSOG"))+"";
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
            Cursor_fiduciabo.Next();
          }
          m_cConnectivityError = Cursor_fiduciabo.ErrorMessage();
          Cursor_fiduciabo.Close();
          // * --- End Select
        } // End If
        // * --- Select from delegabo
        m_cServer = m_Ctx.GetServer("delegabo");
        m_cPhName = m_Ctx.GetPhName("delegabo");
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
        Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_delegabo.Eof())) {
          /* _avanza := 0 */
          _avanza = CPLib.Round(0,0);
          /* If Empty(delegabo->CODINTER) */
          if (CPLib.Empty(Cursor_delegabo.GetString("CODINTER"))) {
            /* _avanza := 1 */
            _avanza = CPLib.Round(1,0);
          } // End If
          /* If _avanza=0 */
          if (CPLib.eqr(_avanza,0)) {
            /* If delegabo->DATAINI <= qbe_allrapopebo_tec_one->DATAOPE and (delegabo->DATAFINE >= qbe_allrapopebo_tec_one->DATAOPE or Empty(delegabo->DATAFINE)) */
            if (CPLib.le(Cursor_delegabo.GetDate("DATAINI"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAOPE")) && (CPLib.ge(Cursor_delegabo.GetDate("DATAFINE"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAOPE")) || CPLib.Empty(Cursor_delegabo.GetDate("DATAFINE")))) {
              /* _delega := 'S' */
              _delega = "S";
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000010E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000010E(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
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
              /* xProg := arfn_chkspers(delegabo->CODINTER,iif(qbe_allrapopebo_tec_one->TIPOOPRAP='31',arfn_dateminus(qbe_allrapopebo_tec_one->DATAREG,1),qbe_allrapopebo_tec_one->DATAREG)) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_delegabo.GetString("CODINTER"),(CPLib.eqr(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOOPRAP"),"31")?arfn_dateminusR.Make(m_Ctx,this).Run(Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG"),1):Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG")));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000112")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("D","?",0,0,m_cServer),m_cServer,"D")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetString("CODINTER"))+"";
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000114")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("D","?",0,0,m_cServer),m_cServer,"D")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_delegabo.GetString("CODINTER"))+"";
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
          } // End If
          Cursor_delegabo.Next();
        }
        m_cConnectivityError = Cursor_delegabo.ErrorMessage();
        Cursor_delegabo.Close();
        // * --- End Select
        Cursor_qbe_allrapopebo_tec_one.Next();
      }
      m_cConnectivityError = Cursor_qbe_allrapopebo_tec_one.ErrorMessage();
      Cursor_qbe_allrapopebo_tec_one.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_allrapopebo_tec_one!=null)
          Cursor_qbe_allrapopebo_tec_one.Close();
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
        if (Cursor_soginfo!=null)
          Cursor_soginfo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_fiduciabo!=null)
          Cursor_fiduciabo.Close();
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
  void Page_6() throws Exception {
    CPResultSet Cursor_qbe_allrapopebo_tec_one=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_soginfo=null;
    CPResultSet Cursor_fiduciabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_allrapopebo_tec_one
      SPBridge.HMCaller _h00000115;
      _h00000115 = new SPBridge.HMCaller();
      _h00000115.Set("m_cVQRList",m_cVQRList);
      _h00000115.Set("idinfo",w_idinfo);
      if (Cursor_qbe_allrapopebo_tec_one!=null)
        Cursor_qbe_allrapopebo_tec_one.Close();
      Cursor_qbe_allrapopebo_tec_one = new VQRHolder("qbe_allrapopebo_tec_one",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000115,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_allrapopebo_tec_one.Eof())) {
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* _avanza := 0 */
          _avanza = CPLib.Round(0,0);
          /* If Empty(intestbo->CODINTER) */
          if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
            /* _avanza := 1 */
            _avanza = CPLib.Round(1,0);
          } // End If
          /* If _avanza=0 */
          if (CPLib.eqr(_avanza,0)) {
            /* xProg := '' */
            xProg = "";
            // * --- Insert into tmp_soggettioper from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000011C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000011C(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
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
            /* xProg := arfn_chkspers(intestbo->CODINTER,qbe_allrapopebo_tec_one->DATAREG) */
            xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG"));
            /* If Empty(LRTrim(xProg)) */
            if (CPLib.Empty(CPLib.LRTrim(xProg))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000120")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000122")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
          } // End If
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        /* If not(Empty(qbe_allrapopebo_tec_one->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER")))) {
          /* _esecut := 'S' */
          _esecut = "S";
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000127")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000127(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
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
          /* xProg := arfn_chkspers(qbe_allrapopebo_tec_one->CONNESOPER,qbe_allrapopebo_tec_one->DATAREG) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG"));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000012B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"))+"";
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
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000012D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"))+"";
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
        // * --- Select from soginfo
        m_cServer = m_Ctx.GetServer("soginfo");
        m_cPhName = m_Ctx.GetPhName("soginfo");
        if (Cursor_soginfo!=null)
          Cursor_soginfo.Close();
        Cursor_soginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("soginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_soginfo.Eof())) {
          /* _avanza := 0 */
          _avanza = CPLib.Round(0,0);
          /* If Empty(soginfo->CODSOG) */
          if (CPLib.Empty(Cursor_soginfo.GetString("CODSOG"))) {
            /* _avanza := 1 */
            _avanza = CPLib.Round(1,0);
          } // End If
          /* If _avanza=0 */
          if (CPLib.eqr(_avanza,0)) {
            /* _esecut := 'S' */
            _esecut = "S";
            /* xProg := '' */
            xProg = "";
            // * --- Insert into tmp_soggettioper from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000135")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000135(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_soginfo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
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
            /* xProg := arfn_chkspers(soginfo->CODSOG,qbe_allrapopebo_tec_one->DATAREG) */
            xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_soginfo.GetString("CODSOG"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG"));
            /* If Empty(LRTrim(xProg)) */
            if (CPLib.Empty(CPLib.LRTrim(xProg))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_soginfo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000139")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_soginfo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_soginfo.GetString("CODSOG"))+"";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000013B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_soginfo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_soginfo.GetString("CODSOG"))+"";
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
          Cursor_soginfo.Next();
        }
        m_cConnectivityError = Cursor_soginfo.ErrorMessage();
        Cursor_soginfo.Close();
        // * --- End Select
        // * --- Select from fiduciabo
        m_cServer = m_Ctx.GetServer("fiduciabo");
        m_cPhName = m_Ctx.GetPhName("fiduciabo");
        if (Cursor_fiduciabo!=null)
          Cursor_fiduciabo.Close();
        Cursor_fiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("fiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_fiduciabo.Eof())) {
          /* _avanza := 0 */
          _avanza = CPLib.Round(0,0);
          /* If Empty(fiduciabo->CODSOG) */
          if (CPLib.Empty(Cursor_fiduciabo.GetString("CODSOG"))) {
            /* _avanza := 1 */
            _avanza = CPLib.Round(1,0);
          } // End If
          /* If _avanza=0 */
          if (CPLib.eqr(_avanza,0)) {
            /* _titola := 'S' */
            _titola = "S";
            /* xProg := '' */
            xProg = "";
            // * --- Insert into tmp_soggettioper from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000143")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000143(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
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
            /* xProg := arfn_chkspers(fiduciabo->CODSOG,qbe_allrapopebo_tec_one->DATAREG) */
            xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_fiduciabo.GetString("CODSOG"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG"));
            /* If Empty(LRTrim(xProg)) */
            if (CPLib.Empty(CPLib.LRTrim(xProg))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000147")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_fiduciabo.GetString("CODSOG"))+"";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000149")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_fiduciabo.GetString("CODSOG"))+"";
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
          Cursor_fiduciabo.Next();
        }
        m_cConnectivityError = Cursor_fiduciabo.ErrorMessage();
        Cursor_fiduciabo.Close();
        // * --- End Select
        Cursor_qbe_allrapopebo_tec_one.Next();
      }
      m_cConnectivityError = Cursor_qbe_allrapopebo_tec_one.ErrorMessage();
      Cursor_qbe_allrapopebo_tec_one.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_allrapopebo_tec_one!=null)
          Cursor_qbe_allrapopebo_tec_one.Close();
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
        if (Cursor_soginfo!=null)
          Cursor_soginfo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_fiduciabo!=null)
          Cursor_fiduciabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_7() throws Exception {
    CPResultSet Cursor_qbe_allrapopebo_tec_one=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_soginfo=null;
    CPResultSet Cursor_fiduciabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_allrapopebo_tec_one
      SPBridge.HMCaller _h0000014A;
      _h0000014A = new SPBridge.HMCaller();
      _h0000014A.Set("m_cVQRList",m_cVQRList);
      _h0000014A.Set("idinfo",w_idinfo);
      if (Cursor_qbe_allrapopebo_tec_one!=null)
        Cursor_qbe_allrapopebo_tec_one.Close();
      Cursor_qbe_allrapopebo_tec_one = new VQRHolder("qbe_allrapopebo_tec_one",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000014A,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_allrapopebo_tec_one.Eof())) {
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* _avanza := 0 */
          _avanza = CPLib.Round(0,0);
          /* If Empty(intestbo->CODINTER) */
          if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
            /* _avanza := 1 */
            _avanza = CPLib.Round(1,0);
          } // End If
          /* If _avanza=0 */
          if (CPLib.eqr(_avanza,0)) {
            /* xProg := '' */
            xProg = "";
            // * --- Insert into tmp_soggettioper from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000151")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000151(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
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
            /* xProg := arfn_chkspers(intestbo->CODINTER,qbe_allrapopebo_tec_one->DATAREG) */
            xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG"));
            /* If Empty(LRTrim(xProg)) */
            if (CPLib.Empty(CPLib.LRTrim(xProg))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000155")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000157")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
          } // End If
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        /* If not(Empty(qbe_allrapopebo_tec_one->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER")))) {
          /* _esecut := 'S' */
          _esecut = "S";
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000015C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000015C(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
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
          /* xProg := arfn_chkspers(qbe_allrapopebo_tec_one->CONNESOPER,qbe_allrapopebo_tec_one->DATAREG) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG"));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000160")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"))+"";
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
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000162")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("CONNESOPER"))+"";
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
        // * --- Select from soginfo
        m_cServer = m_Ctx.GetServer("soginfo");
        m_cPhName = m_Ctx.GetPhName("soginfo");
        if (Cursor_soginfo!=null)
          Cursor_soginfo.Close();
        Cursor_soginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("soginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_soginfo.Eof())) {
          /* _avanza := 0 */
          _avanza = CPLib.Round(0,0);
          /* If Empty(soginfo->CODSOG) */
          if (CPLib.Empty(Cursor_soginfo.GetString("CODSOG"))) {
            /* _avanza := 1 */
            _avanza = CPLib.Round(1,0);
          } // End If
          /* If _avanza=0 */
          if (CPLib.eqr(_avanza,0)) {
            /* _esecut := 'S' */
            _esecut = "S";
            /* xProg := '' */
            xProg = "";
            // * --- Insert into tmp_soggettioper from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000016A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000016A(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_soginfo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
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
            /* xProg := arfn_chkspers(soginfo->CODSOG,qbe_allrapopebo_tec_one->DATAREG) */
            xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_soginfo.GetString("CODSOG"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG"));
            /* If Empty(LRTrim(xProg)) */
            if (CPLib.Empty(CPLib.LRTrim(xProg))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_soginfo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000016E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_soginfo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_soginfo.GetString("CODSOG"))+"";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000170")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_soginfo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_soginfo.GetString("CODSOG"))+"";
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
          Cursor_soginfo.Next();
        }
        m_cConnectivityError = Cursor_soginfo.ErrorMessage();
        Cursor_soginfo.Close();
        // * --- End Select
        // * --- Select from fiduciabo
        m_cServer = m_Ctx.GetServer("fiduciabo");
        m_cPhName = m_Ctx.GetPhName("fiduciabo");
        if (Cursor_fiduciabo!=null)
          Cursor_fiduciabo.Close();
        Cursor_fiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("fiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_fiduciabo.Eof())) {
          /* _avanza := 0 */
          _avanza = CPLib.Round(0,0);
          /* If Empty(fiduciabo->CODSOG) */
          if (CPLib.Empty(Cursor_fiduciabo.GetString("CODSOG"))) {
            /* _avanza := 1 */
            _avanza = CPLib.Round(1,0);
          } // End If
          /* If _avanza=0 */
          if (CPLib.eqr(_avanza,0)) {
            /* _titola := 'S' */
            _titola = "S";
            /* xProg := '' */
            xProg = "";
            // * --- Insert into tmp_soggettioper from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000178")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000178(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
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
            /* xProg := arfn_chkspers(fiduciabo->CODSOG,qbe_allrapopebo_tec_one->DATAREG) */
            xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_fiduciabo.GetString("CODSOG"),Cursor_qbe_allrapopebo_tec_one.GetDate("DATAREG"));
            /* If Empty(LRTrim(xProg)) */
            if (CPLib.Empty(CPLib.LRTrim(xProg))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000017C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_fiduciabo.GetString("CODSOG"))+"";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000017E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allrapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_fiduciabo.GetString("CODSOG"))+"";
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
          Cursor_fiduciabo.Next();
        }
        m_cConnectivityError = Cursor_fiduciabo.ErrorMessage();
        Cursor_fiduciabo.Close();
        // * --- End Select
        Cursor_qbe_allrapopebo_tec_one.Next();
      }
      m_cConnectivityError = Cursor_qbe_allrapopebo_tec_one.ErrorMessage();
      Cursor_qbe_allrapopebo_tec_one.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_allrapopebo_tec_one!=null)
          Cursor_qbe_allrapopebo_tec_one.Close();
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
        if (Cursor_soginfo!=null)
          Cursor_soginfo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_fiduciabo!=null)
          Cursor_fiduciabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_8() throws Exception {
    CPResultSet Cursor_qbe_allxapopebo_tec_one=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_xelegabo=null;
    CPResultSet Cursor_xiduciabo=null;
    CPResultSet Cursor_fiduciabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_allxapopebo_tec_one
      SPBridge.HMCaller _h0000017F;
      _h0000017F = new SPBridge.HMCaller();
      _h0000017F.Set("m_cVQRList",m_cVQRList);
      _h0000017F.Set("idinfo",w_idinfo);
      if (Cursor_qbe_allxapopebo_tec_one!=null)
        Cursor_qbe_allxapopebo_tec_one.Close();
      Cursor_qbe_allxapopebo_tec_one = new VQRHolder("qbe_allxapopebo_tec_one",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000017F,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_allxapopebo_tec_one.Eof())) {
        /* If qbe_allxapopebo_tec_one->TIPOOPRAP='25' or qbe_allxapopebo_tec_one->TIPOOPRAP='39' or qbe_allxapopebo_tec_one->TIPOOPRAP='40' */
        if (CPLib.eqr(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOOPRAP"),"25") || CPLib.eqr(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOOPRAP"),"39") || CPLib.eqr(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOOPRAP"),"40")) {
          /* _trovati := 0 // Ha trovasto intestatari o fiducianti */
          _trovati = CPLib.Round(0,0);
          // * --- Select from xntestbo
          m_cServer = m_Ctx.GetServer("xntestbo");
          m_cPhName = m_Ctx.GetPhName("xntestbo");
          if (Cursor_xntestbo!=null)
            Cursor_xntestbo.Close();
          Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xntestbo.Eof())) {
            /* If xntestbo->DATAINI <= qbe_allxapopebo_tec_one->DATAOPE and (xntestbo->DATAFINE >= qbe_allxapopebo_tec_one->DATAOPE or Empty(xntestbo->DATAFINE)) */
            if (CPLib.le(Cursor_xntestbo.GetDate("DATAINI"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAOPE")) && (CPLib.ge(Cursor_xntestbo.GetDate("DATAFINE"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAOPE")) || CPLib.Empty(Cursor_xntestbo.GetDate("DATAFINE")))) {
              /* _trovati := 1 // Ha trovasto intestatari o fiducianti */
              _trovati = CPLib.Round(1,0);
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000186")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000186(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
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
              /* xProg := arfn_chkspers(xntestbo->CODINTER,qbe_allxapopebo_tec_one->DATAREG) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAREG"));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000018A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"))+"";
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000018C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"))+"";
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
            } // End If
            Cursor_xntestbo.Next();
          }
          m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
          Cursor_xntestbo.Close();
          // * --- End Select
          /* If _trovati=0 */
          if (CPLib.eqr(_trovati,0)) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If intestbo->DATAINI <= qbe_allxapopebo_tec_one->DATAOPE and (intestbo->DATAFINE >= qbe_allxapopebo_tec_one->DATAOPE or Empty(intestbo->DATAFINE)) */
              if (CPLib.le(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAOPE")) && (CPLib.ge(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAOPE")) || CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")))) {
                /* xProg := '' */
                xProg = "";
                // * --- Insert into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000192")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000192(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
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
                /* xProg := arfn_chkspers(intestbo->CODINTER,qbe_allxapopebo_tec_one->DATAREG) */
                xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAREG"));
                /* If Empty(LRTrim(xProg)) */
                if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000196")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000198")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
              } // End If
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
          } // End If
          // * --- Select from xelegabo
          m_cServer = m_Ctx.GetServer("xelegabo");
          m_cPhName = m_Ctx.GetPhName("xelegabo");
          if (Cursor_xelegabo!=null)
            Cursor_xelegabo.Close();
          Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xelegabo.Eof())) {
            /* _avanza := 0 */
            _avanza = CPLib.Round(0,0);
            /* If Empty(xelegabo->CODINTER) */
            if (CPLib.Empty(Cursor_xelegabo.GetString("CODINTER"))) {
              /* _avanza := 1 */
              _avanza = CPLib.Round(1,0);
            } // End If
            /* If _avanza=0 */
            if (CPLib.eqr(_avanza,0)) {
              /* _delega := 'S' */
              _delega = "S";
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001A1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001A1(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
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
              /* xProg := arfn_chkspers(xelegabo->CODINTER,qbe_allxapopebo_tec_one->DATAREG) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xelegabo.GetString("CODINTER"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAREG"));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001A5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("D","?",0,0,m_cServer),m_cServer,"D")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xelegabo.GetString("CODINTER"))+"";
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001A7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("D","?",0,0,m_cServer),m_cServer,"D")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xelegabo.GetString("CODINTER"))+"";
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
            Cursor_xelegabo.Next();
          }
          m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
          Cursor_xelegabo.Close();
          // * --- End Select
          /* If qbe_allxapopebo_tec_one->DATAOPE >= CharToDate('20140101') */
          if (CPLib.ge(Cursor_qbe_allxapopebo_tec_one.GetDate("DATAOPE"),CPLib.CharToDate("20140101"))) {
            /* _trovati := 0 // Ha trovasto intestatari o fiducianti */
            _trovati = CPLib.Round(0,0);
            // * --- Select from xiduciabo
            m_cServer = m_Ctx.GetServer("xiduciabo");
            m_cPhName = m_Ctx.GetPhName("xiduciabo");
            if (Cursor_xiduciabo!=null)
              Cursor_xiduciabo.Close();
            Cursor_xiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xiduciabo.Eof())) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If Empty(xiduciabo->CODSOG) */
              if (CPLib.Empty(Cursor_xiduciabo.GetString("CODSOG"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                /* _trovati := 1 // Ha trovasto intestatari o fiducianti */
                _trovati = CPLib.Round(1,0);
                /* _titola := 'S' */
                _titola = "S";
                /* xProg := '' */
                xProg = "";
                // * --- Insert into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001B2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000001B2(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
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
                /* xProg := arfn_chkspers(xiduciabo->CODSOG,qbe_allxapopebo_tec_one->DATAREG) */
                xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xiduciabo.GetString("CODSOG"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAREG"));
                /* If Empty(LRTrim(xProg)) */
                if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001B6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xiduciabo.GetString("CODSOG"))+"";
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
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001B8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xiduciabo.GetString("CODSOG"))+"";
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
              Cursor_xiduciabo.Next();
            }
            m_cConnectivityError = Cursor_xiduciabo.ErrorMessage();
            Cursor_xiduciabo.Close();
            // * --- End Select
            /* If _trovati=0 */
            if (CPLib.eqr(_trovati,0)) {
              // * --- Select from fiduciabo
              m_cServer = m_Ctx.GetServer("fiduciabo");
              m_cPhName = m_Ctx.GetPhName("fiduciabo");
              if (Cursor_fiduciabo!=null)
                Cursor_fiduciabo.Close();
              Cursor_fiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("fiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_fiduciabo.Eof())) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(fiduciabo->CODSOG) */
                if (CPLib.Empty(Cursor_fiduciabo.GetString("CODSOG"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza=0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* _titola := 'S' */
                  _titola = "S";
                  /* xProg := '' */
                  xProg = "";
                  // * --- Insert into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001C1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000001C1(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
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
                  /* xProg := arfn_chkspers(fiduciabo->CODSOG,qbe_allxapopebo_tec_one->DATAREG) */
                  xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_fiduciabo.GetString("CODSOG"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAREG"));
                  /* If Empty(LRTrim(xProg)) */
                  if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                    // * --- Select from personbo
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    if (Cursor_personbo!=null)
                      Cursor_personbo.Close();
                    Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_personbo.Eof())) {
                      // * --- Write into tmp_soggettioper from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                      m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001C5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                      m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                      m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                      m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                      m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_fiduciabo.GetString("CODSOG"))+"";
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
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001C7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                      m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                      m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                      m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                      m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_fiduciabo.GetString("CODSOG"))+"";
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
                Cursor_fiduciabo.Next();
              }
              m_cConnectivityError = Cursor_fiduciabo.ErrorMessage();
              Cursor_fiduciabo.Close();
              // * --- End Select
            } // End If
          } // End If
        } else { // Else
          /* _trovati := 0 */
          _trovati = CPLib.Round(0,0);
          // * --- Select from xntestbo
          m_cServer = m_Ctx.GetServer("xntestbo");
          m_cPhName = m_Ctx.GetPhName("xntestbo");
          if (Cursor_xntestbo!=null)
            Cursor_xntestbo.Close();
          Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xntestbo.Eof())) {
            /* If xntestbo->DATAINI <= qbe_allxapopebo_tec_one->DATAOPE and (xntestbo->DATAFINE >= qbe_allxapopebo_tec_one->DATAOPE or Empty(xntestbo->DATAFINE)) */
            if (CPLib.le(Cursor_xntestbo.GetDate("DATAINI"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAOPE")) && (CPLib.ge(Cursor_xntestbo.GetDate("DATAFINE"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAOPE")) || CPLib.Empty(Cursor_xntestbo.GetDate("DATAFINE")))) {
              /* _trovati := 1 */
              _trovati = CPLib.Round(1,0);
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001CD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001CD(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
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
              /* xProg := arfn_chkspers(xntestbo->CODINTER,qbe_allxapopebo_tec_one->DATAREG) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAREG"));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001D1")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"))+"";
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001D3")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"))+"";
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
            } // End If
            Cursor_xntestbo.Next();
          }
          m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
          Cursor_xntestbo.Close();
          // * --- End Select
          /* If _trovati=0 */
          if (CPLib.eqr(_trovati,0)) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If intestbo->DATAINI <= qbe_allxapopebo_tec_one->DATAOPE and (intestbo->DATAFINE >= qbe_allxapopebo_tec_one->DATAOPE or Empty(intestbo->DATAFINE)) */
              if (CPLib.le(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAOPE")) && (CPLib.ge(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAOPE")) || CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")))) {
                /* xProg := '' */
                xProg = "";
                // * --- Insert into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001D9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000001D9(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
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
                /* xProg := arfn_chkspers(intestbo->CODINTER,qbe_allxapopebo_tec_one->DATAREG) */
                xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAREG"));
                /* If Empty(LRTrim(xProg)) */
                if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001DD")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001DF")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"))+"";
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
              } // End If
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
          } // End If
          // * --- Select from xelegabo
          m_cServer = m_Ctx.GetServer("xelegabo");
          m_cPhName = m_Ctx.GetPhName("xelegabo");
          if (Cursor_xelegabo!=null)
            Cursor_xelegabo.Close();
          Cursor_xelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xelegabo.Eof())) {
            /* _avanza := 0 */
            _avanza = CPLib.Round(0,0);
            /* If Empty(xelegabo->CODINTER) */
            if (CPLib.Empty(Cursor_xelegabo.GetString("CODINTER"))) {
              /* _avanza := 1 */
              _avanza = CPLib.Round(1,0);
            } // End If
            /* If _avanza=0 */
            if (CPLib.eqr(_avanza,0)) {
              /* _delega := 'S' */
              _delega = "S";
              /* xProg := '' */
              xProg = "";
              // * --- Insert into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001E8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001E8(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
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
              /* xProg := arfn_chkspers(xelegabo->CODINTER,qbe_allxapopebo_tec_one->DATAREG) */
              xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xelegabo.GetString("CODINTER"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAREG"));
              /* If Empty(LRTrim(xProg)) */
              if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  // * --- Write into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001EC")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("D","?",0,0,m_cServer),m_cServer,"D")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xelegabo.GetString("CODINTER"))+"";
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
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001EE")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                  m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                  m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("D","?",0,0,m_cServer),m_cServer,"D")+"";
                  m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xelegabo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xelegabo.GetString("CODINTER"))+"";
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
            Cursor_xelegabo.Next();
          }
          m_cConnectivityError = Cursor_xelegabo.ErrorMessage();
          Cursor_xelegabo.Close();
          // * --- End Select
          /* If qbe_allxapopebo_tec_one->DATAOPE >= CharToDate('20140101') */
          if (CPLib.ge(Cursor_qbe_allxapopebo_tec_one.GetDate("DATAOPE"),CPLib.CharToDate("20140101"))) {
            /* _trovati := 0 // Ha trovasto intestatari o fiducianti */
            _trovati = CPLib.Round(0,0);
            // * --- Select from xiduciabo
            m_cServer = m_Ctx.GetServer("xiduciabo");
            m_cPhName = m_Ctx.GetPhName("xiduciabo");
            if (Cursor_xiduciabo!=null)
              Cursor_xiduciabo.Close();
            Cursor_xiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_xiduciabo.Eof())) {
              /* _avanza := 0 */
              _avanza = CPLib.Round(0,0);
              /* If Empty(xiduciabo->CODSOG) */
              if (CPLib.Empty(Cursor_xiduciabo.GetString("CODSOG"))) {
                /* _avanza := 1 */
                _avanza = CPLib.Round(1,0);
              } // End If
              /* If _avanza=0 */
              if (CPLib.eqr(_avanza,0)) {
                /* _trovati := 1 // Ha trovasto intestatari o fiducianti */
                _trovati = CPLib.Round(1,0);
                /* _titola := 'S' */
                _titola = "S";
                /* xProg := '' */
                xProg = "";
                // * --- Insert into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001F9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000001F9(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
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
                /* xProg := arfn_chkspers(xiduciabo->CODSOG,qbe_allxapopebo_tec_one->DATAREG) */
                xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xiduciabo.GetString("CODSOG"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAREG"));
                /* If Empty(LRTrim(xProg)) */
                if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_soggettioper from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                    m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001FD")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xiduciabo.GetString("CODSOG"))+"";
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
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"000001FF")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                    m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                    m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                    m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                    m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xiduciabo.GetString("CODSOG"))+"";
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
              Cursor_xiduciabo.Next();
            }
            m_cConnectivityError = Cursor_xiduciabo.ErrorMessage();
            Cursor_xiduciabo.Close();
            // * --- End Select
            /* If _trovati=0 */
            if (CPLib.eqr(_trovati,0)) {
              // * --- Select from fiduciabo
              m_cServer = m_Ctx.GetServer("fiduciabo");
              m_cPhName = m_Ctx.GetPhName("fiduciabo");
              if (Cursor_fiduciabo!=null)
                Cursor_fiduciabo.Close();
              Cursor_fiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("fiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_fiduciabo.Eof())) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(fiduciabo->CODSOG) */
                if (CPLib.Empty(Cursor_fiduciabo.GetString("CODSOG"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza=0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* _titola := 'S' */
                  _titola = "S";
                  /* xProg := '' */
                  xProg = "";
                  // * --- Insert into tmp_soggettioper from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                  m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000208")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000208(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
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
                  /* xProg := arfn_chkspers(fiduciabo->CODSOG,qbe_allxapopebo_tec_one->DATAREG) */
                  xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_fiduciabo.GetString("CODSOG"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAREG"));
                  /* If Empty(LRTrim(xProg)) */
                  if (CPLib.Empty(CPLib.LRTrim(xProg))) {
                    // * --- Select from personbo
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    if (Cursor_personbo!=null)
                      Cursor_personbo.Close();
                    Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_personbo.Eof())) {
                      // * --- Write into tmp_soggettioper from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                      m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000020C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                      m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                      m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                      m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                      m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_fiduciabo.GetString("CODSOG"))+"";
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
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000020E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                      m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                      m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                      m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                      m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_fiduciabo.GetString("CODSOG"))+"";
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
                Cursor_fiduciabo.Next();
              }
              m_cConnectivityError = Cursor_fiduciabo.ErrorMessage();
              Cursor_fiduciabo.Close();
              // * --- End Select
            } // End If
          } // End If
        } // End If
        Cursor_qbe_allxapopebo_tec_one.Next();
      }
      m_cConnectivityError = Cursor_qbe_allxapopebo_tec_one.ErrorMessage();
      Cursor_qbe_allxapopebo_tec_one.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_allxapopebo_tec_one!=null)
          Cursor_qbe_allxapopebo_tec_one.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
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
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xelegabo!=null)
          Cursor_xelegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xiduciabo!=null)
          Cursor_xiduciabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_fiduciabo!=null)
          Cursor_fiduciabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_9() throws Exception {
    CPResultSet Cursor_qbe_allxapopebo_tec_one=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_xoginfo=null;
    CPResultSet Cursor_xiduciabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_allxapopebo_tec_one
      SPBridge.HMCaller _h0000020F;
      _h0000020F = new SPBridge.HMCaller();
      _h0000020F.Set("m_cVQRList",m_cVQRList);
      _h0000020F.Set("idinfo",w_idinfo);
      if (Cursor_qbe_allxapopebo_tec_one!=null)
        Cursor_qbe_allxapopebo_tec_one.Close();
      Cursor_qbe_allxapopebo_tec_one = new VQRHolder("qbe_allxapopebo_tec_one",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000020F,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_allxapopebo_tec_one.Eof())) {
        // * --- Select from xntestbo
        m_cServer = m_Ctx.GetServer("xntestbo");
        m_cPhName = m_Ctx.GetPhName("xntestbo");
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
        Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xntestbo.Eof())) {
          /* _avanza := 0 */
          _avanza = CPLib.Round(0,0);
          /* If Empty(xntestbo->CODINTER) */
          if (CPLib.Empty(Cursor_xntestbo.GetString("CODINTER"))) {
            /* _avanza := 1 */
            _avanza = CPLib.Round(1,0);
          } // End If
          /* If _avanza=0 */
          if (CPLib.eqr(_avanza,0)) {
            /* xProg := '' */
            xProg = "";
            // * --- Insert into tmp_soggettioper from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000216")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000216(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
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
            /* xProg := arfn_chkspers(xntestbo->CODINTER,qbe_allxapopebo_tec_one->DATAREG) */
            xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAREG"));
            /* If Empty(LRTrim(xProg)) */
            if (CPLib.Empty(CPLib.LRTrim(xProg))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000021A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"))+"";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000021C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"))+"";
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
          } // End If
          Cursor_xntestbo.Next();
        }
        m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
        Cursor_xntestbo.Close();
        // * --- End Select
        /* If not(Empty(qbe_allxapopebo_tec_one->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_qbe_allxapopebo_tec_one.GetString("CONNESOPER")))) {
          /* _esecut := 'S' */
          _esecut = "S";
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000221")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000221(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
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
          /* xProg := arfn_chkspers(qbe_allxapopebo_tec_one->CONNESOPER,qbe_allxapopebo_tec_one->DATAREG) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allxapopebo_tec_one.GetString("CONNESOPER"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAREG"));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000225")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("CONNESOPER"))+"";
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
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000227")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("CONNESOPER"))+"";
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
        // * --- Select from xoginfo
        m_cServer = m_Ctx.GetServer("xoginfo");
        m_cPhName = m_Ctx.GetPhName("xoginfo");
        if (Cursor_xoginfo!=null)
          Cursor_xoginfo.Close();
        Cursor_xoginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xoginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xoginfo.Eof())) {
          /* _avanza := 0 */
          _avanza = CPLib.Round(0,0);
          /* If Empty(xoginfo->CODSOG) */
          if (CPLib.Empty(Cursor_xoginfo.GetString("CODSOG"))) {
            /* _avanza := 1 */
            _avanza = CPLib.Round(1,0);
          } // End If
          /* If _avanza=0 */
          if (CPLib.eqr(_avanza,0)) {
            /* _esecut := 'S' */
            _esecut = "S";
            /* xProg := '' */
            xProg = "";
            // * --- Insert into tmp_soggettioper from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000022F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000022F(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xoginfo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
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
            /* xProg := arfn_chkspers(xoginfo->CODSOG,qbe_allxapopebo_tec_one->DATAREG) */
            xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xoginfo.GetString("CODSOG"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAREG"));
            /* If Empty(LRTrim(xProg)) */
            if (CPLib.Empty(CPLib.LRTrim(xProg))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xoginfo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000233")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xoginfo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xoginfo.GetString("CODSOG"))+"";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000235")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xoginfo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xoginfo.GetString("CODSOG"))+"";
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
          Cursor_xoginfo.Next();
        }
        m_cConnectivityError = Cursor_xoginfo.ErrorMessage();
        Cursor_xoginfo.Close();
        // * --- End Select
        // * --- Select from xiduciabo
        m_cServer = m_Ctx.GetServer("xiduciabo");
        m_cPhName = m_Ctx.GetPhName("xiduciabo");
        if (Cursor_xiduciabo!=null)
          Cursor_xiduciabo.Close();
        Cursor_xiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xiduciabo.Eof())) {
          /* _avanza := 0 */
          _avanza = CPLib.Round(0,0);
          /* If Empty(xiduciabo->CODSOG) */
          if (CPLib.Empty(Cursor_xiduciabo.GetString("CODSOG"))) {
            /* _avanza := 1 */
            _avanza = CPLib.Round(1,0);
          } // End If
          /* If _avanza=0 */
          if (CPLib.eqr(_avanza,0)) {
            /* _titola := 'S' */
            _titola = "S";
            /* xProg := '' */
            xProg = "";
            // * --- Insert into tmp_soggettioper from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000023D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000023D(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
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
            /* xProg := arfn_chkspers(xiduciabo->CODSOG,qbe_allxapopebo_tec_one->DATAREG) */
            xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xiduciabo.GetString("CODSOG"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAREG"));
            /* If Empty(LRTrim(xProg)) */
            if (CPLib.Empty(CPLib.LRTrim(xProg))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000241")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xiduciabo.GetString("CODSOG"))+"";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000243")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xiduciabo.GetString("CODSOG"))+"";
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
          Cursor_xiduciabo.Next();
        }
        m_cConnectivityError = Cursor_xiduciabo.ErrorMessage();
        Cursor_xiduciabo.Close();
        // * --- End Select
        Cursor_qbe_allxapopebo_tec_one.Next();
      }
      m_cConnectivityError = Cursor_qbe_allxapopebo_tec_one.ErrorMessage();
      Cursor_qbe_allxapopebo_tec_one.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_allxapopebo_tec_one!=null)
          Cursor_qbe_allxapopebo_tec_one.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
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
        if (Cursor_xoginfo!=null)
          Cursor_xoginfo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xiduciabo!=null)
          Cursor_xiduciabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_10() throws Exception {
    CPResultSet Cursor_qbe_allxapopebo_tec_one=null;
    CPResultSet Cursor_xntestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_xoginfo=null;
    CPResultSet Cursor_xiduciabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      // * --- Select from qbe_allxapopebo_tec_one
      SPBridge.HMCaller _h00000244;
      _h00000244 = new SPBridge.HMCaller();
      _h00000244.Set("m_cVQRList",m_cVQRList);
      _h00000244.Set("idinfo",w_idinfo);
      if (Cursor_qbe_allxapopebo_tec_one!=null)
        Cursor_qbe_allxapopebo_tec_one.Close();
      Cursor_qbe_allxapopebo_tec_one = new VQRHolder("qbe_allxapopebo_tec_one",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000244,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_allxapopebo_tec_one.Eof())) {
        // * --- Select from xntestbo
        m_cServer = m_Ctx.GetServer("xntestbo");
        m_cPhName = m_Ctx.GetPhName("xntestbo");
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
        Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xntestbo.Eof())) {
          /* _avanza := 0 */
          _avanza = CPLib.Round(0,0);
          /* If Empty(xntestbo->CODINTER) */
          if (CPLib.Empty(Cursor_xntestbo.GetString("CODINTER"))) {
            /* _avanza := 1 */
            _avanza = CPLib.Round(1,0);
          } // End If
          /* If _avanza=0 */
          if (CPLib.eqr(_avanza,0)) {
            /* xProg := '' */
            xProg = "";
            // * --- Insert into tmp_soggettioper from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000024B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000024B(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("7","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
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
            /* xProg := arfn_chkspers(xntestbo->CODINTER,qbe_allxapopebo_tec_one->DATAREG) */
            xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xntestbo.GetString("CODINTER"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAREG"));
            /* If Empty(LRTrim(xProg)) */
            if (CPLib.Empty(CPLib.LRTrim(xProg))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000024F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"))+"";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000251")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("I","?",0,0,m_cServer),m_cServer,"I")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"))+"";
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
          } // End If
          Cursor_xntestbo.Next();
        }
        m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
        Cursor_xntestbo.Close();
        // * --- End Select
        /* If not(Empty(qbe_allxapopebo_tec_one->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_qbe_allxapopebo_tec_one.GetString("CONNESOPER")))) {
          /* _esecut := 'S' */
          _esecut = "S";
          /* xProg := '' */
          xProg = "";
          // * --- Insert into tmp_soggettioper from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_soggettioper");
          m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000256")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000256(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
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
          /* xProg := arfn_chkspers(qbe_allxapopebo_tec_one->CONNESOPER,qbe_allxapopebo_tec_one->DATAREG) */
          xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_allxapopebo_tec_one.GetString("CONNESOPER"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAREG"));
          /* If Empty(LRTrim(xProg)) */
          if (CPLib.Empty(CPLib.LRTrim(xProg))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into tmp_soggettioper from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_soggettioper");
              m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000025A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("CONNESOPER"))+"";
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
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000025C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
              m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
              m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
              m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("CONNESOPER"))+"";
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
        // * --- Select from xoginfo
        m_cServer = m_Ctx.GetServer("xoginfo");
        m_cPhName = m_Ctx.GetPhName("xoginfo");
        if (Cursor_xoginfo!=null)
          Cursor_xoginfo.Close();
        Cursor_xoginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xoginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xoginfo.Eof())) {
          /* _avanza := 0 */
          _avanza = CPLib.Round(0,0);
          /* If Empty(xoginfo->CODSOG) */
          if (CPLib.Empty(Cursor_xoginfo.GetString("CODSOG"))) {
            /* _avanza := 1 */
            _avanza = CPLib.Round(1,0);
          } // End If
          /* If _avanza=0 */
          if (CPLib.eqr(_avanza,0)) {
            /* _esecut := 'S' */
            _esecut = "S";
            /* xProg := '' */
            xProg = "";
            // * --- Insert into tmp_soggettioper from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000264")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000264(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("8","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xoginfo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
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
            /* xProg := arfn_chkspers(xoginfo->CODSOG,qbe_allxapopebo_tec_one->DATAREG) */
            xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xoginfo.GetString("CODSOG"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAREG"));
            /* If Empty(LRTrim(xProg)) */
            if (CPLib.Empty(CPLib.LRTrim(xProg))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xoginfo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000268")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xoginfo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xoginfo.GetString("CODSOG"))+"";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"0000026A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("O","?",0,0,m_cServer),m_cServer,"O")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xoginfo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xoginfo.GetString("CODSOG"))+"";
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
          Cursor_xoginfo.Next();
        }
        m_cConnectivityError = Cursor_xoginfo.ErrorMessage();
        Cursor_xoginfo.Close();
        // * --- End Select
        // * --- Select from xiduciabo
        m_cServer = m_Ctx.GetServer("xiduciabo");
        m_cPhName = m_Ctx.GetPhName("xiduciabo");
        if (Cursor_xiduciabo!=null)
          Cursor_xiduciabo.Close();
        Cursor_xiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("xiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xiduciabo.Eof())) {
          /* _avanza := 0 */
          _avanza = CPLib.Round(0,0);
          /* If Empty(xiduciabo->CODSOG) */
          if (CPLib.Empty(Cursor_xiduciabo.GetString("CODSOG"))) {
            /* _avanza := 1 */
            _avanza = CPLib.Round(1,0);
          } // End If
          /* If _avanza=0 */
          if (CPLib.eqr(_avanza,0)) {
            /* _titola := 'S' */
            _titola = "S";
            /* xProg := '' */
            xProg = "";
            // * --- Insert into tmp_soggettioper from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_soggettioper");
            m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000272")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000272(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("T","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
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
            /* xProg := arfn_chkspers(xiduciabo->CODSOG,qbe_allxapopebo_tec_one->DATAREG) */
            xProg = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_xiduciabo.GetString("CODSOG"),Cursor_qbe_allxapopebo_tec_one.GetDate("DATAREG"));
            /* If Empty(LRTrim(xProg)) */
            if (CPLib.Empty(CPLib.LRTrim(xProg))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                // * --- Write into tmp_soggettioper from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_soggettioper");
                m_cPhName = m_Ctx.GetPhName("tmp_soggettioper");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_soggettioper",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000276")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xiduciabo.GetString("CODSOG"))+"";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_stdtec_rap_new",182,"00000278")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
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
                m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("RAPPORTO"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("FLAGRAP"),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_soggettioper",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allxapopebo_tec_one.GetString("IDBASE"))+"";
                m_cSql = m_cSql+" and TIPOPERS = "+CPSql.SQLValueAdapter(CPLib.ToSQL("T","?",0,0,m_cServer),m_cServer,"T")+"";
                m_cSql = m_cSql+" and CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xiduciabo.GetString("CODSOG"),"?",0,0,m_cServer),m_cServer,Cursor_xiduciabo.GetString("CODSOG"))+"";
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
          Cursor_xiduciabo.Next();
        }
        m_cConnectivityError = Cursor_xiduciabo.ErrorMessage();
        Cursor_xiduciabo.Close();
        // * --- End Select
        Cursor_qbe_allxapopebo_tec_one.Next();
      }
      m_cConnectivityError = Cursor_qbe_allxapopebo_tec_one.ErrorMessage();
      Cursor_qbe_allxapopebo_tec_one.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_allxapopebo_tec_one!=null)
          Cursor_qbe_allxapopebo_tec_one.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
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
        if (Cursor_xoginfo!=null)
          Cursor_xoginfo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xiduciabo!=null)
          Cursor_xiduciabo.Close();
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
    /* _report.setParameterChar('w_daRapporto',w_daRapporto) */
    _report.setParameterChar("w_daRapporto",w_daRapporto);
    /* _report.setParameterChar('w_aRapporto',w_aRapporto) */
    _report.setParameterChar("w_aRapporto",w_aRapporto);
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
      /* _varrep := 'arrp_stp_stdtec_rap' */
      _varrep = "arrp_stp_stdtec_rap";
    } else { // Else
      /* _varrep := 'arrp_stp_stdtec_rap_new' */
      _varrep = "arrp_stp_stdtec_rap_new";
    } // End If
    /* Exec "Stampa la singola pagina" Page 12:StampaPag */
    StampaPag();
    /* If _intest='S' */
    if (CPLib.eqr(_intest,"S")) {
      /* If _dataope < CharToDate('20140101') */
      if (CPLib.lt(_dataope,CPLib.CharToDate("20140101"))) {
        /* _varrep := 'arrp_stp_stdtec_rap_1' */
        _varrep = "arrp_stp_stdtec_rap_1";
      } else { // Else
        /* _varrep := "arrp_stp_stdtec_rap_1_new" */
        _varrep = "arrp_stp_stdtec_rap_1_new";
      } // End If
      /* Exec "Stampa la singola pagina" Page 12:StampaPag */
      StampaPag();
    } // End If
    /* If _esecut='S' */
    if (CPLib.eqr(_esecut,"S")) {
      /* If _dataope < CharToDate('20140101') */
      if (CPLib.lt(_dataope,CPLib.CharToDate("20140101"))) {
        /* _varrep := "arrp_stp_stdtec_rap_2" */
        _varrep = "arrp_stp_stdtec_rap_2";
      } else { // Else
        /* _varrep := "arrp_stp_stdtec_rap_2_new" */
        _varrep = "arrp_stp_stdtec_rap_2_new";
      } // End If
      /* Exec "Stampa la singola pagina" Page 12:StampaPag */
      StampaPag();
    } // End If
    /* If _delega='S' */
    if (CPLib.eqr(_delega,"S")) {
      /* If _dataope < CharToDate('20140101') */
      if (CPLib.lt(_dataope,CPLib.CharToDate("20140101"))) {
        /* _varrep := "arrp_stp_stdtec_rap_3" */
        _varrep = "arrp_stp_stdtec_rap_3";
      } else { // Else
        /* _varrep := "arrp_stp_stdtec_rap_3_new" */
        _varrep = "arrp_stp_stdtec_rap_3_new";
      } // End If
      /* Exec "Stampa la singola pagina" Page 12:StampaPag */
      StampaPag();
    } // End If
    /* If _titola='S' */
    if (CPLib.eqr(_titola,"S")) {
      /* If _dataope < CharToDate('20140101') */
      if (CPLib.lt(_dataope,CPLib.CharToDate("20140101"))) {
        /* _varrep := "arrp_stp_stdtec_rap_4" */
        _varrep = "arrp_stp_stdtec_rap_4";
      } else { // Else
        /* _varrep := "arrp_stp_stdtec_rap_4_new" */
        _varrep = "arrp_stp_stdtec_rap_4_new";
      } // End If
      /* Exec "Stampa la singola pagina" Page 12:StampaPag */
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
    /* _nomerep := _nomerep + LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/'+_varrep+'_'+_id+'.pdf;' // Nome Stampa */
    _nomerep = _nomerep+CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+_varrep+"_"+_id+".pdf;";
    /* _report.SetParameterNumeric('nNumPage',nPag) */
    _report.SetParameterNumeric("nNumPage",nPag);
    /* bReport := _report.makeReport(_varrep,LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+'/'+_varrep+'_'+_id+'.pdf','A4','PORTRAIT',pPDF) */
    bReport = _report.makeReport(_varrep,CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+_varrep+"_"+_id+".pdf","A4","PORTRAIT",pPDF);
    /* nPag := _report.GetnNumPage()+1 */
    nPag = CPLib.Round(_report.GetnNumPage()+1,0);
  }
  void _init_() {
  }
  public String RunAsync(String p_pAUI,String p_pPDF,java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,java.sql.Date p_w_DaDatReg,java.sql.Date p_w_ADatReg,String p_w_daRapporto,String p_w_aRapporto,String p_w_daCodDip,String p_w_aCodDip) {
    pAUI = p_pAUI;
    pPDF = p_pPDF;
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_DaDatReg = p_w_DaDatReg;
    w_ADatReg = p_w_ADatReg;
    w_daRapporto = p_w_daRapporto;
    w_aRapporto = p_w_aRapporto;
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
  public Forward Run(String p_pAUI,String p_pPDF,java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,java.sql.Date p_w_DaDatReg,java.sql.Date p_w_ADatReg,String p_w_daRapporto,String p_w_aRapporto,String p_w_daCodDip,String p_w_aCodDip) {
    pAUI = p_pAUI;
    pPDF = p_pPDF;
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_DaDatReg = p_w_DaDatReg;
    w_ADatReg = p_w_ADatReg;
    w_daRapporto = p_w_daRapporto;
    w_aRapporto = p_w_aRapporto;
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
  public static arrt_stp_stdtec_rap_newR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stp_stdtec_rap_newR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pAUI = CPLib.Space(1);
    pPDF = CPLib.Space(6);
    w_DaDatOpe = CPLib.NullDate();
    w_ADatOpe = CPLib.NullDate();
    w_DaDatReg = CPLib.NullDate();
    w_ADatReg = CPLib.NullDate();
    w_daRapporto = CPLib.Space(25);
    w_aRapporto = CPLib.Space(25);
    w_daCodDip = CPLib.Space(6);
    w_aCodDip = CPLib.Space(6);
    _nomerep = "";
    _report = null;
    bReport = false;
    _id = CPLib.Space(6);
    _idrep = CPLib.Space(10);
    _conta = 0;
    _numsto = CPLib.Space(15);
    w_c_dadata = CPLib.Space(8);
    w_c_adata = CPLib.Space(8);
    w_dacdatreg = CPLib.Space(8);
    w_acdatreg = CPLib.Space(8);
    xProg = CPLib.Space(15);
    lReport = "";
    _avanza = 0;
    _intest = CPLib.Space(1);
    _delega = CPLib.Space(1);
    _titola = CPLib.Space(1);
    _esecut = CPLib.Space(1);
    w_idinfo = CPLib.Space(10);
    _trovati = 0;
    _dataope = CPLib.NullDate();
    _varrep = CPLib.Space(30);
    _reportname = CPLib.Space(100);
    filepdf = CPLib.Space(128);
    nPag = 0;
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
  // ENTITY_VQR: ,qbe_allrapopebo_tec,qbe_allxapopebo_tec,qbe_allrapopebo_tec_one,qbe_allrapopebo_tec_one,qbe_allrapopebo_tec_one,qbe_allrapopebo_tec_one,qbe_allxapopebo_tec_one,qbe_allxapopebo_tec_one,qbe_allxapopebo_tec_one,
  public static final String m_cVQRList = ",qbe_allrapopebo_tec,qbe_allxapopebo_tec,qbe_allrapopebo_tec_one,qbe_allrapopebo_tec_one,qbe_allrapopebo_tec_one,qbe_allrapopebo_tec_one,qbe_allxapopebo_tec_one,qbe_allxapopebo_tec_one,qbe_allxapopebo_tec_one,";
  // ENTITY_BATCHES: ,arfn_chkspers,arfn_dateminus,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_chkspers,arfn_dateminus,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"pAUI","pPDF","w_DaDatOpe","w_ADatOpe","w_DaDatReg","w_ADatReg","w_daRapporto","w_aRapporto","w_daCodDip","w_aCodDip"};
  protected static String GetFieldsName_0000005F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000075(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000083(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000092(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000000AB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000000BA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000000C9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000000E2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000000F0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000000FF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000010E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000011C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000127(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000135(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000143(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000151(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000015C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000016A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000178(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000186(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000192(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000001A1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000001B2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000001C1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000001CD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000001D9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000001E8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000001F9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000208(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000216(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000221(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000022F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000023D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000024B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000256(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000264(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000272(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
