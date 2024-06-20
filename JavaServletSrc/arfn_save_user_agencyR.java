// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_save_user_agencyR implements CallerWithObjs {
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
  public String m_cPhName_cpusrgrp;
  public String m_cServer_cpusrgrp;
  public String m_cPhName_cpusers_add;
  public String m_cServer_cpusers_add;
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
  public double pCode;
  public String pName;
  public String pUser;
  public String pDisable;
  public String pResetPWD;
  public String pResetOTP;
  public String pNewPwd;
  public String gCodDip;
  public String cPwd;
  public double _codute;
  public String cRitorno;
  public String _coddip;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_save_user_agencyR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_save_user_agency",m_Caller);
    m_cPhName_cpusers = p_ContextObject.GetPhName("cpusers");
    if (m_cPhName_cpusers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers = m_cPhName_cpusers+" "+m_Ctx.GetWritePhName("cpusers");
    }
    m_cServer_cpusers = p_ContextObject.GetServer("cpusers");
    m_cPhName_cpusrgrp = p_ContextObject.GetPhName("cpusrgrp");
    if (m_cPhName_cpusrgrp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusrgrp = m_cPhName_cpusrgrp+" "+m_Ctx.GetWritePhName("cpusrgrp");
    }
    m_cServer_cpusrgrp = p_ContextObject.GetServer("cpusrgrp");
    m_cPhName_cpusers_add = p_ContextObject.GetPhName("cpusers_add");
    if (m_cPhName_cpusers_add.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers_add = m_cPhName_cpusers_add+" "+m_Ctx.GetWritePhName("cpusers_add");
    }
    m_cServer_cpusers_add = p_ContextObject.GetServer("cpusers_add");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pCode",p_cVarName)) {
      return pCode;
    }
    if (CPLib.eqr("_codute",p_cVarName)) {
      return _codute;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_save_user_agency";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pName",p_cVarName)) {
      return pName;
    }
    if (CPLib.eqr("pUser",p_cVarName)) {
      return pUser;
    }
    if (CPLib.eqr("pDisable",p_cVarName)) {
      return pDisable;
    }
    if (CPLib.eqr("pResetPWD",p_cVarName)) {
      return pResetPWD;
    }
    if (CPLib.eqr("pResetOTP",p_cVarName)) {
      return pResetOTP;
    }
    if (CPLib.eqr("pNewPwd",p_cVarName)) {
      return pNewPwd;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      return gCodDip;
    }
    if (CPLib.eqr("cPwd",p_cVarName)) {
      return cPwd;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      return _coddip;
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
    if (CPLib.eqr("pCode",p_cVarName)) {
      pCode = value;
      return;
    }
    if (CPLib.eqr("_codute",p_cVarName)) {
      _codute = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pName",p_cVarName)) {
      pName = value;
      return;
    }
    if (CPLib.eqr("pUser",p_cVarName)) {
      pUser = value;
      return;
    }
    if (CPLib.eqr("pDisable",p_cVarName)) {
      pDisable = value;
      return;
    }
    if (CPLib.eqr("pResetPWD",p_cVarName)) {
      pResetPWD = value;
      return;
    }
    if (CPLib.eqr("pResetOTP",p_cVarName)) {
      pResetOTP = value;
      return;
    }
    if (CPLib.eqr("pNewPwd",p_cVarName)) {
      pNewPwd = value;
      return;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      gCodDip = value;
      return;
    }
    if (CPLib.eqr("cPwd",p_cVarName)) {
      cPwd = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      _coddip = value;
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
    CPResultSet Cursor_qbe_tab_mmc=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pCode Numeric(10, 0) // Codice Utente */
      /* pName Char(60) // Nominativo */
      /* pUser Char(40) // Utente */
      /* pDisable Char(1) // Abilita/Disabilita */
      /* pResetPWD Char(1) // Per resettare la password */
      /* pResetOTP Char(1) // Per resettare l'OTP */
      /* pNewPwd Char(20) // Nuova password */
      /* gCodDip Char(6) // Dipendenza */
      /* cPwd Char(20) */
      /* _codute Numeric(10, 0) := 0 */
      _codute = CPLib.Round(0,0);
      /* cRitorno Char(3) := 'KO' */
      cRitorno = "KO";
      /* _coddip Char(6) */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000012status;
      nTry00000012status = m_Sql.GetTransactionStatus();
      String cTry00000012msg;
      cTry00000012msg = m_Sql.TransactionErrorMessage();
      try {
        /* If pCode=0 */
        if (CPLib.eqr(pCode,0)) {
          /* _codute := 0 */
          _codute = CPLib.Round(0,0);
          // * --- Read from cpusers
          m_cServer = m_Ctx.GetServer("cpusers");
          m_cPhName = m_Ctx.GetPhName("cpusers");
          m_cSql = "";
          m_cSql = m_cSql+"name="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(pUser),"C",50,0,m_cServer),m_cServer,CPLib.LRTrim(pUser));
          if (m_Ctx.IsSharedTemp("cpusers")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("code",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _codute = CPLib.Round(Read_Cursor.GetDouble("code"),0);
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on cpusers into routine arfn_save_user_agency returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _codute = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If _codute=0 */
          if (CPLib.eqr(_codute,0)) {
            // * --- Read from cpusers
            m_cServer = m_Ctx.GetServer("cpusers");
            m_cPhName = m_Ctx.GetPhName("cpusers");
            m_cSql = "";
            m_cSql = m_cSql+"name="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(CPLib.Upper(pUser)),"C",50,0,m_cServer),m_cServer,CPLib.LRTrim(CPLib.Upper(pUser)));
            if (m_Ctx.IsSharedTemp("cpusers")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("code",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _codute = CPLib.Round(Read_Cursor.GetDouble("code"),0);
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on cpusers into routine arfn_save_user_agency returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _codute = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* If _codute <> 0 */
          if (CPLib.ne(_codute,0)) {
            /* cRitorno := 'USR' */
            cRitorno = "USR";
          } else { // Else
            /* If Empty(pUser) */
            if (CPLib.Empty(pUser)) {
              /* cRitorno := 'EMP' */
              cRitorno = "EMP";
            } else { // Else
              // * --- Select from qbe_tab_mmc
              SPBridge.HMCaller _h0000001C;
              _h0000001C = new SPBridge.HMCaller();
              _h0000001C.Set("m_cVQRList",m_cVQRList);
              _h0000001C.Set("tbname","cpusers");
              _h0000001C.Set("fldname","code");
              if (Cursor_qbe_tab_mmc!=null)
                Cursor_qbe_tab_mmc.Close();
              Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000001C,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_tab_mmc.Eof())) {
                /* _codute := qbe_tab_mmc->max */
                _codute = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("max"),0);
                Cursor_qbe_tab_mmc.Next();
              }
              m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
              Cursor_qbe_tab_mmc.Close();
              // * --- End Select
              /* _codute := _codute + 1 */
              _codute = CPLib.Round(_codute+1,0);
              /* cPwd := CPLib.CriptPwd(_codute,LRTrim(pNewPwd)) // password criptata */
              cPwd = CPLib.CriptPwd(_codute,CPLib.LRTrim(pNewPwd));
              // * --- Insert into cpusers from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpusers");
              m_cPhName = m_Ctx.GetPhName("cpusers");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpusers",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_save_user_agency",25,"00000020")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000020(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codute,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(pUser),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cPwd,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(pName),"?",0,0,m_cServer)+", ";
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
                throw new RoutineException();
              }
              // * --- Insert into cpusers_add from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpusers_add");
              m_cPhName = m_Ctx.GetPhName("cpusers_add");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpusers_add",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_save_user_agency",25,"00000021")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000021(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codute,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(gCodDip,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
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
                throw new RoutineException();
              }
              // * --- Insert into cpusrgrp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpusrgrp");
              m_cPhName = m_Ctx.GetPhName("cpusrgrp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpusrgrp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_save_user_agency",25,"00000022")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000022(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(12,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_codute,"?",0,0)+", ";
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
                throw new RoutineException();
              }
              /* cRitorno := 'OK' */
              cRitorno = "OK";
            } // End If
          } // End If
        } else { // Else
          /* _coddip := '' */
          _coddip = "";
          // * --- Read from cpusers_add
          m_cServer = m_Ctx.GetServer("cpusers_add");
          m_cPhName = m_Ctx.GetPhName("cpusers_add");
          m_cSql = "";
          m_cSql = m_cSql+"CODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pCode,"N",10,0,m_cServer),m_cServer,pCode);
          if (m_Ctx.IsSharedTemp("cpusers_add")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODDIP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _coddip = Read_Cursor.GetString("CODDIP");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on cpusers_add into routine arfn_save_user_agency returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _coddip = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If _coddip = gCodDip */
          if (CPLib.eqr(_coddip,gCodDip)) {
            /* If pResetOTP='S' */
            if (CPLib.eqr(pResetOTP,"S")) {
              // * --- Write into cpusers from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpusers");
              m_cPhName = m_Ctx.GetPhName("cpusers");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpusers",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_save_user_agency",25,"00000028")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"cpotp = "+CPLib.ToSQL("","C",100,0,m_cServer)+", ";
              m_cSql = m_cSql+"name = "+CPLib.ToSQL(CPLib.LRTrim(pUser),"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"fullname = "+CPLib.ToSQL(CPLib.LRTrim(pName),"C",60,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpusers",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"code = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pCode,"?",0,0,m_cServer),m_cServer,pCode)+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
              /* cRitorno := 'OTP' */
              cRitorno = "OTP";
            } else { // Else
              /* If pResetPWD='S' */
              if (CPLib.eqr(pResetPWD,"S")) {
                /* cPwd := CPLib.CriptPwd(pCode,LRTrim(pNewPwd)) // password criptata */
                cPwd = CPLib.CriptPwd(pCode,CPLib.LRTrim(pNewPwd));
                // * --- Write into cpusers from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cpusers");
                m_cPhName = m_Ctx.GetPhName("cpusers");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpusers",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_save_user_agency",25,"0000002C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"passwd = "+CPLib.ToSQL(cPwd,"C",20,0,m_cServer)+", ";
                m_cSql = m_cSql+"forcepwdchange = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"name = "+CPLib.ToSQL(CPLib.LRTrim(pUser),"C",50,0,m_cServer)+", ";
                m_cSql = m_cSql+"fullname = "+CPLib.ToSQL(CPLib.LRTrim(pName),"C",60,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpusers",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"code = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pCode,"?",0,0,m_cServer),m_cServer,pCode)+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                  throw new RoutineException();
                }
                /* cRitorno := 'PWD' */
                cRitorno = "PWD";
              } else { // Else
                /* If pDisable='D' or pDisable='E' */
                if (CPLib.eqr(pDisable,"D") || CPLib.eqr(pDisable,"E")) {
                  // * --- Write into cpusers from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("cpusers");
                  m_cPhName = m_Ctx.GetPhName("cpusers");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpusers",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arfn_save_user_agency",25,"0000002F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"enabled = "+CPLib.ToSQL(pDisable,"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"name = "+CPLib.ToSQL(CPLib.LRTrim(pUser),"C",50,0,m_cServer)+", ";
                  m_cSql = m_cSql+"fullname = "+CPLib.ToSQL(CPLib.LRTrim(pName),"C",60,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpusers",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"code = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pCode,"?",0,0,m_cServer),m_cServer,pCode)+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                  /* cRitorno := 'DIS' */
                  cRitorno = "DIS";
                } // End If
              } // End If
            } // End If
          } else { // Else
            /* cRitorno := 'AGE' */
            cRitorno = "AGE";
          } // End If
        } // End If
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* cRitorno := 'KO' */
        cRitorno = "KO";
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000012status,0)) {
          m_Sql.SetTransactionStatus(nTry00000012status,cTry00000012msg);
        }
      }
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(double p_pCode,String p_pName,String p_pUser,String p_pDisable,String p_pResetPWD,String p_pResetOTP,String p_pNewPwd) {
    pCode = p_pCode;
    pName = p_pName;
    pUser = p_pUser;
    pDisable = p_pDisable;
    pResetPWD = p_pResetPWD;
    pResetOTP = p_pResetOTP;
    pNewPwd = p_pNewPwd;
    return CPAsyncRoutine.CreateAsyncAndStart(
    new CPAsyncRoutine.AsyncRunnable() {
      public void Compute(CPAsyncRoutine.AsyncResult p_oResult) {
        try {
          p_oResult.m_oResult=new Stop(Run());
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
  public String Run(double p_pCode,String p_pName,String p_pUser,String p_pDisable,String p_pResetPWD,String p_pResetOTP,String p_pNewPwd) {
    pCode = p_pCode;
    pName = p_pName;
    pUser = p_pUser;
    pDisable = p_pDisable;
    pResetPWD = p_pResetPWD;
    pResetOTP = p_pResetOTP;
    pNewPwd = p_pNewPwd;
    return Run();
  }
  public String Run() {
    String l_result;
    l_result = "";
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
      } catch(Stop stop_value) {
        l_result = stop_value.GetString();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = "";
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
    return l_result;
  }
  public static arfn_save_user_agencyR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_save_user_agencyR(p_Ctx, p_Caller);
  }
  public static arfn_save_user_agencyR Make(CPContext p_Ctx) {
    return new arfn_save_user_agencyR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pCode = 0;
    pName = CPLib.Space(60);
    pUser = CPLib.Space(40);
    pDisable = CPLib.Space(1);
    pResetPWD = CPLib.Space(1);
    pResetOTP = CPLib.Space(1);
    pNewPwd = CPLib.Space(20);
    cPwd = CPLib.Space(20);
    _codute = CPLib.Round(0,0);
    cRitorno = "KO";
    _coddip = CPLib.Space(6);
    gCodDip=m_Ctx.GetGlobalString("gCodDip");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tab_mmc,
  public static final String m_cVQRList = ",qbe_tab_mmc,";
  // ENTITY_BATCHES: ,arfn_save_user_agency,
  public static final String i_InvokedRoutines = ",arfn_save_user_agency,";
  public static String[] m_cRunParameterNames={"pCode","pName","pUser","pDisable","pResetPWD","pResetOTP","pNewPwd"};
  protected static String GetFieldsName_00000020(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"code,";
    p_cSql = p_cSql+"name,";
    p_cSql = p_cSql+"passwd,";
    p_cSql = p_cSql+"forcepwdchange,";
    p_cSql = p_cSql+"enabled,";
    p_cSql = p_cSql+"fullname,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpusers",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000021(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODE,";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"SUPERDIP,";
    p_cSql = p_cSql+"DATECREATE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpusers_add",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000022(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"groupcode,";
    p_cSql = p_cSql+"usercode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpusrgrp",true);
    return p_cSql;
  }
}
