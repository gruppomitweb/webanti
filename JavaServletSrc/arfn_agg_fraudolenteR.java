// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_agg_fraudolenteR implements CallerWithObjs {
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
  public String m_cPhName_analisi_sv;
  public String m_cServer_analisi_sv;
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
  public double pAnno;
  public double pTri;
  public String gMsgImp;
  public String gMsgProc;
  public String _datinisem;
  public String _datfinsem;
  public MemoryCursor_qbe_ope_fraudolente_vqr mcFraudo;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_agg_fraudolenteR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_agg_fraudolente",m_Caller);
    m_cPhName_analisi_sv = p_ContextObject.GetPhName("analisi_sv");
    if (m_cPhName_analisi_sv.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_analisi_sv = m_cPhName_analisi_sv+" "+m_Ctx.GetWritePhName("analisi_sv");
    }
    m_cServer_analisi_sv = p_ContextObject.GetServer("analisi_sv");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pAnno",p_cVarName)) {
      return pAnno;
    }
    if (CPLib.eqr("pTri",p_cVarName)) {
      return pTri;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_agg_fraudolente";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("_datinisem",p_cVarName)) {
      return _datinisem;
    }
    if (CPLib.eqr("_datfinsem",p_cVarName)) {
      return _datfinsem;
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
    if (CPLib.eqr("mcFraudo",p_cVarName)) {
      return mcFraudo;
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
    if (CPLib.eqr("pAnno",p_cVarName)) {
      pAnno = value;
      return;
    }
    if (CPLib.eqr("pTri",p_cVarName)) {
      pTri = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("_datinisem",p_cVarName)) {
      _datinisem = value;
      return;
    }
    if (CPLib.eqr("_datfinsem",p_cVarName)) {
      _datfinsem = value;
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
    if (CPLib.eqr("mcFraudo",p_cVarName)) {
      mcFraudo = (MemoryCursor_qbe_ope_fraudolente_vqr)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_ope_fraudolente=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pAnno Numeric(4, 0) // Anno di riferimento */
      /* pTri Numeric(1, 0) // Trimestre */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio */
      /* _datinisem Char(8) // Data Inizio Semestre */
      /* _datfinsem Char(8) // Data Fine Semestre */
      /* mcFraudo MemoryCursor(qbe_ope_fraudolente.vqr) */
      /* Case pTri=2 */
      if (CPLib.eqr(pTri,2)) {
        /* voce semestrale per IP */
        /* _datinisem := Str(pAnno,4,0)+'0101' // Data Inizio Semestre */
        _datinisem = CPLib.Str(pAnno,4,0)+"0101";
        /* _datfinsem := Str(pAnno,4,0)+'0630' // Data Fine Semestre */
        _datfinsem = CPLib.Str(pAnno,4,0)+"0630";
        /* Case pTri=4 */
      } else if (CPLib.eqr(pTri,4)) {
        /* voce semestrale per IP */
        /* _datinisem := Str(pAnno,4,0)+'0701' // Data Inizio Semestre */
        _datinisem = CPLib.Str(pAnno,4,0)+"0701";
        /* _datfinsem := Str(pAnno,4,0)+'1231' // Data Fine Semestre */
        _datfinsem = CPLib.Str(pAnno,4,0)+"1231";
      } // End Case
      /* gMsgProc := gMsgProc+'Inizio Aggiornamento Fraudolente: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Inizio Aggiornamento Fraudolente: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000017status;
      nTry00000017status = m_Sql.GetTransactionStatus();
      String cTry00000017msg;
      cTry00000017msg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgProc := gMsgProc+'Inizio Azzeramento Fraudolente Esistenti: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Inizio Azzeramento Fraudolente Esistenti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Write into analisi_sv from all
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("analisi_sv");
        m_cPhName = m_Ctx.GetPhName("analisi_sv");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"analisi_sv",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arfn_agg_fraudolente",4,"0000001A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"FLAGFRAUD = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"analisi_sv",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
        /* gMsgProc := gMsgProc+'Fine Azzeramento Fraudolente Esistenti: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Fine Azzeramento Fraudolente Esistenti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Fill memory cursor mcFraudo on qbe_ope_fraudolente
        mcFraudo.Zap();
        SPBridge.HMCaller _h0000001D;
        _h0000001D = new SPBridge.HMCaller();
        _h0000001D.Set("m_cVQRList",m_cVQRList);
        _h0000001D.Set("pDatIni",_datinisem);
        _h0000001D.Set("pDatFin",_datfinsem);
        if (Cursor_qbe_ope_fraudolente!=null)
          Cursor_qbe_ope_fraudolente.Close();
        Cursor_qbe_ope_fraudolente = new VQRHolder("qbe_ope_fraudolente",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000001D,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_ope_fraudolente;
          Cursor_qbe_ope_fraudolente.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arfn_agg_fraudolente: query on qbe_ope_fraudolente returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_ope_fraudolente.Eof())) {
          mcFraudo.AppendBlank();
          mcFraudo.row.TIPO = Cursor_qbe_ope_fraudolente.GetString("TIPO");
          mcFraudo.row.NUMPROG = Cursor_qbe_ope_fraudolente.GetString("NUMPROG");
          Cursor_qbe_ope_fraudolente.Next();
        }
        m_cConnectivityError = Cursor_qbe_ope_fraudolente.ErrorMessage();
        Cursor_qbe_ope_fraudolente.Close();
        mcFraudo.GoTop();
        for (MemoryCursorRow_qbe_ope_fraudolente_vqr rwFraudo : mcFraudo._iterable_()) {
          // * --- Write into analisi_sv from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("analisi_sv");
          m_cPhName = m_Ctx.GetPhName("analisi_sv");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"analisi_sv",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_agg_fraudolente",4,"0000001F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"FLAGFRAUD = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"analisi_sv",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"TIPO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraudo.TIPO,"?",0,0,m_cServer),m_cServer,rwFraudo.TIPO)+"";
          m_cSql = m_cSql+" and NUMPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraudo.NUMPROG,"?",0,0,m_cServer),m_cServer,rwFraudo.NUMPROG)+"";
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
        }
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000017status,0)) {
          m_Sql.SetTransactionStatus(nTry00000017status,cTry00000017msg);
        }
      }
      /* gMsgProc := gMsgProc+'Fine Aggiornamento Fraudolente: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Fine Aggiornamento Fraudolente: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_ope_fraudolente!=null)
          Cursor_qbe_ope_fraudolente.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(double p_pAnno,double p_pTri) {
    pAnno = p_pAnno;
    pTri = p_pTri;
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
  public String Run(double p_pAnno,double p_pTri) {
    pAnno = p_pAnno;
    pTri = p_pTri;
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return l_result;
  }
  public static arfn_agg_fraudolenteR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_agg_fraudolenteR(p_Ctx, p_Caller);
  }
  public static arfn_agg_fraudolenteR Make(CPContext p_Ctx) {
    return new arfn_agg_fraudolenteR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pAnno = 0;
    pTri = 0;
    _datinisem = CPLib.Space(8);
    _datfinsem = CPLib.Space(8);
    mcFraudo = new MemoryCursor_qbe_ope_fraudolente_vqr();
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_ope_fraudolente,
  public static final String m_cVQRList = ",qbe_ope_fraudolente,";
  // ENTITY_BATCHES: ,arfn_agg_fraudolente,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_agg_fraudolente,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"pAnno","pTri"};
}
