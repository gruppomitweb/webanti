// * --- Area Manuale = BO - Header
// * --- arrt_stprappo_prv
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
public class arrt_stprappo_prvR implements CallerWithObjs {
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
  public String m_cPhName_tmp_stprapporti;
  public String m_cServer_tmp_stprapporti;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tbtipdoc;
  public String m_cServer_tbtipdoc;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_tbstgru;
  public String m_cServer_tbstgru;
  public String m_cPhName_tbtipatt;
  public String m_cServer_tbtipatt;
  public String m_cPhName_tbsetsin;
  public String m_cServer_tbsetsin;
  public String m_cPhName_tbramgru;
  public String m_cServer_tbramgru;
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
  public String w_daRappo;
  public String w_aRappo;
  public java.sql.Date w_DaData;
  public java.sql.Date w_AData;
  public String w_c_dadata;
  public String w_c_adata;
  public String w_detope;
  public String w_flgtit;
  public String w_flgdel;
  public String w_coddip;
  public String gPathApp;
  public String gUrlApp;
  public String gDescAzi;
  public String gAzienda;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_stprappo_prv
  public int riga;
  public DateTime dt;
  // * --- Fine Area Manuale
  public arrt_stprappo_prvR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stprappo_prv",m_Caller);
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stprapporti")) {
      m_cPhName_tmp_stprapporti = p_ContextObject.GetPhName("tmp_stprapporti");
      if (m_cPhName_tmp_stprapporti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stprapporti = m_cPhName_tmp_stprapporti+" "+m_Ctx.GetWritePhName("tmp_stprapporti");
      }
      m_cServer_tmp_stprapporti = p_ContextObject.GetServer("tmp_stprapporti");
    }
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
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_tbtipdoc = p_ContextObject.GetPhName("tbtipdoc");
    if (m_cPhName_tbtipdoc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipdoc = m_cPhName_tbtipdoc+" "+m_Ctx.GetWritePhName("tbtipdoc");
    }
    m_cServer_tbtipdoc = p_ContextObject.GetServer("tbtipdoc");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_tbstgru = p_ContextObject.GetPhName("tbstgru");
    if (m_cPhName_tbstgru.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstgru = m_cPhName_tbstgru+" "+m_Ctx.GetWritePhName("tbstgru");
    }
    m_cServer_tbstgru = p_ContextObject.GetServer("tbstgru");
    m_cPhName_tbtipatt = p_ContextObject.GetPhName("tbtipatt");
    if (m_cPhName_tbtipatt.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipatt = m_cPhName_tbtipatt+" "+m_Ctx.GetWritePhName("tbtipatt");
    }
    m_cServer_tbtipatt = p_ContextObject.GetServer("tbtipatt");
    m_cPhName_tbsetsin = p_ContextObject.GetPhName("tbsetsin");
    if (m_cPhName_tbsetsin.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbsetsin = m_cPhName_tbsetsin+" "+m_Ctx.GetWritePhName("tbsetsin");
    }
    m_cServer_tbsetsin = p_ContextObject.GetServer("tbsetsin");
    m_cPhName_tbramgru = p_ContextObject.GetPhName("tbramgru");
    if (m_cPhName_tbramgru.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbramgru = m_cPhName_tbramgru+" "+m_Ctx.GetWritePhName("tbramgru");
    }
    m_cServer_tbramgru = p_ContextObject.GetServer("tbramgru");
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
      return "arrt_stprappo_prv";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("daRappo",p_cVarName)) {
      return w_daRappo;
    }
    if (CPLib.eqr("aRappo",p_cVarName)) {
      return w_aRappo;
    }
    if (CPLib.eqr("c_dadata",p_cVarName)) {
      return w_c_dadata;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return w_c_adata;
    }
    if (CPLib.eqr("detope",p_cVarName)) {
      return w_detope;
    }
    if (CPLib.eqr("flgtit",p_cVarName)) {
      return w_flgtit;
    }
    if (CPLib.eqr("flgdel",p_cVarName)) {
      return w_flgdel;
    }
    if (CPLib.eqr("coddip",p_cVarName)) {
      return w_coddip;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DaData",p_cVarName)) {
      return w_DaData;
    }
    if (CPLib.eqr("AData",p_cVarName)) {
      return w_AData;
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
    if (CPLib.eqr("daRappo",p_cVarName)) {
      w_daRappo = value;
      return;
    }
    if (CPLib.eqr("aRappo",p_cVarName)) {
      w_aRappo = value;
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
    if (CPLib.eqr("detope",p_cVarName)) {
      w_detope = value;
      return;
    }
    if (CPLib.eqr("flgtit",p_cVarName)) {
      w_flgtit = value;
      return;
    }
    if (CPLib.eqr("flgdel",p_cVarName)) {
      w_flgdel = value;
      return;
    }
    if (CPLib.eqr("coddip",p_cVarName)) {
      w_coddip = value;
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
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
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
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DaData",p_cVarName)) {
      w_DaData = value;
      return;
    }
    if (CPLib.eqr("AData",p_cVarName)) {
      w_AData = value;
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
    /* w_daRappo Char(25) */
    /* w_aRappo Char(25) */
    /* w_DaData Date */
    /* w_AData Date */
    /* w_c_dadata Char(8) */
    /* w_c_adata Char(8) */
    /* w_detope Char(1) */
    /* w_flgtit Char(1) */
    /* w_flgdel Char(1) */
    /* w_coddip Char(6) */
    /* gPathApp Char(80) // Path Applicazione */
    /* gUrlApp Char(80) // URL Applicazione */
    /* gDescAzi Char(70) // Descrizione Intermediario */
    /* gAzienda Char(10) // Azienda */
    /* gMsgImp Char(120) // Messaggio Import */
    /* Lancio la stampa */
    /* w_c_dadata := iif(w_c_dadata='01000101','',w_c_dadata) */
    w_c_dadata = (CPLib.eqr(w_c_dadata,"01000101")?"":w_c_dadata);
    /* w_c_adata := iif(w_c_adata='01000101','',w_c_adata) */
    w_c_adata = (CPLib.eqr(w_c_adata,"01000101")?"":w_c_adata);
    // * --- Drop temporary table tmp_stprapporti
    if (m_Ctx.IsSharedTemp("tmp_stprapporti")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_stprapporti")) {
        m_cServer = m_Ctx.GetServer("tmp_stprapporti");
        m_cPhName = m_Ctx.GetPhName("tmp_stprapporti");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_stprapporti");
    }
    // * --- Create temporary table tmp_stprapporti
    if (m_Ctx.IsSharedTemp("tmp_stprapporti")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_stprapporti")) {
        m_cServer = m_Ctx.GetServer("tmp_stprapporti");
        m_cPhName = m_Ctx.GetPhName("tmp_stprapporti");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_stprapporti");
    }
    m_cPhName = m_Ctx.CreateTmpPhName("tmp_stprapporti");
    new VQRHolder("qbe_allxapopebo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).CreateServerQuery(m_Ctx, "tmp_stprapporti",false);
    m_cPhName_tmp_stprapporti = m_cPhName;
    /* If w_detope='S' */
    if (CPLib.eqr(w_detope,"S")) {
      /* Stop arrp_stprappo_prv2.vrp */
      Forward f;
      f=new Forward("Report",false,this,Forward.Start,false);
      f.SetParameter("daRappo",w_daRappo);
      f.SetParameter("aRappo",w_aRappo);
      f.SetParameter("DaData",w_DaData);
      f.SetParameter("AData",w_AData);
      f.SetParameter("c_dadata",w_c_dadata);
      f.SetParameter("c_adata",w_c_adata);
      f.SetParameter("DescAzi",gDescAzi);
      f.SetParameter("ReportName","arrp_stprappo_prv2.vrp");
      f.SetParameter("m_cParameterSequence","daRappo"+","+"aRappo"+","+"DaData"+","+"AData"+","+"c_dadata"+","+"c_adata"+","+"DescAzi"+","+"ReportName");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } else { // Else
      /* Stop arrp_stprappo_prv1.vrp */
      Forward f;
      f=new Forward("Report",false,this,Forward.Start,false);
      f.SetParameter("daRappo",w_daRappo);
      f.SetParameter("aRappo",w_aRappo);
      f.SetParameter("DaData",w_DaData);
      f.SetParameter("AData",w_AData);
      f.SetParameter("c_dadata",w_c_dadata);
      f.SetParameter("c_adata",w_c_adata);
      f.SetParameter("DescAzi",gDescAzi);
      f.SetParameter("hideLanguage",true);
      f.SetParameter("hideSettings",true);
      f.SetParameter("hideExport",true);
      f.SetParameter("ReportName","arrp_stprappo_prv1.vrp");
      f.SetParameter("m_cParameterSequence","daRappo"+","+"aRappo"+","+"DaData"+","+"AData"+","+"c_dadata"+","+"c_adata"+","+"DescAzi"+","+"hideLanguage"+","+"hideSettings"+","+"hideExport"+","+"ReportName");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } // End If
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
      m_Caller.SetString("daRappo","C",25,0,w_daRappo);
      m_Caller.SetString("aRappo","C",25,0,w_aRappo);
      m_Caller.SetDate("DaData","D",8,0,w_DaData);
      m_Caller.SetDate("AData","D",8,0,w_AData);
      m_Caller.SetString("c_dadata","C",8,0,w_c_dadata);
      m_Caller.SetString("c_adata","C",8,0,w_c_adata);
      m_Caller.SetString("detope","C",1,0,w_detope);
      m_Caller.SetString("flgtit","C",1,0,w_flgtit);
      m_Caller.SetString("flgdel","C",1,0,w_flgdel);
      m_Caller.SetString("coddip","C",6,0,w_coddip);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_stprappo_prvR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stprappo_prvR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_daRappo = m_Caller.GetString("daRappo","C",25,0);
    w_aRappo = m_Caller.GetString("aRappo","C",25,0);
    w_DaData = m_Caller.GetDate("DaData","D",8,0);
    w_AData = m_Caller.GetDate("AData","D",8,0);
    w_c_dadata = m_Caller.GetString("c_dadata","C",8,0);
    w_c_adata = m_Caller.GetString("c_adata","C",8,0);
    w_detope = m_Caller.GetString("detope","C",1,0);
    w_flgtit = m_Caller.GetString("flgtit","C",1,0);
    w_flgdel = m_Caller.GetString("flgdel","C",1,0);
    w_coddip = m_Caller.GetString("coddip","C",6,0);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_allxapopebo,
  public static final String m_cVQRList = ",qbe_allxapopebo,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
