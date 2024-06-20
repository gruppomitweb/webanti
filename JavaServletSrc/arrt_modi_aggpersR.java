// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_modi_aggpersR implements CallerWithObjs {
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
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
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
  public String w_CONNES;
  public String w_AREAGEO;
  public String w_BANCABEN;
  public String w_COMPORT;
  public String w_PKTBSPECIE;
  public double w_RAREA;
  public double w_RCOMP;
  public double w_RNATGIU;
  public String w_CITTADIN1;
  public String w_CITTADIN2;
  public String w_RESFISC;
  public double w_MITIG;
  public String w_MITGDOC;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_modi_aggpersR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_modi_aggpers",m_Caller);
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("RAREA",p_cVarName)) {
      return w_RAREA;
    }
    if (CPLib.eqr("RCOMP",p_cVarName)) {
      return w_RCOMP;
    }
    if (CPLib.eqr("RNATGIU",p_cVarName)) {
      return w_RNATGIU;
    }
    if (CPLib.eqr("MITIG",p_cVarName)) {
      return w_MITIG;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_modi_aggpers";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("CONNES",p_cVarName)) {
      return w_CONNES;
    }
    if (CPLib.eqr("AREAGEO",p_cVarName)) {
      return w_AREAGEO;
    }
    if (CPLib.eqr("BANCABEN",p_cVarName)) {
      return w_BANCABEN;
    }
    if (CPLib.eqr("COMPORT",p_cVarName)) {
      return w_COMPORT;
    }
    if (CPLib.eqr("PKTBSPECIE",p_cVarName)) {
      return w_PKTBSPECIE;
    }
    if (CPLib.eqr("CITTADIN1",p_cVarName)) {
      return w_CITTADIN1;
    }
    if (CPLib.eqr("CITTADIN2",p_cVarName)) {
      return w_CITTADIN2;
    }
    if (CPLib.eqr("RESFISC",p_cVarName)) {
      return w_RESFISC;
    }
    if (CPLib.eqr("MITGDOC",p_cVarName)) {
      return w_MITGDOC;
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
    if (CPLib.eqr("RAREA",p_cVarName)) {
      w_RAREA = value;
      return;
    }
    if (CPLib.eqr("RCOMP",p_cVarName)) {
      w_RCOMP = value;
      return;
    }
    if (CPLib.eqr("RNATGIU",p_cVarName)) {
      w_RNATGIU = value;
      return;
    }
    if (CPLib.eqr("MITIG",p_cVarName)) {
      w_MITIG = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("CONNES",p_cVarName)) {
      w_CONNES = value;
      return;
    }
    if (CPLib.eqr("AREAGEO",p_cVarName)) {
      w_AREAGEO = value;
      return;
    }
    if (CPLib.eqr("BANCABEN",p_cVarName)) {
      w_BANCABEN = value;
      return;
    }
    if (CPLib.eqr("COMPORT",p_cVarName)) {
      w_COMPORT = value;
      return;
    }
    if (CPLib.eqr("PKTBSPECIE",p_cVarName)) {
      w_PKTBSPECIE = value;
      return;
    }
    if (CPLib.eqr("CITTADIN1",p_cVarName)) {
      w_CITTADIN1 = value;
      return;
    }
    if (CPLib.eqr("CITTADIN2",p_cVarName)) {
      w_CITTADIN2 = value;
      return;
    }
    if (CPLib.eqr("RESFISC",p_cVarName)) {
      w_RESFISC = value;
      return;
    }
    if (CPLib.eqr("MITGDOC",p_cVarName)) {
      w_MITGDOC = value;
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
    /* w_CONNES Char(16) */
    /* w_AREAGEO Char(5) */
    /* w_BANCABEN Char(11) // Codice Banca se Beneficiario */
    /* w_COMPORT Char(5) */
    /* w_PKTBSPECIE Char(4) // Modalità Svolgimento */
    /* w_RAREA Numeric(3, 0) // Indice Rischio */
    /* w_RCOMP Numeric(3, 0) // Indice Rischio */
    /* w_RNATGIU Numeric(3, 0) // Indice di rischio */
    /* w_CITTADIN1 Char(3) // Cittadinanza 1 */
    /* w_CITTADIN2 Char(3) // Cittadinanza 2 */
    /* w_RESFISC Char(3) // Residenza Fiscale */
    /* w_MITIG Numeric(4, 0) // Mitigazione */
    /* w_MITGDOC Char(100) // Documentazione Mitigazione */
    // * --- Write into personbo from values
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("personbo");
    m_cPhName = m_Ctx.GetPhName("personbo");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("arrt_modi_aggpers",13,"0000000F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
    m_cSql = m_cSql+"AREAGEO = "+CPLib.ToSQL(w_AREAGEO,"C",3,0,m_cServer)+", ";
    m_cSql = m_cSql+"COMPORT = "+CPLib.ToSQL(w_COMPORT,"C",5,0,m_cServer)+", ";
    m_cSql = m_cSql+"PKTBSPECIE = "+CPLib.ToSQL(w_PKTBSPECIE,"C",4,0,m_cServer)+", ";
    m_cSql = m_cSql+"RAREA = "+CPLib.ToSQL(w_RAREA,"N",3,0)+", ";
    m_cSql = m_cSql+"RCOMP = "+CPLib.ToSQL(w_RCOMP,"N",3,0)+", ";
    m_cSql = m_cSql+"RNATGIU = "+CPLib.ToSQL(w_RNATGIU,"N",3,0)+", ";
    m_cSql = m_cSql+"BANCABEN = "+CPLib.ToSQL(w_BANCABEN,"C",11,0,m_cServer)+", ";
    m_cSql = m_cSql+"CITTADIN1 = "+CPLib.ToSQL(w_CITTADIN1,"C",3,0,m_cServer)+", ";
    m_cSql = m_cSql+"CITTADIN2 = "+CPLib.ToSQL(w_CITTADIN2,"C",3,0,m_cServer)+", ";
    m_cSql = m_cSql+"RESFISC = "+CPLib.ToSQL(w_RESFISC,"C",3,0,m_cServer)+", ";
    m_cSql = m_cSql+"MITIG = "+CPLib.ToSQL(w_MITIG,"N",4,0)+", ";
    m_cSql = m_cSql+"MITIGDOC = "+CPLib.ToSQL(w_MITGDOC,"C",100,0,m_cServer)+", ";
    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
    m_cSql = m_cSql+" where ";
    m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CONNES,"?",0,0,m_cServer),m_cServer,w_CONNES)+"";
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
      m_Caller.SetString("CONNES","C",16,0,w_CONNES);
      m_Caller.SetString("AREAGEO","C",5,0,w_AREAGEO);
      m_Caller.SetString("BANCABEN","C",11,0,w_BANCABEN);
      m_Caller.SetString("COMPORT","C",5,0,w_COMPORT);
      m_Caller.SetString("PKTBSPECIE","C",4,0,w_PKTBSPECIE);
      m_Caller.SetNumber("RAREA","N",3,0,w_RAREA);
      m_Caller.SetNumber("RCOMP","N",3,0,w_RCOMP);
      m_Caller.SetNumber("RNATGIU","N",3,0,w_RNATGIU);
      m_Caller.SetString("CITTADIN1","C",3,0,w_CITTADIN1);
      m_Caller.SetString("CITTADIN2","C",3,0,w_CITTADIN2);
      m_Caller.SetString("RESFISC","C",3,0,w_RESFISC);
      m_Caller.SetNumber("MITIG","N",4,0,w_MITIG);
      m_Caller.SetString("MITGDOC","C",100,0,w_MITGDOC);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_modi_aggpersR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_modi_aggpersR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_CONNES = m_Caller.GetString("CONNES","C",16,0);
    w_AREAGEO = m_Caller.GetString("AREAGEO","C",5,0);
    w_BANCABEN = m_Caller.GetString("BANCABEN","C",11,0);
    w_COMPORT = m_Caller.GetString("COMPORT","C",5,0);
    w_PKTBSPECIE = m_Caller.GetString("PKTBSPECIE","C",4,0);
    w_RAREA = m_Caller.GetNumber("RAREA","N",3,0);
    w_RCOMP = m_Caller.GetNumber("RCOMP","N",3,0);
    w_RNATGIU = m_Caller.GetNumber("RNATGIU","N",3,0);
    w_CITTADIN1 = m_Caller.GetString("CITTADIN1","C",3,0);
    w_CITTADIN2 = m_Caller.GetString("CITTADIN2","C",3,0);
    w_RESFISC = m_Caller.GetString("RESFISC","C",3,0);
    w_MITIG = m_Caller.GetNumber("MITIG","N",4,0);
    w_MITGDOC = m_Caller.GetString("MITGDOC","C",100,0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
