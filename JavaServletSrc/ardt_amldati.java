import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class ardt_amldati extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*a7643c05*!";
  static public class ServletStatus extends SPDetailChildServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "amldati";
    }
    public String w_IDAMLANNO;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_IDAMLANNO,context,"amldati","IDAMLANNO","C",4,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='IDAMLANNO' type='hidden' value="+SPLib.ToHTMLValue(w_IDAMLANNO,"C",4,0)+">" +
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
    ardt_amldatiBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_amldati;
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
    } else if (CPLib.eq(status.m_cAction,"deleterow")) {
      DeleteRow(status,BO,source);
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
      status.w_IDAMLANNO = BO.w_IDAMLANNO;
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
    return "Dati Questionario";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "ardt_amldati";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 652;
    l_eg.m_nEntityHeight = 287;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"amldati"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"IDAMLANNO"};
    l_eg.keyRepeatedColumns = new String[]{"IDBASE"};
    l_eg.items = new SPItem[]{
                   new SPItem("IDAMLANNO","C",4,0, "edit","Anno riferimento"),
                   new SPItem("IDBASE","C",10,0, "edit",""),
                   new SPItem("LIV1","C",3,0, "edit",""),
                   new SPItem("LIV2","C",3,0, "edit",""),
                   new SPItem("LIV3","C",3,0, "edit",""),
                   new SPItem("N1","N",15,2, "edit",""),
                   new SPItem("N2","N",15,2, "edit",""),
                   new SPItem("N3","N",15,2, "edit",""),
                   new SPItem("N4","N",15,2, "edit",""),
                   new SPItem("N5","N",15,2, "edit",""),
                   new SPItem("N6","N",15,2, "edit",""),
                   new SPItem("N7","N",15,2, "edit",""),
                   new SPItem("C1","C",100,0, "edit",""),
                   new SPItem("C2","C",100,0, "edit",""),
                   new SPItem("C3","C",100,0, "edit",""),
                   new SPItem("C4","C",100,0, "edit",""),
                   new SPItem("C5","C",100,0, "edit",""),
                   new SPItem("C6","C",100,0, "edit",""),
                   new SPItem("C7","C",100,0, "edit",""),
                   new SPItem("BOX","M",10,0, "edit","")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,ardt_amldatiBO BO) {
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
    l_translations=new String[][]{{"10759403658",p_Context.Translate("Dati Questionario")},
    {"999531942",p_Context.Translate("Anno riferimento")},
    {"MSG_MD_TAB_FOOTER",p_Context.Translate("MSG_MD_TAB_FOOTER")},
    {"MSG_MD_TAB_HEADER",p_Context.Translate("MSG_MD_TAB_HEADER")},
    {"MSG_MD_TAB_ROWS",p_Context.Translate("MSG_MD_TAB_ROWS")}};
    return l_translations;
  }
  org.json.JSONArray i_detailMenuItems = null;
  public org.json.JSONArray getDetailMenuItems() {
    if (CPLib.IsNull(i_detailMenuItems)) {
      i_detailMenuItems = new org.json.JSONArray();
    }
    return i_detailMenuItems;
  }
  void WriteStyles(ardt_amldatiBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../ardt_amldati.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(ardt_amldatiBO BO,ServletStatus status) {
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
      HTMLRowScript(BO,status);
      status.out.println(
       "<style>" +
      "");
      status.out.println(".UASFCHXLRC {top:0px;position:absolute;left:0px;height:16px;width:72px;background-color:Transparent;z-index:1; }");
      status.out.println(".AFSDOMRNZC {top:0px;position:absolute;left:77px;height:16px;width:30px;background-color:Transparent;z-index:1; }");
      status.out.println(".LMBDWDWYOJ {top:0px;position:absolute;left:112px;height:16px;width:30px;background-color:Transparent;z-index:1; }");
      status.out.println(".OUCAYORICR {top:0px;position:absolute;left:147px;height:16px;width:30px;background-color:Transparent;z-index:1; }");
      status.out.println(".WFEQRDUEHK {top:0px;position:absolute;left:182px;height:16px;width:102px;text-align:right;background-color:Transparent;z-index:1; }");
      status.out.println(".AXLQDUTMKE {top:0px;position:absolute;left:289px;height:16px;width:102px;text-align:right;background-color:Transparent;z-index:1; }");
      status.out.println(".UQEGOTONHO {top:0px;position:absolute;left:396px;height:16px;width:102px;text-align:right;background-color:Transparent;z-index:1; }");
      status.out.println(".VLPHUFHRWG {top:19px;position:absolute;left:0px;height:16px;width:102px;text-align:right;background-color:Transparent;z-index:1; }");
      status.out.println(".RNANYATLJA {top:19px;position:absolute;left:107px;height:16px;width:102px;text-align:right;background-color:Transparent;z-index:1; }");
      status.out.println(".FGZMGIETJK {top:19px;position:absolute;left:214px;height:16px;width:102px;text-align:right;background-color:Transparent;z-index:1; }");
      status.out.println(".TTSVMTXSHK {top:19px;position:absolute;left:321px;height:16px;width:102px;text-align:right;background-color:Transparent;z-index:1; }");
      status.out.println(".BCQNNDGTFP {top:38px;position:absolute;left:0px;height:16px;width:612px;background-color:Transparent;z-index:1; }");
      status.out.println(".YQPUAGHCIC {top:57px;position:absolute;left:0px;height:16px;width:612px;background-color:Transparent;z-index:1; }");
      status.out.println(".VBELTUYZHN {top:76px;position:absolute;left:0px;height:16px;width:612px;background-color:Transparent;z-index:1; }");
      status.out.println(".BYRSYJQNCL {top:95px;position:absolute;left:0px;height:16px;width:612px;background-color:Transparent;z-index:1; }");
      status.out.println(".PCMHVKTTLL {top:114px;position:absolute;left:0px;height:16px;width:612px;background-color:Transparent;z-index:1; }");
      status.out.println(".RTBHNLUHZE {top:133px;position:absolute;left:0px;height:16px;width:612px;background-color:Transparent;z-index:1; }");
      status.out.println(".SWIJFJKKLJ {top:152px;position:absolute;left:0px;height:16px;width:612px;background-color:Transparent;z-index:1; }");
      status.out.println(".OIVQOXTGIZ {top:171px;position:absolute;left:0px;height:16px;width:72px;overflow:auto;background-color:Transparent;z-index:1; }");
      status.out.println(
       "</style>" +
      "");
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
      status.out.println("Z.Tabs.Get('tabs').InitSelect('ardt_amldati',true);");
    }
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"ardt_amldati",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(ardt_amldatiBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,2);
  }
  void WriteControls_p1(ardt_amldatiBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:287px;width:652px;display:none'>" +
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
  void WriteControls_p1_b0(ardt_amldatiBO BO,ServletStatus status) {
    status.out.println(
     "<div style='position:relative;height:287px'>" +
    "");
    status.out.println(
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='IDAMLANNO' id='NSUYYWAOJV' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_IDAMLANNO,"C",4,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='4' size='4' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel PrimaryKeyLabel' id='KOCAYKNGCM_DIV'>" +
     "<label id='KOCAYKNGCM' for='NSUYYWAOJV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Anno riferimento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<div id='GridTable_Container' style='position:absolute;top:96px;left:18px;height:166px;width:634px;overflow:hidden' class='GridTable_Container "+SPLib.ToHTML(status.m_cClientMode,"C",0,0)+"'>" +
     "<div id=GridTable_LockedScroll style='position:absolute;top:0px;left:0px;height:166px;width:634px;overflow:scroll'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<div id='GridTable_DIV' style='position:relative;left:0;top:0;width:634px;height:166px;overflow:auto;'>" +
     "<table id='GridTable' style='position:relative;top:0px;left:0px;width:628px' cellspacing='0' cellpadding='0' border='0'>" +
     "<tr>" +
     "<td></td>" +
     "</tr>" +
     "</table>" +
     "</div>" +
    "");
    if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<div id='GridTable_ButtonPanel' style='position:absolute;top:0px;left:20px;z-index:4'>" +
       ""+printButtonPanelContent(status,1,"upper_right",false,getDetailMenuItems(),false,"")+"" +
       "</div>" +
      "");
    }
    HTMLRowScript(BO,status);
    status.m_nTabIndex = status.m_nTabIndex+1;
    status.out.println(
     "</div>" +
    "");
  }
  void HTMLRowScript(ardt_amldatiBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder = null;
    status.out.println(
     "<script>" +
    "");
    status.out.println("function HTMLRow(editable,rowtoshow) {");
    status.out.println("var s;");
    status.out.println("s='<div style=\"position:relative;width:612px;height:159px;\"';");
    status.out.println("s=s+'>';");
    status.out.println("var row;");
    status.out.println("var prefix;");
    status.out.println("var w_IDBASE;");
    status.out.println("var w_LIV1;");
    status.out.println("var w_LIV2;");
    status.out.println("var w_LIV3;");
    status.out.println("var w_N1;");
    status.out.println("var w_N2;");
    status.out.println("var w_N3;");
    status.out.println("var w_N4;");
    status.out.println("var w_N5;");
    status.out.println("var w_N6;");
    status.out.println("var w_N7;");
    status.out.println("var w_C1;");
    status.out.println("var w_C2;");
    status.out.println("var w_C3;");
    status.out.println("var w_C4;");
    status.out.println("var w_C5;");
    status.out.println("var w_C6;");
    status.out.println("var w_C7;");
    status.out.println("var w_BOX;");
    status.out.println("if (Eq(rowtoshow,null)) {");
    status.out.println("row=window;");
    status.out.println("prefix='w_';");
    status.out.println("} else {");
    status.out.println("row=rowtoshow;");
    status.out.println("prefix='';");
    status.out.println("}");
    status.out.println("w_IDBASE=row[prefix+'IDBASE'];");
    status.out.println("w_LIV1=row[prefix+'LIV1'];");
    status.out.println("w_LIV2=row[prefix+'LIV2'];");
    status.out.println("w_LIV3=row[prefix+'LIV3'];");
    status.out.println("w_N1=row[prefix+'N1'];");
    status.out.println("w_N2=row[prefix+'N2'];");
    status.out.println("w_N3=row[prefix+'N3'];");
    status.out.println("w_N4=row[prefix+'N4'];");
    status.out.println("w_N5=row[prefix+'N5'];");
    status.out.println("w_N6=row[prefix+'N6'];");
    status.out.println("w_N7=row[prefix+'N7'];");
    status.out.println("w_C1=row[prefix+'C1'];");
    status.out.println("w_C2=row[prefix+'C2'];");
    status.out.println("w_C3=row[prefix+'C3'];");
    status.out.println("w_C4=row[prefix+'C4'];");
    status.out.println("w_C5=row[prefix+'C5'];");
    status.out.println("w_C6=row[prefix+'C6'];");
    status.out.println("w_C7=row[prefix+'C7'];");
    status.out.println("w_BOX=row[prefix+'BOX'];");
    status.out.println("if (editable) {");
    status.out.println("if (Gt(m_nCurrentRow,0)) {");
    status.out.println("s=s+\""+
     "<input name='BeforeDetailElement' type='text' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
    "\"");
    status.out.println("}");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='IDBASE' id='UASFCHXLRC' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+" GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_IDBASE),'C',10,0,'')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='10' size='10' fieldtype='C'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='LIV1' id='AFSDOMRNZC' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_LIV1),'C',3,0,'')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='3' size='3' fieldtype='C'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='LIV2' id='LMBDWDWYOJ' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_LIV2),'C',3,0,'')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='3' size='3' fieldtype='C'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='LIV3' id='OUCAYORICR' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_LIV3),'C',3,0,'')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='3' size='3' fieldtype='C'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='N1' id='WFEQRDUEHK' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(w_N1,'N',15,2,'999999999999.99')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='18' size='15' fieldtype='N'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='N2' id='AXLQDUTMKE' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(w_N2,'N',15,2,'999999999999.99')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='18' size='15' fieldtype='N'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='N3' id='UQEGOTONHO' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(w_N3,'N',15,2,'999999999999.99')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='18' size='15' fieldtype='N'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='N4' id='VLPHUFHRWG' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(w_N4,'N',15,2,'999999999999.99')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='18' size='15' fieldtype='N'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='N5' id='RNANYATLJA' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(w_N5,'N',15,2,'999999999999.99')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='18' size='15' fieldtype='N'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='N6' id='FGZMGIETJK' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(w_N6,'N',15,2,'999999999999.99')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='18' size='15' fieldtype='N'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='N7' id='TTSVMTXSHK' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(w_N7,'N',15,2,'999999999999.99')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='18' size='15' fieldtype='N'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='C1' id='BCQNNDGTFP' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_C1),'C',100,0,'')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='100' size='100' fieldtype='C'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='C2' id='YQPUAGHCIC' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_C2),'C',100,0,'')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='100' size='100' fieldtype='C'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='C3' id='VBELTUYZHN' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_C3),'C',100,0,'')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='100' size='100' fieldtype='C'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='C4' id='BYRSYJQNCL' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_C4),'C',100,0,'')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='100' size='100' fieldtype='C'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='C5' id='PCMHVKTTLL' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_C5),'C',100,0,'')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='100' size='100' fieldtype='C'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='C6' id='RTBHNLUHZE' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_C6),'C',100,0,'')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='100' size='100' fieldtype='C'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='C7' id='SWIJFJKKLJ' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_C7),'C',100,0,'')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='100' size='100' fieldtype='C'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<textarea name='BOX' id='OIVQOXTGIZ' class='Memo GridTable_EditRowItem ' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" cols='20' rows='2'>" +
     "</textarea>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.m_nTabIndex = status.m_nTabIndex+(0);
    status.m_nAfterDetailElementTabIndex = status.m_nTabIndex;
    status.out.println("s=s+\""+
     "<input name='AfterDetailElement' type='text' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(-1);
    status.m_nTabIndex = status.m_nTabIndex-(0);
    status.out.println("} else {");
    status.out.println("if ( ! (IsHiddenByStateDriver('IDBASE'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+" Disabled GridTable_QueryRowItem UASFCHXLRC' value='\"+WtH(ToHTML(w_IDBASE),'C',10,0,'')+\"' tabindex='-1' readonly size='10'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('LIV1'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem AFSDOMRNZC' value='\"+WtH(ToHTML(w_LIV1),'C',3,0,'')+\"' tabindex='-1' readonly size='3'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('LIV2'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem LMBDWDWYOJ' value='\"+WtH(ToHTML(w_LIV2),'C',3,0,'')+\"' tabindex='-1' readonly size='3'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('LIV3'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem OUCAYORICR' value='\"+WtH(ToHTML(w_LIV3),'C',3,0,'')+\"' tabindex='-1' readonly size='3'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('N1'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem WFEQRDUEHK' value='\"+WtH(w_N1,'N',15,2,'999999999999.99')+\"' tabindex='-1' readonly size='15'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('N2'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem AXLQDUTMKE' value='\"+WtH(w_N2,'N',15,2,'999999999999.99')+\"' tabindex='-1' readonly size='15'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('N3'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem UQEGOTONHO' value='\"+WtH(w_N3,'N',15,2,'999999999999.99')+\"' tabindex='-1' readonly size='15'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('N4'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem VLPHUFHRWG' value='\"+WtH(w_N4,'N',15,2,'999999999999.99')+\"' tabindex='-1' readonly size='15'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('N5'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem RNANYATLJA' value='\"+WtH(w_N5,'N',15,2,'999999999999.99')+\"' tabindex='-1' readonly size='15'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('N6'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem FGZMGIETJK' value='\"+WtH(w_N6,'N',15,2,'999999999999.99')+\"' tabindex='-1' readonly size='15'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('N7'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem TTSVMTXSHK' value='\"+WtH(w_N7,'N',15,2,'999999999999.99')+\"' tabindex='-1' readonly size='15'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('C1'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem BCQNNDGTFP' value='\"+WtH(ToHTML(w_C1),'C',100,0,'')+\"' tabindex='-1' readonly size='100'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('C2'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem YQPUAGHCIC' value='\"+WtH(ToHTML(w_C2),'C',100,0,'')+\"' tabindex='-1' readonly size='100'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('C3'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem VBELTUYZHN' value='\"+WtH(ToHTML(w_C3),'C',100,0,'')+\"' tabindex='-1' readonly size='100'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('C4'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem BYRSYJQNCL' value='\"+WtH(ToHTML(w_C4),'C',100,0,'')+\"' tabindex='-1' readonly size='100'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('C5'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem PCMHVKTTLL' value='\"+WtH(ToHTML(w_C5),'C',100,0,'')+\"' tabindex='-1' readonly size='100'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('C6'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem RTBHNLUHZE' value='\"+WtH(ToHTML(w_C6),'C',100,0,'')+\"' tabindex='-1' readonly size='100'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('C7'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem SWIJFJKKLJ' value='\"+WtH(ToHTML(w_C7),'C',100,0,'')+\"' tabindex='-1' readonly size='100'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('BOX'))) {");
    status.out.println("s=s+\""+
     "<textarea class='GridTable_QueryRowItem OIVQOXTGIZ' disabled cols='20' rows='2'>" +
     "\"+WtH(w_BOX,'M',10,0,'"+""+"')+\"" +
     "</textarea>" +
    "\"");
    status.out.println("}");
    status.out.println("s=s+'<div style=\" position:absolute;z-index:2;width:612px;height:159px;\"></div>';");
    status.out.println("}");
    status.out.println("s=s+'</div>';");
    status.out.println("return s;");
    status.out.println("}");
    status.out.println(
     "</script>" +
    "");
  }
  static void PrintState(ardt_amldatiBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(ardt_amldatiBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
  }
  static void PrintStateWorkVars(ardt_amldatiBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_IDAMLANNO,"C",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_LIV1,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_LIV2,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_LIV3,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_N1,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_N2,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_N3,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_N4,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_N5,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_N6,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_N7,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_C1,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C2,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C3,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C4,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C5,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C6,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C7,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_BOX,"M",10,0));
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
    PrintStateDetailWorkVars(BO,status);
  }
  static void PrintStateDetailWorkVars(ardt_amldatiBL BO,ServletStatus status) {
    int k;
    int l_nSelectRow = -1;
    boolean l_bForceSelect = false;
    if (CPLib.Empty(status.m_cDetailBehavior) && status.m_bBrowserUpdate &&  ! (CPLib.Empty(BO.LastErrorMessage()))) {
      status.out.print("if (Empty(m_cDetailBehavior)) {");
      status.out.print("m_cDetailBehavior='select';");
      status.out.print("}");
      l_nSelectRow = BO.m_nCurrentRow;
      l_bForceSelect = true;
    } else if (CPLib.ne(CPLib.Lower(CPLib.Left(status.m_cDetailBehavior,6)),"select")) {
      l_nSelectRow = -2;
    }
    status.out.print("m_oTrs=[");
    k = 0;
    while (CPLib.lt(k,BO.m_oTrs.size())) {
      BO.SetRow(k);
      if (CPLib.eq(l_nSelectRow,-1)) {
        l_nSelectRow = k;
      }
      status.out.print(" new TrsRow(");
      status.out.print(""+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",");
      if ( ! (l_bForceSelect) && CPLib.eq(l_nSelectRow,k) && ( ! (status.source.Has("IDBASE")) || CPLib.ne(CPLib.RTrim(BO.w_IDBASE),status.source.GetParameter("IDBASE","")))) {
        l_nSelectRow = -1;
      }
      status.out.print(""+SPLib.ToJSValue(BO.w_LIV1,"C",3,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_LIV2,"C",3,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_LIV3,"C",3,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_N1,"N",15,2)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_N2,"N",15,2)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_N3,"N",15,2)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_N4,"N",15,2)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_N5,"N",15,2)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_N6,"N",15,2)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_N7,"N",15,2)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_C1,"C",100,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_C2,"C",100,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_C3,"C",100,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_C4,"C",100,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_C5,"C",100,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_C6,"C",100,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_C7,"C",100,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_BOX,"M",10,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.opk_IDBASE,"N",0,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.m_nRowStatus,"N",0,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.m_cOldRowCPCCCHK,"C",10,0)+"");
      int l;
      for ( l = 0; CPLib.lt(l,BO.work_children.length); l = l + (1)) {
        if ( ! (CPLib.eq(BO.work_children[l],null))) {
          status.out.print(","+SPLib.ToJSValue(BO.work_children[l],"C",0,0)+"");
        } else {
          status.out.print(",''");
        }
      }
      status.out.print(")");
      k = k+1;
      if (CPLib.lt(k,BO.m_oTrs.size())) {
        status.out.print(",");
      }
    }
    status.out.println("]");
    if (CPLib.gt(l_nSelectRow,-1)) {
      BO.SetRow(l_nSelectRow);
    } else {
      BO.SetRow(0);
    }
    // Variabile che contiene il numero di riga corrente nel transitorio
    status.out.println("m_nCurrentRow="+SPLib.ToJSValue(BO.m_nCurrentRow,"N",0,0)+";");
    status.out.println("m_cOldRowCPCCCHK=\""+BO.m_cOldRowCPCCCHK+"\";");
    PrintStateDetailWorkVars_Deleted(BO,status);
  }
  static void PrintStateDetailWorkVars_Deleted(ardt_amldatiBL BO,ServletStatus status) {
    String l_cTrs;
    int k;
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      ardt_amldatiBO.TrsRow l_Row;
      l_cTrs = "[";
      k = 0;
      while (CPLib.lt(k,BO.m_oDeletedRows.size())) {
        l_Row= (ardt_amldatiBO.TrsRow) BO.m_oDeletedRows.get(k);
        l_cTrs = l_cTrs+" new TrsRow(";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_IDBASE,"C",10,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_LIV1,"C",3,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_LIV2,"C",3,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_LIV3,"C",3,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_N1,"N",15,2)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_N2,"N",15,2)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_N3,"N",15,2)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_N4,"N",15,2)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_N5,"N",15,2)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_N6,"N",15,2)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_N7,"N",15,2)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_C1,"C",100,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_C2,"C",100,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_C3,"C",100,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_C4,"C",100,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_C5,"C",100,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_C6,"C",100,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_C7,"C",100,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_BOX,"M",10,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.opk_IDBASE,"N",0,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.m_nRowStatus,"N",0,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.m_cOldRowCPCCCHK,"C",10,0);
        int l;
        for ( l = 0; CPLib.lt(l,l_Row.work_children.length); l = l + (1)) {
          if ( ! (CPLib.eq(l_Row.work_children[l],null))) {
            l_cTrs = l_cTrs+","+SPLib.ToJSValue(l_Row.work_children[l],"C",0,0);
          } else {
            l_cTrs = l_cTrs+",''";
          }
        }
        l_cTrs = l_cTrs+")";
        k = k+1;
        if (CPLib.lt(k,BO.m_oDeletedRows.size())) {
          l_cTrs = l_cTrs+",";
        }
      }
      l_cTrs = l_cTrs+"]";
      status.out.println("m_oDeletedRows="+l_cTrs+";");
      status.out.println("m_nRowStatus="+SPLib.ToJSValue(BO.m_nRowStatus,"N",0,0)+";");
      status.out.println("m_bHeaderUpdated="+SPLib.ToJSValue(BO.m_bHeaderUpdated,"L",0,0)+";");
      status.out.println("opk_IDBASE="+SPLib.ToJSValue(BO.opk_IDBASE,"N",0,0)+";");
    }
  }
  void WriteMainFormVarScript(ardt_amldatiBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var m_oFather;");
    status.out.println("var m_bRowsChild = "+status.m_bRowsChild+";");
    status.out.println("var m_nChildStatus = " + SPLib.ToJSValue(status.m_nChildStatus,"N",0,0)+ ";");
    status.out.println("var m_bResetOnUnload = true;");
    status.out.println("var m_bChildDisabled = false;");
    if (CPLib.eq(status.m_nChildStatus,1)) {
      status.out.println("var m_cCPCCCHK = " + SPLib.ToJSValue("","C",0,0)+ ";");
    }
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(287,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(652,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_amldati"),"C",0,0)+ ";");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("ardt_amldati","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"ardt_amldati",BO.GetCurrentState());
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
      status.out.println("var m_bStopChangeRow = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    } else {
      status.out.println("var m_nLastRec = " + SPLib.ToJSValue(status.m_nLastRec,"N",0,0)+ ";");
      status.out.println("var m_nRecPos = " + SPLib.ToJSValue(status.m_nRecPos,"N",0,0)+ ";");
      status.out.println("var m_cVirtName = " + SPLib.ToJSValue(status.m_cVirtName,"C",0,0)+ ";");
    }
    status.out.println("var m_SaveContextRepeatedChild = " + SPLib.ToJSValue("","C",0,0)+ ";");
    status.out.println("var m_cDetailBehavior = " + SPLib.ToJSValue(status.m_cDetailBehavior,"C",0,0)+ ";");
    status.out.println("var m_bAlternateColorRows = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("function TrsRow() {");
    status.out.println("if (Eq(arguments.length,1)) {");
    status.out.println("this.IDBASE=w_IDBASE;");
    status.out.println("this.LIV1=w_LIV1;");
    status.out.println("this.LIV2=w_LIV2;");
    status.out.println("this.LIV3=w_LIV3;");
    status.out.println("this.N1=w_N1;");
    status.out.println("this.N2=w_N2;");
    status.out.println("this.N3=w_N3;");
    status.out.println("this.N4=w_N4;");
    status.out.println("this.N5=w_N5;");
    status.out.println("this.N6=w_N6;");
    status.out.println("this.N7=w_N7;");
    status.out.println("this.C1=w_C1;");
    status.out.println("this.C2=w_C2;");
    status.out.println("this.C3=w_C3;");
    status.out.println("this.C4=w_C4;");
    status.out.println("this.C5=w_C5;");
    status.out.println("this.C6=w_C6;");
    status.out.println("this.C7=w_C7;");
    status.out.println("this.BOX=w_BOX;");
    status.out.println("this.opk_IDBASE=opk_IDBASE;");
    status.out.println("this.m_nRowStatus=arguments[0];");
    status.out.println("this.m_cOldRowCPCCCHK=m_cOldRowCPCCCHK;");
    int l;
    for ( l = 0; CPLib.lt(l,BO.m_MNTs.length); l = l + (1)) {
      if (BO.m_MNTs[l].RepeatedChild()) {
        status.out.println("this.m_cWv_"+BO.m_MNTs[l].m_cChildName+"=m_cWv_"+BO.m_MNTs[l].m_cChildName+";");
      }
    }
    status.out.println("} else {");
    status.out.println("this.IDBASE=arguments[0];");
    status.out.println("this.LIV1=arguments[1];");
    status.out.println("this.LIV2=arguments[2];");
    status.out.println("this.LIV3=arguments[3];");
    status.out.println("this.N1=arguments[4];");
    status.out.println("this.N2=arguments[5];");
    status.out.println("this.N3=arguments[6];");
    status.out.println("this.N4=arguments[7];");
    status.out.println("this.N5=arguments[8];");
    status.out.println("this.N6=arguments[9];");
    status.out.println("this.N7=arguments[10];");
    status.out.println("this.C1=arguments[11];");
    status.out.println("this.C2=arguments[12];");
    status.out.println("this.C3=arguments[13];");
    status.out.println("this.C4=arguments[14];");
    status.out.println("this.C5=arguments[15];");
    status.out.println("this.C6=arguments[16];");
    status.out.println("this.C7=arguments[17];");
    status.out.println("this.BOX=arguments[18];");
    status.out.println("this.opk_IDBASE=arguments[19];");
    status.out.println("this.m_nRowStatus=arguments[20];");
    status.out.println("this.m_cOldRowCPCCCHK=arguments[21];");
    int lastRow;
    lastRow = 22;
    for ( l = 0; CPLib.lt(l,BO.m_MNTs.length); l = l + (1)) {
      if (BO.m_MNTs[l].RepeatedChild()) {
        status.out.println("this.m_cWv_"+BO.m_MNTs[l].m_cChildName+"=arguments["+(lastRow+l)+"];");
      }
    }
    status.out.println("}");
    status.out.println("}");
    status.out.println("function TrsToWork() {");
    status.out.println("var row;");
    status.out.println("row=m_oTrs[m_nCurrentRow];");
    status.out.println("if (Ne(row,null)) {");
    status.out.println("w_IDBASE=row.IDBASE;");
    status.out.println("w_LIV1=row.LIV1;");
    status.out.println("w_LIV2=row.LIV2;");
    status.out.println("w_LIV3=row.LIV3;");
    status.out.println("w_N1=row.N1;");
    status.out.println("w_N2=row.N2;");
    status.out.println("w_N3=row.N3;");
    status.out.println("w_N4=row.N4;");
    status.out.println("w_N5=row.N5;");
    status.out.println("w_N6=row.N6;");
    status.out.println("w_N7=row.N7;");
    status.out.println("w_C1=row.C1;");
    status.out.println("w_C2=row.C2;");
    status.out.println("w_C3=row.C3;");
    status.out.println("w_C4=row.C4;");
    status.out.println("w_C5=row.C5;");
    status.out.println("w_C6=row.C6;");
    status.out.println("w_C7=row.C7;");
    status.out.println("w_BOX=row.BOX;");
    if (CPLib.ne(status.m_cClientMode,"query")) {
      status.out.println("opk_IDBASE=row.opk_IDBASE;");
      status.out.println("m_nRowStatus=row.m_nRowStatus;");
      status.out.println("m_cOldRowCPCCCHK=row.m_cOldRowCPCCCHK;");
      for ( l = 0; CPLib.lt(l,BO.m_MNTs.length); l = l + (1)) {
        if (BO.m_MNTs[l].RepeatedChild()) {
          status.out.println("m_cWv_"+BO.m_MNTs[l].m_cChildName+"=row.m_cWv_"+BO.m_MNTs[l].m_cChildName+";");
        }
      }
      status.out.println("} else {");
      status.out.println("w_IDBASE='';");
      status.out.println("w_LIV1='';");
      status.out.println("w_LIV2='';");
      status.out.println("w_LIV3='';");
      status.out.println("w_N1=0;");
      status.out.println("w_N2=0;");
      status.out.println("w_N3=0;");
      status.out.println("w_N4=0;");
      status.out.println("w_N5=0;");
      status.out.println("w_N6=0;");
      status.out.println("w_N7=0;");
      status.out.println("w_C1='';");
      status.out.println("w_C2='';");
      status.out.println("w_C3='';");
      status.out.println("w_C4='';");
      status.out.println("w_C5='';");
      status.out.println("w_C6='';");
      status.out.println("w_C7='';");
      status.out.println("w_BOX='';");
      status.out.println("m_nRowStatus=2;");
      status.out.println("m_cOldRowCPCCCHK='';");
      for ( l = 0; CPLib.lt(l,BO.m_MNTs.length); l = l + (1)) {
        if (BO.m_MNTs[l].RepeatedChild()) {
          status.out.println("m_cWv_"+BO.m_MNTs[l].m_cChildName+"='';");
        }
      }
    }
    status.out.println("}");
    if (CPLib.ne(status.m_cClientMode,"query") && CPLib.ne(status.m_cClientMode,"view")) {
      status.out.println("SaveDependsOn();");
      status.out.println("SaveLabelDependsOn();");
    }
    status.out.println("}");
    status.out.println("_GridRowHeight='159';");
    WriteExtendedFieldsVars(BO.extendedFields,status);
    status.out.println("// * --- Area Manuale = UI - Declare Variables");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteMainFormScript(ardt_amldatiBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("if (IsIE()) {");
    status.out.println("if (Ne(document.readyState,'complete')) {");
    status.out.println("document.onreadystatechange=OnLoad;");
    status.out.println("return;");
    status.out.println("} else {");
    status.out.println("document.onreadystatechange=null;");
    status.out.println("}");
    status.out.println("}");
    if (CPLib.eq(status.m_nChildStatus,1)) {
      status.out.println("m_oFather=window[NameForCaller()];");
    } else if (CPLib.eq(status.m_nChildStatus,2)) {
      status.out.println("m_oFather=window.parent;");
    }
    if (status.m_bAutoFill) {
      status.out.println("if (IsWndAccessible(m_oFather)) {");
      status.out.println("SetFromContext(m_oFather.m_cWv_ardt_amldati);");
      status.out.println("}");
    }
    if (CPLib.eq(status.m_nChildStatus,1)) {
      status.out.println("m_cCPCCCHK="+SPLib.ToJSValue(status.m_cFatherCPCCCHK,"C",0,0)+";");
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("EnableEntity=EnableEntityWhenReady;");
    }
    status.out.println("_IAmReady=true;");
    if ((CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) && CPLib.gt(status.m_nChildStatus,0)) {
      status.out.println("if (IsWndAccessible(m_oFather)) {");
      status.out.println("m_oFather.SetChildVariables_ardt_amldati();");
      status.out.println("}");
    }
    status.out.println("AdjustTrs();");
    status.out.println("var l_cMode;");
    status.out.println("l_cMode=\""+status.m_cClientMode+"\";");
    WriteJSRestoreEntity(status);
    status.out.println("InitTable(Ctrl('GridTable'),l_cMode);");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("Z.Tabs.Get('tabs').InitSelect('ardt_amldati',Ne(m_nChildStatus,0));");
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('NSUYYWAOJV')) SetDisabled(c,true);");
      } else if (( ! (CPLib.Empty(status.m_cAltInterface))) && CPLib.eq(status.m_cClientMode,"query")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('UASFCHXLRC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AFSDOMRNZC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LMBDWDWYOJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OUCAYORICR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WFEQRDUEHK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AXLQDUTMKE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UQEGOTONHO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VLPHUFHRWG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RNANYATLJA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FGZMGIETJK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TTSVMTXSHK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BCQNNDGTFP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YQPUAGHCIC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VBELTUYZHN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BYRSYJQNCL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PCMHVKTTLL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RTBHNLUHZE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SWIJFJKKLJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OIVQOXTGIZ')) SetDisabled(c,true);");
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
    status.out.println("if (Eq(m_oFather,null)) {");
    if (CPLib.ne(status.m_cClientMode,"view")) {
      status.out.println("FocusFirstComponent();");
    }
    if (CPLib.eq(status.m_cClientMode,"query") && CPLib.gt(status.m_nChildStatus,0)) {
      status.out.println("} else if (m_bRowsChild) {");
      status.out.println("SetDisabled('NSUYYWAOJV',m_bRowsChild);");
    }
    status.out.println("}");
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('NSUYYWAOJV')) SetDisabled(c,true);");
      }
    }
    status.out.println("FillCombosValues();");
    status.out.println("SetControlsValue();");
    status.out.println("NotifyEvent('Record Loaded');");
    if (status.HasFoundlingChildren()) {
      status.out.println("LoadContext();");
      status.out.println("LoadContext(true);");
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
    status.out.println("function OnUnload() {");
    status.out.println("if (IsWndAccessible(m_oFather)) {");
    status.out.println("// * --- Area Manuale = UI - OnUnload");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("if (Eq(m_nChildStatus,1) && m_bResetOnUnload) {");
    status.out.println("m_oFather.m_oardt_amldati=null;");
    status.out.println("}");
    status.out.println("}");
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
  ardt_amldatiBO getBO(ServletStatus status) {
    ardt_amldatiBO BO = new ardt_amldatiBO(status.context);
    if (CPLib.eq(status.m_nChildStatus,0)) {
      LoadExtensions(BO);
    }
    return BO;
  }
  void LoadExtensions(ardt_amldatiBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("amldati",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,ardt_amldatiBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,ardt_amldatiBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
  }
  CPResultSet QueryKeyCursor(ardt_amldatiBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_amldati;
    String l_cPhName = BO.m_cPhName_amldati;
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
      String l_cQueryFilter = ardt_amldatiBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" distinct  "+BO.m_cVirtName_amldati+".IDAMLANNO"+(CPLib.Empty(status.m_cLastOrderBy) || CPLib.gt(CPLib.At(status.m_cLastOrderBy," distinct  "+BO.m_cVirtName_amldati+".IDAMLANNO"),0) || CPLib.ne(CPSql.GetDataBaseType(l_cServer),CPSql.m_nPostgres)?"":","+status.m_cLastOrderBy)+"",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("amldati");
    String l_cPhName = CPSql.ManipulateTablePhName("amldati",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altres� come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".IDAMLANNO"+(CPLib.Empty(status.m_cLastOrderBy) || CPLib.gt(CPLib.At(status.m_cLastOrderBy," "+l_cPhName+".IDAMLANNO"),0) || CPLib.ne(CPSql.GetDataBaseType(l_cServer),CPSql.m_nPostgres)?"":","+status.m_cLastOrderBy)+"",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,ardt_amldatiBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = ardt_amldatiBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (CPLib.eq(CPSql.GetDataBaseType(BO.m_cServer_amldati),CPSql.m_nInformix)) {
        if (l_rsCount!=null)
          l_rsCount.Close();
        l_rsCount = BO.m_Sql.Query(BO.m_cServer_amldati,CPSql.BuildSQLPhrase(" count( distinct  "+BO.m_cVirtName_amldati+".IDAMLANNO) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_amldati,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
      } else {
        if (l_rsCount!=null)
          l_rsCount.Close();
        l_rsCount = BO.m_Sql.Query(BO.m_cServer_amldati,CPSql.BuildSQLPhrase(" count(*) as reccount","("+CPSql.BuildSQLPhrase(" distinct  "+BO.m_cVirtName_amldati+".IDAMLANNO",CPLib.GetTablesWithAliases(BO.m_cPhName_amldati,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,"")+") CountFrom","",""));
      }
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
  void View(ServletStatus status,ardt_amldatiBO BO) {
    String _m = status.m_cMode;
    if ( ! (BO.m_bLoaded)) {
      Query(status,BO);
      LoadCurrentRecord(status,BO);
    }
    if (CPLib.eq(status.m_nChildStatus,0)) {
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
    }
    status.m_cClientMode = "view";
  }
  void Edit(ServletStatus status,ardt_amldatiBO BO,SPParameterSource source) {
    BO.Load(status.w_IDAMLANNO);
    if (BO.m_bLoaded && BO.CanEdit()) {
      if (CPLib.eq(BO.Rows(),0)) {
        BO.w_IDBASE = "";
        BO.w_LIV1 = "";
        BO.w_LIV2 = "";
        BO.w_LIV3 = "";
        BO.w_N1 = 0;
        BO.w_N2 = 0;
        BO.w_N3 = 0;
        BO.w_N4 = 0;
        BO.w_N5 = 0;
        BO.w_N6 = 0;
        BO.w_N7 = 0;
        BO.w_C1 = "";
        BO.w_C2 = "";
        BO.w_C3 = "";
        BO.w_C4 = "";
        BO.w_C5 = "";
        BO.w_C6 = "";
        BO.w_C7 = "";
        BO.w_BOX = "";
        BO.m_cOldRowCPCCCHK = "";
      } else {
        BO.SetRow(0);
      }
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
  void New(ServletStatus status,ardt_amldatiBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,ardt_amldatiBO BO,SPParameterSource source) {
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
      if ( ! (CPLib.Empty(l_cTrsMsgErr))) {
        l_bResult = false;
        l_bTrsOk = false;
        if (BO.m_Sql.CanTranslateErrorMessage()) {
          l_cTrsMsgErr = status.context.Translate("MSG_CANNOT_SAVE_DATA");
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
  void LoadCurrentRecord(ServletStatus status,ardt_amldatiBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_IDAMLANNO = "";
      } else {
        BO.w_IDAMLANNO = l_rsKeys.GetString("IDAMLANNO");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_IDAMLANNO = BO.w_IDAMLANNO;
        if (CPLib.eq(BO.Rows(),0)) {
          BO.w_IDBASE = "";
          BO.w_LIV1 = "";
          BO.w_LIV2 = "";
          BO.w_LIV3 = "";
          BO.w_N1 = 0;
          BO.w_N2 = 0;
          BO.w_N3 = 0;
          BO.w_N4 = 0;
          BO.w_N5 = 0;
          BO.w_N6 = 0;
          BO.w_N7 = 0;
          BO.w_C1 = "";
          BO.w_C2 = "";
          BO.w_C3 = "";
          BO.w_C4 = "";
          BO.w_C5 = "";
          BO.w_C6 = "";
          BO.w_C7 = "";
          BO.w_BOX = "";
          BO.m_cOldRowCPCCCHK = "";
        } else {
          BO.SetRow(0);
        }
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
  void EditLoad(ServletStatus status,ardt_amldatiBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,ardt_amldatiBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_IDAMLANNO);
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
  void DeleteMessage(ServletStatus status,ardt_amldatiBO BO,SPParameterSource source) {
    BO.Load(status.w_IDAMLANNO);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,ardt_amldatiBO BO) {
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
        if ( ! (CPLib.Empty(l_cTrsMsgErr))) {
          l_bResult = false;
          l_bTrsOk = false;
          if (BO.m_Sql.CanTranslateErrorMessage()) {
            l_cTrsMsgErr = status.context.Translate("MSG_CANNOT_SAVE_DATA");
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({IDAMLANNO:"+SPLib.ToJSValue(BO.w_IDAMLANNO,"C",4,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
  void Discard(ServletStatus status,ardt_amldatiBO BO) {
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
  void CreatePortlet(ServletStatus status,ardt_amldatiBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",287);
    item.put("w",652);
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
    item.put("altInterfaceFor","ardt_amldati");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"comment\":\"Anno riferimento\",\"h\":20,\"maxlength\":4,\"name\":\"IDAMLANNO\",\"page\":1,\"spuid\":\"NSUYYWAOJV\",\"tabindex\":1,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":36,\"x\":98,\"y\":49,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KOCAYKNGCM\",\"page\":1,\"spuid\":\"KOCAYKNGCM\",\"tabindex\":2,\"type\":\"Label\",\"value\":\"Anno riferimento:\",\"w\":92,\"x\":5,\"y\":53,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":162,\"name\":\"BodyDetail0\",\"page\":1,\"spuid\":\"CUGQFVCABS\",\"type\":\"BodyDetail\",\"w\":668,\"x\":20,\"y\":97,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"__body__grid__\",\"box_type\":\"layer\",\"h\":189,\"name\":\"Body_Row\",\"page\":1,\"shrinkable\":true,\"spuid\":\"VJUREVBTEF\",\"type\":\"Box\",\"w\":612,\"x\":20,\"y\":98,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"maxlength\":10,\"name\":\"IDBASE\",\"page\":1,\"repeated\":true,\"spuid\":\"UASFCHXLRC\",\"tabindex\":1,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":20,\"y\":99,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"maxlength\":3,\"name\":\"LIV1\",\"page\":1,\"repeated\":true,\"spuid\":\"AFSDOMRNZC\",\"tabindex\":2,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":97,\"y\":99,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"maxlength\":3,\"name\":\"LIV3\",\"page\":1,\"repeated\":true,\"spuid\":\"OUCAYORICR\",\"tabindex\":4,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":167,\"y\":99,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"maxlength\":18,\"name\":\"N1\",\"page\":1,\"repeated\":true,\"spuid\":\"WFEQRDUEHK\",\"tabindex\":5,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":202,\"y\":99,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"maxlength\":18,\"name\":\"N2\",\"page\":1,\"repeated\":true,\"spuid\":\"AXLQDUTMKE\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":309,\"y\":99,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"maxlength\":18,\"name\":\"N3\",\"page\":1,\"repeated\":true,\"spuid\":\"UQEGOTONHO\",\"tabindex\":7,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":416,\"y\":99,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"maxlength\":18,\"name\":\"N4\",\"page\":1,\"repeated\":true,\"spuid\":\"VLPHUFHRWG\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":20,\"y\":118,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"maxlength\":3,\"name\":\"LIV2\",\"page\":1,\"repeated\":true,\"spuid\":\"LMBDWDWYOJ\",\"tabindex\":3,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":132,\"y\":99,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"maxlength\":18,\"name\":\"N6\",\"page\":1,\"repeated\":true,\"spuid\":\"FGZMGIETJK\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":234,\"y\":118,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"maxlength\":18,\"name\":\"N7\",\"page\":1,\"repeated\":true,\"spuid\":\"TTSVMTXSHK\",\"tabindex\":11,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":341,\"y\":118,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"maxlength\":100,\"name\":\"C1\",\"page\":1,\"repeated\":true,\"spuid\":\"BCQNNDGTFP\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":20,\"y\":137,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"maxlength\":100,\"name\":\"C2\",\"page\":1,\"repeated\":true,\"spuid\":\"YQPUAGHCIC\",\"tabindex\":13,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":20,\"y\":156,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"maxlength\":100,\"name\":\"C3\",\"page\":1,\"repeated\":true,\"spuid\":\"VBELTUYZHN\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":20,\"y\":175,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"maxlength\":100,\"name\":\"C4\",\"page\":1,\"repeated\":true,\"spuid\":\"BYRSYJQNCL\",\"tabindex\":15,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":20,\"y\":194,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"maxlength\":100,\"name\":\"C5\",\"page\":1,\"repeated\":true,\"spuid\":\"PCMHVKTTLL\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":20,\"y\":213,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"maxlength\":100,\"name\":\"C6\",\"page\":1,\"repeated\":true,\"spuid\":\"RTBHNLUHZE\",\"tabindex\":17,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":20,\"y\":232,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"maxlength\":100,\"name\":\"C7\",\"page\":1,\"repeated\":true,\"spuid\":\"SWIJFJKKLJ\",\"tabindex\":18,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":20,\"y\":251,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"BOX\",\"page\":1,\"repeated\":true,\"scroll\":true,\"spuid\":\"OIVQOXTGIZ\",\"tabindex\":19,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":72,\"x\":20,\"y\":270,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"maxlength\":18,\"name\":\"N5\",\"page\":1,\"repeated\":true,\"spuid\":\"RNANYATLJA\",\"tabindex\":9,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":127,\"y\":118,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void DeleteRow(ServletStatus status,ardt_amldatiBO BO,SPParameterSource source) {
    int l_nRow = 0;
    boolean l_bFound = false;
    boolean l_bTrsOk = true;
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    BO.Load(status.w_IDAMLANNO);
    if (BO.m_bLoaded) {
      while (CPLib.lt(l_nRow,BO.m_oTrs.size()) &&  ! (l_bFound)) {
        l_bFound = CPLib.eqr(source.GetParameter("IDBASE",""),BO.m_oTrs.get(l_nRow).w_IDBASE);
        if ( ! (l_bFound)) {
          l_nRow = l_nRow+1;
        }
      }
      if (l_bFound) {
        BO.SetRow(l_nRow);
        if (BO.CanDeleteRow()) {
          BO.m_Sql.BeginTransaction();
          BO.DeleteRow();
          BO.Update();
          l_bTrsOk = BO.m_Sql.EndTransaction();
          if (l_bTrsOk) {
            status.m_bBODeleted = true;
          } else {
            status.m_bError = true;
            status.m_cErrMsg = BO.m_Sql.TransactionErrorMessage();
          }
        } else {
          status.m_bError = true;
          if (CPLib.ne(BO.m_cLastMsgError,"")) {
            status.m_cErrMsg = BO.m_cLastMsgError;
          }
        }
      }
    } else {
      status.m_bError = true;
      // Gestione dell'errore di transazione
      if (CPLib.ne(BO.m_cLastMsgError,"")) {
        status.m_cErrMsg = BO.m_cLastMsgError;
      }
    }
    if (l_bBringBack) {
      status.m_cClientMode = "bringback";
    }
  }
  void WriteFormPage(ardt_amldatiBO BO,ServletStatus status) {
    status.themeWriter = new SPTheme(status.out,status.GetThemeStatus("",status.context.Translate(entityGlobals.userName),status.context.Translate("MSG_FORM_FUNCTION_"+status.m_cClientMode.toUpperCase())),"form");
    status.out.println(
     "<!doctype html>" +
    "");
    status.out.println(
     "<html " + ( SPLib.IsMobile( status.request ) && status.m_nChildStatus != 2 ? "ps-stretch": "" )+ ">" +
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
     "<script src='ardt_amldati?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/ardt_amldati_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/ardt_amldati_edit.js'>" +
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
      status.out.println("w_IDAMLANNO=a[0];");
      status.out.println("w_IDBASE=a[1];");
      status.out.println("w_LIV1=a[2];");
      status.out.println("w_LIV2=a[3];");
      status.out.println("w_LIV3=a[4];");
      status.out.println("w_N1=a[5];");
      status.out.println("w_N2=a[6];");
      status.out.println("w_N3=a[7];");
      status.out.println("w_N4=a[8];");
      status.out.println("w_N5=a[9];");
      status.out.println("w_N6=a[10];");
      status.out.println("w_N7=a[11];");
      status.out.println("w_C1=a[12];");
      status.out.println("w_C2=a[13];");
      status.out.println("w_C3=a[14];");
      status.out.println("w_C4=a[15];");
      status.out.println("w_C5=a[16];");
      status.out.println("w_C6=a[17];");
      status.out.println("w_C7=a[18];");
      status.out.println("w_BOX=a[19];");
      status.out.println("m_PrimaryKeys=['IDBASE','IDAMLANNO'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/ardt_amldati_proc.js'>" +
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
    l_cJsUid = SPPrxycizer.proxycizedPath("SPBOUILib.Row.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("tablefuncts.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    WriteStyles(BO,status);
    status.out.println(
     "<title>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate(entityGlobals.userName))+"" +
     "</title>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("AppletTag('Trs',null,true);");
    if ( ! (status.m_bHasRS)) {
      status.out.println("AppletTag('Settings','Trs');");
    }
    status.out.println("AppletTag('Wv','Trs');");
    status.out.println("AppletTag('Batch');");
    status.out.println(
     "</script>" +
    "");
    status.m_cBodyAttributes = "onload=OnLoad() onunload=OnUnload() onhelp=CancelHelp()";
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.m_cBodyAttributes = status.m_cBodyAttributes+" onkeydown=window.ManageKeys(event,false,false)";
    } else {
      status.m_cBodyAttributes = status.m_cBodyAttributes+" onkeydown=window.ManageKeys(event,true,false)";
    }
    status.m_cBodyAttributes = status.m_cBodyAttributes+" onfocus=EnsureControlFocus()";
    status.themeWriter.WriteBody_Begin(287,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","amldati");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","IDAMLANNO");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(ardt_amldatiBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({IDAMLANNO:"+SPLib.ToJSValue(BO.w_IDAMLANNO,"C",4,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(ardt_amldatiBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({IDAMLANNO:"+SPLib.ToJSValue(BO.w_IDAMLANNO,"C",4,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(ardt_amldatiBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({IDAMLANNO:"+SPLib.ToJSValue(BO.w_IDAMLANNO,"C",4,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(ardt_amldatiBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({IDAMLANNO:"+SPLib.ToJSValue(BO.w_IDAMLANNO,"C",4,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(ardt_amldatiBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({IDAMLANNO:"+SPLib.ToJSValue(BO.w_IDAMLANNO,"C",4,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(ardt_amldatiBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(ardt_amldatiBO BO,ServletStatus status) throws IOException {
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
  public String GetCheckVars(ServletStatus status,ardt_amldatiBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_IDAMLANNO),"C",4,0));
      }
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,ardt_amldatiBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      int l_nRow = 0;
      org.json.JSONObject _detail = status.m_CheckVars.optJSONObject("_detail");
      if (CPLib.IsNull(_detail)) {
        _detail = new org.json.JSONObject();
      }
      while (CPLib.lt(l_nRow,BO.Rows())) {
        BO.SetRow(l_nRow);
        if (BO.IsRowUpdated()) {
          org.json.JSONObject _row = _detail.optJSONObject(String.valueOf(l_nRow));
          if (CPLib.IsNull(_row)) {
            _row = new org.json.JSONObject();
          }
        }
        l_nRow = l_nRow+1;
      }
    }
    return result;
  }
}
