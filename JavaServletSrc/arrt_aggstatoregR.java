// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_aggstatoregR implements CallerWithObjs {
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
  // I messaggi vengono instradati su questo oggetto
  public CPMessageSink m_MessageSink;
  public com.zucchetti.sitepainter.Logger m_Debug;
  public com.zucchetti.sitepainter.Logger m_Info;
  public com.zucchetti.sitepainter.Logger m_Warning;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
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
  public String w_IDBASE;
  public String w_STATOREG;
  public String w_NUMPROG;
  public java.sql.Date w_DATAOPE;
  public java.sql.Date w_DATAREG;
  public java.sql.Date w_DATARETT;
  public String pFile;
  public String pOper;
  public String gSblocco;
  public java.sql.Date gDataVaria;
  public String _stato;
  public String _idreg;
  public java.sql.Date _dataret;
  public String _statoreg;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_aggstatoregR (CPContext p_ContextObject, Caller caller) {
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
    // I messaggi vengono instradati su questo oggetto
    m_MessageSink = CPMessageSink.SinkFromCaller(m_Caller);
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_aggstatoreg",m_Caller);
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
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
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
      return "arrt_aggstatoreg";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("IDBASE",p_cVarName)) {
      return w_IDBASE;
    }
    if (CPLib.eqr("STATOREG",p_cVarName)) {
      return w_STATOREG;
    }
    if (CPLib.eqr("NUMPROG",p_cVarName)) {
      return w_NUMPROG;
    }
    if (CPLib.eqr("pFile",p_cVarName)) {
      return pFile;
    }
    if (CPLib.eqr("pOper",p_cVarName)) {
      return pOper;
    }
    if (CPLib.eqr("gSblocco",p_cVarName)) {
      return gSblocco;
    }
    if (CPLib.eqr("_stato",p_cVarName)) {
      return _stato;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      return _idreg;
    }
    if (CPLib.eqr("_statoreg",p_cVarName)) {
      return _statoreg;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DATAOPE",p_cVarName)) {
      return w_DATAOPE;
    }
    if (CPLib.eqr("DATAREG",p_cVarName)) {
      return w_DATAREG;
    }
    if (CPLib.eqr("DATARETT",p_cVarName)) {
      return w_DATARETT;
    }
    if (CPLib.eqr("gDataVaria",p_cVarName)) {
      return gDataVaria;
    }
    if (CPLib.eqr("_dataret",p_cVarName)) {
      return _dataret;
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
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("IDBASE",p_cVarName)) {
      w_IDBASE = value;
      return;
    }
    if (CPLib.eqr("STATOREG",p_cVarName)) {
      w_STATOREG = value;
      return;
    }
    if (CPLib.eqr("NUMPROG",p_cVarName)) {
      w_NUMPROG = value;
      return;
    }
    if (CPLib.eqr("pFile",p_cVarName)) {
      pFile = value;
      return;
    }
    if (CPLib.eqr("pOper",p_cVarName)) {
      pOper = value;
      return;
    }
    if (CPLib.eqr("gSblocco",p_cVarName)) {
      gSblocco = value;
      return;
    }
    if (CPLib.eqr("_stato",p_cVarName)) {
      _stato = value;
      return;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      _idreg = value;
      return;
    }
    if (CPLib.eqr("_statoreg",p_cVarName)) {
      _statoreg = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DATAOPE",p_cVarName)) {
      w_DATAOPE = value;
      return;
    }
    if (CPLib.eqr("DATAREG",p_cVarName)) {
      w_DATAREG = value;
      return;
    }
    if (CPLib.eqr("DATARETT",p_cVarName)) {
      w_DATARETT = value;
      return;
    }
    if (CPLib.eqr("gDataVaria",p_cVarName)) {
      gDataVaria = value;
      return;
    }
    if (CPLib.eqr("_dataret",p_cVarName)) {
      _dataret = value;
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
    try {
      /* w_IDBASE Char(10) // Idbase */
      /* w_STATOREG Char(1) // Stato registrazione */
      /* w_NUMPROG Char(11) // Numero Progressivo */
      /* w_DATAOPE Date // Data Operazione */
      /* w_DATAREG Date // Data registrazione */
      /* w_DATARETT Date // Data Rettifica */
      /* Parametri */
      /* pFile Char(8) */
      /* pOper Char(4) */
      /* Definizione variabili locali */
      /* gSblocco Char(1) // Sblocco controllo */
      /* gDataVaria Date // Data Variazione */
      /* _stato Char(1) */
      /* _idreg Char(20) */
      /* _dataret Date */
      /* _statoreg Char(1) */
      /* Verifica lo stato */
      /* If gSblocco='N' */
      if (CPLib.eqr(gSblocco,"N")) {
        /* _dataret := gDataVaria */
        _dataret = gDataVaria;
        /* If pOper='CANC' */
        if (CPLib.eqr(pOper,"CANC")) {
          /* _stato := '2' */
          _stato = "2";
          /* ElseIf pOper='EDIT' */
        } else if (CPLib.eqr(pOper,"EDIT")) {
          /* _stato := '1' */
          _stato = "1";
        } // End If
        /* Modificato perchè l'ultimo valore di idereg in caso di modifica su operazbo e fraziobo deve corrispondere allo statoreg.
           Solo nel caso di primo inserimento inserimento si mette S o Z a seconda se si tratta di operazbo o fraziobo. */
        /* Case pFile = 'OPERAZBO' */
        if (CPLib.eqr(pFile,"OPERAZBO")) {
          /* If pOper='CANC' */
          if (CPLib.eqr(pOper,"CANC")) {
            /* _statoreg := '' */
            _statoreg = "";
            // * --- Read from operazbo
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_cSql = "";
            m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"C",10,0,m_cServer),m_cServer,w_IDBASE);
            if (m_Ctx.IsSharedTemp("operazbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("STATOREG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _statoreg = Read_Cursor.GetString("STATOREG");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on operazbo into routine arrt_aggstatoreg returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _statoreg = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If At(_statoreg,'|0|1') <> 0 */
            if (CPLib.ne(CPLib.At(_statoreg,"|0|1"),0)) {
              // * --- Write into operazbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("operazbo");
              m_cPhName = m_Ctx.GetPhName("operazbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_aggstatoreg",27,"0000001E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL(_stato,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"?",0,0,m_cServer),m_cServer,w_IDBASE)+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                m_cLastMsgError = "'Capperi non scrive correttamente'";
              }
            } else { // Else
              /* Status Msg iif(_statoreg='2',"Impossibile cancellare un'operazione già cancellata","Impossibile cancellare un'operazione copia di rettifica") */
              m_MessageSink.SendMessage((CPLib.eqr(_statoreg,"2")?"Impossibile cancellare un'operazione già cancellata":"Impossibile cancellare un'operazione copia di rettifica"));
            } // End If
          } else { // Else
            // * --- Write into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_aggstatoreg",27,"00000020")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL(_stato,"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"?",0,0,m_cServer),m_cServer,w_IDBASE)+"";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
              m_cLastMsgError = "'Capperi non scrive correttamente'";
            }
          } // End If
          /* Case pFile = 'FRAZIOBO' */
        } else if (CPLib.eqr(pFile,"FRAZIOBO")) {
          // * --- Write into fraziobo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_aggstatoreg",27,"00000021")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL(_stato,"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(_dataret,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"?",0,0,m_cServer),m_cServer,w_IDBASE)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            m_cLastMsgError = "'Capperi  non scrive correttamente'";
          }
          /* Case pFile = 'RAPOPEBO' */
        } else if (CPLib.eqr(pFile,"RAPOPEBO")) {
          // * --- Write into rapopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_aggstatoreg",27,"00000022")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL(_stato,"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(_dataret,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapopebo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"?",0,0,m_cServer),m_cServer,w_IDBASE)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            m_cLastMsgError = "'Capperi  non scrive correttamente'";
          }
          /* Case pFile = 'RAPOTIT' */
        } else if (CPLib.eqr(pFile,"RAPOTIT")) {
          // * --- Write into rapotit from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rapotit");
          m_cPhName = m_Ctx.GetPhName("rapotit");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_aggstatoreg",27,"00000023")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL(_stato,"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(_dataret,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapotit",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"?",0,0,m_cServer),m_cServer,w_IDBASE)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            m_cLastMsgError = "'Capperi  non scrive correttamente'";
          }
        } // End Case
      } // End If
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pFile,String p_pOper) {
    pFile = p_pFile;
    pOper = p_pOper;
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
    );
  }
  public Forward Run(String p_pFile,String p_pOper) {
    pFile = p_pFile;
    pOper = p_pOper;
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
      m_Caller.SetString("IDBASE","C",10,0,w_IDBASE);
      m_Caller.SetString("STATOREG","C",1,0,w_STATOREG);
      m_Caller.SetString("NUMPROG","C",11,0,w_NUMPROG);
      m_Caller.SetDate("DATAOPE","D",8,0,w_DATAOPE);
      m_Caller.SetDate("DATAREG","D",8,0,w_DATAREG);
      m_Caller.SetDate("DATARETT","D",8,0,w_DATARETT);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_aggstatoregR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_aggstatoregR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_IDBASE = m_Caller.GetString("IDBASE","C",10,0);
    w_STATOREG = m_Caller.GetString("STATOREG","C",1,0);
    w_NUMPROG = m_Caller.GetString("NUMPROG","C",11,0);
    w_DATAOPE = m_Caller.GetDate("DATAOPE","D",8,0);
    w_DATAREG = m_Caller.GetDate("DATAREG","D",8,0);
    w_DATARETT = m_Caller.GetDate("DATARETT","D",8,0);
    pFile = CPLib.Space(8);
    pOper = CPLib.Space(4);
    _stato = CPLib.Space(1);
    _idreg = CPLib.Space(20);
    _dataret = CPLib.NullDate();
    _statoreg = CPLib.Space(1);
    gSblocco=m_Ctx.GetGlobalString("gSblocco");
    gDataVaria=m_Ctx.GetGlobalDate("gDataVaria");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pFile","pOper"};
}
