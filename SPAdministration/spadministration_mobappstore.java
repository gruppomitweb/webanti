import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class spadministration_mobappstore extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*1788d9bb*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "cpappstore";
    }
    public String w_oa__code;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_oa__code,context,"cpappstore","oa__code","C",10,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='oa__code' type='hidden' value="+SPLib.ToHTMLValue(w_oa__code,"C",10,0)+">" +
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
    spadministration_mobappstoreBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_cpappstore;
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
      status.w_oa__code = BO.w_oa__code;
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
    return "CP_MOBAPPSTORE";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "spadministration_mobappstore";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 840;
    l_eg.m_nEntityHeight = 685;
    l_eg.isPublic = false;
    l_eg.canAccess = false;
    l_eg.canInsert = false;
    l_eg.canChange = false;
    l_eg.canDelete = false;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"cpappstore"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","App mobile online","page"),new ZoneItem("page_2","Quick menu","page"),new ZoneItem("page_3","Permessi","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"oa__code"};
    l_eg.items = new SPItem[]{
                   new SPItem("oa__code","C",10,0, "edit","MOBAPPSTORE_CODE"),
                   new SPItem("oaapppublished","N",1,0, "edit","Published"),
                   new SPItem("oareserved","C",1,0, "edit","Profilata"),
                   new SPItem("oaappmenu","C",100,0, "edit","MOBAPPSTORE_MENU_APPL"),
                   new SPItem("oaapptitle","C",50,0, "edit","MOBAPPSTORE_TITLE"),
                   new SPItem("oadescri","M",10,0, "edit","MOBAPPSTORE_DESCRIPTION"),
                   new SPItem("oaapplogo","C",50,0, "edit","MOBAPPSTORE_LOGO"),
                   new SPItem("oaappfavico","C",50,0, "edit","MOBAPPSTORE_ICON"),
                   new SPItem("oaapplanding","C",255,0, "edit","Landing page"),
                   new SPItem("oaskinname","C",30,0, "edit","Nome Skin"),
                   new SPItem("changeSkin","L",1,0, "edit",""),
                   new SPItem("oaappvariantname","C",30,0, "edit","Variant name"),
                   new SPItem("oaappheader","C",50,0, "edit","Header image"),
                   new SPItem("oaappdescrheader","C",50,0, "edit","Description header"),
                   new SPItem("oaapphideutilitygroup","N",1,0, "edit","MOBAPPSTORE_HIDE_UTILITY_GROUP"),
                   new SPItem("oaapphomelink","C",255,0, "edit","Home link of home button"),
                   new SPItem("combo_homelink","N",1,0, "edit","MOBAPPSTORE_HOME_BUTTON_LINK"),
                   new SPItem("custom_homelink","C",255,0, "edit",""),
                   new SPItem("oaappchecksum","C",20,0, "edit","Cheksum"),
                   new SPItem("OAAPPACCESSMODE","C",30,0, "edit","Access mode"),
                   new SPItem("oaappdevtyp","C",1,0, "edit","Designed for"),
                   new SPItem("oaappreqreg","N",1,0, "edit","MOBAPPSTORE_REQUIRE_REGISTRATION"),
                   new SPItem("oaappurlreg","C",255,0, "edit","MOBAPPSTORE_URL_REGISTRATION"),
                   new SPItem("forceCreateFile","L",1,0, "hide",""),
                   new SPItem("ignoreFile","L",1,0, "hide","")
                 };
    l_eg.m_lHasHistorical = false;
    return l_eg;
  }
  ArrayList<org.json.JSONArray> i_sidebarItems = null;
  public org.json.JSONArray getSidebarItems(int p_nPage) {
    if (CPLib.IsNull(i_sidebarItems)) {
      i_sidebarItems = InitializeSidebarItemsArray(3);
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,spadministration_mobappstoreBO BO) {
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
      i_contextmenu = InitializeContextMenuArray(3);
      org.json.JSONArray l_contextmenuPageItems;
    }
    if (CPLib.ge(p_nPage,0) && CPLib.lt(p_nPage,i_contextmenu.size())) {
      return i_contextmenu.get(p_nPage);
    } else {
      return new org.json.JSONArray();
    }
  }
  public String[][] JSTranslations(CPContext p_Context) {
    String[][] l_translations;
    l_translations=new String[][]{{"10139844320",p_Context.Translate("Access mode")},
    {"10330741240",p_Context.Translate("Home link of home button")},
    {"10728329812",p_Context.Translate("MOBAPPSTORE_LOGO")},
    {"10875327060",p_Context.Translate("MOBAPPSTORE_ICON")},
    {"10962091029",p_Context.Translate("MOBAPPSTORE_SKIN_NAME")},
    {"1097638194",p_Context.Translate("MOBAPPSTORE_URL_REGISTRATION")},
    {"11080022524",p_Context.Translate("Published")},
    {"11215142635",p_Context.Translate("Header image")},
    {"11321299471",p_Context.Translate("MOBAPPSTORE_TITLE")},
    {"11403674860",p_Context.Translate("Designed for")},
    {"11473259823",p_Context.Translate("Profilata")},
    {"11606209755",p_Context.Translate("MOBAPPSTORE_PUBLISHED")},
    {"1243315651",p_Context.Translate("CP_MOBAPPSTORE")},
    {"1288641461",p_Context.Translate("MOBAPPSTORE_PROFILED")},
    {"1301099432",p_Context.Translate("MOBAPPSTORE_REQUIRE_REGISTRATION")},
    {"1589847666",p_Context.Translate("Description header")},
    {"1851159004",p_Context.Translate("Landing page")},
    {"1932338830",p_Context.Translate("MOBAPPSTORE_DESCRIPTION")},
    {"1959402435",p_Context.Translate("Cheksum")},
    {"2068761572",p_Context.Translate("Variant name")},
    {"2111909383",p_Context.Translate("MOBAPPSTORE_HOME_BUTTON_LINK")},
    {"285091139",p_Context.Translate("MOBAPPSTORE_CHANGE_SKIN")},
    {"527286826",p_Context.Translate("MOBAPPSTORE_HIDE_UTILITY_GROUP")},
    {"539286221",p_Context.Translate("MOBAPPSTORE_VARIANT_NAME")},
    {"5686444",p_Context.Translate("Nome Skin")},
    {"831361452",p_Context.Translate("MOBAPPSTORE_CODE")},
    {"994633243",p_Context.Translate("MOBAPPSTORE_MENU_APPL")}};
    return l_translations;
  }
  void WriteStyles(spadministration_mobappstoreBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../spadministration_mobappstore.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(spadministration_mobappstoreBO BO,ServletStatus status) {
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
    status.out.println("SetSubTitle("+SPLib.ToJSValue(status.context.Translate(""),"C",0,0)+");");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='tabsContainer'>" +
     " " +
     "</div>" +
    "");
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
    status.out.println("if ( ! (Z.Tabs.Has('tabs'))) {");
    status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("App mobile online"),"C",0,0)+"},{name:\"page_2\", element:\"page_2\", caption:"+SPLib.ToJSValue(status.context.Translate("Quick menu"),"C",0,0)+"},{name:\"page_3\", element:\"page_3\", caption:"+SPLib.ToJSValue(status.context.Translate("Permessi"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
    status.out.println("Z.Tabs.Set('tabs',tabs);");
    status.out.println("} else {");
    status.out.println("var tabs = Z.Tabs.Get('tabs')");
    status.out.println("}");
    AddExtendedTabs(status);
    status.out.println("Z.Tabs.Get('tabs').InitSelect('spadministration_mobappstore',false);");
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"spadministration_mobappstore",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(spadministration_mobappstoreBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    WriteControls_p2(BO,status);
    WriteControls_p3(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,4);
  }
  void WriteControls_p1(spadministration_mobappstoreBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:685px;width:840px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"App mobile online");
    PrintSidebarContent(1,status,getSidebarItems(0),false);
    PrintContextMenu(1,status,getContextMenu(0),"spadministration");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2(spadministration_mobappstoreBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_2' class='PageContainer' style='position:relative;height:260px;width:840px;display:none'>" +
    "");
    WriteControls_p2_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,2,"Quick menu");
    PrintSidebarContent(2,status,getSidebarItems(1),false);
    PrintContextMenu(2,status,getContextMenu(1),"spadministration");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3(spadministration_mobappstoreBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_3' class='PageContainer' style='position:relative;height:245px;width:840px;display:none'>" +
    "");
    WriteControls_p3_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,3,"Permessi");
    PrintSidebarContent(3,status,getSidebarItems(2),false);
    PrintContextMenu(3,status,getContextMenu(2),"spadministration");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b0(spadministration_mobappstoreBO BO,ServletStatus status) {
    status.out.println(
     "<div style='position:relative;height:685px'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='oa__code' id='BXPAETNPNW' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_oa__code,"C",10,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("MOBAPPSTORE_CODE"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='10' size='10' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='SNIXYTTVQQ_DIV'>" +
     "<input name='oaapppublished' id='SNIXYTTVQQ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_oaapppublished,"N",1,0,"", status.m_oRegSettings)+" tabindex='-1' "+(CPLib.eq(1,BO.w_oaapppublished)?"CHECKED":"")+">" +
     "<label id='SNIXYTTVQQ_LBL' for='SNIXYTTVQQ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_PUBLISHED"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel PrimaryKeyLabel' id='KVKRLLIGYM_DIV'>" +
     "<label id='KVKRLLIGYM' for='BXPAETNPNW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_CODE"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='ZLZSHHUAAO_DIV'>" +
     "<input name='oareserved' id='ZLZSHHUAAO' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_oareserved,"C",1,0,"", status.m_oRegSettings)+" tabindex='-1' "+(CPLib.eq("S",CPLib.Trim(BO.w_oareserved))?"CHECKED":"")+">" +
     "<label id='ZLZSHHUAAO_LBL' for='ZLZSHHUAAO' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_PROFILED"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='oaappmenu' id='HGEWTTQPUR' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_oaappmenu,"C",100,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("MOBAPPSTORE_MENU_APPL"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='100' size='100' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='TZKFFVHPXC_DIV'>" +
     "<label id='TZKFFVHPXC'>" +
     "<a href='javascript:href_TZKFFVHPXC()' class='SPLabel' tabindex='"+status.m_nTabIndex+"' id='TZKFFVHPXC_HREF' curTabIndex='"+status.m_nTabIndex+"'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_MENU_APPL"))+"" +
     "</a>" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='oaapptitle' id='DIVZDHWPRQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_oaapptitle,"C",50,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("MOBAPPSTORE_TITLE"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FSDGYBMNYQ_DIV'>" +
     "<label id='FSDGYBMNYQ' for='DIVZDHWPRQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_TITLE"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<textarea name='oadescri' id='XGINRSLGED' class='Memo' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' cols='20' rows='2'>" +
     "</textarea>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CTNJEDTGDD_DIV'>" +
     "<label id='CTNJEDTGDD' for='XGINRSLGED'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_DESCRIPTION"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='oaapplogo' id='THXHMWDAPZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_oaapplogo,"C",50,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("MOBAPPSTORE_LOGO"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HMQXIQLADZ_DIV'>" +
     "<label id='HMQXIQLADZ' for='THXHMWDAPZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_LOGO"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='oaappfavico' id='QYLTLWYYSH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_oaappfavico,"C",50,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("MOBAPPSTORE_ICON"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XEBDOBFQBZ_DIV'>" +
     "<label id='XEBDOBFQBZ' for='QYLTLWYYSH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_ICON"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='oaapplanding' id='LHWJXXROEN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_oaapplanding,"C",255,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("Landing page"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='255' size='255' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DSXRDZXBTT_DIV'>" +
     "<label id='DSXRDZXBTT' for='LHWJXXROEN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_LANDING"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='oaskinname' id='UZJHJSBNKL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_oaskinname,"C",30,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("MOBAPPSTORE_SKIN_NAME"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='JKORHAZIKU_DIV'>" +
     "<input name='changeSkin' id='JKORHAZIKU' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_changeSkin,"L",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"disabled":"")+" "+(CPLib.eq(true,BO.w_changeSkin)?"CHECKED":"")+">" +
     "<label id='JKORHAZIKU_LBL' for='JKORHAZIKU' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_CHANGE_SKIN"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JLTWHMFXTO_DIV'>" +
     "<label id='JLTWHMFXTO' for='UZJHJSBNKL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_SKIN_NAME"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='oaappvariantname' id='LRTLIAYQMN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_oaappvariantname,"C",30,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("MOBAPPSTORE_VARIANT_NAME"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MVNSCJDAFX_DIV'>" +
     "<label id='MVNSCJDAFX' for='LRTLIAYQMN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_VARIANT_NAME"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='oaappheader' id='MRNRGZRDQJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_oaappheader,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ICRRPRBHAK_DIV'>" +
     "<label id='ICRRPRBHAK' for='MRNRGZRDQJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_HEADER_IMG"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='oaappdescrheader' id='CUOPMOHONZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_oaappdescrheader,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QHPVOKFJDL_DIV'>" +
     "<label id='QHPVOKFJDL' for='CUOPMOHONZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_HEADER_DESC"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='DAMSKDIPPB_DIV'>" +
     "<input name='oaapphideutilitygroup' id='DAMSKDIPPB' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_oaapphideutilitygroup,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_oaapphideutilitygroup)?"CHECKED":"")+">" +
     "<label id='DAMSKDIPPB_LBL' for='DAMSKDIPPB' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_HIDE_UTILITY_GROUP"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='oaapphomelink' id='EYZZDYMIDO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_oaapphomelink,"C",255,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='255' size='255' fieldtype='C' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='combo_homelink' id='LMGRJMFNAF' class='Combobox "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"disabled":"")+">" +
     "<option value="+SPLib.ToHTMLValue(1,"N",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq(1,BO.w_combo_homelink)?"SELECTED":"")+">" +
     ""+status.context.Translate("Login Page")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(2,"N",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq(2,BO.w_combo_homelink)?"SELECTED":"")+">" +
     ""+status.context.Translate("Default Page")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(3,"N",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq(3,BO.w_combo_homelink)?"SELECTED":"")+">" +
     ""+status.context.Translate("Custom URL")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('LMGRJMFNAF'),w_combo_homelink,'N');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='custom_homelink' id='ZOTPWYUMVB' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_custom_homelink,"C",255,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='255' size='255' fieldtype='C' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NCFRRVPJOU_DIV'>" +
     "<label id='NCFRRVPJOU' for='LMGRJMFNAF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_HOME_BUTTON_LINK"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='oaappchecksum' id='GJRUFNPOQO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_oaappchecksum,"C",20,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='20' size='20' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='GFKDYWNVED_DIV'>" +
     "<label id='GFKDYWNVED' for='GJRUFNPOQO'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_CHECKSUM"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='OAAPPACCESSMODE' id='ZMJJCHDRPF' class='Combobox' tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("browser_only","C",30,0,"", status.m_oRegSettings)+" "+(CPLib.eq("browser_only",CPLib.Trim(BO.w_OAAPPACCESSMODE))?"SELECTED":"")+">" +
     ""+status.context.Translate("MSG_MOBAPPSTORE_ACCESS_MODE_BROWSER")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("hybrid_only","C",30,0,"", status.m_oRegSettings)+" "+(CPLib.eq("hybrid_only",CPLib.Trim(BO.w_OAAPPACCESSMODE))?"SELECTED":"")+">" +
     ""+status.context.Translate("MSG_MOBAPPSTORE_ACCESS_MODE_HYBRID")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("browser_and_hybrid","C",30,0,"", status.m_oRegSettings)+" "+(CPLib.eq("browser_and_hybrid",CPLib.Trim(BO.w_OAAPPACCESSMODE))?"SELECTED":"")+">" +
     ""+status.context.Translate("MSG_MOBAPPSTORE_ACCESS_MODE_BROWSER_AND_HYBRID")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('ZMJJCHDRPF'),w_OAAPPACCESSMODE,'C');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CPQRMTYZXV_DIV'>" +
     "<label id='CPQRMTYZXV' for='PIQTDJYWDH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_ACCESS_MODE"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TWZFAYGLKC_DIV'>" +
     "<label id='TWZFAYGLKC' for='FBEIHIJGFG'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_DESIGNEDFOR"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='oaappdevtyp' id='FBEIHIJGFG' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("T","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("T",CPLib.Trim(BO.w_oaappdevtyp))?"SELECTED":"")+">" +
     ""+status.context.Translate("Tablet")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("S","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("S",CPLib.Trim(BO.w_oaappdevtyp))?"SELECTED":"")+">" +
     ""+status.context.Translate("Smartphone")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("B","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("B",CPLib.Trim(BO.w_oaappdevtyp))?"SELECTED":"")+">" +
     ""+status.context.Translate("MOBAPPSTORE_BOTHDEVICE")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('FBEIHIJGFG'),w_oaappdevtyp,'C');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span title="+SPLib.ToHTMLValue(status.context.Translate("MOBAPPSTORE_REQUIRE_REGISTRATION"),"C",0,0)+" id='HRCRJRTGHT_DIV'>" +
     "<input name='oaappreqreg' id='HRCRJRTGHT' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_oaappreqreg,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_oaappreqreg)?"CHECKED":"")+">" +
     "<label id='HRCRJRTGHT_LBL' for='HRCRJRTGHT' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_REQUIRE_REGISTRATION"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='oaappurlreg' id='LDPQVCCVLI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_oaappurlreg,"C",255,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("MOBAPPSTORE_URL_REGISTRATION"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='255' size='255' fieldtype='C' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XRODPYXFDF_DIV' style='display:none'>" +
     "<label id='XRODPYXFDF' for='LDPQVCCVLI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MOBAPPSTORE_URL_REGISTRATION"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b0(spadministration_mobappstoreBO BO,ServletStatus status) {
    status.out.println(
     "<div style='position:relative;height:260px'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='spadministration_dmobapp_qkm' id='OIOVQVCCYP' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b0(spadministration_mobappstoreBO BO,ServletStatus status) {
    status.out.println(
     "<div style='position:relative;height:245px'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='spadministration_mobapppermissions' id='XNQZSXVGTN' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  static void PrintState(spadministration_mobappstoreBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(spadministration_mobappstoreBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
    if (BO.spadministration_dmobapp_qkm.IsUpdated()) {
      BO.m_cWv_spadministration_dmobapp_qkm = BO.spadministration_dmobapp_qkm.GetContext();
    }
    if (BO.spadministration_mobapppermissions.IsUpdated()) {
      BO.m_cWv_spadministration_mobapppermissions = BO.spadministration_mobapppermissions.GetContext();
    }
  }
  static void PrintStateWorkVars(spadministration_mobappstoreBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_oa__code,"C",10,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_oa__code:BO.w_oa__code,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oaapppublished,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oareserved,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oaappmenu,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oaapptitle,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oadescri,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oaapplogo,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oaappfavico,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oaapplanding,"C",255,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oaskinname,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oaappvariantname,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oaappheader,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oaappdescrheader,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oaapphideutilitygroup,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oaapphomelink,"C",255,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oaappchecksum,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OAAPPACCESSMODE,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oaappdevtyp,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oaappreqreg,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oaappurlreg,"C",255,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_changeSkin,"L",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_combo_homelink,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_custom_homelink,"C",255,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_forceCreateFile,"L",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ignoreFile,"L",1,0));
    if (CPLib.eq(BO.m_cWv_spadministration_dmobapp_qkm,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_spadministration_dmobapp_qkm");
    } else if (CPLib.eq(BO.m_cWv_spadministration_dmobapp_qkm,"_not_empty_")) {
      BO.m_cWv_spadministration_dmobapp_qkm = BO.spadministration_dmobapp_qkm.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_spadministration_dmobapp_qkm,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_spadministration_dmobapp_qkm,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_spadministration_mobapppermissions,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_spadministration_mobapppermissions");
    } else if (CPLib.eq(BO.m_cWv_spadministration_mobapppermissions,"_not_empty_")) {
      BO.m_cWv_spadministration_mobapppermissions = BO.spadministration_mobapppermissions.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_spadministration_mobapppermissions,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_spadministration_mobapppermissions,"C",0,0));
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(spadministration_mobappstoreBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(685,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(840,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"spadministration_mobappstore"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      AppendCallableIDS(status,"");
    } else {
      AppendCallableIDS(status,"");
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
      status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("spadministration_mobappstore","C",0,0)+ ";");
    }
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"spadministration_mobappstore",BO.GetCurrentState());
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
  void WriteMainFormScript(spadministration_mobappstoreBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("Z.Tabs.Get('tabs').InitSelect('spadministration_mobappstore',false);");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('BXPAETNPNW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SNIXYTTVQQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZLZSHHUAAO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HGEWTTQPUR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DIVZDHWPRQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XGINRSLGED')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('THXHMWDAPZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QYLTLWYYSH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LHWJXXROEN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UZJHJSBNKL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JKORHAZIKU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LRTLIAYQMN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MRNRGZRDQJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CUOPMOHONZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DAMSKDIPPB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EYZZDYMIDO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LMGRJMFNAF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZOTPWYUMVB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GJRUFNPOQO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZMJJCHDRPF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FBEIHIJGFG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HRCRJRTGHT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LDPQVCCVLI')) SetDisabled(c,true);");
      }
      status.out.println("HideControlsUnderCondition();");
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
      status.out.println("if (Ctrl('OIOVQVCCYP')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('OIOVQVCCYP',linkpc_url('OIOVQVCCYP'));");
      status.out.println("}");
      status.out.println("if (Ctrl('XNQZSXVGTN')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('XNQZSXVGTN',linkpc_url('XNQZSXVGTN'));");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('BXPAETNPNW')) SetDisabled(c,true);");
      }
    }
    status.out.println("FillCombosValues();");
    status.out.println("SetControlsValue();");
    status.out.println("NotifyEvent('Record Loaded');");
    status.out.println("LoadContext();");
    status.out.println("// * --- Area Manuale = UI - OnLoad End");
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
    status.out.println("if (Eq(name,'spadministration_dmobapp_qkm')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"spadministration_dmobapp_qkm")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'spadministration_mobapppermissions')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"spadministration_mobapppermissions")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    ChildSelectedPageChild(BO.m_MNTs,status,status.m_cSelectedPage);
    status.out.println("}");
    if (CPLib.ne(status.m_cClientMode,"query")) {
      status.out.println("function UpdateAutonumber(p_uid) {");
      status.out.println("}");
    }
    WriteJSError(status);
    WriteTableCombo(status,BO);
    status.out.println("// * --- Area Manuale = UI - Functions & Procedures");
    status.out.println("// * --- spadministration_mobappstore");
    status.out.println("function calc_url(){");
    status.out.println("  return window.SPWebRootURL || ZtVWeb.SPWebRootURL;");
    status.out.println("}");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  spadministration_mobappstoreBO getBO(ServletStatus status) {
    spadministration_mobappstoreBO BO = new spadministration_mobappstoreBO(status.context);
    // gli op_ possono essere utilizzati dalla servlet anche prima di essere inizializzati
    BO.op_oa__code = BO.w_oa__code;
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(spadministration_mobappstoreBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("cpappstore",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,spadministration_mobappstoreBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,spadministration_mobappstoreBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
  }
  CPResultSet QueryKeyCursor(spadministration_mobappstoreBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_cpappstore;
    String l_cPhName = BO.m_cPhName_cpappstore;
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
      String l_cQueryFilter = spadministration_mobappstoreBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_cpappstore+".oa__code",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("cpappstore");
    String l_cPhName = CPSql.ManipulateTablePhName("cpappstore",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".oa__code",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,spadministration_mobappstoreBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = spadministration_mobappstoreBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_cpappstore,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_cpappstore,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,spadministration_mobappstoreBO BO) {
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
  void Edit(ServletStatus status,spadministration_mobappstoreBO BO,SPParameterSource source) {
    BO.Load(status.w_oa__code);
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
  void New(ServletStatus status,spadministration_mobappstoreBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,spadministration_mobappstoreBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,spadministration_mobappstoreBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_oa__code = "";
      } else {
        BO.w_oa__code = l_rsKeys.GetString("oa__code");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_oa__code = BO.w_oa__code;
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
  void EditLoad(ServletStatus status,spadministration_mobappstoreBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,spadministration_mobappstoreBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_oa__code);
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
  void DeleteMessage(ServletStatus status,spadministration_mobappstoreBO BO,SPParameterSource source) {
    BO.Load(status.w_oa__code);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,spadministration_mobappstoreBO BO) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    String l_cTransMsgErr = "";
    BO.SetFromContext(status.m_cWv,status.m_Parameters);
    String l_old_oa__code = "";
    if (CPLib.ne(BO.w_oa__code,BO.op_oa__code)) {
      l_old_oa__code = BO.op_oa__code;
    }
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({oa__code:"+SPLib.ToJSValue(BO.w_oa__code,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
      if ( ! (CPLib.Empty(l_old_oa__code))) {
        BO.op_oa__code = l_old_oa__code;
      }
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
  void Discard(ServletStatus status,spadministration_mobappstoreBO BO) {
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
  void CreatePortlet(ServletStatus status,spadministration_mobappstoreBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",685);
    item.put("w",840);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","true");
    org.json.JSONObject pageProp = null;
    org.json.JSONArray pagesProp = null;
    pagesProp = new org.json.JSONArray();
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"App mobile online\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Quick menu\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Permessi\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","App mobile online,Quick menu,Permessi");
    item.put("altInterfaceFor","spadministration_mobappstore");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"comment\":\"MOBAPPSTORE_CODE\",\"h\":25,\"maxlength\":10,\"name\":\"oa__code\",\"page\":1,\"spuid\":\"BXPAETNPNW\",\"tabindex\":1,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":83,\"x\":205,\"y\":15,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_KVKRLLIGYM\",\"page\":1,\"spuid\":\"KVKRLLIGYM\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"MOBAPPSTORE_CODE\",\"w\":201,\"x\":0,\"y\":15,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Published\",\"h\":25,\"label_text\":\"MOBAPPSTORE_PUBLISHED\",\"maxlength\":2,\"name\":\"oaapppublished\",\"page\":1,\"spuid\":\"SNIXYTTVQQ\",\"tabindex\":2,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":78,\"x\":588,\"y\":15,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Profilata\",\"h\":25,\"label_text\":\"MOBAPPSTORE_PROFILED\",\"maxlength\":1,\"name\":\"oareserved\",\"page\":1,\"spuid\":\"ZLZSHHUAAO\",\"tabindex\":4,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":96,\"x\":692,\"y\":15,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"MOBAPPSTORE_MENU_APPL\",\"h\":25,\"maxlength\":100,\"name\":\"oaappmenu\",\"page\":1,\"spuid\":\"HGEWTTQPUR\",\"tabindex\":5,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":460,\"x\":206,\"y\":50,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_TZKFFVHPXC\",\"page\":1,\"spuid\":\"TZKFFVHPXC\",\"tabindex\":6,\"type\":\"Label\",\"value\":\"MOBAPPSTORE_MENU_APPL\",\"w\":201,\"x\":0,\"y\":50,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"MOBAPPSTORE_TITLE\",\"h\":25,\"maxlength\":50,\"name\":\"oaapptitle\",\"page\":1,\"spuid\":\"DIVZDHWPRQ\",\"tabindex\":7,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":589,\"x\":205,\"y\":85,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_FSDGYBMNYQ\",\"page\":1,\"spuid\":\"FSDGYBMNYQ\",\"tabindex\":8,\"type\":\"Label\",\"value\":\"MOBAPPSTORE_TITLE\",\"w\":201,\"x\":0,\"y\":85,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"MOBAPPSTORE_DESCRIPTION\",\"h\":105,\"name\":\"oadescri\",\"page\":1,\"scroll\":true,\"spuid\":\"XGINRSLGED\",\"tabindex\":9,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":588,\"x\":206,\"y\":120,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_CTNJEDTGDD\",\"page\":1,\"spuid\":\"CTNJEDTGDD\",\"tabindex\":10,\"type\":\"Label\",\"value\":\"MOBAPPSTORE_DESCRIPTION\",\"w\":201,\"x\":0,\"y\":120,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"MOBAPPSTORE_LOGO\",\"h\":25,\"maxlength\":50,\"name\":\"oaapplogo\",\"page\":1,\"spuid\":\"THXHMWDAPZ\",\"tabindex\":11,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":589,\"x\":205,\"y\":235,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_HMQXIQLADZ\",\"page\":1,\"spuid\":\"HMQXIQLADZ\",\"tabindex\":12,\"type\":\"Label\",\"value\":\"MOBAPPSTORE_LOGO\",\"w\":201,\"x\":0,\"y\":235,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"MOBAPPSTORE_ICON\",\"h\":25,\"maxlength\":50,\"name\":\"oaappfavico\",\"page\":1,\"spuid\":\"QYLTLWYYSH\",\"tabindex\":13,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":589,\"x\":205,\"y\":270,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_XEBDOBFQBZ\",\"page\":1,\"spuid\":\"XEBDOBFQBZ\",\"tabindex\":14,\"type\":\"Label\",\"value\":\"MOBAPPSTORE_ICON\",\"w\":201,\"x\":0,\"y\":270,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Landing page\",\"h\":25,\"maxlength\":255,\"name\":\"oaapplanding\",\"page\":1,\"spuid\":\"LHWJXXROEN\",\"tabindex\":15,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":589,\"x\":205,\"y\":305,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_DSXRDZXBTT\",\"page\":1,\"spuid\":\"DSXRDZXBTT\",\"tabindex\":16,\"type\":\"Label\",\"value\":\"MOBAPPSTORE_LANDING\",\"w\":201,\"x\":0,\"y\":305,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome Skin\",\"h\":25,\"maxlength\":30,\"name\":\"oaskinname\",\"page\":1,\"spuid\":\"UZJHJSBNKL\",\"tabindex\":17,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":223,\"x\":205,\"y\":340,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"true\",\"h\":25,\"label_text\":\"MOBAPPSTORE_CHANGE_SKIN\",\"maxlength\":1,\"name\":\"changeSkin\",\"page\":1,\"spuid\":\"JKORHAZIKU\",\"tabindex\":18,\"type\":\"Checkbox\",\"typevar\":\"logic\",\"unchecked_value\":\"false\",\"w\":234,\"x\":434,\"y\":340,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_JLTWHMFXTO\",\"page\":1,\"spuid\":\"JLTWHMFXTO\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"MOBAPPSTORE_SKIN_NAME\",\"w\":201,\"x\":0,\"y\":340,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Variant name\",\"h\":25,\"maxlength\":30,\"name\":\"oaappvariantname\",\"page\":1,\"spuid\":\"LRTLIAYQMN\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":223,\"x\":205,\"y\":375,\"zone\":\"pag1_10\",\"zonepath\":\"[1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_MVNSCJDAFX\",\"page\":1,\"spuid\":\"MVNSCJDAFX\",\"tabindex\":21,\"type\":\"Label\",\"value\":\"MOBAPPSTORE_VARIANT_NAME\",\"w\":201,\"x\":0,\"y\":375,\"zone\":\"pag1_10\",\"zonepath\":\"[1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Header image\",\"h\":25,\"maxlength\":50,\"name\":\"oaappheader\",\"page\":1,\"spuid\":\"MRNRGZRDQJ\",\"tabindex\":22,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":363,\"x\":205,\"y\":410,\"zone\":\"pag1_11\",\"zonepath\":\"[1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_ICRRPRBHAK\",\"page\":1,\"spuid\":\"ICRRPRBHAK\",\"tabindex\":23,\"type\":\"Label\",\"value\":\"MOBAPPSTORE_HEADER_IMG\",\"w\":201,\"x\":0,\"y\":410,\"zone\":\"pag1_11\",\"zonepath\":\"[1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Description header\",\"h\":25,\"maxlength\":50,\"name\":\"oaappdescrheader\",\"page\":1,\"spuid\":\"CUOPMOHONZ\",\"tabindex\":24,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":363,\"x\":205,\"y\":445,\"zone\":\"pag1_12\",\"zonepath\":\"[1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_QHPVOKFJDL\",\"page\":1,\"spuid\":\"QHPVOKFJDL\",\"tabindex\":25,\"type\":\"Label\",\"value\":\"MOBAPPSTORE_HEADER_DESC\",\"w\":201,\"x\":0,\"y\":445,\"zone\":\"pag1_12\",\"zonepath\":\"[1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"MOBAPPSTORE_HIDE_UTILITY_GROUP\",\"h\":25,\"label_text\":\"MOBAPPSTORE_HIDE_UTILITY_GROUP\",\"maxlength\":2,\"name\":\"oaapphideutilitygroup\",\"page\":1,\"spuid\":\"DAMSKDIPPB\",\"tabindex\":26,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":276,\"x\":206,\"y\":480,\"zone\":\"pag1_13\",\"zonepath\":\"[1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"MOBAPPSTORE_HOME_BUTTON_LINK\",\"empty_value\":\"false\",\"h\":25,\"maxlength\":2,\"name\":\"combo_homelink\",\"page\":1,\"spuid\":\"LMGRJMFNAF\",\"tabindex\":28,\"textlist\":\"Login Page,Default Page,Custom URL\",\"type\":\"Combobox\",\"typevar\":\"numeric\",\"valuelist\":\"1,2,3\",\"w\":102,\"x\":206,\"y\":515,\"zone\":\"pag1_14\",\"zonepath\":\"[1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"maxlength\":255,\"name\":\"custom_homelink\",\"page\":1,\"spuid\":\"ZOTPWYUMVB\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":485,\"x\":309,\"y\":515,\"zone\":\"pag1_14\",\"zonepath\":\"[1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_NCFRRVPJOU\",\"page\":1,\"spuid\":\"NCFRRVPJOU\",\"tabindex\":30,\"type\":\"Label\",\"value\":\"MOBAPPSTORE_HOME_BUTTON_LINK\",\"w\":201,\"x\":0,\"y\":515,\"zone\":\"pag1_14\",\"zonepath\":\"[1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cheksum\",\"h\":25,\"maxlength\":20,\"name\":\"oaappchecksum\",\"page\":1,\"spuid\":\"GJRUFNPOQO\",\"tabindex\":31,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":153,\"x\":206,\"y\":550,\"zone\":\"pag1_15\",\"zonepath\":\"[1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_GFKDYWNVED\",\"page\":1,\"spuid\":\"GFKDYWNVED\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"MOBAPPSTORE_CHECKSUM\",\"w\":201,\"x\":0,\"y\":550,\"zone\":\"pag1_15\",\"zonepath\":\"[1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Access mode\",\"empty_value\":\"false\",\"h\":25,\"maxlength\":30,\"name\":\"OAAPPACCESSMODE\",\"page\":1,\"spuid\":\"ZMJJCHDRPF\",\"tabindex\":33,\"textlist\":\"MSG_MOBAPPSTORE_ACCESS_MODE_BROWSER,MSG_MOBAPPSTORE_ACCESS_MODE_HYBRID,MSG_MOBAPPSTORE_ACCESS_MODE_BROWSER_AND_HYBRID\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"browser_only"+"'"+","+"'"+"hybrid_only"+"'"+","+"'"+"browser_and_hybrid"+"'"+"\",\"w\":223,\"x\":206,\"y\":585,\"zone\":\"pag1_16\",\"zonepath\":\"[1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_CPQRMTYZXV\",\"page\":1,\"spuid\":\"CPQRMTYZXV\",\"tabindex\":34,\"type\":\"Label\",\"value\":\"MOBAPPSTORE_ACCESS_MODE\",\"w\":243,\"x\":-45,\"y\":585,\"zone\":\"pag1_16\",\"zonepath\":\"[1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_TWZFAYGLKC\",\"page\":1,\"spuid\":\"TWZFAYGLKC\",\"tabindex\":35,\"type\":\"Label\",\"value\":\"MOBAPPSTORE_DESIGNEDFOR\",\"w\":118,\"x\":473,\"y\":585,\"zone\":\"pag1_16\",\"zonepath\":\"[1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Designed for\",\"empty_value\":\"false\",\"h\":25,\"maxlength\":1,\"name\":\"oaappdevtyp\",\"page\":1,\"spuid\":\"FBEIHIJGFG\",\"tabindex\":36,\"textlist\":\"Tablet,Smartphone,MOBAPPSTORE_BOTHDEVICE\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"T"+"'"+","+"'"+"S"+"'"+","+"'"+"B"+"'"+"\",\"w\":192,\"x\":599,\"y\":600,\"zone\":\"pag1_17\",\"zonepath\":\"[1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"MOBAPPSTORE_REQUIRE_REGISTRATION\",\"h\":25,\"label_text\":\"MOBAPPSTORE_REQUIRE_REGISTRATION\",\"maxlength\":2,\"name\":\"oaappreqreg\",\"page\":1,\"spuid\":\"HRCRJRTGHT\",\"tabindex\":37,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":276,\"x\":206,\"y\":620,\"zone\":\"pag1_18\",\"zonepath\":\"[1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"MOBAPPSTORE_URL_REGISTRATION\",\"h\":25,\"maxlength\":255,\"name\":\"oaappurlreg\",\"page\":1,\"spuid\":\"LDPQVCCVLI\",\"tabindex\":38,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":589,\"x\":206,\"y\":655,\"zone\":\"pag1_19\",\"zonepath\":\"[1,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_XRODPYXFDF\",\"page\":1,\"spuid\":\"XRODPYXFDF\",\"tabindex\":39,\"type\":\"Label\",\"value\":\"MOBAPPSTORE_URL_REGISTRATION\",\"w\":201,\"x\":0,\"y\":655,\"zone\":\"pag1_19\",\"zonepath\":\"[1,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":240,\"name\":\"spadministration_dmobapp_qkm\",\"page\":2,\"spuid\":\"OIOVQVCCYP\",\"tabindex\":1,\"type\":\"Iframe\",\"w\":827,\"x\":8,\"y\":15,\"zone\":\"pag2_1\",\"zonepath\":\"[2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":225,\"name\":\"spadministration_mobapppermissions\",\"page\":3,\"spuid\":\"XNQZSXVGTN\",\"tabindex\":1,\"type\":\"Iframe\",\"w\":648,\"x\":7,\"y\":15,\"zone\":\"pag3_1\",\"zonepath\":\"[3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(spadministration_mobappstoreBO BO,ServletStatus status) {
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
     "<script src='spadministration_mobappstore?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/spadministration_mobappstore_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/spadministration_mobappstore_edit.js'>" +
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
      status.out.println("w_oa__code=a[0];");
      status.out.println("op_oa__code=a[1];");
      status.out.println("w_oaapppublished=a[2];");
      status.out.println("w_oareserved=a[3];");
      status.out.println("w_oaappmenu=a[4];");
      status.out.println("w_oaapptitle=a[5];");
      status.out.println("w_oadescri=a[6];");
      status.out.println("w_oaapplogo=a[7];");
      status.out.println("w_oaappfavico=a[8];");
      status.out.println("w_oaapplanding=a[9];");
      status.out.println("w_oaskinname=a[10];");
      status.out.println("w_oaappvariantname=a[11];");
      status.out.println("w_oaappheader=a[12];");
      status.out.println("w_oaappdescrheader=a[13];");
      status.out.println("w_oaapphideutilitygroup=a[14];");
      status.out.println("w_oaapphomelink=a[15];");
      status.out.println("w_oaappchecksum=a[16];");
      status.out.println("w_OAAPPACCESSMODE=a[17];");
      status.out.println("w_oaappdevtyp=a[18];");
      status.out.println("w_oaappreqreg=a[19];");
      status.out.println("w_oaappurlreg=a[20];");
      status.out.println("w_changeSkin=a[21];");
      status.out.println("w_combo_homelink=a[22];");
      status.out.println("w_custom_homelink=a[23];");
      status.out.println("w_forceCreateFile=a[24];");
      status.out.println("w_ignoreFile=a[25];");
      status.out.println("m_cWv_spadministration_dmobapp_qkm=a[26];");
      status.out.println("m_cWv_spadministration_mobapppermissions=a[27];");
      status.out.println("if (Gt(a.length,28)) {");
      status.out.println("m_cErrorInChild='';");
      status.out.println("}");
      status.out.println("if (Gt(a.length,28)) {");
      status.out.println("o_oaappreqreg=w_oaappreqreg;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['oa__code'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/spadministration_mobappstore_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(685,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
    status.out.println(
     "<script>" +
    "");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("AppletTag('Autonumber');");
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
    f.SetParameter("Table","cpappstore");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","oa__code");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(spadministration_mobappstoreBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({oa__code:"+SPLib.ToJSValue(BO.w_oa__code,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(spadministration_mobappstoreBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({oa__code:"+SPLib.ToJSValue(BO.w_oa__code,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(spadministration_mobappstoreBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({oa__code:"+SPLib.ToJSValue(BO.w_oa__code,"C",10,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(spadministration_mobappstoreBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({oa__code:"+SPLib.ToJSValue(BO.w_oa__code,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(spadministration_mobappstoreBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({oa__code:"+SPLib.ToJSValue(BO.w_oa__code,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(spadministration_mobappstoreBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(spadministration_mobappstoreBO BO,ServletStatus status) throws IOException {
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
    /* --- Area Manuale = UI - Include */
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
      CPLib.AddToSet(callable,"spadministration_dmobapp_qkm");
      CPLib.AddToSet(callable,"spadministration_mobapppermissions");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,spadministration_mobappstoreBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_oa__code),"C",10,0));
      }
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,spadministration_mobappstoreBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
    }
    return result;
  }
}
