// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_chk_codfisR implements CallerWithObjs {
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
  public String m_cPhName_kersonbo;
  public String m_cServer_kersonbo;
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
  public double _max;
  public double _min;
  public double _tot;
  public double _top;
  public double _bottom;
  public double _mono;
  public double _cicli;
  public double _contacicli;
  public double _reccount;
  public double _conta;
  public double _contas;
  public String _valido;
  public String _nasstato;
  public String _nascitta;
  public String gMsgProc;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_chk_codfisR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_chk_codfis",m_Caller);
    m_cPhName_kersonbo = p_ContextObject.GetPhName("kersonbo");
    if (m_cPhName_kersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_kersonbo = m_cPhName_kersonbo+" "+m_Ctx.GetWritePhName("kersonbo");
    }
    m_cServer_kersonbo = p_ContextObject.GetServer("kersonbo");
    m_cPhName_dersonbo = p_ContextObject.GetPhName("dersonbo");
    if (m_cPhName_dersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_dersonbo = m_cPhName_dersonbo+" "+m_Ctx.GetWritePhName("dersonbo");
    }
    m_cServer_dersonbo = p_ContextObject.GetServer("dersonbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      return _contacicli;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      return _reccount;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_contas",p_cVarName)) {
      return _contas;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_chk_codfis";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("_valido",p_cVarName)) {
      return _valido;
    }
    if (CPLib.eqr("_nasstato",p_cVarName)) {
      return _nasstato;
    }
    if (CPLib.eqr("_nascitta",p_cVarName)) {
      return _nascitta;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
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
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
      return;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
      return;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      _mono = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      _contacicli = value;
      return;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      _reccount = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_contas",p_cVarName)) {
      _contas = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_valido",p_cVarName)) {
      _valido = value;
      return;
    }
    if (CPLib.eqr("_nasstato",p_cVarName)) {
      _nasstato = value;
      return;
    }
    if (CPLib.eqr("_nascitta",p_cVarName)) {
      _nascitta = value;
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
    CPResultSet Cursor_qbe_dersonbo_minmax=null;
    CPResultSet Cursor_dersonbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _cicli Numeric(15, 0) */
      /* _contacicli Numeric(15, 0) */
      /* _reccount Numeric(0, 0) */
      /* _conta Numeric(10, 0) */
      /* _contas Numeric(10, 0) */
      /* _valido Char(1) */
      /* _nasstato Char(30) */
      /* _nascitta Char(30) */
      /* gMsgProc Memo // Messaggio */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc := 'Ora Inizio elaborazione: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = "Ora Inizio elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      /* _mono := 0 */
      _mono = CPLib.Round(0,0);
      // * --- Select from qbe_dersonbo_minmax
      if (Cursor_qbe_dersonbo_minmax!=null)
        Cursor_qbe_dersonbo_minmax.Close();
      Cursor_qbe_dersonbo_minmax = new VQRHolder("qbe_dersonbo_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_dersonbo_minmax.Eof())) {
        /* _min := qbe_dersonbo_minmax->MINKER */
        _min = CPLib.Round(Cursor_qbe_dersonbo_minmax.GetDouble("MINKER"),0);
        /* _max := qbe_dersonbo_minmax->MAXKER */
        _max = CPLib.Round(Cursor_qbe_dersonbo_minmax.GetDouble("MAXKER"),0);
        /* _tot := qbe_dersonbo_minmax->TOTKER */
        _tot = CPLib.Round(Cursor_qbe_dersonbo_minmax.GetDouble("TOTKER"),0);
        Cursor_qbe_dersonbo_minmax.Next();
      }
      m_cConnectivityError = Cursor_qbe_dersonbo_minmax.ErrorMessage();
      Cursor_qbe_dersonbo_minmax.Close();
      // * --- End Select
      /* _mono := iif(_tot > 1000,0,1) */
      _mono = CPLib.Round((CPLib.gt(_tot,1000)?0:1),0);
      /* If _mono = 1 */
      if (CPLib.eqr(_mono,1)) {
        /* If _tot = 0 */
        if (CPLib.eqr(_tot,0)) {
          /* _cicli := 0 */
          _cicli = CPLib.Round(0,0);
        } else { // Else
          /* _cicli := 1 */
          _cicli = CPLib.Round(1,0);
        } // End If
      } else { // Else
        /* _reccount := _max - _min */
        _reccount = CPLib.Round(_max-_min,0);
        /* _cicli := iif(Mod(_reccount,1000) <> 0,Int(_reccount/1000) + 1,Int(_reccount/1000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,1000),0)?CPLib.Int(_reccount/1000)+1:CPLib.Int(_reccount/1000)),0);
      } // End If
      /* _contas := 0 */
      _contas = CPLib.Round(0,0);
      /* _contacicli := 1 */
      _contacicli = CPLib.Round(1,0);
      /* While _contacicli<=_cicli */
      while (CPLib.le(_contacicli,_cicli)) {
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
          /* _bottom := _min */
          _bottom = CPLib.Round(_min,0);
          /* _top := _max */
          _top = CPLib.Round(_max,0);
        } else { // Else
          /* If _contacicli=1 */
          if (CPLib.eqr(_contacicli,1)) {
            /* _bottom := _min */
            _bottom = CPLib.Round(_min,0);
            /* _top := _min + 999 */
            _top = CPLib.Round(_min+999,0);
            /* ElseIf _contacicli = _cicli */
          } else if (CPLib.eqr(_contacicli,_cicli)) {
            /* _bottom := _top + 1 */
            _bottom = CPLib.Round(_top+1,0);
            /* _top := _max */
            _top = CPLib.Round(_max,0);
          } else { // Else
            /* _bottom := _top + 1 */
            _bottom = CPLib.Round(_top+1,0);
            /* _top := _bottom + 999 */
            _top = CPLib.Round(_bottom+999,0);
          } // End If
        } // End If
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000031status;
        nTry00000031status = m_Sql.GetTransactionStatus();
        String cTry00000031msg;
        cTry00000031msg = m_Sql.TransactionErrorMessage();
        try {
          // * --- Select from dersonbo
          m_cServer = m_Ctx.GetServer("dersonbo");
          m_cPhName = m_Ctx.GetPhName("dersonbo");
          if (Cursor_dersonbo!=null)
            Cursor_dersonbo.Close();
          Cursor_dersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,CODFISC,NASSTATO,NASCOMUN,TIPODOC,NUMDOCUM  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PROGIMPORT >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_bottom,"?",0,0,m_cServer, m_oParameters),m_cServer,_bottom)+"  and  PROGIMPORT <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+"  and  FLGCFVALIDO='N'  and  FLGCGFORMAT='N'  "+")"+(m_Ctx.IsSharedTemp("dersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_dersonbo.Eof())) {
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* gMsgImp := 'Sto elaborando il record '+LRTrim(Str(_conta,10,0)) + ' su ' + LRTrim(Str(_tot,10,0)) // Messaggio Import */
            gMsgImp = "Sto elaborando il record "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_tot,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If not(Empty(LRTrim(dersonbo->CODFISC))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_dersonbo.GetString("CODFISC"))))) {
              /* _valido := iif(arfn_chkcodfis(dersonbo->CODFISC,'',0),'S','N') */
              _valido = (arfn_chkcodfisR.Make(m_Ctx,this).Run(Cursor_dersonbo.GetString("CODFISC"),"",0)?"S":"N");
              /* If _valido='S' */
              if (CPLib.eqr(_valido,"S")) {
                /* _nasstato := iif(Substr(LRTrim(dersonbo->CODFISC),12,1)='Z',dersonbo->NASSTATO,'') */
                _nasstato = (CPLib.eqr(CPLib.Substr(CPLib.LRTrim(Cursor_dersonbo.GetString("CODFISC")),12,1),"Z")?Cursor_dersonbo.GetString("NASSTATO"):"");
                /* _nascitta := iif(Substr(LRTrim(dersonbo->CODFISC),12,1)<>'Z',dersonbo->NASCOMUN,'') */
                _nascitta = (CPLib.ne(CPLib.Substr(CPLib.LRTrim(Cursor_dersonbo.GetString("CODFISC")),12,1),"Z")?Cursor_dersonbo.GetString("NASCOMUN"):"");
                /* _contas := _contas + 1 */
                _contas = CPLib.Round(_contas+1,0);
                // * --- Write into dersonbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("dersonbo");
                m_cPhName = m_Ctx.GetPhName("dersonbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dersonbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_chk_codfis",113,"0000003B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"FLGCGFORMAT = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(_nascitta,"C",60,0,m_cServer)+", ";
                m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(_nasstato,"C",60,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"dersonbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"TIPODOC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_dersonbo.GetString("TIPODOC"),"?",0,0,m_cServer),m_cServer,Cursor_dersonbo.GetString("TIPODOC"))+"";
                m_cSql = m_cSql+" and NUMDOCUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_dersonbo.GetString("NUMDOCUM"),"?",0,0,m_cServer),m_cServer,Cursor_dersonbo.GetString("NUMDOCUM"))+"";
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
            Cursor_dersonbo.Next();
          }
          m_cConnectivityError = Cursor_dersonbo.ErrorMessage();
          Cursor_dersonbo.Close();
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
          // Exit Loop
          if (true) {
            break;
          }
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000031status,0)) {
            m_Sql.SetTransactionStatus(nTry00000031status,cTry00000031msg);
          }
        }
        /* _contacicli := _contacicli+1 */
        _contacicli = CPLib.Round(_contacicli+1,0);
      } // End While
      /* If _contacicli < _cicli */
      if (CPLib.lt(_contacicli,_cicli)) {
        /* gMsgImp := 'Elaborazione abortita!' // Messaggio Import */
        gMsgImp = "Elaborazione abortita!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } else { // Else
        /* gMsgImp := 'Elaborazione terminata correttamente!' // Messaggio Import */
        gMsgImp = "Elaborazione terminata correttamente!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } // End If
      /* gMsgProc := gMsgProc + 'Sono stati validati: '+LRTrim(Str(_contas,10,0))+ " su "+LRTrim(Str(_tot,10,0))+NL // Messaggio */
      gMsgProc = gMsgProc+"Sono stati validati: "+CPLib.LRTrim(CPLib.Str(_contas,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_tot,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine elaborazione: '+arfn_fdatetime(DateTime()) // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_dersonbo_minmax!=null)
          Cursor_qbe_dersonbo_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_dersonbo!=null)
          Cursor_dersonbo.Close();
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
  public static arrt_chk_codfisR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_chk_codfisR(p_Ctx, p_Caller);
  }
  public static arrt_chk_codfisR Make(CPContext p_Ctx) {
    return new arrt_chk_codfisR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    _max = 0;
    _min = 0;
    _tot = 0;
    _top = 0;
    _bottom = 0;
    _mono = 0;
    _cicli = 0;
    _contacicli = 0;
    _reccount = 0;
    _conta = 0;
    _contas = 0;
    _valido = CPLib.Space(1);
    _nasstato = CPLib.Space(30);
    _nascitta = CPLib.Space(30);
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_dersonbo_minmax,
  public static final String m_cVQRList = ",qbe_dersonbo_minmax,";
  // ENTITY_BATCHES: ,arfn_chkcodfis,arfn_fdatetime,arrt_chk_codfis,
  public static final String i_InvokedRoutines = ",arfn_chkcodfis,arfn_fdatetime,arrt_chk_codfis,";
  public static String[] m_cRunParameterNames={};
}
