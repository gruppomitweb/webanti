import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.zucchetti.sitepainter.SPPrxycizer;

@com.zucchetti.sitepainter.EntityRoles({"administrators","utenti standard","ruolo 3","utenti confidi","ruolo 5","agenzia","area finanza","help desk","consultazione","utilità"})
public class armt_frazioprov extends SPServlet implements SPInvokable {
  public static String m_cEntityUid = "!*35673181*!";
  static public class ServletStatus extends SPMasterServletStatus {
    ServletStatus() {
      m_cAllVirtNames = "xraziobo";
    }
    public String w_IDBASE;
    public void BuildLastWhereFromPK() {
      if (CPLib.Empty(m_cLastWhere)) {
        m_cLastWhere = m_cLastWhere+CPLib.BuildLastWhereFromPK(w_IDBASE,context,"xraziobo","IDBASE","C",10,0,( ! (CPLib.Empty(m_cLastWhere))?" and ":""));
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
    armt_frazioprovBO BO;
    BO = getBO(status);
    BO.m_bSkipCheckOTPSecurity = false;
    status.m_cVirtName = BO.m_cVirtName_xraziobo;
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
    return "Frazionate (Provvisorie)";
  }
  public SPEntityGlobals getEntityGlobals() {
    // Costanti globali dell' entita'
    SPEntityGlobals l_eg = new SPEntityGlobals();
    l_eg.name = "armt_frazioprov";
    l_eg.userName = getEntityTitle();
    l_eg.m_nEntityWidth = 1293;
    l_eg.m_nEntityHeight = 782;
    l_eg.isPublic = false;
    l_eg.canAccess = true;
    l_eg.canInsert = true;
    l_eg.canChange = true;
    l_eg.canDelete = true;
    l_eg.m_cStates = "[]";
    l_eg.zoomableTables = new String[]{"xraziobo","intermbo","anadip","tbcauana","tbcausin","tbvalute","knarapbo","personbo","tbcitta","tbstati","inter2bo","tbtipope","tbdurata_p","tbimporto_p","tbareegeog_p","tbsvolgim_p","tbplauso_p","tbtiporisc_p","kersonbo","tbdurata","tbimporto","tbareegeog","tbsvolgim","tbplauso","tbtiporisc"};
    l_eg.zoneItems = new ZoneItem[]{new ZoneItem("page_1","Principale","page"),new ZoneItem("page_2","Intestatari / Operanti Conto Terzi","page"),new ZoneItem("page_3","Altre Controparti / Altri Soggetti Terzi","page"),new ZoneItem("page_4","Dati Aggiuntivi","page"),new ZoneItem("page_5","Documenti Soggetti","page"),new ZoneItem("page_6","Gestione Rischio","page"),new ZoneItem("page_7","Gestione Contante","page"),new ZoneItem("DatiOperazione","Dati operazione","horizontal_section"),new ZoneItem("DatiCambiaSV","Dati Cambiavalute/SV","horizontal_section"),new ZoneItem("Soggetti","Dati Soggetti/Rapporti Coinvolti nell'operazione","horizontal_section"),new ZoneItem("DatiControparte","Dati ControParte","horizontal_section"),new ZoneItem("DatiIntermediarioControparte","Dati eventuale Intermediario ControParte","horizontal_section"),new ZoneItem("Intermediario","Intermediario","auto_horizontal_section"),new ZoneItem("Intermediario2","Intermediario","auto_horizontal_section"),new ZoneItem("AltriIntestatari","Altri Intestatari","collapsible"),new ZoneItem("AltriEsecutori","","collapsible"),new ZoneItem("Intermediario3","Intermediario","auto_horizontal_section"),new ZoneItem("AltreControparti","Controparti","horizontal_section"),new ZoneItem("AltriSoggTerzi","","horizontal_section"),new ZoneItem("Intermediario4","Intermediario","auto_horizontal_section"),new ZoneItem("AGE","Dati Per Agenzia Entrate","horizontal_section"),new ZoneItem("Internet","Dati  Operazione Internet Casino","horizontal_section"),new ZoneItem("Aggiuntivi","Dati Aggiuntivi","horizontal_section"),new ZoneItem("SV","Segnalazioni di Vigilanza","horizontal_section"),new ZoneItem("Contante_Gen","Dati Generali Contante","horizontal_section"),new ZoneItem("OAM","OAM","horizontal_section"),new ZoneItem("Intermediario5","Intermediario","auto_horizontal_section"),new ZoneItem("Documenti","Documenti Soggetti Collegati","horizontal_section"),new ZoneItem("IIIDirettiva","TIPOLOGIA E VALUTAZIONE RISCHIO (IIIa DIRETTIVA)","horizontal_section"),new ZoneItem("Mitigazione","Mitigazione del rischio","horizontal_section"),new ZoneItem("Categorie","Categorie","horizontal_section"),new ZoneItem("Intermediario6","Intermediario","auto_horizontal_section"),new ZoneItem("Intermediario7","Intermediario","auto_horizontal_section"),new ZoneItem("Contante","Gestione Contante","horizontal_section")};
    l_eg.securedBoxes = new String[][] {};
    l_eg.securedTabs = new String[][] {};
    l_eg.keyColumns = new String[]{"IDBASE"};
    l_eg.items = new SPItem[]{
                   new SPItem("gIntemediario","C",11,0, "hide","Intermediario"),
                   new SPItem("gChkDate","C",1,0, "hide","Controllo Date"),
                   new SPItem("gTipInter","C",2,0, "hide","Tipo Intermediario"),
                   new SPItem("gSblocco","C",1,0, "hide","Sblocco controllo"),
                   new SPItem("gFlgWU","C",1,0, "hide","Gestione WU"),
                   new SPItem("gStatus","C",4,0, "hide","Stato Operazione"),
                   new SPItem("gDataVaria","D",8,0, "hide","Data Variazione"),
                   new SPItem("gFlgDoc","C",1,0, "hide","Collegamento con storico documenti"),
                   new SPItem("gFlgDTP","N",1,0, "hide","Forza Data Trasferimento Provvisorie"),
                   new SPItem("gSeekAos","C",1,0, "hide","Collegamento con AOS"),
                   new SPItem("gVerSim","C",1,0, "hide","Verifica Semplificata"),
                   new SPItem("dataoggi","D",8,0, "hide",""),
                   new SPItem("filtro","C",1,0, "hide",""),
                   new SPItem("sEdit","N",1,0, "hide",""),
                   new SPItem("test","C",1,0, "hide",""),
                   new SPItem("datpaseuro","D",8,0, "hide","Data Passaggio EURO"),
                   new SPItem("tipope","C",1,0, "hide",""),
                   new SPItem("stringaflagrap2","C",9,0, "hide",""),
                   new SPItem("IDBASE","C",10,0, "edit","Idbase"),
                   new SPItem("CODINTER","C",11,0, "show","Codice Intermediario"),
                   new SPItem("apporeg","C",8,0, "hide",""),
                   new SPItem("CODDIPE","C",6,0, "edit","Codice Dipendenza"),
                   new SPItem("DESCCIT","C",30,0, "show","Città Dipendenza"),
                   new SPItem("PROVINCIA","C",2,0, "show","Provincia Dipendenza"),
                   new SPItem("CODCAB","C",6,0, "show","CAB Dipendenza"),
                   new SPItem("DATAOPE","D",8,0, "edit","Data Operazione"),
                   new SPItem("NUMPROG","C",11,0, "show","Numero Progressivo"),
                   new SPItem("CDATOPE","C",8,0, "hide","Data Operazione in carattere"),
                   new SPItem("CDATAOPE","C",10,0, "hide",""),
                   new SPItem("ANNOOPE","N",4,0, "hide","Anno Operazione (MT/IDP)"),
                   new SPItem("DATAREG","D",8,0, "hide","Data registrazione"),
                   new SPItem("CDATREG","C",8,0, "hide","Data Registrazione in carattere"),
                   new SPItem("FLAGFRAZ","C",1,0, "edit","Frazionata (S/N)"),
                   new SPItem("COLLEG","C",12,0, "show","Collegamento Operazione Multiple"),
                   new SPItem("TIPOOPRAP","C",2,0, "edit","Tipo Operazione Completa"),
                   new SPItem("idcauana","C",4,0, "edit","Causale"),
                   new SPItem("CODANA","C",4,0, "show","Causale Analitica"),
                   new SPItem("CODVOC","C",2,0, "show","Causale Sintetica"),
                   new SPItem("FLAGLIRE","C",1,0, "hide","Lire Euro Valuta"),
                   new SPItem("appolire","C",1,0, "edit","B11. Tipo Divisa"),
                   new SPItem("VALUTA","C",3,0, "edit","B12. Divisa"),
                   new SPItem("xTOTLIRE","N",15,2, "edit","B14. Totale Euro"),
                   new SPItem("FLAGCONT","C",1,0, "edit","Contanti (S/N)"),
                   new SPItem("xTOTCONT","N",15,2, "edit","B15. di cui contanti"),
                   new SPItem("CAMBIO","N",9,4, "edit","Cambio"),
                   new SPItem("IMPIN","N",15,2, "edit","Importo in Entrata"),
                   new SPItem("IMPOUT","N",15,2, "edit","Importo in Uscita"),
                   new SPItem("RAPPORTO","C",25,0, "edit","Rapporto Collegato"),
                   new SPItem("CONNESCLI","C",16,0, "edit","Codice Cliente Occasionale"),
                   new SPItem("PROQUOTA","N",3,0, "edit","% Pro Quota"),
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
                   new SPItem("DESCINTER","C",50,0, "edit","A43. Denominazione Intermediario C/Parte"),
                   new SPItem("PAESE","C",3,0, "edit","A32. Stato Intermediario C/Parte"),
                   new SPItem("C_RAPPORTO","C",25,0, "edit",""),
                   new SPItem("CODCAB2","C",6,0, "edit","A33A. CAB Intermediario C/Parte"),
                   new SPItem("DESC2","C",30,0, "edit","A33B. Comune Intermediario C/Parte"),
                   new SPItem("PROV2","C",2,0, "edit","A33C. Provincia Intermediario C/Parte"),
                   new SPItem("ZCPARTE","C",69,0, "edit",""),
                   new SPItem("xdestipleg","C",50,0, "hide","Descrizione"),
                   new SPItem("xragsocct","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("xDescDipe","C",30,0, "hide","Descrizione"),
                   new SPItem("descdiv","C",30,0, "hide","Descrizione"),
                   new SPItem("TIPOINF","C",1,0, "hide","Tipo Informazione"),
                   new SPItem("valflg2","C",1,0, "hide",""),
                   new SPItem("xragint2","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("errmsg","C",100,0, "hide",""),
                   new SPItem("CABINT","C",6,0, "hide","CAB"),
                   new SPItem("xragsocper","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("desccauana","C",165,0, "hide","Descrizione"),
                   new SPItem("xragsocben","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("xdesccausin","C",165,0, "hide","Descrizione"),
                   new SPItem("xdescpaese2","C",30,0, "hide","Descrizione"),
                   new SPItem("xdescrap","C",50,0, "hide","Descrizione"),
                   new SPItem("xdes1","C",90,0, "hide","Descrizione"),
                   new SPItem("xcodfisc","C",16,0, "hide","Codice Fiscale"),
                   new SPItem("xdciticon","C",40,0, "hide","Località"),
                   new SPItem("dessta","C",40,0, "hide","Descrizione"),
                   new SPItem("xragsocalt","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("xFLGITAEST","C",1,0, "hide","I=Italia,E=Estero"),
                   new SPItem("SEGNO","C",1,0, "show","Segno"),
                   new SPItem("TOTLIRE","N",15,0, "hide","Totale Operazione"),
                   new SPItem("TOTCONT","N",15,0, "hide","di cui contanti"),
                   new SPItem("IDEREG","C",20,0, "hide","ID Registrazione"),
                   new SPItem("DESCINTER","C",50,0, "hide",""),
                   new SPItem("FLAGRAP","C",1,0, "hide","Tipo Rapporto Collegato"),
                   new SPItem("OPRAP","C",1,0, "hide","Tipo operazione"),
                   new SPItem("RAPPORTBEN","C",25,0, "hide","Rapporto Beneficiario"),
                   new SPItem("OPERATORE","C",70,0, "hide","Operatore"),
                   new SPItem("AUTOM","C",5,0, "hide","Importazione da file esterno"),
                   new SPItem("FLAGRAP2","C",1,0, "hide","Tipo Rapporto Beneficiario"),
                   new SPItem("PRGIMPFRZ","N",15,0, "hide","Progressivo Import"),
                   new SPItem("CITINT","C",30,0, "hide","Città"),
                   new SPItem("CITDIP","C",30,0, "hide","Città"),
                   new SPItem("PROVDIP","C",2,0, "hide","Provincia"),
                   new SPItem("CABDIP","C",6,0, "hide","CAB"),
                   new SPItem("PROVINT","C",2,0, "hide","Provincia"),
                   new SPItem("CONNESDOC","C",40,0, "hide","Connessione Tabella Storico Documenti"),
                   new SPItem("DATAVALI","D",8,0, "hide",""),
                   new SPItem("DATARILASC","D",8,0, "hide","Data Rilascio Doc."),
                   new SPItem("IDBASE2","C",10,0, "hide","Gestione IDEREG"),
                   new SPItem("NOSARA","C",1,0, "edit","Escludi operazioni soggetto da SARA"),
                   new SPItem("NOPROT","N",1,0, "edit",""),
                   new SPItem("OPERAG","C",3,0, "edit",""),
                   new SPItem("xdescopeage","C",254,0, "hide","Descrizione"),
                   new SPItem("RESPINS","C",30,0, "edit",""),
                   new SPItem("INFORM","C",30,0, "edit",""),
                   new SPItem("NATURA","C",50,0, "edit",""),
                   new SPItem("SCOPO","C",50,0, "edit",""),
                   new SPItem("SV58550","C",1,0, "edit","Modalità bonifico in uscita"),
                   new SPItem("SV58550MA","C",2,0, "edit","Modalità di avvio"),
                   new SPItem("xdescfreq","C",200,0, "hide","Descrizione"),
                   new SPItem("DURAT","C",5,0, "hide",""),
                   new SPItem("xdescammo","C",200,0, "hide","Descrizione"),
                   new SPItem("AMMONT","C",5,0, "hide",""),
                   new SPItem("xdescareag","C",50,0, "hide","Descrizione"),
                   new SPItem("AREAGEO","C",5,0, "hide",""),
                   new SPItem("xdescmodsvo","C",200,0, "hide","Descrizione"),
                   new SPItem("MODSVOL","C",5,0, "hide",""),
                   new SPItem("xdescplauso","C",200,0, "hide","Descrizione"),
                   new SPItem("RAGIO","C",5,0, "hide",""),
                   new SPItem("xdesctipor","C",100,0, "hide","Descrizione"),
                   new SPItem("TIPO","C",3,0, "hide",""),
                   new SPItem("DUCOLLEG","N",10,0, "show","Durata Collegamento"),
                   new SPItem("ORACOLLEG","T",8,0, "show","Inizio Collegamento"),
                   new SPItem("IPCOLLEG","C",15,0, "show","IP Collegamento"),
                   new SPItem("MEZPAG","C",30,0, "edit","Mezzo pagamento"),
                   new SPItem("PRESTAZ","C",30,0, "edit","Beni Oggetto Incarico"),
                   new SPItem("DESPUNTO","C",80,0, "show","Punto Contante"),
                   new SPItem("CODCLICON","C",20,0, "show","Codice Cliente Contante"),
                   new SPItem("TIPATT","C",3,0, "show","Tipo attività"),
                   new SPItem("VASP","C",2,0, "edit","Tipo VASP"),
                   new SPItem("RIFIMP","C",15,0, "hide",""),
                   new SPItem("CONNESDOC","C",50,0, "edit","Storico Documenti"),
                   new SPItem("xRAGSOCDOC","C",70,0, "hide","Ragione Sociale"),
                   new SPItem("IDFILE","C",60,0, "show","ID File"),
                   new SPItem("MTCN","C",10,0, "edit","MTCN"),
                   new SPItem("DURAT","C",5,0, "edit",""),
                   new SPItem("RFREQ","N",3,0, "edit",""),
                   new SPItem("AMMONT","C",5,0, "edit",""),
                   new SPItem("RIMP","N",3,0, "edit",""),
                   new SPItem("AREAGEO","C",5,0, "edit",""),
                   new SPItem("RAREA","N",3,0, "edit",""),
                   new SPItem("MODSVOL","C",5,0, "edit",""),
                   new SPItem("RCOMP","N",3,0, "edit",""),
                   new SPItem("RAGIO","C",5,0, "edit",""),
                   new SPItem("RRAGIO","N",3,0, "edit",""),
                   new SPItem("TIPO","C",3,0, "edit",""),
                   new SPItem("RTIPO","N",3,0, "edit",""),
                   new SPItem("RISGLOB","C",1,0, "edit","Rischio Globale"),
                   new SPItem("MITIG","N",4,0, "edit","Mitigazione (+/-)"),
                   new SPItem("MITIGDOC","C",100,0, "edit","Path Documentazione Mitigazione")
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
  public String GetLayerGroupHeader(String p_cGroupName,String p_cLayerName,String p_cLayerId,armt_frazioprovBO BO) {
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
    {"1008789486",p_Context.Translate("Forza Data Trasferimento Provvisorie")},
    {"10095365423",p_Context.Translate("Provincia")},
    {"1010957902",p_Context.Translate("Punto Contante")},
    {"10114564076",p_Context.Translate("Mezzo pagamento")},
    {"10126883135",p_Context.Translate("B11. Tipo Divisa")},
    {"10166248752",p_Context.Translate("A33B. Comune Intermediario C/Parte")},
    {"10196692374",p_Context.Translate("Non inviare agenzia Entrate")},
    {"10219814530",p_Context.Translate("Codice Cliente Occasionale")},
    {"10220423475",p_Context.Translate("Data Variazione")},
    {"1028598955",p_Context.Translate("Data registrazione")},
    {"103243324",p_Context.Translate("Tipo Operazione Agenzia Entrate")},
    {"10379997930",p_Context.Translate("Rapporto Collegato")},
    {"10450770185",p_Context.Translate("Escludi operazioni soggetto da SARA")},
    {"10455298077",p_Context.Translate("Codice Intermediario C/Parte")},
    {"10464441821",p_Context.Translate("%1")},
    {"10500809751",p_Context.Translate("Rischio Globale")},
    {"10637879581",p_Context.Translate("Data Operazione in carattere")},
    {"10639118571",p_Context.Translate("Tipo Legame")},
    {"10662833243",p_Context.Translate("Ragione Sociale")},
    {"10703819256",p_Context.Translate("%1")},
    {"10848850431",p_Context.Translate("CAB Dipendenza")},
    {"10849117717",p_Context.Translate("B12. Divisa")},
    {"10943726013",p_Context.Translate("di cui contanti")},
    {"10983493593",p_Context.Translate("Gestione WU")},
    {"10984972139",p_Context.Translate("Modalità bonifico in uscita")},
    {"11053408024",p_Context.Translate("Area Geografica")},
    {"11085000424",p_Context.Translate("F14A. CAB Controparte")},
    {"1108605666",p_Context.Translate("A32. Stato Intermediario C/Parte")},
    {"11135066302",p_Context.Translate("A33C. Provincia Intermediario C/Parte")},
    {"11137644647",p_Context.Translate("Tipo Operazione Completa")},
    {"11141557209",p_Context.Translate("F16. CAP Controparte")},
    {"11155590227",p_Context.Translate("Tipo attività")},
    {"11158852142",p_Context.Translate("Modalità Svolgimento")},
    {"11259116522",p_Context.Translate("Il segno dell'operazione non è compatibile con il tipo di operazione (11-19 / Dare)")},
    {"11262175587",p_Context.Translate("Documenti")},
    {"11291273118",p_Context.Translate("Soggetto operante utilizza mezzi propri")},
    {"11316624286",p_Context.Translate("Codice Intermediario")},
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
    {"11552491820",p_Context.Translate("% Pro Quota")},
    {"11628231202",p_Context.Translate("A31A. Tipo Intermediario C/Parte")},
    {"11655443642",p_Context.Translate("%1")},
    {"11710831322",p_Context.Translate("%1")},
    {"11767338828",p_Context.Translate("Operatore")},
    {"11835283726",p_Context.Translate("F15. Indirizzo Controparte")},
    {"11857520945",p_Context.Translate("Ammontare Operazione")},
    {"11921223220",p_Context.Translate("Codice Fiscale")},
    {"11925635672",p_Context.Translate("Collegamento con AOS")},
    {"12000295156",p_Context.Translate("Modalità di avvio")},
    {"12057236694",p_Context.Translate("Frazionate")},
    {"12101861285",p_Context.Translate("Tipo Rapporto Beneficiario")},
    {"12135010165",p_Context.Translate("A33A. CAB Intermediario C/Parte")},
    {"123704147",p_Context.Translate("Cambio")},
    {"1251797647",p_Context.Translate("Verifica Semplificata")},
    {"1270140318",p_Context.Translate("Dipendenze")},
    {"1284129730",p_Context.Translate("F11. Denominazione Controparte")},
    {"1410438055",p_Context.Translate("F14B. Comune Controparte")},
    {"1474107696",p_Context.Translate("Frazionate (Provvisorie)")},
    {"15186643",p_Context.Translate("Città")},
    {"156259011",p_Context.Translate("Escludi operazione da S.A.R.A.")},
    {"1637276170",p_Context.Translate("F14C. Provincia Controparte")},
    {"1663847307",p_Context.Translate("A43. Denominazione Intermediario C/Parte")},
    {"1690077224",p_Context.Translate("Data Rilascio Doc.")},
    {"1698385181",p_Context.Translate("ID Registrazione")},
    {"1722199786",p_Context.Translate("Frazionata (S/N)")},
    {"1729482089",p_Context.Translate("Impossibile utilizzare un codice diverso da 242 con tipo divisa = EURO")},
    {"1748201363",p_Context.Translate("Città Dipendenza")},
    {"18003",p_Context.Translate("CAB")},
    {"1814604627",p_Context.Translate("Causale")},
    {"1814922377",p_Context.Translate("ID File")},
    {"1825772649",p_Context.Translate("Totale Operazione")},
    {"1890893827",p_Context.Translate("Clienti")},
    {"191062270",p_Context.Translate("%1")},
    {"1940073082",p_Context.Translate("Ricerca su Soggetti Segnalati")},
    {"194410082",p_Context.Translate("Rapporti")},
    {"198756379",p_Context.Translate("Rapporto Beneficiario")},
    {"1988585268",p_Context.Translate("Tipo VASP")},
    {"2063759932",p_Context.Translate("Località")},
    {"2071283709",p_Context.Translate("Codice Dipendenza")},
    {"2135167160",p_Context.Translate("Beni Oggetto Incarico")},
    {"215310487",p_Context.Translate("Causale Sintetica")},
    {"215536597",p_Context.Translate("Causale Analitica")},
    {"216014596",p_Context.Translate("I=Italia,E=Estero")},
    {"226933836",p_Context.Translate("Data Passaggio EURO")},
    {"237632211",p_Context.Translate("Contanti (S/N)")},
    {"282420974",p_Context.Translate("Causali Sintetiche")},
    {"282647084",p_Context.Translate("Causali Analitiche")},
    {"283403499",p_Context.Translate("Progressivo Import")},
    {"285692487",p_Context.Translate("Gestione IDEREG")},
    {"285808099",p_Context.Translate("Descrizione")},
    {"301347801",p_Context.Translate("Il segno dell'operazione non è compatibile con il tipo di operazione (12-18 / Avere)")},
    {"307787605",p_Context.Translate("Mitigazione (+/-)")},
    {"308673648",p_Context.Translate("Tipo Rapporto Collegato")},
    {"338061",p_Context.Translate("MTCN")},
    {"339694596",p_Context.Translate("Connessione Tabella Storico Documenti")},
    {"340709450",p_Context.Translate("%1")},
    {"36480606",p_Context.Translate("Impossibile utilizzare il codice 242 con tipo divisa = VALUTA")},
    {"368688795",p_Context.Translate("Anno Operazione (MT/IDP)")},
    {"383234328",p_Context.Translate("Stato Operazione")},
    {"436781937",p_Context.Translate("Durata Collegamento")},
    {"439997054",p_Context.Translate("Codice Cliente Contante")},
    {"450841094",p_Context.Translate("Inizio Collegamento")},
    {"491820845",p_Context.Translate("Data Registrazione in carattere")},
    {"492802848",p_Context.Translate("Frequenza Operazione")},
    {"502956915",p_Context.Translate("B14. Totale Euro")},
    {"616535110",p_Context.Translate("B15. di cui contanti")},
    {"624505163",p_Context.Translate("Lire Euro Valuta")},
    {"643948227",p_Context.Translate("Importo in Uscita")},
    {"654805131",p_Context.Translate("Collega le operazioni ai titolari effettivi")},
    {"684190680",p_Context.Translate("Tipo Informazione")},
    {"698242285",p_Context.Translate("Importazione da file esterno")},
    {"7070950",p_Context.Translate("Importo in Entrata")},
    {"711282992",p_Context.Translate("Storico Documenti")},
    {"724026219",p_Context.Translate("Path Documentazione Mitigazione")},
    {"728888873",p_Context.Translate("F13. Stato Controparte")},
    {"7383187",p_Context.Translate("Stati")},
    {"750412439",p_Context.Translate("Collegamento Operazione Multiple")},
    {"7753123",p_Context.Translate("Segno")},
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
  void WriteStyles(armt_frazioprovBO BO,ServletStatus status) {
    if ( ! ( ! (CPLib.Empty(status.m_cAltInterface)))) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../armt_frazioprov.css?"+m_cEntityUid+"'>" +
      "");
    }
    if (CPLib.eq(status.m_cClientMode,"painter")) {
      status.out.println(
       "<link type='text/css' rel='stylesheet' href='../"+SPPrxycizer.proxycizedPath(status.m_cTheme + "/spadministration_security.css", SPPrxycizer.Mode.QUERYSTRING)+"'>" +
      "");
    }
  }
  void WriteMainForm(armt_frazioprovBO BO,ServletStatus status) {
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
    status.out.println("var tabs = new Z.Tabs({container:'tabsContainer',useseparator:GetStyleVariable('formTabUseSeparator', false, ''),expandcollapse:(typeof(sv_TabstripCanCollapse)!='undefined'?sv_TabstripCanCollapse:GetStyleVariable('formTabCanCollapse', false, '')),contents:[{name:\"page_1\", element:\"page_1\", caption:"+SPLib.ToJSValue(status.context.Translate("Principale"),"C",0,0)+"},{name:\"page_2\", element:\"page_2\", caption:"+SPLib.ToJSValue(status.context.Translate("Intestatari / Operanti Conto Terzi"),"C",0,0)+"},{name:\"page_3\", element:\"page_3\", caption:"+SPLib.ToJSValue(status.context.Translate("Altre Controparti / Altri Soggetti Terzi"),"C",0,0)+"},{name:\"page_4\", element:\"page_4\", caption:"+SPLib.ToJSValue(status.context.Translate("Dati Aggiuntivi"),"C",0,0)+"},{name:\"page_5\", element:\"page_5\", caption:"+SPLib.ToJSValue(status.context.Translate("Documenti Soggetti"),"C",0,0)+"},{name:\"page_6\", element:\"page_6\", caption:"+SPLib.ToJSValue(status.context.Translate("Gestione Rischio"),"C",0,0)+"},{name:\"page_7\", element:\"page_7\", caption:"+SPLib.ToJSValue(status.context.Translate("Gestione Contante"),"C",0,0)+"}],tabstrip_class: ''});Z.Tabs.UseDeprecation();");
    status.out.println("Z.Tabs.Set('tabs',tabs);");
    status.out.println("} else {");
    status.out.println("var tabs = Z.Tabs.Get('tabs')");
    status.out.println("}");
    AddExtendedTabs(status);
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_frazioprov',false);");
    status.out.println(
     "</script>" +
    "");
    PrintPwdOTPDiv(status,"armt_frazioprov",BO.m_bLoaded,(BO.m_bLoaded?false:false),(BO.m_bLoaded?false:false));
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls(armt_frazioprovBO BO,ServletStatus status) {
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
  void WriteControls_p1(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_1' class='PageContainer' style='position:relative;height:782px;width:1293px;display:none'>" +
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
    WriteControls_p1_b11(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,1,"Principale");
    PrintSidebarContent(1,status,getSidebarItems(0),true);
    PrintContextMenu(1,status,getContextMenu(0),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_2' class='PageContainer' style='position:relative;height:533px;width:1293px;display:none'>" +
    "");
    WriteControls_p2_b0(BO,status);
    WriteControls_p2_b1(BO,status);
    WriteControls_p2_b2(BO,status);
    WriteControls_p2_b3(BO,status);
    WriteControls_p2_b4(BO,status);
    WriteControls_p2_b5(BO,status);
    WriteControls_p2_b6(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,2,"Intestatari / Operanti Conto Terzi");
    PrintSidebarContent(2,status,getSidebarItems(1),true);
    PrintContextMenu(2,status,getContextMenu(1),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_3' class='PageContainer' style='position:relative;height:632px;width:1293px;display:none'>" +
    "");
    WriteControls_p3_b0(BO,status);
    WriteControls_p3_b1(BO,status);
    WriteControls_p3_b2(BO,status);
    WriteControls_p3_b3(BO,status);
    WriteControls_p3_b4(BO,status);
    WriteControls_p3_b5(BO,status);
    WriteControls_p3_b6(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,3,"Altre Controparti / Altri Soggetti Terzi");
    PrintSidebarContent(3,status,getSidebarItems(2),true);
    PrintContextMenu(3,status,getContextMenu(2),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p4(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_4' class='PageContainer' style='position:relative;height:568px;width:1293px;display:none'>" +
    "");
    WriteControls_p4_b0(BO,status);
    WriteControls_p4_b1(BO,status);
    WriteControls_p4_b2(BO,status);
    WriteControls_p4_b3(BO,status);
    WriteControls_p4_b4(BO,status);
    WriteControls_p4_b5(BO,status);
    WriteControls_p4_b6(BO,status);
    WriteControls_p4_b7(BO,status);
    WriteControls_p4_b8(BO,status);
    WriteControls_p4_b9(BO,status);
    WriteControls_p4_b10(BO,status);
    WriteControls_p4_b11(BO,status);
    WriteControls_p4_b12(BO,status);
    WriteControls_p4_b13(BO,status);
    WriteControls_p4_b14(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,4,"Dati Aggiuntivi");
    PrintSidebarContent(4,status,getSidebarItems(3),true);
    PrintContextMenu(4,status,getContextMenu(3),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p5(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_5' class='PageContainer' style='position:relative;height:577px;width:1293px;display:none'>" +
    "");
    WriteControls_p5_b0(BO,status);
    WriteControls_p5_b1(BO,status);
    WriteControls_p5_b2(BO,status);
    WriteControls_p5_b3(BO,status);
    WriteControls_p5_b4(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,5,"Documenti Soggetti");
    PrintSidebarContent(5,status,getSidebarItems(4),true);
    PrintContextMenu(5,status,getContextMenu(4),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p6(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_6' class='PageContainer' style='position:relative;height:676px;width:1293px;display:none'>" +
    "");
    WriteControls_p6_b0(BO,status);
    WriteControls_p6_b1(BO,status);
    WriteControls_p6_b2(BO,status);
    WriteControls_p6_b3(BO,status);
    WriteControls_p6_b4(BO,status);
    WriteControls_p6_b5(BO,status);
    WriteControls_p6_b6(BO,status);
    WriteControls_p6_b7(BO,status);
    WriteControls_p6_b8(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,6,"Gestione Rischio");
    PrintSidebarContent(6,status,getSidebarItems(5),true);
    PrintContextMenu(6,status,getContextMenu(5),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p7(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='page_7' class='PageContainer' style='position:relative;height:810px;width:1293px;display:none'>" +
    "");
    WriteControls_p7_b0(BO,status);
    WriteControls_p7_b1(BO,status);
    WriteControls_p7_b2(BO,status);
    WriteControls_p7_b3(BO,status);
    WriteExtendedCBoxChildren(BO.m_MNTs,status,7,"Gestione Contante");
    PrintSidebarContent(7,status,getSidebarItems(6),true);
    PrintContextMenu(7,status,getContextMenu(6),"");
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p1_b0(armt_frazioprovBO BO,ServletStatus status) {
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
  void WriteControls_p1_b1(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Intermediario' id='QOEQGFTIYF_DIV' class='BoxContainer SPSection_expanded SectionContainerWithoutTitle'>" +
    "");
    status.out.println(
     "<div id='QOEQGFTIYF' class='SectionBody' style='position:relative;height:45px;display:block'>" +
    "");
    status.includeZoneAltInterface("Intermediario@BEGIN");
    if (status.includeZoneAltInterface("Intermediario")) {
      WriteControls_p1_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Intermediario@BEGIN") || status.HasZoneAltInterface("Intermediario@END")) {
        status.out.println(
         "<div id='QOEQGFTIYF_boxContent' style='position:relative;height:45px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='IDBASE' id='NJDOYSOENB' type='text' class='Field PrimaryKeyField "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"' value="+SPLib.ToHTMLValue(BO.w_IDBASE,"C",10,0,"", status.m_oRegSettings)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='10' size='10' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HBLSDWZPZJ_DIV'>" +
       "<label id='HBLSDWZPZJ' for='NNOUMHTLXJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A01B. Intermediario:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='CODINTER' id='NNOUMHTLXJ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CODINTER,"C",11,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='11' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HZDQOFEXPB_DIV'>" +
       "<label id='HZDQOFEXPB' for='SDNFDOJDLP'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A11. Dipendenza:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CODDIPE' id='SDNFDOJDLP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CODDIPE,"C",6,0,"", status.m_oRegSettings)+" title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_xDescDipe),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
       "<button id='SDNFDOJDLP_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_xDescDipe),"C",0,0)+" tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "SDNFDOJDLP", "anadip", "", "")+"" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OIZHYHOJII_DIV'>" +
       "<label id='OIZHYHOJII' for='DHFUAHCMCJ'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A12B. Città:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='DESCCIT' id='DHFUAHCMCJ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DESCCIT,"C",30,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='IZRUENEKXU_DIV'>" +
       "<label id='IZRUENEKXU' for='QTBRDJZGGM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A12C. Prov.:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='PROVINCIA' id='QTBRDJZGGM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_PROVINCIA,"C",2,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VPEIKRTWFC_DIV'>" +
       "<label id='VPEIKRTWFC' for='RIKKHKHPLM'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A12A. CAB:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='CODCAB' id='RIKKHKHPLM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CODCAB,"C",6,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='6' size='6' fieldtype='C'>" +
      "");
      if (status.HasZoneAltInterface("Intermediario@BEGIN") || status.HasZoneAltInterface("Intermediario@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b1_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
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
      status.out.println("Ctrl('QOEQGFTIYF').style.height='auto';");
    } else {
      status.out.println("Ctrl('QOEQGFTIYF').setAttribute('band_height',45);");
    }
    status.out.println("Ctrl('QOEQGFTIYF').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b2(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='DatiOperazione' id='HZHFVWKGKP_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='HZHFVWKGKP_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='HZHFVWKGKP_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati operazione")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='HZHFVWKGKP_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"HZHFVWKGKP\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=HZHFVWKGKP_HEADER&m_cBoxId=HZHFVWKGKP&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati operazione"))+"");
    }
    status.out.println(
     "<div id='HZHFVWKGKP' class='SectionBody' style='position:relative;height:176px;display:block'>" +
    "");
    status.includeZoneAltInterface("DatiOperazione@BEGIN");
    if (status.includeZoneAltInterface("DatiOperazione")) {
      WriteControls_p1_b2_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("DatiOperazione@BEGIN") || status.HasZoneAltInterface("DatiOperazione@END")) {
        status.out.println(
         "<div id='HZHFVWKGKP_boxContent' style='position:relative;height:176px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DATAOPE' id='WAAXEDMKXA' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_DATAOPE,"D",8,0,SPLib.GetUserDatePicture(status.context.GetLanguage(),"DD-MM-YYYY"), status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='10' size='8' fieldtype='D'>" +
       "<button id='WAAXEDMKXA_ZOOM' type='button' class='CalendarButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
      "");
      status.out.println(
       "<input name='NUMPROG' id='XTDANURGMM' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_NUMPROG,"C",11,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='11' fieldtype='C'>" +
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
       "<input name='COLLEG' id='FCUPIYMFZB' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_COLLEG,"C",12,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='12' size='12' fieldtype='C' style='display:none'>" +
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
       "<input name='idcauana' id='XDPPAEWQFR' type='text' class='"+status.ObligatoryClass("Field")+"' value="+SPLib.ToHTMLValue(BO.w_idcauana,"C",4,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='4' fieldtype='C'>" +
       "<button id='XDPPAEWQFR_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "XDPPAEWQFR", "tbcauana", "", "cauinter")+"" +
      "");
      status.out.println(
       "<input name='CODANA' id='SQVJLYRFKQ' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CODANA,"C",4,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='4' size='4' fieldtype='C'>" +
      "");
      status.out.println(
       "<input name='CODVOC' id='SRWWPHPCUB' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CODVOC,"C",2,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='2' size='2' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='appolire' id='MFRSDQPPEY' class='"+status.ObligatoryClass("Combobox "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"")+"' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_FLAGLIRE),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"disabled":"")+">" +
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
       "<select name='VALUTA' id='JCKYJRZABA' class='"+status.ObligatoryClass("Combobox")+"' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_VALUTA),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
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
       "<select name='FLAGCONT' id='RPHQMPGGQR' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
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
       "<input name='xTOTCONT' id='KUMAEYPETV' type='text' class='"+status.ObligatoryClass("Field "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"")+"",BO.KUMAEYPETV_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_xTOTCONT,"N",15,2,"999,999,999,999.99", status.m_oRegSettings)+" tabindex='-1' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"readonly":"")+" maxlength='21' size='15' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CAMBIO' id='FADDNUEJZJ' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CAMBIO,"N",9,4,"9999.9999", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='12' size='9' fieldtype='N'>" +
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
       "<span class='SPLabel' id='LQQUOWOYQW_DIV'>" +
       "<label id='LQQUOWOYQW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A23. Contanti:"))+"" +
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
       "<span class='SPLabel' id='RPGHLQLUDI_DIV'>" +
       "<label id='RPGHLQLUDI'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A24. Causale Analitica:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GVUCGWQOGG_DIV'>" +
       "<label id='GVUCGWQOGG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("A25. Sintetica:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WDLBZTAAWH_DIV'>" +
       "<label id='WDLBZTAAWH' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_desccauana),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation(BO.w_desccauana)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BPBCTQXMMG_DIV'>" +
       "<label id='BPBCTQXMMG' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_xdesccausin),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation(BO.w_xdesccausin)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='DFNYQWVWJD_DIV'>" +
       "<label id='DFNYQWVWJD' for='XDPPAEWQFR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("ID Causale:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='XCYZDRXAMJ_DIV'>" +
       "<input name='NOSARA' id='XCYZDRXAMJ' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_NOSARA,"C",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq("S",CPLib.Trim(BO.w_NOSARA))?"CHECKED":"")+">" +
       "<label id='XCYZDRXAMJ_LBL' for='XCYZDRXAMJ' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Escludi operazione da S.A.R.A."))+"</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("DatiOperazione@BEGIN") || status.HasZoneAltInterface("DatiOperazione@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b2_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b2_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("DatiOperazione@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("DatiOperazione")) {
      status.out.println("Ctrl('HZHFVWKGKP').style.height='auto';");
    } else {
      status.out.println("Ctrl('HZHFVWKGKP').setAttribute('band_height',176);");
    }
    status.out.println("Ctrl('HZHFVWKGKP').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b3(armt_frazioprovBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_ANGGVVFTIZ")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_ANGGVVFTIZ' style='position:relative;height:1px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_ANGGVVFTIZ")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_ANGGVVFTIZ').style.height='auto';");
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
  void WriteControls_p1_b4(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='DatiCambiaSV' id='ANGGVVFTIZ_DIV' class='BoxContainer SPSection_collapsed SectionContainerWithTitle' style='display:none'>" +
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
     "<div id='ANGGVVFTIZ' class='SectionBody' style='position:relative;height:37px;display:none'>" +
    "");
    status.includeZoneAltInterface("DatiCambiaSV@BEGIN");
    if (status.includeZoneAltInterface("DatiCambiaSV")) {
      WriteControls_p1_b4_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("DatiCambiaSV@BEGIN") || status.HasZoneAltInterface("DatiCambiaSV@END")) {
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
      status.out.println(
       "<span class='SPLabel' id='ZLLARVPZIO_DIV'>" +
       "<label id='ZLLARVPZIO' for='DPCGXWDECV'>" +
       ""+SPLib.ToHTMLRepresentation((CPLib.ne(CPLib.At(BO.w_CODANA,"|DB|DC"),0)?"Importo in Uscita:":"Importo Operazione al netto delle commissioni:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("DatiCambiaSV@BEGIN") || status.HasZoneAltInterface("DatiCambiaSV@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b4_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b4_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("DatiCambiaSV@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("DatiCambiaSV")) {
      status.out.println("Ctrl('ANGGVVFTIZ').style.height='auto';");
    } else {
      status.out.println("Ctrl('ANGGVVFTIZ').setAttribute('band_height',37);");
    }
    status.out.println("Ctrl('ANGGVVFTIZ').setAttribute('status','close');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b5(armt_frazioprovBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_XLSSDAVPDH")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_XLSSDAVPDH' style='position:relative;height:1px;display:block' page='1'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_XLSSDAVPDH")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_XLSSDAVPDH').style.height='auto';");
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
  void WriteControls_p1_b6(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Soggetti' id='XLSSDAVPDH_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
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
     "<div id='XLSSDAVPDH' class='SectionBody' style='position:relative;height:171px;display:block'>" +
    "");
    status.includeZoneAltInterface("Soggetti@BEGIN");
    if (status.includeZoneAltInterface("Soggetti")) {
      WriteControls_p1_b6_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Soggetti@BEGIN") || status.HasZoneAltInterface("Soggetti@END")) {
        status.out.println(
         "<div id='XLSSDAVPDH_boxContent' style='position:relative;height:171px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RAPPORTO' id='RZIQZFKPUE' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RAPPORTO,"C",25,0,"@!", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='25' size='25' fieldtype='C'>" +
       "<button id='RZIQZFKPUE_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "RZIQZFKPUE", "knarapbo", "", "")+"" +
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
       "<input name='PROQUOTA' id='ADUIDSWRJW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PROQUOTA,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
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
       "<select name='TIPOLEG' id='WBHSORBZAV' class='"+status.ObligatoryClass("Combobox",BO.WBHSORBZAV_isObligatory())+"' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_TIPOLEG),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
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
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='CONNALTRO' id='TRNDHQYOXC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_CONNALTRO,"C",16,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='16' size='16' fieldtype='C'>" +
       "<button id='TRNDHQYOXC_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "TRNDHQYOXC", "personbo", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input id='XPWBHUQUGP' type='button' class='SPButton' value="+SPLib.ToHTMLValue(status.context.Translate("Collega"),"C",0,0)+" title="+SPLib.ToHTMLValue(status.context.Translate("Collega le operazioni ai titolari effettivi"),"C",0,0)+" tabindex='"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"-1":""+status.m_nTabIndex+"")+"' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
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
      status.out.println(
       "<span class='SPLabel' id='CMPDPVIXKY_DIV'>" +
       "<label id='CMPDPVIXKY' for='ADUIDSWRJW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("% Pro Quota:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Soggetti@BEGIN") || status.HasZoneAltInterface("Soggetti@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b6_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b6_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Soggetti@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Soggetti")) {
      status.out.println("Ctrl('XLSSDAVPDH').style.height='auto';");
    } else {
      status.out.println("Ctrl('XLSSDAVPDH').setAttribute('band_height',171);");
    }
    status.out.println("Ctrl('XLSSDAVPDH').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b7(armt_frazioprovBO BO,ServletStatus status) {
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
  void WriteControls_p1_b8(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='DatiControparte' id='HGCXMHOHLD_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle' style='display:none'>" +
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
     "<div id='HGCXMHOHLD' class='SectionBody' style='position:relative;height:90px;display:block'>" +
    "");
    status.includeZoneAltInterface("DatiControparte@BEGIN");
    if (status.includeZoneAltInterface("DatiControparte")) {
      WriteControls_p1_b8_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("DatiControparte@BEGIN") || status.HasZoneAltInterface("DatiControparte@END")) {
        status.out.println(
         "<div id='HGCXMHOHLD_boxContent' style='position:relative;height:90px;display:block'>" +
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
       "<a href='javascript:href_FRGXYSRNBR()' tabindex='"+status.m_nTabIndex+"' id='FRGXYSRNBR_HREF' curTabIndex='"+status.m_nTabIndex+"' style='display:none'>" +
       "<span id='FRGXYSRNBR' title="+SPLib.ToHTMLValue(status.context.Translate("Ricerca su Soggetti Segnalati"),"C",0,0)+">" +
       ""+SPLib.ToHTMLRepresentation(Character.toString((char)60124))+"" +
       "</span>" +
       "</a>" +
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
      if (status.HasZoneAltInterface("DatiControparte@BEGIN") || status.HasZoneAltInterface("DatiControparte@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p1_b8_CloseBand(BO,status);
    }
  }
  void WriteControls_p1_b8_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("DatiControparte@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("DatiControparte")) {
      status.out.println("Ctrl('HGCXMHOHLD').style.height='auto';");
    } else {
      status.out.println("Ctrl('HGCXMHOHLD').setAttribute('band_height',90);");
    }
    status.out.println("Ctrl('HGCXMHOHLD').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b9(armt_frazioprovBO BO,ServletStatus status) {
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
  void WriteControls_p1_b10(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='DatiIntermediarioControparte' id='HXTNEUCQUZ_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle' style='display:none'>" +
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
     "<div id='HXTNEUCQUZ' class='SectionBody' style='position:relative;height:171px;display:block'>" +
    "");
    status.includeZoneAltInterface("DatiIntermediarioControparte@BEGIN");
    if (status.includeZoneAltInterface("DatiIntermediarioControparte")) {
      WriteControls_p1_b10_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("DatiIntermediarioControparte@BEGIN") || status.HasZoneAltInterface("DatiIntermediarioControparte@END")) {
        status.out.println(
         "<div id='HXTNEUCQUZ_boxContent' style='position:relative;height:171px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='TIPOINT2' id='OBBUSHLGFO' class='"+status.ObligatoryClass("Combobox",BO.OBBUSHLGFO_isObligatory())+"' title="+SPLib.ToHTMLValue(CPLib.FormatMsg("%1",BO.w_TIPOINT2),"C",0,0)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
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
       "<input name='DESCINTER' id='TYCTKKPTQQ' type='text' class='"+status.ObligatoryClass("Field",BO.TYCTKKPTQQ_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_DESCINTER,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PAESE' id='MUTRCJYNJT' type='text' class='"+status.ObligatoryClass("Field",BO.MUTRCJYNJT_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_PAESE,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
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
       "<input name='CODCAB2' id='CRVLITCYRD' type='text' class='"+status.ObligatoryClass("Field",BO.CRVLITCYRD_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_CODCAB2,"C",6,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='6' size='6' fieldtype='C'>" +
       "<button id='CRVLITCYRD_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "CRVLITCYRD", "tbcitta", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DESC2' id='KDONRVZYMP' type='text' class='"+status.ObligatoryClass("Field",BO.KDONRVZYMP_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_DESC2,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PROV2' id='HWGWORUQJF' type='text' class='"+status.ObligatoryClass("Field",BO.HWGWORUQJF_isObligatory())+"' value="+SPLib.ToHTMLValue(BO.w_PROV2,"C",2,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='2' size='2' fieldtype='C'>" +
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
      WriteControls_p1_b10_1(BO,status);
    }
  }
  void WriteControls_p1_b10_1(armt_frazioprovBO BO,ServletStatus status) {
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
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
     ""+SPLib.ToHTMLRepresentation(status.context.Translate("F31. Conto:"))+"" +
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
    if (status.HasZoneAltInterface("DatiIntermediarioControparte@BEGIN") || status.HasZoneAltInterface("DatiIntermediarioControparte@END")) {
      status.out.println(
       "</div>" +
      "");
    }
    WriteControls_p1_b10_CloseBand(BO,status);
  }
  void WriteControls_p1_b10_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("DatiIntermediarioControparte@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("DatiIntermediarioControparte")) {
      status.out.println("Ctrl('HXTNEUCQUZ').style.height='auto';");
    } else {
      status.out.println("Ctrl('HXTNEUCQUZ').setAttribute('band_height',171);");
    }
    status.out.println("Ctrl('HXTNEUCQUZ').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p1_b11(armt_frazioprovBO BO,ServletStatus status) {
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
  void WriteControls_p2_b0(armt_frazioprovBO BO,ServletStatus status) {
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
  void WriteControls_p2_b1(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Intermediario2' id='HNGGJVVCNB_DIV' class='BoxContainer SPSection_expanded SectionContainerWithoutTitle'>" +
    "");
    status.out.println(
     "<div id='HNGGJVVCNB' class='SectionBody' style='position:relative;height:45px;display:block'>" +
    "");
    status.includeZoneAltInterface("Intermediario2@BEGIN");
    if (status.includeZoneAltInterface("Intermediario2")) {
      WriteControls_p2_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Intermediario2@BEGIN") || status.HasZoneAltInterface("Intermediario2@END")) {
        status.out.println(
         "<div id='HNGGJVVCNB_boxContent' style='position:relative;height:45px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
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
      if (status.HasZoneAltInterface("Intermediario2@BEGIN") || status.HasZoneAltInterface("Intermediario2@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p2_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p2_b1_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Intermediario2@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Intermediario2")) {
      status.out.println("Ctrl('HNGGJVVCNB').style.height='auto';");
    } else {
      status.out.println("Ctrl('HNGGJVVCNB').setAttribute('band_height',45);");
    }
    status.out.println("Ctrl('HNGGJVVCNB').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b2(armt_frazioprovBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_BDZUATYPMW")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_BDZUATYPMW' style='position:relative;height:1px;display:block' page='2'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_BDZUATYPMW")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_BDZUATYPMW').style.height='auto';");
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
  void WriteControls_p2_b3(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='AltriIntestatari' id='BDZUATYPMW_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='BDZUATYPMW_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='BDZUATYPMW_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Altri Intestatari")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='BDZUATYPMW_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"BDZUATYPMW\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=BDZUATYPMW_HEADER&m_cBoxId=BDZUATYPMW&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Altri Intestatari"))+"");
    }
    status.out.println(
     "<div id='BDZUATYPMW' class='CollapsibleBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("AltriIntestatari@BEGIN");
    if (status.includeZoneAltInterface("AltriIntestatari")) {
      WriteControls_p2_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("AltriIntestatari@BEGIN") || status.HasZoneAltInterface("AltriIntestatari@END")) {
        status.out.println(
         "<div id='BDZUATYPMW_boxContent' style='position:relative;display:block'>" +
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
      status.out.println("ToggleCollapsibleBox.subBands['BDZUATYPMW']=['band_2_46','band_2_57','band_2_262'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("AltriIntestatari@BEGIN") || status.HasZoneAltInterface("AltriIntestatari@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p2_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p2_b3_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("AltriIntestatari@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('BDZUATYPMW').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b3_b0(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_46' style='position:relative;height:11px;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b3_b1(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_57' style='position:relative;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='ardt_xlientifrz' id='BOAFVDQFRN' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_2_57']=['BOAFVDQFRN'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b3_b2(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_262' style='position:relative;height:17px;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b4(armt_frazioprovBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_ZYUUSRMPQG")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_ZYUUSRMPQG' style='position:relative;height:9px;display:block' page='2'>" +
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
  void WriteControls_p2_b5(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='AltriEsecutori' id='ZYUUSRMPQG_DIV' class='BoxContainer SPSection_expanded CollapsibleContainerWithTitle'>" +
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
     "<div id='ZYUUSRMPQG' class='CollapsibleBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("AltriEsecutori@BEGIN");
    if (status.includeZoneAltInterface("AltriEsecutori")) {
      WriteControls_p2_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("AltriEsecutori@BEGIN") || status.HasZoneAltInterface("AltriEsecutori@END")) {
        status.out.println(
         "<div id='ZYUUSRMPQG_boxContent' style='position:relative;display:block'>" +
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
      status.out.println("ToggleCollapsibleBox.subBands['ZYUUSRMPQG']=['band_2_288','band_2_297','band_2_452'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("AltriEsecutori@BEGIN") || status.HasZoneAltInterface("AltriEsecutori@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p2_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p2_b5_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("AltriEsecutori@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('ZYUUSRMPQG').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b5_b0(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_288' style='position:relative;height:9px;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b5_b1(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_297' style='position:relative;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='ardt_sogopefrazprov' id='TQDGESLQVD' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_2_297']=['TQDGESLQVD'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p2_b5_b2(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_2_452' style='position:relative;height:16px;display:block' page='2'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p2_b6(armt_frazioprovBO BO,ServletStatus status) {
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
  void WriteControls_p3_b0(armt_frazioprovBO BO,ServletStatus status) {
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
  void WriteControls_p3_b1(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Intermediario3' id='MDLVFVTHTI_DIV' class='BoxContainer SPSection_expanded SectionContainerWithoutTitle'>" +
    "");
    status.out.println(
     "<div id='MDLVFVTHTI' class='SectionBody' style='position:relative;height:45px;display:block'>" +
    "");
    status.includeZoneAltInterface("Intermediario3@BEGIN");
    if (status.includeZoneAltInterface("Intermediario3")) {
      WriteControls_p3_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Intermediario3@BEGIN") || status.HasZoneAltInterface("Intermediario3@END")) {
        status.out.println(
         "<div id='MDLVFVTHTI_boxContent' style='position:relative;height:45px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
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
      if (status.HasZoneAltInterface("Intermediario3@BEGIN") || status.HasZoneAltInterface("Intermediario3@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p3_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p3_b1_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Intermediario3@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Intermediario3")) {
      status.out.println("Ctrl('MDLVFVTHTI').style.height='auto';");
    } else {
      status.out.println("Ctrl('MDLVFVTHTI').setAttribute('band_height',45);");
    }
    status.out.println("Ctrl('MDLVFVTHTI').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p3_b2(armt_frazioprovBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_GTSBULOFTD")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_GTSBULOFTD' style='position:relative;height:1px;display:block' page='3'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_GTSBULOFTD")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_GTSBULOFTD').style.height='auto';");
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
  void WriteControls_p3_b3(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='AltreControparti' id='GTSBULOFTD_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
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
     "<div id='GTSBULOFTD' class='SectionBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("AltreControparti@BEGIN");
    if (status.includeZoneAltInterface("AltreControparti")) {
      WriteControls_p3_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("AltreControparti@BEGIN") || status.HasZoneAltInterface("AltreControparti@END")) {
        status.out.println(
         "<div id='GTSBULOFTD_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p3_b3_b0(BO,status);
      WriteControls_p3_b3_b1(BO,status);
      WriteControls_p3_b3_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['GTSBULOFTD']=['band_3_46','band_3_55','band_3_294'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("AltreControparti@BEGIN") || status.HasZoneAltInterface("AltreControparti@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p3_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p3_b3_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("AltreControparti@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('GTSBULOFTD').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p3_b3_b0(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_46' style='position:relative;height:9px;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b3_b1(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_55' style='position:relative;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='ardt_xeneficfrz' id='OCTDIOXFMI' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_3_55']=['OCTDIOXFMI'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p3_b3_b2(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_294' style='position:relative;height:12px;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b4(armt_frazioprovBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_BHLGNNSXQY")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_BHLGNNSXQY' style='position:relative;height:9px;display:block' page='3'>" +
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
  void WriteControls_p3_b5(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='AltriSoggTerzi' id='BHLGNNSXQY_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
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
     "<div id='BHLGNNSXQY' class='SectionBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("AltriSoggTerzi@BEGIN");
    if (status.includeZoneAltInterface("AltriSoggTerzi")) {
      WriteControls_p3_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("AltriSoggTerzi@BEGIN") || status.HasZoneAltInterface("AltriSoggTerzi@END")) {
        status.out.println(
         "<div id='BHLGNNSXQY_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p3_b5_b0(BO,status);
      WriteControls_p3_b5_b1(BO,status);
      WriteControls_p3_b5_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['BHLGNNSXQY']=['band_3_315','band_3_323','band_3_549'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("AltriSoggTerzi@BEGIN") || status.HasZoneAltInterface("AltriSoggTerzi@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p3_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p3_b5_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("AltriSoggTerzi@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("Ctrl('BHLGNNSXQY').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p3_b5_b0(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_315' style='position:relative;height:8px;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b5_b1(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_323' style='position:relative;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='ardt_xerzistifrz' id='NOKYMTFBFL' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_3_323']=['NOKYMTFBFL'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p3_b5_b2(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_3_549' style='position:relative;height:18px;display:block' page='3'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p3_b6(armt_frazioprovBO BO,ServletStatus status) {
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
  void WriteControls_p4_b0(armt_frazioprovBO BO,ServletStatus status) {
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
  void WriteControls_p4_b1(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Intermediario4' id='EPMKMXEEOS_DIV' class='BoxContainer SPSection_expanded SectionContainerWithoutTitle'>" +
    "");
    status.out.println(
     "<div id='EPMKMXEEOS' class='SectionBody' style='position:relative;height:43px;display:block'>" +
    "");
    status.includeZoneAltInterface("Intermediario4@BEGIN");
    if (status.includeZoneAltInterface("Intermediario4")) {
      WriteControls_p4_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Intermediario4@BEGIN") || status.HasZoneAltInterface("Intermediario4@END")) {
        status.out.println(
         "<div id='EPMKMXEEOS_boxContent' style='position:relative;height:43px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
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
      if (status.HasZoneAltInterface("Intermediario4@BEGIN") || status.HasZoneAltInterface("Intermediario4@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p4_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p4_b1_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Intermediario4@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Intermediario4")) {
      status.out.println("Ctrl('EPMKMXEEOS').style.height='auto';");
    } else {
      status.out.println("Ctrl('EPMKMXEEOS').setAttribute('band_height',43);");
    }
    status.out.println("Ctrl('EPMKMXEEOS').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p4_b2(armt_frazioprovBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_JTWNGHDSFX")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_JTWNGHDSFX' style='position:relative;height:1px;display:block' page='4'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_JTWNGHDSFX")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_JTWNGHDSFX').style.height='auto';");
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
  void WriteControls_p4_b3(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Internet' id='JTWNGHDSFX_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle' style='display:none'>" +
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
     "<div id='JTWNGHDSFX' class='SectionBody' style='position:relative;height:32px;display:block'>" +
    "");
    status.includeZoneAltInterface("Internet@BEGIN");
    if (status.includeZoneAltInterface("Internet")) {
      WriteControls_p4_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Internet@BEGIN") || status.HasZoneAltInterface("Internet@END")) {
        status.out.println(
         "<div id='JTWNGHDSFX_boxContent' style='position:relative;height:32px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<input name='DUCOLLEG' id='IKKFZQQTRR' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DUCOLLEG,"N",10,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='11' size='10' fieldtype='N'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='WAAEZAHSYA_DIV'>" +
       "<label id='WAAEZAHSYA' for='IKKFZQQTRR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Durata Collegamento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='ORACOLLEG' id='USFWBVEHFH' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_ORACOLLEG,"T",8,0,SPLib.GetUserDateTimePicture(status.context.GetLanguage(),"DD-MM-YYYY hh:mm:ss"), status.m_oRegSettings)+" tabindex='-1' readonly maxlength='13' size='8' fieldtype='T'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GETFWUXANX_DIV'>" +
       "<label id='GETFWUXANX' for='USFWBVEHFH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Inizio Collegamento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='IPCOLLEG' id='GOVICFJKZC' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_IPCOLLEG,"C",15,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='15' size='15' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KMKAXHABAG_DIV'>" +
       "<label id='KMKAXHABAG' for='GOVICFJKZC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("IP Collegamento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Internet@BEGIN") || status.HasZoneAltInterface("Internet@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p4_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p4_b3_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
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
      status.out.println("Ctrl('JTWNGHDSFX').setAttribute('band_height',32);");
    }
    status.out.println("Ctrl('JTWNGHDSFX').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p4_b4(armt_frazioprovBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_EOKCAXCLZO")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_EOKCAXCLZO' style='position:relative;height:1px;display:block' page='4'>" +
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
  void WriteControls_p4_b5(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='AGE' id='EOKCAXCLZO_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle' style='display:none'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='EOKCAXCLZO_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='EOKCAXCLZO_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Per Agenzia Entrate")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='EOKCAXCLZO_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"EOKCAXCLZO\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=EOKCAXCLZO_HEADER&m_cBoxId=EOKCAXCLZO&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Per Agenzia Entrate"))+"");
    }
    status.out.println(
     "<div id='EOKCAXCLZO' class='SectionBody' style='position:relative;height:49px;display:block'>" +
    "");
    status.includeZoneAltInterface("AGE@BEGIN");
    if (status.includeZoneAltInterface("AGE")) {
      WriteControls_p4_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("AGE@BEGIN") || status.HasZoneAltInterface("AGE@END")) {
        status.out.println(
         "<div id='EOKCAXCLZO_boxContent' style='position:relative;height:49px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<span id='LEHLEQRJPH_DIV'>" +
       "<input name='NOPROT' id='LEHLEQRJPH' type='checkbox' value="+SPLib.ToHTMLValue(BO.w_NOPROT,"N",1,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' "+(CPLib.eq(1,BO.w_NOPROT)?"CHECKED":"")+">" +
       "<label id='LEHLEQRJPH_LBL' for='LEHLEQRJPH' class='SPLabel'>"+SPLib.ToHTMLRepresentation(status.context.Translate("Non inviare agenzia Entrate"))+"</label>" +
       "</span>" +
      "");
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
      if (status.HasZoneAltInterface("AGE@BEGIN") || status.HasZoneAltInterface("AGE@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p4_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p4_b5_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
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
      status.out.println("Ctrl('EOKCAXCLZO').setAttribute('band_height',49);");
    }
    status.out.println("Ctrl('EOKCAXCLZO').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p4_b6(armt_frazioprovBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_RNCPQBELNU")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_RNCPQBELNU' style='position:relative;height:4px;display:block' page='4'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_RNCPQBELNU")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_RNCPQBELNU').style.height='auto';");
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
  void WriteControls_p4_b7(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Aggiuntivi' id='RNCPQBELNU_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='RNCPQBELNU_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='RNCPQBELNU_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Aggiuntivi")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='RNCPQBELNU_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"RNCPQBELNU\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=RNCPQBELNU_HEADER&m_cBoxId=RNCPQBELNU&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Aggiuntivi"))+"");
    }
    status.out.println(
     "<div id='RNCPQBELNU' class='SectionBody' style='position:relative;height:127px;display:block'>" +
    "");
    status.includeZoneAltInterface("Aggiuntivi@BEGIN");
    if (status.includeZoneAltInterface("Aggiuntivi")) {
      WriteControls_p4_b7_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Aggiuntivi@BEGIN") || status.HasZoneAltInterface("Aggiuntivi@END")) {
        status.out.println(
         "<div id='RNCPQBELNU_boxContent' style='position:relative;height:127px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
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
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='NATURA' id='VSHUPFYWOC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_NATURA,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='SCOPO' id='VASVGQZJGP' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_SCOPO,"C",50,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='50' size='50' fieldtype='C'>" +
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
       "<span class='SPLabel' id='PLAWSVGZSR_DIV'>" +
       "<label id='PLAWSVGZSR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Es. Natura = Mutuo; Scopo = Acquisto beni di consumo"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='UOJWCVBOTW_DIV'>" +
       "<label id='UOJWCVBOTW'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Valutazione: da 0 a 20 Regolare - da 20 a 30 Attenzione  - sopra 30 Anomalia"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MEZPAG' id='JEKLOGLRAN' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MEZPAG,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='RVWYGBVTDV_DIV' style='display:none'>" +
       "<label id='RVWYGBVTDV' for='JEKLOGLRAN'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Mezzo pagamento:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='PRESTAZ' id='RQKHNRJEDR' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_PRESTAZ,"C",30,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='30' size='30' fieldtype='C' style='display:none'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZFGJEWNDTX_DIV' style='display:none'>" +
       "<label id='ZFGJEWNDTX' for='RQKHNRJEDR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Beni Oggetto Incarico:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Aggiuntivi@BEGIN") || status.HasZoneAltInterface("Aggiuntivi@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p4_b7_CloseBand(BO,status);
    }
  }
  void WriteControls_p4_b7_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Aggiuntivi@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Aggiuntivi")) {
      status.out.println("Ctrl('RNCPQBELNU').style.height='auto';");
    } else {
      status.out.println("Ctrl('RNCPQBELNU').setAttribute('band_height',127);");
    }
    status.out.println("Ctrl('RNCPQBELNU').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p4_b8(armt_frazioprovBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_MOGXTATYIF")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_MOGXTATYIF' style='position:relative;height:4px;display:block' page='4'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_MOGXTATYIF")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_MOGXTATYIF').style.height='auto';");
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
  void WriteControls_p4_b9(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='SV' id='MOGXTATYIF_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle' style='display:none'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='MOGXTATYIF_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='MOGXTATYIF_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Segnalazioni di Vigilanza")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='MOGXTATYIF_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"MOGXTATYIF\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=MOGXTATYIF_HEADER&m_cBoxId=MOGXTATYIF&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Segnalazioni di Vigilanza"))+"");
    }
    status.out.println(
     "<div id='MOGXTATYIF' class='SectionBody' style='position:relative;height:54px;display:block'>" +
    "");
    status.includeZoneAltInterface("SV@BEGIN");
    if (status.includeZoneAltInterface("SV")) {
      WriteControls_p4_b9_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("SV@BEGIN") || status.HasZoneAltInterface("SV@END")) {
        status.out.println(
         "<div id='MOGXTATYIF_boxContent' style='position:relative;height:54px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='SV58550' id='SMZCOQAIDC' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("1","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("1",CPLib.Trim(BO.w_SV58550))?"SELECTED":"")+">" +
       ""+status.context.Translate("Modalità tradizionale")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("2","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("2",CPLib.Trim(BO.w_SV58550))?"SELECTED":"")+">" +
       ""+status.context.Translate("Supporti Magnetici e ATM")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("3","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("3",CPLib.Trim(BO.w_SV58550))?"SELECTED":"")+">" +
       ""+status.context.Translate("Collegamenti telematici o telefonici (NO INTERNET)")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("4","C",1,0,"", status.m_oRegSettings)+" "+(CPLib.eq("4",CPLib.Trim(BO.w_SV58550))?"SELECTED":"")+">" +
       ""+status.context.Translate("Internet")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('SMZCOQAIDC'),w_SV58550,'C');" +
       "</script>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='SV58550MA' id='MDVEMSKFNR' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("67","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("67",CPLib.Trim(BO.w_SV58550MA))?"SELECTED":"")+">" +
       ""+status.context.Translate("67 - File Batch")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("68","C",2,0,"", status.m_oRegSettings)+" "+(CPLib.eq("68",CPLib.Trim(BO.w_SV58550MA))?"SELECTED":"")+">" +
       ""+status.context.Translate("68 - Disposizione Singola")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('MDVEMSKFNR'),w_SV58550MA,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BQDHWAMSZF_DIV' style='display:none'>" +
       "<label id='BQDHWAMSZF' for='SMZCOQAIDC'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Modalità bonifico in uscita:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='BRIRCGYFEZ_DIV'>" +
       "<label id='BRIRCGYFEZ' for='MDVEMSKFNR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Modalità di avvio:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("SV@BEGIN") || status.HasZoneAltInterface("SV@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p4_b9_CloseBand(BO,status);
    }
  }
  void WriteControls_p4_b9_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("SV@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("SV")) {
      status.out.println("Ctrl('MOGXTATYIF').style.height='auto';");
    } else {
      status.out.println("Ctrl('MOGXTATYIF').setAttribute('band_height',54);");
    }
    status.out.println("Ctrl('MOGXTATYIF').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p4_b10(armt_frazioprovBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_LLZCQSNQZL")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_LLZCQSNQZL' style='position:relative;height:5px;display:block' page='4'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_LLZCQSNQZL")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_LLZCQSNQZL').style.height='auto';");
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
  void WriteControls_p4_b11(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Contante_Gen' id='LLZCQSNQZL_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle' style='display:none'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='LLZCQSNQZL_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='LLZCQSNQZL_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Dati Generali Contante")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='LLZCQSNQZL_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"LLZCQSNQZL\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=LLZCQSNQZL_HEADER&m_cBoxId=LLZCQSNQZL&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Dati Generali Contante"))+"");
    }
    status.out.println(
     "<div id='LLZCQSNQZL' class='SectionBody' style='position:relative;height:63px;display:block'>" +
    "");
    status.includeZoneAltInterface("Contante_Gen@BEGIN");
    if (status.includeZoneAltInterface("Contante_Gen")) {
      WriteControls_p4_b11_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Contante_Gen@BEGIN") || status.HasZoneAltInterface("Contante_Gen@END")) {
        status.out.println(
         "<div id='LLZCQSNQZL_boxContent' style='position:relative;height:63px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<input name='DESPUNTO' id='DVZEGUGHBR' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_DESPUNTO,"C",80,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='80' size='80' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='GWFAZWBZWG_DIV'>" +
       "<label id='GWFAZWBZWG' for='IDIFNZYSLH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Codice Cliente Contante:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<input name='CODCLICON' id='IDIFNZYSLH' type='text' class='Field Disabled' value="+SPLib.ToHTMLValue(BO.w_CODCLICON,"C",20,0,"", status.m_oRegSettings)+" tabindex='-1' readonly maxlength='20' size='20' fieldtype='C'>" +
      "");
      status.out.println(
       "<select name='TIPATT' id='SOMEUVNZHG' class='Combobox Disabled' disabled>" +
       "<option value="+SPLib.ToHTMLValue("","C",0,0)+">" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("RIT","C",3,0,"", status.m_oRegSettings)+" "+(CPLib.eq("RIT",CPLib.Trim(BO.w_TIPATT))?"SELECTED":"")+">" +
       ""+status.context.Translate("Ritiro")+"" +
       "</option>" +
       "<option value="+SPLib.ToHTMLValue("SOV","C",3,0,"", status.m_oRegSettings)+" "+(CPLib.eq("SOV",CPLib.Trim(BO.w_TIPATT))?"SELECTED":"")+">" +
       ""+status.context.Translate("Sovvenzione")+"" +
       "</option>" +
       "</select>" +
       "<script type='text/javascript'>" +
       "selectCombo(Ctrl('SOMEUVNZHG'),w_TIPATT,'C');" +
       "</script>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='TZYCGKLUVR_DIV'>" +
       "<label id='TZYCGKLUVR' for='SOMEUVNZHG'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo attività:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='IXLIPJPKPM_DIV'>" +
       "<label id='IXLIPJPKPM' for='DVZEGUGHBR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Punto Contante:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Contante_Gen@BEGIN") || status.HasZoneAltInterface("Contante_Gen@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p4_b11_CloseBand(BO,status);
    }
  }
  void WriteControls_p4_b11_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Contante_Gen@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Contante_Gen")) {
      status.out.println("Ctrl('LLZCQSNQZL').style.height='auto';");
    } else {
      status.out.println("Ctrl('LLZCQSNQZL').setAttribute('band_height',63);");
    }
    status.out.println("Ctrl('LLZCQSNQZL').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p4_b12(armt_frazioprovBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_OXFXXISYUL")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_OXFXXISYUL' style='position:relative;height:4px;display:block' page='4'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_OXFXXISYUL")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_OXFXXISYUL').style.height='auto';");
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
  void WriteControls_p4_b13(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='OAM' id='OXFXXISYUL_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='OXFXXISYUL_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='OXFXXISYUL_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("OAM")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='OXFXXISYUL_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"OXFXXISYUL\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=OXFXXISYUL_HEADER&m_cBoxId=OXFXXISYUL&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("OAM"))+"");
    }
    status.out.println(
     "<div id='OXFXXISYUL' class='SectionBody' style='position:relative;height:36px;display:block'>" +
    "");
    status.includeZoneAltInterface("OAM@BEGIN");
    if (status.includeZoneAltInterface("OAM")) {
      WriteControls_p4_b13_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("OAM@BEGIN") || status.HasZoneAltInterface("OAM@END")) {
        status.out.println(
         "<div id='OXFXXISYUL_boxContent' style='position:relative;height:36px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<span class='SPLabel' id='THAPDQIYBH_DIV'>" +
       "<label id='THAPDQIYBH' for='YMKLIGEOKH'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Tipo VASP:"))+"" +
       "</label>" +
       "</span>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='VASP' id='YMKLIGEOKH' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
      "");
      if (status.HasZoneAltInterface("OAM@BEGIN") || status.HasZoneAltInterface("OAM@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p4_b13_CloseBand(BO,status);
    }
  }
  void WriteControls_p4_b13_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("OAM@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("OAM")) {
      status.out.println("Ctrl('OXFXXISYUL').style.height='auto';");
    } else {
      status.out.println("Ctrl('OXFXXISYUL').setAttribute('band_height',36);");
    }
    status.out.println("Ctrl('OXFXXISYUL').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p4_b14(armt_frazioprovBO BO,ServletStatus status) {
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
  void WriteControls_p5_b0(armt_frazioprovBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_5")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_5' style='position:relative;height:0px;display:none' page='5'>" +
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
  void WriteControls_p5_b1(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Intermediario5' id='UMWUWBXDQZ_DIV' class='BoxContainer SPSection_expanded SectionContainerWithoutTitle'>" +
    "");
    status.out.println(
     "<div id='UMWUWBXDQZ' class='SectionBody' style='position:relative;height:45px;display:block'>" +
    "");
    status.includeZoneAltInterface("Intermediario5@BEGIN");
    if (status.includeZoneAltInterface("Intermediario5")) {
      WriteControls_p5_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Intermediario5@BEGIN") || status.HasZoneAltInterface("Intermediario5@END")) {
        status.out.println(
         "<div id='UMWUWBXDQZ_boxContent' style='position:relative;height:45px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
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
      if (status.HasZoneAltInterface("Intermediario5@BEGIN") || status.HasZoneAltInterface("Intermediario5@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p5_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p5_b1_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Intermediario5@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Intermediario5")) {
      status.out.println("Ctrl('UMWUWBXDQZ').style.height='auto';");
    } else {
      status.out.println("Ctrl('UMWUWBXDQZ').setAttribute('band_height',45);");
    }
    status.out.println("Ctrl('UMWUWBXDQZ').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p5_b2(armt_frazioprovBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_WDZXXUSHOC")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_WDZXXUSHOC' style='position:relative;height:1px;display:block' page='5'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_WDZXXUSHOC")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_WDZXXUSHOC').style.height='auto';");
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
  void WriteControls_p5_b3(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Documenti' id='WDZXXUSHOC_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='WDZXXUSHOC_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='WDZXXUSHOC_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Documenti Soggetti Collegati")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='WDZXXUSHOC_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"WDZXXUSHOC\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=WDZXXUSHOC_HEADER&m_cBoxId=WDZXXUSHOC&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Documenti Soggetti Collegati"))+"");
    }
    status.out.println(
     "<div id='WDZXXUSHOC' class='SectionBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("Documenti@BEGIN");
    if (status.includeZoneAltInterface("Documenti")) {
      WriteControls_p5_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Documenti@BEGIN") || status.HasZoneAltInterface("Documenti@END")) {
        status.out.println(
         "<div id='WDZXXUSHOC_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p5_b3_b0(BO,status);
      WriteControls_p5_b3_b1(BO,status);
      WriteControls_p5_b3_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['WDZXXUSHOC']=['band_5_46','band_5_109','band_5_522'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("Documenti@BEGIN") || status.HasZoneAltInterface("Documenti@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p5_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p5_b3_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
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
    status.out.println("Ctrl('WDZXXUSHOC').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p5_b3_b0(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_5_46' style='position:relative;height:63px;display:block' page='5'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
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
  void WriteControls_p5_b3_b1(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_5_109' style='position:relative;display:block' page='5'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='ardt_docfrabo' id='OQWMEPQQNM' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_5_109']=['OQWMEPQQNM'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p5_b3_b2(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_5_522' style='position:relative;height:10px;display:block' page='5'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p5_b4(armt_frazioprovBO BO,ServletStatus status) {
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
  void WriteControls_p6_b0(armt_frazioprovBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_6")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_6' style='position:relative;height:0px;display:none' page='6'>" +
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
  void WriteControls_p6_b1(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Intermediario6' id='GNPYRENPRZ_DIV' class='BoxContainer SPSection_expanded SectionContainerWithoutTitle'>" +
    "");
    status.out.println(
     "<div id='GNPYRENPRZ' class='SectionBody' style='position:relative;height:45px;display:block'>" +
    "");
    status.includeZoneAltInterface("Intermediario6@BEGIN");
    if (status.includeZoneAltInterface("Intermediario6")) {
      WriteControls_p6_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Intermediario6@BEGIN") || status.HasZoneAltInterface("Intermediario6@END")) {
        status.out.println(
         "<div id='GNPYRENPRZ_boxContent' style='position:relative;height:45px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<span class='SPLabel' id='TZVKYZDTVD_DIV'>" +
       "<label id='TZVKYZDTVD'>" +
       ""+SPLib.ToHTMLRepresentation("A01B. Intermediario: "+BO.w_CODINTER)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='HLUTYEAJIP_DIV'>" +
       "<label id='HLUTYEAJIP'>" +
       ""+SPLib.ToHTMLRepresentation("A11. Dipendenza:"+BO.w_CODDIPE)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='KWRAOEORDS_DIV'>" +
       "<label id='KWRAOEORDS'>" +
       ""+SPLib.ToHTMLRepresentation("A12B. Città: "+BO.w_DESCCIT)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PRWFWGAEAD_DIV'>" +
       "<label id='PRWFWGAEAD'>" +
       ""+SPLib.ToHTMLRepresentation(" A12C. Prov.: "+BO.w_PROVINCIA)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='ZBCYGHVZOB_DIV'>" +
       "<label id='ZBCYGHVZOB'>" +
       ""+SPLib.ToHTMLRepresentation("A12A. CAB: "+BO.w_CODCAB)+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Intermediario6@BEGIN") || status.HasZoneAltInterface("Intermediario6@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p6_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p6_b1_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Intermediario6@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Intermediario6")) {
      status.out.println("Ctrl('GNPYRENPRZ').style.height='auto';");
    } else {
      status.out.println("Ctrl('GNPYRENPRZ').setAttribute('band_height',45);");
    }
    status.out.println("Ctrl('GNPYRENPRZ').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p6_b2(armt_frazioprovBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_GMMLWYVNPO")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_GMMLWYVNPO' style='position:relative;height:2px;display:block' page='6'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_GMMLWYVNPO")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_GMMLWYVNPO').style.height='auto';");
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
  void WriteControls_p6_b3(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='IIIDirettiva' id='GMMLWYVNPO_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='GMMLWYVNPO_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='GMMLWYVNPO_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("TIPOLOGIA E VALUTAZIONE RISCHIO (IIIa DIRETTIVA)")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='GMMLWYVNPO_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"GMMLWYVNPO\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=GMMLWYVNPO_HEADER&m_cBoxId=GMMLWYVNPO&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("TIPOLOGIA E VALUTAZIONE RISCHIO (IIIa DIRETTIVA)"))+"");
    }
    status.out.println(
     "<div id='GMMLWYVNPO' class='SectionBody' style='position:relative;height:196px;display:block'>" +
    "");
    status.includeZoneAltInterface("IIIDirettiva@BEGIN");
    if (status.includeZoneAltInterface("IIIDirettiva")) {
      WriteControls_p6_b3_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("IIIDirettiva@BEGIN") || status.HasZoneAltInterface("IIIDirettiva@END")) {
        status.out.println(
         "<div id='GMMLWYVNPO_boxContent' style='position:relative;height:196px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='DURAT' id='CKJQULDXKW' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_DURAT,"C",5,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='5' fieldtype='C'>" +
       "<button id='CKJQULDXKW_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "CKJQULDXKW", "tbdurata", "", "")+"" +
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
       "<input name='TIPO' id='DJOWYRMDDC' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_TIPO,"C",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='3' size='3' fieldtype='C'>" +
       "<button id='DJOWYRMDDC_ZOOM' type='button' class='ZoomButton"+(CPLib.eq(status.m_cClientMode,"query") || CPLib.eq(status.m_cClientMode,"view")?"Disabled":"Enabled")+"' tabindex='-1' "+(CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")?"disabled":"")+">" +
       "</button>" +
       ""+EventuallyContextMenu(status, "DJOWYRMDDC", "tbtiporisc", "", "")+"" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='RTIPO' id='RUWEXWJASG' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_RTIPO,"N",3,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='4' size='3' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<select name='RISGLOB' id='SMVVFHCEHA' class='Combobox' tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"'>" +
       "<option value>" +
       "</option>" +
       "</select>" +
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
       "<span class='SPLabel' id='JKZZQYXAFS_DIV'>" +
       "<label id='JKZZQYXAFS' for='SMVVFHCEHA'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Rischio Globale:"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("IIIDirettiva@BEGIN") || status.HasZoneAltInterface("IIIDirettiva@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p6_b3_CloseBand(BO,status);
    }
  }
  void WriteControls_p6_b3_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("IIIDirettiva@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("IIIDirettiva")) {
      status.out.println("Ctrl('GMMLWYVNPO').style.height='auto';");
    } else {
      status.out.println("Ctrl('GMMLWYVNPO').setAttribute('band_height',196);");
    }
    status.out.println("Ctrl('GMMLWYVNPO').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p6_b4(armt_frazioprovBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_UFFFOVKFCE")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_UFFFOVKFCE' style='position:relative;height:1px;display:block' page='6'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_UFFFOVKFCE")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_UFFFOVKFCE').style.height='auto';");
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
  void WriteControls_p6_b5(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Mitigazione' id='UFFFOVKFCE_DIV' class='BoxContainer SPSection_collapsed SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='UFFFOVKFCE_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='UFFFOVKFCE_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Mitigazione del rischio")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='UFFFOVKFCE_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderExpandImage", "../"+status.m_cTheme+"/formPage/box_expand.gif")+"' onclick='ToggleCollapsibleBox(\"UFFFOVKFCE\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=UFFFOVKFCE_HEADER&m_cBoxId=UFFFOVKFCE&m_cInitialState=close&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Mitigazione del rischio"))+"");
    }
    status.out.println(
     "<div id='UFFFOVKFCE' class='SectionBody' style='position:relative;height:30px;display:none'>" +
    "");
    status.includeZoneAltInterface("Mitigazione@BEGIN");
    if (status.includeZoneAltInterface("Mitigazione")) {
      WriteControls_p6_b5_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Mitigazione@BEGIN") || status.HasZoneAltInterface("Mitigazione@END")) {
        status.out.println(
         "<div id='UFFFOVKFCE_boxContent' style='position:relative;height:30px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MITIG' id='DOXBACRWUU' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MITIG,"N",4,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='5' size='4' fieldtype='N'>" +
      "");
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<input name='MITIGDOC' id='OXGBDTWKSX' type='text' class='Field' value="+SPLib.ToHTMLValue(BO.w_MITIGDOC,"C",100,0,"", status.m_oRegSettings)+" tabindex='"+status.m_nTabIndex+"' curTabIndex='"+status.m_nTabIndex+"' maxlength='100' size='100' fieldtype='C'>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='VCBMHLXJMD_DIV'>" +
       "<label id='VCBMHLXJMD' for='DOXBACRWUU'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("Mitigazione (+/-):"))+"" +
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
      status.out.println(
       "<span class='SPLabel' id='NKPWKMDXUR_DIV'>" +
       "<label id='NKPWKMDXUR'>" +
       ""+SPLib.ToHTMLRepresentation(status.context.Translate("%"))+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Mitigazione@BEGIN") || status.HasZoneAltInterface("Mitigazione@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p6_b5_CloseBand(BO,status);
    }
  }
  void WriteControls_p6_b5_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Mitigazione@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Mitigazione")) {
      status.out.println("Ctrl('UFFFOVKFCE').style.height='auto';");
    } else {
      status.out.println("Ctrl('UFFFOVKFCE').setAttribute('band_height',30);");
    }
    status.out.println("Ctrl('UFFFOVKFCE').setAttribute('status','close');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p6_b6(armt_frazioprovBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_BEFORE_YUNLBUHYXD")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_BEFORE_YUNLBUHYXD' style='position:relative;height:1px;display:block' page='6'>" +
    "");
    if (status.includeZoneAltInterface("shadowBand_BEFORE_YUNLBUHYXD")) {
      status.out.println(
       "</div>" +
      "");
      status.out.println(
       "<script>" +
      "");
      status.out.println("Ctrl('shadowBand_BEFORE_YUNLBUHYXD').style.height='auto';");
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
  void WriteControls_p6_b7(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Categorie' id='YUNLBUHYXD_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='YUNLBUHYXD_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='YUNLBUHYXD_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Categorie")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='YUNLBUHYXD_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"YUNLBUHYXD\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=YUNLBUHYXD_HEADER&m_cBoxId=YUNLBUHYXD&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Categorie"))+"");
    }
    status.out.println(
     "<div id='YUNLBUHYXD' class='SectionBody' style='position:relative;display:block'>" +
    "");
    status.includeZoneAltInterface("Categorie@BEGIN");
    if (status.includeZoneAltInterface("Categorie")) {
      WriteControls_p6_b7_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Categorie@BEGIN") || status.HasZoneAltInterface("Categorie@END")) {
        status.out.println(
         "<div id='YUNLBUHYXD_boxContent' style='position:relative;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      WriteControls_p6_b7_b0(BO,status);
      WriteControls_p6_b7_b1(BO,status);
      WriteControls_p6_b7_b2(BO,status);
      status.out.println(
       "<script>" +
      "");
      status.out.println("ToggleCollapsibleBox.subBands['YUNLBUHYXD']=['band_6_275','band_6_288','band_6_604'];");
      status.out.println(
       "</script>" +
      "");
      if (status.HasZoneAltInterface("Categorie@BEGIN") || status.HasZoneAltInterface("Categorie@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p6_b7_CloseBand(BO,status);
    }
  }
  void WriteControls_p6_b7_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
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
    status.out.println("Ctrl('YUNLBUHYXD').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p6_b7_b0(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_6_275' style='position:relative;height:13px;display:block' page='6'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p6_b7_b1(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_6_288' style='position:relative;display:block' page='6'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.m_nTabIndex = status.m_nTabIndex+(1);
    status.out.println(
     "<iframe name='armt_xraziobo_agg' id='RZOXJTRIYP' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
     "</iframe>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['band_6_288']=['RZOXJTRIYP'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p6_b7_b2(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div id='band_6_604' style='position:relative;height:17px;display:block' page='6'>" +
    "");
    CPResultSet l_rsLoad=null;
    VQRHolder l_VQRHolder=null;
    status.out.println(
     "</div>" +
    "");
  }
  void WriteControls_p6_b8(armt_frazioprovBO BO,ServletStatus status) {
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
  void WriteControls_p7_b0(armt_frazioprovBO BO,ServletStatus status) {
    if (status.IsHiddenZoneAltInterface("shadowBand_TOP_OF_PAGE_7")) {
      return;
    }
    status.out.println(
     "<div id='shadowBand_TOP_OF_PAGE_7' style='position:relative;height:0px;display:none' page='7'>" +
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
  void WriteControls_p7_b1(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Intermediario7' id='ZKIEGJMZVC_DIV' class='BoxContainer SPSection_expanded SectionContainerWithoutTitle'>" +
    "");
    status.out.println(
     "<div id='ZKIEGJMZVC' class='SectionBody' style='position:relative;height:45px;display:block'>" +
    "");
    status.includeZoneAltInterface("Intermediario7@BEGIN");
    if (status.includeZoneAltInterface("Intermediario7")) {
      WriteControls_p7_b1_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Intermediario7@BEGIN") || status.HasZoneAltInterface("Intermediario7@END")) {
        status.out.println(
         "<div id='ZKIEGJMZVC_boxContent' style='position:relative;height:45px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.out.println(
       "<span class='SPLabel' id='NHKIWAWZTC_DIV'>" +
       "<label id='NHKIWAWZTC'>" +
       ""+SPLib.ToHTMLRepresentation("A01B. Intermediario: "+BO.w_CODINTER)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='PFLBLQMSNX_DIV'>" +
       "<label id='PFLBLQMSNX'>" +
       ""+SPLib.ToHTMLRepresentation("A11. Dipendenza:"+BO.w_CODDIPE)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='OSFCYNKIDE_DIV'>" +
       "<label id='OSFCYNKIDE'>" +
       ""+SPLib.ToHTMLRepresentation("A12B. Città: "+BO.w_DESCCIT)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='YXYNFREDGB_DIV'>" +
       "<label id='YXYNFREDGB'>" +
       ""+SPLib.ToHTMLRepresentation(" A12C. Prov.: "+BO.w_PROVINCIA)+"" +
       "</label>" +
       "</span>" +
      "");
      status.out.println(
       "<span class='SPLabel' id='FWBBOFFUEN_DIV'>" +
       "<label id='FWBBOFFUEN'>" +
       ""+SPLib.ToHTMLRepresentation("A12A. CAB: "+BO.w_CODCAB)+"" +
       "</label>" +
       "</span>" +
      "");
      if (status.HasZoneAltInterface("Intermediario7@BEGIN") || status.HasZoneAltInterface("Intermediario7@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p7_b1_CloseBand(BO,status);
    }
  }
  void WriteControls_p7_b1_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Intermediario7@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Intermediario7")) {
      status.out.println("Ctrl('ZKIEGJMZVC').style.height='auto';");
    } else {
      status.out.println("Ctrl('ZKIEGJMZVC').setAttribute('band_height',45);");
    }
    status.out.println("Ctrl('ZKIEGJMZVC').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p7_b2(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<div name='Contante' id='HFENTZBUDL_DIV' class='BoxContainer SPSection_expanded SectionContainerWithTitle'>" +
    "");
    if (CPLib.eq(status.GetBoxHeaderInclude(),"")) {
      status.out.println(
       "<div id='HFENTZBUDL_HEADER' class='BoxHeader'>" +
      "");
      status.out.println(
       "<span id='HFENTZBUDL_HEADER_CAPTION' class='BoxHeaderCaption'>" +
       ""+status.context.Translate("Gestione Contante")+"" +
       "</span>" +
      "");
      status.out.println(
       "<img id='HFENTZBUDL_HEADER_ICON' class='BoxHeaderIcon' src='"+com.zucchetti.sitepainter.Library.GetStyleVariable(status.m_cTheme, "boxHeaderCollapseImage", "../"+status.m_cTheme+"/formPage/box_collapse.gif")+"' onclick='ToggleCollapsibleBox(\"HFENTZBUDL\")' alt='"+status.context.Translate("Expand/Collapse")+"' title='"+status.context.Translate("Expand/Collapse")+"' tabindex='"+status.m_nTabIndex+"'>" +
      "");
      status.out.println(
       "</div>" +
      "");
    } else {
      SPLib.Include(servletContext,status,status.GetBoxHeaderInclude()+"?ForcedPortletUID=HFENTZBUDL_HEADER&m_cBoxId=HFENTZBUDL&m_cInitialState=open&m_cTheme="+status.m_cTheme+"&m_nTabIndex="+status.m_nTabIndex+"&m_cCaption="+com.zucchetti.sitepainter.Library.URLencode(status.context.Translate("Gestione Contante"))+"");
    }
    status.out.println(
     "<div id='HFENTZBUDL' class='SectionBody' style='position:relative;height:720px;display:block'>" +
    "");
    status.includeZoneAltInterface("Contante@BEGIN");
    if (status.includeZoneAltInterface("Contante")) {
      WriteControls_p7_b2_CloseBand(BO,status);
    } else {
      if (status.HasZoneAltInterface("Contante@BEGIN") || status.HasZoneAltInterface("Contante@END")) {
        status.out.println(
         "<div id='HFENTZBUDL_boxContent' style='position:relative;height:720px;display:block'>" +
        "");
      }
      CPResultSet l_rsLoad=null;
      VQRHolder l_VQRHolder=null;
      status.m_nTabIndex = status.m_nTabIndex+(1);
      status.out.println(
       "<iframe name='ardt_xrz_contante' id='QMSPZAQYXJ' frameborder='0' allowtransparency='true' toResize='no' tabindex='"+status.m_nTabIndex+"' src='javascript:[].join()'>" +
       "</iframe>" +
      "");
      if (status.HasZoneAltInterface("Contante@BEGIN") || status.HasZoneAltInterface("Contante@END")) {
        status.out.println(
         "</div>" +
        "");
      }
      WriteControls_p7_b2_CloseBand(BO,status);
    }
  }
  void WriteControls_p7_b2_CloseBand(armt_frazioprovBO BO,ServletStatus status) {
    status.includeZoneAltInterface("Contante@END");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "</div>" +
    "");
    status.out.println(
     "<script>" +
    "");
    if (status.HasZoneAnyAltInterface("Contante")) {
      status.out.println("Ctrl('HFENTZBUDL').style.height='auto';");
    } else {
      status.out.println("Ctrl('HFENTZBUDL').setAttribute('band_height',720);");
    }
    status.out.println("Ctrl('HFENTZBUDL').setAttribute('status','open');");
    status.out.println(
     "</script>" +
    "");
    status.out.println(
     "<script>" +
    "");
    status.out.println("ToggleCollapsibleBox.children['HFENTZBUDL']=['QMSPZAQYXJ'];");
    status.out.println(
     "</script>" +
    "");
  }
  void WriteControls_p7_b3(armt_frazioprovBO BO,ServletStatus status) {
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
  static void PrintState(armt_frazioprovBL BO,ServletStatus status) {
    PrintStateChildren(BO,status);
    PrintStateWorkVars(BO,status);
  }
  static void PrintStateChildren(armt_frazioprovBL BO,ServletStatus status) {
    PrintMNTState(status,BO,BO.m_MNTs);
    if (BO.ardt_xlientifrz.IsUpdated()) {
      BO.m_cWv_ardt_xlientifrz = BO.ardt_xlientifrz.GetContext();
    }
    if (BO.ardt_sogopefrazprov.IsUpdated()) {
      BO.m_cWv_ardt_sogopefrazprov = BO.ardt_sogopefrazprov.GetContext();
    }
    if (BO.ardt_xeneficfrz.IsUpdated()) {
      BO.m_cWv_ardt_xeneficfrz = BO.ardt_xeneficfrz.GetContext();
    }
    if (BO.ardt_xerzistifrz.IsUpdated()) {
      BO.m_cWv_ardt_xerzistifrz = BO.ardt_xerzistifrz.GetContext();
    }
    if (BO.ardt_docfrabo.IsUpdated()) {
      BO.m_cWv_ardt_docfrabo = BO.ardt_docfrabo.GetContext();
    }
    if (BO.armt_xraziobo_agg.IsUpdated()) {
      BO.m_cWv_armt_xraziobo_agg = BO.armt_xraziobo_agg.GetContext();
    }
    if (BO.ardt_xrz_contante.IsUpdated()) {
      BO.m_cWv_ardt_xrz_contante = BO.ardt_xrz_contante.GetContext();
    }
  }
  static void PrintStateWorkVars(armt_frazioprovBL BO,ServletStatus status) {
    status.out.print("DeclareWVs(");
    status.out.print(SPLib.ToJSValue(BO.w_CONNESDOC,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_IDBASE:BO.w_IDBASE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODINTER,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODDIPE,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESCCIT,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINCIA,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODCAB,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAOPE,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NUMPROG,"C",11,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_NUMPROG:BO.w_NUMPROG,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CDATOPE,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CDATAOPE,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ANNOOPE,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAREG,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CDATREG,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGFRAZ,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_COLLEG,"C",12,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOOPRAP,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_idcauana,"C",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODANA,"C",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODVOC,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGLIRE,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VALUTA,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGCONT,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CAMBIO,"N",9,4));
    status.out.print(","+SPLib.ToJSValue(BO.w_IMPIN,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_IMPOUT,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAPPORTO,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CONNESCLI,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROQUOTA,"N",3,0));
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
    status.out.print(","+SPLib.ToJSValue(BO.w_DESC2,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROV2,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ZCPARTE,"C",69,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPOINF,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SEGNO,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDFILE,"C",60,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MTCN,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TOTLIRE,"N",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TOTCONT,"N",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDEREG,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGRAP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OPRAP,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAPPORTBEN,"C",25,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OPERATORE,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AUTOM,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_FLAGRAP2,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PRGIMPFRZ,"N",15,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_PRGIMPFRZ:BO.w_PRGIMPFRZ,"N",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IDBASE2,"C",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOPROT,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_OPERAG,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RESPINS,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_INFORM,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NATURA,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SCOPO,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SV58550,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_SV58550MA,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DURAT,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AMMONT,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_AREAGEO,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MODSVOL,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAGIO,"C",5,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPO,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DUCOLLEG,"N",10,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_ORACOLLEG,"T",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_IPCOLLEG,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MEZPAG,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PRESTAZ,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_NOSARA,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RFREQ,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RIMP,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RAREA,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RCOMP,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RRAGIO,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RTIPO,"N",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RISGLOB,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MITIG,"N",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_MITIGDOC,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DESPUNTO,"C",80,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CODCLICON,"C",20,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_TIPATT,"C",3,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_VASP,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_RIFIMP,"C",15,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xRAGSOCDOC,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gIntemediario,"C",11,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gChkDate,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gTipInter,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gSblocco,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgWU,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gStatus,"C",4,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gDataVaria,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgDoc,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gFlgDTP,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gSeekAos,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_gVerSim,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dataoggi,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_filtro,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_sEdit,"N",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_test,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_datpaseuro,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_tipope,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_stringaflagrap2,"C",9,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_apporeg,"C",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_appolire,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xTOTLIRE,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_xTOTCONT,"N",15,2));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdestipleg,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragsocct,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xDescDipe,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_descdiv,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_valflg2,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragint2,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_errmsg,"C",100,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CABINT,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragsocper,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_desccauana,"C",165,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragsocben,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesccausin,"C",165,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescpaese2,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescrap,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdes1,"C",90,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xcodfisc,"C",16,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdciticon,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_dessta,"C",40,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xragsocalt,"C",70,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xFLGITAEST,"C",1,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CITINT,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CITDIP,"C",30,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVDIP,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_CABDIP,"C",6,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_PROVINT,"C",2,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATAVALI,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_DATARILASC,"D",8,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescopeage,"C",254,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescfreq,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescammo,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescareag,"C",50,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescmodsvo,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdescplauso,"C",200,0));
    status.out.print(","+SPLib.ToJSValue(BO.w_xdesctipor,"C",100,0));
    status.out.print(","+SPLib.ToJSValue("new".equals(status.m_cClientMode)?BO.op_codazi:BO.m_Ctx.GetCompany(),"C",10,0));
    if (CPLib.eq(BO.m_cWv_ardt_xlientifrz,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_xlientifrz");
    } else if (CPLib.eq(BO.m_cWv_ardt_xlientifrz,"_not_empty_")) {
      BO.m_cWv_ardt_xlientifrz = BO.ardt_xlientifrz.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_xlientifrz,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_xlientifrz,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_sogopefrazprov,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_sogopefrazprov");
    } else if (CPLib.eq(BO.m_cWv_ardt_sogopefrazprov,"_not_empty_")) {
      BO.m_cWv_ardt_sogopefrazprov = BO.ardt_sogopefrazprov.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_sogopefrazprov,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_sogopefrazprov,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_xeneficfrz,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_xeneficfrz");
    } else if (CPLib.eq(BO.m_cWv_ardt_xeneficfrz,"_not_empty_")) {
      BO.m_cWv_ardt_xeneficfrz = BO.ardt_xeneficfrz.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_xeneficfrz,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_xeneficfrz,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_xerzistifrz,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_xerzistifrz");
    } else if (CPLib.eq(BO.m_cWv_ardt_xerzistifrz,"_not_empty_")) {
      BO.m_cWv_ardt_xerzistifrz = BO.ardt_xerzistifrz.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_xerzistifrz,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_xerzistifrz,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_docfrabo,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_docfrabo");
    } else if (CPLib.eq(BO.m_cWv_ardt_docfrabo,"_not_empty_")) {
      BO.m_cWv_ardt_docfrabo = BO.ardt_docfrabo.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_docfrabo,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_docfrabo,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_armt_xraziobo_agg,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_armt_xraziobo_agg");
    } else if (CPLib.eq(BO.m_cWv_armt_xraziobo_agg,"_not_empty_")) {
      BO.m_cWv_armt_xraziobo_agg = BO.armt_xraziobo_agg.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_armt_xraziobo_agg,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_armt_xraziobo_agg,"C",0,0));
    }
    if (CPLib.eq(BO.m_cWv_ardt_xrz_contante,"_not_empty_") && status.m_bBrowserUpdate) {
      status.out.print(","+"m_cWv_ardt_xrz_contante");
    } else if (CPLib.eq(BO.m_cWv_ardt_xrz_contante,"_not_empty_")) {
      BO.m_cWv_ardt_xrz_contante = BO.ardt_xrz_contante.GetContext();
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_xrz_contante,"C",0,0));
    } else {
      status.out.print(","+SPLib.ToJSValue(BO.m_cWv_ardt_xrz_contante,"C",0,0));
    }
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print(","+"1");
    }
    status.out.println(")");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.println("m_bUpdated="+SPLib.ToJSValue(BO.m_bUpdated,"L",0,0)+";");
    }
  }
  void WriteMainFormVarScript(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    PrintState(BO,status);
    status.out.println("var e_ZLLARVPZIO = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_HUZWIZYTMV = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_IINONMZPLB = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_PXKFPRTVXX = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_UWUWSYENHG = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_QGPWBVUZYW = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_USZXRLYSFT = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_VPCTBTGNEV = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_CKBXAAYFYL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_RDOJHWCSNP = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_SJNCLQSBKG = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ESVLUSNYWB = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_WDLBZTAAWH = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_BPBCTQXMMG = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_YPYOQUQUZO = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_FSLWEQSSNU = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_UGBWSZCQRL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_HJOXUPJMAI = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_PYRWIMYTNP = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ZYUUSRMPQG = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_TZFLWDFIAF = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_BTOBVVCOML = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_GLUOTVRWBG = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_TBRVQNQTYO = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_LJUWADMQSL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_BHLGNNSXQY = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_AUNJFYUGOI = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_JMALELOJGS = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_DABLCPOUXL = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_HSFSPISTIA = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_IAJSGBSETX = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ILIJSVUNTQ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_UDYBTFTSHB = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_KUHVBYTJII = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_DIUABADXEH = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_JVWAHALTAM = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_GRIUAFUQEF = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_DRRKLKJROO = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_CMKJDFEFFI = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_DXOTWSGBKN = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_FXHEISJAJE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_GHHOMNKDDQ = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_BCFLBBQSRN = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_QEXJCFPJBM = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_TZVKYZDTVD = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_HLUTYEAJIP = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_KWRAOEORDS = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_PRWFWGAEAD = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_ZBCYGHVZOB = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_NHKIWAWZTC = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_PFLBLQMSNX = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_OSFCYNKIDE = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_YXYNFREDGB = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    status.out.println("var e_FWBBOFFUEN = " + SPLib.ToJSValue(m_cEntityUid,"C",0,0)+ ";");
    // hide e disable di pagine ed item
    status.out.println("var m_bQueryOnLatestKeyOnly = " + SPLib.ToJSValue(m_bQueryOnLatestKeyOnly,"L",0,0)+ ";");
    status.out.println("var m_cCaption = " + SPLib.ToJSValue(status.context.Translate(entityGlobals.userName),"C",0,0)+ ";");
    status.out.println("var m_oEnteredInDate;");
    status.out.println("var m_bAlreadySubmitted = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_cBrowser = " + SPLib.ToJSValue(status.m_cBrowser,"C",0,0)+ ";");
    status.out.println("var m_cThemePath = " + SPLib.ToJSValue(status.m_cTheme,"C",0,0)+ ";");
    status.out.println("var m_cDecoration = " + SPLib.ToJSValue(status.m_cDecoration,"C",0,0)+ ";");
    if ( ! (SPLib.IsMobile(status.request))) {
      status.out.println("var m_nPreferredHeight = " + SPLib.ToJSValue(782,"N",0,0)+ ";");
      status.out.println("var m_nPreferredWidth = " + SPLib.ToJSValue(1293,"N",0,0)+ ";");
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
    status.out.println("var m_cSelectedPage = " + SPLib.ToJSValue(SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_frazioprov"),"C",0,0)+ ";");
    status.out.println("var m_bShowSuggest = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowNotifyBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    status.out.println("var m_bShowExtendReduceBtn = " + SPLib.ToJSValue(false,"L",0,0)+ ";");
    HttpSession l_session = ((SPContext)status.context).session;
    status.out.print("var m_IDS={");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      status.out.print("'NNOUMHTLXJ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NNOUMHTLXJ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,intermbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'SDNFDOJDLP':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SDNFDOJDLP",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'XDPPAEWQFR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"XDPPAEWQFR",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcauana,"+"cauinter",l_session)+"'"+"]");
      status.out.print(",'SQVJLYRFKQ':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SQVJLYRFKQ",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcauana,"+"default",l_session)+"'"+"]");
      status.out.print(",'SRWWPHPCUB':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SRWWPHPCUB",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcausin,"+"default",l_session)+"'"+"]");
      status.out.print(",'JCKYJRZABA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"JCKYJRZABA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbvalute,"+"default",l_session)+"'"+"]");
      status.out.print(",'RZIQZFKPUE':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"RZIQZFKPUE",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,knarapbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'QBLXDBODXR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QBLXDBODXR",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'TCOTJNZLGM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"TCOTJNZLGM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'WBHSORBZAV':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash("qbe_tipileg",l_session)+"']");
      status.out.print(",'ULVCBLFVEU':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ULVCBLFVEU",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'TRNDHQYOXC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"TRNDHQYOXC",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'ODAYKSRECA':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ODAYKSRECA",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'YVIKEGPYPM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"YVIKEGPYPM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'OGZBJVOVLN':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"OGZBJVOVLN",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,inter2bo,"+"default",l_session)+"'"+"]");
      status.out.print(",'MUTRCJYNJT':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"MUTRCJYNJT",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'CRVLITCYRD':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"CRVLITCYRD",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'QEFXECTWSF':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QEFXECTWSF",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipope,"+"default",l_session)+"'"+"]");
      status.out.print(",'VMVNJQLPEN':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"VMVNJQLPEN",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbdurata_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'ASETEUZIOS':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"ASETEUZIOS",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbimporto_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'UXDPSYOTRU':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"UXDPSYOTRU",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'VZKBEOYRRK':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"VZKBEOYRRK",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsvolgim_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'NVHOMNEASH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NVHOMNEASH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbplauso_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'XSVOIKCEKR':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"XSVOIKCEKR",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtiporisc_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'EOXCZYYEBY':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"EOXCZYYEBY",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,kersonbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'CKJQULDXKW':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"CKJQULDXKW",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbdurata,"+"default",l_session)+"'"+"]");
      status.out.print(",'SXTYCPHBIM':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SXTYCPHBIM",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbimporto,"+"default",l_session)+"'"+"]");
      status.out.print(",'QJSTZIPOQB':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"QJSTZIPOQB",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog,"+"default",l_session)+"'"+"]");
      status.out.print(",'SFFFOYOWNH':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"SFFFOYOWNH",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsvolgim,"+"default",l_session)+"'"+"]");
      status.out.print(",'NOBMPHKVTX':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"NOBMPHKVTX",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbplauso,"+"default",l_session)+"'"+"]");
      status.out.print(",'DJOWYRMDDC':['"+com.zucchetti.PortalStudio.JSPLib.cmdHash(entityGlobals.name+"DJOWYRMDDC",l_session)+"','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtiporisc,"+"default",l_session)+"'"+"]");
      AppendCallableIDS(status,",");
    } else {
      status.out.print("'NNOUMHTLXJ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,intermbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'SDNFDOJDLP':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,anadip,"+"default",l_session)+"'"+"]");
      status.out.print(",'XDPPAEWQFR':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcauana,"+"cauinter",l_session)+"'"+"]");
      status.out.print(",'SQVJLYRFKQ':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcauana,"+"default",l_session)+"'"+"]");
      status.out.print(",'SRWWPHPCUB':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcausin,"+"default",l_session)+"'"+"]");
      status.out.print(",'JCKYJRZABA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbvalute,"+"default",l_session)+"'"+"]");
      status.out.print(",'RZIQZFKPUE':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,knarapbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'QBLXDBODXR':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'TCOTJNZLGM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'ULVCBLFVEU':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'TRNDHQYOXC':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,personbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'ODAYKSRECA':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'YVIKEGPYPM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'OGZBJVOVLN':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,inter2bo,"+"default",l_session)+"'"+"]");
      status.out.print(",'MUTRCJYNJT':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbstati,"+"default",l_session)+"'"+"]");
      status.out.print(",'CRVLITCYRD':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbcitta,"+"default",l_session)+"'"+"]");
      status.out.print(",'QEFXECTWSF':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtipope,"+"default",l_session)+"'"+"]");
      status.out.print(",'VMVNJQLPEN':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbdurata_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'ASETEUZIOS':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbimporto_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'UXDPSYOTRU':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'VZKBEOYRRK':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsvolgim_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'NVHOMNEASH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbplauso_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'XSVOIKCEKR':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtiporisc_p,"+"default",l_session)+"'"+"]");
      status.out.print(",'EOXCZYYEBY':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,kersonbo,"+"default",l_session)+"'"+"]");
      status.out.print(",'CKJQULDXKW':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbdurata,"+"default",l_session)+"'"+"]");
      status.out.print(",'SXTYCPHBIM':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbimporto,"+"default",l_session)+"'"+"]");
      status.out.print(",'QJSTZIPOQB':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbareegeog,"+"default",l_session)+"'"+"]");
      status.out.print(",'SFFFOYOWNH':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbsvolgim,"+"default",l_session)+"'"+"]");
      status.out.print(",'NOBMPHKVTX':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbplauso,"+"default",l_session)+"'"+"]");
      status.out.print(",'DJOWYRMDDC':['','"+com.zucchetti.PortalStudio.JSPLib.cmdHash("link,tbtiporisc,"+"default",l_session)+"'"+"]");
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
    status.out.println("var m_cProgNameAlter = " + SPLib.ToJSValue("armt_frazioprov","C",0,0)+ ";");
    // hide e disable di pagine ed item
    VRTStateImpl l_vrtState = VRTHolder.GetState(status.context,"armt_frazioprov",BO.GetCurrentState());
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
    if (CPLib.eq(status.GetZoneAltInterface("DatiOperazione"),"")) {
      status.quoteAndAppend("DatiOperazione","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("DatiCambiaSV"),"")) {
      status.quoteAndAppend("DatiCambiaSV","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Soggetti"),"")) {
      status.quoteAndAppend("Soggetti","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("DatiControparte"),"")) {
      status.quoteAndAppend("DatiControparte","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("DatiIntermediarioControparte"),"")) {
      status.quoteAndAppend("DatiIntermediarioControparte","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Intermediario"),"")) {
      status.quoteAndAppend("Intermediario","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Intermediario2"),"")) {
      status.quoteAndAppend("Intermediario2","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("AltriIntestatari"),"")) {
      status.quoteAndAppend("AltriIntestatari","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("AltriEsecutori"),"")) {
      status.quoteAndAppend("AltriEsecutori","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Intermediario3"),"")) {
      status.quoteAndAppend("Intermediario3","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("AltreControparti"),"")) {
      status.quoteAndAppend("AltreControparti","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("AltriSoggTerzi"),"")) {
      status.quoteAndAppend("AltriSoggTerzi","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Intermediario4"),"")) {
      status.quoteAndAppend("Intermediario4","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("AGE"),"")) {
      status.quoteAndAppend("AGE","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Internet"),"")) {
      status.quoteAndAppend("Internet","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Aggiuntivi"),"")) {
      status.quoteAndAppend("Aggiuntivi","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("SV"),"")) {
      status.quoteAndAppend("SV","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Contante_Gen"),"")) {
      status.quoteAndAppend("Contante_Gen","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("OAM"),"")) {
      status.quoteAndAppend("OAM","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Intermediario5"),"")) {
      status.quoteAndAppend("Intermediario5","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Documenti"),"")) {
      status.quoteAndAppend("Documenti","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("IIIDirettiva"),"")) {
      status.quoteAndAppend("IIIDirettiva","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Mitigazione"),"")) {
      status.quoteAndAppend("Mitigazione","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Categorie"),"")) {
      status.quoteAndAppend("Categorie","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Intermediario6"),"")) {
      status.quoteAndAppend("Intermediario6","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Intermediario7"),"")) {
      status.quoteAndAppend("Intermediario7","hide","box");
    }
    if (CPLib.eq(status.GetZoneAltInterface("Contante"),"")) {
      status.quoteAndAppend("Contante","hide","box");
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
  void WriteMainFormScript(armt_frazioprovBO BO,ServletStatus status) {
    status.out.println(
     "<script>" +
    "");
    status.out.println("function OnLoad() {");
    status.out.println("// * --- Area Manuale = UI - OnLoad Init");
    status.out.println("// * --- Fine Area Manuale");
    status.out.println("Z.Tabs.Get('tabs').InitSelect('armt_frazioprov',false);");
    if (CPLib.eq(status.m_cClientMode,"edit") || CPLib.eq(status.m_cClientMode,"new")) {
      WriteJSRestoreEntity(status);
      status.out.println("EnableControlsUnderCondition=EnableControlsUnderCondition_WhenReady;");
      status.out.println("EnableControlsUnderCondition();");
      status.out.println("SetCollapsibleCaptions();");
    } else if (CPLib.eq(status.m_cClientMode,"view") || CPLib.eq(status.m_cClientMode,"query")) {
      WriteJSRestoreEntity(status);
      if (CPLib.eq(status.m_cClientMode,"view")) {
        status.out.println("var c;");
        status.out.println("if(c=Ctrl('NJDOYSOENB')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SDNFDOJDLP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SDNFDOJDLP_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WAAXEDMKXA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WAAXEDMKXA_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QSRYXQJCBZ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XVLCUXTZXI')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XDPPAEWQFR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XDPPAEWQFR_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MFRSDQPPEY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JCKYJRZABA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QOALLRLDKY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RPHQMPGGQR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KUMAEYPETV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('FADDNUEJZJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YXAKYHSWPW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('DPCGXWDECV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RZIQZFKPUE')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RZIQZFKPUE_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QBLXDBODXR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QBLXDBODXR_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ADUIDSWRJW')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TCOTJNZLGM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TCOTJNZLGM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('WBHSORBZAV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TMYVGJFCXV')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ULVCBLFVEU')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ULVCBLFVEU_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TRNDHQYOXC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TRNDHQYOXC_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('AWPNTOJIRR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ODAYKSRECA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('ODAYKSRECA_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('NOTZPDMYIA')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RDAVOEETJG')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('BOTAJBWHHY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VYLHWTRQNX')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YVIKEGPYPM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YVIKEGPYPM_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OBBUSHLGFO')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OGZBJVOVLN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('OGZBJVOVLN_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('TYCTKKPTQQ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MUTRCJYNJT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MUTRCJYNJT_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YBNJCVPDUM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CRVLITCYRD')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('CRVLITCYRD_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KDONRVZYMP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('HWGWORUQJF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RGKPHWRBRT')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('XCYZDRXAMJ')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('LEHLEQRJPH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QEFXECTWSF')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('QEFXECTWSF_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VMRTFBBQHL')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('KDWBJNGUTK')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VSHUPFYWOC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('VASVGQZJGP')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('SMZCOQAIDC')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('MDVEMSKFNR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JEKLOGLRAN')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('RQKHNRJEDR')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('YMKLIGEOKH')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EOXCZYYEBY')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('EOXCZYYEBY_ZOOM')) SetDisabled(c,true);");
        status.out.println("if(c=Ctrl('JDTKGSGMAF')) SetDisabled(c,true);");
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
      status.out.println("if (Ctrl('RZOXJTRIYP')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('RZOXJTRIYP',linkpc_url('RZOXJTRIYP'));");
      status.out.println("}");
      status.out.println("if (Ctrl('QMSPZAQYXJ')) {");
      status.out.println("ChangeIframeSrcWithoutPushingHistory('QMSPZAQYXJ',linkpc_url('QMSPZAQYXJ'));");
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
    status.out.println("if (Eq(name,'ardt_xlientifrz')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_xlientifrz")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_sogopefrazprov')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_sogopefrazprov")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_xeneficfrz')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_xeneficfrz")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_xerzistifrz')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_xerzistifrz")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_docfrabo')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_docfrabo")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'armt_xraziobo_agg')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"armt_xraziobo_agg")+"';");
    status.out.println("return l_cRes;");
    status.out.println("}");
    status.out.println("if (Eq(name,'ardt_xrz_contante')) {");
    status.out.println("l_cRes='"+SPLib.GetSelectedPage(status.m_cSelectedPage,"ardt_xrz_contante")+"';");
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
        status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_IDBASE','PPFRAZ1');");
        status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
        status.out.println("AutonumberApplet().SetProg('IDBASE',w_IDBASE,op_IDBASE,'C',10,0);");
        status.out.println("AutonumberApplet().SetETName('xraziobo');");
        status.out.println("w_IDBASE=AutonumberApplet().GetAutonumberString('IDBASE');");
        status.out.println("}");
      }
      status.out.println("if (l_b1) {");
      status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_NUMPROG','PPFRAZ2');");
      status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
      status.out.println("AutonumberApplet().SetProg('NUMPROG',w_NUMPROG,op_NUMPROG,'C',11,0);");
      status.out.println("AutonumberApplet().SetETName('xraziobo');");
      status.out.println("w_NUMPROG=AutonumberApplet().GetAutonumberString('NUMPROG');");
      status.out.println("}");
      status.out.println("if (l_b2) {");
      status.out.println("AutonumberApplet().SetAutonumber('i_codazi,w_PRGIMPFRZ','PRGIMPFRZ');");
      status.out.println("AutonumberApplet().SetFixedProg('i_codazi',m_cCompany,'C',10,0);");
      status.out.println("AutonumberApplet().SetProg('PRGIMPFRZ',w_PRGIMPFRZ,op_PRGIMPFRZ,'N',15,0);");
      status.out.println("AutonumberApplet().SetETName('xraziobo');");
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
  armt_frazioprovBO getBO(ServletStatus status) {
    armt_frazioprovBO BO = new armt_frazioprovBO(status.context);
    // gli op_ possono essere utilizzati dalla servlet anche prima di essere inizializzati
    BO.op_IDBASE = BO.w_IDBASE;
    BO.op_NUMPROG = BO.w_NUMPROG;
    BO.op_PRGIMPFRZ = BO.w_PRGIMPFRZ;
    LoadExtensions(BO);
    return BO;
  }
  void LoadExtensions(armt_frazioprovBO BO) {
    XDCHolder xdc = CPLib.GetXDCHolder(SPLib.GetClassesPath(),new SPXDCReaderFactory(BO.m_Ctx.GetInstance()),BO.m_Ctx.GetInstance());
    XDCTable t = xdc.GetXDCTable("xraziobo",true);
    BO.extendedFields = CPExtenderLib.GetExtendedItemsFromTable(t);
  }
  public void NotifyEvent(String p_cEvent,ServletStatus status,armt_frazioprovBO BO) {
    super.NotifyEvent(p_cEvent,status,BO);
    if (CPLib.eq(p_cEvent,"Edit Started")) {
      Calculation_NAKGPBRIRV(status,BO);
      Calculation_VWASRYIQTS(status,BO);
    }
    CPLib.NotifyEvent(p_cEvent,BO,BO.m_Ctx,BO.specificEventsHandlers,BO.allEventsHandlers);
  }
  void Calculation_NAKGPBRIRV(ServletStatus status,armt_frazioprovBO BO) {
    BO.w_xTOTLIRE = (CPLib.ge(BO.w_DATAOPE,CPLib.CharToDate("20020101")) || CPLib.le(BO.w_datpaseuro,BO.w_DATAOPE)?BO.w_TOTLIRE/100:BO.w_TOTLIRE);
    BO.w_xTOTCONT = (CPLib.ge(BO.w_DATAOPE,CPLib.CharToDate("20020101")) || CPLib.le(BO.w_datpaseuro,BO.w_DATAOPE)?BO.w_TOTCONT/100:BO.w_TOTCONT);
  }
  void Calculation_VWASRYIQTS(ServletStatus status,armt_frazioprovBO BO) {
    BO.w_FLAGRAP2 = (CPLib.Empty(BO.w_FLAGRAP2)?"1":CPLib.Str(CPLib.Val(BO.w_FLAGRAP2)+1,1,0));
    BO.w_valflg2 = LibreriaMit.NewStato("FRAZIOBO",BO.w_FLAGRAP2);
  }
  void WriteTableCombo(ServletStatus status,armt_frazioprovBO BO) {
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
    status.out.println("var OBBUSHLGFO_Curs = "+l_cTmp+";");
    l_cTmp = "[";
    if (l_rsLoad!=null)
      l_rsLoad.Close();
    l_VQRHolder = new VQRHolder("qbe_tbvasp",com.zucchetti.sitepainter.Library.getVQRReaderFactory(BO.m_Ctx.GetInstance()),BO,false);
    l_VQRHolder.LoadTempWhere("");
    l_VQRHolder.LoadTempOrderBy("CODICE");
    l_rsLoad = l_VQRHolder.GetResultSet(BO.m_Ctx);
    try {
      l_cTmp = l_cTmp+"["+SPLib.ToJSValue("","C",2,0)+","+SPLib.ToJSValue("","C",0,0)+"]";
      while ( ! (l_rsLoad.Eof())) {
        l_cTmp = l_cTmp+",["+SPLib.ToJSValue(l_rsLoad.GetString("CODICE"),"C",2,0)+","+SPLib.ToJSValue(l_rsLoad.GetString("DESCRI"),"C",0,0)+"]";
        l_rsLoad.Next();
      }
    } finally {
      l_rsLoad.Close();
    }
    l_cTmp = l_cTmp+"]";
    status.out.println("var YMKLIGEOKH_Curs = "+l_cTmp+";");
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
  CPResultSet QueryKeyCursor(armt_frazioprovBO BO,ServletStatus status) {
    String l_cServer = BO.m_cServer_xraziobo;
    String l_cPhName = BO.m_cPhName_xraziobo;
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
      String l_cQueryFilter = armt_frazioprovBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsKeys!=null)
        l_rsKeys.Close();
      l_rsKeys = status.context.GetSql().Query(l_cServer,CPSql.BuildSQLPhrase(" "+BO.m_cVirtName_xraziobo+".IDBASE",CPLib.GetTablesWithAliases(l_cPhName,status.m_cAllVirtNames,status.context),l_cLastWhere,status.m_cLastOrderBy));
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
    String l_cServer = status.context.GetServer("xraziobo");
    String l_cPhName = CPSql.ManipulateTablePhName("xraziobo",l_cServer);
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
  void Query(ServletStatus status,armt_frazioprovBO BO) {
    if ( ! (CPLib.Empty(status.m_cLastWhere))) {
      CPResultSet l_rsCount=null;
      String l_cLastWhere = status.m_cLastWhere;
      String l_cQueryFilter = armt_frazioprovBL.QueryFilter(status.context);
      if ( ! (CPLib.Empty(l_cQueryFilter))) {
        if ( ! (CPLib.Empty(l_cLastWhere))) {
          l_cLastWhere = "("+l_cLastWhere+") and";
        }
        l_cLastWhere = l_cLastWhere+" ("+l_cQueryFilter+")";
      }
      if (l_rsCount!=null)
        l_rsCount.Close();
      l_rsCount = BO.m_Sql.Query(BO.m_cServer_xraziobo,CPSql.BuildSQLPhrase(" count(*) as reccount",CPLib.GetTablesWithAliases(BO.m_cPhName_xraziobo,status.m_cAllVirtNames,BO.m_Ctx),l_cLastWhere,""));
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
  void View(ServletStatus status,armt_frazioprovBO BO) {
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
  void Edit(ServletStatus status,armt_frazioprovBO BO,SPParameterSource source) {
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
  void New(ServletStatus status,armt_frazioprovBO BO,SPParameterSource source) {
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
  void Write(ServletStatus status,armt_frazioprovBO BO,SPParameterSource source) {
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
  void LoadCurrentRecord(ServletStatus status,armt_frazioprovBO BO) {
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
  void EditLoad(ServletStatus status,armt_frazioprovBO BO,SPParameterSource source) {
    Edit(status,BO,source);
    if ( ! (BO.m_bLoaded)) {
      status.m_cErrMsg = "";
      status.m_bError = false;
      status.m_bExit = false;
      New(status,BO,source);
    }
  }
  void Delete(ServletStatus status,armt_frazioprovBO BO,SPParameterSource source) {
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
  void DeleteMessage(ServletStatus status,armt_frazioprovBO BO,SPParameterSource source) {
    BO.Load(status.w_IDBASE);
    status.m_cBOWarnMessageDeleted = status.context.Translate("MSG_PROCEED_WITH_DELETE");
    status.m_bExit = true;
    status.m_cClientMode = "bringback";
  }
  void Save(ServletStatus status,armt_frazioprovBO BO) {
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
  void Discard(ServletStatus status,armt_frazioprovBO BO) {
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
  void CreatePortlet(ServletStatus status,armt_frazioprovBO BO) {
    org.json.JSONArray items = new org.json.JSONArray();
    org.json.JSONObject item = new org.json.JSONObject();
    item.put("type","Form");
    item.put("description",entityGlobals.userName);
    item.put("h",699);
    item.put("w",1293);
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
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Dati Aggiuntivi\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Documenti Soggetti\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Gestione Rischio\",\"w\":400}");
    pagesProp.put(pageProp);
    pageProp = new org.json.JSONObject("{\"h\":300,\"layer\":\"\",\"layout_steps_values\":{},\"title\":\"Gestione Contante\",\"w\":400}");
    pagesProp.put(pageProp);
    item.put("pagesProp",pagesProp);
    item.put("pages_names","Principale,Intestatari / Operanti Conto Terzi,Altre Controparti / Altri Soggetti Terzi,Dati Aggiuntivi,Documenti Soggetti,Gestione Rischio,Gestione Contante");
    item.put("altInterfaceFor","armt_frazioprov");
    items.put(item);
    String s;
    org.json.JSONObject ctrl = null;
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Intermediario\",\"box_type\":\"auto_horizontal_section\",\"collapsible\":true,\"comment\":\"Intermediario\",\"h\":45,\"name\":\"Intermediario\",\"page\":1,\"shrinkable\":true,\"spuid\":\"QOEQGFTIYF\",\"stretch\":true,\"tabindex\":177,\"title_caption\":\"Intermediario\",\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag1_1\",\"zonepath\":\"[1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_HBLSDWZPZJ\",\"page\":1,\"spuid\":\"HBLSDWZPZJ\",\"tabindex\":25,\"type\":\"Label\",\"value\":\"A01B. Intermediario:\",\"w\":122,\"x\":14,\"y\":13,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Intermediario\",\"disabled\":\"true\",\"h\":21,\"maxlength\":11,\"name\":\"CODINTER\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"NNOUMHTLXJ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":78,\"x\":139,\"y\":9,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_HZDQOFEXPB\",\"page\":1,\"spuid\":\"HZDQOFEXPB\",\"tabindex\":27,\"type\":\"Label\",\"value\":\"A11. Dipendenza:\",\"w\":93,\"x\":246,\"y\":13,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Dipendenza\",\"h\":21,\"maxlength\":6,\"name\":\"CODDIPE\",\"page\":1,\"picker\":true,\"spuid\":\"SDNFDOJDLP\",\"tabindex\":29,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":344,\"y\":9,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_OIZHYHOJII\",\"page\":1,\"spuid\":\"OIZHYHOJII\",\"tabindex\":30,\"type\":\"Label\",\"value\":\"A12B. Citt\\u00E0:\",\"w\":62,\"x\":445,\"y\":13,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Citt\\u00E0 Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":30,\"name\":\"DESCCIT\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"DHFUAHCMCJ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":160,\"x\":512,\"y\":9,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_IZRUENEKXU\",\"page\":1,\"spuid\":\"IZRUENEKXU\",\"tabindex\":32,\"type\":\"Label\",\"value\":\"A12C. Prov.:\",\"w\":66,\"x\":680,\"y\":13,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Provincia Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":2,\"name\":\"PROVINCIA\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"QTBRDJZGGM\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":751,\"y\":9,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":17,\"name\":\"label_VPEIKRTWFC\",\"page\":1,\"spuid\":\"VPEIKRTWFC\",\"tabindex\":34,\"type\":\"Label\",\"value\":\"A12A. CAB:\",\"w\":64,\"x\":789,\"y\":13,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"CAB Dipendenza\",\"disabled\":\"true\",\"h\":21,\"maxlength\":6,\"name\":\"CODCAB\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"RIKKHKHPLM\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":48,\"x\":856,\"y\":9,\"zone\":\"pag1_1_1\",\"zonepath\":\"[1,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"DatiOperazione\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati operazione\",\"h\":176,\"name\":\"DatiOperazione\",\"page\":1,\"shrinkable\":true,\"spuid\":\"HZHFVWKGKP\",\"stretch\":true,\"tabindex\":20,\"title_caption\":\"Dati operazione\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":45,\"zone\":\"pag1_2\",\"zonepath\":\"[1,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Data Operazione\",\"h\":20,\"maxlength\":10,\"name\":\"DATAOPE\",\"page\":1,\"picker\":true,\"spuid\":\"WAAXEDMKXA\",\"tabindex\":36,\"type\":\"Textbox\",\"typevar\":\"date\",\"w\":80,\"x\":130,\"y\":58,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Numero Progressivo\",\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"NUMPROG\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"XTDANURGMM\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":88,\"x\":400,\"y\":58,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RUVVREGNGP\",\"page\":1,\"spuid\":\"RUVVREGNGP\",\"tabindex\":107,\"type\":\"Label\",\"value\":\"A03. Numero Progressivo:\",\"w\":138,\"x\":259,\"y\":62,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NRJTHQEJCT\",\"page\":1,\"spuid\":\"NRJTHQEJCT\",\"tabindex\":108,\"type\":\"Label\",\"value\":\"A21. Data Operazione:\",\"w\":122,\"x\":5,\"y\":62,\"zone\":\"pag1_2_1\",\"zonepath\":\"[1,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Frazionata (S\\/N)\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"FLAGFRAZ\",\"page\":1,\"spuid\":\"QSRYXQJCBZ\",\"tabindex\":43,\"textlist\":\"Normale,Fraz. Trasferita,Multipla\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"0"+"'"+","+"'"+"1"+"'"+","+"'"+"2"+"'"+"\",\"w\":128,\"x\":130,\"y\":85,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Collegamento Operazione Multiple\",\"disabled\":\"true\",\"h\":20,\"maxlength\":12,\"name\":\"COLLEG\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"FCUPIYMFZB\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":96,\"x\":368,\"y\":85,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RLUNSWADHC\",\"page\":1,\"spuid\":\"RLUNSWADHC\",\"tabindex\":134,\"type\":\"Label\",\"value\":\"A22. Tipo:\",\"w\":122,\"x\":5,\"y\":89,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CNKLWUVOXA\",\"page\":1,\"spuid\":\"CNKLWUVOXA\",\"tabindex\":135,\"type\":\"Label\",\"value\":\"A53. Collegata a:\",\"w\":104,\"x\":262,\"y\":89,\"zone\":\"pag1_2_2\",\"zonepath\":\"[1,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Operazione Completa\",\"h\":20,\"maxlength\":2,\"name\":\"TIPOOPRAP\",\"page\":1,\"spuid\":\"XVLCUXTZXI\",\"tabindex\":45,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":296,\"x\":632,\"y\":85,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KJZKHGDTBV\",\"page\":1,\"spuid\":\"KJZKHGDTBV\",\"tabindex\":118,\"type\":\"Label\",\"value\":\"A52. Tipo Operazione:\",\"w\":118,\"x\":512,\"y\":89,\"zone\":\"pag1_2_3\",\"zonepath\":\"[1,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Causale\",\"h\":20,\"maxlength\":4,\"name\":\"idcauana\",\"page\":1,\"picker\":true,\"spuid\":\"XDPPAEWQFR\",\"tabindex\":46,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":130,\"y\":114,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Causale Analitica\",\"disabled\":\"true\",\"h\":20,\"maxlength\":4,\"name\":\"CODANA\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"SQVJLYRFKQ\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":315,\"y\":114,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RPGHLQLUDI\",\"page\":1,\"spuid\":\"RPGHLQLUDI\",\"tabindex\":171,\"type\":\"Label\",\"value\":\"A24. Causale Analitica:\",\"w\":122,\"x\":189,\"y\":118,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"%w_desccauana%\",\"h\":16,\"name\":\"label_WDLBZTAAWH\",\"page\":1,\"spuid\":\"WDLBZTAAWH\",\"tabindex\":173,\"type\":\"Label\",\"w\":638,\"x\":365,\"y\":118,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DFNYQWVWJD\",\"page\":1,\"spuid\":\"DFNYQWVWJD\",\"tabindex\":175,\"type\":\"Label\",\"value\":\"ID Causale:\",\"w\":122,\"x\":5,\"y\":118,\"zone\":\"pag1_2_4\",\"zonepath\":\"[1,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Causale Sintetica\",\"disabled\":\"true\",\"h\":20,\"maxlength\":2,\"name\":\"CODVOC\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"SRWWPHPCUB\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":40,\"x\":315,\"y\":141,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"B11. Tipo Divisa\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"appolire\",\"page\":1,\"spuid\":\"MFRSDQPPEY\",\"tabindex\":50,\"textlist\":\"Lire,Euro,Valuta Estera\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"L"+"'"+","+"'"+"E"+"'"+","+"'"+"V"+"'"+"\",\"w\":160,\"x\":130,\"y\":168,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"B12. Divisa\",\"h\":20,\"maxlength\":3,\"name\":\"VALUTA\",\"page\":1,\"spuid\":\"JCKYJRZABA\",\"tabindex\":51,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":384,\"x\":384,\"y\":168,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Cambio\",\"h\":20,\"maxlength\":12,\"name\":\"CAMBIO\",\"page\":1,\"spuid\":\"FADDNUEJZJ\",\"tabindex\":55,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":936,\"y\":168,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CEGQRJFFAZ\",\"page\":1,\"spuid\":\"CEGQRJFFAZ\",\"tabindex\":119,\"type\":\"Label\",\"value\":\"B11. Tipo Divisa:\",\"w\":122,\"x\":5,\"y\":172,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JYQAVTDBKY\",\"page\":1,\"spuid\":\"JYQAVTDBKY\",\"tabindex\":120,\"type\":\"Label\",\"value\":\"B12. Divisa:\",\"w\":62,\"x\":321,\"y\":172,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Segno\",\"disabled\":\"true\",\"h\":20,\"maxlength\":1,\"name\":\"SEGNO\",\"page\":1,\"readonly\":\"true\",\"spuid\":\"XESWONRBTH\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":24,\"x\":850,\"y\":168,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AIRYDUUQZV\",\"page\":1,\"spuid\":\"AIRYDUUQZV\",\"tabindex\":122,\"type\":\"Label\",\"value\":\"B13. Segno:\",\"w\":79,\"x\":770,\"y\":172,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TLSZHVBXSN\",\"page\":1,\"spuid\":\"TLSZHVBXSN\",\"tabindex\":128,\"type\":\"Label\",\"value\":\"Cambio:\",\"w\":63,\"x\":872,\"y\":172,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GVUCGWQOGG\",\"page\":1,\"spuid\":\"GVUCGWQOGG\",\"tabindex\":172,\"type\":\"Label\",\"value\":\"A25. Sintetica:\",\"w\":122,\"x\":189,\"y\":145,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"%w_xdesccausin%\",\"h\":16,\"name\":\"label_BPBCTQXMMG\",\"page\":1,\"spuid\":\"BPBCTQXMMG\",\"tabindex\":174,\"type\":\"Label\",\"w\":638,\"x\":365,\"y\":145,\"zone\":\"pag1_2_5\",\"zonepath\":\"[1,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"B14. Totale Euro\",\"h\":20,\"maxlength\":21,\"name\":\"xTOTLIRE\",\"page\":1,\"spuid\":\"QOALLRLDKY\",\"tabindex\":52,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":114,\"x\":130,\"y\":195,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Contanti (S\\/N)\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"FLAGCONT\",\"page\":1,\"spuid\":\"RPHQMPGGQR\",\"tabindex\":53,\"textlist\":\"No,Si\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"0"+"'"+","+"'"+"1"+"'"+"\",\"w\":104,\"x\":352,\"y\":195,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"B15. di cui contanti\",\"h\":20,\"maxlength\":21,\"name\":\"xTOTCONT\",\"page\":1,\"spuid\":\"KUMAEYPETV\",\"tabindex\":54,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":114,\"x\":593,\"y\":195,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LQQUOWOYQW\",\"page\":1,\"spuid\":\"LQQUOWOYQW\",\"tabindex\":109,\"type\":\"Label\",\"value\":\"A23. Contanti:\",\"w\":80,\"x\":271,\"y\":199,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HUZWIZYTMV\",\"page\":1,\"spuid\":\"HUZWIZYTMV\",\"tabindex\":123,\"type\":\"Label\",\"w\":122,\"x\":5,\"y\":199,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PGNMOJFSUL\",\"page\":1,\"spuid\":\"PGNMOJFSUL\",\"tabindex\":124,\"type\":\"Label\",\"value\":\"B15. di cui contanti:\",\"w\":104,\"x\":487,\"y\":199,\"zone\":\"pag1_2_6\",\"zonepath\":\"[1,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"comment\":\"Escludi operazioni soggetto da SARA\",\"h\":21,\"label_text\":\"Escludi operazione da S.A.R.A.\",\"maxlength\":1,\"name\":\"NOSARA\",\"page\":1,\"spuid\":\"XCYZDRXAMJ\",\"tabindex\":176,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":192,\"x\":817,\"y\":194,\"zone\":\"pag1_2_7\",\"zonepath\":\"[1,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"DatiCambiaSV\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Cambiavalute\\/SV\",\"h\":37,\"name\":\"DatiCambiaSV\",\"page\":1,\"shrinkable\":true,\"spuid\":\"ANGGVVFTIZ\",\"stretch\":true,\"tabindex\":21,\"title_caption\":\"Dati Cambiavalute\\/SV\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":222,\"zone\":\"pag1_3\",\"zonepath\":\"[1,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Importo in Entrata\",\"h\":20,\"maxlength\":16,\"name\":\"IMPIN\",\"page\":1,\"spuid\":\"YXAKYHSWPW\",\"tabindex\":56,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":130,\"y\":231,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SIPPFUEECW\",\"page\":1,\"spuid\":\"SIPPFUEECW\",\"tabindex\":57,\"type\":\"Label\",\"value\":\"Importo in Entrata:\",\"w\":122,\"x\":5,\"y\":235,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Importo in Uscita\",\"h\":20,\"maxlength\":16,\"name\":\"IMPOUT\",\"page\":1,\"spuid\":\"DPCGXWDECV\",\"tabindex\":58,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":102,\"x\":596,\"y\":231,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZLLARVPZIO\",\"page\":1,\"spuid\":\"ZLLARVPZIO\",\"tabindex\":59,\"type\":\"Label\",\"w\":296,\"x\":296,\"y\":235,\"zone\":\"pag1_3_1\",\"zonepath\":\"[1,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Soggetti\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Soggetti\\/Rapporti Coinvolti nell"+"'"+"operazione\",\"h\":171,\"name\":\"Soggetti\",\"page\":1,\"shrinkable\":true,\"spuid\":\"XLSSDAVPDH\",\"stretch\":true,\"tabindex\":22,\"title_caption\":\"Dati Soggetti\\/Rapporti Coinvolti nell"+"'"+"operazione\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":260,\"zone\":\"pag1_4\",\"zonepath\":\"[1,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Rapporto Collegato\",\"h\":20,\"maxlength\":25,\"name\":\"RAPPORTO\",\"page\":1,\"picker\":true,\"spuid\":\"RZIQZFKPUE\",\"tabindex\":60,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":162,\"x\":228,\"y\":269,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EXIXNLTCBE\",\"page\":1,\"spuid\":\"EXIXNLTCBE\",\"tabindex\":116,\"type\":\"Label\",\"value\":\"A41. Rapporto Collegato:\",\"w\":216,\"x\":8,\"y\":273,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_UWUWSYENHG\",\"page\":1,\"spuid\":\"UWUWSYENHG\",\"tabindex\":130,\"type\":\"Label\",\"w\":432,\"x\":412,\"y\":273,\"zone\":\"pag1_4_1\",\"zonepath\":\"[1,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Cliente Occasionale\",\"h\":20,\"maxlength\":16,\"name\":\"CONNESCLI\",\"page\":1,\"picker\":true,\"spuid\":\"QBLXDBODXR\",\"tabindex\":61,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":108,\"x\":228,\"y\":296,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"% Pro Quota\",\"h\":20,\"maxlength\":4,\"name\":\"PROQUOTA\",\"page\":1,\"spuid\":\"ADUIDSWRJW\",\"tabindex\":62,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":30,\"x\":859,\"y\":296,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NUEFWOMRRX\",\"page\":1,\"spuid\":\"NUEFWOMRRX\",\"tabindex\":125,\"type\":\"Label\",\"value\":\"C11. Intest. \\/ Cliente Occ.:\",\"w\":216,\"x\":8,\"y\":300,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_PXKFPRTVXX\",\"page\":1,\"spuid\":\"PXKFPRTVXX\",\"tabindex\":129,\"type\":\"Label\",\"w\":412,\"x\":364,\"y\":300,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CMPDPVIXKY\",\"page\":1,\"spuid\":\"CMPDPVIXKY\",\"tabindex\":170,\"type\":\"Label\",\"value\":\"% Pro Quota:\",\"w\":73,\"x\":783,\"y\":300,\"zone\":\"pag1_4_2\",\"zonepath\":\"[1,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Cliente Occasionale\",\"h\":20,\"maxlength\":16,\"name\":\"CONNESOPER\",\"page\":1,\"picker\":true,\"spuid\":\"TCOTJNZLGM\",\"tabindex\":63,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":108,\"x\":228,\"y\":323,\"zone\":\"pag1_4_3\",\"zonepath\":\"[1,4,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IINONMZPLB\",\"page\":1,\"spuid\":\"IINONMZPLB\",\"tabindex\":126,\"type\":\"Label\",\"w\":216,\"x\":8,\"y\":327,\"zone\":\"pag1_4_3\",\"zonepath\":\"[1,4,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_QGPWBVUZYW\",\"page\":1,\"spuid\":\"QGPWBVUZYW\",\"tabindex\":131,\"type\":\"Label\",\"w\":480,\"x\":364,\"y\":327,\"zone\":\"pag1_4_3\",\"zonepath\":\"[1,4,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo Legame\",\"h\":20,\"maxlength\":1,\"name\":\"TIPOLEG\",\"page\":1,\"spuid\":\"WBHSORBZAV\",\"tabindex\":64,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":360,\"x\":228,\"y\":350,\"zone\":\"pag1_4_4\",\"zonepath\":\"[1,4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\""+"'"+"S"+"'"+"\",\"h\":21,\"label_text\":\"Soggetto operante utilizza mezzi propri\",\"maxlength\":1,\"name\":\"PAGASOGOP\",\"page\":1,\"spuid\":\"TMYVGJFCXV\",\"tabindex\":65,\"type\":\"Checkbox\",\"typevar\":\"character\",\"unchecked_value\":\""+"'"+"N"+"'"+"\",\"w\":237,\"x\":648,\"y\":350,\"zone\":\"pag1_4_4\",\"zonepath\":\"[1,4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VECGHPFLII\",\"page\":1,\"spuid\":\"VECGHPFLII\",\"tabindex\":117,\"type\":\"Label\",\"value\":\"A43. Tipo Legame:\",\"w\":216,\"x\":8,\"y\":354,\"zone\":\"pag1_4_4\",\"zonepath\":\"[1,4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Cliente Occasionale\",\"h\":20,\"maxlength\":16,\"name\":\"CONNESBEN\",\"page\":1,\"picker\":true,\"spuid\":\"ULVCBLFVEU\",\"tabindex\":66,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":108,\"x\":228,\"y\":377,\"zone\":\"pag1_4_5\",\"zonepath\":\"[1,4,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LZDWHHTSGR\",\"page\":1,\"spuid\":\"LZDWHHTSGR\",\"tabindex\":127,\"type\":\"Label\",\"value\":\"C31. Controparte Bonifico:\",\"w\":216,\"x\":8,\"y\":381,\"zone\":\"pag1_4_5\",\"zonepath\":\"[1,4,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_USZXRLYSFT\",\"page\":1,\"spuid\":\"USZXRLYSFT\",\"tabindex\":132,\"type\":\"Label\",\"w\":480,\"x\":364,\"y\":381,\"zone\":\"pag1_4_5\",\"zonepath\":\"[1,4,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":16,\"name\":\"CONNALTRO\",\"page\":1,\"picker\":true,\"spuid\":\"TRNDHQYOXC\",\"tabindex\":67,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":108,\"x\":228,\"y\":404,\"zone\":\"pag1_4_6\",\"zonepath\":\"[1,4,6]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_CKBXAAYFYL\",\"page\":1,\"spuid\":\"CKBXAAYFYL\",\"tabindex\":137,\"type\":\"Label\",\"w\":216,\"x\":8,\"y\":408,\"zone\":\"pag1_4_6\",\"zonepath\":\"[1,4,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_RDOJHWCSNP\",\"page\":1,\"spuid\":\"RDOJHWCSNP\",\"tabindex\":138,\"type\":\"Label\",\"w\":480,\"x\":364,\"y\":408,\"zone\":\"pag1_4_6\",\"zonepath\":\"[1,4,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"name\":\"button_XPWBHUQUGP\",\"page\":1,\"picker\":true,\"spuid\":\"XPWBHUQUGP\",\"tabindex\":68,\"type\":\"Button\",\"value\":\"Collega\",\"w\":72,\"x\":925,\"y\":405,\"zone\":\"pag1_4_7\",\"zonepath\":\"[1,4,7]\",\"zoom\":\"usrz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"DatiControparte\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati ControParte\",\"h\":90,\"name\":\"DatiControparte\",\"page\":1,\"shrinkable\":true,\"spuid\":\"HGCXMHOHLD\",\"stretch\":true,\"tabindex\":23,\"title_caption\":\"Dati ControParte\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":432,\"zone\":\"pag1_5\",\"zonepath\":\"[1,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"F11. Denominazione Controparte\",\"h\":20,\"maxlength\":70,\"name\":\"C_RAG\",\"page\":1,\"spuid\":\"AWPNTOJIRR\",\"tabindex\":69,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":432,\"x\":160,\"y\":440,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PFEQRACAUA\",\"page\":1,\"spuid\":\"PFEQRACAUA\",\"tabindex\":163,\"type\":\"Label\",\"value\":\"F11. Denominazione:\",\"w\":149,\"x\":8,\"y\":444,\"zone\":\"pag1_5_1\",\"zonepath\":\"[1,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Ricerca su Soggetti Segnalati\",\"h\":24,\"keep_proportions\":\"bounded\",\"name\":\"image_FRGXYSRNBR\",\"page\":1,\"spuid\":\"FRGXYSRNBR\",\"src\":\"..\\/{\\\"Char\\\":\\\"60124\\\",\\\"Color\\\":\\\"#000000\\\",\\\"FontName\\\":\\\"ZucchettiDevelopement\\\",\\\"FontWeight\\\":\\\"\\\",\\\"Size\\\":\\\"25\\\"}\",\"tabindex\":70,\"type\":\"Image\",\"w\":32,\"x\":968,\"y\":437,\"zone\":\"pag1_5_2\",\"zonepath\":\"[1,5,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"F14B. Comune Controparte\",\"h\":20,\"maxlength\":30,\"name\":\"C_CTA\",\"page\":1,\"picker\":true,\"spuid\":\"ODAYKSRECA\",\"tabindex\":71,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":230,\"x\":160,\"y\":467,\"zone\":\"pag1_5_3\",\"zonepath\":\"[1,5,3]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"F14C. Provincia Controparte\",\"h\":20,\"maxlength\":2,\"name\":\"C_PRV\",\"page\":1,\"spuid\":\"NOTZPDMYIA\",\"tabindex\":72,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":480,\"y\":467,\"zone\":\"pag1_5_3\",\"zonepath\":\"[1,5,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"F16. CAP Controparte\",\"h\":20,\"maxlength\":5,\"name\":\"C_CAP\",\"page\":1,\"spuid\":\"RDAVOEETJG\",\"tabindex\":73,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":592,\"y\":467,\"zone\":\"pag1_5_3\",\"zonepath\":\"[1,5,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"F14A. CAB Controparte\",\"h\":20,\"maxlength\":6,\"name\":\"C_CAB\",\"page\":1,\"spuid\":\"BOTAJBWHHY\",\"tabindex\":74,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":728,\"y\":467,\"zone\":\"pag1_5_3\",\"zonepath\":\"[1,5,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SBJQIAQUCN\",\"page\":1,\"spuid\":\"SBJQIAQUCN\",\"tabindex\":162,\"type\":\"Label\",\"value\":\"F14C. Prov.:\",\"w\":70,\"x\":408,\"y\":471,\"zone\":\"pag1_5_3\",\"zonepath\":\"[1,5,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GDOCAGKROT\",\"page\":1,\"spuid\":\"GDOCAGKROT\",\"tabindex\":166,\"type\":\"Label\",\"value\":\"F16. CAP:\",\"w\":54,\"x\":536,\"y\":471,\"zone\":\"pag1_5_3\",\"zonepath\":\"[1,5,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WHMXTGXWGC\",\"page\":1,\"spuid\":\"WHMXTGXWGC\",\"tabindex\":167,\"type\":\"Label\",\"value\":\"F14A. CAB:\",\"w\":63,\"x\":664,\"y\":471,\"zone\":\"pag1_5_3\",\"zonepath\":\"[1,5,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_XPSQTBKQQZ\",\"page\":1,\"spuid\":\"XPSQTBKQQZ\",\"tabindex\":168,\"type\":\"Label\",\"value\":\"F14B. Comune:\",\"w\":133,\"x\":24,\"y\":471,\"zone\":\"pag1_5_3\",\"zonepath\":\"[1,5,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"F15. Indirizzo Controparte\",\"h\":20,\"maxlength\":35,\"name\":\"C_IND\",\"page\":1,\"spuid\":\"VYLHWTRQNX\",\"tabindex\":75,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":222,\"x\":160,\"y\":494,\"zone\":\"pag1_5_4\",\"zonepath\":\"[1,5,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"F13. Stato Controparte\",\"h\":20,\"maxlength\":3,\"name\":\"C_STA\",\"page\":1,\"picker\":true,\"spuid\":\"YVIKEGPYPM\",\"tabindex\":76,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":480,\"y\":494,\"zone\":\"pag1_5_4\",\"zonepath\":\"[1,5,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RZBLEGCFJJ\",\"page\":1,\"spuid\":\"RZBLEGCFJJ\",\"tabindex\":164,\"type\":\"Label\",\"value\":\"F13. Stato:\",\"w\":76,\"x\":402,\"y\":498,\"zone\":\"pag1_5_4\",\"zonepath\":\"[1,5,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TWTXGZJTAR\",\"page\":1,\"spuid\":\"TWTXGZJTAR\",\"tabindex\":165,\"type\":\"Label\",\"value\":\"F15. Indirizzo:\",\"w\":149,\"x\":8,\"y\":498,\"zone\":\"pag1_5_4\",\"zonepath\":\"[1,5,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_ESVLUSNYWB\",\"page\":1,\"spuid\":\"ESVLUSNYWB\",\"tabindex\":169,\"type\":\"Label\",\"w\":251,\"x\":533,\"y\":498,\"zone\":\"pag1_5_4\",\"zonepath\":\"[1,5,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"DatiIntermediarioControparte\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati eventuale Intermediario ControParte\",\"h\":171,\"name\":\"DatiIntermediarioControparte\",\"page\":1,\"shrinkable\":true,\"spuid\":\"HXTNEUCQUZ\",\"stretch\":true,\"tabindex\":24,\"title_caption\":\"Dati eventuale Intermediario ControParte\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":523,\"zone\":\"pag1_6\",\"zonepath\":\"[1,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"A31A. Tipo Intermediario C\\/Parte\",\"h\":20,\"maxlength\":2,\"name\":\"TIPOINT2\",\"page\":1,\"spuid\":\"OBBUSHLGFO\",\"tabindex\":77,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":720,\"x\":160,\"y\":532,\"zone\":\"pag1_6_1\",\"zonepath\":\"[1,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BXZTUYDDHV\",\"page\":1,\"spuid\":\"BXZTUYDDHV\",\"tabindex\":110,\"type\":\"Label\",\"value\":\"A31A. Tipo Intermediario:\",\"w\":154,\"x\":4,\"y\":536,\"zone\":\"pag1_6_1\",\"zonepath\":\"[1,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Codice Intermediario C\\/Parte\",\"h\":20,\"maxlength\":11,\"name\":\"CODINT2\",\"page\":1,\"picker\":true,\"spuid\":\"OGZBJVOVLN\",\"tabindex\":78,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":94,\"x\":160,\"y\":559,\"zone\":\"pag1_6_2\",\"zonepath\":\"[1,6,2]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DMUKXNHPIX\",\"page\":1,\"spuid\":\"DMUKXNHPIX\",\"tabindex\":111,\"type\":\"Label\",\"value\":\"A31B. Intermediario C\\/Parte:\",\"w\":154,\"x\":4,\"y\":563,\"zone\":\"pag1_6_2\",\"zonepath\":\"[1,6,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"A43. Denominazione Intermediario C\\/Parte\",\"h\":20,\"maxlength\":50,\"name\":\"DESCINTER\",\"page\":1,\"spuid\":\"TYCTKKPTQQ\",\"tabindex\":79,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":328,\"x\":552,\"y\":559,\"zone\":\"pag1_6_3\",\"zonepath\":\"[1,6,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RPVEUGMVLG\",\"page\":1,\"spuid\":\"RPVEUGMVLG\",\"tabindex\":141,\"type\":\"Label\",\"value\":\"A34. Denominazione:\",\"w\":112,\"x\":437,\"y\":563,\"zone\":\"pag1_6_3\",\"zonepath\":\"[1,6,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A32. Stato Intermediario C\\/Parte\",\"h\":20,\"maxlength\":3,\"name\":\"PAESE\",\"page\":1,\"picker\":true,\"spuid\":\"MUTRCJYNJT\",\"tabindex\":80,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":30,\"x\":160,\"y\":586,\"zone\":\"pag1_6_4\",\"zonepath\":\"[1,6,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":25,\"name\":\"C_RAPPORTO\",\"page\":1,\"spuid\":\"YBNJCVPDUM\",\"tabindex\":81,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":168,\"x\":712,\"y\":586,\"zone\":\"pag1_6_4\",\"zonepath\":\"[1,6,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZVNEKPSDJI\",\"page\":1,\"spuid\":\"ZVNEKPSDJI\",\"tabindex\":112,\"type\":\"Label\",\"value\":\"A32. Stato UIF:\",\"w\":154,\"x\":4,\"y\":590,\"zone\":\"pag1_6_4\",\"zonepath\":\"[1,6,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_VPCTBTGNEV\",\"page\":1,\"spuid\":\"VPCTBTGNEV\",\"tabindex\":133,\"type\":\"Label\",\"w\":328,\"x\":216,\"y\":590,\"zone\":\"pag1_6_4\",\"zonepath\":\"[1,6,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RUIGDGZVBM\",\"page\":1,\"spuid\":\"RUIGDGZVBM\",\"tabindex\":139,\"type\":\"Label\",\"value\":\"F31. Conto:\",\"w\":84,\"x\":626,\"y\":590,\"zone\":\"pag1_6_4\",\"zonepath\":\"[1,6,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"A33A. CAB Intermediario C\\/Parte\",\"h\":20,\"maxlength\":6,\"name\":\"CODCAB2\",\"page\":1,\"picker\":true,\"spuid\":\"CRVLITCYRD\",\"tabindex\":82,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":56,\"x\":160,\"y\":613,\"zone\":\"pag1_6_5\",\"zonepath\":\"[1,6,5]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NSQKCLPTTK\",\"page\":1,\"spuid\":\"NSQKCLPTTK\",\"tabindex\":115,\"type\":\"Label\",\"value\":\"A33A. CAB \\/ Comune:\",\"w\":154,\"x\":4,\"y\":617,\"zone\":\"pag1_6_5\",\"zonepath\":\"[1,6,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_SJNCLQSBKG\",\"page\":1,\"spuid\":\"SJNCLQSBKG\",\"tabindex\":140,\"type\":\"Label\",\"w\":400,\"x\":240,\"y\":617,\"zone\":\"pag1_6_5\",\"zonepath\":\"[1,6,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"A33B. Comune Intermediario C\\/Parte\",\"h\":20,\"maxlength\":30,\"name\":\"DESC2\",\"page\":1,\"spuid\":\"KDONRVZYMP\",\"tabindex\":83,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":280,\"x\":160,\"y\":640,\"zone\":\"pag1_6_6\",\"zonepath\":\"[1,6,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_FWWUKUSBMJ\",\"page\":1,\"spuid\":\"FWWUKUSBMJ\",\"tabindex\":113,\"type\":\"Label\",\"value\":\"A33B. Comune per esteso:\",\"w\":154,\"x\":4,\"y\":644,\"zone\":\"pag1_6_6\",\"zonepath\":\"[1,6,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"A33C. Provincia Intermediario C\\/Parte\",\"h\":20,\"maxlength\":2,\"name\":\"PROV2\",\"page\":1,\"spuid\":\"HWGWORUQJF\",\"tabindex\":84,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":32,\"x\":848,\"y\":640,\"zone\":\"pag1_6_7\",\"zonepath\":\"[1,6,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_DFQGTRKLJP\",\"page\":1,\"spuid\":\"DFQGTRKLJP\",\"tabindex\":114,\"type\":\"Label\",\"value\":\"A33C. Provincia:\",\"w\":88,\"x\":758,\"y\":644,\"zone\":\"pag1_6_7\",\"zonepath\":\"[1,6,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":69,\"name\":\"ZCPARTE\",\"page\":1,\"spuid\":\"RGKPHWRBRT\",\"tabindex\":85,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":426,\"x\":160,\"y\":667,\"zone\":\"pag1_6_8\",\"zonepath\":\"[1,6,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_SGPAMGUKLY\",\"page\":1,\"spuid\":\"SGPAMGUKLY\",\"tabindex\":136,\"type\":\"Label\",\"value\":\"Nome per Esteso:\",\"w\":154,\"x\":4,\"y\":671,\"zone\":\"pag1_6_8\",\"zonepath\":\"[1,6,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Intermediario2\",\"box_type\":\"auto_horizontal_section\",\"collapsible\":true,\"comment\":\"Intermediario\",\"h\":45,\"name\":\"Intermediario2\",\"page\":2,\"shrinkable\":true,\"spuid\":\"HNGGJVVCNB\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Intermediario\",\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag2_1\",\"zonepath\":\"[2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_YPYOQUQUZO\",\"page\":2,\"spuid\":\"YPYOQUQUZO\",\"tabindex\":2,\"type\":\"Label\",\"w\":204,\"x\":12,\"y\":14,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_FSLWEQSSNU\",\"page\":2,\"spuid\":\"FSLWEQSSNU\",\"tabindex\":3,\"type\":\"Label\",\"w\":167,\"x\":233,\"y\":14,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_UGBWSZCQRL\",\"page\":2,\"spuid\":\"UGBWSZCQRL\",\"tabindex\":4,\"type\":\"Label\",\"w\":230,\"x\":414,\"y\":14,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_HJOXUPJMAI\",\"page\":2,\"spuid\":\"HJOXUPJMAI\",\"tabindex\":5,\"type\":\"Label\",\"w\":93,\"x\":659,\"y\":14,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_PYRWIMYTNP\",\"page\":2,\"spuid\":\"PYRWIMYTNP\",\"tabindex\":6,\"type\":\"Label\",\"w\":116,\"x\":762,\"y\":14,\"zone\":\"pag2_1_1\",\"zonepath\":\"[2,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"AltriIntestatari\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"Altri Intestatari\",\"h\":233,\"name\":\"AltriIntestatari\",\"page\":2,\"shrinkable\":true,\"spuid\":\"BDZUATYPMW\",\"tabindex\":7,\"title_caption\":\"Altri Intestatari\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":46,\"zone\":\"pag2_2\",\"zonepath\":\"[2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":205,\"name\":\"ardt_xlientifrz\",\"page\":2,\"spuid\":\"BOAFVDQFRN\",\"tabindex\":8,\"type\":\"Iframe\",\"w\":677,\"x\":120,\"y\":57,\"zone\":\"pag2_2_1\",\"zonepath\":\"[2,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"AltriEsecutori\",\"box_type\":\"collapsible\",\"collapsible\":true,\"comment\":\"iif(w_DATAOPE < CharToDate("+"'"+"20140101"+"'"+"),"+"'"+"Altri Soggetti Operanti Conto Terzi"+"'"+","+"'"+"Altri Esecutori"+"'"+")\",\"h\":180,\"name\":\"AltriEsecutori\",\"page\":2,\"shrinkable\":true,\"spuid\":\"ZYUUSRMPQG\",\"tabindex\":9,\"titled\":true,\"type\":\"Box\",\"w\":1017,\"x\":0,\"y\":288,\"zone\":\"pag2_3\",\"zonepath\":\"[2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":155,\"name\":\"ardt_sogopefrazprov\",\"page\":2,\"spuid\":\"TQDGESLQVD\",\"tabindex\":10,\"type\":\"Iframe\",\"w\":681,\"x\":120,\"y\":297,\"zone\":\"pag2_3_1\",\"zonepath\":\"[2,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Intermediario3\",\"box_type\":\"auto_horizontal_section\",\"collapsible\":true,\"comment\":\"Intermediario\",\"h\":45,\"name\":\"Intermediario3\",\"page\":3,\"shrinkable\":true,\"spuid\":\"MDLVFVTHTI\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Intermediario\",\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag3_1\",\"zonepath\":\"[3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_TZFLWDFIAF\",\"page\":3,\"spuid\":\"TZFLWDFIAF\",\"tabindex\":2,\"type\":\"Label\",\"w\":204,\"x\":12,\"y\":14,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_BTOBVVCOML\",\"page\":3,\"spuid\":\"BTOBVVCOML\",\"tabindex\":3,\"type\":\"Label\",\"w\":167,\"x\":233,\"y\":14,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_GLUOTVRWBG\",\"page\":3,\"spuid\":\"GLUOTVRWBG\",\"tabindex\":4,\"type\":\"Label\",\"w\":230,\"x\":414,\"y\":14,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_TBRVQNQTYO\",\"page\":3,\"spuid\":\"TBRVQNQTYO\",\"tabindex\":5,\"type\":\"Label\",\"w\":93,\"x\":659,\"y\":14,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_LJUWADMQSL\",\"page\":3,\"spuid\":\"LJUWADMQSL\",\"tabindex\":6,\"type\":\"Label\",\"w\":116,\"x\":762,\"y\":14,\"zone\":\"pag3_1_1\",\"zonepath\":\"[3,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"AltreControparti\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Controparti\",\"h\":260,\"name\":\"AltreControparti\",\"page\":3,\"shrinkable\":true,\"spuid\":\"GTSBULOFTD\",\"stretch\":true,\"tabindex\":7,\"title_caption\":\"Controparti\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":46,\"zone\":\"pag3_2\",\"zonepath\":\"[3,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":239,\"name\":\"ardt_xeneficfrz\",\"page\":3,\"spuid\":\"OCTDIOXFMI\",\"tabindex\":8,\"type\":\"Iframe\",\"w\":629,\"x\":144,\"y\":55,\"zone\":\"pag3_2_1\",\"zonepath\":\"[3,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"AltriSoggTerzi\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"iif(w_DATAOPE >= CharToDate("+"'"+"20140101"+"'"+"),"+"'"+"Soggetti Terzi:"+"'"+","+"'"+"Titolari Effettivi"+"'"+")\",\"h\":252,\"name\":\"AltriSoggTerzi\",\"page\":3,\"shrinkable\":true,\"spuid\":\"BHLGNNSXQY\",\"stretch\":true,\"tabindex\":9,\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":-8,\"y\":315,\"zone\":\"pag3_3\",\"zonepath\":\"[3,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":226,\"name\":\"ardt_xerzistifrz\",\"page\":3,\"spuid\":\"NOKYMTFBFL\",\"tabindex\":10,\"type\":\"Iframe\",\"w\":629,\"x\":136,\"y\":323,\"zone\":\"pag3_3_1\",\"zonepath\":\"[3,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Intermediario4\",\"box_type\":\"auto_horizontal_section\",\"collapsible\":true,\"comment\":\"Intermediario\",\"h\":43,\"name\":\"Intermediario4\",\"page\":4,\"shrinkable\":true,\"spuid\":\"EPMKMXEEOS\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Intermediario\",\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag4_1\",\"zonepath\":\"[4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_AUNJFYUGOI\",\"page\":4,\"spuid\":\"AUNJFYUGOI\",\"tabindex\":2,\"type\":\"Label\",\"w\":204,\"x\":12,\"y\":14,\"zone\":\"pag4_1_1\",\"zonepath\":\"[4,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_JMALELOJGS\",\"page\":4,\"spuid\":\"JMALELOJGS\",\"tabindex\":3,\"type\":\"Label\",\"w\":167,\"x\":233,\"y\":14,\"zone\":\"pag4_1_1\",\"zonepath\":\"[4,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_DABLCPOUXL\",\"page\":4,\"spuid\":\"DABLCPOUXL\",\"tabindex\":4,\"type\":\"Label\",\"w\":230,\"x\":414,\"y\":14,\"zone\":\"pag4_1_1\",\"zonepath\":\"[4,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_HSFSPISTIA\",\"page\":4,\"spuid\":\"HSFSPISTIA\",\"tabindex\":5,\"type\":\"Label\",\"w\":93,\"x\":659,\"y\":14,\"zone\":\"pag4_1_1\",\"zonepath\":\"[4,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_IAJSGBSETX\",\"page\":4,\"spuid\":\"IAJSGBSETX\",\"tabindex\":6,\"type\":\"Label\",\"w\":116,\"x\":762,\"y\":14,\"zone\":\"pag4_1_1\",\"zonepath\":\"[4,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Internet\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati  Operazione Internet Casino\",\"h\":32,\"name\":\"Internet\",\"page\":4,\"shrinkable\":true,\"spuid\":\"JTWNGHDSFX\",\"stretch\":true,\"tabindex\":45,\"title_caption\":\"Dati  Operazione Internet Casino\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":44,\"zone\":\"pag4_2\",\"zonepath\":\"[4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Durata Collegamento\",\"disabled\":\"true\",\"h\":20,\"maxlength\":11,\"name\":\"DUCOLLEG\",\"page\":4,\"readonly\":\"true\",\"spuid\":\"IKKFZQQTRR\",\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":72,\"x\":731,\"y\":51,\"zone\":\"pag4_2_1\",\"zonepath\":\"[4,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_WAAEZAHSYA\",\"page\":4,\"spuid\":\"WAAEZAHSYA\",\"tabindex\":40,\"type\":\"Label\",\"value\":\"Durata Collegamento:\",\"w\":168,\"x\":560,\"y\":55,\"zone\":\"pag4_2_1\",\"zonepath\":\"[4,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Inizio Collegamento\",\"disabled\":\"true\",\"h\":20,\"maxlength\":13,\"name\":\"ORACOLLEG\",\"page\":4,\"readonly\":\"true\",\"spuid\":\"USFWBVEHFH\",\"type\":\"Textbox\",\"typevar\":\"datetime\",\"w\":112,\"x\":443,\"y\":50,\"zone\":\"pag4_2_1\",\"zonepath\":\"[4,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GETFWUXANX\",\"page\":4,\"spuid\":\"GETFWUXANX\",\"tabindex\":42,\"type\":\"Label\",\"value\":\"Inizio Collegamento:\",\"w\":166,\"x\":272,\"y\":54,\"zone\":\"pag4_2_1\",\"zonepath\":\"[4,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"IP Collegamento\",\"disabled\":\"true\",\"h\":20,\"maxlength\":15,\"name\":\"IPCOLLEG\",\"page\":4,\"readonly\":\"true\",\"spuid\":\"GOVICFJKZC\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":102,\"x\":160,\"y\":50,\"zone\":\"pag4_2_1\",\"zonepath\":\"[4,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_KMKAXHABAG\",\"page\":4,\"spuid\":\"KMKAXHABAG\",\"tabindex\":44,\"type\":\"Label\",\"value\":\"IP Collegamento:\",\"w\":152,\"x\":5,\"y\":54,\"zone\":\"pag4_2_1\",\"zonepath\":\"[4,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"AGE\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Per Agenzia Entrate\",\"h\":49,\"name\":\"AGE\",\"page\":4,\"shrinkable\":true,\"spuid\":\"EOKCAXCLZO\",\"stretch\":true,\"tabindex\":7,\"title_caption\":\"Dati Per Agenzia Entrate\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":77,\"zone\":\"pag4_3\",\"zonepath\":\"[4,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"checked_value\":\"1\",\"h\":21,\"label_text\":\"Non inviare agenzia Entrate\",\"maxlength\":2,\"name\":\"NOPROT\",\"page\":4,\"spuid\":\"LEHLEQRJPH\",\"tabindex\":8,\"type\":\"Checkbox\",\"typevar\":\"numeric\",\"unchecked_value\":\"0\",\"w\":168,\"x\":832,\"y\":90,\"zone\":\"pag4_3_1\",\"zonepath\":\"[4,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":3,\"name\":\"OPERAG\",\"page\":4,\"picker\":true,\"spuid\":\"QEFXECTWSF\",\"tabindex\":9,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":38,\"x\":184,\"y\":90,\"zone\":\"pag4_3_1\",\"zonepath\":\"[4,3,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZEYLNLLVTD\",\"page\":4,\"spuid\":\"ZEYLNLLVTD\",\"tabindex\":11,\"type\":\"Label\",\"value\":\"Tipo Operazione:\",\"w\":169,\"x\":13,\"y\":94,\"zone\":\"pag4_3_1\",\"zonepath\":\"[4,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_ILIJSVUNTQ\",\"page\":4,\"spuid\":\"ILIJSVUNTQ\",\"tabindex\":12,\"type\":\"Label\",\"w\":560,\"x\":242,\"y\":93,\"zone\":\"pag4_3_1\",\"zonepath\":\"[4,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Aggiuntivi\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Aggiuntivi\",\"h\":127,\"name\":\"Aggiuntivi\",\"page\":4,\"shrinkable\":true,\"spuid\":\"RNCPQBELNU\",\"stretch\":true,\"tabindex\":50,\"title_caption\":\"Dati Aggiuntivi\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":130,\"zone\":\"pag4_4\",\"zonepath\":\"[4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":30,\"name\":\"RESPINS\",\"page\":4,\"spuid\":\"VMRTFBBQHL\",\"tabindex\":13,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":208,\"x\":184,\"y\":144,\"zone\":\"pag4_4_1\",\"zonepath\":\"[4,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_AMHSICIBVW\",\"page\":4,\"spuid\":\"AMHSICIBVW\",\"tabindex\":14,\"type\":\"Label\",\"value\":\"Responsabile Inserimento:\",\"w\":169,\"x\":13,\"y\":148,\"zone\":\"pag4_4_1\",\"zonepath\":\"[4,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":30,\"name\":\"INFORM\",\"page\":4,\"spuid\":\"KDWBJNGUTK\",\"tabindex\":15,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":728,\"y\":144,\"zone\":\"pag4_4_2\",\"zonepath\":\"[4,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PZUBJPCOXA\",\"page\":4,\"spuid\":\"PZUBJPCOXA\",\"tabindex\":16,\"type\":\"Label\",\"value\":\"Annotazioni varie:\",\"w\":151,\"x\":573,\"y\":148,\"zone\":\"pag4_4_2\",\"zonepath\":\"[4,4,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":50,\"name\":\"NATURA\",\"page\":4,\"spuid\":\"VSHUPFYWOC\",\"tabindex\":17,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":184,\"y\":171,\"zone\":\"pag4_4_3\",\"zonepath\":\"[4,4,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BVGYBYGMJB\",\"page\":4,\"spuid\":\"BVGYBYGMJB\",\"tabindex\":33,\"type\":\"Label\",\"value\":\"Natura:\",\"w\":169,\"x\":13,\"y\":175,\"zone\":\"pag4_4_3\",\"zonepath\":\"[4,4,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_PLAWSVGZSR\",\"page\":4,\"spuid\":\"PLAWSVGZSR\",\"tabindex\":35,\"type\":\"Label\",\"value\":\"Es. Natura = Mutuo; Scopo = Acquisto beni di consumo\",\"w\":477,\"x\":520,\"y\":175,\"zone\":\"pag4_4_3\",\"zonepath\":\"[4,4,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":50,\"name\":\"SCOPO\",\"page\":4,\"spuid\":\"VASVGQZJGP\",\"tabindex\":18,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":184,\"y\":198,\"zone\":\"pag4_4_4\",\"zonepath\":\"[4,4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EWATRAIADP\",\"page\":4,\"spuid\":\"EWATRAIADP\",\"tabindex\":34,\"type\":\"Label\",\"value\":\"Scopo:\",\"w\":169,\"x\":13,\"y\":202,\"zone\":\"pag4_4_4\",\"zonepath\":\"[4,4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_UOJWCVBOTW\",\"page\":4,\"spuid\":\"UOJWCVBOTW\",\"tabindex\":36,\"type\":\"Label\",\"value\":\"Valutazione: da 0 a 20 Regolare - da 20 a 30 Attenzione  - sopra 30 Anomalia\",\"w\":477,\"x\":520,\"y\":202,\"zone\":\"pag4_4_4\",\"zonepath\":\"[4,4,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Mezzo pagamento\",\"h\":20,\"maxlength\":30,\"name\":\"MEZPAG\",\"page\":4,\"spuid\":\"JEKLOGLRAN\",\"tabindex\":46,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":184,\"y\":225,\"zone\":\"pag4_4_5\",\"zonepath\":\"[4,4,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_RVWYGBVTDV\",\"page\":4,\"spuid\":\"RVWYGBVTDV\",\"tabindex\":47,\"type\":\"Label\",\"value\":\"Mezzo pagamento:\",\"w\":100,\"x\":84,\"y\":229,\"zone\":\"pag4_4_5\",\"zonepath\":\"[4,4,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Beni Oggetto Incarico\",\"h\":20,\"maxlength\":30,\"name\":\"PRESTAZ\",\"page\":4,\"spuid\":\"RQKHNRJEDR\",\"tabindex\":48,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":192,\"x\":560,\"y\":225,\"zone\":\"pag4_4_5\",\"zonepath\":\"[4,4,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZFGJEWNDTX\",\"page\":4,\"spuid\":\"ZFGJEWNDTX\",\"tabindex\":49,\"type\":\"Label\",\"value\":\"Beni Oggetto Incarico:\",\"w\":118,\"x\":442,\"y\":229,\"zone\":\"pag4_4_5\",\"zonepath\":\"[4,4,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"SV\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Segnalazioni di Vigilanza\",\"h\":54,\"name\":\"SV\",\"page\":4,\"shrinkable\":true,\"spuid\":\"MOGXTATYIF\",\"stretch\":true,\"tabindex\":51,\"title_caption\":\"Segnalazioni di Vigilanza\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":261,\"zone\":\"pag4_5\",\"zonepath\":\"[4,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Modalit\\u00E0 bonifico in uscita\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":1,\"name\":\"SV58550\",\"page\":4,\"spuid\":\"SMZCOQAIDC\",\"tabindex\":19,\"textlist\":\"Modalit\\u00E0 tradizionale,Supporti Magnetici e ATM,Collegamenti telematici o telefonici (NO INTERNET),Internet\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"1"+"'"+","+"'"+"2"+"'"+","+"'"+"3"+"'"+","+"'"+"4"+"'"+"\",\"w\":432,\"x\":184,\"y\":279,\"zone\":\"pag4_5_1\",\"zonepath\":\"[4,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Modalit\\u00E0 di avvio\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":2,\"name\":\"SV58550MA\",\"page\":4,\"spuid\":\"MDVEMSKFNR\",\"tabindex\":20,\"textlist\":\"67 - File Batch,68 - Disposizione Singola\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\"\\\"67\\\",\\\"68\\\"\",\"w\":176,\"x\":792,\"y\":279,\"zone\":\"pag4_5_1\",\"zonepath\":\"[4,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BQDHWAMSZF\",\"page\":4,\"spuid\":\"BQDHWAMSZF\",\"tabindex\":37,\"type\":\"Label\",\"value\":\"Modalit\\u00E0 bonifico in uscita:\",\"w\":169,\"x\":8,\"y\":279,\"zone\":\"pag4_5_1\",\"zonepath\":\"[4,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BRIRCGYFEZ\",\"page\":4,\"spuid\":\"BRIRCGYFEZ\",\"tabindex\":38,\"type\":\"Label\",\"value\":\"Modalit\\u00E0 di avvio:\",\"w\":99,\"x\":688,\"y\":279,\"zone\":\"pag4_5_1\",\"zonepath\":\"[4,5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Contante_Gen\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Dati Generali Contante\",\"h\":63,\"name\":\"Contante_Gen\",\"page\":4,\"shrinkable\":true,\"spuid\":\"LLZCQSNQZL\",\"stretch\":true,\"tabindex\":58,\"title_caption\":\"Dati Generali Contante\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":320,\"zone\":\"pag4_6\",\"zonepath\":\"[4,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Punto Contante\",\"disabled\":\"true\",\"h\":20,\"maxlength\":80,\"name\":\"DESPUNTO\",\"page\":4,\"readonly\":\"true\",\"spuid\":\"DVZEGUGHBR\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":492,\"x\":152,\"y\":356,\"zone\":\"pag4_6_1\",\"zonepath\":\"[4,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_GWFAZWBZWG\",\"page\":4,\"spuid\":\"GWFAZWBZWG\",\"tabindex\":53,\"type\":\"Label\",\"value\":\"Codice Cliente Contante:\",\"w\":132,\"x\":580,\"y\":333,\"zone\":\"pag4_6_1\",\"zonepath\":\"[4,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Codice Cliente Contante\",\"disabled\":\"true\",\"h\":20,\"maxlength\":20,\"name\":\"CODCLICON\",\"page\":4,\"readonly\":\"true\",\"spuid\":\"IDIFNZYSLH\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":152,\"x\":712,\"y\":329,\"zone\":\"pag4_6_1\",\"zonepath\":\"[4,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo attivit\\u00E0\",\"disabled\":\"true\",\"empty_value\":\"false\",\"h\":20,\"maxlength\":3,\"name\":\"TIPATT\",\"page\":4,\"readonly\":\"true\",\"spuid\":\"SOMEUVNZHG\",\"textlist\":\"Ritiro,Sovvenzione\",\"type\":\"Combobox\",\"typevar\":\"character\",\"valuelist\":\""+"'"+"RIT"+"'"+","+"'"+"SOV"+"'"+"\",\"w\":184,\"x\":152,\"y\":329,\"zone\":\"pag4_6_1\",\"zonepath\":\"[4,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_TZYCGKLUVR\",\"page\":4,\"spuid\":\"TZYCGKLUVR\",\"tabindex\":56,\"type\":\"Label\",\"value\":\"Tipo attivit\\u00E0:\",\"w\":104,\"x\":48,\"y\":333,\"zone\":\"pag4_6_1\",\"zonepath\":\"[4,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_IXLIPJPKPM\",\"page\":4,\"spuid\":\"IXLIPJPKPM\",\"tabindex\":57,\"type\":\"Label\",\"value\":\"Punto Contante:\",\"w\":88,\"x\":64,\"y\":360,\"zone\":\"pag4_6_1\",\"zonepath\":\"[4,6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"OAM\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"OAM\",\"h\":36,\"name\":\"OAM\",\"page\":4,\"shrinkable\":true,\"spuid\":\"OXFXXISYUL\",\"stretch\":true,\"tabindex\":59,\"title_caption\":\"OAM\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":387,\"zone\":\"pag4_7\",\"zonepath\":\"[4,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_THAPDQIYBH\",\"page\":4,\"spuid\":\"THAPDQIYBH\",\"tabindex\":60,\"type\":\"Label\",\"value\":\"Tipo VASP:\",\"w\":57,\"x\":95,\"y\":400,\"zone\":\"pag4_7_1\",\"zonepath\":\"[4,7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Tipo VASP\",\"h\":20,\"maxlength\":2,\"name\":\"VASP\",\"page\":4,\"spuid\":\"YMKLIGEOKH\",\"tabindex\":61,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":736,\"x\":152,\"y\":396,\"zone\":\"pag4_7_1\",\"zonepath\":\"[4,7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Intermediario5\",\"box_type\":\"auto_horizontal_section\",\"collapsible\":true,\"comment\":\"Intermediario\",\"h\":45,\"name\":\"Intermediario5\",\"page\":5,\"shrinkable\":true,\"spuid\":\"UMWUWBXDQZ\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"Intermediario\",\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag5_1\",\"zonepath\":\"[5,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_UDYBTFTSHB\",\"page\":5,\"spuid\":\"UDYBTFTSHB\",\"tabindex\":2,\"type\":\"Label\",\"w\":204,\"x\":12,\"y\":14,\"zone\":\"pag5_1_1\",\"zonepath\":\"[5,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_KUHVBYTJII\",\"page\":5,\"spuid\":\"KUHVBYTJII\",\"tabindex\":3,\"type\":\"Label\",\"w\":167,\"x\":233,\"y\":14,\"zone\":\"pag5_1_1\",\"zonepath\":\"[5,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_DIUABADXEH\",\"page\":5,\"spuid\":\"DIUABADXEH\",\"tabindex\":4,\"type\":\"Label\",\"w\":230,\"x\":414,\"y\":14,\"zone\":\"pag5_1_1\",\"zonepath\":\"[5,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_JVWAHALTAM\",\"page\":5,\"spuid\":\"JVWAHALTAM\",\"tabindex\":5,\"type\":\"Label\",\"w\":93,\"x\":659,\"y\":14,\"zone\":\"pag5_1_1\",\"zonepath\":\"[5,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_GRIUAFUQEF\",\"page\":5,\"spuid\":\"GRIUAFUQEF\",\"tabindex\":6,\"type\":\"Label\",\"w\":116,\"x\":762,\"y\":14,\"zone\":\"pag5_1_1\",\"zonepath\":\"[5,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Documenti\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Documenti Soggetti Collegati\",\"h\":486,\"name\":\"Documenti\",\"page\":5,\"shrinkable\":true,\"spuid\":\"WDZXXUSHOC\",\"stretch\":true,\"tabindex\":7,\"title_caption\":\"Documenti Soggetti Collegati\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":46,\"zone\":\"pag5_2\",\"zonepath\":\"[5,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_MHQXMCGOMG\",\"page\":5,\"spuid\":\"MHQXMCGOMG\",\"tabindex\":9,\"type\":\"Label\",\"value\":\"Documento:\",\"w\":86,\"x\":8,\"y\":59,\"zone\":\"pag5_2_1\",\"zonepath\":\"[5,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"comment\":\"Storico Documenti\",\"h\":20,\"maxlength\":50,\"name\":\"CONNESDOC\",\"page\":5,\"picker\":true,\"spuid\":\"EOXCZYYEBY\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":312,\"x\":98,\"y\":55,\"zone\":\"pag5_2_1\",\"zonepath\":\"[5,2,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_DRRKLKJROO\",\"page\":5,\"spuid\":\"DRRKLKJROO\",\"tabindex\":11,\"type\":\"Label\",\"w\":480,\"x\":434,\"y\":59,\"zone\":\"pag5_2_1\",\"zonepath\":\"[5,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"ID File\",\"disabled\":\"true\",\"h\":20,\"maxlength\":60,\"name\":\"IDFILE\",\"page\":5,\"readonly\":\"true\",\"spuid\":\"PLFKNICHPU\",\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":372,\"x\":98,\"y\":82,\"zone\":\"pag5_2_2\",\"zonepath\":\"[5,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_BNZLNGZOEF\",\"page\":5,\"spuid\":\"BNZLNGZOEF\",\"tabindex\":14,\"type\":\"Label\",\"value\":\"ID File:\",\"w\":86,\"x\":8,\"y\":86,\"zone\":\"pag5_2_2\",\"zonepath\":\"[5,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":413,\"name\":\"ardt_docfrabo\",\"page\":5,\"spuid\":\"OQWMEPQQNM\",\"tabindex\":8,\"type\":\"Iframe\",\"w\":686,\"x\":127,\"y\":109,\"zone\":\"pag5_2_3\",\"zonepath\":\"[5,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"MTCN\",\"h\":20,\"maxlength\":10,\"name\":\"MTCN\",\"page\":5,\"spuid\":\"JDTKGSGMAF\",\"tabindex\":15,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":72,\"x\":810,\"y\":82,\"zone\":\"pag5_2_3\",\"zonepath\":\"[5,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_EOJCZFADSY\",\"page\":5,\"spuid\":\"EOJCZFADSY\",\"tabindex\":16,\"type\":\"Label\",\"value\":\"MTCN:\",\"w\":48,\"x\":758,\"y\":86,\"zone\":\"pag5_2_3\",\"zonepath\":\"[5,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Intermediario6\",\"box_type\":\"auto_horizontal_section\",\"collapsible\":true,\"comment\":\"Intermediario\",\"h\":45,\"name\":\"Intermediario6\",\"page\":6,\"shrinkable\":true,\"spuid\":\"GNPYRENPRZ\",\"stretch\":true,\"tabindex\":43,\"title_caption\":\"Intermediario\",\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag6_1\",\"zonepath\":\"[6,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_TZVKYZDTVD\",\"page\":6,\"spuid\":\"TZVKYZDTVD\",\"tabindex\":38,\"type\":\"Label\",\"w\":204,\"x\":12,\"y\":14,\"zone\":\"pag6_1_1\",\"zonepath\":\"[6,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_HLUTYEAJIP\",\"page\":6,\"spuid\":\"HLUTYEAJIP\",\"tabindex\":39,\"type\":\"Label\",\"w\":167,\"x\":233,\"y\":14,\"zone\":\"pag6_1_1\",\"zonepath\":\"[6,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_KWRAOEORDS\",\"page\":6,\"spuid\":\"KWRAOEORDS\",\"tabindex\":40,\"type\":\"Label\",\"w\":230,\"x\":414,\"y\":14,\"zone\":\"pag6_1_1\",\"zonepath\":\"[6,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_PRWFWGAEAD\",\"page\":6,\"spuid\":\"PRWFWGAEAD\",\"tabindex\":41,\"type\":\"Label\",\"w\":93,\"x\":659,\"y\":14,\"zone\":\"pag6_1_1\",\"zonepath\":\"[6,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_ZBCYGHVZOB\",\"page\":6,\"spuid\":\"ZBCYGHVZOB\",\"tabindex\":42,\"type\":\"Label\",\"w\":116,\"x\":762,\"y\":14,\"zone\":\"pag6_1_1\",\"zonepath\":\"[6,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"IIIDirettiva\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"TIPOLOGIA E VALUTAZIONE RISCHIO (IIIa DIRETTIVA)\",\"h\":196,\"name\":\"IIIDirettiva\",\"page\":6,\"shrinkable\":true,\"spuid\":\"GMMLWYVNPO\",\"stretch\":true,\"tabindex\":1,\"title_caption\":\"TIPOLOGIA E VALUTAZIONE RISCHIO (IIIa DIRETTIVA)\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":47,\"zone\":\"pag6_2\",\"zonepath\":\"[6,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"DURAT\",\"page\":6,\"picker\":true,\"spuid\":\"CKJQULDXKW\",\"tabindex\":4,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":46,\"x\":200,\"y\":74,\"zone\":\"pag6_2_1\",\"zonepath\":\"[6,2,1]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_ZUVXJIZOSF\",\"page\":6,\"spuid\":\"ZUVXJIZOSF\",\"tabindex\":24,\"type\":\"Label\",\"value\":\"Frequenza:\",\"w\":181,\"x\":16,\"y\":78,\"zone\":\"pag6_2_1\",\"zonepath\":\"[6,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_NWFPTCEPRA\",\"page\":6,\"spuid\":\"NWFPTCEPRA\",\"tabindex\":30,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"TIPOLOGIA RISCHIO\",\"w\":440,\"x\":72,\"y\":54,\"zone\":\"pag6_2_1\",\"zonepath\":\"[6,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_QEXJCFPJBM\",\"page\":6,\"spuid\":\"QEXJCFPJBM\",\"tabindex\":33,\"type\":\"Label\",\"w\":533,\"x\":267,\"y\":78,\"zone\":\"pag6_2_1\",\"zonepath\":\"[6,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"center\",\"h\":16,\"name\":\"label_NFLJJHXTKY\",\"page\":6,\"spuid\":\"NFLJJHXTKY\",\"tabindex\":31,\"type\":\"Label\",\"typevar\":\"character\",\"value\":\"VALUTAZIONE\",\"w\":120,\"x\":824,\"y\":54,\"zone\":\"pag6_2_2\",\"zonepath\":\"[6,2,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RFREQ\",\"page\":6,\"spuid\":\"MXYTQLATHC\",\"tabindex\":5,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":880,\"y\":75,\"zone\":\"pag6_2_3\",\"zonepath\":\"[6,2,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"AMMONT\",\"page\":6,\"picker\":true,\"spuid\":\"SXTYCPHBIM\",\"tabindex\":6,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":46,\"x\":200,\"y\":98,\"zone\":\"pag6_2_4\",\"zonepath\":\"[6,2,4]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LXNMWSOUMF\",\"page\":6,\"spuid\":\"LXNMWSOUMF\",\"tabindex\":25,\"type\":\"Label\",\"value\":\"Importo:\",\"w\":181,\"x\":16,\"y\":102,\"zone\":\"pag6_2_4\",\"zonepath\":\"[6,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_BCFLBBQSRN\",\"page\":6,\"spuid\":\"BCFLBBQSRN\",\"tabindex\":32,\"type\":\"Label\",\"w\":533,\"x\":267,\"y\":102,\"zone\":\"pag6_2_4\",\"zonepath\":\"[6,2,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RIMP\",\"page\":6,\"spuid\":\"KBIUAXUDXA\",\"tabindex\":7,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":880,\"y\":99,\"zone\":\"pag6_2_5\",\"zonepath\":\"[6,2,5]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"AREAGEO\",\"page\":6,\"picker\":true,\"spuid\":\"QJSTZIPOQB\",\"tabindex\":8,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":46,\"x\":200,\"y\":122,\"zone\":\"pag6_2_6\",\"zonepath\":\"[6,2,6]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_NAVNOGNZNE\",\"page\":6,\"spuid\":\"NAVNOGNZNE\",\"tabindex\":20,\"type\":\"Label\",\"value\":\"Area Geografica:\",\"w\":181,\"x\":16,\"y\":126,\"zone\":\"pag6_2_6\",\"zonepath\":\"[6,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_CMKJDFEFFI\",\"page\":6,\"spuid\":\"CMKJDFEFFI\",\"tabindex\":26,\"type\":\"Label\",\"w\":533,\"x\":267,\"y\":126,\"zone\":\"pag6_2_6\",\"zonepath\":\"[6,2,6]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RAREA\",\"page\":6,\"spuid\":\"UDAYHICPVB\",\"tabindex\":9,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":880,\"y\":123,\"zone\":\"pag6_2_7\",\"zonepath\":\"[6,2,7]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"MODSVOL\",\"page\":6,\"picker\":true,\"spuid\":\"SFFFOYOWNH\",\"tabindex\":10,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":46,\"x\":200,\"y\":146,\"zone\":\"pag6_2_8\",\"zonepath\":\"[6,2,8]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_LHTXLTQYIK\",\"page\":6,\"spuid\":\"LHTXLTQYIK\",\"tabindex\":21,\"type\":\"Label\",\"value\":\"Svol. Instaurazione Operaz.:\",\"w\":181,\"x\":16,\"y\":150,\"zone\":\"pag6_2_8\",\"zonepath\":\"[6,2,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_DXOTWSGBKN\",\"page\":6,\"spuid\":\"DXOTWSGBKN\",\"tabindex\":27,\"type\":\"Label\",\"w\":533,\"x\":267,\"y\":150,\"zone\":\"pag6_2_8\",\"zonepath\":\"[6,2,8]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RCOMP\",\"page\":6,\"spuid\":\"ETALZDRBSO\",\"tabindex\":11,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":880,\"y\":147,\"zone\":\"pag6_2_9\",\"zonepath\":\"[6,2,9]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":5,\"name\":\"RAGIO\",\"page\":6,\"picker\":true,\"spuid\":\"NOBMPHKVTX\",\"tabindex\":12,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":46,\"x\":200,\"y\":170,\"zone\":\"pag6_2_10\",\"zonepath\":\"[6,2,10]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_HGXSBHTFKF\",\"page\":6,\"spuid\":\"HGXSBHTFKF\",\"tabindex\":22,\"type\":\"Label\",\"value\":\"Ragionevolezza Operazione:\",\"w\":181,\"x\":16,\"y\":174,\"zone\":\"pag6_2_10\",\"zonepath\":\"[6,2,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_FXHEISJAJE\",\"page\":6,\"spuid\":\"FXHEISJAJE\",\"tabindex\":28,\"type\":\"Label\",\"w\":533,\"x\":267,\"y\":174,\"zone\":\"pag6_2_10\",\"zonepath\":\"[6,2,10]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RRAGIO\",\"page\":6,\"spuid\":\"QBTVZDKLCO\",\"tabindex\":13,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":880,\"y\":171,\"zone\":\"pag6_2_11\",\"zonepath\":\"[6,2,11]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"check\":\"file\",\"h\":20,\"maxlength\":3,\"name\":\"TIPO\",\"page\":6,\"picker\":true,\"spuid\":\"DJOWYRMDDC\",\"tabindex\":14,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":46,\"x\":200,\"y\":194,\"zone\":\"pag6_2_12\",\"zonepath\":\"[6,2,12]\",\"zoom\":\"stdz\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_OKFGBGYVWD\",\"page\":6,\"spuid\":\"OKFGBGYVWD\",\"tabindex\":23,\"type\":\"Label\",\"value\":\"Tipo di rischio:\",\"w\":181,\"x\":16,\"y\":198,\"zone\":\"pag6_2_12\",\"zonepath\":\"[6,2,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_GHHOMNKDDQ\",\"page\":6,\"spuid\":\"GHHOMNKDDQ\",\"tabindex\":29,\"type\":\"Label\",\"w\":533,\"x\":267,\"y\":198,\"zone\":\"pag6_2_12\",\"zonepath\":\"[6,2,12]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":20,\"maxlength\":4,\"name\":\"RTIPO\",\"page\":6,\"spuid\":\"RUWEXWJASG\",\"tabindex\":16,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":880,\"y\":195,\"zone\":\"pag6_2_13\",\"zonepath\":\"[6,2,13]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Rischio Globale\",\"h\":20,\"maxlength\":1,\"name\":\"RISGLOB\",\"page\":6,\"spuid\":\"SMVVFHCEHA\",\"tabindex\":17,\"type\":\"Combobox\",\"typevar\":\"character\",\"w\":396,\"x\":200,\"y\":219,\"zone\":\"pag6_2_14\",\"zonepath\":\"[6,2,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_JKZZQYXAFS\",\"page\":6,\"spuid\":\"JKZZQYXAFS\",\"tabindex\":37,\"type\":\"Label\",\"value\":\"Rischio Globale:\",\"w\":181,\"x\":16,\"y\":223,\"zone\":\"pag6_2_14\",\"zonepath\":\"[6,2,14]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Mitigazione\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Mitigazione del rischio\",\"h\":30,\"name\":\"Mitigazione\",\"page\":6,\"shrinkable\":true,\"spuid\":\"UFFFOVKFCE\",\"stretch\":true,\"tabindex\":2,\"title_caption\":\"Mitigazione del rischio\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":244,\"zone\":\"pag6_3\",\"zonepath\":\"[6,3]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Mitigazione (+\\/-)\",\"h\":20,\"maxlength\":5,\"name\":\"MITIG\",\"page\":6,\"spuid\":\"DOXBACRWUU\",\"tabindex\":18,\"type\":\"Textbox\",\"typevar\":\"numeric\",\"w\":40,\"x\":163,\"y\":248,\"zone\":\"pag6_3_1\",\"zonepath\":\"[6,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"comment\":\"Path Documentazione Mitigazione\",\"h\":20,\"maxlength\":100,\"name\":\"MITIGDOC\",\"page\":6,\"spuid\":\"OXGBDTWKSX\",\"tabindex\":19,\"type\":\"Textbox\",\"typevar\":\"character\",\"w\":608,\"x\":384,\"y\":248,\"zone\":\"pag6_3_1\",\"zonepath\":\"[6,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_VCBMHLXJMD\",\"page\":6,\"spuid\":\"VCBMHLXJMD\",\"tabindex\":34,\"type\":\"Label\",\"value\":\"Mitigazione (+\\/-):\",\"w\":150,\"x\":10,\"y\":252,\"zone\":\"pag6_3_1\",\"zonepath\":\"[6,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"align\":\"right\",\"h\":16,\"name\":\"label_PKJNNGBWFM\",\"page\":6,\"spuid\":\"PKJNNGBWFM\",\"tabindex\":35,\"type\":\"Label\",\"value\":\"Documentazione Mitigazione:\",\"w\":150,\"x\":232,\"y\":252,\"zone\":\"pag6_3_1\",\"zonepath\":\"[6,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":16,\"name\":\"label_NKPWKMDXUR\",\"page\":6,\"spuid\":\"NKPWKMDXUR\",\"tabindex\":36,\"type\":\"Label\",\"value\":\"%\",\"w\":19,\"x\":206,\"y\":252,\"zone\":\"pag6_3_1\",\"zonepath\":\"[6,3,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Categorie\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Categorie\",\"h\":346,\"name\":\"Categorie\",\"page\":6,\"shrinkable\":true,\"spuid\":\"YUNLBUHYXD\",\"stretch\":true,\"tabindex\":3,\"title_caption\":\"Categorie\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":275,\"zone\":\"pag6_4\",\"zonepath\":\"[6,4]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"autoexpand\":true,\"h\":316,\"name\":\"armt_xraziobo_agg\",\"page\":6,\"spuid\":\"RZOXJTRIYP\",\"tabindex\":15,\"type\":\"Iframe\",\"w\":821,\"x\":96,\"y\":288,\"zone\":\"pag6_4_1\",\"zonepath\":\"[6,4,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Intermediario7\",\"box_type\":\"auto_horizontal_section\",\"collapsible\":true,\"comment\":\"Intermediario\",\"h\":45,\"name\":\"Intermediario7\",\"page\":7,\"shrinkable\":true,\"spuid\":\"ZKIEGJMZVC\",\"stretch\":true,\"tabindex\":7,\"title_caption\":\"Intermediario\",\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":0,\"zone\":\"pag7_1\",\"zonepath\":\"[7,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_NHKIWAWZTC\",\"page\":7,\"spuid\":\"NHKIWAWZTC\",\"tabindex\":2,\"type\":\"Label\",\"w\":204,\"x\":12,\"y\":14,\"zone\":\"pag7_1_1\",\"zonepath\":\"[7,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_PFLBLQMSNX\",\"page\":7,\"spuid\":\"PFLBLQMSNX\",\"tabindex\":3,\"type\":\"Label\",\"w\":167,\"x\":233,\"y\":14,\"zone\":\"pag7_1_1\",\"zonepath\":\"[7,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_OSFCYNKIDE\",\"page\":7,\"spuid\":\"OSFCYNKIDE\",\"tabindex\":4,\"type\":\"Label\",\"w\":230,\"x\":414,\"y\":14,\"zone\":\"pag7_1_1\",\"zonepath\":\"[7,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_YXYNFREDGB\",\"page\":7,\"spuid\":\"YXYNFREDGB\",\"tabindex\":5,\"type\":\"Label\",\"w\":93,\"x\":659,\"y\":14,\"zone\":\"pag7_1_1\",\"zonepath\":\"[7,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":17,\"name\":\"label_FWBBOFFUEN\",\"page\":7,\"spuid\":\"FWBBOFFUEN\",\"tabindex\":6,\"type\":\"Label\",\"w\":116,\"x\":762,\"y\":14,\"zone\":\"pag7_1_1\",\"zonepath\":\"[7,1,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"bg_color\":\"transparent\",\"box_name\":\"Contante\",\"box_type\":\"horizontal_section\",\"collapsible\":true,\"comment\":\"Gestione Contante\",\"h\":720,\"name\":\"Contante\",\"page\":7,\"shrinkable\":true,\"spuid\":\"HFENTZBUDL\",\"stretch\":true,\"tabindex\":8,\"title_caption\":\"Gestione Contante\",\"titled\":true,\"type\":\"Box\",\"w\":1016,\"x\":0,\"y\":45,\"zone\":\"pag7_2\",\"zonepath\":\"[7,2]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    s = "{\"h\":702,\"name\":\"ardt_xrz_contante\",\"page\":7,\"spuid\":\"QMSPZAQYXJ\",\"tabindex\":1,\"type\":\"Iframe\",\"w\":749,\"x\":144,\"y\":54,\"zone\":\"pag7_2_1\",\"zonepath\":\"[7,2,1]\"}";
    ctrl = new org.json.JSONObject(s);
    items.put(ctrl);
    CPLib.addExtFieldsToJson(items,BO.extendedFields);
    SPLib.SetMimeType(status.response,"application/json");
    items.write(status.out);
  }
  void WriteFormPage(armt_frazioprovBO BO,ServletStatus status) {
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
     "<script src='armt_frazioprov?"+SPLib.TranslationParameter()+"="+status.context.GetLanguage()+"'>" +
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
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_frazioprov_query.js'>" +
       "</script>" +
      "");
    } else if (CPLib.eq(status.m_cClientMode,"new") || CPLib.eq(status.m_cClientMode,"edit")) {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_frazioprov_edit.js'>" +
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
      status.out.println("w_CONNESDOC=a[0];");
      status.out.println("w_IDBASE=a[1];");
      status.out.println("op_IDBASE=a[2];");
      status.out.println("w_CODINTER=a[3];");
      status.out.println("w_CODDIPE=a[4];");
      status.out.println("w_DESCCIT=a[5];");
      status.out.println("w_PROVINCIA=a[6];");
      status.out.println("w_CODCAB=a[7];");
      status.out.println("w_DATAOPE=a[8];");
      status.out.println("w_NUMPROG=a[9];");
      status.out.println("op_NUMPROG=a[10];");
      status.out.println("w_CDATOPE=a[11];");
      status.out.println("w_CDATAOPE=a[12];");
      status.out.println("w_ANNOOPE=a[13];");
      status.out.println("w_DATAREG=a[14];");
      status.out.println("w_CDATREG=a[15];");
      status.out.println("w_FLAGFRAZ=a[16];");
      status.out.println("w_COLLEG=a[17];");
      status.out.println("w_TIPOOPRAP=a[18];");
      status.out.println("w_idcauana=a[19];");
      status.out.println("w_CODANA=a[20];");
      status.out.println("w_CODVOC=a[21];");
      status.out.println("w_FLAGLIRE=a[22];");
      status.out.println("w_VALUTA=a[23];");
      status.out.println("w_FLAGCONT=a[24];");
      status.out.println("w_CAMBIO=a[25];");
      status.out.println("w_IMPIN=a[26];");
      status.out.println("w_IMPOUT=a[27];");
      status.out.println("w_RAPPORTO=a[28];");
      status.out.println("w_CONNESCLI=a[29];");
      status.out.println("w_PROQUOTA=a[30];");
      status.out.println("w_CONNESOPER=a[31];");
      status.out.println("w_TIPOLEG=a[32];");
      status.out.println("w_PAGASOGOP=a[33];");
      status.out.println("w_CONNESBEN=a[34];");
      status.out.println("w_CONNALTRO=a[35];");
      status.out.println("w_C_RAG=a[36];");
      status.out.println("w_C_CTA=a[37];");
      status.out.println("w_C_PRV=a[38];");
      status.out.println("w_C_CAP=a[39];");
      status.out.println("w_C_CAB=a[40];");
      status.out.println("w_C_IND=a[41];");
      status.out.println("w_C_STA=a[42];");
      status.out.println("w_TIPOINT2=a[43];");
      status.out.println("w_CODINT2=a[44];");
      status.out.println("w_DESCINTER=a[45];");
      status.out.println("w_PAESE=a[46];");
      status.out.println("w_C_RAPPORTO=a[47];");
      status.out.println("w_CODCAB2=a[48];");
      status.out.println("w_DESC2=a[49];");
      status.out.println("w_PROV2=a[50];");
      status.out.println("w_ZCPARTE=a[51];");
      status.out.println("w_TIPOINF=a[52];");
      status.out.println("w_SEGNO=a[53];");
      status.out.println("w_IDFILE=a[54];");
      status.out.println("w_MTCN=a[55];");
      status.out.println("w_TOTLIRE=a[56];");
      status.out.println("w_TOTCONT=a[57];");
      status.out.println("w_IDEREG=a[58];");
      status.out.println("w_FLAGRAP=a[59];");
      status.out.println("w_OPRAP=a[60];");
      status.out.println("w_RAPPORTBEN=a[61];");
      status.out.println("w_OPERATORE=a[62];");
      status.out.println("w_AUTOM=a[63];");
      status.out.println("w_FLAGRAP2=a[64];");
      status.out.println("w_PRGIMPFRZ=a[65];");
      status.out.println("op_PRGIMPFRZ=a[66];");
      status.out.println("w_IDBASE2=a[67];");
      status.out.println("w_NOPROT=a[68];");
      status.out.println("w_OPERAG=a[69];");
      status.out.println("w_RESPINS=a[70];");
      status.out.println("w_INFORM=a[71];");
      status.out.println("w_NATURA=a[72];");
      status.out.println("w_SCOPO=a[73];");
      status.out.println("w_SV58550=a[74];");
      status.out.println("w_SV58550MA=a[75];");
      status.out.println("w_DURAT=a[76];");
      status.out.println("w_AMMONT=a[77];");
      status.out.println("w_AREAGEO=a[78];");
      status.out.println("w_MODSVOL=a[79];");
      status.out.println("w_RAGIO=a[80];");
      status.out.println("w_TIPO=a[81];");
      status.out.println("w_DUCOLLEG=a[82];");
      status.out.println("w_ORACOLLEG=a[83];");
      status.out.println("w_IPCOLLEG=a[84];");
      status.out.println("w_MEZPAG=a[85];");
      status.out.println("w_PRESTAZ=a[86];");
      status.out.println("w_NOSARA=a[87];");
      status.out.println("w_RFREQ=a[88];");
      status.out.println("w_RIMP=a[89];");
      status.out.println("w_RAREA=a[90];");
      status.out.println("w_RCOMP=a[91];");
      status.out.println("w_RRAGIO=a[92];");
      status.out.println("w_RTIPO=a[93];");
      status.out.println("w_RISGLOB=a[94];");
      status.out.println("w_MITIG=a[95];");
      status.out.println("w_MITIGDOC=a[96];");
      status.out.println("w_DESPUNTO=a[97];");
      status.out.println("w_CODCLICON=a[98];");
      status.out.println("w_TIPATT=a[99];");
      status.out.println("w_VASP=a[100];");
      status.out.println("w_RIFIMP=a[101];");
      status.out.println("w_xRAGSOCDOC=a[102];");
      status.out.println("w_gIntemediario=a[103];");
      status.out.println("w_gChkDate=a[104];");
      status.out.println("w_gTipInter=a[105];");
      status.out.println("w_gSblocco=a[106];");
      status.out.println("w_gFlgWU=a[107];");
      status.out.println("w_gStatus=a[108];");
      status.out.println("w_gDataVaria=a[109];");
      status.out.println("w_gFlgDoc=a[110];");
      status.out.println("w_gFlgDTP=a[111];");
      status.out.println("w_gSeekAos=a[112];");
      status.out.println("w_gVerSim=a[113];");
      status.out.println("w_dataoggi=a[114];");
      status.out.println("w_filtro=a[115];");
      status.out.println("w_sEdit=a[116];");
      status.out.println("w_test=a[117];");
      status.out.println("w_datpaseuro=a[118];");
      status.out.println("w_tipope=a[119];");
      status.out.println("w_stringaflagrap2=a[120];");
      status.out.println("w_apporeg=a[121];");
      status.out.println("w_appolire=a[122];");
      status.out.println("w_xTOTLIRE=a[123];");
      status.out.println("w_xTOTCONT=a[124];");
      status.out.println("w_xdestipleg=a[125];");
      status.out.println("w_xragsocct=a[126];");
      status.out.println("w_xDescDipe=a[127];");
      status.out.println("w_descdiv=a[128];");
      status.out.println("w_valflg2=a[129];");
      status.out.println("w_xragint2=a[130];");
      status.out.println("w_errmsg=a[131];");
      status.out.println("w_CABINT=a[132];");
      status.out.println("w_xragsocper=a[133];");
      status.out.println("w_desccauana=a[134];");
      status.out.println("w_xragsocben=a[135];");
      status.out.println("w_xdesccausin=a[136];");
      status.out.println("w_xdescpaese2=a[137];");
      status.out.println("w_xdescrap=a[138];");
      status.out.println("w_xdes1=a[139];");
      status.out.println("w_xcodfisc=a[140];");
      status.out.println("w_xdciticon=a[141];");
      status.out.println("w_dessta=a[142];");
      status.out.println("w_xragsocalt=a[143];");
      status.out.println("w_xFLGITAEST=a[144];");
      status.out.println("w_CITINT=a[145];");
      status.out.println("w_CITDIP=a[146];");
      status.out.println("w_PROVDIP=a[147];");
      status.out.println("w_CABDIP=a[148];");
      status.out.println("w_PROVINT=a[149];;");
      status.out.println("w_DATAVALI=a[150];");
      status.out.println("w_DATARILASC=a[151];");
      status.out.println("w_xdescopeage=a[152];");
      status.out.println("w_xdescfreq=a[153];");
      status.out.println("w_xdescammo=a[154];");
      status.out.println("w_xdescareag=a[155];");
      status.out.println("w_xdescmodsvo=a[156];");
      status.out.println("w_xdescplauso=a[157];");
      status.out.println("w_xdesctipor=a[158];");
      status.out.println("op_codazi=a[159];");
      status.out.println("o_HGCXMHOHLD_expand=null;");
      status.out.println("o_HXTNEUCQUZ_expand=null;");
      status.out.println("m_cWv_ardt_xlientifrz=a[160];");
      status.out.println("m_cWv_ardt_sogopefrazprov=a[161];");
      status.out.println("m_cWv_ardt_xeneficfrz=a[162];");
      status.out.println("m_cWv_ardt_xerzistifrz=a[163];");
      status.out.println("m_cWv_ardt_docfrabo=a[164];");
      status.out.println("m_cWv_armt_xraziobo_agg=a[165];");
      status.out.println("m_cWv_ardt_xrz_contante=a[166];");
      status.out.println("if (Gt(a.length,167)) {");
      status.out.println("m_cErrorInChild='';");
      status.out.println("}");
      status.out.println("if (Gt(a.length,167)) {");
      status.out.println("o_filtro=w_filtro;");
      status.out.println("o_CODINTER=w_CODINTER;");
      status.out.println("o_CODDIPE=w_CODDIPE;");
      status.out.println("o_DATAOPE=w_DATAOPE;");
      status.out.println("o_CDATOPE=w_CDATOPE;");
      status.out.println("o_DATAREG=w_DATAREG;");
      status.out.println("o_TIPOOPRAP=w_TIPOOPRAP;");
      status.out.println("o_CODANA=w_CODANA;");
      status.out.println("o_CODVOC=w_CODVOC;");
      status.out.println("o_FLAGLIRE=w_FLAGLIRE;");
      status.out.println("o_appolire=w_appolire;");
      status.out.println("o_VALUTA=w_VALUTA;");
      status.out.println("o_FLAGCONT=w_FLAGCONT;");
      status.out.println("o_RAPPORTO=w_RAPPORTO;");
      status.out.println("o_CONNESCLI=w_CONNESCLI;");
      status.out.println("o_CONNESOPER=w_CONNESOPER;");
      status.out.println("o_CONNESBEN=w_CONNESBEN;");
      status.out.println("o_CONNALTRO=w_CONNALTRO;");
      status.out.println("o_C_CTA=w_C_CTA;");
      status.out.println("o_CODINT2=w_CODINT2;");
      status.out.println("o_SEGNO=w_SEGNO;");
      status.out.println("o_DURAT=w_DURAT;");
      status.out.println("o_AMMONT=w_AMMONT;");
      status.out.println("o_AREAGEO=w_AREAGEO;");
      status.out.println("o_MODSVOL=w_MODSVOL;");
      status.out.println("o_RAGIO=w_RAGIO;");
      status.out.println("o_TIPO=w_TIPO;");
      status.out.println("}");
      status.out.println("m_PrimaryKeys=['IDBASE'];");
      status.out.println("}");
      status.out.println(
       "</script>" +
      "");
    } else {
      status.out.println(
       "<script src='SPPrxy/"+m_cEntityUid+"/armt_frazioprov_proc.js'>" +
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
    status.themeWriter.WriteBody_Begin(782,status.m_cBodyAttributes,status.context.Translate("MSG_LOADING")+"...");
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
    f.SetParameter("Table","xraziobo");
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
  void RaiseLoadedEntity(armt_frazioprovBO BO,ServletStatus status) {
    RaiseEventLoadedEntity(status,SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cClientMode,"C",0,0)+"})","C",0,0));
  }
  void RaiseSavedEntity(armt_frazioprovBO BO,ServletStatus status) {
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
  void RaiseDeletedEntity(armt_frazioprovBO BO,ServletStatus status) {
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
  void RaiseDiscardedEntity(armt_frazioprovBO BO,ServletStatus status) {
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
  void WriteExitPage(armt_frazioprovBO BO,ServletStatus status,Forward f) {
    WriteExitPage(status,SPLib.ToJSValue("({IDBASE:"+SPLib.ToJSValue(BO.w_IDBASE,"C",10,0)+",action:"+SPLib.ToJSValue(status.m_cMode,"C",0,0)+"})","C",0,0), f);
  }
  void WriteExitPage(armt_frazioprovBO BO,ServletStatus status) {
    WriteExitPage(BO,status,Forward.Unforwarded);
  }
  protected void BringBackPage(armt_frazioprovBO BO,ServletStatus status) throws IOException {
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
    l_cJsUid = SPPrxycizer.proxycizedPath("arfn_calc_soggope.js");
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
     "<script src='SPPrxy/"+arfn_chktotalelire_cont.m_cEntityUid+"/arfn_chktotalelire_cont.js'>" +
     "</script>" +
    "");
    status.out.println(
     "<script src='SPPrxy/"+arfn_chktotalelire_fraz.m_cEntityUid+"/arfn_chktotalelire_fraz.js'>" +
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
     "<script src='SPPrxy/"+arrt_li_xraziobo.m_cEntityUid+"/arrt_li_xraziobo.js'>" +
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
      arfn_chktotalelire_cont.GetCallableNames(callable);
      arfn_chktotalelire_fraz.GetCallableNames(callable);
      arfn_read_tipoleg.GetCallableNames(callable);
      arrt_imp_frischio.GetCallableNames(callable);
      arrt_li_xraziobo.GetCallableNames(callable);
      arrt_val_benefic.GetCallableNames(callable);
      CPLib.AddToSet(callable,"LibreriaMit");
      CPLib.AddToSet(callable,"Utilities");
      CPLib.AddToSet(callable,"arfn_calc_soggope");
      CPLib.AddToSet(callable,"ardt_xlientifrz");
      CPLib.AddToSet(callable,"ardt_sogopefrazprov");
      CPLib.AddToSet(callable,"ardt_xeneficfrz");
      CPLib.AddToSet(callable,"ardt_xerzistifrz");
      CPLib.AddToSet(callable,"ardt_docfrabo");
      CPLib.AddToSet(callable,"armt_xraziobo_agg");
      CPLib.AddToSet(callable,"ardt_xrz_contante");
    } else {
      CPLib.AddStringsToSet(callable,m_CallableNames);
    }
  }
  void AppendCallableIDS(ServletStatus status,String sep) {
    PrintCallableIDS(GetCallableNames(),status,sep);
  }
  public String GetCheckVars(ServletStatus status,armt_frazioprovBO BO,String p_cUID) {
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
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gFlgWU),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gStatus),"C",4,0));
      hCreator.AddValue(CPLib.ToSQL(BO.w_gDataVaria,"D",8,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gFlgDoc),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(BO.w_gFlgDTP,"N",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gSeekAos),"C",1,0));
      hCreator.AddValue(CPLib.ToSQL(CPLib.Trim(BO.w_gVerSim),"C",1,0));
    } else if (CPLib.eq(p_cUID,"NNOUMHTLXJ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SDNFDOJDLP")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"XDPPAEWQFR")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SQVJLYRFKQ")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SRWWPHPCUB")) {
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
    } else if (CPLib.eq(p_cUID,"ODAYKSRECA")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"YVIKEGPYPM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"OGZBJVOVLN")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"MUTRCJYNJT")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"CRVLITCYRD")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"QEFXECTWSF")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"VMVNJQLPEN")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"ASETEUZIOS")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"UXDPSYOTRU")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"VZKBEOYRRK")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NVHOMNEASH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"XSVOIKCEKR")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"EOXCZYYEBY")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"CKJQULDXKW")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SXTYCPHBIM")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"QJSTZIPOQB")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"SFFFOYOWNH")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"NOBMPHKVTX")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    } else if (CPLib.eq(p_cUID,"DJOWYRMDDC")) {
      SPLib.FillLinkHash(hCreator,BO.GetLinkProperties(p_cUID),BO);
    }
    return GetEntityHash(p_cUID,status,hCreator);
  }
  public boolean CheckVars(ServletStatus status,armt_frazioprovBO BO) {
    boolean result = true;
    if (SPServlet.m_nEnableCheckHash) {
      String a = GetCheckVars(status,BO,m_cEntityUid);
      String b = status.m_CheckVars.optString("_");
      result = CPLib.eq(a,b);
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
      if (result &&  ! (CPLib.Empty(BO.w_OPERAG))) {
        a = GetCheckVars(status,BO,"QEFXECTWSF");
        b = status.m_CheckVars.optString("QEFXECTWSF");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_DURAT))) {
        a = GetCheckVars(status,BO,"VMVNJQLPEN");
        b = status.m_CheckVars.optString("VMVNJQLPEN");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_AMMONT))) {
        a = GetCheckVars(status,BO,"ASETEUZIOS");
        b = status.m_CheckVars.optString("ASETEUZIOS");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_AREAGEO))) {
        a = GetCheckVars(status,BO,"UXDPSYOTRU");
        b = status.m_CheckVars.optString("UXDPSYOTRU");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_MODSVOL))) {
        a = GetCheckVars(status,BO,"VZKBEOYRRK");
        b = status.m_CheckVars.optString("VZKBEOYRRK");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_RAGIO))) {
        a = GetCheckVars(status,BO,"NVHOMNEASH");
        b = status.m_CheckVars.optString("NVHOMNEASH");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_TIPO))) {
        a = GetCheckVars(status,BO,"XSVOIKCEKR");
        b = status.m_CheckVars.optString("XSVOIKCEKR");
        result = CPLib.eq(a,b);
      }
      if (result &&  ! (CPLib.Empty(BO.w_CONNESDOC))) {
        a = GetCheckVars(status,BO,"EOXCZYYEBY");
        b = status.m_CheckVars.optString("EOXCZYYEBY");
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
    }
    return result;
  }
}
