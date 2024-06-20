import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({"administrators","utenti standard","ruolo 3","utenti confidi","ruolo 5","agenzia","area finanza","help desk","consultazione","utilità"})
public class armt_ae_anarap extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*8366f125*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "jnarapbo";
    }
    public String w_RAPPORTO;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_RAPPORTO,context,"jnarapbo","RAPPORTO","C",25,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='RAPPORTO' type='hidden' value="+SPLib.ToHTMLValue(w_RAPPORTO,"C",25,0)+">" +
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
    armt_ae_anarapBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_jnarapbo;
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
      status.w_RAPPORTO = BO.w_RAPPORTO;
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
    return "Rapporti (AGE)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_ae_anarap";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 1021;
    l_eg.m_nEntityHeight = 661;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"jnarapbo","tbvalute"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","Dati Base","page"),new ZoneItem("page_2","Operazioni","page"),new ZoneItem("page_3","Deleghe su rapporto","page"),new ZoneItem("page_4","Garantiti","page"),new ZoneItem("page_5","Saldi","page"),new ZoneItem("DatiBase","Dati Base","horizontal_section"),new ZoneItem("DatiBase","Dati Base","horizontal_section"),new ZoneItem("Rapporto","Rapporto e Operazioni","horizontal_section"),new ZoneItem("Deleghe","Deleghe","horizontal_section"),new ZoneItem("SaldiOro","Saldi Oro","horizontal_section"),new ZoneItem("Garantiti","Garantiti","horizontal_section"),new ZoneItem("Saldi","Saldi","horizontal_section")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"RAPPORTO"};
    l_eg.items = new SPItem[]{
                   new SPItem("gTelepass","C",1,0, "hide","Versione Telepass"),
                   new SPItem("gCodDip","C",6,0, "hide","Dipendenza"),
                   new SPItem("gBrowser","C",1,0, "hide","Tipo Browser"),
                   new SPItem("gTipInter","C",2,0, "hide","Tipo Intermediario"),
                   new SPItem("RAPPORTO","C",25,0, "edit","Codice Rapporto"),
                   new SPItem("DESCRAP","C",50,0, "edit","Descrizione"),
                   new SPItem("TIPORAP","C",1,0, "edit","Tipo Rapporto"),
                   new SPItem("TIPOAG","C",2,0, "edit",""),
                   new SPItem("ISOAGE","C",3,0, "edit","Per tipo rapporto 96/97"),
                   new SPItem("FLAGLIRE","C",1,0, "edit","Divisa"),
                   new SPItem("VALUTA","C",3,0, "edit","Codice Divisa"),
                   new SPItem("descval","C",30,0, "hide","Descrizione"),
                   new SPItem("daticoll","N",10,0, "hide",""),
                   new SPItem("PRGIMPRAP","N",15,0, "hide","Progressivo Import"),
                   new SPItem("CODDIP","C",6,0, "hide","Dipendenza / Agenzia che crea il rapporto"),
                   new SPItem("titolo","C",90,0, "hide",""),
                   new SPItem("NOPROT","N",1,0, "hide",""),
                   new SPItem("mess","M",10,0, "hide","")
                 };
    l_eg.m_lHasHistorical = false;
    return l_eg;
  }
  ArrayList<org.json.JSONArray> i_sidebarItems = null;
  public org.json.JSONArray getSidebarItems(int p_nPage) {
    if (CPLib.IsNull(i_sidebarItems)) {
      i_sidebarItems = InitializeSidebarItemsArray(5);
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_ae_anarapBO BO) {
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
      i_contextmenu = InitializeContextMenuArray(5);
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
    l_translations=new String[][]{{"109710548",p_Context.Translate("Divisa")},
    {"11116511596",p_Context.Translate("Codice Rapporto")},
    {"114016870",p_Context.Translate("Valute")},
    {"11441951893",p_Context.Translate("Dipendenza / Agenzia che crea il rapporto")},
    {"1270140254",p_Context.Translate("Dipendenza")},
    {"1529904207",p_Context.Translate("Per tipo rapporto 96/97")},
    {"1573704569",p_Context.Translate("Versione Telepass")},
    {"1682876716",p_Context.Translate("%1")},
    {"1716450187",p_Context.Translate("Tipo Browser")},
    {"1723736132",p_Context.Translate("Tipo Rapporto")},
    {"1730321404",p_Context.Translate("Codice Divisa")},
    {"191062270",p_Context.Translate("%1")},
    {"1951322326",p_Context.Translate("%1")},
    {"242231810",p_Context.Translate("Rapporti (AGE)")},
    {"283403499",p_Context.Translate("Progressivo Import")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"984756930",p_Context.Translate("Tipo Intermediario")}};
    return l_translations;
  }
  void WriteStyles(armt_ae_anarapBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_ae_anarap.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_ae_anarapBO BO,ServletStatus status) {
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
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='tabsContainer'>" +
     " " +
     "</div>" +
    "");
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
    status.out.println("if ( ! (Z.Tabs.Has('tabs'))) {");
    status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati Base"),"C",0,0)+"},{name:\"page_2\", element:\"page_2\", caption:"+SPLib.ToJSValue(status.context.Translate("Operazioni"),"C",0,0)+"},{name:\"page_3\", element:\"page_3\", caption:"+SPLib.ToJSValue(status.context.Translate("Deleghe su rapporto"),"C",0,0)+"},{name:\"page_4\", element:\"page_4\", caption:"+SPLib.ToJSValue(status.context.Translate("Garantiti"),"C",0,0)+"},{name:\"page_5\", element:\"page_5\", caption:"+SPLib.ToJSValue(status.context.Translate("Saldi"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
    status.out.println("Z.Tabs.Set('tabs',tabs);");
    status.out.println("} else {");
    status.out.println("var tabs = Z.Tabs.Get('tabs')");
    status.out.println("}");
    AddExtendedTabs(status);
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_ae_anarap',false);");
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_ae_anarap",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  // GetPortlet_Intestatari_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_XCLJCOLAOK_Vars(armt_ae_anarapBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_rapporto",CPLib.LRTrim(BO.w_RAPPORTO));
    return inclusionVars;
  }
  // GetPortlet_Informazioni_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_NXJPOCJGET_Vars(armt_ae_anarapBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_rapporto",CPLib.LRTrim(BO.w_RAPPORTO));
    return inclusionVars;
  }
  // GetPortlet_Operazioni_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_VNBQZVXZTE_Vars(armt_ae_anarapBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_rapporto",CPLib.LRTrim(BO.w_RAPPORTO));
    return inclusionVars;
  }
  void WriteControls(armt_ae_anarapBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    WriteControls_p2(BO,status);
    WriteControls_p3(BO,status);
    WriteControls_p4(BO,status);
    WriteControls_p5(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,6);
  }
  void WriteControls_p1(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:661px;width:1021px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteControls_p1_b1(BO,status);
    WriteControls_p1_b2(BO,status);
    WriteControls_p1_b3(BO,status);
    WriteControls_p1_b4(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"Dati Base");
    PrintSidebarContent(1,status,getSidebarItems(0),true);
    PrintContextMenu(1,status,getContextMenu(0),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_2' class='PageContainer' style='position:relative;height:617px;width:1021px;display:none'>" +
    "");
    WriteControls_p2_b0(BO,status);
    WriteControls_p2_b1(BO,status);
    WriteControls_p2_b2(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,2,"Operazioni");
    PrintSidebarContent(2,status,getSidebarItems(1),true);
    PrintContextMenu(2,status,getContextMenu(1),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_3' class='PageContainer' style='position:relative;height:517px;width:1021px;display:none'>" +
    "");
    WriteControls_p3_b0(BO,status);
    WriteControls_p3_b1(BO,status);
    WriteControls_p3_b2(BO,status);
    WriteControls_p3_b3(BO,status);
    WriteControls_p3_b4(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,3,"Deleghe su rapporto");
    PrintSidebarContent(3,status,getSidebarItems(2),true);
    PrintContextMenu(3,status,getContextMenu(2),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p4(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_4' class='PageContainer' style='position:relative;height:377px;width:1021px;display:none'>" +
    "");
    WriteControls_p4_b0(BO,status);
    WriteControls_p4_b1(BO,status);
    WriteControls_p4_b2(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,4,"Garantiti");
    PrintSidebarContent(4,status,getSidebarItems(3),true);
    PrintContextMenu(4,status,getContextMenu(3),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p5(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_5' class='PageContainer' style='position:relative;height:627px;width:1021px;display:none'>" +
    "");
    WriteControls_p5_b0(BO,status);
    WriteControls_p5_b1(BO,status);
    WriteControls_p5_b2(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,5,"Saldi");
    PrintSidebarContent(5,status,getSidebarItems(4),true);
    PrintContextMenu(5,status,getContextMenu(4),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b0(armt_ae_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_1' style='position:relative;height:0px;display:none' page='1'>" +
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
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b1(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div name='DatiBase' id='YORQOIOBQN_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='YORQOIOBQN_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='YORQOIOBQN_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Base")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='YORQOIOBQN_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"YORQOIOBQN\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=YORQOIOBQN_HEADER&m_cBoxId=YORQOIOBQN&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Base"))+"");
    }
    status.out.println(
     "<div id='YORQOIOBQN' class='SectionBody' style='position:relative;height:144px;display:block'>" +
    "");
    status.includeZoneAltInterface("DatiBase@BEGIN");
    if (status.includeZoneAltInterface("DatiBase")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("DatiBase@BEGIN") || status.HasZoneAltInterface("DatiBase@END")) {
        status.out.println(
         "<div id='YORQOIOBQN_boxContent' style='position:relative;height:144px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RAPPORTO' id='LXORWVRYJJ' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_RAPPORTO,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='25' size='25' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OICGZUOZYP_DIV'>" +
       "<label id='OICGZUOZYP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Rapporto:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DESCRAP' id='AQAARAIPOR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DESCRAP,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VEBJKDHMDC_DIV'>" +
       "<label id='VEBJKDHMDC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Descrizione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPORAP' id='ZFOHYLVPYN' class='"+status.ObligatoryClass("Combobox")+"' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_TIPORAP),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPOAG' id='BHAVHLFPAC' class='Combobox' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_TIPOAG),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='ISOAGE' id='QBUCLWUNFT' class='"+status.ObligatoryClass("Combobox",BO.QBUCLWUNFT_isObligatory())+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='FLAGLIRE' id='BCLYMGMBLK' class='"+status.ObligatoryClass("Combobox")+"' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_FLAGLIRE),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("L","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("L",CPLib.Trim(BO.w_FLAGLIRE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Lire")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("E","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("E",CPLib.Trim(BO.w_FLAGLIRE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Euro")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("V","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("V",CPLib.Trim(BO.w_FLAGLIRE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Valuta Estera")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('BCLYMGMBLK'),w_FLAGLIRE,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GDCHKTFQUK_DIV'>" +
       "<label id='GDCHKTFQUK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Rapporto:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='VALUTA' id='RUMXLFCOKA' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_VALUTA,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='RUMXLFCOKA_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "RUMXLFCOKA", "tbvalute", "armt_divise", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OUQKLNQVMP_DIV'>" +
       "<label id='OUQKLNQVMP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Divisa:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MILRATMPIJ_DIV'>" +
       "<label id='MILRATMPIJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Divisa:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XQILBJQNNS_DIV'>" +
       "<label id='XQILBJQNNS'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descval)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TQNAPDCWFY_DIV' style='display:none'>" +
       "<label id='TQNAPDCWFY' for='QBUCLWUNFT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Per tipo 96/97:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CTCKWHZVTZ_DIV'>" +
       "<label id='CTCKWHZVTZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Rap. Ag. Entrate:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("DatiBase@BEGIN") || status.HasZoneAltInterface("DatiBase@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b1_CloseBand(armt_ae_anarapBO BO,ServletStatus status) {
    status.includeZoneAltInterface("DatiBase@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("DatiBase")) {
      status.out.println("Ctrl('YORQOIOBQN').style.height='auto';");
    } else {
      status.out.println("Ctrl('YORQOIOBQN').setAttribute('band_height',144);");
    }
    status.out.println("Ctrl('YORQOIOBQN').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_ae_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_GJZISGEBVV")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_GJZISGEBVV' style='position:relative;height:8px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_GJZISGEBVV")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_GJZISGEBVV').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b3(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div name='DatiBase' id='GJZISGEBVV_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='GJZISGEBVV_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='GJZISGEBVV_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Base")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='GJZISGEBVV_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"GJZISGEBVV\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=GJZISGEBVV_HEADER&m_cBoxId=GJZISGEBVV&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Base"))+"");
    }
    status.out.println(
     "<div id='GJZISGEBVV' class='SectionBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("DatiBase@BEGIN");
    if (status.includeZoneAltInterface("DatiBase")) {
      WriteControls_p1_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("DatiBase@BEGIN") || status.HasZoneAltInterface("DatiBase@END")) {
        status.out.println(
         "<div id='GJZISGEBVV_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p1_b3_b0(BO,status);
      WriteControls_p1_b3_b1(BO,status);
      WriteControls_p1_b3_b2(BO,status);
      WriteControls_p1_b3_b3(BO,status);
      WriteControls_p1_b3_b4(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['GJZISGEBVV']=['band_1_152','band_1_160','band_1_368','band_1_376','band_1_608'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("DatiBase@BEGIN") || status.HasZoneAltInterface("DatiBase@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b3_CloseBand(armt_ae_anarapBO BO,ServletStatus status) {
    status.includeZoneAltInterface("DatiBase@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('GJZISGEBVV').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b3_b0(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_152' style='position:relative;height:8px;display:block' page='1'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b3_b1(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_160' style='position:relative;display:block' page='1'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='XCLJCOLAOK'>" +
    "");
    // GetPortlet_Intestatari_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_XCLJCOLAOK;
    inclusionVars_XCLJCOLAOK = GetPortlet_XCLJCOLAOK_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_XCLJCOLAOK);
    String portletUID_XCLJCOLAOK = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_intestbo_ae_portlet.jsp?ForcedPortletUID="+ portletUID_XCLJCOLAOK+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_XCLJCOLAOK),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.XCLJCOLAOK='"+portletUID_XCLJCOLAOK+"';" +
     "w_Intestatari=ZtVWeb.getPortletById('"+portletUID_XCLJCOLAOK+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b3_b2(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_368' style='position:relative;height:8px;display:block' page='1'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b3_b3(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_376' style='position:relative;display:block' page='1'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='NXJPOCJGET'>" +
    "");
    // GetPortlet_Informazioni_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_NXJPOCJGET;
    inclusionVars_NXJPOCJGET = GetPortlet_NXJPOCJGET_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_NXJPOCJGET);
    String portletUID_NXJPOCJGET = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_rapopebo_ae_portlet.jsp?ForcedPortletUID="+ portletUID_NXJPOCJGET+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_NXJPOCJGET),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.NXJPOCJGET='"+portletUID_NXJPOCJGET+"';" +
     "w_Informazioni=ZtVWeb.getPortletById('"+portletUID_NXJPOCJGET+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b3_b4(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_608' style='position:relative;height:8px;display:block' page='1'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b4(armt_ae_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_END_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_END_OF_PAGE_1' style='position:relative;height:5px;display:block' page='1'>" +
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
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p2_b0(armt_ae_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_2")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_2' style='position:relative;height:0px;display:none' page='2'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_TOP_OF_PAGE_2")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_TOP_OF_PAGE_2').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p2_b1(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Rapporto' id='LZCEHELAXJ_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='LZCEHELAXJ_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='LZCEHELAXJ_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Rapporto e Operazioni")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='LZCEHELAXJ_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"LZCEHELAXJ\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=LZCEHELAXJ_HEADER&m_cBoxId=LZCEHELAXJ&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Rapporto e Operazioni"))+"");
    }
    status.out.println(
     "<div id='LZCEHELAXJ' class='SectionBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("Rapporto@BEGIN");
    if (status.includeZoneAltInterface("Rapporto")) {
      WriteControls_p2_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Rapporto@BEGIN") || status.HasZoneAltInterface("Rapporto@END")) {
        status.out.println(
         "<div id='LZCEHELAXJ_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p2_b1_b0(BO,status);
      WriteControls_p2_b1_b1(BO,status);
      WriteControls_p2_b1_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['LZCEHELAXJ']=['band_2_0','band_2_8','band_2_584'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("Rapporto@BEGIN") || status.HasZoneAltInterface("Rapporto@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p2_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p2_b1_CloseBand(armt_ae_anarapBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Rapporto@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('LZCEHELAXJ').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b1_b0(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_0' style='position:relative;height:8px;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b1_b1(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_8' style='position:relative;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='VNBQZVXZTE'>" +
    "");
    // GetPortlet_Operazioni_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_VNBQZVXZTE;
    inclusionVars_VNBQZVXZTE = GetPortlet_VNBQZVXZTE_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_VNBQZVXZTE);
    String portletUID_VNBQZVXZTE = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_operazbo_ae_portlet.jsp?ForcedPortletUID="+ portletUID_VNBQZVXZTE+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_VNBQZVXZTE),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.VNBQZVXZTE='"+portletUID_VNBQZVXZTE+"';" +
     "w_Operazioni=ZtVWeb.getPortletById('"+portletUID_VNBQZVXZTE+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b1_b2(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_584' style='position:relative;height:8px;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b2(armt_ae_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_END_OF_PAGE_2")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_END_OF_PAGE_2' style='position:relative;height:5px;display:block' page='2'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_END_OF_PAGE_2")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_END_OF_PAGE_2').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p3_b0(armt_ae_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_3")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_3' style='position:relative;height:0px;display:none' page='3'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_TOP_OF_PAGE_3")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_TOP_OF_PAGE_3').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p3_b1(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Deleghe' id='EHSQLOIDHO_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='EHSQLOIDHO_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='EHSQLOIDHO_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Deleghe")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='EHSQLOIDHO_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"EHSQLOIDHO\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=EHSQLOIDHO_HEADER&m_cBoxId=EHSQLOIDHO&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Deleghe"))+"");
    }
    status.out.println(
     "<div id='EHSQLOIDHO' class='SectionBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("Deleghe@BEGIN");
    if (status.includeZoneAltInterface("Deleghe")) {
      WriteControls_p3_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Deleghe@BEGIN") || status.HasZoneAltInterface("Deleghe@END")) {
        status.out.println(
         "<div id='EHSQLOIDHO_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p3_b1_b0(BO,status);
      WriteControls_p3_b1_b1(BO,status);
      WriteControls_p3_b1_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['EHSQLOIDHO']=['band_3_0','band_3_16','band_3_272'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("Deleghe@BEGIN") || status.HasZoneAltInterface("Deleghe@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p3_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p3_b1_CloseBand(armt_ae_anarapBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Deleghe@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('EHSQLOIDHO').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p3_b1_b0(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_0' style='position:relative;height:16px;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b1_b1(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_16' style='position:relative;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='ardt_ae_delegabo' id='OYYXUVDIWN' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_3_16']=['OYYXUVDIWN'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p3_b1_b2(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_272' style='position:relative;height:8px;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b2(armt_ae_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_KAVLKRYWMM")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_KAVLKRYWMM' style='position:relative;height:8px;display:block' page='3'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_KAVLKRYWMM")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_KAVLKRYWMM').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p3_b3(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div name='SaldiOro' id='KAVLKRYWMM_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='KAVLKRYWMM_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='KAVLKRYWMM_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Saldi Oro")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='KAVLKRYWMM_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"KAVLKRYWMM\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=KAVLKRYWMM_HEADER&m_cBoxId=KAVLKRYWMM&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Saldi Oro"))+"");
    }
    status.out.println(
     "<div id='KAVLKRYWMM' class='SectionBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("SaldiOro@BEGIN");
    if (status.includeZoneAltInterface("SaldiOro")) {
      WriteControls_p3_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("SaldiOro@BEGIN") || status.HasZoneAltInterface("SaldiOro@END")) {
        status.out.println(
         "<div id='KAVLKRYWMM_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p3_b3_b0(BO,status);
      WriteControls_p3_b3_b1(BO,status);
      WriteControls_p3_b3_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['KAVLKRYWMM']=['band_3_288','band_3_296','band_3_460'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("SaldiOro@BEGIN") || status.HasZoneAltInterface("SaldiOro@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p3_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p3_b3_CloseBand(armt_ae_anarapBO BO,ServletStatus status) {
    status.includeZoneAltInterface("SaldiOro@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('KAVLKRYWMM').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p3_b3_b0(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_288' style='position:relative;height:8px;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b3_b1(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_296' style='position:relative;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='ardt_saldioro' id='XRVFDCHTKZ' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_3_296']=['XRVFDCHTKZ'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p3_b3_b2(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_460' style='position:relative;height:12px;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b4(armt_ae_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_END_OF_PAGE_3")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_END_OF_PAGE_3' style='position:relative;height:5px;display:block' page='3'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_END_OF_PAGE_3")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_END_OF_PAGE_3').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p4_b0(armt_ae_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_4")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_4' style='position:relative;height:0px;display:none' page='4'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_TOP_OF_PAGE_4")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_TOP_OF_PAGE_4').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p4_b1(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Garantiti' id='LWDMGLAEON_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='LWDMGLAEON_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='LWDMGLAEON_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Garantiti")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='LWDMGLAEON_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"LWDMGLAEON\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=LWDMGLAEON_HEADER&m_cBoxId=LWDMGLAEON&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Garantiti"))+"");
    }
    status.out.println(
     "<div id='LWDMGLAEON' class='SectionBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("Garantiti@BEGIN");
    if (status.includeZoneAltInterface("Garantiti")) {
      WriteControls_p4_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Garantiti@BEGIN") || status.HasZoneAltInterface("Garantiti@END")) {
        status.out.println(
         "<div id='LWDMGLAEON_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p4_b1_b0(BO,status);
      WriteControls_p4_b1_b1(BO,status);
      WriteControls_p4_b1_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['LWDMGLAEON']=['band_4_0','band_4_8','band_4_343'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("Garantiti@BEGIN") || status.HasZoneAltInterface("Garantiti@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p4_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p4_b1_CloseBand(armt_ae_anarapBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Garantiti@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('LWDMGLAEON').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p4_b1_b0(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_4_0' style='position:relative;height:8px;display:block' page='4'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p4_b1_b1(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_4_8' style='position:relative;display:block' page='4'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='ardt_jarantbo' id='ZSYGOPYXSA' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_4_8']=['ZSYGOPYXSA'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p4_b1_b2(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_4_343' style='position:relative;height:9px;display:block' page='4'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p4_b2(armt_ae_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_END_OF_PAGE_4")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_END_OF_PAGE_4' style='position:relative;height:5px;display:block' page='4'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_END_OF_PAGE_4")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_END_OF_PAGE_4').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p5_b0(armt_ae_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_5")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_5' style='position:relative;height:0px;display:none' page='5'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_TOP_OF_PAGE_5")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_TOP_OF_PAGE_5').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p5_b1(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Saldi' id='MUCCIMEJEB_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='MUCCIMEJEB_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='MUCCIMEJEB_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Saldi")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='MUCCIMEJEB_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"MUCCIMEJEB\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=MUCCIMEJEB_HEADER&m_cBoxId=MUCCIMEJEB&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Saldi"))+"");
    }
    status.out.println(
     "<div id='MUCCIMEJEB' class='SectionBody' style='position:relative;height:602px;display:block'>" +
    "");
    status.includeZoneAltInterface("Saldi@BEGIN");
    if (status.includeZoneAltInterface("Saldi")) {
      WriteControls_p5_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Saldi@BEGIN") || status.HasZoneAltInterface("Saldi@END")) {
        status.out.println(
         "<div id='MUCCIMEJEB_boxContent' style='position:relative;height:602px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<iframe name='ardt_ae_saldianno_rap' id='XUXHMWVHFR' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
       "</iframe>" +
      "");
      if (status.HasZoneAltInterface("Saldi@BEGIN") || status.HasZoneAltInterface("Saldi@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p5_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p5_b1_CloseBand(armt_ae_anarapBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Saldi@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Saldi")) {
      status.out.println("Ctrl('MUCCIMEJEB').style.height='auto';");
    } else {
      status.out.println("Ctrl('MUCCIMEJEB').setAttribute('band_height',602);");
    }
    status.out.println("Ctrl('MUCCIMEJEB').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['MUCCIMEJEB']=['XUXHMWVHFR'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p5_b2(armt_ae_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_END_OF_PAGE_5")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_END_OF_PAGE_5' style='position:relative;height:5px;display:block' page='5'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_END_OF_PAGE_5")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_END_OF_PAGE_5').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "</div>" +
      "");
    }
  }
  static void PrintState(armt_ae_anarapBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_ae_anarapBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
    if (BO.ardt_ae_delegabo.IsUpdated()) {
      BO.m_cWv_ardt_ae_delegabo = BO.ardt_ae_delegabo.GetContext();
    }
    if (BO.ardt_saldioro.IsUpdated()) {
      BO.m_cWv_ardt_saldioro = BO.ardt_saldioro.GetContext();
    }
    if (BO.ardt_jarantbo.IsUpdated()) {
      BO.m_cWv_ardt_jarantbo = BO.ardt_jarantbo.GetContext();
    }
    if (BO.ardt_ae_saldianno_rap.IsUpdated()) {
      BO.m_cWv_ardt_ae_saldianno_rap = BO.ardt_ae_saldianno_rap.GetContext();
    }
  }
  static void PrintStateWorkVars(armt_ae_anarapBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCRAP,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPORAP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOAG,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ISOAGE,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGLIRE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VALUTA,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PRGIMPRAP,"N",15,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_PRGIMPRAP:BO.w_PRGIMPRAP,"N",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODDIP,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOPROT,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gTelepass,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gCodDip,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gBrowser,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gTipInter,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descval,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_daticoll,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_titolo,"C",90,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_mess,"M",10,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_codazi:BO.m_Ctx.GetCompany(),"C",10,0));
    if (CPLib.eq(BO.m_cWv_ardt_ae_delegabo,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_ae_delegabo");
    } else if (CPLib.eq(BO.m_cWv_ardt_ae_delegabo,"_not_empty_")) {
      BO.m_cWv_ardt_ae_delegabo = BO.ardt_ae_delegabo.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_ae_delegabo,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_ae_delegabo,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_saldioro,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_saldioro");
    } else if (CPLib.eq(BO.m_cWv_ardt_saldioro,"_not_empty_")) {
      BO.m_cWv_ardt_saldioro = BO.ardt_saldioro.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_saldioro,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_saldioro,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_jarantbo,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_jarantbo");
    } else if (CPLib.eq(BO.m_cWv_ardt_jarantbo,"_not_empty_")) {
      BO.m_cWv_ardt_jarantbo = BO.ardt_jarantbo.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_jarantbo,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_jarantbo,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_ae_saldianno_rap,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_ae_saldianno_rap");
    } else if (CPLib.eq(BO.m_cWv_ardt_ae_saldianno_rap,"_not_empty_")) {
      BO.m_cWv_ardt_ae_saldianno_rap = BO.ardt_ae_saldianno_rap.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_ae_saldianno_rap,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_ae_saldianno_rap,"C",0,0));
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_XQILBJQNNS = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_subtitle = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(661,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(1021,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_ae_anarap"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'RUMXLFCOKA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"RUMXLFCOKA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbvalute,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'RUMXLFCOKA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbvalute,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_ae_anarap","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_ae_anarap",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("DatiBase"),"")) {
      status.quoteAndAppend("DatiBase","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("DatiBase"),"")) {
      status.quoteAndAppend("DatiBase","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Rapporto"),"")) {
      status.quoteAndAppend("Rapporto","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Deleghe"),"")) {
      status.quoteAndAppend("Deleghe","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("SaldiOro"),"")) {
      status.quoteAndAppend("SaldiOro","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Garantiti"),"")) {
      status.quoteAndAppend("Garantiti","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Saldi"),"")) {
      status.quoteAndAppend("Saldi","hide","box");
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
  void WriteMainFormScript(armt_ae_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_ae_anarap',false);");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('LXORWVRYJJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AQAARAIPOR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZFOHYLVPYN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BHAVHLFPAC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QBUCLWUNFT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BCLYMGMBLK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RUMXLFCOKA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RUMXLFCOKA_ZOOM')) SetDisabled(c,true);");
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
      status.out.println("if (Ctrl('OYYXUVDIWN')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('OYYXUVDIWN',linkpc_url('OYYXUVDIWN'));");
      status.out.println("}");
      status.out.println("if (Ctrl('XRVFDCHTKZ')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('XRVFDCHTKZ',linkpc_url('XRVFDCHTKZ'));");
      status.out.println("}");
      status.out.println("if (Ctrl('ZSYGOPYXSA')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('ZSYGOPYXSA',linkpc_url('ZSYGOPYXSA'));");
      status.out.println("}");
      status.out.println("if (Ctrl('XUXHMWVHFR')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('XUXHMWVHFR',linkpc_url('XUXHMWVHFR'));");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('LXORWVRYJJ')) SetDisabled(c,true);");
      }
    }
    status.out.println("FillCombosValues();");
    status.out.println("SetControlsValue();");
    status.out.println("NotifyEvent('Record Loaded');");
    status.out.println("LoadContext();");
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
    status.out.println("if (Eq(name,'ardt_ae_delegabo')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_ae_delegabo")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_saldioro')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_saldioro")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_jarantbo')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_jarantbo")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_ae_saldianno_rap')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_ae_saldianno_rap")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    ChildSelectedPageChild(BO.m_MNTs,status,status.m_cSelectedPage);
    status.out.println("}");
    if (CPLib.ne(status.m_cClientMode,"query")) {
      status.out.println("function UpdateAutonumber(p_uid) {");
      status.out.println("var l_b0 = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
      status.out.println("if (Eq(p_uid,'PRGIMPRAP') || Empty(p_uid)) {");
      status.out.println("l_b0= ! (Eq(op_codazi,m_cCompany));");
      status.out.println("}");
      status.out.println("if (l_b0) {");
      status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_PRGIMPRAP','PRGIMPRAP');");
      status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
      status.out.println("AutonumberApplet().SetProg('PRGIMPRAP',w_PRGIMPRAP,op_PRGIMPRAP,'N',15,0);");
      status.out.println("AutonumberApplet().SetETName('jnarapbo');");
      status.out.println("w_PRGIMPRAP=AutonumberApplet().GetAutonumberDouble('PRGIMPRAP');");
      status.out.println("}");
      status.out.println("if (l_b0) {");
      status.out.println("op_codazi=m_cCompany;");
      status.out.println("op_PRGIMPRAP=w_PRGIMPRAP;");
      status.out.println("}");
      status.out.println("}");
    }
    WriteJSError(status);
    WriteTableCombo(status,BO);
    status.out.println("// * --- Area Manuale = UI - Functions & Procedures");
    status.out.println("// * --- armt_ae_anarap");
    status.out.println("function nuovainf() {");
    status.out.println("  if (m_cFunction=='new' || m_cFunction=='edit') {");
    status.out.println("    cp_StandardFunction('Save');");
    status.out.println("  } else {");
    status.out.println("    cp_StandardFunction('Quit');");
    status.out.println("  }");
    status.out.println("  var l_oWv = InitWvApplet();");
    status.out.println("  l_oWv.setValue('RAPPORTO',AsAppletValue(w_RAPPORTO));");
    status.out.println("  l_oWv.setValue('m_cParameterSequence',AsAppletValue('RAPPORTO'));");
    status.out.println("  _modifyandopen('armt_informazioni'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=new&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,resizable=1,scrollbars=yes',null)");
    status.out.println("  ");
    status.out.println("}");
    status.out.println("");
    status.out.println("function Crea3132() {");
    status.out.println("  if (confirm('Confermi la creazione delle informazioni ?')) {");
    status.out.println("    _modifyandopen('arrt_crea_3132'+'?m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,,width=800,,height=600,resizable=1,scrollbars=yes',null)");
    status.out.println("  }");
    status.out.println("}");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  armt_ae_anarapBO getBO(ServletStatus status) {
    armt_ae_anarapBO BO = new armt_ae_anarapBO(status.context);
    // gli op_ possono essere utilizzati dalla servlet anche prima di essere inizializzati
    BO.op_PRGIMPRAP = BO.w_PRGIMPRAP;
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_ae_anarapBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("jnarapbo",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_ae_anarapBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_ae_anarapBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
    l_cTmp = "[";
    VQRHolder l_VQRHolder=null;
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_tbtipnat",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),BO,false);
    l_VQRHolder.LoadTempWhere("");
    l_rsLoad = l_VQRHolder.GetResultSet(BO.m_Ctx);
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",1,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("TIPONAT"),"C",1,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var ZFOHYLVPYN_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_tbrapp",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),BO,false);
    l_VQRHolder.LoadTempWhere("");
    l_rsLoad = l_VQRHolder.GetResultSet(BO.m_Ctx);
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",2,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("CODICE"),"C",2,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCOMBO"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var BHAVHLFPAC_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbstati,CPSql.BuildSQLPhrase("ISO,DESCRI",BO.m_cPhName_tbstati,"","DESCRI"));
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",3,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("ISO"),"C",3,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var QBUCLWUNFT_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(armt_ae_anarapBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_jnarapbo;
    String l_cPhName = BO.m_cPhName_jnarapbo;
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    // * --- Area Manuale = BO - Query Key Set Init
    // * --- Fine Area Manuale
    int l_nIdx;
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_ae_anarapBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_jnarapbo+".RAPPORTO",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("jnarapbo");
    String l_cPhName = CPSql.ManipulateTablePhName("jnarapbo",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".RAPPORTO",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,armt_ae_anarapBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_ae_anarapBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_jnarapbo,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_jnarapbo,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_ae_anarapBO BO) {
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
  void Edit(ServletStatus status,armt_ae_anarapBO BO,SPParameterSource source) {
    BO.Load(status.w_RAPPORTO);
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
  void New(ServletStatus status,armt_ae_anarapBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_ae_anarapBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_ae_anarapBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_RAPPORTO = "";
      } else {
        BO.w_RAPPORTO = l_rsKeys.GetString("RAPPORTO");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_RAPPORTO = BO.w_RAPPORTO;
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
  void EditLoad(ServletStatus status,armt_ae_anarapBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_ae_anarapBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_RAPPORTO);
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
  void DeleteMessage(ServletStatus status,armt_ae_anarapBO BO,SPParameterSource source) {
    BO.Load(status.w_RAPPORTO);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_ae_anarapBO BO) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    String l_cTransMsgErr = "";
    BO.SetFromContext(status.m_cWv,status.m_Parameters);
    double l_old_PRGIMPRAP = 0;
    if (CPLib.ne(BO.w_PRGIMPRAP,BO.op_PRGIMPRAP)) {
      l_old_PRGIMPRAP = BO.op_PRGIMPRAP;
    }
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({RAPPORTO:"+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
      if ( ! (CPLib.Empty(l_old_PRGIMPRAP))) {
        BO.op_PRGIMPRAP = l_old_PRGIMPRAP;
      }
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
  void Discard(ServletStatus status,armt_ae_anarapBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_ae_anarapBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",621);
    item.put("w",1021);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","true");
    org.json.JSONObject pageProp = null;
    org.json.JSONArray pagesProp = null;
    pagesProp = new org.json.JSONArray();
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Dati Base\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Operazioni\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Deleghe su rapporto\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Garantiti\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Saldi\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Dati Base,Operazioni,Deleghe su rapporto,Garantiti,Saldi");
    item.put("altInterfaceFor","armt_ae_anarap");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"DatiBase\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Base\",\"h\":144,\"name\":\"DatiBase\",\"page\":1,\"shrinkable\":true,\"spuid\":\"YORQOIOBQN\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Dati Base\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Rapporto\",\"h\":20,\"maxlength\":25,\"name\":\"RAPPORTO\",\"page\":1,\"spuid\":\"LXORWVRYJJ\",\"tabindex\":7,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":162,\"x\":144,\"y\":16,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OICGZUOZYP\",\"page\":1,\"spuid\":\"OICGZUOZYP\",\"tabindex\":8,\"type\":\"Label\",\"value\":\"Codice Rapporto:\",\"w\":132,\"x\":8,\"y\":20,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Descrizione\",\"h\":20,\"maxlength\":50,\"name\":\"DESCRAP\",\"page\":1,\"spuid\":\"AQAARAIPOR\",\"tabindex\":9,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":328,\"x\":448,\"y\":16,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VEBJKDHMDC\",\"page\":1,\"spuid\":\"VEBJKDHMDC\",\"tabindex\":10,\"type\":\"Label\",\"value\":\"Descrizione:\",\"w\":120,\"x\":324,\"y\":20,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Rapporto\",\"h\":20,\"maxlength\":1,\"name\":\"TIPORAP\",\"page\":1,\"spuid\":\"ZFOHYLVPYN\",\"tabindex\":11,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":856,\"x\":144,\"y\":40,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GDCHKTFQUK\",\"page\":1,\"spuid\":\"GDCHKTFQUK\",\"tabindex\":15,\"type\":\"Label\",\"value\":\"Tipo Rapporto:\",\"w\":132,\"x\":8,\"y\":44,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":2,\"name\":\"TIPOAG\",\"page\":1,\"spuid\":\"BHAVHLFPAC\",\"tabindex\":12,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":856,\"x\":144,\"y\":64,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CTCKWHZVTZ\",\"page\":1,\"spuid\":\"CTCKWHZVTZ\",\"tabindex\":29,\"type\":\"Label\",\"value\":\"Tipo Rap. Ag. Entrate:\",\"w\":132,\"x\":8,\"y\":70,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Per tipo rapporto 96\\/97\",\"h\":20,\"maxlength\":3,\"name\":\"ISOAGE\",\"page\":1,\"spuid\":\"QBUCLWUNFT\",\"tabindex\":13,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":336,\"x\":144,\"y\":88,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TQNAPDCWFY\",\"page\":1,\"spuid\":\"TQNAPDCWFY\",\"tabindex\":28,\"type\":\"Label\",\"value\":\"Per tipo 96\\/97:\",\"w\":90,\"x\":51,\"y\":92,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Divisa\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"FLAGLIRE\",\"page\":1,\"spuid\":\"BCLYMGMBLK\",\"tabindex\":14,\"textlist\":\"Lire,Euro,Valuta Estera\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"L"+"'"+","+"'"+"E"+"'"+","+"'"+"V"+"'"+"\",\"w\":126,\"x\":144,\"y\":112,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Divisa\",\"h\":20,\"maxlength\":3,\"name\":\"VALUTA\",\"page\":1,\"picker\":true,\"spuid\":\"RUMXLFCOKA\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":38,\"x\":368,\"y\":112,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OUQKLNQVMP\",\"page\":1,\"spuid\":\"OUQKLNQVMP\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"Divisa:\",\"w\":132,\"x\":8,\"y\":116,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MILRATMPIJ\",\"page\":1,\"spuid\":\"MILRATMPIJ\",\"tabindex\":18,\"type\":\"Label\",\"value\":\"Codice Divisa:\",\"w\":93,\"x\":272,\"y\":116,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_XQILBJQNNS\",\"page\":1,\"spuid\":\"XQILBJQNNS\",\"tabindex\":20,\"type\":\"Label\",\"w\":328,\"x\":432,\"y\":116,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"DatiBase\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Base\",\"h\":464,\"name\":\"DatiBase\",\"page\":1,\"shrinkable\":true,\"spuid\":\"GJZISGEBVV\",\"stretch\":true,\"tabindex\":2,\"title_caption\":\"Dati Base\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":152,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":208,\"name\":\"Intestatari\",\"page\":1,\"spuid\":\"XCLJCOLAOK\",\"src\":\"\\/jsp\\/pg_intestbo_ae_portlet.jsp?ForcedPortletUID=XCLJCOLAOK\",\"tabindex\":25,\"type\":\"Portlet\",\"w\":992,\"x\":8,\"y\":160,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":232,\"name\":\"Informazioni\",\"page\":1,\"spuid\":\"NXJPOCJGET\",\"src\":\"\\/jsp\\/pg_rapopebo_ae_portlet.jsp?ForcedPortletUID=NXJPOCJGET\",\"tabindex\":26,\"type\":\"Portlet\",\"w\":992,\"x\":8,\"y\":376,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Rapporto\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Rapporto e Operazioni\",\"h\":592,\"name\":\"Rapporto\",\"page\":2,\"shrinkable\":true,\"spuid\":\"LZCEHELAXJ\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Rapporto e Operazioni\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag2_1\",\"zonepath\":\"[2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":576,\"name\":\"Operazioni\",\"page\":2,\"spuid\":\"VNBQZVXZTE\",\"src\":\"\\/jsp\\/pg_operazbo_ae_portlet.jsp?ForcedPortletUID=VNBQZVXZTE\",\"tabindex\":3,\"type\":\"Portlet\",\"w\":1000,\"x\":8,\"y\":8,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Deleghe\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Deleghe\",\"h\":280,\"name\":\"Deleghe\",\"page\":3,\"shrinkable\":true,\"spuid\":\"EHSQLOIDHO\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Deleghe\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag3_1\",\"zonepath\":\"[3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":256,\"name\":\"ardt_ae_delegabo\",\"page\":3,\"spuid\":\"OYYXUVDIWN\",\"tabindex\":2,\"type\":\"Iframe\",\"w\":773,\"x\":136,\"y\":16,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"SaldiOro\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Saldi Oro\",\"h\":184,\"name\":\"SaldiOro\",\"page\":3,\"shrinkable\":true,\"spuid\":\"KAVLKRYWMM\",\"stretch\":true,\"tabindex\":4,\"title_caption\":\"Saldi Oro\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":288,\"zone\":\"pag3_2\",\"zonepath\":\"[3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":164,\"name\":\"ardt_saldioro\",\"page\":3,\"spuid\":\"XRVFDCHTKZ\",\"tabindex\":3,\"type\":\"Iframe\",\"w\":455,\"x\":296,\"y\":296,\"zone\":\"pag3_2_1\",\"zonepath\":\"[3,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Garantiti\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Garantiti\",\"h\":352,\"name\":\"Garantiti\",\"page\":4,\"shrinkable\":true,\"spuid\":\"LWDMGLAEON\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Garantiti\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag4_1\",\"zonepath\":\"[4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":335,\"name\":\"ardt_jarantbo\",\"page\":4,\"spuid\":\"ZSYGOPYXSA\",\"tabindex\":2,\"type\":\"Iframe\",\"w\":771,\"x\":160,\"y\":8,\"zone\":\"pag4_1_1\",\"zonepath\":\"[4,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Saldi\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Saldi\",\"h\":602,\"name\":\"Saldi\",\"page\":5,\"shrinkable\":true,\"spuid\":\"MUCCIMEJEB\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Saldi\",\"titled\":true,\"type\":\"Box\",\"w\":824,\"x\":0,\"y\":0,\"zone\":\"pag5_1\",\"zonepath\":\"[5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":335,\"name\":\"ardt_ae_saldianno_rap\",\"page\":5,\"spuid\":\"XUXHMWVHFR\",\"tabindex\":2,\"type\":\"Iframe\",\"w\":647,\"x\":80,\"y\":133,\"zone\":\"pag5_1_1\",\"zonepath\":\"[5,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_ae_anarapBO BO,ServletStatus status) {
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
     "<script src='armt_ae_anarap?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_ae_anarap_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_ae_anarap_edit.js'>" +
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
      status.out.println("w_RAPPORTO=a[0];");
      status.out.println("w_DESCRAP=a[1];");
      status.out.println("w_TIPORAP=a[2];");
      status.out.println("w_TIPOAG=a[3];");
      status.out.println("w_ISOAGE=a[4];");
      status.out.println("w_FLAGLIRE=a[5];");
      status.out.println("w_VALUTA=a[6];");
      status.out.println("w_PRGIMPRAP=a[7];");
      status.out.println("op_PRGIMPRAP=a[8];");
      status.out.println("w_CODDIP=a[9];");
      status.out.println("w_NOPROT=a[10];");
      status.out.println("w_gTelepass=a[11];");
      status.out.println("w_gCodDip=a[12];");
      status.out.println("w_gBrowser=a[13];");
      status.out.println("w_gTipInter=a[14];");
      status.out.println("w_descval=a[15];");
      status.out.println("w_daticoll=a[16];");
      status.out.println("w_titolo=a[17];");
      status.out.println("w_mess=a[18];");
      status.out.println("op_codazi=a[19];");
      status.out.println("m_cWv_ardt_ae_delegabo=a[20];");
      status.out.println("m_cWv_ardt_saldioro=a[21];");
      status.out.println("m_cWv_ardt_jarantbo=a[22];");
      status.out.println("m_cWv_ardt_ae_saldianno_rap=a[23];");
      status.out.println("if (Gt(a.length,24)) {");
      status.out.println("m_cErrorInChild='';");
      status.out.println("}");
      status.out.println("if (Gt(a.length,24)) {");
      status.out.println("o_TIPOAG=w_TIPOAG;");
      status.out.println("o_FLAGLIRE=w_FLAGLIRE;");
      status.out.println("o_VALUTA=w_VALUTA;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['RAPPORTO'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_ae_anarap_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(661,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
    status.out.println(
     "<script>" +
    "");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("AppletTag('Link');");
      status.out.println("AppletTag('Autonumber');");
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
    f.SetParameter("Table","jnarapbo");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","RAPPORTO");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(armt_ae_anarapBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({RAPPORTO:"+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_ae_anarapBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({RAPPORTO:"+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armt_ae_anarapBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({RAPPORTO:"+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armt_ae_anarapBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({RAPPORTO:"+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armt_ae_anarapBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({RAPPORTO:"+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_ae_anarapBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_ae_anarapBO BO,ServletStatus status) throws IOException {
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
    l_cJsUid = SPPrxycizer.proxycizedPath("Utilities.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_crea_3132.js");
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
      CPLib.AddToSet(callable,"Utilities");
      CPLib.AddToSet(callable,"arrt_crea_3132");
      CPLib.AddToSet(callable,"ardt_ae_delegabo");
      CPLib.AddToSet(callable,"ardt_saldioro");
      CPLib.AddToSet(callable,"ardt_jarantbo");
      CPLib.AddToSet(callable,"ardt_ae_saldianno_rap");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_ae_anarapBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_RAPPORTO),"C",25,0));
      }
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gTelepass),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gCodDip),"C",6,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gBrowser),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gTipInter),"C",2,0));
    } else if (CPLib.eq(p_cUID,"RUMXLFCOKA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_ae_anarapBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_VALUTA))) {
        a = GetCheckVars(status,BO,"RUMXLFCOKA");
        b = status.m_CheckVars.optString("RUMXLFCOKA");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
