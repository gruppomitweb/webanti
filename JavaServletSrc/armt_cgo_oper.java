import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_cgo_oper extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*a06ea3c*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "cgo_operazioni_dl";
    }
    public String w_SNAINUMOPE;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_SNAINUMOPE,context,"cgo_operazioni_dl","SNAINUMOPE","C",15,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
    armt_cgo_operBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_cgo_operazioni_dl;
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
    return "Operazioni Agenzie (CGO)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_cgo_oper";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 1024;
    l_eg.m_nEntityHeight = 893;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"cgo_operazioni_dl","cgo_tbtipgio","cgo_vltplat","tbcitta","tbstati","tbtipatt","tbtipreg","personbo","intermbo","operazbo","cgo_tipdoc","cgo_autorita","anadip"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","Dati Operazione","page"),new ZoneItem("page_2","Documenti","page"),new ZoneItem("page_3","Questionario ADV","page"),new ZoneItem("Base","Dati Base","horizontal_section"),new ZoneItem("Operazione","Dati Operazione","horizontal_section"),new ZoneItem("Soggetto","Dati Soggetto","horizontal_section"),new ZoneItem("Documenti","Caricamento Documenti","horizontal_section")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"SNAINUMOPE"};
    l_eg.items = new SPItem[]{
                   new SPItem("gIntemediario","C",11,0, "show","Intermediario"),
                   new SPItem("TIPOGIOCO","C",3,0, "edit","Tipo gioco"),
                   new SPItem("xSOGTPGIO","N",12,2, "hide","Soglia pagamento Agenzia"),
                   new SPItem("xDEFTPGIO","C",1,0, "hide","Default (A=Agenzia , S=SNAI)"),
                   new SPItem("xEDTTPGIO","C",1,0, "hide","Abilita modifica Scelta"),
                   new SPItem("xEDTSPGIO","C",1,0, "hide","Abilita Modifica Sotto Soglia"),
                   new SPItem("xDEFSPGIO","C",1,0, "hide","Default Sotto Soglia"),
                   new SPItem("xFLGPLGIO","C",1,0, "hide","Abilita Selezione Piattaforma"),
                   new SPItem("CGOTIPOPE","C",1,0, "hide","Tipo Gioco"),
                   new SPItem("VLTPLAT","C",2,0, "edit","Piattaforma VLT"),
                   new SPItem("CAIDBIGLIETTO","C",30,0, "edit","ID BIGLIETTO"),
                   new SPItem("DATAOPE","D",8,0, "edit","Data Operazione"),
                   new SPItem("FLAGCONT","C",1,0, "edit","Contanti (S/N)"),
                   new SPItem("FLAGWALLET","C",1,0, "edit","Flag Wallet"),
                   new SPItem("CAFLGOPE","C",1,0, "edit","Tipo Registrazione"),
                   new SPItem("TOTLIRE","N",15,2, "edit","Totale Operazione"),
                   new SPItem("TOTCONT","N",15,2, "edit","di cui contanti"),
                   new SPItem("IMPWALLET","N",12,2, "edit","IMporto"),
                   new SPItem("CODWALLET","C",20,0, "edit","WALLET"),
                   new SPItem("CODTRANSZ","C",50,0, "edit","Transazione ID Wallet"),
                   new SPItem("FILTROMP","C",50,0, "edit",""),
                   new SPItem("CGOFLGVLT","C",1,0, "show","Pagamento VLT"),
                   new SPItem("FLGPAGAM","C",1,0, "edit",""),
                   new SPItem("CGOFLGVNP","C",1,0, "hide","Pagamento Vincite prenotate"),
                   new SPItem("MEZPAGAM","C",1,0, "edit","Mezzo Pagamento"),
                   new SPItem("CC4CIFRE","C",4,0, "edit","Ultime Cifre CC ()"),
                   new SPItem("CCMESSCA","N",2,0, "edit","Mese Scadenza"),
                   new SPItem("CCANNSCA","N",4,0, "edit","Carta Di Credito Scadenza"),
                   new SPItem("ASSEGNO","C",25,0, "edit","Assegno"),
                   new SPItem("IBAN","C",40,0, "edit","IBAN per Bonifici"),
                   new SPItem("CCDATSCA","C",7,0, "hide","Scadenza"),
                   new SPItem("CFESTERO","N",1,0, "edit","Codice Fiscale Estero"),
                   new SPItem("PEP","C",1,0, "edit","Persona Politicamente Esposta"),
                   new SPItem("CODFISC","C",16,0, "edit","Codice Fiscale"),
                   new SPItem("COGNOME","C",26,0, "edit","Cognome"),
                   new SPItem("NOME","C",25,0, "edit","Nome"),
                   new SPItem("NASCOMUN","C",30,0, "edit","Luogo di Nascita"),
                   new SPItem("TIPINTER","C",2,0, "edit","Prov."),
                   new SPItem("SESSO","C",1,0, "edit","Sesso"),
                   new SPItem("NASSTATO","C",30,0, "edit","Stato di nascita"),
                   new SPItem("DATANASC","D",8,0, "edit","Data Nascita"),
                   new SPItem("PAESE","C",3,0, "edit","Stato Residenza"),
                   new SPItem("DESCCIT","C",40,0, "edit","Citt�"),
                   new SPItem("idcitta","C",10,0, "hide","Codice"),
                   new SPItem("PROVINCIA","C",2,0, "edit","Provincia"),
                   new SPItem("CAP","C",9,0, "edit","CAP"),
                   new SPItem("DOMICILIO","C",35,0, "edit","Indirizzo"),
                   new SPItem("NUMTEL","C",20,0, "edit","Numero Telefono"),
                   new SPItem("xARDESCRI","C",15,0, "hide","Descrizione"),
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
                   new SPItem("CONNESCLI","C",16,0, "edit","Codice Cliente Occasionale"),
                   new SPItem("CONNESBEN","C",16,0, "hide","Codice Cliente Occasionale"),
                   new SPItem("C_RAG","C",70,0, "hide",""),
                   new SPItem("C_CTA","C",30,0, "hide",""),
                   new SPItem("C_PRV","C",2,0, "hide",""),
                   new SPItem("C_CAP","C",5,0, "hide",""),
                   new SPItem("C_CAB","C",6,0, "hide",""),
                   new SPItem("C_IND","C",35,0, "hide",""),
                   new SPItem("C_STA","C",3,0, "hide",""),
                   new SPItem("NUMPROG","C",11,0, "hide","Numero Progressivo"),
                   new SPItem("CODINTER","C",11,0, "hide","Codice Intermediario"),
                   new SPItem("gCodDip","C",6,0, "hide","Dipendenza"),
                   new SPItem("SEGNO","C",1,0, "show","Segno"),
                   new SPItem("FLAGFRAZ","C",1,0, "hide","Frazionata (S/N)"),
                   new SPItem("COLLEG","C",11,0, "hide","Collegamento Operazione Multiple"),
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
                   new SPItem("xdesccausin","C",165,0, "hide","Descrizione"),
                   new SPItem("gChkDate","C",1,0, "hide","Controllo Date"),
                   new SPItem("xdesctipatt","C",250,0, "hide","Descrizione"),
                   new SPItem("gVLT","N",10,2, "hide","Limite VLT"),
                   new SPItem("gVNP","N",10,2, "hide","Limite VNP"),
                   new SPItem("gStpDwn","C",1,0, "hide","Stampa Download"),
                   new SPItem("CACODICE","N",5,0, "hide","Codice Causale"),
                   new SPItem("CODCAB","C",6,0, "hide","CAB"),
                   new SPItem("MIDBIGLIETTO","M",10,0, "hide",""),
                   new SPItem("MIDBIGLIETTO1","M",10,0, "hide",""),
                   new SPItem("MIDBIGLIETTO4","M",10,0, "hide",""),
                   new SPItem("MIDBIGLIETTO2","M",10,0, "hide",""),
                   new SPItem("MIDBIGLIETTO3","M",10,0, "hide",""),
                   new SPItem("gPathApp","C",80,0, "hide","Path Applicazione"),
                   new SPItem("IDDOCALL","C",36,0, "hide","ID Collegamento Documenti"),
                   new SPItem("FLGDOCALL","C",1,0, "edit","Flag Documentazione Completa"),
                   new SPItem("xVPFLGATT","C",1,0, "hide","Piattaforma Attiva"),
                   new SPItem("DOC03","C",80,0, "edit",""),
                   new SPItem("DOC04","C",80,0, "edit",""),
                   new SPItem("gGesDoc","C",1,0, "hide","Gestione Documentale"),
                   new SPItem("edtdoc","L",1,0, "hide",""),
                   new SPItem("saveddoc","C",1,0, "edit",""),
                   new SPItem("xIMPMINGIO","N",10,2, "hide","Importo minimo autovalidazione multiple"),
                   new SPItem("TIPODOC","C",2,0, "edit","Tipo Documento"),
                   new SPItem("NUMDOCUM","C",15,0, "edit","Numero Doc."),
                   new SPItem("DATARILASC","D",8,0, "edit","Rilascio Doc."),
                   new SPItem("DATAVALI","D",8,0, "edit","Data Fine Validit�"),
                   new SPItem("RDCODAUT","C",2,0, "edit","Autorit� Rilascio"),
                   new SPItem("RDLOCAUT","C",20,0, "edit","Luogo Autorit� Rilascio"),
                   new SPItem("AUTRILASC","C",30,0, "show","Autorit� di rilascio"),
                   new SPItem("PEPDESCRI","C",80,0, "edit","Descrizione PEP"),
                   new SPItem("PAESE2","C",3,0, "edit","Stato Domicilio"),
                   new SPItem("DESCCIT2","C",40,0, "edit","Citt� Domicilio"),
                   new SPItem("idcitta2","C",10,0, "hide","Codice"),
                   new SPItem("PROVINCIA2","C",2,0, "edit","Provincia"),
                   new SPItem("CAP2","C",9,0, "edit","CAP"),
                   new SPItem("DOMICILIO2","C",35,0, "edit","Indirizzo Domicilio"),
                   new SPItem("FLGDOM","C",1,0, "edit","Domicilio diverso da residenza"),
                   new SPItem("dessta2","C",40,0, "hide","Descrizione"),
                   new SPItem("gTipMul","C",3,0, "hide","Tipo Gioco Multiple"),
                   new SPItem("FLGQADVFULL","C",1,0, "edit",""),
                   new SPItem("gQADV","C",1,0, "hide","Attiva Questionario QADV"),
                   new SPItem("xCGOFLGPROF","C",1,0, "hide","Flag Richiesta Professione"),
                   new SPItem("PROFESSIONE","C",40,0, "edit","Professione"),
                   new SPItem("CODDIPE","C",6,0, "edit","Codice Dipendenza"),
                   new SPItem("DESCCITDIP","C",30,0, "show","Citt� Dipendenza"),
                   new SPItem("PROVINCIADIP","C",2,0, "show","Provincia Dipendenza"),
                   new SPItem("CODCABDIP","C",6,0, "show","CAB Dipendenza"),
                   new SPItem("TELDIP","C",15,0, "hide","Telefono"),
                   new SPItem("CODLOC","C",25,0, "hide","Codice Locale (CGO)"),
                   new SPItem("dirupl","C",10,0, "hide",""),
                   new SPItem("ANA_FOUND","C",1,0, "edit","")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_cgo_operBO BO) {
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
    l_translations=new String[][]{{"10032163180",p_Context.Translate("Autorit� di rilascio")},
    {"10034405761",p_Context.Translate("Codice Fiscale Estero")},
    {"1009376930",p_Context.Translate("Recupera dati anagrafici da codice fiscale")},
    {"10095365423",p_Context.Translate("Provincia")},
    {"10219814530",p_Context.Translate("Codice Cliente Occasionale")},
    {"10220423475",p_Context.Translate("Data Variazione")},
    {"1022824624",p_Context.Translate("Inserire le ultime 4 cifre della carta di credito")},
    {"1028598955",p_Context.Translate("Data registrazione")},
    {"10290663779",p_Context.Translate("ID Collegamento Documenti")},
    {"1033518927",p_Context.Translate("Attivit� Prevalente")},
    {"10524120562",p_Context.Translate("ID BIGLIETTO")},
    {"10574713661",p_Context.Translate("Numero Telefono")},
    {"10651434988",p_Context.Translate("Mezzo Pagamento")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"10678724575",p_Context.Translate("Impossibile cancellare una operazione di un'altra agenzia")},
    {"10787648910",p_Context.Translate("Stampa Download")},
    {"10845724022",p_Context.Translate("La data del ticket non pu� essere maggiore della data odierna!")},
    {"10848850431",p_Context.Translate("CAB Dipendenza")},
    {"10901286719",p_Context.Translate("Path Applicazione")},
    {"1093030153",p_Context.Translate("Codice Locale (CGO)")},
    {"10943726013",p_Context.Translate("di cui contanti")},
    {"10966082329",p_Context.Translate("Impossibile visualizzare una operazione di un'altra agenzia")},
    {"109710548",p_Context.Translate("Divisa")},
    {"11052594431",p_Context.Translate("Importo minimo autovalidazione multiple")},
    {"11061636098",p_Context.Translate("Default Sotto Soglia")},
    {"11137644647",p_Context.Translate("Tipo Operazione Completa")},
    {"11247539166",p_Context.Translate("Piattaforma VLT")},
    {"11256417841",p_Context.Translate("Pagamento VLT")},
    {"11269468581",p_Context.Translate("Ricerca su Soggetti Segnalati (Black List Interna)")},
    {"112851763",p_Context.Translate("Codice")},
    {"11316624286",p_Context.Translate("Codice Intermediario")},
    {"11356972522",p_Context.Translate("Provincia Dipendenza")},
    {"11393904432",p_Context.Translate("Citt� Domicilio")},
    {"11396780126",p_Context.Translate("Intermediario")},
    {"11401314672",p_Context.Translate("Stato Domicilio")},
    {"11419822357",p_Context.Translate("E' obbligatorio inserire un importo valido")},
    {"11429032151",p_Context.Translate("Tipo Documento")},
    {"11434798317",p_Context.Translate("Questionario ADV Completato")},
    {"11517258780",p_Context.Translate("Transazione ID Wallet")},
    {"11525797640",p_Context.Translate("%ERRORMESSAGE%")},
    {"11642408298",p_Context.Translate("Ultime Cifre CC ()")},
    {"11777527481",p_Context.Translate("Data Nascita")},
    {"11857312893",p_Context.Translate("Scadenza")},
    {"11921223220",p_Context.Translate("Codice Fiscale")},
    {"11925635672",p_Context.Translate("Collegamento con AOS")},
    {"11993248424",p_Context.Translate("N� Operazione")},
    {"12033514136",p_Context.Translate("Limite VLT")},
    {"12033514198",p_Context.Translate("Limite VNP")},
    {"12123284333",p_Context.Translate("Stato di nascita")},
    {"12123334500",p_Context.Translate("Luogo di Nascita")},
    {"1216938285",p_Context.Translate("Data Fine Validit�")},
    {"123704147",p_Context.Translate("Cambio")},
    {"1255218623",p_Context.Translate("Abilita Selezione Piattaforma")},
    {"1264575246",p_Context.Translate("Abilita modifica Scelta")},
    {"1267255314",p_Context.Translate("Persona Esposta Politicamente")},
    {"1270140254",p_Context.Translate("Dipendenza")},
    {"1270140318",p_Context.Translate("Dipendenze")},
    {"1314928579",p_Context.Translate("L'importo non pu� superare la differenza tra importo totale e importo contanti")},
    {"1319025851",p_Context.Translate("Domicilio diverso da residenza")},
    {"1444804436",p_Context.Translate("Carta Di Credito Scadenza")},
    {"1475053609",p_Context.Translate("Luogo Autorit� Rilascio")},
    {"1489090677",p_Context.Translate("Autorit� non valida per il tipo documento selezionato")},
    {"1501129222",p_Context.Translate("Operazioni Agenzie (CGO)")},
    {"1513560829",p_Context.Translate("Persona Politicamente Esposta")},
    {"15186643",p_Context.Translate("Citt�")},
    {"1518802369",p_Context.Translate("Attenzione! Data di rilascio superiore alla data fine validit�.Verificare il corretto inserimento delle date.")},
    {"1568441828",p_Context.Translate("Codice Causale")},
    {"1570205239",p_Context.Translate("Tipo Gioco")},
    {"1603759671",p_Context.Translate("Tipo gioco")},
    {"1608394306",p_Context.Translate("Rilascio Doc.")},
    {"1683045192",p_Context.Translate("Attiva Questionario QADV")},
    {"1686225832",p_Context.Translate("Non � utilizzabile il tipo gioco valido per le operazioni multiple")},
    {"1700577956",p_Context.Translate("Telefono")},
    {"1705711075",p_Context.Translate("Descrizione PEP")},
    {"1715238713",p_Context.Translate("Codice Fiscale Errato nel formato")},
    {"1722199786",p_Context.Translate("Frazionata (S/N)")},
    {"1734932797",p_Context.Translate("Numero Doc.")},
    {"1745819304",p_Context.Translate("Piattaforma Attiva")},
    {"1748201363",p_Context.Translate("Citt� Dipendenza")},
    {"1758579303",p_Context.Translate("Tipo Gioco Multiple")},
    {"178012863",p_Context.Translate("Professione")},
    {"18003",p_Context.Translate("CAB")},
    {"1816546867",p_Context.Translate("Cognome")},
    {"1825772649",p_Context.Translate("Totale Operazione")},
    {"187973133",p_Context.Translate("Attenzione! Documento scaduto. E' necessario inserire gli estremi di un nuovo documento.")},
    {"1890893827",p_Context.Translate("Clienti")},
    {"1973525056",p_Context.Translate("Autorit� Rilascio")},
    {"1984809585",p_Context.Translate("Assegno")},
    {"1991861529",p_Context.Translate("IMporto")},
    {"2025840209",p_Context.Translate("Mese Scadenza")},
    {"2071283709",p_Context.Translate("Codice Dipendenza")},
    {"2095911698",p_Context.Translate("Settorizzazione UIC")},
    {"215310487",p_Context.Translate("Causale Sintetica")},
    {"215536597",p_Context.Translate("Causale Analitica")},
    {"21587",p_Context.Translate("CAP")},
    {"226933836",p_Context.Translate("Data Passaggio EURO")},
    {"227238806",p_Context.Translate("Stato Residenza")},
    {"237632211",p_Context.Translate("Contanti (S/N)")},
    {"282420974",p_Context.Translate("Causali Sintetiche")},
    {"282647084",p_Context.Translate("Causali Analitiche")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"296951675",p_Context.Translate("Gestione Documentale")},
    {"316744004",p_Context.Translate("Soglia pagamento Agenzia")},
    {"3528304",p_Context.Translate("Prov.")},
    {"38572451",p_Context.Translate("Default (A=Agenzia , S=SNAI)")},
    {"441053783",p_Context.Translate("Obbligatorio selezionare una piattaforma attiva!")},
    {"443454",p_Context.Translate("Nome")},
    {"448095445",p_Context.Translate("Pagamento Vincite prenotate")},
    {"453879700",p_Context.Translate("Indirizzo Domicilio")},
    {"484567773",p_Context.Translate("Prevalente Attivit�")},
    {"485092",p_Context.Translate("Tipo")},
    {"554236824",p_Context.Translate("Indirizzo")},
    {"572399938",p_Context.Translate("Ramo Gruppo Att. Ec.")},
    {"611154211",p_Context.Translate("Sottogruppo Att. Ec.")},
    {"628897822",p_Context.Translate("Flag Richiesta Professione")},
    {"647451330",p_Context.Translate("Flag Wallet")},
    {"674110294",p_Context.Translate("Flag Documentazione Completa")},
    {"737507602",p_Context.Translate("IBAN per Bonifici")},
    {"7383187",p_Context.Translate("Stati")},
    {"750412439",p_Context.Translate("Collegamento Operazione Multiple")},
    {"7753123",p_Context.Translate("Segno")},
    {"7776675",p_Context.Translate("Sesso")},
    {"779449074",p_Context.Translate("Impossibile modificare una operazione di un'altra agenzia")},
    {"819587209",p_Context.Translate("Attenzione! Data di rilascio documento successiva all'operazione. E' necessario inserire gli estremi di un nuovo documento.")},
    {"829201110",p_Context.Translate("Data Operazione")},
    {"839211622",p_Context.Translate("Numero Progressivo")},
    {"864597548",p_Context.Translate("Collegamento con storico documenti")},
    {"906181626",p_Context.Translate("Soggetto Residente All'Estero")},
    {"92934247",p_Context.Translate("WALLET")},
    {"976489378",p_Context.Translate("Controllo Date")},
    {"981524941",p_Context.Translate("Abilita Modifica Sotto Soglia")},
    {"995100987",p_Context.Translate("Tipo Registrazione")}};
    return l_translations;
  }
  void WriteStyles(armt_cgo_operBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_cgo_oper.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_cgo_operBO BO,ServletStatus status) {
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
    status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati Operazione"),"C",0,0)+"},{name:\"page_2\", element:\"page_2\", caption:"+SPLib.ToJSValue(status.context.Translate("Documenti"),"C",0,0)+"},{name:\"page_3\", element:\"page_3\", caption:"+SPLib.ToJSValue(status.context.Translate("Questionario ADV"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
    status.out.println("Z.Tabs.Set('tabs',tabs);");
    status.out.println("} else {");
    status.out.println("var tabs = Z.Tabs.Get('tabs')");
    status.out.println("}");
    AddExtendedTabs(status);
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_cgo_oper',false);");
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_cgo_oper",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  // GetPortlet_Documenti_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_KUBMCPCHPZ_Vars(armt_cgo_operBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"aTG",BO.w_TIPOGIOCO);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"aOrigine","N");
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"aImporto",BO.w_TOTLIRE);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"aContanti",BO.w_TOTCONT);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"aFull",BO.w_FLGDOCALL);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"aID",BO.w_IDDOCALL);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"aIDTicket",BO.w_CAIDBIGLIETTO);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"aCodDip",BO.w_CODDIPE);
    return inclusionVars;
  }
  void WriteControls(armt_cgo_operBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    WriteControls_p2(BO,status);
    WriteControls_p3(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,4);
  }
  void WriteControls_p1(armt_cgo_operBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:893px;width:1024px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteControls_p1_b1(BO,status);
    WriteControls_p1_b2(BO,status);
    WriteControls_p1_b3(BO,status);
    WriteControls_p1_b4(BO,status);
    WriteControls_p1_b5(BO,status);
    WriteControls_p1_b6(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"Dati Operazione");
    PrintSidebarContent(1,status,getSidebarItems(0),true);
    PrintContextMenu(1,status,getContextMenu(0),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2(armt_cgo_operBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_2' class='PageContainer' style='position:relative;height:497px;width:1024px;display:none'>" +
    "");
    WriteControls_p2_b0(BO,status);
    WriteControls_p2_b1(BO,status);
    WriteControls_p2_b2(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,2,"Documenti");
    PrintSidebarContent(2,status,getSidebarItems(1),true);
    PrintContextMenu(2,status,getContextMenu(1),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3(armt_cgo_operBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_3' class='PageContainer' style='position:relative;height:804px;width:1024px;display:none'>" +
    "");
    WriteControls_p3_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,3,"Questionario ADV");
    PrintSidebarContent(3,status,getSidebarItems(2),false);
    PrintContextMenu(3,status,getContextMenu(2),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b0(armt_cgo_operBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_1' style='position:relative;height:8px;display:block' page='1'>" +
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
  void WriteControls_p1_b1(armt_cgo_operBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Base' id='CCUOYXMBZC_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='CCUOYXMBZC_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='CCUOYXMBZC_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Base")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='CCUOYXMBZC_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"CCUOYXMBZC\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=CCUOYXMBZC_HEADER&m_cBoxId=CCUOYXMBZC&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Base"))+"");
    }
    status.out.println(
     "<div id='CCUOYXMBZC' class='SectionBody' style='position:relative;height:90px;display:block'>" +
    "");
    status.includeZoneAltInterface("Base@BEGIN");
    if (status.includeZoneAltInterface("Base")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Base@BEGIN") || status.HasZoneAltInterface("Base@END")) {
        status.out.println(
         "<div id='CCUOYXMBZC_boxContent' style='position:relative;height:90px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<input name='gIntemediario' id='GXLWKNXGMM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_gIntemediario,"C",11,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='11' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPOGIOCO' id='QZTTRBWAQL' class='"+status.ObligatoryClass("Combobox")+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='VLTPLAT' id='LVYFMQXNZH' class='"+status.ObligatoryClass("Combobox",BO.LVYFMQXNZH_isObligatory())+"' tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CAIDBIGLIETTO' id='BMTLGIUQTH' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_CAIDBIGLIETTO,"C",30,0,"!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
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
       "<span class='SPLabel' id='EZWFUWOKXC_DIV'>" +
       "<label id='EZWFUWOKXC' for='BMTLGIUQTH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ID BIGLIETTO:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JNQVUOSVPV_DIV'>" +
       "<label id='JNQVUOSVPV' for='DMGEDRIYII'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Gioco:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DJRHGZHJSR_DIV'>" +
       "<label id='DJRHGZHJSR' for='DMGEDRIYII'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Piattaforma:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LOEAMXUYLA_DIV'>" +
       "<label id='LOEAMXUYLA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Intermediario:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODDIPE' id='AVHTGZTOSZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODDIPE,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='DESCCITDIP' id='RLUMBFHPUD' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DESCCITDIP,"C",30,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XVRJYSKGWZ_DIV'>" +
       "<label id='XVRJYSKGWZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Agenzia:"))+"" +
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
      if (status.HasZoneAltInterface("Base@BEGIN") || status.HasZoneAltInterface("Base@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b1_CloseBand(armt_cgo_operBO BO,ServletStatus status) {
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
      status.out.println("Ctrl('CCUOYXMBZC').style.height='auto';");
    } else {
      status.out.println("Ctrl('CCUOYXMBZC').setAttribute('band_height',90);");
    }
    status.out.println("Ctrl('CCUOYXMBZC').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_cgo_operBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_YORQOIOBQN")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_YORQOIOBQN' style='position:relative;height:2px;display:block' page='1'>" +
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
  void WriteControls_p1_b3(armt_cgo_operBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Operazione' id='YORQOIOBQN_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
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
     "<div id='YORQOIOBQN' class='SectionBody' style='position:relative;height:212px;display:block'>" +
    "");
    status.includeZoneAltInterface("Operazione@BEGIN");
    if (status.includeZoneAltInterface("Operazione")) {
      WriteControls_p1_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Operazione@BEGIN") || status.HasZoneAltInterface("Operazione@END")) {
        status.out.println(
         "<div id='YORQOIOBQN_boxContent' style='position:relative;height:212px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAOPE' id='YLIKFVPZJA' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_DATAOPE,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
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
       "<select name='FLAGWALLET' id='DWJVPXTRND' class='"+status.ObligatoryClass("Combobox")+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("0","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("0",CPLib.Trim(BO.w_FLAGWALLET))?"SELECTED":"")+">" +
       ""+status.context.Translate("No")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_FLAGWALLET))?"SELECTED":"")+">" +
       ""+status.context.Translate("Si")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('DWJVPXTRND'),w_FLAGWALLET,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='CAFLGOPE' id='YJDISDDJUY' class='"+status.ObligatoryClass("Combobox")+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='TOTLIRE' id='HUAGBHPUNH' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_TOTLIRE,"N",15,2,"999,999,999,999.99", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='21' size='15' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='TOTCONT' id='HUDOCMLKKT' type='text' class='"+status.ObligatoryClass("Field",BO.HUDOCMLKKT_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_TOTCONT,"N",15,2,"999,999,999,999.99", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='21' size='15' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IMPWALLET' id='BELMGUMGMW' type='text' class='"+status.ObligatoryClass("Field",BO.BELMGUMGMW_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_IMPWALLET,"N",12,2,"999,999,999,999.99", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='21' size='12' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODWALLET' id='TRGEEVWGRS' type='text' class='"+status.ObligatoryClass("Field",BO.TRGEEVWGRS_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_CODWALLET,"C",20,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='20' size='20' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODTRANSZ' id='YYELCZIDWS' type='text' class='"+status.ObligatoryClass("Field",BO.YYELCZIDWS_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_CODTRANSZ,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.out.println(
       "<div class='"+status.ObligatoryClass("")+"' id='SFKJNKYLJO_DIV'>" +
       "<span id='SFKJNKYLJO_0_container'>" +
       "<input id='SFKJNKYLJO_0' name='SFKJNKYLJO' type='radio' value="+SPLib.ToHTMLValue("S","C",1,0)+" disabled "+(CPLib.eq("S",CPLib.Trim(BO.w_CGOFLGVLT))?"CHECKED":"")+">" +
       "<label class='SPLabel' for='SFKJNKYLJO_0'>"+status.context.Translate("Concessionario")+"</label>" +
       "</span>" +
       "<span id='SFKJNKYLJO_1_container'>" +
       "<input id='SFKJNKYLJO_1' name='SFKJNKYLJO' type='radio' value="+SPLib.ToHTMLValue("A","C",1,0)+" disabled "+(CPLib.eq("A",CPLib.Trim(BO.w_CGOFLGVLT))?"CHECKED":"")+">" +
       "<label class='SPLabel' for='SFKJNKYLJO_1'>"+status.context.Translate("Punto Vendita")+"</label>" +
       "</span>" +
       "</div>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='MEZPAGAM' id='EOSKLIUGBC' class='"+status.ObligatoryClass("Combobox",BO.EOSKLIUGBC_isObligatory())+"' tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CC4CIFRE' id='FKEAKFSYVU' type='text' class='"+status.ObligatoryClass("Field",BO.FKEAKFSYVU_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_CC4CIFRE,"C",4,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(status.context.Translate("Inserire le ultime 4 cifre della carta di credito"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='4' fieldtype='C' style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='CCMESSCA' id='MFCMVHMGSB' class='"+status.ObligatoryClass("Combobox",BO.MFCMVHMGSB_isObligatory())+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue(0,"N",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(1,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(1,BO.w_CCMESSCA)?"SELECTED":"")+">" +
       ""+status.context.Translate("Gennaio")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(2,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(2,BO.w_CCMESSCA)?"SELECTED":"")+">" +
       ""+status.context.Translate("Febbraio")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(3,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(3,BO.w_CCMESSCA)?"SELECTED":"")+">" +
       ""+status.context.Translate("Marzo")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(4,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(4,BO.w_CCMESSCA)?"SELECTED":"")+">" +
       ""+status.context.Translate("Aprile")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(5,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(5,BO.w_CCMESSCA)?"SELECTED":"")+">" +
       ""+status.context.Translate("Maggio")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(6,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(6,BO.w_CCMESSCA)?"SELECTED":"")+">" +
       ""+status.context.Translate("Giugno")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(7,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(7,BO.w_CCMESSCA)?"SELECTED":"")+">" +
       ""+status.context.Translate("Luglio")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(8,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(8,BO.w_CCMESSCA)?"SELECTED":"")+">" +
       ""+status.context.Translate("Agosto")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(9,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(9,BO.w_CCMESSCA)?"SELECTED":"")+">" +
       ""+status.context.Translate("Settembre")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(10,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(10,BO.w_CCMESSCA)?"SELECTED":"")+">" +
       ""+status.context.Translate("Ottobre")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(11,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(11,BO.w_CCMESSCA)?"SELECTED":"")+">" +
       ""+status.context.Translate("Novembre")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue(12,"N",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq(12,BO.w_CCMESSCA)?"SELECTED":"")+">" +
       ""+status.context.Translate("Dicembre")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('MFCMVHMGSB'),w_CCMESSCA,'N');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CCANNSCA' id='YZHCHEDWZM' type='text' class='"+status.ObligatoryClass("Field",BO.YZHCHEDWZM_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_CCANNSCA,"N",4,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='4' fieldtype='N' style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ASSEGNO' id='KZWBLPQNHU' type='text' class='"+status.ObligatoryClass("Field",BO.KZWBLPQNHU_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_ASSEGNO,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C' style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IBAN' id='UTUCDPQJKK' type='text' class='"+status.ObligatoryClass("Field",BO.UTUCDPQJKK_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_IBAN,"C",40,0,"!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='40' size='40' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<input name='DATAREG' id='OEIKQOZMYJ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DATAREG,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.out.println(
       "<input name='TIPOOPRAP' id='UJRFWINIVQ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TIPOOPRAP,"C",2,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KDUGHGZUUG_DIV' style='display:none'>" +
       "<label id='KDUGHGZUUG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Numero Progressivo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HVHVAYPDJE_DIV'>" +
       "<label id='HVHVAYPDJE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data di pagamento:"))+"" +
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
       "<select name='SEGNO' id='QNNLSEAZHF' class='Combobox Disabled' disabled>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("A","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("A",CPLib.Trim(BO.w_SEGNO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Avere")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("D","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("D",CPLib.Trim(BO.w_SEGNO))?"SELECTED":"")+">" +
       ""+status.context.Translate("Dare")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('QNNLSEAZHF'),w_SEGNO,'C');" +
       "</script>" +
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
       "<span class='SPLabel' id='VQCVMXHDPB_DIV' style='display:none'>" +
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
       "<span class='SPLabel' id='OLXBUMYJGF_DIV'>" +
       "<label id='OLXBUMYJGF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Registrazione:"))+"" +
       "</label>" +
       "</span>" +
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
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='saveddoc' id='NVJDAQQRWF' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_saveddoc,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='1' size='1' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MXHBIVIBOZ_DIV'>" +
       "<label id='MXHBIVIBOZ' for='QNNLSEAZHF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Segno:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='AYZLWZINKY_DIV'>" +
       "<label id='AYZLWZINKY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Wallet:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DWKJKOCJCQ_DIV'>" +
       "<label id='DWKJKOCJCQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("di cui Wallet:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VIFLDDUUWV_DIV'>" +
       "<label id='VIFLDDUUWV' for='TRGEEVWGRS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("WALLET:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FYLQGYMZSV_DIV'>" +
       "<label id='FYLQGYMZSV' for='YYELCZIDWS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Transazione ID Wallet:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Operazione@BEGIN") || status.HasZoneAltInterface("Operazione@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b3_CloseBand(armt_cgo_operBO BO,ServletStatus status) {
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
      status.out.println("Ctrl('YORQOIOBQN').setAttribute('band_height',212);");
    }
    status.out.println("Ctrl('YORQOIOBQN').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b4(armt_cgo_operBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_AQSQVBKXAL")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_AQSQVBKXAL' style='position:relative;height:8px;display:block' page='1'>" +
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
  void WriteControls_p1_b5(armt_cgo_operBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Soggetto' id='AQSQVBKXAL_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
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
     "<div id='AQSQVBKXAL' class='SectionBody' style='position:relative;height:508px;display:block'>" +
    "");
    status.includeZoneAltInterface("Soggetto@BEGIN");
    if (status.includeZoneAltInterface("Soggetto")) {
      WriteControls_p1_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Soggetto@BEGIN") || status.HasZoneAltInterface("Soggetto@END")) {
        status.out.println(
         "<div id='AQSQVBKXAL_boxContent' style='position:relative;height:508px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='FILTROMP' id='EKBMRGBOJG' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_FILTROMP,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='50' size='50' fieldtype='C' style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='FLGPAGAM' id='GRJCRZXDIK' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_FLGPAGAM,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='1' size='1' fieldtype='C' style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='CZTHKEDVCO_DIV'>" +
       "<input name='CFESTERO' id='CZTHKEDVCO' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_CFESTERO,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_CFESTERO)?"CHECKED":"")+">" +
       "<label id='CZTHKEDVCO_LBL' for='CZTHKEDVCO' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Soggetto Residente All'Estero"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span class='"+status.ObligatoryClass("")+"' id='XFKXBQYUIU_DIV'>" +
       "<input name='PEP' id='XFKXBQYUIU' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_PEP,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_PEP))?"CHECKED":"")+">" +
       "<label id='XFKXBQYUIU_LBL' for='XFKXBQYUIU' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Persona Esposta Politicamente"))+"</label>" +
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
       "<input name='NUMTEL' id='GRTAUFQUJZ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NUMTEL,"C",20,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='20' size='20' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CONNESCLI' id='QBLXDBODXR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONNESCLI,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C' style='display:none'>" +
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
      status.out.println(
       "<span class='SPLabel' id='WKTPZFFUJF_DIV'>" +
       "<label id='WKTPZFFUJF' for='GRTAUFQUJZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Numero Telefono:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='FLGDOCALL' id='ZUVVNOUSIQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_FLGDOCALL,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='1' size='1' fieldtype='C' style='display:none'>" +
      "");
      WriteControls_p1_b5_1(BO,status);
    }
  }
  void WriteControls_p1_b5_1(armt_cgo_operBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DOC03' id='PAADFVDPUD' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_DOC03,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='80' size='80' fieldtype='C' style='display:none'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DOC04' id='SIRTAMVPQN' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_DOC04,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='80' size='80' fieldtype='C' style='display:none'>" +
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
     "<select name='RDCODAUT' id='YDUQCBNYFV' class='"+status.ObligatoryClass("Combobox")+"' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
     "<option value>" +
     "</option>" +
     "</select>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='RDLOCAUT' id='MPRHMTBSXX' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_RDLOCAUT,"C",20,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='20' size='20' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='YXFGMWZGNN_DIV'>" +
     "<label id='YXFGMWZGNN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Numero Doc.:"))+"" +
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
     "<span class='SPLabel' id='UYGHJPRVKH_DIV'>" +
     "<label id='UYGHJPRVKH'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Fine Validit�:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='AUTRILASC' id='TXKHUBKEOP' type='text' class='"+status.ObligatoryClass("Field Disabled")+"' value="+SPLib.ToHTMLValue(BO.w_AUTRILASC,"C",30,0,"!", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='30' size='30' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LSLCBQSYUK_DIV'>" +
     "<label id='LSLCBQSYUK' for='MPRHMTBSXX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Luogo Autorit� Rilascio:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='PEPDESCRI' id='DAEHHCRYAM' type='text' class='"+status.ObligatoryClass("Field",BO.DAEHHCRYAM_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_PEPDESCRI,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='80' size='80' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='PAESE2' id='UOOQYQWWNG' type='text' class='"+status.ObligatoryClass("Field",BO.UOOQYQWWNG_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_PAESE2,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C' autocomplete='off'>" +
     "<button id='UOOQYQWWNG_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "UOOQYQWWNG", "tbstati", "", "")+"" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DESCCIT2' id='BVEIQEJCLQ' type='text' class='"+status.ObligatoryClass("Field",BO.BVEIQEJCLQ_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_DESCCIT2,"C",40,0,"!", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='40' size='40' fieldtype='C' autocomplete='off'>" +
     "<button id='BVEIQEJCLQ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "BVEIQEJCLQ", "tbcitta", "", "")+"" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='PROVINCIA2' id='NKJDWBKDWM' type='text' class='"+status.ObligatoryClass("Field",BO.NKJDWBKDWM_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_PROVINCIA2,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CAP2' id='MDTHUZMSSI' type='text' class='"+status.ObligatoryClass("Field",BO.MDTHUZMSSI_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_CAP2,"C",9,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='9' size='9' fieldtype='C'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='DOMICILIO2' id='CWOLOHZAQW' type='text' class='"+status.ObligatoryClass("Field",BO.CWOLOHZAQW_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_DOMICILIO2,"C",35,0,"!", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='35' size='35' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XAZPZOWUXV_DIV'>" +
     "<label id='XAZPZOWUXV'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_dessta2)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='ZJPDUNZSZL_DIV'>" +
     "<input name='FLGDOM' id='ZJPDUNZSZL' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGDOM,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGDOM))?"CHECKED":"")+">" +
     "<label id='ZJPDUNZSZL_LBL' for='ZJPDUNZSZL' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Domicilio diverso da residenza"))+"</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='ELBFOCJOYH_DIV'>" +
     "<label id='ELBFOCJOYH' for='DAEHHCRYAM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Descrizione PEP:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MCODDONEHP_DIV'>" +
     "<label id='MCODDONEHP' for='UOOQYQWWNG'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato Domicilio:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='BRPGRCAORR_DIV'>" +
     "<label id='BRPGRCAORR' for='BVEIQEJCLQ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Citt� Domicilio:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='INUGZKMMHN_DIV'>" +
     "<label id='INUGZKMMHN' for='NKJDWBKDWM'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Provincia:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PXQUPKOPNQ_DIV'>" +
     "<label id='PXQUPKOPNQ' for='MDTHUZMSSI'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("CAP:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KBBIQTXMOO_DIV'>" +
     "<label id='KBBIQTXMOO' for='CWOLOHZAQW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Indirizzo Domicilio:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KCXIMANXKF_DIV'>" +
     "<label id='KCXIMANXKF' for='MBGANUUHRA'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Documento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QUXAELRWLA_DIV'>" +
     "<label id='QUXAELRWLA' for='XHWYGOPPUN'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Rilascio Doc.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RAVMCVENOT_DIV'>" +
     "<label id='RAVMCVENOT' for='YDUQCBNYFV'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Autorit� Rilascio:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<span id='XMHFFKJFDF_DIV' style='display:none'>" +
     "<input name='FLGQADVFULL' id='XMHFFKJFDF' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGQADVFULL,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"disabled":"")+" "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGQADVFULL))?"CHECKED":"")+">" +
     "<label id='XMHFFKJFDF_LBL' for='XMHFFKJFDF' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Questionario ADV Completato"))+"</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_BYFMKHYARA()' tabindex='"+status.m_nTabIndex+"' id='BYFMKHYARA_HREF' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
     "<span id='BYFMKHYARA' title="+SPLib.ToHTMLValue(status.context.Translate("Ricerca su Soggetti Segnalati (Black List Interna)"),"C",0,0)+">" +
     ""+SPLib.ToHTMLRepresentation(Character.toString((char)60124))+"" +
     "</span>" +
     "</a>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='PROFESSIONE' id='PAQVIKBAGR' type='text' class='"+status.ObligatoryClass("Field",BO.PAQVIKBAGR_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_PROFESSIONE,"C",40,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='40' size='40' fieldtype='C' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VBCBZEOPVC_DIV' style='display:none'>" +
     "<label id='VBCBZEOPVC' for='PAQVIKBAGR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Professione:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='ANA_FOUND' id='NWDPKKZGVO' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_ANA_FOUND,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='1' size='1' fieldtype='C' style='display:none'>" +
    "");
    if (status.HasZoneAltInterface("Soggetto@BEGIN") || status.HasZoneAltInterface("Soggetto@END")) {
      status.out.println(
       "</div>" +
      "");
    }
    WriteControls_p1_b5_CloseBand(BO,status);
  }
  void WriteControls_p1_b5_CloseBand(armt_cgo_operBO BO,ServletStatus status) {
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
      status.out.println("Ctrl('AQSQVBKXAL').setAttribute('band_height',508);");
    }
    status.out.println("Ctrl('AQSQVBKXAL').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b6(armt_cgo_operBO BO,ServletStatus status) {
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
  void WriteControls_p2_b0(armt_cgo_operBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_2")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_2' style='position:relative;height:8px;display:block' page='2'>" +
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
  void WriteControls_p2_b1(armt_cgo_operBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Documenti' id='XWJLXLYKJC_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='XWJLXLYKJC_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='XWJLXLYKJC_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Caricamento Documenti")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='XWJLXLYKJC_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"XWJLXLYKJC\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=XWJLXLYKJC_HEADER&m_cBoxId=XWJLXLYKJC&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Caricamento Documenti"))+"");
    }
    status.out.println(
     "<div id='XWJLXLYKJC' class='SectionBody' style='position:relative;height:464px;display:block'>" +
    "");
    status.includeZoneAltInterface("Documenti@BEGIN");
    if (status.includeZoneAltInterface("Documenti")) {
      WriteControls_p2_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Documenti@BEGIN") || status.HasZoneAltInterface("Documenti@END")) {
        status.out.println(
         "<div id='XWJLXLYKJC_boxContent' style='position:relative;height:464px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
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
      if (status.HasZoneAltInterface("Documenti@BEGIN") || status.HasZoneAltInterface("Documenti@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p2_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p2_b1_CloseBand(armt_cgo_operBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Documenti@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Documenti")) {
      status.out.println("Ctrl('XWJLXLYKJC').style.height='auto';");
    } else {
      status.out.println("Ctrl('XWJLXLYKJC').setAttribute('band_height',464);");
    }
    status.out.println("Ctrl('XWJLXLYKJC').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b2(armt_cgo_operBO BO,ServletStatus status) {
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
  void WriteControls_p3_b0(armt_cgo_operBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='position:relative;height:804px'>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='armt_cgo_qadv_operazioni_dl' id='BZRUFRMVDO' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  static void PrintState(armt_cgo_operBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_cgo_operBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
    if (BO.armt_cgo_qadv_operazioni_dl.IsUpdated()) {
      BO.m_cWv_armt_cgo_qadv_operazioni_dl = BO.armt_cgo_qadv_operazioni_dl.GetContext();
    }
  }
  static void PrintStateWorkVars(armt_cgo_operBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_TIPOGIOCO,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CGOTIPOPE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VLTPLAT,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAIDBIGLIETTO,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAOPE,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGCONT,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGWALLET,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAFLGOPE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TOTLIRE,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_TOTCONT,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_IMPWALLET,"N",12,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODWALLET,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODTRANSZ,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CGOFLGVLT,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CGOFLGVNP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MEZPAGAM,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CC4CIFRE,"C",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CCMESSCA,"N",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CCANNSCA,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ASSEGNO,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IBAN,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CCDATSCA,"C",7,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CFESTERO,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PEP,"C",1,0));
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
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMTEL,"C",20,0));
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
    status.out.print(","+SPLib.ToJSValue(BO.w_SEGNO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGFRAZ,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_COLLEG,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CACODICE,"N",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODCAB,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDDOCALL,"C",36,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGDOCALL,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPODOC,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMDOCUM,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATARILASC,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAVALI,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RDCODAUT,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RDLOCAUT,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AUTRILASC,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PEPDESCRI,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PAESE2,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCCIT2,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINCIA2,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAP2,"C",9,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DOMICILIO2,"C",35,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGDOM,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROFESSIONE,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODDIPE,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCCITDIP,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINCIADIP,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODCABDIP,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gIntemediario,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xSOGTPGIO,"N",12,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDEFTPGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xEDTTPGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xEDTSPGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDEFSPGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xFLGPLGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FILTROMP,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGPAGAM,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_idcitta,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xARDESCRI,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dessta,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipsot,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_STATOREG,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMPROG,"C",7,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCRI,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gSeekAos,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gDataVaria,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgDoc,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gCodDip,"C",6,0));
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
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesctipatt,"C",250,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gVLT,"N",10,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_gVNP,"N",10,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_gStpDwn,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MIDBIGLIETTO,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MIDBIGLIETTO1,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MIDBIGLIETTO4,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MIDBIGLIETTO2,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MIDBIGLIETTO3,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gPathApp,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xVPFLGATT,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DOC03,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DOC04,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gGesDoc,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_edtdoc,"L",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_saveddoc,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xIMPMINGIO,"N",10,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_idcitta2,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dessta2,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gTipMul,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGQADVFULL,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gQADV,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xCGOFLGPROF,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TELDIP,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODLOC,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dirupl,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ANA_FOUND,"C",1,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_codazi:BO.m_Ctx.GetCompany(),"C",10,0));
    if (CPLib.eq(BO.m_cWv_armt_cgo_qadv_operazioni_dl,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_armt_cgo_qadv_operazioni_dl");
    } else if (CPLib.eq(BO.m_cWv_armt_cgo_qadv_operazioni_dl,"_not_empty_")) {
      BO.m_cWv_armt_cgo_qadv_operazioni_dl = BO.armt_cgo_qadv_operazioni_dl.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_armt_cgo_qadv_operazioni_dl,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_armt_cgo_qadv_operazioni_dl,"C",0,0));
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_cgo_operBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_THOGQCLBJA = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ESVLUSNYWB = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_XAZPZOWUXV = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_BLXOBUQVYE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(893,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(1024,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_cgo_oper"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'QZTTRBWAQL':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QZTTRBWAQL",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_tbtipgio,"+"default",l_session)+"'"+"]");
      status.out.print(",'LVYFMQXNZH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"LVYFMQXNZH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_vltplat,"+"default",l_session)+"'"+"]");
      status.out.print(",'YJDISDDJUY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("qbe_cgo_tgtiporeg",l_session)+"']");
      status.out.print(",'EOSKLIUGBC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("qbe_cgo_mezzipag",l_session)+"']");
      status.out.print(",'NEUBQNUEOJ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NEUBQNUEOJ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'HODZKKOSYW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"HODZKKOSYW",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'YVIKEGPYPM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"YVIKEGPYPM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'ODAYKSRECA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ODAYKSRECA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'XPSJTIMTNR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"XPSJTIMTNR",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'SAQTIHOALW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SAQTIHOALW",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipatt,"+"default",l_session)+"'"+"]");
      status.out.print(",'UJRFWINIVQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"UJRFWINIVQ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipreg,"+"default",l_session)+"'"+"]");
      status.out.print(",'ULVCBLFVEU':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ULVCBLFVEU",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'KUPRRTVLKH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"KUPRRTVLKH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'WJSVGWKSFC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"WJSVGWKSFC",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,intermbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'MSGBKOOAOY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"MSGBKOOAOY",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,operazbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'MBGANUUHRA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"MBGANUUHRA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_tipdoc,"+"default",l_session)+"'"+"]");
      status.out.print(",'YDUQCBNYFV':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"YDUQCBNYFV",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_autorita,"+"default",l_session)+"'"+"]");
      status.out.print(",'UOOQYQWWNG':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"UOOQYQWWNG",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'BVEIQEJCLQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"BVEIQEJCLQ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'HNAYMCHXMY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"HNAYMCHXMY",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'AVHTGZTOSZ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"AVHTGZTOSZ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'QZTTRBWAQL':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_tbtipgio,"+"default",l_session)+"'"+"]");
      status.out.print(",'LVYFMQXNZH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_vltplat,"+"default",l_session)+"'"+"]");
      status.out.print(",'NEUBQNUEOJ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'HODZKKOSYW':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'YVIKEGPYPM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'ODAYKSRECA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'XPSJTIMTNR':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'SAQTIHOALW':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipatt,"+"default",l_session)+"'"+"]");
      status.out.print(",'UJRFWINIVQ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipreg,"+"default",l_session)+"'"+"]");
      status.out.print(",'ULVCBLFVEU':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'KUPRRTVLKH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'WJSVGWKSFC':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,intermbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'MSGBKOOAOY':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,operazbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'MBGANUUHRA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_tipdoc,"+"default",l_session)+"'"+"]");
      status.out.print(",'YDUQCBNYFV':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_autorita,"+"default",l_session)+"'"+"]");
      status.out.print(",'UOOQYQWWNG':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'BVEIQEJCLQ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'HNAYMCHXMY':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'AVHTGZTOSZ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_cgo_oper","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_cgo_oper",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("Operazione"),"")) {
      status.quoteAndAppend("Operazione","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Soggetto"),"")) {
      status.quoteAndAppend("Soggetto","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Documenti"),"")) {
      status.quoteAndAppend("Documenti","hide","box");
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
    status.out.println("// * --- armt_cgo_oper");
    status.out.println("l_bReport=false;");
    status.out.println("l_bQADV=true");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteMainFormScript(armt_cgo_operBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_cgo_oper',false);");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('QZTTRBWAQL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LVYFMQXNZH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BMTLGIUQTH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YLIKFVPZJA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YLIKFVPZJA_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PURPSXEVAI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DWJVPXTRND')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YJDISDDJUY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HUAGBHPUNH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HUDOCMLKKT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BELMGUMGMW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TRGEEVWGRS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YYELCZIDWS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EKBMRGBOJG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GRJCRZXDIK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EOSKLIUGBC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FKEAKFSYVU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MFCMVHMGSB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YZHCHEDWZM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KZWBLPQNHU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UTUCDPQJKK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CZTHKEDVCO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XFKXBQYUIU')) SetDisabled(c,true);");
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
        status.out.println("if(c=Ctrl('GRTAUFQUJZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XFUOZLSACP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QBLXDBODXR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZUVVNOUSIQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PAADFVDPUD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SIRTAMVPQN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NVJDAQQRWF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MBGANUUHRA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HVEEMUJUUY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XHWYGOPPUN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XHWYGOPPUN_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BNWXBPSIDG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BNWXBPSIDG_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YDUQCBNYFV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MPRHMTBSXX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DAEHHCRYAM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UOOQYQWWNG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UOOQYQWWNG_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BVEIQEJCLQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BVEIQEJCLQ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NKJDWBKDWM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MDTHUZMSSI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CWOLOHZAQW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZJPDUNZSZL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XMHFFKJFDF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PAQVIKBAGR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AVHTGZTOSZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NWDPKKZGVO')) SetDisabled(c,true);");
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
      status.out.println("if (Ctrl('BZRUFRMVDO')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('BZRUFRMVDO',linkpc_url('BZRUFRMVDO'));");
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
    status.out.println("// * --- armt_cgo_oper");
    status.out.println("var btn=window.parent.document.getElementsByClassName('spModalLayer_closebtn')[0]");
    status.out.println("btn.style.display='none';");
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
    status.out.println("if (Eq(name,'armt_cgo_qadv_operazioni_dl')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_cgo_qadv_operazioni_dl")+"';");
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
        status.out.println("AutonumberApplet().SetETName('cgo_operazioni_dl');");
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
    status.out.println("// * --- armt_cgo_oper");
    status.out.println("function DocUpdated(_completo) {");
    status.out.println("  Set_FLGDOCALL(_completo);");
    status.out.println("  Set_saveddoc('S');");
    status.out.println("  SetModified();");
    status.out.println("  SendData('save');");
    status.out.println("}");
    status.out.println("");
    status.out.println("function DatiCF() {");
    status.out.println("  arrt_cgo_read_codfisc_dl([['pObj',this],['pTipo','I']])");
    status.out.println("  Calculate()");
    status.out.println("}");
    status.out.println("");
    status.out.println("function DatiCN() {");
    status.out.println("  arrt_cgo_read_codfisc_dl([['pObj',this],['pTipo','E']])");
    status.out.println("  Calculate()");
    status.out.println("}");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  armt_cgo_operBO getBO(ServletStatus status) {
    armt_cgo_operBO BO = new armt_cgo_operBO(status.context);
    // gli op_ possono essere utilizzati dalla servlet anche prima di essere inizializzati
    BO.op_SNAINUMOPE = BO.w_SNAINUMOPE;
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_cgo_operBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("cgo_operazioni_dl",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_cgo_operBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    if (CPLib.eq(p_cEvent,"Edit Aborted")) {
      Calculation_OATZTIMJMD(status,BO);
    } else if (CPLib.eq(p_cEvent,"Edit Started")) {
      Calculation_LAEGOZNRMQ(status,BO);
    } else if (CPLib.eq(p_cEvent,"New record")) {
      Calculation_BVTIXLYUGT(status,BO);
      Calculation_LAEGOZNRMQ(status,BO);
    } else if (CPLib.eq(p_cEvent,"New record aborted")) {
      Calculation_GCDVVJTTDD(status,BO);
    }
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Calculation_OATZTIMJMD(ServletStatus status,armt_cgo_operBO BO) {
    arrt_cgo_delete_docR l_oRoutine_arrt_cgo_delete_doc;
    l_oRoutine_arrt_cgo_delete_doc = arrt_cgo_delete_docR.Make(status.context,BO);
    l_oRoutine_arrt_cgo_delete_doc.pIDDOC = BO.w_IDDOCALL;
    l_oRoutine_arrt_cgo_delete_doc.pSaved = BO.w_saveddoc;
    l_oRoutine_arrt_cgo_delete_doc.pStato = "E";
    if ( ! (Forward.IsForwarded(status.forwardedto))) {
      status.forwardedto = l_oRoutine_arrt_cgo_delete_doc.Run();
      if (Forward.IsForwarded(status.forwardedto)) {
        SPLib.ForwardTo(status.forwardedto,servletContext,status.request,status.response);
      }
    }
  }
  void Calculation_GCDVVJTTDD(ServletStatus status,armt_cgo_operBO BO) {
    arrt_cgo_delete_docR l_oRoutine_arrt_cgo_delete_doc;
    l_oRoutine_arrt_cgo_delete_doc = arrt_cgo_delete_docR.Make(status.context,BO);
    l_oRoutine_arrt_cgo_delete_doc.pIDDOC = BO.w_IDDOCALL;
    l_oRoutine_arrt_cgo_delete_doc.pSaved = BO.w_saveddoc;
    l_oRoutine_arrt_cgo_delete_doc.pStato = "N";
    if ( ! (Forward.IsForwarded(status.forwardedto))) {
      status.forwardedto = l_oRoutine_arrt_cgo_delete_doc.Run();
      if (Forward.IsForwarded(status.forwardedto)) {
        SPLib.ForwardTo(status.forwardedto,servletContext,status.request,status.response);
      }
    }
  }
  void Calculation_BVTIXLYUGT(ServletStatus status,armt_cgo_operBO BO) {
    BO.w_PEP = "N";
  }
  void Calculation_LAEGOZNRMQ(ServletStatus status,armt_cgo_operBO BO) {
    BO.w_IDDOCALL = (CPLib.Empty(BO.w_IDDOCALL)?LibreriaMit.nextUID():BO.w_IDDOCALL);
  }
  void WriteTableCombo(ServletStatus status,armt_cgo_operBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_cgo_tbtipgio,CPSql.BuildSQLPhrase("CODTPGIO,DESTPGIO",BO.m_cPhName_cgo_tbtipgio,"FLGATTIVO="+CPLib.ToSQL("S","C",1,0)+"",""));
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
    status.out.println("var QZTTRBWAQL_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_cgo_vltplat,CPSql.BuildSQLPhrase("VPCODICE,VPDESCRI",BO.m_cPhName_cgo_vltplat,"VPFLGATT="+CPLib.ToSQL("S","C",1,0)+"",""));
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
    VQRHolder l_VQRHolder=null;
    SPBridge.HMCaller _h_YJDISDDJUY = new SPBridge.HMCaller();
    _h_YJDISDDJUY.Set("TIPOGIOCO",BO.w_TIPOGIOCO);
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_cgo_tgtiporeg",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),_h_YJDISDDJUY,false);
    l_VQRHolder.LoadTempWhere("");
    l_rsLoad = l_VQRHolder.GetResultSet(BO.m_Ctx);
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",1,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("TRTIPREG"),"C",1,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("TRDESREG"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var YJDISDDJUY_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    SPBridge.HMCaller _h_EOSKLIUGBC = new SPBridge.HMCaller();
    _h_EOSKLIUGBC.Set("FILTROMP",BO.w_FILTROMP);
    _h_EOSKLIUGBC.Set("FLGPAGAM",BO.w_FLGPAGAM);
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_cgo_mezzipag",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),_h_EOSKLIUGBC,false);
    l_VQRHolder.LoadTempWhere("");
    l_rsLoad = l_VQRHolder.GetResultSet(BO.m_Ctx);
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",1,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("MPCODICE"),"C",1,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("MPDESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var EOSKLIUGBC_Curs = "+l_cTmp+";");
    l_cTmp = "[";
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
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_cgo_autorita,CPSql.BuildSQLPhrase("ARCODICE,ARDESCRI",BO.m_cPhName_cgo_autorita,"",""));
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",2,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("ARCODICE"),"C",2,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("ARDESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var YDUQCBNYFV_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(armt_cgo_operBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_cgo_operazioni_dl;
    String l_cPhName = BO.m_cPhName_cgo_operazioni_dl;
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
      String l_cQueryFilter = armt_cgo_operBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_cgo_operazioni_dl+".SNAINUMOPE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("cgo_operazioni_dl");
    String l_cPhName = CPSql.ManipulateTablePhName("cgo_operazioni_dl",l_cServer);
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
  void Query(ServletStatus status,armt_cgo_operBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_cgo_operBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_cgo_operazioni_dl,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_cgo_operazioni_dl,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_cgo_operBO BO) {
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
  void Edit(ServletStatus status,armt_cgo_operBO BO,SPParameterSource source) {
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
  void New(ServletStatus status,armt_cgo_operBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_cgo_operBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_cgo_operBO BO) {
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
  void EditLoad(ServletStatus status,armt_cgo_operBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_cgo_operBO BO,SPParameterSource source) {
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
  void DeleteMessage(ServletStatus status,armt_cgo_operBO BO,SPParameterSource source) {
    BO.Load(status.w_SNAINUMOPE);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_cgo_operBO BO) {
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
  void Discard(ServletStatus status,armt_cgo_operBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_cgo_operBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",833);
    item.put("w",1024);
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
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Questionario ADV\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Dati Operazione,Documenti,Questionario ADV");
    item.put("altInterfaceFor","armt_cgo_oper");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Base\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Base\",\"h\":90,\"name\":\"Base\",\"page\":1,\"shrinkable\":true,\"spuid\":\"CCUOYXMBZC\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Dati Base\",\"titled\":true,\"type\":\"Box\",\"w\":1008,\"x\":8,\"y\":8,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAB Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":6,\"name\":\"CODCABDIP\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"OZEOCQRSEQ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":963,\"y\":22,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo gioco\",\"h\":20,\"maxlength\":3,\"name\":\"TIPOGIOCO\",\"page\":1,\"spuid\":\"QZTTRBWAQL\",\"tabindex\":5,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":208,\"x\":136,\"y\":72,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Intermediario\",\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"gIntemediario\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"GXLWKNXGMM\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":137,\"y\":22,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"ID BIGLIETTO\",\"h\":20,\"maxlength\":30,\"name\":\"CAIDBIGLIETTO\",\"page\":1,\"spuid\":\"BMTLGIUQTH\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":280,\"x\":504,\"y\":48,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"N\\u00B0 Operazione\",\"h\":20,\"maxlength\":15,\"name\":\"SNAINUMOPE\",\"page\":1,\"spuid\":\"XFUOZLSACP\",\"tabindex\":68,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":114,\"x\":136,\"y\":48,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GZVEXPFQCZ\",\"page\":1,\"spuid\":\"GZVEXPFQCZ\",\"tabindex\":69,\"type\":\"Label\",\"value\":\"N\\u00B0 Operazione:\",\"w\":121,\"x\":14,\"y\":52,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Piattaforma VLT\",\"h\":20,\"maxlength\":2,\"name\":\"VLTPLAT\",\"page\":1,\"spuid\":\"LVYFMQXNZH\",\"tabindex\":13,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":280,\"x\":504,\"y\":72,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JNQVUOSVPV\",\"page\":1,\"spuid\":\"JNQVUOSVPV\",\"tabindex\":117,\"type\":\"Label\",\"value\":\"Tipo Gioco:\",\"w\":121,\"x\":14,\"y\":76,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DJRHGZHJSR\",\"page\":1,\"spuid\":\"DJRHGZHJSR\",\"tabindex\":143,\"type\":\"Label\",\"value\":\"Tipo Piattaforma:\",\"w\":152,\"x\":352,\"y\":76,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_LOEAMXUYLA\",\"page\":1,\"spuid\":\"LOEAMXUYLA\",\"tabindex\":200,\"type\":\"Label\",\"value\":\"Intermediario:\",\"w\":121,\"x\":14,\"y\":26,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Dipendenza\",\"h\":21,\"maxlength\":6,\"name\":\"CODDIPE\",\"page\":1,\"spuid\":\"AVHTGZTOSZ\",\"tabindex\":201,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":267,\"y\":22,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Citt\\u00E0 Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":30,\"name\":\"DESCCITDIP\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"RLUMBFHPUD\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":198,\"x\":659,\"y\":22,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_XVRJYSKGWZ\",\"page\":1,\"spuid\":\"XVRJYSKGWZ\",\"tabindex\":203,\"type\":\"Label\",\"value\":\"Agenzia:\",\"w\":56,\"x\":211,\"y\":26,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_CTLYJMTHDV\",\"page\":1,\"spuid\":\"CTLYJMTHDV\",\"tabindex\":204,\"type\":\"Label\",\"value\":\"Citt\\u00E0:\",\"w\":47,\"x\":613,\"y\":26,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EZWFUWOKXC\",\"page\":1,\"spuid\":\"EZWFUWOKXC\",\"tabindex\":112,\"type\":\"Label\",\"value\":\"ID BIGLIETTO:\",\"w\":150,\"x\":352,\"y\":52,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_ENBRMMDVUP\",\"page\":1,\"spuid\":\"ENBRMMDVUP\",\"tabindex\":206,\"type\":\"Label\",\"value\":\"CAB:\",\"w\":42,\"x\":923,\"y\":26,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_BLXOBUQVYE\",\"page\":1,\"spuid\":\"BLXOBUQVYE\",\"tabindex\":207,\"type\":\"Label\",\"w\":280,\"x\":320,\"y\":26,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":2,\"name\":\"PROVINCIADIP\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"OJGQABFSYN\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":891,\"y\":22,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_JWSDOSRGAG\",\"page\":1,\"spuid\":\"JWSDOSRGAG\",\"tabindex\":205,\"type\":\"Label\",\"value\":\"Pr.:\",\"w\":32,\"x\":859,\"y\":26,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Operazione\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Operazione\",\"h\":212,\"name\":\"Operazione\",\"page\":1,\"shrinkable\":true,\"spuid\":\"YORQOIOBQN\",\"stretch\":true,\"tabindex\":3,\"title_caption\":\"Dati Operazione\",\"titled\":true,\"type\":\"Box\",\"w\":1008,\"x\":8,\"y\":100,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"Data Operazione\",\"h\":20,\"maxlength\":10,\"name\":\"DATAOPE\",\"page\":1,\"picker\":true,\"spuid\":\"YLIKFVPZJA\",\"tabindex\":15,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":88,\"x\":136,\"y\":107,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HVHVAYPDJE\",\"page\":1,\"spuid\":\"HVHVAYPDJE\",\"tabindex\":87,\"type\":\"Label\",\"value\":\"Data di pagamento:\",\"w\":121,\"x\":14,\"y\":111,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data registrazione\",\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"DATAREG\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"OEIKQOZMYJ\",\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":920,\"y\":107,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IKBMEWKQJW\",\"page\":1,\"spuid\":\"IKBMEWKQJW\",\"tabindex\":91,\"type\":\"Label\",\"value\":\"Data registrazione:\",\"w\":104,\"x\":816,\"y\":111,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Contanti (S\\/N)\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"FLAGCONT\",\"page\":1,\"spuid\":\"PURPSXEVAI\",\"tabindex\":16,\"textlist\":\"No,Si\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"0"+"'"+","+"'"+"1"+"'"+"\",\"w\":104,\"x\":136,\"y\":135,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Flag Wallet\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"FLAGWALLET\",\"page\":1,\"spuid\":\"DWJVPXTRND\",\"tabindex\":17,\"textlist\":\"No,Si\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"0"+"'"+","+"'"+"1"+"'"+"\",\"w\":104,\"x\":360,\"y\":135,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GVTXMEILAZ\",\"page\":1,\"spuid\":\"GVTXMEILAZ\",\"tabindex\":90,\"type\":\"Label\",\"value\":\"Contanti:\",\"w\":121,\"x\":14,\"y\":139,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AYZLWZINKY\",\"page\":1,\"spuid\":\"AYZLWZINKY\",\"tabindex\":197,\"type\":\"Label\",\"value\":\"Wallet:\",\"w\":80,\"x\":277,\"y\":139,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo Operazione Completa\",\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"TIPOOPRAP\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"UJRFWINIVQ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":608,\"y\":135,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KMCNAWQHKV\",\"page\":1,\"spuid\":\"KMCNAWQHKV\",\"tabindex\":92,\"type\":\"Label\",\"value\":\"Tipo Operazione:\",\"w\":104,\"x\":504,\"y\":139,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_THOGQCLBJA\",\"page\":1,\"spuid\":\"THOGQCLBJA\",\"tabindex\":96,\"type\":\"Label\",\"w\":361,\"x\":639,\"y\":139,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Registrazione\",\"h\":20,\"maxlength\":1,\"name\":\"CAFLGOPE\",\"page\":1,\"spuid\":\"YJDISDDJUY\",\"tabindex\":18,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":344,\"x\":136,\"y\":165,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Segno\",\"disabled\":\"true\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"SEGNO\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"QNNLSEAZHF\",\"textlist\":\"Avere,Dare\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"A"+"'"+","+"'"+"D"+"'"+"\",\"w\":72,\"x\":552,\"y\":165,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OLXBUMYJGF\",\"page\":1,\"spuid\":\"OLXBUMYJGF\",\"tabindex\":118,\"type\":\"Label\",\"value\":\"Tipo Registrazione:\",\"w\":121,\"x\":14,\"y\":170,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MXHBIVIBOZ\",\"page\":1,\"spuid\":\"MXHBIVIBOZ\",\"tabindex\":189,\"type\":\"Label\",\"value\":\"Segno:\",\"w\":64,\"x\":488,\"y\":170,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"Totale Operazione\",\"h\":20,\"maxlength\":21,\"name\":\"TOTLIRE\",\"page\":1,\"spuid\":\"HUAGBHPUNH\",\"tabindex\":19,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":120,\"x\":136,\"y\":194,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"di cui contanti\",\"h\":20,\"maxlength\":21,\"name\":\"TOTCONT\",\"page\":1,\"spuid\":\"HUDOCMLKKT\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":120,\"x\":360,\"y\":194,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"IMporto\",\"h\":20,\"maxlength\":21,\"name\":\"IMPWALLET\",\"page\":1,\"spuid\":\"BELMGUMGMW\",\"tabindex\":21,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":84,\"x\":584,\"y\":192,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XLNVLBYVQX\",\"page\":1,\"spuid\":\"XLNVLBYVQX\",\"tabindex\":94,\"type\":\"Label\",\"value\":\"Totale Euro:\",\"w\":121,\"x\":14,\"y\":198,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IDTBMNCIOX\",\"page\":1,\"spuid\":\"IDTBMNCIOX\",\"tabindex\":95,\"type\":\"Label\",\"value\":\"di cui contanti:\",\"w\":94,\"x\":264,\"y\":198,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DWKJKOCJCQ\",\"page\":1,\"spuid\":\"DWKJKOCJCQ\",\"tabindex\":198,\"type\":\"Label\",\"value\":\"di cui Wallet:\",\"w\":94,\"x\":488,\"y\":196,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"WALLET\",\"h\":20,\"maxlength\":20,\"name\":\"CODWALLET\",\"page\":1,\"spuid\":\"TRGEEVWGRS\",\"tabindex\":22,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":144,\"x\":136,\"y\":224,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Transazione ID Wallet\",\"h\":20,\"maxlength\":50,\"name\":\"CODTRANSZ\",\"page\":1,\"spuid\":\"YYELCZIDWS\",\"tabindex\":23,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":432,\"y\":224,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VIFLDDUUWV\",\"page\":1,\"spuid\":\"VIFLDDUUWV\",\"tabindex\":199,\"type\":\"Label\",\"value\":\"WALLET:\",\"w\":96,\"x\":40,\"y\":228,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FYLQGYMZSV\",\"page\":1,\"spuid\":\"FYLQGYMZSV\",\"tabindex\":212,\"type\":\"Label\",\"value\":\"Transazione ID Wallet:\",\"w\":136,\"x\":296,\"y\":228,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Pagamento VLT\",\"disabled\":\"true\",\"h\":19,\"maxlength\":1,\"name\":\"CGOFLGVLT\",\"orientation\":\"horizontal\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"SFKJNKYLJO\",\"type\":\"Radio\",\"typevar\":\"character\",\"w\":272,\"x\":136,\"y\":256,\"zone\":\"pag1_2_8\",\"zonepath\":\"[1,2,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LKYFODKVBU\",\"page\":1,\"spuid\":\"LKYFODKVBU\",\"tabindex\":114,\"type\":\"Label\",\"value\":\"Pagamento da parte di:\",\"w\":121,\"x\":14,\"y\":260,\"zone\":\"pag1_2_8\",\"zonepath\":\"[1,2,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Mezzo Pagamento\",\"h\":20,\"maxlength\":1,\"name\":\"MEZPAGAM\",\"page\":1,\"spuid\":\"EOSKLIUGBC\",\"tabindex\":28,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":272,\"x\":136,\"y\":281,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"Ultime Cifre CC ()\",\"h\":20,\"maxlength\":4,\"name\":\"CC4CIFRE\",\"page\":1,\"spuid\":\"FKEAKFSYVU\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":36,\"x\":525,\"y\":282,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Mese Scadenza\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":3,\"name\":\"CCMESSCA\",\"page\":1,\"spuid\":\"MFCMVHMGSB\",\"tabindex\":30,\"textlist\":\"Gennaio,Febbraio,Marzo,Aprile,Maggio,Giugno,Luglio,Agosto,Settembre,Ottobre,Novembre,Dicembre\",\"type\":\"Combobox\",\"typevar\":\"numeric\",\"valuelist\":\"1,2,3,4,5,6,7,8,9,10,11,12\",\"w\":104,\"x\":621,\"y\":282,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"Carta Di Credito Scadenza\",\"h\":20,\"maxlength\":5,\"name\":\"CCANNSCA\",\"page\":1,\"spuid\":\"YZHCHEDWZM\",\"tabindex\":31,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":736,\"y\":282,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Assegno\",\"h\":20,\"maxlength\":25,\"name\":\"ASSEGNO\",\"page\":1,\"spuid\":\"KZWBLPQNHU\",\"tabindex\":32,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":224,\"x\":525,\"y\":282,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"IBAN per Bonifici\",\"h\":20,\"maxlength\":40,\"name\":\"IBAN\",\"page\":1,\"spuid\":\"UTUCDPQJKK\",\"tabindex\":33,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":252,\"x\":525,\"y\":282,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VQCVMXHDPB\",\"page\":1,\"spuid\":\"VQCVMXHDPB\",\"tabindex\":111,\"type\":\"Label\",\"value\":\"Mezzo Pagamento:\",\"w\":121,\"x\":14,\"y\":286,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PBHNLOUBML\",\"page\":1,\"spuid\":\"PBHNLOUBML\",\"tabindex\":144,\"type\":\"Label\",\"value\":\"IBAN per Bonifici:\",\"w\":144,\"x\":376,\"y\":286,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BTZLLSBMCC\",\"page\":1,\"spuid\":\"BTZLLSBMCC\",\"tabindex\":145,\"type\":\"Label\",\"value\":\"Numero Assegno:\",\"w\":93,\"x\":427,\"y\":286,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CQTMIXIELC\",\"page\":1,\"spuid\":\"CQTMIXIELC\",\"tabindex\":146,\"type\":\"Label\",\"value\":\"Ultime Cifre CC:\",\"w\":83,\"x\":437,\"y\":286,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HKREYYVVOP\",\"page\":1,\"spuid\":\"HKREYYVVOP\",\"tabindex\":147,\"type\":\"Label\",\"value\":\"Scadenza:\",\"w\":55,\"x\":567,\"y\":286,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Soggetto\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Soggetto\",\"h\":508,\"name\":\"Soggetto\",\"page\":1,\"shrinkable\":true,\"spuid\":\"AQSQVBKXAL\",\"stretch\":true,\"tabindex\":4,\"title_caption\":\"Dati Soggetto\",\"titled\":true,\"type\":\"Box\",\"w\":1008,\"x\":8,\"y\":320,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Codice Fiscale Estero\",\"h\":21,\"label_text\":\"Soggetto Residente All"+"'"+"Estero\",\"maxlength\":2,\"name\":\"CFESTERO\",\"page\":1,\"spuid\":\"CZTHKEDVCO\",\"tabindex\":35,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":280,\"x\":136,\"y\":326,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Persona Politicamente Esposta\",\"h\":21,\"label_text\":\"Persona Esposta Politicamente\",\"maxlength\":1,\"name\":\"PEP\",\"page\":1,\"spuid\":\"XFKXBQYUIU\",\"tabindex\":36,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":208,\"x\":432,\"y\":326,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"Codice Fiscale\",\"h\":20,\"maxlength\":16,\"name\":\"CODFISC\",\"page\":1,\"spuid\":\"OJJHIUDPFY\",\"tabindex\":37,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":128,\"x\":136,\"y\":358,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cognome\",\"h\":20,\"maxlength\":26,\"name\":\"COGNOME\",\"page\":1,\"spuid\":\"TWTTDWKCRG\",\"tabindex\":38,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":176,\"x\":392,\"y\":358,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome\",\"h\":20,\"maxlength\":25,\"name\":\"NOME\",\"page\":1,\"spuid\":\"WWGIVGNUDW\",\"tabindex\":39,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":168,\"x\":616,\"y\":358,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Recupera dati anagrafici da codice fiscale\",\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_DERAHXASAL\",\"page\":1,\"spuid\":\"DERAHXASAL\",\"src\":\"..\\/images\\/search4.gif\",\"tabindex\":121,\"type\":\"Image\",\"w\":21,\"x\":268,\"y\":358,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WZDAFMDKJE\",\"page\":1,\"spuid\":\"WZDAFMDKJE\",\"tabindex\":125,\"type\":\"Label\",\"value\":\"Codice Fiscale:\",\"w\":117,\"x\":16,\"y\":362,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TVSLWOCERI\",\"page\":1,\"spuid\":\"TVSLWOCERI\",\"tabindex\":135,\"type\":\"Label\",\"value\":\"Cognome:\",\"w\":85,\"x\":304,\"y\":362,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KUPYKSUBXV\",\"page\":1,\"spuid\":\"KUPYKSUBXV\",\"tabindex\":136,\"type\":\"Label\",\"value\":\"Nome:\",\"w\":47,\"x\":568,\"y\":362,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Luogo di Nascita\",\"h\":20,\"maxlength\":30,\"name\":\"NASCOMUN\",\"page\":1,\"picker\":true,\"spuid\":\"NEUBQNUEOJ\",\"tabindex\":40,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":222,\"x\":136,\"y\":390,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Prov.\",\"h\":20,\"maxlength\":2,\"name\":\"TIPINTER\",\"page\":1,\"spuid\":\"KPSCOABZLB\",\"tabindex\":41,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":440,\"y\":390,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Sesso\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"SESSO\",\"page\":1,\"spuid\":\"QPALJZMFCL\",\"tabindex\":42,\"textlist\":\"Maschile,Femminile\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":88,\"x\":560,\"y\":390,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WVJSUIKYEY\",\"page\":1,\"spuid\":\"WVJSUIKYEY\",\"tabindex\":123,\"type\":\"Label\",\"value\":\"Citt\\u00E0 di Nascita:\",\"w\":117,\"x\":16,\"y\":394,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KRSCDPQZTQ\",\"page\":1,\"spuid\":\"KRSCDPQZTQ\",\"tabindex\":130,\"type\":\"Label\",\"value\":\"Sesso:\",\"w\":78,\"x\":480,\"y\":394,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IVAWYVSUQI\",\"page\":1,\"spuid\":\"IVAWYVSUQI\",\"tabindex\":132,\"type\":\"Label\",\"value\":\"Prov.:\",\"w\":64,\"x\":376,\"y\":394,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Stato di nascita\",\"h\":20,\"maxlength\":30,\"name\":\"NASSTATO\",\"page\":1,\"picker\":true,\"spuid\":\"HODZKKOSYW\",\"tabindex\":43,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":222,\"x\":136,\"y\":422,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZBRDCBHLZC\",\"page\":1,\"spuid\":\"ZBRDCBHLZC\",\"tabindex\":134,\"type\":\"Label\",\"value\":\"Stato di Nascita:\",\"w\":117,\"x\":16,\"y\":426,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"Data Nascita\",\"h\":20,\"maxlength\":10,\"name\":\"DATANASC\",\"page\":1,\"picker\":true,\"spuid\":\"XMGRWGFSFV\",\"tabindex\":44,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":86,\"x\":560,\"y\":422,\"zone\":\"pag1_3_5\",\"zonepath\":\"[1,3,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HZYTDOZFPI\",\"page\":1,\"spuid\":\"HZYTDOZFPI\",\"tabindex\":124,\"type\":\"Label\",\"value\":\"Data Nascita:\",\"w\":78,\"x\":480,\"y\":426,\"zone\":\"pag1_3_5\",\"zonepath\":\"[1,3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Recupera dati anagrafici da codice fiscale\",\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_RQVPEKINIU\",\"page\":1,\"spuid\":\"RQVPEKINIU\",\"src\":\"..\\/images\\/search4.gif\",\"tabindex\":137,\"type\":\"Image\",\"w\":21,\"x\":672,\"y\":422,\"zone\":\"pag1_3_5\",\"zonepath\":\"[1,3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Stato Residenza\",\"h\":20,\"maxlength\":3,\"name\":\"PAESE\",\"page\":1,\"picker\":true,\"spuid\":\"YVIKEGPYPM\",\"tabindex\":45,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":136,\"y\":454,\"zone\":\"pag1_3_6\",\"zonepath\":\"[1,3,6]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RZBLEGCFJJ\",\"page\":1,\"spuid\":\"RZBLEGCFJJ\",\"tabindex\":127,\"type\":\"Label\",\"value\":\"Stato Residenza:\",\"w\":117,\"x\":16,\"y\":459,\"zone\":\"pag1_3_6\",\"zonepath\":\"[1,3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_ESVLUSNYWB\",\"page\":1,\"spuid\":\"ESVLUSNYWB\",\"tabindex\":133,\"type\":\"Label\",\"w\":323,\"x\":203,\"y\":459,\"zone\":\"pag1_3_6\",\"zonepath\":\"[1,3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Citt\\u00E0\",\"h\":20,\"maxlength\":40,\"name\":\"DESCCIT\",\"page\":1,\"picker\":true,\"spuid\":\"ODAYKSRECA\",\"tabindex\":46,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":318,\"x\":136,\"y\":486,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia\",\"h\":20,\"maxlength\":2,\"name\":\"PROVINCIA\",\"page\":1,\"spuid\":\"NOTZPDMYIA\",\"tabindex\":48,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":536,\"y\":486,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAP\",\"h\":20,\"maxlength\":9,\"name\":\"CAP\",\"page\":1,\"spuid\":\"RDAVOEETJG\",\"tabindex\":49,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":66,\"x\":608,\"y\":486,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SBJQIAQUCN\",\"page\":1,\"spuid\":\"SBJQIAQUCN\",\"tabindex\":126,\"type\":\"Label\",\"value\":\"Provincia:\",\"w\":60,\"x\":472,\"y\":490,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GDOCAGKROT\",\"page\":1,\"spuid\":\"GDOCAGKROT\",\"tabindex\":129,\"type\":\"Label\",\"value\":\"CAP:\",\"w\":38,\"x\":568,\"y\":490,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XPSQTBKQQZ\",\"page\":1,\"spuid\":\"XPSQTBKQQZ\",\"tabindex\":131,\"type\":\"Label\",\"value\":\"Citt\\u00E0:\",\"w\":117,\"x\":16,\"y\":490,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Indirizzo\",\"h\":20,\"maxlength\":35,\"name\":\"DOMICILIO\",\"page\":1,\"spuid\":\"VYLHWTRQNX\",\"tabindex\":50,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":222,\"x\":136,\"y\":518,\"zone\":\"pag1_3_8\",\"zonepath\":\"[1,3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TWTXGZJTAR\",\"page\":1,\"spuid\":\"TWTXGZJTAR\",\"tabindex\":128,\"type\":\"Label\",\"value\":\"Indirizzo:\",\"w\":117,\"x\":16,\"y\":522,\"zone\":\"pag1_3_8\",\"zonepath\":\"[1,3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero Telefono\",\"h\":20,\"maxlength\":20,\"name\":\"NUMTEL\",\"page\":1,\"spuid\":\"GRTAUFQUJZ\",\"tabindex\":51,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":132,\"x\":560,\"y\":518,\"zone\":\"pag1_3_9\",\"zonepath\":\"[1,3,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WKTPZFFUJF\",\"page\":1,\"spuid\":\"WKTPZFFUJF\",\"tabindex\":148,\"type\":\"Label\",\"value\":\"Numero Telefono:\",\"w\":112,\"x\":448,\"y\":522,\"zone\":\"pag1_3_9\",\"zonepath\":\"[1,3,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo Documento\",\"h\":20,\"maxlength\":2,\"name\":\"TIPODOC\",\"page\":1,\"spuid\":\"MBGANUUHRA\",\"tabindex\":159,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":246,\"x\":136,\"y\":668,\"zone\":\"pag1_3_10\",\"zonepath\":\"[1,3,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KCXIMANXKF\",\"page\":1,\"spuid\":\"KCXIMANXKF\",\"tabindex\":185,\"type\":\"Label\",\"value\":\"Tipo Documento:\",\"w\":117,\"x\":16,\"y\":672,\"zone\":\"pag1_3_10\",\"zonepath\":\"[1,3,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero Doc.\",\"h\":20,\"maxlength\":15,\"name\":\"NUMDOCUM\",\"page\":1,\"spuid\":\"HVEEMUJUUY\",\"tabindex\":160,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":128,\"x\":560,\"y\":668,\"zone\":\"pag1_3_11\",\"zonepath\":\"[1,3,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YXFGMWZGNN\",\"page\":1,\"spuid\":\"YXFGMWZGNN\",\"tabindex\":165,\"type\":\"Label\",\"value\":\"Numero Doc.:\",\"w\":109,\"x\":448,\"y\":672,\"zone\":\"pag1_3_11\",\"zonepath\":\"[1,3,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"Rilascio Doc.\",\"h\":20,\"maxlength\":10,\"name\":\"DATARILASC\",\"page\":1,\"picker\":true,\"spuid\":\"XHWYGOPPUN\",\"tabindex\":161,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":86,\"x\":136,\"y\":700,\"zone\":\"pag1_3_12\",\"zonepath\":\"[1,3,12]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"Data Fine Validit\\u00E0\",\"h\":20,\"maxlength\":10,\"name\":\"DATAVALI\",\"page\":1,\"picker\":true,\"spuid\":\"BNWXBPSIDG\",\"tabindex\":162,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":86,\"x\":344,\"y\":700,\"zone\":\"pag1_3_12\",\"zonepath\":\"[1,3,12]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZPQIEJPWJC\",\"page\":1,\"spuid\":\"ZPQIEJPWJC\",\"tabindex\":166,\"type\":\"Label\",\"value\":\"Autorit\\u00E0 di rilascio:\",\"w\":111,\"x\":448,\"y\":704,\"zone\":\"pag1_3_12\",\"zonepath\":\"[1,3,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UYGHJPRVKH\",\"page\":1,\"spuid\":\"UYGHJPRVKH\",\"tabindex\":167,\"type\":\"Label\",\"value\":\"Data Fine Validit\\u00E0:\",\"w\":101,\"x\":240,\"y\":704,\"zone\":\"pag1_3_12\",\"zonepath\":\"[1,3,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Autorit\\u00E0 di rilascio\",\"disabled\":\"true\",\"h\":20,\"maxlength\":30,\"name\":\"AUTRILASC\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"TXKHUBKEOP\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":224,\"x\":560,\"y\":700,\"zone\":\"pag1_3_12\",\"zonepath\":\"[1,3,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QUXAELRWLA\",\"page\":1,\"spuid\":\"QUXAELRWLA\",\"tabindex\":186,\"type\":\"Label\",\"value\":\"Rilascio Doc.:\",\"w\":117,\"x\":16,\"y\":704,\"zone\":\"pag1_3_12\",\"zonepath\":\"[1,3,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Autorit\\u00E0 Rilascio\",\"h\":20,\"maxlength\":2,\"name\":\"RDCODAUT\",\"page\":1,\"spuid\":\"YDUQCBNYFV\",\"tabindex\":163,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":176,\"x\":136,\"y\":732,\"zone\":\"pag1_3_13\",\"zonepath\":\"[1,3,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RAVMCVENOT\",\"page\":1,\"spuid\":\"RAVMCVENOT\",\"tabindex\":187,\"type\":\"Label\",\"value\":\"Autorit\\u00E0 Rilascio:\",\"w\":117,\"x\":16,\"y\":736,\"zone\":\"pag1_3_13\",\"zonepath\":\"[1,3,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Luogo Autorit\\u00E0 Rilascio\",\"h\":20,\"maxlength\":20,\"name\":\"RDLOCAUT\",\"page\":1,\"spuid\":\"MPRHMTBSXX\",\"tabindex\":164,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":152,\"x\":560,\"y\":732,\"zone\":\"pag1_3_14\",\"zonepath\":\"[1,3,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LSLCBQSYUK\",\"page\":1,\"spuid\":\"LSLCBQSYUK\",\"tabindex\":169,\"type\":\"Label\",\"value\":\"Luogo Autorit\\u00E0 Rilascio:\",\"w\":152,\"x\":408,\"y\":736,\"zone\":\"pag1_3_14\",\"zonepath\":\"[1,3,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Descrizione PEP\",\"h\":20,\"maxlength\":80,\"name\":\"PEPDESCRI\",\"page\":1,\"spuid\":\"DAEHHCRYAM\",\"tabindex\":170,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":648,\"x\":136,\"y\":764,\"zone\":\"pag1_3_15\",\"zonepath\":\"[1,3,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ELBFOCJOYH\",\"page\":1,\"spuid\":\"ELBFOCJOYH\",\"tabindex\":179,\"type\":\"Label\",\"value\":\"Descrizione PEP:\",\"w\":117,\"x\":16,\"y\":768,\"zone\":\"pag1_3_15\",\"zonepath\":\"[1,3,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Stato Domicilio\",\"h\":20,\"maxlength\":3,\"name\":\"PAESE2\",\"page\":1,\"picker\":true,\"spuid\":\"UOOQYQWWNG\",\"tabindex\":171,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":136,\"y\":574,\"zone\":\"pag1_3_16\",\"zonepath\":\"[1,3,16]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_XAZPZOWUXV\",\"page\":1,\"spuid\":\"XAZPZOWUXV\",\"tabindex\":177,\"type\":\"Label\",\"w\":323,\"x\":203,\"y\":578,\"zone\":\"pag1_3_16\",\"zonepath\":\"[1,3,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MCODDONEHP\",\"page\":1,\"spuid\":\"MCODDONEHP\",\"tabindex\":180,\"type\":\"Label\",\"value\":\"Stato Domicilio:\",\"w\":117,\"x\":16,\"y\":578,\"zone\":\"pag1_3_16\",\"zonepath\":\"[1,3,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Citt\\u00E0 Domicilio\",\"h\":20,\"maxlength\":40,\"name\":\"DESCCIT2\",\"page\":1,\"picker\":true,\"spuid\":\"BVEIQEJCLQ\",\"tabindex\":172,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":318,\"x\":136,\"y\":604,\"zone\":\"pag1_3_17\",\"zonepath\":\"[1,3,17]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia\",\"h\":20,\"maxlength\":2,\"name\":\"PROVINCIA2\",\"page\":1,\"spuid\":\"NKJDWBKDWM\",\"tabindex\":174,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":536,\"y\":604,\"zone\":\"pag1_3_17\",\"zonepath\":\"[1,3,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAP\",\"h\":20,\"maxlength\":9,\"name\":\"CAP2\",\"page\":1,\"spuid\":\"MDTHUZMSSI\",\"tabindex\":175,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":66,\"x\":608,\"y\":604,\"zone\":\"pag1_3_17\",\"zonepath\":\"[1,3,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BRPGRCAORR\",\"page\":1,\"spuid\":\"BRPGRCAORR\",\"tabindex\":181,\"type\":\"Label\",\"value\":\"Citt\\u00E0 Domicilio:\",\"w\":117,\"x\":16,\"y\":608,\"zone\":\"pag1_3_17\",\"zonepath\":\"[1,3,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_INUGZKMMHN\",\"page\":1,\"spuid\":\"INUGZKMMHN\",\"tabindex\":182,\"type\":\"Label\",\"value\":\"Provincia:\",\"w\":64,\"x\":472,\"y\":608,\"zone\":\"pag1_3_17\",\"zonepath\":\"[1,3,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PXQUPKOPNQ\",\"page\":1,\"spuid\":\"PXQUPKOPNQ\",\"tabindex\":183,\"type\":\"Label\",\"value\":\"CAP:\",\"w\":40,\"x\":568,\"y\":608,\"zone\":\"pag1_3_17\",\"zonepath\":\"[1,3,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Indirizzo Domicilio\",\"h\":20,\"maxlength\":35,\"name\":\"DOMICILIO2\",\"page\":1,\"spuid\":\"CWOLOHZAQW\",\"tabindex\":176,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":222,\"x\":136,\"y\":636,\"zone\":\"pag1_3_18\",\"zonepath\":\"[1,3,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KBBIQTXMOO\",\"page\":1,\"spuid\":\"KBBIQTXMOO\",\"tabindex\":184,\"type\":\"Label\",\"value\":\"Indirizzo Domicilio:\",\"w\":117,\"x\":16,\"y\":640,\"zone\":\"pag1_3_18\",\"zonepath\":\"[1,3,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Domicilio diverso da residenza\",\"h\":21,\"label_text\":\"Domicilio diverso da residenza\",\"maxlength\":1,\"name\":\"FLGDOM\",\"page\":1,\"spuid\":\"ZJPDUNZSZL\",\"tabindex\":178,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":240,\"x\":136,\"y\":548,\"zone\":\"pag1_3_19\",\"zonepath\":\"[1,3,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Ricerca su Soggetti Segnalati (Black List Interna)\",\"h\":24,\"keep_proportions\":\"bounded\",\"name\":\"image_BYFMKHYARA\",\"page\":1,\"spuid\":\"BYFMKHYARA\",\"src\":\"..\\/{\\\"Char\\\":\\\"60124\\\",\\\"Color\\\":\\\"#000000\\\",\\\"FontName\\\":\\\"ZucchettiDevelopement\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"25\\\"}\",\"tabindex\":193,\"type\":\"Image\",\"w\":32,\"x\":16,\"y\":332,\"zone\":\"pag1_3_20\",\"zonepath\":\"[1,3,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Professione\",\"h\":20,\"maxlength\":40,\"name\":\"PROFESSIONE\",\"page\":1,\"spuid\":\"PAQVIKBAGR\",\"tabindex\":195,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":252,\"x\":136,\"y\":796,\"zone\":\"pag1_3_21\",\"zonepath\":\"[1,3,21]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VBCBZEOPVC\",\"page\":1,\"spuid\":\"VBCBZEOPVC\",\"tabindex\":196,\"type\":\"Label\",\"value\":\"Professione:\",\"w\":117,\"x\":16,\"y\":800,\"zone\":\"pag1_3_21\",\"zonepath\":\"[1,3,21]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Documenti\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Caricamento Documenti\",\"h\":464,\"name\":\"Documenti\",\"page\":2,\"shrinkable\":true,\"spuid\":\"XWJLXLYKJC\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Caricamento Documenti\",\"titled\":true,\"type\":\"Box\",\"w\":1008,\"x\":8,\"y\":8,\"zone\":\"pag2_1\",\"zonepath\":\"[2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":448,\"name\":\"Documenti\",\"page\":2,\"spuid\":\"KUBMCPCHPZ\",\"src\":\"\\/jsp\\/pg_allegati_portlet.jsp?ForcedPortletUID=KUBMCPCHPZ\",\"tabindex\":2,\"type\":\"Portlet\",\"w\":992,\"x\":16,\"y\":16,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":799,\"name\":\"armt_cgo_qadv_operazioni_dl\",\"page\":3,\"spuid\":\"BZRUFRMVDO\",\"tabindex\":1,\"type\":\"Iframe\",\"w\":1005,\"x\":0,\"y\":0,\"zone\":\"pag3_1\",\"zonepath\":\"[3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_cgo_operBO BO,ServletStatus status) {
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
     "<script src='armt_cgo_oper?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_oper_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_oper_edit.js'>" +
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
      status.out.println("w_TIPOGIOCO=a[0];");
      status.out.println("w_CGOTIPOPE=a[1];");
      status.out.println("w_VLTPLAT=a[2];");
      status.out.println("w_CAIDBIGLIETTO=a[3];");
      status.out.println("w_DATAOPE=a[4];");
      status.out.println("w_FLAGCONT=a[5];");
      status.out.println("w_FLAGWALLET=a[6];");
      status.out.println("w_CAFLGOPE=a[7];");
      status.out.println("w_TOTLIRE=a[8];");
      status.out.println("w_TOTCONT=a[9];");
      status.out.println("w_IMPWALLET=a[10];");
      status.out.println("w_CODWALLET=a[11];");
      status.out.println("w_CODTRANSZ=a[12];");
      status.out.println("w_CGOFLGVLT=a[13];");
      status.out.println("w_CGOFLGVNP=a[14];");
      status.out.println("w_MEZPAGAM=a[15];");
      status.out.println("w_CC4CIFRE=a[16];");
      status.out.println("w_CCMESSCA=a[17];");
      status.out.println("w_CCANNSCA=a[18];");
      status.out.println("w_ASSEGNO=a[19];");
      status.out.println("w_IBAN=a[20];");
      status.out.println("w_CCDATSCA=a[21];");
      status.out.println("w_CFESTERO=a[22];");
      status.out.println("w_PEP=a[23];");
      status.out.println("w_CODFISC=a[24];");
      status.out.println("w_COGNOME=a[25];");
      status.out.println("w_NOME=a[26];");
      status.out.println("w_NASCOMUN=a[27];");
      status.out.println("w_TIPINTER=a[28];");
      status.out.println("w_SESSO=a[29];");
      status.out.println("w_NASSTATO=a[30];");
      status.out.println("w_DATANASC=a[31];");
      status.out.println("w_PAESE=a[32];");
      status.out.println("w_DESCCIT=a[33];");
      status.out.println("w_PROVINCIA=a[34];");
      status.out.println("w_CAP=a[35];");
      status.out.println("w_DOMICILIO=a[36];");
      status.out.println("w_NUMTEL=a[37];");
      status.out.println("w_ATTIV=a[38];");
      status.out.println("w_TIPOPERS=a[39];");
      status.out.println("w_RAGSOC=a[40];");
      status.out.println("w_SOTGRUP=a[41];");
      status.out.println("w_RAMOGRUP=a[42];");
      status.out.println("w_SETTSINT=a[43];");
      status.out.println("w_SNAINUMOPE=a[44];");
      status.out.println("op_SNAINUMOPE=a[45];");
      status.out.println("w_DATAREG=a[46];");
      status.out.println("w_TIPOOPRAP=a[47];");
      status.out.println("w_CODANA=a[48];");
      status.out.println("w_CODVOC=a[49];");
      status.out.println("w_VALUTA=a[50];");
      status.out.println("w_CAMBIO=a[51];");
      status.out.println("w_CONNESCLI=a[52];");
      status.out.println("w_CONNESBEN=a[53];");
      status.out.println("w_C_RAG=a[54];");
      status.out.println("w_C_CTA=a[55];");
      status.out.println("w_C_PRV=a[56];");
      status.out.println("w_C_CAP=a[57];");
      status.out.println("w_C_CAB=a[58];");
      status.out.println("w_C_IND=a[59];");
      status.out.println("w_C_STA=a[60];");
      status.out.println("w_CODINTER=a[61];");
      status.out.println("w_SEGNO=a[62];");
      status.out.println("w_FLAGFRAZ=a[63];");
      status.out.println("w_COLLEG=a[64];");
      status.out.println("w_CACODICE=a[65];");
      status.out.println("w_CODCAB=a[66];");
      status.out.println("w_IDDOCALL=a[67];");
      status.out.println("w_FLGDOCALL=a[68];");
      status.out.println("w_TIPODOC=a[69];");
      status.out.println("w_NUMDOCUM=a[70];");
      status.out.println("w_DATARILASC=a[71];");
      status.out.println("w_DATAVALI=a[72];");
      status.out.println("w_RDCODAUT=a[73];");
      status.out.println("w_RDLOCAUT=a[74];");
      status.out.println("w_AUTRILASC=a[75];");
      status.out.println("w_PEPDESCRI=a[76];");
      status.out.println("w_PAESE2=a[77];");
      status.out.println("w_DESCCIT2=a[78];");
      status.out.println("w_PROVINCIA2=a[79];");
      status.out.println("w_CAP2=a[80];");
      status.out.println("w_DOMICILIO2=a[81];");
      status.out.println("w_FLGDOM=a[82];");
      status.out.println("w_PROFESSIONE=a[83];");
      status.out.println("w_CODDIPE=a[84];");
      status.out.println("w_DESCCITDIP=a[85];");
      status.out.println("w_PROVINCIADIP=a[86];");
      status.out.println("w_CODCABDIP=a[87];");
      status.out.println("w_gIntemediario=a[88];");
      status.out.println("w_xSOGTPGIO=a[89];");
      status.out.println("w_xDEFTPGIO=a[90];");
      status.out.println("w_xEDTTPGIO=a[91];");
      status.out.println("w_xEDTSPGIO=a[92];");
      status.out.println("w_xDEFSPGIO=a[93];");
      status.out.println("w_xFLGPLGIO=a[94];");
      status.out.println("w_FILTROMP=a[95];");
      status.out.println("w_FLGPAGAM=a[96];");
      status.out.println("w_idcitta=a[97];");
      status.out.println("w_xARDESCRI=a[98];");
      status.out.println("w_dessta=a[99];");
      status.out.println("w_tipsot=a[100];");
      status.out.println("w_STATOREG=a[101];");
      status.out.println("w_IDBASE=a[102];");
      status.out.println("w_NUMPROG=a[103];");
      status.out.println("w_DESCRI=a[104];");
      status.out.println("w_gSeekAos=a[105];");
      status.out.println("w_gDataVaria=a[106];");
      status.out.println("w_gFlgDoc=a[107];");
      status.out.println("w_gCodDip=a[108];");
      status.out.println("w_xDescDipe=a[109];");
      status.out.println("w_datpaseuro=a[110];");
      status.out.println("w_xdes1=a[111];");
      status.out.println("w_desccauana=a[112];");
      status.out.println("w_CITINT=a[113];");
      status.out.println("w_CITDIP=a[114];");
      status.out.println("w_PROVDIP=a[115];");
      status.out.println("w_CABDIP=a[116];");
      status.out.println("w_PROVINT=a[117];");
      status.out.println("w_CABINT=a[118];");
      status.out.println("w_xdesccausin=a[119];");
      status.out.println("w_gChkDate=a[120];");
      status.out.println("w_xdesctipatt=a[121];");
      status.out.println("w_gVLT=a[122];");
      status.out.println("w_gVNP=a[123];");
      status.out.println("w_gStpDwn=a[124];");
      status.out.println("w_MIDBIGLIETTO=a[125];");
      status.out.println("w_MIDBIGLIETTO1=a[126];");
      status.out.println("w_MIDBIGLIETTO4=a[127];");
      status.out.println("w_MIDBIGLIETTO2=a[128];");
      status.out.println("w_MIDBIGLIETTO3=a[129];");
      status.out.println("w_gPathApp=a[130];");
      status.out.println("w_xVPFLGATT=a[131];");
      status.out.println("w_DOC03=a[132];");
      status.out.println("w_DOC04=a[133];");
      status.out.println("w_gGesDoc=a[134];");
      status.out.println("w_edtdoc=a[135];");
      status.out.println("w_saveddoc=a[136];");
      status.out.println("w_xIMPMINGIO=a[137];");
      status.out.println("w_idcitta2=a[138];");
      status.out.println("w_dessta2=a[139];");
      status.out.println("w_gTipMul=a[140];");
      status.out.println("w_FLGQADVFULL=a[141];");
      status.out.println("w_gQADV=a[142];");
      status.out.println("w_xCGOFLGPROF=a[143];");
      status.out.println("w_TELDIP=a[144];");
      status.out.println("w_CODLOC=a[145];");
      status.out.println("w_dirupl=a[146];");
      status.out.println("w_ANA_FOUND=a[147];");
      status.out.println("op_codazi=a[148];");
      status.out.println("m_cWv_armt_cgo_qadv_operazioni_dl=a[149];;");
      status.out.println("if (Gt(a.length,150)) {");
      status.out.println("m_cErrorInChild='';");
      status.out.println("}");
      status.out.println("if (Gt(a.length,150)) {");
      status.out.println("o_TIPOGIOCO=w_TIPOGIOCO;");
      status.out.println("o_CAIDBIGLIETTO=w_CAIDBIGLIETTO;");
      status.out.println("o_DATAOPE=w_DATAOPE;");
      status.out.println("o_FLAGCONT=w_FLAGCONT;");
      status.out.println("o_FLAGWALLET=w_FLAGWALLET;");
      status.out.println("o_CAFLGOPE=w_CAFLGOPE;");
      status.out.println("o_TOTLIRE=w_TOTLIRE;");
      status.out.println("o_TOTCONT=w_TOTCONT;");
      status.out.println("o_IMPWALLET=w_IMPWALLET;");
      status.out.println("o_FILTROMP=w_FILTROMP;");
      status.out.println("o_CGOFLGVLT=w_CGOFLGVLT;");
      status.out.println("o_FLGPAGAM=w_FLGPAGAM;");
      status.out.println("o_MEZPAGAM=w_MEZPAGAM;");
      status.out.println("o_COGNOME=w_COGNOME;");
      status.out.println("o_NOME=w_NOME;");
      status.out.println("o_NASCOMUN=w_NASCOMUN;");
      status.out.println("o_TIPINTER=w_TIPINTER;");
      status.out.println("o_NASSTATO=w_NASSTATO;");
      status.out.println("o_PAESE=w_PAESE;");
      status.out.println("o_idcitta=w_idcitta;");
      status.out.println("o_ATTIV=w_ATTIV;");
      status.out.println("o_SOTGRUP=w_SOTGRUP;");
      status.out.println("o_TIPOOPRAP=w_TIPOOPRAP;");
      status.out.println("o_CONNESBEN=w_CONNESBEN;");
      status.out.println("o_C_CTA=w_C_CTA;");
      status.out.println("o_CODINTER=w_CODINTER;");
      status.out.println("o_COLLEG=w_COLLEG;");
      status.out.println("o_DATARILASC=w_DATARILASC;");
      status.out.println("o_DATAVALI=w_DATAVALI;");
      status.out.println("o_RDCODAUT=w_RDCODAUT;");
      status.out.println("o_RDLOCAUT=w_RDLOCAUT;");
      status.out.println("o_PAESE2=w_PAESE2;");
      status.out.println("o_idcitta2=w_idcitta2;");
      status.out.println("o_CODDIPE=w_CODDIPE;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['SNAINUMOPE'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_cgo_oper_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(893,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","cgo_operazioni_dl");
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
  void RaiseLoadedEntity(armt_cgo_operBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({SNAINUMOPE:"+SPLib.ToJSValue(BO.w_SNAINUMOPE,"C",15,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_cgo_operBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(armt_cgo_operBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(armt_cgo_operBO BO,ServletStatus status) {
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
  void WriteExitPage(armt_cgo_operBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({SNAINUMOPE:"+SPLib.ToJSValue(BO.w_SNAINUMOPE,"C",15,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_cgo_operBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_cgo_operBO BO,ServletStatus status) throws IOException {
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
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_cgo_moduli.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_cgo_read_codfisc_dl.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_agechar.m_cEntityUid+"/arfn_agechar.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_cgo_chkcap.m_cEntityUid+"/arfn_cgo_chkcap.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_cgo_chkcc.m_cEntityUid+"/arfn_cgo_chkcc.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_cgo_chkdata.m_cEntityUid+"/arfn_cgo_chkdata.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_cgo_chkidb.m_cEntityUid+"/arfn_cgo_chkidb.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chk_docaut.m_cEntityUid+"/arfn_chk_docaut.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chkcodfis.m_cEntityUid+"/arfn_chkcodfis.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chkiban.m_cEntityUid+"/arfn_chkiban.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chktotalelire_cont.m_cEntityUid+"/arfn_chktotalelire_cont.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_form_cf.m_cEntityUid+"/arfn_form_cf.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_maggiorenne.m_cEntityUid+"/arfn_maggiorenne.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arrt_cgo_setpagatore.m_cEntityUid+"/arrt_cgo_setpagatore.js'>" +
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
      arfn_cgo_chkcap.GetCallableNames(callable);
      arfn_cgo_chkcc.GetCallableNames(callable);
      arfn_cgo_chkdata.GetCallableNames(callable);
      arfn_cgo_chkidb.GetCallableNames(callable);
      arfn_chk_docaut.GetCallableNames(callable);
      arfn_chkcodfis.GetCallableNames(callable);
      arfn_chkiban.GetCallableNames(callable);
      arfn_chktotalelire_cont.GetCallableNames(callable);
      arfn_form_cf.GetCallableNames(callable);
      arfn_maggiorenne.GetCallableNames(callable);
      arrt_cgo_setpagatore.GetCallableNames(callable);
      CPLib.AddToSet(callable,"LibreriaMit");
      CPLib.AddToSet(callable,"Utilities");
      CPLib.AddToSet(callable,"arfn_form_cf");
      CPLib.AddToSet(callable,"arrt_cgo_moduli");
      CPLib.AddToSet(callable,"arrt_cgo_read_codfisc_dl");
      CPLib.AddToSet(callable,"armt_cgo_qadv_operazioni_dl");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_cgo_operBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_SNAINUMOPE),"C",15,0));
      }
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gIntemediario),"C",11,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gSeekAos),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(BO.w_gDataVaria,"D",8,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gFlgDoc),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gCodDip),"C",6,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gChkDate),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(BO.w_gVLT,"N",10,2));
      hCreator.AddValue(CPLib.ToSQL(BO.w_gVNP,"N",10,2));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gStpDwn),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gPathApp),"C",80,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gGesDoc),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gTipMul),"C",3,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gQADV),"C",1,0));
    } else if (CPLib.eq(p_cUID,"QZTTRBWAQL")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"LVYFMQXNZH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NEUBQNUEOJ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"HODZKKOSYW")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"YVIKEGPYPM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ODAYKSRECA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"XPSJTIMTNR")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SAQTIHOALW")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"UJRFWINIVQ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ULVCBLFVEU")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"KUPRRTVLKH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"WJSVGWKSFC")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"MSGBKOOAOY")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"MBGANUUHRA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"YDUQCBNYFV")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"UOOQYQWWNG")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"BVEIQEJCLQ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"HNAYMCHXMY")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"AVHTGZTOSZ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_cgo_operBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_TIPOGIOCO))) {
        a = GetCheckVars(status,BO,"QZTTRBWAQL");
        b = status.m_CheckVars.optString("QZTTRBWAQL");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_VLTPLAT))) {
        a = GetCheckVars(status,BO,"LVYFMQXNZH");
        b = status.m_CheckVars.optString("LVYFMQXNZH");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_PAESE))) {
        a = GetCheckVars(status,BO,"YVIKEGPYPM");
        b = status.m_CheckVars.optString("YVIKEGPYPM");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_idcitta))) {
        a = GetCheckVars(status,BO,"XPSJTIMTNR");
        b = status.m_CheckVars.optString("XPSJTIMTNR");
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
      if (result &&  ! (CPLib.Empty(BO.w_COLLEG))) {
        a = GetCheckVars(status,BO,"MSGBKOOAOY");
        b = status.m_CheckVars.optString("MSGBKOOAOY");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_TIPODOC))) {
        a = GetCheckVars(status,BO,"MBGANUUHRA");
        b = status.m_CheckVars.optString("MBGANUUHRA");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_RDCODAUT))) {
        a = GetCheckVars(status,BO,"YDUQCBNYFV");
        b = status.m_CheckVars.optString("YDUQCBNYFV");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_PAESE2))) {
        a = GetCheckVars(status,BO,"UOOQYQWWNG");
        b = status.m_CheckVars.optString("UOOQYQWWNG");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_idcitta2))) {
        a = GetCheckVars(status,BO,"HNAYMCHXMY");
        b = status.m_CheckVars.optString("HNAYMCHXMY");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CODDIPE))) {
        a = GetCheckVars(status,BO,"AVHTGZTOSZ");
        b = status.m_CheckVars.optString("AVHTGZTOSZ");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
