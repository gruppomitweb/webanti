// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spadministration_updatepasswordR implements CallerWithObjs {
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
  public String w_confirm_password;
  public String w_new_password;
  public String w_old_password;
  public String cachekey;
  public String root_m_cURL_servlet;
  public String m_cAtExit;
  public String changeReason;
  public String errormessage;
  public double usercode;
  public String pwdcript_current;
  public String pwdcript_new;
  public String m_cChangePasswordLockDestination;
  public double w_pwdcomplexity;
  public boolean canupdate;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spadministration_updatepasswordR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("spadministration_updatepassword",m_Caller);
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
    if (CPLib.eqr("pwdcomplexity",p_cVarName)) {
      return w_pwdcomplexity;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "spadministration_updatepassword";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("confirm_password",p_cVarName)) {
      return w_confirm_password;
    }
    if (CPLib.eqr("new_password",p_cVarName)) {
      return w_new_password;
    }
    if (CPLib.eqr("old_password",p_cVarName)) {
      return w_old_password;
    }
    if (CPLib.eqr("cachekey",p_cVarName)) {
      return cachekey;
    }
    if (CPLib.eqr("root_m_cURL_servlet",p_cVarName)) {
      return root_m_cURL_servlet;
    }
    if (CPLib.eqr("m_cAtExit",p_cVarName)) {
      return m_cAtExit;
    }
    if (CPLib.eqr("changeReason",p_cVarName)) {
      return changeReason;
    }
    if (CPLib.eqr("errormessage",p_cVarName)) {
      return errormessage;
    }
    if (CPLib.eqr("pwdcript_current",p_cVarName)) {
      return pwdcript_current;
    }
    if (CPLib.eqr("pwdcript_new",p_cVarName)) {
      return pwdcript_new;
    }
    if (CPLib.eqr("m_cChangePasswordLockDestination",p_cVarName)) {
      return m_cChangePasswordLockDestination;
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
    if (CPLib.eqr("canupdate",p_cVarName)) {
      return canupdate;
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
    if (CPLib.eqr("pwdcomplexity",p_cVarName)) {
      w_pwdcomplexity = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("confirm_password",p_cVarName)) {
      w_confirm_password = value;
      return;
    }
    if (CPLib.eqr("new_password",p_cVarName)) {
      w_new_password = value;
      return;
    }
    if (CPLib.eqr("old_password",p_cVarName)) {
      w_old_password = value;
      return;
    }
    if (CPLib.eqr("cachekey",p_cVarName)) {
      cachekey = value;
      return;
    }
    if (CPLib.eqr("root_m_cURL_servlet",p_cVarName)) {
      root_m_cURL_servlet = value;
      return;
    }
    if (CPLib.eqr("m_cAtExit",p_cVarName)) {
      m_cAtExit = value;
      return;
    }
    if (CPLib.eqr("changeReason",p_cVarName)) {
      changeReason = value;
      return;
    }
    if (CPLib.eqr("errormessage",p_cVarName)) {
      errormessage = value;
      return;
    }
    if (CPLib.eqr("pwdcript_current",p_cVarName)) {
      pwdcript_current = value;
      return;
    }
    if (CPLib.eqr("pwdcript_new",p_cVarName)) {
      pwdcript_new = value;
      return;
    }
    if (CPLib.eqr("m_cChangePasswordLockDestination",p_cVarName)) {
      m_cChangePasswordLockDestination = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("canupdate",p_cVarName)) {
      canupdate = value;
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
    try {
      /* w_confirm_password Char(20) // MSG_CONFIRM_PASSWORD */
      /* w_new_password Char(20) // MSG_NEW_PASSWORD */
      /* w_old_password Char(20) // MSG_OLD_PASSWORD */
      /* cachekey Char(20) */
      /* root_m_cURL_servlet Char(100) */
      /* m_cAtExit Char(100) */
      /* changeReason Char(10) */
      /* errormessage Memo */
      /* usercode Numeric(9, 0) */
      /* pwdcript_current Char(300) */
      /* pwdcript_new Char(300) */
      /* m_cChangePasswordLockDestination Char(300) */
      /* w_pwdcomplexity Numeric(3, 0) */
      /* If w_new_password<>w_confirm_password */
      if (CPLib.ne(w_new_password,w_confirm_password)) {
        /* errormessage := FormatMsg('MSG_NEW_PASSWORD_DIFFER') */
        errormessage = CPLib.FormatMsg(m_Ctx,"MSG_NEW_PASSWORD_DIFFER");
        /* Exec "Stop spadministration_changepassword" Page 2:Page_2 */
        Page_2();
      } // End If
      /* usercode := m_Ctx.UserCode() */
      usercode = CPLib.Round(m_Ctx.UserCode(),0);
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
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("passwd",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("pwdcomplexity",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        pwdcript_current = Read_Cursor.GetString("passwd");
        w_pwdcomplexity = CPLib.Round(Read_Cursor.GetDouble("pwdcomplexity"),0);
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on cpusers into routine spadministration_updatepassword returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        pwdcript_current = "";
        w_pwdcomplexity = 0;
        Read_Cursor.Close();
        /* Warn Msg "updatepasswd: failed reading cpusers: usercode = "+usercode */
        if ( ! (CPLib.IsNull(m_Warning))) {
          m_Warning.log("updatepasswd: failed reading cpusers: usercode = "+usercode);
        }
        /* errormessage := FormatMsg('MSG_OLD_PASSWORD_ERROR') */
        errormessage = CPLib.FormatMsg(m_Ctx,"MSG_OLD_PASSWORD_ERROR");
        /* Exec "Stop spadministration_changepassword" Page 2:Page_2 */
        Page_2();
      }
      /* If not( CPLib.CheckPwd( usercode, w_old_password, pwdcript_current ) ) */
      if ( ! (CPLib.CheckPwd(usercode,w_old_password,pwdcript_current))) {
        /* errormessage := FormatMsg('MSG_OLD_PASSWORD_ERROR') */
        errormessage = CPLib.FormatMsg(m_Ctx,"MSG_OLD_PASSWORD_ERROR");
        /* Exec "Stop spadministration_changepassword" Page 2:Page_2 */
        Page_2();
      } // End If
      /* pwdcript_new := CPLib.CriptPwd(usercode,w_new_password) */
      pwdcript_new = CPLib.CriptPwd(usercode,w_new_password);
      /* Case CPLib.CheckPwd( usercode, w_new_password , pwdcript_current ) */
      if (CPLib.CheckPwd(usercode,w_new_password,pwdcript_current)) {
        /* errormessage := FormatMsg('MSG_SAME_PASSWORD') */
        errormessage = CPLib.FormatMsg(m_Ctx,"MSG_SAME_PASSWORD");
        /* Case not(spadministration_checkpasswordciclicity(usercode,w_new_password)) */
      } else if ( ! (spadministration_checkpasswordciclicityR.Make(m_Ctx,this).Run(usercode,w_new_password))) {
        /* errormessage := FormatMsg('MSG_PASSWORD_CICLICITY_ERROR') */
        errormessage = CPLib.FormatMsg(m_Ctx,"MSG_PASSWORD_CICLICITY_ERROR");
        /* Case not(UserAdmin.CheckPasswordStrength(w_new_password,Max(w_pwdcomplexity,spadministration_getpwdcomplexity_group(usercode)))) */
      } else if ( ! (UserAdmin.Make(m_Ctx).CheckPasswordStrength(w_new_password,CPLib.Max(w_pwdcomplexity,spadministration_getpwdcomplexity_groupR.Make(m_Ctx,this).Run(usercode))))) {
        /* errormessage := FormatMsg('MSG_WEAKY_PASSWORD') */
        errormessage = CPLib.FormatMsg(m_Ctx,"MSG_WEAKY_PASSWORD");
      } // End Case
      /* If Empty(errormessage) */
      if (CPLib.Empty(errormessage)) {
        /* errormessage := FormatMsg('MSG_PASSWORD_CHANGED') */
        errormessage = CPLib.FormatMsg(m_Ctx,"MSG_PASSWORD_CHANGED");
        /* canupdate Bool // Permit external control on password changeability */
        /* canupdate := True // Permit external control on password changeability */
        canupdate = true;
        /* Fire Event 'Before Update Password' */
        try {
          m_bEventRunning = true;
          com.zucchetti.sitepainter.EventHandler.notifyEvent("Before Update Password",this,m_Ctx,specificEventsHandlers,allEventsHandlers);
        } finally {
          m_bEventRunning = false;
        }
        /* Routine ascoltatori dell'evento "Before update password"
           possono utilizzare la variabile caller "canupdate" per bloccare
           il cambio password.
           Per impostare un messaggio d'errore possono utilizzare
           la variabile caller "errormessage" */
        /* If canupdate */
        if (canupdate) {
          double nTry00000025status;
          nTry00000025status = m_Sql.GetTransactionStatus();
          String cTry00000025msg;
          cTry00000025msg = m_Sql.TransactionErrorMessage();
          try {
            // Begin Transaction
            m_Sql.RequireTransaction();
            // * --- Write into cpusers from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpusers");
            m_cPhName = m_Ctx.GetPhName("cpusers");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpusers",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("spadministration_updatepassword",93,"00000027")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"passwd = "+CPLib.ToSQL(pwdcript_new,"C",20,0,m_cServer)+", ";
            m_cSql = m_cSql+"pwdcreate = "+CPLib.ToSQL(CPLib.DateTime(),"T",14,0)+", ";
            m_cSql = m_cSql+"forcepwdchange = "+CPLib.ToSQL(false,"L",1,0)+", ";
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
              /* Warn Msg "updatepasswd: failed writing cpusers: usercode = "+usercode */
              if ( ! (CPLib.IsNull(m_Warning))) {
                m_Warning.log("updatepasswd: failed writing cpusers: usercode = "+usercode);
              }
              // Rollback
              m_Sql.AbortTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              m_bError = true;
              m_Sql.CompleteTransaction();
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
              throw new RoutineException();
            }
            // * --- Insert into cphistorypwd from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cphistorypwd");
            m_cPhName = m_Ctx.GetPhName("cphistorypwd");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cphistorypwd",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("spadministration_updatepassword",93,"0000002A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000002A(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(usercode,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(pwdcript_new,"?",0,0,m_cServer)+", ";
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
              /* Warn Msg "updatepasswd: failed insert cphystorypwd: usercode = "+usercode+" pwd "+pwdcript_current */
              if ( ! (CPLib.IsNull(m_Warning))) {
                m_Warning.log("updatepasswd: failed insert cphystorypwd: usercode = "+usercode+" pwd "+pwdcript_current);
              }
              // Rollback
              m_Sql.AbortTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              m_bError = true;
              m_Sql.CompleteTransaction();
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
              throw new RoutineException();
            }
            /* Fire Event 'Password Changed' */
            try {
              m_bEventRunning = true;
              com.zucchetti.sitepainter.EventHandler.notifyEvent("Password Changed",this,m_Ctx,specificEventsHandlers,allEventsHandlers);
            } finally {
              m_bEventRunning = false;
            }
            // Commit
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            m_Sql.CompleteTransaction();
            /* errormessage := FormatMsg('MSG_PASSWORD_CHANGED') */
            errormessage = CPLib.FormatMsg(m_Ctx,"MSG_PASSWORD_CHANGED");
            /* m_cChangePasswordLockDestination := m_Ctx.GetAuthority().m_cChangePasswordLockDestination */
            m_cChangePasswordLockDestination = m_Ctx.GetAuthority().m_cChangePasswordLockDestination;
            /* servletStatus Object(SPServlet.SPServletStatus) */
            SPServlet.SPServletStatus servletStatus;
            servletStatus = null;
            /* servletStatus := CastToServletStatus(m_Caller) */
            servletStatus = CastToServletStatus(m_Caller);
            /* If not( IsNull(servletStatus) ) */
            if ( ! (CPLib.IsNull(servletStatus))) {
              /* SPLib.SetCookie(servletStatus.request, servletStatus.response, m_Ctx) */
              SPLib.SetCookie(servletStatus.request,servletStatus.response,m_Ctx);
            } // End If
            /* If Empty(m_cChangePasswordLockDestination) */
            if (CPLib.Empty(m_cChangePasswordLockDestination)) {
              /* Exec "Stop spadministration_changepassword" Page 2:Page_2 */
              Page_2();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
            } // End If
            /* m_Ctx.GetAuthority().m_cChangePasswordLockDestination := "" */
            m_Ctx.GetAuthority().m_cChangePasswordLockDestination = "";
            /* If Empty(root_m_cURL_servlet) */
            if (CPLib.Empty(root_m_cURL_servlet)) {
              /* Stop cp_login */
              Forward f;
              f=new Forward("cp_login",false,this,Forward.Start,false);
              f.SetParameter("m_cAction","welcome");
              f.SetParameter("m_cParameterCache",cachekey);
              f.SetParameter("m_cParameterSequence","m_cAction"+","+"m_cParameterCache");
              f.SetParameter("m_cMode","hyperlink");
              throw f;
            } // End If
            /* Stop root_m_cURL_servlet */
            Forward f;
            f=new Forward(root_m_cURL_servlet,false,this,Forward.NoStatus,true);
            f.SetParameter("m_cParametersCache",cachekey);
            f.SetParameter("m_cParameterSequence","m_cParametersCache");
            f.SetParameter("m_cMode","hyperlink");
            throw f;
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            /* errormessage := FormatMsg('MSG_ERROR_UPDATING_PASSWORD') */
            errormessage = CPLib.FormatMsg(m_Ctx,"MSG_ERROR_UPDATING_PASSWORD");
            /* Exec "Stop spadministration_changepassword" Page 2:Page_2 */
            Page_2();
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000025status,0)) {
              m_Sql.SetTransactionStatus(nTry00000025status,cTry00000025msg);
            }
          }
        } else { // Else
          /* Exec "Stop spadministration_changepassword" Page 2:Page_2 */
          Page_2();
        } // End If
      } else { // Else
        /* Exec "Stop spadministration_changepassword" Page 2:Page_2 */
        Page_2();
      } // End If
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
  void Page_2() throws Exception {
    /* w_old_password := "" // MSG_OLD_PASSWORD */
    w_old_password = "";
    /* w_new_password := "" // MSG_NEW_PASSWORD */
    w_new_password = "";
    /* w_confirm_password := "" // MSG_CONFIRM_PASSWORD */
    w_confirm_password = "";
    /* Stop spadministration_changepassword */
    Forward f;
    f=new Forward("spadministration_changepassword",false,this,Forward.Start,false);
    f.SetParameter("errormessage",errormessage);
    f.SetParameter("cachekey",cachekey);
    f.SetParameter("root_m_cURL_servlet",root_m_cURL_servlet);
    f.SetParameter("m_cAtExit",m_cAtExit);
    f.SetParameter("m_cParameterSequence","errormessage"+","+"cachekey"+","+"root_m_cURL_servlet"+","+"m_cAtExit");
    f.SetParameter("m_cMode","hyperlink");
    throw f;
  }
  void _init_() {
  }
  public String RunAsync() {
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
      m_Caller.SetString("confirm_password","C",20,0,w_confirm_password);
      m_Caller.SetString("new_password","C",20,0,w_new_password);
      m_Caller.SetString("old_password","C",20,0,w_old_password);
      m_Caller.SetString("cachekey","C",20,0,cachekey);
      m_Caller.SetString("root_m_cURL_servlet","C",100,0,root_m_cURL_servlet);
      m_Caller.SetString("m_cAtExit","C",100,0,m_cAtExit);
      m_Caller.SetString("changeReason","C",10,0,changeReason);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static spadministration_updatepasswordR Make(CPContext p_Ctx, Caller p_Caller) {
    return new spadministration_updatepasswordR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_confirm_password = m_Caller.GetString("confirm_password","C",20,0);
    w_new_password = m_Caller.GetString("new_password","C",20,0);
    w_old_password = m_Caller.GetString("old_password","C",20,0);
    cachekey = m_Caller.GetString("cachekey","C",20,0);
    root_m_cURL_servlet = m_Caller.GetString("root_m_cURL_servlet","C",100,0);
    m_cAtExit = m_Caller.GetString("m_cAtExit","C",100,0);
    changeReason = m_Caller.GetString("changeReason","C",10,0);
    errormessage = "";
    usercode = 0;
    pwdcript_current = CPLib.Space(300);
    pwdcript_new = CPLib.Space(300);
    m_cChangePasswordLockDestination = CPLib.Space(300);
    w_pwdcomplexity = 0;
    canupdate = false;
  }
  // * --- Area Manuale = BO - Methods
  // * --- spadministration_updatepassword
  /*
  public boolean CheckPassword(String password) {
    boolean result = false;
    CPResultSet Cursor_cpusers;
    String currentPassword = "";
    String m_cServer = m_Ctx.GetServer("cpusers", true);
    CPPooler pooler=CPPooler.GetPooler(m_Ctx.GetInstance());
    m_Sql = m_Ctx.GetSql();
    Cursor_cpusers = m_Sql.Query(m_cServer,"select passwd from "+pooler.PhNameAdapter("cpusers")+" where code="+CPLib.ToSQL(m_Ctx.UserCode(),"N",9,0));
    if ( ! (Cursor_cpusers.Eof())) {
      currentPassword = Cursor_cpusers.GetString("passwd");
    } else {
      // Error: no record found!
      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
    }
    Cursor_cpusers.Close();
    result = CPLib.CheckPwd(m_Ctx.UserCode(),password,currentPassword);
    return result;
  }
  
  public boolean ChangePassword(String newpassword) {
    boolean result = true;
    String m_cServer = m_Ctx.GetServer("cpusers", true);
    String m_cSql = "";
    int m_nUpdatedRows;
    m_Sql = m_Ctx.GetSql();
    CPPooler pooler=CPPooler.GetPooler(m_Ctx.GetInstance());
    
    m_Sql.RequireTransaction();
    m_cSql = "Update "+pooler.PhNameAdapter("cpusers")+" set ";
    m_cSql = m_cSql+"passwd = "+CPLib.ToSQL(CPLib.CriptPwd(m_Ctx.UserCode(),newpassword),"C",20,0)+" where ";
    m_cSql = m_cSql+"code = "+CPLib.ToSQL(m_Ctx.UserCode(),"N",9,0)+" ";
    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
    m_Sql.CompleteTransaction();
    m_cLastMsgError = m_Sql.TransactionErrorMessage();
    if (CPLib.ne(m_cLastMsgError,"")) {
      result = false;
    }
    
    if (result) {
      m_cServer = m_Ctx.GetServer("cpssomap", true);
      m_cSql = "Delete from "+pooler.PhNameAdapter("cpssomap")+" where ";
      m_cSql = m_cSql+"userid="+CPLib.ToSQL(m_Ctx.UserCode(),"N",9,0);
      m_Sql.RequireTransaction();
      m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      m_Sql.CompleteTransaction();
    }
    return result;
  }
  */
  private static SPServlet.SPServletStatus CastToServletStatus(CallerWithObjs s) {
    if (s instanceof SPServlet.SPServletStatus) {
      return (SPServlet.SPServletStatus)s;
    }
    return null;
  }
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,spadministration_checkpasswordciclicity,spadministration_getpwdcomplexity_group,
  public static final String i_InvokedRoutines = ",spadministration_checkpasswordciclicity,spadministration_getpwdcomplexity_group,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000002A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"code,";
    p_cSql = p_cSql+"pwpassword,";
    p_cSql = p_cSql+"pwdatcreate,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cphistorypwd",true);
    return p_cSql;
  }
}
