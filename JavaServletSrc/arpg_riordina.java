import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_riordina extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*RSYRLVHEWA*!";
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
    arpg_riordinaBO BO;
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
    return "Riorganizzazione Indici";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_riordina";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 789;
    l_eg.m_nEntityHeight = 284;
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
                   new SPItem("rapuif","C",1,0, "edit",""),
                   new SPItem("opeuif","C",1,0, "edit",""),
                   new SPItem("frzuif","C",1,0, "edit",""),
                   new SPItem("rapage","C",1,0, "edit",""),
                   new SPItem("opeage","C",1,0, "edit",""),
                   new SPItem("gTelepass","C",1,0, "hide","Versione Telepass"),
                   new SPItem("titaui","C",1,0, "edit",""),
                   new SPItem("gFlgWU","C",1,0, "hide","Gestione WU"),
                   new SPItem("flgpart","C",1,0, "edit",""),
                   new SPItem("prgidb","N",10,0, "edit","Prog. IDBASE"),
                   new SPItem("prgnprg","N",10,0, "edit","Prog. IDBASE"),
                   new SPItem("prgiope","N",10,0, "edit","Prog. IDBASE"),
                   new SPItem("daData","D",8,0, "edit","Da Data Registrazione"),
                   new SPItem("dataover","C",1,0, "edit","date oltre il limite"),
                   new SPItem("ngiorni","N",2,0, "edit","Numero di giorni")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,arpg_riordinaBO BO) {
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
    l_translations=new String[][]{{"10221529600",p_Context.Translate("Da Data Registrazione")},
    {"10911852273",p_Context.Translate("Impostare il ritardo della registrazione")},
    {"10983493593",p_Context.Translate("Gestione WU")},
    {"11315943373",p_Context.Translate("date oltre il limite")},
    {"11315943405",p_Context.Translate("Date oltre il limite")},
    {"11959162430",p_Context.Translate("Prog. IDBASE")},
    {"11974845654",p_Context.Translate("Frazionate AUI")},
    {"143152148",p_Context.Translate("Titolari AUI")},
    {"1573704569",p_Context.Translate("Versione Telepass")},
    {"1705231181",p_Context.Translate("Operazioni AGE")},
    {"1710342989",p_Context.Translate("Operazioni AUI")},
    {"1828634119",p_Context.Translate("Numero di giorni")},
    {"194711954",p_Context.Translate("Rapporti AGE")},
    {"194731922",p_Context.Translate("Rapporti AUI")},
    {"854143230",p_Context.Translate("Ricostruzione Parziale")},
    {"919240835",p_Context.Translate("Il valore non pò superare il limite dei 30 giorni o essere inferiore a 0")},
    {"964645292",p_Context.Translate("Riorganizzazione Indici")}};
    return l_translations;
  }
  void WriteStyles(arpg_riordinaBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/arpg_riordina.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(arpg_riordinaBO BO,ServletStatus status) {
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
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_DYMVKIQWCA_Vars(arpg_riordinaBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  void WriteControls(arpg_riordinaBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(arpg_riordinaBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(279);
    WriteControls_1_h_0(BO,status);
  }
  void WriteControls_1_h_0(arpg_riordinaBO BO,ServletStatus status) {
    status.out.println(
     "<div id='IDIZVJSJFR_DIV' class='UntitledBox'>" +
     "<div id='IDIZVJSJFR' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_ROZQLWLMOH()' tabindex='-1' id='ROZQLWLMOH_HREF'>" +
     "<img id='ROZQLWLMOH' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/elaborazione.gif"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt=''>" +
     "</a>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FGMOCXNBFY_DIV' style='display:none'>" +
     "<label id='FGMOCXNBFY'>" +
     ""+SPLib.ToHTMLRepresentation("<iframe width='460' height='80' id ='elaborazione' name ='elaborazione' frameborder='0'  border='0' align='TOP' marginwidth='0' marginheight='0'></iframe>")+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TSMFJKNNPI_DIV'>" +
     "<label id='TSMFJKNNPI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("ARCHIVI DA RIORDINARE"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='RWYSXVADUD_DIV'>" +
     "<input name='rapuif' id='RWYSXVADUD' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_rapuif,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_rapuif))?"CHECKED":"")+">" +
     "<label id='RWYSXVADUD_LBL' for='RWYSXVADUD' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Rapporti AUI"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='CENYIVTJCD_DIV'>" +
     "<input name='opeuif' id='CENYIVTJCD' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_opeuif,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_opeuif))?"CHECKED":"")+">" +
     "<label id='CENYIVTJCD_LBL' for='CENYIVTJCD' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Operazioni AUI"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='CPLLFIWSVW_DIV'>" +
     "<input name='frzuif' id='CPLLFIWSVW' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_frzuif,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_frzuif))?"CHECKED":"")+">" +
     "<label id='CPLLFIWSVW_LBL' for='CPLLFIWSVW' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Frazionate AUI"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='JALETSSOWI_DIV'>" +
     "<input name='rapage' id='JALETSSOWI' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_rapage,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_rapage))?"CHECKED":"")+">" +
     "<label id='JALETSSOWI_LBL' for='JALETSSOWI' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Rapporti AGE"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='YSMCMCPCUY_DIV'>" +
     "<input name='opeage' id='YSMCMCPCUY' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_opeage,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_opeage))?"CHECKED":"")+">" +
     "<label id='YSMCMCPCUY_LBL' for='YSMCMCPCUY' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Operazioni AGE"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='IEUGAKXYTZ_DIV'>" +
     "<input name='titaui' id='IEUGAKXYTZ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_titaui,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_titaui))?"CHECKED":"")+">" +
     "<label id='IEUGAKXYTZ_LBL' for='IEUGAKXYTZ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Titolari AUI"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='FMRRWRYWEQ_DIV' style='display:none'>" +
     "<input name='flgpart' id='FMRRWRYWEQ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_flgpart,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_flgpart))?"CHECKED":"")+">" +
     "<label id='FMRRWRYWEQ_LBL' for='FMRRWRYWEQ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Ricostruzione Parziale"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='prgidb' id='IRVRFIWCHD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_prgidb,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='11' size='10' fieldtype='N' onkeypress='' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='BQBTJCITDO_DIV' style='display:none'>" +
     "<label id='BQBTJCITDO' for='IRVRFIWCHD'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Prog. IDBASE:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='prgnprg' id='SHFWFZUZAU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_prgnprg,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='11' size='10' fieldtype='N' onkeypress='' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZUPQPKRXOU_DIV' style='display:none'>" +
     "<label id='ZUPQPKRXOU' for='SHFWFZUZAU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Prog. NUMPROG:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='prgiope' id='BBWGQILZDE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_prgiope,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='11' size='10' fieldtype='N' onkeypress='' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HEDBPKUMXR_DIV' style='display:none'>" +
     "<label id='HEDBPKUMXR' for='BBWGQILZDE'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Prog. PRGIMPOPE:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='daData' id='DGCPENGASO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_daData,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' onkeydown='ManageKeys(event,false,false,true,true)' onkeypress=''>" +
     "<button id='DGCPENGASO_ZOOM' type='button' class='CalendarButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='DGCPENGASO_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JJDJMFKGFW_DIV'>" +
     "<label id='JJDJMFKGFW' for='DGCPENGASO'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da Data Registrazione:"))+"" +
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
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='YSDLBTYKKH_DIV'>" +
     "<input name='dataover' id='YSDLBTYKKH' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_dataover,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_dataover))?"CHECKED":"")+">" +
     "<label id='YSDLBTYKKH_LBL' for='YSDLBTYKKH' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Date oltre il limite"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='ngiorni' id='BXVKMROMSG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ngiorni,"N",2,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("Impostare il ritardo della registrazione"),"C",0,0)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='2' fieldtype='N' onkeypress='' style='display:none'>" +
    "");
    status.themeWriter.Header_EndHtml();
  }
  static void PrintState(arpg_riordinaBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_riordinaBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_riordinaBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_rapuif,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_opeuif,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_frzuif,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_rapage,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_opeage,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gTelepass,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_titaui,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgWU,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_flgpart,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_prgidb,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_prgnprg,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_prgiope,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_daData,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dataover,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ngiorni,"N",2,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_riordinaBO BO,ServletStatus status) {
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(284,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_riordina"),"C",0,0)+ ";");
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
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_riordina","");
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
  void WriteMainFormScript(arpg_riordinaBO BO,ServletStatus status) {
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
    status.out.println("// * --- arpg_riordina");
    status.out.println("function Elabora() {");
    status.out.println("  w_bloccaedit = 'S';");
    status.out.println("  EnableControlsUnderCondition();");
    status.out.println("  SetLocationHref(null,'arrt_allinea_anagrafiche'+'?m_cAction=start&m_cMode=hyperlink','elaborazione')   ");
    status.out.println("}");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  arpg_riordinaBO getBO(ServletStatus status) {
    arpg_riordinaBO BO = new arpg_riordinaBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_riordinaBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_riordinaBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_riordinaBO BO) {
    BO.SetFromContext(status.m_cWv);
    BO.Calculate();
  }
  void Save(ServletStatus status,arpg_riordinaBO BO) {
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
  void Discard(ServletStatus status,arpg_riordinaBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,arpg_riordinaBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",284);
    item.put("w",789);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","arpg_riordina");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"270\",\"name\":\"Box_IDIZVJSJFR\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"IDIZVJSJFR\",\"tabindex\":\"1\",\"type\":\"Box\",\"w\":\"776\",\"x\":\"8\",\"y\":\"9\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"32\",\"href\":\"javascript:href_ROZQLWLMOH()\",\"name\":\"images_elaborazione_gif\",\"page\":\"1\",\"spuid\":\"ROZQLWLMOH\",\"src\":\"images\\/elaborazione.gif\",\"tabindex\":\"2\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"376\",\"y\":\"243\",\"zone\":\"IDIZVJSJFR_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"25\",\"href\":\" \",\"name\":\"__iframe_width__460__height__80__id___elaborazione__name___elaborazione__frameborder__0___border__0__align__TOP__marginwidth__0__marginheight__0____iframe__\",\"page\":\"1\",\"spuid\":\"FGMOCXNBFY_DIV\",\"tabindex\":\"3\",\"type\":\"Label\",\"value\":\"\\\"<iframe width="+"'"+"460"+"'"+" height="+"'"+"80"+"'"+" id ="+"'"+"elaborazione"+"'"+" name ="+"'"+"elaborazione"+"'"+" frameborder="+"'"+"0"+"'"+"  border="+"'"+"0"+"'"+" align="+"'"+"TOP"+"'"+" marginwidth="+"'"+"0"+"'"+" marginheight="+"'"+"0"+"'"+"><\\/iframe>\\\"\",\"w\":\"21\",\"x\":\"752\",\"y\":\"18\",\"zone\":\"\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"ARCHIVI_DA_RIORDINARE\",\"page\":\"1\",\"spuid\":\"TSMFJKNNPI_DIV\",\"tabindex\":\"4\",\"type\":\"Label\",\"value\":\"ARCHIVI DA RIORDINARE\",\"w\":\"141\",\"x\":\"16\",\"y\":\"18\",\"zone\":\"IDIZVJSJFR_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"rapuif\",\"page\":\"1\",\"spuid\":\"RWYSXVADUD\",\"tabindex\":\"5\",\"type\":\"Checkbox\",\"w\":\"112\",\"x\":\"16\",\"y\":\"45\",\"zone\":\"IDIZVJSJFR_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"opeuif\",\"page\":\"1\",\"spuid\":\"CENYIVTJCD\",\"tabindex\":\"6\",\"type\":\"Checkbox\",\"w\":\"112\",\"x\":\"176\",\"y\":\"45\",\"zone\":\"IDIZVJSJFR_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"frzuif\",\"page\":\"1\",\"spuid\":\"CPLLFIWSVW\",\"tabindex\":\"7\",\"type\":\"Checkbox\",\"w\":\"112\",\"x\":\"336\",\"y\":\"45\",\"zone\":\"IDIZVJSJFR_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"rapage\",\"page\":\"1\",\"spuid\":\"JALETSSOWI\",\"tabindex\":\"8\",\"type\":\"Checkbox\",\"w\":\"112\",\"x\":\"16\",\"y\":\"81\",\"zone\":\"IDIZVJSJFR_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"opeage\",\"page\":\"1\",\"spuid\":\"YSMCMCPCUY\",\"tabindex\":\"9\",\"type\":\"Checkbox\",\"w\":\"112\",\"x\":\"176\",\"y\":\"81\",\"zone\":\"IDIZVJSJFR_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"titaui\",\"page\":\"1\",\"spuid\":\"IEUGAKXYTZ\",\"tabindex\":\"11\",\"type\":\"Checkbox\",\"w\":\"112\",\"x\":\"496\",\"y\":\"45\",\"zone\":\"IDIZVJSJFR_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"flgpart\",\"page\":\"1\",\"spuid\":\"FMRRWRYWEQ\",\"tabindex\":\"13\",\"type\":\"Checkbox\",\"w\":\"136\",\"x\":\"16\",\"y\":\"117\",\"zone\":\"IDIZVJSJFR_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Prog. IDBASE\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"11\",\"name\":\"prgidb\",\"page\":\"1\",\"spuid\":\"IRVRFIWCHD\",\"tabindex\":\"14\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"232\",\"y\":\"117\",\"zone\":\"IDIZVJSJFR_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Prog__IDBASE_\",\"page\":\"1\",\"spuid\":\"BQBTJCITDO_DIV\",\"tabindex\":\"15\",\"type\":\"Label\",\"value\":\"Prog. IDBASE:\",\"w\":\"69\",\"x\":\"163\",\"y\":\"121\",\"zone\":\"IDIZVJSJFR_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Prog. IDBASE\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"11\",\"name\":\"prgnprg\",\"page\":\"1\",\"spuid\":\"SHFWFZUZAU\",\"tabindex\":\"16\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"448\",\"y\":\"117\",\"zone\":\"IDIZVJSJFR_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Prog__NUMPROG_\",\"page\":\"1\",\"spuid\":\"ZUPQPKRXOU_DIV\",\"tabindex\":\"17\",\"type\":\"Label\",\"value\":\"Prog. NUMPROG:\",\"w\":\"83\",\"x\":\"365\",\"y\":\"121\",\"zone\":\"IDIZVJSJFR_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Prog. IDBASE\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"11\",\"name\":\"prgiope\",\"page\":\"1\",\"spuid\":\"BBWGQILZDE\",\"tabindex\":\"18\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"672\",\"y\":\"117\",\"zone\":\"IDIZVJSJFR_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Prog__PRGIMPOPE_\",\"page\":\"1\",\"spuid\":\"HEDBPKUMXR_DIV\",\"tabindex\":\"19\",\"type\":\"Label\",\"value\":\"Prog. PRGIMPOPE:\",\"w\":\"91\",\"x\":\"581\",\"y\":\"121\",\"zone\":\"IDIZVJSJFR_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Da Data Registrazione\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"10\",\"name\":\"daData\",\"page\":\"1\",\"spuid\":\"DGCPENGASO\",\"tabindex\":\"20\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"672\",\"y\":\"81\",\"zone\":\"IDIZVJSJFR_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Da_Data_Registrazione_\",\"page\":\"1\",\"spuid\":\"JJDJMFKGFW_DIV\",\"tabindex\":\"21\",\"type\":\"Label\",\"value\":\"Da Data Registrazione:\",\"w\":\"120\",\"x\":\"552\",\"y\":\"85\",\"zone\":\"IDIZVJSJFR_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"84\",\"name\":\"Portlet_DYMVKIQWCA\",\"page\":\"1\",\"src\":\"\\/jsp\\/showmsg_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____DYMVKIQWCA\",\"type\":\"Portlet\",\"w\":\"760\",\"x\":\"16\",\"y\":\"153\",\"zone\":\"IDIZVJSJFR_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"date oltre il limite\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"dataover\",\"page\":\"1\",\"spuid\":\"YSDLBTYKKH\",\"tabindex\":\"23\",\"type\":\"Checkbox\",\"w\":\"104\",\"x\":\"336\",\"y\":\"81\",\"zone\":\"IDIZVJSJFR_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Numero di giorni\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"3\",\"name\":\"ngiorni\",\"page\":\"1\",\"spuid\":\"BXVKMROMSG\",\"tabindex\":\"24\",\"type\":\"Textbox\",\"w\":\"80\",\"x\":\"440\",\"y\":\"82\",\"zone\":\"IDIZVJSJFR_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void Next(ServletStatus status,arpg_riordinaBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_riordinaBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_riordinaBO BO,ServletStatus status) {
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
     "<script src='arpg_riordina?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
     "<script src='SPPrxy/"+m_cEntityUid+"/arpg_riordina_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(284,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
  void RaiseLoadedEntity(arpg_riordinaBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_riordinaBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(arpg_riordinaBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(arpg_riordinaBO BO,ServletStatus status) {
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
  void WriteExitPage(arpg_riordinaBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(arpg_riordinaBO BO,ServletStatus status) {
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
      arrt_riordina.GetCallableNames(callable);
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,arpg_riordinaBO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,arpg_riordinaBO BO) {
    boolean result = true;
    return result;
  }
}
