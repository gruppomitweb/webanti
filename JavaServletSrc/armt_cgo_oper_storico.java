import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_cgo_oper_storico extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*c5ce316a*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "cgo_operazioni_dl_multi";
    }
    public String w_SNAINUMOPE;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_SNAINUMOPE,context,"cgo_operazioni_dl_multi","SNAINUMOPE","C",15,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
         "<input name='SNAINUMOPE' type='hidden' value="+SPLib.ToHTMLValue(w_SNAINUMOPE,"C",15,0)+">" +
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
    armt_cgo_oper_storicoBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_cgo_operazioni_dl_multi;
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
      status.w_SNAINUMOPE = BO.w_SNAINUMOPE;
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
    return "CGO Storico Operazioni Agenzie (DL)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_cgo_oper_storico";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 797;
    l_eg.m_nEntityHeight = 733;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"cgo_operazioni_dl_multi","tbcitta","tbstati","cgo_tipdoc","tbtipatt","tbtipreg","tbcauana","personbo","intermbo","anadip","operazbo","tbcausin","cgo_vltplat","cgo_tbtipgio"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","Dati Operazione","page"),new ZoneItem("page_2","Documenti","page"),new ZoneItem("box_CCUOYXMBZC","",""),new ZoneItem("Operazione","Dati Operazione","collapsible"),new ZoneItem("Soggetto","Dati Soggetto","collapsible"),new ZoneItem("box_XWJLXLYKJC","","")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"SNAINUMOPE"};
    l_eg.items = new SPItem[]{
                   new SPItem("CGOTIPOPE","C",1,0, "hide","Tipo Gioco"),
                   new SPItem("CAIDBIGLIETTO","C",30,0, "show","ID BIGLIETTO"),
                   new SPItem("xSOGTPGIO","N",12,2, "hide","Soglia pagamento Agenzia"),
                   new SPItem("xDEFTPGIO","C",1,0, "hide","Default (A=Agenzia , S=SNAI)"),
                   new SPItem("xEDTTPGIO","C",1,0, "hide","Abilita modifica Scelta"),
                   new SPItem("DATAOPE","D",8,0, "edit","Data Operazione"),
                   new SPItem("FLAGCONT","C",1,0, "edit","Contanti (S/N)"),
                   new SPItem("CACODICE","N",5,0, "edit","Causale"),
                   new SPItem("CAFLGOPE","C",1,0, "show","Tipo Registrazione"),
                   new SPItem("TOTLIRE","N",15,2, "edit","Totale Operazione"),
                   new SPItem("TOTCONT","N",15,2, "edit","di cui contanti"),
                   new SPItem("CGOFLGVLT","C",1,0, "edit","Pagamento VLT"),
                   new SPItem("CGOFLGVNP","C",1,0, "hide","Pagamento Vincite prenotate"),
                   new SPItem("MEZPAGAM","C",1,0, "edit","Mezzo Pagamento"),
                   new SPItem("CFESTERO","N",1,0, "edit","Codice Fiscale Estero"),
                   new SPItem("CODFISC","C",16,0, "edit","Codice Fiscale"),
                   new SPItem("COGNOME","C",26,0, "edit","Cognome"),
                   new SPItem("NOME","C",25,0, "edit","Nome"),
                   new SPItem("NASCOMUN","C",30,0, "edit","Luogo di Nascita"),
                   new SPItem("TIPINTER","C",2,0, "edit","Prov."),
                   new SPItem("SESSO","C",1,0, "edit","Sesso"),
                   new SPItem("NASSTATO","C",30,0, "edit","Stato di nascita"),
                   new SPItem("DATANASC","D",8,0, "edit","Data Nascita"),
                   new SPItem("PAESE","C",3,0, "edit","Stato"),
                   new SPItem("DESCCIT","C",40,0, "edit","Citt�"),
                   new SPItem("PROVINCIA","C",2,0, "edit","Provincia"),
                   new SPItem("CAP","C",9,0, "edit","CAP"),
                   new SPItem("DOMICILIO","C",35,0, "edit","Indirizzo"),
                   new SPItem("TIPODOC","C",2,0, "edit","Tipo Documento"),
                   new SPItem("NUMDOCUM","C",15,0, "edit","Numero Doc."),
                   new SPItem("DATARILASC","D",8,0, "edit","Rilascio Doc."),
                   new SPItem("DATAVALI","D",8,0, "edit","Data Fine Validit�"),
                   new SPItem("AUTRILASC","C",30,0, "edit","Autorit� di rilascio"),
                   new SPItem("ATTIV","C",10,0, "hide","Attivit� Prevalente"),
                   new SPItem("TIPOPERS","C",1,0, "hide",""),
                   new SPItem("RAGSOC","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("SOTGRUP","C",3,0, "hide","Sottogruppo Att. Ec."),
                   new SPItem("RAMOGRUP","C",3,0, "hide","Ramo Gruppo Att. Ec."),
                   new SPItem("SETTSINT","C",3,0, "hide","Settorizzazione UIC"),
                   new SPItem("dessta","C",30,0, "hide","Descrizione"),
                   new SPItem("tipsot","C",1,0, "hide","Tipo"),
                   new SPItem("STATOREG","C",1,0, "hide",""),
                   new SPItem("IDBASE","C",10,0, "hide",""),
                   new SPItem("NUMPROG","C",7,0, "hide",""),
                   new SPItem("DESCRI","C",30,0, "hide","Descrizione"),
                   new SPItem("gSeekAos","C",1,0, "hide","Collegamento con AOS"),
                   new SPItem("gDataVaria","D",8,0, "hide","Data Variazione"),
                   new SPItem("gFlgDoc","C",1,0, "hide","Collegamento con storico documenti"),
                   new SPItem("SNAINUMOPE","C",15,0, "edit","N� Operazione"),
                   new SPItem("DATAREG","D",8,0, "show","Data registrazione"),
                   new SPItem("TIPOOPRAP","C",2,0, "show","Tipo Operazione Completa"),
                   new SPItem("CODANA","C",4,0, "hide","Causale Analitica"),
                   new SPItem("CODVOC","C",2,0, "hide","Causale Sintetica"),
                   new SPItem("VALUTA","C",3,0, "hide","Divisa"),
                   new SPItem("CAMBIO","N",9,4, "hide","Cambio"),
                   new SPItem("CONNESCLI","C",16,0, "hide","Codice Cliente Occasionale"),
                   new SPItem("CONNESBEN","C",16,0, "hide","Codice Cliente Occasionale"),
                   new SPItem("C_RAG","C",70,0, "hide",""),
                   new SPItem("C_CTA","C",30,0, "hide",""),
                   new SPItem("C_PRV","C",2,0, "hide",""),
                   new SPItem("C_CAP","C",5,0, "hide",""),
                   new SPItem("C_CAB","C",6,0, "hide",""),
                   new SPItem("C_IND","C",35,0, "hide",""),
                   new SPItem("C_STA","C",3,0, "hide",""),
                   new SPItem("NUMPROG","C",11,0, "show","Numero Progressivo"),
                   new SPItem("gIntemediario","C",11,0, "show","Intermediario"),
                   new SPItem("CODINTER","C",11,0, "hide","Codice Intermediario"),
                   new SPItem("CODDIPE","C",6,0, "show","Codice Dipendenza"),
                   new SPItem("DESCCITDIP","C",30,0, "show","Citt� Dipendenza"),
                   new SPItem("SEGNO","C",1,0, "hide","Segno"),
                   new SPItem("FLAGFRAZ","C",1,0, "hide","Frazionata (S/N)"),
                   new SPItem("COLLEG","C",11,0, "hide","Collegamento Operazione Multiple"),
                   new SPItem("PROVINCIADIP","C",2,0, "show","Provincia Dipendenza"),
                   new SPItem("CODCABDIP","C",6,0, "show","CAB Dipendenza"),
                   new SPItem("xDescDipe","C",30,0, "hide","Descrizione"),
                   new SPItem("datpaseuro","D",8,0, "hide","Data Passaggio EURO"),
                   new SPItem("xdes1","C",90,0, "hide","Descrizione"),
                   new SPItem("desccauana","C",165,0, "hide","Descrizione"),
                   new SPItem("CITINT","C",30,0, "hide","Citt�"),
                   new SPItem("CITDIP","C",30,0, "hide","Citt�"),
                   new SPItem("PROVDIP","C",2,0, "hide","Provincia"),
                   new SPItem("CABDIP","C",6,0, "hide","CAB"),
                   new SPItem("PROVINT","C",2,0, "hide","Provincia"),
                   new SPItem("CABINT","C",6,0, "hide","CAB"),
                   new SPItem("CODVOC","C",2,0, "hide","Causale Sintetica"),
                   new SPItem("xdesccausin","C",165,0, "hide","Descrizione"),
                   new SPItem("gChkDate","C",1,0, "hide","Controllo Date"),
                   new SPItem("idcitta","C",10,0, "hide","Codice"),
                   new SPItem("xdesctipatt","C",250,0, "hide","Descrizione"),
                   new SPItem("gVLT","N",10,2, "hide","Limite VLT"),
                   new SPItem("gVNP","N",10,2, "hide","Limite VNP"),
                   new SPItem("gCodDip","C",6,0, "hide","Dipendenza"),
                   new SPItem("gStpDwn","C",1,0, "hide","Stampa Download"),
                   new SPItem("CODCAB","C",6,0, "hide","CAB"),
                   new SPItem("PEP","C",1,0, "hide","Persona Politicamente Esposta"),
                   new SPItem("MIDBIGLIETTO","M",10,0, "edit",""),
                   new SPItem("VLTPLAT","C",2,0, "show","Piattaforma VLT"),
                   new SPItem("TIPOGIOCO","C",3,0, "show","Tipo gioco"),
                   new SPItem("xFLGPLGIO","C",1,0, "hide","Abilita Selezione Piattaforma"),
                   new SPItem("xDEFSPGIO","C",1,0, "hide","Default Sotto Soglia"),
                   new SPItem("xEDTSPGIO","C",1,0, "hide","Abilita Modifica Sotto Soglia"),
                   new SPItem("ASSEGNO","C",25,0, "edit","Assegno"),
                   new SPItem("IBAN","C",27,0, "edit","IBAN per Bonifici"),
                   new SPItem("CC4CIFRE","C",4,0, "edit","Ultime Cifre CC"),
                   new SPItem("CCDATSCA","C",7,0, "edit","Scadenza"),
                   new SPItem("NUMTEL","C",20,0, "edit","Numero Telefono"),
                   new SPItem("IDDOCALL","C",36,0, "hide","ID Collegamento Documenti"),
                   new SPItem("FLGDOCALL","C",1,0, "hide","Flag Documentazione Completa"),
                   new SPItem("gGesDoc","C",1,0, "hide","Gestione Documentale")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_cgo_oper_storicoBO BO) {
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
    l_translations=new String[][]{{"10032163180",p_Context.Translate("Autorit� di rilascio")},
    {"10034405761",p_Context.Translate("Codice Fiscale Estero")},
    {"1009376930",p_Context.Translate("Recupera dati anagrafici da codice fiscale")},
    {"10095365423",p_Context.Translate("Provincia")},
    {"10219814530",p_Context.Translate("Codice Cliente Occasionale")},
    {"10220423475",p_Context.Translate("Data Variazione")},
    {"1028598955",p_Context.Translate("Data registrazione")},
    {"10290663779",p_Context.Translate("ID Collegamento Documenti")},
    {"1033518927",p_Context.Translate("Attivit� Prevalente")},
    {"10499608141",p_Context.Translate("Soggetto Estero")},
    {"10524120562",p_Context.Translate("ID BIGLIETTO")},
    {"10574713661",p_Context.Translate("Numero Telefono")},
    {"10651434988",p_Context.Translate("Mezzo Pagamento")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"10787648910",p_Context.Translate("Stampa Download")},
    {"10848850431",p_Context.Translate("CAB Dipendenza")},
    {"10943726013",p_Context.Translate("di cui contanti")},
    {"109710548",p_Context.Translate("Divisa")},
    {"11061636098",p_Context.Translate("Default Sotto Soglia")},
    {"11137644647",p_Context.Translate("Tipo Operazione Completa")},
    {"11247539166",p_Context.Translate("Piattaforma VLT")},
    {"11256417841",p_Context.Translate("Pagamento VLT")},
    {"112851763",p_Context.Translate("Codice")},
    {"11293478463",p_Context.Translate("Attenzione! Data di rilascio inferiore alla data fine validit�.Verificare il corretto inserimento delle date.")},
    {"11316624286",p_Context.Translate("Codice Intermediario")},
    {"11356972522",p_Context.Translate("Provincia Dipendenza")},
    {"11365640",p_Context.Translate("CGO Storico Operazioni Agenzie (DL)")},
    {"11396780126",p_Context.Translate("Intermediario")},
    {"11419822357",p_Context.Translate("E' obbligatorio inserire un importo valido")},
    {"11429032151",p_Context.Translate("Tipo Documento")},
    {"11525797640",p_Context.Translate("%ERRORMESSAGE%")},
    {"11642408994",p_Context.Translate("Ultime Cifre CC")},
    {"11777527481",p_Context.Translate("Data Nascita")},
    {"11857312893",p_Context.Translate("Scadenza")},
    {"11921223220",p_Context.Translate("Codice Fiscale")},
    {"11925635672",p_Context.Translate("Collegamento con AOS")},
    {"11993248424",p_Context.Translate("N� Operazione")},
    {"12033514136",p_Context.Translate("Limite VLT")},
    {"12033514198",p_Context.Translate("Limite VNP")},
    {"1209108021",p_Context.Translate("Codice Fiscale non congruente con dati anagrafici")},
    {"12123284333",p_Context.Translate("Stato di nascita")},
    {"12123334500",p_Context.Translate("Luogo di Nascita")},
    {"1216938285",p_Context.Translate("Data Fine Validit�")},
    {"123704147",p_Context.Translate("Cambio")},
    {"1255218623",p_Context.Translate("Abilita Selezione Piattaforma")},
    {"1255511772",p_Context.Translate("Tipo Documento (CGO)")},
    {"1264575246",p_Context.Translate("Abilita modifica Scelta")},
    {"1267255314",p_Context.Translate("Persona Esposta Politicamente")},
    {"1270140254",p_Context.Translate("Dipendenza")},
    {"1270140318",p_Context.Translate("Dipendenze")},
    {"1513560829",p_Context.Translate("Persona Politicamente Esposta")},
    {"15186643",p_Context.Translate("Citt�")},
    {"1570205239",p_Context.Translate("Tipo Gioco")},
    {"1603759671",p_Context.Translate("Tipo gioco")},
    {"1608394306",p_Context.Translate("Rilascio Doc.")},
    {"1715238713",p_Context.Translate("Codice Fiscale Errato nel formato")},
    {"1722199786",p_Context.Translate("Frazionata (S/N)")},
    {"1734932797",p_Context.Translate("Numero Doc.")},
    {"1748201363",p_Context.Translate("Citt� Dipendenza")},
    {"18003",p_Context.Translate("CAB")},
    {"1814604627",p_Context.Translate("Causale")},
    {"1816546867",p_Context.Translate("Cognome")},
    {"1825772649",p_Context.Translate("Totale Operazione")},
    {"187973133",p_Context.Translate("Attenzione! Documento scaduto. E' necessario inserire gli estremi di un nuovo documento.")},
    {"1890893827",p_Context.Translate("Clienti")},
    {"1984809585",p_Context.Translate("Assegno")},
    {"2071283709",p_Context.Translate("Codice Dipendenza")},
    {"2095911698",p_Context.Translate("Settorizzazione UIC")},
    {"215310487",p_Context.Translate("Causale Sintetica")},
    {"215536597",p_Context.Translate("Causale Analitica")},
    {"21587",p_Context.Translate("CAP")},
    {"226933836",p_Context.Translate("Data Passaggio EURO")},
    {"237632211",p_Context.Translate("Contanti (S/N)")},
    {"282420974",p_Context.Translate("Causali Sintetiche")},
    {"282647084",p_Context.Translate("Causali Analitiche")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"296951675",p_Context.Translate("Gestione Documentale")},
    {"316744004",p_Context.Translate("Soglia pagamento Agenzia")},
    {"3528304",p_Context.Translate("Prov.")},
    {"38572451",p_Context.Translate("Default (A=Agenzia , S=SNAI)")},
    {"443454",p_Context.Translate("Nome")},
    {"448095445",p_Context.Translate("Pagamento Vincite prenotate")},
    {"484567773",p_Context.Translate("Prevalente Attivit�")},
    {"485092",p_Context.Translate("Tipo")},
    {"554236824",p_Context.Translate("Indirizzo")},
    {"572399938",p_Context.Translate("Ramo Gruppo Att. Ec.")},
    {"611154211",p_Context.Translate("Sottogruppo Att. Ec.")},
    {"674110294",p_Context.Translate("Flag Documentazione Completa")},
    {"737507602",p_Context.Translate("IBAN per Bonifici")},
    {"7383187",p_Context.Translate("Stati")},
    {"750412439",p_Context.Translate("Collegamento Operazione Multiple")},
    {"7753123",p_Context.Translate("Segno")},
    {"7776403",p_Context.Translate("Stato")},
    {"7776675",p_Context.Translate("Sesso")},
    {"819587209",p_Context.Translate("Attenzione! Data di rilascio documento successiva all'operazione. E' necessario inserire gli estremi di un nuovo documento.")},
    {"829201110",p_Context.Translate("Data Operazione")},
    {"839211622",p_Context.Translate("Numero Progressivo")},
    {"864597548",p_Context.Translate("Collegamento con storico documenti")},
    {"976489378",p_Context.Translate("Controllo Date")},
    {"981524941",p_Context.Translate("Abilita Modifica Sotto Soglia")},
    {"995100987",p_Context.Translate("Tipo Registrazione")}};
    return l_translations;
  }
  void WriteStyles(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_cgo_oper_storico.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_cgo_oper_storicoBO BO,ServletStatus status) {
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
    status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati Operazione"),"C",0,0)+"},{name:\"page_2\", element:\"page_2\", caption:"+SPLib.ToJSValue(status.context.Translate("Documenti"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
    status.out.println("Z.Tabs.Set('tabs',tabs);");
    status.out.println("} else {");
    status.out.println("var tabs = Z.Tabs.Get('tabs')");
    status.out.println("}");
    AddExtendedTabs(status);
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_cgo_oper_storico',false);");
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_cgo_oper_storico",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  // GetPortlet_Documenti_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_KUBMCPCHPZ_Vars(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"w_idpratica",BO.w_IDDOCALL);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"pTG",BO.w_TIPOGIOCO);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"pImporto",BO.w_TOTLIRE);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"pImporto",BO.w_TOTCONT);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"pFull",BO.w_FLGDOCALL);
    return inclusionVars;
  }
  void WriteControls(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    WriteControls_p2(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,3);
  }
  void WriteControls_p1(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:733px;width:797px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteControls_p1_b1(BO,status);
    WriteControls_p1_b2(BO,status);
    WriteControls_p1_b3(BO,status);
    WriteControls_p1_b4(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"Dati Operazione");
    PrintSidebarContent(1,status,getSidebarItems(0),true);
    PrintContextMenu(1,status,getContextMenu(0),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_2' class='PageContainer' style='position:relative;height:477px;width:797px;display:none'>" +
    "");
    WriteControls_p2_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,2,"Documenti");
    PrintSidebarContent(2,status,getSidebarItems(1),false);
    PrintContextMenu(2,status,getContextMenu(1),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b0(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_1' style='position:relative;height:103px;display:block' page='1'>" +
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
       "<div id='CCUOYXMBZC_DIV' class='UntitledBox'>" +
       "<div id='CCUOYXMBZC' class='BoxBody'>" +
       "</div>" +
       "</div>" +
      "");
      status.out.println(
       "<input name='CAIDBIGLIETTO' id='BMTLGIUQTH' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CAIDBIGLIETTO,"C",30,0,"!", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SNAINUMOPE' id='XFUOZLSACP' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_SNAINUMOPE,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel PrimaryKeyLabel' id='GZVEXPFQCZ_DIV'>" +
       "<label id='GZVEXPFQCZ' for='XFUOZLSACP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("N� Operazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='gIntemediario' id='GXLWKNXGMM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_gIntemediario,"C",11,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='11' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LOEAMXUYLA_DIV'>" +
       "<label id='LOEAMXUYLA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Intermediario:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='CODDIPE' id='AVHTGZTOSZ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CODDIPE,"C",6,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='6' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='DESCCITDIP' id='RLUMBFHPUD' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DESCCITDIP,"C",30,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='30' size='30' fieldtype='C'>" +
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
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Citt�:"))+"" +
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
      status.out.println(
       "<input name='PROVINCIADIP' id='OJGQABFSYN' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_PROVINCIADIP,"C",2,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='CODCABDIP' id='OZEOCQRSEQ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CODCABDIP,"C",6,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='6' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NRIPVBSJUQ_DIV'>" +
       "<label id='NRIPVBSJUQ' for='DMGEDRIYII'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Gioco:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZQBDEYWWMG_DIV'>" +
       "<label id='ZQBDEYWWMG' for='BMTLGIUQTH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ID BIGLIETTO:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<select name='VLTPLAT' id='LVYFMQXNZH' class='Combobox Disabled' disabled>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DJRHGZHJSR_DIV'>" +
       "<label id='DJRHGZHJSR' for='DMGEDRIYII'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Piattaforma:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<select name='TIPOGIOCO' id='DKNVEJCFAA' class='Combobox Disabled' disabled>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b1(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Operazione' id='YORQOIOBQN_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='YORQOIOBQN_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='YORQOIOBQN_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Operazione")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='YORQOIOBQN_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"YORQOIOBQN\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=YORQOIOBQN_HEADER&m_cBoxId=YORQOIOBQN&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Operazione"))+"");
    }
    status.out.println(
     "<div id='YORQOIOBQN' class='CollapsibleBody' style='position:relative;height:294px;display:block'>" +
    "");
    status.includeZoneAltInterface("Operazione@BEGIN");
    if (status.includeZoneAltInterface("Operazione")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Operazione@BEGIN") || status.HasZoneAltInterface("Operazione@END")) {
        status.out.println(
         "<div id='YORQOIOBQN_boxContent' style='position:relative;height:294px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAOPE' id='YLIKFVPZJA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATAOPE,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='YLIKFVPZJA_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='FLAGCONT' id='PURPSXEVAI' class='"+status.ObligatoryClass("Combobox")+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("0","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("0",CPLib.Trim(BO.w_FLAGCONT))?"SELECTED":"")+">" +
       ""+status.context.Translate("No")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_FLAGCONT))?"SELECTED":"")+">" +
       ""+status.context.Translate("Si")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('PURPSXEVAI'),w_FLAGCONT,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='CACODICE' id='WJQFIEBCQV' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue(0,"N",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(1,"N",5,0,"", status.m_oRegSettings)+" "+(CPLib.eq(1,BO.w_CACODICE)?"SELECTED":"")+">" +
       ""+status.context.Translate("Emissione Biglietti")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(3,"N",5,0,"", status.m_oRegSettings)+" "+(CPLib.eq(3,BO.w_CACODICE)?"SELECTED":"")+">" +
       ""+status.context.Translate("Pagamento Biglietti")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('WJQFIEBCQV'),w_CACODICE,'N');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<iframe name='ardt_cgo_oper_storico_multi' id='AAHJPBZVGL' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
       "</iframe>" +
      "");
      status.out.println(
       "<select name='CAFLGOPE' id='YJDISDDJUY' class='Combobox Disabled' disabled>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("G","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("G",CPLib.Trim(BO.w_CAFLGOPE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Giocata")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("R","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("R",CPLib.Trim(BO.w_CAFLGOPE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Versamento")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("V","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("V",CPLib.Trim(BO.w_CAFLGOPE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Vincita")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("P","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("P",CPLib.Trim(BO.w_CAFLGOPE))?"SELECTED":"")+">" +
       ""+status.context.Translate("Prelievo")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('YJDISDDJUY'),w_CAFLGOPE,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='TOTLIRE' id='HUAGBHPUNH' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_TOTLIRE,"N",15,2,"999,999,999,999.99", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='21' size='15' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='TOTCONT' id='HUDOCMLKKT' type='text' class='"+status.ObligatoryClass("Field",BO.HUDOCMLKKT_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_TOTCONT,"N",15,2,"999,999,999,999.99", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='21' size='15' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<div class='"+status.ObligatoryClass("")+"' id='SFKJNKYLJO_DIV'>" +
       "<span id='SFKJNKYLJO_0_container'>" +
       "<input id='SFKJNKYLJO_0' name='SFKJNKYLJO' type='radio' value="+SPLib.ToHTMLValue("S","C",1,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_CGOFLGVLT))?"CHECKED":"")+">" +
       "<label class='SPLabel' for='SFKJNKYLJO_0'>"+status.context.Translate("Concessionario")+"</label>" +
       "</span>" +
       "<span id='SFKJNKYLJO_1_container'>" +
       "<input id='SFKJNKYLJO_1' name='SFKJNKYLJO' type='radio' value="+SPLib.ToHTMLValue("A","C",1,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("A",CPLib.Trim(BO.w_CGOFLGVLT))?"CHECKED":"")+">" +
       "<label class='SPLabel' for='SFKJNKYLJO_1'>"+status.context.Translate("Punto Vendita")+"</label>" +
       "</span>" +
       "</div>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='MEZPAGAM' id='EOSKLIUGBC' class='"+status.ObligatoryClass("Combobox")+"' tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("A","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("A",CPLib.Trim(BO.w_MEZPAGAM))?"SELECTED":"")+">" +
       ""+status.context.Translate("Altro Mezzo")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("I","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("I",CPLib.Trim(BO.w_MEZPAGAM))?"SELECTED":"")+">" +
       ""+status.context.Translate("Bonifico Italia")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("E","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("E",CPLib.Trim(BO.w_MEZPAGAM))?"SELECTED":"")+">" +
       ""+status.context.Translate("Bonifico Estero")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("P","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("P",CPLib.Trim(BO.w_MEZPAGAM))?"SELECTED":"")+">" +
       ""+status.context.Translate("Bonifico Postale")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("C","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("C",CPLib.Trim(BO.w_MEZPAGAM))?"SELECTED":"")+">" +
       ""+status.context.Translate("Assegno Circolare")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("B","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("B",CPLib.Trim(BO.w_MEZPAGAM))?"SELECTED":"")+">" +
       ""+status.context.Translate("Assegno Bancario")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("V","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("V",CPLib.Trim(BO.w_MEZPAGAM))?"SELECTED":"")+">" +
       ""+status.context.Translate("Carta di Credito")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("S","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("S",CPLib.Trim(BO.w_MEZPAGAM))?"SELECTED":"")+">" +
       ""+status.context.Translate("Contante")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('EOSKLIUGBC'),w_MEZPAGAM,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<input name='DATAREG' id='OEIKQOZMYJ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DATAREG,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.out.println(
       "<input name='TIPOOPRAP' id='UJRFWINIVQ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TIPOOPRAP,"C",2,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='NUMPROG' id='XYMCLUECBD' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_NUMPROG,"C",11,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='11' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KDUGHGZUUG_DIV'>" +
       "<label id='KDUGHGZUUG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Numero Progressivo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HVHVAYPDJE_DIV'>" +
       "<label id='HVHVAYPDJE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Ticket:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GVTXMEILAZ_DIV'>" +
       "<label id='GVTXMEILAZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Contanti:"))+"" +
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
       "<span class='SPLabel' id='KMCNAWQHKV_DIV'>" +
       "<label id='KMCNAWQHKV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Operazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XLNVLBYVQX_DIV'>" +
       "<label id='XLNVLBYVQX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Totale Euro:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='IDTBMNCIOX_DIV'>" +
       "<label id='IDTBMNCIOX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("di cui contanti:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='THOGQCLBJA_DIV'>" +
       "<label id='THOGQCLBJA'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdes1)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VQCVMXHDPB_DIV'>" +
       "<label id='VQCVMXHDPB' for='EOSKLIUGBC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Mezzo Pagamento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LKYFODKVBU_DIV'>" +
       "<label id='LKYFODKVBU' for='SFKJNKYLJO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Pagamento da parte di:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YFGRJCQGZV_DIV'>" +
       "<label id='YFGRJCQGZV' for='WJQFIEBCQV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Causale:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<textarea name='MIDBIGLIETTO' id='BSSRUASCBR' class='Memo "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" cols='20' rows='2' style='display:none'>" +
       "</textarea>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ASSEGNO' id='KZWBLPQNHU' type='text' class='"+status.ObligatoryClass("Field",BO.KZWBLPQNHU_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_ASSEGNO,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C' style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IBAN' id='UTUCDPQJKK' type='text' class='"+status.ObligatoryClass("Field",BO.UTUCDPQJKK_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_IBAN,"C",27,0,"!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='27' size='27' fieldtype='C' style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CC4CIFRE' id='FKEAKFSYVU' type='text' class='"+status.ObligatoryClass("Field",BO.FKEAKFSYVU_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_CC4CIFRE,"C",4,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='4' fieldtype='C' style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CCDATSCA' id='OXFYJQLTDL' type='text' class='"+status.ObligatoryClass("Field",BO.OXFYJQLTDL_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_CCDATSCA,"C",7,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='7' size='7' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PBHNLOUBML_DIV' style='display:none'>" +
       "<label id='PBHNLOUBML' for='UTUCDPQJKK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("IBAN per Bonifici:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BTZLLSBMCC_DIV' style='display:none'>" +
       "<label id='BTZLLSBMCC' for='KZWBLPQNHU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Numero Assegno:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CQTMIXIELC_DIV' style='display:none'>" +
       "<label id='CQTMIXIELC' for='FKEAKFSYVU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Ultime Cifre CC:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HKREYYVVOP_DIV' style='display:none'>" +
       "<label id='HKREYYVVOP' for='OXFYJQLTDL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Scadenza:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Operazione@BEGIN") || status.HasZoneAltInterface("Operazione@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b1_CloseBand(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Operazione@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Operazione")) {
      status.out.println("Ctrl('YORQOIOBQN').style.height='auto';");
    } else {
      status.out.println("Ctrl('YORQOIOBQN').setAttribute('band_height',294);");
    }
    status.out.println("Ctrl('YORQOIOBQN').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['YORQOIOBQN']=['AAHJPBZVGL'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_AQSQVBKXAL")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_AQSQVBKXAL' style='position:relative;height:2px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_AQSQVBKXAL")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_AQSQVBKXAL').style.height='auto';");
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
  void WriteControls_p1_b3(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Soggetto' id='AQSQVBKXAL_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='AQSQVBKXAL_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='AQSQVBKXAL_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Soggetto")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='AQSQVBKXAL_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"AQSQVBKXAL\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=AQSQVBKXAL_HEADER&m_cBoxId=AQSQVBKXAL&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Soggetto"))+"");
    }
    status.out.println(
     "<div id='AQSQVBKXAL' class='CollapsibleBody' style='position:relative;height:289px;display:block'>" +
    "");
    status.includeZoneAltInterface("Soggetto@BEGIN");
    if (status.includeZoneAltInterface("Soggetto")) {
      WriteControls_p1_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Soggetto@BEGIN") || status.HasZoneAltInterface("Soggetto@END")) {
        status.out.println(
         "<div id='AQSQVBKXAL_boxContent' style='position:relative;height:289px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='CZTHKEDVCO_DIV'>" +
       "<input name='CFESTERO' id='CZTHKEDVCO' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_CFESTERO,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_CFESTERO)?"CHECKED":"")+">" +
       "<label id='CZTHKEDVCO_LBL' for='CZTHKEDVCO' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Soggetto Estero"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODFISC' id='OJJHIUDPFY' type='text' class='"+status.ObligatoryClass("Field",BO.OJJHIUDPFY_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_CODFISC,"C",16,0,"!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='COGNOME' id='TWTTDWKCRG' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_COGNOME,"C",26,0,"!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='26' size='26' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NOME' id='WWGIVGNUDW' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_NOME,"C",25,0,"!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NASCOMUN' id='NEUBQNUEOJ' type='text' class='"+status.ObligatoryClass("Field",BO.NEUBQNUEOJ_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_NASCOMUN,"C",30,0,"!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C' autocomplete='off'>" +
       "<button id='NEUBQNUEOJ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "NEUBQNUEOJ", "tbcitta", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='TIPINTER' id='KPSCOABZLB' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_TIPINTER,"C",2,0,"!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='SESSO' id='QPALJZMFCL' class='"+status.ObligatoryClass("Combobox")+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_SESSO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Maschile")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_SESSO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Femminile")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('QPALJZMFCL'),w_SESSO,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NASSTATO' id='HODZKKOSYW' type='text' class='"+status.ObligatoryClass("Field",BO.HODZKKOSYW_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_NASSTATO,"C",30,0,"!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C' autocomplete='off'>" +
       "<button id='HODZKKOSYW_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "HODZKKOSYW", "tbstati", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATANASC' id='XMGRWGFSFV' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_DATANASC,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='XMGRWGFSFV_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PAESE' id='YVIKEGPYPM' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_PAESE,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C' autocomplete='off'>" +
       "<button id='YVIKEGPYPM_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "YVIKEGPYPM", "tbstati", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DESCCIT' id='ODAYKSRECA' type='text' class='"+status.ObligatoryClass("Field",BO.ODAYKSRECA_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_DESCCIT,"C",40,0,"!", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='40' size='40' fieldtype='C' autocomplete='off'>" +
       "<button id='ODAYKSRECA_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "ODAYKSRECA", "tbcitta", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PROVINCIA' id='NOTZPDMYIA' type='text' class='"+status.ObligatoryClass("Field",BO.NOTZPDMYIA_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_PROVINCIA,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CAP' id='RDAVOEETJG' type='text' class='"+status.ObligatoryClass("Field",BO.RDAVOEETJG_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_CAP,"C",9,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='9' size='9' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DOMICILIO' id='VYLHWTRQNX' type='text' class='"+status.ObligatoryClass("Field",BO.VYLHWTRQNX_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_DOMICILIO,"C",35,0,"!", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='35' size='35' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPODOC' id='MBGANUUHRA' class='"+status.ObligatoryClass("Combobox")+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NUMDOCUM' id='HVEEMUJUUY' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_NUMDOCUM,"C",15,0,"!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATARILASC' id='XHWYGOPPUN' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_DATARILASC,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='XHWYGOPPUN_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAVALI' id='BNWXBPSIDG' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_DATAVALI,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='BNWXBPSIDG_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AUTRILASC' id='HRNCPADUFU' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_AUTRILASC,"C",30,0,"!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='javascript:href_DERAHXASAL()' tabindex='-1' style='display:none' id='DERAHXASAL_HREF'>" +
       "<img id='DERAHXASAL' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/search4.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Recupera dati anagrafici da codice fiscale"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Recupera dati anagrafici da codice fiscale"),"C",0,0)+">" +
       "</a>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WVJSUIKYEY_DIV'>" +
       "<label id='WVJSUIKYEY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Citt� di Nascita:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YXFGMWZGNN_DIV'>" +
       "<label id='YXFGMWZGNN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Numero Doc.:"))+"" +
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
       "<span class='SPLabel' id='WZDAFMDKJE_DIV'>" +
       "<label id='WZDAFMDKJE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Fiscale:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZPQIEJPWJC_DIV'>" +
       "<label id='ZPQIEJPWJC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Autorit� di rilascio:"))+"" +
       "</label>" +
       "</span>" +
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
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato Residenza:"))+"" +
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
       "<span class='SPLabel' id='KRSCDPQZTQ_DIV'>" +
       "<label id='KRSCDPQZTQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Sesso:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XPSQTBKQQZ_DIV'>" +
       "<label id='XPSQTBKQQZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Citt�:"))+"" +
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
       "<span class='SPLabel' id='ESVLUSNYWB_DIV'>" +
       "<label id='ESVLUSNYWB'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_dessta)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UYGHJPRVKH_DIV'>" +
       "<label id='UYGHJPRVKH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Fine Validit�:"))+"" +
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
       "<a href='javascript:href_RQVPEKINIU()' tabindex='-1' style='display:none' id='RQVPEKINIU_HREF'>" +
       "<img id='RQVPEKINIU' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/search4.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Recupera dati anagrafici da codice fiscale"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Recupera dati anagrafici da codice fiscale"),"C",0,0)+">" +
       "</a>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NUMTEL' id='KSZEHVQAGY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NUMTEL,"C",20,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='20' size='20' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FTGPYDFDAY_DIV'>" +
       "<label id='FTGPYDFDAY' for='KSZEHVQAGY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Numero Telefono:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Soggetto@BEGIN") || status.HasZoneAltInterface("Soggetto@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b3_CloseBand(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Soggetto@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Soggetto")) {
      status.out.println("Ctrl('AQSQVBKXAL').style.height='auto';");
    } else {
      status.out.println("Ctrl('AQSQVBKXAL').setAttribute('band_height',289);");
    }
    status.out.println("Ctrl('AQSQVBKXAL').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b4(armt_cgo_oper_storicoBO BO,ServletStatus status) {
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
  void WriteControls_p2_b0(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='position:relative;height:477px'>" +
    "");
    status.out.println(
     "<div id='XWJLXLYKJC_DIV' class='UntitledBox'>" +
     "<div id='XWJLXLYKJC' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<div id='KUBMCPCHPZ'>" +
    "");
    // GetPortlet_Documenti_Vars()
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars_KUBMCPCHPZ;
    inclusionVars_KUBMCPCHPZ = GetPortlet_KUBMCPCHPZ_Vars(BO,status);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.setAttributes(status.request,inclusionVars_KUBMCPCHPZ);
    String portletUID_KUBMCPCHPZ = com.zucchetti.sitepainter.Library.newCPCCCHK(5);
    com.zucchetti.sitepainter.Library.setAttribute(status.request,"m_cInclusionEntityName",entityGlobals.name);
    com.zucchetti.sitepainter.Library.includeResource(status.request,status.response,"/jsp/pg_allegati_portlet.jsp?ForcedPortletUID="+ portletUID_KUBMCPCHPZ+"&" + com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildQueryString(inclusionVars_KUBMCPCHPZ),true);
    status.out.println(
     "<script>" +
     "GetPortletInEntity.portlets.KUBMCPCHPZ='"+portletUID_KUBMCPCHPZ+"';" +
     "w_PrtDocAll=ZtVWeb.getPortletById('"+portletUID_KUBMCPCHPZ+"');" +
     "</script>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  static void PrintState(armt_cgo_oper_storicoBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_cgo_oper_storicoBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
    if (BO.ardt_cgo_oper_storico_multi.IsUpdated()) {
      BO.m_cWv_ardt_cgo_oper_storico_multi = BO.ardt_cgo_oper_storico_multi.GetContext();
    }
  }
  static void PrintStateWorkVars(armt_cgo_oper_storicoBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_CGOTIPOPE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAIDBIGLIETTO,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAOPE,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGCONT,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CACODICE,"N",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAFLGOPE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TOTLIRE,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_TOTCONT,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_CGOFLGVLT,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CGOFLGVNP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MEZPAGAM,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CFESTERO,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODFISC,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_COGNOME,"C",26,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOME,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NASCOMUN,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPINTER,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SESSO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NASSTATO,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATANASC,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PAESE,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCCIT,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINCIA,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAP,"C",9,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DOMICILIO,"C",35,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPODOC,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMDOCUM,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATARILASC,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAVALI,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AUTRILASC,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ATTIV,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOPERS,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAGSOC,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOTGRUP,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAMOGRUP,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SETTSINT,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SNAINUMOPE,"C",15,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_SNAINUMOPE:BO.w_SNAINUMOPE,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAREG,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOOPRAP,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODANA,"C",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODVOC,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VALUTA,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAMBIO,"N",9,4));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNESCLI,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNESBEN,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C_RAG,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C_CTA,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C_PRV,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C_CAP,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C_CAB,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C_IND,"C",35,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C_STA,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODINTER,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODDIPE,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCCITDIP,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SEGNO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGFRAZ,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_COLLEG,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINCIADIP,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODCABDIP,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODCAB,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PEP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VLTPLAT,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOGIOCO,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ASSEGNO,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IBAN,"C",27,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CC4CIFRE,"C",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CCDATSCA,"C",7,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMTEL,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDDOCALL,"C",36,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGDOCALL,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xSOGTPGIO,"N",12,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDEFTPGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xEDTTPGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dessta,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipsot,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_STATOREG,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMPROG,"C",7,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCRI,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gSeekAos,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gDataVaria,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgDoc,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gIntemediario,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDescDipe,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_datpaseuro,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdes1,"C",90,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_desccauana,"C",165,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CITINT,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CITDIP,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVDIP,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CABDIP,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINT,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CABINT,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesccausin,"C",165,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gChkDate,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_idcitta,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesctipatt,"C",250,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gVLT,"N",10,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_gVNP,"N",10,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_gCodDip,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gStpDwn,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MIDBIGLIETTO,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xFLGPLGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDEFSPGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xEDTSPGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gGesDoc,"C",1,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_codazi:BO.m_Ctx.GetCompany(),"C",10,0));
    if (CPLib.eq(BO.m_cWv_ardt_cgo_oper_storico_multi,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_cgo_oper_storico_multi");
    } else if (CPLib.eq(BO.m_cWv_ardt_cgo_oper_storico_multi,"_not_empty_")) {
      BO.m_cWv_ardt_cgo_oper_storico_multi = BO.ardt_cgo_oper_storico_multi.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_cgo_oper_storico_multi,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_cgo_oper_storico_multi,"C",0,0));
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_BLXOBUQVYE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_THOGQCLBJA = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
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
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(733,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_cgo_oper_storico"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'NEUBQNUEOJ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NEUBQNUEOJ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'HODZKKOSYW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"HODZKKOSYW",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'YVIKEGPYPM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"YVIKEGPYPM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'ODAYKSRECA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ODAYKSRECA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'MBGANUUHRA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"MBGANUUHRA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_tipdoc,"+"default",l_session)+"'"+"]");
      status.out.print(",'SAQTIHOALW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SAQTIHOALW",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipatt,"+"default",l_session)+"'"+"]");
      status.out.print(",'UJRFWINIVQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"UJRFWINIVQ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipreg,"+"default",l_session)+"'"+"]");
      status.out.print(",'SQVJLYRFKQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SQVJLYRFKQ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcauana,"+"default",l_session)+"'"+"]");
      status.out.print(",'SRWWPHPCUB':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SRWWPHPCUB",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcauana,"+"default",l_session)+"'"+"]");
      status.out.print(",'ULVCBLFVEU':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ULVCBLFVEU",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'KUPRRTVLKH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"KUPRRTVLKH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'WJSVGWKSFC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"WJSVGWKSFC",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,intermbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'AVHTGZTOSZ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"AVHTGZTOSZ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'MSGBKOOAOY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"MSGBKOOAOY",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,operazbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'LKEDJRUQJU':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"LKEDJRUQJU",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcausin,"+"default",l_session)+"'"+"]");
      status.out.print(",'XPSJTIMTNR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"XPSJTIMTNR",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'LVYFMQXNZH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"LVYFMQXNZH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_vltplat,"+"default",l_session)+"'"+"]");
      status.out.print(",'DKNVEJCFAA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"DKNVEJCFAA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_tbtipgio,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'NEUBQNUEOJ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'HODZKKOSYW':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'YVIKEGPYPM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'ODAYKSRECA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'MBGANUUHRA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_tipdoc,"+"default",l_session)+"'"+"]");
      status.out.print(",'SAQTIHOALW':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipatt,"+"default",l_session)+"'"+"]");
      status.out.print(",'UJRFWINIVQ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipreg,"+"default",l_session)+"'"+"]");
      status.out.print(",'SQVJLYRFKQ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcauana,"+"default",l_session)+"'"+"]");
      status.out.print(",'SRWWPHPCUB':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcauana,"+"default",l_session)+"'"+"]");
      status.out.print(",'ULVCBLFVEU':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'KUPRRTVLKH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'WJSVGWKSFC':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,intermbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'AVHTGZTOSZ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'MSGBKOOAOY':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,operazbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'LKEDJRUQJU':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcausin,"+"default",l_session)+"'"+"]");
      status.out.print(",'XPSJTIMTNR':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'LVYFMQXNZH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_vltplat,"+"default",l_session)+"'"+"]");
      status.out.print(",'DKNVEJCFAA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_tbtipgio,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_cgo_oper_storico","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_cgo_oper_storico",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("box_CCUOYXMBZC"),"")) {
      status.quoteAndAppend("box_CCUOYXMBZC","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Operazione"),"")) {
      status.quoteAndAppend("Operazione","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Soggetto"),"")) {
      status.quoteAndAppend("Soggetto","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_XWJLXLYKJC"),"")) {
      status.quoteAndAppend("box_XWJLXLYKJC","hide","box");
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
    status.out.println("// * --- armt_cgo_oper_storico");
    status.out.println("l_bReport=false");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteMainFormScript(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_cgo_oper_storico',false);");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('YLIKFVPZJA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YLIKFVPZJA_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PURPSXEVAI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WJQFIEBCQV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HUAGBHPUNH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HUDOCMLKKT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SFKJNKYLJO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EOSKLIUGBC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CZTHKEDVCO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OJJHIUDPFY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TWTTDWKCRG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WWGIVGNUDW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NEUBQNUEOJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NEUBQNUEOJ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KPSCOABZLB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QPALJZMFCL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HODZKKOSYW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HODZKKOSYW_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XMGRWGFSFV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XMGRWGFSFV_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YVIKEGPYPM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YVIKEGPYPM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ODAYKSRECA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ODAYKSRECA_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NOTZPDMYIA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RDAVOEETJG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VYLHWTRQNX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MBGANUUHRA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HVEEMUJUUY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XHWYGOPPUN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XHWYGOPPUN_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BNWXBPSIDG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BNWXBPSIDG_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HRNCPADUFU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XFUOZLSACP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BSSRUASCBR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KZWBLPQNHU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UTUCDPQJKK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FKEAKFSYVU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OXFYJQLTDL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KSZEHVQAGY')) SetDisabled(c,true);");
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
      status.out.println("if (Ctrl('AAHJPBZVGL')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('AAHJPBZVGL',linkpc_url('AAHJPBZVGL'));");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('XFUOZLSACP')) SetDisabled(c,true);");
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
    status.out.println("if (Eq(name,'ardt_cgo_oper_storico_multi')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_cgo_oper_storico_multi")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    ChildSelectedPageChild(BO.m_MNTs,status,status.m_cSelectedPage);
    status.out.println("}");
    if (CPLib.ne(status.m_cClientMode,"query")) {
      status.out.println("function UpdateAutonumber(p_uid) {");
      if (CPLib.eq(status.m_cClientMode,"new")) {
        status.out.println("var l_b0 = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
        status.out.println("if (Eq(p_uid,'SNAINUMOPE') || Empty(p_uid)) {");
        status.out.println("l_b0= ! (Eq(op_codazi,m_cCompany));");
        status.out.println("}");
      }
      if (CPLib.eq(status.m_cClientMode,"new")) {
        status.out.println("if (l_b0) {");
        status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_SNAINUMOPE','PRGNUMOPE');");
        status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
        status.out.println("AutonumberApplet().SetProg('SNAINUMOPE',w_SNAINUMOPE,op_SNAINUMOPE,'C',15,0);");
        status.out.println("AutonumberApplet().SetETName('cgo_operazioni_dl_multi');");
        status.out.println("w_SNAINUMOPE=AutonumberApplet().GetAutonumberString('SNAINUMOPE');");
        status.out.println("}");
      }
      if (CPLib.eq(status.m_cClientMode,"new")) {
        status.out.println("if (l_b0) {");
        status.out.println("op_codazi=m_cCompany;");
        status.out.println("op_SNAINUMOPE=w_SNAINUMOPE;");
        status.out.println("}");
      }
      status.out.println("}");
    }
    WriteJSError(status);
    WriteTableCombo(status,BO);
    status.out.println("// * --- Area Manuale = UI - Functions & Procedures");
    status.out.println("// * --- armt_cgo_oper_storico");
    status.out.println("function StampaModulo() {");
    status.out.println("  var l_oWv = InitWvApplet();");
    status.out.println("  l_oWv.setValue('w_ATTIV',AsAppletValue(w_ATTIV));");
    status.out.println("  l_oWv.setValue('w_AUTRILASC',AsAppletValue(w_AUTRILASC));");
    status.out.println("  l_oWv.setValue('w_C_CAB',AsAppletValue(w_C_CAB));");
    status.out.println("  l_oWv.setValue('w_C_CAP',AsAppletValue(w_C_CAP));");
    status.out.println("  l_oWv.setValue('w_C_CTA',AsAppletValue(w_C_CTA));");
    status.out.println("  l_oWv.setValue('w_C_IND',AsAppletValue(w_C_IND));");
    status.out.println("  l_oWv.setValue('w_C_PRV',AsAppletValue(w_C_PRV));");
    status.out.println("  l_oWv.setValue('w_C_RAG',AsAppletValue(w_C_RAG));");
    status.out.println("  l_oWv.setValue('w_C_STA',AsAppletValue(w_C_STA));");
    status.out.println("  l_oWv.setValue('w_CABDIP',AsAppletValue(w_CABDIP));");
    status.out.println("  l_oWv.setValue('w_CABINT',AsAppletValue(w_CABINT));");
    status.out.println("  l_oWv.setValue('w_CACODICE',AsAppletValue(w_CACODICE));");
    status.out.println("  l_oWv.setValue('w_CAFLGOPE',AsAppletValue(w_CAFLGOPE));");
    status.out.println("  l_oWv.setValue('w_CAIDBIGLIETTO',AsAppletValue(w_CAIDBIGLIETTO));");
    status.out.println("  l_oWv.setValue('w_CAMBIO',AsAppletValue(w_CAMBIO));");
    status.out.println("  l_oWv.setValue('w_CAP',AsAppletValue(w_CAP));");
    status.out.println("  l_oWv.setValue('w_CFESTERO',AsAppletValue(w_CFESTERO));");
    status.out.println("  l_oWv.setValue('w_CITDIP',AsAppletValue(w_CITDIP));");
    status.out.println("  l_oWv.setValue('w_CITINT',AsAppletValue(w_CITINT));");
    status.out.println("  l_oWv.setValue('w_CODANA',AsAppletValue(w_CODANA));");
    status.out.println("  l_oWv.setValue('w_CODCAB',AsAppletValue(w_CODCAB));");
    status.out.println("  l_oWv.setValue('w_CODCABDIP',AsAppletValue(w_CODCABDIP));");
    status.out.println("  l_oWv.setValue('w_CODDIPE',AsAppletValue(w_CODDIPE));");
    status.out.println("  l_oWv.setValue('w_CODFISC',AsAppletValue(w_CODFISC));");
    status.out.println("  l_oWv.setValue('w_CODINTER',AsAppletValue(w_CODINTER));");
    status.out.println("  l_oWv.setValue('w_CODVOC',AsAppletValue(w_CODVOC));");
    status.out.println("  l_oWv.setValue('w_COGNOME',AsAppletValue(w_COGNOME));");
    status.out.println("  l_oWv.setValue('w_COLLEG',AsAppletValue(w_COLLEG));");
    status.out.println("  l_oWv.setValue('w_CONNESBEN',AsAppletValue(w_CONNESBEN));");
    status.out.println("  l_oWv.setValue('w_CONNESCLI',AsAppletValue(w_CONNESCLI));");
    status.out.println("  l_oWv.setValue('w_DATANASC',AsAppletValue(w_DATANASC));");
    status.out.println("  l_oWv.setValue('w_DATAOPE',AsAppletValue(w_DATAOPE));");
    status.out.println("  l_oWv.setValue('w_DATAREG',AsAppletValue(w_DATAREG));");
    status.out.println("  l_oWv.setValue('w_DATARILASC',AsAppletValue(w_DATARILASC));");
    status.out.println("  l_oWv.setValue('w_DATAVALI',AsAppletValue(w_DATAVALI));");
    status.out.println("  l_oWv.setValue('w_DESCCIT',AsAppletValue(w_DESCCIT));");
    status.out.println("  l_oWv.setValue('w_DESCCITDIP',AsAppletValue(w_DESCCITDIP));");
    status.out.println("  l_oWv.setValue('w_DESCRI',AsAppletValue(w_DESCRI));");
    status.out.println("  l_oWv.setValue('w_DOMICILIO',AsAppletValue(w_DOMICILIO));");
    status.out.println("  l_oWv.setValue('w_FLAGCONT',AsAppletValue(w_FLAGCONT));");
    status.out.println("  l_oWv.setValue('w_FLAGFRAZ',AsAppletValue(w_FLAGFRAZ));");
    status.out.println("  l_oWv.setValue('w_IBAN',AsAppletValue(w_IBAN));");
    status.out.println("  l_oWv.setValue('w_IDBASE',AsAppletValue(w_IDBASE));");
    status.out.println("  l_oWv.setValue('w_MEZPAGAM',AsAppletValue(w_MEZPAGAM));");
    status.out.println("  l_oWv.setValue('w_NASCOMUN',AsAppletValue(w_NASCOMUN));");
    status.out.println("  l_oWv.setValue('w_NASSTATO',AsAppletValue(w_NASSTATO));");
    status.out.println("  l_oWv.setValue('w_NOME',AsAppletValue(w_NOME));");
    status.out.println("  l_oWv.setValue('w_NUMDOCUM',AsAppletValue(w_NUMDOCUM));");
    status.out.println("  l_oWv.setValue('w_NUMPROG',AsAppletValue(w_NUMPROG));");
    status.out.println("  l_oWv.setValue('w_PAESE',AsAppletValue(w_PAESE));");
    status.out.println("  l_oWv.setValue('w_PEP',AsAppletValue(w_PEP));");
    status.out.println("  l_oWv.setValue('w_PROVDIP',AsAppletValue(w_PROVDIP));");
    status.out.println("  l_oWv.setValue('w_PROVINCIA',AsAppletValue(w_PROVINCIA));");
    status.out.println("  l_oWv.setValue('w_PROVINCIADIP',AsAppletValue(w_PROVINCIADIP));");
    status.out.println("  l_oWv.setValue('w_PROVINT',AsAppletValue(w_PROVINT));");
    status.out.println("  l_oWv.setValue('w_RAGSOC',AsAppletValue(w_RAGSOC));");
    status.out.println("  l_oWv.setValue('w_RAMOGRUP',AsAppletValue(w_RAMOGRUP));");
    status.out.println("  l_oWv.setValue('w_SEGNO',AsAppletValue(w_SEGNO));");
    status.out.println("  l_oWv.setValue('w_SESSO',AsAppletValue(w_SESSO));");
    status.out.println("  l_oWv.setValue('w_SETTSINT',AsAppletValue(w_SETTSINT));");
    status.out.println("  l_oWv.setValue('w_SNAINUMOPE',AsAppletValue(w_SNAINUMOPE));");
    status.out.println("  l_oWv.setValue('w_SOTGRUP',AsAppletValue(w_SOTGRUP));");
    status.out.println("  l_oWv.setValue('w_STATOREG',AsAppletValue(w_STATOREG));");
    status.out.println("  l_oWv.setValue('w_TIPINTER',AsAppletValue(w_TIPINTER));");
    status.out.println("  l_oWv.setValue('w_TIPODOC',AsAppletValue(w_TIPODOC));");
    status.out.println("  l_oWv.setValue('w_TIPOOPRAP',AsAppletValue(w_TIPOOPRAP));");
    status.out.println("  l_oWv.setValue('w_TIPOPERS',AsAppletValue(w_TIPOPERS));");
    status.out.println("  l_oWv.setValue('w_TOTCONT',AsAppletValue(w_TOTCONT));  ");
    status.out.println("  l_oWv.setValue('w_TOTLIRE',AsAppletValue(w_TOTLIRE));");
    status.out.println("  l_oWv.setValue('w_MIDBIGLIETTO',AsAppletValue(w_MIDBIGLIETTO));  ");
    status.out.println("  l_oWv.setValue('m_cParameterSequence',AsAppletValue('w_ATTIV,w_AUTRILASC,w_C_CAB,w_C_CAP,w_C_CTA,w_C_IND,w_C_PRV,w_C_RAG,w_C_STA,w_CABDIP,w_CABINT,w_CACODICE,w_CAFLGOPE,w_CAIDBIGLIETTO,w_CAMBIO,w_CAP,w_CFESTERO,w_CITDIP,w_CITINT,w_CODANA,w_CODCAB,w_CODCABDIP,w_CODDIPE,w_CODFISC,w_CODINTER,w_CODVOC,w_COGNOME,w_COLLEG,w_CONNESBEN,w_CONNESCLI,w_DATANASC,w_DATAOPE,w_DATAREG,w_DATARILASC,w_DATAVALI,w_DESCCIT,w_DESCCITDIP,w_DESCRI,w_DOMICILIO,w_FLAGCONT,w_FLAGFRAZ,w_IBAN,w_IDBASE,w_MEZPAGAM,w_NASCOMUN,w_NASSTATO,w_NOME,w_NUMDOCUM,w_NUMPROG,w_PAESE,w_PEP,w_PROVDIP,w_PROVINCIA,w_PROVINCIADIP,w_PROVINT,w_RAGSOC,w_RAMOGRUP,w_SEGNO,w_SESSO,w_SETTSINT,w_SNAINUMOPE,w_SOTGRUP,w_STATOREG,w_TIPINTER,w_TIPODOC,w_TIPOOPRAP,w_TIPOPERS,w_TOTCONT,w_TOTLIRE,w_MIDBIGLIETTO'));");
    status.out.println("  if (w_gStpDwn=='N') {");
    status.out.println("    _modifyandopen('arrt_cgo_moduli'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','toolbar=0,menubar=0,directories=0,width=640,height=480,resizable=1,scrollbars=yes',null)");
    status.out.println("  } else {");
    status.out.println("    SetLocationHref(null,'arrt_cgo_moduli'+'?m_cWv='+URLenc(l_oWv.asString())+'&m_cAction=start&m_cAtExit=close&m_cMode=hyperlink','elabgen')");
    status.out.println("  }");
    status.out.println("}");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  armt_cgo_oper_storicoBO getBO(ServletStatus status) {
    armt_cgo_oper_storicoBO BO = new armt_cgo_oper_storicoBO(status.context);
    // gli op_ possono essere utilizzati dalla servlet anche prima di essere inizializzati
    BO.op_SNAINUMOPE = BO.w_SNAINUMOPE;
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_cgo_oper_storicoBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("cgo_operazioni_dl_multi",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_cgo_oper_storicoBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_cgo_oper_storicoBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_cgo_tipdoc,CPSql.BuildSQLPhrase("TIPDOC,DESCRI",BO.m_cPhName_cgo_tipdoc,"","DESCRI"));
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
    l_cTmp = "[";
    VQRHolder l_VQRHolder=null;
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_cgo_tbtipatt",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),BO,false);
    l_VQRHolder.LoadTempWhere("");
    l_rsLoad = l_VQRHolder.GetResultSet(BO.m_Ctx);
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",10,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("CODICE"),"C",10,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var SAQTIHOALW_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_cgo_vltplat,CPSql.BuildSQLPhrase("VPCODICE,VPDESCRI",BO.m_cPhName_cgo_vltplat,"",""));
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",2,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("VPCODICE"),"C",2,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("VPDESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var LVYFMQXNZH_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_cgo_tbtipgio,CPSql.BuildSQLPhrase("CODTPGIO,DESTPGIO",BO.m_cPhName_cgo_tbtipgio,"",""));
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",3,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("CODTPGIO"),"C",3,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESTPGIO"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var DKNVEJCFAA_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_cgo_operazioni_dl_multi;
    String l_cPhName = BO.m_cPhName_cgo_operazioni_dl_multi;
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altres� come
    // parametro la clausola di "order by".
    // * --- Area Manuale = BO - Query Key Set Init
    // * --- Fine Area Manuale
    int l_nIdx;
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_cgo_oper_storicoBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_cgo_operazioni_dl_multi+".SNAINUMOPE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("cgo_operazioni_dl_multi");
    String l_cPhName = CPSql.ManipulateTablePhName("cgo_operazioni_dl_multi",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altres� come
    // parametro la clausola di "order by".
    CPResultSet l_rsKeys=null;
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      String l_cLastWhere = status.m_cLastWhere;
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+l_cPhName+".SNAINUMOPE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
    }
    return l_rsKeys;
  }
  void Query(ServletStatus status,armt_cgo_oper_storicoBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_cgo_oper_storicoBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_cgo_operazioni_dl_multi,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_cgo_operazioni_dl_multi,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_cgo_oper_storicoBO BO) {
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
  void Edit(ServletStatus status,armt_cgo_oper_storicoBO BO,SPParameterSource source) {
    BO.Load(status.w_SNAINUMOPE);
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
  void New(ServletStatus status,armt_cgo_oper_storicoBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_cgo_oper_storicoBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_cgo_oper_storicoBO BO) {
    // Dichiarazione del cursore locale del link
    CPResultSet l_rsKeys=null;
    l_rsKeys = QueryKeyCursor(BO,status);
    try {
      if (l_rsKeys.Eof()) {
        BO.Blank();
        status.w_SNAINUMOPE = "";
      } else {
        BO.w_SNAINUMOPE = l_rsKeys.GetString("SNAINUMOPE");
        // Ottimizzazione: liberata connessione database prima di eseguire la Load
        l_rsKeys.Close();
        BO.Load();
        status.w_SNAINUMOPE = BO.w_SNAINUMOPE;
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
  void EditLoad(ServletStatus status,armt_cgo_oper_storicoBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_cgo_oper_storicoBO BO,SPParameterSource source) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    // alla fine del metodo controllo se devo rispondere a JSURL
    boolean l_bBringBack = CPLib.eq(status.m_cMode,"hyperlink");
    if (HasAllKeys(status,source)) {
      BO.m_Sql.BeginTransaction();
      // la funzione CanDelete viene gestita dal BO
      l_bResult = BO.Delete(status.w_SNAINUMOPE);
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
  void DeleteMessage(ServletStatus status,armt_cgo_oper_storicoBO BO,SPParameterSource source) {
    BO.Load(status.w_SNAINUMOPE);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_cgo_oper_storicoBO BO) {
    boolean l_bResult = false;
    String l_cTrsMsgErr = "";
    boolean l_bTrsOk = true;
    String l_cTransMsgErr = "";
    BO.SetFromContext(status.m_cWv,status.m_Parameters);
    String l_old_SNAINUMOPE = "";
    if (CPLib.ne(BO.w_SNAINUMOPE,BO.op_SNAINUMOPE)) {
      l_old_SNAINUMOPE = BO.op_SNAINUMOPE;
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({SNAINUMOPE:"+SPLib.ToJSValue(BO.w_SNAINUMOPE,"C",15,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
      if ( ! (CPLib.Empty(l_old_SNAINUMOPE))) {
        BO.op_SNAINUMOPE = l_old_SNAINUMOPE;
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
  void Discard(ServletStatus status,armt_cgo_oper_storicoBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_cgo_oper_storicoBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",693);
    item.put("w",797);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","true");
    org.json.JSONObject pageProp = null;
    org.json.JSONArray pagesProp = null;
    pagesProp = new org.json.JSONArray();
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Dati Operazione\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Documenti\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Dati Operazione,Documenti");
    item.put("altInterfaceFor","armt_cgo_oper_storico");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Operazione\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Dati Operazione\",\"h\":294,\"name\":\"Operazione\",\"page\":1,\"shrinkable\":true,\"spuid\":\"YORQOIOBQN\",\"tabindex\":2,\"title_caption\":\"Dati Operazione\",\"titled\":true,\"type\":\"Box\",\"w\":784,\"x\":8,\"y\":103,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Operazione\",\"h\":20,\"maxlength\":10,\"name\":\"DATAOPE\",\"page\":1,\"picker\":true,\"spuid\":\"YLIKFVPZJA\",\"tabindex\":9,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":88,\"x\":136,\"y\":110,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero Progressivo\",\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"NUMPROG\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"XYMCLUECBD\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":88,\"x\":392,\"y\":110,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KDUGHGZUUG\",\"page\":1,\"spuid\":\"KDUGHGZUUG\",\"tabindex\":71,\"type\":\"Label\",\"value\":\"Numero Progressivo:\",\"w\":117,\"x\":272,\"y\":114,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HVHVAYPDJE\",\"page\":1,\"spuid\":\"HVHVAYPDJE\",\"tabindex\":73,\"type\":\"Label\",\"value\":\"Data Ticket:\",\"w\":95,\"x\":38,\"y\":114,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data registrazione\",\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"DATAREG\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"OEIKQOZMYJ\",\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":704,\"y\":109,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IKBMEWKQJW\",\"page\":1,\"spuid\":\"IKBMEWKQJW\",\"tabindex\":79,\"type\":\"Label\",\"value\":\"Data registrazione:\",\"w\":104,\"x\":600,\"y\":113,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Contanti (S\\/N)\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"FLAGCONT\",\"page\":1,\"spuid\":\"PURPSXEVAI\",\"tabindex\":10,\"textlist\":\"No,Si\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"0"+"'"+","+"'"+"1"+"'"+"\",\"w\":104,\"x\":136,\"y\":138,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GVTXMEILAZ\",\"page\":1,\"spuid\":\"GVTXMEILAZ\",\"tabindex\":78,\"type\":\"Label\",\"value\":\"Contanti:\",\"w\":80,\"x\":53,\"y\":142,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Causale\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":6,\"name\":\"CACODICE\",\"page\":1,\"spuid\":\"WJQFIEBCQV\",\"tabindex\":11,\"textlist\":\"Emissione Biglietti,Pagamento Biglietti\",\"type\":\"Combobox\",\"typevar\":\"numeric\",\"valuelist\":\"1,3\",\"w\":440,\"x\":136,\"y\":166,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Registrazione\",\"disabled\":\"true\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"CAFLGOPE\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"YJDISDDJUY\",\"textlist\":\"Giocata,Versamento,Vincita,Prelievo\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"G"+"'"+","+"'"+"R"+"'"+","+"'"+"V"+"'"+","+"'"+"P"+"'"+"\",\"w\":112,\"x\":584,\"y\":166,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo Operazione Completa\",\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"TIPOOPRAP\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"UJRFWINIVQ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":392,\"y\":138,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KMCNAWQHKV\",\"page\":1,\"spuid\":\"KMCNAWQHKV\",\"tabindex\":80,\"type\":\"Label\",\"value\":\"Tipo Operazione:\",\"w\":104,\"x\":288,\"y\":142,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_THOGQCLBJA\",\"page\":1,\"spuid\":\"THOGQCLBJA\",\"tabindex\":89,\"type\":\"Label\",\"w\":361,\"x\":423,\"y\":142,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YFGRJCQGZV\",\"page\":1,\"spuid\":\"YFGRJCQGZV\",\"tabindex\":138,\"type\":\"Label\",\"value\":\"Causale:\",\"w\":42,\"x\":91,\"y\":170,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":117,\"name\":\"ardt_cgo_oper_storico_multi\",\"page\":1,\"spuid\":\"AAHJPBZVGL\",\"tabindex\":12,\"type\":\"Iframe\",\"w\":493,\"x\":152,\"y\":194,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Totale Operazione\",\"h\":20,\"maxlength\":21,\"name\":\"TOTLIRE\",\"page\":1,\"spuid\":\"HUAGBHPUNH\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":120,\"x\":136,\"y\":317,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XLNVLBYVQX\",\"page\":1,\"spuid\":\"XLNVLBYVQX\",\"tabindex\":82,\"type\":\"Label\",\"value\":\"Totale Euro:\",\"w\":95,\"x\":38,\"y\":321,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"di cui contanti\",\"h\":20,\"maxlength\":21,\"name\":\"TOTCONT\",\"page\":1,\"spuid\":\"HUDOCMLKKT\",\"tabindex\":15,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":120,\"x\":560,\"y\":317,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IDTBMNCIOX\",\"page\":1,\"spuid\":\"IDTBMNCIOX\",\"tabindex\":83,\"type\":\"Label\",\"value\":\"di cui contanti:\",\"w\":78,\"x\":480,\"y\":321,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Pagamento VLT\",\"h\":19,\"maxlength\":1,\"name\":\"CGOFLGVLT\",\"orientation\":\"horizontal\",\"page\":1,\"spuid\":\"SFKJNKYLJO\",\"tabindex\":16,\"type\":\"Radio\",\"typevar\":\"character\",\"w\":288,\"x\":136,\"y\":346,\"zone\":\"pag1_1_8\",\"zonepath\":\"[1,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LKYFODKVBU\",\"page\":1,\"spuid\":\"LKYFODKVBU\",\"tabindex\":110,\"type\":\"Label\",\"value\":\"Pagamento da parte di:\",\"w\":124,\"x\":9,\"y\":350,\"zone\":\"pag1_1_8\",\"zonepath\":\"[1,1,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Mezzo Pagamento\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"MEZPAGAM\",\"page\":1,\"spuid\":\"EOSKLIUGBC\",\"tabindex\":18,\"textlist\":\"Altro Mezzo,Bonifico Italia,Bonifico Estero,Bonifico Postale,Assegno Circolare,Assegno Bancario,Carta di Credito,Contante\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"A"+"'"+","+"'"+"I"+"'"+","+"'"+"E"+"'"+","+"'"+"P"+"'"+","+"'"+"C"+"'"+","+"'"+"B"+"'"+","+"'"+"V"+"'"+","+"'"+"S"+"'"+"\",\"w\":224,\"x\":136,\"y\":370,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VQCVMXHDPB\",\"page\":1,\"spuid\":\"VQCVMXHDPB\",\"tabindex\":108,\"type\":\"Label\",\"value\":\"Mezzo Pagamento:\",\"w\":120,\"x\":16,\"y\":374,\"zone\":\"pag1_1_9\",\"zonepath\":\"[1,1,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Assegno\",\"h\":20,\"maxlength\":25,\"name\":\"ASSEGNO\",\"page\":1,\"spuid\":\"KZWBLPQNHU\",\"tabindex\":148,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":224,\"x\":560,\"y\":370,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"IBAN per Bonifici\",\"h\":20,\"maxlength\":27,\"name\":\"IBAN\",\"page\":1,\"spuid\":\"UTUCDPQJKK\",\"tabindex\":149,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":224,\"x\":560,\"y\":370,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Ultime Cifre CC\",\"h\":20,\"maxlength\":4,\"name\":\"CC4CIFRE\",\"page\":1,\"spuid\":\"FKEAKFSYVU\",\"tabindex\":150,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":36,\"x\":560,\"y\":370,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Scadenza\",\"h\":20,\"maxlength\":7,\"name\":\"CCDATSCA\",\"page\":1,\"spuid\":\"OXFYJQLTDL\",\"tabindex\":151,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":64,\"x\":704,\"y\":370,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PBHNLOUBML\",\"page\":1,\"spuid\":\"PBHNLOUBML\",\"tabindex\":152,\"type\":\"Label\",\"value\":\"IBAN per Bonifici:\",\"w\":144,\"x\":411,\"y\":374,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BTZLLSBMCC\",\"page\":1,\"spuid\":\"BTZLLSBMCC\",\"tabindex\":153,\"type\":\"Label\",\"value\":\"Numero Assegno:\",\"w\":93,\"x\":462,\"y\":374,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CQTMIXIELC\",\"page\":1,\"spuid\":\"CQTMIXIELC\",\"tabindex\":154,\"type\":\"Label\",\"value\":\"Ultime Cifre CC:\",\"w\":83,\"x\":475,\"y\":374,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HKREYYVVOP\",\"page\":1,\"spuid\":\"HKREYYVVOP\",\"tabindex\":155,\"type\":\"Label\",\"value\":\"Scadenza:\",\"w\":55,\"x\":649,\"y\":374,\"zone\":\"pag1_1_10\",\"zonepath\":\"[1,1,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Soggetto\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Dati Soggetto\",\"h\":289,\"name\":\"Soggetto\",\"page\":1,\"shrinkable\":true,\"spuid\":\"AQSQVBKXAL\",\"tabindex\":3,\"title_caption\":\"Dati Soggetto\",\"titled\":true,\"type\":\"Box\",\"w\":784,\"x\":8,\"y\":399,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Codice Fiscale Estero\",\"h\":21,\"label_text\":\"Soggetto Estero\",\"maxlength\":2,\"name\":\"CFESTERO\",\"page\":1,\"spuid\":\"CZTHKEDVCO\",\"tabindex\":19,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":575,\"x\":136,\"y\":405,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"Codice Fiscale\",\"h\":20,\"maxlength\":16,\"name\":\"CODFISC\",\"page\":1,\"spuid\":\"OJJHIUDPFY\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":128,\"x\":136,\"y\":437,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cognome\",\"h\":20,\"maxlength\":26,\"name\":\"COGNOME\",\"page\":1,\"spuid\":\"TWTTDWKCRG\",\"tabindex\":21,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":176,\"x\":392,\"y\":437,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome\",\"h\":20,\"maxlength\":25,\"name\":\"NOME\",\"page\":1,\"spuid\":\"WWGIVGNUDW\",\"tabindex\":22,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":168,\"x\":616,\"y\":437,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Recupera dati anagrafici da codice fiscale\",\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_DERAHXASAL\",\"page\":1,\"spuid\":\"DERAHXASAL\",\"src\":\"..\\/images\\/search4.gif\",\"tabindex\":115,\"type\":\"Image\",\"w\":21,\"x\":268,\"y\":437,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WZDAFMDKJE\",\"page\":1,\"spuid\":\"WZDAFMDKJE\",\"tabindex\":120,\"type\":\"Label\",\"value\":\"Codice Fiscale:\",\"w\":85,\"x\":48,\"y\":441,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TVSLWOCERI\",\"page\":1,\"spuid\":\"TVSLWOCERI\",\"tabindex\":134,\"type\":\"Label\",\"value\":\"Cognome:\",\"w\":56,\"x\":333,\"y\":441,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KUPYKSUBXV\",\"page\":1,\"spuid\":\"KUPYKSUBXV\",\"tabindex\":135,\"type\":\"Label\",\"value\":\"Nome:\",\"w\":35,\"x\":580,\"y\":441,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Luogo di Nascita\",\"h\":20,\"maxlength\":30,\"name\":\"NASCOMUN\",\"page\":1,\"picker\":true,\"spuid\":\"NEUBQNUEOJ\",\"tabindex\":23,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":222,\"x\":136,\"y\":469,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Prov.\",\"h\":20,\"maxlength\":2,\"name\":\"TIPINTER\",\"page\":1,\"spuid\":\"KPSCOABZLB\",\"tabindex\":24,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":440,\"y\":469,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Sesso\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"SESSO\",\"page\":1,\"spuid\":\"QPALJZMFCL\",\"tabindex\":25,\"textlist\":\"Maschile,Femminile\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":88,\"x\":560,\"y\":469,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WVJSUIKYEY\",\"page\":1,\"spuid\":\"WVJSUIKYEY\",\"tabindex\":117,\"type\":\"Label\",\"value\":\"Citt\\u00E0 di Nascita:\",\"w\":101,\"x\":32,\"y\":473,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KRSCDPQZTQ\",\"page\":1,\"spuid\":\"KRSCDPQZTQ\",\"tabindex\":128,\"type\":\"Label\",\"value\":\"Sesso:\",\"w\":39,\"x\":519,\"y\":473,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IVAWYVSUQI\",\"page\":1,\"spuid\":\"IVAWYVSUQI\",\"tabindex\":130,\"type\":\"Label\",\"value\":\"Prov.:\",\"w\":32,\"x\":408,\"y\":473,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Stato di nascita\",\"h\":20,\"maxlength\":30,\"name\":\"NASSTATO\",\"page\":1,\"picker\":true,\"spuid\":\"HODZKKOSYW\",\"tabindex\":26,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":222,\"x\":136,\"y\":501,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZBRDCBHLZC\",\"page\":1,\"spuid\":\"ZBRDCBHLZC\",\"tabindex\":133,\"type\":\"Label\",\"value\":\"Stato di Nascita:\",\"w\":101,\"x\":32,\"y\":505,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Nascita\",\"h\":20,\"maxlength\":10,\"name\":\"DATANASC\",\"page\":1,\"picker\":true,\"spuid\":\"XMGRWGFSFV\",\"tabindex\":27,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":86,\"x\":560,\"y\":501,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HZYTDOZFPI\",\"page\":1,\"spuid\":\"HZYTDOZFPI\",\"tabindex\":119,\"type\":\"Label\",\"value\":\"Data Nascita:\",\"w\":74,\"x\":483,\"y\":505,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Recupera dati anagrafici da codice fiscale\",\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_RQVPEKINIU\",\"page\":1,\"spuid\":\"RQVPEKINIU\",\"src\":\"..\\/images\\/search4.gif\",\"tabindex\":137,\"type\":\"Image\",\"w\":21,\"x\":672,\"y\":501,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Stato\",\"h\":20,\"maxlength\":3,\"name\":\"PAESE\",\"page\":1,\"picker\":true,\"spuid\":\"YVIKEGPYPM\",\"tabindex\":28,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":136,\"y\":533,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RZBLEGCFJJ\",\"page\":1,\"spuid\":\"RZBLEGCFJJ\",\"tabindex\":123,\"type\":\"Label\",\"value\":\"Stato Residenza:\",\"w\":108,\"x\":24,\"y\":538,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_ESVLUSNYWB\",\"page\":1,\"spuid\":\"ESVLUSNYWB\",\"tabindex\":131,\"type\":\"Label\",\"w\":323,\"x\":203,\"y\":538,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Citt\\u00E0\",\"h\":20,\"maxlength\":40,\"name\":\"DESCCIT\",\"page\":1,\"picker\":true,\"spuid\":\"ODAYKSRECA\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":318,\"x\":136,\"y\":565,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia\",\"h\":20,\"maxlength\":2,\"name\":\"PROVINCIA\",\"page\":1,\"spuid\":\"NOTZPDMYIA\",\"tabindex\":30,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":536,\"y\":565,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAP\",\"h\":20,\"maxlength\":9,\"name\":\"CAP\",\"page\":1,\"spuid\":\"RDAVOEETJG\",\"tabindex\":31,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":66,\"x\":608,\"y\":565,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SBJQIAQUCN\",\"page\":1,\"spuid\":\"SBJQIAQUCN\",\"tabindex\":122,\"type\":\"Label\",\"value\":\"Provincia:\",\"w\":52,\"x\":480,\"y\":569,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GDOCAGKROT\",\"page\":1,\"spuid\":\"GDOCAGKROT\",\"tabindex\":125,\"type\":\"Label\",\"value\":\"CAP:\",\"w\":30,\"x\":576,\"y\":569,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XPSQTBKQQZ\",\"page\":1,\"spuid\":\"XPSQTBKQQZ\",\"tabindex\":129,\"type\":\"Label\",\"value\":\"Citt\\u00E0:\",\"w\":70,\"x\":63,\"y\":569,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Indirizzo\",\"h\":20,\"maxlength\":35,\"name\":\"DOMICILIO\",\"page\":1,\"spuid\":\"VYLHWTRQNX\",\"tabindex\":32,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":222,\"x\":136,\"y\":597,\"zone\":\"pag1_2_8\",\"zonepath\":\"[1,2,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TWTXGZJTAR\",\"page\":1,\"spuid\":\"TWTXGZJTAR\",\"tabindex\":124,\"type\":\"Label\",\"value\":\"Indirizzo:\",\"w\":47,\"x\":86,\"y\":601,\"zone\":\"pag1_2_8\",\"zonepath\":\"[1,2,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo Documento\",\"h\":20,\"maxlength\":2,\"name\":\"TIPODOC\",\"page\":1,\"spuid\":\"MBGANUUHRA\",\"tabindex\":33,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":246,\"x\":136,\"y\":629,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YRARWMJPPV\",\"page\":1,\"spuid\":\"YRARWMJPPV\",\"tabindex\":126,\"type\":\"Label\",\"value\":\"Tipo Documento:\",\"w\":95,\"x\":40,\"y\":633,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero Doc.\",\"h\":20,\"maxlength\":15,\"name\":\"NUMDOCUM\",\"page\":1,\"spuid\":\"HVEEMUJUUY\",\"tabindex\":34,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":128,\"x\":560,\"y\":629,\"zone\":\"pag1_2_10\",\"zonepath\":\"[1,2,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YXFGMWZGNN\",\"page\":1,\"spuid\":\"YXFGMWZGNN\",\"tabindex\":118,\"type\":\"Label\",\"value\":\"Numero Doc.:\",\"w\":69,\"x\":488,\"y\":633,\"zone\":\"pag1_2_10\",\"zonepath\":\"[1,2,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Rilascio Doc.\",\"h\":20,\"maxlength\":10,\"name\":\"DATARILASC\",\"page\":1,\"picker\":true,\"spuid\":\"XHWYGOPPUN\",\"tabindex\":35,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":86,\"x\":136,\"y\":661,\"zone\":\"pag1_2_11\",\"zonepath\":\"[1,2,11]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Fine Validit\\u00E0\",\"h\":20,\"maxlength\":10,\"name\":\"DATAVALI\",\"page\":1,\"picker\":true,\"spuid\":\"BNWXBPSIDG\",\"tabindex\":36,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":86,\"x\":344,\"y\":661,\"zone\":\"pag1_2_11\",\"zonepath\":\"[1,2,11]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Autorit\\u00E0 di rilascio\",\"h\":20,\"maxlength\":30,\"name\":\"AUTRILASC\",\"page\":1,\"spuid\":\"HRNCPADUFU\",\"tabindex\":37,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":224,\"x\":560,\"y\":661,\"zone\":\"pag1_2_11\",\"zonepath\":\"[1,2,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZPQIEJPWJC\",\"page\":1,\"spuid\":\"ZPQIEJPWJC\",\"tabindex\":121,\"type\":\"Label\",\"value\":\"Autorit\\u00E0 di rilascio:\",\"w\":100,\"x\":459,\"y\":665,\"zone\":\"pag1_2_11\",\"zonepath\":\"[1,2,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MLJVDLOITR\",\"page\":1,\"spuid\":\"MLJVDLOITR\",\"tabindex\":127,\"type\":\"Label\",\"value\":\"Rilascio Doc.:\",\"w\":101,\"x\":32,\"y\":665,\"zone\":\"pag1_2_11\",\"zonepath\":\"[1,2,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UYGHJPRVKH\",\"page\":1,\"spuid\":\"UYGHJPRVKH\",\"tabindex\":132,\"type\":\"Label\",\"value\":\"Data Fine Validit\\u00E0:\",\"w\":101,\"x\":240,\"y\":665,\"zone\":\"pag1_2_11\",\"zonepath\":\"[1,2,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero Telefono\",\"h\":20,\"maxlength\":20,\"name\":\"NUMTEL\",\"page\":1,\"spuid\":\"KSZEHVQAGY\",\"tabindex\":156,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":132,\"x\":560,\"y\":597,\"zone\":\"pag1_2_12\",\"zonepath\":\"[1,2,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FTGPYDFDAY\",\"page\":1,\"spuid\":\"FTGPYDFDAY\",\"tabindex\":157,\"type\":\"Label\",\"value\":\"Numero Telefono:\",\"w\":94,\"x\":463,\"y\":601,\"zone\":\"pag1_2_12\",\"zonepath\":\"[1,2,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_CCUOYXMBZC\",\"h\":93,\"name\":\"box_CCUOYXMBZC\",\"page\":1,\"shrinkable\":true,\"spuid\":\"CCUOYXMBZC\",\"tabindex\":1,\"type\":\"Box\",\"w\":784,\"x\":8,\"y\":8,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Intermediario\",\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"gIntemediario\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"GXLWKNXGMM\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":96,\"y\":16,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_LOEAMXUYLA\",\"page\":1,\"spuid\":\"LOEAMXUYLA\",\"tabindex\":75,\"type\":\"Label\",\"value\":\"Intermediario:\",\"w\":78,\"x\":16,\"y\":20,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":6,\"name\":\"CODDIPE\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"AVHTGZTOSZ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":224,\"y\":16,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Citt\\u00E0 Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":30,\"name\":\"DESCCITDIP\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"RLUMBFHPUD\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":160,\"x\":480,\"y\":16,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_XVRJYSKGWZ\",\"page\":1,\"spuid\":\"XVRJYSKGWZ\",\"tabindex\":84,\"type\":\"Label\",\"value\":\"Dipen.:\",\"w\":40,\"x\":184,\"y\":20,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_CTLYJMTHDV\",\"page\":1,\"spuid\":\"CTLYJMTHDV\",\"tabindex\":85,\"type\":\"Label\",\"value\":\"Citt\\u00E0:\",\"w\":28,\"x\":453,\"y\":20,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_JWSDOSRGAG\",\"page\":1,\"spuid\":\"JWSDOSRGAG\",\"tabindex\":86,\"type\":\"Label\",\"value\":\"Pr.:\",\"w\":24,\"x\":640,\"y\":20,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_ENBRMMDVUP\",\"page\":1,\"spuid\":\"ENBRMMDVUP\",\"tabindex\":87,\"type\":\"Label\",\"value\":\"CAB:\",\"w\":27,\"x\":695,\"y\":20,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_BLXOBUQVYE\",\"page\":1,\"spuid\":\"BLXOBUQVYE\",\"tabindex\":88,\"type\":\"Label\",\"w\":175,\"x\":277,\"y\":20,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":2,\"name\":\"PROVINCIADIP\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"OJGQABFSYN\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":664,\"y\":16,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAB Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":6,\"name\":\"CODCABDIP\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"OZEOCQRSEQ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":720,\"y\":16,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"N\\u00B0 Operazione\",\"h\":20,\"maxlength\":15,\"name\":\"SNAINUMOPE\",\"page\":1,\"spuid\":\"XFUOZLSACP\",\"tabindex\":53,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":120,\"x\":136,\"y\":48,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GZVEXPFQCZ\",\"page\":1,\"spuid\":\"GZVEXPFQCZ\",\"tabindex\":54,\"type\":\"Label\",\"value\":\"N\\u00B0 Operazione:\",\"w\":104,\"x\":29,\"y\":52,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ID BIGLIETTO\",\"disabled\":\"true\",\"h\":20,\"maxlength\":30,\"name\":\"CAIDBIGLIETTO\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"BMTLGIUQTH\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":504,\"y\":48,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZQBDEYWWMG\",\"page\":1,\"spuid\":\"ZQBDEYWWMG\",\"tabindex\":141,\"type\":\"Label\",\"value\":\"ID BIGLIETTO:\",\"w\":70,\"x\":434,\"y\":52,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NRIPVBSJUQ\",\"page\":1,\"spuid\":\"NRIPVBSJUQ\",\"tabindex\":140,\"type\":\"Label\",\"value\":\"Tipo Gioco:\",\"w\":53,\"x\":83,\"y\":76,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Piattaforma VLT\",\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"VLTPLAT\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"LVYFMQXNZH\",\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":280,\"x\":504,\"y\":72,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DJRHGZHJSR\",\"page\":1,\"spuid\":\"DJRHGZHJSR\",\"tabindex\":143,\"type\":\"Label\",\"value\":\"Tipo Piattaforma:\",\"w\":112,\"x\":392,\"y\":76,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo gioco\",\"disabled\":\"true\",\"h\":20,\"maxlength\":3,\"name\":\"TIPOGIOCO\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"DKNVEJCFAA\",\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":208,\"x\":136,\"y\":72,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_XWJLXLYKJC\",\"h\":464,\"name\":\"box_XWJLXLYKJC\",\"page\":2,\"shrinkable\":true,\"spuid\":\"XWJLXLYKJC\",\"tabindex\":1,\"type\":\"Box\",\"w\":784,\"x\":8,\"y\":8,\"zone\":\"pag2_1\",\"zonepath\":\"[2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":448,\"name\":\"Documenti\",\"page\":2,\"spuid\":\"KUBMCPCHPZ\",\"src\":\"\\/jsp\\/pg_allegati_portlet.jsp?ForcedPortletUID=KUBMCPCHPZ\",\"tabindex\":2,\"type\":\"Portlet\",\"w\":768,\"x\":16,\"y\":16,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_cgo_oper_storicoBO BO,ServletStatus status) {
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
     "<script src='armt_cgo_oper_storico?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_oper_storico_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_oper_storico_edit.js'>" +
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
      status.out.println("w_CGOTIPOPE=a[0];");
      status.out.println("w_CAIDBIGLIETTO=a[1];");
      status.out.println("w_DATAOPE=a[2];");
      status.out.println("w_FLAGCONT=a[3];");
      status.out.println("w_CACODICE=a[4];");
      status.out.println("w_CAFLGOPE=a[5];");
      status.out.println("w_TOTLIRE=a[6];");
      status.out.println("w_TOTCONT=a[7];");
      status.out.println("w_CGOFLGVLT=a[8];");
      status.out.println("w_CGOFLGVNP=a[9];");
      status.out.println("w_MEZPAGAM=a[10];");
      status.out.println("w_CFESTERO=a[11];");
      status.out.println("w_CODFISC=a[12];");
      status.out.println("w_COGNOME=a[13];");
      status.out.println("w_NOME=a[14];");
      status.out.println("w_NASCOMUN=a[15];");
      status.out.println("w_TIPINTER=a[16];");
      status.out.println("w_SESSO=a[17];");
      status.out.println("w_NASSTATO=a[18];");
      status.out.println("w_DATANASC=a[19];");
      status.out.println("w_PAESE=a[20];");
      status.out.println("w_DESCCIT=a[21];");
      status.out.println("w_PROVINCIA=a[22];");
      status.out.println("w_CAP=a[23];");
      status.out.println("w_DOMICILIO=a[24];");
      status.out.println("w_TIPODOC=a[25];");
      status.out.println("w_NUMDOCUM=a[26];");
      status.out.println("w_DATARILASC=a[27];");
      status.out.println("w_DATAVALI=a[28];");
      status.out.println("w_AUTRILASC=a[29];");
      status.out.println("w_ATTIV=a[30];");
      status.out.println("w_TIPOPERS=a[31];");
      status.out.println("w_RAGSOC=a[32];");
      status.out.println("w_SOTGRUP=a[33];");
      status.out.println("w_RAMOGRUP=a[34];");
      status.out.println("w_SETTSINT=a[35];");
      status.out.println("w_SNAINUMOPE=a[36];");
      status.out.println("op_SNAINUMOPE=a[37];");
      status.out.println("w_DATAREG=a[38];");
      status.out.println("w_TIPOOPRAP=a[39];");
      status.out.println("w_CODANA=a[40];");
      status.out.println("w_CODVOC=a[41];");
      status.out.println("w_VALUTA=a[42];");
      status.out.println("w_CAMBIO=a[43];");
      status.out.println("w_CONNESCLI=a[44];");
      status.out.println("w_CONNESBEN=a[45];");
      status.out.println("w_C_RAG=a[46];");
      status.out.println("w_C_CTA=a[47];");
      status.out.println("w_C_PRV=a[48];");
      status.out.println("w_C_CAP=a[49];");
      status.out.println("w_C_CAB=a[50];");
      status.out.println("w_C_IND=a[51];");
      status.out.println("w_C_STA=a[52];");
      status.out.println("w_CODINTER=a[53];");
      status.out.println("w_CODDIPE=a[54];");
      status.out.println("w_DESCCITDIP=a[55];");
      status.out.println("w_SEGNO=a[56];");
      status.out.println("w_FLAGFRAZ=a[57];");
      status.out.println("w_COLLEG=a[58];");
      status.out.println("w_PROVINCIADIP=a[59];");
      status.out.println("w_CODCABDIP=a[60];");
      status.out.println("w_CODCAB=a[61];");
      status.out.println("w_PEP=a[62];");
      status.out.println("w_VLTPLAT=a[63];");
      status.out.println("w_TIPOGIOCO=a[64];");
      status.out.println("w_ASSEGNO=a[65];");
      status.out.println("w_IBAN=a[66];");
      status.out.println("w_CC4CIFRE=a[67];");
      status.out.println("w_CCDATSCA=a[68];");
      status.out.println("w_NUMTEL=a[69];");
      status.out.println("w_IDDOCALL=a[70];");
      status.out.println("w_FLGDOCALL=a[71];");
      status.out.println("w_xSOGTPGIO=a[72];");
      status.out.println("w_xDEFTPGIO=a[73];");
      status.out.println("w_xEDTTPGIO=a[74];");
      status.out.println("w_dessta=a[75];");
      status.out.println("w_tipsot=a[76];");
      status.out.println("w_STATOREG=a[77];");
      status.out.println("w_IDBASE=a[78];");
      status.out.println("w_NUMPROG=a[79];");
      status.out.println("w_DESCRI=a[80];");
      status.out.println("w_gSeekAos=a[81];");
      status.out.println("w_gDataVaria=a[82];");
      status.out.println("w_gFlgDoc=a[83];");
      status.out.println("w_gIntemediario=a[84];");
      status.out.println("w_xDescDipe=a[85];");
      status.out.println("w_datpaseuro=a[86];");
      status.out.println("w_xdes1=a[87];");
      status.out.println("w_desccauana=a[88];");
      status.out.println("w_CITINT=a[89];");
      status.out.println("w_CITDIP=a[90];");
      status.out.println("w_PROVDIP=a[91];");
      status.out.println("w_CABDIP=a[92];");
      status.out.println("w_PROVINT=a[93];");
      status.out.println("w_CABINT=a[94];");
      status.out.println("w_xdesccausin=a[95];");
      status.out.println("w_gChkDate=a[96];");
      status.out.println("w_idcitta=a[97];");
      status.out.println("w_xdesctipatt=a[98];");
      status.out.println("w_gVLT=a[99];");
      status.out.println("w_gVNP=a[100];");
      status.out.println("w_gCodDip=a[101];");
      status.out.println("w_gStpDwn=a[102];");
      status.out.println("w_MIDBIGLIETTO=a[103];");
      status.out.println("w_xFLGPLGIO=a[104];");
      status.out.println("w_xDEFSPGIO=a[105];");
      status.out.println("w_xEDTSPGIO=a[106];");
      status.out.println("w_gGesDoc=a[107];");
      status.out.println("op_codazi=a[108];");
      status.out.println("m_cWv_ardt_cgo_oper_storico_multi=a[109];");
      status.out.println("if (Gt(a.length,110)) {");
      status.out.println("m_cErrorInChild='';");
      status.out.println("}");
      status.out.println("if (Gt(a.length,110)) {");
      status.out.println("o_CGOTIPOPE=w_CGOTIPOPE;");
      status.out.println("o_DATAOPE=w_DATAOPE;");
      status.out.println("o_CACODICE=w_CACODICE;");
      status.out.println("o_COGNOME=w_COGNOME;");
      status.out.println("o_NOME=w_NOME;");
      status.out.println("o_NASCOMUN=w_NASCOMUN;");
      status.out.println("o_TIPINTER=w_TIPINTER;");
      status.out.println("o_NASSTATO=w_NASSTATO;");
      status.out.println("o_PAESE=w_PAESE;");
      status.out.println("o_DATARILASC=w_DATARILASC;");
      status.out.println("o_DATAVALI=w_DATAVALI;");
      status.out.println("o_ATTIV=w_ATTIV;");
      status.out.println("o_SOTGRUP=w_SOTGRUP;");
      status.out.println("o_TIPOOPRAP=w_TIPOOPRAP;");
      status.out.println("o_CODANA=w_CODANA;");
      status.out.println("o_CODVOC=w_CODVOC;");
      status.out.println("o_CONNESBEN=w_CONNESBEN;");
      status.out.println("o_C_CTA=w_C_CTA;");
      status.out.println("o_CODINTER=w_CODINTER;");
      status.out.println("o_CODDIPE=w_CODDIPE;");
      status.out.println("o_COLLEG=w_COLLEG;");
      status.out.println("o_idcitta=w_idcitta;");
      status.out.println("o_VLTPLAT=w_VLTPLAT;");
      status.out.println("o_TIPOGIOCO=w_TIPOGIOCO;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['SNAINUMOPE'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_oper_storico_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(733,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","cgo_operazioni_dl_multi");
    f.SetParameter("Autozoom",entityGlobals.name);
    f.SetParameter("PKFields","SNAINUMOPE");
    f.SetParameter("Popup","true");
    f.SetParameter("m_cAtExit",(SPLib.IsMobile(status.request)?"autozoom":"close"));
    f.SetParameter("Caption",status.context.Translate(entityGlobals.userName));
    if ( ! (CPLib.Empty(entityGlobals.m_cZoomConfigName))) {
      f.SetParameter("ConfigName",entityGlobals.m_cZoomConfigName);
    }
    SetParameterSequence(source,f,status.request);
    status.forwardedto = f;
  }
  void RaiseLoadedEntity(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({SNAINUMOPE:"+SPLib.ToJSValue(BO.w_SNAINUMOPE,"C",15,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({SNAINUMOPE:"+SPLib.ToJSValue(BO.w_SNAINUMOPE,"C",15,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({SNAINUMOPE:"+SPLib.ToJSValue(BO.w_SNAINUMOPE,"C",15,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({SNAINUMOPE:"+SPLib.ToJSValue(BO.w_SNAINUMOPE,"C",15,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armt_cgo_oper_storicoBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({SNAINUMOPE:"+SPLib.ToJSValue(BO.w_SNAINUMOPE,"C",15,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_cgo_oper_storicoBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_cgo_oper_storicoBO BO,ServletStatus status) throws IOException {
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
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_cgo_calc_multiid.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_cgo_moduli.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_agechar.m_cEntityUid+"/arfn_agechar.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chkcodfis.m_cEntityUid+"/arfn_chkcodfis.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_form_cf.m_cEntityUid+"/arfn_form_cf.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arrt_cgo_read_codfisc_multi.m_cEntityUid+"/arrt_cgo_read_codfisc_multi.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arrt_cgo_read_flgope.m_cEntityUid+"/arrt_cgo_read_flgope.js'>" +
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
      arfn_chkcodfis.GetCallableNames(callable);
      arfn_form_cf.GetCallableNames(callable);
      arrt_cgo_read_codfisc_multi.GetCallableNames(callable);
      arrt_cgo_read_flgope.GetCallableNames(callable);
      CPLib.AddToSet(callable,"LibreriaMit");
      CPLib.AddToSet(callable,"arrt_cgo_calc_multiid");
      CPLib.AddToSet(callable,"arrt_cgo_moduli");
      CPLib.AddToSet(callable,"ardt_cgo_oper_storico_multi");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_cgo_oper_storicoBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_SNAINUMOPE),"C",15,0));
      }
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gSeekAos),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(BO.w_gDataVaria,"D",8,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gFlgDoc),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gIntemediario),"C",11,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gChkDate),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(BO.w_gVLT,"N",10,2));
      hCreator.AddValue(CPLib.ToSQL(BO.w_gVNP,"N",10,2));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gCodDip),"C",6,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gStpDwn),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gGesDoc),"C",1,0));
    } else if (CPLib.eq(p_cUID,"NEUBQNUEOJ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"HODZKKOSYW")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"YVIKEGPYPM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ODAYKSRECA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"MBGANUUHRA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SAQTIHOALW")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"UJRFWINIVQ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SQVJLYRFKQ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SRWWPHPCUB")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ULVCBLFVEU")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"KUPRRTVLKH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"WJSVGWKSFC")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"AVHTGZTOSZ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"MSGBKOOAOY")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"LKEDJRUQJU")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"XPSJTIMTNR")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"LVYFMQXNZH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"DKNVEJCFAA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_cgo_oper_storicoBO BO) {
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
      if (result &&  ! (CPLib.Empty(BO.w_ATTIV))) {
        a = GetCheckVars(status,BO,"SAQTIHOALW");
        b = status.m_CheckVars.optString("SAQTIHOALW");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_TIPOOPRAP))) {
        a = GetCheckVars(status,BO,"UJRFWINIVQ");
        b = status.m_CheckVars.optString("UJRFWINIVQ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CODANA))) {
        a = GetCheckVars(status,BO,"SQVJLYRFKQ");
        b = status.m_CheckVars.optString("SQVJLYRFKQ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CODVOC))) {
        a = GetCheckVars(status,BO,"SRWWPHPCUB");
        b = status.m_CheckVars.optString("SRWWPHPCUB");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CONNESBEN))) {
        a = GetCheckVars(status,BO,"ULVCBLFVEU");
        b = status.m_CheckVars.optString("ULVCBLFVEU");
        result = CPLib.eq(a,b);
      }
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
      if (result &&  ! (CPLib.Empty(BO.w_COLLEG))) {
        a = GetCheckVars(status,BO,"MSGBKOOAOY");
        b = status.m_CheckVars.optString("MSGBKOOAOY");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CODVOC))) {
        a = GetCheckVars(status,BO,"LKEDJRUQJU");
        b = status.m_CheckVars.optString("LKEDJRUQJU");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_idcitta))) {
        a = GetCheckVars(status,BO,"XPSJTIMTNR");
        b = status.m_CheckVars.optString("XPSJTIMTNR");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_VLTPLAT))) {
        a = GetCheckVars(status,BO,"LVYFMQXNZH");
        b = status.m_CheckVars.optString("LVYFMQXNZH");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_TIPOGIOCO))) {
        a = GetCheckVars(status,BO,"DKNVEJCFAA");
        b = status.m_CheckVars.optString("DKNVEJCFAA");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
