import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_pers_rapporti_prv extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*IDQAYMWZMA*!";
  static public class ServletStatus extends SPPageServletStatus {
    public void MergeCallerVars(SPParameterSource source) {
      source.SetParameter("CONNES",source.GetCaller().GetString("CONNES","C",16,0));
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
    arpg_pers_rapporti_prvBO BO;
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
    return "Rapporti relativi a Persona / Societ� / Fornitore (Provvisori)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_pers_rapporti_prv";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 533;
    l_eg.m_nEntityHeight = 70;
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
                   new SPItem("CONNES","C",16,0, "hide","")
                 };
    l_eg.m_lExecuteAtStart = true;
    l_eg.m_cQueryName = "qbe_pers_rapporti_prv";
    l_eg.m_nRowsPerPage = 10;
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,arpg_pers_rapporti_prvBO BO) {
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
    l_translations=new String[][]{{"10027039931",p_Context.Translate("Tipologia")},
    {"10632911230",p_Context.Translate("Data Reg.")},
    {"113933141",p_Context.Translate("Update")},
    {"1805022818",p_Context.Translate("Rapporto")},
    {"1930572929",p_Context.Translate("Rapporti relativi a Persona / Societ� / Fornitore (Provvisori)")},
    {"45547614",p_Context.Translate("Data Inizio")},
    {"7776403",p_Context.Translate("Stato")}};
    return l_translations;
  }
  void WriteStyles(arpg_pers_rapporti_prvBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/arpg_pers_rapporti_prv.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(arpg_pers_rapporti_prvBO BO,ServletStatus status) {
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
  void WriteControls(arpg_pers_rapporti_prvBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(arpg_pers_rapporti_prvBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(0);
    status.themeWriter.Header_EndHtml();
    status.out.println(
     "<script type='text/javascript'>" +
     "FillHTMLRow()" +
     "</script>" +
    "");
    status.themeWriter.Footer_BeginHtml(0);
    WriteControls_1_f_0(BO,status);
  }
  void WriteControls_1_f_0(arpg_pers_rapporti_prvBO BO,ServletStatus status) {
    status.themeWriter.Footer_EndHtml();
  }
  static void PrintState(arpg_pers_rapporti_prvBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_pers_rapporti_prvBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_pers_rapporti_prvBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_CONNES,"C",16,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_pers_rapporti_prvBO BO,ServletStatus status) {
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(70,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(533,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_pers_rapporti_prv"),"C",0,0)+ ";");
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
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_pers_rapporti_prv","");
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
    status.out.println("var m_bOtherRow = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bResetOnSave = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("// * --- Area Manuale = UI - Declare Variables");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteMainFormScript(arpg_pers_rapporti_prvBO BO,ServletStatus status) {
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
  arpg_pers_rapporti_prvBO getBO(ServletStatus status) {
    arpg_pers_rapporti_prvBO BO = new arpg_pers_rapporti_prvBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_pers_rapporti_prvBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_pers_rapporti_prvBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_pers_rapporti_prvBO BO) {
    BO.SetFromContext(status.m_cWv);
    BO.Calculate();
  }
  void Save(ServletStatus status,arpg_pers_rapporti_prvBO BO) {
    boolean l_bResult;
    BO.SetFromContext(status.m_cWv);
    l_bResult = BO.Save();
    if (l_bResult) {
      status.m_cClientMode = "new";
      status.m_bExit = true;
      // valorizzazione dei placeholder del workflow: l'Initialize cancella i valori nel BO e solo in questo punto conosco i valori di campi in chiave sottoposti ad autonumber
      SetWorkflowPlaceholders(status,BO);
    }
  }
  void Discard(ServletStatus status,arpg_pers_rapporti_prvBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,arpg_pers_rapporti_prvBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",70);
    item.put("w",533);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","arpg_pers_rapporti_prv");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteBody(ServletStatus status,arpg_pers_rapporti_prvBO BO) {
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
  void WriteTrs(ServletStatus status,arpg_pers_rapporti_prvBO BO) {
    status.out.println("var c_RAPPORTO;");
    status.out.println("var c_DATAINI;");
    status.out.println("var c_DATAFINE;");
    status.out.println("var c_STATORAP;");
    status.out.println("var c_TIPOPERS;");
    status.out.println("var m_oTrsFW;");
    status.out.println("m_oTrsFW = []");
    status.out.println("var m_oTrsQuery;");
    status.out.println("m_oTrsQuery = []");
    WriteBody(status,BO);
    status.out.println("m_nRows="+status.m_nRows+";");
  }
  void AddTrsQueryRow(ServletStatus status,int p_nCnt,arpg_pers_rapporti_prvBO BO) {
    String l_cTrsQ;
    l_cTrsQ = " new TrsQueryRow(";
    l_cTrsQ = l_cTrsQ+SPLib.ToJSValue(BO.c_RAPPORTO,"C",25,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_DATAINI,"D",10,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_DATAFINE,"D",10,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_STATORAP,"C",7,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_TIPOPERS,"C",11,0);
    l_cTrsQ = l_cTrsQ+")";
    status.out.println("m_oTrsQuery["+p_nCnt+"] = "+l_cTrsQ+"");
  }
  void Next(ServletStatus status,arpg_pers_rapporti_prvBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_pers_rapporti_prvBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_pers_rapporti_prvBO BO,ServletStatus status) {
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
     "<script src='arpg_pers_rapporti_prv?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
     "<script src='SPPrxy/"+m_cEntityUid+"/arpg_pers_rapporti_prv_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(70,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
  void RaiseLoadedEntity(arpg_pers_rapporti_prvBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_pers_rapporti_prvBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(arpg_pers_rapporti_prvBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(arpg_pers_rapporti_prvBO BO,ServletStatus status) {
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
  void WriteExitPage(arpg_pers_rapporti_prvBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(arpg_pers_rapporti_prvBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
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
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
  }
  public String GetCheckVars(ServletStatus status,arpg_pers_rapporti_prvBO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,arpg_pers_rapporti_prvBO BO) {
    boolean result = true;
    return result;
  }
}
