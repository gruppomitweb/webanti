// * --- Area Manuale = BO - Header
// * --- arrt_wutrxchk_save_sched
import java.util.*;
import java.util.Iterator;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
// * --- Fine Area Manuale
public class arrt_wutrxchk_save_schedR implements CallerWithObjs {
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
  // I messaggi vengono instradati su questo oggetto
  public CPMessageSink m_MessageSink;
  public com.zucchetti.sitepainter.Logger m_Debug;
  public com.zucchetti.sitepainter.Logger m_Info;
  public com.zucchetti.sitepainter.Logger m_Warning;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_wutrxchk_checked;
  public String m_cServer_wutrxchk_checked;
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
  public String _gAzienda;
  public String _gPathApp;
  public String _gPathDoc;
  public String _filen;
  public MemoryCursor_wutrxchk_checked mcTransazioni;
  public MemoryCursor_mcerratedef_mcrdef mcErrate;
  public String _nfile;
  public String _tipimp;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_wutrxchk_save_sched
  public int _i;
  public int _y;
  public int _righe;
  public int conta;
  public int _conta;
  public int r;
  public int cell_count;
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
  // * --- Fine Area Manuale
  public arrt_wutrxchk_save_schedR (CPContext p_ContextObject, Caller caller) {
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
    // I messaggi vengono instradati su questo oggetto
    m_MessageSink = CPMessageSink.ConsoleSink;
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_wutrxchk_save_sched",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_wutrxchk_checked = p_ContextObject.GetPhName("wutrxchk_checked");
    if (m_cPhName_wutrxchk_checked.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wutrxchk_checked = m_cPhName_wutrxchk_checked+" "+m_Ctx.GetWritePhName("wutrxchk_checked");
    }
    m_cServer_wutrxchk_checked = p_ContextObject.GetServer("wutrxchk_checked");
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
      return "arrt_wutrxchk_save_sched";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      return _gAzienda;
    }
    if (CPLib.eqr("_gPathApp",p_cVarName)) {
      return _gPathApp;
    }
    if (CPLib.eqr("_gPathDoc",p_cVarName)) {
      return _gPathDoc;
    }
    if (CPLib.eqr("_filen",p_cVarName)) {
      return _filen;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      return _nfile;
    }
    if (CPLib.eqr("_tipimp",p_cVarName)) {
      return _tipimp;
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
    if (CPLib.eqr("mcTransazioni",p_cVarName)) {
      return mcTransazioni;
    }
    if (CPLib.eqr("mcErrate",p_cVarName)) {
      return mcErrate;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      _gAzienda = value;
      return;
    }
    if (CPLib.eqr("_gPathApp",p_cVarName)) {
      _gPathApp = value;
      return;
    }
    if (CPLib.eqr("_gPathDoc",p_cVarName)) {
      _gPathDoc = value;
      return;
    }
    if (CPLib.eqr("_filen",p_cVarName)) {
      _filen = value;
      return;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      _nfile = value;
      return;
    }
    if (CPLib.eqr("_tipimp",p_cVarName)) {
      _tipimp = value;
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
    if (CPLib.eqr("mcTransazioni",p_cVarName)) {
      mcTransazioni = (MemoryCursor_wutrxchk_checked)value;
      return;
    }
    if (CPLib.eqr("mcErrate",p_cVarName)) {
      mcErrate = (MemoryCursor_mcerratedef_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_Main() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_wutrxchk_checked=null;
    try {
      /* _gAzienda Char(10) // Azienda */
      /* _gPathApp Char(80) // Path Applicazione */
      /* _gPathDoc Char(80) */
      /* _filen Char(50) */
      /* mcTransazioni MemoryCursor(wutrxchk_checked) */
      /* mcErrate MemoryCursor(mcErrateDef.MCRDef) */
      /* _nfile Char(100) */
      /* _tipimp Char(1) */
      /* Info Msg 'Elaborazione Correzioni AUA' */
      if ( ! (CPLib.IsNull(m_Info))) {
        m_Info.log(CPLib.FormatMsg(m_Ctx,"Elaborazione Correzioni AUA"));
      }
      /* Utilities.SetCompany('AUIWUPSIL') */
      Utilities.Make(m_Ctx,m_Caller).SetCompany("AUIWUPSIL");
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select FLGTIPIMP,RICEVUTE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _tipimp := intermbo->FLGTIPIMP */
        _tipimp = Cursor_intermbo.GetString("FLGTIPIMP");
        /* _gPathDoc := intermbo->RICEVUTE */
        _gPathDoc = Cursor_intermbo.GetString("RICEVUTE");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _gAzienda := 'AUIWUPSIL' // Azienda */
      _gAzienda = "AUIWUPSIL";
      /* _gPathApp := Strtran(FileLibMit.GetLocation(),'\','/') // Path Applicazione */
      _gPathApp = CPLib.Strtran(FileLibMit.GetLocation(),"\\","/");
      /* _gPathApp := Strtran(_gPathApp,'/servlet/','') // Path Applicazione */
      _gPathApp = CPLib.Strtran(_gPathApp,"/servlet/","");
      /* _filen := LibreriaMit.UniqueId()+"_TRX.xlsx" */
      _filen = LibreriaMit.UniqueId()+"_TRX.xlsx";
      // * --- Fill memory cursor mcTransazioni on wutrxchk_checked
      mcTransazioni.Zap();
      m_cServer = m_Ctx.GetServer("wutrxchk_checked");
      m_cPhName = m_Ctx.GetPhName("wutrxchk_checked");
      if (Cursor_wutrxchk_checked!=null)
        Cursor_wutrxchk_checked.Close();
      Cursor_wutrxchk_checked = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("wutrxchk_checked")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_wutrxchk_checked;
        Cursor_wutrxchk_checked.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_wutrxchk_save_sched: query on wutrxchk_checked returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_wutrxchk_checked.Eof())) {
        mcTransazioni.AppendBlank();
        mcTransazioni.row.TRXCODPRG = Cursor_wutrxchk_checked.GetDouble("TRXCODPRG");
        mcTransazioni.row.TRXCOGNOM = Cursor_wutrxchk_checked.GetString("TRXCOGNOM");
        mcTransazioni.row.TRXNOME = Cursor_wutrxchk_checked.GetString("TRXNOME");
        mcTransazioni.row.TRXDOMICI = Cursor_wutrxchk_checked.GetString("TRXDOMICI");
        mcTransazioni.row.TRXFLGCF = Cursor_wutrxchk_checked.GetString("TRXFLGCF");
        mcTransazioni.row.TRXCODFIS = Cursor_wutrxchk_checked.GetString("TRXCODFIS");
        mcTransazioni.row.TRXLUONAS = Cursor_wutrxchk_checked.GetString("TRXLUONAS");
        mcTransazioni.row.TRXNUMDOC = Cursor_wutrxchk_checked.GetString("TRXNUMDOC");
        mcTransazioni.row.TRXDATSCA = Cursor_wutrxchk_checked.GetDate("TRXDATSCA");
        mcTransazioni.row.TRXDATRIL = Cursor_wutrxchk_checked.GetDate("TRXDATRIL");
        mcTransazioni.row.TRXAUTRIL = Cursor_wutrxchk_checked.GetString("TRXAUTRIL");
        mcTransazioni.row.TRXNAZRES = Cursor_wutrxchk_checked.GetString("TRXNAZRES");
        mcTransazioni.row.TRXCITRES = Cursor_wutrxchk_checked.GetString("TRXCITRES");
        mcTransazioni.row.TRXTIPDOC = Cursor_wutrxchk_checked.GetString("TRXTIPDOC");
        mcTransazioni.row.TRXDATOPE = Cursor_wutrxchk_checked.GetDate("TRXDATOPE");
        mcTransazioni.row.TRXFLGCON = Cursor_wutrxchk_checked.GetString("TRXFLGCON");
        mcTransazioni.row.TRSSEGNO = Cursor_wutrxchk_checked.GetString("TRSSEGNO");
        mcTransazioni.row.TRXIMPORTO = Cursor_wutrxchk_checked.GetDouble("TRXIMPORTO");
        mcTransazioni.row.TRXCONTAN = Cursor_wutrxchk_checked.GetDouble("TRXCONTAN");
        mcTransazioni.row.TRXUNIQUE = Cursor_wutrxchk_checked.GetString("TRXUNIQUE");
        mcTransazioni.row.TRXCODDIP = Cursor_wutrxchk_checked.GetString("TRXCODDIP");
        mcTransazioni.row.TRXCOGCON = Cursor_wutrxchk_checked.GetString("TRXCOGCON");
        mcTransazioni.row.TRXNOMCON = Cursor_wutrxchk_checked.GetString("TRXNOMCON");
        mcTransazioni.row.TRXDESTIN = Cursor_wutrxchk_checked.GetString("TRXDESTIN");
        mcTransazioni.row.TRXMTCN = Cursor_wutrxchk_checked.GetString("TRXMTCN");
        mcTransazioni.row.TRXDATNAS = Cursor_wutrxchk_checked.GetDate("TRXDATNAS");
        mcTransazioni.row.TRXSESSO = Cursor_wutrxchk_checked.GetString("TRXSESSO");
        mcTransazioni.row.TRXCODCAS = Cursor_wutrxchk_checked.GetString("TRXCODCAS");
        mcTransazioni.row.TRXRECTYPE = Cursor_wutrxchk_checked.GetString("TRXRECTYPE");
        mcTransazioni.row.TRXCODMAG = Cursor_wutrxchk_checked.GetString("TRXCODMAG");
        mcTransazioni.row.TRXCODUNI = Cursor_wutrxchk_checked.GetString("TRXCODUNI");
        mcTransazioni.row.TRXERROR01 = Cursor_wutrxchk_checked.GetString("TRXERROR01");
        mcTransazioni.row.TRXERROR02 = Cursor_wutrxchk_checked.GetString("TRXERROR02");
        mcTransazioni.row.TRXERROR03 = Cursor_wutrxchk_checked.GetString("TRXERROR03");
        mcTransazioni.row.TRXERROR04 = Cursor_wutrxchk_checked.GetString("TRXERROR04");
        mcTransazioni.row.TRXERROR05 = Cursor_wutrxchk_checked.GetString("TRXERROR05");
        mcTransazioni.row.TRXERROR06 = Cursor_wutrxchk_checked.GetString("TRXERROR06");
        mcTransazioni.row.TRXERROR07 = Cursor_wutrxchk_checked.GetString("TRXERROR07");
        mcTransazioni.row.TRXERROR08 = Cursor_wutrxchk_checked.GetString("TRXERROR08");
        mcTransazioni.row.TRXERROR09 = Cursor_wutrxchk_checked.GetString("TRXERROR09");
        mcTransazioni.row.TRXERROR10 = Cursor_wutrxchk_checked.GetString("TRXERROR10");
        mcTransazioni.row.TRXERROR11 = Cursor_wutrxchk_checked.GetString("TRXERROR11");
        mcTransazioni.row.TRXERROR12 = Cursor_wutrxchk_checked.GetString("TRXERROR12");
        mcTransazioni.row.TRXERROR13 = Cursor_wutrxchk_checked.GetString("TRXERROR13");
        mcTransazioni.row.TRXERROR14 = Cursor_wutrxchk_checked.GetString("TRXERROR14");
        mcTransazioni.row.TRXERROR15 = Cursor_wutrxchk_checked.GetString("TRXERROR15");
        mcTransazioni.row.TRXERROR16 = Cursor_wutrxchk_checked.GetString("TRXERROR16");
        mcTransazioni.row.TRXERROR17 = Cursor_wutrxchk_checked.GetString("TRXERROR17");
        mcTransazioni.row.TRXERROR18 = Cursor_wutrxchk_checked.GetString("TRXERROR18");
        mcTransazioni.row.TRXERROR19 = Cursor_wutrxchk_checked.GetString("TRXERROR19");
        mcTransazioni.row.TRXERROR20 = Cursor_wutrxchk_checked.GetString("TRXERROR20");
        mcTransazioni.row.TRXERROR21 = Cursor_wutrxchk_checked.GetString("TRXERROR21");
        mcTransazioni.row.TRXERROR22 = Cursor_wutrxchk_checked.GetString("TRXERROR22");
        mcTransazioni.row.TRXERROR23 = Cursor_wutrxchk_checked.GetString("TRXERROR23");
        mcTransazioni.row.TRXERROR24 = Cursor_wutrxchk_checked.GetString("TRXERROR24");
        mcTransazioni.row.TRXERROR25 = Cursor_wutrxchk_checked.GetString("TRXERROR25");
        mcTransazioni.row.TRXERROR26 = Cursor_wutrxchk_checked.GetString("TRXERROR26");
        mcTransazioni.row.TRXERROR27 = Cursor_wutrxchk_checked.GetString("TRXERROR27");
        mcTransazioni.row.TRXERROR28 = Cursor_wutrxchk_checked.GetString("TRXERROR28");
        mcTransazioni.row.TRXERROR29 = Cursor_wutrxchk_checked.GetString("TRXERROR29");
        mcTransazioni.row.TRXERROR30 = Cursor_wutrxchk_checked.GetString("TRXERROR30");
        mcTransazioni.row.TRXERROR31 = Cursor_wutrxchk_checked.GetString("TRXERROR31");
        mcTransazioni.row.TRXERROR32 = Cursor_wutrxchk_checked.GetString("TRXERROR32");
        mcTransazioni.row.TRXERROR33 = Cursor_wutrxchk_checked.GetString("TRXERROR33");
        mcTransazioni.row.TRXERROR34 = Cursor_wutrxchk_checked.GetString("TRXERROR34");
        mcTransazioni.row.TRXERROR35 = Cursor_wutrxchk_checked.GetString("TRXERROR35");
        mcTransazioni.row.TRXERROR36 = Cursor_wutrxchk_checked.GetString("TRXERROR36");
        mcTransazioni.row.TRXERROR37 = Cursor_wutrxchk_checked.GetString("TRXERROR37");
        mcTransazioni.row.TRXERROR38 = Cursor_wutrxchk_checked.GetString("TRXERROR38");
        mcTransazioni.row.TRXERROR39 = Cursor_wutrxchk_checked.GetString("TRXERROR39");
        mcTransazioni.row.TRXERROR40 = Cursor_wutrxchk_checked.GetString("TRXERROR40");
        mcTransazioni.row.TRXERROR41 = Cursor_wutrxchk_checked.GetString("TRXERROR41");
        mcTransazioni.row.TRXERROR42 = Cursor_wutrxchk_checked.GetString("TRXERROR42");
        mcTransazioni.row.TRXERROR43 = Cursor_wutrxchk_checked.GetString("TRXERROR43");
        mcTransazioni.row.TRXERROR44 = Cursor_wutrxchk_checked.GetString("TRXERROR44");
        mcTransazioni.row.TRXERROR45 = Cursor_wutrxchk_checked.GetString("TRXERROR45");
        mcTransazioni.row.TRXERROR46 = Cursor_wutrxchk_checked.GetString("TRXERROR46");
        mcTransazioni.row.TRXERROR47 = Cursor_wutrxchk_checked.GetString("TRXERROR47");
        mcTransazioni.row.TRXERROR48 = Cursor_wutrxchk_checked.GetString("TRXERROR48");
        mcTransazioni.row.TRXERROR49 = Cursor_wutrxchk_checked.GetString("TRXERROR49");
        mcTransazioni.row.TRXERROR50 = Cursor_wutrxchk_checked.GetString("TRXERROR50");
        mcTransazioni.row.TRXERRAUA01 = Cursor_wutrxchk_checked.GetString("TRXERRAUA01");
        mcTransazioni.row.TRXERRAUA02 = Cursor_wutrxchk_checked.GetString("TRXERRAUA02");
        mcTransazioni.row.TRXERRAUA03 = Cursor_wutrxchk_checked.GetString("TRXERRAUA03");
        mcTransazioni.row.TRXERRAUA04 = Cursor_wutrxchk_checked.GetString("TRXERRAUA04");
        mcTransazioni.row.TRXERRAUA05 = Cursor_wutrxchk_checked.GetString("TRXERRAUA05");
        mcTransazioni.row.TRXERRAUA06 = Cursor_wutrxchk_checked.GetString("TRXERRAUA06");
        mcTransazioni.row.TRXERRAUA07 = Cursor_wutrxchk_checked.GetString("TRXERRAUA07");
        mcTransazioni.row.TRXERRAUA08 = Cursor_wutrxchk_checked.GetString("TRXERRAUA08");
        mcTransazioni.row.TRXERRAUA09 = Cursor_wutrxchk_checked.GetString("TRXERRAUA09");
        mcTransazioni.row.TRXERRAUA10 = Cursor_wutrxchk_checked.GetString("TRXERRAUA10");
        mcTransazioni.row.TRXFLGAUI = Cursor_wutrxchk_checked.GetString("TRXFLGAUI");
        mcTransazioni.row.TRXFLGAUA = Cursor_wutrxchk_checked.GetString("TRXFLGAUA");
        mcTransazioni.row.TRXFLGFOR = Cursor_wutrxchk_checked.GetString("TRXFLGFOR");
        mcTransazioni.row.TRXAUICHK = Cursor_wutrxchk_checked.GetString("TRXAUICHK");
        mcTransazioni.row.TRXAUACHK = Cursor_wutrxchk_checked.GetString("TRXAUACHK");
        mcTransazioni.row.TRXNOTEOPER = Cursor_wutrxchk_checked.GetString("TRXNOTEOPER");
        mcTransazioni.row.TRXFORCE = Cursor_wutrxchk_checked.GetString("TRXFORCE");
        mcTransazioni.row.TRXNASSTATO = Cursor_wutrxchk_checked.GetString("TRXNASSTATO");
        mcTransazioni.row.TRXNASCOMUN = Cursor_wutrxchk_checked.GetString("TRXNASCOMUN");
        mcTransazioni.row.TRXFLGAUAQ1 = Cursor_wutrxchk_checked.GetString("TRXFLGAUAQ1");
        mcTransazioni.row.TRXFLGAUAQ2 = Cursor_wutrxchk_checked.GetString("TRXFLGAUAQ2");
        mcTransazioni.row.TRXFLGAUAQ3 = Cursor_wutrxchk_checked.GetString("TRXFLGAUAQ3");
        mcTransazioni.row.TRXFLGAUAQ4 = Cursor_wutrxchk_checked.GetString("TRXFLGAUAQ4");
        mcTransazioni.row.TRXFLGAUAQ5 = Cursor_wutrxchk_checked.GetString("TRXFLGAUAQ5");
        mcTransazioni.row.TRXDATRICERCA = Cursor_wutrxchk_checked.GetDate("TRXDATRICERCA");
        mcTransazioni.row.TRXUTENTE = Cursor_wutrxchk_checked.GetDouble("TRXUTENTE");
        mcTransazioni.row.TRXTINILAV = Cursor_wutrxchk_checked.GetDateTime("TRXTINILAV");
        mcTransazioni.row.TRXTFINLAV = Cursor_wutrxchk_checked.GetDateTime("TRXTFINLAV");
        mcTransazioni.row.TRXDINILAV = Cursor_wutrxchk_checked.GetDate("TRXDINILAV");
        mcTransazioni.row.TRDFINLAV = Cursor_wutrxchk_checked.GetDate("TRDFINLAV");
        mcTransazioni.row.TRFLGINLAV = Cursor_wutrxchk_checked.GetString("TRFLGINLAV");
        mcTransazioni.row.TRXNUMRIL = Cursor_wutrxchk_checked.GetDouble("TRXNUMRIL");
        mcTransazioni.row.TRXSCAEDT = Cursor_wutrxchk_checked.GetDate("TRXSCAEDT");
        mcTransazioni.row.TRXESITO = Cursor_wutrxchk_checked.GetString("TRXESITO");
        mcTransazioni.row.TRXDERIVATA = Cursor_wutrxchk_checked.GetString("TRXDERIVATA");
        mcTransazioni.row.TRXGALACTIC = Cursor_wutrxchk_checked.GetString("TRXGALACTIC");
        mcTransazioni.row.TRXNAZRIL = Cursor_wutrxchk_checked.GetString("TRXNAZRIL");
        Cursor_wutrxchk_checked.Next();
      }
      m_cConnectivityError = Cursor_wutrxchk_checked.ErrorMessage();
      Cursor_wutrxchk_checked.Close();
      mcTransazioni.GoTop();
      for (MemoryCursorRow_wutrxchk_checked rowTransazioni : mcTransazioni._iterable_()) {
        /* mcErrate.AppendBlank() */
        mcErrate.AppendBlank();
        /* mcErrate.colonna01 := rowTransazioni.TRXCOGNOM */
        mcErrate.row.colonna01 = rowTransazioni.TRXCOGNOM;
        /* mcErrate.colonna02 := rowTransazioni.TRXNOME */
        mcErrate.row.colonna02 = rowTransazioni.TRXNOME;
        /* mcErrate.colonna03 := rowTransazioni.TRXDOMICI */
        mcErrate.row.colonna03 = rowTransazioni.TRXDOMICI;
        /* mcErrate.colonna04 := rowTransazioni.TRXFLGCF */
        mcErrate.row.colonna04 = rowTransazioni.TRXFLGCF;
        /* mcErrate.colonna05 := rowTransazioni.TRXCODFIS */
        mcErrate.row.colonna05 = rowTransazioni.TRXCODFIS;
        /* mcErrate.colonna06 := rowTransazioni.TRXLUONAS */
        mcErrate.row.colonna06 = rowTransazioni.TRXLUONAS;
        /* mcErrate.colonna07 := rowTransazioni.TRXNUMDOC */
        mcErrate.row.colonna07 = rowTransazioni.TRXNUMDOC;
        /* mcErrate.colonna08 := DateToChar(rowTransazioni.TRXDATSCA) */
        mcErrate.row.colonna08 = CPLib.DateToChar(rowTransazioni.TRXDATSCA);
        /* mcErrate.colonna09 := DateToChar(rowTransazioni.TRXDATRIL) */
        mcErrate.row.colonna09 = CPLib.DateToChar(rowTransazioni.TRXDATRIL);
        /* mcErrate.colonna10 := rowTransazioni.TRXAUTRIL */
        mcErrate.row.colonna10 = rowTransazioni.TRXAUTRIL;
        /* mcErrate.colonna11 := rowTransazioni.TRXNAZRES */
        mcErrate.row.colonna11 = rowTransazioni.TRXNAZRES;
        /* mcErrate.colonna12 := rowTransazioni.TRXCITRES */
        mcErrate.row.colonna12 = rowTransazioni.TRXCITRES;
        /* mcErrate.colonna13 := rowTransazioni.TRXTIPDOC */
        mcErrate.row.colonna13 = rowTransazioni.TRXTIPDOC;
        /* mcErrate.colonna14 := DateToChar(rowTransazioni.TRXDATOPE) */
        mcErrate.row.colonna14 = CPLib.DateToChar(rowTransazioni.TRXDATOPE);
        /* mcErrate.colonna15 := rowTransazioni.TRXFLGCON */
        mcErrate.row.colonna15 = rowTransazioni.TRXFLGCON;
        /* mcErrate.colonna16 := rowTransazioni.TRSSEGNO */
        mcErrate.row.colonna16 = rowTransazioni.TRSSEGNO;
        /* mcErrate.colonna17 := LRTrim(Str(rowTransazioni.TRXIMPORTO,12,2)) */
        mcErrate.row.colonna17 = CPLib.LRTrim(CPLib.Str(rowTransazioni.TRXIMPORTO,12,2));
        /* mcErrate.colonna18 := LRTrim(Str(rowTransazioni.TRXCONTAN,12,2)) */
        mcErrate.row.colonna18 = CPLib.LRTrim(CPLib.Str(rowTransazioni.TRXCONTAN,12,2));
        /* mcErrate.colonna19 := rowTransazioni.TRXUNIQUE */
        mcErrate.row.colonna19 = rowTransazioni.TRXUNIQUE;
        /* mcErrate.colonna20 := rowTransazioni.TRXCODDIP */
        mcErrate.row.colonna20 = rowTransazioni.TRXCODDIP;
        /* mcErrate.colonna21 := rowTransazioni.TRXCOGCON */
        mcErrate.row.colonna21 = rowTransazioni.TRXCOGCON;
        /* mcErrate.colonna22 := rowTransazioni.TRXNOMCON */
        mcErrate.row.colonna22 = rowTransazioni.TRXNOMCON;
        /* mcErrate.colonna23 := rowTransazioni.TRXDESTIN */
        mcErrate.row.colonna23 = rowTransazioni.TRXDESTIN;
        /* mcErrate.colonna24 := rowTransazioni.TRXMTCN */
        mcErrate.row.colonna24 = rowTransazioni.TRXMTCN;
        /* mcErrate.colonna25 := DateToChar(rowTransazioni.TRXDATNAS) */
        mcErrate.row.colonna25 = CPLib.DateToChar(rowTransazioni.TRXDATNAS);
        /* mcErrate.colonna26 := rowTransazioni.TRXSESSO */
        mcErrate.row.colonna26 = rowTransazioni.TRXSESSO;
        /* mcErrate.colonna27 := rowTransazioni.TRXCODCAS */
        mcErrate.row.colonna27 = rowTransazioni.TRXCODCAS;
        /* mcErrate.colonna28 := rowTransazioni.TRXRECTYPE */
        mcErrate.row.colonna28 = rowTransazioni.TRXRECTYPE;
        /* mcErrate.colonna29 := rowTransazioni.TRXCODMAG */
        mcErrate.row.colonna29 = rowTransazioni.TRXCODMAG;
        /* mcErrate.colonna30 := rowTransazioni.TRXCODUNI */
        mcErrate.row.colonna30 = rowTransazioni.TRXCODUNI;
        /* mcErrate.colonna31 := rowTransazioni.TRXNAZRIL */
        mcErrate.row.colonna31 = rowTransazioni.TRXNAZRIL;
        /* mcErrate.colonna32 := rowTransazioni.TRXGALACTIC */
        mcErrate.row.colonna32 = rowTransazioni.TRXGALACTIC;
        /* mcErrate.colonna33 := '' */
        mcErrate.row.colonna33 = "";
        /* mcErrate.colonna34 := '' */
        mcErrate.row.colonna34 = "";
        /* mcErrate.colonna35 := '' */
        mcErrate.row.colonna35 = "";
        /* mcErrate.colonna36 := '' */
        mcErrate.row.colonna36 = "";
        /* mcErrate.colonna37 := '' */
        mcErrate.row.colonna37 = "";
        /* mcErrate.colonna38 := '' */
        mcErrate.row.colonna38 = "";
        /* mcErrate.colonna39 := '' */
        mcErrate.row.colonna39 = "";
        /* mcErrate.colonna40 := '' */
        mcErrate.row.colonna40 = "";
        /* mcErrate.colonna41 := '' */
        mcErrate.row.colonna41 = "";
        /* mcErrate.colonna42 := '' */
        mcErrate.row.colonna42 = "";
        /* mcErrate.colonna43 := '' */
        mcErrate.row.colonna43 = "";
        /* mcErrate.colonna44 := '' */
        mcErrate.row.colonna44 = "";
        /* mcErrate.colonna45 := '' */
        mcErrate.row.colonna45 = "";
        /* mcErrate.colonna46 := '' */
        mcErrate.row.colonna46 = "";
        /* mcErrate.colonna47 := '' */
        mcErrate.row.colonna47 = "";
        /* mcErrate.colonna48 := '' */
        mcErrate.row.colonna48 = "";
        /* mcErrate.colonna49 := '' */
        mcErrate.row.colonna49 = "";
        /* mcErrate.colonna50 := '' */
        mcErrate.row.colonna50 = "";
        /* mcErrate.colonna51 := '' */
        mcErrate.row.colonna51 = "";
        /* mcErrate.colonna52 := '' */
        mcErrate.row.colonna52 = "";
        /* mcErrate.colonna53 := '' */
        mcErrate.row.colonna53 = "";
        /* mcErrate.colonna54 := '' */
        mcErrate.row.colonna54 = "";
        /* mcErrate.colonna55 := '' */
        mcErrate.row.colonna55 = "";
        /* mcErrate.colonna56 := '' */
        mcErrate.row.colonna56 = "";
        /* mcErrate.colonna57 := '' */
        mcErrate.row.colonna57 = "";
        /* mcErrate.colonna58 := '' */
        mcErrate.row.colonna58 = "";
        /* mcErrate.colonna59 := '' */
        mcErrate.row.colonna59 = "";
        /* mcErrate.colonna60 := '' */
        mcErrate.row.colonna60 = "";
        /* mcErrate.colonna61 := '' */
        mcErrate.row.colonna61 = "";
        /* mcErrate.colonna62 := '' */
        mcErrate.row.colonna62 = "";
        /* mcErrate.colonna63 := '' */
        mcErrate.row.colonna63 = "";
        /* mcErrate.colonna64 := '' */
        mcErrate.row.colonna64 = "";
        /* mcErrate.colonna65 := '' */
        mcErrate.row.colonna65 = "";
        /* mcErrate.colonna66 := '' */
        mcErrate.row.colonna66 = "";
        /* mcErrate.colonna67 := '' */
        mcErrate.row.colonna67 = "";
        /* mcErrate.colonna68 := '' */
        mcErrate.row.colonna68 = "";
        /* mcErrate.colonna69 := '' */
        mcErrate.row.colonna69 = "";
        /* mcErrate.colonna70 := '' */
        mcErrate.row.colonna70 = "";
        /* mcErrate.colonna71 := '' */
        mcErrate.row.colonna71 = "";
        /* mcErrate.colonna72 := '' */
        mcErrate.row.colonna72 = "";
        /* mcErrate.colonna73 := '' */
        mcErrate.row.colonna73 = "";
        /* mcErrate.colonna74 := Str(rowTransazioni.TRXCODPRG,15,0) */
        mcErrate.row.colonna74 = CPLib.Str(rowTransazioni.TRXCODPRG,15,0);
        /* mcErrate.colonna75 := "" */
        mcErrate.row.colonna75 = "";
        /* mcErrate.colonna76 := "" */
        mcErrate.row.colonna76 = "";
        /* mcErrate.colonna77 := rowTransazioni.TRXESITO */
        mcErrate.row.colonna77 = rowTransazioni.TRXESITO;
        /* mcErrate.SaveRow() */
        mcErrate.SaveRow();
      }
      /* Exec "Scrittura file excel" Page 2:Page_XLS */
      Page_XLS();
      /* Exec Routine arrt_imp_dati_rtra(_tipimp,'N','N','X','I','N','N','N') */
      arrt_imp_dati_rtraR.Make(m_Ctx,this).Run(_tipimp,"N","N","X","I","N","N","N");
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wutrxchk_checked!=null)
          Cursor_wutrxchk_checked.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_XLS() throws Exception {
    /* Formato Excel */
    /* _nfile := LRTrim(_gPathDoc)+"/appo/"+LRTrim(_gAzienda)+"/"+LRTrim(_filen) */
    _nfile = CPLib.LRTrim(_gPathDoc)+"/appo/"+CPLib.LRTrim(_gAzienda)+"/"+CPLib.LRTrim(_filen);
    /* Seleziona i record */
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
    cell =  row.createCell(0);
    cell.setCellValue("COGNOME");
    cell.setCellStyle(cs);
    cell = row.createCell(1);
    cell.setCellValue("NOME");
    cell.setCellStyle(cs);
    cell = row.createCell(2);
    cell.setCellValue("INDIRIZZO");
    cell.setCellStyle(cs);
    cell =  row.createCell(3);
    cell.setCellValue("FLAG CODICE FISCALE");
    cell.setCellStyle(cs);
    cell =  row.createCell(4);
    cell.setCellValue("CODICE FISCALE");
    cell.setCellStyle(cs);
    cell =  row.createCell(5);
    cell.setCellValue("LUOGO DI NASCITA");
    cell.setCellStyle(cs);
    cell =  row.createCell(6);
    cell.setCellValue("NUM. DOCUMENTO");
    cell.setCellStyle(cs);
    cell =  row.createCell(7);
    cell.setCellValue("DATA SCADENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(8);
    cell.setCellValue("DATA RILASCIO");
    cell.setCellStyle(cs);
    cell = row.createCell(9);
    cell.setCellValue("AUTORITA' RILASCIO");
    cell.setCellStyle(cs);
    cell = row.createCell(10);
    cell.setCellValue("PAESE RESIDENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(11);
    cell.setCellValue("CITTA' DI RESIDENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(12);
    cell.setCellValue("TIPO DOCUMENTO");
    cell.setCellStyle(cs);
    cell = row.createCell(13);
    cell.setCellValue("DATA OPERAZIONE");
    cell.setCellStyle(cs);
    cell = row.createCell(14);
    cell.setCellValue("FLAG CONTANTI");
    cell.setCellStyle(cs);
    cell = row.createCell(15);
    cell.setCellValue("TIPO TRANSAZIONE");
    cell.setCellStyle(cs);
    cell = row.createCell(16);
    cell.setCellValue("IMPORTO TRX");
    cell.setCellStyle(cs);
    cell = row.createCell(17);
    cell.setCellValue("CONTANTI TRX");
    cell.setCellStyle(cs);
    cell = row.createCell(18);
    cell.setCellValue("UNIQUE ID TRX");
    cell.setCellStyle(cs);
    cell = row.createCell(19);
    cell.setCellValue("CODICE AGENZIA");
    cell.setCellStyle(cs);
    cell = row.createCell(20);
    cell.setCellValue("COGNOME CONTROPARTE");
    cell.setCellStyle(cs);
    cell = row.createCell(21);
    cell.setCellValue("NOME CONTROPARTE");
    cell.setCellStyle(cs);
    cell = row.createCell(22);
    cell.setCellValue("STATO CONTROPARTE");
    cell.setCellStyle(cs);
    cell = row.createCell(23);
    cell.setCellValue("MTCN");
    cell.setCellStyle(cs);
    cell = row.createCell(24);
    cell.setCellValue("DATA DI NASCITA");
    cell.setCellStyle(cs);
    cell = row.createCell(25);
    cell.setCellValue("SESSO");
    cell.setCellStyle(cs);
    cell = row.createCell(26);
    cell.setCellValue("CODICE CATASTALE");
    cell.setCellStyle(cs);
    cell = row.createCell(27);
    cell.setCellValue("TIPO OPERAZIONE");
    cell.setCellStyle(cs);
    cell = row.createCell(28);
    cell.setCellValue("MACROAGENTE");
    cell.setCellStyle(cs);
    cell = row.createCell(29);
    cell.setCellValue("CODICE UNIVOCO");
    cell.setCellStyle(cs);
    cell = row.createCell(30);
    cell.setCellValue("NAZIONE RILASCIO DOCUMENTO");
    cell.setCellStyle(cs);
    cell = row.createCell(31);
    cell.setCellValue("GALACTIC ID");
    cell.setCellStyle(cs);
    cell = row.createCell(32);
    cell.setCellValue("ERRORE 1");
    cell.setCellStyle(cs);
    cell = row.createCell(33);
    cell.setCellValue("ERRORE 2");
    cell.setCellStyle(cs);
    cell = row.createCell(34);
    cell.setCellValue("ERRORE 3");
    cell.setCellStyle(cs);
    cell = row.createCell(35);
    cell.setCellValue("ERRORE 4");
    cell.setCellStyle(cs);
    cell = row.createCell(36);
    cell.setCellValue("ERRORE 5");
    cell.setCellStyle(cs);
    cell = row.createCell(37);
    cell.setCellValue("ERRORE 6");
    cell.setCellStyle(cs);
    cell = row.createCell(38);
    cell.setCellValue("ERRORE 7");
    cell.setCellStyle(cs);
    cell = row.createCell(39);
    cell.setCellValue("ERRORE 8");
    cell.setCellStyle(cs);
    cell = row.createCell(40);
    cell.setCellValue("ERRORE 9");
    cell.setCellStyle(cs);
    cell = row.createCell(41);
    cell.setCellValue("ERRORE 10");
    cell.setCellStyle(cs);
    cell = row.createCell(42);
    cell.setCellValue("ERRORE 11");
    cell.setCellStyle(cs);
    cell = row.createCell(43);
    cell.setCellValue("ERRORE 12");
    cell.setCellStyle(cs);
    cell = row.createCell(44);
    cell.setCellValue("ERRORE 13");
    cell.setCellStyle(cs);
    cell = row.createCell(45);
    cell.setCellValue("ERRORE 14");
    cell.setCellStyle(cs);
    cell = row.createCell(46);
    cell.setCellValue("ERRORE 15");
    cell.setCellStyle(cs);
    cell = row.createCell(47);
    cell.setCellValue("ERRORE 16");
    cell.setCellStyle(cs);
    cell = row.createCell(48);
    cell.setCellValue("ERRORE 17");
    cell.setCellStyle(cs);
    cell = row.createCell(49);
    cell.setCellValue("ERRORE 18");
    cell.setCellStyle(cs);
    cell = row.createCell(50);
    cell.setCellValue("ERRORE 19");
    cell.setCellStyle(cs);
    cell = row.createCell(51);
    cell.setCellValue("ERRORE 20");
    cell.setCellStyle(cs);
    cell = row.createCell(52);
    cell.setCellValue("ERRORE 21");
    cell.setCellStyle(cs);
    cell = row.createCell(53);
    cell.setCellValue("ERRORE 22");
    cell.setCellStyle(cs);
    cell = row.createCell(54);
    cell.setCellValue("ERRORE 23");
    cell.setCellStyle(cs);
    cell = row.createCell(55);
    cell.setCellValue("ERRORE 24");
    cell.setCellStyle(cs);
    cell = row.createCell(56);
    cell.setCellValue("ERRORE 25");
    cell.setCellStyle(cs);
    cell = row.createCell(57);
    cell.setCellValue("ERRORE 26");
    cell.setCellStyle(cs);
    cell = row.createCell(58);
    cell.setCellValue("ERRORE 27");
    cell.setCellStyle(cs);
    cell = row.createCell(59);
    cell.setCellValue("ERRORE 28");
    cell.setCellStyle(cs);
    cell = row.createCell(60);
    cell.setCellValue("ERRORE 29");
    cell.setCellStyle(cs);
    cell = row.createCell(61);
    cell.setCellValue("ERRORE 30");
    cell.setCellStyle(cs);
    cell = row.createCell(62);
    cell.setCellValue("ERRORE 31");
    cell.setCellStyle(cs);
    cell = row.createCell(63);
    cell.setCellValue("ERRORE 32");
    cell.setCellStyle(cs);
    cell = row.createCell(64);
    cell.setCellValue("ERRORE 33");
    cell.setCellStyle(cs);
    cell = row.createCell(65);
    cell.setCellValue("ERRORE 34");
    cell.setCellStyle(cs);
    cell = row.createCell(66);
    cell.setCellValue("ERRORE 35");
    cell.setCellStyle(cs);
    cell = row.createCell(67);
    cell.setCellValue("ERRORE 36");
    cell.setCellStyle(cs);
    cell = row.createCell(68);
    cell.setCellValue("ERRORE 37");
    cell.setCellStyle(cs);
    cell = row.createCell(69);
    cell.setCellValue("ERRORE 38");
    cell.setCellStyle(cs);
    cell = row.createCell(70);
    cell.setCellValue("ERRORE 39");
    cell.setCellStyle(cs);
    cell = row.createCell(71);
    cell.setCellValue("ERRORE 40");
    cell.setCellStyle(cs);
    cell = row.createCell(72);
    cell.setCellValue("ERRORE 41");
    cell.setCellStyle(cs);
    cell = row.createCell(73);
    cell.setCellValue("RIF. AUA");
    cell.setCellStyle(cs);
    cell = row.createCell(74);
    cell.setCellValue("OPERAZIONE CORRETTA");
    cell.setCellStyle(cs);
    cell = row.createCell(75);
    cell.setCellValue("FORZA SCRITTURA");
    cell.setCellStyle(cs);
    cell = row.createCell(76);
    cell.setCellValue("ESITO AUA");
    cell.setCellStyle(cs);
    r++;
    for (MemoryCursorRow_mcerratedef_mcrdef rowErrate : mcErrate._iterable_()) {
      // Scrive la riga
      row = sheet.createRow(r);
      cell = row.createCell(0);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna01));
      cell = row.createCell(1);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna02));
      cell = row.createCell(2);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna03));
      cell = row.createCell(3);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna04));
      cell = row.createCell(4);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna05));
      cell = row.createCell(5);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna06));
      cell = row.createCell(6);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna07));
      cell = row.createCell(7);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna08));
      cell = row.createCell(8);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna09));
      cell = row.createCell(9);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna10));
      cell = row.createCell(10);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna11));
      cell = row.createCell(11);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna12));
      cell = row.createCell(12);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna13));
      cell = row.createCell(13);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna14));
      cell = row.createCell(14);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna15));
      cell = row.createCell(15);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna16));
      cell = row.createCell(16);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna17));
      cell = row.createCell(17);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna18));
      cell = row.createCell(18);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna19));
      cell = row.createCell(19);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna20));
      cell = row.createCell(20);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna21));
      cell = row.createCell(21);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna22));
      cell = row.createCell(22);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna23));
      cell = row.createCell(23);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna24));
      cell = row.createCell(24);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna25));
      cell = row.createCell(25);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna26));
      cell = row.createCell(26);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna27));
      cell = row.createCell(27);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna28));
      cell = row.createCell(28);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna29));
      cell = row.createCell(29);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna30));
      cell = row.createCell(30);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna31));
      cell = row.createCell(31);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna32));
      cell = row.createCell(32);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna33));
      cell = row.createCell(33);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna34));
      cell = row.createCell(34);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna35));
      cell = row.createCell(35);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna36));
      cell = row.createCell(36);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna37));
      cell = row.createCell(37);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna38));
      cell = row.createCell(38);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna39));
      cell = row.createCell(39);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna40));
      cell = row.createCell(40);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna41));
      cell = row.createCell(41);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna42));
      cell = row.createCell(42);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna43));
      cell = row.createCell(43);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna44));
      cell = row.createCell(44);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna45));
      cell = row.createCell(45);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna46));
      cell = row.createCell(46);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna47));
      cell = row.createCell(47);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna48));
      cell = row.createCell(48);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna49));
      cell = row.createCell(49);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna50));
      cell = row.createCell(50);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna51));
      cell = row.createCell(51);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna52));
      cell = row.createCell(52);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna53));
      cell = row.createCell(53);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna54));
      cell = row.createCell(54);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna55));
      cell = row.createCell(55);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna56));
      cell = row.createCell(56);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna57));
      cell = row.createCell(57);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna58));
      cell = row.createCell(58);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna59));
      cell = row.createCell(59);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna60));
      cell = row.createCell(60);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna61));
      cell = row.createCell(61);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna62));
      cell = row.createCell(62);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna63));
      cell = row.createCell(63);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna64));
      cell = row.createCell(64);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna65));
      cell = row.createCell(65);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna66));
      cell = row.createCell(66);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna67));
      cell = row.createCell(67);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna68));
      cell = row.createCell(68);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna69));
      cell = row.createCell(69);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna70));
      cell = row.createCell(70);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna71));
      cell = row.createCell(71);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna72));
      cell = row.createCell(72);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna73));
      cell = row.createCell(73);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna74));
      cell = row.createCell(74);
      cell.setCellValue(CPLib.LRTrim("S"));
      cell = row.createCell(75);
      cell.setCellValue(CPLib.LRTrim("S"));
      cell = row.createCell(76);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna77));
      r++;
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
    sheet.autoSizeColumn(25);
    sheet.autoSizeColumn(26);
    sheet.autoSizeColumn(27);
    sheet.autoSizeColumn(28);
    sheet.autoSizeColumn(29);
    sheet.autoSizeColumn(30);
    sheet.autoSizeColumn(31);
    sheet.autoSizeColumn(32);
    sheet.autoSizeColumn(33);
    sheet.autoSizeColumn(34);
    sheet.autoSizeColumn(35);
    sheet.autoSizeColumn(36);
    sheet.autoSizeColumn(37);
    sheet.autoSizeColumn(38);
    sheet.autoSizeColumn(39);
    sheet.autoSizeColumn(40);
    sheet.autoSizeColumn(41);
    sheet.autoSizeColumn(42);
    sheet.autoSizeColumn(43);
    sheet.autoSizeColumn(44);
    sheet.autoSizeColumn(45);
    sheet.autoSizeColumn(46);
    sheet.autoSizeColumn(47);
    sheet.autoSizeColumn(48);
    sheet.autoSizeColumn(49);
    sheet.autoSizeColumn(50);
    sheet.autoSizeColumn(51);
    sheet.autoSizeColumn(52);
    sheet.autoSizeColumn(53);
    sheet.autoSizeColumn(54);
    sheet.autoSizeColumn(55);
    sheet.autoSizeColumn(56);
    sheet.autoSizeColumn(57);
    sheet.autoSizeColumn(58);
    sheet.autoSizeColumn(59);
    sheet.autoSizeColumn(60);
    sheet.autoSizeColumn(61);
    sheet.autoSizeColumn(62);
    sheet.autoSizeColumn(63);
    sheet.autoSizeColumn(64);
    sheet.autoSizeColumn(65);
    sheet.autoSizeColumn(66);
    sheet.autoSizeColumn(67);
    sheet.autoSizeColumn(68);
    sheet.autoSizeColumn(69);
    sheet.autoSizeColumn(70);
    sheet.autoSizeColumn(71);
    sheet.autoSizeColumn(72);
    sheet.autoSizeColumn(73);
    sheet.autoSizeColumn(74);
    sheet.autoSizeColumn(75);
    sheet.autoSizeColumn(76);
    // scrivo il file di esito
    FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(_nfile));
    //write this workbook to an Outputstream.
    wb.write(fileOut);
    fileOut.flush();
    fileOut.close();
  }
  void _init_() {
  }
  public String RunAsync() {
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
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
          Page_Main();
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_wutrxchk_save_schedR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_wutrxchk_save_schedR(p_Ctx, p_Caller);
  }
  public void Blank() {
    _gAzienda = CPLib.Space(10);
    _gPathApp = CPLib.Space(80);
    _gPathDoc = CPLib.Space(80);
    _filen = CPLib.Space(50);
    mcTransazioni = new MemoryCursor_wutrxchk_checked();
    mcErrate = new MemoryCursor_mcerratedef_mcrdef();
    _nfile = CPLib.Space(100);
    _tipimp = CPLib.Space(1);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arrt_imp_dati_rtra,
  public static final String i_InvokedRoutines = ",arrt_imp_dati_rtra,";
  public static String[] m_cRunParameterNames={};
}
