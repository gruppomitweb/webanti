import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_cgo_operazioni_agenzie_admin extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*JVRRIVEJTO*!";
  static public class ServletStatus extends SPPageServletStatus {
    public void MergeCallerVars(SPParameterSource source) {
      source.SetParameter("agenzia",source.GetCaller().GetString("agenzia","C",6,0));
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
    arpg_cgo_operazioni_agenzie_adminBO BO;
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
    return "Operazioni da completare (Administrator)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_cgo_operazioni_agenzie_admin";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 805;
    l_eg.m_nEntityHeight = 170;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"anadip"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.items = new SPItem[]{
                   new SPItem("agenzia","C",6,0, "edit","Agenzia"),
                   new SPItem("xdesage","C",30,0, "hide","Descrizione"),
                   new SPItem("coddip","C",6,0, "hide","Codice Dipendenza"),
                   new SPItem("xagenzia","C",10,0, "hide",""),
                   new SPItem("idticket","C",20,0, "edit","ID Biglietto"),
                   new SPItem("tipogio","C",10,0, "edit","Tipo Gioco"),
                   new SPItem("xcodloc","C",25,0, "show","Locale")
                 };
    l_eg.m_lExecuteAtStart = true;
    l_eg.m_cQueryName = "qbe_cgo_operazioni_agenzia_admin";
    l_eg.m_nRowsPerPage = 20;
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,arpg_cgo_operazioni_agenzie_adminBO BO) {
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
    l_translations=new String[][]{{"10506025307",p_Context.Translate("Esci dalla procedura")},
    {"10988377690",p_Context.Translate("Data Oper.")},
    {"11046582334",p_Context.Translate("N° Ticket")},
    {"113408572",p_Context.Translate("Locale")},
    {"113933141",p_Context.Translate("Update")},
    {"117806551",p_Context.Translate("Giorni")},
    {"11922513907",p_Context.Translate("Operazioni da completare (Administrator)")},
    {"11944359785",p_Context.Translate("Contattato il")},
    {"1461038147",p_Context.Translate("Ricerca le operazione da completare delle agenzie")},
    {"1570205239",p_Context.Translate("Tipo Gioco")},
    {"1745963953",p_Context.Translate("Agenzia")},
    {"1813072817",p_Context.Translate("Agenzie")},
    {"1814604627",p_Context.Translate("Causale")},
    {"1991862041",p_Context.Translate("Importo")},
    {"2071283709",p_Context.Translate("Codice Dipendenza")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"485092",p_Context.Translate("Tipo")},
    {"48541742",p_Context.Translate("ID Biglietto")},
    {"7778421",p_Context.Translate("Esito")}};
    return l_translations;
  }
  void WriteStyles(arpg_cgo_operazioni_agenzie_adminBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/arpg_cgo_operazioni_agenzie_admin.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(arpg_cgo_operazioni_agenzie_adminBO BO,ServletStatus status) {
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
  void WriteControls(arpg_cgo_operazioni_agenzie_adminBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(arpg_cgo_operazioni_agenzie_adminBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(70);
    WriteControls_1_h_0(BO,status);
  }
  void WriteControls_1_h_0(arpg_cgo_operazioni_agenzie_adminBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='XLVFHSOSYH_DIV' class='UntitledBox'>" +
     "<div id='XLVFHSOSYH' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_RROILCAWGO()' tabindex='-1' id='RROILCAWGO_HREF'>" +
     "<img id='RROILCAWGO' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/search.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Ricerca le operazione da completare delle agenzie"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Ricerca le operazione da completare delle agenzie"),"C",0,0)+">" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_IIJDTQKPBX()' tabindex='-1' id='IIJDTQKPBX_HREF'>" +
     "<img id='IIJDTQKPBX' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/exit.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Esci dalla procedura"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Esci dalla procedura"),"C",0,0)+">" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='agenzia' id='HZHPBOOXGE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_agenzia,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
     "<button id='HZHPBOOXGE_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='HZHPBOOXGE_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MHBJRXVDJU_DIV'>" +
     "<label id='MHBJRXVDJU'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdesage)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MKIGHUWRVZ_DIV'>" +
     "<label id='MKIGHUWRVZ' for='HZHPBOOXGE'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Agenzia:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='idticket' id='JSXWYUESVP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_idticket,"C",20,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='20' size='20' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='GTWTZPFFZE_DIV'>" +
     "<label id='GTWTZPFFZE' for='JSXWYUESVP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("ID Biglietto:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='tipogio' id='WRQRNKTEXN' class='Combobox' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
    "");
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_cgo_tbtipgio,CPSql.BuildSQLPhrase("CODTPGIO,DESTPGIO",BO.m_cPhName_cgo_tbtipgio,"",""));
    try {
      while ( ! (l_rsLoad.Eof())) {
        status.out.println(
         "<option value="+SPLib.ToHTMLValue(l_rsLoad.GetString("CODTPGIO"),"C",10,0,"", status.m_oRegSettings)+" "+(CPLib.eq(l_rsLoad.GetString("CODTPGIO"),CPLib.Trim(BO.w_tipogio))?"SELECTED":"")+">" +
         ""+SPLib.ToHTML(l_rsLoad.GetString("DESTPGIO"),"C",0,0)+"" +
         "</option>" +
        "");
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    status.out.println(
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('WRQRNKTEXN'),w_tipogio,'C');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MTLVVFIDKL_DIV'>" +
     "<label id='MTLVVFIDKL' for='WRQRNKTEXN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Gioco:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='xcodloc' id='JERWRKFYOV' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_xcodloc,"C",25,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='25' size='25' fieldtype='C'>" +
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
  static void PrintState(arpg_cgo_operazioni_agenzie_adminBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_cgo_operazioni_agenzie_adminBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_cgo_operazioni_agenzie_adminBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_agenzia,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesage,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_coddip,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xagenzia,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_idticket,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipogio,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xcodloc,"C",25,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_cgo_operazioni_agenzie_adminBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_MHBJRXVDJU = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(170,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_cgo_operazioni_agenzie_admin"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    status.out.print("'HZHPBOOXGE':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODDIPCODDIP,DESCRIZ,IDBASE,CODLOCC,C,C,Canadip",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
    AppendCallableIDS(status,",");
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
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_cgo_operazioni_agenzie_admin","");
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
    status.out.println("// * --- Area Manuale = UI - Declare Variables");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteMainFormScript(arpg_cgo_operazioni_agenzie_adminBO BO,ServletStatus status) {
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
  arpg_cgo_operazioni_agenzie_adminBO getBO(ServletStatus status) {
    arpg_cgo_operazioni_agenzie_adminBO BO = new arpg_cgo_operazioni_agenzie_adminBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_cgo_operazioni_agenzie_adminBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_cgo_operazioni_agenzie_adminBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_cgo_operazioni_agenzie_adminBO BO) {
    BO.SetFromContext(status.m_cWv);
    BO.Calculate();
  }
  void Save(ServletStatus status,arpg_cgo_operazioni_agenzie_adminBO BO) {
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
  void Discard(ServletStatus status,arpg_cgo_operazioni_agenzie_adminBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,arpg_cgo_operazioni_agenzie_adminBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",170);
    item.put("w",805);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","arpg_cgo_operazioni_agenzie_admin");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"70\",\"name\":\"Box_XLVFHSOSYH\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"XLVFHSOSYH\",\"tabindex\":\"5\",\"type\":\"Box\",\"w\":\"800\",\"x\":\"0\",\"y\":\"0\",\"zone\":\"pag1_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Ricerca le operazione da completare delle agenzie\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"30\",\"href\":\"javascript:href_RROILCAWGO()\",\"name\":\"images_search_gif\",\"page\":\"1\",\"spuid\":\"RROILCAWGO\",\"src\":\"images\\/search.gif\",\"tabindex\":\"6\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"704\",\"y\":\"35\",\"zone\":\"XLVFHSOSYH_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Esci dalla procedura\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"30\",\"href\":\"javascript:href_IIJDTQKPBX()\",\"name\":\"images_exit_gif\",\"page\":\"1\",\"spuid\":\"IIJDTQKPBX\",\"src\":\"images\\/exit.gif\",\"tabindex\":\"7\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"752\",\"y\":\"35\",\"zone\":\"XLVFHSOSYH_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Agenzia\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"6\",\"name\":\"agenzia\",\"page\":\"1\",\"spuid\":\"HZHPBOOXGE\",\"tabindex\":\"8\",\"type\":\"Textbox\",\"w\":\"56\",\"x\":\"80\",\"y\":\"14\",\"zone\":\"XLVFHSOSYH_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xdesage\",\"page\":\"1\",\"spuid\":\"MHBJRXVDJU_DIV\",\"tabindex\":\"10\",\"type\":\"Label\",\"value\":\"w_xdesage\",\"w\":\"352\",\"x\":\"161\",\"y\":\"18\",\"zone\":\"XLVFHSOSYH_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Agenzia_\",\"page\":\"1\",\"spuid\":\"MKIGHUWRVZ_DIV\",\"tabindex\":\"11\",\"type\":\"Label\",\"value\":\"Agenzia:\",\"w\":\"42\",\"x\":\"38\",\"y\":\"18\",\"zone\":\"XLVFHSOSYH_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"ID Biglietto\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"20\",\"name\":\"idticket\",\"page\":\"1\",\"spuid\":\"JSXWYUESVP\",\"tabindex\":\"20\",\"type\":\"Textbox\",\"w\":\"160\",\"x\":\"80\",\"y\":\"42\",\"zone\":\"XLVFHSOSYH_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"ID_Biglietto_\",\"page\":\"1\",\"spuid\":\"GTWTZPFFZE_DIV\",\"tabindex\":\"21\",\"type\":\"Label\",\"value\":\"ID Biglietto:\",\"w\":\"80\",\"x\":\"0\",\"y\":\"46\",\"zone\":\"XLVFHSOSYH_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Tipo Gioco\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"tipogio\",\"page\":\"1\",\"spuid\":\"WRQRNKTEXN\",\"tabindex\":\"28\",\"textlist\":\"\",\"type\":\"Combobox\",\"valuelist\":\"\",\"w\":\"344\",\"x\":\"344\",\"y\":\"42\",\"zone\":\"XLVFHSOSYH_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Tipo_Gioco_\",\"page\":\"1\",\"spuid\":\"MTLVVFIDKL_DIV\",\"tabindex\":\"29\",\"type\":\"Label\",\"value\":\"Tipo Gioco:\",\"w\":\"58\",\"x\":\"286\",\"y\":\"46\",\"zone\":\"XLVFHSOSYH_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Locale\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"25\",\"name\":\"xcodloc\",\"page\":\"1\",\"spuid\":\"JERWRKFYOV\",\"type\":\"Textbox\",\"w\":\"162\",\"x\":\"528\",\"y\":\"14\",\"zone\":\"XLVFHSOSYH_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteBody(ServletStatus status,arpg_cgo_operazioni_agenzie_adminBO BO) {
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
  void WriteTrs(ServletStatus status,arpg_cgo_operazioni_agenzie_adminBO BO) {
    status.out.println("var c_DATAOPE;");
    status.out.println("var c_CACODICE;");
    status.out.println("var c_CADESCRI;");
    status.out.println("var c_SNAINUMOPE;");
    status.out.println("var c_TOTLIRE;");
    status.out.println("var c_SEGNO;");
    status.out.println("var c_CAIDBIGLIETTO;");
    status.out.println("var c_CODDIPE;");
    status.out.println("var c_IDDIP;");
    status.out.println("var c_TIPOGIOCO;");
    status.out.println("var c_GIORNI;");
    status.out.println("var c_CGODATCON;");
    status.out.println("var c_CGOESICON;");
    status.out.println("var c_CGONOTCON;");
    status.out.println("var m_oTrsFW;");
    status.out.println("m_oTrsFW = []");
    status.out.println("var m_oTrsQuery;");
    status.out.println("m_oTrsQuery = []");
    WriteBody(status,BO);
    status.out.println("m_nRows="+status.m_nRows+";");
  }
  void AddTrsQueryRow(ServletStatus status,int p_nCnt,arpg_cgo_operazioni_agenzie_adminBO BO) {
    String l_cTrsQ;
    l_cTrsQ = " new TrsQueryRow(";
    l_cTrsQ = l_cTrsQ+SPLib.ToJSValue(BO.c_DATAOPE,"D",8,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_CACODICE,"N",5,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_CADESCRI,"C",90,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_SNAINUMOPE,"C",15,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_TOTLIRE,"N",15,2);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_SEGNO,"C",1,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_CAIDBIGLIETTO,"C",28,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_CODDIPE,"C",6,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_IDDIP,"C",10,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_TIPOGIOCO,"C",3,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_GIORNI,"N",10,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_CGODATCON,"D",8,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_CGOESICON,"C",1,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_CGONOTCON,"M",10,0);
    l_cTrsQ = l_cTrsQ+")";
    status.out.println("m_oTrsQuery["+p_nCnt+"] = "+l_cTrsQ+"");
  }
  void Next(ServletStatus status,arpg_cgo_operazioni_agenzie_adminBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_cgo_operazioni_agenzie_adminBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_cgo_operazioni_agenzie_adminBO BO,ServletStatus status) {
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
     "<script src='arpg_cgo_operazioni_agenzie_admin?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
     "<script src='SPPrxy/"+m_cEntityUid+"/arpg_cgo_operazioni_agenzie_admin_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(170,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
    status.out.println(
     "<script>" +
    "");
    status.out.println("AppletTag('Link');");
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
  void RaiseLoadedEntity(arpg_cgo_operazioni_agenzie_adminBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_cgo_operazioni_agenzie_adminBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(arpg_cgo_operazioni_agenzie_adminBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(arpg_cgo_operazioni_agenzie_adminBO BO,ServletStatus status) {
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
  void WriteExitPage(arpg_cgo_operazioni_agenzie_adminBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(arpg_cgo_operazioni_agenzie_adminBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  void IncludeJS(ServletStatus status) {
    String l_cJsUid;
    status.out.println(
     "<script src='SPPrxy/"+arfn_esiticon.m_cEntityUid+"/arfn_esiticon.js'>" +
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
      arfn_esiticon.GetCallableNames(callable);
      arrt_snai_oper_load.GetCallableNames(callable);
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,arpg_cgo_operazioni_agenzie_adminBO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,arpg_cgo_operazioni_agenzie_adminBO BO) {
    boolean result = true;
    return result;
  }
}
