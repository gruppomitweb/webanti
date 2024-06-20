import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_cgo_personbo extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*3ad6c269*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "cgo_soggetti_err";
    }
    public String w_PRGSOG;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_PRGSOG,context,"cgo_soggetti_err","PRGSOG","C",15,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='PRGSOG' type='hidden' value="+SPLib.ToHTMLValue(w_PRGSOG,"C",15,0)+">" +
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
    armt_cgo_personboBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_cgo_soggetti_err;
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
      status.w_PRGSOG = BO.w_PRGSOG;
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
    return "Soggetti Scartati (CGO)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_cgo_personbo";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 797;
    l_eg.m_nEntityHeight = 566;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"cgo_soggetti_err","tbstati","tbcitta","tbcittna","tbstatna","tbtipdoc"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","Dati Base","page"),new ZoneItem("Residenza","Dati Residenza","horizontal_section"),new ZoneItem("PF","Dati Nascita","horizontal_section"),new ZoneItem("PFDoc","Dati Documento","horizontal_section"),new ZoneItem("Chiave","Dati Base","horizontal_section"),new ZoneItem("Errori","Errori Rilevati","horizontal_section")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"PRGSOG"};
    l_eg.items = new SPItem[]{
                   new SPItem("COGNOME","C",26,0, "edit","Cognome"),
                   new SPItem("NOME","C",25,0, "edit","Nome"),
                   new SPItem("CFESTERO","N",1,0, "edit","Codice Fiscale Estero"),
                   new SPItem("PAESE","C",3,0, "edit","Stato"),
                   new SPItem("DESCCIT","C",30,0, "edit","Città"),
                   new SPItem("PROVINCIA","C",2,0, "edit","Provincia"),
                   new SPItem("CAP","C",9,0, "edit","CAP"),
                   new SPItem("DOMICILIO","C",35,0, "edit","Indirizzo"),
                   new SPItem("IDCITTANA","C",40,0, "edit","ID CItta Nascita"),
                   new SPItem("nascomunid","C",40,0, "hide",""),
                   new SPItem("NASCOMUN","C",30,0, "edit","Luogo di Nascita"),
                   new SPItem("NASPROV","C",2,0, "edit","Provincia di nascita (EE se nato estero)"),
                   new SPItem("SESSO","C",1,0, "edit","Sesso"),
                   new SPItem("NASSTATO","C",30,0, "edit","Stato di nascita"),
                   new SPItem("DATANASC","D",8,0, "edit","Data Nascita"),
                   new SPItem("TIPODOC","C",2,0, "edit","Tipo Documento"),
                   new SPItem("NUMDOCUM","C",15,0, "edit","Numero Doc."),
                   new SPItem("DATARILASC","D",8,0, "edit","Data Rilascio Doc."),
                   new SPItem("DATAVALI","D",8,0, "edit",""),
                   new SPItem("AUTRILASC","C",30,0, "edit","Autorità di rilascio"),
                   new SPItem("CONNES","C",16,0, "edit","Codice Fiscale"),
                   new SPItem("dessta","C",30,0, "hide","Descrizione"),
                   new SPItem("PEP","C",1,0, "edit","Persona Politicamente Esposta"),
                   new SPItem("TXTERR","M",10,0, "edit","Errori"),
                   new SPItem("PRGSOG","C",15,0, "edit","Progressivo Errore"),
                   new SPItem("FLGFULL","C",1,0, "edit","Completo"),
                   new SPItem("DESCRI","C",30,0, "hide","Descrizione"),
                   new SPItem("CODCAB","C",6,0, "show","CAB")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_cgo_personboBO BO) {
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
    l_translations=new String[][]{{"10032163180",p_Context.Translate("Autorità di rilascio")},
    {"10034398626",p_Context.Translate("Codice Fiscale Errato")},
    {"10034405761",p_Context.Translate("Codice Fiscale Estero")},
    {"10095365423",p_Context.Translate("Provincia")},
    {"10492850948",p_Context.Translate("Soggetti Scartati (CGO)")},
    {"10511004352",p_Context.Translate("Codice Fiscale formalmente non valido")},
    {"11083306812",p_Context.Translate("Codice Fiscale non coerente con dati anagrafici")},
    {"11429032151",p_Context.Translate("Tipo Documento")},
    {"11693745788",p_Context.Translate("Provincia di nascita (EE se nato estero)")},
    {"11732732778",p_Context.Translate("Correzione Completata")},
    {"11777527481",p_Context.Translate("Data Nascita")},
    {"118057317",p_Context.Translate("Errori")},
    {"11921223220",p_Context.Translate("Codice Fiscale")},
    {"12123284333",p_Context.Translate("Stato di nascita")},
    {"12123334500",p_Context.Translate("Luogo di Nascita")},
    {"1267255314",p_Context.Translate("Persona Esposta Politicamente")},
    {"1513560829",p_Context.Translate("Persona Politicamente Esposta")},
    {"15186643",p_Context.Translate("Città")},
    {"1690077224",p_Context.Translate("Data Rilascio Doc.")},
    {"1734932797",p_Context.Translate("Numero Doc.")},
    {"1791194163",p_Context.Translate("Completo")},
    {"18003",p_Context.Translate("CAB")},
    {"1816546867",p_Context.Translate("Cognome")},
    {"184789190",p_Context.Translate("Codice Fiscale non attribuito dall'Agenzia delle Entrate (p.es. Sogg. Estero senza stabile organizz. o attività in Italia)")},
    {"21587",p_Context.Translate("CAP")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"321938427",p_Context.Translate("Progressivo Errore")},
    {"378006153",p_Context.Translate("ID CItta Nascita")},
    {"443454",p_Context.Translate("Nome")},
    {"554236824",p_Context.Translate("Indirizzo")},
    {"7383187",p_Context.Translate("Stati")},
    {"7776403",p_Context.Translate("Stato")},
    {"7776675",p_Context.Translate("Sesso")}};
    return l_translations;
  }
  void WriteStyles(armt_cgo_personboBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_cgo_personbo.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_cgo_personboBO BO,ServletStatus status) {
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
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"Dati Base")) {
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
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"Dati Base")) {
      status.out.println("if ( ! (Z.Tabs.Has('tabs'))) {");
      status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati Base"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
      status.out.println("Z.Tabs.Set('tabs',tabs);");
      status.out.println("} else {");
      status.out.println("var tabs = Z.Tabs.Get('tabs')");
      status.out.println("}");
      AddExtendedTabs(status);
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_cgo_personbo',false);");
    }
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_cgo_personbo",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(armt_cgo_personboBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,2);
  }
  void WriteControls_p1(armt_cgo_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:566px;width:797px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteControls_p1_b1(BO,status);
    WriteControls_p1_b2(BO,status);
    WriteControls_p1_b3(BO,status);
    WriteControls_p1_b4(BO,status);
    WriteControls_p1_b5(BO,status);
    WriteControls_p1_b6(BO,status);
    WriteControls_p1_b7(BO,status);
    WriteControls_p1_b8(BO,status);
    WriteControls_p1_b9(BO,status);
    WriteControls_p1_b10(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"Dati Base");
    PrintSidebarContent(1,status,getSidebarItems(0),true);
    PrintContextMenu(1,status,getContextMenu(0),"");
    status.out.println(
     "</div>" +
    "");
    if ( ! (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"Dati Base"))) {
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('page_1').style.display='block';");
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteControls_p1_b0(armt_cgo_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_1' style='position:relative;height:7px;display:block' page='1'>" +
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
  void WriteControls_p1_b1(armt_cgo_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Residenza' id='AQSQVBKXAL_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='AQSQVBKXAL_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='AQSQVBKXAL_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Residenza")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='AQSQVBKXAL_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"AQSQVBKXAL\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=AQSQVBKXAL_HEADER&m_cBoxId=AQSQVBKXAL&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Residenza"))+"");
    }
    status.out.println(
     "<div id='AQSQVBKXAL' class='SectionBody' style='position:relative;height:145px;display:block'>" +
    "");
    status.includeZoneAltInterface("Residenza@BEGIN");
    if (status.includeZoneAltInterface("Residenza")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Residenza@BEGIN") || status.HasZoneAltInterface("Residenza@END")) {
        status.out.println(
         "<div id='AQSQVBKXAL_boxContent' style='position:relative;height:145px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='COGNOME' id='TWTTDWKCRG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_COGNOME,"C",26,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='26' size='26' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NOME' id='WWGIVGNUDW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NOME,"C",25,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='CZTHKEDVCO_DIV'>" +
       "<input name='CFESTERO' id='CZTHKEDVCO' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_CFESTERO,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_CFESTERO)?"CHECKED":"")+">" +
       "<label id='CZTHKEDVCO_LBL' for='CZTHKEDVCO' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale non attribuito dall'Agenzia delle Entrate (p.es. Sogg. Estero senza stabile organizz. o attività in Italia)"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PAESE' id='YVIKEGPYPM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PAESE,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='YVIKEGPYPM_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "YVIKEGPYPM", "tbstati", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DESCCIT' id='ODAYKSRECA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DESCCIT,"C",30,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C' autocomplete='off'>" +
       "<button id='ODAYKSRECA_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "ODAYKSRECA", "tbcitta", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PROVINCIA' id='NOTZPDMYIA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PROVINCIA,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CAP' id='RDAVOEETJG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CAP,"C",9,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='9' size='9' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DOMICILIO' id='VYLHWTRQNX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DOMICILIO,"C",35,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='35' size='35' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SBJQIAQUCN_DIV'>" +
       "<label id='SBJQIAQUCN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Provincia:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RZBLEGCFJJ_DIV'>" +
       "<label id='RZBLEGCFJJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TWTXGZJTAR_DIV'>" +
       "<label id='TWTXGZJTAR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Indirizzo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GDOCAGKROT_DIV'>" +
       "<label id='GDOCAGKROT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAP:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WHMXTGXWGC_DIV'>" +
       "<label id='WHMXTGXWGC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAB:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XPSQTBKQQZ_DIV'>" +
       "<label id='XPSQTBKQQZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Città:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ESVLUSNYWB_DIV'>" +
       "<label id='ESVLUSNYWB'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_dessta)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TVSLWOCERI_DIV'>" +
       "<label id='TVSLWOCERI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cognome:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KUPYKSUBXV_DIV'>" +
       "<label id='KUPYKSUBXV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nome:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PRGSOG' id='GIZUBOQEKL' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_PRGSOG,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel PrimaryKeyLabel' id='BLRTTDWMJC_DIV'>" +
       "<label id='BLRTTDWMJC' for='GIZUBOQEKL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Progressivo Errore:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='CODCAB' id='WBGZOIFODE' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CODCAB,"C",6,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='6' fieldtype='C'>" +
      "");
      if (status.HasZoneAltInterface("Residenza@BEGIN") || status.HasZoneAltInterface("Residenza@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b1_CloseBand(armt_cgo_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Residenza@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Residenza")) {
      status.out.println("Ctrl('AQSQVBKXAL').style.height='auto';");
    } else {
      status.out.println("Ctrl('AQSQVBKXAL').setAttribute('band_height',145);");
    }
    status.out.println("Ctrl('AQSQVBKXAL').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_cgo_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_EWPTTWSBMT")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_EWPTTWSBMT' style='position:relative;height:2px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_EWPTTWSBMT")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_EWPTTWSBMT').style.height='auto';");
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
  void WriteControls_p1_b3(armt_cgo_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='PF' id='EWPTTWSBMT_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='EWPTTWSBMT_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='EWPTTWSBMT_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Nascita")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='EWPTTWSBMT_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"EWPTTWSBMT\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=EWPTTWSBMT_HEADER&m_cBoxId=EWPTTWSBMT&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Nascita"))+"");
    }
    status.out.println(
     "<div id='EWPTTWSBMT' class='SectionBody' style='position:relative;height:63px;display:block'>" +
    "");
    status.includeZoneAltInterface("PF@BEGIN");
    if (status.includeZoneAltInterface("PF")) {
      WriteControls_p1_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("PF@BEGIN") || status.HasZoneAltInterface("PF@END")) {
        status.out.println(
         "<div id='EWPTTWSBMT_boxContent' style='position:relative;height:63px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IDCITTANA' id='BYPEBFEOAJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_IDCITTANA,"C",40,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='40' size='40' fieldtype='C'>" +
       "<button id='BYPEBFEOAJ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "BYPEBFEOAJ", "tbcittna", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NASCOMUN' id='NEUBQNUEOJ' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_NASCOMUN,"C",30,0,"@!", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NASPROV' id='KPSCOABZLB' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_NASPROV,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='SESSO' id='QPALJZMFCL' class='"+status.ObligatoryClass("Combobox")+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("M","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("M",CPLib.Trim(BO.w_SESSO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Maschile")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("F","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("F",CPLib.Trim(BO.w_SESSO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Femminile")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('QPALJZMFCL'),w_SESSO,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NASSTATO' id='HODZKKOSYW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NASSTATO,"C",30,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C' autocomplete='off'>" +
       "<button id='HODZKKOSYW_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "HODZKKOSYW", "tbstatna", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATANASC' id='XMGRWGFSFV' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_DATANASC,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='XMGRWGFSFV_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WVJSUIKYEY_DIV'>" +
       "<label id='WVJSUIKYEY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Città di Nascita:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HZYTDOZFPI_DIV'>" +
       "<label id='HZYTDOZFPI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Nascita:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KRSCDPQZTQ_DIV'>" +
       "<label id='KRSCDPQZTQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sesso:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='IVAWYVSUQI_DIV'>" +
       "<label id='IVAWYVSUQI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Prov.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZBRDCBHLZC_DIV'>" +
       "<label id='ZBRDCBHLZC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato di Nascita:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("PF@BEGIN") || status.HasZoneAltInterface("PF@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b3_CloseBand(armt_cgo_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("PF@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("PF")) {
      status.out.println("Ctrl('EWPTTWSBMT').style.height='auto';");
    } else {
      status.out.println("Ctrl('EWPTTWSBMT').setAttribute('band_height',63);");
    }
    status.out.println("Ctrl('EWPTTWSBMT').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b4(armt_cgo_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_BLAIVNGHMW")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_BLAIVNGHMW' style='position:relative;height:2px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_BLAIVNGHMW")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_BLAIVNGHMW').style.height='auto';");
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
  void WriteControls_p1_b5(armt_cgo_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='PFDoc' id='BLAIVNGHMW_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='BLAIVNGHMW_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='BLAIVNGHMW_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Documento")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='BLAIVNGHMW_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"BLAIVNGHMW\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=BLAIVNGHMW_HEADER&m_cBoxId=BLAIVNGHMW&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Documento"))+"");
    }
    status.out.println(
     "<div id='BLAIVNGHMW' class='SectionBody' style='position:relative;height:63px;display:block'>" +
    "");
    status.includeZoneAltInterface("PFDoc@BEGIN");
    if (status.includeZoneAltInterface("PFDoc")) {
      WriteControls_p1_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("PFDoc@BEGIN") || status.HasZoneAltInterface("PFDoc@END")) {
        status.out.println(
         "<div id='BLAIVNGHMW_boxContent' style='position:relative;height:63px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPODOC' id='MBGANUUHRA' class='"+status.ObligatoryClass("Combobox")+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NUMDOCUM' id='HVEEMUJUUY' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_NUMDOCUM,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATARILASC' id='XHWYGOPPUN' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_DATARILASC,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='XHWYGOPPUN_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAVALI' id='BNWXBPSIDG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATAVALI,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='BNWXBPSIDG_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AUTRILASC' id='HRNCPADUFU' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_AUTRILASC,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YXFGMWZGNN_DIV'>" +
       "<label id='YXFGMWZGNN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Numero Doc.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZPQIEJPWJC_DIV'>" +
       "<label id='ZPQIEJPWJC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Autorità di rilascio:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YRARWMJPPV_DIV'>" +
       "<label id='YRARWMJPPV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Documento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MLJVDLOITR_DIV'>" +
       "<label id='MLJVDLOITR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Rilascio Doc.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UYGHJPRVKH_DIV'>" +
       "<label id='UYGHJPRVKH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Fine Validità:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("PFDoc@BEGIN") || status.HasZoneAltInterface("PFDoc@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b5_CloseBand(armt_cgo_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("PFDoc@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("PFDoc")) {
      status.out.println("Ctrl('BLAIVNGHMW').style.height='auto';");
    } else {
      status.out.println("Ctrl('BLAIVNGHMW').setAttribute('band_height',63);");
    }
    status.out.println("Ctrl('BLAIVNGHMW').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b6(armt_cgo_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_OQFTKYDCIW")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_OQFTKYDCIW' style='position:relative;height:2px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_OQFTKYDCIW")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_OQFTKYDCIW').style.height='auto';");
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
  void WriteControls_p1_b7(armt_cgo_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Chiave' id='OQFTKYDCIW_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='OQFTKYDCIW_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='OQFTKYDCIW_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Base")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='OQFTKYDCIW_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"OQFTKYDCIW\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=OQFTKYDCIW_HEADER&m_cBoxId=OQFTKYDCIW&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Base"))+"");
    }
    status.out.println(
     "<div id='OQFTKYDCIW' class='SectionBody' style='position:relative;height:33px;display:block'>" +
    "");
    status.includeZoneAltInterface("Chiave@BEGIN");
    if (status.includeZoneAltInterface("Chiave")) {
      WriteControls_p1_b7_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Chiave@BEGIN") || status.HasZoneAltInterface("Chiave@END")) {
        status.out.println(
         "<div id='OQFTKYDCIW_boxContent' style='position:relative;height:33px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CONNES' id='OJJHIUDPFY' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_CONNES,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WZDAFMDKJE_DIV'>" +
       "<label id='WZDAFMDKJE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='XFKXBQYUIU_DIV'>" +
       "<input name='PEP' id='XFKXBQYUIU' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_PEP,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_PEP))?"CHECKED":"")+">" +
       "<label id='XFKXBQYUIU_LBL' for='XFKXBQYUIU' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Persona Esposta Politicamente"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='AYCRVWSEMG_DIV'>" +
       "<input name='FLGFULL' id='AYCRVWSEMG' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGFULL,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGFULL))?"CHECKED":"")+">" +
       "<label id='AYCRVWSEMG_LBL' for='AYCRVWSEMG' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Correzione Completata"))+"</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Chiave@BEGIN") || status.HasZoneAltInterface("Chiave@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b7_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b7_CloseBand(armt_cgo_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Chiave@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Chiave")) {
      status.out.println("Ctrl('OQFTKYDCIW').style.height='auto';");
    } else {
      status.out.println("Ctrl('OQFTKYDCIW').setAttribute('band_height',33);");
    }
    status.out.println("Ctrl('OQFTKYDCIW').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b8(armt_cgo_personboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_MKZZTQTPHW")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_MKZZTQTPHW' style='position:relative;height:2px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_MKZZTQTPHW")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_MKZZTQTPHW').style.height='auto';");
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
  void WriteControls_p1_b9(armt_cgo_personboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Errori' id='MKZZTQTPHW_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='MKZZTQTPHW_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='MKZZTQTPHW_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Errori Rilevati")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='MKZZTQTPHW_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"MKZZTQTPHW\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=MKZZTQTPHW_HEADER&m_cBoxId=MKZZTQTPHW&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Errori Rilevati"))+"");
    }
    status.out.println(
     "<div id='MKZZTQTPHW' class='SectionBody' style='position:relative;height:142px;display:block'>" +
    "");
    status.includeZoneAltInterface("Errori@BEGIN");
    if (status.includeZoneAltInterface("Errori")) {
      WriteControls_p1_b9_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Errori@BEGIN") || status.HasZoneAltInterface("Errori@END")) {
        status.out.println(
         "<div id='MKZZTQTPHW_boxContent' style='position:relative;height:142px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<textarea name='TXTERR' id='TVQKRQXOUS' class='Memo' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' cols='20' rows='2'>" +
       "</textarea>" +
      "");
      if (status.HasZoneAltInterface("Errori@BEGIN") || status.HasZoneAltInterface("Errori@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b9_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b9_CloseBand(armt_cgo_personboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Errori@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Errori")) {
      status.out.println("Ctrl('MKZZTQTPHW').style.height='auto';");
    } else {
      status.out.println("Ctrl('MKZZTQTPHW').setAttribute('band_height',142);");
    }
    status.out.println("Ctrl('MKZZTQTPHW').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b10(armt_cgo_personboBO BO,ServletStatus status) {
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
  static void PrintState(armt_cgo_personboBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_cgo_personboBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
  }
  static void PrintStateWorkVars(armt_cgo_personboBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_COGNOME,"C",26,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOME,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CFESTERO,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PAESE,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCCIT,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINCIA,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAP,"C",9,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DOMICILIO,"C",35,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDCITTANA,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NASCOMUN,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NASPROV,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SESSO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NASSTATO,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATANASC,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPODOC,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMDOCUM,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATARILASC,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAVALI,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AUTRILASC,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNES,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PEP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TXTERR,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PRGSOG,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGFULL,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_nascomunid,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dessta,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCRI,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODCAB,"C",6,0));
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_cgo_personboBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_ESVLUSNYWB = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(566,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(797,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_cgo_personbo"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'YVIKEGPYPM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"YVIKEGPYPM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'ODAYKSRECA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ODAYKSRECA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'BYPEBFEOAJ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"BYPEBFEOAJ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcittna,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZRIWLTGERM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ZRIWLTGERM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcittna,"+"default",l_session)+"'"+"]");
      status.out.print(",'HODZKKOSYW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"HODZKKOSYW",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstatna,"+"default",l_session)+"'"+"]");
      status.out.print(",'MBGANUUHRA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"MBGANUUHRA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipdoc,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'YVIKEGPYPM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'ODAYKSRECA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'BYPEBFEOAJ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcittna,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZRIWLTGERM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcittna,"+"default",l_session)+"'"+"]");
      status.out.print(",'HODZKKOSYW':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstatna,"+"default",l_session)+"'"+"]");
      status.out.print(",'MBGANUUHRA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipdoc,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_cgo_personbo","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_cgo_personbo",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("Residenza"),"")) {
      status.quoteAndAppend("Residenza","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("PF"),"")) {
      status.quoteAndAppend("PF","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("PFDoc"),"")) {
      status.quoteAndAppend("PFDoc","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Chiave"),"")) {
      status.quoteAndAppend("Chiave","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Errori"),"")) {
      status.quoteAndAppend("Errori","hide","box");
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
  void WriteMainFormScript(armt_cgo_personboBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"Dati Base")) {
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_cgo_personbo',false);");
    } else {
      status.out.println("calculateSidebarBandsPosition('page_1');");
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('TWTTDWKCRG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WWGIVGNUDW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CZTHKEDVCO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YVIKEGPYPM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YVIKEGPYPM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ODAYKSRECA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ODAYKSRECA_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NOTZPDMYIA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RDAVOEETJG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VYLHWTRQNX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BYPEBFEOAJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BYPEBFEOAJ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NEUBQNUEOJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KPSCOABZLB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QPALJZMFCL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HODZKKOSYW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HODZKKOSYW_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XMGRWGFSFV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XMGRWGFSFV_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MBGANUUHRA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HVEEMUJUUY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XHWYGOPPUN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XHWYGOPPUN_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BNWXBPSIDG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BNWXBPSIDG_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HRNCPADUFU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OJJHIUDPFY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XFKXBQYUIU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TVQKRQXOUS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GIZUBOQEKL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AYCRVWSEMG')) SetDisabled(c,true);");
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
        status.out.println("if(c=Ctrl('GIZUBOQEKL')) SetDisabled(c,true);");
      }
    }
    status.out.println("FillCombosValues();");
    status.out.println("SetControlsValue();");
    status.out.println("NotifyEvent('Record Loaded');");
    if (status.HasFoundlingChildren()) {
      status.out.println("LoadContext();");
    }
    status.out.println("// * --- Area Manuale = UI - OnLoad End");
    status.out.println("// * --- armt_cgo_personbo");
    status.out.println("SetModified()");
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
  armt_cgo_personboBO getBO(ServletStatus status) {
    armt_cgo_personboBO BO = new armt_cgo_personboBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_cgo_personboBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("cgo_soggetti_err",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_cgo_personboBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_cgo_personboBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbtipdoc,CPSql.BuildSQLPhrase("TIPDOC,DESCRI",BO.m_cPhName_tbtipdoc,"","DESCRI"));
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",2,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("TIPDOC"),"C",2,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var MBGANUUHRA_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(armt_cgo_personboBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_cgo_soggetti_err;
    String l_cPhName = BO.m_cPhName_cgo_soggetti_err;
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
      String l_cQueryFilter = armt_cgo_personboBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_cgo_soggetti_err+".PRGSOG",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("cgo_soggetti_err");
    String l_cPhName = CPSql.ManipulateTablePhName("cgo_soggetti_err",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".PRGSOG",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,armt_cgo_personboBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_cgo_personboBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_cgo_soggetti_err,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_cgo_soggetti_err,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_cgo_personboBO BO) {
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
  void Edit(ServletStatus status,armt_cgo_personboBO BO,SPParameterSource source) {
    BO.Load(status.w_PRGSOG);
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
  void New(ServletStatus status,armt_cgo_personboBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_cgo_personboBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_cgo_personboBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_PRGSOG = "";
      } else {
        BO.w_PRGSOG = l_rsKeys.GetString("PRGSOG");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_PRGSOG = BO.w_PRGSOG;
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
  void EditLoad(ServletStatus status,armt_cgo_personboBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_cgo_personboBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_PRGSOG);
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
  void DeleteMessage(ServletStatus status,armt_cgo_personboBO BO,SPParameterSource source) {
    BO.Load(status.w_PRGSOG);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_cgo_personboBO BO) {
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({PRGSOG:"+SPLib.ToJSValue(BO.w_PRGSOG,"C",15,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
  void Discard(ServletStatus status,armt_cgo_personboBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_cgo_personboBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",466);
    item.put("w",797);
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
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Dati Base");
    item.put("altInterfaceFor","armt_cgo_personbo");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Residenza\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Residenza\",\"h\":145,\"name\":\"Residenza\",\"page\":1,\"shrinkable\":true,\"spuid\":\"AQSQVBKXAL\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Dati Residenza\",\"titled\":true,\"type\":\"Box\",\"w\":784,\"x\":8,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cognome\",\"h\":20,\"maxlength\":26,\"name\":\"COGNOME\",\"page\":1,\"spuid\":\"TWTTDWKCRG\",\"tabindex\":5,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":176,\"x\":128,\"y\":14,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome\",\"h\":20,\"maxlength\":25,\"name\":\"NOME\",\"page\":1,\"spuid\":\"WWGIVGNUDW\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":168,\"x\":352,\"y\":14,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TVSLWOCERI\",\"page\":1,\"spuid\":\"TVSLWOCERI\",\"tabindex\":45,\"type\":\"Label\",\"value\":\"Cognome:\",\"w\":56,\"x\":69,\"y\":18,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KUPYKSUBXV\",\"page\":1,\"spuid\":\"KUPYKSUBXV\",\"tabindex\":46,\"type\":\"Label\",\"value\":\"Nome:\",\"w\":35,\"x\":316,\"y\":18,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Codice Fiscale Estero\",\"h\":21,\"label_text\":\"Codice Fiscale non attribuito dall"+"'"+"Agenzia delle Entrate (p.es. Sogg. Estero senza stabile organizz. o attivit\\u00E0 in Italia)\",\"maxlength\":2,\"name\":\"CFESTERO\",\"page\":1,\"spuid\":\"CZTHKEDVCO\",\"tabindex\":7,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":575,\"x\":128,\"y\":39,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Progressivo Errore\",\"h\":20,\"maxlength\":15,\"name\":\"PRGSOG\",\"page\":1,\"spuid\":\"GIZUBOQEKL\",\"tabindex\":50,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":96,\"x\":680,\"y\":14,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BLRTTDWMJC\",\"page\":1,\"spuid\":\"BLRTTDWMJC\",\"tabindex\":51,\"type\":\"Label\",\"value\":\"Progressivo Errore:\",\"w\":93,\"x\":587,\"y\":18,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Stato\",\"h\":20,\"maxlength\":3,\"name\":\"PAESE\",\"page\":1,\"picker\":true,\"spuid\":\"YVIKEGPYPM\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":128,\"y\":64,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RZBLEGCFJJ\",\"page\":1,\"spuid\":\"RZBLEGCFJJ\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"Stato:\",\"w\":36,\"x\":88,\"y\":68,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_ESVLUSNYWB\",\"page\":1,\"spuid\":\"ESVLUSNYWB\",\"tabindex\":42,\"type\":\"Label\",\"w\":323,\"x\":191,\"y\":68,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Citt\\u00E0\",\"h\":20,\"maxlength\":30,\"name\":\"DESCCIT\",\"page\":1,\"picker\":true,\"spuid\":\"ODAYKSRECA\",\"tabindex\":9,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":280,\"x\":128,\"y\":91,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia\",\"h\":20,\"maxlength\":2,\"name\":\"PROVINCIA\",\"page\":1,\"spuid\":\"NOTZPDMYIA\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":528,\"y\":91,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAP\",\"h\":20,\"maxlength\":9,\"name\":\"CAP\",\"page\":1,\"spuid\":\"RDAVOEETJG\",\"tabindex\":11,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":66,\"x\":600,\"y\":91,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SBJQIAQUCN\",\"page\":1,\"spuid\":\"SBJQIAQUCN\",\"tabindex\":31,\"type\":\"Label\",\"value\":\"Provincia:\",\"w\":52,\"x\":472,\"y\":95,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GDOCAGKROT\",\"page\":1,\"spuid\":\"GDOCAGKROT\",\"tabindex\":34,\"type\":\"Label\",\"value\":\"CAP:\",\"w\":30,\"x\":568,\"y\":95,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WHMXTGXWGC\",\"page\":1,\"spuid\":\"WHMXTGXWGC\",\"tabindex\":35,\"type\":\"Label\",\"value\":\"CAB:\",\"w\":27,\"x\":676,\"y\":95,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XPSQTBKQQZ\",\"page\":1,\"spuid\":\"XPSQTBKQQZ\",\"tabindex\":39,\"type\":\"Label\",\"value\":\"Citt\\u00E0:\",\"w\":70,\"x\":55,\"y\":95,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAB\",\"disabled\":\"true\",\"h\":20,\"maxlength\":6,\"name\":\"CODCAB\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"WBGZOIFODE\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":704,\"y\":92,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Indirizzo\",\"h\":20,\"maxlength\":35,\"name\":\"DOMICILIO\",\"page\":1,\"spuid\":\"VYLHWTRQNX\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":222,\"x\":128,\"y\":119,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TWTXGZJTAR\",\"page\":1,\"spuid\":\"TWTXGZJTAR\",\"tabindex\":33,\"type\":\"Label\",\"value\":\"Indirizzo:\",\"w\":47,\"x\":78,\"y\":123,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"PF\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Nascita\",\"h\":63,\"name\":\"PF\",\"page\":1,\"shrinkable\":true,\"spuid\":\"EWPTTWSBMT\",\"stretch\":true,\"tabindex\":2,\"title_caption\":\"Dati Nascita\",\"titled\":true,\"type\":\"Box\",\"w\":784,\"x\":8,\"y\":154,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"ID CItta Nascita\",\"h\":20,\"maxlength\":40,\"name\":\"IDCITTANA\",\"page\":1,\"picker\":true,\"spuid\":\"BYPEBFEOAJ\",\"tabindex\":13,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":252,\"x\":128,\"y\":160,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Luogo di Nascita\",\"h\":20,\"maxlength\":30,\"name\":\"NASCOMUN\",\"page\":1,\"spuid\":\"NEUBQNUEOJ\",\"tabindex\":15,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":222,\"x\":408,\"y\":160,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia di nascita (EE se nato estero)\",\"h\":20,\"maxlength\":2,\"name\":\"NASPROV\",\"page\":1,\"spuid\":\"KPSCOABZLB\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":744,\"y\":160,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WVJSUIKYEY\",\"page\":1,\"spuid\":\"WVJSUIKYEY\",\"tabindex\":26,\"type\":\"Label\",\"value\":\"Citt\\u00E0 di Nascita:\",\"w\":101,\"x\":24,\"y\":164,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IVAWYVSUQI\",\"page\":1,\"spuid\":\"IVAWYVSUQI\",\"tabindex\":40,\"type\":\"Label\",\"value\":\"Prov.:\",\"w\":32,\"x\":712,\"y\":164,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Sesso\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"SESSO\",\"page\":1,\"spuid\":\"QPALJZMFCL\",\"tabindex\":17,\"textlist\":\"Maschile,Femminile\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"M"+"'"+","+"'"+"F"+"'"+"\",\"w\":104,\"x\":672,\"y\":192,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Stato di nascita\",\"h\":20,\"maxlength\":30,\"name\":\"NASSTATO\",\"page\":1,\"picker\":true,\"spuid\":\"HODZKKOSYW\",\"tabindex\":18,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":222,\"x\":128,\"y\":189,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Nascita\",\"h\":20,\"maxlength\":10,\"name\":\"DATANASC\",\"page\":1,\"picker\":true,\"spuid\":\"XMGRWGFSFV\",\"tabindex\":19,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":86,\"x\":472,\"y\":192,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HZYTDOZFPI\",\"page\":1,\"spuid\":\"HZYTDOZFPI\",\"tabindex\":28,\"type\":\"Label\",\"value\":\"Data Nascita:\",\"w\":74,\"x\":395,\"y\":196,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KRSCDPQZTQ\",\"page\":1,\"spuid\":\"KRSCDPQZTQ\",\"tabindex\":38,\"type\":\"Label\",\"value\":\"Sesso:\",\"w\":39,\"x\":630,\"y\":196,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZBRDCBHLZC\",\"page\":1,\"spuid\":\"ZBRDCBHLZC\",\"tabindex\":44,\"type\":\"Label\",\"value\":\"Stato di Nascita:\",\"w\":101,\"x\":24,\"y\":193,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"PFDoc\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Documento\",\"h\":63,\"name\":\"PFDoc\",\"page\":1,\"shrinkable\":true,\"spuid\":\"BLAIVNGHMW\",\"stretch\":true,\"tabindex\":3,\"title_caption\":\"Dati Documento\",\"titled\":true,\"type\":\"Box\",\"w\":784,\"x\":8,\"y\":219,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo Documento\",\"h\":20,\"maxlength\":2,\"name\":\"TIPODOC\",\"page\":1,\"spuid\":\"MBGANUUHRA\",\"tabindex\":20,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":246,\"x\":128,\"y\":226,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YRARWMJPPV\",\"page\":1,\"spuid\":\"YRARWMJPPV\",\"tabindex\":36,\"type\":\"Label\",\"value\":\"Tipo Documento:\",\"w\":127,\"x\":0,\"y\":230,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero Doc.\",\"h\":20,\"maxlength\":15,\"name\":\"NUMDOCUM\",\"page\":1,\"spuid\":\"HVEEMUJUUY\",\"tabindex\":21,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":552,\"y\":226,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YXFGMWZGNN\",\"page\":1,\"spuid\":\"YXFGMWZGNN\",\"tabindex\":27,\"type\":\"Label\",\"value\":\"Numero Doc.:\",\"w\":101,\"x\":448,\"y\":230,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Rilascio Doc.\",\"h\":20,\"maxlength\":10,\"name\":\"DATARILASC\",\"page\":1,\"picker\":true,\"spuid\":\"XHWYGOPPUN\",\"tabindex\":22,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":86,\"x\":128,\"y\":254,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":10,\"name\":\"DATAVALI\",\"page\":1,\"picker\":true,\"spuid\":\"BNWXBPSIDG\",\"tabindex\":23,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":86,\"x\":336,\"y\":254,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Autorit\\u00E0 di rilascio\",\"h\":20,\"maxlength\":30,\"name\":\"AUTRILASC\",\"page\":1,\"spuid\":\"HRNCPADUFU\",\"tabindex\":24,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":232,\"x\":552,\"y\":254,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZPQIEJPWJC\",\"page\":1,\"spuid\":\"ZPQIEJPWJC\",\"tabindex\":30,\"type\":\"Label\",\"value\":\"Autorit\\u00E0 di rilascio:\",\"w\":100,\"x\":451,\"y\":258,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MLJVDLOITR\",\"page\":1,\"spuid\":\"MLJVDLOITR\",\"tabindex\":37,\"type\":\"Label\",\"value\":\"Rilascio Doc.:\",\"w\":101,\"x\":24,\"y\":258,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UYGHJPRVKH\",\"page\":1,\"spuid\":\"UYGHJPRVKH\",\"tabindex\":43,\"type\":\"Label\",\"value\":\"Data Fine Validit\\u00E0:\",\"w\":101,\"x\":232,\"y\":258,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Chiave\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Base\",\"h\":33,\"name\":\"Chiave\",\"page\":1,\"shrinkable\":true,\"spuid\":\"OQFTKYDCIW\",\"stretch\":true,\"tabindex\":4,\"title_caption\":\"Dati Base\",\"titled\":true,\"type\":\"Box\",\"w\":784,\"x\":8,\"y\":284,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"Codice Fiscale\",\"h\":20,\"maxlength\":16,\"name\":\"CONNES\",\"page\":1,\"spuid\":\"OJJHIUDPFY\",\"tabindex\":25,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":128,\"x\":128,\"y\":289,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WZDAFMDKJE\",\"page\":1,\"spuid\":\"WZDAFMDKJE\",\"tabindex\":29,\"type\":\"Label\",\"value\":\"Codice Fiscale:\",\"w\":85,\"x\":40,\"y\":293,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Persona Politicamente Esposta\",\"h\":21,\"label_text\":\"Persona Esposta Politicamente\",\"maxlength\":1,\"name\":\"PEP\",\"page\":1,\"spuid\":\"XFKXBQYUIU\",\"tabindex\":47,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":190,\"x\":312,\"y\":289,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Completo\",\"h\":21,\"label_text\":\"Correzione Completata\",\"maxlength\":1,\"name\":\"FLGFULL\",\"page\":1,\"spuid\":\"AYCRVWSEMG\",\"tabindex\":52,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":146,\"x\":552,\"y\":289,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Errori\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Errori Rilevati\",\"h\":142,\"name\":\"Errori\",\"page\":1,\"shrinkable\":true,\"spuid\":\"MKZZTQTPHW\",\"stretch\":true,\"tabindex\":48,\"title_caption\":\"Errori Rilevati\",\"titled\":true,\"type\":\"Box\",\"w\":784,\"x\":8,\"y\":319,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errori\",\"h\":128,\"name\":\"TXTERR\",\"page\":1,\"scroll\":true,\"spuid\":\"TVQKRQXOUS\",\"tabindex\":49,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":768,\"x\":16,\"y\":325,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_cgo_personboBO BO,ServletStatus status) {
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
     "<script src='armt_cgo_personbo?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_personbo_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_personbo_edit.js'>" +
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
      status.out.println("w_COGNOME=a[0];");
      status.out.println("w_NOME=a[1];");
      status.out.println("w_CFESTERO=a[2];");
      status.out.println("w_PAESE=a[3];");
      status.out.println("w_DESCCIT=a[4];");
      status.out.println("w_PROVINCIA=a[5];");
      status.out.println("w_CAP=a[6];");
      status.out.println("w_DOMICILIO=a[7];");
      status.out.println("w_IDCITTANA=a[8];");
      status.out.println("w_NASCOMUN=a[9];");
      status.out.println("w_NASPROV=a[10];");
      status.out.println("w_SESSO=a[11];");
      status.out.println("w_NASSTATO=a[12];");
      status.out.println("w_DATANASC=a[13];");
      status.out.println("w_TIPODOC=a[14];");
      status.out.println("w_NUMDOCUM=a[15];");
      status.out.println("w_DATARILASC=a[16];");
      status.out.println("w_DATAVALI=a[17];");
      status.out.println("w_AUTRILASC=a[18];");
      status.out.println("w_CONNES=a[19];");
      status.out.println("w_PEP=a[20];");
      status.out.println("w_TXTERR=a[21];");
      status.out.println("w_PRGSOG=a[22];");
      status.out.println("w_FLGFULL=a[23];");
      status.out.println("w_nascomunid=a[24];");
      status.out.println("w_dessta=a[25];");
      status.out.println("w_DESCRI=a[26];");
      status.out.println("w_CODCAB=a[27];");
      status.out.println("if (Gt(a.length,28)) {");
      status.out.println("o_COGNOME=w_COGNOME;");
      status.out.println("o_NOME=w_NOME;");
      status.out.println("o_PAESE=w_PAESE;");
      status.out.println("o_DESCCIT=w_DESCCIT;");
      status.out.println("o_IDCITTANA=w_IDCITTANA;");
      status.out.println("o_NASSTATO=w_NASSTATO;");
      status.out.println("o_DATANASC=w_DATANASC;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['PRGSOG'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_personbo_proc.js'>" +
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
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"Dati Base")) {
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
    status.themeWriter.WriteBody_Begin(566,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","cgo_soggetti_err");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","PRGSOG");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(armt_cgo_personboBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({PRGSOG:"+SPLib.ToJSValue(BO.w_PRGSOG,"C",15,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_cgo_personboBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({PRGSOG:"+SPLib.ToJSValue(BO.w_PRGSOG,"C",15,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armt_cgo_personboBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({PRGSOG:"+SPLib.ToJSValue(BO.w_PRGSOG,"C",15,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armt_cgo_personboBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({PRGSOG:"+SPLib.ToJSValue(BO.w_PRGSOG,"C",15,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armt_cgo_personboBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({PRGSOG:"+SPLib.ToJSValue(BO.w_PRGSOG,"C",15,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_cgo_personboBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_cgo_personboBO BO,ServletStatus status) throws IOException {
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
     "<script src='SPPrxy/"+arfn_agechar.m_cEntityUid+"/arfn_agechar.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_cgo_calccodfis.m_cEntityUid+"/arfn_cgo_calccodfis.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chkcodfis.m_cEntityUid+"/arfn_chkcodfis.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arrt_calccodfis.m_cEntityUid+"/arrt_calccodfis.js'>" +
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
      arfn_agechar.GetCallableNames(callable);
      arfn_cgo_calccodfis.GetCallableNames(callable);
      arfn_chkcodfis.GetCallableNames(callable);
      arrt_calccodfis.GetCallableNames(callable);
      CPLib.AddToSet(callable,"Utilities");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_cgo_personboBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_PRGSOG),"C",15,0));
      }
    } else if (CPLib.eq(p_cUID,"YVIKEGPYPM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ODAYKSRECA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"BYPEBFEOAJ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ZRIWLTGERM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"HODZKKOSYW")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"MBGANUUHRA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_cgo_personboBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_PAESE))) {
        a = GetCheckVars(status,BO,"YVIKEGPYPM");
        b = status.m_CheckVars.optString("YVIKEGPYPM");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_TIPODOC))) {
        a = GetCheckVars(status,BO,"MBGANUUHRA");
        b = status.m_CheckVars.optString("MBGANUUHRA");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
