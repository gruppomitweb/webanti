// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_closerap_startR implements CallerWithObjs {
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
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_xoginfo;
  public String m_cServer_xoginfo;
  public String m_cPhName_soginfo;
  public String m_cServer_soginfo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xtatorap;
  public String m_cServer_xtatorap;
  public String m_cPhName_statorap;
  public String m_cServer_statorap;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_xelegabo;
  public String m_cServer_xelegabo;
  public String m_cPhName_tmp_rapportipd;
  public String m_cServer_tmp_rapportipd;
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
  public double _close;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_closerap_startR (CPContext p_ContextObject, Caller caller) {
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
                                all'oggetto globale (unico per pi� istanze di una stessa applicazione)
                                per recuperare informazioni sul:
                                1) nome fisico della tabella di gestione;
                                2) nome fisico delle tabelle collegate nei link;
                                3) stringa di connessione.
                                L'azienda � contenuta nel global object.
                             */
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_closerap_start",m_Caller);
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    m_cPhName_xoginfo = p_ContextObject.GetPhName("xoginfo");
    if (m_cPhName_xoginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xoginfo = m_cPhName_xoginfo+" "+m_Ctx.GetWritePhName("xoginfo");
    }
    m_cServer_xoginfo = p_ContextObject.GetServer("xoginfo");
    m_cPhName_soginfo = p_ContextObject.GetPhName("soginfo");
    if (m_cPhName_soginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_soginfo = m_cPhName_soginfo+" "+m_Ctx.GetWritePhName("soginfo");
    }
    m_cServer_soginfo = p_ContextObject.GetServer("soginfo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_xtatorap = p_ContextObject.GetPhName("xtatorap");
    if (m_cPhName_xtatorap.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xtatorap = m_cPhName_xtatorap+" "+m_Ctx.GetWritePhName("xtatorap");
    }
    m_cServer_xtatorap = p_ContextObject.GetServer("xtatorap");
    m_cPhName_statorap = p_ContextObject.GetPhName("statorap");
    if (m_cPhName_statorap.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_statorap = m_cPhName_statorap+" "+m_Ctx.GetWritePhName("statorap");
    }
    m_cServer_statorap = p_ContextObject.GetServer("statorap");
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    if (m_cPhName_knarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_knarapbo = m_cPhName_knarapbo+" "+m_Ctx.GetWritePhName("knarapbo");
    }
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_xelegabo = p_ContextObject.GetPhName("xelegabo");
    if (m_cPhName_xelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xelegabo = m_cPhName_xelegabo+" "+m_Ctx.GetWritePhName("xelegabo");
    }
    m_cServer_xelegabo = p_ContextObject.GetServer("xelegabo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_rapportipd")) {
      m_cPhName_tmp_rapportipd = p_ContextObject.GetPhName("tmp_rapportipd");
      if (m_cPhName_tmp_rapportipd.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_rapportipd = m_cPhName_tmp_rapportipd+" "+m_Ctx.GetWritePhName("tmp_rapportipd");
      }
      m_cServer_tmp_rapportipd = p_ContextObject.GetServer("tmp_rapportipd");
    }
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_close",p_cVarName)) {
      return _close;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_closerap_start";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
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
    if (CPLib.eqr("_close",p_cVarName)) {
      _close = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
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
    CPResultSet Cursor_anarapbo=null;
    CPResultSet Cursor_rapopebo=null;
    try {
      /* Definizione variabili locali */
      /* _close Numeric(1, 0) */
      /* Crea la tabella d'appoggio */
      // * --- Drop temporary table tmp_rapportipd
      if (m_Ctx.IsSharedTemp("tmp_rapportipd")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_rapportipd")) {
          m_cServer = m_Ctx.GetServer("tmp_rapportipd");
          m_cPhName = m_Ctx.GetPhName("tmp_rapportipd");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_rapportipd");
      }
      // * --- Create temporary table tmp_rapportipd
      if (m_Ctx.IsSharedTemp("tmp_rapportipd")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_rapportipd")) {
          m_cServer = m_Ctx.GetServer("tmp_rapportipd");
          m_cPhName = m_Ctx.GetPhName("tmp_rapportipd");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_rapportipd");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_rapportipd");
      if ( ! (m_Ctx.IsSharedTemp("tmp_rapportipd"))) {
        m_cServer = m_Ctx.GetServer("tmp_rapportipd");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_rapportipd",m_cServer,"proto")),m_cPhName,"tmp_rapportipd",m_Ctx);
      }
      m_cPhName_tmp_rapportipd = m_cPhName;
      /* Cicla sui rapporti e trova quelli non chiusi */
      // * --- Select from anarapbo
      m_cServer = m_Ctx.GetServer("anarapbo");
      m_cPhName = m_Ctx.GetPhName("anarapbo");
      if (Cursor_anarapbo!=null)
        Cursor_anarapbo.Close();
      Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("anarapbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_anarapbo.Eof())) {
        /* _close := 0 */
        _close = CPLib.Round(0,0);
        // * --- Select from rapopebo
        m_cServer = m_Ctx.GetServer("rapopebo");
        m_cPhName = m_Ctx.GetPhName("rapopebo");
        if (Cursor_rapopebo!=null)
          Cursor_rapopebo.Close();
        Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_anarapbo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_rapopebo.Eof())) {
          /* If rapopebo->TIPOOPRAP='26' or rapopebo->TIPOOPRAP='36' or rapopebo->TIPOOPRAP='46' */
          if (CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"26") || CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"36") || CPLib.eqr(Cursor_rapopebo.GetString("TIPOOPRAP"),"46")) {
            /* _close := 1 */
            _close = CPLib.Round(1,0);
          } // End If
          Cursor_rapopebo.Next();
        }
        m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
        Cursor_rapopebo.Close();
        // * --- End Select
        /* If _close = 0 */
        if (CPLib.eqr(_close,0)) {
          // * --- Insert into tmp_rapportipd from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_rapportipd");
          m_cPhName = m_Ctx.GetPhName("tmp_rapportipd");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_rapportipd",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_closerap_start",51,"0000000D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000000D(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("DESCRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_rapportipd",true);
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
        Cursor_anarapbo.Next();
      }
      m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
      Cursor_anarapbo.Close();
      // * --- End Select
      /* Return  */
      Forward f;
      f=new Forward("arpg_closerap",false,this,Forward.Start,false);
      f.SetParameter("m_cParameterSequence", "");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_rapopebo!=null)
          Cursor_rapopebo.Close();
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
  public static arrt_closerap_startR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_closerap_startR(p_Ctx, p_Caller);
  }
  public void Blank() {
    _close = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000000D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"FLGSEL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_rapportipd",true);
    return p_cSql;
  }
}
