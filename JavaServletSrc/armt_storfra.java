import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({})
public class armt_storfra extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*83844e9b*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "wraziobo";
    }
    public String w_IDBASE;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_IDBASE,context,"wraziobo","IDBASE","C",10,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
    armt_storfraBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_wraziobo;
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
    return "Frazionate (A.U.I.) (Storico)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_storfra";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 919;
    l_eg.m_nEntityHeight = 745;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"wraziobo","wraziobo","tbcauana","tbvalute","anarapbo","personbo","tbcitta","tbstati","inter2bo","intermbo","anadip","tbcausin","tbtipope","tbareegeog","tbsvolgim","tbplauso","tbtiporisc","tbdurata","tbimporto","kersonbo"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","Principale","page"),new ZoneItem("page_2","Intestatari / Operanti Conto Terzi","page"),new ZoneItem("page_3","Altre Controparti / Altri Soggetti Terzi","page"),new ZoneItem("page_4","Dati Agenzia Entrate","page"),new ZoneItem("page_5","Documenti Soggetti","page"),new ZoneItem("box_HZHFVWKGKP","",""),new ZoneItem("box_JOFBXTNMTP","",""),new ZoneItem("box_XLSSDAVPDH","Dati Soggetti/Rapporti Coinvolti nell'operazione","collapsible"),new ZoneItem("box_HGCXMHOHLD","Dati ControParte","collapsible"),new ZoneItem("box_HXTNEUCQUZ","Dati eventuale Intermediario ControParte","collapsible"),new ZoneItem("box_KURTXQHCYE","Dati Rettifiche","collapsible"),new ZoneItem("Intestatari","Intestatari","collapsible"),new ZoneItem("Esecutori","","collapsible"),new ZoneItem("box_HNGGJVVCNB","",""),new ZoneItem("box_EUBBNRKXRL","",""),new ZoneItem("Controparti","Controparti","collapsible"),new ZoneItem("SoggTerzi","","collapsible"),new ZoneItem("box_MDLVFVTHTI","",""),new ZoneItem("box_XBHGNJLLKW","",""),new ZoneItem("AGE","Dati Per Agenzia Entrate (Campi modificabili liberamente)","collapsible"),new ZoneItem("box_EPMKMXEEOS","",""),new ZoneItem("box_BAZZCBWNET","",""),new ZoneItem("Internet","Dati  Operazione Internet Casino","collapsible"),new ZoneItem("box_WDZXXUSHOC","",""),new ZoneItem("box_UMWUWBXDQZ","",""),new ZoneItem("box_UUQVMJFNZY","","")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"IDBASE"};
    l_eg.items = new SPItem[]{
                   new SPItem("DATAOPE","D",8,0, "edit","Data Operazione"),
                   new SPItem("CDATOPE","C",8,0, "hide","Data Operazione in carattere"),
                   new SPItem("filtro","C",1,0, "hide",""),
                   new SPItem("DATAREG","D",8,0, "edit","Data registrazione"),
                   new SPItem("FLAGFRAZ","C",1,0, "edit","Frazionata (S/N)"),
                   new SPItem("COLLEG","C",11,0, "show","Collegamento Operazione Multiple"),
                   new SPItem("TIPOOPRAP","C",2,0, "edit","Tipo Operazione Completa"),
                   new SPItem("CODANA","C",4,0, "edit","Causale Analitica"),
                   new SPItem("CODVOC","C",2,0, "edit","Causale Sintetica"),
                   new SPItem("FLAGLIRE","C",1,0, "hide","Lire Euro Valuta"),
                   new SPItem("appolire","C",1,0, "edit",""),
                   new SPItem("VALUTA","C",3,0, "edit","Divisa"),
                   new SPItem("xTOTLIRE","N",15,2, "edit",""),
                   new SPItem("FLAGCONT","C",1,0, "edit","Contanti (S/N)"),
                   new SPItem("xTOTCONT","N",15,2, "edit",""),
                   new SPItem("CAMBIO","N",9,4, "edit","Cambio"),
                   new SPItem("RAPPORTO","C",25,0, "edit","Rapporto Collegato"),
                   new SPItem("CONNESCLI","C",16,0, "edit","Codice Cliente Occasionale"),
                   new SPItem("CONNESOPER","C",16,0, "edit","Codice Cliente Occasionale"),
                   new SPItem("TIPOLEG","C",1,0, "edit","Tipo Legame"),
                   new SPItem("PAGASOGOP","C",1,0, "edit",""),
                   new SPItem("CONNESBEN","C",16,0, "edit","Codice Cliente Occasionale"),
                   new SPItem("CONNALTRO","C",16,0, "edit",""),
                   new SPItem("C_RAG","C",70,0, "edit",""),
                   new SPItem("C_CTA","C",30,0, "edit",""),
                   new SPItem("C_PRV","C",2,0, "edit",""),
                   new SPItem("C_CAP","C",5,0, "edit",""),
                   new SPItem("C_CAB","C",6,0, "edit",""),
                   new SPItem("C_IND","C",35,0, "edit",""),
                   new SPItem("C_STA","C",3,0, "edit",""),
                   new SPItem("TIPOINT2","C",2,0, "edit","Tipo Intermediario C/Parte"),
                   new SPItem("CODINT2","C",11,0, "edit","Codice Intermediario C/Parte"),
                   new SPItem("DESCINTER","C",50,0, "edit",""),
                   new SPItem("PAESE","C",3,0, "edit","Stato Intermediario C/Parte"),
                   new SPItem("C_RAPPORTO","C",25,0, "edit",""),
                   new SPItem("CODCAB2","C",6,0, "edit","CAB Intermediario C/Parte"),
                   new SPItem("PROV2","C",2,0, "edit","Provincia Intermediario C/Parte"),
                   new SPItem("DESC2","C",30,0, "edit","Denominazione Intermediario C/Parte"),
                   new SPItem("ZCPARTE","C",69,0, "edit",""),
                   new SPItem("IDBASE","C",10,0, "edit","Idbase"),
                   new SPItem("NUMPROG","C",11,0, "show","Numero Progressivo"),
                   new SPItem("CODINTER","C",11,0, "show","Codice Intermediario"),
                   new SPItem("CODDIPE","C",6,0, "edit","Codice Dipendenza"),
                   new SPItem("DESCCIT","C",30,0, "show","Città Dipendenza"),
                   new SPItem("SEGNO","C",1,0, "show","Segno"),
                   new SPItem("PROVINCIA","C",2,0, "show","Provincia Dipendenza"),
                   new SPItem("CODCAB","C",6,0, "show","CAB Dipendenza"),
                   new SPItem("tipope","C",1,0, "hide",""),
                   new SPItem("CODVOC","C",2,0, "hide","Causale Sintetica"),
                   new SPItem("TOTLIRE","N",15,0, "hide","Totale Operazione"),
                   new SPItem("TOTCONT","N",15,0, "hide","di cui contanti"),
                   new SPItem("IDBASE","C",10,0, "hide","Idbase"),
                   new SPItem("TIPOINF","C",1,0, "hide","Tipo Informazione"),
                   new SPItem("IDEREG","C",20,0, "hide","ID Registrazione"),
                   new SPItem("DESCINTER","C",50,0, "hide",""),
                   new SPItem("FLAGRAP","C",1,0, "hide","Tipo Rapporto Collegato"),
                   new SPItem("OPRAP","C",1,0, "hide","Tipo operazione"),
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
                   new SPItem("gTipInter","C",2,0, "hide","Tipo Intermediario"),
                   new SPItem("PROVDIP","C",2,0, "hide","Provincia"),
                   new SPItem("CABDIP","C",6,0, "hide","CAB"),
                   new SPItem("PROVINT","C",2,0, "hide","Provincia"),
                   new SPItem("CABINT","C",6,0, "hide","CAB"),
                   new SPItem("PRGIMPFRZ","N",15,0, "hide","Progressivo Import"),
                   new SPItem("dataoggi","D",8,0, "hide",""),
                   new SPItem("stringaflagrap2","C",9,0, "hide",""),
                   new SPItem("gSblocco","C",1,0, "hide","Sblocco controllo"),
                   new SPItem("CDATAOPE","C",8,0, "hide","Data Operazione in carattere"),
                   new SPItem("gStatus","C",4,0, "hide","Stato Operazione"),
                   new SPItem("gDataVaria","D",8,0, "hide","Data Variazione"),
                   new SPItem("CITINT","C",30,0, "hide","Città"),
                   new SPItem("CITDIP","C",30,0, "hide","Città"),
                   new SPItem("CONNESDOC","C",40,0, "hide","Connessione Tabella Storico Documenti"),
                   new SPItem("gFlgDoc","C",1,0, "hide","Collegamento con storico documenti"),
                   new SPItem("xcodfisc","C",16,0, "hide","Codice Fiscale"),
                   new SPItem("dessta","C",40,0, "hide","Descrizione"),
                   new SPItem("xragsocalt","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("xdciticon","C",40,0, "hide","Località"),
                   new SPItem("gFlgWU","C",1,0, "hide","Gestione WU"),
                   new SPItem("CDATREG","C",8,0, "hide","Data Registrazione in carattere"),
                   new SPItem("DATAVALI","D",8,0, "hide",""),
                   new SPItem("DATARILASC","D",8,0, "hide","Data Rilascio Doc."),
                   new SPItem("apporeg","C",8,0, "hide",""),
                   new SPItem("gFlgDTP","N",1,0, "hide","Forza Data Trasferimento Provvisorie"),
                   new SPItem("ANNOOPE","N",4,0, "hide","Anno Operazione (MT/IDP)"),
                   new SPItem("DATARETT","D",8,0, "edit","Data Rettifica"),
                   new SPItem("IDEREG","C",20,0, "show","ID Registrazione"),
                   new SPItem("STATOREG","C",1,0, "show","Stato"),
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
                   new SPItem("IPCOLLEG","C",15,0, "show","IP Collegamento"),
                   new SPItem("ORACOLLEG","T",8,0, "show","Inizio Collegamento"),
                   new SPItem("DUCOLLEG","N",10,0, "show","Durata Collegamento"),
                   new SPItem("MITIG","N",4,0, "edit","Mitigazione (+/-)"),
                   new SPItem("MITGDOC","C",100,0, "edit","Documentazione Mitigazione"),
                   new SPItem("CONNESDOC","C",50,0, "edit","Storico Documenti"),
                   new SPItem("xRAGSOCDOC","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("IDFILE","C",60,0, "show","ID File"),
                   new SPItem("MTCN","C",10,0, "edit","MTCN")
                 };
    l_eg.m_lHasHistorical = false;
    return l_eg;
  }
  ArrayList<org.json.JSONArray> i_sidebarItems = null;
  public org.json.JSONArray getSidebarItems(int p_nPage) {
    if (CPLib.IsNull(i_sidebarItems)) {
      i_sidebarItems = InitializeSidebarItemsArray(5);
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_storfraBO BO) {
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
      i_contextmenu = InitializeContextMenuArray(5);
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
    {"10196692374",p_Context.Translate("Non inviare agenzia Entrate")},
    {"10219814530",p_Context.Translate("Codice Cliente Occasionale")},
    {"10220423475",p_Context.Translate("Data Variazione")},
    {"1028598955",p_Context.Translate("Data registrazione")},
    {"103243324",p_Context.Translate("Tipo Operazione Agenzia Entrate")},
    {"10379997930",p_Context.Translate("Rapporto Collegato")},
    {"10455298077",p_Context.Translate("Codice Intermediario C/Parte")},
    {"10464441821",p_Context.Translate("%1")},
    {"10637879581",p_Context.Translate("Data Operazione in carattere")},
    {"10639118571",p_Context.Translate("Tipo Legame")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"10703819256",p_Context.Translate("%1")},
    {"10848850431",p_Context.Translate("CAB Dipendenza")},
    {"10935874817",p_Context.Translate("Impossibile cancellare una frazionata dall'archivio storico")},
    {"10943726013",p_Context.Translate("di cui contanti")},
    {"109710548",p_Context.Translate("Divisa")},
    {"10983493593",p_Context.Translate("Gestione WU")},
    {"11053408024",p_Context.Translate("Area Geografica")},
    {"11058698874",p_Context.Translate("Tipo Intermediario C/Parte")},
    {"11137644647",p_Context.Translate("Tipo Operazione Completa")},
    {"11158852142",p_Context.Translate("Modalità Svolgimento")},
    {"11262175587",p_Context.Translate("Documenti")},
    {"11291273118",p_Context.Translate("Soggetto operante utilizza mezzi propri")},
    {"11316624286",p_Context.Translate("Codice Intermediario")},
    {"11329559720",p_Context.Translate("Data Rettifica")},
    {"11356972522",p_Context.Translate("Provincia Dipendenza")},
    {"113866889",p_Context.Translate("Idbase")},
    {"11396780126",p_Context.Translate("Intermediario")},
    {"114016870",p_Context.Translate("Valute")},
    {"11419545353",p_Context.Translate("%1")},
    {"11424168249",p_Context.Translate("Altri Intermediari")},
    {"11459349451",p_Context.Translate("Sblocco controllo")},
    {"1148775685",p_Context.Translate("%1")},
    {"11525797640",p_Context.Translate("%ERRORMESSAGE%")},
    {"11655443642",p_Context.Translate("%1")},
    {"11710831322",p_Context.Translate("%1")},
    {"11767338828",p_Context.Translate("Operatore")},
    {"11823283690",p_Context.Translate("Denominazione Intermediario C/Parte")},
    {"11857520945",p_Context.Translate("Ammontare Operazione")},
    {"11921223220",p_Context.Translate("Codice Fiscale")},
    {"11945229207",p_Context.Translate("CAB Intermediario C/Parte")},
    {"12057236694",p_Context.Translate("Frazionate")},
    {"12101861285",p_Context.Translate("Tipo Rapporto Beneficiario")},
    {"12128708791",p_Context.Translate("La data di registrazione deve essere maggiore o uguale a quella dell'operazione")},
    {"123704147",p_Context.Translate("Cambio")},
    {"1270140318",p_Context.Translate("Dipendenze")},
    {"15186643",p_Context.Translate("Città")},
    {"1638885956",p_Context.Translate("Visualizza i dati del cliente relativi all'operazione")},
    {"1690077224",p_Context.Translate("Data Rilascio Doc.")},
    {"1698385181",p_Context.Translate("ID Registrazione")},
    {"1722199786",p_Context.Translate("Frazionata (S/N)")},
    {"1748201363",p_Context.Translate("Città Dipendenza")},
    {"18003",p_Context.Translate("CAB")},
    {"1814922377",p_Context.Translate("ID File")},
    {"1825772649",p_Context.Translate("Totale Operazione")},
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
    {"226933836",p_Context.Translate("Data Passaggio EURO")},
    {"237632211",p_Context.Translate("Contanti (S/N)")},
    {"240702475",p_Context.Translate("Stato Intermediario C/Parte")},
    {"282420974",p_Context.Translate("Causali Sintetiche")},
    {"282647084",p_Context.Translate("Causali Analitiche")},
    {"283403499",p_Context.Translate("Progressivo Import")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"307787605",p_Context.Translate("Mitigazione (+/-)")},
    {"308673648",p_Context.Translate("Tipo Rapporto Collegato")},
    {"338061",p_Context.Translate("MTCN")},
    {"339694596",p_Context.Translate("Connessione Tabella Storico Documenti")},
    {"340709450",p_Context.Translate("%1")},
    {"368688795",p_Context.Translate("Anno Operazione (MT/IDP)")},
    {"382921594",p_Context.Translate("Impossibile inserire una frazionata nell'archivio storico")},
    {"383234328",p_Context.Translate("Stato Operazione")},
    {"436781937",p_Context.Translate("Durata Collegamento")},
    {"450841094",p_Context.Translate("Inizio Collegamento")},
    {"491820845",p_Context.Translate("Data Registrazione in carattere")},
    {"492802848",p_Context.Translate("Frequenza Operazione")},
    {"619750558",p_Context.Translate("Impossibile variare una frazionata nell'archivio storico")},
    {"624505163",p_Context.Translate("Lire Euro Valuta")},
    {"635233449",p_Context.Translate("Provincia Intermediario C/Parte")},
    {"654805131",p_Context.Translate("Collega le operazioni ai titolari effettivi")},
    {"655308117",p_Context.Translate("Frazionate (A.U.I.) (Storico)")},
    {"684190680",p_Context.Translate("Tipo Informazione")},
    {"698242285",p_Context.Translate("Importazione da file esterno")},
    {"711282992",p_Context.Translate("Storico Documenti")},
    {"7383187",p_Context.Translate("Stati")},
    {"750412439",p_Context.Translate("Collegamento Operazione Multiple")},
    {"7753123",p_Context.Translate("Segno")},
    {"7776403",p_Context.Translate("Stato")},
    {"829201110",p_Context.Translate("Data Operazione")},
    {"839211622",p_Context.Translate("Numero Progressivo")},
    {"862812006",p_Context.Translate("Tipo operazione")},
    {"864597548",p_Context.Translate("Collegamento con storico documenti")},
    {"955814582",p_Context.Translate("Ragionevolezza Operazione")},
    {"971512000",p_Context.Translate("IP Collegamento")},
    {"976489378",p_Context.Translate("Controllo Date")},
    {"984756930",p_Context.Translate("Tipo Intermediario")},
    {"995100987",p_Context.Translate("Tipo Registrazione")}};
    return l_translations;
  }
  void WriteStyles(armt_storfraBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_storfra.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_storfraBO BO,ServletStatus status) {
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
    status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("Principale"),"C",0,0)+"},{name:\"page_2\", element:\"page_2\", caption:"+SPLib.ToJSValue(status.context.Translate("Intestatari / Operanti Conto Terzi"),"C",0,0)+"},{name:\"page_3\", element:\"page_3\", caption:"+SPLib.ToJSValue(status.context.Translate("Altre Controparti / Altri Soggetti Terzi"),"C",0,0)+"},{name:\"page_4\", element:\"page_4\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati Agenzia Entrate"),"C",0,0)+"},{name:\"page_5\", element:\"page_5\", caption:"+SPLib.ToJSValue(status.context.Translate("Documenti Soggetti"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
    status.out.println("Z.Tabs.Set('tabs',tabs);");
    status.out.println("} else {");
    status.out.println("var tabs = Z.Tabs.Get('tabs')");
    status.out.println("}");
    AddExtendedTabs(status);
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_storfra',false);");
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_storfra",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(armt_storfraBO BO,ServletStatus status) {
    WriteControls_p1(BO,status);
    WriteControls_p2(BO,status);
    WriteControls_p3(BO,status);
    WriteControls_p4(BO,status);
    WriteControls_p5(BO,status);
    PrintNotifyContent(status,getNotifyItems());
    WriteExtendedTabs(BO.m_MNTs,BO.extendedFields,status,6);
  }
  void WriteControls_p1(armt_storfraBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:745px;width:919px;display:none'>" +
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
  void WriteControls_p2(armt_storfraBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_2' class='PageContainer' style='position:relative;height:504px;width:919px;display:none'>" +
    "");
    WriteControls_p2_b0(BO,status);
    WriteControls_p2_b1(BO,status);
    WriteControls_p2_b2(BO,status);
    WriteControls_p2_b3(BO,status);
    WriteControls_p2_b4(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,2,"Intestatari / Operanti Conto Terzi");
    PrintSidebarContent(2,status,getSidebarItems(1),true);
    PrintContextMenu(2,status,getContextMenu(1),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3(armt_storfraBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_3' class='PageContainer' style='position:relative;height:567px;width:919px;display:none'>" +
    "");
    WriteControls_p3_b0(BO,status);
    WriteControls_p3_b1(BO,status);
    WriteControls_p3_b2(BO,status);
    WriteControls_p3_b3(BO,status);
    WriteControls_p3_b4(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,3,"Altre Controparti / Altri Soggetti Terzi");
    PrintSidebarContent(3,status,getSidebarItems(2),true);
    PrintContextMenu(3,status,getContextMenu(2),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p4(armt_storfraBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_4' class='PageContainer' style='position:relative;height:549px;width:919px;display:none'>" +
    "");
    WriteControls_p4_b0(BO,status);
    WriteControls_p4_b1(BO,status);
    WriteControls_p4_b2(BO,status);
    WriteControls_p4_b3(BO,status);
    WriteControls_p4_b4(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,4,"Dati Agenzia Entrate");
    PrintSidebarContent(4,status,getSidebarItems(3),true);
    PrintContextMenu(4,status,getContextMenu(3),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p5(armt_storfraBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_5' class='PageContainer' style='position:relative;height:546px;width:919px;display:none'>" +
    "");
    WriteControls_p5_b0(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,5,"Documenti Soggetti");
    PrintSidebarContent(5,status,getSidebarItems(4),false);
    PrintContextMenu(5,status,getContextMenu(4),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b0(armt_storfraBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_1")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_1' style='position:relative;height:188px;display:block' page='1'>" +
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
       "<div id='HZHFVWKGKP_DIV' class='UntitledBox'>" +
       "<div id='HZHFVWKGKP' class='BoxBody'>" +
       "</div>" +
       "</div>" +
      "");
      status.out.println(
       "<div id='JOFBXTNMTP_DIV' class='UntitledBox'>" +
       "<div id='JOFBXTNMTP' class='BoxBody'>" +
       "</div>" +
       "</div>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAOPE' id='WAAXEDMKXA' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_DATAOPE,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='WAAXEDMKXA_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAREG' id='NXYGHZZLCG' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_DATAREG,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='FLAGFRAZ' id='QSRYXQJCBZ' class='Combobox' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_FLAGFRAZ),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
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
       "selectCombo(Ctrl('QSRYXQJCBZ'),w_FLAGFRAZ,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<input name='COLLEG' id='FCUPIYMFZB' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_COLLEG,"C",11,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='11' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPOOPRAP' id='XVLCUXTZXI' class='Combobox' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_TIPOOPRAP),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODANA' id='EZPCGCABUD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODANA,"C",4,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='4' fieldtype='C'>" +
       "<button id='EZPCGCABUD_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "EZPCGCABUD", "tbcauana", "", "cauinter")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODVOC' id='BHDZAMJILO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODVOC,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
       "<button id='BHDZAMJILO_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "BHDZAMJILO", "tbcauana", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='appolire' id='MFRSDQPPEY' class='Combobox "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_FLAGLIRE),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"disabled":"")+">" +
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
       "selectCombo(Ctrl('MFRSDQPPEY'),w_appolire,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='VALUTA' id='JCKYJRZABA' class='Combobox' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_VALUTA),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='xTOTLIRE' id='QOALLRLDKY' type='text' class='"+status.ObligatoryClass("Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"")+"' value="+SPLib.ToHTMLValue(BO.w_xTOTLIRE,"N",15,2,"999,999,999,999.99", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='21' size='15' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='FLAGCONT' id='RPHQMPGGQR' class='Combobox' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_FLAGCONT),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("0","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("0",CPLib.Trim(BO.w_FLAGCONT))?"SELECTED":"")+">" +
       ""+status.context.Translate("No")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_FLAGCONT))?"SELECTED":"")+">" +
       ""+status.context.Translate("Si")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('RPHQMPGGQR'),w_FLAGCONT,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='xTOTCONT' id='KUMAEYPETV' type='text' class='"+status.ObligatoryClass("Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"")+"' value="+SPLib.ToHTMLValue(BO.w_xTOTCONT,"N",15,2,"999,999,999,999.99", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='21' size='15' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CAMBIO' id='FADDNUEJZJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CAMBIO,"N",9,4,"9999.9999", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='12' size='9' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IDBASE' id='NJDOYSOENB' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_IDBASE,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='10' size='10' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<input name='NUMPROG' id='XTDANURGMM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_NUMPROG,"C",11,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='11' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RUVVREGNGP_DIV'>" +
       "<label id='RUVVREGNGP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A03. Numero Progressivo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NRJTHQEJCT_DIV'>" +
       "<label id='NRJTHQEJCT'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A21. Data Operazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='CODINTER' id='NNOUMHTLXJ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CODINTER,"C",11,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='11' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HBLSDWZPZJ_DIV'>" +
       "<label id='HBLSDWZPZJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A01B. Intermediario:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODDIPE' id='SDNFDOJDLP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODDIPE,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
       "<button id='SDNFDOJDLP_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "SDNFDOJDLP", "anadip", "", "")+"" +
      "");
      status.out.println(
       "<input name='DESCCIT' id='DHFUAHCMCJ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DESCCIT,"C",30,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LQQUOWOYQW_DIV'>" +
       "<label id='LQQUOWOYQW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A23. Contanti:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RFOXSFMJNY_DIV'>" +
       "<label id='RFOXSFMJNY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A24. Causale Analitica:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KZBMHOFWYD_DIV'>" +
       "<label id='KZBMHOFWYD'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A51. Data registrazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KJZKHGDTBV_DIV'>" +
       "<label id='KJZKHGDTBV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A52. Tipo Operazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CEGQRJFFAZ_DIV'>" +
       "<label id='CEGQRJFFAZ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("B11. Tipo Divisa:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JYQAVTDBKY_DIV'>" +
       "<label id='JYQAVTDBKY'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("B12. Divisa:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='SEGNO' id='XESWONRBTH' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_SEGNO,"C",1,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='1' size='1' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='AIRYDUUQZV_DIV'>" +
       "<label id='AIRYDUUQZV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("B13. Segno:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HUZWIZYTMV_DIV'>" +
       "<label id='HUZWIZYTMV'>" +
       ""+SPLib.ToHTMLRepresentation((CPLib.ge(BO.w_DATAOPE,CPLib.CharToDate("20020101")) || CPLib.le(BO.w_datpaseuro,BO.w_DATAOPE)?"B14. Totale Euro:":"B14. Totale Lire:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PGNMOJFSUL_DIV'>" +
       "<label id='PGNMOJFSUL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("B15. di cui contanti:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TLSZHVBXSN_DIV'>" +
       "<label id='TLSZHVBXSN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Cambio:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HZDQOFEXPB_DIV'>" +
       "<label id='HZDQOFEXPB'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A11. Dipendenza:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OIZHYHOJII_DIV'>" +
       "<label id='OIZHYHOJII'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A12B. Città:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='IZRUENEKXU_DIV'>" +
       "<label id='IZRUENEKXU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A12C. Prov.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VPEIKRTWFC_DIV'>" +
       "<label id='VPEIKRTWFC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A12A. CAB:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RLUNSWADHC_DIV'>" +
       "<label id='RLUNSWADHC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A22. Tipo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CNKLWUVOXA_DIV' style='display:none'>" +
       "<label id='CNKLWUVOXA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A53. Collegata a:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='PROVINCIA' id='QTBRDJZGGM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_PROVINCIA,"C",2,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='CODCAB' id='RIKKHKHPLM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CODCAB,"C",6,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='6' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LNDPVLRRZI_DIV'>" +
       "<label id='LNDPVLRRZI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A25. Sintetica:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OJVAARLZEQ_DIV'>" +
       "<label id='OJVAARLZEQ' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_desccauana),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation(BO.w_desccauana)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CKDWHDTZAO_DIV'>" +
       "<label id='CKDWHDTZAO' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_xdesccausin),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdesccausin)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p1_b1(armt_storfraBO BO,ServletStatus status) {
    status.out.println(
     "<div name='box_XLSSDAVPDH' id='XLSSDAVPDH_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='XLSSDAVPDH_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='XLSSDAVPDH_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Soggetti/Rapporti Coinvolti nell'operazione")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='XLSSDAVPDH_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"XLSSDAVPDH\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=XLSSDAVPDH_HEADER&m_cBoxId=XLSSDAVPDH&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Soggetti/Rapporti Coinvolti nell'operazione"))+"");
    }
    status.out.println(
     "<div id='XLSSDAVPDH' class='CollapsibleBody' style='position:relative;height:171px;display:block'>" +
    "");
    status.includeZoneAltInterface("box_XLSSDAVPDH@BEGIN");
    if (status.includeZoneAltInterface("box_XLSSDAVPDH")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("box_XLSSDAVPDH@BEGIN") || status.HasZoneAltInterface("box_XLSSDAVPDH@END")) {
        status.out.println(
         "<div id='XLSSDAVPDH_boxContent' style='position:relative;height:171px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RAPPORTO' id='RZIQZFKPUE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RAPPORTO,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
       "<button id='RZIQZFKPUE_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "RZIQZFKPUE", "anarapbo", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CONNESCLI' id='QBLXDBODXR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONNESCLI,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
       "<button id='QBLXDBODXR_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "QBLXDBODXR", "personbo", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CONNESOPER' id='TCOTJNZLGM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONNESOPER,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
       "<button id='TCOTJNZLGM_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "TCOTJNZLGM", "personbo", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPOLEG' id='WBHSORBZAV' class='"+status.ObligatoryClass("Combobox")+"' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_TIPOLEG),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='TMYVGJFCXV_DIV'>" +
       "<input name='PAGASOGOP' id='TMYVGJFCXV' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_PAGASOGOP,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_PAGASOGOP))?"CHECKED":"")+">" +
       "<label id='TMYVGJFCXV_LBL' for='TMYVGJFCXV' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Soggetto operante utilizza mezzi propri"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CONNESBEN' id='ULVCBLFVEU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONNESBEN,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
       "<button id='ULVCBLFVEU_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "ULVCBLFVEU", "personbo", "", "")+"" +
      "");
      WriteControls_p1_b1_1(BO,status);
    }
  }
  void WriteControls_p1_b1_1(armt_storfraBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CONNALTRO' id='TRNDHQYOXC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONNALTRO,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
     "<button id='TRNDHQYOXC_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "TRNDHQYOXC", "personbo", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='EXIXNLTCBE_DIV'>" +
     "<label id='EXIXNLTCBE'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A41. Rapporto Collegato:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='VECGHPFLII_DIV'>" +
     "<label id='VECGHPFLII'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("A43. Tipo Legame:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='NUEFWOMRRX_DIV'>" +
     "<label id='NUEFWOMRRX'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("C11. Intest. / Cliente Occ.:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='IINONMZPLB_DIV'>" +
     "<label id='IINONMZPLB'>" +
     ""+SPLib.ToHTMLRepresentation((CPLib.lt(BO.w_DATAOPE,CPLib.CharToDate("20140101"))?"C21. Sogg. Op. Conto Terzi:":"C21. Esecutore: "))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='LZDWHHTSGR_DIV'>" +
     "<label id='LZDWHHTSGR'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("C31. Controparte Bonifico:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='PXKFPRTVXX_DIV'>" +
     "<label id='PXKFPRTVXX'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xragsocper)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UWUWSYENHG_DIV'>" +
     "<label id='UWUWSYENHG'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xdescrap)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='QGPWBVUZYW_DIV'>" +
     "<label id='QGPWBVUZYW'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xragsocct)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='USZXRLYSFT_DIV'>" +
     "<label id='USZXRLYSFT'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xragsocben)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<a href='javascript:href_KMXZXPWLPX()' tabindex='-1' style='display:none' id='KMXZXPWLPX_HREF'>" +
     "<img id='KMXZXPWLPX' src="+SPLib.ToHTMLValue(SPLib.ToResource("images/search_adm.gif"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Visualizza i dati del cliente relativi all'operazione"),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' alt="+SPLib.ToHTMLValue(status.context.Translate("Visualizza i dati del cliente relativi all'operazione"),"C",0,0)+">" +
     "</a>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='CKBXAAYFYL_DIV'>" +
     "<label id='CKBXAAYFYL'>" +
     ""+SPLib.ToHTMLRepresentation((CPLib.lt(BO.w_DATAOPE,CPLib.CharToDate("20140101"))?"C41. Titolare Effettivo:":"C51. Soggetto per conto del quale: "))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='RDOJHWCSNP_DIV'>" +
     "<label id='RDOJHWCSNP'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xragsocalt)+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input id='XPWBHUQUGP' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Collega"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Collega le operazioni ai titolari effettivi"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
    "");
    if (status.HasZoneAltInterface("box_XLSSDAVPDH@BEGIN") || status.HasZoneAltInterface("box_XLSSDAVPDH@END")) {
      status.out.println(
       "</div>" +
      "");
    }
    WriteControls_p1_b1_CloseBand(BO,status);
  }
  void WriteControls_p1_b1_CloseBand(armt_storfraBO BO,ServletStatus status) {
    status.includeZoneAltInterface("box_XLSSDAVPDH@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("box_XLSSDAVPDH")) {
      status.out.println("Ctrl('XLSSDAVPDH').style.height='auto';");
    } else {
      status.out.println("Ctrl('XLSSDAVPDH').setAttribute('band_height',171);");
    }
    status.out.println("Ctrl('XLSSDAVPDH').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_storfraBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_HGCXMHOHLD")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_HGCXMHOHLD' style='position:relative;height:1px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_HGCXMHOHLD")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_HGCXMHOHLD').style.height='auto';");
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
  void WriteControls_p1_b3(armt_storfraBO BO,ServletStatus status) {
    status.out.println(
     "<div name='box_HGCXMHOHLD' id='HGCXMHOHLD_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='HGCXMHOHLD_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='HGCXMHOHLD_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati ControParte")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='HGCXMHOHLD_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"HGCXMHOHLD\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=HGCXMHOHLD_HEADER&m_cBoxId=HGCXMHOHLD&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati ControParte"))+"");
    }
    status.out.println(
     "<div id='HGCXMHOHLD' class='CollapsibleBody' style='position:relative;height:90px;display:block'>" +
    "");
    status.includeZoneAltInterface("box_HGCXMHOHLD@BEGIN");
    if (status.includeZoneAltInterface("box_HGCXMHOHLD")) {
      WriteControls_p1_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("box_HGCXMHOHLD@BEGIN") || status.HasZoneAltInterface("box_HGCXMHOHLD@END")) {
        status.out.println(
         "<div id='HGCXMHOHLD_boxContent' style='position:relative;height:90px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='C_RAG' id='KZXSBEEORE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_C_RAG,"C",70,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='70' size='70' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='C_CTA' id='SDKWKBVOVR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_C_CTA,"C",30,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
       "<button id='SDKWKBVOVR_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "SDKWKBVOVR", "tbcitta", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='C_PRV' id='UBEYBTICRP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_C_PRV,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='C_CAP' id='KWJVJHCAHT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_C_CAP,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='C_CAB' id='IXODLSKCSA' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_C_CAB,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='C_IND' id='LVMUPCVGIQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_C_IND,"C",35,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='35' size='35' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='C_STA' id='QASGTWMXYC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_C_STA,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='QASGTWMXYC_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "QASGTWMXYC", "tbstati", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WOJCGFTQXX_DIV'>" +
       "<label id='WOJCGFTQXX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("F14C. Prov.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='XBDNJBMLGI_DIV'>" +
       "<label id='XBDNJBMLGI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("F11. Denominazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HGSPJZYAQK_DIV'>" +
       "<label id='HGSPJZYAQK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("F13. Stato:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ENCKEBCYOC_DIV'>" +
       "<label id='ENCKEBCYOC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("F15. Indirizzo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UESICSHRAF_DIV'>" +
       "<label id='UESICSHRAF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("F16. CAP:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UIURSUTTMA_DIV'>" +
       "<label id='UIURSUTTMA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("F14A. CAB:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='IWRBWCCMDJ_DIV'>" +
       "<label id='IWRBWCCMDJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("F14B. Comune:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='MJDMCPKVHS_DIV'>" +
       "<label id='MJDMCPKVHS'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_dessta)+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("box_HGCXMHOHLD@BEGIN") || status.HasZoneAltInterface("box_HGCXMHOHLD@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b3_CloseBand(armt_storfraBO BO,ServletStatus status) {
    status.includeZoneAltInterface("box_HGCXMHOHLD@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("box_HGCXMHOHLD")) {
      status.out.println("Ctrl('HGCXMHOHLD').style.height='auto';");
    } else {
      status.out.println("Ctrl('HGCXMHOHLD').setAttribute('band_height',90);");
    }
    status.out.println("Ctrl('HGCXMHOHLD').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b4(armt_storfraBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_HXTNEUCQUZ")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_HXTNEUCQUZ' style='position:relative;height:1px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_HXTNEUCQUZ")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_HXTNEUCQUZ').style.height='auto';");
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
  void WriteControls_p1_b5(armt_storfraBO BO,ServletStatus status) {
    status.out.println(
     "<div name='box_HXTNEUCQUZ' id='HXTNEUCQUZ_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='HXTNEUCQUZ_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='HXTNEUCQUZ_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati eventuale Intermediario ControParte")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='HXTNEUCQUZ_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"HXTNEUCQUZ\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=HXTNEUCQUZ_HEADER&m_cBoxId=HXTNEUCQUZ&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati eventuale Intermediario ControParte"))+"");
    }
    status.out.println(
     "<div id='HXTNEUCQUZ' class='CollapsibleBody' style='position:relative;height:171px;display:block'>" +
    "");
    status.includeZoneAltInterface("box_HXTNEUCQUZ@BEGIN");
    if (status.includeZoneAltInterface("box_HXTNEUCQUZ")) {
      WriteControls_p1_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("box_HXTNEUCQUZ@BEGIN") || status.HasZoneAltInterface("box_HXTNEUCQUZ@END")) {
        status.out.println(
         "<div id='HXTNEUCQUZ_boxContent' style='position:relative;height:171px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPOINT2' id='OBBUSHLGFO' class='Combobox' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_TIPOINT2),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODINT2' id='OGZBJVOVLN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODINT2,"C",11,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='11' size='11' fieldtype='C'>" +
       "<button id='OGZBJVOVLN_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "OGZBJVOVLN", "inter2bo", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DESCINTER' id='TYCTKKPTQQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DESCINTER,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PAESE' id='MUTRCJYNJT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PAESE,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='MUTRCJYNJT_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "MUTRCJYNJT", "tbstati", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='C_RAPPORTO' id='YBNJCVPDUM' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_C_RAPPORTO,"C",25,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODCAB2' id='CRVLITCYRD' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODCAB2,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
       "<button id='CRVLITCYRD_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "CRVLITCYRD", "tbcitta", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PROV2' id='HWGWORUQJF' type='text' class='"+status.ObligatoryClass("Field",BO.HWGWORUQJF_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_PROV2,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DESC2' id='KDONRVZYMP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DESC2,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='ZCPARTE' id='RGKPHWRBRT' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_ZCPARTE,"C",69,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='69' size='69' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BXZTUYDDHV_DIV'>" +
       "<label id='BXZTUYDDHV'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A31A. Tipo Intermediario:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DMUKXNHPIX_DIV'>" +
       "<label id='DMUKXNHPIX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A31B. Intermediario C/Parte:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZVNEKPSDJI_DIV'>" +
       "<label id='ZVNEKPSDJI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A32. Stato UIF:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FWWUKUSBMJ_DIV'>" +
       "<label id='FWWUKUSBMJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A33B. Comune per esteso:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DFQGTRKLJP_DIV'>" +
       "<label id='DFQGTRKLJP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A33C. Provincia:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NSQKCLPTTK_DIV'>" +
       "<label id='NSQKCLPTTK'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A33A. CAB / Comune:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VPCTBTGNEV_DIV'>" +
       "<label id='VPCTBTGNEV'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdescpaese2)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SGPAMGUKLY_DIV'>" +
       "<label id='SGPAMGUKLY'>" +
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
       "<span class='SPLabel' id='SJNCLQSBKG_DIV'>" +
       "<label id='SJNCLQSBKG'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdciticon)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RPVEUGMVLG_DIV'>" +
       "<label id='RPVEUGMVLG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A34. Denominazione:"))+"" +
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
      if (status.HasZoneAltInterface("box_HXTNEUCQUZ@BEGIN") || status.HasZoneAltInterface("box_HXTNEUCQUZ@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b5_CloseBand(armt_storfraBO BO,ServletStatus status) {
    status.includeZoneAltInterface("box_HXTNEUCQUZ@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("box_HXTNEUCQUZ")) {
      status.out.println("Ctrl('HXTNEUCQUZ').style.height='auto';");
    } else {
      status.out.println("Ctrl('HXTNEUCQUZ').setAttribute('band_height',171);");
    }
    status.out.println("Ctrl('HXTNEUCQUZ').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b6(armt_storfraBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_KURTXQHCYE")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_KURTXQHCYE' style='position:relative;height:2px;display:block' page='1'>" +
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
  void WriteControls_p1_b7(armt_storfraBO BO,ServletStatus status) {
    status.out.println(
     "<div name='box_KURTXQHCYE' id='KURTXQHCYE_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='KURTXQHCYE_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='KURTXQHCYE_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Rettifiche")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='KURTXQHCYE_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"KURTXQHCYE\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=KURTXQHCYE_HEADER&m_cBoxId=KURTXQHCYE&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Rettifiche"))+"");
    }
    status.out.println(
     "<div id='KURTXQHCYE' class='CollapsibleBody' style='position:relative;height:36px;display:block'>" +
    "");
    status.includeZoneAltInterface("box_KURTXQHCYE@BEGIN");
    if (status.includeZoneAltInterface("box_KURTXQHCYE")) {
      WriteControls_p1_b7_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("box_KURTXQHCYE@BEGIN") || status.HasZoneAltInterface("box_KURTXQHCYE@END")) {
        status.out.println(
         "<div id='KURTXQHCYE_boxContent' style='position:relative;height:36px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATARETT' id='VYBZEWHKFF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DATARETT,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query")?""+status.m_nTabIndex+"":"-1")+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D' style='display:none'>" +
      "");
      status.out.println(
       "<input name='IDEREG' id='BFDIPOAGFS' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_IDEREG,"C",20,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='20' size='20' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PXIMPOLVHG_DIV'>" +
       "<label id='PXIMPOLVHG' for='VYBZEWHKFF'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Data Rettifica:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NOCRBBFOUY_DIV'>" +
       "<label id='NOCRBBFOUY' for='BFDIPOAGFS'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ID Registrazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<select name='STATOREG' id='OJXGBVSJHY' class='Combobox Disabled' disabled>" +
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
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Stato:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("box_KURTXQHCYE@BEGIN") || status.HasZoneAltInterface("box_KURTXQHCYE@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b7_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b7_CloseBand(armt_storfraBO BO,ServletStatus status) {
    status.includeZoneAltInterface("box_KURTXQHCYE@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("box_KURTXQHCYE")) {
      status.out.println("Ctrl('KURTXQHCYE').style.height='auto';");
    } else {
      status.out.println("Ctrl('KURTXQHCYE').setAttribute('band_height',36);");
    }
    status.out.println("Ctrl('KURTXQHCYE').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b8(armt_storfraBO BO,ServletStatus status) {
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
  void WriteControls_p2_b0(armt_storfraBO BO,ServletStatus status) {
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
  void WriteControls_p2_b1(armt_storfraBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Intestatari' id='BDZUATYPMW_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='BDZUATYPMW_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='BDZUATYPMW_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Intestatari")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='BDZUATYPMW_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"BDZUATYPMW\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=BDZUATYPMW_HEADER&m_cBoxId=BDZUATYPMW&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Intestatari"))+"");
    }
    status.out.println(
     "<div id='BDZUATYPMW' class='CollapsibleBody' style='position:relative;height:224px;display:block'>" +
    "");
    status.includeZoneAltInterface("Intestatari@BEGIN");
    if (status.includeZoneAltInterface("Intestatari")) {
      WriteControls_p2_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Intestatari@BEGIN") || status.HasZoneAltInterface("Intestatari@END")) {
        status.out.println(
         "<div id='BDZUATYPMW_boxContent' style='position:relative;height:224px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<iframe name='ardt_wlientifrz' id='BOAFVDQFRN' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
       "</iframe>" +
      "");
      if (status.HasZoneAltInterface("Intestatari@BEGIN") || status.HasZoneAltInterface("Intestatari@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p2_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p2_b1_CloseBand(armt_storfraBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Intestatari@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Intestatari")) {
      status.out.println("Ctrl('BDZUATYPMW').style.height='auto';");
    } else {
      status.out.println("Ctrl('BDZUATYPMW').setAttribute('band_height',224);");
    }
    status.out.println("Ctrl('BDZUATYPMW').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['BDZUATYPMW']=['BOAFVDQFRN'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b2(armt_storfraBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_ZYUUSRMPQG")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_ZYUUSRMPQG' style='position:relative;height:1px;display:block' page='2'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_ZYUUSRMPQG")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_ZYUUSRMPQG').style.height='auto';");
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
  void WriteControls_p2_b3(armt_storfraBO BO,ServletStatus status) {
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
     "<div id='ZYUUSRMPQG' class='CollapsibleBody' style='position:relative;height:179px;display:block'>" +
    "");
    status.includeZoneAltInterface("Esecutori@BEGIN");
    if (status.includeZoneAltInterface("Esecutori")) {
      WriteControls_p2_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Esecutori@BEGIN") || status.HasZoneAltInterface("Esecutori@END")) {
        status.out.println(
         "<div id='ZYUUSRMPQG_boxContent' style='position:relative;height:179px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<iframe name='ardt_storsogfraz' id='TQDGESLQVD' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
       "</iframe>" +
      "");
      if (status.HasZoneAltInterface("Esecutori@BEGIN") || status.HasZoneAltInterface("Esecutori@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p2_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p2_b3_CloseBand(armt_storfraBO BO,ServletStatus status) {
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
      status.out.println("Ctrl('ZYUUSRMPQG').setAttribute('band_height',179);");
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
  void WriteControls_p2_b4(armt_storfraBO BO,ServletStatus status) {
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
  void WriteControls_p3_b0(armt_storfraBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_3")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_3' style='position:relative;height:55px;display:block' page='3'>" +
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
       "<div id='MDLVFVTHTI_DIV' class='UntitledBox'>" +
       "<div id='MDLVFVTHTI' class='BoxBody'>" +
       "</div>" +
       "</div>" +
      "");
      status.out.println(
       "<div id='XBHGNJLLKW_DIV' class='UntitledBox'>" +
       "<div id='XBHGNJLLKW' class='BoxBody'>" +
       "</div>" +
       "</div>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TZFLWDFIAF_DIV'>" +
       "<label id='TZFLWDFIAF'>" +
       ""+SPLib.ToHTMLRepresentation("A01B. Intermediario: "+BO.w_CODINTER)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BTOBVVCOML_DIV'>" +
       "<label id='BTOBVVCOML'>" +
       ""+SPLib.ToHTMLRepresentation("A11. Dipendenza:"+BO.w_CODDIPE)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GLUOTVRWBG_DIV'>" +
       "<label id='GLUOTVRWBG'>" +
       ""+SPLib.ToHTMLRepresentation("A12B. Città: "+BO.w_DESCCIT)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TBRVQNQTYO_DIV'>" +
       "<label id='TBRVQNQTYO'>" +
       ""+SPLib.ToHTMLRepresentation(" A12C. Prov.: "+BO.w_PROVINCIA)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LJUWADMQSL_DIV'>" +
       "<label id='LJUWADMQSL'>" +
       ""+SPLib.ToHTMLRepresentation("A12A. CAB: "+BO.w_CODCAB)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p3_b1(armt_storfraBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Controparti' id='GTSBULOFTD_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='GTSBULOFTD_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='GTSBULOFTD_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Controparti")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='GTSBULOFTD_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"GTSBULOFTD\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=GTSBULOFTD_HEADER&m_cBoxId=GTSBULOFTD&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Controparti"))+"");
    }
    status.out.println(
     "<div id='GTSBULOFTD' class='CollapsibleBody' style='position:relative;height:242px;display:block'>" +
    "");
    status.includeZoneAltInterface("Controparti@BEGIN");
    if (status.includeZoneAltInterface("Controparti")) {
      WriteControls_p3_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Controparti@BEGIN") || status.HasZoneAltInterface("Controparti@END")) {
        status.out.println(
         "<div id='GTSBULOFTD_boxContent' style='position:relative;height:242px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<iframe name='ardt_weneficfrz' id='OCTDIOXFMI' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
       "</iframe>" +
      "");
      if (status.HasZoneAltInterface("Controparti@BEGIN") || status.HasZoneAltInterface("Controparti@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p3_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p3_b1_CloseBand(armt_storfraBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Controparti@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Controparti")) {
      status.out.println("Ctrl('GTSBULOFTD').style.height='auto';");
    } else {
      status.out.println("Ctrl('GTSBULOFTD').setAttribute('band_height',242);");
    }
    status.out.println("Ctrl('GTSBULOFTD').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['GTSBULOFTD']=['OCTDIOXFMI'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p3_b2(armt_storfraBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_BHLGNNSXQY")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_BHLGNNSXQY' style='position:relative;height:1px;display:block' page='3'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_BHLGNNSXQY")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_BHLGNNSXQY').style.height='auto';");
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
  void WriteControls_p3_b3(armt_storfraBO BO,ServletStatus status) {
    status.out.println(
     "<div name='SoggTerzi' id='BHLGNNSXQY_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='BHLGNNSXQY_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='BHLGNNSXQY_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       "</span>" +
      "");
      status.out.println(
       "<img id='BHLGNNSXQY_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"BHLGNNSXQY\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=BHLGNNSXQY_HEADER&m_cBoxId=BHLGNNSXQY&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption=");
    }
    status.out.println(
     "<div id='BHLGNNSXQY' class='CollapsibleBody' style='position:relative;height:224px;display:block'>" +
    "");
    status.includeZoneAltInterface("SoggTerzi@BEGIN");
    if (status.includeZoneAltInterface("SoggTerzi")) {
      WriteControls_p3_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("SoggTerzi@BEGIN") || status.HasZoneAltInterface("SoggTerzi@END")) {
        status.out.println(
         "<div id='BHLGNNSXQY_boxContent' style='position:relative;height:224px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<iframe name='ardt_werzistifrz' id='NOKYMTFBFL' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
       "</iframe>" +
      "");
      if (status.HasZoneAltInterface("SoggTerzi@BEGIN") || status.HasZoneAltInterface("SoggTerzi@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p3_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p3_b3_CloseBand(armt_storfraBO BO,ServletStatus status) {
    status.includeZoneAltInterface("SoggTerzi@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("SoggTerzi")) {
      status.out.println("Ctrl('BHLGNNSXQY').style.height='auto';");
    } else {
      status.out.println("Ctrl('BHLGNNSXQY').setAttribute('band_height',224);");
    }
    status.out.println("Ctrl('BHLGNNSXQY').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['BHLGNNSXQY']=['NOKYMTFBFL'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p3_b4(armt_storfraBO BO,ServletStatus status) {
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
  void WriteControls_p4_b0(armt_storfraBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_4")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_4' style='position:relative;height:55px;display:block' page='4'>" +
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
       "<div id='EPMKMXEEOS_DIV' class='UntitledBox'>" +
       "<div id='EPMKMXEEOS' class='BoxBody'>" +
       "</div>" +
       "</div>" +
      "");
      status.out.println(
       "<div id='BAZZCBWNET_DIV' class='UntitledBox'>" +
       "<div id='BAZZCBWNET' class='BoxBody'>" +
       "</div>" +
       "</div>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='AUNJFYUGOI_DIV'>" +
       "<label id='AUNJFYUGOI'>" +
       ""+SPLib.ToHTMLRepresentation("A01B. Intermediario: "+BO.w_CODINTER)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JMALELOJGS_DIV'>" +
       "<label id='JMALELOJGS'>" +
       ""+SPLib.ToHTMLRepresentation("A11. Dipendenza:"+BO.w_CODDIPE)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DABLCPOUXL_DIV'>" +
       "<label id='DABLCPOUXL'>" +
       ""+SPLib.ToHTMLRepresentation("A12B. Città: "+BO.w_DESCCIT)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HSFSPISTIA_DIV'>" +
       "<label id='HSFSPISTIA'>" +
       ""+SPLib.ToHTMLRepresentation(" A12C. Prov.: "+BO.w_PROVINCIA)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='IAJSGBSETX_DIV'>" +
       "<label id='IAJSGBSETX'>" +
       ""+SPLib.ToHTMLRepresentation("A12A. CAB: "+BO.w_CODCAB)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "</div>" +
      "");
    }
  }
  void WriteControls_p4_b1(armt_storfraBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Internet' id='JTWNGHDSFX_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='JTWNGHDSFX_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='JTWNGHDSFX_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati  Operazione Internet Casino")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='JTWNGHDSFX_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"JTWNGHDSFX\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=JTWNGHDSFX_HEADER&m_cBoxId=JTWNGHDSFX&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati  Operazione Internet Casino"))+"");
    }
    status.out.println(
     "<div id='JTWNGHDSFX' class='CollapsibleBody' style='position:relative;height:36px;display:block'>" +
    "");
    status.includeZoneAltInterface("Internet@BEGIN");
    if (status.includeZoneAltInterface("Internet")) {
      WriteControls_p4_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Internet@BEGIN") || status.HasZoneAltInterface("Internet@END")) {
        status.out.println(
         "<div id='JTWNGHDSFX_boxContent' style='position:relative;height:36px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<input name='IPCOLLEG' id='GOVICFJKZC' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_IPCOLLEG,"C",15,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='ORACOLLEG' id='USFWBVEHFH' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_ORACOLLEG,"T",8,0,SPLib.GetUserDateTimePicture(status.context.GetLanguage(),"DD-MM-YYYY hh:mm:ss"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='13' size='8' fieldtype='T'>" +
      "");
      status.out.println(
       "<input name='DUCOLLEG' id='IKKFZQQTRR' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DUCOLLEG,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KMKAXHABAG_DIV'>" +
       "<label id='KMKAXHABAG' for='GOVICFJKZC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("IP Collegamento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GETFWUXANX_DIV'>" +
       "<label id='GETFWUXANX' for='USFWBVEHFH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Inizio Collegamento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WAAEZAHSYA_DIV'>" +
       "<label id='WAAEZAHSYA' for='IKKFZQQTRR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Durata Collegamento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Internet@BEGIN") || status.HasZoneAltInterface("Internet@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p4_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p4_b1_CloseBand(armt_storfraBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Internet@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Internet")) {
      status.out.println("Ctrl('JTWNGHDSFX').style.height='auto';");
    } else {
      status.out.println("Ctrl('JTWNGHDSFX').setAttribute('band_height',36);");
    }
    status.out.println("Ctrl('JTWNGHDSFX').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p4_b2(armt_storfraBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_HWXHLCWYTW")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_HWXHLCWYTW' style='position:relative;height:2px;display:block' page='4'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_HWXHLCWYTW")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_HWXHLCWYTW').style.height='auto';");
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
  void WriteControls_p4_b3(armt_storfraBO BO,ServletStatus status) {
    status.out.println(
     "<div name='AGE' id='HWXHLCWYTW_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='HWXHLCWYTW_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='HWXHLCWYTW_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Per Agenzia Entrate (Campi modificabili liberamente)")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='HWXHLCWYTW_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"HWXHLCWYTW\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=HWXHLCWYTW_HEADER&m_cBoxId=HWXHLCWYTW&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Per Agenzia Entrate (Campi modificabili liberamente)"))+"");
    }
    status.out.println(
     "<div id='HWXHLCWYTW' class='CollapsibleBody' style='position:relative;height:411px;display:block'>" +
    "");
    status.includeZoneAltInterface("AGE@BEGIN");
    if (status.includeZoneAltInterface("AGE")) {
      WriteControls_p4_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("AGE@BEGIN") || status.HasZoneAltInterface("AGE@END")) {
        status.out.println(
         "<div id='HWXHLCWYTW_boxContent' style='position:relative;height:411px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='OPERAG' id='KZPPWSIAXL' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_OPERAG,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='KZPPWSIAXL_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "KZPPWSIAXL", "tbtipope", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TOMMPAEWKP_DIV'>" +
       "<label id='TOMMPAEWKP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo Operazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FEHZBPHFYP_DIV'>" +
       "<label id='FEHZBPHFYP'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdescopeage)+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='BOISLVXVWN_DIV'>" +
       "<input name='NOPROT' id='BOISLVXVWN' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_NOPROT,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_NOPROT)?"CHECKED":"")+">" +
       "<label id='BOISLVXVWN_LBL' for='BOISLVXVWN' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Non inviare agenzia Entrate"))+"</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RESPINS' id='ZSJIVPTGDO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RESPINS,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HCSIJWCBSM_DIV'>" +
       "<label id='HCSIJWCBSM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Responsabile Inserimento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='INFORM' id='MWCNUZJZYJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_INFORM,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KHKNOZJZIW_DIV'>" +
       "<label id='KHKNOZJZIW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Annotazioni varie:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BDKGZENPXI_DIV'>" +
       "<label id='BDKGZENPXI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("TIPOLOGIA E VALUTAZIONE RISCHIO (IIIa DIRETTIVA)"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NATURA' id='YOYXXFWJYJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NATURA,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SCOPO' id='GPFTVWCTPC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SCOPO,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AREAGEO' id='RTGTOVGSAH' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AREAGEO,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
       "<button id='RTGTOVGSAH_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "RTGTOVGSAH", "tbareegeog", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MODSVOL' id='WZGVCTOIUK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MODSVOL,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
       "<button id='WZGVCTOIUK_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "WZGVCTOIUK", "tbsvolgim", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RAGIO' id='MTCGTVJYAU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RAGIO,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
       "<button id='MTCGTVJYAU_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "MTCGTVJYAU", "tbplauso", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='TIPO' id='NQCYKQCVPJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TIPO,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='NQCYKQCVPJ_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "NQCYKQCVPJ", "tbtiporisc", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VDQYYJXFJQ_DIV'>" +
       "<label id='VDQYYJXFJQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Natura:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='CBVQIGLDDG_DIV'>" +
       "<label id='CBVQIGLDDG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Scopo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JPALOYZWMJ_DIV'>" +
       "<label id='JPALOYZWMJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Area Geografica:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RAREA' id='OVLHZLTRLW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RAREA,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZBPWOBVSVI_DIV'>" +
       "<label id='ZBPWOBVSVI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Svol. Instaurazione Operaz.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZIIDSDAHTP_DIV'>" +
       "<label id='ZIIDSDAHTP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Ragionevolezza Operazione:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='LABEMWHWNX_DIV'>" +
       "<label id='LABEMWHWNX'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo di rischio:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BXWPAZXUPO_DIV'>" +
       "<label id='BXWPAZXUPO'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Es. Natura = Mutuo; Scopo = Acquisto beni di consumo"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BRKYBYMELL_DIV'>" +
       "<label id='BRKYBYMELL'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Valutazione: da 0 a 20 Regolare - da 20 a 30 Attenzione - sopra 30 Anomalia"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RCOMP' id='SSXPWXCJEG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RCOMP,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RRAGIO' id='DPWFRQJRKQ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RRAGIO,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RTIPO' id='NKOMZBCBBR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RTIPO,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RFREQ' id='HJYPHRYRFX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RFREQ,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RIMP' id='IAFRSBROAJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RIMP,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PZNSWKLSER_DIV'>" +
       "<label id='PZNSWKLSER'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Frequenza:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='NIFTBIQAPE_DIV'>" +
       "<label id='NIFTBIQAPE'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Importo:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HZZVSFREZH_DIV'>" +
       "<label id='HZZVSFREZH'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdescareag)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YPTKUXUUNT_DIV'>" +
       "<label id='YPTKUXUUNT'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdescmodsvo)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FMMALABUUY_DIV'>" +
       "<label id='FMMALABUUY'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdescplauso)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='SGFBTJRXOV_DIV'>" +
       "<label id='SGFBTJRXOV'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdesctipor)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YZKNWGMAJQ_DIV'>" +
       "<label id='YZKNWGMAJQ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("TIPOLOGIA RISCHIO"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='JAQTRTMFWG_DIV'>" +
       "<label id='JAQTRTMFWG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("VALUTAZIONE"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DURAT' id='RIGLNJERGO' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DURAT,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
       "<button id='RIGLNJERGO_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "RIGLNJERGO", "tbdurata", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='AMMONT' id='QTLAIWJTIK' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_AMMONT,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
       "<button id='QTLAIWJTIK_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "QTLAIWJTIK", "tbimporto", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='EHGWWNQNIJ_DIV'>" +
       "<label id='EHGWWNQNIJ'>" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdescammo)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BMKTZACCDB_DIV'>" +
       "<label id='BMKTZACCDB'>" +
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
      WriteControls_p4_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p4_b3_CloseBand(armt_storfraBO BO,ServletStatus status) {
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
      status.out.println("Ctrl('HWXHLCWYTW').style.height='auto';");
    } else {
      status.out.println("Ctrl('HWXHLCWYTW').setAttribute('band_height',411);");
    }
    status.out.println("Ctrl('HWXHLCWYTW').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p4_b4(armt_storfraBO BO,ServletStatus status) {
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
  void WriteControls_p5_b0(armt_storfraBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "<div style='position:relative;height:546px'>" +
    "");
    status.out.println(
     "<div id='WDZXXUSHOC_DIV' class='UntitledBox'>" +
     "<div id='WDZXXUSHOC' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='ardt_docfrabo' id='OQWMEPQQNM' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='MHQXMCGOMG_DIV'>" +
     "<label id='MHQXMCGOMG'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("Documento:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='CONNESDOC' id='EOXCZYYEBY' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONNESDOC,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
     "<button id='EOXCZYYEBY_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
     "</button>" +
     ""+EventuallyContextMenu(status, "EOXCZYYEBY", "kersonbo", "", "")+"" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DRRKLKJROO_DIV'>" +
     "<label id='DRRKLKJROO'>" +
     ""+SPLib.ToHTMLRepresentation(BO.w_xRAGSOCDOC)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<div id='UMWUWBXDQZ_DIV' class='UntitledBox'>" +
     "<div id='UMWUWBXDQZ' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<div id='UUQVMJFNZY_DIV' class='UntitledBox'>" +
     "<div id='UUQVMJFNZY' class='BoxBody'>" +
     "</div>" +
     "</div>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='UDYBTFTSHB_DIV'>" +
     "<label id='UDYBTFTSHB'>" +
     ""+SPLib.ToHTMLRepresentation("A01B. Intermediario: "+BO.w_CODINTER)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='KUHVBYTJII_DIV'>" +
     "<label id='KUHVBYTJII'>" +
     ""+SPLib.ToHTMLRepresentation("A11. Dipendenza:"+BO.w_CODDIPE)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='DIUABADXEH_DIV'>" +
     "<label id='DIUABADXEH'>" +
     ""+SPLib.ToHTMLRepresentation("A12B. Città: "+BO.w_DESCCIT)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='JVWAHALTAM_DIV'>" +
     "<label id='JVWAHALTAM'>" +
     ""+SPLib.ToHTMLRepresentation(" A12C. Prov.: "+BO.w_PROVINCIA)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='GRIUAFUQEF_DIV'>" +
     "<label id='GRIUAFUQEF'>" +
     ""+SPLib.ToHTMLRepresentation("A12A. CAB: "+BO.w_CODCAB)+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "<input name='IDFILE' id='PLFKNICHPU' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_IDFILE,"C",60,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='60' size='60' fieldtype='C'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='BNZLNGZOEF_DIV'>" +
     "<label id='BNZLNGZOEF' for='PLFKNICHPU'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("ID File:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<input name='MTCN' id='JDTKGSGMAF' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MTCN,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='10' fieldtype='C' style='display:none'>" +
    "");
    status.out.println(
     "<span class='SPLabel' id='EOJCZFADSY_DIV' style='display:none'>" +
     "<label id='EOJCZFADSY'>" +
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("MTCN:"))+"" +
     "</label>" +
     "</span>" +
    "");
    status.out.println(
     "</div>" +
    "");
  }
  static void PrintState(armt_storfraBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_storfraBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
    if (BO.ardt_wlientifrz.IsUpdated()) {
      BO.m_cWv_ardt_wlientifrz = BO.ardt_wlientifrz.GetContext();
    }
    if (BO.ardt_storsogfraz.IsUpdated()) {
      BO.m_cWv_ardt_storsogfraz = BO.ardt_storsogfraz.GetContext();
    }
    if (BO.ardt_weneficfrz.IsUpdated()) {
      BO.m_cWv_ardt_weneficfrz = BO.ardt_weneficfrz.GetContext();
    }
    if (BO.ardt_werzistifrz.IsUpdated()) {
      BO.m_cWv_ardt_werzistifrz = BO.ardt_werzistifrz.GetContext();
    }
    if (BO.ardt_docfrabo.IsUpdated()) {
      BO.m_cWv_ardt_docfrabo = BO.ardt_docfrabo.GetContext();
    }
  }
  static void PrintStateWorkVars(armt_storfraBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_OPERAG,"C",3,0));
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
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNESDOC,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAOPE,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CDATOPE,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAREG,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGFRAZ,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_COLLEG,"C",11,0));
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
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINCIA,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODCAB,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDFILE,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MTCN,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TOTLIRE,"N",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TOTCONT,"N",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOINF,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDEREG,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGRAP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OPRAP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAPPORTBEN,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OPERATORE,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AUTOM,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGRAP2,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PRGIMPFRZ,"N",15,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_PRGIMPFRZ:BO.w_PRGIMPFRZ,"N",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CDATAOPE,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CDATREG,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IPCOLLEG,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ORACOLLEG,"T",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DUCOLLEG,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ANNOOPE,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATARETT,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_STATOREG,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MITIG,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MITGDOC,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescmodsvo,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescareag,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescplauso,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesctipor,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescopeage,"C",254,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescfreq,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescammo,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xRAGSOCDOC,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_filtro,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_appolire,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xTOTLIRE,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_xTOTCONT,"N",15,2));
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
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVDIP,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CABDIP,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINT,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CABINT,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dataoggi,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_stringaflagrap2,"C",9,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gSblocco,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gStatus,"C",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gDataVaria,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CITINT,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CITDIP,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgDoc,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xcodfisc,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dessta,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragsocalt,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdciticon,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgWU,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAVALI,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATARILASC,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_apporeg,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgDTP,"N",1,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_codazi:BO.m_Ctx.GetCompany(),"C",10,0));
    if (CPLib.eq(BO.m_cWv_ardt_wlientifrz,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_wlientifrz");
    } else if (CPLib.eq(BO.m_cWv_ardt_wlientifrz,"_not_empty_")) {
      BO.m_cWv_ardt_wlientifrz = BO.ardt_wlientifrz.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_wlientifrz,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_wlientifrz,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_storsogfraz,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_storsogfraz");
    } else if (CPLib.eq(BO.m_cWv_ardt_storsogfraz,"_not_empty_")) {
      BO.m_cWv_ardt_storsogfraz = BO.ardt_storsogfraz.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_storsogfraz,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_storsogfraz,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_weneficfrz,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_weneficfrz");
    } else if (CPLib.eq(BO.m_cWv_ardt_weneficfrz,"_not_empty_")) {
      BO.m_cWv_ardt_weneficfrz = BO.ardt_weneficfrz.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_weneficfrz,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_weneficfrz,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_werzistifrz,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_werzistifrz");
    } else if (CPLib.eq(BO.m_cWv_ardt_werzistifrz,"_not_empty_")) {
      BO.m_cWv_ardt_werzistifrz = BO.ardt_werzistifrz.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_werzistifrz,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_werzistifrz,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_docfrabo,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_docfrabo");
    } else if (CPLib.eq(BO.m_cWv_ardt_docfrabo,"_not_empty_")) {
      BO.m_cWv_ardt_docfrabo = BO.ardt_docfrabo.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_docfrabo,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_docfrabo,"C",0,0));
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_storfraBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_HUZWIZYTMV = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_IINONMZPLB = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_PXKFPRTVXX = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_UWUWSYENHG = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_QGPWBVUZYW = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_USZXRLYSFT = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_VPCTBTGNEV = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_CKBXAAYFYL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_RDOJHWCSNP = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_MJDMCPKVHS = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_OJVAARLZEQ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_CKDWHDTZAO = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_SJNCLQSBKG = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ZYUUSRMPQG = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_YPYOQUQUZO = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_FSLWEQSSNU = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_UGBWSZCQRL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_HJOXUPJMAI = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_PYRWIMYTNP = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_BHLGNNSXQY = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_TZFLWDFIAF = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_BTOBVVCOML = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_GLUOTVRWBG = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_TBRVQNQTYO = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_LJUWADMQSL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_FEHZBPHFYP = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_HZZVSFREZH = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_YPTKUXUUNT = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_FMMALABUUY = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_SGFBTJRXOV = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_EHGWWNQNIJ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_BMKTZACCDB = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_AUNJFYUGOI = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_JMALELOJGS = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_DABLCPOUXL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_HSFSPISTIA = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_IAJSGBSETX = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_DRRKLKJROO = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_UDYBTFTSHB = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_KUHVBYTJII = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_DIUABADXEH = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_JVWAHALTAM = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_GRIUAFUQEF = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(745,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(919,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_storfra"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'FCUPIYMFZB':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"FCUPIYMFZB",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,wraziobo,"+"default",l_session)+"'"+"]");
      status.out.print(",'EZPCGCABUD':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"EZPCGCABUD",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcauana,"+"cauinter",l_session)+"'"+"]");
      status.out.print(",'BHDZAMJILO':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"BHDZAMJILO",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcauana,"+"default",l_session)+"'"+"]");
      status.out.print(",'JCKYJRZABA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"JCKYJRZABA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbvalute,"+"default",l_session)+"'"+"]");
      status.out.print(",'RZIQZFKPUE':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"RZIQZFKPUE",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anarapbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'QBLXDBODXR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QBLXDBODXR",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'TCOTJNZLGM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"TCOTJNZLGM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'WBHSORBZAV':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("qbe_tipileg",l_session)+"']");
      status.out.print(",'ULVCBLFVEU':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ULVCBLFVEU",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'TRNDHQYOXC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"TRNDHQYOXC",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'SDKWKBVOVR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SDKWKBVOVR",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'QASGTWMXYC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QASGTWMXYC",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'OGZBJVOVLN':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"OGZBJVOVLN",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,inter2bo,"+"default",l_session)+"'"+"]");
      status.out.print(",'MUTRCJYNJT':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"MUTRCJYNJT",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'CRVLITCYRD':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"CRVLITCYRD",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'NNOUMHTLXJ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NNOUMHTLXJ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,intermbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'SDNFDOJDLP':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SDNFDOJDLP",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'SRWWPHPCUB':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SRWWPHPCUB",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcausin,"+"default",l_session)+"'"+"]");
      status.out.print(",'KZPPWSIAXL':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"KZPPWSIAXL",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipope,"+"default",l_session)+"'"+"]");
      status.out.print(",'RTGTOVGSAH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"RTGTOVGSAH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog,"+"default",l_session)+"'"+"]");
      status.out.print(",'WZGVCTOIUK':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"WZGVCTOIUK",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsvolgim,"+"default",l_session)+"'"+"]");
      status.out.print(",'MTCGTVJYAU':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"MTCGTVJYAU",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbplauso,"+"default",l_session)+"'"+"]");
      status.out.print(",'NQCYKQCVPJ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NQCYKQCVPJ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtiporisc,"+"default",l_session)+"'"+"]");
      status.out.print(",'RIGLNJERGO':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"RIGLNJERGO",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbdurata,"+"default",l_session)+"'"+"]");
      status.out.print(",'QTLAIWJTIK':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QTLAIWJTIK",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbimporto,"+"default",l_session)+"'"+"]");
      status.out.print(",'EOXCZYYEBY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"EOXCZYYEBY",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,kersonbo,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'FCUPIYMFZB':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,wraziobo,"+"default",l_session)+"'"+"]");
      status.out.print(",'EZPCGCABUD':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcauana,"+"cauinter",l_session)+"'"+"]");
      status.out.print(",'BHDZAMJILO':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcauana,"+"default",l_session)+"'"+"]");
      status.out.print(",'JCKYJRZABA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbvalute,"+"default",l_session)+"'"+"]");
      status.out.print(",'RZIQZFKPUE':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anarapbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'QBLXDBODXR':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'TCOTJNZLGM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'ULVCBLFVEU':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'TRNDHQYOXC':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'SDKWKBVOVR':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'QASGTWMXYC':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'OGZBJVOVLN':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,inter2bo,"+"default",l_session)+"'"+"]");
      status.out.print(",'MUTRCJYNJT':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'CRVLITCYRD':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'NNOUMHTLXJ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,intermbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'SDNFDOJDLP':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'SRWWPHPCUB':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcausin,"+"default",l_session)+"'"+"]");
      status.out.print(",'KZPPWSIAXL':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipope,"+"default",l_session)+"'"+"]");
      status.out.print(",'RTGTOVGSAH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog,"+"default",l_session)+"'"+"]");
      status.out.print(",'WZGVCTOIUK':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsvolgim,"+"default",l_session)+"'"+"]");
      status.out.print(",'MTCGTVJYAU':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbplauso,"+"default",l_session)+"'"+"]");
      status.out.print(",'NQCYKQCVPJ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtiporisc,"+"default",l_session)+"'"+"]");
      status.out.print(",'RIGLNJERGO':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbdurata,"+"default",l_session)+"'"+"]");
      status.out.print(",'QTLAIWJTIK':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbimporto,"+"default",l_session)+"'"+"]");
      status.out.print(",'EOXCZYYEBY':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,kersonbo,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_storfra","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_storfra",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("box_HZHFVWKGKP"),"")) {
      status.quoteAndAppend("box_HZHFVWKGKP","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_JOFBXTNMTP"),"")) {
      status.quoteAndAppend("box_JOFBXTNMTP","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_XLSSDAVPDH"),"")) {
      status.quoteAndAppend("box_XLSSDAVPDH","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_HGCXMHOHLD"),"")) {
      status.quoteAndAppend("box_HGCXMHOHLD","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_HXTNEUCQUZ"),"")) {
      status.quoteAndAppend("box_HXTNEUCQUZ","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_KURTXQHCYE"),"")) {
      status.quoteAndAppend("box_KURTXQHCYE","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Intestatari"),"")) {
      status.quoteAndAppend("Intestatari","hide","box");
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
    if (CPLib.eq(status.GetZoneAltInterface("Controparti"),"")) {
      status.quoteAndAppend("Controparti","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("SoggTerzi"),"")) {
      status.quoteAndAppend("SoggTerzi","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_MDLVFVTHTI"),"")) {
      status.quoteAndAppend("box_MDLVFVTHTI","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_XBHGNJLLKW"),"")) {
      status.quoteAndAppend("box_XBHGNJLLKW","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("AGE"),"")) {
      status.quoteAndAppend("AGE","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_EPMKMXEEOS"),"")) {
      status.quoteAndAppend("box_EPMKMXEEOS","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_BAZZCBWNET"),"")) {
      status.quoteAndAppend("box_BAZZCBWNET","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Internet"),"")) {
      status.quoteAndAppend("Internet","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_WDZXXUSHOC"),"")) {
      status.quoteAndAppend("box_WDZXXUSHOC","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_UMWUWBXDQZ"),"")) {
      status.quoteAndAppend("box_UMWUWBXDQZ","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("box_UUQVMJFNZY"),"")) {
      status.quoteAndAppend("box_UUQVMJFNZY","hide","box");
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
  void WriteMainFormScript(armt_storfraBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_storfra',false);");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
      status.out.println("SetCollapsibleCaptions();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('WAAXEDMKXA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WAAXEDMKXA_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NXYGHZZLCG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QSRYXQJCBZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XVLCUXTZXI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EZPCGCABUD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EZPCGCABUD_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BHDZAMJILO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BHDZAMJILO_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MFRSDQPPEY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JCKYJRZABA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QOALLRLDKY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RPHQMPGGQR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KUMAEYPETV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FADDNUEJZJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RZIQZFKPUE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RZIQZFKPUE_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QBLXDBODXR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QBLXDBODXR_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TCOTJNZLGM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TCOTJNZLGM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WBHSORBZAV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TMYVGJFCXV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ULVCBLFVEU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ULVCBLFVEU_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TRNDHQYOXC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TRNDHQYOXC_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KZXSBEEORE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SDKWKBVOVR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SDKWKBVOVR_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('UBEYBTICRP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KWJVJHCAHT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IXODLSKCSA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LVMUPCVGIQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QASGTWMXYC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QASGTWMXYC_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OBBUSHLGFO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OGZBJVOVLN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OGZBJVOVLN_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TYCTKKPTQQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MUTRCJYNJT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MUTRCJYNJT_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YBNJCVPDUM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CRVLITCYRD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CRVLITCYRD_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HWGWORUQJF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KDONRVZYMP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RGKPHWRBRT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NJDOYSOENB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SDNFDOJDLP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SDNFDOJDLP_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VYBZEWHKFF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KZPPWSIAXL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KZPPWSIAXL_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BOISLVXVWN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ZSJIVPTGDO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MWCNUZJZYJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YOYXXFWJYJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('GPFTVWCTPC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RTGTOVGSAH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RTGTOVGSAH_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WZGVCTOIUK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WZGVCTOIUK_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MTCGTVJYAU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MTCGTVJYAU_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NQCYKQCVPJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NQCYKQCVPJ_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OVLHZLTRLW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SSXPWXCJEG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DPWFRQJRKQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NKOMZBCBBR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HJYPHRYRFX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('IAFRSBROAJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RIGLNJERGO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RIGLNJERGO_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QTLAIWJTIK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QTLAIWJTIK_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DOXBACRWUU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OXGBDTWKSX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EOXCZYYEBY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EOXCZYYEBY_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JDTKGSGMAF')) SetDisabled(c,true);");
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
      status.out.println("if (Ctrl('BOAFVDQFRN')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('BOAFVDQFRN',linkpc_url('BOAFVDQFRN'));");
      status.out.println("}");
      status.out.println("if (Ctrl('TQDGESLQVD')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('TQDGESLQVD',linkpc_url('TQDGESLQVD'));");
      status.out.println("}");
      status.out.println("if (Ctrl('OCTDIOXFMI')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('OCTDIOXFMI',linkpc_url('OCTDIOXFMI'));");
      status.out.println("}");
      status.out.println("if (Ctrl('NOKYMTFBFL')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('NOKYMTFBFL',linkpc_url('NOKYMTFBFL'));");
      status.out.println("}");
      status.out.println("if (Ctrl('OQWMEPQQNM')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('OQWMEPQQNM',linkpc_url('OQWMEPQQNM'));");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"edit")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('NJDOYSOENB')) SetDisabled(c,true);");
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
    status.out.println("if (Eq(name,'ardt_wlientifrz')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_wlientifrz")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_storsogfraz')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_storsogfraz")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_weneficfrz')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_weneficfrz")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_werzistifrz')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_werzistifrz")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_docfrabo')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_docfrabo")+"';");
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
      status.out.println("if (Eq(p_uid,'PRGIMPFRZ') || Empty(p_uid)) {");
      status.out.println("l_b2= ! (Eq(op_codazi,m_cCompany));");
      status.out.println("}");
      if (CPLib.eq(status.m_cClientMode,"new")) {
        status.out.println("if (l_b0) {");
        status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_IDBASE','PFRAZIO1');");
        status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
        status.out.println("AutonumberApplet().SetProg('IDBASE',w_IDBASE,op_IDBASE,'C',10,0);");
        status.out.println("AutonumberApplet().SetETName('wraziobo');");
        status.out.println("w_IDBASE=AutonumberApplet().GetAutonumberString('IDBASE');");
        status.out.println("}");
      }
      status.out.println("if (l_b1) {");
      status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_NUMPROG','PFRAZIO2');");
      status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
      status.out.println("AutonumberApplet().SetProg('NUMPROG',w_NUMPROG,op_NUMPROG,'C',11,0);");
      status.out.println("AutonumberApplet().SetETName('wraziobo');");
      status.out.println("w_NUMPROG=AutonumberApplet().GetAutonumberString('NUMPROG');");
      status.out.println("}");
      status.out.println("if (l_b2) {");
      status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_PRGIMPFRZ','PRGIMPFRZ');");
      status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
      status.out.println("AutonumberApplet().SetProg('PRGIMPFRZ',w_PRGIMPFRZ,op_PRGIMPFRZ,'N',15,0);");
      status.out.println("AutonumberApplet().SetETName('wraziobo');");
      status.out.println("w_PRGIMPFRZ=AutonumberApplet().GetAutonumberDouble('PRGIMPFRZ');");
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
      status.out.println("op_PRGIMPFRZ=w_PRGIMPFRZ;");
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
  armt_storfraBO getBO(ServletStatus status) {
    armt_storfraBO BO = new armt_storfraBO(status.context);
    // gli op_ possono essere utilizzati dalla servlet anche prima di essere inizializzati
    BO.op_IDBASE = BO.w_IDBASE;
    BO.op_NUMPROG = BO.w_NUMPROG;
    BO.op_PRGIMPFRZ = BO.w_PRGIMPFRZ;
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_storfraBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("wraziobo",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_storfraBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    if (CPLib.eq(p_cEvent,"Edit Started")) {
      Calculation_NAKGPBRIRV(status,BO);
    }
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Calculation_NAKGPBRIRV(ServletStatus status,armt_storfraBO BO) {
    BO.w_xTOTLIRE = (CPLib.ge(BO.w_DATAOPE,CPLib.CharToDate("20020101")) || CPLib.le(BO.w_datpaseuro,BO.w_DATAOPE)?BO.w_TOTLIRE/100:BO.w_TOTLIRE);
    BO.w_xTOTCONT = (CPLib.ge(BO.w_DATAOPE,CPLib.CharToDate("20020101")) || CPLib.le(BO.w_datpaseuro,BO.w_DATAOPE)?BO.w_TOTCONT/100:BO.w_TOTCONT);
  }
  void WriteTableCombo(ServletStatus status,armt_storfraBO BO) {
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
    status.out.println("var XVLCUXTZXI_Curs = "+l_cTmp+";");
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
    status.out.println("var JCKYJRZABA_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    VQRHolder l_VQRHolder=null;
    SPBridge.HMCaller _h_WBHSORBZAV = new SPBridge.HMCaller();
    _h_WBHSORBZAV.Set("CDATOPE",BO.w_CDATOPE);
    _h_WBHSORBZAV.Set("filtro",BO.w_filtro);
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_tipileg",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),_h_WBHSORBZAV,false);
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
    status.out.println("var WBHSORBZAV_Curs = "+l_cTmp+";");
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
    status.out.println("var OBBUSHLGFO_Curs = "+l_cTmp+";");
  }
  CPResultSet QueryKeyCursor(armt_storfraBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_wraziobo;
    String l_cPhName = BO.m_cPhName_wraziobo;
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
      String l_cQueryFilter = armt_storfraBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_wraziobo+".IDBASE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("wraziobo");
    String l_cPhName = CPSql.ManipulateTablePhName("wraziobo",l_cServer);
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
  void Query(ServletStatus status,armt_storfraBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_storfraBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_wraziobo,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_wraziobo,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_storfraBO BO) {
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
  void Edit(ServletStatus status,armt_storfraBO BO,SPParameterSource source) {
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
  void New(ServletStatus status,armt_storfraBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_storfraBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_storfraBO BO) {
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
  void EditLoad(ServletStatus status,armt_storfraBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_storfraBO BO,SPParameterSource source) {
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
  void DeleteMessage(ServletStatus status,armt_storfraBO BO,SPParameterSource source) {
    BO.Load(status.w_IDBASE);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_storfraBO BO) {
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
    double l_old_PRGIMPFRZ = 0;
    if (CPLib.ne(BO.w_PRGIMPFRZ,BO.op_PRGIMPFRZ)) {
      l_old_PRGIMPFRZ = BO.op_PRGIMPFRZ;
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
      status.m_cOldKeysToRaiseParms = SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0);
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
      if ( ! (CPLib.Empty(l_old_PRGIMPFRZ))) {
        BO.op_PRGIMPFRZ = l_old_PRGIMPFRZ;
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
  void Discard(ServletStatus status,armt_storfraBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_storfraBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",665);
    item.put("w",919);
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
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Intestatari \\/ Operanti Conto Terzi\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Altre Controparti \\/ Altri Soggetti Terzi\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Dati Agenzia Entrate\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Documenti Soggetti\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Principale,Intestatari / Operanti Conto Terzi,Altre Controparti / Altri Soggetti Terzi,Dati Agenzia Entrate,Documenti Soggetti");
    item.put("altInterfaceFor","armt_storfra");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_HZHFVWKGKP\",\"h\":180,\"name\":\"box_HZHFVWKGKP\",\"page\":1,\"shrinkable\":true,\"spuid\":\"HZHFVWKGKP\",\"tabindex\":1,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":7,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"Data Operazione\",\"h\":20,\"maxlength\":10,\"name\":\"DATAOPE\",\"page\":1,\"picker\":true,\"spuid\":\"WAAXEDMKXA\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":136,\"y\":52,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero Progressivo\",\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"NUMPROG\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"XTDANURGMM\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":88,\"x\":408,\"y\":52,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RUVVREGNGP\",\"page\":1,\"spuid\":\"RUVVREGNGP\",\"tabindex\":47,\"type\":\"Label\",\"value\":\"A03. Numero Progressivo:\",\"w\":138,\"x\":267,\"y\":56,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NRJTHQEJCT\",\"page\":1,\"spuid\":\"NRJTHQEJCT\",\"tabindex\":48,\"type\":\"Label\",\"value\":\"A21. Data Operazione:\",\"w\":122,\"x\":13,\"y\":56,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"comment\":\"Data registrazione\",\"h\":20,\"maxlength\":10,\"name\":\"DATAREG\",\"page\":1,\"spuid\":\"NXYGHZZLCG\",\"tabindex\":9,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":72,\"x\":816,\"y\":52,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KZBMHOFWYD\",\"page\":1,\"spuid\":\"KZBMHOFWYD\",\"tabindex\":63,\"type\":\"Label\",\"value\":\"A51. Data registrazione:\",\"w\":129,\"x\":686,\"y\":56,\"zone\":\"pag1_1_2\",\"zonepath\":\"[1,1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Frazionata (S\\/N)\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"FLAGFRAZ\",\"page\":1,\"spuid\":\"QSRYXQJCBZ\",\"tabindex\":10,\"textlist\":\"Normale,Fraz. Trasferita,Multipla\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"0"+"'"+","+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":128,\"x\":136,\"y\":79,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Collegamento Operazione Multiple\",\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"COLLEG\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"FCUPIYMFZB\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":88,\"x\":368,\"y\":79,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Operazione Completa\",\"h\":20,\"maxlength\":2,\"name\":\"TIPOOPRAP\",\"page\":1,\"spuid\":\"XVLCUXTZXI\",\"tabindex\":12,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":296,\"x\":592,\"y\":79,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KJZKHGDTBV\",\"page\":1,\"spuid\":\"KJZKHGDTBV\",\"tabindex\":64,\"type\":\"Label\",\"value\":\"A52. Tipo Operazione:\",\"w\":118,\"x\":474,\"y\":83,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RLUNSWADHC\",\"page\":1,\"spuid\":\"RLUNSWADHC\",\"tabindex\":84,\"type\":\"Label\",\"value\":\"A22. Tipo:\",\"w\":67,\"x\":64,\"y\":83,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CNKLWUVOXA\",\"page\":1,\"spuid\":\"CNKLWUVOXA\",\"tabindex\":85,\"type\":\"Label\",\"value\":\"A53. Collegata a:\",\"w\":98,\"x\":270,\"y\":83,\"zone\":\"pag1_1_3\",\"zonepath\":\"[1,1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Causale Analitica\",\"h\":20,\"maxlength\":4,\"name\":\"CODANA\",\"page\":1,\"picker\":true,\"spuid\":\"EZPCGCABUD\",\"tabindex\":13,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":136,\"y\":106,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Causale Sintetica\",\"h\":20,\"maxlength\":2,\"name\":\"CODVOC\",\"page\":1,\"picker\":true,\"spuid\":\"BHDZAMJILO\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":592,\"y\":106,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RFOXSFMJNY\",\"page\":1,\"spuid\":\"RFOXSFMJNY\",\"tabindex\":54,\"type\":\"Label\",\"value\":\"A24. Causale Analitica:\",\"w\":122,\"x\":13,\"y\":110,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LNDPVLRRZI\",\"page\":1,\"spuid\":\"LNDPVLRRZI\",\"tabindex\":101,\"type\":\"Label\",\"value\":\"A25. Sintetica:\",\"w\":78,\"x\":514,\"y\":110,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"%w_desccauana%\",\"h\":16,\"name\":\"label_OJVAARLZEQ\",\"page\":1,\"spuid\":\"OJVAARLZEQ\",\"tabindex\":102,\"type\":\"Label\",\"w\":310,\"x\":202,\"y\":110,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"%w_xdesccausin%\",\"h\":16,\"name\":\"label_CKDWHDTZAO\",\"page\":1,\"spuid\":\"CKDWHDTZAO\",\"tabindex\":103,\"type\":\"Label\",\"w\":247,\"x\":649,\"y\":110,\"zone\":\"pag1_1_4\",\"zonepath\":\"[1,1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"appolire\",\"page\":1,\"spuid\":\"MFRSDQPPEY\",\"tabindex\":16,\"textlist\":\"Lire,Euro,Valuta Estera\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"L"+"'"+","+"'"+"E"+"'"+","+"'"+"V"+"'"+"\",\"w\":160,\"x\":136,\"y\":133,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Divisa\",\"h\":20,\"maxlength\":3,\"name\":\"VALUTA\",\"page\":1,\"spuid\":\"JCKYJRZABA\",\"tabindex\":17,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":384,\"x\":392,\"y\":133,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CEGQRJFFAZ\",\"page\":1,\"spuid\":\"CEGQRJFFAZ\",\"tabindex\":65,\"type\":\"Label\",\"value\":\"B11. Tipo Divisa:\",\"w\":90,\"x\":45,\"y\":137,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JYQAVTDBKY\",\"page\":1,\"spuid\":\"JYQAVTDBKY\",\"tabindex\":66,\"type\":\"Label\",\"value\":\"B12. Divisa:\",\"w\":62,\"x\":329,\"y\":137,\"zone\":\"pag1_1_5\",\"zonepath\":\"[1,1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":21,\"name\":\"xTOTLIRE\",\"page\":1,\"spuid\":\"QOALLRLDKY\",\"tabindex\":18,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":114,\"x\":136,\"y\":160,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Contanti (S\\/N)\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"FLAGCONT\",\"page\":1,\"spuid\":\"RPHQMPGGQR\",\"tabindex\":19,\"textlist\":\"No,Si\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"0"+"'"+","+"'"+"1"+"'"+"\",\"w\":104,\"x\":360,\"y\":160,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"check\",\"h\":20,\"maxlength\":21,\"name\":\"xTOTCONT\",\"page\":1,\"spuid\":\"KUMAEYPETV\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":114,\"x\":600,\"y\":160,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cambio\",\"h\":20,\"maxlength\":12,\"name\":\"CAMBIO\",\"page\":1,\"spuid\":\"FADDNUEJZJ\",\"tabindex\":21,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":824,\"y\":160,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LQQUOWOYQW\",\"page\":1,\"spuid\":\"LQQUOWOYQW\",\"tabindex\":53,\"type\":\"Label\",\"value\":\"A23. Contanti:\",\"w\":80,\"x\":279,\"y\":164,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Segno\",\"disabled\":\"true\",\"h\":20,\"maxlength\":1,\"name\":\"SEGNO\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"XESWONRBTH\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":872,\"y\":133,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AIRYDUUQZV\",\"page\":1,\"spuid\":\"AIRYDUUQZV\",\"tabindex\":68,\"type\":\"Label\",\"value\":\"B13. Segno:\",\"w\":64,\"x\":807,\"y\":137,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HUZWIZYTMV\",\"page\":1,\"spuid\":\"HUZWIZYTMV\",\"tabindex\":69,\"type\":\"Label\",\"w\":111,\"x\":24,\"y\":164,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PGNMOJFSUL\",\"page\":1,\"spuid\":\"PGNMOJFSUL\",\"tabindex\":70,\"type\":\"Label\",\"value\":\"B15. di cui contanti:\",\"w\":104,\"x\":495,\"y\":164,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TLSZHVBXSN\",\"page\":1,\"spuid\":\"TLSZHVBXSN\",\"tabindex\":74,\"type\":\"Label\",\"value\":\"Cambio:\",\"w\":87,\"x\":736,\"y\":164,\"zone\":\"pag1_1_6\",\"zonepath\":\"[1,1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_JOFBXTNMTP\",\"h\":31,\"name\":\"box_JOFBXTNMTP\",\"page\":1,\"shrinkable\":true,\"spuid\":\"JOFBXTNMTP\",\"tabindex\":2,\"type\":\"Box\",\"w\":880,\"x\":16,\"y\":12,\"zone\":\"pag1_1_7\",\"zonepath\":\"[1,1,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Intermediario\",\"disabled\":\"true\",\"h\":21,\"maxlength\":11,\"name\":\"CODINTER\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"NNOUMHTLXJ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":78,\"x\":138,\"y\":16,\"zone\":\"pag1_1_7_1\",\"zonepath\":\"[1,1,7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_HBLSDWZPZJ\",\"page\":1,\"spuid\":\"HBLSDWZPZJ\",\"tabindex\":50,\"type\":\"Label\",\"value\":\"A01B. Intermediario:\",\"w\":122,\"x\":14,\"y\":20,\"zone\":\"pag1_1_7_1\",\"zonepath\":\"[1,1,7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Dipendenza\",\"h\":21,\"maxlength\":6,\"name\":\"CODDIPE\",\"page\":1,\"picker\":true,\"spuid\":\"SDNFDOJDLP\",\"tabindex\":51,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":342,\"y\":16,\"zone\":\"pag1_1_7_1\",\"zonepath\":\"[1,1,7,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Citt\\u00E0 Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":30,\"name\":\"DESCCIT\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"DHFUAHCMCJ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":160,\"x\":504,\"y\":16,\"zone\":\"pag1_1_7_1\",\"zonepath\":\"[1,1,7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_HZDQOFEXPB\",\"page\":1,\"spuid\":\"HZDQOFEXPB\",\"tabindex\":75,\"type\":\"Label\",\"value\":\"A11. Dipendenza:\",\"w\":93,\"x\":249,\"y\":20,\"zone\":\"pag1_1_7_1\",\"zonepath\":\"[1,1,7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_OIZHYHOJII\",\"page\":1,\"spuid\":\"OIZHYHOJII\",\"tabindex\":76,\"type\":\"Label\",\"value\":\"A12B. Citt\\u00E0:\",\"w\":62,\"x\":443,\"y\":20,\"zone\":\"pag1_1_7_1\",\"zonepath\":\"[1,1,7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_IZRUENEKXU\",\"page\":1,\"spuid\":\"IZRUENEKXU\",\"tabindex\":77,\"type\":\"Label\",\"value\":\"A12C. Prov.:\",\"w\":66,\"x\":672,\"y\":20,\"zone\":\"pag1_1_7_1\",\"zonepath\":\"[1,1,7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_VPEIKRTWFC\",\"page\":1,\"spuid\":\"VPEIKRTWFC\",\"tabindex\":78,\"type\":\"Label\",\"value\":\"A12A. CAB:\",\"w\":64,\"x\":776,\"y\":20,\"zone\":\"pag1_1_7_1\",\"zonepath\":\"[1,1,7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":2,\"name\":\"PROVINCIA\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"QTBRDJZGGM\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":738,\"y\":16,\"zone\":\"pag1_1_7_1\",\"zonepath\":\"[1,1,7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAB Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":6,\"name\":\"CODCAB\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"RIKKHKHPLM\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":838,\"y\":16,\"zone\":\"pag1_1_7_1\",\"zonepath\":\"[1,1,7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_XLSSDAVPDH\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Dati Soggetti\\/Rapporti Coinvolti nell"+"'"+"operazione\",\"h\":171,\"name\":\"box_XLSSDAVPDH\",\"page\":1,\"shrinkable\":true,\"spuid\":\"XLSSDAVPDH\",\"tabindex\":3,\"title_caption\":\"Dati Soggetti\\/Rapporti Coinvolti nell"+"'"+"operazione\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":188,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Rapporto Collegato\",\"h\":20,\"maxlength\":25,\"name\":\"RAPPORTO\",\"page\":1,\"picker\":true,\"spuid\":\"RZIQZFKPUE\",\"tabindex\":22,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":162,\"x\":168,\"y\":197,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EXIXNLTCBE\",\"page\":1,\"spuid\":\"EXIXNLTCBE\",\"tabindex\":61,\"type\":\"Label\",\"value\":\"A41. Rapporto Collegato:\",\"w\":148,\"x\":16,\"y\":201,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_UWUWSYENHG\",\"page\":1,\"spuid\":\"UWUWSYENHG\",\"tabindex\":80,\"type\":\"Label\",\"w\":432,\"x\":352,\"y\":201,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Cliente Occasionale\",\"h\":20,\"maxlength\":16,\"name\":\"CONNESCLI\",\"page\":1,\"picker\":true,\"spuid\":\"QBLXDBODXR\",\"tabindex\":23,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":108,\"x\":168,\"y\":224,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NUEFWOMRRX\",\"page\":1,\"spuid\":\"NUEFWOMRRX\",\"tabindex\":71,\"type\":\"Label\",\"value\":\"C11. Intest. \\/ Cliente Occ.:\",\"w\":155,\"x\":9,\"y\":228,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_PXKFPRTVXX\",\"page\":1,\"spuid\":\"PXKFPRTVXX\",\"tabindex\":79,\"type\":\"Label\",\"w\":456,\"x\":304,\"y\":228,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Cliente Occasionale\",\"h\":20,\"maxlength\":16,\"name\":\"CONNESOPER\",\"page\":1,\"picker\":true,\"spuid\":\"TCOTJNZLGM\",\"tabindex\":24,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":108,\"x\":168,\"y\":251,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IINONMZPLB\",\"page\":1,\"spuid\":\"IINONMZPLB\",\"tabindex\":72,\"type\":\"Label\",\"w\":148,\"x\":16,\"y\":255,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_QGPWBVUZYW\",\"page\":1,\"spuid\":\"QGPWBVUZYW\",\"tabindex\":81,\"type\":\"Label\",\"w\":480,\"x\":304,\"y\":255,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Legame\",\"h\":20,\"maxlength\":1,\"name\":\"TIPOLEG\",\"page\":1,\"spuid\":\"WBHSORBZAV\",\"tabindex\":25,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":360,\"x\":168,\"y\":278,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VECGHPFLII\",\"page\":1,\"spuid\":\"VECGHPFLII\",\"tabindex\":62,\"type\":\"Label\",\"value\":\"A43. Tipo Legame:\",\"w\":132,\"x\":32,\"y\":282,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"h\":21,\"label_text\":\"Soggetto operante utilizza mezzi propri\",\"maxlength\":1,\"name\":\"PAGASOGOP\",\"page\":1,\"spuid\":\"TMYVGJFCXV\",\"tabindex\":26,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":206,\"x\":687,\"y\":278,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Cliente Occasionale\",\"h\":20,\"maxlength\":16,\"name\":\"CONNESBEN\",\"page\":1,\"picker\":true,\"spuid\":\"ULVCBLFVEU\",\"tabindex\":27,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":108,\"x\":168,\"y\":305,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LZDWHHTSGR\",\"page\":1,\"spuid\":\"LZDWHHTSGR\",\"tabindex\":73,\"type\":\"Label\",\"value\":\"C31. Controparte Bonifico:\",\"w\":156,\"x\":8,\"y\":309,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_USZXRLYSFT\",\"page\":1,\"spuid\":\"USZXRLYSFT\",\"tabindex\":82,\"type\":\"Label\",\"w\":480,\"x\":304,\"y\":309,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":16,\"name\":\"CONNALTRO\",\"page\":1,\"picker\":true,\"spuid\":\"TRNDHQYOXC\",\"tabindex\":28,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":108,\"x\":168,\"y\":332,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CKBXAAYFYL\",\"page\":1,\"spuid\":\"CKBXAAYFYL\",\"tabindex\":90,\"type\":\"Label\",\"w\":156,\"x\":8,\"y\":336,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_RDOJHWCSNP\",\"page\":1,\"spuid\":\"RDOJHWCSNP\",\"tabindex\":91,\"type\":\"Label\",\"w\":480,\"x\":304,\"y\":336,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"name\":\"button_XPWBHUQUGP\",\"page\":1,\"picker\":true,\"spuid\":\"XPWBHUQUGP\",\"tabindex\":166,\"type\":\"Button\",\"value\":\"Collega\",\"w\":72,\"x\":824,\"y\":333,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Visualizza i dati del cliente relativi all"+"'"+"operazione\",\"h\":20,\"keep_proportions\":\"bounded\",\"name\":\"image_KMXZXPWLPX\",\"page\":1,\"spuid\":\"KMXZXPWLPX\",\"src\":\"..\\/images\\/search_adm.gif\",\"tabindex\":89,\"type\":\"Image\",\"w\":20,\"x\":873,\"y\":222,\"zone\":\"pag1_2_8\",\"zonepath\":\"[1,2,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_HGCXMHOHLD\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Dati ControParte\",\"h\":90,\"name\":\"box_HGCXMHOHLD\",\"page\":1,\"shrinkable\":true,\"spuid\":\"HGCXMHOHLD\",\"tabindex\":4,\"title_caption\":\"Dati ControParte\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":360,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":70,\"name\":\"C_RAG\",\"page\":1,\"spuid\":\"KZXSBEEORE\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":432,\"x\":168,\"y\":369,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XBDNJBMLGI\",\"page\":1,\"spuid\":\"XBDNJBMLGI\",\"tabindex\":94,\"type\":\"Label\",\"value\":\"F11. Denominazione:\",\"w\":149,\"x\":16,\"y\":373,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":30,\"name\":\"C_CTA\",\"page\":1,\"picker\":true,\"spuid\":\"SDKWKBVOVR\",\"tabindex\":30,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":230,\"x\":168,\"y\":396,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":2,\"name\":\"C_PRV\",\"page\":1,\"spuid\":\"UBEYBTICRP\",\"tabindex\":31,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":488,\"y\":396,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":5,\"name\":\"C_CAP\",\"page\":1,\"spuid\":\"KWJVJHCAHT\",\"tabindex\":32,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":600,\"y\":396,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":6,\"name\":\"C_CAB\",\"page\":1,\"spuid\":\"IXODLSKCSA\",\"tabindex\":33,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":736,\"y\":396,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WOJCGFTQXX\",\"page\":1,\"spuid\":\"WOJCGFTQXX\",\"tabindex\":93,\"type\":\"Label\",\"value\":\"F14C. Prov.:\",\"w\":70,\"x\":416,\"y\":400,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UESICSHRAF\",\"page\":1,\"spuid\":\"UESICSHRAF\",\"tabindex\":97,\"type\":\"Label\",\"value\":\"F16. CAP:\",\"w\":54,\"x\":544,\"y\":400,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_UIURSUTTMA\",\"page\":1,\"spuid\":\"UIURSUTTMA\",\"tabindex\":98,\"type\":\"Label\",\"value\":\"F14A. CAB:\",\"w\":63,\"x\":672,\"y\":400,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IWRBWCCMDJ\",\"page\":1,\"spuid\":\"IWRBWCCMDJ\",\"tabindex\":99,\"type\":\"Label\",\"value\":\"F14B. Comune:\",\"w\":133,\"x\":32,\"y\":400,\"zone\":\"pag1_3_2\",\"zonepath\":\"[1,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":35,\"name\":\"C_IND\",\"page\":1,\"spuid\":\"LVMUPCVGIQ\",\"tabindex\":34,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":222,\"x\":168,\"y\":423,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":3,\"name\":\"C_STA\",\"page\":1,\"picker\":true,\"spuid\":\"QASGTWMXYC\",\"tabindex\":35,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":488,\"y\":423,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HGSPJZYAQK\",\"page\":1,\"spuid\":\"HGSPJZYAQK\",\"tabindex\":95,\"type\":\"Label\",\"value\":\"F13. Stato:\",\"w\":76,\"x\":410,\"y\":427,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ENCKEBCYOC\",\"page\":1,\"spuid\":\"ENCKEBCYOC\",\"tabindex\":96,\"type\":\"Label\",\"value\":\"F15. Indirizzo:\",\"w\":149,\"x\":16,\"y\":427,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_MJDMCPKVHS\",\"page\":1,\"spuid\":\"MJDMCPKVHS\",\"tabindex\":100,\"type\":\"Label\",\"w\":251,\"x\":541,\"y\":427,\"zone\":\"pag1_3_3\",\"zonepath\":\"[1,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_HXTNEUCQUZ\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Dati eventuale Intermediario ControParte\",\"h\":171,\"name\":\"box_HXTNEUCQUZ\",\"page\":1,\"shrinkable\":true,\"spuid\":\"HXTNEUCQUZ\",\"tabindex\":5,\"title_caption\":\"Dati eventuale Intermediario ControParte\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":451,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Intermediario C\\/Parte\",\"h\":20,\"maxlength\":2,\"name\":\"TIPOINT2\",\"page\":1,\"spuid\":\"OBBUSHLGFO\",\"tabindex\":36,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":516,\"x\":168,\"y\":460,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BXZTUYDDHV\",\"page\":1,\"spuid\":\"BXZTUYDDHV\",\"tabindex\":55,\"type\":\"Label\",\"value\":\"A31A. Tipo Intermediario:\",\"w\":136,\"x\":28,\"y\":464,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Intermediario C\\/Parte\",\"h\":20,\"maxlength\":11,\"name\":\"CODINT2\",\"page\":1,\"picker\":true,\"spuid\":\"OGZBJVOVLN\",\"tabindex\":37,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":94,\"x\":168,\"y\":487,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DMUKXNHPIX\",\"page\":1,\"spuid\":\"DMUKXNHPIX\",\"tabindex\":56,\"type\":\"Label\",\"value\":\"A31B. Intermediario C\\/Parte:\",\"w\":154,\"x\":10,\"y\":491,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":50,\"name\":\"DESCINTER\",\"page\":1,\"spuid\":\"TYCTKKPTQQ\",\"tabindex\":38,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":328,\"x\":560,\"y\":487,\"zone\":\"pag1_4_3\",\"zonepath\":\"[1,4,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RPVEUGMVLG\",\"page\":1,\"spuid\":\"RPVEUGMVLG\",\"tabindex\":105,\"type\":\"Label\",\"value\":\"A34. Denominazione:\",\"w\":112,\"x\":449,\"y\":491,\"zone\":\"pag1_4_3\",\"zonepath\":\"[1,4,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Stato Intermediario C\\/Parte\",\"h\":20,\"maxlength\":3,\"name\":\"PAESE\",\"page\":1,\"picker\":true,\"spuid\":\"MUTRCJYNJT\",\"tabindex\":39,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":168,\"y\":514,\"zone\":\"pag1_4_4\",\"zonepath\":\"[1,4,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":25,\"name\":\"C_RAPPORTO\",\"page\":1,\"spuid\":\"YBNJCVPDUM\",\"tabindex\":40,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":168,\"x\":720,\"y\":514,\"zone\":\"pag1_4_4\",\"zonepath\":\"[1,4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZVNEKPSDJI\",\"page\":1,\"spuid\":\"ZVNEKPSDJI\",\"tabindex\":57,\"type\":\"Label\",\"value\":\"A32. Stato UIF:\",\"w\":83,\"x\":82,\"y\":518,\"zone\":\"pag1_4_4\",\"zonepath\":\"[1,4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_VPCTBTGNEV\",\"page\":1,\"spuid\":\"VPCTBTGNEV\",\"tabindex\":83,\"type\":\"Label\",\"w\":328,\"x\":224,\"y\":518,\"zone\":\"pag1_4_4\",\"zonepath\":\"[1,4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RUIGDGZVBM\",\"page\":1,\"spuid\":\"RUIGDGZVBM\",\"tabindex\":92,\"type\":\"Label\",\"value\":\"Conto:\",\"w\":84,\"x\":634,\"y\":518,\"zone\":\"pag1_4_4\",\"zonepath\":\"[1,4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"CAB Intermediario C\\/Parte\",\"h\":20,\"maxlength\":6,\"name\":\"CODCAB2\",\"page\":1,\"picker\":true,\"spuid\":\"CRVLITCYRD\",\"tabindex\":41,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":168,\"y\":541,\"zone\":\"pag1_4_5\",\"zonepath\":\"[1,4,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NSQKCLPTTK\",\"page\":1,\"spuid\":\"NSQKCLPTTK\",\"tabindex\":60,\"type\":\"Label\",\"value\":\"A33A. CAB \\/ Comune:\",\"w\":124,\"x\":40,\"y\":545,\"zone\":\"pag1_4_5\",\"zonepath\":\"[1,4,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_SJNCLQSBKG\",\"page\":1,\"spuid\":\"SJNCLQSBKG\",\"tabindex\":104,\"type\":\"Label\",\"w\":400,\"x\":248,\"y\":545,\"zone\":\"pag1_4_5\",\"zonepath\":\"[1,4,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia Intermediario C\\/Parte\",\"h\":20,\"maxlength\":2,\"name\":\"PROV2\",\"page\":1,\"spuid\":\"HWGWORUQJF\",\"tabindex\":42,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":856,\"y\":568,\"zone\":\"pag1_4_6\",\"zonepath\":\"[1,4,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DFQGTRKLJP\",\"page\":1,\"spuid\":\"DFQGTRKLJP\",\"tabindex\":59,\"type\":\"Label\",\"value\":\"A33C. Provincia:\",\"w\":88,\"x\":766,\"y\":572,\"zone\":\"pag1_4_6\",\"zonepath\":\"[1,4,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":18,\"name\":\"label_LPKMZXAILT\",\"page\":1,\"spuid\":\"LPKMZXAILT\",\"tabindex\":167,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"OPERAZIONE CANCELLATA\",\"w\":192,\"x\":696,\"y\":594,\"zone\":\"pag1_4_7\",\"zonepath\":\"[1,4,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":18,\"name\":\"label_JTSYWOZZQD\",\"page\":1,\"spuid\":\"JTSYWOZZQD\",\"tabindex\":168,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"COPIA OPERAZIONE MODIFICATA\",\"w\":192,\"x\":696,\"y\":594,\"zone\":\"pag1_4_8\",\"zonepath\":\"[1,4,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Denominazione Intermediario C\\/Parte\",\"h\":20,\"maxlength\":30,\"name\":\"DESC2\",\"page\":1,\"spuid\":\"KDONRVZYMP\",\"tabindex\":43,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":280,\"x\":168,\"y\":568,\"zone\":\"pag1_4_9\",\"zonepath\":\"[1,4,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FWWUKUSBMJ\",\"page\":1,\"spuid\":\"FWWUKUSBMJ\",\"tabindex\":58,\"type\":\"Label\",\"value\":\"A33B. Comune per esteso:\",\"w\":141,\"x\":23,\"y\":572,\"zone\":\"pag1_4_9\",\"zonepath\":\"[1,4,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":69,\"name\":\"ZCPARTE\",\"page\":1,\"spuid\":\"RGKPHWRBRT\",\"tabindex\":44,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":426,\"x\":168,\"y\":595,\"zone\":\"pag1_4_10\",\"zonepath\":\"[1,4,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SGPAMGUKLY\",\"page\":1,\"spuid\":\"SGPAMGUKLY\",\"tabindex\":86,\"type\":\"Label\",\"value\":\"Nome per Esteso:\",\"w\":119,\"x\":45,\"y\":599,\"zone\":\"pag1_4_10\",\"zonepath\":\"[1,4,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_KURTXQHCYE\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Dati Rettifiche\",\"h\":36,\"name\":\"box_KURTXQHCYE\",\"page\":1,\"shrinkable\":true,\"spuid\":\"KURTXQHCYE\",\"tabindex\":169,\"title_caption\":\"Dati Rettifiche\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":624,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Rettifica\",\"h\":20,\"maxlength\":10,\"name\":\"DATARETT\",\"page\":1,\"spuid\":\"VYBZEWHKFF\",\"tabindex\":170,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":168,\"y\":633,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ID Registrazione\",\"disabled\":\"true\",\"h\":20,\"maxlength\":20,\"name\":\"IDEREG\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"BFDIPOAGFS\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":138,\"x\":344,\"y\":633,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PXIMPOLVHG\",\"page\":1,\"spuid\":\"PXIMPOLVHG\",\"tabindex\":172,\"type\":\"Label\",\"value\":\"Data Rettifica:\",\"w\":77,\"x\":91,\"y\":637,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NOCRBBFOUY\",\"page\":1,\"spuid\":\"NOCRBBFOUY\",\"tabindex\":173,\"type\":\"Label\",\"value\":\"ID Registrazione:\",\"w\":91,\"x\":253,\"y\":637,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Stato\",\"disabled\":\"true\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"STATOREG\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"OJXGBVSJHY\",\"textlist\":\"0 - Registrazione in essere mai modificata,1 - Registrazione in essere sostitutiva di precedente registrazione,2 - Registrazione annullata (cancellata per rettifica),3 - Registrazione annullata (sostituita per rettifica)\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"0"+"'"+","+"'"+"1"+"'"+","+"'"+"2"+"'"+","+"'"+"3"+"'"+"\",\"w\":352,\"x\":544,\"y\":633,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MBISTIEAGL\",\"page\":1,\"spuid\":\"MBISTIEAGL\",\"tabindex\":175,\"type\":\"Label\",\"value\":\"Stato:\",\"w\":33,\"x\":511,\"y\":637,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_HNGGJVVCNB\",\"h\":45,\"name\":\"box_HNGGJVVCNB\",\"page\":2,\"shrinkable\":true,\"spuid\":\"HNGGJVVCNB\",\"tabindex\":12,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":9,\"zone\":\"pag2_1\",\"zonepath\":\"[2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_EUBBNRKXRL\",\"h\":31,\"name\":\"box_EUBBNRKXRL\",\"page\":2,\"shrinkable\":true,\"spuid\":\"EUBBNRKXRL\",\"tabindex\":13,\"type\":\"Box\",\"w\":880,\"x\":16,\"y\":16,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_YPYOQUQUZO\",\"page\":2,\"spuid\":\"YPYOQUQUZO\",\"tabindex\":14,\"type\":\"Label\",\"w\":204,\"x\":20,\"y\":23,\"zone\":\"pag2_1_1_1\",\"zonepath\":\"[2,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_FSLWEQSSNU\",\"page\":2,\"spuid\":\"FSLWEQSSNU\",\"tabindex\":15,\"type\":\"Label\",\"w\":167,\"x\":241,\"y\":23,\"zone\":\"pag2_1_1_1\",\"zonepath\":\"[2,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_UGBWSZCQRL\",\"page\":2,\"spuid\":\"UGBWSZCQRL\",\"tabindex\":16,\"type\":\"Label\",\"w\":230,\"x\":422,\"y\":23,\"zone\":\"pag2_1_1_1\",\"zonepath\":\"[2,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_HJOXUPJMAI\",\"page\":2,\"spuid\":\"HJOXUPJMAI\",\"tabindex\":17,\"type\":\"Label\",\"w\":93,\"x\":667,\"y\":23,\"zone\":\"pag2_1_1_1\",\"zonepath\":\"[2,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_PYRWIMYTNP\",\"page\":2,\"spuid\":\"PYRWIMYTNP\",\"tabindex\":18,\"type\":\"Label\",\"w\":116,\"x\":770,\"y\":23,\"zone\":\"pag2_1_1_1\",\"zonepath\":\"[2,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Intestatari\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Intestatari\",\"h\":224,\"name\":\"Intestatari\",\"page\":2,\"shrinkable\":true,\"spuid\":\"BDZUATYPMW\",\"tabindex\":8,\"title_caption\":\"Intestatari\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":55,\"zone\":\"pag2_2\",\"zonepath\":\"[2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":216,\"name\":\"ardt_wlientifrz\",\"page\":2,\"spuid\":\"BOAFVDQFRN\",\"tabindex\":9,\"type\":\"Iframe\",\"w\":629,\"x\":152,\"y\":59,\"zone\":\"pag2_2_1\",\"zonepath\":\"[2,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Esecutori\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"iif(w_DATAOPE < CharToDate("+"'"+"20140101"+"'"+"),"+"'"+"Soggetti Operanti Conto Terzi"+"'"+","+"'"+"Esecutori"+"'"+")\",\"h\":179,\"name\":\"Esecutori\",\"page\":2,\"shrinkable\":true,\"spuid\":\"ZYUUSRMPQG\",\"tabindex\":10,\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":280,\"zone\":\"pag2_3\",\"zonepath\":\"[2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":163,\"name\":\"ardt_storsogfraz\",\"page\":2,\"spuid\":\"TQDGESLQVD\",\"tabindex\":11,\"type\":\"Iframe\",\"w\":661,\"x\":129,\"y\":287,\"zone\":\"pag2_3_1\",\"zonepath\":\"[2,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_MDLVFVTHTI\",\"h\":45,\"name\":\"box_MDLVFVTHTI\",\"page\":3,\"shrinkable\":true,\"spuid\":\"MDLVFVTHTI\",\"tabindex\":5,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":9,\"zone\":\"pag3_1\",\"zonepath\":\"[3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_XBHGNJLLKW\",\"h\":31,\"name\":\"box_XBHGNJLLKW\",\"page\":3,\"shrinkable\":true,\"spuid\":\"XBHGNJLLKW\",\"tabindex\":6,\"type\":\"Box\",\"w\":880,\"x\":16,\"y\":16,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_TZFLWDFIAF\",\"page\":3,\"spuid\":\"TZFLWDFIAF\",\"tabindex\":7,\"type\":\"Label\",\"w\":204,\"x\":20,\"y\":23,\"zone\":\"pag3_1_1_1\",\"zonepath\":\"[3,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_BTOBVVCOML\",\"page\":3,\"spuid\":\"BTOBVVCOML\",\"tabindex\":8,\"type\":\"Label\",\"w\":167,\"x\":241,\"y\":23,\"zone\":\"pag3_1_1_1\",\"zonepath\":\"[3,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_GLUOTVRWBG\",\"page\":3,\"spuid\":\"GLUOTVRWBG\",\"tabindex\":9,\"type\":\"Label\",\"w\":230,\"x\":422,\"y\":23,\"zone\":\"pag3_1_1_1\",\"zonepath\":\"[3,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_TBRVQNQTYO\",\"page\":3,\"spuid\":\"TBRVQNQTYO\",\"tabindex\":10,\"type\":\"Label\",\"w\":93,\"x\":667,\"y\":23,\"zone\":\"pag3_1_1_1\",\"zonepath\":\"[3,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_LJUWADMQSL\",\"page\":3,\"spuid\":\"LJUWADMQSL\",\"tabindex\":11,\"type\":\"Label\",\"w\":116,\"x\":770,\"y\":23,\"zone\":\"pag3_1_1_1\",\"zonepath\":\"[3,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Controparti\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Controparti\",\"h\":242,\"name\":\"Controparti\",\"page\":3,\"shrinkable\":true,\"spuid\":\"GTSBULOFTD\",\"tabindex\":1,\"title_caption\":\"Controparti\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":55,\"zone\":\"pag3_2\",\"zonepath\":\"[3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":229,\"name\":\"ardt_weneficfrz\",\"page\":3,\"spuid\":\"OCTDIOXFMI\",\"tabindex\":2,\"type\":\"Iframe\",\"w\":629,\"x\":152,\"y\":59,\"zone\":\"pag3_2_1\",\"zonepath\":\"[3,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"SoggTerzi\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"iif(w_DATAOPE >= CharToDate("+"'"+"20140101"+"'"+"),"+"'"+"Soggetti Terzi:"+"'"+","+"'"+"Titolari Effettivi"+"'"+")\",\"h\":224,\"name\":\"SoggTerzi\",\"page\":3,\"shrinkable\":true,\"spuid\":\"BHLGNNSXQY\",\"tabindex\":3,\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":298,\"zone\":\"pag3_3\",\"zonepath\":\"[3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":217,\"name\":\"ardt_werzistifrz\",\"page\":3,\"spuid\":\"NOKYMTFBFL\",\"tabindex\":4,\"type\":\"Iframe\",\"w\":629,\"x\":152,\"y\":304,\"zone\":\"pag3_3_1\",\"zonepath\":\"[3,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_EPMKMXEEOS\",\"h\":45,\"name\":\"box_EPMKMXEEOS\",\"page\":4,\"shrinkable\":true,\"spuid\":\"EPMKMXEEOS\",\"tabindex\":43,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":9,\"zone\":\"pag4_1\",\"zonepath\":\"[4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_BAZZCBWNET\",\"h\":31,\"name\":\"box_BAZZCBWNET\",\"page\":4,\"shrinkable\":true,\"spuid\":\"BAZZCBWNET\",\"tabindex\":44,\"type\":\"Box\",\"w\":880,\"x\":16,\"y\":16,\"zone\":\"pag4_1_1\",\"zonepath\":\"[4,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_AUNJFYUGOI\",\"page\":4,\"spuid\":\"AUNJFYUGOI\",\"tabindex\":45,\"type\":\"Label\",\"w\":204,\"x\":20,\"y\":23,\"zone\":\"pag4_1_1_1\",\"zonepath\":\"[4,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_JMALELOJGS\",\"page\":4,\"spuid\":\"JMALELOJGS\",\"tabindex\":46,\"type\":\"Label\",\"w\":167,\"x\":241,\"y\":23,\"zone\":\"pag4_1_1_1\",\"zonepath\":\"[4,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_DABLCPOUXL\",\"page\":4,\"spuid\":\"DABLCPOUXL\",\"tabindex\":47,\"type\":\"Label\",\"w\":230,\"x\":422,\"y\":23,\"zone\":\"pag4_1_1_1\",\"zonepath\":\"[4,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_HSFSPISTIA\",\"page\":4,\"spuid\":\"HSFSPISTIA\",\"tabindex\":48,\"type\":\"Label\",\"w\":93,\"x\":667,\"y\":23,\"zone\":\"pag4_1_1_1\",\"zonepath\":\"[4,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_IAJSGBSETX\",\"page\":4,\"spuid\":\"IAJSGBSETX\",\"tabindex\":49,\"type\":\"Label\",\"w\":116,\"x\":770,\"y\":23,\"zone\":\"pag4_1_1_1\",\"zonepath\":\"[4,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Internet\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Dati  Operazione Internet Casino\",\"h\":36,\"name\":\"Internet\",\"page\":4,\"shrinkable\":true,\"spuid\":\"JTWNGHDSFX\",\"tabindex\":50,\"title_caption\":\"Dati  Operazione Internet Casino\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":55,\"zone\":\"pag4_2\",\"zonepath\":\"[4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"IP Collegamento\",\"disabled\":\"true\",\"h\":20,\"maxlength\":15,\"name\":\"IPCOLLEG\",\"page\":4,\"readonly\":\"true\",\"spuid\":\"GOVICFJKZC\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":160,\"y\":64,\"zone\":\"pag4_2_1\",\"zonepath\":\"[4,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Inizio Collegamento\",\"disabled\":\"true\",\"h\":20,\"maxlength\":13,\"name\":\"ORACOLLEG\",\"page\":4,\"readonly\":\"true\",\"spuid\":\"USFWBVEHFH\",\"type\":\"Textbox\",\"typevar\":\"datetime\",\"w\":112,\"x\":384,\"y\":64,\"zone\":\"pag4_2_1\",\"zonepath\":\"[4,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Durata Collegamento\",\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"DUCOLLEG\",\"page\":4,\"readonly\":\"true\",\"spuid\":\"IKKFZQQTRR\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":616,\"y\":64,\"zone\":\"pag4_2_1\",\"zonepath\":\"[4,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KMKAXHABAG\",\"page\":4,\"spuid\":\"KMKAXHABAG\",\"tabindex\":54,\"type\":\"Label\",\"value\":\"IP Collegamento:\",\"w\":90,\"x\":70,\"y\":68,\"zone\":\"pag4_2_1\",\"zonepath\":\"[4,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GETFWUXANX\",\"page\":4,\"spuid\":\"GETFWUXANX\",\"tabindex\":55,\"type\":\"Label\",\"value\":\"Inizio Collegamento:\",\"w\":106,\"x\":278,\"y\":68,\"zone\":\"pag4_2_1\",\"zonepath\":\"[4,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WAAEZAHSYA\",\"page\":4,\"spuid\":\"WAAEZAHSYA\",\"tabindex\":56,\"type\":\"Label\",\"value\":\"Durata Collegamento:\",\"w\":115,\"x\":501,\"y\":68,\"zone\":\"pag4_2_1\",\"zonepath\":\"[4,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"AGE\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Dati Per Agenzia Entrate (Campi modificabili liberamente)\",\"h\":411,\"name\":\"AGE\",\"page\":4,\"shrinkable\":true,\"spuid\":\"HWXHLCWYTW\",\"tabindex\":1,\"title_caption\":\"Dati Per Agenzia Entrate (Campi modificabili liberamente)\",\"titled\":true,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":93,\"zone\":\"pag4_3\",\"zonepath\":\"[4,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":3,\"name\":\"OPERAG\",\"page\":4,\"picker\":true,\"spuid\":\"KZPPWSIAXL\",\"tabindex\":2,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":38,\"x\":160,\"y\":128,\"zone\":\"pag4_3_1\",\"zonepath\":\"[4,3,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TOMMPAEWKP\",\"page\":4,\"spuid\":\"TOMMPAEWKP\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Tipo Operazione:\",\"w\":82,\"x\":76,\"y\":132,\"zone\":\"pag4_3_1\",\"zonepath\":\"[4,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_FEHZBPHFYP\",\"page\":4,\"spuid\":\"FEHZBPHFYP\",\"tabindex\":4,\"type\":\"Label\",\"w\":560,\"x\":224,\"y\":131,\"zone\":\"pag4_3_1\",\"zonepath\":\"[4,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"h\":21,\"label_text\":\"Non inviare agenzia Entrate\",\"maxlength\":2,\"name\":\"NOPROT\",\"page\":4,\"spuid\":\"BOISLVXVWN\",\"tabindex\":5,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":168,\"x\":727,\"y\":100,\"zone\":\"pag4_3_2\",\"zonepath\":\"[4,3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":30,\"name\":\"RESPINS\",\"page\":4,\"spuid\":\"ZSJIVPTGDO\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":208,\"x\":160,\"y\":155,\"zone\":\"pag4_3_3\",\"zonepath\":\"[4,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HCSIJWCBSM\",\"page\":4,\"spuid\":\"HCSIJWCBSM\",\"tabindex\":7,\"type\":\"Label\",\"value\":\"Responsabile Inserimento:\",\"w\":127,\"x\":31,\"y\":159,\"zone\":\"pag4_3_3\",\"zonepath\":\"[4,3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":30,\"name\":\"INFORM\",\"page\":4,\"spuid\":\"MWCNUZJZYJ\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":694,\"y\":155,\"zone\":\"pag4_3_4\",\"zonepath\":\"[4,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KHKNOZJZIW\",\"page\":4,\"spuid\":\"KHKNOZJZIW\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"Annotazioni varie:\",\"w\":92,\"x\":598,\"y\":159,\"zone\":\"pag4_3_4\",\"zonepath\":\"[4,3,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":50,\"name\":\"NATURA\",\"page\":4,\"spuid\":\"YOYXXFWJYJ\",\"tabindex\":11,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":160,\"y\":182,\"zone\":\"pag4_3_5\",\"zonepath\":\"[4,3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VDQYYJXFJQ\",\"page\":4,\"spuid\":\"VDQYYJXFJQ\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"Natura:\",\"w\":124,\"x\":32,\"y\":186,\"zone\":\"pag4_3_5\",\"zonepath\":\"[4,3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_BXWPAZXUPO\",\"page\":4,\"spuid\":\"BXWPAZXUPO\",\"tabindex\":24,\"type\":\"Label\",\"value\":\"Es. Natura = Mutuo; Scopo = Acquisto beni di consumo\",\"w\":265,\"x\":496,\"y\":186,\"zone\":\"pag4_3_5\",\"zonepath\":\"[4,3,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":50,\"name\":\"SCOPO\",\"page\":4,\"spuid\":\"GPFTVWCTPC\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":160,\"y\":209,\"zone\":\"pag4_3_6\",\"zonepath\":\"[4,3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CBVQIGLDDG\",\"page\":4,\"spuid\":\"CBVQIGLDDG\",\"tabindex\":18,\"type\":\"Label\",\"value\":\"Scopo:\",\"w\":124,\"x\":32,\"y\":213,\"zone\":\"pag4_3_6\",\"zonepath\":\"[4,3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_BRKYBYMELL\",\"page\":4,\"spuid\":\"BRKYBYMELL\",\"tabindex\":25,\"type\":\"Label\",\"value\":\"Valutazione: da 0 a 20 Regolare - da 20 a 30 Attenzione - sopra 30 Anomalia\",\"w\":403,\"x\":496,\"y\":213,\"zone\":\"pag4_3_6\",\"zonepath\":\"[4,3,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_BDKGZENPXI\",\"page\":4,\"spuid\":\"BDKGZENPXI\",\"tabindex\":10,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"TIPOLOGIA E VALUTAZIONE RISCHIO (IIIa DIRETTIVA)\",\"w\":896,\"x\":8,\"y\":236,\"zone\":\"pag4_3_7\",\"zonepath\":\"[4,3,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"AREAGEO\",\"page\":4,\"picker\":true,\"spuid\":\"RTGTOVGSAH\",\"tabindex\":13,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":46,\"x\":160,\"y\":325,\"zone\":\"pag4_3_8\",\"zonepath\":\"[4,3,8]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JPALOYZWMJ\",\"page\":4,\"spuid\":\"JPALOYZWMJ\",\"tabindex\":19,\"type\":\"Label\",\"value\":\"Area Geografica:\",\"w\":124,\"x\":32,\"y\":329,\"zone\":\"pag4_3_8\",\"zonepath\":\"[4,3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PZNSWKLSER\",\"page\":4,\"spuid\":\"PZNSWKLSER\",\"tabindex\":31,\"type\":\"Label\",\"value\":\"Frequenza:\",\"w\":55,\"x\":101,\"y\":281,\"zone\":\"pag4_3_8\",\"zonepath\":\"[4,3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NIFTBIQAPE\",\"page\":4,\"spuid\":\"NIFTBIQAPE\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"Importo:\",\"w\":55,\"x\":101,\"y\":305,\"zone\":\"pag4_3_8\",\"zonepath\":\"[4,3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_HZZVSFREZH\",\"page\":4,\"spuid\":\"HZZVSFREZH\",\"tabindex\":33,\"type\":\"Label\",\"w\":416,\"x\":232,\"y\":329,\"zone\":\"pag4_3_8\",\"zonepath\":\"[4,3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_YZKNWGMAJQ\",\"page\":4,\"spuid\":\"YZKNWGMAJQ\",\"tabindex\":37,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"TIPOLOGIA RISCHIO\",\"w\":440,\"x\":24,\"y\":257,\"zone\":\"pag4_3_8\",\"zonepath\":\"[4,3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"DURAT\",\"page\":4,\"picker\":true,\"spuid\":\"RIGLNJERGO\",\"tabindex\":39,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":46,\"x\":160,\"y\":277,\"zone\":\"pag4_3_8\",\"zonepath\":\"[4,3,8]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"AMMONT\",\"page\":4,\"picker\":true,\"spuid\":\"QTLAIWJTIK\",\"tabindex\":40,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":46,\"x\":160,\"y\":301,\"zone\":\"pag4_3_8\",\"zonepath\":\"[4,3,8]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_EHGWWNQNIJ\",\"page\":4,\"spuid\":\"EHGWWNQNIJ\",\"tabindex\":41,\"type\":\"Label\",\"w\":416,\"x\":232,\"y\":305,\"zone\":\"pag4_3_8\",\"zonepath\":\"[4,3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_BMKTZACCDB\",\"page\":4,\"spuid\":\"BMKTZACCDB\",\"tabindex\":42,\"type\":\"Label\",\"w\":416,\"x\":232,\"y\":281,\"zone\":\"pag4_3_8\",\"zonepath\":\"[4,3,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"MODSVOL\",\"page\":4,\"picker\":true,\"spuid\":\"WZGVCTOIUK\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":46,\"x\":160,\"y\":349,\"zone\":\"pag4_3_9\",\"zonepath\":\"[4,3,9]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZBPWOBVSVI\",\"page\":4,\"spuid\":\"ZBPWOBVSVI\",\"tabindex\":21,\"type\":\"Label\",\"value\":\"Svol. Instaurazione Operaz.:\",\"w\":139,\"x\":17,\"y\":353,\"zone\":\"pag4_3_9\",\"zonepath\":\"[4,3,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_YPTKUXUUNT\",\"page\":4,\"spuid\":\"YPTKUXUUNT\",\"tabindex\":34,\"type\":\"Label\",\"w\":416,\"x\":232,\"y\":353,\"zone\":\"pag4_3_9\",\"zonepath\":\"[4,3,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"RAGIO\",\"page\":4,\"picker\":true,\"spuid\":\"MTCGTVJYAU\",\"tabindex\":15,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":46,\"x\":160,\"y\":373,\"zone\":\"pag4_3_10\",\"zonepath\":\"[4,3,10]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZIIDSDAHTP\",\"page\":4,\"spuid\":\"ZIIDSDAHTP\",\"tabindex\":22,\"type\":\"Label\",\"value\":\"Ragionevolezza Operazione:\",\"w\":137,\"x\":19,\"y\":377,\"zone\":\"pag4_3_10\",\"zonepath\":\"[4,3,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_FMMALABUUY\",\"page\":4,\"spuid\":\"FMMALABUUY\",\"tabindex\":35,\"type\":\"Label\",\"w\":416,\"x\":232,\"y\":377,\"zone\":\"pag4_3_10\",\"zonepath\":\"[4,3,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":3,\"name\":\"TIPO\",\"page\":4,\"picker\":true,\"spuid\":\"NQCYKQCVPJ\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":46,\"x\":160,\"y\":397,\"zone\":\"pag4_3_11\",\"zonepath\":\"[4,3,11]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LABEMWHWNX\",\"page\":4,\"spuid\":\"LABEMWHWNX\",\"tabindex\":23,\"type\":\"Label\",\"value\":\"Tipo di rischio:\",\"w\":129,\"x\":27,\"y\":401,\"zone\":\"pag4_3_11\",\"zonepath\":\"[4,3,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_SGFBTJRXOV\",\"page\":4,\"spuid\":\"SGFBTJRXOV\",\"tabindex\":36,\"type\":\"Label\",\"w\":416,\"x\":232,\"y\":401,\"zone\":\"pag4_3_11\",\"zonepath\":\"[4,3,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RAREA\",\"page\":4,\"spuid\":\"OVLHZLTRLW\",\"tabindex\":20,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":846,\"y\":325,\"zone\":\"pag4_3_12\",\"zonepath\":\"[4,3,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RCOMP\",\"page\":4,\"spuid\":\"SSXPWXCJEG\",\"tabindex\":26,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":846,\"y\":349,\"zone\":\"pag4_3_13\",\"zonepath\":\"[4,3,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RRAGIO\",\"page\":4,\"spuid\":\"DPWFRQJRKQ\",\"tabindex\":27,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":846,\"y\":373,\"zone\":\"pag4_3_14\",\"zonepath\":\"[4,3,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RTIPO\",\"page\":4,\"spuid\":\"NKOMZBCBBR\",\"tabindex\":28,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":846,\"y\":397,\"zone\":\"pag4_3_15\",\"zonepath\":\"[4,3,15]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RFREQ\",\"page\":4,\"spuid\":\"HJYPHRYRFX\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":846,\"y\":277,\"zone\":\"pag4_3_16\",\"zonepath\":\"[4,3,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_JAQTRTMFWG\",\"page\":4,\"spuid\":\"JAQTRTMFWG\",\"tabindex\":38,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"VALUTAZIONE\",\"w\":120,\"x\":766,\"y\":257,\"zone\":\"pag4_3_16\",\"zonepath\":\"[4,3,16]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RIMP\",\"page\":4,\"spuid\":\"IAFRSBROAJ\",\"tabindex\":30,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":846,\"y\":301,\"zone\":\"pag4_3_17\",\"zonepath\":\"[4,3,17]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_CPZDORVHLG\",\"page\":4,\"spuid\":\"CPZDORVHLG\",\"tabindex\":57,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"MITIGAZIONE RISCHIO\",\"w\":896,\"x\":8,\"y\":432,\"zone\":\"pag4_3_18\",\"zonepath\":\"[4,3,18]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Mitigazione (+\\/-)\",\"h\":20,\"maxlength\":5,\"name\":\"MITIG\",\"page\":4,\"spuid\":\"DOXBACRWUU\",\"tabindex\":58,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":160,\"y\":450,\"zone\":\"pag4_3_19\",\"zonepath\":\"[4,3,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VCBMHLXJMD\",\"page\":4,\"spuid\":\"VCBMHLXJMD\",\"tabindex\":59,\"type\":\"Label\",\"value\":\"Mitigazione (+\\/-):\",\"w\":128,\"x\":32,\"y\":454,\"zone\":\"pag4_3_19\",\"zonepath\":\"[4,3,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_NKPWKMDXUR\",\"page\":4,\"spuid\":\"NKPWKMDXUR\",\"tabindex\":62,\"type\":\"Label\",\"value\":\"%\",\"w\":22,\"x\":203,\"y\":454,\"zone\":\"pag4_3_19\",\"zonepath\":\"[4,3,19]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Documentazione Mitigazione\",\"h\":20,\"maxlength\":100,\"name\":\"MITGDOC\",\"page\":4,\"spuid\":\"OXGBDTWKSX\",\"tabindex\":60,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":612,\"x\":160,\"y\":474,\"zone\":\"pag4_3_20\",\"zonepath\":\"[4,3,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PKJNNGBWFM\",\"page\":4,\"spuid\":\"PKJNNGBWFM\",\"tabindex\":61,\"type\":\"Label\",\"value\":\"Documentazione Mitigazione:\",\"w\":152,\"x\":8,\"y\":478,\"zone\":\"pag4_3_20\",\"zonepath\":\"[4,3,20]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_UMWUWBXDQZ\",\"h\":45,\"name\":\"box_UMWUWBXDQZ\",\"page\":5,\"shrinkable\":true,\"spuid\":\"UMWUWBXDQZ\",\"tabindex\":7,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":9,\"zone\":\"pag5_1\",\"zonepath\":\"[5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_UUQVMJFNZY\",\"h\":31,\"name\":\"box_UUQVMJFNZY\",\"page\":5,\"shrinkable\":true,\"spuid\":\"UUQVMJFNZY\",\"tabindex\":8,\"type\":\"Box\",\"w\":880,\"x\":16,\"y\":16,\"zone\":\"pag5_1_1\",\"zonepath\":\"[5,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_UDYBTFTSHB\",\"page\":5,\"spuid\":\"UDYBTFTSHB\",\"tabindex\":9,\"type\":\"Label\",\"w\":204,\"x\":20,\"y\":23,\"zone\":\"pag5_1_1_1\",\"zonepath\":\"[5,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_KUHVBYTJII\",\"page\":5,\"spuid\":\"KUHVBYTJII\",\"tabindex\":10,\"type\":\"Label\",\"w\":167,\"x\":241,\"y\":23,\"zone\":\"pag5_1_1_1\",\"zonepath\":\"[5,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_DIUABADXEH\",\"page\":5,\"spuid\":\"DIUABADXEH\",\"tabindex\":11,\"type\":\"Label\",\"w\":230,\"x\":422,\"y\":23,\"zone\":\"pag5_1_1_1\",\"zonepath\":\"[5,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_JVWAHALTAM\",\"page\":5,\"spuid\":\"JVWAHALTAM\",\"tabindex\":12,\"type\":\"Label\",\"w\":93,\"x\":667,\"y\":23,\"zone\":\"pag5_1_1_1\",\"zonepath\":\"[5,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_GRIUAFUQEF\",\"page\":5,\"spuid\":\"GRIUAFUQEF\",\"tabindex\":13,\"type\":\"Label\",\"w\":116,\"x\":770,\"y\":23,\"zone\":\"pag5_1_1_1\",\"zonepath\":\"[5,1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"box_WDZXXUSHOC\",\"h\":486,\"name\":\"box_WDZXXUSHOC\",\"page\":5,\"shrinkable\":true,\"spuid\":\"WDZXXUSHOC\",\"tabindex\":1,\"type\":\"Box\",\"w\":896,\"x\":8,\"y\":55,\"zone\":\"pag5_2\",\"zonepath\":\"[5,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MHQXMCGOMG\",\"page\":5,\"spuid\":\"MHQXMCGOMG\",\"tabindex\":3,\"type\":\"Label\",\"value\":\"Documento:\",\"w\":90,\"x\":-10,\"y\":68,\"zone\":\"pag5_2_1\",\"zonepath\":\"[5,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Storico Documenti\",\"h\":20,\"maxlength\":50,\"name\":\"CONNESDOC\",\"page\":5,\"picker\":true,\"spuid\":\"EOXCZYYEBY\",\"tabindex\":4,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":80,\"y\":64,\"zone\":\"pag5_2_1\",\"zonepath\":\"[5,2,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_DRRKLKJROO\",\"page\":5,\"spuid\":\"DRRKLKJROO\",\"tabindex\":5,\"type\":\"Label\",\"w\":480,\"x\":416,\"y\":68,\"zone\":\"pag5_2_1\",\"zonepath\":\"[5,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ID File\",\"disabled\":\"true\",\"h\":20,\"maxlength\":60,\"name\":\"IDFILE\",\"page\":5,\"readonly\":\"true\",\"spuid\":\"PLFKNICHPU\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":372,\"x\":80,\"y\":91,\"zone\":\"pag5_2_2\",\"zonepath\":\"[5,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BNZLNGZOEF\",\"page\":5,\"spuid\":\"BNZLNGZOEF\",\"tabindex\":15,\"type\":\"Label\",\"value\":\"ID File:\",\"w\":34,\"x\":46,\"y\":95,\"zone\":\"pag5_2_2\",\"zonepath\":\"[5,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":413,\"name\":\"ardt_docfrabo\",\"page\":5,\"spuid\":\"OQWMEPQQNM\",\"tabindex\":2,\"type\":\"Iframe\",\"w\":686,\"x\":135,\"y\":118,\"zone\":\"pag5_2_3\",\"zonepath\":\"[5,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"MTCN\",\"h\":20,\"maxlength\":10,\"name\":\"MTCN\",\"page\":5,\"spuid\":\"JDTKGSGMAF\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":818,\"y\":91,\"zone\":\"pag5_2_3\",\"zonepath\":\"[5,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EOJCZFADSY\",\"page\":5,\"spuid\":\"EOJCZFADSY\",\"tabindex\":17,\"type\":\"Label\",\"value\":\"MTCN:\",\"w\":32,\"x\":786,\"y\":95,\"zone\":\"pag5_2_3\",\"zonepath\":\"[5,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_storfraBO BO,ServletStatus status) {
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
     "<script src='armt_storfra?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_storfra_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_storfra_edit.js'>" +
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
      status.out.println("w_OPERAG=a[0];");
      status.out.println("w_NOPROT=a[1];");
      status.out.println("w_RESPINS=a[2];");
      status.out.println("w_INFORM=a[3];");
      status.out.println("w_NATURA=a[4];");
      status.out.println("w_SCOPO=a[5];");
      status.out.println("w_AREAGEO=a[6];");
      status.out.println("w_MODSVOL=a[7];");
      status.out.println("w_RAGIO=a[8];");
      status.out.println("w_TIPO=a[9];");
      status.out.println("w_RAREA=a[10];");
      status.out.println("w_RCOMP=a[11];");
      status.out.println("w_RRAGIO=a[12];");
      status.out.println("w_RTIPO=a[13];");
      status.out.println("w_RFREQ=a[14];");
      status.out.println("w_RIMP=a[15];");
      status.out.println("w_DURAT=a[16];");
      status.out.println("w_AMMONT=a[17];");
      status.out.println("w_CONNESDOC=a[18];");
      status.out.println("w_DATAOPE=a[19];");
      status.out.println("w_CDATOPE=a[20];");
      status.out.println("w_DATAREG=a[21];");
      status.out.println("w_FLAGFRAZ=a[22];");
      status.out.println("w_COLLEG=a[23];");
      status.out.println("w_TIPOOPRAP=a[24];");
      status.out.println("w_CODANA=a[25];");
      status.out.println("w_CODVOC=a[26];");
      status.out.println("w_FLAGLIRE=a[27];");
      status.out.println("w_VALUTA=a[28];");
      status.out.println("w_FLAGCONT=a[29];");
      status.out.println("w_CAMBIO=a[30];");
      status.out.println("w_RAPPORTO=a[31];");
      status.out.println("w_CONNESCLI=a[32];");
      status.out.println("w_CONNESOPER=a[33];");
      status.out.println("w_TIPOLEG=a[34];");
      status.out.println("w_PAGASOGOP=a[35];");
      status.out.println("w_CONNESBEN=a[36];");
      status.out.println("w_CONNALTRO=a[37];");
      status.out.println("w_C_RAG=a[38];");
      status.out.println("w_C_CTA=a[39];");
      status.out.println("w_C_PRV=a[40];");
      status.out.println("w_C_CAP=a[41];");
      status.out.println("w_C_CAB=a[42];");
      status.out.println("w_C_IND=a[43];");
      status.out.println("w_C_STA=a[44];");
      status.out.println("w_TIPOINT2=a[45];");
      status.out.println("w_CODINT2=a[46];");
      status.out.println("w_DESCINTER=a[47];");
      status.out.println("w_PAESE=a[48];");
      status.out.println("w_C_RAPPORTO=a[49];");
      status.out.println("w_CODCAB2=a[50];");
      status.out.println("w_PROV2=a[51];");
      status.out.println("w_DESC2=a[52];");
      status.out.println("w_ZCPARTE=a[53];");
      status.out.println("w_IDBASE=a[54];");
      status.out.println("op_IDBASE=a[55];");
      status.out.println("w_NUMPROG=a[56];");
      status.out.println("op_NUMPROG=a[57];");
      status.out.println("w_CODINTER=a[58];");
      status.out.println("w_CODDIPE=a[59];");
      status.out.println("w_DESCCIT=a[60];");
      status.out.println("w_SEGNO=a[61];");
      status.out.println("w_PROVINCIA=a[62];");
      status.out.println("w_CODCAB=a[63];");
      status.out.println("w_IDFILE=a[64];");
      status.out.println("w_MTCN=a[65];");
      status.out.println("w_TOTLIRE=a[66];");
      status.out.println("w_TOTCONT=a[67];");
      status.out.println("w_TIPOINF=a[68];");
      status.out.println("w_IDEREG=a[69];");
      status.out.println("w_FLAGRAP=a[70];");
      status.out.println("w_OPRAP=a[71];");
      status.out.println("w_RAPPORTBEN=a[72];");
      status.out.println("w_OPERATORE=a[73];");
      status.out.println("w_AUTOM=a[74];");
      status.out.println("w_FLAGRAP2=a[75];");
      status.out.println("w_PRGIMPFRZ=a[76];");
      status.out.println("op_PRGIMPFRZ=a[77];");
      status.out.println("w_CDATAOPE=a[78];");
      status.out.println("w_CDATREG=a[79];");
      status.out.println("w_IPCOLLEG=a[80];");
      status.out.println("w_ORACOLLEG=a[81];");
      status.out.println("w_DUCOLLEG=a[82];");
      status.out.println("w_ANNOOPE=a[83];");
      status.out.println("w_DATARETT=a[84];");
      status.out.println("w_STATOREG=a[85];");
      status.out.println("w_MITIG=a[86];");
      status.out.println("w_MITGDOC=a[87];");
      status.out.println("w_xdescmodsvo=a[88];");
      status.out.println("w_xdescareag=a[89];");
      status.out.println("w_xdescplauso=a[90];");
      status.out.println("w_xdesctipor=a[91];");
      status.out.println("w_xdescopeage=a[92];");
      status.out.println("w_xdescfreq=a[93];");
      status.out.println("w_xdescammo=a[94];");
      status.out.println("w_xRAGSOCDOC=a[95];");
      status.out.println("w_filtro=a[96];");
      status.out.println("w_appolire=a[97];");
      status.out.println("w_xTOTLIRE=a[98];");
      status.out.println("w_xTOTCONT=a[99];");
      status.out.println("w_tipope=a[100];");
      status.out.println("w_gIntemediario=a[101];");
      status.out.println("w_xdes1=a[102];");
      status.out.println("w_desccauana=a[103];");
      status.out.println("w_xdesccausin=a[104];");
      status.out.println("w_descdiv=a[105];");
      status.out.println("w_xragsocper=a[106];");
      status.out.println("w_xdescrap=a[107];");
      status.out.println("w_xragsocct=a[108];");
      status.out.println("w_xragsocben=a[109];");
      status.out.println("w_xdestipleg=a[110];");
      status.out.println("w_xragint2=a[111];");
      status.out.println("w_xdescpaese2=a[112];");
      status.out.println("w_datpaseuro=a[113];");
      status.out.println("w_xDescDipe=a[114];");
      status.out.println("w_sEdit=a[115];");
      status.out.println("w_gChkDate=a[116];");
      status.out.println("w_errmsg=a[117];");
      status.out.println("w_test=a[118];");
      status.out.println("w_valflg2=a[119];");
      status.out.println("w_gTipInter=a[120];");
      status.out.println("w_PROVDIP=a[121];");
      status.out.println("w_CABDIP=a[122];");
      status.out.println("w_PROVINT=a[123];");
      status.out.println("w_CABINT=a[124];");
      status.out.println("w_dataoggi=a[125];");
      status.out.println("w_stringaflagrap2=a[126];");
      status.out.println("w_gSblocco=a[127];");
      status.out.println("w_gStatus=a[128];");
      status.out.println("w_gDataVaria=a[129];");
      status.out.println("w_CITINT=a[130];");
      status.out.println("w_CITDIP=a[131];");
      status.out.println("w_gFlgDoc=a[132];");
      status.out.println("w_xcodfisc=a[133];");
      status.out.println("w_dessta=a[134];");
      status.out.println("w_xragsocalt=a[135];");
      status.out.println("w_xdciticon=a[136];");
      status.out.println("w_gFlgWU=a[137];");
      status.out.println("w_DATAVALI=a[138];");
      status.out.println("w_DATARILASC=a[139];");
      status.out.println("w_apporeg=a[140];");
      status.out.println("w_gFlgDTP=a[141];");
      status.out.println("op_codazi=a[142];");
      status.out.println("o_HGCXMHOHLD_expand=null;");
      status.out.println("o_HXTNEUCQUZ_expand=null;");
      status.out.println("m_cWv_ardt_wlientifrz=a[143];");
      status.out.println("m_cWv_ardt_storsogfraz=a[144];");
      status.out.println("m_cWv_ardt_weneficfrz=a[145];");
      status.out.println("m_cWv_ardt_werzistifrz=a[146];");
      status.out.println("m_cWv_ardt_docfrabo=a[147];;");
      status.out.println("if (Gt(a.length,148)) {");
      status.out.println("m_cErrorInChild='';");
      status.out.println("}");
      status.out.println("if (Gt(a.length,148)) {");
      status.out.println("o_DATAOPE=w_DATAOPE;");
      status.out.println("o_CDATOPE=w_CDATOPE;");
      status.out.println("o_filtro=w_filtro;");
      status.out.println("o_DATAREG=w_DATAREG;");
      status.out.println("o_COLLEG=w_COLLEG;");
      status.out.println("o_CODVOC=w_CODVOC;");
      status.out.println("o_FLAGLIRE=w_FLAGLIRE;");
      status.out.println("o_appolire=w_appolire;");
      status.out.println("o_FLAGCONT=w_FLAGCONT;");
      status.out.println("o_RAPPORTO=w_RAPPORTO;");
      status.out.println("o_CONNESCLI=w_CONNESCLI;");
      status.out.println("o_CONNESBEN=w_CONNESBEN;");
      status.out.println("o_C_CTA=w_C_CTA;");
      status.out.println("o_CODINT2=w_CODINT2;");
      status.out.println("o_CODINTER=w_CODINTER;");
      status.out.println("o_CODDIPE=w_CODDIPE;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['IDBASE'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_storfra_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(745,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","wraziobo");
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
  void RaiseLoadedEntity(armt_storfraBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_storfraBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"save") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventSavedEntity(status,(status.m_cOldKeysToRaiseParms!=null?status.m_cOldKeysToRaiseParms:SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0)));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDeletedEntity(armt_storfraBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"delete") &&  ! (status.m_bError)) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDeletedEntity(status,SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void RaiseDiscardedEntity(armt_storfraBO BO,ServletStatus status) {
    if (CPLib.eq(status.m_cAction,"discard")) {
      status.out.println(
       "<script>" +
      "");
      RaiseEventDiscardedEntity(status,SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0));
      status.out.println(
       "</script>" +
      "");
    }
  }
  void WriteExitPage(armt_storfraBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_storfraBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_storfraBO BO,ServletStatus status) throws IOException {
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
     "<script src='SPPrxy/"+arfn_chktotalelire_cont.m_cEntityUid+"/arfn_chktotalelire_cont.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chktotalelire_fraz.m_cEntityUid+"/arfn_chktotalelire_fraz.js'>" +
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
      arfn_chktotalelire_cont.GetCallableNames(callable);
      arfn_chktotalelire_fraz.GetCallableNames(callable);
      arrt_imp_frischio.GetCallableNames(callable);
      arrt_val_benefic.GetCallableNames(callable);
      CPLib.AddToSet(callable,"LibreriaMit");
      CPLib.AddToSet(callable,"ardt_wlientifrz");
      CPLib.AddToSet(callable,"ardt_storsogfraz");
      CPLib.AddToSet(callable,"ardt_weneficfrz");
      CPLib.AddToSet(callable,"ardt_werzistifrz");
      CPLib.AddToSet(callable,"ardt_docfrabo");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_storfraBO BO,String p_cUID) {
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
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gStatus),"C",4,0));
      hCreator.AddValue(CPLib.ToSQL(BO.w_gDataVaria,"D",8,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gFlgDoc),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gFlgWU),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(BO.w_gFlgDTP,"N",1,0));
    } else if (CPLib.eq(p_cUID,"FCUPIYMFZB")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"EZPCGCABUD")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"BHDZAMJILO")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"JCKYJRZABA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"RZIQZFKPUE")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"QBLXDBODXR")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"TCOTJNZLGM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ULVCBLFVEU")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"TRNDHQYOXC")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SDKWKBVOVR")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"QASGTWMXYC")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"OGZBJVOVLN")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"MUTRCJYNJT")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"CRVLITCYRD")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NNOUMHTLXJ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SDNFDOJDLP")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SRWWPHPCUB")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"KZPPWSIAXL")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"RTGTOVGSAH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"WZGVCTOIUK")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"MTCGTVJYAU")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NQCYKQCVPJ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"RIGLNJERGO")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"QTLAIWJTIK")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"EOXCZYYEBY")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_storfraBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
      if (result &&  ! (CPLib.Empty(BO.w_COLLEG))) {
        a = GetCheckVars(status,BO,"FCUPIYMFZB");
        b = status.m_CheckVars.optString("FCUPIYMFZB");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CODANA))) {
        a = GetCheckVars(status,BO,"EZPCGCABUD");
        b = status.m_CheckVars.optString("EZPCGCABUD");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CODVOC))) {
        a = GetCheckVars(status,BO,"BHDZAMJILO");
        b = status.m_CheckVars.optString("BHDZAMJILO");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_VALUTA))) {
        a = GetCheckVars(status,BO,"JCKYJRZABA");
        b = status.m_CheckVars.optString("JCKYJRZABA");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_RAPPORTO))) {
        a = GetCheckVars(status,BO,"RZIQZFKPUE");
        b = status.m_CheckVars.optString("RZIQZFKPUE");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CONNESCLI))) {
        a = GetCheckVars(status,BO,"QBLXDBODXR");
        b = status.m_CheckVars.optString("QBLXDBODXR");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CONNESOPER))) {
        a = GetCheckVars(status,BO,"TCOTJNZLGM");
        b = status.m_CheckVars.optString("TCOTJNZLGM");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CONNESBEN))) {
        a = GetCheckVars(status,BO,"ULVCBLFVEU");
        b = status.m_CheckVars.optString("ULVCBLFVEU");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CONNALTRO))) {
        a = GetCheckVars(status,BO,"TRNDHQYOXC");
        b = status.m_CheckVars.optString("TRNDHQYOXC");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_C_STA))) {
        a = GetCheckVars(status,BO,"QASGTWMXYC");
        b = status.m_CheckVars.optString("QASGTWMXYC");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_PAESE))) {
        a = GetCheckVars(status,BO,"MUTRCJYNJT");
        b = status.m_CheckVars.optString("MUTRCJYNJT");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CODINTER))) {
        a = GetCheckVars(status,BO,"NNOUMHTLXJ");
        b = status.m_CheckVars.optString("NNOUMHTLXJ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CODDIPE))) {
        a = GetCheckVars(status,BO,"SDNFDOJDLP");
        b = status.m_CheckVars.optString("SDNFDOJDLP");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CODVOC))) {
        a = GetCheckVars(status,BO,"SRWWPHPCUB");
        b = status.m_CheckVars.optString("SRWWPHPCUB");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_OPERAG))) {
        a = GetCheckVars(status,BO,"KZPPWSIAXL");
        b = status.m_CheckVars.optString("KZPPWSIAXL");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_AREAGEO))) {
        a = GetCheckVars(status,BO,"RTGTOVGSAH");
        b = status.m_CheckVars.optString("RTGTOVGSAH");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_MODSVOL))) {
        a = GetCheckVars(status,BO,"WZGVCTOIUK");
        b = status.m_CheckVars.optString("WZGVCTOIUK");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_RAGIO))) {
        a = GetCheckVars(status,BO,"MTCGTVJYAU");
        b = status.m_CheckVars.optString("MTCGTVJYAU");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_TIPO))) {
        a = GetCheckVars(status,BO,"NQCYKQCVPJ");
        b = status.m_CheckVars.optString("NQCYKQCVPJ");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DURAT))) {
        a = GetCheckVars(status,BO,"RIGLNJERGO");
        b = status.m_CheckVars.optString("RIGLNJERGO");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_AMMONT))) {
        a = GetCheckVars(status,BO,"QTLAIWJTIK");
        b = status.m_CheckVars.optString("QTLAIWJTIK");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CONNESDOC))) {
        a = GetCheckVars(status,BO,"EOXCZYYEBY");
        b = status.m_CheckVars.optString("EOXCZYYEBY");
        result = CPLib.eq(a,b);
      }
    }
    return result;
  }
}
