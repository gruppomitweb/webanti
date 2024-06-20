import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_import_fileae extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*QWSOAJYSTX*!";
  static public class ServletStatus extends SPPageServletStatus {
    public void MergeCallerVars(SPParameterSource source) {
      source.SetParameter("nomefile",source.GetCaller().GetString("nomefile","C",100,0));
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
    arpg_import_fileaeBO BO;
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
    return "Import File Anagrafe Agenzia Entrate";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_import_fileae";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 799;
    l_eg.m_nEntityHeight = 649;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"tbvalute"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.items = new SPItem[]{
                   new SPItem("nomefile","C",100,0, "show",""),
                   new SPItem("errchk","N",1,0, "hide",""),
                   new SPItem("offset","N",5,0, "edit",""),
                   new SPItem("f_denom","C",1,0, "edit",""),
                   new SPItem("f_ricaui","C",1,0, "edit",""),
                   new SPItem("prefrap","C",5,0, "edit",""),
                   new SPItem("codval","C",3,0, "edit",""),
                   new SPItem("xdesval","C",45,0, "hide","Descrizione"),
                   new SPItem("impzip","N",1,0, "show",""),
                   new SPItem("faggp","C",1,0, "edit",""),
                   new SPItem("faggr","C",1,0, "edit",""),
                   new SPItem("tipofile","C",1,0, "edit",""),
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,arpg_import_fileaeBO BO) {
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
    l_translations=new String[][]{{"10509999726",p_Context.Translate("Riallinea dati con terne")},
    {"10664744434",p_Context.Translate("Import dei dati")},
    {"10846144684",p_Context.Translate("Import File Anagrafe Agenzia Entrate")},
    {"11369217405",p_Context.Translate("Per i soggetti senza codice fiscale, se non trovati cerca per Denominazione")},
    {"114016870",p_Context.Translate("Valute")},
    {"1604101495",p_Context.Translate("Aggiorna dati anagrafici se presenti")},
    {"1984373739",p_Context.Translate("Aggiorna righe se già presenti")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"582839624",p_Context.Translate("Vecchio Intermediario")}};
    return l_translations;
  }
  void WriteStyles(arpg_import_fileaeBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/arpg_import_fileae.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(arpg_import_fileaeBO BO,ServletStatus status) {
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
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_DYMVKIQWCA_Vars(arpg_import_fileaeBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  // GetPortlet_Log_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_KQMKKBMXYE_Vars(arpg_import_fileaeBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  // GetPortlet_ListaFile_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_MVXXCZOQGP_Vars(arpg_import_fileaeBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  void WriteControls(arpg_import_fileaeBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(arpg_import_fileaeBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(644);
    WriteControls_1_h_0(BO,status);
  }
  void WriteControls_1_h_0(arpg_import_fileaeBO BO,ServletStatus status) {
    status.out.println(
     "<div id='YWGFSYCMOZ_DIV' class='UntitledBox'>" +
     "<div id='YWGFSYCMOZ' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='GRNCOSXGXB_DIV'>" +
     "<label id='GRNCOSXGXB'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Selezione del file da importare"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='nomefile' id='ZFBIYQMSFL' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_nomefile,"C",100,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='100' size='100' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='DZUBEERBGN' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Seleziona"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' onkeydown='ManageKeys(event,false,false,true)' onclick='DZUBEERBGN_Click()'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='PIRPTHHLHK' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Esegui"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Import dei dati"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' onkeydown='ManageKeys(event,false,false,true)' onclick='PIRPTHHLHK_Click()'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FGMOCXNBFY_DIV' style='display:none'>" +
     "<label id='FGMOCXNBFY'>" +
     ""+SPLib.ToHTMLRepresentation("<iframe width='655' height='170' id='elaborazione'  name='elaborazione'  frameborder='1'  border='1' align='TOP' marginwidth='1' marginheight='1'></iframe>")+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VBEYRFASEL_DIV'>" +
     "<label id='VBEYRFASEL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Impostazione della lunghezza del record (nel tracciato ufficiale è 1800)"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='offset' id='VNFRMCXRZW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_offset,"N",5,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='5' fieldtype='N' onkeypress=''>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='BLSWRPJBJG_DIV'>" +
     "<input name='f_denom' id='BLSWRPJBJG' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_f_denom,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_f_denom))?"CHECKED":"")+">" +
     "<label id='BLSWRPJBJG_LBL' for='BLSWRPJBJG' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Per i soggetti senza codice fiscale, se non trovati cerca per Denominazione"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='f_ricaui' id='EQEVYTAUZT' class='Combobox' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("A","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("A",CPLib.Trim(BO.w_f_ricaui))?"SELECTED":"")+">" +
     ""+status.context.Translate("Ricostruzione Archivio Unico Informatico (Menu 2)")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("G","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("G",CPLib.Trim(BO.w_f_ricaui))?"SELECTED":"")+">" +
     ""+status.context.Translate("Ricostruzione Archivio Agenzia Entrate (Menu 5)")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('EQEVYTAUZT'),w_f_ricaui,'C');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CDTQPZIPTH_DIV'>" +
     "<label id='CDTQPZIPTH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Prefisso Nome Rapporti:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='prefrap' id='VQLMVVYLUU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_prefrap,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='codval' id='HKGEZJGNAE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_codval,"C",3,0,"", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='HKGEZJGNAE_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='HKGEZJGNAE_ZOOM_Click()'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SSTUTBOCAN_DIV'>" +
     "<label id='SSTUTBOCAN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Valuta:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RMHDQIMWME_DIV'>" +
     "<label id='RMHDQIMWME'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdesval)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='impzip' id='UEOYJYCOSR' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_impzip,"N",1,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='2' size='1' fieldtype='N' onkeypress=''>" +
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
     "<div id='MVXXCZOQGP'>" +
    "");
    // GetPortlet_ListaFile_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_MVXXCZOQGP;
    inclusionVars_MVXXCZOQGP = GetPortlet_MVXXCZOQGP_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_MVXXCZOQGP);
    String portletUID_MVXXCZOQGP = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/list_imprich_portlet.jsp?ForcedPortletUID="+ portletUID_MVXXCZOQGP+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_MVXXCZOQGP),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.MVXXCZOQGP='"+portletUID_MVXXCZOQGP+"';" +
     "w_ListaFile=ZtVWeb.getPortletById('"+portletUID_MVXXCZOQGP+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='HWGSDNXHVO' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Riallinea"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Riallinea dati con terne"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' onkeydown='ManageKeys(event,false,false,true)' onclick='HWGSDNXHVO_Click()'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='NRLODKQADP_DIV'>" +
     "<input name='faggp' id='NRLODKQADP' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_faggp,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_faggp))?"CHECKED":"")+">" +
     "<label id='NRLODKQADP_LBL' for='NRLODKQADP' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Aggiorna dati anagrafici se presenti"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='WKILGLJQCE_DIV'>" +
     "<input name='faggr' id='WKILGLJQCE' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_faggr,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_faggr))?"CHECKED":"")+">" +
     "<label id='WKILGLJQCE_LBL' for='WKILGLJQCE' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Aggiorna righe se già presenti"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LQPXLNJOZC_DIV'>" +
     "<label id='LQPXLNJOZC'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo File:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='tipofile' id='VURSSHWJPP' class='Combobox' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("S","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("S",CPLib.Trim(BO.w_tipofile))?"SELECTED":"")+">" +
     ""+status.context.Translate("Standard")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("D","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("D",CPLib.Trim(BO.w_tipofile))?"SELECTED":"")+">" +
     ""+status.context.Translate("DCM")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('VURSSHWJPP'),w_tipofile,'C');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='oldinter' id='LJCBRCQAIY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_oldinter,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='AYJCXMJZDC_DIV'>" +
     "<label id='AYJCXMJZDC' for='LJCBRCQAIY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Vecchio Intermediario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.themeWriter.Header_EndHtml();
  }
  static void PrintState(arpg_import_fileaeBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_import_fileaeBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_import_fileaeBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_nomefile,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_errchk,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_offset,"N",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_f_denom,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_f_ricaui,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_prefrap,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_codval,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesval,"C",45,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_impzip,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_faggp,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_faggr,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipofile,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oldinter,"C",16,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_import_fileaeBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_FGMOCXNBFY = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_RMHDQIMWME = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(649,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(799,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_import_fileae"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    status.out.print("'HKGEZJGNAE':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CODVALCODVAL,DESCRIC,Ctbvalute",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbvalute,"+"default",l_session)+"'"+"]");
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
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_import_fileae","");
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
  void WriteMainFormScript(arpg_import_fileaeBO BO,ServletStatus status) {
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
    status.out.println("// * --- arpg_import_fileae");
    status.out.println("function UploadDoc() {");
    status.out.println("  m_bUpdated=true");
    status.out.println("  windowOpenForeground(PlatformPathStart('vRepupload')+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','','toolbar=0,menubar=0,directories=0,width=500,height=400,resizable=1,scrollbars=1')");
    status.out.println("}");
    status.out.println("");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  arpg_import_fileaeBO getBO(ServletStatus status) {
    arpg_import_fileaeBO BO = new arpg_import_fileaeBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_import_fileaeBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_import_fileaeBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_import_fileaeBO BO) {
    BO.SetFromContext(status.m_cWv);
    BO.Calculate();
  }
  void Save(ServletStatus status,arpg_import_fileaeBO BO) {
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
  void Discard(ServletStatus status,arpg_import_fileaeBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,arpg_import_fileaeBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",649);
    item.put("w",799);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","arpg_import_fileae");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"637\",\"name\":\"Box_YWGFSYCMOZ\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"YWGFSYCMOZ\",\"tabindex\":\"1\",\"type\":\"Box\",\"w\":\"776\",\"x\":\"8\",\"y\":\"7\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Selezione_del_file_da_importare\",\"page\":\"1\",\"spuid\":\"GRNCOSXGXB_DIV\",\"tabindex\":\"2\",\"type\":\"Label\",\"value\":\"Selezione del file da importare\",\"w\":\"226\",\"x\":\"16\",\"y\":\"14\",\"zone\":\"YWGFSYCMOZ_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"100\",\"name\":\"nomefile\",\"page\":\"1\",\"spuid\":\"ZFBIYQMSFL\",\"type\":\"Textbox\",\"w\":\"664\",\"x\":\"16\",\"y\":\"35\",\"zone\":\"YWGFSYCMOZ_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"25\",\"href\":\"javascript:DZUBEERBGN_Click()\",\"name\":\"Seleziona\",\"page\":\"1\",\"spuid\":\"DZUBEERBGN\",\"tabindex\":\"4\",\"type\":\"Button\",\"value\":\"Seleziona\",\"w\":\"88\",\"x\":\"688\",\"y\":\"35\",\"zone\":\"YWGFSYCMOZ_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"25\",\"href\":\"javascript:PIRPTHHLHK_Click()\",\"name\":\"Esegui\",\"page\":\"1\",\"spuid\":\"PIRPTHHLHK\",\"tabindex\":\"5\",\"type\":\"Button\",\"value\":\"Esegui\",\"w\":\"88\",\"x\":\"688\",\"y\":\"63\",\"zone\":\"YWGFSYCMOZ_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"14\",\"href\":\" \",\"name\":\"__iframe_width__655__height__170__id__elaborazione___name__elaborazione___frameborder__1___border__1__align__TOP__marginwidth__1__marginheight__1____iframe__\",\"page\":\"1\",\"spuid\":\"FGMOCXNBFY_DIV\",\"tabindex\":\"6\",\"type\":\"Label\",\"value\":\"\\\"<iframe width="+"'"+"655"+"'"+" height="+"'"+"170"+"'"+" id="+"'"+"elaborazione"+"'"+"  name="+"'"+"elaborazione"+"'"+"  frameborder="+"'"+"1"+"'"+"  border="+"'"+"1"+"'"+" align="+"'"+"TOP"+"'"+" marginwidth="+"'"+"1"+"'"+" marginheight="+"'"+"1"+"'"+"><\\/iframe>\\\"\",\"w\":\"16\",\"x\":\"760\",\"y\":\"14\",\"zone\":\"\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Impostazione_della_lunghezza_del_record__nel_tracciato_ufficiale_\\u00E8_1800_\",\"page\":\"1\",\"spuid\":\"VBEYRFASEL_DIV\",\"tabindex\":\"8\",\"type\":\"Label\",\"value\":\"Impostazione della lunghezza del record (nel tracciato ufficiale \\u00E8 1800)\",\"w\":\"337\",\"x\":\"24\",\"y\":\"63\",\"zone\":\"YWGFSYCMOZ_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"6\",\"name\":\"offset\",\"page\":\"1\",\"spuid\":\"VNFRMCXRZW\",\"tabindex\":\"9\",\"type\":\"Textbox\",\"w\":\"66\",\"x\":\"365\",\"y\":\"59\",\"zone\":\"YWGFSYCMOZ_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"f_denom\",\"page\":\"1\",\"spuid\":\"BLSWRPJBJG\",\"tabindex\":\"10\",\"type\":\"Checkbox\",\"w\":\"377\",\"x\":\"21\",\"y\":\"87\",\"zone\":\"YWGFSYCMOZ_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"f_ricaui\",\"page\":\"1\",\"spuid\":\"EQEVYTAUZT\",\"tabindex\":\"11\",\"textlist\":\"Ricostruzione Archivio Unico Informatico (Menu 2),Ricostruzione Archivio Agenzia Entrate (Menu 5)\",\"type\":\"Combobox\",\"valuelist\":\""+"'"+"A"+"'"+","+"'"+"G"+"'"+"\",\"w\":\"408\",\"x\":\"21\",\"y\":\"116\",\"zone\":\"YWGFSYCMOZ_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Prefisso_Nome_Rapporti_\",\"page\":\"1\",\"spuid\":\"CDTQPZIPTH_DIV\",\"tabindex\":\"12\",\"type\":\"Label\",\"value\":\"Prefisso Nome Rapporti:\",\"w\":\"116\",\"x\":\"445\",\"y\":\"119\",\"zone\":\"YWGFSYCMOZ_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"5\",\"name\":\"prefrap\",\"page\":\"1\",\"spuid\":\"VQLMVVYLUU\",\"tabindex\":\"13\",\"type\":\"Textbox\",\"w\":\"58\",\"x\":\"565\",\"y\":\"115\",\"zone\":\"YWGFSYCMOZ_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"3\",\"name\":\"codval\",\"page\":\"1\",\"spuid\":\"HKGEZJGNAE\",\"tabindex\":\"14\",\"type\":\"Textbox\",\"w\":\"40\",\"x\":\"88\",\"y\":\"147\",\"zone\":\"YWGFSYCMOZ_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Codice_Valuta_\",\"page\":\"1\",\"spuid\":\"SSTUTBOCAN_DIV\",\"tabindex\":\"15\",\"type\":\"Label\",\"value\":\"Codice Valuta:\",\"w\":\"73\",\"x\":\"11\",\"y\":\"151\",\"zone\":\"YWGFSYCMOZ_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"w_xdesval\",\"page\":\"1\",\"spuid\":\"RMHDQIMWME_DIV\",\"tabindex\":\"17\",\"type\":\"Label\",\"value\":\"w_xdesval\",\"w\":\"352\",\"x\":\"154\",\"y\":\"151\",\"zone\":\"YWGFSYCMOZ_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"2\",\"name\":\"impzip\",\"page\":\"1\",\"spuid\":\"UEOYJYCOSR\",\"type\":\"Textbox\",\"w\":\"88\",\"x\":\"688\",\"y\":\"119\",\"zone\":\"YWGFSYCMOZ_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"84\",\"name\":\"Portlet_DYMVKIQWCA\",\"page\":\"1\",\"src\":\"\\/jsp\\/showmsg_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____DYMVKIQWCA\",\"type\":\"Portlet\",\"w\":\"760\",\"x\":\"16\",\"y\":\"553\",\"zone\":\"YWGFSYCMOZ_10\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"147\",\"name\":\"Portlet_KQMKKBMXYE\",\"page\":\"1\",\"src\":\"\\/jsp\\/showlog_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____KQMKKBMXYE\",\"type\":\"Portlet\",\"w\":\"760\",\"x\":\"16\",\"y\":\"203\",\"zone\":\"YWGFSYCMOZ_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"198\",\"name\":\"Portlet_MVXXCZOQGP\",\"page\":\"1\",\"src\":\"\\/jsp\\/list_imprich_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____MVXXCZOQGP\",\"type\":\"Portlet\",\"w\":\"760\",\"x\":\"16\",\"y\":\"352\",\"zone\":\"YWGFSYCMOZ_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"25\",\"href\":\"javascript:HWGSDNXHVO_Click()\",\"name\":\"Riallinea\",\"page\":\"1\",\"spuid\":\"HWGSDNXHVO\",\"tabindex\":\"22\",\"type\":\"Button\",\"value\":\"Riallinea\",\"w\":\"88\",\"x\":\"688\",\"y\":\"91\",\"zone\":\"YWGFSYCMOZ_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"faggp\",\"page\":\"1\",\"spuid\":\"NRLODKQADP\",\"tabindex\":\"23\",\"type\":\"Checkbox\",\"w\":\"208\",\"x\":\"456\",\"y\":\"91\",\"zone\":\"YWGFSYCMOZ_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"faggr\",\"page\":\"1\",\"spuid\":\"WKILGLJQCE\",\"tabindex\":\"24\",\"type\":\"Checkbox\",\"w\":\"208\",\"x\":\"88\",\"y\":\"175\",\"zone\":\"YWGFSYCMOZ_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Tipo_File_\",\"page\":\"1\",\"spuid\":\"LQPXLNJOZC_DIV\",\"tabindex\":\"25\",\"type\":\"Label\",\"value\":\"Tipo File:\",\"w\":\"47\",\"x\":\"448\",\"y\":\"63\",\"zone\":\"YWGFSYCMOZ_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"name\":\"tipofile\",\"page\":\"1\",\"spuid\":\"VURSSHWJPP\",\"tabindex\":\"26\",\"textlist\":\"Standard,DCM\",\"type\":\"Combobox\",\"valuelist\":\""+"'"+"S"+"'"+","+"'"+"D"+"'"+"\",\"w\":\"184\",\"x\":\"496\",\"y\":\"59\",\"zone\":\"YWGFSYCMOZ_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Vecchio Intermediario\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"20\",\"maxlength\":\"16\",\"name\":\"oldinter\",\"page\":\"1\",\"spuid\":\"LJCBRCQAIY\",\"tabindex\":\"27\",\"type\":\"Textbox\",\"w\":\"108\",\"x\":\"565\",\"y\":\"175\",\"zone\":\"YWGFSYCMOZ_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"16\",\"href\":\" \",\"name\":\"Vecchio_Intermediario_\",\"page\":\"1\",\"spuid\":\"AYJCXMJZDC_DIV\",\"tabindex\":\"28\",\"type\":\"Label\",\"value\":\"Vecchio Intermediario:\",\"w\":\"117\",\"x\":\"444\",\"y\":\"179\",\"zone\":\"YWGFSYCMOZ_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void Next(ServletStatus status,arpg_import_fileaeBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_import_fileaeBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_import_fileaeBO BO,ServletStatus status) {
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
     "<script src='arpg_import_fileae?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
     "<script src='SPPrxy/"+m_cEntityUid+"/arpg_import_fileae_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(649,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
  void RaiseLoadedEntity(arpg_import_fileaeBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_import_fileaeBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(arpg_import_fileaeBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(arpg_import_fileaeBO BO,ServletStatus status) {
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
  void WriteExitPage(arpg_import_fileaeBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(arpg_import_fileaeBO BO,ServletStatus status) {
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
      arrt_import_fileae.GetCallableNames(callable);
      arrt_riallinea_fileae.GetCallableNames(callable);
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,arpg_import_fileaeBO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,arpg_import_fileaeBO BO) {
    boolean result = true;
    return result;
  }
}
