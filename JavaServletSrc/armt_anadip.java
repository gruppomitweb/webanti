import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_anadip extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*361aa267*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "anadip";
    }
    public String w_CODDIP;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_CODDIP,context,"anadip","CODDIP","C",6,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='CODDIP' type='hidden' value="+SPLib.ToHTMLValue(w_CODDIP,"C",6,0)+">" +
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
    armt_anadipBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_anadip;
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
      status.w_CODDIP = BO.w_CODDIP;
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
    return "Dipendenze";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_anadip";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 1085;
    l_eg.m_nEntityHeight = 357;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"anadip","tbcitta","tbmacage","tbstati","tbcateg04","tbcateg05","tbcateg01","tbcateg02","tbcateg03"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","","page"),new ZoneItem("DatiBase","Dati Base","horizontal_section"),new ZoneItem("DatiAdd","Dati Aggiuntivi Agenzia","horizontal_section"),new ZoneItem("Rischio","Valori per Rischio","horizontal_section"),new ZoneItem("Dati SARA/SV","Dati aggiuntivi per SOS/SARA/SV","horizontal_section"),new ZoneItem("Preposti","Soggetti Preposti (Comunicazione Soggetti Convenzionati OAM)","horizontal_section")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"CODDIP"};
    l_eg.items = new SPItem[]{
                   new SPItem("CODDIP","C",6,0, "edit","Codice Dipendenza"),
                   new SPItem("DESCRIZ","C",30,0, "edit","Descrizione"),
                   new SPItem("DOMICILIO","C",50,0, "edit","Indirizzo"),
                   new SPItem("CAP","C",5,0, "edit","CAP"),
                   new SPItem("IDCITTA","C",10,0, "hide","Codice Città"),
                   new SPItem("DESCCIT","C",60,0, "edit","Città"),
                   new SPItem("PROVINCIA","C",2,0, "show","Provincia"),
                   new SPItem("CAB","C",6,0, "show","CAB"),
                   new SPItem("AGENTE","C",1,0, "edit","Agente"),
                   new SPItem("gFlgWU","C",1,0, "hide","Gestione WU"),
                   new SPItem("MACROAGENTE","C",5,0, "edit","Denominazione MacroAgente"),
                   new SPItem("TERMINALID","C",15,0, "edit","ID Terrminale"),
                   new SPItem("xMADESCRI","C",60,0, "hide","Denominazione"),
                   new SPItem("IDBASE","C",10,0, "edit","CGO Codice Interno"),
                   new SPItem("TELEFONO","C",15,0, "edit","Telefono"),
                   new SPItem("ABICABSARA","C",12,0, "edit","ABI CAB Dipendenza per SARA"),
                   new SPItem("AGACCODE","C",10,0, "edit","Dipendenza WU"),
                   new SPItem("NAZAGENTE","C",3,0, "edit","Nazionalità Agente"),
                   new SPItem("xDESCNAZ","C",40,0, "hide","Descrizione"),
                   new SPItem("VALCOMPL","C",2,0, "hide","Visita Compliance"),
                   new SPItem("ANOMOPER","C",2,0, "hide","Anomalie Operative"),
                   new SPItem("OPXSOSCLI","N",10,0, "hide","Op. Sospette Cliente"),
                   new SPItem("OPXSOSAGE","N",10,0, "hide","SOS Agente"),
                   new SPItem("AGEREGIO","C",2,0, "edit","Regione"),
                   new SPItem("FLGATT","C",1,0, "edit","Agenzia Attiva (S/N)"),
                   new SPItem("CODLOC","C",25,0, "edit","Codice Locale (CGO)"),
                   new SPItem("CODAGE","C",15,0, "edit","Codice AGENTE"),
                   new SPItem("gAgeCGO","C",1,0, "hide","Creazione Automatica agente"),
                   new SPItem("TIPOSV","C",3,0, "edit","Canale Distributivo (SV)"),
                   new SPItem("FLGNOAUA","C",1,0, "edit","Escludi Controlli AUA"),
                   new SPItem("FLGWUPOS","C",1,0, "edit","Flag WUPOS"),
                   new SPItem("tipocat","C",10,0, "hide",""),
                   new SPItem("CATEG04","C",2,0, "edit","Categoria 1"),
                   new SPItem("CATEG05","C",2,0, "edit","Categoria 1"),
                   new SPItem("xC1DESCRI","C",80,0, "hide","Descrizione"),
                   new SPItem("xC2DESCRI","C",80,0, "hide","Descrizione"),
                   new SPItem("xC3DESCRI","C",80,0, "hide","Descrizione"),
                   new SPItem("xC4DESCRI","C",80,0, "hide","Descrizione"),
                   new SPItem("xC5DESCRI","C",80,0, "hide","Descrizione"),
                   new SPItem("CATEGORIA","C",10,0, "hide","Categoria"),
                   new SPItem("CATEG01","C",2,0, "edit","Categoria 1"),
                   new SPItem("CATEG02","C",2,0, "edit","Categoria 2"),
                   new SPItem("CATEG03","C",2,0, "edit","Categoria 3"),
                   new SPItem("CAB2","C",6,0, "edit","CAB Bancario"),
                   new SPItem("CODICEAAMS","C",12,0, "edit","Codice AAMS Sala"),
                   new SPItem("CONCESSIONE","C",10,0, "edit","Concessione"),
                   new SPItem("CODFISC","C",16,0, "edit","Codice Fiscale"),
                   new SPItem("PARTIVA","C",11,0, "edit","Partita IVA"),
                   new SPItem("TIPOAGENTE","C",2,0, "edit","Tipo Agente"),
                   new SPItem("NUMCIVICO","C",15,0, "edit","Numero Civico"),
                   new SPItem("SERRIMDEN","C",1,0, "edit","Servizi Rimessa Denaro (S/N)"),
                   new SPItem("gTipInter","C",2,0, "hide","Tipo Intermediario"),
                   new SPItem("DATAINI","D",8,0, "edit","Data Inizio Mandato"),
                   new SPItem("DATAFINE","D",8,0, "edit","Data Fine Mandato"),
                   new SPItem("xDESCAN","C",50,0, "hide","Descrizione"),
                   new SPItem("xMACOGNOME","C",50,0, "hide","Cognome"),
                   new SPItem("xMANOME","C",50,0, "hide","Nome"),
                   new SPItem("FLGCOMPL","N",1,0, "edit","Chiusura per compliance")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_anadipBO BO) {
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
    l_translations=new String[][]{{"10083148406",p_Context.Translate("Visita Compliance")},
    {"10095365423",p_Context.Translate("Provincia")},
    {"10180688344",p_Context.Translate("Data Fine Mandato")},
    {"10376012512",p_Context.Translate("ABI CAB Dipendenza per SARA")},
    {"10894365193",p_Context.Translate("Anomalie Operative")},
    {"1093030153",p_Context.Translate("Codice Locale (CGO)")},
    {"10983493593",p_Context.Translate("Gestione WU")},
    {"11009959272",p_Context.Translate("Servizi di rimessa in denaro")},
    {"11148782069",p_Context.Translate("MacroAgenti")},
    {"11153969262",p_Context.Translate("Tipo Agente")},
    {"11189129404",p_Context.Translate("Codice AAMS Sala")},
    {"11223264513",p_Context.Translate("Data Inizio Mandato")},
    {"113986481",p_Context.Translate("Agente")},
    {"11537497388",p_Context.Translate("CAB Bancario")},
    {"11553173743",p_Context.Translate("Escludi Controlli AUA")},
    {"11725152890",p_Context.Translate("Denominazione MacroAgente")},
    {"11749879174",p_Context.Translate("Creazione Automatica agente")},
    {"11921223220",p_Context.Translate("Codice Fiscale")},
    {"12014834236",p_Context.Translate("CGO Codice Interno")},
    {"12056209762",p_Context.Translate("Denominazione")},
    {"12090880341",p_Context.Translate("WUPOS Attivo")},
    {"12128215460",p_Context.Translate("Servizi Rimessa Denaro (S/N)")},
    {"1240894674",p_Context.Translate("ID Terrminale")},
    {"1270046471",p_Context.Translate("SOS Agente")},
    {"1270140318",p_Context.Translate("Dipendenze")},
    {"1276075358",p_Context.Translate("Dipendenza WU")},
    {"1325233457",p_Context.Translate("Obbligatoria se chiusura per compliance")},
    {"1455978204",p_Context.Translate("Codice Città")},
    {"1474192743",p_Context.Translate("Numero Civico")},
    {"15186643",p_Context.Translate("Città")},
    {"1519836549",p_Context.Translate("Flag WUPOS")},
    {"157141684",p_Context.Translate("Categoria")},
    {"157154740",p_Context.Translate("Categoria 1")},
    {"157154996",p_Context.Translate("Categoria 2")},
    {"157155252",p_Context.Translate("Categoria 3")},
    {"157155508",p_Context.Translate("Categoria 4")},
    {"157155764",p_Context.Translate("Categoria 5")},
    {"1700577956",p_Context.Translate("Telefono")},
    {"1756430089",p_Context.Translate("Partita IVA")},
    {"178000258",p_Context.Translate("Concessione")},
    {"18003",p_Context.Translate("CAB")},
    {"1816546867",p_Context.Translate("Cognome")},
    {"1817574818",p_Context.Translate("Regione")},
    {"1855870770",p_Context.Translate("Agenzia Attiva")},
    {"1946812107",p_Context.Translate("Nazionalità Agente")},
    {"2057489465",p_Context.Translate("Op. Sospette Cliente")},
    {"2071283709",p_Context.Translate("Codice Dipendenza")},
    {"21587",p_Context.Translate("CAP")},
    {"229480117",p_Context.Translate("Canale Distributivo (SV)")},
    {"233672885",p_Context.Translate("Canali Distributivi (SV)")},
    {"245446773",p_Context.Translate("Agenzia Attiva (S/N)")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"443454",p_Context.Translate("Nome")},
    {"554236824",p_Context.Translate("Indirizzo")},
    {"7383187",p_Context.Translate("Stati")},
    {"923045322",p_Context.Translate("Codice AGENTE")},
    {"984756930",p_Context.Translate("Tipo Intermediario")},
    {"986106899",p_Context.Translate("Chiusura per compliance")}};
    return l_translations;
  }
  void WriteStyles(armt_anadipBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_anadip.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_anadipBO BO,ServletStatus status) {
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
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_anadip',false);");
    }
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_anadip",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(armt_anadipBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,2);
  }
  void WriteControls_p1(armt_anadipBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:357px;width:1085px;display:none'>" +
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
  void WriteControls_p1_b0(armt_anadipBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_1' style='position:relative;height:9px;display:block' page='1'>" +
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
  void WriteControls_p1_b1(armt_anadipBO BO,ServletStatus status) {
    status.out.println(
     "<div name='DatiBase' id='UBUBESGOCL_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
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
     "<div id='UBUBESGOCL' class='SectionBody' style='position:relative;height:126px;display:block'>" +
    "");
    status.includeZoneAltInterface("DatiBase@BEGIN");
    if (status.includeZoneAltInterface("DatiBase")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("DatiBase@BEGIN") || status.HasZoneAltInterface("DatiBase@END")) {
        status.out.println(
         "<div id='UBUBESGOCL_boxContent' style='position:relative;height:126px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODDIP' id='PBPAZFLKHV' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_CODDIP,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='6' size='6' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RBRNYGGGZL_DIV'>" +
       "<label id='RBRNYGGGZL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DESCRIZ' id='XCUHPGQTRL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DESCRIZ,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DOMICILIO' id='JRSYWVEHIR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DOMICILIO,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HSCGRBUSWT_DIV'>" +
       "<label id='HSCGRBUSWT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Descrizione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CAP' id='KQSLGVHSRE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CAP,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DESCCIT' id='AEZUFOYHTM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DESCCIT,"C",60,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='60' size='60' fieldtype='C'>" +
       "<button id='AEZUFOYHTM_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "AEZUFOYHTM", "tbcitta", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BMQWNHMESL_DIV'>" +
       "<label id='BMQWNHMESL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Città:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='PROVINCIA' id='WBQFGTJCPW' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_PROVINCIA,"C",2,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GVPDXVYAAR_DIV'>" +
       "<label id='GVPDXVYAAR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Provincia:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='CAB' id='FJRMKWPZIG' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CAB,"C",6,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='6' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XFSMURLNKN_DIV'>" +
       "<label id='XFSMURLNKN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAB:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='WRIYZYCTBR_DIV'>" +
       "<input name='AGENTE' id='WRIYZYCTBR' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_AGENTE,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_AGENTE))?"CHECKED":"")+">" +
       "<label id='WRIYZYCTBR_LBL' for='WRIYZYCTBR' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Agente"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MACROAGENTE' id='BPQQBVFABO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MACROAGENTE,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
       "<button id='BPQQBVFABO_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "BPQQBVFABO", "tbmacage", "armt_tbmacage", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BUKDXBSGHV_DIV'>" +
       "<label id='BUKDXBSGHV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Macro Agente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='QJZAQQCYWJ_DIV'>" +
       "<label id='QJZAQQCYWJ'>" +
       ""+SPLib.ToHTMLRepresentation((CPLib.Empty(BO.w_xMADESCRI)?CPLib.LRTrim(BO.w_xMACOGNOME)+" "+CPLib.LRTrim(BO.w_xMANOME):CPLib.LRTrim(BO.w_xMADESCRI)))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LGDVILSMPZ_DIV'>" +
       "<label id='LGDVILSMPZ' for='JRSYWVEHIR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Indirizzo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='TELEFONO' id='CDMUQZYEAX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TELEFONO,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RASTVMTGDB_DIV'>" +
       "<label id='RASTVMTGDB' for='CDMUQZYEAX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Telefono:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TTSBPIZZEM_DIV'>" +
       "<label id='TTSBPIZZEM' for='KQSLGVHSRE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAP:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='ECKDLHTTSN_DIV'>" +
       "<input name='FLGATT' id='ECKDLHTTSN' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGATT,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGATT))?"CHECKED":"")+">" +
       "<label id='ECKDLHTTSN_LBL' for='ECKDLHTTSN' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Agenzia Attiva"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CAB2' id='IOZYXJKYDX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CAB2,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LJFDSMRYHQ_DIV'>" +
       "<label id='LJFDSMRYHQ' for='IOZYXJKYDX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAB Bancario:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NUMCIVICO' id='PWMWPIWKXR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NUMCIVICO,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NFTCHEJXHV_DIV'>" +
       "<label id='NFTCHEJXHV' for='PWMWPIWKXR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Numero Civico:"))+"" +
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
  void WriteControls_p1_b1_CloseBand(armt_anadipBO BO,ServletStatus status) {
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
      status.out.println("Ctrl('UBUBESGOCL').style.height='auto';");
    } else {
      status.out.println("Ctrl('UBUBESGOCL').setAttribute('band_height',126);");
    }
    status.out.println("Ctrl('UBUBESGOCL').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_anadipBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_SJOTYLCKUC")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_SJOTYLCKUC' style='position:relative;height:9px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_SJOTYLCKUC")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_SJOTYLCKUC').style.height='auto';");
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
  void WriteControls_p1_b3(armt_anadipBO BO,ServletStatus status) {
    status.out.println(
     "<div id='tabs_1_Dati_container'>" +
     " " +
     "</div>" +
    "");
    status.out.println(
     "<div name='Dati SARA/SV' id='SJOTYLCKUC_DIV' class='BoxContainer SPSection_expanded TabStripBoxContainer' group_id='tabs_1_Dati'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var tabs_1_Dati = new Z.Tabs({container:'tabs_1_Dati_container',useGlobals: false,boxtabs: true,useseparator:GetStyleVariable('boxTabUseSeparator',null,''),expandcollapse:GetStyleVariable('boxTabCanCollapse',null,''),contents:[],tabstrip_class: ''});");
    status.out.println("Z.Tabs.Set('tabs_1_Dati',tabs_1_Dati);");
    status.out.println("var l_nSJOTYLCKUCTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='SJOTYLCKUC' class='TabStripBoxBody' style='position:relative;height:81px;display:block'>" +
    "");
    status.includeZoneAltInterface("Dati SARA/SV@BEGIN");
    if (status.includeZoneAltInterface("Dati SARA/SV")) {
      WriteControls_p1_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Dati SARA/SV@BEGIN") || status.HasZoneAltInterface("Dati SARA/SV@END")) {
        status.out.println(
         "<div id='SJOTYLCKUC_boxContent' style='position:relative;height:81px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ABICABSARA' id='YTCIMOKXKS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ABICABSARA,"C",12,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='12' size='12' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LRAFMUSNIS_DIV'>" +
       "<label id='LRAFMUSNIS' for='YTCIMOKXKS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ABI CAB Dipendenza per SARA:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPOSV' id='LYZAJWZGAM' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EXFKQPWTSQ_DIV'>" +
       "<label id='EXFKQPWTSQ' for='LYZAJWZGAM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Canale Distributivo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODFISC' id='ACTQHMCVYK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODFISC,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LLXHZULQLI_DIV'>" +
       "<label id='LLXHZULQLI' for='ACTQHMCVYK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PARTIVA' id='RTWJYVXECF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PARTIVA,"C",11,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='11' size='11' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FDEKGGVCSR_DIV'>" +
       "<label id='FDEKGGVCSR' for='RTWJYVXECF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Partita IVA:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPOAGENTE' id='ACDLDQVQXS' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("PF","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("PF",CPLib.Trim(BO.w_TIPOAGENTE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Persona fisica")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("PG","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("PG",CPLib.Trim(BO.w_TIPOAGENTE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Persona Giuridica")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('ACDLDQVQXS'),w_TIPOAGENTE,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZMFFOLWFAF_DIV'>" +
       "<label id='ZMFFOLWFAF' for='ACDLDQVQXS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Agente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Dati SARA/SV@BEGIN") || status.HasZoneAltInterface("Dati SARA/SV@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b3_CloseBand(armt_anadipBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Dati SARA/SV@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Dati SARA/SV")) {
      status.out.println("Ctrl('SJOTYLCKUC').style.height='auto';");
    } else {
      status.out.println("Ctrl('SJOTYLCKUC').setAttribute('band_height',81);");
    }
    status.out.println("Ctrl('SJOTYLCKUC').setAttribute('status','open');");
    status.out.println("tabs_1_Dati.AddTab({name:\"SJOTYLCKUC\", element:\"SJOTYLCKUC_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati aggiuntivi per SOS/SARA/SV"),"C",0,0)+",tabIndex: l_nSJOTYLCKUCTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('SJOTYLCKUC',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('SJOTYLCKUC',false,true,false)}});");
    status.out.println("if (tabs_1_Dati.CanCollapse()) {");
    status.out.println("tabs_1_Dati.Expand('SJOTYLCKUC');");
    status.out.println("}");
    status.out.println("PageOpened.AppendReceiver('page_1',tabs_1_Dati.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b4(armt_anadipBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_OQJXMMCZQK")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_OQJXMMCZQK' style='position:relative;height:9px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_OQJXMMCZQK")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_OQJXMMCZQK').style.height='auto';");
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
  void WriteControls_p1_b5(armt_anadipBO BO,ServletStatus status) {
    status.out.println(
     "<div name='DatiAdd' id='OQJXMMCZQK_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' style='display:none' group_id='tabs_1_Dati'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nOQJXMMCZQKTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='OQJXMMCZQK' class='TabStripBoxBody' style='position:relative;height:99px;display:none'>" +
    "");
    status.includeZoneAltInterface("DatiAdd@BEGIN");
    if (status.includeZoneAltInterface("DatiAdd")) {
      WriteControls_p1_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("DatiAdd@BEGIN") || status.HasZoneAltInterface("DatiAdd@END")) {
        status.out.println(
         "<div id='OQJXMMCZQK_boxContent' style='position:relative;height:99px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='TERMINALID' id='RTLSPZPWWO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TERMINALID,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WRCFGXMASK_DIV' style='display:none'>" +
       "<label id='WRCFGXMASK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ID Terrminale:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IDBASE' id='WTENUNIUCY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_IDBASE,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='10' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FOXBQNQVXR_DIV'>" +
       "<label id='FOXBQNQVXR' for='WTENUNIUCY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CGO Codice Interno:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AGACCODE' id='NISBFWYVAN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AGACCODE,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='10' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ECJVBPLVAM_DIV'>" +
       "<label id='ECJVBPLVAM' for='NISBFWYVAN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Interno:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODLOC' id='DUZIXALHHS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODLOC,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KPEKMJMQUX_DIV'>" +
       "<label id='KPEKMJMQUX' for='DUZIXALHHS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Locale (CGO):"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODAGE' id='MOQMJLJJNI' type='text' class='"+status.ObligatoryClass("Field",BO.MOQMJLJJNI_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_CODAGE,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MRGPZXPZJX_DIV' style='display:none'>" +
       "<label id='MRGPZXPZJX' for='MOQMJLJJNI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice AGENTE:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='NPJMZHJDRZ_DIV' style='display:none'>" +
       "<input name='FLGNOAUA' id='NPJMZHJDRZ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGNOAUA,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGNOAUA))?"CHECKED":"")+">" +
       "<label id='NPJMZHJDRZ_LBL' for='NPJMZHJDRZ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Escludi Controlli AUA"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='PNZMYOKETI_DIV' style='display:none'>" +
       "<input name='FLGWUPOS' id='PNZMYOKETI' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGWUPOS,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGWUPOS))?"CHECKED":"")+">" +
       "<label id='PNZMYOKETI_LBL' for='PNZMYOKETI' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("WUPOS Attivo"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODICEAAMS' id='VYZSOTTSWB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODICEAAMS,"C",12,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='12' size='12' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XKQHBHHNKD_DIV'>" +
       "<label id='XKQHBHHNKD' for='VYZSOTTSWB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice AAMS Sala:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CONCESSIONE' id='JJJFDTJFAK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONCESSIONE,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='10' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BGLJJMTOYA_DIV'>" +
       "<label id='BGLJJMTOYA' for='JJJFDTJFAK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Concessione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("DatiAdd@BEGIN") || status.HasZoneAltInterface("DatiAdd@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b5_CloseBand(armt_anadipBO BO,ServletStatus status) {
    status.includeZoneAltInterface("DatiAdd@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("DatiAdd")) {
      status.out.println("Ctrl('OQJXMMCZQK').style.height='auto';");
    } else {
      status.out.println("Ctrl('OQJXMMCZQK').setAttribute('band_height',99);");
    }
    status.out.println("Ctrl('OQJXMMCZQK').setAttribute('status','close');");
    status.out.println("tabs_1_Dati.AddTab({name:\"OQJXMMCZQK\", element:\"OQJXMMCZQK_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati Aggiuntivi Agenzia"),"C",0,0)+",tabIndex: l_nOQJXMMCZQKTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('OQJXMMCZQK',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('OQJXMMCZQK',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_1',tabs_1_Dati.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b6(armt_anadipBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_RFAIYHSGII")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_RFAIYHSGII' style='position:relative;height:9px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_RFAIYHSGII")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_RFAIYHSGII').style.height='auto';");
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
  void WriteControls_p1_b7(armt_anadipBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Rischio' id='RFAIYHSGII_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' group_id='tabs_1_Dati'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nRFAIYHSGIITabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='RFAIYHSGII' class='TabStripBoxBody' style='position:relative;height:198px;display:none'>" +
    "");
    status.includeZoneAltInterface("Rischio@BEGIN");
    if (status.includeZoneAltInterface("Rischio")) {
      WriteControls_p1_b7_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Rischio@BEGIN") || status.HasZoneAltInterface("Rischio@END")) {
        status.out.println(
         "<div id='RFAIYHSGII_boxContent' style='position:relative;height:198px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NAZAGENTE' id='SGDAQGMTNU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NAZAGENTE,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='SGDAQGMTNU_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "SGDAQGMTNU", "tbstati", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SARKHBDBSW_DIV'>" +
       "<label id='SARKHBDBSW' for='SGDAQGMTNU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nazionalità Agente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VNMKJRVPPS_DIV'>" +
       "<label id='VNMKJRVPPS'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xDESCNAZ)+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='AGEREGIO' id='KSBCZELDDB' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("01","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("01",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Abruzzo")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("02","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("02",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Basilicata")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("03","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("03",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Calabria")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("04","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("04",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Campania")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("05","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("05",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Emilia-Romagna")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("06","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("06",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Friuli-Venezia Giulia")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("07","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("07",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Lazio")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("08","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("08",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Liguria")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("09","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("09",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Lombardia")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("10","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("10",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Marche")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("11","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("11",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Molise")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("12","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("12",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Piemonte")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("13","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("13",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Puglia")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("14","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("14",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Sardegna")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("15","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("15",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Sicilia")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("16","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("16",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Toscana")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("17","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("17",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Trentino-Alto Adige")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("18","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("18",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Umbria")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("19","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("19",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Valle d'Aosta")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("20","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("20",CPLib.Trim(BO.w_AGEREGIO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Veneto")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('KSBCZELDDB'),w_AGEREGIO,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SFACPNQMFC_DIV'>" +
       "<label id='SFACPNQMFC' for='KSBCZELDDB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Regione:"))+"" +
       "</label>" +
       "</span>" +
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
       "<label id='WWRYOVTMFY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Categoria 1:"))+"" +
       "</label>" +
       "</span>" +
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
       "<label id='HNQZARYXGS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Categoria 2:"))+"" +
       "</label>" +
       "</span>" +
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
       "<label id='BGEVFUGGOS'>" +
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
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CATEG01' id='ICGUZGYXTD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CATEG01,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
       "<button id='ICGUZGYXTD_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "ICGUZGYXTD", "tbcateg01", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CATEG02' id='TGQHYPERED' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CATEG02,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
       "<button id='TGQHYPERED_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "TGQHYPERED", "tbcateg02", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CATEG03' id='QRJNKZVHDW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CATEG03,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
       "<button id='QRJNKZVHDW_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "QRJNKZVHDW", "tbcateg03", "", "")+"" +
      "");
      if (status.HasZoneAltInterface("Rischio@BEGIN") || status.HasZoneAltInterface("Rischio@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b7_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b7_CloseBand(armt_anadipBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Rischio@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Rischio")) {
      status.out.println("Ctrl('RFAIYHSGII').style.height='auto';");
    } else {
      status.out.println("Ctrl('RFAIYHSGII').setAttribute('band_height',198);");
    }
    status.out.println("Ctrl('RFAIYHSGII').setAttribute('status','close');");
    status.out.println("tabs_1_Dati.AddTab({name:\"RFAIYHSGII\", element:\"RFAIYHSGII_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Valori per Rischio"),"C",0,0)+",tabIndex: l_nRFAIYHSGIITabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('RFAIYHSGII',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('RFAIYHSGII',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_1',tabs_1_Dati.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b8(armt_anadipBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_DKPWIMNYIB")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_DKPWIMNYIB' style='position:relative;height:9px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_DKPWIMNYIB")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_DKPWIMNYIB').style.height='auto';");
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
  void WriteControls_p1_b9(armt_anadipBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Preposti' id='DKPWIMNYIB_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' group_id='tabs_1_Dati'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nDKPWIMNYIBTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='DKPWIMNYIB' class='TabStripBoxBody' style='position:relative;height:198px;display:none'>" +
    "");
    status.includeZoneAltInterface("Preposti@BEGIN");
    if (status.includeZoneAltInterface("Preposti")) {
      WriteControls_p1_b9_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Preposti@BEGIN") || status.HasZoneAltInterface("Preposti@END")) {
        status.out.println(
         "<div id='DKPWIMNYIB_boxContent' style='position:relative;height:198px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<iframe name='ardt_dippreposti' id='ZBFNRFHLSE' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
       "</iframe>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='VKYZPROJCI_DIV'>" +
       "<input name='SERRIMDEN' id='VKYZPROJCI' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_SERRIMDEN,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_SERRIMDEN))?"CHECKED":"")+">" +
       "<label id='VKYZPROJCI_LBL' for='VKYZPROJCI' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Servizi di rimessa in denaro"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAINI' id='OSJJWSZMDE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATAINI,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='OSJJWSZMDE_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MDCCDZNMIV_DIV'>" +
       "<label id='MDCCDZNMIV' for='OSJJWSZMDE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Inizio Mandato:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAFINE' id='QDGOPSCQNI' type='text' class='"+status.ObligatoryClass("Field",BO.QDGOPSCQNI_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_DATAFINE,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='QDGOPSCQNI_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XHVKTYTVYI_DIV'>" +
       "<label id='XHVKTYTVYI' for='QDGOPSCQNI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Fine Mandato:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='DVNRBUBGST_DIV'>" +
       "<input name='FLGCOMPL' id='DVNRBUBGST' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGCOMPL,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_FLGCOMPL)?"CHECKED":"")+">" +
       "<label id='DVNRBUBGST_LBL' for='DVNRBUBGST' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Chiusura per compliance"))+"</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Preposti@BEGIN") || status.HasZoneAltInterface("Preposti@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b9_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b9_CloseBand(armt_anadipBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Preposti@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Preposti")) {
      status.out.println("Ctrl('DKPWIMNYIB').style.height='auto';");
    } else {
      status.out.println("Ctrl('DKPWIMNYIB').setAttribute('band_height',198);");
    }
    status.out.println("Ctrl('DKPWIMNYIB').setAttribute('status','close');");
    status.out.println("tabs_1_Dati.AddTab({name:\"DKPWIMNYIB\", element:\"DKPWIMNYIB_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Soggetti Preposti (Comunicazione Soggetti Convenzionati OAM)"),"C",0,0)+",tabIndex: l_nDKPWIMNYIBTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('DKPWIMNYIB',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('DKPWIMNYIB',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_1',tabs_1_Dati.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
    WriteExtendedCBoxGroupChildren(BO.m_MNTs,status,"Dati",1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['DKPWIMNYIB']=['ZBFNRFHLSE'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b10(armt_anadipBO BO,ServletStatus status) {
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
  static void PrintState(armt_anadipBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_anadipBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
    if (BO.ardt_dippreposti.IsUpdated()) {
      BO.m_cWv_ardt_dippreposti = BO.ardt_dippreposti.GetContext();
    }
  }
  static void PrintStateWorkVars(armt_anadipBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_CODDIP,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCRIZ,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DOMICILIO,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAP,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDCITTA,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCCIT,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINCIA,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAB,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AGENTE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MACROAGENTE,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TERMINALID,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TELEFONO,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ABICABSARA,"C",12,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AGACCODE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NAZAGENTE,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VALCOMPL,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ANOMOPER,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OPXSOSCLI,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OPXSOSAGE,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AGEREGIO,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGATT,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODLOC,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODAGE,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOSV,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGNOAUA,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGWUPOS,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CATEG04,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CATEG05,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CATEGORIA,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CATEG01,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CATEG02,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CATEG03,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAB2,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODICEAAMS,"C",12,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONCESSIONE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODFISC,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PARTIVA,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOAGENTE,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMCIVICO,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SERRIMDEN,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAINI,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAFINE,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGCOMPL,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgWU,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xMADESCRI,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDESCNAZ,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gAgeCGO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipocat,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xC1DESCRI,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xC2DESCRI,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xC3DESCRI,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xC4DESCRI,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xC5DESCRI,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gTipInter,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDESCAN,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xMACOGNOME,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xMANOME,"C",50,0));
    if (CPLib.eq(BO.m_cWv_ardt_dippreposti,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_dippreposti");
    } else if (CPLib.eq(BO.m_cWv_ardt_dippreposti,"_not_empty_")) {
      BO.m_cWv_ardt_dippreposti = BO.ardt_dippreposti.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_dippreposti,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_dippreposti,"C",0,0));
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_anadipBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_QJZAQQCYWJ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_VNMKJRVPPS = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_NRWNAJJVRA = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_LNOFOPAOYD = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_WBTKNDJDFF = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_MWCFKQVNHF = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_HADVHTQAPE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(357,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_anadip"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'CZGVBAYWKP':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"CZGVBAYWKP",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'AEZUFOYHTM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"AEZUFOYHTM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'BPQQBVFABO':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"BPQQBVFABO",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbmacage,"+"default",l_session)+"'"+"]");
      status.out.print(",'SGDAQGMTNU':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SGDAQGMTNU",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'JQLGHMLOKO':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"JQLGHMLOKO",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg04,"+"default",l_session)+"'"+"]");
      status.out.print(",'QVBZSFMTVP':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QVBZSFMTVP",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg05,"+"default",l_session)+"'"+"]");
      status.out.print(",'ICGUZGYXTD':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ICGUZGYXTD",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg01,"+"default",l_session)+"'"+"]");
      status.out.print(",'TGQHYPERED':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"TGQHYPERED",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg02,"+"default",l_session)+"'"+"]");
      status.out.print(",'QRJNKZVHDW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QRJNKZVHDW",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg03,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'CZGVBAYWKP':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'AEZUFOYHTM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'BPQQBVFABO':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbmacage,"+"default",l_session)+"'"+"]");
      status.out.print(",'SGDAQGMTNU':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'JQLGHMLOKO':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg04,"+"default",l_session)+"'"+"]");
      status.out.print(",'QVBZSFMTVP':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg05,"+"default",l_session)+"'"+"]");
      status.out.print(",'ICGUZGYXTD':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg01,"+"default",l_session)+"'"+"]");
      status.out.print(",'TGQHYPERED':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg02,"+"default",l_session)+"'"+"]");
      status.out.print(",'QRJNKZVHDW':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg03,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_anadip","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_anadip",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("DatiAdd"),"")) {
      status.quoteAndAppend("DatiAdd","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Rischio"),"")) {
      status.quoteAndAppend("Rischio","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Dati SARA/SV"),"")) {
      status.quoteAndAppend("Dati SARA/SV","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Preposti"),"")) {
      status.quoteAndAppend("Preposti","hide","box");
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
  void WriteMainFormScript(armt_anadipBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    if (CPLib.gt(BO.extendedFields.length,0) || CPLib.HasTabFoundlings(BO.m_MNTs,"")) {
      status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_anadip',false);");
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
        status.out.println("if(c=Ctrl('PBPAZFLKHV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XCUHPGQTRL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JRSYWVEHIR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KQSLGVHSRE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AEZUFOYHTM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AEZUFOYHTM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WRIYZYCTBR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BPQQBVFABO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BPQQBVFABO_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RTLSPZPWWO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WTENUNIUCY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CDMUQZYEAX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YTCIMOKXKS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NISBFWYVAN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SGDAQGMTNU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SGDAQGMTNU_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KSBCZELDDB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ECKDLHTTSN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DUZIXALHHS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MOQMJLJJNI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LYZAJWZGAM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NPJMZHJDRZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PNZMYOKETI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JQLGHMLOKO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JQLGHMLOKO_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QVBZSFMTVP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QVBZSFMTVP_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ICGUZGYXTD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ICGUZGYXTD_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TGQHYPERED')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TGQHYPERED_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QRJNKZVHDW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QRJNKZVHDW_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IOZYXJKYDX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VYZSOTTSWB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JJJFDTJFAK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ACTQHMCVYK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RTWJYVXECF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ACDLDQVQXS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PWMWPIWKXR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VKYZPROJCI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OSJJWSZMDE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OSJJWSZMDE_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QDGOPSCQNI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QDGOPSCQNI_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DVNRBUBGST')) SetDisabled(c,true);");
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
      status.out.println("if (Ctrl('ZBFNRFHLSE')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('ZBFNRFHLSE',linkpc_url('ZBFNRFHLSE'));");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('PBPAZFLKHV')) SetDisabled(c,true);");
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
    status.out.println("if (Eq(name,'ardt_dippreposti')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_dippreposti")+"';");
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
  armt_anadipBO getBO(ServletStatus status) {
    armt_anadipBO BO = new armt_anadipBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_anadipBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("anadip",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_anadipBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_anadipBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbcandistr,CPSql.BuildSQLPhrase("CODICE,DESCRI",BO.m_cPhName_tbcandistr,"",""));
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",3,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("CODICE"),"C",3,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var LYZAJWZGAM_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(armt_anadipBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_anadip;
    String l_cPhName = BO.m_cPhName_anadip;
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
      String l_cQueryFilter = armt_anadipBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_anadip+".CODDIP",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("anadip");
    String l_cPhName = CPSql.ManipulateTablePhName("anadip",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".CODDIP",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,armt_anadipBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_anadipBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_anadip,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_anadip,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_anadipBO BO) {
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
  void Edit(ServletStatus status,armt_anadipBO BO,SPParameterSource source) {
    BO.Load(status.w_CODDIP);
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
  void New(ServletStatus status,armt_anadipBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_anadipBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_anadipBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_CODDIP = "";
      } else {
        BO.w_CODDIP = l_rsKeys.GetString("CODDIP");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_CODDIP = BO.w_CODDIP;
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
  void EditLoad(ServletStatus status,armt_anadipBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_anadipBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_CODDIP);
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
  void DeleteMessage(ServletStatus status,armt_anadipBO BO,SPParameterSource source) {
    BO.Load(status.w_CODDIP);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_anadipBO BO) {
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({CODDIP:"+SPLib.ToJSValue(BO.w_CODDIP,"C",6,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
  void Discard(ServletStatus status,armt_anadipBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_anadipBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",752);
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
    item.put("altInterfaceFor","armt_anadip");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"DatiBase\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Base\",\"h\":126,\"name\":\"DatiBase\",\"page\":1,\"shrinkable\":true,\"spuid\":\"UBUBESGOCL\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Dati Base\",\"titled\":true,\"type\":\"Box\",\"w\":1072,\"x\":8,\"y\":9,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Dipendenza\",\"h\":20,\"maxlength\":6,\"name\":\"CODDIP\",\"page\":1,\"spuid\":\"PBPAZFLKHV\",\"tabindex\":3,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":120,\"y\":18,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RBRNYGGGZL\",\"page\":1,\"spuid\":\"RBRNYGGGZL\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"Codice:\",\"w\":95,\"x\":24,\"y\":22,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Descrizione\",\"h\":20,\"maxlength\":30,\"name\":\"DESCRIZ\",\"page\":1,\"spuid\":\"XCUHPGQTRL\",\"tabindex\":5,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":272,\"y\":18,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HSCGRBUSWT\",\"page\":1,\"spuid\":\"HSCGRBUSWT\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"Descrizione:\",\"w\":76,\"x\":192,\"y\":22,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Agente\",\"h\":21,\"label_text\":\"Agente\",\"maxlength\":1,\"name\":\"AGENTE\",\"page\":1,\"spuid\":\"WRIYZYCTBR\",\"tabindex\":16,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":72,\"x\":480,\"y\":17,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Indirizzo\",\"h\":20,\"maxlength\":50,\"name\":\"DOMICILIO\",\"page\":1,\"spuid\":\"JRSYWVEHIR\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":120,\"y\":45,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LGDVILSMPZ\",\"page\":1,\"spuid\":\"LGDVILSMPZ\",\"tabindex\":26,\"type\":\"Label\",\"value\":\"Indirizzo:\",\"w\":96,\"x\":24,\"y\":49,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Telefono\",\"h\":20,\"maxlength\":15,\"name\":\"TELEFONO\",\"page\":1,\"spuid\":\"CDMUQZYEAX\",\"tabindex\":27,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":120,\"x\":736,\"y\":45,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RASTVMTGDB\",\"page\":1,\"spuid\":\"RASTVMTGDB\",\"tabindex\":28,\"type\":\"Label\",\"value\":\"Telefono:\",\"w\":100,\"x\":636,\"y\":49,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero Civico\",\"h\":20,\"maxlength\":15,\"name\":\"NUMCIVICO\",\"page\":1,\"spuid\":\"PWMWPIWKXR\",\"tabindex\":92,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":112,\"x\":552,\"y\":45,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NFTCHEJXHV\",\"page\":1,\"spuid\":\"NFTCHEJXHV\",\"tabindex\":93,\"type\":\"Label\",\"value\":\"Numero Civico:\",\"w\":104,\"x\":448,\"y\":49,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAP\",\"h\":20,\"maxlength\":5,\"name\":\"CAP\",\"page\":1,\"spuid\":\"KQSLGVHSRE\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":52,\"x\":568,\"y\":72,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Citt\\u00E0\",\"h\":20,\"maxlength\":60,\"name\":\"DESCCIT\",\"page\":1,\"picker\":true,\"spuid\":\"AEZUFOYHTM\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":378,\"x\":120,\"y\":72,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BMQWNHMESL\",\"page\":1,\"spuid\":\"BMQWNHMESL\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"Citt\\u00E0:\",\"w\":95,\"x\":24,\"y\":76,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia\",\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"PROVINCIA\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"WBQFGTJCPW\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":28,\"x\":704,\"y\":72,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GVPDXVYAAR\",\"page\":1,\"spuid\":\"GVPDXVYAAR\",\"tabindex\":13,\"type\":\"Label\",\"value\":\"Provincia:\",\"w\":61,\"x\":640,\"y\":76,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAB\",\"disabled\":\"true\",\"h\":20,\"maxlength\":6,\"name\":\"CAB\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"FJRMKWPZIG\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":64,\"x\":792,\"y\":72,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XFSMURLNKN\",\"page\":1,\"spuid\":\"XFSMURLNKN\",\"tabindex\":15,\"type\":\"Label\",\"value\":\"CAB:\",\"w\":43,\"x\":744,\"y\":76,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TTSBPIZZEM\",\"page\":1,\"spuid\":\"TTSBPIZZEM\",\"tabindex\":31,\"type\":\"Label\",\"value\":\"CAP:\",\"w\":44,\"x\":524,\"y\":76,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Denominazione MacroAgente\",\"h\":20,\"maxlength\":5,\"name\":\"MACROAGENTE\",\"page\":1,\"picker\":true,\"spuid\":\"BPQQBVFABO\",\"tabindex\":18,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":54,\"x\":120,\"y\":99,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BUKDXBSGHV\",\"page\":1,\"spuid\":\"BUKDXBSGHV\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"Macro Agente:\",\"w\":111,\"x\":8,\"y\":103,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_QJZAQQCYWJ\",\"page\":1,\"spuid\":\"QJZAQQCYWJ\",\"tabindex\":23,\"type\":\"Label\",\"w\":504,\"x\":200,\"y\":103,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAB Bancario\",\"h\":20,\"maxlength\":6,\"name\":\"CAB2\",\"page\":1,\"spuid\":\"IOZYXJKYDX\",\"tabindex\":77,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":800,\"y\":99,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LJFDSMRYHQ\",\"page\":1,\"spuid\":\"LJFDSMRYHQ\",\"tabindex\":78,\"type\":\"Label\",\"value\":\"CAB Bancario:\",\"w\":88,\"x\":712,\"y\":103,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Agenzia Attiva (S\\/N)\",\"h\":21,\"label_text\":\"Agenzia Attiva\",\"maxlength\":1,\"name\":\"FLGATT\",\"page\":1,\"spuid\":\"ECKDLHTTSN\",\"tabindex\":43,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":112,\"x\":960,\"y\":18,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"DatiAdd\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Aggiuntivi Agenzia\",\"groupName\":\"Dati\",\"h\":99,\"name\":\"DatiAdd\",\"page\":1,\"shrinkable\":true,\"spuid\":\"OQJXMMCZQK\",\"stretch\":true,\"tabindex\":2,\"title_caption\":\"Dati Aggiuntivi Agenzia\",\"titled\":true,\"type\":\"Box\",\"w\":1072,\"x\":8,\"y\":234,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ID Terrminale\",\"h\":20,\"maxlength\":15,\"name\":\"TERMINALID\",\"page\":1,\"spuid\":\"RTLSPZPWWO\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":496,\"y\":243,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WRCFGXMASK\",\"page\":1,\"spuid\":\"WRCFGXMASK\",\"tabindex\":21,\"type\":\"Label\",\"value\":\"ID Terrminale:\",\"w\":111,\"x\":384,\"y\":247,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CGO Codice Interno\",\"h\":20,\"maxlength\":10,\"name\":\"IDBASE\",\"page\":1,\"spuid\":\"WTENUNIUCY\",\"tabindex\":24,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":104,\"x\":496,\"y\":270,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FOXBQNQVXR\",\"page\":1,\"spuid\":\"FOXBQNQVXR\",\"tabindex\":25,\"type\":\"Label\",\"value\":\"CGO Codice Interno:\",\"w\":176,\"x\":320,\"y\":274,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Concessione\",\"h\":20,\"maxlength\":10,\"name\":\"CONCESSIONE\",\"page\":1,\"spuid\":\"JJJFDTJFAK\",\"tabindex\":81,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":88,\"x\":752,\"y\":270,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BGLJJMTOYA\",\"page\":1,\"spuid\":\"BGLJJMTOYA\",\"tabindex\":82,\"type\":\"Label\",\"value\":\"Concessione:\",\"w\":144,\"x\":608,\"y\":274,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Dipendenza WU\",\"h\":20,\"maxlength\":10,\"name\":\"AGACCODE\",\"page\":1,\"spuid\":\"NISBFWYVAN\",\"tabindex\":32,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":120,\"y\":243,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ECJVBPLVAM\",\"page\":1,\"spuid\":\"ECJVBPLVAM\",\"tabindex\":33,\"type\":\"Label\",\"value\":\"Codice Interno:\",\"w\":111,\"x\":8,\"y\":247,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Locale (CGO)\",\"h\":20,\"maxlength\":25,\"name\":\"CODLOC\",\"page\":1,\"spuid\":\"DUZIXALHHS\",\"tabindex\":45,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":162,\"x\":496,\"y\":297,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KPEKMJMQUX\",\"page\":1,\"spuid\":\"KPEKMJMQUX\",\"tabindex\":46,\"type\":\"Label\",\"value\":\"Codice Locale (CGO):\",\"w\":135,\"x\":360,\"y\":301,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice AGENTE\",\"h\":20,\"maxlength\":15,\"name\":\"CODAGE\",\"page\":1,\"spuid\":\"MOQMJLJJNI\",\"tabindex\":47,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":112,\"x\":120,\"y\":270,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MRGPZXPZJX\",\"page\":1,\"spuid\":\"MRGPZXPZJX\",\"tabindex\":48,\"type\":\"Label\",\"value\":\"Codice AGENTE:\",\"w\":176,\"x\":-56,\"y\":274,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Escludi Controlli AUA\",\"h\":21,\"label_text\":\"Escludi Controlli AUA\",\"maxlength\":1,\"name\":\"FLGNOAUA\",\"page\":1,\"spuid\":\"NPJMZHJDRZ\",\"tabindex\":52,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":136,\"x\":928,\"y\":243,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Flag WUPOS\",\"h\":21,\"label_text\":\"WUPOS Attivo\",\"maxlength\":1,\"name\":\"FLGWUPOS\",\"page\":1,\"spuid\":\"PNZMYOKETI\",\"tabindex\":53,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":144,\"x\":752,\"y\":243,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice AAMS Sala\",\"h\":20,\"maxlength\":12,\"name\":\"CODICEAAMS\",\"page\":1,\"spuid\":\"VYZSOTTSWB\",\"tabindex\":79,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":96,\"x\":120,\"y\":297,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XKQHBHHNKD\",\"page\":1,\"spuid\":\"XKQHBHHNKD\",\"tabindex\":80,\"type\":\"Label\",\"value\":\"Codice AAMS Sala:\",\"w\":176,\"x\":-56,\"y\":301,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Dati SARA\\/SV\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati aggiuntivi per SOS\\/SARA\\/SV\",\"groupName\":\"Dati\",\"h\":81,\"name\":\"Dati SARA\\/SV\",\"page\":1,\"shrinkable\":true,\"spuid\":\"SJOTYLCKUC\",\"stretch\":true,\"tabindex\":89,\"title_caption\":\"Dati aggiuntivi per SOS\\/SARA\\/SV\",\"titled\":true,\"type\":\"Box\",\"w\":1072,\"x\":8,\"y\":144,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ABI CAB Dipendenza per SARA\",\"h\":20,\"maxlength\":12,\"name\":\"ABICABSARA\",\"page\":1,\"spuid\":\"YTCIMOKXKS\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":88,\"x\":680,\"y\":162,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LRAFMUSNIS\",\"page\":1,\"spuid\":\"LRAFMUSNIS\",\"tabindex\":30,\"type\":\"Label\",\"value\":\"ABI CAB Dipendenza per SARA:\",\"w\":176,\"x\":504,\"y\":166,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Canale Distributivo (SV)\",\"h\":20,\"maxlength\":3,\"name\":\"TIPOSV\",\"page\":1,\"spuid\":\"LYZAJWZGAM\",\"tabindex\":50,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":384,\"x\":120,\"y\":162,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EXFKQPWTSQ\",\"page\":1,\"spuid\":\"EXFKQPWTSQ\",\"tabindex\":51,\"type\":\"Label\",\"value\":\"Canale Distributivo:\",\"w\":111,\"x\":8,\"y\":166,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Fiscale\",\"h\":20,\"maxlength\":16,\"name\":\"CODFISC\",\"page\":1,\"spuid\":\"ACTQHMCVYK\",\"tabindex\":83,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":128,\"x\":416,\"y\":189,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LLXHZULQLI\",\"page\":1,\"spuid\":\"LLXHZULQLI\",\"tabindex\":84,\"type\":\"Label\",\"value\":\"Codice Fiscale:\",\"w\":104,\"x\":312,\"y\":193,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Partita IVA\",\"h\":20,\"maxlength\":11,\"name\":\"PARTIVA\",\"page\":1,\"spuid\":\"RTWJYVXECF\",\"tabindex\":85,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":96,\"x\":664,\"y\":189,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FDEKGGVCSR\",\"page\":1,\"spuid\":\"FDEKGGVCSR\",\"tabindex\":86,\"type\":\"Label\",\"value\":\"Partita IVA:\",\"w\":120,\"x\":544,\"y\":193,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Agente\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":2,\"name\":\"TIPOAGENTE\",\"page\":1,\"spuid\":\"ACDLDQVQXS\",\"tabindex\":87,\"textlist\":\"Persona fisica,Persona Giuridica\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"PF"+"'"+","+"'"+"PG"+"'"+"\",\"w\":184,\"x\":120,\"y\":189,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZMFFOLWFAF\",\"page\":1,\"spuid\":\"ZMFFOLWFAF\",\"tabindex\":88,\"type\":\"Label\",\"value\":\"Tipo Agente:\",\"w\":104,\"x\":16,\"y\":193,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Rischio\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Valori per Rischio\",\"groupName\":\"Dati\",\"h\":198,\"name\":\"Rischio\",\"page\":1,\"shrinkable\":true,\"spuid\":\"RFAIYHSGII\",\"stretch\":true,\"tabindex\":55,\"title_caption\":\"Valori per Rischio\",\"titled\":true,\"type\":\"Box\",\"w\":1072,\"x\":8,\"y\":342,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Nazionalit\\u00E0 Agente\",\"h\":20,\"maxlength\":3,\"name\":\"NAZAGENTE\",\"page\":1,\"picker\":true,\"spuid\":\"SGDAQGMTNU\",\"tabindex\":34,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":120,\"y\":486,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SARKHBDBSW\",\"page\":1,\"spuid\":\"SARKHBDBSW\",\"tabindex\":35,\"type\":\"Label\",\"value\":\"Nazionalit\\u00E0 Agente:\",\"w\":111,\"x\":8,\"y\":490,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_VNMKJRVPPS\",\"page\":1,\"spuid\":\"VNMKJRVPPS\",\"tabindex\":36,\"type\":\"Label\",\"w\":384,\"x\":192,\"y\":490,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_NRWNAJJVRA\",\"page\":1,\"spuid\":\"NRWNAJJVRA\",\"tabindex\":56,\"type\":\"Label\",\"w\":488,\"x\":176,\"y\":355,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WWRYOVTMFY\",\"page\":1,\"spuid\":\"WWRYOVTMFY\",\"tabindex\":57,\"type\":\"Label\",\"value\":\"Categoria 1:\",\"w\":104,\"x\":16,\"y\":355,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_LNOFOPAOYD\",\"page\":1,\"spuid\":\"LNOFOPAOYD\",\"tabindex\":58,\"type\":\"Label\",\"w\":488,\"x\":176,\"y\":382,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HNQZARYXGS\",\"page\":1,\"spuid\":\"HNQZARYXGS\",\"tabindex\":59,\"type\":\"Label\",\"value\":\"Categoria 2:\",\"w\":104,\"x\":16,\"y\":382,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_WBTKNDJDFF\",\"page\":1,\"spuid\":\"WBTKNDJDFF\",\"tabindex\":60,\"type\":\"Label\",\"w\":488,\"x\":176,\"y\":409,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BGEVFUGGOS\",\"page\":1,\"spuid\":\"BGEVFUGGOS\",\"tabindex\":61,\"type\":\"Label\",\"value\":\"Categoria 3:\",\"w\":104,\"x\":16,\"y\":409,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Categoria 1\",\"h\":20,\"maxlength\":2,\"name\":\"CATEG04\",\"page\":1,\"picker\":true,\"spuid\":\"JQLGHMLOKO\",\"tabindex\":62,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":120,\"y\":432,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_MWCFKQVNHF\",\"page\":1,\"spuid\":\"MWCFKQVNHF\",\"tabindex\":63,\"type\":\"Label\",\"w\":488,\"x\":176,\"y\":436,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RHXCIUHRTU\",\"page\":1,\"spuid\":\"RHXCIUHRTU\",\"tabindex\":64,\"type\":\"Label\",\"value\":\"Categoria 4:\",\"w\":104,\"x\":16,\"y\":436,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Categoria 1\",\"h\":20,\"maxlength\":2,\"name\":\"CATEG05\",\"page\":1,\"picker\":true,\"spuid\":\"QVBZSFMTVP\",\"tabindex\":65,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":120,\"y\":459,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_HADVHTQAPE\",\"page\":1,\"spuid\":\"HADVHTQAPE\",\"tabindex\":66,\"type\":\"Label\",\"w\":488,\"x\":176,\"y\":463,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GRCYFEKJWU\",\"page\":1,\"spuid\":\"GRCYFEKJWU\",\"tabindex\":67,\"type\":\"Label\",\"value\":\"Categoria 5:\",\"w\":104,\"x\":16,\"y\":463,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Categoria 1\",\"h\":20,\"maxlength\":2,\"name\":\"CATEG01\",\"page\":1,\"picker\":true,\"spuid\":\"ICGUZGYXTD\",\"tabindex\":74,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":120,\"y\":351,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Categoria 2\",\"h\":20,\"maxlength\":2,\"name\":\"CATEG02\",\"page\":1,\"picker\":true,\"spuid\":\"TGQHYPERED\",\"tabindex\":75,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":120,\"y\":378,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Categoria 3\",\"h\":20,\"maxlength\":2,\"name\":\"CATEG03\",\"page\":1,\"picker\":true,\"spuid\":\"QRJNKZVHDW\",\"tabindex\":76,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":120,\"y\":405,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Regione\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":2,\"name\":\"AGEREGIO\",\"page\":1,\"spuid\":\"KSBCZELDDB\",\"tabindex\":42,\"textlist\":\"Abruzzo,Basilicata,Calabria,Campania,Emilia-Romagna,Friuli-Venezia Giulia,Lazio,Liguria,Lombardia,Marche,Molise,Piemonte,Puglia,Sardegna,Sicilia,Toscana,Trentino-Alto Adige,Umbria,Valle d"+"'"+"Aosta,Veneto\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"01"+"'"+","+"'"+"02"+"'"+","+"'"+"03"+"'"+","+"'"+"04"+"'"+","+"'"+"05"+"'"+","+"'"+"06"+"'"+","+"'"+"07"+"'"+","+"'"+"08"+"'"+","+"'"+"09"+"'"+","+"'"+"10"+"'"+","+"'"+"11"+"'"+","+"'"+"12"+"'"+","+"'"+"13"+"'"+","+"'"+"14"+"'"+","+"'"+"15"+"'"+","+"'"+"16"+"'"+","+"'"+"17"+"'"+","+"'"+"18"+"'"+","+"'"+"19"+"'"+","+"'"+"20"+"'"+"\",\"w\":216,\"x\":120,\"y\":513,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SFACPNQMFC\",\"page\":1,\"spuid\":\"SFACPNQMFC\",\"tabindex\":44,\"type\":\"Label\",\"value\":\"Regione:\",\"w\":111,\"x\":8,\"y\":517,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Preposti\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Soggetti Preposti (Comunicazione Soggetti Convenzionati OAM)\",\"groupName\":\"Dati\",\"h\":198,\"name\":\"Preposti\",\"page\":1,\"shrinkable\":true,\"spuid\":\"DKPWIMNYIB\",\"stretch\":true,\"tabindex\":91,\"title_caption\":\"Soggetti Preposti (Comunicazione Soggetti Convenzionati OAM)\",\"titled\":true,\"type\":\"Box\",\"w\":1072,\"x\":8,\"y\":549,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":150,\"name\":\"ardt_dippreposti\",\"page\":1,\"spuid\":\"ZBFNRFHLSE\",\"tabindex\":90,\"type\":\"Iframe\",\"w\":1051,\"x\":16,\"y\":585,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Inizio Mandato\",\"h\":20,\"maxlength\":10,\"name\":\"DATAINI\",\"page\":1,\"picker\":true,\"spuid\":\"OSJJWSZMDE\",\"tabindex\":96,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":152,\"y\":559,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MDCCDZNMIV\",\"page\":1,\"spuid\":\"MDCCDZNMIV\",\"tabindex\":97,\"type\":\"Label\",\"value\":\"Data Inizio Mandato:\",\"w\":136,\"x\":16,\"y\":563,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Fine Mandato\",\"h\":20,\"maxlength\":10,\"name\":\"DATAFINE\",\"page\":1,\"picker\":true,\"spuid\":\"QDGOPSCQNI\",\"tabindex\":98,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":376,\"y\":559,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XHVKTYTVYI\",\"page\":1,\"spuid\":\"XHVKTYTVYI\",\"tabindex\":99,\"type\":\"Label\",\"value\":\"Data Fine Mandato:\",\"w\":136,\"x\":240,\"y\":563,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Chiusura per compliance\",\"h\":21,\"label_text\":\"Chiusura per compliance\",\"maxlength\":2,\"name\":\"FLGCOMPL\",\"page\":1,\"spuid\":\"DVNRBUBGST\",\"tabindex\":103,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":176,\"x\":496,\"y\":558,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Servizi Rimessa Denaro (S\\/N)\",\"h\":21,\"label_text\":\"Servizi di rimessa in denaro\",\"maxlength\":1,\"name\":\"SERRIMDEN\",\"page\":1,\"spuid\":\"VKYZPROJCI\",\"tabindex\":94,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":208,\"x\":856,\"y\":558,\"zone\":\"pag1_5_2\",\"zonepath\":\"[1,5,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_anadipBO BO,ServletStatus status) {
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
     "<script src='armt_anadip?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_anadip_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_anadip_edit.js'>" +
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
      status.out.println("w_CODDIP=a[0];");
      status.out.println("w_DESCRIZ=a[1];");
      status.out.println("w_DOMICILIO=a[2];");
      status.out.println("w_CAP=a[3];");
      status.out.println("w_IDCITTA=a[4];");
      status.out.println("w_DESCCIT=a[5];");
      status.out.println("w_PROVINCIA=a[6];");
      status.out.println("w_CAB=a[7];");
      status.out.println("w_AGENTE=a[8];");
      status.out.println("w_MACROAGENTE=a[9];");
      status.out.println("w_TERMINALID=a[10];");
      status.out.println("w_IDBASE=a[11];");
      status.out.println("w_TELEFONO=a[12];");
      status.out.println("w_ABICABSARA=a[13];");
      status.out.println("w_AGACCODE=a[14];");
      status.out.println("w_NAZAGENTE=a[15];");
      status.out.println("w_VALCOMPL=a[16];");
      status.out.println("w_ANOMOPER=a[17];");
      status.out.println("w_OPXSOSCLI=a[18];");
      status.out.println("w_OPXSOSAGE=a[19];");
      status.out.println("w_AGEREGIO=a[20];");
      status.out.println("w_FLGATT=a[21];");
      status.out.println("w_CODLOC=a[22];");
      status.out.println("w_CODAGE=a[23];");
      status.out.println("w_TIPOSV=a[24];");
      status.out.println("w_FLGNOAUA=a[25];");
      status.out.println("w_FLGWUPOS=a[26];");
      status.out.println("w_CATEG04=a[27];");
      status.out.println("w_CATEG05=a[28];");
      status.out.println("w_CATEGORIA=a[29];");
      status.out.println("w_CATEG01=a[30];");
      status.out.println("w_CATEG02=a[31];");
      status.out.println("w_CATEG03=a[32];");
      status.out.println("w_CAB2=a[33];");
      status.out.println("w_CODICEAAMS=a[34];");
      status.out.println("w_CONCESSIONE=a[35];");
      status.out.println("w_CODFISC=a[36];");
      status.out.println("w_PARTIVA=a[37];");
      status.out.println("w_TIPOAGENTE=a[38];");
      status.out.println("w_NUMCIVICO=a[39];");
      status.out.println("w_SERRIMDEN=a[40];");
      status.out.println("w_DATAINI=a[41];");
      status.out.println("w_DATAFINE=a[42];");
      status.out.println("w_FLGCOMPL=a[43];");
      status.out.println("w_gFlgWU=a[44];");
      status.out.println("w_xMADESCRI=a[45];");
      status.out.println("w_xDESCNAZ=a[46];");
      status.out.println("w_gAgeCGO=a[47];");
      status.out.println("w_tipocat=a[48];");
      status.out.println("w_xC1DESCRI=a[49];");
      status.out.println("w_xC2DESCRI=a[50];");
      status.out.println("w_xC3DESCRI=a[51];");
      status.out.println("w_xC4DESCRI=a[52];");
      status.out.println("w_xC5DESCRI=a[53];");
      status.out.println("w_gTipInter=a[54];");
      status.out.println("w_xDESCAN=a[55];");
      status.out.println("w_xMACOGNOME=a[56];");
      status.out.println("w_xMANOME=a[57];");
      status.out.println("m_cWv_ardt_dippreposti=a[58];");
      status.out.println("if (Gt(a.length,59)) {");
      status.out.println("m_cErrorInChild='';");
      status.out.println("}");
      status.out.println("if (Gt(a.length,59)) {");
      status.out.println("o_IDCITTA=w_IDCITTA;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['CODDIP'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_anadip_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(357,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","anadip");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","CODDIP");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(armt_anadipBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({CODDIP:"+SPLib.ToJSValue(BO.w_CODDIP,"C",6,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_anadipBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({CODDIP:"+SPLib.ToJSValue(BO.w_CODDIP,"C",6,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armt_anadipBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({CODDIP:"+SPLib.ToJSValue(BO.w_CODDIP,"C",6,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armt_anadipBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({CODDIP:"+SPLib.ToJSValue(BO.w_CODDIP,"C",6,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armt_anadipBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({CODDIP:"+SPLib.ToJSValue(BO.w_CODDIP,"C",6,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_anadipBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_anadipBO BO,ServletStatus status) throws IOException {
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
      CPLib.AddToSet(callable,"ardt_dippreposti");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_anadipBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_CODDIP),"C",6,0));
      }
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gFlgWU),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gAgeCGO),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gTipInter),"C",2,0));
    } else if (CPLib.eq(p_cUID,"CZGVBAYWKP")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"AEZUFOYHTM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"BPQQBVFABO")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SGDAQGMTNU")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"JQLGHMLOKO")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"QVBZSFMTVP")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ICGUZGYXTD")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"TGQHYPERED")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"QRJNKZVHDW")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_anadipBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_IDCITTA))) {
        a = GetCheckVars(status,BO,"CZGVBAYWKP");
        b = status.m_CheckVars.optString("CZGVBAYWKP");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DESCCIT))) {
        a = GetCheckVars(status,BO,"AEZUFOYHTM");
        b = status.m_CheckVars.optString("AEZUFOYHTM");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_MACROAGENTE))) {
        a = GetCheckVars(status,BO,"BPQQBVFABO");
        b = status.m_CheckVars.optString("BPQQBVFABO");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_NAZAGENTE))) {
        a = GetCheckVars(status,BO,"SGDAQGMTNU");
        b = status.m_CheckVars.optString("SGDAQGMTNU");
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
      if (result &&  ! (CPLib.Empty(BO.w_CATEG01))) {
        a = GetCheckVars(status,BO,"ICGUZGYXTD");
        b = status.m_CheckVars.optString("ICGUZGYXTD");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CATEG02))) {
        a = GetCheckVars(status,BO,"TGQHYPERED");
        b = status.m_CheckVars.optString("TGQHYPERED");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CATEG03))) {
        a = GetCheckVars(status,BO,"QRJNKZVHDW");
        b = status.m_CheckVars.optString("QRJNKZVHDW");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
