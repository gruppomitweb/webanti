import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_informazioni extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*412865f2*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "rapopebo";
    }
    public String w_IDBASE;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_IDBASE,context,"rapopebo","IDBASE","C",10,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='IDBASE' type='hidden' value="+SPLib.ToHTMLValue(w_IDBASE,"C",10,0)+">" +
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
    armt_informazioniBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_rapopebo;
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
      status.w_IDBASE = BO.w_IDBASE;
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
    return "Informazioni su rapporti (A.U.I.)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_informazioni";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 909;
    l_eg.m_nEntityHeight = 1072;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"rapopebo","intermbo","anadip","anarapbo","tbtipreg","personbo","tbtipleg"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","Dati","page"),new ZoneItem("page_2","Altri Soggetti","page"),new ZoneItem("Intermediario","Intermediario/Dipendenza","horizontal_section"),new ZoneItem("DATIBASE","DATI BASE","horizontal_section"),new ZoneItem("INTESTATARI","INTESTATARI","horizontal_section"),new ZoneItem("DELEGATI","DELEGATI","horizontal_section"),new ZoneItem("DATIRET","Dati Rettifiche (A54)","horizontal_section"),new ZoneItem("ALTRISOGG","Altri Soggetti Operanti","collapsible"),new ZoneItem("TITOLARI","Altri Titolari Effetti","collapsible"),new ZoneItem("Intermediario","Intermediario/Dipendenza","horizontal_section"),new ZoneItem("FIDUCIANTI","Fiducianti","collapsible")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"IDBASE"};
    l_eg.items = new SPItem[]{
                   new SPItem("gIntemediario","C",11,0, "hide","Intermediario"),
                   new SPItem("gSblocco","C",1,0, "hide","Sblocco controllo"),
                   new SPItem("gFlgDTP","N",1,0, "hide","Forza Data Trasferimento Provvisorie"),
                   new SPItem("gChkDate","C",1,0, "hide","Controllo Date"),
                   new SPItem("gStatus","C",4,0, "hide","Stato Operazione"),
                   new SPItem("gDataVaria","D",8,0, "hide","Data Variazione"),
                   new SPItem("gFlgDTP","N",1,0, "hide","Forza Data Trasferimento Provvisorie"),
                   new SPItem("gCodDip","C",6,0, "hide","Dipendenza"),
                   new SPItem("filtro","C",1,0, "hide",""),
                   new SPItem("dataoggi","D",8,0, "hide",""),
                   new SPItem("tipreg","C",1,0, "hide","Operazione/Rapporto"),
                   new SPItem("tipregn","N",1,0, "hide","Operazione/Rapporto"),
                   new SPItem("CDATOPE","C",8,0, "hide","Data Operazione (Letterale)"),
                   new SPItem("CDATREG","C",8,0, "hide","Data Registrazione in carattere"),
                   new SPItem("sEdit","N",1,0, "hide",""),
                   new SPItem("CODINTER","C",11,0, "show","Codice Intermediario"),
                   new SPItem("CODDIPE","C",6,0, "edit","Codice Dipendenza"),
                   new SPItem("RAPPORTO","C",25,0, "edit",""),
                   new SPItem("DATAOPE","D",8,0, "edit","Data Operazione"),
                   new SPItem("DATAREG","D",8,0, "edit","Data registrazione"),
                   new SPItem("TIPOOPRAP","C",2,0, "edit","Tipo Informazione"),
                   new SPItem("CONNESOPER","C",16,0, "edit","Soggetto Operante Conto Terzi"),
                   new SPItem("TIPOLEG","C",1,0, "edit","Tipo Legame Sogg."),
                   new SPItem("IDBASE","C",10,0, "hide","idbase"),
                   new SPItem("TIPOINTER","C",2,0, "hide",""),
                   new SPItem("TIPOINF","C",1,0, "hide",""),
                   new SPItem("IDEREG","C",20,0, "hide",""),
                   new SPItem("FLAGRAP","C",1,0, "hide",""),
                   new SPItem("OPRAP","C",1,0, "hide",""),
                   new SPItem("OPERATORE","C",70,0, "hide",""),
                   new SPItem("AUTOM","C",5,0, "hide",""),
                   new SPItem("DESCCIT","C",30,0, "show","Città Dipendenza"),
                   new SPItem("PROVINCIA","C",2,0, "show","Provincia Dipendenza"),
                   new SPItem("CODCAB","C",6,0, "show","CAB Dipendenza"),
                   new SPItem("NUMPROG","C",11,0, "show","Numero Progressivo"),
                   new SPItem("xdescrap","C",50,0, "hide","Descrizione"),
                   new SPItem("xDescDipe","C",30,0, "hide","Descrizione"),
                   new SPItem("datpaseuro","D",8,0, "hide","Data Passaggio EURO"),
                   new SPItem("xDesReg","C",90,0, "hide","Descrizione"),
                   new SPItem("xRagSoc","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("errmsg","C",100,0, "hide",""),
                   new SPItem("Aggiorna","C",1,0, "hide",""),
                   new SPItem("FLAGRAP2","C",1,0, "hide",""),
                   new SPItem("lancio","N",10,0, "hide",""),
                   new SPItem("FLAGLIRE","C",1,0, "hide",""),
                   new SPItem("VALUTA","C",3,0, "hide","Codice Divisa"),
                   new SPItem("PRGIMPINF","N",15,0, "hide","Progressivo Importo"),
                   new SPItem("CITINT","C",30,0, "hide","Città"),
                   new SPItem("CITDIP","C",30,0, "hide","Città"),
                   new SPItem("PROVDIP","C",2,0, "hide","Provincia"),
                   new SPItem("CABDIP","C",6,0, "hide","CAB"),
                   new SPItem("PROVINT","C",2,0, "hide","Provincia"),
                   new SPItem("CABINT","C",6,0, "hide","CAB"),
                   new SPItem("IDEREG","C",20,0, "show","ID Registrazione"),
                   new SPItem("OPERAZMOD","C",20,0, "hide","Operazione Modificata"),
                   new SPItem("IDBASE2","C",10,0, "hide","Gestione IDEREG"),
                   new SPItem("inutile","N",10,0, "hide",""),
                   new SPItem("DATARETT","D",8,0, "edit","Data Rettifica"),
                   new SPItem("STATOREG","C",1,0, "edit","Stato"),
                   new SPItem("OPERAZMOD","C",20,0, "show","Operazione Modificata"),
                   new SPItem("prova","C",70,0, "hide",""),
                   new SPItem("closeall","C",1,0, "edit",""),
                   new SPItem("CODINTER","C",11,0, "show",""),
                   new SPItem("CODDIPE","C",6,0, "show",""),
                   new SPItem("DESCCIT","C",30,0, "show",""),
                   new SPItem("PROVINCIA","C",2,0, "show",""),
                   new SPItem("CODCAB","C",6,0, "show",""),
                   new SPItem("FLAGTIT","N",1,0, "edit","Flag Somma Titolari")
                 };
    l_eg.m_lHasHistorical = false;
    return l_eg;
  }
  ArrayList<org.json.JSONArray> i_sidebarItems = null;
  public org.json.JSONArray getSidebarItems(int p_nPage) {
    if (CPLib.IsNull(i_sidebarItems)) {
      i_sidebarItems = InitializeSidebarItemsArray(2);
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_informazioniBO BO) {
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
      i_contextmenu = InitializeContextMenuArray(2);
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
    l_translations=new String[][]{{"10082410841",p_Context.Translate("La differenza tra Data Operazione e Data Registrazione non deve superare i 30 gg")},
    {"1008789486",p_Context.Translate("Forza Data Trasferimento Provvisorie")},
    {"10095365423",p_Context.Translate("Provincia")},
    {"10220423475",p_Context.Translate("Data Variazione")},
    {"1028598955",p_Context.Translate("Data registrazione")},
    {"10505367639",p_Context.Translate("Persone / Società / Legali Rappresentanti")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"10701632044",p_Context.Translate("Rapporti in essere")},
    {"10848850431",p_Context.Translate("CAB Dipendenza")},
    {"10932226881",p_Context.Translate("Operazione/Rapporto")},
    {"11058877460",p_Context.Translate("'%ERRORMESSAGE%'")},
    {"11133577011",p_Context.Translate("Informazioni su rapporti (A.U.I.)")},
    {"11170705286",p_Context.Translate("Data Operazione (Letterale)")},
    {"11205021885",p_Context.Translate("Tipo Legame Sogg.")},
    {"11316624286",p_Context.Translate("Codice Intermediario")},
    {"11329559720",p_Context.Translate("Data Rettifica")},
    {"11356972522",p_Context.Translate("Provincia Dipendenza")},
    {"113866921",p_Context.Translate("idbase")},
    {"11396780126",p_Context.Translate("Intermediario")},
    {"11459349451",p_Context.Translate("Sblocco controllo")},
    {"1148775685",p_Context.Translate("%1")},
    {"11525797640",p_Context.Translate("%ERRORMESSAGE%")},
    {"11755647652",p_Context.Translate("Soggetto Operante Conto Terzi")},
    {"11823569485",p_Context.Translate("Comprendere anche titolari intestatario rapporto in estrazione scarico Ministeriale")},
    {"1215050295",p_Context.Translate("%1")},
    {"1270140254",p_Context.Translate("Dipendenza")},
    {"1270140318",p_Context.Translate("Dipendenze")},
    {"15186643",p_Context.Translate("Città")},
    {"1639410703",p_Context.Translate("Impossibile modificare un'operazione già cancellata o copia di modifica")},
    {"1698385181",p_Context.Translate("ID Registrazione")},
    {"1730321404",p_Context.Translate("Codice Divisa")},
    {"1748201363",p_Context.Translate("Città Dipendenza")},
    {"18003",p_Context.Translate("CAB")},
    {"181237054",p_Context.Translate("Impossibile cancellare un'operazione già cancellata o copia di modifica")},
    {"2021191611",p_Context.Translate("La data di registrazione deve essere maggiore o uguale a quella dell'informazione")},
    {"2063970052",p_Context.Translate("Flag Somma Titolari")},
    {"2071283709",p_Context.Translate("Codice Dipendenza")},
    {"226933836",p_Context.Translate("Data Passaggio EURO")},
    {"283431915",p_Context.Translate("Progressivo Importo")},
    {"285692487",p_Context.Translate("Gestione IDEREG")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"340709450",p_Context.Translate("%1")},
    {"383234328",p_Context.Translate("Stato Operazione")},
    {"491820845",p_Context.Translate("Data Registrazione in carattere")},
    {"684190680",p_Context.Translate("Tipo Informazione")},
    {"7776403",p_Context.Translate("Stato")},
    {"824519334",p_Context.Translate("Operazione Modificata")},
    {"829201110",p_Context.Translate("Data Operazione")},
    {"839211622",p_Context.Translate("Numero Progressivo")},
    {"976489378",p_Context.Translate("Controllo Date")},
    {"995100987",p_Context.Translate("Tipo Registrazione")}};
    return l_translations;
  }
  void WriteStyles(armt_informazioniBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_informazioni.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_informazioniBO BO,ServletStatus status) {
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
    status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati"),"C",0,0)+"},{name:\"page_2\", element:\"page_2\", caption:"+SPLib.ToJSValue(status.context.Translate("Altri Soggetti"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
    status.out.println("Z.Tabs.Set('tabs',tabs);");
    status.out.println("} else {");
    status.out.println("var tabs = Z.Tabs.Get('tabs')");
    status.out.println("}");
    AddExtendedTabs(status);
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_informazioni',false);");
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_informazioni",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(armt_informazioniBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    WriteControls_p2(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,3);
  }
  void WriteControls_p1(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:1072px;width:909px;display:none'>" +
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
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"Dati");
    PrintSidebarContent(1,status,getSidebarItems(0),true);
    PrintContextMenu(1,status,getContextMenu(0),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_2' class='PageContainer' style='position:relative;height:477px;width:909px;display:none'>" +
    "");
    WriteControls_p2_b0(BO,status);
    WriteControls_p2_b1(BO,status);
    WriteControls_p2_b2(BO,status);
    WriteControls_p2_b3(BO,status);
    WriteControls_p2_b4(BO,status);
    WriteControls_p2_b5(BO,status);
    WriteControls_p2_b6(BO,status);
    WriteControls_p2_b7(BO,status);
    WriteControls_p2_b8(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,2,"Altri Soggetti");
    PrintSidebarContent(2,status,getSidebarItems(1),true);
    PrintContextMenu(2,status,getContextMenu(1),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b0(armt_informazioniBO BO,ServletStatus status) {
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
  void WriteControls_p1_b1(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Intermediario' id='GSYOOIOWZF_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='GSYOOIOWZF_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='GSYOOIOWZF_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Intermediario/Dipendenza")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='GSYOOIOWZF_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"GSYOOIOWZF\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=GSYOOIOWZF_HEADER&m_cBoxId=GSYOOIOWZF&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Intermediario/Dipendenza"))+"");
    }
    status.out.println(
     "<div id='GSYOOIOWZF' class='SectionBody' style='position:relative;height:48px;display:block'>" +
    "");
    status.includeZoneAltInterface("Intermediario@BEGIN");
    if (status.includeZoneAltInterface("Intermediario")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Intermediario@BEGIN") || status.HasZoneAltInterface("Intermediario@END")) {
        status.out.println(
         "<div id='GSYOOIOWZF_boxContent' style='position:relative;height:48px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<input name='CODINTER' id='WJSVGWKSFC' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CODINTER,"C",11,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='11' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODDIPE' id='AVHTGZTOSZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODDIPE,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
       "<button id='AVHTGZTOSZ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "AVHTGZTOSZ", "anadip", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LOEAMXUYLA_DIV'>" +
       "<label id='LOEAMXUYLA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Intermediario:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='DESCCIT' id='RLUMBFHPUD' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DESCCIT,"C",30,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='PROVINCIA' id='OJGQABFSYN' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_PROVINCIA,"C",2,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='CODCAB' id='OZEOCQRSEQ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CODCAB,"C",6,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='6' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XVRJYSKGWZ_DIV'>" +
       "<label id='XVRJYSKGWZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Dipen.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CTLYJMTHDV_DIV'>" +
       "<label id='CTLYJMTHDV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Città:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JWSDOSRGAG_DIV'>" +
       "<label id='JWSDOSRGAG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Pr.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ENBRMMDVUP_DIV'>" +
       "<label id='ENBRMMDVUP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAB:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BLXOBUQVYE_DIV'>" +
       "<label id='BLXOBUQVYE'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xDescDipe)+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Intermediario@BEGIN") || status.HasZoneAltInterface("Intermediario@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b1_CloseBand(armt_informazioniBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Intermediario@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Intermediario")) {
      status.out.println("Ctrl('GSYOOIOWZF').style.height='auto';");
    } else {
      status.out.println("Ctrl('GSYOOIOWZF').setAttribute('band_height',48);");
    }
    status.out.println("Ctrl('GSYOOIOWZF').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_informazioniBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_YORQOIOBQN")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_YORQOIOBQN' style='position:relative;height:1px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_YORQOIOBQN")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_YORQOIOBQN').style.height='auto';");
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
  void WriteControls_p1_b3(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div name='DATIBASE' id='YORQOIOBQN_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='YORQOIOBQN_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='YORQOIOBQN_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("DATI BASE")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='YORQOIOBQN_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"YORQOIOBQN\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=YORQOIOBQN_HEADER&m_cBoxId=YORQOIOBQN&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("DATI BASE"))+"");
    }
    status.out.println(
     "<div id='YORQOIOBQN' class='SectionBody' style='position:relative;height:168px;display:block'>" +
    "");
    status.includeZoneAltInterface("DATIBASE@BEGIN");
    if (status.includeZoneAltInterface("DATIBASE")) {
      WriteControls_p1_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("DATIBASE@BEGIN") || status.HasZoneAltInterface("DATIBASE@END")) {
        status.out.println(
         "<div id='YORQOIOBQN_boxContent' style='position:relative;height:168px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RAPPORTO' id='UMFEJVRUFZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RAPPORTO,"C",25,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
       "<button id='UMFEJVRUFZ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "UMFEJVRUFZ", "anarapbo", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAOPE' id='YLIKFVPZJA' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_DATAOPE,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='YLIKFVPZJA_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAREG' id='OEIKQOZMYJ' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_DATAREG,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='OEIKQOZMYJ_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPOOPRAP' id='SWRTSKXMDH' class='"+status.ObligatoryClass("Combobox")+"' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_TIPOOPRAP),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CONNESOPER' id='SLTZSUMACW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONNESOPER,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C' style='display:none'>" +
       "<button id='SLTZSUMACW_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" style='display:none'>" +
       "</button>" +
       ""+EventuallyContextMenu(status, "SLTZSUMACW", "personbo", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPOLEG' id='MLPGOPNAKN' class='Combobox' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_TIPOLEG),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BYKQMDEEAQ_DIV'>" +
       "<label id='BYKQMDEEAQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Informazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='NUMPROG' id='XYMCLUECBD' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_NUMPROG,"C",11,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='11' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KDUGHGZUUG_DIV'>" +
       "<label id='KDUGHGZUUG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("N° Progressivo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='IKBMEWKQJW_DIV'>" +
       "<label id='IKBMEWKQJW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data registrazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HVHVAYPDJE_DIV'>" +
       "<label id='HVHVAYPDJE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Operazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WDSMYOZLJE_DIV'>" +
       "<label id='WDSMYOZLJE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Rapporto:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XXRYVYIIGY_DIV'>" +
       "<label id='XXRYVYIIGY'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdescrap)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XAWQKRVCSF_DIV' style='display:none'>" +
       "<label id='XAWQKRVCSF'>" +
       ""+SPLib.ToHTMLRepresentation("Tipo Legame Sogg.:")+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='QSDCLKKQSB_DIV' style='display:none'>" +
       "<label id='QSDCLKKQSB'>" +
       ""+SPLib.ToHTMLRepresentation((CPLib.lt(BO.w_DATAOPE,CPLib.CharToDate("20100601"))?"Soggetto Agente x conto:":(CPLib.gt(BO.w_DATAOPE,CPLib.CharToDate("20131231"))?"Esecutore:":"")))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YJYVIBZLQH_DIV' style='display:none'>" +
       "<label id='YJYVIBZLQH'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xRagSoc)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EFRNVTREYB_DIV' style='display:none'>" +
       "<label id='EFRNVTREYB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Soggetto non presente in anagrafica"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZKPQBQAUZR_DIV' style='display:none'>" +
       "<label id='ZKPQBQAUZR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("OPERAZIONE CANCELLATA"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GHJRKCKISV_DIV' style='display:none'>" +
       "<label id='GHJRKCKISV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("COPIA OPERAZIONE MODIFICATA"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='IDEREG' id='KHYCSRMDGJ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_IDEREG,"C",20,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='20' size='20' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NOCRBBFOUY_DIV'>" +
       "<label id='NOCRBBFOUY' for='KHYCSRMDGJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A03. ID Registrazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("DATIBASE@BEGIN") || status.HasZoneAltInterface("DATIBASE@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b3_CloseBand(armt_informazioniBO BO,ServletStatus status) {
    status.includeZoneAltInterface("DATIBASE@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("DATIBASE")) {
      status.out.println("Ctrl('YORQOIOBQN').style.height='auto';");
    } else {
      status.out.println("Ctrl('YORQOIOBQN').setAttribute('band_height',168);");
    }
    status.out.println("Ctrl('YORQOIOBQN').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b4(armt_informazioniBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_HOHRVXKGPC")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_HOHRVXKGPC' style='position:relative;height:1px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_HOHRVXKGPC")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_HOHRVXKGPC').style.height='auto';");
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
  void WriteControls_p1_b5(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div id='tabs_1_DETTAGLIO_container'>" +
     " " +
     "</div>" +
    "");
    status.out.println(
     "<div name='INTESTATARI' id='HOHRVXKGPC_DIV' class='BoxContainer SPSection_expanded TabStripBoxContainer' group_id='tabs_1_DETTAGLIO'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var tabs_1_DETTAGLIO = new Z.Tabs({container:'tabs_1_DETTAGLIO_container',useGlobals: false,boxtabs: true,useseparator:GetStyleVariable('boxTabUseSeparator',null,''),expandcollapse:GetStyleVariable('boxTabCanCollapse',null,''),contents:[],tabstrip_class: ''});");
    status.out.println("Z.Tabs.Set('tabs_1_DETTAGLIO',tabs_1_DETTAGLIO);");
    status.out.println("var l_nHOHRVXKGPCTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='HOHRVXKGPC' class='TabStripBoxBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("INTESTATARI@BEGIN");
    if (status.includeZoneAltInterface("INTESTATARI")) {
      WriteControls_p1_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("INTESTATARI@BEGIN") || status.HasZoneAltInterface("INTESTATARI@END")) {
        status.out.println(
         "<div id='HOHRVXKGPC_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p1_b5_b0(BO,status);
      WriteControls_p1_b5_b1(BO,status);
      WriteControls_p1_b5_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['HOHRVXKGPC']=['band_1_218','band_1_225','band_1_551'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("INTESTATARI@BEGIN") || status.HasZoneAltInterface("INTESTATARI@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b5_CloseBand(armt_informazioniBO BO,ServletStatus status) {
    status.includeZoneAltInterface("INTESTATARI@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('HOHRVXKGPC').setAttribute('status','open');");
    status.out.println("tabs_1_DETTAGLIO.AddTab({name:\"HOHRVXKGPC\", element:\"HOHRVXKGPC_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("INTESTATARI"),"C",0,0)+",tabIndex: l_nHOHRVXKGPCTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('HOHRVXKGPC',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('HOHRVXKGPC',false,true,false)}});");
    status.out.println("if (tabs_1_DETTAGLIO.CanCollapse()) {");
    status.out.println("tabs_1_DETTAGLIO.Expand('HOHRVXKGPC');");
    status.out.println("}");
    status.out.println("PageOpened.AppendReceiver('page_1',tabs_1_DETTAGLIO.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b5_b0(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_218' style='position:relative;height:7px;display:block' page='1'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b5_b1(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_225' style='position:relative;display:block' page='1'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='ardt_informazioni' id='ZFLICMSKTV' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='closeall' id='JGGDFBSZJB' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_closeall,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='1' size='1' fieldtype='C' style='display:none'>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_1_225']=['ZFLICMSKTV'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b5_b2(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_551' style='position:relative;height:17px;display:block' page='1'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b6(armt_informazioniBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_PUODKNEFWX")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_PUODKNEFWX' style='position:relative;height:8px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_PUODKNEFWX")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_PUODKNEFWX').style.height='auto';");
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
  void WriteControls_p1_b7(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div name='DELEGATI' id='PUODKNEFWX_DIV' class='BoxContainer SPSection_expanded TabStripBoxContainer' group_id='tabs_1_DETTAGLIO'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nPUODKNEFWXTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='PUODKNEFWX' class='TabStripBoxBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("DELEGATI@BEGIN");
    if (status.includeZoneAltInterface("DELEGATI")) {
      WriteControls_p1_b7_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("DELEGATI@BEGIN") || status.HasZoneAltInterface("DELEGATI@END")) {
        status.out.println(
         "<div id='PUODKNEFWX_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p1_b7_b0(BO,status);
      WriteControls_p1_b7_b1(BO,status);
      WriteControls_p1_b7_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['PUODKNEFWX']=['band_1_576','band_1_583','band_1_902'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("DELEGATI@BEGIN") || status.HasZoneAltInterface("DELEGATI@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b7_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b7_CloseBand(armt_informazioniBO BO,ServletStatus status) {
    status.includeZoneAltInterface("DELEGATI@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('PUODKNEFWX').setAttribute('status','open');");
    status.out.println("tabs_1_DETTAGLIO.AddTab({name:\"PUODKNEFWX\", element:\"PUODKNEFWX_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("DELEGATI"),"C",0,0)+",tabIndex: l_nPUODKNEFWXTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('PUODKNEFWX',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('PUODKNEFWX',false,true,false)}});");
    status.out.println("if (tabs_1_DETTAGLIO.CanCollapse()) {");
    status.out.println("tabs_1_DETTAGLIO.Expand('PUODKNEFWX');");
    status.out.println("}");
    status.out.println("PageOpened.AppendReceiver('page_1',tabs_1_DETTAGLIO.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
    WriteExtendedCBoxGroupChildren(BO.m_MNTs,status,"DETTAGLIO",1);
  }
  void WriteControls_p1_b7_b0(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_576' style='position:relative;height:7px;display:block' page='1'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b7_b1(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_583' style='position:relative;display:block' page='1'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='ardt_delegabo' id='RSWMQMMVEI' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_1_583']=['RSWMQMMVEI'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b7_b2(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_1_902' style='position:relative;height:18px;display:block' page='1'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b8(armt_informazioniBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_KURTXQHCYE")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_KURTXQHCYE' style='position:relative;height:8px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_KURTXQHCYE")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_KURTXQHCYE').style.height='auto';");
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
  void WriteControls_p1_b9(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div name='DATIRET' id='KURTXQHCYE_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='KURTXQHCYE_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='KURTXQHCYE_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Rettifiche (A54)")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='KURTXQHCYE_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"KURTXQHCYE\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=KURTXQHCYE_HEADER&m_cBoxId=KURTXQHCYE&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Rettifiche (A54)"))+"");
    }
    status.out.println(
     "<div id='KURTXQHCYE' class='SectionBody' style='position:relative;height:39px;display:block'>" +
    "");
    status.includeZoneAltInterface("DATIRET@BEGIN");
    if (status.includeZoneAltInterface("DATIRET")) {
      WriteControls_p1_b9_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("DATIRET@BEGIN") || status.HasZoneAltInterface("DATIRET@END")) {
        status.out.println(
         "<div id='KURTXQHCYE_boxContent' style='position:relative;height:39px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATARETT' id='VYBZEWHKFF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATARETT,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' style='display:none'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PXIMPOLVHG_DIV'>" +
       "<label id='PXIMPOLVHG' for='VYBZEWHKFF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A54B:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='STATOREG' id='OJXGBVSJHY' class='Combobox' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_STATOREG),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("0","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("0",CPLib.Trim(BO.w_STATOREG))?"SELECTED":"")+">" +
       ""+status.context.Translate("0 - Registrazione in essere mai modificata")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_STATOREG))?"SELECTED":"")+">" +
       ""+status.context.Translate("1 - Registrazione in essere sostitutiva di precedente registrazione")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_STATOREG))?"SELECTED":"")+">" +
       ""+status.context.Translate("2 - Registrazione annullata (cancellata per rettifica)")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("3","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("3",CPLib.Trim(BO.w_STATOREG))?"SELECTED":"")+">" +
       ""+status.context.Translate("3 - Registrazione annullata (sostituita per rettifica)")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('OJXGBVSJHY'),w_STATOREG,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MBISTIEAGL_DIV'>" +
       "<label id='MBISTIEAGL' for='OJXGBVSJHY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A54A. Stato Registrazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='OPERAZMOD' id='NSRIXGWOLV' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_OPERAZMOD,"C",20,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='20' size='20' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='AGZEQLWBPS_DIV'>" +
       "<label id='AGZEQLWBPS' for='NSRIXGWOLV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A54C:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("DATIRET@BEGIN") || status.HasZoneAltInterface("DATIRET@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b9_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b9_CloseBand(armt_informazioniBO BO,ServletStatus status) {
    status.includeZoneAltInterface("DATIRET@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("DATIRET")) {
      status.out.println("Ctrl('KURTXQHCYE').style.height='auto';");
    } else {
      status.out.println("Ctrl('KURTXQHCYE').setAttribute('band_height',39);");
    }
    status.out.println("Ctrl('KURTXQHCYE').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b10(armt_informazioniBO BO,ServletStatus status) {
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
  void WriteControls_p2_b0(armt_informazioniBO BO,ServletStatus status) {
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
  void WriteControls_p2_b1(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Intermediario' id='YCTBVNLZSK_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='YCTBVNLZSK_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='YCTBVNLZSK_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Intermediario/Dipendenza")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='YCTBVNLZSK_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"YCTBVNLZSK\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=YCTBVNLZSK_HEADER&m_cBoxId=YCTBVNLZSK&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Intermediario/Dipendenza"))+"");
    }
    status.out.println(
     "<div id='YCTBVNLZSK' class='SectionBody' style='position:relative;height:48px;display:block'>" +
    "");
    status.includeZoneAltInterface("Intermediario@BEGIN");
    if (status.includeZoneAltInterface("Intermediario")) {
      WriteControls_p2_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Intermediario@BEGIN") || status.HasZoneAltInterface("Intermediario@END")) {
        status.out.println(
         "<div id='YCTBVNLZSK_boxContent' style='position:relative;height:48px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<span class='SPLabel' id='VJHGEJLSKM_DIV'>" +
       "<label id='VJHGEJLSKM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Intermediario:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TGFGXLNJGM_DIV'>" +
       "<label id='TGFGXLNJGM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Dipen.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DPYJDBXPUD_DIV'>" +
       "<label id='DPYJDBXPUD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Città:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='IRVPTXCSTC_DIV'>" +
       "<label id='IRVPTXCSTC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Pr.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZWATUBQOIB_DIV'>" +
       "<label id='ZWATUBQOIB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAB:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VODVVAXWLX_DIV'>" +
       "<label id='VODVVAXWLX'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xDescDipe)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='CODINTER' id='ZTXEUOXXIE' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CODINTER,"C",11,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='11' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='CODDIPE' id='BRGHYFSDHY' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CODDIPE,"C",6,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='6' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='DESCCIT' id='PZJOZFRYQW' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DESCCIT,"C",30,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='PROVINCIA' id='WBNNXNUZER' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_PROVINCIA,"C",2,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='CODCAB' id='BCBQLPOXMG' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CODCAB,"C",6,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='6' fieldtype='C'>" +
      "");
      if (status.HasZoneAltInterface("Intermediario@BEGIN") || status.HasZoneAltInterface("Intermediario@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p2_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p2_b1_CloseBand(armt_informazioniBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Intermediario@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Intermediario")) {
      status.out.println("Ctrl('YCTBVNLZSK').style.height='auto';");
    } else {
      status.out.println("Ctrl('YCTBVNLZSK').setAttribute('band_height',48);");
    }
    status.out.println("Ctrl('YCTBVNLZSK').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b2(armt_informazioniBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_HDCVKCQUDV")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_HDCVKCQUDV' style='position:relative;height:8px;display:block' page='2'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_HDCVKCQUDV")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_HDCVKCQUDV').style.height='auto';");
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
  void WriteControls_p2_b3(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div id='tabs_2_Altri_container'>" +
     " " +
     "</div>" +
    "");
    status.out.println(
     "<div name='ALTRISOGG' id='HDCVKCQUDV_DIV' class='BoxContainer SPSection_expanded TabStripBoxContainer' group_id='tabs_2_Altri'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var tabs_2_Altri = new Z.Tabs({container:'tabs_2_Altri_container',useGlobals: false,boxtabs: true,useseparator:GetStyleVariable('boxTabUseSeparator',null,''),expandcollapse:GetStyleVariable('boxTabCanCollapse',null,''),contents:[],tabstrip_class: ''});");
    status.out.println("Z.Tabs.Set('tabs_2_Altri',tabs_2_Altri);");
    status.out.println("var l_nHDCVKCQUDVTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='HDCVKCQUDV' class='TabStripBoxBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("ALTRISOGG@BEGIN");
    if (status.includeZoneAltInterface("ALTRISOGG")) {
      WriteControls_p2_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("ALTRISOGG@BEGIN") || status.HasZoneAltInterface("ALTRISOGG@END")) {
        status.out.println(
         "<div id='HDCVKCQUDV_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p2_b3_b0(BO,status);
      WriteControls_p2_b3_b1(BO,status);
      WriteControls_p2_b3_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['HDCVKCQUDV']=['band_2_56','band_2_72','band_2_358'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("ALTRISOGG@BEGIN") || status.HasZoneAltInterface("ALTRISOGG@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p2_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p2_b3_CloseBand(armt_informazioniBO BO,ServletStatus status) {
    status.includeZoneAltInterface("ALTRISOGG@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('HDCVKCQUDV').setAttribute('status','open');");
    status.out.println("tabs_2_Altri.AddTab({name:\"HDCVKCQUDV\", element:\"HDCVKCQUDV_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Altri Soggetti Operanti"),"C",0,0)+",tabIndex: l_nHDCVKCQUDVTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('HDCVKCQUDV',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('HDCVKCQUDV',false,true,false)}});");
    status.out.println("if (tabs_2_Altri.CanCollapse()) {");
    status.out.println("tabs_2_Altri.Expand('HDCVKCQUDV');");
    status.out.println("}");
    status.out.println("PageOpened.AppendReceiver('page_2',tabs_2_Altri.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b3_b0(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_56' style='position:relative;height:16px;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b3_b1(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_72' style='position:relative;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='ardt_soginfo' id='IXHEMDOSUG' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_2_72']=['IXHEMDOSUG'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b3_b2(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_358' style='position:relative;height:18px;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b4(armt_informazioniBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_LTJVEGZAIT")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_LTJVEGZAIT' style='position:relative;height:8px;display:block' page='2'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_LTJVEGZAIT")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_LTJVEGZAIT').style.height='auto';");
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
  void WriteControls_p2_b5(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div name='FIDUCIANTI' id='LTJVEGZAIT_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' style='display:none' group_id='tabs_2_Altri'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nLTJVEGZAITTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='LTJVEGZAIT' class='TabStripBoxBody' style='position:relative;display:none'>" +
    "");
    status.includeZoneAltInterface("FIDUCIANTI@BEGIN");
    if (status.includeZoneAltInterface("FIDUCIANTI")) {
      WriteControls_p2_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("FIDUCIANTI@BEGIN") || status.HasZoneAltInterface("FIDUCIANTI@END")) {
        status.out.println(
         "<div id='LTJVEGZAIT_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p2_b5_b0(BO,status);
      WriteControls_p2_b5_b1(BO,status);
      WriteControls_p2_b5_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['LTJVEGZAIT']=['band_2_384','band_2_392','band_2_648'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("FIDUCIANTI@BEGIN") || status.HasZoneAltInterface("FIDUCIANTI@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p2_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p2_b5_CloseBand(armt_informazioniBO BO,ServletStatus status) {
    status.includeZoneAltInterface("FIDUCIANTI@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('LTJVEGZAIT').setAttribute('status','close');");
    status.out.println("tabs_2_Altri.AddTab({name:\"LTJVEGZAIT\", element:\"LTJVEGZAIT_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Fiducianti"),"C",0,0)+",tabIndex: l_nLTJVEGZAITTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('LTJVEGZAIT',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('LTJVEGZAIT',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_2',tabs_2_Altri.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b5_b0(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_384' style='position:relative;height:8px;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b5_b1(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_392' style='position:relative;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='ardt_fiduciabo' id='BZLPIJZENB' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_2_392']=['BZLPIJZENB'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b5_b2(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_648' style='position:relative;height:16px;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b6(armt_informazioniBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_RTQYCVGOWV")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_RTQYCVGOWV' style='position:relative;height:8px;display:block' page='2'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_RTQYCVGOWV")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_RTQYCVGOWV').style.height='auto';");
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
  void WriteControls_p2_b7(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div name='TITOLARI' id='RTQYCVGOWV_DIV' class='BoxContainer SPSection_collapsed TabStripBoxContainer' group_id='tabs_2_Altri'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<script>" +
    "");
    status.out.println("var l_nRTQYCVGOWVTabIndex = " + SPLib.ToJSValue(status.m_nTabIndex,"N",0,0)+ ";");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<div id='RTQYCVGOWV' class='TabStripBoxBody' style='position:relative;display:none'>" +
    "");
    status.includeZoneAltInterface("TITOLARI@BEGIN");
    if (status.includeZoneAltInterface("TITOLARI")) {
      WriteControls_p2_b7_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("TITOLARI@BEGIN") || status.HasZoneAltInterface("TITOLARI@END")) {
        status.out.println(
         "<div id='RTQYCVGOWV_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p2_b7_b0(BO,status);
      WriteControls_p2_b7_b1(BO,status);
      WriteControls_p2_b7_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['RTQYCVGOWV']=['band_2_672','band_2_712','band_2_938'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("TITOLARI@BEGIN") || status.HasZoneAltInterface("TITOLARI@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p2_b7_CloseBand(BO,status);
    }
  }
  void WriteControls_p2_b7_CloseBand(armt_informazioniBO BO,ServletStatus status) {
    status.includeZoneAltInterface("TITOLARI@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('RTQYCVGOWV').setAttribute('status','close');");
    status.out.println("tabs_2_Altri.AddTab({name:\"RTQYCVGOWV\", element:\"RTQYCVGOWV_DIV\", caption:"+SPLib.ToJSValue(status.context.Translate("Altri Titolari Effetti"),"C",0,0)+",tabIndex: l_nRTQYCVGOWVTabIndex,css_class: '',onExpand:function(){ToggleCollapsibleBox('RTQYCVGOWV',true,true,false)},onCollapse:function(){ToggleCollapsibleBox('RTQYCVGOWV',false,true,false)}});");
    status.out.println("PageOpened.AppendReceiver('page_2',tabs_2_Altri.ApplySliders);");
    status.out.println(
     "</script>" +
    "");
    WriteExtendedCBoxGroupChildren(BO.m_MNTs,status,"Altri",2);
  }
  void WriteControls_p2_b7_b0(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_672' style='position:relative;height:40px;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='WKYJJJVZEF_DIV'>" +
     "<input name='FLAGTIT' id='WKYJJJVZEF' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLAGTIT,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_FLAGTIT)?"CHECKED":"")+">" +
     "<label id='WKYJJJVZEF_LBL' for='WKYJJJVZEF' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Comprendere anche titolari intestatario rapporto in estrazione scarico Ministeriale"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b7_b1(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_712' style='position:relative;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='ardt_terzistirap' id='NOKYMTFBFL' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_2_712']=['NOKYMTFBFL'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b7_b2(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_938' style='position:relative;height:14px;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b8(armt_informazioniBO BO,ServletStatus status) {
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
  static void PrintState(armt_informazioniBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_informazioniBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
    if (BO.ardt_informazioni.IsUpdated()) {
      BO.m_cWv_ardt_informazioni = BO.ardt_informazioni.GetContext();
    }
    if (BO.ardt_delegabo.IsUpdated()) {
      BO.m_cWv_ardt_delegabo = BO.ardt_delegabo.GetContext();
    }
    if (BO.ardt_soginfo.IsUpdated()) {
      BO.m_cWv_ardt_soginfo = BO.ardt_soginfo.GetContext();
    }
    if (BO.ardt_fiduciabo.IsUpdated()) {
      BO.m_cWv_ardt_fiduciabo = BO.ardt_fiduciabo.GetContext();
    }
    if (BO.ardt_terzistirap.IsUpdated()) {
      BO.m_cWv_ardt_terzistirap = BO.ardt_terzistirap.GetContext();
    }
  }
  static void PrintStateWorkVars(armt_informazioniBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_CDATOPE,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CDATREG,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODINTER,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODDIPE,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAOPE,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAREG,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOOPRAP,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNESOPER,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOLEG,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_IDBASE:BO.w_IDBASE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOINTER,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOINF,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDEREG,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGRAP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OPRAP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OPERATORE,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AUTOM,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCCIT,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINCIA,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODCAB,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMPROG,"C",11,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_NUMPROG:BO.w_NUMPROG,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGRAP2,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGLIRE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PRGIMPINF,"N",15,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_PRGIMPINF:BO.w_PRGIMPINF,"N",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OPERAZMOD,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDBASE2,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATARETT,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_STATOREG,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGTIT,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gIntemediario,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gSblocco,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgDTP,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gChkDate,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gStatus,"C",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gDataVaria,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gCodDip,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_filtro,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dataoggi,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipreg,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipregn,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_sEdit,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescrap,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDescDipe,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_datpaseuro,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDesReg,"C",90,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xRagSoc,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_errmsg,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_Aggiorna,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_lancio,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VALUTA,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CITINT,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CITDIP,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVDIP,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CABDIP,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINT,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CABINT,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_inutile,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_prova,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_closeall,"C",1,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_codazi:BO.m_Ctx.GetCompany(),"C",10,0));
    if (CPLib.eq(BO.m_cWv_ardt_informazioni,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_informazioni");
    } else if (CPLib.eq(BO.m_cWv_ardt_informazioni,"_not_empty_")) {
      BO.m_cWv_ardt_informazioni = BO.ardt_informazioni.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_informazioni,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_informazioni,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_delegabo,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_delegabo");
    } else if (CPLib.eq(BO.m_cWv_ardt_delegabo,"_not_empty_")) {
      BO.m_cWv_ardt_delegabo = BO.ardt_delegabo.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_delegabo,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_delegabo,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_soginfo,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_soginfo");
    } else if (CPLib.eq(BO.m_cWv_ardt_soginfo,"_not_empty_")) {
      BO.m_cWv_ardt_soginfo = BO.ardt_soginfo.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_soginfo,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_soginfo,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_fiduciabo,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_fiduciabo");
    } else if (CPLib.eq(BO.m_cWv_ardt_fiduciabo,"_not_empty_")) {
      BO.m_cWv_ardt_fiduciabo = BO.ardt_fiduciabo.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_fiduciabo,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_fiduciabo,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_terzistirap,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_terzistirap");
    } else if (CPLib.eq(BO.m_cWv_ardt_terzistirap,"_not_empty_")) {
      BO.m_cWv_ardt_terzistirap = BO.ardt_terzistirap.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_terzistirap,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_terzistirap,"C",0,0));
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_BLXOBUQVYE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_XXRYVYIIGY = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_XAWQKRVCSF = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_QSDCLKKQSB = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_YJYVIBZLQH = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_VODVVAXWLX = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(1072,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(909,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_informazioni"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'WJSVGWKSFC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"WJSVGWKSFC",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,intermbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'AVHTGZTOSZ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"AVHTGZTOSZ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'UMFEJVRUFZ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"UMFEJVRUFZ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anarapbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'SWRTSKXMDH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SWRTSKXMDH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipreg,"+"default",l_session)+"'"+"]");
      status.out.print(",'SLTZSUMACW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SLTZSUMACW",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'MLPGOPNAKN':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"MLPGOPNAKN",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipleg,"+"default",l_session)+"'"+",'"+com.zucchetti.PortalStudio.JSPLib.cmdHash("qbe_tipileg",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'WJSVGWKSFC':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,intermbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'AVHTGZTOSZ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'UMFEJVRUFZ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anarapbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'SWRTSKXMDH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipreg,"+"default",l_session)+"'"+"]");
      status.out.print(",'SLTZSUMACW':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'MLPGOPNAKN':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipleg,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_informazioni","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_informazioni",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("Intermediario"),"")) {
      status.quoteAndAppend("Intermediario","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("DATIBASE"),"")) {
      status.quoteAndAppend("DATIBASE","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("INTESTATARI"),"")) {
      status.quoteAndAppend("INTESTATARI","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("DELEGATI"),"")) {
      status.quoteAndAppend("DELEGATI","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("DATIRET"),"")) {
      status.quoteAndAppend("DATIRET","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("ALTRISOGG"),"")) {
      status.quoteAndAppend("ALTRISOGG","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("TITOLARI"),"")) {
      status.quoteAndAppend("TITOLARI","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Intermediario"),"")) {
      status.quoteAndAppend("Intermediario","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("FIDUCIANTI"),"")) {
      status.quoteAndAppend("FIDUCIANTI","hide","box");
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
  void WriteMainFormScript(armt_informazioniBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_informazioni',false);");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('AVHTGZTOSZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AVHTGZTOSZ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UMFEJVRUFZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UMFEJVRUFZ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YLIKFVPZJA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YLIKFVPZJA_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OEIKQOZMYJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OEIKQOZMYJ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SWRTSKXMDH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SLTZSUMACW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SLTZSUMACW_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MLPGOPNAKN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VYBZEWHKFF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OJXGBVSJHY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JGGDFBSZJB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WKYJJJVZEF')) SetDisabled(c,true);");
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
      status.out.println("if (Ctrl('ZFLICMSKTV')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('ZFLICMSKTV',linkpc_url('ZFLICMSKTV'));");
      status.out.println("}");
      status.out.println("if (Ctrl('RSWMQMMVEI')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('RSWMQMMVEI',linkpc_url('RSWMQMMVEI'));");
      status.out.println("}");
      status.out.println("if (Ctrl('IXHEMDOSUG')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('IXHEMDOSUG',linkpc_url('IXHEMDOSUG'));");
      status.out.println("}");
      status.out.println("if (Ctrl('BZLPIJZENB')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('BZLPIJZENB',linkpc_url('BZLPIJZENB'));");
      status.out.println("}");
      status.out.println("if (Ctrl('NOKYMTFBFL')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('NOKYMTFBFL',linkpc_url('NOKYMTFBFL'));");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
      }
    }
    status.out.println("FillCombosValues();");
    status.out.println("SetControlsValue();");
    status.out.println("NotifyEvent('Record Loaded');");
    status.out.println("LoadContext();");
    status.out.println("// * --- Area Manuale = UI - OnLoad End");
    status.out.println("// * --- armt_informazioni");
    status.out.println("if (m_cFunction=='new') {");
    status.out.println("  CaricaSog()");
    status.out.println("}");
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
    status.out.println("if (Eq(name,'ardt_informazioni')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_informazioni")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_delegabo')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_delegabo")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_soginfo')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_soginfo")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_fiduciabo')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_fiduciabo")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_terzistirap')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_terzistirap")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    ChildSelectedPageChild(BO.m_MNTs,status,status.m_cSelectedPage);
    status.out.println("}");
    if (CPLib.ne(status.m_cClientMode,"query")) {
      status.out.println("function UpdateAutonumber(p_uid) {");
      if (CPLib.eq(status.m_cClientMode,"new")) {
        status.out.println("var l_b0 = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
        status.out.println("if (Eq(p_uid,'IDBASE') || Empty(p_uid)) {");
        status.out.println("l_b0= ! (Eq(op_codazi,m_cCompany));");
        status.out.println("}");
      }
      status.out.println("var l_b1 = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
      status.out.println("if (Eq(p_uid,'NUMPROG') || Empty(p_uid)) {");
      status.out.println("l_b1= ! (Eq(op_codazi,m_cCompany));");
      status.out.println("}");
      status.out.println("var l_b2 = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
      status.out.println("if (Eq(p_uid,'PRGIMPINF') || Empty(p_uid)) {");
      status.out.println("l_b2= ! (Eq(op_codazi,m_cCompany));");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"new")) {
        status.out.println("if (l_b0) {");
        status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_IDBASE','PRGINFO1');");
        status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
        status.out.println("AutonumberApplet().SetProg('IDBASE',w_IDBASE,op_IDBASE,'C',10,0);");
        status.out.println("AutonumberApplet().SetETName('rapopebo');");
        status.out.println("w_IDBASE=AutonumberApplet().GetAutonumberString('IDBASE');");
        status.out.println("}");
      }
      status.out.println("if (l_b1) {");
      status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_NUMPROG','PRGINFO2');");
      status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
      status.out.println("AutonumberApplet().SetProg('NUMPROG',w_NUMPROG,op_NUMPROG,'C',11,0);");
      status.out.println("AutonumberApplet().SetETName('rapopebo');");
      status.out.println("w_NUMPROG=AutonumberApplet().GetAutonumberString('NUMPROG');");
      status.out.println("}");
      status.out.println("if (l_b2) {");
      status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_PRGIMPINF','PRGIMPINF');");
      status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
      status.out.println("AutonumberApplet().SetProg('PRGIMPINF',w_PRGIMPINF,op_PRGIMPINF,'N',15,0);");
      status.out.println("AutonumberApplet().SetETName('rapopebo');");
      status.out.println("w_PRGIMPINF=AutonumberApplet().GetAutonumberDouble('PRGIMPINF');");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"new")) {
        status.out.println("if (l_b0) {");
        status.out.println("op_codazi=m_cCompany;");
        status.out.println("op_IDBASE=w_IDBASE;");
        status.out.println("}");
      }
      status.out.println("if (l_b1) {");
      status.out.println("op_NUMPROG=w_NUMPROG;");
      status.out.println("}");
      status.out.println("if (l_b2) {");
      status.out.println("op_PRGIMPINF=w_PRGIMPINF;");
      status.out.println("}");
      status.out.println("}");
    }
    WriteJSError(status);
    WriteTableCombo(status,BO);
    status.out.println("// * --- Area Manuale = UI - Functions & Procedures");
    status.out.println("// * --- armt_informazioni");
    status.out.println("function CaricaSog() {");
    status.out.println("  Ctrl('ZFLICMSKTV').src='ardt_informazioni?m_bInnerChild=true&m_cAction=editload&RAPPORTO='+LRTrim(w_prova)+'&m_bRowsChild=false'");
    status.out.println("  Ctrl('RSWMQMMVEI').src='ardt_delegabo?m_bInnerChild=true&m_cAction=editload&RAPPORTO='+LRTrim(w_prova)+'&m_bRowsChild=false'      ");
    status.out.println("  Ctrl('IXHEMDOSUG').src='ardt_soginfo?m_bInnerChild=true&m_cAction=editload&RAPCOL='+LRTrim(w_prova)+'&m_bRowsChild=false'        ");
    status.out.println("  Ctrl('BZLPIJZENB').src='ardt_fiduciabo?m_bInnerChild=true&m_cAction=editload&RAPCOL='+LRTrim(w_prova)+'&m_bRowsChild=false'          ");
    status.out.println("}");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  armt_informazioniBO getBO(ServletStatus status) {
    armt_informazioniBO BO = new armt_informazioniBO(status.context);
    // gli op_ possono essere utilizzati dalla servlet anche prima di essere inizializzati
    BO.op_IDBASE = BO.w_IDBASE;
    BO.op_NUMPROG = BO.w_NUMPROG;
    BO.op_PRGIMPINF = BO.w_PRGIMPINF;
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_informazioniBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("rapopebo",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_informazioniBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_informazioniBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
    l_cTmp = "[";
    VQRHolder l_VQRHolder=null;
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_tbtipregno1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),BO,false);
    l_VQRHolder.LoadTempWhere("");
    l_VQRHolder.LoadTempOrderBy("CODICE");
    l_rsLoad = l_VQRHolder.GetResultSet(BO.m_Ctx);
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",2,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("CODICE"),"C",2,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DES1"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var SWRTSKXMDH_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    SPBridge.HMCaller _h_MLPGOPNAKN = new SPBridge.HMCaller();
    _h_MLPGOPNAKN.Set("CDATOPE",BO.w_CDATOPE);
    _h_MLPGOPNAKN.Set("filtro",BO.w_filtro);
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_tipileg",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),_h_MLPGOPNAKN,false);
    l_VQRHolder.LoadTempWhere("");
    l_rsLoad = l_VQRHolder.GetResultSet(BO.m_Ctx);
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",1,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("TPCODICE"),"C",1,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("TPDESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var MLPGOPNAKN_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(armt_informazioniBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_rapopebo;
    String l_cPhName = BO.m_cPhName_rapopebo;
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
      String l_cQueryFilter = armt_informazioniBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_rapopebo+".IDBASE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("rapopebo");
    String l_cPhName = CPSql.ManipulateTablePhName("rapopebo",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".IDBASE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,armt_informazioniBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_informazioniBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_rapopebo,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_rapopebo,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_informazioniBO BO) {
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
  void Edit(ServletStatus status,armt_informazioniBO BO,SPParameterSource source) {
    BO.Load(status.w_IDBASE);
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
  void New(ServletStatus status,armt_informazioniBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_informazioniBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_informazioniBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_IDBASE = "";
      } else {
        BO.w_IDBASE = l_rsKeys.GetString("IDBASE");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_IDBASE = BO.w_IDBASE;
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
  void EditLoad(ServletStatus status,armt_informazioniBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_informazioniBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_IDBASE);
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
  void DeleteMessage(ServletStatus status,armt_informazioniBO BO,SPParameterSource source) {
    BO.Load(status.w_IDBASE);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_informazioniBO BO) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    String l_cTransMsgErr = "";
    BO.SetFromContext(status.m_cWv,status.m_Parameters);
    String l_old_IDBASE = "";
    if (CPLib.ne(BO.w_IDBASE,BO.op_IDBASE)) {
      l_old_IDBASE = BO.op_IDBASE;
    }
    String l_old_NUMPROG = "";
    if (CPLib.ne(BO.w_NUMPROG,BO.op_NUMPROG)) {
      l_old_NUMPROG = BO.op_NUMPROG;
    }
    double l_old_PRGIMPINF = 0;
    if (CPLib.ne(BO.w_PRGIMPINF,BO.op_PRGIMPINF)) {
      l_old_PRGIMPINF = BO.op_PRGIMPINF;
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
      if ( ! (CPLib.Empty(l_old_IDBASE))) {
        BO.op_IDBASE = l_old_IDBASE;
      }
      if ( ! (CPLib.Empty(l_old_NUMPROG))) {
        BO.op_NUMPROG = l_old_NUMPROG;
      }
      if ( ! (CPLib.Empty(l_old_PRGIMPINF))) {
        BO.op_PRGIMPINF = l_old_PRGIMPINF;
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
  void Discard(ServletStatus status,armt_informazioniBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_informazioniBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",972);
    item.put("w",909);
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
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Altri Soggetti\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Dati,Altri Soggetti");
    item.put("altInterfaceFor","armt_informazioni");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Intermediario\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Intermediario\\/Dipendenza\",\"h\":48,\"name\":\"Intermediario\",\"page\":1,\"shrinkable\":true,\"spuid\":\"GSYOOIOWZF\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Intermediario\\/Dipendenza\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":0,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Intermediario\",\"disabled\":\"true\",\"h\":21,\"maxlength\":11,\"name\":\"CODINTER\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"WJSVGWKSFC\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":78,\"x\":152,\"y\":16,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Dipendenza\",\"h\":21,\"maxlength\":6,\"name\":\"CODDIPE\",\"page\":1,\"picker\":true,\"spuid\":\"AVHTGZTOSZ\",\"tabindex\":23,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":280,\"y\":16,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_LOEAMXUYLA\",\"page\":1,\"spuid\":\"LOEAMXUYLA\",\"tabindex\":39,\"type\":\"Label\",\"value\":\"Intermediario:\",\"w\":78,\"x\":72,\"y\":20,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Citt\\u00E0 Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":30,\"name\":\"DESCCIT\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"RLUMBFHPUD\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":198,\"x\":544,\"y\":16,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":2,\"name\":\"PROVINCIA\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"OJGQABFSYN\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":774,\"y\":16,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAB Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":6,\"name\":\"CODCAB\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"OZEOCQRSEQ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":61,\"x\":832,\"y\":16,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_XVRJYSKGWZ\",\"page\":1,\"spuid\":\"XVRJYSKGWZ\",\"tabindex\":43,\"type\":\"Label\",\"value\":\"Dipen.:\",\"w\":40,\"x\":237,\"y\":20,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_CTLYJMTHDV\",\"page\":1,\"spuid\":\"CTLYJMTHDV\",\"tabindex\":44,\"type\":\"Label\",\"value\":\"Citt\\u00E0:\",\"w\":28,\"x\":515,\"y\":20,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_JWSDOSRGAG\",\"page\":1,\"spuid\":\"JWSDOSRGAG\",\"tabindex\":45,\"type\":\"Label\",\"value\":\"Pr.:\",\"w\":22,\"x\":749,\"y\":20,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_ENBRMMDVUP\",\"page\":1,\"spuid\":\"ENBRMMDVUP\",\"tabindex\":46,\"type\":\"Label\",\"value\":\"CAB:\",\"w\":27,\"x\":802,\"y\":20,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_BLXOBUQVYE\",\"page\":1,\"spuid\":\"BLXOBUQVYE\",\"tabindex\":47,\"type\":\"Label\",\"w\":164,\"x\":348,\"y\":20,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"DATIBASE\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"DATI BASE\",\"h\":168,\"name\":\"DATIBASE\",\"page\":1,\"shrinkable\":true,\"spuid\":\"YORQOIOBQN\",\"stretch\":true,\"tabindex\":2,\"title_caption\":\"DATI BASE\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":49,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":25,\"name\":\"RAPPORTO\",\"page\":1,\"picker\":true,\"spuid\":\"UMFEJVRUFZ\",\"tabindex\":24,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":166,\"x\":168,\"y\":65,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WDSMYOZLJE\",\"page\":1,\"spuid\":\"WDSMYOZLJE\",\"tabindex\":52,\"type\":\"Label\",\"value\":\"Rapporto:\",\"w\":111,\"x\":55,\"y\":69,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_XXRYVYIIGY\",\"page\":1,\"spuid\":\"XXRYVYIIGY\",\"tabindex\":54,\"type\":\"Label\",\"w\":440,\"x\":360,\"y\":69,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"Data Operazione\",\"h\":20,\"maxlength\":10,\"name\":\"DATAOPE\",\"page\":1,\"picker\":true,\"spuid\":\"YLIKFVPZJA\",\"tabindex\":25,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":168,\"y\":93,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"Data registrazione\",\"h\":20,\"maxlength\":10,\"name\":\"DATAREG\",\"page\":1,\"picker\":true,\"spuid\":\"OEIKQOZMYJ\",\"tabindex\":26,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":720,\"y\":89,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero Progressivo\",\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"NUMPROG\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"XYMCLUECBD\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":96,\"x\":408,\"y\":89,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KDUGHGZUUG\",\"page\":1,\"spuid\":\"KDUGHGZUUG\",\"tabindex\":49,\"type\":\"Label\",\"value\":\"N\\u00B0 Progressivo:\",\"w\":93,\"x\":312,\"y\":93,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IKBMEWKQJW\",\"page\":1,\"spuid\":\"IKBMEWKQJW\",\"tabindex\":50,\"type\":\"Label\",\"value\":\"Data registrazione:\",\"w\":127,\"x\":592,\"y\":93,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HVHVAYPDJE\",\"page\":1,\"spuid\":\"HVHVAYPDJE\",\"tabindex\":51,\"type\":\"Label\",\"value\":\"Data Operazione:\",\"w\":119,\"x\":47,\"y\":97,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo Informazione\",\"h\":20,\"maxlength\":2,\"name\":\"TIPOOPRAP\",\"page\":1,\"spuid\":\"SWRTSKXMDH\",\"tabindex\":27,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":368,\"x\":168,\"y\":121,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BYKQMDEEAQ\",\"page\":1,\"spuid\":\"BYKQMDEEAQ\",\"tabindex\":36,\"type\":\"Label\",\"value\":\"Tipo Informazione:\",\"w\":158,\"x\":8,\"y\":125,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ID Registrazione\",\"disabled\":\"true\",\"h\":20,\"maxlength\":20,\"name\":\"IDEREG\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"KHYCSRMDGJ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":138,\"x\":720,\"y\":121,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NOCRBBFOUY\",\"page\":1,\"spuid\":\"NOCRBBFOUY\",\"tabindex\":80,\"type\":\"Label\",\"value\":\"A03. ID Registrazione:\",\"w\":127,\"x\":592,\"y\":125,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Soggetto Operante Conto Terzi\",\"h\":20,\"maxlength\":16,\"name\":\"CONNESOPER\",\"page\":1,\"picker\":true,\"spuid\":\"SLTZSUMACW\",\"tabindex\":28,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":108,\"x\":168,\"y\":148,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QSDCLKKQSB\",\"page\":1,\"spuid\":\"QSDCLKKQSB\",\"tabindex\":73,\"type\":\"Label\",\"w\":158,\"x\":8,\"y\":152,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_YJYVIBZLQH\",\"page\":1,\"spuid\":\"YJYVIBZLQH\",\"tabindex\":74,\"type\":\"Label\",\"w\":296,\"x\":304,\"y\":152,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_EFRNVTREYB\",\"page\":1,\"spuid\":\"EFRNVTREYB\",\"tabindex\":75,\"type\":\"Label\",\"value\":\"Soggetto non presente in anagrafica\",\"w\":296,\"x\":304,\"y\":152,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo Legame Sogg.\",\"h\":20,\"maxlength\":1,\"name\":\"TIPOLEG\",\"page\":1,\"spuid\":\"MLPGOPNAKN\",\"tabindex\":29,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":336,\"x\":168,\"y\":176,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XAWQKRVCSF\",\"page\":1,\"spuid\":\"XAWQKRVCSF\",\"tabindex\":72,\"type\":\"Label\",\"w\":158,\"x\":8,\"y\":180,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":18,\"name\":\"label_GHJRKCKISV\",\"page\":1,\"spuid\":\"GHJRKCKISV\",\"tabindex\":77,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"COPIA OPERAZIONE MODIFICATA\",\"w\":240,\"x\":648,\"y\":193,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":18,\"name\":\"label_ZKPQBQAUZR\",\"page\":1,\"spuid\":\"ZKPQBQAUZR\",\"tabindex\":76,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"OPERAZIONE CANCELLATA\",\"w\":240,\"x\":648,\"y\":193,\"zone\":\"pag1_2_8\",\"zonepath\":\"[1,2,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"INTESTATARI\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"INTESTATARI\",\"groupName\":\"DETTAGLIO\",\"h\":350,\"name\":\"INTESTATARI\",\"page\":1,\"shrinkable\":true,\"spuid\":\"HOHRVXKGPC\",\"stretch\":true,\"tabindex\":3,\"title_caption\":\"INTESTATARI\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":218,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":326,\"name\":\"ardt_informazioni\",\"page\":1,\"spuid\":\"ZFLICMSKTV\",\"tabindex\":5,\"type\":\"Iframe\",\"w\":803,\"x\":80,\"y\":225,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"DELEGATI\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"DELEGATI\",\"groupName\":\"DETTAGLIO\",\"h\":344,\"name\":\"DELEGATI\",\"page\":1,\"shrinkable\":true,\"spuid\":\"PUODKNEFWX\",\"stretch\":true,\"tabindex\":4,\"title_caption\":\"DELEGATI\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":576,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":319,\"name\":\"ardt_delegabo\",\"page\":1,\"spuid\":\"RSWMQMMVEI\",\"tabindex\":6,\"type\":\"Iframe\",\"w\":869,\"x\":24,\"y\":583,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"DATIRET\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Rettifiche (A54)\",\"h\":39,\"name\":\"DATIRET\",\"page\":1,\"shrinkable\":true,\"spuid\":\"KURTXQHCYE\",\"stretch\":true,\"tabindex\":78,\"title_caption\":\"Dati Rettifiche (A54)\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":928,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Rettifica\",\"h\":20,\"maxlength\":10,\"name\":\"DATARETT\",\"page\":1,\"spuid\":\"VYBZEWHKFF\",\"tabindex\":84,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":641,\"y\":934,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PXIMPOLVHG\",\"page\":1,\"spuid\":\"PXIMPOLVHG\",\"tabindex\":85,\"type\":\"Label\",\"value\":\"A54B:\",\"w\":38,\"x\":601,\"y\":938,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Stato\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"STATOREG\",\"page\":1,\"spuid\":\"OJXGBVSJHY\",\"tabindex\":86,\"textlist\":\"0 - Registrazione in essere mai modificata,1 - Registrazione in essere sostitutiva di precedente registrazione,2 - Registrazione annullata (cancellata per rettifica),3 - Registrazione annullata (sostituita per rettifica)\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"0"+"'"+","+"'"+"1"+"'"+","+"'"+"2"+"'"+","+"'"+"3"+"'"+"\",\"w\":416,\"x\":184,\"y\":935,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MBISTIEAGL\",\"page\":1,\"spuid\":\"MBISTIEAGL\",\"tabindex\":87,\"type\":\"Label\",\"value\":\"A54A. Stato Registrazione:\",\"w\":160,\"x\":16,\"y\":939,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Operazione Modificata\",\"disabled\":\"true\",\"h\":20,\"maxlength\":20,\"name\":\"OPERAZMOD\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"NSRIXGWOLV\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":132,\"x\":766,\"y\":934,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AGZEQLWBPS\",\"page\":1,\"spuid\":\"AGZEQLWBPS\",\"tabindex\":89,\"type\":\"Label\",\"value\":\"A54C:\",\"w\":40,\"x\":724,\"y\":938,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Intermediario\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Intermediario\\/Dipendenza\",\"h\":48,\"name\":\"Intermediario\",\"page\":2,\"shrinkable\":true,\"spuid\":\"YCTBVNLZSK\",\"stretch\":true,\"tabindex\":6,\"title_caption\":\"Intermediario\\/Dipendenza\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":0,\"zone\":\"pag2_1\",\"zonepath\":\"[2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_VJHGEJLSKM\",\"page\":2,\"spuid\":\"VJHGEJLSKM\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"Intermediario:\",\"w\":78,\"x\":72,\"y\":20,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_TGFGXLNJGM\",\"page\":2,\"spuid\":\"TGFGXLNJGM\",\"tabindex\":8,\"type\":\"Label\",\"value\":\"Dipen.:\",\"w\":40,\"x\":237,\"y\":20,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_DPYJDBXPUD\",\"page\":2,\"spuid\":\"DPYJDBXPUD\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"Citt\\u00E0:\",\"w\":28,\"x\":515,\"y\":20,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_IRVPTXCSTC\",\"page\":2,\"spuid\":\"IRVPTXCSTC\",\"tabindex\":10,\"type\":\"Label\",\"value\":\"Pr.:\",\"w\":22,\"x\":749,\"y\":20,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_ZWATUBQOIB\",\"page\":2,\"spuid\":\"ZWATUBQOIB\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"CAB:\",\"w\":27,\"x\":802,\"y\":20,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_VODVVAXWLX\",\"page\":2,\"spuid\":\"VODVVAXWLX\",\"tabindex\":12,\"type\":\"Label\",\"w\":176,\"x\":336,\"y\":19,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"CODINTER\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"ZTXEUOXXIE\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":78,\"x\":152,\"y\":16,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":6,\"name\":\"CODDIPE\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"BRGHYFSDHY\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":272,\"y\":16,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":30,\"name\":\"DESCCIT\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"PZJOZFRYQW\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":552,\"y\":16,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"PROVINCIA\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"WBNNXNUZER\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":776,\"y\":16,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":6,\"name\":\"CODCAB\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"BCBQLPOXMG\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":832,\"y\":16,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"ALTRISOGG\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Altri Soggetti Operanti\",\"groupName\":\"Altri\",\"h\":320,\"name\":\"ALTRISOGG\",\"page\":2,\"shrinkable\":true,\"spuid\":\"HDCVKCQUDV\",\"tabindex\":1,\"title_caption\":\"Altri Soggetti Operanti\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":56,\"zone\":\"pag2_2\",\"zonepath\":\"[2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":286,\"name\":\"ardt_soginfo\",\"page\":2,\"spuid\":\"IXHEMDOSUG\",\"tabindex\":2,\"type\":\"Iframe\",\"w\":613,\"x\":160,\"y\":72,\"zone\":\"pag2_2_1\",\"zonepath\":\"[2,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"FIDUCIANTI\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Fiducianti\",\"groupName\":\"Altri\",\"h\":280,\"name\":\"FIDUCIANTI\",\"page\":2,\"shrinkable\":true,\"spuid\":\"LTJVEGZAIT\",\"tabindex\":13,\"title_caption\":\"Fiducianti\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":384,\"zone\":\"pag2_3\",\"zonepath\":\"[2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":256,\"name\":\"ardt_fiduciabo\",\"page\":2,\"spuid\":\"BZLPIJZENB\",\"tabindex\":3,\"type\":\"Iframe\",\"w\":637,\"x\":144,\"y\":392,\"zone\":\"pag2_3_1\",\"zonepath\":\"[2,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"TITOLARI\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Altri Titolari Effetti\",\"groupName\":\"Altri\",\"h\":280,\"name\":\"TITOLARI\",\"page\":2,\"shrinkable\":true,\"spuid\":\"RTQYCVGOWV\",\"tabindex\":4,\"title_caption\":\"Altri Titolari Effetti\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":672,\"zone\":\"pag2_4\",\"zonepath\":\"[2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Flag Somma Titolari\",\"h\":21,\"label_text\":\"Comprendere anche titolari intestatario rapporto in estrazione scarico Ministeriale\",\"maxlength\":2,\"name\":\"FLAGTIT\",\"page\":2,\"spuid\":\"WKYJJJVZEF\",\"tabindex\":19,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":640,\"x\":144,\"y\":687,\"zone\":\"pag2_4_1\",\"zonepath\":\"[2,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":226,\"name\":\"ardt_terzistirap\",\"page\":2,\"spuid\":\"NOKYMTFBFL\",\"tabindex\":5,\"type\":\"Iframe\",\"w\":640,\"x\":144,\"y\":712,\"zone\":\"pag2_4_2\",\"zonepath\":\"[2,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_informazioniBO BO,ServletStatus status) {
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
     "<script src='armt_informazioni?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_informazioni_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_informazioni_edit.js'>" +
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
      status.out.println("w_CDATOPE=a[0];");
      status.out.println("w_CDATREG=a[1];");
      status.out.println("w_CODINTER=a[2];");
      status.out.println("w_CODDIPE=a[3];");
      status.out.println("w_RAPPORTO=a[4];");
      status.out.println("w_DATAOPE=a[5];");
      status.out.println("w_DATAREG=a[6];");
      status.out.println("w_TIPOOPRAP=a[7];");
      status.out.println("w_CONNESOPER=a[8];");
      status.out.println("w_TIPOLEG=a[9];");
      status.out.println("w_IDBASE=a[10];");
      status.out.println("op_IDBASE=a[11];");
      status.out.println("w_TIPOINTER=a[12];");
      status.out.println("w_TIPOINF=a[13];");
      status.out.println("w_IDEREG=a[14];");
      status.out.println("w_FLAGRAP=a[15];");
      status.out.println("w_OPRAP=a[16];");
      status.out.println("w_OPERATORE=a[17];");
      status.out.println("w_AUTOM=a[18];");
      status.out.println("w_DESCCIT=a[19];");
      status.out.println("w_PROVINCIA=a[20];");
      status.out.println("w_CODCAB=a[21];");
      status.out.println("w_NUMPROG=a[22];");
      status.out.println("op_NUMPROG=a[23];");
      status.out.println("w_FLAGRAP2=a[24];");
      status.out.println("w_FLAGLIRE=a[25];");
      status.out.println("w_PRGIMPINF=a[26];");
      status.out.println("op_PRGIMPINF=a[27];");
      status.out.println("w_OPERAZMOD=a[28];");
      status.out.println("w_IDBASE2=a[29];");
      status.out.println("w_DATARETT=a[30];");
      status.out.println("w_STATOREG=a[31];");
      status.out.println("w_FLAGTIT=a[32];");
      status.out.println("w_gIntemediario=a[33];");
      status.out.println("w_gSblocco=a[34];");
      status.out.println("w_gFlgDTP=a[35];");
      status.out.println("w_gChkDate=a[36];");
      status.out.println("w_gStatus=a[37];");
      status.out.println("w_gDataVaria=a[38];");
      status.out.println("w_gCodDip=a[39];");
      status.out.println("w_filtro=a[40];");
      status.out.println("w_dataoggi=a[41];");
      status.out.println("w_tipreg=a[42];");
      status.out.println("w_tipregn=a[43];");
      status.out.println("w_sEdit=a[44];");
      status.out.println("w_xdescrap=a[45];");
      status.out.println("w_xDescDipe=a[46];");
      status.out.println("w_datpaseuro=a[47];");
      status.out.println("w_xDesReg=a[48];");
      status.out.println("w_xRagSoc=a[49];");
      status.out.println("w_errmsg=a[50];");
      status.out.println("w_Aggiorna=a[51];");
      status.out.println("w_lancio=a[52];");
      status.out.println("w_VALUTA=a[53];");
      status.out.println("w_CITINT=a[54];");
      status.out.println("w_CITDIP=a[55];");
      status.out.println("w_PROVDIP=a[56];");
      status.out.println("w_CABDIP=a[57];");
      status.out.println("w_PROVINT=a[58];");
      status.out.println("w_CABINT=a[59];");
      status.out.println("w_inutile=a[60];");
      status.out.println("w_prova=a[61];");
      status.out.println("w_closeall=a[62];");
      status.out.println("op_codazi=a[63];");
      status.out.println("o_HOHRVXKGPC_expand=null;");
      status.out.println("o_HOHRVXKGPC_collapse=null;");
      status.out.println("o_PUODKNEFWX_expand=null;");
      status.out.println("o_PUODKNEFWX_collapse=null;");
      status.out.println("m_cWv_ardt_informazioni=a[64];");
      status.out.println("m_cWv_ardt_delegabo=a[65];");
      status.out.println("m_cWv_ardt_soginfo=a[66];");
      status.out.println("m_cWv_ardt_fiduciabo=a[67];");
      status.out.println("m_cWv_ardt_terzistirap=a[68];");
      status.out.println("if (Gt(a.length,69)) {");
      status.out.println("m_cErrorInChild='';");
      status.out.println("}");
      status.out.println("if (Gt(a.length,69)) {");
      status.out.println("o_filtro=w_filtro;");
      status.out.println("o_CDATOPE=w_CDATOPE;");
      status.out.println("o_CODINTER=w_CODINTER;");
      status.out.println("o_CODDIPE=w_CODDIPE;");
      status.out.println("o_RAPPORTO=w_RAPPORTO;");
      status.out.println("o_DATAOPE=w_DATAOPE;");
      status.out.println("o_TIPOOPRAP=w_TIPOOPRAP;");
      status.out.println("o_FLAGRAP=w_FLAGRAP;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['IDBASE'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_informazioni_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(1072,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","rapopebo");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","IDBASE");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(armt_informazioniBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_informazioniBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armt_informazioniBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armt_informazioniBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armt_informazioniBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_informazioniBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_informazioniBO BO,ServletStatus status) throws IOException {
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
     "<script src='SPPrxy/"+arfn_chkdatdoc.m_cEntityUid+"/arfn_chkdatdoc.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chkdatreg.m_cEntityUid+"/arfn_chkdatreg.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chksogg.m_cEntityUid+"/arfn_chksogg.js'>" +
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
      arfn_chkdatdoc.GetCallableNames(callable);
      arfn_chkdatreg.GetCallableNames(callable);
      arfn_chksogg.GetCallableNames(callable);
      arfn_view_soct.GetCallableNames(callable);
      CPLib.AddToSet(callable,"LibreriaMit");
      CPLib.AddToSet(callable,"Utilities");
      CPLib.AddToSet(callable,"ardt_informazioni");
      CPLib.AddToSet(callable,"ardt_delegabo");
      CPLib.AddToSet(callable,"ardt_soginfo");
      CPLib.AddToSet(callable,"ardt_fiduciabo");
      CPLib.AddToSet(callable,"ardt_terzistirap");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_informazioniBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_IDBASE),"C",10,0));
      }
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gIntemediario),"C",11,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gSblocco),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(BO.w_gFlgDTP,"N",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gChkDate),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gStatus),"C",4,0));
      hCreator.AddValue(CPLib.ToSQL(BO.w_gDataVaria,"D",8,0));
      hCreator.AddValue(CPLib.ToSQL(BO.w_gFlgDTP,"N",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gCodDip),"C",6,0));
    } else if (CPLib.eq(p_cUID,"WJSVGWKSFC")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"AVHTGZTOSZ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"UMFEJVRUFZ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SWRTSKXMDH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SLTZSUMACW")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"MLPGOPNAKN")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_informazioniBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_CODINTER))) {
        a = GetCheckVars(status,BO,"WJSVGWKSFC");
        b = status.m_CheckVars.optString("WJSVGWKSFC");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CODDIPE))) {
        a = GetCheckVars(status,BO,"AVHTGZTOSZ");
        b = status.m_CheckVars.optString("AVHTGZTOSZ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_RAPPORTO))) {
        a = GetCheckVars(status,BO,"UMFEJVRUFZ");
        b = status.m_CheckVars.optString("UMFEJVRUFZ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_TIPOOPRAP))) {
        a = GetCheckVars(status,BO,"SWRTSKXMDH");
        b = status.m_CheckVars.optString("SWRTSKXMDH");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CONNESOPER))) {
        a = GetCheckVars(status,BO,"SLTZSUMACW");
        b = status.m_CheckVars.optString("SLTZSUMACW");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_TIPOLEG))) {
        a = GetCheckVars(status,BO,"MLPGOPNAKN");
        b = status.m_CheckVars.optString("MLPGOPNAKN");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
