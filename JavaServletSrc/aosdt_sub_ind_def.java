import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class aosdt_sub_ind_def extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*b94d92ae*!";
  static public class ServletStatus extends SPDetailChildServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "sub_ind_def";
    }
    public String w_IDMOD;
    public String w_IDIND;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_IDMOD,context,"sub_ind_def","IDMOD","C",10,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_IDIND,context,"sub_ind_def","IDIND","C",10,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='IDMOD' type='hidden' value="+SPLib.ToHTMLValue(w_IDMOD,"C",10,0)+">" +
        "");
        status.out.println(
         "<input name='IDIND' type='hidden' value="+SPLib.ToHTMLValue(w_IDIND,"C",10,0)+">" +
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
    aosdt_sub_ind_defBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_sub_ind_def;
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
      status.w_IDMOD = BO.w_IDMOD;
      status.w_IDIND = BO.w_IDIND;
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
    return "Sub Indicatori anomalia";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "aosdt_sub_ind_def";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 1450;
    l_eg.m_nEntityHeight = 62;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"sub_ind_def"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page"),new ZoneItem("Descrizione","Descrizione del subindicatore","layer")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"IDMOD","IDIND"};
    l_eg.keyRepeatedColumns = new String[]{"IDSUBIND"};
    l_eg.items = new SPItem[]{
                   new SPItem("IDMOD","C",10,0, "edit","ID del modello"),
                   new SPItem("IDIND","C",10,0, "edit","ID del indicatore"),
                   new SPItem("show_noapplic","L",1,0, "edit","Mostra i non applicabile"),
                   new SPItem("IDSUBIND","C",10,0, "edit","ID del subindicatore"),
                   new SPItem("PROGSUBIND","C",10,0, "edit","Progressivo subindicatore"),
                   new SPItem("DESCRI","M",10,0, "edit","Descrizione del subindicatore"),
                   new SPItem("PESO","N",15,2, "edit","Peso"),
                   new SPItem("INDRISCH","N",6,2, "edit","Indice di rischio"),
                   new SPItem("LOCKMIT","L",1,0, "edit","Subindicatore standard Immodificabile"),
                   new SPItem("NOAPPLIC","L",1,0, "edit","Subindicatore non applicabile"),
                   new SPItem("DESCRI_layer","M",10,0, "edit","Descrizione"),
                   new SPItem("open_layer","L",1,0, "hide",""),
                   new SPItem("write_layer","L",1,0, "hide","")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,aosdt_sub_ind_defBO BO) {
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
    l_translations=new String[][]{{"10024211400",p_Context.Translate("ID del modello")},
    {"10273053127",p_Context.Translate("Mostra i non applicabile")},
    {"10785547902",p_Context.Translate("ID del subindicatore")},
    {"11407848125",p_Context.Translate("Subindicatore standard Immodificabile")},
    {"11597693133",p_Context.Translate("Subindicatore non applicabile")},
    {"11707648908",p_Context.Translate("Sub Indicatori anomalia")},
    {"1305674908",p_Context.Translate("ID del indicatore")},
    {"1590172100",p_Context.Translate("Apri Descrizione")},
    {"1597949641",p_Context.Translate("'Impossibile cancellare un Subindicatore standard'")},
    {"1701052417",p_Context.Translate("Indice di rischio")},
    {"2042789061",p_Context.Translate("Riporta Descrizione")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"485792",p_Context.Translate("Peso")},
    {"601925191",p_Context.Translate("Descrizione del subindicatore")},
    {"75659037",p_Context.Translate("Subindicatore di anaomalia incompleto")},
    {"976616780",p_Context.Translate("Progressivo subindicatore")},
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
  void WriteStyles(aosdt_sub_ind_defBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../aosdt_sub_ind_def.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(aosdt_sub_ind_defBO BO,ServletStatus status) {
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
      status.out.println(".MXXMCLALYG {top:0px;position:absolute;left:0px;height:18px;width:83px;background-color:Transparent;z-index:1; }");
      status.out.println(".KWRCVYJSPV {top:0px;position:absolute;left:86px;color:#000000;font-family:icons8_win10;font-size:14px;cursor:pointer;border-style:none;z-index:3;}");
      status.out.println(".NGUCJOKSKM {top:0px;position:absolute;left:105px;height:18px;width:868px;overflow:auto;background-color:Transparent;z-index:1; }");
      status.out.println(".YPEGROOCHF {top:0px;position:absolute;left:975px;height:18px;width:118px;text-align:right;background-color:Transparent;z-index:1; }");
      status.out.println(".VDSUAVUBNI {top:0px;position:absolute;left:1095px;height:18px;width:55px;text-align:right;background-color:Transparent;z-index:1; }");
      status.out.println(".OIJUVIXRQN_DIV {top:0px;position:absolute;left:1152px;height:19px;width:134px;overflow:hidden;white-space:nowrap;z-index:1; }");
      status.out.println(".ACJAWRNAVO_DIV {top:0px;position:absolute;left:1289px;height:19px;width:136px;overflow:hidden;white-space:nowrap;z-index:1; }");
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
      status.out.println("Z.Tabs.Get('tabs').InitSelect('aosdt_sub_ind_def',true);");
    }
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"aosdt_sub_ind_def",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(aosdt_sub_ind_defBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,2);
  }
  void WriteControls_p1(aosdt_sub_ind_defBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:62px;width:1450px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteControls_p1_b1(BO,status);
    WriteControls_p1_b2(BO,status);
    WriteControls_p1_l0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"PAGE_1");
    PrintSidebarContent(1,status,getSidebarItems(0),true);
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
  void WriteControls_p1_l0(aosdt_sub_ind_defBO BO,ServletStatus status) {
    status.out.println(
     "<div style='display:none' class='LayerContainer' id='VGASZRXNOJ_DIV'>" +
     "<div id='VGASZRXNOJ_HEADER' onmousedown=\"dragLayer(event,'VGASZRXNOJ_DIV')\" class='LayerHeader'><span id='VGASZRXNOJ_HEADER_CAPTION' class='LayerHeaderCaption'>"+status.context.Translate("Descrizione del subindicatore")+"</span>"+com.zucchetti.sitepainter.Library.GenerateIcon(com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "layerHeaderPinImage", "../"+status.m_cTheme+"/formPage/box_layer_pin.gif"), "", "", "onclick='TogglePinLayerBox(\"VGASZRXNOJ\")' alt='"+status.context.Translate("MSG_PIN_UNPIN")+"' title='"+status.context.Translate("MSG_PIN_UNPIN")+"' class='LayerHeaderIconPin'", "id='VGASZRXNOJ_HEADER_ICON_PIN'")+""+com.zucchetti.sitepainter.Library.GenerateIcon(com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "layerHeaderCloseImage", "../"+status.m_cTheme+"/formPage/box_layer_close.gif"), "", "", "onclick='HideLayerBox(\"VGASZRXNOJ_DIV\",false)' alt='"+status.context.Translate("MSG_CLOSE_ONEXIT")+"' title='"+status.context.Translate("MSG_CLOSE_ONEXIT")+"' class='LayerHeaderIconClose'")+"</div>" +
     "<div id='VGASZRXNOJ' class='LayerBody'>" +
    "");
    if (status.includeZoneAltInterface(status.context,"Descrizione")) {
    } else {
      status.out.println(
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<textarea name='DESCRI_layer' id='ATCXZHNKXY' class='Memo "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' title="+SPLib.ToHTMLValue(status.context.Translate("Descrizione"),"C",0,0)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" cols='20' rows='2'>" +
       "</textarea>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='"+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"javascript:void(0)":"javascript:href_TVQHCLXOGQ()")+"' tabindex='"+status.m_nTabIndex+"' id='TVQHCLXOGQ_HREF' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
       "<span id='TVQHCLXOGQ' title="+SPLib.ToHTMLValue(status.context.Translate("Riporta Descrizione"),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation(Character.toString((char)62160))+"" +
       "</span>" +
       "</a>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='LastLayerElement' type='text' class='Field' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
      "");
    }
    status.out.println(
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('VGASZRXNOJ_DIV').setAttribute('pin_status','unpinned');");
    if (CPLib.IsNull(status.GetZoneAltInterface("Descrizione"))) {
    } else {
      status.out.println("Ctrl('VGASZRXNOJ').style.height='auto';");
    }
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b0(aosdt_sub_ind_defBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_1' style='position:relative;height:21px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_TOP_OF_PAGE_1').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<div name id='GridTable_Header' class='GridTable_Header' style='position:absolute;top:0px;left:3px;height:20px;width:1447px;z-index:0'>" +
       "</div>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span title="+SPLib.ToHTMLValue(status.context.Translate("Mostra i non applicabile"),"C",0,0)+" id='KSVRAIFHEU_DIV' style='display:none'>" +
       "<input name='show_noapplic' id='KSVRAIFHEU' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_show_noapplic,"L",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"disabled":"")+" "+(CPLib.eq(true,BO.w_show_noapplic)?"CHECKED":"")+">" +
       "<label id='KSVRAIFHEU_LBL' for='KSVRAIFHEU' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Mostra i non applicabile"))+"</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel GridTable_HeaderTitle' id='LZTSHRFCON_DIV'>" +
       "<label id='LZTSHRFCON' for='MXXMCLALYG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Progressivo"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel GridTable_HeaderTitle' id='QETIXKMQMF_DIV'>" +
       "<label id='QETIXKMQMF' for='NGUCJOKSKM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Descrizione del subindicatore"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel GridTable_HeaderTitle' id='AATZTVXUOM_DIV'>" +
       "<label id='AATZTVXUOM' for='YPEGROOCHF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Peso"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel GridTable_HeaderTitle' id='ALDLRRKGHX_DIV'>" +
       "<label id='ALDLRRKGHX' for='VDSUAVUBNI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Rischio"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel GridTable_HeaderTitle' id='OLTCDBKKZK_DIV'>" +
       "<label id='OLTCDBKKZK' for='OIJUVIXRQN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Immodificabile"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel GridTable_HeaderTitle' id='NCBLOOVGYK_DIV'>" +
       "<label id='NCBLOOVGYK' for='ACJAWRNAVO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Non Applicabile"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b1(aosdt_sub_ind_defBO BO,ServletStatus status) {
    status.out.println(
     "<div id='GridTable_Band_DIV'>" +
    "");
    status.out.println(
     "<div id='GridTable_Band' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("GridTable@BEGIN");
    if (status.includeZoneAltInterface("GridTable")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("GridTable@BEGIN") || status.HasZoneAltInterface("GridTable@END")) {
        status.out.println(
         "<div id='GridTable_Band_boxContent' style='position:relative;height:82px;display:block'>" +
        "");
      }
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IDMOD' id='ZZCYHWIBYI' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_IDMOD,"C",10,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ID del modello"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='10' size='10' fieldtype='C' style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IDIND' id='VCVGRLKIYI' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_IDIND,"C",10,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ID del indicatore"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='10' size='10' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<div id='GridTable_Container' style='position:relative;top:0px;left:3px;min-height:75px;max-height:336px;width:1447px;overflow:hidden' class='GridTable_Container "+SPLib.ToHTML(status.m_cClientMode,"C",0,0)+"'>" +
       "<div id=GridTable_LockedScroll style='position:absolute;top:0px;left:0px;height:81px;width:1447px;overflow:scroll'>" +
       "</div>" +
       "</div>" +
      "");
      status.out.println(
       "<div id='GridTable_DIV' style='position:relative;left:0;top:0;width:1447px;min-height:75px;max-height:336px;overflow:auto;'>" +
       "<table id='GridTable' style='position:relative;top:0px;left:0px;width:1441px' cellspacing='0' cellpadding='0' border='0'>" +
       "<tr>" +
       "<td></td>" +
       "</tr>" +
       "</table>" +
       "</div>" +
      "");
      if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println(
         "<div id='GridTable_ButtonPanel' style='position:absolute;top:0px;left:5px;z-index:4'>" +
         ""+printButtonPanelContent(status,0,"upper_right",true,getDetailMenuItems(),false,"")+"" +
         "</div>" +
        "");
      }
      status.out.println(
       "<div class='GridTable_VerticalLines' style='position:absolute;top:0px;left:89px;height:100%;width:1px'>" +
       "</div>" +
      "");
      status.out.println(
       "<div class='GridTable_VerticalLines' style='position:absolute;top:0px;left:109px;height:100%;width:1px'>" +
       "</div>" +
      "");
      status.out.println(
       "<div class='GridTable_VerticalLines' style='position:absolute;top:0px;left:979px;height:100%;width:1px'>" +
       "</div>" +
      "");
      status.out.println(
       "<div class='GridTable_VerticalLines' style='position:absolute;top:0px;left:1099px;height:100%;width:1px'>" +
       "</div>" +
      "");
      status.out.println(
       "<div class='GridTable_VerticalLines' style='position:absolute;top:0px;left:1156px;height:100%;width:1px'>" +
       "</div>" +
      "");
      status.out.println(
       "<div class='GridTable_VerticalLines' style='position:absolute;top:0px;left:1292px;height:100%;width:1px'>" +
       "</div>" +
      "");
      HTMLRowScript(BO,status);
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IDSUBIND' id='KQDZVNZECK' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_IDSUBIND,"C",10,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ID del subindicatore"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='10' size='10' fieldtype='C' style='display:none'>" +
      "");
      if (status.HasZoneAltInterface("GridTable@BEGIN") || status.HasZoneAltInterface("GridTable@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b1_CloseBand(aosdt_sub_ind_defBO BO,ServletStatus status) {
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void HTMLRowScript(aosdt_sub_ind_defBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder = null;
    status.out.println(
     "<script>" +
    "");
    status.out.println("function HTMLRow(editable,rowtoshow) {");
    status.out.println("var s;");
    status.out.println("s='<div style=\"position:relative;width:1425px;height:14px;\"';");
    status.out.println("s=s+'>';");
    status.out.println("var row;");
    status.out.println("var prefix;");
    status.out.println("var w_IDSUBIND;");
    status.out.println("var w_PROGSUBIND;");
    status.out.println("var w_DESCRI;");
    status.out.println("var w_PESO;");
    status.out.println("var w_INDRISCH;");
    status.out.println("var w_LOCKMIT;");
    status.out.println("var w_NOAPPLIC;");
    status.out.println("var w_DESCRI_layer;");
    status.out.println("var w_open_layer;");
    status.out.println("var w_write_layer;");
    status.out.println("if (Eq(rowtoshow,null)) {");
    status.out.println("row=window;");
    status.out.println("prefix='w_';");
    status.out.println("} else {");
    status.out.println("row=rowtoshow;");
    status.out.println("prefix='';");
    status.out.println("}");
    status.out.println("w_IDSUBIND=row[prefix+'IDSUBIND'];");
    status.out.println("w_PROGSUBIND=row[prefix+'PROGSUBIND'];");
    status.out.println("w_DESCRI=row[prefix+'DESCRI'];");
    status.out.println("w_PESO=row[prefix+'PESO'];");
    status.out.println("w_INDRISCH=row[prefix+'INDRISCH'];");
    status.out.println("w_LOCKMIT=row[prefix+'LOCKMIT'];");
    status.out.println("w_NOAPPLIC=row[prefix+'NOAPPLIC'];");
    status.out.println("w_DESCRI_layer=row[prefix+'DESCRI_layer'];");
    status.out.println("w_open_layer=row[prefix+'open_layer'];");
    status.out.println("w_write_layer=row[prefix+'write_layer'];");
    status.out.println("if (editable) {");
    status.out.println("if (Gt(m_nCurrentRow,0)) {");
    status.out.println("s=s+\""+
     "<input name='BeforeDetailElement' type='text' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
    "\"");
    status.out.println("}");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='PROGSUBIND' id='MXXMCLALYG' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_PROGSUBIND),'C',10,0,'')+\"' title="+SPLib.ToHTMLValue(status.context.Translate("Progressivo subindicatore"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='10' size='10' fieldtype='C'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<a href='javascript:href_KWRCVYJSPV()' tabindex='"+status.m_nTabIndex+"' id='KWRCVYJSPV_HREF' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<span id='KWRCVYJSPV' class=' GridTable_EditRowItem ' title="+SPLib.ToHTMLValue(status.context.Translate("Apri Descrizione"),"C",0,0)+">" +
     ""+SPLib.ToHTMLRepresentation(Character.toString((char)59899))+"" +
     "</span>" +
     "</a>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<textarea name='DESCRI' id='NGUCJOKSKM' class='Memo GridTable_EditRowItem ' title="+SPLib.ToHTMLValue(status.context.Translate("Descrizione del subindicatore"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" cols='20' rows='2'>" +
     "</textarea>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='PESO' id='YPEGROOCHF' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(w_PESO,'N',15,2,'999,999,999,999.99')+\"' title="+SPLib.ToHTMLValue(status.context.Translate("Peso"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='21' size='15' fieldtype='N'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='INDRISCH' id='VDSUAVUBNI' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(w_INDRISCH,'N',6,2,'999.99')+\"' title="+SPLib.ToHTMLValue(status.context.Translate("Indice di rischio"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='9' size='6' fieldtype='N'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<span class=' GridTable_EditRowItem ' title="+SPLib.ToHTMLValue(status.context.Translate("Subindicatore standard Immodificabile"),"C",0,0)+" id='OIJUVIXRQN_DIV'>" +
     "<input name='LOCKMIT' id='OIJUVIXRQN' type='checkbox' value='' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" \"+(Eq(true,w_LOCKMIT)?'CHECKED':'')+\">" +
     "</span>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<span class=' GridTable_EditRowItem ' title="+SPLib.ToHTMLValue(status.context.Translate("Subindicatore non applicabile"),"C",0,0)+" id='ACJAWRNAVO_DIV'>" +
     "<input name='NOAPPLIC' id='ACJAWRNAVO' type='checkbox' value='' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" \"+(Eq(true,w_NOAPPLIC)?'CHECKED':'')+\">" +
     "</span>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(3);
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.m_nAfterDetailElementTabIndex = status.m_nTabIndex;
    status.out.println("s=s+\""+
     "<input name='AfterDetailElement' type='text' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(-3);
    status.m_nTabIndex = status.m_nTabIndex-(1);
    status.out.println("} else {");
    status.out.println("if ( ! (IsHiddenByStateDriver('PROGSUBIND'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem MXXMCLALYG' value='\"+WtH(ToHTML(w_PROGSUBIND),'C',10,0,'')+\"' tabindex='-1' readonly size='10'>" +
    "\"");
    status.out.println("}");
    status.out.println("s=s+\""+
     "<a href='javascript:void(0)'>" +
     "<span class='GridTable_QueryRowItem KWRCVYJSPV' title="+SPLib.ToHTMLValue(status.context.Translate("Apri Descrizione"),"C",0,0)+">" +
     ""+SPLib.ToHTMLRepresentation(Character.toString((char)59899))+"" +
     "</span>" +
     "</a>" +
    "\"");
    status.out.println("if ( ! (IsHiddenByStateDriver('DESCRI'))) {");
    status.out.println("s=s+\""+
     "<textarea class='GridTable_QueryRowItem NGUCJOKSKM' disabled cols='20' rows='2'>" +
     "\"+WtH(w_DESCRI,'M',10,0,'"+""+"')+\"" +
     "</textarea>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('PESO'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem YPEGROOCHF' value='\"+WtH(w_PESO,'N',15,2,'999,999,999,999.99')+\"' tabindex='-1' readonly size='15'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('INDRISCH'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem VDSUAVUBNI' value='\"+WtH(w_INDRISCH,'N',6,2,'999.99')+\"' tabindex='-1' readonly size='6'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('LOCKMIT'))) {");
    status.out.println("s=s+\""+
     "<span class='GridTable_QueryRowItem OIJUVIXRQN_DIV'>" +
     "<input type='checkbox' value='' disabled \"+(Eq(true,w_LOCKMIT)?'CHECKED':'')+\">" +
     "</span>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('NOAPPLIC'))) {");
    status.out.println("s=s+\""+
     "<span class='GridTable_QueryRowItem ACJAWRNAVO_DIV'>" +
     "<input type='checkbox' value='' disabled \"+(Eq(true,w_NOAPPLIC)?'CHECKED':'')+\">" +
     "</span>" +
    "\"");
    status.out.println("}");
    status.out.println("s=s+'<div style=\" position:absolute;z-index:2;width:1425px;height:14px;\"></div>';");
    status.out.println("}");
    status.out.println("s=s+'</div>';");
    status.out.println("return s;");
    status.out.println("}");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(aosdt_sub_ind_defBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_END_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_END_OF_PAGE_1' style='position:relative;height:0px;display:none' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_END_OF_PAGE_1")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_END_OF_PAGE_1').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "</div>" +
      "");
    }
  }
  static void PrintState(aosdt_sub_ind_defBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(aosdt_sub_ind_defBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
  }
  static void PrintStateWorkVars(aosdt_sub_ind_defBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_IDMOD,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDIND,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDSUBIND,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROGSUBIND,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCRI,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PESO,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_INDRISCH,"N",6,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_LOCKMIT,"L",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOAPPLIC,"L",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_show_noapplic,"L",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCRI_layer,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_open_layer,"L",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_write_layer,"L",1,0));
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
    PrintStateDetailWorkVars(BO,status);
  }
  static void PrintStateDetailWorkVars(aosdt_sub_ind_defBL BO,ServletStatus status) {
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
      status.out.print(""+SPLib.ToJSValue(BO.w_IDSUBIND,"C",10,0)+",");
      if ( ! (l_bForceSelect) && CPLib.eq(l_nSelectRow,k) && ( ! (status.source.Has("IDSUBIND")) || CPLib.ne(CPLib.RTrim(BO.w_IDSUBIND),status.source.GetParameter("IDSUBIND","")))) {
        l_nSelectRow = -1;
      }
      status.out.print(""+SPLib.ToJSValue(BO.w_PROGSUBIND,"C",10,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_DESCRI,"M",10,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_PESO,"N",15,2)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_INDRISCH,"N",6,2)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_LOCKMIT,"L",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_NOAPPLIC,"L",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_DESCRI_layer,"M",10,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_open_layer,"L",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_write_layer,"L",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.opk_IDSUBIND,"N",0,0)+",");
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
  static void PrintStateDetailWorkVars_Deleted(aosdt_sub_ind_defBL BO,ServletStatus status) {
    String l_cTrs;
    int k;
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      aosdt_sub_ind_defBO.TrsRow l_Row;
      l_cTrs = "[";
      k = 0;
      while (CPLib.lt(k,BO.m_oDeletedRows.size())) {
        l_Row= (aosdt_sub_ind_defBO.TrsRow) BO.m_oDeletedRows.get(k);
        l_cTrs = l_cTrs+" new TrsRow(";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_IDSUBIND,"C",10,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_PROGSUBIND,"C",10,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_DESCRI,"M",10,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_PESO,"N",15,2)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_INDRISCH,"N",6,2)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_LOCKMIT,"L",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_NOAPPLIC,"L",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_DESCRI_layer,"M",10,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_open_layer,"L",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_write_layer,"L",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.opk_IDSUBIND,"N",0,0)+",";
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
      status.out.println("opk_IDSUBIND="+SPLib.ToJSValue(BO.opk_IDSUBIND,"N",0,0)+";");
    }
  }
  void WriteMainFormVarScript(aosdt_sub_ind_defBO BO,ServletStatus status) {
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(62,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(1450,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"aosdt_sub_ind_def"),"C",0,0)+ ";");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("aosdt_sub_ind_def","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"aosdt_sub_ind_def",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("Descrizione"),"")) {
      status.quoteAndAppend("Descrizione","hide","box");
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
    status.out.println("var m_bAlternateColorRows = " + SPLib.ToJSValue(true,"L",0,0)+ ";");
    status.out.println("var m_nMinDetailRows = 5;");
    status.out.println("var m_nMaxDetailRows = 22;");
    status.out.println("var m_nLayerInBodyRowHeight = 96;");
    status.out.println("var m_nLayerInBodyRowId = 'VGASZRXNOJ';");
    status.out.println("function TrsRow() {");
    status.out.println("if (Eq(arguments.length,1)) {");
    status.out.println("this.IDSUBIND=w_IDSUBIND;");
    status.out.println("this.PROGSUBIND=w_PROGSUBIND;");
    status.out.println("this.DESCRI=w_DESCRI;");
    status.out.println("this.PESO=w_PESO;");
    status.out.println("this.INDRISCH=w_INDRISCH;");
    status.out.println("this.LOCKMIT=w_LOCKMIT;");
    status.out.println("this.NOAPPLIC=w_NOAPPLIC;");
    status.out.println("this.DESCRI_layer=w_DESCRI_layer;");
    status.out.println("this.open_layer=w_open_layer;");
    status.out.println("this.write_layer=w_write_layer;");
    status.out.println("this.opk_IDSUBIND=opk_IDSUBIND;");
    status.out.println("this.m_nRowStatus=arguments[0];");
    status.out.println("this.m_cOldRowCPCCCHK=m_cOldRowCPCCCHK;");
    int l;
    for ( l = 0; CPLib.lt(l,BO.m_MNTs.length); l = l + (1)) {
      if (BO.m_MNTs[l].RepeatedChild()) {
        status.out.println("this.m_cWv_"+BO.m_MNTs[l].m_cChildName+"=m_cWv_"+BO.m_MNTs[l].m_cChildName+";");
      }
    }
    status.out.println("} else {");
    status.out.println("this.IDSUBIND=arguments[0];");
    status.out.println("this.PROGSUBIND=arguments[1];");
    status.out.println("this.DESCRI=arguments[2];");
    status.out.println("this.PESO=arguments[3];");
    status.out.println("this.INDRISCH=arguments[4];");
    status.out.println("this.LOCKMIT=arguments[5];");
    status.out.println("this.NOAPPLIC=arguments[6];");
    status.out.println("this.DESCRI_layer=arguments[7];");
    status.out.println("this.open_layer=arguments[8];");
    status.out.println("this.write_layer=arguments[9];");
    status.out.println("this.opk_IDSUBIND=arguments[10];");
    status.out.println("this.m_nRowStatus=arguments[11];");
    status.out.println("this.m_cOldRowCPCCCHK=arguments[12];");
    int lastRow;
    lastRow = 13;
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
    status.out.println("w_IDSUBIND=row.IDSUBIND;");
    status.out.println("w_PROGSUBIND=row.PROGSUBIND;");
    status.out.println("w_DESCRI=row.DESCRI;");
    status.out.println("w_PESO=row.PESO;");
    status.out.println("w_INDRISCH=row.INDRISCH;");
    status.out.println("w_LOCKMIT=row.LOCKMIT;");
    status.out.println("w_NOAPPLIC=row.NOAPPLIC;");
    status.out.println("w_DESCRI_layer=row.DESCRI_layer;");
    status.out.println("w_open_layer=row.open_layer;");
    status.out.println("w_write_layer=row.write_layer;");
    if (CPLib.ne(status.m_cClientMode,"query")) {
      status.out.println("opk_IDSUBIND=row.opk_IDSUBIND;");
      status.out.println("m_nRowStatus=row.m_nRowStatus;");
      status.out.println("m_cOldRowCPCCCHK=row.m_cOldRowCPCCCHK;");
      for ( l = 0; CPLib.lt(l,BO.m_MNTs.length); l = l + (1)) {
        if (BO.m_MNTs[l].RepeatedChild()) {
          status.out.println("m_cWv_"+BO.m_MNTs[l].m_cChildName+"=row.m_cWv_"+BO.m_MNTs[l].m_cChildName+";");
        }
      }
      status.out.println("} else {");
      status.out.println("w_IDSUBIND=LibreriaMit.UniqueId();");
      status.out.println("w_PROGSUBIND='';");
      status.out.println("w_DESCRI='';");
      status.out.println("w_PESO=0;");
      status.out.println("w_INDRISCH=0;");
      status.out.println("w_LOCKMIT=false;");
      status.out.println("w_NOAPPLIC=false;");
      status.out.println("w_DESCRI_layer=w_DESCRI;");
      status.out.println("w_open_layer=false;");
      status.out.println("w_write_layer=true;");
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
    status.out.println("_GridRowHeight='14';");
    WriteExtendedFieldsVars(BO.extendedFields,status);
    status.out.println("// * --- Area Manuale = UI - Declare Variables");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteMainFormScript(aosdt_sub_ind_defBO BO,ServletStatus status) {
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
      status.out.println("SetFromContext(m_oFather.m_cWv_aosdt_sub_ind_def);");
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
      status.out.println("m_oFather.SetChildVariables_aosdt_sub_ind_def();");
      status.out.println("}");
    }
    status.out.println("AdjustTrs();");
    status.out.println("var l_cMode;");
    status.out.println("l_cMode=\""+status.m_cClientMode+"\";");
    WriteJSRestoreEntity(status);
    status.out.println("InitTable(Ctrl('GridTable'),l_cMode);");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("Z.Tabs.Get('tabs').InitSelect('aosdt_sub_ind_def',Ne(m_nChildStatus,0));");
    } else {
      status.out.println("calculateSidebarBandsPosition('page_1');");
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('ZZCYHWIBYI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VCVGRLKIYI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KSVRAIFHEU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KQDZVNZECK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ATCXZHNKXY')) SetDisabled(c,true);");
      } else if (( ! (CPLib.Empty(status.m_cAltInterface))) && CPLib.eq(status.m_cClientMode,"query")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('KQDZVNZECK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MXXMCLALYG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NGUCJOKSKM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YPEGROOCHF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VDSUAVUBNI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OIJUVIXRQN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ACJAWRNAVO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ATCXZHNKXY')) SetDisabled(c,true);");
      }
      status.out.println("HideControlsUnderCondition();");
      status.out.println("ExpandCollapseBoxesUnderCondition();");
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
      status.out.println("SetDisabled('ZZCYHWIBYI',m_bRowsChild);");
      status.out.println("SetDisabled('VCVGRLKIYI',m_bRowsChild);");
      status.out.println("SetDisabled('KSVRAIFHEU',m_bRowsChild);");
    }
    status.out.println("}");
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('ZZCYHWIBYI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VCVGRLKIYI')) SetDisabled(c,true);");
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
    status.out.println("m_oFather.m_oaosdt_sub_ind_def=null;");
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
  aosdt_sub_ind_defBO getBO(ServletStatus status) {
    aosdt_sub_ind_defBO BO = new aosdt_sub_ind_defBO(status.context);
    if (CPLib.eq(status.m_nChildStatus,0)) {
      LoadExtensions(BO);
    }
    return BO;
  }
  void LoadExtensions(aosdt_sub_ind_defBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("sub_ind_def",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,aosdt_sub_ind_defBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,aosdt_sub_ind_defBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
  }
  CPResultSet QueryKeyCursor(aosdt_sub_ind_defBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_sub_ind_def;
    String l_cPhName = BO.m_cPhName_sub_ind_def;
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
      String l_cQueryFilter = aosdt_sub_ind_defBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" distinct  "+BO.m_cVirtName_sub_ind_def+".IDMOD, "+BO.m_cVirtName_sub_ind_def+".IDIND"+(CPLib.Empty(status.m_cLastOrderBy) || CPLib.gt(CPLib.At(status.m_cLastOrderBy," distinct  "+BO.m_cVirtName_sub_ind_def+".IDMOD, "+BO.m_cVirtName_sub_ind_def+".IDIND"),0) || CPLib.ne(CPSql.GetDataBaseType(l_cServer),CPSql.m_nPostgres)?"":","+status.m_cLastOrderBy)+"",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("sub_ind_def");
    String l_cPhName = CPSql.ManipulateTablePhName("sub_ind_def",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altres� come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".IDMOD, "+l_cPhName+".IDIND"+(CPLib.Empty(status.m_cLastOrderBy) || CPLib.gt(CPLib.At(status.m_cLastOrderBy," "+l_cPhName+".IDMOD, "+l_cPhName+".IDIND"),0) || CPLib.ne(CPSql.GetDataBaseType(l_cServer),CPSql.m_nPostgres)?"":","+status.m_cLastOrderBy)+"",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,aosdt_sub_ind_defBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = aosdt_sub_ind_defBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (CPLib.eq(CPSql.GetDataBaseType(BO.m_cServer_sub_ind_def),CPSql.m_nInformix)) {
        if (l_rsCount!=null)
          l_rsCount.Close();
        l_rsCount = BO.m_Sql.Query(BO.m_cServer_sub_ind_def,CPSql.BuildSQLPhrase(" count( distinct  "+BO.m_cVirtName_sub_ind_def+".IDMOD, "+BO.m_cVirtName_sub_ind_def+".IDIND) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_sub_ind_def,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
      } else {
        if (l_rsCount!=null)
          l_rsCount.Close();
        l_rsCount = BO.m_Sql.Query(BO.m_cServer_sub_ind_def,CPSql.BuildSQLPhrase(" count(*) as reccount","("+CPSql.BuildSQLPhrase(" distinct  "+BO.m_cVirtName_sub_ind_def+".IDMOD, "+BO.m_cVirtName_sub_ind_def+".IDIND",CPLib.GetTablesWithAliases(BO.m_cPhName_sub_ind_def,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,"")+") CountFrom","",""));
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
  void View(ServletStatus status,aosdt_sub_ind_defBO BO) {
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
  void Edit(ServletStatus status,aosdt_sub_ind_defBO BO,SPParameterSource source) {
    BO.Load(status.w_IDMOD,status.w_IDIND);
    if (BO.m_bLoaded && BO.CanEdit()) {
      if (CPLib.eq(BO.Rows(),0)) {
        BO.w_IDSUBIND = "";
        BO.w_PROGSUBIND = "";
        BO.w_DESCRI = "";
        BO.w_PESO = 0;
        BO.w_INDRISCH = 0;
        BO.w_LOCKMIT = false;
        BO.w_NOAPPLIC = false;
        BO.w_DESCRI_layer = "";
        BO.w_open_layer = false;
        BO.w_write_layer = false;
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
  void New(ServletStatus status,aosdt_sub_ind_defBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,aosdt_sub_ind_defBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,aosdt_sub_ind_defBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_IDMOD = "";
        status.w_IDIND = "";
      } else {
        BO.w_IDMOD = l_rsKeys.GetString("IDMOD");
        BO.w_IDIND = l_rsKeys.GetString("IDIND");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_IDMOD = BO.w_IDMOD;
        status.w_IDIND = BO.w_IDIND;
        if (CPLib.eq(BO.Rows(),0)) {
          BO.w_IDSUBIND = "";
          BO.w_PROGSUBIND = "";
          BO.w_DESCRI = "";
          BO.w_PESO = 0;
          BO.w_INDRISCH = 0;
          BO.w_LOCKMIT = false;
          BO.w_NOAPPLIC = false;
          BO.w_DESCRI_layer = "";
          BO.w_open_layer = false;
          BO.w_write_layer = false;
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
  void EditLoad(ServletStatus status,aosdt_sub_ind_defBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,aosdt_sub_ind_defBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_IDMOD,status.w_IDIND);
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
  void DeleteMessage(ServletStatus status,aosdt_sub_ind_defBO BO,SPParameterSource source) {
    BO.Load(status.w_IDMOD,status.w_IDIND);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,aosdt_sub_ind_defBO BO) {
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({IDMOD:"+SPLib.ToJSValue(BO.w_IDMOD,"C",10,0)+",IDIND:"+SPLib.ToJSValue(BO.w_IDIND,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
      // valorizzazione dei placeholder del workflow: l'Initialize cancella i valori nel BO e solo in questo punto conosco i valori di campi in chiave sottoposti ad autonumber
      SetWorkflowPlaceholders(status,BO);
      if (CPLib.eq(status.m_cMode,"new")) {
        if (CPLib.ne(CPLib.Left(status.m_cAtExit,5),"close") && CPLib.ne(status.m_cAtExit,"edit")) {
          New(status,BO,null);
        }
      } else {
        status.m_cClientMode = "query";
        Collections.sort(BO.m_oTrs,new OrderBodyByComparator());
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
  void Discard(ServletStatus status,aosdt_sub_ind_defBO BO) {
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
  void CreatePortlet(ServletStatus status,aosdt_sub_ind_defBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",42);
    item.put("w",1450);
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
    item.put("altInterfaceFor","aosdt_sub_ind_def");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"align\":\"right\",\"h\":18,\"name\":\"label_AATZTVXUOM\",\"page\":1,\"spuid\":\"AATZTVXUOM\",\"tabindex\":6,\"type\":\"Label\",\"value\":\"Peso\",\"w\":118,\"x\":980,\"y\":1,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_LZTSHRFCON\",\"page\":1,\"spuid\":\"LZTSHRFCON\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"Progressivo\",\"w\":83,\"x\":5,\"y\":1,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_QETIXKMQMF\",\"page\":1,\"spuid\":\"QETIXKMQMF\",\"tabindex\":5,\"type\":\"Label\",\"value\":\"Descrizione del subindicatore\",\"w\":885,\"x\":91,\"y\":1,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":18,\"name\":\"label_ALDLRRKGHX\",\"page\":1,\"spuid\":\"ALDLRRKGHX\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"Rischio\",\"w\":55,\"x\":1100,\"y\":1,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_OLTCDBKKZK\",\"page\":1,\"spuid\":\"OLTCDBKKZK\",\"tabindex\":8,\"type\":\"Label\",\"value\":\"Immodificabile\",\"w\":134,\"x\":1157,\"y\":1,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_NCBLOOVGYK\",\"page\":1,\"spuid\":\"NCBLOOVGYK\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"Non Applicabile\",\"w\":112,\"x\":1294,\"y\":1,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":77,\"name\":\"BodyDetail0\",\"page\":1,\"spuid\":\"GridTable_Band\",\"type\":\"BodyDetail\",\"w\":1481,\"x\":5,\"y\":21,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Descrizione\",\"box_type\":\"layer\",\"comment\":\"Descrizione del subindicatore\",\"fixed\":true,\"h\":96,\"name\":\"Descrizione\",\"page\":1,\"shrinkable\":true,\"spuid\":\"VGASZRXNOJ\",\"tabindex\":9,\"title_caption\":\"Descrizione del subindicatore\",\"type\":\"Box\",\"w\":1399,\"x\":1,\"y\":102,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"container\":\"VGASZRXNOJ\",\"fixed\":true,\"h\":22,\"name\":\"button_TVQHCLXOGQ\",\"page\":1,\"picker\":true,\"repeated\":true,\"spuid\":\"TVQHCLXOGQ\",\"src\":\"..\\/{\\\"Char\\\":\\\"62160\\\",\\\"Color\\\":\\\"#000000\\\",\\\"FontName\\\":\\\"icons8_win10\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"20\\\"}\",\"tabindex\":11,\"type\":\"Image\",\"value\":\"Riporta Descrizione\",\"w\":17,\"x\":1380,\"y\":164,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Descrizione\",\"container\":\"VGASZRXNOJ\",\"fixed\":true,\"h\":78,\"name\":\"DESCRI_layer\",\"page\":1,\"repeated\":true,\"scroll\":true,\"spuid\":\"ATCXZHNKXY\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":1369,\"x\":7,\"y\":108,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"__body__grid__\",\"box_type\":\"layer\",\"h\":42,\"name\":\"Body_Row\",\"page\":1,\"shrinkable\":true,\"spuid\":\"GridTable_Band\",\"type\":\"Box\",\"w\":1425,\"x\":5,\"y\":0,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Descrizione del subindicatore\",\"h\":19,\"name\":\"DESCRI\",\"page\":1,\"repeated\":true,\"scroll\":true,\"spuid\":\"NGUCJOKSKM\",\"tabindex\":4,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":868,\"x\":110,\"y\":23,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Peso\",\"h\":19,\"maxlength\":21,\"name\":\"PESO\",\"page\":1,\"repeated\":true,\"spuid\":\"YPEGROOCHF\",\"tabindex\":5,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":118,\"x\":980,\"y\":23,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"True\",\"comment\":\"Subindicatore non applicabile\",\"h\":19,\"maxlength\":1,\"name\":\"NOAPPLIC\",\"page\":1,\"repeated\":true,\"spuid\":\"ACJAWRNAVO\",\"tabindex\":8,\"type\":\"Checkbox\",\"typevar\":\"logic\",\"unchecked_value\":\"False\",\"w\":136,\"x\":1294,\"y\":23,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Progressivo subindicatore\",\"h\":19,\"maxlength\":10,\"name\":\"PROGSUBIND\",\"page\":1,\"repeated\":true,\"spuid\":\"MXXMCLALYG\",\"tabindex\":2,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":83,\"x\":5,\"y\":23,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"True\",\"comment\":\"Subindicatore standard Immodificabile\",\"h\":19,\"maxlength\":1,\"name\":\"LOCKMIT\",\"page\":1,\"repeated\":true,\"spuid\":\"OIJUVIXRQN\",\"tabindex\":7,\"type\":\"Checkbox\",\"typevar\":\"logic\",\"unchecked_value\":\"False\",\"w\":134,\"x\":1157,\"y\":23,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Indice di rischio\",\"h\":19,\"maxlength\":9,\"name\":\"INDRISCH\",\"page\":1,\"repeated\":true,\"spuid\":\"VDSUAVUBNI\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":55,\"x\":1100,\"y\":23,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":19,\"name\":\"button_KWRCVYJSPV\",\"page\":1,\"picker\":true,\"repeated\":true,\"spuid\":\"KWRCVYJSPV\",\"src\":\"..\\/{\\\"Char\\\":\\\"59899\\\",\\\"Color\\\":\\\"#000000\\\",\\\"FontName\\\":\\\"icons8_win10\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"14\\\"}\",\"tabindex\":3,\"type\":\"Image\",\"value\":\"Apri Descrizione\",\"w\":17,\"x\":91,\"y\":23,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void DeleteRow(ServletStatus status,aosdt_sub_ind_defBO BO,SPParameterSource source) {
    int l_nRow = 0;
    boolean l_bFound = false;
    boolean l_bTrsOk = true;
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    BO.Load(status.w_IDMOD,status.w_IDIND);
    if (BO.m_bLoaded) {
      while (CPLib.lt(l_nRow,BO.m_oTrs.size()) &&  ! (l_bFound)) {
        l_bFound = CPLib.eqr(source.GetParameter("IDSUBIND",""),BO.m_oTrs.get(l_nRow).w_IDSUBIND);
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
  void WriteFormPage(aosdt_sub_ind_defBO BO,ServletStatus status) {
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
     "<script src='aosdt_sub_ind_def?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/aosdt_sub_ind_def_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/aosdt_sub_ind_def_edit.js'>" +
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
      status.out.println("w_IDMOD=a[0];");
      status.out.println("w_IDIND=a[1];");
      status.out.println("w_IDSUBIND=a[2];");
      status.out.println("w_PROGSUBIND=a[3];");
      status.out.println("w_DESCRI=a[4];");
      status.out.println("w_PESO=a[5];");
      status.out.println("w_INDRISCH=a[6];");
      status.out.println("w_LOCKMIT=a[7];");
      status.out.println("w_NOAPPLIC=a[8];");
      status.out.println("w_show_noapplic=a[9];");
      status.out.println("w_DESCRI_layer=a[10];");
      status.out.println("w_open_layer=a[11];");
      status.out.println("w_write_layer=a[12];");
      status.out.println("m_PrimaryKeys=['IDSUBIND','IDIND','IDMOD'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/aosdt_sub_ind_def_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(62,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","sub_ind_def");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","IDMOD,IDIND");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(aosdt_sub_ind_defBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({IDMOD:"+SPLib.ToJSValue(BO.w_IDMOD,"C",10,0)+",IDIND:"+SPLib.ToJSValue(BO.w_IDIND,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(aosdt_sub_ind_defBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({IDMOD:"+SPLib.ToJSValue(BO.w_IDMOD,"C",10,0)+",IDIND:"+SPLib.ToJSValue(BO.w_IDIND,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(aosdt_sub_ind_defBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({IDMOD:"+SPLib.ToJSValue(BO.w_IDMOD,"C",10,0)+",IDIND:"+SPLib.ToJSValue(BO.w_IDIND,"C",10,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(aosdt_sub_ind_defBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({IDMOD:"+SPLib.ToJSValue(BO.w_IDMOD,"C",10,0)+",IDIND:"+SPLib.ToJSValue(BO.w_IDIND,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(aosdt_sub_ind_defBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({IDMOD:"+SPLib.ToJSValue(BO.w_IDMOD,"C",10,0)+",IDIND:"+SPLib.ToJSValue(BO.w_IDIND,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(aosdt_sub_ind_defBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(aosdt_sub_ind_defBO BO,ServletStatus status) throws IOException {
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
    l_cJsUid = SPPrxycizer.proxycizedPath("LibreriaMit.js");
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
      CPLib.AddToSet(callable,"LibreriaMit");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,aosdt_sub_ind_defBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_IDMOD),"C",10,0));
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_IDIND),"C",10,0));
      }
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,aosdt_sub_ind_defBO BO) {
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
  static class OrderBodyByComparator implements Comparator<aosdt_sub_ind_defBL.TrsRow> {
    public int compare(aosdt_sub_ind_defBL.TrsRow o1,aosdt_sub_ind_defBL.TrsRow o2) {
      if (CPLib.lt(o1.w_PROGSUBIND,o2.w_PROGSUBIND)) {
        return -1;
      } else if (CPLib.gt(o1.w_PROGSUBIND,o2.w_PROGSUBIND)) {
        return 1;
      } else {
        return 0;
      }
    }
  }
}
