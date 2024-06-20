// * --- Area Manuale = BO - Header
// * --- arrt_wu_stampa_day_cases
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
public class arrt_wu_stampa_day_casesR implements CallerWithObjs {
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
  public String m_cPhName_wutrxchk;
  public String m_cServer_wutrxchk;
  public String m_cPhName_cpusers;
  public String m_cServer_cpusers;
  public String m_cPhName_tmp_listafile;
  public String m_cServer_tmp_listafile;
  public String m_cPhName_wutrxchk_cases;
  public String m_cServer_wutrxchk_cases;
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
  public java.sql.Date pDatIni;
  public java.sql.Date pDatFin;
  public String gPathApp;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String gUrlApp;
  public String _filexls;
  public String _filexlspath;
  public String cRitorno;
  public java.sql.Date _dataoggi;
  public double _numtrx;
  public double _caso1;
  public double _caso2;
  public double _caso3;
  public double _caso4;
  public double _caso5;
  public MemoryCursor_mcdaycases_mcrdef mcDayCases;
  public String _cdata;
  public String _oldmsg;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_wu_stampa_day_cases
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
  public arrt_wu_stampa_day_casesR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_wu_stampa_day_cases",m_Caller);
    m_cPhName_wutrxchk = p_ContextObject.GetPhName("wutrxchk");
    if (m_cPhName_wutrxchk.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wutrxchk = m_cPhName_wutrxchk+" "+m_Ctx.GetWritePhName("wutrxchk");
    }
    m_cServer_wutrxchk = p_ContextObject.GetServer("wutrxchk");
    m_cPhName_cpusers = p_ContextObject.GetPhName("cpusers");
    if (m_cPhName_cpusers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers = m_cPhName_cpusers+" "+m_Ctx.GetWritePhName("cpusers");
    }
    m_cServer_cpusers = p_ContextObject.GetServer("cpusers");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
      m_cPhName_tmp_listafile = p_ContextObject.GetPhName("tmp_listafile");
      if (m_cPhName_tmp_listafile.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_listafile = m_cPhName_tmp_listafile+" "+m_Ctx.GetWritePhName("tmp_listafile");
      }
      m_cServer_tmp_listafile = p_ContextObject.GetServer("tmp_listafile");
    }
    m_cPhName_wutrxchk_cases = p_ContextObject.GetPhName("wutrxchk_cases");
    if (m_cPhName_wutrxchk_cases.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wutrxchk_cases = m_cPhName_wutrxchk_cases+" "+m_Ctx.GetWritePhName("wutrxchk_cases");
    }
    m_cServer_wutrxchk_cases = p_ContextObject.GetServer("wutrxchk_cases");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_numtrx",p_cVarName)) {
      return _numtrx;
    }
    if (CPLib.eqr("_caso1",p_cVarName)) {
      return _caso1;
    }
    if (CPLib.eqr("_caso2",p_cVarName)) {
      return _caso2;
    }
    if (CPLib.eqr("_caso3",p_cVarName)) {
      return _caso3;
    }
    if (CPLib.eqr("_caso4",p_cVarName)) {
      return _caso4;
    }
    if (CPLib.eqr("_caso5",p_cVarName)) {
      return _caso5;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_wu_stampa_day_cases";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
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
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("_filexls",p_cVarName)) {
      return _filexls;
    }
    if (CPLib.eqr("_filexlspath",p_cVarName)) {
      return _filexlspath;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("_cdata",p_cVarName)) {
      return _cdata;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDatIni",p_cVarName)) {
      return pDatIni;
    }
    if (CPLib.eqr("pDatFin",p_cVarName)) {
      return pDatFin;
    }
    if (CPLib.eqr("_dataoggi",p_cVarName)) {
      return _dataoggi;
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
    if (CPLib.eqr("mcDayCases",p_cVarName)) {
      return mcDayCases;
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
    if (CPLib.eqr("_numtrx",p_cVarName)) {
      _numtrx = value;
      return;
    }
    if (CPLib.eqr("_caso1",p_cVarName)) {
      _caso1 = value;
      return;
    }
    if (CPLib.eqr("_caso2",p_cVarName)) {
      _caso2 = value;
      return;
    }
    if (CPLib.eqr("_caso3",p_cVarName)) {
      _caso3 = value;
      return;
    }
    if (CPLib.eqr("_caso4",p_cVarName)) {
      _caso4 = value;
      return;
    }
    if (CPLib.eqr("_caso5",p_cVarName)) {
      _caso5 = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
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
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("_filexls",p_cVarName)) {
      _filexls = value;
      return;
    }
    if (CPLib.eqr("_filexlspath",p_cVarName)) {
      _filexlspath = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("_cdata",p_cVarName)) {
      _cdata = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pDatIni",p_cVarName)) {
      pDatIni = value;
      return;
    }
    if (CPLib.eqr("pDatFin",p_cVarName)) {
      pDatFin = value;
      return;
    }
    if (CPLib.eqr("_dataoggi",p_cVarName)) {
      _dataoggi = value;
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
    if (CPLib.eqr("mcDayCases",p_cVarName)) {
      mcDayCases = (MemoryCursor_mcdaycases_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_wu_stampa_day_cases=null;
    CPResultSet Cursor_wutrxchk_cases=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pDatIni Date // Data Inizio Periodo */
      /* pDatFin Date // Data Fine Periodo */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) */
      /* gMsgProc Char(120) */
      /* gUrlApp Char(80) // URL Applicazione */
      /* _filexls Char(80) */
      /* _filexlspath Char(80) */
      /* cRitorno Char(50) */
      /* _dataoggi Date */
      /* _numtrx Numeric(10, 0) */
      /* _caso1 Numeric(10, 0) */
      /* _caso2 Numeric(10, 0) */
      /* _caso3 Numeric(10, 0) */
      /* _caso4 Numeric(10, 0) */
      /* _caso5 Numeric(10, 0) */
      /* mcDayCases MemoryCursor(mcDayCases.MCRDef) */
      /* _cdata Char(10) */
      /* _oldmsg Memo */
      // * --- Drop temporary table tmp_listafile
      if (m_Ctx.IsSharedTemp("tmp_listafile")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
          m_cServer = m_Ctx.GetServer("tmp_listafile");
          m_cPhName = m_Ctx.GetPhName("tmp_listafile");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_listafile");
      }
      // * --- Create temporary table tmp_listafile
      if (m_Ctx.IsSharedTemp("tmp_listafile")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
          m_cServer = m_Ctx.GetServer("tmp_listafile");
          m_cPhName = m_Ctx.GetPhName("tmp_listafile");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_listafile");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_listafile");
      if ( ! (m_Ctx.IsSharedTemp("tmp_listafile"))) {
        m_cServer = m_Ctx.GetServer("tmp_listafile");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_listafile",m_cServer,"proto")),m_cPhName,"tmp_listafile",m_Ctx);
      }
      m_cPhName_tmp_listafile = m_cPhName;
      /* gMsgProc := 'Inizio elaborazione alle ore: '+arfn_fdatetime(DateTime()) + NL // Messaggio */
      gMsgProc = "Inizio elaborazione alle ore: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _dataoggi := pDatIni */
      _dataoggi = pDatIni;
      /* _oldmsg := '' */
      _oldmsg = "";
      /* While _dataoggi <= pDatFin */
      while (CPLib.le(_dataoggi,pDatFin)) {
        /* If Empty(_oldmsg) */
        if (CPLib.Empty(_oldmsg)) {
          /* gMsgProc := gMsgProc + 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi)  // Messaggio */
          gMsgProc = gMsgProc+"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi);
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sto elaborando il giorno: '+arfn_fdate(_dataoggi)) // Messaggio */
          gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi));
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* _numtrx := 0 */
        _numtrx = CPLib.Round(0,0);
        /* _caso1 := 0 */
        _caso1 = CPLib.Round(0,0);
        /* _caso2 := 0 */
        _caso2 = CPLib.Round(0,0);
        /* _caso3 := 0 */
        _caso3 = CPLib.Round(0,0);
        /* _caso4 := 0 */
        _caso4 = CPLib.Round(0,0);
        /* _caso5 := 0 */
        _caso5 = CPLib.Round(0,0);
        // * --- Select from qbe_wu_stampa_day_cases
        SPBridge.HMCaller _h00000029;
        _h00000029 = new SPBridge.HMCaller();
        _h00000029.Set("m_cVQRList",m_cVQRList);
        _h00000029.Set("pDaData",_dataoggi);
        _h00000029.Set("pAData",_dataoggi);
        if (Cursor_qbe_wu_stampa_day_cases!=null)
          Cursor_qbe_wu_stampa_day_cases.Close();
        Cursor_qbe_wu_stampa_day_cases = new VQRHolder("qbe_wu_stampa_day_cases",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000029,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_wu_stampa_day_cases.Eof())) {
          /* gMsgImp := "Sto elaborando l'operazione con codice: "+LRTrim(Str(qbe_wu_stampa_day_cases->TRXCODPRG,15,0)) */
          gMsgImp = "Sto elaborando l'operazione con codice: "+CPLib.LRTrim(CPLib.Str(Cursor_qbe_wu_stampa_day_cases.GetDouble("TRXCODPRG"),15,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _numtrx := _numtrx + 1 */
          _numtrx = CPLib.Round(_numtrx+1,0);
          // * --- Select from wutrxchk_cases
          m_cServer = m_Ctx.GetServer("wutrxchk_cases");
          m_cPhName = m_Ctx.GetPhName("wutrxchk_cases");
          if (Cursor_wutrxchk_cases!=null)
            Cursor_wutrxchk_cases.Close();
          Cursor_wutrxchk_cases = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select TRXCODICE,TRXCODCASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"TRXCODICE="+CPLib.ToSQL(Cursor_qbe_wu_stampa_day_cases.GetDouble("TRXCODPRG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("wutrxchk_cases")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_wutrxchk_cases.Eof())) {
            /* Case wutrxchk_cases->TRXCODCASE=1 */
            if (CPLib.eqr(Cursor_wutrxchk_cases.GetDouble("TRXCODCASE"),1)) {
              /* _caso1 := _caso1 + 1 */
              _caso1 = CPLib.Round(_caso1+1,0);
              /* Case wutrxchk_cases->TRXCODCASE=2 */
            } else if (CPLib.eqr(Cursor_wutrxchk_cases.GetDouble("TRXCODCASE"),2)) {
              /* _caso2 := _caso2 + 1 */
              _caso2 = CPLib.Round(_caso2+1,0);
              /* Case wutrxchk_cases->TRXCODCASE=3 */
            } else if (CPLib.eqr(Cursor_wutrxchk_cases.GetDouble("TRXCODCASE"),3)) {
              /* _caso3 := _caso3 + 1 */
              _caso3 = CPLib.Round(_caso3+1,0);
              /* Case wutrxchk_cases->TRXCODCASE=4 */
            } else if (CPLib.eqr(Cursor_wutrxchk_cases.GetDouble("TRXCODCASE"),4)) {
              /* _caso4 := _caso4 + 1 */
              _caso4 = CPLib.Round(_caso4+1,0);
              /* Case wutrxchk_cases->TRXCODCASE=5 */
            } else if (CPLib.eqr(Cursor_wutrxchk_cases.GetDouble("TRXCODCASE"),5)) {
              /* _caso5 := _caso5 + 1 */
              _caso5 = CPLib.Round(_caso5+1,0);
            } // End Case
            Cursor_wutrxchk_cases.Next();
          }
          m_cConnectivityError = Cursor_wutrxchk_cases.ErrorMessage();
          Cursor_wutrxchk_cases.Close();
          // * --- End Select
          Cursor_qbe_wu_stampa_day_cases.Next();
        }
        m_cConnectivityError = Cursor_qbe_wu_stampa_day_cases.ErrorMessage();
        Cursor_qbe_wu_stampa_day_cases.Close();
        // * --- End Select
        /* mcDayCases.AppendBlank() */
        mcDayCases.AppendBlank();
        /* mcDayCases.DATAOPE := _dataoggi */
        mcDayCases.row.DATAOPE = _dataoggi;
        /* mcDayCases.TOTTRX := _numtrx */
        mcDayCases.row.TOTTRX = _numtrx;
        /* mcDayCases.CASO_1 := _caso1 */
        mcDayCases.row.CASO_1 = _caso1;
        /* mcDayCases.CASO_2 := _caso2 */
        mcDayCases.row.CASO_2 = _caso2;
        /* mcDayCases.CASO_3 := _caso3 */
        mcDayCases.row.CASO_3 = _caso3;
        /* mcDayCases.CASO_4 := _caso4 */
        mcDayCases.row.CASO_4 = _caso4;
        /* mcDayCases.CASO_5 := _caso5 */
        mcDayCases.row.CASO_5 = _caso5;
        /* mcDayCases.SaveRow() */
        mcDayCases.SaveRow();
        /* _oldmsg := 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) */
        _oldmsg = "Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi);
        /* _dataoggi := arfn_datesum(_dataoggi,1) */
        _dataoggi = arfn_datesumR.Make(m_Ctx,this).Run(_dataoggi,1);
      } // End While
      double nTry0000003Fstatus;
      nTry0000003Fstatus = m_Sql.GetTransactionStatus();
      String cTry0000003Fmsg;
      cTry0000003Fmsg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgImp := 'Attendere. Creazione del file excel ...' // Messaggio Import */
        gMsgImp = "Attendere. Creazione del file excel ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Formato Excel */
        /* _filexls := 'CASES_AUA_'+DateToChar(Date())+".xlsx" */
        _filexls = "CASES_AUA_"+CPLib.DateToChar(CPLib.Date())+".xlsx";
        /* _filexlspath := LRTrim(gPathApp)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(_filexls) */
        _filexlspath = CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_filexls);
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
        cell.setCellValue("DATA OPERAZIONI");
        cell.setCellStyle(cs);
        cell = row.createCell(1);
        cell.setCellValue("NUMERO TRANSAZIONI");
        cell.setCellStyle(cs);
        cell = row.createCell(2);
        cell.setCellValue("CASO 1");
        cell.setCellStyle(cs);
        cell = row.createCell(3);
        cell.setCellValue("CASO 2");
        cell.setCellStyle(cs);
        cell = row.createCell(4);
        cell.setCellValue("CASO 3");
        cell.setCellStyle(cs);
        cell =  row.createCell(5);
        cell.setCellValue("CASO 4");
        cell.setCellStyle(cs);
        cell =  row.createCell(6);
        cell.setCellValue("CASO 5");
        cell.setCellStyle(cs);
        r++;
        for (MemoryCursorRow_mcdaycases_mcrdef rowDayCases : mcDayCases._iterable_()) {
          /* _cdata := arfn_fdate(rowDayCases.DATAOPE) */
          _cdata = arfn_fdateR.Make(m_Ctx,this).Run(rowDayCases.DATAOPE);
          /* _numtrx := rowDayCases.TOTTRX */
          _numtrx = CPLib.Round(rowDayCases.TOTTRX,0);
          /* _caso1 := rowDayCases.CASO_1 */
          _caso1 = CPLib.Round(rowDayCases.CASO_1,0);
          /* _caso2 := rowDayCases.CASO_2 */
          _caso2 = CPLib.Round(rowDayCases.CASO_2,0);
          /* _caso3 := rowDayCases.CASO_3 */
          _caso3 = CPLib.Round(rowDayCases.CASO_3,0);
          /* _caso4 := rowDayCases.CASO_4 */
          _caso4 = CPLib.Round(rowDayCases.CASO_4,0);
          /* _caso5 := rowDayCases.CASO_5 */
          _caso5 = CPLib.Round(rowDayCases.CASO_5,0);
          // Scrive la riga
          row = sheet.createRow(r);
          cell = row.createCell(0);
          cell.setCellValue(_cdata);
          cell = row.createCell(1);
          cell.setCellValue(_numtrx);
          cell = row.createCell(2);
          cell.setCellValue(_caso1);
          cell = row.createCell(3);
          cell.setCellValue(_caso2);
          cell = row.createCell(4);
          cell.setCellValue(_caso3);
          cell = row.createCell(5);
          cell.setCellValue(_caso4);
          cell = row.createCell(6);
          cell.setCellValue(_caso5);
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
        // scrivo il file di esito
        FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(_filexlspath));
        //write this workbook to an Outputstream.
        wb.write(fileOut);
        fileOut.flush();
        fileOut.close();
        /* cRitorno := _filexls */
        cRitorno = _filexls;
        // * --- Insert into tmp_listafile from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_listafile");
        m_cPhName = m_Ctx.GetPhName("tmp_listafile");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_listafile",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_stampa_day_cases",43,"00000058")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000058(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_filexls),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gUrlApp)+"export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_filexls),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_listafile",true);
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
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* cRitorno := '' */
        cRitorno = "";
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000003Fstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000003Fstatus,cTry0000003Fmsg);
        }
      }
      /* gMsgProc := gMsgProc +NL +  'Fine elaborazione alle ore: '+arfn_fdatetime(DateTime()) + NL // Messaggio */
      gMsgProc = gMsgProc+"\n"+"Fine elaborazione alle ore: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Elaborazione terminata!' // Messaggio Import */
      gMsgImp = "Elaborazione terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
      try {
        if (Cursor_qbe_wu_stampa_day_cases!=null)
          Cursor_qbe_wu_stampa_day_cases.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wutrxchk_cases!=null)
          Cursor_wutrxchk_cases.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_pDatIni,java.sql.Date p_pDatFin) {
    pDatIni = p_pDatIni;
    pDatFin = p_pDatFin;
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
  public String Run(java.sql.Date p_pDatIni,java.sql.Date p_pDatFin) {
    pDatIni = p_pDatIni;
    pDatFin = p_pDatFin;
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
  public static arrt_wu_stampa_day_casesR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_wu_stampa_day_casesR(p_Ctx, p_Caller);
  }
  public static arrt_wu_stampa_day_casesR Make(CPContext p_Ctx) {
    return new arrt_wu_stampa_day_casesR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pDatIni = CPLib.NullDate();
    pDatFin = CPLib.NullDate();
    _filexls = CPLib.Space(80);
    _filexlspath = CPLib.Space(80);
    cRitorno = CPLib.Space(50);
    _dataoggi = CPLib.NullDate();
    _numtrx = 0;
    _caso1 = 0;
    _caso2 = 0;
    _caso3 = 0;
    _caso4 = 0;
    _caso5 = 0;
    mcDayCases = new MemoryCursor_mcdaycases_mcrdef();
    _cdata = CPLib.Space(10);
    _oldmsg = "";
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_wu_stampa_day_cases,
  public static final String m_cVQRList = ",qbe_wu_stampa_day_cases,";
  // ENTITY_BATCHES: ,arfn_datesum,arfn_fdate,arfn_fdatetime,arrt_wu_stampa_day_cases,
  public static final String i_InvokedRoutines = ",arfn_datesum,arfn_fdate,arfn_fdatetime,arrt_wu_stampa_day_cases,";
  public static String[] m_cRunParameterNames={"pDatIni","pDatFin"};
  protected static String GetFieldsName_00000058(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"priorita,";
    p_cSql = p_cSql+"hyperlynk,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_listafile",true);
    return p_cSql;
  }
}
