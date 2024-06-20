// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_modi_aggoperR implements CallerWithObjs {
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
  public String w_IDBASE;
  public String w_DURAT;
  public double w_RFREQ;
  public String w_AMMONT;
  public double w_RIMP;
  public String w_AREAGEO;
  public double w_RAREA;
  public String w_MODSVOL;
  public double w_RCOMP;
  public String w_RAGIO;
  public double w_RRAGIO;
  public String w_TIPO;
  public double w_RTIPO;
  public double w_NOPROT;
  public String w_OPERAG;
  public String w_RESPINS;
  public String w_SCOPO;
  public String w_NATURA;
  public String w_INFORM;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_modi_aggoperR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_modi_aggoper",m_Caller);
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("RFREQ",p_cVarName)) {
      return w_RFREQ;
    }
    if (CPLib.eqr("RIMP",p_cVarName)) {
      return w_RIMP;
    }
    if (CPLib.eqr("RAREA",p_cVarName)) {
      return w_RAREA;
    }
    if (CPLib.eqr("RCOMP",p_cVarName)) {
      return w_RCOMP;
    }
    if (CPLib.eqr("RRAGIO",p_cVarName)) {
      return w_RRAGIO;
    }
    if (CPLib.eqr("RTIPO",p_cVarName)) {
      return w_RTIPO;
    }
    if (CPLib.eqr("NOPROT",p_cVarName)) {
      return w_NOPROT;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_modi_aggoper";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("IDBASE",p_cVarName)) {
      return w_IDBASE;
    }
    if (CPLib.eqr("DURAT",p_cVarName)) {
      return w_DURAT;
    }
    if (CPLib.eqr("AMMONT",p_cVarName)) {
      return w_AMMONT;
    }
    if (CPLib.eqr("AREAGEO",p_cVarName)) {
      return w_AREAGEO;
    }
    if (CPLib.eqr("MODSVOL",p_cVarName)) {
      return w_MODSVOL;
    }
    if (CPLib.eqr("RAGIO",p_cVarName)) {
      return w_RAGIO;
    }
    if (CPLib.eqr("TIPO",p_cVarName)) {
      return w_TIPO;
    }
    if (CPLib.eqr("OPERAG",p_cVarName)) {
      return w_OPERAG;
    }
    if (CPLib.eqr("RESPINS",p_cVarName)) {
      return w_RESPINS;
    }
    if (CPLib.eqr("SCOPO",p_cVarName)) {
      return w_SCOPO;
    }
    if (CPLib.eqr("NATURA",p_cVarName)) {
      return w_NATURA;
    }
    if (CPLib.eqr("INFORM",p_cVarName)) {
      return w_INFORM;
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
    if (CPLib.eqr("RFREQ",p_cVarName)) {
      w_RFREQ = value;
      return;
    }
    if (CPLib.eqr("RIMP",p_cVarName)) {
      w_RIMP = value;
      return;
    }
    if (CPLib.eqr("RAREA",p_cVarName)) {
      w_RAREA = value;
      return;
    }
    if (CPLib.eqr("RCOMP",p_cVarName)) {
      w_RCOMP = value;
      return;
    }
    if (CPLib.eqr("RRAGIO",p_cVarName)) {
      w_RRAGIO = value;
      return;
    }
    if (CPLib.eqr("RTIPO",p_cVarName)) {
      w_RTIPO = value;
      return;
    }
    if (CPLib.eqr("NOPROT",p_cVarName)) {
      w_NOPROT = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("IDBASE",p_cVarName)) {
      w_IDBASE = value;
      return;
    }
    if (CPLib.eqr("DURAT",p_cVarName)) {
      w_DURAT = value;
      return;
    }
    if (CPLib.eqr("AMMONT",p_cVarName)) {
      w_AMMONT = value;
      return;
    }
    if (CPLib.eqr("AREAGEO",p_cVarName)) {
      w_AREAGEO = value;
      return;
    }
    if (CPLib.eqr("MODSVOL",p_cVarName)) {
      w_MODSVOL = value;
      return;
    }
    if (CPLib.eqr("RAGIO",p_cVarName)) {
      w_RAGIO = value;
      return;
    }
    if (CPLib.eqr("TIPO",p_cVarName)) {
      w_TIPO = value;
      return;
    }
    if (CPLib.eqr("OPERAG",p_cVarName)) {
      w_OPERAG = value;
      return;
    }
    if (CPLib.eqr("RESPINS",p_cVarName)) {
      w_RESPINS = value;
      return;
    }
    if (CPLib.eqr("SCOPO",p_cVarName)) {
      w_SCOPO = value;
      return;
    }
    if (CPLib.eqr("NATURA",p_cVarName)) {
      w_NATURA = value;
      return;
    }
    if (CPLib.eqr("INFORM",p_cVarName)) {
      w_INFORM = value;
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
    /* w_IDBASE Char(10) */
    /* w_DURAT Char(5) */
    /* w_RFREQ Numeric(3, 0) */
    /* w_AMMONT Char(5) */
    /* w_RIMP Numeric(3, 0) */
    /* w_AREAGEO Char(5) */
    /* w_RAREA Numeric(3, 0) // Indice Rischio */
    /* w_MODSVOL Char(5) // Modalità Svolgimento */
    /* w_RCOMP Numeric(3, 0) // Indice di rischio */
    /* w_RAGIO Char(5) */
    /* w_RRAGIO Numeric(3, 0) // Indice di rischio */
    /* w_TIPO Char(3) */
    /* w_RTIPO Numeric(3, 0) // Indice di Rischio */
    /* w_NOPROT Numeric(1, 0) */
    /* w_OPERAG Char(3) */
    /* w_RESPINS Char(30) */
    /* w_SCOPO Char(50) */
    /* w_NATURA Char(50) */
    /* w_INFORM Char(30) */
    // * --- Write into operazbo from values
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("operazbo");
    m_cPhName = m_Ctx.GetPhName("operazbo");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("arrt_modi_aggoper",6,"00000015")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
    m_cSql = m_cSql+"RESPINS = "+CPLib.ToSQL(w_RESPINS,"C",30,0,m_cServer)+", ";
    m_cSql = m_cSql+"INFORM = "+CPLib.ToSQL(w_INFORM,"C",30,0,m_cServer)+", ";
    m_cSql = m_cSql+"NOPROT = "+CPLib.ToSQL(w_NOPROT,"N",1,0)+", ";
    m_cSql = m_cSql+"RAGIO = "+CPLib.ToSQL(w_RAGIO,"C",5,0,m_cServer)+", ";
    m_cSql = m_cSql+"MODSVOL = "+CPLib.ToSQL(w_MODSVOL,"C",5,0,m_cServer)+", ";
    m_cSql = m_cSql+"AREAGEO = "+CPLib.ToSQL(w_AREAGEO,"C",5,0,m_cServer)+", ";
    m_cSql = m_cSql+"OPERAG = "+CPLib.ToSQL(w_OPERAG,"C",3,0,m_cServer)+", ";
    m_cSql = m_cSql+"SCOPO = "+CPLib.ToSQL(w_SCOPO,"C",50,0,m_cServer)+", ";
    m_cSql = m_cSql+"NATURA = "+CPLib.ToSQL(w_NATURA,"C",50,0,m_cServer)+", ";
    m_cSql = m_cSql+"RTIPO = "+CPLib.ToSQL(w_RTIPO,"N",3,0)+", ";
    m_cSql = m_cSql+"RCOMP = "+CPLib.ToSQL(w_RCOMP,"N",3,0)+", ";
    m_cSql = m_cSql+"RIMP = "+CPLib.ToSQL(w_RIMP,"N",3,0)+", ";
    m_cSql = m_cSql+"RFREQ = "+CPLib.ToSQL(w_RFREQ,"N",3,0)+", ";
    m_cSql = m_cSql+"RRAGIO = "+CPLib.ToSQL(w_RRAGIO,"N",3,0)+", ";
    m_cSql = m_cSql+"RAREA = "+CPLib.ToSQL(w_RAREA,"N",3,0)+", ";
    m_cSql = m_cSql+"TIPO = "+CPLib.ToSQL(w_TIPO,"C",2,0,m_cServer)+", ";
    m_cSql = m_cSql+"DURAT = "+CPLib.ToSQL(w_DURAT,"C",2,0,m_cServer)+", ";
    m_cSql = m_cSql+"AMMONT = "+CPLib.ToSQL(w_AMMONT,"C",2,0,m_cServer)+", ";
    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
    m_cSql = m_cSql+" where ";
    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_IDBASE,"?",0,0,m_cServer),m_cServer,w_IDBASE)+"";
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
      m_Caller.SetString("IDBASE","C",10,0,w_IDBASE);
      m_Caller.SetString("DURAT","C",5,0,w_DURAT);
      m_Caller.SetNumber("RFREQ","N",3,0,w_RFREQ);
      m_Caller.SetString("AMMONT","C",5,0,w_AMMONT);
      m_Caller.SetNumber("RIMP","N",3,0,w_RIMP);
      m_Caller.SetString("AREAGEO","C",5,0,w_AREAGEO);
      m_Caller.SetNumber("RAREA","N",3,0,w_RAREA);
      m_Caller.SetString("MODSVOL","C",5,0,w_MODSVOL);
      m_Caller.SetNumber("RCOMP","N",3,0,w_RCOMP);
      m_Caller.SetString("RAGIO","C",5,0,w_RAGIO);
      m_Caller.SetNumber("RRAGIO","N",3,0,w_RRAGIO);
      m_Caller.SetString("TIPO","C",3,0,w_TIPO);
      m_Caller.SetNumber("RTIPO","N",3,0,w_RTIPO);
      m_Caller.SetNumber("NOPROT","N",1,0,w_NOPROT);
      m_Caller.SetString("OPERAG","C",3,0,w_OPERAG);
      m_Caller.SetString("RESPINS","C",30,0,w_RESPINS);
      m_Caller.SetString("SCOPO","C",50,0,w_SCOPO);
      m_Caller.SetString("NATURA","C",50,0,w_NATURA);
      m_Caller.SetString("INFORM","C",30,0,w_INFORM);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_modi_aggoperR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_modi_aggoperR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_IDBASE = m_Caller.GetString("IDBASE","C",10,0);
    w_DURAT = m_Caller.GetString("DURAT","C",5,0);
    w_RFREQ = m_Caller.GetNumber("RFREQ","N",3,0);
    w_AMMONT = m_Caller.GetString("AMMONT","C",5,0);
    w_RIMP = m_Caller.GetNumber("RIMP","N",3,0);
    w_AREAGEO = m_Caller.GetString("AREAGEO","C",5,0);
    w_RAREA = m_Caller.GetNumber("RAREA","N",3,0);
    w_MODSVOL = m_Caller.GetString("MODSVOL","C",5,0);
    w_RCOMP = m_Caller.GetNumber("RCOMP","N",3,0);
    w_RAGIO = m_Caller.GetString("RAGIO","C",5,0);
    w_RRAGIO = m_Caller.GetNumber("RRAGIO","N",3,0);
    w_TIPO = m_Caller.GetString("TIPO","C",3,0);
    w_RTIPO = m_Caller.GetNumber("RTIPO","N",3,0);
    w_NOPROT = m_Caller.GetNumber("NOPROT","N",1,0);
    w_OPERAG = m_Caller.GetString("OPERAG","C",3,0);
    w_RESPINS = m_Caller.GetString("RESPINS","C",30,0);
    w_SCOPO = m_Caller.GetString("SCOPO","C",50,0);
    w_NATURA = m_Caller.GetString("NATURA","C",50,0);
    w_INFORM = m_Caller.GetString("INFORM","C",30,0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
