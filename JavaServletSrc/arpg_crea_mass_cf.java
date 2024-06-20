import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_crea_mass_cf extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*HCONRBNVTP*!";
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
    arpg_crea_mass_cfBO BO;
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
    return "Creazione File Controllo Massivo Codici Fiscali";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_crea_mass_cf";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 821;
    l_eg.m_nEntityHeight = 411;
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
                   new SPItem("gIntemediario","C",11,0, "hide","Intermediario"),
                   new SPItem("gDescAzi","C",70,0, "hide","Descrizione Intermediario"),
                   new SPItem("gFlgWU","C",1,0, "hide","Gestione WU"),
                   new SPItem("tiposog","C",1,0, "edit",""),
                   new SPItem("tipoout","C",1,0, "hide",""),
                   new SPItem("tipoinv","C",1,0, "edit",""),
                   new SPItem("maxinvii","N",10,0, "show","N. Massimo Invii Effettuabili"),
                   new SPItem("a2011","C",1,0, "edit",""),
                   new SPItem("a2012","C",1,0, "edit",""),
                   new SPItem("a2013","C",1,0, "edit",""),
                   new SPItem("a2014","C",1,0, "edit",""),
                   new SPItem("a2015","C",1,0, "edit",""),
                   new SPItem("a2016","C",1,0, "edit",""),
                   new SPItem("a2017","C",1,0, "edit",""),
                   new SPItem("a2018","C",1,0, "edit",""),
                   new SPItem("a2019","C",1,0, "edit","")
                 };
    l_eg.m_lExecuteAtStart = true;
    l_eg.m_cQueryName = "";
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,arpg_crea_mass_cfBO BO) {
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
    l_translations=new String[][]{{"10457981292",p_Context.Translate("Descrizione Intermediario")},
    {"10679172996",p_Context.Translate("N. Massimo Invii Effettuabili")},
    {"10983493593",p_Context.Translate("Gestione WU")},
    {"11396780126",p_Context.Translate("Intermediario")},
    {"11421805868",p_Context.Translate("Vuoi calcolare il numero di record massimo?")},
    {"1162057163",p_Context.Translate("Confermi la creazione dei file mensili ?")},
    {"12090677005",p_Context.Translate("Visualizza file creati")},
    {"1557914413",p_Context.Translate("Creazione File Controllo Massivo Codici Fiscali")},
    {"214066",p_Context.Translate("2011")},
    {"218162",p_Context.Translate("2012")},
    {"222258",p_Context.Translate("2013")},
    {"226354",p_Context.Translate("2014")},
    {"230450",p_Context.Translate("2015")},
    {"234546",p_Context.Translate("2016")},
    {"238642",p_Context.Translate("2017")},
    {"242738",p_Context.Translate("2018")},
    {"246834",p_Context.Translate("2019")}};
    return l_translations;
  }
  void WriteStyles(arpg_crea_mass_cfBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/arpg_crea_mass_cf.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(arpg_crea_mass_cfBO BO,ServletStatus status) {
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
  // GetPortlet_Messaggi_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_DYMVKIQWCA_Vars(arpg_crea_mass_cfBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  // GetPortlet_Log_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_KQMKKBMXYE_Vars(arpg_crea_mass_cfBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  void WriteControls(arpg_crea_mass_cfBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(arpg_crea_mass_cfBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(406);
    WriteControls_1_h_0(BO,status);
  }
  void WriteControls_1_h_0(arpg_crea_mass_cfBO BO,ServletStatus status) {
    status.out.println(
     "<div id='TTRVXROIVP_DIV' class='UntitledBox'>" +
     "<div id='TTRVXROIVP' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DMMJSVFBEV_DIV'>" +
     "<label id='DMMJSVFBEV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("CREAZIONE FILE CONTROLLO MASSIVO CODICI FISCALI"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='ALQVOOWZEV' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Crea Comunicazione"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' onkeydown='ManageKeys(event,false,false,true)' onclick='ALQVOOWZEV_Click()'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_AJXISNWTIP()' tabindex='-1' id='AJXISNWTIP_HREF'>" +
     "<img id='AJXISNWTIP' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/exit.gif"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt=''>" +
     "</a>" +
    "");
    status.out.println(
     "<div id='DYMVKIQWCA'>" +
    "");
    // GetPortlet_Messaggi_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_DYMVKIQWCA;
    inclusionVars_DYMVKIQWCA = GetPortlet_DYMVKIQWCA_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_DYMVKIQWCA);
    String portletUID_DYMVKIQWCA = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/showmsg_portlet.jsp?ForcedPortletUID="+ portletUID_DYMVKIQWCA+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_DYMVKIQWCA),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.DYMVKIQWCA='"+portletUID_DYMVKIQWCA+"';" +
     "w_pMsg=ZtVWeb.getPortletById('"+portletUID_DYMVKIQWCA+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<div id='KQMKKBMXYE'>" +
    "");
    // GetPortlet_Log_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_KQMKKBMXYE;
    inclusionVars_KQMKKBMXYE = GetPortlet_KQMKKBMXYE_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_KQMKKBMXYE);
    String portletUID_KQMKKBMXYE = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/showlog_portlet.jsp?ForcedPortletUID="+ portletUID_KQMKKBMXYE+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_KQMKKBMXYE),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.KQMKKBMXYE='"+portletUID_KQMKKBMXYE+"';" +
     "w_pLog=ZtVWeb.getPortletById('"+portletUID_KQMKKBMXYE+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_JBNBDKBIAJ()' tabindex='-1' id='JBNBDKBIAJ_HREF'>" +
     "<img id='JBNBDKBIAJ' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/search.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Visualizza file creati"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Visualizza file creati"),"C",0,0)+">" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='tiposog' id='CPBCFXOJEC' class='Combobox' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("C","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("C",CPLib.Trim(BO.w_tiposog))?"SELECTED":"")+">" +
     ""+status.context.Translate("Solo Soggetti con Codice Fiscale")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("E","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("E",CPLib.Trim(BO.w_tiposog))?"SELECTED":"")+">" +
     ""+status.context.Translate("Solo Soggetti senza Codice Fiscale")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("T","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("T",CPLib.Trim(BO.w_tiposog))?"SELECTED":"")+">" +
     ""+status.context.Translate("Tutti i Soggetti")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_tiposog))?"SELECTED":"")+">" +
     ""+status.context.Translate("Tutti i soggetti (Prima quelli senza e poi quelli con codice fiscale)")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_tiposog))?"SELECTED":"")+">" +
     ""+status.context.Translate("Tutti i soggetti (Prima quelli con e poi quelli senza codice fiscale)")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('CPBCFXOJEC'),w_tiposog,'C');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FGMOCXNBFY_DIV' style='display:none'>" +
     "<label id='FGMOCXNBFY'>" +
     ""+SPLib.ToHTMLRepresentation("<iframe width='655' height='170' id='elaborazione'  name='elaborazione' frameborder='1'  border='1' align='TOP' marginwidth='1' marginheight='1'></iframe>")+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<div id='AKHAWZVTWL_DIV'>" +
     "<span id='AKHAWZVTWL_0_container'>" +
     "<input id='AKHAWZVTWL_0' name='AKHAWZVTWL' type='radio' value="+SPLib.ToHTMLValue("G","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("G",CPLib.Trim(BO.w_tipoinv))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='AKHAWZVTWL_0'>"+status.context.Translate("Invio Globale")+"</label>" +
     "</span>" +
     "<span id='AKHAWZVTWL_1_container'>" +
     "<input id='AKHAWZVTWL_1' name='AKHAWZVTWL' type='radio' value="+SPLib.ToHTMLValue("P","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("P",CPLib.Trim(BO.w_tipoinv))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='AKHAWZVTWL_1'>"+status.context.Translate("Primo Invio (Limitato)")+"</label>" +
     "</span>" +
     "<span id='AKHAWZVTWL_2_container'>" +
     "<input id='AKHAWZVTWL_2' name='AKHAWZVTWL' type='radio' value="+SPLib.ToHTMLValue("S","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tipoinv))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='AKHAWZVTWL_2'>"+status.context.Translate("Invii Successivi")+"</label>" +
     "</span>" +
     "</div>" +
    "");
    status.out.println(
     "<input name='maxinvii' id='FSIGQXURNL' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_maxinvii,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N' onkeypress='' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VNUQKFZYEW_DIV' style='display:none'>" +
     "<label id='VNUQKFZYEW' for='FSIGQXURNL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("N. Massimo Invii Effettuabili:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='OKFXLPIBJW' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Calcola"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' onkeydown='ManageKeys(event,false,false,true)' onclick='OKFXLPIBJW_Click()' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='KLUTVGESET_DIV' style='display:none'>" +
     "<input name='a2011' id='KLUTVGESET' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_a2011,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_a2011))?"CHECKED":"")+">" +
     "<label id='KLUTVGESET_LBL' for='KLUTVGESET' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("2011"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YXROKNYPVY_DIV' style='display:none'>" +
     "<label id='YXROKNYPVY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Anni di riferimento per la selezione dei soggetti da cui inviare i dati"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='WFROVCSJJF_DIV' style='display:none'>" +
     "<input name='a2012' id='WFROVCSJJF' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_a2012,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_a2012))?"CHECKED":"")+">" +
     "<label id='WFROVCSJJF_LBL' for='WFROVCSJJF' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("2012"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='VHNANTQLDO_DIV' style='display:none'>" +
     "<input name='a2013' id='VHNANTQLDO' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_a2013,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_a2013))?"CHECKED":"")+">" +
     "<label id='VHNANTQLDO_LBL' for='VHNANTQLDO' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("2013"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='NYQRDWPVQW_DIV' style='display:none'>" +
     "<input name='a2014' id='NYQRDWPVQW' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_a2014,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_a2014))?"CHECKED":"")+">" +
     "<label id='NYQRDWPVQW_LBL' for='NYQRDWPVQW' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("2014"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='EWRHUMIOJD_DIV' style='display:none'>" +
     "<input name='a2015' id='EWRHUMIOJD' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_a2015,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_a2015))?"CHECKED":"")+">" +
     "<label id='EWRHUMIOJD_LBL' for='EWRHUMIOJD' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("2015"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='YRRCXCTEWB_DIV' style='display:none'>" +
     "<input name='a2016' id='YRRCXCTEWB' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_a2016,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_a2016))?"CHECKED":"")+">" +
     "<label id='YRRCXCTEWB_LBL' for='YRRCXCTEWB' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("2016"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='SVHKBBCQHM_DIV' style='display:none'>" +
     "<input name='a2017' id='SVHKBBCQHM' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_a2017,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_a2017))?"CHECKED":"")+">" +
     "<label id='SVHKBBCQHM_LBL' for='SVHKBBCQHM' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("2017"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='NLIHHTTFII_DIV' style='display:none'>" +
     "<input name='a2018' id='NLIHHTTFII' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_a2018,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_a2018))?"CHECKED":"")+">" +
     "<label id='NLIHHTTFII_LBL' for='NLIHHTTFII' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("2018"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='EFUHYXQNOB_DIV' style='display:none'>" +
     "<input name='a2019' id='EFUHYXQNOB' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_a2019,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_a2019))?"CHECKED":"")+">" +
     "<label id='EFUHYXQNOB_LBL' for='EFUHYXQNOB' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("2019"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='ZCHZGJTEXB' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Crea Comunicazione"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' onkeydown='ManageKeys(event,false,false,true)' onclick='ZCHZGJTEXB_Click()' style='display:none'>" +
    "");
    status.themeWriter.Header_EndHtml();
  }
  static void PrintState(arpg_crea_mass_cfBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_crea_mass_cfBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_crea_mass_cfBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_gIntemediario,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gDescAzi,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgWU,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tiposog,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipoout,"C",1,0));
    status.out.print(","+"["+SPLib.ToJSValue(BO.w_tipoinv,"C",1,0)+","+SPLib.ToJSValue(BO.o_tipoinv,"C",1,0)+"]");
    status.out.print(","+SPLib.ToJSValue(BO.w_maxinvii,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_a2011,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_a2012,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_a2013,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_a2014,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_a2015,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_a2016,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_a2017,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_a2018,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_a2019,"C",1,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_crea_mass_cfBO BO,ServletStatus status) {
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(411,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(821,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_crea_mass_cf"),"C",0,0)+ ";");
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
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_crea_mass_cf","");
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
  void WriteMainFormScript(arpg_crea_mass_cfBO BO,ServletStatus status) {
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
    status.out.println("// * --- arpg_crea_mass_cf");
    status.out.println("function Calcola() {");
    status.out.println(" arrt_mass_cf_calcola_max([])");
    status.out.println("}");
    status.out.println("");
    status.out.println("function Lancio() {");
    status.out.println("  w_pLog.Timer0.Start()");
    status.out.println("  w_pMsg.Timer0.Start()");
    status.out.println("  ZCHZGJTEXB_Click()");
    status.out.println("}");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  arpg_crea_mass_cfBO getBO(ServletStatus status) {
    arpg_crea_mass_cfBO BO = new arpg_crea_mass_cfBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_crea_mass_cfBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_crea_mass_cfBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_crea_mass_cfBO BO) {
    BO.SetFromContext(status.m_cWv);
    BO.Calculate();
  }
  void Save(ServletStatus status,arpg_crea_mass_cfBO BO) {
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
  void Discard(ServletStatus status,arpg_crea_mass_cfBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,arpg_crea_mass_cfBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",411);
    item.put("w",821);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","arpg_crea_mass_cf");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"407\",\"name\":\"Box_TTRVXROIVP\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"TTRVXROIVP\",\"tabindex\":\"1\",\"type\":\"Box\",\"w\":\"801\",\"x\":\"-1\",\"y\":\"-1\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\"#0000FF\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"CREAZIONE_FILE_CONTROLLO_MASSIVO_CODICI_FISCALI\",\"page\":\"1\",\"spuid\":\"DMMJSVFBEV_DIV\",\"tabindex\":\"2\",\"type\":\"Label\",\"value\":\"CREAZIONE FILE CONTROLLO MASSIVO CODICI FISCALI\",\"w\":\"800\",\"x\":\"0\",\"y\":\"0\",\"zone\":\"TTRVXROIVP_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"56\",\"href\":\"javascript:ALQVOOWZEV_Click()\",\"name\":\"Crea_Comunicazione\",\"page\":\"1\",\"spuid\":\"ALQVOOWZEV\",\"tabindex\":\"3\",\"type\":\"Button\",\"value\":\"Crea Comunicazione\",\"w\":\"193\",\"x\":\"605\",\"y\":\"77\",\"zone\":\"TTRVXROIVP_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"28\",\"href\":\"javascript:href_AJXISNWTIP()\",\"name\":\"images_exit_gif\",\"page\":\"1\",\"spuid\":\"AJXISNWTIP\",\"src\":\"images\\/exit.gif\",\"tabindex\":\"4\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"752\",\"y\":\"35\",\"zone\":\"TTRVXROIVP_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"84\",\"name\":\"Portlet_DYMVKIQWCA\",\"page\":\"1\",\"src\":\"\\/jsp\\/showmsg_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____DYMVKIQWCA\",\"type\":\"Portlet\",\"w\":\"797\",\"x\":\"0\",\"y\":\"313\",\"zone\":\"TTRVXROIVP_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"173\",\"name\":\"Portlet_KQMKKBMXYE\",\"page\":\"1\",\"src\":\"\\/jsp\\/showlog_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____KQMKKBMXYE\",\"type\":\"Portlet\",\"w\":\"797\",\"x\":\"0\",\"y\":\"139\",\"zone\":\"TTRVXROIVP_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Visualizza file creati\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"28\",\"href\":\"javascript:href_JBNBDKBIAJ()\",\"name\":\"images_search_gif\",\"page\":\"1\",\"spuid\":\"JBNBDKBIAJ\",\"src\":\"images\\/search.gif\",\"tabindex\":\"9\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"704\",\"y\":\"35\",\"zone\":\"TTRVXROIVP_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"tiposog\",\"page\":\"1\",\"spuid\":\"CPBCFXOJEC\",\"tabindex\":\"11\",\"textlist\":\"Solo Soggetti con Codice Fiscale,Solo Soggetti senza Codice Fiscale,Tutti i Soggetti,Tutti i soggetti (Prima quelli senza e poi quelli con codice fiscale),Tutti i soggetti (Prima quelli con e poi quelli senza codice fiscale)\",\"type\":\"Combobox\",\"valuelist\":\""+"'"+"C"+"'"+","+"'"+"E"+"'"+","+"'"+"T"+"'"+","+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":\"576\",\"x\":\"8\",\"y\":\"97\",\"zone\":\"TTRVXROIVP_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"14\",\"href\":\" \",\"name\":\"__iframe_width__655__height__170__id__elaborazione___name__elaborazione__frameborder__1___border__1__align__TOP__marginwidth__1__marginheight__1____iframe__\",\"page\":\"1\",\"spuid\":\"FGMOCXNBFY_DIV\",\"tabindex\":\"12\",\"type\":\"Label\",\"value\":\"\\\"<iframe width="+"'"+"655"+"'"+" height="+"'"+"170"+"'"+" id="+"'"+"elaborazione"+"'"+"  name="+"'"+"elaborazione"+"'"+" frameborder="+"'"+"1"+"'"+"  border="+"'"+"1"+"'"+" align="+"'"+"TOP"+"'"+" marginwidth="+"'"+"1"+"'"+" marginheight="+"'"+"1"+"'"+"><\\/iframe>\\\"\",\"w\":\"88\",\"x\":\"705\",\"y\":\"19\",\"zone\":\"\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"19\",\"name\":\"tipoinv\",\"orientation\":\"horizontal\",\"page\":\"1\",\"spuid\":\"AKHAWZVTWL\",\"tabindex\":\"14\",\"textlist\":\"Invio Globale,Primo Invio (Limitato),Invii Successivi\",\"type\":\"Radio\",\"valuelist\":\""+"'"+"G"+"'"+","+"'"+"P"+"'"+","+"'"+"S"+"'"+"\",\"w\":\"336\",\"x\":\"8\",\"y\":\"22\",\"zone\":\"TTRVXROIVP_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"N. Massimo Invii Effettuabili\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"11\",\"name\":\"maxinvii\",\"page\":\"1\",\"spuid\":\"FSIGQXURNL\",\"type\":\"Textbox\",\"w\":\"72\",\"x\":\"508\",\"y\":\"21\",\"zone\":\"TTRVXROIVP_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"N__Massimo_Invii_Effettuabili_\",\"page\":\"1\",\"spuid\":\"VNUQKFZYEW_DIV\",\"tabindex\":\"16\",\"type\":\"Label\",\"value\":\"N. Massimo Invii Effettuabili:\",\"w\":\"149\",\"x\":\"359\",\"y\":\"25\",\"zone\":\"TTRVXROIVP_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"href\":\"javascript:OKFXLPIBJW_Click()\",\"name\":\"Calcola\",\"page\":\"1\",\"spuid\":\"OKFXLPIBJW\",\"tabindex\":\"17\",\"type\":\"Button\",\"value\":\"Calcola\",\"w\":\"50\",\"x\":\"587\",\"y\":\"21\",\"zone\":\"TTRVXROIVP_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"a2011\",\"page\":\"1\",\"spuid\":\"KLUTVGESET\",\"tabindex\":\"18\",\"type\":\"Checkbox\",\"w\":\"56\",\"x\":\"8\",\"y\":\"63\",\"zone\":\"TTRVXROIVP_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Anni_di_riferimento_per_la_selezione_dei_soggetti_da_cui_inviare_i_dati\",\"page\":\"1\",\"spuid\":\"YXROKNYPVY_DIV\",\"tabindex\":\"19\",\"type\":\"Label\",\"value\":\"Anni di riferimento per la selezione dei soggetti da cui inviare i dati\",\"w\":\"346\",\"x\":\"8\",\"y\":\"43\",\"zone\":\"TTRVXROIVP_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"a2012\",\"page\":\"1\",\"spuid\":\"WFROVCSJJF\",\"tabindex\":\"20\",\"type\":\"Checkbox\",\"w\":\"56\",\"x\":\"72\",\"y\":\"63\",\"zone\":\"TTRVXROIVP_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"a2013\",\"page\":\"1\",\"spuid\":\"VHNANTQLDO\",\"tabindex\":\"21\",\"type\":\"Checkbox\",\"w\":\"56\",\"x\":\"136\",\"y\":\"63\",\"zone\":\"TTRVXROIVP_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"a2014\",\"page\":\"1\",\"spuid\":\"NYQRDWPVQW\",\"tabindex\":\"22\",\"type\":\"Checkbox\",\"w\":\"56\",\"x\":\"200\",\"y\":\"63\",\"zone\":\"TTRVXROIVP_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"a2015\",\"page\":\"1\",\"spuid\":\"EWRHUMIOJD\",\"tabindex\":\"23\",\"type\":\"Checkbox\",\"w\":\"56\",\"x\":\"264\",\"y\":\"63\",\"zone\":\"TTRVXROIVP_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"a2016\",\"page\":\"1\",\"spuid\":\"YRRCXCTEWB\",\"tabindex\":\"24\",\"type\":\"Checkbox\",\"w\":\"56\",\"x\":\"328\",\"y\":\"63\",\"zone\":\"TTRVXROIVP_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"a2017\",\"page\":\"1\",\"spuid\":\"SVHKBBCQHM\",\"tabindex\":\"25\",\"type\":\"Checkbox\",\"w\":\"56\",\"x\":\"392\",\"y\":\"63\",\"zone\":\"TTRVXROIVP_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"a2018\",\"page\":\"1\",\"spuid\":\"NLIHHTTFII\",\"tabindex\":\"26\",\"type\":\"Checkbox\",\"w\":\"56\",\"x\":\"456\",\"y\":\"63\",\"zone\":\"TTRVXROIVP_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"a2019\",\"page\":\"1\",\"spuid\":\"EFUHYXQNOB\",\"tabindex\":\"28\",\"type\":\"Checkbox\",\"w\":\"56\",\"x\":\"520\",\"y\":\"63\",\"zone\":\"TTRVXROIVP_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"56\",\"href\":\"javascript:ZCHZGJTEXB_Click()\",\"name\":\"Crea_Comunicazione\",\"page\":\"1\",\"spuid\":\"ZCHZGJTEXB\",\"tabindex\":\"29\",\"type\":\"Button\",\"value\":\"Crea Comunicazione\",\"w\":\"32\",\"x\":\"656\",\"y\":\"21\",\"zone\":\"TTRVXROIVP_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void Next(ServletStatus status,arpg_crea_mass_cfBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_crea_mass_cfBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_crea_mass_cfBO BO,ServletStatus status) {
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
     "<script src='arpg_crea_mass_cf?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
     "<script src='SPPrxy/"+m_cEntityUid+"/arpg_crea_mass_cf_proc.js'>" +
     "</script>" +
    "");
    IncludeJS(status);
    RaiseSavedEntity(BO,status);
    RaiseDeletedEntity(BO,status);
    RaiseDiscardedEntity(BO,status);
    // Dichiarazione delle variabili di script
    WriteMainFormVarScript(BO,status);
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_mass_cf_calcola_max.js");
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
    status.themeWriter.WriteBody_Begin(411,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
  void RaiseLoadedEntity(arpg_crea_mass_cfBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_crea_mass_cfBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(arpg_crea_mass_cfBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(arpg_crea_mass_cfBO BO,ServletStatus status) {
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
  void WriteExitPage(arpg_crea_mass_cfBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(arpg_crea_mass_cfBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  void IncludeJS(ServletStatus status) {
    String l_cJsUid;
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_mass_cf_calcola_max.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
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
      arrt_crea_mass_cf.GetCallableNames(callable);
      CPLib.AddToSet(callable,"arrt_mass_cf_calcola_max");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,arpg_crea_mass_cfBO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,arpg_crea_mass_cfBO BO) {
    boolean result = true;
    return result;
  }
}
