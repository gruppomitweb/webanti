import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_snai_oper_v extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*5d01e100*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "cgo_operazioni";
    }
    public String w_SNAINUMOPE;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_SNAINUMOPE,context,"cgo_operazioni","SNAINUMOPE","C",15,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
    armt_snai_oper_vBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_cgo_operazioni;
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
    return "Operazioni (CGO)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_snai_oper_v";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 797;
    l_eg.m_nEntityHeight = 825;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"cgo_operazioni","cgo_tbtipgio","tbcitta","tbstati","tbtipatt","tbtipreg","tbcauana","personbo","intermbo","anadip","operazbo","tbcausin","cgo_causali","cgo_tipdoc","cgo_autorita"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","Dati Base","page"),new ZoneItem("page_2","Documenti","page"),new ZoneItem("page_3","Contatto","page"),new ZoneItem("Base","Dati base","horizontal_section"),new ZoneItem("Operazione","Dati Operazione","horizontal_section"),new ZoneItem("Soggetto","Dati Soggetto","collapsible"),new ZoneItem("box_XWJLXLYKJC","",""),new ZoneItem("box_NYSCBMMEEX","","")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"SNAINUMOPE"};
    l_eg.items = new SPItem[]{
                   new SPItem("gIntemediario","C",11,0, "show","Intermediario"),
                   new SPItem("TIPOGIOCO","C",3,0, "show","Tipo gioco"),
                   new SPItem("xSOGTPGIO","N",12,2, "hide","Soglia pagamento Agenzia"),
                   new SPItem("xDEFTPGIO","C",1,0, "hide","Default (A=Agenzia , S=Concessionario)"),
                   new SPItem("xEDTTPGIO","C",1,0, "hide","Abilita modifica Scelta"),
                   new SPItem("xEDTSPGIO","C",1,0, "hide","Abilita Modifica Sotto Soglia"),
                   new SPItem("xDEFSPGIO","C",1,0, "hide","Default Sotto Soglia"),
                   new SPItem("TIPOPERS","C",1,0, "hide",""),
                   new SPItem("CGOFLGVNP","C",1,0, "hide","Pagamento Vincite prenotate"),
                   new SPItem("TOTLIRE","N",15,2, "show","Totale Operazione"),
                   new SPItem("CGOFLGVLT","C",1,0, "show","Pagamento VLT"),
                   new SPItem("MEZPAGAM","C",1,0, "show","Mezzo Pagamento"),
                   new SPItem("ASSEGNO","C",25,0, "show","Assegno"),
                   new SPItem("IBAN","C",27,0, "show","IBAN per Bonifici"),
                   new SPItem("CC4CIFRE","C",4,0, "show","Ultime Cifre CC"),
                   new SPItem("CCDATSCA","C",7,0, "show","Scadenza"),
                   new SPItem("CFESTERO","N",1,0, "show","Codice Fiscale Estero"),
                   new SPItem("CODFISC","C",16,0, "show","Codice Fiscale"),
                   new SPItem("COGNOME","C",26,0, "show","Cognome"),
                   new SPItem("NOME","C",25,0, "show","Nome"),
                   new SPItem("NASCOMUN","C",30,0, "show","Luogo di Nascita"),
                   new SPItem("TIPINTER","C",2,0, "show","Prov."),
                   new SPItem("SESSO","C",1,0, "show","Sesso"),
                   new SPItem("NASSTATO","C",30,0, "show","Stato di nascita"),
                   new SPItem("DATANASC","D",8,0, "show","Data Nascita"),
                   new SPItem("PAESE","C",3,0, "show","Stato"),
                   new SPItem("RAGSOC","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("DESCCIT","C",40,0, "show","Città"),
                   new SPItem("PROVINCIA","C",2,0, "show","Provincia"),
                   new SPItem("CAP","C",9,0, "show","CAP"),
                   new SPItem("CODCAB","C",6,0, "hide","CAB"),
                   new SPItem("DOMICILIO","C",35,0, "show","Indirizzo"),
                   new SPItem("NUMTEL","C",20,0, "show","Numero Telefono"),
                   new SPItem("xARDESCRI","C",15,0, "hide","Descrizione"),
                   new SPItem("ATTIV","C",10,0, "hide","Attività Prevalente"),
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
                   new SPItem("PEP","C",1,0, "hide","Persona Politicamente Esposta"),
                   new SPItem("SNAINUMOPE","C",15,0, "edit","N° Operazione"),
                   new SPItem("DATAOPE","D",8,0, "edit","Data Operazione"),
                   new SPItem("DATAREG","D",8,0, "show","Data registrazione"),
                   new SPItem("FLAGCONT","C",1,0, "show","Contanti (S/N)"),
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
                   new SPItem("NUMPROG","C",11,0, "hide","Numero Progressivo"),
                   new SPItem("CODINTER","C",11,0, "hide","Codice Intermediario"),
                   new SPItem("CODDIPE","C",6,0, "show","Codice Dipendenza"),
                   new SPItem("DESCCITDIP","C",30,0, "show","Città Dipendenza"),
                   new SPItem("SEGNO","C",1,0, "hide","Segno"),
                   new SPItem("FLAGFRAZ","C",1,0, "hide","Frazionata (S/N)"),
                   new SPItem("COLLEG","C",11,0, "hide","Collegamento Operazione Multiple"),
                   new SPItem("PROVINCIADIP","C",2,0, "show","Provincia Dipendenza"),
                   new SPItem("CODCABDIP","C",6,0, "show","CAB Dipendenza"),
                   new SPItem("xDescDipe","C",30,0, "hide","Descrizione"),
                   new SPItem("datpaseuro","D",8,0, "hide","Data Passaggio EURO"),
                   new SPItem("xdes1","C",90,0, "hide","Descrizione"),
                   new SPItem("desccauana","C",165,0, "hide","Descrizione"),
                   new SPItem("CITINT","C",30,0, "hide","Città"),
                   new SPItem("CITDIP","C",30,0, "hide","Città"),
                   new SPItem("PROVDIP","C",2,0, "hide","Provincia"),
                   new SPItem("CABDIP","C",6,0, "hide","CAB"),
                   new SPItem("PROVINT","C",2,0, "hide","Provincia"),
                   new SPItem("CABINT","C",6,0, "hide","CAB"),
                   new SPItem("CODVOC","C",2,0, "hide","Causale Sintetica"),
                   new SPItem("xdesccausin","C",165,0, "hide","Descrizione"),
                   new SPItem("TOTCONT","N",15,2, "show","di cui contanti"),
                   new SPItem("gChkDate","C",1,0, "hide","Controllo Date"),
                   new SPItem("idcitta","C",10,0, "hide","Codice"),
                   new SPItem("CACODICE","N",5,0, "show","Causale"),
                   new SPItem("CAIDBIGLIETTO","C",30,0, "show","ID BIGLIETTO"),
                   new SPItem("xdesctipatt","C",250,0, "hide","Descrizione"),
                   new SPItem("gVLT","N",10,2, "hide","Limite VLT"),
                   new SPItem("gVNP","N",10,2, "hide","Limite VNP"),
                   new SPItem("CGOTIPOPE","C",1,0, "hide","Tipo Gioco"),
                   new SPItem("gCodDip","C",6,0, "hide","Dipendenza"),
                   new SPItem("verifica","C",1,0, "edit",""),
                   new SPItem("NUMOPEDL","C",15,0, "edit","Operazione da cancellare"),
                   new SPItem("gStpDwn","C",1,0, "hide","Stampa Download"),
                   new SPItem("MIDBIGLIETTO","M",10,0, "hide",""),
                   new SPItem("MIDBIGLIETTO1","M",10,0, "hide",""),
                   new SPItem("MIDBIGLIETTO2","M",10,0, "hide",""),
                   new SPItem("MIDBIGLIETTO3","M",10,0, "hide",""),
                   new SPItem("MIDBIGLIETTO4","M",10,0, "hide",""),
                   new SPItem("CAFLGOPE","C",1,0, "show","Tipo Registrazione"),
                   new SPItem("TELDIP","C",15,0, "hide","Telefono"),
                   new SPItem("CODLOC","C",25,0, "hide","Codice Locale (CGO)"),
                   new SPItem("xFLGPLGIO","C",1,0, "hide","Abilita Selezione Piattaforma"),
                   new SPItem("IDDOCALL","C",36,0, "hide","ID Collegamento Documenti"),
                   new SPItem("FLGDOCALL","C",1,0, "edit","Flag Documentazione Completa"),
                   new SPItem("VLTPLAT","C",2,0, "show","Piattaforma VLT"),
                   new SPItem("xVPFLGATT","C",1,0, "hide","Piattaforma Attiva"),
                   new SPItem("DOC03","C",80,0, "edit",""),
                   new SPItem("DOC04","C",80,0, "edit",""),
                   new SPItem("tipop","C",1,0, "edit",""),
                   new SPItem("FLGSAVE","C",1,0, "hide",""),
                   new SPItem("PEP","C",1,0, "show","Persona Politicamente Esposta"),
                   new SPItem("TIPODOC","C",2,0, "show","Tipo Documento"),
                   new SPItem("NUMDOCUM","C",15,0, "show","Numero Doc."),
                   new SPItem("DATARILASC","D",8,0, "show","Rilascio Doc."),
                   new SPItem("DATAVALI","D",8,0, "show","Data Fine Validità"),
                   new SPItem("RDCODAUT","C",2,0, "show","Autorità Rilascio"),
                   new SPItem("RDLOCAUT","C",20,0, "show","Luogo Autorità Rilascio"),
                   new SPItem("AUTRILASC","C",30,0, "show","Autorità di rilascio"),
                   new SPItem("PEPDESCRI","C",80,0, "show","Descrizione PEP"),
                   new SPItem("PAESE2","C",3,0, "show","Stato Domicilio"),
                   new SPItem("DESCCIT2","C",40,0, "show","Città Domicilio"),
                   new SPItem("PROVINCIA2","C",2,0, "show","Provincia"),
                   new SPItem("CAP2","C",9,0, "show","CAP"),
                   new SPItem("DOMICILIO2","C",35,0, "show","Indirizzo Domicilio"),
                   new SPItem("FLGDOM","C",1,0, "show","Domicilio diverso da residenza"),
                   new SPItem("dessta2","C",40,0, "hide","Descrizione"),
                   new SPItem("CGODATCON","D",8,0, "show","Data Contatto"),
                   new SPItem("CGOESICON","C",2,0, "show","Esito Contatto"),
                   new SPItem("CGONOTCON","M",10,0, "edit","Note Contatto")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_snai_oper_vBO BO) {
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
    l_translations=new String[][]{{"10032163180",p_Context.Translate("Autorità di rilascio")},
    {"10034405761",p_Context.Translate("Codice Fiscale Estero")},
    {"10095365423",p_Context.Translate("Provincia")},
    {"1021466915",p_Context.Translate("Esito Contatto")},
    {"10219814530",p_Context.Translate("Codice Cliente Occasionale")},
    {"10220423475",p_Context.Translate("Data Variazione")},
    {"1028598955",p_Context.Translate("Data registrazione")},
    {"10290663779",p_Context.Translate("ID Collegamento Documenti")},
    {"1033518927",p_Context.Translate("Attività Prevalente")},
    {"10524120562",p_Context.Translate("ID BIGLIETTO")},
    {"10574713661",p_Context.Translate("Numero Telefono")},
    {"10605582583",p_Context.Translate("Impossibile selezionare una piattaforma non attiva!")},
    {"10651434988",p_Context.Translate("Mezzo Pagamento")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"10787648910",p_Context.Translate("Stampa Download")},
    {"10848850431",p_Context.Translate("CAB Dipendenza")},
    {"1093030153",p_Context.Translate("Codice Locale (CGO)")},
    {"10943726013",p_Context.Translate("di cui contanti")},
    {"109710548",p_Context.Translate("Divisa")},
    {"11061636098",p_Context.Translate("Default Sotto Soglia")},
    {"11137644647",p_Context.Translate("Tipo Operazione Completa")},
    {"11247539166",p_Context.Translate("Piattaforma VLT")},
    {"11256417841",p_Context.Translate("Pagamento VLT")},
    {"112851763",p_Context.Translate("Codice")},
    {"11316624286",p_Context.Translate("Codice Intermediario")},
    {"11356972522",p_Context.Translate("Provincia Dipendenza")},
    {"11393904432",p_Context.Translate("Città Domicilio")},
    {"11396780126",p_Context.Translate("Intermediario")},
    {"11401314672",p_Context.Translate("Stato Domicilio")},
    {"11429032151",p_Context.Translate("Tipo Documento")},
    {"11525797640",p_Context.Translate("%ERRORMESSAGE%")},
    {"11529669945",p_Context.Translate("Il paese di residenza deve essere congruente con il flag di soggetto estero!")},
    {"1153315661",p_Context.Translate("Operazioni (CGO)")},
    {"11628234069",p_Context.Translate("Operazione da cancellare")},
    {"11642408994",p_Context.Translate("Ultime Cifre CC")},
    {"11777527481",p_Context.Translate("Data Nascita")},
    {"11857312893",p_Context.Translate("Scadenza")},
    {"11921223220",p_Context.Translate("Codice Fiscale")},
    {"11925635672",p_Context.Translate("Collegamento con AOS")},
    {"11993248424",p_Context.Translate("N° Operazione")},
    {"12033514136",p_Context.Translate("Limite VLT")},
    {"12033514198",p_Context.Translate("Limite VNP")},
    {"1209108021",p_Context.Translate("Codice Fiscale non congruente con dati anagrafici")},
    {"12123284333",p_Context.Translate("Stato di nascita")},
    {"12123334500",p_Context.Translate("Luogo di Nascita")},
    {"1216938285",p_Context.Translate("Data Fine Validità")},
    {"123704147",p_Context.Translate("Cambio")},
    {"1255218623",p_Context.Translate("Abilita Selezione Piattaforma")},
    {"1264575246",p_Context.Translate("Abilita modifica Scelta")},
    {"1267255314",p_Context.Translate("Persona Esposta Politicamente")},
    {"1270140254",p_Context.Translate("Dipendenza")},
    {"1270140318",p_Context.Translate("Dipendenze")},
    {"1319025851",p_Context.Translate("Domicilio diverso da residenza")},
    {"1405961432",p_Context.Translate("Data Contatto")},
    {"1405978050",p_Context.Translate("Note Contatto")},
    {"1475053609",p_Context.Translate("Luogo Autorità Rilascio")},
    {"1489090677",p_Context.Translate("Autorità non valida per il tipo documento selezionato")},
    {"1513560829",p_Context.Translate("Persona Politicamente Esposta")},
    {"15186643",p_Context.Translate("Città")},
    {"1570205239",p_Context.Translate("Tipo Gioco")},
    {"1603759671",p_Context.Translate("Tipo gioco")},
    {"1608394306",p_Context.Translate("Rilascio Doc.")},
    {"1700577956",p_Context.Translate("Telefono")},
    {"1705711075",p_Context.Translate("Descrizione PEP")},
    {"1710847762",p_Context.Translate("Default (A=Agenzia , S=Concessionario)")},
    {"1715238713",p_Context.Translate("Codice Fiscale Errato nel formato")},
    {"1722199786",p_Context.Translate("Frazionata (S/N)")},
    {"1734932797",p_Context.Translate("Numero Doc.")},
    {"1745819304",p_Context.Translate("Piattaforma Attiva")},
    {"1748201363",p_Context.Translate("Città Dipendenza")},
    {"18003",p_Context.Translate("CAB")},
    {"1814604627",p_Context.Translate("Causale")},
    {"1816546867",p_Context.Translate("Cognome")},
    {"1825772649",p_Context.Translate("Totale Operazione")},
    {"1890893827",p_Context.Translate("Clienti")},
    {"1973525056",p_Context.Translate("Autorità Rilascio")},
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
    {"316744004",p_Context.Translate("Soglia pagamento Agenzia")},
    {"3528304",p_Context.Translate("Prov.")},
    {"443454",p_Context.Translate("Nome")},
    {"448095445",p_Context.Translate("Pagamento Vincite prenotate")},
    {"453879700",p_Context.Translate("Indirizzo Domicilio")},
    {"484567773",p_Context.Translate("Prevalente Attività")},
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
    {"829201110",p_Context.Translate("Data Operazione")},
    {"839211622",p_Context.Translate("Numero Progressivo")},
    {"864597548",p_Context.Translate("Collegamento con storico documenti")},
    {"906181626",p_Context.Translate("Soggetto Residente All'Estero")},
    {"976489378",p_Context.Translate("Controllo Date")},
    {"981524941",p_Context.Translate("Abilita Modifica Sotto Soglia")},
    {"995100987",p_Context.Translate("Tipo Registrazione")}};
    return l_translations;
  }
  void WriteStyles(armt_snai_oper_vBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_snai_oper_v.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_snai_oper_vBO BO,ServletStatus status) {
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
    status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati Base"),"C",0,0)+"},{name:\"page_2\", element:\"page_2\", caption:"+SPLib.ToJSValue(status.context.Translate("Documenti"),"C",0,0)+"},{name:\"page_3\", element:\"page_3\", caption:"+SPLib.ToJSValue(status.context.Translate("Contatto"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
    status.out.println("Z.Tabs.Set('tabs',tabs);");
    status.out.println("} else {");
    status.out.println("var tabs = Z.Tabs.Get('tabs')");
    status.out.println("}");
    AddExtendedTabs(status);
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_snai_oper_v',false);");
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_snai_oper_v",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  // GetPortlet_Documenti_Vars
  com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars GetPortlet_KUBMCPCHPZ_Vars(armt_snai_oper_vBO BO,ServletStatus status) {
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.Vars inclusionVars;
    inclusionVars = com.zucchetti.sitepainter.Library.IncludedPortletUtils.buildVars();
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"aTG",BO.w_TIPOGIOCO);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"aOrigine","C");
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"aImporto",BO.w_TOTLIRE);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"aContanti",BO.w_TOTCONT);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"aFull",BO.w_FLGDOCALL);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"aID",BO.w_IDDOCALL);
    com.zucchetti.sitepainter.Library.IncludedPortletUtils.addAttribute(inclusionVars,"aIDTicket",BO.w_CAIDBIGLIETTO);
    return inclusionVars;
  }
  void WriteControls(armt_snai_oper_vBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    WriteControls_p2(BO,status);
    WriteControls_p3(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,4);
  }
  void WriteControls_p1(armt_snai_oper_vBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:825px;width:797px;display:none'>" +
    "");
    WriteControls_p1_b0(BO,status);
    WriteControls_p1_b1(BO,status);
    WriteControls_p1_b2(BO,status);
    WriteControls_p1_b3(BO,status);
    WriteControls_p1_b4(BO,status);
    WriteControls_p1_b5(BO,status);
    WriteControls_p1_b6(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"Dati Base");
    PrintSidebarContent(1,status,getSidebarItems(0),true);
    PrintContextMenu(1,status,getContextMenu(0),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2(armt_snai_oper_vBO BO,ServletStatus status) {
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
  void WriteControls_p3(armt_snai_oper_vBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_3' class='PageContainer' style='position:relative;height:293px;width:797px;display:none'>" +
    "");
    WriteControls_p3_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,3,"Contatto");
    PrintSidebarContent(3,status,getSidebarItems(2),false);
    PrintContextMenu(3,status,getContextMenu(2),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b0(armt_snai_oper_vBO BO,ServletStatus status) {
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
  void WriteControls_p1_b1(armt_snai_oper_vBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Base' id='CCUOYXMBZC_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='CCUOYXMBZC_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='CCUOYXMBZC_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati base")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='CCUOYXMBZC_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"CCUOYXMBZC\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=CCUOYXMBZC_HEADER&m_cBoxId=CCUOYXMBZC&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati base"))+"");
    }
    status.out.println(
     "<div id='CCUOYXMBZC' class='SectionBody' style='position:relative;height:91px;display:block'>" +
    "");
    status.includeZoneAltInterface("Base@BEGIN");
    if (status.includeZoneAltInterface("Base")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Base@BEGIN") || status.HasZoneAltInterface("Base@END")) {
        status.out.println(
         "<div id='CCUOYXMBZC_boxContent' style='position:relative;height:91px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<input name='gIntemediario' id='GXLWKNXGMM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_gIntemediario,"C",11,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='11' fieldtype='C'>" +
      "");
      status.out.println(
       "<select name='TIPOGIOCO' id='QZTTRBWAQL' class='Combobox Disabled' disabled>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SNAINUMOPE' id='XFUOZLSACP' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_SNAINUMOPE,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel PrimaryKeyLabel' id='GZVEXPFQCZ_DIV'>" +
       "<label id='GZVEXPFQCZ' for='XFUOZLSACP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("N° Operazione:"))+"" +
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
      status.out.println(
       "<input name='PROVINCIADIP' id='OJGQABFSYN' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_PROVINCIADIP,"C",2,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='CODCABDIP' id='OZEOCQRSEQ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CODCABDIP,"C",6,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='6' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='CAIDBIGLIETTO' id='BMTLGIUQTH' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CAIDBIGLIETTO,"C",30,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='30' size='30' fieldtype='C'>" +
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
       "<select name='VLTPLAT' id='LVYFMQXNZH' class='Combobox Disabled' disabled>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      if (status.HasZoneAltInterface("Base@BEGIN") || status.HasZoneAltInterface("Base@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b1_CloseBand(armt_snai_oper_vBO BO,ServletStatus status) {
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
      status.out.println("Ctrl('CCUOYXMBZC').setAttribute('band_height',91);");
    }
    status.out.println("Ctrl('CCUOYXMBZC').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_snai_oper_vBO BO,ServletStatus status) {
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
  void WriteControls_p1_b3(armt_snai_oper_vBO BO,ServletStatus status) {
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
     "<div id='YORQOIOBQN' class='SectionBody' style='position:relative;height:182px;display:block'>" +
    "");
    status.includeZoneAltInterface("Operazione@BEGIN");
    if (status.includeZoneAltInterface("Operazione")) {
      WriteControls_p1_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Operazione@BEGIN") || status.HasZoneAltInterface("Operazione@END")) {
        status.out.println(
         "<div id='YORQOIOBQN_boxContent' style='position:relative;height:182px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<input name='TOTLIRE' id='HUAGBHPUNH' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TOTLIRE,"N",15,2,"999,999,999,999.99", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='21' size='15' fieldtype='N'>" +
      "");
      status.out.println(
       "<div id='SFKJNKYLJO_DIV'>" +
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
      status.out.println(
       "<select name='MEZPAGAM' id='EOSKLIUGBC' class='Combobox Disabled' disabled>" +
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
       "<input name='ASSEGNO' id='KZWBLPQNHU' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_ASSEGNO,"C",25,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='25' size='25' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<input name='IBAN' id='UTUCDPQJKK' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_IBAN,"C",27,0,"!", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='27' size='27' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<input name='CC4CIFRE' id='FKEAKFSYVU' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CC4CIFRE,"C",4,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='4' size='4' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<input name='CCDATSCA' id='OXFYJQLTDL' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CCDATSCA,"C",7,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='7' size='7' fieldtype='C' style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAOPE' id='YLIKFVPZJA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATAOPE,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.out.println(
       "<input name='DATAREG' id='OEIKQOZMYJ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DATAREG,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.out.println(
       "<select name='FLAGCONT' id='PURPSXEVAI' class='Combobox Disabled' disabled>" +
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
       "<input name='TOTCONT' id='HUDOCMLKKT' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TOTCONT,"N",15,2,"999,999,999,999.99", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='21' size='15' fieldtype='N'>" +
      "");
      status.out.println(
       "<select name='CACODICE' id='WJQFIEBCQV' class='Combobox Disabled' disabled>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YFGRJCQGZV_DIV'>" +
       "<label id='YFGRJCQGZV' for='WJQFIEBCQV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Causale:"))+"" +
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
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NUMOPEDL' id='HILLZZMRNQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NUMOPEDL,"C",15,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='15' size='15' fieldtype='C' style='display:none'>" +
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
       "<input name='FLGDOCALL' id='ZUVVNOUSIQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_FLGDOCALL,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='1' size='1' fieldtype='C' style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DOC03' id='PAADFVDPUD' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_DOC03,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='80' size='80' fieldtype='C' style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DOC04' id='SIRTAMVPQN' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_DOC04,"C",80,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='80' size='80' fieldtype='C' style='display:none'>" +
      "");
      if (status.HasZoneAltInterface("Operazione@BEGIN") || status.HasZoneAltInterface("Operazione@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b3_CloseBand(armt_snai_oper_vBO BO,ServletStatus status) {
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
      status.out.println("Ctrl('YORQOIOBQN').setAttribute('band_height',182);");
    }
    status.out.println("Ctrl('YORQOIOBQN').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b4(armt_snai_oper_vBO BO,ServletStatus status) {
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
  void WriteControls_p1_b5(armt_snai_oper_vBO BO,ServletStatus status) {
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
     "<div id='AQSQVBKXAL' class='CollapsibleBody' style='position:relative;height:475px;display:block'>" +
    "");
    status.includeZoneAltInterface("Soggetto@BEGIN");
    if (status.includeZoneAltInterface("Soggetto")) {
      WriteControls_p1_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Soggetto@BEGIN") || status.HasZoneAltInterface("Soggetto@END")) {
        status.out.println(
         "<div id='AQSQVBKXAL_boxContent' style='position:relative;height:475px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<span id='CZTHKEDVCO_DIV'>" +
       "<input name='CFESTERO' id='CZTHKEDVCO' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_CFESTERO,"N",1,0,"", status.m_oRegSettings)+" disabled "+(CPLib.eq(1,BO.w_CFESTERO)?"CHECKED":"")+">" +
       "<label id='CZTHKEDVCO_LBL' for='CZTHKEDVCO' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Soggetto Residente All'Estero"))+"</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='CODFISC' id='OJJHIUDPFY' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CODFISC,"C",16,0,"!", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='16' size='16' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='COGNOME' id='TWTTDWKCRG' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_COGNOME,"C",26,0,"!", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='26' size='26' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='NOME' id='WWGIVGNUDW' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_NOME,"C",25,0,"!", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='25' size='25' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='NASCOMUN' id='NEUBQNUEOJ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_NASCOMUN,"C",30,0,"!", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='30' size='30' fieldtype='C' autocomplete='off'>" +
      "");
      status.out.println(
       "<input name='TIPINTER' id='KPSCOABZLB' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_TIPINTER,"C",2,0,"!", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.out.println(
       "<select name='SESSO' id='QPALJZMFCL' class='Combobox Disabled' disabled>" +
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
      status.out.println(
       "<input name='NASSTATO' id='HODZKKOSYW' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_NASSTATO,"C",30,0,"!", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='30' size='30' fieldtype='C' autocomplete='off'>" +
      "");
      status.out.println(
       "<input name='DATANASC' id='XMGRWGFSFV' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DATANASC,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.out.println(
       "<input name='PAESE' id='YVIKEGPYPM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_PAESE,"C",3,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='3' size='3' fieldtype='C' autocomplete='off'>" +
      "");
      status.out.println(
       "<input name='DESCCIT' id='ODAYKSRECA' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DESCCIT,"C",40,0,"!", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='40' size='40' fieldtype='C' autocomplete='off'>" +
      "");
      status.out.println(
       "<input name='PROVINCIA' id='NOTZPDMYIA' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_PROVINCIA,"C",2,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='CAP' id='RDAVOEETJG' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CAP,"C",9,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='9' size='9' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='DOMICILIO' id='VYLHWTRQNX' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DOMICILIO,"C",35,0,"!", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='35' size='35' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='NUMTEL' id='VFKGHJLVGB' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_NUMTEL,"C",20,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='20' size='20' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WVJSUIKYEY_DIV'>" +
       "<label id='WVJSUIKYEY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Città di Nascita:"))+"" +
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
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Città:"))+"" +
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
       "<input name='verifica' id='PUBAAWPVMH' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_verifica,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='1' size='1' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZZVYXPTPXC_DIV'>" +
       "<label id='ZZVYXPTPXC' for='VFKGHJLVGB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Numero Telefono:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='tipop' id='OZGWRQKOZF' type='text' class='Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_tipop,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='1' size='1' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<span class='"+status.ObligatoryClass("")+"' id='VXAWEXADJV_DIV'>" +
       "<input name='PEP' id='VXAWEXADJV' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_PEP,"C",1,0,"", status.m_oRegSettings)+" disabled "+(CPLib.eq("S",CPLib.Trim(BO.w_PEP))?"CHECKED":"")+">" +
       "<label id='VXAWEXADJV_LBL' for='VXAWEXADJV' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Persona Esposta Politicamente"))+"</label>" +
       "</span>" +
      "");
      status.out.println(
       "<select name='TIPODOC' id='MBGANUUHRA' class='Combobox Disabled' disabled>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.out.println(
       "<input name='NUMDOCUM' id='HVEEMUJUUY' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_NUMDOCUM,"C",15,0,"!", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='DATARILASC' id='XHWYGOPPUN' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DATARILASC,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.out.println(
       "<input name='DATAVALI' id='BNWXBPSIDG' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DATAVALI,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.out.println(
       "<select name='RDCODAUT' id='YDUQCBNYFV' class='Combobox Disabled' disabled>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.out.println(
       "<input name='RDLOCAUT' id='MPRHMTBSXX' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_RDLOCAUT,"C",20,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='20' size='20' fieldtype='C'>" +
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
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Autorità di rilascio:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UYGHJPRVKH_DIV'>" +
       "<label id='UYGHJPRVKH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Fine Validità:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='AUTRILASC' id='TXKHUBKEOP' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_AUTRILASC,"C",30,0,"!", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LSLCBQSYUK_DIV'>" +
       "<label id='LSLCBQSYUK' for='MPRHMTBSXX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Luogo Autorità Rilascio:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='PEPDESCRI' id='DAEHHCRYAM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_PEPDESCRI,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='PAESE2' id='UOOQYQWWNG' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_PAESE2,"C",3,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='3' size='3' fieldtype='C' autocomplete='off'>" +
      "");
      WriteControls_p1_b5_1(BO,status);
    }
  }
  void WriteControls_p1_b5_1(armt_snai_oper_vBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<input name='DESCCIT2' id='BVEIQEJCLQ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DESCCIT2,"C",40,0,"!", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='40' size='40' fieldtype='C' autocomplete='off'>" +
    "");
    status.out.println(
     "<input name='PROVINCIA2' id='NKJDWBKDWM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_PROVINCIA2,"C",2,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='2' size='2' fieldtype='C'>" +
    "");
    status.out.println(
     "<input name='CAP2' id='MDTHUZMSSI' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CAP2,"C",9,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='9' size='9' fieldtype='C'>" +
    "");
    status.out.println(
     "<input name='DOMICILIO2' id='CWOLOHZAQW' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DOMICILIO2,"C",35,0,"!", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='35' size='35' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='XAZPZOWUXV_DIV'>" +
     "<label id='XAZPZOWUXV'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_dessta2)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span id='ZJPDUNZSZL_DIV'>" +
     "<input name='FLGDOM' id='ZJPDUNZSZL' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_FLGDOM,"C",1,0,"", status.m_oRegSettings)+" disabled "+(CPLib.eq("S",CPLib.Trim(BO.w_FLGDOM))?"CHECKED":"")+">" +
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
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Città Domicilio:"))+"" +
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
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Autorità Rilascio:"))+"" +
     "</label>" +
     "</span>" +
    "");
    if (status.HasZoneAltInterface("Soggetto@BEGIN") || status.HasZoneAltInterface("Soggetto@END")) {
      status.out.println(
       "</div>" +
      "");
    }
    WriteControls_p1_b5_CloseBand(BO,status);
  }
  void WriteControls_p1_b5_CloseBand(armt_snai_oper_vBO BO,ServletStatus status) {
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
      status.out.println("Ctrl('AQSQVBKXAL').setAttribute('band_height',475);");
    }
    status.out.println("Ctrl('AQSQVBKXAL').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b6(armt_snai_oper_vBO BO,ServletStatus status) {
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
  void WriteControls_p2_b0(armt_snai_oper_vBO BO,ServletStatus status) {
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
  void WriteControls_p3_b0(armt_snai_oper_vBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='position:relative;height:293px'>" +
    "");
    status.out.println(
     "<div id='NYSCBMMEEX_DIV' class='UntitledBox'>" +
     "<div id='NYSCBMMEEX' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='WSBYTYXZUJ_DIV'>" +
     "<label id='WSBYTYXZUJ'>" +
     ""+SPLib.ToHTMLRepresentation("Intermediario: "+BO.w_gIntemediario)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='EAXVXJOILG_DIV'>" +
     "<label id='EAXVXJOILG'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Agenzia:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RYPMYFNJCH_DIV'>" +
     "<label id='RYPMYFNJCH'>" +
     ""+SPLib.ToHTMLRepresentation("Telefono: "+BO.w_TELDIP)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='SYSCVQLGYQ_DIV'>" +
     "<label id='SYSCVQLGYQ'>" +
     ""+SPLib.ToHTMLRepresentation("Pr.: "+BO.w_PROVDIP)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NDRSVVFNFN_DIV'>" +
     "<label id='NDRSVVFNFN'>" +
     ""+SPLib.ToHTMLRepresentation("CAB: "+BO.w_CABDIP)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PTPHBBPAMU_DIV'>" +
     "<label id='PTPHBBPAMU'>" +
     ""+SPLib.ToHTMLRepresentation(CPLib.LRTrim(BO.w_CODDIPE)+" - "+BO.w_xDescDipe)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FXXYGMCKWS_DIV'>" +
     "<label id='FXXYGMCKWS'>" +
     ""+SPLib.ToHTMLRepresentation("Città: "+BO.w_DESCCITDIP)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='CGODATCON' id='QGTPFXSEXX' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CGODATCON,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='10' size='8' fieldtype='D'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='FQOWHKPMKJ_DIV'>" +
     "<label id='FQOWHKPMKJ' for='QGTPFXSEXX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Contatto:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<select name='CGOESICON' id='UHSDZYTDDZ' class='Combobox Disabled' disabled>" +
     "<option value>" +
     "</option>" +
     "</select>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QEBYVTHZSE_DIV'>" +
     "<label id='QEBYVTHZSE' for='UHSDZYTDDZ'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Esito Contatto:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<textarea name='CGONOTCON' id='MVSSLZXHUW' class='Memo' tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' cols='20' rows='2'>" +
     "</textarea>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='WNQEZXSVGA_DIV'>" +
     "<label id='WNQEZXSVGA' for='MVSSLZXHUW'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Note Contatto:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  static void PrintState(armt_snai_oper_vBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_snai_oper_vBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
  }
  static void PrintStateWorkVars(armt_snai_oper_vBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_TIPOGIOCO,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOPERS,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CGOFLGVNP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TOTLIRE,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_CGOFLGVLT,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MEZPAGAM,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ASSEGNO,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IBAN,"C",27,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CC4CIFRE,"C",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CCDATSCA,"C",7,0));
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
    status.out.print(","+SPLib.ToJSValue(BO.w_RAGSOC,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCCIT,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINCIA,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAP,"C",9,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODCAB,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DOMICILIO,"C",35,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMTEL,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ATTIV,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SOTGRUP,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAMOGRUP,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SETTSINT,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PEP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SNAINUMOPE,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAOPE,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAREG,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGCONT,"C",1,0));
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
    status.out.print(","+SPLib.ToJSValue(BO.w_TOTCONT,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_CACODICE,"N",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAIDBIGLIETTO,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CGOTIPOPE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMOPEDL,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAFLGOPE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CGODATCON,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CGOESICON,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CGONOTCON,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDDOCALL,"C",36,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGDOCALL,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VLTPLAT,"C",2,0));
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
    status.out.print(","+SPLib.ToJSValue(BO.w_gIntemediario,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xSOGTPGIO,"N",12,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDEFTPGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xEDTTPGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xEDTSPGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDEFSPGIO,"C",1,0));
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
    status.out.print(","+SPLib.ToJSValue(BO.w_verifica,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gStpDwn,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MIDBIGLIETTO,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MIDBIGLIETTO1,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MIDBIGLIETTO2,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MIDBIGLIETTO3,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MIDBIGLIETTO4,"M",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TELDIP,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODLOC,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xFLGPLGIO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xVPFLGATT,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DOC03,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DOC04,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipop,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLGSAVE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dessta2,"C",40,0));
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_snai_oper_vBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_ESVLUSNYWB = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_BLXOBUQVYE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_THOGQCLBJA = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_XAZPZOWUXV = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_WSBYTYXZUJ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_RYPMYFNJCH = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_SYSCVQLGYQ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_NDRSVVFNFN = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_PTPHBBPAMU = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_FXXYGMCKWS = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(825,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_snai_oper_v"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'QZTTRBWAQL':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QZTTRBWAQL",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_tbtipgio,"+"default",l_session)+"'"+"]");
      status.out.print(",'NEUBQNUEOJ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NEUBQNUEOJ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'HODZKKOSYW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"HODZKKOSYW",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'ODAYKSRECA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ODAYKSRECA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
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
      status.out.print(",'WJQFIEBCQV':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"WJQFIEBCQV",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_causali,"+"default",l_session)+"'"+"]");
      status.out.print(",'MBGANUUHRA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"MBGANUUHRA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_tipdoc,"+"default",l_session)+"'"+"]");
      status.out.print(",'YDUQCBNYFV':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"YDUQCBNYFV",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_autorita,"+"default",l_session)+"'"+"]");
      status.out.print(",'UOOQYQWWNG':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"UOOQYQWWNG",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'BVEIQEJCLQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"BVEIQEJCLQ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'QZTTRBWAQL':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_tbtipgio,"+"default",l_session)+"'"+"]");
      status.out.print(",'NEUBQNUEOJ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'HODZKKOSYW':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'ODAYKSRECA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
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
      status.out.print(",'WJQFIEBCQV':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_causali,"+"default",l_session)+"'"+"]");
      status.out.print(",'MBGANUUHRA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_tipdoc,"+"default",l_session)+"'"+"]");
      status.out.print(",'YDUQCBNYFV':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,cgo_autorita,"+"default",l_session)+"'"+"]");
      status.out.print(",'UOOQYQWWNG':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'BVEIQEJCLQ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_snai_oper_v","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_snai_oper_v",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("box_XWJLXLYKJC"),"")) {
      status.quoteAndAppend("box_XWJLXLYKJC","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_NYSCBMMEEX"),"")) {
      status.quoteAndAppend("box_NYSCBMMEEX","hide","box");
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
  void WriteMainFormScript(armt_snai_oper_vBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_snai_oper_v',false);");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('XFUOZLSACP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YLIKFVPZJA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PUBAAWPVMH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HILLZZMRNQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZUVVNOUSIQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PAADFVDPUD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SIRTAMVPQN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OZGWRQKOZF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MVSSLZXHUW')) SetDisabled(c,true);");
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
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('XFUOZLSACP')) SetDisabled(c,true);");
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
    WriteJSError(status);
    WriteTableCombo(status,BO);
    status.out.println("// * --- Area Manuale = UI - Functions & Procedures");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println(
     "</script>" +
    "");
  }
  armt_snai_oper_vBO getBO(ServletStatus status) {
    armt_snai_oper_vBO BO = new armt_snai_oper_vBO(status.context);
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_snai_oper_vBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("cgo_operazioni",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_snai_oper_vBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_snai_oper_vBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
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
    status.out.println("var QZTTRBWAQL_Curs = "+l_cTmp+";");
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
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_cgo_causali,CPSql.BuildSQLPhrase("CACODICE,CADESCRI",BO.m_cPhName_cgo_causali,"","CACODICE"));
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue(0,"N",5,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetDouble("CACODICE"),"N",5,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("CADESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var WJQFIEBCQV_Curs = "+l_cTmp+";");
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
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_cgo_esiticon,CPSql.BuildSQLPhrase("ECCODICE,ECDESCRI",BO.m_cPhName_cgo_esiticon,"",""));
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",2,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("ECCODICE"),"C",2,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("ECDESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var UHSDZYTDDZ_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(armt_snai_oper_vBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_cgo_operazioni;
    String l_cPhName = BO.m_cPhName_cgo_operazioni;
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
      String l_cQueryFilter = armt_snai_oper_vBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_cgo_operazioni+".SNAINUMOPE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("cgo_operazioni");
    String l_cPhName = CPSql.ManipulateTablePhName("cgo_operazioni",l_cServer);
    // Creazione del cursore delle chiavi. Costruisce la frase SQL nella tabella
    // associata alla maschera selezionando solo i campi della chiave di ricerca che
    // soddisfa la clausola di "where" passata come parametro. Riceve altresì come
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
  void Query(ServletStatus status,armt_snai_oper_vBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_snai_oper_vBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_cgo_operazioni,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_cgo_operazioni,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_snai_oper_vBO BO) {
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
  void Edit(ServletStatus status,armt_snai_oper_vBO BO,SPParameterSource source) {
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
  void New(ServletStatus status,armt_snai_oper_vBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_snai_oper_vBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_snai_oper_vBO BO) {
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
  void EditLoad(ServletStatus status,armt_snai_oper_vBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_snai_oper_vBO BO,SPParameterSource source) {
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
  void DeleteMessage(ServletStatus status,armt_snai_oper_vBO BO,SPParameterSource source) {
    BO.Load(status.w_SNAINUMOPE);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_snai_oper_vBO BO) {
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
  void Discard(ServletStatus status,armt_snai_oper_vBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_snai_oper_vBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",765);
    item.put("w",797);
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
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Documenti\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Contatto\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Dati Base,Documenti,Contatto");
    item.put("altInterfaceFor","armt_snai_oper_v");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Base\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati base\",\"h\":91,\"name\":\"Base\",\"page\":1,\"shrinkable\":true,\"spuid\":\"CCUOYXMBZC\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Dati base\",\"titled\":true,\"type\":\"Box\",\"w\":784,\"x\":8,\"y\":8,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Intermediario\",\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"gIntemediario\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"GXLWKNXGMM\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":96,\"y\":16,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_LOEAMXUYLA\",\"page\":1,\"spuid\":\"LOEAMXUYLA\",\"tabindex\":89,\"type\":\"Label\",\"value\":\"Intermediario:\",\"w\":78,\"x\":16,\"y\":20,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":6,\"name\":\"CODDIPE\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"AVHTGZTOSZ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":224,\"y\":16,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Citt\\u00E0 Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":30,\"name\":\"DESCCITDIP\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"RLUMBFHPUD\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":160,\"x\":480,\"y\":16,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_XVRJYSKGWZ\",\"page\":1,\"spuid\":\"XVRJYSKGWZ\",\"tabindex\":98,\"type\":\"Label\",\"value\":\"Dipen.:\",\"w\":40,\"x\":184,\"y\":20,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_CTLYJMTHDV\",\"page\":1,\"spuid\":\"CTLYJMTHDV\",\"tabindex\":99,\"type\":\"Label\",\"value\":\"Citt\\u00E0:\",\"w\":28,\"x\":453,\"y\":20,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_JWSDOSRGAG\",\"page\":1,\"spuid\":\"JWSDOSRGAG\",\"tabindex\":100,\"type\":\"Label\",\"value\":\"Pr.:\",\"w\":24,\"x\":640,\"y\":20,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_ENBRMMDVUP\",\"page\":1,\"spuid\":\"ENBRMMDVUP\",\"tabindex\":101,\"type\":\"Label\",\"value\":\"CAB:\",\"w\":27,\"x\":695,\"y\":20,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_BLXOBUQVYE\",\"page\":1,\"spuid\":\"BLXOBUQVYE\",\"tabindex\":102,\"type\":\"Label\",\"w\":175,\"x\":277,\"y\":20,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":2,\"name\":\"PROVINCIADIP\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"OJGQABFSYN\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":664,\"y\":16,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAB Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":6,\"name\":\"CODCABDIP\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"OZEOCQRSEQ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":720,\"y\":16,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"N\\u00B0 Operazione\",\"h\":20,\"maxlength\":15,\"name\":\"SNAINUMOPE\",\"page\":1,\"spuid\":\"XFUOZLSACP\",\"tabindex\":66,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":112,\"x\":136,\"y\":48,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GZVEXPFQCZ\",\"page\":1,\"spuid\":\"GZVEXPFQCZ\",\"tabindex\":67,\"type\":\"Label\",\"value\":\"N\\u00B0 Operazione:\",\"w\":104,\"x\":29,\"y\":52,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ID BIGLIETTO\",\"disabled\":\"true\",\"h\":20,\"maxlength\":30,\"name\":\"CAIDBIGLIETTO\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"BMTLGIUQTH\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":280,\"x\":504,\"y\":48,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EZWFUWOKXC\",\"page\":1,\"spuid\":\"EZWFUWOKXC\",\"tabindex\":127,\"type\":\"Label\",\"value\":\"ID BIGLIETTO:\",\"w\":96,\"x\":408,\"y\":52,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo gioco\",\"disabled\":\"true\",\"h\":20,\"maxlength\":3,\"name\":\"TIPOGIOCO\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"QZTTRBWAQL\",\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":208,\"x\":136,\"y\":72,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JNQVUOSVPV\",\"page\":1,\"spuid\":\"JNQVUOSVPV\",\"tabindex\":133,\"type\":\"Label\",\"value\":\"Tipo Gioco:\",\"w\":64,\"x\":72,\"y\":76,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DJRHGZHJSR\",\"page\":1,\"spuid\":\"DJRHGZHJSR\",\"tabindex\":146,\"type\":\"Label\",\"value\":\"Tipo Piattaforma:\",\"w\":112,\"x\":392,\"y\":76,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Piattaforma VLT\",\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"VLTPLAT\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"LVYFMQXNZH\",\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":280,\"x\":504,\"y\":72,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Operazione\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Operazione\",\"h\":182,\"name\":\"Operazione\",\"page\":1,\"shrinkable\":true,\"spuid\":\"YORQOIOBQN\",\"stretch\":true,\"tabindex\":3,\"title_caption\":\"Dati Operazione\",\"titled\":true,\"type\":\"Box\",\"w\":784,\"x\":8,\"y\":101,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data registrazione\",\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"DATAREG\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"OEIKQOZMYJ\",\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":704,\"y\":107,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IKBMEWKQJW\",\"page\":1,\"spuid\":\"IKBMEWKQJW\",\"tabindex\":93,\"type\":\"Label\",\"value\":\"Data registrazione:\",\"w\":104,\"x\":600,\"y\":111,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Operazione\",\"h\":20,\"maxlength\":10,\"name\":\"DATAOPE\",\"page\":1,\"spuid\":\"YLIKFVPZJA\",\"tabindex\":68,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":88,\"x\":136,\"y\":108,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HVHVAYPDJE\",\"page\":1,\"spuid\":\"HVHVAYPDJE\",\"tabindex\":87,\"type\":\"Label\",\"value\":\"Data di pagamento:\",\"w\":104,\"x\":29,\"y\":112,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Contanti (S\\/N)\",\"disabled\":\"true\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"FLAGCONT\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"PURPSXEVAI\",\"textlist\":\"No,Si\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"0"+"'"+","+"'"+"1"+"'"+"\",\"w\":104,\"x\":136,\"y\":136,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GVTXMEILAZ\",\"page\":1,\"spuid\":\"GVTXMEILAZ\",\"tabindex\":92,\"type\":\"Label\",\"value\":\"Contanti:\",\"w\":80,\"x\":53,\"y\":140,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo Operazione Completa\",\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"TIPOOPRAP\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"UJRFWINIVQ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":392,\"y\":136,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KMCNAWQHKV\",\"page\":1,\"spuid\":\"KMCNAWQHKV\",\"tabindex\":94,\"type\":\"Label\",\"value\":\"Tipo Operazione:\",\"w\":104,\"x\":288,\"y\":140,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_THOGQCLBJA\",\"page\":1,\"spuid\":\"THOGQCLBJA\",\"tabindex\":103,\"type\":\"Label\",\"w\":361,\"x\":423,\"y\":140,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Causale\",\"disabled\":\"true\",\"h\":20,\"maxlength\":6,\"name\":\"CACODICE\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"WJQFIEBCQV\",\"type\":\"Combobox\",\"typevar\":\"numeric\",\"w\":312,\"x\":136,\"y\":164,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YFGRJCQGZV\",\"page\":1,\"spuid\":\"YFGRJCQGZV\",\"tabindex\":124,\"type\":\"Label\",\"value\":\"Causale:\",\"w\":42,\"x\":91,\"y\":168,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Registrazione\",\"disabled\":\"true\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"CAFLGOPE\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"YJDISDDJUY\",\"textlist\":\"Giocata,Versamento,Vincita,Prelievo\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"G"+"'"+","+"'"+"R"+"'"+","+"'"+"V"+"'"+","+"'"+"P"+"'"+"\",\"w\":112,\"x\":456,\"y\":164,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Totale Operazione\",\"disabled\":\"true\",\"h\":20,\"maxlength\":21,\"name\":\"TOTLIRE\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"HUAGBHPUNH\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":120,\"x\":136,\"y\":195,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XLNVLBYVQX\",\"page\":1,\"spuid\":\"XLNVLBYVQX\",\"tabindex\":96,\"type\":\"Label\",\"value\":\"Totale Euro:\",\"w\":95,\"x\":38,\"y\":199,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IDTBMNCIOX\",\"page\":1,\"spuid\":\"IDTBMNCIOX\",\"tabindex\":97,\"type\":\"Label\",\"value\":\"di cui contanti:\",\"w\":78,\"x\":280,\"y\":199,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"di cui contanti\",\"disabled\":\"true\",\"h\":20,\"maxlength\":21,\"name\":\"TOTCONT\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"HUDOCMLKKT\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":120,\"x\":360,\"y\":195,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Pagamento VLT\",\"disabled\":\"true\",\"h\":19,\"maxlength\":1,\"name\":\"CGOFLGVLT\",\"orientation\":\"horizontal\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"SFKJNKYLJO\",\"type\":\"Radio\",\"typevar\":\"character\",\"w\":288,\"x\":136,\"y\":227,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LKYFODKVBU\",\"page\":1,\"spuid\":\"LKYFODKVBU\",\"tabindex\":129,\"type\":\"Label\",\"value\":\"Pagamento da parte di:\",\"w\":124,\"x\":12,\"y\":231,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Mezzo Pagamento\",\"disabled\":\"true\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"MEZPAGAM\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"EOSKLIUGBC\",\"textlist\":\"Altro Mezzo,Bonifico Italia,Bonifico Estero,Bonifico Postale,Assegno Circolare,Assegno Bancario,Carta di Credito,Contante\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"A"+"'"+","+"'"+"I"+"'"+","+"'"+"E"+"'"+","+"'"+"P"+"'"+","+"'"+"C"+"'"+","+"'"+"B"+"'"+","+"'"+"V"+"'"+","+"'"+"S"+"'"+"\",\"w\":224,\"x\":136,\"y\":251,\"zone\":\"pag1_2_8\",\"zonepath\":\"[1,2,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VQCVMXHDPB\",\"page\":1,\"spuid\":\"VQCVMXHDPB\",\"tabindex\":125,\"type\":\"Label\",\"value\":\"Mezzo Pagamento:\",\"w\":120,\"x\":16,\"y\":255,\"zone\":\"pag1_2_8\",\"zonepath\":\"[1,2,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Assegno\",\"disabled\":\"true\",\"h\":20,\"maxlength\":25,\"name\":\"ASSEGNO\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"KZWBLPQNHU\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":224,\"x\":560,\"y\":251,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"IBAN per Bonifici\",\"disabled\":\"true\",\"h\":20,\"maxlength\":27,\"name\":\"IBAN\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"UTUCDPQJKK\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":224,\"x\":560,\"y\":251,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Ultime Cifre CC\",\"disabled\":\"true\",\"h\":20,\"maxlength\":4,\"name\":\"CC4CIFRE\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"FKEAKFSYVU\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":36,\"x\":560,\"y\":251,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Scadenza\",\"disabled\":\"true\",\"h\":20,\"maxlength\":7,\"name\":\"CCDATSCA\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"OXFYJQLTDL\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":64,\"x\":704,\"y\":251,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PBHNLOUBML\",\"page\":1,\"spuid\":\"PBHNLOUBML\",\"tabindex\":148,\"type\":\"Label\",\"value\":\"IBAN per Bonifici:\",\"w\":144,\"x\":411,\"y\":255,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BTZLLSBMCC\",\"page\":1,\"spuid\":\"BTZLLSBMCC\",\"tabindex\":149,\"type\":\"Label\",\"value\":\"Numero Assegno:\",\"w\":93,\"x\":464,\"y\":255,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CQTMIXIELC\",\"page\":1,\"spuid\":\"CQTMIXIELC\",\"tabindex\":150,\"type\":\"Label\",\"value\":\"Ultime Cifre CC:\",\"w\":83,\"x\":472,\"y\":255,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HKREYYVVOP\",\"page\":1,\"spuid\":\"HKREYYVVOP\",\"tabindex\":151,\"type\":\"Label\",\"value\":\"Scadenza:\",\"w\":55,\"x\":649,\"y\":255,\"zone\":\"pag1_2_9\",\"zonepath\":\"[1,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Soggetto\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Dati Soggetto\",\"h\":475,\"name\":\"Soggetto\",\"page\":1,\"shrinkable\":true,\"spuid\":\"AQSQVBKXAL\",\"tabindex\":9,\"title_caption\":\"Dati Soggetto\",\"titled\":true,\"type\":\"Box\",\"w\":784,\"x\":8,\"y\":285,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"comment\":\"Codice Fiscale Estero\",\"disabled\":\"true\",\"h\":21,\"label_text\":\"Soggetto Residente All"+"'"+"Estero\",\"maxlength\":2,\"name\":\"CFESTERO\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"CZTHKEDVCO\",\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":575,\"x\":136,\"y\":291,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Fiscale\",\"disabled\":\"true\",\"h\":20,\"maxlength\":16,\"name\":\"CODFISC\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"OJJHIUDPFY\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":128,\"x\":136,\"y\":323,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cognome\",\"disabled\":\"true\",\"h\":20,\"maxlength\":26,\"name\":\"COGNOME\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"TWTTDWKCRG\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":176,\"x\":392,\"y\":323,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Nome\",\"disabled\":\"true\",\"h\":20,\"maxlength\":25,\"name\":\"NOME\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"WWGIVGNUDW\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":168,\"x\":616,\"y\":323,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WZDAFMDKJE\",\"page\":1,\"spuid\":\"WZDAFMDKJE\",\"tabindex\":44,\"type\":\"Label\",\"value\":\"Codice Fiscale:\",\"w\":85,\"x\":48,\"y\":327,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TVSLWOCERI\",\"page\":1,\"spuid\":\"TVSLWOCERI\",\"tabindex\":57,\"type\":\"Label\",\"value\":\"Cognome:\",\"w\":56,\"x\":333,\"y\":327,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KUPYKSUBXV\",\"page\":1,\"spuid\":\"KUPYKSUBXV\",\"tabindex\":58,\"type\":\"Label\",\"value\":\"Nome:\",\"w\":35,\"x\":580,\"y\":327,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Luogo di Nascita\",\"disabled\":\"true\",\"h\":20,\"maxlength\":30,\"name\":\"NASCOMUN\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"NEUBQNUEOJ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":222,\"x\":136,\"y\":355,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Prov.\",\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"TIPINTER\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"KPSCOABZLB\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":440,\"y\":355,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Sesso\",\"disabled\":\"true\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"SESSO\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"QPALJZMFCL\",\"textlist\":\"Maschile,Femminile\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":88,\"x\":560,\"y\":355,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WVJSUIKYEY\",\"page\":1,\"spuid\":\"WVJSUIKYEY\",\"tabindex\":42,\"type\":\"Label\",\"value\":\"Citt\\u00E0 di Nascita:\",\"w\":101,\"x\":32,\"y\":359,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KRSCDPQZTQ\",\"page\":1,\"spuid\":\"KRSCDPQZTQ\",\"tabindex\":49,\"type\":\"Label\",\"value\":\"Sesso:\",\"w\":39,\"x\":519,\"y\":359,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IVAWYVSUQI\",\"page\":1,\"spuid\":\"IVAWYVSUQI\",\"tabindex\":51,\"type\":\"Label\",\"value\":\"Prov.:\",\"w\":32,\"x\":408,\"y\":359,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Stato di nascita\",\"disabled\":\"true\",\"h\":20,\"maxlength\":30,\"name\":\"NASSTATO\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"HODZKKOSYW\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":222,\"x\":136,\"y\":387,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZBRDCBHLZC\",\"page\":1,\"spuid\":\"ZBRDCBHLZC\",\"tabindex\":56,\"type\":\"Label\",\"value\":\"Stato di Nascita:\",\"w\":101,\"x\":32,\"y\":391,\"zone\":\"pag1_3_4\",\"zonepath\":\"[1,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Nascita\",\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"DATANASC\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"XMGRWGFSFV\",\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":86,\"x\":560,\"y\":387,\"zone\":\"pag1_3_5\",\"zonepath\":\"[1,3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HZYTDOZFPI\",\"page\":1,\"spuid\":\"HZYTDOZFPI\",\"tabindex\":43,\"type\":\"Label\",\"value\":\"Data Nascita:\",\"w\":74,\"x\":483,\"y\":391,\"zone\":\"pag1_3_5\",\"zonepath\":\"[1,3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Stato\",\"disabled\":\"true\",\"h\":20,\"maxlength\":3,\"name\":\"PAESE\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"YVIKEGPYPM\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":136,\"y\":419,\"zone\":\"pag1_3_6\",\"zonepath\":\"[1,3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RZBLEGCFJJ\",\"page\":1,\"spuid\":\"RZBLEGCFJJ\",\"tabindex\":46,\"type\":\"Label\",\"value\":\"Stato Residenza:\",\"w\":108,\"x\":24,\"y\":424,\"zone\":\"pag1_3_6\",\"zonepath\":\"[1,3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_ESVLUSNYWB\",\"page\":1,\"spuid\":\"ESVLUSNYWB\",\"tabindex\":53,\"type\":\"Label\",\"w\":323,\"x\":203,\"y\":424,\"zone\":\"pag1_3_6\",\"zonepath\":\"[1,3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Citt\\u00E0\",\"disabled\":\"true\",\"h\":20,\"maxlength\":40,\"name\":\"DESCCIT\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"ODAYKSRECA\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":318,\"x\":136,\"y\":451,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia\",\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"PROVINCIA\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"NOTZPDMYIA\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":536,\"y\":451,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAP\",\"disabled\":\"true\",\"h\":20,\"maxlength\":9,\"name\":\"CAP\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"RDAVOEETJG\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":66,\"x\":608,\"y\":451,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SBJQIAQUCN\",\"page\":1,\"spuid\":\"SBJQIAQUCN\",\"tabindex\":45,\"type\":\"Label\",\"value\":\"Provincia:\",\"w\":52,\"x\":480,\"y\":455,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GDOCAGKROT\",\"page\":1,\"spuid\":\"GDOCAGKROT\",\"tabindex\":48,\"type\":\"Label\",\"value\":\"CAP:\",\"w\":30,\"x\":576,\"y\":455,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XPSQTBKQQZ\",\"page\":1,\"spuid\":\"XPSQTBKQQZ\",\"tabindex\":50,\"type\":\"Label\",\"value\":\"Citt\\u00E0:\",\"w\":70,\"x\":63,\"y\":455,\"zone\":\"pag1_3_7\",\"zonepath\":\"[1,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Indirizzo\",\"disabled\":\"true\",\"h\":20,\"maxlength\":35,\"name\":\"DOMICILIO\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"VYLHWTRQNX\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":222,\"x\":136,\"y\":483,\"zone\":\"pag1_3_8\",\"zonepath\":\"[1,3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TWTXGZJTAR\",\"page\":1,\"spuid\":\"TWTXGZJTAR\",\"tabindex\":47,\"type\":\"Label\",\"value\":\"Indirizzo:\",\"w\":47,\"x\":86,\"y\":487,\"zone\":\"pag1_3_8\",\"zonepath\":\"[1,3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero Telefono\",\"disabled\":\"true\",\"h\":20,\"maxlength\":20,\"name\":\"NUMTEL\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"VFKGHJLVGB\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":132,\"x\":560,\"y\":483,\"zone\":\"pag1_3_9\",\"zonepath\":\"[1,3,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZZVYXPTPXC\",\"page\":1,\"spuid\":\"ZZVYXPTPXC\",\"tabindex\":152,\"type\":\"Label\",\"value\":\"Numero Telefono:\",\"w\":94,\"x\":463,\"y\":487,\"zone\":\"pag1_3_9\",\"zonepath\":\"[1,3,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Persona Politicamente Esposta\",\"disabled\":\"true\",\"h\":21,\"label_text\":\"Persona Esposta Politicamente\",\"maxlength\":1,\"name\":\"PEP\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"VXAWEXADJV\",\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":208,\"x\":392,\"y\":291,\"zone\":\"pag1_3_10\",\"zonepath\":\"[1,3,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Tipo Documento\",\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"TIPODOC\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"MBGANUUHRA\",\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":246,\"x\":136,\"y\":632,\"zone\":\"pag1_3_11\",\"zonepath\":\"[1,3,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KCXIMANXKF\",\"page\":1,\"spuid\":\"KCXIMANXKF\",\"tabindex\":187,\"type\":\"Label\",\"value\":\"Tipo Documento:\",\"w\":89,\"x\":47,\"y\":636,\"zone\":\"pag1_3_11\",\"zonepath\":\"[1,3,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero Doc.\",\"disabled\":\"true\",\"h\":20,\"maxlength\":15,\"name\":\"NUMDOCUM\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"HVEEMUJUUY\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":128,\"x\":560,\"y\":632,\"zone\":\"pag1_3_12\",\"zonepath\":\"[1,3,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YXFGMWZGNN\",\"page\":1,\"spuid\":\"YXFGMWZGNN\",\"tabindex\":168,\"type\":\"Label\",\"value\":\"Numero Doc.:\",\"w\":69,\"x\":488,\"y\":636,\"zone\":\"pag1_3_12\",\"zonepath\":\"[1,3,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Rilascio Doc.\",\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"DATARILASC\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"XHWYGOPPUN\",\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":86,\"x\":136,\"y\":664,\"zone\":\"pag1_3_13\",\"zonepath\":\"[1,3,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Fine Validit\\u00E0\",\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"DATAVALI\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"BNWXBPSIDG\",\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":86,\"x\":344,\"y\":664,\"zone\":\"pag1_3_13\",\"zonepath\":\"[1,3,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZPQIEJPWJC\",\"page\":1,\"spuid\":\"ZPQIEJPWJC\",\"tabindex\":169,\"type\":\"Label\",\"value\":\"Autorit\\u00E0 di rilascio:\",\"w\":100,\"x\":459,\"y\":668,\"zone\":\"pag1_3_13\",\"zonepath\":\"[1,3,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UYGHJPRVKH\",\"page\":1,\"spuid\":\"UYGHJPRVKH\",\"tabindex\":170,\"type\":\"Label\",\"value\":\"Data Fine Validit\\u00E0:\",\"w\":101,\"x\":240,\"y\":668,\"zone\":\"pag1_3_13\",\"zonepath\":\"[1,3,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Autorit\\u00E0 di rilascio\",\"disabled\":\"true\",\"h\":20,\"maxlength\":30,\"name\":\"AUTRILASC\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"TXKHUBKEOP\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":224,\"x\":560,\"y\":664,\"zone\":\"pag1_3_13\",\"zonepath\":\"[1,3,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QUXAELRWLA\",\"page\":1,\"spuid\":\"QUXAELRWLA\",\"tabindex\":188,\"type\":\"Label\",\"value\":\"Rilascio Doc.:\",\"w\":70,\"x\":66,\"y\":668,\"zone\":\"pag1_3_13\",\"zonepath\":\"[1,3,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Autorit\\u00E0 Rilascio\",\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"RDCODAUT\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"YDUQCBNYFV\",\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":176,\"x\":136,\"y\":696,\"zone\":\"pag1_3_14\",\"zonepath\":\"[1,3,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RAVMCVENOT\",\"page\":1,\"spuid\":\"RAVMCVENOT\",\"tabindex\":189,\"type\":\"Label\",\"value\":\"Autorit\\u00E0 Rilascio:\",\"w\":89,\"x\":47,\"y\":700,\"zone\":\"pag1_3_14\",\"zonepath\":\"[1,3,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Luogo Autorit\\u00E0 Rilascio\",\"disabled\":\"true\",\"h\":20,\"maxlength\":20,\"name\":\"RDLOCAUT\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"MPRHMTBSXX\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":152,\"x\":560,\"y\":696,\"zone\":\"pag1_3_15\",\"zonepath\":\"[1,3,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LSLCBQSYUK\",\"page\":1,\"spuid\":\"LSLCBQSYUK\",\"tabindex\":172,\"type\":\"Label\",\"value\":\"Luogo Autorit\\u00E0 Rilascio:\",\"w\":124,\"x\":436,\"y\":700,\"zone\":\"pag1_3_15\",\"zonepath\":\"[1,3,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Descrizione PEP\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"PEPDESCRI\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"DAEHHCRYAM\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":648,\"x\":136,\"y\":728,\"zone\":\"pag1_3_16\",\"zonepath\":\"[1,3,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ELBFOCJOYH\",\"page\":1,\"spuid\":\"ELBFOCJOYH\",\"tabindex\":181,\"type\":\"Label\",\"value\":\"Descrizione PEP:\",\"w\":86,\"x\":50,\"y\":732,\"zone\":\"pag1_3_16\",\"zonepath\":\"[1,3,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Stato Domicilio\",\"disabled\":\"true\",\"h\":20,\"maxlength\":3,\"name\":\"PAESE2\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"UOOQYQWWNG\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":136,\"y\":538,\"zone\":\"pag1_3_17\",\"zonepath\":\"[1,3,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_XAZPZOWUXV\",\"page\":1,\"spuid\":\"XAZPZOWUXV\",\"tabindex\":179,\"type\":\"Label\",\"w\":323,\"x\":180,\"y\":542,\"zone\":\"pag1_3_17\",\"zonepath\":\"[1,3,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MCODDONEHP\",\"page\":1,\"spuid\":\"MCODDONEHP\",\"tabindex\":182,\"type\":\"Label\",\"value\":\"Stato Domicilio:\",\"w\":80,\"x\":56,\"y\":542,\"zone\":\"pag1_3_17\",\"zonepath\":\"[1,3,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Citt\\u00E0 Domicilio\",\"disabled\":\"true\",\"h\":20,\"maxlength\":40,\"name\":\"DESCCIT2\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"BVEIQEJCLQ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":318,\"x\":136,\"y\":568,\"zone\":\"pag1_3_18\",\"zonepath\":\"[1,3,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia\",\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"PROVINCIA2\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"NKJDWBKDWM\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":536,\"y\":568,\"zone\":\"pag1_3_18\",\"zonepath\":\"[1,3,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAP\",\"disabled\":\"true\",\"h\":20,\"maxlength\":9,\"name\":\"CAP2\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"MDTHUZMSSI\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":66,\"x\":608,\"y\":568,\"zone\":\"pag1_3_18\",\"zonepath\":\"[1,3,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BRPGRCAORR\",\"page\":1,\"spuid\":\"BRPGRCAORR\",\"tabindex\":183,\"type\":\"Label\",\"value\":\"Citt\\u00E0 Domicilio:\",\"w\":77,\"x\":59,\"y\":572,\"zone\":\"pag1_3_18\",\"zonepath\":\"[1,3,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_INUGZKMMHN\",\"page\":1,\"spuid\":\"INUGZKMMHN\",\"tabindex\":184,\"type\":\"Label\",\"value\":\"Provincia:\",\"w\":51,\"x\":485,\"y\":572,\"zone\":\"pag1_3_18\",\"zonepath\":\"[1,3,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PXQUPKOPNQ\",\"page\":1,\"spuid\":\"PXQUPKOPNQ\",\"tabindex\":185,\"type\":\"Label\",\"value\":\"CAP:\",\"w\":26,\"x\":582,\"y\":572,\"zone\":\"pag1_3_18\",\"zonepath\":\"[1,3,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Indirizzo Domicilio\",\"disabled\":\"true\",\"h\":20,\"maxlength\":35,\"name\":\"DOMICILIO2\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"CWOLOHZAQW\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":222,\"x\":136,\"y\":600,\"zone\":\"pag1_3_19\",\"zonepath\":\"[1,3,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KBBIQTXMOO\",\"page\":1,\"spuid\":\"KBBIQTXMOO\",\"tabindex\":186,\"type\":\"Label\",\"value\":\"Indirizzo Domicilio:\",\"w\":95,\"x\":41,\"y\":604,\"zone\":\"pag1_3_19\",\"zonepath\":\"[1,3,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Domicilio diverso da residenza\",\"disabled\":\"true\",\"h\":21,\"label_text\":\"Domicilio diverso da residenza\",\"maxlength\":1,\"name\":\"FLGDOM\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"ZJPDUNZSZL\",\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":224,\"x\":136,\"y\":512,\"zone\":\"pag1_3_20\",\"zonepath\":\"[1,3,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_XWJLXLYKJC\",\"h\":464,\"name\":\"box_XWJLXLYKJC\",\"page\":2,\"shrinkable\":true,\"spuid\":\"XWJLXLYKJC\",\"tabindex\":1,\"type\":\"Box\",\"w\":784,\"x\":8,\"y\":8,\"zone\":\"pag2_1\",\"zonepath\":\"[2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":448,\"name\":\"Documenti\",\"page\":2,\"spuid\":\"KUBMCPCHPZ\",\"src\":\"\\/jsp\\/pg_allegati_portlet.jsp?ForcedPortletUID=KUBMCPCHPZ\",\"tabindex\":2,\"type\":\"Portlet\",\"w\":768,\"x\":16,\"y\":16,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_NYSCBMMEEX\",\"h\":280,\"name\":\"box_NYSCBMMEEX\",\"page\":3,\"shrinkable\":true,\"spuid\":\"NYSCBMMEEX\",\"tabindex\":1,\"type\":\"Box\",\"w\":784,\"x\":8,\"y\":8,\"zone\":\"pag3_1\",\"zonepath\":\"[3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_WSBYTYXZUJ\",\"page\":3,\"spuid\":\"WSBYTYXZUJ\",\"tabindex\":2,\"type\":\"Label\",\"w\":200,\"x\":16,\"y\":16,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_EAXVXJOILG\",\"page\":3,\"spuid\":\"EAXVXJOILG\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Agenzia:\",\"w\":47,\"x\":17,\"y\":40,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_SYSCVQLGYQ\",\"page\":3,\"spuid\":\"SYSCVQLGYQ\",\"tabindex\":5,\"type\":\"Label\",\"w\":64,\"x\":624,\"y\":40,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_NDRSVVFNFN\",\"page\":3,\"spuid\":\"NDRSVVFNFN\",\"tabindex\":6,\"type\":\"Label\",\"w\":88,\"x\":696,\"y\":40,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_PTPHBBPAMU\",\"page\":3,\"spuid\":\"PTPHBBPAMU\",\"tabindex\":7,\"type\":\"Label\",\"w\":256,\"x\":72,\"y\":40,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_FXXYGMCKWS\",\"page\":3,\"spuid\":\"FXXYGMCKWS\",\"tabindex\":8,\"type\":\"Label\",\"w\":288,\"x\":336,\"y\":40,\"zone\":\"pag3_1_2\",\"zonepath\":\"[3,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_RYPMYFNJCH\",\"page\":3,\"spuid\":\"RYPMYFNJCH\",\"tabindex\":4,\"type\":\"Label\",\"w\":184,\"x\":336,\"y\":64,\"zone\":\"pag3_1_3\",\"zonepath\":\"[3,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Contatto\",\"disabled\":\"true\",\"h\":20,\"maxlength\":10,\"name\":\"CGODATCON\",\"page\":3,\"readonly\":\"true\",\"spuid\":\"QGTPFXSEXX\",\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":104,\"y\":96,\"zone\":\"pag3_1_4\",\"zonepath\":\"[3,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FQOWHKPMKJ\",\"page\":3,\"spuid\":\"FQOWHKPMKJ\",\"tabindex\":10,\"type\":\"Label\",\"value\":\"Data Contatto:\",\"w\":80,\"x\":24,\"y\":100,\"zone\":\"pag3_1_4\",\"zonepath\":\"[3,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Esito Contatto\",\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"CGOESICON\",\"page\":3,\"readonly\":\"true\",\"spuid\":\"UHSDZYTDDZ\",\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":296,\"x\":336,\"y\":96,\"zone\":\"pag3_1_4\",\"zonepath\":\"[3,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QEBYVTHZSE\",\"page\":3,\"spuid\":\"QEBYVTHZSE\",\"tabindex\":12,\"type\":\"Label\",\"value\":\"Esito Contatto:\",\"w\":80,\"x\":256,\"y\":100,\"zone\":\"pag3_1_4\",\"zonepath\":\"[3,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Note Contatto\",\"h\":152,\"name\":\"CGONOTCON\",\"page\":3,\"scroll\":true,\"spuid\":\"MVSSLZXHUW\",\"tabindex\":13,\"type\":\"Textbox\",\"typevar\":\"memo\",\"w\":680,\"x\":104,\"y\":128,\"zone\":\"pag3_1_5\",\"zonepath\":\"[3,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WNQEZXSVGA\",\"page\":3,\"spuid\":\"WNQEZXSVGA\",\"tabindex\":14,\"type\":\"Label\",\"value\":\"Note Contatto:\",\"w\":80,\"x\":24,\"y\":128,\"zone\":\"pag3_1_5\",\"zonepath\":\"[3,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_snai_oper_vBO BO,ServletStatus status) {
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
     "<script src='armt_snai_oper_v?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_snai_oper_v_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_snai_oper_v_edit.js'>" +
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
      status.out.println("w_TIPOPERS=a[1];");
      status.out.println("w_CGOFLGVNP=a[2];");
      status.out.println("w_TOTLIRE=a[3];");
      status.out.println("w_CGOFLGVLT=a[4];");
      status.out.println("w_MEZPAGAM=a[5];");
      status.out.println("w_ASSEGNO=a[6];");
      status.out.println("w_IBAN=a[7];");
      status.out.println("w_CC4CIFRE=a[8];");
      status.out.println("w_CCDATSCA=a[9];");
      status.out.println("w_CFESTERO=a[10];");
      status.out.println("w_CODFISC=a[11];");
      status.out.println("w_COGNOME=a[12];");
      status.out.println("w_NOME=a[13];");
      status.out.println("w_NASCOMUN=a[14];");
      status.out.println("w_TIPINTER=a[15];");
      status.out.println("w_SESSO=a[16];");
      status.out.println("w_NASSTATO=a[17];");
      status.out.println("w_DATANASC=a[18];");
      status.out.println("w_PAESE=a[19];");
      status.out.println("w_RAGSOC=a[20];");
      status.out.println("w_DESCCIT=a[21];");
      status.out.println("w_PROVINCIA=a[22];");
      status.out.println("w_CAP=a[23];");
      status.out.println("w_CODCAB=a[24];");
      status.out.println("w_DOMICILIO=a[25];");
      status.out.println("w_NUMTEL=a[26];");
      status.out.println("w_ATTIV=a[27];");
      status.out.println("w_SOTGRUP=a[28];");
      status.out.println("w_RAMOGRUP=a[29];");
      status.out.println("w_SETTSINT=a[30];");
      status.out.println("w_PEP=a[31];");
      status.out.println("w_SNAINUMOPE=a[32];");
      status.out.println("w_DATAOPE=a[33];");
      status.out.println("w_DATAREG=a[34];");
      status.out.println("w_FLAGCONT=a[35];");
      status.out.println("w_TIPOOPRAP=a[36];");
      status.out.println("w_CODANA=a[37];");
      status.out.println("w_CODVOC=a[38];");
      status.out.println("w_VALUTA=a[39];");
      status.out.println("w_CAMBIO=a[40];");
      status.out.println("w_CONNESCLI=a[41];");
      status.out.println("w_CONNESBEN=a[42];");
      status.out.println("w_C_RAG=a[43];");
      status.out.println("w_C_CTA=a[44];");
      status.out.println("w_C_PRV=a[45];");
      status.out.println("w_C_CAP=a[46];");
      status.out.println("w_C_CAB=a[47];");
      status.out.println("w_C_IND=a[48];");
      status.out.println("w_C_STA=a[49];");
      status.out.println("w_CODINTER=a[50];");
      status.out.println("w_CODDIPE=a[51];");
      status.out.println("w_DESCCITDIP=a[52];");
      status.out.println("w_SEGNO=a[53];");
      status.out.println("w_FLAGFRAZ=a[54];");
      status.out.println("w_COLLEG=a[55];");
      status.out.println("w_PROVINCIADIP=a[56];");
      status.out.println("w_CODCABDIP=a[57];");
      status.out.println("w_TOTCONT=a[58];");
      status.out.println("w_CACODICE=a[59];");
      status.out.println("w_CAIDBIGLIETTO=a[60];");
      status.out.println("w_CGOTIPOPE=a[61];");
      status.out.println("w_NUMOPEDL=a[62];");
      status.out.println("w_CAFLGOPE=a[63];");
      status.out.println("w_CGODATCON=a[64];");
      status.out.println("w_CGOESICON=a[65];");
      status.out.println("w_CGONOTCON=a[66];");
      status.out.println("w_IDDOCALL=a[67];");
      status.out.println("w_FLGDOCALL=a[68];");
      status.out.println("w_VLTPLAT=a[69];");
      status.out.println("w_TIPODOC=a[70];");
      status.out.println("w_NUMDOCUM=a[71];");
      status.out.println("w_DATARILASC=a[72];");
      status.out.println("w_DATAVALI=a[73];");
      status.out.println("w_RDCODAUT=a[74];");
      status.out.println("w_RDLOCAUT=a[75];");
      status.out.println("w_AUTRILASC=a[76];");
      status.out.println("w_PEPDESCRI=a[77];");
      status.out.println("w_PAESE2=a[78];");
      status.out.println("w_DESCCIT2=a[79];");
      status.out.println("w_PROVINCIA2=a[80];");
      status.out.println("w_CAP2=a[81];");
      status.out.println("w_DOMICILIO2=a[82];");
      status.out.println("w_FLGDOM=a[83];");
      status.out.println("w_gIntemediario=a[84];");
      status.out.println("w_xSOGTPGIO=a[85];");
      status.out.println("w_xDEFTPGIO=a[86];");
      status.out.println("w_xEDTTPGIO=a[87];");
      status.out.println("w_xEDTSPGIO=a[88];");
      status.out.println("w_xDEFSPGIO=a[89];");
      status.out.println("w_xARDESCRI=a[90];");
      status.out.println("w_dessta=a[91];");
      status.out.println("w_tipsot=a[92];");
      status.out.println("w_STATOREG=a[93];");
      status.out.println("w_IDBASE=a[94];");
      status.out.println("w_NUMPROG=a[95];");
      status.out.println("w_DESCRI=a[96];");
      status.out.println("w_gSeekAos=a[97];");
      status.out.println("w_gDataVaria=a[98];");
      status.out.println("w_gFlgDoc=a[99];");
      status.out.println("w_xDescDipe=a[100];");
      status.out.println("w_datpaseuro=a[101];");
      status.out.println("w_xdes1=a[102];");
      status.out.println("w_desccauana=a[103];");
      status.out.println("w_CITINT=a[104];");
      status.out.println("w_CITDIP=a[105];");
      status.out.println("w_PROVDIP=a[106];");
      status.out.println("w_CABDIP=a[107];");
      status.out.println("w_PROVINT=a[108];");
      status.out.println("w_CABINT=a[109];");
      status.out.println("w_xdesccausin=a[110];");
      status.out.println("w_gChkDate=a[111];");
      status.out.println("w_idcitta=a[112];");
      status.out.println("w_xdesctipatt=a[113];");
      status.out.println("w_gVLT=a[114];");
      status.out.println("w_gVNP=a[115];");
      status.out.println("w_gCodDip=a[116];");
      status.out.println("w_verifica=a[117];");
      status.out.println("w_gStpDwn=a[118];");
      status.out.println("w_MIDBIGLIETTO=a[119];");
      status.out.println("w_MIDBIGLIETTO1=a[120];");
      status.out.println("w_MIDBIGLIETTO2=a[121];");
      status.out.println("w_MIDBIGLIETTO3=a[122];");
      status.out.println("w_MIDBIGLIETTO4=a[123];");
      status.out.println("w_TELDIP=a[124];");
      status.out.println("w_CODLOC=a[125];");
      status.out.println("w_xFLGPLGIO=a[126];");
      status.out.println("w_xVPFLGATT=a[127];");
      status.out.println("w_DOC03=a[128];");
      status.out.println("w_DOC04=a[129];");
      status.out.println("w_tipop=a[130];");
      status.out.println("w_FLGSAVE=a[131];");
      status.out.println("w_dessta2=a[132];");
      status.out.println("if (Gt(a.length,133)) {");
      status.out.println("o_TIPOGIOCO=w_TIPOGIOCO;");
      status.out.println("o_NASCOMUN=w_NASCOMUN;");
      status.out.println("o_NASSTATO=w_NASSTATO;");
      status.out.println("o_PAESE=w_PAESE;");
      status.out.println("o_DESCCIT=w_DESCCIT;");
      status.out.println("o_ATTIV=w_ATTIV;");
      status.out.println("o_SOTGRUP=w_SOTGRUP;");
      status.out.println("o_DATAOPE=w_DATAOPE;");
      status.out.println("o_TIPOOPRAP=w_TIPOOPRAP;");
      status.out.println("o_CODANA=w_CODANA;");
      status.out.println("o_CODVOC=w_CODVOC;");
      status.out.println("o_CONNESBEN=w_CONNESBEN;");
      status.out.println("o_C_CTA=w_C_CTA;");
      status.out.println("o_CODDIPE=w_CODDIPE;");
      status.out.println("o_COLLEG=w_COLLEG;");
      status.out.println("o_idcitta=w_idcitta;;");
      status.out.println("o_CACODICE=w_CACODICE;");
      status.out.println("o_TIPODOC=w_TIPODOC;");
      status.out.println("o_RDCODAUT=w_RDCODAUT;");
      status.out.println("o_RDLOCAUT=w_RDLOCAUT;");
      status.out.println("o_PAESE2=w_PAESE2;");
      status.out.println("o_DESCCIT2=w_DESCCIT2;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['SNAINUMOPE'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_snai_oper_v_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(825,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","cgo_operazioni");
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
  void RaiseLoadedEntity(armt_snai_oper_vBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({SNAINUMOPE:"+SPLib.ToJSValue(BO.w_SNAINUMOPE,"C",15,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_snai_oper_vBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(armt_snai_oper_vBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(armt_snai_oper_vBO BO,ServletStatus status) {
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
  void WriteExitPage(armt_snai_oper_vBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({SNAINUMOPE:"+SPLib.ToJSValue(BO.w_SNAINUMOPE,"C",15,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_snai_oper_vBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_snai_oper_vBO BO,ServletStatus status) throws IOException {
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
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_cgo_read_codfisc.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    l_cJsUid = SPPrxycizer.proxycizedPath("arrt_cgo_read_dl.js");
    status.out.println(
     "<script src='../"+l_cJsUid+"'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chk_docaut.m_cEntityUid+"/arfn_chk_docaut.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_form_cf.m_cEntityUid+"/arfn_form_cf.js'>" +
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
      arfn_chk_docaut.GetCallableNames(callable);
      arfn_form_cf.GetCallableNames(callable);
      CPLib.AddToSet(callable,"Utilities");
      CPLib.AddToSet(callable,"arrt_cgo_moduli");
      CPLib.AddToSet(callable,"arrt_cgo_read_codfisc");
      CPLib.AddToSet(callable,"arrt_cgo_read_dl");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_snai_oper_vBO BO,String p_cUID) {
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
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gChkDate),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(BO.w_gVLT,"N",10,2));
      hCreator.AddValue(CPLib.ToSQL(BO.w_gVNP,"N",10,2));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gCodDip),"C",6,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gStpDwn),"C",1,0));
    } else if (CPLib.eq(p_cUID,"QZTTRBWAQL")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NEUBQNUEOJ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"HODZKKOSYW")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ODAYKSRECA")) {
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
    } else if (CPLib.eq(p_cUID,"WJQFIEBCQV")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"MBGANUUHRA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"YDUQCBNYFV")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"UOOQYQWWNG")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"BVEIQEJCLQ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_snai_oper_vBO BO) {
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
      if (result &&  ! (CPLib.Empty(BO.w_CACODICE))) {
        a = GetCheckVars(status,BO,"WJQFIEBCQV");
        b = status.m_CheckVars.optString("WJQFIEBCQV");
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
    }
    return result;
  }
}
