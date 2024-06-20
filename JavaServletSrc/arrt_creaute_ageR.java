// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_creaute_ageR implements CallerWithObjs {
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
  public String m_cPhName_cpusers;
  public String m_cServer_cpusers;
  public String m_cPhName_cpusers_add;
  public String m_cServer_cpusers_add;
  public String m_cPhName_cpusrgrp;
  public String m_cServer_cpusrgrp;
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
  public String w_CODDIP;
  public String w_DESCRIZ;
  public String w_CODAGE;
  public double _code;
  public String cPassword;
  public String gAgeCGO;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_creaute_ageR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_creaute_age",m_Caller);
    m_cPhName_cpusers = p_ContextObject.GetPhName("cpusers");
    if (m_cPhName_cpusers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers = m_cPhName_cpusers+" "+m_Ctx.GetWritePhName("cpusers");
    }
    m_cServer_cpusers = p_ContextObject.GetServer("cpusers");
    m_cPhName_cpusers_add = p_ContextObject.GetPhName("cpusers_add");
    if (m_cPhName_cpusers_add.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers_add = m_cPhName_cpusers_add+" "+m_Ctx.GetWritePhName("cpusers_add");
    }
    m_cServer_cpusers_add = p_ContextObject.GetServer("cpusers_add");
    m_cPhName_cpusrgrp = p_ContextObject.GetPhName("cpusrgrp");
    if (m_cPhName_cpusrgrp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusrgrp = m_cPhName_cpusrgrp+" "+m_Ctx.GetWritePhName("cpusrgrp");
    }
    m_cServer_cpusrgrp = p_ContextObject.GetServer("cpusrgrp");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_code",p_cVarName)) {
      return _code;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_creaute_age";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("CODDIP",p_cVarName)) {
      return w_CODDIP;
    }
    if (CPLib.eqr("DESCRIZ",p_cVarName)) {
      return w_DESCRIZ;
    }
    if (CPLib.eqr("CODAGE",p_cVarName)) {
      return w_CODAGE;
    }
    if (CPLib.eqr("cPassword",p_cVarName)) {
      return cPassword;
    }
    if (CPLib.eqr("gAgeCGO",p_cVarName)) {
      return gAgeCGO;
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
    if (CPLib.eqr("_code",p_cVarName)) {
      _code = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("CODDIP",p_cVarName)) {
      w_CODDIP = value;
      return;
    }
    if (CPLib.eqr("DESCRIZ",p_cVarName)) {
      w_DESCRIZ = value;
      return;
    }
    if (CPLib.eqr("CODAGE",p_cVarName)) {
      w_CODAGE = value;
      return;
    }
    if (CPLib.eqr("cPassword",p_cVarName)) {
      cPassword = value;
      return;
    }
    if (CPLib.eqr("gAgeCGO",p_cVarName)) {
      gAgeCGO = value;
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
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_cpusers_max=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_CODDIP Char(6) // Codice Dipendenza */
      /* w_DESCRIZ Char(30) // Descrizione */
      /* w_CODAGE Char(15) // Codice AGENTE */
      /* _code Numeric(10, 0) */
      /* cPassword Char(20) */
      /* gAgeCGO Char(1) // Creazione Automatica agente */
      /* If gAgeCGO='S' */
      if (CPLib.eqr(gAgeCGO,"S")) {
        /* _code := 0 */
        _code = CPLib.Round(0,0);
        // * --- Read from cpusers
        m_cServer = m_Ctx.GetServer("cpusers");
        m_cPhName = m_Ctx.GetPhName("cpusers");
        m_cSql = "";
        m_cSql = m_cSql+"name="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_CODAGE,"C",50,0,m_cServer),m_cServer,w_CODAGE);
        if (m_Ctx.IsSharedTemp("cpusers")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("code",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _code = CPLib.Round(Read_Cursor.GetDouble("code"),0);
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on cpusers into routine arrt_creaute_age returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _code = 0;
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If _code=0 */
        if (CPLib.eqr(_code,0)) {
          // * --- Select from qbe_cpusers_max
          if (Cursor_qbe_cpusers_max!=null)
            Cursor_qbe_cpusers_max.Close();
          Cursor_qbe_cpusers_max = new VQRHolder("qbe_cpusers_max",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_cpusers_max.Eof())) {
            /* _code := qbe_cpusers_max->MAXUSR */
            _code = CPLib.Round(Cursor_qbe_cpusers_max.GetDouble("MAXUSR"),0);
            Cursor_qbe_cpusers_max.Next();
          }
          m_cConnectivityError = Cursor_qbe_cpusers_max.ErrorMessage();
          Cursor_qbe_cpusers_max.Close();
          // * --- End Select
          /* _code := _code + 1 */
          _code = CPLib.Round(_code+1,0);
          /* cPassword := CPLib.CriptPwd(_code,'mitwebanti') */
          cPassword = CPLib.CriptPwd(_code,"mitwebanti");
          // * --- Insert into cpusers from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpusers");
          m_cPhName = m_Ctx.GetPhName("cpusers");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpusers",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_creaute_age",7,"00000012")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000012(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_code,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_CODAGE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cPassword,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_DESCRIZ,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpusers",true);
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
          // * --- Insert into cpusers_add from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpusers_add");
          m_cPhName = m_Ctx.GetPhName("cpusers_add");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpusers_add",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_creaute_age",7,"00000013")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000013(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_code,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_CODDIP,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpusers_add",true);
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
          // * --- Insert into cpusrgrp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpusrgrp");
          m_cPhName = m_Ctx.GetPhName("cpusrgrp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpusrgrp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_creaute_age",7,"00000014")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000014(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(6,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_code,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpusrgrp",true);
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
      } // End If
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_cpusers_max!=null)
          Cursor_qbe_cpusers_max.Close();
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
      m_Caller.SetString("CODDIP","C",6,0,w_CODDIP);
      m_Caller.SetString("DESCRIZ","C",30,0,w_DESCRIZ);
      m_Caller.SetString("CODAGE","C",15,0,w_CODAGE);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_creaute_ageR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_creaute_ageR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_CODDIP = m_Caller.GetString("CODDIP","C",6,0);
    w_DESCRIZ = m_Caller.GetString("DESCRIZ","C",30,0);
    w_CODAGE = m_Caller.GetString("CODAGE","C",15,0);
    _code = 0;
    cPassword = CPLib.Space(20);
    gAgeCGO=m_Ctx.GetGlobalString("gAgeCGO");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_cpusers_max,
  public static final String m_cVQRList = ",qbe_cpusers_max,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000012(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"code,";
    p_cSql = p_cSql+"name,";
    p_cSql = p_cSql+"passwd,";
    p_cSql = p_cSql+"enabled,";
    p_cSql = p_cSql+"fullname,";
    p_cSql = p_cSql+"forcepwdchange,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpusers",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000013(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODE,";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpusers_add",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000014(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"groupcode,";
    p_cSql = p_cSql+"usercode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpusrgrp",true);
    return p_cSql;
  }
}
