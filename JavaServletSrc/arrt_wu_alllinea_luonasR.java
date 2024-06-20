// * --- Area Manuale = BO - Header
// * --- arrt_wu_alllinea_luonas
import java.util.*;
import java.util.Iterator;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.*;
import com.monitorjbl.xlsx.StreamingReader;
// * --- Fine Area Manuale
public class arrt_wu_alllinea_luonasR implements CallerWithObjs {
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
  public String m_cPhName_dersonbo;
  public String m_cServer_dersonbo;
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
  public String pNomeFile;
  public String gAzienda;
  public String gPathApp;
  public String gMsgProc;
  public String gMsgImp;
  public String column01;
  public String column02;
  public String column03;
  public String column04;
  public boolean _commit;
  public double riga_letta;
  public double ncol;
  public double foglio;
  public String foglio_c;
  public MemoryCursor_mcdatistru_mcrdef mcDati;
  public double cell_type;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_wu_alllinea_luonas
  public int _i;
  public int _y;
  public int _righe;
  public int conta;
  public int r;
  String sheetName = "Sheet1";
  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
  public int _conta;
  public String[] lista;
  public String[] campi;
  public String[] colonna;
  public int conteggio;
  public int i;
  public int contanome;
  public int nfogli;
  public int ncampi;
  public int cell_count;
  // * --- Fine Area Manuale
  public arrt_wu_alllinea_luonasR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_wu_alllinea_luonas",m_Caller);
    m_cPhName_dersonbo = p_ContextObject.GetPhName("dersonbo");
    if (m_cPhName_dersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_dersonbo = m_cPhName_dersonbo+" "+m_Ctx.GetWritePhName("dersonbo");
    }
    m_cServer_dersonbo = p_ContextObject.GetServer("dersonbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      return riga_letta;
    }
    if (CPLib.eqr("ncol",p_cVarName)) {
      return ncol;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      return foglio;
    }
    if (CPLib.eqr("cell_type",p_cVarName)) {
      return cell_type;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_wu_alllinea_luonas";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pNomeFile",p_cVarName)) {
      return pNomeFile;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("column01",p_cVarName)) {
      return column01;
    }
    if (CPLib.eqr("column02",p_cVarName)) {
      return column02;
    }
    if (CPLib.eqr("column03",p_cVarName)) {
      return column03;
    }
    if (CPLib.eqr("column04",p_cVarName)) {
      return column04;
    }
    if (CPLib.eqr("foglio_c",p_cVarName)) {
      return foglio_c;
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
    if (CPLib.eqr("_commit",p_cVarName)) {
      return _commit;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcDati",p_cVarName)) {
      return mcDati;
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
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      riga_letta = value;
      return;
    }
    if (CPLib.eqr("ncol",p_cVarName)) {
      ncol = value;
      return;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      foglio = value;
      return;
    }
    if (CPLib.eqr("cell_type",p_cVarName)) {
      cell_type = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pNomeFile",p_cVarName)) {
      pNomeFile = value;
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
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("column01",p_cVarName)) {
      column01 = value;
      return;
    }
    if (CPLib.eqr("column02",p_cVarName)) {
      column02 = value;
      return;
    }
    if (CPLib.eqr("column03",p_cVarName)) {
      column03 = value;
      return;
    }
    if (CPLib.eqr("column04",p_cVarName)) {
      column04 = value;
      return;
    }
    if (CPLib.eqr("foglio_c",p_cVarName)) {
      foglio_c = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("_commit",p_cVarName)) {
      _commit = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcDati",p_cVarName)) {
      mcDati = (MemoryCursor_mcdatistru_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void StartPage() throws Exception {
    /* pNomeFile Char(50) // nome file da importare */
    /* gAzienda Char(10) // Azienda */
    /* gPathApp Char(80) // Path Applicazione */
    /* gMsgProc Memo // Messaggio */
    /* gMsgImp Char(120) // Messaggio */
    /* column01 Char(60) // numero progressivo */
    /* column02 Char(2) // data operazione */
    /* column03 Char(60) // segno */
    /* column04 Char(2) // codice agenzia */
    /* _commit Bool // ok alla commit */
    /* riga_letta Numeric(9, 0) // riga letta del file Excel */
    /* ncol Numeric(2, 0) // numero della colonna letta */
    /* foglio Numeric(2, 0) // foglio letto */
    /* foglio_c Char(9) // foglio letto Character */
    /* mcDati MemoryCursor(mcDatiStru.MCRDef) */
    /* cell_type Numeric(1, 0) // tipologia di cella letta */
    /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + pNomeFile + NL */
    gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+pNomeFile+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    // Begin Transaction
    m_Sql.RequireTransaction();
    double nTry00000016status;
    nTry00000016status = m_Sql.GetTransactionStatus();
    String cTry00000016msg;
    cTry00000016msg = m_Sql.TransactionErrorMessage();
    try {
      // Prova
      InputStream is = new FileInputStream(new File(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pNomeFile)));
      Workbook workbook = StreamingReader.builder()
              .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
              .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
              .open(is);            // InputStream or File for XLSX file (required)
      Cell cell;
      int cellType;
      String[] colonna = new String[4];
      _i=0;
      riga_letta=0;
      Sheet sheet = workbook.getSheetAt(0);
      for (Row row : sheet) {
        if (row == null) {
               // This row is completely empty
          } else {
      /* riga_letta := riga_letta+1 // riga letta del file Excel */
      riga_letta = CPLib.Round(riga_letta+1,0);
      /* gMsgImp := 'Elaboro riga Excel numero: '+ LRTrim(Str(riga_letta,10,0)) // Messaggio Import */
      gMsgImp = "Elaboro riga Excel numero: "+CPLib.LRTrim(CPLib.Str(riga_letta,10,0));
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If riga_letta >= 1 */
      if (CPLib.ge(riga_letta,1)) {
        //scorro le colonne
        cell_count=0;
        /* While cell_count < 4 */
        while (CPLib.lt(cell_count,4)) {
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
        /* mcDati.AppendBlank() */
        mcDati.AppendBlank();
        /* mcDati.colonna1 := colonna[0] */
        mcDati.row.colonna1 = colonna[0];
        /* mcDati.colonna2 := colonna[1] */
        mcDati.row.colonna2 = colonna[1];
        /* mcDati.colonna3 := colonna[2] */
        mcDati.row.colonna3 = colonna[2];
        /* mcDati.colonna4 := colonna[3] */
        mcDati.row.colonna4 = colonna[3];
        /* mcDati.SaveRow() */
        mcDati.SaveRow();
      } // End If
      // Chiude i cicli
        }
      }
      workbook.close();
      // Cancella il file
      FileLibMit.DeleteFile("appo/"+CPLib.LRTrim(gAzienda)+"/"+pNomeFile);
      for (MemoryCursorRow_mcdatistru_mcrdef rowDati : mcDati._iterable_()) {
        /* If not(Empty(rowDati.colonna1)) and not(Empty(rowDati.colonna3)) */
        if ( ! (CPLib.Empty(rowDati.colonna1)) &&  ! (CPLib.Empty(rowDati.colonna3))) {
          /* gMsgProc := gMsgProc  + 'Allineamento soggetti con luogo di nascita = ' + LRTrim(rowDati.colonna1) + " con luogo nascita = "+LRTrim(rowDati.colonna3) + NL */
          gMsgProc = gMsgProc+"Allineamento soggetti con luogo di nascita = "+CPLib.LRTrim(rowDati.colonna1)+" con luogo nascita = "+CPLib.LRTrim(rowDati.colonna3)+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgImp := 'Allineamento soggetti con luogo di nascita = ' + LRTrim(rowDati.colonna1) + " con luogo nascita = "+LRTrim(rowDati.colonna3) */
          gMsgImp = "Allineamento soggetti con luogo di nascita = "+CPLib.LRTrim(rowDati.colonna1)+" con luogo nascita = "+CPLib.LRTrim(rowDati.colonna3);
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* If rowDati.colonna2='EE' */
          if (CPLib.eqr(rowDati.colonna2,"EE")) {
            // * --- Write into dersonbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("dersonbo");
            m_cPhName = m_Ctx.GetPhName("dersonbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dersonbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_alllinea_luonas",141,"0000002B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.LRTrim(rowDati.colonna3),"C",60,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.LRTrim(rowDati.colonna4),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL("","C",60,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"dersonbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NASSTATO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowDati.colonna1),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(rowDati.colonna1))+"";
            m_cSql = m_cSql+" and TIPINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowDati.colonna2),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(rowDati.colonna2))+"";
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
          } else { // Else
            // * --- Write into dersonbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("dersonbo");
            m_cPhName = m_Ctx.GetPhName("dersonbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dersonbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_alllinea_luonas",141,"0000002C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.LRTrim(rowDati.colonna3),"C",60,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.LRTrim(rowDati.colonna4),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL("","C",60,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"dersonbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NASCOMUN = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowDati.colonna1),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(rowDati.colonna1))+"";
            m_cSql = m_cSql+" and TIPINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowDati.colonna2),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(rowDati.colonna2))+"";
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
          } // End If
        } // End If
      }
      // Commit
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      m_Sql.CompleteTransaction();
      /* gMsgImp := "Elaborazione Terminata con successo!" // Messaggio Import */
      gMsgImp = "Elaborazione Terminata con successo!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } catch(Exception l_exeption) {
      Stop.ReactToException(l_exeption);
      // Rollback
      m_Sql.AbortTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      m_bError = true;
      m_Sql.CompleteTransaction();
      /* gMsgImp := "Elaborazione Terminata con errori!" // Messaggio Import */
      gMsgImp = "Elaborazione Terminata con errori!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000016status,0)) {
        m_Sql.SetTransactionStatus(nTry00000016status,cTry00000016msg);
      }
    }
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + pNomeFile + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+pNomeFile+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
  }
  void _init_() {
  }
  public String RunAsync(String p_pNomeFile) {
    pNomeFile = p_pNomeFile;
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
  public String Run(String p_pNomeFile) {
    pNomeFile = p_pNomeFile;
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
          StartPage();
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
  public static arrt_wu_alllinea_luonasR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_wu_alllinea_luonasR(p_Ctx, p_Caller);
  }
  public static arrt_wu_alllinea_luonasR Make(CPContext p_Ctx) {
    return new arrt_wu_alllinea_luonasR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pNomeFile = CPLib.Space(50);
    column01 = CPLib.Space(60);
    column02 = CPLib.Space(2);
    column03 = CPLib.Space(60);
    column04 = CPLib.Space(2);
    _commit = false;
    riga_letta = 0;
    ncol = 0;
    foglio = 0;
    foglio_c = CPLib.Space(9);
    mcDati = new MemoryCursor_mcdatistru_mcrdef();
    cell_type = 0;
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,arrt_wu_alllinea_luonas,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arrt_wu_alllinea_luonas,";
  public static String[] m_cRunParameterNames={"pNomeFile"};
}
