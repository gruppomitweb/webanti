// * --- Area Manuale = BO - Header
// * --- arrt_chkdiana_sched
import java.util.*;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.nio.*;
import java.nio.channels.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import java.nio.charset.StandardCharsets;
// * --- Fine Area Manuale
public class arrt_chkdiana_schedR implements CallerWithObjs {
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
  public String m_cPhName_tbprcbck;
  public String m_cServer_tbprcbck;
  public String m_cPhName_tbprcbck_param;
  public String m_cServer_tbprcbck_param;
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
  public String w_codinter;
  public String w_tipinter;
  public String w_codage;
  public String w_codcli;
  public String w_ragben;
  public String daope;
  public String a_ope;
  public String dareg;
  public String a_reg;
  public String w_tipoarchd;
  public String w_tipoarchp;
  public String w_stoper;
  public String w_flgope;
  public String w_flgfrz;
  public String w_flgrae;
  public String w_flgrap;
  public String w_tiprap;
  public String w_flgtit;
  public String w_tiptit;
  public String w_flgint;
  public String w_flgdel;
  public String w_flgchk;
  public String w_flgxls;
  public String w_flgsto;
  public String w_allsto;
  public String w_multifile;
  public double _codice;
  public String cRitorno;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_chkdiana_sched
  public int _i;
  public int _y;
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
  public SXSSFWorkbook wb;
  public SXSSFSheet sheet;
  public Row row; 
  public Cell cell;
  public CellStyle cs;
  public Font f;
  Vector filenames = new Vector();
  Vector fileonames = new Vector();
  public byte[] buffer;
  // * --- Fine Area Manuale
  public arrt_chkdiana_schedR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_chkdiana_sched",m_Caller);
    m_cPhName_tbprcbck = p_ContextObject.GetPhName("tbprcbck");
    if (m_cPhName_tbprcbck.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbprcbck = m_cPhName_tbprcbck+" "+m_Ctx.GetWritePhName("tbprcbck");
    }
    m_cServer_tbprcbck = p_ContextObject.GetServer("tbprcbck");
    m_cPhName_tbprcbck_param = p_ContextObject.GetPhName("tbprcbck_param");
    if (m_cPhName_tbprcbck_param.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbprcbck_param = m_cPhName_tbprcbck_param+" "+m_Ctx.GetWritePhName("tbprcbck_param");
    }
    m_cServer_tbprcbck_param = p_ContextObject.GetServer("tbprcbck_param");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_codice",p_cVarName)) {
      return _codice;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_chkdiana_sched";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("codinter",p_cVarName)) {
      return w_codinter;
    }
    if (CPLib.eqr("tipinter",p_cVarName)) {
      return w_tipinter;
    }
    if (CPLib.eqr("codage",p_cVarName)) {
      return w_codage;
    }
    if (CPLib.eqr("codcli",p_cVarName)) {
      return w_codcli;
    }
    if (CPLib.eqr("ragben",p_cVarName)) {
      return w_ragben;
    }
    if (CPLib.eqr("daope",p_cVarName)) {
      return daope;
    }
    if (CPLib.eqr("a_ope",p_cVarName)) {
      return a_ope;
    }
    if (CPLib.eqr("dareg",p_cVarName)) {
      return dareg;
    }
    if (CPLib.eqr("a_reg",p_cVarName)) {
      return a_reg;
    }
    if (CPLib.eqr("tipoarchd",p_cVarName)) {
      return w_tipoarchd;
    }
    if (CPLib.eqr("tipoarchp",p_cVarName)) {
      return w_tipoarchp;
    }
    if (CPLib.eqr("stoper",p_cVarName)) {
      return w_stoper;
    }
    if (CPLib.eqr("flgope",p_cVarName)) {
      return w_flgope;
    }
    if (CPLib.eqr("flgfrz",p_cVarName)) {
      return w_flgfrz;
    }
    if (CPLib.eqr("flgrae",p_cVarName)) {
      return w_flgrae;
    }
    if (CPLib.eqr("flgrap",p_cVarName)) {
      return w_flgrap;
    }
    if (CPLib.eqr("tiprap",p_cVarName)) {
      return w_tiprap;
    }
    if (CPLib.eqr("flgtit",p_cVarName)) {
      return w_flgtit;
    }
    if (CPLib.eqr("tiptit",p_cVarName)) {
      return w_tiptit;
    }
    if (CPLib.eqr("flgint",p_cVarName)) {
      return w_flgint;
    }
    if (CPLib.eqr("flgdel",p_cVarName)) {
      return w_flgdel;
    }
    if (CPLib.eqr("flgchk",p_cVarName)) {
      return w_flgchk;
    }
    if (CPLib.eqr("flgxls",p_cVarName)) {
      return w_flgxls;
    }
    if (CPLib.eqr("flgsto",p_cVarName)) {
      return w_flgsto;
    }
    if (CPLib.eqr("allsto",p_cVarName)) {
      return w_allsto;
    }
    if (CPLib.eqr("multifile",p_cVarName)) {
      return w_multifile;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
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
    if (CPLib.eqr("_codice",p_cVarName)) {
      _codice = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("codinter",p_cVarName)) {
      w_codinter = value;
      return;
    }
    if (CPLib.eqr("tipinter",p_cVarName)) {
      w_tipinter = value;
      return;
    }
    if (CPLib.eqr("codage",p_cVarName)) {
      w_codage = value;
      return;
    }
    if (CPLib.eqr("codcli",p_cVarName)) {
      w_codcli = value;
      return;
    }
    if (CPLib.eqr("ragben",p_cVarName)) {
      w_ragben = value;
      return;
    }
    if (CPLib.eqr("daope",p_cVarName)) {
      daope = value;
      return;
    }
    if (CPLib.eqr("a_ope",p_cVarName)) {
      a_ope = value;
      return;
    }
    if (CPLib.eqr("dareg",p_cVarName)) {
      dareg = value;
      return;
    }
    if (CPLib.eqr("a_reg",p_cVarName)) {
      a_reg = value;
      return;
    }
    if (CPLib.eqr("tipoarchd",p_cVarName)) {
      w_tipoarchd = value;
      return;
    }
    if (CPLib.eqr("tipoarchp",p_cVarName)) {
      w_tipoarchp = value;
      return;
    }
    if (CPLib.eqr("stoper",p_cVarName)) {
      w_stoper = value;
      return;
    }
    if (CPLib.eqr("flgope",p_cVarName)) {
      w_flgope = value;
      return;
    }
    if (CPLib.eqr("flgfrz",p_cVarName)) {
      w_flgfrz = value;
      return;
    }
    if (CPLib.eqr("flgrae",p_cVarName)) {
      w_flgrae = value;
      return;
    }
    if (CPLib.eqr("flgrap",p_cVarName)) {
      w_flgrap = value;
      return;
    }
    if (CPLib.eqr("tiprap",p_cVarName)) {
      w_tiprap = value;
      return;
    }
    if (CPLib.eqr("flgtit",p_cVarName)) {
      w_flgtit = value;
      return;
    }
    if (CPLib.eqr("tiptit",p_cVarName)) {
      w_tiptit = value;
      return;
    }
    if (CPLib.eqr("flgint",p_cVarName)) {
      w_flgint = value;
      return;
    }
    if (CPLib.eqr("flgdel",p_cVarName)) {
      w_flgdel = value;
      return;
    }
    if (CPLib.eqr("flgchk",p_cVarName)) {
      w_flgchk = value;
      return;
    }
    if (CPLib.eqr("flgxls",p_cVarName)) {
      w_flgxls = value;
      return;
    }
    if (CPLib.eqr("flgsto",p_cVarName)) {
      w_flgsto = value;
      return;
    }
    if (CPLib.eqr("allsto",p_cVarName)) {
      w_allsto = value;
      return;
    }
    if (CPLib.eqr("multifile",p_cVarName)) {
      w_multifile = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
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
    CPResultSet Cursor_tbprcbck=null;
    try {
      /* w_codinter Char(11) */
      /* w_tipinter Char(2) */
      /* w_codage Char(6) */
      /* w_codcli Char(16) */
      /* w_ragben Char(70) */
      /* daope Char(8) */
      /* a_ope Char(8) */
      /* dareg Char(8) */
      /* a_reg Char(8) */
      /* w_tipoarchd Char(1) */
      /* w_tipoarchp Char(1) */
      /* w_stoper Char(1) */
      /* w_flgope Char(1) */
      /* w_flgfrz Char(1) */
      /* w_flgrae Char(1) */
      /* w_flgrap Char(1) */
      /* w_tiprap Char(1) */
      /* w_flgtit Char(1) */
      /* w_tiptit Char(1) */
      /* w_flgint Char(1) */
      /* w_flgdel Char(1) */
      /* w_flgchk Char(1) */
      /* w_flgxls Char(1) */
      /* w_flgsto Char(1) */
      /* w_allsto Char(1) */
      /* w_multifile Char(1) */
      /* _codice Numeric(10, 0) */
      /* cRitorno Char(2) := 'KO' */
      cRitorno = "KO";
      double nTry00000020status;
      nTry00000020status = m_Sql.GetTransactionStatus();
      String cTry00000020msg;
      cTry00000020msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from tbprcbck
        m_cServer = m_Ctx.GetServer("tbprcbck");
        m_cPhName = m_Ctx.GetPhName("tbprcbck");
        if (Cursor_tbprcbck!=null)
          Cursor_tbprcbck.Close();
        Cursor_tbprcbck = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select PBCODICE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PBDESCRI='SCHEDULAZIONE 380' "+")"+(m_Ctx.IsSharedTemp("tbprcbck")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_tbprcbck.Eof())) {
          /* _codice := tbprcbck->PBCODICE */
          _codice = CPLib.Round(Cursor_tbprcbck.GetDouble("PBCODICE"),0);
          // * --- Delete from tbprcbck_param
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tbprcbck_param");
          m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"00000023")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"PPCODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codice,"?",0,0,m_cServer),m_cServer,_codice)+"";
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
          Cursor_tbprcbck.Next();
        }
        m_cConnectivityError = Cursor_tbprcbck.ErrorMessage();
        Cursor_tbprcbck.Close();
        // * --- End Select
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"00000024")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000024(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_codinter","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_codinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"00000025")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000025(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(2,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_tipinter","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_tipinter,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"00000026")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000026(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(3,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_codage","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_codage,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"00000027")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000027(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(4,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_codcli","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_codcli,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"00000028")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000028(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(5,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_ragben","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_ragben,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"00000029")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000029(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(6,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("daope","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(daope),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"0000002A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000002A(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(7,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("a_ope","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(a_ope),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"0000002B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000002B(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(8,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("dareg","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(dareg),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"0000002C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000002C(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(9,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("a_reg","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(a_reg),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"0000002D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000002D(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(10,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_tipoarchd","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_tipoarchd,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"0000002E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000002E(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(11,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_tipoarchp","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_tipoarchp,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"0000002F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000002F(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(12,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_stoper","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(w_stoper),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"00000030")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000030(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(13,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_flgope","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_flgope,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"00000031")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000031(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(14,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_flgfrz","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_flgfrz,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"00000032")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000032(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(15,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_flgrae","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_flgrae,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"00000033")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000033(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(16,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_flgrap","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_flgrap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"00000034")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000034(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(17,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_tiprap","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_tiprap,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"00000035")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000035(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(18,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_flgtit","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_flgtit,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"00000036")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000036(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(19,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_tiptit","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_tiptit,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"00000037")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000037(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(20,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_flgint","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_flgint,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"00000038")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000038(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(21,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_flgdel","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_flgdel,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"00000039")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000039(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(22,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_flgchk","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_flgchk,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"0000003A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000003A(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(23,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_flgxls","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_flgxls,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"0000003B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000003B(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(24,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_flgsto","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_flgsto,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"0000003C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000003C(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(25,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_allsto","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_allsto,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Insert into tbprcbck_param from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck_param");
        m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck_param",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"0000003D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000003D(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codice,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(26,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("w_multifile","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(w_multifile,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck_param",true);
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
        // * --- Write into tbprcbck from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tbprcbck");
        m_cPhName = m_Ctx.GetPhName("tbprcbck");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_chkdiana_sched",556,"0000003E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"PBATTIVO = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbprcbck",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"PBCODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codice,"?",0,0,m_cServer),m_cServer,_codice)+"";
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
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* cRitorno := 'OK' */
        cRitorno = "OK";
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000020status,0)) {
          m_Sql.SetTransactionStatus(nTry00000020status,cTry00000020msg);
        }
      }
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
      try {
        if (Cursor_tbprcbck!=null)
          Cursor_tbprcbck.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_w_codinter,String p_w_tipinter,String p_w_codage,String p_w_codcli,String p_w_ragben,String p_daope,String p_a_ope,String p_dareg,String p_a_reg,String p_w_tipoarchd,String p_w_tipoarchp,String p_w_stoper,String p_w_flgope,String p_w_flgfrz,String p_w_flgrae,String p_w_flgrap,String p_w_tiprap,String p_w_flgtit,String p_w_tiptit,String p_w_flgint,String p_w_flgdel,String p_w_flgchk,String p_w_flgxls,String p_w_flgsto,String p_w_allsto,String p_w_multifile) {
    w_codinter = p_w_codinter;
    w_tipinter = p_w_tipinter;
    w_codage = p_w_codage;
    w_codcli = p_w_codcli;
    w_ragben = p_w_ragben;
    daope = p_daope;
    a_ope = p_a_ope;
    dareg = p_dareg;
    a_reg = p_a_reg;
    w_tipoarchd = p_w_tipoarchd;
    w_tipoarchp = p_w_tipoarchp;
    w_stoper = p_w_stoper;
    w_flgope = p_w_flgope;
    w_flgfrz = p_w_flgfrz;
    w_flgrae = p_w_flgrae;
    w_flgrap = p_w_flgrap;
    w_tiprap = p_w_tiprap;
    w_flgtit = p_w_flgtit;
    w_tiptit = p_w_tiptit;
    w_flgint = p_w_flgint;
    w_flgdel = p_w_flgdel;
    w_flgchk = p_w_flgchk;
    w_flgxls = p_w_flgxls;
    w_flgsto = p_w_flgsto;
    w_allsto = p_w_allsto;
    w_multifile = p_w_multifile;
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
  public String Run(String p_w_codinter,String p_w_tipinter,String p_w_codage,String p_w_codcli,String p_w_ragben,String p_daope,String p_a_ope,String p_dareg,String p_a_reg,String p_w_tipoarchd,String p_w_tipoarchp,String p_w_stoper,String p_w_flgope,String p_w_flgfrz,String p_w_flgrae,String p_w_flgrap,String p_w_tiprap,String p_w_flgtit,String p_w_tiptit,String p_w_flgint,String p_w_flgdel,String p_w_flgchk,String p_w_flgxls,String p_w_flgsto,String p_w_allsto,String p_w_multifile) {
    w_codinter = p_w_codinter;
    w_tipinter = p_w_tipinter;
    w_codage = p_w_codage;
    w_codcli = p_w_codcli;
    w_ragben = p_w_ragben;
    daope = p_daope;
    a_ope = p_a_ope;
    dareg = p_dareg;
    a_reg = p_a_reg;
    w_tipoarchd = p_w_tipoarchd;
    w_tipoarchp = p_w_tipoarchp;
    w_stoper = p_w_stoper;
    w_flgope = p_w_flgope;
    w_flgfrz = p_w_flgfrz;
    w_flgrae = p_w_flgrae;
    w_flgrap = p_w_flgrap;
    w_tiprap = p_w_tiprap;
    w_flgtit = p_w_flgtit;
    w_tiptit = p_w_tiptit;
    w_flgint = p_w_flgint;
    w_flgdel = p_w_flgdel;
    w_flgchk = p_w_flgchk;
    w_flgxls = p_w_flgxls;
    w_flgsto = p_w_flgsto;
    w_allsto = p_w_allsto;
    w_multifile = p_w_multifile;
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return l_result;
  }
  public static arrt_chkdiana_schedR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_chkdiana_schedR(p_Ctx, p_Caller);
  }
  public static arrt_chkdiana_schedR Make(CPContext p_Ctx) {
    return new arrt_chkdiana_schedR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_codinter = CPLib.Space(11);
    w_tipinter = CPLib.Space(2);
    w_codage = CPLib.Space(6);
    w_codcli = CPLib.Space(16);
    w_ragben = CPLib.Space(70);
    daope = CPLib.Space(8);
    a_ope = CPLib.Space(8);
    dareg = CPLib.Space(8);
    a_reg = CPLib.Space(8);
    w_tipoarchd = CPLib.Space(1);
    w_tipoarchp = CPLib.Space(1);
    w_stoper = CPLib.Space(1);
    w_flgope = CPLib.Space(1);
    w_flgfrz = CPLib.Space(1);
    w_flgrae = CPLib.Space(1);
    w_flgrap = CPLib.Space(1);
    w_tiprap = CPLib.Space(1);
    w_flgtit = CPLib.Space(1);
    w_tiptit = CPLib.Space(1);
    w_flgint = CPLib.Space(1);
    w_flgdel = CPLib.Space(1);
    w_flgchk = CPLib.Space(1);
    w_flgxls = CPLib.Space(1);
    w_flgsto = CPLib.Space(1);
    w_allsto = CPLib.Space(1);
    w_multifile = CPLib.Space(1);
    _codice = 0;
    cRitorno = "KO";
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arrt_chkdiana_sched,
  public static final String i_InvokedRoutines = ",arrt_chkdiana_sched,";
  public static String[] m_cRunParameterNames={"w_codinter","w_tipinter","w_codage","w_codcli","w_ragben","daope","a_ope","dareg","a_reg","w_tipoarchd","w_tipoarchp","w_stoper","w_flgope","w_flgfrz","w_flgrae","w_flgrap","w_tiprap","w_flgtit","w_tiptit","w_flgint","w_flgdel","w_flgchk","w_flgxls","w_flgsto","w_allsto","w_multifile"};
  protected static String GetFieldsName_00000024(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000025(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000026(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000027(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000028(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000029(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000002F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000030(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000031(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000032(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000033(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000034(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000035(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000036(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000037(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000038(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000039(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000003A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000003B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000003C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000003D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PPCODICE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"PPDESCRI,";
    p_cSql = p_cSql+"PPTIPPAR,";
    p_cSql = p_cSql+"PPVALPAR,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck_param",true);
    return p_cSql;
  }
}
