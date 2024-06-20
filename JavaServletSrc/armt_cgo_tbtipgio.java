import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_cgo_tbtipgio extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*3d2fb8a8*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "cgo_tbtipgio";
    }
    public String w_CODTPGIO;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_CODTPGIO,context,"cgo_tbtipgio","CODTPGIO","C",3,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='CODTPGIO' type='hidden' value="+SPLib.ToHTMLValue(w_CODTPGIO,"C",3,0)+">" +
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
    armt_cgo_tbtipgioBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_cgo_tbtipgio;
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
      status.w_CODTPGIO = BO.w_CODTPGIO;
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
    return "Tipologie Gioco (CGO)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_cgo_tbtipgio";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 701;
    l_eg.m_nEntityHeight = 654;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"cgo_tbtipgio"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page"),new ZoneItem("Base","Dati Base","horizontal_section"),new ZoneItem("box_GIMNJEFKNF","Moduli Sopra Soglia","titled_box"),new ZoneItem("box_MFCHEDYPZM","Moduli Sotto Soglia","titled_box"),new ZoneItem("box_OERGIOTKFK","Attivi se pagamento in contanti","titled_box"),new ZoneItem("TipReg","Tipologie Registrazione","horizontal_section")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"CODTPGIO"};
    l_eg.items = new SPItem[]{
                   new SPItem("CODTPGIO","C",3,0, "edit","Tipo Gioco"),
                   new SPItem("DESTPGIO","C",50,0, "edit","Descrizione"),
                   new SPItem("SOGTPGIO","N",12,2, "edit","Soglia pagamento"),
                   new SPItem("EDTTPGIO","C",1,0, "edit","Abilita modifica Scelta"),
                   new SPItem("DEFTPGIO","C",1,0, "edit","Default pagamento"),
                   new SPItem("EDTSPGIO","C",1,0, "edit","Abilita Modifica Sotto Soglia"),
                   new SPItem("DEFSPGIO","C",1,0, "edit","Default Sotto Soglia"),
                   new SPItem("FLGPLGIO","C",1,0, "edit","Abilita Selezione Piattaforma"),
                   new SPItem("FLGMLGIO","C",1,0, "edit","Inserimento Operazioni Multiple"),
                   new SPItem("MAGPAGGIO","N",2,0, "edit","N° Massimo Pagine Documento Unico o N° Max Documenti"),
                   new SPItem("MINPAGGIO","N",2,0, "edit","N° Pagine Documento Unico o N° Documenti (Importo Sotto Soglia):"),
                   new SPItem("FDC1OSGIO","C",1,0, "edit","Adeguata Verifica Sopra Soglia"),
                   new SPItem("FDC2OSGIO","C",1,0, "edit","Copia Biglietto"),
                   new SPItem("FDC3OSGIO","C",1,0, "edit","Codice Fiscale"),
                   new SPItem("FDC4OSGIO","C",1,0, "edit","Codice Fiscale"),
                   new SPItem("FDC5OSGIO","C",1,0, "edit","Codice Fiscale"),
                   new SPItem("FDC6OSGIO","C",1,0, "edit","Codice Fiscale"),
                   new SPItem("FDC1SSGIO","C",1,0, "edit","Adeguata Verifica Sopra Soglia"),
                   new SPItem("FDC2SSGIO","C",1,0, "edit","Copia Biglietto"),
                   new SPItem("FDC3SSGIO","C",1,0, "edit","Codice Fiscale"),
                   new SPItem("FDC4SSGIO","C",1,0, "edit","Codice Fiscale"),
                   new SPItem("FDC5SSGIO","C",1,0, "edit","Codice Fiscale"),
                   new SPItem("FDC6SSGIO","C",1,0, "edit","Codice Fiscale"),
                   new SPItem("FDC1ACGIO","C",1,0, "edit","Adeguata Verifica Sopra Soglia"),
                   new SPItem("FDC2ACGIO","C",1,0, "edit","Copia Biglietto"),
                   new SPItem("FDC3ACGIO","C",1,0, "edit","Codice Fiscale"),
                   new SPItem("FDC4ACGIO","C",1,0, "edit","Codice Fiscale"),
                   new SPItem("FDC5ACGIO","C",1,0, "edit","Codice Fiscale"),
                   new SPItem("FDC6ACGIO","C",1,0, "edit","Codice Fiscale"),
                   new SPItem("NCOPAGGIO","N",2,0, "edit","N° pagine Pagamento in contanti"),
                   new SPItem("FLTIPGIO","C",1,0, "edit","Tipologia"),
                   new SPItem("FLGATTIVO","C",1,0, "edit","Tipo Gioco Attivo"),
                   new SPItem("IMPMINGIO","N",10,2, "edit","Importo minimo autovalidazione multiple"),
                   new SPItem("IMPMINTOT","N",12,2, "edit","Importo Minimo Totale Multiple")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_cgo_tbtipgioBO BO) {
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
    l_translations=new String[][]{{"10027039931",p_Context.Translate("Tipologia")},
    {"10615149648",p_Context.Translate("N° pagine Pagamento in contanti")},
    {"106476627",p_Context.Translate("N° Massimo Pagine Documento Unico o N° Max Documenti")},
    {"11052594431",p_Context.Translate("Importo minimo autovalidazione multiple")},
    {"11061636098",p_Context.Translate("Default Sotto Soglia")},
    {"1118764577",p_Context.Translate("Mezzo di Pagamento")},
    {"11281970931",p_Context.Translate("Inserimento Operazioni Multiple")},
    {"11720460891",p_Context.Translate("Adeguata Verifica Sopra Soglia")},
    {"11848875500",p_Context.Translate("Soglia pagamento")},
    {"11921223220",p_Context.Translate("Codice Fiscale")},
    {"12075327151",p_Context.Translate("Importo Minimo Totale Multiple")},
    {"1255218623",p_Context.Translate("Abilita Selezione Piattaforma")},
    {"1260570458",p_Context.Translate("Copia Biglietto")},
    {"1264575246",p_Context.Translate("Abilita modifica Scelta")},
    {"132574664",p_Context.Translate("Obbligazione")},
    {"1570205239",p_Context.Translate("Tipo Gioco")},
    {"1725568305",p_Context.Translate("Biglietto/Ticket")},
    {"1852006737",p_Context.Translate("Documento di Identità")},
    {"1949793185",p_Context.Translate("Tipologie Gioco (CGO)")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"474405998",p_Context.Translate("Abilita Inserimento Operazioni Multiple")},
    {"710698594",p_Context.Translate("Adeguata Verifica")},
    {"721888449",p_Context.Translate("N° Pagine Documento Unico o N° Documenti (Importo Sotto Soglia):")},
    {"776969894",p_Context.Translate("Tipo Gioco Attivo")},
    {"805239427",p_Context.Translate("Default pagamento")},
    {"966697453",p_Context.Translate("Abilita modifica Sopra Soglia")},
    {"981524941",p_Context.Translate("Abilita Modifica Sotto Soglia")},
    {"981524973",p_Context.Translate("Abilita modifica Sotto Soglia")}};
    return l_translations;
  }
  void WriteStyles(armt_cgo_tbtipgioBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_cgo_tbtipgio.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_cgo_tbtipgioBO BO,ServletStatus status) {
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
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_cgo_tbtipgio',false);");
    }
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_cgo_tbtipgio",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(armt_cgo_tbtipgioBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,2);
  }
  void WriteControls_p1(armt_cgo_tbtipgioBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:654px;width:701px;display:none'>" +
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
  void WriteControls_p1_b0(armt_cgo_tbtipgioBO BO,ServletStatus status) {
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
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b1(armt_cgo_tbtipgioBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Base' id='YORQOIOBQN_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
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
     "<div id='YORQOIOBQN' class='SectionBody' style='position:relative;height:434px;display:block'>" +
    "");
    status.includeZoneAltInterface("Base@BEGIN");
    if (status.includeZoneAltInterface("Base")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Base@BEGIN") || status.HasZoneAltInterface("Base@END")) {
        status.out.println(
         "<div id='YORQOIOBQN_boxContent' style='position:relative;height:434px;display:block'>" +
        "");
      }
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODTPGIO' id='RCAIOHOYCN' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_CODTPGIO,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='3' size='3' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel PrimaryKeyLabel' id='HHFRUECYAF_DIV'>" +
       "<label id='HHFRUECYAF' for='RCAIOHOYCN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Gioco:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DESTPGIO' id='PLTDFOMPMX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DESTPGIO,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RSSVRXXCCP_DIV'>" +
       "<label id='RSSVRXXCCP' for='PLTDFOMPMX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Descrizione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SOGTPGIO' id='DLCJAPAHNK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SOGTPGIO,"N",12,2,"999,999,999.99", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='17' size='12' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='PPZWLBHZXY_DIV'>" +
       "<input name='EDTTPGIO' id='PPZWLBHZXY' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_EDTTPGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_EDTTPGIO))?"CHECKED":"")+">" +
       "<label id='PPZWLBHZXY_LBL' for='PPZWLBHZXY' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Abilita modifica Sopra Soglia"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='DEFTPGIO' id='SOFGJQQNFS' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("A","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("A",CPLib.Trim(BO.w_DEFTPGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Agenzia")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("S","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("S",CPLib.Trim(BO.w_DEFTPGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Concessionario")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('SOFGJQQNFS'),w_DEFTPGIO,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BEHWXHTIBN_DIV'>" +
       "<label id='BEHWXHTIBN' for='DLCJAPAHNK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Soglia pagamento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TENXMNLTTK_DIV'>" +
       "<label id='TENXMNLTTK' for='SOFGJQQNFS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Default pagamento sopra soglia:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='GOFVHZECXL_DIV'>" +
       "<input name='EDTSPGIO' id='GOFVHZECXL' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_EDTSPGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_EDTSPGIO))?"CHECKED":"")+">" +
       "<label id='GOFVHZECXL_LBL' for='GOFVHZECXL' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Abilita modifica Sotto Soglia"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='DEFSPGIO' id='NZZQBPTZYU' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("A","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("A",CPLib.Trim(BO.w_DEFSPGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Agenzia")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("S","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("S",CPLib.Trim(BO.w_DEFSPGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Concessionario")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('NZZQBPTZYU'),w_DEFSPGIO,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VPKIKBZRVZ_DIV'>" +
       "<label id='VPKIKBZRVZ' for='NZZQBPTZYU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Default pagamento sotto soglia:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='MRDEGXONBG_DIV'>" +
       "<input name='FLGPLGIO' id='MRDEGXONBG' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGPLGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGPLGIO))?"CHECKED":"")+">" +
       "<label id='MRDEGXONBG_LBL' for='MRDEGXONBG' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Abilita Selezione Piattaforma"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='FMLKVYWRZP_DIV'>" +
       "<input name='FLGMLGIO' id='FMLKVYWRZP' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGMLGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGMLGIO))?"CHECKED":"")+">" +
       "<label id='FMLKVYWRZP_LBL' for='FMLKVYWRZP' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Abilita Inserimento Operazioni Multiple"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MAGPAGGIO' id='RNGJQLKVFO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MAGPAGGIO,"N",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='2' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ITKWXOHKBK_DIV'>" +
       "<label id='ITKWXOHKBK' for='RNGJQLKVFO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("N° Pagine Doc. Unico:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MINPAGGIO' id='UFVJWZLULG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MINPAGGIO,"N",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='2' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='CAUFCTBRNM_DIV'>" +
       "<input name='FDC1OSGIO' id='CAUFCTBRNM' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FDC1OSGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FDC1OSGIO))?"CHECKED":"")+">" +
       "<label id='CAUFCTBRNM_LBL' for='CAUFCTBRNM' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Adeguata Verifica"))+"</label>" +
       "</span>" +
      "");
      status.out.println(
       "<div id='GIMNJEFKNF_DIV' class='TitledBox'>" +
       "<span id='GIMNJEFKNF_HEADER_CAPTION' class='DefaultTitledBox'>"+status.context.Translate("Moduli Sopra Soglia")+"</span>" +
       "<div id='GIMNJEFKNF'>" +
       "</div>" +
       "</div>" +
      "");
      status.out.println(
       "<div id='MFCHEDYPZM_DIV' class='TitledBox'>" +
       "<span id='MFCHEDYPZM_HEADER_CAPTION' class='DefaultTitledBox'>"+status.context.Translate("Moduli Sotto Soglia")+"</span>" +
       "<div id='MFCHEDYPZM'>" +
       "</div>" +
       "</div>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='UGCFKKQJNN_DIV'>" +
       "<input name='FDC2OSGIO' id='UGCFKKQJNN' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FDC2OSGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FDC2OSGIO))?"CHECKED":"")+">" +
       "<label id='UGCFKKQJNN_LBL' for='UGCFKKQJNN' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Biglietto/Ticket"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='XNNAMCGSXP_DIV'>" +
       "<input name='FDC3OSGIO' id='XNNAMCGSXP' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FDC3OSGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FDC3OSGIO))?"CHECKED":"")+">" +
       "<label id='XNNAMCGSXP_LBL' for='XNNAMCGSXP' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='MYUZABATXZ_DIV'>" +
       "<input name='FDC4OSGIO' id='MYUZABATXZ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FDC4OSGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FDC4OSGIO))?"CHECKED":"")+">" +
       "<label id='MYUZABATXZ_LBL' for='MYUZABATXZ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Documento di Identità"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='RSGIDFYOLS_DIV'>" +
       "<input name='FDC5OSGIO' id='RSGIDFYOLS' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FDC5OSGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FDC5OSGIO))?"CHECKED":"")+">" +
       "<label id='RSGIDFYOLS_LBL' for='RSGIDFYOLS' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Mezzo di Pagamento"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='YPMOMULORE_DIV'>" +
       "<input name='FDC6OSGIO' id='YPMOMULORE' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FDC6OSGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FDC6OSGIO))?"CHECKED":"")+">" +
       "<label id='YPMOMULORE_LBL' for='YPMOMULORE' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Obbligazione"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='QEKBNPGOBS_DIV'>" +
       "<input name='FDC1SSGIO' id='QEKBNPGOBS' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FDC1SSGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FDC1SSGIO))?"CHECKED":"")+">" +
       "<label id='QEKBNPGOBS_LBL' for='QEKBNPGOBS' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Adeguata Verifica"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='NFHGTEJQNE_DIV'>" +
       "<input name='FDC2SSGIO' id='NFHGTEJQNE' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FDC2SSGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FDC2SSGIO))?"CHECKED":"")+">" +
       "<label id='NFHGTEJQNE_LBL' for='NFHGTEJQNE' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Biglietto/Ticket"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='GJLCDJIDAY_DIV'>" +
       "<input name='FDC3SSGIO' id='GJLCDJIDAY' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FDC3SSGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FDC3SSGIO))?"CHECKED":"")+">" +
       "<label id='GJLCDJIDAY_LBL' for='GJLCDJIDAY' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='RBOWBOPVOA_DIV'>" +
       "<input name='FDC4SSGIO' id='RBOWBOPVOA' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FDC4SSGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FDC4SSGIO))?"CHECKED":"")+">" +
       "<label id='RBOWBOPVOA_LBL' for='RBOWBOPVOA' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Documento di Identità"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='DHNVKQKTHK_DIV'>" +
       "<input name='FDC5SSGIO' id='DHNVKQKTHK' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FDC5SSGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FDC5SSGIO))?"CHECKED":"")+">" +
       "<label id='DHNVKQKTHK_LBL' for='DHNVKQKTHK' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Mezzo di Pagamento"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='CBJEEAJCGS_DIV'>" +
       "<input name='FDC6SSGIO' id='CBJEEAJCGS' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FDC6SSGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FDC6SSGIO))?"CHECKED":"")+">" +
       "<label id='CBJEEAJCGS_LBL' for='CBJEEAJCGS' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Obbligazione"))+"</label>" +
       "</span>" +
      "");
      status.out.println(
       "<div id='OERGIOTKFK_DIV' class='TitledBox'>" +
       "<span id='OERGIOTKFK_HEADER_CAPTION' class='DefaultTitledBox'>"+status.context.Translate("Attivi se pagamento in contanti")+"</span>" +
       "<div id='OERGIOTKFK'>" +
       "</div>" +
       "</div>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='UXGJFWIPXB_DIV'>" +
       "<input name='FDC1ACGIO' id='UXGJFWIPXB' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FDC1ACGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FDC1ACGIO))?"CHECKED":"")+">" +
       "<label id='UXGJFWIPXB_LBL' for='UXGJFWIPXB' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Adeguata Verifica"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='TKEHQQFQUC_DIV'>" +
       "<input name='FDC2ACGIO' id='TKEHQQFQUC' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FDC2ACGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FDC2ACGIO))?"CHECKED":"")+">" +
       "<label id='TKEHQQFQUC_LBL' for='TKEHQQFQUC' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Biglietto/Ticket"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='XBPDZFAWFR_DIV'>" +
       "<input name='FDC3ACGIO' id='XBPDZFAWFR' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FDC3ACGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FDC3ACGIO))?"CHECKED":"")+">" +
       "<label id='XBPDZFAWFR_LBL' for='XBPDZFAWFR' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='ZJMEDHEECW_DIV'>" +
       "<input name='FDC4ACGIO' id='ZJMEDHEECW' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FDC4ACGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FDC4ACGIO))?"CHECKED":"")+">" +
       "<label id='ZJMEDHEECW_LBL' for='ZJMEDHEECW' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Documento di Identità"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='TOJFZPDKWJ_DIV'>" +
       "<input name='FDC5ACGIO' id='TOJFZPDKWJ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FDC5ACGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FDC5ACGIO))?"CHECKED":"")+">" +
       "<label id='TOJFZPDKWJ_LBL' for='TOJFZPDKWJ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Mezzo di Pagamento"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='UXAYRLQXMN_DIV'>" +
       "<input name='FDC6ACGIO' id='UXAYRLQXMN' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FDC6ACGIO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FDC6ACGIO))?"CHECKED":"")+">" +
       "<label id='UXAYRLQXMN_LBL' for='UXAYRLQXMN' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Obbligazione"))+"</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='QPPLTIMJLH_DIV'>" +
       "<label id='QPPLTIMJLH' for='RNGJQLKVFO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("N° Pagine Doc. Unico:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NCOPAGGIO' id='MXUUACEBJE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NCOPAGGIO,"N",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='2' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GPUIIBJKGO_DIV'>" +
       "<label id='GPUIIBJKGO' for='RNGJQLKVFO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("N° Pagine Doc. Unico:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<div class='"+status.ObligatoryClass("")+"' id='LTMWIPFDRU_DIV'>" +
       "<span id='LTMWIPFDRU_0_container'>" +
       "<input id='LTMWIPFDRU_0' name='LTMWIPFDRU' type='radio' value="+SPLib.ToHTMLValue("A","C",1,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("A",CPLib.Trim(BO.w_FLTIPGIO))?"CHECKED":"")+">" +
       "<label class='SPLabel' for='LTMWIPFDRU_0'>"+status.context.Translate("Altro")+"</label>" +
       "</span>" +
       "<span id='LTMWIPFDRU_1_container'>" +
       "<input id='LTMWIPFDRU_1' name='LTMWIPFDRU' type='radio' value="+SPLib.ToHTMLValue("V","C",1,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("V",CPLib.Trim(BO.w_FLTIPGIO))?"CHECKED":"")+">" +
       "<label class='SPLabel' for='LTMWIPFDRU_1'>"+status.context.Translate("VLT")+"</label>" +
       "</span>" +
       "</div>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DJYCCVWMOP_DIV'>" +
       "<label id='DJYCCVWMOP' for='LTMWIPFDRU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipologia:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='RVLRRQTSCQ_DIV'>" +
       "<input name='FLGATTIVO' id='RVLRRQTSCQ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGATTIVO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGATTIVO))?"CHECKED":"")+">" +
       "<label id='RVLRRQTSCQ_LBL' for='RVLRRQTSCQ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Gioco Attivo"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IMPMINGIO' id='UFVFYVMNVG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_IMPMINGIO,"N",10,2,"9,999,999.99", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='10' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZZOTBVRTLQ_DIV'>" +
       "<label id='ZZOTBVRTLQ' for='UFVFYVMNVG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Importo massimo autovalidazione multiple:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IMPMINTOT' id='UVKSMYBGBT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_IMPMINTOT,"N",12,2,"9,999,999.99", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='12' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BKOBIZPXGR_DIV'>" +
       "<label id='BKOBIZPXGR' for='UVKSMYBGBT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Importo Minimo Totale Multiple:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Base@BEGIN") || status.HasZoneAltInterface("Base@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b1_CloseBand(armt_cgo_tbtipgioBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Base@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Base")) {
      status.out.println("Ctrl('YORQOIOBQN').style.height='auto';");
    } else {
      status.out.println("Ctrl('YORQOIOBQN').setAttribute('band_height',434);");
    }
    status.out.println("Ctrl('YORQOIOBQN').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_cgo_tbtipgioBO BO,ServletStatus status) {
    status.out.println(
     "<div name='TipReg' id='PBPNWREDVO_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='PBPNWREDVO_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='PBPNWREDVO_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Tipologie Registrazione")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='PBPNWREDVO_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"PBPNWREDVO\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=PBPNWREDVO_HEADER&m_cBoxId=PBPNWREDVO&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Tipologie Registrazione"))+"");
    }
    status.out.println(
     "<div id='PBPNWREDVO' class='SectionBody' style='position:relative;height:168px;display:block'>" +
    "");
    status.includeZoneAltInterface("TipReg@BEGIN");
    if (status.includeZoneAltInterface("TipReg")) {
      WriteControls_p1_b2_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("TipReg@BEGIN") || status.HasZoneAltInterface("TipReg@END")) {
        status.out.println(
         "<div id='PBPNWREDVO_boxContent' style='position:relative;height:168px;display:block'>" +
        "");
      }
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<iframe name='ardt_cgo_tgtiporeg' id='EKQWOMODBX' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
       "</iframe>" +
      "");
      if (status.HasZoneAltInterface("TipReg@BEGIN") || status.HasZoneAltInterface("TipReg@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b2_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b2_CloseBand(armt_cgo_tbtipgioBO BO,ServletStatus status) {
    status.includeZoneAltInterface("TipReg@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("TipReg")) {
      status.out.println("Ctrl('PBPNWREDVO').style.height='auto';");
    } else {
      status.out.println("Ctrl('PBPNWREDVO').setAttribute('band_height',168);");
    }
    status.out.println("Ctrl('PBPNWREDVO').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['PBPNWREDVO']=['EKQWOMODBX'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b3(armt_cgo_tbtipgioBO BO,ServletStatus status) {
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
  static void PrintState(armt_cgo_tbtipgioBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_cgo_tbtipgioBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
    if (BO.ardt_cgo_tgtiporeg.IsUpdated()) {
      BO.m_cWv_ardt_cgo_tgtiporeg = BO.ardt_cgo_tgtiporeg.GetContext();
    }
  }
  static void PrintStateWorkVars(armt_cgo_tbtipgioBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_CODTPGIO,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESTPGIO,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOGTPGIO,"N",12,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_EDTTPGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DEFTPGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_EDTSPGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DEFSPGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGPLGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGMLGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MAGPAGGIO,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MINPAGGIO,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FDC1OSGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FDC2OSGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FDC3OSGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FDC4OSGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FDC5OSGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FDC6OSGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FDC1SSGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FDC2SSGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FDC3SSGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FDC4SSGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FDC5SSGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FDC6SSGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FDC1ACGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FDC2ACGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FDC3ACGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FDC4ACGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FDC5ACGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FDC6ACGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NCOPAGGIO,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLTIPGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGATTIVO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IMPMINGIO,"N",10,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_IMPMINTOT,"N",12,2));
    if (CPLib.eq(BO.m_cWv_ardt_cgo_tgtiporeg,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_cgo_tgtiporeg");
    } else if (CPLib.eq(BO.m_cWv_ardt_cgo_tgtiporeg,"_not_empty_")) {
      BO.m_cWv_ardt_cgo_tgtiporeg = BO.ardt_cgo_tgtiporeg.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_cgo_tgtiporeg,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_cgo_tgtiporeg,"C",0,0));
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_cgo_tbtipgioBO BO,ServletStatus status) {
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(654,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(701,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_cgo_tbtipgio"),"C",0,0)+ ";");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_cgo_tbtipgio","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_cgo_tbtipgio",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("Base"),"")) {
      status.quoteAndAppend("Base","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_GIMNJEFKNF"),"")) {
      status.quoteAndAppend("box_GIMNJEFKNF","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_MFCHEDYPZM"),"")) {
      status.quoteAndAppend("box_MFCHEDYPZM","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_OERGIOTKFK"),"")) {
      status.quoteAndAppend("box_OERGIOTKFK","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("TipReg"),"")) {
      status.quoteAndAppend("TipReg","hide","box");
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
  void WriteMainFormScript(armt_cgo_tbtipgioBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_cgo_tbtipgio',false);");
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
        status.out.println("if(c=Ctrl('RCAIOHOYCN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PLTDFOMPMX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DLCJAPAHNK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PPZWLBHZXY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SOFGJQQNFS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GOFVHZECXL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NZZQBPTZYU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MRDEGXONBG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FMLKVYWRZP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RNGJQLKVFO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UFVJWZLULG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CAUFCTBRNM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UGCFKKQJNN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XNNAMCGSXP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MYUZABATXZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RSGIDFYOLS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YPMOMULORE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QEKBNPGOBS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NFHGTEJQNE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GJLCDJIDAY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RBOWBOPVOA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DHNVKQKTHK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CBJEEAJCGS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UXGJFWIPXB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TKEHQQFQUC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XBPDZFAWFR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZJMEDHEECW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TOJFZPDKWJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UXAYRLQXMN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MXUUACEBJE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LTMWIPFDRU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RVLRRQTSCQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UFVFYVMNVG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UVKSMYBGBT')) SetDisabled(c,true);");
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
      status.out.println("if (Ctrl('EKQWOMODBX')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('EKQWOMODBX',linkpc_url('EKQWOMODBX'));");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('RCAIOHOYCN')) SetDisabled(c,true);");
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
    status.out.println("if (Eq(name,'ardt_cgo_tgtiporeg')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_cgo_tgtiporeg")+"';");
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
  armt_cgo_tbtipgioBO getBO(ServletStatus status) {
    armt_cgo_tbtipgioBO BO = new armt_cgo_tbtipgioBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_cgo_tbtipgioBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("cgo_tbtipgio",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_cgo_tbtipgioBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_cgo_tbtipgioBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
  }
  CPResultSet QueryKeyCursor(armt_cgo_tbtipgioBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_cgo_tbtipgio;
    String l_cPhName = BO.m_cPhName_cgo_tbtipgio;
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
      String l_cQueryFilter = armt_cgo_tbtipgioBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_cgo_tbtipgio+".CODTPGIO",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("cgo_tbtipgio");
    String l_cPhName = CPSql.ManipulateTablePhName("cgo_tbtipgio",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".CODTPGIO",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,armt_cgo_tbtipgioBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_cgo_tbtipgioBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_cgo_tbtipgio,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_cgo_tbtipgio,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_cgo_tbtipgioBO BO) {
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
  void Edit(ServletStatus status,armt_cgo_tbtipgioBO BO,SPParameterSource source) {
    BO.Load(status.w_CODTPGIO);
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
  void New(ServletStatus status,armt_cgo_tbtipgioBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_cgo_tbtipgioBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_cgo_tbtipgioBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_CODTPGIO = "";
      } else {
        BO.w_CODTPGIO = l_rsKeys.GetString("CODTPGIO");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_CODTPGIO = BO.w_CODTPGIO;
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
  void EditLoad(ServletStatus status,armt_cgo_tbtipgioBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_cgo_tbtipgioBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_CODTPGIO);
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
  void DeleteMessage(ServletStatus status,armt_cgo_tbtipgioBO BO,SPParameterSource source) {
    BO.Load(status.w_CODTPGIO);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_cgo_tbtipgioBO BO) {
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({CODTPGIO:"+SPLib.ToJSValue(BO.w_CODTPGIO,"C",3,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
  void Discard(ServletStatus status,armt_cgo_tbtipgioBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_cgo_tbtipgioBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",614);
    item.put("w",701);
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
    item.put("altInterfaceFor","armt_cgo_tbtipgio");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Base\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Base\",\"h\":434,\"name\":\"Base\",\"page\":1,\"shrinkable\":true,\"spuid\":\"YORQOIOBQN\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Dati Base\",\"titled\":true,\"type\":\"Box\",\"w\":688,\"x\":8,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Gioco\",\"h\":20,\"maxlength\":3,\"name\":\"CODTPGIO\",\"page\":1,\"spuid\":\"RCAIOHOYCN\",\"tabindex\":2,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":112,\"y\":14,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HHFRUECYAF\",\"page\":1,\"spuid\":\"HHFRUECYAF\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Tipo Gioco:\",\"w\":79,\"x\":32,\"y\":18,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Descrizione\",\"h\":20,\"maxlength\":50,\"name\":\"DESTPGIO\",\"page\":1,\"spuid\":\"PLTDFOMPMX\",\"tabindex\":4,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":376,\"x\":112,\"y\":42,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RSSVRXXCCP\",\"page\":1,\"spuid\":\"RSSVRXXCCP\",\"tabindex\":5,\"type\":\"Label\",\"value\":\"Descrizione:\",\"w\":63,\"x\":48,\"y\":46,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Soglia pagamento\",\"h\":20,\"maxlength\":17,\"name\":\"SOGTPGIO\",\"page\":1,\"spuid\":\"DLCJAPAHNK\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":84,\"x\":600,\"y\":42,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BEHWXHTIBN\",\"page\":1,\"spuid\":\"BEHWXHTIBN\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"Soglia pagamento:\",\"w\":97,\"x\":503,\"y\":46,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Abilita modifica Scelta\",\"h\":21,\"label_text\":\"Abilita modifica Sopra Soglia\",\"maxlength\":1,\"name\":\"EDTTPGIO\",\"page\":1,\"spuid\":\"PPZWLBHZXY\",\"tabindex\":7,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":176,\"x\":112,\"y\":70,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Default pagamento\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"DEFTPGIO\",\"page\":1,\"spuid\":\"SOFGJQQNFS\",\"tabindex\":8,\"textlist\":\"Agenzia,Concessionario\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"A"+"'"+","+"'"+"S"+"'"+"\",\"w\":216,\"x\":472,\"y\":70,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TENXMNLTTK\",\"page\":1,\"spuid\":\"TENXMNLTTK\",\"tabindex\":10,\"type\":\"Label\",\"value\":\"Default pagamento sopra soglia:\",\"w\":171,\"x\":301,\"y\":74,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Abilita Modifica Sotto Soglia\",\"h\":21,\"label_text\":\"Abilita modifica Sotto Soglia\",\"maxlength\":1,\"name\":\"EDTSPGIO\",\"page\":1,\"spuid\":\"GOFVHZECXL\",\"tabindex\":11,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":176,\"x\":112,\"y\":98,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Default Sotto Soglia\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"DEFSPGIO\",\"page\":1,\"spuid\":\"NZZQBPTZYU\",\"tabindex\":12,\"textlist\":\"Agenzia,Concessionario\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"A"+"'"+","+"'"+"S"+"'"+"\",\"w\":216,\"x\":472,\"y\":98,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VPKIKBZRVZ\",\"page\":1,\"spuid\":\"VPKIKBZRVZ\",\"tabindex\":13,\"type\":\"Label\",\"value\":\"Default pagamento sotto soglia:\",\"w\":171,\"x\":301,\"y\":102,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Abilita Selezione Piattaforma\",\"h\":21,\"label_text\":\"Abilita Selezione Piattaforma\",\"maxlength\":1,\"name\":\"FLGPLGIO\",\"page\":1,\"spuid\":\"MRDEGXONBG\",\"tabindex\":14,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":176,\"x\":112,\"y\":125,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Inserimento Operazioni Multiple\",\"h\":21,\"label_text\":\"Abilita Inserimento Operazioni Multiple\",\"maxlength\":1,\"name\":\"FLGMLGIO\",\"page\":1,\"spuid\":\"FMLKVYWRZP\",\"tabindex\":15,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":216,\"x\":112,\"y\":154,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_GIMNJEFKNF\",\"box_type\":\"titled_box\",\"comment\":\"Moduli Sopra Soglia\",\"h\":217,\"name\":\"box_GIMNJEFKNF\",\"page\":1,\"shrinkable\":true,\"spuid\":\"GIMNJEFKNF\",\"tabindex\":20,\"title_caption\":\"Moduli Sopra Soglia\",\"titled\":true,\"type\":\"Box\",\"w\":208,\"x\":24,\"y\":210,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"N\\u00B0 Massimo Pagine Documento Unico o N\\u00B0 Max Documenti\",\"h\":20,\"maxlength\":3,\"name\":\"MAGPAGGIO\",\"page\":1,\"spuid\":\"RNGJQLKVFO\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":160,\"y\":399,\"zone\":\"pag1_1_7_1\",\"zonepath\":\"[1,1,7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ITKWXOHKBK\",\"page\":1,\"spuid\":\"ITKWXOHKBK\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"N\\u00B0 Pagine Doc. Unico:\",\"w\":120,\"x\":40,\"y\":403,\"zone\":\"pag1_1_7_1\",\"zonepath\":\"[1,1,7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Adeguata Verifica Sopra Soglia\",\"h\":21,\"label_text\":\"Adeguata Verifica\",\"maxlength\":1,\"name\":\"FDC1OSGIO\",\"page\":1,\"spuid\":\"CAUFCTBRNM\",\"tabindex\":19,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":56,\"y\":343,\"zone\":\"pag1_1_7_2\",\"zonepath\":\"[1,1,7,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Copia Biglietto\",\"h\":21,\"label_text\":\"Biglietto\\/Ticket\",\"maxlength\":1,\"name\":\"FDC2OSGIO\",\"page\":1,\"spuid\":\"UGCFKKQJNN\",\"tabindex\":22,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":56,\"y\":287,\"zone\":\"pag1_1_7_3\",\"zonepath\":\"[1,1,7,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Codice Fiscale\",\"h\":21,\"label_text\":\"Codice Fiscale\",\"maxlength\":1,\"name\":\"FDC3OSGIO\",\"page\":1,\"spuid\":\"XNNAMCGSXP\",\"tabindex\":23,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":56,\"y\":259,\"zone\":\"pag1_1_7_4\",\"zonepath\":\"[1,1,7,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Codice Fiscale\",\"h\":21,\"label_text\":\"Documento di Identit\\u00E0\",\"maxlength\":1,\"name\":\"FDC4OSGIO\",\"page\":1,\"spuid\":\"MYUZABATXZ\",\"tabindex\":24,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":56,\"y\":231,\"zone\":\"pag1_1_7_5\",\"zonepath\":\"[1,1,7,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Codice Fiscale\",\"h\":21,\"label_text\":\"Mezzo di Pagamento\",\"maxlength\":1,\"name\":\"FDC5OSGIO\",\"page\":1,\"spuid\":\"RSGIDFYOLS\",\"tabindex\":25,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":56,\"y\":315,\"zone\":\"pag1_1_7_6\",\"zonepath\":\"[1,1,7,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Codice Fiscale\",\"h\":21,\"label_text\":\"Obbligazione\",\"maxlength\":1,\"name\":\"FDC6OSGIO\",\"page\":1,\"spuid\":\"YPMOMULORE\",\"tabindex\":26,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":56,\"y\":371,\"zone\":\"pag1_1_7_7\",\"zonepath\":\"[1,1,7,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_MFCHEDYPZM\",\"box_type\":\"titled_box\",\"comment\":\"Moduli Sotto Soglia\",\"h\":217,\"name\":\"box_MFCHEDYPZM\",\"page\":1,\"shrinkable\":true,\"spuid\":\"MFCHEDYPZM\",\"tabindex\":21,\"title_caption\":\"Moduli Sotto Soglia\",\"titled\":true,\"type\":\"Box\",\"w\":208,\"x\":248,\"y\":210,\"zone\":\"pag1_1_8\",\"zonepath\":\"[1,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"N\\u00B0 Pagine Documento Unico o N\\u00B0 Documenti (Importo Sotto Soglia):\",\"h\":20,\"maxlength\":3,\"name\":\"MINPAGGIO\",\"page\":1,\"spuid\":\"UFVJWZLULG\",\"tabindex\":18,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":384,\"y\":399,\"zone\":\"pag1_1_8_1\",\"zonepath\":\"[1,1,8,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QPPLTIMJLH\",\"page\":1,\"spuid\":\"QPPLTIMJLH\",\"tabindex\":40,\"type\":\"Label\",\"value\":\"N\\u00B0 Pagine Doc. Unico:\",\"w\":120,\"x\":264,\"y\":403,\"zone\":\"pag1_1_8_1\",\"zonepath\":\"[1,1,8,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Adeguata Verifica Sopra Soglia\",\"h\":21,\"label_text\":\"Adeguata Verifica\",\"maxlength\":1,\"name\":\"FDC1SSGIO\",\"page\":1,\"spuid\":\"QEKBNPGOBS\",\"tabindex\":27,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":280,\"y\":343,\"zone\":\"pag1_1_8_2\",\"zonepath\":\"[1,1,8,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Copia Biglietto\",\"h\":21,\"label_text\":\"Biglietto\\/Ticket\",\"maxlength\":1,\"name\":\"FDC2SSGIO\",\"page\":1,\"spuid\":\"NFHGTEJQNE\",\"tabindex\":28,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":280,\"y\":287,\"zone\":\"pag1_1_8_3\",\"zonepath\":\"[1,1,8,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Codice Fiscale\",\"h\":21,\"label_text\":\"Codice Fiscale\",\"maxlength\":1,\"name\":\"FDC3SSGIO\",\"page\":1,\"spuid\":\"GJLCDJIDAY\",\"tabindex\":29,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":280,\"y\":259,\"zone\":\"pag1_1_8_4\",\"zonepath\":\"[1,1,8,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Codice Fiscale\",\"h\":21,\"label_text\":\"Documento di Identit\\u00E0\",\"maxlength\":1,\"name\":\"FDC4SSGIO\",\"page\":1,\"spuid\":\"RBOWBOPVOA\",\"tabindex\":30,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":280,\"y\":231,\"zone\":\"pag1_1_8_5\",\"zonepath\":\"[1,1,8,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Codice Fiscale\",\"h\":21,\"label_text\":\"Mezzo di Pagamento\",\"maxlength\":1,\"name\":\"FDC5SSGIO\",\"page\":1,\"spuid\":\"DHNVKQKTHK\",\"tabindex\":31,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":280,\"y\":315,\"zone\":\"pag1_1_8_6\",\"zonepath\":\"[1,1,8,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Codice Fiscale\",\"h\":21,\"label_text\":\"Obbligazione\",\"maxlength\":1,\"name\":\"FDC6SSGIO\",\"page\":1,\"spuid\":\"CBJEEAJCGS\",\"tabindex\":32,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":280,\"y\":371,\"zone\":\"pag1_1_8_7\",\"zonepath\":\"[1,1,8,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_OERGIOTKFK\",\"box_type\":\"titled_box\",\"comment\":\"Attivi se pagamento in contanti\",\"h\":217,\"name\":\"box_OERGIOTKFK\",\"page\":1,\"shrinkable\":true,\"spuid\":\"OERGIOTKFK\",\"tabindex\":33,\"title_caption\":\"Attivi se pagamento in contanti\",\"titled\":true,\"type\":\"Box\",\"w\":208,\"x\":472,\"y\":210,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Adeguata Verifica Sopra Soglia\",\"h\":21,\"label_text\":\"Adeguata Verifica\",\"maxlength\":1,\"name\":\"FDC1ACGIO\",\"page\":1,\"spuid\":\"UXGJFWIPXB\",\"tabindex\":34,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":504,\"y\":343,\"zone\":\"pag1_1_9_1\",\"zonepath\":\"[1,1,9,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Copia Biglietto\",\"h\":21,\"label_text\":\"Biglietto\\/Ticket\",\"maxlength\":1,\"name\":\"FDC2ACGIO\",\"page\":1,\"spuid\":\"TKEHQQFQUC\",\"tabindex\":35,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":504,\"y\":287,\"zone\":\"pag1_1_9_2\",\"zonepath\":\"[1,1,9,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Codice Fiscale\",\"h\":21,\"label_text\":\"Codice Fiscale\",\"maxlength\":1,\"name\":\"FDC3ACGIO\",\"page\":1,\"spuid\":\"XBPDZFAWFR\",\"tabindex\":36,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":504,\"y\":259,\"zone\":\"pag1_1_9_3\",\"zonepath\":\"[1,1,9,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Codice Fiscale\",\"h\":21,\"label_text\":\"Documento di Identit\\u00E0\",\"maxlength\":1,\"name\":\"FDC4ACGIO\",\"page\":1,\"spuid\":\"ZJMEDHEECW\",\"tabindex\":37,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":504,\"y\":231,\"zone\":\"pag1_1_9_4\",\"zonepath\":\"[1,1,9,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Codice Fiscale\",\"h\":21,\"label_text\":\"Mezzo di Pagamento\",\"maxlength\":1,\"name\":\"FDC5ACGIO\",\"page\":1,\"spuid\":\"TOJFZPDKWJ\",\"tabindex\":38,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":504,\"y\":315,\"zone\":\"pag1_1_9_5\",\"zonepath\":\"[1,1,9,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Codice Fiscale\",\"h\":21,\"label_text\":\"Obbligazione\",\"maxlength\":1,\"name\":\"FDC6ACGIO\",\"page\":1,\"spuid\":\"UXAYRLQXMN\",\"tabindex\":39,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":160,\"x\":504,\"y\":371,\"zone\":\"pag1_1_9_6\",\"zonepath\":\"[1,1,9,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"N\\u00B0 pagine Pagamento in contanti\",\"h\":20,\"maxlength\":3,\"name\":\"NCOPAGGIO\",\"page\":1,\"spuid\":\"MXUUACEBJE\",\"tabindex\":41,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":600,\"y\":399,\"zone\":\"pag1_1_9_7\",\"zonepath\":\"[1,1,9,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GPUIIBJKGO\",\"page\":1,\"spuid\":\"GPUIIBJKGO\",\"tabindex\":42,\"type\":\"Label\",\"value\":\"N\\u00B0 Pagine Doc. Unico:\",\"w\":120,\"x\":480,\"y\":403,\"zone\":\"pag1_1_9_7\",\"zonepath\":\"[1,1,9,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipologia\",\"h\":19,\"maxlength\":1,\"name\":\"FLTIPGIO\",\"orientation\":\"horizontal\",\"page\":1,\"spuid\":\"LTMWIPFDRU\",\"tabindex\":45,\"type\":\"Radio\",\"typevar\":\"character\",\"w\":104,\"x\":584,\"y\":14,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DJYCCVWMOP\",\"page\":1,\"spuid\":\"DJYCCVWMOP\",\"tabindex\":46,\"type\":\"Label\",\"value\":\"Tipologia:\",\"w\":58,\"x\":519,\"y\":14,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Tipo Gioco Attivo\",\"h\":21,\"label_text\":\"Tipo Gioco Attivo\",\"maxlength\":1,\"name\":\"FLGATTIVO\",\"page\":1,\"spuid\":\"RVLRRQTSCQ\",\"tabindex\":47,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":128,\"x\":295,\"y\":13,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Importo minimo autovalidazione multiple\",\"h\":20,\"maxlength\":15,\"name\":\"IMPMINGIO\",\"page\":1,\"spuid\":\"UFVFYVMNVG\",\"tabindex\":48,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":80,\"x\":600,\"y\":154,\"zone\":\"pag1_1_11\",\"zonepath\":\"[1,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZZOTBVRTLQ\",\"page\":1,\"spuid\":\"ZZOTBVRTLQ\",\"tabindex\":49,\"type\":\"Label\",\"value\":\"Importo massimo autovalidazione multiple:\",\"w\":222,\"x\":378,\"y\":158,\"zone\":\"pag1_1_11\",\"zonepath\":\"[1,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Importo Minimo Totale Multiple\",\"h\":20,\"maxlength\":15,\"name\":\"IMPMINTOT\",\"page\":1,\"spuid\":\"UVKSMYBGBT\",\"tabindex\":50,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":80,\"x\":600,\"y\":182,\"zone\":\"pag1_1_12\",\"zonepath\":\"[1,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BKOBIZPXGR\",\"page\":1,\"spuid\":\"BKOBIZPXGR\",\"tabindex\":51,\"type\":\"Label\",\"value\":\"Importo Minimo Totale Multiple:\",\"w\":163,\"x\":437,\"y\":186,\"zone\":\"pag1_1_12\",\"zonepath\":\"[1,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"TipReg\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Tipologie Registrazione\",\"h\":168,\"name\":\"TipReg\",\"page\":1,\"shrinkable\":true,\"spuid\":\"PBPNWREDVO\",\"stretch\":true,\"tabindex\":43,\"title_caption\":\"Tipologie Registrazione\",\"titled\":true,\"type\":\"Box\",\"w\":688,\"x\":8,\"y\":441,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":145,\"name\":\"ardt_cgo_tgtiporeg\",\"page\":1,\"spuid\":\"EKQWOMODBX\",\"tabindex\":44,\"type\":\"Iframe\",\"w\":357,\"x\":168,\"y\":452,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_cgo_tbtipgioBO BO,ServletStatus status) {
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
     "<script src='armt_cgo_tbtipgio?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_tbtipgio_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_tbtipgio_edit.js'>" +
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
      status.out.println("w_CODTPGIO=a[0];");
      status.out.println("w_DESTPGIO=a[1];");
      status.out.println("w_SOGTPGIO=a[2];");
      status.out.println("w_EDTTPGIO=a[3];");
      status.out.println("w_DEFTPGIO=a[4];");
      status.out.println("w_EDTSPGIO=a[5];");
      status.out.println("w_DEFSPGIO=a[6];");
      status.out.println("w_FLGPLGIO=a[7];");
      status.out.println("w_FLGMLGIO=a[8];");
      status.out.println("w_MAGPAGGIO=a[9];");
      status.out.println("w_MINPAGGIO=a[10];");
      status.out.println("w_FDC1OSGIO=a[11];");
      status.out.println("w_FDC2OSGIO=a[12];");
      status.out.println("w_FDC3OSGIO=a[13];");
      status.out.println("w_FDC4OSGIO=a[14];");
      status.out.println("w_FDC5OSGIO=a[15];");
      status.out.println("w_FDC6OSGIO=a[16];");
      status.out.println("w_FDC1SSGIO=a[17];");
      status.out.println("w_FDC2SSGIO=a[18];");
      status.out.println("w_FDC3SSGIO=a[19];");
      status.out.println("w_FDC4SSGIO=a[20];");
      status.out.println("w_FDC5SSGIO=a[21];");
      status.out.println("w_FDC6SSGIO=a[22];");
      status.out.println("w_FDC1ACGIO=a[23];");
      status.out.println("w_FDC2ACGIO=a[24];");
      status.out.println("w_FDC3ACGIO=a[25];");
      status.out.println("w_FDC4ACGIO=a[26];");
      status.out.println("w_FDC5ACGIO=a[27];");
      status.out.println("w_FDC6ACGIO=a[28];");
      status.out.println("w_NCOPAGGIO=a[29];");
      status.out.println("w_FLTIPGIO=a[30];");
      status.out.println("w_FLGATTIVO=a[31];");
      status.out.println("w_IMPMINGIO=a[32];");
      status.out.println("w_IMPMINTOT=a[33];");
      status.out.println("m_cWv_ardt_cgo_tgtiporeg=a[34];");
      status.out.println("if (Gt(a.length,35)) {");
      status.out.println("m_cErrorInChild='';");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['CODTPGIO'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_tbtipgio_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(654,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","cgo_tbtipgio");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","CODTPGIO");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(armt_cgo_tbtipgioBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({CODTPGIO:"+SPLib.ToJSValue(BO.w_CODTPGIO,"C",3,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_cgo_tbtipgioBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({CODTPGIO:"+SPLib.ToJSValue(BO.w_CODTPGIO,"C",3,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armt_cgo_tbtipgioBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({CODTPGIO:"+SPLib.ToJSValue(BO.w_CODTPGIO,"C",3,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armt_cgo_tbtipgioBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({CODTPGIO:"+SPLib.ToJSValue(BO.w_CODTPGIO,"C",3,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armt_cgo_tbtipgioBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({CODTPGIO:"+SPLib.ToJSValue(BO.w_CODTPGIO,"C",3,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_cgo_tbtipgioBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_cgo_tbtipgioBO BO,ServletStatus status) throws IOException {
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
      CPLib.AddToSet(callable,"ardt_cgo_tgtiporeg");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_cgo_tbtipgioBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_CODTPGIO),"C",3,0));
      }
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_cgo_tbtipgioBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
    }
    return result;
  }
}
