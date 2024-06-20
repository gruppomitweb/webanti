// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_trasftit_selR implements CallerWithObjs {
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
  public String m_cPhName_tmp_trasfope;
  public String m_cServer_tmp_trasfope;
  public String m_cPhName_tmp_trasftit;
  public String m_cServer_tmp_trasftit;
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
  public String w_DaConnes;
  public String w_AConnes;
  public String w_xragsoc1;
  public String w_xragsoc2;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_trasftit_selR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_trasftit_sel",m_Caller);
    m_cPhName_tmp_trasfope = p_ContextObject.GetPhName("tmp_trasfope");
    if (m_cPhName_tmp_trasfope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_trasfope = m_cPhName_tmp_trasfope+" "+m_Ctx.GetWritePhName("tmp_trasfope");
    }
    m_cServer_tmp_trasfope = p_ContextObject.GetServer("tmp_trasfope");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_trasftit")) {
      m_cPhName_tmp_trasftit = p_ContextObject.GetPhName("tmp_trasftit");
      if (m_cPhName_tmp_trasftit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_trasftit = m_cPhName_tmp_trasftit+" "+m_Ctx.GetWritePhName("tmp_trasftit");
      }
      m_cServer_tmp_trasftit = p_ContextObject.GetServer("tmp_trasftit");
    }
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
      return "arrt_trasftit_sel";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("DaConnes",p_cVarName)) {
      return w_DaConnes;
    }
    if (CPLib.eqr("AConnes",p_cVarName)) {
      return w_AConnes;
    }
    if (CPLib.eqr("xragsoc1",p_cVarName)) {
      return w_xragsoc1;
    }
    if (CPLib.eqr("xragsoc2",p_cVarName)) {
      return w_xragsoc2;
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
    if (CPLib.eqr("DaConnes",p_cVarName)) {
      w_DaConnes = value;
      return;
    }
    if (CPLib.eqr("AConnes",p_cVarName)) {
      w_AConnes = value;
      return;
    }
    if (CPLib.eqr("xragsoc1",p_cVarName)) {
      w_xragsoc1 = value;
      return;
    }
    if (CPLib.eqr("xragsoc2",p_cVarName)) {
      w_xragsoc2 = value;
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
    CPResultSet Cursor_qbe_trasftit_sel=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Variabili del caller */
      /* w_DaConnes Char(16) */
      /* w_AConnes Char(16) */
      /* w_xragsoc1 Char(70) */
      /* w_xragsoc2 Char(70) */
      /* Variabili locali */
      // * --- Drop temporary table tmp_trasftit
      if (m_Ctx.IsSharedTemp("tmp_trasftit")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_trasftit")) {
          m_cServer = m_Ctx.GetServer("tmp_trasftit");
          m_cPhName = m_Ctx.GetPhName("tmp_trasftit");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_trasftit");
      }
      // * --- Create temporary table tmp_trasftit
      if (m_Ctx.IsSharedTemp("tmp_trasftit")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_trasftit")) {
          m_cServer = m_Ctx.GetServer("tmp_trasftit");
          m_cPhName = m_Ctx.GetPhName("tmp_trasftit");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_trasftit");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_trasftit");
      if ( ! (m_Ctx.IsSharedTemp("tmp_trasftit"))) {
        m_cServer = m_Ctx.GetServer("tmp_trasftit");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_trasftit",m_cServer,"proto")),m_cPhName,"tmp_trasftit",m_Ctx);
      }
      m_cPhName_tmp_trasftit = m_cPhName;
      /* Crea la tabella d'appoggio */
      // * --- Select from qbe_trasftit_sel
      if (Cursor_qbe_trasftit_sel!=null)
        Cursor_qbe_trasftit_sel.Close();
      Cursor_qbe_trasftit_sel = new VQRHolder("qbe_trasftit_sel",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_trasftit_sel.Eof())) {
        // * --- Insert into tmp_trasftit from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_trasftit");
        m_cPhName = m_Ctx.GetPhName("tmp_trasftit");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_trasftit",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_trasftit_sel",14,"0000000B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000000B(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasftit_sel.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasftit_sel.GetDate("DATAOPE"),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasftit_sel.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasftit_sel.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_trasftit_sel.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_trasftit",true);
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
        Cursor_qbe_trasftit_sel.Next();
      }
      m_cConnectivityError = Cursor_qbe_trasftit_sel.ErrorMessage();
      Cursor_qbe_trasftit_sel.Close();
      // * --- End Select
      /* Return  */
      Forward f;
      f=new Forward("arpg_trasftit",false,this,Forward.Start,false);
      f.SetParameter("AConnes",w_AConnes);
      f.SetParameter("DaConnes",w_DaConnes);
      f.SetParameter("xragsoc1",w_xragsoc1);
      f.SetParameter("xragsoc2",w_xragsoc2);
      f.SetParameter("m_bQuery",true);
      f.SetParameter("m_cParameterSequence","AConnes"+","+"DaConnes"+","+"xragsoc1"+","+"xragsoc2"+","+"m_bQuery");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_qbe_trasftit_sel!=null)
          Cursor_qbe_trasftit_sel.Close();
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
      m_Caller.SetString("DaConnes","C",16,0,w_DaConnes);
      m_Caller.SetString("AConnes","C",16,0,w_AConnes);
      m_Caller.SetString("xragsoc1","C",70,0,w_xragsoc1);
      m_Caller.SetString("xragsoc2","C",70,0,w_xragsoc2);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_trasftit_selR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_trasftit_selR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_DaConnes = m_Caller.GetString("DaConnes","C",16,0);
    w_AConnes = m_Caller.GetString("AConnes","C",16,0);
    w_xragsoc1 = m_Caller.GetString("xragsoc1","C",70,0);
    w_xragsoc2 = m_Caller.GetString("xragsoc2","C",70,0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_trasftit_sel,
  public static final String m_cVQRList = ",qbe_trasftit_sel,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000000B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"TIPOOPER,";
    p_cSql = p_cSql+"FLGSEL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_trasftit",true);
    return p_cSql;
  }
}
