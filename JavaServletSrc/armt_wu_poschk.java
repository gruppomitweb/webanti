import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_wu_poschk extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*e3b62953*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "wuposchk";
    }
    public String w_CPCODMAG;
    public String w_CPCODAJW;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_CPCODMAG,context,"wuposchk","CPCODMAG","C",5,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_CPCODAJW,context,"wuposchk","CPCODAJW","C",9,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
      }
    }
    void FillParameters() {
      m_Parameters = source.GetParametersProperties();
      m_cWv = (CPLib.gt(m_Parameters.size(),0)?"_not_empty_":"");
    }
    public void MergeCallerVars(SPParameterSource source) {
    }
    public void WriteSenderFormPKVars() {
      ServletStatus status = this;
      if (CPLib.eq(m_cClientMode,"query") || CPLib.eq(m_cClientMode,"view")) {
        status.out.println(
         "<input name='CPCODMAG' type='hidden' value="+SPLib.ToHTMLValue(w_CPCODMAG,"C",5,0)+">" +
        "");
        status.out.println(
         "<input name='CPCODAJW' type='hidden' value="+SPLib.ToHTMLValue(w_CPCODAJW,"C",9,0)+">" +
        "");
      }
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
    armt_wu_poschkBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_wuposchk;
    if (CPLib.eq(status.m_cAction,"start")) {
      status.m_cMode = "";
      status.m_cClientMode = "query";
      BO.Blank();
    } else if (CPLib.eq(status.m_cAction,"query")) {
      Query(status,BO);
      LoadCurrentRecord(status,BO);
    } else if (CPLib.eq(status.m_cAction,"view")) {
      View(status,BO);
    } else if (CPLib.eq(status.m_cAction,"first")) {
      MoveTo(status,1);
      LoadCurrentRecord(status,BO);
    } else if (CPLib.eq(status.m_cAction,"previous")) {
      MoveTo(status,status.m_nRecPos-1);
      LoadCurrentRecord(status,BO);
    } else if (CPLib.eq(status.m_cAction,"next")) {
      MoveTo(status,status.m_nRecPos+1);
      LoadCurrentRecord(status,BO);
    } else if (CPLib.eq(status.m_cAction,"last")) {
      MoveTo(status,status.m_nLastRec);
      LoadCurrentRecord(status,BO);
    } else if (CPLib.eq(status.m_cAction,"moveto")) {
      LoadCurrentRecord(status,BO);
    } else if (CPLib.eq(status.m_cAction,"edit")) {
      Edit(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"editload")) {
      EditLoad(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"write")) {
      Write(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"writeload")) {
      Write(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"new")) {
      New(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"save")) {
      Save(status,BO);
    } else if (CPLib.eq(status.m_cAction,"discard")) {
      Discard(status,BO);
    } else if (CPLib.eq(status.m_cAction,"delete")) {
      Delete(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"deletemessage")) {
      DeleteMessage(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"painter")) {
      Painter(status);
    } else if (CPLib.eq(status.m_cAction,"autozoom")) {
      OpenZoom(status,source);
    } else if (CPLib.eq(status.m_cAction,"zoom")) {
      OpenPSZoom(status,source);
    }
    // * --- Area Manuale = Do Action
    // * --- Fine Area Manuale
    //  status.m_cClientMode: stato che deve assumere il client
    //  status.m_bError: indica se si e' verificato un errore
    //  status.m_bExit: indica se e' un punto di uscita
    //  status.m_cAtExit: azione di uscita
    Forward localForward = Forward.Unforwarded;
    if ( ! (status.m_bExit) || CPLib.Empty(status.m_cAtExit)) {
    } else if (CPLib.eq(CPLib.Left(status.m_cAtExit,8),"workflow")) {
      ExitToWorkflow(status);
    } else if (CPLib.eq(CPLib.Left(status.m_cAtExit,8),"activity")) {
      ExitToActivity(status,BO);
    } else if (status.m_bError && CPLib.ne(status.m_cClientMode,"bringback")) {
      // Il programma da eseguire in uscita non sa come visualizzare l' errore, viene quindi lanciata la pagina di errore che poi eseguira' il programma di uscita
      status.m_cClientMode = "error";
    } else if (status.m_bError) {
    } else if (CPLib.eq(status.m_cAtExit,"new")) {
      status.CleanInterfaceSettings();
      New(status,BO,source);
    } else if (CPLib.eq(status.m_cAtExit,"edit")) {
      status.w_CPCODMAG = BO.w_CPCODMAG;
      status.w_CPCODAJW = BO.w_CPCODAJW;
      BO.Initialize();
      Edit(status,BO,source);
    } else if (CPLib.eq(status.m_cAtExit,"autozoom")) {
      // Si puo' proseguire con lo zoom
      OpenZoom(status,source);
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
    // ora interpreta la seconda parte del workflow (i vari set sull' oggetto reale)
    ExecuteWorkflowStartingScript(status,BO);
    // Ora manda la pagina di risposta
    NotifyEvent("Response start",status,BO);
    if (Forward.IsForwarded(status.forwardedto)) {
      SPLib.ForwardTo(status.forwardedto,servletContext,status.request,status.response);
      return;
    }
    SPLib.SetContentType(response);
    if ("get".equalsIgnoreCase(request.getMethod())) {
      SPLib.NoCache(response);
    }
    status.out = response.getWriter();
    if (CPLib.eq(status.m_cClientMode,"error")) {
      WriteErrorPage(status);
    } else if (CPLib.eq(status.m_cClientMode,"close")) {
      WriteExitPage(BO,status,localForward);
    } else if (CPLib.eq(status.m_cClientMode,"bringback")) {
      BringBackPage(BO,status);
    } else if (CPLib.eq(status.m_cAction,"createportlet")) {
      CreatePortlet(status,BO);
    } else {
      WriteFormPage(BO,status);
    }
  }
  public String getEntityTitle() {
    return "Import POS";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_wu_poschk";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 499;
    l_eg.m_nEntityHeight = 442;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"wuposchk"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"CPCODMAG","CPCODAJW"};
    l_eg.items = new SPItem[]{
                   new SPItem("CPCODMAG","C",5,0, "edit","Codice Macro Agente"),
                   new SPItem("CPCODAJW","C",9,0, "edit","AJW Agenzia"),
                   new SPItem("CPRAGSOC","C",30,0, "edit","Ragione Sociale"),
                   new SPItem("CPDOMICI","C",40,0, "edit","Domicilio"),
                   new SPItem("CP_CITTA","C",30,0, "edit","Citt�"),
                   new SPItem("CPERR_01","C",60,0, "edit","Errore 1"),
                   new SPItem("CPERR_02","C",60,0, "edit","Errore 2"),
                   new SPItem("CPERR_03","C",60,0, "edit","Errore 3"),
                   new SPItem("CPERR_04","C",60,0, "edit","Errore 4"),
                   new SPItem("CPERR_05","C",60,0, "edit","Errore 5"),
                   new SPItem("CPERR_06","C",60,0, "edit","Errore 6"),
                   new SPItem("CPERR_07","C",60,0, "edit","Errore 7"),
                   new SPItem("CPERR_08","C",60,0, "edit","Errore 8"),
                   new SPItem("CPERR_09","C",60,0, "edit","Errore 9"),
                   new SPItem("CPERR_10","C",60,0, "edit","Errore 10"),
                   new SPItem("CPFLGCOR","C",1,0, "edit","Flag Corretta"),
                   new SPItem("CPFLGFOR","C",1,0, "edit","Flag Forzatura")
                 };
    l_eg.m_lHasHistorical = false;
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_wu_poschkBO BO) {
    CPMNTChild[] l_MNTs = BO.m_MNTs;
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
    l_translations=new String[][]{{"10662833243",p_Context.Translate("Ragione Sociale")},
    {"11228314267",p_Context.Translate("Errore 9")},
    {"11309552526",p_Context.Translate("Codice Macro Agente")},
    {"11496749723",p_Context.Translate("Errore 8")},
    {"11710185840",p_Context.Translate("Flag Forzatura")},
    {"11765185179",p_Context.Translate("Errore 7")},
    {"11816161592",p_Context.Translate("Flag Corretta")},
    {"1187604837",p_Context.Translate("Errore 2")},
    {"12033620635",p_Context.Translate("Errore 6")},
    {"1270072299",p_Context.Translate("AJW Agenzia")},
    {"1456040293",p_Context.Translate("Errore 3")},
    {"15186643",p_Context.Translate("Citt�")},
    {"1724475749",p_Context.Translate("Errore 4")},
    {"1992911205",p_Context.Translate("Errore 5")},
    {"49939619",p_Context.Translate("Domicilio")},
    {"666463384",p_Context.Translate("Import POS")},
    {"919169381",p_Context.Translate("Errore 1")},
    {"919169429",p_Context.Translate("Errore 10")}};
    return l_translations;
  }
  void WriteStyles(armt_wu_poschkBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_wu_poschk.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_wu_poschkBO BO,ServletStatus status) {
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
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println(
       "<div id='tabsContainer'>" +
       " " +
       "</div>" +
      "");
    }
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      status.request.setAttribute("com__zucchetti__sitepainter__altinterface__url",status.m_cAltInterface);
      status.request.setAttribute("com__zucchetti__sitepainter__altinterface__m_cEntityUid",m_cEntityUid);
      SPLib.Include(servletContext,status,status.m_cAltInterface);
    } else {
      WriteControls(BO,status);
    }
    status.out.println(
     "<script>" +
    "");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("if ( ! (Z.Tabs.Has('tabs'))) {");
      status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("MSG_PAGE_NUMBER","1"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
      status.out.println("Z.Tabs.Set('tabs',tabs);");
      status.out.println("} else {");
      status.out.println("var tabs = Z.Tabs.Get('tabs')");
      status.out.println("}");
      AddExtendedTabs(status);
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_wu_poschk',false);");
    }
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_wu_poschk",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(armt_wu_poschkBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,2);
  }
  void WriteControls_p1(armt_wu_poschkBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:442px;width:499px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"PAGE_1");
    PrintSidebarContent(1,status,getSidebarItems(0),false);
    PrintContextMenu(1,status,getContextMenu(0),"");
    status.out.println(
     "</div>" +
    "");
    if ( ! (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,""))) {
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('page_1').style.display='block';");
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteControls_p1_b0(armt_wu_poschkBO BO,ServletStatus status) {
    status.out.println(
     "<div style='position:relative;height:442px'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CPCODMAG' id='BUQHTQZEWF' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_CPCODMAG,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='5' size='5' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel PrimaryKeyLabel' id='FGJGISOCRH_DIV'>" +
     "<label id='FGJGISOCRH' for='BUQHTQZEWF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Macro Agente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CPCODAJW' id='PUGRYTGEHQ' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_CPCODAJW,"C",9,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='9' size='9' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel PrimaryKeyLabel' id='RLMKMBMYWN_DIV'>" +
     "<label id='RLMKMBMYWN' for='PUGRYTGEHQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("AJW Agenzia:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CPRAGSOC' id='FFNWZCKHDB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CPRAGSOC,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UUZFJIKNDH_DIV'>" +
     "<label id='UUZFJIKNDH' for='FFNWZCKHDB'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Ragione Sociale:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CPDOMICI' id='VAFIDWPHCA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CPDOMICI,"C",40,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='40' size='40' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XVALWRRSQW_DIV'>" +
     "<label id='XVALWRRSQW' for='VAFIDWPHCA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Domicilio:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CP_CITTA' id='PHXZPOWUHE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CP_CITTA,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FBJUZQYAYI_DIV'>" +
     "<label id='FBJUZQYAYI' for='PHXZPOWUHE'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Citt�:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CPERR_01' id='XPYTVNWCHO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CPERR_01,"C",60,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='60' size='60' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FUFCACTQCQ_DIV'>" +
     "<label id='FUFCACTQCQ' for='XPYTVNWCHO'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 1:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CPERR_02' id='VFFCZHRBSV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CPERR_02,"C",60,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='60' size='60' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='WVGTEDJQXS_DIV'>" +
     "<label id='WVGTEDJQXS' for='VFFCZHRBSV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 2:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CPERR_03' id='YFVSZTUKFJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CPERR_03,"C",60,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='60' size='60' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='GNJKEPAFQG_DIV'>" +
     "<label id='GNJKEPAFQG' for='YFVSZTUKFJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 3:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CPERR_04' id='FBLLPINCSQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CPERR_04,"C",60,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='60' size='60' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MYIBJOKLHM_DIV'>" +
     "<label id='MYIBJOKLHM' for='FBLLPINCSQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 4:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CPERR_05' id='NREHZLHXUK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CPERR_05,"C",60,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='60' size='60' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RONDZMRNWA_DIV'>" +
     "<label id='RONDZMRNWA' for='NREHZLHXUK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 5:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CPERR_06' id='WMBIMGHLXA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CPERR_06,"C",60,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='60' size='60' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TOTPAIZNJM_DIV'>" +
     "<label id='TOTPAIZNJM' for='WMBIMGHLXA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 6:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CPERR_07' id='MUIQATNACU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CPERR_07,"C",60,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='60' size='60' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IENYFAVPAY_DIV'>" +
     "<label id='IENYFAVPAY' for='MUIQATNACU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 7:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CPERR_08' id='MCFYJRFQLY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CPERR_08,"C",60,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='60' size='60' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RLVBRMKVLK_DIV'>" +
     "<label id='RLVBRMKVLK' for='MCFYJRFQLY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 8:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CPERR_09' id='FVWFZMVAXM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CPERR_09,"C",60,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='60' size='60' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UDNLAIKCZT_DIV'>" +
     "<label id='UDNLAIKCZT' for='FVWFZMVAXM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 9:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CPERR_10' id='FBNHYNDMJM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CPERR_10,"C",60,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='60' size='60' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='URAFRLWJGA_DIV'>" +
     "<label id='URAFRLWJGA' for='FBNHYNDMJM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 10:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CPFLGCOR' id='UPIBHMCFWQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CPFLGCOR,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='1' size='1' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TLSSWSIGYB_DIV'>" +
     "<label id='TLSSWSIGYB' for='UPIBHMCFWQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Flag Corretta:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CPFLGFOR' id='VQBNKYNPCH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CPFLGFOR,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='1' size='1' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NKHUJTBNTZ_DIV'>" +
     "<label id='NKHUJTBNTZ' for='VQBNKYNPCH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Flag Forzatura:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  static void PrintState(armt_wu_poschkBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_wu_poschkBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
  }
  static void PrintStateWorkVars(armt_wu_poschkBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_CPCODMAG,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPCODAJW,"C",9,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPRAGSOC,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPDOMICI,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CP_CITTA,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPERR_01,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPERR_02,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPERR_03,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPERR_04,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPERR_05,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPERR_06,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPERR_07,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPERR_08,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPERR_09,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPERR_10,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPFLGCOR,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPFLGFOR,"C",1,0));
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_wu_poschkBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(442,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(499,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_wu_poschk"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      AppendCallableIDS(status,"");
    } else {
      AppendCallableIDS(status,"");
    }
    status.out.println("}");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      if (CPLib.IsNull(status.m_CheckVars)) {
        status.out.print("var m_CheckVars={");
        status.out.print("'_':"+SPLib.ToJSValue(GetCheckVars(status, BO, m_cEntityUid),"C",0,0));
        status.out.println("}");
      } else {
        status.out.print("var m_CheckVars=");
        status.m_CheckVars.write(status.out);
        status.out.println(";");
      }
    }
    if (CPLib.eq(status.context.GetGlobalString("IsSPAdministrationInstalled"),"yes") && CPLib.IsAdministrator(status.context) && status.context.HasAdministeredUsers()) {
      status.out.println("var m_cProgName = " + SPLib.ToJSValue(entityGlobals.name,"C",0,0)+ ";");
    } else {
      status.out.println("Zoom.p="+SPLib.ToJSValue(entityGlobals.name,"C",0,0)+";");
    }
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_wu_poschk","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_wu_poschk",BO.GetCurrentState());
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
    status.out.println("var m_cFunction = " + SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+ ";");
    status.out.println("var m_cDataLanguage = " + SPLib.ToJSValue(CPLib.Upper(BO.m_Ctx.GetDataLanguage()),"C",0,0)+ ";");
    status.out.println("var m_cOldCPCCCHK = " + SPLib.ToJSValue(BO.m_cOldCPCCCHK,"C",0,0)+ ";");
    status.out.println("var m_bLoaded = " + SPLib.ToJSValue(BO.m_bLoaded,"L",0,0)+ ";");
    status.out.println("var m_cPrvsStt = " + SPLib.ToJSValue(BO.m_cPreviousState,"C",0,0)+ ";");
    status.out.println("var m_FoundlingCopyWorkVar;");
    status.out.println("m_FoundlingCopyWorkVar=[];");
    status.out.println("var m_FoundlingHideExpression;");
    status.out.println("m_FoundlingHideExpression=[];");
    status.out.println("var m_FoundlingEditExpression;");
    status.out.println("m_FoundlingEditExpression=[];");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("var m_nLastError = " + SPLib.ToJSValue(0,"I",0,0)+ ";");
      status.out.println("var m_cObblFieldName = " + SPLib.ToJSValue("","C",0,0)+ ";");
      status.out.println("var m_cLastMsgError = " + SPLib.ToJSValue("","C",0,0)+ ";");
      status.out.println("var m_cLastWorkVarError = " + SPLib.ToJSValue("","C",0,0)+ ";");
      status.out.println("var m_cLastWorkVarErrorMsg = " + SPLib.ToJSValue("","C",0,0)+ ";");
    } else {
      status.out.println("var m_nLastRec = " + SPLib.ToJSValue(status.m_nLastRec,"N",0,0)+ ";");
      status.out.println("var m_nRecPos = " + SPLib.ToJSValue(status.m_nRecPos,"N",0,0)+ ";");
      status.out.println("var m_cVirtName = " + SPLib.ToJSValue(status.m_cVirtName,"C",0,0)+ ";");
    }
    WriteExtendedFieldsVars(BO.extendedFields,status);
    status.out.println("// * --- Area Manuale = UI - Declare Variables");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteMainFormScript(armt_wu_poschkBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_wu_poschk',false);");
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('BUQHTQZEWF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PUGRYTGEHQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FFNWZCKHDB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VAFIDWPHCA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PHXZPOWUHE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XPYTVNWCHO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VFFCZHRBSV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YFVSZTUKFJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FBLLPINCSQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NREHZLHXUK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WMBIMGHLXA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MUIQATNACU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MCFYJRFQLY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FVWFZMVAXM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FBNHYNDMJM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UPIBHMCFWQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VQBNKYNPCH')) SetDisabled(c,true);");
      }
      status.out.println("HideControlsUnderCondition();");
    }
    status.out.println("if ( ! (Empty(m_cLayerInterface))) {");
    status.out.println("SubstituteInterface(m_cLayerInterface);");
    status.out.println("}");
    if (status.m_bError) {
      status.out.println("HideLoadingLayer();");
      status.out.println("WindowAlert(showed_database_error);");
      status.out.println("HideLoadingLayer(false);");
    }
    if ( ! (status.m_bHasRS)) {
      status.out.println("SetRegionalSettings();");
    }
    status.out.println("ReloadMenu();");
    status.out.println("setEventHandlers(false);");
    if (CPLib.ne(status.m_cClientMode,"view")) {
      status.out.println("FocusFirstComponent();");
    }
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('BUQHTQZEWF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PUGRYTGEHQ')) SetDisabled(c,true);");
      }
    }
    status.out.println("FillCombosValues();");
    status.out.println("SetControlsValue();");
    status.out.println("NotifyEvent('Record Loaded');");
    if (status.HasFoundlingChildren()) {
      status.out.println("LoadContext();");
    }
    status.out.println("// * --- Area Manuale = UI - OnLoad End");
    status.out.println("// * --- Fine Area Manuale");
    RaiseLoadedEntity(BO,status);
    status.out.println("CalculateAndResizeEntityHeight();");
    status.out.println("HideLoadingLayer();");
    if (status.is_live_editing) {
      status.out.println("CreateAltInterfaceEditTool(" + SPLib.ToJSValue(entityGlobals.name,"C",0,0) + ");");
    }
    if (status.m_bShowBOWarnings) {
      status.out.println("SubmitListenerForm(" + SPLib.ToJSValue(status.m_cAction,"C",0,0) + ");");
    }
    status.out.println("}");
    status.out.println("function ChildSelectedPage(name) {");
    status.out.println("var l_cRes = '';");
    ChildSelectedPageChild(BO.m_MNTs,status,status.m_cSelectedPage);
    status.out.println("}");
    WriteJSError(status);
    WriteTableCombo(status,BO);
    status.out.println("// * --- Area Manuale = UI - Functions & Procedures");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  armt_wu_poschkBO getBO(ServletStatus status) {
    armt_wu_poschkBO BO = new armt_wu_poschkBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_wu_poschkBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("wuposchk",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_wu_poschkBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_wu_poschkBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
  }
  CPResultSet QueryKeyCursor(armt_wu_poschkBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_wuposchk;
    String l_cPhName = BO.m_cPhName_wuposchk;
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altres� come
    // parametro la clausola di "order by".
    // * --- Area Manuale = BO - Query Key Set Init
    // * --- Fine Area Manuale
    int l_nIdx;
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_wu_poschkBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_wuposchk+".CPCODMAG, "+BO.m_cVirtName_wuposchk+".CPCODAJW",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    } else {
      l_rsKeys = new CPResultSet();
    }
    l_nIdx = 1;
    while (CPLib.lt(l_nIdx,status.m_nRecPos) &&  ! (l_rsKeys.Eof())) {
      l_rsKeys.Next();
      l_nIdx = l_nIdx+1;
    }
    // * --- Area Manuale = BO - Query Key Set End
    // * --- Fine Area Manuale
    return l_rsKeys;
  }
  CPResultSet QueryKeyCursor(SPMasterServletStatus status) {
    String l_cServer = status.context.GetServer("wuposchk");
    String l_cPhName = CPSql.ManipulateTablePhName("wuposchk",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altres� come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".CPCODMAG, "+l_cPhName+".CPCODAJW",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,armt_wu_poschkBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_wu_poschkBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_wuposchk,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_wuposchk,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
      try {
        status.m_nLastRec = l_rsCount.GetInt("reccount");
        if (CPLib.eq(status.m_nLastRec,0)) {
          status.m_nRecPos = 0;
        } else {
          status.m_nRecPos = 1;
        }
      } finally {
        l_rsCount.Close();
      }
    } else {
      status.m_nRecPos = 0;
      status.m_nLastRec = 0;
    }
    status.m_cMode = "";
  }
  void View(ServletStatus status,armt_wu_poschkBO BO) {
    String _m = status.m_cMode;
    if ( ! (BO.m_bLoaded)) {
      Query(status,BO);
      LoadCurrentRecord(status,BO);
    }
    if ( ! (status.m_bError) &&  ! (BO.m_bLoaded) && CPLib.ne(_m,"empty")) {
      status.m_cErrMsg = "MSG_RECORD_NOT_FOUND";
      status.m_bError = true;
      status.m_bExit = true;
      if ( ! (CPLib.Empty(status.m_cAtExit)) && HasMarker(status,"@ERROR")) {
        // valorizzazione dei placeholder del workflow: qui e' gia' valorizzato status.m_cErrMsg
        SetWorkflowPlaceholders(status,BO);
      }
    } else {
      NotifyEvent("View",status,BO);
    }
    status.m_cClientMode = "view";
  }
  void Edit(ServletStatus status,armt_wu_poschkBO BO,SPParameterSource source) {
    BO.Load(status.w_CPCODMAG,status.w_CPCODAJW);
    if (BO.m_bLoaded && BO.CanEdit()) {
      NotifyEvent("Edit Started",status,BO);
      // A valle dela NotifyEvent imposto le variabili passate da hyperlink e simili
      if (SetPassedWorkVars(status,BO,source,entityGlobals.keyColumns)) {
        // Posso <dimenticare> che m_cMode="hyperlink"
        status.m_cMode = "edit";
        status.m_cClientMode = "edit";
      } else {
        status.m_cClientMode = "error";
      }
    } else {
      if (BO.m_bLoaded) {
        status.m_cErrMsg = (CPLib.Empty(BO.LastErrorMessage())?"":BO.LastErrorMessage());
      } else {
        status.m_cErrMsg = "MSG_RECORD_NOT_FOUND";
      }
      status.m_bError = true;
      status.m_bExit = true;
      status.m_cClientMode = "query";
      if ( ! (CPLib.Empty(status.m_cAtExit)) && HasMarker(status,"@ERROR")) {
        status.m_bExit = true;
        // valorizzazione dei placeholder del workflow: qui e' gia' valorizzato status.m_cErrMsg
        SetWorkflowPlaceholders(status,BO);
      }
    }
    if ( ! (CPLib.IsNull(source)) && source.Has("m_OnlyContext")) {
      status.m_cClientMode = "bringback";
    }
  }
  void New(ServletStatus status,armt_wu_poschkBO BO,SPParameterSource source) {
    BO.Initialize();
    if (BO.CanAdd()) {
      NotifyEvent("New record",status,BO);
      // A valle della NotifyEvent imposto le variabili passate da hyperlink e simili
      if (CPLib.IsNull(source) || SetPassedWorkVars(status,BO,source)) {
        // Posso <dimenticare> che m_cMode="hyperlink"
        status.m_cMode = "new";
        status.m_cClientMode = "new";
      } else {
        status.m_cClientMode = "error";
      }
    } else {
      status.m_cErrMsg = BO.m_cLastMsgError;
      status.m_bError = true;
      status.m_bExit = true;
      status.m_cClientMode = "query";
      if ( ! (CPLib.Empty(status.m_cAtExit)) && HasMarker(status,"@ERROR")) {
        status.m_bExit = true;
        // valorizzazione dei placeholder del workflow: qui e' gia' valorizzato status.m_cErrMsg
        SetWorkflowPlaceholders(status,BO);
      }
    }
    if ( ! (CPLib.IsNull(source)) && source.Has("m_OnlyContext")) {
      status.m_cClientMode = "bringback";
    }
  }
  void Write(ServletStatus status,armt_wu_poschkBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    String l_cTransMsgErr = "";
    if (HasAllKeys(status,source)) {
      Edit(status,BO,source);
    } else if (CPLib.eq(status.m_cAction,"write")) {
      status.m_bError = true;
      status.m_cClientMode = "error";
      status.m_cErrMsg = "MSG_WRITE_FAILED_FOR_KEY";
    }
    if ( ! (BO.m_bLoaded) && CPLib.eq(status.m_cAction,"writeload")) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      New(status,BO,source);
    }
    if ( ! (status.m_bError)) {
      l_bResult = BO.CanSave();
      l_bResult = l_bResult && BO.BRCanSave();
      if (l_bResult) {
        BO.m_Sql.BeginTransaction();
        l_bResult = BO.Save(true);
        l_cTrsMsgErr = BO.m_Sql.TransactionErrorMessage();
        l_bTrsOk = BO.m_Sql.EndTransaction();
        if (l_bResult && l_bTrsOk && BO.IsUpdated()) {
          if (BO.m_bLoaded) {
            BO.NotifyEvent("Record Updated");
          } else {
            BO.NotifyEvent("Record Inserted");
          }
        }
      }
      if (l_bTrsOk && l_bResult) {
        status.m_bExit = true;
        status.m_cClientMode = "query";
      } else {
        status.m_bError = true;
        status.m_cClientMode = "error";
        if ( ! (l_bTrsOk)) {
          // Gestione dell'errore di transazione
          if (CPLib.ne(l_cTrsMsgErr,"")) {
            status.m_cErrMsg = l_cTrsMsgErr;
          }
        } else if ( ! (l_bResult)) {
          CheckErrorToBrowser(BO.m_nLastError,BO.LastErrorMessage(),status);
        }
      }
    }
    // la write non ha parte visuale
    status.m_cClientMode = "bringback";
  }
  void LoadCurrentRecord(ServletStatus status,armt_wu_poschkBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_CPCODMAG = "";
        status.w_CPCODAJW = "";
      } else {
        BO.w_CPCODMAG = l_rsKeys.GetString("CPCODMAG");
        BO.w_CPCODAJW = l_rsKeys.GetString("CPCODAJW");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_CPCODMAG = BO.w_CPCODMAG;
        status.w_CPCODAJW = BO.w_CPCODAJW;
      }
    } finally {
      // In ogni evenienza bisogna liberare la connessione del database
      l_rsKeys.Close();
    }
    status.m_cClientMode = "query";
    if (BO.m_bLoaded &&  ! (BO.CanView())) {
      status.m_cErrMsg = BO.LastErrorMessage();
      status.m_bError = true;
      status.m_bExit = true;
      if ( ! (CPLib.Empty(status.m_cAtExit)) && HasMarker(status,"@ERROR")) {
        // valorizzazione dei placeholder del workflow: qui e' gia' valorizzato status.m_cErrMsg
        SetWorkflowPlaceholders(status,BO);
      }
    }
  }
  void EditLoad(ServletStatus status,armt_wu_poschkBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_wu_poschkBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_CPCODMAG,status.w_CPCODAJW);
      l_cTrsMsgErr = BO.m_Sql.TransactionErrorMessage();
      l_bTrsOk = BO.m_Sql.EndTransaction();
      if (l_bResult && l_bTrsOk) {
        BO.NotifyEvent("Record Deleted");
        status.m_bBODeleted = true;
      }
      status.m_cClientMode = "query";
      if (l_bTrsOk) {
        if (CPLib.gt(status.m_nLastRec,1)) {
          if (CPLib.eq(status.m_nRecPos,status.m_nLastRec)) {
            status.m_nRecPos = status.m_nRecPos-1;
          }
          status.m_nLastRec = status.m_nLastRec-1;
          LoadCurrentRecord(status,BO);
        } else {
          status.m_nLastRec = 0;
          status.m_nRecPos = 0;
          BO.Blank();
        }
      } else {
        status.m_bError = true;
        // Gestione dell'errore di transazione
        if (CPLib.ne(l_cTrsMsgErr,"")) {
          status.m_cErrMsg = l_cTrsMsgErr;
        }
      }
      status.m_bExit = true;
    } else {
      status.m_bError = true;
      status.m_cClientMode = "error";
      status.m_cErrMsg = "MSG_DELETE_FAILED_FOR_KEY";
    }
    if ( ! (l_bResult) &&  ! (CPLib.Empty(status.m_cAtExit)) && HasMarker(status,"@ERROR")) {
      status.m_bExit = true;
      // valorizzazione dei placeholder del workflow: qui e' gia' valorizzato status.m_cErrMsg
      SetWorkflowPlaceholders(status,BO);
    } else if (l_bBringBack) {
      status.m_cClientMode = "bringback";
    }
  }
  void DeleteMessage(ServletStatus status,armt_wu_poschkBO BO,SPParameterSource source) {
    BO.Load(status.w_CPCODMAG,status.w_CPCODAJW);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_wu_poschkBO BO) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    String l_cTransMsgErr = "";
    BO.SetFromContext(status.m_cWv,status.m_Parameters);
    if (CheckVars(status,BO)) {
      if (( ! (BO.IsLoaded()) || status.CheckOP(BO.m_cOldCPCCCHK))) {
        l_bResult = BO.CanSave();
        l_bResult = l_bResult && BO.BRCanSave();
        if (l_bResult) {
          BO.m_Sql.BeginTransaction();
          l_bResult = BO.Save(true);
          l_cTrsMsgErr = BO.m_Sql.TransactionErrorMessage();
          l_bTrsOk = BO.m_Sql.EndTransaction();
          if (l_bResult && l_bTrsOk && BO.IsUpdated()) {
            if (BO.m_bLoaded) {
              BO.NotifyEvent("Record Updated");
            } else {
              BO.NotifyEvent("Record Inserted");
            }
          }
        }
      } else {
        BO.m_cLastMsgError = "MSG_LOOK_INTO_COUNTERS";
        BO.m_nLastError = 0;
        l_bResult = false;
      }
    } else {
      status.m_bError = true;
      status.m_bExit = true;
      status.m_cMode = "error";
      BO.m_cLastMsgError = "MSG_ERROR_SAVING_CONFIG";
      BO.m_nLastError = 0;
      l_bResult = false;
    }
    if (l_bTrsOk && l_bResult) {
      status.m_bExit = true;
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({CPCODMAG:"+SPLib.ToJSValue(BO.w_CPCODMAG,"C",5,0)+",CPCODAJW:"+SPLib.ToJSValue(BO.w_CPCODAJW,"C",9,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
      // valorizzazione dei placeholder del workflow: l'Initialize cancella i valori nel BO e solo in questo punto conosco i valori di campi in chiave sottoposti ad autonumber
      SetWorkflowPlaceholders(status,BO);
      if (CPLib.eq(status.m_cMode,"new")) {
        if (CPLib.ne(CPLib.Left(status.m_cAtExit,5),"close") && CPLib.ne(status.m_cAtExit,"edit")) {
          New(status,BO,null);
        }
      } else {
        status.m_cClientMode = "query";
      }
    } else {
      status.m_bError = true;
      status.m_cClientMode = status.m_cMode;
      if ( ! (l_bTrsOk)) {
        // Gestione dell'errore di transazione
        if (CPLib.ne(l_cTrsMsgErr,"")) {
          status.m_cErrMsg = l_cTrsMsgErr;
        }
      } else if ( ! (l_bResult)) {
        CheckErrorToBrowser(BO.m_nLastError,BO.LastErrorMessage(),status);
      }
      if ( ! (CPLib.Empty(status.m_cAtExit)) && HasMarker(status,"@ERROR")) {
        status.m_bExit = true;
        // valorizzazione dei placeholder del workflow: qui e' gia' valorizzato status.m_cErrMsg
        SetWorkflowPlaceholders(status,BO);
      }
    }
  }
  void Discard(ServletStatus status,armt_wu_poschkBO BO) {
    BO.SetFromContext(status.m_cWv,status.m_Parameters);
    if (CPLib.eq(status.m_cMode,"edit")) {
      NotifyEvent("Edit Aborted",status,BO);
    }
    // valorizzazione dei placeholder del workflow: la blank puo' cancellare i valori preesistenti
    SetWorkflowPlaceholders(status,BO);
    if (CPLib.eq(status.m_cMode,"new")) {
      NotifyEvent("New record aborted",status,BO);
      BO.Blank();
    } else if (CPLib.eq(status.m_cMode,"edit") && CPLib.ne(CPLib.Left(status.m_cAtExit,5),"close") && CPLib.ne(status.m_cAtExit,"autozoom")) {
      LoadCurrentRecord(status,BO);
    }
    status.m_cClientMode = "query";
    status.m_bExit = true;
  }
  void CreatePortlet(ServletStatus status,armt_wu_poschkBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",442);
    item.put("w",499);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","true");
    org.json.JSONObject pageProp = null;
    org.json.JSONArray pagesProp = null;
    pagesProp = new org.json.JSONArray();
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Page 1\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Page 1");
    item.put("altInterfaceFor","armt_wu_poschk");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"comment\":\"Codice Macro Agente\",\"h\":20,\"maxlength\":5,\"name\":\"CPCODMAG\",\"page\":1,\"spuid\":\"BUQHTQZEWF\",\"tabindex\":1,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":42,\"x\":122,\"y\":49,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FGJGISOCRH\",\"page\":1,\"spuid\":\"FGJGISOCRH\",\"tabindex\":2,\"type\":\"Label\",\"value\":\"Codice Macro Agente:\",\"w\":116,\"x\":5,\"y\":53,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"AJW Agenzia\",\"h\":20,\"maxlength\":9,\"name\":\"CPCODAJW\",\"page\":1,\"spuid\":\"PUGRYTGEHQ\",\"tabindex\":3,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":66,\"x\":122,\"y\":72,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RLMKMBMYWN\",\"page\":1,\"spuid\":\"RLMKMBMYWN\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"AJW Agenzia:\",\"w\":73,\"x\":48,\"y\":76,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Ragione Sociale\",\"h\":20,\"maxlength\":30,\"name\":\"CPRAGSOC\",\"page\":1,\"spuid\":\"FFNWZCKHDB\",\"tabindex\":5,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":122,\"y\":95,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UUZFJIKNDH\",\"page\":1,\"spuid\":\"UUZFJIKNDH\",\"tabindex\":6,\"type\":\"Label\",\"value\":\"Ragione Sociale:\",\"w\":86,\"x\":35,\"y\":99,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Domicilio\",\"h\":20,\"maxlength\":40,\"name\":\"CPDOMICI\",\"page\":1,\"spuid\":\"VAFIDWPHCA\",\"tabindex\":7,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":252,\"x\":122,\"y\":118,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XVALWRRSQW\",\"page\":1,\"spuid\":\"XVALWRRSQW\",\"tabindex\":8,\"type\":\"Label\",\"value\":\"Domicilio:\",\"w\":48,\"x\":73,\"y\":122,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Citt\\u00E0\",\"h\":20,\"maxlength\":30,\"name\":\"CP_CITTA\",\"page\":1,\"spuid\":\"PHXZPOWUHE\",\"tabindex\":9,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":122,\"y\":141,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FBJUZQYAYI\",\"page\":1,\"spuid\":\"FBJUZQYAYI\",\"tabindex\":10,\"type\":\"Label\",\"value\":\"Citt\\u00E0:\",\"w\":29,\"x\":92,\"y\":145,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 1\",\"h\":20,\"maxlength\":60,\"name\":\"CPERR_01\",\"page\":1,\"spuid\":\"XPYTVNWCHO\",\"tabindex\":11,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":372,\"x\":122,\"y\":164,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FUFCACTQCQ\",\"page\":1,\"spuid\":\"FUFCACTQCQ\",\"tabindex\":12,\"type\":\"Label\",\"value\":\"Errore 1:\",\"w\":47,\"x\":74,\"y\":168,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 2\",\"h\":20,\"maxlength\":60,\"name\":\"CPERR_02\",\"page\":1,\"spuid\":\"VFFCZHRBSV\",\"tabindex\":13,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":372,\"x\":122,\"y\":187,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WVGTEDJQXS\",\"page\":1,\"spuid\":\"WVGTEDJQXS\",\"tabindex\":14,\"type\":\"Label\",\"value\":\"Errore 2:\",\"w\":47,\"x\":74,\"y\":191,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 3\",\"h\":20,\"maxlength\":60,\"name\":\"CPERR_03\",\"page\":1,\"spuid\":\"YFVSZTUKFJ\",\"tabindex\":15,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":372,\"x\":122,\"y\":210,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GNJKEPAFQG\",\"page\":1,\"spuid\":\"GNJKEPAFQG\",\"tabindex\":16,\"type\":\"Label\",\"value\":\"Errore 3:\",\"w\":47,\"x\":74,\"y\":214,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 4\",\"h\":20,\"maxlength\":60,\"name\":\"CPERR_04\",\"page\":1,\"spuid\":\"FBLLPINCSQ\",\"tabindex\":17,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":372,\"x\":122,\"y\":233,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MYIBJOKLHM\",\"page\":1,\"spuid\":\"MYIBJOKLHM\",\"tabindex\":18,\"type\":\"Label\",\"value\":\"Errore 4:\",\"w\":47,\"x\":74,\"y\":237,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 5\",\"h\":20,\"maxlength\":60,\"name\":\"CPERR_05\",\"page\":1,\"spuid\":\"NREHZLHXUK\",\"tabindex\":19,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":372,\"x\":122,\"y\":256,\"zone\":\"pag1_10\",\"zonepath\":\"[1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RONDZMRNWA\",\"page\":1,\"spuid\":\"RONDZMRNWA\",\"tabindex\":20,\"type\":\"Label\",\"value\":\"Errore 5:\",\"w\":47,\"x\":74,\"y\":260,\"zone\":\"pag1_10\",\"zonepath\":\"[1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 6\",\"h\":20,\"maxlength\":60,\"name\":\"CPERR_06\",\"page\":1,\"spuid\":\"WMBIMGHLXA\",\"tabindex\":21,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":372,\"x\":122,\"y\":279,\"zone\":\"pag1_11\",\"zonepath\":\"[1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TOTPAIZNJM\",\"page\":1,\"spuid\":\"TOTPAIZNJM\",\"tabindex\":22,\"type\":\"Label\",\"value\":\"Errore 6:\",\"w\":47,\"x\":74,\"y\":283,\"zone\":\"pag1_11\",\"zonepath\":\"[1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 7\",\"h\":20,\"maxlength\":60,\"name\":\"CPERR_07\",\"page\":1,\"spuid\":\"MUIQATNACU\",\"tabindex\":23,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":372,\"x\":122,\"y\":302,\"zone\":\"pag1_12\",\"zonepath\":\"[1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IENYFAVPAY\",\"page\":1,\"spuid\":\"IENYFAVPAY\",\"tabindex\":24,\"type\":\"Label\",\"value\":\"Errore 7:\",\"w\":47,\"x\":74,\"y\":306,\"zone\":\"pag1_12\",\"zonepath\":\"[1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 8\",\"h\":20,\"maxlength\":60,\"name\":\"CPERR_08\",\"page\":1,\"spuid\":\"MCFYJRFQLY\",\"tabindex\":25,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":372,\"x\":122,\"y\":325,\"zone\":\"pag1_13\",\"zonepath\":\"[1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RLVBRMKVLK\",\"page\":1,\"spuid\":\"RLVBRMKVLK\",\"tabindex\":26,\"type\":\"Label\",\"value\":\"Errore 8:\",\"w\":47,\"x\":74,\"y\":329,\"zone\":\"pag1_13\",\"zonepath\":\"[1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 9\",\"h\":20,\"maxlength\":60,\"name\":\"CPERR_09\",\"page\":1,\"spuid\":\"FVWFZMVAXM\",\"tabindex\":27,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":372,\"x\":122,\"y\":348,\"zone\":\"pag1_14\",\"zonepath\":\"[1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UDNLAIKCZT\",\"page\":1,\"spuid\":\"UDNLAIKCZT\",\"tabindex\":28,\"type\":\"Label\",\"value\":\"Errore 9:\",\"w\":47,\"x\":74,\"y\":352,\"zone\":\"pag1_14\",\"zonepath\":\"[1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 10\",\"h\":20,\"maxlength\":60,\"name\":\"CPERR_10\",\"page\":1,\"spuid\":\"FBNHYNDMJM\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":372,\"x\":122,\"y\":371,\"zone\":\"pag1_15\",\"zonepath\":\"[1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_URAFRLWJGA\",\"page\":1,\"spuid\":\"URAFRLWJGA\",\"tabindex\":30,\"type\":\"Label\",\"value\":\"Errore 10:\",\"w\":53,\"x\":68,\"y\":375,\"zone\":\"pag1_15\",\"zonepath\":\"[1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Flag Corretta\",\"h\":20,\"maxlength\":1,\"name\":\"CPFLGCOR\",\"page\":1,\"spuid\":\"UPIBHMCFWQ\",\"tabindex\":31,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":18,\"x\":122,\"y\":394,\"zone\":\"pag1_16\",\"zonepath\":\"[1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TLSSWSIGYB\",\"page\":1,\"spuid\":\"TLSSWSIGYB\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"Flag Corretta:\",\"w\":74,\"x\":47,\"y\":398,\"zone\":\"pag1_16\",\"zonepath\":\"[1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Flag Forzatura\",\"h\":20,\"maxlength\":1,\"name\":\"CPFLGFOR\",\"page\":1,\"spuid\":\"VQBNKYNPCH\",\"tabindex\":33,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":18,\"x\":122,\"y\":417,\"zone\":\"pag1_17\",\"zonepath\":\"[1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NKHUJTBNTZ\",\"page\":1,\"spuid\":\"NKHUJTBNTZ\",\"tabindex\":34,\"type\":\"Label\",\"value\":\"Flag Forzatura:\",\"w\":81,\"x\":40,\"y\":421,\"zone\":\"pag1_17\",\"zonepath\":\"[1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_wu_poschkBO BO,ServletStatus status) {
    status.themeWriter = new SPTheme(status.out,status.GetThemeStatus("",status.context.Translate(entityGlobals.userName),status.context.Translate("MSG_FORM_FUNCTION_"+status.m_cClientMode.toUpperCase())),"form");
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
     "<script src='armt_wu_poschk?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
    if (status.is_live_editing) {
      l_cJsUid = SPPrxycizer.proxycizedPath("visualweb/VisualWEB.js");
      status.out.println(
       "<script src='../"+l_cJsUid+"'>" +
       "</script>" +
      "");
      l_cJsUid = SPPrxycizer.proxycizedPath("LiveEditing.js");
      status.out.println(
       "<script src='../"+l_cJsUid+"'>" +
       "</script>" +
      "");
    }
    l_cJsUid = SPPrxycizer.proxycizedPath("SPBOUILib.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    if (CPLib.gt(BO.extendedFields.length,0)) {
      l_cJsUid = SPPrxycizer.proxycizedPath("ExtendedFields.js");
      status.out.println(
       "<script src='../"+l_cJsUid+"'>" +
       "</script>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_wu_poschk_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_wu_poschk_edit.js'>" +
       "</script>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      l_cJsUid = SPPrxycizer.proxycizedPath("sppainterentity.js");
      status.out.println(
       "<script src='../"+l_cJsUid+"'>" +
       "</script>" +
      "");
      PrintPainterProps(status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("function DeclareWVs() {");
      status.out.println("var a = arguments;");
      status.out.println("w_CPCODMAG=a[0];");
      status.out.println("w_CPCODAJW=a[1];");
      status.out.println("w_CPRAGSOC=a[2];");
      status.out.println("w_CPDOMICI=a[3];");
      status.out.println("w_CP_CITTA=a[4];");
      status.out.println("w_CPERR_01=a[5];");
      status.out.println("w_CPERR_02=a[6];");
      status.out.println("w_CPERR_03=a[7];");
      status.out.println("w_CPERR_04=a[8];");
      status.out.println("w_CPERR_05=a[9];");
      status.out.println("w_CPERR_06=a[10];");
      status.out.println("w_CPERR_07=a[11];");
      status.out.println("w_CPERR_08=a[12];");
      status.out.println("w_CPERR_09=a[13];");
      status.out.println("w_CPERR_10=a[14];");
      status.out.println("w_CPFLGCOR=a[15];");
      status.out.println("w_CPFLGFOR=a[16];");
      status.out.println("m_PrimaryKeys=['CPCODAJW','CPCODMAG'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_wu_poschk_proc.js'>" +
       "</script>" +
      "");
    }
    IncludeJS(status);
    RaiseSavedEntity(BO,status);
    RaiseDeletedEntity(BO,status);
    RaiseDiscardedEntity(BO,status);
    // Dichiarazione delle variabili di script
    WriteMainFormVarScript(BO,status);
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/styleVariables.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/calendar.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/calculator.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    if (CPLib.ne(status.m_bAutoResize,"")) {
      status.out.println(
       "<script>" +
      "");
      status.out.println("var sv_WindowAutoResize = " + SPLib.ToJSValue(CPLib.eq(status.m_bAutoResize,"true"),"L",0,0)+ ";");
      status.out.println(
       "</script>" +
      "");
    }
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/tabStrip.js");
      status.out.println(
       "<script src='../"+l_cJsUid+"'>" +
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
    status.out.println("AppletTag('Batch');");
    status.out.println(
     "</script>" +
    "");
    status.m_cBodyAttributes = "onload=OnLoad() onhelp=CancelHelp()";
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.m_cBodyAttributes = status.m_cBodyAttributes+" onkeydown=window.ManageKeys(event,false,false)";
    } else {
      status.m_cBodyAttributes = status.m_cBodyAttributes+" onkeydown=window.ManageKeys(event,true,false)";
    }
    status.m_cBodyAttributes = status.m_cBodyAttributes+" onfocus=EnsureControlFocus()";
    status.themeWriter.WriteBody_Begin(442,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
    status.out.println(
     "<script>" +
    "");
    status.out.println(
     "</script>" +
    "");
    WriteMainFormScript(BO,status);
    status.AssignOP(BO.m_cOldCPCCCHK);
    status.WriteSenderForm(entityGlobals,BO.m_bLoaded);
    WriteMainForm(BO,status);
    status.themeWriter.WriteBody_EndHtml();
    status.themeWriter.WriteBody_End();
    PrintWarns(BO,status,BO.IsLoaded());
    status.out.println(
     "</html>" +
    "");
  }
  void OpenZoom(ServletStatus status,SPParameterSource source) {
    ForwardZoom("../jsp/SPPortalZoom.jsp",status,source);
  }
  void OpenPSZoom(ServletStatus status,SPParameterSource source) {
    ForwardZoom("../jsp/SPPortalZoomBase_portlet.jsp",status,source);
  }
  void ForwardZoom(String p_cForwardZoomResource,ServletStatus status,SPParameterSource source) {
    SPLib.NoCache(status.response);
    Forward f;
    f = new Forward(SPLib.GetZoomResource(p_cForwardZoomResource),false,Forward.Start,false);
    f.SetParameter("Table","wuposchk");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","CPCODMAG,CPCODAJW");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(armt_wu_poschkBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({CPCODMAG:"+SPLib.ToJSValue(BO.w_CPCODMAG,"C",5,0)+",CPCODAJW:"+SPLib.ToJSValue(BO.w_CPCODAJW,"C",9,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_wu_poschkBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({CPCODMAG:"+SPLib.ToJSValue(BO.w_CPCODMAG,"C",5,0)+",CPCODAJW:"+SPLib.ToJSValue(BO.w_CPCODAJW,"C",9,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armt_wu_poschkBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({CPCODMAG:"+SPLib.ToJSValue(BO.w_CPCODMAG,"C",5,0)+",CPCODAJW:"+SPLib.ToJSValue(BO.w_CPCODAJW,"C",9,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armt_wu_poschkBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({CPCODMAG:"+SPLib.ToJSValue(BO.w_CPCODMAG,"C",5,0)+",CPCODAJW:"+SPLib.ToJSValue(BO.w_CPCODAJW,"C",9,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armt_wu_poschkBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({CPCODMAG:"+SPLib.ToJSValue(BO.w_CPCODMAG,"C",5,0)+",CPCODAJW:"+SPLib.ToJSValue(BO.w_CPCODAJW,"C",9,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_wu_poschkBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_wu_poschkBO BO,ServletStatus status) throws IOException {
    if (CPLib.eq(BO.m_nLastError,4) || CPLib.eq(BO.m_nLastError,5)) {
      RequestPwdOrOTP(status,(CPLib.eq(BO.m_nLastError,5)?"OTP":"password"));
      return;
    }
    String msg = status.context.Translate("MSG_END_ROUTINE");
    SPLib.SetContentType(status.response);
    SPLib.NoCache(status.response);
    status.out = status.response.getWriter();
    String l_cJsUid;
    status.out.println(
     "<!doctype html>" +
    "");
    status.out.println(
     "<html>" +
    "");
    status.out.println(
     "<title>" +
     ""+status.context.Translate("MSG_ROUTINE_WIND")+"" +
     "</title>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("stdFunctions.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("controls.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    if (status.m_bError) {
      msg = status.context.Translate("MSG_END_ROUTINE_WITH_MSG");
      status.out.println(
       "<body onkeydown='window.ManageKeys(event,false,false)'>" +
      "");
    } else {
      status.out.println(
       "<body>" +
      "");
    }
    status.out.println(
     "<p>" +
     ""+msg+"" +
     "</p>" +
    "");
    String l_cPreviousErr = status.m_cErrMsg;
    String l_cUserErr = status.m_cErrMsg;
    if (status.m_bError) {
      status.out.println(
       "<script>" +
      "");
      WriteJSError(status);
      l_cUserErr = status.m_cErrMsg;
      status.m_cErrMsg = l_cPreviousErr;
      status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
      status.out.println(
       "</script>" +
      "");
    }
    status.out.println(
     "<!--" +
    "");
    if (CPLib.eq(status.source.GetParameter("m_OnlyContext","_no_"),"_no_")) {
      String l_cOut;
      if (status.m_bError) {
        l_cOut = SPLib.ToJSValue("KO("+SPLib.GetWriteVarErrorName(status)+")"+UserDBMessage(status),"C",0,0);
      } else {
        l_cOut = "OK";
        if (status.m_cAction.endsWith("message")) {
          l_cOut = l_cOut+" "+SPLib.ToJSValue(status.m_cBOWarnMessageDeleted,"C",0,0);
        } else if (status.m_cAction.startsWith("delete")) {
          l_cOut = l_cOut+" "+status.m_bBODeleted;
        }
      }
      l_cOut = CPLib.ToProperties(l_cOut);
      l_cOut = com.zucchetti.sitepainter.Library.ToHTMLEuro(l_cOut);
      status.out.println("Function return value:"+l_cOut+"");
    } else {
      status.m_cErrMsg = l_cUserErr;
      status.out.println("js:BO="+SPLib.ToJSValue(BO.GetContext(),"M",0,0)+"");
    }
    status.out.println(
     " -->" +
    "");
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
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
  }
  public String GetCheckVars(ServletStatus status,armt_wu_poschkBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_CPCODMAG),"C",5,0));
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_CPCODAJW),"C",9,0));
      }
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_wu_poschkBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
    }
    return result;
  }
}
