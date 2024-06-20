// * --- Area Manuale = BO - Header
// * --- arrt_import_file_xls_esterni
import java.io.File; 
import java.lang.Double;

import jxl.*;
// * --- Fine Area Manuale
public class arrt_import_file_xls_esterniR implements CallerWithObjs {
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
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
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
  public String nomefile;
  public String column01;
  public String column02;
  public String column03;
  public String column04;
  public String column05;
  public String column06;
  public String column07;
  public String column08;
  public String column09;
  public String column10;
  public String column11;
  public String column12;
  public String column13;
  public String column14;
  public String column15;
  public String column16;
  public String column17;
  public String column18;
  public String column19;
  public String column20;
  public String column21;
  public String column22;
  public String column23;
  public String column24;
  public String column25;
  public String column26;
  public String column27;
  public String gPathApp;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_import_file_xls_esterni
  public int _i;
  public int _y;
  public int _righe;
  public int conta;
  // * --- Fine Area Manuale
  public arrt_import_file_xls_esterniR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_import_file_xls_esterni",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
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
      return "arrt_import_file_xls_esterni";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return nomefile;
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
    if (CPLib.eqr("column05",p_cVarName)) {
      return column05;
    }
    if (CPLib.eqr("column06",p_cVarName)) {
      return column06;
    }
    if (CPLib.eqr("column07",p_cVarName)) {
      return column07;
    }
    if (CPLib.eqr("column08",p_cVarName)) {
      return column08;
    }
    if (CPLib.eqr("column09",p_cVarName)) {
      return column09;
    }
    if (CPLib.eqr("column10",p_cVarName)) {
      return column10;
    }
    if (CPLib.eqr("column11",p_cVarName)) {
      return column11;
    }
    if (CPLib.eqr("column12",p_cVarName)) {
      return column12;
    }
    if (CPLib.eqr("column13",p_cVarName)) {
      return column13;
    }
    if (CPLib.eqr("column14",p_cVarName)) {
      return column14;
    }
    if (CPLib.eqr("column15",p_cVarName)) {
      return column15;
    }
    if (CPLib.eqr("column16",p_cVarName)) {
      return column16;
    }
    if (CPLib.eqr("column17",p_cVarName)) {
      return column17;
    }
    if (CPLib.eqr("column18",p_cVarName)) {
      return column18;
    }
    if (CPLib.eqr("column19",p_cVarName)) {
      return column19;
    }
    if (CPLib.eqr("column20",p_cVarName)) {
      return column20;
    }
    if (CPLib.eqr("column21",p_cVarName)) {
      return column21;
    }
    if (CPLib.eqr("column22",p_cVarName)) {
      return column22;
    }
    if (CPLib.eqr("column23",p_cVarName)) {
      return column23;
    }
    if (CPLib.eqr("column24",p_cVarName)) {
      return column24;
    }
    if (CPLib.eqr("column25",p_cVarName)) {
      return column25;
    }
    if (CPLib.eqr("column26",p_cVarName)) {
      return column26;
    }
    if (CPLib.eqr("column27",p_cVarName)) {
      return column27;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("nomefile",p_cVarName)) {
      nomefile = value;
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
    if (CPLib.eqr("column05",p_cVarName)) {
      column05 = value;
      return;
    }
    if (CPLib.eqr("column06",p_cVarName)) {
      column06 = value;
      return;
    }
    if (CPLib.eqr("column07",p_cVarName)) {
      column07 = value;
      return;
    }
    if (CPLib.eqr("column08",p_cVarName)) {
      column08 = value;
      return;
    }
    if (CPLib.eqr("column09",p_cVarName)) {
      column09 = value;
      return;
    }
    if (CPLib.eqr("column10",p_cVarName)) {
      column10 = value;
      return;
    }
    if (CPLib.eqr("column11",p_cVarName)) {
      column11 = value;
      return;
    }
    if (CPLib.eqr("column12",p_cVarName)) {
      column12 = value;
      return;
    }
    if (CPLib.eqr("column13",p_cVarName)) {
      column13 = value;
      return;
    }
    if (CPLib.eqr("column14",p_cVarName)) {
      column14 = value;
      return;
    }
    if (CPLib.eqr("column15",p_cVarName)) {
      column15 = value;
      return;
    }
    if (CPLib.eqr("column16",p_cVarName)) {
      column16 = value;
      return;
    }
    if (CPLib.eqr("column17",p_cVarName)) {
      column17 = value;
      return;
    }
    if (CPLib.eqr("column18",p_cVarName)) {
      column18 = value;
      return;
    }
    if (CPLib.eqr("column19",p_cVarName)) {
      column19 = value;
      return;
    }
    if (CPLib.eqr("column20",p_cVarName)) {
      column20 = value;
      return;
    }
    if (CPLib.eqr("column21",p_cVarName)) {
      column21 = value;
      return;
    }
    if (CPLib.eqr("column22",p_cVarName)) {
      column22 = value;
      return;
    }
    if (CPLib.eqr("column23",p_cVarName)) {
      column23 = value;
      return;
    }
    if (CPLib.eqr("column24",p_cVarName)) {
      column24 = value;
      return;
    }
    if (CPLib.eqr("column25",p_cVarName)) {
      column25 = value;
      return;
    }
    if (CPLib.eqr("column26",p_cVarName)) {
      column26 = value;
      return;
    }
    if (CPLib.eqr("column27",p_cVarName)) {
      column27 = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
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
    /* nomefile Char(30) */
    /* column01 Char(25) */
    /* column02 Char(25) */
    /* column03 Char(25) */
    /* column04 Char(25) */
    /* column05 Char(25) */
    /* column06 Char(25) */
    /* column07 Char(25) */
    /* column08 Char(25) */
    /* column09 Char(25) */
    /* column10 Char(25) */
    /* column11 Char(25) */
    /* column12 Char(25) */
    /* column13 Char(25) */
    /* column14 Char(25) */
    /* column15 Char(25) */
    /* column16 Char(25) */
    /* column17 Char(25) */
    /* column18 Char(25) */
    /* column19 Char(25) */
    /* column20 Char(25) */
    /* column21 Char(25) */
    /* column22 Char(25) */
    /* column23 Char(25) */
    /* column24 Char(25) */
    /* column25 Char(25) */
    /* column26 Char(25) */
    /* column27 Char(25) */
    /* gPathApp Char(80) // Path Applicazione */
    /* Exec "Importazione dati anagrafici" Page 2:Page_2 */
    Page_2();
    /* Stop  */
    throw new Stop();
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_personbo=null;
    try {
      /* nomefile := 'archpers_jc2.xls' */
      nomefile = "archpers_jc2.xls";
      //base
      Workbook workbook = Workbook.getWorkbook(new File(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(nomefile)));
      conta = workbook.getNumberOfSheets();
      /* _i = 0 */
      CPLib.eqr(_i,0);
      /* While _i < conta */
      while (CPLib.lt(_i,conta)) {
        _righe = 0;
        Sheet sheet = workbook.getSheet(_i);
        _righe = sheet.getRows();
        _y = 1;
        /* While _y <_righe */
        while (CPLib.lt(_y,_righe)) {
          Cell a01 = sheet.getCell(0,_y);
          Cell a02 = sheet.getCell(1,_y);
          Cell a03 = sheet.getCell(2,_y);
          Cell a04 = sheet.getCell(3,_y);
          Cell a05 = sheet.getCell(4,_y);
          Cell a06 = sheet.getCell(5,_y);
          Cell a07 = sheet.getCell(6,_y);
          Cell a08 = sheet.getCell(7,_y);
          Cell a09 = sheet.getCell(8,_y);
          /* column01 := a01.getContents() */
          column01 = a01.getContents();
          /* column02 := a02.getContents() */
          column02 = a02.getContents();
          /* column03 := a03.getContents() */
          column03 = a03.getContents();
          /* column04 := a04.getContents() */
          column04 = a04.getContents();
          /* column05 := a05.getContents() */
          column05 = a05.getContents();
          /* column06 := a06.getContents() */
          column06 = a06.getContents();
          /* column07 := a07.getContents() */
          column07 = a07.getContents();
          /* column08 := a08.getContents() */
          column08 = a08.getContents();
          /* column09 := a09.getContents() */
          column09 = a09.getContents();
          /* If not(Empty(LRTrim(column01))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(column01)))) {
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LTrim(column01),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LTrim(column01))+"  and  CODFISC="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LTrim(column02),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LTrim(column02))+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_personbo;
              Cursor_personbo.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_import_file_xls_esterni: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_personbo.Eof())) {
              // * --- Write into personbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xls_esterni",23,"00000037")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"NOME = "+CPLib.ToSQL((CPLib.Empty(Cursor_personbo.GetString("NOME")) || CPLib.gt(CPLib.At("?",Cursor_personbo.GetString("NOME")),0)?CPLib.LRTrim(column03):Cursor_personbo.GetString("NOME")),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL((CPLib.Empty(Cursor_personbo.GetString("COGNOME")) || CPLib.gt(CPLib.At("?",Cursor_personbo.GetString("COGNOME")),0)?CPLib.LRTrim(column04):Cursor_personbo.GetString("COGNOME")),"C",26,0,m_cServer)+", ";
              m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL((CPLib.Empty(Cursor_personbo.GetString("NASSTATO")) || CPLib.gt(CPLib.At("?",Cursor_personbo.GetString("NASSTATO")),0)?CPLib.LRTrim(column08):Cursor_personbo.GetString("NASSTATO")),"C",30,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
              m_cSql = m_cSql+" and CODFISC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CODFISC"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              {
                if (CPLib.gt(m_nUpdatedRows,1*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_import_file_xls_esterni: Write on personbo updates "+(m_nUpdatedRows)+" rows larger then the expected 1");
                  }
                }
              }
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
          } // End If
          _y++;
        } // End While
        _i++;
      } // End While
      /* workbook.close() */
      workbook.close();
    } finally {
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_import_file_xls_esterniR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_import_file_xls_esterniR(p_Ctx, p_Caller);
  }
  public void Blank() {
    nomefile = CPLib.Space(30);
    column01 = CPLib.Space(25);
    column02 = CPLib.Space(25);
    column03 = CPLib.Space(25);
    column04 = CPLib.Space(25);
    column05 = CPLib.Space(25);
    column06 = CPLib.Space(25);
    column07 = CPLib.Space(25);
    column08 = CPLib.Space(25);
    column09 = CPLib.Space(25);
    column10 = CPLib.Space(25);
    column11 = CPLib.Space(25);
    column12 = CPLib.Space(25);
    column13 = CPLib.Space(25);
    column14 = CPLib.Space(25);
    column15 = CPLib.Space(25);
    column16 = CPLib.Space(25);
    column17 = CPLib.Space(25);
    column18 = CPLib.Space(25);
    column19 = CPLib.Space(25);
    column20 = CPLib.Space(25);
    column21 = CPLib.Space(25);
    column22 = CPLib.Space(25);
    column23 = CPLib.Space(25);
    column24 = CPLib.Space(25);
    column25 = CPLib.Space(25);
    column26 = CPLib.Space(25);
    column27 = CPLib.Space(25);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
