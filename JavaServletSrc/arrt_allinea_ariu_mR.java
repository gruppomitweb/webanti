// * --- Area Manuale = BO - Header
// * --- arrt_allinea_ariu_m
import java.io.File; 
import java.lang.Double;
import jxl.*;
// * --- Fine Area Manuale
public class arrt_allinea_ariu_mR implements CallerWithObjs {
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
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
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
  public String cRapporto;
  public double _nrighe;
  public String _tiprap;
  public String cID;
  public double _numriga;
  public double xRiga;
  public String _setsin;
  public String gAzienda;
  public String gPathApp;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_allinea_ariu_m
  public int _i;
  public int _y;
  public int _righe;
  public int conta;
  // * --- Fine Area Manuale
  public arrt_allinea_ariu_mR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_allinea_ariu_m",m_Caller);
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
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_nrighe",p_cVarName)) {
      return _nrighe;
    }
    if (CPLib.eqr("_numriga",p_cVarName)) {
      return _numriga;
    }
    if (CPLib.eqr("xRiga",p_cVarName)) {
      return xRiga;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_allinea_ariu_m";
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
    if (CPLib.eqr("cRapporto",p_cVarName)) {
      return cRapporto;
    }
    if (CPLib.eqr("_tiprap",p_cVarName)) {
      return _tiprap;
    }
    if (CPLib.eqr("cID",p_cVarName)) {
      return cID;
    }
    if (CPLib.eqr("_setsin",p_cVarName)) {
      return _setsin;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
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
    if (CPLib.eqr("_nrighe",p_cVarName)) {
      _nrighe = value;
      return;
    }
    if (CPLib.eqr("_numriga",p_cVarName)) {
      _numriga = value;
      return;
    }
    if (CPLib.eqr("xRiga",p_cVarName)) {
      xRiga = value;
      return;
    }
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
    if (CPLib.eqr("cRapporto",p_cVarName)) {
      cRapporto = value;
      return;
    }
    if (CPLib.eqr("_tiprap",p_cVarName)) {
      _tiprap = value;
      return;
    }
    if (CPLib.eqr("cID",p_cVarName)) {
      cID = value;
      return;
    }
    if (CPLib.eqr("_setsin",p_cVarName)) {
      _setsin = value;
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
    CPResultSet Cursor_xntestbo=null;
    try {
      /* nomefile Char(30) */
      /* column01 Char(25) */
      /* column02 Char(25) */
      /* column03 Char(25) */
      /* column04 Char(25) */
      /* column05 Char(25) */
      /* column06 Char(25) */
      /* column07 Char(25) */
      /* cRapporto Char(25) */
      /* _nrighe Numeric(3, 0) */
      /* _tiprap Char(1) */
      /* cID Char(10) */
      /* _numriga Numeric(4, 0) */
      /* xRiga Numeric(10, 0) */
      /* _setsin Char(3) */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      //base
      Workbook workbook = Workbook.getWorkbook(new File(CPLib.LRTrim(gPathApp)+"/appo/ariu_allinea.xls"));
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
          // Lettura colonne
          Cell a01 = sheet.getCell(0,_y);
          Cell a02 = sheet.getCell(1,_y);
          Cell a03 = sheet.getCell(2,_y);
          Cell a04 = sheet.getCell(3,_y);
          Cell a05 = sheet.getCell(4,_y);
          Cell a06 = sheet.getCell(5,_y);
          Cell a07 = sheet.getCell(6,_y);
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
          // * --- Write into xnarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xnarapbo");
          m_cPhName = m_Ctx.GetPhName("xnarapbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xnarapbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_ariu_m",74,"00000024")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"SPLITCODE = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column03),15),"C",15,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xnarapbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(CPLib.LRTrim(column01),25)),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(CPLib.Left(CPLib.LRTrim(column01),25)))+"";
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
          // * --- Select from xntestbo
          m_cServer = m_Ctx.GetServer("xntestbo");
          m_cPhName = m_Ctx.GetPhName("xntestbo");
          if (Cursor_xntestbo!=null)
            Cursor_xntestbo.Close();
          Cursor_xntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column01),25),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(CPLib.LRTrim(column01),25))+" "+")"+(m_Ctx.IsSharedTemp("xntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xntestbo.Eof())) {
            /* If Empty(LRTrim(Left(LRTrim(column07),3))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Left(CPLib.LRTrim(column07),3)))) {
              /* _setsin := arfn_calcolasett(Left(LRTrim(column06),3),Left(LRTrim(column05),3),'') */
              _setsin = arfn_calcolasettR.Make(m_Ctx,this).Run(CPLib.Left(CPLib.LRTrim(column06),3),CPLib.Left(CPLib.LRTrim(column05),3),"");
            } else { // Else
              /* _setsin := Left(LRTrim(column07),3) */
              _setsin = CPLib.Left(CPLib.LRTrim(column07),3);
            } // End If
            // * --- Write into personbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_ariu_m",74,"00000029")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column06),3),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column05),3),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(_setsin,"C",3,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_xntestbo.GetString("CODINTER"),"?",0,0,m_cServer),m_cServer,Cursor_xntestbo.GetString("CODINTER"))+"";
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
            Cursor_xntestbo.Next();
          }
          m_cConnectivityError = Cursor_xntestbo.ErrorMessage();
          Cursor_xntestbo.Close();
          // * --- End Select
          _y++;
        } // End While
        _i++;
      } // End While
      /* workbook.close() */
      workbook.close();
    } finally {
      try {
        if (Cursor_xntestbo!=null)
          Cursor_xntestbo.Close();
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
  public static arrt_allinea_ariu_mR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_allinea_ariu_mR(p_Ctx, p_Caller);
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
    cRapporto = CPLib.Space(25);
    _nrighe = 0;
    _tiprap = CPLib.Space(1);
    cID = CPLib.Space(10);
    _numriga = 0;
    xRiga = 0;
    _setsin = CPLib.Space(3);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_calcolasett,
  public static final String i_InvokedRoutines = ",arfn_calcolasett,";
  public static String[] m_cRunParameterNames={};
}
