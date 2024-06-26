import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class arpg_info_pre_prn_scheda_adeguata_ver_clientela extends SPDialogServlet implements SPInvokable {
  public static String m_cEntityUid = "!*KKQFOCGHGT*!";
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
    arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO;
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
    return "Informazioni Preliminari per stampa scheda di verifica adeguata clientela";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "arpg_info_pre_prn_scheda_adeguata_ver_clientela";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 661;
    l_eg.m_nEntityHeight = 278;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"personbo"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.items = new SPItem[]{
                   new SPItem("mpa","N",1,0, "edit","Scheda Vuota"),
                   new SPItem("neo","N",1,0, "edit",""),
                   new SPItem("ana","N",1,0, "edit","Solo dati Anagrafici"),
                   new SPItem("cod","C",16,0, "edit",""),
                   new SPItem("SESSO","C",1,0, "hide",""),
                   new SPItem("xragisoc","C",70,0, "hide","ragione sociale"),
                   new SPItem("RAGSOCM","C",70,0, "hide",""),
                   new SPItem("CONNES","C",16,0, "hide",""),
                   new SPItem("CFESTERO","N",1,0, "hide","codice fiscale fittizio"),
                   new SPItem("CODFISC","C",16,0, "hide","Codice Fiscale"),
                   new SPItem("PARTIVA","C",14,0, "hide","Partita iva"),
                   new SPItem("vcam","N",1,0, "edit","")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO) {
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
    l_translations=new String[][]{{"10662833179",p_Context.Translate("ragione sociale")},
    {"11237762887",p_Context.Translate("Informazioni Preliminari per stampa scheda di verifica adeguata clientela")},
    {"11597981018",p_Context.Translate("Chiudi la finestra")},
    {"11921223220",p_Context.Translate("Codice Fiscale")},
    {"12038347288",p_Context.Translate("Scheda Vuota")},
    {"12087878251",p_Context.Translate("codice fiscale fittizio")},
    {"1660347783",p_Context.Translate("Acquisita Visura Camerale")},
    {"1756438825",p_Context.Translate("Partita iva")},
    {"1779746634",p_Context.Translate("Stampa la scheda di verifica")},
    {"809926818",p_Context.Translate("Solo dati Anagrafici")}};
    return l_translations;
  }
  void WriteStyles(arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='SPPrxy/"+m_cEntityUid+"/arpg_info_pre_prn_scheda_adeguata_ver_clientela.css'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+status.m_cTheme+"/spadministration_security.css'>" +
      "");
    }
  }
  void WriteMainForm(arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO,ServletStatus status) {
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
  void WriteControls(arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
  }
  void WriteControls_p1(arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO,ServletStatus status) {
    status.themeWriter.Header_BeginHtml(273);
    WriteControls_1_h_0(BO,status);
  }
  void WriteControls_1_h_0(arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO,ServletStatus status) {
    status.out.println(
     "<div id='FXEGLMMZZE_DIV' class='UntitledBox'>" +
     "<div id='FXEGLMMZZE' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='HNOHSVFLOQ_DIV'>" +
     "<input name='mpa' id='HNOHSVFLOQ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_mpa,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_mpa)?"CHECKED":"")+">" +
     "<label id='HNOHSVFLOQ_LBL' for='HNOHSVFLOQ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Scheda Vuota"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XUMEHEGWFS_DIV'>" +
     "<label id='XUMEHEGWFS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("INFORMAZIONI PRELIMINARI"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<div id='MTKUDOZPWO_DIV' class='UntitledBox'>" +
     "<div id='MTKUDOZPWO' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<div id='GMCWGKWJAP_DIV'>" +
     "<div id='GMCWGKWJAP_0_container'>" +
     "<input id='GMCWGKWJAP_0' name='GMCWGKWJAP' type='radio' value="+SPLib.ToHTMLValue(0,"N",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(0,BO.w_neo)?"CHECKED":"")+">" +
     "<label class='SPLabel' for='GMCWGKWJAP_0'>"+status.context.Translate("Nuovo cliente")+"</label>" +
     "</div>" +
     "<div id='GMCWGKWJAP_1_container'>" +
     "<input id='GMCWGKWJAP_1' name='GMCWGKWJAP' type='radio' value="+SPLib.ToHTMLValue(1,"N",1,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_neo)?"CHECKED":"")+">" +
     "<label class='SPLabel' for='GMCWGKWJAP_1'>"+status.context.Translate("Cliente gi� acquisito")+"</label>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='DWLJVFRPWC_DIV' style='display:none'>" +
     "<input name='ana' id='DWLJVFRPWC' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_ana,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_ana)?"CHECKED":"")+">" +
     "<label id='DWLJVFRPWC_LBL' for='DWLJVFRPWC' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Solo dati Anagrafici"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='cod' id='QCPAGAIRIU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_cod,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C' style='display:none'>" +
     "<button id='QCPAGAIRIU_ZOOM' type='button' class='ZoomButtonEnabled' tabindex='-1' onkeydown='ManageKeys(event,false,false,true)' onclick='QCPAGAIRIU_ZOOM_Click()' style='display:none'>" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YRBRMQSERG_DIV' style='display:none'>" +
     "<label id='YRBRMQSERG'>" +
     ""+SPLib.ToHTMLRepresentation("Indicare il legale Rappresentante della societ� "+BO.w_RAGSOCM+":")+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TXJKEDTKOL_DIV' style='display:none'>" +
     "<label id='TXJKEDTKOL'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xragisoc)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_AAQUHMAIVT()' tabindex='-1' id='AAQUHMAIVT_HREF'>" +
     "<img id='AAQUHMAIVT' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/print.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Stampa la scheda di verifica"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Stampa la scheda di verifica"),"C",0,0)+">" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='DWNCHDOZIE_DIV' style='display:none'>" +
     "<input name='vcam' id='DWNCHDOZIE' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_vcam,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_vcam)?"CHECKED":"")+">" +
     "<label id='DWNCHDOZIE_LBL' for='DWNCHDOZIE' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Acquisita Visura Camerale"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_SEPYAQKCQK()' tabindex='-1' id='SEPYAQKCQK_HREF'>" +
     "<img id='SEPYAQKCQK' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/exit.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Chiudi la finestra"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Chiudi la finestra"),"C",0,0)+">" +
     "</a>" +
    "");
    status.themeWriter.Header_EndHtml();
  }
  static void PrintState(arpg_info_pre_prn_scheda_adeguata_ver_clientelaBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(arpg_info_pre_prn_scheda_adeguata_ver_clientelaBL BO,ServletStatus status) {
  }
  static void PrintStateWorkVars(arpg_info_pre_prn_scheda_adeguata_ver_clientelaBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_mpa,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_neo,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ana,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_cod,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SESSO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragisoc,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAGSOCM,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNES,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CFESTERO,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODFISC,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PARTIVA,"C",14,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_vcam,"N",1,0));
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_YRBRMQSERG = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_TXJKEDTKOL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(278,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(661,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"arpg_info_pre_prn_scheda_adeguata_ver_clientela"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    status.out.print("'QCPAGAIRIU':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("CONNESCONNES,RAGSOCC,Cpersonbo",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"pers_fisiche",l_session)+"'"+"]");
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
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"arpg_info_pre_prn_scheda_adeguata_ver_clientela","");
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
  void WriteMainFormScript(arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO,ServletStatus status) {
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
  arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO getBO(ServletStatus status) {
    arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO = new arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO) {
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Start(ServletStatus status,arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO) {
    BO.SetFromContext(status.m_cWv);
  }
  void Save(ServletStatus status,arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO) {
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
  void Discard(ServletStatus status,arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO) {
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",278);
    item.put("w",661);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","false");
    item.put("altInterfaceFor","arpg_info_pre_prn_scheda_adeguata_ver_clientela");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"266\",\"name\":\"Box_FXEGLMMZZE\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"FXEGLMMZZE\",\"tabindex\":\"1\",\"type\":\"Box\",\"w\":\"648\",\"x\":\"8\",\"y\":\"7\",\"zone\":\"pag1_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Scheda Vuota\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"24\",\"name\":\"mpa\",\"page\":\"1\",\"spuid\":\"HNOHSVFLOQ\",\"tabindex\":\"2\",\"type\":\"Checkbox\",\"w\":\"104\",\"x\":\"280\",\"y\":\"49\",\"zone\":\"FXEGLMMZZE_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"26\",\"href\":\" \",\"name\":\"INFORMAZIONI_PRELIMINARI\",\"page\":\"1\",\"spuid\":\"XUMEHEGWFS_DIV\",\"tabindex\":\"3\",\"type\":\"Label\",\"value\":\"INFORMAZIONI PRELIMINARI\",\"w\":\"648\",\"x\":\"8\",\"y\":\"14\",\"zone\":\"FXEGLMMZZE_6\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_type\":\"\",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"49\",\"name\":\"Box_MTKUDOZPWO\",\"page\":\"1\",\"shrinkable\":\"true\",\"spuid\":\"MTKUDOZPWO\",\"tabindex\":\"4\",\"type\":\"Box\",\"w\":\"160\",\"x\":\"248\",\"y\":\"105\",\"zone\":\"FXEGLMMZZE_7\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"42\",\"name\":\"neo\",\"orientation\":\"vertical\",\"page\":\"1\",\"spuid\":\"GMCWGKWJAP\",\"tabindex\":\"5\",\"textlist\":\"Nuovo cliente,Cliente gi\\u00E0 acquisito\",\"type\":\"Radio\",\"valuelist\":\"0,1\",\"w\":\"136\",\"x\":\"264\",\"y\":\"112\",\"zone\":\"MTKUDOZPWO_1\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Solo dati Anagrafici\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"24\",\"name\":\"ana\",\"page\":\"1\",\"spuid\":\"DWLJVFRPWC\",\"tabindex\":\"6\",\"type\":\"Checkbox\",\"w\":\"136\",\"x\":\"264\",\"y\":\"77\",\"zone\":\"FXEGLMMZZE_2\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"23\",\"maxlength\":\"16\",\"name\":\"cod\",\"page\":\"1\",\"spuid\":\"QCPAGAIRIU\",\"tabindex\":\"7\",\"type\":\"Textbox\",\"w\":\"126\",\"x\":\"24\",\"y\":\"231\",\"zone\":\"FXEGLMMZZE_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"19\",\"href\":\" \",\"name\":\"_Indicare_il_legale_Rappresentante_della_societ\\u00E0___w_RAGSOCM____\",\"page\":\"1\",\"spuid\":\"YRBRMQSERG_DIV\",\"tabindex\":\"8\",\"type\":\"Label\",\"value\":\""+"'"+"Indicare il legale Rappresentante della societ\\u00E0 "+"'"+"+w_RAGSOCM+"+"'"+":"+"'"+"\",\"w\":\"616\",\"x\":\"24\",\"y\":\"210\",\"zone\":\"FXEGLMMZZE_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"left\",\"bg_color\":\" \",\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"21\",\"href\":\" \",\"name\":\"w_xragisoc\",\"page\":\"1\",\"spuid\":\"TXJKEDTKOL_DIV\",\"tabindex\":\"11\",\"type\":\"Label\",\"value\":\"w_xragisoc\",\"w\":\"464\",\"x\":\"176\",\"y\":\"231\",\"zone\":\"FXEGLMMZZE_4\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Stampa la scheda di verifica\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"35\",\"href\":\"javascript:href_AAQUHMAIVT()\",\"name\":\"images_print_gif\",\"page\":\"1\",\"spuid\":\"AAQUHMAIVT\",\"src\":\"images\\/print.gif\",\"tabindex\":\"13\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"552\",\"y\":\"231\",\"zone\":\"FXEGLMMZZE_5\"}";
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
    s = "{}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"24\",\"name\":\"vcam\",\"page\":\"1\",\"spuid\":\"DWNCHDOZIE\",\"tabindex\":\"18\",\"type\":\"Checkbox\",\"w\":\"192\",\"x\":\"248\",\"y\":\"161\",\"zone\":\"FXEGLMMZZE_3\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"class_Css\":\" \",\"comment\":\"Chiudi la finestra\",\"font\":\" \",\"font_color\":\" \",\"font_size\":\" \",\"font_weight\":\" \",\"h\":\"35\",\"href\":\"javascript:href_SEPYAQKCQK()\",\"name\":\"images_exit_gif\",\"page\":\"1\",\"spuid\":\"SEPYAQKCQK\",\"src\":\"images\\/exit.gif\",\"tabindex\":\"19\",\"type\":\"Image\",\"w\":\"40\",\"x\":\"608\",\"y\":\"231\",\"zone\":\"FXEGLMMZZE_5\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void Next(ServletStatus status,arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow+entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void Previous(ServletStatus status,arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO) {
    BO.SetFromContext(status.m_cWv);
    status.m_nStartRow = status.m_nStartRow-entityGlobals.m_nRowsPerPage;
    status.m_cClientMode = "edit";
  }
  void WriteFormPage(arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO,ServletStatus status) {
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
     "<script src='arpg_info_pre_prn_scheda_adeguata_ver_clientela?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
     "<script src='SPPrxy/"+m_cEntityUid+"/arpg_info_pre_prn_scheda_adeguata_ver_clientela_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(278,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
  void RaiseLoadedEntity(arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO,ServletStatus status) {
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
  void WriteExitPage(arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  void IncludeJS(ServletStatus status) {
    String l_cJsUid;
    status.out.println(
     "<script src='SPPrxy/"+arrt_stp_scheda_di_verifica.m_cEntityUid+"/arrt_stp_scheda_di_verifica.js'>" +
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
      arrt_stp_scheda_di_verifica.GetCallableNames(callable);
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO) {
    return "NO_VALUE";
  }
  public boolean CheckVars(ServletStatus status,arpg_info_pre_prn_scheda_adeguata_ver_clientelaBO BO) {
    boolean result = true;
    return result;
  }
}
