// * --- Area Manuale = BO - Header
// * --- arrt_stplegami_elenco
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
public class arrt_stplegami_elencoR implements CallerWithObjs {
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
  public String m_cPhName_tmp_stprapporti_ele;
  public String m_cServer_tmp_stprapporti_ele;
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
  public java.sql.Date w_DaDatIni;
  public java.sql.Date w_ADatIni;
  public java.sql.Date w_DaDatFin;
  public java.sql.Date w_ADatFin;
  public String gPathApp;
  public String gUrlApp;
  public String gDescAzi;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_stplegami_elenco
  public int riga;
  public DateTime dt;
  // * --- Fine Area Manuale
  public arrt_stplegami_elencoR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stplegami_elenco",m_Caller);
    m_cPhName_tmp_stprapporti_ele = p_ContextObject.GetPhName("tmp_stprapporti_ele");
    if (m_cPhName_tmp_stprapporti_ele.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_stprapporti_ele = m_cPhName_tmp_stprapporti_ele+" "+m_Ctx.GetWritePhName("tmp_stprapporti_ele");
    }
    m_cServer_tmp_stprapporti_ele = p_ContextObject.GetServer("tmp_stprapporti_ele");
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
      return "arrt_stplegami_elenco";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("daRappo",p_cVarName)) {
      return w_daRappo;
    }
    if (CPLib.eqr("aRappo",p_cVarName)) {
      return w_aRappo;
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
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DaDatIni",p_cVarName)) {
      return w_DaDatIni;
    }
    if (CPLib.eqr("ADatIni",p_cVarName)) {
      return w_ADatIni;
    }
    if (CPLib.eqr("DaDatFin",p_cVarName)) {
      return w_DaDatFin;
    }
    if (CPLib.eqr("ADatFin",p_cVarName)) {
      return w_ADatFin;
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
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DaDatIni",p_cVarName)) {
      w_DaDatIni = value;
      return;
    }
    if (CPLib.eqr("ADatIni",p_cVarName)) {
      w_ADatIni = value;
      return;
    }
    if (CPLib.eqr("DaDatFin",p_cVarName)) {
      w_DaDatFin = value;
      return;
    }
    if (CPLib.eqr("ADatFin",p_cVarName)) {
      w_ADatFin = value;
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
    /* Parametro della procedura */
    /* w_daRappo Char(25) */
    /* w_aRappo Char(25) */
    /* w_DaDatIni Date */
    /* w_ADatIni Date */
    /* w_DaDatFin Date */
    /* w_ADatFin Date */
    /* gPathApp Char(80) // Path Applicazione */
    /* gUrlApp Char(80) // URL Applicazione */
    /* gDescAzi Char(70) // Descrizione Intermediario */
    /* Lancio la stampa */
    // * --- Drop temporary table tmp_stprapporti_ele
    if (m_Ctx.IsSharedTemp("tmp_stprapporti_ele")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_stprapporti_ele")) {
        m_cServer = m_Ctx.GetServer("tmp_stprapporti_ele");
        m_cPhName = m_Ctx.GetPhName("tmp_stprapporti_ele");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_stprapporti_ele");
    }
    /* Stop Report */
    Forward f;
    f=new Forward("Report",false,this,Forward.Start,false);
    f.SetParameter("ReportName","arrp_stprappo_elenco");
    f.SetParameter("outputFormat","PDF");
    f.SetParameter("rotation","LANDSCAPE");
    f.SetParameter("daRappo",w_daRappo);
    f.SetParameter("aRappo",w_aRappo);
    f.SetParameter("DaDatIni",w_DaDatIni);
    f.SetParameter("ADatIni",w_ADatIni);
    f.SetParameter("DaDatFin",w_DaDatFin);
    f.SetParameter("ADatFin",w_ADatFin);
    f.SetParameter("DescAzi",gDescAzi);
    f.SetParameter("m_cParameterSequence","ReportName"+","+"outputFormat"+","+"rotation"+","+"daRappo"+","+"aRappo"+","+"DaDatIni"+","+"ADatIni"+","+"DaDatFin"+","+"ADatFin"+","+"DescAzi");
    f.SetParameter("m_cMode","hyperlink");
    throw f;
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
      m_Caller.SetDate("DaDatIni","D",8,0,w_DaDatIni);
      m_Caller.SetDate("ADatIni","D",8,0,w_ADatIni);
      m_Caller.SetDate("DaDatFin","D",8,0,w_DaDatFin);
      m_Caller.SetDate("ADatFin","D",8,0,w_ADatFin);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_stplegami_elencoR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stplegami_elencoR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_daRappo = m_Caller.GetString("daRappo","C",25,0);
    w_aRappo = m_Caller.GetString("aRappo","C",25,0);
    w_DaDatIni = m_Caller.GetDate("DaDatIni","D",8,0);
    w_ADatIni = m_Caller.GetDate("ADatIni","D",8,0);
    w_DaDatFin = m_Caller.GetDate("DaDatFin","D",8,0);
    w_ADatFin = m_Caller.GetDate("ADatFin","D",8,0);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
