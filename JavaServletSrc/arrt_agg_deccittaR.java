// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_agg_deccittaR implements CallerWithObjs {
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
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tmp_decodecitta;
  public String m_cServer_tmp_decodecitta;
  public String m_cPhName_decodecitta;
  public String m_cServer_decodecitta;
  public String m_cPhName_yperazbo;
  public String m_cServer_yperazbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
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
  public String cProg1;
  public String cProg2;
  public double nProg;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_agg_deccittaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_agg_deccitta",m_Caller);
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tmp_decodecitta = p_ContextObject.GetPhName("tmp_decodecitta");
    if (m_cPhName_tmp_decodecitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_decodecitta = m_cPhName_tmp_decodecitta+" "+m_Ctx.GetWritePhName("tmp_decodecitta");
    }
    m_cServer_tmp_decodecitta = p_ContextObject.GetServer("tmp_decodecitta");
    m_cPhName_decodecitta = p_ContextObject.GetPhName("decodecitta");
    if (m_cPhName_decodecitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_decodecitta = m_cPhName_decodecitta+" "+m_Ctx.GetWritePhName("decodecitta");
    }
    m_cServer_decodecitta = p_ContextObject.GetServer("decodecitta");
    m_cPhName_yperazbo = p_ContextObject.GetPhName("yperazbo");
    if (m_cPhName_yperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_yperazbo = m_cPhName_yperazbo+" "+m_Ctx.GetWritePhName("yperazbo");
    }
    m_cServer_yperazbo = p_ContextObject.GetServer("yperazbo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("nProg",p_cVarName)) {
      return nProg;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_agg_deccitta";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("cProg1",p_cVarName)) {
      return cProg1;
    }
    if (CPLib.eqr("cProg2",p_cVarName)) {
      return cProg2;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
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
    if (CPLib.eqr("nProg",p_cVarName)) {
      nProg = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("cProg1",p_cVarName)) {
      cProg1 = value;
      return;
    }
    if (CPLib.eqr("cProg2",p_cVarName)) {
      cProg2 = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    CPResultSet Cursor_tmp_decodecitta=null;
    CPResultSet Cursor_tbcitta=null;
    try {
      /* cProg1 Char(10) */
      /* cProg2 Char(11) */
      /* nProg Numeric(10, 0) */
      /* gAzienda Char(10) // Azienda */
      /* Esegue la decodifica degli stati e trasferisce le operazioni */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000009status;
      nTry00000009status = m_Sql.GetTransactionStatus();
      String cTry00000009msg;
      cTry00000009msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from tmp_decodecitta
        m_cServer = m_Ctx.GetServer("tmp_decodecitta");
        m_cPhName = m_Ctx.GetPhName("tmp_decodecitta");
        if (Cursor_tmp_decodecitta!=null)
          Cursor_tmp_decodecitta.Close();
        Cursor_tmp_decodecitta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_decodecitta")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_tmp_decodecitta.Eof())) {
          /* If not(Empty(LRTrim(tmp_decodecitta->SIGLA))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_tmp_decodecitta.GetString("SIGLA"))))) {
            // * --- Select from tbcitta
            m_cServer = m_Ctx.GetServer("tbcitta");
            m_cPhName = m_Ctx.GetPhName("tbcitta");
            if (Cursor_tbcitta!=null)
              Cursor_tbcitta.Close();
            Cursor_tbcitta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SIGLA="+CPLib.ToSQL(Cursor_tmp_decodecitta.GetString("SIGLA"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("tbcitta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_tbcitta.Eof())) {
              // * --- Write into DecodeCitta from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("DecodeCitta");
              m_cPhName = m_Ctx.GetPhName("DecodeCitta");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"DecodeCitta",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_deccitta",22,"0000000D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(Cursor_tbcitta.GetString("IDBASE"),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"CITTAMIT = "+CPLib.ToSQL(Cursor_tbcitta.GetString("CITTA"),"C",60,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAB = "+CPLib.ToSQL(Cursor_tbcitta.GetString("CAB"),"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROV = "+CPLib.ToSQL(Cursor_tbcitta.GetString("PROV"),"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"CAPMIT = "+CPLib.ToSQL(Cursor_tbcitta.GetString("CAP"),"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"PKTBSTATI = "+CPLib.ToSQL(Cursor_tbcitta.GetString("PKTBSTATI"),"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"SIGLA = "+CPLib.ToSQL(Cursor_tbcitta.GetString("SIGLA"),"C",4,0,m_cServer)+", ";
              m_cSql = m_cSql+"PREF = "+CPLib.ToSQL(Cursor_tbcitta.GetString("PREF"),"C",4,0,m_cServer)+", ";
              m_cSql = m_cSql+"IDTBLS = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"DecodeCitta",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"ID = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_decodecitta.GetDouble("ID"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_decodecitta.GetDouble("ID"))+"";
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
              Cursor_tbcitta.Next();
            }
            m_cConnectivityError = Cursor_tbcitta.ErrorMessage();
            Cursor_tbcitta.Close();
            // * --- End Select
            // * --- Delete from tmp_decodecitta
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_decodecitta");
            m_cPhName = m_Ctx.GetPhName("tmp_decodecitta");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_decodecitta",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_agg_deccitta",22,"0000000E")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"ID = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_decodecitta.GetDouble("ID"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_decodecitta.GetDouble("ID"))+"";
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
          Cursor_tmp_decodecitta.Next();
        }
        m_cConnectivityError = Cursor_tmp_decodecitta.ErrorMessage();
        Cursor_tmp_decodecitta.Close();
        // * --- End Select
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000009status,0)) {
          m_Sql.SetTransactionStatus(nTry00000009status,cTry00000009msg);
        }
      }
      /* Stop arpg_agg_deccitta */
      Forward f;
      f=new Forward("arpg_agg_deccitta",false,this,Forward.Start,false);
      f.SetParameter("m_cParameterSequence", "");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_tmp_decodecitta!=null)
          Cursor_tmp_decodecitta.Close();
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
  public static arrt_agg_deccittaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_agg_deccittaR(p_Ctx, p_Caller);
  }
  public void Blank() {
    cProg1 = CPLib.Space(10);
    cProg2 = CPLib.Space(11);
    nProg = 0;
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
