import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({"administrators","utenti standard","ruolo 3","utenti confidi","ruolo 5","agenzia","area finanza","help desk","consultazione","utilità"})
public class armt_ae_operazbo extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*1d713156*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "jperazbo";
    }
    public String w_IDBASE;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_IDBASE,context,"jperazbo","IDBASE","C",10,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
    armt_ae_operazboBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_jperazbo;
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
    return "Operazioni (AGE)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_ae_operazbo";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 909;
    l_eg.m_nEntityHeight = 710;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"jperazbo","tbcauana","tbvalute","jnarapbo","personbo","tbcitta","tbstati","inter2bo","intermbo","anadip","tbcausin","tbtipope","tbareegeog","tbsvolgim","tbplauso","tbtiporisc","tbdurata","tbimporto"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","Principale","page"),new ZoneItem("page_2","Operanti Conto Terzi / Dati Agenzia Entrate","page"),new ZoneItem("box_HGYWQIUORJ","",""),new ZoneItem("box_OXJSQGZIYF","",""),new ZoneItem("box_YDQEMCWVGS","Dati Soggetti/Rapporti Coinvolti nell'operazione","collapsible"),new ZoneItem("box_YSUXVYPEKQ","Dati ControParte","collapsible"),new ZoneItem("box_VNNYTOBGNA","Dati eventuale Intermediario ControParte","collapsible"),new ZoneItem("box_ANGGVVFTIZ","Dati Cambiavalute/SV","collapsible"),new ZoneItem("Esecutori","","collapsible"),new ZoneItem("box_HNGGJVVCNB","",""),new ZoneItem("box_EUBBNRKXRL","",""),new ZoneItem("AGE","Dati Per Agenzia Entrate (Campi modificabili liberamente)","collapsible")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"IDBASE"};
    l_eg.items = new SPItem[]{
                   new SPItem("DATAOPE","D",8,0, "edit","Data Operazione"),
                   new SPItem("CDATOPE","C",8,0, "hide","Data Operazione in Carattere"),
                   new SPItem("DATAREG","D",8,0, "hide","Data registrazione"),
                   new SPItem("FLAGFRAZ","C",1,0, "edit","Frazionata (S/N)"),
                   new SPItem("COLLEG","C",12,0, "edit","Collegamento Operazione Multiple"),
                   new SPItem("TIPOOPRAP","C",2,0, "edit","Tipo Operazione Completa"),
                   new SPItem("CODANA","C",4,0, "edit","Causale Analitica"),
                   new SPItem("CODVOC","C",2,0, "edit","Causale Sintetica"),
                   new SPItem("FLAGLIRE","C",1,0, "hide","Lire Euro Valuta"),
                   new SPItem("appolire","C",1,0, "edit","B11. Tipo Divisa"),
                   new SPItem("VALUTA","C",3,0, "edit","B12. Divisa"),
                   new SPItem("xTOTLIRE","N",15,2, "edit","B14. Totale Euro"),
                   new SPItem("FLAGCONT","C",1,0, "edit","Contanti (S/N)"),
                   new SPItem("xTOTCONT","N",15,2, "edit","B15. di cui contanti"),
                   new SPItem("CAMBIO","N",9,4, "edit","Cambio"),
                   new SPItem("RAPPORTO","C",25,0, "edit","Rapporto Collegato"),
                   new SPItem("CONNESCLI","C",16,0, "edit","Codice Cliente Occasionale"),
                   new SPItem("filtro","C",1,0, "hide",""),
                   new SPItem("CONNESOPER","C",16,0, "edit","Codice Cliente Occasionale"),
                   new SPItem("TIPOLEG","C",1,0, "edit","Tipo Legame"),
                   new SPItem("PAGASOGOP","C",1,0, "edit",""),
                   new SPItem("CONNESBEN","C",16,0, "edit","Codice Cliente Occasionale"),
                   new SPItem("CONNALTRO","C",16,0, "edit",""),
                   new SPItem("C_RAG","C",70,0, "edit","F11. Denominazione Controparte"),
                   new SPItem("C_CTA","C",30,0, "edit","F14B. Comune Controparte"),
                   new SPItem("C_PRV","C",2,0, "edit","F14C. Provincia Controparte"),
                   new SPItem("C_CAP","C",5,0, "edit","F16. CAP Controparte"),
                   new SPItem("C_CAB","C",6,0, "edit","F14A. CAB Controparte"),
                   new SPItem("C_IND","C",35,0, "edit","F15. Indirizzo Controparte"),
                   new SPItem("C_STA","C",3,0, "edit","F13. Stato Controparte"),
                   new SPItem("TIPOINT2","C",2,0, "edit","A31A. Tipo Intermediario C/Parte"),
                   new SPItem("CODINT2","C",11,0, "edit","Codice Intermediario C/Parte"),
                   new SPItem("DESCINTER","C",50,0, "edit","A34. Denominazione Intermediario C/Parte"),
                   new SPItem("PAESE","C",3,0, "edit","A32. Stato Intermediario C/Parte"),
                   new SPItem("C_RAPPORTO","C",25,0, "edit",""),
                   new SPItem("CODCAB2","C",6,0, "edit","A33A. CAB Intermediario C/Parte"),
                   new SPItem("PROV2","C",2,0, "edit","A33C. Provincia Intermediario C/Parte"),
                   new SPItem("DESC2","C",30,0, "edit","A33B. Comune Intermediario C/Parte"),
                   new SPItem("ZCPARTE","C",69,0, "edit",""),
                   new SPItem("IDBASE","C",10,0, "edit","Idbase"),
                   new SPItem("NUMPROG","C",11,0, "show","Numero Progressivo"),
                   new SPItem("CODINTER","C",11,0, "show","Codice Intermediario"),
                   new SPItem("CODDIPE","C",6,0, "edit","Codice Dipendenza"),
                   new SPItem("DESCCIT","C",30,0, "show","Città Dipendenza"),
                   new SPItem("SEGNO","C",1,0, "edit","Segno"),
                   new SPItem("DATARETT","D",8,0, "edit","Data Rettifica"),
                   new SPItem("PROVINCIA","C",2,0, "show","Provincia Dipendenza"),
                   new SPItem("CODCAB","C",6,0, "show","CAB Dipendenza"),
                   new SPItem("tipope","C",1,0, "hide",""),
                   new SPItem("TOTLIRE","N",15,0, "hide","Totale Operazione"),
                   new SPItem("TOTCONT","N",15,0, "hide","di cui contanti"),
                   new SPItem("TIPOINF","C",1,0, "hide","Tipo Informazione"),
                   new SPItem("IDEREG","C",20,0, "hide","ID Registrazione"),
                   new SPItem("DESCINTER","C",50,0, "hide",""),
                   new SPItem("FLAGRAP","C",1,0, "hide","Tipo Rapporto Collegato"),
                   new SPItem("OPRAP","C",1,0, "hide","Tipo operazione"),
                   new SPItem("OPERAZMOD","C",20,0, "hide","Operazione Modificata"),
                   new SPItem("RAPPORTBEN","C",25,0, "hide","Rapporto Beneficiario"),
                   new SPItem("OPERATORE","C",70,0, "hide","Operatore"),
                   new SPItem("AUTOM","C",5,0, "hide","Importazione da file esterno"),
                   new SPItem("gIntemediario","C",11,0, "hide","Intermediario"),
                   new SPItem("xdes1","C",90,0, "hide","Descrizione"),
                   new SPItem("desccauana","C",165,0, "hide","Descrizione"),
                   new SPItem("xdesccausin","C",165,0, "hide","Descrizione"),
                   new SPItem("descdiv","C",30,0, "hide","Descrizione"),
                   new SPItem("xragsocper","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("xdescrap","C",50,0, "hide","Descrizione"),
                   new SPItem("xragsocct","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("xragsocben","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("xdestipleg","C",50,0, "hide","Descrizione"),
                   new SPItem("xragint2","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("xdescpaese2","C",30,0, "hide","Descrizione"),
                   new SPItem("datpaseuro","D",8,0, "hide","Data Passaggio EURO"),
                   new SPItem("xDescDipe","C",30,0, "hide","Descrizione"),
                   new SPItem("sEdit","N",1,0, "hide",""),
                   new SPItem("gChkDate","C",1,0, "hide","Controllo Date"),
                   new SPItem("errmsg","C",100,0, "hide",""),
                   new SPItem("test","C",1,0, "hide",""),
                   new SPItem("FLAGRAP2","C",1,0, "hide","Tipo Rapporto Beneficiario"),
                   new SPItem("valflg2","C",1,0, "hide",""),
                   new SPItem("STATOREG","C",1,0, "hide","Stato registrazione"),
                   new SPItem("gTipInter","C",2,0, "hide","Tipo Intermediario"),
                   new SPItem("gSblocco","C",1,0, "hide","Sblocco controllo"),
                   new SPItem("xcodfisc","C",16,0, "hide","Codice Fiscale"),
                   new SPItem("PRGIMPOPE","N",15,0, "hide","Progressivo Import"),
                   new SPItem("dataoggi","D",8,0, "hide",""),
                   new SPItem("stringaflagrap2","C",9,0, "hide",""),
                   new SPItem("CDATAOPE","C",8,0, "hide","Data Operazione in Carattere"),
                   new SPItem("gDataVaria","D",8,0, "hide","Data Variazione"),
                   new SPItem("gStatus","C",4,0, "hide","Stato Operazione"),
                   new SPItem("CITINT","C",30,0, "hide","Città"),
                   new SPItem("CITDIP","C",30,0, "hide","Città"),
                   new SPItem("PROVDIP","C",2,0, "hide","Provincia"),
                   new SPItem("CABDIP","C",6,0, "hide","CAB"),
                   new SPItem("PROVINT","C",2,0, "hide","Provincia"),
                   new SPItem("CABINT","C",6,0, "hide","CAB"),
                   new SPItem("CONNESDOC","C",40,0, "hide","Connessione Tabella Storico Documenti"),
                   new SPItem("gFlgDoc","C",1,0, "hide","Collegamento con storico documenti"),
                   new SPItem("xtiporap","C",1,0, "hide","Provvisorio / Definitivo"),
                   new SPItem("dessta","C",40,0, "hide","Descrizione"),
                   new SPItem("CODVOC","C",2,0, "hide","Causale Sintetica"),
                   new SPItem("xragsocalt","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("xdciticon","C",40,0, "hide","Località"),
                   new SPItem("gFlgWU","C",1,0, "hide","Gestione WU"),
                   new SPItem("CDATREG","C",8,0, "hide","Data Registrazione in carattere"),
                   new SPItem("DATAVALI","D",8,0, "hide",""),
                   new SPItem("DATARILASC","D",8,0, "hide","Data Rilascio Doc."),
                   new SPItem("gFlgDTP","N",1,0, "hide","Forza Data Trasferimento Provvisorie"),
                   new SPItem("ANNOOPE","N",4,0, "hide","Anno Operazione (MT/IDP)"),
                   new SPItem("xFLGITAEST","C",1,0, "hide","I=Italia,E=Estero"),
                   new SPItem("IMPIN","N",15,2, "edit","Importo in Entrata"),
                   new SPItem("IMPOUT","N",15,2, "edit","Importo in Uscita"),
                   new SPItem("xdescmodsvo","C",200,0, "hide","Descrizione"),
                   new SPItem("xdescareag","C",50,0, "hide","Descrizione"),
                   new SPItem("xdescplauso","C",200,0, "hide","Descrizione"),
                   new SPItem("xdesctipor","C",100,0, "hide","Descrizione"),
                   new SPItem("xdescopeage","C",254,0, "hide","Descrizione"),
                   new SPItem("xdescfreq","C",200,0, "hide","Descrizione"),
                   new SPItem("xdescammo","C",200,0, "hide","Descrizione"),
                   new SPItem("OPERAG","C",3,0, "edit",""),
                   new SPItem("NOPROT","N",1,0, "edit",""),
                   new SPItem("RESPINS","C",30,0, "edit",""),
                   new SPItem("INFORM","C",30,0, "edit",""),
                   new SPItem("NATURA","C",50,0, "edit",""),
                   new SPItem("SCOPO","C",50,0, "edit",""),
                   new SPItem("AREAGEO","C",5,0, "edit",""),
                   new SPItem("MODSVOL","C",5,0, "edit",""),
                   new SPItem("RAGIO","C",5,0, "edit",""),
                   new SPItem("TIPO","C",3,0, "edit",""),
                   new SPItem("RAREA","N",3,0, "edit",""),
                   new SPItem("RCOMP","N",3,0, "edit",""),
                   new SPItem("RRAGIO","N",3,0, "edit",""),
                   new SPItem("RTIPO","N",3,0, "edit",""),
                   new SPItem("RFREQ","N",3,0, "edit",""),
                   new SPItem("RIMP","N",3,0, "edit",""),
                   new SPItem("DURAT","C",5,0, "edit",""),
                   new SPItem("AMMONT","C",5,0, "edit",""),
                   new SPItem("MITIG","N",4,0, "edit","Mitigazione (+/-)"),
                   new SPItem("MITGDOC","C",100,0, "edit","Documentazione Mitigazione")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_ae_operazboBO BO) {
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
    l_translations=new String[][]{{"10049460300",p_Context.Translate("Tipologia Rischio")},
    {"10082410841",p_Context.Translate("La differenza tra Data Operazione e Data Registrazione non deve superare i 30 gg")},
    {"1008789486",p_Context.Translate("Forza Data Trasferimento Provvisorie")},
    {"10095365423",p_Context.Translate("Provincia")},
    {"10126883135",p_Context.Translate("B11. Tipo Divisa")},
    {"10166248752",p_Context.Translate("A33B. Comune Intermediario C/Parte")},
    {"10196692374",p_Context.Translate("Non inviare agenzia Entrate")},
    {"10219814530",p_Context.Translate("Codice Cliente Occasionale")},
    {"10220423475",p_Context.Translate("Data Variazione")},
    {"1028598955",p_Context.Translate("Data registrazione")},
    {"103243324",p_Context.Translate("Tipo Operazione Agenzia Entrate")},
    {"10379997930",p_Context.Translate("Rapporto Collegato")},
    {"10455298077",p_Context.Translate("Codice Intermediario C/Parte")},
    {"10464441821",p_Context.Translate("%1")},
    {"10638010653",p_Context.Translate("Data Operazione in Carattere")},
    {"10639118571",p_Context.Translate("Tipo Legame")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"10703819256",p_Context.Translate("%1")},
    {"10721367335",p_Context.Translate("Stato registrazione")},
    {"10848850431",p_Context.Translate("CAB Dipendenza")},
    {"10849117717",p_Context.Translate("B12. Divisa")},
    {"10943726013",p_Context.Translate("di cui contanti")},
    {"10983493593",p_Context.Translate("Gestione WU")},
    {"11053408024",p_Context.Translate("Area Geografica")},
    {"11085000424",p_Context.Translate("F14A. CAB Controparte")},
    {"1108605666",p_Context.Translate("A32. Stato Intermediario C/Parte")},
    {"11135066302",p_Context.Translate("A33C. Provincia Intermediario C/Parte")},
    {"11137644647",p_Context.Translate("Tipo Operazione Completa")},
    {"11141557209",p_Context.Translate("F16. CAP Controparte")},
    {"11158852142",p_Context.Translate("Modalità Svolgimento")},
    {"11259116522",p_Context.Translate("Il segno dell'operazione non è compatibile con il tipo di operazione (11-19 / Dare)")},
    {"11291273118",p_Context.Translate("Soggetto operante utilizza mezzi propri")},
    {"11316624286",p_Context.Translate("Codice Intermediario")},
    {"11329559720",p_Context.Translate("Data Rettifica")},
    {"11356972522",p_Context.Translate("Provincia Dipendenza")},
    {"113866889",p_Context.Translate("Idbase")},
    {"11396780126",p_Context.Translate("Intermediario")},
    {"114016870",p_Context.Translate("Valute")},
    {"11419545353",p_Context.Translate("%1")},
    {"11424168249",p_Context.Translate("Altri Intermediari")},
    {"11446531735",p_Context.Translate("%1")},
    {"11459349451",p_Context.Translate("Sblocco controllo")},
    {"1148775685",p_Context.Translate("%1")},
    {"11525797640",p_Context.Translate("%ERRORMESSAGE%")},
    {"11628231202",p_Context.Translate("A31A. Tipo Intermediario C/Parte")},
    {"11655443642",p_Context.Translate("%1")},
    {"11710831322",p_Context.Translate("%1")},
    {"11767338828",p_Context.Translate("Operatore")},
    {"11835283726",p_Context.Translate("F15. Indirizzo Controparte")},
    {"11857520945",p_Context.Translate("Ammontare Operazione")},
    {"11887010137",p_Context.Translate("La differenza tra Data Operazione e Data Registrazione non deve superare i 30gg")},
    {"11921223220",p_Context.Translate("Codice Fiscale")},
    {"11950205337",p_Context.Translate("Premere il bottone per collegare le operazioni")},
    {"12101861285",p_Context.Translate("Tipo Rapporto Beneficiario")},
    {"12128708791",p_Context.Translate("La data di registrazione deve essere maggiore o uguale a quella dell'operazione")},
    {"12135010165",p_Context.Translate("A33A. CAB Intermediario C/Parte")},
    {"123704147",p_Context.Translate("Cambio")},
    {"1270140318",p_Context.Translate("Dipendenze")},
    {"1284129730",p_Context.Translate("F11. Denominazione Controparte")},
    {"1410438055",p_Context.Translate("F14B. Comune Controparte")},
    {"15186643",p_Context.Translate("Città")},
    {"1627951949",p_Context.Translate("Operazioni")},
    {"1637276170",p_Context.Translate("F14C. Provincia Controparte")},
    {"1638885956",p_Context.Translate("Visualizza i dati del cliente relativi all'operazione")},
    {"1663847547",p_Context.Translate("A34. Denominazione Intermediario C/Parte")},
    {"1690077224",p_Context.Translate("Data Rilascio Doc.")},
    {"1698385181",p_Context.Translate("ID Registrazione")},
    {"1722199786",p_Context.Translate("Frazionata (S/N)")},
    {"1729482089",p_Context.Translate("Impossibile utilizzare un codice diverso da 242 con tipo divisa = EURO")},
    {"1748201363",p_Context.Translate("Città Dipendenza")},
    {"18003",p_Context.Translate("CAB")},
    {"1825772649",p_Context.Translate("Totale Operazione")},
    {"1833587048",p_Context.Translate("Provvisorio / Definitivo")},
    {"1890893827",p_Context.Translate("Clienti")},
    {"191062270",p_Context.Translate("%1")},
    {"194410082",p_Context.Translate("Rapporti")},
    {"198756379",p_Context.Translate("Rapporto Beneficiario")},
    {"2063759932",p_Context.Translate("Località")},
    {"2070114244",p_Context.Translate("%1")},
    {"2071283709",p_Context.Translate("Codice Dipendenza")},
    {"210895516",p_Context.Translate("Documentazione Mitigazione")},
    {"215310487",p_Context.Translate("Causale Sintetica")},
    {"215536597",p_Context.Translate("Causale Analitica")},
    {"216014596",p_Context.Translate("I=Italia,E=Estero")},
    {"226933836",p_Context.Translate("Data Passaggio EURO")},
    {"237632211",p_Context.Translate("Contanti (S/N)")},
    {"282420974",p_Context.Translate("Causali Sintetiche")},
    {"282647084",p_Context.Translate("Causali Analitiche")},
    {"283403499",p_Context.Translate("Progressivo Import")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"301347801",p_Context.Translate("Il segno dell'operazione non è compatibile con il tipo di operazione (12-18 / Avere)")},
    {"307787605",p_Context.Translate("Mitigazione (+/-)")},
    {"308673648",p_Context.Translate("Tipo Rapporto Collegato")},
    {"339694596",p_Context.Translate("Connessione Tabella Storico Documenti")},
    {"340709450",p_Context.Translate("%1")},
    {"36480606",p_Context.Translate("Impossibile utilizzare il codice 242 con tipo divisa = VALUTA")},
    {"368688795",p_Context.Translate("Anno Operazione (MT/IDP)")},
    {"383234328",p_Context.Translate("Stato Operazione")},
    {"491820845",p_Context.Translate("Data Registrazione in carattere")},
    {"492802848",p_Context.Translate("Frequenza Operazione")},
    {"502956915",p_Context.Translate("B14. Totale Euro")},
    {"616535110",p_Context.Translate("B15. di cui contanti")},
    {"624505163",p_Context.Translate("Lire Euro Valuta")},
    {"643948227",p_Context.Translate("Importo in Uscita")},
    {"684190680",p_Context.Translate("Tipo Informazione")},
    {"698242285",p_Context.Translate("Importazione da file esterno")},
    {"7070950",p_Context.Translate("Importo in Entrata")},
    {"728888873",p_Context.Translate("F13. Stato Controparte")},
    {"7383187",p_Context.Translate("Stati")},
    {"750412439",p_Context.Translate("Collegamento Operazione Multiple")},
    {"7753123",p_Context.Translate("Segno")},
    {"824519334",p_Context.Translate("Operazione Modificata")},
    {"829201110",p_Context.Translate("Data Operazione")},
    {"839211622",p_Context.Translate("Numero Progressivo")},
    {"862812006",p_Context.Translate("Tipo operazione")},
    {"864597548",p_Context.Translate("Collegamento con storico documenti")},
    {"955814582",p_Context.Translate("Ragionevolezza Operazione")},
    {"976489378",p_Context.Translate("Controllo Date")},
    {"984756930",p_Context.Translate("Tipo Intermediario")},
    {"985412429",p_Context.Translate("Operazioni (AGE)")},
    {"995100987",p_Context.Translate("Tipo Registrazione")}};
    return l_translations;
  }
  void WriteStyles(armt_ae_operazboBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_ae_operazbo.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_ae_operazboBO BO,ServletStatus status) {
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
    status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("Principale"),"C",0,0)+"},{name:\"page_2\", element:\"page_2\", caption:"+SPLib.ToJSValue(status.context.Translate("Operanti Conto Terzi / Dati Agenzia Entrate"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
    status.out.println("Z.Tabs.Set('tabs',tabs);");
    status.out.println("} else {");
    status.out.println("var tabs = Z.Tabs.Get('tabs')");
    status.out.println("}");
    AddExtendedTabs(status);
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_ae_operazbo',false);");
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_ae_operazbo",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(armt_ae_operazboBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    WriteControls_p2(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,3);
  }
  void WriteControls_p1(armt_ae_operazboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:710px;width:909px;display:none'>" +
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
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"Principale");
    PrintSidebarContent(1,status,getSidebarItems(0),true);
    PrintContextMenu(1,status,getContextMenu(0),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2(armt_ae_operazboBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_2' class='PageContainer' style='position:relative;height:689px;width:909px;display:none'>" +
    "");
    WriteControls_p2_b0(BO,status);
    WriteControls_p2_b1(BO,status);
    WriteControls_p2_b2(BO,status);
    WriteControls_p2_b3(BO,status);
    WriteControls_p2_b4(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,2,"Operanti Conto Terzi / Dati Agenzia Entrate");
    PrintSidebarContent(2,status,getSidebarItems(1),true);
    PrintContextMenu(2,status,getContextMenu(1),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b0(armt_ae_operazboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_1' style='position:relative;height:190px;display:block' page='1'>" +
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
       "<div id='HGYWQIUORJ_DIV' class='UntitledBox'>" +
       "<div id='HGYWQIUORJ' class='BoxBody'>" +
       "</div>" +
       "</div>" +
      "");
      status.out.println(
       "<div id='OXJSQGZIYF_DIV' class='UntitledBox'>" +
       "<div id='OXJSQGZIYF' class='BoxBody'>" +
       "</div>" +
       "</div>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAOPE' id='DHPABFMAHC' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_DATAOPE,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='DHPABFMAHC_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='FLAGFRAZ' id='QHEJZYDDEZ' class='Combobox' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_FLAGFRAZ),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("0","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("0",CPLib.Trim(BO.w_FLAGFRAZ))?"SELECTED":"")+">" +
       ""+status.context.Translate("Normale")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_FLAGFRAZ))?"SELECTED":"")+">" +
       ""+status.context.Translate("Fraz. Trasferita")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_FLAGFRAZ))?"SELECTED":"")+">" +
       ""+status.context.Translate("Multipla")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('QHEJZYDDEZ'),w_FLAGFRAZ,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='COLLEG' id='FBSFGXGZYT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_COLLEG,"C",12,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='12' size='12' fieldtype='C' style='display:none'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPOOPRAP' id='KGJJECFNIC' class='Combobox' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_TIPOOPRAP),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODANA' id='UTKMIHOWMH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODANA,"C",4,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='4' fieldtype='C'>" +
       "<button id='UTKMIHOWMH_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "UTKMIHOWMH", "tbcauana", "", "cauinter")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODVOC' id='JFTTTRWQFB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODVOC,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
       "<button id='JFTTTRWQFB_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "JFTTTRWQFB", "tbcauana", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='appolire' id='XXKGUCJQWE' class='"+status.ObligatoryClass("Combobox "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"")+"' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_FLAGLIRE),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"disabled":"")+">" +
       "<option value="+SPLib.ToHTMLValue("L","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("L",CPLib.Trim(BO.w_appolire))?"SELECTED":"")+">" +
       ""+status.context.Translate("Lire")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("E","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("E",CPLib.Trim(BO.w_appolire))?"SELECTED":"")+">" +
       ""+status.context.Translate("Euro")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("V","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("V",CPLib.Trim(BO.w_appolire))?"SELECTED":"")+">" +
       ""+status.context.Translate("Valuta Estera")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('XXKGUCJQWE'),w_appolire,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='VALUTA' id='YGFXODFVYI' class='"+status.ObligatoryClass("Combobox")+"' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_VALUTA),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='xTOTLIRE' id='PIXUNJHQQK' type='text' class='"+status.ObligatoryClass("Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"")+"' value="+SPLib.ToHTMLValue(BO.w_xTOTLIRE,"N",15,2,"999,999,999,999.99", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='21' size='15' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='FLAGCONT' id='GHDJLBOEYX' class='Combobox' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_FLAGCONT),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("0","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("0",CPLib.Trim(BO.w_FLAGCONT))?"SELECTED":"")+">" +
       ""+status.context.Translate("No")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_FLAGCONT))?"SELECTED":"")+">" +
       ""+status.context.Translate("Si")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('GHDJLBOEYX'),w_FLAGCONT,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='xTOTCONT' id='IRQOQMDUXA' type='text' class='"+status.ObligatoryClass("Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"",BO.IRQOQMDUXA_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_xTOTCONT,"N",15,2,"999,999,999,999.99", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='21' size='15' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CAMBIO' id='AQSPNMQSXA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CAMBIO,"N",9,4,"9999.9999", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='12' size='9' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IDBASE' id='YPYBCLFHOV' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_IDBASE,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='10' size='10' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<input name='NUMPROG' id='TYDJDJIPJI' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_NUMPROG,"C",11,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='11' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FHIFSPJIWQ_DIV'>" +
       "<label id='FHIFSPJIWQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A03. Numero Progressivo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FUVQYJBXPR_DIV'>" +
       "<label id='FUVQYJBXPR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A21. Data Operazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='CODINTER' id='ZUFPYFWAFU' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CODINTER,"C",11,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='11' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CWEAEPHHVV_DIV'>" +
       "<label id='CWEAEPHHVV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A01B. Intermediario:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODDIPE' id='KXEUVNBTBC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODDIPE,"C",6,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_xDescDipe),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
       "<button id='KXEUVNBTBC_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_xDescDipe),"C",0,0)+" tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "KXEUVNBTBC", "anadip", "", "")+"" +
      "");
      status.out.println(
       "<input name='DESCCIT' id='KGOEXUTYVW' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DESCCIT,"C",30,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TOWPZGRIEX_DIV'>" +
       "<label id='TOWPZGRIEX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A23. Contanti:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CESAROTQCI_DIV'>" +
       "<label id='CESAROTQCI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A24. Causale Analitica:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PURXFBARDS_DIV' style='display:none'>" +
       "<label id='PURXFBARDS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A51. Data registrazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EYOFHMRBZI_DIV'>" +
       "<label id='EYOFHMRBZI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A52. Tipo Operazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PCYDLZWFSC_DIV'>" +
       "<label id='PCYDLZWFSC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("B11. Tipo Divisa:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OZAHWFFLSK_DIV'>" +
       "<label id='OZAHWFFLSK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("B12. Divisa:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SEGNO' id='VEGGMIUHSD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SEGNO,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='1' size='1' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FRJHXSGHQU_DIV'>" +
       "<label id='FRJHXSGHQU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("B13. Segno:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='QSCSWSCWOL_DIV'>" +
       "<label id='QSCSWSCWOL'>" +
       ""+SPLib.ToHTMLRepresentation((CPLib.ge(BO.w_DATAOPE,CPLib.CharToDate("20020101")) || CPLib.le(BO.w_datpaseuro,BO.w_DATAOPE)?"B14. Totale Euro:":"B14. Totale Lire:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZKCFWLDCQZ_DIV'>" +
       "<label id='ZKCFWLDCQZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("B15. di cui contanti:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NHBYSHDKOA_DIV'>" +
       "<label id='NHBYSHDKOA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cambio:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CUYLJCWOJN_DIV'>" +
       "<label id='CUYLJCWOJN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A11. Dipendenza:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FFUODKCFLH_DIV'>" +
       "<label id='FFUODKCFLH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A12B. Città:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TSXEWUJYEC_DIV'>" +
       "<label id='TSXEWUJYEC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A12C. Prov.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='AGREXMHTAA_DIV'>" +
       "<label id='AGREXMHTAA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A12A. CAB:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='AAQQBPLNLQ_DIV' style='display:none'>" +
       "<label id='AAQQBPLNLQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A22. Tipo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATARETT' id='IGFDIUZEOQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATARETT,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' style='display:none'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MCGGYJLXPH_DIV' style='display:none'>" +
       "<label id='MCGGYJLXPH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A53. Collegata a:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='PROVINCIA' id='SIYKBVMDQU' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_PROVINCIA,"C",2,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='CODCAB' id='EBKATKTHYT' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CODCAB,"C",6,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='6' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='AISKRPOPLA_DIV'>" +
       "<label id='AISKRPOPLA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A25. Sintetica:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WHSKCSNYYO_DIV'>" +
       "<label id='WHSKCSNYYO' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_desccauana),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation(BO.w_desccauana)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NALNLPMPAE_DIV'>" +
       "<label id='NALNLPMPAE' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_xdesccausin),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdesccausin)+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='javascript:href_RHYSMJSILT()' tabindex='-1' id='RHYSMJSILT_HREF'>" +
       "<img id='RHYSMJSILT' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/070.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Premere il bottone per collegare le operazioni"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Premere il bottone per collegare le operazioni"),"C",0,0)+">" +
       "</a>" +
      "");
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b1(armt_ae_operazboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='box_ANGGVVFTIZ' id='ANGGVVFTIZ_DIV' class='BoxContainer SPSection_collapsed CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='ANGGVVFTIZ_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='ANGGVVFTIZ_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Cambiavalute/SV")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='ANGGVVFTIZ_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderExpandImage", "../"+status.m_cTheme+"/formPage/box_expand.gif")+"' onclick='ToggleCollapsibleBox(\"ANGGVVFTIZ\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=ANGGVVFTIZ_HEADER&m_cBoxId=ANGGVVFTIZ&m_cInitialState=close&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Cambiavalute/SV"))+"");
    }
    status.out.println(
     "<div id='ANGGVVFTIZ' class='CollapsibleBody' style='position:relative;height:37px;display:none'>" +
    "");
    status.includeZoneAltInterface("box_ANGGVVFTIZ@BEGIN");
    if (status.includeZoneAltInterface("box_ANGGVVFTIZ")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("box_ANGGVVFTIZ@BEGIN") || status.HasZoneAltInterface("box_ANGGVVFTIZ@END")) {
        status.out.println(
         "<div id='ANGGVVFTIZ_boxContent' style='position:relative;height:37px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IMPIN' id='YXAKYHSWPW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_IMPIN,"N",15,2,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='15' fieldtype='N' style='display:none'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SIPPFUEECW_DIV' style='display:none'>" +
       "<label id='SIPPFUEECW' for='YXAKYHSWPW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Importo in Entrata:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IMPOUT' id='DPCGXWDECV' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_IMPOUT,"N",15,2,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='15' fieldtype='N'>" +
      "");
      WriteControls_p1_b1_1(BO,status);
    }
  }
  void WriteControls_p1_b1_1(armt_ae_operazboBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<span class='SPLabel' id='ZLLARVPZIO_DIV'>" +
     "<label id='ZLLARVPZIO' for='DPCGXWDECV'>" +
     ""+SPLib.ToHTMLRepresentation((CPLib.ne(CPLib.At(BO.w_CODANA,"|DB|DC"),0)?"Importo in Uscita:":"Importo Operazione al netto delle commissioni:"))+"" +
     "</label>" +
     "</span>" +
    "");
    if (status.HasZoneAltInterface("box_ANGGVVFTIZ@BEGIN") || status.HasZoneAltInterface("box_ANGGVVFTIZ@END")) {
      status.out.println(
       "</div>" +
      "");
    }
    WriteControls_p1_b1_CloseBand(BO,status);
  }
  void WriteControls_p1_b1_CloseBand(armt_ae_operazboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("box_ANGGVVFTIZ@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("box_ANGGVVFTIZ")) {
      status.out.println("Ctrl('ANGGVVFTIZ').style.height='auto';");
    } else {
      status.out.println("Ctrl('ANGGVVFTIZ').setAttribute('band_height',37);");
    }
    status.out.println("Ctrl('ANGGVVFTIZ').setAttribute('status','close');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_ae_operazboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_YDQEMCWVGS")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_YDQEMCWVGS' style='position:relative;height:1px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_YDQEMCWVGS")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_YDQEMCWVGS').style.height='auto';");
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
  void WriteControls_p1_b3(armt_ae_operazboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='box_YDQEMCWVGS' id='YDQEMCWVGS_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='YDQEMCWVGS_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='YDQEMCWVGS_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Soggetti/Rapporti Coinvolti nell'operazione")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='YDQEMCWVGS_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"YDQEMCWVGS\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=YDQEMCWVGS_HEADER&m_cBoxId=YDQEMCWVGS&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Soggetti/Rapporti Coinvolti nell'operazione"))+"");
    }
    status.out.println(
     "<div id='YDQEMCWVGS' class='CollapsibleBody' style='position:relative;height:171px;display:block'>" +
    "");
    status.includeZoneAltInterface("box_YDQEMCWVGS@BEGIN");
    if (status.includeZoneAltInterface("box_YDQEMCWVGS")) {
      WriteControls_p1_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("box_YDQEMCWVGS@BEGIN") || status.HasZoneAltInterface("box_YDQEMCWVGS@END")) {
        status.out.println(
         "<div id='YDQEMCWVGS_boxContent' style='position:relative;height:171px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RAPPORTO' id='HLPFLQLILN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RAPPORTO,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
       "<button id='HLPFLQLILN_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "HLPFLQLILN", "jnarapbo", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CONNESCLI' id='MLQSWPUYXK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONNESCLI,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
       "<button id='MLQSWPUYXK_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "MLQSWPUYXK", "personbo", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CONNESOPER' id='JHLWBNTKPL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONNESOPER,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
       "<button id='JHLWBNTKPL_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "JHLWBNTKPL", "personbo", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPOLEG' id='GRXZUKZAYO' class='"+status.ObligatoryClass("Combobox",BO.GRXZUKZAYO_isObligatory())+"' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_TIPOLEG),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='KSFGUUJEFK_DIV'>" +
       "<input name='PAGASOGOP' id='KSFGUUJEFK' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_PAGASOGOP,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_PAGASOGOP))?"CHECKED":"")+">" +
       "<label id='KSFGUUJEFK_LBL' for='KSFGUUJEFK' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Soggetto operante utilizza mezzi propri"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CONNESBEN' id='SYIIMUFSEQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONNESBEN,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
       "<button id='SYIIMUFSEQ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "SYIIMUFSEQ", "personbo", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CONNALTRO' id='JVSBAIMQUS' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONNALTRO,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
       "<button id='JVSBAIMQUS_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "JVSBAIMQUS", "personbo", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='QPUJWTNJVA_DIV'>" +
       "<label id='QPUJWTNJVA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A41. Rapporto Collegato:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VSWQOBIQXP_DIV'>" +
       "<label id='VSWQOBIQXP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A43. Tipo Legame:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GNQVCJVGNQ_DIV'>" +
       "<label id='GNQVCJVGNQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("C11. Intest. / Cliente Occ.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='QRIWNHGABL_DIV'>" +
       "<label id='QRIWNHGABL'>" +
       ""+SPLib.ToHTMLRepresentation((CPLib.lt(BO.w_DATAOPE,CPLib.CharToDate("20140101"))?"C21. Sogg. Op. Conto Terzi:":"C21. Esecutore: "))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JTKOMBMPVH_DIV'>" +
       "<label id='JTKOMBMPVH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("C31. Controparte Bonifico:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PFRVKZGNLA_DIV'>" +
       "<label id='PFRVKZGNLA'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xragsocper)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CCTRHLCTWU_DIV'>" +
       "<label id='CCTRHLCTWU'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdescrap)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WOGEIKUBYX_DIV'>" +
       "<label id='WOGEIKUBYX'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xragsocct)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XHXIVQRISQ_DIV'>" +
       "<label id='XHXIVQRISQ'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xragsocben)+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<a href='javascript:href_KJAPTMTYKV()' tabindex='-1' style='display:none' id='KJAPTMTYKV_HREF'>" +
       "<img id='KJAPTMTYKV' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/search_adm.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Visualizza i dati del cliente relativi all'operazione"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Visualizza i dati del cliente relativi all'operazione"),"C",0,0)+">" +
       "</a>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XNPBVJJOEN_DIV'>" +
       "<label id='XNPBVJJOEN'>" +
       ""+SPLib.ToHTMLRepresentation((CPLib.lt(BO.w_DATAOPE,CPLib.CharToDate("20140101"))?"C41. Titolare Effettivo:":"C51. Soggetto per conto del quale: "))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SUDZQYBKAE_DIV'>" +
       "<label id='SUDZQYBKAE'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xragsocalt)+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("box_YDQEMCWVGS@BEGIN") || status.HasZoneAltInterface("box_YDQEMCWVGS@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b3_CloseBand(armt_ae_operazboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("box_YDQEMCWVGS@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("box_YDQEMCWVGS")) {
      status.out.println("Ctrl('YDQEMCWVGS').style.height='auto';");
    } else {
      status.out.println("Ctrl('YDQEMCWVGS').setAttribute('band_height',171);");
    }
    status.out.println("Ctrl('YDQEMCWVGS').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b4(armt_ae_operazboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_YSUXVYPEKQ")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_YSUXVYPEKQ' style='position:relative;height:1px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_YSUXVYPEKQ")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_YSUXVYPEKQ').style.height='auto';");
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
  void WriteControls_p1_b5(armt_ae_operazboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='box_YSUXVYPEKQ' id='YSUXVYPEKQ_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='YSUXVYPEKQ_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='YSUXVYPEKQ_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati ControParte")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='YSUXVYPEKQ_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"YSUXVYPEKQ\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=YSUXVYPEKQ_HEADER&m_cBoxId=YSUXVYPEKQ&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati ControParte"))+"");
    }
    status.out.println(
     "<div id='YSUXVYPEKQ' class='CollapsibleBody' style='position:relative;height:90px;display:block'>" +
    "");
    status.includeZoneAltInterface("box_YSUXVYPEKQ@BEGIN");
    if (status.includeZoneAltInterface("box_YSUXVYPEKQ")) {
      WriteControls_p1_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("box_YSUXVYPEKQ@BEGIN") || status.HasZoneAltInterface("box_YSUXVYPEKQ@END")) {
        status.out.println(
         "<div id='YSUXVYPEKQ_boxContent' style='position:relative;height:90px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='C_RAG' id='AWPNTOJIRR' type='text' class='"+status.ObligatoryClass("Field",BO.AWPNTOJIRR_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_C_RAG,"C",70,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='70' size='70' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='C_CTA' id='ODAYKSRECA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_C_CTA,"C",30,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
       "<button id='ODAYKSRECA_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "ODAYKSRECA", "tbcitta", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='C_PRV' id='NOTZPDMYIA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_C_PRV,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='C_CAP' id='RDAVOEETJG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_C_CAP,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='C_CAB' id='BOTAJBWHHY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_C_CAB,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='C_IND' id='VYLHWTRQNX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_C_IND,"C",35,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='35' size='35' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='C_STA' id='YVIKEGPYPM' type='text' class='"+status.ObligatoryClass("Field",BO.YVIKEGPYPM_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_C_STA,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='YVIKEGPYPM_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "YVIKEGPYPM", "tbstati", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SBJQIAQUCN_DIV'>" +
       "<label id='SBJQIAQUCN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("F14C. Prov.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PFEQRACAUA_DIV'>" +
       "<label id='PFEQRACAUA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("F11. Denominazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RZBLEGCFJJ_DIV'>" +
       "<label id='RZBLEGCFJJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("F13. Stato:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TWTXGZJTAR_DIV'>" +
       "<label id='TWTXGZJTAR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("F15. Indirizzo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GDOCAGKROT_DIV'>" +
       "<label id='GDOCAGKROT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("F16. CAP:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WHMXTGXWGC_DIV'>" +
       "<label id='WHMXTGXWGC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("F14A. CAB:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XPSQTBKQQZ_DIV'>" +
       "<label id='XPSQTBKQQZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("F14B. Comune:"))+"" +
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
      if (status.HasZoneAltInterface("box_YSUXVYPEKQ@BEGIN") || status.HasZoneAltInterface("box_YSUXVYPEKQ@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b5_CloseBand(armt_ae_operazboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("box_YSUXVYPEKQ@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("box_YSUXVYPEKQ")) {
      status.out.println("Ctrl('YSUXVYPEKQ').style.height='auto';");
    } else {
      status.out.println("Ctrl('YSUXVYPEKQ').setAttribute('band_height',90);");
    }
    status.out.println("Ctrl('YSUXVYPEKQ').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b6(armt_ae_operazboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_VNNYTOBGNA")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_VNNYTOBGNA' style='position:relative;height:1px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_VNNYTOBGNA")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_VNNYTOBGNA').style.height='auto';");
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
  void WriteControls_p1_b7(armt_ae_operazboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='box_VNNYTOBGNA' id='VNNYTOBGNA_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='VNNYTOBGNA_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='VNNYTOBGNA_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati eventuale Intermediario ControParte")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='VNNYTOBGNA_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"VNNYTOBGNA\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=VNNYTOBGNA_HEADER&m_cBoxId=VNNYTOBGNA&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati eventuale Intermediario ControParte"))+"");
    }
    status.out.println(
     "<div id='VNNYTOBGNA' class='CollapsibleBody' style='position:relative;height:171px;display:block'>" +
    "");
    status.includeZoneAltInterface("box_VNNYTOBGNA@BEGIN");
    if (status.includeZoneAltInterface("box_VNNYTOBGNA")) {
      WriteControls_p1_b7_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("box_VNNYTOBGNA@BEGIN") || status.HasZoneAltInterface("box_VNNYTOBGNA@END")) {
        status.out.println(
         "<div id='VNNYTOBGNA_boxContent' style='position:relative;height:171px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPOINT2' id='BUGJZOCZYH' class='"+status.ObligatoryClass("Combobox",BO.BUGJZOCZYH_isObligatory())+"' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_TIPOINT2),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODINT2' id='NUZRBZHLLM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODINT2,"C",11,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='11' size='11' fieldtype='C'>" +
       "<button id='NUZRBZHLLM_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "NUZRBZHLLM", "inter2bo", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DESCINTER' id='ABKVYRXWAV' type='text' class='"+status.ObligatoryClass("Field",BO.ABKVYRXWAV_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_DESCINTER,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PAESE' id='GYOQKYEVYP' type='text' class='"+status.ObligatoryClass("Field",BO.GYOQKYEVYP_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_PAESE,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='GYOQKYEVYP_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "GYOQKYEVYP", "tbstati", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='C_RAPPORTO' id='YBNJCVPDUM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_C_RAPPORTO,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODCAB2' id='LCQKOYRNRT' type='text' class='"+status.ObligatoryClass("Field",BO.LCQKOYRNRT_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_CODCAB2,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
       "<button id='LCQKOYRNRT_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "LCQKOYRNRT", "tbcitta", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PROV2' id='QQJJGKCSOY' type='text' class='"+status.ObligatoryClass("Field",BO.QQJJGKCSOY_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_PROV2,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DESC2' id='WUSGSRXDMA' type='text' class='"+status.ObligatoryClass("Field",BO.WUSGSRXDMA_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_DESC2,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ZCPARTE' id='EPRSQUBPGF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ZCPARTE,"C",69,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='69' size='69' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XQTZXXRKAL_DIV'>" +
       "<label id='XQTZXXRKAL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A31A. Tipo Intermediario:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WVEGMKFSFB_DIV'>" +
       "<label id='WVEGMKFSFB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A31B. Intermediario C/Parte:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DDPYWTWDBG_DIV'>" +
       "<label id='DDPYWTWDBG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A32. Stato UIF:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WSMVZRJXYS_DIV'>" +
       "<label id='WSMVZRJXYS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A33B. Comune per esteso:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BKCOIKPFLJ_DIV'>" +
       "<label id='BKCOIKPFLJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A33C. Provincia:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YMRSJURZMI_DIV'>" +
       "<label id='YMRSJURZMI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A33A. CAB / Comune:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZSZJMHTNLV_DIV'>" +
       "<label id='ZSZJMHTNLV'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdescpaese2)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LPKMZXAILT_DIV' style='display:none'>" +
       "<label id='LPKMZXAILT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("OPERAZIONE CANCELLATA"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JTSYWOZZQD_DIV' style='display:none'>" +
       "<label id='JTSYWOZZQD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("COPIA OPERAZIONE MODIFICATA"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CARVDZRFVD_DIV'>" +
       "<label id='CARVDZRFVD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Nome per Esteso:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RUIGDGZVBM_DIV'>" +
       "<label id='RUIGDGZVBM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Conto:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FAWPPBAAYI_DIV'>" +
       "<label id='FAWPPBAAYI'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdciticon)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XUVZBTPJNH_DIV'>" +
       "<label id='XUVZBTPJNH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A34. Denominazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("box_VNNYTOBGNA@BEGIN") || status.HasZoneAltInterface("box_VNNYTOBGNA@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b7_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b7_CloseBand(armt_ae_operazboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("box_VNNYTOBGNA@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("box_VNNYTOBGNA")) {
      status.out.println("Ctrl('VNNYTOBGNA').style.height='auto';");
    } else {
      status.out.println("Ctrl('VNNYTOBGNA').setAttribute('band_height',171);");
    }
    status.out.println("Ctrl('VNNYTOBGNA').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b8(armt_ae_operazboBO BO,ServletStatus status) {
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
  void WriteControls_p2_b0(armt_ae_operazboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_2")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_2' style='position:relative;height:55px;display:block' page='2'>" +
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
       "<div id='HNGGJVVCNB_DIV' class='UntitledBox'>" +
       "<div id='HNGGJVVCNB' class='BoxBody'>" +
       "</div>" +
       "</div>" +
      "");
      status.out.println(
       "<div id='EUBBNRKXRL_DIV' class='UntitledBox'>" +
       "<div id='EUBBNRKXRL' class='BoxBody'>" +
       "</div>" +
       "</div>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YPYOQUQUZO_DIV'>" +
       "<label id='YPYOQUQUZO'>" +
       ""+SPLib.ToHTMLRepresentation("A01B. Intermediario: "+BO.w_CODINTER)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FSLWEQSSNU_DIV'>" +
       "<label id='FSLWEQSSNU'>" +
       ""+SPLib.ToHTMLRepresentation("A11. Dipendenza:"+BO.w_CODDIPE)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UGBWSZCQRL_DIV'>" +
       "<label id='UGBWSZCQRL'>" +
       ""+SPLib.ToHTMLRepresentation("A12B. Città: "+BO.w_DESCCIT)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HJOXUPJMAI_DIV'>" +
       "<label id='HJOXUPJMAI'>" +
       ""+SPLib.ToHTMLRepresentation(" A12C. Prov.: "+BO.w_PROVINCIA)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PYRWIMYTNP_DIV'>" +
       "<label id='PYRWIMYTNP'>" +
       ""+SPLib.ToHTMLRepresentation("A12A. CAB: "+BO.w_CODCAB)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p2_b1(armt_ae_operazboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Esecutori' id='ZYUUSRMPQG_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='ZYUUSRMPQG_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='ZYUUSRMPQG_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       "</span>" +
      "");
      status.out.println(
       "<img id='ZYUUSRMPQG_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"ZYUUSRMPQG\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=ZYUUSRMPQG_HEADER&m_cBoxId=ZYUUSRMPQG&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption=");
    }
    status.out.println(
     "<div id='ZYUUSRMPQG' class='CollapsibleBody' style='position:relative;height:178px;display:block'>" +
    "");
    status.includeZoneAltInterface("Esecutori@BEGIN");
    if (status.includeZoneAltInterface("Esecutori")) {
      WriteControls_p2_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Esecutori@BEGIN") || status.HasZoneAltInterface("Esecutori@END")) {
        status.out.println(
         "<div id='ZYUUSRMPQG_boxContent' style='position:relative;height:178px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<iframe name='ardt_sogopeprov' id='TQDGESLQVD' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
       "</iframe>" +
      "");
      if (status.HasZoneAltInterface("Esecutori@BEGIN") || status.HasZoneAltInterface("Esecutori@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p2_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p2_b1_CloseBand(armt_ae_operazboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Esecutori@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Esecutori")) {
      status.out.println("Ctrl('ZYUUSRMPQG').style.height='auto';");
    } else {
      status.out.println("Ctrl('ZYUUSRMPQG').setAttribute('band_height',178);");
    }
    status.out.println("Ctrl('ZYUUSRMPQG').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['ZYUUSRMPQG']=['TQDGESLQVD'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b2(armt_ae_operazboBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_EOKCAXCLZO")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_EOKCAXCLZO' style='position:relative;height:1px;display:block' page='2'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_EOKCAXCLZO")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_EOKCAXCLZO').style.height='auto';");
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
  void WriteControls_p2_b3(armt_ae_operazboBO BO,ServletStatus status) {
    status.out.println(
     "<div name='AGE' id='EOKCAXCLZO_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='EOKCAXCLZO_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='EOKCAXCLZO_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Per Agenzia Entrate (Campi modificabili liberamente)")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='EOKCAXCLZO_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"EOKCAXCLZO\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=EOKCAXCLZO_HEADER&m_cBoxId=EOKCAXCLZO&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Per Agenzia Entrate (Campi modificabili liberamente)"))+"");
    }
    status.out.println(
     "<div id='EOKCAXCLZO' class='CollapsibleBody' style='position:relative;height:410px;display:block'>" +
    "");
    status.includeZoneAltInterface("AGE@BEGIN");
    if (status.includeZoneAltInterface("AGE")) {
      WriteControls_p2_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("AGE@BEGIN") || status.HasZoneAltInterface("AGE@END")) {
        status.out.println(
         "<div id='EOKCAXCLZO_boxContent' style='position:relative;height:410px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='OPERAG' id='QEFXECTWSF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_OPERAG,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='QEFXECTWSF_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "QEFXECTWSF", "tbtipope", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZEYLNLLVTD_DIV'>" +
       "<label id='ZEYLNLLVTD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Operazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ILIJSVUNTQ_DIV'>" +
       "<label id='ILIJSVUNTQ'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdescopeage)+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='LEHLEQRJPH_DIV'>" +
       "<input name='NOPROT' id='LEHLEQRJPH' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_NOPROT,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_NOPROT)?"CHECKED":"")+">" +
       "<label id='LEHLEQRJPH_LBL' for='LEHLEQRJPH' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Non inviare agenzia Entrate"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RESPINS' id='VMRTFBBQHL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RESPINS,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='AMHSICIBVW_DIV'>" +
       "<label id='AMHSICIBVW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Responsabile Inserimento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='INFORM' id='KDWBJNGUTK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_INFORM,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PZUBJPCOXA_DIV'>" +
       "<label id='PZUBJPCOXA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Annotazioni varie:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HBAROSDSIX_DIV'>" +
       "<label id='HBAROSDSIX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("TIPOLOGIA E VALUTAZIONE RISCHIO (IIIa DIRETTIVA)"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NATURA' id='VSHUPFYWOC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NATURA,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SCOPO' id='VASVGQZJGP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SCOPO,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
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
       "<input name='MODSVOL' id='SFFFOYOWNH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MODSVOL,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
       "<button id='SFFFOYOWNH_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "SFFFOYOWNH", "tbsvolgim", "", "")+"" +
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
       "<input name='TIPO' id='DJOWYRMDDC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TIPO,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='DJOWYRMDDC_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "DJOWYRMDDC", "tbtiporisc", "", "")+"" +
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
       "<span class='SPLabel' id='NAVNOGNZNE_DIV'>" +
       "<label id='NAVNOGNZNE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Area Geografica:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RAREA' id='UDAYHICPVB' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RAREA,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LHTXLTQYIK_DIV'>" +
       "<label id='LHTXLTQYIK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Svol. Instaurazione Operaz.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HGXSBHTFKF_DIV'>" +
       "<label id='HGXSBHTFKF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Ragionevolezza Operazione:"))+"" +
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
       "<span class='SPLabel' id='PLAWSVGZSR_DIV'>" +
       "<label id='PLAWSVGZSR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Es. Natura = Mutuo; Scopo = Acquisto beni di consumo"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UOJWCVBOTW_DIV'>" +
       "<label id='UOJWCVBOTW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Valutazione: da 0 a 20 Regolare - da 20 a 30 Attenzione - sopra 30 Anomala"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RCOMP' id='ETALZDRBSO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RCOMP,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RRAGIO' id='QBTVZDKLCO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RRAGIO,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RTIPO' id='RUWEXWJASG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RTIPO,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RFREQ' id='MXYTQLATHC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RFREQ,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RIMP' id='KBIUAXUDXA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RIMP,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
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
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DURAT' id='CKJQULDXKW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DURAT,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
       "<button id='CKJQULDXKW_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "CKJQULDXKW", "tbdurata", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AMMONT' id='SXTYCPHBIM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AMMONT,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
       "<button id='SXTYCPHBIM_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "SXTYCPHBIM", "tbimporto", "", "")+"" +
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
       "<span class='SPLabel' id='CPZDORVHLG_DIV'>" +
       "<label id='CPZDORVHLG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("MITIGAZIONE RISCHIO"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MITIG' id='DOXBACRWUU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MITIG,"N",4,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='4' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VCBMHLXJMD_DIV'>" +
       "<label id='VCBMHLXJMD' for='DOXBACRWUU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Mitigazione (+/-):"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MITGDOC' id='OXGBDTWKSX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MITGDOC,"C",100,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='100' size='100' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PKJNNGBWFM_DIV'>" +
       "<label id='PKJNNGBWFM' for='OXGBDTWKSX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Documentazione Mitigazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NKPWKMDXUR_DIV'>" +
       "<label id='NKPWKMDXUR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("%"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("AGE@BEGIN") || status.HasZoneAltInterface("AGE@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p2_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p2_b3_CloseBand(armt_ae_operazboBO BO,ServletStatus status) {
    status.includeZoneAltInterface("AGE@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("AGE")) {
      status.out.println("Ctrl('EOKCAXCLZO').style.height='auto';");
    } else {
      status.out.println("Ctrl('EOKCAXCLZO').setAttribute('band_height',410);");
    }
    status.out.println("Ctrl('EOKCAXCLZO').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b4(armt_ae_operazboBO BO,ServletStatus status) {
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
  static void PrintState(armt_ae_operazboBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_ae_operazboBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
    if (BO.ardt_sogopeprov.IsUpdated()) {
      BO.m_cWv_ardt_sogopeprov = BO.ardt_sogopeprov.GetContext();
    }
  }
  static void PrintStateWorkVars(armt_ae_operazboBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_DATAOPE,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CDATOPE,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAREG,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGFRAZ,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_COLLEG,"C",12,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOOPRAP,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODANA,"C",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODVOC,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGLIRE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VALUTA,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGCONT,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAMBIO,"N",9,4));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNESCLI,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNESOPER,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOLEG,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PAGASOGOP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNESBEN,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNALTRO,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C_RAG,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C_CTA,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C_PRV,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C_CAP,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C_CAB,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C_IND,"C",35,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C_STA,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOINT2,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODINT2,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCINTER,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PAESE,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_C_RAPPORTO,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODCAB2,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROV2,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESC2,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ZCPARTE,"C",69,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_IDBASE:BO.w_IDBASE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMPROG,"C",11,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_NUMPROG:BO.w_NUMPROG,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODINTER,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODDIPE,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCCIT,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SEGNO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATARETT,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINCIA,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODCAB,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TOTLIRE,"N",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TOTCONT,"N",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOINF,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDEREG,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGRAP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OPRAP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OPERAZMOD,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAPPORTBEN,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OPERATORE,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AUTOM,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGRAP2,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_STATOREG,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PRGIMPOPE,"N",15,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_PRGIMPOPE:BO.w_PRGIMPOPE,"N",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CDATAOPE,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNESDOC,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CDATREG,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ANNOOPE,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IMPIN,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_IMPOUT,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_OPERAG,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOPROT,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RESPINS,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_INFORM,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NATURA,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SCOPO,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AREAGEO,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MODSVOL,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAGIO,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPO,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAREA,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RCOMP,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RRAGIO,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RTIPO,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RFREQ,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RIMP,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DURAT,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AMMONT,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MITIG,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MITGDOC,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescmodsvo,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescareag,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescplauso,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesctipor,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescopeage,"C",254,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescfreq,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescammo,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_appolire,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xTOTLIRE,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_xTOTCONT,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_filtro,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipope,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gIntemediario,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdes1,"C",90,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_desccauana,"C",165,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesccausin,"C",165,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descdiv,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragsocper,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescrap,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragsocct,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragsocben,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdestipleg,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragint2,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescpaese2,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_datpaseuro,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDescDipe,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_sEdit,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gChkDate,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_errmsg,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_test,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_valflg2,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gTipInter,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gSblocco,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xcodfisc,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dataoggi,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_stringaflagrap2,"C",9,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gDataVaria,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gStatus,"C",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CITINT,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CITDIP,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVDIP,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CABDIP,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINT,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CABINT,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgDoc,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xtiporap,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dessta,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragsocalt,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdciticon,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgWU,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAVALI,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATARILASC,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgDTP,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xFLGITAEST,"C",1,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_codazi:BO.m_Ctx.GetCompany(),"C",10,0));
    if (CPLib.eq(BO.m_cWv_ardt_sogopeprov,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_sogopeprov");
    } else if (CPLib.eq(BO.m_cWv_ardt_sogopeprov,"_not_empty_")) {
      BO.m_cWv_ardt_sogopeprov = BO.ardt_sogopeprov.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_sogopeprov,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_sogopeprov,"C",0,0));
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_ae_operazboBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_QSCSWSCWOL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_QRIWNHGABL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_PFRVKZGNLA = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_CCTRHLCTWU = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_WOGEIKUBYX = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_XHXIVQRISQ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ZSZJMHTNLV = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_XNPBVJJOEN = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_SUDZQYBKAE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_WHSKCSNYYO = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_NALNLPMPAE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_FAWPPBAAYI = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ESVLUSNYWB = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ZLLARVPZIO = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ZYUUSRMPQG = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_YPYOQUQUZO = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_FSLWEQSSNU = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_UGBWSZCQRL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_HJOXUPJMAI = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_PYRWIMYTNP = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ILIJSVUNTQ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_CMKJDFEFFI = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_DXOTWSGBKN = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_FXHEISJAJE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_GHHOMNKDDQ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_BCFLBBQSRN = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_QEXJCFPJBM = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(710,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_ae_operazbo"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'UTKMIHOWMH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"UTKMIHOWMH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcauana,"+"cauinter",l_session)+"'"+"]");
      status.out.print(",'JFTTTRWQFB':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"JFTTTRWQFB",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcauana,"+"default",l_session)+"'"+"]");
      status.out.print(",'YGFXODFVYI':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"YGFXODFVYI",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbvalute,"+"default",l_session)+"'"+"]");
      status.out.print(",'HLPFLQLILN':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"HLPFLQLILN",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,jnarapbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'MLQSWPUYXK':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"MLQSWPUYXK",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'JHLWBNTKPL':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"JHLWBNTKPL",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'GRXZUKZAYO':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("qbe_tipileg",l_session)+"']");
      status.out.print(",'SYIIMUFSEQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SYIIMUFSEQ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'JVSBAIMQUS':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"JVSBAIMQUS",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'ODAYKSRECA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ODAYKSRECA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'YVIKEGPYPM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"YVIKEGPYPM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'NUZRBZHLLM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NUZRBZHLLM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,inter2bo,"+"default",l_session)+"'"+"]");
      status.out.print(",'GYOQKYEVYP':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"GYOQKYEVYP",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'LCQKOYRNRT':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"LCQKOYRNRT",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZUFPYFWAFU':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ZUFPYFWAFU",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,intermbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'KXEUVNBTBC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"KXEUVNBTBC",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'KHRUYMSPDK':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"KHRUYMSPDK",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcausin,"+"default",l_session)+"'"+"]");
      status.out.print(",'QEFXECTWSF':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QEFXECTWSF",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipope,"+"default",l_session)+"'"+"]");
      status.out.print(",'QJSTZIPOQB':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QJSTZIPOQB",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog,"+"default",l_session)+"'"+"]");
      status.out.print(",'SFFFOYOWNH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SFFFOYOWNH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsvolgim,"+"default",l_session)+"'"+"]");
      status.out.print(",'NOBMPHKVTX':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NOBMPHKVTX",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbplauso,"+"default",l_session)+"'"+"]");
      status.out.print(",'DJOWYRMDDC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"DJOWYRMDDC",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtiporisc,"+"default",l_session)+"'"+"]");
      status.out.print(",'CKJQULDXKW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"CKJQULDXKW",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbdurata,"+"default",l_session)+"'"+"]");
      status.out.print(",'SXTYCPHBIM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SXTYCPHBIM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbimporto,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'UTKMIHOWMH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcauana,"+"cauinter",l_session)+"'"+"]");
      status.out.print(",'JFTTTRWQFB':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcauana,"+"default",l_session)+"'"+"]");
      status.out.print(",'YGFXODFVYI':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbvalute,"+"default",l_session)+"'"+"]");
      status.out.print(",'HLPFLQLILN':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,jnarapbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'MLQSWPUYXK':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'JHLWBNTKPL':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'SYIIMUFSEQ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'JVSBAIMQUS':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'ODAYKSRECA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'YVIKEGPYPM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'NUZRBZHLLM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,inter2bo,"+"default",l_session)+"'"+"]");
      status.out.print(",'GYOQKYEVYP':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'LCQKOYRNRT':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'ZUFPYFWAFU':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,intermbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'KXEUVNBTBC':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'KHRUYMSPDK':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcausin,"+"default",l_session)+"'"+"]");
      status.out.print(",'QEFXECTWSF':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipope,"+"default",l_session)+"'"+"]");
      status.out.print(",'QJSTZIPOQB':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog,"+"default",l_session)+"'"+"]");
      status.out.print(",'SFFFOYOWNH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsvolgim,"+"default",l_session)+"'"+"]");
      status.out.print(",'NOBMPHKVTX':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbplauso,"+"default",l_session)+"'"+"]");
      status.out.print(",'DJOWYRMDDC':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtiporisc,"+"default",l_session)+"'"+"]");
      status.out.print(",'CKJQULDXKW':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbdurata,"+"default",l_session)+"'"+"]");
      status.out.print(",'SXTYCPHBIM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbimporto,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_ae_operazbo","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_ae_operazbo",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("box_HGYWQIUORJ"),"")) {
      status.quoteAndAppend("box_HGYWQIUORJ","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_OXJSQGZIYF"),"")) {
      status.quoteAndAppend("box_OXJSQGZIYF","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_YDQEMCWVGS"),"")) {
      status.quoteAndAppend("box_YDQEMCWVGS","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_YSUXVYPEKQ"),"")) {
      status.quoteAndAppend("box_YSUXVYPEKQ","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_VNNYTOBGNA"),"")) {
      status.quoteAndAppend("box_VNNYTOBGNA","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_ANGGVVFTIZ"),"")) {
      status.quoteAndAppend("box_ANGGVVFTIZ","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Esecutori"),"")) {
      status.quoteAndAppend("Esecutori","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_HNGGJVVCNB"),"")) {
      status.quoteAndAppend("box_HNGGJVVCNB","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_EUBBNRKXRL"),"")) {
      status.quoteAndAppend("box_EUBBNRKXRL","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("AGE"),"")) {
      status.quoteAndAppend("AGE","hide","box");
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
  void WriteMainFormScript(armt_ae_operazboBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_ae_operazbo',false);");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
      status.out.println("SetCollapsibleCaptions();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('DHPABFMAHC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DHPABFMAHC_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QHEJZYDDEZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FBSFGXGZYT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KGJJECFNIC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UTKMIHOWMH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UTKMIHOWMH_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JFTTTRWQFB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JFTTTRWQFB_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XXKGUCJQWE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YGFXODFVYI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('PIXUNJHQQK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GHDJLBOEYX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IRQOQMDUXA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AQSPNMQSXA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HLPFLQLILN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HLPFLQLILN_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MLQSWPUYXK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MLQSWPUYXK_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JHLWBNTKPL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JHLWBNTKPL_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GRXZUKZAYO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KSFGUUJEFK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SYIIMUFSEQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SYIIMUFSEQ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JVSBAIMQUS')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JVSBAIMQUS_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AWPNTOJIRR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ODAYKSRECA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ODAYKSRECA_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NOTZPDMYIA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RDAVOEETJG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BOTAJBWHHY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VYLHWTRQNX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YVIKEGPYPM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YVIKEGPYPM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BUGJZOCZYH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NUZRBZHLLM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NUZRBZHLLM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ABKVYRXWAV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GYOQKYEVYP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GYOQKYEVYP_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YBNJCVPDUM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LCQKOYRNRT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LCQKOYRNRT_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QQJJGKCSOY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WUSGSRXDMA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EPRSQUBPGF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YPYBCLFHOV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KXEUVNBTBC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KXEUVNBTBC_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VEGGMIUHSD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IGFDIUZEOQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YXAKYHSWPW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DPCGXWDECV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QEFXECTWSF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QEFXECTWSF_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LEHLEQRJPH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VMRTFBBQHL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KDWBJNGUTK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VSHUPFYWOC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VASVGQZJGP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QJSTZIPOQB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QJSTZIPOQB_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SFFFOYOWNH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SFFFOYOWNH_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NOBMPHKVTX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NOBMPHKVTX_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DJOWYRMDDC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DJOWYRMDDC_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UDAYHICPVB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ETALZDRBSO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QBTVZDKLCO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RUWEXWJASG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MXYTQLATHC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KBIUAXUDXA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CKJQULDXKW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CKJQULDXKW_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SXTYCPHBIM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SXTYCPHBIM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DOXBACRWUU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OXGBDTWKSX')) SetDisabled(c,true);");
      }
      status.out.println("HideControlsUnderCondition();");
      status.out.println("SetCollapsibleCaptions();");
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
      status.out.println("if (Ctrl('TQDGESLQVD')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('TQDGESLQVD',linkpc_url('TQDGESLQVD'));");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('YPYBCLFHOV')) SetDisabled(c,true);");
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
    status.out.println("if (Eq(name,'ardt_sogopeprov')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_sogopeprov")+"';");
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
      status.out.println("if (Eq(p_uid,'PRGIMPOPE') || Empty(p_uid)) {");
      status.out.println("l_b2= ! (Eq(op_codazi,m_cCompany));");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"new")) {
        status.out.println("if (l_b0) {");
        status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_IDBASE','PPOPER1');");
        status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
        status.out.println("AutonumberApplet().SetProg('IDBASE',w_IDBASE,op_IDBASE,'C',10,0);");
        status.out.println("AutonumberApplet().SetETName('jperazbo');");
        status.out.println("w_IDBASE=AutonumberApplet().GetAutonumberString('IDBASE');");
        status.out.println("}");
      }
      status.out.println("if (l_b1) {");
      status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_NUMPROG','PPOPER2');");
      status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
      status.out.println("AutonumberApplet().SetProg('NUMPROG',w_NUMPROG,op_NUMPROG,'C',11,0);");
      status.out.println("AutonumberApplet().SetETName('jperazbo');");
      status.out.println("w_NUMPROG=AutonumberApplet().GetAutonumberString('NUMPROG');");
      status.out.println("}");
      status.out.println("if (l_b2) {");
      status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_PRGIMPOPE','PRGIMPOPE');");
      status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
      status.out.println("AutonumberApplet().SetProg('PRGIMPOPE',w_PRGIMPOPE,op_PRGIMPOPE,'N',15,0);");
      status.out.println("AutonumberApplet().SetETName('jperazbo');");
      status.out.println("w_PRGIMPOPE=AutonumberApplet().GetAutonumberDouble('PRGIMPOPE');");
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
      status.out.println("op_PRGIMPOPE=w_PRGIMPOPE;");
      status.out.println("}");
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
  armt_ae_operazboBO getBO(ServletStatus status) {
    armt_ae_operazboBO BO = new armt_ae_operazboBO(status.context);
    // gli op_ possono essere utilizzati dalla servlet anche prima di essere inizializzati
    BO.op_IDBASE = BO.w_IDBASE;
    BO.op_NUMPROG = BO.w_NUMPROG;
    BO.op_PRGIMPOPE = BO.w_PRGIMPOPE;
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_ae_operazboBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("jperazbo",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_ae_operazboBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void WriteTableCombo(ServletStatus status,armt_ae_operazboBO BO) {
    String l_cTmp;
    CPResultSet l_rsLoad=null;
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbtipreg,CPSql.BuildSQLPhrase("CODICE,DES1",BO.m_cPhName_tbtipreg,"OPERAZIO="+CPLib.ToSQL("1","C",1,0)+"",""));
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
    status.out.println("var KGJJECFNIC_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_rsLoad = BO.m_Sql.Query(BO.m_cServer_tbvalute,CPSql.BuildSQLPhrase("CODVAL,DESCRI",BO.m_cPhName_tbvalute,"",""));
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",3,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("CODVAL"),"C",3,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var YGFXODFVYI_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    VQRHolder l_VQRHolder=null;
    SPBridge.HMCaller _h_GRXZUKZAYO = new SPBridge.HMCaller();
    _h_GRXZUKZAYO.Set("CDATOPE",BO.w_CDATOPE);
    _h_GRXZUKZAYO.Set("filtro",BO.w_filtro);
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_tipileg",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),_h_GRXZUKZAYO,false);
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
    status.out.println("var GRXZUKZAYO_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_tbtipint",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),BO,false);
    l_VQRHolder.LoadTempWhere("");
    l_rsLoad = l_VQRHolder.GetResultSet(BO.m_Ctx);
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
    status.out.println("var BUGJZOCZYH_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(armt_ae_operazboBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_jperazbo;
    String l_cPhName = BO.m_cPhName_jperazbo;
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
      String l_cQueryFilter = armt_ae_operazboBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_jperazbo+".IDBASE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("jperazbo");
    String l_cPhName = CPSql.ManipulateTablePhName("jperazbo",l_cServer);
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
  void Query(ServletStatus status,armt_ae_operazboBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_ae_operazboBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_jperazbo,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_jperazbo,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_ae_operazboBO BO) {
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
  void Edit(ServletStatus status,armt_ae_operazboBO BO,SPParameterSource source) {
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
  void New(ServletStatus status,armt_ae_operazboBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_ae_operazboBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_ae_operazboBO BO) {
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
  void EditLoad(ServletStatus status,armt_ae_operazboBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_ae_operazboBO BO,SPParameterSource source) {
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
  void DeleteMessage(ServletStatus status,armt_ae_operazboBO BO,SPParameterSource source) {
    BO.Load(status.w_IDBASE);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_ae_operazboBO BO) {
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
    double l_old_PRGIMPOPE = 0;
    if (CPLib.ne(BO.w_PRGIMPOPE,BO.op_PRGIMPOPE)) {
      l_old_PRGIMPOPE = BO.op_PRGIMPOPE;
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
      if ( ! (CPLib.Empty(l_old_PRGIMPOPE))) {
        BO.op_PRGIMPOPE = l_old_PRGIMPOPE;
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
  void Discard(ServletStatus status,armt_ae_operazboBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_ae_operazboBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",667);
    item.put("w",909);
    item.put("color","transparent");
    item.put("form_type","false");
    item.put("security","none");
    item.put("sp_theme","false");
    item.put("language","true");
    org.json.JSONObject pageProp = null;
    org.json.JSONArray pagesProp = null;
    pagesProp = new org.json.JSONArray();
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Principale\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Operanti Conto Terzi \\/ Dati Agenzia Entrate\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Principale,Operanti Conto Terzi / Dati Agenzia Entrate");
    item.put("altInterfaceFor","armt_ae_operazbo");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_HGYWQIUORJ\",\"h\":180,\"name\":\"box_HGYWQIUORJ\",\"page\":1,\"shrinkable\":true,\"spuid\":\"HGYWQIUORJ\",\"tabindex\":1,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":9,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"Data Operazione\",\"h\":20,\"maxlength\":10,\"name\":\"DATAOPE\",\"page\":1,\"picker\":true,\"spuid\":\"DHPABFMAHC\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":136,\"y\":54,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero Progressivo\",\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"NUMPROG\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"TYDJDJIPJI\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":88,\"x\":408,\"y\":54,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FHIFSPJIWQ\",\"page\":1,\"spuid\":\"FHIFSPJIWQ\",\"tabindex\":47,\"type\":\"Label\",\"value\":\"A03. Numero Progressivo:\",\"w\":138,\"x\":267,\"y\":58,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FUVQYJBXPR\",\"page\":1,\"spuid\":\"FUVQYJBXPR\",\"tabindex\":48,\"type\":\"Label\",\"value\":\"A21. Data Operazione:\",\"w\":122,\"x\":13,\"y\":58,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Frazionata (S\\/N)\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"FLAGFRAZ\",\"page\":1,\"spuid\":\"QHEJZYDDEZ\",\"tabindex\":9,\"textlist\":\"Normale,Fraz. Trasferita,Multipla\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"0"+"'"+","+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":128,\"x\":136,\"y\":81,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Collegamento Operazione Multiple\",\"h\":20,\"maxlength\":12,\"name\":\"COLLEG\",\"page\":1,\"spuid\":\"FBSFGXGZYT\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":104,\"x\":360,\"y\":81,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Operazione Completa\",\"h\":20,\"maxlength\":2,\"name\":\"TIPOOPRAP\",\"page\":1,\"spuid\":\"KGJJECFNIC\",\"tabindex\":11,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":296,\"x\":592,\"y\":81,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EYOFHMRBZI\",\"page\":1,\"spuid\":\"EYOFHMRBZI\",\"tabindex\":64,\"type\":\"Label\",\"value\":\"A52. Tipo Operazione:\",\"w\":118,\"x\":474,\"y\":85,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AAQQBPLNLQ\",\"page\":1,\"spuid\":\"AAQQBPLNLQ\",\"tabindex\":84,\"type\":\"Label\",\"value\":\"A22. Tipo:\",\"w\":67,\"x\":64,\"y\":85,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MCGGYJLXPH\",\"page\":1,\"spuid\":\"MCGGYJLXPH\",\"tabindex\":88,\"type\":\"Label\",\"value\":\"A53. Collegata a:\",\"w\":90,\"x\":272,\"y\":85,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Premere il bottone per collegare le operazioni\",\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_RHYSMJSILT\",\"page\":1,\"spuid\":\"RHYSMJSILT\",\"src\":\"..\\/images\\/070.gif\",\"tabindex\":162,\"type\":\"Image\",\"w\":19,\"x\":463,\"y\":82,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Causale Analitica\",\"h\":20,\"maxlength\":4,\"name\":\"CODANA\",\"page\":1,\"picker\":true,\"spuid\":\"UTKMIHOWMH\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":136,\"y\":108,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Causale Sintetica\",\"h\":20,\"maxlength\":2,\"name\":\"CODVOC\",\"page\":1,\"picker\":true,\"spuid\":\"JFTTTRWQFB\",\"tabindex\":13,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":592,\"y\":108,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CESAROTQCI\",\"page\":1,\"spuid\":\"CESAROTQCI\",\"tabindex\":54,\"type\":\"Label\",\"value\":\"A24. Causale Analitica:\",\"w\":122,\"x\":13,\"y\":112,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AISKRPOPLA\",\"page\":1,\"spuid\":\"AISKRPOPLA\",\"tabindex\":96,\"type\":\"Label\",\"value\":\"A25. Sintetica:\",\"w\":78,\"x\":514,\"y\":112,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"%w_desccauana%\",\"h\":16,\"name\":\"label_WHSKCSNYYO\",\"page\":1,\"spuid\":\"WHSKCSNYYO\",\"tabindex\":97,\"type\":\"Label\",\"w\":310,\"x\":202,\"y\":112,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"%w_xdesccausin%\",\"h\":16,\"name\":\"label_NALNLPMPAE\",\"page\":1,\"spuid\":\"NALNLPMPAE\",\"tabindex\":98,\"type\":\"Label\",\"w\":247,\"x\":649,\"y\":112,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"B11. Tipo Divisa\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"appolire\",\"page\":1,\"spuid\":\"XXKGUCJQWE\",\"tabindex\":15,\"textlist\":\"Lire,Euro,Valuta Estera\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"L"+"'"+","+"'"+"E"+"'"+","+"'"+"V"+"'"+"\",\"w\":160,\"x\":136,\"y\":135,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"B12. Divisa\",\"h\":20,\"maxlength\":3,\"name\":\"VALUTA\",\"page\":1,\"spuid\":\"YGFXODFVYI\",\"tabindex\":16,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":384,\"x\":392,\"y\":135,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PCYDLZWFSC\",\"page\":1,\"spuid\":\"PCYDLZWFSC\",\"tabindex\":65,\"type\":\"Label\",\"value\":\"B11. Tipo Divisa:\",\"w\":90,\"x\":45,\"y\":139,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OZAHWFFLSK\",\"page\":1,\"spuid\":\"OZAHWFFLSK\",\"tabindex\":66,\"type\":\"Label\",\"value\":\"B12. Divisa:\",\"w\":62,\"x\":329,\"y\":139,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"B14. Totale Euro\",\"h\":20,\"maxlength\":21,\"name\":\"xTOTLIRE\",\"page\":1,\"spuid\":\"PIXUNJHQQK\",\"tabindex\":17,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":114,\"x\":136,\"y\":162,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Contanti (S\\/N)\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"FLAGCONT\",\"page\":1,\"spuid\":\"GHDJLBOEYX\",\"tabindex\":18,\"textlist\":\"No,Si\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"0"+"'"+","+"'"+"1"+"'"+"\",\"w\":104,\"x\":360,\"y\":162,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"B15. di cui contanti\",\"h\":20,\"maxlength\":21,\"name\":\"xTOTCONT\",\"page\":1,\"spuid\":\"IRQOQMDUXA\",\"tabindex\":19,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":114,\"x\":600,\"y\":162,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cambio\",\"h\":20,\"maxlength\":12,\"name\":\"CAMBIO\",\"page\":1,\"spuid\":\"AQSPNMQSXA\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":824,\"y\":162,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TOWPZGRIEX\",\"page\":1,\"spuid\":\"TOWPZGRIEX\",\"tabindex\":53,\"type\":\"Label\",\"value\":\"A23. Contanti:\",\"w\":80,\"x\":279,\"y\":166,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Segno\",\"h\":20,\"maxlength\":1,\"name\":\"SEGNO\",\"page\":1,\"spuid\":\"VEGGMIUHSD\",\"tabindex\":67,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":872,\"y\":135,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FRJHXSGHQU\",\"page\":1,\"spuid\":\"FRJHXSGHQU\",\"tabindex\":68,\"type\":\"Label\",\"value\":\"B13. Segno:\",\"w\":64,\"x\":807,\"y\":139,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QSCSWSCWOL\",\"page\":1,\"spuid\":\"QSCSWSCWOL\",\"tabindex\":69,\"type\":\"Label\",\"w\":111,\"x\":24,\"y\":166,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZKCFWLDCQZ\",\"page\":1,\"spuid\":\"ZKCFWLDCQZ\",\"tabindex\":70,\"type\":\"Label\",\"value\":\"B15. di cui contanti:\",\"w\":104,\"x\":495,\"y\":166,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NHBYSHDKOA\",\"page\":1,\"spuid\":\"NHBYSHDKOA\",\"tabindex\":74,\"type\":\"Label\",\"value\":\"Cambio:\",\"w\":87,\"x\":736,\"y\":166,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_OXJSQGZIYF\",\"h\":31,\"name\":\"box_OXJSQGZIYF\",\"page\":1,\"shrinkable\":true,\"spuid\":\"OXJSQGZIYF\",\"tabindex\":2,\"type\":\"Box\",\"w\":880,\"x\":16,\"y\":14,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Intermediario\",\"disabled\":\"true\",\"h\":21,\"maxlength\":11,\"name\":\"CODINTER\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"ZUFPYFWAFU\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":78,\"x\":138,\"y\":18,\"zone\":\"pag1_1_6_1\",\"zonepath\":\"[1,1,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_CWEAEPHHVV\",\"page\":1,\"spuid\":\"CWEAEPHHVV\",\"tabindex\":50,\"type\":\"Label\",\"value\":\"A01B. Intermediario:\",\"w\":122,\"x\":14,\"y\":22,\"zone\":\"pag1_1_6_1\",\"zonepath\":\"[1,1,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Dipendenza\",\"h\":21,\"maxlength\":6,\"name\":\"CODDIPE\",\"page\":1,\"picker\":true,\"spuid\":\"KXEUVNBTBC\",\"tabindex\":51,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":342,\"y\":18,\"zone\":\"pag1_1_6_1\",\"zonepath\":\"[1,1,6,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Citt\\u00E0 Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":30,\"name\":\"DESCCIT\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"KGOEXUTYVW\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":160,\"x\":504,\"y\":18,\"zone\":\"pag1_1_6_1\",\"zonepath\":\"[1,1,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_CUYLJCWOJN\",\"page\":1,\"spuid\":\"CUYLJCWOJN\",\"tabindex\":75,\"type\":\"Label\",\"value\":\"A11. Dipendenza:\",\"w\":93,\"x\":249,\"y\":22,\"zone\":\"pag1_1_6_1\",\"zonepath\":\"[1,1,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_FFUODKCFLH\",\"page\":1,\"spuid\":\"FFUODKCFLH\",\"tabindex\":76,\"type\":\"Label\",\"value\":\"A12B. Citt\\u00E0:\",\"w\":62,\"x\":443,\"y\":22,\"zone\":\"pag1_1_6_1\",\"zonepath\":\"[1,1,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_TSXEWUJYEC\",\"page\":1,\"spuid\":\"TSXEWUJYEC\",\"tabindex\":77,\"type\":\"Label\",\"value\":\"A12C. Prov.:\",\"w\":66,\"x\":672,\"y\":22,\"zone\":\"pag1_1_6_1\",\"zonepath\":\"[1,1,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_AGREXMHTAA\",\"page\":1,\"spuid\":\"AGREXMHTAA\",\"tabindex\":78,\"type\":\"Label\",\"value\":\"A12A. CAB:\",\"w\":64,\"x\":776,\"y\":22,\"zone\":\"pag1_1_6_1\",\"zonepath\":\"[1,1,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":2,\"name\":\"PROVINCIA\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"SIYKBVMDQU\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":738,\"y\":18,\"zone\":\"pag1_1_6_1\",\"zonepath\":\"[1,1,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAB Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":6,\"name\":\"CODCAB\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"EBKATKTHYT\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":838,\"y\":18,\"zone\":\"pag1_1_6_1\",\"zonepath\":\"[1,1,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_YDQEMCWVGS\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Dati Soggetti\\/Rapporti Coinvolti nell"+"'"+"operazione\",\"h\":171,\"name\":\"box_YDQEMCWVGS\",\"page\":1,\"shrinkable\":true,\"spuid\":\"YDQEMCWVGS\",\"tabindex\":3,\"title_caption\":\"Dati Soggetti\\/Rapporti Coinvolti nell"+"'"+"operazione\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":228,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Rapporto Collegato\",\"h\":20,\"maxlength\":25,\"name\":\"RAPPORTO\",\"page\":1,\"picker\":true,\"spuid\":\"HLPFLQLILN\",\"tabindex\":21,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":162,\"x\":168,\"y\":237,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QPUJWTNJVA\",\"page\":1,\"spuid\":\"QPUJWTNJVA\",\"tabindex\":61,\"type\":\"Label\",\"value\":\"A41. Rapporto Collegato:\",\"w\":148,\"x\":16,\"y\":241,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_CCTRHLCTWU\",\"page\":1,\"spuid\":\"CCTRHLCTWU\",\"tabindex\":80,\"type\":\"Label\",\"w\":432,\"x\":352,\"y\":241,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Cliente Occasionale\",\"h\":20,\"maxlength\":16,\"name\":\"CONNESCLI\",\"page\":1,\"picker\":true,\"spuid\":\"MLQSWPUYXK\",\"tabindex\":22,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":108,\"x\":168,\"y\":264,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GNQVCJVGNQ\",\"page\":1,\"spuid\":\"GNQVCJVGNQ\",\"tabindex\":71,\"type\":\"Label\",\"value\":\"C11. Intest. \\/ Cliente Occ.:\",\"w\":155,\"x\":9,\"y\":268,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_PFRVKZGNLA\",\"page\":1,\"spuid\":\"PFRVKZGNLA\",\"tabindex\":79,\"type\":\"Label\",\"w\":456,\"x\":304,\"y\":268,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Cliente Occasionale\",\"h\":20,\"maxlength\":16,\"name\":\"CONNESOPER\",\"page\":1,\"picker\":true,\"spuid\":\"JHLWBNTKPL\",\"tabindex\":24,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":108,\"x\":168,\"y\":291,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_QRIWNHGABL\",\"page\":1,\"spuid\":\"QRIWNHGABL\",\"tabindex\":72,\"type\":\"Label\",\"w\":148,\"x\":16,\"y\":295,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_WOGEIKUBYX\",\"page\":1,\"spuid\":\"WOGEIKUBYX\",\"tabindex\":81,\"type\":\"Label\",\"w\":480,\"x\":304,\"y\":295,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Legame\",\"h\":20,\"maxlength\":1,\"name\":\"TIPOLEG\",\"page\":1,\"spuid\":\"GRXZUKZAYO\",\"tabindex\":25,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":360,\"x\":168,\"y\":318,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VSWQOBIQXP\",\"page\":1,\"spuid\":\"VSWQOBIQXP\",\"tabindex\":62,\"type\":\"Label\",\"value\":\"A43. Tipo Legame:\",\"w\":132,\"x\":32,\"y\":322,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"h\":21,\"label_text\":\"Soggetto operante utilizza mezzi propri\",\"maxlength\":1,\"name\":\"PAGASOGOP\",\"page\":1,\"spuid\":\"KSFGUUJEFK\",\"tabindex\":26,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":206,\"x\":687,\"y\":318,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Cliente Occasionale\",\"h\":20,\"maxlength\":16,\"name\":\"CONNESBEN\",\"page\":1,\"picker\":true,\"spuid\":\"SYIIMUFSEQ\",\"tabindex\":27,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":108,\"x\":168,\"y\":345,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JTKOMBMPVH\",\"page\":1,\"spuid\":\"JTKOMBMPVH\",\"tabindex\":73,\"type\":\"Label\",\"value\":\"C31. Controparte Bonifico:\",\"w\":156,\"x\":8,\"y\":349,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_XHXIVQRISQ\",\"page\":1,\"spuid\":\"XHXIVQRISQ\",\"tabindex\":82,\"type\":\"Label\",\"w\":480,\"x\":304,\"y\":349,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":16,\"name\":\"CONNALTRO\",\"page\":1,\"picker\":true,\"spuid\":\"JVSBAIMQUS\",\"tabindex\":28,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":108,\"x\":168,\"y\":372,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XNPBVJJOEN\",\"page\":1,\"spuid\":\"XNPBVJJOEN\",\"tabindex\":93,\"type\":\"Label\",\"w\":156,\"x\":8,\"y\":376,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_SUDZQYBKAE\",\"page\":1,\"spuid\":\"SUDZQYBKAE\",\"tabindex\":94,\"type\":\"Label\",\"w\":480,\"x\":304,\"y\":376,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Visualizza i dati del cliente relativi all"+"'"+"operazione\",\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_KJAPTMTYKV\",\"page\":1,\"spuid\":\"KJAPTMTYKV\",\"src\":\"..\\/images\\/search_adm.gif\",\"tabindex\":92,\"type\":\"Image\",\"w\":20,\"x\":873,\"y\":262,\"zone\":\"pag1_2_8\",\"zonepath\":\"[1,2,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_YSUXVYPEKQ\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Dati ControParte\",\"h\":90,\"name\":\"box_YSUXVYPEKQ\",\"page\":1,\"shrinkable\":true,\"spuid\":\"YSUXVYPEKQ\",\"tabindex\":4,\"title_caption\":\"Dati ControParte\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":400,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"F11. Denominazione Controparte\",\"h\":20,\"maxlength\":70,\"name\":\"C_RAG\",\"page\":1,\"spuid\":\"AWPNTOJIRR\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":432,\"x\":169,\"y\":408,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PFEQRACAUA\",\"page\":1,\"spuid\":\"PFEQRACAUA\",\"tabindex\":164,\"type\":\"Label\",\"value\":\"F11. Denominazione:\",\"w\":149,\"x\":17,\"y\":412,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"F14B. Comune Controparte\",\"h\":20,\"maxlength\":30,\"name\":\"C_CTA\",\"page\":1,\"picker\":true,\"spuid\":\"ODAYKSRECA\",\"tabindex\":30,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":230,\"x\":169,\"y\":435,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"F14C. Provincia Controparte\",\"h\":20,\"maxlength\":2,\"name\":\"C_PRV\",\"page\":1,\"spuid\":\"NOTZPDMYIA\",\"tabindex\":31,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":489,\"y\":435,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"F16. CAP Controparte\",\"h\":20,\"maxlength\":5,\"name\":\"C_CAP\",\"page\":1,\"spuid\":\"RDAVOEETJG\",\"tabindex\":32,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":601,\"y\":435,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"F14A. CAB Controparte\",\"h\":20,\"maxlength\":6,\"name\":\"C_CAB\",\"page\":1,\"spuid\":\"BOTAJBWHHY\",\"tabindex\":33,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":737,\"y\":435,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SBJQIAQUCN\",\"page\":1,\"spuid\":\"SBJQIAQUCN\",\"tabindex\":163,\"type\":\"Label\",\"value\":\"F14C. Prov.:\",\"w\":70,\"x\":417,\"y\":439,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GDOCAGKROT\",\"page\":1,\"spuid\":\"GDOCAGKROT\",\"tabindex\":167,\"type\":\"Label\",\"value\":\"F16. CAP:\",\"w\":54,\"x\":545,\"y\":439,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WHMXTGXWGC\",\"page\":1,\"spuid\":\"WHMXTGXWGC\",\"tabindex\":168,\"type\":\"Label\",\"value\":\"F14A. CAB:\",\"w\":63,\"x\":673,\"y\":439,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XPSQTBKQQZ\",\"page\":1,\"spuid\":\"XPSQTBKQQZ\",\"tabindex\":169,\"type\":\"Label\",\"value\":\"F14B. Comune:\",\"w\":133,\"x\":33,\"y\":439,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"F15. Indirizzo Controparte\",\"h\":20,\"maxlength\":35,\"name\":\"C_IND\",\"page\":1,\"spuid\":\"VYLHWTRQNX\",\"tabindex\":34,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":222,\"x\":169,\"y\":462,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"F13. Stato Controparte\",\"h\":20,\"maxlength\":3,\"name\":\"C_STA\",\"page\":1,\"picker\":true,\"spuid\":\"YVIKEGPYPM\",\"tabindex\":35,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":489,\"y\":462,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RZBLEGCFJJ\",\"page\":1,\"spuid\":\"RZBLEGCFJJ\",\"tabindex\":165,\"type\":\"Label\",\"value\":\"F13. Stato:\",\"w\":76,\"x\":411,\"y\":466,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TWTXGZJTAR\",\"page\":1,\"spuid\":\"TWTXGZJTAR\",\"tabindex\":166,\"type\":\"Label\",\"value\":\"F15. Indirizzo:\",\"w\":149,\"x\":17,\"y\":466,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_ESVLUSNYWB\",\"page\":1,\"spuid\":\"ESVLUSNYWB\",\"tabindex\":170,\"type\":\"Label\",\"w\":251,\"x\":542,\"y\":466,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_VNNYTOBGNA\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Dati eventuale Intermediario ControParte\",\"h\":171,\"name\":\"box_VNNYTOBGNA\",\"page\":1,\"shrinkable\":true,\"spuid\":\"VNNYTOBGNA\",\"tabindex\":5,\"title_caption\":\"Dati eventuale Intermediario ControParte\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":491,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"A31A. Tipo Intermediario C\\/Parte\",\"h\":20,\"maxlength\":2,\"name\":\"TIPOINT2\",\"page\":1,\"spuid\":\"BUGJZOCZYH\",\"tabindex\":36,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":720,\"x\":168,\"y\":500,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XQTZXXRKAL\",\"page\":1,\"spuid\":\"XQTZXXRKAL\",\"tabindex\":55,\"type\":\"Label\",\"value\":\"A31A. Tipo Intermediario:\",\"w\":136,\"x\":28,\"y\":504,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Intermediario C\\/Parte\",\"h\":20,\"maxlength\":11,\"name\":\"CODINT2\",\"page\":1,\"picker\":true,\"spuid\":\"NUZRBZHLLM\",\"tabindex\":37,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":94,\"x\":168,\"y\":527,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WVEGMKFSFB\",\"page\":1,\"spuid\":\"WVEGMKFSFB\",\"tabindex\":56,\"type\":\"Label\",\"value\":\"A31B. Intermediario C\\/Parte:\",\"w\":154,\"x\":10,\"y\":531,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"A34. Denominazione Intermediario C\\/Parte\",\"h\":20,\"maxlength\":50,\"name\":\"DESCINTER\",\"page\":1,\"spuid\":\"ABKVYRXWAV\",\"tabindex\":38,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":328,\"x\":560,\"y\":527,\"zone\":\"pag1_4_3\",\"zonepath\":\"[1,4,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XUVZBTPJNH\",\"page\":1,\"spuid\":\"XUVZBTPJNH\",\"tabindex\":100,\"type\":\"Label\",\"value\":\"A34. Denominazione:\",\"w\":112,\"x\":449,\"y\":531,\"zone\":\"pag1_4_3\",\"zonepath\":\"[1,4,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A32. Stato Intermediario C\\/Parte\",\"h\":20,\"maxlength\":3,\"name\":\"PAESE\",\"page\":1,\"picker\":true,\"spuid\":\"GYOQKYEVYP\",\"tabindex\":39,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":168,\"y\":554,\"zone\":\"pag1_4_4\",\"zonepath\":\"[1,4,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DDPYWTWDBG\",\"page\":1,\"spuid\":\"DDPYWTWDBG\",\"tabindex\":57,\"type\":\"Label\",\"value\":\"A32. Stato UIF:\",\"w\":83,\"x\":82,\"y\":558,\"zone\":\"pag1_4_4\",\"zonepath\":\"[1,4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_ZSZJMHTNLV\",\"page\":1,\"spuid\":\"ZSZJMHTNLV\",\"tabindex\":83,\"type\":\"Label\",\"w\":328,\"x\":224,\"y\":558,\"zone\":\"pag1_4_4\",\"zonepath\":\"[1,4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":25,\"name\":\"C_RAPPORTO\",\"page\":1,\"spuid\":\"YBNJCVPDUM\",\"tabindex\":40,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":168,\"x\":720,\"y\":554,\"zone\":\"pag1_4_5\",\"zonepath\":\"[1,4,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RUIGDGZVBM\",\"page\":1,\"spuid\":\"RUIGDGZVBM\",\"tabindex\":95,\"type\":\"Label\",\"value\":\"Conto:\",\"w\":84,\"x\":634,\"y\":558,\"zone\":\"pag1_4_5\",\"zonepath\":\"[1,4,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A33A. CAB Intermediario C\\/Parte\",\"h\":20,\"maxlength\":6,\"name\":\"CODCAB2\",\"page\":1,\"picker\":true,\"spuid\":\"LCQKOYRNRT\",\"tabindex\":41,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":168,\"y\":581,\"zone\":\"pag1_4_6\",\"zonepath\":\"[1,4,6]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_YMRSJURZMI\",\"page\":1,\"spuid\":\"YMRSJURZMI\",\"tabindex\":60,\"type\":\"Label\",\"value\":\"A33A. CAB \\/ Comune:\",\"w\":124,\"x\":40,\"y\":585,\"zone\":\"pag1_4_6\",\"zonepath\":\"[1,4,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_FAWPPBAAYI\",\"page\":1,\"spuid\":\"FAWPPBAAYI\",\"tabindex\":99,\"type\":\"Label\",\"w\":400,\"x\":248,\"y\":585,\"zone\":\"pag1_4_6\",\"zonepath\":\"[1,4,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"A33C. Provincia Intermediario C\\/Parte\",\"h\":20,\"maxlength\":2,\"name\":\"PROV2\",\"page\":1,\"spuid\":\"QQJJGKCSOY\",\"tabindex\":42,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":856,\"y\":608,\"zone\":\"pag1_4_7\",\"zonepath\":\"[1,4,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BKCOIKPFLJ\",\"page\":1,\"spuid\":\"BKCOIKPFLJ\",\"tabindex\":59,\"type\":\"Label\",\"value\":\"A33C. Provincia:\",\"w\":88,\"x\":766,\"y\":612,\"zone\":\"pag1_4_7\",\"zonepath\":\"[1,4,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"A33B. Comune Intermediario C\\/Parte\",\"h\":20,\"maxlength\":30,\"name\":\"DESC2\",\"page\":1,\"spuid\":\"WUSGSRXDMA\",\"tabindex\":43,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":280,\"x\":168,\"y\":608,\"zone\":\"pag1_4_8\",\"zonepath\":\"[1,4,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WSMVZRJXYS\",\"page\":1,\"spuid\":\"WSMVZRJXYS\",\"tabindex\":58,\"type\":\"Label\",\"value\":\"A33B. Comune per esteso:\",\"w\":141,\"x\":23,\"y\":612,\"zone\":\"pag1_4_8\",\"zonepath\":\"[1,4,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":69,\"name\":\"ZCPARTE\",\"page\":1,\"spuid\":\"EPRSQUBPGF\",\"tabindex\":44,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":426,\"x\":168,\"y\":635,\"zone\":\"pag1_4_9\",\"zonepath\":\"[1,4,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CARVDZRFVD\",\"page\":1,\"spuid\":\"CARVDZRFVD\",\"tabindex\":89,\"type\":\"Label\",\"value\":\"Nome per Esteso:\",\"w\":119,\"x\":48,\"y\":637,\"zone\":\"pag1_4_9\",\"zonepath\":\"[1,4,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":18,\"name\":\"label_LPKMZXAILT\",\"page\":1,\"spuid\":\"LPKMZXAILT\",\"tabindex\":85,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"OPERAZIONE CANCELLATA\",\"w\":192,\"x\":704,\"y\":636,\"zone\":\"pag1_4_10\",\"zonepath\":\"[1,4,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":18,\"name\":\"label_JTSYWOZZQD\",\"page\":1,\"spuid\":\"JTSYWOZZQD\",\"tabindex\":86,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"COPIA OPERAZIONE MODIFICATA\",\"w\":192,\"x\":704,\"y\":636,\"zone\":\"pag1_4_11\",\"zonepath\":\"[1,4,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_ANGGVVFTIZ\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Dati Cambiavalute\\/SV\",\"h\":37,\"name\":\"box_ANGGVVFTIZ\",\"page\":1,\"shrinkable\":true,\"spuid\":\"ANGGVVFTIZ\",\"tabindex\":172,\"title_caption\":\"Dati Cambiavalute\\/SV\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":190,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Importo in Entrata\",\"h\":20,\"maxlength\":16,\"name\":\"IMPIN\",\"page\":1,\"spuid\":\"YXAKYHSWPW\",\"tabindex\":173,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":136,\"y\":200,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SIPPFUEECW\",\"page\":1,\"spuid\":\"SIPPFUEECW\",\"tabindex\":174,\"type\":\"Label\",\"value\":\"Importo in Entrata:\",\"w\":101,\"x\":35,\"y\":204,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Importo in Uscita\",\"h\":20,\"maxlength\":16,\"name\":\"IMPOUT\",\"page\":1,\"spuid\":\"DPCGXWDECV\",\"tabindex\":175,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":600,\"y\":200,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZLLARVPZIO\",\"page\":1,\"spuid\":\"ZLLARVPZIO\",\"tabindex\":176,\"type\":\"Label\",\"w\":296,\"x\":304,\"y\":204,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_HNGGJVVCNB\",\"h\":45,\"name\":\"box_HNGGJVVCNB\",\"page\":2,\"shrinkable\":true,\"spuid\":\"HNGGJVVCNB\",\"tabindex\":10,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":9,\"zone\":\"pag2_1\",\"zonepath\":\"[2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_EUBBNRKXRL\",\"h\":31,\"name\":\"box_EUBBNRKXRL\",\"page\":2,\"shrinkable\":true,\"spuid\":\"EUBBNRKXRL\",\"tabindex\":11,\"type\":\"Box\",\"w\":880,\"x\":16,\"y\":16,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_YPYOQUQUZO\",\"page\":2,\"spuid\":\"YPYOQUQUZO\",\"tabindex\":12,\"type\":\"Label\",\"w\":204,\"x\":20,\"y\":23,\"zone\":\"pag2_1_1_1\",\"zonepath\":\"[2,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_FSLWEQSSNU\",\"page\":2,\"spuid\":\"FSLWEQSSNU\",\"tabindex\":13,\"type\":\"Label\",\"w\":167,\"x\":241,\"y\":23,\"zone\":\"pag2_1_1_1\",\"zonepath\":\"[2,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_UGBWSZCQRL\",\"page\":2,\"spuid\":\"UGBWSZCQRL\",\"tabindex\":14,\"type\":\"Label\",\"w\":230,\"x\":422,\"y\":23,\"zone\":\"pag2_1_1_1\",\"zonepath\":\"[2,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_HJOXUPJMAI\",\"page\":2,\"spuid\":\"HJOXUPJMAI\",\"tabindex\":15,\"type\":\"Label\",\"w\":93,\"x\":667,\"y\":23,\"zone\":\"pag2_1_1_1\",\"zonepath\":\"[2,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_PYRWIMYTNP\",\"page\":2,\"spuid\":\"PYRWIMYTNP\",\"tabindex\":16,\"type\":\"Label\",\"w\":116,\"x\":770,\"y\":23,\"zone\":\"pag2_1_1_1\",\"zonepath\":\"[2,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Esecutori\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"iif(w_DATAOPE < CharToDate("+"'"+"20140101"+"'"+"),"+"'"+"Soggetti Operanti Conto Terzi"+"'"+","+"'"+"Esecutori"+"'"+")\",\"h\":178,\"name\":\"Esecutori\",\"page\":2,\"shrinkable\":true,\"spuid\":\"ZYUUSRMPQG\",\"tabindex\":1,\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":55,\"zone\":\"pag2_2\",\"zonepath\":\"[2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":162,\"name\":\"ardt_sogopeprov\",\"page\":2,\"spuid\":\"TQDGESLQVD\",\"tabindex\":2,\"type\":\"Iframe\",\"w\":661,\"x\":126,\"y\":62,\"zone\":\"pag2_2_1\",\"zonepath\":\"[2,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"AGE\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Dati Per Agenzia Entrate (Campi modificabili liberamente)\",\"h\":410,\"name\":\"AGE\",\"page\":2,\"shrinkable\":true,\"spuid\":\"EOKCAXCLZO\",\"tabindex\":17,\"title_caption\":\"Dati Per Agenzia Entrate (Campi modificabili liberamente)\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":234,\"zone\":\"pag2_3\",\"zonepath\":\"[2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":3,\"name\":\"OPERAG\",\"page\":2,\"picker\":true,\"spuid\":\"QEFXECTWSF\",\"tabindex\":18,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":38,\"x\":160,\"y\":269,\"zone\":\"pag2_3_1\",\"zonepath\":\"[2,3,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZEYLNLLVTD\",\"page\":2,\"spuid\":\"ZEYLNLLVTD\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"Tipo Operazione:\",\"w\":82,\"x\":76,\"y\":273,\"zone\":\"pag2_3_1\",\"zonepath\":\"[2,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_ILIJSVUNTQ\",\"page\":2,\"spuid\":\"ILIJSVUNTQ\",\"tabindex\":20,\"type\":\"Label\",\"w\":560,\"x\":224,\"y\":272,\"zone\":\"pag2_3_1\",\"zonepath\":\"[2,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"h\":21,\"label_text\":\"Non inviare agenzia Entrate\",\"maxlength\":2,\"name\":\"NOPROT\",\"page\":2,\"spuid\":\"LEHLEQRJPH\",\"tabindex\":21,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":168,\"x\":616,\"y\":241,\"zone\":\"pag2_3_2\",\"zonepath\":\"[2,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":30,\"name\":\"RESPINS\",\"page\":2,\"spuid\":\"VMRTFBBQHL\",\"tabindex\":22,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":208,\"x\":160,\"y\":296,\"zone\":\"pag2_3_3\",\"zonepath\":\"[2,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AMHSICIBVW\",\"page\":2,\"spuid\":\"AMHSICIBVW\",\"tabindex\":23,\"type\":\"Label\",\"value\":\"Responsabile Inserimento:\",\"w\":127,\"x\":31,\"y\":300,\"zone\":\"pag2_3_3\",\"zonepath\":\"[2,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":30,\"name\":\"INFORM\",\"page\":2,\"spuid\":\"KDWBJNGUTK\",\"tabindex\":24,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":704,\"y\":296,\"zone\":\"pag2_3_4\",\"zonepath\":\"[2,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PZUBJPCOXA\",\"page\":2,\"spuid\":\"PZUBJPCOXA\",\"tabindex\":25,\"type\":\"Label\",\"value\":\"Annotazioni varie:\",\"w\":92,\"x\":608,\"y\":300,\"zone\":\"pag2_3_4\",\"zonepath\":\"[2,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":50,\"name\":\"NATURA\",\"page\":2,\"spuid\":\"VSHUPFYWOC\",\"tabindex\":27,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":160,\"y\":323,\"zone\":\"pag2_3_5\",\"zonepath\":\"[2,3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BVGYBYGMJB\",\"page\":2,\"spuid\":\"BVGYBYGMJB\",\"tabindex\":33,\"type\":\"Label\",\"value\":\"Natura:\",\"w\":124,\"x\":32,\"y\":327,\"zone\":\"pag2_3_5\",\"zonepath\":\"[2,3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_PLAWSVGZSR\",\"page\":2,\"spuid\":\"PLAWSVGZSR\",\"tabindex\":40,\"type\":\"Label\",\"value\":\"Es. Natura = Mutuo; Scopo = Acquisto beni di consumo\",\"w\":265,\"x\":496,\"y\":327,\"zone\":\"pag2_3_5\",\"zonepath\":\"[2,3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":50,\"name\":\"SCOPO\",\"page\":2,\"spuid\":\"VASVGQZJGP\",\"tabindex\":28,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":160,\"y\":350,\"zone\":\"pag2_3_6\",\"zonepath\":\"[2,3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EWATRAIADP\",\"page\":2,\"spuid\":\"EWATRAIADP\",\"tabindex\":34,\"type\":\"Label\",\"value\":\"Scopo:\",\"w\":124,\"x\":32,\"y\":354,\"zone\":\"pag2_3_6\",\"zonepath\":\"[2,3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_UOJWCVBOTW\",\"page\":2,\"spuid\":\"UOJWCVBOTW\",\"tabindex\":41,\"type\":\"Label\",\"value\":\"Valutazione: da 0 a 20 Regolare - da 20 a 30 Attenzione - sopra 30 Anomala\",\"w\":401,\"x\":496,\"y\":354,\"zone\":\"pag2_3_6\",\"zonepath\":\"[2,3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"AREAGEO\",\"page\":2,\"picker\":true,\"spuid\":\"QJSTZIPOQB\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":46,\"x\":160,\"y\":466,\"zone\":\"pag2_3_7\",\"zonepath\":\"[2,3,7]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NAVNOGNZNE\",\"page\":2,\"spuid\":\"NAVNOGNZNE\",\"tabindex\":35,\"type\":\"Label\",\"value\":\"Area Geografica:\",\"w\":124,\"x\":32,\"y\":470,\"zone\":\"pag2_3_7\",\"zonepath\":\"[2,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZUVXJIZOSF\",\"page\":2,\"spuid\":\"ZUVXJIZOSF\",\"tabindex\":47,\"type\":\"Label\",\"value\":\"Frequenza:\",\"w\":55,\"x\":101,\"y\":422,\"zone\":\"pag2_3_7\",\"zonepath\":\"[2,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LXNMWSOUMF\",\"page\":2,\"spuid\":\"LXNMWSOUMF\",\"tabindex\":48,\"type\":\"Label\",\"value\":\"Importo:\",\"w\":55,\"x\":101,\"y\":446,\"zone\":\"pag2_3_7\",\"zonepath\":\"[2,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_CMKJDFEFFI\",\"page\":2,\"spuid\":\"CMKJDFEFFI\",\"tabindex\":49,\"type\":\"Label\",\"w\":416,\"x\":232,\"y\":470,\"zone\":\"pag2_3_7\",\"zonepath\":\"[2,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_NWFPTCEPRA\",\"page\":2,\"spuid\":\"NWFPTCEPRA\",\"tabindex\":53,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"TIPOLOGIA RISCHIO\",\"w\":440,\"x\":24,\"y\":398,\"zone\":\"pag2_3_7\",\"zonepath\":\"[2,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"DURAT\",\"page\":2,\"picker\":true,\"spuid\":\"CKJQULDXKW\",\"tabindex\":55,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":46,\"x\":160,\"y\":418,\"zone\":\"pag2_3_7\",\"zonepath\":\"[2,3,7]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"AMMONT\",\"page\":2,\"picker\":true,\"spuid\":\"SXTYCPHBIM\",\"tabindex\":56,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":46,\"x\":160,\"y\":442,\"zone\":\"pag2_3_7\",\"zonepath\":\"[2,3,7]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_BCFLBBQSRN\",\"page\":2,\"spuid\":\"BCFLBBQSRN\",\"tabindex\":57,\"type\":\"Label\",\"w\":416,\"x\":232,\"y\":446,\"zone\":\"pag2_3_7\",\"zonepath\":\"[2,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_QEXJCFPJBM\",\"page\":2,\"spuid\":\"QEXJCFPJBM\",\"tabindex\":58,\"type\":\"Label\",\"w\":416,\"x\":232,\"y\":422,\"zone\":\"pag2_3_7\",\"zonepath\":\"[2,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"MODSVOL\",\"page\":2,\"picker\":true,\"spuid\":\"SFFFOYOWNH\",\"tabindex\":30,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":46,\"x\":160,\"y\":490,\"zone\":\"pag2_3_8\",\"zonepath\":\"[2,3,8]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LHTXLTQYIK\",\"page\":2,\"spuid\":\"LHTXLTQYIK\",\"tabindex\":37,\"type\":\"Label\",\"value\":\"Svol. Instaurazione Operaz.:\",\"w\":139,\"x\":17,\"y\":494,\"zone\":\"pag2_3_8\",\"zonepath\":\"[2,3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_DXOTWSGBKN\",\"page\":2,\"spuid\":\"DXOTWSGBKN\",\"tabindex\":50,\"type\":\"Label\",\"w\":416,\"x\":232,\"y\":494,\"zone\":\"pag2_3_8\",\"zonepath\":\"[2,3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"RAGIO\",\"page\":2,\"picker\":true,\"spuid\":\"NOBMPHKVTX\",\"tabindex\":31,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":46,\"x\":160,\"y\":514,\"zone\":\"pag2_3_9\",\"zonepath\":\"[2,3,9]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HGXSBHTFKF\",\"page\":2,\"spuid\":\"HGXSBHTFKF\",\"tabindex\":38,\"type\":\"Label\",\"value\":\"Ragionevolezza Operazione:\",\"w\":137,\"x\":19,\"y\":518,\"zone\":\"pag2_3_9\",\"zonepath\":\"[2,3,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_FXHEISJAJE\",\"page\":2,\"spuid\":\"FXHEISJAJE\",\"tabindex\":51,\"type\":\"Label\",\"w\":416,\"x\":232,\"y\":518,\"zone\":\"pag2_3_9\",\"zonepath\":\"[2,3,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":3,\"name\":\"TIPO\",\"page\":2,\"picker\":true,\"spuid\":\"DJOWYRMDDC\",\"tabindex\":32,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":46,\"x\":160,\"y\":538,\"zone\":\"pag2_3_10\",\"zonepath\":\"[2,3,10]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OKFGBGYVWD\",\"page\":2,\"spuid\":\"OKFGBGYVWD\",\"tabindex\":39,\"type\":\"Label\",\"value\":\"Tipo di rischio:\",\"w\":129,\"x\":27,\"y\":542,\"zone\":\"pag2_3_10\",\"zonepath\":\"[2,3,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_GHHOMNKDDQ\",\"page\":2,\"spuid\":\"GHHOMNKDDQ\",\"tabindex\":52,\"type\":\"Label\",\"w\":416,\"x\":232,\"y\":542,\"zone\":\"pag2_3_10\",\"zonepath\":\"[2,3,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RAREA\",\"page\":2,\"spuid\":\"UDAYHICPVB\",\"tabindex\":36,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":856,\"y\":463,\"zone\":\"pag2_3_11\",\"zonepath\":\"[2,3,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RCOMP\",\"page\":2,\"spuid\":\"ETALZDRBSO\",\"tabindex\":42,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":856,\"y\":487,\"zone\":\"pag2_3_12\",\"zonepath\":\"[2,3,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RRAGIO\",\"page\":2,\"spuid\":\"QBTVZDKLCO\",\"tabindex\":43,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":856,\"y\":511,\"zone\":\"pag2_3_13\",\"zonepath\":\"[2,3,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RTIPO\",\"page\":2,\"spuid\":\"RUWEXWJASG\",\"tabindex\":44,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":856,\"y\":535,\"zone\":\"pag2_3_14\",\"zonepath\":\"[2,3,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_HBAROSDSIX\",\"page\":2,\"spuid\":\"HBAROSDSIX\",\"tabindex\":26,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"TIPOLOGIA E VALUTAZIONE RISCHIO (IIIa DIRETTIVA)\",\"w\":896,\"x\":8,\"y\":377,\"zone\":\"pag2_3_15\",\"zonepath\":\"[2,3,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RFREQ\",\"page\":2,\"spuid\":\"MXYTQLATHC\",\"tabindex\":45,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":856,\"y\":415,\"zone\":\"pag2_3_16\",\"zonepath\":\"[2,3,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_NFLJJHXTKY\",\"page\":2,\"spuid\":\"NFLJJHXTKY\",\"tabindex\":54,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"VALUTAZIONE\",\"w\":120,\"x\":776,\"y\":395,\"zone\":\"pag2_3_16\",\"zonepath\":\"[2,3,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RIMP\",\"page\":2,\"spuid\":\"KBIUAXUDXA\",\"tabindex\":46,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":856,\"y\":439,\"zone\":\"pag2_3_17\",\"zonepath\":\"[2,3,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_CPZDORVHLG\",\"page\":2,\"spuid\":\"CPZDORVHLG\",\"tabindex\":59,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"MITIGAZIONE RISCHIO\",\"w\":896,\"x\":8,\"y\":572,\"zone\":\"pag2_3_18\",\"zonepath\":\"[2,3,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Mitigazione (+\\/-)\",\"h\":20,\"maxlength\":5,\"name\":\"MITIG\",\"page\":2,\"spuid\":\"DOXBACRWUU\",\"tabindex\":60,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":160,\"y\":590,\"zone\":\"pag2_3_19\",\"zonepath\":\"[2,3,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VCBMHLXJMD\",\"page\":2,\"spuid\":\"VCBMHLXJMD\",\"tabindex\":61,\"type\":\"Label\",\"value\":\"Mitigazione (+\\/-):\",\"w\":128,\"x\":32,\"y\":594,\"zone\":\"pag2_3_19\",\"zonepath\":\"[2,3,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_NKPWKMDXUR\",\"page\":2,\"spuid\":\"NKPWKMDXUR\",\"tabindex\":64,\"type\":\"Label\",\"value\":\"%\",\"w\":22,\"x\":203,\"y\":594,\"zone\":\"pag2_3_19\",\"zonepath\":\"[2,3,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Documentazione Mitigazione\",\"h\":20,\"maxlength\":100,\"name\":\"MITGDOC\",\"page\":2,\"spuid\":\"OXGBDTWKSX\",\"tabindex\":62,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":160,\"y\":614,\"zone\":\"pag2_3_20\",\"zonepath\":\"[2,3,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PKJNNGBWFM\",\"page\":2,\"spuid\":\"PKJNNGBWFM\",\"tabindex\":63,\"type\":\"Label\",\"value\":\"Documentazione Mitigazione:\",\"w\":152,\"x\":8,\"y\":618,\"zone\":\"pag2_3_20\",\"zonepath\":\"[2,3,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_ae_operazboBO BO,ServletStatus status) {
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
     "<script src='armt_ae_operazbo?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_ae_operazbo_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_ae_operazbo_edit.js'>" +
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
      status.out.println("w_DATAOPE=a[0];");
      status.out.println("w_CDATOPE=a[1];");
      status.out.println("w_DATAREG=a[2];");
      status.out.println("w_FLAGFRAZ=a[3];");
      status.out.println("w_COLLEG=a[4];");
      status.out.println("w_TIPOOPRAP=a[5];");
      status.out.println("w_CODANA=a[6];");
      status.out.println("w_CODVOC=a[7];");
      status.out.println("w_FLAGLIRE=a[8];");
      status.out.println("w_VALUTA=a[9];");
      status.out.println("w_FLAGCONT=a[10];");
      status.out.println("w_CAMBIO=a[11];");
      status.out.println("w_RAPPORTO=a[12];");
      status.out.println("w_CONNESCLI=a[13];");
      status.out.println("w_CONNESOPER=a[14];");
      status.out.println("w_TIPOLEG=a[15];");
      status.out.println("w_PAGASOGOP=a[16];");
      status.out.println("w_CONNESBEN=a[17];");
      status.out.println("w_CONNALTRO=a[18];");
      status.out.println("w_C_RAG=a[19];");
      status.out.println("w_C_CTA=a[20];");
      status.out.println("w_C_PRV=a[21];");
      status.out.println("w_C_CAP=a[22];");
      status.out.println("w_C_CAB=a[23];");
      status.out.println("w_C_IND=a[24];");
      status.out.println("w_C_STA=a[25];");
      status.out.println("w_TIPOINT2=a[26];");
      status.out.println("w_CODINT2=a[27];");
      status.out.println("w_DESCINTER=a[28];");
      status.out.println("w_PAESE=a[29];");
      status.out.println("w_C_RAPPORTO=a[30];");
      status.out.println("w_CODCAB2=a[31];");
      status.out.println("w_PROV2=a[32];");
      status.out.println("w_DESC2=a[33];");
      status.out.println("w_ZCPARTE=a[34];");
      status.out.println("w_IDBASE=a[35];");
      status.out.println("op_IDBASE=a[36];");
      status.out.println("w_NUMPROG=a[37];");
      status.out.println("op_NUMPROG=a[38];");
      status.out.println("w_CODINTER=a[39];");
      status.out.println("w_CODDIPE=a[40];");
      status.out.println("w_DESCCIT=a[41];");
      status.out.println("w_SEGNO=a[42];");
      status.out.println("w_DATARETT=a[43];");
      status.out.println("w_PROVINCIA=a[44];");
      status.out.println("w_CODCAB=a[45];");
      status.out.println("w_TOTLIRE=a[46];");
      status.out.println("w_TOTCONT=a[47];");
      status.out.println("w_TIPOINF=a[48];");
      status.out.println("w_IDEREG=a[49];");
      status.out.println("w_FLAGRAP=a[50];");
      status.out.println("w_OPRAP=a[51];");
      status.out.println("w_OPERAZMOD=a[52];");
      status.out.println("w_RAPPORTBEN=a[53];");
      status.out.println("w_OPERATORE=a[54];");
      status.out.println("w_AUTOM=a[55];");
      status.out.println("w_FLAGRAP2=a[56];");
      status.out.println("w_STATOREG=a[57];");
      status.out.println("w_PRGIMPOPE=a[58];");
      status.out.println("op_PRGIMPOPE=a[59];");
      status.out.println("w_CDATAOPE=a[60];");
      status.out.println("w_CONNESDOC=a[61];");
      status.out.println("w_CDATREG=a[62];");
      status.out.println("w_ANNOOPE=a[63];");
      status.out.println("w_IMPIN=a[64];");
      status.out.println("w_IMPOUT=a[65];");
      status.out.println("w_OPERAG=a[66];");
      status.out.println("w_NOPROT=a[67];");
      status.out.println("w_RESPINS=a[68];");
      status.out.println("w_INFORM=a[69];");
      status.out.println("w_NATURA=a[70];");
      status.out.println("w_SCOPO=a[71];");
      status.out.println("w_AREAGEO=a[72];");
      status.out.println("w_MODSVOL=a[73];");
      status.out.println("w_RAGIO=a[74];");
      status.out.println("w_TIPO=a[75];");
      status.out.println("w_RAREA=a[76];");
      status.out.println("w_RCOMP=a[77];");
      status.out.println("w_RRAGIO=a[78];");
      status.out.println("w_RTIPO=a[79];");
      status.out.println("w_RFREQ=a[80];");
      status.out.println("w_RIMP=a[81];");
      status.out.println("w_DURAT=a[82];");
      status.out.println("w_AMMONT=a[83];");
      status.out.println("w_MITIG=a[84];");
      status.out.println("w_MITGDOC=a[85];");
      status.out.println("w_xdescmodsvo=a[86];");
      status.out.println("w_xdescareag=a[87];");
      status.out.println("w_xdescplauso=a[88];");
      status.out.println("w_xdesctipor=a[89];");
      status.out.println("w_xdescopeage=a[90];");
      status.out.println("w_xdescfreq=a[91];");
      status.out.println("w_xdescammo=a[92];");
      status.out.println("w_appolire=a[93];");
      status.out.println("w_xTOTLIRE=a[94];");
      status.out.println("w_xTOTCONT=a[95];");
      status.out.println("w_filtro=a[96];");
      status.out.println("w_tipope=a[97];");
      status.out.println("w_gIntemediario=a[98];");
      status.out.println("w_xdes1=a[99];");
      status.out.println("w_desccauana=a[100];");
      status.out.println("w_xdesccausin=a[101];");
      status.out.println("w_descdiv=a[102];");
      status.out.println("w_xragsocper=a[103];");
      status.out.println("w_xdescrap=a[104];");
      status.out.println("w_xragsocct=a[105];");
      status.out.println("w_xragsocben=a[106];");
      status.out.println("w_xdestipleg=a[107];");
      status.out.println("w_xragint2=a[108];");
      status.out.println("w_xdescpaese2=a[109];");
      status.out.println("w_datpaseuro=a[110];");
      status.out.println("w_xDescDipe=a[111];");
      status.out.println("w_sEdit=a[112];");
      status.out.println("w_gChkDate=a[113];");
      status.out.println("w_errmsg=a[114];");
      status.out.println("w_test=a[115];");
      status.out.println("w_valflg2=a[116];");
      status.out.println("w_gTipInter=a[117];");
      status.out.println("w_gSblocco=a[118];");
      status.out.println("w_xcodfisc=a[119];");
      status.out.println("w_dataoggi=a[120];");
      status.out.println("w_stringaflagrap2=a[121];");
      status.out.println("w_gDataVaria=a[122];");
      status.out.println("w_gStatus=a[123];");
      status.out.println("w_CITINT=a[124];");
      status.out.println("w_CITDIP=a[125];");
      status.out.println("w_PROVDIP=a[126];");
      status.out.println("w_CABDIP=a[127];");
      status.out.println("w_PROVINT=a[128];");
      status.out.println("w_CABINT=a[129];");
      status.out.println("w_gFlgDoc=a[130];");
      status.out.println("w_xtiporap=a[131];");
      status.out.println("w_dessta=a[132];");
      status.out.println("w_xragsocalt=a[133];");
      status.out.println("w_xdciticon=a[134];");
      status.out.println("w_gFlgWU=a[135];");
      status.out.println("w_DATAVALI=a[136];");
      status.out.println("w_DATARILASC=a[137];");
      status.out.println("w_gFlgDTP=a[138];");
      status.out.println("w_xFLGITAEST=a[139];");
      status.out.println("op_codazi=a[140];");
      status.out.println("o_YSUXVYPEKQ_expand=null;");
      status.out.println("o_VNNYTOBGNA_expand=null;");
      status.out.println("m_cWv_ardt_sogopeprov=a[141];");
      status.out.println("if (Gt(a.length,142)) {");
      status.out.println("m_cErrorInChild='';");
      status.out.println("}");
      status.out.println("if (Gt(a.length,142)) {");
      status.out.println("o_DATAOPE=w_DATAOPE;");
      status.out.println("o_CDATOPE=w_CDATOPE;");
      status.out.println("o_FLAGFRAZ=w_FLAGFRAZ;");
      status.out.println("o_TIPOOPRAP=w_TIPOOPRAP;");
      status.out.println("o_CODVOC=w_CODVOC;;");
      status.out.println("o_FLAGLIRE=w_FLAGLIRE;");
      status.out.println("o_appolire=w_appolire;");
      status.out.println("o_VALUTA=w_VALUTA;");
      status.out.println("o_FLAGCONT=w_FLAGCONT;");
      status.out.println("o_RAPPORTO=w_RAPPORTO;");
      status.out.println("o_CONNESCLI=w_CONNESCLI;");
      status.out.println("o_filtro=w_filtro;");
      status.out.println("o_CONNESOPER=w_CONNESOPER;");
      status.out.println("o_CONNESBEN=w_CONNESBEN;");
      status.out.println("o_CONNALTRO=w_CONNALTRO;");
      status.out.println("o_C_CTA=w_C_CTA;");
      status.out.println("o_CODINT2=w_CODINT2;");
      status.out.println("o_CODINTER=w_CODINTER;");
      status.out.println("o_CODDIPE=w_CODDIPE;");
      status.out.println("o_SEGNO=w_SEGNO;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['IDBASE'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_ae_operazbo_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(710,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","jperazbo");
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
  void RaiseLoadedEntity(armt_ae_operazboBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_ae_operazboBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(armt_ae_operazboBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(armt_ae_operazboBO BO,ServletStatus status) {
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
  void WriteExitPage(armt_ae_operazboBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_ae_operazboBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_ae_operazboBO BO,ServletStatus status) throws IOException {
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
     "<script src='SPPrxy/"+arfn_calcflaglire.m_cEntityUid+"/arfn_calcflaglire.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chkdatdoc.m_cEntityUid+"/arfn_chkdatdoc.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chksogg.m_cEntityUid+"/arfn_chksogg.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chktotalelire.m_cEntityUid+"/arfn_chktotalelire.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chktotalelire_cont.m_cEntityUid+"/arfn_chktotalelire_cont.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_read_tipoleg.m_cEntityUid+"/arfn_read_tipoleg.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arrt_imp_frischio.m_cEntityUid+"/arrt_imp_frischio.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arrt_val_benefic.m_cEntityUid+"/arrt_val_benefic.js'>" +
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
      arfn_calcflaglire.GetCallableNames(callable);
      arfn_chkdatdoc.GetCallableNames(callable);
      arfn_chksogg.GetCallableNames(callable);
      arfn_chktotalelire.GetCallableNames(callable);
      arfn_chktotalelire_cont.GetCallableNames(callable);
      arfn_read_tipoleg.GetCallableNames(callable);
      arrt_imp_frischio.GetCallableNames(callable);
      arrt_val_benefic.GetCallableNames(callable);
      CPLib.AddToSet(callable,"LibreriaMit");
      CPLib.AddToSet(callable,"ardt_sogopeprov");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_ae_operazboBO BO,String p_cUID) {
    com.zucchetti.sitepainter.Library.HashCreator hCreator = com.zucchetti.sitepainter.Library.GetHashCreator();
    hCreator.Reset();
    if (CPLib.eq(p_cUID,m_cEntityUid)) {
      hCreator.AddValue(CPLib.BoolToChar(BO.IsLoaded()));
      if (BO.IsLoaded()) {
        hCreator.AddValue(BO.m_cOldCPCCCHK);
        hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_IDBASE),"C",10,0));
      }
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gIntemediario),"C",11,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gChkDate),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gTipInter),"C",2,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gSblocco),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(BO.w_gDataVaria,"D",8,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gStatus),"C",4,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gFlgDoc),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gFlgWU),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(BO.w_gFlgDTP,"N",1,0));
    } else if (CPLib.eq(p_cUID,"UTKMIHOWMH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"JFTTTRWQFB")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"YGFXODFVYI")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"HLPFLQLILN")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"MLQSWPUYXK")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"JHLWBNTKPL")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SYIIMUFSEQ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"JVSBAIMQUS")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ODAYKSRECA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"YVIKEGPYPM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NUZRBZHLLM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"GYOQKYEVYP")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"LCQKOYRNRT")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ZUFPYFWAFU")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"KXEUVNBTBC")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"KHRUYMSPDK")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"QEFXECTWSF")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"QJSTZIPOQB")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SFFFOYOWNH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NOBMPHKVTX")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"DJOWYRMDDC")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"CKJQULDXKW")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SXTYCPHBIM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_ae_operazboBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_CODANA))) {
        a = GetCheckVars(status,BO,"UTKMIHOWMH");
        b = status.m_CheckVars.optString("UTKMIHOWMH");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_VALUTA))) {
        a = GetCheckVars(status,BO,"YGFXODFVYI");
        b = status.m_CheckVars.optString("YGFXODFVYI");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_RAPPORTO))) {
        a = GetCheckVars(status,BO,"HLPFLQLILN");
        b = status.m_CheckVars.optString("HLPFLQLILN");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CONNESCLI))) {
        a = GetCheckVars(status,BO,"MLQSWPUYXK");
        b = status.m_CheckVars.optString("MLQSWPUYXK");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CONNESOPER))) {
        a = GetCheckVars(status,BO,"JHLWBNTKPL");
        b = status.m_CheckVars.optString("JHLWBNTKPL");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CONNESBEN))) {
        a = GetCheckVars(status,BO,"SYIIMUFSEQ");
        b = status.m_CheckVars.optString("SYIIMUFSEQ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CONNALTRO))) {
        a = GetCheckVars(status,BO,"JVSBAIMQUS");
        b = status.m_CheckVars.optString("JVSBAIMQUS");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_C_STA))) {
        a = GetCheckVars(status,BO,"YVIKEGPYPM");
        b = status.m_CheckVars.optString("YVIKEGPYPM");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_PAESE))) {
        a = GetCheckVars(status,BO,"GYOQKYEVYP");
        b = status.m_CheckVars.optString("GYOQKYEVYP");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CODINTER))) {
        a = GetCheckVars(status,BO,"ZUFPYFWAFU");
        b = status.m_CheckVars.optString("ZUFPYFWAFU");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CODDIPE))) {
        a = GetCheckVars(status,BO,"KXEUVNBTBC");
        b = status.m_CheckVars.optString("KXEUVNBTBC");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CODVOC))) {
        a = GetCheckVars(status,BO,"KHRUYMSPDK");
        b = status.m_CheckVars.optString("KHRUYMSPDK");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_OPERAG))) {
        a = GetCheckVars(status,BO,"QEFXECTWSF");
        b = status.m_CheckVars.optString("QEFXECTWSF");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_AREAGEO))) {
        a = GetCheckVars(status,BO,"QJSTZIPOQB");
        b = status.m_CheckVars.optString("QJSTZIPOQB");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_MODSVOL))) {
        a = GetCheckVars(status,BO,"SFFFOYOWNH");
        b = status.m_CheckVars.optString("SFFFOYOWNH");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_RAGIO))) {
        a = GetCheckVars(status,BO,"NOBMPHKVTX");
        b = status.m_CheckVars.optString("NOBMPHKVTX");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_TIPO))) {
        a = GetCheckVars(status,BO,"DJOWYRMDDC");
        b = status.m_CheckVars.optString("DJOWYRMDDC");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DURAT))) {
        a = GetCheckVars(status,BO,"CKJQULDXKW");
        b = status.m_CheckVars.optString("CKJQULDXKW");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_AMMONT))) {
        a = GetCheckVars(status,BO,"SXTYCPHBIM");
        b = status.m_CheckVars.optString("SXTYCPHBIM");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
