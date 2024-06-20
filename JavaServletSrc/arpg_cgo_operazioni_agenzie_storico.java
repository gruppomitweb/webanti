import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_cgo_operazioni_agenzie_storico extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*FIUOHWXEKG*!";
  static public class ServletStatus extends SPPageServletStatus {
    public void MergeCallerVars(SPParameterSource source) {
      source.SetParameter("DaData",source.GetCaller().GetDate("DaData","D",8,0));
      source.SetParameter("A_Data",source.GetCaller().GetDate("A_Data","D",8,0));
      source.SetParameter("DaDataOpe",source.GetCaller().GetDate("DaDataOpe","D",8,0));
      source.SetParameter("A_DataOpe",source.GetCaller().GetDate("A_DataOpe","D",8,0));
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
    arpg_cgo_operazioni_agenzie_storicoBO BO;
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
    return "Storico Operazioni (Agenzie)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_cgo_operazioni_agenzie_storico";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 941;
    l_eg.m_nEntityHeight = 128;
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
                   new SPItem("DaData","D",8,0, "edit","Da Data Completamento"),
                   new SPItem("A_Data","D",8,0, "edit","A Data Completamento"),
                   new SPItem("DaDataOpe","D",8,0, "edit","Da Data Operazione"),
                   new SPItem("A_DataOpe","D",8,0, "edit","A Data Operazione")
                 };
    l_eg.m_lExecuteAtStart = true;
    l_eg.m_cQueryName = "qbe_cgo_operazioni_agenzia_storico";
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,arpg_cgo_operazioni_agenzie_storicoBO BO) {
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
    l_translations=new String[][]{{"10203452604",p_Context.Translate("Da Data Completamento")},
    {"10506025307",p_Context.Translate("Esci dalla procedura")},
    {"10734924728",p_Context.Translate("Ristampa il modulo di adeguata verifica")},
    {"10911345311",p_Context.Translate("Da Data Operazione")},
    {"10988377690",p_Context.Translate("Data Oper.")},
    {"11046582334",p_Context.Translate("N° Ticket")},
    {"113933141",p_Context.Translate("Update")},
    {"11891764027",p_Context.Translate("A Data Completamento")},
    {"11959384393",p_Context.Translate("Completata il")},
    {"1461038147",p_Context.Translate("Ricerca le operazione da completare delle agenzie")},
    {"1814604627",p_Context.Translate("Causale")},
    {"1822089062",p_Context.Translate("A Data Operazione")},
    {"1991862041",p_Context.Translate("Importo")},
    {"576701930",p_Context.Translate("Storico Operazioni (Agenzie)")}};
    return l_translations;
  }
  void WriteStyles(arpg_cgo_operazioni_agenzie_storicoBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/arpg_cgo_operazioni_agenzie_storico.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(arpg_cgo_operazioni_agenzie_storicoBO BO,ServletStatus status) {
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
  void WriteControls(arpg_cgo_operazioni_agenzie_storicoBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(arpg_cgo_operazioni_agenzie_storicoBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(63);
    WriteControls_1_h_0(BO,status);
  }
  void WriteControls_1_h_0(arpg_cgo_operazioni_agenzie_storicoBO BO,ServletStatus status) {
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
     "<input name='DaData' id='VAUCRMZHWP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DaData,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='VAUCRMZHWP_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='VAUCRMZHWP_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UVJLFCGXSJ_DIV'>" +
     "<label id='UVJLFCGXSJ' for='VAUCRMZHWP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da Data Completamento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A_Data' id='OXXBPYCOCK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A_Data,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='OXXBPYCOCK_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='OXXBPYCOCK_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CTLCSHLQSX_DIV'>" +
     "<label id='CTLCSHLQSX' for='OXXBPYCOCK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A Data Completamento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DaDataOpe' id='HTGZKUIBWA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DaDataOpe,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='HTGZKUIBWA_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='HTGZKUIBWA_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NPEYCYPTXA_DIV'>" +
     "<label id='NPEYCYPTXA' for='HTGZKUIBWA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da Data Operazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A_DataOpe' id='RPNVEZKZBQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A_DataOpe,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='RPNVEZKZBQ_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='RPNVEZKZBQ_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MDVAOJTHSC_DIV'>" +
     "<label id='MDVAOJTHSC' for='RPNVEZKZBQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A Data Operazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FGMOCXNBFY_DIV' style='display:none'>" +
     "<label id='FGMOCXNBFY'>" +
     ""+SPLib.ToHTMLRepresentation("<iframe width='655' height='170' id='elaborazione'  name='elaborazione' frameborder='1'  border='1' align='TOP' marginwidth='1' marginheight='1'></iframe>")+"" +
     "</label>" +
     "</span>" +
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
  static void PrintState(arpg_cgo_operazioni_agenzie_storicoBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_cgo_operazioni_agenzie_storicoBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_cgo_operazioni_agenzie_storicoBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_DaData,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A_Data,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DaDataOpe,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A_DataOpe,"D",8,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_cgo_operazioni_agenzie_storicoBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_FGMOCXNBFY = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(128,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(941,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_cgo_operazioni_agenzie_storico"),"C",0,0)+ ";");
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
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_cgo_operazioni_agenzie_storico","");
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
  void WriteMainFormScript(arpg_cgo_operazioni_agenzie_storicoBO BO,ServletStatus status) {
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
  arpg_cgo_operazioni_agenzie_storicoBO getBO(ServletStatus status) {
    arpg_cgo_operazioni_agenzie_storicoBO BO = new arpg_cgo_operazioni_agenzie_storicoBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_cgo_operazioni_agenzie_storicoBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_cgo_operazioni_agenzie_storicoBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_cgo_operazioni_agenzie_storicoBO BO) {
    BO.SetFromContext(status.m_cWv);
    BO.Calculate();
  }
  void Save(ServletStatus status,arpg_cgo_operazioni_agenzie_storicoBO BO) {
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
  void Discard(ServletStatus status,arpg_cgo_operazioni_agenzie_storicoBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,arpg_cgo_operazioni_agenzie_storicoBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",128);
    item.put("w",941);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","arpg_cgo_operazioni_agenzie_storico");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"63\",\"name\":\"Box_XLVFHSOSYH\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"XLVFHSOSYH\",\"tabindex\":\"11\",\"type\":\"Box\",\"w\":\"936\",\"x\":\"0\",\"y\":\"0\",\"zone\":\"pag1_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Ricerca le operazione da completare delle agenzie\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"30\",\"href\":\"javascript:href_RROILCAWGO()\",\"name\":\"images_search_gif\",\"page\":\"1\",\"spuid\":\"RROILCAWGO\",\"src\":\"images\\/search.gif\",\"tabindex\":\"12\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"827\",\"y\":\"18\",\"zone\":\"XLVFHSOSYH_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Esci dalla procedura\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"30\",\"href\":\"javascript:href_IIJDTQKPBX()\",\"name\":\"images_exit_gif\",\"page\":\"1\",\"spuid\":\"IIJDTQKPBX\",\"src\":\"images\\/exit.gif\",\"tabindex\":\"13\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"875\",\"y\":\"18\",\"zone\":\"XLVFHSOSYH_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Da Data Completamento\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"DaData\",\"page\":\"1\",\"spuid\":\"VAUCRMZHWP\",\"tabindex\":\"14\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"144\",\"y\":\"36\",\"zone\":\"XLVFHSOSYH_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Da_Data_Completamento_\",\"page\":\"1\",\"spuid\":\"UVJLFCGXSJ_DIV\",\"tabindex\":\"15\",\"type\":\"Label\",\"value\":\"Da Data Completamento:\",\"w\":\"128\",\"x\":\"16\",\"y\":\"40\",\"zone\":\"XLVFHSOSYH_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"A Data Completamento\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"A_Data\",\"page\":\"1\",\"spuid\":\"OXXBPYCOCK\",\"tabindex\":\"16\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"400\",\"y\":\"36\",\"zone\":\"XLVFHSOSYH_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"A_Data_Completamento_\",\"page\":\"1\",\"spuid\":\"CTLCSHLQSX_DIV\",\"tabindex\":\"17\",\"type\":\"Label\",\"value\":\"A Data Completamento:\",\"w\":\"128\",\"x\":\"272\",\"y\":\"40\",\"zone\":\"XLVFHSOSYH_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Da Data Operazione\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"DaDataOpe\",\"page\":\"1\",\"spuid\":\"HTGZKUIBWA\",\"tabindex\":\"18\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"144\",\"y\":\"7\",\"zone\":\"XLVFHSOSYH_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Da_Data_Operazione_\",\"page\":\"1\",\"spuid\":\"NPEYCYPTXA_DIV\",\"tabindex\":\"19\",\"type\":\"Label\",\"value\":\"Da Data Operazione:\",\"w\":\"128\",\"x\":\"16\",\"y\":\"11\",\"zone\":\"XLVFHSOSYH_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"A Data Operazione\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"A_DataOpe\",\"page\":\"1\",\"spuid\":\"RPNVEZKZBQ\",\"tabindex\":\"20\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"400\",\"y\":\"7\",\"zone\":\"XLVFHSOSYH_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"A_Data_Operazione_\",\"page\":\"1\",\"spuid\":\"MDVAOJTHSC_DIV\",\"tabindex\":\"21\",\"type\":\"Label\",\"value\":\"A Data Operazione:\",\"w\":\"128\",\"x\":\"272\",\"y\":\"11\",\"zone\":\"XLVFHSOSYH_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"14\",\"href\":\" \",\"name\":\"__iframe_width__655__height__170__id__elaborazione___name__elaborazione__frameborder__1___border__1__align__TOP__marginwidth__1__marginheight__1____iframe__\",\"page\":\"1\",\"spuid\":\"FGMOCXNBFY_DIV\",\"tabindex\":\"25\",\"type\":\"Label\",\"value\":\"\\\"<iframe width="+"'"+"655"+"'"+" height="+"'"+"170"+"'"+" id="+"'"+"elaborazione"+"'"+"  name="+"'"+"elaborazione"+"'"+" frameborder="+"'"+"1"+"'"+"  border="+"'"+"1"+"'"+" align="+"'"+"TOP"+"'"+" marginwidth="+"'"+"1"+"'"+" marginheight="+"'"+"1"+"'"+"><\\/iframe>\\\"\",\"w\":\"88\",\"x\":\"672\",\"y\":\"35\",\"zone\":\"\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteBody(ServletStatus status,arpg_cgo_operazioni_agenzie_storicoBO BO) {
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
  void WriteTrs(ServletStatus status,arpg_cgo_operazioni_agenzie_storicoBO BO) {
    status.out.println("var c_DATAOPE;");
    status.out.println("var c_CACODICE;");
    status.out.println("var c_CADESCRI;");
    status.out.println("var c_SNAINUMOPE;");
    status.out.println("var c_TOTLIRE;");
    status.out.println("var c_SEGNO;");
    status.out.println("var c_CAIDBIGLIETTO;");
    status.out.println("var c_CGODATDIPCOM;");
    status.out.println("var m_oTrsFW;");
    status.out.println("m_oTrsFW = []");
    status.out.println("var m_oTrsQuery;");
    status.out.println("m_oTrsQuery = []");
    WriteBody(status,BO);
    status.out.println("m_nRows="+status.m_nRows+";");
  }
  void AddTrsQueryRow(ServletStatus status,int p_nCnt,arpg_cgo_operazioni_agenzie_storicoBO BO) {
    String l_cTrsQ;
    l_cTrsQ = " new TrsQueryRow(";
    l_cTrsQ = l_cTrsQ+SPLib.ToJSValue(BO.c_DATAOPE,"D",8,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_CACODICE,"N",5,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_CADESCRI,"C",90,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_SNAINUMOPE,"C",15,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_TOTLIRE,"N",15,2);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_SEGNO,"C",1,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_CAIDBIGLIETTO,"C",28,0);
    l_cTrsQ = l_cTrsQ+","+SPLib.ToJSValue(BO.c_CGODATDIPCOM,"D",8,0);
    l_cTrsQ = l_cTrsQ+")";
    status.out.println("m_oTrsQuery["+p_nCnt+"] = "+l_cTrsQ+"");
  }
  void Next(ServletStatus status,arpg_cgo_operazioni_agenzie_storicoBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_cgo_operazioni_agenzie_storicoBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_cgo_operazioni_agenzie_storicoBO BO,ServletStatus status) {
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
     "<script src='arpg_cgo_operazioni_agenzie_storico?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
     "<script src='SPPrxy/"+m_cEntityUid+"/arpg_cgo_operazioni_agenzie_storico_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(128,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
  void RaiseLoadedEntity(arpg_cgo_operazioni_agenzie_storicoBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_cgo_operazioni_agenzie_storicoBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(arpg_cgo_operazioni_agenzie_storicoBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(arpg_cgo_operazioni_agenzie_storicoBO BO,ServletStatus status) {
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
  void WriteExitPage(arpg_cgo_operazioni_agenzie_storicoBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(arpg_cgo_operazioni_agenzie_storicoBO BO,ServletStatus status) {
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
      arrt_cgo_moduli_storico.GetCallableNames(callable);
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,arpg_cgo_operazioni_agenzie_storicoBO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,arpg_cgo_operazioni_agenzie_storicoBO BO) {
    boolean result = true;
    return result;
  }
}
