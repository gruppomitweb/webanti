import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class ardt_ae_delegabo extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*f596cc02*!";
  static public class ServletStatus extends SPDetailChildServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "jelegabo";
    }
    public String w_RAPPORTO;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_RAPPORTO,context,"jelegabo","RAPPORTO","C",25,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
    ardt_ae_delegaboBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_jelegabo;
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
    return "Deleghe su rapporti";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "ardt_ae_delegabo";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 744;
    l_eg.m_nEntityHeight = 274;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"jelegabo","personbo"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page"),new ZoneItem("DatiAna","Dati Anagrafici","horizontal_section"),new ZoneItem("Progressivi","Progressivi","horizontal_section")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"RAPPORTO"};
    l_eg.items = new SPItem[]{
                   new SPItem("RAPPORTO","C",25,0, "show","Rapporto (Copia della testata)"),
                   new SPItem("CODINTER","C",16,0, "edit",""),
                   new SPItem("DESCINTER","C",70,0, "hide",""),
                   new SPItem("descdele","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("DATAINI","D",8,0, "edit","Data Inizio"),
                   new SPItem("TIPORAP","C",1,0, "hide","Tipo Rapporto"),
                   new SPItem("TIPOPERS","C",1,0, "hide","Tipo Persona"),
                   new SPItem("STATOREG","C",1,0, "hide","Stato Registrazione"),
                   new SPItem("OPERAZMOD","C",20,0, "hide",""),
                   new SPItem("DATARETT","D",8,0, "hide","Data Rettifica"),
                   new SPItem("IDEREG","C",20,0, "hide","Identificativo Registrazione"),
                   new SPItem("COLLEGAMEN","C",20,0, "hide","Collegamento"),
                   new SPItem("DATAFINE","D",8,0, "edit","Data Fine"),
                   new SPItem("IDBASE","C",10,0, "hide","IDBASE"),
                   new SPItem("UCODE","C",7,0, "hide",""),
                   new SPItem("tiporegr","N",1,0, "hide",""),
                   new SPItem("DOMICILIO","C",35,0, "hide","Indirizzo"),
                   new SPItem("DESCCIT","C",30,0, "hide","Città"),
                   new SPItem("PROVINCIA","C",2,0, "hide","Provincia"),
                   new SPItem("CAP","C",9,0, "hide","CAP"),
                   new SPItem("NUMPROG1","C",11,0, "show","N° Progressivo"),
                   new SPItem("NUMPROG2","C",11,0, "show","N° Registrazione"),
                   new SPItem("xRagSoc","C",70,0, "show",""),
                   new SPItem("NOAGE","C",1,0, "hide","")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,ardt_ae_delegaboBO BO) {
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
    l_translations=new String[][]{{"10095365423",p_Context.Translate("Provincia")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"10749307127",p_Context.Translate("Deleghe su rapporti")},
    {"11258238247",p_Context.Translate("Stato Registrazione")},
    {"11329559720",p_Context.Translate("Data Rettifica")},
    {"11488180956",p_Context.Translate("Soggetti Registrati")},
    {"11525797640",p_Context.Translate("%ERRORMESSAGE%")},
    {"11661040791",p_Context.Translate("Rapporto (Copia della testata)")},
    {"11781254685",p_Context.Translate("N° Progressivo")},
    {"11976701881",p_Context.Translate("Tipo Persona")},
    {"12141648712",p_Context.Translate("Non inviare all'Agenzia delle Entrate")},
    {"1293597482",p_Context.Translate("Identificativo Registrazione")},
    {"1300662969",p_Context.Translate("Data Fine")},
    {"15186643",p_Context.Translate("Città")},
    {"1698386914",p_Context.Translate("N° Registrazione")},
    {"1723736132",p_Context.Translate("Tipo Rapporto")},
    {"21587",p_Context.Translate("CAP")},
    {"45547614",p_Context.Translate("Data Inizio")},
    {"554236824",p_Context.Translate("Indirizzo")},
    {"78075529",p_Context.Translate("IDBASE")},
    {"937664120",p_Context.Translate("Collegamento")},
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
  void WriteStyles(ardt_ae_delegaboBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../ardt_ae_delegabo.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(ardt_ae_delegaboBO BO,ServletStatus status) {
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
      status.out.println(".CROCGCIGKF {top:0px;position:absolute;left:0px;height:16px;width:110px;background-color:Transparent;z-index:1; }");
      status.out.println(".CROCGCIGKF_ZOOM { position:absolute;top:0px;left:111px;height:17px;width:17px;background-color:Transparent;background-repeat:no-repeat;background-position:center;margin:0;border-width:0;padding:0;z-index:1;}");
      status.out.println(".BJKHVZBXDR {top:0px;position:absolute;left:576px;height:16px;width:72px;text-align:right;background-color:Transparent;z-index:1; }");
      status.out.println(".JCFUNSQXBI {top:0px;position:absolute;left:656px;height:16px;width:60px;text-align:right;background-color:Transparent;z-index:1; }");
      status.out.println(".VICYEWBISV {top:0px;position:absolute;left:141px;height:16px;width:423px;background-color:Transparent;z-index:1; }");
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
      status.out.println("Z.Tabs.Get('tabs').InitSelect('ardt_ae_delegabo',true);");
    }
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"ardt_ae_delegabo",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(ardt_ae_delegaboBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,2);
  }
  void WriteControls_p1(ardt_ae_delegaboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:274px;width:744px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteControls_p1_b1(BO,status);
    WriteControls_p1_b2(BO,status);
    WriteControls_p1_b3(BO,status);
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
  void WriteControls_p1_b0(ardt_ae_delegaboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_1' style='position:relative;height:133px;display:block' page='1'>" +
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
      "");
      status.out.println(
       "<span class='SPLabel' id='RQPAWNXLEF_DIV'>" +
       "<label id='RQPAWNXLEF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Delegato"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MAUGJNUVWH_DIV'>" +
       "<label id='MAUGJNUVWH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Inizio"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DGFLOKNCET_DIV'>" +
       "<label id='DGFLOKNCET'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Fine"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<div id='GridTable_Container' style='position:absolute;top:25px;left:6px;height:106px;width:738px;overflow:hidden' class='GridTable_Container "+SPLib.ToHTML(status.m_cClientMode,"C",0,0)+"'>" +
       "<div id=GridTable_LockedScroll style='position:absolute;top:0px;left:0px;height:106px;width:738px;overflow:scroll'>" +
       "</div>" +
       "</div>" +
      "");
      status.out.println(
       "<div id='GridTable_DIV' style='position:relative;left:0;top:0;width:738px;height:106px;overflow:auto;'>" +
       "<table id='GridTable' style='position:relative;top:0px;left:0px;width:732px' cellspacing='0' cellpadding='0' border='0'>" +
       "<tr>" +
       "<td></td>" +
       "</tr>" +
       "</table>" +
       "</div>" +
      "");
      if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println(
         "<div id='GridTable_ButtonPanel' style='position:absolute;top:0px;left:8px;z-index:4'>" +
         ""+printButtonPanelContent(status,1,"upper_right",false,getDetailMenuItems(),false,"")+"" +
         "</div>" +
        "");
      }
      status.out.println(
       "<div class='GridTable_VerticalLines' style='position:absolute;top:25px;left:142px;height:106px;width:1px'>" +
       "</div>" +
      "");
      status.out.println(
       "<div class='GridTable_VerticalLines' style='position:absolute;top:25px;left:578px;height:106px;width:1px'>" +
       "</div>" +
      "");
      status.out.println(
       "<div class='GridTable_VerticalLines' style='position:absolute;top:25px;left:660px;height:106px;width:1px'>" +
       "</div>" +
      "");
      HTMLRowScript(BO,status);
      status.m_nTabIndex = status.m_nTabIndex+1;
      status.out.println(
       "</div>" +
      "");
    }
  }
  void HTMLRowScript(ardt_ae_delegaboBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder = null;
    status.out.println(
     "<script>" +
    "");
    status.out.println("function HTMLRow(editable,rowtoshow) {");
    status.out.println("var s;");
    status.out.println("s='<div style=\"position:relative;width:716px;height:19px;\"';");
    status.out.println("s=s+'>';");
    status.out.println("var row;");
    status.out.println("var prefix;");
    status.out.println("var w_CODINTER;");
    status.out.println("var w_DESCINTER;");
    status.out.println("var w_DATAINI;");
    status.out.println("var w_TIPORAP;");
    status.out.println("var w_TIPOPERS;");
    status.out.println("var w_STATOREG;");
    status.out.println("var w_OPERAZMOD;");
    status.out.println("var w_DATARETT;");
    status.out.println("var w_IDEREG;");
    status.out.println("var w_COLLEGAMEN;");
    status.out.println("var w_DATAFINE;");
    status.out.println("var w_IDBASE;");
    status.out.println("var w_UCODE;");
    status.out.println("var w_NUMPROG1;");
    status.out.println("var w_NUMPROG2;");
    status.out.println("var w_NOAGE;");
    status.out.println("var w_descdele;");
    status.out.println("var w_tiporegr;");
    status.out.println("var w_DOMICILIO;");
    status.out.println("var w_DESCCIT;");
    status.out.println("var w_PROVINCIA;");
    status.out.println("var w_CAP;");
    status.out.println("var w_xRagSoc;");
    status.out.println("if (Eq(rowtoshow,null)) {");
    status.out.println("row=window;");
    status.out.println("prefix='w_';");
    status.out.println("} else {");
    status.out.println("row=rowtoshow;");
    status.out.println("prefix='';");
    status.out.println("}");
    status.out.println("w_CODINTER=row[prefix+'CODINTER'];");
    status.out.println("w_DESCINTER=row[prefix+'DESCINTER'];");
    status.out.println("w_DATAINI=row[prefix+'DATAINI'];");
    status.out.println("w_TIPORAP=row[prefix+'TIPORAP'];");
    status.out.println("w_TIPOPERS=row[prefix+'TIPOPERS'];");
    status.out.println("w_STATOREG=row[prefix+'STATOREG'];");
    status.out.println("w_OPERAZMOD=row[prefix+'OPERAZMOD'];");
    status.out.println("w_DATARETT=row[prefix+'DATARETT'];");
    status.out.println("w_IDEREG=row[prefix+'IDEREG'];");
    status.out.println("w_COLLEGAMEN=row[prefix+'COLLEGAMEN'];");
    status.out.println("w_DATAFINE=row[prefix+'DATAFINE'];");
    status.out.println("w_IDBASE=row[prefix+'IDBASE'];");
    status.out.println("w_UCODE=row[prefix+'UCODE'];");
    status.out.println("w_NUMPROG1=row[prefix+'NUMPROG1'];");
    status.out.println("w_NUMPROG2=row[prefix+'NUMPROG2'];");
    status.out.println("w_NOAGE=row[prefix+'NOAGE'];");
    status.out.println("w_descdele=row[prefix+'descdele'];");
    status.out.println("w_tiporegr=row[prefix+'tiporegr'];");
    status.out.println("w_DOMICILIO=row[prefix+'DOMICILIO'];");
    status.out.println("w_DESCCIT=row[prefix+'DESCCIT'];");
    status.out.println("w_PROVINCIA=row[prefix+'PROVINCIA'];");
    status.out.println("w_CAP=row[prefix+'CAP'];");
    status.out.println("w_xRagSoc=row[prefix+'xRagSoc'];");
    status.out.println("if (editable) {");
    status.out.println("if (Gt(m_nCurrentRow,0)) {");
    status.out.println("s=s+\""+
     "<input name='BeforeDetailElement' type='text' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
    "\"");
    status.out.println("}");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='CODINTER' id='CROCGCIGKF' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_CODINTER),'C',16,0,'')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='16' size='16' fieldtype='C'>" +
     "<button id='CROCGCIGKF_ZOOM' type='button' class='GridZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='DATAINI' id='BJKHVZBXDR' type='text' class='"+status.ObligatoryClass("Field GridTable_EditRowItem ",BO.BJKHVZBXDR_isObligatory())+"' value='\"+WtH(w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))+\"' tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='10' size='8' fieldtype='D'>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='DATAFINE' id='JCFUNSQXBI' type='text' class='"+status.ObligatoryClass("Field GridTable_EditRowItem ",BO.JCFUNSQXBI_isObligatory())+"' value='\"+WtH(w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))+\"' tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='10' size='8' fieldtype='D'>" +
    "\"");
    status.out.println("s=s+\""+
     "<input name='xRagSoc' id='VICYEWBISV' type='text' class='Field Disabled GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_xRagSoc),'C',70,0,'')+\"' tabindex='-1' readonly maxlength='70' size='70' fieldtype='C'>" +
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
    status.out.println("if ( ! (IsHiddenByStateDriver('CODINTER'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem CROCGCIGKF' value='\"+WtH(ToHTML(w_CODINTER),'C',16,0,'')+\"' tabindex='-1' readonly size='16'>" +
     "<button type='button' class='CROCGCIGKF_ZOOM GridZoomButtonEnabled' value="+SPLib.ToHTMLValue(status.context.Translate("..."),"C",0,0)+" disabled class='CROCGCIGKF_ZOOM GridZoomButtonEnabled'>" +
     "</button>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('DATAINI'))) {");
    status.out.println("s=s+\""+
     "<input type='"+(SPLib.IsMobile(status.request)?"date":"text")+"' class='Field Disabled GridTable_QueryRowItem BJKHVZBXDR' value='\"+WtH(w_DATAINI,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))+\"' tabindex='-1' readonly size='8'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('DATAFINE'))) {");
    status.out.println("s=s+\""+
     "<input type='"+(SPLib.IsMobile(status.request)?"date":"text")+"' class='Field Disabled GridTable_QueryRowItem JCFUNSQXBI' value='\"+WtH(w_DATAFINE,'D',8,0,TranslatePicture(GetDatePicture(true,'D'),'D'))+\"' tabindex='-1' readonly size='8'>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('xRagSoc'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled Disabled GridTable_QueryRowItem VICYEWBISV' value='\"+WtH(ToHTML(w_xRagSoc),'C',70,0,'')+\"' tabindex='-1' readonly size='70'>" +
    "\"");
    status.out.println("}");
    status.out.println("s=s+'<div style=\" position:absolute;z-index:2;width:716px;height:19px;\"></div>';");
    status.out.println("}");
    status.out.println("s=s+'</div>';");
    status.out.println("return s;");
    status.out.println("}");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b1(ardt_ae_delegaboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='DatiAna' id='VRCVINYRJO_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='VRCVINYRJO_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='VRCVINYRJO_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Anagrafici")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='VRCVINYRJO_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"VRCVINYRJO\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=VRCVINYRJO_HEADER&m_cBoxId=VRCVINYRJO&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Anagrafici"))+"");
    }
    status.out.println(
     "<div id='VRCVINYRJO' class='SectionBody' style='position:relative;height:56px;display:block'>" +
    "");
    status.includeZoneAltInterface("DatiAna@BEGIN");
    if (status.includeZoneAltInterface("DatiAna")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("DatiAna@BEGIN") || status.HasZoneAltInterface("DatiAna@END")) {
        status.out.println(
         "<div id='VRCVINYRJO_boxContent' style='position:relative;height:56px;display:block'>" +
        "");
      }
      status.out.println(
       "<span class='SPLabel' id='NAKGRMOUXS_DIV'>" +
       "<label id='NAKGRMOUXS'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_DOMICILIO)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HMPQLYVATL_DIV'>" +
       "<label id='HMPQLYVATL'>" +
       ""+SPLib.ToHTMLRepresentation(CPLib.LRTrim(BO.w_CAP)+" "+CPLib.LRTrim(BO.w_DESCCIT)+" ("+CPLib.LRTrim(BO.w_PROVINCIA)+")")+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("DatiAna@BEGIN") || status.HasZoneAltInterface("DatiAna@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b1_CloseBand(ardt_ae_delegaboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("DatiAna@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("DatiAna")) {
      status.out.println("Ctrl('VRCVINYRJO').style.height='auto';");
    } else {
      status.out.println("Ctrl('VRCVINYRJO').setAttribute('band_height',56);");
    }
    status.out.println("Ctrl('VRCVINYRJO').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(ardt_ae_delegaboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Progressivi' id='MINAAOAOZC_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='MINAAOAOZC_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='MINAAOAOZC_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Progressivi")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='MINAAOAOZC_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"MINAAOAOZC\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=MINAAOAOZC_HEADER&m_cBoxId=MINAAOAOZC&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Progressivi"))+"");
    }
    status.out.println(
     "<div id='MINAAOAOZC' class='SectionBody' style='position:relative;height:45px;display:block'>" +
    "");
    status.includeZoneAltInterface("Progressivi@BEGIN");
    if (status.includeZoneAltInterface("Progressivi")) {
      WriteControls_p1_b2_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Progressivi@BEGIN") || status.HasZoneAltInterface("Progressivi@END")) {
        status.out.println(
         "<div id='MINAAOAOZC_boxContent' style='position:relative;height:45px;display:block'>" +
        "");
      }
      status.out.println(
       "<span class='SPLabel' id='EQUZNNIXBO_DIV'>" +
       "<label id='EQUZNNIXBO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Prog.Informazione Chiusura:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BHLAQHLOJQ_DIV'>" +
       "<label id='BHLAQHLOJQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Prog.Informazione Apertura:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='NUMPROG1' id='XXEVJVFWWX' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_NUMPROG1,"C",11,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='11' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='NUMPROG2' id='QCGWEEVSON' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_NUMPROG2,"C",11,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='11' fieldtype='C'>" +
      "");
      if (status.HasZoneAltInterface("Progressivi@BEGIN") || status.HasZoneAltInterface("Progressivi@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b2_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b2_CloseBand(ardt_ae_delegaboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Progressivi@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Progressivi")) {
      status.out.println("Ctrl('MINAAOAOZC').style.height='auto';");
    } else {
      status.out.println("Ctrl('MINAAOAOZC').setAttribute('band_height',45);");
    }
    status.out.println("Ctrl('MINAAOAOZC').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b3(ardt_ae_delegaboBO BO,ServletStatus status) {
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
       "<input name='RAPPORTO' id='QPLXZEEVEI' type='text' class='Field PrimaryKeyField "+(CPLib.ne(status.m_cClientMode,"query")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_RAPPORTO,"C",25,0,"", status.m_oRegSettings)+" tabindex='-1' "+(CPLib.ne(status.m_cClientMode,"query")?"readonly":"")+" maxlength='25' size='25' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    }
  }
  static void PrintState(ardt_ae_delegaboBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(ardt_ae_delegaboBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
  }
  static void PrintStateWorkVars(ardt_ae_delegaboBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_CODINTER,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCINTER,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAINI,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPORAP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOPERS,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_STATOREG,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OPERAZMOD,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATARETT,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDEREG,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_COLLEGAMEN,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAFINE,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_UCODE,"C",7,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMPROG1,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMPROG2,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOAGE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descdele,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tiporegr,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DOMICILIO,"C",35,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCCIT,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINCIA,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAP,"C",9,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xRagSoc,"C",70,0));
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
    PrintStateDetailWorkVars(BO,status);
  }
  static void PrintStateDetailWorkVars(ardt_ae_delegaboBL BO,ServletStatus status) {
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
      status.out.print(""+SPLib.ToJSValue(BO.w_CODINTER,"C",16,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_DESCINTER,"C",70,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_descdele,"C",70,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_DATAINI,"D",8,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_TIPORAP,"C",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_TIPOPERS,"C",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_STATOREG,"C",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_OPERAZMOD,"C",20,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_DATARETT,"D",8,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_IDEREG,"C",20,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_COLLEGAMEN,"C",20,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_DATAFINE,"D",8,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_UCODE,"C",7,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_tiporegr,"N",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_DOMICILIO,"C",35,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_DESCCIT,"C",30,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_PROVINCIA,"C",2,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_CAP,"C",9,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_NUMPROG1,"C",11,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_NUMPROG2,"C",11,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_xRagSoc,"C",70,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_NOAGE,"C",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.m_nCPRowNum,"N",0,0)+",");
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
  static void PrintStateDetailWorkVars_Deleted(ardt_ae_delegaboBL BO,ServletStatus status) {
    String l_cTrs;
    int k;
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      ardt_ae_delegaboBO.TrsRow l_Row;
      l_cTrs = "[";
      k = 0;
      while (CPLib.lt(k,BO.m_oDeletedRows.size())) {
        l_Row= (ardt_ae_delegaboBO.TrsRow) BO.m_oDeletedRows.get(k);
        l_cTrs = l_cTrs+" new TrsRow(";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_CODINTER,"C",16,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_DESCINTER,"C",70,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_descdele,"C",70,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_DATAINI,"D",8,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_TIPORAP,"C",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_TIPOPERS,"C",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_STATOREG,"C",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_OPERAZMOD,"C",20,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_DATARETT,"D",8,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_IDEREG,"C",20,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_COLLEGAMEN,"C",20,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_DATAFINE,"D",8,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_IDBASE,"C",10,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_UCODE,"C",7,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_tiporegr,"N",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_DOMICILIO,"C",35,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_DESCCIT,"C",30,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_PROVINCIA,"C",2,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_CAP,"C",9,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_NUMPROG1,"C",11,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_NUMPROG2,"C",11,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_xRagSoc,"C",70,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_NOAGE,"C",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.m_nCPRowNum,"N",0,0)+",";
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
      // Variabile per la gestione del CPROWNUM
      status.out.println("w_CPROWNUM="+SPLib.ToJSValue(BO.m_nCPRowNum,"N",0,0)+";");
    }
  }
  void WriteMainFormVarScript(ardt_ae_delegaboBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_NAKGRMOUXS = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_HMPQLYVATL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(274,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(744,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_ae_delegabo"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'CROCGCIGKF':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"CROCGCIGKF",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'CROCGCIGKF':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("ardt_ae_delegabo","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"ardt_ae_delegabo",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("DatiAna"),"")) {
      status.quoteAndAppend("DatiAna","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Progressivi"),"")) {
      status.quoteAndAppend("Progressivi","hide","box");
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
    status.out.println("function TrsRow() {");
    status.out.println("if (Eq(arguments.length,1)) {");
    status.out.println("this.CODINTER=w_CODINTER;");
    status.out.println("this.DESCINTER=w_DESCINTER;");
    status.out.println("this.descdele=w_descdele;");
    status.out.println("this.DATAINI=w_DATAINI;");
    status.out.println("this.TIPORAP=w_TIPORAP;");
    status.out.println("this.TIPOPERS=w_TIPOPERS;");
    status.out.println("this.STATOREG=w_STATOREG;");
    status.out.println("this.OPERAZMOD=w_OPERAZMOD;");
    status.out.println("this.DATARETT=w_DATARETT;");
    status.out.println("this.IDEREG=w_IDEREG;");
    status.out.println("this.COLLEGAMEN=w_COLLEGAMEN;");
    status.out.println("this.DATAFINE=w_DATAFINE;");
    status.out.println("this.IDBASE=w_IDBASE;");
    status.out.println("this.UCODE=w_UCODE;");
    status.out.println("this.tiporegr=w_tiporegr;");
    status.out.println("this.DOMICILIO=w_DOMICILIO;");
    status.out.println("this.DESCCIT=w_DESCCIT;");
    status.out.println("this.PROVINCIA=w_PROVINCIA;");
    status.out.println("this.CAP=w_CAP;");
    status.out.println("this.NUMPROG1=w_NUMPROG1;");
    status.out.println("this.NUMPROG2=w_NUMPROG2;");
    status.out.println("this.xRagSoc=w_xRagSoc;");
    status.out.println("this.NOAGE=w_NOAGE;");
    status.out.println("this.CPROWNUM=w_CPROWNUM;");
    status.out.println("this.m_nRowStatus=arguments[0];");
    status.out.println("this.m_cOldRowCPCCCHK=m_cOldRowCPCCCHK;");
    int l;
    for ( l = 0; CPLib.lt(l,BO.m_MNTs.length); l = l + (1)) {
      if (BO.m_MNTs[l].RepeatedChild()) {
        status.out.println("this.m_cWv_"+BO.m_MNTs[l].m_cChildName+"=m_cWv_"+BO.m_MNTs[l].m_cChildName+";");
      }
    }
    status.out.println("} else {");
    status.out.println("this.CODINTER=arguments[0];");
    status.out.println("this.DESCINTER=arguments[1];");
    status.out.println("this.descdele=arguments[2];");
    status.out.println("this.DATAINI=arguments[3];");
    status.out.println("this.TIPORAP=arguments[4];");
    status.out.println("this.TIPOPERS=arguments[5];");
    status.out.println("this.STATOREG=arguments[6];");
    status.out.println("this.OPERAZMOD=arguments[7];");
    status.out.println("this.DATARETT=arguments[8];");
    status.out.println("this.IDEREG=arguments[9];");
    status.out.println("this.COLLEGAMEN=arguments[10];");
    status.out.println("this.DATAFINE=arguments[11];");
    status.out.println("this.IDBASE=arguments[12];");
    status.out.println("this.UCODE=arguments[13];");
    status.out.println("this.tiporegr=arguments[14];");
    status.out.println("this.DOMICILIO=arguments[15];");
    status.out.println("this.DESCCIT=arguments[16];");
    status.out.println("this.PROVINCIA=arguments[17];");
    status.out.println("this.CAP=arguments[18];");
    status.out.println("this.NUMPROG1=arguments[19];");
    status.out.println("this.NUMPROG2=arguments[20];");
    status.out.println("this.xRagSoc=arguments[21];");
    status.out.println("this.NOAGE=arguments[22];");
    status.out.println("this.CPROWNUM=arguments[23];");
    status.out.println("this.m_nRowStatus=arguments[24];");
    status.out.println("this.m_cOldRowCPCCCHK=arguments[25];");
    int lastRow;
    lastRow = 26;
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
    status.out.println("w_CODINTER=row.CODINTER;");
    status.out.println("w_DESCINTER=row.DESCINTER;");
    status.out.println("w_descdele=row.descdele;");
    status.out.println("w_DATAINI=row.DATAINI;");
    status.out.println("w_TIPORAP=row.TIPORAP;");
    status.out.println("w_TIPOPERS=row.TIPOPERS;");
    status.out.println("w_STATOREG=row.STATOREG;");
    status.out.println("w_OPERAZMOD=row.OPERAZMOD;");
    status.out.println("w_DATARETT=row.DATARETT;");
    status.out.println("w_IDEREG=row.IDEREG;");
    status.out.println("w_COLLEGAMEN=row.COLLEGAMEN;");
    status.out.println("w_DATAFINE=row.DATAFINE;");
    status.out.println("w_IDBASE=row.IDBASE;");
    status.out.println("w_UCODE=row.UCODE;");
    status.out.println("w_tiporegr=row.tiporegr;");
    status.out.println("w_DOMICILIO=row.DOMICILIO;");
    status.out.println("w_DESCCIT=row.DESCCIT;");
    status.out.println("w_PROVINCIA=row.PROVINCIA;");
    status.out.println("w_CAP=row.CAP;");
    status.out.println("w_NUMPROG1=row.NUMPROG1;");
    status.out.println("w_NUMPROG2=row.NUMPROG2;");
    status.out.println("w_xRagSoc=row.xRagSoc;");
    status.out.println("w_NOAGE=row.NOAGE;");
    if (CPLib.ne(status.m_cClientMode,"query")) {
      status.out.println("w_CPROWNUM=row.CPROWNUM;");
      status.out.println("m_nRowStatus=row.m_nRowStatus;");
      status.out.println("m_cOldRowCPCCCHK=row.m_cOldRowCPCCCHK;");
      for ( l = 0; CPLib.lt(l,BO.m_MNTs.length); l = l + (1)) {
        if (BO.m_MNTs[l].RepeatedChild()) {
          status.out.println("m_cWv_"+BO.m_MNTs[l].m_cChildName+"=row.m_cWv_"+BO.m_MNTs[l].m_cChildName+";");
        }
      }
      status.out.println("} else {");
      status.out.println("w_CODINTER='';");
      status.out.println("w_DESCINTER='';");
      status.out.println("w_descdele='';");
      status.out.println("w_DATAINI=NullDate();");
      status.out.println("w_TIPORAP='';");
      status.out.println("w_TIPOPERS='';");
      status.out.println("w_STATOREG='';");
      status.out.println("w_OPERAZMOD='';");
      status.out.println("w_DATARETT=NullDate();");
      status.out.println("w_IDEREG='';");
      status.out.println("w_COLLEGAMEN='';");
      status.out.println("w_DATAFINE=NullDate();");
      status.out.println("w_IDBASE='';");
      status.out.println("w_UCODE='';");
      status.out.println("w_tiporegr=0;");
      status.out.println("w_DOMICILIO='';");
      status.out.println("w_DESCCIT='';");
      status.out.println("w_PROVINCIA='';");
      status.out.println("w_CAP='';");
      status.out.println("w_NUMPROG1='';");
      status.out.println("w_NUMPROG2='';");
      status.out.println("w_xRagSoc='';");
      status.out.println("w_NOAGE='N';");
      status.out.println("w_CPROWNUM=0;");
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
    status.out.println("_GridRowHeight='19';");
    status.out.println("CPRowNumName='w_CPROWNUM';");
    WriteExtendedFieldsVars(BO.extendedFields,status);
    status.out.println("// * --- Area Manuale = UI - Declare Variables");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteMainFormScript(ardt_ae_delegaboBO BO,ServletStatus status) {
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
      status.out.println("SetFromContext(m_oFather.m_cWv_ardt_ae_delegabo);");
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
      status.out.println("m_oFather.SetChildVariables_ardt_ae_delegabo();");
      status.out.println("}");
    }
    status.out.println("AdjustTrs();");
    status.out.println("var l_cMode;");
    status.out.println("l_cMode=\""+status.m_cClientMode+"\";");
    WriteJSRestoreEntity(status);
    status.out.println("InitTable(Ctrl('GridTable'),l_cMode);");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("Z.Tabs.Get('tabs').InitSelect('ardt_ae_delegabo',Ne(m_nChildStatus,0));");
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
        status.out.println("if(c=Ctrl('QPLXZEEVEI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CROCGCIGKF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CROCGCIGKF_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BJKHVZBXDR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JCFUNSQXBI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XXEVJVFWWX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QCGWEEVSON')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VICYEWBISV')) SetDisabled(c,true);");
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
      status.out.println("SetDisabled('QPLXZEEVEI',m_bRowsChild);");
    }
    status.out.println("}");
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('QPLXZEEVEI')) SetDisabled(c,true);");
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
    status.out.println("m_oFather.m_oardt_ae_delegabo=null;");
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
  ardt_ae_delegaboBO getBO(ServletStatus status) {
    ardt_ae_delegaboBO BO = new ardt_ae_delegaboBO(status.context);
    if (CPLib.eq(status.m_nChildStatus,0)) {
      LoadExtensions(BO);
    }
    return BO;
  }
  void LoadExtensions(ardt_ae_delegaboBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("jelegabo",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,ardt_ae_delegaboBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,ardt_ae_delegaboBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
  }
  CPResultSet QueryKeyCursor(ardt_ae_delegaboBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_jelegabo;
    String l_cPhName = BO.m_cPhName_jelegabo;
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
      String l_cQueryFilter = ardt_ae_delegaboBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" distinct  "+BO.m_cVirtName_jelegabo+".RAPPORTO"+(CPLib.Empty(status.m_cLastOrderBy) || CPLib.gt(CPLib.At(status.m_cLastOrderBy," distinct  "+BO.m_cVirtName_jelegabo+".RAPPORTO"),0) || CPLib.ne(CPSql.GetDataBaseType(l_cServer),CPSql.m_nPostgres)?"":","+status.m_cLastOrderBy)+"",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("jelegabo");
    String l_cPhName = CPSql.ManipulateTablePhName("jelegabo",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".RAPPORTO"+(CPLib.Empty(status.m_cLastOrderBy) || CPLib.gt(CPLib.At(status.m_cLastOrderBy," "+l_cPhName+".RAPPORTO"),0) || CPLib.ne(CPSql.GetDataBaseType(l_cServer),CPSql.m_nPostgres)?"":","+status.m_cLastOrderBy)+"",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,ardt_ae_delegaboBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = ardt_ae_delegaboBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (CPLib.eq(CPSql.GetDataBaseType(BO.m_cServer_jelegabo),CPSql.m_nInformix)) {
        if (l_rsCount!=null)
          l_rsCount.Close();
        l_rsCount = BO.m_Sql.Query(BO.m_cServer_jelegabo,CPSql.BuildSQLPhrase(" count( distinct  "+BO.m_cVirtName_jelegabo+".RAPPORTO) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_jelegabo,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
      } else {
        if (l_rsCount!=null)
          l_rsCount.Close();
        l_rsCount = BO.m_Sql.Query(BO.m_cServer_jelegabo,CPSql.BuildSQLPhrase(" count(*) as reccount","("+CPSql.BuildSQLPhrase(" distinct  "+BO.m_cVirtName_jelegabo+".RAPPORTO",CPLib.GetTablesWithAliases(BO.m_cPhName_jelegabo,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,"")+") CountFrom","",""));
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
  void View(ServletStatus status,ardt_ae_delegaboBO BO) {
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
  void Edit(ServletStatus status,ardt_ae_delegaboBO BO,SPParameterSource source) {
    BO.Load(status.w_RAPPORTO);
    if (BO.m_bLoaded && BO.CanEdit()) {
      if (CPLib.eq(BO.Rows(),0)) {
        BO.w_CODINTER = "";
        BO.w_DESCINTER = "";
        BO.w_descdele = "";
        BO.w_DATAINI = CPLib.NullDate();
        BO.w_TIPORAP = "";
        BO.w_TIPOPERS = "";
        BO.w_STATOREG = "";
        BO.w_OPERAZMOD = "";
        BO.w_DATARETT = CPLib.NullDate();
        BO.w_IDEREG = "";
        BO.w_COLLEGAMEN = "";
        BO.w_DATAFINE = CPLib.NullDate();
        BO.w_IDBASE = "";
        BO.w_UCODE = "";
        BO.w_tiporegr = 0;
        BO.w_DOMICILIO = "";
        BO.w_DESCCIT = "";
        BO.w_PROVINCIA = "";
        BO.w_CAP = "";
        BO.w_NUMPROG1 = "";
        BO.w_NUMPROG2 = "";
        BO.w_xRagSoc = "";
        BO.w_NOAGE = "";
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
  void New(ServletStatus status,ardt_ae_delegaboBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,ardt_ae_delegaboBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,ardt_ae_delegaboBO BO) {
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
        if (CPLib.eq(BO.Rows(),0)) {
          BO.w_CODINTER = "";
          BO.w_DESCINTER = "";
          BO.w_descdele = "";
          BO.w_DATAINI = CPLib.NullDate();
          BO.w_TIPORAP = "";
          BO.w_TIPOPERS = "";
          BO.w_STATOREG = "";
          BO.w_OPERAZMOD = "";
          BO.w_DATARETT = CPLib.NullDate();
          BO.w_IDEREG = "";
          BO.w_COLLEGAMEN = "";
          BO.w_DATAFINE = CPLib.NullDate();
          BO.w_IDBASE = "";
          BO.w_UCODE = "";
          BO.w_tiporegr = 0;
          BO.w_DOMICILIO = "";
          BO.w_DESCCIT = "";
          BO.w_PROVINCIA = "";
          BO.w_CAP = "";
          BO.w_NUMPROG1 = "";
          BO.w_NUMPROG2 = "";
          BO.w_xRagSoc = "";
          BO.w_NOAGE = "";
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
  void EditLoad(ServletStatus status,ardt_ae_delegaboBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,ardt_ae_delegaboBO BO,SPParameterSource source) {
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
  void DeleteMessage(ServletStatus status,ardt_ae_delegaboBO BO,SPParameterSource source) {
    BO.Load(status.w_RAPPORTO);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,ardt_ae_delegaboBO BO) {
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
  void Discard(ServletStatus status,ardt_ae_delegaboBO BO) {
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
  void CreatePortlet(ServletStatus status,ardt_ae_delegaboBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",234);
    item.put("w",744);
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
    item.put("altInterfaceFor","ardt_ae_delegabo");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"h\":16,\"name\":\"label_MAUGJNUVWH\",\"page\":1,\"spuid\":\"MAUGJNUVWH\",\"tabindex\":2,\"type\":\"Label\",\"value\":\"Inizio\",\"w\":43,\"x\":592,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_RQPAWNXLEF\",\"page\":1,\"spuid\":\"RQPAWNXLEF\",\"tabindex\":1,\"type\":\"Label\",\"value\":\"Delegato\",\"w\":43,\"x\":8,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_DGFLOKNCET\",\"page\":1,\"spuid\":\"DGFLOKNCET\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Fine\",\"w\":43,\"x\":680,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":102,\"name\":\"BodyDetail0\",\"page\":1,\"spuid\":\"WOXQZZSGWY\",\"type\":\"BodyDetail\",\"w\":772,\"x\":8,\"y\":26,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"DatiAna\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Anagrafici\",\"h\":56,\"name\":\"DatiAna\",\"page\":1,\"shrinkable\":true,\"spuid\":\"VRCVINYRJO\",\"stretch\":true,\"tabindex\":4,\"title_caption\":\"Dati Anagrafici\",\"titled\":true,\"type\":\"Box\",\"w\":736,\"x\":8,\"y\":133,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_NAKGRMOUXS\",\"page\":1,\"spuid\":\"NAKGRMOUXS\",\"tabindex\":5,\"type\":\"Label\",\"w\":648,\"x\":16,\"y\":140,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_HMPQLYVATL\",\"page\":1,\"spuid\":\"HMPQLYVATL\",\"tabindex\":6,\"type\":\"Label\",\"w\":648,\"x\":16,\"y\":161,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Progressivi\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Progressivi\",\"h\":45,\"name\":\"Progressivi\",\"page\":1,\"shrinkable\":true,\"spuid\":\"MINAAOAOZC\",\"stretch\":true,\"tabindex\":8,\"title_caption\":\"Progressivi\",\"titled\":true,\"type\":\"Box\",\"w\":736,\"x\":8,\"y\":189,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EQUZNNIXBO\",\"page\":1,\"spuid\":\"EQUZNNIXBO\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"Prog.Informazione Chiusura:\",\"w\":163,\"x\":476,\"y\":207,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"N\\u00B0 Registrazione\",\"disabled\":\"true\",\"fixed\":true,\"h\":20,\"maxlength\":11,\"name\":\"NUMPROG2\",\"page\":1,\"readonly\":\"true\",\"repeated\":true,\"spuid\":\"QCGWEEVSON\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":80,\"x\":644,\"y\":203,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"N\\u00B0 Progressivo\",\"disabled\":\"true\",\"fixed\":true,\"h\":20,\"maxlength\":11,\"name\":\"NUMPROG1\",\"page\":1,\"readonly\":\"true\",\"repeated\":true,\"spuid\":\"XXEVJVFWWX\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":80,\"x\":168,\"y\":203,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BHLAQHLOJQ\",\"page\":1,\"spuid\":\"BHLAQHLOJQ\",\"tabindex\":10,\"type\":\"Label\",\"value\":\"Prog.Informazione Apertura:\",\"w\":147,\"x\":16,\"y\":207,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"__body__grid__\",\"box_type\":\"layer\",\"h\":39,\"name\":\"Body_Row\",\"page\":1,\"shrinkable\":true,\"spuid\":\"BIDSGBUIRI\",\"type\":\"Box\",\"w\":716,\"x\":8,\"y\":6,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":17,\"maxlength\":70,\"name\":\"xRagSoc\",\"page\":1,\"readonly\":\"true\",\"repeated\":true,\"spuid\":\"VICYEWBISV\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":423,\"x\":149,\"y\":28,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Inizio\",\"h\":17,\"maxlength\":10,\"name\":\"DATAINI\",\"page\":1,\"repeated\":true,\"spuid\":\"BJKHVZBXDR\",\"tabindex\":4,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":584,\"y\":28,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Fine\",\"h\":17,\"maxlength\":10,\"name\":\"DATAFINE\",\"page\":1,\"repeated\":true,\"spuid\":\"JCFUNSQXBI\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":60,\"x\":664,\"y\":28,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":17,\"maxlength\":16,\"name\":\"CODINTER\",\"page\":1,\"picker\":true,\"repeated\":true,\"spuid\":\"CROCGCIGKF\",\"tabindex\":1,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":110,\"x\":8,\"y\":28,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void DeleteRow(ServletStatus status,ardt_ae_delegaboBO BO,SPParameterSource source) {
    int l_nRow = 0;
    boolean l_bFound = false;
    boolean l_bTrsOk = true;
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    BO.Load(status.w_RAPPORTO);
    if (BO.m_bLoaded) {
      while (CPLib.lt(l_nRow,BO.m_oTrs.size()) &&  ! (l_bFound)) {
        l_bFound = CPLib.eq(source.GetParameter("CPROWNUM",source.GetParameter("cprownum",0)),BO.m_oTrs.get(l_nRow).m_nCPRowNum);
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
  void WriteFormPage(ardt_ae_delegaboBO BO,ServletStatus status) {
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
     "<script src='ardt_ae_delegabo?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/ardt_ae_delegabo_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/ardt_ae_delegabo_edit.js'>" +
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
      status.out.println("w_CODINTER=a[0];");
      status.out.println("w_DESCINTER=a[1];");
      status.out.println("w_DATAINI=a[2];");
      status.out.println("w_TIPORAP=a[3];");
      status.out.println("w_TIPOPERS=a[4];");
      status.out.println("w_STATOREG=a[5];");
      status.out.println("w_OPERAZMOD=a[6];");
      status.out.println("w_DATARETT=a[7];");
      status.out.println("w_IDEREG=a[8];");
      status.out.println("w_COLLEGAMEN=a[9];");
      status.out.println("w_DATAFINE=a[10];");
      status.out.println("w_IDBASE=a[11];");
      status.out.println("w_UCODE=a[12];");
      status.out.println("w_RAPPORTO=a[13];");
      status.out.println("w_NUMPROG1=a[14];");
      status.out.println("w_NUMPROG2=a[15];");
      status.out.println("w_NOAGE=a[16];");
      status.out.println("w_descdele=a[17];");
      status.out.println("w_tiporegr=a[18];");
      status.out.println("w_DOMICILIO=a[19];");
      status.out.println("w_DESCCIT=a[20];");
      status.out.println("w_PROVINCIA=a[21];");
      status.out.println("w_CAP=a[22];");
      status.out.println("w_xRagSoc=a[23];");
      status.out.println("if (Gt(a.length,24)) {");
      status.out.println("o_CODINTER=w_CODINTER;");
      status.out.println("o_DATAINI=w_DATAINI;");
      status.out.println("o_DATAFINE=w_DATAFINE;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['RAPPORTO'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/ardt_ae_delegabo_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(274,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","jelegabo");
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
  void RaiseLoadedEntity(ardt_ae_delegaboBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({RAPPORTO:"+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(ardt_ae_delegaboBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(ardt_ae_delegaboBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(ardt_ae_delegaboBO BO,ServletStatus status) {
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
  void WriteExitPage(ardt_ae_delegaboBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({RAPPORTO:"+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(ardt_ae_delegaboBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(ardt_ae_delegaboBO BO,ServletStatus status) throws IOException {
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
    l_cJsUid = SPPrxycizer.proxycizedPath("Utilities.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chkdatdoc.m_cEntityUid+"/arfn_chkdatdoc.js'>" +
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
      arfn_chkdatdoc.GetCallableNames(callable);
      CPLib.AddToSet(callable,"Utilities");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,ardt_ae_delegaboBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_RAPPORTO),"C",25,0));
      }
    } else if (CPLib.eq(p_cUID,"CROCGCIGKF")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,ardt_ae_delegaboBO BO) {
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
          if (result &&  ! (CPLib.Empty(BO.w_CODINTER))) {
            a = GetCheckVars(status,BO,"CROCGCIGKF");
            b = _row.optString("CROCGCIGKF");
            result = CPLib.eq(a,b);
          }
        }
        l_nRow = l_nRow+1;
      }
    }
    return result;
  }
}
