import java.util.*;

public class spadministration_usersBL extends spadministration_usersWV implements CPLib.QueryFilterFromApplication {
  // Variabile che indica se il record è stato caricato
  public boolean m_bLoaded;
  // Variabile che indica se il record è stato variato
  public boolean m_bUpdated;
  // Variabile che memorizza lo stato subito dopo una Load o una Save
  public String m_cPreviousState;
  // Variabile che mantiene il vecchio timestamp
  public String m_cOldCPCCCHK;
  public java.util.List<String> m_oParameters;
  protected String m_cPassword;
  protected String m_cOTP;
  //  Variabile che indica il tipo dell'ultimo
  //  errore, o messaggio da comunicare all'interfaccia,
  //  che si è verificato impostando una variabile di work.
  //  I valori ammessi sono:
  //  - 1     : errore di campo obbligatorio
  //  - 2     : errore di check
  //  - 3     : valore non ammesso nel link
  //  - 4     : richiesta password
  //  - 5     : richiesto otp
  public int m_nLastError;
  public String m_cLastMsgError;
  public String m_cLastWorkVarError;
  // m_bCalculating==true la Calculate e' in esecuzione
  public boolean m_bCalculating = false;
  public static final String i_EntityName = "spadministration_users";
  public static final String i_EntityType = "master";
  public static final boolean i_IsSon = false;
  public boolean m_bSkipCheckOTPSecurity = true;
  // Variabile di collegamento con il database: passata nel costruttore
  public CPSql m_Sql;
  // Variabile di contesto (variabili globali): passata nel costruttore
  public CPContext m_Ctx;
  // Variabili che contengono il nome fisico e la connessione per la tabella collegata
  public String m_cPhName_cpusers;
  public String m_cServer_cpusers;
  public CPPhTableWrInfo m_oWrInfo_cpusers;
  // Variabile che contiene il nome virtuale della tabella
  public String m_cVirtName_cpusers;
  public String m_cPhName_cplangs;
  public String m_cServer_cplangs;
  public CPPhTableWrInfo m_oWrInfo_cplangs;
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public CPPhTableWrInfo m_oWrInfo_cpazi;
  // gestori eventi esterni al business object sono collegati inserendoli nella coppia di strutture dati seguenti
  // gestori associati a particolari eventi ('Blank')
  public static volatile HashMap specificEventsHandlers;
  // gestori associati a tutti gli eventi
  public static volatile ArrayList allEventsHandlers;
  // metadati resi disponibili ai gestori di eventi
  public static String[] m_EntityTables = {"cpusers"};
  // codice secondo sintassi delle business rules per produrre i dati da usare in un ideale documento che li rappresenti
  public static final String i_StateStructure = "{'spadministration_usersgroups':spadministration_usersgroups,'spadministration_ssomap_child':spadministration_ssomap_child,'code':code,'fullname':fullname,'name':name,'accesstype_human':accesstype_human,'accesstype_service':accesstype_service,'accesstype_machine':accesstype_machine,'modifyPassword':modifyPassword,'pwd1':pwd1,'pwd2':pwd2,'pwdcomplexity_group':pwdcomplexity_group,'pwdcomplexity':pwdcomplexity,'forcepwdchange':forcepwdchange,'enabled':enabled,'language':language,'decimalseparator':decimalseparator,'thousandseparator':thousandseparator,'datepattern':datepattern,'datetimepattern':datetimepattern,'pwddaysduration':pwddaysduration,'pwdciclicity':pwdciclicity,'captchalevel':captchalevel,'spadministration_historypwd':spadministration_historypwd,'spadministration_usercompanies':spadministration_usercompanies,'datestart':datestart,'datestop':datestop,'printserver':printserver,'usesiarlicense':usesiarlicense,'selected_group':selected_group,'otp':otp,'companies':companies,'UFENABLEAZI':UFENABLEAZI"+FoundlingChildrenList("spadministration_users",true)+"}";
  public static final String i_CompleteStateStructure = "{'spadministration_usersgroups':spadministration_usersgroups,'spadministration_ssomap_child':spadministration_ssomap_child,'code':code,'fullname':fullname,'name':name,'accesstype_human':accesstype_human,'accesstype_service':accesstype_service,'accesstype_machine':accesstype_machine,'modifyPassword':modifyPassword,'pwd1':pwd1,'calcomplex':calcomplex,'pwdratecause':pwdratecause,'pwd2':pwd2,'pwdcomplexity_group':pwdcomplexity_group,'pwdcomplexity':pwdcomplexity,'pwdcomplexity_reqired':pwdcomplexity_reqired,'forcepwdchange':forcepwdchange,'enabled':enabled,'language':language,'language_name':language_name,'decimalseparator':decimalseparator,'thousandseparator':thousandseparator,'datepattern':datepattern,'datetimepattern':datetimepattern,'pwddaysduration_group':pwddaysduration_group,'pwddaysduration':pwddaysduration,'pwdciclicity_groups':pwdciclicity_groups,'pwdciclicity':pwdciclicity,'pwdcaptchalevel_group':pwdcaptchalevel_group,'captchalevel':captchalevel,'spadministration_historypwd':spadministration_historypwd,'spadministration_usercompanies':spadministration_usercompanies,'datestart':datestart,'datestop':datestop,'failedlogins':failedlogins,'lastfailedlogin':lastfailedlogin,'lastsuccessfullogin':lastsuccessfullogin,'pwdcreate':pwdcreate,'pwddaysduration_applied':pwddaysduration_applied,'pwdciclicity_applied':pwdciclicity_applied,'pwdcaptchalevel_applied':pwdcaptchalevel_applied,'printserver':printserver,'init_code':init_code,'createdwhen':createdwhen,'pwd_modified':pwd_modified,'usesiarlicense':usesiarlicense,'IAR_LICENSE_VALID':IAR_LICENSE_VALID,'IAR_LICENSES':IAR_LICENSES,'IAR_USED':IAR_USED,'IAR_AVAILABLE':IAR_AVAILABLE,'selected_group':selected_group,'g_OTPisActive':g_OTPisActive,'otp':otp,'companies':companies,'UFENABLEAZI':UFENABLEAZI,'pwd1_view':pwd1_view,'pwd2_view':pwd2_view"+FoundlingChildrenList("spadministration_users",true)+"}";
  public static final String i_ItemSequence = "spadministration_usersgroups,spadministration_ssomap_child,code,fullname,name,accesstype_human,accesstype_service,accesstype_machine,modifyPassword,pwd1,pwd2,pwdcomplexity_group,pwdcomplexity,forcepwdchange,enabled,language,decimalseparator,thousandseparator,datepattern,datetimepattern,pwddaysduration,pwdciclicity,captchalevel,spadministration_historypwd,spadministration_usercompanies,datestart,datestop,printserver,usesiarlicense,selected_group,otp,companies,UFENABLEAZI"+FoundlingChildrenList("spadministration_users",false)+"";
  public static final com.zucchetti.sitepainter.EntityItem[] i_EditableEntityItems = com.zucchetti.sitepainter.EntityItem.buildEditableItemsForEntity(GetLinkDef(),FoundlingChildrenList("spadministration_users"),new String[][]{new String[]{"spadministration_usersgroups","User groups","","","","link_PC","","false",""},new String[]{"spadministration_ssomap_child","LinkPC","","","","link_PC","","false",""},new String[]{"code","ADMIN_CODE","N","9","0","campo","key1","false","false"},new String[]{"fullname","ADMIN_FULLNAME","C","2048","0","campo","nokey","false","false"},new String[]{"name","ADMIN_NAME","C","50","0","campo","nokey","false","true"},new String[]{"accesstype_human","&Human","L","1","0","campo","nokey","false","false"},new String[]{"accesstype_service","&Service","L","1","0","campo","nokey","false","false"},new String[]{"accesstype_machine","&Machine","L","1","0","campo","nokey","false","false"},new String[]{"modifyPassword","","N","1","0","variabile","nokey","false","false"},new String[]{"pwd1","Password","C","20","0","variabile","nokey","false","false"},new String[]{"pwd2","MSG_CONFIRM_PASSWORD","C","20","0","variabile","nokey","false","false"},new String[]{"pwdcomplexity_group","ADMIN_PWDCOMPLEXITY","N","3","0","variabile","nokey","false","false"},new String[]{"pwdcomplexity","ADMIN_PWDCOMPLEXITY","N","3","0","campo","nokey","false","false"},new String[]{"forcepwdchange","ADMIN_FORCEPWDCHANGE","L","1","0","campo","nokey","false","false"},new String[]{"enabled","ADMIN_DISABLED","C","1","0","campo","nokey","false","false"},new String[]{"language","ADMIN_LANGUAGE","C","3","0","campo","nokey","false","false"},new String[]{"decimalseparator","","C","3","0","campo","nokey","false","false"},new String[]{"thousandseparator","","C","3","0","campo","nokey","false","false"},new String[]{"datepattern","ADMIN_DATEPATTERN","C","12","0","campo","nokey","false","false"},new String[]{"datetimepattern","ADMIN_DATETIMEPATTERN","C","25","0","campo","nokey","false","false"},new String[]{"pwddaysduration","ADMIN_PWDDAYSDURATION","N","4","0","campo","nokey","false","false"},new String[]{"pwdciclicity","ADMIN_PWDCICLICITY","N","2","0","campo","nokey","false","false"},new String[]{"captchalevel","ADMIN_CAPTCHA_LEVEL","N","4","0","campo","nokey","false","false"},new String[]{"spadministration_historypwd","cphistorypwd","","","","link_PC","","false",""},new String[]{"spadministration_usercompanies","User companies","","","","link_PC","","false",""},new String[]{"datestart","ADMIN_VALIDITY_START","D","8","0","campo","nokey","false","false"},new String[]{"datestop","ADMIN_VALIDITY_END","D","8","0","campo","nokey","false","false"},new String[]{"printserver","ADMIN_PRINT_SERVER","C","60","0","campo","nokey","false","false"},new String[]{"usesiarlicense","SPAS_USES_IAR_LICENSE","C","1","0","campo","nokey","false","false"},new String[]{"selected_group","","N","4","0","variabile","nokey","false","false"},new String[]{"otp","","C","100","0","variabile","nokey","false","false"},new String[]{"companies","Companies","C","2000","0","campo","nokey","false","false"},new String[]{"UFENABLEAZI","Abilita l'utente su certe aziende","C","1","0","variabile","nokey","false","false"}});
  // dati usati internamente dai metodi BRxxx di BRCallerImpl
  private static boolean _involved=true;
  protected void _setInvolvedInBR(boolean involved) {
    _involved=involved;
  }
  protected boolean _involvedInBR() {
    return _involved;
  }
  public spadministration_usersBL (CPContext p_ContextObject) {
    /*  Impostazione dell'ambiente globale: il businness object si collega
               all'oggetto globale (unico per più istanze di una stessa applicazione)
               per recuperare informazioni sul:
               1) nome fisico della tabella di gestione;
               2) nome fisico delle tabelle collegate nei link;
               3) stringa di connessione.
               L'azienda è contenuta nel global object. */
    // Assegnazione delle variabili che contengono il nome fisico, il nome virtuale, e la connessione per la tabella collegata
    m_cPhName_cpusers = p_ContextObject.GetPhName("cpusers",p_ContextObject.GetCompany(),false);
    m_cServer_cpusers = p_ContextObject.GetServer("cpusers");
    m_oWrInfo_cpusers = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cpusers",p_ContextObject.GetCompany());
    m_cVirtName_cpusers = CPSql.ManipulateTablePhName("cpusers",m_cServer_cpusers);
    // Assegnazione della variabile di collegamento con il database
    m_Sql = p_ContextObject.GetSql();
    m_Ctx = p_ContextObject;
    m_cPhName_cplangs = p_ContextObject.GetPhName("cplangs");
    m_cServer_cplangs = p_ContextObject.GetServer("cplangs");
    m_oWrInfo_cplangs = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cplangs",p_ContextObject.GetCompany());
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_oWrInfo_cpazi = CPPhTableWrInfo.GetCPPhTableWrInfo(p_ContextObject,"cpazi",p_ContextObject.GetCompany());
    // Istanziazione dei business object dei figli
    spadministration_usersgroups = new spadministration_usersgroupsBO(p_ContextObject);
    spadministration_ssomap_child = new spadministration_ssomap_childBO(p_ContextObject);
    spadministration_historypwd = new spadministration_historypwdBO(p_ContextObject);
    spadministration_usercompanies = new spadministration_usercompaniesBO(p_ContextObject);
    m_MNTs = CPLib.MNTChilds("spadministration_users",p_ContextObject);
  }
  public void Blank() {
    BlankStatusVariables();
    // * --- Area Manuale = BO - Blank Record Init
    // * --- Fine Area Manuale
    w_fullname = "";
    w_name = "";
    w_pwdcomplexity = 0;
    w_forcepwdchange = false;
    w_language = "";
    w_language_name = "";
    w_decimalseparator = "";
    w_thousandseparator = "";
    w_datepattern = "";
    w_datetimepattern = "";
    w_pwddaysduration = 0;
    w_pwdciclicity = 0;
    w_captchalevel = 0;
    w_datestart = CPLib.NullDate();
    w_datestop = CPLib.NullDate();
    w_failedlogins = 0;
    w_lastfailedlogin = CPLib.NullDateTime();
    w_lastsuccessfullogin = CPLib.NullDateTime();
    w_printserver = "";
    w_usesiarlicense = "";
    w_selected_group = 0;
    w_g_OTPisActive = m_Ctx.GetGlobalString("g_OTPisActive");
    w_otp = "";
    w_code = UserAdmin.Make(m_Ctx).GetNextCode("users");
    Link_CIUGDDXJMR();
    w_accesstype_human = true;
    w_accesstype_service = true;
    w_accesstype_machine = true;
    w_modifyPassword = (CPLib.eq(EntityStatus(),"E")?0:1);
    w_pwd1 = (CPLib.eq(EntityStatus(),"N")?"":"cambia la password");
    w_calcomplex = 0;
    w_calcomplex = UserAdmin.Make(m_Ctx).GetPasswordRating(w_pwd1);
    w_pwdratecause = "";
    w_pwdratecause = UserAdmin.Make(m_Ctx).GetPasswordRatingExplaination(w_pwd1);
    w_pwd2 = (CPLib.eq(EntityStatus(),"N")?"":"cambia la password");
    w_pwdcomplexity_group = 0;
    w_pwdcomplexity_group = spadministration_getpwdcomplexity_groupR.Make(m_Ctx,this).Run(w_code);
    w_pwdcomplexity_reqired = 0;
    w_pwdcomplexity_reqired = CPLib.Max(w_pwdcomplexity,w_pwdcomplexity_group);
    w_enabled = "E";
    Link_XFCGDYJJAR();
    w_pwddaysduration_group = 0;
    w_pwddaysduration_group = spadministration_getpwdduration_groupR.Make(m_Ctx,this).Run(w_code);
    w_pwdciclicity_groups = 0;
    w_pwdciclicity_groups = spadministration_getpwdciclicity_groupR.Make(m_Ctx,this).Run(w_code);
    w_pwdcaptchalevel_group = 0;
    w_pwdcaptchalevel_group = spadministration_getcaptchalevel_groupR.Make(m_Ctx,this).Run(w_code);
    w_pwdcreate = CPLib.DateTime();
    w_pwddaysduration_applied = 0;
    w_pwddaysduration_applied = (CPLib.gt(w_pwddaysduration,0) && CPLib.gt(w_pwddaysduration_group,0)?CPLib.Min(w_pwddaysduration,w_pwddaysduration_group):CPLib.Max(w_pwddaysduration,w_pwddaysduration_group));
    w_pwdciclicity_applied = 0;
    w_pwdciclicity_applied = CPLib.Max(w_pwdciclicity,w_pwdciclicity_groups);
    w_pwdcaptchalevel_applied = 0;
    w_pwdcaptchalevel_applied = (CPLib.gt(w_captchalevel,0) && CPLib.gt(w_pwdcaptchalevel_group,0)?CPLib.Min(w_captchalevel,w_pwdcaptchalevel_group):CPLib.Max(w_captchalevel,w_pwdcaptchalevel_group));
    w_init_code = w_code;
    w_createdwhen = CPLib.DateTime();
    w_pwd_modified = false;
    w_pwd_modified = true;
    w_IAR_LICENSE_VALID = spas_fgetlicensevalidR.Make(m_Ctx,this).Run();
    w_IAR_LICENSES = spas_flicensepurchasedR.Make(m_Ctx,this).Run();
    w_IAR_USED = spas_fgetlicenseusedR.Make(m_Ctx,this).Run();
    w_IAR_AVAILABLE = 0;
    w_IAR_AVAILABLE = w_IAR_LICENSES-w_IAR_USED;
    w_companies = "";
    w_companies = (CPLib.eq(w_UFENABLEAZI,"n")?"":w_companies);
    w_UFENABLEAZI = "";
    w_UFENABLEAZI = (CPLib.Empty(w_companies)?"n":"s");
    w_pwd1_view = false;
    w_pwd2_view = false;
    m_cWv_spadministration_usersgroups = "";
    m_cWv_spadministration_ssomap_child = "";
    m_cWv_spadministration_historypwd = "";
    m_cWv_spadministration_usercompanies = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    NotifyEvent("Blank");
    // * --- Area Manuale = BO - Blank Record End
    // * --- Fine Area Manuale
  }
  public boolean IsUpdated() {
    boolean l_bResult;
    l_bResult = m_bUpdated;
    l_bResult = l_bResult || spadministration_usersgroups.IsUpdated() || CPLib.IsUpdated(m_cWv_spadministration_usersgroups);
    l_bResult = l_bResult || spadministration_ssomap_child.IsUpdated() || CPLib.IsUpdated(m_cWv_spadministration_ssomap_child);
    l_bResult = l_bResult || spadministration_historypwd.IsUpdated() || CPLib.IsUpdated(m_cWv_spadministration_historypwd);
    l_bResult = l_bResult || spadministration_usercompanies.IsUpdated() || CPLib.IsUpdated(m_cWv_spadministration_usercompanies);
    return l_bResult;
  }
  public boolean IsLoaded() {
    return m_bLoaded;
  }
  public boolean IsNew() {
    return IsUpdated() &&  ! (IsLoaded());
  }
  public void SaveDependsOn() {
    o_code = w_code;
    o_modifyPassword = w_modifyPassword;
    o_pwd1 = w_pwd1;
    o_pwd2 = w_pwd2;
    o_pwddaysduration_group = w_pwddaysduration_group;
    o_pwddaysduration = w_pwddaysduration;
    o_pwdciclicity_groups = w_pwdciclicity_groups;
    o_pwdciclicity = w_pwdciclicity;
    o_pwdcaptchalevel_group = w_pwdcaptchalevel_group;
    o_captchalevel = w_captchalevel;
    o_selected_group = w_selected_group;
    o_companies = w_companies;
    o_UFENABLEAZI = w_UFENABLEAZI;
    spadministration_usersgroups.SaveDependsOn();
    spadministration_ssomap_child.SaveDependsOn();
    spadministration_historypwd.SaveDependsOn();
    spadministration_usercompanies.SaveDependsOn();
  }
  public void NotifyEvent(String p_cEvent) {
    if (CPLib.eq(p_cEvent,"Insert end")) {
      Calculation_ORMDEWSLSD();
    } else if (CPLib.eq(p_cEvent,"Record Deleted")) {
      Calculation_FABWPYXIOK();
    } else if (CPLib.eq(p_cEvent,"Record Inserted")) {
      Calculation_UGMVQYEORN();
    } else if (CPLib.eq(p_cEvent,"Update end")) {
      Calculation_ORMDEWSLSD();
    }
    CPLib.NotifyEvent(p_cEvent,this,m_Ctx,specificEventsHandlers,allEventsHandlers);
  }
  // Funzioni di link legate alle variabili ed ai campi.
  protected boolean Link_CIUGDDXJMR() {
    return Link_CIUGDDXJMR("Full");
  }
  protected boolean Link_CIUGDDXJMR(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_code))) {
      double l_OldValue = w_code;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_code,"N",9,0),m_cServer_cpusers,w_code);
      if (m_Ctx.IsSharedTemp("cpusers")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_cpusers,"select code,cpotp from "+m_cPhName_cpusers+((m_cPhName_cpusers).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"code"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_code = l_rsLink.GetDouble("code");
          w_otp = l_rsLink.GetString("cpotp");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          l_bResult = true;
          if (CPLib.eq(p_cType,"Full")) {
            Link_CIUGDDXJMR_blank();
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","code");
          }
          m_cLastWorkVarError = "code";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_CIUGDDXJMR_blank();
    }
    return l_bResult;
  }
  void Link_CIUGDDXJMR_blank() {
    Link_CIUGDDXJMR_blank("");
  }
  void Link_CIUGDDXJMR_blank(String p_cType) {
    w_otp = "";
  }
  protected boolean Link_XFCGDYJJAR() {
    return Link_XFCGDYJJAR("Full");
  }
  protected boolean Link_XFCGDYJJAR(String p_cType) {
    // Viene eseguita una query per chiave totale.
    boolean l_bResult;
    boolean l_bLoaded;
    String l_cWhere = "";
    String l_cCurrentKey;
    l_bResult = false;
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsLink=null;
    if ( ! (CPLib.Empty(w_language))) {
      String l_OldValue = w_language;
      // Costruzione della where per la chiave corrente e per le chiavi fisse
      l_cCurrentKey = "="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_language,"C",3,0),m_cServer_cplangs,w_language);
      if (m_Ctx.IsSharedTemp("cplangs")) {
        l_cWhere = l_cWhere+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (l_rsLink!=null)
        l_rsLink.Close();
      l_rsLink = m_Sql.Query(m_cServer_cplangs,"select code,name from "+m_cPhName_cplangs+((m_cPhName_cplangs).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"code"+l_cCurrentKey+l_cWhere);
      try {
        l_bLoaded =  ! (l_rsLink.Eof());
        if (l_bLoaded) {
          /*  E' stato trovato almeno un record: i valori del cursore vengono riportati nei
                                      relativi campi e/o variabili.
                                    */
          w_language = l_rsLink.GetString("code");
          w_language_name = l_rsLink.GetString("name");
          l_rsLink.Next();
          /*  Se è stato trovato un record il link con chiave piena ha avuto successo.
                                  */
          l_bResult = l_rsLink.Eof();
          /*  Segna che l'interfaccia potrebbe fare un link con chiave parziale
                                    */
        } else {
          Link_XFCGDYJJAR_blank();
          if (CPLib.eq(p_cType,"Load")) {
            w_language = l_OldValue;
          }
        }
        if ( ! (l_bResult)) {
          m_nLastError = 3;
          m_cLastMsgError = "";
          if (CPLib.eq(m_cLastMsgError,"")) {
            m_cLastMsgError = m_Ctx.Translate("MSG_LINK_FAILED","language");
          }
          m_cLastWorkVarError = "language";
        }
      } finally {
        l_rsLink.Close();
      }
    } else {
      // Se la variabile è vuota deve essere considerato un valore valido ('NULL')
      l_bResult = true;
      Link_XFCGDYJJAR_blank();
    }
    return l_bResult;
  }
  void Link_XFCGDYJJAR_blank() {
    w_language = "";
    w_language_name = "";
  }
  /*  Gestione dei metodi per l'impostazione delle variabili di work.
                              I seguenti metodi sono pubblici perchè vengono chiamati dalla UI che
                              ha creato il business object o da batch.
                            */
  public boolean Set_code(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_code = p_workVariableValue;
    l_bResult = Link_CIUGDDXJMR();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_code = 0;
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_fullname(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_fullname = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_name(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_name = p_workVariableValue;
    // Se il campo è vuoto, demando la segnalazione dell'obbligatorietà alla Check() del business object
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_name = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_accesstype_human(boolean p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_accesstype_human = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_accesstype_service(boolean p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_accesstype_service = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_accesstype_machine(boolean p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_accesstype_machine = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_modifyPassword(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_modifyPassword = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_pwd1(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_pwd1 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_pwd2(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_pwd2 = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_pwdcomplexity_group(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_pwdcomplexity_group = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_pwdcomplexity(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_pwdcomplexity = p_workVariableValue;
    // 
    l_bResult = CPLib.ge(w_pwdcomplexity,0) && CPLib.le(w_pwdcomplexity,UserAdmin.Make(m_Ctx).GetPasswordRatingMaxReachable());
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = "ADMIN_MSG_ERROR_RANGE";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_pwdcomplexity = 0;
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_forcepwdchange(boolean p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_forcepwdchange = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_enabled(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_enabled = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_language(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_language = p_workVariableValue;
    l_bResult = Link_XFCGDYJJAR();
    // La variabile che indica il tipo di errore viene eventualmente impostata
    // dalla funzione di link: infatti il suo valore di ritorno non e'
    // sufficiente per determinare il tipo di errore che puo' essere di valore
    // non trovato nella tabella collegata o di check non valido.
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_language = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_decimalseparator(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_decimalseparator = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_thousandseparator(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_thousandseparator = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_datepattern(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_datepattern = p_workVariableValue;
    // 
    l_bResult = CPLib.Empty(w_datepattern) || (CPLib.gt(CPLib.At("YYYY",w_datepattern),0) && CPLib.gt(CPLib.At("MM",w_datepattern),0) && CPLib.gt(CPLib.At("DD",w_datepattern),0));
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = "ADMIN_DATE_WRONG";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_datepattern = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_datetimepattern(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_datetimepattern = p_workVariableValue;
    // 
    l_bResult = CPLib.Empty(w_datetimepattern) || (CPLib.gt(CPLib.At("YYYY",w_datetimepattern),0) && CPLib.gt(CPLib.At("MM",w_datetimepattern),0) && CPLib.gt(CPLib.At("DD",w_datetimepattern),0) && CPLib.gt(CPLib.At("hh",w_datetimepattern),0) && CPLib.gt(CPLib.At("mm",w_datetimepattern),0) && CPLib.gt(CPLib.At("ss",w_datetimepattern),0));
    if ( ! (l_bResult)) {
      m_nLastError = 2;
      m_cLastMsgError = "ADMIN_DATETIME_WRONG";
    }
    if ( ! (l_bResult)) {
      // Impostazione a blank della variabile di work
      w_datetimepattern = "";
    }
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_pwddaysduration(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_pwddaysduration = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_pwdciclicity(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_pwdciclicity = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_captchalevel(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_captchalevel = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_datestart(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_datestart = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_datestop(java.sql.Date p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_datestop = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_printserver(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_printserver = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_usesiarlicense(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_usesiarlicense = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_selected_group(double p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_selected_group = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_otp(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_otp = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_companies(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_companies = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  public boolean Set_UFENABLEAZI(String p_workVariableValue) {
    m_nLastError = 0;
    m_cLastMsgError = "";
    boolean l_bResult;
    l_bResult = true;
    // Variabile temporanea che conterrà il risultato della funzione di link se l'item corrente è parte di una chiave composta
    boolean l_bTmpRes;
    SetUpdated();
    w_UFENABLEAZI = p_workVariableValue;
    // Esecuzione dei calcoli
    Calculate();
    SaveDependsOn();
    return l_bResult;
  }
  /*  Gestione delle funzioni che rispondono lo stato delle variabili di work.
                              Vengono chiamate dalla UI per valutare la condizione di visibilità e di
                              abilitazione di un control.
                            */
  public boolean getWritable_pwd1() {
    return CPLib.ne(EntityStatus(),"E") || CPLib.eq(w_modifyPassword,1);
  }
  public boolean getWritable_pwd2() {
    return CPLib.ne(EntityStatus(),"E") || CPLib.eq(w_modifyPassword,1);
  }
  public boolean getWritable_pwdcomplexity_group() {
    return false;
  }
  public boolean getWritable_usesiarlicense() {
    return w_IAR_LICENSE_VALID;
  }
  public boolean getWritable_companies() {
    return false;
  }
  public boolean getVisible_calcomplex() {
    return CPLib.eq(w_pwd1,"cambia la password");
  }
  public boolean getVisible_pwdcomplexity_reqired() {
    return CPLib.eq(w_pwd1,"cambia la password");
  }
  public boolean getVisible_selected_group() {
    return true;
  }
  public boolean getVisible_otp() {
    return true;
  }
  public boolean getVisible_companies() {
    return true;
  }
  public boolean Set_Password(String p_pwd) {
    m_cPassword = p_pwd;
    return true;
  }
  public boolean Set_OTP(String p_otp) {
    m_cOTP = p_otp;
    return true;
  }
  public boolean Calculate() {
    boolean l_bTmpRes;
    l_bTmpRes = true;
    boolean l_bResult;
    l_bResult = true;
    m_bCalculating = true;
    if (CPLib.ne(o_modifyPassword,w_modifyPassword)) {
      Calculation_YULXNUPOWY();
    }
    if (CPLib.ne(o_pwd1,w_pwd1) || CPLib.ne(o_modifyPassword,w_modifyPassword)) {
      w_calcomplex = UserAdmin.Make(m_Ctx).GetPasswordRating(w_pwd1);
    }
    if (CPLib.ne(o_pwd1,w_pwd1)) {
      w_pwdratecause = UserAdmin.Make(m_Ctx).GetPasswordRatingExplaination(w_pwd1);
    }
    if (CPLib.ne(o_code,w_code)) {
      w_pwdcomplexity_group = spadministration_getpwdcomplexity_groupR.Make(m_Ctx,this).Run(w_code);
    }
    w_pwdcomplexity_reqired = CPLib.Max(w_pwdcomplexity,w_pwdcomplexity_group);
    if (CPLib.ne(o_code,w_code)) {
      w_pwddaysduration_group = spadministration_getpwdduration_groupR.Make(m_Ctx,this).Run(w_code);
    }
    if (CPLib.ne(o_code,w_code)) {
      w_pwdciclicity_groups = spadministration_getpwdciclicity_groupR.Make(m_Ctx,this).Run(w_code);
    }
    if (CPLib.ne(o_code,w_code)) {
      w_pwdcaptchalevel_group = spadministration_getcaptchalevel_groupR.Make(m_Ctx,this).Run(w_code);
    }
    if (CPLib.ne(o_pwddaysduration,w_pwddaysduration) || CPLib.ne(o_pwddaysduration_group,w_pwddaysduration_group)) {
      w_pwddaysduration_applied = (CPLib.gt(w_pwddaysduration,0) && CPLib.gt(w_pwddaysduration_group,0)?CPLib.Min(w_pwddaysduration,w_pwddaysduration_group):CPLib.Max(w_pwddaysduration,w_pwddaysduration_group));
    }
    if (CPLib.ne(o_pwdciclicity,w_pwdciclicity) || CPLib.ne(o_pwdciclicity_groups,w_pwdciclicity_groups)) {
      w_pwdciclicity_applied = CPLib.Max(w_pwdciclicity,w_pwdciclicity_groups);
    }
    if (CPLib.ne(o_captchalevel,w_captchalevel) || CPLib.ne(o_pwdcaptchalevel_group,w_pwdcaptchalevel_group)) {
      w_pwdcaptchalevel_applied = (CPLib.gt(w_captchalevel,0) && CPLib.gt(w_pwdcaptchalevel_group,0)?CPLib.Min(w_captchalevel,w_pwdcaptchalevel_group):CPLib.Max(w_captchalevel,w_pwdcaptchalevel_group));
    }
    if (CPLib.ne(o_pwd1,w_pwd1) || CPLib.ne(o_pwd2,w_pwd2)) {
      w_pwd_modified = true;
    }
    w_IAR_AVAILABLE = w_IAR_LICENSES-w_IAR_USED;
    if (CPLib.ne(o_UFENABLEAZI,w_UFENABLEAZI)) {
      w_companies = (CPLib.eq(w_UFENABLEAZI,"n")?"":w_companies);
    }
    if (CPLib.ne(o_companies,w_companies)) {
      w_UFENABLEAZI = (CPLib.Empty(w_companies)?"n":"s");
    }
    // * --- Area Manuale = BO - Calculate
    // * --- Fine Area Manuale
    CopyWorkVar(this,spadministration_usersgroups,new String[]{"selected_group"},new String[]{"selected_group"},true);
    for (int l_i = 0; CPLib.lt(l_i,m_MNTs.length); l_i = l_i + (1)) {
      m_MNTs[l_i].m_child.FoundlingCopyWorkVar(this,true);
    }
    m_bCalculating = false;
    return l_bResult;
  }
  void Calculation_YULXNUPOWY() {
    if (CPLib.eq(w_modifyPassword,1)) {
      w_pwd1 = "";
    }
    if (CPLib.eq(w_modifyPassword,1)) {
      w_pwd2 = "";
    }
    if (CPLib.eq(w_modifyPassword,0)) {
      w_pwd1 = "cambia la password";
    }
    if (CPLib.eq(w_modifyPassword,0)) {
      w_pwd2 = "cambia la password";
    }
  }
  void Calculation_ORMDEWSLSD() {
    spadministration_writepwdR l_oRoutine_spadministration_writepwd;
    l_oRoutine_spadministration_writepwd = spadministration_writepwdR.Make(m_Ctx,this);
    l_oRoutine_spadministration_writepwd.password = w_pwd2;
    l_oRoutine_spadministration_writepwd.usercode = w_code;
    l_oRoutine_spadministration_writepwd.Run();
  }
  void Calculation_FABWPYXIOK() {
    spadministration_deleteuserR l_oRoutine_spadministration_deleteuser;
    l_oRoutine_spadministration_deleteuser = spadministration_deleteuserR.Make(m_Ctx,this);
    l_oRoutine_spadministration_deleteuser.usercode = w_code;
    l_oRoutine_spadministration_deleteuser.Run();
  }
  void Calculation_UGMVQYEORN() {
    spadministration_firstloginR l_oRoutine_spadministration_firstlogin;
    l_oRoutine_spadministration_firstlogin = spadministration_firstloginR.Make(m_Ctx,this);
    l_oRoutine_spadministration_firstlogin.usercode = w_code;
    l_oRoutine_spadministration_firstlogin.Run();
  }
  boolean Check_DPHWQTPSFC(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce) {
      l_bResult =  ! (w_pwd_modified) || UserAdmin.Make(m_Ctx).CheckPasswordStrength(w_pwd1,w_pwdcomplexity_reqired);
      if ( ! (l_bResult)) {
        m_cLastMsgError = "MSG_WEAKY_PASSWORD";
      } else {
        l_bResult = CPLib.eq(w_pwd1,w_pwd2);
        if ( ! (l_bResult)) {
          m_cLastMsgError = "MSG_PASSWORD_CONFIRM_DIFFERENT";
        }
      }
    }
    return l_bResult;
  }
  boolean Check_BLWKYYPKAQ(boolean p_bForce) {
    boolean l_bResult = true;
    if (p_bForce) {
      l_bResult = CPLib.gt(w_code,0);
      if ( ! (l_bResult)) {
        m_cLastMsgError = "ADMIN_CODE_MUST_POSITIVE";
      }
    }
    return l_bResult;
  }
  protected void BlankStatusVariables() {
    m_bLoaded = false;
    m_bUpdated = false;
    m_cPreviousState = CPSecurity.UNKNOWN_STATE;
  }
  public void CalledBatchEnd() {
    if ( ! (m_bCalculating)) {
      // Esecuzione dei calcoli
      Calculate();
    }
  }
  public final static String[] m_KeyColumns = {"code"};
  public static String QueryFilter(CPContext m_Ctx) {
    String l_cFilter;
    l_cFilter = CPLib.ApplicationQueryFilter("spadministration_users","cpusers",m_KeyColumns,m_Ctx);
    return l_cFilter;
  }
  public void SetFromContext(String s) {
    SetFromContext(s,null);
  }
  public void SetFromContext(java.util.Properties p) {
    SetFromContext("_dummy_",p);
  }
  public void SetFromContext(String s,java.util.Properties p) {
    BlankStatusVariables();
    w_code = 0;
    w_fullname = "";
    w_name = "";
    w_accesstype_human = false;
    w_accesstype_service = false;
    w_accesstype_machine = false;
    w_modifyPassword = 0;
    w_pwd1 = "";
    w_calcomplex = 0;
    w_pwdratecause = "";
    w_pwd2 = "";
    w_pwdcomplexity_group = 0;
    w_pwdcomplexity = 0;
    w_pwdcomplexity_reqired = 0;
    w_forcepwdchange = false;
    w_enabled = "";
    w_language = "";
    w_language_name = "";
    w_decimalseparator = "";
    w_thousandseparator = "";
    w_datepattern = "";
    w_datetimepattern = "";
    w_pwddaysduration_group = 0;
    w_pwddaysduration = 0;
    w_pwdciclicity_groups = 0;
    w_pwdciclicity = 0;
    w_pwdcaptchalevel_group = 0;
    w_captchalevel = 0;
    w_datestart = CPLib.NullDate();
    w_datestop = CPLib.NullDate();
    w_failedlogins = 0;
    w_lastfailedlogin = CPLib.NullDateTime();
    w_lastsuccessfullogin = CPLib.NullDateTime();
    w_pwdcreate = CPLib.NullDateTime();
    w_pwddaysduration_applied = 0;
    w_pwdciclicity_applied = 0;
    w_pwdcaptchalevel_applied = 0;
    w_printserver = "";
    w_init_code = 0;
    w_createdwhen = CPLib.NullDateTime();
    w_pwd_modified = false;
    w_usesiarlicense = "";
    w_IAR_LICENSE_VALID = false;
    w_IAR_LICENSES = 0;
    w_IAR_USED = 0;
    w_IAR_AVAILABLE = 0;
    w_selected_group = 0;
    w_g_OTPisActive = m_Ctx.GetGlobalString("g_OTPisActive");
    w_otp = "";
    w_companies = "";
    w_UFENABLEAZI = "";
    w_pwd1_view = false;
    w_pwd2_view = false;
    m_cWv_spadministration_usersgroups = "";
    m_cWv_spadministration_ssomap_child = "";
    m_cWv_spadministration_historypwd = "";
    m_cWv_spadministration_usercompanies = "";
    CPExtenderLib.BlankExtendedFields(extendedFields);
    SaveDependsOn();
    if ( ! (CPLib.Empty(s))) {
      if (CPLib.IsNull(p)) {
        p = CPLib.GetProperties(s);
      }
      boolean l_bFromHyperlink = CPLib.ne("_not_found_",CPLib.GetProperty(p,"m_cParameterSequence","_not_found_"));
      w_code = CPLib.GetProperty(p,"code",w_code,0);
      w_fullname = CPLib.GetProperty(p,"fullname",w_fullname,0);
      w_name = CPLib.GetProperty(p,"name",w_name,0);
      w_accesstype_human = CPLib.GetProperty(p,"accesstype_human",w_accesstype_human,0);
      w_accesstype_service = CPLib.GetProperty(p,"accesstype_service",w_accesstype_service,0);
      w_accesstype_machine = CPLib.GetProperty(p,"accesstype_machine",w_accesstype_machine,0);
      w_pwdcomplexity = CPLib.GetProperty(p,"pwdcomplexity",w_pwdcomplexity,0);
      w_forcepwdchange = CPLib.GetProperty(p,"forcepwdchange",w_forcepwdchange,0);
      w_enabled = CPLib.GetProperty(p,"enabled",w_enabled,0);
      w_language = CPLib.GetProperty(p,"language",w_language,0);
      w_decimalseparator = CPLib.GetProperty(p,"decimalseparator",w_decimalseparator,0);
      w_thousandseparator = CPLib.GetProperty(p,"thousandseparator",w_thousandseparator,0);
      w_datepattern = CPLib.GetProperty(p,"datepattern",w_datepattern,0);
      w_datetimepattern = CPLib.GetProperty(p,"datetimepattern",w_datetimepattern,0);
      w_pwddaysduration = CPLib.GetProperty(p,"pwddaysduration",w_pwddaysduration,0);
      w_pwdciclicity = CPLib.GetProperty(p,"pwdciclicity",w_pwdciclicity,0);
      w_captchalevel = CPLib.GetProperty(p,"captchalevel",w_captchalevel,0);
      w_datestart = CPLib.GetProperty(p,"datestart",w_datestart,0);
      w_datestop = CPLib.GetProperty(p,"datestop",w_datestop,0);
      w_failedlogins = CPLib.GetProperty(p,"failedlogins",w_failedlogins,0);
      w_lastfailedlogin = CPLib.GetProperty(p,"lastfailedlogin",w_lastfailedlogin,0);
      w_lastsuccessfullogin = CPLib.GetProperty(p,"lastsuccessfullogin",w_lastsuccessfullogin,0);
      w_pwdcreate = CPLib.GetProperty(p,"pwdcreate",w_pwdcreate,0);
      w_printserver = CPLib.GetProperty(p,"printserver",w_printserver,0);
      w_createdwhen = CPLib.GetProperty(p,"createdwhen",w_createdwhen,0);
      w_usesiarlicense = CPLib.GetProperty(p,"usesiarlicense",w_usesiarlicense,0);
      w_companies = CPLib.GetProperty(p,"companies",w_companies,0);
      w_modifyPassword = CPLib.GetProperty(p,"modifyPassword",w_modifyPassword,0);
      w_pwd1 = CPLib.GetProperty(p,"pwd1",w_pwd1,0);
      w_calcomplex = CPLib.GetProperty(p,"calcomplex",w_calcomplex,0);
      w_pwdratecause = CPLib.GetProperty(p,"pwdratecause",w_pwdratecause,0);
      w_pwd2 = CPLib.GetProperty(p,"pwd2",w_pwd2,0);
      w_pwdcomplexity_group = CPLib.GetProperty(p,"pwdcomplexity_group",w_pwdcomplexity_group,0);
      w_pwdcomplexity_reqired = CPLib.GetProperty(p,"pwdcomplexity_reqired",w_pwdcomplexity_reqired,0);
      w_language_name = CPLib.GetProperty(p,"language_name",w_language_name,0);
      w_pwddaysduration_group = CPLib.GetProperty(p,"pwddaysduration_group",w_pwddaysduration_group,0);
      w_pwdciclicity_groups = CPLib.GetProperty(p,"pwdciclicity_groups",w_pwdciclicity_groups,0);
      w_pwdcaptchalevel_group = CPLib.GetProperty(p,"pwdcaptchalevel_group",w_pwdcaptchalevel_group,0);
      w_pwddaysduration_applied = CPLib.GetProperty(p,"pwddaysduration_applied",w_pwddaysduration_applied,0);
      w_pwdciclicity_applied = CPLib.GetProperty(p,"pwdciclicity_applied",w_pwdciclicity_applied,0);
      w_pwdcaptchalevel_applied = CPLib.GetProperty(p,"pwdcaptchalevel_applied",w_pwdcaptchalevel_applied,0);
      w_init_code = CPLib.GetProperty(p,"init_code",w_init_code,0);
      w_pwd_modified = CPLib.GetProperty(p,"pwd_modified",w_pwd_modified,0);
      w_IAR_LICENSE_VALID = CPLib.GetProperty(p,"IAR_LICENSE_VALID",w_IAR_LICENSE_VALID,0);
      w_IAR_LICENSES = CPLib.GetProperty(p,"IAR_LICENSES",w_IAR_LICENSES,0);
      w_IAR_USED = CPLib.GetProperty(p,"IAR_USED",w_IAR_USED,0);
      w_IAR_AVAILABLE = CPLib.GetProperty(p,"IAR_AVAILABLE",w_IAR_AVAILABLE,0);
      w_selected_group = CPLib.GetProperty(p,"selected_group",w_selected_group,0);
      w_g_OTPisActive = CPLib.GetProperty(p,"g_OTPisActive",w_g_OTPisActive,0);
      w_otp = CPLib.GetProperty(p,"otp",w_otp,0);
      w_UFENABLEAZI = CPLib.GetProperty(p,"UFENABLEAZI",w_UFENABLEAZI,0);
      w_pwd1_view = CPLib.GetProperty(p,"pwd1_view",w_pwd1_view,0);
      w_pwd2_view = CPLib.GetProperty(p,"pwd2_view",w_pwd2_view,0);
      m_cWv_spadministration_usersgroups = CPLib.GetProperty(p,"m_cWv_spadministration_usersgroups",m_cWv_spadministration_usersgroups,0);
      m_cWv_spadministration_ssomap_child = CPLib.GetProperty(p,"m_cWv_spadministration_ssomap_child",m_cWv_spadministration_ssomap_child,0);
      m_cWv_spadministration_historypwd = CPLib.GetProperty(p,"m_cWv_spadministration_historypwd",m_cWv_spadministration_historypwd,0);
      m_cWv_spadministration_usercompanies = CPLib.GetProperty(p,"m_cWv_spadministration_usercompanies",m_cWv_spadministration_usercompanies,0);
      CPLib.SetFromContextMNTs(p,m_MNTs);
      SPExtenderLib.SetExtendedFromContext(p,extendedFields);
      m_bLoaded = CPLib.GetProperty(p,"m_bLoaded",false,0);
      m_bUpdated = CPLib.GetProperty(p,"m_bUpdated",false,0);
      m_cOldCPCCCHK = CPLib.GetProperty(p,"m_cOldCPCCCHK","",0);
      m_cPreviousState = CPLib.GetProperty(p,"m_cPrvsStt","",0);
      m_cPassword = CPLib.GetProperty(p,"m_cPwd","",0);
      m_cOTP = CPLib.GetProperty(p,"m_cOTP","",0);
      m_lCtxLoaded = true;
      if ( ! (l_bFromHyperlink)) {
        SaveDependsOn();
      }
    }
  }
  public void SetUpdated() {
    m_bUpdated = true;
  }
  public String EntityStatus() {
    return (m_bLoaded?"E":"N");
  }
  public String LastErrorMessage() {
    return m_cLastMsgError;
  }
  static void GetLinkDef0(Map<String,List<Map<String,String[]>>> tables) {
    java.util.regex.Pattern zeroSplit;
    zeroSplit = java.util.regex.Pattern.compile("\\x00");
    Map<String,String[]> map;
    List<Map<String,String[]>> items;
    map = new HashMap<String,String[]>();
    items = tables.get("cpusrgrp");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("cpusrgrp",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"usercode"});
    map.put("rd_var",new String[]{"w_code"});
    map.put("wr_var",new String[]{"w_code"});
    map.put("wr_field",new String[]{"usercode"});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("N",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("4",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",new String[]{""});
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{""});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("cpusrgrp\u0000false\u0000false\u00001\u00000\u0000spadministration_usersgroups\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("cpssomap");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("cpssomap",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"userid"});
    map.put("rd_var",new String[]{"w_code"});
    map.put("wr_var",new String[]{"w_code"});
    map.put("wr_field",new String[]{"userid"});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",new String[]{});
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",new String[]{});
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",new String[]{});
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",new String[]{});
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",new String[]{});
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",new String[]{});
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",new String[]{});
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("cpssomap\u0000false\u0000false\u00001\u00000\u0000spadministration_ssomap_child\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("cphistorypwd");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("cphistorypwd",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"code"});
    map.put("rd_var",new String[]{"w_code"});
    map.put("wr_var",new String[]{"w_code"});
    map.put("wr_field",new String[]{"code"});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",new String[]{});
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",new String[]{});
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",new String[]{});
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",new String[]{});
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",new String[]{});
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",new String[]{});
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",new String[]{});
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("cphistorypwd\u0000false\u0000false\u00001\u00000\u0000spadministration_historypwd\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("cpusrazi");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("cpusrazi",items);
    }
    items.add(map);
    map.put("link_PC",new String[]{});
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"usercode"});
    map.put("rd_var",new String[]{"w_code"});
    map.put("wr_var",new String[]{"w_code"});
    map.put("wr_field",new String[]{"usercode"});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",new String[]{});
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",new String[]{});
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",new String[]{});
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",new String[]{});
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",new String[]{});
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",new String[]{});
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",new String[]{});
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",new String[]{});
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("cpusrazi\u0000false\u0000false\u00001\u00000\u0000spadministration_usercompanies\u0000false\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("cpusers");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("cpusers",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"code","cpotp"});
    map.put("rd_var",new String[]{"w_code","w_otp"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("N\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("9\u0000100",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("ADMIN_CODE\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("key1\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("cpusers\u0000false\u0000true\u00001\u00000\u0000\u0000true\u0000false\u0000\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
    map = new HashMap<String,String[]>();
    items = tables.get("cplangs");
    if (CPLib.IsNull(items)) {
      items = new ArrayList<Map<String,String[]>>();
      tables.put("cplangs",items);
    }
    items.add(map);
    map.put("rd_kvar",new String[]{});
    map.put("rd_kfield",new String[]{});
    map.put("rd_field",new String[]{"code","name"});
    map.put("rd_var",new String[]{"w_language","w_language_name"});
    map.put("wr_var",new String[]{});
    map.put("wr_field",new String[]{});
    map.put("wr_op",new String[]{});
    map.put("rd_var.obj_type",zeroSplit.split("C\u0000C",-1));
    map.put("rd_kvar.obj_type",new String[]{});
    map.put("rd_var.len",zeroSplit.split("3\u000025",-1));
    map.put("rd_kvar.len",new String[]{});
    map.put("rd_var.dec",zeroSplit.split("0\u00000",-1));
    map.put("rd_kvar.dec",new String[]{});
    map.put("rd_var.comment",zeroSplit.split("ADMIN_LANGUAGE\u0000",-1));
    map.put("rd_kvar.comment",new String[]{});
    map.put("rd_var.key_num",zeroSplit.split("nokey\u0000nokey",-1));
    map.put("rd_kvar.key_num",new String[]{});
    map.put("rd_var.repeated",zeroSplit.split("FALSE\u0000FALSE",-1));
    map.put("rd_kvar.repeated",new String[]{});
    map.put("rd_var.frm_obbl",zeroSplit.split("\u0000",-1));
    map.put("rd_kvar.frm_obbl",new String[]{});
    map.put("rd_var.obj",zeroSplit.split("campo\u0000variabile",-1));
    map.put("rd_kvar.obj",new String[]{});
    map.put("property.value",zeroSplit.split("cplangs\u0000false\u0000false\u00001\u00000\u0000spadministration_langs\u0000false\u0000false\u0000ADMIN_SELECT_LANGUAGE\u0000\u0000\u0000false",-1));
    map.put("property.name",zeroSplit.split("arch\u0000fillemptykey\u0000looselylinked\u0000src_key\u0000hst_link_mode\u0000prg_zoom\u0000looselylinked\u0000sendkeystozoomonzoom\u0000zoom_title\u0000prg_link_search\u0000prg_link_defaults\u0000",-1));
  }
  public static Map<String,List<Map<String,String[]>>> GetLinkDef() {
    java.util.regex.Pattern zeroSplit;
    zeroSplit = java.util.regex.Pattern.compile("\\x00");
    Map<String,List<Map<String,String[]>>> tables;
    tables = new HashMap<String,List<Map<String,String[]>>>();
    Map<String,String[]> map;
    List<Map<String,String[]>> items;
    GetLinkDef0(tables);
    for(String child : CPLib.LoadableMNTs("spadministration_users",false)) {
      map = new HashMap<String,String[]>();
      items = tables.get(com.zucchetti.sitepainter.Library.getEntityTables(child)[0]);
      if (CPLib.IsNull(items)) {
        items = new ArrayList<Map<String,String[]>>();
        tables.put(com.zucchetti.sitepainter.Library.getEntityTables(child)[0],items);
      }
      map.put("link_PC",new String[]{});
      map.put("rd_kvar",new String[]{});
      map.put("rd_kfield",new String[]{});
      map.put("rd_field",new String[]{});
      map.put("rd_var",new String[]{});
      String[][] definitions = CPMNTChild.GetM_Fkd("spadministration_users",child);
      // Informazione usata per risolvere la sintassi BO->tabella nelle VQR
      map.put("rd_var",definitions[0]);
      map.put("rd_field",definitions[1]);
      // Definizione delle coppie padre/figlio
      map.put("wr_var",definitions[0]);
      map.put("wr_field",definitions[1]);
      map.put("wr_op",new String[]{});
      map.put("rd_var.obj_type",new String[]{});
      map.put("rd_var.len",new String[]{});
      map.put("rd_var.dec",new String[]{});
      map.put("rd_var.comment",new String[]{});
      map.put("property.name",new String[]{"arch","foundling","","","","prg_zoom"});
      map.put("property.value",new String[]{com.zucchetti.sitepainter.Library.getEntityTables(child)[0],"true","","","",child});
      items.add(map);
    }
    return tables;
  }
  public void Initialize() {
    // Inizializzazione delle variabili di work
    Blank();
    // Inizializzazione delle variabili di progressivo e legate alle operazioni a saldo
    BlankAutonumberAndTransactionVars();
    spadministration_usersgroups = new spadministration_usersgroupsBO(m_Ctx);
    spadministration_ssomap_child = new spadministration_ssomap_childBO(m_Ctx);
    spadministration_historypwd = new spadministration_historypwdBO(m_Ctx);
    spadministration_usercompanies = new spadministration_usercompaniesBO(m_Ctx);
    m_MNTs = CPLib.MNTChilds("spadministration_users",m_Ctx);
    m_cPreviousState = GetCurrentState();
  }
  public boolean Check() {
    boolean l_bResult;
    l_bResult = true;
    boolean l_bNoCheck;
    l_bNoCheck = true;
    boolean l_bNoObligatory;
    l_bNoObligatory = true;
    ResetErrorMessage();
    if (CPLib.Empty(w_name)) {
      l_bNoObligatory =  ! (CPLib.Empty(w_name));
      String obblMsgError = m_Ctx.Translate("ADMIN_NAME")+" : ";
      m_cLastMsgError = obblMsgError+m_Ctx.Translate("MSG_OBBLI_FIELD");
      l_bResult = false;
      w_name = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "name";
      }
    } else if ( ! (CPLib.ge(w_pwdcomplexity,0) && CPLib.le(w_pwdcomplexity,UserAdmin.Make(m_Ctx).GetPasswordRatingMaxReachable()))) {
      m_cLastMsgError = m_Ctx.Translate("ADMIN_MSG_ERROR_RANGE");
      l_bNoCheck = false;
      l_bResult = false;
      w_pwdcomplexity = 0;
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "pwdcomplexity";
      }
    } else if ( ! (CPLib.Empty(w_datepattern) || (CPLib.gt(CPLib.At("YYYY",w_datepattern),0) && CPLib.gt(CPLib.At("MM",w_datepattern),0) && CPLib.gt(CPLib.At("DD",w_datepattern),0)))) {
      m_cLastMsgError = m_Ctx.Translate("ADMIN_DATE_WRONG");
      l_bNoCheck = false;
      l_bResult = false;
      w_datepattern = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "datepattern";
      }
    } else if ( ! (CPLib.Empty(w_datetimepattern) || (CPLib.gt(CPLib.At("YYYY",w_datetimepattern),0) && CPLib.gt(CPLib.At("MM",w_datetimepattern),0) && CPLib.gt(CPLib.At("DD",w_datetimepattern),0) && CPLib.gt(CPLib.At("hh",w_datetimepattern),0) && CPLib.gt(CPLib.At("mm",w_datetimepattern),0) && CPLib.gt(CPLib.At("ss",w_datetimepattern),0)))) {
      m_cLastMsgError = m_Ctx.Translate("ADMIN_DATETIME_WRONG");
      l_bNoCheck = false;
      l_bResult = false;
      w_datetimepattern = "";
      if (CPLib.eq(m_cLastWorkVarError,"")) {
        m_cLastWorkVarError = "datetimepattern";
      }
    } else if ( ! (Check_DPHWQTPSFC(true))) {
      l_bResult = false;
    } else if ( ! (Check_BLWKYYPKAQ(true))) {
      l_bResult = false;
    }
    if (l_bResult && (( ! (spadministration_usersgroups.m_bLoaded) && CPLib.IsLoaded(m_cWv_spadministration_usersgroups)) || ( ! (spadministration_usersgroups.m_bUpdated) && CPLib.IsUpdated(m_cWv_spadministration_usersgroups)))) {
      spadministration_usersgroups.SetFromContext(m_cWv_spadministration_usersgroups);
      m_cWv_spadministration_usersgroups = "_not_empty_";
    }
    if (l_bResult && (spadministration_usersgroups.m_bLoaded || spadministration_usersgroups.m_bUpdated)) {
      l_bResult = l_bResult && spadministration_usersgroups.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = spadministration_usersgroups.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (spadministration_ssomap_child.m_bLoaded) && CPLib.IsLoaded(m_cWv_spadministration_ssomap_child)) || ( ! (spadministration_ssomap_child.m_bUpdated) && CPLib.IsUpdated(m_cWv_spadministration_ssomap_child)))) {
      spadministration_ssomap_child.SetFromContext(m_cWv_spadministration_ssomap_child);
      m_cWv_spadministration_ssomap_child = "_not_empty_";
    }
    if (l_bResult && (spadministration_ssomap_child.m_bLoaded || spadministration_ssomap_child.m_bUpdated)) {
      l_bResult = l_bResult && spadministration_ssomap_child.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = spadministration_ssomap_child.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (spadministration_historypwd.m_bLoaded) && CPLib.IsLoaded(m_cWv_spadministration_historypwd)) || ( ! (spadministration_historypwd.m_bUpdated) && CPLib.IsUpdated(m_cWv_spadministration_historypwd)))) {
      spadministration_historypwd.SetFromContext(m_cWv_spadministration_historypwd);
      m_cWv_spadministration_historypwd = "_not_empty_";
    }
    if (l_bResult && (spadministration_historypwd.m_bLoaded || spadministration_historypwd.m_bUpdated)) {
      l_bResult = l_bResult && spadministration_historypwd.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = spadministration_historypwd.m_cLastMsgError;
      }
    }
    if (l_bResult && (( ! (spadministration_usercompanies.m_bLoaded) && CPLib.IsLoaded(m_cWv_spadministration_usercompanies)) || ( ! (spadministration_usercompanies.m_bUpdated) && CPLib.IsUpdated(m_cWv_spadministration_usercompanies)))) {
      spadministration_usercompanies.SetFromContext(m_cWv_spadministration_usercompanies);
      m_cWv_spadministration_usercompanies = "_not_empty_";
    }
    if (l_bResult && (spadministration_usercompanies.m_bLoaded || spadministration_usercompanies.m_bUpdated)) {
      l_bResult = l_bResult && spadministration_usercompanies.Check();
      l_bNoCheck = l_bResult;
      if ( ! (l_bNoCheck)) {
        m_cLastMsgError = spadministration_usercompanies.m_cLastMsgError;
      }
    }
    // * --- Area Manuale = BO - Check Form
    // * --- Fine Area Manuale
    if ( ! (l_bNoObligatory)) {
      m_nLastError = 1;
    } else if ( ! (l_bNoCheck)) {
      m_nLastError = 2;
    }
    return l_bResult;
  }
  void ResetErrorMessage() {
    m_nLastError = 0;
    m_cLastMsgError = "";
    m_cLastWorkVarError = "";
  }
  public String GetCurrentState() {
    String l_bResult;
    l_bResult = CPSecurity.UNKNOWN_STATE;
    return l_bResult;
  }
  /** @deprecated Will be removed in a future version **/
  @Deprecated
  public String GetStateSecurityKey(String p_cState) {
    return GetStateSecurityKeyRoles(p_cState)[0];
  }
  public String[] GetStateSecurityKeyRoles(String p_cState) {
    String[] l_Keys = {};
    if (CPLib.eq(p_cState,CPSecurity.UNKNOWN_STATE)) {
      l_Keys = new String[]{"spadministration_users"};
    }
    if (CPLib.eq(l_Keys.length,0)) {
      l_Keys = new String[]{"spadministration_users\\"+p_cState};
    }
    return l_Keys;
  }
  public boolean CanView() {
    boolean l_bResult;
    l_bResult = true;
    ResetErrorMessage();
    l_bResult = l_bResult && BRCanView();
    if ( ! (l_bResult)) {
      String o_cLastMsgError = m_cLastMsgError;
      Blank();
      // Evita che un errore segnalato alla Blank, ad esempio link fallito, sovrascriva l'errore di accesso bloccato
      m_cLastMsgError = o_cLastMsgError;
    }
    return l_bResult;
  }
  public boolean CanEdit() {
    return CanEdit(GetCurrentState());
  }
  public boolean CanEdit(String p_cState) {
    boolean l_bResult = true;
    ResetErrorMessage();
    l_bResult = l_bResult && BRCanEdit();
    return l_bResult;
  }
  public boolean CanDelete() {
    boolean l_bResult;
    l_bResult = true;
    ResetErrorMessage();
    l_bResult = l_bResult && BRCanDelete();
    return l_bResult;
  }
  public boolean CanAdd() {
    return CanAdd(GetCurrentState());
  }
  public boolean CanAdd(String p_cState) {
    boolean l_bResult = true;
    ResetErrorMessage();
    l_bResult = l_bResult && BRCanAdd();
    return l_bResult;
  }
  void BlankAutonumberAndTransactionVars() {
    // Inizializzazione dei progressivi
    // Inizializzazione delle variabili per DependsOn
    o_code = 0;
    o_modifyPassword = 0;
    o_pwd1 = "";
    o_pwd2 = "";
    o_pwddaysduration_group = 0;
    o_pwddaysduration = 0;
    o_pwdciclicity_groups = 0;
    o_pwdciclicity = 0;
    o_pwdcaptchalevel_group = 0;
    o_captchalevel = 0;
    o_selected_group = 0;
    o_companies = "";
    o_UFENABLEAZI = "";
    // Inizializzazione delle variabili per la gestione dello storno delle operazioni di saldo
  }
  public String GetContext() {
    return GetContext(true);
  }
  public String GetContext(boolean p_bGetChildren) {
    Properties p;
    p = new Properties();
    GetContext(p_bGetChildren,p);
    return CPLib.ToProperties(p);
  }
  public void GetContext(java.util.Properties p_oProperties) {
    GetContext(true,p_oProperties);
  }
  public void GetContext(boolean p_bGetChildren,java.util.Properties p) {
    CPLib.PutProperty(p,"code",w_code,0);
    CPLib.PutProperty(p,"fullname",w_fullname,0);
    CPLib.PutProperty(p,"name",w_name,0);
    CPLib.PutProperty(p,"accesstype_human",w_accesstype_human,0);
    CPLib.PutProperty(p,"accesstype_service",w_accesstype_service,0);
    CPLib.PutProperty(p,"accesstype_machine",w_accesstype_machine,0);
    CPLib.PutProperty(p,"pwdcomplexity",w_pwdcomplexity,0);
    CPLib.PutProperty(p,"forcepwdchange",w_forcepwdchange,0);
    CPLib.PutProperty(p,"enabled",w_enabled,0);
    CPLib.PutProperty(p,"language",w_language,0);
    CPLib.PutProperty(p,"decimalseparator",w_decimalseparator,0);
    CPLib.PutProperty(p,"thousandseparator",w_thousandseparator,0);
    CPLib.PutProperty(p,"datepattern",w_datepattern,0);
    CPLib.PutProperty(p,"datetimepattern",w_datetimepattern,0);
    CPLib.PutProperty(p,"pwddaysduration",w_pwddaysduration,0);
    CPLib.PutProperty(p,"pwdciclicity",w_pwdciclicity,0);
    CPLib.PutProperty(p,"captchalevel",w_captchalevel,0);
    CPLib.PutProperty(p,"datestart",w_datestart,0);
    CPLib.PutProperty(p,"datestop",w_datestop,0);
    CPLib.PutProperty(p,"failedlogins",w_failedlogins,0);
    CPLib.PutProperty(p,"lastfailedlogin",w_lastfailedlogin,0);
    CPLib.PutProperty(p,"lastsuccessfullogin",w_lastsuccessfullogin,0);
    CPLib.PutProperty(p,"pwdcreate",w_pwdcreate,0);
    CPLib.PutProperty(p,"printserver",w_printserver,0);
    CPLib.PutProperty(p,"createdwhen",w_createdwhen,0);
    CPLib.PutProperty(p,"usesiarlicense",w_usesiarlicense,0);
    CPLib.PutProperty(p,"companies",w_companies,0);
    CPLib.PutProperty(p,"modifyPassword",w_modifyPassword,0);
    CPLib.PutProperty(p,"pwd1",w_pwd1,0);
    CPLib.PutProperty(p,"calcomplex",w_calcomplex,0);
    CPLib.PutProperty(p,"pwdratecause",w_pwdratecause,0);
    CPLib.PutProperty(p,"pwd2",w_pwd2,0);
    CPLib.PutProperty(p,"pwdcomplexity_group",w_pwdcomplexity_group,0);
    CPLib.PutProperty(p,"pwdcomplexity_reqired",w_pwdcomplexity_reqired,0);
    CPLib.PutProperty(p,"language_name",w_language_name,0);
    CPLib.PutProperty(p,"pwddaysduration_group",w_pwddaysduration_group,0);
    CPLib.PutProperty(p,"pwdciclicity_groups",w_pwdciclicity_groups,0);
    CPLib.PutProperty(p,"pwdcaptchalevel_group",w_pwdcaptchalevel_group,0);
    CPLib.PutProperty(p,"pwddaysduration_applied",w_pwddaysduration_applied,0);
    CPLib.PutProperty(p,"pwdciclicity_applied",w_pwdciclicity_applied,0);
    CPLib.PutProperty(p,"pwdcaptchalevel_applied",w_pwdcaptchalevel_applied,0);
    CPLib.PutProperty(p,"init_code",w_init_code,0);
    CPLib.PutProperty(p,"pwd_modified",w_pwd_modified,0);
    CPLib.PutProperty(p,"IAR_LICENSE_VALID",w_IAR_LICENSE_VALID,0);
    CPLib.PutProperty(p,"IAR_LICENSES",w_IAR_LICENSES,0);
    CPLib.PutProperty(p,"IAR_USED",w_IAR_USED,0);
    CPLib.PutProperty(p,"IAR_AVAILABLE",w_IAR_AVAILABLE,0);
    CPLib.PutProperty(p,"selected_group",w_selected_group,0);
    CPLib.PutProperty(p,"g_OTPisActive",w_g_OTPisActive,0);
    CPLib.PutProperty(p,"otp",w_otp,0);
    CPLib.PutProperty(p,"UFENABLEAZI",w_UFENABLEAZI,0);
    CPLib.PutProperty(p,"pwd1_view",w_pwd1_view,0);
    CPLib.PutProperty(p,"pwd2_view",w_pwd2_view,0);
    if (p_bGetChildren) {
      if (spadministration_usersgroups.IsUpdated()) {
        m_cWv_spadministration_usersgroups = spadministration_usersgroups.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_spadministration_usersgroups",m_cWv_spadministration_usersgroups,0);
    }
    if (p_bGetChildren) {
      if (spadministration_ssomap_child.IsUpdated()) {
        m_cWv_spadministration_ssomap_child = spadministration_ssomap_child.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_spadministration_ssomap_child",m_cWv_spadministration_ssomap_child,0);
    }
    if (p_bGetChildren) {
      if (spadministration_historypwd.IsUpdated()) {
        m_cWv_spadministration_historypwd = spadministration_historypwd.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_spadministration_historypwd",m_cWv_spadministration_historypwd,0);
    }
    if (p_bGetChildren) {
      if (spadministration_usercompanies.IsUpdated()) {
        m_cWv_spadministration_usercompanies = spadministration_usercompanies.GetContext();
      }
      CPLib.PutProperty(p,"m_cWv_spadministration_usercompanies",m_cWv_spadministration_usercompanies,0);
    }
    if (p_bGetChildren) {
      CPLib.PutProperty(p,m_MNTs);
    }
    SPExtenderLib.PutExtendedProperies(p,extendedFields);
    CPLib.PutProperty(p,"m_bLoaded",m_bLoaded);
    CPLib.PutProperty(p,"m_bUpdated",m_bUpdated);
    CPLib.PutProperty(p,"m_cOldCPCCCHK",m_cOldCPCCCHK);
    CPLib.PutProperty(p,"m_cPrvsStt",m_cPreviousState);
  }
  public String i_PrimaryKey() {
    return PrimaryKey(this);
  }
  public static String PrimaryKey(Caller p_Caller) {
    return "cpusers"+"\\"+CPLib.ToCPStr(p_Caller.GetNumber("code","N",9,0));
  }
  public List<List<String>> AutonumDefinition() {
    return StaticAutonumDefinition();
  }
  public static List<List<String>> StaticAutonumDefinition() {
    List<List<String>> autonums;
    autonums = new ArrayList<List<String>>();
    List<String> oneAutoNum;
    return autonums;
  }
  public boolean ChildExists_spadministration_usersgroups() {
    if (spadministration_usersgroups.IsUpdated() || (CPLib.IsUpdated(m_cWv_spadministration_usersgroups) || CPLib.IsLoaded(m_cWv_spadministration_usersgroups))) {
      return true;
    } else if (m_bLoaded &&  ! (spadministration_usersgroups.m_bLoaded)) {
      spadministration_usersgroups.Blank();
      spadministration_usersgroups.w_usercode = w_code;
      spadministration_usersgroups.Load();
    }
    return spadministration_usersgroups.m_bLoaded;
  }
  public void CtxLoad_spadministration_usersgroups() {
    if ( ! (spadministration_usersgroups.m_lCtxLoaded)) {
      spadministration_usersgroups.Blank();
    }
    spadministration_usersgroups.m_lCtxLoaded = true;
    if ( ! (spadministration_usersgroups.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_spadministration_usersgroups) || CPLib.IsLoaded(m_cWv_spadministration_usersgroups)) {
        spadministration_usersgroups.SetFromContext(m_cWv_spadministration_usersgroups);
        m_cWv_spadministration_usersgroups = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (spadministration_usersgroups.m_bLoaded)) {
          spadministration_usersgroups.Blank();
          spadministration_usersgroups.w_usercode = w_code;
          spadministration_usersgroups.Load();
          if ( ! (spadministration_usersgroups.m_bLoaded)) {
            spadministration_usersgroups.Initialize();
            spadministration_usersgroups.SetUpdated();
          }
          CopyWorkVar(this,spadministration_usersgroups,new String[]{"selected_group"},new String[]{"selected_group"},false);
        } else if ( ! (m_bLoaded)) {
          CopyWorkVar(this,spadministration_usersgroups,new String[]{"selected_group"},new String[]{"selected_group"},true);
        }
      }
    }
  }
  public boolean ChildExists_spadministration_ssomap_child() {
    if (spadministration_ssomap_child.IsUpdated() || (CPLib.IsUpdated(m_cWv_spadministration_ssomap_child) || CPLib.IsLoaded(m_cWv_spadministration_ssomap_child))) {
      return true;
    } else if (m_bLoaded &&  ! (spadministration_ssomap_child.m_bLoaded)) {
      spadministration_ssomap_child.Blank();
      spadministration_ssomap_child.w_userid = w_code;
      spadministration_ssomap_child.Load();
    }
    return spadministration_ssomap_child.m_bLoaded;
  }
  public void CtxLoad_spadministration_ssomap_child() {
    if ( ! (spadministration_ssomap_child.m_lCtxLoaded)) {
      spadministration_ssomap_child.Blank();
    }
    spadministration_ssomap_child.m_lCtxLoaded = true;
    if ( ! (spadministration_ssomap_child.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_spadministration_ssomap_child) || CPLib.IsLoaded(m_cWv_spadministration_ssomap_child)) {
        spadministration_ssomap_child.SetFromContext(m_cWv_spadministration_ssomap_child);
        m_cWv_spadministration_ssomap_child = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (spadministration_ssomap_child.m_bLoaded)) {
          spadministration_ssomap_child.Blank();
          spadministration_ssomap_child.w_userid = w_code;
          spadministration_ssomap_child.Load();
          if ( ! (spadministration_ssomap_child.m_bLoaded)) {
            spadministration_ssomap_child.Initialize();
            spadministration_ssomap_child.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_spadministration_historypwd() {
    if (spadministration_historypwd.IsUpdated() || (CPLib.IsUpdated(m_cWv_spadministration_historypwd) || CPLib.IsLoaded(m_cWv_spadministration_historypwd))) {
      return true;
    } else if (m_bLoaded &&  ! (spadministration_historypwd.m_bLoaded)) {
      spadministration_historypwd.Blank();
      spadministration_historypwd.w_code = w_code;
      spadministration_historypwd.Load();
    }
    return spadministration_historypwd.m_bLoaded;
  }
  public void CtxLoad_spadministration_historypwd() {
    if ( ! (spadministration_historypwd.m_lCtxLoaded)) {
      spadministration_historypwd.Blank();
    }
    spadministration_historypwd.m_lCtxLoaded = true;
    if ( ! (spadministration_historypwd.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_spadministration_historypwd) || CPLib.IsLoaded(m_cWv_spadministration_historypwd)) {
        spadministration_historypwd.SetFromContext(m_cWv_spadministration_historypwd);
        m_cWv_spadministration_historypwd = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (spadministration_historypwd.m_bLoaded)) {
          spadministration_historypwd.Blank();
          spadministration_historypwd.w_code = w_code;
          spadministration_historypwd.Load();
          if ( ! (spadministration_historypwd.m_bLoaded)) {
            spadministration_historypwd.Initialize();
            spadministration_historypwd.SetUpdated();
          }
        }
      }
    }
  }
  public boolean ChildExists_spadministration_usercompanies() {
    if (spadministration_usercompanies.IsUpdated() || (CPLib.IsUpdated(m_cWv_spadministration_usercompanies) || CPLib.IsLoaded(m_cWv_spadministration_usercompanies))) {
      return true;
    } else if (m_bLoaded &&  ! (spadministration_usercompanies.m_bLoaded)) {
      spadministration_usercompanies.Blank();
      spadministration_usercompanies.w_usercode = w_code;
      spadministration_usercompanies.Load();
    }
    return spadministration_usercompanies.m_bLoaded;
  }
  public void CtxLoad_spadministration_usercompanies() {
    if ( ! (spadministration_usercompanies.m_lCtxLoaded)) {
      spadministration_usercompanies.Blank();
    }
    spadministration_usercompanies.m_lCtxLoaded = true;
    if ( ! (spadministration_usercompanies.IsUpdated())) {
      if (CPLib.IsUpdated(m_cWv_spadministration_usercompanies) || CPLib.IsLoaded(m_cWv_spadministration_usercompanies)) {
        spadministration_usercompanies.SetFromContext(m_cWv_spadministration_usercompanies);
        m_cWv_spadministration_usercompanies = "_not_empty_";
      } else {
        if (m_bLoaded &&  ! (spadministration_usercompanies.m_bLoaded)) {
          spadministration_usercompanies.Blank();
          spadministration_usercompanies.w_usercode = w_code;
          spadministration_usercompanies.Load();
          if ( ! (spadministration_usercompanies.m_bLoaded)) {
            spadministration_usercompanies.Initialize();
            spadministration_usercompanies.SetUpdated();
          }
        }
      }
    }
  }
  CallerBRImpl GetChild(String p_cName) {
    if (CPLib.eq(p_cName,"spadministration_usersgroups")) {
      CtxLoad_spadministration_usersgroups();
      return spadministration_usersgroups;
    }
    if (CPLib.eq(p_cName,"spadministration_ssomap_child")) {
      CtxLoad_spadministration_ssomap_child();
      return spadministration_ssomap_child;
    }
    if (CPLib.eq(p_cName,"spadministration_historypwd")) {
      CtxLoad_spadministration_historypwd();
      return spadministration_historypwd;
    }
    if (CPLib.eq(p_cName,"spadministration_usercompanies")) {
      CtxLoad_spadministration_usercompanies();
      return spadministration_usercompanies;
    }
    return GetMNTChild(false,m_MNTs,p_cName);
  }
  // * --- Area Manuale = BL - Methods
  // * --- Fine Area Manuale
}
