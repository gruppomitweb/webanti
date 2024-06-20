import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_ricercamassa extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*307feeb0*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "tmp_ricmas1";
    }
    public String w_IDBASE;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_IDBASE,context,"tmp_ricmas1","IDBASE","C",10,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
    armt_ricercamassaBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_tmp_ricmas1;
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
    return "Ricerca di massa";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_ricercamassa";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 757;
    l_eg.m_nEntityHeight = 404;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"tmp_ricmas1","intermbo","anadip","tbcitta","tbcauana","tbcausin","inter2bo","tbstati","anarapbo","tbtipnat","tbtipleg","tbtipreg","tbvalute","personbo","tbstgru","tbramgru","tbsetsin","tbtipdoc"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","Archivio di ricerca","page"),new ZoneItem("page_2","Tipo A","page"),new ZoneItem("page_3","Tipo B","page"),new ZoneItem("page_4","Tipo C","page"),new ZoneItem("page_5","Tipo D","page"),new ZoneItem("page_6","Tipo E","page"),new ZoneItem("page_7","Tipo F","page"),new ZoneItem("page_8","Tipo G","page"),new ZoneItem("page_9","Tipo H","page"),new ZoneItem("box_XLKFOZPJVO","",""),new ZoneItem("box_KVGFUZUMZV","",""),new ZoneItem("box_ZRLFCCXZUM","",""),new ZoneItem("box_YOZVQCHKHW","",""),new ZoneItem("box_CSGINFLFWZ","",""),new ZoneItem("box_KRHDYFEJWS","",""),new ZoneItem("box_IAWYMLKEQC","",""),new ZoneItem("box_EVPFVSEQYP","",""),new ZoneItem("box_RWWUWNLOQE","",""),new ZoneItem("box_HKEAENLPXY","",""),new ZoneItem("box_RKEDQZABYX","",""),new ZoneItem("box_JLTUCUTXFV","",""),new ZoneItem("box_EITSLGXPKQ","",""),new ZoneItem("box_UOKHMLIEUR","",""),new ZoneItem("box_ZGRJNQPUNM","",""),new ZoneItem("box_OFWGQIZSXD","",""),new ZoneItem("box_XECCYIEIAP","","")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"IDBASE"};
    l_eg.items = new SPItem[]{
                   new SPItem("archivio","C",1,0, "edit",""),
                   new SPItem("attsel","N",10,0, "show",""),
                   new SPItem("richieste","N",10,0, "show",""),
                   new SPItem("A01A","C",2,0, "edit","Tipo intermediario"),
                   new SPItem("A01B","C",11,0, "edit",""),
                   new SPItem("xraginter","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("A03","C",20,0, "edit",""),
                   new SPItem("A11","C",6,0, "edit",""),
                   new SPItem("xdesdip","C",30,0, "hide","Descrizione"),
                   new SPItem("A12A","C",6,0, "edit",""),
                   new SPItem("A12B","C",30,0, "edit",""),
                   new SPItem("A12C","C",2,0, "edit",""),
                   new SPItem("A21","D",8,0, "edit",""),
                   new SPItem("A22","N",1,0, "edit",""),
                   new SPItem("A23","C",1,0, "edit",""),
                   new SPItem("A24","C",4,0, "edit",""),
                   new SPItem("A25","C",2,0, "edit",""),
                   new SPItem("A31A","C",2,0, "edit",""),
                   new SPItem("A31B","C",10,0, "edit",""),
                   new SPItem("A32","C",3,0, "edit",""),
                   new SPItem("A33A","C",6,0, "edit",""),
                   new SPItem("A33B","C",30,0, "edit",""),
                   new SPItem("xdescittab","C",40,0, "hide","Località"),
                   new SPItem("A33C","C",2,0, "edit",""),
                   new SPItem("A34","C",50,0, "edit",""),
                   new SPItem("A41","C",25,0, "edit",""),
                   new SPItem("A42","C",1,0, "edit",""),
                   new SPItem("A43","C",1,0, "edit",""),
                   new SPItem("xtipleg","C",50,0, "hide","Descrizione"),
                   new SPItem("xdesrap","C",50,0, "hide","Descrizione"),
                   new SPItem("A51","D",8,0, "edit",""),
                   new SPItem("A52B","C",2,0, "edit",""),
                   new SPItem("A53","C",12,0, "edit",""),
                   new SPItem("A54A","C",1,0, "edit",""),
                   new SPItem("A54B","D",8,0, "edit",""),
                   new SPItem("A54C","C",20,0, "edit",""),
                   new SPItem("attsel","N",10,0, "show",""),
                   new SPItem("richieste","N",10,0, "show",""),
                   new SPItem("IDBASE","C",10,0, "hide",""),
                   new SPItem("oldval","C",1,0, "hide",""),
                   new SPItem("B11","C",1,0, "edit",""),
                   new SPItem("B12","C",3,0, "edit","Codice Valuta"),
                   new SPItem("B13","C",1,0, "edit",""),
                   new SPItem("B14","N",19,0, "edit",""),
                   new SPItem("B15","N",19,0, "edit",""),
                   new SPItem("attsel","N",10,0, "show",""),
                   new SPItem("richieste","N",10,0, "show",""),
                   new SPItem("xdesval","C",30,0, "hide","Descrizione"),
                   new SPItem("X_B14_OP","C",2,0, "edit",""),
                   new SPItem("X_B15_OP","C",2,0, "edit",""),
                   new SPItem("attsel","N",10,0, "show",""),
                   new SPItem("richieste","N",10,0, "show",""),
                   new SPItem("C11","C",16,0, "edit","Tipo intermediario"),
                   new SPItem("xragintes","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("C21","C",16,0, "edit",""),
                   new SPItem("C31","C",16,0, "edit","Tipo intermediario"),
                   new SPItem("xragsogope","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("xragbenef","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("C41","C",16,0, "edit","Tipo intermediario"),
                   new SPItem("xragsecond","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("C51","C",16,0, "edit","Tipo intermediario"),
                   new SPItem("xragterzo","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("attsel","N",10,0, "show",""),
                   new SPItem("richieste","N",10,0, "show",""),
                   new SPItem("D11","C",70,0, "edit","Tipo intermediario"),
                   new SPItem("D13","C",3,0, "edit",""),
                   new SPItem("D14A","C",6,0, "edit",""),
                   new SPItem("D14B","C",30,0, "edit",""),
                   new SPItem("D14C","C",2,0, "edit",""),
                   new SPItem("D15","C",35,0, "edit",""),
                   new SPItem("D16","C",5,0, "edit",""),
                   new SPItem("D17","C",16,0, "edit",""),
                   new SPItem("D18","D",8,0, "edit",""),
                   new SPItem("D19A","C",30,0, "edit",""),
                   new SPItem("D19B","C",30,0, "edit",""),
                   new SPItem("D21","C",3,0, "edit",""),
                   new SPItem("xdessoteco","C",60,0, "hide","Descrizione"),
                   new SPItem("D22","C",3,0, "edit",""),
                   new SPItem("xdesramgrp","C",70,0, "hide","Descrizione"),
                   new SPItem("D23","C",3,0, "edit",""),
                   new SPItem("xdessetsin","C",60,0, "hide","Descrizione"),
                   new SPItem("D41","C",2,0, "edit",""),
                   new SPItem("xdestipdoc","C",30,0, "hide","Descrizione"),
                   new SPItem("D42","C",15,0, "edit",""),
                   new SPItem("D43","D",8,0, "edit",""),
                   new SPItem("D44","C",30,0, "edit",""),
                   new SPItem("D45","C",1,0, "edit",""),
                   new SPItem("attsel","N",10,0, "show",""),
                   new SPItem("richieste","N",10,0, "show",""),
                   new SPItem("E11","C",70,0, "edit","Tipo intermediario"),
                   new SPItem("E13","C",3,0, "edit",""),
                   new SPItem("E14A","C",6,0, "edit",""),
                   new SPItem("E14B","C",30,0, "edit",""),
                   new SPItem("E14C","C",2,0, "edit",""),
                   new SPItem("E15","C",35,0, "edit",""),
                   new SPItem("E16","C",5,0, "edit",""),
                   new SPItem("E17","C",16,0, "edit",""),
                   new SPItem("E18","D",8,0, "edit",""),
                   new SPItem("E19A","C",30,0, "edit",""),
                   new SPItem("E19B","C",30,0, "edit",""),
                   new SPItem("E41","C",2,0, "edit",""),
                   new SPItem("xdestipdocsg","C",30,0, "hide","Descrizione"),
                   new SPItem("E42","C",15,0, "edit",""),
                   new SPItem("E43","D",8,0, "edit",""),
                   new SPItem("E44","C",30,0, "edit",""),
                   new SPItem("E45","C",1,0, "edit",""),
                   new SPItem("attsel","N",10,0, "show",""),
                   new SPItem("richieste","N",10,0, "show",""),
                   new SPItem("F11","C",70,0, "edit","Tipo intermediario"),
                   new SPItem("F13","C",3,0, "edit",""),
                   new SPItem("F14A","C",6,0, "edit",""),
                   new SPItem("F14B","C",30,0, "edit",""),
                   new SPItem("F14C","C",2,0, "edit",""),
                   new SPItem("F15","C",35,0, "edit",""),
                   new SPItem("F16","C",5,0, "edit",""),
                   new SPItem("F17","C",16,0, "edit",""),
                   new SPItem("attsel","N",10,0, "show",""),
                   new SPItem("richieste","N",10,0, "show",""),
                   new SPItem("G11","C",70,0, "edit","Tipo intermediario"),
                   new SPItem("G13","C",3,0, "edit",""),
                   new SPItem("G14A","C",6,0, "edit",""),
                   new SPItem("G14B","C",30,0, "edit",""),
                   new SPItem("G14C","C",2,0, "edit",""),
                   new SPItem("G15","C",35,0, "edit",""),
                   new SPItem("G16","C",5,0, "edit",""),
                   new SPItem("G17","C",16,0, "edit",""),
                   new SPItem("G18","D",8,0, "edit",""),
                   new SPItem("G19A","C",30,0, "edit",""),
                   new SPItem("G19B","C",30,0, "edit",""),
                   new SPItem("G41","C",2,0, "edit",""),
                   new SPItem("xdestipdoct","C",30,0, "hide","Descrizione"),
                   new SPItem("G42","C",15,0, "edit",""),
                   new SPItem("G43","D",8,0, "edit",""),
                   new SPItem("G44","C",30,0, "edit",""),
                   new SPItem("G45","C",1,0, "edit",""),
                   new SPItem("attsel","N",10,0, "show",""),
                   new SPItem("richieste","N",10,0, "show",""),
                   new SPItem("H11","C",70,0, "edit","Tipo intermediario"),
                   new SPItem("H13","C",3,0, "edit",""),
                   new SPItem("H14A","C",6,0, "edit",""),
                   new SPItem("H14B","C",30,0, "edit",""),
                   new SPItem("H14C","C",2,0, "edit",""),
                   new SPItem("H15","C",35,0, "edit",""),
                   new SPItem("H16","C",5,0, "edit",""),
                   new SPItem("H17","C",16,0, "edit",""),
                   new SPItem("H18","D",8,0, "edit",""),
                   new SPItem("H19A","C",30,0, "edit",""),
                   new SPItem("H19B","C",30,0, "edit",""),
                   new SPItem("H41","C",2,0, "edit",""),
                   new SPItem("xdestipdoct1","C",30,0, "hide","Descrizione"),
                   new SPItem("H42","C",15,0, "edit",""),
                   new SPItem("H43","D",8,0, "edit",""),
                   new SPItem("H44","C",30,0, "edit",""),
                   new SPItem("H45","C",1,0, "edit","")
                 };
    l_eg.m_lHasHistorical = false;
    return l_eg;
  }
  ArrayList<org.json.JSONArray> i_sidebarItems = null;
  public org.json.JSONArray getSidebarItems(int p_nPage) {
    if (CPLib.IsNull(i_sidebarItems)) {
      i_sidebarItems = InitializeSidebarItemsArray(9);
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_ricercamassaBO BO) {
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
      i_contextmenu = InitializeContextMenuArray(9);
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
    l_translations=new String[][]{{"10100846317",p_Context.Translate("Beneficiari")},
    {"1018311362",p_Context.Translate("Tipo intermediario")},
    {"10230641450",p_Context.Translate("Ricerca di massa")},
    {"10523305189",p_Context.Translate("Sono selezionabili al massimo 15 attributi")},
    {"10622103675",p_Context.Translate("Stamp il risultato delle selezioni")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"10787309997",p_Context.Translate("Rapporti Continuativi")},
    {"10886683082",p_Context.Translate("Intermediari ControParte")},
    {"11070292036",p_Context.Translate("Soggetti Operanti")},
    {"11155509822",p_Context.Translate("Non si posso inserire più di 10 richieste")},
    {"11404054622",p_Context.Translate("Intermediari")},
    {"11429056727",p_Context.Translate("Tipi Documento")},
    {"11456106420",p_Context.Translate("Soggetti per conto del quale ...")},
    {"11464190038",p_Context.Translate("Intestatari")},
    {"12027767980",p_Context.Translate("Codice Valuta")},
    {"12090037306",p_Context.Translate("Valute / Divise")},
    {"1270140318",p_Context.Translate("Dipendenze")},
    {"15186643",p_Context.Translate("Città")},
    {"1723736132",p_Context.Translate("Tipo Rapporto")},
    {"2063759932",p_Context.Translate("Località")},
    {"215310487",p_Context.Translate("Causale Sintetica")},
    {"215536597",p_Context.Translate("Causale Analitica")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"496599153",p_Context.Translate("Settorizzazione Sintetica")},
    {"6863571",p_Context.Translate("Citta")},
    {"711862875",p_Context.Translate("Tipo Telgame")},
    {"7383187",p_Context.Translate("Stati")},
    {"807557430",p_Context.Translate("Ramo/Gruppo Attività Economica")},
    {"845327127",p_Context.Translate("Sottogruppi Attività Economica")}};
    return l_translations;
  }
  void WriteStyles(armt_ricercamassaBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_ricercamassa.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_ricercamassaBO BO,ServletStatus status) {
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
    status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("Archivio di ricerca"),"C",0,0)+"},{name:\"page_2\", element:\"page_2\", caption:"+SPLib.ToJSValue(status.context.Translate("Tipo A"),"C",0,0)+"},{name:\"page_3\", element:\"page_3\", caption:"+SPLib.ToJSValue(status.context.Translate("Tipo B"),"C",0,0)+"},{name:\"page_4\", element:\"page_4\", caption:"+SPLib.ToJSValue(status.context.Translate("Tipo C"),"C",0,0)+"},{name:\"page_5\", element:\"page_5\", caption:"+SPLib.ToJSValue(status.context.Translate("Tipo D"),"C",0,0)+"},{name:\"page_6\", element:\"page_6\", caption:"+SPLib.ToJSValue(status.context.Translate("Tipo E"),"C",0,0)+"},{name:\"page_7\", element:\"page_7\", caption:"+SPLib.ToJSValue(status.context.Translate("Tipo F"),"C",0,0)+"},{name:\"page_8\", element:\"page_8\", caption:"+SPLib.ToJSValue(status.context.Translate("Tipo G"),"C",0,0)+"},{name:\"page_9\", element:\"page_9\", caption:"+SPLib.ToJSValue(status.context.Translate("Tipo H"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
    status.out.println("Z.Tabs.Set('tabs',tabs);");
    status.out.println("} else {");
    status.out.println("var tabs = Z.Tabs.Get('tabs')");
    status.out.println("}");
    AddExtendedTabs(status);
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_ricercamassa',false);");
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_ricercamassa",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(armt_ricercamassaBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    WriteControls_p2(BO,status);
    WriteControls_p3(BO,status);
    WriteControls_p4(BO,status);
    WriteControls_p5(BO,status);
    WriteControls_p6(BO,status);
    WriteControls_p7(BO,status);
    WriteControls_p8(BO,status);
    WriteControls_p9(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,10);
  }
  void WriteControls_p1(armt_ricercamassaBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:404px;width:757px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"Archivio di ricerca");
    PrintSidebarContent(1,status,getSidebarItems(0),false);
    PrintContextMenu(1,status,getContextMenu(0),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2(armt_ricercamassaBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_2' class='PageContainer' style='position:relative;height:467px;width:757px;display:none'>" +
    "");
    WriteControls_p2_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,2,"Tipo A");
    PrintSidebarContent(2,status,getSidebarItems(1),false);
    PrintContextMenu(2,status,getContextMenu(1),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3(armt_ricercamassaBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_3' class='PageContainer' style='position:relative;height:441px;width:757px;display:none'>" +
    "");
    WriteControls_p3_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,3,"Tipo B");
    PrintSidebarContent(3,status,getSidebarItems(2),false);
    PrintContextMenu(3,status,getContextMenu(2),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p4(armt_ricercamassaBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_4' class='PageContainer' style='position:relative;height:441px;width:757px;display:none'>" +
    "");
    WriteControls_p4_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,4,"Tipo C");
    PrintSidebarContent(4,status,getSidebarItems(3),false);
    PrintContextMenu(4,status,getContextMenu(3),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p5(armt_ricercamassaBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_5' class='PageContainer' style='position:relative;height:441px;width:757px;display:none'>" +
    "");
    WriteControls_p5_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,5,"Tipo D");
    PrintSidebarContent(5,status,getSidebarItems(4),false);
    PrintContextMenu(5,status,getContextMenu(4),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p6(armt_ricercamassaBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_6' class='PageContainer' style='position:relative;height:441px;width:757px;display:none'>" +
    "");
    WriteControls_p6_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,6,"Tipo E");
    PrintSidebarContent(6,status,getSidebarItems(5),false);
    PrintContextMenu(6,status,getContextMenu(5),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p7(armt_ricercamassaBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_7' class='PageContainer' style='position:relative;height:441px;width:757px;display:none'>" +
    "");
    WriteControls_p7_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,7,"Tipo F");
    PrintSidebarContent(7,status,getSidebarItems(6),false);
    PrintContextMenu(7,status,getContextMenu(6),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p8(armt_ricercamassaBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_8' class='PageContainer' style='position:relative;height:441px;width:757px;display:none'>" +
    "");
    WriteControls_p8_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,8,"Tipo G");
    PrintSidebarContent(8,status,getSidebarItems(7),false);
    PrintContextMenu(8,status,getContextMenu(7),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p9(armt_ricercamassaBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_9' class='PageContainer' style='position:relative;height:441px;width:757px;display:none'>" +
    "");
    WriteControls_p9_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,9,"Tipo H");
    PrintSidebarContent(9,status,getSidebarItems(8),false);
    PrintContextMenu(9,status,getContextMenu(8),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b0(armt_ricercamassaBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='position:relative;height:404px'>" +
    "");
    status.out.println(
     "<div id='XLKFOZPJVO_DIV' class='UntitledBox'>" +
     "<div id='XLKFOZPJVO' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MHSMCGMELQ_DIV'>" +
     "<label id='MHSMCGMELQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Archivio di ricerca:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='archivio' id='WBNIEXDKHU' class='"+status.ObligatoryClass("Combobox")+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("O","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("O",CPLib.Trim(BO.w_archivio))?"SELECTED":"")+">" +
     ""+status.context.Translate("Operazioni Ordinarie")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("I","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("I",CPLib.Trim(BO.w_archivio))?"SELECTED":"")+">" +
     ""+status.context.Translate("Informazioni sui rapporti")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("F","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("F",CPLib.Trim(BO.w_archivio))?"SELECTED":"")+">" +
     ""+status.context.Translate("Frazionate")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("T","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("T",CPLib.Trim(BO.w_archivio))?"SELECTED":"")+">" +
     ""+status.context.Translate("Legami tra Soggetti")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("S","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("S",CPLib.Trim(BO.w_archivio))?"SELECTED":"")+">" +
     ""+status.context.Translate("Storico Rapporti")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("X","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("X",CPLib.Trim(BO.w_archivio))?"SELECTED":"")+">" +
     ""+status.context.Translate("Storico Operazioni")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('WBNIEXDKHU'),w_archivio,'C');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_GHJKYVCUZI()' tabindex='-1' id='GHJKYVCUZI_HREF'>" +
     "<img id='GHJKYVCUZI' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/print.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Stamp il risultato delle selezioni"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Stamp il risultato delle selezioni"),"C",0,0)+">" +
     "</a>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QZKKQLMHBR_DIV'>" +
     "<label id='QZKKQLMHBR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Attributi Selezionati:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='attsel' id='FZSXKHMBWI' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_attsel,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZROWGDZUEC_DIV'>" +
     "<label id='ZROWGDZUEC'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Richieste:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='richieste' id='BYZREJKUOL' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_richieste,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b0(armt_ricercamassaBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='position:relative;height:467px'>" +
    "");
    status.out.println(
     "<div id='KVGFUZUMZV_DIV' class='UntitledBox'>" +
     "<div id='KVGFUZUMZV' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<div id='ZRLFCCXZUM_DIV' class='UntitledBox'>" +
     "<div id='ZRLFCCXZUM' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QFEJRPWHYK_DIV'>" +
     "<label id='QFEJRPWHYK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A01a. Tipo Intermediario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='A01A' id='TESHVPIZQD' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value>" +
     "</option>" +
     "</select>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VNVWZFEUHE_DIV'>" +
     "<label id='VNVWZFEUHE'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A01b.Codice Intermediario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A01B' id='TIPXBDXITE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A01B,"C",11,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='11' size='11' fieldtype='C'>" +
     "<button id='TIPXBDXITE_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "TIPXBDXITE", "intermbo", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CHADKUQQIO_DIV'>" +
     "<label id='CHADKUQQIO'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xraginter)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LDOCLAAARK_DIV'>" +
     "<label id='LDOCLAAARK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A03.Identificativo Registrazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A03' id='MXWTPQUTBB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A03,"C",20,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='20' size='20' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IRZBSCAUFG_DIV'>" +
     "<label id='IRZBSCAUFG'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A11.Codice Dipendenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A11' id='BQNMQAOIPA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A11,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
     "<button id='BQNMQAOIPA_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "BQNMQAOIPA", "anadip", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='EAYOQYEKSN_DIV'>" +
     "<label id='EAYOQYEKSN'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdesdip)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VYDUOMMXQS_DIV'>" +
     "<label id='VYDUOMMXQS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A12a. CAB Comune Dipendenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A12A' id='XHIBDWLIOD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A12A,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
     "<button id='XHIBDWLIOD_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "XHIBDWLIOD", "tbcitta", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FQDUTIBRWF_DIV'>" +
     "<label id='FQDUTIBRWF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A12b. Comune Dipendenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A12B' id='IFYLHOXPRS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A12B,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
     "<button id='IFYLHOXPRS_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "IFYLHOXPRS", "tbcitta", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QMDPACOUBB_DIV'>" +
     "<label id='QMDPACOUBB'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A12c. Sigla Provincia Dipendenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A12C' id='WZNDKFWJMU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A12C,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FESIXUVFYS_DIV'>" +
     "<label id='FESIXUVFYS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A21. Data Operazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A21' id='OOVOWNWMZK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A21,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VMHYCUTRMT_DIV'>" +
     "<label id='VMHYCUTRMT'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A22. Flag Frazionata:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='A22' id='TPGCMCINSD' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue(0,"N",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq(0,BO.w_A22)?"SELECTED":"")+">" +
     ""+status.context.Translate("")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(2,"N",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq(2,BO.w_A22)?"SELECTED":"")+">" +
     ""+status.context.Translate("Si")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(3,"N",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq(3,BO.w_A22)?"SELECTED":"")+">" +
     ""+status.context.Translate("No")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue(1,"N",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq(1,BO.w_A22)?"SELECTED":"")+">" +
     ""+status.context.Translate("N + F")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('TPGCMCINSD'),w_A22,'N');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PNKIIXBJDA_DIV'>" +
     "<label id='PNKIIXBJDA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A23. Flag Contanti:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='A23' id='NPNITFAIKW' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("0","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("0",CPLib.Trim(BO.w_A23))?"SELECTED":"")+">" +
     ""+status.context.Translate("No")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_A23))?"SELECTED":"")+">" +
     ""+status.context.Translate("Si")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('NPNITFAIKW'),w_A23,'C');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HSRFLEDTES_DIV'>" +
     "<label id='HSRFLEDTES'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A24. Causale Analitica:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A24' id='CKACALWZOL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A24,"C",4,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='4' fieldtype='C'>" +
     "<button id='CKACALWZOL_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "CKACALWZOL", "tbcauana", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='BXEMZOFNPA_DIV'>" +
     "<label id='BXEMZOFNPA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A25. Codice Voce:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A25' id='ZIMEUPPLZY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A25,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
     "<button id='ZIMEUPPLZY_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "ZIMEUPPLZY", "tbcausin", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XIRGQJSHDT_DIV'>" +
     "<label id='XIRGQJSHDT'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A31a. Tipo Intermediario C/Parte:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='A31A' id='EHNAPBXMAR' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value>" +
     "</option>" +
     "</select>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YGQKXHEHWV_DIV'>" +
     "<label id='YGQKXHEHWV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A31b.Cod. Intermediario C/Parte:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A31B' id='ZZQPEDWGCO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A31B,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='10' fieldtype='C'>" +
     "<button id='ZZQPEDWGCO_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "ZZQPEDWGCO", "inter2bo", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='EKNQTHCUHI_DIV'>" +
     "<label id='EKNQTHCUHI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A32. Paese Intermediario C/Parte:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A32' id='LTUCQORMSA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A32,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='LTUCQORMSA_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "LTUCQORMSA", "tbstati", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CATDSTXWKN_DIV'>" +
     "<label id='CATDSTXWKN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A33a. CAB Comune Inter. C/Parte:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A33A' id='VDWEKDDBOW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A33A,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
     "<button id='VDWEKDDBOW_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "VDWEKDDBOW", "tbcitta", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SQXLNELNGN_DIV'>" +
     "<label id='SQXLNELNGN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A33b. Comune Inter. C/Parte:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A33B' id='BICDANUWZD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A33B,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
     "<button id='BICDANUWZD_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "BICDANUWZD", "tbcitta", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IRSQCXIFGH_DIV'>" +
     "<label id='IRSQCXIFGH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A33c. Provincia Inter. C/Parte:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A33C' id='OCRIGUNQVR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A33C,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='EENJYSYKCW_DIV'>" +
     "<label id='EENJYSYKCW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A34. Denominazione Inter. C/Parte:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A34' id='PGJPWEXBVK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A34,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ITOWAQHNXI_DIV'>" +
     "<label id='ITOWAQHNXI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A41. Rapporto Continuativo:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A41' id='HDIAJDVNVI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A41,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
     "<button id='HDIAJDVNVI_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "HDIAJDVNVI", "anarapbo", "", "")+"" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A42' id='RQJLOLNIHM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A42,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='1' size='1' fieldtype='C'>" +
     "<button id='RQJLOLNIHM_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "RQJLOLNIHM", "tbtipnat", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ARPEUWGQUZ_DIV'>" +
     "<label id='ARPEUWGQUZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A42. Flag Rapporto:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SHTEYUGPPB_DIV'>" +
     "<label id='SHTEYUGPPB'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A43. Tipo Legame Sogg. Operante:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A43' id='CHJJABTJCS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A43,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='1' size='1' fieldtype='C'>" +
     "<button id='CHJJABTJCS_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "CHJJABTJCS", "tbtipleg", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KGCQSTGBFX_DIV'>" +
     "<label id='KGCQSTGBFX'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xtipleg)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CPEXVRTGQH_DIV'>" +
     "<label id='CPEXVRTGQH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A51. Data registrazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A51' id='KFDSCJBSLJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A51,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DYHSKTUMPC_DIV'>" +
     "<label id='DYHSKTUMPC'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A52. Tipo Registrazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='A52B' id='DFFBWGMKTL' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value>" +
     "</option>" +
     "</select>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A53' id='JPOXBHVIYE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A53,"C",12,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='12' size='12' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SQHEEDSHGD_DIV'>" +
     "<label id='SQHEEDSHGD'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A54a. Codice Stato Registrazione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='A54A' id='VJIDPHKDWI' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("0","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("0",CPLib.Trim(BO.w_A54A))?"SELECTED":"")+">" +
     ""+status.context.Translate("Operazione attiva")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_A54A))?"SELECTED":"")+">" +
     ""+status.context.Translate("Operazione Modificata")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_A54A))?"SELECTED":"")+">" +
     ""+status.context.Translate("Operazione Cancellata")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("3","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("3",CPLib.Trim(BO.w_A54A))?"SELECTED":"")+">" +
     ""+status.context.Translate("Copia Operazione Modificata")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('VJIDPHKDWI'),w_A54A,'C');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ASELJDEKCP_DIV'>" +
     "<label id='ASELJDEKCP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A54b. Data della rettifica:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A54B' id='XYVBVXLTXA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A54B,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='A54C' id='MSZJBMMVGZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_A54C,"C",20,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='20' size='20' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MMOVRNNECE_DIV'>" +
     "<label id='MMOVRNNECE'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A54c. Id. Operazione Modificata:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CWOTTEUVHI_DIV'>" +
     "<label id='CWOTTEUVHI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Attributi Selezionati:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='attsel' id='TMUPYJLPKP' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_attsel,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CHHIMCXSDZ_DIV'>" +
     "<label id='CHHIMCXSDZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Richieste:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='richieste' id='THCRJKNXGZ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_richieste,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MBUECIPZTY_DIV'>" +
     "<label id='MBUECIPZTY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A53. Connessione operazioni:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b0(armt_ricercamassaBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='position:relative;height:441px'>" +
    "");
    status.out.println(
     "<div id='YOZVQCHKHW_DIV' class='UntitledBox'>" +
     "<div id='YOZVQCHKHW' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='B11' id='EPMUHBJYIP' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("L","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("L",CPLib.Trim(BO.w_B11))?"SELECTED":"")+">" +
     ""+status.context.Translate("Lira")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("E","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("E",CPLib.Trim(BO.w_B11))?"SELECTED":"")+">" +
     ""+status.context.Translate("Euro")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("V","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("V",CPLib.Trim(BO.w_B11))?"SELECTED":"")+">" +
     ""+status.context.Translate("Valuta Estera")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('EPMUHBJYIP'),w_B11,'C');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='B12' id='CDFYKKBMYS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_B12,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='CDFYKKBMYS_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "CDFYKKBMYS", "tbvalute", "", "")+"" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='B13' id='AREEANYKOU' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("A","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("A",CPLib.Trim(BO.w_B13))?"SELECTED":"")+">" +
     ""+status.context.Translate("Avere")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("D","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("D",CPLib.Trim(BO.w_B13))?"SELECTED":"")+">" +
     ""+status.context.Translate("Dare")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('AREEANYKOU'),w_B13,'C');" +
     "</script>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='B14' id='SOZNPELALO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_B14,"N",19,0,"9,999,999,999,999,999,999", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='28' size='19' fieldtype='N'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='B15' id='DNCCUIFECE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_B15,"N",19,0,"9,999,999,999,999,999,999", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='28' size='19' fieldtype='N'>" +
    "");
    status.out.println(
     "<div id='CSGINFLFWZ_DIV' class='UntitledBox'>" +
     "<div id='CSGINFLFWZ' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VLQMGDWCRQ_DIV'>" +
     "<label id='VLQMGDWCRQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Attributi Selezionati:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='attsel' id='JIDZAAHINH' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_attsel,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QOKCZHSIMS_DIV'>" +
     "<label id='QOKCZHSIMS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Richieste:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='richieste' id='DAPKMAFMRM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_richieste,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TIWFTFIKJB_DIV'>" +
     "<label id='TIWFTFIKJB'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("B11 Lire/Euro Valuta:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZGTLDBJSNA_DIV'>" +
     "<label id='ZGTLDBJSNA'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdesval)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SIDHJTYMEM_DIV'>" +
     "<label id='SIDHJTYMEM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("B12. Codice Divisa:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OXNUSNGVOZ_DIV'>" +
     "<label id='OXNUSNGVOZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("B13. Segno monetario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PIIBXVVRPP_DIV'>" +
     "<label id='PIIBXVVRPP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("B14. Totale Lire / Euro * 100:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ILSARIWRNJ_DIV'>" +
     "<label id='ILSARIWRNJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("B15. Contanti Lire / Euro * 100:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HANAAGYCXB_DIV'>" +
     "<label id='HANAAGYCXB'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Operatore di confronto:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<div id='CFQDRXVJLE_DIV'>" +
     "<span id='CFQDRXVJLE_0_container'>" +
     "<input id='CFQDRXVJLE_0' name='CFQDRXVJLE' type='radio' value="+SPLib.ToHTMLValue(">","C",2,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(">",CPLib.Trim(BO.w_X_B14_OP))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='CFQDRXVJLE_0'>"+status.context.Translate(">")+"</label>" +
     "</span>" +
     "<span id='CFQDRXVJLE_1_container'>" +
     "<input id='CFQDRXVJLE_1' name='CFQDRXVJLE' type='radio' value="+SPLib.ToHTMLValue(">=","C",2,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(">=",CPLib.Trim(BO.w_X_B14_OP))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='CFQDRXVJLE_1'>"+status.context.Translate(">=")+"</label>" +
     "</span>" +
     "<span id='CFQDRXVJLE_2_container'>" +
     "<input id='CFQDRXVJLE_2' name='CFQDRXVJLE' type='radio' value="+SPLib.ToHTMLValue("<=","C",2,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("<=",CPLib.Trim(BO.w_X_B14_OP))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='CFQDRXVJLE_2'>"+status.context.Translate("<=")+"</label>" +
     "</span>" +
     "<span id='CFQDRXVJLE_3_container'>" +
     "<input id='CFQDRXVJLE_3' name='CFQDRXVJLE' type='radio' value="+SPLib.ToHTMLValue("<","C",2,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("<",CPLib.Trim(BO.w_X_B14_OP))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='CFQDRXVJLE_3'>"+status.context.Translate("<")+"</label>" +
     "</span>" +
     "<span id='CFQDRXVJLE_4_container'>" +
     "<input id='CFQDRXVJLE_4' name='CFQDRXVJLE' type='radio' value="+SPLib.ToHTMLValue("=","C",2,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("=",CPLib.Trim(BO.w_X_B14_OP))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='CFQDRXVJLE_4'>"+status.context.Translate("=")+"</label>" +
     "</span>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YCHGPBZPNV_DIV'>" +
     "<label id='YCHGPBZPNV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Operatore di confronto:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<div id='JNSSKKSFRO_DIV'>" +
     "<span id='JNSSKKSFRO_0_container'>" +
     "<input id='JNSSKKSFRO_0' name='JNSSKKSFRO' type='radio' value="+SPLib.ToHTMLValue(">","C",2,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(">",CPLib.Trim(BO.w_X_B15_OP))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='JNSSKKSFRO_0'>"+status.context.Translate(">")+"</label>" +
     "</span>" +
     "<span id='JNSSKKSFRO_1_container'>" +
     "<input id='JNSSKKSFRO_1' name='JNSSKKSFRO' type='radio' value="+SPLib.ToHTMLValue(">=","C",2,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(">=",CPLib.Trim(BO.w_X_B15_OP))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='JNSSKKSFRO_1'>"+status.context.Translate(">=")+"</label>" +
     "</span>" +
     "<span id='JNSSKKSFRO_2_container'>" +
     "<input id='JNSSKKSFRO_2' name='JNSSKKSFRO' type='radio' value="+SPLib.ToHTMLValue("<=","C",2,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("<=",CPLib.Trim(BO.w_X_B15_OP))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='JNSSKKSFRO_2'>"+status.context.Translate("<=")+"</label>" +
     "</span>" +
     "<span id='JNSSKKSFRO_3_container'>" +
     "<input id='JNSSKKSFRO_3' name='JNSSKKSFRO' type='radio' value="+SPLib.ToHTMLValue("<","C",2,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("<",CPLib.Trim(BO.w_X_B15_OP))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='JNSSKKSFRO_3'>"+status.context.Translate("<")+"</label>" +
     "</span>" +
     "<span id='JNSSKKSFRO_4_container'>" +
     "<input id='JNSSKKSFRO_4' name='JNSSKKSFRO' type='radio' value="+SPLib.ToHTMLValue("=","C",2,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("=",CPLib.Trim(BO.w_X_B15_OP))?"CHECKED":"")+">" +
     "<label class='SPLabel' for='JNSSKKSFRO_4'>"+status.context.Translate("=")+"</label>" +
     "</span>" +
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p4_b0(armt_ricercamassaBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='position:relative;height:441px'>" +
    "");
    status.out.println(
     "<div id='KRHDYFEJWS_DIV' class='UntitledBox'>" +
     "<div id='KRHDYFEJWS' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<div id='IAWYMLKEQC_DIV' class='UntitledBox'>" +
     "<div id='IAWYMLKEQC' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TNVUEPXDLS_DIV'>" +
     "<label id='TNVUEPXDLS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Attributi Selezionati:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='attsel' id='HZTWRPMZIJ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_attsel,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='AMZCYHAYVW_DIV'>" +
     "<label id='AMZCYHAYVW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Richieste:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='richieste' id='JEKIPUJSNX' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_richieste,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RNLMFMRNOH_DIV'>" +
     "<label id='RNLMFMRNOH'>" +
     ""+SPLib.ToHTMLRepresentation((CPLib.eq(BO.w_archivio,"T")?"C11. Sogg. Primario Legame:":"C11. Codice Cliente Intestatario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='C11' id='BZRDFHBMPM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_C11,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
     "<button id='BZRDFHBMPM_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "BZRDFHBMPM", "personbo", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ETLYWIFSII_DIV'>" +
     "<label id='ETLYWIFSII'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xragintes)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IDHSNDCTMV_DIV' style='display:none'>" +
     "<label id='IDHSNDCTMV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("C21. Sogg. Oper. Conto Terzi:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='C21' id='UYRQHSBRRT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_C21,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C' style='display:none'>" +
     "<button id='UYRQHSBRRT_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" style='display:none'>" +
     "</button>" +
     ""+EventuallyContextMenu(status, "UYRQHSBRRT", "personbo", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LVWOATBCKV_DIV' style='display:none'>" +
     "<label id='LVWOATBCKV'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xragsogope)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VZSHOQLWNK_DIV' style='display:none'>" +
     "<label id='VZSHOQLWNK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("C31. Codice Beneficiario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='C31' id='PMFBITPOAZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_C31,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C' style='display:none'>" +
     "<button id='PMFBITPOAZ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" style='display:none'>" +
     "</button>" +
     ""+EventuallyContextMenu(status, "PMFBITPOAZ", "personbo", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CGEIVVOXXA_DIV' style='display:none'>" +
     "<label id='CGEIVVOXXA'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xragbenef)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TNXYMTDNHM_DIV' style='display:none'>" +
     "<label id='TNXYMTDNHM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("C41. Sogg. Secondario Legame:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='C41' id='LZSKLOQPNQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_C41,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C' style='display:none'>" +
     "<button id='LZSKLOQPNQ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+" style='display:none'>" +
     "</button>" +
     ""+EventuallyContextMenu(status, "LZSKLOQPNQ", "personbo", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RNOHNHPWKP_DIV' style='display:none'>" +
     "<label id='RNOHNHPWKP'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xragsecond)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UHBKFQBEEX_DIV'>" +
     "<label id='UHBKFQBEEX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("C51. Soggetto per conto del quale:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='C51' id='RHMPOMWSNG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_C51,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
     "<button id='RHMPOMWSNG_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "RHMPOMWSNG", "personbo", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MOREOSGKEO_DIV'>" +
     "<label id='MOREOSGKEO'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xragterzo)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p5_b0(armt_ricercamassaBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='position:relative;height:441px'>" +
    "");
    status.out.println(
     "<div id='EVPFVSEQYP_DIV' class='UntitledBox'>" +
     "<div id='EVPFVSEQYP' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<div id='RWWUWNLOQE_DIV' class='UntitledBox'>" +
     "<div id='RWWUWNLOQE' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='EXOKGLLODC_DIV'>" +
     "<label id='EXOKGLLODC'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Attributi Selezionati:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='attsel' id='QIFUBGYUZF' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_attsel,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OKYOYCFRUX_DIV'>" +
     "<label id='OKYOYCFRUX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Richieste:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='richieste' id='CNGNVBWJSY' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_richieste,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UPATPCHUKQ_DIV'>" +
     "<label id='UPATPCHUKQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("D11. Cliente Intestatario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='D11' id='OQJHGGFCNJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_D11,"C",70,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='70' size='70' fieldtype='C'>" +
     "<button id='OQJHGGFCNJ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "OQJHGGFCNJ", "personbo", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KITFEGEWOH_DIV'>" +
     "<label id='KITFEGEWOH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("D13. Codice Paese Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='D13' id='GMCYYELLWW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_D13,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='GMCYYELLWW_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "GMCYYELLWW", "tbstati", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PJLUBXHKKN_DIV'>" +
     "<label id='PJLUBXHKKN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("D14a. CAB Comune Reside. Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='D14A' id='VZGLYXBMQI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_D14A,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
     "<button id='VZGLYXBMQI_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "VZGLYXBMQI", "tbcitta", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='BBWAKOQIYQ_DIV'>" +
     "<label id='BBWAKOQIYQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("D14b. Comune Residenza Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='D14B' id='YRFNYFRQSY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_D14B,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
     "<button id='YRFNYFRQSY_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "YRFNYFRQSY", "tbcitta", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TGASSPVQNV_DIV'>" +
     "<label id='TGASSPVQNV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("D14c. Provincia Residenza Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='D14C' id='RLWWENBDDD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_D14C,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ECJOMBFBWF_DIV'>" +
     "<label id='ECJOMBFBWF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("D15. Indirizzo Residenza Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='D15' id='YCLKMEZUZX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_D15,"C",35,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='35' size='35' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CIQLFTONTH_DIV'>" +
     "<label id='CIQLFTONTH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("D16. C.A.P. Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='D16' id='ZIKKMNZCHI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_D16,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PBQVXZCDEF_DIV'>" +
     "<label id='PBQVXZCDEF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("D17. Codice Fiscale Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='D17' id='UEISEWDTOW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_D17,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NQAOSFTGWF_DIV'>" +
     "<label id='NQAOSFTGWF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("D18. Data Nascita Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='D18' id='AZIQXZISZO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_D18,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SMUYYNVEQP_DIV'>" +
     "<label id='SMUYYNVEQP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("D19. Comune Nascita Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='D19A' id='ZGFXMEVTVH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_D19A,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
     "<button id='ZGFXMEVTVH_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "ZGFXMEVTVH", "tbcitta", "", "")+"" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='D19B' id='RVQNZAINRJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_D19B,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
     "<button id='RVQNZAINRJ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "RVQNZAINRJ", "tbstati", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HKSQSRUJMZ_DIV'>" +
     "<label id='HKSQSRUJMZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("D21. Sottog. Att. Econ. Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='D21' id='DXFRERNUEZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_D21,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='DXFRERNUEZ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "DXFRERNUEZ", "tbstgru", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JKQBFYSMDS_DIV'>" +
     "<label id='JKQBFYSMDS'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdessoteco)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RYAOPPQUAH_DIV'>" +
     "<label id='RYAOPPQUAH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("D22. Ramo/Grp.. Att. Econ. Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='D22' id='QZTKKLVNJB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_D22,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='QZTKKLVNJB_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "QZTKKLVNJB", "tbramgru", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OGXVSQJGJW_DIV'>" +
     "<label id='OGXVSQJGJW'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdesramgrp)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='AVSQBPTKYQ_DIV'>" +
     "<label id='AVSQBPTKYQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("D23. Settorizzaz. Sintetica Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='D23' id='RIPVAPFZCO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_D23,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='RIPVAPFZCO_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "RIPVAPFZCO", "tbsetsin", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XLGVTZHKKD_DIV'>" +
     "<label id='XLGVTZHKKD'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdessetsin)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FGAKDZPMIG_DIV'>" +
     "<label id='FGAKDZPMIG'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("D41. Tipo Documento Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='D41' id='QDVHTXVAEJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_D41,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
     "<button id='QDVHTXVAEJ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "QDVHTXVAEJ", "tbtipdoc", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KDMNUBFBED_DIV'>" +
     "<label id='KDMNUBFBED'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdestipdoc)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DTMKARNGFH_DIV'>" +
     "<label id='DTMKARNGFH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("D42. Numero Documento Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='D42' id='ZZPDVGQXEP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_D42,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OMNEKUTPPQ_DIV'>" +
     "<label id='OMNEKUTPPQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("D43. Data Rilascio Documento Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='D43' id='TCBOHGKRMJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_D43,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VVONWAFQOT_DIV'>" +
     "<label id='VVONWAFQOT'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("D44. Autorità e Luogo Rilascio:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='D44' id='YSHERQEZOZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_D44,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LDRVQOMLUC_DIV'>" +
     "<label id='LDRVQOMLUC'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("D19. Stato Nascita Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JKYZUXADHY_DIV'>" +
     "<label id='JKYZUXADHY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("D45. Sesso:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='D45' id='GEXJBDRMDF' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_D45))?"SELECTED":"")+">" +
     ""+status.context.Translate("Maschile")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_D45))?"SELECTED":"")+">" +
     ""+status.context.Translate("Femminile")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('GEXJBDRMDF'),w_D45,'C');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p6_b0(armt_ricercamassaBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='position:relative;height:441px'>" +
    "");
    status.out.println(
     "<div id='HKEAENLPXY_DIV' class='UntitledBox'>" +
     "<div id='HKEAENLPXY' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<div id='RKEDQZABYX_DIV' class='UntitledBox'>" +
     "<div id='RKEDQZABYX' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SXXUVRYCBH_DIV'>" +
     "<label id='SXXUVRYCBH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Attributi Selezionati:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='attsel' id='MMCNOUUVWE' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_attsel,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LCRRHHJFHF_DIV'>" +
     "<label id='LCRRHHJFHF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Richieste:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='richieste' id='ITXGQSYKLQ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_richieste,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LTIQECJTED_DIV'>" +
     "<label id='LTIQECJTED'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("E11. Sogg. Operante Conto Terzi:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='E11' id='UMGRLGMHMY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_E11,"C",70,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='70' size='70' fieldtype='C'>" +
     "<button id='UMGRLGMHMY_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "UMGRLGMHMY", "personbo", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CXQOGATSRV_DIV'>" +
     "<label id='CXQOGATSRV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("E13. Codice Paese Sog. Oper.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='E13' id='GXOOZRXYFU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_E13,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='GXOOZRXYFU_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "GXOOZRXYFU", "tbstati", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RIXARQJQBE_DIV'>" +
     "<label id='RIXARQJQBE'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("E14a. CAB Comune Res. Sog.Oper.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='E14A' id='IMIPLTLEAA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_E14A,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
     "<button id='IMIPLTLEAA_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "IMIPLTLEAA", "tbcitta", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LUIGJBMFUW_DIV'>" +
     "<label id='LUIGJBMFUW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("E14b. Comune Resid. Sog. Oper.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='E14B' id='JMWSEEISWG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_E14B,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
     "<button id='JMWSEEISWG_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "JMWSEEISWG", "tbcitta", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TKBWEFZLOK_DIV'>" +
     "<label id='TKBWEFZLOK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("E14c. Provincia Residenza Sog. Oper.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='E14C' id='SHRVLATCSU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_E14C,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JLFXKKIAAW_DIV'>" +
     "<label id='JLFXKKIAAW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("E15. Indirizzo Resid. Sog. Oper.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='E15' id='VOGKTTTAQY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_E15,"C",35,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='35' size='35' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FYHEKMFRKB_DIV'>" +
     "<label id='FYHEKMFRKB'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("E16. C.A.P. Sog. Oper.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='E16' id='CSJKLGPLSD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_E16,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='GCHVAXKWGU_DIV'>" +
     "<label id='GCHVAXKWGU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("E17. Codice Fiscale Sog. Oper.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='E17' id='HZXHSFBWVP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_E17,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SPFWVWEKNI_DIV'>" +
     "<label id='SPFWVWEKNI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("E18. Data Nascita Sog. Oper.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='E18' id='STLDMRXUQZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_E18,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NDAMZGRGWK_DIV'>" +
     "<label id='NDAMZGRGWK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("E41. Tipo Documento Sog. Oper.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='E19A' id='OZDICWDQRW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_E19A,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
     "<button id='OZDICWDQRW_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "OZDICWDQRW", "tbcitta", "", "")+"" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='E19B' id='YSNADFXEBL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_E19B,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
     "<button id='YSNADFXEBL_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "YSNADFXEBL", "tbstati", "", "")+"" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='E41' id='SZZONHIXUX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_E41,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
     "<button id='SZZONHIXUX_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "SZZONHIXUX", "tbtipdoc", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CXEOWDRJVB_DIV'>" +
     "<label id='CXEOWDRJVB'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdestipdocsg)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OKVSRMKJOK_DIV'>" +
     "<label id='OKVSRMKJOK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("E42. N° Documento Sog. Oper.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='E42' id='GVZBHBTNIN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_E42,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JLMMAURJJN_DIV'>" +
     "<label id='JLMMAURJJN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("E43. Data Rilascio Doc. Sog. Oper.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='E43' id='YTZBMCKQSI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_E43,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KDMYNCMQHO_DIV'>" +
     "<label id='KDMYNCMQHO'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("E44. Autorità e Luogo Rilascio:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='E44' id='YQCFUVRDIB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_E44,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MBLKVJSFTS_DIV'>" +
     "<label id='MBLKVJSFTS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("E19. Comune Nascita Sog. Oper.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KOZHYMKNEL_DIV'>" +
     "<label id='KOZHYMKNEL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("E19. Stato Nascita Sog. Oper.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MXCBJNKZYQ_DIV'>" +
     "<label id='MXCBJNKZYQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("E45. Sesso:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='E45' id='RZGRAAMFRQ' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_E45))?"SELECTED":"")+">" +
     ""+status.context.Translate("Maschile")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_E45))?"SELECTED":"")+">" +
     ""+status.context.Translate("Femminile")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('RZGRAAMFRQ'),w_E45,'C');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p7_b0(armt_ricercamassaBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='position:relative;height:441px'>" +
    "");
    status.out.println(
     "<div id='JLTUCUTXFV_DIV' class='UntitledBox'>" +
     "<div id='JLTUCUTXFV' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<div id='EITSLGXPKQ_DIV' class='UntitledBox'>" +
     "<div id='EITSLGXPKQ' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SXKIEJLNFT_DIV'>" +
     "<label id='SXKIEJLNFT'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Attributi Selezionati:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='attsel' id='HZUCYQJVWZ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_attsel,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CSLRNONFNA_DIV'>" +
     "<label id='CSLRNONFNA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Richieste:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='richieste' id='TJQZUIJXJA' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_richieste,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QWBLLJYXNS_DIV'>" +
     "<label id='QWBLLJYXNS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("F11. Beneficiario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='F11' id='XUTATNAFCN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_F11,"C",70,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='70' size='70' fieldtype='C'>" +
     "<button id='XUTATNAFCN_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "XUTATNAFCN", "personbo", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SYHUSLVFCD_DIV'>" +
     "<label id='SYHUSLVFCD'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("F13. Codice Paese Beneficiario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='F13' id='GSQDROOXIH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_F13,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='GSQDROOXIH_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "GSQDROOXIH", "tbstati", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RZYRMOZJVB_DIV'>" +
     "<label id='RZYRMOZJVB'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("F14a. CAB Comune Res. Benefic.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='F14A' id='AYOYZWWHED' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_F14A,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
     "<button id='AYOYZWWHED_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "AYOYZWWHED", "tbcitta", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PZECWLNBMT_DIV'>" +
     "<label id='PZECWLNBMT'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("F14b. Comune Resid. Beneficiario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='F14B' id='ZKDTAIVYNT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_F14B,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
     "<button id='ZKDTAIVYNT_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "ZKDTAIVYNT", "tbcitta", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IATOQRWIHQ_DIV'>" +
     "<label id='IATOQRWIHQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("F14c. Provincia Residenza Beneficiario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='F14C' id='SBSUVGTSQF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_F14C,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DTWECKAHQZ_DIV'>" +
     "<label id='DTWECKAHQZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("F15. Indirizzo Resid. Beneficiario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='F15' id='TFVSJQEFKN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_F15,"C",35,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='35' size='35' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YOBMERVJPM_DIV'>" +
     "<label id='YOBMERVJPM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("F16. C.A.P. Beneficiario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='F16' id='CSKIGUYWKA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_F16,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CXMIQWKTSH_DIV'>" +
     "<label id='CXMIQWKTSH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("F17. Codice Fiscale Beneficiario:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='F17' id='EWALMUXONU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_F17,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p8_b0(armt_ricercamassaBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='position:relative;height:441px'>" +
    "");
    status.out.println(
     "<div id='UOKHMLIEUR_DIV' class='UntitledBox'>" +
     "<div id='UOKHMLIEUR' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<div id='ZGRJNQPUNM_DIV' class='UntitledBox'>" +
     "<div id='ZGRJNQPUNM' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZMPORIFPRF_DIV'>" +
     "<label id='ZMPORIFPRF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Attributi Selezionati:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='attsel' id='SEYNWLHCKS' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_attsel,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TDFJGVRMRA_DIV'>" +
     "<label id='TDFJGVRMRA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Richieste:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='richieste' id='UDWBDWNMCH' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_richieste,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UWBVBSVVUA_DIV'>" +
     "<label id='UWBVBSVVUA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("G11. Titolare:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='G11' id='PGAPCLKWDU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_G11,"C",70,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='70' size='70' fieldtype='C'>" +
     "<button id='PGAPCLKWDU_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "PGAPCLKWDU", "personbo", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CJBHMTGUVX_DIV'>" +
     "<label id='CJBHMTGUVX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("G13. Codice Paese Tit.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='G13' id='NMVYSCDEYI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_G13,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='NMVYSCDEYI_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "NMVYSCDEYI", "tbstati", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FXAWPGUGEY_DIV'>" +
     "<label id='FXAWPGUGEY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("G14a. CAB Comune Reside. Tit.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='G14A' id='IZFSEEEELX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_G14A,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
     "<button id='IZFSEEEELX_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "IZFSEEEELX", "tbcitta", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JTMFWTSPOT_DIV'>" +
     "<label id='JTMFWTSPOT'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("G14b. Comune Residenza Tit.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='G14B' id='RZOPLJQQOD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_G14B,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
     "<button id='RZOPLJQQOD_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "RZOPLJQQOD", "tbcitta", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YNRACSTHKM_DIV'>" +
     "<label id='YNRACSTHKM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("G14c. Provincia Residenza Tit.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='G14C' id='YZZZVPGQXU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_G14C,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='GFQIZPIFCE_DIV'>" +
     "<label id='GFQIZPIFCE'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("G15. Indirizzo Residenza Tit.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='G15' id='YPHNWWQBAM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_G15,"C",35,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='35' size='35' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KXZFCUMEWU_DIV'>" +
     "<label id='KXZFCUMEWU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("G16. C.A.P. Tit.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='G16' id='ALVPQNRJEQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_G16,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UCYULWKFMB_DIV'>" +
     "<label id='UCYULWKFMB'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("G17. Codice Fiscale Tit.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='G17' id='IMPXVWAVVG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_G17,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DXTWNKDPPU_DIV'>" +
     "<label id='DXTWNKDPPU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("G18. Data Nascita Tit.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='G18' id='HICXAQROVP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_G18,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='G19A' id='GSZGYDPMMI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_G19A,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
     "<button id='GSZGYDPMMI_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "GSZGYDPMMI", "tbcitta", "", "")+"" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='G19B' id='HKGGYHAADA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_G19B,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
     "<button id='HKGGYHAADA_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "HKGGYHAADA", "tbstati", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZVVVRLQFHT_DIV'>" +
     "<label id='ZVVVRLQFHT'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("G41. Tipo Documento Tit.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='G41' id='BCOSCDETUR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_G41,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
     "<button id='BCOSCDETUR_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "BCOSCDETUR", "tbtipdoc", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZKBMLTPVQH_DIV'>" +
     "<label id='ZKBMLTPVQH'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdestipdoct)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OCGDPFLIKF_DIV'>" +
     "<label id='OCGDPFLIKF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("G42. Numero Documento Tit.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='G42' id='KTOZCJXWSV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_G42,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZTBBTGYDFF_DIV'>" +
     "<label id='ZTBBTGYDFF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("G43. Data Rilascio Documento Tit.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='G43' id='NVUUMCKUPB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_G43,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KRPFTRBGAY_DIV'>" +
     "<label id='KRPFTRBGAY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("G44. Autorità e Luogo Rilascio:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='G44' id='JRWWNQSHYE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_G44,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FAOYGFYDWQ_DIV'>" +
     "<label id='FAOYGFYDWQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("G19. Comune Nascita Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XHXKUAFOPX_DIV'>" +
     "<label id='XHXKUAFOPX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("G19. Stato Nascita Cliente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DNIOKHMKXP_DIV'>" +
     "<label id='DNIOKHMKXP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("G45. Sesso:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='G45' id='HCXFFYRBOR' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_G45))?"SELECTED":"")+">" +
     ""+status.context.Translate("Maschile")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_G45))?"SELECTED":"")+">" +
     ""+status.context.Translate("Femminile")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('HCXFFYRBOR'),w_G45,'C');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p9_b0(armt_ricercamassaBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='position:relative;height:441px'>" +
    "");
    status.out.println(
     "<div id='OFWGQIZSXD_DIV' class='UntitledBox'>" +
     "<div id='OFWGQIZSXD' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<div id='XECCYIEIAP_DIV' class='UntitledBox'>" +
     "<div id='XECCYIEIAP' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='EDVJDUZOHS_DIV'>" +
     "<label id='EDVJDUZOHS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Attributi Selezionati:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='attsel' id='ODJVXHJRMG' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_attsel,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NJTGFZIVPP_DIV'>" +
     "<label id='NJTGFZIVPP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Richieste:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='richieste' id='WRQUPUNDJP' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_richieste,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VIEBKKOUYW_DIV'>" +
     "<label id='VIEBKKOUYW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("H11. Soggetto per conto del quale:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='H11' id='LWFUPEVCFF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_H11,"C",70,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='70' size='70' fieldtype='C'>" +
     "<button id='LWFUPEVCFF_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "LWFUPEVCFF", "personbo", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JEZUQVAWKX_DIV'>" +
     "<label id='JEZUQVAWKX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("H13. Codice Paese:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='H13' id='LMFVWUIXUQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_H13,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
     "<button id='LMFVWUIXUQ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "LMFVWUIXUQ", "tbstati", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PBBYNFBXGI_DIV'>" +
     "<label id='PBBYNFBXGI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("H14A. CAB Comune Residenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='H14A' id='EVWGKCMMJY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_H14A,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
     "<button id='EVWGKCMMJY_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "EVWGKCMMJY", "tbcitta", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JZEQURMYIA_DIV'>" +
     "<label id='JZEQURMYIA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("H14B. Comune Residenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='H14B' id='UVHIQLABPT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_H14B,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
     "<button id='UVHIQLABPT_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "UVHIQLABPT", "tbcitta", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XACHSHIOBM_DIV'>" +
     "<label id='XACHSHIOBM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("H14C. Provincia Residenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='H14C' id='ERDRBGAWFM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_H14C,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='AFJYTDAGME_DIV'>" +
     "<label id='AFJYTDAGME'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("H15. Indirizzo Residenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='H15' id='QCIYKOSBAC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_H15,"C",35,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='35' size='35' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='BOVZPEFEJL_DIV'>" +
     "<label id='BOVZPEFEJL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("H16. C.A.P.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='H16' id='SDOQENNYTS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_H16,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='REFYDNGVOA_DIV'>" +
     "<label id='REFYDNGVOA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("H17. Codice Fiscale:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='H17' id='MYCAJZEAYR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_H17,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NROFEEDXHZ_DIV'>" +
     "<label id='NROFEEDXHZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("H18. Data Nascita:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='H18' id='MJSLFJOSLC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_H18,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='H19A' id='KCGLCUJYUP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_H19A,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
     "<button id='KCGLCUJYUP_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "KCGLCUJYUP", "tbcitta", "", "")+"" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='H19B' id='RQOFXUOOWZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_H19B,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
     "<button id='RQOFXUOOWZ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "RQOFXUOOWZ", "tbstati", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YAPYXTTVDV_DIV'>" +
     "<label id='YAPYXTTVDV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("H41. Tipo Documento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='H41' id='OAWXXEHPRA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_H41,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
     "<button id='OAWXXEHPRA_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "OAWXXEHPRA", "tbtipdoc", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OBHLLYIHEI_DIV'>" +
     "<label id='OBHLLYIHEI'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdestipdoct1)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RSGEAFOUFH_DIV'>" +
     "<label id='RSGEAFOUFH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("H42. Numero Documento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='H42' id='EVIOJXHHYZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_H42,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OCPLYOVTEC_DIV'>" +
     "<label id='OCPLYOVTEC'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("H43. Data Rilascio Documento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='H43' id='AAPLEODVNN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_H43,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JLWOSLULYH_DIV'>" +
     "<label id='JLWOSLULYH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("H44. Autorità e Luogo Rilascio:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='H44' id='PBYCEMAFOR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_H44,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FOKITCSEDA_DIV'>" +
     "<label id='FOKITCSEDA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("H19. Comune Nascita:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='GLNDCEAZTM_DIV'>" +
     "<label id='GLNDCEAZTM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("H19. Stato Nascita:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IEJJSMSSFK_DIV'>" +
     "<label id='IEJJSMSSFK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("H45. Sesso:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='H45' id='CCGDGWYZHO' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_H45))?"SELECTED":"")+">" +
     ""+status.context.Translate("Maschile")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_H45))?"SELECTED":"")+">" +
     ""+status.context.Translate("Femminile")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('CCGDGWYZHO'),w_H45,'C');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  static void PrintState(armt_ricercamassaBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_ricercamassaBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
  }
  static void PrintStateWorkVars(armt_ricercamassaBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_attsel,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_G11,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_G13,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_G14A,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_G14B,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_G14C,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_G15,"C",35,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_G16,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_G17,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_G18,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_G19A,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_G19B,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_G41,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_G42,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_G43,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_G44,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_F11,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_F13,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_F14A,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_F14B,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_F14C,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_F15,"C",35,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_F16,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_F17,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_E11,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_E13,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_E14A,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_E14B,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_E14C,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_E15,"C",35,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_E16,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_E17,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_E18,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_E19A,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_E19B,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_E41,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_E42,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_E43,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_E44,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_D11,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_D13,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_D14A,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_D14B,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_D14C,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_D15,"C",35,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_D16,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_D17,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_D18,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_D19A,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_D19B,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_D21,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_D22,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_D23,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_D41,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_D42,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_D43,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_D44,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C11,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C21,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C31,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_B11,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_B12,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_B13,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_B14,"N",19,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_B15,"N",19,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_X_B14_OP,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_X_B15_OP,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A01A,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A01B,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A03,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A11,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A12A,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A12B,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A12C,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A21,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A22,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A23,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A24,"C",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A25,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A31A,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A31B,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A32,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A33A,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A33B,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A33C,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A34,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A41,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A42,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A43,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A51,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A52B,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A53,"C",12,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A54A,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A54B,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_A54C,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_IDBASE:BO.w_IDBASE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_archivio,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C41,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C51,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_H11,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_H13,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_H14A,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_H14B,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_H14C,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_H15,"C",35,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_H16,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_H17,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_H18,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_H19A,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_H19B,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_H41,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_H42,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_H43,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_H44,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_D45,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_E45,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_G45,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_H45,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_richieste,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdestipdoct,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdestipdocsg,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdessoteco,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesramgrp,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdessetsin,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdestipdoc,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragintes,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragsogope,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragbenef,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesval,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xraginter,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesdip,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescittab,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xtipleg,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesrap,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_oldval,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragsecond,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragterzo,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdestipdoct1,"C",30,0));
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_ricercamassaBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_CHADKUQQIO = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_EAYOQYEKSN = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_KGCQSTGBFX = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ZGTLDBJSNA = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_RNLMFMRNOH = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ETLYWIFSII = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_LVWOATBCKV = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_CGEIVVOXXA = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_RNOHNHPWKP = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_MOREOSGKEO = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_JKQBFYSMDS = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_OGXVSQJGJW = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_XLGVTZHKKD = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_KDMNUBFBED = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_CXEOWDRJVB = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ZKBMLTPVQH = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_OBHLLYIHEI = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(404,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(757,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_ricercamassa"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'TIPXBDXITE':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"TIPXBDXITE",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,intermbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'BQNMQAOIPA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"BQNMQAOIPA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'XHIBDWLIOD':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"XHIBDWLIOD",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'IFYLHOXPRS':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"IFYLHOXPRS",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'CKACALWZOL':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"CKACALWZOL",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcauana,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZIMEUPPLZY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ZIMEUPPLZY",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcausin,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZZQPEDWGCO':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ZZQPEDWGCO",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,inter2bo,"+"default",l_session)+"'"+"]");
      status.out.print(",'LTUCQORMSA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"LTUCQORMSA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'VDWEKDDBOW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"VDWEKDDBOW",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'BICDANUWZD':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"BICDANUWZD",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'HDIAJDVNVI':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"HDIAJDVNVI",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anarapbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'RQJLOLNIHM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"RQJLOLNIHM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipnat,"+"default",l_session)+"'"+"]");
      status.out.print(",'CHJJABTJCS':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"CHJJABTJCS",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipleg,"+"default",l_session)+"'"+"]");
      status.out.print(",'DFFBWGMKTL':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"DFFBWGMKTL",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipreg,"+"default",l_session)+"'"+"]");
      status.out.print(",'CDFYKKBMYS':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"CDFYKKBMYS",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbvalute,"+"default",l_session)+"'"+"]");
      status.out.print(",'BZRDFHBMPM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"BZRDFHBMPM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'UYRQHSBRRT':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"UYRQHSBRRT",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'PMFBITPOAZ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"PMFBITPOAZ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'LZSKLOQPNQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"LZSKLOQPNQ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'RHMPOMWSNG':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"RHMPOMWSNG",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'OQJHGGFCNJ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"OQJHGGFCNJ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'GMCYYELLWW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"GMCYYELLWW",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'VZGLYXBMQI':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"VZGLYXBMQI",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'YRFNYFRQSY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"YRFNYFRQSY",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZGFXMEVTVH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ZGFXMEVTVH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'RVQNZAINRJ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"RVQNZAINRJ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'DXFRERNUEZ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"DXFRERNUEZ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'QZTKKLVNJB':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QZTKKLVNJB",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'RIPVAPFZCO':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"RIPVAPFZCO",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsetsin,"+"default",l_session)+"'"+"]");
      status.out.print(",'QDVHTXVAEJ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QDVHTXVAEJ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipdoc,"+"default",l_session)+"'"+"]");
      status.out.print(",'UMGRLGMHMY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"UMGRLGMHMY",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'GXOOZRXYFU':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"GXOOZRXYFU",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'IMIPLTLEAA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"IMIPLTLEAA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'JMWSEEISWG':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"JMWSEEISWG",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'OZDICWDQRW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"OZDICWDQRW",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'YSNADFXEBL':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"YSNADFXEBL",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'SZZONHIXUX':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SZZONHIXUX",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipdoc,"+"default",l_session)+"'"+"]");
      status.out.print(",'XUTATNAFCN':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"XUTATNAFCN",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'GSQDROOXIH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"GSQDROOXIH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'AYOYZWWHED':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"AYOYZWWHED",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZKDTAIVYNT':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ZKDTAIVYNT",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'PGAPCLKWDU':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"PGAPCLKWDU",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'NMVYSCDEYI':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NMVYSCDEYI",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'IZFSEEEELX':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"IZFSEEEELX",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'RZOPLJQQOD':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"RZOPLJQQOD",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'GSZGYDPMMI':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"GSZGYDPMMI",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'HKGGYHAADA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"HKGGYHAADA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'BCOSCDETUR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"BCOSCDETUR",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipdoc,"+"default",l_session)+"'"+"]");
      status.out.print(",'LWFUPEVCFF':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"LWFUPEVCFF",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'LMFVWUIXUQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"LMFVWUIXUQ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'EVWGKCMMJY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"EVWGKCMMJY",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'UVHIQLABPT':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"UVHIQLABPT",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'KCGLCUJYUP':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"KCGLCUJYUP",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'RQOFXUOOWZ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"RQOFXUOOWZ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'OAWXXEHPRA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"OAWXXEHPRA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipdoc,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'TIPXBDXITE':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,intermbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'BQNMQAOIPA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'XHIBDWLIOD':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'IFYLHOXPRS':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'CKACALWZOL':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcauana,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZIMEUPPLZY':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcausin,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZZQPEDWGCO':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,inter2bo,"+"default",l_session)+"'"+"]");
      status.out.print(",'LTUCQORMSA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'VDWEKDDBOW':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'BICDANUWZD':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'HDIAJDVNVI':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anarapbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'RQJLOLNIHM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipnat,"+"default",l_session)+"'"+"]");
      status.out.print(",'CHJJABTJCS':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipleg,"+"default",l_session)+"'"+"]");
      status.out.print(",'DFFBWGMKTL':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipreg,"+"default",l_session)+"'"+"]");
      status.out.print(",'CDFYKKBMYS':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbvalute,"+"default",l_session)+"'"+"]");
      status.out.print(",'BZRDFHBMPM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'UYRQHSBRRT':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'PMFBITPOAZ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'LZSKLOQPNQ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'RHMPOMWSNG':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'OQJHGGFCNJ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'GMCYYELLWW':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'VZGLYXBMQI':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'YRFNYFRQSY':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZGFXMEVTVH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'RVQNZAINRJ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'DXFRERNUEZ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'QZTKKLVNJB':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbramgru,"+"default",l_session)+"'"+"]");
      status.out.print(",'RIPVAPFZCO':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsetsin,"+"default",l_session)+"'"+"]");
      status.out.print(",'QDVHTXVAEJ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipdoc,"+"default",l_session)+"'"+"]");
      status.out.print(",'UMGRLGMHMY':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'GXOOZRXYFU':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'IMIPLTLEAA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'JMWSEEISWG':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'OZDICWDQRW':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'YSNADFXEBL':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'SZZONHIXUX':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipdoc,"+"default",l_session)+"'"+"]");
      status.out.print(",'XUTATNAFCN':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'GSQDROOXIH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'AYOYZWWHED':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZKDTAIVYNT':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'PGAPCLKWDU':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'NMVYSCDEYI':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'IZFSEEEELX':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'RZOPLJQQOD':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'GSZGYDPMMI':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'HKGGYHAADA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'BCOSCDETUR':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipdoc,"+"default",l_session)+"'"+"]");
      status.out.print(",'LWFUPEVCFF':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'LMFVWUIXUQ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'EVWGKCMMJY':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'UVHIQLABPT':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'KCGLCUJYUP':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'RQOFXUOOWZ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'OAWXXEHPRA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipdoc,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_ricercamassa","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_ricercamassa",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("box_XLKFOZPJVO"),"")) {
      status.quoteAndAppend("box_XLKFOZPJVO","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_KVGFUZUMZV"),"")) {
      status.quoteAndAppend("box_KVGFUZUMZV","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_ZRLFCCXZUM"),"")) {
      status.quoteAndAppend("box_ZRLFCCXZUM","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_YOZVQCHKHW"),"")) {
      status.quoteAndAppend("box_YOZVQCHKHW","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_CSGINFLFWZ"),"")) {
      status.quoteAndAppend("box_CSGINFLFWZ","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_KRHDYFEJWS"),"")) {
      status.quoteAndAppend("box_KRHDYFEJWS","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_IAWYMLKEQC"),"")) {
      status.quoteAndAppend("box_IAWYMLKEQC","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_EVPFVSEQYP"),"")) {
      status.quoteAndAppend("box_EVPFVSEQYP","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_RWWUWNLOQE"),"")) {
      status.quoteAndAppend("box_RWWUWNLOQE","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_HKEAENLPXY"),"")) {
      status.quoteAndAppend("box_HKEAENLPXY","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_RKEDQZABYX"),"")) {
      status.quoteAndAppend("box_RKEDQZABYX","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_JLTUCUTXFV"),"")) {
      status.quoteAndAppend("box_JLTUCUTXFV","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_EITSLGXPKQ"),"")) {
      status.quoteAndAppend("box_EITSLGXPKQ","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_UOKHMLIEUR"),"")) {
      status.quoteAndAppend("box_UOKHMLIEUR","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_ZGRJNQPUNM"),"")) {
      status.quoteAndAppend("box_ZGRJNQPUNM","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_OFWGQIZSXD"),"")) {
      status.quoteAndAppend("box_OFWGQIZSXD","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_XECCYIEIAP"),"")) {
      status.quoteAndAppend("box_XECCYIEIAP","hide","box");
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
  void WriteMainFormScript(armt_ricercamassaBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_ricercamassa',false);");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('WBNIEXDKHU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TESHVPIZQD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TIPXBDXITE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TIPXBDXITE_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MXWTPQUTBB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BQNMQAOIPA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BQNMQAOIPA_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XHIBDWLIOD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XHIBDWLIOD_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IFYLHOXPRS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IFYLHOXPRS_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WZNDKFWJMU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OOVOWNWMZK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TPGCMCINSD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NPNITFAIKW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CKACALWZOL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CKACALWZOL_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZIMEUPPLZY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZIMEUPPLZY_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EHNAPBXMAR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZZQPEDWGCO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZZQPEDWGCO_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LTUCQORMSA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LTUCQORMSA_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VDWEKDDBOW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VDWEKDDBOW_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BICDANUWZD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BICDANUWZD_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OCRIGUNQVR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PGJPWEXBVK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HDIAJDVNVI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HDIAJDVNVI_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RQJLOLNIHM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RQJLOLNIHM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CHJJABTJCS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CHJJABTJCS_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KFDSCJBSLJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DFFBWGMKTL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JPOXBHVIYE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VJIDPHKDWI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XYVBVXLTXA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MSZJBMMVGZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EPMUHBJYIP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CDFYKKBMYS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CDFYKKBMYS_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AREEANYKOU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SOZNPELALO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DNCCUIFECE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CFQDRXVJLE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JNSSKKSFRO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BZRDFHBMPM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BZRDFHBMPM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UYRQHSBRRT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UYRQHSBRRT_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PMFBITPOAZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PMFBITPOAZ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LZSKLOQPNQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LZSKLOQPNQ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RHMPOMWSNG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RHMPOMWSNG_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OQJHGGFCNJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OQJHGGFCNJ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GMCYYELLWW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GMCYYELLWW_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VZGLYXBMQI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VZGLYXBMQI_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YRFNYFRQSY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YRFNYFRQSY_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RLWWENBDDD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YCLKMEZUZX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZIKKMNZCHI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UEISEWDTOW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AZIQXZISZO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZGFXMEVTVH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZGFXMEVTVH_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RVQNZAINRJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RVQNZAINRJ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DXFRERNUEZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DXFRERNUEZ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QZTKKLVNJB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QZTKKLVNJB_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RIPVAPFZCO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RIPVAPFZCO_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QDVHTXVAEJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QDVHTXVAEJ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZZPDVGQXEP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TCBOHGKRMJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YSHERQEZOZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GEXJBDRMDF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UMGRLGMHMY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UMGRLGMHMY_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GXOOZRXYFU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GXOOZRXYFU_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IMIPLTLEAA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IMIPLTLEAA_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JMWSEEISWG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JMWSEEISWG_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SHRVLATCSU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VOGKTTTAQY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CSJKLGPLSD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HZXHSFBWVP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('STLDMRXUQZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OZDICWDQRW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OZDICWDQRW_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YSNADFXEBL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YSNADFXEBL_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SZZONHIXUX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SZZONHIXUX_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GVZBHBTNIN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YTZBMCKQSI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YQCFUVRDIB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RZGRAAMFRQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XUTATNAFCN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XUTATNAFCN_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GSQDROOXIH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GSQDROOXIH_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AYOYZWWHED')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AYOYZWWHED_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZKDTAIVYNT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZKDTAIVYNT_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SBSUVGTSQF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TFVSJQEFKN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CSKIGUYWKA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EWALMUXONU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PGAPCLKWDU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PGAPCLKWDU_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NMVYSCDEYI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NMVYSCDEYI_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IZFSEEEELX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IZFSEEEELX_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RZOPLJQQOD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RZOPLJQQOD_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YZZZVPGQXU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YPHNWWQBAM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ALVPQNRJEQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IMPXVWAVVG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HICXAQROVP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GSZGYDPMMI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GSZGYDPMMI_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HKGGYHAADA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HKGGYHAADA_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BCOSCDETUR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BCOSCDETUR_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KTOZCJXWSV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NVUUMCKUPB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JRWWNQSHYE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HCXFFYRBOR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LWFUPEVCFF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LWFUPEVCFF_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LMFVWUIXUQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LMFVWUIXUQ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EVWGKCMMJY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EVWGKCMMJY_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UVHIQLABPT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UVHIQLABPT_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ERDRBGAWFM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QCIYKOSBAC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SDOQENNYTS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MYCAJZEAYR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MJSLFJOSLC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KCGLCUJYUP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KCGLCUJYUP_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RQOFXUOOWZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RQOFXUOOWZ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OAWXXEHPRA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OAWXXEHPRA_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EVIOJXHHYZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AAPLEODVNN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PBYCEMAFOR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CCGDGWYZHO')) SetDisabled(c,true);");
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
      }
    }
    status.out.println("FillCombosValues();");
    status.out.println("SetControlsValue();");
    status.out.println("NotifyEvent('Record Loaded');");
    if (status.HasFoundlingChildren()) {
      status.out.println("LoadContext();");
    }
    status.out.println("scaleImage('GHJKYVCUZI',63,100);");
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
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  armt_ricercamassaBO getBO(ServletStatus status) {
    armt_ricercamassaBO BO = new armt_ricercamassaBO(status.context);
    // gli op_ possono essere utilizzati dalla servlet anche prima di essere inizializzati
    BO.op_IDBASE = BO.w_IDBASE;
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_ricercamassaBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("tmp_ricmas1",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_ricercamassaBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_ricercamassaBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbtipint,CPSql.BuildSQLPhrase("TIPOINT,DESCRI",BO.m_cPhName_tbtipint,"","TIPOINT"));
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",2,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("TIPOINT"),"C",2,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var TESHVPIZQD_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbtipint,CPSql.BuildSQLPhrase("TIPOINT,DESCRI",BO.m_cPhName_tbtipint,"","DESCRI"));
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",2,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("TIPOINT"),"C",2,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var EHNAPBXMAR_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbtipreg,CPSql.BuildSQLPhrase("CODICE,DES1",BO.m_cPhName_tbtipreg,"",""));
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
    status.out.println("var DFFBWGMKTL_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(armt_ricercamassaBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_tmp_ricmas1;
    String l_cPhName = BO.m_cPhName_tmp_ricmas1;
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
      String l_cQueryFilter = armt_ricercamassaBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_tmp_ricmas1+".IDBASE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("tmp_ricmas1");
    String l_cPhName = CPSql.ManipulateTablePhName("tmp_ricmas1",l_cServer);
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
  void Query(ServletStatus status,armt_ricercamassaBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_ricercamassaBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_tmp_ricmas1,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_tmp_ricmas1,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_ricercamassaBO BO) {
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
  void Edit(ServletStatus status,armt_ricercamassaBO BO,SPParameterSource source) {
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
  void New(ServletStatus status,armt_ricercamassaBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_ricercamassaBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_ricercamassaBO BO) {
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
  void EditLoad(ServletStatus status,armt_ricercamassaBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_ricercamassaBO BO,SPParameterSource source) {
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
  void DeleteMessage(ServletStatus status,armt_ricercamassaBO BO,SPParameterSource source) {
    BO.Load(status.w_IDBASE);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_ricercamassaBO BO) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    String l_cTransMsgErr = "";
    BO.SetFromContext(status.m_cWv,status.m_Parameters);
    String l_old_IDBASE = "";
    if (CPLib.ne(BO.w_IDBASE,BO.op_IDBASE)) {
      l_old_IDBASE = BO.op_IDBASE;
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
  void Discard(ServletStatus status,armt_ricercamassaBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_ricercamassaBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",404);
    item.put("w",757);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","true");
    org.json.JSONObject pageProp = null;
    org.json.JSONArray pagesProp = null;
    pagesProp = new org.json.JSONArray();
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Archivio di ricerca\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Tipo A\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Tipo B\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Tipo C\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Tipo D\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Tipo E\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Tipo F\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Tipo G\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Tipo H\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Archivio di ricerca,Tipo A,Tipo B,Tipo C,Tipo D,Tipo E,Tipo F,Tipo G,Tipo H");
    item.put("altInterfaceFor","armt_ricercamassa");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_XLKFOZPJVO\",\"h\":399,\"name\":\"box_XLKFOZPJVO\",\"page\":1,\"shrinkable\":true,\"spuid\":\"XLKFOZPJVO\",\"tabindex\":1,\"type\":\"Box\",\"w\":752,\"x\":0,\"y\":0,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MHSMCGMELQ\",\"page\":1,\"spuid\":\"MHSMCGMELQ\",\"tabindex\":2,\"type\":\"Label\",\"value\":\"Archivio di ricerca:\",\"w\":88,\"x\":183,\"y\":18,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"archivio\",\"page\":1,\"spuid\":\"WBNIEXDKHU\",\"tabindex\":3,\"textlist\":\"Operazioni Ordinarie,Informazioni sui rapporti,Frazionate,Legami tra Soggetti,Storico Rapporti,Storico Operazioni\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"O"+"'"+","+"'"+"I"+"'"+","+"'"+"F"+"'"+","+"'"+"T"+"'"+","+"'"+"S"+"'"+","+"'"+"X"+"'"+"\",\"w\":232,\"x\":272,\"y\":14,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QZKKQLMHBR\",\"page\":1,\"spuid\":\"QZKKQLMHBR\",\"tabindex\":5,\"type\":\"Label\",\"value\":\"Attributi Selezionati:\",\"w\":97,\"x\":189,\"y\":151,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"attsel\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"FZSXKHMBWI\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":288,\"y\":147,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_ZROWGDZUEC\",\"page\":1,\"spuid\":\"ZROWGDZUEC\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"Richieste:\",\"w\":47,\"x\":368,\"y\":151,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"richieste\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"BYZREJKUOL\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":416,\"y\":147,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Stamp il risultato delle selezioni\",\"h\":63,\"keep_proportions\":\"bounded\",\"name\":\"image_GHJKYVCUZI\",\"page\":1,\"spuid\":\"GHJKYVCUZI\",\"src\":\"..\\/images\\/print.gif\",\"tabindex\":4,\"type\":\"Image\",\"w\":100,\"x\":326,\"y\":329,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_KVGFUZUMZV\",\"h\":425,\"name\":\"box_KVGFUZUMZV\",\"page\":2,\"shrinkable\":true,\"spuid\":\"KVGFUZUMZV\",\"tabindex\":1,\"type\":\"Box\",\"w\":752,\"x\":0,\"y\":0,\"zone\":\"pag2_1\",\"zonepath\":\"[2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QFEJRPWHYK\",\"page\":2,\"spuid\":\"QFEJRPWHYK\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"A01a. Tipo Intermediario:\",\"w\":123,\"x\":58,\"y\":11,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo intermediario\",\"h\":20,\"maxlength\":2,\"name\":\"A01A\",\"page\":2,\"spuid\":\"TESHVPIZQD\",\"tabindex\":4,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":272,\"x\":184,\"y\":7,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VNVWZFEUHE\",\"page\":2,\"spuid\":\"VNVWZFEUHE\",\"tabindex\":5,\"type\":\"Label\",\"value\":\"A01b.Codice Intermediario:\",\"w\":132,\"x\":49,\"y\":32,\"zone\":\"pag2_1_2\",\"zonepath\":\"[2,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":11,\"name\":\"A01B\",\"page\":2,\"picker\":true,\"spuid\":\"TIPXBDXITE\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":78,\"x\":184,\"y\":28,\"zone\":\"pag2_1_2\",\"zonepath\":\"[2,1,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_CHADKUQQIO\",\"page\":2,\"spuid\":\"CHADKUQQIO\",\"tabindex\":8,\"type\":\"Label\",\"w\":440,\"x\":287,\"y\":32,\"zone\":\"pag2_1_2\",\"zonepath\":\"[2,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LDOCLAAARK\",\"page\":2,\"spuid\":\"LDOCLAAARK\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"A03.Identificativo Registrazione:\",\"w\":164,\"x\":17,\"y\":53,\"zone\":\"pag2_1_3\",\"zonepath\":\"[2,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":20,\"name\":\"A03\",\"page\":2,\"spuid\":\"MXWTPQUTBB\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":132,\"x\":184,\"y\":49,\"zone\":\"pag2_1_3\",\"zonepath\":\"[2,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IRZBSCAUFG\",\"page\":2,\"spuid\":\"IRZBSCAUFG\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"A11.Codice Dipendenza:\",\"w\":118,\"x\":63,\"y\":81,\"zone\":\"pag2_1_4\",\"zonepath\":\"[2,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":6,\"name\":\"A11\",\"page\":2,\"picker\":true,\"spuid\":\"BQNMQAOIPA\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":54,\"x\":184,\"y\":77,\"zone\":\"pag2_1_4\",\"zonepath\":\"[2,1,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_EAYOQYEKSN\",\"page\":2,\"spuid\":\"EAYOQYEKSN\",\"tabindex\":14,\"type\":\"Label\",\"w\":240,\"x\":264,\"y\":81,\"zone\":\"pag2_1_4\",\"zonepath\":\"[2,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VYDUOMMXQS\",\"page\":2,\"spuid\":\"VYDUOMMXQS\",\"tabindex\":15,\"type\":\"Label\",\"value\":\"A12a. CAB Comune Dipendenza:\",\"w\":157,\"x\":512,\"y\":81,\"zone\":\"pag2_1_4\",\"zonepath\":\"[2,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":6,\"name\":\"A12A\",\"page\":2,\"picker\":true,\"spuid\":\"XHIBDWLIOD\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":672,\"y\":77,\"zone\":\"pag2_1_4\",\"zonepath\":\"[2,1,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FQDUTIBRWF\",\"page\":2,\"spuid\":\"FQDUTIBRWF\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"A12b. Comune Dipendenza:\",\"w\":153,\"x\":28,\"y\":102,\"zone\":\"pag2_1_5\",\"zonepath\":\"[2,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":30,\"name\":\"A12B\",\"page\":2,\"picker\":true,\"spuid\":\"IFYLHOXPRS\",\"tabindex\":18,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":248,\"x\":184,\"y\":98,\"zone\":\"pag2_1_5\",\"zonepath\":\"[2,1,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QMDPACOUBB\",\"page\":2,\"spuid\":\"QMDPACOUBB\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"A12c. Sigla Provincia Dipendenza:\",\"w\":162,\"x\":507,\"y\":102,\"zone\":\"pag2_1_5\",\"zonepath\":\"[2,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":2,\"name\":\"A12C\",\"page\":2,\"spuid\":\"WZNDKFWJMU\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":672,\"y\":98,\"zone\":\"pag2_1_5\",\"zonepath\":\"[2,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_FESIXUVFYS\",\"page\":2,\"spuid\":\"FESIXUVFYS\",\"tabindex\":21,\"type\":\"Label\",\"value\":\"A21. Data Operazione:\",\"w\":111,\"x\":70,\"y\":130,\"zone\":\"pag2_1_6\",\"zonepath\":\"[2,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":10,\"name\":\"A21\",\"page\":2,\"spuid\":\"OOVOWNWMZK\",\"tabindex\":22,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":184,\"y\":126,\"zone\":\"pag2_1_6\",\"zonepath\":\"[2,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VMHYCUTRMT\",\"page\":2,\"spuid\":\"VMHYCUTRMT\",\"tabindex\":23,\"type\":\"Label\",\"value\":\"A22. Flag Frazionata:\",\"w\":104,\"x\":565,\"y\":130,\"zone\":\"pag2_1_7\",\"zonepath\":\"[2,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"empty_value\":\"false\",\"h\":20,\"maxlength\":2,\"name\":\"A22\",\"page\":2,\"spuid\":\"TPGCMCINSD\",\"tabindex\":24,\"textlist\":\",Si,No,N + F\",\"type\":\"Combobox\",\"typevar\":\"numeric\",\"valuelist\":\"0,2,3,1\",\"w\":72,\"x\":672,\"y\":126,\"zone\":\"pag2_1_7\",\"zonepath\":\"[2,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PNKIIXBJDA\",\"page\":2,\"spuid\":\"PNKIIXBJDA\",\"tabindex\":25,\"type\":\"Label\",\"value\":\"A23. Flag Contanti:\",\"w\":104,\"x\":77,\"y\":151,\"zone\":\"pag2_1_8\",\"zonepath\":\"[2,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"A23\",\"page\":2,\"spuid\":\"NPNITFAIKW\",\"tabindex\":26,\"textlist\":\"No,Si\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"0"+"'"+","+"'"+"1"+"'"+"\",\"w\":80,\"x\":184,\"y\":147,\"zone\":\"pag2_1_8\",\"zonepath\":\"[2,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HSRFLEDTES\",\"page\":2,\"spuid\":\"HSRFLEDTES\",\"tabindex\":27,\"type\":\"Label\",\"value\":\"A24. Causale Analitica:\",\"w\":111,\"x\":558,\"y\":151,\"zone\":\"pag2_1_9\",\"zonepath\":\"[2,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":4,\"name\":\"A24\",\"page\":2,\"picker\":true,\"spuid\":\"CKACALWZOL\",\"tabindex\":28,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":54,\"x\":672,\"y\":147,\"zone\":\"pag2_1_9\",\"zonepath\":\"[2,1,9]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BXEMZOFNPA\",\"page\":2,\"spuid\":\"BXEMZOFNPA\",\"tabindex\":29,\"type\":\"Label\",\"value\":\"A25. Codice Voce:\",\"w\":88,\"x\":93,\"y\":172,\"zone\":\"pag2_1_10\",\"zonepath\":\"[2,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":2,\"name\":\"A25\",\"page\":2,\"picker\":true,\"spuid\":\"ZIMEUPPLZY\",\"tabindex\":30,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":184,\"y\":168,\"zone\":\"pag2_1_10\",\"zonepath\":\"[2,1,10]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XIRGQJSHDT\",\"page\":2,\"spuid\":\"XIRGQJSHDT\",\"tabindex\":31,\"type\":\"Label\",\"value\":\"A31a. Tipo Intermediario C\\/Parte:\",\"w\":163,\"x\":306,\"y\":172,\"zone\":\"pag2_1_10\",\"zonepath\":\"[2,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":2,\"name\":\"A31A\",\"page\":2,\"spuid\":\"EHNAPBXMAR\",\"tabindex\":32,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":272,\"x\":472,\"y\":168,\"zone\":\"pag2_1_10\",\"zonepath\":\"[2,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YGQKXHEHWV\",\"page\":2,\"spuid\":\"YGQKXHEHWV\",\"tabindex\":33,\"type\":\"Label\",\"value\":\"A31b.Cod. Intermediario C\\/Parte:\",\"w\":172,\"x\":9,\"y\":200,\"zone\":\"pag2_1_11\",\"zonepath\":\"[2,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":10,\"name\":\"A31B\",\"page\":2,\"picker\":true,\"spuid\":\"ZZQPEDWGCO\",\"tabindex\":34,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":184,\"y\":196,\"zone\":\"pag2_1_11\",\"zonepath\":\"[2,1,11]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EKNQTHCUHI\",\"page\":2,\"spuid\":\"EKNQTHCUHI\",\"tabindex\":35,\"type\":\"Label\",\"value\":\"A32. Paese Intermediario C\\/Parte:\",\"w\":166,\"x\":503,\"y\":200,\"zone\":\"pag2_1_12\",\"zonepath\":\"[2,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":3,\"name\":\"A32\",\"page\":2,\"picker\":true,\"spuid\":\"LTUCQORMSA\",\"tabindex\":36,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":54,\"x\":672,\"y\":196,\"zone\":\"pag2_1_12\",\"zonepath\":\"[2,1,12]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CATDSTXWKN\",\"page\":2,\"spuid\":\"CATDSTXWKN\",\"tabindex\":37,\"type\":\"Label\",\"value\":\"A33a. CAB Comune Inter. C\\/Parte:\",\"w\":169,\"x\":12,\"y\":221,\"zone\":\"pag2_1_13\",\"zonepath\":\"[2,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":6,\"name\":\"A33A\",\"page\":2,\"picker\":true,\"spuid\":\"VDWEKDDBOW\",\"tabindex\":38,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":184,\"y\":217,\"zone\":\"pag2_1_13\",\"zonepath\":\"[2,1,13]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SQXLNELNGN\",\"page\":2,\"spuid\":\"SQXLNELNGN\",\"tabindex\":39,\"type\":\"Label\",\"value\":\"A33b. Comune Inter. C\\/Parte:\",\"w\":153,\"x\":260,\"y\":221,\"zone\":\"pag2_1_13\",\"zonepath\":\"[2,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":30,\"name\":\"A33B\",\"page\":2,\"picker\":true,\"spuid\":\"BICDANUWZD\",\"tabindex\":40,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":248,\"x\":416,\"y\":217,\"zone\":\"pag2_1_13\",\"zonepath\":\"[2,1,13]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IRSQCXIFGH\",\"page\":2,\"spuid\":\"IRSQCXIFGH\",\"tabindex\":42,\"type\":\"Label\",\"value\":\"A33c. Provincia Inter. C\\/Parte:\",\"w\":162,\"x\":19,\"y\":242,\"zone\":\"pag2_1_14\",\"zonepath\":\"[2,1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":2,\"name\":\"A33C\",\"page\":2,\"spuid\":\"OCRIGUNQVR\",\"tabindex\":43,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":184,\"y\":238,\"zone\":\"pag2_1_14\",\"zonepath\":\"[2,1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EENJYSYKCW\",\"page\":2,\"spuid\":\"EENJYSYKCW\",\"tabindex\":44,\"type\":\"Label\",\"value\":\"A34. Denominazione Inter. C\\/Parte:\",\"w\":173,\"x\":240,\"y\":242,\"zone\":\"pag2_1_14\",\"zonepath\":\"[2,1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":50,\"name\":\"A34\",\"page\":2,\"spuid\":\"PGJPWEXBVK\",\"tabindex\":45,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":328,\"x\":416,\"y\":238,\"zone\":\"pag2_1_14\",\"zonepath\":\"[2,1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ITOWAQHNXI\",\"page\":2,\"spuid\":\"ITOWAQHNXI\",\"tabindex\":46,\"type\":\"Label\",\"value\":\"A41. Rapporto Continuativo:\",\"w\":139,\"x\":42,\"y\":270,\"zone\":\"pag2_1_15\",\"zonepath\":\"[2,1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":25,\"name\":\"A41\",\"page\":2,\"picker\":true,\"spuid\":\"HDIAJDVNVI\",\"tabindex\":47,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":162,\"x\":184,\"y\":266,\"zone\":\"pag2_1_15\",\"zonepath\":\"[2,1,15]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":1,\"name\":\"A42\",\"page\":2,\"picker\":true,\"spuid\":\"RQJLOLNIHM\",\"tabindex\":48,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":664,\"y\":266,\"zone\":\"pag2_1_16\",\"zonepath\":\"[2,1,16]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ARPEUWGQUZ\",\"page\":2,\"spuid\":\"ARPEUWGQUZ\",\"tabindex\":49,\"type\":\"Label\",\"value\":\"A42. Flag Rapporto:\",\"w\":139,\"x\":523,\"y\":270,\"zone\":\"pag2_1_16\",\"zonepath\":\"[2,1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SHTEYUGPPB\",\"page\":2,\"spuid\":\"SHTEYUGPPB\",\"tabindex\":50,\"type\":\"Label\",\"value\":\"A43. Tipo Legame Sogg. Operante:\",\"w\":170,\"x\":11,\"y\":298,\"zone\":\"pag2_1_17\",\"zonepath\":\"[2,1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":1,\"name\":\"A43\",\"page\":2,\"picker\":true,\"spuid\":\"CHJJABTJCS\",\"tabindex\":51,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":38,\"x\":184,\"y\":294,\"zone\":\"pag2_1_17\",\"zonepath\":\"[2,1,17]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_KGCQSTGBFX\",\"page\":2,\"spuid\":\"KGCQSTGBFX\",\"tabindex\":54,\"type\":\"Label\",\"w\":232,\"x\":248,\"y\":298,\"zone\":\"pag2_1_17\",\"zonepath\":\"[2,1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CPEXVRTGQH\",\"page\":2,\"spuid\":\"CPEXVRTGQH\",\"tabindex\":55,\"type\":\"Label\",\"value\":\"A51. Data registrazione:\",\"w\":118,\"x\":544,\"y\":298,\"zone\":\"pag2_1_17\",\"zonepath\":\"[2,1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":10,\"name\":\"A51\",\"page\":2,\"spuid\":\"KFDSCJBSLJ\",\"tabindex\":56,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":664,\"y\":294,\"zone\":\"pag2_1_17\",\"zonepath\":\"[2,1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DYHSKTUMPC\",\"page\":2,\"spuid\":\"DYHSKTUMPC\",\"tabindex\":57,\"type\":\"Label\",\"value\":\"A52. Tipo Registrazione:\",\"w\":186,\"x\":-8,\"y\":326,\"zone\":\"pag2_1_18\",\"zonepath\":\"[2,1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":2,\"name\":\"A52B\",\"page\":2,\"spuid\":\"DFFBWGMKTL\",\"tabindex\":58,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":560,\"x\":184,\"y\":322,\"zone\":\"pag2_1_18\",\"zonepath\":\"[2,1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":12,\"name\":\"A53\",\"page\":2,\"spuid\":\"JPOXBHVIYE\",\"tabindex\":59,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":84,\"x\":184,\"y\":350,\"zone\":\"pag2_1_19\",\"zonepath\":\"[2,1,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MBUECIPZTY\",\"page\":2,\"spuid\":\"MBUECIPZTY\",\"tabindex\":72,\"type\":\"Label\",\"value\":\"A53. Connessione operazioni:\",\"w\":149,\"x\":32,\"y\":354,\"zone\":\"pag2_1_19\",\"zonepath\":\"[2,1,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SQHEEDSHGD\",\"page\":2,\"spuid\":\"SQHEEDSHGD\",\"tabindex\":60,\"type\":\"Label\",\"value\":\"A54a. Codice Stato Registrazione:\",\"w\":165,\"x\":16,\"y\":382,\"zone\":\"pag2_1_20\",\"zonepath\":\"[2,1,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"A54A\",\"page\":2,\"spuid\":\"VJIDPHKDWI\",\"tabindex\":61,\"textlist\":\"Operazione attiva,Operazione Modificata,Operazione Cancellata,Copia Operazione Modificata\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"0"+"'"+","+"'"+"1"+"'"+","+"'"+"2"+"'"+","+"'"+"3"+"'"+"\",\"w\":176,\"x\":184,\"y\":378,\"zone\":\"pag2_1_20\",\"zonepath\":\"[2,1,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ASELJDEKCP\",\"page\":2,\"spuid\":\"ASELJDEKCP\",\"tabindex\":62,\"type\":\"Label\",\"value\":\"A54b. Data della rettifica:\",\"w\":124,\"x\":538,\"y\":382,\"zone\":\"pag2_1_21\",\"zonepath\":\"[2,1,21]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":10,\"name\":\"A54B\",\"page\":2,\"spuid\":\"XYVBVXLTXA\",\"tabindex\":63,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":664,\"y\":378,\"zone\":\"pag2_1_21\",\"zonepath\":\"[2,1,21]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":20,\"name\":\"A54C\",\"page\":2,\"spuid\":\"MSZJBMMVGZ\",\"tabindex\":64,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":132,\"x\":184,\"y\":399,\"zone\":\"pag2_1_22\",\"zonepath\":\"[2,1,22]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MMOVRNNECE\",\"page\":2,\"spuid\":\"MMOVRNNECE\",\"tabindex\":65,\"type\":\"Label\",\"value\":\"A54c. Id. Operazione Modificata:\",\"w\":165,\"x\":16,\"y\":403,\"zone\":\"pag2_1_22\",\"zonepath\":\"[2,1,22]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_ZRLFCCXZUM\",\"h\":35,\"name\":\"box_ZRLFCCXZUM\",\"page\":2,\"shrinkable\":true,\"spuid\":\"ZRLFCCXZUM\",\"tabindex\":2,\"type\":\"Box\",\"w\":752,\"x\":0,\"y\":427,\"zone\":\"pag2_2\",\"zonepath\":\"[2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CWOTTEUVHI\",\"page\":2,\"spuid\":\"CWOTTEUVHI\",\"tabindex\":66,\"type\":\"Label\",\"value\":\"Attributi Selezionati:\",\"w\":97,\"x\":5,\"y\":438,\"zone\":\"pag2_2_1\",\"zonepath\":\"[2,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"attsel\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"TMUPYJLPKP\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":104,\"y\":434,\"zone\":\"pag2_2_1\",\"zonepath\":\"[2,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_CHHIMCXSDZ\",\"page\":2,\"spuid\":\"CHHIMCXSDZ\",\"tabindex\":68,\"type\":\"Label\",\"value\":\"Richieste:\",\"w\":47,\"x\":184,\"y\":438,\"zone\":\"pag2_2_1\",\"zonepath\":\"[2,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"richieste\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"THCRJKNXGZ\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":232,\"y\":434,\"zone\":\"pag2_2_1\",\"zonepath\":\"[2,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_YOZVQCHKHW\",\"h\":399,\"name\":\"box_YOZVQCHKHW\",\"page\":3,\"shrinkable\":true,\"spuid\":\"YOZVQCHKHW\",\"tabindex\":1,\"type\":\"Box\",\"w\":752,\"x\":0,\"y\":0,\"zone\":\"pag3_1\",\"zonepath\":\"[3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"B11\",\"page\":3,\"spuid\":\"EPMUHBJYIP\",\"tabindex\":2,\"textlist\":\"Lira,Euro,Valuta Estera\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"L"+"'"+","+"'"+"E"+"'"+","+"'"+"V"+"'"+"\",\"w\":200,\"x\":184,\"y\":7,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TIWFTFIKJB\",\"page\":3,\"spuid\":\"TIWFTFIKJB\",\"tabindex\":12,\"type\":\"Label\",\"value\":\"B11 Lire\\/Euro Valuta:\",\"w\":123,\"x\":58,\"y\":11,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Valuta\",\"h\":20,\"maxlength\":3,\"name\":\"B12\",\"page\":3,\"picker\":true,\"spuid\":\"CDFYKKBMYS\",\"tabindex\":3,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":38,\"x\":184,\"y\":35,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_ZGTLDBJSNA\",\"page\":3,\"spuid\":\"ZGTLDBJSNA\",\"tabindex\":14,\"type\":\"Label\",\"w\":440,\"x\":248,\"y\":39,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SIDHJTYMEM\",\"page\":3,\"spuid\":\"SIDHJTYMEM\",\"tabindex\":15,\"type\":\"Label\",\"value\":\"B12. Codice Divisa:\",\"w\":123,\"x\":58,\"y\":39,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"B13\",\"page\":3,\"spuid\":\"AREEANYKOU\",\"tabindex\":4,\"textlist\":\"Avere,Dare\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"A"+"'"+","+"'"+"D"+"'"+"\",\"w\":80,\"x\":184,\"y\":63,\"zone\":\"pag3_1_3\",\"zonepath\":\"[3,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OXNUSNGVOZ\",\"page\":3,\"spuid\":\"OXNUSNGVOZ\",\"tabindex\":16,\"type\":\"Label\",\"value\":\"B13. Segno monetario:\",\"w\":110,\"x\":71,\"y\":67,\"zone\":\"pag3_1_3\",\"zonepath\":\"[3,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":28,\"name\":\"B14\",\"page\":3,\"spuid\":\"SOZNPELALO\",\"tabindex\":5,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":126,\"x\":184,\"y\":91,\"zone\":\"pag3_1_4\",\"zonepath\":\"[3,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PIIBXVVRPP\",\"page\":3,\"spuid\":\"PIIBXVVRPP\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"B14. Totale Lire \\/ Euro * 100:\",\"w\":141,\"x\":40,\"y\":95,\"zone\":\"pag3_1_4\",\"zonepath\":\"[3,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HANAAGYCXB\",\"page\":3,\"spuid\":\"HANAAGYCXB\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"Operatore di confronto:\",\"w\":115,\"x\":320,\"y\":95,\"zone\":\"pag3_1_4\",\"zonepath\":\"[3,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":19,\"maxlength\":2,\"name\":\"X_B14_OP\",\"orientation\":\"horizontal\",\"page\":3,\"spuid\":\"CFQDRXVJLE\",\"tabindex\":20,\"type\":\"Radio\",\"typevar\":\"character\",\"w\":216,\"x\":440,\"y\":92,\"zone\":\"pag3_1_4\",\"zonepath\":\"[3,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":28,\"name\":\"B15\",\"page\":3,\"spuid\":\"DNCCUIFECE\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":126,\"x\":184,\"y\":119,\"zone\":\"pag3_1_5\",\"zonepath\":\"[3,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ILSARIWRNJ\",\"page\":3,\"spuid\":\"ILSARIWRNJ\",\"tabindex\":18,\"type\":\"Label\",\"value\":\"B15. Contanti Lire \\/ Euro * 100:\",\"w\":173,\"x\":8,\"y\":123,\"zone\":\"pag3_1_5\",\"zonepath\":\"[3,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YCHGPBZPNV\",\"page\":3,\"spuid\":\"YCHGPBZPNV\",\"tabindex\":21,\"type\":\"Label\",\"value\":\"Operatore di confronto:\",\"w\":115,\"x\":320,\"y\":122,\"zone\":\"pag3_1_5\",\"zonepath\":\"[3,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":19,\"maxlength\":2,\"name\":\"X_B15_OP\",\"orientation\":\"horizontal\",\"page\":3,\"spuid\":\"JNSSKKSFRO\",\"tabindex\":22,\"type\":\"Radio\",\"typevar\":\"character\",\"w\":240,\"x\":440,\"y\":119,\"zone\":\"pag3_1_5\",\"zonepath\":\"[3,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_CSGINFLFWZ\",\"h\":35,\"name\":\"box_CSGINFLFWZ\",\"page\":3,\"shrinkable\":true,\"spuid\":\"CSGINFLFWZ\",\"tabindex\":7,\"type\":\"Box\",\"w\":752,\"x\":0,\"y\":401,\"zone\":\"pag3_2\",\"zonepath\":\"[3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VLQMGDWCRQ\",\"page\":3,\"spuid\":\"VLQMGDWCRQ\",\"tabindex\":8,\"type\":\"Label\",\"value\":\"Attributi Selezionati:\",\"w\":97,\"x\":5,\"y\":412,\"zone\":\"pag3_2_1\",\"zonepath\":\"[3,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"attsel\",\"page\":3,\"readonly\":\"true\",\"spuid\":\"JIDZAAHINH\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":104,\"y\":408,\"zone\":\"pag3_2_1\",\"zonepath\":\"[3,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_QOKCZHSIMS\",\"page\":3,\"spuid\":\"QOKCZHSIMS\",\"tabindex\":10,\"type\":\"Label\",\"value\":\"Richieste:\",\"w\":47,\"x\":184,\"y\":412,\"zone\":\"pag3_2_1\",\"zonepath\":\"[3,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"richieste\",\"page\":3,\"readonly\":\"true\",\"spuid\":\"DAPKMAFMRM\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":232,\"y\":408,\"zone\":\"pag3_2_1\",\"zonepath\":\"[3,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_KRHDYFEJWS\",\"h\":399,\"name\":\"box_KRHDYFEJWS\",\"page\":4,\"shrinkable\":true,\"spuid\":\"KRHDYFEJWS\",\"tabindex\":1,\"type\":\"Box\",\"w\":752,\"x\":0,\"y\":0,\"zone\":\"pag4_1\",\"zonepath\":\"[4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RNLMFMRNOH\",\"page\":4,\"spuid\":\"RNLMFMRNOH\",\"tabindex\":7,\"type\":\"Label\",\"w\":181,\"x\":0,\"y\":11,\"zone\":\"pag4_1_1\",\"zonepath\":\"[4,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo intermediario\",\"h\":20,\"maxlength\":16,\"name\":\"C11\",\"page\":4,\"picker\":true,\"spuid\":\"BZRDFHBMPM\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":118,\"x\":184,\"y\":7,\"zone\":\"pag4_1_1\",\"zonepath\":\"[4,1,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_ETLYWIFSII\",\"page\":4,\"spuid\":\"ETLYWIFSII\",\"tabindex\":10,\"type\":\"Label\",\"w\":416,\"x\":328,\"y\":11,\"zone\":\"pag4_1_1\",\"zonepath\":\"[4,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IDHSNDCTMV\",\"page\":4,\"spuid\":\"IDHSNDCTMV\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"C21. Sogg. Oper. Conto Terzi:\",\"w\":161,\"x\":20,\"y\":39,\"zone\":\"pag4_1_2\",\"zonepath\":\"[4,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":16,\"name\":\"C21\",\"page\":4,\"picker\":true,\"spuid\":\"UYRQHSBRRT\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":118,\"x\":184,\"y\":35,\"zone\":\"pag4_1_2\",\"zonepath\":\"[4,1,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_LVWOATBCKV\",\"page\":4,\"spuid\":\"LVWOATBCKV\",\"tabindex\":13,\"type\":\"Label\",\"w\":416,\"x\":328,\"y\":39,\"zone\":\"pag4_1_2\",\"zonepath\":\"[4,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VZSHOQLWNK\",\"page\":4,\"spuid\":\"VZSHOQLWNK\",\"tabindex\":14,\"type\":\"Label\",\"value\":\"C31. Codice Beneficiario:\",\"w\":158,\"x\":23,\"y\":67,\"zone\":\"pag4_1_3\",\"zonepath\":\"[4,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo intermediario\",\"h\":20,\"maxlength\":16,\"name\":\"C31\",\"page\":4,\"picker\":true,\"spuid\":\"PMFBITPOAZ\",\"tabindex\":15,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":118,\"x\":184,\"y\":63,\"zone\":\"pag4_1_3\",\"zonepath\":\"[4,1,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_CGEIVVOXXA\",\"page\":4,\"spuid\":\"CGEIVVOXXA\",\"tabindex\":16,\"type\":\"Label\",\"w\":416,\"x\":328,\"y\":67,\"zone\":\"pag4_1_3\",\"zonepath\":\"[4,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TNXYMTDNHM\",\"page\":4,\"spuid\":\"TNXYMTDNHM\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"C41. Sogg. Secondario Legame:\",\"w\":169,\"x\":12,\"y\":95,\"zone\":\"pag4_1_4\",\"zonepath\":\"[4,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo intermediario\",\"h\":20,\"maxlength\":16,\"name\":\"C41\",\"page\":4,\"picker\":true,\"spuid\":\"LZSKLOQPNQ\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":118,\"x\":184,\"y\":91,\"zone\":\"pag4_1_4\",\"zonepath\":\"[4,1,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_RNOHNHPWKP\",\"page\":4,\"spuid\":\"RNOHNHPWKP\",\"tabindex\":21,\"type\":\"Label\",\"w\":416,\"x\":328,\"y\":95,\"zone\":\"pag4_1_4\",\"zonepath\":\"[4,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UHBKFQBEEX\",\"page\":4,\"spuid\":\"UHBKFQBEEX\",\"tabindex\":23,\"type\":\"Label\",\"value\":\"C51. Soggetto per conto del quale:\",\"w\":185,\"x\":-4,\"y\":123,\"zone\":\"pag4_1_5\",\"zonepath\":\"[4,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo intermediario\",\"h\":20,\"maxlength\":16,\"name\":\"C51\",\"page\":4,\"picker\":true,\"spuid\":\"RHMPOMWSNG\",\"tabindex\":24,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":118,\"x\":184,\"y\":119,\"zone\":\"pag4_1_5\",\"zonepath\":\"[4,1,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_MOREOSGKEO\",\"page\":4,\"spuid\":\"MOREOSGKEO\",\"tabindex\":25,\"type\":\"Label\",\"w\":416,\"x\":328,\"y\":123,\"zone\":\"pag4_1_5\",\"zonepath\":\"[4,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_IAWYMLKEQC\",\"h\":35,\"name\":\"box_IAWYMLKEQC\",\"page\":4,\"shrinkable\":true,\"spuid\":\"IAWYMLKEQC\",\"tabindex\":2,\"type\":\"Box\",\"w\":752,\"x\":0,\"y\":401,\"zone\":\"pag4_2\",\"zonepath\":\"[4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TNVUEPXDLS\",\"page\":4,\"spuid\":\"TNVUEPXDLS\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Attributi Selezionati:\",\"w\":97,\"x\":5,\"y\":412,\"zone\":\"pag4_2_1\",\"zonepath\":\"[4,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"attsel\",\"page\":4,\"readonly\":\"true\",\"spuid\":\"HZTWRPMZIJ\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":104,\"y\":408,\"zone\":\"pag4_2_1\",\"zonepath\":\"[4,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_AMZCYHAYVW\",\"page\":4,\"spuid\":\"AMZCYHAYVW\",\"tabindex\":5,\"type\":\"Label\",\"value\":\"Richieste:\",\"w\":47,\"x\":184,\"y\":412,\"zone\":\"pag4_2_1\",\"zonepath\":\"[4,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"richieste\",\"page\":4,\"readonly\":\"true\",\"spuid\":\"JEKIPUJSNX\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":232,\"y\":408,\"zone\":\"pag4_2_1\",\"zonepath\":\"[4,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_EVPFVSEQYP\",\"h\":399,\"name\":\"box_EVPFVSEQYP\",\"page\":5,\"shrinkable\":true,\"spuid\":\"EVPFVSEQYP\",\"tabindex\":1,\"type\":\"Box\",\"w\":752,\"x\":0,\"y\":0,\"zone\":\"pag5_1\",\"zonepath\":\"[5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UPATPCHUKQ\",\"page\":5,\"spuid\":\"UPATPCHUKQ\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"D11. Cliente Intestatario:\",\"w\":158,\"x\":23,\"y\":11,\"zone\":\"pag5_1_1\",\"zonepath\":\"[5,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo intermediario\",\"h\":20,\"maxlength\":70,\"name\":\"D11\",\"page\":5,\"picker\":true,\"spuid\":\"OQJHGGFCNJ\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":432,\"x\":184,\"y\":7,\"zone\":\"pag5_1_1\",\"zonepath\":\"[5,1,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KITFEGEWOH\",\"page\":5,\"spuid\":\"KITFEGEWOH\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"D13. Codice Paese Cliente:\",\"w\":166,\"x\":15,\"y\":39,\"zone\":\"pag5_1_2\",\"zonepath\":\"[5,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":3,\"name\":\"D13\",\"page\":5,\"picker\":true,\"spuid\":\"GMCYYELLWW\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":62,\"x\":184,\"y\":35,\"zone\":\"pag5_1_2\",\"zonepath\":\"[5,1,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PJLUBXHKKN\",\"page\":5,\"spuid\":\"PJLUBXHKKN\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"D14a. CAB Comune Reside. Cliente:\",\"w\":173,\"x\":8,\"y\":60,\"zone\":\"pag5_1_3\",\"zonepath\":\"[5,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":6,\"name\":\"D14A\",\"page\":5,\"picker\":true,\"spuid\":\"VZGLYXBMQI\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":62,\"x\":184,\"y\":56,\"zone\":\"pag5_1_3\",\"zonepath\":\"[5,1,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BBWAKOQIYQ\",\"page\":5,\"spuid\":\"BBWAKOQIYQ\",\"tabindex\":13,\"type\":\"Label\",\"value\":\"D14b. Comune Residenza Cliente:\",\"w\":163,\"x\":18,\"y\":81,\"zone\":\"pag5_1_4\",\"zonepath\":\"[5,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":30,\"name\":\"D14B\",\"page\":5,\"picker\":true,\"spuid\":\"YRFNYFRQSY\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":184,\"y\":77,\"zone\":\"pag5_1_4\",\"zonepath\":\"[5,1,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TGASSPVQNV\",\"page\":5,\"spuid\":\"TGASSPVQNV\",\"tabindex\":15,\"type\":\"Label\",\"value\":\"D14c. Provincia Residenza Cliente:\",\"w\":166,\"x\":455,\"y\":81,\"zone\":\"pag5_1_4\",\"zonepath\":\"[5,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":2,\"name\":\"D14C\",\"page\":5,\"spuid\":\"RLWWENBDDD\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":624,\"y\":77,\"zone\":\"pag5_1_4\",\"zonepath\":\"[5,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ECJOMBFBWF\",\"page\":5,\"spuid\":\"ECJOMBFBWF\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"D15. Indirizzo Residenza Cliente:\",\"w\":163,\"x\":18,\"y\":102,\"zone\":\"pag5_1_5\",\"zonepath\":\"[5,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":35,\"name\":\"D15\",\"page\":5,\"spuid\":\"YCLKMEZUZX\",\"tabindex\":18,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":240,\"x\":184,\"y\":98,\"zone\":\"pag5_1_5\",\"zonepath\":\"[5,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CIQLFTONTH\",\"page\":5,\"spuid\":\"CIQLFTONTH\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"D16. C.A.P. Cliente:\",\"w\":166,\"x\":455,\"y\":102,\"zone\":\"pag5_1_5\",\"zonepath\":\"[5,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":5,\"name\":\"D16\",\"page\":5,\"spuid\":\"ZIKKMNZCHI\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":624,\"y\":98,\"zone\":\"pag5_1_5\",\"zonepath\":\"[5,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PBQVXZCDEF\",\"page\":5,\"spuid\":\"PBQVXZCDEF\",\"tabindex\":21,\"type\":\"Label\",\"value\":\"D17. Codice Fiscale Cliente:\",\"w\":163,\"x\":18,\"y\":123,\"zone\":\"pag5_1_6\",\"zonepath\":\"[5,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":16,\"name\":\"D17\",\"page\":5,\"spuid\":\"UEISEWDTOW\",\"tabindex\":22,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":114,\"x\":184,\"y\":119,\"zone\":\"pag5_1_6\",\"zonepath\":\"[5,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NQAOSFTGWF\",\"page\":5,\"spuid\":\"NQAOSFTGWF\",\"tabindex\":23,\"type\":\"Label\",\"value\":\"D18. Data Nascita Cliente:\",\"w\":127,\"x\":54,\"y\":151,\"zone\":\"pag5_1_7\",\"zonepath\":\"[5,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":10,\"name\":\"D18\",\"page\":5,\"spuid\":\"AZIQXZISZO\",\"tabindex\":24,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":184,\"y\":147,\"zone\":\"pag5_1_7\",\"zonepath\":\"[5,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SMUYYNVEQP\",\"page\":5,\"spuid\":\"SMUYYNVEQP\",\"tabindex\":25,\"type\":\"Label\",\"value\":\"D19. Comune Nascita Cliente:\",\"w\":163,\"x\":370,\"y\":151,\"zone\":\"pag5_1_7\",\"zonepath\":\"[5,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":30,\"name\":\"D19A\",\"page\":5,\"picker\":true,\"spuid\":\"ZGFXMEVTVH\",\"tabindex\":26,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":536,\"y\":147,\"zone\":\"pag5_1_7\",\"zonepath\":\"[5,1,7]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":30,\"name\":\"D19B\",\"page\":5,\"picker\":true,\"spuid\":\"RVQNZAINRJ\",\"tabindex\":27,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":536,\"y\":168,\"zone\":\"pag5_1_8\",\"zonepath\":\"[5,1,8]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LDRVQOMLUC\",\"page\":5,\"spuid\":\"LDRVQOMLUC\",\"tabindex\":50,\"type\":\"Label\",\"value\":\"D19. Stato Nascita Cliente:\",\"w\":163,\"x\":370,\"y\":172,\"zone\":\"pag5_1_8\",\"zonepath\":\"[5,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HKSQSRUJMZ\",\"page\":5,\"spuid\":\"HKSQSRUJMZ\",\"tabindex\":28,\"type\":\"Label\",\"value\":\"D21. Sottog. Att. Econ. Cliente:\",\"w\":168,\"x\":13,\"y\":193,\"zone\":\"pag5_1_9\",\"zonepath\":\"[5,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":3,\"name\":\"D21\",\"page\":5,\"picker\":true,\"spuid\":\"DXFRERNUEZ\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":38,\"x\":184,\"y\":189,\"zone\":\"pag5_1_9\",\"zonepath\":\"[5,1,9]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_JKQBFYSMDS\",\"page\":5,\"spuid\":\"JKQBFYSMDS\",\"tabindex\":31,\"type\":\"Label\",\"w\":496,\"x\":248,\"y\":193,\"zone\":\"pag5_1_9\",\"zonepath\":\"[5,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RYAOPPQUAH\",\"page\":5,\"spuid\":\"RYAOPPQUAH\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"D22. Ramo\\/Grp.. Att. Econ. Cliente:\",\"w\":174,\"x\":7,\"y\":214,\"zone\":\"pag5_1_10\",\"zonepath\":\"[5,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":3,\"name\":\"D22\",\"page\":5,\"picker\":true,\"spuid\":\"QZTKKLVNJB\",\"tabindex\":33,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":38,\"x\":184,\"y\":210,\"zone\":\"pag5_1_10\",\"zonepath\":\"[5,1,10]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_OGXVSQJGJW\",\"page\":5,\"spuid\":\"OGXVSQJGJW\",\"tabindex\":35,\"type\":\"Label\",\"w\":496,\"x\":248,\"y\":214,\"zone\":\"pag5_1_10\",\"zonepath\":\"[5,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AVSQBPTKYQ\",\"page\":5,\"spuid\":\"AVSQBPTKYQ\",\"tabindex\":36,\"type\":\"Label\",\"value\":\"D23. Settorizzaz. Sintetica Cliente:\",\"w\":174,\"x\":7,\"y\":235,\"zone\":\"pag5_1_11\",\"zonepath\":\"[5,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":3,\"name\":\"D23\",\"page\":5,\"picker\":true,\"spuid\":\"RIPVAPFZCO\",\"tabindex\":37,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":38,\"x\":184,\"y\":231,\"zone\":\"pag5_1_11\",\"zonepath\":\"[5,1,11]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_XLGVTZHKKD\",\"page\":5,\"spuid\":\"XLGVTZHKKD\",\"tabindex\":39,\"type\":\"Label\",\"w\":496,\"x\":248,\"y\":235,\"zone\":\"pag5_1_11\",\"zonepath\":\"[5,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FGAKDZPMIG\",\"page\":5,\"spuid\":\"FGAKDZPMIG\",\"tabindex\":40,\"type\":\"Label\",\"value\":\"D41. Tipo Documento Cliente:\",\"w\":143,\"x\":38,\"y\":263,\"zone\":\"pag5_1_12\",\"zonepath\":\"[5,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":2,\"name\":\"D41\",\"page\":5,\"picker\":true,\"spuid\":\"QDVHTXVAEJ\",\"tabindex\":41,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":38,\"x\":184,\"y\":259,\"zone\":\"pag5_1_12\",\"zonepath\":\"[5,1,12]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_KDMNUBFBED\",\"page\":5,\"spuid\":\"KDMNUBFBED\",\"tabindex\":43,\"type\":\"Label\",\"w\":496,\"x\":248,\"y\":263,\"zone\":\"pag5_1_12\",\"zonepath\":\"[5,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DTMKARNGFH\",\"page\":5,\"spuid\":\"DTMKARNGFH\",\"tabindex\":44,\"type\":\"Label\",\"value\":\"D42. Numero Documento Cliente:\",\"w\":160,\"x\":21,\"y\":284,\"zone\":\"pag5_1_13\",\"zonepath\":\"[5,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":15,\"name\":\"D42\",\"page\":5,\"spuid\":\"ZZPDVGQXEP\",\"tabindex\":45,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":184,\"y\":280,\"zone\":\"pag5_1_13\",\"zonepath\":\"[5,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OMNEKUTPPQ\",\"page\":5,\"spuid\":\"OMNEKUTPPQ\",\"tabindex\":46,\"type\":\"Label\",\"value\":\"D43. Data Rilascio Documento Cliente:\",\"w\":184,\"x\":349,\"y\":284,\"zone\":\"pag5_1_13\",\"zonepath\":\"[5,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":10,\"name\":\"D43\",\"page\":5,\"spuid\":\"TCBOHGKRMJ\",\"tabindex\":47,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":536,\"y\":280,\"zone\":\"pag5_1_13\",\"zonepath\":\"[5,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VVONWAFQOT\",\"page\":5,\"spuid\":\"VVONWAFQOT\",\"tabindex\":48,\"type\":\"Label\",\"value\":\"D44. Autorit\\u00E0 e Luogo Rilascio:\",\"w\":160,\"x\":21,\"y\":305,\"zone\":\"pag5_1_14\",\"zonepath\":\"[5,1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":30,\"name\":\"D44\",\"page\":5,\"spuid\":\"YSHERQEZOZ\",\"tabindex\":49,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":184,\"y\":301,\"zone\":\"pag5_1_14\",\"zonepath\":\"[5,1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JKYZUXADHY\",\"page\":5,\"spuid\":\"JKYZUXADHY\",\"tabindex\":51,\"type\":\"Label\",\"value\":\"D45. Sesso:\",\"w\":160,\"x\":21,\"y\":333,\"zone\":\"pag5_1_15\",\"zonepath\":\"[5,1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"D45\",\"page\":5,\"spuid\":\"GEXJBDRMDF\",\"tabindex\":52,\"textlist\":\"Maschile,Femminile\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":176,\"x\":184,\"y\":329,\"zone\":\"pag5_1_15\",\"zonepath\":\"[5,1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_RWWUWNLOQE\",\"h\":35,\"name\":\"box_RWWUWNLOQE\",\"page\":5,\"shrinkable\":true,\"spuid\":\"RWWUWNLOQE\",\"tabindex\":2,\"type\":\"Box\",\"w\":752,\"x\":0,\"y\":401,\"zone\":\"pag5_2\",\"zonepath\":\"[5,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EXOKGLLODC\",\"page\":5,\"spuid\":\"EXOKGLLODC\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Attributi Selezionati:\",\"w\":97,\"x\":5,\"y\":412,\"zone\":\"pag5_2_1\",\"zonepath\":\"[5,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"attsel\",\"page\":5,\"readonly\":\"true\",\"spuid\":\"QIFUBGYUZF\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":104,\"y\":408,\"zone\":\"pag5_2_1\",\"zonepath\":\"[5,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_OKYOYCFRUX\",\"page\":5,\"spuid\":\"OKYOYCFRUX\",\"tabindex\":5,\"type\":\"Label\",\"value\":\"Richieste:\",\"w\":47,\"x\":184,\"y\":412,\"zone\":\"pag5_2_1\",\"zonepath\":\"[5,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"richieste\",\"page\":5,\"readonly\":\"true\",\"spuid\":\"CNGNVBWJSY\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":232,\"y\":408,\"zone\":\"pag5_2_1\",\"zonepath\":\"[5,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_HKEAENLPXY\",\"h\":399,\"name\":\"box_HKEAENLPXY\",\"page\":6,\"shrinkable\":true,\"spuid\":\"HKEAENLPXY\",\"tabindex\":1,\"type\":\"Box\",\"w\":752,\"x\":0,\"y\":0,\"zone\":\"pag6_1\",\"zonepath\":\"[6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LTIQECJTED\",\"page\":6,\"spuid\":\"LTIQECJTED\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"E11. Sogg. Operante Conto Terzi:\",\"w\":164,\"x\":17,\"y\":11,\"zone\":\"pag6_1_1\",\"zonepath\":\"[6,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo intermediario\",\"h\":20,\"maxlength\":70,\"name\":\"E11\",\"page\":6,\"picker\":true,\"spuid\":\"UMGRLGMHMY\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":432,\"x\":184,\"y\":7,\"zone\":\"pag6_1_1\",\"zonepath\":\"[6,1,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CXQOGATSRV\",\"page\":6,\"spuid\":\"CXQOGATSRV\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"E13. Codice Paese Sog. Oper.:\",\"w\":166,\"x\":15,\"y\":39,\"zone\":\"pag6_1_2\",\"zonepath\":\"[6,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":3,\"name\":\"E13\",\"page\":6,\"picker\":true,\"spuid\":\"GXOOZRXYFU\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":62,\"x\":184,\"y\":35,\"zone\":\"pag6_1_2\",\"zonepath\":\"[6,1,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RIXARQJQBE\",\"page\":6,\"spuid\":\"RIXARQJQBE\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"E14a. CAB Comune Res. Sog.Oper.:\",\"w\":176,\"x\":5,\"y\":60,\"zone\":\"pag6_1_3\",\"zonepath\":\"[6,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":6,\"name\":\"E14A\",\"page\":6,\"picker\":true,\"spuid\":\"IMIPLTLEAA\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":62,\"x\":184,\"y\":56,\"zone\":\"pag6_1_3\",\"zonepath\":\"[6,1,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LUIGJBMFUW\",\"page\":6,\"spuid\":\"LUIGJBMFUW\",\"tabindex\":13,\"type\":\"Label\",\"value\":\"E14b. Comune Resid. Sog. Oper.:\",\"w\":163,\"x\":18,\"y\":81,\"zone\":\"pag6_1_4\",\"zonepath\":\"[6,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":30,\"name\":\"E14B\",\"page\":6,\"picker\":true,\"spuid\":\"JMWSEEISWG\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":184,\"y\":77,\"zone\":\"pag6_1_4\",\"zonepath\":\"[6,1,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TKBWEFZLOK\",\"page\":6,\"spuid\":\"TKBWEFZLOK\",\"tabindex\":15,\"type\":\"Label\",\"value\":\"E14c. Provincia Residenza Sog. Oper.:\",\"w\":186,\"x\":435,\"y\":81,\"zone\":\"pag6_1_4\",\"zonepath\":\"[6,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":2,\"name\":\"E14C\",\"page\":6,\"spuid\":\"SHRVLATCSU\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":624,\"y\":77,\"zone\":\"pag6_1_4\",\"zonepath\":\"[6,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JLFXKKIAAW\",\"page\":6,\"spuid\":\"JLFXKKIAAW\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"E15. Indirizzo Resid. Sog. Oper.:\",\"w\":163,\"x\":18,\"y\":102,\"zone\":\"pag6_1_5\",\"zonepath\":\"[6,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":35,\"name\":\"E15\",\"page\":6,\"spuid\":\"VOGKTTTAQY\",\"tabindex\":18,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":240,\"x\":184,\"y\":98,\"zone\":\"pag6_1_5\",\"zonepath\":\"[6,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FYHEKMFRKB\",\"page\":6,\"spuid\":\"FYHEKMFRKB\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"E16. C.A.P. Sog. Oper.:\",\"w\":166,\"x\":455,\"y\":102,\"zone\":\"pag6_1_5\",\"zonepath\":\"[6,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":5,\"name\":\"E16\",\"page\":6,\"spuid\":\"CSJKLGPLSD\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":624,\"y\":98,\"zone\":\"pag6_1_5\",\"zonepath\":\"[6,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GCHVAXKWGU\",\"page\":6,\"spuid\":\"GCHVAXKWGU\",\"tabindex\":21,\"type\":\"Label\",\"value\":\"E17. Codice Fiscale Sog. Oper.:\",\"w\":163,\"x\":18,\"y\":123,\"zone\":\"pag6_1_6\",\"zonepath\":\"[6,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":16,\"name\":\"E17\",\"page\":6,\"spuid\":\"HZXHSFBWVP\",\"tabindex\":22,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":114,\"x\":184,\"y\":119,\"zone\":\"pag6_1_6\",\"zonepath\":\"[6,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SPFWVWEKNI\",\"page\":6,\"spuid\":\"SPFWVWEKNI\",\"tabindex\":23,\"type\":\"Label\",\"value\":\"E18. Data Nascita Sog. Oper.:\",\"w\":146,\"x\":35,\"y\":151,\"zone\":\"pag6_1_7\",\"zonepath\":\"[6,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":10,\"name\":\"E18\",\"page\":6,\"spuid\":\"STLDMRXUQZ\",\"tabindex\":24,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":184,\"y\":147,\"zone\":\"pag6_1_7\",\"zonepath\":\"[6,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":30,\"name\":\"E19A\",\"page\":6,\"picker\":true,\"spuid\":\"OZDICWDQRW\",\"tabindex\":26,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":536,\"y\":147,\"zone\":\"pag6_1_8\",\"zonepath\":\"[6,1,8]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MBLKVJSFTS\",\"page\":6,\"spuid\":\"MBLKVJSFTS\",\"tabindex\":37,\"type\":\"Label\",\"value\":\"E19. Comune Nascita Sog. Oper.:\",\"w\":178,\"x\":355,\"y\":151,\"zone\":\"pag6_1_8\",\"zonepath\":\"[6,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":30,\"name\":\"E19B\",\"page\":6,\"picker\":true,\"spuid\":\"YSNADFXEBL\",\"tabindex\":27,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":536,\"y\":168,\"zone\":\"pag6_1_9\",\"zonepath\":\"[6,1,9]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KOZHYMKNEL\",\"page\":6,\"spuid\":\"KOZHYMKNEL\",\"tabindex\":38,\"type\":\"Label\",\"value\":\"E19. Stato Nascita Sog. Oper.:\",\"w\":163,\"x\":370,\"y\":172,\"zone\":\"pag6_1_9\",\"zonepath\":\"[6,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NDAMZGRGWK\",\"page\":6,\"spuid\":\"NDAMZGRGWK\",\"tabindex\":25,\"type\":\"Label\",\"value\":\"E41. Tipo Documento Sog. Oper.:\",\"w\":162,\"x\":27,\"y\":193,\"zone\":\"pag6_1_10\",\"zonepath\":\"[6,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":2,\"name\":\"E41\",\"page\":6,\"picker\":true,\"spuid\":\"SZZONHIXUX\",\"tabindex\":28,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":38,\"x\":192,\"y\":189,\"zone\":\"pag6_1_10\",\"zonepath\":\"[6,1,10]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_CXEOWDRJVB\",\"page\":6,\"spuid\":\"CXEOWDRJVB\",\"tabindex\":30,\"type\":\"Label\",\"w\":496,\"x\":256,\"y\":193,\"zone\":\"pag6_1_10\",\"zonepath\":\"[6,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OKVSRMKJOK\",\"page\":6,\"spuid\":\"OKVSRMKJOK\",\"tabindex\":31,\"type\":\"Label\",\"value\":\"E42. N\\u00B0 Documento Sog. Oper.:\",\"w\":160,\"x\":29,\"y\":214,\"zone\":\"pag6_1_11\",\"zonepath\":\"[6,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":15,\"name\":\"E42\",\"page\":6,\"spuid\":\"GVZBHBTNIN\",\"tabindex\":32,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":192,\"y\":210,\"zone\":\"pag6_1_11\",\"zonepath\":\"[6,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JLMMAURJJN\",\"page\":6,\"spuid\":\"JLMMAURJJN\",\"tabindex\":33,\"type\":\"Label\",\"value\":\"E43. Data Rilascio Doc. Sog. Oper.:\",\"w\":184,\"x\":357,\"y\":214,\"zone\":\"pag6_1_11\",\"zonepath\":\"[6,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":10,\"name\":\"E43\",\"page\":6,\"spuid\":\"YTZBMCKQSI\",\"tabindex\":34,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":544,\"y\":210,\"zone\":\"pag6_1_11\",\"zonepath\":\"[6,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KDMYNCMQHO\",\"page\":6,\"spuid\":\"KDMYNCMQHO\",\"tabindex\":35,\"type\":\"Label\",\"value\":\"E44. Autorit\\u00E0 e Luogo Rilascio:\",\"w\":160,\"x\":29,\"y\":235,\"zone\":\"pag6_1_12\",\"zonepath\":\"[6,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":30,\"name\":\"E44\",\"page\":6,\"spuid\":\"YQCFUVRDIB\",\"tabindex\":36,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":192,\"y\":231,\"zone\":\"pag6_1_12\",\"zonepath\":\"[6,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MXCBJNKZYQ\",\"page\":6,\"spuid\":\"MXCBJNKZYQ\",\"tabindex\":39,\"type\":\"Label\",\"value\":\"E45. Sesso:\",\"w\":160,\"x\":29,\"y\":263,\"zone\":\"pag6_1_13\",\"zonepath\":\"[6,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"E45\",\"page\":6,\"spuid\":\"RZGRAAMFRQ\",\"tabindex\":40,\"textlist\":\"Maschile,Femminile\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":176,\"x\":192,\"y\":259,\"zone\":\"pag6_1_13\",\"zonepath\":\"[6,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_RKEDQZABYX\",\"h\":35,\"name\":\"box_RKEDQZABYX\",\"page\":6,\"shrinkable\":true,\"spuid\":\"RKEDQZABYX\",\"tabindex\":2,\"type\":\"Box\",\"w\":752,\"x\":0,\"y\":401,\"zone\":\"pag6_2\",\"zonepath\":\"[6,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SXXUVRYCBH\",\"page\":6,\"spuid\":\"SXXUVRYCBH\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Attributi Selezionati:\",\"w\":97,\"x\":5,\"y\":412,\"zone\":\"pag6_2_1\",\"zonepath\":\"[6,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"attsel\",\"page\":6,\"readonly\":\"true\",\"spuid\":\"MMCNOUUVWE\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":104,\"y\":408,\"zone\":\"pag6_2_1\",\"zonepath\":\"[6,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_LCRRHHJFHF\",\"page\":6,\"spuid\":\"LCRRHHJFHF\",\"tabindex\":5,\"type\":\"Label\",\"value\":\"Richieste:\",\"w\":47,\"x\":184,\"y\":412,\"zone\":\"pag6_2_1\",\"zonepath\":\"[6,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"richieste\",\"page\":6,\"readonly\":\"true\",\"spuid\":\"ITXGQSYKLQ\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":232,\"y\":408,\"zone\":\"pag6_2_1\",\"zonepath\":\"[6,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_JLTUCUTXFV\",\"h\":399,\"name\":\"box_JLTUCUTXFV\",\"page\":7,\"shrinkable\":true,\"spuid\":\"JLTUCUTXFV\",\"tabindex\":1,\"type\":\"Box\",\"w\":752,\"x\":0,\"y\":0,\"zone\":\"pag7_1\",\"zonepath\":\"[7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QWBLLJYXNS\",\"page\":7,\"spuid\":\"QWBLLJYXNS\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"F11. Beneficiario:\",\"w\":158,\"x\":23,\"y\":11,\"zone\":\"pag7_1_1\",\"zonepath\":\"[7,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo intermediario\",\"h\":20,\"maxlength\":70,\"name\":\"F11\",\"page\":7,\"picker\":true,\"spuid\":\"XUTATNAFCN\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":432,\"x\":184,\"y\":7,\"zone\":\"pag7_1_1\",\"zonepath\":\"[7,1,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SYHUSLVFCD\",\"page\":7,\"spuid\":\"SYHUSLVFCD\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"F13. Codice Paese Beneficiario:\",\"w\":166,\"x\":15,\"y\":39,\"zone\":\"pag7_1_2\",\"zonepath\":\"[7,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":3,\"name\":\"F13\",\"page\":7,\"picker\":true,\"spuid\":\"GSQDROOXIH\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":62,\"x\":184,\"y\":35,\"zone\":\"pag7_1_2\",\"zonepath\":\"[7,1,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RZYRMOZJVB\",\"page\":7,\"spuid\":\"RZYRMOZJVB\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"F14a. CAB Comune Res. Benefic.:\",\"w\":176,\"x\":5,\"y\":60,\"zone\":\"pag7_1_3\",\"zonepath\":\"[7,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":6,\"name\":\"F14A\",\"page\":7,\"picker\":true,\"spuid\":\"AYOYZWWHED\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":62,\"x\":184,\"y\":56,\"zone\":\"pag7_1_3\",\"zonepath\":\"[7,1,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PZECWLNBMT\",\"page\":7,\"spuid\":\"PZECWLNBMT\",\"tabindex\":13,\"type\":\"Label\",\"value\":\"F14b. Comune Resid. Beneficiario:\",\"w\":165,\"x\":16,\"y\":81,\"zone\":\"pag7_1_4\",\"zonepath\":\"[7,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":30,\"name\":\"F14B\",\"page\":7,\"picker\":true,\"spuid\":\"ZKDTAIVYNT\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":184,\"y\":77,\"zone\":\"pag7_1_4\",\"zonepath\":\"[7,1,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IATOQRWIHQ\",\"page\":7,\"spuid\":\"IATOQRWIHQ\",\"tabindex\":15,\"type\":\"Label\",\"value\":\"F14c. Provincia Residenza Beneficiario:\",\"w\":187,\"x\":434,\"y\":81,\"zone\":\"pag7_1_4\",\"zonepath\":\"[7,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":2,\"name\":\"F14C\",\"page\":7,\"spuid\":\"SBSUVGTSQF\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":624,\"y\":77,\"zone\":\"pag7_1_4\",\"zonepath\":\"[7,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DTWECKAHQZ\",\"page\":7,\"spuid\":\"DTWECKAHQZ\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"F15. Indirizzo Resid. Beneficiario:\",\"w\":163,\"x\":18,\"y\":102,\"zone\":\"pag7_1_5\",\"zonepath\":\"[7,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":35,\"name\":\"F15\",\"page\":7,\"spuid\":\"TFVSJQEFKN\",\"tabindex\":18,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":240,\"x\":184,\"y\":98,\"zone\":\"pag7_1_5\",\"zonepath\":\"[7,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YOBMERVJPM\",\"page\":7,\"spuid\":\"YOBMERVJPM\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"F16. C.A.P. Beneficiario:\",\"w\":166,\"x\":455,\"y\":102,\"zone\":\"pag7_1_5\",\"zonepath\":\"[7,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":5,\"name\":\"F16\",\"page\":7,\"spuid\":\"CSKIGUYWKA\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":624,\"y\":98,\"zone\":\"pag7_1_5\",\"zonepath\":\"[7,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CXMIQWKTSH\",\"page\":7,\"spuid\":\"CXMIQWKTSH\",\"tabindex\":21,\"type\":\"Label\",\"value\":\"F17. Codice Fiscale Beneficiario:\",\"w\":163,\"x\":18,\"y\":123,\"zone\":\"pag7_1_6\",\"zonepath\":\"[7,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":16,\"name\":\"F17\",\"page\":7,\"spuid\":\"EWALMUXONU\",\"tabindex\":22,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":114,\"x\":184,\"y\":119,\"zone\":\"pag7_1_6\",\"zonepath\":\"[7,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_EITSLGXPKQ\",\"h\":35,\"name\":\"box_EITSLGXPKQ\",\"page\":7,\"shrinkable\":true,\"spuid\":\"EITSLGXPKQ\",\"tabindex\":2,\"type\":\"Box\",\"w\":752,\"x\":0,\"y\":401,\"zone\":\"pag7_2\",\"zonepath\":\"[7,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SXKIEJLNFT\",\"page\":7,\"spuid\":\"SXKIEJLNFT\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Attributi Selezionati:\",\"w\":97,\"x\":5,\"y\":412,\"zone\":\"pag7_2_1\",\"zonepath\":\"[7,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"attsel\",\"page\":7,\"readonly\":\"true\",\"spuid\":\"HZUCYQJVWZ\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":104,\"y\":408,\"zone\":\"pag7_2_1\",\"zonepath\":\"[7,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_CSLRNONFNA\",\"page\":7,\"spuid\":\"CSLRNONFNA\",\"tabindex\":5,\"type\":\"Label\",\"value\":\"Richieste:\",\"w\":47,\"x\":184,\"y\":412,\"zone\":\"pag7_2_1\",\"zonepath\":\"[7,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"richieste\",\"page\":7,\"readonly\":\"true\",\"spuid\":\"TJQZUIJXJA\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":232,\"y\":408,\"zone\":\"pag7_2_1\",\"zonepath\":\"[7,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_UOKHMLIEUR\",\"h\":399,\"name\":\"box_UOKHMLIEUR\",\"page\":8,\"shrinkable\":true,\"spuid\":\"UOKHMLIEUR\",\"tabindex\":1,\"type\":\"Box\",\"w\":752,\"x\":0,\"y\":0,\"zone\":\"pag8_1\",\"zonepath\":\"[8,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UWBVBSVVUA\",\"page\":8,\"spuid\":\"UWBVBSVVUA\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"G11. Titolare:\",\"w\":158,\"x\":23,\"y\":11,\"zone\":\"pag8_1_1\",\"zonepath\":\"[8,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo intermediario\",\"h\":20,\"maxlength\":70,\"name\":\"G11\",\"page\":8,\"picker\":true,\"spuid\":\"PGAPCLKWDU\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":432,\"x\":184,\"y\":7,\"zone\":\"pag8_1_1\",\"zonepath\":\"[8,1,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CJBHMTGUVX\",\"page\":8,\"spuid\":\"CJBHMTGUVX\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"G13. Codice Paese Tit.:\",\"w\":181,\"x\":0,\"y\":39,\"zone\":\"pag8_1_2\",\"zonepath\":\"[8,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":3,\"name\":\"G13\",\"page\":8,\"picker\":true,\"spuid\":\"NMVYSCDEYI\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":62,\"x\":184,\"y\":35,\"zone\":\"pag8_1_2\",\"zonepath\":\"[8,1,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FXAWPGUGEY\",\"page\":8,\"spuid\":\"FXAWPGUGEY\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"G14a. CAB Comune Reside. Tit.:\",\"w\":181,\"x\":0,\"y\":60,\"zone\":\"pag8_1_3\",\"zonepath\":\"[8,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":6,\"name\":\"G14A\",\"page\":8,\"picker\":true,\"spuid\":\"IZFSEEEELX\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":62,\"x\":184,\"y\":56,\"zone\":\"pag8_1_3\",\"zonepath\":\"[8,1,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JTMFWTSPOT\",\"page\":8,\"spuid\":\"JTMFWTSPOT\",\"tabindex\":13,\"type\":\"Label\",\"value\":\"G14b. Comune Residenza Tit.:\",\"w\":181,\"x\":0,\"y\":81,\"zone\":\"pag8_1_4\",\"zonepath\":\"[8,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":30,\"name\":\"G14B\",\"page\":8,\"picker\":true,\"spuid\":\"RZOPLJQQOD\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":184,\"y\":77,\"zone\":\"pag8_1_4\",\"zonepath\":\"[8,1,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YNRACSTHKM\",\"page\":8,\"spuid\":\"YNRACSTHKM\",\"tabindex\":15,\"type\":\"Label\",\"value\":\"G14c. Provincia Residenza Tit.:\",\"w\":166,\"x\":455,\"y\":81,\"zone\":\"pag8_1_4\",\"zonepath\":\"[8,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":2,\"name\":\"G14C\",\"page\":8,\"spuid\":\"YZZZVPGQXU\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":624,\"y\":77,\"zone\":\"pag8_1_4\",\"zonepath\":\"[8,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GFQIZPIFCE\",\"page\":8,\"spuid\":\"GFQIZPIFCE\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"G15. Indirizzo Residenza Tit.:\",\"w\":163,\"x\":18,\"y\":102,\"zone\":\"pag8_1_5\",\"zonepath\":\"[8,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":35,\"name\":\"G15\",\"page\":8,\"spuid\":\"YPHNWWQBAM\",\"tabindex\":18,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":240,\"x\":184,\"y\":98,\"zone\":\"pag8_1_5\",\"zonepath\":\"[8,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KXZFCUMEWU\",\"page\":8,\"spuid\":\"KXZFCUMEWU\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"G16. C.A.P. Tit.:\",\"w\":166,\"x\":455,\"y\":102,\"zone\":\"pag8_1_5\",\"zonepath\":\"[8,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":5,\"name\":\"G16\",\"page\":8,\"spuid\":\"ALVPQNRJEQ\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":624,\"y\":98,\"zone\":\"pag8_1_5\",\"zonepath\":\"[8,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UCYULWKFMB\",\"page\":8,\"spuid\":\"UCYULWKFMB\",\"tabindex\":21,\"type\":\"Label\",\"value\":\"G17. Codice Fiscale Tit.:\",\"w\":163,\"x\":18,\"y\":123,\"zone\":\"pag8_1_6\",\"zonepath\":\"[8,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":16,\"name\":\"G17\",\"page\":8,\"spuid\":\"IMPXVWAVVG\",\"tabindex\":22,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":114,\"x\":184,\"y\":119,\"zone\":\"pag8_1_6\",\"zonepath\":\"[8,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DXTWNKDPPU\",\"page\":8,\"spuid\":\"DXTWNKDPPU\",\"tabindex\":23,\"type\":\"Label\",\"value\":\"G18. Data Nascita Tit.:\",\"w\":127,\"x\":54,\"y\":151,\"zone\":\"pag8_1_7\",\"zonepath\":\"[8,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":10,\"name\":\"G18\",\"page\":8,\"spuid\":\"HICXAQROVP\",\"tabindex\":24,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":184,\"y\":147,\"zone\":\"pag8_1_7\",\"zonepath\":\"[8,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":30,\"name\":\"G19A\",\"page\":8,\"picker\":true,\"spuid\":\"GSZGYDPMMI\",\"tabindex\":25,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":536,\"y\":147,\"zone\":\"pag8_1_8\",\"zonepath\":\"[8,1,8]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FAOYGFYDWQ\",\"page\":8,\"spuid\":\"FAOYGFYDWQ\",\"tabindex\":37,\"type\":\"Label\",\"value\":\"G19. Comune Nascita Cliente:\",\"w\":163,\"x\":370,\"y\":151,\"zone\":\"pag8_1_8\",\"zonepath\":\"[8,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":30,\"name\":\"G19B\",\"page\":8,\"picker\":true,\"spuid\":\"HKGGYHAADA\",\"tabindex\":26,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":536,\"y\":168,\"zone\":\"pag8_1_9\",\"zonepath\":\"[8,1,9]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XHXKUAFOPX\",\"page\":8,\"spuid\":\"XHXKUAFOPX\",\"tabindex\":38,\"type\":\"Label\",\"value\":\"G19. Stato Nascita Cliente:\",\"w\":163,\"x\":370,\"y\":172,\"zone\":\"pag8_1_9\",\"zonepath\":\"[8,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZVVVRLQFHT\",\"page\":8,\"spuid\":\"ZVVVRLQFHT\",\"tabindex\":27,\"type\":\"Label\",\"value\":\"G41. Tipo Documento Tit.:\",\"w\":143,\"x\":38,\"y\":214,\"zone\":\"pag8_1_10\",\"zonepath\":\"[8,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":2,\"name\":\"G41\",\"page\":8,\"picker\":true,\"spuid\":\"BCOSCDETUR\",\"tabindex\":28,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":38,\"x\":184,\"y\":210,\"zone\":\"pag8_1_10\",\"zonepath\":\"[8,1,10]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_ZKBMLTPVQH\",\"page\":8,\"spuid\":\"ZKBMLTPVQH\",\"tabindex\":30,\"type\":\"Label\",\"w\":496,\"x\":248,\"y\":214,\"zone\":\"pag8_1_10\",\"zonepath\":\"[8,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OCGDPFLIKF\",\"page\":8,\"spuid\":\"OCGDPFLIKF\",\"tabindex\":31,\"type\":\"Label\",\"value\":\"G42. Numero Documento Tit.:\",\"w\":160,\"x\":21,\"y\":235,\"zone\":\"pag8_1_11\",\"zonepath\":\"[8,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":15,\"name\":\"G42\",\"page\":8,\"spuid\":\"KTOZCJXWSV\",\"tabindex\":32,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":184,\"y\":231,\"zone\":\"pag8_1_11\",\"zonepath\":\"[8,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZTBBTGYDFF\",\"page\":8,\"spuid\":\"ZTBBTGYDFF\",\"tabindex\":33,\"type\":\"Label\",\"value\":\"G43. Data Rilascio Documento Tit.:\",\"w\":184,\"x\":349,\"y\":235,\"zone\":\"pag8_1_11\",\"zonepath\":\"[8,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":10,\"name\":\"G43\",\"page\":8,\"spuid\":\"NVUUMCKUPB\",\"tabindex\":34,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":536,\"y\":231,\"zone\":\"pag8_1_11\",\"zonepath\":\"[8,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KRPFTRBGAY\",\"page\":8,\"spuid\":\"KRPFTRBGAY\",\"tabindex\":35,\"type\":\"Label\",\"value\":\"G44. Autorit\\u00E0 e Luogo Rilascio:\",\"w\":162,\"x\":19,\"y\":256,\"zone\":\"pag8_1_12\",\"zonepath\":\"[8,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":30,\"name\":\"G44\",\"page\":8,\"spuid\":\"JRWWNQSHYE\",\"tabindex\":36,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":184,\"y\":252,\"zone\":\"pag8_1_12\",\"zonepath\":\"[8,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DNIOKHMKXP\",\"page\":8,\"spuid\":\"DNIOKHMKXP\",\"tabindex\":39,\"type\":\"Label\",\"value\":\"G45. Sesso:\",\"w\":160,\"x\":21,\"y\":284,\"zone\":\"pag8_1_13\",\"zonepath\":\"[8,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"G45\",\"page\":8,\"spuid\":\"HCXFFYRBOR\",\"tabindex\":40,\"textlist\":\"Maschile,Femminile\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":176,\"x\":184,\"y\":280,\"zone\":\"pag8_1_13\",\"zonepath\":\"[8,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_ZGRJNQPUNM\",\"h\":35,\"name\":\"box_ZGRJNQPUNM\",\"page\":8,\"shrinkable\":true,\"spuid\":\"ZGRJNQPUNM\",\"tabindex\":2,\"type\":\"Box\",\"w\":752,\"x\":0,\"y\":401,\"zone\":\"pag8_2\",\"zonepath\":\"[8,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZMPORIFPRF\",\"page\":8,\"spuid\":\"ZMPORIFPRF\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Attributi Selezionati:\",\"w\":97,\"x\":5,\"y\":412,\"zone\":\"pag8_2_1\",\"zonepath\":\"[8,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"attsel\",\"page\":8,\"readonly\":\"true\",\"spuid\":\"SEYNWLHCKS\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":104,\"y\":408,\"zone\":\"pag8_2_1\",\"zonepath\":\"[8,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_TDFJGVRMRA\",\"page\":8,\"spuid\":\"TDFJGVRMRA\",\"tabindex\":5,\"type\":\"Label\",\"value\":\"Richieste:\",\"w\":47,\"x\":184,\"y\":412,\"zone\":\"pag8_2_1\",\"zonepath\":\"[8,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"richieste\",\"page\":8,\"readonly\":\"true\",\"spuid\":\"UDWBDWNMCH\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":232,\"y\":408,\"zone\":\"pag8_2_1\",\"zonepath\":\"[8,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_OFWGQIZSXD\",\"h\":399,\"name\":\"box_OFWGQIZSXD\",\"page\":9,\"shrinkable\":true,\"spuid\":\"OFWGQIZSXD\",\"tabindex\":1,\"type\":\"Box\",\"w\":752,\"x\":0,\"y\":0,\"zone\":\"pag9_1\",\"zonepath\":\"[9,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VIEBKKOUYW\",\"page\":9,\"spuid\":\"VIEBKKOUYW\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"H11. Soggetto per conto del quale:\",\"w\":185,\"x\":-4,\"y\":11,\"zone\":\"pag9_1_1\",\"zonepath\":\"[9,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo intermediario\",\"h\":20,\"maxlength\":70,\"name\":\"H11\",\"page\":9,\"picker\":true,\"spuid\":\"LWFUPEVCFF\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":432,\"x\":184,\"y\":7,\"zone\":\"pag9_1_1\",\"zonepath\":\"[9,1,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JEZUQVAWKX\",\"page\":9,\"spuid\":\"JEZUQVAWKX\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"H13. Codice Paese:\",\"w\":181,\"x\":0,\"y\":39,\"zone\":\"pag9_1_2\",\"zonepath\":\"[9,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":3,\"name\":\"H13\",\"page\":9,\"picker\":true,\"spuid\":\"LMFVWUIXUQ\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":62,\"x\":184,\"y\":35,\"zone\":\"pag9_1_2\",\"zonepath\":\"[9,1,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PBBYNFBXGI\",\"page\":9,\"spuid\":\"PBBYNFBXGI\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"H14A. CAB Comune Residenza:\",\"w\":181,\"x\":0,\"y\":60,\"zone\":\"pag9_1_3\",\"zonepath\":\"[9,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":6,\"name\":\"H14A\",\"page\":9,\"picker\":true,\"spuid\":\"EVWGKCMMJY\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":62,\"x\":184,\"y\":56,\"zone\":\"pag9_1_3\",\"zonepath\":\"[9,1,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JZEQURMYIA\",\"page\":9,\"spuid\":\"JZEQURMYIA\",\"tabindex\":13,\"type\":\"Label\",\"value\":\"H14B. Comune Residenza:\",\"w\":181,\"x\":0,\"y\":81,\"zone\":\"pag9_1_4\",\"zonepath\":\"[9,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":30,\"name\":\"H14B\",\"page\":9,\"picker\":true,\"spuid\":\"UVHIQLABPT\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":184,\"y\":77,\"zone\":\"pag9_1_4\",\"zonepath\":\"[9,1,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XACHSHIOBM\",\"page\":9,\"spuid\":\"XACHSHIOBM\",\"tabindex\":15,\"type\":\"Label\",\"value\":\"H14C. Provincia Residenza:\",\"w\":166,\"x\":455,\"y\":81,\"zone\":\"pag9_1_4\",\"zonepath\":\"[9,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":2,\"name\":\"H14C\",\"page\":9,\"spuid\":\"ERDRBGAWFM\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":624,\"y\":77,\"zone\":\"pag9_1_4\",\"zonepath\":\"[9,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AFJYTDAGME\",\"page\":9,\"spuid\":\"AFJYTDAGME\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"H15. Indirizzo Residenza:\",\"w\":163,\"x\":18,\"y\":102,\"zone\":\"pag9_1_5\",\"zonepath\":\"[9,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":35,\"name\":\"H15\",\"page\":9,\"spuid\":\"QCIYKOSBAC\",\"tabindex\":18,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":240,\"x\":184,\"y\":98,\"zone\":\"pag9_1_5\",\"zonepath\":\"[9,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BOVZPEFEJL\",\"page\":9,\"spuid\":\"BOVZPEFEJL\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"H16. C.A.P.:\",\"w\":166,\"x\":455,\"y\":102,\"zone\":\"pag9_1_5\",\"zonepath\":\"[9,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":5,\"name\":\"H16\",\"page\":9,\"spuid\":\"SDOQENNYTS\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":624,\"y\":98,\"zone\":\"pag9_1_5\",\"zonepath\":\"[9,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_REFYDNGVOA\",\"page\":9,\"spuid\":\"REFYDNGVOA\",\"tabindex\":21,\"type\":\"Label\",\"value\":\"H17. Codice Fiscale:\",\"w\":163,\"x\":18,\"y\":123,\"zone\":\"pag9_1_6\",\"zonepath\":\"[9,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":16,\"name\":\"H17\",\"page\":9,\"spuid\":\"MYCAJZEAYR\",\"tabindex\":22,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":114,\"x\":184,\"y\":119,\"zone\":\"pag9_1_6\",\"zonepath\":\"[9,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NROFEEDXHZ\",\"page\":9,\"spuid\":\"NROFEEDXHZ\",\"tabindex\":23,\"type\":\"Label\",\"value\":\"H18. Data Nascita:\",\"w\":127,\"x\":54,\"y\":151,\"zone\":\"pag9_1_7\",\"zonepath\":\"[9,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":10,\"name\":\"H18\",\"page\":9,\"spuid\":\"MJSLFJOSLC\",\"tabindex\":24,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":184,\"y\":147,\"zone\":\"pag9_1_7\",\"zonepath\":\"[9,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":30,\"name\":\"H19A\",\"page\":9,\"picker\":true,\"spuid\":\"KCGLCUJYUP\",\"tabindex\":25,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":536,\"y\":147,\"zone\":\"pag9_1_8\",\"zonepath\":\"[9,1,8]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FOKITCSEDA\",\"page\":9,\"spuid\":\"FOKITCSEDA\",\"tabindex\":37,\"type\":\"Label\",\"value\":\"H19. Comune Nascita:\",\"w\":163,\"x\":370,\"y\":151,\"zone\":\"pag9_1_8\",\"zonepath\":\"[9,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":30,\"name\":\"H19B\",\"page\":9,\"picker\":true,\"spuid\":\"RQOFXUOOWZ\",\"tabindex\":26,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":536,\"y\":168,\"zone\":\"pag9_1_9\",\"zonepath\":\"[9,1,9]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GLNDCEAZTM\",\"page\":9,\"spuid\":\"GLNDCEAZTM\",\"tabindex\":38,\"type\":\"Label\",\"value\":\"H19. Stato Nascita:\",\"w\":163,\"x\":370,\"y\":172,\"zone\":\"pag9_1_9\",\"zonepath\":\"[9,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YAPYXTTVDV\",\"page\":9,\"spuid\":\"YAPYXTTVDV\",\"tabindex\":27,\"type\":\"Label\",\"value\":\"H41. Tipo Documento:\",\"w\":143,\"x\":38,\"y\":214,\"zone\":\"pag9_1_10\",\"zonepath\":\"[9,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":2,\"name\":\"H41\",\"page\":9,\"picker\":true,\"spuid\":\"OAWXXEHPRA\",\"tabindex\":28,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":38,\"x\":184,\"y\":210,\"zone\":\"pag9_1_10\",\"zonepath\":\"[9,1,10]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_OBHLLYIHEI\",\"page\":9,\"spuid\":\"OBHLLYIHEI\",\"tabindex\":30,\"type\":\"Label\",\"w\":496,\"x\":248,\"y\":214,\"zone\":\"pag9_1_10\",\"zonepath\":\"[9,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RSGEAFOUFH\",\"page\":9,\"spuid\":\"RSGEAFOUFH\",\"tabindex\":31,\"type\":\"Label\",\"value\":\"H42. Numero Documento:\",\"w\":160,\"x\":21,\"y\":235,\"zone\":\"pag9_1_11\",\"zonepath\":\"[9,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":15,\"name\":\"H42\",\"page\":9,\"spuid\":\"EVIOJXHHYZ\",\"tabindex\":32,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":184,\"y\":231,\"zone\":\"pag9_1_11\",\"zonepath\":\"[9,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OCPLYOVTEC\",\"page\":9,\"spuid\":\"OCPLYOVTEC\",\"tabindex\":33,\"type\":\"Label\",\"value\":\"H43. Data Rilascio Documento:\",\"w\":184,\"x\":349,\"y\":235,\"zone\":\"pag9_1_11\",\"zonepath\":\"[9,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":10,\"name\":\"H43\",\"page\":9,\"spuid\":\"AAPLEODVNN\",\"tabindex\":34,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":536,\"y\":231,\"zone\":\"pag9_1_11\",\"zonepath\":\"[9,1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JLWOSLULYH\",\"page\":9,\"spuid\":\"JLWOSLULYH\",\"tabindex\":35,\"type\":\"Label\",\"value\":\"H44. Autorit\\u00E0 e Luogo Rilascio:\",\"w\":162,\"x\":19,\"y\":256,\"zone\":\"pag9_1_12\",\"zonepath\":\"[9,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":30,\"name\":\"H44\",\"page\":9,\"spuid\":\"PBYCEMAFOR\",\"tabindex\":36,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":184,\"y\":252,\"zone\":\"pag9_1_12\",\"zonepath\":\"[9,1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IEJJSMSSFK\",\"page\":9,\"spuid\":\"IEJJSMSSFK\",\"tabindex\":39,\"type\":\"Label\",\"value\":\"H45. Sesso:\",\"w\":160,\"x\":21,\"y\":284,\"zone\":\"pag9_1_13\",\"zonepath\":\"[9,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"H45\",\"page\":9,\"spuid\":\"CCGDGWYZHO\",\"tabindex\":40,\"textlist\":\"Maschile,Femminile\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":176,\"x\":184,\"y\":280,\"zone\":\"pag9_1_13\",\"zonepath\":\"[9,1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_XECCYIEIAP\",\"h\":35,\"name\":\"box_XECCYIEIAP\",\"page\":9,\"shrinkable\":true,\"spuid\":\"XECCYIEIAP\",\"tabindex\":2,\"type\":\"Box\",\"w\":752,\"x\":0,\"y\":401,\"zone\":\"pag9_2\",\"zonepath\":\"[9,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EDVJDUZOHS\",\"page\":9,\"spuid\":\"EDVJDUZOHS\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Attributi Selezionati:\",\"w\":97,\"x\":5,\"y\":412,\"zone\":\"pag9_2_1\",\"zonepath\":\"[9,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"attsel\",\"page\":9,\"readonly\":\"true\",\"spuid\":\"ODJVXHJRMG\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":104,\"y\":408,\"zone\":\"pag9_2_1\",\"zonepath\":\"[9,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_NJTGFZIVPP\",\"page\":9,\"spuid\":\"NJTGFZIVPP\",\"tabindex\":5,\"type\":\"Label\",\"value\":\"Richieste:\",\"w\":47,\"x\":184,\"y\":412,\"zone\":\"pag9_2_1\",\"zonepath\":\"[9,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"richieste\",\"page\":9,\"readonly\":\"true\",\"spuid\":\"WRQUPUNDJP\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":232,\"y\":408,\"zone\":\"pag9_2_1\",\"zonepath\":\"[9,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_ricercamassaBO BO,ServletStatus status) {
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
     "<script src='armt_ricercamassa?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_ricercamassa_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_ricercamassa_edit.js'>" +
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
      status.out.println("w_attsel=a[0];");
      status.out.println("w_G11=a[1];");
      status.out.println("w_G13=a[2];");
      status.out.println("w_G14A=a[3];");
      status.out.println("w_G14B=a[4];");
      status.out.println("w_G14C=a[5];");
      status.out.println("w_G15=a[6];");
      status.out.println("w_G16=a[7];");
      status.out.println("w_G17=a[8];");
      status.out.println("w_G18=a[9];");
      status.out.println("w_G19A=a[10];");
      status.out.println("w_G19B=a[11];");
      status.out.println("w_G41=a[12];");
      status.out.println("w_G42=a[13];");
      status.out.println("w_G43=a[14];");
      status.out.println("w_G44=a[15];");
      status.out.println("w_F11=a[16];");
      status.out.println("w_F13=a[17];");
      status.out.println("w_F14A=a[18];");
      status.out.println("w_F14B=a[19];");
      status.out.println("w_F14C=a[20];");
      status.out.println("w_F15=a[21];");
      status.out.println("w_F16=a[22];");
      status.out.println("w_F17=a[23];");
      status.out.println("w_E11=a[24];");
      status.out.println("w_E13=a[25];");
      status.out.println("w_E14A=a[26];");
      status.out.println("w_E14B=a[27];");
      status.out.println("w_E14C=a[28];");
      status.out.println("w_E15=a[29];");
      status.out.println("w_E16=a[30];");
      status.out.println("w_E17=a[31];");
      status.out.println("w_E18=a[32];");
      status.out.println("w_E19A=a[33];");
      status.out.println("w_E19B=a[34];");
      status.out.println("w_E41=a[35];");
      status.out.println("w_E42=a[36];");
      status.out.println("w_E43=a[37];");
      status.out.println("w_E44=a[38];");
      status.out.println("w_D11=a[39];");
      status.out.println("w_D13=a[40];");
      status.out.println("w_D14A=a[41];");
      status.out.println("w_D14B=a[42];");
      status.out.println("w_D14C=a[43];");
      status.out.println("w_D15=a[44];");
      status.out.println("w_D16=a[45];");
      status.out.println("w_D17=a[46];");
      status.out.println("w_D18=a[47];");
      status.out.println("w_D19A=a[48];");
      status.out.println("w_D19B=a[49];");
      status.out.println("w_D21=a[50];");
      status.out.println("w_D22=a[51];");
      status.out.println("w_D23=a[52];");
      status.out.println("w_D41=a[53];");
      status.out.println("w_D42=a[54];");
      status.out.println("w_D43=a[55];");
      status.out.println("w_D44=a[56];");
      status.out.println("w_C11=a[57];");
      status.out.println("w_C21=a[58];");
      status.out.println("w_C31=a[59];");
      status.out.println("w_B11=a[60];");
      status.out.println("w_B12=a[61];");
      status.out.println("w_B13=a[62];");
      status.out.println("w_B14=a[63];");
      status.out.println("w_B15=a[64];");
      status.out.println("w_X_B14_OP=a[65];");
      status.out.println("w_X_B15_OP=a[66];");
      status.out.println("w_A01A=a[67];");
      status.out.println("w_A01B=a[68];");
      status.out.println("w_A03=a[69];");
      status.out.println("w_A11=a[70];");
      status.out.println("w_A12A=a[71];");
      status.out.println("w_A12B=a[72];");
      status.out.println("w_A12C=a[73];");
      status.out.println("w_A21=a[74];");
      status.out.println("w_A22=a[75];");
      status.out.println("w_A23=a[76];");
      status.out.println("w_A24=a[77];");
      status.out.println("w_A25=a[78];");
      status.out.println("w_A31A=a[79];");
      status.out.println("w_A31B=a[80];");
      status.out.println("w_A32=a[81];");
      status.out.println("w_A33A=a[82];");
      status.out.println("w_A33B=a[83];");
      status.out.println("w_A33C=a[84];");
      status.out.println("w_A34=a[85];");
      status.out.println("w_A41=a[86];");
      status.out.println("w_A42=a[87];");
      status.out.println("w_A43=a[88];");
      status.out.println("w_A51=a[89];");
      status.out.println("w_A52B=a[90];");
      status.out.println("w_A53=a[91];");
      status.out.println("w_A54A=a[92];");
      status.out.println("w_A54B=a[93];");
      status.out.println("w_A54C=a[94];");
      status.out.println("w_IDBASE=a[95];");
      status.out.println("op_IDBASE=a[96];");
      status.out.println("w_archivio=a[97];");
      status.out.println("w_C41=a[98];");
      status.out.println("w_C51=a[99];");
      status.out.println("w_H11=a[100];");
      status.out.println("w_H13=a[101];");
      status.out.println("w_H14A=a[102];");
      status.out.println("w_H14B=a[103];");
      status.out.println("w_H14C=a[104];");
      status.out.println("w_H15=a[105];");
      status.out.println("w_H16=a[106];");
      status.out.println("w_H17=a[107];");
      status.out.println("w_H18=a[108];");
      status.out.println("w_H19A=a[109];");
      status.out.println("w_H19B=a[110];");
      status.out.println("w_H41=a[111];");
      status.out.println("w_H42=a[112];");
      status.out.println("w_H43=a[113];");
      status.out.println("w_H44=a[114];");
      status.out.println("w_D45=a[115];");
      status.out.println("w_E45=a[116];");
      status.out.println("w_G45=a[117];");
      status.out.println("w_H45=a[118];");
      status.out.println("w_richieste=a[119];");
      status.out.println("w_xdestipdoct=a[120];");
      status.out.println("w_xdestipdocsg=a[121];");
      status.out.println("w_xdessoteco=a[122];");
      status.out.println("w_xdesramgrp=a[123];");
      status.out.println("w_xdessetsin=a[124];");
      status.out.println("w_xdestipdoc=a[125];");
      status.out.println("w_xragintes=a[126];");
      status.out.println("w_xragsogope=a[127];");
      status.out.println("w_xragbenef=a[128];");
      status.out.println("w_xdesval=a[129];");
      status.out.println("w_xraginter=a[130];");
      status.out.println("w_xdesdip=a[131];");
      status.out.println("w_xdescittab=a[132];");
      status.out.println("w_xtipleg=a[133];");
      status.out.println("w_xdesrap=a[134];");
      status.out.println("w_oldval=a[135];");
      status.out.println("w_xragsecond=a[136];");
      status.out.println("w_xragterzo=a[137];");
      status.out.println("w_xdestipdoct1=a[138];");
      status.out.println("if (Gt(a.length,139)) {");
      status.out.println("o_A01A=w_A01A;");
      status.out.println("o_A01B=w_A01B;");
      status.out.println("o_A03=w_A03;");
      status.out.println("o_A11=w_A11;");
      status.out.println("o_A12A=w_A12A;");
      status.out.println("o_A12B=w_A12B;");
      status.out.println("o_A12C=w_A12C;");
      status.out.println("o_A21=w_A21;");
      status.out.println("o_A22=w_A22;");
      status.out.println("o_A23=w_A23;;");
      status.out.println("o_A24=w_A24;");
      status.out.println("o_A25=w_A25;");
      status.out.println("o_A31A=w_A31A;");
      status.out.println("o_A31B=w_A31B;");
      status.out.println("o_A32=w_A32;");
      status.out.println("o_A33A=w_A33A;");
      status.out.println("o_A33B=w_A33B;");
      status.out.println("o_A33C=w_A33C;");
      status.out.println("o_A34=w_A34;");
      status.out.println("o_A41=w_A41;");
      status.out.println("o_A42=w_A42;");
      status.out.println("o_A43=w_A43;");
      status.out.println("o_A51=w_A51;");
      status.out.println("o_A52B=w_A52B;");
      status.out.println("o_A53=w_A53;");
      status.out.println("o_A54A=w_A54A;");
      status.out.println("o_A54B=w_A54B;");
      status.out.println("o_A54C=w_A54C;");
      status.out.println("o_B11=w_B11;");
      status.out.println("o_B12=w_B12;");
      status.out.println("o_B13=w_B13;");
      status.out.println("o_B14=w_B14;");
      status.out.println("o_B15=w_B15;");
      status.out.println("o_C11=w_C11;");
      status.out.println("o_C21=w_C21;");
      status.out.println("o_C31=w_C31;");
      status.out.println("o_D11=w_D11;");
      status.out.println("o_D13=w_D13;");
      status.out.println("o_D14A=w_D14A;");
      status.out.println("o_D14B=w_D14B;");
      status.out.println("o_D14C=w_D14C;");
      status.out.println("o_D15=w_D15;");
      status.out.println("o_D16=w_D16;");
      status.out.println("o_D17=w_D17;");
      status.out.println("o_D18=w_D18;");
      status.out.println("o_D19A=w_D19A;");
      status.out.println("o_D19B=w_D19B;");
      status.out.println("o_D21=w_D21;");
      status.out.println("o_D22=w_D22;");
      status.out.println("o_D23=w_D23;");
      status.out.println("o_D41=w_D41;");
      status.out.println("o_D42=w_D42;");
      status.out.println("o_D43=w_D43;");
      status.out.println("o_D44=w_D44;");
      status.out.println("o_D45=w_D45;");
      status.out.println("o_E11=w_E11;");
      status.out.println("o_E13=w_E13;");
      status.out.println("o_E14A=w_E14A;");
      status.out.println("o_E14B=w_E14B;");
      status.out.println("o_E14C=w_E14C;");
      status.out.println("o_E15=w_E15;");
      status.out.println("o_E16=w_E16;");
      status.out.println("o_E17=w_E17;");
      status.out.println("o_E18=w_E18;");
      status.out.println("o_E19A=w_E19A;");
      status.out.println("o_E19B=w_E19B;");
      status.out.println("o_E41=w_E41;");
      status.out.println("o_E42=w_E42;");
      status.out.println("o_E43=w_E43;");
      status.out.println("o_E44=w_E44;");
      status.out.println("o_E45=w_E45;");
      status.out.println("o_F11=w_F11;");
      status.out.println("o_F13=w_F13;");
      status.out.println("o_F14A=w_F14A;");
      status.out.println("o_F14B=w_F14B;");
      status.out.println("o_F14C=w_F14C;");
      status.out.println("o_F15=w_F15;");
      status.out.println("o_F16=w_F16;");
      status.out.println("o_F17=w_F17;");
      status.out.println("o_G11=w_G11;");
      status.out.println("o_G13=w_G13;");
      status.out.println("o_G14A=w_G14A;");
      status.out.println("o_G14B=w_G14B;");
      status.out.println("o_G14C=w_G14C;");
      status.out.println("o_G15=w_G15;");
      status.out.println("o_G16=w_G16;");
      status.out.println("o_G17=w_G17;");
      status.out.println("o_G18=w_G18;");
      status.out.println("o_G19A=w_G19A;");
      status.out.println("o_G19B=w_G19B;");
      status.out.println("o_G41=w_G41;");
      status.out.println("o_G42=w_G42;");
      status.out.println("o_G43=w_G43;");
      status.out.println("o_G44=w_G44;");
      status.out.println("o_G45=w_G45;");
      status.out.println("o_H11=w_H11;");
      status.out.println("o_H13=w_H13;");
      status.out.println("o_H14A=w_H14A;");
      status.out.println("o_H14B=w_H14B;");
      status.out.println("o_H14C=w_H14C;");
      status.out.println("o_H15=w_H15;");
      status.out.println("o_H16=w_H16;");
      status.out.println("o_H17=w_H17;");
      status.out.println("o_H18=w_H18;");
      status.out.println("o_H19A=w_H19A;");
      status.out.println("o_H19B=w_H19B;");
      status.out.println("o_H41=w_H41;");
      status.out.println("o_H42=w_H42;");
      status.out.println("o_H43=w_H43;");
      status.out.println("o_H44=w_H44;");
      status.out.println("o_H45=w_H45;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['IDBASE'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_ricercamassa_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(404,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","tmp_ricmas1");
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
  void RaiseLoadedEntity(armt_ricercamassaBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_ricercamassaBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(armt_ricercamassaBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(armt_ricercamassaBO BO,ServletStatus status) {
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
  void WriteExitPage(armt_ricercamassaBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_ricercamassaBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_ricercamassaBO BO,ServletStatus status) throws IOException {
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
    status.out.println(
     "<script src='SPPrxy/"+arfn_calcrichieste.m_cEntityUid+"/arfn_calcrichieste.js'>" +
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
      arfn_calcrichieste.GetCallableNames(callable);
      arrt_ricercamassa.GetCallableNames(callable);
      CPLib.AddToSet(callable,"LibreriaMit");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_ricercamassaBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_IDBASE),"C",10,0));
      }
    } else if (CPLib.eq(p_cUID,"TIPXBDXITE")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"BQNMQAOIPA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"XHIBDWLIOD")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"IFYLHOXPRS")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"CKACALWZOL")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ZIMEUPPLZY")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ZZQPEDWGCO")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"LTUCQORMSA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"VDWEKDDBOW")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"BICDANUWZD")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"HDIAJDVNVI")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"RQJLOLNIHM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"CHJJABTJCS")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"DFFBWGMKTL")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"CDFYKKBMYS")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"BZRDFHBMPM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"UYRQHSBRRT")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"PMFBITPOAZ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"LZSKLOQPNQ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"RHMPOMWSNG")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"OQJHGGFCNJ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"GMCYYELLWW")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"VZGLYXBMQI")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"YRFNYFRQSY")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ZGFXMEVTVH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"RVQNZAINRJ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"DXFRERNUEZ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"QZTKKLVNJB")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"RIPVAPFZCO")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"QDVHTXVAEJ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"UMGRLGMHMY")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"GXOOZRXYFU")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"IMIPLTLEAA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"JMWSEEISWG")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"OZDICWDQRW")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"YSNADFXEBL")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SZZONHIXUX")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"XUTATNAFCN")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"GSQDROOXIH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"AYOYZWWHED")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ZKDTAIVYNT")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"PGAPCLKWDU")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NMVYSCDEYI")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"IZFSEEEELX")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"RZOPLJQQOD")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"GSZGYDPMMI")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"HKGGYHAADA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"BCOSCDETUR")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"LWFUPEVCFF")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"LMFVWUIXUQ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"EVWGKCMMJY")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"UVHIQLABPT")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"KCGLCUJYUP")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"RQOFXUOOWZ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"OAWXXEHPRA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_ricercamassaBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_A01B))) {
        a = GetCheckVars(status,BO,"TIPXBDXITE");
        b = status.m_CheckVars.optString("TIPXBDXITE");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_A11))) {
        a = GetCheckVars(status,BO,"BQNMQAOIPA");
        b = status.m_CheckVars.optString("BQNMQAOIPA");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_A12A))) {
        a = GetCheckVars(status,BO,"XHIBDWLIOD");
        b = status.m_CheckVars.optString("XHIBDWLIOD");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_A12B))) {
        a = GetCheckVars(status,BO,"IFYLHOXPRS");
        b = status.m_CheckVars.optString("IFYLHOXPRS");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_A24))) {
        a = GetCheckVars(status,BO,"CKACALWZOL");
        b = status.m_CheckVars.optString("CKACALWZOL");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_A25))) {
        a = GetCheckVars(status,BO,"ZIMEUPPLZY");
        b = status.m_CheckVars.optString("ZIMEUPPLZY");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_A31B))) {
        a = GetCheckVars(status,BO,"ZZQPEDWGCO");
        b = status.m_CheckVars.optString("ZZQPEDWGCO");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_A32))) {
        a = GetCheckVars(status,BO,"LTUCQORMSA");
        b = status.m_CheckVars.optString("LTUCQORMSA");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_A33A))) {
        a = GetCheckVars(status,BO,"VDWEKDDBOW");
        b = status.m_CheckVars.optString("VDWEKDDBOW");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_A33B))) {
        a = GetCheckVars(status,BO,"BICDANUWZD");
        b = status.m_CheckVars.optString("BICDANUWZD");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_A41))) {
        a = GetCheckVars(status,BO,"HDIAJDVNVI");
        b = status.m_CheckVars.optString("HDIAJDVNVI");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_A42))) {
        a = GetCheckVars(status,BO,"RQJLOLNIHM");
        b = status.m_CheckVars.optString("RQJLOLNIHM");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_A43))) {
        a = GetCheckVars(status,BO,"CHJJABTJCS");
        b = status.m_CheckVars.optString("CHJJABTJCS");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_A52B))) {
        a = GetCheckVars(status,BO,"DFFBWGMKTL");
        b = status.m_CheckVars.optString("DFFBWGMKTL");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_B12))) {
        a = GetCheckVars(status,BO,"CDFYKKBMYS");
        b = status.m_CheckVars.optString("CDFYKKBMYS");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_C11))) {
        a = GetCheckVars(status,BO,"BZRDFHBMPM");
        b = status.m_CheckVars.optString("BZRDFHBMPM");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_C21))) {
        a = GetCheckVars(status,BO,"UYRQHSBRRT");
        b = status.m_CheckVars.optString("UYRQHSBRRT");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_C31))) {
        a = GetCheckVars(status,BO,"PMFBITPOAZ");
        b = status.m_CheckVars.optString("PMFBITPOAZ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_C41))) {
        a = GetCheckVars(status,BO,"LZSKLOQPNQ");
        b = status.m_CheckVars.optString("LZSKLOQPNQ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_C51))) {
        a = GetCheckVars(status,BO,"RHMPOMWSNG");
        b = status.m_CheckVars.optString("RHMPOMWSNG");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_D11))) {
        a = GetCheckVars(status,BO,"OQJHGGFCNJ");
        b = status.m_CheckVars.optString("OQJHGGFCNJ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_D13))) {
        a = GetCheckVars(status,BO,"GMCYYELLWW");
        b = status.m_CheckVars.optString("GMCYYELLWW");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_D14A))) {
        a = GetCheckVars(status,BO,"VZGLYXBMQI");
        b = status.m_CheckVars.optString("VZGLYXBMQI");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_D14B))) {
        a = GetCheckVars(status,BO,"YRFNYFRQSY");
        b = status.m_CheckVars.optString("YRFNYFRQSY");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_D19A))) {
        a = GetCheckVars(status,BO,"ZGFXMEVTVH");
        b = status.m_CheckVars.optString("ZGFXMEVTVH");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_D19B))) {
        a = GetCheckVars(status,BO,"RVQNZAINRJ");
        b = status.m_CheckVars.optString("RVQNZAINRJ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_D21))) {
        a = GetCheckVars(status,BO,"DXFRERNUEZ");
        b = status.m_CheckVars.optString("DXFRERNUEZ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_D22))) {
        a = GetCheckVars(status,BO,"QZTKKLVNJB");
        b = status.m_CheckVars.optString("QZTKKLVNJB");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_D23))) {
        a = GetCheckVars(status,BO,"RIPVAPFZCO");
        b = status.m_CheckVars.optString("RIPVAPFZCO");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_D41))) {
        a = GetCheckVars(status,BO,"QDVHTXVAEJ");
        b = status.m_CheckVars.optString("QDVHTXVAEJ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_E11))) {
        a = GetCheckVars(status,BO,"UMGRLGMHMY");
        b = status.m_CheckVars.optString("UMGRLGMHMY");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_E13))) {
        a = GetCheckVars(status,BO,"GXOOZRXYFU");
        b = status.m_CheckVars.optString("GXOOZRXYFU");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_E14A))) {
        a = GetCheckVars(status,BO,"IMIPLTLEAA");
        b = status.m_CheckVars.optString("IMIPLTLEAA");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_E14B))) {
        a = GetCheckVars(status,BO,"JMWSEEISWG");
        b = status.m_CheckVars.optString("JMWSEEISWG");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_E19A))) {
        a = GetCheckVars(status,BO,"OZDICWDQRW");
        b = status.m_CheckVars.optString("OZDICWDQRW");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_E19B))) {
        a = GetCheckVars(status,BO,"YSNADFXEBL");
        b = status.m_CheckVars.optString("YSNADFXEBL");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_E41))) {
        a = GetCheckVars(status,BO,"SZZONHIXUX");
        b = status.m_CheckVars.optString("SZZONHIXUX");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_F11))) {
        a = GetCheckVars(status,BO,"XUTATNAFCN");
        b = status.m_CheckVars.optString("XUTATNAFCN");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_F13))) {
        a = GetCheckVars(status,BO,"GSQDROOXIH");
        b = status.m_CheckVars.optString("GSQDROOXIH");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_F14A))) {
        a = GetCheckVars(status,BO,"AYOYZWWHED");
        b = status.m_CheckVars.optString("AYOYZWWHED");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_F14B))) {
        a = GetCheckVars(status,BO,"ZKDTAIVYNT");
        b = status.m_CheckVars.optString("ZKDTAIVYNT");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_G11))) {
        a = GetCheckVars(status,BO,"PGAPCLKWDU");
        b = status.m_CheckVars.optString("PGAPCLKWDU");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_G13))) {
        a = GetCheckVars(status,BO,"NMVYSCDEYI");
        b = status.m_CheckVars.optString("NMVYSCDEYI");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_G14A))) {
        a = GetCheckVars(status,BO,"IZFSEEEELX");
        b = status.m_CheckVars.optString("IZFSEEEELX");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_G14B))) {
        a = GetCheckVars(status,BO,"RZOPLJQQOD");
        b = status.m_CheckVars.optString("RZOPLJQQOD");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_G19A))) {
        a = GetCheckVars(status,BO,"GSZGYDPMMI");
        b = status.m_CheckVars.optString("GSZGYDPMMI");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_G19B))) {
        a = GetCheckVars(status,BO,"HKGGYHAADA");
        b = status.m_CheckVars.optString("HKGGYHAADA");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_G41))) {
        a = GetCheckVars(status,BO,"BCOSCDETUR");
        b = status.m_CheckVars.optString("BCOSCDETUR");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_H11))) {
        a = GetCheckVars(status,BO,"LWFUPEVCFF");
        b = status.m_CheckVars.optString("LWFUPEVCFF");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_H13))) {
        a = GetCheckVars(status,BO,"LMFVWUIXUQ");
        b = status.m_CheckVars.optString("LMFVWUIXUQ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_H14A))) {
        a = GetCheckVars(status,BO,"EVWGKCMMJY");
        b = status.m_CheckVars.optString("EVWGKCMMJY");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_H14B))) {
        a = GetCheckVars(status,BO,"UVHIQLABPT");
        b = status.m_CheckVars.optString("UVHIQLABPT");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_H19A))) {
        a = GetCheckVars(status,BO,"KCGLCUJYUP");
        b = status.m_CheckVars.optString("KCGLCUJYUP");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_H19B))) {
        a = GetCheckVars(status,BO,"RQOFXUOOWZ");
        b = status.m_CheckVars.optString("RQOFXUOOWZ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_H41))) {
        a = GetCheckVars(status,BO,"OAWXXEHPRA");
        b = status.m_CheckVars.optString("OAWXXEHPRA");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
