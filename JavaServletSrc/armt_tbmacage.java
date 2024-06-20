import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_tbmacage extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*d1661704*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "tbmacage";
    }
    public String w_MACODICE;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_MACODICE,context,"tbmacage","MACODICE","C",5,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='MACODICE' type='hidden' value="+SPLib.ToHTMLValue(w_MACODICE,"C",5,0)+">" +
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
    armt_tbmacageBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_tbmacage;
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
      status.w_MACODICE = BO.w_MACODICE;
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
    return "MacroAgente";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_tbmacage";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 1085;
    l_eg.m_nEntityHeight = 240;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"tbmacage","anadip","tbstati","tbcitta"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page"),new ZoneItem("Base","Dati Base","horizontal_section"),new ZoneItem("PF","Persona Fisica","horizontal_section"),new ZoneItem("PG","Persona Giuridica","horizontal_section"),new ZoneItem("WU","Dati WU","horizontal_section"),new ZoneItem("Residenza","Residenza","titled_section"),new ZoneItem("Domicilio","Domicilio","titled_section"),new ZoneItem("SedeLegale","Sede Legale","titled_section"),new ZoneItem("RL","Responsabili Legali","horizontal_section"),new ZoneItem("SO","Sedi Operative","horizontal_section")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"MACODICE"};
    l_eg.items = new SPItem[]{
                   new SPItem("gFlgWU","C",1,0, "hide","Gestione WU"),
                   new SPItem("MACODICE","C",5,0, "edit","Codice"),
                   new SPItem("MADESCRI","C",120,0, "edit","Denominazione"),
                   new SPItem("MAFLGRAP","C",1,0, "edit","Generazione Rapporti da operazioni"),
                   new SPItem("MAFLGOPE","C",1,0, "edit","Scrivi su Operazioni o Frazionate"),
                   new SPItem("MAFLGBON","C",1,0, "edit","Scrive tipo operazione come bonifico"),
                   new SPItem("MAFLGCKR","C",1,0, "edit","Controllo esistenza Rapporto"),
                   new SPItem("MAFLGASR","C",1,0, "edit","Associa Operazione a Rapporto"),
                   new SPItem("MAFLGNOX","C",1,0, "edit","Non creare Operazioni Extraconto"),
                   new SPItem("MADIPSTD","C",6,0, "edit","Dipendenza Standard"),
                   new SPItem("xDESDIP","C",30,0, "hide","Descrizione"),
                   new SPItem("MANAIDWU","C",5,0, "edit","NAID"),
                   new SPItem("MAFLGCHKDAT","C",1,0, "edit","Dati certi per Soggetti"),
                   new SPItem("MAFLGACT","C",1,0, "edit","Macrosgente operativo"),
                   new SPItem("MARESSDEF","C",3,0, "edit","Paese Res. Default"),
                   new SPItem("despaese","C",40,0, "hide","Descrizione"),
                   new SPItem("MAFLGAUA","C",1,0, "edit","Escludi Controlli AUA"),
                   new SPItem("MATIPAGE","C",1,0, "edit","Tipo Agente"),
                   new SPItem("MAFISGIU","C",1,0, "edit","Specie Giuridica"),
                   new SPItem("MADATINI","D",8,0, "edit","Data Inizio Rapporto"),
                   new SPItem("MADATFIN","D",8,0, "edit","Fine Rapporto"),
                   new SPItem("MADATMOD","D",8,0, "edit","Data Ultimo Aggiornamento"),
                   new SPItem("MACODFIS","C",16,0, "edit","Codice Fiscale/P.IVA"),
                   new SPItem("MACOGNOME","C",50,0, "edit","Cognome"),
                   new SPItem("MANOME","C",50,0, "edit","Nome"),
                   new SPItem("MARESPAESE","C",3,0, "edit","Paese Residenza"),
                   new SPItem("MARESCITTA","C",60,0, "edit","Città"),
                   new SPItem("MARESCAP","C",15,0, "edit","CAP"),
                   new SPItem("MARESPRV","C",2,0, "edit","Provincia"),
                   new SPItem("xDESSTARES","C",40,0, "hide","Descrizione"),
                   new SPItem("MARESIND","C",50,0, "edit","Indirizzo"),
                   new SPItem("MARESNCIV","C",15,0, "edit","N. Civico"),
                   new SPItem("MADOMPAESE","C",3,0, "edit","Paese Residenza"),
                   new SPItem("MADOMCITTA","C",60,0, "edit","Città"),
                   new SPItem("MADOMCAP","C",15,0, "edit","CAP"),
                   new SPItem("MADOMPRV","C",2,0, "edit","Provincia"),
                   new SPItem("MADOMIND","C",50,0, "edit","Indirizzo"),
                   new SPItem("MADOMNCIV","C",15,0, "edit","N. Civico"),
                   new SPItem("xDESSTADOM","C",40,0, "hide","Descrizione"),
                   new SPItem("MARESPAESE","C",3,0, "edit","Paese Residenza"),
                   new SPItem("MARESCITTA","C",60,0, "edit","Città"),
                   new SPItem("MARESIND","C",50,0, "edit","Indirizzo"),
                   new SPItem("MARESNCIV","C",15,0, "edit","N. Civico"),
                   new SPItem("MARESCAP","C",15,0, "edit","CAP"),
                   new SPItem("MARESPRV","C",2,0, "edit","Provincia"),
                   new SPItem("MAFLGCOMPL","N",1,0, "edit","Chiusura per compliance")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_tbmacageBO BO) {
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
    {"10751018373",p_Context.Translate("Considera dati anagrafici certi")},
    {"10983493593",p_Context.Translate("Gestione WU")},
    {"11132404598",p_Context.Translate("Codice Fiscale/P.IVA")},
    {"11148783093",p_Context.Translate("MacroAgente")},
    {"11153969262",p_Context.Translate("Tipo Agente")},
    {"112851763",p_Context.Translate("Codice")},
    {"11553173743",p_Context.Translate("Escludi Controlli AUA")},
    {"11597156451",p_Context.Translate("N. Civico")},
    {"116301484",p_Context.Translate("Dipendenze / Agenzie")},
    {"11895403464",p_Context.Translate("Scrivi su Operazioni o Frazionate")},
    {"12056209762",p_Context.Translate("Denominazione")},
    {"1213122220",p_Context.Translate("MacroAgente Operativo")},
    {"1267648172",p_Context.Translate("Macrosgente operativo")},
    {"1325233457",p_Context.Translate("Obbligatoria se chiusura per compliance")},
    {"1331482594",p_Context.Translate("Generazione Rapporti da operazioni")},
    {"1331668514",p_Context.Translate("Scrive tipo operazione come bonifico")},
    {"1402859319",p_Context.Translate("Dati certi per Soggetti")},
    {"15186643",p_Context.Translate("Città")},
    {"1547044447",p_Context.Translate("Paese Res. Default")},
    {"1676510859",p_Context.Translate("Data Ultimo Aggiornamento")},
    {"1723694646",p_Context.Translate("Fine Rapporto")},
    {"1816546867",p_Context.Translate("Cognome")},
    {"1826506593",p_Context.Translate("Scrive operazione non in contanti")},
    {"1970676031",p_Context.Translate("Controllo esistenza Rapporto")},
    {"2032298989",p_Context.Translate("Data Inizio Rapporto")},
    {"21587",p_Context.Translate("CAP")},
    {"226580067",p_Context.Translate("Paese Residenza")},
    {"280667660",p_Context.Translate("Specie Giuridica")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"298334",p_Context.Translate("NAID")},
    {"4098271",p_Context.Translate("Dipendenza Standard")},
    {"443454",p_Context.Translate("Nome")},
    {"554236824",p_Context.Translate("Indirizzo")},
    {"7383187",p_Context.Translate("Stati")},
    {"801105630",p_Context.Translate("Associa Operazione a Rapporto")},
    {"940604062",p_Context.Translate("Non creare Operazioni Extraconto")},
    {"940604062",p_Context.Translate("Non creare operazioni ExtraConto")},
    {"986106899",p_Context.Translate("Chiusura per compliance")}};
    return l_translations;
  }
  void WriteStyles(armt_tbmacageBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_tbmacage.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_tbmacageBO BO,ServletStatus status) {
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
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_tbmacage',false);");
    }
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_tbmacage",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  // GetPortlet_Object_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_MIOGGDHBIQ_Vars(armt_tbmacageBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_MACODAGE",BO.w_MACODICE);
    return inclusionVars;
  }
  void WriteControls(armt_tbmacageBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,2);
  }
  void WriteControls_p1(armt_tbmacageBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:240px;width:1085px;display:none'>" +
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
    WriteControls_p1_b11(BO,status);
    WriteControls_p1_b12(BO,status);
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
  void WriteControls_p1_b0(armt_tbmacageBO BO,ServletStatus status) {
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
  void WriteControls_p1_b1(armt_tbmacageBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Base' id='UBUBESGOCL_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='UBUBESGOCL_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='UBUBESGOCL_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Base")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='UBUBESGOCL_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"UBUBESGOCL\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=UBUBESGOCL_HEADER&m_cBoxId=UBUBESGOCL&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Base"))+"");
    }
    status.out.println(
     "<div id='UBUBESGOCL' class='SectionBody' style='position:relative;height:77px;display:block'>" +
    "");
    status.includeZoneAltInterface("Base@BEGIN");
    if (status.includeZoneAltInterface("Base")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Base@BEGIN") || status.HasZoneAltInterface("Base@END")) {
        status.out.println(
         "<div id='UBUBESGOCL_boxContent' style='position:relative;height:77px;display:block'>" +
        "");
      }
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MACODICE' id='LVIYDAHUQL' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_MACODICE,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='5' size='5' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XKNWYVGCBE_DIV'>" +
       "<label id='XKNWYVGCBE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='MATIPAGE' id='HUKDVHFFUB' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("A","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("A",CPLib.Trim(BO.w_MATIPAGE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Agente")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("C","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("C",CPLib.Trim(BO.w_MATIPAGE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Convenzionato")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('HUKDVHFFUB'),w_MATIPAGE,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RUIZMYEJXT_DIV'>" +
       "<label id='RUIZMYEJXT' for='HUKDVHFFUB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Agente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='MAFISGIU' id='TCJHVDJTUY' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("P","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("P",CPLib.Trim(BO.w_MAFISGIU))?"SELECTED":"")+">" +
       ""+status.context.Translate("Persona Fisica")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("G","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("G",CPLib.Trim(BO.w_MAFISGIU))?"SELECTED":"")+">" +
       ""+status.context.Translate("Persona Giuridica")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('TCJHVDJTUY'),w_MAFISGIU,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GURVSIKVQI_DIV'>" +
       "<label id='GURVSIKVQI' for='TCJHVDJTUY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Specie Giuridica:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MADATINI' id='RROACIQRKN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MADATINI,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='RROACIQRKN_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BNDYHPCUPK_DIV'>" +
       "<label id='BNDYHPCUPK' for='RROACIQRKN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Inizio Rapporto:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MADATFIN' id='UYKWSCJLEB' type='text' class='"+status.ObligatoryClass("Field",BO.UYKWSCJLEB_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_MADATFIN,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='UYKWSCJLEB_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BMQRTBDRHY_DIV'>" +
       "<label id='BMQRTBDRHY' for='UYKWSCJLEB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Fine Rapporto:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MADATMOD' id='MGUFLYJWMR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MADATMOD,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='MGUFLYJWMR_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VOAMRHZCGF_DIV'>" +
       "<label id='VOAMRHZCGF' for='MGUFLYJWMR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Ultimo Aggiornamento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MACODFIS' id='OPANBXIPXY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MACODFIS,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZJGWZLUOZI_DIV'>" +
       "<label id='ZJGWZLUOZI' for='OPANBXIPXY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale/P.IVA:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='MGGEMJQGRJ_DIV'>" +
       "<input name='MAFLGCOMPL' id='MGGEMJQGRJ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_MAFLGCOMPL,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_MAFLGCOMPL)?"CHECKED":"")+">" +
       "<label id='MGGEMJQGRJ_LBL' for='MGGEMJQGRJ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Chiusura per compliance"))+"</label>" +
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
  void WriteControls_p1_b1_CloseBand(armt_tbmacageBO BO,ServletStatus status) {
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
      status.out.println("Ctrl('UBUBESGOCL').style.height='auto';");
    } else {
      status.out.println("Ctrl('UBUBESGOCL').setAttribute('band_height',77);");
    }
    status.out.println("Ctrl('UBUBESGOCL').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_tbmacageBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_FZFECYSHCA")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_FZFECYSHCA' style='position:relative;height:7px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_FZFECYSHCA")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_FZFECYSHCA').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b3(armt_tbmacageBO BO,ServletStatus status) {
    status.out.println(
     "<div id='tabs_1_DatiBase_container'>" +
     " " +
     "</div>" +
    "");
    status.out.println(
     "<div name='PF' id='FZFECYSHCA_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' style='display:none' group_id='tabs_1_DatiBase'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var tabs_1_DatiBase = new Z.Tabs({container:'tabs_1_DatiBase_container',useGlobals: false,boxtabs: true,useseparator:GetStyleVariable('boxTabUseSeparator',null,''),expandcollapse:GetStyleVariable('boxTabCanCollapse',null,''),contents:[],tabstrip_class: ''});");
    status.out.println("Z.Tabs.Set('tabs_1_DatiBase',tabs_1_DatiBase);");
    status.out.println("var l_nFZFECYSHCATabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='FZFECYSHCA' class='TabStripBoxBody' style='position:relative;height:289px;display:none'>" +
    "");
    status.includeZoneAltInterface("PF@BEGIN");
    if (status.includeZoneAltInterface("PF")) {
      WriteControls_p1_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("PF@BEGIN") || status.HasZoneAltInterface("PF@END")) {
        status.out.println(
         "<div id='FZFECYSHCA_boxContent' style='position:relative;height:289px;display:block'>" +
        "");
      }
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MACOGNOME' id='ESOMNUPHTE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MACOGNOME,"C",50,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MANOME' id='ZXBKIFGVGY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MANOME,"C",50,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YFJANWHXCV_DIV'>" +
       "<label id='YFJANWHXCV' for='ESOMNUPHTE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cognome:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<div id='QLICUFUCES_DIV' class='TitledSection'>" +
       "<span id='QLICUFUCES_HEADER_CAPTION' class='DefaultTitledBox'>"+status.context.Translate("Residenza")+"</span>" +
       "<div id='QLICUFUCES'>" +
       "</div>" +
       "</div>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MARESPAESE' id='BFMOWHWVBP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MARESPAESE,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='BFMOWHWVBP_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "BFMOWHWVBP", "tbstati", "armt_stati", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MARESCITTA' id='ODQOMCYUIH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MARESCITTA,"C",60,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='60' size='60' fieldtype='C'>" +
       "<button id='ODQOMCYUIH_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "ODQOMCYUIH", "tbcitta", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MARESCAP' id='LWTLGAYOFY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MARESCAP,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MARESPRV' id='UHIQZUDMGI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MARESPRV,"C",2,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YDGLQSLLPS_DIV'>" +
       "<label id='YDGLQSLLPS' for='BFMOWHWVBP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Paese:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='AYAXIAXHNF_DIV'>" +
       "<label id='AYAXIAXHNF'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xDESSTARES)+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MARESIND' id='MURAEDMCDC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MARESIND,"C",50,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JJADBFUOHS_DIV'>" +
       "<label id='JJADBFUOHS' for='MURAEDMCDC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Indirizzo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MARESNCIV' id='FQYPBTRCED' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MARESNCIV,"C",15,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FUVOTLRTOO_DIV'>" +
       "<label id='FUVOTLRTOO' for='FQYPBTRCED'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("N. Civico:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='IZRFLVHCWH_DIV'>" +
       "<label id='IZRFLVHCWH' for='LWTLGAYOFY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAP:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DDSGHKAKIP_DIV' style='display:none'>" +
       "<label id='DDSGHKAKIP' for='UHIQZUDMGI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Provincia:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RRKIDUJKND_DIV'>" +
       "<label id='RRKIDUJKND' for='ODQOMCYUIH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Città:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<div id='ESTMSWKOOS_DIV' class='TitledSection'>" +
       "<span id='ESTMSWKOOS_HEADER_CAPTION' class='DefaultTitledBox'>"+status.context.Translate("Domicilio")+"</span>" +
       "<div id='ESTMSWKOOS'>" +
       "</div>" +
       "</div>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MADOMPAESE' id='DJVPNMOUXM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MADOMPAESE,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='DJVPNMOUXM_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "DJVPNMOUXM", "tbstati", "armt_stati", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MADOMCITTA' id='UUHMAJHIGT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MADOMCITTA,"C",60,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='60' size='60' fieldtype='C'>" +
       "<button id='UUHMAJHIGT_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "UUHMAJHIGT", "tbcitta", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MADOMCAP' id='WEAMCVVDVI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MADOMCAP,"C",15,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MADOMPRV' id='ZQOYBAIYYW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MADOMPRV,"C",2,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CZLOZIJQYR_DIV'>" +
       "<label id='CZLOZIJQYR' for='DJVPNMOUXM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Paese:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UJYVVYZVCK_DIV'>" +
       "<label id='UJYVVYZVCK'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xDESSTADOM)+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MADOMIND' id='AZHKYECVLF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MADOMIND,"C",50,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XUEHNZJRPC_DIV'>" +
       "<label id='XUEHNZJRPC' for='AZHKYECVLF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Indirizzo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MADOMNCIV' id='DRNUGFPEBE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MADOMNCIV,"C",15,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FFDHPXIQUB_DIV'>" +
       "<label id='FFDHPXIQUB' for='DRNUGFPEBE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("N. Civico:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FWHTUJNUGD_DIV'>" +
       "<label id='FWHTUJNUGD' for='WEAMCVVDVI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAP:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HQJYVIBPZH_DIV' style='display:none'>" +
       "<label id='HQJYVIBPZH' for='ZQOYBAIYYW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Provincia:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BMYDWAIPBZ_DIV'>" +
       "<label id='BMYDWAIPBZ' for='UUHMAJHIGT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Città:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='IZNJQFOXAR_DIV'>" +
       "<label id='IZNJQFOXAR' for='ZXBKIFGVGY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nome:"))+"" +
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
  void WriteControls_p1_b3_CloseBand(armt_tbmacageBO BO,ServletStatus status) {
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
      status.out.println("Ctrl('FZFECYSHCA').style.height='auto';");
    } else {
      status.out.println("Ctrl('FZFECYSHCA').setAttribute('band_height',289);");
    }
    status.out.println("Ctrl('FZFECYSHCA').setAttribute('status','close');");
    status.out.println("tabs_1_DatiBase.AddTab({name:\"FZFECYSHCA\", element:\"FZFECYSHCA_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Persona Fisica"),"C",0,0)+",tabIndex: l_nFZFECYSHCATabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('FZFECYSHCA',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('FZFECYSHCA',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_1',tabs_1_DatiBase.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b4(armt_tbmacageBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_IQCHDVPIPM")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_IQCHDVPIPM' style='position:relative;height:5px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_IQCHDVPIPM")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_IQCHDVPIPM').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b5(armt_tbmacageBO BO,ServletStatus status) {
    status.out.println(
     "<div name='PG' id='IQCHDVPIPM_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' style='display:none' group_id='tabs_1_DatiBase'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nIQCHDVPIPMTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='IQCHDVPIPM' class='TabStripBoxBody' style='position:relative;height:161px;display:none'>" +
    "");
    status.includeZoneAltInterface("PG@BEGIN");
    if (status.includeZoneAltInterface("PG")) {
      WriteControls_p1_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("PG@BEGIN") || status.HasZoneAltInterface("PG@END")) {
        status.out.println(
         "<div id='IQCHDVPIPM_boxContent' style='position:relative;height:161px;display:block'>" +
        "");
      }
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MADESCRI' id='UJLZTFQRLR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MADESCRI,"C",120,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='120' size='120' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HXZVRERFNV_DIV'>" +
       "<label id='HXZVRERFNV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Denominazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<div id='JNAHHHKQCN_DIV' class='TitledSection'>" +
       "<span id='JNAHHHKQCN_HEADER_CAPTION' class='DefaultTitledBox'>"+status.context.Translate("Sede Legale")+"</span>" +
       "<div id='JNAHHHKQCN'>" +
       "</div>" +
       "</div>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MARESPAESE' id='HSKILYGZSO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MARESPAESE,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='HSKILYGZSO_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "HSKILYGZSO", "tbstati", "armt_stati", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MARESCITTA' id='NHXACJTYPN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MARESCITTA,"C",60,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='60' size='60' fieldtype='C'>" +
       "<button id='NHXACJTYPN_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "NHXACJTYPN", "tbcitta", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RENWSBUVVI_DIV'>" +
       "<label id='RENWSBUVVI' for='HSKILYGZSO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Paese:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UGJFCRCUJU_DIV'>" +
       "<label id='UGJFCRCUJU'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xDESSTARES)+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MARESIND' id='TGDACWRRAA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MARESIND,"C",50,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HPBIUSSADM_DIV'>" +
       "<label id='HPBIUSSADM' for='TGDACWRRAA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Indirizzo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MARESNCIV' id='TSPCNBOMFU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MARESNCIV,"C",15,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YMMSAOLKCG_DIV'>" +
       "<label id='YMMSAOLKCG' for='TSPCNBOMFU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("N. Civico:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MARESCAP' id='OBWMFCTJTG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MARESCAP,"C",15,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TBKPJLKZVC_DIV'>" +
       "<label id='TBKPJLKZVC' for='OBWMFCTJTG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAP:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MARESPRV' id='NVHTOUGLDP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MARESPRV,"C",2,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DRWKMUJLLC_DIV' style='display:none'>" +
       "<label id='DRWKMUJLLC' for='NVHTOUGLDP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Provincia:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EAQTDOPSMF_DIV'>" +
       "<label id='EAQTDOPSMF' for='NHXACJTYPN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Città:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("PG@BEGIN") || status.HasZoneAltInterface("PG@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b5_CloseBand(armt_tbmacageBO BO,ServletStatus status) {
    status.includeZoneAltInterface("PG@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("PG")) {
      status.out.println("Ctrl('IQCHDVPIPM').style.height='auto';");
    } else {
      status.out.println("Ctrl('IQCHDVPIPM').setAttribute('band_height',161);");
    }
    status.out.println("Ctrl('IQCHDVPIPM').setAttribute('status','close');");
    status.out.println("tabs_1_DatiBase.AddTab({name:\"IQCHDVPIPM\", element:\"IQCHDVPIPM_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Persona Giuridica"),"C",0,0)+",tabIndex: l_nIQCHDVPIPMTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('IQCHDVPIPM',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('IQCHDVPIPM',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_1',tabs_1_DatiBase.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b6(armt_tbmacageBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_MGKJOJJOBA")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_MGKJOJJOBA' style='position:relative;height:7px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_MGKJOJJOBA")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_MGKJOJJOBA').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b7(armt_tbmacageBO BO,ServletStatus status) {
    status.out.println(
     "<div name='WU' id='MGKJOJJOBA_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' style='display:none' group_id='tabs_1_DatiBase'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nMGKJOJJOBATabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='MGKJOJJOBA' class='TabStripBoxBody' style='position:relative;height:130px;display:none'>" +
    "");
    status.includeZoneAltInterface("WU@BEGIN");
    if (status.includeZoneAltInterface("WU")) {
      WriteControls_p1_b7_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("WU@BEGIN") || status.HasZoneAltInterface("WU@END")) {
        status.out.println(
         "<div id='MGKJOJJOBA_boxContent' style='position:relative;height:130px;display:block'>" +
        "");
      }
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='ASRUOVVPGY_DIV'>" +
       "<input name='MAFLGRAP' id='ASRUOVVPGY' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_MAFLGRAP,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_MAFLGRAP))?"CHECKED":"")+">" +
       "<label id='ASRUOVVPGY_LBL' for='ASRUOVVPGY' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Generazione Rapporti da operazioni"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='MAFLGOPE' id='EIHHOYVEDW' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("O","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("O",CPLib.Trim(BO.w_MAFLGOPE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Scrive i dati su Operazioni")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("F","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("F",CPLib.Trim(BO.w_MAFLGOPE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Scrive i dati su Frazionate")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('EIHHOYVEDW'),w_MAFLGOPE,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='MHLKURBXQM_DIV'>" +
       "<input name='MAFLGBON' id='MHLKURBXQM' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_MAFLGBON,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_MAFLGBON))?"CHECKED":"")+">" +
       "<label id='MHLKURBXQM_LBL' for='MHLKURBXQM' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Scrive operazione non in contanti"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='KDDADCDNIG_DIV'>" +
       "<input name='MAFLGCKR' id='KDDADCDNIG' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_MAFLGCKR,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_MAFLGCKR))?"CHECKED":"")+">" +
       "<label id='KDDADCDNIG_LBL' for='KDDADCDNIG' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Controllo esistenza Rapporto"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='EJTKDNLUIZ_DIV'>" +
       "<input name='MAFLGASR' id='EJTKDNLUIZ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_MAFLGASR,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_MAFLGASR))?"CHECKED":"")+">" +
       "<label id='EJTKDNLUIZ_LBL' for='EJTKDNLUIZ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Associa Operazione a Rapporto"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='FLWNMAVARU_DIV'>" +
       "<input name='MAFLGNOX' id='FLWNMAVARU' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_MAFLGNOX,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_MAFLGNOX))?"CHECKED":"")+">" +
       "<label id='FLWNMAVARU_LBL' for='FLWNMAVARU' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Non creare operazioni ExtraConto"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MADIPSTD' id='LRWPVABXRO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MADIPSTD,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
       "<button id='LRWPVABXRO_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "LRWPVABXRO", "anadip", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VFVLLYALSZ_DIV'>" +
       "<label id='VFVLLYALSZ' for='LRWPVABXRO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Dipendenza:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WLDLHTXIQZ_DIV'>" +
       "<label id='WLDLHTXIQZ'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xDESDIP)+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MANAIDWU' id='CNGYYMAOSD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MANAIDWU,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KIMHNFPQIF_DIV'>" +
       "<label id='KIMHNFPQIF' for='CNGYYMAOSD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("NAID:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='PVYFXNLRHX_DIV'>" +
       "<input name='MAFLGCHKDAT' id='PVYFXNLRHX' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_MAFLGCHKDAT,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_MAFLGCHKDAT))?"CHECKED":"")+">" +
       "<label id='PVYFXNLRHX_LBL' for='PVYFXNLRHX' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Considera dati anagrafici certi"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='LFYBATBNHY_DIV'>" +
       "<input name='MAFLGACT' id='LFYBATBNHY' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_MAFLGACT,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_MAFLGACT))?"CHECKED":"")+">" +
       "<label id='LFYBATBNHY_LBL' for='LFYBATBNHY' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("MacroAgente Operativo"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MARESSDEF' id='XDJMLPLVUM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MARESSDEF,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C' autocomplete='off'>" +
       "<button id='XDJMLPLVUM_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "XDJMLPLVUM", "tbstati", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NWDVZOSXJE_DIV'>" +
       "<label id='NWDVZOSXJE'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_despaese)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OIHWAUBJXF_DIV'>" +
       "<label id='OIHWAUBJXF' for='XDJMLPLVUM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Paese Res. Default:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='ZLKRYVPWEH_DIV'>" +
       "<input name='MAFLGAUA' id='ZLKRYVPWEH' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_MAFLGAUA,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_MAFLGAUA))?"CHECKED":"")+">" +
       "<label id='ZLKRYVPWEH_LBL' for='ZLKRYVPWEH' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Escludi Controlli AUA"))+"</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("WU@BEGIN") || status.HasZoneAltInterface("WU@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b7_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b7_CloseBand(armt_tbmacageBO BO,ServletStatus status) {
    status.includeZoneAltInterface("WU@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("WU")) {
      status.out.println("Ctrl('MGKJOJJOBA').style.height='auto';");
    } else {
      status.out.println("Ctrl('MGKJOJJOBA').setAttribute('band_height',130);");
    }
    status.out.println("Ctrl('MGKJOJJOBA').setAttribute('status','close');");
    status.out.println("tabs_1_DatiBase.AddTab({name:\"MGKJOJJOBA\", element:\"MGKJOJJOBA_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati WU"),"C",0,0)+",tabIndex: l_nMGKJOJJOBATabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('MGKJOJJOBA',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('MGKJOJJOBA',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_1',tabs_1_DatiBase.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b8(armt_tbmacageBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_CUUSKOLCJA")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_CUUSKOLCJA' style='position:relative;height:3px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_CUUSKOLCJA")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_CUUSKOLCJA').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b9(armt_tbmacageBO BO,ServletStatus status) {
    status.out.println(
     "<div name='SO' id='CUUSKOLCJA_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' group_id='tabs_1_DatiBase'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nCUUSKOLCJATabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='CUUSKOLCJA' class='TabStripBoxBody' style='position:relative;display:none'>" +
    "");
    status.includeZoneAltInterface("SO@BEGIN");
    if (status.includeZoneAltInterface("SO")) {
      WriteControls_p1_b9_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("SO@BEGIN") || status.HasZoneAltInterface("SO@END")) {
        status.out.println(
         "<div id='CUUSKOLCJA_boxContent' style='position:relative;display:block'>" +
        "");
      }
      WriteControls_p1_b9_b0(BO,status);
      WriteControls_p1_b9_b1(BO,status);
      WriteControls_p1_b9_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['CUUSKOLCJA']=['band_1_686','band_1_697','band_1_1099'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("SO@BEGIN") || status.HasZoneAltInterface("SO@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b9_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b9_CloseBand(armt_tbmacageBO BO,ServletStatus status) {
    status.includeZoneAltInterface("SO@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('CUUSKOLCJA').setAttribute('status','close');");
    status.out.println("tabs_1_DatiBase.AddTab({name:\"CUUSKOLCJA\", element:\"CUUSKOLCJA_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Sedi Operative"),"C",0,0)+",tabIndex: l_nCUUSKOLCJATabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('CUUSKOLCJA',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('CUUSKOLCJA',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_1',tabs_1_DatiBase.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b9_b0(armt_tbmacageBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_686' style='position:relative;height:11px;display:block' page='1'>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b9_b1(armt_tbmacageBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_697' style='position:relative;display:block' page='1'>" +
    "");
    status.out.println(
     "<div id='MIOGGDHBIQ'>" +
    "");
    // GetPortlet_Object_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_MIOGGDHBIQ;
    inclusionVars_MIOGGDHBIQ = GetPortlet_MIOGGDHBIQ_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_MIOGGDHBIQ);
    String portletUID_MIOGGDHBIQ = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_sedi_operative_portlet.jsp?ForcedPortletUID="+ portletUID_MIOGGDHBIQ+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_MIOGGDHBIQ),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.MIOGGDHBIQ='"+portletUID_MIOGGDHBIQ+"';" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b9_b2(armt_tbmacageBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_1099' style='position:relative;height:12px;display:block' page='1'>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b10(armt_tbmacageBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_YULWJWXEXS")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_YULWJWXEXS' style='position:relative;height:9px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_YULWJWXEXS")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_YULWJWXEXS').style.height='auto';");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b11(armt_tbmacageBO BO,ServletStatus status) {
    status.out.println(
     "<div name='RL' id='YULWJWXEXS_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' style='display:none' group_id='tabs_1_DatiBase'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nYULWJWXEXSTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='YULWJWXEXS' class='TabStripBoxBody' style='position:relative;height:170px;display:none'>" +
    "");
    status.includeZoneAltInterface("RL@BEGIN");
    if (status.includeZoneAltInterface("RL")) {
      WriteControls_p1_b11_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("RL@BEGIN") || status.HasZoneAltInterface("RL@END")) {
        status.out.println(
         "<div id='YULWJWXEXS_boxContent' style='position:relative;height:170px;display:block'>" +
        "");
      }
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<iframe name='ardt_ageresleg' id='LBQEONIOQI' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
       "</iframe>" +
      "");
      if (status.HasZoneAltInterface("RL@BEGIN") || status.HasZoneAltInterface("RL@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b11_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b11_CloseBand(armt_tbmacageBO BO,ServletStatus status) {
    status.includeZoneAltInterface("RL@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("RL")) {
      status.out.println("Ctrl('YULWJWXEXS').style.height='auto';");
    } else {
      status.out.println("Ctrl('YULWJWXEXS').setAttribute('band_height',170);");
    }
    status.out.println("Ctrl('YULWJWXEXS').setAttribute('status','close');");
    status.out.println("tabs_1_DatiBase.AddTab({name:\"YULWJWXEXS\", element:\"YULWJWXEXS_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Responsabili Legali"),"C",0,0)+",tabIndex: l_nYULWJWXEXSTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('YULWJWXEXS',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('YULWJWXEXS',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_1',tabs_1_DatiBase.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
    WriteExtendedCBoxGroupChildren(BO.m_MNTs,status,"DatiBase",1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['YULWJWXEXS']=['LBQEONIOQI'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b12(armt_tbmacageBO BO,ServletStatus status) {
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
  static void PrintState(armt_tbmacageBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_tbmacageBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
    if (BO.ardt_ageresleg.IsUpdated()) {
      BO.m_cWv_ardt_ageresleg = BO.ardt_ageresleg.GetContext();
    }
  }
  static void PrintStateWorkVars(armt_tbmacageBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_MACODICE,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MADESCRI,"C",120,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MAFLGRAP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MAFLGOPE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MAFLGBON,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MAFLGCKR,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MAFLGASR,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MAFLGNOX,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MADIPSTD,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MANAIDWU,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MAFLGCHKDAT,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MAFLGACT,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MARESSDEF,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MAFLGAUA,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MATIPAGE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MAFISGIU,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MADATINI,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MADATFIN,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MADATMOD,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MACODFIS,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MACOGNOME,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MANOME,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MARESPAESE,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MARESCITTA,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MARESCAP,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MARESPRV,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MARESIND,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MARESNCIV,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MADOMPAESE,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MADOMCITTA,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MADOMCAP,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MADOMPRV,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MADOMIND,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MADOMNCIV,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MAFLGCOMPL,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgWU,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDESDIP,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_despaese,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDESSTARES,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDESSTADOM,"C",40,0));
    if (CPLib.eq(BO.m_cWv_ardt_ageresleg,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_ageresleg");
    } else if (CPLib.eq(BO.m_cWv_ardt_ageresleg,"_not_empty_")) {
      BO.m_cWv_ardt_ageresleg = BO.ardt_ageresleg.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_ageresleg,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_ageresleg,"C",0,0));
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_tbmacageBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_WLDLHTXIQZ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_NWDVZOSXJE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_AYAXIAXHNF = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_UJYVVYZVCK = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_UGJFCRCUJU = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(240,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(1085,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_tbmacage"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'LRWPVABXRO':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"LRWPVABXRO",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'XDJMLPLVUM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"XDJMLPLVUM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'BFMOWHWVBP':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"BFMOWHWVBP",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'ODQOMCYUIH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ODQOMCYUIH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'DJVPNMOUXM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"DJVPNMOUXM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'UUHMAJHIGT':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"UUHMAJHIGT",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'HSKILYGZSO':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"HSKILYGZSO",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'NHXACJTYPN':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NHXACJTYPN",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'LRWPVABXRO':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'XDJMLPLVUM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'BFMOWHWVBP':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'ODQOMCYUIH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'DJVPNMOUXM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'UUHMAJHIGT':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'HSKILYGZSO':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'NHXACJTYPN':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_tbmacage","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_tbmacage",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("PF"),"")) {
      status.quoteAndAppend("PF","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("PG"),"")) {
      status.quoteAndAppend("PG","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("WU"),"")) {
      status.quoteAndAppend("WU","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Residenza"),"")) {
      status.quoteAndAppend("Residenza","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Domicilio"),"")) {
      status.quoteAndAppend("Domicilio","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("SedeLegale"),"")) {
      status.quoteAndAppend("SedeLegale","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("RL"),"")) {
      status.quoteAndAppend("RL","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("SO"),"")) {
      status.quoteAndAppend("SO","hide","box");
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
  void WriteMainFormScript(armt_tbmacageBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_tbmacage',false);");
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
        status.out.println("if(c=Ctrl('LVIYDAHUQL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UJLZTFQRLR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ASRUOVVPGY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EIHHOYVEDW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MHLKURBXQM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KDDADCDNIG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EJTKDNLUIZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FLWNMAVARU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LRWPVABXRO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LRWPVABXRO_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CNGYYMAOSD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PVYFXNLRHX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LFYBATBNHY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XDJMLPLVUM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XDJMLPLVUM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZLKRYVPWEH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HUKDVHFFUB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TCJHVDJTUY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RROACIQRKN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RROACIQRKN_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UYKWSCJLEB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UYKWSCJLEB_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MGUFLYJWMR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MGUFLYJWMR_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OPANBXIPXY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ESOMNUPHTE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZXBKIFGVGY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BFMOWHWVBP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BFMOWHWVBP_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ODQOMCYUIH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ODQOMCYUIH_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LWTLGAYOFY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UHIQZUDMGI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MURAEDMCDC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FQYPBTRCED')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DJVPNMOUXM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DJVPNMOUXM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UUHMAJHIGT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UUHMAJHIGT_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WEAMCVVDVI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZQOYBAIYYW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AZHKYECVLF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DRNUGFPEBE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HSKILYGZSO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HSKILYGZSO_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NHXACJTYPN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NHXACJTYPN_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TGDACWRRAA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TSPCNBOMFU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OBWMFCTJTG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NVHTOUGLDP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MGGEMJQGRJ')) SetDisabled(c,true);");
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
      status.out.println("if (Ctrl('LBQEONIOQI')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('LBQEONIOQI',linkpc_url('LBQEONIOQI'));");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('LVIYDAHUQL')) SetDisabled(c,true);");
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
    status.out.println("if (Eq(name,'ardt_ageresleg')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_ageresleg")+"';");
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
  armt_tbmacageBO getBO(ServletStatus status) {
    armt_tbmacageBO BO = new armt_tbmacageBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_tbmacageBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("tbmacage",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_tbmacageBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_tbmacageBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
  }
  CPResultSet QueryKeyCursor(armt_tbmacageBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_tbmacage;
    String l_cPhName = BO.m_cPhName_tbmacage;
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
      String l_cQueryFilter = armt_tbmacageBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_tbmacage+".MACODICE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("tbmacage");
    String l_cPhName = CPSql.ManipulateTablePhName("tbmacage",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".MACODICE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,armt_tbmacageBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_tbmacageBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_tbmacage,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_tbmacage,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_tbmacageBO BO) {
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
  void Edit(ServletStatus status,armt_tbmacageBO BO,SPParameterSource source) {
    BO.Load(status.w_MACODICE);
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
  void New(ServletStatus status,armt_tbmacageBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_tbmacageBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_tbmacageBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_MACODICE = "";
      } else {
        BO.w_MACODICE = l_rsKeys.GetString("MACODICE");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_MACODICE = BO.w_MACODICE;
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
  void EditLoad(ServletStatus status,armt_tbmacageBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_tbmacageBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_MACODICE);
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
  void DeleteMessage(ServletStatus status,armt_tbmacageBO BO,SPParameterSource source) {
    BO.Load(status.w_MACODICE);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_tbmacageBO BO) {
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({MACODICE:"+SPLib.ToJSValue(BO.w_MACODICE,"C",5,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
  void Discard(ServletStatus status,armt_tbmacageBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_tbmacageBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",1295);
    item.put("w",1085);
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
    item.put("altInterfaceFor","armt_tbmacage");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Base\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Base\",\"h\":77,\"name\":\"Base\",\"page\":1,\"shrinkable\":true,\"spuid\":\"UBUBESGOCL\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Dati Base\",\"titled\":true,\"type\":\"Box\",\"w\":1072,\"x\":8,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice\",\"h\":20,\"maxlength\":5,\"name\":\"MACODICE\",\"page\":1,\"spuid\":\"LVIYDAHUQL\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":96,\"y\":21,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XKNWYVGCBE\",\"page\":1,\"spuid\":\"XKNWYVGCBE\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"Codice:\",\"w\":79,\"x\":16,\"y\":25,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Agente\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"MATIPAGE\",\"page\":1,\"spuid\":\"HUKDVHFFUB\",\"tabindex\":29,\"textlist\":\"Agente,Convenzionato\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"A"+"'"+","+"'"+"C"+"'"+"\",\"w\":144,\"x\":592,\"y\":21,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RUIZMYEJXT\",\"page\":1,\"spuid\":\"RUIZMYEJXT\",\"tabindex\":30,\"type\":\"Label\",\"value\":\"Tipo Agente:\",\"w\":96,\"x\":496,\"y\":25,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Specie Giuridica\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"MAFISGIU\",\"page\":1,\"spuid\":\"TCJHVDJTUY\",\"tabindex\":31,\"textlist\":\"Persona Fisica,Persona Giuridica\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"P"+"'"+","+"'"+"G"+"'"+"\",\"w\":216,\"x\":856,\"y\":21,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GURVSIKVQI\",\"page\":1,\"spuid\":\"GURVSIKVQI\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"Specie Giuridica:\",\"w\":120,\"x\":736,\"y\":25,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Fiscale\\/P.IVA\",\"h\":20,\"maxlength\":16,\"name\":\"MACODFIS\",\"page\":1,\"spuid\":\"OPANBXIPXY\",\"tabindex\":39,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":136,\"x\":352,\"y\":21,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZJGWZLUOZI\",\"page\":1,\"spuid\":\"ZJGWZLUOZI\",\"tabindex\":40,\"type\":\"Label\",\"value\":\"Codice Fiscale\\/P.IVA:\",\"w\":184,\"x\":168,\"y\":25,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Inizio Rapporto\",\"h\":20,\"maxlength\":10,\"name\":\"MADATINI\",\"page\":1,\"picker\":true,\"spuid\":\"RROACIQRKN\",\"tabindex\":33,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":96,\"y\":49,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BNDYHPCUPK\",\"page\":1,\"spuid\":\"BNDYHPCUPK\",\"tabindex\":34,\"type\":\"Label\",\"value\":\"Inizio Rapporto:\",\"w\":113,\"x\":-17,\"y\":53,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Fine Rapporto\",\"h\":20,\"maxlength\":10,\"name\":\"MADATFIN\",\"page\":1,\"picker\":true,\"spuid\":\"UYKWSCJLEB\",\"tabindex\":35,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":304,\"y\":49,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BMQRTBDRHY\",\"page\":1,\"spuid\":\"BMQRTBDRHY\",\"tabindex\":36,\"type\":\"Label\",\"value\":\"Fine Rapporto:\",\"w\":104,\"x\":200,\"y\":53,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Ultimo Aggiornamento\",\"h\":20,\"maxlength\":10,\"name\":\"MADATMOD\",\"page\":1,\"picker\":true,\"spuid\":\"MGUFLYJWMR\",\"tabindex\":37,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":560,\"y\":49,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VOAMRHZCGF\",\"page\":1,\"spuid\":\"VOAMRHZCGF\",\"tabindex\":38,\"type\":\"Label\",\"value\":\"Data Ultimo Aggiornamento:\",\"w\":160,\"x\":400,\"y\":53,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Chiusura per compliance\",\"h\":21,\"label_text\":\"Chiusura per compliance\",\"maxlength\":2,\"name\":\"MAFLGCOMPL\",\"page\":1,\"spuid\":\"MGGEMJQGRJ\",\"tabindex\":93,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":184,\"x\":672,\"y\":49,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"PG\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Persona Giuridica\",\"groupName\":\"DatiBase\",\"h\":161,\"name\":\"PG\",\"page\":1,\"shrinkable\":true,\"spuid\":\"IQCHDVPIPM\",\"stretch\":true,\"tabindex\":4,\"title_caption\":\"Persona Giuridica\",\"titled\":true,\"type\":\"Box\",\"w\":1072,\"x\":8,\"y\":385,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Denominazione\",\"h\":20,\"maxlength\":120,\"name\":\"MADESCRI\",\"page\":1,\"spuid\":\"UJLZTFQRLR\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":800,\"x\":96,\"y\":399,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HXZVRERFNV\",\"page\":1,\"spuid\":\"HXZVRERFNV\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"Denominazione:\",\"w\":87,\"x\":8,\"y\":403,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"SedeLegale\",\"box_type\":\"titled_section\",\"comment\":\"Sede Legale\",\"h\":105,\"name\":\"SedeLegale\",\"page\":1,\"shrinkable\":true,\"spuid\":\"JNAHHHKQCN\",\"stretch\":true,\"tabindex\":75,\"title_caption\":\"Sede Legale\",\"titled\":true,\"type\":\"Box\",\"w\":1048,\"x\":16,\"y\":427,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Paese Residenza\",\"h\":20,\"maxlength\":3,\"name\":\"MARESPAESE\",\"page\":1,\"picker\":true,\"spuid\":\"HSKILYGZSO\",\"tabindex\":76,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":96,\"y\":434,\"zone\":\"pag1_2_2_1\",\"zonepath\":\"[1,2,2,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RENWSBUVVI\",\"page\":1,\"spuid\":\"RENWSBUVVI\",\"tabindex\":78,\"type\":\"Label\",\"value\":\"Paese:\",\"w\":93,\"x\":3,\"y\":438,\"zone\":\"pag1_2_2_1\",\"zonepath\":\"[1,2,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"name\":\"label_UGJFCRCUJU\",\"page\":1,\"spuid\":\"UGJFCRCUJU\",\"tabindex\":79,\"type\":\"Label\",\"w\":392,\"x\":176,\"y\":434,\"zone\":\"pag1_2_2_1\",\"zonepath\":\"[1,2,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Citt\\u00E0\",\"h\":20,\"maxlength\":60,\"name\":\"MARESCITTA\",\"page\":1,\"picker\":true,\"spuid\":\"NHXACJTYPN\",\"tabindex\":77,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":372,\"x\":96,\"y\":462,\"zone\":\"pag1_2_2_2\",\"zonepath\":\"[1,2,2,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAP\",\"h\":20,\"maxlength\":15,\"name\":\"MARESCAP\",\"page\":1,\"spuid\":\"OBWMFCTJTG\",\"tabindex\":84,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":552,\"y\":462,\"zone\":\"pag1_2_2_2\",\"zonepath\":\"[1,2,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TBKPJLKZVC\",\"page\":1,\"spuid\":\"TBKPJLKZVC\",\"tabindex\":85,\"type\":\"Label\",\"value\":\"CAP:\",\"w\":56,\"x\":496,\"y\":466,\"zone\":\"pag1_2_2_2\",\"zonepath\":\"[1,2,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia\",\"h\":20,\"maxlength\":2,\"name\":\"MARESPRV\",\"page\":1,\"spuid\":\"NVHTOUGLDP\",\"tabindex\":86,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":768,\"y\":462,\"zone\":\"pag1_2_2_2\",\"zonepath\":\"[1,2,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DRWKMUJLLC\",\"page\":1,\"spuid\":\"DRWKMUJLLC\",\"tabindex\":87,\"type\":\"Label\",\"value\":\"Provincia:\",\"w\":88,\"x\":680,\"y\":466,\"zone\":\"pag1_2_2_2\",\"zonepath\":\"[1,2,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EAQTDOPSMF\",\"page\":1,\"spuid\":\"EAQTDOPSMF\",\"tabindex\":88,\"type\":\"Label\",\"value\":\"Citt\\u00E0:\",\"w\":80,\"x\":16,\"y\":466,\"zone\":\"pag1_2_2_2\",\"zonepath\":\"[1,2,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Indirizzo\",\"h\":20,\"maxlength\":50,\"name\":\"MARESIND\",\"page\":1,\"spuid\":\"TGDACWRRAA\",\"tabindex\":80,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":96,\"y\":490,\"zone\":\"pag1_2_2_3\",\"zonepath\":\"[1,2,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HPBIUSSADM\",\"page\":1,\"spuid\":\"HPBIUSSADM\",\"tabindex\":81,\"type\":\"Label\",\"value\":\"Indirizzo:\",\"w\":80,\"x\":16,\"y\":494,\"zone\":\"pag1_2_2_3\",\"zonepath\":\"[1,2,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"N. Civico\",\"h\":20,\"maxlength\":15,\"name\":\"MARESNCIV\",\"page\":1,\"spuid\":\"TSPCNBOMFU\",\"tabindex\":82,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":552,\"y\":490,\"zone\":\"pag1_2_2_3\",\"zonepath\":\"[1,2,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YMMSAOLKCG\",\"page\":1,\"spuid\":\"YMMSAOLKCG\",\"tabindex\":83,\"type\":\"Label\",\"value\":\"N. Civico:\",\"w\":96,\"x\":456,\"y\":494,\"zone\":\"pag1_2_2_3\",\"zonepath\":\"[1,2,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"WU\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati WU\",\"groupName\":\"DatiBase\",\"h\":130,\"name\":\"WU\",\"page\":1,\"shrinkable\":true,\"spuid\":\"MGKJOJJOBA\",\"stretch\":true,\"tabindex\":5,\"title_caption\":\"Dati WU\",\"titled\":true,\"type\":\"Box\",\"w\":1072,\"x\":8,\"y\":553,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Generazione Rapporti da operazioni\",\"h\":21,\"label_text\":\"Generazione Rapporti da operazioni\",\"maxlength\":1,\"name\":\"MAFLGRAP\",\"page\":1,\"spuid\":\"ASRUOVVPGY\",\"tabindex\":10,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":216,\"x\":24,\"y\":567,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Scrivi su Operazioni o Frazionate\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"MAFLGOPE\",\"page\":1,\"spuid\":\"EIHHOYVEDW\",\"tabindex\":11,\"textlist\":\"Scrive i dati su Operazioni,Scrive i dati su Frazionate\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"O"+"'"+","+"'"+"F"+"'"+"\",\"w\":240,\"x\":832,\"y\":567,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Scrive tipo operazione come bonifico\",\"h\":21,\"label_text\":\"Scrive operazione non in contanti\",\"maxlength\":1,\"name\":\"MAFLGBON\",\"page\":1,\"spuid\":\"MHLKURBXQM\",\"tabindex\":12,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":216,\"x\":264,\"y\":567,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Controllo esistenza Rapporto\",\"h\":21,\"label_text\":\"Controllo esistenza Rapporto\",\"maxlength\":1,\"name\":\"MAFLGCKR\",\"page\":1,\"spuid\":\"KDDADCDNIG\",\"tabindex\":13,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":216,\"x\":464,\"y\":567,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Associa Operazione a Rapporto\",\"h\":21,\"label_text\":\"Associa Operazione a Rapporto\",\"maxlength\":1,\"name\":\"MAFLGASR\",\"page\":1,\"spuid\":\"EJTKDNLUIZ\",\"tabindex\":14,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":216,\"x\":648,\"y\":567,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Non creare Operazioni Extraconto\",\"h\":21,\"label_text\":\"Non creare operazioni ExtraConto\",\"maxlength\":1,\"name\":\"MAFLGNOX\",\"page\":1,\"spuid\":\"FLWNMAVARU\",\"tabindex\":15,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":216,\"x\":648,\"y\":595,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Dipendenza Standard\",\"h\":20,\"maxlength\":6,\"name\":\"MADIPSTD\",\"page\":1,\"picker\":true,\"spuid\":\"LRWPVABXRO\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":136,\"y\":623,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VFVLLYALSZ\",\"page\":1,\"spuid\":\"VFVLLYALSZ\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"Dipendenza:\",\"w\":117,\"x\":19,\"y\":627,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_WLDLHTXIQZ\",\"page\":1,\"spuid\":\"WLDLHTXIQZ\",\"tabindex\":19,\"type\":\"Label\",\"w\":264,\"x\":208,\"y\":627,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"NAID\",\"h\":20,\"maxlength\":5,\"name\":\"MANAIDWU\",\"page\":1,\"spuid\":\"CNGYYMAOSD\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":896,\"y\":595,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KIMHNFPQIF\",\"page\":1,\"spuid\":\"KIMHNFPQIF\",\"tabindex\":21,\"type\":\"Label\",\"value\":\"NAID:\",\"w\":64,\"x\":832,\"y\":599,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Dati certi per Soggetti\",\"h\":21,\"label_text\":\"Considera dati anagrafici certi\",\"maxlength\":1,\"name\":\"MAFLGCHKDAT\",\"page\":1,\"spuid\":\"PVYFXNLRHX\",\"tabindex\":22,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":232,\"x\":464,\"y\":595,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Macrosgente operativo\",\"h\":21,\"label_text\":\"MacroAgente Operativo\",\"maxlength\":1,\"name\":\"MAFLGACT\",\"page\":1,\"spuid\":\"LFYBATBNHY\",\"tabindex\":23,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":232,\"x\":24,\"y\":595,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Escludi Controlli AUA\",\"h\":21,\"label_text\":\"Escludi Controlli AUA\",\"maxlength\":1,\"name\":\"MAFLGAUA\",\"page\":1,\"spuid\":\"ZLKRYVPWEH\",\"tabindex\":28,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":192,\"x\":264,\"y\":595,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Paese Res. Default\",\"h\":20,\"maxlength\":3,\"name\":\"MARESSDEF\",\"page\":1,\"picker\":true,\"spuid\":\"XDJMLPLVUM\",\"tabindex\":24,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":136,\"y\":651,\"zone\":\"pag1_3_5\",\"zonepath\":\"[1,3,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_NWDVZOSXJE\",\"page\":1,\"spuid\":\"NWDVZOSXJE\",\"tabindex\":26,\"type\":\"Label\",\"w\":392,\"x\":208,\"y\":655,\"zone\":\"pag1_3_5\",\"zonepath\":\"[1,3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OIHWAUBJXF\",\"page\":1,\"spuid\":\"OIHWAUBJXF\",\"tabindex\":27,\"type\":\"Label\",\"value\":\"Paese Res. Default:\",\"w\":128,\"x\":8,\"y\":655,\"zone\":\"pag1_3_5\",\"zonepath\":\"[1,3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"SO\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Sedi Operative\",\"groupName\":\"DatiBase\",\"h\":425,\"name\":\"SO\",\"page\":1,\"shrinkable\":true,\"spuid\":\"CUUSKOLCJA\",\"stretch\":true,\"tabindex\":91,\"title_caption\":\"Sedi Operative\",\"titled\":true,\"type\":\"Box\",\"w\":1072,\"x\":8,\"y\":686,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":402,\"name\":\"Object\",\"page\":1,\"spuid\":\"MIOGGDHBIQ\",\"src\":\"\\/jsp\\/pg_sedi_operative_portlet.jsp?ForcedPortletUID=MIOGGDHBIQ\",\"tabindex\":92,\"type\":\"Portlet\",\"w\":1040,\"x\":24,\"y\":697,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"RL\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Responsabili Legali\",\"groupName\":\"DatiBase\",\"h\":170,\"name\":\"RL\",\"page\":1,\"shrinkable\":true,\"spuid\":\"YULWJWXEXS\",\"stretch\":true,\"tabindex\":90,\"title_caption\":\"Responsabili Legali\",\"titled\":true,\"type\":\"Box\",\"w\":1072,\"x\":8,\"y\":1120,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":150,\"name\":\"ardt_ageresleg\",\"page\":1,\"spuid\":\"LBQEONIOQI\",\"tabindex\":89,\"type\":\"Iframe\",\"w\":1051,\"x\":16,\"y\":1134,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"PF\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Persona Fisica\",\"groupName\":\"DatiBase\",\"h\":289,\"name\":\"PF\",\"page\":1,\"shrinkable\":true,\"spuid\":\"FZFECYSHCA\",\"stretch\":true,\"tabindex\":3,\"title_caption\":\"Persona Fisica\",\"titled\":true,\"type\":\"Box\",\"w\":1072,\"x\":8,\"y\":91,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cognome\",\"h\":20,\"maxlength\":50,\"name\":\"MACOGNOME\",\"page\":1,\"spuid\":\"ESOMNUPHTE\",\"tabindex\":41,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":96,\"y\":105,\"zone\":\"pag1_6_1\",\"zonepath\":\"[1,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome\",\"h\":20,\"maxlength\":50,\"name\":\"MANOME\",\"page\":1,\"spuid\":\"ZXBKIFGVGY\",\"tabindex\":42,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":512,\"y\":105,\"zone\":\"pag1_6_1\",\"zonepath\":\"[1,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YFJANWHXCV\",\"page\":1,\"spuid\":\"YFJANWHXCV\",\"tabindex\":43,\"type\":\"Label\",\"value\":\"Cognome:\",\"w\":80,\"x\":16,\"y\":109,\"zone\":\"pag1_6_1\",\"zonepath\":\"[1,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IZNJQFOXAR\",\"page\":1,\"spuid\":\"IZNJQFOXAR\",\"tabindex\":74,\"type\":\"Label\",\"value\":\"Nome:\",\"w\":96,\"x\":416,\"y\":109,\"zone\":\"pag1_6_1\",\"zonepath\":\"[1,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Residenza\",\"box_type\":\"titled_section\",\"comment\":\"Residenza\",\"h\":105,\"name\":\"Residenza\",\"page\":1,\"shrinkable\":true,\"spuid\":\"QLICUFUCES\",\"stretch\":true,\"tabindex\":44,\"title_caption\":\"Residenza\",\"titled\":true,\"type\":\"Box\",\"w\":1048,\"x\":16,\"y\":140,\"zone\":\"pag1_6_2\",\"zonepath\":\"[1,6,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Paese Residenza\",\"h\":20,\"maxlength\":3,\"name\":\"MARESPAESE\",\"page\":1,\"picker\":true,\"spuid\":\"BFMOWHWVBP\",\"tabindex\":45,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":96,\"y\":147,\"zone\":\"pag1_6_2_1\",\"zonepath\":\"[1,6,2,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YDGLQSLLPS\",\"page\":1,\"spuid\":\"YDGLQSLLPS\",\"tabindex\":49,\"type\":\"Label\",\"value\":\"Paese:\",\"w\":93,\"x\":3,\"y\":151,\"zone\":\"pag1_6_2_1\",\"zonepath\":\"[1,6,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"name\":\"label_AYAXIAXHNF\",\"page\":1,\"spuid\":\"AYAXIAXHNF\",\"tabindex\":51,\"type\":\"Label\",\"w\":392,\"x\":176,\"y\":147,\"zone\":\"pag1_6_2_1\",\"zonepath\":\"[1,6,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Citt\\u00E0\",\"h\":20,\"maxlength\":60,\"name\":\"MARESCITTA\",\"page\":1,\"picker\":true,\"spuid\":\"ODQOMCYUIH\",\"tabindex\":46,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":372,\"x\":96,\"y\":175,\"zone\":\"pag1_6_2_2\",\"zonepath\":\"[1,6,2,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAP\",\"h\":20,\"maxlength\":15,\"name\":\"MARESCAP\",\"page\":1,\"spuid\":\"LWTLGAYOFY\",\"tabindex\":47,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":552,\"y\":175,\"zone\":\"pag1_6_2_2\",\"zonepath\":\"[1,6,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia\",\"h\":20,\"maxlength\":2,\"name\":\"MARESPRV\",\"page\":1,\"spuid\":\"UHIQZUDMGI\",\"tabindex\":48,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":768,\"y\":175,\"zone\":\"pag1_6_2_2\",\"zonepath\":\"[1,6,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IZRFLVHCWH\",\"page\":1,\"spuid\":\"IZRFLVHCWH\",\"tabindex\":56,\"type\":\"Label\",\"value\":\"CAP:\",\"w\":56,\"x\":496,\"y\":179,\"zone\":\"pag1_6_2_2\",\"zonepath\":\"[1,6,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DDSGHKAKIP\",\"page\":1,\"spuid\":\"DDSGHKAKIP\",\"tabindex\":57,\"type\":\"Label\",\"value\":\"Provincia:\",\"w\":88,\"x\":680,\"y\":179,\"zone\":\"pag1_6_2_2\",\"zonepath\":\"[1,6,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RRKIDUJKND\",\"page\":1,\"spuid\":\"RRKIDUJKND\",\"tabindex\":58,\"type\":\"Label\",\"value\":\"Citt\\u00E0:\",\"w\":80,\"x\":16,\"y\":179,\"zone\":\"pag1_6_2_2\",\"zonepath\":\"[1,6,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Indirizzo\",\"h\":20,\"maxlength\":50,\"name\":\"MARESIND\",\"page\":1,\"spuid\":\"MURAEDMCDC\",\"tabindex\":52,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":96,\"y\":203,\"zone\":\"pag1_6_2_3\",\"zonepath\":\"[1,6,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JJADBFUOHS\",\"page\":1,\"spuid\":\"JJADBFUOHS\",\"tabindex\":53,\"type\":\"Label\",\"value\":\"Indirizzo:\",\"w\":80,\"x\":16,\"y\":207,\"zone\":\"pag1_6_2_3\",\"zonepath\":\"[1,6,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"N. Civico\",\"h\":20,\"maxlength\":15,\"name\":\"MARESNCIV\",\"page\":1,\"spuid\":\"FQYPBTRCED\",\"tabindex\":54,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":552,\"y\":203,\"zone\":\"pag1_6_2_3\",\"zonepath\":\"[1,6,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FUVOTLRTOO\",\"page\":1,\"spuid\":\"FUVOTLRTOO\",\"tabindex\":55,\"type\":\"Label\",\"value\":\"N. Civico:\",\"w\":96,\"x\":456,\"y\":207,\"zone\":\"pag1_6_2_3\",\"zonepath\":\"[1,6,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Domicilio\",\"box_type\":\"titled_section\",\"comment\":\"Domicilio\",\"h\":105,\"name\":\"Domicilio\",\"page\":1,\"shrinkable\":true,\"spuid\":\"ESTMSWKOOS\",\"stretch\":true,\"tabindex\":59,\"title_caption\":\"Domicilio\",\"titled\":true,\"type\":\"Box\",\"w\":1048,\"x\":16,\"y\":259,\"zone\":\"pag1_6_3\",\"zonepath\":\"[1,6,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Paese Residenza\",\"h\":20,\"maxlength\":3,\"name\":\"MADOMPAESE\",\"page\":1,\"picker\":true,\"spuid\":\"DJVPNMOUXM\",\"tabindex\":60,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":96,\"y\":266,\"zone\":\"pag1_6_3_1\",\"zonepath\":\"[1,6,3,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CZLOZIJQYR\",\"page\":1,\"spuid\":\"CZLOZIJQYR\",\"tabindex\":64,\"type\":\"Label\",\"value\":\"Paese:\",\"w\":93,\"x\":3,\"y\":270,\"zone\":\"pag1_6_3_1\",\"zonepath\":\"[1,6,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"name\":\"label_UJYVVYZVCK\",\"page\":1,\"spuid\":\"UJYVVYZVCK\",\"tabindex\":65,\"type\":\"Label\",\"w\":392,\"x\":176,\"y\":266,\"zone\":\"pag1_6_3_1\",\"zonepath\":\"[1,6,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Citt\\u00E0\",\"h\":20,\"maxlength\":60,\"name\":\"MADOMCITTA\",\"page\":1,\"picker\":true,\"spuid\":\"UUHMAJHIGT\",\"tabindex\":61,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":372,\"x\":96,\"y\":294,\"zone\":\"pag1_6_3_2\",\"zonepath\":\"[1,6,3,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAP\",\"h\":20,\"maxlength\":15,\"name\":\"MADOMCAP\",\"page\":1,\"spuid\":\"WEAMCVVDVI\",\"tabindex\":62,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":552,\"y\":294,\"zone\":\"pag1_6_3_2\",\"zonepath\":\"[1,6,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia\",\"h\":20,\"maxlength\":2,\"name\":\"MADOMPRV\",\"page\":1,\"spuid\":\"ZQOYBAIYYW\",\"tabindex\":63,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":768,\"y\":294,\"zone\":\"pag1_6_3_2\",\"zonepath\":\"[1,6,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FWHTUJNUGD\",\"page\":1,\"spuid\":\"FWHTUJNUGD\",\"tabindex\":70,\"type\":\"Label\",\"value\":\"CAP:\",\"w\":56,\"x\":496,\"y\":298,\"zone\":\"pag1_6_3_2\",\"zonepath\":\"[1,6,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HQJYVIBPZH\",\"page\":1,\"spuid\":\"HQJYVIBPZH\",\"tabindex\":71,\"type\":\"Label\",\"value\":\"Provincia:\",\"w\":88,\"x\":680,\"y\":298,\"zone\":\"pag1_6_3_2\",\"zonepath\":\"[1,6,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BMYDWAIPBZ\",\"page\":1,\"spuid\":\"BMYDWAIPBZ\",\"tabindex\":72,\"type\":\"Label\",\"value\":\"Citt\\u00E0:\",\"w\":80,\"x\":16,\"y\":298,\"zone\":\"pag1_6_3_2\",\"zonepath\":\"[1,6,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Indirizzo\",\"h\":20,\"maxlength\":50,\"name\":\"MADOMIND\",\"page\":1,\"spuid\":\"AZHKYECVLF\",\"tabindex\":66,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":96,\"y\":322,\"zone\":\"pag1_6_3_3\",\"zonepath\":\"[1,6,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XUEHNZJRPC\",\"page\":1,\"spuid\":\"XUEHNZJRPC\",\"tabindex\":67,\"type\":\"Label\",\"value\":\"Indirizzo:\",\"w\":80,\"x\":16,\"y\":326,\"zone\":\"pag1_6_3_3\",\"zonepath\":\"[1,6,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"N. Civico\",\"h\":20,\"maxlength\":15,\"name\":\"MADOMNCIV\",\"page\":1,\"spuid\":\"DRNUGFPEBE\",\"tabindex\":68,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":552,\"y\":322,\"zone\":\"pag1_6_3_3\",\"zonepath\":\"[1,6,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FFDHPXIQUB\",\"page\":1,\"spuid\":\"FFDHPXIQUB\",\"tabindex\":69,\"type\":\"Label\",\"value\":\"N. Civico:\",\"w\":96,\"x\":456,\"y\":326,\"zone\":\"pag1_6_3_3\",\"zonepath\":\"[1,6,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_tbmacageBO BO,ServletStatus status) {
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
     "<script src='armt_tbmacage?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_tbmacage_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_tbmacage_edit.js'>" +
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
      status.out.println("w_MACODICE=a[0];");
      status.out.println("w_MADESCRI=a[1];");
      status.out.println("w_MAFLGRAP=a[2];");
      status.out.println("w_MAFLGOPE=a[3];");
      status.out.println("w_MAFLGBON=a[4];");
      status.out.println("w_MAFLGCKR=a[5];");
      status.out.println("w_MAFLGASR=a[6];");
      status.out.println("w_MAFLGNOX=a[7];");
      status.out.println("w_MADIPSTD=a[8];");
      status.out.println("w_MANAIDWU=a[9];");
      status.out.println("w_MAFLGCHKDAT=a[10];");
      status.out.println("w_MAFLGACT=a[11];");
      status.out.println("w_MARESSDEF=a[12];");
      status.out.println("w_MAFLGAUA=a[13];");
      status.out.println("w_MATIPAGE=a[14];");
      status.out.println("w_MAFISGIU=a[15];");
      status.out.println("w_MADATINI=a[16];");
      status.out.println("w_MADATFIN=a[17];");
      status.out.println("w_MADATMOD=a[18];");
      status.out.println("w_MACODFIS=a[19];");
      status.out.println("w_MACOGNOME=a[20];");
      status.out.println("w_MANOME=a[21];");
      status.out.println("w_MARESPAESE=a[22];");
      status.out.println("w_MARESCITTA=a[23];");
      status.out.println("w_MARESCAP=a[24];");
      status.out.println("w_MARESPRV=a[25];");
      status.out.println("w_MARESIND=a[26];");
      status.out.println("w_MARESNCIV=a[27];");
      status.out.println("w_MADOMPAESE=a[28];");
      status.out.println("w_MADOMCITTA=a[29];");
      status.out.println("w_MADOMCAP=a[30];");
      status.out.println("w_MADOMPRV=a[31];");
      status.out.println("w_MADOMIND=a[32];");
      status.out.println("w_MADOMNCIV=a[33];");
      status.out.println("w_MAFLGCOMPL=a[34];");
      status.out.println("w_gFlgWU=a[35];");
      status.out.println("w_xDESDIP=a[36];");
      status.out.println("w_despaese=a[37];");
      status.out.println("w_xDESSTARES=a[38];");
      status.out.println("w_xDESSTADOM=a[39];");
      status.out.println("o_FZFECYSHCA_expand=null;");
      status.out.println("o_FZFECYSHCA_collapse=null;");
      status.out.println("o_IQCHDVPIPM_expand=null;");
      status.out.println("o_IQCHDVPIPM_collapse=null;");
      status.out.println("m_cWv_ardt_ageresleg=a[40];");
      status.out.println("if (Gt(a.length,41)) {");
      status.out.println("m_cErrorInChild='';");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['MACODICE'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_tbmacage_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(240,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","tbmacage");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","MACODICE");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(armt_tbmacageBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({MACODICE:"+SPLib.ToJSValue(BO.w_MACODICE,"C",5,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_tbmacageBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({MACODICE:"+SPLib.ToJSValue(BO.w_MACODICE,"C",5,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armt_tbmacageBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({MACODICE:"+SPLib.ToJSValue(BO.w_MACODICE,"C",5,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armt_tbmacageBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({MACODICE:"+SPLib.ToJSValue(BO.w_MACODICE,"C",5,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armt_tbmacageBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({MACODICE:"+SPLib.ToJSValue(BO.w_MACODICE,"C",5,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_tbmacageBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_tbmacageBO BO,ServletStatus status) throws IOException {
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
      CPLib.AddToSet(callable,"ardt_ageresleg");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_tbmacageBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_MACODICE),"C",5,0));
      }
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gFlgWU),"C",1,0));
    } else if (CPLib.eq(p_cUID,"LRWPVABXRO")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"XDJMLPLVUM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"BFMOWHWVBP")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ODQOMCYUIH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"DJVPNMOUXM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"UUHMAJHIGT")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"HSKILYGZSO")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NHXACJTYPN")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_tbmacageBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_MADIPSTD))) {
        a = GetCheckVars(status,BO,"LRWPVABXRO");
        b = status.m_CheckVars.optString("LRWPVABXRO");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_MARESSDEF))) {
        a = GetCheckVars(status,BO,"XDJMLPLVUM");
        b = status.m_CheckVars.optString("XDJMLPLVUM");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_MARESPAESE))) {
        a = GetCheckVars(status,BO,"BFMOWHWVBP");
        b = status.m_CheckVars.optString("BFMOWHWVBP");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_MADOMPAESE))) {
        a = GetCheckVars(status,BO,"DJVPNMOUXM");
        b = status.m_CheckVars.optString("DJVPNMOUXM");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_MARESPAESE))) {
        a = GetCheckVars(status,BO,"HSKILYGZSO");
        b = status.m_CheckVars.optString("HSKILYGZSO");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
