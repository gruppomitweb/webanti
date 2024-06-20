// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class spadministration_usersBO extends spadministration_usersBL {
  class SqlLoader {
    public boolean m_bLink_1_40 = false;
    double m_nColumns = 0;
    CPSql m_Sql;
    String m_cServer;
    String m_cMainTable;
    String m_cSelect;
    String m_cFrom;
    String m_cAlias;
    String m_cWhere;
    String m_cOrderBy;
    public SqlLoader(CPSql sql,String server,String from,String alias,String where,String orderby) {
      m_cAlias = alias;
      m_Sql = sql;
      m_cServer = server;
      m_cMainTable = alias;
      m_cSelect = m_cAlias+".*";
      m_cFrom = from+" "+m_cAlias;
      m_cWhere = where;
      m_cOrderBy = orderby;
    }
    public void AddJoinedLink_1_40(String rightTable,String rightServer) {
      // questo link aggiunge 2 campi al cursore risultato
      String m_cLinkedFrom;
      String m_cLinkedWhere;
      String m_cJoinCond = "";
      if (m_Sql.CanOptimizeLink(m_nColumns+2,m_cServer,rightServer)) {
        m_cSelect = m_cSelect+" ,link_1_40.code AS code140";
        m_cSelect = m_cSelect+" ,link_1_40.name AS name140";
        m_cLinkedFrom = m_Sql.GenerateLinkFrom(m_cServer,m_cMainTable,rightTable,"link_1_40","language","code");
        if (CPLib.ne(m_cLinkedFrom,"")) {
          m_cFrom = m_cFrom+m_cLinkedFrom;
          m_cLinkedWhere = m_Sql.GenerateJoinCondition(m_cServer,m_cMainTable,rightTable,"link_1_40","language","code",true);
          if (CPLib.eq(m_cLinkedWhere,"")) {
            m_cFrom = m_cFrom+m_cJoinCond;
          } else {
            m_cWhere = m_cWhere+m_cLinkedWhere+m_cJoinCond;
          }
          m_bLink_1_40 = true;
          m_nColumns = m_nColumns+2;
        }
      }
    }
    public CPResultSet Query() {
      String l_cWhere = QueryFilter(m_Ctx);
      if (CPLib.Empty(l_cWhere)) {
        l_cWhere = m_cWhere;
      } else {
        if ( ! (CPLib.Empty(m_cWhere))) {
          l_cWhere = "("+m_cWhere+") and ("+l_cWhere+")";
        }
      }
      return m_Sql.Query(m_cServer,CPSql.BuildSQLPhrase(m_cSelect,m_cFrom,l_cWhere,m_cOrderBy));
    }
  }
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public spadministration_usersBO (CPContext p_ContextObject) {
      super(p_ContextObject);
  }
  public boolean CheckOTPSecurity() {
    boolean l_bResult;
    l_bResult = true;
    int accessType;
    boolean requiredOTP;
    boolean requiredPwd;
    requiredOTP = (m_bLoaded?false:false);
    requiredPwd = (m_bLoaded?false:false);
    if (requiredOTP) {
      accessType = 3;
    } else if (requiredPwd) {
      accessType = 2;
    } else {
      accessType = SPLib.AccessType((m_bLoaded?"edit":"insert"),"spadministration_users");
    }
    if (CPLib.eq(accessType,2)) {
      // richiesta password
      if ( ! (CPLib.CheckPwd(m_Ctx,m_cPassword))) {
        l_bResult = false;
        m_nLastError = 4;
        m_cLastMsgError = (CPLib.Empty(m_cPassword)?"MSG_NEED_PWD":"MSG_WRONG_PWD");
      }
    } else if (CPLib.eq(accessType,3)) {
      // richiesto otp
      if (CPLib.Empty(m_cOTP) ||  ! (CPLib.CheckOTP(m_Ctx.UserCode(),m_cOTP))) {
        l_bResult = false;
        m_nLastError = 5;
        m_cLastMsgError = (CPLib.Empty(m_cOTP)?"MSG_NEED_OTP":"MSG_WRONG_OTP");
      }
    }
    return l_bResult;
  }
  public boolean CanSave() {
    ResetErrorMessage();
    boolean l_bResult;
    l_bResult = true;
    l_bResult = (CPLib.Empty(w_decimalseparator) && CPLib.Empty(w_thousandseparator) && CPLib.Empty(w_datepattern) && CPLib.Empty(w_datetimepattern)) || ( ! (CPLib.Empty(w_decimalseparator)) &&  ! (CPLib.Empty(w_thousandseparator)) &&  ! (CPLib.Empty(w_datepattern)) &&  ! (CPLib.Empty(w_datetimepattern)) && CPLib.ne(w_decimalseparator,w_thousandseparator) && CPLib.ne(w_datepattern,w_datetimepattern));
    if (l_bResult) {
    } else {
      m_cLastMsgError = "ADMIN_PICTUREALLCOMPILED";
    }
    if (l_bResult) {
      l_bResult = CanSaveChild(spadministration_usersgroups,m_cWv_spadministration_usersgroups,"m_cWv_spadministration_usersgroups");
      if (l_bResult) {
        l_bResult = CanSaveChild(spadministration_ssomap_child,m_cWv_spadministration_ssomap_child,"m_cWv_spadministration_ssomap_child");
        if (l_bResult) {
          l_bResult = CanSaveChild(spadministration_historypwd,m_cWv_spadministration_historypwd,"m_cWv_spadministration_historypwd");
          if (l_bResult) {
            l_bResult = CanSaveChild(spadministration_usercompanies,m_cWv_spadministration_usercompanies,"m_cWv_spadministration_usercompanies");
            if (l_bResult) {
              l_bResult = CanSaveMNTs(m_MNTs,true) && CanSaveMNTs(m_MNTs,false);
            } else {
              m_cLastMsgError = spadministration_usercompanies.m_cLastMsgError;
            }
          } else {
            m_cLastMsgError = spadministration_historypwd.m_cLastMsgError;
          }
        } else {
          m_cLastMsgError = spadministration_ssomap_child.m_cLastMsgError;
        }
      } else {
        m_cLastMsgError = spadministration_usersgroups.m_cLastMsgError;
      }
    }
    return l_bResult;
  }
  public static String[] m_cSaveParameterNames = {"AlreadyAccepted"};
  public boolean Save() {
    return Save(false);
  }
  public boolean Save(boolean p_bAlreadyAccepted) {
    boolean l_bResult;
    l_bResult = true;
    // Se il record è stato modificato, prosegue con il salvataggio
    if (IsUpdated()) {
      // Verifica globale dei check delle variabili.
      l_bResult = l_bResult && BRCheck();
      l_bResult = l_bResult && Check();
      l_bResult = l_bResult && (m_bSkipCheckOTPSecurity || CheckOTPSecurity());
      l_bResult = l_bResult && (p_bAlreadyAccepted || CanSave());
      if (l_bResult) {
        // Il metodo "Save" richiede l'utilizzo di una transazione. Se il modulo che
        // gestisce le transazioni trova che ce n'è già una, utilizza quella, altrimenti
        // ne inizia una nuova ("begin transaction").
        m_Sql.RequireTransaction();
        if (m_bLoaded) {
          Update();
          BROnUpdated();
        } else {
          Insert();
          BROnInserted();
        }
        if (m_bLoaded) {
          NotifyEvent("Update children start");
        } else {
          NotifyEvent("Insert children start");
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          if ( ! (spadministration_usersgroups.IsUpdated()) && CPLib.IsUpdated(m_cWv_spadministration_usersgroups)) {
            spadministration_usersgroups.SetFromContext(m_cWv_spadministration_usersgroups);
            m_cWv_spadministration_usersgroups = "_not_empty_";
          }
          if (spadministration_usersgroups.IsUpdated()) {
            spadministration_usersgroups.w_usercode = w_code;
            if ( ! (spadministration_usersgroups.Save(true))) {
              m_Sql.AbortTransaction();
            }
          }
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          if ( ! (spadministration_ssomap_child.IsUpdated()) && CPLib.IsUpdated(m_cWv_spadministration_ssomap_child)) {
            spadministration_ssomap_child.SetFromContext(m_cWv_spadministration_ssomap_child);
            m_cWv_spadministration_ssomap_child = "_not_empty_";
          }
          if (spadministration_ssomap_child.IsUpdated()) {
            spadministration_ssomap_child.w_userid = w_code;
            if ( ! (spadministration_ssomap_child.Save(true))) {
              m_Sql.AbortTransaction();
            }
          }
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          if ( ! (spadministration_historypwd.IsUpdated()) && CPLib.IsUpdated(m_cWv_spadministration_historypwd)) {
            spadministration_historypwd.SetFromContext(m_cWv_spadministration_historypwd);
            m_cWv_spadministration_historypwd = "_not_empty_";
          }
          if (spadministration_historypwd.IsUpdated()) {
            spadministration_historypwd.w_code = w_code;
            if ( ! (spadministration_historypwd.Save(true))) {
              m_Sql.AbortTransaction();
            }
          }
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          if ( ! (spadministration_usercompanies.IsUpdated()) && CPLib.IsUpdated(m_cWv_spadministration_usercompanies)) {
            spadministration_usercompanies.SetFromContext(m_cWv_spadministration_usercompanies);
            m_cWv_spadministration_usercompanies = "_not_empty_";
          }
          if (spadministration_usercompanies.IsUpdated()) {
            spadministration_usercompanies.w_usercode = w_code;
            if ( ! (spadministration_usercompanies.Save(true))) {
              m_Sql.AbortTransaction();
            }
          }
        }
        CPLib.SaveMNTs(m_Sql,m_MNTs,this);
        l_bResult = CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK);
        if (m_bLoaded) {
          NotifyEvent("Update children end");
        } else {
          NotifyEvent("Insert children end");
        }
        /*  Se il metodo di richiesta della transazione ha cominciato una nuova transazione,
                                    questa viene terminata ("Commit" o "Rollback"), altrimenti segna come completata
                                    la parte di transazione corrente
                                  */
        // * --- Area Manuale = BO - Save End
        // * --- Fine Area Manuale
        BROnSaved();
        if (CPLib.ne(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          l_bResult = false;
        }
        m_Sql.CompleteTransaction();
      }
    }
    return l_bResult;
  }
  public static String[] m_cLoadParameterNames = {"code"};
  public static String[] m_cDeleteParameterNames = m_cLoadParameterNames;
  public boolean Load(double p_code) {
    CPResultSet l_rsLoad=null;
    SqlLoader l_oSqlLoader;
    l_oSqlLoader = new SqlLoader(m_Sql,m_cServer_cpusers,m_cPhName_cpusers,m_cVirtName_cpusers,m_cVirtName_cpusers+".code="+CPSql.SQLValueAdapter(CPLib.ToSQL(p_code,"N",9,0),m_cServer_cpusers,p_code),"");
    // * --- Area Manuale = BO - Load Record Init
    // * --- Fine Area Manuale
    BlankStatusVariables();
    l_oSqlLoader.AddJoinedLink_1_40(m_cPhName_cplangs,m_cServer_cplangs);
    // Cursore dei record caricati
    l_rsLoad = l_oSqlLoader.Query();
    try {
      m_bLoaded =  ! (l_rsLoad.Eof());
      if (m_bLoaded) {
        m_bCalculating = true;
        /*  Assegna il valore iniziale a tutte le variabili non calcolate/inizializzate.
                                    Queste variabili non vengono inizializzate nella lettura del record,
                                    quindi terrebbero il valore che avevano precedentemente.
                                 */
        w_language_name = "";
        w_selected_group = 0;
        w_g_OTPisActive = m_Ctx.GetGlobalString("g_OTPisActive");
        w_otp = "";
        /*  Assegna i valori letti dal record appena caricato nelle variabili di work.
                                    Vengono calcolate e inizializzate le variabili ed eseguiti i link, rispettando la sequenza
                                    degli item.
                                  */
        w_code = l_rsLoad.GetDouble("code");
        w_otp = "";
        Link_CIUGDDXJMR("Load");
        w_fullname = l_rsLoad.GetString("fullname");
        w_name = l_rsLoad.GetString("name");
        w_accesstype_human = l_rsLoad.GetBoolean("accesstype_human");
        w_accesstype_service = l_rsLoad.GetBoolean("accesstype_service");
        w_accesstype_machine = l_rsLoad.GetBoolean("accesstype_machine");
        w_modifyPassword = (CPLib.eq(EntityStatus(),"E")?0:1);
        w_pwd1 = (CPLib.eq(EntityStatus(),"N")?"":"cambia la password");
        w_calcomplex = UserAdmin.Make(m_Ctx).GetPasswordRating(w_pwd1);
        w_pwdratecause = UserAdmin.Make(m_Ctx).GetPasswordRatingExplaination(w_pwd1);
        w_pwd2 = (CPLib.eq(EntityStatus(),"N")?"":"cambia la password");
        w_pwdcomplexity_group = spadministration_getpwdcomplexity_groupR.Make(m_Ctx,this).Run(w_code);
        w_pwdcomplexity = l_rsLoad.GetDouble("pwdcomplexity");
        w_pwdcomplexity_reqired = CPLib.Max(w_pwdcomplexity,w_pwdcomplexity_group);
        w_forcepwdchange = l_rsLoad.GetBoolean("forcepwdchange");
        w_enabled = l_rsLoad.GetString("enabled");
        w_language = l_rsLoad.GetString("language");
        if (l_oSqlLoader.m_bLink_1_40) {
          w_language_name = l_rsLoad.GetString("name140");
        } else {
          Link_XFCGDYJJAR("Load");
        }
        w_decimalseparator = l_rsLoad.GetString("decimalseparator");
        w_thousandseparator = l_rsLoad.GetString("thousandseparator");
        w_datepattern = l_rsLoad.GetString("datepattern");
        w_datetimepattern = l_rsLoad.GetString("datetimepattern");
        w_pwddaysduration_group = spadministration_getpwdduration_groupR.Make(m_Ctx,this).Run(w_code);
        w_pwddaysduration = l_rsLoad.GetDouble("pwddaysduration");
        w_pwdciclicity_groups = spadministration_getpwdciclicity_groupR.Make(m_Ctx,this).Run(w_code);
        w_pwdciclicity = l_rsLoad.GetDouble("pwdciclicity");
        w_pwdcaptchalevel_group = spadministration_getcaptchalevel_groupR.Make(m_Ctx,this).Run(w_code);
        w_captchalevel = l_rsLoad.GetDouble("captchalevel");
        w_datestart = l_rsLoad.GetDate("datestart");
        w_datestop = l_rsLoad.GetDate("datestop");
        w_failedlogins = l_rsLoad.GetDouble("failedlogins");
        w_lastfailedlogin = l_rsLoad.GetDateTime("lastfailedlogin");
        w_lastsuccessfullogin = l_rsLoad.GetDateTime("lastsuccessfullogin");
        w_pwdcreate = l_rsLoad.GetDateTime("pwdcreate");
        w_pwddaysduration_applied = (CPLib.gt(w_pwddaysduration,0) && CPLib.gt(w_pwddaysduration_group,0)?CPLib.Min(w_pwddaysduration,w_pwddaysduration_group):CPLib.Max(w_pwddaysduration,w_pwddaysduration_group));
        w_pwdciclicity_applied = CPLib.Max(w_pwdciclicity,w_pwdciclicity_groups);
        w_pwdcaptchalevel_applied = (CPLib.gt(w_captchalevel,0) && CPLib.gt(w_pwdcaptchalevel_group,0)?CPLib.Min(w_captchalevel,w_pwdcaptchalevel_group):CPLib.Max(w_captchalevel,w_pwdcaptchalevel_group));
        w_printserver = l_rsLoad.GetString("printserver");
        w_init_code = w_code;
        w_createdwhen = l_rsLoad.GetDateTime("createdwhen");
        w_pwd_modified = true;
        w_usesiarlicense = l_rsLoad.GetString("usesiarlicense");
        w_IAR_LICENSE_VALID = spas_fgetlicensevalidR.Make(m_Ctx,this).Run();
        w_IAR_LICENSES = spas_flicensepurchasedR.Make(m_Ctx,this).Run();
        w_IAR_USED = spas_fgetlicenseusedR.Make(m_Ctx,this).Run();
        w_IAR_AVAILABLE = w_IAR_LICENSES-w_IAR_USED;
        w_companies = l_rsLoad.GetString("companies");
        w_UFENABLEAZI = (CPLib.Empty(w_companies)?"n":"s");
        w_pwd1_view = false;
        w_pwd2_view = false;
        // Assegna i valori degli op_
        // Assegna il contesto dei figli a Empty
        m_cWv_spadministration_usersgroups = "";
        spadministration_usersgroups.m_lCtxLoaded = false;
        m_cWv_spadministration_ssomap_child = "";
        spadministration_ssomap_child.m_lCtxLoaded = false;
        m_cWv_spadministration_historypwd = "";
        spadministration_historypwd.m_lCtxLoaded = false;
        m_cWv_spadministration_usercompanies = "";
        spadministration_usercompanies.m_lCtxLoaded = false;
        SPExtenderLib.LoadExtendedFields(l_rsLoad,extendedFields);
        if (CPLib.HasTableCPCCCHK(m_Ctx,"cpusers")) {
          m_cOldCPCCCHK = l_rsLoad.GetString("CPCCCHK");
        } else {
          m_cOldCPCCCHK = "nocpcc";
        }
        m_bCalculating = false;
        SaveDependsOn();
        m_cPreviousState = GetCurrentState();
        NotifyEvent("Load");
      } else {
        Blank();
      }
    } finally {
      l_rsLoad.Close();
    }
    // * --- Area Manuale = BO - Load Record End
    // * --- Fine Area Manuale
    return m_bLoaded;
  }
  public boolean Load() {
    return Load(w_code);
  }
  void Insert() {
    String l_cSql;
    String l_cCPCCCHK = CPLib.NewCPCCCHK();
    double l_nUpdatedRows;
    // * --- Area Manuale = BO - Insert Init
    // * --- spadministration_users
    //riproduzione dell'autonumber in maniera manuale. Se si hanno due inserimenti concorrenti si deve calcolare il codice utente giusto
    //per essere sicuri di non avere errore di chiave gia' utilizzata
    if (w_code==w_init_code) {
      m_Sql.Update(m_cServer_cpusers, "update "+m_Ctx.PhNameAdapter("cpttbls")+" set FileName = FileName where FileName = "+CPLib.ToSQL("cpusers","C",8,0));
      if (UserAdmin.Make(m_Ctx).HasCode("users",w_code)) {
       w_code = UserAdmin.Make(m_Ctx).GetNextCode("users");
      }
    }
    // * --- Fine Area Manuale
    // * --- Area Manuale = BO - Autonum Assigned
    // * --- Fine Area Manuale
    NotifyEvent("Insert start");
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cpusers);
      l_cSql = "insert into "+m_oWrInfo_cpusers.GetTableWriteName()+" (";
      l_cSql = l_cSql+"code,";
      l_cSql = l_cSql+"fullname,";
      l_cSql = l_cSql+"name,";
      l_cSql = l_cSql+"accesstype_human,";
      l_cSql = l_cSql+"accesstype_service,";
      l_cSql = l_cSql+"accesstype_machine,";
      l_cSql = l_cSql+"pwdcomplexity,";
      l_cSql = l_cSql+"forcepwdchange,";
      l_cSql = l_cSql+"enabled,";
      l_cSql = l_cSql+"language,";
      l_cSql = l_cSql+"decimalseparator,";
      l_cSql = l_cSql+"thousandseparator,";
      l_cSql = l_cSql+"datepattern,";
      l_cSql = l_cSql+"datetimepattern,";
      l_cSql = l_cSql+"pwddaysduration,";
      l_cSql = l_cSql+"pwdciclicity,";
      l_cSql = l_cSql+"captchalevel,";
      l_cSql = l_cSql+"datestart,";
      l_cSql = l_cSql+"datestop,";
      l_cSql = l_cSql+"failedlogins,";
      l_cSql = l_cSql+"lastfailedlogin,";
      l_cSql = l_cSql+"lastsuccessfullogin,";
      l_cSql = l_cSql+"pwdcreate,";
      l_cSql = l_cSql+"printserver,";
      l_cSql = l_cSql+"createdwhen,";
      l_cSql = l_cSql+"usesiarlicense,";
      l_cSql = l_cSql+"companies,";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsNameToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cpusers.InsertFields();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cpusers")) {
        l_cSql = l_cSql+"CPCCCHK";
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+") values (";
      l_cSql = l_cSql+CPLib.ToSQL(w_code,"N",9,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_fullname,"C",2048,0,m_cServer_cpusers,m_oParameters)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_name,"C",50,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_accesstype_human,"L",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_accesstype_service,"L",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_accesstype_machine,"L",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_pwdcomplexity,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_forcepwdchange,"L",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_enabled,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQLNull(w_language,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_decimalseparator,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_thousandseparator,"C",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_datepattern,"C",12,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_datetimepattern,"C",25,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_pwddaysduration,"N",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_pwdciclicity,"N",2,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_captchalevel,"N",4,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_datestart,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_datestop,"D",8,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_failedlogins,"N",3,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_lastfailedlogin,"T",14,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_lastsuccessfullogin,"T",14,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_pwdcreate,"T",14,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_printserver,"C",60,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_createdwhen,"T",14,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_usesiarlicense,"C",1,0)+", ";
      l_cSql = l_cSql+CPLib.ToSQL(w_companies,"C",2000,0,m_cServer_cpusers,m_oParameters)+", ";
      l_cSql = l_cSql+SPExtenderLib.InsertExtendedFieldsValueToSQL(extendedFields);
      l_cSql = l_cSql+m_oWrInfo_cpusers.InsertValues();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cpusers")) {
        l_cSql = l_cSql+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      } else {
        l_cSql = CPLib.TrimTrailingComma(l_cSql);
      }
      l_cSql = l_cSql+")";
      l_nUpdatedRows = m_Sql.Update(m_cServer_cpusers,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Insert end");
    // * --- Area Manuale = BO - Insert End
    // * --- Fine Area Manuale
  }
  void Update() {
    String l_cSql;
    int l_nUpdatedRows;
    String l_cCPCCCHK = CPLib.NewCPCCCHK();
    // * --- Area Manuale = BO - Replace Init
    // * --- Fine Area Manuale
    NotifyEvent("Update start");
    if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer_cpusers);
      l_cSql = "Update "+m_oWrInfo_cpusers.GetTableWriteName()+" set";
      l_cSql = l_cSql+" fullname = "+CPLib.ToSQL(w_fullname,"C",2048,0,m_cServer_cpusers,m_oParameters);
      l_cSql = l_cSql+", name = "+CPLib.ToSQL(w_name,"C",50,0);
      l_cSql = l_cSql+", accesstype_human = "+CPLib.ToSQL(w_accesstype_human,"L",1,0);
      l_cSql = l_cSql+", accesstype_service = "+CPLib.ToSQL(w_accesstype_service,"L",1,0);
      l_cSql = l_cSql+", accesstype_machine = "+CPLib.ToSQL(w_accesstype_machine,"L",1,0);
      l_cSql = l_cSql+", pwdcomplexity = "+CPLib.ToSQL(w_pwdcomplexity,"N",3,0);
      l_cSql = l_cSql+", forcepwdchange = "+CPLib.ToSQL(w_forcepwdchange,"L",1,0);
      l_cSql = l_cSql+", enabled = "+CPLib.ToSQL(w_enabled,"C",1,0);
      l_cSql = l_cSql+", language = "+CPLib.ToSQLNull(w_language,"C",3,0);
      l_cSql = l_cSql+", decimalseparator = "+CPLib.ToSQL(w_decimalseparator,"C",3,0);
      l_cSql = l_cSql+", thousandseparator = "+CPLib.ToSQL(w_thousandseparator,"C",3,0);
      l_cSql = l_cSql+", datepattern = "+CPLib.ToSQL(w_datepattern,"C",12,0);
      l_cSql = l_cSql+", datetimepattern = "+CPLib.ToSQL(w_datetimepattern,"C",25,0);
      l_cSql = l_cSql+", pwddaysduration = "+CPLib.ToSQL(w_pwddaysduration,"N",4,0);
      l_cSql = l_cSql+", pwdciclicity = "+CPLib.ToSQL(w_pwdciclicity,"N",2,0);
      l_cSql = l_cSql+", captchalevel = "+CPLib.ToSQL(w_captchalevel,"N",4,0);
      l_cSql = l_cSql+", datestart = "+CPLib.ToSQL(w_datestart,"D",8,0);
      l_cSql = l_cSql+", datestop = "+CPLib.ToSQL(w_datestop,"D",8,0);
      l_cSql = l_cSql+", failedlogins = "+CPLib.ToSQL(w_failedlogins,"N",3,0);
      l_cSql = l_cSql+", lastfailedlogin = "+CPLib.ToSQL(w_lastfailedlogin,"T",14,0);
      l_cSql = l_cSql+", lastsuccessfullogin = "+CPLib.ToSQL(w_lastsuccessfullogin,"T",14,0);
      l_cSql = l_cSql+", pwdcreate = "+CPLib.ToSQL(w_pwdcreate,"T",14,0);
      l_cSql = l_cSql+", printserver = "+CPLib.ToSQL(w_printserver,"C",60,0);
      l_cSql = l_cSql+", createdwhen = "+CPLib.ToSQL(w_createdwhen,"T",14,0);
      l_cSql = l_cSql+", usesiarlicense = "+CPLib.ToSQL(w_usesiarlicense,"C",1,0);
      l_cSql = l_cSql+", companies = "+CPLib.ToSQL(w_companies,"C",2000,0,m_cServer_cpusers,m_oParameters);
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cpusers")) {
        l_cSql = l_cSql+", CPCCCHK ="+CPLib.ToSQL(l_cCPCCCHK,"C",10,0);
      }
      l_cSql = l_cSql+SPExtenderLib.UpdateExtendedFieldsNameValueToSQL(extendedFields);
      l_cSql = l_cSql+" where ";
      l_cSql = l_cSql+"code="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_code,"N",9,0),m_cServer_cpusers,w_code);
      l_cSql = l_cSql+m_oWrInfo_cpusers.WhereFilter();
      if (CPLib.HasTableCPCCCHK(m_Ctx,"cpusers")) {
        l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
      }
      l_nUpdatedRows = m_Sql.Update(m_cServer_cpusers,l_cSql,m_oParameters);
      if (CPLib.ne(l_nUpdatedRows,1)) {
        m_Sql.AbortTransaction();
      }
    }
    NotifyEvent("Update end");
    // * --- Area Manuale = BO - Replace End
    // * --- Fine Area Manuale
  }
  public boolean Delete(double p_code) {
    String l_cSql;
    int l_nUpdatedRows = 0;
    boolean l_bTrsOk = false;
    Load(p_code);
    // * --- Area Manuale = BO - Delete Init
    // * --- Fine Area Manuale
    if (m_bLoaded) {
      if (CanDelete()) {
        /*  Il metodo "Delete" richiede l'utilizzo di una transazione. Se il modulo che
                                    gestisce le transazioni trova che ce n'è già una, utilizza quella, altrimenti
                                    ne inizia una nuova ("begin transaction").
                                  */
        m_Sql.RequireTransaction();
        NotifyEvent("Delete start");
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio User groups
          spadministration_usersgroups.w_usercode = w_code;
          spadministration_usersgroups.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio LinkPC
          spadministration_ssomap_child.w_userid = w_code;
          spadministration_ssomap_child.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio cphistorypwd
          spadministration_historypwd.w_code = w_code;
          spadministration_historypwd.Delete();
        }
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          // Cancella il figlio User companies
          spadministration_usercompanies.w_usercode = w_code;
          spadministration_usercompanies.Delete();
        }
        CPLib.DeleteMNTs(m_Sql,m_MNTs,this);
        if (CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK)) {
          l_cSql = "Delete from "+m_oWrInfo_cpusers.GetTableWriteName()+" where ";
          l_cSql = l_cSql+"code="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_code,"N",9,0),m_cServer_cpusers,w_code);
          l_cSql = l_cSql+m_oWrInfo_cpusers.WhereFilter();
          if (CPLib.HasTableCPCCCHK(m_Ctx,"cpusers")) {
            l_cSql = l_cSql+" and CPCCCHK="+CPLib.ToSQL(m_cOldCPCCCHK,"C",10,0);
          }
          l_nUpdatedRows = m_Sql.Update(m_cServer_cpusers,l_cSql);
          if (CPLib.ne(l_nUpdatedRows,1)) {
            // AbortTransaction
            m_Sql.AbortTransaction();
          }
        }
        NotifyEvent("Delete end");
        BROnDeleted();
        l_bTrsOk = CPLib.eq(m_Sql.GetTransactionStatus(),CPSql.OK);
        // Se il metodo di richiesta della transazione ha cominciato una nuova transazione,
        // questa viene terminata ("Commit" o "Rollback"), altrimenti segna come completata
        // la parte di transazione corrente
        m_Sql.CompleteTransaction();
      } else {
        m_Sql.AbortTransaction(m_cLastMsgError);
      }
    }
    // * --- Area Manuale = BO - Delete End
    // * --- Fine Area Manuale
    return m_bLoaded && CPLib.eq(l_nUpdatedRows,1) && l_bTrsOk;
  }
  public boolean Delete() {
    return Delete(w_code);
  }
  public static CPLib.SPLinkProperties GetLinkProperties(String p_cID) {
    CPLib.SPLinkProperties result = CPLib.GetSPLinkerProperties();
    if (CPLib.eq(p_cID,"CIUGDDXJMR")) {
      result.m_TableName = "cpusers";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = true;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_DefaultFunction = "";
      result.m_PrgZoom = "";
      result.m_rdField = new String[]{"code" , "cpotp"};
      result.m_rdTypes = new String[]{"N" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("CIUGDDXJMR",CPLib.GetLinkedFieldProps("code","code","N",9,0));
    } else if (CPLib.eq(p_cID,"XFCGDYJJAR")) {
      result.m_TableName = "cplangs";
      result.n_KMode = 1;
      result.m_FillEmpty = false;
      result.m_LooselyLinked = false;
      result.m_dynamicprgzoom = false;
      result.m_SearchingFunction = "";
      result.m_PrgZoom = "spadministration_langs";
      result.m_rdField = new String[]{"code" , "name"};
      result.m_rdTypes = new String[]{"C" , "C"};
      result.m_kField = new String[]{};
      result.m_kTypes = new String[]{};
      result.AppendFieldsHash("XFCGDYJJAR",CPLib.GetLinkedFieldProps("code","language","C",3,0));
    }
    return result;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_BATCHES: ,spadministration_check_username,spadministration_deleteuser,spadministration_firstlogin,spadministration_getcaptchalevel_group,spadministration_getpwdciclicity_group,spadministration_getpwdcomplexity_group,spadministration_getpwdduration_group,spadministration_writepwd,spas_fgetlicenseused,spas_fgetlicensevalid,spas_fhaslicense,spas_flicensepurchased,
  public static final String i_InvokedRoutines = ",spadministration_check_username,spadministration_deleteuser,spadministration_firstlogin,spadministration_getcaptchalevel_group,spadministration_getpwdciclicity_group,spadministration_getpwdcomplexity_group,spadministration_getpwdduration_group,spadministration_writepwd,spas_fgetlicenseused,spas_fgetlicensevalid,spas_fhaslicense,spas_flicensepurchased,";
}
