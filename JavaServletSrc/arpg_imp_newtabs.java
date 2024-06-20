import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_imp_newtabs extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*MRGISXZMXU*!";
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
    arpg_imp_newtabsBO BO;
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
    return "Aggiornamento Tabelle Antiriciclaggio";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_imp_newtabs";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 799;
    l_eg.m_nEntityHeight = 537;
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
                   new SPItem("gFlgWU","C",1,0, "hide","Gestione WU"),
                   new SPItem("tbcitta","C",1,0, "edit",""),
                   new SPItem("tbsetsin","C",1,0, "edit",""),
                   new SPItem("tbcauana","C",1,0, "edit",""),
                   new SPItem("inter2bo","C",1,0, "edit",""),
                   new SPItem("tbvalute","C",1,0, "edit",""),
                   new SPItem("tbtipreg","C",1,0, "edit",""),
                   new SPItem("tbstati","C",1,0, "edit",""),
                   new SPItem("tbtipint","C",1,0, "edit",""),
                   new SPItem("tbesitoage","C",1,0, "edit",""),
                   new SPItem("tbrapp","C",1,0, "edit",""),
                   new SPItem("tbstgru","C",1,0, "edit",""),
                   new SPItem("tbramgru","C",1,0, "edit",""),
                   new SPItem("tbtipdoc","C",1,0, "edit",""),
                   new SPItem("tbtipleg","C",1,0, "edit",""),
                   new SPItem("tbtipnat","C",1,0, "edit",""),
                   new SPItem("tberrorisid","C",1,0, "edit",""),
                   new SPItem("tberrsiddgn","C",1,0, "edit",""),
                   new SPItem("tbricevutesid","C",1,0, "edit",""),
                   new SPItem("tbcittna","C",1,0, "edit",""),
                   new SPItem("tbstatna","C",1,0, "edit",""),
                   new SPItem("tberrdge","C",1,0, "edit",""),
                   new SPItem("tbprvreg","C",1,0, "edit",""),
                   new SPItem("tbesielb","C",1,0, "edit",""),
                   new SPItem("convgio","C",1,0, "edit",""),
                   new SPItem("staticrs","C",1,0, "edit",""),
                   new SPItem("tbcandistr","C",1,0, "edit",""),
                   new SPItem("tbluonas","C",1,0, "edit",""),
                   new SPItem("tbprovsv","C",1,0, "edit",""),
                   new SPItem("rapogg","C",1,0, "edit","")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,arpg_imp_newtabsBO BO) {
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
    l_translations=new String[][]{{"10097110631",p_Context.Translate("Stati OCSE (per CRS)")},
    {"10639118571",p_Context.Translate("Tipo Legame")},
    {"10664744434",p_Context.Translate("Import dei dati")},
    {"10983493593",p_Context.Translate("Gestione WU")},
    {"11166046192",p_Context.Translate("Province (SV)")},
    {"11194294587",p_Context.Translate("Conversione Tipi Gioco (CGO)")},
    {"11284460358",p_Context.Translate("Esiti AGE")},
    {"114016870",p_Context.Translate("Valute")},
    {"11429032151",p_Context.Translate("Tipo Documento")},
    {"11654621348",p_Context.Translate("Errori Esiti Saldi")},
    {"11749091718",p_Context.Translate("Rami Attività Economica")},
    {"12006048580",p_Context.Translate("Codici Rapporti Oggettivi")},
    {"12115874605",p_Context.Translate("Città di Nascita")},
    {"12123678061",p_Context.Translate("Stati di Nascita")},
    {"1289102826",p_Context.Translate("ABI+CAB Italia")},
    {"1452332461",p_Context.Translate("Natura conti")},
    {"15186643",p_Context.Translate("Città")},
    {"1667564043",p_Context.Translate("Confermi l'import delle tabelle?")},
    {"1752779956",p_Context.Translate("Esiti Elaborazione")},
    {"1881713491",p_Context.Translate("Causali")},
    {"2000555569",p_Context.Translate("Errori Diagnostico SID")},
    {"233672885",p_Context.Translate("Canali Distributivi (SV)")},
    {"289632239",p_Context.Translate("Settori Sintetici")},
    {"384957030",p_Context.Translate("Luoghi di Nascita AGE")},
    {"431865993",p_Context.Translate("Tipi Rapporto AGE")},
    {"439033982",p_Context.Translate("Province / Regioni")},
    {"684689814",p_Context.Translate("Sottogruppi Att. Economica")},
    {"7383187",p_Context.Translate("Stati")},
    {"90207336",p_Context.Translate("Errori Esiti SID")},
    {"971566069",p_Context.Translate("Aggiornamento Tabelle Antiriciclaggio")},
    {"984756930",p_Context.Translate("Tipo Intermediario")},
    {"993821105",p_Context.Translate("Esiti Ricevute SID")},
    {"995100987",p_Context.Translate("Tipo Registrazione")}};
    return l_translations;
  }
  void WriteStyles(arpg_imp_newtabsBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/arpg_imp_newtabs.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(arpg_imp_newtabsBO BO,ServletStatus status) {
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
  // GetPortlet_pMsg_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_DYMVKIQWCA_Vars(arpg_imp_newtabsBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  // GetPortlet_pLog_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_KQMKKBMXYE_Vars(arpg_imp_newtabsBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    return inclusionVars;
  }
  void WriteControls(arpg_imp_newtabsBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(arpg_imp_newtabsBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(532);
    WriteControls_1_h_0(BO,status);
  }
  void WriteControls_1_h_0(arpg_imp_newtabsBO BO,ServletStatus status) {
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='PIRPTHHLHK' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Esegui"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Import dei dati"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' onkeydown='ManageKeys(event,false,false,true)' onclick='PIRPTHHLHK_Click()'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FGMOCXNBFY_DIV' style='display:none'>" +
     "<label id='FGMOCXNBFY'>" +
     ""+SPLib.ToHTMLRepresentation("<iframe width='655' height='170' id ='elaborazione' name='elaborazione' frameborder='1'  border='1' align='TOP' marginwidth='1' marginheight='1'></iframe>")+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='YOKMCCNMNC' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Esegui MT"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Import dei dati"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' onkeydown='ManageKeys(event,false,false,true)' onclick='YOKMCCNMNC_Click()' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='GXYMDOZGOQ_DIV'>" +
     "<input name='tbcitta' id='GXYMDOZGOQ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbcitta,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbcitta))?"CHECKED":"")+">" +
     "<label id='GXYMDOZGOQ_LBL' for='GXYMDOZGOQ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Città"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='GYCYDAPWEF_DIV'>" +
     "<input name='tbsetsin' id='GYCYDAPWEF' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbsetsin,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbsetsin))?"CHECKED":"")+">" +
     "<label id='GYCYDAPWEF_LBL' for='GYCYDAPWEF' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Settori Sintetici"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='CLIZXFIFQP_DIV'>" +
     "<input name='tbcauana' id='CLIZXFIFQP' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbcauana,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbcauana))?"CHECKED":"")+">" +
     "<label id='CLIZXFIFQP_LBL' for='CLIZXFIFQP' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Causali"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='GYRPUQOAOP_DIV'>" +
     "<input name='inter2bo' id='GYRPUQOAOP' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_inter2bo,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_inter2bo))?"CHECKED":"")+">" +
     "<label id='GYRPUQOAOP_LBL' for='GYRPUQOAOP' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("ABI+CAB Italia"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='BPLIWTTKIK_DIV'>" +
     "<input name='tbvalute' id='BPLIWTTKIK' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbvalute,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbvalute))?"CHECKED":"")+">" +
     "<label id='BPLIWTTKIK_LBL' for='BPLIWTTKIK' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Valute"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='DJAYDIHKCT_DIV'>" +
     "<input name='tbtipreg' id='DJAYDIHKCT' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbtipreg,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbtipreg))?"CHECKED":"")+">" +
     "<label id='DJAYDIHKCT_LBL' for='DJAYDIHKCT' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Registrazione"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='GQLSVVBZAE_DIV'>" +
     "<input name='tbstati' id='GQLSVVBZAE' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbstati,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbstati))?"CHECKED":"")+">" +
     "<label id='GQLSVVBZAE_LBL' for='GQLSVVBZAE' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Stati"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='KAUCYBWKCY_DIV'>" +
     "<input name='tbtipint' id='KAUCYBWKCY' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbtipint,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbtipint))?"CHECKED":"")+">" +
     "<label id='KAUCYBWKCY_LBL' for='KAUCYBWKCY' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Intermediario"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='QYIGQMSMGL_DIV'>" +
     "<input name='tbesitoage' id='QYIGQMSMGL' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbesitoage,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbesitoage))?"CHECKED":"")+">" +
     "<label id='QYIGQMSMGL_LBL' for='QYIGQMSMGL' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Esiti AGE"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='DKJFQFFFCS_DIV'>" +
     "<input name='tbrapp' id='DKJFQFFFCS' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbrapp,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbrapp))?"CHECKED":"")+">" +
     "<label id='DKJFQFFFCS_LBL' for='DKJFQFFFCS' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Tipi Rapporto AGE"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='NXHTINJEZP_DIV'>" +
     "<input name='tbstgru' id='NXHTINJEZP' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbstgru,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbstgru))?"CHECKED":"")+">" +
     "<label id='NXHTINJEZP_LBL' for='NXHTINJEZP' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Sottogruppi Att. Economica"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='WDDZKXXVRH_DIV'>" +
     "<input name='tbramgru' id='WDDZKXXVRH' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbramgru,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbramgru))?"CHECKED":"")+">" +
     "<label id='WDDZKXXVRH_LBL' for='WDDZKXXVRH' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Rami Attività Economica"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='ESQBNZZTIJ_DIV'>" +
     "<input name='tbtipdoc' id='ESQBNZZTIJ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbtipdoc,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbtipdoc))?"CHECKED":"")+">" +
     "<label id='ESQBNZZTIJ_LBL' for='ESQBNZZTIJ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Documento"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='KQCTUMJHSZ_DIV'>" +
     "<input name='tbtipleg' id='KQCTUMJHSZ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbtipleg,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbtipleg))?"CHECKED":"")+">" +
     "<label id='KQCTUMJHSZ_LBL' for='KQCTUMJHSZ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Legame"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='NRFNGQKNRC_DIV'>" +
     "<input name='tbtipnat' id='NRFNGQKNRC' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbtipnat,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbtipnat))?"CHECKED":"")+">" +
     "<label id='NRFNGQKNRC_LBL' for='NRFNGQKNRC' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Natura conti"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "<div id='DYMVKIQWCA'>" +
    "");
    // GetPortlet_pMsg_Vars()
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
    // GetPortlet_pLog_Vars()
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
     "<span id='FPLVARMRZT_DIV'>" +
     "<input name='tberrorisid' id='FPLVARMRZT' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tberrorisid,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tberrorisid))?"CHECKED":"")+">" +
     "<label id='FPLVARMRZT_LBL' for='FPLVARMRZT' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Errori Esiti SID"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='FCJDCGCZMR_DIV'>" +
     "<input name='tberrsiddgn' id='FCJDCGCZMR' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tberrsiddgn,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tberrsiddgn))?"CHECKED":"")+">" +
     "<label id='FCJDCGCZMR_LBL' for='FCJDCGCZMR' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Errori Diagnostico SID"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='NOPTJJJCIV_DIV'>" +
     "<input name='tbricevutesid' id='NOPTJJJCIV' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbricevutesid,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbricevutesid))?"CHECKED":"")+">" +
     "<label id='NOPTJJJCIV_LBL' for='NOPTJJJCIV' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Esiti Ricevute SID"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='SUYPGBDTZX_DIV'>" +
     "<input name='tbcittna' id='SUYPGBDTZX' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbcittna,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbcittna))?"CHECKED":"")+">" +
     "<label id='SUYPGBDTZX_LBL' for='SUYPGBDTZX' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Città di Nascita"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='YAEKWBHJNU_DIV'>" +
     "<input name='tbstatna' id='YAEKWBHJNU' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbstatna,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbstatna))?"CHECKED":"")+">" +
     "<label id='YAEKWBHJNU_LBL' for='YAEKWBHJNU' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Stati di Nascita"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='PJTUOGFKMR_DIV'>" +
     "<input name='tberrdge' id='PJTUOGFKMR' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tberrdge,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tberrdge))?"CHECKED":"")+">" +
     "<label id='PJTUOGFKMR_LBL' for='PJTUOGFKMR' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Errori Esiti Saldi"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='NGTLHQAOIU_DIV'>" +
     "<input name='tbprvreg' id='NGTLHQAOIU' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbprvreg,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbprvreg))?"CHECKED":"")+">" +
     "<label id='NGTLHQAOIU_LBL' for='NGTLHQAOIU' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Province / Regioni"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='AZAPSXEAEY_DIV'>" +
     "<input name='tbesielb' id='AZAPSXEAEY' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbesielb,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbesielb))?"CHECKED":"")+">" +
     "<label id='AZAPSXEAEY_LBL' for='AZAPSXEAEY' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Esiti Elaborazione"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='NJLNRHUWKF_DIV'>" +
     "<input name='convgio' id='NJLNRHUWKF' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_convgio,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_convgio))?"CHECKED":"")+">" +
     "<label id='NJLNRHUWKF_LBL' for='NJLNRHUWKF' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Conversione Tipi Gioco (CGO)"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='WJYIVNDHCP_DIV'>" +
     "<input name='staticrs' id='WJYIVNDHCP' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_staticrs,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_staticrs))?"CHECKED":"")+">" +
     "<label id='WJYIVNDHCP_LBL' for='WJYIVNDHCP' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Stati OCSE (per CRS)"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='GOZUJRIMWT_DIV'>" +
     "<input name='tbcandistr' id='GOZUJRIMWT' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbcandistr,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbcandistr))?"CHECKED":"")+">" +
     "<label id='GOZUJRIMWT_LBL' for='GOZUJRIMWT' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Canali Distributivi (SV)"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='UTCLBUQFFR_DIV'>" +
     "<input name='tbluonas' id='UTCLBUQFFR' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbluonas,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbluonas))?"CHECKED":"")+">" +
     "<label id='UTCLBUQFFR_LBL' for='UTCLBUQFFR' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Luoghi di Nascita AGE"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='QLYYYUZTMV_DIV'>" +
     "<input name='tbprovsv' id='QLYYYUZTMV' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_tbprovsv,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_tbprovsv))?"CHECKED":"")+">" +
     "<label id='QLYYYUZTMV_LBL' for='QLYYYUZTMV' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Province (SV)"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='LTWONWESXG' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Esegui"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Import dei dati"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' onkeydown='ManageKeys(event,false,false,true)' onclick='LTWONWESXG_Click()' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='NOMTMIMOQE_DIV'>" +
     "<input name='rapogg' id='NOMTMIMOQE' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_rapogg,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_rapogg))?"CHECKED":"")+">" +
     "<label id='NOMTMIMOQE_LBL' for='NOMTMIMOQE' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Codici Rapporti Oggettivi"))+"</label>" +
     "</span>" +
    "");
    status.themeWriter.Header_EndHtml();
  }
  static void PrintState(arpg_imp_newtabsBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_imp_newtabsBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_imp_newtabsBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_gFlgWU,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbcitta,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbsetsin,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbcauana,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_inter2bo,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbvalute,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbtipreg,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbstati,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbtipint,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbesitoage,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbrapp,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbstgru,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbramgru,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbtipdoc,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbtipleg,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbtipnat,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tberrorisid,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tberrsiddgn,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbricevutesid,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbcittna,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbstatna,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tberrdge,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbprvreg,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbesielb,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_convgio,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_staticrs,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbcandistr,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbluonas,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tbprovsv,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_rapogg,"C",1,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_imp_newtabsBO BO,ServletStatus status) {
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(537,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_imp_newtabs"),"C",0,0)+ ";");
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
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_imp_newtabs","");
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
  void WriteMainFormScript(arpg_imp_newtabsBO BO,ServletStatus status) {
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
    status.out.println("// * --- arpg_imp_newtabs");
    status.out.println("function Lancio() {");
    status.out.println("  w_pLog.Timer0.Start();");
    status.out.println("  w_pMsg.Timer0.Start();");
    status.out.println("  LTWONWESXG_Click();");
    status.out.println("}");
    status.out.println("");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  arpg_imp_newtabsBO getBO(ServletStatus status) {
    arpg_imp_newtabsBO BO = new arpg_imp_newtabsBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_imp_newtabsBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_imp_newtabsBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_imp_newtabsBO BO) {
    BO.SetFromContext(status.m_cWv);
    BO.Calculate();
  }
  void Save(ServletStatus status,arpg_imp_newtabsBO BO) {
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
  void Discard(ServletStatus status,arpg_imp_newtabsBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,arpg_imp_newtabsBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",537);
    item.put("w",799);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","arpg_imp_newtabs");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"25\",\"href\":\"javascript:PIRPTHHLHK_Click()\",\"name\":\"Esegui\",\"page\":\"1\",\"spuid\":\"PIRPTHHLHK\",\"tabindex\":\"1\",\"type\":\"Button\",\"value\":\"Esegui\",\"w\":\"88\",\"x\":\"688\",\"y\":\"14\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"14\",\"href\":\" \",\"name\":\"__iframe_width__655__height__170__id___elaborazione__name__elaborazione__frameborder__1___border__1__align__TOP__marginwidth__1__marginheight__1____iframe__\",\"page\":\"1\",\"spuid\":\"FGMOCXNBFY_DIV\",\"tabindex\":\"2\",\"type\":\"Label\",\"value\":\"\\\"<iframe width="+"'"+"655"+"'"+" height="+"'"+"170"+"'"+" id ="+"'"+"elaborazione"+"'"+" name="+"'"+"elaborazione"+"'"+" frameborder="+"'"+"1"+"'"+"  border="+"'"+"1"+"'"+" align="+"'"+"TOP"+"'"+" marginwidth="+"'"+"1"+"'"+" marginheight="+"'"+"1"+"'"+"><\\/iframe>\\\"\",\"w\":\"88\",\"x\":\"16\",\"y\":\"21\",\"zone\":\"\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"25\",\"href\":\"javascript:YOKMCCNMNC_Click()\",\"name\":\"Esegui_MT\",\"page\":\"1\",\"spuid\":\"YOKMCCNMNC\",\"tabindex\":\"3\",\"type\":\"Button\",\"value\":\"Esegui MT\",\"w\":\"88\",\"x\":\"512\",\"y\":\"14\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbcitta\",\"page\":\"1\",\"spuid\":\"GXYMDOZGOQ\",\"tabindex\":\"5\",\"type\":\"Checkbox\",\"w\":\"64\",\"x\":\"16\",\"y\":\"49\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbsetsin\",\"page\":\"1\",\"spuid\":\"GYCYDAPWEF\",\"tabindex\":\"6\",\"type\":\"Checkbox\",\"w\":\"184\",\"x\":\"192\",\"y\":\"105\",\"zone\":\"pag1_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbcauana\",\"page\":\"1\",\"spuid\":\"CLIZXFIFQP\",\"tabindex\":\"7\",\"type\":\"Checkbox\",\"w\":\"144\",\"x\":\"440\",\"y\":\"105\",\"zone\":\"pag1_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"inter2bo\",\"page\":\"1\",\"spuid\":\"GYRPUQOAOP\",\"tabindex\":\"8\",\"type\":\"Checkbox\",\"w\":\"104\",\"x\":\"440\",\"y\":\"49\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbvalute\",\"page\":\"1\",\"spuid\":\"BPLIWTTKIK\",\"tabindex\":\"9\",\"type\":\"Checkbox\",\"w\":\"104\",\"x\":\"440\",\"y\":\"77\",\"zone\":\"pag1_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbtipreg\",\"page\":\"1\",\"spuid\":\"DJAYDIHKCT\",\"tabindex\":\"10\",\"type\":\"Checkbox\",\"w\":\"128\",\"x\":\"632\",\"y\":\"49\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbstati\",\"page\":\"1\",\"spuid\":\"GQLSVVBZAE\",\"tabindex\":\"11\",\"type\":\"Checkbox\",\"w\":\"64\",\"x\":\"16\",\"y\":\"77\",\"zone\":\"pag1_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbtipint\",\"page\":\"1\",\"spuid\":\"KAUCYBWKCY\",\"tabindex\":\"12\",\"type\":\"Checkbox\",\"w\":\"128\",\"x\":\"16\",\"y\":\"105\",\"zone\":\"pag1_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbesitoage\",\"page\":\"1\",\"spuid\":\"QYIGQMSMGL\",\"tabindex\":\"13\",\"type\":\"Checkbox\",\"w\":\"88\",\"x\":\"632\",\"y\":\"77\",\"zone\":\"pag1_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbrapp\",\"page\":\"1\",\"spuid\":\"DKJFQFFFCS\",\"tabindex\":\"14\",\"type\":\"Checkbox\",\"w\":\"152\",\"x\":\"632\",\"y\":\"105\",\"zone\":\"pag1_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbstgru\",\"page\":\"1\",\"spuid\":\"NXHTINJEZP\",\"tabindex\":\"15\",\"type\":\"Checkbox\",\"w\":\"184\",\"x\":\"192\",\"y\":\"49\",\"zone\":\"pag1_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbramgru\",\"page\":\"1\",\"spuid\":\"WDDZKXXVRH\",\"tabindex\":\"16\",\"type\":\"Checkbox\",\"w\":\"184\",\"x\":\"192\",\"y\":\"77\",\"zone\":\"pag1_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbtipdoc\",\"page\":\"1\",\"spuid\":\"ESQBNZZTIJ\",\"tabindex\":\"17\",\"type\":\"Checkbox\",\"w\":\"128\",\"x\":\"16\",\"y\":\"133\",\"zone\":\"pag1_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbtipleg\",\"page\":\"1\",\"spuid\":\"KQCTUMJHSZ\",\"tabindex\":\"18\",\"type\":\"Checkbox\",\"w\":\"128\",\"x\":\"192\",\"y\":\"133\",\"zone\":\"pag1_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbtipnat\",\"page\":\"1\",\"spuid\":\"NRFNGQKNRC\",\"tabindex\":\"19\",\"type\":\"Checkbox\",\"w\":\"144\",\"x\":\"440\",\"y\":\"133\",\"zone\":\"pag1_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"84\",\"name\":\"Portlet_DYMVKIQWCA\",\"page\":\"1\",\"src\":\"\\/jsp\\/showmsg_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____DYMVKIQWCA\",\"type\":\"Portlet\",\"w\":\"760\",\"x\":\"16\",\"y\":\"448\",\"zone\":\"pag1_11\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"\",\"h\":\"169\",\"name\":\"Portlet_KQMKKBMXYE\",\"page\":\"1\",\"src\":\"\\/jsp\\/showlog_portlet.jsp?ForcedPortletUID=___com__zucchetti__sitepainter__altinterface__m_cEntityUid____KQMKKBMXYE\",\"type\":\"Portlet\",\"w\":\"760\",\"x\":\"16\",\"y\":\"273\",\"zone\":\"pag1_10\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tberrorisid\",\"page\":\"1\",\"spuid\":\"FPLVARMRZT\",\"tabindex\":\"22\",\"type\":\"Checkbox\",\"w\":\"152\",\"x\":\"16\",\"y\":\"161\",\"zone\":\"pag1_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tberrsiddgn\",\"page\":\"1\",\"spuid\":\"FCJDCGCZMR\",\"tabindex\":\"23\",\"type\":\"Checkbox\",\"w\":\"152\",\"x\":\"192\",\"y\":\"161\",\"zone\":\"pag1_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbricevutesid\",\"page\":\"1\",\"spuid\":\"NOPTJJJCIV\",\"tabindex\":\"24\",\"type\":\"Checkbox\",\"w\":\"152\",\"x\":\"440\",\"y\":\"161\",\"zone\":\"pag1_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbcittna\",\"page\":\"1\",\"spuid\":\"SUYPGBDTZX\",\"tabindex\":\"25\",\"type\":\"Checkbox\",\"w\":\"144\",\"x\":\"632\",\"y\":\"133\",\"zone\":\"pag1_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbstatna\",\"page\":\"1\",\"spuid\":\"YAEKWBHJNU\",\"tabindex\":\"26\",\"type\":\"Checkbox\",\"w\":\"144\",\"x\":\"632\",\"y\":\"161\",\"zone\":\"pag1_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tberrdge\",\"page\":\"1\",\"spuid\":\"PJTUOGFKMR\",\"tabindex\":\"27\",\"type\":\"Checkbox\",\"w\":\"152\",\"x\":\"16\",\"y\":\"189\",\"zone\":\"pag1_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbprvreg\",\"page\":\"1\",\"spuid\":\"NGTLHQAOIU\",\"tabindex\":\"28\",\"type\":\"Checkbox\",\"w\":\"152\",\"x\":\"192\",\"y\":\"189\",\"zone\":\"pag1_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbesielb\",\"page\":\"1\",\"spuid\":\"AZAPSXEAEY\",\"tabindex\":\"29\",\"type\":\"Checkbox\",\"w\":\"152\",\"x\":\"440\",\"y\":\"189\",\"zone\":\"pag1_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"convgio\",\"page\":\"1\",\"spuid\":\"NJLNRHUWKF\",\"tabindex\":\"30\",\"type\":\"Checkbox\",\"w\":\"176\",\"x\":\"16\",\"y\":\"217\",\"zone\":\"pag1_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"staticrs\",\"page\":\"1\",\"spuid\":\"WJYIVNDHCP\",\"tabindex\":\"31\",\"type\":\"Checkbox\",\"w\":\"176\",\"x\":\"192\",\"y\":\"217\",\"zone\":\"pag1_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbcandistr\",\"page\":\"1\",\"spuid\":\"GOZUJRIMWT\",\"tabindex\":\"32\",\"type\":\"Checkbox\",\"w\":\"176\",\"x\":\"440\",\"y\":\"217\",\"zone\":\"pag1_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbluonas\",\"page\":\"1\",\"spuid\":\"UTCLBUQFFR\",\"tabindex\":\"33\",\"type\":\"Checkbox\",\"w\":\"144\",\"x\":\"632\",\"y\":\"189\",\"zone\":\"pag1_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"tbprovsv\",\"page\":\"1\",\"spuid\":\"QLYYYUZTMV\",\"tabindex\":\"34\",\"type\":\"Checkbox\",\"w\":\"152\",\"x\":\"632\",\"y\":\"217\",\"zone\":\"pag1_8\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"25\",\"href\":\"javascript:LTWONWESXG_Click()\",\"name\":\"Esegui\",\"page\":\"1\",\"spuid\":\"LTWONWESXG\",\"tabindex\":\"35\",\"type\":\"Button\",\"value\":\"Esegui\",\"w\":\"88\",\"x\":\"600\",\"y\":\"14\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"name\":\"rapogg\",\"page\":\"1\",\"spuid\":\"NOMTMIMOQE\",\"tabindex\":\"36\",\"type\":\"Checkbox\",\"w\":\"176\",\"x\":\"16\",\"y\":\"245\",\"zone\":\"pag1_9\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void Next(ServletStatus status,arpg_imp_newtabsBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_imp_newtabsBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_imp_newtabsBO BO,ServletStatus status) {
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
     "<script src='arpg_imp_newtabs?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
     "<script src='SPPrxy/"+m_cEntityUid+"/arpg_imp_newtabs_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(537,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
  void RaiseLoadedEntity(arpg_imp_newtabsBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_imp_newtabsBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(arpg_imp_newtabsBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(arpg_imp_newtabsBO BO,ServletStatus status) {
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
  void WriteExitPage(arpg_imp_newtabsBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(arpg_imp_newtabsBO BO,ServletStatus status) {
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
      imp_newtabs_mt.GetCallableNames(callable);
      imp_newtabs.GetCallableNames(callable);
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,arpg_imp_newtabsBO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,arpg_imp_newtabsBO BO) {
    boolean result = true;
    return result;
  }
}
