import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_start_wuchkpas extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*TEICQLKPYU*!";
  static public class ServletStatus extends SPPageServletStatus {
    public void MergeCallerVars(SPParameterSource source) {
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
    arpg_start_wuchkpasBO BO;
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
    if (CPLib.eq(status.m_cAction,"next")) {
      Next(status,BO);
    } else if (CPLib.eq(status.m_cAction,"previous")) {
      Previous(status,BO);
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
    SPLib.NoCache(response);
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
    return "Elaborazione record modificati";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_start_wuchkpas";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 805;
    l_eg.m_nEntityHeight = 140;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.items = new SPItem[]{
                   new SPItem("tipodest","C",1,0, "edit",""),
                   new SPItem("opextc","C",1,0, "edit",""),
                   new SPItem("destfin","C",1,0, "edit","")
                 };
    l_eg.m_lExecuteAtStart = true;
    l_eg.m_cQueryName = "qbe_wuimport";
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,arpg_start_wuchkpasBO BO) {
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
  public String[][] JSTranslations(CPContext p_Context) {
    String[][] l_translations;
    l_translations=new String[][]{{"10437792479",p_Context.Translate("Esecuzione trasferimento operazioni selezionate")},
    {"113933141",p_Context.Translate("Update")},
    {"11488571677",p_Context.Translate("Elaborazione record modificati")},
    {"1275327946",p_Context.Translate("Seleziona tutte le operazioni")},
    {"146644790",p_Context.Translate("Trasferire")},
    {"1500692548",p_Context.Translate("Selezionato per il passaggio")},
    {"1823784963",p_Context.Translate("Cliente")},
    {"1825939288",p_Context.Translate("Crea operazioni Extra Conto")},
    {"338061",p_Context.Translate("MTCN")},
    {"350606523",p_Context.Translate("Visualizza registrazioni comprese nel periodo")},
    {"55887572",p_Context.Translate("Dipen.")},
    {"66453706",p_Context.Translate("Deseleziona tutte le operazioni")},
    {"727419286",p_Context.Translate("Conferma i record selezionati")},
    {"763806883",p_Context.Translate("Nome File")}};
    return l_translations;
  }
  void WriteStyles(arpg_start_wuchkpasBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/arpg_start_wuchkpas.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(arpg_start_wuchkpasBO BO,ServletStatus status) {
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
      status.request.setAttribute("com__zucchetti__sitepainter__altinterface__m_cEntityUid",m_cEntityUid);
      SPLib.Include(servletContext,status,status.m_cAltInterface);
    } else {
      WriteControls(BO,status);
    }
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(arpg_start_wuchkpasBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(arpg_start_wuchkpasBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(70);
    WriteControls_1_h_0(BO,status);
  }
  void WriteControls_1_h_0(arpg_start_wuchkpasBO BO,ServletStatus status) {
    status.out.println(
     "<div id='YWGFSYCMOZ_DIV' class='UntitledBox'>" +
     "<div id='YWGFSYCMOZ' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<div id='WIRRRKLEWO_DIV'>" +
     "<span id='WIRRRKLEWO_0_container'>" +
     "<input id='WIRRRKLEWO_0' name='WIRRRKLEWO' type='radio' value="+SPLib.ToHTMLValue("D","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("D",CPLib.Trim(BO.w_tipodest))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='WIRRRKLEWO_0'>"+status.context.Translate("Definitivo")+"</label>" +
     "</span>" +
     "<span id='WIRRRKLEWO_1_container'>" +
     "<input id='WIRRRKLEWO_1' name='WIRRRKLEWO' type='radio' value="+SPLib.ToHTMLValue("P","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("P",CPLib.Trim(BO.w_tipodest))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='WIRRRKLEWO_1'>"+status.context.Translate("Provvisorio")+"</label>" +
     "</span>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NJQSNRJAXM_DIV'>" +
     "<label id='NJQSNRJAXM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Destinazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='JAKNEJNBKZ_DIV'>" +
     "<input name='opextc' id='JAKNEJNBKZ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_opextc,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_opextc))?"CHECKED":"")+">" +
     "<label id='JAKNEJNBKZ_LBL' for='JAKNEJNBKZ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Crea operazioni Extra Conto"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<div id='RQAECCWOBF_DIV'>" +
     "<span id='RQAECCWOBF_0_container'>" +
     "<input id='RQAECCWOBF_0' name='RQAECCWOBF' type='radio' value="+SPLib.ToHTMLValue("O","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("O",CPLib.Trim(BO.w_destfin))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='RQAECCWOBF_0'>"+status.context.Translate("Operazioni")+"</label>" +
     "</span>" +
     "<span id='RQAECCWOBF_1_container'>" +
     "<input id='RQAECCWOBF_1' name='RQAECCWOBF' type='radio' value="+SPLib.ToHTMLValue("F","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("F",CPLib.Trim(BO.w_destfin))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='RQAECCWOBF_1'>"+status.context.Translate("Frazionate")+"</label>" +
     "</span>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_FLFHSXPWZI()' tabindex='-1' id='FLFHSXPWZI_HREF'>" +
     "<img id='FLFHSXPWZI' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/elaborazione.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Esecuzione trasferimento operazioni selezionate"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Esecuzione trasferimento operazioni selezionate"),"C",0,0)+">" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_VRHQBWKFPP()' tabindex='-1' id='VRHQBWKFPP_HREF'>" +
     "<img id='VRHQBWKFPP' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/search.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Visualizza registrazioni comprese nel periodo"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Visualizza registrazioni comprese nel periodo"),"C",0,0)+">" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_HDSXZTLKVK()' tabindex='-1' id='HDSXZTLKVK_HREF'>" +
     "<img id='HDSXZTLKVK' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/save.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Conferma i record selezionati"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Conferma i record selezionati"),"C",0,0)+">" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_ZWTNEMXOFQ()' tabindex='-1' id='ZWTNEMXOFQ_HREF'>" +
     "<img id='ZWTNEMXOFQ' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/dese_all.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Deseleziona tutte le operazioni"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Deseleziona tutte le operazioni"),"C",0,0)+">" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_FCATLNLMSB()' tabindex='-1' id='FCATLNLMSB_HREF'>" +
     "<img id='FCATLNLMSB' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/sel_all.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Seleziona tutte le operazioni"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Seleziona tutte le operazioni"),"C",0,0)+">" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_PTXYMSWBZO()' tabindex='-1' id='PTXYMSWBZO_HREF'>" +
     "<img id='PTXYMSWBZO' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/exit.gif"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt=''>" +
     "</a>" +
    "");
    status.themeWriter.Header_EndHtml();
    status.out.println(
     "<script type='text/javascript'>" +
     "FillHTMLRow()" +
     "</script>" +
    "");
    status.themeWriter.Footer_BeginHtml(0);
    status.themeWriter.Footer_EndHtml();
  }
  static void PrintState(arpg_start_wuchkpasBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_start_wuchkpasBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_start_wuchkpasBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_WUFLGSEL,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipodest,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_opextc,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_destfin,"C",1,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_start_wuchkpasBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(140,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(805,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_start_wuchkpas"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    AppendCallableIDS(status,"");
    status.out.println("}");
    if (true) {
      status.out.print("var m_CheckVars=[");
      status.out.print(SPLib.ToJSValue(GetCheckVars(status, BO),"C",0,0));
      status.out.println("]");
    }
    if (CPLib.eq(status.context.GetGlobalString("IsSPAdministrationInstalled"),"yes") && CPLib.IsAdministrator(status.context) && status.context.HasAdministeredUsers()) {
      status.out.println("var m_cProgName = " + SPLib.ToJSValue(entityGlobals.name,"C",0,0)+ ";");
    } else {
      status.out.println("Zoom.p="+SPLib.ToJSValue(entityGlobals.name,"C",0,0)+";");
    }
    if (CPLib.eq(status.context.GetGlobalString("IsPortalStudioInstalled"),"yes") && SPLib.CanAccessEditor(status.context,"PortalStudio")) {
      status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue(entityGlobals.name,"C",0,0)+ ";");
    }
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_start_wuchkpas","");
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
    status.out.println("var m_cFunction = " + SPLib.ToJSValue("dialog","C",0,0)+ ";");
    status.out.println("var m_bFieldsUpdated = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_nLastError = " + SPLib.ToJSValue(0,"I",0,0)+ ";");
    status.out.println("var m_cObblFieldName = " + SPLib.ToJSValue("","C",0,0)+ ";");
    status.out.println("var m_cLastMsgError = " + SPLib.ToJSValue("","C",0,0)+ ";");
    status.out.println("var m_cLastWorkVarError = " + SPLib.ToJSValue("","C",0,0)+ ";");
    status.out.println("var m_cLastWorkVarErrorMsg = " + SPLib.ToJSValue("","C",0,0)+ ";");
    status.out.println("var m_nRowsPerPage = " + SPLib.ToJSValue(entityGlobals.m_nRowsPerPage,"I",0,0)+ ";");
    status.out.println("var m_nCurrentRow = " + SPLib.ToJSValue(0,"N",0,0)+ ";");
    status.out.println("var m_nRows = " + SPLib.ToJSValue(0,"I",0,0)+ ";");
    status.out.println("var m_nRowStatus = " + SPLib.ToJSValue(0,"N",0,0)+ ";");
    status.out.println("// * --- Area Manuale = UI - Declare Variables");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteMainFormScript(arpg_start_wuchkpasBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    WriteTrs(status,BO);
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("m_nCurrentRow=0;");
    status.out.println("TrsToWork();");
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
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
      }
    }
    status.out.println("SetControlsValue();");
    status.out.println("NotifyEvent('Record Loaded');");
    status.out.println("// * --- Area Manuale = UI - OnLoad End");
    status.out.println("// * --- Fine Area Manuale");
    RaiseLoadedEntity(BO,status);
    status.out.println("CalculateAndResizeEntityHeight();");
    status.out.println("HideLoadingLayer();");
    if (status.m_bShowBOWarnings) {
      status.out.println("SubmitListenerForm(" + SPLib.ToJSValue(status.m_cAction,"C",0,0) + ");");
    }
    status.out.println("}");
    status.out.println("// * --- Area Manuale = UI - Functions & Procedures");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  arpg_start_wuchkpasBO getBO(ServletStatus status) {
    arpg_start_wuchkpasBO BO = new arpg_start_wuchkpasBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_start_wuchkpasBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_start_wuchkpasBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_start_wuchkpasBO BO) {
    BO.SetFromContext(status.m_cWv);
  }
  void Save(ServletStatus status,arpg_start_wuchkpasBO BO) {
    boolean l_bResult;
    BO.SetFromContext(status.m_cWv);
    SPPageServletStatus pagestatus;
    pagestatus = (SPPageServletStatus)status;
    NotifyEvent("Before update",status,BO);
    l_bResult = BO.Save();
    NotifyEvent("After update",status,BO);
    if ( ! (l_bResult)) {
      CheckErrorToBrowser(BO.m_nLastError,BO.m_cLastMsgError,status);
    }
    if (l_bResult) {
      status.m_cClientMode = "new";
      status.m_bExit = true;
      // valorizzazione dei placeholder del workflow: l'Initialize cancella i valori nel BO e solo in questo punto conosco i valori di campi in chiave sottoposti ad autonumber
      SetWorkflowPlaceholders(status,BO);
    }
  }
  void Discard(ServletStatus status,arpg_start_wuchkpasBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,arpg_start_wuchkpasBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",140);
    item.put("w",805);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","arpg_start_wuchkpas");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"70\",\"name\":\"Box_YWGFSYCMOZ\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"YWGFSYCMOZ\",\"tabindex\":\"1\",\"type\":\"Box\",\"w\":\"800\",\"x\":\"0\",\"y\":\"0\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"19\",\"name\":\"tipodest\",\"orientation\":\"horizontal\",\"page\":\"1\",\"spuid\":\"WIRRRKLEWO\",\"tabindex\":\"2\",\"textlist\":\"Definitivo,Provvisorio\",\"type\":\"Radio\",\"valuelist\":\""+"'"+"D"+"'"+","+"'"+"P"+"'"+"\",\"w\":\"161\",\"x\":\"88\",\"y\":\"14\",\"zone\":\"YWGFSYCMOZ_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Destinazione_\",\"page\":\"1\",\"spuid\":\"NJQSNRJAXM_DIV\",\"tabindex\":\"3\",\"type\":\"Label\",\"value\":\"Destinazione:\",\"w\":\"65\",\"x\":\"16\",\"y\":\"17\",\"zone\":\"YWGFSYCMOZ_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"opextc\",\"page\":\"1\",\"spuid\":\"JAKNEJNBKZ\",\"tabindex\":\"4\",\"type\":\"Checkbox\",\"w\":\"156\",\"x\":\"88\",\"y\":\"35\",\"zone\":\"YWGFSYCMOZ_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"19\",\"name\":\"destfin\",\"orientation\":\"horizontal\",\"page\":\"1\",\"spuid\":\"RQAECCWOBF\",\"tabindex\":\"5\",\"textlist\":\"Operazioni,Frazionate\",\"type\":\"Radio\",\"valuelist\":\""+"'"+"O"+"'"+","+"'"+"F"+"'"+"\",\"w\":\"161\",\"x\":\"288\",\"y\":\"14\",\"zone\":\"YWGFSYCMOZ_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Esecuzione trasferimento operazioni selezionate\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"30\",\"href\":\"javascript:href_FLFHSXPWZI()\",\"name\":\"images_elaborazione_gif\",\"page\":\"1\",\"spuid\":\"FLFHSXPWZI\",\"src\":\"images\\/elaborazione.gif\",\"tabindex\":\"6\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"704\",\"y\":\"28\",\"zone\":\"YWGFSYCMOZ_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Visualizza registrazioni comprese nel periodo\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"30\",\"href\":\"javascript:href_VRHQBWKFPP()\",\"name\":\"images_search_gif\",\"page\":\"1\",\"spuid\":\"VRHQBWKFPP\",\"src\":\"images\\/search.gif\",\"tabindex\":\"7\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"656\",\"y\":\"28\",\"zone\":\"YWGFSYCMOZ_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Conferma i record selezionati\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"30\",\"href\":\"javascript:href_HDSXZTLKVK()\",\"name\":\"images_save_gif\",\"page\":\"1\",\"spuid\":\"HDSXZTLKVK\",\"src\":\"images\\/save.gif\",\"tabindex\":\"8\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"608\",\"y\":\"28\",\"zone\":\"YWGFSYCMOZ_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Deseleziona tutte le operazioni\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"30\",\"href\":\"javascript:href_ZWTNEMXOFQ()\",\"name\":\"images_dese_all_gif\",\"page\":\"1\",\"spuid\":\"ZWTNEMXOFQ\",\"src\":\"images\\/dese_all.gif\",\"tabindex\":\"9\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"560\",\"y\":\"28\",\"zone\":\"YWGFSYCMOZ_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Seleziona tutte le operazioni\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"30\",\"href\":\"javascript:href_FCATLNLMSB()\",\"name\":\"images_sel_all_gif\",\"page\":\"1\",\"spuid\":\"FCATLNLMSB\",\"src\":\"images\\/sel_all.gif\",\"tabindex\":\"10\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"512\",\"y\":\"28\",\"zone\":\"YWGFSYCMOZ_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"30\",\"href\":\"javascript:href_PTXYMSWBZO()\",\"name\":\"images_exit_gif\",\"page\":\"1\",\"spuid\":\"PTXYMSWBZO\",\"src\":\"images\\/exit.gif\",\"tabindex\":\"11\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"752\",\"y\":\"28\",\"zone\":\"YWGFSYCMOZ_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteBody(ServletStatus status,arpg_start_wuchkpasBO BO) {
    SPVQRReaderFactory l_VqrFactory = new SPVQRReaderFactory(BO.m_Ctx.GetInstance());
    BO.m_cQueryName = entityGlobals.m_cQueryName;
    BO.m_bQuery = status.m_bQuery;
    BO.m_nStartRow = status.m_nStartRow;
    BO.Query(l_VqrFactory);
    int l_nRow;
    if (status.m_bQuery) {
      l_nRow = 0;
      while (CPLib.lt(l_nRow,BO.m_oTrs.size())) {
        BO.m_nCurrentRow = l_nRow;
        BO.TrsToWork();
        AddTrsQueryRow(status,l_nRow,BO);
        l_nRow = l_nRow+1;
      }
      status.m_nRows = BO.Rows();
    } else {
      status.m_nRows = 0;
    }
    status.out.println("m_bOtherRow="+SPLib.ToJSValue(BO.m_bExitRow,"L",0,0)+";");
  }
  void WriteTrs(ServletStatus status,arpg_start_wuchkpasBO BO) {
    status.out.println("var c_WUNOMEFILE;");
    status.out.println("var c_WURIFEMTCN;");
    status.out.println("var c_WUNCLIENTE;");
    status.out.println("var c_WUCODDIPEN;");
    status.out.println("var c_WUTIPESITO;");
    status.out.println("var m_oTrsFW;");
    status.out.println("m_oTrsFW = []");
    status.out.println("var m_oTrsQuery;");
    status.out.println("m_oTrsQuery = []");
    WriteBody(status,BO);
    status.out.println("m_nRows="+status.m_nRows+";");
  }
  void AddTrsQueryRow(ServletStatus status,int p_nCnt,arpg_start_wuchkpasBO BO) {
    String l_cTrsQ;
    l_cTrsQ = " new TrsQueryRow(";
    l_cTrsQ = l_cTrsQ+SPLib.ToJSValue(BO.c_WUNOMEFILE,"C",20,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_WURIFEMTCN,"C",10,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_WUNCLIENTE,"C",40,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_WUCODDIPEN,"C",6,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_WUTIPESITO,"C",2,0);
    l_cTrsQ = l_cTrsQ+")";
    status.out.println("m_oTrsQuery["+p_nCnt+"] = "+l_cTrsQ+"");
    String l_cTrsF;
    l_cTrsF = " new TrsFWRow(";
    l_cTrsF = l_cTrsF+SPLib.ToJSValue(BO.w_WUFLGSEL,"C",1,0);
    l_cTrsF = l_cTrsF+","+SPLib.ToJSValue(BO.w_WUFLGSEL,"C",1,0);
    l_cTrsF = l_cTrsF+","+SPLib.ToJSValue(BO.c_WUNOMEFILE,"C",120,0);
    l_cTrsF = l_cTrsF+","+SPLib.ToJSValue(BO.c_WURIFEMTCN,"C",10,0);
    l_cTrsF = l_cTrsF+",0)";
    status.out.println("m_oTrsFW["+p_nCnt+"] = "+l_cTrsF+"");
  }
  void Next(ServletStatus status,arpg_start_wuchkpasBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_start_wuchkpasBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_start_wuchkpasBO BO,ServletStatus status) {
    status.themeWriter = new SPTheme(status.out,status.GetThemeStatus("",status.context.Translate(entityGlobals.userName),""),"page");
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
     "<script src='arpg_start_wuchkpas?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
    l_cJsUid = SPPrxycizer.proxycizedPath("pageControls.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+m_cEntityUid+"/arpg_start_wuchkpas_proc.js'>" +
     "</script>" +
    "");
    IncludeJS(status);
    RaiseSavedEntity(BO,status);
    RaiseDeletedEntity(BO,status);
    RaiseDiscardedEntity(BO,status);
    // Dichiarazione delle variabili di script
    WriteMainFormVarScript(BO,status);
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_imp_dati.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_imp_dati_multipli.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_imp_dati_telepass.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_imp_dati_multipli_telepass.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_imp_dati_ac.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/styleVariables.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/calendar.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/calculator.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"' type='text/javascript'>" +
     "</script>" +
    "");
    if (CPLib.ne(status.m_bAutoResize,"")) {
      status.out.println(
       "<script type='text/javascript'>" +
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
    status.out.println("AppletTag('Trs');");
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
    status.themeWriter.WriteBody_Begin(140,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
  void RaiseLoadedEntity(arpg_start_wuchkpasBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_start_wuchkpasBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(arpg_start_wuchkpasBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(arpg_start_wuchkpasBO BO,ServletStatus status) {
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
  void WriteExitPage(arpg_start_wuchkpasBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(arpg_start_wuchkpasBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  void IncludeJS(ServletStatus status) {
    String l_cJsUid;
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_imp_dati.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_imp_dati_ac.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_imp_dati_multipli.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_imp_dati_multipli_telepass.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_imp_dati_telepass.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arrt_seldes_wuchkpas.m_cEntityUid+"/arrt_seldes_wuchkpas.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arrt_start_wuchkpas.m_cEntityUid+"/arrt_start_wuchkpas.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arrt_wuchkpas.m_cEntityUid+"/arrt_wuchkpas.js'>" +
     "</script>" +
    "");
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
      arrt_seldes_wuchkpas.GetCallableNames(callable);
      arrt_start_wuchkpas.GetCallableNames(callable);
      arrt_wuchkpas.GetCallableNames(callable);
      CPLib.AddToSet(callable,"arrt_imp_dati");
      CPLib.AddToSet(callable,"arrt_imp_dati_ac");
      CPLib.AddToSet(callable,"arrt_imp_dati_multipli");
      CPLib.AddToSet(callable,"arrt_imp_dati_multipli_telepass");
      CPLib.AddToSet(callable,"arrt_imp_dati_telepass");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,arpg_start_wuchkpasBO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,arpg_start_wuchkpasBO BO) {
    boolean result = true;
    return result;
  }
}