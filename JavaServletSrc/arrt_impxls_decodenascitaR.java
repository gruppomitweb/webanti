// * --- Area Manuale = BO - Header
// * --- arrt_impxls_decodenascita
import java.io.File; 
import java.lang.Double;

import jxl.*;
// * --- Fine Area Manuale
public class arrt_impxls_decodenascitaR implements CallerWithObjs {
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
  public String m_cPhName_decodenascita;
  public String m_cServer_decodenascita;
  public String m_cPhName_tbluonas;
  public String m_cServer_tbluonas;
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
  public String pNome;
  public double _id;
  public String _comune;
  public String _idb;
  public String column01;
  public String column02;
  public String column03;
  public String column04;
  public String gAzienda;
  public String gPathApp;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_impxls_decodenascita
  public int _i;
  public int _y;
  public int _righe;
  public int conta;
  // * --- Fine Area Manuale
  public arrt_impxls_decodenascitaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_impxls_decodenascita",m_Caller);
    m_cPhName_decodenascita = p_ContextObject.GetPhName("decodenascita");
    if (m_cPhName_decodenascita.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_decodenascita = m_cPhName_decodenascita+" "+m_Ctx.GetWritePhName("decodenascita");
    }
    m_cServer_decodenascita = p_ContextObject.GetServer("decodenascita");
    m_cPhName_tbluonas = p_ContextObject.GetPhName("tbluonas");
    if (m_cPhName_tbluonas.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbluonas = m_cPhName_tbluonas+" "+m_Ctx.GetWritePhName("tbluonas");
    }
    m_cServer_tbluonas = p_ContextObject.GetServer("tbluonas");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_id",p_cVarName)) {
      return _id;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_impxls_decodenascita";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pNome",p_cVarName)) {
      return pNome;
    }
    if (CPLib.eqr("_comune",p_cVarName)) {
      return _comune;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      return _idb;
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
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
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
    if (CPLib.eqr("_id",p_cVarName)) {
      _id = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pNome",p_cVarName)) {
      pNome = value;
      return;
    }
    if (CPLib.eqr("_comune",p_cVarName)) {
      _comune = value;
      return;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      _idb = value;
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
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
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
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_tbluonas=null;
    try {
      /* Dichiarazione variabili del caller */
      /* pNome Char(80) */
      /* Definizione variabili locali */
      /* _id Numeric(10, 0) */
      /* _comune Char(100) */
      /* _idb Char(4) */
      /* column01 Char(25) */
      /* column02 Char(25) */
      /* column03 Char(25) */
      /* column04 Char(25) */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gMsgImp Memo // Messaggio Import */
      //base
      Workbook workbook = Workbook.getWorkbook(new File(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(pNome)));
      conta = workbook.getNumberOfSheets();
      /* _i = 0 */
      CPLib.eqr(_i,0);
      /* While _i < conta */
      while (CPLib.lt(_i,conta)) {
        _righe = 0;
        Sheet sheet = workbook.getSheet(_i);
        _righe = sheet.getRows();
        _y = 1;
        /* While _y < _righe */
        while (CPLib.lt(_y,_righe)) {
          // Legge le celle del file xls
          Cell a01 = sheet.getCell(0,_y);
          Cell a02 = sheet.getCell(1,_y);
          Cell a03 = sheet.getCell(2,_y);
          Cell a04 = sheet.getCell(3,_y);
          /* column01 := a01.getContents() */
          column01 = a01.getContents();
          /* column02 := a02.getContents() */
          column02 = a02.getContents();
          /* column03 := a03.getContents() */
          column03 = a03.getContents();
          /* column04 := a04.getContents() */
          column04 = a04.getContents();
          /* _id := Val(column01) */
          _id = CPLib.Round(CPLib.Val(column01),0);
          /* _comune := LRTrim(column03) */
          _comune = CPLib.LRTrim(column03);
          /* _idb := '' */
          _idb = "";
          /* If not(Empty(LRTrim(_comune))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(_comune)))) {
            // * --- Read from DecodeNascita
            m_cServer = m_Ctx.GetServer("DecodeNascita");
            m_cPhName = m_Ctx.GetPhName("DecodeNascita");
            m_cSql = "";
            m_cSql = m_cSql+"id="+CPSql.SQLValueAdapter(CPLib.ToSQL(_id,"N",10,0,m_cServer),m_cServer,_id);
            if (m_Ctx.IsSharedTemp("DecodeNascita")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _idb = Read_Cursor.GetString("SIGLA");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on DecodeNascita into routine arrt_impxls_decodenascita returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _idb = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If not(Empty(LRTrim(_idb))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(_idb)))) {
              // * --- Select from tbluonas
              m_cServer = m_Ctx.GetServer("tbluonas");
              m_cPhName = m_Ctx.GetPhName("tbluonas");
              if (Cursor_tbluonas!=null)
                Cursor_tbluonas.Close();
              Cursor_tbluonas = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SIGLA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idb,"?",0,0,m_cServer, m_oParameters),m_cServer,_idb)+" "+")"+(m_Ctx.IsSharedTemp("tbluonas")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_tbluonas.Eof())) {
                // * --- Write into DecodeNascita from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("DecodeNascita");
                m_cPhName = m_Ctx.GetPhName("DecodeNascita");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"DecodeNascita",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_impxls_decodenascita",75,"00000026")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"SIGLA = "+CPLib.ToSQL(Cursor_tbluonas.GetString("SIGLA"),"C",4,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL(Cursor_tbluonas.GetString("DESCRI"),"C",60,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATINI = "+CPLib.ToSQL(Cursor_tbluonas.GetDate("DATINI"),"D",8,0)+", ";
                m_cSql = m_cSql+"DATFIN = "+CPLib.ToSQL(Cursor_tbluonas.GetDate("DATFIN"),"D",8,0)+", ";
                m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_tbluonas.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"DecodeNascita",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"ID = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_id,"?",0,0,m_cServer),m_cServer,_id)+"";
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
                Cursor_tbluonas.Next();
              }
              m_cConnectivityError = Cursor_tbluonas.ErrorMessage();
              Cursor_tbluonas.Close();
              // * --- End Select
            } // End If
          } // End If
          _y++;
        } // End While
        _i++;
      } // End While
      /* workbook.close() */
      workbook.close();
      /* gMsgImp := 'Elaborazione Terminata !' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata !";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbluonas!=null)
          Cursor_tbluonas.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pNome) {
    pNome = p_pNome;
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
  public Forward Run(String p_pNome) {
    pNome = p_pNome;
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
  public static arrt_impxls_decodenascitaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_impxls_decodenascitaR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pNome = CPLib.Space(80);
    _id = 0;
    _comune = CPLib.Space(100);
    _idb = CPLib.Space(4);
    column01 = CPLib.Space(25);
    column02 = CPLib.Space(25);
    column03 = CPLib.Space(25);
    column04 = CPLib.Space(25);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pNome"};
}
