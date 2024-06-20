// * --- Area Manuale = BO - Header
// * --- arrt_import_sva7
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
public class arrt_import_sva7R implements CallerWithObjs {
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
  public String m_cPhName_xersonbo;
  public String m_cServer_xersonbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_sottovocea7;
  public String m_cServer_sottovocea7;
  public String m_cPhName_tbprovsv;
  public String m_cServer_tbprovsv;
  public String m_cPhName_tb00016;
  public String m_cServer_tb00016;
  public String m_cPhName_tb01217;
  public String m_cServer_tb01217;
  public String m_cPhName_tb02147;
  public String m_cServer_tb02147;
  public String m_cPhName_basea7;
  public String m_cServer_basea7;
  public String m_cPhName_detta7;
  public String m_cServer_detta7;
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
  public String pFile;
  public String pTipo;
  public String gPathApp;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String gPathDoc;
  public String fhand;
  public String _flgresid;
  public String _flg00015;
  public String _flg00016;
  public String _flg01217;
  public String _flg02147;
  public String _flg02148;
  public String _flg02149;
  public double _dato;
  public double _nriga;
  public MemoryCursor_detta7 mcDettaglio;
  public String _anno;
  public String _semestre;
  public String riga;
  public double _rinizio;
  public double riga_letta;
  public double foglio;
  public MemoryCursor_sottovocea7 mcSottovoce;
  public MemoryCursor_tbprovsv mcTB00015;
  public MemoryCursor_qbe_tb00016_vqr mcTB00016;
  public MemoryCursor_tb01217 mcTB01217;
  public MemoryCursor_tb02147 mcTB02147;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_import_sva7
  public int _i;
  public int _y;
  public int _righe;
  public int conta;
  public int _conta;
  public int r;
  public int cell_count;
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
  public String[] colonna=new String[8];
  // * --- Fine Area Manuale
  public arrt_import_sva7R (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_import_sva7",m_Caller);
    m_cPhName_xersonbo = p_ContextObject.GetPhName("xersonbo");
    if (m_cPhName_xersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xersonbo = m_cPhName_xersonbo+" "+m_Ctx.GetWritePhName("xersonbo");
    }
    m_cServer_xersonbo = p_ContextObject.GetServer("xersonbo");
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
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_sottovocea7 = p_ContextObject.GetPhName("sottovocea7");
    if (m_cPhName_sottovocea7.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sottovocea7 = m_cPhName_sottovocea7+" "+m_Ctx.GetWritePhName("sottovocea7");
    }
    m_cServer_sottovocea7 = p_ContextObject.GetServer("sottovocea7");
    m_cPhName_tbprovsv = p_ContextObject.GetPhName("tbprovsv");
    if (m_cPhName_tbprovsv.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbprovsv = m_cPhName_tbprovsv+" "+m_Ctx.GetWritePhName("tbprovsv");
    }
    m_cServer_tbprovsv = p_ContextObject.GetServer("tbprovsv");
    m_cPhName_tb00016 = p_ContextObject.GetPhName("tb00016");
    if (m_cPhName_tb00016.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tb00016 = m_cPhName_tb00016+" "+m_Ctx.GetWritePhName("tb00016");
    }
    m_cServer_tb00016 = p_ContextObject.GetServer("tb00016");
    m_cPhName_tb01217 = p_ContextObject.GetPhName("tb01217");
    if (m_cPhName_tb01217.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tb01217 = m_cPhName_tb01217+" "+m_Ctx.GetWritePhName("tb01217");
    }
    m_cServer_tb01217 = p_ContextObject.GetServer("tb01217");
    m_cPhName_tb02147 = p_ContextObject.GetPhName("tb02147");
    if (m_cPhName_tb02147.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tb02147 = m_cPhName_tb02147+" "+m_Ctx.GetWritePhName("tb02147");
    }
    m_cServer_tb02147 = p_ContextObject.GetServer("tb02147");
    m_cPhName_basea7 = p_ContextObject.GetPhName("basea7");
    if (m_cPhName_basea7.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_basea7 = m_cPhName_basea7+" "+m_Ctx.GetWritePhName("basea7");
    }
    m_cServer_basea7 = p_ContextObject.GetServer("basea7");
    m_cPhName_detta7 = p_ContextObject.GetPhName("detta7");
    if (m_cPhName_detta7.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_detta7 = m_cPhName_detta7+" "+m_Ctx.GetWritePhName("detta7");
    }
    m_cServer_detta7 = p_ContextObject.GetServer("detta7");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_dato",p_cVarName)) {
      return _dato;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      return _nriga;
    }
    if (CPLib.eqr("_rinizio",p_cVarName)) {
      return _rinizio;
    }
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      return riga_letta;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      return foglio;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_import_sva7";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pFile",p_cVarName)) {
      return pFile;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_flgresid",p_cVarName)) {
      return _flgresid;
    }
    if (CPLib.eqr("_flg00015",p_cVarName)) {
      return _flg00015;
    }
    if (CPLib.eqr("_flg00016",p_cVarName)) {
      return _flg00016;
    }
    if (CPLib.eqr("_flg01217",p_cVarName)) {
      return _flg01217;
    }
    if (CPLib.eqr("_flg02147",p_cVarName)) {
      return _flg02147;
    }
    if (CPLib.eqr("_flg02148",p_cVarName)) {
      return _flg02148;
    }
    if (CPLib.eqr("_flg02149",p_cVarName)) {
      return _flg02149;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      return _anno;
    }
    if (CPLib.eqr("_semestre",p_cVarName)) {
      return _semestre;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
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
    if (CPLib.eqr("mcDettaglio",p_cVarName)) {
      return mcDettaglio;
    }
    if (CPLib.eqr("mcSottovoce",p_cVarName)) {
      return mcSottovoce;
    }
    if (CPLib.eqr("mcTB00015",p_cVarName)) {
      return mcTB00015;
    }
    if (CPLib.eqr("mcTB00016",p_cVarName)) {
      return mcTB00016;
    }
    if (CPLib.eqr("mcTB01217",p_cVarName)) {
      return mcTB01217;
    }
    if (CPLib.eqr("mcTB02147",p_cVarName)) {
      return mcTB02147;
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
    if (CPLib.eqr("_dato",p_cVarName)) {
      _dato = value;
      return;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      _nriga = value;
      return;
    }
    if (CPLib.eqr("_rinizio",p_cVarName)) {
      _rinizio = value;
      return;
    }
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      riga_letta = value;
      return;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      foglio = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pFile",p_cVarName)) {
      pFile = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
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
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_flgresid",p_cVarName)) {
      _flgresid = value;
      return;
    }
    if (CPLib.eqr("_flg00015",p_cVarName)) {
      _flg00015 = value;
      return;
    }
    if (CPLib.eqr("_flg00016",p_cVarName)) {
      _flg00016 = value;
      return;
    }
    if (CPLib.eqr("_flg01217",p_cVarName)) {
      _flg01217 = value;
      return;
    }
    if (CPLib.eqr("_flg02147",p_cVarName)) {
      _flg02147 = value;
      return;
    }
    if (CPLib.eqr("_flg02148",p_cVarName)) {
      _flg02148 = value;
      return;
    }
    if (CPLib.eqr("_flg02149",p_cVarName)) {
      _flg02149 = value;
      return;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      _anno = value;
      return;
    }
    if (CPLib.eqr("_semestre",p_cVarName)) {
      _semestre = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
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
    if (CPLib.eqr("mcDettaglio",p_cVarName)) {
      mcDettaglio = (MemoryCursor_detta7)value;
      return;
    }
    if (CPLib.eqr("mcSottovoce",p_cVarName)) {
      mcSottovoce = (MemoryCursor_sottovocea7)value;
      return;
    }
    if (CPLib.eqr("mcTB00015",p_cVarName)) {
      mcTB00015 = (MemoryCursor_tbprovsv)value;
      return;
    }
    if (CPLib.eqr("mcTB00016",p_cVarName)) {
      mcTB00016 = (MemoryCursor_qbe_tb00016_vqr)value;
      return;
    }
    if (CPLib.eqr("mcTB01217",p_cVarName)) {
      mcTB01217 = (MemoryCursor_tb01217)value;
      return;
    }
    if (CPLib.eqr("mcTB02147",p_cVarName)) {
      mcTB02147 = (MemoryCursor_tb02147)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_sottovocea7=null;
    CPResultSet Cursor_tbprovsv=null;
    CPResultSet Cursor_qbe_tb00016=null;
    CPResultSet Cursor_tb01217=null;
    CPResultSet Cursor_tb02147=null;
    CPResultSet Cursor_detta7=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pFile Char(0) // nome del file da importare */
      /* pTipo Char(1) // Tipo import */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gPathDoc Char(128) // Path Documenti */
      /* fhand Char(0) := "" // Puntatore al file aperto */
      fhand = "";
      /* _flgresid Char(1) */
      /* _flg00015 Char(1) */
      /* _flg00016 Char(1) */
      /* _flg01217 Char(1) */
      /* _flg02147 Char(1) */
      /* _flg02148 Char(1) */
      /* _flg02149 Char(1) */
      /* _dato Numeric(1, 0) */
      /* _nriga Numeric(4, 0) */
      /* mcDettaglio MemoryCursor(detta7) */
      /* _anno Char(4) */
      /* _semestre Char(1) */
      /* riga Memo := "" */
      riga = "";
      /* _rinizio Numeric(4, 0) */
      /* riga_letta Numeric(9, 0) // riga letta del file Excel */
      /* foglio Numeric(2, 0) // foglio letto */
      /* mcSottovoce MemoryCursor(sottovocea7) */
      /* mcTB00015 MemoryCursor(tbprovsv) */
      /* mcTB00016 MemoryCursor(qbe_tb00016.vqr) */
      /* mcTB01217 MemoryCursor(tb01217) */
      /* mcTB02147 MemoryCursor(tb02147) */
      // * --- Fill memory cursor mcSottovoce on sottovocea7
      mcSottovoce.Zap();
      m_cServer = m_Ctx.GetServer("sottovocea7");
      m_cPhName = m_Ctx.GetPhName("sottovocea7");
      if (Cursor_sottovocea7!=null)
        Cursor_sottovocea7.Close();
      Cursor_sottovocea7 = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("sottovocea7")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_sottovocea7;
        Cursor_sottovocea7.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_sva7: query on sottovocea7 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_sottovocea7.Eof())) {
        mcSottovoce.AppendWithTrimmedKey(Cursor_sottovocea7.GetString("VOCE")+Cursor_sottovocea7.GetString("SOTTOVOCE"));
        mcSottovoce.row.VOCE = Cursor_sottovocea7.GetString("VOCE");
        mcSottovoce.row.SOTTOVOCE = Cursor_sottovocea7.GetString("SOTTOVOCE");
        mcSottovoce.row.DESCRI = Cursor_sottovocea7.GetString("DESCRI");
        mcSottovoce.row.FLGRESID = Cursor_sottovocea7.GetString("FLGRESID");
        mcSottovoce.row.FLG00015 = Cursor_sottovocea7.GetString("FLG00015");
        mcSottovoce.row.FLG00016 = Cursor_sottovocea7.GetString("FLG00016");
        mcSottovoce.row.FLG01217 = Cursor_sottovocea7.GetString("FLG01217");
        mcSottovoce.row.FLG02147 = Cursor_sottovocea7.GetString("FLG02147");
        mcSottovoce.row.FLG02148 = Cursor_sottovocea7.GetString("FLG02148");
        mcSottovoce.row.FLG02149 = Cursor_sottovocea7.GetString("FLG02149");
        Cursor_sottovocea7.Next();
      }
      m_cConnectivityError = Cursor_sottovocea7.ErrorMessage();
      Cursor_sottovocea7.Close();
      mcSottovoce.GoTop();
      // * --- Fill memory cursor mcTB00015 on tbprovsv
      mcTB00015.Zap();
      m_cServer = m_Ctx.GetServer("tbprovsv");
      m_cPhName = m_Ctx.GetPhName("tbprovsv");
      if (Cursor_tbprovsv!=null)
        Cursor_tbprovsv.Close();
      Cursor_tbprovsv = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbprovsv")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbprovsv;
        Cursor_tbprovsv.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_sva7: query on tbprovsv returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbprovsv.Eof())) {
        mcTB00015.AppendWithTrimmedKey(Cursor_tbprovsv.GetString("SIGLASV"));
        mcTB00015.row.SIGLA = Cursor_tbprovsv.GetString("SIGLA");
        mcTB00015.row.PROVINCIA = Cursor_tbprovsv.GetString("PROVINCIA");
        mcTB00015.row.SIGLASV = Cursor_tbprovsv.GetString("SIGLASV");
        Cursor_tbprovsv.Next();
      }
      m_cConnectivityError = Cursor_tbprovsv.ErrorMessage();
      Cursor_tbprovsv.Close();
      mcTB00015.GoTop();
      // * --- Fill memory cursor mcTB00016 on qbe_tb00016
      mcTB00016.Zap();
      SPBridge.HMCaller _h00000026;
      _h00000026 = new SPBridge.HMCaller();
      _h00000026.Set("m_cVQRList",m_cVQRList);
      _h00000026.Set("tiposv","A7");
      if (Cursor_qbe_tb00016!=null)
        Cursor_qbe_tb00016.Close();
      Cursor_qbe_tb00016 = new VQRHolder("qbe_tb00016",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000026,true).GetResultSet(m_Ctx);
      {
        final CPResultSet m_TheCursor = Cursor_qbe_tb00016;
        Cursor_qbe_tb00016.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_sva7: query on qbe_tb00016 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_qbe_tb00016.Eof())) {
        mcTB00016.AppendWithTrimmedKey(Cursor_qbe_tb00016.GetString("COD"));
        mcTB00016.row.COD = Cursor_qbe_tb00016.GetString("COD");
        mcTB00016.row.DESCRI = Cursor_qbe_tb00016.GetString("DESCRI");
        Cursor_qbe_tb00016.Next();
      }
      m_cConnectivityError = Cursor_qbe_tb00016.ErrorMessage();
      Cursor_qbe_tb00016.Close();
      mcTB00016.GoTop();
      // * --- Fill memory cursor mcTB01217 on tb01217
      mcTB01217.Zap();
      m_cServer = m_Ctx.GetServer("tb01217");
      m_cPhName = m_Ctx.GetPhName("tb01217");
      if (Cursor_tb01217!=null)
        Cursor_tb01217.Close();
      Cursor_tb01217 = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tb01217")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tb01217;
        Cursor_tb01217.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_sva7: query on tb01217 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tb01217.Eof())) {
        mcTB01217.AppendWithTrimmedKey(Cursor_tb01217.GetString("COD"));
        mcTB01217.row.COD = Cursor_tb01217.GetString("COD");
        mcTB01217.row.DESCRI = Cursor_tb01217.GetString("DESCRI");
        mcTB01217.row.VOCE = Cursor_tb01217.GetString("VOCE");
        Cursor_tb01217.Next();
      }
      m_cConnectivityError = Cursor_tb01217.ErrorMessage();
      Cursor_tb01217.Close();
      mcTB01217.GoTop();
      // * --- Fill memory cursor mcTB02147 on tb02147
      mcTB02147.Zap();
      m_cServer = m_Ctx.GetServer("tb02147");
      m_cPhName = m_Ctx.GetPhName("tb02147");
      if (Cursor_tb02147!=null)
        Cursor_tb02147.Close();
      Cursor_tb02147 = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tb02147")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tb02147;
        Cursor_tb02147.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_import_sva7: query on tb02147 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tb02147.Eof())) {
        mcTB02147.AppendWithTrimmedKey(Cursor_tb02147.GetString("COD"));
        mcTB02147.row.COD = Cursor_tb02147.GetString("COD");
        mcTB02147.row.DESCRI = Cursor_tb02147.GetString("DESCRI");
        Cursor_tb02147.Next();
      }
      m_cConnectivityError = Cursor_tb02147.ErrorMessage();
      Cursor_tb02147.Close();
      mcTB02147.GoTop();
      /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + pFile + NL */
      gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+pFile+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If At(".xlsx",Lower(pFile)) > 0 */
      if (CPLib.gt(CPLib.At(".xlsx",CPLib.Lower(pFile)),0)) {
        //base
        InputStream ExcelFileToRead = new FileInputStream(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+pFile);
        XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
        _conta = wb.getNumberOfSheets();
        Row row; 
        Cell cell;
        int cellType;
        /* While _i < _conta */
        while (CPLib.lt(_i,_conta)) {
          //Apro uno ad uno i fogli del file Excel
          XSSFSheet sheet = wb.getSheetAt(_i);
          for (int rowNumber = sheet.getFirstRowNum(); rowNumber <= sheet.getLastRowNum(); rowNumber++) {
            row = sheet.getRow(rowNumber);
            if (row == null) {
                   // This row is completely empty
              } else {
          /* riga_letta := riga_letta+1 // riga letta del file Excel */
          riga_letta = CPLib.Round(riga_letta+1,0);
          /* If riga_letta > 1 */
          if (CPLib.gt(riga_letta,1)) {
            //scorro le colonne
            cell_count=0;
            /* While cell_count < 8 */
            while (CPLib.lt(cell_count,8)) {
              //scorro le celle della riga
              cell = row.getCell(cell_count);
              if (cell != null) {
              //  _tipocol = cell.getCellType();
                cellType = cell.getCellType().ordinal();
                switch (cellType) {
                  case 1:
                    colonna[cell_count]=String.valueOf((int)cell.getNumericCellValue());
                    break;
                  case 2:
                    colonna[cell_count]=cell.getStringCellValue();       
                    break;
                  default:
                    colonna[cell_count]=cell.getStringCellValue();       
                 }
              } else {
                colonna[cell_count]="";
              }
              ++cell_count;
            } // End While
            /* conta := conta + 1 */
            conta = conta+1;
            /* _anno := LRTrim(colonna[0]) */
            _anno = CPLib.LRTrim(colonna[0]);
            /* _semestre := LRTrim(colonna[1]) */
            _semestre = CPLib.LRTrim(colonna[1]);
            /* _dato := -1 */
            _dato = CPLib.Round(-1,0);
            /* gMsgImp := 'Elaborazione della riga: Anno-'+LRTrim(colonna[0])+"/Semestre-"+LRTrim(colonna[1])+"/Voce-"+LRTrim(colonna[2])+"/Sottovoce-"+LRTrim(colonna[3]) // Messaggio Import */
            gMsgImp = "Elaborazione della riga: Anno-"+CPLib.LRTrim(colonna[0])+"/Semestre-"+CPLib.LRTrim(colonna[1])+"/Voce-"+CPLib.LRTrim(colonna[2])+"/Sottovoce-"+CPLib.LRTrim(colonna[3]);
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If mcSottovoce.HasKey(LRTrim(colonna[2])+LRTrim(colonna[3])) */
            if (mcSottovoce.HasKey(CPLib.LRTrim(colonna[2])+CPLib.LRTrim(colonna[3]))) {
              /* mcSottovoce.GoToKey(LRTrim(colonna[2])+LRTrim(colonna[3])) */
              mcSottovoce.GoToKey(CPLib.LRTrim(colonna[2])+CPLib.LRTrim(colonna[3]));
              /* _flgresid := mcSottovoce.FLGRESID */
              _flgresid = mcSottovoce.row.FLGRESID;
              /* _flg00015 := mcSottovoce.FLG00015 */
              _flg00015 = mcSottovoce.row.FLG00015;
              /* _flg00016 := mcSottovoce.FLG00016 */
              _flg00016 = mcSottovoce.row.FLG00016;
              /* _flg01217 := mcSottovoce.FLG01217 */
              _flg01217 = mcSottovoce.row.FLG01217;
              /* _flg02147 := mcSottovoce.FLG02147 */
              _flg02147 = mcSottovoce.row.FLG02147;
              /* _flg02148 := mcSottovoce.FLG02148 */
              _flg02148 = mcSottovoce.row.FLG02148;
              /* _flg02149 := mcSottovoce.FLG02149 */
              _flg02149 = mcSottovoce.row.FLG02149;
            } // End If
            /* mcDettaglio.AppendBlank() */
            mcDettaglio.AppendBlank();
            /* mcDettaglio.ANNO := LRTrim(colonna[0]) */
            mcDettaglio.row.ANNO = CPLib.LRTrim(colonna[0]);
            /* mcDettaglio.SEMESTRE := LRTrim(colonna[1]) */
            mcDettaglio.row.SEMESTRE = CPLib.LRTrim(colonna[1]);
            /* mcDettaglio.VOCE := LRTrim(colonna[2]) */
            mcDettaglio.row.VOCE = CPLib.LRTrim(colonna[2]);
            /* mcDettaglio.SOTTOVOCE := LRTrim(colonna[3]) */
            mcDettaglio.row.SOTTOVOCE = CPLib.LRTrim(colonna[3]);
            /* mcDettaglio.IMPORTO := Val(LRTrim(colonna[5])) */
            mcDettaglio.row.IMPORTO = CPLib.Val(CPLib.LRTrim(colonna[5]));
            /* mcDettaglio.IDBASEA7 := LibreriaMit.UniqueId() */
            mcDettaglio.row.IDBASEA7 = LibreriaMit.UniqueId();
            /* mcDettaglio.RESID := iif(_flgresid='S',LRTrim(colonna[4]),"1") */
            mcDettaglio.row.RESID = (CPLib.eqr(_flgresid,"S")?CPLib.LRTrim(colonna[4]):"1");
            /* If _flg00015='S' */
            if (CPLib.eqr(_flg00015,"S")) {
              /* If mcTB00015.HasKey(LRTrim(colonna[6])) */
              if (mcTB00015.HasKey(CPLib.LRTrim(colonna[6]))) {
                /* mcTB00015.GoToKey(LRTrim(colonna[6])) */
                mcTB00015.GoToKey(CPLib.LRTrim(colonna[6]));
                /* mcDettaglio.PROVINCIA := mcTB00015.SIGLASV */
                mcDettaglio.row.PROVINCIA = mcTB00015.row.SIGLASV;
                /* _dato := 0 */
                _dato = CPLib.Round(0,0);
              } // End If
              /* If _dato=-1 */
              if (CPLib.eqr(_dato,-1)) {
                /* If mcTB00015.HasKey(LRTrim(colonna[7])) */
                if (mcTB00015.HasKey(CPLib.LRTrim(colonna[7]))) {
                  /* mcTB00015.GoToKey(LRTrim(colonna[7])) */
                  mcTB00015.GoToKey(CPLib.LRTrim(colonna[7]));
                  /* mcDettaglio.PROVINCIA := mcTB00015.SIGLASV */
                  mcDettaglio.row.PROVINCIA = mcTB00015.row.SIGLASV;
                  /* _dato := 1 */
                  _dato = CPLib.Round(1,0);
                } // End If
              } // End If
            } // End If
            /* If _flg00016='S' */
            if (CPLib.eqr(_flg00016,"S")) {
              /* If _dato=-1 */
              if (CPLib.eqr(_dato,-1)) {
                /* If mcTB00016.HasKey(LRTrim(colonna[6])) */
                if (mcTB00016.HasKey(CPLib.LRTrim(colonna[6]))) {
                  /* mcTB00016.GoToKey(LRTrim(colonna[6])) */
                  mcTB00016.GoToKey(CPLib.LRTrim(colonna[6]));
                  /* mcDettaglio.STATO := mcTB00016.COD */
                  mcDettaglio.row.STATO = mcTB00016.row.COD;
                  /* _dato := 0 */
                  _dato = CPLib.Round(0,0);
                } // End If
                /* If _dato=-1 */
                if (CPLib.eqr(_dato,-1)) {
                  /* If mcTB00016.HasKey(LRTrim(colonna[7])) */
                  if (mcTB00016.HasKey(CPLib.LRTrim(colonna[7]))) {
                    /* mcTB00016.GoToKey(LRTrim(colonna[7])) */
                    mcTB00016.GoToKey(CPLib.LRTrim(colonna[7]));
                    /* mcDettaglio.STATO := mcTB00016.COD */
                    mcDettaglio.row.STATO = mcTB00016.row.COD;
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                } // End If
              } else { // Else
                /* If _dato=0 */
                if (CPLib.eqr(_dato,0)) {
                  /* If mcTB00016.HasKey(LRTrim(colonna[7])) */
                  if (mcTB00016.HasKey(CPLib.LRTrim(colonna[7]))) {
                    /* mcTB00016.GoToKey(LRTrim(colonna[7])) */
                    mcTB00016.GoToKey(CPLib.LRTrim(colonna[7]));
                    /* mcDettaglio.STATO := mcTB00016.COD */
                    mcDettaglio.row.STATO = mcTB00016.row.COD;
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                  /* ElseIf _dato=1 */
                } else if (CPLib.eqr(_dato,1)) {
                  /* If mcTB00016.HasKey(LRTrim(colonna[6])) */
                  if (mcTB00016.HasKey(CPLib.LRTrim(colonna[6]))) {
                    /* mcTB00016.GoToKey(LRTrim(colonna[6])) */
                    mcTB00016.GoToKey(CPLib.LRTrim(colonna[6]));
                    /* mcDettaglio.STATO := mcTB00016.COD */
                    mcDettaglio.row.STATO = mcTB00016.row.COD;
                    /* _dato := 0 */
                    _dato = CPLib.Round(0,0);
                  } // End If
                } // End If
              } // End If
            } // End If
            /* If _flg01217='S' */
            if (CPLib.eqr(_flg01217,"S")) {
              /* If _dato=-1 */
              if (CPLib.eqr(_dato,-1)) {
                /* If mcTB01217.HasKey(LRTrim(colonna[6])) */
                if (mcTB01217.HasKey(CPLib.LRTrim(colonna[6]))) {
                  /* mcTB01217.GoToKey(LRTrim(colonna[6])) */
                  mcTB01217.GoToKey(CPLib.LRTrim(colonna[6]));
                  /* mcDettaglio.VAL01217 := mcTB01217.COD */
                  mcDettaglio.row.VAL01217 = mcTB01217.row.COD;
                  /* _dato := 0 */
                  _dato = CPLib.Round(0,0);
                } // End If
                /* If _dato=-1 */
                if (CPLib.eqr(_dato,-1)) {
                  /* If mcTB01217.HasKey(LRTrim(colonna[7])) */
                  if (mcTB01217.HasKey(CPLib.LRTrim(colonna[7]))) {
                    /* mcTB01217.GoToKey(LRTrim(colonna[7])) */
                    mcTB01217.GoToKey(CPLib.LRTrim(colonna[7]));
                    /* mcDettaglio.VAL01217 := mcTB01217.COD */
                    mcDettaglio.row.VAL01217 = mcTB01217.row.COD;
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                } // End If
              } else { // Else
                /* If _dato=0 */
                if (CPLib.eqr(_dato,0)) {
                  /* If mcTB01217.HasKey(LRTrim(colonna[7])) */
                  if (mcTB01217.HasKey(CPLib.LRTrim(colonna[7]))) {
                    /* mcTB01217.GoToKey(LRTrim(colonna[7])) */
                    mcTB01217.GoToKey(CPLib.LRTrim(colonna[7]));
                    /* mcDettaglio.VAL01217 := mcTB01217.COD */
                    mcDettaglio.row.VAL01217 = mcTB01217.row.COD;
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                  /* ElseIf _dato=1 */
                } else if (CPLib.eqr(_dato,1)) {
                  /* If mcTB01217.HasKey(LRTrim(colonna[6])) */
                  if (mcTB01217.HasKey(CPLib.LRTrim(colonna[6]))) {
                    /* mcTB01217.GoToKey(LRTrim(colonna[6])) */
                    mcTB01217.GoToKey(CPLib.LRTrim(colonna[6]));
                    /* mcDettaglio.VAL01217 := mcTB01217.COD */
                    mcDettaglio.row.VAL01217 = mcTB01217.row.COD;
                    /* _dato := 0 */
                    _dato = CPLib.Round(0,0);
                  } // End If
                } // End If
              } // End If
            } // End If
            /* If _flg02147='S' */
            if (CPLib.eqr(_flg02147,"S")) {
              /* If _dato=-1 */
              if (CPLib.eqr(_dato,-1)) {
                /* If mcTB02147.HasKey(LRTrim(colonna[6])) */
                if (mcTB02147.HasKey(CPLib.LRTrim(colonna[6]))) {
                  /* mcTB02147.GoToKey(LRTrim(colonna[6])) */
                  mcTB02147.GoToKey(CPLib.LRTrim(colonna[6]));
                  /* mcDettaglio.VAL02147 := mcTB02147.COD */
                  mcDettaglio.row.VAL02147 = mcTB02147.row.COD;
                  /* _dato := 0 */
                  _dato = CPLib.Round(0,0);
                } // End If
                /* If _dato=-1 */
                if (CPLib.eqr(_dato,-1)) {
                  /* If mcTB02147.HasKey(LRTrim(colonna[7])) */
                  if (mcTB02147.HasKey(CPLib.LRTrim(colonna[7]))) {
                    /* mcTB02147.GoToKey(LRTrim(colonna[7])) */
                    mcTB02147.GoToKey(CPLib.LRTrim(colonna[7]));
                    /* mcDettaglio.VAL02147 := mcTB02147.COD */
                    mcDettaglio.row.VAL02147 = mcTB02147.row.COD;
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                } // End If
              } else { // Else
                /* If _dato=0 */
                if (CPLib.eqr(_dato,0)) {
                  /* If mcTB02147.HasKey(LRTrim(colonna[7])) */
                  if (mcTB02147.HasKey(CPLib.LRTrim(colonna[7]))) {
                    /* mcTB02147.GoToKey(LRTrim(colonna[7])) */
                    mcTB02147.GoToKey(CPLib.LRTrim(colonna[7]));
                    /* mcDettaglio.VAL02147 := mcTB02147.COD */
                    mcDettaglio.row.VAL02147 = mcTB02147.row.COD;
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                  /* ElseIf _dato=1 */
                } else if (CPLib.eqr(_dato,1)) {
                  /* If mcTB02147.HasKey(LRTrim(colonna[6])) */
                  if (mcTB02147.HasKey(CPLib.LRTrim(colonna[6]))) {
                    /* mcTB02147.GoToKey(LRTrim(colonna[6])) */
                    mcTB02147.GoToKey(CPLib.LRTrim(colonna[6]));
                    /* mcDettaglio.VAL02147 := mcTB02147.COD */
                    mcDettaglio.row.VAL02147 = mcTB02147.row.COD;
                    /* _dato := 0 */
                    _dato = CPLib.Round(0,0);
                  } // End If
                } // End If
              } // End If
            } // End If
            /* If _flg02148='S' */
            if (CPLib.eqr(_flg02148,"S")) {
              /* If _dato=-1 */
              if (CPLib.eqr(_dato,-1)) {
                /* If LRTrim(Right(LRTrim(colonna[6]),4))=_anno */
                if (CPLib.eqr(CPLib.LRTrim(CPLib.Right(CPLib.LRTrim(colonna[6]),4)),_anno)) {
                  /* mcDettaglio.VAL02148 := arfn_datefchar(LRTrim(colonna[6])) */
                  mcDettaglio.row.VAL02148 = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.LRTrim(colonna[6]));
                  /* _dato := 0 */
                  _dato = CPLib.Round(0,0);
                } // End If
                /* If _dato=-1 */
                if (CPLib.eqr(_dato,-1)) {
                  /* If LRTrim(Right(LRTrim(colonna[7]),4))=_anno */
                  if (CPLib.eqr(CPLib.LRTrim(CPLib.Right(CPLib.LRTrim(colonna[7]),4)),_anno)) {
                    /* mcDettaglio.VAL02148 := arfn_datefchar(LRTrim(colonna[7])) */
                    mcDettaglio.row.VAL02148 = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.LRTrim(colonna[7]));
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                } // End If
              } else { // Else
                /* If _dato=0 */
                if (CPLib.eqr(_dato,0)) {
                  /* If LRTrim(Right(LRTrim(colonna[7]),4))=_anno */
                  if (CPLib.eqr(CPLib.LRTrim(CPLib.Right(CPLib.LRTrim(colonna[7]),4)),_anno)) {
                    /* mcDettaglio.VAL02148 := arfn_datefchar(LRTrim(colonna[7])) */
                    mcDettaglio.row.VAL02148 = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.LRTrim(colonna[7]));
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                  /* ElseIf _dato=1 */
                } else if (CPLib.eqr(_dato,1)) {
                  /* If LRTrim(Right(LRTrim(colonna[6]),4))=_anno */
                  if (CPLib.eqr(CPLib.LRTrim(CPLib.Right(CPLib.LRTrim(colonna[6]),4)),_anno)) {
                    /* mcDettaglio.VAL02148 := arfn_datefchar(LRTrim(colonna[6])) */
                    mcDettaglio.row.VAL02148 = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.LRTrim(colonna[6]));
                    /* _dato := 0 */
                    _dato = CPLib.Round(0,0);
                  } // End If
                } // End If
              } // End If
            } // End If
            /* If _flg02149='S' */
            if (CPLib.eqr(_flg02149,"S")) {
              /* If _dato=-1 */
              if (CPLib.eqr(_dato,-1)) {
                /* If LRTrim(Right(LRTrim(colonna[6]),4))<>_anno */
                if (CPLib.ne(CPLib.LRTrim(CPLib.Right(CPLib.LRTrim(colonna[6]),4)),_anno)) {
                  /* mcDettaglio.VAL02149 := LRTrim(colonna[6]) */
                  mcDettaglio.row.VAL02149 = CPLib.LRTrim(colonna[6]);
                  /* _dato := 0 */
                  _dato = CPLib.Round(0,0);
                } // End If
                /* If _dato=-1 */
                if (CPLib.eqr(_dato,-1)) {
                  /* If LRTrim(Right(LRTrim(colonna[7]),4))<>_anno */
                  if (CPLib.ne(CPLib.LRTrim(CPLib.Right(CPLib.LRTrim(colonna[7]),4)),_anno)) {
                    /* mcDettaglio.VAL02149 := LRTrim(colonna[7]) */
                    mcDettaglio.row.VAL02149 = CPLib.LRTrim(colonna[7]);
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                } // End If
              } else { // Else
                /* If _dato=0 */
                if (CPLib.eqr(_dato,0)) {
                  /* If LRTrim(Right(LRTrim(colonna[7]),4))<>_anno */
                  if (CPLib.ne(CPLib.LRTrim(CPLib.Right(CPLib.LRTrim(colonna[7]),4)),_anno)) {
                    /* mcDettaglio.VAL02149 := LRTrim(colonna[7]) */
                    mcDettaglio.row.VAL02149 = CPLib.LRTrim(colonna[7]);
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                  /* ElseIf _dato=1 */
                } else if (CPLib.eqr(_dato,1)) {
                  /* If LRTrim(Right(LRTrim(colonna[6]),4))<>_anno */
                  if (CPLib.ne(CPLib.LRTrim(CPLib.Right(CPLib.LRTrim(colonna[6]),4)),_anno)) {
                    /* mcDettaglio.VAL02149 := LRTrim(colonna[6]) */
                    mcDettaglio.row.VAL02149 = CPLib.LRTrim(colonna[6]);
                    /* _dato := 0 */
                    _dato = CPLib.Round(0,0);
                  } // End If
                } // End If
              } // End If
            } // End If
            /* mcDettaglio.SaveRow() */
            mcDettaglio.SaveRow();
          } // End If
          // Chiude i cicli
            }
          }
          /* foglio := _i // foglio letto */
          foglio = CPLib.Round(_i,0);
          _i++;
        } // End While
        // Chiude il file
        ExcelFileToRead.close();
      } else { // Else
        /* fhand := FileLibMit.OpenReadPath(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+'/'+pFile) */
        fhand = FileLibMit.OpenReadPath(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+pFile);
        /* While not(FileLibMit.Eof(fhand)) */
        while ( ! (FileLibMit.Eof(fhand))) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* If Len(LRTrim(riga)) > 0 */
          if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
            /* _anno := Left(riga,4) */
            _anno = CPLib.Left(riga,4);
            /* _semestre := Substr(riga,5,1) */
            _semestre = CPLib.Substr(riga,5,1);
            /* _dato := -1 */
            _dato = CPLib.Round(-1,0);
            /* gMsgImp := 'Elaborazione della riga: Anno-'+Left(riga,4)+"/Semestre-"+Substr(riga,5,1)+"/Voce-"+Substr(riga,6,5)+"/Sottovoce-"+Substr(riga,11,2) // Messaggio Import */
            gMsgImp = "Elaborazione della riga: Anno-"+CPLib.Left(riga,4)+"/Semestre-"+CPLib.Substr(riga,5,1)+"/Voce-"+CPLib.Substr(riga,6,5)+"/Sottovoce-"+CPLib.Substr(riga,11,2);
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If mcSottovoce.HasKey(Substr(riga,6,7)) */
            if (mcSottovoce.HasKey(CPLib.Substr(riga,6,7))) {
              /* mcSottovoce.GoToKey(Substr(riga,6,7)) */
              mcSottovoce.GoToKey(CPLib.Substr(riga,6,7));
              /* _flgresid := mcSottovoce.FLGRESID */
              _flgresid = mcSottovoce.row.FLGRESID;
              /* _flg00015 := mcSottovoce.FLG00015 */
              _flg00015 = mcSottovoce.row.FLG00015;
              /* _flg00016 := mcSottovoce.FLG00016 */
              _flg00016 = mcSottovoce.row.FLG00016;
              /* _flg01217 := mcSottovoce.FLG01217 */
              _flg01217 = mcSottovoce.row.FLG01217;
              /* _flg02147 := mcSottovoce.FLG02147 */
              _flg02147 = mcSottovoce.row.FLG02147;
              /* _flg02148 := mcSottovoce.FLG02148 */
              _flg02148 = mcSottovoce.row.FLG02148;
              /* _flg02149 := mcSottovoce.FLG02149 */
              _flg02149 = mcSottovoce.row.FLG02149;
            } // End If
            /* mcDettaglio.AppendBlank() */
            mcDettaglio.AppendBlank();
            /* mcDettaglio.ANNO := Left(riga,4) */
            mcDettaglio.row.ANNO = CPLib.Left(riga,4);
            /* mcDettaglio.SEMESTRE := Substr(riga,5,1) */
            mcDettaglio.row.SEMESTRE = CPLib.Substr(riga,5,1);
            /* mcDettaglio.VOCE := Substr(riga,6,5) */
            mcDettaglio.row.VOCE = CPLib.Substr(riga,6,5);
            /* mcDettaglio.SOTTOVOCE := Substr(riga,11,2) */
            mcDettaglio.row.SOTTOVOCE = CPLib.Substr(riga,11,2);
            /* mcDettaglio.IMPORTO := Val(Substr(riga,14,15)) */
            mcDettaglio.row.IMPORTO = CPLib.Val(CPLib.Substr(riga,14,15));
            /* mcDettaglio.IDBASEA7 := LibreriaMit.UniqueId() */
            mcDettaglio.row.IDBASEA7 = LibreriaMit.UniqueId();
            /* mcDettaglio.RESID := iif(_flgresid='S',Substr(riga,13,1),"1") */
            mcDettaglio.row.RESID = (CPLib.eqr(_flgresid,"S")?CPLib.Substr(riga,13,1):"1");
            /* If _flg00015='S' */
            if (CPLib.eqr(_flg00015,"S")) {
              /* If mcTB00015.HasKey(LRTrim(Substr(riga,29,8))) */
              if (mcTB00015.HasKey(CPLib.LRTrim(CPLib.Substr(riga,29,8)))) {
                /* mcTB00015.GoToKey(LRTrim(Substr(riga,29,8))) */
                mcTB00015.GoToKey(CPLib.LRTrim(CPLib.Substr(riga,29,8)));
                /* mcDettaglio.PROVINCIA := mcTB00015.SIGLASV */
                mcDettaglio.row.PROVINCIA = mcTB00015.row.SIGLASV;
                /* _dato := 0 */
                _dato = CPLib.Round(0,0);
              } // End If
              /* If _dato=-1 */
              if (CPLib.eqr(_dato,-1)) {
                /* If mcTB00015.HasKey(LRTrim(Substr(riga,37,8))) */
                if (mcTB00015.HasKey(CPLib.LRTrim(CPLib.Substr(riga,37,8)))) {
                  /* mcTB00015.GoToKey(LRTrim(Substr(riga,37,8))) */
                  mcTB00015.GoToKey(CPLib.LRTrim(CPLib.Substr(riga,37,8)));
                  /* mcDettaglio.PROVINCIA := mcTB00015.SIGLASV */
                  mcDettaglio.row.PROVINCIA = mcTB00015.row.SIGLASV;
                  /* _dato := 1 */
                  _dato = CPLib.Round(1,0);
                } // End If
              } // End If
            } // End If
            /* If _flg00016='S' */
            if (CPLib.eqr(_flg00016,"S")) {
              /* If _dato=-1 */
              if (CPLib.eqr(_dato,-1)) {
                /* If mcTB00016.HasKey(LRTrim(Substr(riga,29,8))) */
                if (mcTB00016.HasKey(CPLib.LRTrim(CPLib.Substr(riga,29,8)))) {
                  /* mcTB00016.GoToKey(LRTrim(Substr(riga,29,8))) */
                  mcTB00016.GoToKey(CPLib.LRTrim(CPLib.Substr(riga,29,8)));
                  /* mcDettaglio.STATO := mcTB00016.COD */
                  mcDettaglio.row.STATO = mcTB00016.row.COD;
                  /* _dato := 0 */
                  _dato = CPLib.Round(0,0);
                } // End If
                /* If _dato=-1 */
                if (CPLib.eqr(_dato,-1)) {
                  /* If mcTB00016.HasKey(LRTrim(Substr(riga,37,8))) */
                  if (mcTB00016.HasKey(CPLib.LRTrim(CPLib.Substr(riga,37,8)))) {
                    /* mcTB00016.GoToKey(LRTrim(Substr(riga,37,8))) */
                    mcTB00016.GoToKey(CPLib.LRTrim(CPLib.Substr(riga,37,8)));
                    /* mcDettaglio.STATO := mcTB00016.COD */
                    mcDettaglio.row.STATO = mcTB00016.row.COD;
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                } // End If
              } else { // Else
                /* If _dato=0 */
                if (CPLib.eqr(_dato,0)) {
                  /* If mcTB00016.HasKey(LRTrim(Substr(riga,37,8))) */
                  if (mcTB00016.HasKey(CPLib.LRTrim(CPLib.Substr(riga,37,8)))) {
                    /* mcTB00016.GoToKey(LRTrim(Substr(riga,37,8))) */
                    mcTB00016.GoToKey(CPLib.LRTrim(CPLib.Substr(riga,37,8)));
                    /* mcDettaglio.STATO := mcTB00016.COD */
                    mcDettaglio.row.STATO = mcTB00016.row.COD;
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                  /* ElseIf _dato=1 */
                } else if (CPLib.eqr(_dato,1)) {
                  /* If mcTB00016.HasKey(LRTrim(Substr(riga,29,8))) */
                  if (mcTB00016.HasKey(CPLib.LRTrim(CPLib.Substr(riga,29,8)))) {
                    /* mcTB00016.GoToKey(LRTrim(Substr(riga,29,8))) */
                    mcTB00016.GoToKey(CPLib.LRTrim(CPLib.Substr(riga,29,8)));
                    /* mcDettaglio.STATO := mcTB00016.COD */
                    mcDettaglio.row.STATO = mcTB00016.row.COD;
                    /* _dato := 0 */
                    _dato = CPLib.Round(0,0);
                  } // End If
                } // End If
              } // End If
            } // End If
            /* If _flg01217='S' */
            if (CPLib.eqr(_flg01217,"S")) {
              /* If _dato=-1 */
              if (CPLib.eqr(_dato,-1)) {
                /* If mcTB01217.HasKey(LRTrim(Substr(riga,29,8))) */
                if (mcTB01217.HasKey(CPLib.LRTrim(CPLib.Substr(riga,29,8)))) {
                  /* mcTB01217.GoToKey(LRTrim(Substr(riga,29,8))) */
                  mcTB01217.GoToKey(CPLib.LRTrim(CPLib.Substr(riga,29,8)));
                  /* mcDettaglio.VAL01217 := mcTB01217.COD */
                  mcDettaglio.row.VAL01217 = mcTB01217.row.COD;
                  /* _dato := 0 */
                  _dato = CPLib.Round(0,0);
                } // End If
                /* If _dato=-1 */
                if (CPLib.eqr(_dato,-1)) {
                  /* If mcTB01217.HasKey(LRTrim(Substr(riga,37,8))) */
                  if (mcTB01217.HasKey(CPLib.LRTrim(CPLib.Substr(riga,37,8)))) {
                    /* mcTB01217.GoToKey(LRTrim(Substr(riga,37,8))) */
                    mcTB01217.GoToKey(CPLib.LRTrim(CPLib.Substr(riga,37,8)));
                    /* mcDettaglio.VAL01217 := mcTB01217.COD */
                    mcDettaglio.row.VAL01217 = mcTB01217.row.COD;
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                } // End If
              } else { // Else
                /* If _dato=0 */
                if (CPLib.eqr(_dato,0)) {
                  /* If mcTB01217.HasKey(LRTrim(Substr(riga,37,8))) */
                  if (mcTB01217.HasKey(CPLib.LRTrim(CPLib.Substr(riga,37,8)))) {
                    /* mcTB01217.GoToKey(LRTrim(Substr(riga,37,8))) */
                    mcTB01217.GoToKey(CPLib.LRTrim(CPLib.Substr(riga,37,8)));
                    /* mcDettaglio.VAL01217 := mcTB01217.COD */
                    mcDettaglio.row.VAL01217 = mcTB01217.row.COD;
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                  /* ElseIf _dato=1 */
                } else if (CPLib.eqr(_dato,1)) {
                  /* If mcTB01217.HasKey(LRTrim(Substr(riga,29,8))) */
                  if (mcTB01217.HasKey(CPLib.LRTrim(CPLib.Substr(riga,29,8)))) {
                    /* mcTB01217.GoToKey(LRTrim(Substr(riga,29,8))) */
                    mcTB01217.GoToKey(CPLib.LRTrim(CPLib.Substr(riga,29,8)));
                    /* mcDettaglio.VAL01217 := mcTB01217.COD */
                    mcDettaglio.row.VAL01217 = mcTB01217.row.COD;
                    /* _dato := 0 */
                    _dato = CPLib.Round(0,0);
                  } // End If
                } // End If
              } // End If
            } // End If
            /* If _flg02147='S' */
            if (CPLib.eqr(_flg02147,"S")) {
              /* If _dato=-1 */
              if (CPLib.eqr(_dato,-1)) {
                /* If mcTB02147.HasKey(LRTrim(Substr(riga,29,8))) */
                if (mcTB02147.HasKey(CPLib.LRTrim(CPLib.Substr(riga,29,8)))) {
                  /* mcTB02147.GoToKey(LRTrim(Substr(riga,29,8))) */
                  mcTB02147.GoToKey(CPLib.LRTrim(CPLib.Substr(riga,29,8)));
                  /* mcDettaglio.VAL02147 := mcTB02147.COD */
                  mcDettaglio.row.VAL02147 = mcTB02147.row.COD;
                  /* _dato := 0 */
                  _dato = CPLib.Round(0,0);
                } // End If
                /* If _dato=-1 */
                if (CPLib.eqr(_dato,-1)) {
                  /* If mcTB02147.HasKey(LRTrim(Substr(riga,37,8))) */
                  if (mcTB02147.HasKey(CPLib.LRTrim(CPLib.Substr(riga,37,8)))) {
                    /* mcTB02147.GoToKey(LRTrim(Substr(riga,37,8))) */
                    mcTB02147.GoToKey(CPLib.LRTrim(CPLib.Substr(riga,37,8)));
                    /* mcDettaglio.VAL02147 := mcTB02147.COD */
                    mcDettaglio.row.VAL02147 = mcTB02147.row.COD;
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                } // End If
              } else { // Else
                /* If _dato=0 */
                if (CPLib.eqr(_dato,0)) {
                  /* If mcTB02147.HasKey(LRTrim(Substr(riga,37,8))) */
                  if (mcTB02147.HasKey(CPLib.LRTrim(CPLib.Substr(riga,37,8)))) {
                    /* mcTB02147.GoToKey(LRTrim(Substr(riga,37,8))) */
                    mcTB02147.GoToKey(CPLib.LRTrim(CPLib.Substr(riga,37,8)));
                    /* mcDettaglio.VAL02147 := mcTB02147.COD */
                    mcDettaglio.row.VAL02147 = mcTB02147.row.COD;
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                  /* ElseIf _dato=1 */
                } else if (CPLib.eqr(_dato,1)) {
                  /* If mcTB02147.HasKey(LRTrim(Substr(riga,29,8))) */
                  if (mcTB02147.HasKey(CPLib.LRTrim(CPLib.Substr(riga,29,8)))) {
                    /* mcTB02147.GoToKey(LRTrim(Substr(riga,29,8))) */
                    mcTB02147.GoToKey(CPLib.LRTrim(CPLib.Substr(riga,29,8)));
                    /* mcDettaglio.VAL02147 := mcTB02147.COD */
                    mcDettaglio.row.VAL02147 = mcTB02147.row.COD;
                    /* _dato := 0 */
                    _dato = CPLib.Round(0,0);
                  } // End If
                } // End If
              } // End If
            } // End If
            /* If _flg02148='S' */
            if (CPLib.eqr(_flg02148,"S")) {
              /* If _dato=-1 */
              if (CPLib.eqr(_dato,-1)) {
                /* If LRTrim(Substr(riga,33,4))=_anno */
                if (CPLib.eqr(CPLib.LRTrim(CPLib.Substr(riga,33,4)),_anno)) {
                  /* mcDettaglio.VAL02148 := arfn_datefchar(LRTrim(Substr(riga,29,8))) */
                  mcDettaglio.row.VAL02148 = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.LRTrim(CPLib.Substr(riga,29,8)));
                  /* _dato := 0 */
                  _dato = CPLib.Round(0,0);
                } // End If
                /* If _dato=-1 */
                if (CPLib.eqr(_dato,-1)) {
                  /* If LRTrim(Substr(riga,41,4))=_anno */
                  if (CPLib.eqr(CPLib.LRTrim(CPLib.Substr(riga,41,4)),_anno)) {
                    /* mcDettaglio.VAL02148 := arfn_datefchar(LRTrim(Substr(riga,37,8))) */
                    mcDettaglio.row.VAL02148 = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.LRTrim(CPLib.Substr(riga,37,8)));
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                } // End If
              } else { // Else
                /* If _dato=0 */
                if (CPLib.eqr(_dato,0)) {
                  /* If LRTrim(Substr(riga,41,4))=_anno */
                  if (CPLib.eqr(CPLib.LRTrim(CPLib.Substr(riga,41,4)),_anno)) {
                    /* mcDettaglio.VAL02148 := arfn_datefchar(LRTrim(Substr(riga,37,8))) */
                    mcDettaglio.row.VAL02148 = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.LRTrim(CPLib.Substr(riga,37,8)));
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                  /* ElseIf _dato=1 */
                } else if (CPLib.eqr(_dato,1)) {
                  /* If LRTrim(Substr(riga,33,4))=_anno */
                  if (CPLib.eqr(CPLib.LRTrim(CPLib.Substr(riga,33,4)),_anno)) {
                    /* mcDettaglio.VAL02148 := arfn_datefchar(LRTrim(Substr(riga,29,8))) */
                    mcDettaglio.row.VAL02148 = arfn_datefcharR.Make(m_Ctx,this).Run(CPLib.LRTrim(CPLib.Substr(riga,29,8)));
                    /* _dato := 0 */
                    _dato = CPLib.Round(0,0);
                  } // End If
                } // End If
              } // End If
            } // End If
            /* If _flg02149='S' */
            if (CPLib.eqr(_flg02149,"S")) {
              /* If _dato=-1 */
              if (CPLib.eqr(_dato,-1)) {
                /* If LRTrim(Substr(riga,33,4))<>_anno */
                if (CPLib.ne(CPLib.LRTrim(CPLib.Substr(riga,33,4)),_anno)) {
                  /* mcDettaglio.VAL02149 := LRTrim(Substr(riga,29,8)) */
                  mcDettaglio.row.VAL02149 = CPLib.LRTrim(CPLib.Substr(riga,29,8));
                  /* _dato := 0 */
                  _dato = CPLib.Round(0,0);
                } // End If
                /* If _dato=-1 */
                if (CPLib.eqr(_dato,-1)) {
                  /* If LRTrim(Substr(riga,41,4))<>_anno */
                  if (CPLib.ne(CPLib.LRTrim(CPLib.Substr(riga,41,4)),_anno)) {
                    /* mcDettaglio.VAL02149 := LRTrim(Substr(riga,37,8)) */
                    mcDettaglio.row.VAL02149 = CPLib.LRTrim(CPLib.Substr(riga,37,8));
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                } // End If
              } else { // Else
                /* If _dato=0 */
                if (CPLib.eqr(_dato,0)) {
                  /* If LRTrim(Substr(riga,41,4))<>_anno */
                  if (CPLib.ne(CPLib.LRTrim(CPLib.Substr(riga,41,4)),_anno)) {
                    /* mcDettaglio.VAL02149 := LRTrim(Substr(riga,37,8)) */
                    mcDettaglio.row.VAL02149 = CPLib.LRTrim(CPLib.Substr(riga,37,8));
                    /* _dato := 1 */
                    _dato = CPLib.Round(1,0);
                  } // End If
                  /* ElseIf _dato=1 */
                } else if (CPLib.eqr(_dato,1)) {
                  /* If LRTrim(Substr(riga,33,4))<>_anno */
                  if (CPLib.ne(CPLib.LRTrim(CPLib.Substr(riga,33,4)),_anno)) {
                    /* mcDettaglio.VAL02149 := LRTrim(Substr(riga,29,8)) */
                    mcDettaglio.row.VAL02149 = CPLib.LRTrim(CPLib.Substr(riga,29,8));
                    /* _dato := 0 */
                    _dato = CPLib.Round(0,0);
                  } // End If
                } // End If
              } // End If
            } // End If
            /* mcDettaglio.SaveRow() */
            mcDettaglio.SaveRow();
          } // End If
        } // End While
      } // End If
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000013Dstatus;
      nTry0000013Dstatus = m_Sql.GetTransactionStatus();
      String cTry0000013Dmsg;
      cTry0000013Dmsg = m_Sql.TransactionErrorMessage();
      try {
        /* If pTipo='C' */
        if (CPLib.eqr(pTipo,"C")) {
          // * --- Delete from detta7
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("detta7");
          m_cPhName = m_Ctx.GetPhName("detta7");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"detta7",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_sva7",23,"0000013F")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"?",0,0,m_cServer),m_cServer,_anno)+"";
          m_cSql = m_cSql+" and SEMESTRE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_semestre,"?",0,0,m_cServer),m_cServer,_semestre)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
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
          // * --- Delete from basea7
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("basea7");
          m_cPhName = m_Ctx.GetPhName("basea7");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"basea7",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_sva7",23,"00000140")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"?",0,0,m_cServer),m_cServer,_anno)+"";
          m_cSql = m_cSql+" and SEMESTRE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_semestre,"?",0,0,m_cServer),m_cServer,_semestre)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
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
          /* _rinizio := 0 */
          _rinizio = CPLib.Round(0,0);
          // * --- Insert into basea7 from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("basea7");
          m_cPhName = m_Ctx.GetPhName("basea7");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"basea7",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_sva7",23,"00000142")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000142(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_anno,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_semestre,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"basea7",true);
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
        } else { // Else
          // * --- Select from detta7
          m_cServer = m_Ctx.GetServer("detta7");
          m_cPhName = m_Ctx.GetPhName("detta7");
          if (Cursor_detta7!=null)
            Cursor_detta7.Close();
          Cursor_detta7 = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CPROWNUM  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"?",0,0,m_cServer, m_oParameters),m_cServer,_anno)+"  and  SEMESTRE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_semestre,"?",0,0,m_cServer, m_oParameters),m_cServer,_semestre)+" "+")"+(m_Ctx.IsSharedTemp("detta7")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_detta7.Eof())) {
            /* _rinizio := detta7->CPROWNUM */
            _rinizio = CPLib.Round(Cursor_detta7.GetDouble("CPROWNUM"),0);
            Cursor_detta7.Next();
          }
          m_cConnectivityError = Cursor_detta7.ErrorMessage();
          Cursor_detta7.Close();
          // * --- End Select
        } // End If
        for (MemoryCursorRow_detta7 rwDettaglio : mcDettaglio._iterable_()) {
          /* _nriga := _nriga + 1 */
          _nriga = CPLib.Round(_nriga+1,0);
          /* _rinizio := _rinizio + 1 */
          _rinizio = CPLib.Round(_rinizio+1,0);
          // * --- Insert into detta7 from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("detta7");
          m_cPhName = m_Ctx.GetPhName("detta7");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"detta7",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_sva7",23,"00000148")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000148(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.ANNO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.SEMESTRE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_rinizio,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(rwDettaglio.VOCE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(rwDettaglio.SOTTOVOCE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.RESID,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.PROVINCIA,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(rwDettaglio.STATO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(rwDettaglio.VAL01217,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(rwDettaglio.VAL02147,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.VAL02148,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.VAL02149,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.IMPORTO,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rwDettaglio.IDBASEA7,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"detta7",true);
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
        }
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgProc := gMsgProc + 'Sono state elaborate '+ LRTrim(Str(_nriga,4,0))+ ' righe ' + NL */
        gMsgProc = gMsgProc+"Sono state elaborate "+CPLib.LRTrim(CPLib.Str(_nriga,4,0))+" righe "+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgProc := gMsgProc + "Elaborazione bloccata per errore nell'inserimento dati! " + NL */
        gMsgProc = gMsgProc+"Elaborazione bloccata per errore nell'inserimento dati! "+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000013Dstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000013Dstatus,cTry0000013Dmsg);
        }
      }
      /* gMsgImp := 'Elaborazione Terminata!' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + pFile */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+pFile;
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_sottovocea7!=null)
          Cursor_sottovocea7.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbprovsv!=null)
          Cursor_tbprovsv.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_tb00016!=null)
          Cursor_qbe_tb00016.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tb01217!=null)
          Cursor_tb01217.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tb02147!=null)
          Cursor_tb02147.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_detta7!=null)
          Cursor_detta7.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pFile,String p_pTipo) {
    pFile = p_pFile;
    pTipo = p_pTipo;
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
  public Forward Run(String p_pFile,String p_pTipo) {
    pFile = p_pFile;
    pTipo = p_pTipo;
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
  public static arrt_import_sva7R Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_import_sva7R(p_Ctx, p_Caller);
  }
  public void Blank() {
    pFile = CPLib.Space(0);
    pTipo = CPLib.Space(1);
    fhand = "";
    _flgresid = CPLib.Space(1);
    _flg00015 = CPLib.Space(1);
    _flg00016 = CPLib.Space(1);
    _flg01217 = CPLib.Space(1);
    _flg02147 = CPLib.Space(1);
    _flg02148 = CPLib.Space(1);
    _flg02149 = CPLib.Space(1);
    _dato = 0;
    _nriga = 0;
    mcDettaglio = new MemoryCursor_detta7();
    _anno = CPLib.Space(4);
    _semestre = CPLib.Space(1);
    riga = "";
    _rinizio = 0;
    riga_letta = 0;
    foglio = 0;
    mcSottovoce = new MemoryCursor_sottovocea7();
    mcTB00015 = new MemoryCursor_tbprovsv();
    mcTB00016 = new MemoryCursor_qbe_tb00016_vqr();
    mcTB01217 = new MemoryCursor_tb01217();
    mcTB02147 = new MemoryCursor_tb02147();
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tb00016,
  public static final String m_cVQRList = ",qbe_tb00016,";
  // ENTITY_BATCHES: ,arfn_datefchar,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_datefchar,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"pFile","pTipo"};
  protected static String GetFieldsName_00000142(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"SEMESTRE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"basea7",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000148(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"SEMESTRE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"VOCE,";
    p_cSql = p_cSql+"SOTTOVOCE,";
    p_cSql = p_cSql+"RESID,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"STATO,";
    p_cSql = p_cSql+"VAL01217,";
    p_cSql = p_cSql+"VAL02147,";
    p_cSql = p_cSql+"VAL02148,";
    p_cSql = p_cSql+"VAL02149,";
    p_cSql = p_cSql+"IMPORTO,";
    p_cSql = p_cSql+"IDBASEA7,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"detta7",true);
    return p_cSql;
  }
}
