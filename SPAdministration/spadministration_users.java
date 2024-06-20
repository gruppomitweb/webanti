import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class spadministration_users extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*76d51519*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "cpusers";
    }
    public double w_code;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_code,context,"cpusers","code","N",9,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
      }
    }
    void FillParameters() {
      m_Parameters = source.GetParametersProperties();
      m_cWv = (CPLib.gt(m_Parameters.size(),0)?"_not_empty_":"");
    }
    public void MergeCallerVars(SPParameterSource source) {
    }
    public void WriteSenderFormPKVars() {
      ServletStatus status = this;
      if (CPLib.eq(m_cClientMode,"query") || CPLib.eq(m_cClientMode,"view")) {
        status.out.println(
         "<input name='code' type='hidden' value="+SPLib.ToHTMLValue(w_code,"N",9,0)+">" +
        "");
      }
    }
  }
  public void doProcess(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    // Inizializzazione delle variabili della classe globale di stato
    ServletStatus status = new ServletStatus();
    status.containing = this;
    SPParameterSource source = SPLib.GetSource(request);
    // Controlla lo stato di login e la sicurezza associata alla procedura
    if ( ! (EnterServlet(status,source,request,response))) {
      return;
    }
    boolean requiredPwd;
    requiredPwd = (CPLib.eq(status.m_cAction,"delete")?false:false);
    boolean requiredOTP;
    requiredOTP = (CPLib.eq(status.m_cAction,"delete")?false:false);
    int accessType;
    accessType = (requiredOTP?3:((requiredPwd?2:SPLib.AccessType((CPLib.eq(status.m_cAction,"delete")?"delete":"access"),entityGlobals.name))));
    if ( ! (CheckAccessSecurity(status,(CPLib.eq(accessType,3)?"OTP":(CPLib.eq(accessType,2)?"password":""))))) {
      RequestPwdOrOTP(status,(CPLib.eq(accessType,3)?"OTP":"password"));
      return;
    }
    // Ora esegue l' operazione richiesta da m_cAction
    spadministration_usersBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_cpusers;
    if (CPLib.eq(status.m_cAction,"start")) {
      status.m_cMode = "";
      status.m_cClientMode = "query";
      BO.Blank();
    } else if (CPLib.eq(status.m_cAction,"query")) {
      Query(status,BO);
      LoadCurrentRecord(status,BO);
    } else if (CPLib.eq(status.m_cAction,"view")) {
      View(status,BO);
    } else if (CPLib.eq(status.m_cAction,"first")) {
      MoveTo(status,1);
      LoadCurrentRecord(status,BO);
    } else if (CPLib.eq(status.m_cAction,"previous")) {
      MoveTo(status,status.m_nRecPos-1);
      LoadCurrentRecord(status,BO);
    } else if (CPLib.eq(status.m_cAction,"next")) {
      MoveTo(status,status.m_nRecPos+1);
      LoadCurrentRecord(status,BO);
    } else if (CPLib.eq(status.m_cAction,"last")) {
      MoveTo(status,status.m_nLastRec);
      LoadCurrentRecord(status,BO);
    } else if (CPLib.eq(status.m_cAction,"moveto")) {
      LoadCurrentRecord(status,BO);
    } else if (CPLib.eq(status.m_cAction,"edit")) {
      Edit(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"editload")) {
      EditLoad(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"write")) {
      Write(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"writeload")) {
      Write(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"new")) {
      New(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"save")) {
      Save(status,BO);
    } else if (CPLib.eq(status.m_cAction,"discard")) {
      Discard(status,BO);
    } else if (CPLib.eq(status.m_cAction,"delete")) {
      Delete(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"deletemessage")) {
      DeleteMessage(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"painter")) {
      Painter(status);
    } else if (CPLib.eq(status.m_cAction,"autozoom")) {
      OpenZoom(status,source);
    } else if (CPLib.eq(status.m_cAction,"zoom")) {
      OpenPSZoom(status,source);
    }
    // * --- Area Manuale = Do Action
    // * --- Fine Area Manuale
    //  status.m_cClientMode: stato che deve assumere il client
    //  status.m_bError: indica se si e' verificato un errore
    //  status.m_bExit: indica se e' un punto di uscita
    //  status.m_cAtExit: azione di uscita
    Forward localForward = Forward.Unforwarded;
    if ( ! (status.m_bExit) || CPLib.Empty(status.m_cAtExit)) {
    } else if (CPLib.eq(CPLib.Left(status.m_cAtExit,8),"workflow")) {
      ExitToWorkflow(status);
    } else if (CPLib.eq(CPLib.Left(status.m_cAtExit,8),"activity")) {
      ExitToActivity(status,BO);
    } else if (status.m_bError && CPLib.ne(status.m_cClientMode,"bringback")) {
      // Il programma da eseguire in uscita non sa come visualizzare l' errore, viene quindi lanciata la pagina di errore che poi eseguira' il programma di uscita
      status.m_cClientMode = "error";
    } else if (status.m_bError) {
    } else if (CPLib.eq(status.m_cAtExit,"new")) {
      status.CleanInterfaceSettings();
      New(status,BO,source);
    } else if (CPLib.eq(status.m_cAtExit,"edit")) {
      status.w_code = BO.w_code;
      BO.Initialize();
      Edit(status,BO,source);
    } else if (CPLib.eq(status.m_cAtExit,"autozoom")) {
      // Si puo' proseguire con lo zoom
      OpenZoom(status,source);
    } else if (CPLib.eq(status.m_cAtExit,"close")) {
      // Si puo' proseguire con la chiusura della pagina corrente
      status.m_cClientMode = "close";
    } else if (CPLib.eq(status.m_cAtExit,"close&reload")) {
      // Si puo' proseguire con la chiusura della pagina corrente e rinfrescare il chiamante
      status.m_bReload = true;
      status.m_cClientMode = "close";
    } else {
      status.m_cAtExit = "workflow"+"\n"+"@END"+"\n"+status.m_cAtExit;
      ManageWorkflow(status,"@END");
    }
    // ora interpreta la seconda parte del workflow (i vari set sull' oggetto reale)
    ExecuteWorkflowStartingScript(status,BO);
    // Ora manda la pagina di risposta
    NotifyEvent("Response start",status,BO);
    if (Forward.IsForwarded(status.forwardedto)) {
      SPLib.ForwardTo(status.forwardedto,servletContext,status.request,status.response);
      return;
    }
    SPLib.SetContentType(response);
    if ("get".equalsIgnoreCase(request.getMethod())) {
      SPLib.NoCache(response);
    }
    status.out = response.getWriter();
    if (CPLib.eq(status.m_cClientMode,"error")) {
      WriteErrorPage(status);
    } else if (CPLib.eq(status.m_cClientMode,"close")) {
      WriteExitPage(BO,status,localForward);
    } else if (CPLib.eq(status.m_cClientMode,"bringback")) {
      BringBackPage(BO,status);
    } else if (CPLib.eq(status.m_cAction,"createportlet")) {
      CreatePortlet(status,BO);
    } else {
      WriteFormPage(BO,status);
    }
  }
  public String getEntityTitle() {
    return "CP_USERS";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "spadministration_users";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 900;
    l_eg.m_nEntityHeight = 930;
    l_eg.isPublic = false;
    l_eg.canAccess = false;
    l_eg.canInsert = false;
    l_eg.canChange = false;
    l_eg.canDelete = false;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"cpusers","cpusers","cplangs"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","ADMIN_GENERALE","page"),new ZoneItem("box_BGMYNICMON","CP_SSOID","horizontal_section"),new ZoneItem("box_access","Access","titled_box"),new ZoneItem("box_WUIVVJMUJT","","auto_horizontal_section"),new ZoneItem("pwdratecause_layer","","layer"),new ZoneItem("complexityreq_layer","ADMIN_REQUIRED_COMPLEXITY","layer"),new ZoneItem("pwd_layer","ADMIN_DETAILS","horizontal_section"),new ZoneItem("durationreq_layer","ADMIN_PWDDAYSDURATION","layer"),new ZoneItem("ciclicityreq_layer","ADMIN_PWDCICLICITY","layer"),new ZoneItem("captchareq_layer","ADMIN_CAPTCHA_LEVEL","layer"),new ZoneItem("language_formatting","Formattazione","horizontal_section"),new ZoneItem("box_AXCUQKTKCI","SPAS_IAR_LICENSE","horizontal_section"),new ZoneItem("gruppi_appartenenza","ADMIN_GROUP_MEMBERSHIP","horizontal_section"),new ZoneItem("companies_hsect","CP_COMPANIES","horizontal_section")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"code"};
    l_eg.items = new SPItem[]{
                   new SPItem("code","N",9,0, "edit","ADMIN_CODE"),
                   new SPItem("fullname","C",2048,0, "edit","ADMIN_FULLNAME"),
                   new SPItem("name","C",50,0, "edit","ADMIN_NAME"),
                   new SPItem("accesstype_human","L",1,0, "edit","&Human"),
                   new SPItem("accesstype_service","L",1,0, "edit","&Service"),
                   new SPItem("accesstype_machine","L",1,0, "edit","&Machine"),
                   new SPItem("modifyPassword","N",1,0, "edit",""),
                   new SPItem("pwd1","C",20,0, "edit","Password"),
                   new SPItem("calcomplex","N",3,0, "show","ADMIN_PWDCOMPLEXITY"),
                   new SPItem("pwdratecause","M",10,0, "show",""),
                   new SPItem("pwd2","C",20,0, "edit","MSG_CONFIRM_PASSWORD"),
                   new SPItem("pwdcomplexity_group","N",3,0, "edit","ADMIN_PWDCOMPLEXITY"),
                   new SPItem("pwdcomplexity","N",3,0, "edit","ADMIN_PWDCOMPLEXITY"),
                   new SPItem("pwdcomplexity_reqired","N",3,0, "show","ADMIN_PWDCOMPLEXITY"),
                   new SPItem("forcepwdchange","L",1,0, "edit","ADMIN_FORCEPWDCHANGE"),
                   new SPItem("enabled","C",1,0, "edit","ADMIN_DISABLED"),
                   new SPItem("language","C",3,0, "edit","ADMIN_LANGUAGE"),
                   new SPItem("language_name","C",25,0, "hide",""),
                   new SPItem("decimalseparator","C",3,0, "edit",""),
                   new SPItem("thousandseparator","C",3,0, "edit",""),
                   new SPItem("datepattern","C",12,0, "edit","ADMIN_DATEPATTERN"),
                   new SPItem("datetimepattern","C",25,0, "edit","ADMIN_DATETIMEPATTERN"),
                   new SPItem("pwddaysduration_group","N",4,0, "show","ADMIN_PWDDAYSDURATION_GROUPS"),
                   new SPItem("pwddaysduration","N",4,0, "edit","ADMIN_PWDDAYSDURATION"),
                   new SPItem("pwdciclicity_groups","N",4,0, "show","ADMIN_PWDCICLICITY_GROUPS"),
                   new SPItem("pwdciclicity","N",2,0, "edit","ADMIN_PWDCICLICITY"),
                   new SPItem("pwdcaptchalevel_group","N",3,0, "show","ADMIN_CAPTCHA_LEVEL_GROUP"),
                   new SPItem("captchalevel","N",4,0, "edit","ADMIN_CAPTCHA_LEVEL"),
                   new SPItem("datestart","D",8,0, "edit","ADMIN_VALIDITY_START"),
                   new SPItem("datestop","D",8,0, "edit","ADMIN_VALIDITY_END"),
                   new SPItem("failedlogins","N",3,0, "show","ADMIN_NUM_FAILED_LOGIN"),
                   new SPItem("lastfailedlogin","T",14,0, "show","ADMIN_LAST_FAILED_LOGIN"),
                   new SPItem("lastsuccessfullogin","T",14,0, "show","ADMIN_LAST_SUCCESS_LOGIN"),
                   new SPItem("pwdcreate","T",14,0, "show","ADMIN_PWDCREATE"),
                   new SPItem("pwddaysduration_applied","N",4,0, "show","ADMIN_PWDDAYSDURATION"),
                   new SPItem("pwdciclicity_applied","N",4,0, "show","ADMIN_PWDCICLICITY"),
                   new SPItem("pwdcaptchalevel_applied","N",4,0, "show","ADMIN_CAPTCHA_LEVEL"),
                   new SPItem("printserver","C",60,0, "edit","ADMIN_PRINT_SERVER"),
                   new SPItem("init_code","N",6,0, "hide",""),
                   new SPItem("createdwhen","T",14,0, "hide","ADMIN_CREATEDWHEN"),
                   new SPItem("pwd_modified","L",1,0, "hide",""),
                   new SPItem("usesiarlicense","C",1,0, "edit","SPAS_USES_IAR_LICENSE"),
                   new SPItem("IAR_LICENSE_VALID","L",1,0, "hide",""),
                   new SPItem("IAR_LICENSES","N",6,0, "show",""),
                   new SPItem("IAR_USED","N",6,0, "show",""),
                   new SPItem("IAR_AVAILABLE","N",6,0, "show",""),
                   new SPItem("selected_group","N",4,0, "edit",""),
                   new SPItem("g_OTPisActive","C",1,0, "hide",""),
                   new SPItem("otp","C",100,0, "edit",""),
                   new SPItem("companies","C",2000,0, "edit","Companies"),
                   new SPItem("UFENABLEAZI","C",1,0, "edit","Abilita l'utente su certe aziende"),
                   new SPItem("pwd1_view","L",1,0, "hide",""),
                   new SPItem("pwd2_view","L",1,0, "hide","")
                 };
    l_eg.m_lHasHistorical = false;
    return l_eg;
  }
  ArrayList<org.json.JSONArray> i_sidebarItems = null;
  public org.json.JSONArray getSidebarItems(int p_nPage) {
    if (CPLib.IsNull(i_sidebarItems)) {
      i_sidebarItems = InitializeSidebarItemsArray(1);
      org.json.JSONArray l_sidebarPageItems;
    }
    if (CPLib.ge(p_nPage,0) && CPLib.lt(p_nPage,i_sidebarItems.size())) {
      return i_sidebarItems.get(p_nPage);
    } else {
      return new org.json.JSONArray();
    }
  }
  // m_layerGroups inizializzato dal primo accesso a FillLayerGroups
  org.json.JSONObject m_layerGroups = null;
  public void FillLayerGroups(CPMNTChild[] p_MNTs) {
    if (CPLib.IsNull(m_layerGroups)) {
      org.json.JSONObject l_layerGroups = null;
      l_layerGroups = new org.json.JSONObject("{}");
      if ( ! (CPLib.IsNull(p_MNTs))) {
        CPLib.AppendFoundlingChildOnLayerGroup(p_MNTs,l_layerGroups);
      }
      m_layerGroups = l_layerGroups;
    }
  }
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,spadministration_usersBO BO) {
    CPMNTChild[] l_MNTs = BO.m_MNTs;
    FillLayerGroups(l_MNTs);
    return GetGenericLayerGroupHeader(getLayerGroup(p_cGroupName),p_cLayerName,p_cLayerId,BO.m_Ctx,l_MNTs);
  }
  public org.json.JSONArray getLayerGroup(String group) {
    return m_layerGroups.getJSONArray(group);
  }
  org.json.JSONArray i_notifyItems = null;
  public org.json.JSONArray getNotifyItems() {
    if (CPLib.IsNull(i_notifyItems)) {
      i_notifyItems = new org.json.JSONArray();
    }
    return i_notifyItems;
  }
  ArrayList<org.json.JSONArray> i_contextmenu = null;
  public org.json.JSONArray getContextMenu(int p_nPage) {
    if (CPLib.IsNull(i_contextmenu)) {
      i_contextmenu = InitializeContextMenuArray(1);
      org.json.JSONArray l_contextmenuPageItems;
    }
    if (CPLib.ge(p_nPage,0) && CPLib.lt(p_nPage,i_contextmenu.size())) {
      return i_contextmenu.get(p_nPage);
    } else {
      return new org.json.JSONArray();
    }
  }
  static volatile java.util.Set<String> m_ManualBlockTranslations;
  java.util.Set<String> ManualBlockTranslations() {
    if (CPLib.IsNull(m_ManualBlockTranslations)) {
      m_ManualBlockTranslations = com.zucchetti.sitepainter.Library.findFormatMsg("iif( w_IAR_LICENSE_VALID, "+"'"+""+"'"+", FormatMsg( "+"'"+"SPAS_LICENSE_TAMPERED_MSG"+"'"+" ) )"+" "+"iif(Empty(w_otp),FormatMsg(\"ADMIN_ACTIVATE_OTP\"),FormatMsg(\"ADMIN_DEACTIVATE_OTP\"))");
    }
    return m_ManualBlockTranslations;
  }
  public String[][] JSTranslations(CPContext p_Context) {
    String[][] l_translations;
    l_translations=new String[][]{{"100703254",p_Context.Translate("ADMIN_PWDCOMPLEXITY_REACHED")},
    {"10075957577",p_Context.Translate("ADMIN_CAPTCHA_LEVEL")},
    {"10127257556",p_Context.Translate("ADMIN_PWDCICLICITY_GROUPS")},
    {"10196742531",p_Context.Translate("Spiegazione della complessità raggiunta")},
    {"10404909924",p_Context.Translate("ADMIN_LAST_FAILED_LOGIN_DATETIME")},
    {"10482651266",p_Context.Translate("ADMIN_PWDCOMPLEXITY_MIN")},
    {"10556996636",p_Context.Translate("ADMIN_DISABLED")},
    {"1060953294",p_Context.Translate("ADMIN_USERNAME_EXISTS")},
    {"1076819334",p_Context.Translate("ADMIN_PWDDAYSDURATION")},
    {"10810475596",p_Context.Translate("ADMIN_SELECT_LANGUAGE")},
    {"1082066774",p_Context.Translate("Ciclicità specifica per l'utente. Zero = nessuna")},
    {"10891053757",p_Context.Translate("ADMIN_PWDCOMPLEXITYRATE_EXPL")},
    {"10892072166",p_Context.Translate("ADMIN_MSG_ERROR_RANGE")},
    {"10989948426",p_Context.Translate("&Machine")},
    {"10992262541",p_Context.Translate("ADMIN_DATEPATTERN")},
    {"11068993370",p_Context.Translate("Companies")},
    {"11080326411",p_Context.Translate("Il livello minimo di complessità della password")},
    {"11086835527",p_Context.Translate("ADMIN_DATETIMEPATTERN")},
    {"1110746968",p_Context.Translate("MSG_WEAKY_PASSWORD")},
    {"11134759945",p_Context.Translate("ADMIN_USER_FULLNAME")},
    {"11173517738",p_Context.Translate("&Service")},
    {"11183930016",p_Context.Translate("Password")},
    {"11390118107",p_Context.Translate("ADMIN_PWDDAYSDURATION_GROUPS")},
    {"11414533951",p_Context.Translate("ADMIN_DATE_EXAMPLES")},
    {"11417048807",p_Context.Translate("Livello minimo di complessià richiesto dai gruppi di appartenenza")},
    {"11586272425",p_Context.Translate("Abilita l'utente su certe aziende")},
    {"11586457659",p_Context.Translate("Numero di accessi fallibili massimo specifico per l'utente prima di visualizzare il CAPTCHA")},
    {"11595652979",p_Context.Translate("ADMIN_FULLNAME")},
    {"11612322041",p_Context.Translate("ADMIN_CAPTCHA_LEVEL_GROUP")},
    {"11641847591",p_Context.Translate("ADMIN_PWDCICLICITY")},
    {"11646716131",p_Context.Translate("ADMIN_DECIMALSEPARATOR_EXAMPLE")},
    {"11701122331",p_Context.Translate("ADMIN_DETAILS")},
    {"117148196",p_Context.Translate("ADMIN_CREATEDWHEN")},
    {"1176248443",p_Context.Translate("ADMIN_LAST_SUCCESS_LOGIN_DATETIME")},
    {"11801066077",p_Context.Translate("Livello minimo di complessità della password richiesto per l'utente")},
    {"11835557445",p_Context.Translate("Numero di accessi fallibili massimo calcolato dai gruppi di appartenenza prima di visualizzare il CAPTCHA")},
    {"11837720696",p_Context.Translate("ADMIN_THOUSAND_EXAMPLE")},
    {"11873255554",p_Context.Translate("ADMIN_PWDCOMPLEXITY")},
    {"11915928953",p_Context.Translate("ADMIN_DISABLED_USER")},
    {"11958389719",p_Context.Translate("SPAS_USES_IAR_LICENSE")},
    {"11972117867",p_Context.Translate("ADMIN_PWDDAYSDURATION_TOOLTIP")},
    {"12035764157",p_Context.Translate("CP_USERS")},
    {"12136232393",p_Context.Translate("ADMIN_PICTUREALLCOMPILED")},
    {"1216878000",p_Context.Translate("ADMIN_FORCEPWDCHANGE_TOOLTIP")},
    {"122177958",p_Context.Translate("&Human")},
    {"127668165",p_Context.Translate("ADMIN_USER_LOGIN_HELPTIP")},
    {"13447241",p_Context.Translate("ADMIN_PWDCREATE_DATE")},
    {"1442113608",p_Context.Translate("ADMIN_LAST_FAILED_LOGIN")},
    {"1493538838",p_Context.Translate("Premere per la durata della password utente e calcolata dai gruppi")},
    {"160108003",p_Context.Translate("Durata massima della password richiesta dai gruppi di appartenenza. Zero = sempre valida")},
    {"1615256308",p_Context.Translate("MSG_ENABLE_MODIFY_PASSWORD")},
    {"1638670341",p_Context.Translate("Premere per la ciclicità della password utente e calcolata dai gruppi")},
    {"1651831919",p_Context.Translate("ADMIN_USER_VALIDITY_END")},
    {"1670742889",p_Context.Translate("ADMIN_MAXIMUM")},
    {"1682105886",p_Context.Translate("ADMIN_NAME")},
    {"1703287693",p_Context.Translate("ADMIN_DATETIME_EXAMPLES")},
    {"1725844287",p_Context.Translate("ADMIN_LANGUAGE")},
    {"1805703331",p_Context.Translate("Service")},
    {"1817176413",p_Context.Translate("Machine")},
    {"1848680752",p_Context.Translate("MSG_PASSWORD_CONFIRM_DIFFERENT")},
    {"20009153",p_Context.Translate("ADMIN_VALIDITY_START")},
    {"2135137720",p_Context.Translate("Durata massima della password per l'utente. Zero = sempre valida")},
    {"2145580227",p_Context.Translate("ADMIN_USER_VALIDITY_START")},
    {"264454043",p_Context.Translate("ADMIN_CAPTCHA_LEVEL_TOOLTIP")},
    {"281577461",p_Context.Translate("ADMIN_PWDCREATE")},
    {"495629605",p_Context.Translate("ADMIN_DATE_WRONG")},
    {"556515051",p_Context.Translate("ADMIN_VALIDITY_END")},
    {"65259300",p_Context.Translate("ADMIN_FORCEPWDCHANGE")},
    {"661213079",p_Context.Translate("ADMIN_USER_LANGUAGE")},
    {"663853719",p_Context.Translate("ADMIN_LAST_SUCCESS_LOGIN")},
    {"678494100",p_Context.Translate("Descrizone della lingua dell'utente")},
    {"687682343",p_Context.Translate("Ciclicità minima richiesta dai gruppi di appartenenza")},
    {"753676303",p_Context.Translate("ADMIN_PRINT_SERVER")},
    {"7636120",p_Context.Translate("Human")},
    {"766901589",p_Context.Translate("ADMIN_CODE_MUST_POSITIVE")},
    {"770280807",p_Context.Translate("ADMIN_DATETIME_WRONG")},
    {"785458012",p_Context.Translate("Premere per la soglia di CAPTCHA utente e calcolata dai gruppi")},
    {"786093217",p_Context.Translate("Inserire le Companies in sequenza separate da virgola")},
    {"795347234",p_Context.Translate("ADMIN_PWDCICLICITY_TOOLTIP")},
    {"85399363",p_Context.Translate("Il livello di complessità della password inserita")},
    {"863896029",p_Context.Translate("ADMIN_NUM_FAILED_LOGIN")},
    {"960685589",p_Context.Translate("ADMIN_CODE")},
    {"983832109",p_Context.Translate("MSG_CONFIRM_PASSWORD")}};
    String[] l_Pair;
    java.util.List<String[]> l_ManualBlocks = new java.util.ArrayList<String[]>();
    l_ManualBlocks.addAll(java.util.Arrays.asList(l_translations));
    for (String msg : ManualBlockTranslations()) {
      l_Pair=new String[]{msg,p_Context.Translate(msg)};
      l_ManualBlocks.add(l_Pair);
    }
    return l_ManualBlocks.toArray(l_translations);
  }
  void WriteStyles(spadministration_usersBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../spadministration_users.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(spadministration_usersBO BO,ServletStatus status) {
    status.out.println(
     "<div id='FrmMain' class='FormDefault'>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("if ( ! (Empty(m_cLayerInterface))) {");
    status.out.println("document.getElementById('FrmMain').style.display='none';");
    status.out.println("}");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='subTitleContainer' class='subTitleContainer' style='display:none'>" +
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println(
     "</script>" +
    "");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"ADMIN_GENERALE")) {
      status.out.println(
       "<div id='tabsContainer'>" +
       " " +
       "</div>" +
      "");
    }
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      status.request.setAttribute("com__zucchetti__sitepainter__altinterface__url",status.m_cAltInterface);
      status.request.setAttribute("com__zucchetti__sitepainter__altinterface__m_cEntityUid",m_cEntityUid);
      SPLib.Include(servletContext,status,status.m_cAltInterface);
    } else {
      WriteControls(BO,status);
    }
    status.out.println(
     "<script>" +
    "");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"ADMIN_GENERALE")) {
      status.out.println("if ( ! (Z.Tabs.Has('tabs'))) {");
      status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("ADMIN_GENERALE"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
      status.out.println("Z.Tabs.Set('tabs',tabs);");
      status.out.println("} else {");
      status.out.println("var tabs = Z.Tabs.Get('tabs')");
      status.out.println("}");
      AddExtendedTabs(status);
      status.out.println("Z.Tabs.Get('tabs').InitSelect('spadministration_users',false);");
    }
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"spadministration_users",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  // GetPortlet_grdCompanies_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_OBAKOPSMDI_Vars(spadministration_usersBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  void WriteControls(spadministration_usersBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,2);
  }
  void WriteControls_p1(spadministration_usersBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:930px;width:900px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteControls_p1_b1(BO,status);
    WriteControls_p1_b2(BO,status);
    WriteControls_p1_b3(BO,status);
    WriteControls_p1_b4(BO,status);
    WriteControls_p1_b5(BO,status);
    WriteControls_p1_b6(BO,status);
    WriteControls_p1_b7(BO,status);
    WriteControls_p1_b8(BO,status);
    WriteControls_p1_b9(BO,status);
    WriteControls_p1_b10(BO,status);
    WriteControls_p1_l0(BO,status);
    WriteControls_p1_l1(BO,status);
    WriteControls_p1_l2(BO,status);
    WriteControls_p1_l3(BO,status);
    WriteControls_p1_l4(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"ADMIN_GENERALE");
    PrintSidebarContent(1,status,getSidebarItems(0),true);
    PrintContextMenu(1,status,getContextMenu(0),"spadministration");
    status.out.println(
     "</div>" +
    "");
    if ( ! (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"ADMIN_GENERALE"))) {
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('page_1').style.display='block';");
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteControls_p1_l0(spadministration_usersBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='display:none' class='LayerContainer' id='PLMVGNNZCG_DIV'>" +
     "<div id='PLMVGNNZCG_HEADER' onmousedown=\"dragLayer(event,'PLMVGNNZCG_DIV')\" class='LayerHeader'><span id='PLMVGNNZCG_HEADER_CAPTION' class='LayerHeaderCaption'></span>"+com.zucchetti.sitepainter.Library.GenerateIcon(com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "layerHeaderPinImage", "../"+status.m_cTheme+"/formPage/box_layer_pin.gif"), "", "", "onclick='TogglePinLayerBox(\"PLMVGNNZCG\")' alt='"+status.context.Translate("MSG_PIN_UNPIN")+"' title='"+status.context.Translate("MSG_PIN_UNPIN")+"' class='LayerHeaderIconPin'", "id='PLMVGNNZCG_HEADER_ICON_PIN'")+""+com.zucchetti.sitepainter.Library.GenerateIcon(com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "layerHeaderCloseImage", "../"+status.m_cTheme+"/formPage/box_layer_close.gif"), "", "", "onclick='HideLayerBox(\"PLMVGNNZCG_DIV\",false)' alt='"+status.context.Translate("MSG_CLOSE_ONEXIT")+"' title='"+status.context.Translate("MSG_CLOSE_ONEXIT")+"' class='LayerHeaderIconClose'")+"</div>" +
     "<div id='PLMVGNNZCG' class='LayerBody'>" +
    "");
    if (status.includeZoneAltInterface(status.context,"pwdratecause_layer")) {
    } else {
      status.out.println(
       "<textarea name='pwdratecause' id='OTMRFENACR' class='Memo Disabled' title="+SPLib.ToHTMLValue(status.context.Translate("Spiegazione della complessità raggiunta"),"C",0,0)+" tabindex='-1' readonly cols='20' rows='2'>" +
       "</textarea>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='LastLayerElement' type='text' class='Field' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
      "");
    }
    status.out.println(
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('PLMVGNNZCG_DIV').setAttribute('pin_status','unpinned');");
    if (CPLib.IsNull(status.GetZoneAltInterface("pwdratecause_layer"))) {
    } else {
      status.out.println("Ctrl('PLMVGNNZCG').style.height='auto';");
    }
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_l1(spadministration_usersBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='display:none' class='LayerContainer' id='PBZCUWPENC_DIV'>" +
     "<div id='PBZCUWPENC_HEADER' onmousedown=\"dragLayer(event,'PBZCUWPENC_DIV')\" class='LayerHeader'><span id='PBZCUWPENC_HEADER_CAPTION' class='LayerHeaderCaption'>"+status.context.Translate("ADMIN_REQUIRED_COMPLEXITY")+"</span>"+com.zucchetti.sitepainter.Library.GenerateIcon(com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "layerHeaderPinImage", "../"+status.m_cTheme+"/formPage/box_layer_pin.gif"), "", "", "onclick='TogglePinLayerBox(\"PBZCUWPENC\")' alt='"+status.context.Translate("MSG_PIN_UNPIN")+"' title='"+status.context.Translate("MSG_PIN_UNPIN")+"' class='LayerHeaderIconPin'", "id='PBZCUWPENC_HEADER_ICON_PIN'")+""+com.zucchetti.sitepainter.Library.GenerateIcon(com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "layerHeaderCloseImage", "../"+status.m_cTheme+"/formPage/box_layer_close.gif"), "", "", "onclick='HideLayerBox(\"PBZCUWPENC_DIV\",false)' alt='"+status.context.Translate("MSG_CLOSE_ONEXIT")+"' title='"+status.context.Translate("MSG_CLOSE_ONEXIT")+"' class='LayerHeaderIconClose'")+"</div>" +
     "<div id='PBZCUWPENC' class='LayerBody'>" +
    "");
    if (status.includeZoneAltInterface(status.context,"complexityreq_layer")) {
    } else {
      status.out.println(
       "<span class='SPLabel' id='WNFOFUHXXF_DIV'>" +
       "<label id='WNFOFUHXXF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_PWDCOMPLEXITY_GROUP"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='pwdcomplexity_group' id='TBXREXYXIU' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_pwdcomplexity_group,"N",3,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("Livello minimo di complessià richiesto dai gruppi di appartenenza"),"C",0,0)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='4' size='3' fieldtype='N'>" +
       "<span class='SPLabel' id='XCVHSJEHUH_DIV'>" +
       "<label id='XCVHSJEHUH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_PWDCOMPLEXITY_USER"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='pwdcomplexity' id='YDSHUIXYEH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_pwdcomplexity,"N",3,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("Livello minimo di complessità della password richiesto per l'utente"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='LastLayerElement' type='text' class='Field' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
      "");
    }
    status.out.println(
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('PBZCUWPENC_DIV').setAttribute('pin_status','unpinned');");
    if (CPLib.IsNull(status.GetZoneAltInterface("complexityreq_layer"))) {
    } else {
      status.out.println("Ctrl('PBZCUWPENC').style.height='auto';");
    }
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_l2(spadministration_usersBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='display:none' class='LayerContainer' id='QTXMMDECZO_DIV'>" +
     "<div id='QTXMMDECZO_HEADER' onmousedown=\"dragLayer(event,'QTXMMDECZO_DIV')\" class='LayerHeader'><span id='QTXMMDECZO_HEADER_CAPTION' class='LayerHeaderCaption'>"+status.context.Translate("ADMIN_PWDDAYSDURATION")+"</span>"+com.zucchetti.sitepainter.Library.GenerateIcon(com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "layerHeaderPinImage", "../"+status.m_cTheme+"/formPage/box_layer_pin.gif"), "", "", "onclick='TogglePinLayerBox(\"QTXMMDECZO\")' alt='"+status.context.Translate("MSG_PIN_UNPIN")+"' title='"+status.context.Translate("MSG_PIN_UNPIN")+"' class='LayerHeaderIconPin'", "id='QTXMMDECZO_HEADER_ICON_PIN'")+""+com.zucchetti.sitepainter.Library.GenerateIcon(com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "layerHeaderCloseImage", "../"+status.m_cTheme+"/formPage/box_layer_close.gif"), "", "", "onclick='HideLayerBox(\"QTXMMDECZO_DIV\",false)' alt='"+status.context.Translate("MSG_CLOSE_ONEXIT")+"' title='"+status.context.Translate("MSG_CLOSE_ONEXIT")+"' class='LayerHeaderIconClose'")+"</div>" +
     "<div id='QTXMMDECZO' class='LayerBody'>" +
    "");
    if (status.includeZoneAltInterface(status.context,"durationreq_layer")) {
    } else {
      status.out.println(
       "<span class='SPLabel' id='OXCBAQDUEO_DIV'>" +
       "<label id='OXCBAQDUEO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_PWDDAYSDURATION_GROUPS"))+"" +
       "</label>" +
       "</span>" +
       "<input name='pwddaysduration_group' id='AMIQVJBLLQ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_pwddaysduration_group,"N",4,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("Durata massima della password richiesta dai gruppi di appartenenza. Zero = sempre valida"),"C",0,0)+" tabindex='-1' readonly maxlength='5' size='4' fieldtype='N'>" +
       "<span class='SPLabel' id='CNLYOZMXLI_DIV'>" +
       "<label id='CNLYOZMXLI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_PWDCOMPLEXITY_USER"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='pwddaysduration' id='NTAYXBDPVY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_pwddaysduration,"N",4,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("Durata massima della password per l'utente. Zero = sempre valida"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='4' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='LastLayerElement' type='text' class='Field' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
      "");
    }
    status.out.println(
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('QTXMMDECZO_DIV').setAttribute('pin_status','unpinned');");
    if (CPLib.IsNull(status.GetZoneAltInterface("durationreq_layer"))) {
    } else {
      status.out.println("Ctrl('QTXMMDECZO').style.height='auto';");
    }
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_l3(spadministration_usersBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='display:none' class='LayerContainer' id='YWYTSWWAZG_DIV'>" +
     "<div id='YWYTSWWAZG_HEADER' onmousedown=\"dragLayer(event,'YWYTSWWAZG_DIV')\" class='LayerHeader'><span id='YWYTSWWAZG_HEADER_CAPTION' class='LayerHeaderCaption'>"+status.context.Translate("ADMIN_PWDCICLICITY")+"</span>"+com.zucchetti.sitepainter.Library.GenerateIcon(com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "layerHeaderPinImage", "../"+status.m_cTheme+"/formPage/box_layer_pin.gif"), "", "", "onclick='TogglePinLayerBox(\"YWYTSWWAZG\")' alt='"+status.context.Translate("MSG_PIN_UNPIN")+"' title='"+status.context.Translate("MSG_PIN_UNPIN")+"' class='LayerHeaderIconPin'", "id='YWYTSWWAZG_HEADER_ICON_PIN'")+""+com.zucchetti.sitepainter.Library.GenerateIcon(com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "layerHeaderCloseImage", "../"+status.m_cTheme+"/formPage/box_layer_close.gif"), "", "", "onclick='HideLayerBox(\"YWYTSWWAZG_DIV\",false)' alt='"+status.context.Translate("MSG_CLOSE_ONEXIT")+"' title='"+status.context.Translate("MSG_CLOSE_ONEXIT")+"' class='LayerHeaderIconClose'")+"</div>" +
     "<div id='YWYTSWWAZG' class='LayerBody'>" +
    "");
    if (status.includeZoneAltInterface(status.context,"ciclicityreq_layer")) {
    } else {
      status.out.println(
       "<span class='SPLabel' id='INOSWBMEWD_DIV'>" +
       "<label id='INOSWBMEWD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_PWDCICLICITY_GROUPS"))+"" +
       "</label>" +
       "</span>" +
       "<input name='pwdciclicity_groups' id='LDXRXBOORH' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_pwdciclicity_groups,"N",4,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("Ciclicità minima richiesta dai gruppi di appartenenza"),"C",0,0)+" tabindex='-1' readonly maxlength='5' size='4' fieldtype='N'>" +
       "<span class='SPLabel' id='KRTEQHMKQD_DIV'>" +
       "<label id='KRTEQHMKQD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_PWDCOMPLEXITY_USER"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='pwdciclicity' id='CLZCOSTIAC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_pwdciclicity,"N",2,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("Ciclicità specifica per l'utente. Zero = nessuna"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='2' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='LastLayerElement' type='text' class='Field' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
      "");
    }
    status.out.println(
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('YWYTSWWAZG_DIV').setAttribute('pin_status','unpinned');");
    if (CPLib.IsNull(status.GetZoneAltInterface("ciclicityreq_layer"))) {
    } else {
      status.out.println("Ctrl('YWYTSWWAZG').style.height='auto';");
    }
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_l4(spadministration_usersBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='display:none' class='LayerContainer' id='YIYKXFSQJK_DIV'>" +
     "<div id='YIYKXFSQJK_HEADER' onmousedown=\"dragLayer(event,'YIYKXFSQJK_DIV')\" class='LayerHeader'><span id='YIYKXFSQJK_HEADER_CAPTION' class='LayerHeaderCaption'>"+status.context.Translate("ADMIN_CAPTCHA_LEVEL")+"</span>"+com.zucchetti.sitepainter.Library.GenerateIcon(com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "layerHeaderPinImage", "../"+status.m_cTheme+"/formPage/box_layer_pin.gif"), "", "", "onclick='TogglePinLayerBox(\"YIYKXFSQJK\")' alt='"+status.context.Translate("MSG_PIN_UNPIN")+"' title='"+status.context.Translate("MSG_PIN_UNPIN")+"' class='LayerHeaderIconPin'", "id='YIYKXFSQJK_HEADER_ICON_PIN'")+""+com.zucchetti.sitepainter.Library.GenerateIcon(com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "layerHeaderCloseImage", "../"+status.m_cTheme+"/formPage/box_layer_close.gif"), "", "", "onclick='HideLayerBox(\"YIYKXFSQJK_DIV\",false)' alt='"+status.context.Translate("MSG_CLOSE_ONEXIT")+"' title='"+status.context.Translate("MSG_CLOSE_ONEXIT")+"' class='LayerHeaderIconClose'")+"</div>" +
     "<div id='YIYKXFSQJK' class='LayerBody'>" +
    "");
    if (status.includeZoneAltInterface(status.context,"captchareq_layer")) {
    } else {
      status.out.println(
       "<span class='SPLabel' id='ONZAKKFAAI_DIV'>" +
       "<label id='ONZAKKFAAI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_CAPTCHA_LEVEL_GROUPS"))+"" +
       "</label>" +
       "</span>" +
       "<input name='pwdcaptchalevel_group' id='LREHYNDNHI' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_pwdcaptchalevel_group,"N",3,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("Numero di accessi fallibili massimo calcolato dai gruppi di appartenenza prima di visualizzare il CAPTCHA"),"C",0,0)+" tabindex='-1' readonly maxlength='4' size='3' fieldtype='N'>" +
       "<span class='SPLabel' id='SWHXFUZIRC_DIV'>" +
       "<label id='SWHXFUZIRC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_PWDCOMPLEXITY_USER"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='captchalevel' id='WLRWPELGIS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_captchalevel,"N",4,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("Numero di accessi fallibili massimo specifico per l'utente prima di visualizzare il CAPTCHA"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='4' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='LastLayerElement' type='text' class='Field' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
      "");
    }
    status.out.println(
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('YIYKXFSQJK_DIV').setAttribute('pin_status','unpinned');");
    if (CPLib.IsNull(status.GetZoneAltInterface("captchareq_layer"))) {
    } else {
      status.out.println("Ctrl('YIYKXFSQJK').style.height='auto';");
    }
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b0(spadministration_usersBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_1' style='position:relative;height:120px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_TOP_OF_PAGE_1').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<span class='SPLabel PrimaryKeyLabel' id='ZRXEDHLHRU_DIV'>" +
       "<label id='ZRXEDHLHRU' for='CIUGDDXJMR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_CODE"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='code' id='CIUGDDXJMR' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_code,"N",9,0,"999999999", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='12' size='9' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GONJPLYFCM_DIV'>" +
       "<label id='GONJPLYFCM' for='YOMCOSHNCV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_FULLNAME"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='fullname' id='YOMCOSHNCV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_fullname,"C",2048,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_USER_FULLNAME"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2048' size='2048' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LWKHSAVZHT_DIV'>" +
       "<label id='LWKHSAVZHT' for='ZOLPGDGKUC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_LOGIN"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='name' id='ZOLPGDGKUC' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_name,"C",50,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_USER_LOGIN_HELPTIP"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<div id='KVIFRCSRUG_DIV' class='TitledBox'>" +
       "<span id='KVIFRCSRUG_HEADER_CAPTION' class='DefaultTitledBox'>"+status.context.Translate("Access")+"</span>" +
       "<div id='KVIFRCSRUG'>" +
       "</div>" +
       "</div>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='RGNPWADGHN_DIV'>" +
       "<input name='accesstype_human' id='RGNPWADGHN' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_accesstype_human,"L",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(true,BO.w_accesstype_human)?"CHECKED":"")+">" +
       "<label id='RGNPWADGHN_LBL' for='RGNPWADGHN' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Human"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='GZOGXZQGVV_DIV'>" +
       "<input name='accesstype_service' id='GZOGXZQGVV' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_accesstype_service,"L",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(true,BO.w_accesstype_service)?"CHECKED":"")+">" +
       "<label id='GZOGXZQGVV_LBL' for='GZOGXZQGVV' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Service"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='GSXRFLFMJR_DIV'>" +
       "<input name='accesstype_machine' id='GSXRFLFMJR' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_accesstype_machine,"L",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(true,BO.w_accesstype_machine)?"CHECKED":"")+">" +
       "<label id='GSXRFLFMJR_LBL' for='GSXRFLFMJR' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Machine"))+"</label>" +
       "</span>" +
      "");
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b1(spadministration_usersBO BO,ServletStatus status) {
    status.out.println(
     "<div name='box_WUIVVJMUJT' id='WUIVVJMUJT_DIV' class='BoxContainer SPSection_expanded SectionContainerWithoutTitle' style='display:none'>" +
    "");
    status.out.println(
     "<div id='WUIVVJMUJT' class='SectionBody' style='position:relative;height:30px;display:block'>" +
    "");
    status.includeZoneAltInterface("box_WUIVVJMUJT@BEGIN");
    if (status.includeZoneAltInterface("box_WUIVVJMUJT")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("box_WUIVVJMUJT@BEGIN") || status.HasZoneAltInterface("box_WUIVVJMUJT@END")) {
        status.out.println(
         "<div id='WUIVVJMUJT_boxContent' style='position:relative;height:30px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='FTIRRMMSXK_DIV'>" +
       "<input name='modifyPassword' id='FTIRRMMSXK' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_modifyPassword,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"disabled":"")+" "+(CPLib.eq(1,BO.w_modifyPassword)?"CHECKED":"")+">" +
       "<label id='FTIRRMMSXK_LBL' for='FTIRRMMSXK' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("MSG_ENABLE_MODIFY_PASSWORD"))+"</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("box_WUIVVJMUJT@BEGIN") || status.HasZoneAltInterface("box_WUIVVJMUJT@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b1_CloseBand(spadministration_usersBO BO,ServletStatus status) {
    status.includeZoneAltInterface("box_WUIVVJMUJT@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("box_WUIVVJMUJT")) {
      status.out.println("Ctrl('WUIVVJMUJT').style.height='auto';");
    } else {
      status.out.println("Ctrl('WUIVVJMUJT').setAttribute('band_height',30);");
    }
    status.out.println("Ctrl('WUIVVJMUJT').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(spadministration_usersBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_GWZDNNWFFM")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_GWZDNNWFFM' style='position:relative;height:210px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_GWZDNNWFFM")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_GWZDNNWFFM').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<span class='SPLabel' id='YYYRCYYISO_DIV'>" +
       "<label id='YYYRCYYISO' for='GMYTSOEEXH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Password"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='pwd1' id='GMYTSOEEXH' type='password' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_pwd1,"C",20,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("Password"),"C",0,0)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='20' size='20' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='javascript:href_ZZKRWOJQTG()' tabindex='-1' id='ZZKRWOJQTG_HREF' style='display:none'>" +
       "<span id='ZZKRWOJQTG'>" +
       ""+SPLib.ToHTMLRepresentation(Character.toString((char)61550))+"" +
       "</span>" +
       "</a>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='QEXYRQXFGY_DIV' style='display:none'>" +
       "<label id='QEXYRQXFGY' title="+SPLib.ToHTMLValue(status.context.Translate("Il livello di complessità della password inserita"),"C",0,0)+" for='ZDDZZTSQYG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_PWDCOMPLEXITY"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='calcomplex' id='ZDDZZTSQYG' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_calcomplex,"N",3,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_PWDCOMPLEXITY_REACHED"),"C",0,0)+" tabindex='-1' readonly maxlength='4' size='3' fieldtype='N' style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input id='KZXLYHJHAW' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("..."),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_PWDCOMPLEXITYRATE_EXPL"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DRGTXCMDVI_DIV' style='display:none'>" +
       "<label id='DRGTXCMDVI' title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_MAXIMUM"),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation("/"+UserAdmin.Make(status.context).GetPasswordRatingMaxReachable())+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NXPUKKLWAT_DIV'>" +
       "<label id='NXPUKKLWAT' for='KIBLXEYDCR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("MSG_CONFIRM_PASSWORD"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='pwd2' id='KIBLXEYDCR' type='password' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_pwd2,"C",20,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("MSG_CONFIRM_PASSWORD"),"C",0,0)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='20' size='20' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GRPBSLBHXA_DIV' style='display:none'>" +
       "<label id='GRPBSLBHXA' title="+SPLib.ToHTMLValue(status.context.Translate("Il livello minimo di complessità della password"),"C",0,0)+" for='EJKRLFXEIY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_PWDCOMPLEXITY_MINIMUM"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='javascript:href_OTBBXDQDET()' tabindex='-1' id='OTBBXDQDET_HREF' style='display:none'>" +
       "<span id='OTBBXDQDET'>" +
       ""+SPLib.ToHTMLRepresentation(Character.toString((char)61550))+"" +
       "</span>" +
       "</a>" +
      "");
      status.out.println(
       "<input name='pwdcomplexity_reqired' id='EJKRLFXEIY' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_pwdcomplexity_reqired,"N",3,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_PWDCOMPLEXITY_MIN"),"C",0,0)+" tabindex='-1' readonly maxlength='4' size='3' fieldtype='N' style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input id='LCHPBEJNON' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("..."),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_DETAILS"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CZUCWOMCIB_DIV' style='display:none'>" +
       "<label id='CZUCWOMCIB' title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_MAXIMUM"),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation("/"+UserAdmin.Make(status.context).GetPasswordRatingMaxReachable())+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_FORCEPWDCHANGE_TOOLTIP"),"C",0,0)+" id='RRBOVTXUAU_DIV'>" +
       "<input name='forcepwdchange' id='RRBOVTXUAU' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_forcepwdchange,"L",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(true,BO.w_forcepwdchange)?"CHECKED":"")+">" +
       "<label id='RRBOVTXUAU_LBL' for='RRBOVTXUAU' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_FORCEPWDCHANGE"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_DISABLED_USER"),"C",0,0)+" id='GNSADWOGKM_DIV'>" +
       "<input name='enabled' id='GNSADWOGKM' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_enabled,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("D",CPLib.Trim(BO.w_enabled))?"CHECKED":"")+">" +
       "<label id='GNSADWOGKM_LBL' for='GNSADWOGKM' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_DISABLED"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='language' id='XFCGDYJJAR' class='Combobox' title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_USER_LANGUAGE"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UKIHMTALYE_DIV'>" +
       "<label id='UKIHMTALYE' for='XFCGDYJJAR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_LANGUAGE"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DBASOAOUYJ_DIV'>" +
       "<label id='DBASOAOUYJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CP_COMPANIES"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
      "");
      status.out.println(
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='companies' id='UYGLGETTUT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_companies,"C",2000,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("Inserire le Companies in sequenza separate da virgola"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2000' size='2000' fieldtype='C' style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='UFENABLEAZI' id='VRCQKXWFPX' class='Combobox "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"disabled":"")+">" +
       "<option value="+SPLib.ToHTMLValue("n","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("n",CPLib.Trim(BO.w_UFENABLEAZI))?"SELECTED":"")+">" +
       ""+status.context.Translate("ADMIN_ALL_COMPANIES")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("s","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("s",CPLib.Trim(BO.w_UFENABLEAZI))?"SELECTED":"")+">" +
       ""+status.context.Translate("ADMIN_LIST_OF_COMPANIES")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('VRCQKXWFPX'),w_UFENABLEAZI,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='javascript:href_OSVFPWEFJH()' tabindex='-1' id='OSVFPWEFJH_HREF' style='display:none'>" +
       "<span id='OSVFPWEFJH'>" +
       ""+SPLib.ToHTMLRepresentation(Character.toString((char)61552))+"" +
       "</span>" +
       "</a>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='javascript:href_XEGRJMWYIW()' tabindex='-1' id='XEGRJMWYIW_HREF' style='display:none'>" +
       "<span id='XEGRJMWYIW'>" +
       ""+SPLib.ToHTMLRepresentation(Character.toString((char)61552))+"" +
       "</span>" +
       "</a>" +
      "");
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b3(spadministration_usersBO BO,ServletStatus status) {
    status.out.println(
     "<div name='companies_hsect' id='GWZDNNWFFM_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle' style='display:none'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='GWZDNNWFFM_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='GWZDNNWFFM_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("CP_COMPANIES")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='GWZDNNWFFM_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"GWZDNNWFFM\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=GWZDNNWFFM_HEADER&m_cBoxId=GWZDNNWFFM&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("CP_COMPANIES"))+"");
    }
    status.out.println(
     "<div id='GWZDNNWFFM' class='SectionBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("companies_hsect@BEGIN");
    if (status.includeZoneAltInterface("companies_hsect")) {
      WriteControls_p1_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("companies_hsect@BEGIN") || status.HasZoneAltInterface("companies_hsect@END")) {
        status.out.println(
         "<div id='GWZDNNWFFM_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p1_b3_b0(BO,status);
      WriteControls_p1_b3_b1(BO,status);
      WriteControls_p1_b3_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['GWZDNNWFFM']=['band_1_360','band_1_370','band_1_591'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("companies_hsect@BEGIN") || status.HasZoneAltInterface("companies_hsect@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b3_CloseBand(spadministration_usersBO BO,ServletStatus status) {
    status.includeZoneAltInterface("companies_hsect@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('GWZDNNWFFM').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b3_b0(spadministration_usersBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_360' style='position:relative;height:10px;display:block' page='1'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b3_b1(spadministration_usersBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_370' style='position:relative;display:block' page='1'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='OBAKOPSMDI'>" +
    "");
    // GetPortlet_grdCompanies_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_OBAKOPSMDI;
    inclusionVars_OBAKOPSMDI = GetPortlet_OBAKOPSMDI_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_OBAKOPSMDI);
    String portletUID_OBAKOPSMDI = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp-system/spadministration_users_companies_portlet.jsp?ForcedPortletUID="+ portletUID_OBAKOPSMDI+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_OBAKOPSMDI),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.OBAKOPSMDI='"+portletUID_OBAKOPSMDI+"';" +
     "w_grdcompanies=ZtVWeb.getPortletById('"+portletUID_OBAKOPSMDI+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b3_b2(spadministration_usersBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_591' style='position:relative;height:19px;display:block' page='1'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b4(spadministration_usersBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_QZSVKXVUQD")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_QZSVKXVUQD' style='position:relative;height:5px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_QZSVKXVUQD")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_QZSVKXVUQD').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b5(spadministration_usersBO BO,ServletStatus status) {
    status.out.println(
     "<div id='tabs_1_configurazioni_container'>" +
     " " +
     "</div>" +
    "");
    status.out.println(
     "<div name='language_formatting' id='QZSVKXVUQD_DIV' class='BoxContainer SPSection_expanded TabStripBoxContainer' group_id='tabs_1_configurazioni'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var tabs_1_configurazioni = new Z.Tabs({container:'tabs_1_configurazioni_container',useGlobals: false,boxtabs: true,useseparator:GetStyleVariable('boxTabUseSeparator',null,''),expandcollapse:GetStyleVariable('boxTabCanCollapse',null,''),contents:[],tabstrip_class: ''});");
    status.out.println("Z.Tabs.Set('tabs_1_configurazioni',tabs_1_configurazioni);");
    status.out.println("var l_nQZSVKXVUQDTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='QZSVKXVUQD' class='TabStripBoxBody' style='position:relative;height:170px;display:block'>" +
    "");
    status.includeZoneAltInterface("language_formatting@BEGIN");
    if (status.includeZoneAltInterface("language_formatting")) {
      WriteControls_p1_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("language_formatting@BEGIN") || status.HasZoneAltInterface("language_formatting@END")) {
        status.out.println(
         "<div id='QZSVKXVUQD_boxContent' style='position:relative;height:170px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='decimalseparator' id='IZJFQHGQUB' type='text' class='Field spadminNoPadding' value="+SPLib.ToHTMLValue(BO.w_decimalseparator,"C",3,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_DECIMALSEPARATOR_EXAMPLE"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='thousandseparator' id='ACYLERWDKK' type='text' class='Field spadminNoPadding' value="+SPLib.ToHTMLValue(BO.w_thousandseparator,"C",3,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_THOUSAND_EXAMPLE"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='datepattern' id='EVNGTHPGLR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_datepattern,"C",12,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_DATE_EXAMPLES"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='12' size='12' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='datetimepattern' id='BOLWRICGIA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_datetimepattern,"C",25,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_DATETIME_EXAMPLES"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DJBOUZEOSW_DIV'>" +
       "<label id='DJBOUZEOSW' for='IZJFQHGQUB'>" +
       ""+SPLib.ToHTMLRepresentation("#"+BO.w_thousandseparator+"###"+BO.w_decimalseparator+"00")+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HUODVPIWHU_DIV'>" +
       "<label id='HUODVPIWHU' for='IZJFQHGQUB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_DECIMAL_SEPARATOR"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VCIJYACAFD_DIV'>" +
       "<label id='VCIJYACAFD' for='EVNGTHPGLR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_DATEPATTERN"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GIRCEKWNMB_DIV'>" +
       "<label id='GIRCEKWNMB' for='BOLWRICGIA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_DATETIMEPATTERN"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ADDXUTCFVF_DIV'>" +
       "<label id='ADDXUTCFVF' for='ACYLERWDKK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_THOUSAND_SEPARATOR"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HOTCYSDBTM_DIV'>" +
       "<label id='HOTCYSDBTM' for='IZJFQHGQUB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_SEPARATOR_EXAMPLE"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("language_formatting@BEGIN") || status.HasZoneAltInterface("language_formatting@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b5_CloseBand(spadministration_usersBO BO,ServletStatus status) {
    status.includeZoneAltInterface("language_formatting@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("language_formatting")) {
      status.out.println("Ctrl('QZSVKXVUQD').style.height='auto';");
    } else {
      status.out.println("Ctrl('QZSVKXVUQD').setAttribute('band_height',170);");
    }
    status.out.println("Ctrl('QZSVKXVUQD').setAttribute('status','open');");
    status.out.println("tabs_1_configurazioni.AddTab({name:\"QZSVKXVUQD\", element:\"QZSVKXVUQD_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Formattazione"),"C",0,0)+",tabIndex: l_nQZSVKXVUQDTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('QZSVKXVUQD',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('QZSVKXVUQD',false,true,false)}});");
    status.out.println("if (tabs_1_configurazioni.CanCollapse()) {");
    status.out.println("tabs_1_configurazioni.Expand('QZSVKXVUQD');");
    status.out.println("}");
    status.out.println("PageOpened.AppendReceiver('page_1',tabs_1_configurazioni.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b6(spadministration_usersBO BO,ServletStatus status) {
    status.out.println(
     "<div name='pwd_layer' id='ZVNKOIBZTJ_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' group_id='tabs_1_configurazioni'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nZVNKOIBZTJTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='ZVNKOIBZTJ' class='TabStripBoxBody' style='position:relative;height:430px;display:none'>" +
    "");
    status.includeZoneAltInterface("pwd_layer@BEGIN");
    if (status.includeZoneAltInterface("pwd_layer")) {
      WriteControls_p1_b6_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("pwd_layer@BEGIN") || status.HasZoneAltInterface("pwd_layer@END")) {
        status.out.println(
         "<div id='ZVNKOIBZTJ_boxContent' style='position:relative;height:430px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<span class='SPLabel' id='TETMHKUMSX_DIV'>" +
       "<label id='TETMHKUMSX' for='DWGQEAJBOS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_VALIDITY_START"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='datestart' id='DWGQEAJBOS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_datestart,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_USER_VALIDITY_START"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='DWGQEAJBOS_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_USER_VALIDITY_START"),"C",0,0)+" tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LHHSNVPTSD_DIV'>" +
       "<label id='LHHSNVPTSD' for='AFHAPKTVTZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_VALIDITY_END"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='datestop' id='AFHAPKTVTZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_datestop,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_USER_VALIDITY_END"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='AFHAPKTVTZ_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_USER_VALIDITY_END"),"C",0,0)+" tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ACXJLWUAKM_DIV'>" +
       "<label id='ACXJLWUAKM' for='HZXQEZHOPX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_NUM_FAILED_LOGIN"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='failedlogins' id='HZXQEZHOPX' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_failedlogins,"N",3,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_NUM_FAILED_LOGIN"),"C",0,0)+" tabindex='-1' readonly maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NNXHXVLPCZ_DIV'>" +
       "<label id='NNXHXVLPCZ' for='ZRPODWVWKZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_LAST_FAILED_LOGIN"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='lastfailedlogin' id='ZRPODWVWKZ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_lastfailedlogin,"T",14,0,SPLib.GetUserDateTimePicture(status.context.GetLanguage(),"DD-MM-YYYY hh:mm:ss"), status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_LAST_FAILED_LOGIN_DATETIME"),"C",0,0)+" tabindex='-1' readonly maxlength='19' size='14' fieldtype='T'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YIWMIRNCJP_DIV'>" +
       "<label id='YIWMIRNCJP' for='QHBHJMVSND'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_LAST_SUCCESS_LOGIN"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='lastsuccessfullogin' id='QHBHJMVSND' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_lastsuccessfullogin,"T",14,0,SPLib.GetUserDateTimePicture(status.context.GetLanguage(),"DD-MM-YYYY hh:mm:ss"), status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_LAST_SUCCESS_LOGIN_DATETIME"),"C",0,0)+" tabindex='-1' readonly maxlength='19' size='14' fieldtype='T'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UVGCSSTYHA_DIV'>" +
       "<label id='UVGCSSTYHA' for='HDTXQUZAEB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_PWDCREATE"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='pwdcreate' id='HDTXQUZAEB' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_pwdcreate,"T",14,0,SPLib.GetUserDateTimePicture(status.context.GetLanguage(),"DD-MM-YYYY hh:mm:ss"), status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_PWDCREATE_DATE"),"C",0,0)+" tabindex='-1' readonly maxlength='19' size='14' fieldtype='T'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UFJBXUDKJY_DIV'>" +
       "<label id='UFJBXUDKJY' for='TDUBYHZOLX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_PWDDAYSDURATION"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='pwddaysduration_applied' id='TDUBYHZOLX' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_pwddaysduration_applied,"N",4,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_PWDDAYSDURATION_TOOLTIP"),"C",0,0)+" tabindex='-1' readonly maxlength='5' size='4' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input id='PDERGYRPRJ' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("..."),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Premere per la durata della password utente e calcolata dai gruppi"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EKCSBIVEMO_DIV'>" +
       "<label id='EKCSBIVEMO' for='YXDVNAKABC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_PWDCICLICITY"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='pwdciclicity_applied' id='YXDVNAKABC' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_pwdciclicity_applied,"N",4,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_PWDCICLICITY_TOOLTIP"),"C",0,0)+" tabindex='-1' readonly maxlength='5' size='4' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input id='PKHYFJSKUZ' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("..."),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Premere per la ciclicità della password utente e calcolata dai gruppi"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NTPASPDTXK_DIV'>" +
       "<label id='NTPASPDTXK' for='WECEQGOQXC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_CAPTCHA_LEVEL"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='pwdcaptchalevel_applied' id='WECEQGOQXC' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_pwdcaptchalevel_applied,"N",4,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_CAPTCHA_LEVEL_TOOLTIP"),"C",0,0)+" tabindex='-1' readonly maxlength='5' size='4' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input id='KXFZJKYRKC' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("..."),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Premere per la soglia di CAPTCHA utente e calcolata dai gruppi"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ETVOQUICKV_DIV'>" +
       "<label id='ETVOQUICKV' for='BLGCNCYQRJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_PRINT_SERVER"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='printserver' id='BLGCNCYQRJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_printserver,"C",60,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_PRINT_SERVER"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='60' size='60' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='selected_group' id='XNDAWTQDZS' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_selected_group,"N",4,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='5' size='4' fieldtype='N' style='display:none'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZTPRGWPKKQ_DIV'>" +
       "<label id='ZTPRGWPKKQ' for='BLGCNCYQRJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_TWO_FACTOR_AUTH"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input id='DUYHIUNXPN' type='button' class='SPButton' value="+SPLib.ToHTMLValue((CPLib.Empty(BO.w_otp)?CPLib.FormatMsg("ADMIN_ACTIVATE_OTP"):CPLib.FormatMsg("ADMIN_DEACTIVATE_OTP")),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='otp' id='UOJLIHOZBH' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_otp,"C",100,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='100' size='100' fieldtype='C' style='display:none'>" +
      "");
      if (status.HasZoneAltInterface("pwd_layer@BEGIN") || status.HasZoneAltInterface("pwd_layer@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b6_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b6_CloseBand(spadministration_usersBO BO,ServletStatus status) {
    status.includeZoneAltInterface("pwd_layer@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("pwd_layer")) {
      status.out.println("Ctrl('ZVNKOIBZTJ').style.height='auto';");
    } else {
      status.out.println("Ctrl('ZVNKOIBZTJ').setAttribute('band_height',430);");
    }
    status.out.println("Ctrl('ZVNKOIBZTJ').setAttribute('status','close');");
    status.out.println("tabs_1_configurazioni.AddTab({name:\"ZVNKOIBZTJ\", element:\"ZVNKOIBZTJ_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("ADMIN_DETAILS"),"C",0,0)+",tabIndex: l_nZVNKOIBZTJTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('ZVNKOIBZTJ',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('ZVNKOIBZTJ',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_1',tabs_1_configurazioni.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b7(spadministration_usersBO BO,ServletStatus status) {
    status.out.println(
     "<div name='gruppi_appartenenza' id='FLMCUOBXBF_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' group_id='tabs_1_configurazioni'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nFLMCUOBXBFTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='FLMCUOBXBF' class='TabStripBoxBody' style='position:relative;display:none'>" +
    "");
    status.includeZoneAltInterface("gruppi_appartenenza@BEGIN");
    if (status.includeZoneAltInterface("gruppi_appartenenza")) {
      WriteControls_p1_b7_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("gruppi_appartenenza@BEGIN") || status.HasZoneAltInterface("gruppi_appartenenza@END")) {
        status.out.println(
         "<div id='FLMCUOBXBF_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p1_b7_b0(BO,status);
      WriteControls_p1_b7_b1(BO,status);
      WriteControls_p1_b7_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['FLMCUOBXBF']=['band_1_1215','band_1_1235','band_1_1323'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("gruppi_appartenenza@BEGIN") || status.HasZoneAltInterface("gruppi_appartenenza@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b7_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b7_CloseBand(spadministration_usersBO BO,ServletStatus status) {
    status.includeZoneAltInterface("gruppi_appartenenza@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('FLMCUOBXBF').setAttribute('status','close');");
    status.out.println("tabs_1_configurazioni.AddTab({name:\"FLMCUOBXBF\", element:\"FLMCUOBXBF_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("ADMIN_GROUP_MEMBERSHIP"),"C",0,0)+",tabIndex: l_nFLMCUOBXBFTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('FLMCUOBXBF',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('FLMCUOBXBF',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_1',tabs_1_configurazioni.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b7_b0(spadministration_usersBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_1215' style='position:relative;height:20px;display:block' page='1'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b7_b1(spadministration_usersBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_1235' style='position:relative;display:block' page='1'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='spadministration_usersgroups' id='QGNMFELDBT' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_1_1235']=['QGNMFELDBT'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b7_b2(spadministration_usersBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_1323' style='position:relative;height:15px;display:block' page='1'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b8(spadministration_usersBO BO,ServletStatus status) {
    status.out.println(
     "<div name='box_BGMYNICMON' id='BGMYNICMON_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' group_id='tabs_1_configurazioni'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nBGMYNICMONTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='BGMYNICMON' class='TabStripBoxBody' style='position:relative;height:95px;display:none'>" +
    "");
    status.includeZoneAltInterface("box_BGMYNICMON@BEGIN");
    if (status.includeZoneAltInterface("box_BGMYNICMON")) {
      WriteControls_p1_b8_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("box_BGMYNICMON@BEGIN") || status.HasZoneAltInterface("box_BGMYNICMON@END")) {
        status.out.println(
         "<div id='BGMYNICMON_boxContent' style='position:relative;height:95px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<iframe name='spadministration_ssomap_child' id='VMCLEJEYGM' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
       "</iframe>" +
      "");
      if (status.HasZoneAltInterface("box_BGMYNICMON@BEGIN") || status.HasZoneAltInterface("box_BGMYNICMON@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b8_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b8_CloseBand(spadministration_usersBO BO,ServletStatus status) {
    status.includeZoneAltInterface("box_BGMYNICMON@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("box_BGMYNICMON")) {
      status.out.println("Ctrl('BGMYNICMON').style.height='auto';");
    } else {
      status.out.println("Ctrl('BGMYNICMON').setAttribute('band_height',95);");
    }
    status.out.println("Ctrl('BGMYNICMON').setAttribute('status','close');");
    status.out.println("tabs_1_configurazioni.AddTab({name:\"BGMYNICMON\", element:\"BGMYNICMON_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("CP_SSOID"),"C",0,0)+",tabIndex: l_nBGMYNICMONTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('BGMYNICMON',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('BGMYNICMON',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_1',tabs_1_configurazioni.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['BGMYNICMON']=['VMCLEJEYGM'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b9(spadministration_usersBO BO,ServletStatus status) {
    status.out.println(
     "<div name='box_AXCUQKTKCI' id='AXCUQKTKCI_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' style='display:none' group_id='tabs_1_configurazioni'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nAXCUQKTKCITabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='AXCUQKTKCI' class='TabStripBoxBody' style='position:relative;height:135px;display:none'>" +
    "");
    status.includeZoneAltInterface("box_AXCUQKTKCI@BEGIN");
    if (status.includeZoneAltInterface("box_AXCUQKTKCI")) {
      WriteControls_p1_b9_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("box_AXCUQKTKCI@BEGIN") || status.HasZoneAltInterface("box_AXCUQKTKCI@END")) {
        status.out.println(
         "<div id='AXCUQKTKCI_boxContent' style='position:relative;height:135px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='ZOICKBMQFQ_DIV'>" +
       "<input name='usesiarlicense' id='ZOICKBMQFQ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_usesiarlicense,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("T",CPLib.Trim(BO.w_usesiarlicense))?"CHECKED":"")+">" +
       "<label id='ZOICKBMQFQ_LBL' for='ZOICKBMQFQ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("SPAS_USES_IAR_LICENSE"))+"</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='IAR_LICENSES' id='MHGIWUEDLA' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_IAR_LICENSES,"N",6,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='7' size='6' fieldtype='N'>" +
      "");
      status.out.println(
       "<input name='IAR_USED' id='IQERCSAIWG' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_IAR_USED,"N",6,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='7' size='6' fieldtype='N'>" +
      "");
      status.out.println(
       "<input name='IAR_AVAILABLE' id='RGMQBWZEWR' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_IAR_AVAILABLE,"N",6,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='7' size='6' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FPMYPPWLBO_DIV'>" +
       "<label id='FPMYPPWLBO' for='RGMQBWZEWR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("SPAS_LICENSE_AVAILABLE"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UKIVAGKLUF_DIV'>" +
       "<label id='UKIVAGKLUF' for='IQERCSAIWG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("SPAS_LICENSE_USED"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZKJXQLSILH_DIV'>" +
       "<label id='ZKJXQLSILH' for='MHGIWUEDLA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("SPAS_LICENSE_PURCHASED"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EMQMMHAGNL_DIV'>" +
       "<label id='EMQMMHAGNL'>" +
       ""+SPLib.ToHTMLRepresentation((BO.w_IAR_LICENSE_VALID?"":CPLib.FormatMsg("SPAS_LICENSE_TAMPERED_MSG")))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("box_AXCUQKTKCI@BEGIN") || status.HasZoneAltInterface("box_AXCUQKTKCI@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b9_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b9_CloseBand(spadministration_usersBO BO,ServletStatus status) {
    status.includeZoneAltInterface("box_AXCUQKTKCI@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("box_AXCUQKTKCI")) {
      status.out.println("Ctrl('AXCUQKTKCI').style.height='auto';");
    } else {
      status.out.println("Ctrl('AXCUQKTKCI').setAttribute('band_height',135);");
    }
    status.out.println("Ctrl('AXCUQKTKCI').setAttribute('status','close');");
    status.out.println("tabs_1_configurazioni.AddTab({name:\"AXCUQKTKCI\", element:\"AXCUQKTKCI_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("SPAS_IAR_LICENSE"),"C",0,0)+",tabIndex: l_nAXCUQKTKCITabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('AXCUQKTKCI',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('AXCUQKTKCI',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_1',tabs_1_configurazioni.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
    WriteExtendedCBoxGroupChildren(BO.m_MNTs,status,"configurazioni",1);
  }
  void WriteControls_p1_b10(spadministration_usersBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_END_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_END_OF_PAGE_1' style='position:relative;height:5px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_END_OF_PAGE_1")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_END_OF_PAGE_1').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "</div>" +
      "");
    }
  }
  static void PrintState(spadministration_usersBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(spadministration_usersBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
    if (BO.spadministration_usersgroups.IsUpdated()) {
      BO.m_cWv_spadministration_usersgroups = BO.spadministration_usersgroups.GetContext();
    }
    if (BO.spadministration_ssomap_child.IsUpdated()) {
      BO.m_cWv_spadministration_ssomap_child = BO.spadministration_ssomap_child.GetContext();
    }
    if (BO.spadministration_historypwd.IsUpdated()) {
      BO.m_cWv_spadministration_historypwd = BO.spadministration_historypwd.GetContext();
    }
    if (BO.spadministration_usercompanies.IsUpdated()) {
      BO.m_cWv_spadministration_usercompanies = BO.spadministration_usercompanies.GetContext();
    }
  }
  static void PrintStateWorkVars(spadministration_usersBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_code,"N",9,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_fullname,"C",2048,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_name,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_accesstype_human,"L",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_accesstype_service,"L",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_accesstype_machine,"L",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwdcomplexity,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_forcepwdchange,"L",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_enabled,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_language,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_decimalseparator,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_thousandseparator,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_datepattern,"C",12,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_datetimepattern,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwddaysduration,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwdciclicity,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_captchalevel,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_datestart,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_datestop,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_failedlogins,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_lastfailedlogin,"T",14,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_lastsuccessfullogin,"T",14,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwdcreate,"T",14,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_printserver,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_createdwhen,"T",14,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_usesiarlicense,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_companies,"C",2000,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_modifyPassword,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwd1,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_calcomplex,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwdratecause,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwd2,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwdcomplexity_group,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwdcomplexity_reqired,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_language_name,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwddaysduration_group,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwdciclicity_groups,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwdcaptchalevel_group,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwddaysduration_applied,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwdciclicity_applied,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwdcaptchalevel_applied,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_init_code,"N",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwd_modified,"L",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IAR_LICENSE_VALID,"L",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IAR_LICENSES,"N",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IAR_USED,"N",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IAR_AVAILABLE,"N",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_selected_group,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_g_OTPisActive,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_otp,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_UFENABLEAZI,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwd1_view,"L",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwd2_view,"L",1,0));
    if (CPLib.eq(BO.m_cWv_spadministration_usersgroups,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_spadministration_usersgroups");
    } else if (CPLib.eq(BO.m_cWv_spadministration_usersgroups,"_not_empty_")) {
      BO.m_cWv_spadministration_usersgroups = BO.spadministration_usersgroups.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_spadministration_usersgroups,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_spadministration_usersgroups,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_spadministration_ssomap_child,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_spadministration_ssomap_child");
    } else if (CPLib.eq(BO.m_cWv_spadministration_ssomap_child,"_not_empty_")) {
      BO.m_cWv_spadministration_ssomap_child = BO.spadministration_ssomap_child.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_spadministration_ssomap_child,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_spadministration_ssomap_child,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_spadministration_historypwd,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_spadministration_historypwd");
    } else if (CPLib.eq(BO.m_cWv_spadministration_historypwd,"_not_empty_")) {
      BO.m_cWv_spadministration_historypwd = BO.spadministration_historypwd.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_spadministration_historypwd,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_spadministration_historypwd,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_spadministration_usercompanies,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_spadministration_usercompanies");
    } else if (CPLib.eq(BO.m_cWv_spadministration_usercompanies,"_not_empty_")) {
      BO.m_cWv_spadministration_usercompanies = BO.spadministration_usercompanies.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_spadministration_usercompanies,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_spadministration_usercompanies,"C",0,0));
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(spadministration_usersBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_DRGTXCMDVI = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_PLMVGNNZCG = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_CZUCWOMCIB = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_DJBOUZEOSW = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_EMQMMHAGNL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_DUYHIUNXPN = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_subtitle = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(930,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(900,"N",0,0)+ ";");
    }
    status.out.println("var m_bCalculating = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_nUserCode = " + SPLib.ToJSValue(status.context.UserCode(),"N",0,0)+ ";");
    status.out.println("var m_GroupsList = "+"["+status.context.GetGroupsList()+"]"+";");
    status.out.println("var m_RolesList = "+"["+status.context.GetAuthority().GetCurrentAssignement().GetRoleNames()+"]"+";");
    status.out.println("var m_cCompany = " + SPLib.ToJSValue(status.context.GetCompany(),"C",0,0)+ ";");
    status.out.println("var m_cLanguage = " + SPLib.ToJSValue(status.context.GetLanguage(),"C",0,0)+ ";");
    status.out.println("var m_cUserName = " + SPLib.ToJSValue(status.context.UserName(),"C",0,0)+ ";");
    status.out.println("var m_cAltInterface = " + SPLib.ToJSValue(status.m_cAltInterface,"C",0,0)+ ";");
    status.out.println("var m_cLayerInterface = " + SPLib.ToJSValue(status.m_cLayerInterface,"C",0,0)+ ";");
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"spadministration_users"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'CIUGDDXJMR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"CIUGDDXJMR",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cpusers,"+"default",l_session)+"'"+"]");
      status.out.print(",'XFCGDYJJAR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"XFCGDYJJAR",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cplangs,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'CIUGDDXJMR':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cpusers,"+"default",l_session)+"'"+"]");
      status.out.print(",'XFCGDYJJAR':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cplangs,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    }
    status.out.println("}");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      if (CPLib.IsNull(status.m_CheckVars)) {
        status.out.print("var m_CheckVars={");
        status.out.print("'_':"+SPLib.ToJSValue(GetCheckVars(status, BO, m_cEntityUid),"C",0,0));
        status.out.println("}");
      } else {
        status.out.print("var m_CheckVars=");
        status.m_CheckVars.write(status.out);
        status.out.println(";");
      }
    }
    if (CPLib.eq(status.context.GetGlobalString("IsSPAdministrationInstalled"),"yes") && CPLib.IsAdministrator(status.context) && status.context.HasAdministeredUsers()) {
      status.out.println("var m_cProgName = " + SPLib.ToJSValue(entityGlobals.name,"C",0,0)+ ";");
    } else {
      status.out.println("Zoom.p="+SPLib.ToJSValue(entityGlobals.name,"C",0,0)+";");
    }
    if (CPLib.eq(status.context.GetGlobalString("IsPortalStudioInstalled"),"yes") && SPLib.CanAccessEditor(status.context,"PortalStudio")) {
      status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("spadministration_users","C",0,0)+ ";");
    }
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"spadministration_users",BO.GetCurrentState());
    for (String disabled_item : l_vrtState.DisabledFields().split(",")) {
      if ( ! (CPLib.Empty(disabled_item))) {
        status.quoteAndAppend(disabled_item,"disable","item");
      }
    }
    for (String hidden_item : l_vrtState.HiddenFields().split(",")) {
      if ( ! (CPLib.Empty(hidden_item))) {
        status.quoteAndAppend(hidden_item,"hide","item");
      }
    }
    for (String obligatory_item : l_vrtState.ObligatoryFields().split(",")) {
      if ( ! (CPLib.Empty(obligatory_item))) {
        status.quoteAndAppend(obligatory_item,"obligatory","item");
      }
    }
    for (String disabled_tab : l_vrtState.DisabledTabs().split(",")) {
      if ( ! (CPLib.Empty(disabled_tab))) {
        status.quoteAndAppend(disabled_tab,"disable","tab");
      }
    }
    for (String hidden_tab : l_vrtState.HiddenTabs().split(",")) {
      if ( ! (CPLib.Empty(hidden_tab))) {
        status.quoteAndAppend(hidden_tab,"hide","tab");
      }
    }
    for (String hidden_box : l_vrtState.HiddenBoxes().split(",")) {
      if ( ! (CPLib.Empty(hidden_box))) {
        status.quoteAndAppend(hidden_box,"hide","box");
      }
    }
    for (String disabled_box : l_vrtState.DisabledBoxes().split(",")) {
      if ( ! (CPLib.Empty(disabled_box))) {
        status.quoteAndAppend(disabled_box,"disable","box");
      }
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_BGMYNICMON"),"")) {
      status.quoteAndAppend("box_BGMYNICMON","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_access"),"")) {
      status.quoteAndAppend("box_access","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_WUIVVJMUJT"),"")) {
      status.quoteAndAppend("box_WUIVVJMUJT","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("pwdratecause_layer"),"")) {
      status.quoteAndAppend("pwdratecause_layer","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("complexityreq_layer"),"")) {
      status.quoteAndAppend("complexityreq_layer","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("pwd_layer"),"")) {
      status.quoteAndAppend("pwd_layer","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("durationreq_layer"),"")) {
      status.quoteAndAppend("durationreq_layer","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("ciclicityreq_layer"),"")) {
      status.quoteAndAppend("ciclicityreq_layer","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("captchareq_layer"),"")) {
      status.quoteAndAppend("captchareq_layer","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("language_formatting"),"")) {
      status.quoteAndAppend("language_formatting","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_AXCUQKTKCI"),"")) {
      status.quoteAndAppend("box_AXCUQKTKCI","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("gruppi_appartenenza"),"")) {
      status.quoteAndAppend("gruppi_appartenenza","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("companies_hsect"),"")) {
      status.quoteAndAppend("companies_hsect","hide","box");
    }
    status.PrintStateArrays();
    status.out.println("var m_cFunction = " + SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+ ";");
    status.out.println("var m_cDataLanguage = " + SPLib.ToJSValue(CPLib.Upper(BO.m_Ctx.GetDataLanguage()),"C",0,0)+ ";");
    status.out.println("var m_cOldCPCCCHK = " + SPLib.ToJSValue(BO.m_cOldCPCCCHK,"C",0,0)+ ";");
    status.out.println("var m_bLoaded = " + SPLib.ToJSValue(BO.m_bLoaded,"L",0,0)+ ";");
    status.out.println("var m_cPrvsStt = " + SPLib.ToJSValue(BO.m_cPreviousState,"C",0,0)+ ";");
    status.out.println("var m_FoundlingCopyWorkVar;");
    status.out.println("m_FoundlingCopyWorkVar=[];");
    status.out.println("var m_FoundlingHideExpression;");
    status.out.println("m_FoundlingHideExpression=[];");
    status.out.println("var m_FoundlingEditExpression;");
    status.out.println("m_FoundlingEditExpression=[];");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("var m_nLastError = " + SPLib.ToJSValue(0,"I",0,0)+ ";");
      status.out.println("var m_cObblFieldName = " + SPLib.ToJSValue("","C",0,0)+ ";");
      status.out.println("var m_cLastMsgError = " + SPLib.ToJSValue("","C",0,0)+ ";");
      status.out.println("var m_cLastWorkVarError = " + SPLib.ToJSValue("","C",0,0)+ ";");
      status.out.println("var m_cLastWorkVarErrorMsg = " + SPLib.ToJSValue("","C",0,0)+ ";");
    } else {
      status.out.println("var m_nLastRec = " + SPLib.ToJSValue(status.m_nLastRec,"N",0,0)+ ";");
      status.out.println("var m_nRecPos = " + SPLib.ToJSValue(status.m_nRecPos,"N",0,0)+ ";");
      status.out.println("var m_cVirtName = " + SPLib.ToJSValue(status.m_cVirtName,"C",0,0)+ ";");
      status.out.println("var m_bCan_new = " + SPLib.ToJSValue(SPLib.CanAccess(status.context,"new",entityGlobals.name),"L",0,0)+ ";");
      status.out.println("var m_bCan_edit = " + SPLib.ToJSValue(SPLib.CanAccess(status.context,"edit",entityGlobals.name),"L",0,0)+ ";");
      status.out.println("var m_bCan_delete = " + SPLib.ToJSValue(SPLib.CanAccess(status.context,"delete",entityGlobals.name),"L",0,0)+ ";");
    }
    WriteExtendedFieldsVars(BO.extendedFields,status);
    status.out.println("// * --- Area Manuale = UI - Declare Variables");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteMainFormScript(spadministration_usersBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- spadministration_users");
    status.out.println("    if(Empty(w_companies)){");
    status.out.println("      //Set_UFENABLEAZI('n');");
    status.out.println("      w_UFENABLEAZI='n';");
    status.out.println("    }else{");
    status.out.println("      //Set_UFENABLEAZI('s');");
    status.out.println("      w_UFENABLEAZI='s';");
    status.out.println("      //Decodifico la stringa");
    status.out.println("      // w_ListCompanies=spadministration_user_decodecompanies(w_companies);");
    status.out.println("      // w_companies è del tipo A,B,C,D");
    status.out.println("      // w_grdcompanies.raiseEvent('Ricarica',{pElcomp:w_companies});");
    status.out.println("    }");
    status.out.println("    SetControlsValue();");
    status.out.println("");
    status.out.println("// * --- Fine Area Manuale");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"ADMIN_GENERALE")) {
      status.out.println("Z.Tabs.Get('tabs').InitSelect('spadministration_users',false);");
    } else {
      status.out.println("calculateSidebarBandsPosition('page_1');");
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
      status.out.println("SetCollapsibleCaptions();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('CIUGDDXJMR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YOMCOSHNCV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZOLPGDGKUC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RGNPWADGHN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GZOGXZQGVV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GSXRFLFMJR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FTIRRMMSXK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GMYTSOEEXH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KIBLXEYDCR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TBXREXYXIU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YDSHUIXYEH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RRBOVTXUAU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GNSADWOGKM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XFCGDYJJAR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IZJFQHGQUB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ACYLERWDKK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EVNGTHPGLR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BOLWRICGIA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NTAYXBDPVY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CLZCOSTIAC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WLRWPELGIS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DWGQEAJBOS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DWGQEAJBOS_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AFHAPKTVTZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AFHAPKTVTZ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BLGCNCYQRJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZOICKBMQFQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XNDAWTQDZS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UOJLIHOZBH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UYGLGETTUT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VRCQKXWFPX')) SetDisabled(c,true);");
      }
      status.out.println("HideControlsUnderCondition();");
      status.out.println("SetCollapsibleCaptions();");
      status.out.println("ExpandCollapseBoxesUnderCondition();");
    }
    status.out.println("if ( ! (Empty(m_cLayerInterface))) {");
    status.out.println("SubstituteInterface(m_cLayerInterface);");
    status.out.println("}");
    if (status.m_bError) {
      status.out.println("HideLoadingLayer();");
      status.out.println("WindowAlert(showed_database_error);");
      status.out.println("HideLoadingLayer(false);");
    }
    if ( ! (status.m_bHasRS)) {
      status.out.println("SetRegionalSettings();");
    }
    status.out.println("ReloadMenu();");
    status.out.println("setEventHandlers(false);");
    if (CPLib.ne(status.m_cClientMode,"view")) {
      status.out.println("FocusFirstComponent();");
    }
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      status.out.println("if (Ctrl('QGNMFELDBT')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('QGNMFELDBT',linkpc_url('QGNMFELDBT'));");
      status.out.println("}");
      status.out.println("if (Ctrl('VMCLEJEYGM')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('VMCLEJEYGM',linkpc_url('VMCLEJEYGM'));");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('CIUGDDXJMR')) SetDisabled(c,true);");
      }
    }
    status.out.println("FillCombosValues();");
    status.out.println("SetControlsValue();");
    status.out.println("NotifyEvent('Record Loaded');");
    status.out.println("LoadContext();");
    status.out.println("// * --- Area Manuale = UI - OnLoad End");
    status.out.println("// * --- spadministration_users");
    status.out.println("if (EntityStatus()=='E')");
    status.out.println("  w_pwd_modified=false;");
    status.out.println("else if (EntityStatus()=='N')");
    status.out.println("  w_pwd_modified=true;");
    status.out.println("");
    status.out.println("// * --- Fine Area Manuale");
    RaiseLoadedEntity(BO,status);
    status.out.println("CalculateAndResizeEntityHeight();");
    status.out.println("HideLoadingLayer();");
    if (status.is_live_editing) {
      status.out.println("CreateAltInterfaceEditTool(" + SPLib.ToJSValue(entityGlobals.name,"C",0,0) + ");");
    }
    if (status.m_bShowBOWarnings) {
      status.out.println("SubmitListenerForm(" + SPLib.ToJSValue(status.m_cAction,"C",0,0) + ");");
    }
    status.out.println("}");
    status.out.println("function ChildSelectedPage(name) {");
    status.out.println("var l_cRes = '';");
    status.out.println("if (Eq(name,'spadministration_usersgroups')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"spadministration_usersgroups")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'spadministration_ssomap_child')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"spadministration_ssomap_child")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    ChildSelectedPageChild(BO.m_MNTs,status,status.m_cSelectedPage);
    status.out.println("}");
    WriteJSError(status);
    WriteTableCombo(status,BO);
    status.out.println("// * --- Area Manuale = UI - Functions & Procedures");
    status.out.println("// * --- spadministration_users");
    status.out.println("function SPAdmin_makeanchor() {");
    status.out.println("  if (m_cSelectedPage=='page_2')");
    status.out.println("    return 'spadministration_usersgroups';");
    status.out.println("  else");
    status.out.println("    return 'spadministration_users';");
    status.out.println("}");
    status.out.println("");
    status.out.println("function togglePwdView(uid) {");
    status.out.println("  var c;");
    status.out.println("  if (uid == 1) {");
    status.out.println("    c = 'GMYTSOEEXH';");
    status.out.println("  } else if (uid == 2) {");
    status.out.println("    c = 'KIBLXEYDCR';");
    status.out.println("  }");
    status.out.println("  if (uid) {");
    status.out.println("    var input = document.getElementById(c);");
    status.out.println("    if (input.type === 'password') {");
    status.out.println("      input.type = 'text';");
    status.out.println("      window['w_pwd' + uid + '_view'] = true;");
    status.out.println("    } else {");
    status.out.println("      input.type = 'password';");
    status.out.println("      window['w_pwd' + uid + '_view'] = false;");
    status.out.println("    }");
    status.out.println("  }");
    status.out.println("  HideControlsUnderCondition();");
    status.out.println("}");
    status.out.println("function setPasswordType() {");
    status.out.println("  var input = document.getElementById('GMYTSOEEXH');");
    status.out.println("  input.type = 'password';");
    status.out.println("  input = document.getElementById('KIBLXEYDCR');");
    status.out.println("  input.type = 'password';");
    status.out.println("  w_pwd1_view = w_pwd2_view = false;");
    status.out.println("}");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  spadministration_usersBO getBO(ServletStatus status) {
    spadministration_usersBO BO = new spadministration_usersBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(spadministration_usersBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("cpusers",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,spadministration_usersBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,spadministration_usersBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_cplangs,CPSql.BuildSQLPhrase("code,name",BO.m_cPhName_cplangs,"","name"));
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",3,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("code"),"C",3,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("name"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var XFCGDYJJAR_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(spadministration_usersBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_cpusers;
    String l_cPhName = BO.m_cPhName_cpusers;
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    // * --- Area Manuale = BO - Query Key Set Init
    // * --- Fine Area Manuale
    int l_nIdx;
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = spadministration_usersBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_cpusers+".code",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    } else {
      l_rsKeys = new CPResultSet();
    }
    l_nIdx = 1;
    while (CPLib.lt(l_nIdx,status.m_nRecPos) &&  ! (l_rsKeys.Eof())) {
      l_rsKeys.Next();
      l_nIdx = l_nIdx+1;
    }
    // * --- Area Manuale = BO - Query Key Set End
    // * --- Fine Area Manuale
    return l_rsKeys;
  }
  CPResultSet QueryKeyCursor(SPMasterServletStatus status) {
    String l_cServer = status.context.GetServer("cpusers");
    String l_cPhName = CPSql.ManipulateTablePhName("cpusers",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".code",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,spadministration_usersBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = spadministration_usersBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_cpusers,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_cpusers,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
      try {
        status.m_nLastRec = l_rsCount.GetInt("reccount");
        if (CPLib.eq(status.m_nLastRec,0)) {
          status.m_nRecPos = 0;
        } else {
          status.m_nRecPos = 1;
        }
      } finally {
        l_rsCount.Close();
      }
    } else {
      status.m_nRecPos = 0;
      status.m_nLastRec = 0;
    }
    status.m_cMode = "";
  }
  void View(ServletStatus status,spadministration_usersBO BO) {
    String _m = status.m_cMode;
    if ( ! (BO.m_bLoaded)) {
      Query(status,BO);
      LoadCurrentRecord(status,BO);
    }
    if ( ! (status.m_bError) &&  ! (BO.m_bLoaded) && CPLib.ne(_m,"empty")) {
      status.m_cErrMsg = "MSG_RECORD_NOT_FOUND";
      status.m_bError = true;
      status.m_bExit = true;
      if ( ! (CPLib.Empty(status.m_cAtExit)) && HasMarker(status,"@ERROR")) {
        // valorizzazione dei placeholder del workflow: qui e' gia' valorizzato status.m_cErrMsg
        SetWorkflowPlaceholders(status,BO);
      }
    } else {
      NotifyEvent("View",status,BO);
    }
    status.m_cClientMode = "view";
  }
  void Edit(ServletStatus status,spadministration_usersBO BO,SPParameterSource source) {
    BO.Load(status.w_code);
    if (BO.m_bLoaded && BO.CanEdit()) {
      NotifyEvent("Edit Started",status,BO);
      // A valle dela NotifyEvent imposto le variabili passate da hyperlink e simili
      if (SetPassedWorkVars(status,BO,source,entityGlobals.keyColumns)) {
        // Posso <dimenticare> che m_cMode="hyperlink"
        status.m_cMode = "edit";
        status.m_cClientMode = "edit";
      } else {
        status.m_cClientMode = "error";
      }
    } else {
      if (BO.m_bLoaded) {
        status.m_cErrMsg = (CPLib.Empty(BO.LastErrorMessage())?"":BO.LastErrorMessage());
      } else {
        status.m_cErrMsg = "MSG_RECORD_NOT_FOUND";
      }
      status.m_bError = true;
      status.m_bExit = true;
      status.m_cClientMode = "query";
      if ( ! (CPLib.Empty(status.m_cAtExit)) && HasMarker(status,"@ERROR")) {
        status.m_bExit = true;
        // valorizzazione dei placeholder del workflow: qui e' gia' valorizzato status.m_cErrMsg
        SetWorkflowPlaceholders(status,BO);
      }
    }
    if ( ! (CPLib.IsNull(source)) && source.Has("m_OnlyContext")) {
      status.m_cClientMode = "bringback";
    }
  }
  void New(ServletStatus status,spadministration_usersBO BO,SPParameterSource source) {
    BO.Initialize();
    if (BO.CanAdd()) {
      NotifyEvent("New record",status,BO);
      // A valle della NotifyEvent imposto le variabili passate da hyperlink e simili
      if (CPLib.IsNull(source) || SetPassedWorkVars(status,BO,source)) {
        // Posso <dimenticare> che m_cMode="hyperlink"
        status.m_cMode = "new";
        status.m_cClientMode = "new";
      } else {
        status.m_cClientMode = "error";
      }
    } else {
      status.m_cErrMsg = BO.m_cLastMsgError;
      status.m_bError = true;
      status.m_bExit = true;
      status.m_cClientMode = "query";
      if ( ! (CPLib.Empty(status.m_cAtExit)) && HasMarker(status,"@ERROR")) {
        status.m_bExit = true;
        // valorizzazione dei placeholder del workflow: qui e' gia' valorizzato status.m_cErrMsg
        SetWorkflowPlaceholders(status,BO);
      }
    }
    if ( ! (CPLib.IsNull(source)) && source.Has("m_OnlyContext")) {
      status.m_cClientMode = "bringback";
    }
  }
  void Write(ServletStatus status,spadministration_usersBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    String l_cTransMsgErr = "";
    if (HasAllKeys(status,source)) {
      Edit(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"write")) {
      status.m_bError = true;
      status.m_cClientMode = "error";
      status.m_cErrMsg = "MSG_WRITE_FAILED_FOR_KEY";
    }
    if ( ! (BO.m_bLoaded) && CPLib.eq(status.m_cAction,"writeload")) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      New(status,BO,source);
    }
    if ( ! (status.m_bError)) {
      l_bResult = BO.CanSave();
      l_bResult = l_bResult && BO.BRCanSave();
      if (l_bResult) {
        BO.m_Sql.BeginTransaction();
        l_bResult = BO.Save(true);
        l_cTrsMsgErr = BO.m_Sql.TransactionErrorMessage();
        l_bTrsOk = BO.m_Sql.EndTransaction();
        if (l_bResult && l_bTrsOk && BO.IsUpdated()) {
          if (BO.m_bLoaded) {
            BO.NotifyEvent("Record Updated");
          } else {
            BO.NotifyEvent("Record Inserted");
          }
        }
      }
      if (l_bTrsOk && l_bResult) {
        status.m_bExit = true;
        status.m_cClientMode = "query";
      } else {
        status.m_bError = true;
        status.m_cClientMode = "error";
        if ( ! (l_bTrsOk)) {
          // Gestione dell'errore di transazione
          if (CPLib.ne(l_cTrsMsgErr,"")) {
            status.m_cErrMsg = l_cTrsMsgErr;
          }
        } else if ( ! (l_bResult)) {
          CheckErrorToBrowser(BO.m_nLastError,BO.LastErrorMessage(),status);
        }
      }
    }
    // la write non ha parte visuale
    status.m_cClientMode = "bringback";
  }
  void LoadCurrentRecord(ServletStatus status,spadministration_usersBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_code = 0;
      } else {
        BO.w_code = l_rsKeys.GetDouble("code");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_code = BO.w_code;
      }
    } finally {
      // In ogni evenienza bisogna liberare la connessione del database
      l_rsKeys.Close();
    }
    status.m_cClientMode = "query";
    if (BO.m_bLoaded &&  ! (BO.CanView())) {
      status.m_cErrMsg = BO.LastErrorMessage();
      status.m_bError = true;
      status.m_bExit = true;
      if ( ! (CPLib.Empty(status.m_cAtExit)) && HasMarker(status,"@ERROR")) {
        // valorizzazione dei placeholder del workflow: qui e' gia' valorizzato status.m_cErrMsg
        SetWorkflowPlaceholders(status,BO);
      }
    }
  }
  void EditLoad(ServletStatus status,spadministration_usersBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,spadministration_usersBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_code);
      l_cTrsMsgErr = BO.m_Sql.TransactionErrorMessage();
      l_bTrsOk = BO.m_Sql.EndTransaction();
      if (l_bResult && l_bTrsOk) {
        BO.NotifyEvent("Record Deleted");
        status.m_bBODeleted = true;
      }
      status.m_cClientMode = "query";
      if (l_bTrsOk) {
        if (CPLib.gt(status.m_nLastRec,1)) {
          if (CPLib.eq(status.m_nRecPos,status.m_nLastRec)) {
            status.m_nRecPos = status.m_nRecPos-1;
          }
          status.m_nLastRec = status.m_nLastRec-1;
          LoadCurrentRecord(status,BO);
        } else {
          status.m_nLastRec = 0;
          status.m_nRecPos = 0;
          BO.Blank();
        }
      } else {
        status.m_bError = true;
        // Gestione dell'errore di transazione
        if (CPLib.ne(l_cTrsMsgErr,"")) {
          status.m_cErrMsg = l_cTrsMsgErr;
        }
      }
      status.m_bExit = true;
    } else {
      status.m_bError = true;
      status.m_cClientMode = "error";
      status.m_cErrMsg = "MSG_DELETE_FAILED_FOR_KEY";
    }
    if ( ! (l_bResult) &&  ! (CPLib.Empty(status.m_cAtExit)) && HasMarker(status,"@ERROR")) {
      status.m_bExit = true;
      // valorizzazione dei placeholder del workflow: qui e' gia' valorizzato status.m_cErrMsg
      SetWorkflowPlaceholders(status,BO);
    } else if (l_bBringBack) {
      status.m_cClientMode = "bringback";
    }
  }
  void DeleteMessage(ServletStatus status,spadministration_usersBO BO,SPParameterSource source) {
    BO.Load(status.w_code);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,spadministration_usersBO BO) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    String l_cTransMsgErr = "";
    BO.SetFromContext(status.m_cWv,status.m_Parameters);
    if (CheckVars(status,BO)) {
      if (( ! (BO.IsLoaded()) || status.CheckOP(BO.m_cOldCPCCCHK))) {
        l_bResult = BO.CanSave();
        l_bResult = l_bResult && BO.BRCanSave();
        if (l_bResult) {
          BO.m_Sql.BeginTransaction();
          l_bResult = BO.Save(true);
          l_cTrsMsgErr = BO.m_Sql.TransactionErrorMessage();
          l_bTrsOk = BO.m_Sql.EndTransaction();
          if (l_bResult && l_bTrsOk && BO.IsUpdated()) {
            if (BO.m_bLoaded) {
              BO.NotifyEvent("Record Updated");
            } else {
              BO.NotifyEvent("Record Inserted");
            }
          }
        }
      } else {
        BO.m_cLastMsgError = "MSG_LOOK_INTO_COUNTERS";
        BO.m_nLastError = 0;
        l_bResult = false;
      }
    } else {
      status.m_bError = true;
      status.m_bExit = true;
      status.m_cMode = "error";
      BO.m_cLastMsgError = "MSG_ERROR_SAVING_CONFIG";
      BO.m_nLastError = 0;
      l_bResult = false;
    }
    if (l_bTrsOk && l_bResult) {
      status.m_bExit = true;
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({code:"+SPLib.ToJSValue(BO.w_code,"N",9,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
      // valorizzazione dei placeholder del workflow: l'Initialize cancella i valori nel BO e solo in questo punto conosco i valori di campi in chiave sottoposti ad autonumber
      SetWorkflowPlaceholders(status,BO);
      if (CPLib.eq(status.m_cMode,"new")) {
        if (CPLib.ne(CPLib.Left(status.m_cAtExit,5),"close") && CPLib.ne(status.m_cAtExit,"edit")) {
          New(status,BO,null);
        }
      } else {
        status.m_cClientMode = "query";
      }
    } else {
      status.m_bError = true;
      status.m_cClientMode = status.m_cMode;
      if ( ! (l_bTrsOk)) {
        // Gestione dell'errore di transazione
        if (CPLib.ne(l_cTrsMsgErr,"")) {
          status.m_cErrMsg = l_cTrsMsgErr;
        }
      } else if ( ! (l_bResult)) {
        CheckErrorToBrowser(BO.m_nLastError,BO.LastErrorMessage(),status);
      }
      if ( ! (CPLib.Empty(status.m_cAtExit)) && HasMarker(status,"@ERROR")) {
        status.m_bExit = true;
        // valorizzazione dei placeholder del workflow: qui e' gia' valorizzato status.m_cErrMsg
        SetWorkflowPlaceholders(status,BO);
      }
    }
  }
  void Discard(ServletStatus status,spadministration_usersBO BO) {
    BO.SetFromContext(status.m_cWv,status.m_Parameters);
    if (CPLib.eq(status.m_cMode,"edit")) {
      NotifyEvent("Edit Aborted",status,BO);
    }
    // valorizzazione dei placeholder del workflow: la blank puo' cancellare i valori preesistenti
    SetWorkflowPlaceholders(status,BO);
    if (CPLib.eq(status.m_cMode,"new")) {
      NotifyEvent("New record aborted",status,BO);
      BO.Blank();
    } else if (CPLib.eq(status.m_cMode,"edit") && CPLib.ne(CPLib.Left(status.m_cAtExit,5),"close") && CPLib.ne(status.m_cAtExit,"autozoom")) {
      LoadCurrentRecord(status,BO);
    }
    status.m_cClientMode = "query";
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,spadministration_usersBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",1573);
    item.put("w",900);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","true");
    org.json.JSONObject pageProp = null;
    org.json.JSONArray pagesProp = null;
    pagesProp = new org.json.JSONArray();
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"ADMIN_GENERALE\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","ADMIN_GENERALE");
    item.put("altInterfaceFor","spadministration_users");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_ZRXEDHLHRU\",\"page\":1,\"spuid\":\"ZRXEDHLHRU\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"ADMIN_CODE\",\"w\":196,\"x\":5,\"y\":20,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"ADMIN_CODE\",\"h\":25,\"maxlength\":12,\"name\":\"code\",\"page\":1,\"spuid\":\"CIUGDDXJMR\",\"tabindex\":5,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":76,\"x\":210,\"y\":20,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_GONJPLYFCM\",\"page\":1,\"spuid\":\"GONJPLYFCM\",\"tabindex\":6,\"type\":\"Label\",\"value\":\"ADMIN_FULLNAME\",\"w\":196,\"x\":5,\"y\":55,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_FULLNAME\",\"h\":25,\"maxlength\":2048,\"name\":\"fullname\",\"page\":1,\"spuid\":\"YOMCOSHNCV\",\"tabindex\":7,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":374,\"x\":210,\"y\":55,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_LWKHSAVZHT\",\"page\":1,\"spuid\":\"LWKHSAVZHT\",\"tabindex\":8,\"type\":\"Label\",\"value\":\"ADMIN_LOGIN\",\"w\":196,\"x\":5,\"y\":90,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_NAME\",\"h\":25,\"maxlength\":50,\"name\":\"name\",\"page\":1,\"spuid\":\"ZOLPGDGKUC\",\"tabindex\":9,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":374,\"x\":210,\"y\":90,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_access\",\"box_type\":\"titled_box\",\"comment\":\"Access\",\"h\":95,\"name\":\"box_access\",\"page\":1,\"shrinkable\":true,\"spuid\":\"KVIFRCSRUG\",\"tabindex\":10,\"title_caption\":\"Access\",\"titled\":true,\"type\":\"Box\",\"w\":175,\"x\":603,\"y\":10,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"true\",\"comment\":\"&Human\",\"h\":23,\"label_text\":\"Human\",\"maxlength\":1,\"name\":\"accesstype_human\",\"page\":1,\"spuid\":\"RGNPWADGHN\",\"tabindex\":11,\"type\":\"Checkbox\",\"typevar\":\"logic\",\"unchecked_value\":\"false\",\"w\":150,\"x\":615,\"y\":24,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"true\",\"comment\":\"&Service\",\"h\":23,\"label_text\":\"Service\",\"maxlength\":1,\"name\":\"accesstype_service\",\"page\":1,\"spuid\":\"GZOGXZQGVV\",\"tabindex\":12,\"type\":\"Checkbox\",\"typevar\":\"logic\",\"unchecked_value\":\"false\",\"w\":150,\"x\":615,\"y\":49,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"true\",\"comment\":\"&Machine\",\"h\":23,\"label_text\":\"Machine\",\"maxlength\":1,\"name\":\"accesstype_machine\",\"page\":1,\"spuid\":\"GSXRFLFMJR\",\"tabindex\":13,\"type\":\"Checkbox\",\"typevar\":\"logic\",\"unchecked_value\":\"false\",\"w\":150,\"x\":615,\"y\":74,\"zone\":\"pag1_4_3\",\"zonepath\":\"[1,4,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_WUIVVJMUJT\",\"box_type\":\"auto_horizontal_section\",\"collapsible\":true,\"h\":30,\"name\":\"box_WUIVVJMUJT\",\"page\":1,\"shrinkable\":true,\"spuid\":\"WUIVVJMUJT\",\"stretch\":true,\"tabindex\":14,\"type\":\"Box\",\"w\":890,\"x\":5,\"y\":120,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"h\":23,\"label_text\":\"MSG_ENABLE_MODIFY_PASSWORD\",\"maxlength\":2,\"name\":\"modifyPassword\",\"page\":1,\"spuid\":\"FTIRRMMSXK\",\"tabindex\":15,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":375,\"x\":210,\"y\":124,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_YYYRCYYISO\",\"page\":1,\"spuid\":\"YYYRCYYISO\",\"tabindex\":16,\"type\":\"Label\",\"value\":\"Password\",\"w\":196,\"x\":5,\"y\":155,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Password\",\"h\":25,\"maxlength\":20,\"name\":\"pwd1\",\"page\":1,\"spuid\":\"GMYTSOEEXH\",\"tabindex\":17,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":153,\"x\":210,\"y\":155,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_ZZKRWOJQTG\",\"page\":1,\"spuid\":\"ZZKRWOJQTG\",\"src\":\"..\\/{\\\"Char\\\":\\\"61550\\\",\\\"Color\\\":\\\"#808080\\\",\\\"FontName\\\":\\\"fontawesome-webfont\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"15\\\"}\",\"tabindex\":18,\"type\":\"Image\",\"w\":20,\"x\":365,\"y\":158,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"comment\":\"Il livello di complessit\\u00E0 della password inserita\",\"h\":25,\"name\":\"label_QEXYRQXFGY\",\"page\":1,\"spuid\":\"QEXYRQXFGY\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"ADMIN_PWDCOMPLEXITY\",\"w\":140,\"x\":387,\"y\":155,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_PWDCOMPLEXITY\",\"disabled\":\"true\",\"h\":25,\"maxlength\":4,\"name\":\"calcomplex\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"ZDDZZTSQYG\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":29,\"x\":531,\"y\":155,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"button_KZXLYHJHAW\",\"page\":1,\"picker\":true,\"spuid\":\"KZXLYHJHAW\",\"tabindex\":21,\"type\":\"Button\",\"value\":\"...\",\"w\":18,\"x\":589,\"y\":155,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_MAXIMUM\",\"h\":25,\"name\":\"label_DRGTXCMDVI\",\"page\":1,\"spuid\":\"DRGTXCMDVI\",\"tabindex\":22,\"type\":\"Label\",\"w\":26,\"x\":561,\"y\":155,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_OSVFPWEFJH\",\"page\":1,\"spuid\":\"OSVFPWEFJH\",\"src\":\"..\\/{\\\"Char\\\":\\\"61552\\\",\\\"Color\\\":\\\"#808080\\\",\\\"FontName\\\":\\\"fontawesome-webfont\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"15\\\"}\",\"tabindex\":120,\"type\":\"Image\",\"w\":20,\"x\":365,\"y\":158,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_NXPUKKLWAT\",\"page\":1,\"spuid\":\"NXPUKKLWAT\",\"tabindex\":25,\"type\":\"Label\",\"value\":\"MSG_CONFIRM_PASSWORD\",\"w\":196,\"x\":5,\"y\":190,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"MSG_CONFIRM_PASSWORD\",\"h\":25,\"maxlength\":20,\"name\":\"pwd2\",\"page\":1,\"spuid\":\"KIBLXEYDCR\",\"tabindex\":26,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":153,\"x\":210,\"y\":190,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"comment\":\"Il livello minimo di complessit\\u00E0 della password\",\"h\":25,\"name\":\"label_GRPBSLBHXA\",\"page\":1,\"spuid\":\"GRPBSLBHXA\",\"tabindex\":27,\"type\":\"Label\",\"value\":\"ADMIN_PWDCOMPLEXITY_MINIMUM\",\"w\":139,\"x\":388,\"y\":190,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_OTBBXDQDET\",\"page\":1,\"spuid\":\"OTBBXDQDET\",\"src\":\"..\\/{\\\"Char\\\":\\\"61550\\\",\\\"Color\\\":\\\"#808080\\\",\\\"FontName\\\":\\\"fontawesome-webfont\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"15\\\"}\",\"tabindex\":28,\"type\":\"Image\",\"w\":20,\"x\":365,\"y\":193,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_PWDCOMPLEXITY\",\"disabled\":\"true\",\"h\":25,\"maxlength\":4,\"name\":\"pwdcomplexity_reqired\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"EJKRLFXEIY\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":29,\"x\":531,\"y\":190,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"button_LCHPBEJNON\",\"page\":1,\"picker\":true,\"spuid\":\"LCHPBEJNON\",\"tabindex\":35,\"type\":\"Button\",\"value\":\"...\",\"w\":18,\"x\":589,\"y\":190,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_MAXIMUM\",\"h\":25,\"name\":\"label_CZUCWOMCIB\",\"page\":1,\"spuid\":\"CZUCWOMCIB\",\"tabindex\":36,\"type\":\"Label\",\"w\":26,\"x\":561,\"y\":190,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_XEGRJMWYIW\",\"page\":1,\"spuid\":\"XEGRJMWYIW\",\"src\":\"..\\/{\\\"Char\\\":\\\"61552\\\",\\\"Color\\\":\\\"#808080\\\",\\\"FontName\\\":\\\"fontawesome-webfont\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"15\\\"}\",\"tabindex\":121,\"type\":\"Image\",\"w\":20,\"x\":365,\"y\":193,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"complexityreq_layer\",\"box_type\":\"layer\",\"comment\":\"ADMIN_REQUIRED_COMPLEXITY\",\"fixed\":true,\"h\":102,\"name\":\"complexityreq_layer\",\"page\":1,\"shrinkable\":true,\"spuid\":\"PBZCUWPENC\",\"tabindex\":29,\"title_caption\":\"ADMIN_REQUIRED_COMPLEXITY\",\"type\":\"Box\",\"w\":330,\"x\":980,\"y\":95,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"container\":\"PBZCUWPENC\",\"h\":25,\"name\":\"label_WNFOFUHXXF\",\"page\":1,\"spuid\":\"WNFOFUHXXF\",\"tabindex\":30,\"type\":\"Label\",\"value\":\"ADMIN_PWDCOMPLEXITY_GROUP\",\"w\":173,\"x\":1085,\"y\":115,\"zone\":\"pag1_8_1\",\"zonepath\":\"[1,8,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_PWDCOMPLEXITY\",\"container\":\"PBZCUWPENC\",\"h\":25,\"maxlength\":4,\"name\":\"pwdcomplexity_group\",\"page\":1,\"spuid\":\"TBXREXYXIU\",\"tabindex\":31,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":34,\"x\":1261,\"y\":115,\"zone\":\"pag1_8_1\",\"zonepath\":\"[1,8,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"container\":\"PBZCUWPENC\",\"h\":25,\"name\":\"label_XCVHSJEHUH\",\"page\":1,\"spuid\":\"XCVHSJEHUH\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"ADMIN_PWDCOMPLEXITY_USER\",\"w\":173,\"x\":1085,\"y\":150,\"zone\":\"pag1_8_2\",\"zonepath\":\"[1,8,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"ADMIN_PWDCOMPLEXITY\",\"container\":\"PBZCUWPENC\",\"h\":25,\"maxlength\":4,\"name\":\"pwdcomplexity\",\"page\":1,\"spuid\":\"YDSHUIXYEH\",\"tabindex\":33,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":34,\"x\":1261,\"y\":150,\"zone\":\"pag1_8_2\",\"zonepath\":\"[1,8,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"True\",\"comment\":\"ADMIN_FORCEPWDCHANGE\",\"h\":25,\"label_text\":\"ADMIN_FORCEPWDCHANGE\",\"maxlength\":1,\"name\":\"forcepwdchange\",\"page\":1,\"spuid\":\"RRBOVTXUAU\",\"tabindex\":37,\"type\":\"Checkbox\",\"typevar\":\"logic\",\"unchecked_value\":\"False\",\"w\":374,\"x\":210,\"y\":225,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"D"+"'"+"\",\"comment\":\"ADMIN_DISABLED\",\"h\":25,\"label_text\":\"ADMIN_DISABLED\",\"maxlength\":1,\"name\":\"enabled\",\"page\":1,\"spuid\":\"GNSADWOGKM\",\"tabindex\":38,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"E"+"'"+"\",\"w\":374,\"x\":210,\"y\":260,\"zone\":\"pag1_10\",\"zonepath\":\"[1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"ADMIN_LANGUAGE\",\"h\":25,\"maxlength\":3,\"name\":\"language\",\"page\":1,\"spuid\":\"XFCGDYJJAR\",\"tabindex\":39,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":150,\"x\":210,\"y\":295,\"zone\":\"pag1_11\",\"zonepath\":\"[1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_UKIHMTALYE\",\"page\":1,\"spuid\":\"UKIHMTALYE\",\"tabindex\":40,\"type\":\"Label\",\"value\":\"ADMIN_LANGUAGE\",\"w\":195,\"x\":5,\"y\":295,\"zone\":\"pag1_11\",\"zonepath\":\"[1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"companies_hsect\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"CP_COMPANIES\",\"h\":250,\"name\":\"companies_hsect\",\"page\":1,\"shrinkable\":true,\"spuid\":\"GWZDNNWFFM\",\"stretch\":true,\"tabindex\":117,\"title_caption\":\"CP_COMPANIES\",\"titled\":true,\"type\":\"Box\",\"w\":830,\"x\":0,\"y\":360,\"zone\":\"pag1_12\",\"zonepath\":\"[1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":221,\"name\":\"grdCompanies\",\"page\":1,\"spuid\":\"OBAKOPSMDI\",\"src\":\"\\/jsp-system\\/spadministration_users_companies_portlet.jsp?ForcedPortletUID=OBAKOPSMDI\",\"tabindex\":91,\"type\":\"Portlet\",\"w\":795,\"x\":20,\"y\":370,\"zone\":\"pag1_12_1\",\"zonepath\":\"[1,12,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"language_formatting\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Formattazione\",\"groupName\":\"configurazioni\",\"h\":170,\"name\":\"language_formatting\",\"page\":1,\"shrinkable\":true,\"spuid\":\"QZSVKXVUQD\",\"stretch\":true,\"tabindex\":96,\"title_caption\":\"Formattazione\",\"titled\":true,\"type\":\"Box\",\"w\":830,\"x\":0,\"y\":615,\"zone\":\"pag1_13\",\"zonepath\":\"[1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\"spadminNoPadding\",\"h\":25,\"maxlength\":3,\"name\":\"decimalseparator\",\"page\":1,\"spuid\":\"IZJFQHGQUB\",\"tabindex\":42,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":210,\"y\":630,\"zone\":\"pag1_13_1\",\"zonepath\":\"[1,13,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\"spadminNoPadding\",\"h\":25,\"maxlength\":3,\"name\":\"thousandseparator\",\"page\":1,\"spuid\":\"ACYLERWDKK\",\"tabindex\":43,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":210,\"y\":665,\"zone\":\"pag1_13_1\",\"zonepath\":\"[1,13,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"label_DJBOUZEOSW\",\"page\":1,\"spuid\":\"DJBOUZEOSW\",\"tabindex\":92,\"type\":\"Label\",\"w\":195,\"x\":335,\"y\":665,\"zone\":\"pag1_13_1\",\"zonepath\":\"[1,13,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":18,\"name\":\"label_HUODVPIWHU\",\"page\":1,\"spuid\":\"HUODVPIWHU\",\"tabindex\":93,\"type\":\"Label\",\"value\":\"ADMIN_DECIMAL_SEPARATOR\",\"w\":195,\"x\":5,\"y\":637,\"zone\":\"pag1_13_1\",\"zonepath\":\"[1,13,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":18,\"name\":\"label_ADDXUTCFVF\",\"page\":1,\"spuid\":\"ADDXUTCFVF\",\"tabindex\":107,\"type\":\"Label\",\"value\":\"ADMIN_THOUSAND_SEPARATOR\",\"w\":206,\"x\":-6,\"y\":672,\"zone\":\"pag1_13_1\",\"zonepath\":\"[1,13,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":18,\"name\":\"label_HOTCYSDBTM\",\"page\":1,\"spuid\":\"HOTCYSDBTM\",\"tabindex\":108,\"type\":\"Label\",\"value\":\"ADMIN_SEPARATOR_EXAMPLE\",\"w\":85,\"x\":245,\"y\":672,\"zone\":\"pag1_13_1\",\"zonepath\":\"[1,13,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"ADMIN_DATEPATTERN\",\"h\":25,\"maxlength\":12,\"name\":\"datepattern\",\"page\":1,\"spuid\":\"EVNGTHPGLR\",\"tabindex\":44,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":97,\"x\":210,\"y\":700,\"zone\":\"pag1_13_2\",\"zonepath\":\"[1,13,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_VCIJYACAFD\",\"page\":1,\"spuid\":\"VCIJYACAFD\",\"tabindex\":94,\"type\":\"Label\",\"value\":\"ADMIN_DATEPATTERN\",\"w\":195,\"x\":5,\"y\":700,\"zone\":\"pag1_13_2\",\"zonepath\":\"[1,13,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"ADMIN_DATETIMEPATTERN\",\"h\":25,\"maxlength\":25,\"name\":\"datetimepattern\",\"page\":1,\"spuid\":\"BOLWRICGIA\",\"tabindex\":45,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":188,\"x\":210,\"y\":735,\"zone\":\"pag1_13_3\",\"zonepath\":\"[1,13,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_GIRCEKWNMB\",\"page\":1,\"spuid\":\"GIRCEKWNMB\",\"tabindex\":95,\"type\":\"Label\",\"value\":\"ADMIN_DATETIMEPATTERN\",\"w\":195,\"x\":5,\"y\":735,\"zone\":\"pag1_13_3\",\"zonepath\":\"[1,13,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"durationreq_layer\",\"box_type\":\"layer\",\"comment\":\"ADMIN_PWDDAYSDURATION\",\"fixed\":true,\"h\":102,\"name\":\"durationreq_layer\",\"page\":1,\"shrinkable\":true,\"spuid\":\"QTXMMDECZO\",\"tabindex\":48,\"title_caption\":\"ADMIN_PWDDAYSDURATION\",\"type\":\"Box\",\"w\":332,\"x\":978,\"y\":293,\"zone\":\"pag1_14\",\"zonepath\":\"[1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"container\":\"QTXMMDECZO\",\"h\":25,\"name\":\"label_OXCBAQDUEO\",\"page\":1,\"spuid\":\"OXCBAQDUEO\",\"tabindex\":49,\"type\":\"Label\",\"value\":\"ADMIN_PWDDAYSDURATION_GROUPS\",\"w\":173,\"x\":1085,\"y\":315,\"zone\":\"pag1_14_1\",\"zonepath\":\"[1,14,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_PWDDAYSDURATION_GROUPS\",\"container\":\"QTXMMDECZO\",\"disabled\":\"true\",\"h\":25,\"maxlength\":5,\"name\":\"pwddaysduration_group\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"AMIQVJBLLQ\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":34,\"x\":1261,\"y\":315,\"zone\":\"pag1_14_1\",\"zonepath\":\"[1,14,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"container\":\"QTXMMDECZO\",\"h\":25,\"name\":\"label_CNLYOZMXLI\",\"page\":1,\"spuid\":\"CNLYOZMXLI\",\"tabindex\":51,\"type\":\"Label\",\"value\":\"ADMIN_PWDCOMPLEXITY_USER\",\"w\":173,\"x\":1085,\"y\":350,\"zone\":\"pag1_14_2\",\"zonepath\":\"[1,14,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_PWDDAYSDURATION\",\"container\":\"QTXMMDECZO\",\"h\":25,\"maxlength\":5,\"name\":\"pwddaysduration\",\"page\":1,\"spuid\":\"NTAYXBDPVY\",\"tabindex\":52,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":34,\"x\":1261,\"y\":350,\"zone\":\"pag1_14_2\",\"zonepath\":\"[1,14,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"ciclicityreq_layer\",\"box_type\":\"layer\",\"comment\":\"ADMIN_PWDCICLICITY\",\"fixed\":true,\"h\":100,\"name\":\"ciclicityreq_layer\",\"page\":1,\"shrinkable\":true,\"spuid\":\"YWYTSWWAZG\",\"tabindex\":53,\"title_caption\":\"ADMIN_PWDCICLICITY\",\"type\":\"Box\",\"w\":332,\"x\":978,\"y\":395,\"zone\":\"pag1_15\",\"zonepath\":\"[1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"container\":\"YWYTSWWAZG\",\"h\":25,\"name\":\"label_INOSWBMEWD\",\"page\":1,\"spuid\":\"INOSWBMEWD\",\"tabindex\":54,\"type\":\"Label\",\"value\":\"ADMIN_PWDCICLICITY_GROUPS\",\"w\":173,\"x\":1085,\"y\":415,\"zone\":\"pag1_15_1\",\"zonepath\":\"[1,15,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_PWDCICLICITY_GROUPS\",\"container\":\"YWYTSWWAZG\",\"disabled\":\"true\",\"h\":25,\"maxlength\":5,\"name\":\"pwdciclicity_groups\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"LDXRXBOORH\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":34,\"x\":1261,\"y\":415,\"zone\":\"pag1_15_1\",\"zonepath\":\"[1,15,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"container\":\"YWYTSWWAZG\",\"h\":25,\"name\":\"label_KRTEQHMKQD\",\"page\":1,\"spuid\":\"KRTEQHMKQD\",\"tabindex\":56,\"type\":\"Label\",\"value\":\"ADMIN_PWDCOMPLEXITY_USER\",\"w\":173,\"x\":1085,\"y\":450,\"zone\":\"pag1_15_2\",\"zonepath\":\"[1,15,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_PWDCICLICITY\",\"container\":\"YWYTSWWAZG\",\"h\":25,\"maxlength\":3,\"name\":\"pwdciclicity\",\"page\":1,\"spuid\":\"CLZCOSTIAC\",\"tabindex\":57,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":34,\"x\":1261,\"y\":450,\"zone\":\"pag1_15_2\",\"zonepath\":\"[1,15,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"captchareq_layer\",\"box_type\":\"layer\",\"comment\":\"ADMIN_CAPTCHA_LEVEL\",\"fixed\":true,\"h\":100,\"name\":\"captchareq_layer\",\"page\":1,\"shrinkable\":true,\"spuid\":\"YIYKXFSQJK\",\"tabindex\":58,\"title_caption\":\"ADMIN_CAPTCHA_LEVEL\",\"type\":\"Box\",\"w\":332,\"x\":978,\"y\":495,\"zone\":\"pag1_16\",\"zonepath\":\"[1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"container\":\"YIYKXFSQJK\",\"h\":25,\"name\":\"label_ONZAKKFAAI\",\"page\":1,\"spuid\":\"ONZAKKFAAI\",\"tabindex\":59,\"type\":\"Label\",\"value\":\"ADMIN_CAPTCHA_LEVEL_GROUPS\",\"w\":173,\"x\":1085,\"y\":515,\"zone\":\"pag1_16_1\",\"zonepath\":\"[1,16,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_CAPTCHA_LEVEL_GROUP\",\"container\":\"YIYKXFSQJK\",\"disabled\":\"true\",\"h\":25,\"maxlength\":4,\"name\":\"pwdcaptchalevel_group\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"LREHYNDNHI\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":34,\"x\":1261,\"y\":515,\"zone\":\"pag1_16_1\",\"zonepath\":\"[1,16,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"container\":\"YIYKXFSQJK\",\"h\":25,\"name\":\"label_SWHXFUZIRC\",\"page\":1,\"spuid\":\"SWHXFUZIRC\",\"tabindex\":61,\"type\":\"Label\",\"value\":\"ADMIN_PWDCOMPLEXITY_USER\",\"w\":173,\"x\":1085,\"y\":550,\"zone\":\"pag1_16_2\",\"zonepath\":\"[1,16,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_CAPTCHA_LEVEL\",\"container\":\"YIYKXFSQJK\",\"h\":25,\"maxlength\":5,\"name\":\"captchalevel\",\"page\":1,\"spuid\":\"WLRWPELGIS\",\"tabindex\":62,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":34,\"x\":1261,\"y\":550,\"zone\":\"pag1_16_2\",\"zonepath\":\"[1,16,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"pwd_layer\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"ADMIN_DETAILS\",\"groupName\":\"configurazioni\",\"h\":430,\"name\":\"pwd_layer\",\"page\":1,\"shrinkable\":true,\"spuid\":\"ZVNKOIBZTJ\",\"stretch\":true,\"tabindex\":47,\"title_caption\":\"ADMIN_DETAILS\",\"titled\":true,\"type\":\"Box\",\"w\":830,\"x\":0,\"y\":785,\"zone\":\"pag1_17\",\"zonepath\":\"[1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_TETMHKUMSX\",\"page\":1,\"spuid\":\"TETMHKUMSX\",\"tabindex\":65,\"type\":\"Label\",\"value\":\"ADMIN_VALIDITY_START\",\"w\":195,\"x\":5,\"y\":805,\"zone\":\"pag1_17_1\",\"zonepath\":\"[1,17,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_VALIDITY_START\",\"h\":25,\"maxlength\":10,\"name\":\"datestart\",\"page\":1,\"picker\":true,\"spuid\":\"DWGQEAJBOS\",\"tabindex\":66,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":112,\"x\":210,\"y\":805,\"zone\":\"pag1_17_1\",\"zonepath\":\"[1,17,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_LHHSNVPTSD\",\"page\":1,\"spuid\":\"LHHSNVPTSD\",\"tabindex\":67,\"type\":\"Label\",\"value\":\"ADMIN_VALIDITY_END\",\"w\":195,\"x\":5,\"y\":840,\"zone\":\"pag1_17_2\",\"zonepath\":\"[1,17,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_VALIDITY_END\",\"h\":25,\"maxlength\":10,\"name\":\"datestop\",\"page\":1,\"picker\":true,\"spuid\":\"AFHAPKTVTZ\",\"tabindex\":68,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":112,\"x\":210,\"y\":840,\"zone\":\"pag1_17_2\",\"zonepath\":\"[1,17,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_ACXJLWUAKM\",\"page\":1,\"spuid\":\"ACXJLWUAKM\",\"tabindex\":69,\"type\":\"Label\",\"value\":\"ADMIN_NUM_FAILED_LOGIN\",\"w\":195,\"x\":5,\"y\":875,\"zone\":\"pag1_17_3\",\"zonepath\":\"[1,17,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_NUM_FAILED_LOGIN\",\"disabled\":\"true\",\"h\":25,\"maxlength\":4,\"name\":\"failedlogins\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"HZXQEZHOPX\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":55,\"x\":210,\"y\":875,\"zone\":\"pag1_17_3\",\"zonepath\":\"[1,17,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_NNXHXVLPCZ\",\"page\":1,\"spuid\":\"NNXHXVLPCZ\",\"tabindex\":71,\"type\":\"Label\",\"value\":\"ADMIN_LAST_FAILED_LOGIN\",\"w\":195,\"x\":5,\"y\":910,\"zone\":\"pag1_17_4\",\"zonepath\":\"[1,17,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_LAST_FAILED_LOGIN\",\"disabled\":\"true\",\"h\":25,\"maxlength\":19,\"name\":\"lastfailedlogin\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"ZRPODWVWKZ\",\"type\":\"Textbox\",\"typevar\":\"datetime\",\"w\":130,\"x\":210,\"y\":910,\"zone\":\"pag1_17_4\",\"zonepath\":\"[1,17,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_YIWMIRNCJP\",\"page\":1,\"spuid\":\"YIWMIRNCJP\",\"tabindex\":73,\"type\":\"Label\",\"value\":\"ADMIN_LAST_SUCCESS_LOGIN\",\"w\":195,\"x\":5,\"y\":945,\"zone\":\"pag1_17_5\",\"zonepath\":\"[1,17,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_LAST_SUCCESS_LOGIN\",\"disabled\":\"true\",\"h\":25,\"maxlength\":19,\"name\":\"lastsuccessfullogin\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"QHBHJMVSND\",\"type\":\"Textbox\",\"typevar\":\"datetime\",\"w\":130,\"x\":210,\"y\":945,\"zone\":\"pag1_17_5\",\"zonepath\":\"[1,17,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_UVGCSSTYHA\",\"page\":1,\"spuid\":\"UVGCSSTYHA\",\"tabindex\":75,\"type\":\"Label\",\"value\":\"ADMIN_PWDCREATE\",\"w\":195,\"x\":5,\"y\":980,\"zone\":\"pag1_17_6\",\"zonepath\":\"[1,17,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_PWDCREATE\",\"disabled\":\"true\",\"h\":25,\"maxlength\":19,\"name\":\"pwdcreate\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"HDTXQUZAEB\",\"type\":\"Textbox\",\"typevar\":\"datetime\",\"w\":130,\"x\":210,\"y\":980,\"zone\":\"pag1_17_6\",\"zonepath\":\"[1,17,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_UFJBXUDKJY\",\"page\":1,\"spuid\":\"UFJBXUDKJY\",\"tabindex\":77,\"type\":\"Label\",\"value\":\"ADMIN_PWDDAYSDURATION\",\"w\":195,\"x\":5,\"y\":1015,\"zone\":\"pag1_17_7\",\"zonepath\":\"[1,17,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_PWDDAYSDURATION\",\"disabled\":\"true\",\"h\":25,\"maxlength\":5,\"name\":\"pwddaysduration_applied\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"TDUBYHZOLX\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":41,\"x\":210,\"y\":1015,\"zone\":\"pag1_17_7\",\"zonepath\":\"[1,17,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"button_PDERGYRPRJ\",\"page\":1,\"picker\":true,\"spuid\":\"PDERGYRPRJ\",\"tabindex\":79,\"type\":\"Button\",\"value\":\"...\",\"w\":18,\"x\":255,\"y\":1015,\"zone\":\"pag1_17_7\",\"zonepath\":\"[1,17,7]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_EKCSBIVEMO\",\"page\":1,\"spuid\":\"EKCSBIVEMO\",\"tabindex\":80,\"type\":\"Label\",\"value\":\"ADMIN_PWDCICLICITY\",\"w\":195,\"x\":5,\"y\":1050,\"zone\":\"pag1_17_8\",\"zonepath\":\"[1,17,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_PWDCICLICITY\",\"disabled\":\"true\",\"h\":25,\"maxlength\":5,\"name\":\"pwdciclicity_applied\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"YXDVNAKABC\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":41,\"x\":210,\"y\":1050,\"zone\":\"pag1_17_8\",\"zonepath\":\"[1,17,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"button_PKHYFJSKUZ\",\"page\":1,\"picker\":true,\"spuid\":\"PKHYFJSKUZ\",\"tabindex\":82,\"type\":\"Button\",\"value\":\"...\",\"w\":18,\"x\":255,\"y\":1050,\"zone\":\"pag1_17_8\",\"zonepath\":\"[1,17,8]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_NTPASPDTXK\",\"page\":1,\"spuid\":\"NTPASPDTXK\",\"tabindex\":83,\"type\":\"Label\",\"value\":\"ADMIN_CAPTCHA_LEVEL\",\"w\":195,\"x\":5,\"y\":1085,\"zone\":\"pag1_17_9\",\"zonepath\":\"[1,17,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_CAPTCHA_LEVEL\",\"disabled\":\"true\",\"h\":25,\"maxlength\":5,\"name\":\"pwdcaptchalevel_applied\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"WECEQGOQXC\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":41,\"x\":210,\"y\":1085,\"zone\":\"pag1_17_9\",\"zonepath\":\"[1,17,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"button_KXFZJKYRKC\",\"page\":1,\"picker\":true,\"spuid\":\"KXFZJKYRKC\",\"tabindex\":85,\"type\":\"Button\",\"value\":\"...\",\"w\":18,\"x\":255,\"y\":1085,\"zone\":\"pag1_17_9\",\"zonepath\":\"[1,17,9]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_ETVOQUICKV\",\"page\":1,\"spuid\":\"ETVOQUICKV\",\"tabindex\":86,\"type\":\"Label\",\"value\":\"ADMIN_PRINT_SERVER\",\"w\":195,\"x\":5,\"y\":1120,\"zone\":\"pag1_17_10\",\"zonepath\":\"[1,17,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_PRINT_SERVER\",\"h\":25,\"maxlength\":60,\"name\":\"printserver\",\"page\":1,\"spuid\":\"BLGCNCYQRJ\",\"tabindex\":87,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":41,\"x\":210,\"y\":1120,\"zone\":\"pag1_17_10\",\"zonepath\":\"[1,17,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":18,\"name\":\"label_ZTPRGWPKKQ\",\"page\":1,\"spuid\":\"ZTPRGWPKKQ\",\"tabindex\":111,\"type\":\"Label\",\"value\":\"ADMIN_TWO_FACTOR_AUTH\",\"w\":195,\"x\":5,\"y\":1166,\"zone\":\"pag1_17_10\",\"zonepath\":\"[1,17,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":32,\"name\":\"button_DUYHIUNXPN\",\"page\":1,\"picker\":true,\"spuid\":\"DUYHIUNXPN\",\"tabindex\":112,\"type\":\"Button\",\"w\":130,\"x\":210,\"y\":1155,\"zone\":\"pag1_17_11\",\"zonepath\":\"[1,17,11]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"pwdratecause_layer\",\"box_type\":\"layer\",\"comment\":\"UserAdmin.GetPasswordVerdict(w_pwd1,1)\",\"fixed\":true,\"h\":188,\"name\":\"pwdratecause_layer\",\"page\":1,\"shrinkable\":true,\"spuid\":\"PLMVGNNZCG\",\"tabindex\":23,\"type\":\"Box\",\"w\":330,\"x\":980,\"y\":605,\"zone\":\"pag1_18\",\"zonepath\":\"[1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"container\":\"PLMVGNNZCG\",\"disabled\":\"true\",\"h\":145,\"name\":\"pwdratecause\",\"page\":1,\"readonly\":\"true\",\"scroll\":true,\"spuid\":\"OTMRFENACR\",\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":305,\"x\":990,\"y\":615,\"zone\":\"pag1_18_1\",\"zonepath\":\"[1,18,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"gruppi_appartenenza\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"ADMIN_GROUP_MEMBERSHIP\",\"groupName\":\"configurazioni\",\"h\":123,\"name\":\"gruppi_appartenenza\",\"page\":1,\"shrinkable\":true,\"spuid\":\"FLMCUOBXBF\",\"stretch\":true,\"tabindex\":110,\"title_caption\":\"ADMIN_GROUP_MEMBERSHIP\",\"titled\":true,\"type\":\"Box\",\"w\":830,\"x\":0,\"y\":1215,\"zone\":\"pag1_19\",\"zonepath\":\"[1,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":88,\"name\":\"spadministration_usersgroups\",\"page\":1,\"spuid\":\"QGNMFELDBT\",\"tabindex\":1,\"type\":\"Iframe\",\"w\":795,\"x\":10,\"y\":1235,\"zone\":\"pag1_19_1\",\"zonepath\":\"[1,19,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_BGMYNICMON\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"CP_SSOID\",\"groupName\":\"configurazioni\",\"h\":95,\"name\":\"box_BGMYNICMON\",\"page\":1,\"shrinkable\":true,\"spuid\":\"BGMYNICMON\",\"stretch\":true,\"tabindex\":3,\"title_caption\":\"CP_SSOID\",\"titled\":true,\"type\":\"Box\",\"w\":835,\"x\":-5,\"y\":1338,\"zone\":\"pag1_20\",\"zonepath\":\"[1,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":53,\"name\":\"spadministration_ssomap_child\",\"page\":1,\"spuid\":\"VMCLEJEYGM\",\"tabindex\":2,\"type\":\"Iframe\",\"w\":790,\"x\":5,\"y\":1356,\"zone\":\"pag1_20_1\",\"zonepath\":\"[1,20,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_AXCUQKTKCI\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"SPAS_IAR_LICENSE\",\"groupName\":\"configurazioni\",\"h\":135,\"name\":\"box_AXCUQKTKCI\",\"page\":1,\"shrinkable\":true,\"spuid\":\"AXCUQKTKCI\",\"stretch\":true,\"tabindex\":105,\"title_caption\":\"SPAS_IAR_LICENSE\",\"titled\":true,\"type\":\"Box\",\"w\":830,\"x\":0,\"y\":1433,\"zone\":\"pag1_21\",\"zonepath\":\"[1,21]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"T"+"'"+"\",\"comment\":\"SPAS_USES_IAR_LICENSE\",\"h\":25,\"label_text\":\"SPAS_USES_IAR_LICENSE\",\"maxlength\":1,\"name\":\"usesiarlicense\",\"page\":1,\"spuid\":\"ZOICKBMQFQ\",\"tabindex\":97,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"F"+"'"+"\",\"w\":163,\"x\":20,\"y\":1453,\"zone\":\"pag1_21_1\",\"zonepath\":\"[1,21,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":25,\"maxlength\":7,\"name\":\"IAR_LICENSES\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"MHGIWUEDLA\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":66,\"x\":515,\"y\":1453,\"zone\":\"pag1_21_2\",\"zonepath\":\"[1,21,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_ZKJXQLSILH\",\"page\":1,\"spuid\":\"ZKJXQLSILH\",\"tabindex\":104,\"type\":\"Label\",\"value\":\"SPAS_LICENSE_PURCHASED\",\"w\":189,\"x\":316,\"y\":1453,\"zone\":\"pag1_21_2\",\"zonepath\":\"[1,21,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":25,\"maxlength\":7,\"name\":\"IAR_USED\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"IQERCSAIWG\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":66,\"x\":515,\"y\":1488,\"zone\":\"pag1_21_3\",\"zonepath\":\"[1,21,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_UKIVAGKLUF\",\"page\":1,\"spuid\":\"UKIVAGKLUF\",\"tabindex\":103,\"type\":\"Label\",\"value\":\"SPAS_LICENSE_USED\",\"w\":143,\"x\":362,\"y\":1488,\"zone\":\"pag1_21_3\",\"zonepath\":\"[1,21,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"label_EMQMMHAGNL\",\"page\":1,\"spuid\":\"EMQMMHAGNL\",\"tabindex\":106,\"type\":\"Label\",\"w\":328,\"x\":20,\"y\":1488,\"zone\":\"pag1_21_3\",\"zonepath\":\"[1,21,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":25,\"maxlength\":7,\"name\":\"IAR_AVAILABLE\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"RGMQBWZEWR\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":66,\"x\":515,\"y\":1523,\"zone\":\"pag1_21_4\",\"zonepath\":\"[1,21,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_FPMYPPWLBO\",\"page\":1,\"spuid\":\"FPMYPPWLBO\",\"tabindex\":102,\"type\":\"Label\",\"value\":\"SPAS_LICENSE_AVAILABLE\",\"w\":170,\"x\":335,\"y\":1523,\"zone\":\"pag1_21_4\",\"zonepath\":\"[1,21,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_DBASOAOUYJ\",\"page\":1,\"spuid\":\"DBASOAOUYJ\",\"tabindex\":46,\"type\":\"Label\",\"value\":\"CP_COMPANIES\",\"w\":196,\"x\":5,\"y\":330,\"zone\":\"pag1_22\",\"zonepath\":\"[1,22]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Abilita l"+"'"+"utente su certe aziende\",\"empty_value\":\"false\",\"h\":25,\"maxlength\":1,\"name\":\"UFENABLEAZI\",\"page\":1,\"spuid\":\"VRCQKXWFPX\",\"tabindex\":116,\"textlist\":\"ADMIN_ALL_COMPANIES,ADMIN_LIST_OF_COMPANIES\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"n"+"'"+","+"'"+"s"+"'"+"\",\"w\":162,\"x\":210,\"y\":330,\"zone\":\"pag1_22\",\"zonepath\":\"[1,22]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(spadministration_usersBO BO,ServletStatus status) {
    status.themeWriter = new SPTheme(status.out,status.GetThemeStatus("",status.context.Translate(entityGlobals.userName),status.context.Translate("MSG_FORM_FUNCTION_"+status.m_cClientMode.toUpperCase())),"form");
    status.out.println(
     "<!doctype html>" +
    "");
    status.out.println(
     "<html " + ( SPLib.IsMobile( status.request )  ? "ps-stretch": "" )+ ">" +
    "");
    status.out.println(
     "<head>" +
    "");
    status.WriteSkinnedCss();
    status.out.println(
     "<link rel='shortcut icon' href='../favicon.ico'>" +
    "");
    WriteMetaTags(status);
    String l_cJsUid;
    com.zucchetti.sitepainter.Library.WriteLegacyScripts(status.request,status.out);
    com.zucchetti.sitepainter.Library.WriteFrameworkScripts(status.request,status.out);
    status.out.println(
     "<script src='spadministration_users?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("stdFunctions.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    if (com.zucchetti.sitepainter.Library.IsMobile(status.request)) {
      l_cJsUid = SPPrxycizer.proxycizedPath("spmobilelib.js");
      status.out.println(
       "<script>" +
      "");
      status.out.println("if ( ! (window.SPMobileLib)) {");
      status.out.println("LibJavascript.RequireLibrary(\"../"+l_cJsUid+"\");");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    }
    status.out.println(
     "<script>" +
    "");
    status.out.println("function PlatformPathStart(p_cName) {");
    status.out.println("return p_cName;");
    status.out.println("}");
    status.out.println("InstTR();");
    status.out.println(
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("controls.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    if (status.is_live_editing) {
      l_cJsUid = SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js");
      status.out.println(
       "<script src='../"+l_cJsUid+"'>" +
       "</script>" +
      "");
      l_cJsUid = SPPrxycizer.proxycizedPath("LiveEditing.js");
      status.out.println(
       "<script src='../"+l_cJsUid+"'>" +
       "</script>" +
      "");
    }
    l_cJsUid = SPPrxycizer.proxycizedPath("SPBOUILib.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    if (CPLib.gt(BO.extendedFields.length,0)) {
      l_cJsUid = SPPrxycizer.proxycizedPath("ExtendedFields.js");
      status.out.println(
       "<script src='../"+l_cJsUid+"'>" +
       "</script>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/spadministration_users_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/spadministration_users_edit.js'>" +
       "</script>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      l_cJsUid = SPPrxycizer.proxycizedPath("sppainterentity.js");
      status.out.println(
       "<script src='../"+l_cJsUid+"'>" +
       "</script>" +
      "");
      PrintPainterProps(status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("function DeclareWVs() {");
      status.out.println("var a = arguments;");
      status.out.println("w_code=a[0];");
      status.out.println("w_fullname=a[1];");
      status.out.println("w_name=a[2];");
      status.out.println("w_accesstype_human=a[3];");
      status.out.println("w_accesstype_service=a[4];");
      status.out.println("w_accesstype_machine=a[5];");
      status.out.println("w_pwdcomplexity=a[6];");
      status.out.println("w_forcepwdchange=a[7];");
      status.out.println("w_enabled=a[8];");
      status.out.println("w_language=a[9];");
      status.out.println("w_decimalseparator=a[10];");
      status.out.println("w_thousandseparator=a[11];");
      status.out.println("w_datepattern=a[12];");
      status.out.println("w_datetimepattern=a[13];");
      status.out.println("w_pwddaysduration=a[14];");
      status.out.println("w_pwdciclicity=a[15];");
      status.out.println("w_captchalevel=a[16];");
      status.out.println("w_datestart=a[17];");
      status.out.println("w_datestop=a[18];");
      status.out.println("w_failedlogins=a[19];");
      status.out.println("w_lastfailedlogin=a[20];");
      status.out.println("w_lastsuccessfullogin=a[21];");
      status.out.println("w_pwdcreate=a[22];");
      status.out.println("w_printserver=a[23];");
      status.out.println("w_createdwhen=a[24];");
      status.out.println("w_usesiarlicense=a[25];");
      status.out.println("w_companies=a[26];");
      status.out.println("w_modifyPassword=a[27];");
      status.out.println("w_pwd1=a[28];");
      status.out.println("w_calcomplex=a[29];");
      status.out.println("w_pwdratecause=a[30];");
      status.out.println("w_pwd2=a[31];");
      status.out.println("w_pwdcomplexity_group=a[32];");
      status.out.println("w_pwdcomplexity_reqired=a[33];");
      status.out.println("w_language_name=a[34];");
      status.out.println("w_pwddaysduration_group=a[35];");
      status.out.println("w_pwdciclicity_groups=a[36];");
      status.out.println("w_pwdcaptchalevel_group=a[37];");
      status.out.println("w_pwddaysduration_applied=a[38];");
      status.out.println("w_pwdciclicity_applied=a[39];");
      status.out.println("w_pwdcaptchalevel_applied=a[40];");
      status.out.println("w_init_code=a[41];");
      status.out.println("w_pwd_modified=a[42];");
      status.out.println("w_IAR_LICENSE_VALID=a[43];");
      status.out.println("w_IAR_LICENSES=a[44];");
      status.out.println("w_IAR_USED=a[45];");
      status.out.println("w_IAR_AVAILABLE=a[46];");
      status.out.println("w_selected_group=a[47];");
      status.out.println("w_g_OTPisActive=a[48];");
      status.out.println("w_otp=a[49];");
      status.out.println("w_UFENABLEAZI=a[50];");
      status.out.println("w_pwd1_view=a[51];");
      status.out.println("w_pwd2_view=a[52];");
      status.out.println("m_ospadministration_historypwd=null;");
      status.out.println("m_ospadministration_usercompanies=null;");
      status.out.println("o_AXCUQKTKCI_expand=null;");
      status.out.println("m_cWv_spadministration_usersgroups=a[53];");
      status.out.println("m_cWv_spadministration_ssomap_child=a[54];");
      status.out.println("m_cWv_spadministration_historypwd=a[55];");
      status.out.println("m_cWv_spadministration_usercompanies=a[56];");
      status.out.println("if (Gt(a.length,57)) {");
      status.out.println("m_cErrorInChild='';");
      status.out.println("}");
      status.out.println("if (Gt(a.length,57)) {");
      status.out.println("o_code=w_code;");
      status.out.println("o_modifyPassword=w_modifyPassword;");
      status.out.println("o_pwd1=w_pwd1;");
      status.out.println("o_pwd2=w_pwd2;");
      status.out.println("o_pwddaysduration_group=w_pwddaysduration_group;");
      status.out.println("o_pwddaysduration=w_pwddaysduration;");
      status.out.println("o_pwdciclicity_groups=w_pwdciclicity_groups;");
      status.out.println("o_pwdciclicity=w_pwdciclicity;");
      status.out.println("o_pwdcaptchalevel_group=w_pwdcaptchalevel_group;");
      status.out.println("o_captchalevel=w_captchalevel;");
      status.out.println("o_selected_group=w_selected_group;");
      status.out.println("o_companies=w_companies;");
      status.out.println("o_UFENABLEAZI=w_UFENABLEAZI;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['code'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/spadministration_users_proc.js'>" +
       "</script>" +
      "");
    }
    IncludeJS(status);
    RaiseSavedEntity(BO,status);
    RaiseDeletedEntity(BO,status);
    RaiseDiscardedEntity(BO,status);
    // Dichiarazione delle variabili di script
    WriteMainFormVarScript(BO,status);
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/styleVariables.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/calendar.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/calculator.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    if (CPLib.ne(status.m_bAutoResize,"")) {
      status.out.println(
       "<script>" +
      "");
      status.out.println("var sv_WindowAutoResize = " + SPLib.ToJSValue(CPLib.eq(status.m_bAutoResize,"true"),"L",0,0)+ ";");
      status.out.println(
       "</script>" +
      "");
    }
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/tabStrip.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    status.themeWriter.WriteInclude();
    WriteStyles(BO,status);
    status.out.println(
     "<title>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate(entityGlobals.userName))+"" +
     "</title>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if ( ! (status.m_bHasRS)) {
      status.out.println("AppletTag('Settings','Trs');");
    }
    status.out.println("AppletTag('Wv','Trs');");
    status.out.println("AppletTag('Batch');");
    status.out.println(
     "</script>" +
    "");
    status.m_cBodyAttributes = "onload=OnLoad() onhelp=CancelHelp()";
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.m_cBodyAttributes = status.m_cBodyAttributes+" onkeydown=window.ManageKeys(event,false,false)";
    } else {
      status.m_cBodyAttributes = status.m_cBodyAttributes+" onkeydown=window.ManageKeys(event,true,false)";
    }
    status.m_cBodyAttributes = status.m_cBodyAttributes+" onfocus=EnsureControlFocus()";
    status.themeWriter.WriteBody_Begin(930,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
    status.out.println(
     "<script>" +
    "");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("AppletTag('Link');");
    }
    status.out.println(
     "</script>" +
    "");
    WriteMainFormScript(BO,status);
    status.AssignOP(BO.m_cOldCPCCCHK);
    status.WriteSenderForm(entityGlobals,BO.m_bLoaded);
    WriteMainForm(BO,status);
    status.themeWriter.WriteBody_EndHtml();
    status.themeWriter.WriteBody_End();
    PrintWarns(BO,status,BO.IsLoaded());
    status.out.println(
     "</html>" +
    "");
  }
  void OpenZoom(ServletStatus status,SPParameterSource source) {
    ForwardZoom("../jsp/SPPortalZoom.jsp",status,source);
  }
  void OpenPSZoom(ServletStatus status,SPParameterSource source) {
    ForwardZoom("../jsp/SPPortalZoomBase_portlet.jsp",status,source);
  }
  void ForwardZoom(String p_cForwardZoomResource,ServletStatus status,SPParameterSource source) {
    SPLib.NoCache(status.response);
    Forward f;
    f = new Forward(SPLib.GetZoomResource(p_cForwardZoomResource),false,Forward.Start,false);
    f.SetParameter("Table","cpusers");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","code");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(spadministration_usersBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({code:"+SPLib.ToJSValue(BO.w_code,"N",9,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(spadministration_usersBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({code:"+SPLib.ToJSValue(BO.w_code,"N",9,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(spadministration_usersBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({code:"+SPLib.ToJSValue(BO.w_code,"N",9,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(spadministration_usersBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({code:"+SPLib.ToJSValue(BO.w_code,"N",9,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(spadministration_usersBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({code:"+SPLib.ToJSValue(BO.w_code,"N",9,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(spadministration_usersBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(spadministration_usersBO BO,ServletStatus status) throws IOException {
    if (CPLib.eq(BO.m_nLastError,4) || CPLib.eq(BO.m_nLastError,5)) {
      RequestPwdOrOTP(status,(CPLib.eq(BO.m_nLastError,5)?"OTP":"password"));
      return;
    }
    String msg = status.context.Translate("MSG_END_ROUTINE");
    SPLib.SetContentType(status.response);
    SPLib.NoCache(status.response);
    status.out = status.response.getWriter();
    String l_cJsUid;
    status.out.println(
     "<!doctype html>" +
    "");
    status.out.println(
     "<html>" +
    "");
    status.out.println(
     "<title>" +
     ""+status.context.Translate("MSG_ROUTINE_WIND")+"" +
     "</title>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("stdFunctions.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("controls.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    if (status.m_bError) {
      msg = status.context.Translate("MSG_END_ROUTINE_WITH_MSG");
      status.out.println(
       "<body onkeydown='window.ManageKeys(event,false,false)'>" +
      "");
    } else {
      status.out.println(
       "<body>" +
      "");
    }
    status.out.println(
     "<p>" +
     ""+msg+"" +
     "</p>" +
    "");
    String l_cPreviousErr = status.m_cErrMsg;
    String l_cUserErr = status.m_cErrMsg;
    if (status.m_bError) {
      status.out.println(
       "<script>" +
      "");
      WriteJSError(status);
      l_cUserErr = status.m_cErrMsg;
      status.m_cErrMsg = l_cPreviousErr;
      status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
      status.out.println(
       "</script>" +
      "");
    }
    status.out.println(
     "<!--" +
    "");
    if (CPLib.eq(status.source.GetParameter("m_OnlyContext","_no_"),"_no_")) {
      String l_cOut;
      if (status.m_bError) {
        l_cOut = SPLib.ToJSValue("KO("+SPLib.GetWriteVarErrorName(status)+")"+UserDBMessage(status),"C",0,0);
      } else {
        l_cOut = "OK";
        if (status.m_cAction.endsWith("message")) {
          l_cOut = l_cOut+" "+SPLib.ToJSValue(status.m_cBOWarnMessageDeleted,"C",0,0);
        } else if (status.m_cAction.startsWith("delete")) {
          l_cOut = l_cOut+" "+status.m_bBODeleted;
        }
      }
      l_cOut = CPLib.ToProperties(l_cOut);
      l_cOut = com.zucchetti.sitepainter.Library.ToHTMLEuro(l_cOut);
      status.out.println("Function return value:"+l_cOut+"");
    } else {
      status.m_cErrMsg = l_cUserErr;
      status.out.println("js:BO="+SPLib.ToJSValue(BO.GetContext(),"M",0,0)+"");
    }
    status.out.println(
     " -->" +
    "");
  }
  void IncludeJS(ServletStatus status) {
    String l_cJsUid;
    l_cJsUid = SPPrxycizer.proxycizedPath("UserAdmin.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+spadministration_check_username.m_cEntityUid+"/spadministration_check_username.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+spadministration_getcaptchalevel_group.m_cEntityUid+"/spadministration_getcaptchalevel_group.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+spadministration_getpwdciclicity_group.m_cEntityUid+"/spadministration_getpwdciclicity_group.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+spadministration_getpwdcomplexity_group.m_cEntityUid+"/spadministration_getpwdcomplexity_group.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+spadministration_getpwdduration_group.m_cEntityUid+"/spadministration_getpwdduration_group.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+spas_fhaslicense.m_cEntityUid+"/spas_fhaslicense.js'>" +
     "</script>" +
    "");
    /* --- Area Manuale = UI - Include */
    /* --- spadministration_users */
    status.out.println("<script src='../spadministration_help.js' type='text/javascript'></script>");
    status.out.println("<style>.spadminNoPadding { padding: 0; !important;}</style>");
    /* --- Fine Area Manuale */
  }
  // m_CallableNames inizializzato dal primo accesso a GetCallableNames
  private static volatile String[] m_CallableNames;
  public static String[] GetCallableNames() {
    if (CPLib.IsNull(m_CallableNames)) {
      java.util.Set building = new java.util.HashSet();
      GetCallableNames(building);
      m_CallableNames = CPLib.SetOfStringsAsArray(building);
    }
    return (String[])m_CallableNames.clone();
  }
  public static void GetCallableNames(java.util.Set callable) {
    if (CPLib.IsNull(m_CallableNames)) {
      spadministration_check_username.GetCallableNames(callable);
      spadministration_getcaptchalevel_group.GetCallableNames(callable);
      spadministration_getpwdciclicity_group.GetCallableNames(callable);
      spadministration_getpwdcomplexity_group.GetCallableNames(callable);
      spadministration_getpwdduration_group.GetCallableNames(callable);
      spas_fhaslicense.GetCallableNames(callable);
      CPLib.AddToSet(callable,"UserAdmin");
      CPLib.AddToSet(callable,"spadministration_usersgroups");
      CPLib.AddToSet(callable,"spadministration_ssomap_child");
      CPLib.AddToSet(callable,"spadministration_historypwd");
      CPLib.AddToSet(callable,"spadministration_usercompanies");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,spadministration_usersBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(BO.w_code,"N",9,0));
      }
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_g_OTPisActive),"C",1,0));
    } else if (CPLib.eq(p_cUID,"CIUGDDXJMR")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"XFCGDYJJAR")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,spadministration_usersBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_language))) {
        a = GetCheckVars(status,BO,"XFCGDYJJAR");
        b = status.m_CheckVars.optString("XFCGDYJJAR");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
