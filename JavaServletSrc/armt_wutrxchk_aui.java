import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_wutrxchk_aui extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*d6b85f2e*!";
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
    armt_wutrxchk_auiBO BO;
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
    return "Correzione Errori AUI (Import RTRA)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_wutrxchk_aui";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 804;
    l_eg.m_nEntityHeight = 536;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.m_cZoomConfigName = "rtra_aui";
    l_eg.zoomableTables = new String[]{"wutrxchk","anadip","tbmacage"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","Dati Transazione","page"),new ZoneItem("page_2","Errori 01-25","page"),new ZoneItem("page_3","Errori 26-50","page")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"TRXCODPRG"};
    l_eg.items = new SPItem[]{
                   new SPItem("TRXCODPRG","N",15,0, "show","ID Transazione"),
                   new SPItem("TRSSEGNO","C",1,0, "edit","Segno (A=Send,D=Receive)"),
                   new SPItem("TRXIMPORTO","N",15,2, "edit","Importo"),
                   new SPItem("TRXCONTAN","N",15,2, "edit","Contante"),
                   new SPItem("TRXUNIQUE","C",10,0, "edit","Unique ID"),
                   new SPItem("TRXCODDIP","C",10,0, "edit","Codice Agenzia"),
                   new SPItem("TRXCOGCON","C",100,0, "edit","Cognome Controparte"),
                   new SPItem("TRXNOMCON","C",100,0, "edit","Nome Controparte"),
                   new SPItem("TRXDESTIN","C",100,0, "edit","Stato Controparte"),
                   new SPItem("TRXMTCN","C",10,0, "edit","MTCN Operazione"),
                   new SPItem("TRXCODCAS","C",4,0, "edit","Codice Catastale"),
                   new SPItem("TRXRECTYPE","C",1,0, "edit","Tipo Record"),
                   new SPItem("TRXCODMAG","C",5,0, "edit","Codice MacroAgente"),
                   new SPItem("TRXCODUNI","C",18,0, "edit","Codice Univoco"),
                   new SPItem("TRXFLGAUI","C",1,0, "edit","OPERAZIONE CORRETTA AUI"),
                   new SPItem("TRXFLGFOR","C",1,0, "edit","FORZATURA INSERIMENTO"),
                   new SPItem("xMADESCRI","C",60,0, "show","Denominazione"),
                   new SPItem("xDESCRIZ","C",30,0, "show","Descrizione"),
                   new SPItem("TRXCOGNOM","C",50,0, "edit","Cognome"),
                   new SPItem("TRXNOME","C",50,0, "edit","Nome"),
                   new SPItem("TRXDOMICI","C",100,0, "edit","Domicilio"),
                   new SPItem("TRXFLGCF","C",1,0, "edit","Flag Codice Fiscale"),
                   new SPItem("TRXCODFIS","C",16,0, "edit","Codice Ficale (reale)"),
                   new SPItem("TRXLUONAS","C",50,0, "edit","Luogo di nascita"),
                   new SPItem("TRXNUMDOC","C",30,0, "edit","Numero Documento"),
                   new SPItem("TRXDATSCA","D",8,0, "edit","Data Scadenza Documento"),
                   new SPItem("TRXDATRIL","D",8,0, "edit","Data Rilascio Documento"),
                   new SPItem("TRXAUTRIL","C",50,0, "edit","Autorità Rilascio Documento"),
                   new SPItem("TRXNAZRES","C",50,0, "edit","Nazione di Residenza"),
                   new SPItem("TRXCITRES","C",50,0, "edit","Città Di residenza"),
                   new SPItem("TRXTIPDOC","C",2,0, "edit","Tipo Documento"),
                   new SPItem("TRXDATNAS","D",8,0, "edit","Data Di Nascita"),
                   new SPItem("TRXDATOPE","D",8,0, "edit","Data Operazione"),
                   new SPItem("TRXSESSO","C",1,0, "edit","Sesso"),
                   new SPItem("doctype","C",2,0, "hide",""),
                   new SPItem("sesso","C",10,0, "hide",""),
                   new SPItem("TRXNASSTATO","C",40,0, "hide","Stato Nascita da Codice Fiscale"),
                   new SPItem("TRXNASCOMUN","C",40,0, "hide","Comune Nascita da Codice Fiscale"),
                   new SPItem("TRXFLGCON","C",1,0, "show","Flag Contanti"),
                   new SPItem("TRXERROR01","C",80,0, "show","Errore 1"),
                   new SPItem("TRXERROR02","C",80,0, "show","Errore 2"),
                   new SPItem("TRXERROR03","C",80,0, "show","Errore 3"),
                   new SPItem("TRXERROR04","C",80,0, "show","Errore 4"),
                   new SPItem("TRXERROR05","C",80,0, "show","Errore 5"),
                   new SPItem("TRXERROR06","C",80,0, "show","Errore 6"),
                   new SPItem("TRXERROR07","C",80,0, "show","Errore 7"),
                   new SPItem("TRXERROR08","C",80,0, "show","Errore 8"),
                   new SPItem("TRXERROR09","C",80,0, "show","Errore 9"),
                   new SPItem("TRXERROR10","C",80,0, "show","Errore 10"),
                   new SPItem("TRXERROR11","C",80,0, "show","Errore 11"),
                   new SPItem("TRXERROR12","C",80,0, "show","Errore 12"),
                   new SPItem("TRXERROR13","C",80,0, "show","Errore 13"),
                   new SPItem("TRXERROR14","C",80,0, "show","Errore 14"),
                   new SPItem("TRXERROR15","C",80,0, "show","Errore 15"),
                   new SPItem("TRXERROR16","C",80,0, "show","Errore 16"),
                   new SPItem("TRXERROR17","C",80,0, "show","Errore 17"),
                   new SPItem("TRXERROR18","C",80,0, "show","Errore 18"),
                   new SPItem("TRXERROR19","C",80,0, "show","Errore 19"),
                   new SPItem("TRXERROR20","C",80,0, "show","Errore 20"),
                   new SPItem("TRXERROR21","C",80,0, "show","Errore 21"),
                   new SPItem("TRXERROR22","C",80,0, "show","Errore 22"),
                   new SPItem("TRXERROR23","C",80,0, "show","Errore 23"),
                   new SPItem("TRXERROR24","C",80,0, "show","Errore 24"),
                   new SPItem("TRXERROR25","C",80,0, "show","Errore 25"),
                   new SPItem("TRXERROR26","C",80,0, "edit","Errore 26"),
                   new SPItem("TRXERROR27","C",80,0, "edit","Errore27"),
                   new SPItem("TRXERROR28","C",80,0, "edit","Errore 28"),
                   new SPItem("TRXERROR29","C",80,0, "edit","Errore 29"),
                   new SPItem("TRXERROR30","C",80,0, "edit","Errore 30"),
                   new SPItem("TRXERROR31","C",80,0, "edit","Errore 31"),
                   new SPItem("TRXERROR32","C",80,0, "edit","Errore 32"),
                   new SPItem("TRXERROR33","C",80,0, "edit","Errore 33"),
                   new SPItem("TRXERROR34","C",80,0, "edit","Errore 34"),
                   new SPItem("TRXERROR35","C",80,0, "edit","Errore 35"),
                   new SPItem("TRXERROR36","C",80,0, "edit","Errore 36"),
                   new SPItem("TRXERROR37","C",80,0, "edit","Errore 37"),
                   new SPItem("TRXERROR38","C",80,0, "edit","Errore 38"),
                   new SPItem("TRXERROR39","C",80,0, "edit","Errore 39"),
                   new SPItem("TRXERROR40","C",80,0, "edit","Errore 40"),
                   new SPItem("TRXERROR41","C",80,0, "edit","Errore 41"),
                   new SPItem("TRXERROR42","C",80,0, "edit","Errore 42"),
                   new SPItem("TRXERROR43","C",80,0, "edit","Errore 43"),
                   new SPItem("TRXERROR44","C",80,0, "edit","Errore 44"),
                   new SPItem("TRXERROR45","C",80,0, "edit","Errore 45"),
                   new SPItem("TRXERROR46","C",80,0, "edit","Errore 46"),
                   new SPItem("TRXERROR47","C",80,0, "edit","Errore 47"),
                   new SPItem("TRXERROR48","C",80,0, "edit","Errore 48"),
                   new SPItem("TRXERROR49","C",80,0, "edit","Errore 49"),
                   new SPItem("TRXERROR50","C",80,0, "edit","Errore 50")
                 };
    l_eg.m_lHasHistorical = false;
    return l_eg;
  }
  ArrayList<org.json.JSONArray> i_sidebarItems = null;
  public org.json.JSONArray getSidebarItems(int p_nPage) {
    if (CPLib.IsNull(i_sidebarItems)) {
      i_sidebarItems = InitializeSidebarItemsArray(3);
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_wutrxchk_auiBO BO) {
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
      i_contextmenu = InitializeContextMenuArray(3);
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
    {"10444154760",p_Context.Translate("Codice Fiscale Reale (Assegnato da AgE)")},
    {"10613332584",p_Context.Translate("Data Rilascio Documento")},
    {"10703188046",p_Context.Translate("Data Di Nascita")},
    {"10759885763",p_Context.Translate("Numero Documento")},
    {"10782899903",p_Context.Translate("Codice Ficale (reale)")},
    {"10884427469",p_Context.Translate("Contante")},
    {"1114794632",p_Context.Translate("Codice MacroAgente")},
    {"11228111751",p_Context.Translate("Unique ID")},
    {"11228314267",p_Context.Translate("Errore 9")},
    {"11283615582",p_Context.Translate("Macro Agenti")},
    {"11304457711",p_Context.Translate("Presenza Importo in contanti")},
    {"11364806308",p_Context.Translate("Stato Nascita da Codice Fiscale")},
    {"11421032054",p_Context.Translate("ID Transazione")},
    {"11429032151",p_Context.Translate("Tipo Documento")},
    {"11446459032",p_Context.Translate("Correzione Operazione Completata")},
    {"11463195291",p_Context.Translate("Errore27")},
    {"11496749723",p_Context.Translate("Errore 8")},
    {"11706569101",p_Context.Translate("Tipo Record")},
    {"11765185179",p_Context.Translate("Errore 7")},
    {"1181574953",p_Context.Translate("Correzione Errori AUI (Import RTRA)")},
    {"1187604837",p_Context.Translate("Errore 2")},
    {"1187604885",p_Context.Translate("Errore 20")},
    {"1187604886",p_Context.Translate("Errore 21")},
    {"1187604887",p_Context.Translate("Errore 22")},
    {"1187604888",p_Context.Translate("Errore 23")},
    {"1187604889",p_Context.Translate("Errore 24")},
    {"1187604890",p_Context.Translate("Errore 25")},
    {"1187604891",p_Context.Translate("Errore 26")},
    {"1187604893",p_Context.Translate("Errore 28")},
    {"1187604894",p_Context.Translate("Errore 29")},
    {"12033620635",p_Context.Translate("Errore 6")},
    {"12056209762",p_Context.Translate("Denominazione")},
    {"12123333988",p_Context.Translate("Luogo di nascita")},
    {"1316049330",p_Context.Translate("Segno (A=Send,D=Receive)")},
    {"1405586570",p_Context.Translate("Flag Contanti")},
    {"1456040293",p_Context.Translate("Errore 3")},
    {"1456040341",p_Context.Translate("Errore 30")},
    {"1456040342",p_Context.Translate("Errore 31")},
    {"1456040343",p_Context.Translate("Errore 32")},
    {"1456040344",p_Context.Translate("Errore 33")},
    {"1456040345",p_Context.Translate("Errore 34")},
    {"1456040346",p_Context.Translate("Errore 35")},
    {"1456040347",p_Context.Translate("Errore 36")},
    {"1456040348",p_Context.Translate("Errore 37")},
    {"1456040349",p_Context.Translate("Errore 38")},
    {"1456040350",p_Context.Translate("Errore 39")},
    {"1563406272",p_Context.Translate("Flag Codice Fiscale")},
    {"1636021524",p_Context.Translate("FORZATURA INSERIMENTO")},
    {"1724475749",p_Context.Translate("Errore 4")},
    {"1724475797",p_Context.Translate("Errore 40")},
    {"1724475798",p_Context.Translate("Errore 41")},
    {"1724475799",p_Context.Translate("Errore 42")},
    {"1724475800",p_Context.Translate("Errore 43")},
    {"1724475801",p_Context.Translate("Errore 44")},
    {"1724475802",p_Context.Translate("Errore 45")},
    {"1724475803",p_Context.Translate("Errore 46")},
    {"1724475804",p_Context.Translate("Errore 47")},
    {"1724475805",p_Context.Translate("Errore 48")},
    {"1724475806",p_Context.Translate("Errore 49")},
    {"1813072817",p_Context.Translate("Agenzie")},
    {"1816546867",p_Context.Translate("Cognome")},
    {"1991862041",p_Context.Translate("Importo")},
    {"1992911205",p_Context.Translate("Errore 5")},
    {"1992911253",p_Context.Translate("Errore 50")},
    {"2115266609",p_Context.Translate("Codice Univoco")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"423990228",p_Context.Translate("Codice Catastale")},
    {"443454",p_Context.Translate("Nome")},
    {"468328536",p_Context.Translate("Forzatura inserimento dati")},
    {"485943447",p_Context.Translate("Nazione di Residenza")},
    {"49939619",p_Context.Translate("Domicilio")},
    {"517946066",p_Context.Translate("Nome Controparte")},
    {"580410781",p_Context.Translate("Città Di residenza")},
    {"628384699",p_Context.Translate("Data Scadenza Documento")},
    {"7776675",p_Context.Translate("Sesso")},
    {"829110543",p_Context.Translate("MTCN Operazione")},
    {"829201110",p_Context.Translate("Data Operazione")},
    {"887948673",p_Context.Translate("OPERAZIONE CORRETTA AUI")},
    {"919169381",p_Context.Translate("Errore 1")},
    {"919169429",p_Context.Translate("Errore 10")},
    {"919169430",p_Context.Translate("Errore 11")},
    {"919169431",p_Context.Translate("Errore 12")},
    {"919169432",p_Context.Translate("Errore 13")},
    {"919169433",p_Context.Translate("Errore 14")},
    {"919169434",p_Context.Translate("Errore 15")},
    {"919169435",p_Context.Translate("Errore 16")},
    {"919169436",p_Context.Translate("Errore 17")},
    {"919169437",p_Context.Translate("Errore 18")},
    {"919169438",p_Context.Translate("Errore 19")},
    {"979125998",p_Context.Translate("Autorità Rilascio Documento")}};
    return l_translations;
  }
  void WriteStyles(armt_wutrxchk_auiBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_wutrxchk_aui.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_wutrxchk_auiBO BO,ServletStatus status) {
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
    status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati Transazione"),"C",0,0)+"},{name:\"page_2\", element:\"page_2\", caption:"+SPLib.ToJSValue(status.context.Translate("Errori 01-25"),"C",0,0)+"},{name:\"page_3\", element:\"page_3\", caption:"+SPLib.ToJSValue(status.context.Translate("Errori 26-50"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
    status.out.println("Z.Tabs.Set('tabs',tabs);");
    status.out.println("} else {");
    status.out.println("var tabs = Z.Tabs.Get('tabs')");
    status.out.println("}");
    AddExtendedTabs(status);
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_wutrxchk_aui',false);");
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_wutrxchk_aui",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(armt_wutrxchk_auiBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    WriteControls_p2(BO,status);
    WriteControls_p3(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,4);
  }
  void WriteControls_p1(armt_wutrxchk_auiBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:536px;width:804px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"Dati Transazione");
    PrintSidebarContent(1,status,getSidebarItems(0),false);
    PrintContextMenu(1,status,getContextMenu(0),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2(armt_wutrxchk_auiBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_2' class='PageContainer' style='position:relative;height:586px;width:804px;display:none'>" +
    "");
    WriteControls_p2_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,2,"Errori 01-25");
    PrintSidebarContent(2,status,getSidebarItems(1),false);
    PrintContextMenu(2,status,getContextMenu(1),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3(armt_wutrxchk_auiBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_3' class='PageContainer' style='position:relative;height:587px;width:804px;display:none'>" +
    "");
    WriteControls_p3_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,3,"Errori 26-50");
    PrintSidebarContent(3,status,getSidebarItems(2),false);
    PrintContextMenu(3,status,getContextMenu(2),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b0(armt_wutrxchk_auiBO BO,ServletStatus status) {
    status.out.println(
     "<div style='position:relative;height:536px'>" +
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
     "<select name='TRSSEGNO' id='EPEPXVTDDF' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("A","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("A",CPLib.Trim(BO.w_TRSSEGNO))?"SELECTED":"")+">" +
     ""+status.context.Translate("Send")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("D","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("D",CPLib.Trim(BO.w_TRSSEGNO))?"SELECTED":"")+">" +
     ""+status.context.Translate("Receive")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('EPEPXVTDDF'),w_TRSSEGNO,'C');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HAJXBCFZUB_DIV'>" +
     "<label id='HAJXBCFZUB' for='EPEPXVTDDF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Segno (A=Send,D=Receive):"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXIMPORTO' id='FNVGSTOZTQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXIMPORTO,"N",15,2,"999999999999.99", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='18' size='15' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TYFYRRXXWC_DIV'>" +
     "<label id='TYFYRRXXWC' for='FNVGSTOZTQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Importo:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXCONTAN' id='EVKHOJDUVF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXCONTAN,"N",15,2,"999999999999.99", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='18' size='15' fieldtype='N'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='AIMDTEHGSW_DIV'>" +
     "<label id='AIMDTEHGSW' for='EVKHOJDUVF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Contante:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXUNIQUE' id='FCRFUHHVHU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXUNIQUE,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='10' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ULSRWVYTMU_DIV'>" +
     "<label id='ULSRWVYTMU' for='FCRFUHHVHU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Unique ID:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXCODDIP' id='HZPBCLSNRS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXCODDIP,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='10' fieldtype='C'>" +
     "<button id='HZPBCLSNRS_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "HZPBCLSNRS", "anadip", "", "")+"" +
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
     "<input name='TRXCOGCON' id='LGVQVJPZZP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXCOGCON,"C",100,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='100' size='100' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZUININVXNT_DIV'>" +
     "<label id='ZUININVXNT' for='LGVQVJPZZP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cognome Controparte:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXNOMCON' id='OKKVRBSRDN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXNOMCON,"C",100,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='100' size='100' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DSHVDLPTCM_DIV'>" +
     "<label id='DSHVDLPTCM' for='OKKVRBSRDN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nome Controparte:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXDESTIN' id='FDXEUOOSVN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXDESTIN,"C",100,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='100' size='100' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZVELAFATZL_DIV'>" +
     "<label id='ZVELAFATZL' for='FDXEUOOSVN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato Controparte:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXMTCN' id='YZULLMXBBH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXMTCN,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='10' fieldtype='C'>" +
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
     "<input name='TRXCODCAS' id='UTGSXNXPVT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXCODCAS,"C",4,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='4' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MEUEEEUOXT_DIV'>" +
     "<label id='MEUEEEUOXT' for='UTGSXNXPVT'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Catastale:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='TRXRECTYPE' id='FMRUIANURB' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
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
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXCODMAG' id='UTFQIBBLAF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXCODMAG,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
     "<button id='UTFQIBBLAF_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "UTFQIBBLAF", "tbmacage", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VIWNSSMTML_DIV'>" +
     "<label id='VIWNSSMTML' for='UTFQIBBLAF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice MacroAgente:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXCODUNI' id='NSNBJQWLKR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXCODUNI,"C",18,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='18' size='18' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XIUAHOQEHG_DIV'>" +
     "<label id='XIUAHOQEHG' for='NSNBJQWLKR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Univoco:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='TZHYQAUMDE_DIV'>" +
     "<input name='TRXFLGAUI' id='TZHYQAUMDE' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_TRXFLGAUI,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_TRXFLGAUI))?"CHECKED":"")+">" +
     "<label id='TZHYQAUMDE_LBL' for='TZHYQAUMDE' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Correzione Operazione Completata"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='CMGWBYDKHQ_DIV'>" +
     "<input name='TRXFLGFOR' id='CMGWBYDKHQ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_TRXFLGFOR,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_TRXFLGFOR))?"CHECKED":"")+">" +
     "<label id='CMGWBYDKHQ_LBL' for='CMGWBYDKHQ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Forzatura inserimento dati"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='xMADESCRI' id='YUKRVYFISB' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_xMADESCRI,"C",60,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='60' size='60' fieldtype='C'>" +
    "");
    status.out.println(
     "<input name='xDESCRIZ' id='PXDVUJVPPR' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_xDESCRIZ,"C",30,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='30' size='30' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXCOGNOM' id='QKFJKVYCVD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXCOGNOM,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XUZGKKXQHI_DIV'>" +
     "<label id='XUZGKKXQHI' for='QKFJKVYCVD'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cognome:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXNOME' id='OUUNVPTKEC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXNOME,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PDDGGZFWWD_DIV'>" +
     "<label id='PDDGGZFWWD' for='OUUNVPTKEC'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nome:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXDOMICI' id='APRONFZYCV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXDOMICI,"C",100,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='100' size='100' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IULBWAOCZM_DIV'>" +
     "<label id='IULBWAOCZM' for='APRONFZYCV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Domicilio:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='ASIYKLXBCD_DIV'>" +
     "<input name='TRXFLGCF' id='ASIYKLXBCD' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_TRXFLGCF,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_TRXFLGCF))?"CHECKED":"")+">" +
     "<label id='ASIYKLXBCD_LBL' for='ASIYKLXBCD' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale Reale (Assegnato da AgE)"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TQNQMPMBTY_DIV'>" +
     "<label id='TQNQMPMBTY' for='ASIYKLXBCD'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Flag Codice Fiscale:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXCODFIS' id='FVJVEJQIYB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXCODFIS,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RPYTXEJOAU_DIV'>" +
     "<label id='RPYTXEJOAU' for='FVJVEJQIYB'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Ficale (reale):"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXLUONAS' id='OTJSTXXVID' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXLUONAS,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YWGMEJQDVN_DIV'>" +
     "<label id='YWGMEJQDVN' for='OTJSTXXVID'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Luogo di nascita:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXNUMDOC' id='MMSPBVULRO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXNUMDOC,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XSWCEEGDZN_DIV'>" +
     "<label id='XSWCEEGDZN' for='MMSPBVULRO'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Numero Documento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXDATSCA' id='IFKUOAHUHG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXDATSCA,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
     "<button id='IFKUOAHUHG_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UUAVAMYOIT_DIV'>" +
     "<label id='UUAVAMYOIT' for='IFKUOAHUHG'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Scadenza Documento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXDATRIL' id='DRQDHBWECQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXDATRIL,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
     "<button id='DRQDHBWECQ_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='GFCZJPFQSD_DIV'>" +
     "<label id='GFCZJPFQSD' for='DRQDHBWECQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Rilascio Documento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXAUTRIL' id='KUJLLGUFUU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXAUTRIL,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UDUZNUWZVD_DIV'>" +
     "<label id='UDUZNUWZVD' for='KUJLLGUFUU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Autorità Rilascio Documento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXNAZRES' id='SOTHCYQHKP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXNAZRES,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ISWVVEAGKR_DIV'>" +
     "<label id='ISWVVEAGKR' for='SOTHCYQHKP'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nazione di Residenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXCITRES' id='ZDOEFBYPYC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXCITRES,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KSYOWUXVPF_DIV'>" +
     "<label id='KSYOWUXVPF' for='ZDOEFBYPYC'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Città Di residenza:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<select name='TRXTIPDOC' id='ZCRTCXLUUY' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("A","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("A",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("A - Passaporto")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("B","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("B",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("B - Carta d'Identità")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("C","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("C",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("C - Patente di Guida")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("D","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("D",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("D - Permesso di Soggiorno")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("E","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("E",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("E - Altro")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("F","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("F",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("F - Carta d'Identità Comunità Europea")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("G","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("G",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("G - Patente Nautica (UE) o G - Titolo di viaggio per Apolidi")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("H","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("H",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("H - Patente Nautica / Libretto di Navigazione")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("I","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("I",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("I - Porto d'Armi (UE)")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("J","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("J",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("J - Tessera Riconoscimento Amministrazione dello Stato (UE)")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("K","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("K",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("K- Permesso di Soggiorno per soggiornanti comunitari di lungo periodo (UE)")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("L","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("L",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("L - Titolo di viaggio per stranieri rilasciato dalla Questura (UE)")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("M","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("M",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("M - Titolo di viaggio per apolidi (UE)")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("N","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("N",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("N - Documento di viaggio per rifugiati (UE)")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("O","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("O",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("O - Certificato di cittadinanza (UE)")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("P","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("P",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("P - Libretto di navigazione (UE)")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("Q","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("Q",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("Q - Documento di viaggio per rifugiati")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("R","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("R",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("R - Tessera Riconoscimento Amministrazione dello Stato")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("T","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("T",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("T - Passaporto Diplomatico")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("U","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("U",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("U - Titolo di viaggio per stranieri rilasciato dalla Questura")+"" +
     "</option>" +
     "<option value="+SPLib.ToHTMLValue("V","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("V",CPLib.Trim(BO.w_TRXTIPDOC))?"SELECTED":"")+">" +
     ""+status.context.Translate("Porto D'armi")+"" +
     "</option>" +
     "</select>" +
     "<script type='text/javascript'>" +
     "selectCombo(Ctrl('ZCRTCXLUUY'),w_TRXTIPDOC,'C');" +
     "</script>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KUKWNMYGCS_DIV'>" +
     "<label id='KUKWNMYGCS' for='ZCRTCXLUUY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Documento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXDATNAS' id='BYTTMKVPJF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXDATNAS,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXDATOPE' id='VUPAGTECJJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXDATOPE,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
     "<button id='VUPAGTECJJ_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
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
     "</div>" +
    "");
  }
  void WriteControls_p2_b0(armt_wutrxchk_auiBO BO,ServletStatus status) {
    status.out.println(
     "<div style='position:relative;height:586px'>" +
    "");
    status.out.println(
     "<input name='TRXERROR01' id='UCHSJHQNIV' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR01,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YJDTDBJKTF_DIV'>" +
     "<label id='YJDTDBJKTF' for='UCHSJHQNIV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 1:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR02' id='GKZAXYVJEW' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR02,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='AVIHMGJWGN_DIV'>" +
     "<label id='AVIHMGJWGN' for='GKZAXYVJEW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 2:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR03' id='SYKQVOROAS' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR03,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LQOWVNXSZZ_DIV'>" +
     "<label id='LQOWVNXSZZ' for='SYKQVOROAS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 3:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR04' id='WXHVIATWKM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR04,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ZEQMJDTKJK_DIV'>" +
     "<label id='ZEQMJDTKJK' for='WXHVIATWKM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 4:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR05' id='YCDTVJJIMR' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR05,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QOKDINZBUM_DIV'>" +
     "<label id='QOKDINZBUM' for='YCDTVJJIMR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 5:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR06' id='BACNEOKNNG' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR06,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MSZJRHNIOJ_DIV'>" +
     "<label id='MSZJRHNIOJ' for='BACNEOKNNG'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 6:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR07' id='RVIBIVADUM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR07,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YCUADRGOUT_DIV'>" +
     "<label id='YCUADRGOUT' for='RVIBIVADUM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 7:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR08' id='XOBPJRQPBZ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR08,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SHKIUHYTBK_DIV'>" +
     "<label id='SHKIUHYTBK' for='XOBPJRQPBZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 8:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR09' id='RFAJDLABHK' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR09,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ODLCWVHXIM_DIV'>" +
     "<label id='ODLCWVHXIM' for='RFAJDLABHK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 9:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR10' id='LNJHQTAPKH' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR10,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IXLENOMJOT_DIV'>" +
     "<label id='IXLENOMJOT' for='LNJHQTAPKH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 10:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR11' id='BXBAWWFZDV' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR11,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MGTUFSHMTT_DIV'>" +
     "<label id='MGTUFSHMTT' for='BXBAWWFZDV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 11:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR12' id='GLAQECICHA' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR12,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JGYZCBGDLT_DIV'>" +
     "<label id='JGYZCBGDLT' for='GLAQECICHA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 12:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR13' id='KLEBFCDCIF' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR13,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MDPKUXQMTX_DIV'>" +
     "<label id='MDPKUXQMTX' for='KLEBFCDCIF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 13:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR14' id='WXIZZGFGYV' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR14,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IMVSNIGMHD_DIV'>" +
     "<label id='IMVSNIGMHD' for='WXIZZGFGYV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 14:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR15' id='VDAZXJXDXY' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR15,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='TJJMOKWTNI_DIV'>" +
     "<label id='TJJMOKWTNI' for='VDAZXJXDXY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 15:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR16' id='JANNSGSWGM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR16,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CVAGINOCMP_DIV'>" +
     "<label id='CVAGINOCMP' for='JANNSGSWGM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 16:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR17' id='HUIFQLIZHZ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR17,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JPTDZENLJK_DIV'>" +
     "<label id='JPTDZENLJK' for='HUIFQLIZHZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 17:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR18' id='YPMKIOATIZ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR18,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='OKMDAUUJFH_DIV'>" +
     "<label id='OKMDAUUJFH' for='YPMKIOATIZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 18:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR19' id='KGAEUMDODK' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR19,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QCKHWGMETR_DIV'>" +
     "<label id='QCKHWGMETR' for='KGAEUMDODK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 19:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR20' id='VGBNUNWCXY' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR20,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PLWWFSRYAI_DIV'>" +
     "<label id='PLWWFSRYAI' for='VGBNUNWCXY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 20:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR21' id='DLAKPEHAYJ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR21,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='GVUUSALGNA_DIV'>" +
     "<label id='GVUUSALGNA' for='DLAKPEHAYJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 21:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR22' id='JEDPFHJRZS' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR22,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NOXWNOVPAD_DIV'>" +
     "<label id='NOXWNOVPAD' for='JEDPFHJRZS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 22:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR23' id='BMIRKKOHKR' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR23,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CDOOHIIAPB_DIV'>" +
     "<label id='CDOOHIIAPB' for='BMIRKKOHKR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 23:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR24' id='OHTYWCOOIK' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR24,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MWDMUSJEML_DIV'>" +
     "<label id='MWDMUSJEML' for='OHTYWCOOIK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 24:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='TRXERROR25' id='LAAPMSXDPL' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TRXERROR25,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VBPHKZYIIK_DIV'>" +
     "<label id='VBPHKZYIIK' for='LAAPMSXDPL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 25:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b0(armt_wutrxchk_auiBO BO,ServletStatus status) {
    status.out.println(
     "<div style='position:relative;height:587px'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR26' id='ASSPEANDMC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR26,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='HNLLPVTPEP_DIV'>" +
     "<label id='HNLLPVTPEP' for='ASSPEANDMC'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 26:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR27' id='FMOIMQZAPG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR27,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='AWLZZLJZMV_DIV'>" +
     "<label id='AWLZZLJZMV' for='FMOIMQZAPG'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 27:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR28' id='RKGHXZFQZL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR28,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='REHSVTTQZW_DIV'>" +
     "<label id='REHSVTTQZW' for='RKGHXZFQZL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 28:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR29' id='HEPMULJALS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR29,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QWSQQWGKJA_DIV'>" +
     "<label id='QWSQQWGKJA' for='HEPMULJALS'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 29:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR30' id='DYBWDBXZIJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR30,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RYCQAUVBFN_DIV'>" +
     "<label id='RYCQAUVBFN' for='DYBWDBXZIJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 30:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR31' id='LISOLVFJNF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR31,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XYZFJXNCXY_DIV'>" +
     "<label id='XYZFJXNCXY' for='LISOLVFJNF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 31:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR32' id='BHISKUARAJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR32,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KPITEKYSGW_DIV'>" +
     "<label id='KPITEKYSGW' for='BHISKUARAJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 32:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR33' id='MSSBSWBLKI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR33,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YQMAZGPJAS_DIV'>" +
     "<label id='YQMAZGPJAS' for='MSSBSWBLKI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 33:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR34' id='ATBSEHTJHH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR34,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='AGCPTXWUDW_DIV'>" +
     "<label id='AGCPTXWUDW' for='ATBSEHTJHH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 34:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR35' id='CIFSRVZLSK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR35,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='EUBHVZLAKQ_DIV'>" +
     "<label id='EUBHVZLAKQ' for='CIFSRVZLSK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 35:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR36' id='FCOYAJZYOF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR36,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YBMQFVMVNK_DIV'>" +
     "<label id='YBMQFVMVNK' for='FCOYAJZYOF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 36:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR37' id='ZNHTQWPUYJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR37,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YUAOFCOOFT_DIV'>" +
     "<label id='YUAOFCOOFT' for='ZNHTQWPUYJ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 37:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR38' id='ULYZEYIIYY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR38,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='APRWZHGLUI_DIV'>" +
     "<label id='APRWZHGLUI' for='ULYZEYIIYY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 38:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR39' id='ZRCBZVUWZE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR39,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VTTPEXBMTN_DIV'>" +
     "<label id='VTTPEXBMTN' for='ZRCBZVUWZE'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 39:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR40' id='TCMPTOYHZU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR40,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CAQYVLVNUV_DIV'>" +
     "<label id='CAQYVLVNUV' for='TCMPTOYHZU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 40:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR41' id='DYIXHFFDPL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR41,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YCPYSNRJCS_DIV'>" +
     "<label id='YCPYSNRJCS' for='DYIXHFFDPL'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 41:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR42' id='OZIAVQGVQX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR42,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KCOBOXNFOZ_DIV'>" +
     "<label id='KCOBOXNFOZ' for='OZIAVQGVQX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 42:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR43' id='QURNMKDXBF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR43,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XVDSGNYPCO_DIV'>" +
     "<label id='XVDSGNYPCO' for='QURNMKDXBF'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 43:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR44' id='MNXGCWMDZI' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR44,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='GEHQBAIYSA_DIV'>" +
     "<label id='GEHQBAIYSA' for='MNXGCWMDZI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 44:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR45' id='YJUYZEFYVU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR45,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RWRUJLOGUJ_DIV'>" +
     "<label id='RWRUJLOGUJ' for='YJUYZEFYVU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 45:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR46' id='ASNHGNRDBH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR46,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QZDQYZMYBD_DIV'>" +
     "<label id='QZDQYZMYBD' for='ASNHGNRDBH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 46:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR47' id='CZSDXMRIYM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR47,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LXCXEBOILM_DIV'>" +
     "<label id='LXCXEBOILM' for='CZSDXMRIYM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 47:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR48' id='XVGSKNYKNU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR48,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='WJGQPYDDSI_DIV'>" +
     "<label id='WJGQPYDDSI' for='XVGSKNYKNU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 48:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR49' id='BBGXFOFUHV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR49,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YNBUPEMGKR_DIV'>" +
     "<label id='YNBUPEMGKR' for='BBGXFOFUHV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 49:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='TRXERROR50' id='VKWSDIQTXK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TRXERROR50,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NDQGRTJVYG_DIV'>" +
     "<label id='NDQGRTJVYG' for='VKWSDIQTXK'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Errore 50:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  static void PrintState(armt_wutrxchk_auiBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_wutrxchk_auiBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
  }
  static void PrintStateWorkVars(armt_wutrxchk_auiBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_TRXCODPRG,"N",15,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_TRXCODPRG:BO.w_TRXCODPRG,"N",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRSSEGNO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXIMPORTO,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXCONTAN,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXUNIQUE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXCODDIP,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXCOGCON,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXNOMCON,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXDESTIN,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXMTCN,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXCODCAS,"C",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXRECTYPE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXCODMAG,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXCODUNI,"C",18,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXFLGAUI,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXFLGFOR,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR01,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR02,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR03,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR04,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR05,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR06,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR07,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR08,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR09,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR10,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR11,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR12,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR13,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR14,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR15,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR16,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR17,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR18,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR19,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR20,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR21,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR22,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR23,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR24,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR25,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR26,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR27,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR28,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR29,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR30,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR31,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR32,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR33,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR34,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR35,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR36,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR37,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR38,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR39,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR40,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR41,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR42,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR43,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR44,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR45,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR46,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR47,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR48,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR49,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXERROR50,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXCOGNOM,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXNOME,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXDOMICI,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXFLGCF,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXCODFIS,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXLUONAS,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXNUMDOC,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXDATSCA,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXDATRIL,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXAUTRIL,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXNAZRES,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXCITRES,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXTIPDOC,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXDATNAS,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXDATOPE,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXSESSO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXNASSTATO,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXNASCOMUN,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TRXFLGCON,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xMADESCRI,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDESCRIZ,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_doctype,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_sesso,"C",10,0));
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_wutrxchk_auiBO BO,ServletStatus status) {
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(536,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(804,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_wutrxchk_aui"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'HZPBCLSNRS':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"HZPBCLSNRS",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'UTFQIBBLAF':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"UTFQIBBLAF",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbmacage,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'HZPBCLSNRS':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'UTFQIBBLAF':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbmacage,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_wutrxchk_aui","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_wutrxchk_aui",BO.GetCurrentState());
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
  void WriteMainFormScript(armt_wutrxchk_auiBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_wutrxchk_aui',false);");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('EPEPXVTDDF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FNVGSTOZTQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EVKHOJDUVF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FCRFUHHVHU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HZPBCLSNRS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HZPBCLSNRS_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LGVQVJPZZP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OKKVRBSRDN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FDXEUOOSVN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YZULLMXBBH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UTGSXNXPVT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FMRUIANURB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UTFQIBBLAF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UTFQIBBLAF_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NSNBJQWLKR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TZHYQAUMDE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CMGWBYDKHQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QKFJKVYCVD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OUUNVPTKEC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('APRONFZYCV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ASIYKLXBCD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FVJVEJQIYB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OTJSTXXVID')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MMSPBVULRO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IFKUOAHUHG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IFKUOAHUHG_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DRQDHBWECQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DRQDHBWECQ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KUJLLGUFUU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SOTHCYQHKP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZDOEFBYPYC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZCRTCXLUUY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BYTTMKVPJF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VUPAGTECJJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VUPAGTECJJ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ATGEKSLXET')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ASSPEANDMC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FMOIMQZAPG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RKGHXZFQZL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HEPMULJALS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DYBWDBXZIJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LISOLVFJNF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BHISKUARAJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MSSBSWBLKI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ATBSEHTJHH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CIFSRVZLSK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FCOYAJZYOF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZNHTQWPUYJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ULYZEYIIYY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZRCBZVUWZE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TCMPTOYHZU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DYIXHFFDPL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OZIAVQGVQX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QURNMKDXBF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MNXGCWMDZI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YJUYZEFYVU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ASNHGNRDBH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CZSDXMRIYM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XVGSKNYKNU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BBGXFOFUHV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VKWSDIQTXK')) SetDisabled(c,true);");
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
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  armt_wutrxchk_auiBO getBO(ServletStatus status) {
    armt_wutrxchk_auiBO BO = new armt_wutrxchk_auiBO(status.context);
    // gli op_ possono essere utilizzati dalla servlet anche prima di essere inizializzati
    BO.op_TRXCODPRG = BO.w_TRXCODPRG;
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_wutrxchk_auiBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("wutrxchk",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_wutrxchk_auiBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_wutrxchk_auiBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
  }
  CPResultSet QueryKeyCursor(armt_wutrxchk_auiBO BO,ServletStatus status) {
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
      String l_cQueryFilter = armt_wutrxchk_auiBL.QueryFilter(status.context);
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
  void Query(ServletStatus status,armt_wutrxchk_auiBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_wutrxchk_auiBL.QueryFilter(status.context);
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
  void View(ServletStatus status,armt_wutrxchk_auiBO BO) {
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
  void Edit(ServletStatus status,armt_wutrxchk_auiBO BO,SPParameterSource source) {
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
  void New(ServletStatus status,armt_wutrxchk_auiBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_wutrxchk_auiBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_wutrxchk_auiBO BO) {
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
  void EditLoad(ServletStatus status,armt_wutrxchk_auiBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_wutrxchk_auiBO BO,SPParameterSource source) {
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
  void DeleteMessage(ServletStatus status,armt_wutrxchk_auiBO BO,SPParameterSource source) {
    BO.Load(status.w_TRXCODPRG);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_wutrxchk_auiBO BO) {
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
  void Discard(ServletStatus status,armt_wutrxchk_auiBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_wutrxchk_auiBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",536);
    item.put("w",804);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","true");
    org.json.JSONObject pageProp = null;
    org.json.JSONArray pagesProp = null;
    pagesProp = new org.json.JSONArray();
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Dati Transazione\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Errori 01-25\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Errori 26-50\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Dati Transazione,Errori 01-25,Errori 26-50");
    item.put("altInterfaceFor","armt_wutrxchk_aui");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Flag Contanti\",\"disabled\":\"true\",\"h\":21,\"label_text\":\"Presenza Importo in contanti\",\"maxlength\":1,\"name\":\"TRXFLGCON\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"TQMBDRYXLU\",\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":158,\"x\":159,\"y\":278,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HWRRLNPDOJ\",\"page\":1,\"spuid\":\"HWRRLNPDOJ\",\"tabindex\":70,\"type\":\"Label\",\"value\":\"Flag Contanti:\",\"w\":74,\"x\":83,\"y\":283,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Segno (A=Send,D=Receive)\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"TRSSEGNO\",\"page\":1,\"spuid\":\"EPEPXVTDDF\",\"tabindex\":3,\"textlist\":\"Send,Receive\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"A"+"'"+","+"'"+"D"+"'"+"\",\"w\":102,\"x\":159,\"y\":305,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HAJXBCFZUB\",\"page\":1,\"spuid\":\"HAJXBCFZUB\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"Segno (A=Send,D=Receive):\",\"w\":155,\"x\":3,\"y\":309,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Importo\",\"h\":20,\"maxlength\":18,\"name\":\"TRXIMPORTO\",\"page\":1,\"spuid\":\"FNVGSTOZTQ\",\"tabindex\":5,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":400,\"y\":279,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TYFYRRXXWC\",\"page\":1,\"spuid\":\"TYFYRRXXWC\",\"tabindex\":6,\"type\":\"Label\",\"value\":\"Importo:\",\"w\":46,\"x\":353,\"y\":283,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Contante\",\"h\":20,\"maxlength\":18,\"name\":\"TRXCONTAN\",\"page\":1,\"spuid\":\"EVKHOJDUVF\",\"tabindex\":7,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":585,\"y\":279,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AIMDTEHGSW\",\"page\":1,\"spuid\":\"AIMDTEHGSW\",\"tabindex\":8,\"type\":\"Label\",\"value\":\"Contante:\",\"w\":53,\"x\":531,\"y\":283,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Unique ID\",\"h\":20,\"maxlength\":10,\"name\":\"TRXUNIQUE\",\"page\":1,\"spuid\":\"FCRFUHHVHU\",\"tabindex\":9,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":400,\"y\":305,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ULSRWVYTMU\",\"page\":1,\"spuid\":\"ULSRWVYTMU\",\"tabindex\":10,\"type\":\"Label\",\"value\":\"Unique ID:\",\"w\":56,\"x\":343,\"y\":309,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Agenzia\",\"h\":20,\"maxlength\":10,\"name\":\"TRXCODDIP\",\"page\":1,\"picker\":true,\"spuid\":\"HZPBCLSNRS\",\"tabindex\":11,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":83,\"x\":158,\"y\":327,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CKTPLYQSNF\",\"page\":1,\"spuid\":\"CKTPLYQSNF\",\"tabindex\":12,\"type\":\"Label\",\"value\":\"Codice Agenzia:\",\"w\":84,\"x\":73,\"y\":331,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Descrizione\",\"disabled\":\"true\",\"h\":20,\"maxlength\":30,\"name\":\"xDESCRIZ\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"PXDVUJVPPR\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":340,\"x\":268,\"y\":327,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cognome Controparte\",\"h\":20,\"maxlength\":100,\"name\":\"TRXCOGCON\",\"page\":1,\"spuid\":\"LGVQVJPZZP\",\"tabindex\":13,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":158,\"y\":350,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZUININVXNT\",\"page\":1,\"spuid\":\"ZUININVXNT\",\"tabindex\":14,\"type\":\"Label\",\"value\":\"Cognome Controparte:\",\"w\":122,\"x\":35,\"y\":354,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome Controparte\",\"h\":20,\"maxlength\":100,\"name\":\"TRXNOMCON\",\"page\":1,\"spuid\":\"OKKVRBSRDN\",\"tabindex\":15,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":158,\"y\":373,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DSHVDLPTCM\",\"page\":1,\"spuid\":\"DSHVDLPTCM\",\"tabindex\":16,\"type\":\"Label\",\"value\":\"Nome Controparte:\",\"w\":102,\"x\":55,\"y\":377,\"zone\":\"pag1_7\",\"zonepath\":\"[1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Stato Controparte\",\"h\":20,\"maxlength\":100,\"name\":\"TRXDESTIN\",\"page\":1,\"spuid\":\"FDXEUOOSVN\",\"tabindex\":17,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":158,\"y\":396,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZVELAFATZL\",\"page\":1,\"spuid\":\"ZVELAFATZL\",\"tabindex\":18,\"type\":\"Label\",\"value\":\"Stato Controparte:\",\"w\":101,\"x\":56,\"y\":400,\"zone\":\"pag1_8\",\"zonepath\":\"[1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"MTCN Operazione\",\"h\":20,\"maxlength\":10,\"name\":\"TRXMTCN\",\"page\":1,\"spuid\":\"YZULLMXBBH\",\"tabindex\":19,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":464,\"y\":8,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DYDCEKIOPZ\",\"page\":1,\"spuid\":\"DYDCEKIOPZ\",\"tabindex\":20,\"type\":\"Label\",\"value\":\"MTCN Operazione:\",\"w\":99,\"x\":364,\"y\":12,\"zone\":\"pag1_9\",\"zonepath\":\"[1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Catastale\",\"h\":20,\"maxlength\":4,\"name\":\"TRXCODCAS\",\"page\":1,\"spuid\":\"UTGSXNXPVT\",\"tabindex\":21,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":36,\"x\":158,\"y\":419,\"zone\":\"pag1_10\",\"zonepath\":\"[1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MEUEEEUOXT\",\"page\":1,\"spuid\":\"MEUEEEUOXT\",\"tabindex\":22,\"type\":\"Label\",\"value\":\"Codice Catastale:\",\"w\":93,\"x\":64,\"y\":423,\"zone\":\"pag1_10\",\"zonepath\":\"[1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Record\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"TRXRECTYPE\",\"page\":1,\"spuid\":\"FMRUIANURB\",\"tabindex\":23,\"textlist\":\"Nuova Transazione,Rettifica Transazione,Cancellazione Transazione\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"I"+"'"+","+"'"+"M"+"'"+","+"'"+"D"+"'"+"\",\"w\":158,\"x\":158,\"y\":442,\"zone\":\"pag1_11\",\"zonepath\":\"[1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XXKUBGHLZL\",\"page\":1,\"spuid\":\"XXKUBGHLZL\",\"tabindex\":24,\"type\":\"Label\",\"value\":\"Tipo Record:\",\"w\":67,\"x\":90,\"y\":446,\"zone\":\"pag1_11\",\"zonepath\":\"[1,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice MacroAgente\",\"h\":20,\"maxlength\":5,\"name\":\"TRXCODMAG\",\"page\":1,\"picker\":true,\"spuid\":\"UTFQIBBLAF\",\"tabindex\":25,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":55,\"x\":158,\"y\":465,\"zone\":\"pag1_12\",\"zonepath\":\"[1,12]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VIWNSSMTML\",\"page\":1,\"spuid\":\"VIWNSSMTML\",\"tabindex\":26,\"type\":\"Label\",\"value\":\"Codice MacroAgente:\",\"w\":113,\"x\":44,\"y\":469,\"zone\":\"pag1_12\",\"zonepath\":\"[1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Denominazione\",\"disabled\":\"true\",\"h\":20,\"maxlength\":60,\"name\":\"xMADESCRI\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"YUKRVYFISB\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":372,\"x\":241,\"y\":465,\"zone\":\"pag1_12\",\"zonepath\":\"[1,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Univoco\",\"h\":20,\"maxlength\":18,\"name\":\"TRXCODUNI\",\"page\":1,\"spuid\":\"NSNBJQWLKR\",\"tabindex\":27,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":120,\"x\":158,\"y\":488,\"zone\":\"pag1_13\",\"zonepath\":\"[1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XIUAHOQEHG\",\"page\":1,\"spuid\":\"XIUAHOQEHG\",\"tabindex\":28,\"type\":\"Label\",\"value\":\"Codice Univoco:\",\"w\":84,\"x\":73,\"y\":492,\"zone\":\"pag1_13\",\"zonepath\":\"[1,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"OPERAZIONE CORRETTA AUI\",\"h\":21,\"label_text\":\"Correzione Operazione Completata\",\"maxlength\":1,\"name\":\"TRXFLGAUI\",\"page\":1,\"spuid\":\"TZHYQAUMDE\",\"tabindex\":29,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":188,\"x\":159,\"y\":510,\"zone\":\"pag1_14\",\"zonepath\":\"[1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"FORZATURA INSERIMENTO\",\"h\":21,\"label_text\":\"Forzatura inserimento dati\",\"maxlength\":1,\"name\":\"TRXFLGFOR\",\"page\":1,\"spuid\":\"CMGWBYDKHQ\",\"tabindex\":30,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":247,\"x\":370,\"y\":510,\"zone\":\"pag1_14\",\"zonepath\":\"[1,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ID Transazione\",\"disabled\":\"true\",\"h\":20,\"maxlength\":18,\"name\":\"TRXCODPRG\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"LPQRPTUZNB\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":157,\"y\":8,\"zone\":\"pag1_15\",\"zonepath\":\"[1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NESFDLHKJF\",\"page\":1,\"spuid\":\"NESFDLHKJF\",\"tabindex\":2,\"type\":\"Label\",\"value\":\"ID Transazione:\",\"w\":83,\"x\":73,\"y\":12,\"zone\":\"pag1_15\",\"zonepath\":\"[1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cognome\",\"h\":20,\"maxlength\":50,\"name\":\"TRXCOGNOM\",\"page\":1,\"spuid\":\"QKFJKVYCVD\",\"tabindex\":33,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":158,\"y\":30,\"zone\":\"pag1_15\",\"zonepath\":\"[1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XUZGKKXQHI\",\"page\":1,\"spuid\":\"XUZGKKXQHI\",\"tabindex\":34,\"type\":\"Label\",\"value\":\"Cognome:\",\"w\":53,\"x\":104,\"y\":34,\"zone\":\"pag1_15\",\"zonepath\":\"[1,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome\",\"h\":20,\"maxlength\":50,\"name\":\"TRXNOME\",\"page\":1,\"spuid\":\"OUUNVPTKEC\",\"tabindex\":35,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":158,\"y\":53,\"zone\":\"pag1_16\",\"zonepath\":\"[1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PDDGGZFWWD\",\"page\":1,\"spuid\":\"PDDGGZFWWD\",\"tabindex\":36,\"type\":\"Label\",\"value\":\"Nome:\",\"w\":34,\"x\":123,\"y\":57,\"zone\":\"pag1_16\",\"zonepath\":\"[1,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Domicilio\",\"h\":20,\"maxlength\":100,\"name\":\"TRXDOMICI\",\"page\":1,\"spuid\":\"APRONFZYCV\",\"tabindex\":37,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":158,\"y\":76,\"zone\":\"pag1_17\",\"zonepath\":\"[1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IULBWAOCZM\",\"page\":1,\"spuid\":\"IULBWAOCZM\",\"tabindex\":38,\"type\":\"Label\",\"value\":\"Domicilio:\",\"w\":48,\"x\":109,\"y\":80,\"zone\":\"pag1_17\",\"zonepath\":\"[1,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Flag Codice Fiscale\",\"h\":21,\"label_text\":\"Codice Fiscale Reale (Assegnato da AgE)\",\"maxlength\":1,\"name\":\"TRXFLGCF\",\"page\":1,\"spuid\":\"ASIYKLXBCD\",\"tabindex\":39,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":226,\"x\":158,\"y\":98,\"zone\":\"pag1_18\",\"zonepath\":\"[1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TQNQMPMBTY\",\"page\":1,\"spuid\":\"TQNQMPMBTY\",\"tabindex\":40,\"type\":\"Label\",\"value\":\"Flag Codice Fiscale:\",\"w\":103,\"x\":54,\"y\":103,\"zone\":\"pag1_18\",\"zonepath\":\"[1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Ficale (reale)\",\"h\":20,\"maxlength\":16,\"name\":\"TRXCODFIS\",\"page\":1,\"spuid\":\"FVJVEJQIYB\",\"tabindex\":41,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":129,\"x\":503,\"y\":96,\"zone\":\"pag1_18\",\"zonepath\":\"[1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RPYTXEJOAU\",\"page\":1,\"spuid\":\"RPYTXEJOAU\",\"tabindex\":42,\"type\":\"Label\",\"value\":\"Codice Ficale (reale):\",\"w\":111,\"x\":391,\"y\":100,\"zone\":\"pag1_18\",\"zonepath\":\"[1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Sesso\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"TRXSESSO\",\"page\":1,\"spuid\":\"ATGEKSLXET\",\"tabindex\":63,\"textlist\":\"Maschio,Femmina\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"M"+"'"+","+"'"+"F"+"'"+"\",\"w\":86,\"x\":683,\"y\":96,\"zone\":\"pag1_18\",\"zonepath\":\"[1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UWFFZZSTIY\",\"page\":1,\"spuid\":\"UWFFZZSTIY\",\"tabindex\":64,\"type\":\"Label\",\"value\":\"Sesso:\",\"w\":35,\"x\":648,\"y\":100,\"zone\":\"pag1_18\",\"zonepath\":\"[1,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Luogo di nascita\",\"h\":20,\"maxlength\":50,\"name\":\"TRXLUONAS\",\"page\":1,\"spuid\":\"OTJSTXXVID\",\"tabindex\":43,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":158,\"y\":122,\"zone\":\"pag1_19\",\"zonepath\":\"[1,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YWGMEJQDVN\",\"page\":1,\"spuid\":\"YWGMEJQDVN\",\"tabindex\":44,\"type\":\"Label\",\"value\":\"Luogo di nascita:\",\"w\":89,\"x\":68,\"y\":126,\"zone\":\"pag1_19\",\"zonepath\":\"[1,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero Documento\",\"h\":20,\"maxlength\":30,\"name\":\"TRXNUMDOC\",\"page\":1,\"spuid\":\"MMSPBVULRO\",\"tabindex\":45,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":158,\"y\":165,\"zone\":\"pag1_20\",\"zonepath\":\"[1,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XSWCEEGDZN\",\"page\":1,\"spuid\":\"XSWCEEGDZN\",\"tabindex\":46,\"type\":\"Label\",\"value\":\"Numero Documento:\",\"w\":107,\"x\":50,\"y\":169,\"zone\":\"pag1_20\",\"zonepath\":\"[1,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Autorit\\u00E0 Rilascio Documento\",\"h\":20,\"maxlength\":50,\"name\":\"TRXAUTRIL\",\"page\":1,\"spuid\":\"KUJLLGUFUU\",\"tabindex\":51,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":159,\"y\":145,\"zone\":\"pag1_20\",\"zonepath\":\"[1,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UDUZNUWZVD\",\"page\":1,\"spuid\":\"UDUZNUWZVD\",\"tabindex\":52,\"type\":\"Label\",\"value\":\"Autorit\\u00E0 Rilascio Documento:\",\"w\":151,\"x\":7,\"y\":149,\"zone\":\"pag1_20\",\"zonepath\":\"[1,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Scadenza Documento\",\"h\":20,\"maxlength\":10,\"name\":\"TRXDATSCA\",\"page\":1,\"picker\":true,\"spuid\":\"IFKUOAHUHG\",\"tabindex\":47,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":75,\"x\":434,\"y\":187,\"zone\":\"pag1_21\",\"zonepath\":\"[1,21]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UUAVAMYOIT\",\"page\":1,\"spuid\":\"UUAVAMYOIT\",\"tabindex\":48,\"type\":\"Label\",\"value\":\"Data Scadenza Documento:\",\"w\":146,\"x\":287,\"y\":191,\"zone\":\"pag1_21\",\"zonepath\":\"[1,21]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Rilascio Documento\",\"h\":20,\"maxlength\":10,\"name\":\"TRXDATRIL\",\"page\":1,\"picker\":true,\"spuid\":\"DRQDHBWECQ\",\"tabindex\":49,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":71,\"x\":158,\"y\":187,\"zone\":\"pag1_21\",\"zonepath\":\"[1,21]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GFCZJPFQSD\",\"page\":1,\"spuid\":\"GFCZJPFQSD\",\"tabindex\":50,\"type\":\"Label\",\"value\":\"Data Rilascio Documento:\",\"w\":134,\"x\":23,\"y\":191,\"zone\":\"pag1_21\",\"zonepath\":\"[1,21]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nazione di Residenza\",\"h\":20,\"maxlength\":50,\"name\":\"TRXNAZRES\",\"page\":1,\"spuid\":\"SOTHCYQHKP\",\"tabindex\":53,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":158,\"y\":209,\"zone\":\"pag1_22\",\"zonepath\":\"[1,22]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ISWVVEAGKR\",\"page\":1,\"spuid\":\"ISWVVEAGKR\",\"tabindex\":54,\"type\":\"Label\",\"value\":\"Nazione di Residenza:\",\"w\":115,\"x\":42,\"y\":213,\"zone\":\"pag1_22\",\"zonepath\":\"[1,22]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Citt\\u00E0 Di residenza\",\"h\":20,\"maxlength\":50,\"name\":\"TRXCITRES\",\"page\":1,\"spuid\":\"ZDOEFBYPYC\",\"tabindex\":55,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":159,\"y\":231,\"zone\":\"pag1_23\",\"zonepath\":\"[1,23]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KSYOWUXVPF\",\"page\":1,\"spuid\":\"KSYOWUXVPF\",\"tabindex\":56,\"type\":\"Label\",\"value\":\"Citt\\u00E0 Di residenza:\",\"w\":96,\"x\":62,\"y\":235,\"zone\":\"pag1_23\",\"zonepath\":\"[1,23]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Documento\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":2,\"name\":\"TRXTIPDOC\",\"page\":1,\"spuid\":\"ZCRTCXLUUY\",\"tabindex\":57,\"textlist\":\"A - Passaporto,B - Carta d"+"'"+"Identit\\u00E0,C - Patente di Guida,D - Permesso di Soggiorno,E - Altro,F - Carta d"+"'"+"Identit\\u00E0 Comunit\\u00E0 Europea,G - Patente Nautica (UE) o G - Titolo di viaggio per Apolidi,H - Patente Nautica \\/ Libretto di Navigazione,I - Porto d"+"'"+"Armi (UE),J - Tessera Riconoscimento Amministrazione dello Stato (UE),K- Permesso di Soggiorno per soggiornanti comunitari di lungo periodo (UE),L - Titolo di viaggio per stranieri rilasciato dalla Questura (UE),M - Titolo di viaggio per apolidi (UE),N - Documento di viaggio per rifugiati (UE),O - Certificato di cittadinanza (UE),P - Libretto di navigazione (UE),Q - Documento di viaggio per rifugiati,R - Tessera Riconoscimento Amministrazione dello Stato,T - Passaporto Diplomatico,U - Titolo di viaggio per stranieri rilasciato dalla Questura,Porto D"+"'"+"armi\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"A"+"'"+","+"'"+"B"+"'"+","+"'"+"C"+"'"+","+"'"+"D"+"'"+","+"'"+"E"+"'"+","+"'"+"F"+"'"+","+"'"+"G"+"'"+","+"'"+"H"+"'"+","+"'"+"I"+"'"+","+"'"+"J"+"'"+","+"'"+"K"+"'"+","+"'"+"L"+"'"+","+"'"+"M"+"'"+","+"'"+"N"+"'"+","+"'"+"O"+"'"+","+"'"+"P"+"'"+","+"'"+"Q"+"'"+","+"'"+"R"+"'"+","+"'"+"T"+"'"+","+"'"+"U"+"'"+","+"'"+"V"+"'"+"\",\"w\":623,\"x\":159,\"y\":255,\"zone\":\"pag1_24\",\"zonepath\":\"[1,24]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KUKWNMYGCS\",\"page\":1,\"spuid\":\"KUKWNMYGCS\",\"tabindex\":58,\"type\":\"Label\",\"value\":\"Tipo Documento:\",\"w\":89,\"x\":60,\"y\":258,\"zone\":\"pag1_24\",\"zonepath\":\"[1,24]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Di Nascita\",\"h\":20,\"maxlength\":10,\"name\":\"TRXDATNAS\",\"page\":1,\"spuid\":\"BYTTMKVPJF\",\"tabindex\":59,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":78,\"x\":584,\"y\":124,\"zone\":\"pag1_25\",\"zonepath\":\"[1,25]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RWVGLFMUMW\",\"page\":1,\"spuid\":\"RWVGLFMUMW\",\"tabindex\":62,\"type\":\"Label\",\"value\":\"Data Di Nascita:\",\"w\":84,\"x\":500,\"y\":128,\"zone\":\"pag1_25\",\"zonepath\":\"[1,25]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Operazione\",\"h\":20,\"maxlength\":10,\"name\":\"TRXDATOPE\",\"page\":1,\"picker\":true,\"spuid\":\"VUPAGTECJJ\",\"tabindex\":60,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":60,\"x\":721,\"y\":8,\"zone\":\"pag1_26\",\"zonepath\":\"[1,26]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NRJSRMLPEW\",\"page\":1,\"spuid\":\"NRJSRMLPEW\",\"tabindex\":61,\"type\":\"Label\",\"value\":\"Data Operazione:\",\"w\":93,\"x\":627,\"y\":12,\"zone\":\"pag1_26\",\"zonepath\":\"[1,26]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 1\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR01\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"UCHSJHQNIV\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":9,\"zone\":\"pag2_1\",\"zonepath\":\"[2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YJDTDBJKTF\",\"page\":2,\"spuid\":\"YJDTDBJKTF\",\"tabindex\":2,\"type\":\"Label\",\"value\":\"Errore 1:\",\"w\":47,\"x\":19,\"y\":13,\"zone\":\"pag2_1\",\"zonepath\":\"[2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 2\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR02\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"GKZAXYVJEW\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":32,\"zone\":\"pag2_2\",\"zonepath\":\"[2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AVIHMGJWGN\",\"page\":2,\"spuid\":\"AVIHMGJWGN\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"Errore 2:\",\"w\":47,\"x\":19,\"y\":36,\"zone\":\"pag2_2\",\"zonepath\":\"[2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 3\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR03\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"SYKQVOROAS\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":55,\"zone\":\"pag2_3\",\"zonepath\":\"[2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LQOWVNXSZZ\",\"page\":2,\"spuid\":\"LQOWVNXSZZ\",\"tabindex\":6,\"type\":\"Label\",\"value\":\"Errore 3:\",\"w\":47,\"x\":19,\"y\":59,\"zone\":\"pag2_3\",\"zonepath\":\"[2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 4\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR04\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"WXHVIATWKM\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":78,\"zone\":\"pag2_4\",\"zonepath\":\"[2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZEQMJDTKJK\",\"page\":2,\"spuid\":\"ZEQMJDTKJK\",\"tabindex\":8,\"type\":\"Label\",\"value\":\"Errore 4:\",\"w\":47,\"x\":19,\"y\":82,\"zone\":\"pag2_4\",\"zonepath\":\"[2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 5\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR05\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"YCDTVJJIMR\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":101,\"zone\":\"pag2_5\",\"zonepath\":\"[2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QOKDINZBUM\",\"page\":2,\"spuid\":\"QOKDINZBUM\",\"tabindex\":10,\"type\":\"Label\",\"value\":\"Errore 5:\",\"w\":47,\"x\":19,\"y\":105,\"zone\":\"pag2_5\",\"zonepath\":\"[2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 6\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR06\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"BACNEOKNNG\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":124,\"zone\":\"pag2_6\",\"zonepath\":\"[2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MSZJRHNIOJ\",\"page\":2,\"spuid\":\"MSZJRHNIOJ\",\"tabindex\":12,\"type\":\"Label\",\"value\":\"Errore 6:\",\"w\":47,\"x\":19,\"y\":128,\"zone\":\"pag2_6\",\"zonepath\":\"[2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 7\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR07\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"RVIBIVADUM\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":147,\"zone\":\"pag2_7\",\"zonepath\":\"[2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YCUADRGOUT\",\"page\":2,\"spuid\":\"YCUADRGOUT\",\"tabindex\":14,\"type\":\"Label\",\"value\":\"Errore 7:\",\"w\":47,\"x\":19,\"y\":151,\"zone\":\"pag2_7\",\"zonepath\":\"[2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 8\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR08\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"XOBPJRQPBZ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":170,\"zone\":\"pag2_8\",\"zonepath\":\"[2,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SHKIUHYTBK\",\"page\":2,\"spuid\":\"SHKIUHYTBK\",\"tabindex\":16,\"type\":\"Label\",\"value\":\"Errore 8:\",\"w\":47,\"x\":19,\"y\":174,\"zone\":\"pag2_8\",\"zonepath\":\"[2,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 9\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR09\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"RFAJDLABHK\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":193,\"zone\":\"pag2_9\",\"zonepath\":\"[2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ODLCWVHXIM\",\"page\":2,\"spuid\":\"ODLCWVHXIM\",\"tabindex\":18,\"type\":\"Label\",\"value\":\"Errore 9:\",\"w\":47,\"x\":19,\"y\":197,\"zone\":\"pag2_9\",\"zonepath\":\"[2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 10\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR10\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"LNJHQTAPKH\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":216,\"zone\":\"pag2_10\",\"zonepath\":\"[2,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IXLENOMJOT\",\"page\":2,\"spuid\":\"IXLENOMJOT\",\"tabindex\":20,\"type\":\"Label\",\"value\":\"Errore 10:\",\"w\":53,\"x\":13,\"y\":220,\"zone\":\"pag2_10\",\"zonepath\":\"[2,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 11\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR11\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"BXBAWWFZDV\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":239,\"zone\":\"pag2_11\",\"zonepath\":\"[2,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MGTUFSHMTT\",\"page\":2,\"spuid\":\"MGTUFSHMTT\",\"tabindex\":22,\"type\":\"Label\",\"value\":\"Errore 11:\",\"w\":53,\"x\":13,\"y\":243,\"zone\":\"pag2_11\",\"zonepath\":\"[2,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 12\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR12\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"GLAQECICHA\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":262,\"zone\":\"pag2_12\",\"zonepath\":\"[2,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JGYZCBGDLT\",\"page\":2,\"spuid\":\"JGYZCBGDLT\",\"tabindex\":24,\"type\":\"Label\",\"value\":\"Errore 12:\",\"w\":53,\"x\":13,\"y\":266,\"zone\":\"pag2_12\",\"zonepath\":\"[2,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 13\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR13\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"KLEBFCDCIF\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":285,\"zone\":\"pag2_13\",\"zonepath\":\"[2,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MDPKUXQMTX\",\"page\":2,\"spuid\":\"MDPKUXQMTX\",\"tabindex\":26,\"type\":\"Label\",\"value\":\"Errore 13:\",\"w\":53,\"x\":13,\"y\":289,\"zone\":\"pag2_13\",\"zonepath\":\"[2,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 14\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR14\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"WXIZZGFGYV\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":308,\"zone\":\"pag2_14\",\"zonepath\":\"[2,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IMVSNIGMHD\",\"page\":2,\"spuid\":\"IMVSNIGMHD\",\"tabindex\":28,\"type\":\"Label\",\"value\":\"Errore 14:\",\"w\":53,\"x\":13,\"y\":312,\"zone\":\"pag2_14\",\"zonepath\":\"[2,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 15\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR15\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"VDAZXJXDXY\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":331,\"zone\":\"pag2_15\",\"zonepath\":\"[2,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TJJMOKWTNI\",\"page\":2,\"spuid\":\"TJJMOKWTNI\",\"tabindex\":30,\"type\":\"Label\",\"value\":\"Errore 15:\",\"w\":53,\"x\":13,\"y\":335,\"zone\":\"pag2_15\",\"zonepath\":\"[2,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 16\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR16\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"JANNSGSWGM\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":354,\"zone\":\"pag2_16\",\"zonepath\":\"[2,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CVAGINOCMP\",\"page\":2,\"spuid\":\"CVAGINOCMP\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"Errore 16:\",\"w\":53,\"x\":13,\"y\":358,\"zone\":\"pag2_16\",\"zonepath\":\"[2,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 17\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR17\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"HUIFQLIZHZ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":377,\"zone\":\"pag2_17\",\"zonepath\":\"[2,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JPTDZENLJK\",\"page\":2,\"spuid\":\"JPTDZENLJK\",\"tabindex\":34,\"type\":\"Label\",\"value\":\"Errore 17:\",\"w\":53,\"x\":13,\"y\":381,\"zone\":\"pag2_17\",\"zonepath\":\"[2,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 18\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR18\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"YPMKIOATIZ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":400,\"zone\":\"pag2_18\",\"zonepath\":\"[2,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OKMDAUUJFH\",\"page\":2,\"spuid\":\"OKMDAUUJFH\",\"tabindex\":36,\"type\":\"Label\",\"value\":\"Errore 18:\",\"w\":53,\"x\":13,\"y\":404,\"zone\":\"pag2_18\",\"zonepath\":\"[2,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 19\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR19\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"KGAEUMDODK\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":423,\"zone\":\"pag2_19\",\"zonepath\":\"[2,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QCKHWGMETR\",\"page\":2,\"spuid\":\"QCKHWGMETR\",\"tabindex\":38,\"type\":\"Label\",\"value\":\"Errore 19:\",\"w\":53,\"x\":13,\"y\":427,\"zone\":\"pag2_19\",\"zonepath\":\"[2,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 20\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR20\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"VGBNUNWCXY\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":446,\"zone\":\"pag2_20\",\"zonepath\":\"[2,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PLWWFSRYAI\",\"page\":2,\"spuid\":\"PLWWFSRYAI\",\"tabindex\":40,\"type\":\"Label\",\"value\":\"Errore 20:\",\"w\":53,\"x\":13,\"y\":450,\"zone\":\"pag2_20\",\"zonepath\":\"[2,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 21\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR21\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"DLAKPEHAYJ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":469,\"zone\":\"pag2_21\",\"zonepath\":\"[2,21]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GVUUSALGNA\",\"page\":2,\"spuid\":\"GVUUSALGNA\",\"tabindex\":42,\"type\":\"Label\",\"value\":\"Errore 21:\",\"w\":53,\"x\":13,\"y\":473,\"zone\":\"pag2_21\",\"zonepath\":\"[2,21]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 22\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR22\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"JEDPFHJRZS\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":492,\"zone\":\"pag2_22\",\"zonepath\":\"[2,22]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NOXWNOVPAD\",\"page\":2,\"spuid\":\"NOXWNOVPAD\",\"tabindex\":44,\"type\":\"Label\",\"value\":\"Errore 22:\",\"w\":53,\"x\":13,\"y\":496,\"zone\":\"pag2_22\",\"zonepath\":\"[2,22]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 23\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR23\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"BMIRKKOHKR\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":515,\"zone\":\"pag2_23\",\"zonepath\":\"[2,23]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CDOOHIIAPB\",\"page\":2,\"spuid\":\"CDOOHIIAPB\",\"tabindex\":46,\"type\":\"Label\",\"value\":\"Errore 23:\",\"w\":53,\"x\":13,\"y\":519,\"zone\":\"pag2_23\",\"zonepath\":\"[2,23]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 24\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR24\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"OHTYWCOOIK\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":538,\"zone\":\"pag2_24\",\"zonepath\":\"[2,24]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MWDMUSJEML\",\"page\":2,\"spuid\":\"MWDMUSJEML\",\"tabindex\":48,\"type\":\"Label\",\"value\":\"Errore 24:\",\"w\":53,\"x\":13,\"y\":542,\"zone\":\"pag2_24\",\"zonepath\":\"[2,24]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 25\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR25\",\"page\":2,\"readonly\":\"true\",\"spuid\":\"LAAPMSXDPL\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":67,\"y\":561,\"zone\":\"pag2_25\",\"zonepath\":\"[2,25]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VBPHKZYIIK\",\"page\":2,\"spuid\":\"VBPHKZYIIK\",\"tabindex\":50,\"type\":\"Label\",\"value\":\"Errore 25:\",\"w\":53,\"x\":13,\"y\":565,\"zone\":\"pag2_25\",\"zonepath\":\"[2,25]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 26\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR26\",\"page\":3,\"spuid\":\"ASSPEANDMC\",\"tabindex\":1,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":10,\"zone\":\"pag3_1\",\"zonepath\":\"[3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HNLLPVTPEP\",\"page\":3,\"spuid\":\"HNLLPVTPEP\",\"tabindex\":2,\"type\":\"Label\",\"value\":\"Errore 26:\",\"w\":53,\"x\":14,\"y\":14,\"zone\":\"pag3_1\",\"zonepath\":\"[3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore27\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR27\",\"page\":3,\"spuid\":\"FMOIMQZAPG\",\"tabindex\":3,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":33,\"zone\":\"pag3_2\",\"zonepath\":\"[3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AWLZZLJZMV\",\"page\":3,\"spuid\":\"AWLZZLJZMV\",\"tabindex\":4,\"type\":\"Label\",\"value\":\"Errore 27:\",\"w\":53,\"x\":14,\"y\":37,\"zone\":\"pag3_2\",\"zonepath\":\"[3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 28\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR28\",\"page\":3,\"spuid\":\"RKGHXZFQZL\",\"tabindex\":5,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":56,\"zone\":\"pag3_3\",\"zonepath\":\"[3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_REHSVTTQZW\",\"page\":3,\"spuid\":\"REHSVTTQZW\",\"tabindex\":6,\"type\":\"Label\",\"value\":\"Errore 28:\",\"w\":53,\"x\":14,\"y\":60,\"zone\":\"pag3_3\",\"zonepath\":\"[3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 29\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR29\",\"page\":3,\"spuid\":\"HEPMULJALS\",\"tabindex\":7,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":79,\"zone\":\"pag3_4\",\"zonepath\":\"[3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QWSQQWGKJA\",\"page\":3,\"spuid\":\"QWSQQWGKJA\",\"tabindex\":8,\"type\":\"Label\",\"value\":\"Errore 29:\",\"w\":53,\"x\":14,\"y\":83,\"zone\":\"pag3_4\",\"zonepath\":\"[3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 30\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR30\",\"page\":3,\"spuid\":\"DYBWDBXZIJ\",\"tabindex\":9,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":102,\"zone\":\"pag3_5\",\"zonepath\":\"[3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RYCQAUVBFN\",\"page\":3,\"spuid\":\"RYCQAUVBFN\",\"tabindex\":10,\"type\":\"Label\",\"value\":\"Errore 30:\",\"w\":53,\"x\":14,\"y\":106,\"zone\":\"pag3_5\",\"zonepath\":\"[3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 31\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR31\",\"page\":3,\"spuid\":\"LISOLVFJNF\",\"tabindex\":11,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":125,\"zone\":\"pag3_6\",\"zonepath\":\"[3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XYZFJXNCXY\",\"page\":3,\"spuid\":\"XYZFJXNCXY\",\"tabindex\":12,\"type\":\"Label\",\"value\":\"Errore 31:\",\"w\":53,\"x\":14,\"y\":129,\"zone\":\"pag3_6\",\"zonepath\":\"[3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 32\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR32\",\"page\":3,\"spuid\":\"BHISKUARAJ\",\"tabindex\":13,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":148,\"zone\":\"pag3_7\",\"zonepath\":\"[3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KPITEKYSGW\",\"page\":3,\"spuid\":\"KPITEKYSGW\",\"tabindex\":14,\"type\":\"Label\",\"value\":\"Errore 32:\",\"w\":53,\"x\":14,\"y\":152,\"zone\":\"pag3_7\",\"zonepath\":\"[3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 33\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR33\",\"page\":3,\"spuid\":\"MSSBSWBLKI\",\"tabindex\":15,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":171,\"zone\":\"pag3_8\",\"zonepath\":\"[3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YQMAZGPJAS\",\"page\":3,\"spuid\":\"YQMAZGPJAS\",\"tabindex\":16,\"type\":\"Label\",\"value\":\"Errore 33:\",\"w\":53,\"x\":14,\"y\":175,\"zone\":\"pag3_8\",\"zonepath\":\"[3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 34\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR34\",\"page\":3,\"spuid\":\"ATBSEHTJHH\",\"tabindex\":17,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":194,\"zone\":\"pag3_9\",\"zonepath\":\"[3,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AGCPTXWUDW\",\"page\":3,\"spuid\":\"AGCPTXWUDW\",\"tabindex\":18,\"type\":\"Label\",\"value\":\"Errore 34:\",\"w\":53,\"x\":14,\"y\":198,\"zone\":\"pag3_9\",\"zonepath\":\"[3,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 35\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR35\",\"page\":3,\"spuid\":\"CIFSRVZLSK\",\"tabindex\":19,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":217,\"zone\":\"pag3_10\",\"zonepath\":\"[3,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EUBHVZLAKQ\",\"page\":3,\"spuid\":\"EUBHVZLAKQ\",\"tabindex\":20,\"type\":\"Label\",\"value\":\"Errore 35:\",\"w\":53,\"x\":14,\"y\":221,\"zone\":\"pag3_10\",\"zonepath\":\"[3,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 36\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR36\",\"page\":3,\"spuid\":\"FCOYAJZYOF\",\"tabindex\":21,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":240,\"zone\":\"pag3_11\",\"zonepath\":\"[3,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YBMQFVMVNK\",\"page\":3,\"spuid\":\"YBMQFVMVNK\",\"tabindex\":22,\"type\":\"Label\",\"value\":\"Errore 36:\",\"w\":53,\"x\":14,\"y\":244,\"zone\":\"pag3_11\",\"zonepath\":\"[3,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 37\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR37\",\"page\":3,\"spuid\":\"ZNHTQWPUYJ\",\"tabindex\":23,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":263,\"zone\":\"pag3_12\",\"zonepath\":\"[3,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YUAOFCOOFT\",\"page\":3,\"spuid\":\"YUAOFCOOFT\",\"tabindex\":24,\"type\":\"Label\",\"value\":\"Errore 37:\",\"w\":53,\"x\":14,\"y\":267,\"zone\":\"pag3_12\",\"zonepath\":\"[3,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 38\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR38\",\"page\":3,\"spuid\":\"ULYZEYIIYY\",\"tabindex\":25,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":286,\"zone\":\"pag3_13\",\"zonepath\":\"[3,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_APRWZHGLUI\",\"page\":3,\"spuid\":\"APRWZHGLUI\",\"tabindex\":26,\"type\":\"Label\",\"value\":\"Errore 38:\",\"w\":53,\"x\":14,\"y\":290,\"zone\":\"pag3_13\",\"zonepath\":\"[3,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 39\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR39\",\"page\":3,\"spuid\":\"ZRCBZVUWZE\",\"tabindex\":27,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":309,\"zone\":\"pag3_14\",\"zonepath\":\"[3,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VTTPEXBMTN\",\"page\":3,\"spuid\":\"VTTPEXBMTN\",\"tabindex\":28,\"type\":\"Label\",\"value\":\"Errore 39:\",\"w\":53,\"x\":14,\"y\":313,\"zone\":\"pag3_14\",\"zonepath\":\"[3,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 40\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR40\",\"page\":3,\"spuid\":\"TCMPTOYHZU\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":332,\"zone\":\"pag3_15\",\"zonepath\":\"[3,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CAQYVLVNUV\",\"page\":3,\"spuid\":\"CAQYVLVNUV\",\"tabindex\":30,\"type\":\"Label\",\"value\":\"Errore 40:\",\"w\":53,\"x\":14,\"y\":336,\"zone\":\"pag3_15\",\"zonepath\":\"[3,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 41\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR41\",\"page\":3,\"spuid\":\"DYIXHFFDPL\",\"tabindex\":31,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":355,\"zone\":\"pag3_16\",\"zonepath\":\"[3,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YCPYSNRJCS\",\"page\":3,\"spuid\":\"YCPYSNRJCS\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"Errore 41:\",\"w\":53,\"x\":14,\"y\":359,\"zone\":\"pag3_16\",\"zonepath\":\"[3,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 42\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR42\",\"page\":3,\"spuid\":\"OZIAVQGVQX\",\"tabindex\":33,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":378,\"zone\":\"pag3_17\",\"zonepath\":\"[3,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KCOBOXNFOZ\",\"page\":3,\"spuid\":\"KCOBOXNFOZ\",\"tabindex\":34,\"type\":\"Label\",\"value\":\"Errore 42:\",\"w\":53,\"x\":14,\"y\":382,\"zone\":\"pag3_17\",\"zonepath\":\"[3,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 43\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR43\",\"page\":3,\"spuid\":\"QURNMKDXBF\",\"tabindex\":35,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":401,\"zone\":\"pag3_18\",\"zonepath\":\"[3,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XVDSGNYPCO\",\"page\":3,\"spuid\":\"XVDSGNYPCO\",\"tabindex\":36,\"type\":\"Label\",\"value\":\"Errore 43:\",\"w\":53,\"x\":14,\"y\":405,\"zone\":\"pag3_18\",\"zonepath\":\"[3,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 44\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR44\",\"page\":3,\"spuid\":\"MNXGCWMDZI\",\"tabindex\":37,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":424,\"zone\":\"pag3_19\",\"zonepath\":\"[3,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GEHQBAIYSA\",\"page\":3,\"spuid\":\"GEHQBAIYSA\",\"tabindex\":38,\"type\":\"Label\",\"value\":\"Errore 44:\",\"w\":53,\"x\":14,\"y\":428,\"zone\":\"pag3_19\",\"zonepath\":\"[3,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 45\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR45\",\"page\":3,\"spuid\":\"YJUYZEFYVU\",\"tabindex\":39,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":447,\"zone\":\"pag3_20\",\"zonepath\":\"[3,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RWRUJLOGUJ\",\"page\":3,\"spuid\":\"RWRUJLOGUJ\",\"tabindex\":40,\"type\":\"Label\",\"value\":\"Errore 45:\",\"w\":53,\"x\":14,\"y\":451,\"zone\":\"pag3_20\",\"zonepath\":\"[3,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 46\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR46\",\"page\":3,\"spuid\":\"ASNHGNRDBH\",\"tabindex\":41,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":470,\"zone\":\"pag3_21\",\"zonepath\":\"[3,21]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QZDQYZMYBD\",\"page\":3,\"spuid\":\"QZDQYZMYBD\",\"tabindex\":42,\"type\":\"Label\",\"value\":\"Errore 46:\",\"w\":53,\"x\":14,\"y\":474,\"zone\":\"pag3_21\",\"zonepath\":\"[3,21]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 47\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR47\",\"page\":3,\"spuid\":\"CZSDXMRIYM\",\"tabindex\":43,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":493,\"zone\":\"pag3_22\",\"zonepath\":\"[3,22]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LXCXEBOILM\",\"page\":3,\"spuid\":\"LXCXEBOILM\",\"tabindex\":44,\"type\":\"Label\",\"value\":\"Errore 47:\",\"w\":53,\"x\":14,\"y\":497,\"zone\":\"pag3_22\",\"zonepath\":\"[3,22]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 48\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR48\",\"page\":3,\"spuid\":\"XVGSKNYKNU\",\"tabindex\":45,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":516,\"zone\":\"pag3_23\",\"zonepath\":\"[3,23]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WJGQPYDDSI\",\"page\":3,\"spuid\":\"WJGQPYDDSI\",\"tabindex\":46,\"type\":\"Label\",\"value\":\"Errore 48:\",\"w\":53,\"x\":14,\"y\":520,\"zone\":\"pag3_23\",\"zonepath\":\"[3,23]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 49\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR49\",\"page\":3,\"spuid\":\"BBGXFOFUHV\",\"tabindex\":47,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":539,\"zone\":\"pag3_24\",\"zonepath\":\"[3,24]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YNBUPEMGKR\",\"page\":3,\"spuid\":\"YNBUPEMGKR\",\"tabindex\":48,\"type\":\"Label\",\"value\":\"Errore 49:\",\"w\":53,\"x\":14,\"y\":543,\"zone\":\"pag3_24\",\"zonepath\":\"[3,24]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Errore 50\",\"h\":20,\"maxlength\":80,\"name\":\"TRXERROR50\",\"page\":3,\"spuid\":\"VKWSDIQTXK\",\"tabindex\":49,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":68,\"y\":562,\"zone\":\"pag3_25\",\"zonepath\":\"[3,25]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NDQGRTJVYG\",\"page\":3,\"spuid\":\"NDQGRTJVYG\",\"tabindex\":50,\"type\":\"Label\",\"value\":\"Errore 50:\",\"w\":53,\"x\":14,\"y\":566,\"zone\":\"pag3_25\",\"zonepath\":\"[3,25]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_wutrxchk_auiBO BO,ServletStatus status) {
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
     "<script src='armt_wutrxchk_aui?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_wutrxchk_aui_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_wutrxchk_aui_edit.js'>" +
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
      status.out.println("w_TRSSEGNO=a[2];");
      status.out.println("w_TRXIMPORTO=a[3];");
      status.out.println("w_TRXCONTAN=a[4];");
      status.out.println("w_TRXUNIQUE=a[5];");
      status.out.println("w_TRXCODDIP=a[6];");
      status.out.println("w_TRXCOGCON=a[7];");
      status.out.println("w_TRXNOMCON=a[8];");
      status.out.println("w_TRXDESTIN=a[9];");
      status.out.println("w_TRXMTCN=a[10];");
      status.out.println("w_TRXCODCAS=a[11];");
      status.out.println("w_TRXRECTYPE=a[12];");
      status.out.println("w_TRXCODMAG=a[13];");
      status.out.println("w_TRXCODUNI=a[14];");
      status.out.println("w_TRXFLGAUI=a[15];");
      status.out.println("w_TRXFLGFOR=a[16];");
      status.out.println("w_TRXERROR01=a[17];");
      status.out.println("w_TRXERROR02=a[18];");
      status.out.println("w_TRXERROR03=a[19];");
      status.out.println("w_TRXERROR04=a[20];");
      status.out.println("w_TRXERROR05=a[21];");
      status.out.println("w_TRXERROR06=a[22];");
      status.out.println("w_TRXERROR07=a[23];");
      status.out.println("w_TRXERROR08=a[24];");
      status.out.println("w_TRXERROR09=a[25];");
      status.out.println("w_TRXERROR10=a[26];");
      status.out.println("w_TRXERROR11=a[27];");
      status.out.println("w_TRXERROR12=a[28];");
      status.out.println("w_TRXERROR13=a[29];");
      status.out.println("w_TRXERROR14=a[30];");
      status.out.println("w_TRXERROR15=a[31];");
      status.out.println("w_TRXERROR16=a[32];");
      status.out.println("w_TRXERROR17=a[33];");
      status.out.println("w_TRXERROR18=a[34];");
      status.out.println("w_TRXERROR19=a[35];");
      status.out.println("w_TRXERROR20=a[36];");
      status.out.println("w_TRXERROR21=a[37];");
      status.out.println("w_TRXERROR22=a[38];");
      status.out.println("w_TRXERROR23=a[39];");
      status.out.println("w_TRXERROR24=a[40];");
      status.out.println("w_TRXERROR25=a[41];");
      status.out.println("w_TRXERROR26=a[42];");
      status.out.println("w_TRXERROR27=a[43];");
      status.out.println("w_TRXERROR28=a[44];");
      status.out.println("w_TRXERROR29=a[45];");
      status.out.println("w_TRXERROR30=a[46];");
      status.out.println("w_TRXERROR31=a[47];");
      status.out.println("w_TRXERROR32=a[48];");
      status.out.println("w_TRXERROR33=a[49];");
      status.out.println("w_TRXERROR34=a[50];");
      status.out.println("w_TRXERROR35=a[51];");
      status.out.println("w_TRXERROR36=a[52];");
      status.out.println("w_TRXERROR37=a[53];");
      status.out.println("w_TRXERROR38=a[54];");
      status.out.println("w_TRXERROR39=a[55];");
      status.out.println("w_TRXERROR40=a[56];");
      status.out.println("w_TRXERROR41=a[57];");
      status.out.println("w_TRXERROR42=a[58];");
      status.out.println("w_TRXERROR43=a[59];");
      status.out.println("w_TRXERROR44=a[60];");
      status.out.println("w_TRXERROR45=a[61];");
      status.out.println("w_TRXERROR46=a[62];");
      status.out.println("w_TRXERROR47=a[63];");
      status.out.println("w_TRXERROR48=a[64];");
      status.out.println("w_TRXERROR49=a[65];");
      status.out.println("w_TRXERROR50=a[66];");
      status.out.println("w_TRXCOGNOM=a[67];");
      status.out.println("w_TRXNOME=a[68];");
      status.out.println("w_TRXDOMICI=a[69];");
      status.out.println("w_TRXFLGCF=a[70];");
      status.out.println("w_TRXCODFIS=a[71];");
      status.out.println("w_TRXLUONAS=a[72];");
      status.out.println("w_TRXNUMDOC=a[73];");
      status.out.println("w_TRXDATSCA=a[74];");
      status.out.println("w_TRXDATRIL=a[75];");
      status.out.println("w_TRXAUTRIL=a[76];");
      status.out.println("w_TRXNAZRES=a[77];");
      status.out.println("w_TRXCITRES=a[78];");
      status.out.println("w_TRXTIPDOC=a[79];");
      status.out.println("w_TRXDATNAS=a[80];");
      status.out.println("w_TRXDATOPE=a[81];");
      status.out.println("w_TRXSESSO=a[82];");
      status.out.println("w_TRXNASSTATO=a[83];");
      status.out.println("w_TRXNASCOMUN=a[84];");
      status.out.println("w_TRXFLGCON=a[85];");
      status.out.println("w_xMADESCRI=a[86];");
      status.out.println("w_xDESCRIZ=a[87];");
      status.out.println("w_doctype=a[88];");
      status.out.println("w_sesso=a[89];");
      status.out.println("m_PrimaryKeys=['TRXCODPRG'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_wutrxchk_aui_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(536,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
  void RaiseLoadedEntity(armt_wutrxchk_auiBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({TRXCODPRG:"+SPLib.ToJSValue(BO.w_TRXCODPRG,"N",15,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_wutrxchk_auiBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(armt_wutrxchk_auiBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(armt_wutrxchk_auiBO BO,ServletStatus status) {
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
  void WriteExitPage(armt_wutrxchk_auiBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({TRXCODPRG:"+SPLib.ToJSValue(BO.w_TRXCODPRG,"N",15,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_wutrxchk_auiBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_wutrxchk_auiBO BO,ServletStatus status) throws IOException {
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
     "<script src='SPPrxy/"+arfn_wu_doctype.m_cEntityUid+"/arfn_wu_doctype.js'>" +
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
      arfn_wu_doctype.GetCallableNames(callable);
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_wutrxchk_auiBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(BO.w_TRXCODPRG,"N",15,0));
      }
    } else if (CPLib.eq(p_cUID,"HZPBCLSNRS")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"UTFQIBBLAF")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_wutrxchk_auiBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
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
    }
    return result;
  }
}
