// * --- Area Manuale = BO - Header
// * --- arfn_start_estrai_xls
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import com.opencsv.CSVWriter;
import java.util.ArrayList;
// * --- Fine Area Manuale
public class arfn_start_estrai_xlsR implements CallerWithObjs {
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
  public String m_cPhName_bckprocessi;
  public String m_cServer_bckprocessi;
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
  public MemoryCursor_mcparametri_mcrdef mcParam;
  public String gAzienda;
  public String gPathDoc;
  public String gFileName;
  public String gFileZIP;
  public String gUrlApp;
  public String gMsgImp;
  public String cProg;
  public String _filezip;
  // * --- Area Manuale = BO - Properties
  // * --- arfn_start_estrai_xls
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
  // * --- Fine Area Manuale
  public arfn_start_estrai_xlsR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_start_estrai_xls",m_Caller);
    m_cPhName_bckprocessi = p_ContextObject.GetPhName("bckprocessi");
    if (m_cPhName_bckprocessi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_bckprocessi = m_cPhName_bckprocessi+" "+m_Ctx.GetWritePhName("bckprocessi");
    }
    m_cServer_bckprocessi = p_ContextObject.GetServer("bckprocessi");
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
      return "arfn_start_estrai_xls";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gFileName",p_cVarName)) {
      return gFileName;
    }
    if (CPLib.eqr("gFileZIP",p_cVarName)) {
      return gFileZIP;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("_filezip",p_cVarName)) {
      return _filezip;
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
    if (CPLib.eqr("mcParam",p_cVarName)) {
      return mcParam;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("gFileName",p_cVarName)) {
      gFileName = value;
      return;
    }
    if (CPLib.eqr("gFileZIP",p_cVarName)) {
      gFileZIP = value;
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
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("_filezip",p_cVarName)) {
      _filezip = value;
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
    if (CPLib.eqr("mcParam",p_cVarName)) {
      mcParam = (MemoryCursor_mcparametri_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    /* mcParam MemoryCursor(mcParametri.MCRDef) */
    /* gAzienda Char(10) // Azienda */
    /* gPathDoc Char(80) // Path Applicazione */
    /* gFileName Char(80) // NomeFile */
    /* gFileZIP Char(80) // NomeFile */
    /* gUrlApp Char(80) // URL Applicazione */
    /* gMsgImp Char(120) // Messaggio Import */
    /* cProg Char(10) */
    /* _filezip Char(128) */
    /* mcParam.GoTop() */
    mcParam.GoTop();
    /* If mcParam.pTipo='B' */
    if (CPLib.eqr(mcParam.row.pTipo,"B")) {
      /* cProg := Utilities.GetAutonumber("PBCKPROC\'"+LRTrim(gAzienda)+"'","",10) */
      cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PBCKPROC\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
      // * --- Insert into bckprocessi from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("bckprocessi");
      m_cPhName = m_Ctx.GetPhName("bckprocessi");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"bckprocessi",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arfn_start_estrai_xls",286,"00000010")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_00000010(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("arrt_estrai_xls","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.pTipo,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(mcParam.row.w_dadata),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(mcParam.row.w_adata),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_cdadata,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_c_adata,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_cDIP,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_xdesdip,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_ragosc,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_citnas,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_stanas,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(mcParam.row.w_datnas)?"":CPLib.DateToChar(mcParam.row.w_datnas)),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_cMTCN,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_cCODFISC,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_ragben,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_staben,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_codmag,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_connes,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_nomefile,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_tipofile,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_flgsto,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_tipoout,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_opesel,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_frzsel,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_attive,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_destfold,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(gAzienda,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(gPathDoc,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_flgmese,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_flgncf,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_flgsegno,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_lststa,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_lstprv,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(CPLib.Str(mcParam.row.w_importo,15,2)),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(mcParam.row.w_storico,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(34,"?",0,0)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"bckprocessi",true);
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
      /* gMsgImp := 'Elaborazione programmata. Consultare la schermata dei processi per verificare lo stato di avanzamento' // Messaggio Import */
      gMsgImp = "Elaborazione programmata. Consultare la schermata dei processi per verificare lo stato di avanzamento";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } else { // Else
      /* gMsgImp := 'Inizio Estrazione Movimenti in base alle selezioni' // Messaggio Import */
      gMsgImp = "Inizio Estrazione Movimenti in base alle selezioni";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Exec Routine arrt_estrai_xls_func(mcParam,gAzienda,gPathDoc) */
      arrt_estrai_xls_funcR.Make(m_Ctx,this).Run(mcParam,gAzienda,gPathDoc);
      // Rilegge il valore di gFileName
      gFileName=m_Ctx.GetGlobalString("gFileName");
      /* _filezip := iif(Empty(LRTrim(mcParam.w_destfold)),LRTrim(gPathDoc)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(gFileName),LRTrim(mcParam.w_destfold)+"/"+LRTrim(gFileName)) */
      _filezip = (CPLib.Empty(CPLib.LRTrim(mcParam.row.w_destfold))?CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(gFileName):CPLib.LRTrim(mcParam.row.w_destfold)+"/"+CPLib.LRTrim(gFileName));
      /* If FileLibMit.ExistFile(_filezip) */
      if (FileLibMit.ExistFile(_filezip)) {
        /* gMsgImp := 'Elaborazione Terminata. Attendere lo scaricamento del file' // Messaggio Import */
        gMsgImp = "Elaborazione Terminata. Attendere lo scaricamento del file";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gFileZIP := gFileName // NomeFile */
        gFileZIP = gFileName;
        m_Ctx.SetGlobalString("gFileZIP",gFileZIP);
        /* Return gFileZIP */
        throw new Stop(gFileZIP);
      } else { // Else
        /* gMsgImp := 'Elaborazione Terminata. Non è stato generato il file di destinazione' // Messaggio Import */
        gMsgImp = "Elaborazione Terminata. Non è stato generato il file di destinazione";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } // End If
    } // End If
  }
  void _init_() {
  }
  public String RunAsync(MemoryCursor_mcparametri_mcrdef p_mcParam) {
    mcParam = p_mcParam;
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
  public String Run(MemoryCursor_mcparametri_mcrdef p_mcParam) {
    mcParam = p_mcParam;
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
  public static arfn_start_estrai_xlsR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_start_estrai_xlsR(p_Ctx, p_Caller);
  }
  public static arfn_start_estrai_xlsR Make(CPContext p_Ctx) {
    return new arfn_start_estrai_xlsR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    mcParam = new MemoryCursor_mcparametri_mcrdef();
    cProg = CPLib.Space(10);
    _filezip = CPLib.Space(128);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gFileName=m_Ctx.GetGlobalString("gFileName");
    gFileZIP=m_Ctx.GetGlobalString("gFileZIP");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_start_estrai_xls,arrt_estrai_xls_func,
  public static final String i_InvokedRoutines = ",arfn_start_estrai_xls,arrt_estrai_xls_func,";
  public static String[] m_cRunParameterNames={"mcParam"};
  protected static String GetFieldsName_00000010(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PBCODICE,";
    p_cSql = p_cSql+"PBSTATO,";
    p_cSql = p_cSql+"PBSERVLET,";
    p_cSql = p_cSql+"PBPARAM01,";
    p_cSql = p_cSql+"PBPARAM02,";
    p_cSql = p_cSql+"PBPARAM03,";
    p_cSql = p_cSql+"PBPARAM04,";
    p_cSql = p_cSql+"PBPARAM05,";
    p_cSql = p_cSql+"PBPARAM06,";
    p_cSql = p_cSql+"PBPARAM07,";
    p_cSql = p_cSql+"PBPARAM08,";
    p_cSql = p_cSql+"PBPARAM09,";
    p_cSql = p_cSql+"PBPARAM10,";
    p_cSql = p_cSql+"PBPARAM11,";
    p_cSql = p_cSql+"PBPARAM12,";
    p_cSql = p_cSql+"PBPARAM13,";
    p_cSql = p_cSql+"PBPARAM14,";
    p_cSql = p_cSql+"PBPARAM15,";
    p_cSql = p_cSql+"PBPARAM16,";
    p_cSql = p_cSql+"PBPARAM17,";
    p_cSql = p_cSql+"PBPARAM18,";
    p_cSql = p_cSql+"PBPARAM19,";
    p_cSql = p_cSql+"PBPARAM20,";
    p_cSql = p_cSql+"PBPARAM21,";
    p_cSql = p_cSql+"PBPARAM22,";
    p_cSql = p_cSql+"PBPARAM23,";
    p_cSql = p_cSql+"PBPARAM24,";
    p_cSql = p_cSql+"PBPARAM25,";
    p_cSql = p_cSql+"PBPARAM26,";
    p_cSql = p_cSql+"PBPARAM27,";
    p_cSql = p_cSql+"PBPARAM28,";
    p_cSql = p_cSql+"PBPARAM29,";
    p_cSql = p_cSql+"PBPARAM30,";
    p_cSql = p_cSql+"PBPARAM31,";
    p_cSql = p_cSql+"PBPARAM32,";
    p_cSql = p_cSql+"PBPARAM33,";
    p_cSql = p_cSql+"PBPARAM34,";
    p_cSql = p_cSql+"PBTIPOP01,";
    p_cSql = p_cSql+"PBTIPOP02,";
    p_cSql = p_cSql+"PBTIPOP03,";
    p_cSql = p_cSql+"PBTIPOP04,";
    p_cSql = p_cSql+"PBTIPOP05,";
    p_cSql = p_cSql+"PBTIPOP06,";
    p_cSql = p_cSql+"PBTIPOP07,";
    p_cSql = p_cSql+"PBTIPOP08,";
    p_cSql = p_cSql+"PBTIPOP09,";
    p_cSql = p_cSql+"PBTIPOP10,";
    p_cSql = p_cSql+"PBTIPOP11,";
    p_cSql = p_cSql+"PBTIPOP12,";
    p_cSql = p_cSql+"PBTIPOP13,";
    p_cSql = p_cSql+"PBTIPOP14,";
    p_cSql = p_cSql+"PBTIPOP15,";
    p_cSql = p_cSql+"PBTIPOP16,";
    p_cSql = p_cSql+"PBTIPOP17,";
    p_cSql = p_cSql+"PBTIPOP18,";
    p_cSql = p_cSql+"PBTIPOP19,";
    p_cSql = p_cSql+"PBTIPOP20,";
    p_cSql = p_cSql+"PBTIPOP21,";
    p_cSql = p_cSql+"PBTIPOP22,";
    p_cSql = p_cSql+"PBTIPOP23,";
    p_cSql = p_cSql+"PBTIPOP24,";
    p_cSql = p_cSql+"PBTIPOP25,";
    p_cSql = p_cSql+"PBTIPOP26,";
    p_cSql = p_cSql+"PBTIPOP27,";
    p_cSql = p_cSql+"PBTIPOP28,";
    p_cSql = p_cSql+"PBTIPOP29,";
    p_cSql = p_cSql+"PBTIPOP30,";
    p_cSql = p_cSql+"PBTIPOP31,";
    p_cSql = p_cSql+"PBTIPOP32,";
    p_cSql = p_cSql+"PBTIPOP33,";
    p_cSql = p_cSql+"PBTIPOP34,";
    p_cSql = p_cSql+"PBNUMPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"bckprocessi",true);
    return p_cSql;
  }
}
