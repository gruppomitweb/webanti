import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class ardt_provsoginfo extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*5ac2c602*!";
  static public class ServletStatus extends SPDetailChildServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "xoginfo";
    }
    public String w_RAPCOL;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_RAPCOL,context,"xoginfo","RAPCOL","C",25,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='RAPCOL' type='hidden' value="+SPLib.ToHTMLValue(w_RAPCOL,"C",25,0)+">" +
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
    ardt_provsoginfoBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_xoginfo;
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
      status.w_RAPCOL = BO.w_RAPCOL;
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
    return "Soggetti Agenti per Conto Inform. Prov";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "ardt_provsoginfo";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 584;
    l_eg.m_nEntityHeight = 304;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"xoginfo","personbo","tbtipleg"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page"),new ZoneItem("box_VRCVINYRJO","DATI ANAGRAFICI","horizontal_section"),new ZoneItem("box_JUPHOBFSPW","","auto_horizontal_section")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"RAPCOL"};
    l_eg.items = new SPItem[]{
                   new SPItem("IDFILEBO","C",10,0, "hide","Idbase di Operazbo"),
                   new SPItem("RAPCOL","C",25,0, "edit",""),
                   new SPItem("CODSOG","C",16,0, "edit","Codice Soggetto"),
                   new SPItem("LEGAME","C",1,0, "edit","Tipo Legame"),
                   new SPItem("xragsoc","C",70,0, "show","Ragione Sociale"),
                   new SPItem("xdescleg","C",50,0, "show","Descrizione"),
                   new SPItem("DOMICILIO","C",35,0, "hide","Indirizzo"),
                   new SPItem("DESCCIT","C",30,0, "hide","Citt�"),
                   new SPItem("PROVINCIA","C",2,0, "hide","Provincia"),
                   new SPItem("CAP","C",9,0, "hide","CAP")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,ardt_provsoginfoBO BO) {
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
    {"10639118571",p_Context.Translate("Tipo Legame")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"10847988462",p_Context.Translate("Codice Soggetto")},
    {"12100711472",p_Context.Translate("Soggetti Agenti per Conto Inform. Prov")},
    {"15186643",p_Context.Translate("Citt�")},
    {"1729299794",p_Context.Translate("Anagrafica Persone")},
    {"1867895108",p_Context.Translate("Idbase di Operazbo")},
    {"21587",p_Context.Translate("CAP")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"554236824",p_Context.Translate("Indirizzo")},
    {"910117298",p_Context.Translate("Tipologie  legami")},
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
  void WriteStyles(ardt_provsoginfoBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../ardt_provsoginfo.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(ardt_provsoginfoBO BO,ServletStatus status) {
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
      status.out.println(".FVKNSPNHTX {top:0px;position:absolute;left:0px;height:16px;width:110px;background-color:Transparent;z-index:1; }");
      status.out.println(".FVKNSPNHTX_ZOOM { position:absolute;top:0px;left:111px;height:17px;width:17px;background-color:Transparent;background-repeat:no-repeat;background-position:center;margin:0;border-width:0;padding:0;z-index:1;}");
      status.out.println(".KQROMFNGNZ {top:0px;position:absolute;left:504px;height:16px;width:30px;background-color:Transparent;z-index:1; }");
      status.out.println(".KQROMFNGNZ_ZOOM { position:absolute;top:0px;left:535px;height:17px;width:17px;background-color:Transparent;background-repeat:no-repeat;background-position:center;margin:0;border-width:0;padding:0;z-index:1;}");
      status.out.println(".LRZLVXCRIO {top:0px;position:absolute;left:144px;height:16px;width:344px;background-color:Transparent;z-index:1; }");
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
      status.out.println("Z.Tabs.Get('tabs').InitSelect('ardt_provsoginfo',true);");
    }
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"ardt_provsoginfo",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(ardt_provsoginfoBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,2);
  }
  void WriteControls_p1(ardt_provsoginfoBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:304px;width:584px;display:none'>" +
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
  void WriteControls_p1_b0(ardt_provsoginfoBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_1' style='position:relative;height:184px;display:block' page='1'>" +
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
       "<span class='SPLabel' id='JWSZDAXYGH_DIV'>" +
       "<label id='JWSZDAXYGH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Soggetto"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PQGSBATIPW_DIV' style='display:none'>" +
       "<label id='PQGSBATIPW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Legame"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<div id='GridTable_Container' style='position:absolute;top:21px;left:6px;height:134px;width:574px;overflow:hidden' class='GridTable_Container "+SPLib.ToHTML(status.m_cClientMode,"C",0,0)+"'>" +
       "<div id=GridTable_LockedScroll style='position:absolute;top:0px;left:0px;height:134px;width:574px;overflow:scroll'>" +
       "</div>" +
       "</div>" +
      "");
      status.out.println(
       "<div id='GridTable_DIV' style='position:relative;left:0;top:0;width:574px;height:134px;overflow:auto;'>" +
       "<table id='GridTable' style='position:relative;top:0px;left:0px;width:568px' cellspacing='0' cellpadding='0' border='0'>" +
       "<tr>" +
       "<td></td>" +
       "</tr>" +
       "</table>" +
       "</div>" +
      "");
      if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println(
         "<div id='GridTable_ButtonPanel' style='position:absolute;top:0px;left:8px;z-index:4'>" +
         ""+printButtonPanelContent(status,1,"lower_right",false,getDetailMenuItems(),false,"")+"" +
         "</div>" +
        "");
      }
      status.out.println(
       "<div class='GridTable_VerticalLines' style='position:absolute;top:21px;left:144px;height:134px;width:1px'>" +
       "</div>" +
      "");
      status.out.println(
       "<div class='GridTable_VerticalLines' style='position:absolute;top:21px;left:504px;height:134px;width:1px'>" +
       "</div>" +
      "");
      HTMLRowScript(BO,status);
      status.out.println(
       "<input name='xdescleg' id='LPKMVNCKBI' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_xdescleg,"C",50,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='50' size='50' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SRGXXZYNNI_DIV' style='display:none'>" +
       "<label id='SRGXXZYNNI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Desc. Legame:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+1;
      status.out.println(
       "</div>" +
      "");
    }
  }
  void HTMLRowScript(ardt_provsoginfoBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder = null;
    status.out.println(
     "<script>" +
    "");
    status.out.println("function HTMLRow(editable,rowtoshow) {");
    status.out.println("var s;");
    status.out.println("s='<div style=\"position:relative;width:552px;height:15px;\"';");
    status.out.println("s=s+'>';");
    status.out.println("var row;");
    status.out.println("var prefix;");
    status.out.println("var w_CODSOG;");
    status.out.println("var w_LEGAME;");
    status.out.println("var w_xragsoc;");
    status.out.println("var w_xdescleg;");
    status.out.println("var w_DOMICILIO;");
    status.out.println("var w_DESCCIT;");
    status.out.println("var w_PROVINCIA;");
    status.out.println("var w_CAP;");
    status.out.println("if (Eq(rowtoshow,null)) {");
    status.out.println("row=window;");
    status.out.println("prefix='w_';");
    status.out.println("} else {");
    status.out.println("row=rowtoshow;");
    status.out.println("prefix='';");
    status.out.println("}");
    status.out.println("w_CODSOG=row[prefix+'CODSOG'];");
    status.out.println("w_LEGAME=row[prefix+'LEGAME'];");
    status.out.println("w_xragsoc=row[prefix+'xragsoc'];");
    status.out.println("w_xdescleg=row[prefix+'xdescleg'];");
    status.out.println("w_DOMICILIO=row[prefix+'DOMICILIO'];");
    status.out.println("w_DESCCIT=row[prefix+'DESCCIT'];");
    status.out.println("w_PROVINCIA=row[prefix+'PROVINCIA'];");
    status.out.println("w_CAP=row[prefix+'CAP'];");
    status.out.println("if (editable) {");
    status.out.println("if (Gt(m_nCurrentRow,0)) {");
    status.out.println("s=s+\""+
     "<input name='BeforeDetailElement' type='text' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' size='0' style='height:1px;width:1px;background-color:Transparent;border-style:none'>" +
    "\"");
    status.out.println("}");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='CODSOG' id='FVKNSPNHTX' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_CODSOG),'C',16,0,'')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='16' size='16' fieldtype='C'>" +
     "<button id='FVKNSPNHTX_ZOOM' type='button' class='GridZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
    "\"");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println("s=s+\""+
     "<input name='LEGAME' id='KQROMFNGNZ' type='text' class='Field GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_LEGAME),'C',1,0,'')+\"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" maxlength='1' size='1' fieldtype='C' style='display:none'>" +
     "<button id='KQROMFNGNZ_ZOOM' type='button' class='GridZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" style='display:none'>" +
     "</button>" +
    "\"");
    status.out.println("s=s+\""+
     "<input name='xragsoc' id='LRZLVXCRIO' type='text' class='Field Disabled GridTable_EditRowItem ' value='\"+WtH(ToHTML(w_xragsoc),'C',70,0,'')+\"' tabindex='-1' readonly maxlength='70' size='70' fieldtype='C'>" +
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
    status.out.println("if ( ! (IsHiddenByStateDriver('CODSOG'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem FVKNSPNHTX' value='\"+WtH(ToHTML(w_CODSOG),'C',16,0,'')+\"' tabindex='-1' readonly size='16'>" +
     "<button type='button' class='FVKNSPNHTX_ZOOM GridZoomButtonEnabled' value="+SPLib.ToHTMLValue(status.context.Translate("..."),"C",0,0)+" disabled class='FVKNSPNHTX_ZOOM GridZoomButtonEnabled'>" +
     "</button>" +
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('LEGAME'))) {");
    status.out.println("s=s+\""+
    "\"");
    status.out.println(
     "if ( ! ((arfn_view_soct(Utilities.Make(window).GetCallerDate('DATAOPE'),Utilities.Make(window).GetCallerString('TIPOOPRAP'),'T')) || IsHiddenByStateDriver('LEGAME'))) {" +
    "");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled GridTable_QueryRowItem KQROMFNGNZ' value='\"+WtH(ToHTML(w_LEGAME),'C',1,0,'')+\"' tabindex='-1' readonly size='1'>" +
    "\"");
    status.out.println(
     "if ( ! ((arfn_view_soct(Utilities.Make(window).GetCallerDate('DATAOPE'),Utilities.Make(window).GetCallerString('TIPOOPRAP'),'T')))) {" +
    "");
    status.out.println("s=s+\""+
     "<button type='button' class='KQROMFNGNZ_ZOOM GridZoomButtonEnabled' value="+SPLib.ToHTMLValue(status.context.Translate("..."),"C",0,0)+" disabled class='KQROMFNGNZ_ZOOM GridZoomButtonEnabled'>" +
     "</button>" +
    "\"");
    status.out.println(
     "}" +
    "");
    status.out.println("s=s+\""+
    "\"");
    status.out.println(
     "}" +
    "");
    status.out.println("s=s+\""+
    "\"");
    status.out.println("}");
    status.out.println("if ( ! (IsHiddenByStateDriver('xragsoc'))) {");
    status.out.println("s=s+\""+
     "<input type='text' class='Field Disabled Disabled GridTable_QueryRowItem LRZLVXCRIO' value='\"+WtH(ToHTML(w_xragsoc),'C',70,0,'')+\"' tabindex='-1' readonly size='70'>" +
    "\"");
    status.out.println("}");
    status.out.println("s=s+'<div style=\" position:absolute;z-index:2;width:552px;height:15px;\"></div>';");
    status.out.println("}");
    status.out.println("s=s+'</div>';");
    status.out.println("return s;");
    status.out.println("}");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b1(ardt_provsoginfoBO BO,ServletStatus status) {
    status.out.println(
     "<div name='box_VRCVINYRJO' id='VRCVINYRJO_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='VRCVINYRJO_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='VRCVINYRJO_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("DATI ANAGRAFICI")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='VRCVINYRJO_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"VRCVINYRJO\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=VRCVINYRJO_HEADER&m_cBoxId=VRCVINYRJO&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("DATI ANAGRAFICI"))+"");
    }
    status.out.println(
     "<div id='VRCVINYRJO' class='SectionBody' style='position:relative;height:48px;display:block'>" +
    "");
    status.includeZoneAltInterface("box_VRCVINYRJO@BEGIN");
    if (status.includeZoneAltInterface("box_VRCVINYRJO")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("box_VRCVINYRJO@BEGIN") || status.HasZoneAltInterface("box_VRCVINYRJO@END")) {
        status.out.println(
         "<div id='VRCVINYRJO_boxContent' style='position:relative;height:48px;display:block'>" +
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
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RAPCOL' id='IHXPLCYXNH' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_RAPCOL,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='25' size='25' fieldtype='C' style='display:none'>" +
      "");
      if (status.HasZoneAltInterface("box_VRCVINYRJO@BEGIN") || status.HasZoneAltInterface("box_VRCVINYRJO@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b1_CloseBand(ardt_provsoginfoBO BO,ServletStatus status) {
    status.includeZoneAltInterface("box_VRCVINYRJO@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("box_VRCVINYRJO")) {
      status.out.println("Ctrl('VRCVINYRJO').style.height='auto';");
    } else {
      status.out.println("Ctrl('VRCVINYRJO').setAttribute('band_height',48);");
    }
    status.out.println("Ctrl('VRCVINYRJO').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(ardt_provsoginfoBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_JUPHOBFSPW")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_JUPHOBFSPW' style='position:relative;height:8px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_JUPHOBFSPW")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_JUPHOBFSPW').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b3(ardt_provsoginfoBO BO,ServletStatus status) {
    status.out.println(
     "<div name='box_JUPHOBFSPW' id='JUPHOBFSPW_DIV' class='BoxContainer SPSection_expanded SectionContainerWithoutTitle'>" +
    "");
    status.out.println(
     "<div id='JUPHOBFSPW' class='SectionBody' style='position:relative;height:24px;display:block'>" +
    "");
    status.includeZoneAltInterface("box_JUPHOBFSPW@BEGIN");
    if (status.includeZoneAltInterface("box_JUPHOBFSPW")) {
      WriteControls_p1_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("box_JUPHOBFSPW@BEGIN") || status.HasZoneAltInterface("box_JUPHOBFSPW@END")) {
        status.out.println(
         "<div id='JUPHOBFSPW_boxContent' style='position:relative;height:24px;display:block'>" +
        "");
      }
      if (status.HasZoneAltInterface("box_JUPHOBFSPW@BEGIN") || status.HasZoneAltInterface("box_JUPHOBFSPW@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b3_CloseBand(ardt_provsoginfoBO BO,ServletStatus status) {
    status.includeZoneAltInterface("box_JUPHOBFSPW@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("box_JUPHOBFSPW")) {
      status.out.println("Ctrl('JUPHOBFSPW').style.height='auto';");
    } else {
      status.out.println("Ctrl('JUPHOBFSPW').setAttribute('band_height',24);");
    }
    status.out.println("Ctrl('JUPHOBFSPW').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b4(ardt_provsoginfoBO BO,ServletStatus status) {
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
  static void PrintState(ardt_provsoginfoBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(ardt_provsoginfoBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
  }
  static void PrintStateWorkVars(ardt_provsoginfoBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_IDFILEBO,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODSOG,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_LEGAME,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAPCOL,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragsoc,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescleg,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DOMICILIO,"C",35,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCCIT,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINCIA,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAP,"C",9,0));
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
    PrintStateDetailWorkVars(BO,status);
  }
  static void PrintStateDetailWorkVars(ardt_provsoginfoBL BO,ServletStatus status) {
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
      status.out.print(""+SPLib.ToJSValue(BO.w_CODSOG,"C",16,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_LEGAME,"C",1,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_xragsoc,"C",70,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_xdescleg,"C",50,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_DOMICILIO,"C",35,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_DESCCIT,"C",30,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_PROVINCIA,"C",2,0)+",");
      status.out.print(""+SPLib.ToJSValue(BO.w_CAP,"C",9,0)+",");
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
  static void PrintStateDetailWorkVars_Deleted(ardt_provsoginfoBL BO,ServletStatus status) {
    String l_cTrs;
    int k;
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      ardt_provsoginfoBO.TrsRow l_Row;
      l_cTrs = "[";
      k = 0;
      while (CPLib.lt(k,BO.m_oDeletedRows.size())) {
        l_Row= (ardt_provsoginfoBO.TrsRow) BO.m_oDeletedRows.get(k);
        l_cTrs = l_cTrs+" new TrsRow(";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_CODSOG,"C",16,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_LEGAME,"C",1,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_xragsoc,"C",70,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_xdescleg,"C",50,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_DOMICILIO,"C",35,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_DESCCIT,"C",30,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_PROVINCIA,"C",2,0)+",";
        l_cTrs = l_cTrs+SPLib.ToJSValue(l_Row.w_CAP,"C",9,0)+",";
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
  void WriteMainFormVarScript(ardt_provsoginfoBO BO,ServletStatus status) {
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(304,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(584,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_provsoginfo"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'FVKNSPNHTX':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"FVKNSPNHTX",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'KQROMFNGNZ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"KQROMFNGNZ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipleg,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'FVKNSPNHTX':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'KQROMFNGNZ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipleg,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("ardt_provsoginfo","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"ardt_provsoginfo",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("box_VRCVINYRJO"),"")) {
      status.quoteAndAppend("box_VRCVINYRJO","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_JUPHOBFSPW"),"")) {
      status.quoteAndAppend("box_JUPHOBFSPW","hide","box");
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
    status.out.println("this.CODSOG=w_CODSOG;");
    status.out.println("this.LEGAME=w_LEGAME;");
    status.out.println("this.xragsoc=w_xragsoc;");
    status.out.println("this.xdescleg=w_xdescleg;");
    status.out.println("this.DOMICILIO=w_DOMICILIO;");
    status.out.println("this.DESCCIT=w_DESCCIT;");
    status.out.println("this.PROVINCIA=w_PROVINCIA;");
    status.out.println("this.CAP=w_CAP;");
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
    status.out.println("this.CODSOG=arguments[0];");
    status.out.println("this.LEGAME=arguments[1];");
    status.out.println("this.xragsoc=arguments[2];");
    status.out.println("this.xdescleg=arguments[3];");
    status.out.println("this.DOMICILIO=arguments[4];");
    status.out.println("this.DESCCIT=arguments[5];");
    status.out.println("this.PROVINCIA=arguments[6];");
    status.out.println("this.CAP=arguments[7];");
    status.out.println("this.CPROWNUM=arguments[8];");
    status.out.println("this.m_nRowStatus=arguments[9];");
    status.out.println("this.m_cOldRowCPCCCHK=arguments[10];");
    int lastRow;
    lastRow = 11;
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
    status.out.println("w_CODSOG=row.CODSOG;");
    status.out.println("w_LEGAME=row.LEGAME;");
    status.out.println("w_xragsoc=row.xragsoc;");
    status.out.println("w_xdescleg=row.xdescleg;");
    status.out.println("w_DOMICILIO=row.DOMICILIO;");
    status.out.println("w_DESCCIT=row.DESCCIT;");
    status.out.println("w_PROVINCIA=row.PROVINCIA;");
    status.out.println("w_CAP=row.CAP;");
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
      status.out.println("w_CODSOG='';");
      status.out.println("w_LEGAME='';");
      status.out.println("w_xragsoc='';");
      status.out.println("w_xdescleg='';");
      status.out.println("w_DOMICILIO='';");
      status.out.println("w_DESCCIT='';");
      status.out.println("w_PROVINCIA='';");
      status.out.println("w_CAP='';");
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
    status.out.println("_GridRowHeight='15';");
    status.out.println("CPRowNumName='w_CPROWNUM';");
    WriteExtendedFieldsVars(BO.extendedFields,status);
    status.out.println("// * --- Area Manuale = UI - Declare Variables");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteMainFormScript(ardt_provsoginfoBO BO,ServletStatus status) {
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
      status.out.println("SetFromContext(m_oFather.m_cWv_ardt_provsoginfo);");
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
      status.out.println("m_oFather.SetChildVariables_ardt_provsoginfo();");
      status.out.println("}");
    }
    status.out.println("AdjustTrs();");
    status.out.println("var l_cMode;");
    status.out.println("l_cMode=\""+status.m_cClientMode+"\";");
    WriteJSRestoreEntity(status);
    status.out.println("InitTable(Ctrl('GridTable'),l_cMode);");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("Z.Tabs.Get('tabs').InitSelect('ardt_provsoginfo',Ne(m_nChildStatus,0));");
    } else {
      status.out.println("calculateSidebarBandsPosition('page_1');");
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('IHXPLCYXNH')) SetDisabled(c,true);");
      } else if (( ! (CPLib.Empty(status.m_cAltInterface))) && CPLib.eq(status.m_cClientMode,"query")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('FVKNSPNHTX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FVKNSPNHTX_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KQROMFNGNZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KQROMFNGNZ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LRZLVXCRIO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LPKMVNCKBI')) SetDisabled(c,true);");
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
      status.out.println("SetDisabled('IHXPLCYXNH',m_bRowsChild);");
    }
    status.out.println("}");
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('IHXPLCYXNH')) SetDisabled(c,true);");
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
    status.out.println("m_oFather.m_oardt_provsoginfo=null;");
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
  ardt_provsoginfoBO getBO(ServletStatus status) {
    ardt_provsoginfoBO BO = new ardt_provsoginfoBO(status.context);
    if (CPLib.eq(status.m_nChildStatus,0)) {
      LoadExtensions(BO);
    }
    return BO;
  }
  void LoadExtensions(ardt_provsoginfoBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("xoginfo",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,ardt_provsoginfoBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,ardt_provsoginfoBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
  }
  CPResultSet QueryKeyCursor(ardt_provsoginfoBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_xoginfo;
    String l_cPhName = BO.m_cPhName_xoginfo;
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
      String l_cQueryFilter = ardt_provsoginfoBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" distinct  "+BO.m_cVirtName_xoginfo+".RAPCOL"+(CPLib.Empty(status.m_cLastOrderBy) || CPLib.gt(CPLib.At(status.m_cLastOrderBy," distinct  "+BO.m_cVirtName_xoginfo+".RAPCOL"),0) || CPLib.ne(CPSql.GetDataBaseType(l_cServer),CPSql.m_nPostgres)?"":","+status.m_cLastOrderBy)+"",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("xoginfo");
    String l_cPhName = CPSql.ManipulateTablePhName("xoginfo",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altres� come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".RAPCOL"+(CPLib.Empty(status.m_cLastOrderBy) || CPLib.gt(CPLib.At(status.m_cLastOrderBy," "+l_cPhName+".RAPCOL"),0) || CPLib.ne(CPSql.GetDataBaseType(l_cServer),CPSql.m_nPostgres)?"":","+status.m_cLastOrderBy)+"",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,ardt_provsoginfoBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = ardt_provsoginfoBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (CPLib.eq(CPSql.GetDataBaseType(BO.m_cServer_xoginfo),CPSql.m_nInformix)) {
        if (l_rsCount!=null)
          l_rsCount.Close();
        l_rsCount = BO.m_Sql.Query(BO.m_cServer_xoginfo,CPSql.BuildSQLPhrase(" count( distinct  "+BO.m_cVirtName_xoginfo+".RAPCOL) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_xoginfo,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
      } else {
        if (l_rsCount!=null)
          l_rsCount.Close();
        l_rsCount = BO.m_Sql.Query(BO.m_cServer_xoginfo,CPSql.BuildSQLPhrase(" count(*) as reccount","("+CPSql.BuildSQLPhrase(" distinct  "+BO.m_cVirtName_xoginfo+".RAPCOL",CPLib.GetTablesWithAliases(BO.m_cPhName_xoginfo,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,"")+") CountFrom","",""));
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
  void View(ServletStatus status,ardt_provsoginfoBO BO) {
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
  void Edit(ServletStatus status,ardt_provsoginfoBO BO,SPParameterSource source) {
    BO.Load(status.w_RAPCOL);
    if (BO.m_bLoaded && BO.CanEdit()) {
      if (CPLib.eq(BO.Rows(),0)) {
        BO.w_CODSOG = "";
        BO.w_LEGAME = "";
        BO.w_xragsoc = "";
        BO.w_xdescleg = "";
        BO.w_DOMICILIO = "";
        BO.w_DESCCIT = "";
        BO.w_PROVINCIA = "";
        BO.w_CAP = "";
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
  void New(ServletStatus status,ardt_provsoginfoBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,ardt_provsoginfoBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,ardt_provsoginfoBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_RAPCOL = "";
      } else {
        BO.w_RAPCOL = l_rsKeys.GetString("RAPCOL");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_RAPCOL = BO.w_RAPCOL;
        if (CPLib.eq(BO.Rows(),0)) {
          BO.w_CODSOG = "";
          BO.w_LEGAME = "";
          BO.w_xragsoc = "";
          BO.w_xdescleg = "";
          BO.w_DOMICILIO = "";
          BO.w_DESCCIT = "";
          BO.w_PROVINCIA = "";
          BO.w_CAP = "";
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
  void EditLoad(ServletStatus status,ardt_provsoginfoBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,ardt_provsoginfoBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_RAPCOL);
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
  void DeleteMessage(ServletStatus status,ardt_provsoginfoBO BO,SPParameterSource source) {
    BO.Load(status.w_RAPCOL);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,ardt_provsoginfoBO BO) {
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({RAPCOL:"+SPLib.ToJSValue(BO.w_RAPCOL,"C",25,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
  void Discard(ServletStatus status,ardt_provsoginfoBO BO) {
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
  void CreatePortlet(ServletStatus status,ardt_provsoginfoBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",264);
    item.put("w",584);
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
    item.put("altInterfaceFor","ardt_provsoginfo");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"h\":16,\"name\":\"label_JWSZDAXYGH\",\"page\":1,\"spuid\":\"JWSZDAXYGH\",\"tabindex\":2,\"type\":\"Label\",\"typevar\":\"logic\",\"value\":\"Codice Soggetto\",\"w\":91,\"x\":8,\"y\":4,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_PQGSBATIPW\",\"page\":1,\"spuid\":\"PQGSBATIPW\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Legame\",\"w\":48,\"x\":512,\"y\":8,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":130,\"name\":\"BodyDetail0\",\"page\":1,\"spuid\":\"SHFELJEZXU\",\"type\":\"BodyDetail\",\"w\":608,\"x\":8,\"y\":22,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_VRCVINYRJO\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"DATI ANAGRAFICI\",\"h\":48,\"name\":\"box_VRCVINYRJO\",\"page\":1,\"shrinkable\":true,\"spuid\":\"VRCVINYRJO\",\"stretch\":true,\"tabindex\":4,\"title_caption\":\"DATI ANAGRAFICI\",\"titled\":true,\"type\":\"Box\",\"w\":552,\"x\":8,\"y\":184,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SRGXXZYNNI\",\"page\":1,\"spuid\":\"SRGXXZYNNI\",\"tabindex\":1,\"type\":\"Label\",\"value\":\"Desc. Legame:\",\"w\":84,\"x\":8,\"y\":164,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Descrizione\",\"disabled\":\"true\",\"fixed\":true,\"h\":20,\"maxlength\":50,\"name\":\"xdescleg\",\"page\":1,\"readonly\":\"true\",\"repeated\":true,\"spuid\":\"LPKMVNCKBI\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":448,\"x\":96,\"y\":160,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_NAKGRMOUXS\",\"page\":1,\"spuid\":\"NAKGRMOUXS\",\"tabindex\":5,\"type\":\"Label\",\"w\":360,\"x\":16,\"y\":192,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_HMPQLYVATL\",\"page\":1,\"spuid\":\"HMPQLYVATL\",\"tabindex\":6,\"type\":\"Label\",\"w\":416,\"x\":16,\"y\":213,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_JUPHOBFSPW\",\"box_type\":\"auto_horizontal_section\",\"collapsible\":true,\"h\":24,\"name\":\"box_JUPHOBFSPW\",\"page\":1,\"shrinkable\":true,\"spuid\":\"JUPHOBFSPW\",\"stretch\":true,\"tabindex\":8,\"type\":\"Box\",\"w\":584,\"x\":0,\"y\":240,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"__body__grid__\",\"box_type\":\"layer\",\"h\":38,\"name\":\"Body_Row\",\"page\":1,\"shrinkable\":true,\"spuid\":\"XTHMHZGBME\",\"type\":\"Box\",\"w\":552,\"x\":8,\"y\":3,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Soggetto\",\"h\":17,\"maxlength\":16,\"name\":\"CODSOG\",\"page\":1,\"picker\":true,\"repeated\":true,\"spuid\":\"FVKNSPNHTX\",\"tabindex\":1,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":110,\"x\":8,\"y\":24,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Ragione Sociale\",\"disabled\":\"true\",\"h\":17,\"maxlength\":70,\"name\":\"xragsoc\",\"page\":1,\"readonly\":\"true\",\"repeated\":true,\"spuid\":\"LRZLVXCRIO\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":344,\"x\":152,\"y\":24,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo Legame\",\"h\":17,\"maxlength\":1,\"name\":\"LEGAME\",\"page\":1,\"picker\":true,\"repeated\":true,\"spuid\":\"KQROMFNGNZ\",\"tabindex\":2,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":512,\"y\":24,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void DeleteRow(ServletStatus status,ardt_provsoginfoBO BO,SPParameterSource source) {
    int l_nRow = 0;
    boolean l_bFound = false;
    boolean l_bTrsOk = true;
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    BO.Load(status.w_RAPCOL);
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
  void WriteFormPage(ardt_provsoginfoBO BO,ServletStatus status) {
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
     "<script src='ardt_provsoginfo?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/ardt_provsoginfo_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/ardt_provsoginfo_edit.js'>" +
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
      status.out.println("w_IDFILEBO=a[0];");
      status.out.println("w_CODSOG=a[1];");
      status.out.println("w_LEGAME=a[2];");
      status.out.println("w_RAPCOL=a[3];");
      status.out.println("w_xragsoc=a[4];");
      status.out.println("w_xdescleg=a[5];");
      status.out.println("w_DOMICILIO=a[6];");
      status.out.println("w_DESCCIT=a[7];");
      status.out.println("w_PROVINCIA=a[8];");
      status.out.println("w_CAP=a[9];");
      status.out.println("m_PrimaryKeys=['RAPCOL'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/ardt_provsoginfo_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(304,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","xoginfo");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","RAPCOL");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(ardt_provsoginfoBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({RAPCOL:"+SPLib.ToJSValue(BO.w_RAPCOL,"C",25,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(ardt_provsoginfoBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({RAPCOL:"+SPLib.ToJSValue(BO.w_RAPCOL,"C",25,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(ardt_provsoginfoBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({RAPCOL:"+SPLib.ToJSValue(BO.w_RAPCOL,"C",25,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(ardt_provsoginfoBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({RAPCOL:"+SPLib.ToJSValue(BO.w_RAPCOL,"C",25,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(ardt_provsoginfoBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({RAPCOL:"+SPLib.ToJSValue(BO.w_RAPCOL,"C",25,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(ardt_provsoginfoBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(ardt_provsoginfoBO BO,ServletStatus status) throws IOException {
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
    status.out.println(
     "<script src='SPPrxy/"+arfn_view_soct.m_cEntityUid+"/arfn_view_soct.js'>" +
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
      arfn_view_soct.GetCallableNames(callable);
      CPLib.AddToSet(callable,"LibreriaMit");
      CPLib.AddToSet(callable,"Utilities");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,ardt_provsoginfoBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_RAPCOL),"C",25,0));
      }
    } else if (CPLib.eq(p_cUID,"FVKNSPNHTX")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"KQROMFNGNZ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,ardt_provsoginfoBO BO) {
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
          if (result &&  ! (CPLib.Empty(BO.w_CODSOG))) {
            a = GetCheckVars(status,BO,"FVKNSPNHTX");
            b = _row.optString("FVKNSPNHTX");
            result = CPLib.eq(a,b);
          }
          if (result &&  ! (CPLib.Empty(BO.w_LEGAME))) {
            a = GetCheckVars(status,BO,"KQROMFNGNZ");
            b = _row.optString("KQROMFNGNZ");
            result = CPLib.eq(a,b);
          }
        }
        l_nRow = l_nRow+1;
      }
    }
    return result;
  }
}
