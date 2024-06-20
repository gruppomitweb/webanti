import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_wutrxchk_aua extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*9087de11*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "wutrxchk";
    }
    public double w_TRXCODPRG;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_TRXCODPRG,context,"wutrxchk","TRXCODPRG","N",15,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='TRXCODPRG' type='hidden' value="+SPLib.ToHTMLValue(w_TRXCODPRG,"N",15,0)+">" +
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
    armt_wutrxchk_auaBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_wutrxchk;
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
      status.w_TRXCODPRG = BO.w_TRXCODPRG;
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
    return "Correzione Errori AUA (Import RTRA)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_wutrxchk_aua";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 1278;
    l_eg.m_nEntityHeight = 789;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.m_cZoomConfigName = "rtra_aua";
    l_eg.zoomableTables = new String[]{"wutrxchk","tbluonas","wutipdoc","anadip","tbmacage","tbstati","tbcitta"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","Dati Soggetto / Errori","page"),new ZoneItem("page_2","Dati Transazione","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"TRXCODPRG"};
    l_eg.items = new SPItem[]{
                   new SPItem("TRXCODPRG","N",15,0, "show","ID Transazione"),
                   new SPItem("TRXCOGNOM","C",50,0, "edit","Cognome"),
                   new SPItem("TRXNOME","C",50,0, "edit","Nome"),
                   new SPItem("TRXFLGCF","C",1,0, "edit","Flag Codice Fiscale"),
                   new SPItem("TRXCODFIS","C",16,0, "edit","Codice Ficale (reale)"),
                   new SPItem("TRXLUONAS","C",50,0, "edit","Luogo di nascita"),
                   new SPItem("TRXNUMDOC","C",30,0, "edit","Numero Documento"),
                   new SPItem("TRXDATSCA","D",8,0, "edit","Data Scadenza Documento"),
                   new SPItem("TRXDATRIL","D",8,0, "edit","Data Rilascio Documento"),
                   new SPItem("TRXTIPDOC","C",2,0, "edit","Tipo Documento"),
                   new SPItem("TRXMTCN","C",10,0, "show","MTCN Operazione"),
                   new SPItem("TRXDATNAS","D",8,0, "edit","Data Di Nascita"),
                   new SPItem("TRXDATOPE","D",8,0, "show","Data Operazione"),
                   new SPItem("TRXSESSO","C",1,0, "edit","Sesso"),
                   new SPItem("doctype","C",2,0, "show","Tipo Documento AUI"),
                   new SPItem("sesso","C",1,0, "hide",""),
                   new SPItem("TRXNASSTATO","C",40,0, "hide","Stato Nascita da Codice Fiscale"),
                   new SPItem("TRXNASCOMUN","C",40,0, "hide","Comune Nascita da Codice Fiscale"),
                   new SPItem("TRXFLGAUAQ1","C",1,0, "hide","Errori su Query 1"),
                   new SPItem("TRXFLGAUAQ2","C",1,0, "hide","Errori su Query 2"),
                   new SPItem("TRXFLGAUAQ3","C",1,0, "hide","Errori su Query 3"),
                   new SPItem("TRXFLGAUAQ4","C",1,0, "hide","Errori su Query 4"),
                   new SPItem("TRXFLGAUAQ5","C",1,0, "hide","Errori su Query 3Bis"),
                   new SPItem("TRXFLGAUA","C",1,0, "hide","OPERAZIONE CORRETTA AUI"),
                   new SPItem("TRXFLGFOR","C",1,0, "edit","FORZATURA INSERIMENTO"),
                   new SPItem("TRXFORCE","C",3,0, "edit","Motivazione Forzatura"),
                   new SPItem("TRXDATRICERCA","D",8,0, "hide","Data Filtro 12 Mesi"),
                   new SPItem("xTRXPROVINCIA","C",2,0, "show","Provincia Nascita"),
                   new SPItem("FLGDATIOLD","C",1,0, "edit",""),
                   new SPItem("xtipdoc","C",2,0, "edit",""),
                   new SPItem("xtnumdoc","C",15,0, "edit",""),
                   new SPItem("TRXTFINLAV","T",14,0, "edit","Ora Fine Lavorazione"),
                   new SPItem("TRDFINLAV","D",8,0, "edit","Data Fine Lavorazione"),
                   new SPItem("TRFLGINLAV","C",1,0, "edit","IN lavorazione"),
                   new SPItem("TRXFLGAUA","C",1,0, "edit","OPERAZIONE CORRETTA AUA"),
                   new SPItem("TRXESITO","C",1,0, "edit","Tipo Esito"),
                   new SPItem("TRXAUTRIL","C",50,0, "show","Autorità Rilascio Documento"),
                   new SPItem("xDESCRIZ","C",30,0, "show","Descrizione"),
                   new SPItem("TRXCODDIP","C",10,0, "show","Codice Agenzia"),
                   new SPItem("finalized","C",1,0, "edit",""),
                   new SPItem("TRXUTENTE","N",10,0, "hide","Codice Utente che lavora la transazione"),
                   new SPItem("TRFLGINLAV","C",1,0, "hide","IN lavorazione"),
                   new SPItem("TRXTINILAV","T",14,0, "hide","Ora Inizio Lavorazione"),
                   new SPItem("TRXDINILAV","D",8,0, "hide","Data Inizio Lavorazione"),
                   new SPItem("xluonas","C",50,0, "edit",""),
                   new SPItem("TRXFLGCON","C",1,0, "show","Flag Contanti"),
                   new SPItem("TRSSEGNO","C",1,0, "show","Segno (A=Send,D=Receive)"),
                   new SPItem("TRXIMPORTO","N",15,2, "show","Importo"),
                   new SPItem("TRXCONTAN","N",15,2, "show","Contante"),
                   new SPItem("TRXUNIQUE","C",10,0, "show","Unique ID"),
                   new SPItem("TRXCOGCON","C",100,0, "show","Cognome Controparte"),
                   new SPItem("TRXNOMCON","C",100,0, "show","Nome Controparte"),
                   new SPItem("TRXDESTIN","C",100,0, "show","Stato Controparte"),
                   new SPItem("TRXCODCAS","C",4,0, "show","Codice Catastale"),
                   new SPItem("TRXRECTYPE","C",1,0, "show","Tipo Record"),
                   new SPItem("TRXCODMAG","C",5,0, "show","Codice MacroAgente"),
                   new SPItem("TRXCODUNI","C",18,0, "show","Codice Univoco"),
                   new SPItem("xMADESCRI","C",60,0, "show","Denominazione"),
                   new SPItem("TRXNAZRES","C",50,0, "show","Nazione di Residenza"),
                   new SPItem("TRXCITRES","C",50,0, "show","Città Di residenza"),
                   new SPItem("TRXDOMICI","C",100,0, "show","Domicilio")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_wutrxchk_auaBO BO) {
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
    l_translations=new String[][]{{"10206540776",p_Context.Translate("Cognome Controparte")},
    {"1027280874",p_Context.Translate("Codice Agenzia")},
    {"10302116186",p_Context.Translate("Stato Controparte")},
    {"10372862555",p_Context.Translate("Comune Nascita da Codice Fiscale")},
    {"10613332584",p_Context.Translate("Data Rilascio Documento")},
    {"10613740320",p_Context.Translate("Data Inizio Lavorazione")},
    {"10623724530",p_Context.Translate("Tipo Documento AUI")},
    {"10677533139",p_Context.Translate("Errori su Query 3Bis")},
    {"10678032114",p_Context.Translate("Errori su Query 4")},
    {"10678032115",p_Context.Translate("Errori su Query 3")},
    {"10678032116",p_Context.Translate("Errori su Query 2")},
    {"10678032117",p_Context.Translate("Errori su Query 1")},
    {"10681623869",p_Context.Translate("Data Fine Lavorazione")},
    {"10703188046",p_Context.Translate("Data Di Nascita")},
    {"10759885763",p_Context.Translate("Numero Documento")},
    {"10782899903",p_Context.Translate("Codice Ficale (reale)")},
    {"10847907928",p_Context.Translate("Ora Fine Lavorazione")},
    {"10884427469",p_Context.Translate("Contante")},
    {"1114794632",p_Context.Translate("Codice MacroAgente")},
    {"11228111751",p_Context.Translate("Unique ID")},
    {"11283615582",p_Context.Translate("Macro Agenti")},
    {"11304457711",p_Context.Translate("Presenza Importo in contanti")},
    {"11364806308",p_Context.Translate("Stato Nascita da Codice Fiscale")},
    {"11380536119",p_Context.Translate("Ora Inizio Lavorazione")},
    {"11421032054",p_Context.Translate("ID Transazione")},
    {"11429032151",p_Context.Translate("Tipo Documento")},
    {"11443219662",p_Context.Translate("Provincia Nascita")},
    {"11446459032",p_Context.Translate("Correzione Operazione Completata")},
    {"11651685846",p_Context.Translate("IN lavorazione")},
    {"11702910273",p_Context.Translate("Codice Utente che lavora la transazione")},
    {"11706569101",p_Context.Translate("Tipo Record")},
    {"11778092844",p_Context.Translate("Codice Fiscale Dichiarato")},
    {"1181050665",p_Context.Translate("Correzione Errori AUA (Import RTRA)")},
    {"11817885686",p_Context.Translate("Dati acquisiti da record storici")},
    {"12056209762",p_Context.Translate("Denominazione")},
    {"12123333988",p_Context.Translate("Luogo di nascita")},
    {"125267528",p_Context.Translate("Tipo Esito")},
    {"1316049330",p_Context.Translate("Segno (A=Send,D=Receive)")},
    {"1405586570",p_Context.Translate("Flag Contanti")},
    {"15186643",p_Context.Translate("Città")},
    {"1539897768",p_Context.Translate("Impossibile salvare un soggetto nato in Italia senza codice fiscale")},
    {"1563406272",p_Context.Translate("Flag Codice Fiscale")},
    {"1636021524",p_Context.Translate("FORZATURA INSERIMENTO")},
    {"1813072817",p_Context.Translate("Agenzie")},
    {"1816546867",p_Context.Translate("Cognome")},
    {"1991862041",p_Context.Translate("Importo")},
    {"2115266609",p_Context.Translate("Codice Univoco")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"380127078",p_Context.Translate("Luoghi di Nascita")},
    {"423990228",p_Context.Translate("Codice Catastale")},
    {"433310806",p_Context.Translate("Non è possibile cancellare una transazione")},
    {"443454",p_Context.Translate("Nome")},
    {"468328536",p_Context.Translate("Forzatura inserimento dati")},
    {"485943447",p_Context.Translate("Nazione di Residenza")},
    {"49939619",p_Context.Translate("Domicilio")},
    {"517946066",p_Context.Translate("Nome Controparte")},
    {"551186813",p_Context.Translate("Data Filtro 12 Mesi")},
    {"553813303",p_Context.Translate("Finalizza")},
    {"580410781",p_Context.Translate("Città Di residenza")},
    {"628384699",p_Context.Translate("Data Scadenza Documento")},
    {"6887734",p_Context.Translate("Forza")},
    {"707662893",p_Context.Translate("Motivazione Forzatura")},
    {"753730945",p_Context.Translate("OPERAZIONE CORRETTA AUA")},
    {"7776675",p_Context.Translate("Sesso")},
    {"829110543",p_Context.Translate("MTCN Operazione")},
    {"829201110",p_Context.Translate("Data Operazione")},
    {"887948673",p_Context.Translate("OPERAZIONE CORRETTA AUI")},
    {"979125998",p_Context.Translate("Autorità Rilascio Documento")}};
    return l_translations;
  }
  void WriteStyles(armt_wutrxchk_auaBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_wutrxchk_aua.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_wutrxchk_auaBO BO,ServletStatus status) {
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
    status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati Soggetto / Errori"),"C",0,0)+"},{name:\"page_2\", element:\"page_2\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati Transazione"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
    status.out.println("Z.Tabs.Set('tabs',tabs);");
    status.out.println("} else {");
    status.out.println("var tabs = Z.Tabs.Get('tabs')");
    status.out.println("}");
    AddExtendedTabs(status);
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_wutrxchk_aua',false);");
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_wutrxchk_aua",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  // GetPortlet_Cases_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_CPEANLRGHT_Vars(armt_wutrxchk_auaBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"idtrx",CPLib.Str(BO.w_TRXCODPRG,15,0));
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"cognome",BO.w_TRXCOGNOM);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"nome",BO.w_TRXNOME);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"nascomun",BO.w_TRXNASCOMUN);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"sesso",BO.w_sesso);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"tipodoc",BO.w_doctype);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"numdocum",BO.w_TRXNUMDOC);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"codfisc",BO.w_TRXCODFIS);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"nasstato",BO.w_TRXNASSTATO);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"datanas",CPLib.DateToChar(BO.w_TRXDATNAS));
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"dataril",CPLib.DateToChar(BO.w_TRXDATRIL));
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"dataric",CPLib.DateToChar(BO.w_TRXDATRICERCA));
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"luonas",BO.w_TRXLUONAS);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addParameter(inclusionVars,"flgcnf",BO.w_TRXFLGCF);
    return inclusionVars;
  }
  void WriteControls(armt_wutrxchk_auaBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    WriteControls_p2(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,3);
  }
  void WriteControls_p1(armt_wutrxchk_auaBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:789px;width:1278px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"Dati Soggetto / Errori");
    PrintSidebarContent(1,status,getSidebarItems(0),false);
    PrintContextMenu(1,status,getContextMenu(0),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2(armt_wutrxchk_auaBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_2' class='PageContainer' style='position:relative;height:374px;width:1278px;display:none'>" +
    "");
    WriteControls_p2_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,2,"Dati Transazione");
    PrintSidebarContent(2,status,getSidebarItems(1),false);
    PrintContextMenu(2,status,getContextMenu(1),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b0(armt_wutrxchk_auaBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='position:relative;height:789px'>" +
    "");
    status.out.println(
     "<input name='TRXCODPRG' id='LPQRPTUZNB' type='text' class='Field PrimaryKeyField "+(CPLib.ne(status.m_cClientMode,"query")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_TRXCODPRG,"N",15,0,"999999999999999", status.m_oRegSettings)+" tabindex='-1' "+(CPLib.ne(status.m_cClientMode,"query")?"readonly":"")+" maxlength='18' size='15' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel PrimaryKeyLabel' id='NESFDLHKJF_DIV'>" +
     "<label id='NESFDLHKJF' for='LPQRPTUZNB'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("ID Transazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXCOGNOM' id='OAJHZGVXDW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXCOGNOM,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='COLILEINDD_DIV'>" +
     "<label id='COLILEINDD' for='OAJHZGVXDW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cognome:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXNOME' id='IJWHZPPSVS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXNOME,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JWSTZAKUTI_DIV'>" +
     "<label id='JWSTZAKUTI' for='IJWHZPPSVS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nome:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='GOZRBLFKLS_DIV'>" +
     "<input name='TRXFLGCF' id='GOZRBLFKLS' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_TRXFLGCF,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_TRXFLGCF))?"CHECKED":"")+">" +
     "<label id='GOZRBLFKLS_LBL' for='GOZRBLFKLS' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale Dichiarato"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXCODFIS' id='NIGZXFUTGU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXCODFIS,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HOQDCOUNGL_DIV'>" +
     "<label id='HOQDCOUNGL' for='NIGZXFUTGU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXLUONAS' id='CAICHGXWXW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXLUONAS,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C' autocomplete='off'>" +
     "<button id='CAICHGXWXW_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "CAICHGXWXW", "tbluonas", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='WHFMFQMGTQ_DIV'>" +
     "<label id='WHFMFQMGTQ' for='CAICHGXWXW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Luogo di nascita:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXNUMDOC' id='QWQZUBRCXK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXNUMDOC,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DKXGIHHVGO_DIV'>" +
     "<label id='DKXGIHHVGO' for='QWQZUBRCXK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Numero Documento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXDATSCA' id='EMCTEYNINS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXDATSCA,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
     "<button id='EMCTEYNINS_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TUGPOVJSHM_DIV'>" +
     "<label id='TUGPOVJSHM' for='EMCTEYNINS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Scadenza Documento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXDATRIL' id='ETDFWVULIM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXDATRIL,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
     "<button id='ETDFWVULIM_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JGCMMJIMXW_DIV'>" +
     "<label id='JGCMMJIMXW' for='ETDFWVULIM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Rilascio Documento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='TRXTIPDOC' id='TTQTFXMWFO' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value>" +
     "</option>" +
     "</select>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FQDGNGQULN_DIV'>" +
     "<label id='FQDGNGQULN' for='TTQTFXMWFO'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Documento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXMTCN' id='YZULLMXBBH' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXMTCN,"C",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='10' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DYDCEKIOPZ_DIV'>" +
     "<label id='DYDCEKIOPZ' for='YZULLMXBBH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MTCN Operazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXDATNAS' id='BYTTMKVPJF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXDATNAS,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
     "<button id='BYTTMKVPJF_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
    "");
    status.out.println(
     "<input name='TRXDATOPE' id='VUPAGTECJJ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXDATOPE,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NRJSRMLPEW_DIV'>" +
     "<label id='NRJSRMLPEW' for='VUPAGTECJJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Operazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RWVGLFMUMW_DIV'>" +
     "<label id='RWVGLFMUMW' for='BYTTMKVPJF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Di Nascita:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='TRXSESSO' id='ATGEKSLXET' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("M","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("M",CPLib.Trim(BO.w_TRXSESSO))?"SELECTED":"")+">" +
     ""+status.context.Translate("Maschio")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("F","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("F",CPLib.Trim(BO.w_TRXSESSO))?"SELECTED":"")+">" +
     ""+status.context.Translate("Femmina")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('ATGEKSLXET'),w_TRXSESSO,'C');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UWFFZZSTIY_DIV'>" +
     "<label id='UWFFZZSTIY' for='ATGEKSLXET'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sesso:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<select name='doctype' id='QVAFKIBICA' class='Combobox Disabled' disabled>" +
     "<option value>" +
     "</option>" +
     "</select>" +
    "");
    status.out.println(
     "<div id='CPEANLRGHT'>" +
    "");
    // GetPortlet_Cases_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_CPEANLRGHT;
    inclusionVars_CPEANLRGHT = GetPortlet_CPEANLRGHT_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_CPEANLRGHT);
    String portletUID_CPEANLRGHT = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_wutrxchk_cases_portlet.jsp?ForcedPortletUID="+ portletUID_CPEANLRGHT+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_CPEANLRGHT),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.CPEANLRGHT='"+portletUID_CPEANLRGHT+"';" +
     "w_Cases=ZtVWeb.getPortletById('"+portletUID_CPEANLRGHT+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='CMGWBYDKHQ_DIV' style='display:none'>" +
     "<input name='TRXFLGFOR' id='CMGWBYDKHQ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_TRXFLGFOR,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_TRXFLGFOR))?"CHECKED":"")+">" +
     "<label id='CMGWBYDKHQ_LBL' for='CMGWBYDKHQ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Forzatura inserimento dati"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='TRXFORCE' id='GYMTADSNZN' class='"+status.ObligatoryClass("Combobox",BO.GYMTADSNZN_isObligatory())+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value>" +
     "</option>" +
     "</select>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VVELSWKIWG_DIV'>" +
     "<label id='VVELSWKIWG' for='GYMTADSNZN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Motivazione Forzatura:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<img id='GUYNDNSZRL' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/GIF/002.gif"),"C",0,0)+" alt='' style='display:none'>" +
    "");
    status.out.println(
     "<input name='xTRXPROVINCIA' id='ZEJILKQXXT' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_xTRXPROVINCIA,"C",2,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='2' size='2' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='PPLBWAIBLM_DIV' style='display:none'>" +
     "<input name='FLGDATIOLD' id='PPLBWAIBLM' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGDATIOLD,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"disabled":"")+" "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGDATIOLD))?"CHECKED":"")+">" +
     "<label id='PPLBWAIBLM_LBL' for='PPLBWAIBLM' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Dati acquisiti da record storici"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FLZZDEVWLH_DIV'>" +
     "<label id='FLZZDEVWLH' for='QVAFKIBICA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Documento AUI:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href="+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"javascript:void(0)":"javascript:href_NAKIBNYQOP()")+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' id='NAKIBNYQOP' class='SPHorizontalAction'>" +
     "<span class='SPLabel' id='NAKIBNYQOP_txt'>" +
     ""+SPLib.ToHTMLRepresentation("Forza")+"" +
     "</span>" +
     "<img id='NAKIBNYQOP_img' src="+SPLib.ToHTMLValue(SPLib.ToResource("../images/force.png"),"C",0,0)+" tabindex='-1' alt=''>" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='xtipdoc' id='HUXCGVAMUP' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_xtipdoc,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='2' size='2' fieldtype='C' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='xtnumdoc' id='FKGNMENYXR' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_xtnumdoc,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='15' size='15' fieldtype='C' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXTFINLAV' id='EMFAOZJHRN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXTFINLAV,"T",14,0,SPLib.GetUserDateTimePicture(status.context.GetLanguage(),"DD-MM-YYYY hh:mm:ss"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='19' size='14' fieldtype='T' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRDFINLAV' id='WCMXGFBEVX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRDFINLAV,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRFLGINLAV' id='ZGTJLSVSXA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRFLGINLAV,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='1' size='1' fieldtype='C' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXFLGAUA' id='FMRBWPDSBR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXFLGAUA,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='1' size='1' fieldtype='C' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXESITO' id='XONXBNGAAH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXESITO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='1' size='1' fieldtype='C' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href="+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"javascript:void(0)":"javascript:href_BEDRTSBAMO()")+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' id='BEDRTSBAMO' class='SPHorizontalAction'>" +
     "<span class='SPLabel' id='BEDRTSBAMO_txt'>" +
     ""+SPLib.ToHTMLRepresentation("Finalizza")+"" +
     "</span>" +
     "<img id='BEDRTSBAMO_img' src="+SPLib.ToHTMLValue(SPLib.ToResource(SPLib.GetThemedImage(status.context,"../images/final.png")),"C",0,0)+" tabindex='-1' alt=''>" +
     "</a>" +
    "");
    status.out.println(
     "<input name='TRXAUTRIL' id='OHDLYDFRFV' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXAUTRIL,"C",50,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JQQNBNBWZZ_DIV'>" +
     "<label id='JQQNBNBWZZ' for='OHDLYDFRFV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Autorità Rilascio:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='xDESCRIZ' id='PXDVUJVPPR' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_xDESCRIZ,"C",30,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='30' size='30' fieldtype='C'>" +
    "");
    status.out.println(
     "<input name='TRXCODDIP' id='HZPBCLSNRS' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXCODDIP,"C",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='10' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CKTPLYQSNF_DIV'>" +
     "<label id='CKTPLYQSNF' for='HZPBCLSNRS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Agenzia:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='finalized' id='ZDYTXRRFLT' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_finalized,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='1' size='1' fieldtype='C' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='xluonas' id='BLTFRBAHBH' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_xluonas,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='50' size='50' fieldtype='C' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VYEJURLTUG_DIV'>" +
     "<label id='VYEJURLTUG' for='ZEJILKQXXT'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Provincia Nascita:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b0(armt_wutrxchk_auaBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='position:relative;height:374px'>" +
    "");
    status.out.println(
     "<span id='TQMBDRYXLU_DIV'>" +
     "<input name='TRXFLGCON' id='TQMBDRYXLU' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_TRXFLGCON,"C",1,0,"", status.m_oRegSettings)+" disabled "+(CPLib.eq("S",CPLib.Trim(BO.w_TRXFLGCON))?"CHECKED":"")+">" +
     "<label id='TQMBDRYXLU_LBL' for='TQMBDRYXLU' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Presenza Importo in contanti"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HWRRLNPDOJ_DIV'>" +
     "<label id='HWRRLNPDOJ' for='TQMBDRYXLU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Flag Contanti:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<select name='TRSSEGNO' id='EPEPXVTDDF' class='Combobox Disabled' disabled>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("A","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("A",CPLib.Trim(BO.w_TRSSEGNO))?"SELECTED":"")+">" +
     ""+status.context.Translate("Receive")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("D","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("D",CPLib.Trim(BO.w_TRSSEGNO))?"SELECTED":"")+">" +
     ""+status.context.Translate("Send")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('EPEPXVTDDF'),w_TRSSEGNO,'C');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HAJXBCFZUB_DIV'>" +
     "<label id='HAJXBCFZUB' for='EPEPXVTDDF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Segno (A=Receive,D=Send):"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXIMPORTO' id='FNVGSTOZTQ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXIMPORTO,"N",15,2,"999999999999.99", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='18' size='15' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TYFYRRXXWC_DIV'>" +
     "<label id='TYFYRRXXWC' for='FNVGSTOZTQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Importo:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXCONTAN' id='EVKHOJDUVF' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXCONTAN,"N",15,2,"999999999999.99", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='18' size='15' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='AIMDTEHGSW_DIV'>" +
     "<label id='AIMDTEHGSW' for='EVKHOJDUVF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Contante:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXUNIQUE' id='FCRFUHHVHU' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXUNIQUE,"C",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='10' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ULSRWVYTMU_DIV'>" +
     "<label id='ULSRWVYTMU' for='FCRFUHHVHU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Unique ID:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXCOGCON' id='LGVQVJPZZP' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXCOGCON,"C",100,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='100' size='100' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZUININVXNT_DIV'>" +
     "<label id='ZUININVXNT' for='LGVQVJPZZP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cognome Controparte:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXNOMCON' id='OKKVRBSRDN' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXNOMCON,"C",100,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='100' size='100' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DSHVDLPTCM_DIV'>" +
     "<label id='DSHVDLPTCM' for='OKKVRBSRDN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nome Controparte:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXDESTIN' id='FDXEUOOSVN' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXDESTIN,"C",100,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='100' size='100' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZVELAFATZL_DIV'>" +
     "<label id='ZVELAFATZL' for='FDXEUOOSVN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato Controparte:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXCODCAS' id='UTGSXNXPVT' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXCODCAS,"C",4,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='4' size='4' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MEUEEEUOXT_DIV'>" +
     "<label id='MEUEEEUOXT' for='UTGSXNXPVT'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Catastale:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<select name='TRXRECTYPE' id='FMRUIANURB' class='Combobox Disabled' disabled>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("I","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("I",CPLib.Trim(BO.w_TRXRECTYPE))?"SELECTED":"")+">" +
     ""+status.context.Translate("Nuova Transazione")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("M","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("M",CPLib.Trim(BO.w_TRXRECTYPE))?"SELECTED":"")+">" +
     ""+status.context.Translate("Rettifica Transazione")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("D","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("D",CPLib.Trim(BO.w_TRXRECTYPE))?"SELECTED":"")+">" +
     ""+status.context.Translate("Cancellazione Transazione")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('FMRUIANURB'),w_TRXRECTYPE,'C');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XXKUBGHLZL_DIV'>" +
     "<label id='XXKUBGHLZL' for='FMRUIANURB'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Record:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXCODMAG' id='UTFQIBBLAF' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXCODMAG,"C",5,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='5' size='5' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VIWNSSMTML_DIV'>" +
     "<label id='VIWNSSMTML' for='UTFQIBBLAF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice MacroAgente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXCODUNI' id='NSNBJQWLKR' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXCODUNI,"C",18,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='18' size='18' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XIUAHOQEHG_DIV'>" +
     "<label id='XIUAHOQEHG' for='NSNBJQWLKR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Univoco:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='xMADESCRI' id='YUKRVYFISB' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_xMADESCRI,"C",60,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='60' size='60' fieldtype='C'>" +
    "");
    status.out.println(
     "<input name='TRXNAZRES' id='UUXGHAXWLH' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXNAZRES,"C",50,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DMPAIYJLOW_DIV'>" +
     "<label id='DMPAIYJLOW' for='UUXGHAXWLH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nazione di Residenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXCITRES' id='XSZDOLIZKJ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXCITRES,"C",50,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YSJTRGSOUR_DIV'>" +
     "<label id='YSJTRGSOUR' for='XSZDOLIZKJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Città Di residenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXDOMICI' id='AQPBKHBXWC' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXDOMICI,"C",100,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='100' size='100' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YCSZPDCPKE_DIV'>" +
     "<label id='YCSZPDCPKE' for='AQPBKHBXWC'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Domicilio:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  static void PrintState(armt_wutrxchk_auaBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_wutrxchk_auaBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
  }
  static void PrintStateWorkVars(armt_wutrxchk_auaBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_TRXCODPRG,"N",15,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_TRXCODPRG:BO.w_TRXCODPRG,"N",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXCOGNOM,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXNOME,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXFLGCF,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXCODFIS,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXLUONAS,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXNUMDOC,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXDATSCA,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXDATRIL,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXTIPDOC,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXMTCN,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXDATNAS,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXDATOPE,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXFLGCON,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRSSEGNO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXIMPORTO,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXCONTAN,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXUNIQUE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXCOGCON,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXNOMCON,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXDESTIN,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXCODCAS,"C",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXRECTYPE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXCODMAG,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXCODUNI,"C",18,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXSESSO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXNASSTATO,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXNASCOMUN,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXFLGAUAQ1,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXFLGAUAQ2,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXFLGAUAQ3,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXFLGAUAQ4,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXFLGAUAQ5,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXFLGAUA,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXFLGFOR,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXFORCE,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXDATRICERCA,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXNAZRES,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXCITRES,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXDOMICI,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXTFINLAV,"T",14,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRDFINLAV,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRFLGINLAV,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXESITO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXAUTRIL,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXCODDIP,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXUTENTE,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXTINILAV,"T",14,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXDINILAV,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xMADESCRI,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_doctype,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_sesso,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xTRXPROVINCIA,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGDATIOLD,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xtipdoc,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xtnumdoc,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDESCRIZ,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_finalized,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xluonas,"C",50,0));
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_wutrxchk_auaBO BO,ServletStatus status) {
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(789,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(1278,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_wutrxchk_aua"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'CAICHGXWXW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"CAICHGXWXW",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbluonas,"+"default",l_session)+"'"+"]");
      status.out.print(",'TTQTFXMWFO':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"TTQTFXMWFO",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,wutipdoc,"+"default",l_session)+"'"+"]");
      status.out.print(",'HZPBCLSNRS':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"HZPBCLSNRS",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'UTFQIBBLAF':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"UTFQIBBLAF",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbmacage,"+"default",l_session)+"'"+"]");
      status.out.print(",'UUXGHAXWLH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"UUXGHAXWLH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'XSZDOLIZKJ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"XSZDOLIZKJ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'CAICHGXWXW':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbluonas,"+"default",l_session)+"'"+"]");
      status.out.print(",'TTQTFXMWFO':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,wutipdoc,"+"default",l_session)+"'"+"]");
      status.out.print(",'HZPBCLSNRS':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'UTFQIBBLAF':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbmacage,"+"default",l_session)+"'"+"]");
      status.out.print(",'UUXGHAXWLH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'XSZDOLIZKJ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_wutrxchk_aua","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_wutrxchk_aua",BO.GetCurrentState());
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
  void WriteMainFormScript(armt_wutrxchk_auaBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_wutrxchk_aua',false);");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('OAJHZGVXDW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IJWHZPPSVS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GOZRBLFKLS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NIGZXFUTGU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CAICHGXWXW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CAICHGXWXW_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QWQZUBRCXK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EMCTEYNINS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EMCTEYNINS_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ETDFWVULIM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ETDFWVULIM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TTQTFXMWFO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BYTTMKVPJF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BYTTMKVPJF_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ATGEKSLXET')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CMGWBYDKHQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GYMTADSNZN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PPLBWAIBLM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HUXCGVAMUP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FKGNMENYXR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EMFAOZJHRN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WCMXGFBEVX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZGTJLSVSXA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FMRBWPDSBR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XONXBNGAAH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZDYTXRRFLT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BLTFRBAHBH')) SetDisabled(c,true);");
      }
      status.out.println("HideControlsUnderCondition();");
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
        status.out.println("if(c=Ctrl('LPQRPTUZNB')) SetDisabled(c,true);");
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
    if (CPLib.ne(status.m_cClientMode,"query")) {
      status.out.println("function UpdateAutonumber(p_uid) {");
      status.out.println("}");
    }
    WriteJSError(status);
    WriteTableCombo(status,BO);
    status.out.println("// * --- Area Manuale = UI - Functions & Procedures");
    status.out.println("// * --- armt_wutrxchk_aua");
    status.out.println("function SaveForced() {");
    status.out.println("  if (confirm('Confermi il salvataggio forzato della transazione?')) {  ");
    status.out.println("    Set_finalized('S')");
    status.out.println("    Set_TRXESITO('F');");
    status.out.println("    Set_TRXFLGFOR('S');");
    status.out.println("    if (Empty(LRTrim(w_TRXFORCE))) {");
    status.out.println("      alert('Impossibile proseguire. Inserire la motivazione della forzatura')");
    status.out.println("      SetControlFocus('GYMTADSNZN')");
    status.out.println("    } else {");
    status.out.println("      SendData('save');");
    status.out.println("    }");
    status.out.println("  }");
    status.out.println("}");
    status.out.println("function SaveFinalize() {");
    status.out.println("  if (confirm('Confermi la finalizzazione delle correzioni alla transazione?')) {");
    status.out.println("    Set_finalized('S')");
    status.out.println("    SetModified()");
    status.out.println("    SendData('save');");
    status.out.println("  }");
    status.out.println("}");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  armt_wutrxchk_auaBO getBO(ServletStatus status) {
    armt_wutrxchk_auaBO BO = new armt_wutrxchk_auaBO(status.context);
    // gli op_ possono essere utilizzati dalla servlet anche prima di essere inizializzati
    BO.op_TRXCODPRG = BO.w_TRXCODPRG;
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_wutrxchk_auaBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("wutrxchk",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_wutrxchk_auaBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    if (CPLib.eq(p_cEvent,"Edit Aborted")) {
      Calculation_WFSOMZBEIU(status,BO);
    }
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Calculation_WFSOMZBEIU(ServletStatus status,armt_wutrxchk_auaBO BO) {
    arrt_wutrxchk_aua_exitR l_oRoutine_arrt_wutrxchk_aua_exit;
    if (CPLib.eq(BO.w_finalized,"N")) {
      l_oRoutine_arrt_wutrxchk_aua_exit = arrt_wutrxchk_aua_exitR.Make(status.context,BO);
      l_oRoutine_arrt_wutrxchk_aua_exit.pIDTrx = BO.w_TRXCODPRG;
      l_oRoutine_arrt_wutrxchk_aua_exit.pTipo = "X";
      if ( ! (Forward.IsForwarded(status.forwardedto))) {
        status.forwardedto = l_oRoutine_arrt_wutrxchk_aua_exit.Run();
        if (Forward.IsForwarded(status.forwardedto)) {
          SPLib.ForwardTo(status.forwardedto,servletContext,status.request,status.response);
        }
      }
    }
  }
  void WriteTableCombo(ServletStatus status,armt_wutrxchk_auaBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
    l_cTmp = "[";
    VQRHolder l_VQRHolder=null;
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_wutipdoc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),BO,false);
    l_VQRHolder.LoadTempWhere("");
    l_rsLoad = l_VQRHolder.GetResultSet(BO.m_Ctx);
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",2,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("WUTDCODICE"),"C",2,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("WUTDDESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var TTQTFXMWFO_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbtipdoc,CPSql.BuildSQLPhrase("TIPDOC,DESCRI",BO.m_cPhName_tbtipdoc,"",""));
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
    status.out.println("var QVAFKIBICA_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_wuforcer,CPSql.BuildSQLPhrase("FRCODICE,FRDESCRI",BO.m_cPhName_wuforcer,"",""));
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",3,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("FRCODICE"),"C",3,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("FRDESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var GYMTADSNZN_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(armt_wutrxchk_auaBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_wutrxchk;
    String l_cPhName = BO.m_cPhName_wutrxchk;
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
      String l_cQueryFilter = armt_wutrxchk_auaBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_wutrxchk+".TRXCODPRG",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("wutrxchk");
    String l_cPhName = CPSql.ManipulateTablePhName("wutrxchk",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".TRXCODPRG",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,armt_wutrxchk_auaBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_wutrxchk_auaBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_wutrxchk,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_wutrxchk,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_wutrxchk_auaBO BO) {
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
  void Edit(ServletStatus status,armt_wutrxchk_auaBO BO,SPParameterSource source) {
    BO.Load(status.w_TRXCODPRG);
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
  void New(ServletStatus status,armt_wutrxchk_auaBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_wutrxchk_auaBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_wutrxchk_auaBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_TRXCODPRG = 0;
      } else {
        BO.w_TRXCODPRG = l_rsKeys.GetDouble("TRXCODPRG");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_TRXCODPRG = BO.w_TRXCODPRG;
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
  void EditLoad(ServletStatus status,armt_wutrxchk_auaBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_wutrxchk_auaBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_TRXCODPRG);
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
  void DeleteMessage(ServletStatus status,armt_wutrxchk_auaBO BO,SPParameterSource source) {
    BO.Load(status.w_TRXCODPRG);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_wutrxchk_auaBO BO) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    String l_cTransMsgErr = "";
    BO.SetFromContext(status.m_cWv,status.m_Parameters);
    double l_old_TRXCODPRG = 0;
    if (CPLib.ne(BO.w_TRXCODPRG,BO.op_TRXCODPRG)) {
      l_old_TRXCODPRG = BO.op_TRXCODPRG;
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({TRXCODPRG:"+SPLib.ToJSValue(BO.w_TRXCODPRG,"N",15,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
      if ( ! (CPLib.Empty(l_old_TRXCODPRG))) {
        BO.op_TRXCODPRG = l_old_TRXCODPRG;
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
  void Discard(ServletStatus status,armt_wutrxchk_auaBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_wutrxchk_auaBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",789);
    item.put("w",1278);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","true");
    org.json.JSONObject pageProp = null;
    org.json.JSONArray pagesProp = null;
    pagesProp = new org.json.JSONArray();
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Dati Soggetto \\/ Errori\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Dati Transazione\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Dati Soggetto / Errori,Dati Transazione");
    item.put("altInterfaceFor","armt_wutrxchk_aua");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"comment\":\"ID Transazione\",\"disabled\":\"true\",\"h\":20,\"maxlength\":18,\"name\":\"TRXCODPRG\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"LPQRPTUZNB\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":160,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NESFDLHKJF\",\"page\":1,\"spuid\":\"NESFDLHKJF\",\"tabindex\":2,\"type\":\"Label\",\"value\":\"ID Transazione:\",\"w\":83,\"x\":73,\"y\":12,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cognome\",\"h\":20,\"maxlength\":50,\"name\":\"TRXCOGNOM\",\"page\":1,\"spuid\":\"OAJHZGVXDW\",\"tabindex\":3,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":160,\"y\":35,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_COLILEINDD\",\"page\":1,\"spuid\":\"COLILEINDD\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"Cognome:\",\"w\":53,\"x\":106,\"y\":39,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome\",\"h\":20,\"maxlength\":50,\"name\":\"TRXNOME\",\"page\":1,\"spuid\":\"IJWHZPPSVS\",\"tabindex\":5,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":577,\"y\":32,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JWSTZAKUTI\",\"page\":1,\"spuid\":\"JWSTZAKUTI\",\"tabindex\":6,\"type\":\"Label\",\"value\":\"Nome:\",\"w\":34,\"x\":542,\"y\":36,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"MTCN Operazione\",\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"TRXMTCN\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"YZULLMXBBH\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":408,\"y\":7,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DYDCEKIOPZ\",\"page\":1,\"spuid\":\"DYDCEKIOPZ\",\"tabindex\":21,\"type\":\"Label\",\"value\":\"MTCN Operazione:\",\"w\":99,\"x\":308,\"y\":11,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Operazione\",\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"TRXDATOPE\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"VUPAGTECJJ\",\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":71,\"x\":616,\"y\":7,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NRJSRMLPEW\",\"page\":1,\"spuid\":\"NRJSRMLPEW\",\"tabindex\":24,\"type\":\"Label\",\"value\":\"Data Operazione:\",\"w\":93,\"x\":523,\"y\":11,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Descrizione\",\"disabled\":\"true\",\"h\":20,\"maxlength\":30,\"name\":\"xDESCRIZ\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"PXDVUJVPPR\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":340,\"x\":904,\"y\":7,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Agenzia\",\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"TRXCODDIP\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"HZPBCLSNRS\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":94,\"x\":802,\"y\":7,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CKTPLYQSNF\",\"page\":1,\"spuid\":\"CKTPLYQSNF\",\"tabindex\":60,\"type\":\"Label\",\"value\":\"Codice Agenzia:\",\"w\":84,\"x\":717,\"y\":11,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Flag Codice Fiscale\",\"h\":21,\"label_text\":\"Codice Fiscale Dichiarato\",\"maxlength\":1,\"name\":\"TRXFLGCF\",\"page\":1,\"spuid\":\"GOZRBLFKLS\",\"tabindex\":7,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":226,\"x\":160,\"y\":63,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Ficale (reale)\",\"h\":20,\"maxlength\":16,\"name\":\"TRXCODFIS\",\"page\":1,\"spuid\":\"NIGZXFUTGU\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":129,\"x\":505,\"y\":63,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HOQDCOUNGL\",\"page\":1,\"spuid\":\"HOQDCOUNGL\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"Codice Fiscale:\",\"w\":116,\"x\":388,\"y\":67,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":19,\"keep_proportions\":\"bounded\",\"name\":\"image_GUYNDNSZRL\",\"page\":1,\"spuid\":\"GUYNDNSZRL\",\"src\":\"..\\/images\\/GIF\\/002.gif\",\"tabindex\":42,\"type\":\"Image\",\"w\":19,\"x\":638,\"y\":64,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Luogo di nascita\",\"h\":20,\"maxlength\":50,\"name\":\"TRXLUONAS\",\"page\":1,\"picker\":true,\"spuid\":\"CAICHGXWXW\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":160,\"y\":91,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WHFMFQMGTQ\",\"page\":1,\"spuid\":\"WHFMFQMGTQ\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"Luogo di nascita:\",\"w\":89,\"x\":70,\"y\":95,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Di Nascita\",\"h\":20,\"maxlength\":10,\"name\":\"TRXDATNAS\",\"page\":1,\"picker\":true,\"spuid\":\"BYTTMKVPJF\",\"tabindex\":22,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":78,\"x\":586,\"y\":91,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RWVGLFMUMW\",\"page\":1,\"spuid\":\"RWVGLFMUMW\",\"tabindex\":25,\"type\":\"Label\",\"value\":\"Data Di Nascita:\",\"w\":84,\"x\":502,\"y\":95,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Sesso\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"TRXSESSO\",\"page\":1,\"spuid\":\"ATGEKSLXET\",\"tabindex\":26,\"textlist\":\"Maschio,Femmina\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"M"+"'"+","+"'"+"F"+"'"+"\",\"w\":86,\"x\":753,\"y\":91,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UWFFZZSTIY\",\"page\":1,\"spuid\":\"UWFFZZSTIY\",\"tabindex\":27,\"type\":\"Label\",\"value\":\"Sesso:\",\"w\":35,\"x\":718,\"y\":95,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero Documento\",\"h\":20,\"maxlength\":30,\"name\":\"TRXNUMDOC\",\"page\":1,\"spuid\":\"QWQZUBRCXK\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":160,\"y\":119,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DKXGIHHVGO\",\"page\":1,\"spuid\":\"DKXGIHHVGO\",\"tabindex\":13,\"type\":\"Label\",\"value\":\"Numero Documento:\",\"w\":107,\"x\":50,\"y\":122,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Scadenza Documento\",\"h\":20,\"maxlength\":10,\"name\":\"TRXDATSCA\",\"page\":1,\"picker\":true,\"spuid\":\"EMCTEYNINS\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":75,\"x\":727,\"y\":119,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TUGPOVJSHM\",\"page\":1,\"spuid\":\"TUGPOVJSHM\",\"tabindex\":15,\"type\":\"Label\",\"value\":\"Data Scadenza Documento:\",\"w\":146,\"x\":580,\"y\":123,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Rilascio Documento\",\"h\":20,\"maxlength\":10,\"name\":\"TRXDATRIL\",\"page\":1,\"picker\":true,\"spuid\":\"ETDFWVULIM\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":71,\"x\":490,\"y\":119,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JGCMMJIMXW\",\"page\":1,\"spuid\":\"JGCMMJIMXW\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"Data Rilascio Documento:\",\"w\":134,\"x\":355,\"y\":123,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia Nascita\",\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"xTRXPROVINCIA\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"ZEJILKQXXT\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":992,\"y\":91,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Autorit\\u00E0 Rilascio Documento\",\"disabled\":\"true\",\"h\":20,\"maxlength\":50,\"name\":\"TRXAUTRIL\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"OHDLYDFRFV\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":928,\"y\":119,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JQQNBNBWZZ\",\"page\":1,\"spuid\":\"JQQNBNBWZZ\",\"tabindex\":57,\"type\":\"Label\",\"value\":\"Autorit\\u00E0 Rilascio:\",\"w\":94,\"x\":829,\"y\":123,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VYEJURLTUG\",\"page\":1,\"spuid\":\"VYEJURLTUG\",\"tabindex\":67,\"type\":\"Label\",\"value\":\"Provincia Nascita:\",\"w\":93,\"x\":899,\"y\":95,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo Documento\",\"h\":20,\"maxlength\":2,\"name\":\"TRXTIPDOC\",\"page\":1,\"spuid\":\"TTQTFXMWFO\",\"tabindex\":18,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":624,\"x\":160,\"y\":147,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FQDGNGQULN\",\"page\":1,\"spuid\":\"FQDGNGQULN\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"Tipo Documento:\",\"w\":89,\"x\":62,\"y\":150,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Documento AUI\",\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"doctype\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"QVAFKIBICA\",\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":312,\"x\":928,\"y\":147,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FLZZDEVWLH\",\"page\":1,\"spuid\":\"FLZZDEVWLH\",\"tabindex\":46,\"type\":\"Label\",\"value\":\"Tipo Documento AUI:\",\"w\":112,\"x\":816,\"y\":151,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":581,\"name\":\"Cases\",\"page\":1,\"spuid\":\"CPEANLRGHT\",\"src\":\"\\/jsp\\/pg_wutrxchk_cases_portlet.jsp?ForcedPortletUID=CPEANLRGHT\",\"tabindex\":37,\"type\":\"Portlet\",\"w\":1265,\"x\":8,\"y\":203,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Motivazione Forzatura\",\"h\":20,\"maxlength\":3,\"name\":\"TRXFORCE\",\"page\":1,\"spuid\":\"GYMTADSNZN\",\"tabindex\":40,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":624,\"x\":160,\"y\":175,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VVELSWKIWG\",\"page\":1,\"spuid\":\"VVELSWKIWG\",\"tabindex\":41,\"type\":\"Label\",\"value\":\"Motivazione Forzatura:\",\"w\":122,\"x\":38,\"y\":179,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":42,\"name\":\"button_NAKIBNYQOP\",\"page\":1,\"picker\":true,\"spuid\":\"NAKIBNYQOP\",\"tabindex\":47,\"type\":\"Button\",\"value\":\"Forza\",\"w\":80,\"x\":1296,\"y\":154,\"zone\":\"pag1_10\",\"zonepath\":\"[1,10]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":42,\"name\":\"button_BEDRTSBAMO\",\"page\":1,\"picker\":true,\"spuid\":\"BEDRTSBAMO\",\"tabindex\":55,\"type\":\"Button\",\"value\":\"Finalizza\",\"w\":80,\"x\":1384,\"y\":154,\"zone\":\"pag1_10\",\"zonepath\":\"[1,10]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Flag Contanti\",\"disabled\":\"true\",\"h\":21,\"label_text\":\"Presenza Importo in contanti\",\"maxlength\":1,\"name\":\"TRXFLGCON\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"TQMBDRYXLU\",\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":158,\"x\":160,\"y\":7,\"zone\":\"pag2_1\",\"zonepath\":\"[2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HWRRLNPDOJ\",\"page\":2,\"spuid\":\"HWRRLNPDOJ\",\"tabindex\":2,\"type\":\"Label\",\"value\":\"Flag Contanti:\",\"w\":74,\"x\":85,\"y\":12,\"zone\":\"pag2_1\",\"zonepath\":\"[2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Segno (A=Send,D=Receive)\",\"disabled\":\"true\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"TRSSEGNO\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"EPEPXVTDDF\",\"textlist\":\"Receive,Send\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"A"+"'"+","+"'"+"D"+"'"+"\",\"w\":102,\"x\":160,\"y\":31,\"zone\":\"pag2_2\",\"zonepath\":\"[2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HAJXBCFZUB\",\"page\":2,\"spuid\":\"HAJXBCFZUB\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"Segno (A=Receive,D=Send):\",\"w\":155,\"x\":4,\"y\":35,\"zone\":\"pag2_2\",\"zonepath\":\"[2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Importo\",\"disabled\":\"true\",\"h\":20,\"maxlength\":18,\"name\":\"TRXIMPORTO\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"FNVGSTOZTQ\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":160,\"y\":54,\"zone\":\"pag2_3\",\"zonepath\":\"[2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TYFYRRXXWC\",\"page\":2,\"spuid\":\"TYFYRRXXWC\",\"tabindex\":6,\"type\":\"Label\",\"value\":\"Importo:\",\"w\":46,\"x\":113,\"y\":58,\"zone\":\"pag2_3\",\"zonepath\":\"[2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Contante\",\"disabled\":\"true\",\"h\":20,\"maxlength\":18,\"name\":\"TRXCONTAN\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"EVKHOJDUVF\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":160,\"y\":77,\"zone\":\"pag2_4\",\"zonepath\":\"[2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AIMDTEHGSW\",\"page\":2,\"spuid\":\"AIMDTEHGSW\",\"tabindex\":8,\"type\":\"Label\",\"value\":\"Contante:\",\"w\":53,\"x\":106,\"y\":81,\"zone\":\"pag2_4\",\"zonepath\":\"[2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Unique ID\",\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"TRXUNIQUE\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"FCRFUHHVHU\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":160,\"y\":100,\"zone\":\"pag2_5\",\"zonepath\":\"[2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ULSRWVYTMU\",\"page\":2,\"spuid\":\"ULSRWVYTMU\",\"tabindex\":10,\"type\":\"Label\",\"value\":\"Unique ID:\",\"w\":56,\"x\":103,\"y\":104,\"zone\":\"pag2_5\",\"zonepath\":\"[2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cognome Controparte\",\"disabled\":\"true\",\"h\":20,\"maxlength\":100,\"name\":\"TRXCOGCON\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"LGVQVJPZZP\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":160,\"y\":146,\"zone\":\"pag2_6\",\"zonepath\":\"[2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZUININVXNT\",\"page\":2,\"spuid\":\"ZUININVXNT\",\"tabindex\":12,\"type\":\"Label\",\"value\":\"Cognome Controparte:\",\"w\":122,\"x\":37,\"y\":150,\"zone\":\"pag2_6\",\"zonepath\":\"[2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome Controparte\",\"disabled\":\"true\",\"h\":20,\"maxlength\":100,\"name\":\"TRXNOMCON\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"OKKVRBSRDN\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":160,\"y\":169,\"zone\":\"pag2_7\",\"zonepath\":\"[2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DSHVDLPTCM\",\"page\":2,\"spuid\":\"DSHVDLPTCM\",\"tabindex\":14,\"type\":\"Label\",\"value\":\"Nome Controparte:\",\"w\":102,\"x\":57,\"y\":173,\"zone\":\"pag2_7\",\"zonepath\":\"[2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Stato Controparte\",\"disabled\":\"true\",\"h\":20,\"maxlength\":100,\"name\":\"TRXDESTIN\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"FDXEUOOSVN\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":160,\"y\":192,\"zone\":\"pag2_8\",\"zonepath\":\"[2,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZVELAFATZL\",\"page\":2,\"spuid\":\"ZVELAFATZL\",\"tabindex\":16,\"type\":\"Label\",\"value\":\"Stato Controparte:\",\"w\":101,\"x\":58,\"y\":196,\"zone\":\"pag2_8\",\"zonepath\":\"[2,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Catastale\",\"disabled\":\"true\",\"h\":20,\"maxlength\":4,\"name\":\"TRXCODCAS\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"UTGSXNXPVT\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":36,\"x\":160,\"y\":214,\"zone\":\"pag2_9\",\"zonepath\":\"[2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MEUEEEUOXT\",\"page\":2,\"spuid\":\"MEUEEEUOXT\",\"tabindex\":18,\"type\":\"Label\",\"value\":\"Codice Catastale:\",\"w\":93,\"x\":66,\"y\":218,\"zone\":\"pag2_9\",\"zonepath\":\"[2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Record\",\"disabled\":\"true\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"TRXRECTYPE\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"FMRUIANURB\",\"textlist\":\"Nuova Transazione,Rettifica Transazione,Cancellazione Transazione\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"I"+"'"+","+"'"+"M"+"'"+","+"'"+"D"+"'"+"\",\"w\":158,\"x\":160,\"y\":237,\"zone\":\"pag2_10\",\"zonepath\":\"[2,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XXKUBGHLZL\",\"page\":2,\"spuid\":\"XXKUBGHLZL\",\"tabindex\":20,\"type\":\"Label\",\"value\":\"Tipo Record:\",\"w\":67,\"x\":92,\"y\":241,\"zone\":\"pag2_10\",\"zonepath\":\"[2,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice MacroAgente\",\"disabled\":\"true\",\"h\":20,\"maxlength\":5,\"name\":\"TRXCODMAG\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"UTFQIBBLAF\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":55,\"x\":160,\"y\":260,\"zone\":\"pag2_11\",\"zonepath\":\"[2,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VIWNSSMTML\",\"page\":2,\"spuid\":\"VIWNSSMTML\",\"tabindex\":22,\"type\":\"Label\",\"value\":\"Codice MacroAgente:\",\"w\":113,\"x\":46,\"y\":264,\"zone\":\"pag2_11\",\"zonepath\":\"[2,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Denominazione\",\"disabled\":\"true\",\"h\":20,\"maxlength\":60,\"name\":\"xMADESCRI\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"YUKRVYFISB\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":372,\"x\":243,\"y\":260,\"zone\":\"pag2_11\",\"zonepath\":\"[2,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Univoco\",\"disabled\":\"true\",\"h\":20,\"maxlength\":18,\"name\":\"TRXCODUNI\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"NSNBJQWLKR\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":120,\"x\":160,\"y\":283,\"zone\":\"pag2_12\",\"zonepath\":\"[2,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XIUAHOQEHG\",\"page\":2,\"spuid\":\"XIUAHOQEHG\",\"tabindex\":24,\"type\":\"Label\",\"value\":\"Codice Univoco:\",\"w\":84,\"x\":75,\"y\":287,\"zone\":\"pag2_12\",\"zonepath\":\"[2,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Nazione di Residenza\",\"disabled\":\"true\",\"h\":20,\"maxlength\":50,\"name\":\"TRXNAZRES\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"UUXGHAXWLH\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":159,\"y\":307,\"zone\":\"pag2_13\",\"zonepath\":\"[2,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DMPAIYJLOW\",\"page\":2,\"spuid\":\"DMPAIYJLOW\",\"tabindex\":27,\"type\":\"Label\",\"value\":\"Nazione di Residenza:\",\"w\":115,\"x\":43,\"y\":311,\"zone\":\"pag2_13\",\"zonepath\":\"[2,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Citt\\u00E0 Di residenza\",\"disabled\":\"true\",\"h\":20,\"maxlength\":50,\"name\":\"TRXCITRES\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"XSZDOLIZKJ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":159,\"y\":329,\"zone\":\"pag2_14\",\"zonepath\":\"[2,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YSJTRGSOUR\",\"page\":2,\"spuid\":\"YSJTRGSOUR\",\"tabindex\":29,\"type\":\"Label\",\"value\":\"Citt\\u00E0 Di residenza:\",\"w\":96,\"x\":63,\"y\":333,\"zone\":\"pag2_14\",\"zonepath\":\"[2,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Domicilio\",\"disabled\":\"true\",\"h\":20,\"maxlength\":100,\"name\":\"TRXDOMICI\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"AQPBKHBXWC\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":159,\"y\":349,\"zone\":\"pag2_15\",\"zonepath\":\"[2,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YCSZPDCPKE\",\"page\":2,\"spuid\":\"YCSZPDCPKE\",\"tabindex\":31,\"type\":\"Label\",\"value\":\"Domicilio:\",\"w\":48,\"x\":110,\"y\":353,\"zone\":\"pag2_15\",\"zonepath\":\"[2,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_wutrxchk_auaBO BO,ServletStatus status) {
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
     "<script src='armt_wutrxchk_aua?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_wutrxchk_aua_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_wutrxchk_aua_edit.js'>" +
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
      status.out.println("w_TRXCODPRG=a[0];");
      status.out.println("op_TRXCODPRG=a[1];");
      status.out.println("w_TRXCOGNOM=a[2];");
      status.out.println("w_TRXNOME=a[3];");
      status.out.println("w_TRXFLGCF=a[4];");
      status.out.println("w_TRXCODFIS=a[5];");
      status.out.println("w_TRXLUONAS=a[6];");
      status.out.println("w_TRXNUMDOC=a[7];");
      status.out.println("w_TRXDATSCA=a[8];");
      status.out.println("w_TRXDATRIL=a[9];");
      status.out.println("w_TRXTIPDOC=a[10];");
      status.out.println("w_TRXMTCN=a[11];");
      status.out.println("w_TRXDATNAS=a[12];");
      status.out.println("w_TRXDATOPE=a[13];");
      status.out.println("w_TRXFLGCON=a[14];");
      status.out.println("w_TRSSEGNO=a[15];");
      status.out.println("w_TRXIMPORTO=a[16];");
      status.out.println("w_TRXCONTAN=a[17];");
      status.out.println("w_TRXUNIQUE=a[18];");
      status.out.println("w_TRXCOGCON=a[19];");
      status.out.println("w_TRXNOMCON=a[20];");
      status.out.println("w_TRXDESTIN=a[21];");
      status.out.println("w_TRXCODCAS=a[22];");
      status.out.println("w_TRXRECTYPE=a[23];");
      status.out.println("w_TRXCODMAG=a[24];");
      status.out.println("w_TRXCODUNI=a[25];");
      status.out.println("w_TRXSESSO=a[26];");
      status.out.println("w_TRXNASSTATO=a[27];");
      status.out.println("w_TRXNASCOMUN=a[28];");
      status.out.println("w_TRXFLGAUAQ1=a[29];");
      status.out.println("w_TRXFLGAUAQ2=a[30];");
      status.out.println("w_TRXFLGAUAQ3=a[31];");
      status.out.println("w_TRXFLGAUAQ4=a[32];");
      status.out.println("w_TRXFLGAUAQ5=a[33];");
      status.out.println("w_TRXFLGAUA=a[34];");
      status.out.println("w_TRXFLGFOR=a[35];");
      status.out.println("w_TRXFORCE=a[36];");
      status.out.println("w_TRXDATRICERCA=a[37];");
      status.out.println("w_TRXNAZRES=a[38];");
      status.out.println("w_TRXCITRES=a[39];");
      status.out.println("w_TRXDOMICI=a[40];");
      status.out.println("w_TRXTFINLAV=a[41];");
      status.out.println("w_TRDFINLAV=a[42];");
      status.out.println("w_TRFLGINLAV=a[43];");
      status.out.println("w_TRXESITO=a[44];");
      status.out.println("w_TRXAUTRIL=a[45];");
      status.out.println("w_TRXCODDIP=a[46];");
      status.out.println("w_TRXUTENTE=a[47];");
      status.out.println("w_TRXTINILAV=a[48];");
      status.out.println("w_TRXDINILAV=a[49];");
      status.out.println("w_xMADESCRI=a[50];");
      status.out.println("w_doctype=a[51];");
      status.out.println("w_sesso=a[52];");
      status.out.println("w_xTRXPROVINCIA=a[53];");
      status.out.println("w_FLGDATIOLD=a[54];");
      status.out.println("w_xtipdoc=a[55];");
      status.out.println("w_xtnumdoc=a[56];");
      status.out.println("w_xDESCRIZ=a[57];");
      status.out.println("w_finalized=a[58];");
      status.out.println("w_xluonas=a[59];");
      status.out.println("if (Gt(a.length,60)) {");
      status.out.println("o_xtnumdoc=w_xtnumdoc;");
      status.out.println("o_TRXCODDIP=w_TRXCODDIP;");
      status.out.println("o_TRXCODMAG=w_TRXCODMAG;");
      status.out.println("o_TRXNAZRES=w_TRXNAZRES;");
      status.out.println("o_TRXCITRES=w_TRXCITRES;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['TRXCODPRG'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_wutrxchk_aua_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(789,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","wutrxchk");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","TRXCODPRG");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(armt_wutrxchk_auaBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({TRXCODPRG:"+SPLib.ToJSValue(BO.w_TRXCODPRG,"N",15,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_wutrxchk_auaBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({TRXCODPRG:"+SPLib.ToJSValue(BO.w_TRXCODPRG,"N",15,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armt_wutrxchk_auaBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({TRXCODPRG:"+SPLib.ToJSValue(BO.w_TRXCODPRG,"N",15,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armt_wutrxchk_auaBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({TRXCODPRG:"+SPLib.ToJSValue(BO.w_TRXCODPRG,"N",15,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armt_wutrxchk_auaBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({TRXCODPRG:"+SPLib.ToJSValue(BO.w_TRXCODPRG,"N",15,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_wutrxchk_auaBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_wutrxchk_auaBO BO,ServletStatus status) throws IOException {
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
     "<script src='SPPrxy/"+arfn_chkcodfis.m_cEntityUid+"/arfn_chkcodfis.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arrt_wutrxchk_upddata.m_cEntityUid+"/arrt_wutrxchk_upddata.js'>" +
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
      arfn_chkcodfis.GetCallableNames(callable);
      arrt_wutrxchk_upddata.GetCallableNames(callable);
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_wutrxchk_auaBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(BO.w_TRXCODPRG,"N",15,0));
      }
    } else if (CPLib.eq(p_cUID,"CAICHGXWXW")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"TTQTFXMWFO")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"HZPBCLSNRS")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"UTFQIBBLAF")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"UUXGHAXWLH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"XSZDOLIZKJ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_wutrxchk_auaBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_TRXLUONAS))) {
        a = GetCheckVars(status,BO,"CAICHGXWXW");
        b = status.m_CheckVars.optString("CAICHGXWXW");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_TRXTIPDOC))) {
        a = GetCheckVars(status,BO,"TTQTFXMWFO");
        b = status.m_CheckVars.optString("TTQTFXMWFO");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_TRXCODDIP))) {
        a = GetCheckVars(status,BO,"HZPBCLSNRS");
        b = status.m_CheckVars.optString("HZPBCLSNRS");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_TRXCODMAG))) {
        a = GetCheckVars(status,BO,"UTFQIBBLAF");
        b = status.m_CheckVars.optString("UTFQIBBLAF");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_TRXNAZRES))) {
        a = GetCheckVars(status,BO,"UUXGHAXWLH");
        b = status.m_CheckVars.optString("UUXGHAXWLH");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_TRXCITRES))) {
        a = GetCheckVars(status,BO,"XSZDOLIZKJ");
        b = status.m_CheckVars.optString("XSZDOLIZKJ");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
