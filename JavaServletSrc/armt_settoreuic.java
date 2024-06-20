import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_settoreuic extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*f72ecb09*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "tbsetsin";
    }
    public String w_SETSINT;
    public double w_IDSETSIN;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_SETSINT,context,"tbsetsin","SETSINT","C",3,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_IDSETSIN,context,"tbsetsin","IDSETSIN","N",5,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='SETSINT' type='hidden' value="+SPLib.ToHTMLValue(w_SETSINT,"C",3,0)+">" +
        "");
        status.out.println(
         "<input name='IDSETSIN' type='hidden' value="+SPLib.ToHTMLValue(w_IDSETSIN,"N",5,0)+">" +
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
    armt_settoreuicBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_tbsetsin;
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
      status.w_SETSINT = BO.w_SETSINT;
      status.w_IDSETSIN = BO.w_IDSETSIN;
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
    return "Settorizzazione UIF";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_settoreuic";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 805;
    l_eg.m_nEntityHeight = 466;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"tbsetsin","tbramgru","tbstgru"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","Dati","page"),new ZoneItem("page_2","Sottogruppi","page"),new ZoneItem("page_3","ATECO","page"),new ZoneItem("Gruppi","Gruppi","horizontal_section"),new ZoneItem("Sottoguppi","Sottogruppi","horizontal_section"),new ZoneItem("ATECO","ATECO","horizontal_section")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"SETSINT","IDSETSIN"};
    l_eg.items = new SPItem[]{
                   new SPItem("SETSINT","C",3,0, "edit","Codice"),
                   new SPItem("DESCRI","C",200,0, "edit","Descrizione"),
                   new SPItem("descg1","C",70,0, "hide","Descrizione"),
                   new SPItem("descg2","C",70,0, "hide","Descrizione"),
                   new SPItem("descg3","C",70,0, "hide","Descrizione"),
                   new SPItem("descg4","C",70,0, "hide","Descrizione"),
                   new SPItem("descg5","C",70,0, "hide","Descrizione"),
                   new SPItem("descg6","C",70,0, "hide","Descrizione"),
                   new SPItem("descg7","C",70,0, "hide","Descrizione"),
                   new SPItem("descg8","C",70,0, "hide","Descrizione"),
                   new SPItem("descg9","C",70,0, "hide","Descrizione"),
                   new SPItem("descg10","C",70,0, "hide","Descrizione"),
                   new SPItem("descg11","C",70,0, "hide","Descrizione"),
                   new SPItem("descg12","C",70,0, "hide","Descrizione"),
                   new SPItem("DATAINI","D",8,0, "edit","Inizio Validità"),
                   new SPItem("DATAFINE","D",8,0, "edit","Data Fine Validità"),
                   new SPItem("IDSETSIN","N",5,0, "show","Identificativo"),
                   new SPItem("DAGRU1","C",3,0, "edit","Da Gruppo"),
                   new SPItem("AGRU1","C",3,0, "edit","A Gruppo"),
                   new SPItem("DAGRU2","C",3,0, "edit","Da Gruppo"),
                   new SPItem("AGRU2","C",3,0, "edit","A Gruppo"),
                   new SPItem("DAGRU3","C",3,0, "edit","Da Gruppo"),
                   new SPItem("AGRU3","C",3,0, "edit","A Gruppo"),
                   new SPItem("DAGRU4","C",3,0, "edit","Da Gruppo"),
                   new SPItem("AGRU4","C",3,0, "edit","A Gruppo"),
                   new SPItem("DAGRU5","C",3,0, "edit","Da Gruppo"),
                   new SPItem("AGRU5","C",3,0, "edit","A Gruppo"),
                   new SPItem("DAGRU6","C",3,0, "edit","Da Gruppo"),
                   new SPItem("AGRU6","C",3,0, "edit","A Gruppo"),
                   new SPItem("DASOT1","C",3,0, "edit","Da Sottogruppo"),
                   new SPItem("ASOT1","C",3,0, "edit","A Sottogruppo"),
                   new SPItem("DASOT2","C",3,0, "edit","Da Sottogruppo"),
                   new SPItem("ASOT2","C",3,0, "edit","A Sottogruppo"),
                   new SPItem("DASOT3","C",3,0, "edit","Da Sottogruppo"),
                   new SPItem("ASOT3","C",3,0, "edit","A Sottogruppo"),
                   new SPItem("DASOT4","C",3,0, "edit","Da Sottogruppo"),
                   new SPItem("ASOT4","C",3,0, "edit","A Sottogruppo"),
                   new SPItem("DASOT5","C",3,0, "edit","Da Sottogruppo"),
                   new SPItem("ASOT5","C",3,0, "edit","A Sottogruppo"),
                   new SPItem("DASOT6","C",3,0, "edit","Da Sottogruppo"),
                   new SPItem("ASOT6","C",3,0, "edit","A Sottogruppo"),
                   new SPItem("DASOT7","C",3,0, "edit","Da Sottogruppo"),
                   new SPItem("ASOT7","C",3,0, "edit","A Sottogruppo"),
                   new SPItem("DASOT8","C",3,0, "edit","Da Sottogruppo"),
                   new SPItem("ASOT8","C",3,0, "edit","A Sottogruppo"),
                   new SPItem("DASOT9","C",3,0, "edit","Da Sottogruppo"),
                   new SPItem("ASOT9","C",3,0, "edit","A Sottogruppo"),
                   new SPItem("DASOT10","C",3,0, "edit","Da Sottogruppo"),
                   new SPItem("ASOT10","C",3,0, "edit","A Sottogruppo"),
                   new SPItem("DASOT11","C",3,0, "edit","Da Sottogruppo"),
                   new SPItem("ASOT11","C",3,0, "edit","A Sottogruppo"),
                   new SPItem("DASOT12","C",3,0, "edit","Da Sottogruppo"),
                   new SPItem("ASOT12","C",3,0, "edit","A Sottogruppo"),
                   new SPItem("descsg1","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg2","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg3","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg4","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg5","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg6","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg7","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg8","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg9","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg10","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg11","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg12","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg13","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg14","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg15","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg16","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg17","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg18","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg19","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg20","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg21","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg22","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg23","C",60,0, "hide","Descrizione"),
                   new SPItem("descsg24","C",60,0, "hide","Descrizione"),
                   new SPItem("DAATE2","C",3,0, "edit","Da"),
                   new SPItem("AATE2","C",3,0, "edit","A"),
                   new SPItem("DAATE3","C",3,0, "edit","Da"),
                   new SPItem("AATE3","C",3,0, "edit","A"),
                   new SPItem("DAATE4","C",3,0, "edit","Da"),
                   new SPItem("AATE4","C",3,0, "edit","A"),
                   new SPItem("DAATE5","C",3,0, "edit","Da"),
                   new SPItem("AATE5","C",3,0, "edit","A"),
                   new SPItem("DAATE6","C",3,0, "edit","Da"),
                   new SPItem("AATE6","C",3,0, "edit","A"),
                   new SPItem("DAATE1","C",3,0, "edit","Da"),
                   new SPItem("AATE1","C",3,0, "edit","A")
                 };
    l_eg.m_lHasHistorical = false;
    return l_eg;
  }
  ArrayList<org.json.JSONArray> i_sidebarItems = null;
  public org.json.JSONArray getSidebarItems(int p_nPage) {
    if (CPLib.IsNull(i_sidebarItems)) {
      i_sidebarItems = InitializeSidebarItemsArray(3);
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_settoreuicBO BO) {
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
      i_contextmenu = InitializeContextMenuArray(3);
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
    l_translations=new String[][]{{"10416170749",p_Context.Translate("A Sottogruppo")},
    {"10924374093",p_Context.Translate("Sottogruppi")},
    {"112851763",p_Context.Translate("Codice")},
    {"117931111",p_Context.Translate("Gruppi")},
    {"1216938285",p_Context.Translate("Data Fine Validità")},
    {"1620",p_Context.Translate("Da")},
    {"1736206657",p_Context.Translate("A Gruppo")},
    {"1863368778",p_Context.Translate("Inizio Validità")},
    {"1931203291",p_Context.Translate("Da Sottogruppo")},
    {"2009503427",p_Context.Translate("Da Gruppo")},
    {"2095912466",p_Context.Translate("Settorizzazione UIF")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"65",p_Context.Translate("A")},
    {"74995196",p_Context.Translate("Identificativo")}};
    return l_translations;
  }
  void WriteStyles(armt_settoreuicBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_settoreuic.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_settoreuicBO BO,ServletStatus status) {
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
    status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati"),"C",0,0)+"},{name:\"page_2\", element:\"page_2\", caption:"+SPLib.ToJSValue(status.context.Translate("Sottogruppi"),"C",0,0)+"},{name:\"page_3\", element:\"page_3\", caption:"+SPLib.ToJSValue(status.context.Translate("ATECO"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
    status.out.println("Z.Tabs.Set('tabs',tabs);");
    status.out.println("} else {");
    status.out.println("var tabs = Z.Tabs.Get('tabs')");
    status.out.println("}");
    AddExtendedTabs(status);
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_settoreuic',false);");
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_settoreuic",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(armt_settoreuicBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    WriteControls_p2(BO,status);
    WriteControls_p3(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,4);
  }
  void WriteControls_p1(armt_settoreuicBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:466px;width:805px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteControls_p1_b1(BO,status);
    WriteControls_p1_b2(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"Dati");
    PrintSidebarContent(1,status,getSidebarItems(0),true);
    PrintContextMenu(1,status,getContextMenu(0),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2(armt_settoreuicBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_2' class='PageContainer' style='position:relative;height:697px;width:805px;display:none'>" +
    "");
    WriteControls_p2_b0(BO,status);
    WriteControls_p2_b1(BO,status);
    WriteControls_p2_b2(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,2,"Sottogruppi");
    PrintSidebarContent(2,status,getSidebarItems(1),true);
    PrintContextMenu(2,status,getContextMenu(1),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3(armt_settoreuicBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_3' class='PageContainer' style='position:relative;height:137px;width:805px;display:none'>" +
    "");
    WriteControls_p3_b0(BO,status);
    WriteControls_p3_b1(BO,status);
    WriteControls_p3_b2(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,3,"ATECO");
    PrintSidebarContent(3,status,getSidebarItems(2),true);
    PrintContextMenu(3,status,getContextMenu(2),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b0(armt_settoreuicBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_1' style='position:relative;height:98px;display:block' page='1'>" +
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
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SETSINT' id='VPSAQWGZDD' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_SETSINT,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='3' size='3' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UQGAHSYHAV_DIV'>" +
       "<label id='UQGAHSYHAV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DESCRI' id='QGQGKEQSTH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DESCRI,"C",200,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='200' size='200' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PTOPEVANKG_DIV'>" +
       "<label id='PTOPEVANKG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Descrizione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAINI' id='KUAJNGTYUY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATAINI,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ETEULTPDNQ_DIV'>" +
       "<label id='ETEULTPDNQ' for='KUAJNGTYUY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Inizio Validità:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAFINE' id='WMKNBZMDVY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATAFINE,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YRJEQBTMDY_DIV'>" +
       "<label id='YRJEQBTMDY' for='WMKNBZMDVY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Fine Validità:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='IDSETSIN' id='LFVVYXTUJL' type='text' class='Field PrimaryKeyField "+(CPLib.ne(status.m_cClientMode,"query")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_IDSETSIN,"N",5,0,"", status.m_oRegSettings)+" tabindex='-1' "+(CPLib.ne(status.m_cClientMode,"query")?"readonly":"")+" maxlength='6' size='5' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel PrimaryKeyLabel' id='TTXFJGCAKL_DIV'>" +
       "<label id='TTXFJGCAKL' for='LFVVYXTUJL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Identificativo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b1(armt_settoreuicBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Gruppi' id='FUBVXBVEKS_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='FUBVXBVEKS_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='FUBVXBVEKS_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Gruppi")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='FUBVXBVEKS_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"FUBVXBVEKS\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=FUBVXBVEKS_HEADER&m_cBoxId=FUBVXBVEKS&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Gruppi"))+"");
    }
    status.out.println(
     "<div id='FUBVXBVEKS' class='SectionBody' style='position:relative;height:343px;display:block'>" +
    "");
    status.includeZoneAltInterface("Gruppi@BEGIN");
    if (status.includeZoneAltInterface("Gruppi")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Gruppi@BEGIN") || status.HasZoneAltInterface("Gruppi@END")) {
        status.out.println(
         "<div id='FUBVXBVEKS_boxContent' style='position:relative;height:343px;display:block'>" +
        "");
      }
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DAGRU1' id='BMLJXZOHDR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DAGRU1,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='BMLJXZOHDR_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "BMLJXZOHDR", "tbramgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AGRU1' id='PIMPFADLTV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AGRU1,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='PIMPFADLTV_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "PIMPFADLTV", "tbramgru", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NVQZSQQSZV_DIV'>" +
       "<label id='NVQZSQQSZV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Gruppo 1:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DAGRU2' id='NFMNJIJKQG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DAGRU2,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='NFMNJIJKQG_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "NFMNJIJKQG", "tbramgru", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NVAQUXTUOQ_DIV'>" +
       "<label id='NVAQUXTUOQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Gruppo 2:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AGRU2' id='EGVTWLPYYK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AGRU2,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='EGVTWLPYYK_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "EGVTWLPYYK", "tbramgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DAGRU3' id='PBXUYJXCDV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DAGRU3,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='PBXUYJXCDV_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "PBXUYJXCDV", "tbramgru", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='QXYWEFGWVD_DIV'>" +
       "<label id='QXYWEFGWVD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Gruppo 3:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AGRU3' id='LKRRMRMXCU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AGRU3,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='LKRRMRMXCU_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "LKRRMRMXCU", "tbramgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DAGRU4' id='NQYJKRPMAY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DAGRU4,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='NQYJKRPMAY_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "NQYJKRPMAY", "tbramgru", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TWMGRVZHSM_DIV'>" +
       "<label id='TWMGRVZHSM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Gruppo 4:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AGRU4' id='XLQJSGTFOG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AGRU4,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='XLQJSGTFOG_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "XLQJSGTFOG", "tbramgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DAGRU5' id='VVLLCWNYJU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DAGRU5,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='VVLLCWNYJU_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "VVLLCWNYJU", "tbramgru", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JUGSXZDYLQ_DIV'>" +
       "<label id='JUGSXZDYLQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Gruppo 5:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AGRU5' id='GPJQCCUFYH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AGRU5,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='GPJQCCUFYH_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "GPJQCCUFYH", "tbramgru", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MGXPNAALHJ_DIV'>" +
       "<label id='MGXPNAALHJ'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descg1)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WBPEHNHOQV_DIV'>" +
       "<label id='WBPEHNHOQV'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descg2)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PRHOSSIUHM_DIV'>" +
       "<label id='PRHOSSIUHM'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descg3)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EBMXLDUAAV_DIV'>" +
       "<label id='EBMXLDUAAV'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descg4)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZQXAACQTIK_DIV'>" +
       "<label id='ZQXAACQTIK'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descg5)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EXZFMYCRTN_DIV'>" +
       "<label id='EXZFMYCRTN'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descg6)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XRCWONBWTI_DIV'>" +
       "<label id='XRCWONBWTI'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descg7)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='IHBJYFVAEL_DIV'>" +
       "<label id='IHBJYFVAEL'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descg8)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NSKPJFIAVB_DIV'>" +
       "<label id='NSKPJFIAVB'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descg9)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BCSNIJGHNX_DIV'>" +
       "<label id='BCSNIJGHNX'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descg10)+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DAGRU6' id='OWCFHGKVPB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DAGRU6,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='OWCFHGKVPB_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "OWCFHGKVPB", "tbramgru", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PJBYBHDPKO_DIV'>" +
       "<label id='PJBYBHDPKO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Gruppo 6:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AGRU6' id='ZDTAXGFPRF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AGRU6,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='ZDTAXGFPRF_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "ZDTAXGFPRF", "tbramgru", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZFTIDKFQJV_DIV'>" +
       "<label id='ZFTIDKFQJV'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descg11)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CFVGDNSPYZ_DIV'>" +
       "<label id='CFVGDNSPYZ'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descg12)+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Gruppi@BEGIN") || status.HasZoneAltInterface("Gruppi@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b1_CloseBand(armt_settoreuicBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Gruppi@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Gruppi")) {
      status.out.println("Ctrl('FUBVXBVEKS').style.height='auto';");
    } else {
      status.out.println("Ctrl('FUBVXBVEKS').setAttribute('band_height',343);");
    }
    status.out.println("Ctrl('FUBVXBVEKS').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_settoreuicBO BO,ServletStatus status) {
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
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p2_b0(armt_settoreuicBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_2")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_2' style='position:relative;height:7px;display:block' page='2'>" +
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
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p2_b1(armt_settoreuicBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Sottoguppi' id='FMCUBWIEAJ_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='FMCUBWIEAJ_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='FMCUBWIEAJ_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Sottogruppi")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='FMCUBWIEAJ_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"FMCUBWIEAJ\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=FMCUBWIEAJ_HEADER&m_cBoxId=FMCUBWIEAJ&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Sottogruppi"))+"");
    }
    status.out.println(
     "<div id='FMCUBWIEAJ' class='SectionBody' style='position:relative;height:665px;display:block'>" +
    "");
    status.includeZoneAltInterface("Sottoguppi@BEGIN");
    if (status.includeZoneAltInterface("Sottoguppi")) {
      WriteControls_p2_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Sottoguppi@BEGIN") || status.HasZoneAltInterface("Sottoguppi@END")) {
        status.out.println(
         "<div id='FMCUBWIEAJ_boxContent' style='position:relative;height:665px;display:block'>" +
        "");
      }
      status.out.println(
       "<span class='SPLabel' id='BWFPLETCTY_DIV'>" +
       "<label id='BWFPLETCTY'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg2)+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DASOT1' id='QSAEKELBZF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DASOT1,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='QSAEKELBZF_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "QSAEKELBZF", "tbstgru", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NGXDDALQHH_DIV'>" +
       "<label id='NGXDDALQHH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sottogruppo 1:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ASOT1' id='TXKEYYFXPE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ASOT1,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='TXKEYYFXPE_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "TXKEYYFXPE", "tbstgru", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MCKVKEXCXT_DIV'>" +
       "<label id='MCKVKEXCXT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sottogruppo 2:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EEQXWIOXVQ_DIV'>" +
       "<label id='EEQXWIOXVQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sottogruppo 3:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NOQPGQPAGI_DIV'>" +
       "<label id='NOQPGQPAGI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sottogruppo 4:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WTDEHIPEIM_DIV'>" +
       "<label id='WTDEHIPEIM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sottogruppo 5:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EKQDVFAYDN_DIV'>" +
       "<label id='EKQDVFAYDN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sottogruppo 6:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WLDTLNLASC_DIV'>" +
       "<label id='WLDTLNLASC'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg1)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZNNARXJXPF_DIV'>" +
       "<label id='ZNNARXJXPF'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg3)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BKKYKCIQNX_DIV'>" +
       "<label id='BKKYKCIQNX'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg4)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='QHIIUHZDDH_DIV'>" +
       "<label id='QHIIUHZDDH'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg5)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VYXPGYHNZD_DIV'>" +
       "<label id='VYXPGYHNZD'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg6)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SDIPAGTESQ_DIV'>" +
       "<label id='SDIPAGTESQ'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg7)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EIUHGMIIHE_DIV'>" +
       "<label id='EIUHGMIIHE'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg8)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YOEHCOWQGR_DIV'>" +
       "<label id='YOEHCOWQGR'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg9)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FULBKWIDLQ_DIV'>" +
       "<label id='FULBKWIDLQ'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg10)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BKLOUOBBBX_DIV'>" +
       "<label id='BKLOUOBBBX'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg11)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EHBQRWJKNQ_DIV'>" +
       "<label id='EHBQRWJKNQ'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg12)+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DASOT2' id='XJEPLEAUZI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DASOT2,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='XJEPLEAUZI_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "XJEPLEAUZI", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ASOT2' id='DSBUADQBZO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ASOT2,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='DSBUADQBZO_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "DSBUADQBZO", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DASOT3' id='YMUIBONOPY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DASOT3,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='YMUIBONOPY_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "YMUIBONOPY", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ASOT3' id='YFLBURGYJF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ASOT3,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='YFLBURGYJF_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "YFLBURGYJF", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DASOT4' id='CZWHSOLRJS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DASOT4,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='CZWHSOLRJS_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "CZWHSOLRJS", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ASOT4' id='CQDPGDHEVA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ASOT4,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='CQDPGDHEVA_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "CQDPGDHEVA", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DASOT5' id='EVMGYBVTME' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DASOT5,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='EVMGYBVTME_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "EVMGYBVTME", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ASOT5' id='YCLLVDJDPC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ASOT5,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='YCLLVDJDPC_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "YCLLVDJDPC", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DASOT6' id='MWJSVBWARF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DASOT6,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='MWJSVBWARF_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "MWJSVBWARF", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ASOT6' id='AKTWQWJXMU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ASOT6,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='AKTWQWJXMU_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "AKTWQWJXMU", "tbstgru", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NQNYXGPYAE_DIV'>" +
       "<label id='NQNYXGPYAE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sottogruppo 7:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RRMXHWHYFF_DIV'>" +
       "<label id='RRMXHWHYFF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sottogruppo 8:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='AXUHCEMIZY_DIV'>" +
       "<label id='AXUHCEMIZY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sottogruppo 9:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ELKBXKOPKK_DIV'>" +
       "<label id='ELKBXKOPKK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sottogruppo 10:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DZZRAHWFBW_DIV'>" +
       "<label id='DZZRAHWFBW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sottogruppo 11:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WCISLNQJTG_DIV'>" +
       "<label id='WCISLNQJTG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sottogruppo 12:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MCMPGBSWUA_DIV'>" +
       "<label id='MCMPGBSWUA'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg13)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OBYSSBWXPD_DIV'>" +
       "<label id='OBYSSBWXPD'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg14)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LWSOFKTZPY_DIV'>" +
       "<label id='LWSOFKTZPY'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg15)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KERSOQEMTS_DIV'>" +
       "<label id='KERSOQEMTS'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg16)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DVEXNSNEJY_DIV'>" +
       "<label id='DVEXNSNEJY'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg17)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BTPYFBLNYP_DIV'>" +
       "<label id='BTPYFBLNYP'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg18)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='AMKLEQXPHC_DIV'>" +
       "<label id='AMKLEQXPHC'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg19)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LYJZUXVZAB_DIV'>" +
       "<label id='LYJZUXVZAB'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg20)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VDRSJXQAOE_DIV'>" +
       "<label id='VDRSJXQAOE'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg21)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OYPPDTBNMZ_DIV'>" +
       "<label id='OYPPDTBNMZ'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg22)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ARKLACPVPZ_DIV'>" +
       "<label id='ARKLACPVPZ'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg23)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PCMSUANJEX_DIV'>" +
       "<label id='PCMSUANJEX'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_descsg24)+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DASOT7' id='HGBIEMZYHZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DASOT7,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='HGBIEMZYHZ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "HGBIEMZYHZ", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ASOT7' id='JIXSOXOUMP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ASOT7,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='JIXSOXOUMP_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "JIXSOXOUMP", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DASOT8' id='NHXQYOJWPY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DASOT8,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='NHXQYOJWPY_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "NHXQYOJWPY", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ASOT8' id='FQHPMPIEFY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ASOT8,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='FQHPMPIEFY_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "FQHPMPIEFY", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DASOT9' id='KGVPSOERYT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DASOT9,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='KGVPSOERYT_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "KGVPSOERYT", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ASOT9' id='GWWXIEOXZQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ASOT9,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='GWWXIEOXZQ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "GWWXIEOXZQ", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DASOT10' id='TWZIVFFWLR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DASOT10,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='TWZIVFFWLR_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "TWZIVFFWLR", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ASOT10' id='ESIHSDXQVO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ASOT10,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='ESIHSDXQVO_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "ESIHSDXQVO", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DASOT11' id='LXNKGCWVDI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DASOT11,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='LXNKGCWVDI_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "LXNKGCWVDI", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ASOT11' id='QYOHOTJSEN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ASOT11,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='QYOHOTJSEN_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "QYOHOTJSEN", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DASOT12' id='AWBDLKZHRC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DASOT12,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='AWBDLKZHRC_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "AWBDLKZHRC", "tbstgru", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ASOT12' id='AZBXLFMDVT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ASOT12,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='AZBXLFMDVT_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "AZBXLFMDVT", "tbstgru", "", "")+"" +
      "");
      if (status.HasZoneAltInterface("Sottoguppi@BEGIN") || status.HasZoneAltInterface("Sottoguppi@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p2_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p2_b1_CloseBand(armt_settoreuicBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Sottoguppi@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Sottoguppi")) {
      status.out.println("Ctrl('FMCUBWIEAJ').style.height='auto';");
    } else {
      status.out.println("Ctrl('FMCUBWIEAJ').setAttribute('band_height',665);");
    }
    status.out.println("Ctrl('FMCUBWIEAJ').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b2(armt_settoreuicBO BO,ServletStatus status) {
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
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p3_b0(armt_settoreuicBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_3")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_3' style='position:relative;height:7px;display:block' page='3'>" +
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
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p3_b1(armt_settoreuicBO BO,ServletStatus status) {
    status.out.println(
     "<div name='ATECO' id='CLVYAMUSKV_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='CLVYAMUSKV_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='CLVYAMUSKV_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("ATECO")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='CLVYAMUSKV_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"CLVYAMUSKV\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=CLVYAMUSKV_HEADER&m_cBoxId=CLVYAMUSKV&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("ATECO"))+"");
    }
    status.out.println(
     "<div id='CLVYAMUSKV' class='SectionBody' style='position:relative;height:105px;display:block'>" +
    "");
    status.includeZoneAltInterface("ATECO@BEGIN");
    if (status.includeZoneAltInterface("ATECO")) {
      WriteControls_p3_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("ATECO@BEGIN") || status.HasZoneAltInterface("ATECO@END")) {
        status.out.println(
         "<div id='CLVYAMUSKV_boxContent' style='position:relative;height:105px;display:block'>" +
        "");
      }
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DAATE2' id='YMLTCQOYQA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DAATE2,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BHMIAQIZVT_DIV'>" +
       "<label id='BHMIAQIZVT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ATECO 2:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AATE2' id='HRVUSTIUAW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AATE2,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KCJJVUMXVW_DIV'>" +
       "<label id='KCJJVUMXVW' for='YMLTCQOYQA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LZUFLWWWSO_DIV'>" +
       "<label id='LZUFLWWWSO' for='HRVUSTIUAW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DAATE3' id='EBJQOWGCVT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DAATE3,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VCTBSSMPCC_DIV'>" +
       "<label id='VCTBSSMPCC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ATECO 3:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AATE3' id='YZSORAMVLG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AATE3,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DJFUXJVEGF_DIV'>" +
       "<label id='DJFUXJVEGF' for='EBJQOWGCVT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BXBEUHTNEG_DIV'>" +
       "<label id='BXBEUHTNEG' for='YZSORAMVLG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DAATE4' id='JMLQTMPVIO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DAATE4,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BXFBVBUSTR_DIV'>" +
       "<label id='BXFBVBUSTR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ATECO 4:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AATE4' id='SWAVWWKXOJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AATE4,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VTUFQRDPVL_DIV'>" +
       "<label id='VTUFQRDPVL' for='JMLQTMPVIO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WZQHGTSVJY_DIV'>" +
       "<label id='WZQHGTSVJY' for='SWAVWWKXOJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DAATE5' id='LVOQGHIOAR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DAATE5,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YRVSDNHGGP_DIV'>" +
       "<label id='YRVSDNHGGP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ATECO 5:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AATE5' id='EXYRSFXTUA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AATE5,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YUSGVTXWLX_DIV'>" +
       "<label id='YUSGVTXWLX' for='LVOQGHIOAR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZKHOVLRLTQ_DIV'>" +
       "<label id='ZKHOVLRLTQ' for='EXYRSFXTUA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DAATE6' id='NNPAZLOCUA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DAATE6,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DFKUHYRCIV_DIV'>" +
       "<label id='DFKUHYRCIV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ATECO 6:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AATE6' id='RZOSZBFTCK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AATE6,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BKYRTIAYOP_DIV'>" +
       "<label id='BKYRTIAYOP' for='NNPAZLOCUA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZRALREELCM_DIV'>" +
       "<label id='ZRALREELCM' for='RZOSZBFTCK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DAATE1' id='DEJMAVGSRU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DAATE1,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='QTFUGONGPK_DIV'>" +
       "<label id='QTFUGONGPK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ATECO 1:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AATE1' id='EQZKMRBROG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AATE1,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PYCGMACPZJ_DIV'>" +
       "<label id='PYCGMACPZJ' for='DEJMAVGSRU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Da:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DMPTGSIVUT_DIV'>" +
       "<label id='DMPTGSIVUT' for='EQZKMRBROG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("ATECO@BEGIN") || status.HasZoneAltInterface("ATECO@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p3_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p3_b1_CloseBand(armt_settoreuicBO BO,ServletStatus status) {
    status.includeZoneAltInterface("ATECO@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("ATECO")) {
      status.out.println("Ctrl('CLVYAMUSKV').style.height='auto';");
    } else {
      status.out.println("Ctrl('CLVYAMUSKV').setAttribute('band_height',105);");
    }
    status.out.println("Ctrl('CLVYAMUSKV').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p3_b2(armt_settoreuicBO BO,ServletStatus status) {
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
      status.out.println(
       "</div>" +
      "");
    }
  }
  static void PrintState(armt_settoreuicBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_settoreuicBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
  }
  static void PrintStateWorkVars(armt_settoreuicBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_SETSINT,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCRI,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DASOT1,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ASOT1,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DASOT2,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ASOT2,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DASOT3,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ASOT3,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DASOT4,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ASOT4,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DASOT5,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ASOT5,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DASOT6,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ASOT6,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DASOT7,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ASOT7,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DASOT8,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ASOT8,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DASOT9,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ASOT9,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DASOT10,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ASOT10,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DASOT11,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ASOT11,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DASOT12,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ASOT12,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAINI,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAFINE,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDSETSIN,"N",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DAGRU1,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AGRU1,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DAGRU2,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AGRU2,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DAGRU3,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AGRU3,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DAGRU4,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AGRU4,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DAGRU5,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AGRU5,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DAGRU6,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AGRU6,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DAATE2,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AATE2,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DAATE3,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AATE3,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DAATE4,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AATE4,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DAATE5,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AATE5,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DAATE6,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AATE6,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DAATE1,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AATE1,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descg1,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descg2,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descg3,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descg4,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descg5,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descg6,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descg7,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descg8,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descg9,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descg10,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg1,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg2,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg3,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg4,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg5,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg6,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg7,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg8,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg9,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg10,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg11,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg12,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descg11,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descg12,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg13,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg14,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg15,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg16,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg17,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg18,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg19,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg20,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg21,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg22,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg23,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descsg24,"C",60,0));
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_settoreuicBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_MGXPNAALHJ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_WBPEHNHOQV = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_PRHOSSIUHM = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_EBMXLDUAAV = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ZQXAACQTIK = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_EXZFMYCRTN = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_XRCWONBWTI = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_IHBJYFVAEL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_NSKPJFIAVB = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_BCSNIJGHNX = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ZFTIDKFQJV = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_CFVGDNSPYZ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_BWFPLETCTY = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_WLDTLNLASC = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ZNNARXJXPF = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_BKKYKCIQNX = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_QHIIUHZDDH = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_VYXPGYHNZD = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_SDIPAGTESQ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_EIUHGMIIHE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_YOEHCOWQGR = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_FULBKWIDLQ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_BKLOUOBBBX = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_EHBQRWJKNQ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_MCMPGBSWUA = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_OBYSSBWXPD = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_LWSOFKTZPY = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_KERSOQEMTS = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_DVEXNSNEJY = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_BTPYFBLNYP = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_AMKLEQXPHC = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_LYJZUXVZAB = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_VDRSJXQAOE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_OYPPDTBNMZ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ARKLACPVPZ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_PCMSUANJEX = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(466,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(805,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_settoreuic"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'BMLJXZOHDR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"BMLJXZOHDR",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'PIMPFADLTV':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"PIMPFADLTV",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'NFMNJIJKQG':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NFMNJIJKQG",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'EGVTWLPYYK':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"EGVTWLPYYK",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'PBXUYJXCDV':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"PBXUYJXCDV",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'LKRRMRMXCU':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"LKRRMRMXCU",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'NQYJKRPMAY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NQYJKRPMAY",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'XLQJSGTFOG':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"XLQJSGTFOG",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'VVLLCWNYJU':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"VVLLCWNYJU",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'GPJQCCUFYH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"GPJQCCUFYH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'OWCFHGKVPB':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"OWCFHGKVPB",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZDTAXGFPRF':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ZDTAXGFPRF",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'QSAEKELBZF':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QSAEKELBZF",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'TXKEYYFXPE':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"TXKEYYFXPE",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'XJEPLEAUZI':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"XJEPLEAUZI",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'DSBUADQBZO':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"DSBUADQBZO",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'YMUIBONOPY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"YMUIBONOPY",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'YFLBURGYJF':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"YFLBURGYJF",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'CZWHSOLRJS':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"CZWHSOLRJS",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'CQDPGDHEVA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"CQDPGDHEVA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'EVMGYBVTME':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"EVMGYBVTME",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'YCLLVDJDPC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"YCLLVDJDPC",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'MWJSVBWARF':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"MWJSVBWARF",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'AKTWQWJXMU':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"AKTWQWJXMU",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'HGBIEMZYHZ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"HGBIEMZYHZ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'JIXSOXOUMP':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"JIXSOXOUMP",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'NHXQYOJWPY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NHXQYOJWPY",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'FQHPMPIEFY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"FQHPMPIEFY",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'KGVPSOERYT':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"KGVPSOERYT",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'GWWXIEOXZQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"GWWXIEOXZQ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'TWZIVFFWLR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"TWZIVFFWLR",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'ESIHSDXQVO':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ESIHSDXQVO",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'LXNKGCWVDI':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"LXNKGCWVDI",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'QYOHOTJSEN':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QYOHOTJSEN",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'AWBDLKZHRC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"AWBDLKZHRC",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'AZBXLFMDVT':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"AZBXLFMDVT",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'BMLJXZOHDR':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'PIMPFADLTV':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'NFMNJIJKQG':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'EGVTWLPYYK':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'PBXUYJXCDV':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'LKRRMRMXCU':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'NQYJKRPMAY':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'XLQJSGTFOG':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'VVLLCWNYJU':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'GPJQCCUFYH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'OWCFHGKVPB':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZDTAXGFPRF':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'QSAEKELBZF':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'TXKEYYFXPE':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'XJEPLEAUZI':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'DSBUADQBZO':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'YMUIBONOPY':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'YFLBURGYJF':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'CZWHSOLRJS':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'CQDPGDHEVA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'EVMGYBVTME':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'YCLLVDJDPC':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'MWJSVBWARF':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'AKTWQWJXMU':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'HGBIEMZYHZ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'JIXSOXOUMP':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'NHXQYOJWPY':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'FQHPMPIEFY':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'KGVPSOERYT':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'GWWXIEOXZQ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'TWZIVFFWLR':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'ESIHSDXQVO':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'LXNKGCWVDI':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'QYOHOTJSEN':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'AWBDLKZHRC':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'AZBXLFMDVT':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_settoreuic","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_settoreuic",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("Gruppi"),"")) {
      status.quoteAndAppend("Gruppi","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Sottoguppi"),"")) {
      status.quoteAndAppend("Sottoguppi","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("ATECO"),"")) {
      status.quoteAndAppend("ATECO","hide","box");
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
  void WriteMainFormScript(armt_settoreuicBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_settoreuic',false);");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('VPSAQWGZDD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QGQGKEQSTH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KUAJNGTYUY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WMKNBZMDVY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BMLJXZOHDR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BMLJXZOHDR_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PIMPFADLTV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PIMPFADLTV_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NFMNJIJKQG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NFMNJIJKQG_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EGVTWLPYYK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EGVTWLPYYK_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PBXUYJXCDV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PBXUYJXCDV_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LKRRMRMXCU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LKRRMRMXCU_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NQYJKRPMAY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NQYJKRPMAY_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XLQJSGTFOG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XLQJSGTFOG_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VVLLCWNYJU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VVLLCWNYJU_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GPJQCCUFYH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GPJQCCUFYH_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OWCFHGKVPB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OWCFHGKVPB_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZDTAXGFPRF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZDTAXGFPRF_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QSAEKELBZF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QSAEKELBZF_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TXKEYYFXPE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TXKEYYFXPE_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XJEPLEAUZI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XJEPLEAUZI_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DSBUADQBZO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DSBUADQBZO_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YMUIBONOPY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YMUIBONOPY_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YFLBURGYJF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YFLBURGYJF_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CZWHSOLRJS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CZWHSOLRJS_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CQDPGDHEVA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CQDPGDHEVA_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EVMGYBVTME')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EVMGYBVTME_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YCLLVDJDPC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YCLLVDJDPC_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MWJSVBWARF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MWJSVBWARF_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AKTWQWJXMU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AKTWQWJXMU_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HGBIEMZYHZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HGBIEMZYHZ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JIXSOXOUMP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JIXSOXOUMP_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NHXQYOJWPY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NHXQYOJWPY_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FQHPMPIEFY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FQHPMPIEFY_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KGVPSOERYT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KGVPSOERYT_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GWWXIEOXZQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GWWXIEOXZQ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TWZIVFFWLR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TWZIVFFWLR_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ESIHSDXQVO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ESIHSDXQVO_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LXNKGCWVDI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LXNKGCWVDI_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QYOHOTJSEN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QYOHOTJSEN_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AWBDLKZHRC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AWBDLKZHRC_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AZBXLFMDVT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AZBXLFMDVT_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YMLTCQOYQA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HRVUSTIUAW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EBJQOWGCVT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YZSORAMVLG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JMLQTMPVIO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SWAVWWKXOJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LVOQGHIOAR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EXYRSFXTUA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NNPAZLOCUA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RZOSZBFTCK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DEJMAVGSRU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EQZKMRBROG')) SetDisabled(c,true);");
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
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('VPSAQWGZDD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LFVVYXTUJL')) SetDisabled(c,true);");
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
  armt_settoreuicBO getBO(ServletStatus status) {
    armt_settoreuicBO BO = new armt_settoreuicBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_settoreuicBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("tbsetsin",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_settoreuicBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_settoreuicBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
  }
  CPResultSet QueryKeyCursor(armt_settoreuicBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_tbsetsin;
    String l_cPhName = BO.m_cPhName_tbsetsin;
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
      String l_cQueryFilter = armt_settoreuicBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_tbsetsin+".SETSINT, "+BO.m_cVirtName_tbsetsin+".IDSETSIN",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("tbsetsin");
    String l_cPhName = CPSql.ManipulateTablePhName("tbsetsin",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".SETSINT, "+l_cPhName+".IDSETSIN",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,armt_settoreuicBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_settoreuicBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_tbsetsin,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_tbsetsin,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_settoreuicBO BO) {
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
  void Edit(ServletStatus status,armt_settoreuicBO BO,SPParameterSource source) {
    BO.Load(status.w_SETSINT,status.w_IDSETSIN);
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
  void New(ServletStatus status,armt_settoreuicBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_settoreuicBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_settoreuicBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_SETSINT = "";
        status.w_IDSETSIN = 0;
      } else {
        BO.w_SETSINT = l_rsKeys.GetString("SETSINT");
        BO.w_IDSETSIN = l_rsKeys.GetDouble("IDSETSIN");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_SETSINT = BO.w_SETSINT;
        status.w_IDSETSIN = BO.w_IDSETSIN;
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
  void EditLoad(ServletStatus status,armt_settoreuicBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_settoreuicBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_SETSINT,status.w_IDSETSIN);
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
  void DeleteMessage(ServletStatus status,armt_settoreuicBO BO,SPParameterSource source) {
    BO.Load(status.w_SETSINT,status.w_IDSETSIN);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_settoreuicBO BO) {
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({SETSINT:"+SPLib.ToJSValue(BO.w_SETSINT,"C",3,0)+",IDSETSIN:"+SPLib.ToJSValue(BO.w_IDSETSIN,"N",5,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
  void Discard(ServletStatus status,armt_settoreuicBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_settoreuicBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",446);
    item.put("w",805);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","true");
    org.json.JSONObject pageProp = null;
    org.json.JSONArray pagesProp = null;
    pagesProp = new org.json.JSONArray();
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Dati\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Sottogruppi\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"ATECO\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Dati,Sottogruppi,ATECO");
    item.put("altInterfaceFor","armt_settoreuic");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"comment\":\"Codice\",\"h\":20,\"maxlength\":3,\"name\":\"SETSINT\",\"page\":1,\"spuid\":\"VPSAQWGZDD\",\"tabindex\":1,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":88,\"y\":14,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UQGAHSYHAV\",\"page\":1,\"spuid\":\"UQGAHSYHAV\",\"tabindex\":2,\"type\":\"Label\",\"value\":\"Codice:\",\"w\":42,\"x\":40,\"y\":18,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Descrizione\",\"h\":20,\"maxlength\":200,\"name\":\"DESCRI\",\"page\":1,\"spuid\":\"QGQGKEQSTH\",\"tabindex\":3,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":568,\"x\":88,\"y\":42,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PTOPEVANKG\",\"page\":1,\"spuid\":\"PTOPEVANKG\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"Descrizione:\",\"w\":68,\"x\":16,\"y\":46,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Identificativo\",\"disabled\":\"true\",\"h\":20,\"maxlength\":6,\"name\":\"IDSETSIN\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"LFVVYXTUJL\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":48,\"x\":608,\"y\":14,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TTXFJGCAKL\",\"page\":1,\"spuid\":\"TTXFJGCAKL\",\"tabindex\":22,\"type\":\"Label\",\"value\":\"Identificativo:\",\"w\":73,\"x\":535,\"y\":18,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Inizio Validit\\u00E0\",\"h\":20,\"maxlength\":10,\"name\":\"DATAINI\",\"page\":1,\"spuid\":\"KUAJNGTYUY\",\"tabindex\":17,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":88,\"y\":70,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ETEULTPDNQ\",\"page\":1,\"spuid\":\"ETEULTPDNQ\",\"tabindex\":18,\"type\":\"Label\",\"value\":\"Inizio Validit\\u00E0:\",\"w\":72,\"x\":16,\"y\":74,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Fine Validit\\u00E0\",\"h\":20,\"maxlength\":10,\"name\":\"DATAFINE\",\"page\":1,\"spuid\":\"WMKNBZMDVY\",\"tabindex\":19,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":272,\"y\":70,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YRJEQBTMDY\",\"page\":1,\"spuid\":\"YRJEQBTMDY\",\"tabindex\":20,\"type\":\"Label\",\"value\":\"Fine Validit\\u00E0:\",\"w\":72,\"x\":200,\"y\":74,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Gruppi\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Gruppi\",\"h\":343,\"name\":\"Gruppi\",\"page\":1,\"shrinkable\":true,\"spuid\":\"FUBVXBVEKS\",\"stretch\":true,\"tabindex\":23,\"title_caption\":\"Gruppi\",\"titled\":true,\"type\":\"Box\",\"w\":784,\"x\":8,\"y\":98,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Da Gruppo\",\"h\":20,\"maxlength\":3,\"name\":\"DAGRU1\",\"page\":1,\"picker\":true,\"spuid\":\"BMLJXZOHDR\",\"tabindex\":24,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":88,\"y\":105,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NVQZSQQSZV\",\"page\":1,\"spuid\":\"NVQZSQQSZV\",\"tabindex\":26,\"type\":\"Label\",\"value\":\"Gruppo 1:\",\"w\":54,\"x\":32,\"y\":109,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_MGXPNAALHJ\",\"page\":1,\"spuid\":\"MGXPNAALHJ\",\"tabindex\":39,\"type\":\"Label\",\"w\":480,\"x\":144,\"y\":109,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A Gruppo\",\"h\":20,\"maxlength\":3,\"name\":\"AGRU1\",\"page\":1,\"picker\":true,\"spuid\":\"PIMPFADLTV\",\"tabindex\":25,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":88,\"y\":132,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_WBPEHNHOQV\",\"page\":1,\"spuid\":\"WBPEHNHOQV\",\"tabindex\":40,\"type\":\"Label\",\"w\":480,\"x\":144,\"y\":136,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Da Gruppo\",\"h\":20,\"maxlength\":3,\"name\":\"DAGRU2\",\"page\":1,\"picker\":true,\"spuid\":\"NFMNJIJKQG\",\"tabindex\":27,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":88,\"y\":161,\"zone\":\"pag1_4_3\",\"zonepath\":\"[1,4,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NVAQUXTUOQ\",\"page\":1,\"spuid\":\"NVAQUXTUOQ\",\"tabindex\":28,\"type\":\"Label\",\"value\":\"Gruppo 2:\",\"w\":54,\"x\":32,\"y\":165,\"zone\":\"pag1_4_3\",\"zonepath\":\"[1,4,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_PRHOSSIUHM\",\"page\":1,\"spuid\":\"PRHOSSIUHM\",\"tabindex\":41,\"type\":\"Label\",\"w\":480,\"x\":144,\"y\":165,\"zone\":\"pag1_4_3\",\"zonepath\":\"[1,4,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A Gruppo\",\"h\":20,\"maxlength\":3,\"name\":\"AGRU2\",\"page\":1,\"picker\":true,\"spuid\":\"EGVTWLPYYK\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":88,\"y\":188,\"zone\":\"pag1_4_4\",\"zonepath\":\"[1,4,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_EBMXLDUAAV\",\"page\":1,\"spuid\":\"EBMXLDUAAV\",\"tabindex\":42,\"type\":\"Label\",\"w\":480,\"x\":144,\"y\":192,\"zone\":\"pag1_4_4\",\"zonepath\":\"[1,4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Da Gruppo\",\"h\":20,\"maxlength\":3,\"name\":\"DAGRU3\",\"page\":1,\"picker\":true,\"spuid\":\"PBXUYJXCDV\",\"tabindex\":30,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":88,\"y\":217,\"zone\":\"pag1_4_5\",\"zonepath\":\"[1,4,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QXYWEFGWVD\",\"page\":1,\"spuid\":\"QXYWEFGWVD\",\"tabindex\":31,\"type\":\"Label\",\"value\":\"Gruppo 3:\",\"w\":54,\"x\":32,\"y\":221,\"zone\":\"pag1_4_5\",\"zonepath\":\"[1,4,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_ZQXAACQTIK\",\"page\":1,\"spuid\":\"ZQXAACQTIK\",\"tabindex\":43,\"type\":\"Label\",\"w\":480,\"x\":144,\"y\":221,\"zone\":\"pag1_4_5\",\"zonepath\":\"[1,4,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A Gruppo\",\"h\":20,\"maxlength\":3,\"name\":\"AGRU3\",\"page\":1,\"picker\":true,\"spuid\":\"LKRRMRMXCU\",\"tabindex\":32,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":88,\"y\":244,\"zone\":\"pag1_4_6\",\"zonepath\":\"[1,4,6]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_EXZFMYCRTN\",\"page\":1,\"spuid\":\"EXZFMYCRTN\",\"tabindex\":44,\"type\":\"Label\",\"w\":480,\"x\":144,\"y\":248,\"zone\":\"pag1_4_6\",\"zonepath\":\"[1,4,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Da Gruppo\",\"h\":20,\"maxlength\":3,\"name\":\"DAGRU4\",\"page\":1,\"picker\":true,\"spuid\":\"NQYJKRPMAY\",\"tabindex\":33,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":88,\"y\":273,\"zone\":\"pag1_4_7\",\"zonepath\":\"[1,4,7]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TWMGRVZHSM\",\"page\":1,\"spuid\":\"TWMGRVZHSM\",\"tabindex\":34,\"type\":\"Label\",\"value\":\"Gruppo 4:\",\"w\":54,\"x\":32,\"y\":277,\"zone\":\"pag1_4_7\",\"zonepath\":\"[1,4,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_XRCWONBWTI\",\"page\":1,\"spuid\":\"XRCWONBWTI\",\"tabindex\":45,\"type\":\"Label\",\"w\":480,\"x\":144,\"y\":277,\"zone\":\"pag1_4_7\",\"zonepath\":\"[1,4,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A Gruppo\",\"h\":20,\"maxlength\":3,\"name\":\"AGRU4\",\"page\":1,\"picker\":true,\"spuid\":\"XLQJSGTFOG\",\"tabindex\":35,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":88,\"y\":300,\"zone\":\"pag1_4_8\",\"zonepath\":\"[1,4,8]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_IHBJYFVAEL\",\"page\":1,\"spuid\":\"IHBJYFVAEL\",\"tabindex\":46,\"type\":\"Label\",\"w\":480,\"x\":144,\"y\":304,\"zone\":\"pag1_4_8\",\"zonepath\":\"[1,4,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Da Gruppo\",\"h\":20,\"maxlength\":3,\"name\":\"DAGRU5\",\"page\":1,\"picker\":true,\"spuid\":\"VVLLCWNYJU\",\"tabindex\":36,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":88,\"y\":329,\"zone\":\"pag1_4_9\",\"zonepath\":\"[1,4,9]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JUGSXZDYLQ\",\"page\":1,\"spuid\":\"JUGSXZDYLQ\",\"tabindex\":37,\"type\":\"Label\",\"value\":\"Gruppo 5:\",\"w\":54,\"x\":32,\"y\":333,\"zone\":\"pag1_4_9\",\"zonepath\":\"[1,4,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_NSKPJFIAVB\",\"page\":1,\"spuid\":\"NSKPJFIAVB\",\"tabindex\":47,\"type\":\"Label\",\"w\":480,\"x\":144,\"y\":333,\"zone\":\"pag1_4_9\",\"zonepath\":\"[1,4,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A Gruppo\",\"h\":20,\"maxlength\":3,\"name\":\"AGRU5\",\"page\":1,\"picker\":true,\"spuid\":\"GPJQCCUFYH\",\"tabindex\":38,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":88,\"y\":356,\"zone\":\"pag1_4_10\",\"zonepath\":\"[1,4,10]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_BCSNIJGHNX\",\"page\":1,\"spuid\":\"BCSNIJGHNX\",\"tabindex\":48,\"type\":\"Label\",\"w\":480,\"x\":144,\"y\":360,\"zone\":\"pag1_4_10\",\"zonepath\":\"[1,4,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Da Gruppo\",\"h\":20,\"maxlength\":3,\"name\":\"DAGRU6\",\"page\":1,\"picker\":true,\"spuid\":\"OWCFHGKVPB\",\"tabindex\":49,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":88,\"y\":385,\"zone\":\"pag1_4_11\",\"zonepath\":\"[1,4,11]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PJBYBHDPKO\",\"page\":1,\"spuid\":\"PJBYBHDPKO\",\"tabindex\":50,\"type\":\"Label\",\"value\":\"Gruppo 6:\",\"w\":54,\"x\":32,\"y\":389,\"zone\":\"pag1_4_11\",\"zonepath\":\"[1,4,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_ZFTIDKFQJV\",\"page\":1,\"spuid\":\"ZFTIDKFQJV\",\"tabindex\":52,\"type\":\"Label\",\"w\":480,\"x\":144,\"y\":389,\"zone\":\"pag1_4_11\",\"zonepath\":\"[1,4,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A Gruppo\",\"h\":20,\"maxlength\":3,\"name\":\"AGRU6\",\"page\":1,\"picker\":true,\"spuid\":\"ZDTAXGFPRF\",\"tabindex\":51,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":88,\"y\":412,\"zone\":\"pag1_4_12\",\"zonepath\":\"[1,4,12]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_CFVGDNSPYZ\",\"page\":1,\"spuid\":\"CFVGDNSPYZ\",\"tabindex\":53,\"type\":\"Label\",\"w\":480,\"x\":144,\"y\":416,\"zone\":\"pag1_4_12\",\"zonepath\":\"[1,4,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Sottoguppi\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Sottogruppi\",\"h\":665,\"name\":\"Sottoguppi\",\"page\":2,\"shrinkable\":true,\"spuid\":\"FMCUBWIEAJ\",\"stretch\":true,\"tabindex\":85,\"title_caption\":\"Sottogruppi\",\"titled\":true,\"type\":\"Box\",\"w\":792,\"x\":8,\"y\":7,\"zone\":\"pag2_1\",\"zonepath\":\"[2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Da Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"DASOT1\",\"page\":2,\"picker\":true,\"spuid\":\"QSAEKELBZF\",\"tabindex\":2,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":21,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NGXDDALQHH\",\"page\":2,\"spuid\":\"NGXDDALQHH\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Sottogruppo 1:\",\"w\":80,\"x\":27,\"y\":21,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_WLDTLNLASC\",\"page\":2,\"spuid\":\"WLDTLNLASC\",\"tabindex\":10,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":23,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_BWFPLETCTY\",\"page\":2,\"spuid\":\"BWFPLETCTY\",\"tabindex\":1,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":50,\"zone\":\"pag2_1_2\",\"zonepath\":\"[2,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"ASOT1\",\"page\":2,\"picker\":true,\"spuid\":\"TXKEYYFXPE\",\"tabindex\":4,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":48,\"zone\":\"pag2_1_2\",\"zonepath\":\"[2,1,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MCKVKEXCXT\",\"page\":2,\"spuid\":\"MCKVKEXCXT\",\"tabindex\":5,\"type\":\"Label\",\"value\":\"Sottogruppo 2:\",\"w\":80,\"x\":27,\"y\":75,\"zone\":\"pag2_1_3\",\"zonepath\":\"[2,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_ZNNARXJXPF\",\"page\":2,\"spuid\":\"ZNNARXJXPF\",\"tabindex\":11,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":77,\"zone\":\"pag2_1_3\",\"zonepath\":\"[2,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Da Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"DASOT2\",\"page\":2,\"picker\":true,\"spuid\":\"XJEPLEAUZI\",\"tabindex\":21,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":75,\"zone\":\"pag2_1_3\",\"zonepath\":\"[2,1,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_BKKYKCIQNX\",\"page\":2,\"spuid\":\"BKKYKCIQNX\",\"tabindex\":12,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":104,\"zone\":\"pag2_1_4\",\"zonepath\":\"[2,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"ASOT2\",\"page\":2,\"picker\":true,\"spuid\":\"DSBUADQBZO\",\"tabindex\":22,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":102,\"zone\":\"pag2_1_4\",\"zonepath\":\"[2,1,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EEQXWIOXVQ\",\"page\":2,\"spuid\":\"EEQXWIOXVQ\",\"tabindex\":6,\"type\":\"Label\",\"value\":\"Sottogruppo 3:\",\"w\":80,\"x\":27,\"y\":129,\"zone\":\"pag2_1_5\",\"zonepath\":\"[2,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_QHIIUHZDDH\",\"page\":2,\"spuid\":\"QHIIUHZDDH\",\"tabindex\":13,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":131,\"zone\":\"pag2_1_5\",\"zonepath\":\"[2,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Da Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"DASOT3\",\"page\":2,\"picker\":true,\"spuid\":\"YMUIBONOPY\",\"tabindex\":23,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":129,\"zone\":\"pag2_1_5\",\"zonepath\":\"[2,1,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_VYXPGYHNZD\",\"page\":2,\"spuid\":\"VYXPGYHNZD\",\"tabindex\":14,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":158,\"zone\":\"pag2_1_6\",\"zonepath\":\"[2,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"ASOT3\",\"page\":2,\"picker\":true,\"spuid\":\"YFLBURGYJF\",\"tabindex\":24,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":156,\"zone\":\"pag2_1_6\",\"zonepath\":\"[2,1,6]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NOQPGQPAGI\",\"page\":2,\"spuid\":\"NOQPGQPAGI\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"Sottogruppo 4:\",\"w\":80,\"x\":27,\"y\":183,\"zone\":\"pag2_1_7\",\"zonepath\":\"[2,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_SDIPAGTESQ\",\"page\":2,\"spuid\":\"SDIPAGTESQ\",\"tabindex\":15,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":185,\"zone\":\"pag2_1_7\",\"zonepath\":\"[2,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Da Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"DASOT4\",\"page\":2,\"picker\":true,\"spuid\":\"CZWHSOLRJS\",\"tabindex\":25,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":183,\"zone\":\"pag2_1_7\",\"zonepath\":\"[2,1,7]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_EIUHGMIIHE\",\"page\":2,\"spuid\":\"EIUHGMIIHE\",\"tabindex\":16,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":212,\"zone\":\"pag2_1_8\",\"zonepath\":\"[2,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"ASOT4\",\"page\":2,\"picker\":true,\"spuid\":\"CQDPGDHEVA\",\"tabindex\":26,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":210,\"zone\":\"pag2_1_8\",\"zonepath\":\"[2,1,8]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WTDEHIPEIM\",\"page\":2,\"spuid\":\"WTDEHIPEIM\",\"tabindex\":8,\"type\":\"Label\",\"value\":\"Sottogruppo 5:\",\"w\":80,\"x\":27,\"y\":237,\"zone\":\"pag2_1_9\",\"zonepath\":\"[2,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_YOEHCOWQGR\",\"page\":2,\"spuid\":\"YOEHCOWQGR\",\"tabindex\":17,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":239,\"zone\":\"pag2_1_9\",\"zonepath\":\"[2,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Da Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"DASOT5\",\"page\":2,\"picker\":true,\"spuid\":\"EVMGYBVTME\",\"tabindex\":27,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":237,\"zone\":\"pag2_1_9\",\"zonepath\":\"[2,1,9]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_FULBKWIDLQ\",\"page\":2,\"spuid\":\"FULBKWIDLQ\",\"tabindex\":18,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":266,\"zone\":\"pag2_1_10\",\"zonepath\":\"[2,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"ASOT5\",\"page\":2,\"picker\":true,\"spuid\":\"YCLLVDJDPC\",\"tabindex\":28,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":264,\"zone\":\"pag2_1_10\",\"zonepath\":\"[2,1,10]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EKQDVFAYDN\",\"page\":2,\"spuid\":\"EKQDVFAYDN\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"Sottogruppo 6:\",\"w\":80,\"x\":27,\"y\":293,\"zone\":\"pag2_1_11\",\"zonepath\":\"[2,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_BKLOUOBBBX\",\"page\":2,\"spuid\":\"BKLOUOBBBX\",\"tabindex\":19,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":293,\"zone\":\"pag2_1_11\",\"zonepath\":\"[2,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Da Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"DASOT6\",\"page\":2,\"picker\":true,\"spuid\":\"MWJSVBWARF\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":291,\"zone\":\"pag2_1_11\",\"zonepath\":\"[2,1,11]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_EHBQRWJKNQ\",\"page\":2,\"spuid\":\"EHBQRWJKNQ\",\"tabindex\":20,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":320,\"zone\":\"pag2_1_12\",\"zonepath\":\"[2,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"ASOT6\",\"page\":2,\"picker\":true,\"spuid\":\"AKTWQWJXMU\",\"tabindex\":30,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":318,\"zone\":\"pag2_1_12\",\"zonepath\":\"[2,1,12]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NQNYXGPYAE\",\"page\":2,\"spuid\":\"NQNYXGPYAE\",\"tabindex\":31,\"type\":\"Label\",\"value\":\"Sottogruppo 7:\",\"w\":80,\"x\":27,\"y\":342,\"zone\":\"pag2_1_13\",\"zonepath\":\"[2,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_MCMPGBSWUA\",\"page\":2,\"spuid\":\"MCMPGBSWUA\",\"tabindex\":37,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":344,\"zone\":\"pag2_1_13\",\"zonepath\":\"[2,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Da Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"DASOT7\",\"page\":2,\"picker\":true,\"spuid\":\"HGBIEMZYHZ\",\"tabindex\":49,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":342,\"zone\":\"pag2_1_13\",\"zonepath\":\"[2,1,13]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_OBYSSBWXPD\",\"page\":2,\"spuid\":\"OBYSSBWXPD\",\"tabindex\":38,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":371,\"zone\":\"pag2_1_14\",\"zonepath\":\"[2,1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"ASOT7\",\"page\":2,\"picker\":true,\"spuid\":\"JIXSOXOUMP\",\"tabindex\":50,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":369,\"zone\":\"pag2_1_14\",\"zonepath\":\"[2,1,14]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RRMXHWHYFF\",\"page\":2,\"spuid\":\"RRMXHWHYFF\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"Sottogruppo 8:\",\"w\":80,\"x\":27,\"y\":396,\"zone\":\"pag2_1_15\",\"zonepath\":\"[2,1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_LWSOFKTZPY\",\"page\":2,\"spuid\":\"LWSOFKTZPY\",\"tabindex\":39,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":398,\"zone\":\"pag2_1_15\",\"zonepath\":\"[2,1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Da Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"DASOT8\",\"page\":2,\"picker\":true,\"spuid\":\"NHXQYOJWPY\",\"tabindex\":51,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":396,\"zone\":\"pag2_1_15\",\"zonepath\":\"[2,1,15]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_KERSOQEMTS\",\"page\":2,\"spuid\":\"KERSOQEMTS\",\"tabindex\":40,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":425,\"zone\":\"pag2_1_16\",\"zonepath\":\"[2,1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"ASOT8\",\"page\":2,\"picker\":true,\"spuid\":\"FQHPMPIEFY\",\"tabindex\":52,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":423,\"zone\":\"pag2_1_16\",\"zonepath\":\"[2,1,16]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AXUHCEMIZY\",\"page\":2,\"spuid\":\"AXUHCEMIZY\",\"tabindex\":33,\"type\":\"Label\",\"value\":\"Sottogruppo 9:\",\"w\":87,\"x\":20,\"y\":450,\"zone\":\"pag2_1_17\",\"zonepath\":\"[2,1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_DVEXNSNEJY\",\"page\":2,\"spuid\":\"DVEXNSNEJY\",\"tabindex\":41,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":452,\"zone\":\"pag2_1_17\",\"zonepath\":\"[2,1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Da Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"DASOT9\",\"page\":2,\"picker\":true,\"spuid\":\"KGVPSOERYT\",\"tabindex\":53,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":450,\"zone\":\"pag2_1_17\",\"zonepath\":\"[2,1,17]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_BTPYFBLNYP\",\"page\":2,\"spuid\":\"BTPYFBLNYP\",\"tabindex\":42,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":479,\"zone\":\"pag2_1_18\",\"zonepath\":\"[2,1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"ASOT9\",\"page\":2,\"picker\":true,\"spuid\":\"GWWXIEOXZQ\",\"tabindex\":54,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":477,\"zone\":\"pag2_1_18\",\"zonepath\":\"[2,1,18]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ELKBXKOPKK\",\"page\":2,\"spuid\":\"ELKBXKOPKK\",\"tabindex\":34,\"type\":\"Label\",\"value\":\"Sottogruppo 10:\",\"w\":87,\"x\":20,\"y\":504,\"zone\":\"pag2_1_19\",\"zonepath\":\"[2,1,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_AMKLEQXPHC\",\"page\":2,\"spuid\":\"AMKLEQXPHC\",\"tabindex\":43,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":506,\"zone\":\"pag2_1_19\",\"zonepath\":\"[2,1,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Da Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"DASOT10\",\"page\":2,\"picker\":true,\"spuid\":\"TWZIVFFWLR\",\"tabindex\":55,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":504,\"zone\":\"pag2_1_19\",\"zonepath\":\"[2,1,19]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_LYJZUXVZAB\",\"page\":2,\"spuid\":\"LYJZUXVZAB\",\"tabindex\":44,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":533,\"zone\":\"pag2_1_20\",\"zonepath\":\"[2,1,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"ASOT10\",\"page\":2,\"picker\":true,\"spuid\":\"ESIHSDXQVO\",\"tabindex\":56,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":531,\"zone\":\"pag2_1_20\",\"zonepath\":\"[2,1,20]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DZZRAHWFBW\",\"page\":2,\"spuid\":\"DZZRAHWFBW\",\"tabindex\":35,\"type\":\"Label\",\"value\":\"Sottogruppo 11:\",\"w\":87,\"x\":20,\"y\":558,\"zone\":\"pag2_1_21\",\"zonepath\":\"[2,1,21]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_VDRSJXQAOE\",\"page\":2,\"spuid\":\"VDRSJXQAOE\",\"tabindex\":45,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":560,\"zone\":\"pag2_1_21\",\"zonepath\":\"[2,1,21]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Da Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"DASOT11\",\"page\":2,\"picker\":true,\"spuid\":\"LXNKGCWVDI\",\"tabindex\":57,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":558,\"zone\":\"pag2_1_21\",\"zonepath\":\"[2,1,21]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_OYPPDTBNMZ\",\"page\":2,\"spuid\":\"OYPPDTBNMZ\",\"tabindex\":46,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":587,\"zone\":\"pag2_1_22\",\"zonepath\":\"[2,1,22]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"ASOT11\",\"page\":2,\"picker\":true,\"spuid\":\"QYOHOTJSEN\",\"tabindex\":58,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":585,\"zone\":\"pag2_1_22\",\"zonepath\":\"[2,1,22]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WCISLNQJTG\",\"page\":2,\"spuid\":\"WCISLNQJTG\",\"tabindex\":36,\"type\":\"Label\",\"value\":\"Sottogruppo 12:\",\"w\":87,\"x\":20,\"y\":614,\"zone\":\"pag2_1_23\",\"zonepath\":\"[2,1,23]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_ARKLACPVPZ\",\"page\":2,\"spuid\":\"ARKLACPVPZ\",\"tabindex\":47,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":614,\"zone\":\"pag2_1_23\",\"zonepath\":\"[2,1,23]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Da Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"DASOT12\",\"page\":2,\"picker\":true,\"spuid\":\"AWBDLKZHRC\",\"tabindex\":59,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":612,\"zone\":\"pag2_1_23\",\"zonepath\":\"[2,1,23]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":18,\"name\":\"label_PCMSUANJEX\",\"page\":2,\"spuid\":\"PCMSUANJEX\",\"tabindex\":48,\"type\":\"Label\",\"w\":592,\"x\":176,\"y\":641,\"zone\":\"pag2_1_24\",\"zonepath\":\"[2,1,24]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A Sottogruppo\",\"h\":20,\"maxlength\":3,\"name\":\"ASOT12\",\"page\":2,\"picker\":true,\"spuid\":\"AZBXLFMDVT\",\"tabindex\":60,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":112,\"y\":639,\"zone\":\"pag2_1_24\",\"zonepath\":\"[2,1,24]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"ATECO\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"ATECO\",\"h\":105,\"name\":\"ATECO\",\"page\":3,\"shrinkable\":true,\"spuid\":\"CLVYAMUSKV\",\"stretch\":true,\"tabindex\":31,\"title_caption\":\"ATECO\",\"titled\":true,\"type\":\"Box\",\"w\":784,\"x\":8,\"y\":7,\"zone\":\"pag3_1\",\"zonepath\":\"[3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Da\",\"h\":20,\"maxlength\":3,\"name\":\"DAATE2\",\"page\":3,\"spuid\":\"YMLTCQOYQA\",\"tabindex\":1,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":152,\"y\":49,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BHMIAQIZVT\",\"page\":3,\"spuid\":\"BHMIAQIZVT\",\"tabindex\":2,\"type\":\"Label\",\"value\":\"ATECO 2:\",\"w\":80,\"x\":40,\"y\":53,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"A\",\"h\":20,\"maxlength\":3,\"name\":\"AATE2\",\"page\":3,\"spuid\":\"HRVUSTIUAW\",\"tabindex\":3,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":240,\"y\":49,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KCJJVUMXVW\",\"page\":3,\"spuid\":\"KCJJVUMXVW\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"Da:\",\"w\":18,\"x\":134,\"y\":53,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LZUFLWWWSO\",\"page\":3,\"spuid\":\"LZUFLWWWSO\",\"tabindex\":5,\"type\":\"Label\",\"value\":\"A:\",\"w\":12,\"x\":228,\"y\":53,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Da\",\"h\":20,\"maxlength\":3,\"name\":\"DAATE1\",\"page\":3,\"spuid\":\"DEJMAVGSRU\",\"tabindex\":26,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":152,\"y\":21,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QTFUGONGPK\",\"page\":3,\"spuid\":\"QTFUGONGPK\",\"tabindex\":27,\"type\":\"Label\",\"value\":\"ATECO 1:\",\"w\":80,\"x\":40,\"y\":25,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"A\",\"h\":20,\"maxlength\":3,\"name\":\"AATE1\",\"page\":3,\"spuid\":\"EQZKMRBROG\",\"tabindex\":28,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":240,\"y\":21,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PYCGMACPZJ\",\"page\":3,\"spuid\":\"PYCGMACPZJ\",\"tabindex\":29,\"type\":\"Label\",\"value\":\"Da:\",\"w\":18,\"x\":134,\"y\":25,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DMPTGSIVUT\",\"page\":3,\"spuid\":\"DMPTGSIVUT\",\"tabindex\":30,\"type\":\"Label\",\"value\":\"A:\",\"w\":12,\"x\":228,\"y\":25,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Da\",\"h\":20,\"maxlength\":3,\"name\":\"DAATE3\",\"page\":3,\"spuid\":\"EBJQOWGCVT\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":152,\"y\":77,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VCTBSSMPCC\",\"page\":3,\"spuid\":\"VCTBSSMPCC\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"ATECO 3:\",\"w\":80,\"x\":40,\"y\":81,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"A\",\"h\":20,\"maxlength\":3,\"name\":\"AATE3\",\"page\":3,\"spuid\":\"YZSORAMVLG\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":240,\"y\":77,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DJFUXJVEGF\",\"page\":3,\"spuid\":\"DJFUXJVEGF\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"Da:\",\"w\":18,\"x\":134,\"y\":81,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BXBEUHTNEG\",\"page\":3,\"spuid\":\"BXBEUHTNEG\",\"tabindex\":10,\"type\":\"Label\",\"value\":\"A:\",\"w\":12,\"x\":228,\"y\":81,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Da\",\"h\":20,\"maxlength\":3,\"name\":\"DAATE4\",\"page\":3,\"spuid\":\"JMLQTMPVIO\",\"tabindex\":11,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":536,\"y\":21,\"zone\":\"pag3_1_3\",\"zonepath\":\"[3,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BXFBVBUSTR\",\"page\":3,\"spuid\":\"BXFBVBUSTR\",\"tabindex\":12,\"type\":\"Label\",\"value\":\"ATECO 4:\",\"w\":80,\"x\":424,\"y\":25,\"zone\":\"pag3_1_3\",\"zonepath\":\"[3,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"A\",\"h\":20,\"maxlength\":3,\"name\":\"AATE4\",\"page\":3,\"spuid\":\"SWAVWWKXOJ\",\"tabindex\":13,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":624,\"y\":21,\"zone\":\"pag3_1_3\",\"zonepath\":\"[3,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VTUFQRDPVL\",\"page\":3,\"spuid\":\"VTUFQRDPVL\",\"tabindex\":14,\"type\":\"Label\",\"value\":\"Da:\",\"w\":18,\"x\":518,\"y\":25,\"zone\":\"pag3_1_3\",\"zonepath\":\"[3,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WZQHGTSVJY\",\"page\":3,\"spuid\":\"WZQHGTSVJY\",\"tabindex\":15,\"type\":\"Label\",\"value\":\"A:\",\"w\":12,\"x\":612,\"y\":25,\"zone\":\"pag3_1_3\",\"zonepath\":\"[3,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Da\",\"h\":20,\"maxlength\":3,\"name\":\"DAATE5\",\"page\":3,\"spuid\":\"LVOQGHIOAR\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":536,\"y\":49,\"zone\":\"pag3_1_4\",\"zonepath\":\"[3,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YRVSDNHGGP\",\"page\":3,\"spuid\":\"YRVSDNHGGP\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"ATECO 5:\",\"w\":80,\"x\":424,\"y\":53,\"zone\":\"pag3_1_4\",\"zonepath\":\"[3,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"A\",\"h\":20,\"maxlength\":3,\"name\":\"AATE5\",\"page\":3,\"spuid\":\"EXYRSFXTUA\",\"tabindex\":18,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":624,\"y\":49,\"zone\":\"pag3_1_4\",\"zonepath\":\"[3,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YUSGVTXWLX\",\"page\":3,\"spuid\":\"YUSGVTXWLX\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"Da:\",\"w\":18,\"x\":518,\"y\":53,\"zone\":\"pag3_1_4\",\"zonepath\":\"[3,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZKHOVLRLTQ\",\"page\":3,\"spuid\":\"ZKHOVLRLTQ\",\"tabindex\":20,\"type\":\"Label\",\"value\":\"A:\",\"w\":12,\"x\":612,\"y\":53,\"zone\":\"pag3_1_4\",\"zonepath\":\"[3,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Da\",\"h\":20,\"maxlength\":3,\"name\":\"DAATE6\",\"page\":3,\"spuid\":\"NNPAZLOCUA\",\"tabindex\":21,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":536,\"y\":77,\"zone\":\"pag3_1_5\",\"zonepath\":\"[3,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DFKUHYRCIV\",\"page\":3,\"spuid\":\"DFKUHYRCIV\",\"tabindex\":22,\"type\":\"Label\",\"value\":\"ATECO 6:\",\"w\":80,\"x\":424,\"y\":81,\"zone\":\"pag3_1_5\",\"zonepath\":\"[3,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"A\",\"h\":20,\"maxlength\":3,\"name\":\"AATE6\",\"page\":3,\"spuid\":\"RZOSZBFTCK\",\"tabindex\":23,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":624,\"y\":77,\"zone\":\"pag3_1_5\",\"zonepath\":\"[3,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BKYRTIAYOP\",\"page\":3,\"spuid\":\"BKYRTIAYOP\",\"tabindex\":24,\"type\":\"Label\",\"value\":\"Da:\",\"w\":18,\"x\":518,\"y\":81,\"zone\":\"pag3_1_5\",\"zonepath\":\"[3,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZRALREELCM\",\"page\":3,\"spuid\":\"ZRALREELCM\",\"tabindex\":25,\"type\":\"Label\",\"value\":\"A:\",\"w\":12,\"x\":612,\"y\":81,\"zone\":\"pag3_1_5\",\"zonepath\":\"[3,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_settoreuicBO BO,ServletStatus status) {
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
     "<script src='armt_settoreuic?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_settoreuic_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_settoreuic_edit.js'>" +
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
      status.out.println("w_SETSINT=a[0];");
      status.out.println("w_DESCRI=a[1];");
      status.out.println("w_DASOT1=a[2];");
      status.out.println("w_ASOT1=a[3];");
      status.out.println("w_DASOT2=a[4];");
      status.out.println("w_ASOT2=a[5];");
      status.out.println("w_DASOT3=a[6];");
      status.out.println("w_ASOT3=a[7];");
      status.out.println("w_DASOT4=a[8];");
      status.out.println("w_ASOT4=a[9];");
      status.out.println("w_DASOT5=a[10];");
      status.out.println("w_ASOT5=a[11];");
      status.out.println("w_DASOT6=a[12];");
      status.out.println("w_ASOT6=a[13];");
      status.out.println("w_DASOT7=a[14];");
      status.out.println("w_ASOT7=a[15];");
      status.out.println("w_DASOT8=a[16];");
      status.out.println("w_ASOT8=a[17];");
      status.out.println("w_DASOT9=a[18];");
      status.out.println("w_ASOT9=a[19];");
      status.out.println("w_DASOT10=a[20];");
      status.out.println("w_ASOT10=a[21];");
      status.out.println("w_DASOT11=a[22];");
      status.out.println("w_ASOT11=a[23];");
      status.out.println("w_DASOT12=a[24];");
      status.out.println("w_ASOT12=a[25];");
      status.out.println("w_DATAINI=a[26];");
      status.out.println("w_DATAFINE=a[27];");
      status.out.println("w_IDSETSIN=a[28];");
      status.out.println("w_DAGRU1=a[29];");
      status.out.println("w_AGRU1=a[30];");
      status.out.println("w_DAGRU2=a[31];");
      status.out.println("w_AGRU2=a[32];");
      status.out.println("w_DAGRU3=a[33];");
      status.out.println("w_AGRU3=a[34];");
      status.out.println("w_DAGRU4=a[35];");
      status.out.println("w_AGRU4=a[36];");
      status.out.println("w_DAGRU5=a[37];");
      status.out.println("w_AGRU5=a[38];");
      status.out.println("w_DAGRU6=a[39];");
      status.out.println("w_AGRU6=a[40];");
      status.out.println("w_DAATE2=a[41];");
      status.out.println("w_AATE2=a[42];");
      status.out.println("w_DAATE3=a[43];");
      status.out.println("w_AATE3=a[44];");
      status.out.println("w_DAATE4=a[45];");
      status.out.println("w_AATE4=a[46];");
      status.out.println("w_DAATE5=a[47];");
      status.out.println("w_AATE5=a[48];");
      status.out.println("w_DAATE6=a[49];");
      status.out.println("w_AATE6=a[50];");
      status.out.println("w_DAATE1=a[51];");
      status.out.println("w_AATE1=a[52];");
      status.out.println("w_descg1=a[53];");
      status.out.println("w_descg2=a[54];");
      status.out.println("w_descg3=a[55];");
      status.out.println("w_descg4=a[56];");
      status.out.println("w_descg5=a[57];");
      status.out.println("w_descg6=a[58];");
      status.out.println("w_descg7=a[59];");
      status.out.println("w_descg8=a[60];");
      status.out.println("w_descg9=a[61];");
      status.out.println("w_descg10=a[62];");
      status.out.println("w_descsg1=a[63];");
      status.out.println("w_descsg2=a[64];");
      status.out.println("w_descsg3=a[65];");
      status.out.println("w_descsg4=a[66];");
      status.out.println("w_descsg5=a[67];");
      status.out.println("w_descsg6=a[68];");
      status.out.println("w_descsg7=a[69];");
      status.out.println("w_descsg8=a[70];");
      status.out.println("w_descsg9=a[71];");
      status.out.println("w_descsg10=a[72];");
      status.out.println("w_descsg11=a[73];");
      status.out.println("w_descsg12=a[74];");
      status.out.println("w_descg11=a[75];");
      status.out.println("w_descg12=a[76];");
      status.out.println("w_descsg13=a[77];");
      status.out.println("w_descsg14=a[78];");
      status.out.println("w_descsg15=a[79];");
      status.out.println("w_descsg16=a[80];");
      status.out.println("w_descsg17=a[81];");
      status.out.println("w_descsg18=a[82];");
      status.out.println("w_descsg19=a[83];");
      status.out.println("w_descsg20=a[84];");
      status.out.println("w_descsg21=a[85];");
      status.out.println("w_descsg22=a[86];");
      status.out.println("w_descsg23=a[87];");
      status.out.println("w_descsg24=a[88];");
      status.out.println("m_PrimaryKeys=['IDSETSIN','SETSINT'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_settoreuic_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(466,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","tbsetsin");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","SETSINT,IDSETSIN");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(armt_settoreuicBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({SETSINT:"+SPLib.ToJSValue(BO.w_SETSINT,"C",3,0)+",IDSETSIN:"+SPLib.ToJSValue(BO.w_IDSETSIN,"N",5,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_settoreuicBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({SETSINT:"+SPLib.ToJSValue(BO.w_SETSINT,"C",3,0)+",IDSETSIN:"+SPLib.ToJSValue(BO.w_IDSETSIN,"N",5,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armt_settoreuicBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({SETSINT:"+SPLib.ToJSValue(BO.w_SETSINT,"C",3,0)+",IDSETSIN:"+SPLib.ToJSValue(BO.w_IDSETSIN,"N",5,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armt_settoreuicBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({SETSINT:"+SPLib.ToJSValue(BO.w_SETSINT,"C",3,0)+",IDSETSIN:"+SPLib.ToJSValue(BO.w_IDSETSIN,"N",5,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armt_settoreuicBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({SETSINT:"+SPLib.ToJSValue(BO.w_SETSINT,"C",3,0)+",IDSETSIN:"+SPLib.ToJSValue(BO.w_IDSETSIN,"N",5,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_settoreuicBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_settoreuicBO BO,ServletStatus status) throws IOException {
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
  public String GetCheckVars(ServletStatus status,armt_settoreuicBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_SETSINT),"C",3,0));
        hCreator.AddValue(CPLib.ToSQL(BO.w_IDSETSIN,"N",5,0));
      }
    } else if (CPLib.eq(p_cUID,"BMLJXZOHDR")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"PIMPFADLTV")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NFMNJIJKQG")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"EGVTWLPYYK")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"PBXUYJXCDV")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"LKRRMRMXCU")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NQYJKRPMAY")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"XLQJSGTFOG")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"VVLLCWNYJU")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"GPJQCCUFYH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"OWCFHGKVPB")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ZDTAXGFPRF")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"QSAEKELBZF")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"TXKEYYFXPE")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"XJEPLEAUZI")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"DSBUADQBZO")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"YMUIBONOPY")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"YFLBURGYJF")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"CZWHSOLRJS")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"CQDPGDHEVA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"EVMGYBVTME")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"YCLLVDJDPC")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"MWJSVBWARF")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"AKTWQWJXMU")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"HGBIEMZYHZ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"JIXSOXOUMP")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NHXQYOJWPY")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"FQHPMPIEFY")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"KGVPSOERYT")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"GWWXIEOXZQ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"TWZIVFFWLR")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ESIHSDXQVO")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"LXNKGCWVDI")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"QYOHOTJSEN")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"AWBDLKZHRC")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"AZBXLFMDVT")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_settoreuicBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_DAGRU1))) {
        a = GetCheckVars(status,BO,"BMLJXZOHDR");
        b = status.m_CheckVars.optString("BMLJXZOHDR");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_AGRU1))) {
        a = GetCheckVars(status,BO,"PIMPFADLTV");
        b = status.m_CheckVars.optString("PIMPFADLTV");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DAGRU2))) {
        a = GetCheckVars(status,BO,"NFMNJIJKQG");
        b = status.m_CheckVars.optString("NFMNJIJKQG");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_AGRU2))) {
        a = GetCheckVars(status,BO,"EGVTWLPYYK");
        b = status.m_CheckVars.optString("EGVTWLPYYK");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DAGRU3))) {
        a = GetCheckVars(status,BO,"PBXUYJXCDV");
        b = status.m_CheckVars.optString("PBXUYJXCDV");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_AGRU3))) {
        a = GetCheckVars(status,BO,"LKRRMRMXCU");
        b = status.m_CheckVars.optString("LKRRMRMXCU");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DAGRU4))) {
        a = GetCheckVars(status,BO,"NQYJKRPMAY");
        b = status.m_CheckVars.optString("NQYJKRPMAY");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_AGRU4))) {
        a = GetCheckVars(status,BO,"XLQJSGTFOG");
        b = status.m_CheckVars.optString("XLQJSGTFOG");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DAGRU5))) {
        a = GetCheckVars(status,BO,"VVLLCWNYJU");
        b = status.m_CheckVars.optString("VVLLCWNYJU");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_AGRU5))) {
        a = GetCheckVars(status,BO,"GPJQCCUFYH");
        b = status.m_CheckVars.optString("GPJQCCUFYH");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DAGRU6))) {
        a = GetCheckVars(status,BO,"OWCFHGKVPB");
        b = status.m_CheckVars.optString("OWCFHGKVPB");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_AGRU6))) {
        a = GetCheckVars(status,BO,"ZDTAXGFPRF");
        b = status.m_CheckVars.optString("ZDTAXGFPRF");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DASOT1))) {
        a = GetCheckVars(status,BO,"QSAEKELBZF");
        b = status.m_CheckVars.optString("QSAEKELBZF");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_ASOT1))) {
        a = GetCheckVars(status,BO,"TXKEYYFXPE");
        b = status.m_CheckVars.optString("TXKEYYFXPE");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DASOT2))) {
        a = GetCheckVars(status,BO,"XJEPLEAUZI");
        b = status.m_CheckVars.optString("XJEPLEAUZI");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_ASOT2))) {
        a = GetCheckVars(status,BO,"DSBUADQBZO");
        b = status.m_CheckVars.optString("DSBUADQBZO");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DASOT3))) {
        a = GetCheckVars(status,BO,"YMUIBONOPY");
        b = status.m_CheckVars.optString("YMUIBONOPY");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_ASOT3))) {
        a = GetCheckVars(status,BO,"YFLBURGYJF");
        b = status.m_CheckVars.optString("YFLBURGYJF");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DASOT4))) {
        a = GetCheckVars(status,BO,"CZWHSOLRJS");
        b = status.m_CheckVars.optString("CZWHSOLRJS");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_ASOT4))) {
        a = GetCheckVars(status,BO,"CQDPGDHEVA");
        b = status.m_CheckVars.optString("CQDPGDHEVA");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DASOT5))) {
        a = GetCheckVars(status,BO,"EVMGYBVTME");
        b = status.m_CheckVars.optString("EVMGYBVTME");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_ASOT5))) {
        a = GetCheckVars(status,BO,"YCLLVDJDPC");
        b = status.m_CheckVars.optString("YCLLVDJDPC");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DASOT6))) {
        a = GetCheckVars(status,BO,"MWJSVBWARF");
        b = status.m_CheckVars.optString("MWJSVBWARF");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_ASOT6))) {
        a = GetCheckVars(status,BO,"AKTWQWJXMU");
        b = status.m_CheckVars.optString("AKTWQWJXMU");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DASOT7))) {
        a = GetCheckVars(status,BO,"HGBIEMZYHZ");
        b = status.m_CheckVars.optString("HGBIEMZYHZ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_ASOT7))) {
        a = GetCheckVars(status,BO,"JIXSOXOUMP");
        b = status.m_CheckVars.optString("JIXSOXOUMP");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DASOT8))) {
        a = GetCheckVars(status,BO,"NHXQYOJWPY");
        b = status.m_CheckVars.optString("NHXQYOJWPY");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_ASOT8))) {
        a = GetCheckVars(status,BO,"FQHPMPIEFY");
        b = status.m_CheckVars.optString("FQHPMPIEFY");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DASOT9))) {
        a = GetCheckVars(status,BO,"KGVPSOERYT");
        b = status.m_CheckVars.optString("KGVPSOERYT");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_ASOT9))) {
        a = GetCheckVars(status,BO,"GWWXIEOXZQ");
        b = status.m_CheckVars.optString("GWWXIEOXZQ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DASOT10))) {
        a = GetCheckVars(status,BO,"TWZIVFFWLR");
        b = status.m_CheckVars.optString("TWZIVFFWLR");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_ASOT10))) {
        a = GetCheckVars(status,BO,"ESIHSDXQVO");
        b = status.m_CheckVars.optString("ESIHSDXQVO");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DASOT11))) {
        a = GetCheckVars(status,BO,"LXNKGCWVDI");
        b = status.m_CheckVars.optString("LXNKGCWVDI");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_ASOT11))) {
        a = GetCheckVars(status,BO,"QYOHOTJSEN");
        b = status.m_CheckVars.optString("QYOHOTJSEN");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DASOT12))) {
        a = GetCheckVars(status,BO,"AWBDLKZHRC");
        b = status.m_CheckVars.optString("AWBDLKZHRC");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_ASOT12))) {
        a = GetCheckVars(status,BO,"AZBXLFMDVT");
        b = status.m_CheckVars.optString("AZBXLFMDVT");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
