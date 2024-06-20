// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_save_cgo_anadip_errR implements CallerWithObjs {
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
  public String m_cPhName_cgo_anadip_err;
  public String m_cServer_cgo_anadip_err;
  public String m_cPhName_cgo_anadip;
  public String m_cServer_cgo_anadip;
  public String m_cPhName_cgo_telematico_err;
  public String m_cServer_cgo_telematico_err;
  public String m_cPhName_cgo_telematico;
  public String m_cServer_cgo_telematico;
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
  public String pPRGDIP;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_save_cgo_anadip_errR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_save_cgo_anadip_err",m_Caller);
    m_cPhName_cgo_anadip_err = p_ContextObject.GetPhName("cgo_anadip_err");
    if (m_cPhName_cgo_anadip_err.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_anadip_err = m_cPhName_cgo_anadip_err+" "+m_Ctx.GetWritePhName("cgo_anadip_err");
    }
    m_cServer_cgo_anadip_err = p_ContextObject.GetServer("cgo_anadip_err");
    m_cPhName_cgo_anadip = p_ContextObject.GetPhName("cgo_anadip");
    if (m_cPhName_cgo_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_anadip = m_cPhName_cgo_anadip+" "+m_Ctx.GetWritePhName("cgo_anadip");
    }
    m_cServer_cgo_anadip = p_ContextObject.GetServer("cgo_anadip");
    m_cPhName_cgo_telematico_err = p_ContextObject.GetPhName("cgo_telematico_err");
    if (m_cPhName_cgo_telematico_err.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_telematico_err = m_cPhName_cgo_telematico_err+" "+m_Ctx.GetWritePhName("cgo_telematico_err");
    }
    m_cServer_cgo_telematico_err = p_ContextObject.GetServer("cgo_telematico_err");
    m_cPhName_cgo_telematico = p_ContextObject.GetPhName("cgo_telematico");
    if (m_cPhName_cgo_telematico.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_telematico = m_cPhName_cgo_telematico+" "+m_Ctx.GetWritePhName("cgo_telematico");
    }
    m_cServer_cgo_telematico = p_ContextObject.GetServer("cgo_telematico");
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
      return "arrt_save_cgo_anadip_err";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pPRGDIP",p_cVarName)) {
      return pPRGDIP;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pPRGDIP",p_cVarName)) {
      pPRGDIP = value;
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
    CPResultSet Cursor_cgo_anadip_err=null;
    CPResultSet Cursor_cgo_telematico_err=null;
    try {
      /* Chiave  */
      /* pPRGDIP Char(15) */
      /* Legge tabella errori e riporta eventualmente su tabella import */
      /* Exec Routine arrt_writelog('VARIAZIONE','CGO_ANADIP_ERR',pPRGDIP) */
      arrt_writelogR.Make(m_Ctx,this).Run("VARIAZIONE","CGO_ANADIP_ERR",pPRGDIP);
      // * --- Select from cgo_anadip_err
      m_cServer = m_Ctx.GetServer("cgo_anadip_err");
      m_cPhName = m_Ctx.GetPhName("cgo_anadip_err");
      if (Cursor_cgo_anadip_err!=null)
        Cursor_cgo_anadip_err.Close();
      Cursor_cgo_anadip_err = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PRGDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(pPRGDIP,"?",0,0,m_cServer, m_oParameters),m_cServer,pPRGDIP)+" "+")"+(m_Ctx.IsSharedTemp("cgo_anadip_err")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_anadip_err.Eof())) {
        /* If cgo_anadip_err->FLGFULL='S' */
        if (CPLib.eqr(Cursor_cgo_anadip_err.GetString("FLGFULL"),"S")) {
          // * --- Insert into cgo_anadip from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_anadip");
          m_cPhName = m_Ctx.GetPhName("cgo_anadip");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_anadip",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_save_cgo_anadip_err",30,"00000007")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000007(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip_err.GetString("CODDIP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip_err.GetString("DESCRIZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip_err.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip_err.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip_err.GetString("CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip_err.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip_err.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip_err.GetString("TELEFONO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip_err.GetString("CODLOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_anadip_err.GetString("CODICEAAMS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_anadip",true);
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
          // * --- Select from cgo_telematico_err
          m_cServer = m_Ctx.GetServer("cgo_telematico_err");
          m_cPhName = m_Ctx.GetPhName("cgo_telematico_err");
          if (Cursor_cgo_telematico_err!=null)
            Cursor_cgo_telematico_err.Close();
          Cursor_cgo_telematico_err = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_cgo_anadip_err.GetString("CODDIP"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("cgo_telematico_err")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_telematico_err.Eof())) {
            // * --- Insert into cgo_telematico from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_telematico");
            m_cPhName = m_Ctx.GetPhName("cgo_telematico");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_save_cgo_anadip_err",30,"00000009")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000009(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetString("SNAINUMOPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetString("ENV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetDouble("TOTLIRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetDouble("CACODICE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetDateTime("CADATAORA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetString("CAIDBIGLIETTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetDouble("CSMF_COD"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetDouble("NUM_CONC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetDouble("P_VEND"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetDouble("DUCOLLEG"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetString("IBAN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetString("MEZPAGAM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetDouble("CATIPGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetDouble("CATIPCON"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetDouble("CAPV_COD"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_cgo_telematico_err.GetString("VPCODICE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico",true);
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
            // * --- Delete from cgo_telematico_err
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_telematico_err");
            m_cPhName = m_Ctx.GetPhName("cgo_telematico_err");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico_err",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_save_cgo_anadip_err",30,"0000000A")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_cgo_telematico_err.GetString("SNAINUMOPE"),"?",0,0,m_cServer),m_cServer,Cursor_cgo_telematico_err.GetString("SNAINUMOPE"))+"";
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
            Cursor_cgo_telematico_err.Next();
          }
          m_cConnectivityError = Cursor_cgo_telematico_err.ErrorMessage();
          Cursor_cgo_telematico_err.Close();
          // * --- End Select
          // * --- Delete from cgo_anadip_err
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_anadip_err");
          m_cPhName = m_Ctx.GetPhName("cgo_anadip_err");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_anadip_err",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_save_cgo_anadip_err",30,"0000000B")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"PRGDIP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pPRGDIP,"?",0,0,m_cServer),m_cServer,pPRGDIP)+"";
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
        Cursor_cgo_anadip_err.Next();
      }
      m_cConnectivityError = Cursor_cgo_anadip_err.ErrorMessage();
      Cursor_cgo_anadip_err.Close();
      // * --- End Select
      /* Stop arpg_cgo_anadip_err */
      Forward f;
      f=new Forward("arpg_cgo_anadip_err",false,this,Forward.Start,false);
      f.SetParameter("m_cParameterSequence", "");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_cgo_anadip_err!=null)
          Cursor_cgo_anadip_err.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_telematico_err!=null)
          Cursor_cgo_telematico_err.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pPRGDIP) {
    pPRGDIP = p_pPRGDIP;
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
  public Forward Run(String p_pPRGDIP) {
    pPRGDIP = p_pPRGDIP;
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
  public static arrt_save_cgo_anadip_errR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_save_cgo_anadip_errR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pPRGDIP = CPLib.Space(15);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arrt_writelog,
  public static final String i_InvokedRoutines = ",arrt_writelog,";
  public static String[] m_cRunParameterNames={"pPRGDIP"};
  protected static String GetFieldsName_00000007(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CAB,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"TELEFONO,";
    p_cSql = p_cSql+"CODLOC,";
    p_cSql = p_cSql+"CODICEAAMS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_anadip",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000009(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"CSMF_COD,";
    p_cSql = p_cSql+"NUM_CONC,";
    p_cSql = p_cSql+"P_VEND,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"IBAN,";
    p_cSql = p_cSql+"MEZPAGAM,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico",true);
    return p_cSql;
  }
}
