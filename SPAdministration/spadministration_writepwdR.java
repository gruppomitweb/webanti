// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spadministration_writepwdR implements CallerWithObjs {
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
  // I messaggi vengono instradati su questo oggetto
  public CPMessageSink m_MessageSink;
  public com.zucchetti.sitepainter.Logger m_Debug;
  public com.zucchetti.sitepainter.Logger m_Info;
  public com.zucchetti.sitepainter.Logger m_Warning;
  public String m_cPhName_cpusers;
  public String m_cServer_cpusers;
  public String m_cPhName_cphistorypwd;
  public String m_cServer_cphistorypwd;
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
  public String password;
  public double usercode;
  public String pwd_prev;
  public boolean writehistory;
  public String password_cript;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spadministration_writepwdR (CPContext p_ContextObject, Caller caller) {
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
    // I messaggi vengono instradati su questo oggetto
    m_MessageSink = CPMessageSink.ConsoleSink;
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("spadministration_writepwd",m_Caller);
    m_cPhName_cpusers = p_ContextObject.GetPhName("cpusers");
    if (m_cPhName_cpusers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers = m_cPhName_cpusers+" "+m_Ctx.GetWritePhName("cpusers");
    }
    m_cServer_cpusers = p_ContextObject.GetServer("cpusers");
    m_cPhName_cphistorypwd = p_ContextObject.GetPhName("cphistorypwd");
    if (m_cPhName_cphistorypwd.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cphistorypwd = m_cPhName_cphistorypwd+" "+m_Ctx.GetWritePhName("cphistorypwd");
    }
    m_cServer_cphistorypwd = p_ContextObject.GetServer("cphistorypwd");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("usercode",p_cVarName)) {
      return usercode;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "spadministration_writepwd";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("password",p_cVarName)) {
      return password;
    }
    if (CPLib.eqr("pwd_prev",p_cVarName)) {
      return pwd_prev;
    }
    if (CPLib.eqr("password_cript",p_cVarName)) {
      return password_cript;
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
    if (CPLib.eqr("writehistory",p_cVarName)) {
      return writehistory;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("usercode",p_cVarName)) {
      usercode = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("password",p_cVarName)) {
      password = value;
      return;
    }
    if (CPLib.eqr("pwd_prev",p_cVarName)) {
      pwd_prev = value;
      return;
    }
    if (CPLib.eqr("password_cript",p_cVarName)) {
      password_cript = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("writehistory",p_cVarName)) {
      writehistory = value;
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
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_cpusers=null;
    try {
      /* password Char(10) */
      /* usercode Numeric(9, 0) */
      /* pwd_prev Char(300) */
      /* writehistory Bool */
      /* password_cript Char(20) */
      /* If UserAdmin.HasAdminRights() */
      if (UserAdmin.Make(m_Ctx).HasAdminRights()) {
        /* If password<>'cambia la password' */
        if (CPLib.ne(password,"cambia la password")) {
          /* writehistory := True */
          writehistory = true;
          // * --- Read from cpusers
          m_cServer = m_Ctx.GetServer("cpusers");
          m_cPhName = m_Ctx.GetPhName("cpusers");
          m_cSql = "";
          m_cSql = m_cSql+"code="+CPSql.SQLValueAdapter(CPLib.ToSQL(usercode,"N",9,0,m_cServer),m_cServer,usercode);
          if (m_Ctx.IsSharedTemp("cpusers")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("passwd",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            pwd_prev = Read_Cursor.GetString("passwd");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on cpusers into routine spadministration_writepwd returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            pwd_prev = "";
            Read_Cursor.Close();
            /* writehistory := False */
            writehistory = false;
          }
          /* password_cript := CPLib.CriptPwd(usercode,password) */
          password_cript = CPLib.CriptPwd(usercode,password);
          /* If not( CPLib.CheckPwd(usercode,password,pwd_prev) ) */
          if ( ! (CPLib.CheckPwd(usercode,password,pwd_prev))) {
            /* If spadministration_checkpasswordciclicity(usercode,password) */
            if (spadministration_checkpasswordciclicityR.Make(m_Ctx,this).Run(usercode,password)) {
              // * --- Write into cpusers from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpusers");
              m_cPhName = m_Ctx.GetPhName("cpusers");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpusers",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("spadministration_writepwd",52,"0000000E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"passwd = "+CPLib.ToSQL(password_cript,"C",20,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpusers",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"code = "+CPSql.SQLValueAdapter(CPLib.ToSQL(usercode,"?",0,0,m_cServer),m_cServer,usercode)+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_nUpdatedRows = 0;
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.lt(m_nUpdatedRows,1)) {
                // No rows updated
                // Transaction Error
                m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"MSG_ERROR_UPDATING_PASSWORD"));
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              /* If writehistory */
              if (writehistory) {
                // * --- Insert into cphistorypwd from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cphistorypwd");
                m_cPhName = m_Ctx.GetPhName("cphistorypwd");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cphistorypwd",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("spadministration_writepwd",52,"00000011")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000011(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(usercode,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(password_cript,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cphistorypwd",true);
                m_cSql = m_cSql+")";
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_nUpdatedRows = 0;
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.lt(m_nUpdatedRows,1)) {
                  // No rows inserted
                  // Transaction Error
                  m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"MSG_ERROR_UPDATING_PASSWORD"));
                } else if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
              } // End If
              /* Fire Event 'Password Changed' */
              try {
                m_bEventRunning = true;
                com.zucchetti.sitepainter.EventHandler.notifyEvent("Password Changed",this,m_Ctx,specificEventsHandlers,allEventsHandlers);
              } finally {
                m_bEventRunning = false;
              }
            } else { // Else
              // Transaction Error
              m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"MSG_PASSWORD_CICLICITY_ERROR"));
            } // End If
          } // End If
        } else { // Else
          // * --- Select from cpusers
          m_cServer = m_Ctx.GetServer("cpusers");
          m_cPhName = m_Ctx.GetPhName("cpusers");
          if (Cursor_cpusers!=null)
            Cursor_cpusers.Close();
          Cursor_cpusers = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select code  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"code="+CPSql.SQLValueAdapter(CPLib.ToSQL(usercode,"?",0,0,m_cServer, m_oParameters),m_cServer,usercode)+"  and  passwd is null "+")"+(m_Ctx.IsSharedTemp("cpusers")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cpusers.Eof())) {
            // * --- Write into cpusers from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpusers");
            m_cPhName = m_Ctx.GetPhName("cpusers");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpusers",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("spadministration_writepwd",52,"00000016")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"passwd = "+CPLib.ToSQL(CPLib.CriptPwd(usercode,""),"C",20,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpusers",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"code = "+CPSql.SQLValueAdapter(CPLib.ToSQL(usercode,"?",0,0,m_cServer),m_cServer,usercode)+"";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows updated
              // Transaction Error
              m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"MSG_ERROR_UPDATING_PASSWORD"));
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            Cursor_cpusers.Next();
          }
          m_cConnectivityError = Cursor_cpusers.ErrorMessage();
          Cursor_cpusers.Close();
          // * --- End Select
        } // End If
      } else { // Else
        /* If 'cambia la password' <>password */
        if (CPLib.ne("cambia la password",password)) {
          /* Debug Msg 'Password in cpuser non aggiornata da utente non appartenente al gruppo  1 degli amministratori' */
          if ( ! (CPLib.IsNull(m_Debug))) {
            m_Debug.log(CPLib.FormatMsg(m_Ctx,"Password in cpuser non aggiornata da utente non appartenente al gruppo  1 degli amministratori"));
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
        if (Cursor_cpusers!=null)
          Cursor_cpusers.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_password,double p_usercode) {
    password = p_password;
    usercode = p_usercode;
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
    );
  }
  public Forward Run(String p_password,double p_usercode) {
    password = p_password;
    usercode = p_usercode;
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
  public static spadministration_writepwdR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spadministration_writepwdR(p_Ctx, p_Caller);
  }
  public void Blank() {
    password = CPLib.Space(10);
    usercode = 0;
    pwd_prev = CPLib.Space(300);
    writehistory = false;
    password_cript = CPLib.Space(20);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,spadministration_checkpasswordciclicity,spadministration_writepwd,
  public static final String i_InvokedRoutines = ",spadministration_checkpasswordciclicity,spadministration_writepwd,";
  public static String[] m_cRunParameterNames={"password","usercode"};
  protected static String GetFieldsName_00000011(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"code,";
    p_cSql = p_cSql+"pwpassword,";
    p_cSql = p_cSql+"pwdatcreate,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cphistorypwd",true);
    return p_cSql;
  }
}
