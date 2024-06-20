// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_stpanomaliesaeR implements CallerWithObjs {
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
  public String m_cPhName_tmp_newpers;
  public String m_cServer_tmp_newpers;
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
  public java.sql.Date w_daData;
  public String gDescAzi;
  public String _valido;
  public double _passa;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_stpanomaliesaeR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stpanomaliesae",m_Caller);
    if (m_Ctx.IsTmpAlreadyCreated("tmp_newpers")) {
      m_cPhName_tmp_newpers = p_ContextObject.GetPhName("tmp_newpers");
      if (m_cPhName_tmp_newpers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_newpers = m_cPhName_tmp_newpers+" "+m_Ctx.GetWritePhName("tmp_newpers");
      }
      m_cServer_tmp_newpers = p_ContextObject.GetServer("tmp_newpers");
    }
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_passa",p_cVarName)) {
      return _passa;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_stpanomaliesae";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("_valido",p_cVarName)) {
      return _valido;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("daData",p_cVarName)) {
      return w_daData;
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
    if (CPLib.eqr("_passa",p_cVarName)) {
      _passa = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
    if (CPLib.eqr("_valido",p_cVarName)) {
      _valido = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("daData",p_cVarName)) {
      w_daData = value;
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
    CPResultSet Cursor_qbe_anomaliesae=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_daData Date */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* _valido Char(50) */
      /* _passa Numeric(1, 0) */
      // * --- Drop temporary table tmp_newpers
      if (m_Ctx.IsSharedTemp("tmp_newpers")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_newpers")) {
          m_cServer = m_Ctx.GetServer("tmp_newpers");
          m_cPhName = m_Ctx.GetPhName("tmp_newpers");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_newpers");
      }
      // * --- Create temporary table tmp_newpers
      if (m_Ctx.IsSharedTemp("tmp_newpers")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_newpers")) {
          m_cServer = m_Ctx.GetServer("tmp_newpers");
          m_cPhName = m_Ctx.GetPhName("tmp_newpers");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_newpers");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_newpers");
      if ( ! (m_Ctx.IsSharedTemp("tmp_newpers"))) {
        m_cServer = m_Ctx.GetServer("tmp_newpers");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_newpers",m_cServer,"proto")),m_cPhName,"tmp_newpers",m_Ctx);
      }
      m_cPhName_tmp_newpers = m_cPhName;
      // * --- Select from qbe_anomaliesae
      if (Cursor_qbe_anomaliesae!=null)
        Cursor_qbe_anomaliesae.Close();
      Cursor_qbe_anomaliesae = new VQRHolder("qbe_anomaliesae",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_anomaliesae.Eof())) {
        /* _valido := '' */
        _valido = "";
        /* _passa := 0 */
        _passa = CPLib.Round(0,0);
        /* If (iif(Empty(qbe_anomaliesae->DATAINI),True,qbe_anomaliesae->DATAINI<=w_daData) and iif(Empty(qbe_anomaliesae->DATAFINE),True,qbe_anomaliesae->DATAFINE >= w_daData)) */
        if (((CPLib.Empty(Cursor_qbe_anomaliesae.GetDate("DATAINI"))?true:CPLib.le(Cursor_qbe_anomaliesae.GetDate("DATAINI"),w_daData)) && (CPLib.Empty(Cursor_qbe_anomaliesae.GetDate("DATAFINE"))?true:CPLib.ge(Cursor_qbe_anomaliesae.GetDate("DATAFINE"),w_daData)))) {
          /* If not(Empty(qbe_anomaliesae->DESCRI)) */
          if ( ! (CPLib.Empty(Cursor_qbe_anomaliesae.GetString("DESCRI")))) {
            /* _passa := 1 */
            _passa = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If _passa=0 */
        if (CPLib.eqr(_passa,0)) {
          /* If not(Empty(qbe_anomaliesae->DATAINI)) or not(Empty(qbe_anomaliesae->DATAFINE)) */
          if ( ! (CPLib.Empty(Cursor_qbe_anomaliesae.GetDate("DATAINI"))) ||  ! (CPLib.Empty(Cursor_qbe_anomaliesae.GetDate("DATAFINE")))) {
            /* _valido := 'Codice SAE '+ qbe_anomaliesae->SOTGRUP + ' valido' */
            _valido = "Codice SAE "+Cursor_qbe_anomaliesae.GetString("SOTGRUP")+" valido";
          } // End If
          /* If not(Empty(qbe_anomaliesae->DATAINI)) */
          if ( ! (CPLib.Empty(Cursor_qbe_anomaliesae.GetDate("DATAINI")))) {
            /* _valido := _valido + " dal "+arfn_fdate(qbe_anomaliesae->DATAINI) */
            _valido = _valido+" dal "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_anomaliesae.GetDate("DATAINI"));
          } // End If
          /* If not(Empty(qbe_anomaliesae->DATAFINE)) */
          if ( ! (CPLib.Empty(Cursor_qbe_anomaliesae.GetDate("DATAFINE")))) {
            /* _valido := _valido + " fino al "+arfn_fdate(qbe_anomaliesae->DATAFINE) */
            _valido = _valido+" fino al "+arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_anomaliesae.GetDate("DATAFINE"));
          } // End If
          /* If Empty(LRTrim(qbe_anomaliesae->DESCRI)) */
          if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_anomaliesae.GetString("DESCRI")))) {
            /* _valido := 'Codice SAE '+ qbe_anomaliesae->SOTGRUP+" inesistente" */
            _valido = "Codice SAE "+Cursor_qbe_anomaliesae.GetString("SOTGRUP")+" inesistente";
          } // End If
          // * --- Insert into tmp_newpers from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_newpers");
          m_cPhName = m_Ctx.GetPhName("tmp_newpers");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_newpers",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_stpanomaliesae",4,"0000001A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000001A(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_anomaliesae.GetString("CONNES"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_anomaliesae.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_anomaliesae.GetString("SOTGRU"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_valido,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_newpers",true);
          m_cSql = m_cSql+")";
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
        Cursor_qbe_anomaliesae.Next();
      }
      m_cConnectivityError = Cursor_qbe_anomaliesae.ErrorMessage();
      Cursor_qbe_anomaliesae.Close();
      // * --- End Select
      /* Stop arrp_stpanomaliesae.vrp */
      Forward f;
      f=new Forward("Report",false,this,Forward.Start,false);
      f.SetParameter("w_dataseg",w_daData);
      f.SetParameter("DescAzi",gDescAzi);
      f.SetParameter("ReportName","arrp_stpanomaliesae.vrp");
      f.SetParameter("m_cParameterSequence","w_dataseg"+","+"DescAzi"+","+"ReportName");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_qbe_anomaliesae!=null)
          Cursor_qbe_anomaliesae.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_w_daData) {
    w_daData = p_w_daData;
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
  public Forward Run(java.sql.Date p_w_daData) {
    w_daData = p_w_daData;
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_stpanomaliesaeR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stpanomaliesaeR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_daData = CPLib.NullDate();
    _valido = CPLib.Space(50);
    _passa = 0;
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_anomaliesae,
  public static final String m_cVQRList = ",qbe_anomaliesae,";
  // ENTITY_BATCHES: ,arfn_fdate,
  public static final String i_InvokedRoutines = ",arfn_fdate,";
  public static String[] m_cRunParameterNames={"w_daData"};
  protected static String GetFieldsName_0000001A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"MSGELAB,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_newpers",true);
    return p_cSql;
  }
}
