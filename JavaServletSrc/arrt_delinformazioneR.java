// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_delinformazioneR implements CallerWithObjs {
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
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
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
  public String w_RAPPORTO;
  public String w_TIPOOPRAP;
  public java.sql.Date w_DATAVARIA;
  public String gSblocco;
  public String _idreg;
  public java.sql.Date _dataope;
  public String _numprog;
  public String _statoreg;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_delinformazioneR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_delinformazione",m_Caller);
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
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
      return "arrt_delinformazione";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("IDBASE",p_cVarName)) {
      return w_IDBASE;
    }
    if (CPLib.eqr("RAPPORTO",p_cVarName)) {
      return w_RAPPORTO;
    }
    if (CPLib.eqr("TIPOOPRAP",p_cVarName)) {
      return w_TIPOOPRAP;
    }
    if (CPLib.eqr("gSblocco",p_cVarName)) {
      return gSblocco;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      return _idreg;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      return _numprog;
    }
    if (CPLib.eqr("_statoreg",p_cVarName)) {
      return _statoreg;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DATAVARIA",p_cVarName)) {
      return w_DATAVARIA;
    }
    if (CPLib.eqr("_dataope",p_cVarName)) {
      return _dataope;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("IDBASE",p_cVarName)) {
      w_IDBASE = value;
      return;
    }
    if (CPLib.eqr("RAPPORTO",p_cVarName)) {
      w_RAPPORTO = value;
      return;
    }
    if (CPLib.eqr("TIPOOPRAP",p_cVarName)) {
      w_TIPOOPRAP = value;
      return;
    }
    if (CPLib.eqr("gSblocco",p_cVarName)) {
      gSblocco = value;
      return;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      _idreg = value;
      return;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      _numprog = value;
      return;
    }
    if (CPLib.eqr("_statoreg",p_cVarName)) {
      _statoreg = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DATAVARIA",p_cVarName)) {
      w_DATAVARIA = value;
      return;
    }
    if (CPLib.eqr("_dataope",p_cVarName)) {
      _dataope = value;
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
      /* Variabili del caller */
      /* w_IDBASE Char(10) // Idbase */
      /* w_RAPPORTO Char(25) */
      /* w_TIPOOPRAP Char(2) */
      /* w_DATAVARIA Date */
      /* Variabili Globali */
      /* gSblocco Char(1) // Sblocco controllo */
      /* Variabili locali */
      /* _idreg Char(20) */
      /* _dataope Date // dataoperazione */
      /* _numprog Char(11) */
      /* _statoreg Char(1) */
      /* If gSblocco='N' */
      if (CPLib.eqr(gSblocco,"N")) {
        /* _numprog := '' */
        _numprog = "";
        /* _dataope := NullDate() // dataoperazione */
        _dataope = CPLib.NullDate();
        /* _statoreg := '' */
        _statoreg = "";
        // * --- Read from rapopebo
        m_cServer = m_Ctx.GetServer("rapopebo");
        m_cPhName = m_Ctx.GetPhName("rapopebo");
        m_cSql = "";
        m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"C",10,0,m_cServer),m_cServer,w_IDBASE);
        if (m_Ctx.IsSharedTemp("rapopebo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DATAOPE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("STATOREG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _dataope = Read_Cursor.GetDate("DATAOPE");
          _numprog = Read_Cursor.GetString("NUMPROG");
          _statoreg = Read_Cursor.GetString("STATOREG");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on rapopebo into routine arrt_delinformazione returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _dataope = CPLib.NullDate();
          _numprog = "";
          _statoreg = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If At(_statoreg,"|0|1|") <> 0 */
        if (CPLib.ne(CPLib.At(_statoreg,"|0|1|"),0)) {
          // * --- Write into rapopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_delinformazione",49,"00000013")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("2","C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
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
          }
          /* If w_TIPOOPRAP='25' */
          if (CPLib.eqr(w_TIPOOPRAP,"25")) {
            // * --- Write into delegabo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("delegabo");
            m_cPhName = m_Ctx.GetPhName("delegabo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"delegabo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_delinformazione",49,"00000015")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
            m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("2","C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"delegabo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMPROG1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer),m_cServer,_numprog)+"";
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
            /* ElseIf w_TIPOOPRAP='28' */
          } else if (CPLib.eqr(w_TIPOOPRAP,"28")) {
            /* If _numprog <> '' */
            if (CPLib.ne(_numprog,"")) {
              // * --- Write into delegabo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("delegabo");
              m_cPhName = m_Ctx.GetPhName("delegabo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"delegabo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_delinformazione",49,"00000017")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
              m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(CPLib.NullString(),"C",11,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"delegabo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"NUMPROG2 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer),m_cServer,_numprog)+"";
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
            } // End If
            /* ElseIf w_TIPOOPRAP='23' */
          } else if (CPLib.eqr(w_TIPOOPRAP,"23")) {
            /* If _numprog <> '' */
            if (CPLib.ne(_numprog,"")) {
              // * --- Write into intestbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_delinformazione",49,"00000019")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("2","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"NUMPROG1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer),m_cServer,_numprog)+"";
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
            } // End If
            /* ElseIf w_TIPOOPRAP='26' */
          } else if (CPLib.eqr(w_TIPOOPRAP,"26")) {
            // * --- Write into intestbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_delinformazione",49,"0000001A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
            m_cSql = m_cSql+"NUMPROG2 = "+CPLib.ToSQL(CPLib.NullString(),"C",11,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMPROG2 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer),m_cServer,_numprog)+"";
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
          } // End If
        } else { // Else
          // Transaction Error
          m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"Impossibile cancellare un'informazione già cancellata o copia di modifica!"));
          throw new RoutineException(CPLib.FormatMsg(m_Ctx,"Impossibile cancellare un'informazione già cancellata o copia di modifica!"));
        } // End If
      } else { // Else
        // * --- Delete from rapopebo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("rapopebo");
        m_cPhName = m_Ctx.GetPhName("rapopebo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_delinformazione",49,"0000001C")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        }
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
      m_Caller.SetString("IDBASE","C",10,0,w_IDBASE);
      m_Caller.SetString("RAPPORTO","C",25,0,w_RAPPORTO);
      m_Caller.SetString("TIPOOPRAP","C",2,0,w_TIPOOPRAP);
      m_Caller.SetDate("DATAVARIA","D",8,0,w_DATAVARIA);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_delinformazioneR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_delinformazioneR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_IDBASE = m_Caller.GetString("IDBASE","C",10,0);
    w_RAPPORTO = m_Caller.GetString("RAPPORTO","C",25,0);
    w_TIPOOPRAP = m_Caller.GetString("TIPOOPRAP","C",2,0);
    w_DATAVARIA = m_Caller.GetDate("DATAVARIA","D",8,0);
    _idreg = CPLib.Space(20);
    _dataope = CPLib.NullDate();
    _numprog = CPLib.Space(11);
    _statoreg = CPLib.Space(1);
    gSblocco=m_Ctx.GetGlobalString("gSblocco");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
