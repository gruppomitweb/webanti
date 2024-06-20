import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_personbo_agg extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*9886904b*!";
  static public class ServletStatus extends SPMasterChildServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "personbo_agg";
    }
    public String w_CONNES;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_CONNES,context,"personbo_agg","CONNES","C",16,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='CONNES' type='hidden' value="+SPLib.ToHTMLValue(w_CONNES,"C",16,0)+">" +
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
    armt_personbo_aggBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_personbo_agg;
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
      status.w_CONNES = BO.w_CONNES;
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
    return "Dati Aggiuntivi soggetti";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_personbo_agg";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 1016;
    l_eg.m_nEntityHeight = 495;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"personbo_agg","tbstati","tbcateg01","tbcateg02","tbcateg03","tbcateg04","tbcateg05"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page"),new ZoneItem("Categorie","Categorie","horizontal_section"),new ZoneItem("SocRev","Fattori di Rischio","horizontal_section")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"CONNES"};
    l_eg.items = new SPItem[]{
                   new SPItem("gTipInter","C",2,0, "hide","Tipo Intermediario"),
                   new SPItem("CONNES","C",16,0, "hide","Codice Cliente"),
                   new SPItem("EMAIL","C",50,0, "edit","EMAIL"),
                   new SPItem("FLGEMAIL","C",1,0, "edit","Flag EMAIL"),
                   new SPItem("TELEFONO","C",50,0, "edit","Telefono"),
                   new SPItem("FLGVALIDO","C",1,0, "edit","Codice Fiscale Validato"),
                   new SPItem("FLGANAVAL","C",1,0, "edit","Dati Anagrafici Validati"),
                   new SPItem("CLOCCUPA","N",3,0, "edit","Occupazione"),
                   new SPItem("NAZIONE","C",3,0, "edit","Nazionalità"),
                   new SPItem("xDesNaz","C",40,0, "hide","Descrizione"),
                   new SPItem("CLPRVDOM","C",2,0, "edit","Provincia Domicilio"),
                   new SPItem("REGRES","C",2,0, "edit","Regione Residenza"),
                   new SPItem("FLGBL","C",1,0, "edit","BlackList "),
                   new SPItem("CATEG01","C",2,0, "edit","Categoria 1"),
                   new SPItem("CATEG02","C",2,0, "edit","Categoria 2"),
                   new SPItem("CATEG03","C",2,0, "edit","Categoria 3"),
                   new SPItem("CATEG04","C",2,0, "edit","Categoria 1"),
                   new SPItem("CATEG05","C",2,0, "edit","Categoria 1"),
                   new SPItem("xC1DESCRI","C",80,0, "hide","Descrizione"),
                   new SPItem("xC2DESCRI","C",80,0, "hide","Descrizione"),
                   new SPItem("xC3DESCRI","C",80,0, "hide","Descrizione"),
                   new SPItem("xC4DESCRI","C",80,0, "hide","Descrizione"),
                   new SPItem("xC5DESCRI","C",80,0, "hide","Descrizione"),
                   new SPItem("FLGPREGIUD","C",1,0, "edit","Pregiudizievole"),
                   new SPItem("FLGTRUST","C",1,0, "edit","Trust"),
                   new SPItem("FLGRISCHIO","C",1,0, "edit","Cliente con attività in paesi a rischio"),
                   new SPItem("FLGFALSADIC","C",1,0, "edit","Falsa dichiarazione"),
                   new SPItem("FLGEQUIFIN","C",1,0, "edit","Equilibrio Finanziario"),
                   new SPItem("FLGRICINF","C",1,0, "edit","Richiamo di Informativa"),
                   new SPItem("CATEGORIA","C",10,0, "hide","Categoria"),
                   new SPItem("NUMCEL","C",15,0, "edit","Cellulare"),
                   new SPItem("EMAIL","M",10,0, "edit","EMAIL"),
                   new SPItem("PEC","C",50,0, "edit","PEC"),
                   new SPItem("REFERENTE","C",50,0, "edit","Referente"),
                   new SPItem("CONALTO","N",1,0, "edit","Connesso con attività a rischio"),
                   new SPItem("APPALTO","N",1,0, "edit","Prevalente attività in appalti pubblici")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_personbo_aggBO BO) {
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
    l_translations=new String[][]{{"10021363378",p_Context.Translate("Connesso con attività a rischio")},
    {"10061745855",p_Context.Translate("Dati Anagrafici Validati")},
    {"10195722547",p_Context.Translate("Provincia Domicilio")},
    {"10354796574",p_Context.Translate("Prevalente attività in appalti pubblici")},
    {"10659481672",p_Context.Translate("Equilibrio Finanziario")},
    {"10964299298",p_Context.Translate("Cliente con attività in paesi a rischio")},
    {"11261912825",p_Context.Translate("Referente")},
    {"11640916362",p_Context.Translate("BlackList ")},
    {"116493960",p_Context.Translate("Falsa dichiarazione")},
    {"1174748321",p_Context.Translate("Dati Anagrafici Validati da AGE")},
    {"12000724895",p_Context.Translate("Codice Fiscale Validato da AGE")},
    {"12009320712",p_Context.Translate("Cellulare")},
    {"12078005779",p_Context.Translate("Codice Fiscale Validato")},
    {"12129590363",p_Context.Translate("Regione Residenza")},
    {"131795838",p_Context.Translate("possibile inviare messaggi per EMail")},
    {"1471389296",p_Context.Translate("Dati Aggiuntivi soggetti")},
    {"1569015599",p_Context.Translate("Codice Cliente")},
    {"157141684",p_Context.Translate("Categoria")},
    {"157154740",p_Context.Translate("Categoria 1")},
    {"157154996",p_Context.Translate("Categoria 2")},
    {"157155252",p_Context.Translate("Categoria 3")},
    {"157155508",p_Context.Translate("Categoria 4")},
    {"157155764",p_Context.Translate("Categoria 5")},
    {"1635179791",p_Context.Translate("Flag EMAIL")},
    {"1700577956",p_Context.Translate("Telefono")},
    {"1744218234",p_Context.Translate("Pregiudizievole")},
    {"1797543475",p_Context.Translate("Black List Interna")},
    {"18336",p_Context.Translate("PEC")},
    {"277358030",p_Context.Translate("Occupazione")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"5297685",p_Context.Translate("EMAIL")},
    {"676788231",p_Context.Translate("Nazionalità")},
    {"695992708",p_Context.Translate("Richiamo di Informativa")},
    {"7383187",p_Context.Translate("Stati")},
    {"8105076",p_Context.Translate("Trust")},
    {"984756930",p_Context.Translate("Tipo Intermediario")}};
    return l_translations;
  }
  void WriteStyles(armt_personbo_aggBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_personbo_agg.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_personbo_aggBO BO,ServletStatus status) {
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
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_personbo_agg',true);");
    }
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_personbo_agg",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(armt_personbo_aggBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,2);
  }
  void WriteControls_p1(armt_personbo_aggBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:495px;width:1016px;display:none'>" +
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
  void WriteControls_p1_b0(armt_personbo_aggBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_1' style='position:relative;height:255px;display:block' page='1'>" +
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
       "<input name='EMAIL' id='DBFIZRPONS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_EMAIL,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PFHITGLPYJ_DIV'>" +
       "<label id='PFHITGLPYJ' for='DBFIZRPONS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("EMAIL:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='JYNIHKHNSF_DIV'>" +
       "<input name='FLGEMAIL' id='JYNIHKHNSF' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGEMAIL,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGEMAIL))?"CHECKED":"")+">" +
       "<label id='JYNIHKHNSF_LBL' for='JYNIHKHNSF' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("possibile inviare messaggi per EMail"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='TELEFONO' id='TZSFXOGJGG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TELEFONO,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ELIBEIUTYO_DIV'>" +
       "<label id='ELIBEIUTYO' for='TZSFXOGJGG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Telefono:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='LMZAVCTIKT_DIV'>" +
       "<input name='FLGVALIDO' id='LMZAVCTIKT' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGVALIDO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGVALIDO))?"CHECKED":"")+">" +
       "<label id='LMZAVCTIKT_LBL' for='LMZAVCTIKT' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale Validato da AGE"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='HAONGEKSUB_DIV'>" +
       "<input name='FLGANAVAL' id='HAONGEKSUB' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGANAVAL,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGANAVAL))?"CHECKED":"")+">" +
       "<label id='HAONGEKSUB_LBL' for='HAONGEKSUB' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Dati Anagrafici Validati da AGE"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CLOCCUPA' id='FYSLTMPLOV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CLOCCUPA,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VSLFLTAORI_DIV'>" +
       "<label id='VSLFLTAORI' for='FYSLTMPLOV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Occupazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NAZIONE' id='BGFCAXGJBL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NAZIONE,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='BGFCAXGJBL_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "BGFCAXGJBL", "tbstati", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RXOQQWNFRG_DIV'>" +
       "<label id='RXOQQWNFRG' for='BGFCAXGJBL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nazionalità:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FYLIIHUTPH_DIV'>" +
       "<label id='FYLIIHUTPH'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xDesNaz)+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CLPRVDOM' id='NIRLEZVFLW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CLPRVDOM,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='REGRES' id='CBYSBUCJMV' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("00","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("00",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Estero")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("01","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("01",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Abruzzo")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("02","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("02",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Basilicata")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("03","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("03",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Calabria")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("04","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("04",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Campegna")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("05","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("05",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Emilia-Romagna")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("06","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("06",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Friuli-Venezia Giulia")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("07","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("07",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Lazio")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("08","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("08",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Liguria")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("09","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("09",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Lombardia")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("10","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("10",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Marche")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("11","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("11",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Molise")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("12","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("12",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Piemonte")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("13","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("13",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Puglia")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("14","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("14",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Sardegna")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("15","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("15",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Sicilia")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("16","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("16",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Toscana")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("17","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("17",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Trentino-Alto Adige")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("18","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("18",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Umbria")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("19","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("19",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Valle d'Aosta")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("20","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("20",CPLib.Trim(BO.w_REGRES))?"SELECTED":"")+">" +
       ""+status.context.Translate("Veneto")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('CBYSBUCJMV'),w_REGRES,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RKPADAREKN_DIV'>" +
       "<label id='RKPADAREKN' for='NIRLEZVFLW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Prov. Domicilio:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HJQTMOWJVN_DIV'>" +
       "<label id='HJQTMOWJVN' for='CBYSBUCJMV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Regione Residenza:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='URHHMCUEEA_DIV'>" +
       "<input name='FLGBL' id='URHHMCUEEA' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGBL,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGBL))?"CHECKED":"")+">" +
       "<label id='URHHMCUEEA_LBL' for='URHHMCUEEA' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Black List Interna"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NUMCEL' id='HHZVXHZWFT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NUMCEL,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='USQLSETBFB_DIV'>" +
       "<label id='USQLSETBFB' for='HHZVXHZWFT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cellulare:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<textarea name='EMAIL' id='CJLHZBPFZE' class='Memo' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' cols='20' rows='2'>" +
       "</textarea>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NMMOYAZYFJ_DIV'>" +
       "<label id='NMMOYAZYFJ' for='CJLHZBPFZE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("EMAIL:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PEC' id='PYRPYRCHAE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PEC,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GIUWNGWRYA_DIV'>" +
       "<label id='GIUWNGWRYA' for='PYRPYRCHAE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("PEC:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='REFERENTE' id='DRSQJFIQWH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_REFERENTE,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PNNBAMJIYZ_DIV'>" +
       "<label id='PNNBAMJIYZ' for='DRSQJFIQWH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Referente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b1(armt_personbo_aggBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Categorie' id='RFAIYHSGII_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='RFAIYHSGII_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='RFAIYHSGII_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Categorie")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='RFAIYHSGII_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"RFAIYHSGII\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=RFAIYHSGII_HEADER&m_cBoxId=RFAIYHSGII&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Categorie"))+"");
    }
    status.out.println(
     "<div id='RFAIYHSGII' class='SectionBody' style='position:relative;height:126px;display:block'>" +
    "");
    status.includeZoneAltInterface("Categorie@BEGIN");
    if (status.includeZoneAltInterface("Categorie")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Categorie@BEGIN") || status.HasZoneAltInterface("Categorie@END")) {
        status.out.println(
         "<div id='RFAIYHSGII_boxContent' style='position:relative;height:126px;display:block'>" +
        "");
      }
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CATEG01' id='CANUTVNGFD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CATEG01,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
       "<button id='CANUTVNGFD_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "CANUTVNGFD", "tbcateg01", "opemt_tbcateg01", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NRWNAJJVRA_DIV'>" +
       "<label id='NRWNAJJVRA'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xC1DESCRI)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WWRYOVTMFY_DIV'>" +
       "<label id='WWRYOVTMFY' for='CANUTVNGFD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Categoria 1:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CATEG02' id='IXGRJLAKIQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CATEG02,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
       "<button id='IXGRJLAKIQ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "IXGRJLAKIQ", "tbcateg02", "opemt_tbcateg02", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LNOFOPAOYD_DIV'>" +
       "<label id='LNOFOPAOYD'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xC2DESCRI)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HNQZARYXGS_DIV'>" +
       "<label id='HNQZARYXGS' for='IXGRJLAKIQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Categoria 2:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CATEG03' id='NKIXCWZJHO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CATEG03,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
       "<button id='NKIXCWZJHO_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "NKIXCWZJHO", "tbcateg03", "opemt_tbcateg03", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WBTKNDJDFF_DIV'>" +
       "<label id='WBTKNDJDFF'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xC3DESCRI)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BGEVFUGGOS_DIV'>" +
       "<label id='BGEVFUGGOS' for='NKIXCWZJHO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Categoria 3:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CATEG04' id='JQLGHMLOKO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CATEG04,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
       "<button id='JQLGHMLOKO_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "JQLGHMLOKO", "tbcateg04", "opemt_tbcateg04", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MWCFKQVNHF_DIV'>" +
       "<label id='MWCFKQVNHF'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xC4DESCRI)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RHXCIUHRTU_DIV'>" +
       "<label id='RHXCIUHRTU' for='JQLGHMLOKO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Categoria 4:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CATEG05' id='QVBZSFMTVP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CATEG05,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
       "<button id='QVBZSFMTVP_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "QVBZSFMTVP", "tbcateg05", "opemt_tbcateg05", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HADVHTQAPE_DIV'>" +
       "<label id='HADVHTQAPE'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xC5DESCRI)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GRCYFEKJWU_DIV'>" +
       "<label id='GRCYFEKJWU' for='QVBZSFMTVP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Categoria 5:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Categorie@BEGIN") || status.HasZoneAltInterface("Categorie@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b1_CloseBand(armt_personbo_aggBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Categorie@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Categorie")) {
      status.out.println("Ctrl('RFAIYHSGII').style.height='auto';");
    } else {
      status.out.println("Ctrl('RFAIYHSGII').setAttribute('band_height',126);");
    }
    status.out.println("Ctrl('RFAIYHSGII').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_personbo_aggBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_YFAFHIMHLC")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_YFAFHIMHLC' style='position:relative;height:1px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_YFAFHIMHLC")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_YFAFHIMHLC').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b3(armt_personbo_aggBO BO,ServletStatus status) {
    status.out.println(
     "<div name='SocRev' id='YFAFHIMHLC_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='YFAFHIMHLC_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='YFAFHIMHLC_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Fattori di Rischio")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='YFAFHIMHLC_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"YFAFHIMHLC\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=YFAFHIMHLC_HEADER&m_cBoxId=YFAFHIMHLC&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Fattori di Rischio"))+"");
    }
    status.out.println(
     "<div id='YFAFHIMHLC' class='SectionBody' style='position:relative;height:73px;display:block'>" +
    "");
    status.includeZoneAltInterface("SocRev@BEGIN");
    if (status.includeZoneAltInterface("SocRev")) {
      WriteControls_p1_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("SocRev@BEGIN") || status.HasZoneAltInterface("SocRev@END")) {
        status.out.println(
         "<div id='YFAFHIMHLC_boxContent' style='position:relative;height:73px;display:block'>" +
        "");
      }
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='SEUBTYJEKC_DIV'>" +
       "<input name='FLGPREGIUD' id='SEUBTYJEKC' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGPREGIUD,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGPREGIUD))?"CHECKED":"")+">" +
       "<label id='SEUBTYJEKC_LBL' for='SEUBTYJEKC' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Pregiudizievole"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='AIXHBUOLOH_DIV'>" +
       "<input name='FLGTRUST' id='AIXHBUOLOH' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGTRUST,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGTRUST))?"CHECKED":"")+">" +
       "<label id='AIXHBUOLOH_LBL' for='AIXHBUOLOH' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Trust"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='RJATPPKQJX_DIV'>" +
       "<input name='FLGRISCHIO' id='RJATPPKQJX' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGRISCHIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGRISCHIO))?"CHECKED":"")+">" +
       "<label id='RJATPPKQJX_LBL' for='RJATPPKQJX' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Cliente con attività in paesi a rischio"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='BFAZVGKRMM_DIV'>" +
       "<input name='FLGFALSADIC' id='BFAZVGKRMM' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGFALSADIC,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGFALSADIC))?"CHECKED":"")+">" +
       "<label id='BFAZVGKRMM_LBL' for='BFAZVGKRMM' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Falsa dichiarazione"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='TYXOFHIXSZ_DIV'>" +
       "<input name='FLGEQUIFIN' id='TYXOFHIXSZ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGEQUIFIN,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGEQUIFIN))?"CHECKED":"")+">" +
       "<label id='TYXOFHIXSZ_LBL' for='TYXOFHIXSZ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Equilibrio Finanziario"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='ONGFHKWFDC_DIV'>" +
       "<input name='FLGRICINF' id='ONGFHKWFDC' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGRICINF,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGRICINF))?"CHECKED":"")+">" +
       "<label id='ONGFHKWFDC_LBL' for='ONGFHKWFDC' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Richiamo di Informativa"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='XFXZVUBUON_DIV'>" +
       "<input name='CONALTO' id='XFXZVUBUON' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_CONALTO,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_CONALTO)?"CHECKED":"")+">" +
       "<label id='XFXZVUBUON_LBL' for='XFXZVUBUON' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Connesso con attività a rischio"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='GYAJLZIGMO_DIV'>" +
       "<input name='APPALTO' id='GYAJLZIGMO' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_APPALTO,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_APPALTO)?"CHECKED":"")+">" +
       "<label id='GYAJLZIGMO_LBL' for='GYAJLZIGMO' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Prevalente attività in appalti pubblici"))+"</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("SocRev@BEGIN") || status.HasZoneAltInterface("SocRev@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b3_CloseBand(armt_personbo_aggBO BO,ServletStatus status) {
    status.includeZoneAltInterface("SocRev@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("SocRev")) {
      status.out.println("Ctrl('YFAFHIMHLC').style.height='auto';");
    } else {
      status.out.println("Ctrl('YFAFHIMHLC').setAttribute('band_height',73);");
    }
    status.out.println("Ctrl('YFAFHIMHLC').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b4(armt_personbo_aggBO BO,ServletStatus status) {
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
  static void PrintState(armt_personbo_aggBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_personbo_aggBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
  }
  static void PrintStateWorkVars(armt_personbo_aggBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_CONNES,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_EMAIL,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGEMAIL,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TELEFONO,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGVALIDO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGANAVAL,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CLOCCUPA,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NAZIONE,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CLPRVDOM,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_REGRES,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGBL,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CATEG01,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CATEG02,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CATEG03,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CATEG04,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CATEG05,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGPREGIUD,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGTRUST,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGRISCHIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGFALSADIC,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGEQUIFIN,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGRICINF,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CATEGORIA,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMCEL,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PEC,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_REFERENTE,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONALTO,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_APPALTO,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gTipInter,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDesNaz,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xC1DESCRI,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xC2DESCRI,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xC3DESCRI,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xC4DESCRI,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xC5DESCRI,"C",80,0));
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_personbo_aggBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_FYLIIHUTPH = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_NRWNAJJVRA = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_LNOFOPAOYD = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_WBTKNDJDFF = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_MWCFKQVNHF = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_HADVHTQAPE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(495,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(1016,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_personbo_agg"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'BGFCAXGJBL':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"BGFCAXGJBL",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'CANUTVNGFD':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"CANUTVNGFD",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg01,"+"default",l_session)+"'"+"]");
      status.out.print(",'IXGRJLAKIQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"IXGRJLAKIQ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg02,"+"default",l_session)+"'"+"]");
      status.out.print(",'NKIXCWZJHO':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NKIXCWZJHO",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg03,"+"default",l_session)+"'"+"]");
      status.out.print(",'JQLGHMLOKO':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"JQLGHMLOKO",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg04,"+"default",l_session)+"'"+"]");
      status.out.print(",'QVBZSFMTVP':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QVBZSFMTVP",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg05,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'BGFCAXGJBL':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'CANUTVNGFD':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg01,"+"default",l_session)+"'"+"]");
      status.out.print(",'IXGRJLAKIQ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg02,"+"default",l_session)+"'"+"]");
      status.out.print(",'NKIXCWZJHO':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg03,"+"default",l_session)+"'"+"]");
      status.out.print(",'JQLGHMLOKO':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg04,"+"default",l_session)+"'"+"]");
      status.out.print(",'QVBZSFMTVP':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg05,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_personbo_agg","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_personbo_agg",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("Categorie"),"")) {
      status.quoteAndAppend("Categorie","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("SocRev"),"")) {
      status.quoteAndAppend("SocRev","hide","box");
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
  void WriteMainFormScript(armt_personbo_aggBO BO,ServletStatus status) {
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
      status.out.println("SetFromContext(m_oFather.m_cWv_armt_personbo_agg);");
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
      status.out.println("m_oFather.SetChildVariables_armt_personbo_agg();");
      status.out.println("}");
    }
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_personbo_agg',Ne(m_nChildStatus,0));");
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
        status.out.println("if(c=Ctrl('DBFIZRPONS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JYNIHKHNSF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TZSFXOGJGG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LMZAVCTIKT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HAONGEKSUB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FYSLTMPLOV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BGFCAXGJBL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BGFCAXGJBL_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NIRLEZVFLW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CBYSBUCJMV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('URHHMCUEEA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CANUTVNGFD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CANUTVNGFD_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IXGRJLAKIQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IXGRJLAKIQ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NKIXCWZJHO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NKIXCWZJHO_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JQLGHMLOKO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JQLGHMLOKO_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QVBZSFMTVP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QVBZSFMTVP_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SEUBTYJEKC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AIXHBUOLOH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RJATPPKQJX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BFAZVGKRMM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TYXOFHIXSZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ONGFHKWFDC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HHZVXHZWFT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CJLHZBPFZE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PYRPYRCHAE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DRSQJFIQWH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XFXZVUBUON')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GYAJLZIGMO')) SetDisabled(c,true);");
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
      status.out.println("SetDisabled('DBFIZRPONS',m_bRowsChild);");
      status.out.println("SetDisabled('JYNIHKHNSF',m_bRowsChild);");
      status.out.println("SetDisabled('TZSFXOGJGG',m_bRowsChild);");
      status.out.println("SetDisabled('LMZAVCTIKT',m_bRowsChild);");
      status.out.println("SetDisabled('HAONGEKSUB',m_bRowsChild);");
      status.out.println("SetDisabled('FYSLTMPLOV',m_bRowsChild);");
      status.out.println("SetDisabled('BGFCAXGJBL',m_bRowsChild);");
      status.out.println("SetDisabled('NIRLEZVFLW',m_bRowsChild);");
      status.out.println("SetDisabled('CBYSBUCJMV',m_bRowsChild);");
      status.out.println("SetDisabled('URHHMCUEEA',m_bRowsChild);");
      status.out.println("SetDisabled('CANUTVNGFD',m_bRowsChild);");
      status.out.println("SetDisabled('IXGRJLAKIQ',m_bRowsChild);");
      status.out.println("SetDisabled('NKIXCWZJHO',m_bRowsChild);");
      status.out.println("SetDisabled('JQLGHMLOKO',m_bRowsChild);");
      status.out.println("SetDisabled('QVBZSFMTVP',m_bRowsChild);");
      status.out.println("SetDisabled('SEUBTYJEKC',m_bRowsChild);");
      status.out.println("SetDisabled('AIXHBUOLOH',m_bRowsChild);");
      status.out.println("SetDisabled('RJATPPKQJX',m_bRowsChild);");
      status.out.println("SetDisabled('BFAZVGKRMM',m_bRowsChild);");
      status.out.println("SetDisabled('TYXOFHIXSZ',m_bRowsChild);");
      status.out.println("SetDisabled('ONGFHKWFDC',m_bRowsChild);");
      status.out.println("SetDisabled('HHZVXHZWFT',m_bRowsChild);");
      status.out.println("SetDisabled('CJLHZBPFZE',m_bRowsChild);");
      status.out.println("SetDisabled('PYRPYRCHAE',m_bRowsChild);");
      status.out.println("SetDisabled('DRSQJFIQWH',m_bRowsChild);");
      status.out.println("SetDisabled('XFXZVUBUON',m_bRowsChild);");
      status.out.println("SetDisabled('GYAJLZIGMO',m_bRowsChild);");
    }
    status.out.println("}");
    if ( ! (CPLib.Empty(status.m_cAltInterface))) {
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
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
    status.out.println("function OnUnload() {");
    status.out.println("if (IsWndAccessible(m_oFather)) {");
    status.out.println("// * --- Area Manuale = UI - OnUnload");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("if (Eq(m_nChildStatus,1) && m_bResetOnUnload) {");
    status.out.println("m_oFather.m_oarmt_personbo_agg=null;");
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
  armt_personbo_aggBO getBO(ServletStatus status) {
    armt_personbo_aggBO BO = new armt_personbo_aggBO(status.context);
    if (CPLib.eq(status.m_nChildStatus,0)) {
      LoadExtensions(BO);
    }
    return BO;
  }
  void LoadExtensions(armt_personbo_aggBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("personbo_agg",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_personbo_aggBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_personbo_aggBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
  }
  CPResultSet QueryKeyCursor(armt_personbo_aggBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_personbo_agg;
    String l_cPhName = BO.m_cPhName_personbo_agg;
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
      String l_cQueryFilter = armt_personbo_aggBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_personbo_agg+".CONNES",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("personbo_agg");
    String l_cPhName = CPSql.ManipulateTablePhName("personbo_agg",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".CONNES",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,armt_personbo_aggBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_personbo_aggBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_personbo_agg,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_personbo_agg,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_personbo_aggBO BO) {
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
  void Edit(ServletStatus status,armt_personbo_aggBO BO,SPParameterSource source) {
    BO.Load(status.w_CONNES);
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
  void New(ServletStatus status,armt_personbo_aggBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_personbo_aggBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_personbo_aggBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_CONNES = "";
      } else {
        BO.w_CONNES = l_rsKeys.GetString("CONNES");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_CONNES = BO.w_CONNES;
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
  void EditLoad(ServletStatus status,armt_personbo_aggBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_personbo_aggBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_CONNES);
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
  void DeleteMessage(ServletStatus status,armt_personbo_aggBO BO,SPParameterSource source) {
    BO.Load(status.w_CONNES);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_personbo_aggBO BO) {
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({CONNES:"+SPLib.ToJSValue(BO.w_CONNES,"C",16,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
  void Discard(ServletStatus status,armt_personbo_aggBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_personbo_aggBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",455);
    item.put("w",1016);
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
    item.put("altInterfaceFor","armt_personbo_agg");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"comment\":\"EMAIL\",\"h\":20,\"maxlength\":50,\"name\":\"EMAIL\",\"page\":1,\"spuid\":\"DBFIZRPONS\",\"tabindex\":3,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":123,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PFHITGLPYJ\",\"page\":1,\"spuid\":\"PFHITGLPYJ\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"EMAIL:\",\"w\":112,\"x\":8,\"y\":11,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Flag EMAIL\",\"h\":21,\"label_text\":\"possibile inviare messaggi per EMail\",\"maxlength\":1,\"name\":\"FLGEMAIL\",\"page\":1,\"spuid\":\"JYNIHKHNSF\",\"tabindex\":5,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":248,\"x\":456,\"y\":6,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Telefono\",\"h\":20,\"maxlength\":50,\"name\":\"TELEFONO\",\"page\":1,\"spuid\":\"TZSFXOGJGG\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":123,\"y\":35,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ELIBEIUTYO\",\"page\":1,\"spuid\":\"ELIBEIUTYO\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"Telefono:\",\"w\":112,\"x\":8,\"y\":39,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cellulare\",\"h\":20,\"maxlength\":15,\"name\":\"NUMCEL\",\"page\":1,\"spuid\":\"HHZVXHZWFT\",\"tabindex\":50,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":504,\"y\":35,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_USQLSETBFB\",\"page\":1,\"spuid\":\"USQLSETBFB\",\"tabindex\":51,\"type\":\"Label\",\"value\":\"Cellulare:\",\"w\":64,\"x\":440,\"y\":39,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Codice Fiscale Validato\",\"h\":21,\"label_text\":\"Codice Fiscale Validato da AGE\",\"maxlength\":1,\"name\":\"FLGVALIDO\",\"page\":1,\"spuid\":\"LMZAVCTIKT\",\"tabindex\":8,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":184,\"x\":120,\"y\":119,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Dati Anagrafici Validati\",\"h\":21,\"label_text\":\"Dati Anagrafici Validati da AGE\",\"maxlength\":1,\"name\":\"FLGANAVAL\",\"page\":1,\"spuid\":\"HAONGEKSUB\",\"tabindex\":9,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":216,\"x\":381,\"y\":120,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"EMAIL\",\"h\":20,\"name\":\"EMAIL\",\"page\":1,\"scroll\":true,\"spuid\":\"CJLHZBPFZE\",\"tabindex\":52,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":309,\"x\":123,\"y\":63,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NMMOYAZYFJ\",\"page\":1,\"spuid\":\"NMMOYAZYFJ\",\"tabindex\":53,\"type\":\"Label\",\"value\":\"EMAIL:\",\"w\":115,\"x\":8,\"y\":67,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"PEC\",\"h\":20,\"maxlength\":50,\"name\":\"PEC\",\"page\":1,\"spuid\":\"PYRPYRCHAE\",\"tabindex\":54,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":504,\"y\":63,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GIUWNGWRYA\",\"page\":1,\"spuid\":\"GIUWNGWRYA\",\"tabindex\":55,\"type\":\"Label\",\"value\":\"PEC:\",\"w\":56,\"x\":448,\"y\":67,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Referente\",\"h\":20,\"maxlength\":50,\"name\":\"REFERENTE\",\"page\":1,\"spuid\":\"DRSQJFIQWH\",\"tabindex\":56,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":120,\"y\":91,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PNNBAMJIYZ\",\"page\":1,\"spuid\":\"PNNBAMJIYZ\",\"tabindex\":57,\"type\":\"Label\",\"value\":\"Referente:\",\"w\":120,\"x\":0,\"y\":95,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Occupazione\",\"h\":20,\"maxlength\":4,\"name\":\"CLOCCUPA\",\"page\":1,\"spuid\":\"FYSLTMPLOV\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":120,\"y\":148,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VSLFLTAORI\",\"page\":1,\"spuid\":\"VSLFLTAORI\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"Occupazione:\",\"w\":112,\"x\":5,\"y\":152,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Nazionalit\\u00E0\",\"h\":20,\"maxlength\":3,\"name\":\"NAZIONE\",\"page\":1,\"picker\":true,\"spuid\":\"BGFCAXGJBL\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":120,\"y\":176,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RXOQQWNFRG\",\"page\":1,\"spuid\":\"RXOQQWNFRG\",\"tabindex\":13,\"type\":\"Label\",\"value\":\"Nazionalit\\u00E0:\",\"w\":112,\"x\":5,\"y\":180,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_FYLIIHUTPH\",\"page\":1,\"spuid\":\"FYLIIHUTPH\",\"tabindex\":15,\"type\":\"Label\",\"w\":448,\"x\":181,\"y\":180,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia Domicilio\",\"h\":20,\"maxlength\":2,\"name\":\"CLPRVDOM\",\"page\":1,\"spuid\":\"NIRLEZVFLW\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":120,\"y\":204,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RKPADAREKN\",\"page\":1,\"spuid\":\"RKPADAREKN\",\"tabindex\":18,\"type\":\"Label\",\"value\":\"Prov. Domicilio:\",\"w\":112,\"x\":5,\"y\":208,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Regione Residenza\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":2,\"name\":\"REGRES\",\"page\":1,\"spuid\":\"CBYSBUCJMV\",\"tabindex\":17,\"textlist\":\"Estero,Abruzzo,Basilicata,Calabria,Campegna,Emilia-Romagna,Friuli-Venezia Giulia,Lazio,Liguria,Lombardia,Marche,Molise,Piemonte,Puglia,Sardegna,Sicilia,Toscana,Trentino-Alto Adige,Umbria,Valle d"+"'"+"Aosta,Veneto\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"00"+"'"+","+"'"+"01"+"'"+","+"'"+"02"+"'"+","+"'"+"03"+"'"+","+"'"+"04"+"'"+","+"'"+"05"+"'"+","+"'"+"06"+"'"+","+"'"+"07"+"'"+","+"'"+"08"+"'"+","+"'"+"09"+"'"+","+"'"+"10"+"'"+","+"'"+"11"+"'"+","+"'"+"12"+"'"+","+"'"+"13"+"'"+","+"'"+"14"+"'"+","+"'"+"15"+"'"+","+"'"+"16"+"'"+","+"'"+"17"+"'"+","+"'"+"18"+"'"+","+"'"+"19"+"'"+","+"'"+"20"+"'"+"\",\"w\":320,\"x\":120,\"y\":232,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HJQTMOWJVN\",\"page\":1,\"spuid\":\"HJQTMOWJVN\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"Regione Residenza:\",\"w\":112,\"x\":5,\"y\":236,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"BlackList \",\"h\":21,\"label_text\":\"Black List Interna\",\"maxlength\":1,\"name\":\"FLGBL\",\"page\":1,\"spuid\":\"URHHMCUEEA\",\"tabindex\":20,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":128,\"x\":613,\"y\":232,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Categorie\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Categorie\",\"h\":126,\"name\":\"Categorie\",\"page\":1,\"shrinkable\":true,\"spuid\":\"RFAIYHSGII\",\"stretch\":true,\"tabindex\":21,\"title_caption\":\"Categorie\",\"titled\":true,\"type\":\"Box\",\"w\":1019,\"x\":-3,\"y\":255,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Categoria 1\",\"h\":20,\"maxlength\":2,\"name\":\"CATEG01\",\"page\":1,\"picker\":true,\"spuid\":\"CANUTVNGFD\",\"tabindex\":22,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":120,\"y\":262,\"zone\":\"pag1_9_1\",\"zonepath\":\"[1,9,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_NRWNAJJVRA\",\"page\":1,\"spuid\":\"NRWNAJJVRA\",\"tabindex\":23,\"type\":\"Label\",\"w\":488,\"x\":173,\"y\":266,\"zone\":\"pag1_9_1\",\"zonepath\":\"[1,9,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WWRYOVTMFY\",\"page\":1,\"spuid\":\"WWRYOVTMFY\",\"tabindex\":24,\"type\":\"Label\",\"value\":\"Categoria 1:\",\"w\":112,\"x\":5,\"y\":266,\"zone\":\"pag1_9_1\",\"zonepath\":\"[1,9,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Categoria 2\",\"h\":20,\"maxlength\":2,\"name\":\"CATEG02\",\"page\":1,\"picker\":true,\"spuid\":\"IXGRJLAKIQ\",\"tabindex\":25,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":120,\"y\":286,\"zone\":\"pag1_9_2\",\"zonepath\":\"[1,9,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_LNOFOPAOYD\",\"page\":1,\"spuid\":\"LNOFOPAOYD\",\"tabindex\":26,\"type\":\"Label\",\"w\":488,\"x\":173,\"y\":290,\"zone\":\"pag1_9_2\",\"zonepath\":\"[1,9,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HNQZARYXGS\",\"page\":1,\"spuid\":\"HNQZARYXGS\",\"tabindex\":27,\"type\":\"Label\",\"value\":\"Categoria 2:\",\"w\":112,\"x\":5,\"y\":290,\"zone\":\"pag1_9_2\",\"zonepath\":\"[1,9,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Categoria 3\",\"h\":20,\"maxlength\":2,\"name\":\"CATEG03\",\"page\":1,\"picker\":true,\"spuid\":\"NKIXCWZJHO\",\"tabindex\":28,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":120,\"y\":310,\"zone\":\"pag1_9_3\",\"zonepath\":\"[1,9,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_WBTKNDJDFF\",\"page\":1,\"spuid\":\"WBTKNDJDFF\",\"tabindex\":29,\"type\":\"Label\",\"w\":488,\"x\":173,\"y\":314,\"zone\":\"pag1_9_3\",\"zonepath\":\"[1,9,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BGEVFUGGOS\",\"page\":1,\"spuid\":\"BGEVFUGGOS\",\"tabindex\":30,\"type\":\"Label\",\"value\":\"Categoria 3:\",\"w\":112,\"x\":5,\"y\":314,\"zone\":\"pag1_9_3\",\"zonepath\":\"[1,9,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Categoria 1\",\"h\":20,\"maxlength\":2,\"name\":\"CATEG04\",\"page\":1,\"picker\":true,\"spuid\":\"JQLGHMLOKO\",\"tabindex\":31,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":120,\"y\":334,\"zone\":\"pag1_9_4\",\"zonepath\":\"[1,9,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_MWCFKQVNHF\",\"page\":1,\"spuid\":\"MWCFKQVNHF\",\"tabindex\":32,\"type\":\"Label\",\"w\":488,\"x\":173,\"y\":338,\"zone\":\"pag1_9_4\",\"zonepath\":\"[1,9,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RHXCIUHRTU\",\"page\":1,\"spuid\":\"RHXCIUHRTU\",\"tabindex\":33,\"type\":\"Label\",\"value\":\"Categoria 4:\",\"w\":112,\"x\":5,\"y\":338,\"zone\":\"pag1_9_4\",\"zonepath\":\"[1,9,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Categoria 1\",\"h\":20,\"maxlength\":2,\"name\":\"CATEG05\",\"page\":1,\"picker\":true,\"spuid\":\"QVBZSFMTVP\",\"tabindex\":34,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":120,\"y\":358,\"zone\":\"pag1_9_5\",\"zonepath\":\"[1,9,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_HADVHTQAPE\",\"page\":1,\"spuid\":\"HADVHTQAPE\",\"tabindex\":35,\"type\":\"Label\",\"w\":488,\"x\":173,\"y\":362,\"zone\":\"pag1_9_5\",\"zonepath\":\"[1,9,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GRCYFEKJWU\",\"page\":1,\"spuid\":\"GRCYFEKJWU\",\"tabindex\":36,\"type\":\"Label\",\"value\":\"Categoria 5:\",\"w\":112,\"x\":5,\"y\":362,\"zone\":\"pag1_9_5\",\"zonepath\":\"[1,9,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"SocRev\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Fattori di Rischio\",\"h\":73,\"name\":\"SocRev\",\"page\":1,\"shrinkable\":true,\"spuid\":\"YFAFHIMHLC\",\"stretch\":true,\"tabindex\":42,\"title_caption\":\"Fattori di Rischio\",\"titled\":true,\"type\":\"Box\",\"w\":1019,\"x\":-3,\"y\":382,\"zone\":\"pag1_10\",\"zonepath\":\"[1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Pregiudizievole\",\"h\":21,\"label_text\":\"Pregiudizievole\",\"maxlength\":1,\"name\":\"FLGPREGIUD\",\"page\":1,\"spuid\":\"SEUBTYJEKC\",\"tabindex\":43,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":208,\"x\":40,\"y\":392,\"zone\":\"pag1_10_1\",\"zonepath\":\"[1,10,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Trust\",\"h\":21,\"label_text\":\"Trust\",\"maxlength\":1,\"name\":\"FLGTRUST\",\"page\":1,\"spuid\":\"AIXHBUOLOH\",\"tabindex\":44,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":168,\"x\":261,\"y\":392,\"zone\":\"pag1_10_1\",\"zonepath\":\"[1,10,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Cliente con attivit\\u00E0 in paesi a rischio\",\"h\":21,\"label_text\":\"Cliente con attivit\\u00E0 in paesi a rischio\",\"maxlength\":1,\"name\":\"FLGRISCHIO\",\"page\":1,\"spuid\":\"RJATPPKQJX\",\"tabindex\":45,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":208,\"x\":437,\"y\":392,\"zone\":\"pag1_10_1\",\"zonepath\":\"[1,10,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Falsa dichiarazione\",\"h\":21,\"label_text\":\"Falsa dichiarazione\",\"maxlength\":1,\"name\":\"FLGFALSADIC\",\"page\":1,\"spuid\":\"BFAZVGKRMM\",\"tabindex\":46,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":208,\"x\":40,\"y\":420,\"zone\":\"pag1_10_2\",\"zonepath\":\"[1,10,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Equilibrio Finanziario\",\"h\":21,\"label_text\":\"Equilibrio Finanziario\",\"maxlength\":1,\"name\":\"FLGEQUIFIN\",\"page\":1,\"spuid\":\"TYXOFHIXSZ\",\"tabindex\":47,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":168,\"x\":261,\"y\":420,\"zone\":\"pag1_10_2\",\"zonepath\":\"[1,10,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Richiamo di Informativa\",\"h\":21,\"label_text\":\"Richiamo di Informativa\",\"maxlength\":1,\"name\":\"FLGRICINF\",\"page\":1,\"spuid\":\"ONGFHKWFDC\",\"tabindex\":48,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":208,\"x\":437,\"y\":420,\"zone\":\"pag1_10_2\",\"zonepath\":\"[1,10,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Prevalente attivit\\u00E0 in appalti pubblici\",\"h\":21,\"label_text\":\"Prevalente attivit\\u00E0 in appalti pubblici\",\"maxlength\":2,\"name\":\"APPALTO\",\"page\":1,\"spuid\":\"GYAJLZIGMO\",\"tabindex\":59,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":248,\"x\":680,\"y\":419,\"zone\":\"pag1_10_2\",\"zonepath\":\"[1,10,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Connesso con attivit\\u00E0 a rischio\",\"h\":21,\"label_text\":\"Connesso con attivit\\u00E0 a rischio\",\"maxlength\":2,\"name\":\"CONALTO\",\"page\":1,\"spuid\":\"XFXZVUBUON\",\"tabindex\":58,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":248,\"x\":680,\"y\":392,\"zone\":\"pag1_10_3\",\"zonepath\":\"[1,10,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_personbo_aggBO BO,ServletStatus status) {
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
     "<script src='armt_personbo_agg?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_personbo_agg_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_personbo_agg_edit.js'>" +
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
      status.out.println("w_CONNES=a[0];");
      status.out.println("w_EMAIL=a[1];");
      status.out.println("w_FLGEMAIL=a[2];");
      status.out.println("w_TELEFONO=a[3];");
      status.out.println("w_FLGVALIDO=a[4];");
      status.out.println("w_FLGANAVAL=a[5];");
      status.out.println("w_CLOCCUPA=a[6];");
      status.out.println("w_NAZIONE=a[7];");
      status.out.println("w_CLPRVDOM=a[8];");
      status.out.println("w_REGRES=a[9];");
      status.out.println("w_FLGBL=a[10];");
      status.out.println("w_CATEG01=a[11];");
      status.out.println("w_CATEG02=a[12];");
      status.out.println("w_CATEG03=a[13];");
      status.out.println("w_CATEG04=a[14];");
      status.out.println("w_CATEG05=a[15];");
      status.out.println("w_FLGPREGIUD=a[16];");
      status.out.println("w_FLGTRUST=a[17];");
      status.out.println("w_FLGRISCHIO=a[18];");
      status.out.println("w_FLGFALSADIC=a[19];");
      status.out.println("w_FLGEQUIFIN=a[20];");
      status.out.println("w_FLGRICINF=a[21];");
      status.out.println("w_CATEGORIA=a[22];");
      status.out.println("w_NUMCEL=a[23];");
      status.out.println("w_PEC=a[24];");
      status.out.println("w_REFERENTE=a[25];");
      status.out.println("w_CONALTO=a[26];");
      status.out.println("w_APPALTO=a[27];");
      status.out.println("w_gTipInter=a[28];");
      status.out.println("w_xDesNaz=a[29];");
      status.out.println("w_xC1DESCRI=a[30];");
      status.out.println("w_xC2DESCRI=a[31];");
      status.out.println("w_xC3DESCRI=a[32];");
      status.out.println("w_xC4DESCRI=a[33];");
      status.out.println("w_xC5DESCRI=a[34];");
      status.out.println("m_PrimaryKeys=['CONNES'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_personbo_agg_proc.js'>" +
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
    status.m_cBodyAttributes = "onload=OnLoad() onunload=OnUnload() onhelp=CancelHelp()";
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.m_cBodyAttributes = status.m_cBodyAttributes+" onkeydown=window.ManageKeys(event,false,false)";
    } else {
      status.m_cBodyAttributes = status.m_cBodyAttributes+" onkeydown=window.ManageKeys(event,true,false)";
    }
    status.m_cBodyAttributes = status.m_cBodyAttributes+" onfocus=EnsureControlFocus()";
    status.themeWriter.WriteBody_Begin(495,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","personbo_agg");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","CONNES");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(armt_personbo_aggBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({CONNES:"+SPLib.ToJSValue(BO.w_CONNES,"C",16,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_personbo_aggBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({CONNES:"+SPLib.ToJSValue(BO.w_CONNES,"C",16,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armt_personbo_aggBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({CONNES:"+SPLib.ToJSValue(BO.w_CONNES,"C",16,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armt_personbo_aggBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({CONNES:"+SPLib.ToJSValue(BO.w_CONNES,"C",16,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armt_personbo_aggBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({CONNES:"+SPLib.ToJSValue(BO.w_CONNES,"C",16,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_personbo_aggBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_personbo_aggBO BO,ServletStatus status) throws IOException {
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
    status.out.println(
     "<script src='SPPrxy/"+fwfn_calc_categoria.m_cEntityUid+"/fwfn_calc_categoria.js'>" +
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
      fwfn_calc_categoria.GetCallableNames(callable);
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_personbo_aggBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_CONNES),"C",16,0));
      }
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gTipInter),"C",2,0));
    } else if (CPLib.eq(p_cUID,"BGFCAXGJBL")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"CANUTVNGFD")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"IXGRJLAKIQ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NKIXCWZJHO")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"JQLGHMLOKO")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"QVBZSFMTVP")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_personbo_aggBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_NAZIONE))) {
        a = GetCheckVars(status,BO,"BGFCAXGJBL");
        b = status.m_CheckVars.optString("BGFCAXGJBL");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CATEG01))) {
        a = GetCheckVars(status,BO,"CANUTVNGFD");
        b = status.m_CheckVars.optString("CANUTVNGFD");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CATEG02))) {
        a = GetCheckVars(status,BO,"IXGRJLAKIQ");
        b = status.m_CheckVars.optString("IXGRJLAKIQ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CATEG03))) {
        a = GetCheckVars(status,BO,"NKIXCWZJHO");
        b = status.m_CheckVars.optString("NKIXCWZJHO");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CATEG04))) {
        a = GetCheckVars(status,BO,"JQLGHMLOKO");
        b = status.m_CheckVars.optString("JQLGHMLOKO");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CATEG05))) {
        a = GetCheckVars(status,BO,"QVBZSFMTVP");
        b = status.m_CheckVars.optString("QVBZSFMTVP");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
