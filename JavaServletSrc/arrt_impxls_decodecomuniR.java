// * --- Area Manuale = BO - Header
// * --- arrt_impxls_decodecomuni
import java.io.File; 
import java.lang.Double;

import jxl.*;
// * --- Fine Area Manuale
public class arrt_impxls_decodecomuniR implements CallerWithObjs {
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
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_tmp_vegagest;
  public String m_cServer_tmp_vegagest;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_joginfo;
  public String m_cServer_joginfo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_soginfo;
  public String m_cServer_soginfo;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_decodecitta;
  public String m_cServer_decodecitta;
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
  public String _prv;
  public String column01;
  public String column02;
  public String column03;
  public String column04;
  public String column05;
  public String gAzienda;
  public String gPathApp;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_impxls_decodecomuni
  public int _i;
  public int _y;
  public int _righe;
  public int conta;
  // * --- Fine Area Manuale
  public arrt_impxls_decodecomuniR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_impxls_decodecomuni",m_Caller);
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_tmp_vegagest = p_ContextObject.GetPhName("tmp_vegagest");
    if (m_cPhName_tmp_vegagest.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_vegagest = m_cPhName_tmp_vegagest+" "+m_Ctx.GetWritePhName("tmp_vegagest");
    }
    m_cServer_tmp_vegagest = p_ContextObject.GetServer("tmp_vegagest");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_joginfo = p_ContextObject.GetPhName("joginfo");
    if (m_cPhName_joginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_joginfo = m_cPhName_joginfo+" "+m_Ctx.GetWritePhName("joginfo");
    }
    m_cServer_joginfo = p_ContextObject.GetServer("joginfo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_soginfo = p_ContextObject.GetPhName("soginfo");
    if (m_cPhName_soginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_soginfo = m_cPhName_soginfo+" "+m_Ctx.GetWritePhName("soginfo");
    }
    m_cServer_soginfo = p_ContextObject.GetServer("soginfo");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_decodecitta = p_ContextObject.GetPhName("decodecitta");
    if (m_cPhName_decodecitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_decodecitta = m_cPhName_decodecitta+" "+m_Ctx.GetWritePhName("decodecitta");
    }
    m_cServer_decodecitta = p_ContextObject.GetServer("decodecitta");
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
      return "arrt_impxls_decodecomuni";
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
    if (CPLib.eqr("_prv",p_cVarName)) {
      return _prv;
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
    if (CPLib.eqr("_prv",p_cVarName)) {
      _prv = value;
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
    CPResultSet Cursor_tbcitta=null;
    try {
      /* Dichiarazione variabili del caller */
      /* pNome Char(80) */
      /* Definizione variabili locali */
      /* _id Numeric(10, 0) */
      /* _comune Char(40) */
      /* _idb Char(10) */
      /* _prv Char(2) */
      /* column01 Char(25) */
      /* column02 Char(25) */
      /* column03 Char(25) */
      /* column04 Char(25) */
      /* column05 Char(25) */
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
          Cell a05 = sheet.getCell(4,_y);
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
          /* _id := Val(column01) */
          _id = CPLib.Round(CPLib.Val(column01),0);
          /* _comune := LRTrim(column03) */
          _comune = CPLib.LRTrim(column03);
          /* _prv := LRTrim(column04) */
          _prv = CPLib.LRTrim(column04);
          /* _idb := '' */
          _idb = "";
          /* If not(Empty(LRTrim(_comune))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(_comune)))) {
            // * --- Read from tbcitta
            m_cServer = m_Ctx.GetServer("tbcitta");
            m_cPhName = m_Ctx.GetPhName("tbcitta");
            m_cSql = "";
            m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_comune,"C",60,0,m_cServer),m_cServer,_comune);
            m_cSql = m_cSql+" and PROV="+CPSql.SQLValueAdapter(CPLib.ToSQL(_prv,"C",2,0,m_cServer),m_cServer,_prv);
            if (m_Ctx.IsSharedTemp("tbcitta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _idb = Read_Cursor.GetString("IDBASE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_impxls_decodecomuni returns two or more records. This item should return only a record.");
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
              // * --- Select from tbcitta
              m_cServer = m_Ctx.GetServer("tbcitta");
              m_cPhName = m_Ctx.GetPhName("tbcitta");
              if (Cursor_tbcitta!=null)
                Cursor_tbcitta.Close();
              Cursor_tbcitta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idb,"?",0,0,m_cServer, m_oParameters),m_cServer,_idb)+" "+")"+(m_Ctx.IsSharedTemp("tbcitta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_tbcitta.Eof())) {
                // * --- Write into DecodeCitta from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("DecodeCitta");
                m_cPhName = m_Ctx.GetPhName("DecodeCitta");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"DecodeCitta",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_impxls_decodecomuni",72,"0000002A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"CITTAMIT = "+CPLib.ToSQL(Cursor_tbcitta.GetString("CITTA"),"C",60,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAB = "+CPLib.ToSQL(Cursor_tbcitta.GetString("CAB"),"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROV = "+CPLib.ToSQL(Cursor_tbcitta.GetString("PROV"),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAPMIT = "+CPLib.ToSQL(Cursor_tbcitta.GetString("CAP"),"C",9,0,m_cServer)+", ";
                m_cSql = m_cSql+"PKTBSTATI = "+CPLib.ToSQL(Cursor_tbcitta.GetString("PKTBSTATI"),"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"SIGLA = "+CPLib.ToSQL(Cursor_tbcitta.GetString("SIGLA"),"C",4,0,m_cServer)+", ";
                m_cSql = m_cSql+"PREF = "+CPLib.ToSQL(Cursor_tbcitta.GetString("PREF"),"C",4,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDTBLS = "+CPLib.ToSQL(Cursor_tbcitta.GetString("IDTBLS"),"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(_idb,"C",10,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"DecodeCitta",false,true);
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
                Cursor_tbcitta.Next();
              }
              m_cConnectivityError = Cursor_tbcitta.ErrorMessage();
              Cursor_tbcitta.Close();
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
        if (Cursor_tbcitta!=null)
          Cursor_tbcitta.Close();
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
  public static arrt_impxls_decodecomuniR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_impxls_decodecomuniR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pNome = CPLib.Space(80);
    _id = 0;
    _comune = CPLib.Space(40);
    _idb = CPLib.Space(10);
    _prv = CPLib.Space(2);
    column01 = CPLib.Space(25);
    column02 = CPLib.Space(25);
    column03 = CPLib.Space(25);
    column04 = CPLib.Space(25);
    column05 = CPLib.Space(25);
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
