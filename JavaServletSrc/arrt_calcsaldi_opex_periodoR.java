// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_calcsaldi_opex_periodoR implements CallerWithObjs {
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
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_tmp_newpers;
  public String m_cServer_tmp_newpers;
  public String m_cPhName_tbmacage;
  public String m_cServer_tbmacage;
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
  public double w_annorif;
  public String w_valuta;
  public java.sql.Date w_DaData;
  public java.sql.Date w_A_Data;
  public String _codcli;
  public double _totale;
  public double _operaz;
  public String _anno;
  public double _tot;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_calcsaldi_opex_periodoR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_calcsaldi_opex_periodo",m_Caller);
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_tmp_newpers = p_ContextObject.GetPhName("tmp_newpers");
    if (m_cPhName_tmp_newpers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_newpers = m_cPhName_tmp_newpers+" "+m_Ctx.GetWritePhName("tmp_newpers");
    }
    m_cServer_tmp_newpers = p_ContextObject.GetServer("tmp_newpers");
    m_cPhName_tbmacage = p_ContextObject.GetPhName("tbmacage");
    if (m_cPhName_tbmacage.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbmacage = m_cPhName_tbmacage+" "+m_Ctx.GetWritePhName("tbmacage");
    }
    m_cServer_tbmacage = p_ContextObject.GetServer("tbmacage");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("annorif",p_cVarName)) {
      return w_annorif;
    }
    if (CPLib.eqr("_totale",p_cVarName)) {
      return _totale;
    }
    if (CPLib.eqr("_operaz",p_cVarName)) {
      return _operaz;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_calcsaldi_opex_periodo";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("valuta",p_cVarName)) {
      return w_valuta;
    }
    if (CPLib.eqr("_codcli",p_cVarName)) {
      return _codcli;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      return _anno;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DaData",p_cVarName)) {
      return w_DaData;
    }
    if (CPLib.eqr("A_Data",p_cVarName)) {
      return w_A_Data;
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
    if (CPLib.eqr("annorif",p_cVarName)) {
      w_annorif = value;
      return;
    }
    if (CPLib.eqr("_totale",p_cVarName)) {
      _totale = value;
      return;
    }
    if (CPLib.eqr("_operaz",p_cVarName)) {
      _operaz = value;
      return;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("valuta",p_cVarName)) {
      w_valuta = value;
      return;
    }
    if (CPLib.eqr("_codcli",p_cVarName)) {
      _codcli = value;
      return;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      _anno = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DaData",p_cVarName)) {
      w_DaData = value;
      return;
    }
    if (CPLib.eqr("A_Data",p_cVarName)) {
      w_A_Data = value;
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
    CPResultSet Cursor_qbe_calcsaldi_periodo_o=null;
    CPResultSet Cursor_qbe_calcsaldi_periodo_o_tot=null;
    CPResultSet Cursor_opextrbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_annorif Numeric(4, 0) */
      /* w_valuta Char(3) */
      /* w_DaData Date */
      /* w_A_Data Date */
      /* _codcli Char(16) */
      /* _totale Numeric(17, 0) */
      /* _operaz Numeric(10, 0) */
      /* _anno Char(4) */
      /* _tot Numeric(17, 0) */
      /* gMsgImp Char(120) // Messaggio Import */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000000Fstatus;
      nTry0000000Fstatus = m_Sql.GetTransactionStatus();
      String cTry0000000Fmsg;
      cTry0000000Fmsg = m_Sql.TransactionErrorMessage();
      try {
        /* Azzera Saldi */
        /* _anno := Str(w_annorif,4,0) */
        _anno = CPLib.Str(w_annorif,4,0);
        // * --- Select from qbe_calcsaldi_periodo_o
        SPBridge.HMCaller _h00000012;
        _h00000012 = new SPBridge.HMCaller();
        _h00000012.Set("m_cVQRList",m_cVQRList);
        _h00000012.Set("DaData",w_DaData);
        _h00000012.Set("A_Data",w_A_Data);
        if (Cursor_qbe_calcsaldi_periodo_o!=null)
          Cursor_qbe_calcsaldi_periodo_o.Close();
        Cursor_qbe_calcsaldi_periodo_o = new VQRHolder("qbe_calcsaldi_periodo_o",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000012,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_calcsaldi_periodo_o.Eof())) {
          /* gMsgImp := 'Elaboro Soggetto con NDG: '+LRTrim(qbe_calcsaldi_periodo_o->CONNESCLI) */
          gMsgImp = "Elaboro Soggetto con NDG: "+CPLib.LRTrim(Cursor_qbe_calcsaldi_periodo_o.GetString("CONNESCLI"));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _totale := 0 */
          _totale = CPLib.Round(0,0);
          /* _operaz := 0 */
          _operaz = CPLib.Round(0,0);
          // * --- Select from qbe_calcsaldi_periodo_o_tot
          SPBridge.HMCaller _h00000016;
          _h00000016 = new SPBridge.HMCaller();
          _h00000016.Set("m_cVQRList",m_cVQRList);
          _h00000016.Set("codcli",Cursor_qbe_calcsaldi_periodo_o.GetString("CONNESCLI"));
          _h00000016.Set("anno",w_annorif);
          if (Cursor_qbe_calcsaldi_periodo_o_tot!=null)
            Cursor_qbe_calcsaldi_periodo_o_tot.Close();
          Cursor_qbe_calcsaldi_periodo_o_tot = new VQRHolder("qbe_calcsaldi_periodo_o_tot",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000016,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_calcsaldi_periodo_o_tot.Eof())) {
            /* If qbe_calcsaldi_periodo_o_tot->OPERAZIONI > 0 */
            if (CPLib.gt(Cursor_qbe_calcsaldi_periodo_o_tot.GetDouble("OPERAZIONI"),0)) {
              /* _totale := _totale + qbe_calcsaldi_periodo_o_tot->IMPORTO */
              _totale = CPLib.Round(_totale+Cursor_qbe_calcsaldi_periodo_o_tot.GetDouble("IMPORTO"),0);
              /* _operaz := _operaz + qbe_calcsaldi_periodo_o_tot->OPERAZIONI */
              _operaz = CPLib.Round(_operaz+Cursor_qbe_calcsaldi_periodo_o_tot.GetDouble("OPERAZIONI"),0);
            } // End If
            Cursor_qbe_calcsaldi_periodo_o_tot.Next();
          }
          m_cConnectivityError = Cursor_qbe_calcsaldi_periodo_o_tot.ErrorMessage();
          Cursor_qbe_calcsaldi_periodo_o_tot.Close();
          // * --- End Select
          // * --- Select from opextrbo
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          if (Cursor_opextrbo!=null)
            Cursor_opextrbo.Close();
          Cursor_opextrbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"COLLEG="+CPLib.ToSQL(Cursor_qbe_calcsaldi_periodo_o.GetString("CONNESCLI"),"?",0,0)+"  and  ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"?",0,0,m_cServer, m_oParameters),m_cServer,_anno)+" "+")"+(m_Ctx.IsSharedTemp("opextrbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_opextrbo.Eof())) {
            /* _tot := (_totale/100) */
            _tot = CPLib.Round((_totale/100),0);
            /* If opextrbo->QUANTITA<>_operaz or opextrbo->SALDO<>_tot */
            if (CPLib.ne(Cursor_opextrbo.GetDouble("QUANTITA"),_operaz) || CPLib.ne(Cursor_opextrbo.GetDouble("SALDO"),_tot)) {
              /* If opextrbo->INVIATO=1 */
              if (CPLib.eqr(Cursor_opextrbo.GetDouble("INVIATO"),1)) {
                // * --- Write into opextrbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("opextrbo");
                m_cPhName = m_Ctx.GetPhName("opextrbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex_periodo",121,"0000001E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"SALDO = "+CPLib.ToSQL(_tot,"N",17,0)+", ";
                m_cSql = m_cSql+"QUANTITA = "+CPLib.ToSQL(_operaz,"N",6,0)+", ";
                m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(w_valuta,"C",3,0,m_cServer)+", ";
                m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_calcsaldi_periodo_o.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_calcsaldi_periodo_o.GetString("CONNESCLI"))+"";
                m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"?",0,0,m_cServer),m_cServer,_anno)+"";
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
              } else { // Else
                // * --- Write into opextrbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("opextrbo");
                m_cPhName = m_Ctx.GetPhName("opextrbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_calcsaldi_opex_periodo",121,"0000001F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"SALDO = "+CPLib.ToSQL(_tot,"N",17,0)+", ";
                m_cSql = m_cSql+"QUANTITA = "+CPLib.ToSQL(_operaz,"N",6,0)+", ";
                m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(w_valuta,"C",3,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_calcsaldi_periodo_o.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_calcsaldi_periodo_o.GetString("CONNESCLI"))+"";
                m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"?",0,0,m_cServer),m_cServer,_anno)+"";
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
            Cursor_opextrbo.Next();
          }
          m_cConnectivityError = Cursor_opextrbo.ErrorMessage();
          Cursor_opextrbo.Close();
          // * --- End Select
          Cursor_qbe_calcsaldi_periodo_o.Next();
        }
        m_cConnectivityError = Cursor_qbe_calcsaldi_periodo_o.ErrorMessage();
        Cursor_qbe_calcsaldi_periodo_o.Close();
        // * --- End Select
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgImp := 'Elaborazione Terminata con Successo!' */
        gMsgImp = "Elaborazione Terminata con Successo!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgImp := 'Elaborazione Abortita. Contattare Assistenza' */
        gMsgImp = "Elaborazione Abortita. Contattare Assistenza";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000000Fstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000000Fstatus,cTry0000000Fmsg);
        }
      }
    } finally {
      try {
        if (Cursor_qbe_calcsaldi_periodo_o!=null)
          Cursor_qbe_calcsaldi_periodo_o.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_calcsaldi_periodo_o_tot!=null)
          Cursor_qbe_calcsaldi_periodo_o_tot.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_opextrbo!=null)
          Cursor_opextrbo.Close();
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
      m_Caller.SetNumber("annorif","N",4,0,w_annorif);
      m_Caller.SetString("valuta","C",3,0,w_valuta);
      m_Caller.SetDate("DaData","D",8,0,w_DaData);
      m_Caller.SetDate("A_Data","D",8,0,w_A_Data);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_calcsaldi_opex_periodoR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_calcsaldi_opex_periodoR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_annorif = m_Caller.GetNumber("annorif","N",4,0);
    w_valuta = m_Caller.GetString("valuta","C",3,0);
    w_DaData = m_Caller.GetDate("DaData","D",8,0);
    w_A_Data = m_Caller.GetDate("A_Data","D",8,0);
    _codcli = CPLib.Space(16);
    _totale = 0;
    _operaz = 0;
    _anno = CPLib.Space(4);
    _tot = 0;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_calcsaldi_periodo_o,qbe_calcsaldi_periodo_o_tot,
  public static final String m_cVQRList = ",qbe_calcsaldi_periodo_o,qbe_calcsaldi_periodo_o_tot,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
