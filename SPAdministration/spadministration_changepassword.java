import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class spadministration_changepassword extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*ed4eff60*!";
  static public class ServletStatus extends SPDialogServletStatus {
    public void MergeCallerVars(SPParameterSource source) {
      source.SetParameter("old_password",source.GetCaller().GetString("old_password","C",20,0));
      source.SetParameter("new_password",source.GetCaller().GetString("new_password","C",20,0));
      source.SetParameter("confirm_password",source.GetCaller().GetString("confirm_password","C",20,0));
      source.SetParameter("errormessage",source.GetCaller().GetString("errormessage","M",10,0));
      source.SetParameter("cachekey",source.GetCaller().GetString("cachekey","C",20,0));
      source.SetParameter("root_m_cURL_servlet",source.GetCaller().GetString("root_m_cURL_servlet","C",100,0));
      source.SetParameter("changeReason",source.GetCaller().GetString("changeReason","C",20,0));
      source.SetParameter("m_cAtExit",source.GetCaller().GetString("m_cAtExit","C",100,0));
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
    spadministration_changepasswordBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    if (CPLib.eq(status.m_cAction,"start") || CPLib.eq(status.m_cAction,"query")) {
      Start(status,BO);
    } else if (CPLib.eq(status.m_cAction,"save")) {
      Save(status,BO);
    } else if (CPLib.eq(status.m_cAction,"discard")) {
      Discard(status,BO);
    } else if (CPLib.eq(status.m_cAction,"painter")) {
      Painter(status);
    }
    // * --- Area Manuale = Do Action
    // * --- Fine Area Manuale
    if (status.m_bExit &&  ! (CPLib.Empty(status.m_cAtExit))) {
      if (CPLib.eq(CPLib.Left(status.m_cAtExit,8),"workflow")) {
        ExitToWorkflow(status);
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
    } else if ( ! (CPLib.Empty(BO.LastErrorMessage()))) {
      // verra' stampato l'alert dopo
      status.m_bError = true;
    } else if ( ! (Forward.IsForwarded(status.forwardedto)) && CPLib.ne(status.m_cAction,"start")) {
      // verra' visualizzata l'interfaccia: le locali devono essere azzerate dopo la prima visualizzazione
      String pseq = ","+status.source.GetParameter("m_cParameterSequence","")+",";
      if (CPLib.eq(CPLib.At(",calcomplex,",pseq),0)) {
        BO.w_calcomplex = 0;
      }
      if (CPLib.eq(CPLib.At(",pwdcomplexity,",pseq),0)) {
        BO.w_pwdcomplexity = 0;
      }
      if (CPLib.eq(CPLib.At(",pwddaysduration,",pseq),0)) {
        BO.w_pwddaysduration = 0;
      }
      if (CPLib.eq(CPLib.At(",pwdciclicity,",pseq),0)) {
        BO.w_pwdciclicity = 0;
      }
      if (CPLib.eq(CPLib.At(",pwdcaptchalevel_applied,",pseq),0)) {
        BO.w_pwdcaptchalevel_applied = 0;
      }
      if (CPLib.eq(CPLib.At(",pwdratecause,",pseq),0)) {
        BO.w_pwdratecause = "";
      }
      if (CPLib.eq(CPLib.At(",pwd1_view,",pseq),0)) {
        BO.w_pwd1_view = false;
      }
      if (CPLib.eq(CPLib.At(",pwd2_view,",pseq),0)) {
        BO.w_pwd2_view = false;
      }
      if (CPLib.eq(CPLib.At(",pwd3_view,",pseq),0)) {
        BO.w_pwd3_view = false;
      }
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
    status.out = response.getWriter();
    if (CPLib.eq(status.m_cClientMode,"close")) {
      WriteExitPage(status);
    } else if (CPLib.eq(status.m_cAction,"createportlet")) {
      CreatePortlet(status,BO);
    } else {
      WriteFormPage(BO,status);
    }
  }
  public String getEntityTitle() {
    return "MSG_CHANGE_PASSWORD";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "spadministration_changepassword";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 701;
    l_eg.m_nEntityHeight = 200;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page"),new ZoneItem("pwdratecause_layer","","layer")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.items = new SPItem[]{
                   new SPItem("old_password","C",20,0, "edit","MSG_OLD_PASSWORD"),
                   new SPItem("new_password","C",20,0, "edit","MSG_NEW_PASSWORD"),
                   new SPItem("confirm_password","C",20,0, "edit","MSG_CONFIRM_PASSWORD"),
                   new SPItem("errormessage","M",10,0, "hide",""),
                   new SPItem("calcomplex","N",3,0, "show","Complessità password"),
                   new SPItem("pwdcomplexity","N",3,0, "show","ADMIN_PWDCOMPLEXITY_MINIMUM"),
                   new SPItem("pwddaysduration","N",4,0, "show","ADMIN_PWDDAYSDURATION"),
                   new SPItem("cachekey","C",20,0, "hide",""),
                   new SPItem("root_m_cURL_servlet","C",100,0, "hide",""),
                   new SPItem("pwdciclicity","N",4,0, "show","ADMIN_PWDCICLICITY"),
                   new SPItem("pwdcaptchalevel_applied","N",4,0, "show","ADMIN_CAPTCHA_LEVEL"),
                   new SPItem("pwdratecause","M",10,0, "show",""),
                   new SPItem("changeReason","C",20,0, "hide",""),
                   new SPItem("m_cAtExit","C",100,0, "hide",""),
                   new SPItem("pwd1_view","L",1,0, "hide",""),
                   new SPItem("pwd2_view","L",1,0, "hide",""),
                   new SPItem("pwd3_view","L",1,0, "hide","")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,spadministration_changepasswordBO BO) {
    CPMNTChild[] l_MNTs = null;
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
      m_ManualBlockTranslations = com.zucchetti.sitepainter.Library.findFormatMsg("iif(w_changeReason="+"'"+"expire"+"'"+",FormatMsg("+"'"+"ADMIN_PASSWORD_EXPIRED"+"'"+"),FormatMsg("+"'"+"ADMIN_NEW_PASSWORD"+"'"+"))"+" "+"FormatMsg("+"'"+"ADMIN_PASSWORD_VERDICT"+"'"+") + "+"'"+": "+"'"+" + UserAdmin.GetPasswordVerdict(w_new_password)"+" "+"FormatMsg( "+"'"+"ADMIN_PWD_COMPLEXITY_RATE"+"'"+",  iif( w_calcomplex<=15,    FormatMsg( "+"'"+"ADMIN_PASSWORD_VERY_WEAK"+"'"+" ),    iif( w_calcomplex<25,       FormatMsg( "+"'"+"ADMIN_PASSWORD_WEAK"+"'"+" ),       iif( w_calcomplex<35,         FormatMsg( "+"'"+"ADMIN_PASSWORD_MEDIOCRE"+"'"+" ),         iif (w_calcomplex<45,           FormatMsg( "+"'"+"ADMIN_PASSWORD_STRONG"+"'"+" ),          FormatMsg( "+"'"+"ADMIN_PASSWORD_STRONGER"+"'"+" )        )      )     )  ), LRTrim(Str(w_calcomplex)), LRTrim(Str(w_pwdcomplexity)))");
    }
    return m_ManualBlockTranslations;
  }
  public String[][] JSTranslations(CPContext p_Context) {
    String[][] l_translations;
    l_translations=new String[][]{{"10075957577",p_Context.Translate("ADMIN_CAPTCHA_LEVEL")},
    {"10297801341",p_Context.Translate("MSG_CHANGE_PASSWORD")},
    {"10487537699",p_Context.Translate("MSG_NEW_PASSWORD")},
    {"1076819334",p_Context.Translate("ADMIN_PWDDAYSDURATION")},
    {"10798899235",p_Context.Translate("MSG_OLD_PASSWORD")},
    {"10891053757",p_Context.Translate("ADMIN_PWDCOMPLEXITYRATE_EXPL")},
    {"1110746968",p_Context.Translate("MSG_WEAKY_PASSWORD")},
    {"1149789373",p_Context.Translate("MSG_CONFIRM_PASSWORD_HELPTIP")},
    {"11641847591",p_Context.Translate("ADMIN_PWDCICLICITY")},
    {"1397560643",p_Context.Translate("Complessità password")},
    {"1670742889",p_Context.Translate("ADMIN_MAXIMUM")},
    {"1848680752",p_Context.Translate("MSG_PASSWORD_CONFIRM_DIFFERENT")},
    {"1933288987",p_Context.Translate("ADMIN_PWDCOMPLEXITY_MINIMUM")},
    {"2068121389",p_Context.Translate("MSG_PASSWORD_MUST_DIFFERENT")},
    {"519491004",p_Context.Translate("MSG_OLD_PASSWORD_HELPTIP")},
    {"794953577",p_Context.Translate("ADMIN_PASSWORD_VERDICT")},
    {"830852540",p_Context.Translate("MSG_NEW_PASSWORD_HELPTIP")},
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
  void WriteStyles(spadministration_changepasswordBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../spadministration_changepassword.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(spadministration_changepasswordBO BO,ServletStatus status) {
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
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      status.request.setAttribute("com__zucchetti__sitepainter__altinterface__url",status.m_cAltInterface);
      status.request.setAttribute("com__zucchetti__sitepainter__altinterface__m_cEntityUid",m_cEntityUid);
      SPLib.Include(servletContext,status,status.m_cAltInterface);
    } else {
      WriteControls(BO,status);
    }
    status.out.println(
     "</div>" +
    "");
  }
  // GetPortlet_password_meter_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_AZTVNXSPBF_Vars(spadministration_changepasswordBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"pMin",0);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"pMax",50);
    return inclusionVars;
  }
  void WriteControls(spadministration_changepasswordBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(spadministration_changepasswordBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:200px;width:701px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteControls_p1_l0(BO,status);
    PrintSidebarContent(1,status,getSidebarItems(0),false);
    PrintContextMenu(1,status,getContextMenu(0),"spadministration");
    status.out.println(
     "</div>" +
    "");
    if ( ! (false)) {
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('page_1').style.display='block';");
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteControls_p1_l0(spadministration_changepasswordBO BO,ServletStatus status) {
    status.out.println(
     "<div style='display:none' class='LayerContainer' id='HITFFRVPXU_DIV'>" +
     "<div id='HITFFRVPXU_HEADER' onmousedown=\"dragLayer(event,'HITFFRVPXU_DIV')\" class='LayerHeader'><span id='HITFFRVPXU_HEADER_CAPTION' class='LayerHeaderCaption'></span>"+com.zucchetti.sitepainter.Library.GenerateIcon(com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "layerHeaderPinImage", "../"+status.m_cTheme+"/formPage/box_layer_pin.gif"), "", "", "onclick='TogglePinLayerBox(\"HITFFRVPXU\")' alt='"+status.context.Translate("MSG_PIN_UNPIN")+"' title='"+status.context.Translate("MSG_PIN_UNPIN")+"' class='LayerHeaderIconPin'", "id='HITFFRVPXU_HEADER_ICON_PIN'")+""+com.zucchetti.sitepainter.Library.GenerateIcon(com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "layerHeaderCloseImage", "../"+status.m_cTheme+"/formPage/box_layer_close.gif"), "", "", "onclick='HideLayerBox(\"HITFFRVPXU_DIV\",false)' alt='"+status.context.Translate("MSG_CLOSE_ONEXIT")+"' title='"+status.context.Translate("MSG_CLOSE_ONEXIT")+"' class='LayerHeaderIconClose'")+"</div>" +
     "<div id='HITFFRVPXU' class='LayerBody'>" +
    "");
    if (status.includeZoneAltInterface(status.context,"pwdratecause_layer")) {
    } else {
      status.out.println(
       "<textarea name='pwdratecause' id='ESFOZDXNLZ' class='Memo Disabled' tabindex='-1' readonly cols='20' rows='2'>" +
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
    status.out.println("Ctrl('HITFFRVPXU_DIV').setAttribute('pin_status','unpinned');");
    if (CPLib.IsNull(status.GetZoneAltInterface("pwdratecause_layer"))) {
    } else {
      status.out.println("Ctrl('HITFFRVPXU').style.height='auto';");
    }
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b0(spadministration_changepasswordBO BO,ServletStatus status) {
    status.out.println(
     "<div style='position:relative;height:200px'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CJRLVMMWSK_DIV' style='display:none'>" +
     "<label id='CJRLVMMWSK'>" +
     ""+SPLib.ToHTMLRepresentation((CPLib.eq(BO.w_changeReason,"expire")?CPLib.FormatMsg("ADMIN_PASSWORD_EXPIRED"):CPLib.FormatMsg("ADMIN_NEW_PASSWORD")))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LDHKZVMTNN_DIV'>" +
     "<label id='LDHKZVMTNN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_F10_TO_CONTINUE"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='old_password' id='QDPGURJWZK' type='password' class='Field' value="+SPLib.ToHTMLValue(BO.w_old_password,"C",20,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("MSG_OLD_PASSWORD_HELPTIP"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='20' size='20' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QVTYQJROCD_DIV'>" +
     "<label id='QVTYQJROCD' for='QDPGURJWZK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MSG_OLD_PASSWORD"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='new_password' id='JRQGKMZTEH' type='password' class='Field' value="+SPLib.ToHTMLValue(BO.w_new_password,"C",20,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("MSG_NEW_PASSWORD_HELPTIP"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='20' size='20' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='INRIMFQZEF_DIV'>" +
     "<label id='INRIMFQZEF' for='JRQGKMZTEH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MSG_NEW_PASSWORD"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='confirm_password' id='WLGONTBMKR' type='password' class='Field' value="+SPLib.ToHTMLValue(BO.w_confirm_password,"C",20,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("MSG_CONFIRM_PASSWORD_HELPTIP"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='20' size='20' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RIUCOGNUSI_DIV'>" +
     "<label id='RIUCOGNUSI' for='WLGONTBMKR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MSG_CONFIRM_PASSWORD"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TJIVDOWYFZ_DIV'>" +
     "<label id='TJIVDOWYFZ'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_errormessage)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='calcomplex' id='OCVTPTBPNM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_calcomplex,"N",3,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='4' size='3' fieldtype='N' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HJGOYAFDPY_DIV' style='display:none'>" +
     "<label id='HJGOYAFDPY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_PWDCOMPLEXITY"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='pwdcomplexity' id='FGAIBUGBSI' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_pwdcomplexity,"N",3,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='4' size='3' fieldtype='N' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YSVBRIXOZI_DIV' style='display:none'>" +
     "<label id='YSVBRIXOZI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_PWDCOMPLEXITY_MINIMUM"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='pwddaysduration' id='MEKWOPJKAZ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_pwddaysduration,"N",4,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='5' size='4' fieldtype='N' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ALHQOJUXRU_DIV' style='display:none'>" +
     "<label id='ALHQOJUXRU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_PWDDAYSDURATION"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='pwdciclicity' id='BAYVBUTWST' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_pwdciclicity,"N",4,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='5' size='4' fieldtype='N' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TMVAYOSJOV_DIV' style='display:none'>" +
     "<label id='TMVAYOSJOV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("ADMIN_PWDCICLICITY"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JEWFKZZWJU_DIV' style='display:none'>" +
     "<label id='JEWFKZZWJU' title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_MAXIMUM"),"C",0,0)+">" +
     ""+SPLib.ToHTMLRepresentation("/"+UserAdmin.Make(status.context).GetPasswordRatingMaxReachable())+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VULSHKPYLK_DIV' style='display:none'>" +
     "<label id='VULSHKPYLK'>" +
     ""+SPLib.ToHTMLRepresentation("/"+UserAdmin.Make(status.context).GetPasswordRatingMaxReachable())+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='pwdcaptchalevel_applied' id='HSOEINWVPM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_pwdcaptchalevel_applied,"N",4,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='5' size='4' fieldtype='N' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='SQDRAMDHVL' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("?"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_PWDCOMPLEXITYRATE_EXPL"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
    "");
    status.out.println(
     "<div id='AZTVNXSPBF'>" +
    "");
    // GetPortlet_password_meter_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_AZTVNXSPBF;
    inclusionVars_AZTVNXSPBF = GetPortlet_AZTVNXSPBF_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_AZTVNXSPBF);
    String portletUID_AZTVNXSPBF = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp-system/spadministration_pwdmeter_portlet.jsp?ForcedPortletUID="+ portletUID_AZTVNXSPBF+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_AZTVNXSPBF),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.AZTVNXSPBF='"+portletUID_AZTVNXSPBF+"';" +
     "w_pwdMeter=ZtVWeb.getPortletById('"+portletUID_AZTVNXSPBF+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span onclick='href_XVYWBPODNF(this)' id='XVYWBPODNF_DIV' style='display:none'>" +
     "<label id='XVYWBPODNF' title="+SPLib.ToHTMLValue(status.context.Translate("ADMIN_PASSWORD_VERDICT"),"C",0,0)+">" +
     "<a href='javascript:void(0)' class='SPLabel' tabindex='"+status.m_nTabIndex+"' id='XVYWBPODNF_HREF' curTabIndex='"+status.m_nTabIndex+"'>" +
     ""+SPLib.ToHTMLRepresentation(CPLib.FormatMsg("ADMIN_PWD_COMPLEXITY_RATE",(CPLib.le(BO.w_calcomplex,15)?CPLib.FormatMsg("ADMIN_PASSWORD_VERY_WEAK"):(CPLib.lt(BO.w_calcomplex,25)?CPLib.FormatMsg("ADMIN_PASSWORD_WEAK"):(CPLib.lt(BO.w_calcomplex,35)?CPLib.FormatMsg("ADMIN_PASSWORD_MEDIOCRE"):(CPLib.lt(BO.w_calcomplex,45)?CPLib.FormatMsg("ADMIN_PASSWORD_STRONG"):CPLib.FormatMsg("ADMIN_PASSWORD_STRONGER"))))),CPLib.LRTrim(CPLib.Str(BO.w_calcomplex)),CPLib.LRTrim(CPLib.Str(BO.w_pwdcomplexity))))+"" +
     "</a>" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_ZZKRWOJQTG()' tabindex='-1' id='ZZKRWOJQTG_HREF' style='display:none'>" +
     "<span id='ZZKRWOJQTG'>" +
     ""+SPLib.ToHTMLRepresentation(Character.toString((char)61550))+"" +
     "</span>" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_OTBBXDQDET()' tabindex='-1' id='OTBBXDQDET_HREF' style='display:none'>" +
     "<span id='OTBBXDQDET'>" +
     ""+SPLib.ToHTMLRepresentation(Character.toString((char)61550))+"" +
     "</span>" +
     "</a>" +
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
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_YEUZQGQZIT()' tabindex='-1' id='YEUZQGQZIT_HREF' style='display:none'>" +
     "<span id='YEUZQGQZIT'>" +
     ""+SPLib.ToHTMLRepresentation(Character.toString((char)61550))+"" +
     "</span>" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_SCKKFWHTWV()' tabindex='-1' id='SCKKFWHTWV_HREF' style='display:none'>" +
     "<span id='SCKKFWHTWV'>" +
     ""+SPLib.ToHTMLRepresentation(Character.toString((char)61552))+"" +
     "</span>" +
     "</a>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  static void PrintState(spadministration_changepasswordBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(spadministration_changepasswordBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(spadministration_changepasswordBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_old_password,"C",20,0));
    status.out.print(","+"["+SPLib.ToJSValue(BO.w_new_password,"C",20,0)+","+SPLib.ToJSValue(BO.o_new_password,"C",20,0)+"]");
    status.out.print(","+SPLib.ToJSValue(BO.w_confirm_password,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_errormessage,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_calcomplex,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwdcomplexity,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwddaysduration,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_cachekey,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_root_m_cURL_servlet,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwdciclicity,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwdcaptchalevel_applied,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwdratecause,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_changeReason,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_m_cAtExit,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwd1_view,"L",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwd2_view,"L",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_pwd3_view,"L",1,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(spadministration_changepasswordBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_CJRLVMMWSK = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_TJIVDOWYFZ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_JEWFKZZWJU = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_VULSHKPYLK = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_HITFFRVPXU = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_XVYWBPODNF = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(200,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(701,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"spadministration_changepassword"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    AppendCallableIDS(status,"");
    status.out.println("}");
    if (true) {
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
      status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("spadministration_changepassword","C",0,0)+ ";");
    }
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"spadministration_changepassword","");
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
    if (CPLib.eq(status.GetZoneAltInterface("pwdratecause_layer"),"")) {
      status.quoteAndAppend("pwdratecause_layer","hide","box");
    }
    status.PrintStateArrays();
    status.out.println("var m_cFunction = " + SPLib.ToJSValue("dialog","C",0,0)+ ";");
    status.out.println("var m_nLastError = " + SPLib.ToJSValue(0,"I",0,0)+ ";");
    status.out.println("var m_cObblFieldName = " + SPLib.ToJSValue("","C",0,0)+ ";");
    status.out.println("var m_cLastMsgError = " + SPLib.ToJSValue("","C",0,0)+ ";");
    status.out.println("var m_cLastWorkVarError = " + SPLib.ToJSValue("","C",0,0)+ ";");
    status.out.println("var m_cLastWorkVarErrorMsg = " + SPLib.ToJSValue("","C",0,0)+ ";");
    status.out.println("var m_cCPCCCHK = " + SPLib.ToJSValue("","C",0,0)+ ";");
    status.out.println("// * --- Area Manuale = UI - Declare Variables");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteMainFormScript(spadministration_changepasswordBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("EnableControlsUnderCondition();");
    status.out.println("var l_bStart = " + SPLib.ToJSValue(CPLib.eq(status.m_cAction,"start"),"L",0,0)+ ";");
    status.out.println("var l_cParamSeq = " + SPLib.ToJSValue((CPLib.eq(status.m_cAction,"start")?","+status.source.GetParameter("m_cParameterSequence","")+",":""),"C",0,0)+ ";");
    status.out.println("initNoLocalVars((l_bStart?1:0),l_cParamSeq);");
    status.out.println("calculateSidebarBandsPosition('page_1');");
    if ( ! (status.m_bHasRS)) {
      status.out.println("SetRegionalSettings();");
    }
    status.out.println("ReloadMenu();");
    status.out.println("setEventHandlers(false);");
    if (CPLib.ne(status.m_cClientMode,"view")) {
      status.out.println("FocusFirstComponent();");
    }
    status.out.println("SetDynamicClasses();");
    status.out.println("SetCollapsibleCaptions();");
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
      }
    }
    status.out.println("FillCombosValues();");
    status.out.println("SetControlsValue();");
    status.out.println("NotifyEvent('Record Loaded');");
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
    WriteTableCombo(status,BO);
    status.out.println("// * --- Area Manuale = UI - Functions & Procedures");
    status.out.println("// * --- spadministration_changepassword");
    status.out.println("function SPAdmin_makeanchor() {");
    status.out.println("  return 'spadministration_changepassword';");
    status.out.println("}");
    status.out.println("");
    status.out.println("");
    status.out.println("function togglePwdView(uid) {");
    status.out.println("  var c;");
    status.out.println("  if (uid == 1) {");
    status.out.println("    c = 'QDPGURJWZK';");
    status.out.println("  } else if (uid == 2) {");
    status.out.println("    c = 'JRQGKMZTEH';");
    status.out.println("  } else if (uid == 3) {");
    status.out.println("    c = 'WLGONTBMKR';");
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
    status.out.println("");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  spadministration_changepasswordBO getBO(ServletStatus status) {
    spadministration_changepasswordBO BO = new spadministration_changepasswordBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(spadministration_changepasswordBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,spadministration_changepasswordBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,spadministration_changepasswordBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
  }
  void Start(ServletStatus status,spadministration_changepasswordBO BO) {
    BO.SetFromContext(status.m_cWv);
  }
  void Save(ServletStatus status,spadministration_changepasswordBO BO) {
    boolean l_bResult;
    BO.SetFromContext(status.m_cWv);
    l_bResult = BO.Save();
    Forward f;
    f=new Forward("spadministration_updatepassword",false,BO,Forward.Start,false);
    f.SetParameter("m_cAtExit",BO.w_m_cAtExit);
    f.SetParameter("m_cParameterSequence","m_cAtExit");
    f.SetParameter("m_cMode","hyperlink");
    status.forwardedto = f;
    // valorizzazione dei placeholder del workflow: l'Initialize cancella i valori nel BO e solo in questo punto conosco i valori di campi in chiave sottoposti ad autonumber
    SetWorkflowPlaceholders(status,BO);
    // L'if serve ad evitare problemi con la compilazione
    if (Forward.IsForwarded(status.forwardedto)) {
      return;
    }
    if (l_bResult) {
      status.m_cClientMode = "new";
      status.m_bExit = true;
      // valorizzazione dei placeholder del workflow: l'Initialize cancella i valori nel BO e solo in questo punto conosco i valori di campi in chiave sottoposti ad autonumber
      SetWorkflowPlaceholders(status,BO);
    }
  }
  void Discard(ServletStatus status,spadministration_changepasswordBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,spadministration_changepasswordBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",200);
    item.put("w",701);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","true");
    org.json.JSONObject pageProp = null;
    org.json.JSONArray pagesProp = null;
    pagesProp = new org.json.JSONArray();
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Page 1\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Page 1");
    item.put("altInterfaceFor","spadministration_changepassword");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"h\":25,\"name\":\"label_CJRLVMMWSK\",\"page\":1,\"spuid\":\"CJRLVMMWSK\",\"tabindex\":1,\"type\":\"Label\",\"w\":377,\"x\":57,\"y\":15,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":40,\"name\":\"label_TJIVDOWYFZ\",\"page\":1,\"spuid\":\"TJIVDOWYFZ\",\"tabindex\":10,\"type\":\"Label\",\"w\":377,\"x\":57,\"y\":15,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":25,\"name\":\"label_LDHKZVMTNN\",\"page\":1,\"spuid\":\"LDHKZVMTNN\",\"tabindex\":2,\"type\":\"Label\",\"value\":\"ADMIN_F10_TO_CONTINUE\",\"w\":514,\"x\":57,\"y\":65,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"MSG_OLD_PASSWORD\",\"h\":25,\"maxlength\":20,\"name\":\"old_password\",\"page\":1,\"spuid\":\"QDPGURJWZK\",\"tabindex\":3,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":153,\"x\":210,\"y\":100,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_QVTYQJROCD\",\"page\":1,\"spuid\":\"QVTYQJROCD\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"MSG_OLD_PASSWORD\",\"w\":196,\"x\":5,\"y\":100,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_ZZKRWOJQTG\",\"page\":1,\"spuid\":\"ZZKRWOJQTG\",\"src\":\"..\\/{\\\"Char\\\":\\\"61550\\\",\\\"Color\\\":\\\"#808080\\\",\\\"FontName\\\":\\\"fontawesome-webfont\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"15\\\"}\",\"tabindex\":31,\"type\":\"Image\",\"w\":20,\"x\":367,\"y\":103,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_OSVFPWEFJH\",\"page\":1,\"spuid\":\"OSVFPWEFJH\",\"src\":\"..\\/{\\\"Char\\\":\\\"61552\\\",\\\"Color\\\":\\\"#808080\\\",\\\"FontName\\\":\\\"fontawesome-webfont\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"15\\\"}\",\"tabindex\":33,\"type\":\"Image\",\"w\":20,\"x\":367,\"y\":103,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"pwdratecause_layer\",\"box_type\":\"layer\",\"comment\":\"FormatMsg("+"'"+"ADMIN_PASSWORD_VERDICT"+"'"+") + "+"'"+": "+"'"+" + UserAdmin.GetPasswordVerdict(w_new_password)\",\"fixed\":true,\"h\":167,\"name\":\"pwdratecause_layer\",\"page\":1,\"shrinkable\":true,\"spuid\":\"HITFFRVPXU\",\"tabindex\":24,\"type\":\"Box\",\"w\":280,\"x\":391,\"y\":342,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"container\":\"HITFFRVPXU\",\"disabled\":\"true\",\"h\":124,\"name\":\"pwdratecause\",\"page\":1,\"readonly\":\"true\",\"scroll\":true,\"spuid\":\"ESFOZDXNLZ\",\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":260,\"x\":400,\"y\":365,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"MSG_NEW_PASSWORD\",\"h\":25,\"maxlength\":20,\"name\":\"new_password\",\"page\":1,\"spuid\":\"JRQGKMZTEH\",\"tabindex\":5,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":153,\"x\":210,\"y\":135,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_INRIMFQZEF\",\"page\":1,\"spuid\":\"INRIMFQZEF\",\"tabindex\":6,\"type\":\"Label\",\"value\":\"MSG_NEW_PASSWORD\",\"w\":196,\"x\":5,\"y\":135,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ADMIN_PASSWORD_VERDICT\",\"h\":25,\"name\":\"label_XVYWBPODNF\",\"page\":1,\"spuid\":\"XVYWBPODNF\",\"tabindex\":29,\"type\":\"Label\",\"w\":304,\"x\":392,\"y\":135,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_OTBBXDQDET\",\"page\":1,\"spuid\":\"OTBBXDQDET\",\"src\":\"..\\/{\\\"Char\\\":\\\"61550\\\",\\\"Color\\\":\\\"#808080\\\",\\\"FontName\\\":\\\"fontawesome-webfont\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"15\\\"}\",\"tabindex\":32,\"type\":\"Image\",\"w\":20,\"x\":367,\"y\":138,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_XEGRJMWYIW\",\"page\":1,\"spuid\":\"XEGRJMWYIW\",\"src\":\"..\\/{\\\"Char\\\":\\\"61552\\\",\\\"Color\\\":\\\"#808080\\\",\\\"FontName\\\":\\\"fontawesome-webfont\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"15\\\"}\",\"tabindex\":34,\"type\":\"Image\",\"w\":20,\"x\":367,\"y\":138,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":15,\"name\":\"password_meter\",\"page\":1,\"spuid\":\"AZTVNXSPBF\",\"src\":\"\\/jsp-system\\/spadministration_pwdmeter_portlet.jsp?ForcedPortletUID=AZTVNXSPBF\",\"tabindex\":28,\"type\":\"Portlet\",\"w\":304,\"x\":392,\"y\":153,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"MSG_CONFIRM_PASSWORD\",\"h\":25,\"maxlength\":20,\"name\":\"confirm_password\",\"page\":1,\"spuid\":\"WLGONTBMKR\",\"tabindex\":7,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":153,\"x\":210,\"y\":170,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":25,\"name\":\"label_RIUCOGNUSI\",\"page\":1,\"spuid\":\"RIUCOGNUSI\",\"tabindex\":8,\"type\":\"Label\",\"value\":\"MSG_CONFIRM_PASSWORD\",\"w\":196,\"x\":5,\"y\":170,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_YEUZQGQZIT\",\"page\":1,\"spuid\":\"YEUZQGQZIT\",\"src\":\"..\\/{\\\"Char\\\":\\\"61550\\\",\\\"Color\\\":\\\"#808080\\\",\\\"FontName\\\":\\\"fontawesome-webfont\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"15\\\"}\",\"tabindex\":35,\"type\":\"Image\",\"w\":20,\"x\":367,\"y\":172,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_SCKKFWHTWV\",\"page\":1,\"spuid\":\"SCKKFWHTWV\",\"src\":\"..\\/{\\\"Char\\\":\\\"61552\\\",\\\"Color\\\":\\\"#808080\\\",\\\"FontName\\\":\\\"fontawesome-webfont\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"15\\\"}\",\"tabindex\":36,\"type\":\"Image\",\"w\":20,\"x\":367,\"y\":172,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":22,\"name\":\"button_SQDRAMDHVL\",\"page\":1,\"picker\":true,\"spuid\":\"SQDRAMDHVL\",\"tabindex\":26,\"type\":\"Button\",\"value\":\"?\",\"w\":16,\"x\":574,\"y\":185,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(spadministration_changepasswordBO BO,ServletStatus status) {
    status.themeWriter = new SPTheme(status.out,status.GetThemeStatus("",status.context.Translate(entityGlobals.userName),""),"dialog");
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
     "<script src='spadministration_changepassword?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
    status.out.println(
     "<script src='SPPrxy/"+m_cEntityUid+"/spadministration_changepassword_proc.js'>" +
     "</script>" +
    "");
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
    status.out.println("AppletTag('HPar','Trs');");
    status.out.println("AppletTag('Batch');");
    status.out.println(
     "</script>" +
    "");
    status.m_cBodyAttributes = "onload=OnLoad() onhelp=CancelHelp()";
    status.m_cBodyAttributes = status.m_cBodyAttributes+" onkeydown=window.ManageKeys(event,false,false,true)";
    status.m_cBodyAttributes = status.m_cBodyAttributes+" onfocus=EnsureControlFocus()";
    status.themeWriter.WriteBody_Begin(200,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
    status.out.println(
     "<script>" +
    "");
    status.out.println(
     "</script>" +
    "");
    WriteMainFormScript(BO,status);
    status.WriteSenderForm(entityGlobals,false);
    WriteMainForm(BO,status);
    status.themeWriter.WriteBody_EndHtml();
    status.themeWriter.WriteBody_End();
    status.out.println(
     "<script>" +
    "");
    if ( ! (CPLib.Empty(BO.LastErrorMessage()))) {
      status.out.println("var showed_error = "+SPLib.ToJSValue(BO.LastErrorMessage(),"L",0,0)+";");
      status.out.println("WindowAlert(showed_error);");
    }
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "</html>" +
    "");
  }
  void RaiseLoadedEntity(spadministration_changepasswordBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(spadministration_changepasswordBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(spadministration_changepasswordBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(spadministration_changepasswordBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(spadministration_changepasswordBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(spadministration_changepasswordBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  void IncludeJS(ServletStatus status) {
    String l_cJsUid;
    l_cJsUid = SPPrxycizer.proxycizedPath("UserAdmin.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("Utilities.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+spadministration_getcaptchalevel.m_cEntityUid+"/spadministration_getcaptchalevel.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+spadministration_getpwdciclicity.m_cEntityUid+"/spadministration_getpwdciclicity.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+spadministration_getpwdcomplexity.m_cEntityUid+"/spadministration_getpwdcomplexity.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+spadministration_getpwdduration.m_cEntityUid+"/spadministration_getpwdduration.js'>" +
     "</script>" +
    "");
    /* --- Area Manuale = UI - Include */
    /* --- spadministration_changepassword */
    status.out.println("<script src='../spadministration_help.js' type='text/javascript'></script>");
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
      spadministration_getcaptchalevel.GetCallableNames(callable);
      spadministration_getpwdciclicity.GetCallableNames(callable);
      spadministration_getpwdcomplexity.GetCallableNames(callable);
      spadministration_getpwdduration.GetCallableNames(callable);
      CPLib.AddToSet(callable,"UserAdmin");
      CPLib.AddToSet(callable,"Utilities");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,spadministration_changepasswordBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,spadministration_changepasswordBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
    }
    return result;
  }
}
