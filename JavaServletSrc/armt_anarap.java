import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_anarap extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*6ce82c30*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "anarapbo";
    }
    public String w_RAPPORTO;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_RAPPORTO,context,"anarapbo","RAPPORTO","C",25,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
    armt_anarapBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_anarapbo;
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
    return "Rapporti";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_anarap";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 1429;
    l_eg.m_nEntityHeight = 597;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"anarapbo","tbvalute","tbdurata","tbdurata_p","tbimporto","tbimporto_p","tbareegeog","tbareegeog_p","tbsvolgim","tbsvolgim_p","tbplauso","tbplauso_p","tbtiporisc","tbtiporisc_p","tbcateg01","tbcateg02","tbcateg03","tbcateg04","tbcateg05","anadip","tbmacage","personbo"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","Dati Base","page"),new ZoneItem("page_2","Intestatari / Informazioni","page"),new ZoneItem("page_3","Operazioni / Frazionate","page"),new ZoneItem("page_4","Deleghe su rapporto","page"),new ZoneItem("page_5","Garantiti","page"),new ZoneItem("page_6","Saldi AGE","page"),new ZoneItem("page_7","Saldi Canali Distributivi (MITSV)","page"),new ZoneItem("DatiBase","Dati Base","horizontal_section"),new ZoneItem("Categorie","Categorie","horizontal_section"),new ZoneItem("DatiBase","Dati Base","horizontal_section"),new ZoneItem("Rapporto","Rapporto e Operazioni","horizontal_section"),new ZoneItem("Deleghe","Deleghe","horizontal_section"),new ZoneItem("Garantiti","Garantiti","horizontal_section"),new ZoneItem("Dipendenza","Dipendenza Riferimento","horizontal_section"),new ZoneItem("Saldi","Saldi","horizontal_section"),new ZoneItem("SaldiCanali","Saldi","horizontal_section"),new ZoneItem("AltriDati","Altri Dati","horizontal_section")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"RAPPORTO"};
    l_eg.items = new SPItem[]{
                   new SPItem("gTipInter","C",2,0, "hide","Tipo Intermediario"),
                   new SPItem("gBrowser","C",1,0, "hide","Tipo Browser"),
                   new SPItem("gTelepass","C",1,0, "hide","Versione Telepass"),
                   new SPItem("gCodDip","C",6,0, "hide","Dipendenza"),
                   new SPItem("CODDIP","C",6,0, "hide","Dipendenza / Agenzia che crea il rapporto"),
                   new SPItem("RAPPORTO","C",25,0, "edit","Codice Rapporto"),
                   new SPItem("DESCRAP","C",50,0, "edit","Descrizione"),
                   new SPItem("TIPORAP","C",1,0, "edit","Tipo Rapporto"),
                   new SPItem("TIPOAG","C",2,0, "edit",""),
                   new SPItem("ISOAGE","C",3,0, "edit","Per tipo rapporto 96/97"),
                   new SPItem("NOPROT","N",1,0, "edit","Non inviare agenzia entrate"),
                   new SPItem("FLAGLIRE","C",1,0, "edit","Divisa"),
                   new SPItem("VALUTA","C",3,0, "edit","Codice Divisa"),
                   new SPItem("PRGIMPRAP","N",15,0, "hide","Progressivo Import"),
                   new SPItem("descval","C",30,0, "hide","Descrizione"),
                   new SPItem("IBAN","C",30,0, "edit","IBAN"),
                   new SPItem("CODOGG","C",3,0, "edit","Cod. Rapporto Oggettivo"),
                   new SPItem("daticoll","N",10,0, "hide",""),
                   new SPItem("NATURA","C",50,0, "edit",""),
                   new SPItem("SCOPO","C",50,0, "edit",""),
                   new SPItem("DURAT","C",5,0, "edit",""),
                   new SPItem("DURAT","C",5,0, "show",""),
                   new SPItem("RFREQ","N",3,0, "edit",""),
                   new SPItem("AMMONT","C",5,0, "edit",""),
                   new SPItem("AMMONT","C",5,0, "show",""),
                   new SPItem("RIMP","N",3,0, "edit",""),
                   new SPItem("AREAGEO","C",5,0, "edit",""),
                   new SPItem("AREAGEO","C",5,0, "show",""),
                   new SPItem("RAREA","N",3,0, "edit",""),
                   new SPItem("MODSVOL","C",5,0, "edit",""),
                   new SPItem("MODSVOL","C",5,0, "show",""),
                   new SPItem("RCOMP","N",3,0, "edit",""),
                   new SPItem("RAGIO","C",5,0, "edit",""),
                   new SPItem("RAGIO","C",5,0, "show",""),
                   new SPItem("RRAGIO","N",3,0, "edit",""),
                   new SPItem("TIPO","C",5,0, "edit",""),
                   new SPItem("TIPO","C",2,0, "show",""),
                   new SPItem("RTIPO","N",3,0, "edit",""),
                   new SPItem("xdescmodsvo","C",200,0, "hide","Descrizione"),
                   new SPItem("xdescareag","C",50,0, "hide","Descrizione"),
                   new SPItem("xdescplauso","C",200,0, "hide","Descrizione"),
                   new SPItem("xdesctipor","C",100,0, "hide","Descrizione"),
                   new SPItem("xdescfreq","C",200,0, "hide","Descrizione"),
                   new SPItem("xdescammo","C",200,0, "hide","Descrizione"),
                   new SPItem("RISGLOB","C",1,0, "edit","Rischio Globale"),
                   new SPItem("DATAPROF","D",8,0, "edit","Data Profilatura"),
                   new SPItem("DATAREVPROF","D",8,0, "edit","Data Revisione Profilatura"),
                   new SPItem("MITIG","N",4,0, "edit","Mitigazione (+/-)"),
                   new SPItem("MITGDOC","C",100,0, "edit","Documentazione Mitigazione"),
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
                   new SPItem("CATEGORIA","C",10,0, "hide","Categoria"),
                   new SPItem("titolo","C",90,0, "show",""),
                   new SPItem("NOCANC","N",1,0, "edit","Non considerare per passaggio storico/cancellazione"),
                   new SPItem("mess","M",10,0, "hide",""),
                   new SPItem("xMADESCRI","C",60,0, "hide","Denominazione"),
                   new SPItem("xRAGLEG","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("xDESDIPE","C",30,0, "hide","Descrizione"),
                   new SPItem("CODDIPE","C",6,0, "edit","Dipendeza Riferimento"),
                   new SPItem("MACODICE","C",5,0, "edit","Macro Agente"),
                   new SPItem("SPLITCODE","C",15,0, "edit","Customer ID (WUBS)"),
                   new SPItem("CODICELR","C",16,0, "edit","Legale Rappresentante")
                 };
    l_eg.m_lHasHistorical = false;
    return l_eg;
  }
  ArrayList<org.json.JSONArray> i_sidebarItems = null;
  public org.json.JSONArray getSidebarItems(int p_nPage) {
    if (CPLib.IsNull(i_sidebarItems)) {
      i_sidebarItems = InitializeSidebarItemsArray(7);
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_anarapBO BO) {
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
      i_contextmenu = InitializeContextMenuArray(7);
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
    l_translations=new String[][]{{"10049460300",p_Context.Translate("Tipologia Rischio")},
    {"10138432524",p_Context.Translate("Non considerare per passaggio storico/cancellazione")},
    {"10194595222",p_Context.Translate("Non inviare agenzia entrate")},
    {"10198789526",p_Context.Translate("Non inviare Agenzia Entrate")},
    {"10252637878",p_Context.Translate("Data Profilatura")},
    {"10500809751",p_Context.Translate("Rischio Globale")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"10907241187",p_Context.Translate("Visualizza possibili nature della relazione d'affari")},
    {"109693534",p_Context.Translate("Natura")},
    {"109710548",p_Context.Translate("Divisa")},
    {"11053408024",p_Context.Translate("Area Geografica")},
    {"11116511596",p_Context.Translate("Codice Rapporto")},
    {"1113664440",p_Context.Translate("Non considerare per passaggio storico/cancellazione (comprese le operazioni collegate)")},
    {"11148260655",p_Context.Translate("Data Revisione Profilatura")},
    {"11158852142",p_Context.Translate("Modalità Svolgimento")},
    {"11283631966",p_Context.Translate("Macro Agente")},
    {"11283673182",p_Context.Translate("Marco Agenti")},
    {"114016870",p_Context.Translate("Valute")},
    {"11441951893",p_Context.Translate("Dipendenza / Agenzia che crea il rapporto")},
    {"115410470",p_Context.Translate("Customer ID (WUBS)")},
    {"11593637356",p_Context.Translate("Calcola la data di revisione della profilatura")},
    {"11635074230",p_Context.Translate("Cod. Rapporto Oggettivo")},
    {"11815361151",p_Context.Translate("Legale Rappresentante")},
    {"11857520945",p_Context.Translate("Ammontare Operazione")},
    {"12056209762",p_Context.Translate("Denominazione")},
    {"1270140254",p_Context.Translate("Dipendenza")},
    {"1273209170",p_Context.Translate("Confermi la copia del rapporto in 5.1?")},
    {"1529904207",p_Context.Translate("Per tipo rapporto 96/97")},
    {"157141684",p_Context.Translate("Categoria")},
    {"157154740",p_Context.Translate("Categoria 1")},
    {"157154996",p_Context.Translate("Categoria 2")},
    {"157155252",p_Context.Translate("Categoria 3")},
    {"157155508",p_Context.Translate("Categoria 4")},
    {"157155764",p_Context.Translate("Categoria 5")},
    {"1573704569",p_Context.Translate("Versione Telepass")},
    {"1682876716",p_Context.Translate("%1")},
    {"1716450187",p_Context.Translate("Tipo Browser")},
    {"1723736132",p_Context.Translate("Tipo Rapporto")},
    {"1730321404",p_Context.Translate("Codice Divisa")},
    {"191062270",p_Context.Translate("%1")},
    {"194410082",p_Context.Translate("Rapporti")},
    {"1951322326",p_Context.Translate("%1")},
    {"195812931",p_Context.Translate("Soggetti")},
    {"210895516",p_Context.Translate("Documentazione Mitigazione")},
    {"283403499",p_Context.Translate("Progressivo Import")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"307787605",p_Context.Translate("Mitigazione (+/-)")},
    {"337257",p_Context.Translate("IBAN")},
    {"350773234",p_Context.Translate("Dipendeza Riferimento")},
    {"492802848",p_Context.Translate("Frequenza Operazione")},
    {"630676961",p_Context.Translate("Visualizza possibili scopi della relazione d'affari")},
    {"7763331",p_Context.Translate("Scopo")},
    {"955814582",p_Context.Translate("Ragionevolezza Operazione")},
    {"984756930",p_Context.Translate("Tipo Intermediario")}};
    return l_translations;
  }
  void WriteStyles(armt_anarapBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_anarap.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_anarapBO BO,ServletStatus status) {
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
    status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati Base"),"C",0,0)+"},{name:\"page_2\", element:\"page_2\", caption:"+SPLib.ToJSValue(status.context.Translate("Intestatari / Informazioni"),"C",0,0)+"},{name:\"page_3\", element:\"page_3\", caption:"+SPLib.ToJSValue(status.context.Translate("Operazioni / Frazionate"),"C",0,0)+"},{name:\"page_4\", element:\"page_4\", caption:"+SPLib.ToJSValue(status.context.Translate("Deleghe su rapporto"),"C",0,0)+"},{name:\"page_5\", element:\"page_5\", caption:"+SPLib.ToJSValue(status.context.Translate("Garantiti"),"C",0,0)+"},{name:\"page_6\", element:\"page_6\", caption:"+SPLib.ToJSValue(status.context.Translate("Saldi AGE"),"C",0,0)+"},{name:\"page_7\", element:\"page_7\", caption:"+SPLib.ToJSValue(status.context.Translate("Saldi Canali Distributivi (MITSV)"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
    status.out.println("Z.Tabs.Set('tabs',tabs);");
    status.out.println("} else {");
    status.out.println("var tabs = Z.Tabs.Get('tabs')");
    status.out.println("}");
    AddExtendedTabs(status);
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_anarap',false);");
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_anarap",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  // GetPortlet_Intestatari_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_XCLJCOLAOK_Vars(armt_anarapBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_rapporto",CPLib.LRTrim(BO.w_RAPPORTO));
    return inclusionVars;
  }
  // GetPortlet_Informazioni_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_NXJPOCJGET_Vars(armt_anarapBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_rapporto",CPLib.LRTrim(BO.w_RAPPORTO));
    return inclusionVars;
  }
  // GetPortlet_Operazioni_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_VNBQZVXZTE_Vars(armt_anarapBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_rapporto",CPLib.LRTrim(BO.w_RAPPORTO));
    return inclusionVars;
  }
  // GetPortlet_Frazionate_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_POJFSMHRKX_Vars(armt_anarapBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_rapporto",CPLib.LRTrim(BO.w_RAPPORTO));
    return inclusionVars;
  }
  // GetPortlet_Delegati_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_TVOFPFUAEZ_Vars(armt_anarapBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_rapporto",CPLib.LRTrim(BO.w_RAPPORTO));
    return inclusionVars;
  }
  void WriteControls(armt_anarapBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    WriteControls_p2(BO,status);
    WriteControls_p3(BO,status);
    WriteControls_p4(BO,status);
    WriteControls_p5(BO,status);
    WriteControls_p6(BO,status);
    WriteControls_p7(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,8);
  }
  void WriteControls_p1(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:597px;width:1429px;display:none'>" +
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
  void WriteControls_p2(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_2' class='PageContainer' style='position:relative;height:617px;width:1429px;display:none'>" +
    "");
    WriteControls_p2_b0(BO,status);
    WriteControls_p2_b1(BO,status);
    WriteControls_p2_b2(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,2,"Intestatari / Informazioni");
    PrintSidebarContent(2,status,getSidebarItems(1),true);
    PrintContextMenu(2,status,getContextMenu(1),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_3' class='PageContainer' style='position:relative;height:617px;width:1429px;display:none'>" +
    "");
    WriteControls_p3_b0(BO,status);
    WriteControls_p3_b1(BO,status);
    WriteControls_p3_b2(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,3,"Operazioni / Frazionate");
    PrintSidebarContent(3,status,getSidebarItems(2),true);
    PrintContextMenu(3,status,getContextMenu(2),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p4(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_4' class='PageContainer' style='position:relative;height:433px;width:1429px;display:none'>" +
    "");
    WriteControls_p4_b0(BO,status);
    WriteControls_p4_b1(BO,status);
    WriteControls_p4_b2(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,4,"Deleghe su rapporto");
    PrintSidebarContent(4,status,getSidebarItems(3),true);
    PrintContextMenu(4,status,getContextMenu(3),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p5(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_5' class='PageContainer' style='position:relative;height:437px;width:1429px;display:none'>" +
    "");
    WriteControls_p5_b0(BO,status);
    WriteControls_p5_b1(BO,status);
    WriteControls_p5_b2(BO,status);
    WriteControls_p5_b3(BO,status);
    WriteControls_p5_b4(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,5,"Garantiti");
    PrintSidebarContent(5,status,getSidebarItems(4),true);
    PrintContextMenu(5,status,getContextMenu(4),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p6(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_6' class='PageContainer' style='position:relative;height:631px;width:1429px;display:none'>" +
    "");
    WriteControls_p6_b0(BO,status);
    WriteControls_p6_b1(BO,status);
    WriteControls_p6_b2(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,6,"Saldi AGE");
    PrintSidebarContent(6,status,getSidebarItems(5),true);
    PrintContextMenu(6,status,getContextMenu(5),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p7(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_7' class='PageContainer' style='position:relative;height:413px;width:1429px;display:none'>" +
    "");
    WriteControls_p7_b0(BO,status);
    WriteControls_p7_b1(BO,status);
    WriteControls_p7_b2(BO,status);
    WriteControls_p7_b3(BO,status);
    WriteControls_p7_b4(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,7,"Saldi Canali Distributivi (MITSV)");
    PrintSidebarContent(7,status,getSidebarItems(6),true);
    PrintContextMenu(7,status,getContextMenu(6),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b0(armt_anarapBO BO,ServletStatus status) {
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
  void WriteControls_p1_b1(armt_anarapBO BO,ServletStatus status) {
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
     "<div id='YORQOIOBQN' class='SectionBody' style='position:relative;height:544px;display:block'>" +
    "");
    status.includeZoneAltInterface("DatiBase@BEGIN");
    if (status.includeZoneAltInterface("DatiBase")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("DatiBase@BEGIN") || status.HasZoneAltInterface("DatiBase@END")) {
        status.out.println(
         "<div id='YORQOIOBQN_boxContent' style='position:relative;height:544px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RAPPORTO' id='LXORWVRYJJ' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_RAPPORTO,"C",25,0,"@!", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='25' size='25' fieldtype='C'>" +
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
       "<input id='KKXIPNXBWK' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Copia in 5.1"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
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
       "<span id='AABRTCZWUY_DIV'>" +
       "<input name='NOPROT' id='AABRTCZWUY' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_NOPROT,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_NOPROT)?"CHECKED":"")+">" +
       "<label id='AABRTCZWUY_LBL' for='AABRTCZWUY' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Non inviare Agenzia Entrate"))+"</label>" +
       "</span>" +
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
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IBAN' id='WRZZQXZUXK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_IBAN,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='CODOGG' id='LSSRJEUOJW' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CTCKWHZVTZ_DIV'>" +
       "<label id='CTCKWHZVTZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Rap. Ag. Entrate:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HBAROSDSIX_DIV'>" +
       "<label id='HBAROSDSIX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("TIPOLOGIA E VALUTAZIONE RISCHIO (Ia DIRETTIVA)"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NATURA' id='VSHUPFYWOC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NATURA,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='javascript:href_ZBUITWBMLO()' tabindex='"+status.m_nTabIndex+"' id='ZBUITWBMLO_HREF' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
       "<span id='ZBUITWBMLO' title="+SPLib.ToHTMLValue(status.context.Translate("Visualizza possibili nature della relazione d'affari"),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation(Character.toString((char)59987))+"" +
       "</span>" +
       "</a>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SCOPO' id='VASVGQZJGP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SCOPO,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='javascript:href_BXHLWVGOYO()' tabindex='"+status.m_nTabIndex+"' id='BXHLWVGOYO_HREF' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
       "<span id='BXHLWVGOYO' title="+SPLib.ToHTMLValue(status.context.Translate("Visualizza possibili scopi della relazione d'affari"),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation(Character.toString((char)59987))+"" +
       "</span>" +
       "</a>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DURAT' id='CKJQULDXKW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DURAT,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
       "<button id='CKJQULDXKW_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "CKJQULDXKW", "tbdurata", "ammt_tbdurata", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RFREQ' id='MXYTQLATHC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RFREQ,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AMMONT' id='SXTYCPHBIM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AMMONT,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
       "<button id='SXTYCPHBIM_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "SXTYCPHBIM", "tbimporto", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RIMP' id='KBIUAXUDXA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RIMP,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AREAGEO' id='QJSTZIPOQB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AREAGEO,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
       "<button id='QJSTZIPOQB_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "QJSTZIPOQB", "tbareegeog", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RAREA' id='UDAYHICPVB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RAREA,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MODSVOL' id='SFFFOYOWNH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MODSVOL,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
       "<button id='SFFFOYOWNH_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "SFFFOYOWNH", "tbsvolgim", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RCOMP' id='ETALZDRBSO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RCOMP,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RAGIO' id='NOBMPHKVTX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RAGIO,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
       "<button id='NOBMPHKVTX_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "NOBMPHKVTX", "tbplauso", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RRAGIO' id='QBTVZDKLCO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RRAGIO,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='TIPO' id='DJOWYRMDDC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TIPO,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
       "<button id='DJOWYRMDDC_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "DJOWYRMDDC", "tbtiporisc", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RTIPO' id='RUWEXWJASG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RTIPO,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NAVNOGNZNE_DIV'>" +
       "<label id='NAVNOGNZNE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Area Geografica:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LHTXLTQYIK_DIV'>" +
       "<label id='LHTXLTQYIK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Svol. Instaurazione Rapp.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HGXSBHTFKF_DIV'>" +
       "<label id='HGXSBHTFKF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Ragionevolezza Rapporto:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OKFGBGYVWD_DIV'>" +
       "<label id='OKFGBGYVWD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo di rischio:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CMKJDFEFFI_DIV'>" +
       "<label id='CMKJDFEFFI'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdescareag)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DXOTWSGBKN_DIV'>" +
       "<label id='DXOTWSGBKN'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdescmodsvo)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FXHEISJAJE_DIV'>" +
       "<label id='FXHEISJAJE'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdescplauso)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GHHOMNKDDQ_DIV'>" +
       "<label id='GHHOMNKDDQ'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdesctipor)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NWFPTCEPRA_DIV'>" +
       "<label id='NWFPTCEPRA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("TIPOLOGIA RISCHIO"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NFLJJHXTKY_DIV'>" +
       "<label id='NFLJJHXTKY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("VALUTAZIONE"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZUVXJIZOSF_DIV'>" +
       "<label id='ZUVXJIZOSF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Frequenza:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LXNMWSOUMF_DIV'>" +
       "<label id='LXNMWSOUMF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Importo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BCFLBBQSRN_DIV'>" +
       "<label id='BCFLBBQSRN'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdescammo)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='QEXJCFPJBM_DIV'>" +
       "<label id='QEXJCFPJBM'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdescfreq)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PKJNNGBWFM_DIV'>" +
       "<label id='PKJNNGBWFM' for='OXGBDTWKSX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Documentazione Mitigazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='RISGLOB' id='SMVVFHCEHA' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAPROF' id='MXITFMGTNB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATAPROF,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='MXITFMGTNB_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAREVPROF' id='QLLLNEUVYW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATAREVPROF,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='QLLLNEUVYW_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MITIG' id='DOXBACRWUU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MITIG,"N",4,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='4' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MITGDOC' id='OXGBDTWKSX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MITGDOC,"C",100,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='100' size='100' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NKPWKMDXUR_DIV'>" +
       "<label id='NKPWKMDXUR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("%"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VCBMHLXJMD_DIV'>" +
       "<label id='VCBMHLXJMD' for='DOXBACRWUU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Mitigazione (+/-):"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CPZDORVHLG_DIV'>" +
       "<label id='CPZDORVHLG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("MITIGAZIONE RISCHIO"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WHSTCJKJTS_DIV'>" +
       "<label id='WHSTCJKJTS' for='WRZZQXZUXK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("IBAN:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZVXDABBVZA_DIV'>" +
       "<label id='ZVXDABBVZA' for='LSSRJEUOJW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cod. Rapporto Oggettivo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JKZZQYXAFS_DIV'>" +
       "<label id='JKZZQYXAFS' for='SMVVFHCEHA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Rischio Globale:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PLAWSVGZSR_DIV'>" +
       "<label id='PLAWSVGZSR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Es. Natura = Mutuo; Scopo = Acquisto beni di consumo"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BVGYBYGMJB_DIV'>" +
       "<label id='BVGYBYGMJB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Natura:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EWATRAIADP_DIV'>" +
       "<label id='EWATRAIADP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Scopo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ROVJICRYAM_DIV'>" +
       "<label id='ROVJICRYAM' for='QLLLNEUVYW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Revisione Profilatura:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TTZXYWANKG_DIV'>" +
       "<label id='TTZXYWANKG' for='MXITFMGTNB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Profilatura:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='GIJHAKTZAN_DIV'>" +
       "<input name='NOCANC' id='GIJHAKTZAN' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_NOCANC,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_NOCANC)?"CHECKED":"")+">" +
       "<label id='GIJHAKTZAN_LBL' for='GIJHAKTZAN' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Non considerare per passaggio storico/cancellazione (comprese le operazioni collegate)"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='"+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"javascript:void(0)":"javascript:href_ZFPXBMEPWE()")+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' id='ZFPXBMEPWE' class='SPHorizontalAction'>" +
       "<span id='ZFPXBMEPWE_img' title="+SPLib.ToHTMLValue(status.context.Translate("Calcola la data di revisione della profilatura"),"C",0,0)+" tabindex='-1'>" +
       ""+SPLib.ToHTMLRepresentation(Character.toString((char)60454))+"" +
       "</span>" +
       "<span class='SPLabel' id='ZFPXBMEPWE_txt'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Calcola"))+"" +
       "</span>" +
       "</a>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TQNAPDCWFY_DIV' style='display:none'>" +
       "<label id='TQNAPDCWFY' for='QBUCLWUNFT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Per tipo 96/97:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FYRUSHCQJD_DIV'>" +
       "<label id='FYRUSHCQJD' for='WRZZQXZUXK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("IBAN:"))+"" +
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
  void WriteControls_p1_b1_CloseBand(armt_anarapBO BO,ServletStatus status) {
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
      status.out.println("Ctrl('YORQOIOBQN').setAttribute('band_height',544);");
    }
    status.out.println("Ctrl('YORQOIOBQN').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_RFAIYHSGII")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_RFAIYHSGII' style='position:relative;height:8px;display:block' page='1'>" +
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
  void WriteControls_p1_b3(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Categorie' id='RFAIYHSGII_DIV' class='BoxContainer SPSection_collapsed SectionContainerWithTitle'>" +
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
       "<img id='RFAIYHSGII_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderExpandImage", "../"+status.m_cTheme+"/formPage/box_expand.gif")+"' onclick='ToggleCollapsibleBox(\"RFAIYHSGII\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=RFAIYHSGII_HEADER&m_cBoxId=RFAIYHSGII&m_cInitialState=close&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Categorie"))+"");
    }
    status.out.println(
     "<div id='RFAIYHSGII' class='SectionBody' style='position:relative;height:123px;display:none'>" +
    "");
    status.includeZoneAltInterface("Categorie@BEGIN");
    if (status.includeZoneAltInterface("Categorie")) {
      WriteControls_p1_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Categorie@BEGIN") || status.HasZoneAltInterface("Categorie@END")) {
        status.out.println(
         "<div id='RFAIYHSGII_boxContent' style='position:relative;height:123px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
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
      WriteControls_p1_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b3_CloseBand(armt_anarapBO BO,ServletStatus status) {
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
      status.out.println("Ctrl('RFAIYHSGII').setAttribute('band_height',123);");
    }
    status.out.println("Ctrl('RFAIYHSGII').setAttribute('status','close');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b4(armt_anarapBO BO,ServletStatus status) {
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
  void WriteControls_p2_b0(armt_anarapBO BO,ServletStatus status) {
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
  void WriteControls_p2_b1(armt_anarapBO BO,ServletStatus status) {
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
      WriteControls_p2_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("DatiBase@BEGIN") || status.HasZoneAltInterface("DatiBase@END")) {
        status.out.println(
         "<div id='GJZISGEBVV_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p2_b1_b0(BO,status);
      WriteControls_p2_b1_b1(BO,status);
      WriteControls_p2_b1_b2(BO,status);
      WriteControls_p2_b1_b3(BO,status);
      WriteControls_p2_b1_b4(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['GJZISGEBVV']=['band_2_0','band_2_48','band_2_320','band_2_328','band_2_576'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("DatiBase@BEGIN") || status.HasZoneAltInterface("DatiBase@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p2_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p2_b1_CloseBand(armt_anarapBO BO,ServletStatus status) {
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
  void WriteControls_p2_b1_b0(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_0' style='position:relative;height:48px;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='QIETKIRGON' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Crea Informazioni 31 e 32"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b1_b1(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_48' style='position:relative;display:block' page='2'>" +
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
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_intestbo_portlet.jsp?ForcedPortletUID="+ portletUID_XCLJCOLAOK+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_XCLJCOLAOK),true);
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
  void WriteControls_p2_b1_b2(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_320' style='position:relative;height:8px;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b1_b3(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_328' style='position:relative;display:block' page='2'>" +
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
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_rapopebo_portlet.jsp?ForcedPortletUID="+ portletUID_NXJPOCJGET+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_NXJPOCJGET),true);
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
  void WriteControls_p2_b1_b4(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_576' style='position:relative;height:16px;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b2(armt_anarapBO BO,ServletStatus status) {
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
  void WriteControls_p3_b0(armt_anarapBO BO,ServletStatus status) {
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
  void WriteControls_p3_b1(armt_anarapBO BO,ServletStatus status) {
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
      WriteControls_p3_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Rapporto@BEGIN") || status.HasZoneAltInterface("Rapporto@END")) {
        status.out.println(
         "<div id='LZCEHELAXJ_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p3_b1_b0(BO,status);
      WriteControls_p3_b1_b1(BO,status);
      WriteControls_p3_b1_b2(BO,status);
      WriteControls_p3_b1_b3(BO,status);
      WriteControls_p3_b1_b4(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['LZCEHELAXJ']=['band_3_0','band_3_8','band_3_288','band_3_296','band_3_584'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("Rapporto@BEGIN") || status.HasZoneAltInterface("Rapporto@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p3_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p3_b1_CloseBand(armt_anarapBO BO,ServletStatus status) {
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
  void WriteControls_p3_b1_b0(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_0' style='position:relative;height:8px;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b1_b1(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_8' style='position:relative;display:block' page='3'>" +
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
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_operazbo_rap_portlet.jsp?ForcedPortletUID="+ portletUID_VNBQZVXZTE+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_VNBQZVXZTE),true);
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
  void WriteControls_p3_b1_b2(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_288' style='position:relative;height:8px;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b1_b3(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_296' style='position:relative;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='POJFSMHRKX'>" +
    "");
    // GetPortlet_Frazionate_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_POJFSMHRKX;
    inclusionVars_POJFSMHRKX = GetPortlet_POJFSMHRKX_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_POJFSMHRKX);
    String portletUID_POJFSMHRKX = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_fraziobo_rap_portlet.jsp?ForcedPortletUID="+ portletUID_POJFSMHRKX+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_POJFSMHRKX),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.POJFSMHRKX='"+portletUID_POJFSMHRKX+"';" +
     "w_Frazionate=ZtVWeb.getPortletById('"+portletUID_POJFSMHRKX+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b1_b4(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_584' style='position:relative;height:8px;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b2(armt_anarapBO BO,ServletStatus status) {
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
  void WriteControls_p4_b0(armt_anarapBO BO,ServletStatus status) {
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
  void WriteControls_p4_b1(armt_anarapBO BO,ServletStatus status) {
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
      WriteControls_p4_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Deleghe@BEGIN") || status.HasZoneAltInterface("Deleghe@END")) {
        status.out.println(
         "<div id='EHSQLOIDHO_boxContent' style='position:relative;display:block'>" +
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
      status.out.println("ToggleCollapsibleBox.subBands['EHSQLOIDHO']=['band_4_0','band_4_8','band_4_400'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("Deleghe@BEGIN") || status.HasZoneAltInterface("Deleghe@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p4_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p4_b1_CloseBand(armt_anarapBO BO,ServletStatus status) {
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
  void WriteControls_p4_b1_b0(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_4_0' style='position:relative;height:8px;display:block' page='4'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p4_b1_b1(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_4_8' style='position:relative;display:block' page='4'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div id='TVOFPFUAEZ'>" +
    "");
    // GetPortlet_Delegati_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_TVOFPFUAEZ;
    inclusionVars_TVOFPFUAEZ = GetPortlet_TVOFPFUAEZ_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_TVOFPFUAEZ);
    String portletUID_TVOFPFUAEZ = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_delegabo_portlet.jsp?ForcedPortletUID="+ portletUID_TVOFPFUAEZ+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_TVOFPFUAEZ),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.TVOFPFUAEZ='"+portletUID_TVOFPFUAEZ+"';" +
     "w_Delegati=ZtVWeb.getPortletById('"+portletUID_TVOFPFUAEZ+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p4_b1_b2(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_4_400' style='position:relative;height:8px;display:block' page='4'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p4_b2(armt_anarapBO BO,ServletStatus status) {
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
  void WriteControls_p5_b0(armt_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_5")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_5' style='position:relative;height:8px;display:block' page='5'>" +
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
  void WriteControls_p5_b1(armt_anarapBO BO,ServletStatus status) {
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
      WriteControls_p5_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Garantiti@BEGIN") || status.HasZoneAltInterface("Garantiti@END")) {
        status.out.println(
         "<div id='LWDMGLAEON_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p5_b1_b0(BO,status);
      WriteControls_p5_b1_b1(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['LWDMGLAEON']=['band_5_8','band_5_343'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("Garantiti@BEGIN") || status.HasZoneAltInterface("Garantiti@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p5_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p5_b1_CloseBand(armt_anarapBO BO,ServletStatus status) {
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
  void WriteControls_p5_b1_b0(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_5_8' style='position:relative;display:block' page='5'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='ardt_garantbo' id='ZSYGOPYXSA' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_5_8']=['ZSYGOPYXSA'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p5_b1_b1(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_5_343' style='position:relative;height:9px;display:block' page='5'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p5_b2(armt_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_TUIMYVJMXF")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_TUIMYVJMXF' style='position:relative;height:1px;display:block' page='5'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_TUIMYVJMXF")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_TUIMYVJMXF').style.height='auto';");
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
  void WriteControls_p5_b3(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Dipendenza' id='TUIMYVJMXF_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='TUIMYVJMXF_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='TUIMYVJMXF_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dipendenza Riferimento")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='TUIMYVJMXF_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"TUIMYVJMXF\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=TUIMYVJMXF_HEADER&m_cBoxId=TUIMYVJMXF&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dipendenza Riferimento"))+"");
    }
    status.out.println(
     "<div id='TUIMYVJMXF' class='SectionBody' style='position:relative;height:39px;display:block'>" +
    "");
    status.includeZoneAltInterface("Dipendenza@BEGIN");
    if (status.includeZoneAltInterface("Dipendenza")) {
      WriteControls_p5_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Dipendenza@BEGIN") || status.HasZoneAltInterface("Dipendenza@END")) {
        status.out.println(
         "<div id='TUIMYVJMXF_boxContent' style='position:relative;height:39px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<span class='SPLabel' id='TEKSYGREXN_DIV'>" +
       "<label id='TEKSYGREXN'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xDESDIPE)+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODDIPE' id='HBPZQIPSZE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODDIPE,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
       "<button id='HBPZQIPSZE_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "HBPZQIPSZE", "anadip", "armt_anadip", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CBLDNZTZNA_DIV'>" +
       "<label id='CBLDNZTZNA' for='HBPZQIPSZE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Dipendenza Riferimento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Dipendenza@BEGIN") || status.HasZoneAltInterface("Dipendenza@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p5_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p5_b3_CloseBand(armt_anarapBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Dipendenza@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Dipendenza")) {
      status.out.println("Ctrl('TUIMYVJMXF').style.height='auto';");
    } else {
      status.out.println("Ctrl('TUIMYVJMXF').setAttribute('band_height',39);");
    }
    status.out.println("Ctrl('TUIMYVJMXF').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p5_b4(armt_anarapBO BO,ServletStatus status) {
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
  void WriteControls_p6_b0(armt_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_6")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_6' style='position:relative;height:4px;display:block' page='6'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_TOP_OF_PAGE_6")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_TOP_OF_PAGE_6').style.height='auto';");
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
  void WriteControls_p6_b1(armt_anarapBO BO,ServletStatus status) {
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
      WriteControls_p6_b1_CloseBand(BO,status);
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
      WriteControls_p6_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p6_b1_CloseBand(armt_anarapBO BO,ServletStatus status) {
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
  void WriteControls_p6_b2(armt_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_END_OF_PAGE_6")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_END_OF_PAGE_6' style='position:relative;height:5px;display:block' page='6'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_END_OF_PAGE_6")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_END_OF_PAGE_6').style.height='auto';");
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
  void WriteControls_p7_b0(armt_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_7")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_7' style='position:relative;height:8px;display:block' page='7'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_TOP_OF_PAGE_7")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_TOP_OF_PAGE_7').style.height='auto';");
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
  void WriteControls_p7_b1(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div name='SaldiCanali' id='GURCMCSTQS_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='GURCMCSTQS_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='GURCMCSTQS_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Saldi")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='GURCMCSTQS_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"GURCMCSTQS\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=GURCMCSTQS_HEADER&m_cBoxId=GURCMCSTQS&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Saldi"))+"");
    }
    status.out.println(
     "<div id='GURCMCSTQS' class='SectionBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("SaldiCanali@BEGIN");
    if (status.includeZoneAltInterface("SaldiCanali")) {
      WriteControls_p7_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("SaldiCanali@BEGIN") || status.HasZoneAltInterface("SaldiCanali@END")) {
        status.out.println(
         "<div id='GURCMCSTQS_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p7_b1_b0(BO,status);
      WriteControls_p7_b1_b1(BO,status);
      WriteControls_p7_b1_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['GURCMCSTQS']=['band_7_8','band_7_16','band_7_351'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("SaldiCanali@BEGIN") || status.HasZoneAltInterface("SaldiCanali@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p7_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p7_b1_CloseBand(armt_anarapBO BO,ServletStatus status) {
    status.includeZoneAltInterface("SaldiCanali@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('GURCMCSTQS').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p7_b1_b0(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_7_8' style='position:relative;height:8px;display:block' page='7'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p7_b1_b1(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_7_16' style='position:relative;display:block' page='7'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='ardt_saldi_idp' id='BOCKZFOGBL' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_7_16']=['BOCKZFOGBL'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p7_b1_b2(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_7_351' style='position:relative;height:9px;display:block' page='7'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p7_b2(armt_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_PHCJDNQLLF")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_PHCJDNQLLF' style='position:relative;height:8px;display:block' page='7'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_PHCJDNQLLF")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_PHCJDNQLLF').style.height='auto';");
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
  void WriteControls_p7_b3(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<div name='AltriDati' id='PHCJDNQLLF_DIV' class='BoxContainer SPSection_collapsed SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='PHCJDNQLLF_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='PHCJDNQLLF_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Altri Dati")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='PHCJDNQLLF_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderExpandImage", "../"+status.m_cTheme+"/formPage/box_expand.gif")+"' onclick='ToggleCollapsibleBox(\"PHCJDNQLLF\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=PHCJDNQLLF_HEADER&m_cBoxId=PHCJDNQLLF&m_cInitialState=close&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Altri Dati"))+"");
    }
    status.out.println(
     "<div id='PHCJDNQLLF' class='SectionBody' style='position:relative;height:88px;display:none'>" +
    "");
    status.includeZoneAltInterface("AltriDati@BEGIN");
    if (status.includeZoneAltInterface("AltriDati")) {
      WriteControls_p7_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("AltriDati@BEGIN") || status.HasZoneAltInterface("AltriDati@END")) {
        status.out.println(
         "<div id='PHCJDNQLLF_boxContent' style='position:relative;height:88px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MACODICE' id='SSYXHQXJLD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MACODICE,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
       "<button id='SSYXHQXJLD_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "SSYXHQXJLD", "tbmacage", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SPLITCODE' id='YSBAKLZECK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SPLITCODE,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FFCVEAIHJV_DIV'>" +
       "<label id='FFCVEAIHJV' for='YSBAKLZECK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Customer ID (WUIB):"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JIHVKRMSZD_DIV'>" +
       "<label id='JIHVKRMSZD' for='SSYXHQXJLD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Macro Agente:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TWSRQQLPNA_DIV'>" +
       "<label id='TWSRQQLPNA'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xMADESCRI)+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODICELR' id='UYHOJSIFEU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODICELR,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
       "<button id='UYHOJSIFEU_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "UYHOJSIFEU", "personbo", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XDJAPZOPHJ_DIV'>" +
       "<label id='XDJAPZOPHJ' for='UYHOJSIFEU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Legale Rappresentante:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CQBNLOGUOF_DIV'>" +
       "<label id='CQBNLOGUOF'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xRAGLEG)+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("AltriDati@BEGIN") || status.HasZoneAltInterface("AltriDati@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p7_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p7_b3_CloseBand(armt_anarapBO BO,ServletStatus status) {
    status.includeZoneAltInterface("AltriDati@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("AltriDati")) {
      status.out.println("Ctrl('PHCJDNQLLF').style.height='auto';");
    } else {
      status.out.println("Ctrl('PHCJDNQLLF').setAttribute('band_height',88);");
    }
    status.out.println("Ctrl('PHCJDNQLLF').setAttribute('status','close');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p7_b4(armt_anarapBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_END_OF_PAGE_7")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_END_OF_PAGE_7' style='position:relative;height:5px;display:block' page='7'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_END_OF_PAGE_7")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_END_OF_PAGE_7').style.height='auto';");
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
  static void PrintState(armt_anarapBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_anarapBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
    if (BO.ardt_garantbo.IsUpdated()) {
      BO.m_cWv_ardt_garantbo = BO.ardt_garantbo.GetContext();
    }
    if (BO.ardt_ae_saldianno_rap.IsUpdated()) {
      BO.m_cWv_ardt_ae_saldianno_rap = BO.ardt_ae_saldianno_rap.GetContext();
    }
    if (BO.ardt_saldi_idp.IsUpdated()) {
      BO.m_cWv_ardt_saldi_idp = BO.ardt_saldi_idp.GetContext();
    }
  }
  static void PrintStateWorkVars(armt_anarapBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_CODDIP,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCRAP,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPORAP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOAG,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ISOAGE,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOPROT,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGLIRE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VALUTA,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PRGIMPRAP,"N",15,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_PRGIMPRAP:BO.w_PRGIMPRAP,"N",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IBAN,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODOGG,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NATURA,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SCOPO,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DURAT,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RFREQ,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AMMONT,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RIMP,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AREAGEO,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAREA,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MODSVOL,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RCOMP,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAGIO,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RRAGIO,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPO,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RTIPO,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODDIPE,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RISGLOB,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAPROF,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAREVPROF,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MITIG,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MITGDOC,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CATEG01,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CATEG02,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CATEG03,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CATEG04,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CATEG05,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CATEGORIA,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOCANC,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MACODICE,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SPLITCODE,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODICELR,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gTipInter,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gBrowser,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gTelepass,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gCodDip,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descval,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_daticoll,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescmodsvo,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescareag,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescplauso,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesctipor,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescfreq,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescammo,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDESDIPE,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xMADESCRI,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xRAGLEG,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_mess,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xC1DESCRI,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xC2DESCRI,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xC3DESCRI,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xC4DESCRI,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xC5DESCRI,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_titolo,"C",90,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_codazi:BO.m_Ctx.GetCompany(),"C",10,0));
    if (CPLib.eq(BO.m_cWv_ardt_garantbo,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_garantbo");
    } else if (CPLib.eq(BO.m_cWv_ardt_garantbo,"_not_empty_")) {
      BO.m_cWv_ardt_garantbo = BO.ardt_garantbo.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_garantbo,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_garantbo,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_ae_saldianno_rap,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_ae_saldianno_rap");
    } else if (CPLib.eq(BO.m_cWv_ardt_ae_saldianno_rap,"_not_empty_")) {
      BO.m_cWv_ardt_ae_saldianno_rap = BO.ardt_ae_saldianno_rap.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_ae_saldianno_rap,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_ae_saldianno_rap,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_saldi_idp,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_saldi_idp");
    } else if (CPLib.eq(BO.m_cWv_ardt_saldi_idp,"_not_empty_")) {
      BO.m_cWv_ardt_saldi_idp = BO.ardt_saldi_idp.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_saldi_idp,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_saldi_idp,"C",0,0));
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_XQILBJQNNS = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_CMKJDFEFFI = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_DXOTWSGBKN = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_FXHEISJAJE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_GHHOMNKDDQ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_BCFLBBQSRN = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_QEXJCFPJBM = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_NRWNAJJVRA = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_LNOFOPAOYD = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_WBTKNDJDFF = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_MWCFKQVNHF = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_HADVHTQAPE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_TEKSYGREXN = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_TWSRQQLPNA = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_CQBNLOGUOF = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(597,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(1429,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_anarap"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'RUMXLFCOKA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"RUMXLFCOKA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbvalute,"+"default",l_session)+"'"+"]");
      status.out.print(",'CKJQULDXKW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"CKJQULDXKW",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbdurata,"+"default",l_session)+"'"+"]");
      status.out.print(",'VEAKSOSZMJ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"VEAKSOSZMJ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbdurata_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'SXTYCPHBIM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SXTYCPHBIM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbimporto,"+"default",l_session)+"'"+"]");
      status.out.print(",'FLHYCYAKON':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"FLHYCYAKON",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbimporto_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'QJSTZIPOQB':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QJSTZIPOQB",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog,"+"default",l_session)+"'"+"]");
      status.out.print(",'MDMTUJRAZF':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"MDMTUJRAZF",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'SFFFOYOWNH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SFFFOYOWNH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsvolgim,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZKJUEEUNAK':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ZKJUEEUNAK",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsvolgim_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'NOBMPHKVTX':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NOBMPHKVTX",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbplauso,"+"default",l_session)+"'"+"]");
      status.out.print(",'EAWVSIWQBM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"EAWVSIWQBM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbplauso_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'DJOWYRMDDC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"DJOWYRMDDC",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtiporisc,"+"default",l_session)+"'"+"]");
      status.out.print(",'DTDVSGUEWE':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"DTDVSGUEWE",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtiporisc_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'CANUTVNGFD':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"CANUTVNGFD",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg01,"+"default",l_session)+"'"+"]");
      status.out.print(",'IXGRJLAKIQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"IXGRJLAKIQ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg02,"+"default",l_session)+"'"+"]");
      status.out.print(",'NKIXCWZJHO':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NKIXCWZJHO",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg03,"+"default",l_session)+"'"+"]");
      status.out.print(",'JQLGHMLOKO':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"JQLGHMLOKO",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg04,"+"default",l_session)+"'"+"]");
      status.out.print(",'QVBZSFMTVP':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QVBZSFMTVP",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg05,"+"default",l_session)+"'"+"]");
      status.out.print(",'HBPZQIPSZE':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"HBPZQIPSZE",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'SSYXHQXJLD':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SSYXHQXJLD",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbmacage,"+"default",l_session)+"'"+"]");
      status.out.print(",'UYHOJSIFEU':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"UYHOJSIFEU",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'RUMXLFCOKA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbvalute,"+"default",l_session)+"'"+"]");
      status.out.print(",'CKJQULDXKW':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbdurata,"+"default",l_session)+"'"+"]");
      status.out.print(",'VEAKSOSZMJ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbdurata_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'SXTYCPHBIM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbimporto,"+"default",l_session)+"'"+"]");
      status.out.print(",'FLHYCYAKON':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbimporto_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'QJSTZIPOQB':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog,"+"default",l_session)+"'"+"]");
      status.out.print(",'MDMTUJRAZF':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'SFFFOYOWNH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsvolgim,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZKJUEEUNAK':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsvolgim_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'NOBMPHKVTX':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbplauso,"+"default",l_session)+"'"+"]");
      status.out.print(",'EAWVSIWQBM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbplauso_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'DJOWYRMDDC':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtiporisc,"+"default",l_session)+"'"+"]");
      status.out.print(",'DTDVSGUEWE':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtiporisc_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'CANUTVNGFD':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg01,"+"default",l_session)+"'"+"]");
      status.out.print(",'IXGRJLAKIQ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg02,"+"default",l_session)+"'"+"]");
      status.out.print(",'NKIXCWZJHO':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg03,"+"default",l_session)+"'"+"]");
      status.out.print(",'JQLGHMLOKO':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg04,"+"default",l_session)+"'"+"]");
      status.out.print(",'QVBZSFMTVP':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcateg05,"+"default",l_session)+"'"+"]");
      status.out.print(",'HBPZQIPSZE':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'SSYXHQXJLD':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbmacage,"+"default",l_session)+"'"+"]");
      status.out.print(",'UYHOJSIFEU':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_anarap","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_anarap",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("Categorie"),"")) {
      status.quoteAndAppend("Categorie","hide","box");
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
    if (CPLib.eq(status.GetZoneAltInterface("Garantiti"),"")) {
      status.quoteAndAppend("Garantiti","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Dipendenza"),"")) {
      status.quoteAndAppend("Dipendenza","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Saldi"),"")) {
      status.quoteAndAppend("Saldi","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("SaldiCanali"),"")) {
      status.quoteAndAppend("SaldiCanali","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("AltriDati"),"")) {
      status.quoteAndAppend("AltriDati","hide","box");
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
  void WriteMainFormScript(armt_anarapBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_anarap',false);");
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
        status.out.println("if(c=Ctrl('AABRTCZWUY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BCLYMGMBLK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RUMXLFCOKA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RUMXLFCOKA_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WRZZQXZUXK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LSSRJEUOJW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VSHUPFYWOC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VASVGQZJGP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CKJQULDXKW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CKJQULDXKW_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MXYTQLATHC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SXTYCPHBIM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SXTYCPHBIM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KBIUAXUDXA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QJSTZIPOQB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QJSTZIPOQB_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UDAYHICPVB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SFFFOYOWNH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SFFFOYOWNH_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ETALZDRBSO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NOBMPHKVTX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NOBMPHKVTX_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QBTVZDKLCO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DJOWYRMDDC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DJOWYRMDDC_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RUWEXWJASG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SMVVFHCEHA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MXITFMGTNB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MXITFMGTNB_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QLLLNEUVYW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QLLLNEUVYW_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DOXBACRWUU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OXGBDTWKSX')) SetDisabled(c,true);");
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
        status.out.println("if(c=Ctrl('GIJHAKTZAN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HBPZQIPSZE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HBPZQIPSZE_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SSYXHQXJLD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SSYXHQXJLD_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YSBAKLZECK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UYHOJSIFEU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UYHOJSIFEU_ZOOM')) SetDisabled(c,true);");
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
      status.out.println("if (Ctrl('ZSYGOPYXSA')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('ZSYGOPYXSA',linkpc_url('ZSYGOPYXSA'));");
      status.out.println("}");
      status.out.println("if (Ctrl('XUXHMWVHFR')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('XUXHMWVHFR',linkpc_url('XUXHMWVHFR'));");
      status.out.println("}");
      status.out.println("if (Ctrl('BOCKZFOGBL')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('BOCKZFOGBL',linkpc_url('BOCKZFOGBL'));");
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
    status.out.println("if (Eq(name,'ardt_garantbo')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_garantbo")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_ae_saldianno_rap')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_ae_saldianno_rap")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_saldi_idp')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_saldi_idp")+"';");
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
      status.out.println("AutonumberApplet().SetETName('anarapbo');");
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
    status.out.println("// * --- armt_anarap");
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
  armt_anarapBO getBO(ServletStatus status) {
    armt_anarapBO BO = new armt_anarapBO(status.context);
    // gli op_ possono essere utilizzati dalla servlet anche prima di essere inizializzati
    BO.op_PRGIMPRAP = BO.w_PRGIMPRAP;
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_anarapBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("anarapbo",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_anarapBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_anarapBO BO) {
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
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbstati,CPSql.BuildSQLPhrase("ISO",BO.m_cPhName_tbstati,"","CODSTA"));
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",3,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("ISO"),"C",3,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("ISO"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var QBUCLWUNFT_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbrappogg,CPSql.BuildSQLPhrase("CODICE,DESCRI",BO.m_cPhName_tbrappogg,"",""));
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
    status.out.println("var LSSRJEUOJW_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_tbrisglob",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),BO,false);
    l_VQRHolder.LoadTempWhere("");
    l_VQRHolder.LoadTempOrderBy("CODICE");
    l_rsLoad = l_VQRHolder.GetResultSet(BO.m_Ctx);
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",1,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("CODICE"),"C",1,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var SMVVFHCEHA_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(armt_anarapBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_anarapbo;
    String l_cPhName = BO.m_cPhName_anarapbo;
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
      String l_cQueryFilter = armt_anarapBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_anarapbo+".RAPPORTO",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("anarapbo");
    String l_cPhName = CPSql.ManipulateTablePhName("anarapbo",l_cServer);
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
  void Query(ServletStatus status,armt_anarapBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_anarapBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_anarapbo,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_anarapbo,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_anarapBO BO) {
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
  void Edit(ServletStatus status,armt_anarapBO BO,SPParameterSource source) {
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
  void New(ServletStatus status,armt_anarapBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_anarapBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_anarapBO BO) {
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
  void EditLoad(ServletStatus status,armt_anarapBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_anarapBO BO,SPParameterSource source) {
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
  void DeleteMessage(ServletStatus status,armt_anarapBO BO,SPParameterSource source) {
    BO.Load(status.w_RAPPORTO);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_anarapBO BO) {
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
  void Discard(ServletStatus status,armt_anarapBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_anarapBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",680);
    item.put("w",1429);
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
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Intestatari \\/ Informazioni\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Operazioni \\/ Frazionate\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Deleghe su rapporto\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Garantiti\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Saldi AGE\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Saldi Canali Distributivi (MITSV)\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Dati Base,Intestatari / Informazioni,Operazioni / Frazionate,Deleghe su rapporto,Garantiti,Saldi AGE,Saldi Canali Distributivi (MITSV)");
    item.put("altInterfaceFor","armt_anarap");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"DatiBase\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Base\",\"h\":544,\"name\":\"DatiBase\",\"page\":1,\"shrinkable\":true,\"spuid\":\"YORQOIOBQN\",\"stretch\":true,\"tabindex\":6,\"title_caption\":\"Dati Base\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Rapporto\",\"h\":20,\"maxlength\":25,\"name\":\"RAPPORTO\",\"page\":1,\"spuid\":\"LXORWVRYJJ\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":162,\"x\":160,\"y\":16,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OICGZUOZYP\",\"page\":1,\"spuid\":\"OICGZUOZYP\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"Codice Rapporto:\",\"w\":148,\"x\":8,\"y\":20,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Descrizione\",\"h\":20,\"maxlength\":50,\"name\":\"DESCRAP\",\"page\":1,\"spuid\":\"AQAARAIPOR\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":328,\"x\":464,\"y\":16,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VEBJKDHMDC\",\"page\":1,\"spuid\":\"VEBJKDHMDC\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"Descrizione:\",\"w\":120,\"x\":340,\"y\":20,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"name\":\"button_KKXIPNXBWK\",\"page\":1,\"picker\":true,\"spuid\":\"KKXIPNXBWK\",\"tabindex\":13,\"type\":\"Button\",\"value\":\"Copia in 5.1\",\"w\":80,\"x\":920,\"y\":16,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Rapporto\",\"h\":20,\"maxlength\":1,\"name\":\"TIPORAP\",\"page\":1,\"spuid\":\"ZFOHYLVPYN\",\"tabindex\":12,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":424,\"x\":160,\"y\":40,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GDCHKTFQUK\",\"page\":1,\"spuid\":\"GDCHKTFQUK\",\"tabindex\":18,\"type\":\"Label\",\"value\":\"Tipo Rapporto:\",\"w\":148,\"x\":8,\"y\":44,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":2,\"name\":\"TIPOAG\",\"page\":1,\"spuid\":\"BHAVHLFPAC\",\"tabindex\":14,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":840,\"x\":160,\"y\":64,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CTCKWHZVTZ\",\"page\":1,\"spuid\":\"CTCKWHZVTZ\",\"tabindex\":27,\"type\":\"Label\",\"value\":\"Tipo Rap. Ag. Entrate:\",\"w\":148,\"x\":8,\"y\":70,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Per tipo rapporto 96\\/97\",\"h\":20,\"maxlength\":3,\"name\":\"ISOAGE\",\"page\":1,\"spuid\":\"QBUCLWUNFT\",\"tabindex\":15,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":96,\"x\":160,\"y\":88,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"IBAN\",\"h\":20,\"maxlength\":30,\"name\":\"IBAN\",\"page\":1,\"spuid\":\"WRZZQXZUXK\",\"tabindex\":25,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":304,\"y\":88,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WHSTCJKJTS\",\"page\":1,\"spuid\":\"WHSTCJKJTS\",\"tabindex\":102,\"type\":\"Label\",\"value\":\"IBAN:\",\"w\":148,\"x\":288,\"y\":352,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Non considerare per passaggio storico\\/cancellazione\",\"h\":21,\"label_text\":\"Non considerare per passaggio storico\\/cancellazione (comprese le operazioni collegate)\",\"maxlength\":2,\"name\":\"NOCANC\",\"page\":1,\"spuid\":\"GIJHAKTZAN\",\"tabindex\":111,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":480,\"x\":520,\"y\":88,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TQNAPDCWFY\",\"page\":1,\"spuid\":\"TQNAPDCWFY\",\"tabindex\":113,\"type\":\"Label\",\"value\":\"Per tipo 96\\/97:\",\"w\":104,\"x\":52,\"y\":92,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FYRUSHCQJD\",\"page\":1,\"spuid\":\"FYRUSHCQJD\",\"tabindex\":114,\"type\":\"Label\",\"value\":\"IBAN:\",\"w\":44,\"x\":256,\"y\":92,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Non inviare agenzia entrate\",\"h\":21,\"label_text\":\"Non inviare Agenzia Entrate\",\"maxlength\":2,\"name\":\"NOPROT\",\"page\":1,\"spuid\":\"AABRTCZWUY\",\"tabindex\":16,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":176,\"x\":672,\"y\":40,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Divisa\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"FLAGLIRE\",\"page\":1,\"spuid\":\"BCLYMGMBLK\",\"tabindex\":17,\"textlist\":\"Lire,Euro,Valuta Estera\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"L"+"'"+","+"'"+"E"+"'"+","+"'"+"V"+"'"+"\",\"w\":126,\"x\":160,\"y\":112,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Divisa\",\"h\":20,\"maxlength\":3,\"name\":\"VALUTA\",\"page\":1,\"picker\":true,\"spuid\":\"RUMXLFCOKA\",\"tabindex\":19,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":38,\"x\":384,\"y\":112,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OUQKLNQVMP\",\"page\":1,\"spuid\":\"OUQKLNQVMP\",\"tabindex\":20,\"type\":\"Label\",\"value\":\"Divisa:\",\"w\":148,\"x\":8,\"y\":116,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MILRATMPIJ\",\"page\":1,\"spuid\":\"MILRATMPIJ\",\"tabindex\":21,\"type\":\"Label\",\"value\":\"Codice Divisa:\",\"w\":93,\"x\":288,\"y\":116,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_XQILBJQNNS\",\"page\":1,\"spuid\":\"XQILBJQNNS\",\"tabindex\":24,\"type\":\"Label\",\"w\":552,\"x\":448,\"y\":116,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cod. Rapporto Oggettivo\",\"h\":20,\"maxlength\":3,\"name\":\"CODOGG\",\"page\":1,\"spuid\":\"LSSRJEUOJW\",\"tabindex\":26,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":624,\"x\":160,\"y\":136,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZVXDABBVZA\",\"page\":1,\"spuid\":\"ZVXDABBVZA\",\"tabindex\":103,\"type\":\"Label\",\"value\":\"Cod. Rapporto Oggettivo:\",\"w\":148,\"x\":8,\"y\":140,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":50,\"name\":\"NATURA\",\"page\":1,\"spuid\":\"VSHUPFYWOC\",\"tabindex\":30,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":560,\"x\":68,\"y\":192,\"zone\":\"pag1_1_8\",\"zonepath\":\"[1,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Visualizza possibili nature della relazione d"+"'"+"affari\",\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_ZBUITWBMLO\",\"page\":1,\"spuid\":\"ZBUITWBMLO\",\"src\":\"..\\/{\\\"Char\\\":\\\"59987\\\",\\\"Color\\\":\\\"\\\",\\\"FontName\\\":\\\"ZucchettiDevelopement\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"18\\\"}\",\"tabindex\":31,\"type\":\"Image\",\"w\":20,\"x\":628,\"y\":192,\"zone\":\"pag1_1_8\",\"zonepath\":\"[1,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BVGYBYGMJB\",\"page\":1,\"spuid\":\"BVGYBYGMJB\",\"tabindex\":107,\"type\":\"Label\",\"value\":\"Natura:\",\"w\":52,\"x\":12,\"y\":196,\"zone\":\"pag1_1_8\",\"zonepath\":\"[1,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":50,\"name\":\"SCOPO\",\"page\":1,\"spuid\":\"VASVGQZJGP\",\"tabindex\":32,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":560,\"x\":68,\"y\":216,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Visualizza possibili scopi della relazione d"+"'"+"affari\",\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_BXHLWVGOYO\",\"page\":1,\"spuid\":\"BXHLWVGOYO\",\"src\":\"..\\/{\\\"Char\\\":\\\"59987\\\",\\\"Color\\\":\\\"\\\",\\\"FontName\\\":\\\"ZucchettiDevelopement\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"18\\\"}\",\"tabindex\":33,\"type\":\"Image\",\"w\":20,\"x\":628,\"y\":216,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EWATRAIADP\",\"page\":1,\"spuid\":\"EWATRAIADP\",\"tabindex\":108,\"type\":\"Label\",\"value\":\"Scopo:\",\"w\":52,\"x\":12,\"y\":220,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_HBAROSDSIX\",\"page\":1,\"spuid\":\"HBAROSDSIX\",\"tabindex\":29,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"TIPOLOGIA E VALUTAZIONE RISCHIO (Ia DIRETTIVA)\",\"w\":992,\"x\":16,\"y\":168,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"DURAT\",\"page\":1,\"picker\":true,\"spuid\":\"CKJQULDXKW\",\"tabindex\":34,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":160,\"y\":264,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RFREQ\",\"page\":1,\"spuid\":\"MXYTQLATHC\",\"tabindex\":36,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":720,\"y\":264,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_NWFPTCEPRA\",\"page\":1,\"spuid\":\"NWFPTCEPRA\",\"tabindex\":64,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"TIPOLOGIA RISCHIO\",\"w\":440,\"x\":24,\"y\":243,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NFLJJHXTKY\",\"page\":1,\"spuid\":\"NFLJJHXTKY\",\"tabindex\":65,\"type\":\"Label\",\"value\":\"VALUTAZIONE\",\"w\":120,\"x\":640,\"y\":243,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZUVXJIZOSF\",\"page\":1,\"spuid\":\"ZUVXJIZOSF\",\"tabindex\":66,\"type\":\"Label\",\"value\":\"Frequenza:\",\"w\":140,\"x\":16,\"y\":268,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_QEXJCFPJBM\",\"page\":1,\"spuid\":\"QEXJCFPJBM\",\"tabindex\":69,\"type\":\"Label\",\"w\":472,\"x\":232,\"y\":268,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"#0CCDCD\",\"h\":44,\"name\":\"label_PLAWSVGZSR\",\"page\":1,\"spuid\":\"PLAWSVGZSR\",\"tabindex\":106,\"type\":\"Label\",\"value\":\"Es. Natura = Mutuo; Scopo = Acquisto beni di consumo\",\"w\":359,\"x\":649,\"y\":192,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"AMMONT\",\"page\":1,\"picker\":true,\"spuid\":\"SXTYCPHBIM\",\"tabindex\":37,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":160,\"y\":288,\"zone\":\"pag1_1_11\",\"zonepath\":\"[1,1,11]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LXNMWSOUMF\",\"page\":1,\"spuid\":\"LXNMWSOUMF\",\"tabindex\":67,\"type\":\"Label\",\"value\":\"Importo:\",\"w\":140,\"x\":16,\"y\":292,\"zone\":\"pag1_1_11\",\"zonepath\":\"[1,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_BCFLBBQSRN\",\"page\":1,\"spuid\":\"BCFLBBQSRN\",\"tabindex\":68,\"type\":\"Label\",\"w\":416,\"x\":232,\"y\":292,\"zone\":\"pag1_1_11\",\"zonepath\":\"[1,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RIMP\",\"page\":1,\"spuid\":\"KBIUAXUDXA\",\"tabindex\":39,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":720,\"y\":288,\"zone\":\"pag1_1_12\",\"zonepath\":\"[1,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"AREAGEO\",\"page\":1,\"picker\":true,\"spuid\":\"QJSTZIPOQB\",\"tabindex\":40,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":160,\"y\":312,\"zone\":\"pag1_1_13\",\"zonepath\":\"[1,1,13]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NAVNOGNZNE\",\"page\":1,\"spuid\":\"NAVNOGNZNE\",\"tabindex\":52,\"type\":\"Label\",\"value\":\"Area Geografica:\",\"w\":140,\"x\":16,\"y\":316,\"zone\":\"pag1_1_13\",\"zonepath\":\"[1,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_CMKJDFEFFI\",\"page\":1,\"spuid\":\"CMKJDFEFFI\",\"tabindex\":60,\"type\":\"Label\",\"w\":416,\"x\":232,\"y\":316,\"zone\":\"pag1_1_13\",\"zonepath\":\"[1,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RAREA\",\"page\":1,\"spuid\":\"UDAYHICPVB\",\"tabindex\":42,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":720,\"y\":312,\"zone\":\"pag1_1_14\",\"zonepath\":\"[1,1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"MODSVOL\",\"page\":1,\"picker\":true,\"spuid\":\"SFFFOYOWNH\",\"tabindex\":43,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":160,\"y\":336,\"zone\":\"pag1_1_15\",\"zonepath\":\"[1,1,15]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LHTXLTQYIK\",\"page\":1,\"spuid\":\"LHTXLTQYIK\",\"tabindex\":53,\"type\":\"Label\",\"value\":\"Svol. Instaurazione Rapp.:\",\"w\":140,\"x\":16,\"y\":340,\"zone\":\"pag1_1_15\",\"zonepath\":\"[1,1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_DXOTWSGBKN\",\"page\":1,\"spuid\":\"DXOTWSGBKN\",\"tabindex\":61,\"type\":\"Label\",\"w\":416,\"x\":232,\"y\":340,\"zone\":\"pag1_1_15\",\"zonepath\":\"[1,1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RCOMP\",\"page\":1,\"spuid\":\"ETALZDRBSO\",\"tabindex\":45,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":720,\"y\":336,\"zone\":\"pag1_1_16\",\"zonepath\":\"[1,1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"RAGIO\",\"page\":1,\"picker\":true,\"spuid\":\"NOBMPHKVTX\",\"tabindex\":46,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":160,\"y\":360,\"zone\":\"pag1_1_17\",\"zonepath\":\"[1,1,17]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HGXSBHTFKF\",\"page\":1,\"spuid\":\"HGXSBHTFKF\",\"tabindex\":54,\"type\":\"Label\",\"value\":\"Ragionevolezza Rapporto:\",\"w\":140,\"x\":16,\"y\":364,\"zone\":\"pag1_1_17\",\"zonepath\":\"[1,1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_FXHEISJAJE\",\"page\":1,\"spuid\":\"FXHEISJAJE\",\"tabindex\":62,\"type\":\"Label\",\"w\":416,\"x\":232,\"y\":364,\"zone\":\"pag1_1_17\",\"zonepath\":\"[1,1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RRAGIO\",\"page\":1,\"spuid\":\"QBTVZDKLCO\",\"tabindex\":48,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":720,\"y\":360,\"zone\":\"pag1_1_18\",\"zonepath\":\"[1,1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"TIPO\",\"page\":1,\"picker\":true,\"spuid\":\"DJOWYRMDDC\",\"tabindex\":49,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":160,\"y\":384,\"zone\":\"pag1_1_19\",\"zonepath\":\"[1,1,19]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OKFGBGYVWD\",\"page\":1,\"spuid\":\"OKFGBGYVWD\",\"tabindex\":55,\"type\":\"Label\",\"value\":\"Tipo di rischio:\",\"w\":140,\"x\":16,\"y\":388,\"zone\":\"pag1_1_19\",\"zonepath\":\"[1,1,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_GHHOMNKDDQ\",\"page\":1,\"spuid\":\"GHHOMNKDDQ\",\"tabindex\":63,\"type\":\"Label\",\"w\":416,\"x\":232,\"y\":388,\"zone\":\"pag1_1_19\",\"zonepath\":\"[1,1,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RTIPO\",\"page\":1,\"spuid\":\"RUWEXWJASG\",\"tabindex\":51,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":720,\"y\":384,\"zone\":\"pag1_1_20\",\"zonepath\":\"[1,1,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Rischio Globale\",\"h\":20,\"maxlength\":1,\"name\":\"RISGLOB\",\"page\":1,\"spuid\":\"SMVVFHCEHA\",\"tabindex\":73,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":344,\"x\":160,\"y\":408,\"zone\":\"pag1_1_21\",\"zonepath\":\"[1,1,21]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JKZZQYXAFS\",\"page\":1,\"spuid\":\"JKZZQYXAFS\",\"tabindex\":104,\"type\":\"Label\",\"value\":\"Rischio Globale:\",\"w\":140,\"x\":16,\"y\":412,\"zone\":\"pag1_1_21\",\"zonepath\":\"[1,1,21]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Profilatura\",\"h\":20,\"maxlength\":10,\"name\":\"DATAPROF\",\"page\":1,\"picker\":true,\"spuid\":\"MXITFMGTNB\",\"tabindex\":74,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":160,\"y\":432,\"zone\":\"pag1_1_22\",\"zonepath\":\"[1,1,22]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TTZXYWANKG\",\"page\":1,\"spuid\":\"TTZXYWANKG\",\"tabindex\":110,\"type\":\"Label\",\"value\":\"Data Profilatura:\",\"w\":140,\"x\":16,\"y\":436,\"zone\":\"pag1_1_22\",\"zonepath\":\"[1,1,22]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Revisione Profilatura\",\"h\":20,\"maxlength\":10,\"name\":\"DATAREVPROF\",\"page\":1,\"picker\":true,\"spuid\":\"QLLLNEUVYW\",\"tabindex\":75,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":472,\"y\":432,\"zone\":\"pag1_1_23\",\"zonepath\":\"[1,1,23]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ROVJICRYAM\",\"page\":1,\"spuid\":\"ROVJICRYAM\",\"tabindex\":109,\"type\":\"Label\",\"value\":\"Data Revisione Profilatura:\",\"w\":141,\"x\":328,\"y\":436,\"zone\":\"pag1_1_23\",\"zonepath\":\"[1,1,23]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"name\":\"button_ZFPXBMEPWE\",\"page\":1,\"picker\":true,\"spuid\":\"ZFPXBMEPWE\",\"tabindex\":112,\"type\":\"Button\",\"value\":\"Calcola\",\"w\":144,\"x\":592,\"y\":432,\"zone\":\"pag1_1_23\",\"zonepath\":\"[1,1,23]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_CPZDORVHLG\",\"page\":1,\"spuid\":\"CPZDORVHLG\",\"tabindex\":80,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"MITIGAZIONE RISCHIO\",\"w\":992,\"x\":16,\"y\":464,\"zone\":\"pag1_1_24\",\"zonepath\":\"[1,1,24]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Mitigazione (+\\/-)\",\"h\":20,\"maxlength\":5,\"name\":\"MITIG\",\"page\":1,\"spuid\":\"DOXBACRWUU\",\"tabindex\":76,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":168,\"y\":488,\"zone\":\"pag1_1_25\",\"zonepath\":\"[1,1,25]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_NKPWKMDXUR\",\"page\":1,\"spuid\":\"NKPWKMDXUR\",\"tabindex\":78,\"type\":\"Label\",\"value\":\"%\",\"w\":22,\"x\":211,\"y\":492,\"zone\":\"pag1_1_25\",\"zonepath\":\"[1,1,25]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VCBMHLXJMD\",\"page\":1,\"spuid\":\"VCBMHLXJMD\",\"tabindex\":79,\"type\":\"Label\",\"value\":\"Mitigazione (+\\/-):\",\"w\":128,\"x\":37,\"y\":492,\"zone\":\"pag1_1_25\",\"zonepath\":\"[1,1,25]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PKJNNGBWFM\",\"page\":1,\"spuid\":\"PKJNNGBWFM\",\"tabindex\":72,\"type\":\"Label\",\"value\":\"Documentazione Mitigazione:\",\"w\":152,\"x\":13,\"y\":516,\"zone\":\"pag1_1_26\",\"zonepath\":\"[1,1,26]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Documentazione Mitigazione\",\"h\":20,\"maxlength\":100,\"name\":\"MITGDOC\",\"page\":1,\"spuid\":\"OXGBDTWKSX\",\"tabindex\":77,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":600,\"x\":168,\"y\":512,\"zone\":\"pag1_1_26\",\"zonepath\":\"[1,1,26]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":90,\"name\":\"titolo\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"QGMBPIURNH\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":1384,\"y\":8,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"disabled\":\"true\",\"h\":20,\"maxlength\":5,\"name\":\"DURAT\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"VEAKSOSZMJ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":1224,\"y\":248,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"disabled\":\"true\",\"h\":20,\"maxlength\":5,\"name\":\"AMMONT\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"FLHYCYAKON\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":1224,\"y\":272,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"disabled\":\"true\",\"h\":20,\"maxlength\":5,\"name\":\"AREAGEO\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"MDMTUJRAZF\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":1224,\"y\":296,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"disabled\":\"true\",\"h\":20,\"maxlength\":5,\"name\":\"MODSVOL\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"ZKJUEEUNAK\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":1224,\"y\":320,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"disabled\":\"true\",\"h\":20,\"maxlength\":5,\"name\":\"RAGIO\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"EAWVSIWQBM\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":1224,\"y\":344,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"TIPO\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"DTDVSGUEWE\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":1224,\"y\":368,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Categorie\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Categorie\",\"h\":123,\"name\":\"Categorie\",\"page\":1,\"shrinkable\":true,\"spuid\":\"RFAIYHSGII\",\"stretch\":true,\"tabindex\":7,\"title_caption\":\"Categorie\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":552,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Categoria 1\",\"h\":20,\"maxlength\":2,\"name\":\"CATEG01\",\"page\":1,\"picker\":true,\"spuid\":\"CANUTVNGFD\",\"tabindex\":81,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":176,\"y\":554,\"zone\":\"pag1_9_1\",\"zonepath\":\"[1,9,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_NRWNAJJVRA\",\"page\":1,\"spuid\":\"NRWNAJJVRA\",\"tabindex\":82,\"type\":\"Label\",\"w\":488,\"x\":232,\"y\":558,\"zone\":\"pag1_9_1\",\"zonepath\":\"[1,9,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WWRYOVTMFY\",\"page\":1,\"spuid\":\"WWRYOVTMFY\",\"tabindex\":83,\"type\":\"Label\",\"value\":\"Categoria 1:\",\"w\":157,\"x\":16,\"y\":558,\"zone\":\"pag1_9_1\",\"zonepath\":\"[1,9,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Categoria 2\",\"h\":20,\"maxlength\":2,\"name\":\"CATEG02\",\"page\":1,\"picker\":true,\"spuid\":\"IXGRJLAKIQ\",\"tabindex\":84,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":176,\"y\":578,\"zone\":\"pag1_9_2\",\"zonepath\":\"[1,9,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_LNOFOPAOYD\",\"page\":1,\"spuid\":\"LNOFOPAOYD\",\"tabindex\":85,\"type\":\"Label\",\"w\":488,\"x\":232,\"y\":582,\"zone\":\"pag1_9_2\",\"zonepath\":\"[1,9,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HNQZARYXGS\",\"page\":1,\"spuid\":\"HNQZARYXGS\",\"tabindex\":86,\"type\":\"Label\",\"value\":\"Categoria 2:\",\"w\":157,\"x\":16,\"y\":582,\"zone\":\"pag1_9_2\",\"zonepath\":\"[1,9,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Categoria 3\",\"h\":20,\"maxlength\":2,\"name\":\"CATEG03\",\"page\":1,\"picker\":true,\"spuid\":\"NKIXCWZJHO\",\"tabindex\":87,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":176,\"y\":602,\"zone\":\"pag1_9_3\",\"zonepath\":\"[1,9,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_WBTKNDJDFF\",\"page\":1,\"spuid\":\"WBTKNDJDFF\",\"tabindex\":88,\"type\":\"Label\",\"w\":488,\"x\":232,\"y\":606,\"zone\":\"pag1_9_3\",\"zonepath\":\"[1,9,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BGEVFUGGOS\",\"page\":1,\"spuid\":\"BGEVFUGGOS\",\"tabindex\":89,\"type\":\"Label\",\"value\":\"Categoria 3:\",\"w\":157,\"x\":16,\"y\":606,\"zone\":\"pag1_9_3\",\"zonepath\":\"[1,9,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Categoria 1\",\"h\":20,\"maxlength\":2,\"name\":\"CATEG04\",\"page\":1,\"picker\":true,\"spuid\":\"JQLGHMLOKO\",\"tabindex\":90,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":176,\"y\":626,\"zone\":\"pag1_9_4\",\"zonepath\":\"[1,9,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_MWCFKQVNHF\",\"page\":1,\"spuid\":\"MWCFKQVNHF\",\"tabindex\":91,\"type\":\"Label\",\"w\":488,\"x\":232,\"y\":630,\"zone\":\"pag1_9_4\",\"zonepath\":\"[1,9,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RHXCIUHRTU\",\"page\":1,\"spuid\":\"RHXCIUHRTU\",\"tabindex\":92,\"type\":\"Label\",\"value\":\"Categoria 4:\",\"w\":157,\"x\":16,\"y\":630,\"zone\":\"pag1_9_4\",\"zonepath\":\"[1,9,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Categoria 1\",\"h\":20,\"maxlength\":2,\"name\":\"CATEG05\",\"page\":1,\"picker\":true,\"spuid\":\"QVBZSFMTVP\",\"tabindex\":93,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":176,\"y\":650,\"zone\":\"pag1_9_5\",\"zonepath\":\"[1,9,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_HADVHTQAPE\",\"page\":1,\"spuid\":\"HADVHTQAPE\",\"tabindex\":94,\"type\":\"Label\",\"w\":488,\"x\":232,\"y\":654,\"zone\":\"pag1_9_5\",\"zonepath\":\"[1,9,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GRCYFEKJWU\",\"page\":1,\"spuid\":\"GRCYFEKJWU\",\"tabindex\":95,\"type\":\"Label\",\"value\":\"Categoria 5:\",\"w\":157,\"x\":16,\"y\":654,\"zone\":\"pag1_9_5\",\"zonepath\":\"[1,9,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"DatiBase\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Base\",\"h\":592,\"name\":\"DatiBase\",\"page\":2,\"shrinkable\":true,\"spuid\":\"GJZISGEBVV\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Dati Base\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag2_1\",\"zonepath\":\"[2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":24,\"name\":\"button_QIETKIRGON\",\"page\":2,\"picker\":true,\"spuid\":\"QIETKIRGON\",\"tabindex\":4,\"type\":\"Button\",\"value\":\"Crea Informazioni 31 e 32\",\"w\":157,\"x\":608,\"y\":8,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":272,\"name\":\"Intestatari\",\"page\":2,\"spuid\":\"XCLJCOLAOK\",\"src\":\"\\/jsp\\/pg_intestbo_portlet.jsp?ForcedPortletUID=XCLJCOLAOK\",\"tabindex\":2,\"type\":\"Portlet\",\"w\":1000,\"x\":8,\"y\":48,\"zone\":\"pag2_1_2\",\"zonepath\":\"[2,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":248,\"name\":\"Informazioni\",\"page\":2,\"spuid\":\"NXJPOCJGET\",\"src\":\"\\/jsp\\/pg_rapopebo_portlet.jsp?ForcedPortletUID=NXJPOCJGET\",\"tabindex\":3,\"type\":\"Portlet\",\"w\":1000,\"x\":8,\"y\":328,\"zone\":\"pag2_1_3\",\"zonepath\":\"[2,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Rapporto\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Rapporto e Operazioni\",\"h\":592,\"name\":\"Rapporto\",\"page\":3,\"shrinkable\":true,\"spuid\":\"LZCEHELAXJ\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Rapporto e Operazioni\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag3_1\",\"zonepath\":\"[3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":280,\"name\":\"Operazioni\",\"page\":3,\"spuid\":\"VNBQZVXZTE\",\"src\":\"\\/jsp\\/pg_operazbo_rap_portlet.jsp?ForcedPortletUID=VNBQZVXZTE\",\"tabindex\":3,\"type\":\"Portlet\",\"w\":1000,\"x\":8,\"y\":8,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":288,\"name\":\"Frazionate\",\"page\":3,\"spuid\":\"POJFSMHRKX\",\"src\":\"\\/jsp\\/pg_fraziobo_rap_portlet.jsp?ForcedPortletUID=POJFSMHRKX\",\"tabindex\":4,\"type\":\"Portlet\",\"w\":1000,\"x\":8,\"y\":296,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Deleghe\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Deleghe\",\"h\":408,\"name\":\"Deleghe\",\"page\":4,\"shrinkable\":true,\"spuid\":\"EHSQLOIDHO\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Deleghe\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag4_1\",\"zonepath\":\"[4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":392,\"name\":\"Delegati\",\"page\":4,\"spuid\":\"TVOFPFUAEZ\",\"src\":\"\\/jsp\\/pg_delegabo_portlet.jsp?ForcedPortletUID=TVOFPFUAEZ\",\"tabindex\":2,\"type\":\"Portlet\",\"w\":1000,\"x\":8,\"y\":8,\"zone\":\"pag4_1_1\",\"zonepath\":\"[4,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Garantiti\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Garantiti\",\"h\":344,\"name\":\"Garantiti\",\"page\":5,\"shrinkable\":true,\"spuid\":\"LWDMGLAEON\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Garantiti\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":8,\"zone\":\"pag5_1\",\"zonepath\":\"[5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":335,\"name\":\"ardt_garantbo\",\"page\":5,\"spuid\":\"ZSYGOPYXSA\",\"tabindex\":2,\"type\":\"Iframe\",\"w\":796,\"x\":16,\"y\":8,\"zone\":\"pag5_1_1\",\"zonepath\":\"[5,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Dipendenza\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dipendenza Riferimento\",\"h\":39,\"name\":\"Dipendenza\",\"page\":5,\"shrinkable\":true,\"spuid\":\"TUIMYVJMXF\",\"stretch\":true,\"tabindex\":3,\"title_caption\":\"Dipendenza Riferimento\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":353,\"zone\":\"pag5_2\",\"zonepath\":\"[5,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_TEKSYGREXN\",\"page\":5,\"spuid\":\"TEKSYGREXN\",\"tabindex\":5,\"type\":\"Label\",\"w\":448,\"x\":221,\"y\":366,\"zone\":\"pag5_2_1\",\"zonepath\":\"[5,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Dipendeza Riferimento\",\"h\":20,\"maxlength\":6,\"name\":\"CODDIPE\",\"page\":5,\"picker\":true,\"spuid\":\"HBPZQIPSZE\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":140,\"y\":362,\"zone\":\"pag5_2_1\",\"zonepath\":\"[5,2,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CBLDNZTZNA\",\"page\":5,\"spuid\":\"CBLDNZTZNA\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"Dipendenza Riferimento:\",\"w\":129,\"x\":8,\"y\":366,\"zone\":\"pag5_2_1\",\"zonepath\":\"[5,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Saldi\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Saldi\",\"h\":602,\"name\":\"Saldi\",\"page\":6,\"shrinkable\":true,\"spuid\":\"MUCCIMEJEB\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Saldi\",\"titled\":true,\"type\":\"Box\",\"w\":824,\"x\":8,\"y\":4,\"zone\":\"pag6_1\",\"zonepath\":\"[6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":335,\"name\":\"ardt_ae_saldianno_rap\",\"page\":6,\"spuid\":\"XUXHMWVHFR\",\"tabindex\":2,\"type\":\"Iframe\",\"w\":647,\"x\":88,\"y\":137,\"zone\":\"pag6_1_1\",\"zonepath\":\"[6,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"SaldiCanali\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Saldi\",\"h\":352,\"name\":\"SaldiCanali\",\"page\":7,\"shrinkable\":true,\"spuid\":\"GURCMCSTQS\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Saldi\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":8,\"y\":8,\"zone\":\"pag7_1\",\"zonepath\":\"[7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":335,\"name\":\"ardt_saldi_idp\",\"page\":7,\"spuid\":\"BOCKZFOGBL\",\"tabindex\":2,\"type\":\"Iframe\",\"w\":335,\"x\":208,\"y\":16,\"zone\":\"pag7_1_1\",\"zonepath\":\"[7,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"AltriDati\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Altri Dati\",\"h\":88,\"name\":\"AltriDati\",\"page\":7,\"shrinkable\":true,\"spuid\":\"PHCJDNQLLF\",\"stretch\":true,\"tabindex\":3,\"title_caption\":\"Altri Dati\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":8,\"y\":368,\"zone\":\"pag7_2\",\"zonepath\":\"[7,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Macro Agente\",\"h\":20,\"maxlength\":5,\"name\":\"MACODICE\",\"page\":7,\"picker\":true,\"spuid\":\"SSYXHQXJLD\",\"tabindex\":4,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":149,\"y\":379,\"zone\":\"pag7_2_1\",\"zonepath\":\"[7,2,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JIHVKRMSZD\",\"page\":7,\"spuid\":\"JIHVKRMSZD\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"Macro Agente:\",\"w\":128,\"x\":16,\"y\":383,\"zone\":\"pag7_2_1\",\"zonepath\":\"[7,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_TWSRQQLPNA\",\"page\":7,\"spuid\":\"TWSRQQLPNA\",\"tabindex\":8,\"type\":\"Label\",\"w\":440,\"x\":229,\"y\":383,\"zone\":\"pag7_2_1\",\"zonepath\":\"[7,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Customer ID (WUBS)\",\"h\":20,\"maxlength\":15,\"name\":\"SPLITCODE\",\"page\":7,\"spuid\":\"YSBAKLZECK\",\"tabindex\":5,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":149,\"y\":403,\"zone\":\"pag7_2_2\",\"zonepath\":\"[7,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FFCVEAIHJV\",\"page\":7,\"spuid\":\"FFCVEAIHJV\",\"tabindex\":6,\"type\":\"Label\",\"value\":\"Customer ID (WUIB):\",\"w\":128,\"x\":16,\"y\":407,\"zone\":\"pag7_2_2\",\"zonepath\":\"[7,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Legale Rappresentante\",\"h\":20,\"maxlength\":16,\"name\":\"CODICELR\",\"page\":7,\"picker\":true,\"spuid\":\"UYHOJSIFEU\",\"tabindex\":9,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":120,\"x\":149,\"y\":427,\"zone\":\"pag7_2_3\",\"zonepath\":\"[7,2,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XDJAPZOPHJ\",\"page\":7,\"spuid\":\"XDJAPZOPHJ\",\"tabindex\":10,\"type\":\"Label\",\"value\":\"Legale Rappresentante:\",\"w\":127,\"x\":17,\"y\":431,\"zone\":\"pag7_2_3\",\"zonepath\":\"[7,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_CQBNLOGUOF\",\"page\":7,\"spuid\":\"CQBNLOGUOF\",\"tabindex\":11,\"type\":\"Label\",\"w\":472,\"x\":293,\"y\":431,\"zone\":\"pag7_2_3\",\"zonepath\":\"[7,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_anarapBO BO,ServletStatus status) {
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
     "<script src='armt_anarap?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_anarap_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_anarap_edit.js'>" +
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
      status.out.println("w_RAPPORTO=a[1];");
      status.out.println("w_DESCRAP=a[2];");
      status.out.println("w_TIPORAP=a[3];");
      status.out.println("w_TIPOAG=a[4];");
      status.out.println("w_ISOAGE=a[5];");
      status.out.println("w_NOPROT=a[6];");
      status.out.println("w_FLAGLIRE=a[7];");
      status.out.println("w_VALUTA=a[8];");
      status.out.println("w_PRGIMPRAP=a[9];");
      status.out.println("op_PRGIMPRAP=a[10];");
      status.out.println("w_IBAN=a[11];");
      status.out.println("w_CODOGG=a[12];");
      status.out.println("w_NATURA=a[13];");
      status.out.println("w_SCOPO=a[14];");
      status.out.println("w_DURAT=a[15];");
      status.out.println("w_RFREQ=a[16];");
      status.out.println("w_AMMONT=a[17];");
      status.out.println("w_RIMP=a[18];");
      status.out.println("w_AREAGEO=a[19];");
      status.out.println("w_RAREA=a[20];");
      status.out.println("w_MODSVOL=a[21];");
      status.out.println("w_RCOMP=a[22];");
      status.out.println("w_RAGIO=a[23];");
      status.out.println("w_RRAGIO=a[24];");
      status.out.println("w_TIPO=a[25];");
      status.out.println("w_RTIPO=a[26];");
      status.out.println("w_CODDIPE=a[27];");
      status.out.println("w_RISGLOB=a[28];");
      status.out.println("w_DATAPROF=a[29];");
      status.out.println("w_DATAREVPROF=a[30];");
      status.out.println("w_MITIG=a[31];");
      status.out.println("w_MITGDOC=a[32];");
      status.out.println("w_CATEG01=a[33];");
      status.out.println("w_CATEG02=a[34];");
      status.out.println("w_CATEG03=a[35];");
      status.out.println("w_CATEG04=a[36];");
      status.out.println("w_CATEG05=a[37];");
      status.out.println("w_CATEGORIA=a[38];");
      status.out.println("w_NOCANC=a[39];");
      status.out.println("w_MACODICE=a[40];");
      status.out.println("w_SPLITCODE=a[41];");
      status.out.println("w_CODICELR=a[42];");
      status.out.println("w_gTipInter=a[43];");
      status.out.println("w_gBrowser=a[44];");
      status.out.println("w_gTelepass=a[45];");
      status.out.println("w_gCodDip=a[46];");
      status.out.println("w_descval=a[47];");
      status.out.println("w_daticoll=a[48];");
      status.out.println("w_xdescmodsvo=a[49];");
      status.out.println("w_xdescareag=a[50];");
      status.out.println("w_xdescplauso=a[51];");
      status.out.println("w_xdesctipor=a[52];");
      status.out.println("w_xdescfreq=a[53];");
      status.out.println("w_xdescammo=a[54];");
      status.out.println("w_xDESDIPE=a[55];");
      status.out.println("w_xMADESCRI=a[56];");
      status.out.println("w_xRAGLEG=a[57];");
      status.out.println("w_mess=a[58];");
      status.out.println("w_xC1DESCRI=a[59];");
      status.out.println("w_xC2DESCRI=a[60];");
      status.out.println("w_xC3DESCRI=a[61];");
      status.out.println("w_xC4DESCRI=a[62];");
      status.out.println("w_xC5DESCRI=a[63];");
      status.out.println("w_titolo=a[64];");
      status.out.println("op_codazi=a[65];");
      status.out.println("o_RFAIYHSGII_expand=null;");
      status.out.println("o_RFAIYHSGII_collapse=null;");
      status.out.println("m_cWv_ardt_garantbo=a[66];");
      status.out.println("m_cWv_ardt_ae_saldianno_rap=a[67];");
      status.out.println("m_cWv_ardt_saldi_idp=a[68];");
      status.out.println("if (Gt(a.length,69)) {");
      status.out.println("m_cErrorInChild='';");
      status.out.println("}");
      status.out.println("if (Gt(a.length,69)) {");
      status.out.println("o_TIPOAG=w_TIPOAG;");
      status.out.println("o_FLAGLIRE=w_FLAGLIRE;");
      status.out.println("o_VALUTA=w_VALUTA;");
      status.out.println("o_DURAT=w_DURAT;");
      status.out.println("o_AMMONT=w_AMMONT;");
      status.out.println("o_AREAGEO=w_AREAGEO;");
      status.out.println("o_MODSVOL=w_MODSVOL;");
      status.out.println("o_RAGIO=w_RAGIO;");
      status.out.println("o_TIPO=w_TIPO;");
      status.out.println("o_CATEG01=w_CATEG01;");
      status.out.println("o_CATEG02=w_CATEG02;");
      status.out.println("o_CATEG03=w_CATEG03;");
      status.out.println("o_CATEG04=w_CATEG04;");
      status.out.println("o_CATEG05=w_CATEG05;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['RAPPORTO'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_anarap_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(597,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","anarapbo");
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
  void RaiseLoadedEntity(armt_anarapBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({RAPPORTO:"+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_anarapBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(armt_anarapBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(armt_anarapBO BO,ServletStatus status) {
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
  void WriteExitPage(armt_anarapBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({RAPPORTO:"+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_anarapBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_anarapBO BO,ServletStatus status) throws IOException {
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
    status.out.println(
     "<script src='SPPrxy/"+arrt_calcola_datarevprof_rap.m_cEntityUid+"/arrt_calcola_datarevprof_rap.js'>" +
     "</script>" +
    "");
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
      arrt_calcola_datarevprof_rap.GetCallableNames(callable);
      fwfn_calc_categoria.GetCallableNames(callable);
      CPLib.AddToSet(callable,"LibreriaMit");
      CPLib.AddToSet(callable,"Utilities");
      CPLib.AddToSet(callable,"arrt_crea_3132");
      CPLib.AddToSet(callable,"ardt_garantbo");
      CPLib.AddToSet(callable,"ardt_ae_saldianno_rap");
      CPLib.AddToSet(callable,"ardt_saldi_idp");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_anarapBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_RAPPORTO),"C",25,0));
      }
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gTipInter),"C",2,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gBrowser),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gTelepass),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gCodDip),"C",6,0));
    } else if (CPLib.eq(p_cUID,"RUMXLFCOKA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"CKJQULDXKW")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"VEAKSOSZMJ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SXTYCPHBIM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"FLHYCYAKON")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"QJSTZIPOQB")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"MDMTUJRAZF")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SFFFOYOWNH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ZKJUEEUNAK")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NOBMPHKVTX")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"EAWVSIWQBM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"DJOWYRMDDC")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"DTDVSGUEWE")) {
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
    } else if (CPLib.eq(p_cUID,"HBPZQIPSZE")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SSYXHQXJLD")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"UYHOJSIFEU")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_anarapBO BO) {
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
      if (result &&  ! (CPLib.Empty(BO.w_DURAT))) {
        a = GetCheckVars(status,BO,"CKJQULDXKW");
        b = status.m_CheckVars.optString("CKJQULDXKW");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DURAT))) {
        a = GetCheckVars(status,BO,"VEAKSOSZMJ");
        b = status.m_CheckVars.optString("VEAKSOSZMJ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_AMMONT))) {
        a = GetCheckVars(status,BO,"SXTYCPHBIM");
        b = status.m_CheckVars.optString("SXTYCPHBIM");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_AMMONT))) {
        a = GetCheckVars(status,BO,"FLHYCYAKON");
        b = status.m_CheckVars.optString("FLHYCYAKON");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_AREAGEO))) {
        a = GetCheckVars(status,BO,"QJSTZIPOQB");
        b = status.m_CheckVars.optString("QJSTZIPOQB");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_AREAGEO))) {
        a = GetCheckVars(status,BO,"MDMTUJRAZF");
        b = status.m_CheckVars.optString("MDMTUJRAZF");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_MODSVOL))) {
        a = GetCheckVars(status,BO,"SFFFOYOWNH");
        b = status.m_CheckVars.optString("SFFFOYOWNH");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_MODSVOL))) {
        a = GetCheckVars(status,BO,"ZKJUEEUNAK");
        b = status.m_CheckVars.optString("ZKJUEEUNAK");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_RAGIO))) {
        a = GetCheckVars(status,BO,"NOBMPHKVTX");
        b = status.m_CheckVars.optString("NOBMPHKVTX");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_RAGIO))) {
        a = GetCheckVars(status,BO,"EAWVSIWQBM");
        b = status.m_CheckVars.optString("EAWVSIWQBM");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_TIPO))) {
        a = GetCheckVars(status,BO,"DJOWYRMDDC");
        b = status.m_CheckVars.optString("DJOWYRMDDC");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_TIPO))) {
        a = GetCheckVars(status,BO,"DTDVSGUEWE");
        b = status.m_CheckVars.optString("DTDVSGUEWE");
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
      if (result &&  ! (CPLib.Empty(BO.w_CODDIPE))) {
        a = GetCheckVars(status,BO,"HBPZQIPSZE");
        b = status.m_CheckVars.optString("HBPZQIPSZE");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_MACODICE))) {
        a = GetCheckVars(status,BO,"SSYXHQXJLD");
        b = status.m_CheckVars.optString("SSYXHQXJLD");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CODICELR))) {
        a = GetCheckVars(status,BO,"UYHOJSIFEU");
        b = status.m_CheckVars.optString("UYHOJSIFEU");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
