import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class aosdt_rilevazione extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*ec2d3498*!";
  static public class ServletStatus extends SPMasterDetailServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "rilevazione";
    }
    public String w_IDMOD;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_IDMOD,context,"rilevazione","IDMOD","C",10,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
    aosdt_rilevazioneBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_rilevazione;
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
    return "Dati della rilevazione";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "aosdt_rilevazione";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 1806;
    l_eg.m_nEntityHeight = 717;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"rilevazione","mod_ind_def"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page"),new ZoneItem("Dati Base Rilevazione","Dati Base Rilevazione","horizontal_section"),new ZoneItem("Indicatori della Rilevazione","Indicatori della Rilevazione","horizontal_section")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"IDMOD"};
    l_eg.keyRepeatedColumns = new String[]{"CPROWNUM"};
    l_eg.items = new SPItem[]{
                   new SPItem("IDMOD","C",10,0, "show","ID del modello"),
                   new SPItem("DESCRI","C",200,0, "show","Descrizione"),
                   new SPItem("CONNES","C",16,0, "edit","Codice di collegamento del soggetto"),
                   new SPItem("DTRIL","D",8,0, "edit","Data rilevazione"),
                   new SPItem("PROVENIENZA","C",100,0, "edit","Provenienza del dato"),
                   new SPItem("CPROWNUM","N",4,0, "hide","Progressivo rilevazione")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,aosdt_rilevazioneBO BO) {
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
    {"10027479599",p_Context.Translate("Dati della rilevazione")},
    {"10173567207",p_Context.Translate("Data rilevazione")},
    {"10651989569",p_Context.Translate("Progressivo rilevazione")},
    {"1454413650",p_Context.Translate("Rilevazione Anomala")},
    {"1748986534",p_Context.Translate("Codice di collegamento del soggetto")},
    {"1760851654",p_Context.Translate("Anomalie rilevate")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"856336882",p_Context.Translate("Provenienza del dato")},
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
  void WriteStyles(aosdt_rilevazioneBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../aosdt_rilevazione.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(aosdt_rilevazioneBO BO,ServletStatus status) {
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
      status.out.println(".TRQBYTHAVX {top:0px;position:absolute;left:0px;height:18px;width:555px;background-color:Transparent;z-index:1; }");
      status.out.println(".SOAYACQNFI {top:0px;position:absolute;left:560px;height:18px;width:155px;text-align:right;background-color:Transparent;z-index:1; }");
      status.out.println(".SOAYACQNFI_ZOOM { position:absolute;top:0px;left:716px;height:19px;width:17px;background-color:Transparent;background-repeat:no-repeat;background-position:center;margin:0;border-width:0;padding:0;z-index:1;}");
      status.out.println(".AQPVNJGWDF {top:0px;position:absolute;left:737px;height:18px;width:718px;background-color:Transparent;z-index:1; }");
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
      status.out.println("Z.Tabs.Get('tabs').InitSelect('aosdt_rilevazione',false);");
    }
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"aosdt_rilevazione",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(aosdt_rilevazioneBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,2);
  }
  void WriteControls_p1(aosdt_rilevazioneBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:717px;width:1806px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteControls_p1_b1(BO,status);
    WriteControls_p1_b2(BO,status);
    WriteControls_p1_b3(BO,status);
    WriteControls_p1_b4(BO,status);
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
  void WriteControls_p1_b0(aosdt_rilevazioneBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_1' style='position:relative;height:0px;display:none' page='2'>" +
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
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b1(aosdt_rilevazioneBO BO,ServletStatus status) {
    status.out.println(
     "<div id='tabs_1_Rilevazione_container'>" +
     " " +
     "</div>" +
    "");
    status.out.println(
     "<div name='Dati Base Rilevazione' id='VWBPGQDWQK_DIV' class='BoxContainer SPSection_expanded TabStripBoxContainer' group_id='tabs_1_Rilevazione'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var tabs_1_Rilevazione = new Z.Tabs({container:'tabs_1_Rilevazione_container',useGlobals: false,boxtabs: true,useseparator:GetStyleVariable('boxTabUseSeparator',null,''),expandcollapse:GetStyleVariable('boxTabCanCollapse',null,''),contents:[],tabstrip_class: ''});");
    status.out.println("Z.Tabs.Set('tabs_1_Rilevazione',tabs_1_Rilevazione);");
    status.out.println("var l_nVWBPGQDWQKTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='VWBPGQDWQK' class='TabStripBoxBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("Dati Base Rilevazione@BEGIN");
    if (status.includeZoneAltInterface("Dati Base Rilevazione")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Dati Base Rilevazione@BEGIN") || status.HasZoneAltInterface("Dati Base Rilevazione@END")) {
        status.out.println(
         "<div id='VWBPGQDWQK_boxContent' style='position:relative;display:block'>" +
        "");
      }
      WriteControls_p1_b1_b0(BO,status);
      WriteControls_p1_b1_b1(BO,status);
      WriteControls_p1_b1_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['VWBPGQDWQK']=['band_1_0','GridTable_Band','band_2_126'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("Dati Base Rilevazione@BEGIN") || status.HasZoneAltInterface("Dati Base Rilevazione@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b1_CloseBand(aosdt_rilevazioneBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Dati Base Rilevazione@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('VWBPGQDWQK').setAttribute('status','open');");
    status.out.println("tabs_1_Rilevazione.AddTab({name:\"VWBPGQDWQK\", element:\"VWBPGQDWQK_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati Base Rilevazione"),"C",0,0)+",tabIndex: l_nVWBPGQDWQKTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('VWBPGQDWQK',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('VWBPGQDWQK',false,true,false)}});");
    status.out.println("if (tabs_1_Rilevazione.CanCollapse()) {");
    status.out.println("tabs_1_Rilevazione.Expand('VWBPGQDWQK');");
    status.out.println("}");
    status.out.println("PageOpened.AppendReceiver('page_1',tabs_1_Rilevazione.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b1_b0(aosdt_rilevazioneBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_0' style='position:relative;height:49px;display:block' page='1'>" +
    "");
    status.out.println(
     "<div name id='GridTable_Header' class='GridTable_Header' style='position:absolute;top:26px;left:3px;height:22px;width:1477px;z-index:0'>" +
     "</div>" +
    "");
    status.out.println(
     "<input name='IDMOD' id='SZHUMIRICR' type='text' class='Field PrimaryKeyField "+(CPLib.ne(status.m_cClientMode,"query")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_IDMOD,"C",10,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("ID del modello"),"C",0,0)+" tabindex='-1' "+(CPLib.ne(status.m_cClientMode,"query")?"readonly":"")+" maxlength='10' size='10' fieldtype='C' autocomplete='off'>" +
    "");
    status.out.println(
     "<span class='SPLabel PrimaryKeyLabel' id='BBHSFPEDRQ_DIV'>" +
     "<label id='BBHSFPEDRQ' for='SZHUMIRICR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("ID del modello:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='DESCRI' id='DYVTZPSSRP' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DESCRI,"C",200,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("Descrizione"),"C",0,0)+" tabindex='-1' readonly maxlength='200' size='200' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel GridTable_HeaderTitle' id='RKOALHIEPO_DIV'>" +
     "<label id='RKOALHIEPO' for='TRQBYTHAVX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice di collegamento del soggetto"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel GridTable_HeaderTitle' id='SNDESTNZNX_DIV'>" +
     "<label id='SNDESTNZNX' for='SOAYACQNFI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data rilevazione"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel GridTable_HeaderTitle' id='PPPOYREQRK_DIV'>" +
     "<label id='PPPOYREQRK' for='AQPVNJGWDF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Provenienza del dato"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b1_b1(aosdt_rilevazioneBO BO,ServletStatus status) {
    status.out.println(
     "<div id='GridTable_Band_DIV'>" +
    "");
    status.out.println(
     "<div id='GridTable_Band' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("GridTable@BEGIN");
    if (status.includeZoneAltInterface("GridTable")) {
      WriteControls_p1_b1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("GridTable@BEGIN") || status.HasZoneAltInterface("GridTable@END")) {
        status.out.println(
         "<div id='GridTable_Band_boxContent' style='position:relative;height:82px;display:block'>" +
        "");
      }
      status.out.println(
       "<div id='GridTable_Container' style='position:relative;top:0px;left:3px;min-height:75px;max-height:156px;width:1477px;overflow:hidden' class='GridTable_Container "+SPLib.ToHTML(status.m_cClientMode,"C",0,0)+"'>" +
       "<div id=GridTable_LockedScroll style='position:absolute;top:0px;left:0px;height:81px;width:1477px;overflow:scroll'>" +
       "</div>" +
       "</div>" +
      "");
      status.out.println(
       "<div id='GridTable_DIV' style='position:relative;left:0;top:0;width:1477px;min-height:75px;max-height:156px;overflow:auto;'>" +
       "<table id='GridTable' style='position:relative;top:0px;left:0px;width:1471px' cellspacing='0' cellpadding='0' border='0'>" +
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
       "<div class='GridTable_VerticalLines' style='position:absolute;top:0px;left:562px;height:100%;width:1px'>" +
       "</div>" +
      "");
      status.out.println(
       "<div class='GridTable_VerticalLines' style='position:absolute;top:0px;left:740px;height:100%;width:1px'>" +
       "</div>" +
      "");
      HTMLRowScript(BO,status);
      if (status.HasZoneAltInterface("GridTable@BEGIN") || status.HasZoneAltInterface("GridTable@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b1_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b1_b1_CloseBand(aosdt_rilevazioneBO BO,ServletStatus status) {
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void HTMLRowScript(aosdt_rilevazioneBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder = null;
    status.out.println(
     "<script>" +
    "");
    status.out.println("function HTMLRow(editable,rowtoshow) {");
    status.out.println("var s;");
    status.out.println("s='<div style=\"position:relative;width:1455px;height:14px;\"';");
    status.out.println("s=s+'>';");
    status.out.println("var row;");
    status.out.println("var prefix;");
    status.out.println("var w_CONNES;");
    status.out.println("var w_DTRIL;");
    status.out.println("var w_PROVENIENZA;");
    status.out.println("var w_CPROWNUM;");
    status.out.println("if (Eq(rowtoshow,null)) {");
    status.out.println("row=window;");
    status.out.println("prefix='w_';");
    status.out.println("} else {");
    status.out.println("row=rowtoshow;");
    status.out.println("prefix='';");
    status.out.println("}");
    status.out.println("w_CONNES=row[prefix+'CONNES'];");
    status.out.println("w_DTRIL=row[prefix+'DTRIL'];");
    status.out.println("w_PROVENIENZA=row[prefix+'PROVENIENZA'];");
    status.out.println("w_CPROWNUM=row[prefix+'CPROWNUM'];");
    status.out.println("if (editable) {");
    status.out.println("if (Gt(m_nCurrentRow,0)) {");
    status.out.println("s=s+\""+
     "<input name='BeforeDetailElement' type='text' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
    "\"");
    status.out.println("}");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='CONNES' id='TRQBYTHAVX' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_CONNES),'C',16,0,'')+\"' title="+SPLib.ToHTMLValue(status.context.Translate("Codice di collegamento del soggetto"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='16' size='16' fieldtype='C'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='DTRIL' id='SOAYACQNFI' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(w_DTRIL,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))+\"' title="+SPLib.ToHTMLValue(status.context.Translate("Data rilevazione"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='10' size='8' fieldtype='D'>" +
     "<button id='SOAYACQNFI_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='PROVENIENZA' id='AQPVNJGWDF' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_PROVENIENZA),'C',100,0,'')+\"' title="+SPLib.ToHTMLValue(status.context.Translate("Provenienza del dato"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='100' size='100' fieldtype='C'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(2);
    status.m_nTabIndex = status.m_nTabIndex+(0);
    status.m_nAfterDetailElementTabIndex = status.m_nTabIndex;
    status.out.println("s=s+\""+
     "<input name='AfterDetailElement' type='text' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(-2);
    status.m_nTabIndex = status.m_nTabIndex-(0);
    status.out.println("} else {");
    status.out.println("if ( ! (IsHiddenByStateDriver('CONNES'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem TRQBYTHAVX' value='\"+WtH(ToHTML(w_CONNES),'C',16,0,'')+\"' tabindex='-1' readonly size='16'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('DTRIL'))) {");
    status.out.println("s=s+\""+
     "<input type='"+(SPLib.IsMobile(status.request)?"date":"text")+"' class='Field Disabled GridTable_QueryRowItem SOAYACQNFI' value='\"+WtH(w_DTRIL,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))+\"' tabindex='-1' readonly size='8'>" +
     "<button type='button' class='SOAYACQNFI_ZOOM CalendarButtonDisabled' value="+SPLib.ToHTMLValue(status.context.Translate("..."),"C",0,0)+" disabled class='SOAYACQNFI_ZOOM CalendarButtonDisabled'>" +
     "</button>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('PROVENIENZA'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem AQPVNJGWDF' value='\"+WtH(ToHTML(w_PROVENIENZA),'C',100,0,'')+\"' tabindex='-1' readonly size='100'>" +
    "\"");
    status.out.println("}");
    status.out.println("s=s+'<div style=\" position:absolute;z-index:2;width:1455px;height:14px;\"></div>';");
    status.out.println("}");
    status.out.println("s=s+'</div>';");
    status.out.println("return s;");
    status.out.println("}");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b1_b2(aosdt_rilevazioneBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_126' style='position:relative;height:5px;display:block' page='2'>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b2(aosdt_rilevazioneBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_GEDEJOLMRB")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_GEDEJOLMRB' style='position:relative;height:1px;display:block' page='2'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_GEDEJOLMRB")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_GEDEJOLMRB').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b3(aosdt_rilevazioneBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Indicatori della Rilevazione' id='GEDEJOLMRB_DIV' class='BoxContainer SPSection_expanded TabStripBoxContainer' group_id='tabs_1_Rilevazione'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nGEDEJOLMRBTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='GEDEJOLMRB' class='TabStripBoxBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("Indicatori della Rilevazione@BEGIN");
    if (status.includeZoneAltInterface("Indicatori della Rilevazione")) {
      WriteControls_p1_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Indicatori della Rilevazione@BEGIN") || status.HasZoneAltInterface("Indicatori della Rilevazione@END")) {
        status.out.println(
         "<div id='GEDEJOLMRB_boxContent' style='position:relative;display:block'>" +
        "");
      }
      WriteControls_p1_b3_b0(BO,status);
      WriteControls_p1_b3_b1(BO,status);
      WriteControls_p1_b3_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['GEDEJOLMRB']=['band_2_132','band_2_138','band_2_660'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("Indicatori della Rilevazione@BEGIN") || status.HasZoneAltInterface("Indicatori della Rilevazione@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b3_CloseBand(aosdt_rilevazioneBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Indicatori della Rilevazione@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('GEDEJOLMRB').setAttribute('status','open');");
    status.out.println("tabs_1_Rilevazione.AddTab({name:\"GEDEJOLMRB\", element:\"GEDEJOLMRB_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Indicatori della Rilevazione"),"C",0,0)+",tabIndex: l_nGEDEJOLMRBTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('GEDEJOLMRB',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('GEDEJOLMRB',false,true,false)}});");
    status.out.println("if (tabs_1_Rilevazione.CanCollapse()) {");
    status.out.println("tabs_1_Rilevazione.Expand('GEDEJOLMRB');");
    status.out.println("}");
    status.out.println("PageOpened.AppendReceiver('page_1',tabs_1_Rilevazione.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
    WriteExtendedCBoxGroupChildren(BO.m_MNTs,status,"Rilevazione",1);
  }
  void WriteControls_p1_b3_b0(aosdt_rilevazioneBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_132' style='position:relative;height:6px;display:block' page='2'>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b3_b1(aosdt_rilevazioneBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_138' style='position:relative;display:block' page='2'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='aosdt_anom_ril' id='IXXAERLMUY' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_2_138']=['IXXAERLMUY'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b3_b2(aosdt_rilevazioneBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_660' style='position:relative;height:12px;display:block' page='2'>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b4(aosdt_rilevazioneBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_END_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_END_OF_PAGE_1' style='position:relative;height:5px;display:block' page='2'>" +
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
  static void PrintState(aosdt_rilevazioneBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(aosdt_rilevazioneBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
    double i;
    i = 0;
    while (CPLib.lt(i,BO.Rows())) {
      BO.SetRow(i);
      if (BO.aosdt_anom_ril.IsUpdated()) {
        BO.m_cWv_aosdt_anom_ril = BO.aosdt_anom_ril.GetContext();
      }
      BO.WorkToTrs();
      i = i+1;
    }
  }
  static void PrintStateWorkVars(aosdt_rilevazioneBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_IDMOD,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNES,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DTRIL,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVENIENZA,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CPROWNUM,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCRI,"C",200,0));
    if (CPLib.eq(BO.m_cWv_aosdt_anom_ril,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_aosdt_anom_ril");
    } else if (CPLib.eq(BO.m_cWv_aosdt_anom_ril,"_not_empty_")) {
      BO.m_cWv_aosdt_anom_ril = BO.aosdt_anom_ril.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_aosdt_anom_ril,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_aosdt_anom_ril,"C",0,0));
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
    PrintStateDetailWorkVars(BO,status);
  }
  static void PrintStateDetailWorkVars(aosdt_rilevazioneBL BO,ServletStatus status) {
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
      status.out.print(""+SPLib.ToJSValue(BO.w_CONNES,"C",16,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_DTRIL,"D",8,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_PROVENIENZA,"C",100,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_CPROWNUM,"N",4,0)+",");
      if ( ! (l_bForceSelect) && CPLib.eq(l_nSelectRow,k) && ( ! (status.source.Has("CPROWNUM")) || CPLib.ne(BO.w_CPROWNUM,status.source.GetParameter("CPROWNUM",0)))) {
        l_nSelectRow = -1;
      }
      status.out.print(""+SPLib.ToJSValue(BO.m_cWv_aosdt_anom_ril,"C",0,0)+",");
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
  static void PrintStateDetailWorkVars_Deleted(aosdt_rilevazioneBL BO,ServletStatus status) {
    String l_cTrs;
    int k;
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      aosdt_rilevazioneBO.TrsRow l_Row;
      l_cTrs = "[";
      k = 0;
      while (CPLib.lt(k,BO.m_oDeletedRows.size())) {
        l_Row= (aosdt_rilevazioneBO.TrsRow) BO.m_oDeletedRows.get(k);
        l_cTrs = l_cTrs+" new TrsRow(";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_CONNES,"C",16,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_DTRIL,"D",8,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_PROVENIENZA,"C",100,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_CPROWNUM,"N",4,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.m_cWv_aosdt_anom_ril,"C",0,0)+",";
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
    }
  }
  void WriteMainFormVarScript(aosdt_rilevazioneBO BO,ServletStatus status) {
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(717,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(1806,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"aosdt_rilevazione"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'SZHUMIRICR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SZHUMIRICR",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,mod_ind_def,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'SZHUMIRICR':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,mod_ind_def,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("aosdt_rilevazione","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"aosdt_rilevazione",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("Dati Base Rilevazione"),"")) {
      status.quoteAndAppend("Dati Base Rilevazione","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Indicatori della Rilevazione"),"")) {
      status.quoteAndAppend("Indicatori della Rilevazione","hide","box");
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
    status.out.println("var m_nMaxDetailRows = 10;");
    status.out.println("function TrsRow() {");
    status.out.println("if (Eq(arguments.length,1)) {");
    status.out.println("this.CONNES=w_CONNES;");
    status.out.println("this.DTRIL=w_DTRIL;");
    status.out.println("this.PROVENIENZA=w_PROVENIENZA;");
    status.out.println("this.CPROWNUM=w_CPROWNUM;");
    status.out.println("this.m_cWv_aosdt_anom_ril=m_cWv_aosdt_anom_ril;");
    status.out.println("this.m_nRowStatus=arguments[0];");
    status.out.println("this.m_cOldRowCPCCCHK=m_cOldRowCPCCCHK;");
    int l;
    for ( l = 0; CPLib.lt(l,BO.m_MNTs.length); l = l + (1)) {
      if (BO.m_MNTs[l].RepeatedChild()) {
        status.out.println("this.m_cWv_"+BO.m_MNTs[l].m_cChildName+"=m_cWv_"+BO.m_MNTs[l].m_cChildName+";");
      }
    }
    status.out.println("} else {");
    status.out.println("this.CONNES=arguments[0];");
    status.out.println("this.DTRIL=arguments[1];");
    status.out.println("this.PROVENIENZA=arguments[2];");
    status.out.println("this.CPROWNUM=arguments[3];");
    status.out.println("this.m_cWv_aosdt_anom_ril=arguments[4];");
    status.out.println("this.m_nRowStatus=arguments[5];");
    status.out.println("this.m_cOldRowCPCCCHK=arguments[6];");
    int lastRow;
    lastRow = 7;
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
    status.out.println("w_CONNES=row.CONNES;");
    status.out.println("w_DTRIL=row.DTRIL;");
    status.out.println("w_PROVENIENZA=row.PROVENIENZA;");
    status.out.println("w_CPROWNUM=row.CPROWNUM;");
    if (CPLib.ne(status.m_cClientMode,"query")) {
      status.out.println("m_cWv_aosdt_anom_ril=row.m_cWv_aosdt_anom_ril;");
      status.out.println("m_nRowStatus=row.m_nRowStatus;");
      status.out.println("m_cOldRowCPCCCHK=row.m_cOldRowCPCCCHK;");
      for ( l = 0; CPLib.lt(l,BO.m_MNTs.length); l = l + (1)) {
        if (BO.m_MNTs[l].RepeatedChild()) {
          status.out.println("m_cWv_"+BO.m_MNTs[l].m_cChildName+"=row.m_cWv_"+BO.m_MNTs[l].m_cChildName+";");
        }
      }
      status.out.println("} else {");
      status.out.println("w_CONNES='';");
      status.out.println("w_DTRIL=NullDate();");
      status.out.println("w_PROVENIENZA='INTERNA';");
      status.out.println("w_CPROWNUM=0;");
      status.out.println("m_cWv_aosdt_anom_ril='';");
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
    status.out.println("CPRowNumName='w_CPROWNUM';");
    WriteExtendedFieldsVars(BO.extendedFields,status);
    status.out.println("// * --- Area Manuale = UI - Declare Variables");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteMainFormScript(aosdt_rilevazioneBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("AdjustTrs();");
    status.out.println("var l_cMode;");
    status.out.println("l_cMode=\""+status.m_cClientMode+"\";");
    WriteJSRestoreEntity(status);
    status.out.println("InitTable(Ctrl('GridTable'),l_cMode);");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("Z.Tabs.Get('tabs').InitSelect('aosdt_rilevazione',false);");
    } else {
      status.out.println("calculateSidebarBandsPosition('page_1');");
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
      } else if (( ! (CPLib.Empty(status.m_cAltInterface))) && CPLib.eq(status.m_cClientMode,"query")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('TRQBYTHAVX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SOAYACQNFI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SOAYACQNFI_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AQPVNJGWDF')) SetDisabled(c,true);");
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
    if (CPLib.ne(status.m_cClientMode,"view")) {
      status.out.println("FocusFirstComponent();");
    }
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      status.out.println("if (Ctrl('IXXAERLMUY')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('IXXAERLMUY',linkpc_url('IXXAERLMUY'));");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('SZHUMIRICR')) SetDisabled(c,true);");
      }
    }
    status.out.println("FillCombosValues();");
    status.out.println("SetControlsValue();");
    status.out.println("NotifyEvent('Record Loaded');");
    status.out.println("LoadContext();");
    status.out.println("LoadContext(true);");
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
    status.out.println("if (Eq(name,'aosdt_anom_ril')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"aosdt_anom_ril")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
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
  aosdt_rilevazioneBO getBO(ServletStatus status) {
    aosdt_rilevazioneBO BO = new aosdt_rilevazioneBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(aosdt_rilevazioneBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("rilevazione",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,aosdt_rilevazioneBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,aosdt_rilevazioneBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
  }
  CPResultSet QueryKeyCursor(aosdt_rilevazioneBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_rilevazione;
    String l_cPhName = BO.m_cPhName_rilevazione;
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
      String l_cQueryFilter = aosdt_rilevazioneBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" distinct  "+BO.m_cVirtName_rilevazione+".IDMOD"+(CPLib.Empty(status.m_cLastOrderBy) || CPLib.gt(CPLib.At(status.m_cLastOrderBy," distinct  "+BO.m_cVirtName_rilevazione+".IDMOD"),0) || CPLib.ne(CPSql.GetDataBaseType(l_cServer),CPSql.m_nPostgres)?"":","+status.m_cLastOrderBy)+"",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("rilevazione");
    String l_cPhName = CPSql.ManipulateTablePhName("rilevazione",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altres� come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".IDMOD"+(CPLib.Empty(status.m_cLastOrderBy) || CPLib.gt(CPLib.At(status.m_cLastOrderBy," "+l_cPhName+".IDMOD"),0) || CPLib.ne(CPSql.GetDataBaseType(l_cServer),CPSql.m_nPostgres)?"":","+status.m_cLastOrderBy)+"",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,aosdt_rilevazioneBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = aosdt_rilevazioneBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (CPLib.eq(CPSql.GetDataBaseType(BO.m_cServer_rilevazione),CPSql.m_nInformix)) {
        if (l_rsCount!=null)
          l_rsCount.Close();
        l_rsCount = BO.m_Sql.Query(BO.m_cServer_rilevazione,CPSql.BuildSQLPhrase(" count( distinct  "+BO.m_cVirtName_rilevazione+".IDMOD) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_rilevazione,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
      } else {
        if (l_rsCount!=null)
          l_rsCount.Close();
        l_rsCount = BO.m_Sql.Query(BO.m_cServer_rilevazione,CPSql.BuildSQLPhrase(" count(*) as reccount","("+CPSql.BuildSQLPhrase(" distinct  "+BO.m_cVirtName_rilevazione+".IDMOD",CPLib.GetTablesWithAliases(BO.m_cPhName_rilevazione,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,"")+") CountFrom","",""));
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
  void View(ServletStatus status,aosdt_rilevazioneBO BO) {
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
  void Edit(ServletStatus status,aosdt_rilevazioneBO BO,SPParameterSource source) {
    BO.Load(status.w_IDMOD);
    if (BO.m_bLoaded && BO.CanEdit()) {
      if (CPLib.eq(BO.Rows(),0)) {
        BO.w_CONNES = "";
        BO.w_DTRIL = CPLib.NullDate();
        BO.w_PROVENIENZA = "";
        BO.w_CPROWNUM = 0;
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
  void New(ServletStatus status,aosdt_rilevazioneBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,aosdt_rilevazioneBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,aosdt_rilevazioneBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_IDMOD = "";
      } else {
        BO.w_IDMOD = l_rsKeys.GetString("IDMOD");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_IDMOD = BO.w_IDMOD;
        if (CPLib.eq(BO.Rows(),0)) {
          BO.w_CONNES = "";
          BO.w_DTRIL = CPLib.NullDate();
          BO.w_PROVENIENZA = "";
          BO.w_CPROWNUM = 0;
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
  void EditLoad(ServletStatus status,aosdt_rilevazioneBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,aosdt_rilevazioneBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_IDMOD);
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
  void DeleteMessage(ServletStatus status,aosdt_rilevazioneBO BO,SPParameterSource source) {
    BO.Load(status.w_IDMOD);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,aosdt_rilevazioneBO BO) {
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({IDMOD:"+SPLib.ToJSValue(BO.w_IDMOD,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
  void Discard(ServletStatus status,aosdt_rilevazioneBO BO) {
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
  void CreatePortlet(ServletStatus status,aosdt_rilevazioneBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",677);
    item.put("w",1806);
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
    item.put("altInterfaceFor","aosdt_rilevazione");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Dati Base Rilevazione\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Base Rilevazione\",\"groupName\":\"Rilevazione\",\"h\":131,\"name\":\"Dati Base Rilevazione\",\"page\":1,\"shrinkable\":true,\"spuid\":\"VWBPGQDWQK\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Dati Base Rilevazione\",\"titled\":true,\"type\":\"Box\",\"w\":1800,\"x\":0,\"y\":0,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"ID del modello\",\"disabled\":\"true\",\"h\":22,\"maxlength\":10,\"name\":\"IDMOD\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"SZHUMIRICR\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":83,\"x\":96,\"y\":2,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":18,\"name\":\"label_BBHSFPEDRQ\",\"page\":1,\"spuid\":\"BBHSFPEDRQ\",\"tabindex\":2,\"type\":\"Label\",\"value\":\"ID del modello:\",\"w\":91,\"x\":4,\"y\":6,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Descrizione\",\"disabled\":\"true\",\"h\":22,\"maxlength\":200,\"name\":\"DESCRI\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"DYVTZPSSRP\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":1259,\"x\":201,\"y\":2,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_SNDESTNZNX\",\"page\":1,\"spuid\":\"SNDESTNZNX\",\"tabindex\":5,\"type\":\"Label\",\"value\":\"Data rilevazione\",\"w\":155,\"x\":565,\"y\":27,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_RKOALHIEPO\",\"page\":1,\"spuid\":\"RKOALHIEPO\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"Codice di collegamento del soggetto\",\"w\":555,\"x\":5,\"y\":27,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":77,\"name\":\"BodyDetail0\",\"page\":1,\"spuid\":\"GridTable_Band\",\"type\":\"BodyDetail\",\"w\":1511,\"x\":5,\"y\":49,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_PPPOYREQRK\",\"page\":1,\"spuid\":\"PPPOYREQRK\",\"tabindex\":6,\"type\":\"Label\",\"value\":\"Provenienza del dato\",\"w\":718,\"x\":742,\"y\":27,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Indicatori della Rilevazione\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Indicatori della Rilevazione\",\"groupName\":\"Rilevazione\",\"h\":540,\"name\":\"Indicatori della Rilevazione\",\"page\":1,\"shrinkable\":true,\"spuid\":\"GEDEJOLMRB\",\"stretch\":true,\"tabindex\":2,\"title_caption\":\"Indicatori della Rilevazione\",\"titled\":true,\"type\":\"Box\",\"w\":1801,\"x\":0,\"y\":132,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"fixed\":true,\"h\":522,\"name\":\"aosdt_anom_ril\",\"page\":1,\"spuid\":\"IXXAERLMUY\",\"tabindex\":7,\"type\":\"Iframe\",\"w\":1774,\"x\":2,\"y\":138,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"__body__grid__\",\"box_type\":\"layer\",\"h\":44,\"name\":\"Body_Row\",\"page\":1,\"shrinkable\":true,\"spuid\":\"GridTable_Band\",\"type\":\"Box\",\"w\":1455,\"x\":5,\"y\":26,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice di collegamento del soggetto\",\"h\":19,\"maxlength\":16,\"name\":\"CONNES\",\"page\":1,\"repeated\":true,\"spuid\":\"TRQBYTHAVX\",\"tabindex\":3,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":555,\"x\":5,\"y\":51,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provenienza del dato\",\"h\":19,\"maxlength\":100,\"name\":\"PROVENIENZA\",\"page\":1,\"repeated\":true,\"spuid\":\"AQPVNJGWDF\",\"tabindex\":5,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":718,\"x\":742,\"y\":51,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data rilevazione\",\"h\":19,\"maxlength\":10,\"name\":\"DTRIL\",\"page\":1,\"picker\":true,\"repeated\":true,\"spuid\":\"SOAYACQNFI\",\"tabindex\":4,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":155,\"x\":565,\"y\":51,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void DeleteRow(ServletStatus status,aosdt_rilevazioneBO BO,SPParameterSource source) {
    int l_nRow = 0;
    boolean l_bFound = false;
    boolean l_bTrsOk = true;
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    BO.Load(status.w_IDMOD);
    if (BO.m_bLoaded) {
      while (CPLib.lt(l_nRow,BO.m_oTrs.size()) &&  ! (l_bFound)) {
        l_bFound = CPLib.eqr(source.GetParameter("CPROWNUM",0),BO.m_oTrs.get(l_nRow).w_CPROWNUM);
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
  void WriteFormPage(aosdt_rilevazioneBO BO,ServletStatus status) {
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
     "<script src='aosdt_rilevazione?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
    status.out.println("InstTR();");
    status.out.println(
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("controls.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("suggesterlib.js");
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
       "<script src='SPPrxy/"+m_cEntityUid+"/aosdt_rilevazione_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/aosdt_rilevazione_edit.js'>" +
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
      status.out.println("w_CONNES=a[1];");
      status.out.println("w_DTRIL=a[2];");
      status.out.println("w_PROVENIENZA=a[3];");
      status.out.println("w_CPROWNUM=a[4];");
      status.out.println("w_DESCRI=a[5];");
      status.out.println("m_cWv_aosdt_anom_ril=a[6];");
      status.out.println("if (Gt(a.length,7)) {");
      status.out.println("m_cErrorInChild='';");
      status.out.println("}");
      status.out.println("if (Gt(a.length,7)) {");
      status.out.println("o_IDMOD=w_IDMOD;");
      status.out.println("o_CPROWNUM=w_CPROWNUM;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['CPROWNUM','IDMOD'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/aosdt_rilevazione_proc.js'>" +
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
    l_cJsUid = SPPrxycizer.proxycizedPath(status.m_cTheme+"/tabStrip.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
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
    status.m_cBodyAttributes = "onload=OnLoad() onhelp=CancelHelp()";
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.m_cBodyAttributes = status.m_cBodyAttributes+" onkeydown=window.ManageKeys(event,false,false)";
    } else {
      status.m_cBodyAttributes = status.m_cBodyAttributes+" onkeydown=window.ManageKeys(event,true,false)";
    }
    status.m_cBodyAttributes = status.m_cBodyAttributes+" onfocus=EnsureControlFocus()";
    status.themeWriter.WriteBody_Begin(717,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
    status.out.println(
     "<script>" +
    "");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("AppletTag('Link');");
    }
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
    f.SetParameter("Table","rilevazione");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","IDMOD");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(aosdt_rilevazioneBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({IDMOD:"+SPLib.ToJSValue(BO.w_IDMOD,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(aosdt_rilevazioneBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({IDMOD:"+SPLib.ToJSValue(BO.w_IDMOD,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(aosdt_rilevazioneBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({IDMOD:"+SPLib.ToJSValue(BO.w_IDMOD,"C",10,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(aosdt_rilevazioneBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({IDMOD:"+SPLib.ToJSValue(BO.w_IDMOD,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(aosdt_rilevazioneBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({IDMOD:"+SPLib.ToJSValue(BO.w_IDMOD,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(aosdt_rilevazioneBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(aosdt_rilevazioneBO BO,ServletStatus status) throws IOException {
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
      CPLib.AddToSet(callable,"aosdt_anom_ril");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,aosdt_rilevazioneBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_IDMOD),"C",10,0));
      }
    } else if (CPLib.eq(p_cUID,"SZHUMIRICR")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,aosdt_rilevazioneBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_IDMOD))) {
        a = GetCheckVars(status,BO,"SZHUMIRICR");
        b = status.m_CheckVars.optString("SZHUMIRICR");
        result = CPLib.eq(a,b);
      }
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
