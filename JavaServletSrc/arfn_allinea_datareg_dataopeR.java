// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_allinea_datareg_dataopeR implements CallerWithObjs {
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
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
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
  public java.sql.Date DA_DATAOPE;
  public java.sql.Date A_DATAOPE;
  public String TBL;
  public String gMsgImp;
  public String gMsgProc;
  public boolean ritorno;
  public double tot_record;
  public String tot_record_str;
  public String DA_DATAOPE_str;
  public String A_DATAOPE_str;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_allinea_datareg_dataopeR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_allinea_datareg_dataope",m_Caller);
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("tot_record",p_cVarName)) {
      return tot_record;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_allinea_datareg_dataope";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("TBL",p_cVarName)) {
      return TBL;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("tot_record_str",p_cVarName)) {
      return tot_record_str;
    }
    if (CPLib.eqr("DA_DATAOPE_str",p_cVarName)) {
      return DA_DATAOPE_str;
    }
    if (CPLib.eqr("A_DATAOPE_str",p_cVarName)) {
      return A_DATAOPE_str;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DA_DATAOPE",p_cVarName)) {
      return DA_DATAOPE;
    }
    if (CPLib.eqr("A_DATAOPE",p_cVarName)) {
      return A_DATAOPE;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("ritorno",p_cVarName)) {
      return ritorno;
    }
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
    if (CPLib.eqr("tot_record",p_cVarName)) {
      tot_record = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("TBL",p_cVarName)) {
      TBL = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("tot_record_str",p_cVarName)) {
      tot_record_str = value;
      return;
    }
    if (CPLib.eqr("DA_DATAOPE_str",p_cVarName)) {
      DA_DATAOPE_str = value;
      return;
    }
    if (CPLib.eqr("A_DATAOPE_str",p_cVarName)) {
      A_DATAOPE_str = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DA_DATAOPE",p_cVarName)) {
      DA_DATAOPE = value;
      return;
    }
    if (CPLib.eqr("A_DATAOPE",p_cVarName)) {
      A_DATAOPE = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("ritorno",p_cVarName)) {
      ritorno = value;
      return;
    }
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
    CPResultSet Cursor_qbe_tab_mmc_da_a_data_filter=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* DA_DATAOPE Date // da quale data alliniare */
      /* A_DATAOPE Date // a quale data alliniare */
      /* TBL Char(1) // Tabella su cui effettuare l'allienamento (O operazioni, F frazionate, E entrambe) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio */
      /* ritorno Bool // ritorno della funzione */
      /* tot_record Numeric(10, 0) // numero totale dei record da prendere in esame */
      /* tot_record Numeric(10, 0) // numero totale dei record da prendere in esame */
      /* tot_record_str Char(13) // numero totale dei record da prendere in esame su stringa */
      /* DA_DATAOPE_str Char(8) // da quale data alliniare stringa */
      /* A_DATAOPE_str Char(8) // a quale data alliniare stringa */
      /* DA_DATAOPE_str := DateToChar(DA_DATAOPE) // da quale data alliniare stringa */
      DA_DATAOPE_str = CPLib.DateToChar(DA_DATAOPE);
      /* A_DATAOPE_str := DateToChar(A_DATAOPE) // a quale data alliniare stringa */
      A_DATAOPE_str = CPLib.DateToChar(A_DATAOPE);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000010status;
      nTry00000010status = m_Sql.GetTransactionStatus();
      String cTry00000010msg;
      cTry00000010msg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgProc := 'Inizio procedura: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = "Inizio procedura: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* If TBL='O' or TBL='E' */
        if (CPLib.eqr(TBL,"O") || CPLib.eqr(TBL,"E")) {
          // * --- Select from qbe_tab_mmc_da_a_data_filter
          SPBridge.HMCaller _h00000013;
          _h00000013 = new SPBridge.HMCaller();
          _h00000013.Set("m_cVQRList",m_cVQRList);
          _h00000013.Set("tbname","operazbo");
          _h00000013.Set("fldname","IDBASE");
          _h00000013.Set("parname","DATAOPE");
          _h00000013.Set("parval",DA_DATAOPE);
          _h00000013.Set("parval2",A_DATAOPE);
          if (Cursor_qbe_tab_mmc_da_a_data_filter!=null)
            Cursor_qbe_tab_mmc_da_a_data_filter.Close();
          Cursor_qbe_tab_mmc_da_a_data_filter = new VQRHolder("qbe_tab_mmc_da_a_data_filter",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000013,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_tab_mmc_da_a_data_filter.Eof())) {
            /* tot_record := qbe_tab_mmc_da_a_data_filter->tot // numero totale dei record da prendere in esame */
            tot_record = CPLib.Round(Cursor_qbe_tab_mmc_da_a_data_filter.GetDouble("tot"),0);
            Cursor_qbe_tab_mmc_da_a_data_filter.Next();
          }
          m_cConnectivityError = Cursor_qbe_tab_mmc_da_a_data_filter.ErrorMessage();
          Cursor_qbe_tab_mmc_da_a_data_filter.Close();
          // * --- End Select
          /* tot_record_str := Right(Replicate(' ',10)+Str(tot_record,10,0),10) // numero totale dei record da prendere in esame su stringa */
          tot_record_str = CPLib.Right(CPLib.Replicate(" ",10)+CPLib.Str(tot_record,10,0),10);
          /* gMsgImp := 'Elaborazione dati dal '+arfn_fdate(DA_DATAOPE)+' al '+arfn_fdate(A_DATAOPE)+' per operazioni '+tot_record_str // Messaggio Import */
          gMsgImp = "Elaborazione dati dal "+arfn_fdateR.Make(m_Ctx,this).Run(DA_DATAOPE)+" al "+arfn_fdateR.Make(m_Ctx,this).Run(A_DATAOPE)+" per operazioni "+tot_record_str;
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* gMsgProc := gMsgProc+'Elaborazione dati dal '+arfn_fdate(DA_DATAOPE)+' al '+arfn_fdate(A_DATAOPE)+' per operazioni '+tot_record_str+NL // Messaggio */
          gMsgProc = gMsgProc+"Elaborazione dati dal "+arfn_fdateR.Make(m_Ctx,this).Run(DA_DATAOPE)+" al "+arfn_fdateR.Make(m_Ctx,this).Run(A_DATAOPE)+" per operazioni "+tot_record_str+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // * --- Write into operazbo from sql
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cQuery = QueryLoader.SetSqlFunctions("select * from ",m_cServer,m_Ctx)+m_cPhName_operazbo+" where " + QueryLoader.SetSqlFunctions("CDATOPE>="+CPSql.SQLValueAdapter(CPLib.ToSQL(DA_DATAOPE_str,"?",0,0,m_cServer, m_oParameters),m_cServer,DA_DATAOPE_str)+"  and  CDATOPE<="+CPSql.SQLValueAdapter(CPLib.ToSQL(A_DATAOPE_str,"?",0,0,m_cServer, m_oParameters),m_cServer,A_DATAOPE_str)+" ",m_cServer,m_Ctx);
          m_nUpdatedRows = m_Sql.WriteFromSql(CPLib.GetSQLPrefixComment("arfn_allinea_datareg_dataope",18,"00000018"),"operazbo",m_cQuery,CPSql.NewMultipleStringValues("IDBASE"),CPSql.NewMultipleStringValues("DATAREG","CDATREG"),CPSql.NewMultipleStringValues("=","="),CPSql.NewMultipleStringValues(m_oParameters,"cptmp_1xab23.DATAOPE ","cptmp_1xab23.CDATOPE "),m_Ctx,m_oWrInfo);
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
        /* If TBL='F' or TBL='E' */
        if (CPLib.eqr(TBL,"F") || CPLib.eqr(TBL,"E")) {
          // * --- Select from qbe_tab_mmc_da_a_data_filter
          SPBridge.HMCaller _h0000001A;
          _h0000001A = new SPBridge.HMCaller();
          _h0000001A.Set("m_cVQRList",m_cVQRList);
          _h0000001A.Set("tbname","fraziobo");
          _h0000001A.Set("fldname","IDBASE");
          _h0000001A.Set("parname","DATAOPE");
          _h0000001A.Set("parval",DA_DATAOPE);
          _h0000001A.Set("parval2",A_DATAOPE);
          if (Cursor_qbe_tab_mmc_da_a_data_filter!=null)
            Cursor_qbe_tab_mmc_da_a_data_filter.Close();
          Cursor_qbe_tab_mmc_da_a_data_filter = new VQRHolder("qbe_tab_mmc_da_a_data_filter",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000001A,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_tab_mmc_da_a_data_filter.Eof())) {
            /* tot_record := qbe_tab_mmc_da_a_data_filter->tot // numero totale dei record da prendere in esame */
            tot_record = CPLib.Round(Cursor_qbe_tab_mmc_da_a_data_filter.GetDouble("tot"),0);
            Cursor_qbe_tab_mmc_da_a_data_filter.Next();
          }
          m_cConnectivityError = Cursor_qbe_tab_mmc_da_a_data_filter.ErrorMessage();
          Cursor_qbe_tab_mmc_da_a_data_filter.Close();
          // * --- End Select
          /* tot_record_str := Right(Replicate(' ',10)+Str(tot_record,10,0),10) // numero totale dei record da prendere in esame su stringa */
          tot_record_str = CPLib.Right(CPLib.Replicate(" ",10)+CPLib.Str(tot_record,10,0),10);
          /* gMsgImp := 'Elaborazione dati dal '+arfn_fdate(DA_DATAOPE)+' al '+arfn_fdate(A_DATAOPE)+' per frazionate '+tot_record_str // Messaggio Import */
          gMsgImp = "Elaborazione dati dal "+arfn_fdateR.Make(m_Ctx,this).Run(DA_DATAOPE)+" al "+arfn_fdateR.Make(m_Ctx,this).Run(A_DATAOPE)+" per frazionate "+tot_record_str;
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* gMsgProc := gMsgProc+'Elaborazione dati dal '+arfn_fdate(DA_DATAOPE)+' al '+arfn_fdate(A_DATAOPE)+' per frazionate '+tot_record_str+NL // Messaggio */
          gMsgProc = gMsgProc+"Elaborazione dati dal "+arfn_fdateR.Make(m_Ctx,this).Run(DA_DATAOPE)+" al "+arfn_fdateR.Make(m_Ctx,this).Run(A_DATAOPE)+" per frazionate "+tot_record_str+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // * --- Write into fraziobo from sql
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cQuery = QueryLoader.SetSqlFunctions("select * from ",m_cServer,m_Ctx)+m_cPhName_fraziobo+" where " + QueryLoader.SetSqlFunctions("CDATOPE>="+CPSql.SQLValueAdapter(CPLib.ToSQL(DA_DATAOPE_str,"?",0,0,m_cServer, m_oParameters),m_cServer,DA_DATAOPE_str)+"  and  CDATOPE<="+CPSql.SQLValueAdapter(CPLib.ToSQL(A_DATAOPE_str,"?",0,0,m_cServer, m_oParameters),m_cServer,A_DATAOPE_str)+" ",m_cServer,m_Ctx);
          m_nUpdatedRows = m_Sql.WriteFromSql(CPLib.GetSQLPrefixComment("arfn_allinea_datareg_dataope",18,"0000001F"),"fraziobo",m_cQuery,CPSql.NewMultipleStringValues("IDBASE"),CPSql.NewMultipleStringValues("DATAREG","CDATREG"),CPSql.NewMultipleStringValues("=","="),CPSql.NewMultipleStringValues(m_oParameters,"cptmp_1xab23.DATAOPE ","cptmp_1xab23.CDATOPE "),m_Ctx,m_oWrInfo);
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
        /* gMsgProc := gMsgProc+'Procedura terminata correttamente senza presenza di errori '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Procedura terminata correttamente senza presenza di errori "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* ritorno := True // ritorno della funzione */
        ritorno = true;
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* gMsgProc := gMsgProc+'Procedura annullata per presenza di errori '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Procedura annullata per presenza di errori "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* ritorno := False // ritorno della funzione */
        ritorno = false;
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000010status,0)) {
          m_Sql.SetTransactionStatus(nTry00000010status,cTry00000010msg);
        }
      }
      /* gMsgProc := gMsgProc+'Fine procedura: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Fine procedura: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Return ritorno */
      throw new Stop(ritorno);
    } finally {
      try {
        if (Cursor_qbe_tab_mmc_da_a_data_filter!=null)
          Cursor_qbe_tab_mmc_da_a_data_filter.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_DA_DATAOPE,java.sql.Date p_A_DATAOPE,String p_TBL) {
    DA_DATAOPE = p_DA_DATAOPE;
    A_DATAOPE = p_A_DATAOPE;
    TBL = p_TBL;
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
  public boolean Run(java.sql.Date p_DA_DATAOPE,java.sql.Date p_A_DATAOPE,String p_TBL) {
    DA_DATAOPE = p_DA_DATAOPE;
    A_DATAOPE = p_A_DATAOPE;
    TBL = p_TBL;
    return Run();
  }
  public boolean Run() {
    boolean l_result;
    l_result = false;
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
        l_result = stop_value.GetLogic();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = false;
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
  public static arfn_allinea_datareg_dataopeR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_allinea_datareg_dataopeR(p_Ctx, p_Caller);
  }
  public static arfn_allinea_datareg_dataopeR Make(CPContext p_Ctx) {
    return new arfn_allinea_datareg_dataopeR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    DA_DATAOPE = CPLib.NullDate();
    A_DATAOPE = CPLib.NullDate();
    TBL = CPLib.Space(1);
    ritorno = false;
    tot_record = 0;
    tot_record_str = CPLib.Space(13);
    DA_DATAOPE_str = CPLib.Space(8);
    A_DATAOPE_str = CPLib.Space(8);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tab_mmc_da_a_data_filter,qbe_tab_mmc_da_a_data_filter,
  public static final String m_cVQRList = ",qbe_tab_mmc_da_a_data_filter,qbe_tab_mmc_da_a_data_filter,";
  // ENTITY_BATCHES: ,arfn_allinea_datareg_dataope,arfn_fdate,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_allinea_datareg_dataope,arfn_fdate,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"DA_DATAOPE","A_DATAOPE","TBL"};
}
