import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_stp_stdtec_frz_new extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*PVYUUWGHSQ*!";
  static public class ServletStatus extends SPPageServletStatus {
    public void MergeCallerVars(SPParameterSource source) {
      source.SetParameter("DaDatOpe",source.GetCaller().GetDate("DaDatOpe","D",8,0));
      source.SetParameter("ADatOpe",source.GetCaller().GetDate("ADatOpe","D",8,0));
      source.SetParameter("c_dadata",source.GetCaller().GetString("c_dadata","C",8,0));
      source.SetParameter("c_adata",source.GetCaller().GetString("c_adata","C",8,0));
      source.SetParameter("flgrae",source.GetCaller().GetString("flgrae","C",1,0));
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
    arpg_stp_stdtec_frz_newBO BO;
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
    return "Stampa Verifica Frazionate (Standard Tecnici)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_stp_stdtec_frz_new";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 781;
    l_eg.m_nEntityHeight = 453;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"anadip","personbo"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.items = new SPItem[]{
                   new SPItem("daCodDip","C",6,0, "edit",""),
                   new SPItem("aCodDip","C",6,0, "edit",""),
                   new SPItem("DaDatOpe","D",8,0, "edit",""),
                   new SPItem("ADatOpe","D",8,0, "edit",""),
                   new SPItem("daCodCli","C",16,0, "edit",""),
                   new SPItem("aCodCli","C",16,0, "edit",""),
                   new SPItem("RAGSOC1","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("RAGSOC2","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("c_dadata","C",8,0, "hide",""),
                   new SPItem("c_adata","C",8,0, "hide",""),
                   new SPItem("DESCRIZ1","C",30,0, "hide","Descrizione"),
                   new SPItem("DESCRIZ2","C",30,0, "hide","Descrizione"),
                   new SPItem("flgrae","C",1,0, "hide","Rae/ateco"),
                   new SPItem("tipopdf","C",6,0, "edit","Tipologia PDF")
                 };
    l_eg.m_lExecuteAtStart = false;
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,arpg_stp_stdtec_frz_newBO BO) {
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
    l_translations=new String[][]{{"10022152891",p_Context.Translate("Tipologia PDF")},
    {"10505367639",p_Context.Translate("Persone / Societ� / Legali Rappresentanti")},
    {"10557974447",p_Context.Translate("La data di fine periodo non deve essere minore di quella di inizio periodo!")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"11666950191",p_Context.Translate("Rae/ateco")},
    {"1454664372",p_Context.Translate("Stampa Verifica Frazionate (Standard Tecnici)")},
    {"1813072817",p_Context.Translate("Agenzie")},
    {"1882407113",p_Context.Translate("Confermi la creazione della stampa?")},
    {"285808099",p_Context.Translate("Descrizione")}};
    return l_translations;
  }
  void WriteStyles(arpg_stp_stdtec_frz_newBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/arpg_stp_stdtec_frz_new.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(arpg_stp_stdtec_frz_newBO BO,ServletStatus status) {
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
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_DYMVKIQWCA_Vars(arpg_stp_stdtec_frz_newBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  // GetPortlet_Log_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_KQMKKBMXYE_Vars(arpg_stp_stdtec_frz_newBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  void WriteControls(arpg_stp_stdtec_frz_newBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(arpg_stp_stdtec_frz_newBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(448);
    WriteControls_1_h_0(BO,status);
  }
  void WriteControls_1_h_0(arpg_stp_stdtec_frz_newBO BO,ServletStatus status) {
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='daCodDip' id='UQFVYWSNYY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_daCodDip,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
     "<button id='UQFVYWSNYY_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='UQFVYWSNYY_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='aCodDip' id='HXBJUMEZIA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_aCodDip,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
     "<button id='HXBJUMEZIA_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='HXBJUMEZIA_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DaDatOpe' id='DPKVLWHCIG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DaDatOpe,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='DPKVLWHCIG_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='DPKVLWHCIG_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='ADatOpe' id='MTJDZQTEIR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ADatOpe,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='MTJDZQTEIR_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='MTJDZQTEIR_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='daCodCli' id='UYVYTEMEXX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_daCodCli,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
     "<button id='UYVYTEMEXX_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='UYVYTEMEXX_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='aCodCli' id='CJWUHWULAR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_aCodCli,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
     "<button id='CJWUHWULAR_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='CJWUHWULAR_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_XURLGQZZMU()' tabindex='-1' id='XURLGQZZMU_HREF'>" +
     "<img id='XURLGQZZMU' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/print.gif"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt=''>" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_PTXYMSWBZO()' tabindex='-1' id='PTXYMSWBZO_HREF'>" +
     "<img id='PTXYMSWBZO' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/exit.gif"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt=''>" +
     "</a>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HPGJXQIVYG_DIV'>" +
     "<label id='HPGJXQIVYG'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da Data Operazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='BGHAITOPMU_DIV'>" +
     "<label id='BGHAITOPMU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A Data Operazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PCILMATBXL_DIV'>" +
     "<label id='PCILMATBXL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VXJAZUGUIO_DIV'>" +
     "<label id='VXJAZUGUIO'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_RAGSOC1)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JGQCNSZOCQ_DIV'>" +
     "<label id='JGQCNSZOCQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XCBBNKIAUV_DIV'>" +
     "<label id='XCBBNKIAUV'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_RAGSOC2)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZWZOQIGZCX_DIV'>" +
     "<label id='ZWZOQIGZCX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da Agenzia/Dipendenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RXKVDVJPTZ_DIV'>" +
     "<label id='RXKVDVJPTZ'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_DESCRIZ1)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='BGOVXFIBXQ_DIV'>" +
     "<label id='BGOVXFIBXQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Ad Agenzia/Dipendenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LNFAXDLCMF_DIV'>" +
     "<label id='LNFAXDLCMF'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_DESCRIZ2)+"" +
     "</label>" +
     "</span>" +
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
     "w_Messaggi=ZtVWeb.getPortletById('"+portletUID_DYMVKIQWCA+"');" +
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
     "w_Log=ZtVWeb.getPortletById('"+portletUID_KQMKKBMXYE+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
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
     "<select name='tipopdf' id='IDBBKLYUJD' class='Combobox' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("PDF","C",6,0,"", status.m_oRegSettings)+" "+(CPLib.eq("PDF",CPLib.Trim(BO.w_tipopdf))?"SELECTED":"")+">" +
     ""+status.context.Translate("PDF Standard")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("PDFA1B","C",6,0,"", status.m_oRegSettings)+" "+(CPLib.eq("PDFA1B",CPLib.Trim(BO.w_tipopdf))?"SELECTED":"")+">" +
     ""+status.context.Translate("PDF per Conservazione")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('IDBBKLYUJD'),w_tipopdf,'C');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JKOUFWCMIT_DIV'>" +
     "<label id='JKOUFWCMIT' for='IDBBKLYUJD'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipologia PDF:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_HLPOJCMBVW()' tabindex='-1' style='display:none' id='HLPOJCMBVW_HREF'>" +
     "<img id='HLPOJCMBVW' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/print.gif"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt=''>" +
     "</a>" +
    "");
    status.themeWriter.Header_EndHtml();
  }
  static void PrintState(arpg_stp_stdtec_frz_newBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_stp_stdtec_frz_newBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_stp_stdtec_frz_newBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_daCodDip,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_aCodDip,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DaDatOpe,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ADatOpe,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_daCodCli,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_aCodCli,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAGSOC1,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAGSOC2,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_c_dadata,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_c_adata,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCRIZ1,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCRIZ2,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgrae,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipopdf,"C",6,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_stp_stdtec_frz_newBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_VXJAZUGUIO = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_XCBBNKIAUV = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_RXKVDVJPTZ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_LNFAXDLCMF = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_FGMOCXNBFY = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(453,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(781,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_stp_stdtec_frz_new"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    status.out.print("'UQFVYWSNYY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODDIPCODDIP,DESCRIZC,Canadip",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
    status.out.print(",'HXBJUMEZIA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODDIPCODDIP,DESCRIZC,Canadip",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
    status.out.print(",'UYVYTEMEXX':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CONNESCONNES,RAGSOCC,Cpersonbo",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
    status.out.print(",'CJWUHWULAR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CONNESCONNES,RAGSOCC,Cpersonbo",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
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
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_stp_stdtec_frz_new","");
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
  void WriteMainFormScript(arpg_stp_stdtec_frz_newBO BO,ServletStatus status) {
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
    status.out.println("// * --- arpg_stp_stdtec_frz_new");
    status.out.println("function Lancio() {");
    status.out.println("  w_Log.Timer0.Start()");
    status.out.println("  w_Messaggi.Timer0.Start()");
    status.out.println("  href_HLPOJCMBVW()  ");
    status.out.println("}  ");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  arpg_stp_stdtec_frz_newBO getBO(ServletStatus status) {
    arpg_stp_stdtec_frz_newBO BO = new arpg_stp_stdtec_frz_newBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_stp_stdtec_frz_newBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_stp_stdtec_frz_newBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_stp_stdtec_frz_newBO BO) {
    BO.SetFromContext(status.m_cWv);
    BO.Calculate();
  }
  void Save(ServletStatus status,arpg_stp_stdtec_frz_newBO BO) {
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
  void Discard(ServletStatus status,arpg_stp_stdtec_frz_newBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,arpg_stp_stdtec_frz_newBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",453);
    item.put("w",781);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","arpg_stp_stdtec_frz_new");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"6\",\"name\":\"daCodDip\",\"page\":\"1\",\"spuid\":\"UQFVYWSNYY\",\"tabindex\":\"1\",\"type\":\"Textbox\",\"w\":\"70\",\"x\":\"168\",\"y\":\"36\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"6\",\"name\":\"aCodDip\",\"page\":\"1\",\"spuid\":\"HXBJUMEZIA\",\"tabindex\":\"2\",\"type\":\"Textbox\",\"w\":\"70\",\"x\":\"168\",\"y\":\"64\",\"zone\":\"pag1_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"DaDatOpe\",\"page\":\"1\",\"spuid\":\"DPKVLWHCIG\",\"tabindex\":\"3\",\"type\":\"Textbox\",\"w\":\"72\",\"x\":\"168\",\"y\":\"90\",\"zone\":\"pag1_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"ADatOpe\",\"page\":\"1\",\"spuid\":\"MTJDZQTEIR\",\"tabindex\":\"4\",\"type\":\"Textbox\",\"w\":\"72\",\"x\":\"384\",\"y\":\"90\",\"zone\":\"pag1_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"16\",\"name\":\"daCodCli\",\"page\":\"1\",\"spuid\":\"UYVYTEMEXX\",\"tabindex\":\"5\",\"type\":\"Textbox\",\"w\":\"94\",\"x\":\"168\",\"y\":\"117\",\"zone\":\"pag1_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"16\",\"name\":\"aCodCli\",\"page\":\"1\",\"spuid\":\"CJWUHWULAR\",\"tabindex\":\"6\",\"type\":\"Textbox\",\"w\":\"94\",\"x\":\"168\",\"y\":\"145\",\"zone\":\"pag1_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"33\",\"href\":\"javascript:href_XURLGQZZMU()\",\"name\":\"images_print_gif\",\"page\":\"1\",\"spuid\":\"XURLGQZZMU\",\"src\":\"images\\/print.gif\",\"tabindex\":\"7\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"346\",\"y\":\"415\",\"zone\":\"pag1_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"33\",\"href\":\"javascript:href_PTXYMSWBZO()\",\"name\":\"images_exit_gif\",\"page\":\"1\",\"spuid\":\"PTXYMSWBZO\",\"src\":\"images\\/exit.gif\",\"tabindex\":\"8\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"394\",\"y\":\"415\",\"zone\":\"pag1_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Da_Data_Operazione_\",\"page\":\"1\",\"spuid\":\"HPGJXQIVYG_DIV\",\"tabindex\":\"9\",\"type\":\"Label\",\"value\":\"Da Data Operazione:\",\"w\":\"124\",\"x\":\"40\",\"y\":\"94\",\"zone\":\"pag1_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"A_Data_Operazione_\",\"page\":\"1\",\"spuid\":\"BGHAITOPMU_DIV\",\"tabindex\":\"10\",\"type\":\"Label\",\"value\":\"A Data Operazione:\",\"w\":\"124\",\"x\":\"256\",\"y\":\"94\",\"zone\":\"pag1_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Da_Cliente_\",\"page\":\"1\",\"spuid\":\"PCILMATBXL_DIV\",\"tabindex\":\"11\",\"type\":\"Label\",\"value\":\"Da Cliente:\",\"w\":\"61\",\"x\":\"104\",\"y\":\"121\",\"zone\":\"pag1_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_RAGSOC1\",\"page\":\"1\",\"spuid\":\"VXJAZUGUIO_DIV\",\"tabindex\":\"13\",\"type\":\"Label\",\"value\":\"w_RAGSOC1\",\"w\":\"408\",\"x\":\"288\",\"y\":\"121\",\"zone\":\"pag1_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"A_Cliente_\",\"page\":\"1\",\"spuid\":\"JGQCNSZOCQ_DIV\",\"tabindex\":\"14\",\"type\":\"Label\",\"value\":\"A Cliente:\",\"w\":\"61\",\"x\":\"104\",\"y\":\"149\",\"zone\":\"pag1_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_RAGSOC2\",\"page\":\"1\",\"spuid\":\"XCBBNKIAUV_DIV\",\"tabindex\":\"15\",\"type\":\"Label\",\"value\":\"w_RAGSOC2\",\"w\":\"408\",\"x\":\"288\",\"y\":\"149\",\"zone\":\"pag1_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Da_Agenzia_Dipendenza_\",\"page\":\"1\",\"spuid\":\"ZWZOQIGZCX_DIV\",\"tabindex\":\"19\",\"type\":\"Label\",\"value\":\"Da Agenzia\\/Dipendenza:\",\"w\":\"157\",\"x\":\"8\",\"y\":\"40\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_DESCRIZ1\",\"page\":\"1\",\"spuid\":\"RXKVDVJPTZ_DIV\",\"tabindex\":\"20\",\"type\":\"Label\",\"value\":\"w_DESCRIZ1\",\"w\":\"432\",\"x\":\"264\",\"y\":\"40\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Ad_Agenzia_Dipendenza_\",\"page\":\"1\",\"spuid\":\"BGOVXFIBXQ_DIV\",\"tabindex\":\"21\",\"type\":\"Label\",\"value\":\"Ad Agenzia\\/Dipendenza:\",\"w\":\"149\",\"x\":\"16\",\"y\":\"68\",\"zone\":\"pag1_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_DESCRIZ2\",\"page\":\"1\",\"spuid\":\"LNFAXDLCMF_DIV\",\"tabindex\":\"22\",\"type\":\"Label\",\"value\":\"w_DESCRIZ2\",\"w\":\"432\",\"x\":\"264\",\"y\":\"68\",\"zone\":\"pag1_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"84\",\"name\":\"Portlet_DYMVKIQWCA\",\"page\":\"1\",\"src\":\"\\/jsp\\/showmsg_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____DYMVKIQWCA\",\"type\":\"Portlet\",\"w\":\"760\",\"x\":\"16\",\"y\":\"324\",\"zone\":\"pag1_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"147\",\"name\":\"Portlet_KQMKKBMXYE\",\"page\":\"1\",\"src\":\"\\/jsp\\/showlog_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____KQMKKBMXYE\",\"type\":\"Portlet\",\"w\":\"760\",\"x\":\"16\",\"y\":\"171\",\"zone\":\"pag1_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"14\",\"href\":\" \",\"name\":\"__iframe_width__655__height__170__id__elaborazione___name__elaborazione__frameborder__1___border__1__align__TOP__marginwidth__1__marginheight__1____iframe__\",\"page\":\"1\",\"spuid\":\"FGMOCXNBFY_DIV\",\"tabindex\":\"28\",\"type\":\"Label\",\"value\":\"\\\"<iframe width="+"'"+"655"+"'"+" height="+"'"+"170"+"'"+" id="+"'"+"elaborazione"+"'"+"  name="+"'"+"elaborazione"+"'"+" frameborder="+"'"+"1"+"'"+"  border="+"'"+"1"+"'"+" align="+"'"+"TOP"+"'"+" marginwidth="+"'"+"1"+"'"+" marginheight="+"'"+"1"+"'"+"><\\/iframe>\\\"\",\"w\":\"88\",\"x\":\"616\",\"y\":\"423\",\"zone\":\"\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Tipologia PDF\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"tipopdf\",\"page\":\"1\",\"spuid\":\"IDBBKLYUJD\",\"tabindex\":\"29\",\"textlist\":\"PDF Standard,PDF per Conservazione\",\"type\":\"Combobox\",\"valuelist\":\""+"'"+"PDF"+"'"+","+"'"+"PDFA1B"+"'"+"\",\"w\":\"188\",\"x\":\"168\",\"y\":\"9\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Tipologia_PDF_\",\"page\":\"1\",\"spuid\":\"JKOUFWCMIT_DIV\",\"tabindex\":\"30\",\"type\":\"Label\",\"value\":\"Tipologia PDF:\",\"w\":\"109\",\"x\":\"56\",\"y\":\"13\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"33\",\"href\":\"javascript:href_HLPOJCMBVW()\",\"name\":\"images_print_gif\",\"page\":\"1\",\"spuid\":\"HLPOJCMBVW\",\"src\":\"images\\/print.gif\",\"tabindex\":\"31\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"480\",\"y\":\"414\",\"zone\":\"pag1_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void Next(ServletStatus status,arpg_stp_stdtec_frz_newBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_stp_stdtec_frz_newBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_stp_stdtec_frz_newBO BO,ServletStatus status) {
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
     "<script src='arpg_stp_stdtec_frz_new?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
     "<script src='SPPrxy/"+m_cEntityUid+"/arpg_stp_stdtec_frz_new_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(453,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
  void RaiseLoadedEntity(arpg_stp_stdtec_frz_newBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_stp_stdtec_frz_newBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(arpg_stp_stdtec_frz_newBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(arpg_stp_stdtec_frz_newBO BO,ServletStatus status) {
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
  void WriteExitPage(arpg_stp_stdtec_frz_newBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(arpg_stp_stdtec_frz_newBO BO,ServletStatus status) {
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
      arrt_stp_stdtec_new.GetCallableNames(callable);
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,arpg_stp_stdtec_frz_newBO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,arpg_stp_stdtec_frz_newBO BO) {
    boolean result = true;
    return result;
  }
}
