import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_check_opex extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*VQPNWHXQBP*!";
  static public class ServletStatus extends SPPageServletStatus {
    public void MergeCallerVars(SPParameterSource source) {
      source.SetParameter("DaDatOpe",source.GetCaller().GetDate("DaDatOpe","D",8,0));
      source.SetParameter("ADatOpe",source.GetCaller().GetDate("ADatOpe","D",8,0));
      source.SetParameter("cdadata",source.GetCaller().GetString("cdadata","C",8,0));
      source.SetParameter("c_adata",source.GetCaller().GetString("c_adata","C",8,0));
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
    arpg_check_opexBO BO;
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
    return "Verifica Soggetti Con Operazioni ma senza ExtraConto";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_check_opex";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 789;
    l_eg.m_nEntityHeight = 646;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page"),new ZoneItem("FB","Filtri Base","collapsible")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.items = new SPItem[]{
                   new SPItem("anno","N",4,0, "edit",""),
                   new SPItem("mese","C",2,0, "edit",""),
                   new SPItem("DaDatOpe","D",8,0, "edit",""),
                   new SPItem("ADatOpe","D",8,0, "edit",""),
                   new SPItem("cdadata","C",8,0, "hide",""),
                   new SPItem("c_adata","C",8,0, "hide","")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,arpg_check_opexBO BO) {
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
    l_translations=new String[][]{{"10557974447",p_Context.Translate("La data di fine periodo non deve essere minore di quella di inizio periodo!")},
    {"11640985187",p_Context.Translate("Genera le operazioni extraconto a partire da AUI")},
    {"1966663129",p_Context.Translate("L'utilizzo di questa maschera consente date dal 2007 (Mese di maggio) in avanti")},
    {"955893124",p_Context.Translate("Verifica Soggetti Con Operazioni ma senza ExtraConto")}};
    return l_translations;
  }
  void WriteStyles(arpg_check_opexBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/arpg_check_opex.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(arpg_check_opexBO BO,ServletStatus status) {
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
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_DYMVKIQWCA_Vars(arpg_check_opexBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  // GetPortlet_Log_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_KQMKKBMXYE_Vars(arpg_check_opexBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  void WriteControls(arpg_check_opexBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(arpg_check_opexBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(-1);
    status.out.println(
     "<div id='XLVFHSOSYH_DIV' class='BoxContainer'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='XLVFHSOSYH_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='XLVFHSOSYH_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Filtri Base")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='XLVFHSOSYH_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"XLVFHSOSYH\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=XLVFHSOSYH_HEADER&m_cBoxId=XLVFHSOSYH&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Filtri Base"))+"");
    }
    status.out.println(
     "<div id='XLVFHSOSYH' style='position:relative;height:621px;display:block;overflow:hidden'>" +
    "");
    WriteControls_1_b1_h_0(BO,status);
  }
  void WriteControls_1_b1_h_0(arpg_check_opexBO BO,ServletStatus status) {
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='anno' id='GTMJENMCMN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_anno,"N",4,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='4' fieldtype='N' onkeypress=''>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='mese' id='TCZMCNHUFI' class='Combobox' tabindex='-1' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("01","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("01",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Gennaio")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("02","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("02",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Febbraio")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("03","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("03",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Marzo")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("04","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("04",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Aprile")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("05","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("05",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Maggio")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("06","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("06",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Giugno")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("07","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("07",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Luglio")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("08","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("08",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Agosto")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("09","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("09",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Settembre")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("10","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("10",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Ottobre")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("11","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("11",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Novembre")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("12","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("12",CPLib.Trim(BO.w_mese))?"SELECTED":"")+">" +
     ""+status.context.Translate("Dicembre")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('TCZMCNHUFI'),w_mese,'C');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DaDatOpe' id='DPKVLWHCIG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DaDatOpe,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='DPKVLWHCIG_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='DPKVLWHCIG_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='ADatOpe' id='MTJDZQTEIR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ADatOpe,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='MTJDZQTEIR_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='MTJDZQTEIR_ZOOM_Click()'>" +
     "</button>" +
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
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_PTXYMSWBZO()' tabindex='-1' id='PTXYMSWBZO_HREF'>" +
     "<img id='PTXYMSWBZO' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/exit.gif"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt=''>" +
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
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_RXPIEFSABT()' tabindex='-1' id='RXPIEFSABT_HREF'>" +
     "<img id='RXPIEFSABT' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/print.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Genera le operazioni extraconto a partire da AUI"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Genera le operazioni extraconto a partire da AUI"),"C",0,0)+">" +
     "</a>" +
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
     "<span class='SPLabel' id='YIXZTOKOBR_DIV'>" +
     "<label id='YIXZTOKOBR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Anno:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TTKGEZTDBH_DIV'>" +
     "<label id='TTKGEZTDBH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Mese:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TYIWXFLLFY_DIV'>" +
     "<label id='TYIWXFLLFY'>" +
     ""+SPLib.ToHTMLRepresentation("<iframe width='750' height='400' id='elaborazione'  name='elaborazione' frameborder='1'  border='1' align='TOP' marginwidth='1' marginheight='1'></iframe>")+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script type='text/javascript'>" +
    "");
    status.out.println("Ctrl('XLVFHSOSYH').setAttribute('band_height',621);");
    status.out.println("Ctrl('XLVFHSOSYH').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='band_1_621' style='position:relative;height:0px;display:block;overflow:hidden'>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.themeWriter.Header_EndHtml();
  }
  static void PrintState(arpg_check_opexBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_check_opexBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_check_opexBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print("["+SPLib.ToJSValue(BO.w_anno,"N",4,0)+","+SPLib.ToJSValue(BO.o_anno,"N",4,0)+"]");
    status.out.print(","+"["+SPLib.ToJSValue(BO.w_mese,"C",2,0)+","+SPLib.ToJSValue(BO.o_mese,"C",2,0)+"]");
    status.out.print(","+SPLib.ToJSValue(BO.w_DaDatOpe,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ADatOpe,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_cdadata,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_c_adata,"C",8,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_check_opexBO BO,ServletStatus status) {
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(646,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(789,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_check_opex"),"C",0,0)+ ";");
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
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_check_opex","");
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
  void WriteMainFormScript(arpg_check_opexBO BO,ServletStatus status) {
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
  arpg_check_opexBO getBO(ServletStatus status) {
    arpg_check_opexBO BO = new arpg_check_opexBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_check_opexBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_check_opexBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_check_opexBO BO) {
    BO.SetFromContext(status.m_cWv);
    BO.Calculate();
  }
  void Save(ServletStatus status,arpg_check_opexBO BO) {
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
  void Discard(ServletStatus status,arpg_check_opexBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,arpg_check_opexBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",626);
    item.put("w",789);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","arpg_check_opex");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"5\",\"name\":\"anno\",\"page\":\"1\",\"spuid\":\"GTMJENMCMN\",\"tabindex\":\"2\",\"type\":\"Textbox\",\"w\":\"48\",\"x\":\"56\",\"y\":\"27\",\"zone\":\"XLVFHSOSYH_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"mese\",\"page\":\"1\",\"spuid\":\"TCZMCNHUFI\",\"tabindex\":\"3\",\"textlist\":\"Gennaio,Febbraio,Marzo,Aprile,Maggio,Giugno,Luglio,Agosto,Settembre,Ottobre,Novembre,Dicembre\",\"type\":\"Combobox\",\"valuelist\":\""+"'"+"01"+"'"+","+"'"+"02"+"'"+","+"'"+"03"+"'"+","+"'"+"04"+"'"+","+"'"+"05"+"'"+","+"'"+"06"+"'"+","+"'"+"07"+"'"+","+"'"+"08"+"'"+","+"'"+"09"+"'"+","+"'"+"10"+"'"+","+"'"+"11"+"'"+","+"'"+"12"+"'"+"\",\"w\":\"152\",\"x\":\"144\",\"y\":\"27\",\"zone\":\"XLVFHSOSYH_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"DaDatOpe\",\"page\":\"1\",\"spuid\":\"DPKVLWHCIG\",\"tabindex\":\"4\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"440\",\"y\":\"9\",\"zone\":\"XLVFHSOSYH_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"ADatOpe\",\"page\":\"1\",\"spuid\":\"MTJDZQTEIR\",\"tabindex\":\"5\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"440\",\"y\":\"45\",\"zone\":\"XLVFHSOSYH_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Da_Data_Operazione_\",\"page\":\"1\",\"spuid\":\"HPGJXQIVYG_DIV\",\"tabindex\":\"6\",\"type\":\"Label\",\"value\":\"Da Data Operazione:\",\"w\":\"132\",\"x\":\"304\",\"y\":\"13\",\"zone\":\"XLVFHSOSYH_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"A_Data_Operazione_\",\"page\":\"1\",\"spuid\":\"BGHAITOPMU_DIV\",\"tabindex\":\"7\",\"type\":\"Label\",\"value\":\"A Data Operazione:\",\"w\":\"132\",\"x\":\"304\",\"y\":\"49\",\"zone\":\"XLVFHSOSYH_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"32\",\"href\":\"javascript:href_PTXYMSWBZO()\",\"name\":\"images_exit_gif\",\"page\":\"1\",\"spuid\":\"PTXYMSWBZO\",\"src\":\"images\\/exit.gif\",\"tabindex\":\"8\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"736\",\"y\":\"23\",\"zone\":\"XLVFHSOSYH_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"84\",\"name\":\"Portlet_DYMVKIQWCA\",\"page\":\"1\",\"src\":\"\\/jsp\\/showmsg_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____DYMVKIQWCA\",\"type\":\"Portlet\",\"w\":\"768\",\"x\":\"8\",\"y\":\"234\",\"zone\":\"XLVFHSOSYH_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Genera le operazioni extraconto a partire da AUI\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"32\",\"href\":\"javascript:href_RXPIEFSABT()\",\"name\":\"images_print_gif\",\"page\":\"1\",\"spuid\":\"RXPIEFSABT\",\"src\":\"images\\/print.gif\",\"tabindex\":\"12\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"688\",\"y\":\"23\",\"zone\":\"XLVFHSOSYH_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"147\",\"name\":\"Portlet_KQMKKBMXYE\",\"page\":\"1\",\"src\":\"\\/jsp\\/showlog_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____KQMKKBMXYE\",\"type\":\"Portlet\",\"w\":\"768\",\"x\":\"8\",\"y\":\"81\",\"zone\":\"XLVFHSOSYH_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Anno_\",\"page\":\"1\",\"spuid\":\"YIXZTOKOBR_DIV\",\"tabindex\":\"14\",\"type\":\"Label\",\"value\":\"Anno:\",\"w\":\"29\",\"x\":\"23\",\"y\":\"31\",\"zone\":\"XLVFHSOSYH_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Mese_\",\"page\":\"1\",\"spuid\":\"TTKGEZTDBH_DIV\",\"tabindex\":\"15\",\"type\":\"Label\",\"value\":\"Mese:\",\"w\":\"29\",\"x\":\"111\",\"y\":\"31\",\"zone\":\"XLVFHSOSYH_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"294\",\"href\":\" \",\"name\":\"__iframe_width__750__height__400__id__elaborazione___name__elaborazione__frameborder__1___border__1__align__TOP__marginwidth__1__marginheight__1____iframe__\",\"page\":\"1\",\"spuid\":\"TYIWXFLLFY_DIV\",\"tabindex\":\"16\",\"type\":\"Label\",\"value\":\"\\\"<iframe width="+"'"+"750"+"'"+" height="+"'"+"400"+"'"+" id="+"'"+"elaborazione"+"'"+"  name="+"'"+"elaborazione"+"'"+" frameborder="+"'"+"1"+"'"+"  border="+"'"+"1"+"'"+" align="+"'"+"TOP"+"'"+" marginwidth="+"'"+"1"+"'"+" marginheight="+"'"+"1"+"'"+"><\\/iframe>\\\"\",\"w\":\"768\",\"x\":\"8\",\"y\":\"321\",\"zone\":\"XLVFHSOSYH_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void Next(ServletStatus status,arpg_check_opexBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_check_opexBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_check_opexBO BO,ServletStatus status) {
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
     "<script src='arpg_check_opex?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
     "<script src='SPPrxy/"+m_cEntityUid+"/arpg_check_opex_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(646,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
  void RaiseLoadedEntity(arpg_check_opexBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_check_opexBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(arpg_check_opexBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(arpg_check_opexBO BO,ServletStatus status) {
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
  void WriteExitPage(arpg_check_opexBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(arpg_check_opexBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  void IncludeJS(ServletStatus status) {
    String l_cJsUid;
    status.out.println(
     "<script src='SPPrxy/"+arfn_finemese.m_cEntityUid+"/arfn_finemese.js'>" +
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
      arfn_finemese.GetCallableNames(callable);
      arrt_check_opex.GetCallableNames(callable);
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,arpg_check_opexBO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,arpg_check_opexBO BO) {
    boolean result = true;
    return result;
  }
}
