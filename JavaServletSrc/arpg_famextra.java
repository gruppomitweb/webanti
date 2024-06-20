import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_famextra extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*HPHIQHJDTC*!";
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
    arpg_famextraBO BO;
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
    return "Invii Speciali";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_famextra";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 798;
    l_eg.m_nEntityHeight = 551;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"aesaldi"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.items = new SPItem[]{
                   new SPItem("gIntemediario","C",11,0, "hide","Intermediario"),
                   new SPItem("gDescAzi","C",70,0, "hide","Descrizione Intermediario"),
                   new SPItem("tipo","C",1,0, "edit",""),
                   new SPItem("daData","D",8,0, "show",""),
                   new SPItem("a_Data","D",8,0, "edit",""),
                   new SPItem("protfile","C",24,0, "edit","Protocollo"),
                   new SPItem("flgstp","C",1,0, "edit",""),
                   new SPItem("flganni","C",1,0, "edit",""),
                   new SPItem("oldinter","C",16,0, "edit","Vecchio Intermediario")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,arpg_famextraBO BO) {
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
    l_translations=new String[][]{{"10061897561",p_Context.Translate("Stampa contenuto dei file creati")},
    {"10457981292",p_Context.Translate("Descrizione Intermediario")},
    {"10759313073",p_Context.Translate("File Inviati")},
    {"11396780126",p_Context.Translate("Intermediario")},
    {"12020117348",p_Context.Translate("Suddividi il reimpianto in file specifici per ogni anno")},
    {"12090677005",p_Context.Translate("Visualizza file creati")},
    {"1312852873",p_Context.Translate("Confermi la creazione del file ?")},
    {"1551011006",p_Context.Translate("Invii Speciali")},
    {"1578816129",p_Context.Translate("Non creare i file per le stampe (Per grossi volumi di dati - IP)")},
    {"582839624",p_Context.Translate("Vecchio Intermediario")},
    {"900120012",p_Context.Translate("Protocollo")}};
    return l_translations;
  }
  void WriteStyles(arpg_famextraBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/arpg_famextra.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(arpg_famextraBO BO,ServletStatus status) {
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
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_DYMVKIQWCA_Vars(arpg_famextraBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  // GetPortlet_Log_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_KQMKKBMXYE_Vars(arpg_famextraBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  void WriteControls(arpg_famextraBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(arpg_famextraBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(546);
    WriteControls_1_h_0(BO,status);
  }
  void WriteControls_1_h_0(arpg_famextraBO BO,ServletStatus status) {
    status.out.println(
     "<div id='TTRVXROIVP_DIV' class='UntitledBox'>" +
     "<div id='TTRVXROIVP' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DMMJSVFBEV_DIV'>" +
     "<label id='DMMJSVFBEV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("CREAZIONE INVII SPECIALI"))+"" +
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
     "<span class='SPLabel' id='TYIWXFLLFY_DIV'>" +
     "<label id='TYIWXFLLFY'>" +
     ""+SPLib.ToHTMLRepresentation("<iframe width='750' height='400' id='elaborazione'  name='elaborazione' frameborder='1'  border='1' align='TOP' marginwidth='1' marginheight='1'></iframe>")+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_MPCMAMHQST()' tabindex='-1' id='MPCMAMHQST_HREF'>" +
     "<img id='MPCMAMHQST' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/print.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Stampa contenuto dei file creati"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Stampa contenuto dei file creati"),"C",0,0)+">" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_JBNBDKBIAJ()' tabindex='-1' id='JBNBDKBIAJ_HREF'>" +
     "<img id='JBNBDKBIAJ' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/search.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Visualizza file creati"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Visualizza file creati"),"C",0,0)+">" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<div id='TFMYEDBUXJ_DIV'>" +
     "<div id='TFMYEDBUXJ_0_container'>" +
     "<input id='TFMYEDBUXJ_0' name='TFMYEDBUXJ' type='radio' value="+SPLib.ToHTMLValue("R","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("R",CPLib.Trim(BO.w_tipo))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='TFMYEDBUXJ_0'>"+status.context.Translate("Reimpianto")+"</label>" +
     "</div>" +
     "<div id='TFMYEDBUXJ_1_container'>" +
     "<input id='TFMYEDBUXJ_1' name='TFMYEDBUXJ' type='radio' value="+SPLib.ToHTMLValue("C","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("C",CPLib.Trim(BO.w_tipo))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='TFMYEDBUXJ_1'>"+status.context.Translate("Cambio Identificativo")+"</label>" +
     "</div>" +
     "<div id='TFMYEDBUXJ_2_container'>" +
     "<input id='TFMYEDBUXJ_2' name='TFMYEDBUXJ' type='radio' value="+SPLib.ToHTMLValue("P","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("P",CPLib.Trim(BO.w_tipo))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='TFMYEDBUXJ_2'>"+status.context.Translate("Presa in carico rapporti")+"</label>" +
     "</div>" +
     "<div id='TFMYEDBUXJ_3_container'>" +
     "<input id='TFMYEDBUXJ_3' name='TFMYEDBUXJ' type='radio' value="+SPLib.ToHTMLValue("A","C",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("A",CPLib.Trim(BO.w_tipo))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='TFMYEDBUXJ_3'>"+status.context.Translate("Annullamento file")+"</label>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<input name='daData' id='NQCHGQZSVT' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_daData,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress='' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='GQEBBQASYL_DIV' style='display:none'>" +
     "<label id='GQEBBQASYL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Dal:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='a_Data' id='PZFGEEQVPK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_a_Data,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress='' style='display:none'>" +
     "<button id='PZFGEEQVPK_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='PZFGEEQVPK_ZOOM_Click()' style='display:none'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='AHDJAVIZRK_DIV' style='display:none'>" +
     "<label id='AHDJAVIZRK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Al:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='protfile' id='LYJDXZJFGW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_protfile,"C",24,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='24' size='24' fieldtype='C' style='display:none'>" +
     "<button id='LYJDXZJFGW_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='LYJDXZJFGW_ZOOM_Click()' style='display:none'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CYUWCGZNEA_DIV' style='display:none'>" +
     "<label id='CYUWCGZNEA' for='LYJDXZJFGW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Protocollo:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='AOHGKXZIJG_DIV'>" +
     "<input name='flgstp' id='AOHGKXZIJG' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_flgstp,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_flgstp))?"CHECKED":"")+">" +
     "<label id='AOHGKXZIJG_LBL' for='AOHGKXZIJG' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Non creare i file per le stampe (Per grossi volumi di dati - IP)"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='ILJJUNMQGU_DIV' style='display:none'>" +
     "<input name='flganni' id='ILJJUNMQGU' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_flganni,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_flganni))?"CHECKED":"")+">" +
     "<label id='ILJJUNMQGU_LBL' for='ILJJUNMQGU' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Suddividi il reimpianto in file specifici per ogni anno"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='oldinter' id='MHITXDESMW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_oldinter,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JQZIUZNQCK_DIV' style='display:none'>" +
     "<label id='JQZIUZNQCK' for='MHITXDESMW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Vecchio Intermediario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.themeWriter.Header_EndHtml();
  }
  static void PrintState(arpg_famextraBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_famextraBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_famextraBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_gIntemediario,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gDescAzi,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipo,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_daData,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_a_Data,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_protfile,"C",24,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgstp,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flganni,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oldinter,"C",16,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_famextraBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_TYIWXFLLFY = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(551,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(798,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_famextra"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    status.out.print("'LYJDXZJFGW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("PROTOCOLLOPROTOCOLLOCaesaldi",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,aesaldi,"+"default",l_session)+"'"+"]");
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
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_famextra","");
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
  void WriteMainFormScript(arpg_famextraBO BO,ServletStatus status) {
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
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  arpg_famextraBO getBO(ServletStatus status) {
    arpg_famextraBO BO = new arpg_famextraBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_famextraBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_famextraBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_famextraBO BO) {
    BO.SetFromContext(status.m_cWv);
    BO.Calculate();
  }
  void Save(ServletStatus status,arpg_famextraBO BO) {
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
  void Discard(ServletStatus status,arpg_famextraBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,arpg_famextraBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",551);
    item.put("w",798);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","arpg_famextra");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"546\",\"name\":\"Box_TTRVXROIVP\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"TTRVXROIVP\",\"tabindex\":\"1\",\"type\":\"Box\",\"w\":\"784\",\"x\":\"0\",\"y\":\"0\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\"#0000FF\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"CREAZIONE_INVII_SPECIALI\",\"page\":\"1\",\"spuid\":\"DMMJSVFBEV_DIV\",\"tabindex\":\"2\",\"type\":\"Label\",\"value\":\"CREAZIONE INVII SPECIALI\",\"w\":\"784\",\"x\":\"0\",\"y\":\"0\",\"zone\":\"TTRVXROIVP_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"56\",\"href\":\"javascript:ALQVOOWZEV_Click()\",\"name\":\"Crea_Comunicazione\",\"page\":\"1\",\"spuid\":\"ALQVOOWZEV\",\"tabindex\":\"3\",\"type\":\"Button\",\"value\":\"Crea Comunicazione\",\"w\":\"264\",\"x\":\"511\",\"y\":\"20\",\"zone\":\"TTRVXROIVP_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"28\",\"href\":\"javascript:href_AJXISNWTIP()\",\"name\":\"images_exit_gif\",\"page\":\"1\",\"spuid\":\"AJXISNWTIP\",\"src\":\"images\\/exit.gif\",\"tabindex\":\"4\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"735\",\"y\":\"90\",\"zone\":\"TTRVXROIVP_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"84\",\"name\":\"Portlet_DYMVKIQWCA\",\"page\":\"1\",\"src\":\"\\/jsp\\/showmsg_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____DYMVKIQWCA\",\"type\":\"Portlet\",\"w\":\"776\",\"x\":\"3\",\"y\":\"281\",\"zone\":\"TTRVXROIVP_10\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"147\",\"name\":\"Portlet_KQMKKBMXYE\",\"page\":\"1\",\"src\":\"\\/jsp\\/showlog_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____KQMKKBMXYE\",\"type\":\"Portlet\",\"w\":\"776\",\"x\":\"3\",\"y\":\"129\",\"zone\":\"TTRVXROIVP_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"153\",\"href\":\" \",\"name\":\"__iframe_width__750__height__400__id__elaborazione___name__elaborazione__frameborder__1___border__1__align__TOP__marginwidth__1__marginheight__1____iframe__\",\"page\":\"1\",\"spuid\":\"TYIWXFLLFY_DIV\",\"tabindex\":\"9\",\"type\":\"Label\",\"value\":\"\\\"<iframe width="+"'"+"750"+"'"+" height="+"'"+"400"+"'"+" id="+"'"+"elaborazione"+"'"+"  name="+"'"+"elaborazione"+"'"+" frameborder="+"'"+"1"+"'"+"  border="+"'"+"1"+"'"+" align="+"'"+"TOP"+"'"+" marginwidth="+"'"+"1"+"'"+" marginheight="+"'"+"1"+"'"+"><\\/iframe>\\\"\",\"w\":\"776\",\"x\":\"3\",\"y\":\"372\",\"zone\":\"TTRVXROIVP_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Stampa contenuto dei file creati\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"28\",\"href\":\"javascript:href_MPCMAMHQST()\",\"name\":\"images_print_gif\",\"page\":\"1\",\"spuid\":\"MPCMAMHQST\",\"src\":\"images\\/print.gif\",\"tabindex\":\"10\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"639\",\"y\":\"90\",\"zone\":\"TTRVXROIVP_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Visualizza file creati\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"28\",\"href\":\"javascript:href_JBNBDKBIAJ()\",\"name\":\"images_search_gif\",\"page\":\"1\",\"spuid\":\"JBNBDKBIAJ\",\"src\":\"images\\/search.gif\",\"tabindex\":\"11\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"687\",\"y\":\"90\",\"zone\":\"TTRVXROIVP_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"79\",\"name\":\"tipo\",\"orientation\":\"vertical\",\"page\":\"1\",\"spuid\":\"TFMYEDBUXJ\",\"tabindex\":\"13\",\"textlist\":\"Reimpianto,Cambio Identificativo,Presa in carico rapporti,Annullamento file\",\"type\":\"Radio\",\"valuelist\":\""+"'"+"R"+"'"+","+"'"+"C"+"'"+","+"'"+"P"+"'"+","+"'"+"A"+"'"+"\",\"w\":\"150\",\"x\":\"15\",\"y\":\"27\",\"zone\":\"TTRVXROIVP_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"daData\",\"page\":\"1\",\"spuid\":\"NQCHGQZSVT\",\"type\":\"Textbox\",\"w\":\"72\",\"x\":\"279\",\"y\":\"27\",\"zone\":\"TTRVXROIVP_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Dal_\",\"page\":\"1\",\"spuid\":\"GQEBBQASYL_DIV\",\"tabindex\":\"15\",\"type\":\"Label\",\"value\":\"Dal:\",\"w\":\"28\",\"x\":\"247\",\"y\":\"32\",\"zone\":\"TTRVXROIVP_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"a_Data\",\"page\":\"1\",\"spuid\":\"PZFGEEQVPK\",\"tabindex\":\"16\",\"type\":\"Textbox\",\"w\":\"72\",\"x\":\"407\",\"y\":\"27\",\"zone\":\"TTRVXROIVP_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Al_\",\"page\":\"1\",\"spuid\":\"AHDJAVIZRK_DIV\",\"tabindex\":\"17\",\"type\":\"Label\",\"value\":\"Al:\",\"w\":\"28\",\"x\":\"375\",\"y\":\"33\",\"zone\":\"TTRVXROIVP_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Protocollo\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"24\",\"name\":\"protfile\",\"page\":\"1\",\"spuid\":\"LYJDXZJFGW\",\"tabindex\":\"18\",\"type\":\"Textbox\",\"w\":\"200\",\"x\":\"279\",\"y\":\"50\",\"zone\":\"TTRVXROIVP_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Protocollo_\",\"page\":\"1\",\"spuid\":\"CYUWCGZNEA_DIV\",\"tabindex\":\"19\",\"type\":\"Label\",\"value\":\"Protocollo:\",\"w\":\"56\",\"x\":\"223\",\"y\":\"54\",\"zone\":\"TTRVXROIVP_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"flgstp\",\"page\":\"1\",\"spuid\":\"AOHGKXZIJG\",\"tabindex\":\"20\",\"type\":\"Checkbox\",\"w\":\"408\",\"x\":\"16\",\"y\":\"105\",\"zone\":\"TTRVXROIVP_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"flganni\",\"page\":\"1\",\"spuid\":\"ILJJUNMQGU\",\"tabindex\":\"21\",\"type\":\"Checkbox\",\"w\":\"288\",\"x\":\"344\",\"y\":\"105\",\"zone\":\"TTRVXROIVP_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Vecchio Intermediario\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"16\",\"name\":\"oldinter\",\"page\":\"1\",\"spuid\":\"MHITXDESMW\",\"tabindex\":\"22\",\"type\":\"Textbox\",\"w\":\"108\",\"x\":\"280\",\"y\":\"72\",\"zone\":\"TTRVXROIVP_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Vecchio_Intermediario_\",\"page\":\"1\",\"spuid\":\"JQZIUZNQCK_DIV\",\"tabindex\":\"23\",\"type\":\"Label\",\"value\":\"Vecchio Intermediario:\",\"w\":\"117\",\"x\":\"163\",\"y\":\"76\",\"zone\":\"TTRVXROIVP_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void Next(ServletStatus status,arpg_famextraBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_famextraBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_famextraBO BO,ServletStatus status) {
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
     "<script src='arpg_famextra?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
     "<script src='SPPrxy/"+m_cEntityUid+"/arpg_famextra_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(551,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
  void RaiseLoadedEntity(arpg_famextraBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_famextraBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(arpg_famextraBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(arpg_famextraBO BO,ServletStatus status) {
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
  void WriteExitPage(arpg_famextraBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(arpg_famextraBO BO,ServletStatus status) {
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
      arrt_famextra.GetCallableNames(callable);
      arrt_famextra_stp.GetCallableNames(callable);
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,arpg_famextraBO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,arpg_famextraBO BO) {
    boolean result = true;
    return result;
  }
}
