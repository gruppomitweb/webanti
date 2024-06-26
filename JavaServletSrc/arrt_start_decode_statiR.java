// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_start_decode_statiR implements CallerWithObjs {
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
  public String m_cPhName_tmp_decode_stati;
  public String m_cServer_tmp_decode_stati;
  public String m_cPhName_decodestati;
  public String m_cServer_decodestati;
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
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_start_decode_statiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_start_decode_stati",m_Caller);
    if (m_Ctx.IsTmpAlreadyCreated("tmp_decode_stati")) {
      m_cPhName_tmp_decode_stati = p_ContextObject.GetPhName("tmp_decode_stati");
      if (m_cPhName_tmp_decode_stati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_decode_stati = m_cPhName_tmp_decode_stati+" "+m_Ctx.GetWritePhName("tmp_decode_stati");
      }
      m_cServer_tmp_decode_stati = p_ContextObject.GetServer("tmp_decode_stati");
    }
    m_cPhName_decodestati = p_ContextObject.GetPhName("decodestati");
    if (m_cPhName_decodestati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_decodestati = m_cPhName_decodestati+" "+m_Ctx.GetWritePhName("decodestati");
    }
    m_cServer_decodestati = p_ContextObject.GetServer("decodestati");
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
      return "arrt_start_decode_stati";
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
    CPResultSet Cursor_decodestati=null;
    try {
      /* Crea la tabella di appoggio */
      // * --- Drop temporary table tmp_decode_stati
      if (m_Ctx.IsSharedTemp("tmp_decode_stati")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_decode_stati")) {
          m_cServer = m_Ctx.GetServer("tmp_decode_stati");
          m_cPhName = m_Ctx.GetPhName("tmp_decode_stati");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_decode_stati");
      }
      // * --- Create temporary table tmp_decode_stati
      if (m_Ctx.IsSharedTemp("tmp_decode_stati")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_decode_stati")) {
          m_cServer = m_Ctx.GetServer("tmp_decode_stati");
          m_cPhName = m_Ctx.GetPhName("tmp_decode_stati");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_decode_stati");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_decode_stati");
      if ( ! (m_Ctx.IsSharedTemp("tmp_decode_stati"))) {
        m_cServer = m_Ctx.GetServer("tmp_decode_stati");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_decode_stati",m_cServer,"proto")),m_cPhName,"tmp_decode_stati",m_Ctx);
      }
      m_cPhName_tmp_decode_stati = m_cPhName;
      /* Seleziona le operazioni da passare */
      // * --- Select from DecodeStati
      m_cServer = m_Ctx.GetServer("DecodeStati");
      m_cPhName = m_Ctx.GetPhName("DecodeStati");
      if (Cursor_decodestati!=null)
        Cursor_decodestati.Close();
      Cursor_decodestati = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("DecodeStati")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_decodestati.Eof())) {
        /* If Empty(LRTrim(DecodeStati->CODSTA)) */
        if (CPLib.Empty(CPLib.LRTrim(Cursor_decodestati.GetString("CODSTA")))) {
          // * --- Insert into tmp_decode_stati from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_decode_stati");
          m_cPhName = m_Ctx.GetPhName("tmp_decode_stati");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_decode_stati",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_start_decode_stati",9,"00000007")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000007(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_decodestati.GetString("account"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_decodestati.GetString("CODSTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_decodestati.GetString("DESCRI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_decodestati.GetString("SIGLA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_decodestati.GetString("ISO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_decodestati.GetString("ISO2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_decodestati.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_decodestati.GetDouble("id"),"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_decode_stati",true);
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
        Cursor_decodestati.Next();
      }
      m_cConnectivityError = Cursor_decodestati.ErrorMessage();
      Cursor_decodestati.Close();
      // * --- End Select
      /* Stop arpg_agg_decstati */
      Forward f;
      f=new Forward("arpg_agg_decstati",false,this,Forward.Start,false);
      f.SetParameter("m_cParameterSequence", "");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_decodestati!=null)
          Cursor_decodestati.Close();
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
  public static arrt_start_decode_statiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_start_decode_statiR(p_Ctx, p_Caller);
  }
  public void Blank() {
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000007(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"account,";
    p_cSql = p_cSql+"CODSTA,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"SIGLA,";
    p_cSql = p_cSql+"ISO,";
    p_cSql = p_cSql+"ISO2,";
    p_cSql = p_cSql+"IDTBLS,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"id,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_decode_stati",true);
    return p_cSql;
  }
}
