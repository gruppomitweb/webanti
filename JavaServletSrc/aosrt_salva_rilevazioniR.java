// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class aosrt_salva_rilevazioniR implements CallerWithObjs {
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
  public String m_cPhName_rilevazione;
  public String m_cServer_rilevazione;
  public String m_cPhName_ano_ril;
  public String m_cServer_ano_ril;
  public String m_cPhName_rilevazioni;
  public String m_cServer_rilevazioni;
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
  public String pConnes;
  public java.sql.Date pData;
  public String pModello;
  public String pTipo;
  public double _riga;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public aosrt_salva_rilevazioniR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("aosrt_salva_rilevazioni",m_Caller);
    m_cPhName_rilevazione = p_ContextObject.GetPhName("rilevazione");
    if (m_cPhName_rilevazione.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rilevazione = m_cPhName_rilevazione+" "+m_Ctx.GetWritePhName("rilevazione");
    }
    m_cServer_rilevazione = p_ContextObject.GetServer("rilevazione");
    m_cPhName_ano_ril = p_ContextObject.GetPhName("ano_ril");
    if (m_cPhName_ano_ril.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_ano_ril = m_cPhName_ano_ril+" "+m_Ctx.GetWritePhName("ano_ril");
    }
    m_cServer_ano_ril = p_ContextObject.GetServer("ano_ril");
    m_cPhName_rilevazioni = p_ContextObject.GetPhName("rilevazioni");
    if (m_cPhName_rilevazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rilevazioni = m_cPhName_rilevazioni+" "+m_Ctx.GetWritePhName("rilevazioni");
    }
    m_cServer_rilevazioni = p_ContextObject.GetServer("rilevazioni");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_riga",p_cVarName)) {
      return _riga;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "aosrt_salva_rilevazioni";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pConnes",p_cVarName)) {
      return pConnes;
    }
    if (CPLib.eqr("pModello",p_cVarName)) {
      return pModello;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pData",p_cVarName)) {
      return pData;
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
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_riga",p_cVarName)) {
      _riga = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pConnes",p_cVarName)) {
      pConnes = value;
      return;
    }
    if (CPLib.eqr("pModello",p_cVarName)) {
      pModello = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pData",p_cVarName)) {
      pData = value;
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
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_rilevazione=null;
    CPResultSet Cursor_rilevazioni=null;
    try {
      /* pConnes Char(16) // NDG Soggetto */
      /* pData Date // Data Rilevazione */
      /* pModello Char(10) // Modello Rilevazione */
      /* pTipo Char(1) // Tipo Operazione */
      /* _riga Numeric(4, 0) */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000000Astatus;
      nTry0000000Astatus = m_Sql.GetTransactionStatus();
      String cTry0000000Amsg;
      cTry0000000Amsg = m_Sql.TransactionErrorMessage();
      try {
        /* _riga := 0 */
        _riga = CPLib.Round(0,0);
        // * --- Read from rilevazione
        m_cServer = m_Ctx.GetServer("rilevazione");
        m_cPhName = m_Ctx.GetPhName("rilevazione");
        m_cSql = "";
        m_cSql = m_cSql+"IDMOD="+CPSql.SQLValueAdapter(CPLib.ToSQL(pModello,"C",10,0,m_cServer),m_cServer,pModello);
        m_cSql = m_cSql+" and CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pConnes,"C",16,0,m_cServer),m_cServer,pConnes);
        m_cSql = m_cSql+" and DTRIL="+CPSql.SQLValueAdapter(CPLib.ToSQL(pData,"D",8,0,m_cServer),m_cServer,pData);
        if (m_Ctx.IsSharedTemp("rilevazione")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CPROWNUM",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _riga = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on rilevazione into routine aosrt_salva_rilevazioni returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _riga = 0;
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // * --- Delete from ano_ril
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("ano_ril");
        m_cPhName = m_Ctx.GetPhName("ano_ril");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"ano_ril",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("aosrt_salva_rilevazioni",4,"0000000D")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"IDMOD = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pModello,"?",0,0,m_cServer),m_cServer,pModello)+"";
        m_cSql = m_cSql+" and ROWRIL = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_riga,"?",0,0,m_cServer),m_cServer,_riga)+"";
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
        // * --- Delete from rilevazione
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("rilevazione");
        m_cPhName = m_Ctx.GetPhName("rilevazione");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rilevazione",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("aosrt_salva_rilevazioni",4,"0000000E")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"IDMOD = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pModello,"?",0,0,m_cServer),m_cServer,pModello)+"";
        m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_riga,"?",0,0,m_cServer),m_cServer,_riga)+"";
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
        /* If pTipo='S' */
        if (CPLib.eqr(pTipo,"S")) {
          /* _riga := 0 */
          _riga = CPLib.Round(0,0);
          // * --- Select from rilevazione
          m_cServer = m_Ctx.GetServer("rilevazione");
          m_cPhName = m_Ctx.GetPhName("rilevazione");
          if (Cursor_rilevazione!=null)
            Cursor_rilevazione.Close();
          Cursor_rilevazione = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CPROWNUM  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDMOD="+CPSql.SQLValueAdapter(CPLib.ToSQL(pModello,"?",0,0,m_cServer, m_oParameters),m_cServer,pModello)+" "+")"+(m_Ctx.IsSharedTemp("rilevazione")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"CPROWNUM desc ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_rilevazione.Eof())) {
            /* _riga := rilevazione->CPROWNUM */
            _riga = CPLib.Round(Cursor_rilevazione.GetDouble("CPROWNUM"),0);
            Cursor_rilevazione.Next();
          }
          m_cConnectivityError = Cursor_rilevazione.ErrorMessage();
          Cursor_rilevazione.Close();
          // * --- End Select
          /* _riga := _riga + 1 */
          _riga = CPLib.Round(_riga+1,0);
          // * --- Insert into rilevazione from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rilevazione");
          m_cPhName = m_Ctx.GetPhName("rilevazione");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rilevazione",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("aosrt_salva_rilevazioni",4,"00000014")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000014(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(pModello,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_riga,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(pConnes,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(pData,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("WEBANTI","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"rilevazione",true);
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
          // * --- Select from rilevazioni
          m_cServer = m_Ctx.GetServer("rilevazioni");
          m_cPhName = m_Ctx.GetPhName("rilevazioni");
          if (Cursor_rilevazioni!=null)
            Cursor_rilevazioni.Close();
          Cursor_rilevazioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pConnes,"?",0,0,m_cServer, m_oParameters),m_cServer,pConnes)+"  and  DTRIL="+CPSql.SQLValueAdapter(CPLib.ToSQL(pData,"?",0,0,m_cServer, m_oParameters),m_cServer,pData)+"  and  IDMOD="+CPSql.SQLValueAdapter(CPLib.ToSQL(pModello,"?",0,0,m_cServer, m_oParameters),m_cServer,pModello)+" "+")"+(m_Ctx.IsSharedTemp("rilevazioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_rilevazioni.Eof())) {
            // * --- Insert into ano_ril from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("ano_ril");
            m_cPhName = m_Ctx.GetPhName("ano_ril");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"ano_ril",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("aosrt_salva_rilevazioni",4,"00000016")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000016(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(pModello,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_riga,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rilevazioni.GetString("IDIND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rilevazioni.GetString("IDSUBIND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_rilevazioni.GetString("NOTA"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"ano_ril",true);
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
            Cursor_rilevazioni.Next();
          }
          m_cConnectivityError = Cursor_rilevazioni.ErrorMessage();
          Cursor_rilevazioni.Close();
          // * --- End Select
          /* ElseIf pTipo='D' */
        } else if (CPLib.eqr(pTipo,"D")) {
          // * --- Delete from rilevazioni
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rilevazioni");
          m_cPhName = m_Ctx.GetPhName("rilevazioni");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rilevazioni",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("aosrt_salva_rilevazioni",4,"00000017")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pConnes,"?",0,0,m_cServer),m_cServer,pConnes)+"";
          m_cSql = m_cSql+" and DTRIL = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pData,"?",0,0,m_cServer),m_cServer,pData)+"";
          m_cSql = m_cSql+" and IDMOD = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pModello,"?",0,0,m_cServer),m_cServer,pModello)+"";
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000000Astatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000000Astatus,cTry0000000Amsg);
        }
      }
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_rilevazione!=null)
          Cursor_rilevazione.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_rilevazioni!=null)
          Cursor_rilevazioni.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pConnes,java.sql.Date p_pData,String p_pModello,String p_pTipo) {
    pConnes = p_pConnes;
    pData = p_pData;
    pModello = p_pModello;
    pTipo = p_pTipo;
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
  public String Run(String p_pConnes,java.sql.Date p_pData,String p_pModello,String p_pTipo) {
    pConnes = p_pConnes;
    pData = p_pData;
    pModello = p_pModello;
    pTipo = p_pTipo;
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
  public static aosrt_salva_rilevazioniR Make(CPContext p_Ctx, Caller p_Caller) {
    return new aosrt_salva_rilevazioniR(p_Ctx, p_Caller);
  }
  public static aosrt_salva_rilevazioniR Make(CPContext p_Ctx) {
    return new aosrt_salva_rilevazioniR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pConnes = CPLib.Space(16);
    pData = CPLib.NullDate();
    pModello = CPLib.Space(10);
    pTipo = CPLib.Space(1);
    _riga = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,aosrt_salva_rilevazioni,
  public static final String i_InvokedRoutines = ",aosrt_salva_rilevazioni,";
  public static String[] m_cRunParameterNames={"pConnes","pData","pModello","pTipo"};
  protected static String GetFieldsName_00000014(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDMOD,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"DTRIL,";
    p_cSql = p_cSql+"PROVENIENZA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rilevazione",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000016(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDMOD,";
    p_cSql = p_cSql+"ROWRIL,";
    p_cSql = p_cSql+"IDIND,";
    p_cSql = p_cSql+"IDSUBIND,";
    p_cSql = p_cSql+"NOTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"ano_ril",true);
    return p_cSql;
  }
}
