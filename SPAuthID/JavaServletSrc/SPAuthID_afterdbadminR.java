// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class SPAuthID_afterdbadminR implements CallerWithObjs {
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
  public String m_cPhName_cpgrpgrp;
  public String m_cServer_cpgrpgrp;
  public String m_cPhName_cpgroups;
  public String m_cServer_cpgroups;
  public String m_cPhName_spauthid_protocol;
  public String m_cServer_spauthid_protocol;
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
  public SPAuthID_afterdbadminR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("SPAuthID_afterdbadmin",m_Caller);
    m_cPhName_cpgrpgrp = p_ContextObject.GetPhName("cpgrpgrp");
    if (m_cPhName_cpgrpgrp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpgrpgrp = m_cPhName_cpgrpgrp+" "+m_Ctx.GetWritePhName("cpgrpgrp");
    }
    m_cServer_cpgrpgrp = p_ContextObject.GetServer("cpgrpgrp");
    m_cPhName_cpgroups = p_ContextObject.GetPhName("cpgroups");
    if (m_cPhName_cpgroups.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpgroups = m_cPhName_cpgroups+" "+m_Ctx.GetWritePhName("cpgroups");
    }
    m_cServer_cpgroups = p_ContextObject.GetServer("cpgroups");
    m_cPhName_spauthid_protocol = p_ContextObject.GetPhName("spauthid_protocol");
    if (m_cPhName_spauthid_protocol.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_spauthid_protocol = m_cPhName_spauthid_protocol+" "+m_Ctx.GetWritePhName("spauthid_protocol");
    }
    m_cServer_spauthid_protocol = p_ContextObject.GetServer("spauthid_protocol");
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
      return "SPAuthID_afterdbadmin";
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
    CPResultSet Read_Cursor=null;
    try {
      /* spauthid_admin_code Numeric(6, 0) */
      double spauthid_admin_code;
      spauthid_admin_code = 0;
      // * --- Read from cpgroups
      m_cServer = m_Ctx.GetServer("cpgroups");
      m_cPhName = m_Ctx.GetPhName("cpgroups");
      m_cSql = "";
      m_cSql = m_cSql+"name="+CPSql.SQLValueAdapter(CPLib.ToSQL("spauthid_admin","C",50,0,m_cServer),m_cServer,"spauthid_admin");
      m_cSql = m_cSql+" and grptype="+CPSql.SQLValueAdapter(CPLib.ToSQL("R","C",1,0,m_cServer),m_cServer,"R");
      if (m_Ctx.IsSharedTemp("cpgroups")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("code",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        spauthid_admin_code = Read_Cursor.GetDouble("code");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on cpgroups into routine SPAuthID_afterdbadmin returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        spauthid_admin_code = 0;
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If not(Empty(spauthid_admin_code)) */
      if ( ! (CPLib.Empty(spauthid_admin_code))) {
        /* found_admin_code Numeric(6, 0) */
        double found_admin_code;
        found_admin_code = 0;
        // * --- Read from cpgrpgrp
        m_cServer = m_Ctx.GetServer("cpgrpgrp");
        m_cPhName = m_Ctx.GetPhName("cpgrpgrp");
        m_cSql = "";
        m_cSql = m_cSql+"groupcode="+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"N",6,0,m_cServer),m_cServer,1);
        m_cSql = m_cSql+" and groupbase="+CPSql.SQLValueAdapter(CPLib.ToSQL(spauthid_admin_code,"N",6,0,m_cServer),m_cServer,spauthid_admin_code);
        if (m_Ctx.IsSharedTemp("cpgrpgrp")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("groupbase",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          found_admin_code = Read_Cursor.GetDouble("groupbase");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on cpgrpgrp into routine SPAuthID_afterdbadmin returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          found_admin_code = 0;
          Read_Cursor.Close();
          /* Associo il ruolo corrente al ruolo Admins */
          // * --- Insert into cpgrpgrp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpgrpgrp");
          m_cPhName = m_Ctx.GetPhName("cpgrpgrp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpgrpgrp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("SPAuthID_afterdbadmin",6,"00000007")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000007(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(spauthid_admin_code,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpgrpgrp",true);
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
          /* CPContext.RescanSecurity() */
          CPContext.RescanSecurity();
        }
      } // End If
      /* defaultProtocolCode Char(10) := "oidc" */
      String defaultProtocolCode;
      defaultProtocolCode = "oidc";
      /* defaultProtocolDescription Char(25) := "OpenID Connect" */
      String defaultProtocolDescription;
      defaultProtocolDescription = "OpenID Connect";
      /* protocolDescription Char(25) */
      String protocolDescription;
      protocolDescription = CPLib.Space(25);
      /* Verifico che OpenID Connect è censito nella tabella dei protocolli */
      // * --- Read from spauthid_protocol
      m_cServer = m_Ctx.GetServer("spauthid_protocol");
      m_cPhName = m_Ctx.GetPhName("spauthid_protocol");
      m_cSql = "";
      m_cSql = m_cSql+"PRCODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(defaultProtocolCode,"C",10,0,m_cServer),m_cServer,defaultProtocolCode);
      if (m_Ctx.IsSharedTemp("spauthid_protocol")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PRDESCRIPTION",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        protocolDescription = Read_Cursor.GetString("PRDESCRIPTION");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on spauthid_protocol into routine SPAuthID_afterdbadmin returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        protocolDescription = "";
        Read_Cursor.Close();
        // * --- Insert into spauthid_protocol from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("spauthid_protocol");
        m_cPhName = m_Ctx.GetPhName("spauthid_protocol");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"spauthid_protocol",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("SPAuthID_afterdbadmin",6,"0000000F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000000F(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(defaultProtocolCode,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(defaultProtocolDescription,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"spauthid_protocol",true);
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
      }
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
  public static SPAuthID_afterdbadminR Make(CPContext p_Ctx, Caller p_Caller) {
    return new SPAuthID_afterdbadminR(p_Ctx, p_Caller);
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
    p_cSql = p_cSql+"groupcode,";
    p_cSql = p_cSql+"groupbase,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpgrpgrp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000000F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PRCODE,";
    p_cSql = p_cSql+"PRDESCRIPTION,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"spauthid_protocol",true);
    return p_cSql;
  }
}
